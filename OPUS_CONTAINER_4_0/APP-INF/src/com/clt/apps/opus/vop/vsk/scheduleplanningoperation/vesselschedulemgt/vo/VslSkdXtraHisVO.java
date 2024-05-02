/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VslSkdXtraHisVO.java
*@FileTitle : VslSkdXtraHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.08  
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

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
public class VslSkdXtraHisVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<VslSkdXtraHisVO> models = new ArrayList<VslSkdXtraHisVO>();

    /* Column Info */
    private String aftSkdStsCd = null;

    /* Column Info */
    private String bfrSkdDirCd = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String aftCallYdIndSeq = null;

    /* Column Info */
    private String bfrSkdStsCd = null;

    /* Column Info */
    private String aftYdCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String skdCngDesc = null;

    /* Column Info */
    private String bfrClptIndSeq = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String aftVslSlanCd = null;

    /* Column Info */
    private String aftSkdVoyNo = null;

    /* Column Info */
    private String bfrSkdVoyNo = null;

    /* Column Info */
    private String aftVpsEtbDt = null;

    /* Column Info */
    private String bfrVslCd = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String bfrVpsPortCd = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String vskdTpCd = null;

    /* Column Info */
    private String aftVpsEtaDt = null;

    /* Column Info */
    private String bfrYdCd = null;

    /* Column Info */
    private String bfrCallYdIndSeq = null;

    /* Column Info */
    private String bfrVslSlanCd = null;

    /* Column Info */
    private String bfrVpsEtbDt = null;

    /* Column Info */
    private String aftVpsPortCd = null;

    /* Column Info */
    private String skdCngId = null;

    /* Column Info */
    private String vskdCngTpCd = null;

    /* Column Info */
    private String bfrVpsEtaDt = null;

    /* Column Info */
    private String aftClptIndSeq = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String bfrVpsEtdDt = null;

    /* Column Info */
    private String diffRmk = null;

    /* Column Info */
    private String aftVpsEtdDt = null;

    /* Column Info */
    private String vskdCngNo = null;

    /* Column Info */
    private String aftVslCd = null;

    /* Column Info */
    private String aftSkdDirCd = null;

    /* Column Info */
    private String bkgAtchFlg = null;

    /* Column Info */
    private String bfrPfSvcTpCd = null;

    /* Column Info */
    private String vtAddCallFlg = null;

    /* Column Info */
    private boolean istargetforskdhisbyuser = true;

    /* Column Info */
    private String bfrActCrrCd = null;

    /* Column Info */
    private String hisSaveKndCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public VslSkdXtraHisVO() {
    }

    public VslSkdXtraHisVO(String ibflag, String pagerows, String vskdCngNo, String vskdTpCd, String vskdCngTpCd, String bfrSkdStsCd, String bfrVslSlanCd, String bfrVslCd, String bfrSkdVoyNo, String bfrSkdDirCd, String bfrVpsPortCd, String bfrClptIndSeq, String bfrYdCd, String bfrCallYdIndSeq, String bfrVpsEtaDt, String bfrVpsEtbDt, String bfrVpsEtdDt, String aftSkdStsCd, String aftVslSlanCd, String aftVslCd, String aftSkdVoyNo, String aftSkdDirCd, String aftVpsPortCd, String aftClptIndSeq, String aftYdCd, String aftCallYdIndSeq, String aftVpsEtaDt, String aftVpsEtbDt, String aftVpsEtdDt, String diffRmk, String skdCngId, String skdCngDesc, String creUsrId, String creDt, String updUsrId, String updDt, String vtAddCallFlg, boolean istargetforskdhisbyuser, String bfrActCrrCd, String hisSaveKndCd) {
        this.aftSkdStsCd = aftSkdStsCd;
        this.bfrSkdDirCd = bfrSkdDirCd;
        this.creDt = creDt;
        this.aftCallYdIndSeq = aftCallYdIndSeq;
        this.bfrSkdStsCd = bfrSkdStsCd;
        this.aftYdCd = aftYdCd;
        this.pagerows = pagerows;
        this.skdCngDesc = skdCngDesc;
        this.bfrClptIndSeq = bfrClptIndSeq;
        this.ibflag = ibflag;
        this.aftVslSlanCd = aftVslSlanCd;
        this.aftSkdVoyNo = aftSkdVoyNo;
        this.bfrSkdVoyNo = bfrSkdVoyNo;
        this.aftVpsEtbDt = aftVpsEtbDt;
        this.bfrVslCd = bfrVslCd;
        this.updUsrId = updUsrId;
        this.bfrVpsPortCd = bfrVpsPortCd;
        this.updDt = updDt;
        this.vskdTpCd = vskdTpCd;
        this.aftVpsEtaDt = aftVpsEtaDt;
        this.bfrYdCd = bfrYdCd;
        this.bfrCallYdIndSeq = bfrCallYdIndSeq;
        this.bfrVslSlanCd = bfrVslSlanCd;
        this.bfrVpsEtbDt = bfrVpsEtbDt;
        this.aftVpsPortCd = aftVpsPortCd;
        this.skdCngId = skdCngId;
        this.vskdCngTpCd = vskdCngTpCd;
        this.bfrVpsEtaDt = bfrVpsEtaDt;
        this.aftClptIndSeq = aftClptIndSeq;
        this.creUsrId = creUsrId;
        this.bfrVpsEtdDt = bfrVpsEtdDt;
        this.diffRmk = diffRmk;
        this.aftVpsEtdDt = aftVpsEtdDt;
        this.vskdCngNo = vskdCngNo;
        this.aftVslCd = aftVslCd;
        this.aftSkdDirCd = aftSkdDirCd;
        this.vtAddCallFlg = vtAddCallFlg;
        this.istargetforskdhisbyuser = istargetforskdhisbyuser;
        this.bfrActCrrCd = bfrActCrrCd;
        this.hisSaveKndCd = hisSaveKndCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("aft_skd_sts_cd", getAftSkdStsCd());
        this.hashColumns.put("bfr_skd_dir_cd", getBfrSkdDirCd());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("aft_call_yd_ind_seq", getAftCallYdIndSeq());
        this.hashColumns.put("bfr_skd_sts_cd", getBfrSkdStsCd());
        this.hashColumns.put("aft_yd_cd", getAftYdCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("skd_cng_desc", getSkdCngDesc());
        this.hashColumns.put("bfr_clpt_ind_seq", getBfrClptIndSeq());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("aft_vsl_slan_cd", getAftVslSlanCd());
        this.hashColumns.put("aft_skd_voy_no", getAftSkdVoyNo());
        this.hashColumns.put("bfr_skd_voy_no", getBfrSkdVoyNo());
        this.hashColumns.put("aft_vps_etb_dt", getAftVpsEtbDt());
        this.hashColumns.put("bfr_vsl_cd", getBfrVslCd());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("bfr_vps_port_cd", getBfrVpsPortCd());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("vskd_tp_cd", getVskdTpCd());
        this.hashColumns.put("aft_vps_eta_dt", getAftVpsEtaDt());
        this.hashColumns.put("bfr_yd_cd", getBfrYdCd());
        this.hashColumns.put("bfr_call_yd_ind_seq", getBfrCallYdIndSeq());
        this.hashColumns.put("bfr_vsl_slan_cd", getBfrVslSlanCd());
        this.hashColumns.put("bfr_vps_etb_dt", getBfrVpsEtbDt());
        this.hashColumns.put("aft_vps_port_cd", getAftVpsPortCd());
        this.hashColumns.put("skd_cng_id", getSkdCngId());
        this.hashColumns.put("vskd_cng_tp_cd", getVskdCngTpCd());
        this.hashColumns.put("bfr_vps_eta_dt", getBfrVpsEtaDt());
        this.hashColumns.put("aft_clpt_ind_seq", getAftClptIndSeq());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("bfr_vps_etd_dt", getBfrVpsEtdDt());
        this.hashColumns.put("diff_rmk", getDiffRmk());
        this.hashColumns.put("aft_vps_etd_dt", getAftVpsEtdDt());
        this.hashColumns.put("vskd_cng_no", getVskdCngNo());
        this.hashColumns.put("aft_vsl_cd", getAftVslCd());
        this.hashColumns.put("aft_skd_dir_cd", getAftSkdDirCd());
        this.hashColumns.put("bkg_atch_flg", getBkgAtchFlg());
        this.hashColumns.put("bfr_pf_svc_tp_cd", getBfrPfSvcTpCd());
        this.hashColumns.put("vt_add_call_flg", getVtAddCallFlg());
        this.hashColumns.put("bfr_act_crr_cd", getBfrActCrrCd());
        this.hashColumns.put("his_save_knd_cd", getHisSaveKndCd());
        //this.hashColumns.put("istargetforskdhisbyuser", getIstargetforskdhisbyuser());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("aft_skd_sts_cd", "aftSkdStsCd");
        this.hashFields.put("bfr_skd_dir_cd", "bfrSkdDirCd");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("aft_call_yd_ind_seq", "aftCallYdIndSeq");
        this.hashFields.put("bfr_skd_sts_cd", "bfrSkdStsCd");
        this.hashFields.put("aft_yd_cd", "aftYdCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("skd_cng_desc", "skdCngDesc");
        this.hashFields.put("bfr_clpt_ind_seq", "bfrClptIndSeq");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("aft_vsl_slan_cd", "aftVslSlanCd");
        this.hashFields.put("aft_skd_voy_no", "aftSkdVoyNo");
        this.hashFields.put("bfr_skd_voy_no", "bfrSkdVoyNo");
        this.hashFields.put("aft_vps_etb_dt", "aftVpsEtbDt");
        this.hashFields.put("bfr_vsl_cd", "bfrVslCd");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("bfr_vps_port_cd", "bfrVpsPortCd");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("vskd_tp_cd", "vskdTpCd");
        this.hashFields.put("aft_vps_eta_dt", "aftVpsEtaDt");
        this.hashFields.put("bfr_yd_cd", "bfrYdCd");
        this.hashFields.put("bfr_call_yd_ind_seq", "bfrCallYdIndSeq");
        this.hashFields.put("bfr_vsl_slan_cd", "bfrVslSlanCd");
        this.hashFields.put("bfr_vps_etb_dt", "bfrVpsEtbDt");
        this.hashFields.put("aft_vps_port_cd", "aftVpsPortCd");
        this.hashFields.put("skd_cng_id", "skdCngId");
        this.hashFields.put("vskd_cng_tp_cd", "vskdCngTpCd");
        this.hashFields.put("bfr_vps_eta_dt", "bfrVpsEtaDt");
        this.hashFields.put("aft_clpt_ind_seq", "aftClptIndSeq");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("bfr_vps_etd_dt", "bfrVpsEtdDt");
        this.hashFields.put("diff_rmk", "diffRmk");
        this.hashFields.put("aft_vps_etd_dt", "aftVpsEtdDt");
        this.hashFields.put("vskd_cng_no", "vskdCngNo");
        this.hashFields.put("aft_vsl_cd", "aftVslCd");
        this.hashFields.put("aft_skd_dir_cd", "aftSkdDirCd");
        this.hashFields.put("bkg_atch_flg", "bkgAtchFlg");
        this.hashFields.put("bfr_pf_svc_tp_cd", "bfrPfSvcTpCd");
        this.hashFields.put("vt_add_call_flg", "vtAddCallFlg");
        this.hashFields.put("bfr_act_crr_cd", "bfrActCrrCd");
        this.hashFields.put("his_knd_cd", "hisKndCd");
        this.hashFields.put("his_save_knd_cd", "hisSaveKndCd");
        //this.hashFields.put("istargetforskdhisbyuser", "istargetforskdhisbyuser");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return aftSkdStsCd
	 */
    public String getAftSkdStsCd() {
        return this.aftSkdStsCd;
    }

    /**
	 * Column Info
	 * @return bfrSkdDirCd
	 */
    public String getBfrSkdDirCd() {
        return this.bfrSkdDirCd;
    }

    /**
	 * Column Info
	 * @return creDt
	 */
    public String getCreDt() {
        return this.creDt;
    }

    /**
	 * Column Info
	 * @return aftCallYdIndSeq
	 */
    public String getAftCallYdIndSeq() {
        return this.aftCallYdIndSeq;
    }

    /**
	 * Column Info
	 * @return bfrSkdStsCd
	 */
    public String getBfrSkdStsCd() {
        return this.bfrSkdStsCd;
    }

    /**
	 * Column Info
	 * @return aftYdCd
	 */
    public String getAftYdCd() {
        return this.aftYdCd;
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
	 * @return skdCngDesc
	 */
    public String getSkdCngDesc() {
        return this.skdCngDesc;
    }

    /**
	 * Column Info
	 * @return bfrClptIndSeq
	 */
    public String getBfrClptIndSeq() {
        return this.bfrClptIndSeq;
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
	 * @return aftVslSlanCd
	 */
    public String getAftVslSlanCd() {
        return this.aftVslSlanCd;
    }

    /**
	 * Column Info
	 * @return aftSkdVoyNo
	 */
    public String getAftSkdVoyNo() {
        return this.aftSkdVoyNo;
    }

    /**
	 * Column Info
	 * @return bfrSkdVoyNo
	 */
    public String getBfrSkdVoyNo() {
        return this.bfrSkdVoyNo;
    }

    /**
	 * Column Info
	 * @return aftVpsEtbDt
	 */
    public String getAftVpsEtbDt() {
        return this.aftVpsEtbDt;
    }

    /**
	 * Column Info
	 * @return bfrVslCd
	 */
    public String getBfrVslCd() {
        return this.bfrVslCd;
    }

    /**
	 * Column Info
	 * @return updUsrId
	 */
    public String getUpdUsrId() {
        return this.updUsrId;
    }

    /**
	 * Column Info
	 * @return bfrVpsPortCd
	 */
    public String getBfrVpsPortCd() {
        return this.bfrVpsPortCd;
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
	 * @return vskdTpCd
	 */
    public String getVskdTpCd() {
        return this.vskdTpCd;
    }

    /**
	 * Column Info
	 * @return aftVpsEtaDt
	 */
    public String getAftVpsEtaDt() {
        return this.aftVpsEtaDt;
    }

    /**
	 * Column Info
	 * @return bfrYdCd
	 */
    public String getBfrYdCd() {
        return this.bfrYdCd;
    }

    /**
	 * Column Info
	 * @return bfrCallYdIndSeq
	 */
    public String getBfrCallYdIndSeq() {
        return this.bfrCallYdIndSeq;
    }

    /**
	 * Column Info
	 * @return bfrVslSlanCd
	 */
    public String getBfrVslSlanCd() {
        return this.bfrVslSlanCd;
    }

    /**
	 * Column Info
	 * @return bfrVpsEtbDt
	 */
    public String getBfrVpsEtbDt() {
        return this.bfrVpsEtbDt;
    }

    /**
	 * Column Info
	 * @return aftVpsPortCd
	 */
    public String getAftVpsPortCd() {
        return this.aftVpsPortCd;
    }

    /**
	 * Column Info
	 * @return skdCngId
	 */
    public String getSkdCngId() {
        return this.skdCngId;
    }

    /**
	 * Column Info
	 * @return vskdCngTpCd
	 */
    public String getVskdCngTpCd() {
        return this.vskdCngTpCd;
    }

    /**
	 * Column Info
	 * @return bfrVpsEtaDt
	 */
    public String getBfrVpsEtaDt() {
        return this.bfrVpsEtaDt;
    }

    /**
	 * Column Info
	 * @return aftClptIndSeq
	 */
    public String getAftClptIndSeq() {
        return this.aftClptIndSeq;
    }

    /**
	 * Column Info
	 * @return creUsrId
	 */
    public String getCreUsrId() {
        return this.creUsrId;
    }

    /**
	 * Column Info
	 * @return bfrVpsEtdDt
	 */
    public String getBfrVpsEtdDt() {
        return this.bfrVpsEtdDt;
    }

    /**
	 * Column Info
	 * @return diffRmk
	 */
    public String getDiffRmk() {
        return this.diffRmk;
    }

    /**
	 * Column Info
	 * @return aftVpsEtdDt
	 */
    public String getAftVpsEtdDt() {
        return this.aftVpsEtdDt;
    }

    /**
	 * Column Info
	 * @return vskdCngNo
	 */
    public String getVskdCngNo() {
        return this.vskdCngNo;
    }

    /**
	 * Column Info
	 * @return aftVslCd
	 */
    public String getAftVslCd() {
        return this.aftVslCd;
    }

    /**
	 * Column Info
	 * @return aftSkdDirCd
	 */
    public String getAftSkdDirCd() {
        return this.aftSkdDirCd;
    }

    /**
	 * Column Info
	 * @return bkgAtchFlg
	 */
    public String getBkgAtchFlg() {
        return this.bkgAtchFlg;
    }

    /**
	 * Column Info
	 * @return bfrPfSvcTpCd
	 */
    public String getBfrPfSvcTpCd() {
        return this.bfrPfSvcTpCd;
    }

    /**
	 * Column Info
	 * @param bfrPfSvcTpCd
	 */
    public void setBfrPfSvcTpCd(String bfrPfSvcTpCd) {
        this.bfrPfSvcTpCd = bfrPfSvcTpCd;
    }

    /**
	 * Column Info
	 * @param bkgAtchFlg
	 */
    public void setBkgAtchFlg(String bkgAtchFlg) {
        this.bkgAtchFlg = bkgAtchFlg;
    }

    /**
	 * Column Info
	 * @param aftSkdStsCd
	 */
    public void setAftSkdStsCd(String aftSkdStsCd) {
        this.aftSkdStsCd = aftSkdStsCd;
    }

    /**
	 * Column Info
	 * @param bfrSkdDirCd
	 */
    public void setBfrSkdDirCd(String bfrSkdDirCd) {
        this.bfrSkdDirCd = bfrSkdDirCd;
    }

    /**
	 * Column Info
	 * @param creDt
	 */
    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    /**
	 * Column Info
	 * @param aftCallYdIndSeq
	 */
    public void setAftCallYdIndSeq(String aftCallYdIndSeq) {
        this.aftCallYdIndSeq = aftCallYdIndSeq;
    }

    /**
	 * Column Info
	 * @param bfrSkdStsCd
	 */
    public void setBfrSkdStsCd(String bfrSkdStsCd) {
        this.bfrSkdStsCd = bfrSkdStsCd;
    }

    /**
	 * Column Info
	 * @param aftYdCd
	 */
    public void setAftYdCd(String aftYdCd) {
        this.aftYdCd = aftYdCd;
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
	 * @param skdCngDesc
	 */
    public void setSkdCngDesc(String skdCngDesc) {
        this.skdCngDesc = skdCngDesc;
    }

    /**
	 * Column Info
	 * @param bfrClptIndSeq
	 */
    public void setBfrClptIndSeq(String bfrClptIndSeq) {
        this.bfrClptIndSeq = bfrClptIndSeq;
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
	 * @param aftVslSlanCd
	 */
    public void setAftVslSlanCd(String aftVslSlanCd) {
        this.aftVslSlanCd = aftVslSlanCd;
    }

    /**
	 * Column Info
	 * @param aftSkdVoyNo
	 */
    public void setAftSkdVoyNo(String aftSkdVoyNo) {
        this.aftSkdVoyNo = aftSkdVoyNo;
    }

    /**
	 * Column Info
	 * @param bfrSkdVoyNo
	 */
    public void setBfrSkdVoyNo(String bfrSkdVoyNo) {
        this.bfrSkdVoyNo = bfrSkdVoyNo;
    }

    /**
	 * Column Info
	 * @param aftVpsEtbDt
	 */
    public void setAftVpsEtbDt(String aftVpsEtbDt) {
        this.aftVpsEtbDt = aftVpsEtbDt;
    }

    /**
	 * Column Info
	 * @param bfrVslCd
	 */
    public void setBfrVslCd(String bfrVslCd) {
        this.bfrVslCd = bfrVslCd;
    }

    /**
	 * Column Info
	 * @param updUsrId
	 */
    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    /**
	 * Column Info
	 * @param bfrVpsPortCd
	 */
    public void setBfrVpsPortCd(String bfrVpsPortCd) {
        this.bfrVpsPortCd = bfrVpsPortCd;
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
	 * @param vskdTpCd
	 */
    public void setVskdTpCd(String vskdTpCd) {
        this.vskdTpCd = vskdTpCd;
    }

    /**
	 * Column Info
	 * @param aftVpsEtaDt
	 */
    public void setAftVpsEtaDt(String aftVpsEtaDt) {
        this.aftVpsEtaDt = aftVpsEtaDt;
    }

    /**
	 * Column Info
	 * @param bfrYdCd
	 */
    public void setBfrYdCd(String bfrYdCd) {
        this.bfrYdCd = bfrYdCd;
    }

    /**
	 * Column Info
	 * @param bfrCallYdIndSeq
	 */
    public void setBfrCallYdIndSeq(String bfrCallYdIndSeq) {
        this.bfrCallYdIndSeq = bfrCallYdIndSeq;
    }

    /**
	 * Column Info
	 * @param bfrVslSlanCd
	 */
    public void setBfrVslSlanCd(String bfrVslSlanCd) {
        this.bfrVslSlanCd = bfrVslSlanCd;
    }

    /**
	 * Column Info
	 * @param bfrVpsEtbDt
	 */
    public void setBfrVpsEtbDt(String bfrVpsEtbDt) {
        this.bfrVpsEtbDt = bfrVpsEtbDt;
    }

    /**
	 * Column Info
	 * @param aftVpsPortCd
	 */
    public void setAftVpsPortCd(String aftVpsPortCd) {
        this.aftVpsPortCd = aftVpsPortCd;
    }

    /**
	 * Column Info
	 * @param skdCngId
	 */
    public void setSkdCngId(String skdCngId) {
        this.skdCngId = skdCngId;
    }

    /**
	 * Column Info
	 * @param vskdCngTpCd
	 */
    public void setVskdCngTpCd(String vskdCngTpCd) {
        this.vskdCngTpCd = vskdCngTpCd;
    }

    /**
	 * Column Info
	 * @param bfrVpsEtaDt
	 */
    public void setBfrVpsEtaDt(String bfrVpsEtaDt) {
        this.bfrVpsEtaDt = bfrVpsEtaDt;
    }

    /**
	 * Column Info
	 * @param aftClptIndSeq
	 */
    public void setAftClptIndSeq(String aftClptIndSeq) {
        this.aftClptIndSeq = aftClptIndSeq;
    }

    /**
	 * Column Info
	 * @param creUsrId
	 */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    /**
	 * Column Info
	 * @param bfrVpsEtdDt
	 */
    public void setBfrVpsEtdDt(String bfrVpsEtdDt) {
        this.bfrVpsEtdDt = bfrVpsEtdDt;
    }

    /**
	 * Column Info
	 * @param diffRmk
	 */
    public void setDiffRmk(String diffRmk) {
        this.diffRmk = diffRmk;
    }

    /**
	 * Column Info
	 * @param aftVpsEtdDt
	 */
    public void setAftVpsEtdDt(String aftVpsEtdDt) {
        this.aftVpsEtdDt = aftVpsEtdDt;
    }

    /**
	 * Column Info
	 * @param vskdCngNo
	 */
    public void setVskdCngNo(String vskdCngNo) {
        this.vskdCngNo = vskdCngNo;
    }

    /**
	 * Column Info
	 * @param aftVslCd
	 */
    public void setAftVslCd(String aftVslCd) {
        this.aftVslCd = aftVslCd;
    }

    /**
	 * Column Info
	 * @param aftSkdDirCd
	 */
    public void setAftSkdDirCd(String aftSkdDirCd) {
        this.aftSkdDirCd = aftSkdDirCd;
    }

    public void setVtAddCallFlg(String vtAddCallFlg) {
        this.vtAddCallFlg = vtAddCallFlg;
    }

    public String getVtAddCallFlg() {
        return this.vtAddCallFlg;
    }

    public void setIstargetforskdhisbyuser(boolean istargetforskdhisbyuser) {
        this.istargetforskdhisbyuser = istargetforskdhisbyuser;
    }

    public boolean getIstargetforskdhisbyuser() {
        return this.istargetforskdhisbyuser;
    }

    public void setBfrActCrrCd(String bfrActCrrCd) {
        this.bfrActCrrCd = bfrActCrrCd;
    }

    public String getBfrActCrrCd() {
        return this.bfrActCrrCd;
    }

    public void setHisSaveKndCd(String hisSaveKndCd) {
        this.hisSaveKndCd = hisSaveKndCd;
    }

    public String getHisSaveKndCd() {
        return this.hisSaveKndCd;
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
        setAftSkdStsCd(JSPUtil.getParameter(request, prefix + "aft_skd_sts_cd", ""));
        setBfrSkdDirCd(JSPUtil.getParameter(request, prefix + "bfr_skd_dir_cd", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setAftCallYdIndSeq(JSPUtil.getParameter(request, prefix + "aft_call_yd_ind_seq", ""));
        setBfrSkdStsCd(JSPUtil.getParameter(request, prefix + "bfr_skd_sts_cd", ""));
        setAftYdCd(JSPUtil.getParameter(request, prefix + "aft_yd_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setSkdCngDesc(JSPUtil.getParameter(request, prefix + "skd_cng_desc", ""));
        setBfrClptIndSeq(JSPUtil.getParameter(request, prefix + "bfr_clpt_ind_seq", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setAftVslSlanCd(JSPUtil.getParameter(request, prefix + "aft_vsl_slan_cd", ""));
        setAftSkdVoyNo(JSPUtil.getParameter(request, prefix + "aft_skd_voy_no", ""));
        setBfrSkdVoyNo(JSPUtil.getParameter(request, prefix + "bfr_skd_voy_no", ""));
        setAftVpsEtbDt(JSPUtil.getParameter(request, prefix + "aft_vps_etb_dt", ""));
        setBfrVslCd(JSPUtil.getParameter(request, prefix + "bfr_vsl_cd", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setBfrVpsPortCd(JSPUtil.getParameter(request, prefix + "bfr_vps_port_cd", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setVskdTpCd(JSPUtil.getParameter(request, prefix + "vskd_tp_cd", ""));
        setAftVpsEtaDt(JSPUtil.getParameter(request, prefix + "aft_vps_eta_dt", ""));
        setBfrYdCd(JSPUtil.getParameter(request, prefix + "bfr_yd_cd", ""));
        setBfrCallYdIndSeq(JSPUtil.getParameter(request, prefix + "bfr_call_yd_ind_seq", ""));
        setBfrVslSlanCd(JSPUtil.getParameter(request, prefix + "bfr_vsl_slan_cd", ""));
        setBfrVpsEtbDt(JSPUtil.getParameter(request, prefix + "bfr_vps_etb_dt", ""));
        setAftVpsPortCd(JSPUtil.getParameter(request, prefix + "aft_vps_port_cd", ""));
        setSkdCngId(JSPUtil.getParameter(request, prefix + "skd_cng_id", ""));
        setVskdCngTpCd(JSPUtil.getParameter(request, prefix + "vskd_cng_tp_cd", ""));
        setBfrVpsEtaDt(JSPUtil.getParameter(request, prefix + "bfr_vps_eta_dt", ""));
        setAftClptIndSeq(JSPUtil.getParameter(request, prefix + "aft_clpt_ind_seq", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setBfrVpsEtdDt(JSPUtil.getParameter(request, prefix + "bfr_vps_etd_dt", ""));
        setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
        setAftVpsEtdDt(JSPUtil.getParameter(request, prefix + "aft_vps_etd_dt", ""));
        setVskdCngNo(JSPUtil.getParameter(request, prefix + "vskd_cng_no", ""));
        setAftVslCd(JSPUtil.getParameter(request, prefix + "aft_vsl_cd", ""));
        setAftSkdDirCd(JSPUtil.getParameter(request, prefix + "aft_skd_dir_cd", ""));
        setVtAddCallFlg(JSPUtil.getParameter(request, prefix + "vt_add_call_flg", ""));
        setBfrActCrrCd(JSPUtil.getParameter(request, prefix + "bfr_act_crr_cd", ""));
        setHisSaveKndCd(JSPUtil.getParameter(request, prefix + "his_save_knd_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VslSkdXtraHisVO[]
	 */
    public VslSkdXtraHisVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VslSkdXtraHisVO[]
	 */
    public VslSkdXtraHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        VslSkdXtraHisVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] aftSkdStsCd = (JSPUtil.getParameter(request, prefix + "aft_skd_sts_cd", length));
            String[] bfrSkdDirCd = (JSPUtil.getParameter(request, prefix + "bfr_skd_dir_cd", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] aftCallYdIndSeq = (JSPUtil.getParameter(request, prefix + "aft_call_yd_ind_seq", length));
            String[] bfrSkdStsCd = (JSPUtil.getParameter(request, prefix + "bfr_skd_sts_cd", length));
            String[] aftYdCd = (JSPUtil.getParameter(request, prefix + "aft_yd_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] skdCngDesc = (JSPUtil.getParameter(request, prefix + "skd_cng_desc", length));
            String[] bfrClptIndSeq = (JSPUtil.getParameter(request, prefix + "bfr_clpt_ind_seq", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] aftVslSlanCd = (JSPUtil.getParameter(request, prefix + "aft_vsl_slan_cd", length));
            String[] aftSkdVoyNo = (JSPUtil.getParameter(request, prefix + "aft_skd_voy_no", length));
            String[] bfrSkdVoyNo = (JSPUtil.getParameter(request, prefix + "bfr_skd_voy_no", length));
            String[] aftVpsEtbDt = (JSPUtil.getParameter(request, prefix + "aft_vps_etb_dt", length));
            String[] bfrVslCd = (JSPUtil.getParameter(request, prefix + "bfr_vsl_cd", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] bfrVpsPortCd = (JSPUtil.getParameter(request, prefix + "bfr_vps_port_cd", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] vskdTpCd = (JSPUtil.getParameter(request, prefix + "vskd_tp_cd", length));
            String[] aftVpsEtaDt = (JSPUtil.getParameter(request, prefix + "aft_vps_eta_dt", length));
            String[] bfrYdCd = (JSPUtil.getParameter(request, prefix + "bfr_yd_cd", length));
            String[] bfrCallYdIndSeq = (JSPUtil.getParameter(request, prefix + "bfr_call_yd_ind_seq", length));
            String[] bfrVslSlanCd = (JSPUtil.getParameter(request, prefix + "bfr_vsl_slan_cd", length));
            String[] bfrVpsEtbDt = (JSPUtil.getParameter(request, prefix + "bfr_vps_etb_dt", length));
            String[] aftVpsPortCd = (JSPUtil.getParameter(request, prefix + "aft_vps_port_cd", length));
            String[] skdCngId = (JSPUtil.getParameter(request, prefix + "skd_cng_id", length));
            String[] vskdCngTpCd = (JSPUtil.getParameter(request, prefix + "vskd_cng_tp_cd", length));
            String[] bfrVpsEtaDt = (JSPUtil.getParameter(request, prefix + "bfr_vps_eta_dt", length));
            String[] aftClptIndSeq = (JSPUtil.getParameter(request, prefix + "aft_clpt_ind_seq", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] bfrVpsEtdDt = (JSPUtil.getParameter(request, prefix + "bfr_vps_etd_dt", length));
            String[] diffRmk = (JSPUtil.getParameter(request, prefix + "diff_rmk", length));
            String[] aftVpsEtdDt = (JSPUtil.getParameter(request, prefix + "aft_vps_etd_dt", length));
            String[] vskdCngNo = (JSPUtil.getParameter(request, prefix + "vskd_cng_no", length));
            String[] aftVslCd = (JSPUtil.getParameter(request, prefix + "aft_vsl_cd", length));
            String[] aftSkdDirCd = (JSPUtil.getParameter(request, prefix + "aft_skd_dir_cd", length));
            String[] vtAddCallFlg = (JSPUtil.getParameter(request, prefix + "vt_add_call_flg", length));
            String[] istargetforskdhisbyuser = (JSPUtil.getParameter(request, prefix + "istargetforskdhisbyuser", length));
            String[] bfrActCrrCd = (JSPUtil.getParameter(request, prefix + "bfr_act_crr_cd", length));
            String[] hisKndCd = (JSPUtil.getParameter(request, prefix + "his_knd_cd", length));
            String[] hisSaveKndCd = (JSPUtil.getParameter(request, prefix + "his_save_knd_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new VslSkdXtraHisVO();
                if (aftSkdStsCd[i] != null)
                    model.setAftSkdStsCd(aftSkdStsCd[i]);
                if (bfrSkdDirCd[i] != null)
                    model.setBfrSkdDirCd(bfrSkdDirCd[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (aftCallYdIndSeq[i] != null)
                    model.setAftCallYdIndSeq(aftCallYdIndSeq[i]);
                if (bfrSkdStsCd[i] != null)
                    model.setBfrSkdStsCd(bfrSkdStsCd[i]);
                if (aftYdCd[i] != null)
                    model.setAftYdCd(aftYdCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (skdCngDesc[i] != null)
                    model.setSkdCngDesc(skdCngDesc[i]);
                if (bfrClptIndSeq[i] != null)
                    model.setBfrClptIndSeq(bfrClptIndSeq[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (aftVslSlanCd[i] != null)
                    model.setAftVslSlanCd(aftVslSlanCd[i]);
                if (aftSkdVoyNo[i] != null)
                    model.setAftSkdVoyNo(aftSkdVoyNo[i]);
                if (bfrSkdVoyNo[i] != null)
                    model.setBfrSkdVoyNo(bfrSkdVoyNo[i]);
                if (aftVpsEtbDt[i] != null)
                    model.setAftVpsEtbDt(aftVpsEtbDt[i]);
                if (bfrVslCd[i] != null)
                    model.setBfrVslCd(bfrVslCd[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (bfrVpsPortCd[i] != null)
                    model.setBfrVpsPortCd(bfrVpsPortCd[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (vskdTpCd[i] != null)
                    model.setVskdTpCd(vskdTpCd[i]);
                if (aftVpsEtaDt[i] != null)
                    model.setAftVpsEtaDt(aftVpsEtaDt[i]);
                if (bfrYdCd[i] != null)
                    model.setBfrYdCd(bfrYdCd[i]);
                if (bfrCallYdIndSeq[i] != null)
                    model.setBfrCallYdIndSeq(bfrCallYdIndSeq[i]);
                if (bfrVslSlanCd[i] != null)
                    model.setBfrVslSlanCd(bfrVslSlanCd[i]);
                if (bfrVpsEtbDt[i] != null)
                    model.setBfrVpsEtbDt(bfrVpsEtbDt[i]);
                if (aftVpsPortCd[i] != null)
                    model.setAftVpsPortCd(aftVpsPortCd[i]);
                if (skdCngId[i] != null)
                    model.setSkdCngId(skdCngId[i]);
                if (vskdCngTpCd[i] != null)
                    model.setVskdCngTpCd(vskdCngTpCd[i]);
                if (bfrVpsEtaDt[i] != null)
                    model.setBfrVpsEtaDt(bfrVpsEtaDt[i]);
                if (aftClptIndSeq[i] != null)
                    model.setAftClptIndSeq(aftClptIndSeq[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (bfrVpsEtdDt[i] != null)
                    model.setBfrVpsEtdDt(bfrVpsEtdDt[i]);
                if (diffRmk[i] != null)
                    model.setDiffRmk(diffRmk[i]);
                if (aftVpsEtdDt[i] != null)
                    model.setAftVpsEtdDt(aftVpsEtdDt[i]);
                if (vskdCngNo[i] != null)
                    model.setVskdCngNo(vskdCngNo[i]);
                if (aftVslCd[i] != null)
                    model.setAftVslCd(aftVslCd[i]);
                if (aftSkdDirCd[i] != null)
                    model.setAftSkdDirCd(aftSkdDirCd[i]);
                if (vtAddCallFlg[i] != null)
                    model.setVtAddCallFlg(vtAddCallFlg[i]);
                if (bfrActCrrCd[i] != null)
                    model.setBfrActCrrCd(bfrActCrrCd[i]);
                if (hisSaveKndCd[i] != null) 
		    		model.setHisSaveKndCd(hisSaveKndCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getVslSkdXtraHisVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return VslSkdXtraHisVO[]
	 */
    public VslSkdXtraHisVO[] getVslSkdXtraHisVOs() {
        VslSkdXtraHisVO[] vos = (VslSkdXtraHisVO[]) models.toArray(new VslSkdXtraHisVO[models.size()]);
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
        this.aftSkdStsCd = this.aftSkdStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bfrSkdDirCd = this.bfrSkdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aftCallYdIndSeq = this.aftCallYdIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bfrSkdStsCd = this.bfrSkdStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aftYdCd = this.aftYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdCngDesc = this.skdCngDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bfrClptIndSeq = this.bfrClptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aftVslSlanCd = this.aftVslSlanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aftSkdVoyNo = this.aftSkdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bfrSkdVoyNo = this.bfrSkdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aftVpsEtbDt = this.aftVpsEtbDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bfrVslCd = this.bfrVslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bfrVpsPortCd = this.bfrVpsPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vskdTpCd = this.vskdTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aftVpsEtaDt = this.aftVpsEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bfrYdCd = this.bfrYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bfrCallYdIndSeq = this.bfrCallYdIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bfrVslSlanCd = this.bfrVslSlanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bfrVpsEtbDt = this.bfrVpsEtbDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aftVpsPortCd = this.aftVpsPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdCngId = this.skdCngId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vskdCngTpCd = this.vskdCngTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bfrVpsEtaDt = this.bfrVpsEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aftClptIndSeq = this.aftClptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bfrVpsEtdDt = this.bfrVpsEtdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diffRmk = this.diffRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aftVpsEtdDt = this.aftVpsEtdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vskdCngNo = this.vskdCngNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aftVslCd = this.aftVslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aftSkdDirCd = this.aftSkdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vtAddCallFlg = this.vtAddCallFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bfrActCrrCd = this.bfrActCrrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hisSaveKndCd = this.hisSaveKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
