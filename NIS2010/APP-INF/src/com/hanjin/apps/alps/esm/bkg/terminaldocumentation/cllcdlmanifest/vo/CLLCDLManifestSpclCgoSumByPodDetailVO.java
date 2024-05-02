/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CLLCDLManifestSpclCgoSumByPodDetailVO.java
*@FileTitle : CLLCDLManifestSpclCgoSumByPodDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.05  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

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
public class CLLCDLManifestSpclCgoSumByPodDetailVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<CLLCDLManifestSpclCgoSumByPodDetailVO> models = new ArrayList<CLLCDLManifestSpclCgoSumByPodDetailVO>();

    /* Column Info */
    private String rLo20 = null;

    /* Column Info */
    private String fLoTs20 = null;

    /* Column Info */
    private String dLo40 = null;

    /* Column Info */
    private String rLo40 = null;

    /* Column Info */
    private String dTs40h = null;

    /* Column Info */
    private String fLoTs40 = null;

    /* Column Info */
    private String dLo20 = null;

    /* Column Info */
    private String rLoTs20 = null;

    /* Column Info */
    private String dTs20 = null;

    /* Column Info */
    private String gubunCd = null;

    /* Column Info */
    private String rLoTs40 = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String oLoTs20 = null;

    /* Column Info */
    private String fLo40 = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String dLoTs20 = null;

    /* Column Info */
    private String fLoTs40h = null;

    /* Column Info */
    private String dLoTs40 = null;

    /* Column Info */
    private String fLo20 = null;

    /* Column Info */
    private String rTs20 = null;

    /* Column Info */
    private String fTs40 = null;

    /* Column Info */
    private String dLo40h = null;

    /* Column Info */
    private String dLoTs40h = null;

    /* Column Info */
    private String rTs40h = null;

    /* Column Info */
    private String fTs20 = null;

    /* Column Info */
    private String rTs40 = null;

    /* Column Info */
    private String oLoTs40 = null;

    /* Column Info */
    private String fLo40h = null;

    /* Column Info */
    private String podCd2 = null;

    /* Column Info */
    private String oLoTs40h = null;

    /* Column Info */
    private String oTs40h = null;

    /* Column Info */
    private String oTs40 = null;

    /* Column Info */
    private String oLo40 = null;

    /* Column Info */
    private String oTs20 = null;

    /* Column Info */
    private String rLoTs40h = null;

    /* Column Info */
    private String dTs40 = null;

    /* Column Info */
    private String fTs40h = null;

    /* Column Info */
    private String oLo20 = null;

    /* Column Info */
    private String rLo40h = null;

    /* Column Info */
    private String oLo40h = null;

    /* Column Info */
    private String oLo45 = null;

    /* Column Info */
    private String oTs45 = null;

    /* Column Info */
    private String oLoTs45 = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public CLLCDLManifestSpclCgoSumByPodDetailVO() {
    }

    public CLLCDLManifestSpclCgoSumByPodDetailVO(String ibflag, String pagerows, String rLo20, String fLoTs20, String rLo40, String dLo40, String fLoTs40, String dTs40h, String dLo20, String rLoTs20, String dTs20, String rLoTs40, String oLoTs20, String fLo40, String dLoTs20, String fLoTs40h, String dLoTs40, String fLo20, String rTs20, String fTs40, String dLo40h, String dLoTs40h, String rTs40h, String rTs40, String fTs20, String oLoTs40, String oLoTs40h, String fLo40h, String podCd2, String oTs40, String oTs40h, String oLo40, String oLo40h, String rLoTs40h, String oTs20, String dTs40, String fTs40h, String oLo20, String rLo40h, String gubunCd, String oLo45, String oTs45, String oLoTs45) {
        this.rLo20 = rLo20;
        this.fLoTs20 = fLoTs20;
        this.dLo40 = dLo40;
        this.rLo40 = rLo40;
        this.dTs40h = dTs40h;
        this.fLoTs40 = fLoTs40;
        this.dLo20 = dLo20;
        this.rLoTs20 = rLoTs20;
        this.dTs20 = dTs20;
        this.gubunCd = gubunCd;
        this.rLoTs40 = rLoTs40;
        this.pagerows = pagerows;
        this.oLoTs20 = oLoTs20;
        this.fLo40 = fLo40;
        this.ibflag = ibflag;
        this.dLoTs20 = dLoTs20;
        this.fLoTs40h = fLoTs40h;
        this.dLoTs40 = dLoTs40;
        this.fLo20 = fLo20;
        this.rTs20 = rTs20;
        this.fTs40 = fTs40;
        this.dLo40h = dLo40h;
        this.dLoTs40h = dLoTs40h;
        this.rTs40h = rTs40h;
        this.fTs20 = fTs20;
        this.rTs40 = rTs40;
        this.oLoTs40 = oLoTs40;
        this.fLo40h = fLo40h;
        this.podCd2 = podCd2;
        this.oLoTs40h = oLoTs40h;
        this.oTs40h = oTs40h;
        this.oTs40 = oTs40;
        this.oLo40 = oLo40;
        this.oTs20 = oTs20;
        this.rLoTs40h = rLoTs40h;
        this.dTs40 = dTs40;
        this.fTs40h = fTs40h;
        this.oLo20 = oLo20;
        this.rLo40h = rLo40h;
        this.oLo40h = oLo40h;
        this.oLo45 = oLo45;
        this.oTs45 = oTs45;
        this.oLoTs45 = oLoTs45;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("r_lo_20", getRLo20());
        this.hashColumns.put("f_lo_ts_20", getFLoTs20());
        this.hashColumns.put("d_lo_40", getDLo40());
        this.hashColumns.put("r_lo_40", getRLo40());
        this.hashColumns.put("d_ts_40h", getDTs40h());
        this.hashColumns.put("f_lo_ts_40", getFLoTs40());
        this.hashColumns.put("d_lo_20", getDLo20());
        this.hashColumns.put("r_lo_ts_20", getRLoTs20());
        this.hashColumns.put("d_ts_20", getDTs20());
        this.hashColumns.put("gubun_cd", getGubunCd());
        this.hashColumns.put("r_lo_ts_40", getRLoTs40());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("o_lo_ts_20", getOLoTs20());
        this.hashColumns.put("f_lo_40", getFLo40());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("d_lo_ts_20", getDLoTs20());
        this.hashColumns.put("f_lo_ts_40h", getFLoTs40h());
        this.hashColumns.put("d_lo_ts_40", getDLoTs40());
        this.hashColumns.put("f_lo_20", getFLo20());
        this.hashColumns.put("r_ts_20", getRTs20());
        this.hashColumns.put("f_ts_40", getFTs40());
        this.hashColumns.put("d_lo_40h", getDLo40h());
        this.hashColumns.put("d_lo_ts_40h", getDLoTs40h());
        this.hashColumns.put("r_ts_40h", getRTs40h());
        this.hashColumns.put("f_ts_20", getFTs20());
        this.hashColumns.put("r_ts_40", getRTs40());
        this.hashColumns.put("o_lo_ts_40", getOLoTs40());
        this.hashColumns.put("f_lo_40h", getFLo40h());
        this.hashColumns.put("pod_cd2", getPodCd2());
        this.hashColumns.put("o_lo_ts_40h", getOLoTs40h());
        this.hashColumns.put("o_ts_40h", getOTs40h());
        this.hashColumns.put("o_ts_40", getOTs40());
        this.hashColumns.put("o_lo_40", getOLo40());
        this.hashColumns.put("o_ts_20", getOTs20());
        this.hashColumns.put("r_lo_ts_40h", getRLoTs40h());
        this.hashColumns.put("d_ts_40", getDTs40());
        this.hashColumns.put("f_ts_40h", getFTs40h());
        this.hashColumns.put("o_lo_20", getOLo20());
        this.hashColumns.put("r_lo_40h", getRLo40h());
        this.hashColumns.put("o_lo_40h", getOLo40h());
        this.hashColumns.put("o_lo_45", getOLo45());
        this.hashColumns.put("o_ts_45", getOTs45());
        this.hashColumns.put("o_lo_ts_45", getOLoTs45());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("r_lo_20", "rLo20");
        this.hashFields.put("f_lo_ts_20", "fLoTs20");
        this.hashFields.put("d_lo_40", "dLo40");
        this.hashFields.put("r_lo_40", "rLo40");
        this.hashFields.put("d_ts_40h", "dTs40h");
        this.hashFields.put("f_lo_ts_40", "fLoTs40");
        this.hashFields.put("d_lo_20", "dLo20");
        this.hashFields.put("r_lo_ts_20", "rLoTs20");
        this.hashFields.put("d_ts_20", "dTs20");
        this.hashFields.put("gubun_cd", "gubunCd");
        this.hashFields.put("r_lo_ts_40", "rLoTs40");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("o_lo_ts_20", "oLoTs20");
        this.hashFields.put("f_lo_40", "fLo40");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("d_lo_ts_20", "dLoTs20");
        this.hashFields.put("f_lo_ts_40h", "fLoTs40h");
        this.hashFields.put("d_lo_ts_40", "dLoTs40");
        this.hashFields.put("f_lo_20", "fLo20");
        this.hashFields.put("r_ts_20", "rTs20");
        this.hashFields.put("f_ts_40", "fTs40");
        this.hashFields.put("d_lo_40h", "dLo40h");
        this.hashFields.put("d_lo_ts_40h", "dLoTs40h");
        this.hashFields.put("r_ts_40h", "rTs40h");
        this.hashFields.put("f_ts_20", "fTs20");
        this.hashFields.put("r_ts_40", "rTs40");
        this.hashFields.put("o_lo_ts_40", "oLoTs40");
        this.hashFields.put("f_lo_40h", "fLo40h");
        this.hashFields.put("pod_cd2", "podCd2");
        this.hashFields.put("o_lo_ts_40h", "oLoTs40h");
        this.hashFields.put("o_ts_40h", "oTs40h");
        this.hashFields.put("o_ts_40", "oTs40");
        this.hashFields.put("o_lo_40", "oLo40");
        this.hashFields.put("o_ts_20", "oTs20");
        this.hashFields.put("r_lo_ts_40h", "rLoTs40h");
        this.hashFields.put("d_ts_40", "dTs40");
        this.hashFields.put("f_ts_40h", "fTs40h");
        this.hashFields.put("o_lo_20", "oLo20");
        this.hashFields.put("r_lo_40h", "rLo40h");
        this.hashFields.put("o_lo_40h", "oLo40h");
        this.hashFields.put("o_lo_45", "oLo45");
        this.hashFields.put("o_ts_45", "oTs45");
        this.hashFields.put("o_lo_ts_45", "oLoTs45");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return rLo20
	 */
    public String getRLo20() {
        return this.rLo20;
    }

    /**
	 * Column Info
	 * @return fLoTs20
	 */
    public String getFLoTs20() {
        return this.fLoTs20;
    }

    /**
	 * Column Info
	 * @return dLo40
	 */
    public String getDLo40() {
        return this.dLo40;
    }

    /**
	 * Column Info
	 * @return rLo40
	 */
    public String getRLo40() {
        return this.rLo40;
    }

    /**
	 * Column Info
	 * @return dTs40h
	 */
    public String getDTs40h() {
        return this.dTs40h;
    }

    /**
	 * Column Info
	 * @return fLoTs40
	 */
    public String getFLoTs40() {
        return this.fLoTs40;
    }

    /**
	 * Column Info
	 * @return dLo20
	 */
    public String getDLo20() {
        return this.dLo20;
    }

    /**
	 * Column Info
	 * @return rLoTs20
	 */
    public String getRLoTs20() {
        return this.rLoTs20;
    }

    /**
	 * Column Info
	 * @return dTs20
	 */
    public String getDTs20() {
        return this.dTs20;
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
	 * @return rLoTs40
	 */
    public String getRLoTs40() {
        return this.rLoTs40;
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
	 * @return oLoTs20
	 */
    public String getOLoTs20() {
        return this.oLoTs20;
    }

    /**
	 * Column Info
	 * @return fLo40
	 */
    public String getFLo40() {
        return this.fLo40;
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
	 * @return dLoTs20
	 */
    public String getDLoTs20() {
        return this.dLoTs20;
    }

    /**
	 * Column Info
	 * @return fLoTs40h
	 */
    public String getFLoTs40h() {
        return this.fLoTs40h;
    }

    /**
	 * Column Info
	 * @return dLoTs40
	 */
    public String getDLoTs40() {
        return this.dLoTs40;
    }

    /**
	 * Column Info
	 * @return fLo20
	 */
    public String getFLo20() {
        return this.fLo20;
    }

    /**
	 * Column Info
	 * @return rTs20
	 */
    public String getRTs20() {
        return this.rTs20;
    }

    /**
	 * Column Info
	 * @return fTs40
	 */
    public String getFTs40() {
        return this.fTs40;
    }

    /**
	 * Column Info
	 * @return dLo40h
	 */
    public String getDLo40h() {
        return this.dLo40h;
    }

    /**
	 * Column Info
	 * @return dLoTs40h
	 */
    public String getDLoTs40h() {
        return this.dLoTs40h;
    }

    /**
	 * Column Info
	 * @return rTs40h
	 */
    public String getRTs40h() {
        return this.rTs40h;
    }

    /**
	 * Column Info
	 * @return fTs20
	 */
    public String getFTs20() {
        return this.fTs20;
    }

    /**
	 * Column Info
	 * @return rTs40
	 */
    public String getRTs40() {
        return this.rTs40;
    }

    /**
	 * Column Info
	 * @return oLoTs40
	 */
    public String getOLoTs40() {
        return this.oLoTs40;
    }

    /**
	 * Column Info
	 * @return fLo40h
	 */
    public String getFLo40h() {
        return this.fLo40h;
    }

    /**
	 * Column Info
	 * @return podCd2
	 */
    public String getPodCd2() {
        return this.podCd2;
    }

    /**
	 * Column Info
	 * @return oLoTs40h
	 */
    public String getOLoTs40h() {
        return this.oLoTs40h;
    }

    /**
	 * Column Info
	 * @return oTs40h
	 */
    public String getOTs40h() {
        return this.oTs40h;
    }

    /**
	 * Column Info
	 * @return oTs40
	 */
    public String getOTs40() {
        return this.oTs40;
    }

    /**
	 * Column Info
	 * @return oLo40
	 */
    public String getOLo40() {
        return this.oLo40;
    }

    /**
	 * Column Info
	 * @return oTs20
	 */
    public String getOTs20() {
        return this.oTs20;
    }

    /**
	 * Column Info
	 * @return rLoTs40h
	 */
    public String getRLoTs40h() {
        return this.rLoTs40h;
    }

    /**
	 * Column Info
	 * @return dTs40
	 */
    public String getDTs40() {
        return this.dTs40;
    }

    /**
	 * Column Info
	 * @return fTs40h
	 */
    public String getFTs40h() {
        return this.fTs40h;
    }

    /**
	 * Column Info
	 * @return oLo20
	 */
    public String getOLo20() {
        return this.oLo20;
    }

    /**
	 * Column Info
	 * @return rLo40h
	 */
    public String getRLo40h() {
        return this.rLo40h;
    }

    /**
	 * Column Info
	 * @return oLo40h
	 */
    public String getOLo40h() {
        return this.oLo40h;
    }

    /**
	 * Column Info
	 * @param rLo20
	 */
    public void setRLo20(String rLo20) {
        this.rLo20 = rLo20;
    }

    /**
	 * Column Info
	 * @param fLoTs20
	 */
    public void setFLoTs20(String fLoTs20) {
        this.fLoTs20 = fLoTs20;
    }

    /**
	 * Column Info
	 * @param dLo40
	 */
    public void setDLo40(String dLo40) {
        this.dLo40 = dLo40;
    }

    /**
	 * Column Info
	 * @param rLo40
	 */
    public void setRLo40(String rLo40) {
        this.rLo40 = rLo40;
    }

    /**
	 * Column Info
	 * @param dTs40h
	 */
    public void setDTs40h(String dTs40h) {
        this.dTs40h = dTs40h;
    }

    /**
	 * Column Info
	 * @param fLoTs40
	 */
    public void setFLoTs40(String fLoTs40) {
        this.fLoTs40 = fLoTs40;
    }

    /**
	 * Column Info
	 * @param dLo20
	 */
    public void setDLo20(String dLo20) {
        this.dLo20 = dLo20;
    }

    /**
	 * Column Info
	 * @param rLoTs20
	 */
    public void setRLoTs20(String rLoTs20) {
        this.rLoTs20 = rLoTs20;
    }

    /**
	 * Column Info
	 * @param dTs20
	 */
    public void setDTs20(String dTs20) {
        this.dTs20 = dTs20;
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
	 * @param rLoTs40
	 */
    public void setRLoTs40(String rLoTs40) {
        this.rLoTs40 = rLoTs40;
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
	 * @param oLoTs20
	 */
    public void setOLoTs20(String oLoTs20) {
        this.oLoTs20 = oLoTs20;
    }

    /**
	 * Column Info
	 * @param fLo40
	 */
    public void setFLo40(String fLo40) {
        this.fLo40 = fLo40;
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
	 * @param dLoTs20
	 */
    public void setDLoTs20(String dLoTs20) {
        this.dLoTs20 = dLoTs20;
    }

    /**
	 * Column Info
	 * @param fLoTs40h
	 */
    public void setFLoTs40h(String fLoTs40h) {
        this.fLoTs40h = fLoTs40h;
    }

    /**
	 * Column Info
	 * @param dLoTs40
	 */
    public void setDLoTs40(String dLoTs40) {
        this.dLoTs40 = dLoTs40;
    }

    /**
	 * Column Info
	 * @param fLo20
	 */
    public void setFLo20(String fLo20) {
        this.fLo20 = fLo20;
    }

    /**
	 * Column Info
	 * @param rTs20
	 */
    public void setRTs20(String rTs20) {
        this.rTs20 = rTs20;
    }

    /**
	 * Column Info
	 * @param fTs40
	 */
    public void setFTs40(String fTs40) {
        this.fTs40 = fTs40;
    }

    /**
	 * Column Info
	 * @param dLo40h
	 */
    public void setDLo40h(String dLo40h) {
        this.dLo40h = dLo40h;
    }

    /**
	 * Column Info
	 * @param dLoTs40h
	 */
    public void setDLoTs40h(String dLoTs40h) {
        this.dLoTs40h = dLoTs40h;
    }

    /**
	 * Column Info
	 * @param rTs40h
	 */
    public void setRTs40h(String rTs40h) {
        this.rTs40h = rTs40h;
    }

    /**
	 * Column Info
	 * @param fTs20
	 */
    public void setFTs20(String fTs20) {
        this.fTs20 = fTs20;
    }

    /**
	 * Column Info
	 * @param rTs40
	 */
    public void setRTs40(String rTs40) {
        this.rTs40 = rTs40;
    }

    /**
	 * Column Info
	 * @param oLoTs40
	 */
    public void setOLoTs40(String oLoTs40) {
        this.oLoTs40 = oLoTs40;
    }

    /**
	 * Column Info
	 * @param fLo40h
	 */
    public void setFLo40h(String fLo40h) {
        this.fLo40h = fLo40h;
    }

    /**
	 * Column Info
	 * @param podCd2
	 */
    public void setPodCd2(String podCd2) {
        this.podCd2 = podCd2;
    }

    /**
	 * Column Info
	 * @param oLoTs40h
	 */
    public void setOLoTs40h(String oLoTs40h) {
        this.oLoTs40h = oLoTs40h;
    }

    /**
	 * Column Info
	 * @param oTs40h
	 */
    public void setOTs40h(String oTs40h) {
        this.oTs40h = oTs40h;
    }

    /**
	 * Column Info
	 * @param oTs40
	 */
    public void setOTs40(String oTs40) {
        this.oTs40 = oTs40;
    }

    /**
	 * Column Info
	 * @param oLo40
	 */
    public void setOLo40(String oLo40) {
        this.oLo40 = oLo40;
    }

    /**
	 * Column Info
	 * @param oTs20
	 */
    public void setOTs20(String oTs20) {
        this.oTs20 = oTs20;
    }

    /**
	 * Column Info
	 * @param rLoTs40h
	 */
    public void setRLoTs40h(String rLoTs40h) {
        this.rLoTs40h = rLoTs40h;
    }

    /**
	 * Column Info
	 * @param dTs40
	 */
    public void setDTs40(String dTs40) {
        this.dTs40 = dTs40;
    }

    /**
	 * Column Info
	 * @param fTs40h
	 */
    public void setFTs40h(String fTs40h) {
        this.fTs40h = fTs40h;
    }

    /**
	 * Column Info
	 * @param oLo20
	 */
    public void setOLo20(String oLo20) {
        this.oLo20 = oLo20;
    }

    /**
	 * Column Info
	 * @param rLo40h
	 */
    public void setRLo40h(String rLo40h) {
        this.rLo40h = rLo40h;
    }

    /**
	 * Column Info
	 * @param oLo40h
	 */
    public void setOLo40h(String oLo40h) {
        this.oLo40h = oLo40h;
    }

    public void setOLo45(String oLo45) {
        this.oLo45 = oLo45;
    }

    public String getOLo45() {
        return this.oLo45;
    }

    public void setOTs45(String oTs45) {
        this.oTs45 = oTs45;
    }

    public String getOTs45() {
        return this.oTs45;
    }

    public void setOLoTs45(String oLoTs45) {
        this.oLoTs45 = oLoTs45;
    }

    public String getOLoTs45() {
        return this.oLoTs45;
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
        setRLo20(JSPUtil.getParameter(request, prefix + "r_lo_20", ""));
        setFLoTs20(JSPUtil.getParameter(request, prefix + "f_lo_ts_20", ""));
        setDLo40(JSPUtil.getParameter(request, prefix + "d_lo_40", ""));
        setRLo40(JSPUtil.getParameter(request, prefix + "r_lo_40", ""));
        setDTs40h(JSPUtil.getParameter(request, prefix + "d_ts_40h", ""));
        setFLoTs40(JSPUtil.getParameter(request, prefix + "f_lo_ts_40", ""));
        setDLo20(JSPUtil.getParameter(request, prefix + "d_lo_20", ""));
        setRLoTs20(JSPUtil.getParameter(request, prefix + "r_lo_ts_20", ""));
        setDTs20(JSPUtil.getParameter(request, prefix + "d_ts_20", ""));
        setGubunCd(JSPUtil.getParameter(request, prefix + "gubun_cd", ""));
        setRLoTs40(JSPUtil.getParameter(request, prefix + "r_lo_ts_40", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setOLoTs20(JSPUtil.getParameter(request, prefix + "o_lo_ts_20", ""));
        setFLo40(JSPUtil.getParameter(request, prefix + "f_lo_40", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setDLoTs20(JSPUtil.getParameter(request, prefix + "d_lo_ts_20", ""));
        setFLoTs40h(JSPUtil.getParameter(request, prefix + "f_lo_ts_40h", ""));
        setDLoTs40(JSPUtil.getParameter(request, prefix + "d_lo_ts_40", ""));
        setFLo20(JSPUtil.getParameter(request, prefix + "f_lo_20", ""));
        setRTs20(JSPUtil.getParameter(request, prefix + "r_ts_20", ""));
        setFTs40(JSPUtil.getParameter(request, prefix + "f_ts_40", ""));
        setDLo40h(JSPUtil.getParameter(request, prefix + "d_lo_40h", ""));
        setDLoTs40h(JSPUtil.getParameter(request, prefix + "d_lo_ts_40h", ""));
        setRTs40h(JSPUtil.getParameter(request, prefix + "r_ts_40h", ""));
        setFTs20(JSPUtil.getParameter(request, prefix + "f_ts_20", ""));
        setRTs40(JSPUtil.getParameter(request, prefix + "r_ts_40", ""));
        setOLoTs40(JSPUtil.getParameter(request, prefix + "o_lo_ts_40", ""));
        setFLo40h(JSPUtil.getParameter(request, prefix + "f_lo_40h", ""));
        setPodCd2(JSPUtil.getParameter(request, prefix + "pod_cd2", ""));
        setOLoTs40h(JSPUtil.getParameter(request, prefix + "o_lo_ts_40h", ""));
        setOTs40h(JSPUtil.getParameter(request, prefix + "o_ts_40h", ""));
        setOTs40(JSPUtil.getParameter(request, prefix + "o_ts_40", ""));
        setOLo40(JSPUtil.getParameter(request, prefix + "o_lo_40", ""));
        setOTs20(JSPUtil.getParameter(request, prefix + "o_ts_20", ""));
        setRLoTs40h(JSPUtil.getParameter(request, prefix + "r_lo_ts_40h", ""));
        setDTs40(JSPUtil.getParameter(request, prefix + "d_ts_40", ""));
        setFTs40h(JSPUtil.getParameter(request, prefix + "f_ts_40h", ""));
        setOLo20(JSPUtil.getParameter(request, prefix + "o_lo_20", ""));
        setRLo40h(JSPUtil.getParameter(request, prefix + "r_lo_40h", ""));
        setOLo40h(JSPUtil.getParameter(request, prefix + "o_lo_40h", ""));
        setOLo45(JSPUtil.getParameter(request, prefix + "o_lo_45", ""));
        setOTs45(JSPUtil.getParameter(request, prefix + "o_ts_45", ""));
        setOLoTs45(JSPUtil.getParameter(request, prefix + "o_lo_ts_45", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CLLCDLManifestSpclCgoSumByPodDetailVO[]
	 */
    public CLLCDLManifestSpclCgoSumByPodDetailVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CLLCDLManifestSpclCgoSumByPodDetailVO[]
	 */
    public CLLCDLManifestSpclCgoSumByPodDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CLLCDLManifestSpclCgoSumByPodDetailVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] rLo20 = (JSPUtil.getParameter(request, prefix + "r_lo_20", length));
            String[] fLoTs20 = (JSPUtil.getParameter(request, prefix + "f_lo_ts_20", length));
            String[] dLo40 = (JSPUtil.getParameter(request, prefix + "d_lo_40", length));
            String[] rLo40 = (JSPUtil.getParameter(request, prefix + "r_lo_40", length));
            String[] dTs40h = (JSPUtil.getParameter(request, prefix + "d_ts_40h", length));
            String[] fLoTs40 = (JSPUtil.getParameter(request, prefix + "f_lo_ts_40", length));
            String[] dLo20 = (JSPUtil.getParameter(request, prefix + "d_lo_20", length));
            String[] rLoTs20 = (JSPUtil.getParameter(request, prefix + "r_lo_ts_20", length));
            String[] dTs20 = (JSPUtil.getParameter(request, prefix + "d_ts_20", length));
            String[] gubunCd = (JSPUtil.getParameter(request, prefix + "gubun_cd", length));
            String[] rLoTs40 = (JSPUtil.getParameter(request, prefix + "r_lo_ts_40", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] oLoTs20 = (JSPUtil.getParameter(request, prefix + "o_lo_ts_20", length));
            String[] fLo40 = (JSPUtil.getParameter(request, prefix + "f_lo_40", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] dLoTs20 = (JSPUtil.getParameter(request, prefix + "d_lo_ts_20", length));
            String[] fLoTs40h = (JSPUtil.getParameter(request, prefix + "f_lo_ts_40h", length));
            String[] dLoTs40 = (JSPUtil.getParameter(request, prefix + "d_lo_ts_40", length));
            String[] fLo20 = (JSPUtil.getParameter(request, prefix + "f_lo_20", length));
            String[] rTs20 = (JSPUtil.getParameter(request, prefix + "r_ts_20", length));
            String[] fTs40 = (JSPUtil.getParameter(request, prefix + "f_ts_40", length));
            String[] dLo40h = (JSPUtil.getParameter(request, prefix + "d_lo_40h", length));
            String[] dLoTs40h = (JSPUtil.getParameter(request, prefix + "d_lo_ts_40h", length));
            String[] rTs40h = (JSPUtil.getParameter(request, prefix + "r_ts_40h", length));
            String[] fTs20 = (JSPUtil.getParameter(request, prefix + "f_ts_20", length));
            String[] rTs40 = (JSPUtil.getParameter(request, prefix + "r_ts_40", length));
            String[] oLoTs40 = (JSPUtil.getParameter(request, prefix + "o_lo_ts_40", length));
            String[] fLo40h = (JSPUtil.getParameter(request, prefix + "f_lo_40h", length));
            String[] podCd2 = (JSPUtil.getParameter(request, prefix + "pod_cd2", length));
            String[] oLoTs40h = (JSPUtil.getParameter(request, prefix + "o_lo_ts_40h", length));
            String[] oTs40h = (JSPUtil.getParameter(request, prefix + "o_ts_40h", length));
            String[] oTs40 = (JSPUtil.getParameter(request, prefix + "o_ts_40", length));
            String[] oLo40 = (JSPUtil.getParameter(request, prefix + "o_lo_40", length));
            String[] oTs20 = (JSPUtil.getParameter(request, prefix + "o_ts_20", length));
            String[] rLoTs40h = (JSPUtil.getParameter(request, prefix + "r_lo_ts_40h", length));
            String[] dTs40 = (JSPUtil.getParameter(request, prefix + "d_ts_40", length));
            String[] fTs40h = (JSPUtil.getParameter(request, prefix + "f_ts_40h", length));
            String[] oLo20 = (JSPUtil.getParameter(request, prefix + "o_lo_20", length));
            String[] rLo40h = (JSPUtil.getParameter(request, prefix + "r_lo_40h", length));
            String[] oLo40h = (JSPUtil.getParameter(request, prefix + "o_lo_40h", length));
            String[] oLo45 = (JSPUtil.getParameter(request, prefix + "o_lo_45", length));
	    	String[] oTs45 = (JSPUtil.getParameter(request, prefix + "o_ts_45", length));
	    	String[] oLoTs45 = (JSPUtil.getParameter(request, prefix + "o_lo_ts_45", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new CLLCDLManifestSpclCgoSumByPodDetailVO();
                if (rLo20[i] != null)
                    model.setRLo20(rLo20[i]);
                if (fLoTs20[i] != null)
                    model.setFLoTs20(fLoTs20[i]);
                if (dLo40[i] != null)
                    model.setDLo40(dLo40[i]);
                if (rLo40[i] != null)
                    model.setRLo40(rLo40[i]);
                if (dTs40h[i] != null)
                    model.setDTs40h(dTs40h[i]);
                if (fLoTs40[i] != null)
                    model.setFLoTs40(fLoTs40[i]);
                if (dLo20[i] != null)
                    model.setDLo20(dLo20[i]);
                if (rLoTs20[i] != null)
                    model.setRLoTs20(rLoTs20[i]);
                if (dTs20[i] != null)
                    model.setDTs20(dTs20[i]);
                if (gubunCd[i] != null)
                    model.setGubunCd(gubunCd[i]);
                if (rLoTs40[i] != null)
                    model.setRLoTs40(rLoTs40[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (oLoTs20[i] != null)
                    model.setOLoTs20(oLoTs20[i]);
                if (fLo40[i] != null)
                    model.setFLo40(fLo40[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (dLoTs20[i] != null)
                    model.setDLoTs20(dLoTs20[i]);
                if (fLoTs40h[i] != null)
                    model.setFLoTs40h(fLoTs40h[i]);
                if (dLoTs40[i] != null)
                    model.setDLoTs40(dLoTs40[i]);
                if (fLo20[i] != null)
                    model.setFLo20(fLo20[i]);
                if (rTs20[i] != null)
                    model.setRTs20(rTs20[i]);
                if (fTs40[i] != null)
                    model.setFTs40(fTs40[i]);
                if (dLo40h[i] != null)
                    model.setDLo40h(dLo40h[i]);
                if (dLoTs40h[i] != null)
                    model.setDLoTs40h(dLoTs40h[i]);
                if (rTs40h[i] != null)
                    model.setRTs40h(rTs40h[i]);
                if (fTs20[i] != null)
                    model.setFTs20(fTs20[i]);
                if (rTs40[i] != null)
                    model.setRTs40(rTs40[i]);
                if (oLoTs40[i] != null)
                    model.setOLoTs40(oLoTs40[i]);
                if (fLo40h[i] != null)
                    model.setFLo40h(fLo40h[i]);
                if (podCd2[i] != null)
                    model.setPodCd2(podCd2[i]);
                if (oLoTs40h[i] != null)
                    model.setOLoTs40h(oLoTs40h[i]);
                if (oTs40h[i] != null)
                    model.setOTs40h(oTs40h[i]);
                if (oTs40[i] != null)
                    model.setOTs40(oTs40[i]);
                if (oLo40[i] != null)
                    model.setOLo40(oLo40[i]);
                if (oTs20[i] != null)
                    model.setOTs20(oTs20[i]);
                if (rLoTs40h[i] != null)
                    model.setRLoTs40h(rLoTs40h[i]);
                if (dTs40[i] != null)
                    model.setDTs40(dTs40[i]);
                if (fTs40h[i] != null)
                    model.setFTs40h(fTs40h[i]);
                if (oLo20[i] != null)
                    model.setOLo20(oLo20[i]);
                if (rLo40h[i] != null)
                    model.setRLo40h(rLo40h[i]);
                if (oLo40h[i] != null)
                    model.setOLo40h(oLo40h[i]);
                if (oLo45[i] != null) 
		    		model.setOLo45(oLo45[i]);
				if (oTs45[i] != null) 
		    		model.setOTs45(oTs45[i]);
				if (oLoTs45[i] != null) 
		    		model.setOLoTs45(oLoTs45[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCLLCDLManifestSpclCgoSumByPodDetailVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return CLLCDLManifestSpclCgoSumByPodDetailVO[]
	 */
    public CLLCDLManifestSpclCgoSumByPodDetailVO[] getCLLCDLManifestSpclCgoSumByPodDetailVOs() {
        CLLCDLManifestSpclCgoSumByPodDetailVO[] vos = (CLLCDLManifestSpclCgoSumByPodDetailVO[]) models.toArray(new CLLCDLManifestSpclCgoSumByPodDetailVO[models.size()]);
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
        this.rLo20 = this.rLo20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fLoTs20 = this.fLoTs20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dLo40 = this.dLo40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rLo40 = this.rLo40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dTs40h = this.dTs40h.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fLoTs40 = this.fLoTs40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dLo20 = this.dLo20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rLoTs20 = this.rLoTs20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dTs20 = this.dTs20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.gubunCd = this.gubunCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rLoTs40 = this.rLoTs40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oLoTs20 = this.oLoTs20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fLo40 = this.fLo40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dLoTs20 = this.dLoTs20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fLoTs40h = this.fLoTs40h.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dLoTs40 = this.dLoTs40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fLo20 = this.fLo20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rTs20 = this.rTs20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fTs40 = this.fTs40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dLo40h = this.dLo40h.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dLoTs40h = this.dLoTs40h.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rTs40h = this.rTs40h.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fTs20 = this.fTs20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rTs40 = this.rTs40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oLoTs40 = this.oLoTs40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fLo40h = this.fLo40h.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd2 = this.podCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oLoTs40h = this.oLoTs40h.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oTs40h = this.oTs40h.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oTs40 = this.oTs40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oLo40 = this.oLo40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oTs20 = this.oTs20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rLoTs40h = this.rLoTs40h.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dTs40 = this.dTs40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fTs40h = this.fTs40h.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oLo20 = this.oLo20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rLo40h = this.rLo40h.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oLo40h = this.oLo40h.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oLo45 = this.oLo45.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oTs45 = this.oTs45.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oLoTs45 = this.oLoTs45.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
