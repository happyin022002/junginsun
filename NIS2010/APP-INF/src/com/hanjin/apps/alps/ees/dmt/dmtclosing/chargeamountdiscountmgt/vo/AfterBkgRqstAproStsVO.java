/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AfterBkgRqstAproStsVO.java
*@FileTitle : AfterBkgRqstAproStsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.28
*@LastModifier : 김기태
*@LastVersion : 1.0
* 2016.03.28 김기태 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo;

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
 * @author 김기태
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class AfterBkgRqstAproStsVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<AfterBkgRqstAproStsVO> models = new ArrayList<AfterBkgRqstAproStsVO>();

    /* Column Info */
    private String lv4Dt = null;

    /* Column Info */
    private String blNo = null;

    /* Column Info */
    private String lv5UsrNm = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String lv2Sts = null;

    /* Column Info */
    private String lv4UsrNm = null;

    /* Column Info */
    private String lv5Ofc = null;

    /* Column Info */
    private String scNo = null;

    /* Column Info */
    private String lv2UsrId = null;

    /* Column Info */
    private String lv2Dt = null;

    /* Column Info */
    private String lv3Dt = null;

    /* Column Info */
    private String lv1Auth = null;

    /* Column Info */
    private String dmdtTrfCd = null;

    /* Column Info */
    private String lv5Auth = null;

    /* Column Info */
    private String lv2UsrNm = null;

    /* Column Info */
    private String lv6Sts = null;

    /* Column Info */
    private String lv1UsrId = null;

    /* Column Info */
    private String aftBkgAproNo = null;

    /* Column Info */
    private String lv1Dt = null;

    /* Column Info */
    private String lv5Dt = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String lv3Auth = null;

    /* Column Info */
    private String dmdtExptRqstStsCdDesc = null;

    /* Column Info */
    private String lv4UsrId = null;

    /* Column Info */
    private String lv6Auth = null;

    /* Column Info */
    private String rqstUsrId = null;

    /* Column Info */
    private String lv3UsrNm = null;

    /* Column Info */
    private String lv1UsrNm = null;

    /* Column Info */
    private String lv6Dt = null;

    /* Column Info */
    private String lv4Auth = null;

    /* Column Info */
    private String lv6Ofc = null;

    /* Column Info */
    private String lv1Ofc = null;

    /* Column Info */
    private String lv5Sts = null;

    /* Column Info */
    private String rfaNo = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String aftExptDarNo = null;

    /* Column Info */
    private String dmdtExptRqstStsCd = null;

    /* Column Info */
    private String lv2Auth = null;

    /* Column Info */
    private String lv3Sts = null;

    /* Column Info */
    private String lv6UsrId = null;

    /* Column Info */
    private String finalAproOfcCd = null;

    /* Column Info */
    private String lv4Ofc = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String rqstDt = null;

    /* Column Info */
    private String dmdtOfcCd = null;

    /* Column Info */
    private String rqstUsrNm = null;

    /* Column Info */
    private String lv3Ofc = null;

    /* Column Info */
    private String lv3UsrId = null;

    /* Column Info */
    private String lv1Sts = null;

    /* Column Info */
    private String lv2Ofc = null;

    /* Column Info */
    private String rqstAuth = null;

    /* Column Info */
    private String lv6UsrNm = null;

    /* Column Info */
    private String taaNo = null;

    /* Column Info */
    private String rqstOfcCd = null;

    /* Column Info */
    private String lv5UsrId = null;

    /* Column Info */
    private String lv4Sts = null;

    /* Column Info */
    private String ctrtOfcCd = null;

    /* Column Info */
    private String ctrtCustCd = null;

    /* Column Info */
    private String ctrtCustNm = null;

    /* Column Info */
    private String lv7Sts = null;

    /* Column Info */
    private String lv7Auth = null;

    /* Column Info */
    private String lv7Dt = null;

    /* Column Info */
    private String lv7Ofc = null;

    /* Column Info */
    private String lv7UsrId = null;

    /* Column Info */
    private String lv7UsrNm = null;

    /* Column Info */
    private String lv8Sts = null;

    /* Column Info */
    private String lv8Auth = null;

    /* Column Info */
    private String lv8Dt = null;

    /* Column Info */
    private String lv8Ofc = null;

    /* Column Info */
    private String lv8UsrId = null;

    /* Column Info */
    private String lv8UsrNm = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public AfterBkgRqstAproStsVO() {
    }

    public AfterBkgRqstAproStsVO(String ibflag, String pagerows, String aftExptDarNo, String dmdtExptRqstStsCd, String dmdtExptRqstStsCdDesc, String scNo, String rfaNo, String taaNo, String dmdtTrfCd, String dmdtOfcCd, String rqstOfcCd, String rqstUsrId, String rqstUsrNm, String rqstDt, String rqstAuth, String aftBkgAproNo, String updDt, String finalAproOfcCd, String lv1Ofc, String lv1Sts, String lv1UsrId, String lv1UsrNm, String lv1Dt, String lv1Auth, String lv2Ofc, String lv2Sts, String lv2UsrId, String lv2UsrNm, String lv2Dt, String lv2Auth, String lv3Ofc, String lv3Sts, String lv3UsrId, String lv3UsrNm, String lv3Dt, String lv3Auth, String lv4Ofc, String lv4Sts, String lv4UsrId, String lv4UsrNm, String lv4Dt, String lv4Auth, String lv5Ofc, String lv5Sts, String lv5UsrId, String lv5UsrNm, String lv5Dt, String lv5Auth, String lv6Ofc, String lv6Sts, String lv6UsrId, String lv6UsrNm, String lv6Dt, String lv6Auth, String bkgNo, String blNo, String ctrtOfcCd, String ctrtCustCd, String ctrtCustNm, String lv7Sts, String lv7Auth, String lv7Dt, String lv7Ofc, String lv7UsrId, String lv7UsrNm, String lv8Sts, String lv8Auth, String lv8Dt, String lv8Ofc, String lv8UsrId, String lv8UsrNm) {
        this.lv4Dt = lv4Dt;
        this.blNo = blNo;
        this.lv5UsrNm = lv5UsrNm;
        this.pagerows = pagerows;
        this.lv2Sts = lv2Sts;
        this.lv4UsrNm = lv4UsrNm;
        this.lv5Ofc = lv5Ofc;
        this.scNo = scNo;
        this.lv2UsrId = lv2UsrId;
        this.lv2Dt = lv2Dt;
        this.lv3Dt = lv3Dt;
        this.lv1Auth = lv1Auth;
        this.dmdtTrfCd = dmdtTrfCd;
        this.lv5Auth = lv5Auth;
        this.lv2UsrNm = lv2UsrNm;
        this.lv6Sts = lv6Sts;
        this.lv1UsrId = lv1UsrId;
        this.aftBkgAproNo = aftBkgAproNo;
        this.lv1Dt = lv1Dt;
        this.lv5Dt = lv5Dt;
        this.bkgNo = bkgNo;
        this.lv3Auth = lv3Auth;
        this.dmdtExptRqstStsCdDesc = dmdtExptRqstStsCdDesc;
        this.lv4UsrId = lv4UsrId;
        this.lv6Auth = lv6Auth;
        this.rqstUsrId = rqstUsrId;
        this.lv3UsrNm = lv3UsrNm;
        this.lv1UsrNm = lv1UsrNm;
        this.lv6Dt = lv6Dt;
        this.lv4Auth = lv4Auth;
        this.lv6Ofc = lv6Ofc;
        this.lv1Ofc = lv1Ofc;
        this.lv5Sts = lv5Sts;
        this.rfaNo = rfaNo;
        this.ibflag = ibflag;
        this.aftExptDarNo = aftExptDarNo;
        this.dmdtExptRqstStsCd = dmdtExptRqstStsCd;
        this.lv2Auth = lv2Auth;
        this.lv3Sts = lv3Sts;
        this.lv6UsrId = lv6UsrId;
        this.finalAproOfcCd = finalAproOfcCd;
        this.lv4Ofc = lv4Ofc;
        this.updDt = updDt;
        this.rqstDt = rqstDt;
        this.dmdtOfcCd = dmdtOfcCd;
        this.rqstUsrNm = rqstUsrNm;
        this.lv3Ofc = lv3Ofc;
        this.lv3UsrId = lv3UsrId;
        this.lv1Sts = lv1Sts;
        this.lv2Ofc = lv2Ofc;
        this.rqstAuth = rqstAuth;
        this.lv6UsrNm = lv6UsrNm;
        this.taaNo = taaNo;
        this.rqstOfcCd = rqstOfcCd;
        this.lv5UsrId = lv5UsrId;
        this.lv4Sts = lv4Sts;
        this.ctrtOfcCd = ctrtOfcCd;
        this.ctrtCustCd = ctrtCustCd;
        this.ctrtCustNm = ctrtCustNm;
        this.lv7Sts = lv7Sts;
        this.lv7Auth = lv7Auth;
        this.lv7Dt = lv7Dt;
        this.lv7Ofc = lv7Ofc;
        this.lv7UsrId = lv7UsrId;
        this.lv7UsrNm = lv7UsrNm;
        this.lv8Sts = lv8Sts;
        this.lv8Auth = lv8Auth;
        this.lv8Dt = lv8Dt;
        this.lv8Ofc = lv8Ofc;
        this.lv8UsrId = lv8UsrId;
        this.lv8UsrNm = lv8UsrNm;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("lv4_dt", getLv4Dt());
        this.hashColumns.put("bl_no", getBlNo());
        this.hashColumns.put("lv5_usr_nm", getLv5UsrNm());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("lv2_sts", getLv2Sts());
        this.hashColumns.put("lv4_usr_nm", getLv4UsrNm());
        this.hashColumns.put("lv5_ofc", getLv5Ofc());
        this.hashColumns.put("sc_no", getScNo());
        this.hashColumns.put("lv2_usr_id", getLv2UsrId());
        this.hashColumns.put("lv2_dt", getLv2Dt());
        this.hashColumns.put("lv3_dt", getLv3Dt());
        this.hashColumns.put("lv1_auth", getLv1Auth());
        this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
        this.hashColumns.put("lv5_auth", getLv5Auth());
        this.hashColumns.put("lv2_usr_nm", getLv2UsrNm());
        this.hashColumns.put("lv6_sts", getLv6Sts());
        this.hashColumns.put("lv1_usr_id", getLv1UsrId());
        this.hashColumns.put("aft_bkg_apro_no", getAftBkgAproNo());
        this.hashColumns.put("lv1_dt", getLv1Dt());
        this.hashColumns.put("lv5_dt", getLv5Dt());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("lv3_auth", getLv3Auth());
        this.hashColumns.put("dmdt_expt_rqst_sts_cd_desc", getDmdtExptRqstStsCdDesc());
        this.hashColumns.put("lv4_usr_id", getLv4UsrId());
        this.hashColumns.put("lv6_auth", getLv6Auth());
        this.hashColumns.put("rqst_usr_id", getRqstUsrId());
        this.hashColumns.put("lv3_usr_nm", getLv3UsrNm());
        this.hashColumns.put("lv1_usr_nm", getLv1UsrNm());
        this.hashColumns.put("lv6_dt", getLv6Dt());
        this.hashColumns.put("lv4_auth", getLv4Auth());
        this.hashColumns.put("lv6_ofc", getLv6Ofc());
        this.hashColumns.put("lv1_ofc", getLv1Ofc());
        this.hashColumns.put("lv5_sts", getLv5Sts());
        this.hashColumns.put("rfa_no", getRfaNo());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("aft_expt_dar_no", getAftExptDarNo());
        this.hashColumns.put("dmdt_expt_rqst_sts_cd", getDmdtExptRqstStsCd());
        this.hashColumns.put("lv2_auth", getLv2Auth());
        this.hashColumns.put("lv3_sts", getLv3Sts());
        this.hashColumns.put("lv6_usr_id", getLv6UsrId());
        this.hashColumns.put("final_apro_ofc_cd", getFinalAproOfcCd());
        this.hashColumns.put("lv4_ofc", getLv4Ofc());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("rqst_dt", getRqstDt());
        this.hashColumns.put("dmdt_ofc_cd", getDmdtOfcCd());
        this.hashColumns.put("rqst_usr_nm", getRqstUsrNm());
        this.hashColumns.put("lv3_ofc", getLv3Ofc());
        this.hashColumns.put("lv3_usr_id", getLv3UsrId());
        this.hashColumns.put("lv1_sts", getLv1Sts());
        this.hashColumns.put("lv2_ofc", getLv2Ofc());
        this.hashColumns.put("rqst_auth", getRqstAuth());
        this.hashColumns.put("lv6_usr_nm", getLv6UsrNm());
        this.hashColumns.put("taa_no", getTaaNo());
        this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
        this.hashColumns.put("lv5_usr_id", getLv5UsrId());
        this.hashColumns.put("lv4_sts", getLv4Sts());
        this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
        this.hashColumns.put("ctrt_cust_cd", getCtrtCustCd());
        this.hashColumns.put("ctrt_cust_nm", getCtrtCustNm());
        this.hashColumns.put("lv7_sts", getLv7Sts());
        this.hashColumns.put("lv7_auth", getLv7Auth());
        this.hashColumns.put("lv7_dt", getLv7Dt());
        this.hashColumns.put("lv7_ofc", getLv7Ofc());
        this.hashColumns.put("lv7_usr_id", getLv7UsrId());
        this.hashColumns.put("lv7_usr_nm", getLv7UsrNm());
        this.hashColumns.put("lv8_sts", getLv8Sts());
        this.hashColumns.put("lv8_auth", getLv8Auth());
        this.hashColumns.put("lv8_dt", getLv8Dt());
        this.hashColumns.put("lv8_ofc", getLv8Ofc());
        this.hashColumns.put("lv8_usr_id", getLv8UsrId());
        this.hashColumns.put("lv8_usr_nm", getLv8UsrNm());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("lv4_dt", "lv4Dt");
        this.hashFields.put("bl_no", "blNo");
        this.hashFields.put("lv5_usr_nm", "lv5UsrNm");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("lv2_sts", "lv2Sts");
        this.hashFields.put("lv4_usr_nm", "lv4UsrNm");
        this.hashFields.put("lv5_ofc", "lv5Ofc");
        this.hashFields.put("sc_no", "scNo");
        this.hashFields.put("lv2_usr_id", "lv2UsrId");
        this.hashFields.put("lv2_dt", "lv2Dt");
        this.hashFields.put("lv3_dt", "lv3Dt");
        this.hashFields.put("lv1_auth", "lv1Auth");
        this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
        this.hashFields.put("lv5_auth", "lv5Auth");
        this.hashFields.put("lv2_usr_nm", "lv2UsrNm");
        this.hashFields.put("lv6_sts", "lv6Sts");
        this.hashFields.put("lv1_usr_id", "lv1UsrId");
        this.hashFields.put("aft_bkg_apro_no", "aftBkgAproNo");
        this.hashFields.put("lv1_dt", "lv1Dt");
        this.hashFields.put("lv5_dt", "lv5Dt");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("lv3_auth", "lv3Auth");
        this.hashFields.put("dmdt_expt_rqst_sts_cd_desc", "dmdtExptRqstStsCdDesc");
        this.hashFields.put("lv4_usr_id", "lv4UsrId");
        this.hashFields.put("lv6_auth", "lv6Auth");
        this.hashFields.put("rqst_usr_id", "rqstUsrId");
        this.hashFields.put("lv3_usr_nm", "lv3UsrNm");
        this.hashFields.put("lv1_usr_nm", "lv1UsrNm");
        this.hashFields.put("lv6_dt", "lv6Dt");
        this.hashFields.put("lv4_auth", "lv4Auth");
        this.hashFields.put("lv6_ofc", "lv6Ofc");
        this.hashFields.put("lv1_ofc", "lv1Ofc");
        this.hashFields.put("lv5_sts", "lv5Sts");
        this.hashFields.put("rfa_no", "rfaNo");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("aft_expt_dar_no", "aftExptDarNo");
        this.hashFields.put("dmdt_expt_rqst_sts_cd", "dmdtExptRqstStsCd");
        this.hashFields.put("lv2_auth", "lv2Auth");
        this.hashFields.put("lv3_sts", "lv3Sts");
        this.hashFields.put("lv6_usr_id", "lv6UsrId");
        this.hashFields.put("final_apro_ofc_cd", "finalAproOfcCd");
        this.hashFields.put("lv4_ofc", "lv4Ofc");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("rqst_dt", "rqstDt");
        this.hashFields.put("dmdt_ofc_cd", "dmdtOfcCd");
        this.hashFields.put("rqst_usr_nm", "rqstUsrNm");
        this.hashFields.put("lv3_ofc", "lv3Ofc");
        this.hashFields.put("lv3_usr_id", "lv3UsrId");
        this.hashFields.put("lv1_sts", "lv1Sts");
        this.hashFields.put("lv2_ofc", "lv2Ofc");
        this.hashFields.put("rqst_auth", "rqstAuth");
        this.hashFields.put("lv6_usr_nm", "lv6UsrNm");
        this.hashFields.put("taa_no", "taaNo");
        this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
        this.hashFields.put("lv5_usr_id", "lv5UsrId");
        this.hashFields.put("lv4_sts", "lv4Sts");
        this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
        this.hashFields.put("ctrt_cust_cd", "ctrtCustCd");
        this.hashFields.put("ctrt_cust_nm", "ctrtCustNm");
        this.hashFields.put("lv7_sts", "lv7Sts");
        this.hashFields.put("lv7_auth", "lv7Auth");
        this.hashFields.put("lv7_dt", "lv7Dt");
        this.hashFields.put("lv7_ofc", "lv7Ofc");
        this.hashFields.put("lv7_usr_id", "lv7UsrId");
        this.hashFields.put("lv7_usr_nm", "lv7UsrNm");
        this.hashFields.put("lv8_sts", "lv8Sts");
        this.hashFields.put("lv8_auth", "lv8Auth");
        this.hashFields.put("lv8_dt", "lv8Dt");
        this.hashFields.put("lv8_ofc", "lv8Ofc");
        this.hashFields.put("lv8_usr_id", "lv8UsrId");
        this.hashFields.put("lv8_usr_nm", "lv8UsrNm");
        return this.hashFields;
    }

    public String getCtrtOfcCd() {
        return ctrtOfcCd;
    }

    public void setCtrtOfcCd(String ctrtOfcCd) {
        this.ctrtOfcCd = ctrtOfcCd;
    }

    public String getCtrtCustCd() {
        return ctrtCustCd;
    }

    public void setCtrtCustCd(String ctrtCustCd) {
        this.ctrtCustCd = ctrtCustCd;
    }

    public String getCtrtCustNm() {
        return ctrtCustNm;
    }

    public void setCtrtCustNm(String ctrtCustNm) {
        this.ctrtCustNm = ctrtCustNm;
    }

    /**
	 * Column Info
	 * @return lv4Dt
	 */
    public String getLv4Dt() {
        return this.lv4Dt;
    }

    /**
	 * Column Info
	 * @return blNo
	 */
    public String getBlNo() {
        return this.blNo;
    }

    /**
	 * Column Info
	 * @return lv5UsrNm
	 */
    public String getLv5UsrNm() {
        return this.lv5UsrNm;
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
	 * @return lv2Sts
	 */
    public String getLv2Sts() {
        return this.lv2Sts;
    }

    /**
	 * Column Info
	 * @return lv4UsrNm
	 */
    public String getLv4UsrNm() {
        return this.lv4UsrNm;
    }

    /**
	 * Column Info
	 * @return lv5Ofc
	 */
    public String getLv5Ofc() {
        return this.lv5Ofc;
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
	 * @return lv2UsrId
	 */
    public String getLv2UsrId() {
        return this.lv2UsrId;
    }

    /**
	 * Column Info
	 * @return lv2Dt
	 */
    public String getLv2Dt() {
        return this.lv2Dt;
    }

    /**
	 * Column Info
	 * @return lv3Dt
	 */
    public String getLv3Dt() {
        return this.lv3Dt;
    }

    /**
	 * Column Info
	 * @return lv1Auth
	 */
    public String getLv1Auth() {
        return this.lv1Auth;
    }

    /**
	 * Column Info
	 * @return dmdtTrfCd
	 */
    public String getDmdtTrfCd() {
        return this.dmdtTrfCd;
    }

    /**
	 * Column Info
	 * @return lv5Auth
	 */
    public String getLv5Auth() {
        return this.lv5Auth;
    }

    /**
	 * Column Info
	 * @return lv2UsrNm
	 */
    public String getLv2UsrNm() {
        return this.lv2UsrNm;
    }

    /**
	 * Column Info
	 * @return lv6Sts
	 */
    public String getLv6Sts() {
        return this.lv6Sts;
    }

    /**
	 * Column Info
	 * @return lv1UsrId
	 */
    public String getLv1UsrId() {
        return this.lv1UsrId;
    }

    /**
	 * Column Info
	 * @return aftBkgAproNo
	 */
    public String getAftBkgAproNo() {
        return this.aftBkgAproNo;
    }

    /**
	 * Column Info
	 * @return lv1Dt
	 */
    public String getLv1Dt() {
        return this.lv1Dt;
    }

    /**
	 * Column Info
	 * @return lv5Dt
	 */
    public String getLv5Dt() {
        return this.lv5Dt;
    }

    /**
	 * Column Info
	 * @return bkgNo
	 */
    public String getBkgNo() {
        return this.bkgNo;
    }

    /**
	 * Column Info
	 * @return lv3Auth
	 */
    public String getLv3Auth() {
        return this.lv3Auth;
    }

    /**
	 * Column Info
	 * @return dmdtExptRqstStsCdDesc
	 */
    public String getDmdtExptRqstStsCdDesc() {
        return this.dmdtExptRqstStsCdDesc;
    }

    /**
	 * Column Info
	 * @return lv4UsrId
	 */
    public String getLv4UsrId() {
        return this.lv4UsrId;
    }

    /**
	 * Column Info
	 * @return lv6Auth
	 */
    public String getLv6Auth() {
        return this.lv6Auth;
    }

    /**
	 * Column Info
	 * @return rqstUsrId
	 */
    public String getRqstUsrId() {
        return this.rqstUsrId;
    }

    /**
	 * Column Info
	 * @return lv3UsrNm
	 */
    public String getLv3UsrNm() {
        return this.lv3UsrNm;
    }

    /**
	 * Column Info
	 * @return lv1UsrNm
	 */
    public String getLv1UsrNm() {
        return this.lv1UsrNm;
    }

    /**
	 * Column Info
	 * @return lv6Dt
	 */
    public String getLv6Dt() {
        return this.lv6Dt;
    }

    /**
	 * Column Info
	 * @return lv4Auth
	 */
    public String getLv4Auth() {
        return this.lv4Auth;
    }

    /**
	 * Column Info
	 * @return lv6Ofc
	 */
    public String getLv6Ofc() {
        return this.lv6Ofc;
    }

    /**
	 * Column Info
	 * @return lv1Ofc
	 */
    public String getLv1Ofc() {
        return this.lv1Ofc;
    }

    /**
	 * Column Info
	 * @return lv5Sts
	 */
    public String getLv5Sts() {
        return this.lv5Sts;
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
	 * @return aftExptDarNo
	 */
    public String getAftExptDarNo() {
        return this.aftExptDarNo;
    }

    /**
	 * Column Info
	 * @return dmdtExptRqstStsCd
	 */
    public String getDmdtExptRqstStsCd() {
        return this.dmdtExptRqstStsCd;
    }

    /**
	 * Column Info
	 * @return lv2Auth
	 */
    public String getLv2Auth() {
        return this.lv2Auth;
    }

    /**
	 * Column Info
	 * @return lv3Sts
	 */
    public String getLv3Sts() {
        return this.lv3Sts;
    }

    /**
	 * Column Info
	 * @return lv6UsrId
	 */
    public String getLv6UsrId() {
        return this.lv6UsrId;
    }

    /**
	 * Column Info
	 * @return finalAproOfcCd
	 */
    public String getFinalAproOfcCd() {
        return this.finalAproOfcCd;
    }

    /**
	 * Column Info
	 * @return lv4Ofc
	 */
    public String getLv4Ofc() {
        return this.lv4Ofc;
    }

    /**
	 * Column Info
	 * @return updDt
	 */
    public String getUpdDt() {
        return this.updDt;
    }

    /**
	 * Column Info
	 * @return rqstDt
	 */
    public String getRqstDt() {
        return this.rqstDt;
    }

    /**
	 * Column Info
	 * @return dmdtOfcCd
	 */
    public String getDmdtOfcCd() {
        return this.dmdtOfcCd;
    }

    /**
	 * Column Info
	 * @return rqstUsrNm
	 */
    public String getRqstUsrNm() {
        return this.rqstUsrNm;
    }

    /**
	 * Column Info
	 * @return lv3Ofc
	 */
    public String getLv3Ofc() {
        return this.lv3Ofc;
    }

    /**
	 * Column Info
	 * @return lv3UsrId
	 */
    public String getLv3UsrId() {
        return this.lv3UsrId;
    }

    /**
	 * Column Info
	 * @return lv1Sts
	 */
    public String getLv1Sts() {
        return this.lv1Sts;
    }

    /**
	 * Column Info
	 * @return lv2Ofc
	 */
    public String getLv2Ofc() {
        return this.lv2Ofc;
    }

    /**
	 * Column Info
	 * @return rqstAuth
	 */
    public String getRqstAuth() {
        return this.rqstAuth;
    }

    /**
	 * Column Info
	 * @return lv6UsrNm
	 */
    public String getLv6UsrNm() {
        return this.lv6UsrNm;
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
	 * @return rqstOfcCd
	 */
    public String getRqstOfcCd() {
        return this.rqstOfcCd;
    }

    /**
	 * Column Info
	 * @return lv5UsrId
	 */
    public String getLv5UsrId() {
        return this.lv5UsrId;
    }

    /**
	 * Column Info
	 * @return lv4Sts
	 */
    public String getLv4Sts() {
        return this.lv4Sts;
    }

    /**
	 * Column Info
	 * @param lv4Dt
	 */
    public void setLv4Dt(String lv4Dt) {
        this.lv4Dt = lv4Dt;
    }

    /**
	 * Column Info
	 * @param blNo
	 */
    public void setBlNo(String blNo) {
        this.blNo = blNo;
    }

    /**
	 * Column Info
	 * @param lv5UsrNm
	 */
    public void setLv5UsrNm(String lv5UsrNm) {
        this.lv5UsrNm = lv5UsrNm;
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
	 * @param lv2Sts
	 */
    public void setLv2Sts(String lv2Sts) {
        this.lv2Sts = lv2Sts;
    }

    /**
	 * Column Info
	 * @param lv4UsrNm
	 */
    public void setLv4UsrNm(String lv4UsrNm) {
        this.lv4UsrNm = lv4UsrNm;
    }

    /**
	 * Column Info
	 * @param lv5Ofc
	 */
    public void setLv5Ofc(String lv5Ofc) {
        this.lv5Ofc = lv5Ofc;
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
	 * @param lv2UsrId
	 */
    public void setLv2UsrId(String lv2UsrId) {
        this.lv2UsrId = lv2UsrId;
    }

    /**
	 * Column Info
	 * @param lv2Dt
	 */
    public void setLv2Dt(String lv2Dt) {
        this.lv2Dt = lv2Dt;
    }

    /**
	 * Column Info
	 * @param lv3Dt
	 */
    public void setLv3Dt(String lv3Dt) {
        this.lv3Dt = lv3Dt;
    }

    /**
	 * Column Info
	 * @param lv1Auth
	 */
    public void setLv1Auth(String lv1Auth) {
        this.lv1Auth = lv1Auth;
    }

    /**
	 * Column Info
	 * @param dmdtTrfCd
	 */
    public void setDmdtTrfCd(String dmdtTrfCd) {
        this.dmdtTrfCd = dmdtTrfCd;
    }

    /**
	 * Column Info
	 * @param lv5Auth
	 */
    public void setLv5Auth(String lv5Auth) {
        this.lv5Auth = lv5Auth;
    }

    /**
	 * Column Info
	 * @param lv2UsrNm
	 */
    public void setLv2UsrNm(String lv2UsrNm) {
        this.lv2UsrNm = lv2UsrNm;
    }

    /**
	 * Column Info
	 * @param lv6Sts
	 */
    public void setLv6Sts(String lv6Sts) {
        this.lv6Sts = lv6Sts;
    }

    /**
	 * Column Info
	 * @param lv1UsrId
	 */
    public void setLv1UsrId(String lv1UsrId) {
        this.lv1UsrId = lv1UsrId;
    }

    /**
	 * Column Info
	 * @param aftBkgAproNo
	 */
    public void setAftBkgAproNo(String aftBkgAproNo) {
        this.aftBkgAproNo = aftBkgAproNo;
    }

    /**
	 * Column Info
	 * @param lv1Dt
	 */
    public void setLv1Dt(String lv1Dt) {
        this.lv1Dt = lv1Dt;
    }

    /**
	 * Column Info
	 * @param lv5Dt
	 */
    public void setLv5Dt(String lv5Dt) {
        this.lv5Dt = lv5Dt;
    }

    /**
	 * Column Info
	 * @param bkgNo
	 */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    /**
	 * Column Info
	 * @param lv3Auth
	 */
    public void setLv3Auth(String lv3Auth) {
        this.lv3Auth = lv3Auth;
    }

    /**
	 * Column Info
	 * @param dmdtExptRqstStsCdDesc
	 */
    public void setDmdtExptRqstStsCdDesc(String dmdtExptRqstStsCdDesc) {
        this.dmdtExptRqstStsCdDesc = dmdtExptRqstStsCdDesc;
    }

    /**
	 * Column Info
	 * @param lv4UsrId
	 */
    public void setLv4UsrId(String lv4UsrId) {
        this.lv4UsrId = lv4UsrId;
    }

    /**
	 * Column Info
	 * @param lv6Auth
	 */
    public void setLv6Auth(String lv6Auth) {
        this.lv6Auth = lv6Auth;
    }

    /**
	 * Column Info
	 * @param rqstUsrId
	 */
    public void setRqstUsrId(String rqstUsrId) {
        this.rqstUsrId = rqstUsrId;
    }

    /**
	 * Column Info
	 * @param lv3UsrNm
	 */
    public void setLv3UsrNm(String lv3UsrNm) {
        this.lv3UsrNm = lv3UsrNm;
    }

    /**
	 * Column Info
	 * @param lv1UsrNm
	 */
    public void setLv1UsrNm(String lv1UsrNm) {
        this.lv1UsrNm = lv1UsrNm;
    }

    /**
	 * Column Info
	 * @param lv6Dt
	 */
    public void setLv6Dt(String lv6Dt) {
        this.lv6Dt = lv6Dt;
    }

    /**
	 * Column Info
	 * @param lv4Auth
	 */
    public void setLv4Auth(String lv4Auth) {
        this.lv4Auth = lv4Auth;
    }

    /**
	 * Column Info
	 * @param lv6Ofc
	 */
    public void setLv6Ofc(String lv6Ofc) {
        this.lv6Ofc = lv6Ofc;
    }

    /**
	 * Column Info
	 * @param lv1Ofc
	 */
    public void setLv1Ofc(String lv1Ofc) {
        this.lv1Ofc = lv1Ofc;
    }

    /**
	 * Column Info
	 * @param lv5Sts
	 */
    public void setLv5Sts(String lv5Sts) {
        this.lv5Sts = lv5Sts;
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
	 * @param aftExptDarNo
	 */
    public void setAftExptDarNo(String aftExptDarNo) {
        this.aftExptDarNo = aftExptDarNo;
    }

    /**
	 * Column Info
	 * @param dmdtExptRqstStsCd
	 */
    public void setDmdtExptRqstStsCd(String dmdtExptRqstStsCd) {
        this.dmdtExptRqstStsCd = dmdtExptRqstStsCd;
    }

    /**
	 * Column Info
	 * @param lv2Auth
	 */
    public void setLv2Auth(String lv2Auth) {
        this.lv2Auth = lv2Auth;
    }

    /**
	 * Column Info
	 * @param lv3Sts
	 */
    public void setLv3Sts(String lv3Sts) {
        this.lv3Sts = lv3Sts;
    }

    /**
	 * Column Info
	 * @param lv6UsrId
	 */
    public void setLv6UsrId(String lv6UsrId) {
        this.lv6UsrId = lv6UsrId;
    }

    /**
	 * Column Info
	 * @param finalAproOfcCd
	 */
    public void setFinalAproOfcCd(String finalAproOfcCd) {
        this.finalAproOfcCd = finalAproOfcCd;
    }

    /**
	 * Column Info
	 * @param lv4Ofc
	 */
    public void setLv4Ofc(String lv4Ofc) {
        this.lv4Ofc = lv4Ofc;
    }

    /**
	 * Column Info
	 * @param updDt
	 */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
	 * Column Info
	 * @param rqstDt
	 */
    public void setRqstDt(String rqstDt) {
        this.rqstDt = rqstDt;
    }

    /**
	 * Column Info
	 * @param dmdtOfcCd
	 */
    public void setDmdtOfcCd(String dmdtOfcCd) {
        this.dmdtOfcCd = dmdtOfcCd;
    }

    /**
	 * Column Info
	 * @param rqstUsrNm
	 */
    public void setRqstUsrNm(String rqstUsrNm) {
        this.rqstUsrNm = rqstUsrNm;
    }

    /**
	 * Column Info
	 * @param lv3Ofc
	 */
    public void setLv3Ofc(String lv3Ofc) {
        this.lv3Ofc = lv3Ofc;
    }

    /**
	 * Column Info
	 * @param lv3UsrId
	 */
    public void setLv3UsrId(String lv3UsrId) {
        this.lv3UsrId = lv3UsrId;
    }

    /**
	 * Column Info
	 * @param lv1Sts
	 */
    public void setLv1Sts(String lv1Sts) {
        this.lv1Sts = lv1Sts;
    }

    /**
	 * Column Info
	 * @param lv2Ofc
	 */
    public void setLv2Ofc(String lv2Ofc) {
        this.lv2Ofc = lv2Ofc;
    }

    /**
	 * Column Info
	 * @param rqstAuth
	 */
    public void setRqstAuth(String rqstAuth) {
        this.rqstAuth = rqstAuth;
    }

    /**
	 * Column Info
	 * @param lv6UsrNm
	 */
    public void setLv6UsrNm(String lv6UsrNm) {
        this.lv6UsrNm = lv6UsrNm;
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
	 * @param rqstOfcCd
	 */
    public void setRqstOfcCd(String rqstOfcCd) {
        this.rqstOfcCd = rqstOfcCd;
    }

    /**
	 * Column Info
	 * @param lv5UsrId
	 */
    public void setLv5UsrId(String lv5UsrId) {
        this.lv5UsrId = lv5UsrId;
    }

    /**
	 * Column Info
	 * @param lv4Sts
	 */
    public void setLv4Sts(String lv4Sts) {
        this.lv4Sts = lv4Sts;
    }

    public String getLv7Sts() {
        return lv7Sts;
    }

    public void setLv7Sts(String lv7Sts) {
        this.lv7Sts = lv7Sts;
    }

    public String getLv7Auth() {
        return lv7Auth;
    }

    public void setLv7Auth(String lv7Auth) {
        this.lv7Auth = lv7Auth;
    }

    public String getLv7Dt() {
        return lv7Dt;
    }

    public void setLv7Dt(String lv7Dt) {
        this.lv7Dt = lv7Dt;
    }

    public String getLv7Ofc() {
        return lv7Ofc;
    }

    public void setLv7Ofc(String lv7Ofc) {
        this.lv7Ofc = lv7Ofc;
    }

    public String getLv7UsrId() {
        return lv7UsrId;
    }

    public void setLv7UsrId(String lv7UsrId) {
        this.lv7UsrId = lv7UsrId;
    }

    public String getLv7UsrNm() {
        return lv7UsrNm;
    }

    public void setLv7UsrNm(String lv7UsrNm) {
        this.lv7UsrNm = lv7UsrNm;
    }

    public void setLv8Sts(String lv8Sts) {
        this.lv8Sts = lv8Sts;
    }

    public String getLv8Sts() {
        return this.lv8Sts;
    }

    public void setLv8Auth(String lv8Auth) {
        this.lv8Auth = lv8Auth;
    }

    public String getLv8Auth() {
        return this.lv8Auth;
    }

    public void setLv8Dt(String lv8Dt) {
        this.lv8Dt = lv8Dt;
    }

    public String getLv8Dt() {
        return this.lv8Dt;
    }

    public void setLv8Ofc(String lv8Ofc) {
        this.lv8Ofc = lv8Ofc;
    }

    public String getLv8Ofc() {
        return this.lv8Ofc;
    }

    public void setLv8UsrId(String lv8UsrId) {
        this.lv8UsrId = lv8UsrId;
    }

    public String getLv8UsrId() {
        return this.lv8UsrId;
    }

    public void setLv8UsrNm(String lv8UsrNm) {
        this.lv8UsrNm = lv8UsrNm;
    }

    public String getLv8UsrNm() {
        return this.lv8UsrNm;
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
        setLv4Dt(JSPUtil.getParameter(request, prefix + "lv4_dt", ""));
        setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
        setLv5UsrNm(JSPUtil.getParameter(request, prefix + "lv5_usr_nm", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setLv2Sts(JSPUtil.getParameter(request, prefix + "lv2_sts", ""));
        setLv4UsrNm(JSPUtil.getParameter(request, prefix + "lv4_usr_nm", ""));
        setLv5Ofc(JSPUtil.getParameter(request, prefix + "lv5_ofc", ""));
        setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
        setLv2UsrId(JSPUtil.getParameter(request, prefix + "lv2_usr_id", ""));
        setLv2Dt(JSPUtil.getParameter(request, prefix + "lv2_dt", ""));
        setLv3Dt(JSPUtil.getParameter(request, prefix + "lv3_dt", ""));
        setLv1Auth(JSPUtil.getParameter(request, prefix + "lv1_auth", ""));
        setDmdtTrfCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", ""));
        setLv5Auth(JSPUtil.getParameter(request, prefix + "lv5_auth", ""));
        setLv2UsrNm(JSPUtil.getParameter(request, prefix + "lv2_usr_nm", ""));
        setLv6Sts(JSPUtil.getParameter(request, prefix + "lv6_sts", ""));
        setLv1UsrId(JSPUtil.getParameter(request, prefix + "lv1_usr_id", ""));
        setAftBkgAproNo(JSPUtil.getParameter(request, prefix + "aft_bkg_apro_no", ""));
        setLv1Dt(JSPUtil.getParameter(request, prefix + "lv1_dt", ""));
        setLv5Dt(JSPUtil.getParameter(request, prefix + "lv5_dt", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setLv3Auth(JSPUtil.getParameter(request, prefix + "lv3_auth", ""));
        setDmdtExptRqstStsCdDesc(JSPUtil.getParameter(request, prefix + "dmdt_expt_rqst_sts_cd_desc", ""));
        setLv4UsrId(JSPUtil.getParameter(request, prefix + "lv4_usr_id", ""));
        setLv6Auth(JSPUtil.getParameter(request, prefix + "lv6_auth", ""));
        setRqstUsrId(JSPUtil.getParameter(request, prefix + "rqst_usr_id", ""));
        setLv3UsrNm(JSPUtil.getParameter(request, prefix + "lv3_usr_nm", ""));
        setLv1UsrNm(JSPUtil.getParameter(request, prefix + "lv1_usr_nm", ""));
        setLv6Dt(JSPUtil.getParameter(request, prefix + "lv6_dt", ""));
        setLv4Auth(JSPUtil.getParameter(request, prefix + "lv4_auth", ""));
        setLv6Ofc(JSPUtil.getParameter(request, prefix + "lv6_ofc", ""));
        setLv1Ofc(JSPUtil.getParameter(request, prefix + "lv1_ofc", ""));
        setLv5Sts(JSPUtil.getParameter(request, prefix + "lv5_sts", ""));
        setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setAftExptDarNo(JSPUtil.getParameter(request, prefix + "aft_expt_dar_no", ""));
        setDmdtExptRqstStsCd(JSPUtil.getParameter(request, prefix + "dmdt_expt_rqst_sts_cd", ""));
        setLv2Auth(JSPUtil.getParameter(request, prefix + "lv2_auth", ""));
        setLv3Sts(JSPUtil.getParameter(request, prefix + "lv3_sts", ""));
        setLv6UsrId(JSPUtil.getParameter(request, prefix + "lv6_usr_id", ""));
        setFinalAproOfcCd(JSPUtil.getParameter(request, prefix + "final_apro_ofc_cd", ""));
        setLv4Ofc(JSPUtil.getParameter(request, prefix + "lv4_ofc", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
        setDmdtOfcCd(JSPUtil.getParameter(request, prefix + "dmdt_ofc_cd", ""));
        setRqstUsrNm(JSPUtil.getParameter(request, prefix + "rqst_usr_nm", ""));
        setLv3Ofc(JSPUtil.getParameter(request, prefix + "lv3_ofc", ""));
        setLv3UsrId(JSPUtil.getParameter(request, prefix + "lv3_usr_id", ""));
        setLv1Sts(JSPUtil.getParameter(request, prefix + "lv1_sts", ""));
        setLv2Ofc(JSPUtil.getParameter(request, prefix + "lv2_ofc", ""));
        setRqstAuth(JSPUtil.getParameter(request, prefix + "rqst_auth", ""));
        setLv6UsrNm(JSPUtil.getParameter(request, prefix + "lv6_usr_nm", ""));
        setTaaNo(JSPUtil.getParameter(request, prefix + "taa_no", ""));
        setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
        setLv5UsrId(JSPUtil.getParameter(request, prefix + "lv5_usr_id", ""));
        setLv4Sts(JSPUtil.getParameter(request, prefix + "lv4_sts", ""));
        setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
        setCtrtCustCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_cd", ""));
        setCtrtCustNm(JSPUtil.getParameter(request, prefix + "ctrt_cust_nm", ""));
        setLv7Sts(JSPUtil.getParameter(request, prefix + "lv7_sts", ""));
        setLv7Auth(JSPUtil.getParameter(request, prefix + "lv7_auth", ""));
        setLv7Dt(JSPUtil.getParameter(request, prefix + "lv7_dt", ""));
        setLv7Ofc(JSPUtil.getParameter(request, prefix + "lv7_ofc", ""));
        setLv7UsrId(JSPUtil.getParameter(request, prefix + "lv7_usr_id", ""));
        setLv7UsrNm(JSPUtil.getParameter(request, prefix + "lv7_usr_nm", ""));
        setLv8Sts(JSPUtil.getParameter(request, prefix + "lv8_sts", ""));
        setLv8Auth(JSPUtil.getParameter(request, prefix + "lv8_auth", ""));
        setLv8Dt(JSPUtil.getParameter(request, prefix + "lv_8dt", ""));
        setLv8Ofc(JSPUtil.getParameter(request, prefix + "lv8_ofc", ""));
        setLv8UsrId(JSPUtil.getParameter(request, prefix + "lv8_usr_id", ""));
        setLv8UsrNm(JSPUtil.getParameter(request, prefix + "lv8_usr_nm", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AfterBkgRqstAproStsVO[]
	 */
    public AfterBkgRqstAproStsVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AfterBkgRqstAproStsVO[]
	 */
    public AfterBkgRqstAproStsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        AfterBkgRqstAproStsVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] lv4Dt = (JSPUtil.getParameter(request, prefix + "lv4_dt", length));
            String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
            String[] lv5UsrNm = (JSPUtil.getParameter(request, prefix + "lv5_usr_nm", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] lv2Sts = (JSPUtil.getParameter(request, prefix + "lv2_sts", length));
            String[] lv4UsrNm = (JSPUtil.getParameter(request, prefix + "lv4_usr_nm", length));
            String[] lv5Ofc = (JSPUtil.getParameter(request, prefix + "lv5_ofc", length));
            String[] scNo = (JSPUtil.getParameter(request, prefix + "sc_no", length));
            String[] lv2UsrId = (JSPUtil.getParameter(request, prefix + "lv2_usr_id", length));
            String[] lv2Dt = (JSPUtil.getParameter(request, prefix + "lv2_dt", length));
            String[] lv3Dt = (JSPUtil.getParameter(request, prefix + "lv3_dt", length));
            String[] lv1Auth = (JSPUtil.getParameter(request, prefix + "lv1_auth", length));
            String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", length));
            String[] lv5Auth = (JSPUtil.getParameter(request, prefix + "lv5_auth", length));
            String[] lv2UsrNm = (JSPUtil.getParameter(request, prefix + "lv2_usr_nm", length));
            String[] lv6Sts = (JSPUtil.getParameter(request, prefix + "lv6_sts", length));
            String[] lv1UsrId = (JSPUtil.getParameter(request, prefix + "lv1_usr_id", length));
            String[] aftBkgAproNo = (JSPUtil.getParameter(request, prefix + "aft_bkg_apro_no", length));
            String[] lv1Dt = (JSPUtil.getParameter(request, prefix + "lv1_dt", length));
            String[] lv5Dt = (JSPUtil.getParameter(request, prefix + "lv5_dt", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] lv3Auth = (JSPUtil.getParameter(request, prefix + "lv3_auth", length));
            String[] dmdtExptRqstStsCdDesc = (JSPUtil.getParameter(request, prefix + "dmdt_expt_rqst_sts_cd_desc", length));
            String[] lv4UsrId = (JSPUtil.getParameter(request, prefix + "lv4_usr_id", length));
            String[] lv6Auth = (JSPUtil.getParameter(request, prefix + "lv6_auth", length));
            String[] rqstUsrId = (JSPUtil.getParameter(request, prefix + "rqst_usr_id", length));
            String[] lv3UsrNm = (JSPUtil.getParameter(request, prefix + "lv3_usr_nm", length));
            String[] lv1UsrNm = (JSPUtil.getParameter(request, prefix + "lv1_usr_nm", length));
            String[] lv6Dt = (JSPUtil.getParameter(request, prefix + "lv6_dt", length));
            String[] lv4Auth = (JSPUtil.getParameter(request, prefix + "lv4_auth", length));
            String[] lv6Ofc = (JSPUtil.getParameter(request, prefix + "lv6_ofc", length));
            String[] lv1Ofc = (JSPUtil.getParameter(request, prefix + "lv1_ofc", length));
            String[] lv5Sts = (JSPUtil.getParameter(request, prefix + "lv5_sts", length));
            String[] rfaNo = (JSPUtil.getParameter(request, prefix + "rfa_no", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] aftExptDarNo = (JSPUtil.getParameter(request, prefix + "aft_expt_dar_no", length));
            String[] dmdtExptRqstStsCd = (JSPUtil.getParameter(request, prefix + "dmdt_expt_rqst_sts_cd", length));
            String[] lv2Auth = (JSPUtil.getParameter(request, prefix + "lv2_auth", length));
            String[] lv3Sts = (JSPUtil.getParameter(request, prefix + "lv3_sts", length));
            String[] lv6UsrId = (JSPUtil.getParameter(request, prefix + "lv6_usr_id", length));
            String[] finalAproOfcCd = (JSPUtil.getParameter(request, prefix + "final_apro_ofc_cd", length));
            String[] lv4Ofc = (JSPUtil.getParameter(request, prefix + "lv4_ofc", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] rqstDt = (JSPUtil.getParameter(request, prefix + "rqst_dt", length));
            String[] dmdtOfcCd = (JSPUtil.getParameter(request, prefix + "dmdt_ofc_cd", length));
            String[] rqstUsrNm = (JSPUtil.getParameter(request, prefix + "rqst_usr_nm", length));
            String[] lv3Ofc = (JSPUtil.getParameter(request, prefix + "lv3_ofc", length));
            String[] lv3UsrId = (JSPUtil.getParameter(request, prefix + "lv3_usr_id", length));
            String[] lv1Sts = (JSPUtil.getParameter(request, prefix + "lv1_sts", length));
            String[] lv2Ofc = (JSPUtil.getParameter(request, prefix + "lv2_ofc", length));
            String[] rqstAuth = (JSPUtil.getParameter(request, prefix + "rqst_auth", length));
            String[] lv6UsrNm = (JSPUtil.getParameter(request, prefix + "lv6_usr_nm", length));
            String[] taaNo = (JSPUtil.getParameter(request, prefix + "taa_no", length));
            String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", length));
            String[] lv5UsrId = (JSPUtil.getParameter(request, prefix + "lv5_usr_id", length));
            String[] lv4Sts = (JSPUtil.getParameter(request, prefix + "lv4_sts", length));
            String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", length));
            String[] ctrtCustCd = (JSPUtil.getParameter(request, prefix + "ctrt_cust_cd", length));
            String[] ctrtCustNm = (JSPUtil.getParameter(request, prefix + "ctrt_cust_nm", length));
            String[] lv7Sts = (JSPUtil.getParameter(request, prefix + "lv7_sts", length));
            String[] lv7Auth = (JSPUtil.getParameter(request, prefix + "lv7_auth", length));
            String[] lv7Dt = (JSPUtil.getParameter(request, prefix + "lv7_dt", length));
            String[] lv7Ofc = (JSPUtil.getParameter(request, prefix + "lv7_ofc", length));
            String[] lv7UsrId = (JSPUtil.getParameter(request, prefix + "lv7_usr_id", length));
            String[] lv7UsrNm = (JSPUtil.getParameter(request, prefix + "lv7_usr_nm", length));
            String[] lv8Sts = (JSPUtil.getParameter(request, prefix + "lv8_sts", length));
	    	String[] lv8Auth = (JSPUtil.getParameter(request, prefix + "lv8_auth", length));
	    	String[] lv8Dt = (JSPUtil.getParameter(request, prefix + "lv8_dt", length));
	    	String[] lv8Ofc = (JSPUtil.getParameter(request, prefix + "lv8_ofc", length));
	    	String[] lv8UsrId = (JSPUtil.getParameter(request, prefix + "lv8_usr_id", length));
	    	String[] lv8UsrNm = (JSPUtil.getParameter(request, prefix + "lv8_usr_nm", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new AfterBkgRqstAproStsVO();
                if (lv4Dt[i] != null)
                    model.setLv4Dt(lv4Dt[i]);
                if (blNo[i] != null)
                    model.setBlNo(blNo[i]);
                if (lv5UsrNm[i] != null)
                    model.setLv5UsrNm(lv5UsrNm[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (lv2Sts[i] != null)
                    model.setLv2Sts(lv2Sts[i]);
                if (lv4UsrNm[i] != null)
                    model.setLv4UsrNm(lv4UsrNm[i]);
                if (lv5Ofc[i] != null)
                    model.setLv5Ofc(lv5Ofc[i]);
                if (scNo[i] != null)
                    model.setScNo(scNo[i]);
                if (lv2UsrId[i] != null)
                    model.setLv2UsrId(lv2UsrId[i]);
                if (lv2Dt[i] != null)
                    model.setLv2Dt(lv2Dt[i]);
                if (lv3Dt[i] != null)
                    model.setLv3Dt(lv3Dt[i]);
                if (lv1Auth[i] != null)
                    model.setLv1Auth(lv1Auth[i]);
                if (dmdtTrfCd[i] != null)
                    model.setDmdtTrfCd(dmdtTrfCd[i]);
                if (lv5Auth[i] != null)
                    model.setLv5Auth(lv5Auth[i]);
                if (lv2UsrNm[i] != null)
                    model.setLv2UsrNm(lv2UsrNm[i]);
                if (lv6Sts[i] != null)
                    model.setLv6Sts(lv6Sts[i]);
                if (lv1UsrId[i] != null)
                    model.setLv1UsrId(lv1UsrId[i]);
                if (aftBkgAproNo[i] != null)
                    model.setAftBkgAproNo(aftBkgAproNo[i]);
                if (lv1Dt[i] != null)
                    model.setLv1Dt(lv1Dt[i]);
                if (lv5Dt[i] != null)
                    model.setLv5Dt(lv5Dt[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (lv3Auth[i] != null)
                    model.setLv3Auth(lv3Auth[i]);
                if (dmdtExptRqstStsCdDesc[i] != null)
                    model.setDmdtExptRqstStsCdDesc(dmdtExptRqstStsCdDesc[i]);
                if (lv4UsrId[i] != null)
                    model.setLv4UsrId(lv4UsrId[i]);
                if (lv6Auth[i] != null)
                    model.setLv6Auth(lv6Auth[i]);
                if (rqstUsrId[i] != null)
                    model.setRqstUsrId(rqstUsrId[i]);
                if (lv3UsrNm[i] != null)
                    model.setLv3UsrNm(lv3UsrNm[i]);
                if (lv1UsrNm[i] != null)
                    model.setLv1UsrNm(lv1UsrNm[i]);
                if (lv6Dt[i] != null)
                    model.setLv6Dt(lv6Dt[i]);
                if (lv4Auth[i] != null)
                    model.setLv4Auth(lv4Auth[i]);
                if (lv6Ofc[i] != null)
                    model.setLv6Ofc(lv6Ofc[i]);
                if (lv1Ofc[i] != null)
                    model.setLv1Ofc(lv1Ofc[i]);
                if (lv5Sts[i] != null)
                    model.setLv5Sts(lv5Sts[i]);
                if (rfaNo[i] != null)
                    model.setRfaNo(rfaNo[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (aftExptDarNo[i] != null)
                    model.setAftExptDarNo(aftExptDarNo[i]);
                if (dmdtExptRqstStsCd[i] != null)
                    model.setDmdtExptRqstStsCd(dmdtExptRqstStsCd[i]);
                if (lv2Auth[i] != null)
                    model.setLv2Auth(lv2Auth[i]);
                if (lv3Sts[i] != null)
                    model.setLv3Sts(lv3Sts[i]);
                if (lv6UsrId[i] != null)
                    model.setLv6UsrId(lv6UsrId[i]);
                if (finalAproOfcCd[i] != null)
                    model.setFinalAproOfcCd(finalAproOfcCd[i]);
                if (lv4Ofc[i] != null)
                    model.setLv4Ofc(lv4Ofc[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (rqstDt[i] != null)
                    model.setRqstDt(rqstDt[i]);
                if (dmdtOfcCd[i] != null)
                    model.setDmdtOfcCd(dmdtOfcCd[i]);
                if (rqstUsrNm[i] != null)
                    model.setRqstUsrNm(rqstUsrNm[i]);
                if (lv3Ofc[i] != null)
                    model.setLv3Ofc(lv3Ofc[i]);
                if (lv3UsrId[i] != null)
                    model.setLv3UsrId(lv3UsrId[i]);
                if (lv1Sts[i] != null)
                    model.setLv1Sts(lv1Sts[i]);
                if (lv2Ofc[i] != null)
                    model.setLv2Ofc(lv2Ofc[i]);
                if (rqstAuth[i] != null)
                    model.setRqstAuth(rqstAuth[i]);
                if (lv6UsrNm[i] != null)
                    model.setLv6UsrNm(lv6UsrNm[i]);
                if (taaNo[i] != null)
                    model.setTaaNo(taaNo[i]);
                if (rqstOfcCd[i] != null)
                    model.setRqstOfcCd(rqstOfcCd[i]);
                if (lv5UsrId[i] != null)
                    model.setLv5UsrId(lv5UsrId[i]);
                if (lv4Sts[i] != null)
                    model.setLv4Sts(lv4Sts[i]);
                if (ctrtOfcCd[i] != null)
                    model.setCtrtOfcCd(ctrtOfcCd[i]);
                if (ctrtCustCd[i] != null)
                    model.setCtrtCustCd(ctrtCustCd[i]);
                if (ctrtCustNm[i] != null)
                    model.setCtrtCustNm(ctrtCustNm[i]);
                if (lv7Sts[i] != null)
                    model.setLv7Sts(lv7Sts[i]);
                if (lv7Auth[i] != null)
                    model.setLv7Auth(lv7Auth[i]);
                if (lv7Dt[i] != null)
                    model.setLv7Dt(lv7Dt[i]);
                if (lv7Ofc[i] != null)
                    model.setLv7Ofc(lv7Ofc[i]);
                if (lv7UsrId[i] != null)
                    model.setLv7UsrId(lv7UsrId[i]);
                if (lv7UsrNm[i] != null)
                    model.setLv7UsrNm(lv7UsrNm[i]);
                if (lv8Sts[i] != null) 
		    		model.setLv8Sts(lv8Sts[i]);
				if (lv8Auth[i] != null) 
		    		model.setLv8Auth(lv8Auth[i]);
				if (lv8Dt[i] != null) 
		    		model.setLv8Dt(lv8Dt[i]);
				if (lv8Ofc[i] != null) 
		    		model.setLv8Ofc(lv8Ofc[i]);
				if (lv8UsrId[i] != null) 
		    		model.setLv8UsrId(lv8UsrId[i]);
				if (lv8UsrNm[i] != null) 
		    		model.setLv8UsrNm(lv8UsrNm[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getAfterBkgRqstAproStsVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return AfterBkgRqstAproStsVO[]
	 */
    public AfterBkgRqstAproStsVO[] getAfterBkgRqstAproStsVOs() {
        AfterBkgRqstAproStsVO[] vos = (AfterBkgRqstAproStsVO[]) models.toArray(new AfterBkgRqstAproStsVO[models.size()]);
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
        this.lv4Dt = this.lv4Dt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv5UsrNm = this.lv5UsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv2Sts = this.lv2Sts.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv4UsrNm = this.lv4UsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv5Ofc = this.lv5Ofc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scNo = this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv2UsrId = this.lv2UsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv2Dt = this.lv2Dt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv3Dt = this.lv3Dt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv1Auth = this.lv1Auth.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtTrfCd = this.dmdtTrfCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv5Auth = this.lv5Auth.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv2UsrNm = this.lv2UsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv6Sts = this.lv6Sts.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv1UsrId = this.lv1UsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aftBkgAproNo = this.aftBkgAproNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv1Dt = this.lv1Dt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv5Dt = this.lv5Dt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv3Auth = this.lv3Auth.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtExptRqstStsCdDesc = this.dmdtExptRqstStsCdDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv4UsrId = this.lv4UsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv6Auth = this.lv6Auth.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstUsrId = this.rqstUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv3UsrNm = this.lv3UsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv1UsrNm = this.lv1UsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv6Dt = this.lv6Dt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv4Auth = this.lv4Auth.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv6Ofc = this.lv6Ofc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv1Ofc = this.lv1Ofc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv5Sts = this.lv5Sts.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfaNo = this.rfaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aftExptDarNo = this.aftExptDarNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtExptRqstStsCd = this.dmdtExptRqstStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv2Auth = this.lv2Auth.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv3Sts = this.lv3Sts.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv6UsrId = this.lv6UsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.finalAproOfcCd = this.finalAproOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv4Ofc = this.lv4Ofc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstDt = this.rqstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtOfcCd = this.dmdtOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstUsrNm = this.rqstUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv3Ofc = this.lv3Ofc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv3UsrId = this.lv3UsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv1Sts = this.lv1Sts.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv2Ofc = this.lv2Ofc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstAuth = this.rqstAuth.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv6UsrNm = this.lv6UsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.taaNo = this.taaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstOfcCd = this.rqstOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv5UsrId = this.lv5UsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv4Sts = this.lv4Sts.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrtOfcCd = this.ctrtOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrtCustCd = this.ctrtCustCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrtCustNm = this.ctrtCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv7Sts = this.lv7Sts.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv7Auth = this.lv7Auth.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv7Dt = this.lv7Dt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv7Ofc = this.lv7Ofc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv7UsrId = this.lv7UsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv7UsrNm = this.lv7UsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv8Sts = this.lv8Sts.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv8Auth = this.lv8Auth.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv8Dt = this.lv8Dt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv8Ofc = this.lv8Ofc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv8UsrId = this.lv8UsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lv8UsrNm = this.lv8UsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
