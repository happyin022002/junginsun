/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : LocationIfVO.java
*@FileTitle : LocationIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo;
 
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
public class LocationIfVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<LocationIfVO> models = new ArrayList<LocationIfVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String locIfSeq = null;

    /* Column Info */
    private String locCd = null;

    /* Column Info */
    private String sccCd = null;

    /* Column Info */
    private String locNm = null;

    /* Column Info */
    private String rgnCd = null;

    /* Column Info */
    private String cntCd = null;

    /* Column Info */
    private String steCd = null;

    /* Column Info */
    private String contiCd = null;

    /* Column Info */
    private String portInlndFlg = null;

    /* Column Info */
    private String locChrCd = null;

    /* Column Info */
    private String hubLocCd = null;

    /* Column Info */
    private String slsOfcCd = null;

    /* Column Info */
    private String gmtHrs = null;

    /* Column Info */
    private String callPortFlg = null;

    /* Column Info */
    private String locAmsPortCd = null;

    /* Column Info */
    private String fincCtrlOfcCd = null;

    /* Column Info */
    private String eqCtrlOfcCd = null;

    /* Column Info */
    private String mtyPkupYdCd = null;

    /* Column Info */
    private String eqRtnYdCd = null;

    /* Column Info */
    private String unLocIndCd = null;

    /* Column Info */
    private String unLocCd = null;

    /* Column Info */
    private String cmlZnFlg = null;

    /* Column Info */
    private String cstmsCd = null;

    /* Column Info */
    private String locTpCd = null;

    /* Column Info */
    private String repZnCd = null;

    /* Column Info */
    private String zipCd = null;

    /* Column Info */
    private String scontiCd = null;

    /* Column Info */
    private String locLoclLangNm = null;

    /* Column Info */
    private String locLat = null;

    /* Column Info */
    private String latUtCd = null;

    /* Column Info */
    private String locLon = null;

    /* Column Info */
    private String lonUtCd = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String deltFlg = null;

    /* Column Info */
    private String modiLocCd = null;

    /* Column Info */
    private String ecomInsfId = null;

    /* Column Info */
    private String ecomInsfPrsId = null;

    /* Column Info */
    private String ecomInsfDttm = null;

    /* Column Info */
    private String ecomInsfCnqeVal = null;

    /* Column Info */
    private String ecomInsfDvCd = null;

    /* Column Info */
    private String ecomInsfCnqeCont = null;

    /* Column Info */
    private String ocediInsfId = null;

    /* Column Info */
    private String ocediInsfPrsId = null;

    /* Column Info */
    private String ocediInsfDttm = null;

    /* Column Info */
    private String ocediInsfCnqeVal = null;

    /* Column Info */
    private String ocediInsfDvCd = null;

    /* Column Info */
    private String ocediInsfCnqeCont = null;
	
	/* Column Info */
	private String opediInsfId = null;

    /* Column Info */
    private String opediInsfDvCd = null;
    /* Column Info */
    private String newLocLat = null;
    /* Column Info */
    private String newLocLon = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public LocationIfVO() {
    }

    public LocationIfVO(String ibflag, String pagerows, String locIfSeq, String locCd, String sccCd, String locNm, String rgnCd, String cntCd, String steCd, String contiCd, String portInlndFlg, String locChrCd, String hubLocCd, String slsOfcCd, String gmtHrs, String callPortFlg, String locAmsPortCd, String fincCtrlOfcCd, String eqCtrlOfcCd, String mtyPkupYdCd, String eqRtnYdCd, String unLocIndCd, String unLocCd, String cmlZnFlg, String cstmsCd, String locTpCd, String repZnCd, String zipCd, String scontiCd, String locLoclLangNm, String locLat, String latUtCd, String locLon, String lonUtCd, String creUsrId, String creDt, String updUsrId, String updDt, String deltFlg, String modiLocCd, String insfId, String insfPrsId, String insfDttm, String insfCnqeVal, String insfDvCd, String insfCnqeCont, String ecomInsfId, String ecomInsfPrsId, String ecomInsfDttm, String ecomInsfCnqeVal, String ecomInsfDvCd, String ecomInsfCnqeCont, String ocediInsfId, String ocediInsfPrsId, String ocediInsfDttm, String ocediInsfCnqeVal, String ocediInsfDvCd, String ocediInsfCnqeCont, String opediInsfId, String opediInsfDvCd, String newLocLat, String newLocLon) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.locIfSeq = locIfSeq;
        this.locCd = locCd;
        this.sccCd = sccCd;
        this.locNm = locNm;
        this.rgnCd = rgnCd;
        this.cntCd = cntCd;
        this.steCd = steCd;
        this.contiCd = contiCd;
        this.portInlndFlg = portInlndFlg;
        this.locChrCd = locChrCd;
        this.hubLocCd = hubLocCd;
        this.slsOfcCd = slsOfcCd;
        this.gmtHrs = gmtHrs;
        this.callPortFlg = callPortFlg;
        this.locAmsPortCd = locAmsPortCd;
        this.fincCtrlOfcCd = fincCtrlOfcCd;
        this.eqCtrlOfcCd = eqCtrlOfcCd;
        this.mtyPkupYdCd = mtyPkupYdCd;
        this.eqRtnYdCd = eqRtnYdCd;
        this.unLocIndCd = unLocIndCd;
        this.unLocCd = unLocCd;
        this.cmlZnFlg = cmlZnFlg;
        this.cstmsCd = cstmsCd;
        this.locTpCd = locTpCd;
        this.repZnCd = repZnCd;
        this.zipCd = zipCd;
        this.scontiCd = scontiCd;
        this.locLoclLangNm = locLoclLangNm;
        this.locLat = locLat;
        this.latUtCd = latUtCd;
        this.locLon = locLon;
        this.lonUtCd = lonUtCd;
        this.creUsrId = creUsrId;
        this.creDt = creDt;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.deltFlg = deltFlg;
        this.modiLocCd = modiLocCd;
        this.ecomInsfId = ecomInsfId;
        this.ecomInsfPrsId = ecomInsfPrsId;
        this.ecomInsfDttm = ecomInsfDttm;
        this.ecomInsfCnqeVal = ecomInsfCnqeVal;
        this.ecomInsfDvCd = ecomInsfDvCd;
        this.ecomInsfCnqeCont = ecomInsfCnqeCont;
        this.ocediInsfId = ocediInsfId;
        this.ocediInsfPrsId = ocediInsfPrsId;
        this.ocediInsfDttm = ocediInsfDttm;
        this.ocediInsfCnqeVal = ocediInsfCnqeVal;
        this.ocediInsfDvCd = ocediInsfDvCd;
        this.ocediInsfCnqeCont = ocediInsfCnqeCont;
        
        this.opediInsfId = opediInsfId;
        this.opediInsfDvCd = opediInsfDvCd;
        this.newLocLat = newLocLat;
        this.newLocLon = newLocLon;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("loc_if_seq", getLocIfSeq());
        this.hashColumns.put("loc_cd", getLocCd());
        this.hashColumns.put("scc_cd", getSccCd());
        this.hashColumns.put("loc_nm", getLocNm());
        this.hashColumns.put("rgn_cd", getRgnCd());
        this.hashColumns.put("cnt_cd", getCntCd());
        this.hashColumns.put("ste_cd", getSteCd());
        this.hashColumns.put("conti_cd", getContiCd());
        this.hashColumns.put("port_inlnd_flg", getPortInlndFlg());
        this.hashColumns.put("loc_chr_cd", getLocChrCd());
        this.hashColumns.put("hub_loc_cd", getHubLocCd());
        this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
        this.hashColumns.put("gmt_hrs", getGmtHrs());
        this.hashColumns.put("call_port_flg", getCallPortFlg());
        this.hashColumns.put("loc_ams_port_cd", getLocAmsPortCd());
        this.hashColumns.put("finc_ctrl_ofc_cd", getFincCtrlOfcCd());
        this.hashColumns.put("eq_ctrl_ofc_cd", getEqCtrlOfcCd());
        this.hashColumns.put("mty_pkup_yd_cd", getMtyPkupYdCd());
        this.hashColumns.put("eq_rtn_yd_cd", getEqRtnYdCd());
        this.hashColumns.put("un_loc_ind_cd", getUnLocIndCd());
        this.hashColumns.put("un_loc_cd", getUnLocCd());
        this.hashColumns.put("cml_zn_flg", getCmlZnFlg());
        this.hashColumns.put("cstms_cd", getCstmsCd());
        this.hashColumns.put("loc_tp_cd", getLocTpCd());
        this.hashColumns.put("rep_zn_cd", getRepZnCd());
        this.hashColumns.put("zip_cd", getZipCd());
        this.hashColumns.put("sconti_cd", getScontiCd());
        this.hashColumns.put("loc_locl_lang_nm", getLocLoclLangNm());
        this.hashColumns.put("loc_lat", getLocLat());
        this.hashColumns.put("lat_ut_cd", getLatUtCd());
        this.hashColumns.put("loc_lon", getLocLon());
        this.hashColumns.put("lon_ut_cd", getLonUtCd());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("delt_flg", getDeltFlg());
        this.hashColumns.put("modi_loc_cd", getModiLocCd());
        this.hashColumns.put("ecom_insf_id", getEcomInsfId());
        this.hashColumns.put("ecom_insf_prs_id", getEcomInsfPrsId());
        this.hashColumns.put("ecom_insf_dttm", getEcomInsfDttm());
        this.hashColumns.put("ecom_insf_cnqe_val", getEcomInsfCnqeVal());
        this.hashColumns.put("ecom_insf_dv_cd", getEcomInsfDvCd());
        this.hashColumns.put("ecom_insf_cnqe_cont", getEcomInsfCnqeCont());
        this.hashColumns.put("ocedi_insf_id", getOcediInsfId());
        this.hashColumns.put("ocedi_insf_prs_id", getOcediInsfPrsId());
        this.hashColumns.put("ocedi_insf_dttm", getOcediInsfDttm());
        this.hashColumns.put("ocedi_insf_cnqe_val", getOcediInsfCnqeVal());
        this.hashColumns.put("ocedi_insf_dv_cd", getOcediInsfDvCd());
        this.hashColumns.put("ocedi_insf_cnqe_cont", getOcediInsfCnqeCont());

		this.hashColumns.put("opedi_insf_id", getOpediInsfId());
        this.hashColumns.put("opedi_insf_dv_cd", getOpediInsfDvCd());
        
        this.hashColumns.put("new_loc_lat", getNewLocLat());
        this.hashColumns.put("new_loc_lon", getNewLocLon());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("loc_if_seq", "locIfSeq");
        this.hashFields.put("loc_cd", "locCd");
        this.hashFields.put("scc_cd", "sccCd");
        this.hashFields.put("loc_nm", "locNm");
        this.hashFields.put("rgn_cd", "rgnCd");
        this.hashFields.put("cnt_cd", "cntCd");
        this.hashFields.put("ste_cd", "steCd");
        this.hashFields.put("conti_cd", "contiCd");
        this.hashFields.put("port_inlnd_flg", "portInlndFlg");
        this.hashFields.put("loc_chr_cd", "locChrCd");
        this.hashFields.put("hub_loc_cd", "hubLocCd");
        this.hashFields.put("sls_ofc_cd", "slsOfcCd");
        this.hashFields.put("gmt_hrs", "gmtHrs");
        this.hashFields.put("call_port_flg", "callPortFlg");
        this.hashFields.put("loc_ams_port_cd", "locAmsPortCd");
        this.hashFields.put("finc_ctrl_ofc_cd", "fincCtrlOfcCd");
        this.hashFields.put("eq_ctrl_ofc_cd", "eqCtrlOfcCd");
        this.hashFields.put("mty_pkup_yd_cd", "mtyPkupYdCd");
        this.hashFields.put("eq_rtn_yd_cd", "eqRtnYdCd");
        this.hashFields.put("un_loc_ind_cd", "unLocIndCd");
        this.hashFields.put("un_loc_cd", "unLocCd");
        this.hashFields.put("cml_zn_flg", "cmlZnFlg");
        this.hashFields.put("cstms_cd", "cstmsCd");
        this.hashFields.put("loc_tp_cd", "locTpCd");
        this.hashFields.put("rep_zn_cd", "repZnCd");
        this.hashFields.put("zip_cd", "zipCd");
        this.hashFields.put("sconti_cd", "scontiCd");
        this.hashFields.put("loc_locl_lang_nm", "locLoclLangNm");
        this.hashFields.put("loc_lat", "locLat");
        this.hashFields.put("lat_ut_cd", "latUtCd");
        this.hashFields.put("loc_lon", "locLon");
        this.hashFields.put("lon_ut_cd", "lonUtCd");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("delt_flg", "deltFlg");
        this.hashFields.put("modi_loc_cd", "modiLocCd");
        this.hashFields.put("insf_id", "insfId");
        this.hashFields.put("insf_prs_id", "insfPrsId");
        this.hashFields.put("insf_dttm", "insfDttm");
        this.hashFields.put("insf_cnqe_val", "insfCnqeVal");
        this.hashFields.put("insf_dv_cd", "insfDvCd");
        this.hashFields.put("insf_cnqe_cont", "insfCnqeCont");
        this.hashFields.put("ecom_insf_id", "ecomInsfId");
        this.hashFields.put("ecom_insf_prs_id", "ecomInsfPrsId");
        this.hashFields.put("ecom_insf_dttm", "ecomInsfDttm");
        this.hashFields.put("ecom_insf_cnqe_val", "ecomInsfCnqeVal");
        this.hashFields.put("ecom_insf_dv_cd", "ecomInsfDvCd");
        this.hashFields.put("ecom_insf_cnqe_cont", "ecomInsfCnqeCont");
        this.hashFields.put("ocedi_insf_id", "ocediInsfId");
        this.hashFields.put("ocedi_insf_prs_id", "ocediInsfPrsId");
        this.hashFields.put("ocedi_insf_dttm", "ocediInsfDttm");
        this.hashFields.put("ocedi_insf_cnqe_val", "ocediInsfCnqeVal");
        this.hashFields.put("ocedi_insf_dv_cd", "ocediInsfDvCd");
        this.hashFields.put("ocedi_insf_cnqe_cont", "ocediInsfCnqeCont");

		this.hashFields.put("opedi_insf_id", "opediInsfId");
        this.hashFields.put("opedi_insf_dv_cd", "opediInsfDvCd");
        
        this.hashFields.put("new_loc_lat", "newLocLat");
        this.hashFields.put("new_loc_lon", "newLocLon");
        return this.hashFields;
    }

    /**
	 *
	 * @param String ibflag
	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * 
	 * @return String ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
    }

    /**
	 *
	 * @param String pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
	 * 
	 * @return String pagerows
	 */
    public String getPagerows() {
        return this.pagerows;
    }

    /**
	 *
	 * @param String locIfSeq
	 */
    public void setLocIfSeq(String locIfSeq) {
        this.locIfSeq = locIfSeq;
    }

    /**
	 * 
	 * @return String locIfSeq
	 */
    public String getLocIfSeq() {
        return this.locIfSeq;
    }

    /**
	 *
	 * @param String locCd
	 */
    public void setLocCd(String locCd) {
        this.locCd = locCd;
    }

    /**
	 * 
	 * @return String locCd
	 */
    public String getLocCd() {
        return this.locCd;
    }

    /**
	 *
	 * @param String sccCd
	 */
    public void setSccCd(String sccCd) {
        this.sccCd = sccCd;
    }

    /**
	 * 
	 * @return String sccCd
	 */
    public String getSccCd() {
        return this.sccCd;
    }

    /**
	 *
	 * @param String locNm
	 */
    public void setLocNm(String locNm) {
        this.locNm = locNm;
    }

    /**
	 * 
	 * @return String locNm
	 */
    public String getLocNm() {
        return this.locNm;
    }

    /**
	 *
	 * @param String rgnCd
	 */
    public void setRgnCd(String rgnCd) {
        this.rgnCd = rgnCd;
    }

    /**
	 * 
	 * @return String rgnCd
	 */
    public String getRgnCd() {
        return this.rgnCd;
    }

    /**
	 *
	 * @param String cntCd
	 */
    public void setCntCd(String cntCd) {
        this.cntCd = cntCd;
    }

    /**
	 * 
	 * @return String cntCd
	 */
    public String getCntCd() {
        return this.cntCd;
    }

    /**
	 *
	 * @param String steCd
	 */
    public void setSteCd(String steCd) {
        this.steCd = steCd;
    }

    /**
	 * 
	 * @return String steCd
	 */
    public String getSteCd() {
        return this.steCd;
    }

    /**
	 *
	 * @param String contiCd
	 */
    public void setContiCd(String contiCd) {
        this.contiCd = contiCd;
    }

    /**
	 * 
	 * @return String contiCd
	 */
    public String getContiCd() {
        return this.contiCd;
    }

    /**
	 *
	 * @param String portInlndFlg
	 */
    public void setPortInlndFlg(String portInlndFlg) {
        this.portInlndFlg = portInlndFlg;
    }

    /**
	 * 
	 * @return String portInlndFlg
	 */
    public String getPortInlndFlg() {
        return this.portInlndFlg;
    }

    /**
	 *
	 * @param String locChrCd
	 */
    public void setLocChrCd(String locChrCd) {
        this.locChrCd = locChrCd;
    }

    /**
	 * 
	 * @return String locChrCd
	 */
    public String getLocChrCd() {
        return this.locChrCd;
    }

    /**
	 *
	 * @param String hubLocCd
	 */
    public void setHubLocCd(String hubLocCd) {
        this.hubLocCd = hubLocCd;
    }

    /**
	 * 
	 * @return String hubLocCd
	 */
    public String getHubLocCd() {
        return this.hubLocCd;
    }

    /**
	 *
	 * @param String slsOfcCd
	 */
    public void setSlsOfcCd(String slsOfcCd) {
        this.slsOfcCd = slsOfcCd;
    }

    /**
	 * 
	 * @return String slsOfcCd
	 */
    public String getSlsOfcCd() {
        return this.slsOfcCd;
    }

    /**
	 *
	 * @param String gmtHrs
	 */
    public void setGmtHrs(String gmtHrs) {
        this.gmtHrs = gmtHrs;
    }

    /**
	 * 
	 * @return String gmtHrs
	 */
    public String getGmtHrs() {
        return this.gmtHrs;
    }

    /**
	 *
	 * @param String callPortFlg
	 */
    public void setCallPortFlg(String callPortFlg) {
        this.callPortFlg = callPortFlg;
    }

    /**
	 * 
	 * @return String callPortFlg
	 */
    public String getCallPortFlg() {
        return this.callPortFlg;
    }

    /**
	 *
	 * @param String locAmsPortCd
	 */
    public void setLocAmsPortCd(String locAmsPortCd) {
        this.locAmsPortCd = locAmsPortCd;
    }

    /**
	 * 
	 * @return String locAmsPortCd
	 */
    public String getLocAmsPortCd() {
        return this.locAmsPortCd;
    }

    /**
	 *
	 * @param String fincCtrlOfcCd
	 */
    public void setFincCtrlOfcCd(String fincCtrlOfcCd) {
        this.fincCtrlOfcCd = fincCtrlOfcCd;
    }

    /**
	 * 
	 * @return String fincCtrlOfcCd
	 */
    public String getFincCtrlOfcCd() {
        return this.fincCtrlOfcCd;
    }

    /**
	 *
	 * @param String eqCtrlOfcCd
	 */
    public void setEqCtrlOfcCd(String eqCtrlOfcCd) {
        this.eqCtrlOfcCd = eqCtrlOfcCd;
    }

    /**
	 * 
	 * @return String eqCtrlOfcCd
	 */
    public String getEqCtrlOfcCd() {
        return this.eqCtrlOfcCd;
    }

    /**
	 *
	 * @param String mtyPkupYdCd
	 */
    public void setMtyPkupYdCd(String mtyPkupYdCd) {
        this.mtyPkupYdCd = mtyPkupYdCd;
    }

    /**
	 * 
	 * @return String mtyPkupYdCd
	 */
    public String getMtyPkupYdCd() {
        return this.mtyPkupYdCd;
    }

    /**
	 *
	 * @param String eqRtnYdCd
	 */
    public void setEqRtnYdCd(String eqRtnYdCd) {
        this.eqRtnYdCd = eqRtnYdCd;
    }

    /**
	 * 
	 * @return String eqRtnYdCd
	 */
    public String getEqRtnYdCd() {
        return this.eqRtnYdCd;
    }

    /**
	 *
	 * @param String unLocIndCd
	 */
    public void setUnLocIndCd(String unLocIndCd) {
        this.unLocIndCd = unLocIndCd;
    }

    /**
	 * 
	 * @return String unLocIndCd
	 */
    public String getUnLocIndCd() {
        return this.unLocIndCd;
    }

    /**
	 *
	 * @param String unLocCd
	 */
    public void setUnLocCd(String unLocCd) {
        this.unLocCd = unLocCd;
    }

    /**
	 * 
	 * @return String unLocCd
	 */
    public String getUnLocCd() {
        return this.unLocCd;
    }

    /**
	 *
	 * @param String cmlZnFlg
	 */
    public void setCmlZnFlg(String cmlZnFlg) {
        this.cmlZnFlg = cmlZnFlg;
    }

    /**
	 * 
	 * @return String cmlZnFlg
	 */
    public String getCmlZnFlg() {
        return this.cmlZnFlg;
    }

    /**
	 *
	 * @param String cstmsCd
	 */
    public void setCstmsCd(String cstmsCd) {
        this.cstmsCd = cstmsCd;
    }

    /**
	 * 
	 * @return String cstmsCd
	 */
    public String getCstmsCd() {
        return this.cstmsCd;
    }

    /**
	 *
	 * @param String locTpCd
	 */
    public void setLocTpCd(String locTpCd) {
        this.locTpCd = locTpCd;
    }

    /**
	 * 
	 * @return String locTpCd
	 */
    public String getLocTpCd() {
        return this.locTpCd;
    }

    /**
	 *
	 * @param String repZnCd
	 */
    public void setRepZnCd(String repZnCd) {
        this.repZnCd = repZnCd;
    }

    /**
	 * 
	 * @return String repZnCd
	 */
    public String getRepZnCd() {
        return this.repZnCd;
    }

    /**
	 *
	 * @param String zipCd
	 */
    public void setZipCd(String zipCd) {
        this.zipCd = zipCd;
    }

    /**
	 * 
	 * @return String zipCd
	 */
    public String getZipCd() {
        return this.zipCd;
    }

    /**
	 *
	 * @param String scontiCd
	 */
    public void setScontiCd(String scontiCd) {
        this.scontiCd = scontiCd;
    }

    /**
	 * 
	 * @return String scontiCd
	 */
    public String getScontiCd() {
        return this.scontiCd;
    }

    /**
	 *
	 * @param String locLoclLangNm
	 */
    public void setLocLoclLangNm(String locLoclLangNm) {
        this.locLoclLangNm = locLoclLangNm;
    }

    /**
	 * 
	 * @return String locLoclLangNm
	 */
    public String getLocLoclLangNm() {
        return this.locLoclLangNm;
    }

    /**
	 *
	 * @param String locLat
	 */
    public void setLocLat(String locLat) {
        this.locLat = locLat;
    }

    /**
	 * 
	 * @return String locLat
	 */
    public String getLocLat() {
        return this.locLat;
    }

    /**
	 *
	 * @param String latUtCd
	 */
    public void setLatUtCd(String latUtCd) {
        this.latUtCd = latUtCd;
    }

    /**
	 * 
	 * @return String latUtCd
	 */
    public String getLatUtCd() {
        return this.latUtCd;
    }

    /**
	 *
	 * @param String locLon
	 */
    public void setLocLon(String locLon) {
        this.locLon = locLon;
    }

    /**
	 * 
	 * @return String locLon
	 */
    public String getLocLon() {
        return this.locLon;
    }

    /**
	 *
	 * @param String lonUtCd
	 */
    public void setLonUtCd(String lonUtCd) {
        this.lonUtCd = lonUtCd;
    }

    /**
	 * 
	 * @return String lonUtCd
	 */
    public String getLonUtCd() {
        return this.lonUtCd;
    }

    /**
	 *
	 * @param String creUsrId
	 */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    /**
	 * 
	 * @return String creUsrId
	 */
    public String getCreUsrId() {
        return this.creUsrId;
    }

    /**
	 *
	 * @param String creDt
	 */
    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    /**
	 * 
	 * @return String creDt
	 */
    public String getCreDt() {
        return this.creDt;
    }

    /**
	 *
	 * @param String updUsrId
	 */
    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    /**
	 * 
	 * @return String updUsrId
	 */
    public String getUpdUsrId() {
        return this.updUsrId;
    }

    /**
	 *
	 * @param String updDt
	 */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
	 * 
	 * @return String updDt
	 */
    public String getUpdDt() {
        return this.updDt;
    }

    /**
	 *
	 * @param String deltFlg
	 */
    public void setDeltFlg(String deltFlg) {
        this.deltFlg = deltFlg;
    }

    /**
	 * 
	 * @return String deltFlg
	 */
    public String getDeltFlg() {
        return this.deltFlg;
    }

    /**
	 *
	 * @param String modiLocCd
	 */
    public void setModiLocCd(String modiLocCd) {
        this.modiLocCd = modiLocCd;
    }

    /**
	 * 
	 * @return String modiLocCd
	 */
    public String getModiLocCd() {
        return this.modiLocCd;
    }

    public void setEcomInsfId(String ecomInsfId) {
        this.ecomInsfId = ecomInsfId;
    }

    public String getEcomInsfId() {
        return this.ecomInsfId;
    }

    public void setEcomInsfPrsId(String ecomInsfPrsId) {
        this.ecomInsfPrsId = ecomInsfPrsId;
    }

    public String getEcomInsfPrsId() {
        return this.ecomInsfPrsId;
    }

    public void setEcomInsfDttm(String ecomInsfDttm) {
        this.ecomInsfDttm = ecomInsfDttm;
    }

    public String getEcomInsfDttm() {
        return this.ecomInsfDttm;
    }

    public void setEcomInsfCnqeVal(String ecomInsfCnqeVal) {
        this.ecomInsfCnqeVal = ecomInsfCnqeVal;
    }

    public String getEcomInsfCnqeVal() {
        return this.ecomInsfCnqeVal;
    }

    public void setEcomInsfDvCd(String ecomInsfDvCd) {
        this.ecomInsfDvCd = ecomInsfDvCd;
    }

    public String getEcomInsfDvCd() {
        return this.ecomInsfDvCd;
    }

    public void setEcomInsfCnqeCont(String ecomInsfCnqeCont) {
        this.ecomInsfCnqeCont = ecomInsfCnqeCont;
    }

    public String getEcomInsfCnqeCont() {
        return this.ecomInsfCnqeCont;
    }

    public void setOcediInsfId(String ocediInsfId) {
        this.ocediInsfId = ocediInsfId;
    }

    public String getOcediInsfId() {
        return this.ocediInsfId;
    }

    public void setOcediInsfPrsId(String ocediInsfPrsId) {
        this.ocediInsfPrsId = ocediInsfPrsId;
    }

    public String getOcediInsfPrsId() {
        return this.ocediInsfPrsId;
    }

    public void setOcediInsfDttm(String ocediInsfDttm) {
        this.ocediInsfDttm = ocediInsfDttm;
    }

    public String getOcediInsfDttm() {
        return this.ocediInsfDttm;
    }

    public void setOcediInsfCnqeVal(String ocediInsfCnqeVal) {
        this.ocediInsfCnqeVal = ocediInsfCnqeVal;
    }

    public String getOcediInsfCnqeVal() {
        return this.ocediInsfCnqeVal;
    }

    public void setOcediInsfDvCd(String ocediInsfDvCd) {
        this.ocediInsfDvCd = ocediInsfDvCd;
    }

    public String getOcediInsfDvCd() {
        return this.ocediInsfDvCd;
    }

    public void setOcediInsfCnqeCont(String ocediInsfCnqeCont) {
        this.ocediInsfCnqeCont = ocediInsfCnqeCont;
    }

    public String getOcediInsfCnqeCont() {
        return this.ocediInsfCnqeCont;
    }

	public String getOpediInsfId() {
		return opediInsfId;
	}

	public void setOpediInsfId(String opediInsfId) {
		this.opediInsfId = opediInsfId;
	}

    public void setOpediInsfDvCd(String opediInsfDvCd) {
        this.opediInsfDvCd = opediInsfDvCd;
    }

    public String getOpediInsfDvCd() {
        return this.opediInsfDvCd;
    }

    public String getNewLocLat() {
		return newLocLat;
	}

	public void setNewLocLat(String newLocLat) {
		this.newLocLat = newLocLat;
	}

	public String getNewLocLon() {
		return newLocLon;
	}

	public void setNewLocLon(String newLocLon) {
		this.newLocLon = newLocLon;
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
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setLocIfSeq(JSPUtil.getParameter(request, prefix + "loc_if_seq", ""));
        setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
        setSccCd(JSPUtil.getParameter(request, prefix + "scc_cd", ""));
        setLocNm(JSPUtil.getParameter(request, prefix + "loc_nm", ""));
        setRgnCd(JSPUtil.getParameter(request, prefix + "rgn_cd", ""));
        setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
        setSteCd(JSPUtil.getParameter(request, prefix + "ste_cd", ""));
        setContiCd(JSPUtil.getParameter(request, prefix + "conti_cd", ""));
        setPortInlndFlg(JSPUtil.getParameter(request, prefix + "port_inlnd_flg", ""));
        setLocChrCd(JSPUtil.getParameter(request, prefix + "loc_chr_cd", ""));
        setHubLocCd(JSPUtil.getParameter(request, prefix + "hub_loc_cd", ""));
        setSlsOfcCd(JSPUtil.getParameter(request, prefix + "sls_ofc_cd", ""));
        setGmtHrs(JSPUtil.getParameter(request, prefix + "gmt_hrs", ""));
        setCallPortFlg(JSPUtil.getParameter(request, prefix + "call_port_flg", ""));
        setLocAmsPortCd(JSPUtil.getParameter(request, prefix + "loc_ams_port_cd", ""));
        setFincCtrlOfcCd(JSPUtil.getParameter(request, prefix + "finc_ctrl_ofc_cd", ""));
        setEqCtrlOfcCd(JSPUtil.getParameter(request, prefix + "eq_ctrl_ofc_cd", ""));
        setMtyPkupYdCd(JSPUtil.getParameter(request, prefix + "mty_pkup_yd_cd", ""));
        setEqRtnYdCd(JSPUtil.getParameter(request, prefix + "eq_rtn_yd_cd", ""));
        setUnLocIndCd(JSPUtil.getParameter(request, prefix + "un_loc_ind_cd", ""));
        setUnLocCd(JSPUtil.getParameter(request, prefix + "un_loc_cd", ""));
        setCmlZnFlg(JSPUtil.getParameter(request, prefix + "cml_zn_flg", ""));
        setCstmsCd(JSPUtil.getParameter(request, prefix + "cstms_cd", ""));
        setLocTpCd(JSPUtil.getParameter(request, prefix + "loc_tp_cd", ""));
        setRepZnCd(JSPUtil.getParameter(request, prefix + "rep_zn_cd", ""));
        setZipCd(JSPUtil.getParameter(request, prefix + "zip_cd", ""));
        setScontiCd(JSPUtil.getParameter(request, prefix + "sconti_cd", ""));
        setLocLoclLangNm(JSPUtil.getParameter(request, prefix + "loc_locl_lang_nm", ""));
        setLocLat(JSPUtil.getParameter(request, prefix + "loc_lat", ""));
        setLatUtCd(JSPUtil.getParameter(request, prefix + "lat_ut_cd", ""));
        setLocLon(JSPUtil.getParameter(request, prefix + "loc_lon", ""));
        setLonUtCd(JSPUtil.getParameter(request, prefix + "lon_ut_cd", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
        setModiLocCd(JSPUtil.getParameter(request, prefix + "modi_loc_cd", ""));
        setEcomInsfId(JSPUtil.getParameter(request, prefix + "ecom_insf_id", ""));
        setEcomInsfPrsId(JSPUtil.getParameter(request, prefix + "ecom_insf_prs_id", ""));
        setEcomInsfDttm(JSPUtil.getParameter(request, prefix + "ecom_insf_dttm", ""));
        setEcomInsfCnqeVal(JSPUtil.getParameter(request, prefix + "ecom_insf_cnqe_val", ""));
        setEcomInsfDvCd(JSPUtil.getParameter(request, prefix + "ecom_insf_dv_cd", ""));
        setEcomInsfCnqeCont(JSPUtil.getParameter(request, prefix + "ecom_insf_cnqe_cont", ""));
        setOcediInsfId(JSPUtil.getParameter(request, prefix + "ocedi_insf_id", ""));
        setOcediInsfPrsId(JSPUtil.getParameter(request, prefix + "ocedi_insf_prs_id", ""));
        setOcediInsfDttm(JSPUtil.getParameter(request, prefix + "ocedi_insf_dttm", ""));
        setOcediInsfCnqeVal(JSPUtil.getParameter(request, prefix + "ocedi_insf_cnqe_val", ""));
        setOcediInsfDvCd(JSPUtil.getParameter(request, prefix + "ocedi_insf_dv_cd", ""));
        setOcediInsfCnqeCont(JSPUtil.getParameter(request, prefix + "ocedi_insf_cnqe_cont", ""));

		setOpediInsfId(JSPUtil.getParameter(request, prefix + "opedi_insf_id", ""));
        setOpediInsfDvCd(JSPUtil.getParameter(request, prefix + "opedi_insf_dv_cd", ""));
        
        setNewLocLat(JSPUtil.getParameter(request, prefix + "new_loc_lat", ""));
        setNewLocLon(JSPUtil.getParameter(request, prefix + "new_loc_lon", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return LocationIfVO[]
	 */
    public LocationIfVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return LocationIfVO[]
	 */
    public LocationIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        LocationIfVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] locIfSeq = (JSPUtil.getParameter(request, prefix + "loc_if_seq", length));
            String[] locCd = (JSPUtil.getParameter(request, prefix + "loc_cd", length));
            String[] sccCd = (JSPUtil.getParameter(request, prefix + "scc_cd", length));
            String[] locNm = (JSPUtil.getParameter(request, prefix + "loc_nm", length));
            String[] rgnCd = (JSPUtil.getParameter(request, prefix + "rgn_cd", length));
            String[] cntCd = (JSPUtil.getParameter(request, prefix + "cnt_cd", length));
            String[] steCd = (JSPUtil.getParameter(request, prefix + "ste_cd", length));
            String[] contiCd = (JSPUtil.getParameter(request, prefix + "conti_cd", length));
            String[] portInlndFlg = (JSPUtil.getParameter(request, prefix + "port_inlnd_flg", length));
            String[] locChrCd = (JSPUtil.getParameter(request, prefix + "loc_chr_cd", length));
            String[] hubLocCd = (JSPUtil.getParameter(request, prefix + "hub_loc_cd", length));
            String[] slsOfcCd = (JSPUtil.getParameter(request, prefix + "sls_ofc_cd", length));
            String[] gmtHrs = (JSPUtil.getParameter(request, prefix + "gmt_hrs", length));
            String[] callPortFlg = (JSPUtil.getParameter(request, prefix + "call_port_flg", length));
            String[] locAmsPortCd = (JSPUtil.getParameter(request, prefix + "loc_ams_port_cd", length));
            String[] fincCtrlOfcCd = (JSPUtil.getParameter(request, prefix + "finc_ctrl_ofc_cd", length));
            String[] eqCtrlOfcCd = (JSPUtil.getParameter(request, prefix + "eq_ctrl_ofc_cd", length));
            String[] mtyPkupYdCd = (JSPUtil.getParameter(request, prefix + "mty_pkup_yd_cd", length));
            String[] eqRtnYdCd = (JSPUtil.getParameter(request, prefix + "eq_rtn_yd_cd", length));
            String[] unLocIndCd = (JSPUtil.getParameter(request, prefix + "un_loc_ind_cd", length));
            String[] unLocCd = (JSPUtil.getParameter(request, prefix + "un_loc_cd", length));
            String[] cmlZnFlg = (JSPUtil.getParameter(request, prefix + "cml_zn_flg", length));
            String[] cstmsCd = (JSPUtil.getParameter(request, prefix + "cstms_cd", length));
            String[] locTpCd = (JSPUtil.getParameter(request, prefix + "loc_tp_cd", length));
            String[] repZnCd = (JSPUtil.getParameter(request, prefix + "rep_zn_cd", length));
            String[] zipCd = (JSPUtil.getParameter(request, prefix + "zip_cd", length));
            String[] scontiCd = (JSPUtil.getParameter(request, prefix + "sconti_cd", length));
            String[] locLoclLangNm = (JSPUtil.getParameter(request, prefix + "loc_locl_lang_nm", length));
            String[] locLat = (JSPUtil.getParameter(request, prefix + "loc_lat", length));
            String[] latUtCd = (JSPUtil.getParameter(request, prefix + "lat_ut_cd", length));
            String[] locLon = (JSPUtil.getParameter(request, prefix + "loc_lon", length));
            String[] lonUtCd = (JSPUtil.getParameter(request, prefix + "lon_ut_cd", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
            String[] modiLocCd = (JSPUtil.getParameter(request, prefix + "modi_loc_cd", length));
            String[] ecomInsfId = (JSPUtil.getParameter(request, prefix + "ecom_insf_id", length));
	    	String[] ecomInsfPrsId = (JSPUtil.getParameter(request, prefix + "ecom_insf_prs_id", length));
	    	String[] ecomInsfDttm = (JSPUtil.getParameter(request, prefix + "ecom_insf_dttm", length));
	    	String[] ecomInsfCnqeVal = (JSPUtil.getParameter(request, prefix + "ecom_insf_cnqe_val", length));
	    	String[] ecomInsfDvCd = (JSPUtil.getParameter(request, prefix + "ecom_insf_dv_cd", length));
	    	String[] ecomInsfCnqeCont = (JSPUtil.getParameter(request, prefix + "ecom_insf_cnqe_cont", length));
	    	String[] ocediInsfId = (JSPUtil.getParameter(request, prefix + "ocedi_insf_id", length));
	    	String[] ocediInsfPrsId = (JSPUtil.getParameter(request, prefix + "ocedi_insf_prs_id", length));
	    	String[] ocediInsfDttm = (JSPUtil.getParameter(request, prefix + "ocedi_insf_dttm", length));
	    	String[] ocediInsfCnqeVal = (JSPUtil.getParameter(request, prefix + "ocedi_insf_cnqe_val", length));
	    	String[] ocediInsfDvCd = (JSPUtil.getParameter(request, prefix + "ocedi_insf_dv_cd", length));
	    	String[] ocediInsfCnqeCont = (JSPUtil.getParameter(request, prefix + "ocedi_insf_cnqe_cont", length));

			String[] opediInsfId = (JSPUtil.getParameter(request, prefix	+ "opedi_insf_id", length));
	    	String[] opediInsfDvCd = (JSPUtil.getParameter(request, prefix + "opedi_insf_dv_cd", length));
	    	
	    	String[] newLocLat = (JSPUtil.getParameter(request, prefix	+ "new_loc_lat", length));
	    	String[] newLocLon = (JSPUtil.getParameter(request, prefix + "new_loc_lon", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new LocationIfVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (locIfSeq[i] != null)
                    model.setLocIfSeq(locIfSeq[i]);
                if (locCd[i] != null)
                    model.setLocCd(locCd[i]);
                if (sccCd[i] != null)
                    model.setSccCd(sccCd[i]);
                if (locNm[i] != null)
                    model.setLocNm(locNm[i]);
                if (rgnCd[i] != null)
                    model.setRgnCd(rgnCd[i]);
                if (cntCd[i] != null)
                    model.setCntCd(cntCd[i]);
                if (steCd[i] != null)
                    model.setSteCd(steCd[i]);
                if (contiCd[i] != null)
                    model.setContiCd(contiCd[i]);
                if (portInlndFlg[i] != null)
                    model.setPortInlndFlg(portInlndFlg[i]);
                if (locChrCd[i] != null)
                    model.setLocChrCd(locChrCd[i]);
                if (hubLocCd[i] != null)
                    model.setHubLocCd(hubLocCd[i]);
                if (slsOfcCd[i] != null)
                    model.setSlsOfcCd(slsOfcCd[i]);
                if (gmtHrs[i] != null)
                    model.setGmtHrs(gmtHrs[i]);
                if (callPortFlg[i] != null)
                    model.setCallPortFlg(callPortFlg[i]);
                if (locAmsPortCd[i] != null)
                    model.setLocAmsPortCd(locAmsPortCd[i]);
                if (fincCtrlOfcCd[i] != null)
                    model.setFincCtrlOfcCd(fincCtrlOfcCd[i]);
                if (eqCtrlOfcCd[i] != null)
                    model.setEqCtrlOfcCd(eqCtrlOfcCd[i]);
                if (mtyPkupYdCd[i] != null)
                    model.setMtyPkupYdCd(mtyPkupYdCd[i]);
                if (eqRtnYdCd[i] != null)
                    model.setEqRtnYdCd(eqRtnYdCd[i]);
                if (unLocIndCd[i] != null)
                    model.setUnLocIndCd(unLocIndCd[i]);
                if (unLocCd[i] != null)
                    model.setUnLocCd(unLocCd[i]);
                if (cmlZnFlg[i] != null)
                    model.setCmlZnFlg(cmlZnFlg[i]);
                if (cstmsCd[i] != null)
                    model.setCstmsCd(cstmsCd[i]);
                if (locTpCd[i] != null)
                    model.setLocTpCd(locTpCd[i]);
                if (repZnCd[i] != null)
                    model.setRepZnCd(repZnCd[i]);
                if (zipCd[i] != null)
                    model.setZipCd(zipCd[i]);
                if (scontiCd[i] != null)
                    model.setScontiCd(scontiCd[i]);
                if (locLoclLangNm[i] != null)
                    model.setLocLoclLangNm(locLoclLangNm[i]);
                if (locLat[i] != null)
                    model.setLocLat(locLat[i]);
                if (latUtCd[i] != null)
                    model.setLatUtCd(latUtCd[i]);
                if (locLon[i] != null)
                    model.setLocLon(locLon[i]);
                if (lonUtCd[i] != null)
                    model.setLonUtCd(lonUtCd[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (deltFlg[i] != null)
                    model.setDeltFlg(deltFlg[i]);
                if (modiLocCd[i] != null)
                    model.setModiLocCd(modiLocCd[i]);
                if (ecomInsfId[i] != null) 
		    		model.setEcomInsfId(ecomInsfId[i]);
				if (ecomInsfPrsId[i] != null) 
		    		model.setEcomInsfPrsId(ecomInsfPrsId[i]);
				if (ecomInsfDttm[i] != null) 
		    		model.setEcomInsfDttm(ecomInsfDttm[i]);
				if (ecomInsfCnqeVal[i] != null) 
		    		model.setEcomInsfCnqeVal(ecomInsfCnqeVal[i]);
				if (ecomInsfDvCd[i] != null) 
		    		model.setEcomInsfDvCd(ecomInsfDvCd[i]);
				if (ecomInsfCnqeCont[i] != null) 
		    		model.setEcomInsfCnqeCont(ecomInsfCnqeCont[i]);
				if (ocediInsfId[i] != null) 
		    		model.setOcediInsfId(ocediInsfId[i]);
				if (ocediInsfPrsId[i] != null) 
		    		model.setOcediInsfPrsId(ocediInsfPrsId[i]);
				if (ocediInsfDttm[i] != null) 
		    		model.setOcediInsfDttm(ocediInsfDttm[i]);
				if (ocediInsfCnqeVal[i] != null) 
		    		model.setOcediInsfCnqeVal(ocediInsfCnqeVal[i]);
				if (ocediInsfDvCd[i] != null) 
		    		model.setOcediInsfDvCd(ocediInsfDvCd[i]);
				if (ocediInsfCnqeCont[i] != null) 
		    		model.setOcediInsfCnqeCont(ocediInsfCnqeCont[i]);
				
				if (opediInsfId[i] != null)
					model.setOpediInsfId(opediInsfId[i]);
				if (opediInsfDvCd[i] != null) 
		    		model.setOpediInsfDvCd(opediInsfDvCd[i]);
				
				if (newLocLat[i] != null)
					model.setNewLocLat(newLocLat[i]);
				if (newLocLon[i] != null) 
		    		model.setNewLocLon(newLocLon[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getLocationIfVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return LocationIfVO[]
	 */
    public LocationIfVO[] getLocationIfVOs() {
        LocationIfVO[] vos = (LocationIfVO[]) models.toArray(new LocationIfVO[models.size()]);
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
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locIfSeq = this.locIfSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locCd = this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sccCd = this.sccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locNm = this.locNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rgnCd = this.rgnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntCd = this.cntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.steCd = this.steCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.contiCd = this.contiCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.portInlndFlg = this.portInlndFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locChrCd = this.locChrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hubLocCd = this.hubLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slsOfcCd = this.slsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.gmtHrs = this.gmtHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.callPortFlg = this.callPortFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locAmsPortCd = this.locAmsPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fincCtrlOfcCd = this.fincCtrlOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqCtrlOfcCd = this.eqCtrlOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mtyPkupYdCd = this.mtyPkupYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqRtnYdCd = this.eqRtnYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.unLocIndCd = this.unLocIndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.unLocCd = this.unLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmlZnFlg = this.cmlZnFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cstmsCd = this.cstmsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locTpCd = this.locTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.repZnCd = this.repZnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.zipCd = this.zipCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scontiCd = this.scontiCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locLoclLangNm = this.locLoclLangNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locLat = this.locLat.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.latUtCd = this.latUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locLon = this.locLon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lonUtCd = this.lonUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.modiLocCd = this.modiLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecomInsfId = this.ecomInsfId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecomInsfPrsId = this.ecomInsfPrsId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecomInsfDttm = this.ecomInsfDttm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecomInsfCnqeVal = this.ecomInsfCnqeVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecomInsfDvCd = this.ecomInsfDvCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecomInsfCnqeCont = this.ecomInsfCnqeCont.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ocediInsfId = this.ocediInsfId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ocediInsfPrsId = this.ocediInsfPrsId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ocediInsfDttm = this.ocediInsfDttm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ocediInsfCnqeVal = this.ocediInsfCnqeVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ocediInsfDvCd = this.ocediInsfDvCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ocediInsfCnqeCont = this.ocediInsfCnqeCont.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.opediInsfId = this.opediInsfId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.opediInsfDvCd = this.opediInsfDvCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        
        this.newLocLat = this.newLocLat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.newLocLon = this.newLocLon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
