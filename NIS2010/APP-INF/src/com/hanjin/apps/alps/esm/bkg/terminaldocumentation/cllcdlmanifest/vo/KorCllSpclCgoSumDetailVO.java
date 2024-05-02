/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorCllSpclCgoSumDetailVO.java
*@FileTitle : KorCllSpclCgoSumDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.08.21 김승민 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

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
 * @author 김승민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class KorCllSpclCgoSumDetailVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<KorCllSpclCgoSumDetailVO> models = new ArrayList<KorCllSpclCgoSumDetailVO>();

    /* Column Info */
    private String localPcod20 = null;

    /* Column Info */
    private String gubunCd = null;

    /* Column Info */
    private String tsRf40 = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String tsPcod40 = null;

    /* Column Info */
    private String localRf40h = null;

    /* Column Info */
    private String tsPcod20 = null;

    /* Column Info */
    private String tsFr40 = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String tsDg40 = null;

    /* Column Info */
    private String localRf40 = null;

    /* Column Info */
    private String tsRf20 = null;

    /* Column Info */
    private String sumRf40h = null;

    /* Column Info */
    private String tsFr20 = null;

    /* Column Info */
    private String localPcod40 = null;

    /* Column Info */
    private String sumOt40 = null;

    /* Column Info */
    private String sumOt40h = null;

    /* Column Info */
    private String localRf20 = null;

    /* Column Info */
    private String sumRf40 = null;

    /* Column Info */
    private String tsOt20 = null;

    /* Column Info */
    private String sumFr20 = null;

    /* Column Info */
    private String gubunCd3 = null;

    /* Column Info */
    private String gubunCd2 = null;

    /* Column Info */
    private String sumFr40h = null;

    /* Column Info */
    private String sumDg20 = null;

    /* Column Info */
    private String localDg20 = null;

    /* Column Info */
    private String tsOt40 = null;

    /* Column Info */
    private String tsOt40h = null;

    /* Column Info */
    private String localDg40 = null;

    /* Column Info */
    private String localOt40 = null;

    /* Column Info */
    private String localOt40h = null;

    /* Column Info */
    private String orderGubun = null;

    /* Column Info */
    private String sumPcod40 = null;

    /* Column Info */
    private String localFr20 = null;

    /* Column Info */
    private String tsDg20 = null;

    /* Column Info */
    private String tsRf40h = null;

    /* Column Info */
    private String sumRf20 = null;

    /* Column Info */
    private String localFr40 = null;

    /* Column Info */
    private String sumDg40h = null;

    /* Column Info */
    private String tsDg40h = null;

    /* Column Info */
    private String localDg40h = null;

    /* Column Info */
    private String sumOt20 = null;

    /* Column Info */
    private String tsFr40h = null;

    /* Column Info */
    private String localFr40h = null;

    /* Column Info */
    private String localOt20 = null;

    /* Column Info */
    private String sumPcod20 = null;

    /* Column Info */
    private String sumFr40 = null;

    /* Column Info */
    private String sumDg40 = null;

    /* Column Info */
    private String localOt45 = null;

    /* Column Info */
    private String tsOt45 = null;

    /* Column Info */
    private String sumOt45 = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public KorCllSpclCgoSumDetailVO() {
    }

    public KorCllSpclCgoSumDetailVO(String ibflag, String pagerows, String gubunCd2, String gubunCd, String gubunCd3, String orderGubun, String localDg40, String localDg20, String localDg40h, String localRf40, String localRf20, String localRf40h, String localFr40, String localFr20, String localFr40h, String localOt40, String localOt20, String localOt40h, String localPcod40, String localPcod20, String tsDg40, String tsDg20, String tsDg40h, String tsRf40, String tsRf20, String tsRf40h, String tsFr40, String tsFr20, String tsFr40h, String tsOt40, String tsOt20, String tsOt40h, String tsPcod40, String tsPcod20, String sumDg40, String sumDg20, String sumDg40h, String sumRf40, String sumRf20, String sumRf40h, String sumFr40, String sumFr20, String sumFr40h, String sumOt40, String sumOt20, String sumOt40h, String sumPcod40, String sumPcod20, String localOt45, String tsOt45, String sumOt45) {
        this.localPcod20 = localPcod20;
        this.gubunCd = gubunCd;
        this.tsRf40 = tsRf40;
        this.pagerows = pagerows;
        this.tsPcod40 = tsPcod40;
        this.localRf40h = localRf40h;
        this.tsPcod20 = tsPcod20;
        this.tsFr40 = tsFr40;
        this.ibflag = ibflag;
        this.tsDg40 = tsDg40;
        this.localRf40 = localRf40;
        this.tsRf20 = tsRf20;
        this.sumRf40h = sumRf40h;
        this.tsFr20 = tsFr20;
        this.localPcod40 = localPcod40;
        this.sumOt40 = sumOt40;
        this.sumOt40h = sumOt40h;
        this.localRf20 = localRf20;
        this.sumRf40 = sumRf40;
        this.tsOt20 = tsOt20;
        this.sumFr20 = sumFr20;
        this.gubunCd3 = gubunCd3;
        this.gubunCd2 = gubunCd2;
        this.sumFr40h = sumFr40h;
        this.sumDg20 = sumDg20;
        this.localDg20 = localDg20;
        this.tsOt40 = tsOt40;
        this.tsOt40h = tsOt40h;
        this.localDg40 = localDg40;
        this.localOt40 = localOt40;
        this.localOt40h = localOt40h;
        this.orderGubun = orderGubun;
        this.sumPcod40 = sumPcod40;
        this.localFr20 = localFr20;
        this.tsDg20 = tsDg20;
        this.tsRf40h = tsRf40h;
        this.sumRf20 = sumRf20;
        this.localFr40 = localFr40;
        this.sumDg40h = sumDg40h;
        this.tsDg40h = tsDg40h;
        this.localDg40h = localDg40h;
        this.sumOt20 = sumOt20;
        this.tsFr40h = tsFr40h;
        this.localFr40h = localFr40h;
        this.localOt20 = localOt20;
        this.sumPcod20 = sumPcod20;
        this.sumFr40 = sumFr40;
        this.sumDg40 = sumDg40;
        this.localOt45 = localOt45;
        this.tsOt45 = tsOt45;
        this.sumOt45 = sumOt45;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("local_pcod_20", getLocalPcod20());
        this.hashColumns.put("gubun_cd", getGubunCd());
        this.hashColumns.put("ts_rf_40", getTsRf40());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ts_pcod_40", getTsPcod40());
        this.hashColumns.put("local_rf_40h", getLocalRf40h());
        this.hashColumns.put("ts_pcod_20", getTsPcod20());
        this.hashColumns.put("ts_fr_40", getTsFr40());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("ts_dg_40", getTsDg40());
        this.hashColumns.put("local_rf_40", getLocalRf40());
        this.hashColumns.put("ts_rf_20", getTsRf20());
        this.hashColumns.put("sum_rf_40h", getSumRf40h());
        this.hashColumns.put("ts_fr_20", getTsFr20());
        this.hashColumns.put("local_pcod_40", getLocalPcod40());
        this.hashColumns.put("sum_ot_40", getSumOt40());
        this.hashColumns.put("sum_ot_40h", getSumOt40h());
        this.hashColumns.put("local_rf_20", getLocalRf20());
        this.hashColumns.put("sum_rf_40", getSumRf40());
        this.hashColumns.put("ts_ot_20", getTsOt20());
        this.hashColumns.put("sum_fr_20", getSumFr20());
        this.hashColumns.put("gubun_cd3", getGubunCd3());
        this.hashColumns.put("gubun_cd2", getGubunCd2());
        this.hashColumns.put("sum_fr_40h", getSumFr40h());
        this.hashColumns.put("sum_dg_20", getSumDg20());
        this.hashColumns.put("local_dg_20", getLocalDg20());
        this.hashColumns.put("ts_ot_40", getTsOt40());
        this.hashColumns.put("ts_ot_40h", getTsOt40h());
        this.hashColumns.put("local_dg_40", getLocalDg40());
        this.hashColumns.put("local_ot_40", getLocalOt40());
        this.hashColumns.put("local_ot_40h", getLocalOt40h());
        this.hashColumns.put("order_gubun", getOrderGubun());
        this.hashColumns.put("sum_pcod_40", getSumPcod40());
        this.hashColumns.put("local_fr_20", getLocalFr20());
        this.hashColumns.put("ts_dg_20", getTsDg20());
        this.hashColumns.put("ts_rf_40h", getTsRf40h());
        this.hashColumns.put("sum_rf_20", getSumRf20());
        this.hashColumns.put("local_fr_40", getLocalFr40());
        this.hashColumns.put("sum_dg_40h", getSumDg40h());
        this.hashColumns.put("ts_dg_40h", getTsDg40h());
        this.hashColumns.put("local_dg_40h", getLocalDg40h());
        this.hashColumns.put("sum_ot_20", getSumOt20());
        this.hashColumns.put("ts_fr_40h", getTsFr40h());
        this.hashColumns.put("local_fr_40h", getLocalFr40h());
        this.hashColumns.put("local_ot_20", getLocalOt20());
        this.hashColumns.put("sum_pcod_20", getSumPcod20());
        this.hashColumns.put("sum_fr_40", getSumFr40());
        this.hashColumns.put("sum_dg_40", getSumDg40());
        this.hashColumns.put("local_ot_45", getLocalOt45());
        this.hashColumns.put("ts_ot_45", getTsOt45());
        this.hashColumns.put("sum_ot_45", getSumOt45());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("local_pcod_20", "localPcod20");
        this.hashFields.put("gubun_cd", "gubunCd");
        this.hashFields.put("ts_rf_40", "tsRf40");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ts_pcod_40", "tsPcod40");
        this.hashFields.put("local_rf_40h", "localRf40h");
        this.hashFields.put("ts_pcod_20", "tsPcod20");
        this.hashFields.put("ts_fr_40", "tsFr40");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("ts_dg_40", "tsDg40");
        this.hashFields.put("local_rf_40", "localRf40");
        this.hashFields.put("ts_rf_20", "tsRf20");
        this.hashFields.put("sum_rf_40h", "sumRf40h");
        this.hashFields.put("ts_fr_20", "tsFr20");
        this.hashFields.put("local_pcod_40", "localPcod40");
        this.hashFields.put("sum_ot_40", "sumOt40");
        this.hashFields.put("sum_ot_40h", "sumOt40h");
        this.hashFields.put("local_rf_20", "localRf20");
        this.hashFields.put("sum_rf_40", "sumRf40");
        this.hashFields.put("ts_ot_20", "tsOt20");
        this.hashFields.put("sum_fr_20", "sumFr20");
        this.hashFields.put("gubun_cd3", "gubunCd3");
        this.hashFields.put("gubun_cd2", "gubunCd2");
        this.hashFields.put("sum_fr_40h", "sumFr40h");
        this.hashFields.put("sum_dg_20", "sumDg20");
        this.hashFields.put("local_dg_20", "localDg20");
        this.hashFields.put("ts_ot_40", "tsOt40");
        this.hashFields.put("ts_ot_40h", "tsOt40h");
        this.hashFields.put("local_dg_40", "localDg40");
        this.hashFields.put("local_ot_40", "localOt40");
        this.hashFields.put("local_ot_40h", "localOt40h");
        this.hashFields.put("order_gubun", "orderGubun");
        this.hashFields.put("sum_pcod_40", "sumPcod40");
        this.hashFields.put("local_fr_20", "localFr20");
        this.hashFields.put("ts_dg_20", "tsDg20");
        this.hashFields.put("ts_rf_40h", "tsRf40h");
        this.hashFields.put("sum_rf_20", "sumRf20");
        this.hashFields.put("local_fr_40", "localFr40");
        this.hashFields.put("sum_dg_40h", "sumDg40h");
        this.hashFields.put("ts_dg_40h", "tsDg40h");
        this.hashFields.put("local_dg_40h", "localDg40h");
        this.hashFields.put("sum_ot_20", "sumOt20");
        this.hashFields.put("ts_fr_40h", "tsFr40h");
        this.hashFields.put("local_fr_40h", "localFr40h");
        this.hashFields.put("local_ot_20", "localOt20");
        this.hashFields.put("sum_pcod_20", "sumPcod20");
        this.hashFields.put("sum_fr_40", "sumFr40");
        this.hashFields.put("sum_dg_40", "sumDg40");
        this.hashFields.put("local_ot_45", "localOt45");
        this.hashFields.put("ts_ot_45", "tsOt45");
        this.hashFields.put("sum_ot_45", "sumOt45");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return localPcod20
	 */
    public String getLocalPcod20() {
        return this.localPcod20;
    }

    /**
	 * Column Info
	 * @return gubunCd
	 */
    public String getGubunCd() {
        return this.gubunCd;
    }

    /**
	 * Column Info
	 * @return tsRf40
	 */
    public String getTsRf40() {
        return this.tsRf40;
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
	 * @return tsPcod40
	 */
    public String getTsPcod40() {
        return this.tsPcod40;
    }

    /**
	 * Column Info
	 * @return localRf40h
	 */
    public String getLocalRf40h() {
        return this.localRf40h;
    }

    /**
	 * Column Info
	 * @return tsPcod20
	 */
    public String getTsPcod20() {
        return this.tsPcod20;
    }

    /**
	 * Column Info
	 * @return tsFr40
	 */
    public String getTsFr40() {
        return this.tsFr40;
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
	 * @return tsDg40
	 */
    public String getTsDg40() {
        return this.tsDg40;
    }

    /**
	 * Column Info
	 * @return localRf40
	 */
    public String getLocalRf40() {
        return this.localRf40;
    }

    /**
	 * Column Info
	 * @return tsRf20
	 */
    public String getTsRf20() {
        return this.tsRf20;
    }

    /**
	 * Column Info
	 * @return sumRf40h
	 */
    public String getSumRf40h() {
        return this.sumRf40h;
    }

    /**
	 * Column Info
	 * @return tsFr20
	 */
    public String getTsFr20() {
        return this.tsFr20;
    }

    /**
	 * Column Info
	 * @return localPcod40
	 */
    public String getLocalPcod40() {
        return this.localPcod40;
    }

    /**
	 * Column Info
	 * @return sumOt40
	 */
    public String getSumOt40() {
        return this.sumOt40;
    }

    /**
	 * Column Info
	 * @return sumOt40h
	 */
    public String getSumOt40h() {
        return this.sumOt40h;
    }

    /**
	 * Column Info
	 * @return localRf20
	 */
    public String getLocalRf20() {
        return this.localRf20;
    }

    /**
	 * Column Info
	 * @return sumRf40
	 */
    public String getSumRf40() {
        return this.sumRf40;
    }

    /**
	 * Column Info
	 * @return tsOt20
	 */
    public String getTsOt20() {
        return this.tsOt20;
    }

    /**
	 * Column Info
	 * @return sumFr20
	 */
    public String getSumFr20() {
        return this.sumFr20;
    }

    /**
	 * Column Info
	 * @return gubunCd3
	 */
    public String getGubunCd3() {
        return this.gubunCd3;
    }

    /**
	 * Column Info
	 * @return gubunCd2
	 */
    public String getGubunCd2() {
        return this.gubunCd2;
    }

    /**
	 * Column Info
	 * @return sumFr40h
	 */
    public String getSumFr40h() {
        return this.sumFr40h;
    }

    /**
	 * Column Info
	 * @return sumDg20
	 */
    public String getSumDg20() {
        return this.sumDg20;
    }

    /**
	 * Column Info
	 * @return localDg20
	 */
    public String getLocalDg20() {
        return this.localDg20;
    }

    /**
	 * Column Info
	 * @return tsOt40
	 */
    public String getTsOt40() {
        return this.tsOt40;
    }

    /**
	 * Column Info
	 * @return tsOt40h
	 */
    public String getTsOt40h() {
        return this.tsOt40h;
    }

    /**
	 * Column Info
	 * @return localDg40
	 */
    public String getLocalDg40() {
        return this.localDg40;
    }

    /**
	 * Column Info
	 * @return localOt40
	 */
    public String getLocalOt40() {
        return this.localOt40;
    }

    /**
	 * Column Info
	 * @return localOt40h
	 */
    public String getLocalOt40h() {
        return this.localOt40h;
    }

    /**
	 * Column Info
	 * @return orderGubun
	 */
    public String getOrderGubun() {
        return this.orderGubun;
    }

    /**
	 * Column Info
	 * @return sumPcod40
	 */
    public String getSumPcod40() {
        return this.sumPcod40;
    }

    /**
	 * Column Info
	 * @return localFr20
	 */
    public String getLocalFr20() {
        return this.localFr20;
    }

    /**
	 * Column Info
	 * @return tsDg20
	 */
    public String getTsDg20() {
        return this.tsDg20;
    }

    /**
	 * Column Info
	 * @return tsRf40h
	 */
    public String getTsRf40h() {
        return this.tsRf40h;
    }

    /**
	 * Column Info
	 * @return sumRf20
	 */
    public String getSumRf20() {
        return this.sumRf20;
    }

    /**
	 * Column Info
	 * @return localFr40
	 */
    public String getLocalFr40() {
        return this.localFr40;
    }

    /**
	 * Column Info
	 * @return sumDg40h
	 */
    public String getSumDg40h() {
        return this.sumDg40h;
    }

    /**
	 * Column Info
	 * @return tsDg40h
	 */
    public String getTsDg40h() {
        return this.tsDg40h;
    }

    /**
	 * Column Info
	 * @return localDg40h
	 */
    public String getLocalDg40h() {
        return this.localDg40h;
    }

    /**
	 * Column Info
	 * @return sumOt20
	 */
    public String getSumOt20() {
        return this.sumOt20;
    }

    /**
	 * Column Info
	 * @return tsFr40h
	 */
    public String getTsFr40h() {
        return this.tsFr40h;
    }

    /**
	 * Column Info
	 * @return localFr40h
	 */
    public String getLocalFr40h() {
        return this.localFr40h;
    }

    /**
	 * Column Info
	 * @return localOt20
	 */
    public String getLocalOt20() {
        return this.localOt20;
    }

    /**
	 * Column Info
	 * @return sumPcod20
	 */
    public String getSumPcod20() {
        return this.sumPcod20;
    }

    /**
	 * Column Info
	 * @return sumFr40
	 */
    public String getSumFr40() {
        return this.sumFr40;
    }

    /**
	 * Column Info
	 * @return sumDg40
	 */
    public String getSumDg40() {
        return this.sumDg40;
    }

    /**
	 * Column Info
	 * @param localPcod20
	 */
    public void setLocalPcod20(String localPcod20) {
        this.localPcod20 = localPcod20;
    }

    /**
	 * Column Info
	 * @param gubunCd
	 */
    public void setGubunCd(String gubunCd) {
        this.gubunCd = gubunCd;
    }

    /**
	 * Column Info
	 * @param tsRf40
	 */
    public void setTsRf40(String tsRf40) {
        this.tsRf40 = tsRf40;
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
	 * @param tsPcod40
	 */
    public void setTsPcod40(String tsPcod40) {
        this.tsPcod40 = tsPcod40;
    }

    /**
	 * Column Info
	 * @param localRf40h
	 */
    public void setLocalRf40h(String localRf40h) {
        this.localRf40h = localRf40h;
    }

    /**
	 * Column Info
	 * @param tsPcod20
	 */
    public void setTsPcod20(String tsPcod20) {
        this.tsPcod20 = tsPcod20;
    }

    /**
	 * Column Info
	 * @param tsFr40
	 */
    public void setTsFr40(String tsFr40) {
        this.tsFr40 = tsFr40;
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
	 * @param tsDg40
	 */
    public void setTsDg40(String tsDg40) {
        this.tsDg40 = tsDg40;
    }

    /**
	 * Column Info
	 * @param localRf40
	 */
    public void setLocalRf40(String localRf40) {
        this.localRf40 = localRf40;
    }

    /**
	 * Column Info
	 * @param tsRf20
	 */
    public void setTsRf20(String tsRf20) {
        this.tsRf20 = tsRf20;
    }

    /**
	 * Column Info
	 * @param sumRf40h
	 */
    public void setSumRf40h(String sumRf40h) {
        this.sumRf40h = sumRf40h;
    }

    /**
	 * Column Info
	 * @param tsFr20
	 */
    public void setTsFr20(String tsFr20) {
        this.tsFr20 = tsFr20;
    }

    /**
	 * Column Info
	 * @param localPcod40
	 */
    public void setLocalPcod40(String localPcod40) {
        this.localPcod40 = localPcod40;
    }

    /**
	 * Column Info
	 * @param sumOt40
	 */
    public void setSumOt40(String sumOt40) {
        this.sumOt40 = sumOt40;
    }

    /**
	 * Column Info
	 * @param sumOt40h
	 */
    public void setSumOt40h(String sumOt40h) {
        this.sumOt40h = sumOt40h;
    }

    /**
	 * Column Info
	 * @param localRf20
	 */
    public void setLocalRf20(String localRf20) {
        this.localRf20 = localRf20;
    }

    /**
	 * Column Info
	 * @param sumRf40
	 */
    public void setSumRf40(String sumRf40) {
        this.sumRf40 = sumRf40;
    }

    /**
	 * Column Info
	 * @param tsOt20
	 */
    public void setTsOt20(String tsOt20) {
        this.tsOt20 = tsOt20;
    }

    /**
	 * Column Info
	 * @param sumFr20
	 */
    public void setSumFr20(String sumFr20) {
        this.sumFr20 = sumFr20;
    }

    /**
	 * Column Info
	 * @param gubunCd3
	 */
    public void setGubunCd3(String gubunCd3) {
        this.gubunCd3 = gubunCd3;
    }

    /**
	 * Column Info
	 * @param gubunCd2
	 */
    public void setGubunCd2(String gubunCd2) {
        this.gubunCd2 = gubunCd2;
    }

    /**
	 * Column Info
	 * @param sumFr40h
	 */
    public void setSumFr40h(String sumFr40h) {
        this.sumFr40h = sumFr40h;
    }

    /**
	 * Column Info
	 * @param sumDg20
	 */
    public void setSumDg20(String sumDg20) {
        this.sumDg20 = sumDg20;
    }

    /**
	 * Column Info
	 * @param localDg20
	 */
    public void setLocalDg20(String localDg20) {
        this.localDg20 = localDg20;
    }

    /**
	 * Column Info
	 * @param tsOt40
	 */
    public void setTsOt40(String tsOt40) {
        this.tsOt40 = tsOt40;
    }

    /**
	 * Column Info
	 * @param tsOt40h
	 */
    public void setTsOt40h(String tsOt40h) {
        this.tsOt40h = tsOt40h;
    }

    /**
	 * Column Info
	 * @param localDg40
	 */
    public void setLocalDg40(String localDg40) {
        this.localDg40 = localDg40;
    }

    /**
	 * Column Info
	 * @param localOt40
	 */
    public void setLocalOt40(String localOt40) {
        this.localOt40 = localOt40;
    }

    /**
	 * Column Info
	 * @param localOt40h
	 */
    public void setLocalOt40h(String localOt40h) {
        this.localOt40h = localOt40h;
    }

    /**
	 * Column Info
	 * @param orderGubun
	 */
    public void setOrderGubun(String orderGubun) {
        this.orderGubun = orderGubun;
    }

    /**
	 * Column Info
	 * @param sumPcod40
	 */
    public void setSumPcod40(String sumPcod40) {
        this.sumPcod40 = sumPcod40;
    }

    /**
	 * Column Info
	 * @param localFr20
	 */
    public void setLocalFr20(String localFr20) {
        this.localFr20 = localFr20;
    }

    /**
	 * Column Info
	 * @param tsDg20
	 */
    public void setTsDg20(String tsDg20) {
        this.tsDg20 = tsDg20;
    }

    /**
	 * Column Info
	 * @param tsRf40h
	 */
    public void setTsRf40h(String tsRf40h) {
        this.tsRf40h = tsRf40h;
    }

    /**
	 * Column Info
	 * @param sumRf20
	 */
    public void setSumRf20(String sumRf20) {
        this.sumRf20 = sumRf20;
    }

    /**
	 * Column Info
	 * @param localFr40
	 */
    public void setLocalFr40(String localFr40) {
        this.localFr40 = localFr40;
    }

    /**
	 * Column Info
	 * @param sumDg40h
	 */
    public void setSumDg40h(String sumDg40h) {
        this.sumDg40h = sumDg40h;
    }

    /**
	 * Column Info
	 * @param tsDg40h
	 */
    public void setTsDg40h(String tsDg40h) {
        this.tsDg40h = tsDg40h;
    }

    /**
	 * Column Info
	 * @param localDg40h
	 */
    public void setLocalDg40h(String localDg40h) {
        this.localDg40h = localDg40h;
    }

    /**
	 * Column Info
	 * @param sumOt20
	 */
    public void setSumOt20(String sumOt20) {
        this.sumOt20 = sumOt20;
    }

    /**
	 * Column Info
	 * @param tsFr40h
	 */
    public void setTsFr40h(String tsFr40h) {
        this.tsFr40h = tsFr40h;
    }

    /**
	 * Column Info
	 * @param localFr40h
	 */
    public void setLocalFr40h(String localFr40h) {
        this.localFr40h = localFr40h;
    }

    /**
	 * Column Info
	 * @param localOt20
	 */
    public void setLocalOt20(String localOt20) {
        this.localOt20 = localOt20;
    }

    /**
	 * Column Info
	 * @param sumPcod20
	 */
    public void setSumPcod20(String sumPcod20) {
        this.sumPcod20 = sumPcod20;
    }

    /**
	 * Column Info
	 * @param sumFr40
	 */
    public void setSumFr40(String sumFr40) {
        this.sumFr40 = sumFr40;
    }

    /**
	 * Column Info
	 * @param sumDg40
	 */
    public void setSumDg40(String sumDg40) {
        this.sumDg40 = sumDg40;
    }

    public void setLocalOt45(String localOt45) {
        this.localOt45 = localOt45;
    }

    public String getLocalOt45() {
        return this.localOt45;
    }

    public void setTsOt45(String tsOt45) {
        this.tsOt45 = tsOt45;
    }

    public String getTsOt45() {
        return this.tsOt45;
    }

    public void setSumOt45(String sumOt45) {
        this.sumOt45 = sumOt45;
    }

    public String getSumOt45() {
        return this.sumOt45;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setLocalPcod20(JSPUtil.getParameter(request, "local_pcod_20", ""));
        setGubunCd(JSPUtil.getParameter(request, "gubun_cd", ""));
        setTsRf40(JSPUtil.getParameter(request, "ts_rf_40", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setTsPcod40(JSPUtil.getParameter(request, "ts_pcod_40", ""));
        setLocalRf40h(JSPUtil.getParameter(request, "local_rf_40h", ""));
        setTsPcod20(JSPUtil.getParameter(request, "ts_pcod_20", ""));
        setTsFr40(JSPUtil.getParameter(request, "ts_fr_40", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setTsDg40(JSPUtil.getParameter(request, "ts_dg_40", ""));
        setLocalRf40(JSPUtil.getParameter(request, "local_rf_40", ""));
        setTsRf20(JSPUtil.getParameter(request, "ts_rf_20", ""));
        setSumRf40h(JSPUtil.getParameter(request, "sum_rf_40h", ""));
        setTsFr20(JSPUtil.getParameter(request, "ts_fr_20", ""));
        setLocalPcod40(JSPUtil.getParameter(request, "local_pcod_40", ""));
        setSumOt40(JSPUtil.getParameter(request, "sum_ot_40", ""));
        setSumOt40h(JSPUtil.getParameter(request, "sum_ot_40h", ""));
        setLocalRf20(JSPUtil.getParameter(request, "local_rf_20", ""));
        setSumRf40(JSPUtil.getParameter(request, "sum_rf_40", ""));
        setTsOt20(JSPUtil.getParameter(request, "ts_ot_20", ""));
        setSumFr20(JSPUtil.getParameter(request, "sum_fr_20", ""));
        setGubunCd3(JSPUtil.getParameter(request, "gubun_cd3", ""));
        setGubunCd2(JSPUtil.getParameter(request, "gubun_cd2", ""));
        setSumFr40h(JSPUtil.getParameter(request, "sum_fr_40h", ""));
        setSumDg20(JSPUtil.getParameter(request, "sum_dg_20", ""));
        setLocalDg20(JSPUtil.getParameter(request, "local_dg_20", ""));
        setTsOt40(JSPUtil.getParameter(request, "ts_ot_40", ""));
        setTsOt40h(JSPUtil.getParameter(request, "ts_ot_40h", ""));
        setLocalDg40(JSPUtil.getParameter(request, "local_dg_40", ""));
        setLocalOt40(JSPUtil.getParameter(request, "local_ot_40", ""));
        setLocalOt40h(JSPUtil.getParameter(request, "local_ot_40h", ""));
        setOrderGubun(JSPUtil.getParameter(request, "order_gubun", ""));
        setSumPcod40(JSPUtil.getParameter(request, "sum_pcod_40", ""));
        setLocalFr20(JSPUtil.getParameter(request, "local_fr_20", ""));
        setTsDg20(JSPUtil.getParameter(request, "ts_dg_20", ""));
        setTsRf40h(JSPUtil.getParameter(request, "ts_rf_40h", ""));
        setSumRf20(JSPUtil.getParameter(request, "sum_rf_20", ""));
        setLocalFr40(JSPUtil.getParameter(request, "local_fr_40", ""));
        setSumDg40h(JSPUtil.getParameter(request, "sum_dg_40h", ""));
        setTsDg40h(JSPUtil.getParameter(request, "ts_dg_40h", ""));
        setLocalDg40h(JSPUtil.getParameter(request, "local_dg_40h", ""));
        setSumOt20(JSPUtil.getParameter(request, "sum_ot_20", ""));
        setTsFr40h(JSPUtil.getParameter(request, "ts_fr_40h", ""));
        setLocalFr40h(JSPUtil.getParameter(request, "local_fr_40h", ""));
        setLocalOt20(JSPUtil.getParameter(request, "local_ot_20", ""));
        setSumPcod20(JSPUtil.getParameter(request, "sum_pcod_20", ""));
        setSumFr40(JSPUtil.getParameter(request, "sum_fr_40", ""));
        setSumDg40(JSPUtil.getParameter(request, "sum_dg_40", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorCllSpclCgoSumDetailVO[]
	 */
    public KorCllSpclCgoSumDetailVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorCllSpclCgoSumDetailVO[]
	 */
    public KorCllSpclCgoSumDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        KorCllSpclCgoSumDetailVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] localPcod20 = (JSPUtil.getParameter(request, prefix + "local_pcod_20", length));
            String[] gubunCd = (JSPUtil.getParameter(request, prefix + "gubun_cd", length));
            String[] tsRf40 = (JSPUtil.getParameter(request, prefix + "ts_rf_40", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] tsPcod40 = (JSPUtil.getParameter(request, prefix + "ts_pcod_40", length));
            String[] localRf40h = (JSPUtil.getParameter(request, prefix + "local_rf_40h", length));
            String[] tsPcod20 = (JSPUtil.getParameter(request, prefix + "ts_pcod_20", length));
            String[] tsFr40 = (JSPUtil.getParameter(request, prefix + "ts_fr_40", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] tsDg40 = (JSPUtil.getParameter(request, prefix + "ts_dg_40", length));
            String[] localRf40 = (JSPUtil.getParameter(request, prefix + "local_rf_40", length));
            String[] tsRf20 = (JSPUtil.getParameter(request, prefix + "ts_rf_20", length));
            String[] sumRf40h = (JSPUtil.getParameter(request, prefix + "sum_rf_40h", length));
            String[] tsFr20 = (JSPUtil.getParameter(request, prefix + "ts_fr_20", length));
            String[] localPcod40 = (JSPUtil.getParameter(request, prefix + "local_pcod_40", length));
            String[] sumOt40 = (JSPUtil.getParameter(request, prefix + "sum_ot_40", length));
            String[] sumOt40h = (JSPUtil.getParameter(request, prefix + "sum_ot_40h", length));
            String[] localRf20 = (JSPUtil.getParameter(request, prefix + "local_rf_20", length));
            String[] sumRf40 = (JSPUtil.getParameter(request, prefix + "sum_rf_40", length));
            String[] tsOt20 = (JSPUtil.getParameter(request, prefix + "ts_ot_20", length));
            String[] sumFr20 = (JSPUtil.getParameter(request, prefix + "sum_fr_20", length));
            String[] gubunCd3 = (JSPUtil.getParameter(request, prefix + "gubun_cd3", length));
            String[] gubunCd2 = (JSPUtil.getParameter(request, prefix + "gubun_cd2", length));
            String[] sumFr40h = (JSPUtil.getParameter(request, prefix + "sum_fr_40h", length));
            String[] sumDg20 = (JSPUtil.getParameter(request, prefix + "sum_dg_20", length));
            String[] localDg20 = (JSPUtil.getParameter(request, prefix + "local_dg_20", length));
            String[] tsOt40 = (JSPUtil.getParameter(request, prefix + "ts_ot_40", length));
            String[] tsOt40h = (JSPUtil.getParameter(request, prefix + "ts_ot_40h", length));
            String[] localDg40 = (JSPUtil.getParameter(request, prefix + "local_dg_40", length));
            String[] localOt40 = (JSPUtil.getParameter(request, prefix + "local_ot_40", length));
            String[] localOt40h = (JSPUtil.getParameter(request, prefix + "local_ot_40h", length));
            String[] orderGubun = (JSPUtil.getParameter(request, prefix + "order_gubun", length));
            String[] sumPcod40 = (JSPUtil.getParameter(request, prefix + "sum_pcod_40", length));
            String[] localFr20 = (JSPUtil.getParameter(request, prefix + "local_fr_20", length));
            String[] tsDg20 = (JSPUtil.getParameter(request, prefix + "ts_dg_20", length));
            String[] tsRf40h = (JSPUtil.getParameter(request, prefix + "ts_rf_40h", length));
            String[] sumRf20 = (JSPUtil.getParameter(request, prefix + "sum_rf_20", length));
            String[] localFr40 = (JSPUtil.getParameter(request, prefix + "local_fr_40", length));
            String[] sumDg40h = (JSPUtil.getParameter(request, prefix + "sum_dg_40h", length));
            String[] tsDg40h = (JSPUtil.getParameter(request, prefix + "ts_dg_40h", length));
            String[] localDg40h = (JSPUtil.getParameter(request, prefix + "local_dg_40h", length));
            String[] sumOt20 = (JSPUtil.getParameter(request, prefix + "sum_ot_20", length));
            String[] tsFr40h = (JSPUtil.getParameter(request, prefix + "ts_fr_40h", length));
            String[] localFr40h = (JSPUtil.getParameter(request, prefix + "local_fr_40h", length));
            String[] localOt20 = (JSPUtil.getParameter(request, prefix + "local_ot_20", length));
            String[] sumPcod20 = (JSPUtil.getParameter(request, prefix + "sum_pcod_20", length));
            String[] sumFr40 = (JSPUtil.getParameter(request, prefix + "sum_fr_40", length));
            String[] sumDg40 = (JSPUtil.getParameter(request, prefix + "sum_dg_40", length));
            String[] localOt45 = (JSPUtil.getParameter(request, prefix + "local_ot_45", length));
	    	String[] tsOt45 = (JSPUtil.getParameter(request, prefix + "ts_ot_45", length));
	    	String[] sumOt45 = (JSPUtil.getParameter(request, prefix + "sum_ot_45", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new KorCllSpclCgoSumDetailVO();
                if (localPcod20[i] != null)
                    model.setLocalPcod20(localPcod20[i]);
                if (gubunCd[i] != null)
                    model.setGubunCd(gubunCd[i]);
                if (tsRf40[i] != null)
                    model.setTsRf40(tsRf40[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (tsPcod40[i] != null)
                    model.setTsPcod40(tsPcod40[i]);
                if (localRf40h[i] != null)
                    model.setLocalRf40h(localRf40h[i]);
                if (tsPcod20[i] != null)
                    model.setTsPcod20(tsPcod20[i]);
                if (tsFr40[i] != null)
                    model.setTsFr40(tsFr40[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (tsDg40[i] != null)
                    model.setTsDg40(tsDg40[i]);
                if (localRf40[i] != null)
                    model.setLocalRf40(localRf40[i]);
                if (tsRf20[i] != null)
                    model.setTsRf20(tsRf20[i]);
                if (sumRf40h[i] != null)
                    model.setSumRf40h(sumRf40h[i]);
                if (tsFr20[i] != null)
                    model.setTsFr20(tsFr20[i]);
                if (localPcod40[i] != null)
                    model.setLocalPcod40(localPcod40[i]);
                if (sumOt40[i] != null)
                    model.setSumOt40(sumOt40[i]);
                if (sumOt40h[i] != null)
                    model.setSumOt40h(sumOt40h[i]);
                if (localRf20[i] != null)
                    model.setLocalRf20(localRf20[i]);
                if (sumRf40[i] != null)
                    model.setSumRf40(sumRf40[i]);
                if (tsOt20[i] != null)
                    model.setTsOt20(tsOt20[i]);
                if (sumFr20[i] != null)
                    model.setSumFr20(sumFr20[i]);
                if (gubunCd3[i] != null)
                    model.setGubunCd3(gubunCd3[i]);
                if (gubunCd2[i] != null)
                    model.setGubunCd2(gubunCd2[i]);
                if (sumFr40h[i] != null)
                    model.setSumFr40h(sumFr40h[i]);
                if (sumDg20[i] != null)
                    model.setSumDg20(sumDg20[i]);
                if (localDg20[i] != null)
                    model.setLocalDg20(localDg20[i]);
                if (tsOt40[i] != null)
                    model.setTsOt40(tsOt40[i]);
                if (tsOt40h[i] != null)
                    model.setTsOt40h(tsOt40h[i]);
                if (localDg40[i] != null)
                    model.setLocalDg40(localDg40[i]);
                if (localOt40[i] != null)
                    model.setLocalOt40(localOt40[i]);
                if (localOt40h[i] != null)
                    model.setLocalOt40h(localOt40h[i]);
                if (orderGubun[i] != null)
                    model.setOrderGubun(orderGubun[i]);
                if (sumPcod40[i] != null)
                    model.setSumPcod40(sumPcod40[i]);
                if (localFr20[i] != null)
                    model.setLocalFr20(localFr20[i]);
                if (tsDg20[i] != null)
                    model.setTsDg20(tsDg20[i]);
                if (tsRf40h[i] != null)
                    model.setTsRf40h(tsRf40h[i]);
                if (sumRf20[i] != null)
                    model.setSumRf20(sumRf20[i]);
                if (localFr40[i] != null)
                    model.setLocalFr40(localFr40[i]);
                if (sumDg40h[i] != null)
                    model.setSumDg40h(sumDg40h[i]);
                if (tsDg40h[i] != null)
                    model.setTsDg40h(tsDg40h[i]);
                if (localDg40h[i] != null)
                    model.setLocalDg40h(localDg40h[i]);
                if (sumOt20[i] != null)
                    model.setSumOt20(sumOt20[i]);
                if (tsFr40h[i] != null)
                    model.setTsFr40h(tsFr40h[i]);
                if (localFr40h[i] != null)
                    model.setLocalFr40h(localFr40h[i]);
                if (localOt20[i] != null)
                    model.setLocalOt20(localOt20[i]);
                if (sumPcod20[i] != null)
                    model.setSumPcod20(sumPcod20[i]);
                if (sumFr40[i] != null)
                    model.setSumFr40(sumFr40[i]);
                if (sumDg40[i] != null)
                    model.setSumDg40(sumDg40[i]);
                if (localOt45[i] != null) 
		    		model.setLocalOt45(localOt45[i]);
				if (tsOt45[i] != null) 
		    		model.setTsOt45(tsOt45[i]);
				if (sumOt45[i] != null) 
		    		model.setSumOt45(sumOt45[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getKorCllSpclCgoSumDetailVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return KorCllSpclCgoSumDetailVO[]
	 */
    public KorCllSpclCgoSumDetailVO[] getKorCllSpclCgoSumDetailVOs() {
        KorCllSpclCgoSumDetailVO[] vos = (KorCllSpclCgoSumDetailVO[]) models.toArray(new KorCllSpclCgoSumDetailVO[models.size()]);
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
        this.localPcod20 = this.localPcod20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.gubunCd = this.gubunCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tsRf40 = this.tsRf40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tsPcod40 = this.tsPcod40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.localRf40h = this.localRf40h.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tsPcod20 = this.tsPcod20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tsFr40 = this.tsFr40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tsDg40 = this.tsDg40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.localRf40 = this.localRf40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tsRf20 = this.tsRf20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sumRf40h = this.sumRf40h.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tsFr20 = this.tsFr20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.localPcod40 = this.localPcod40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sumOt40 = this.sumOt40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sumOt40h = this.sumOt40h.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.localRf20 = this.localRf20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sumRf40 = this.sumRf40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tsOt20 = this.tsOt20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sumFr20 = this.sumFr20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.gubunCd3 = this.gubunCd3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.gubunCd2 = this.gubunCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sumFr40h = this.sumFr40h.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sumDg20 = this.sumDg20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.localDg20 = this.localDg20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tsOt40 = this.tsOt40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tsOt40h = this.tsOt40h.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.localDg40 = this.localDg40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.localOt40 = this.localOt40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.localOt40h = this.localOt40h.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orderGubun = this.orderGubun.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sumPcod40 = this.sumPcod40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.localFr20 = this.localFr20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tsDg20 = this.tsDg20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tsRf40h = this.tsRf40h.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sumRf20 = this.sumRf20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.localFr40 = this.localFr40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sumDg40h = this.sumDg40h.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tsDg40h = this.tsDg40h.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.localDg40h = this.localDg40h.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sumOt20 = this.sumOt20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tsFr40h = this.tsFr40h.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.localFr40h = this.localFr40h.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.localOt20 = this.localOt20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sumPcod20 = this.sumPcod20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sumFr40 = this.sumFr40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sumDg40 = this.sumDg40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.localOt45 = this.localOt45.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tsOt45 = this.tsOt45.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sumOt45 = this.sumOt45.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
