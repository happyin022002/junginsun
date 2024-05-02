/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LongRangeSkdInqVO.java
*@FileTitle : LongRangeSkdInqVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.07.07 유혁 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;


/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 유혁
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class LongRangeSkdInqVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<LongRangeSkdInqVO> models = new ArrayList<LongRangeSkdInqVO>();

    /* Column Info */
    private String startDate = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String vpsRmk = null;

    /* Column Info */
    private String vpsEtbDt = null;

    /* Column Info */
    private String etbDyCd = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String pfSkdTpCd = null;

    /* Column Info */
    private String endDate = null;

    /* Column Info */
    private String vslSlanCd = null;

    /* Column Info */
    private String vpsEtaDt = null;

    /* Column Info */
    private String etdDyCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String clptSeq = null;

    /* Column Info */
    private String vpsPortCd = null;

    /* Column Info */
    private String grp = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String lastGrp = null;

    /* Column Info */
    private String portSkdStsCd = null;

    /* Column Info */
    private String portRotnSeq = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String vpsEtdDt = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String minDt = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Column Info */
    private String etdTmHrmnt = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String skdCngStsCd = null;

    /* Column Info */
    private String etbTmHrmnt = null;

    /* Column Info */
    private String clptIndSeq = null;

    /* Column Info */
    private String maxNumber = null;

    /* Column Info */
    private boolean remarkFlag = false;

    /* Column Info */
    private String pfEtaDt = null;

    /* Column Info */
    private String pfEtbDt = null;

    /* Column Info */
    private String pfEtdDt = null;

    /* Column Info */
    private String initEtaDt = null;

    /* Column Info */
    private String initEtbDt = null;

    /* Column Info */
    private String initEtdDt = null;

    private boolean emptySkd = false;

    private boolean addingSkd = false;

    private boolean reverse = false;

    /* Column Info */
    private String rmkSeq = null;

    /* Column Info */
    private String rmkDesc = null;
    
    /* Column Info */
    private String obCssmVoyNo = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public LongRangeSkdInqVO() {
    }

    public LongRangeSkdInqVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String vpsPortCd, String clptIndSeq, String clptSeq, String portSkdStsCd, String skdCngStsCd, String vpsRmk, String vslSlanCd, String pfSkdTpCd, String vpsEtaDt, String vpsEtbDt, String vpsEtdDt, String creDt, String creUsrId, String updDt, String updUsrId, String portRotnSeq, String etbDyCd, String etbTmHrmnt, String etdDyCd, String etdTmHrmnt, String grp, String lastGrp, String maxNumber, String minDt, String startDate, String endDate, String pfEtaDt, String pfEtbDt, String pfEtdDt, String initEtaDt, String initEtbDt, String initEtdDt, String rmkSeq, String rmkDesc, String obCssmVoyNo) {
        this.startDate = startDate;
        this.vslCd = vslCd;
        this.vpsRmk = vpsRmk;
        this.vpsEtbDt = vpsEtbDt;
        this.etbDyCd = etbDyCd;
        this.creDt = creDt;
        this.pfSkdTpCd = pfSkdTpCd;
        this.endDate = endDate;
        this.vslSlanCd = vslSlanCd;
        this.vpsEtaDt = vpsEtaDt;
        this.etdDyCd = etdDyCd;
        this.pagerows = pagerows;
        this.clptSeq = clptSeq;
        this.vpsPortCd = vpsPortCd;
        this.grp = grp;
        this.ibflag = ibflag;
        this.lastGrp = lastGrp;
        this.portSkdStsCd = portSkdStsCd;
        this.portRotnSeq = portRotnSeq;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.vpsEtdDt = vpsEtdDt;
        this.skdVoyNo = skdVoyNo;
        this.minDt = minDt;
        this.skdDirCd = skdDirCd;
        this.etdTmHrmnt = etdTmHrmnt;
        this.creUsrId = creUsrId;
        this.skdCngStsCd = skdCngStsCd;
        this.etbTmHrmnt = etbTmHrmnt;
        this.clptIndSeq = clptIndSeq;
        this.maxNumber = maxNumber;
        this.pfEtaDt = pfEtaDt;
        this.pfEtbDt = pfEtbDt;
        this.pfEtdDt = pfEtdDt;
        this.initEtaDt = initEtaDt;
        this.initEtbDt = initEtbDt;
        this.initEtdDt = initEtdDt;
        this.rmkSeq = rmkSeq;
        this.rmkDesc = rmkDesc;
        this.obCssmVoyNo = obCssmVoyNo;

    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("start_date", getStartDate());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("vps_rmk", getVpsRmk());
        this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
        this.hashColumns.put("etb_dy_cd", getEtbDyCd());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("pf_skd_tp_cd", getPfSkdTpCd());
        this.hashColumns.put("end_date", getEndDate());
        this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
        this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
        this.hashColumns.put("etd_dy_cd", getEtdDyCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("clpt_seq", getClptSeq());
        this.hashColumns.put("vps_port_cd", getVpsPortCd());
        this.hashColumns.put("grp", getGrp());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("last_grp", getLastGrp());
        this.hashColumns.put("port_skd_sts_cd", getPortSkdStsCd());
        this.hashColumns.put("port_rotn_seq", getPortRotnSeq());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("min_dt", getMinDt());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("etd_tm_hrmnt", getEtdTmHrmnt());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("skd_cng_sts_cd", getSkdCngStsCd());
        this.hashColumns.put("etb_tm_hrmnt", getEtbTmHrmnt());
        this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
        this.hashColumns.put("max_number", getMaxNumber());
        this.hashColumns.put("pf_eta_dt", getPfEtaDt());
        this.hashColumns.put("pf_etb_dt", getPfEtbDt());
        this.hashColumns.put("pf_etd_dt", getPfEtdDt());
        this.hashColumns.put("init_eta_dt", getInitEtaDt());
        this.hashColumns.put("init_etb_dt", getInitEtbDt());
        this.hashColumns.put("init_etd_dt", getInitEtdDt());
        this.hashColumns.put("rmk_seq", getRmkSeq());
        this.hashColumns.put("rmk_desc", getRmkDesc());
        this.hashColumns.put("ob_cssm_voy_no", getObCssmVoyNo());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("start_date", "startDate");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("vps_rmk", "vpsRmk");
        this.hashFields.put("vps_etb_dt", "vpsEtbDt");
        this.hashFields.put("etb_dy_cd", "etbDyCd");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("pf_skd_tp_cd", "pfSkdTpCd");
        this.hashFields.put("end_date", "endDate");
        this.hashFields.put("vsl_slan_cd", "vslSlanCd");
        this.hashFields.put("vps_eta_dt", "vpsEtaDt");
        this.hashFields.put("etd_dy_cd", "etdDyCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("clpt_seq", "clptSeq");
        this.hashFields.put("vps_port_cd", "vpsPortCd");
        this.hashFields.put("grp", "grp");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("last_grp", "lastGrp");
        this.hashFields.put("port_skd_sts_cd", "portSkdStsCd");
        this.hashFields.put("port_rotn_seq", "portRotnSeq");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("vps_etd_dt", "vpsEtdDt");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("min_dt", "minDt");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("etd_tm_hrmnt", "etdTmHrmnt");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("skd_cng_sts_cd", "skdCngStsCd");
        this.hashFields.put("etb_tm_hrmnt", "etbTmHrmnt");
        this.hashFields.put("clpt_ind_seq", "clptIndSeq");
        this.hashFields.put("max_number", "maxNumber");
        this.hashFields.put("pf_eta_dt", "pfEtaDt");
        this.hashFields.put("pf_etb_dt", "pfEtbDt");
        this.hashFields.put("pf_etd_dt", "pfEtdDt");
        this.hashFields.put("init_eta_dt", "initEtaDt");
        this.hashFields.put("init_etb_dt", "initEtbDt");
        this.hashFields.put("init_etd_dt", "initEtdDt");
        this.hashFields.put("rmk_seq", "rmkSeq");
        this.hashFields.put("rmk_desc", "rmkDesc");
        this.hashFields.put("ob_cssm_voy_no", "obCssmVoyNo");

        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return startDate
	 */
    public String getStartDate() {
        return this.startDate;
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
	 * @return vpsRmk
	 */
    public String getVpsRmk() {
        return this.vpsRmk;
    }

    /**
	 * Column Info
	 * @return vpsEtbDt
	 */
    public String getVpsEtbDt() {
        return this.vpsEtbDt;
    }

    /**
	 * Column Info
	 * @return etbDyCd
	 */
    public String getEtbDyCd() {
        return this.etbDyCd;
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
	 * @return pfSkdTpCd
	 */
    public String getPfSkdTpCd() {
        return this.pfSkdTpCd;
    }

    /**
	 * Column Info
	 * @return endDate
	 */
    public String getEndDate() {
        return this.endDate;
    }

    /**
	 * Column Info
	 * @return vslSlanCd
	 */
    public String getVslSlanCd() {
        return this.vslSlanCd;
    }

    /**
	 * Column Info
	 * @return vpsEtaDt
	 */
    public String getVpsEtaDt() {
        return this.vpsEtaDt;
    }

    /**
	 * Column Info
	 * @return etdDyCd
	 */
    public String getEtdDyCd() {
        return this.etdDyCd;
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
	 * @return clptSeq
	 */
    public String getClptSeq() {
        return this.clptSeq;
    }

    /**
	 * Column Info
	 * @return vpsPortCd
	 */
    public String getVpsPortCd() {
        return this.vpsPortCd;
    }

    /**
	 * Column Info
	 * @return grp
	 */
    public String getGrp() {
        return this.grp;
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
	 * @return lastGrp
	 */
    public String getLastGrp() {
        return this.lastGrp;
    }

    /**
	 * Column Info
	 * @return portSkdStsCd
	 */
    public String getPortSkdStsCd() {
        return this.portSkdStsCd;
    }

    /**
	 * Column Info
	 * @return portRotnSeq
	 */
    public String getPortRotnSeq() {
        return this.portRotnSeq;
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
	 * @return updDt
	 */
    public String getUpdDt() {
        return this.updDt;
    }

    /**
	 * Column Info
	 * @return vpsEtdDt
	 */
    public String getVpsEtdDt() {
        return this.vpsEtdDt;
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
	 * @return minDt
	 */
    public String getMinDt() {
        return this.minDt;
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
	 * @return etdTmHrmnt
	 */
    public String getEtdTmHrmnt() {
        return this.etdTmHrmnt;
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
	 * @return skdCngStsCd
	 */
    public String getSkdCngStsCd() {
        return this.skdCngStsCd;
    }

    /**
	 * Column Info
	 * @return etbTmHrmnt
	 */
    public String getEtbTmHrmnt() {
        return this.etbTmHrmnt;
    }

    /**
	 * Column Info
	 * @return clptIndSeq
	 */
    public String getClptIndSeq() {
        return this.clptIndSeq;
    }

    /**
	 * Column Info
	 * @return maxNumber
	 */
    public String getMaxNumber() {
        return this.maxNumber;
    }

    /**
	 * Column Info
	 * @return remarkFlag
	 */
    public boolean isRemarkFlag() {
        return this.remarkFlag;
    }

    /**
	 * Column Info
	 * @return pfEtaDt
	 */
    public String getPfEtaDt() {
        return this.pfEtaDt;
    }

    /**
	 * Column Info
	 * @return pfEtbDt
	 */
    public String getPfEtbDt() {
        return this.pfEtbDt;
    }

    /**
	 * Column Info
	 * @return pfEtdDt
	 */
    public String getPfEtdDt() {
        return this.pfEtdDt;
    }

    /**
	 * Column Info
	 * @return initEtaDt
	 */
    public String getInitEtaDt() {
        return this.initEtaDt;
    }

    /**
	 * Column Info
	 * @return initEtbDt
	 */
    public String getInitEtbDt() {
        return this.initEtbDt;
    }

    /**
	 * Column Info
	 * @return initEtdDt
	 */
    public String getInitEtdDt() {
        return this.initEtdDt;
    }
    
    /**
	 * Column Info
	 * @return obCssmVoyNo
	 */
    public String getObCssmVoyNo() {
        return this.obCssmVoyNo;
    }


    /**
	 * Column Info
	 * @param startDate
	 */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
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
	 * @param vpsRmk
	 */
    public void setVpsRmk(String vpsRmk) {
        this.vpsRmk = vpsRmk;
    }

    /**
	 * Column Info
	 * @param vpsEtbDt
	 */
    public void setVpsEtbDt(String vpsEtbDt) {
        this.vpsEtbDt = vpsEtbDt;
    }

    /**
	 * Column Info
	 * @param etbDyCd
	 */
    public void setEtbDyCd(String etbDyCd) {
        this.etbDyCd = etbDyCd;
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
	 * @param pfSkdTpCd
	 */
    public void setPfSkdTpCd(String pfSkdTpCd) {
        this.pfSkdTpCd = pfSkdTpCd;
    }

    /**
	 * Column Info
	 * @param endDate
	 */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
	 * Column Info
	 * @param vslSlanCd
	 */
    public void setVslSlanCd(String vslSlanCd) {
        this.vslSlanCd = vslSlanCd;
    }

    /**
	 * Column Info
	 * @param vpsEtaDt
	 */
    public void setVpsEtaDt(String vpsEtaDt) {
        this.vpsEtaDt = vpsEtaDt;
    }

    /**
	 * Column Info
	 * @param etdDyCd
	 */
    public void setEtdDyCd(String etdDyCd) {
        this.etdDyCd = etdDyCd;
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
	 * @param clptSeq
	 */
    public void setClptSeq(String clptSeq) {
        this.clptSeq = clptSeq;
    }

    /**
	 * Column Info
	 * @param vpsPortCd
	 */
    public void setVpsPortCd(String vpsPortCd) {
        this.vpsPortCd = vpsPortCd;
    }

    /**
	 * Column Info
	 * @param grp
	 */
    public void setGrp(String grp) {
        this.grp = grp;
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
	 * @param lastGrp
	 */
    public void setLastGrp(String lastGrp) {
        this.lastGrp = lastGrp;
    }

    /**
	 * Column Info
	 * @param portSkdStsCd
	 */
    public void setPortSkdStsCd(String portSkdStsCd) {
        this.portSkdStsCd = portSkdStsCd;
    }

    /**
	 * Column Info
	 * @param portRotnSeq
	 */
    public void setPortRotnSeq(String portRotnSeq) {
        this.portRotnSeq = portRotnSeq;
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
	 * @param updDt
	 */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
	 * Column Info
	 * @param vpsEtdDt
	 */
    public void setVpsEtdDt(String vpsEtdDt) {
        this.vpsEtdDt = vpsEtdDt;
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
	 * @param minDt
	 */
    public void setMinDt(String minDt) {
        this.minDt = minDt;
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
	 * @param etdTmHrmnt
	 */
    public void setEtdTmHrmnt(String etdTmHrmnt) {
        this.etdTmHrmnt = etdTmHrmnt;
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
	 * @param skdCngStsCd
	 */
    public void setSkdCngStsCd(String skdCngStsCd) {
        this.skdCngStsCd = skdCngStsCd;
    }

    /**
	 * Column Info
	 * @param etbTmHrmnt
	 */
    public void setEtbTmHrmnt(String etbTmHrmnt) {
        this.etbTmHrmnt = etbTmHrmnt;
    }

    /**
	 * Column Info
	 * @param clptIndSeq
	 */
    public void setClptIndSeq(String clptIndSeq) {
        this.clptIndSeq = clptIndSeq;
    }

    /**
	 * Column Info
	 * @param maxNumber
	 */
    public void setMaxNumber(String maxNumber) {
        this.maxNumber = maxNumber;
    }

    /**
	 * Column Info
	 * @param remarkFlag
	 */
    public void setRemarkFlag(boolean remarkFlag) {
        this.remarkFlag = remarkFlag;
    }

    /**
	 * Column Info
	 * @param pfEtaDt
	 */
    public void setPfEtaDt(String pfEtaDt) {
        this.pfEtaDt = pfEtaDt;
    }

    /**
	 * Column Info
	 * @param pfEtbDt
	 */
    public void setPfEtbDt(String pfEtbDt) {
        this.pfEtbDt = pfEtbDt;
    }

    /**
	 * Column Info
	 * @param pfEtdDt
	 */
    public void setPfEtdDt(String pfEtdDt) {
        this.pfEtdDt = pfEtdDt;
    }

    /**
	 * Column Info
	 * @param initEtaDt
	 */
    public void setInitEtaDt(String initEtaDt) {
        this.initEtaDt = initEtaDt;
    }

    /**
	 * Column Info
	 * @param initEtbDt
	 */
    public void setInitEtbDt(String initEtbDt) {
        this.initEtbDt = initEtbDt;
    }

    /**
	 * Column Info
	 * @param initEtdDt
	 */
    public void setInitEtdDt(String initEtdDt) {
        this.initEtdDt = initEtdDt;
    }

    public void setRmkSeq(String rmkSeq) {
        this.rmkSeq = rmkSeq;
    }

    public String getRmkSeq() {
        return this.rmkSeq;
    }

    public void setRmkDesc(String rmkDesc) {
        this.rmkDesc = rmkDesc;
    }
    
    public void setObCssmVoyNo(String obCssmVoyNo) {
        this.obCssmVoyNo = obCssmVoyNo;
    }

    public String getRmkDesc() {
        return this.rmkDesc;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setStartDate(JSPUtil.getParameter(request, "start_date", ""));
        setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
        setVpsRmk(JSPUtil.getParameter(request, "vps_rmk", ""));
        setVpsEtbDt(JSPUtil.getParameter(request, "vps_etb_dt", ""));
        setEtbDyCd(JSPUtil.getParameter(request, "etb_dy_cd", ""));
        setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
        setPfSkdTpCd(JSPUtil.getParameter(request, "pf_skd_tp_cd", ""));
        setEndDate(JSPUtil.getParameter(request, "end_date", ""));
        setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
        setVpsEtaDt(JSPUtil.getParameter(request, "vps_eta_dt", ""));
        setEtdDyCd(JSPUtil.getParameter(request, "etd_dy_cd", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setClptSeq(JSPUtil.getParameter(request, "clpt_seq", ""));
        setVpsPortCd(JSPUtil.getParameter(request, "vps_port_cd", ""));
        setGrp(JSPUtil.getParameter(request, "grp", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setLastGrp(JSPUtil.getParameter(request, "last_grp", ""));
        setPortSkdStsCd(JSPUtil.getParameter(request, "port_skd_sts_cd", ""));
        setPortRotnSeq(JSPUtil.getParameter(request, "port_rotn_seq", ""));
        setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
        setVpsEtdDt(JSPUtil.getParameter(request, "vps_etd_dt", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
        setMinDt(JSPUtil.getParameter(request, "min_dt", ""));
        setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
        setEtdTmHrmnt(JSPUtil.getParameter(request, "etd_tm_hrmnt", ""));
        setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
        setSkdCngStsCd(JSPUtil.getParameter(request, "skd_cng_sts_cd", ""));
        setEtbTmHrmnt(JSPUtil.getParameter(request, "etb_tm_hrmnt", ""));
        setClptIndSeq(JSPUtil.getParameter(request, "clpt_ind_seq", ""));
        setMaxNumber(JSPUtil.getParameter(request, "max_number", ""));
        setPfEtaDt(JSPUtil.getParameter(request, "pf_eta_dt", ""));
        setPfEtbDt(JSPUtil.getParameter(request, "pf_etb_dt", ""));
        setPfEtdDt(JSPUtil.getParameter(request, "pf_etd_dt", ""));
        setInitEtaDt(JSPUtil.getParameter(request, "init_eta_dt", ""));
        setInitEtbDt(JSPUtil.getParameter(request, "init_etb_dt", ""));
        setInitEtdDt(JSPUtil.getParameter(request, "init_etd_dt", ""));
        setObCssmVoyNo(JSPUtil.getParameter(request, "ob_cssm_voy_no", ""));

    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return LongRangeSkdInqVO[]
	 */
    public LongRangeSkdInqVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return LongRangeSkdInqVO[]
	 */
    public LongRangeSkdInqVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        LongRangeSkdInqVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] startDate = (JSPUtil.getParameter(request, prefix + "start_date", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] vpsRmk = (JSPUtil.getParameter(request, prefix + "vps_rmk", length));
            String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix + "vps_etb_dt", length));
            String[] etbDyCd = (JSPUtil.getParameter(request, prefix + "etb_dy_cd", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] pfSkdTpCd = (JSPUtil.getParameter(request, prefix + "pf_skd_tp_cd", length));
            String[] endDate = (JSPUtil.getParameter(request, prefix + "end_date", length));
            String[] vslSlanCd = (JSPUtil.getParameter(request, prefix + "vsl_slan_cd", length));
            String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix + "vps_eta_dt", length));
            String[] etdDyCd = (JSPUtil.getParameter(request, prefix + "etd_dy_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] clptSeq = (JSPUtil.getParameter(request, prefix + "clpt_seq", length));
            String[] vpsPortCd = (JSPUtil.getParameter(request, prefix + "vps_port_cd", length));
            String[] grp = (JSPUtil.getParameter(request, prefix + "grp", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] lastGrp = (JSPUtil.getParameter(request, prefix + "last_grp", length));
            String[] portSkdStsCd = (JSPUtil.getParameter(request, prefix + "port_skd_sts_cd", length));
            String[] portRotnSeq = (JSPUtil.getParameter(request, prefix + "port_rotn_seq", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix + "vps_etd_dt", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] minDt = (JSPUtil.getParameter(request, prefix + "min_dt", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] etdTmHrmnt = (JSPUtil.getParameter(request, prefix + "etd_tm_hrmnt", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] skdCngStsCd = (JSPUtil.getParameter(request, prefix + "skd_cng_sts_cd", length));
            String[] etbTmHrmnt = (JSPUtil.getParameter(request, prefix + "etb_tm_hrmnt", length));
            String[] clptIndSeq = (JSPUtil.getParameter(request, prefix + "clpt_ind_seq", length));
            String[] maxNumber = (JSPUtil.getParameter(request, prefix + "max_number", length));
            String[] pfEtaDt = (JSPUtil.getParameter(request, prefix + "pf_eta_dt", length));
            String[] pfEtbDt = (JSPUtil.getParameter(request, prefix + "pf_etb_dt", length));
            String[] pfEtdDt = (JSPUtil.getParameter(request, prefix + "pf_etd_dt", length));
            String[] initEtaDt = (JSPUtil.getParameter(request, prefix + "init_eta_dt", length));
            String[] initEtbDt = (JSPUtil.getParameter(request, prefix + "init_etb_dt", length));
            String[] initEtdDt = (JSPUtil.getParameter(request, prefix + "init_etd_dt", length));
            String[] rmkSeq = (JSPUtil.getParameter(request, prefix + "rmk_seq", length));
	    	String[] rmkDesc = (JSPUtil.getParameter(request, prefix + "rmk_desc", length));
	    	String[] obCssmVoyNo = (JSPUtil.getParameter(request, prefix + "ob_cssm_voy_no", length));

	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new LongRangeSkdInqVO();
                if (startDate[i] != null)
                    model.setStartDate(startDate[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (vpsRmk[i] != null)
                    model.setVpsRmk(vpsRmk[i]);
                if (vpsEtbDt[i] != null)
                    model.setVpsEtbDt(vpsEtbDt[i]);
                if (etbDyCd[i] != null)
                    model.setEtbDyCd(etbDyCd[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (pfSkdTpCd[i] != null)
                    model.setPfSkdTpCd(pfSkdTpCd[i]);
                if (endDate[i] != null)
                    model.setEndDate(endDate[i]);
                if (vslSlanCd[i] != null)
                    model.setVslSlanCd(vslSlanCd[i]);
                if (vpsEtaDt[i] != null)
                    model.setVpsEtaDt(vpsEtaDt[i]);
                if (etdDyCd[i] != null)
                    model.setEtdDyCd(etdDyCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (clptSeq[i] != null)
                    model.setClptSeq(clptSeq[i]);
                if (vpsPortCd[i] != null)
                    model.setVpsPortCd(vpsPortCd[i]);
                if (grp[i] != null)
                    model.setGrp(grp[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (lastGrp[i] != null)
                    model.setLastGrp(lastGrp[i]);
                if (portSkdStsCd[i] != null)
                    model.setPortSkdStsCd(portSkdStsCd[i]);
                if (portRotnSeq[i] != null)
                    model.setPortRotnSeq(portRotnSeq[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (vpsEtdDt[i] != null)
                    model.setVpsEtdDt(vpsEtdDt[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (minDt[i] != null)
                    model.setMinDt(minDt[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (etdTmHrmnt[i] != null)
                    model.setEtdTmHrmnt(etdTmHrmnt[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (skdCngStsCd[i] != null)
                    model.setSkdCngStsCd(skdCngStsCd[i]);
                if (etbTmHrmnt[i] != null)
                    model.setEtbTmHrmnt(etbTmHrmnt[i]);
                if (clptIndSeq[i] != null)
                    model.setClptIndSeq(clptIndSeq[i]);
                if (maxNumber[i] != null)
                    model.setMaxNumber(maxNumber[i]);
                if (pfEtaDt[i] != null)
                    model.setPfEtaDt(pfEtaDt[i]);
                if (pfEtbDt[i] != null)
                    model.setPfEtbDt(pfEtbDt[i]);
                if (pfEtdDt[i] != null)
                    model.setPfEtdDt(pfEtdDt[i]);
                if (initEtaDt[i] != null)
                    model.setInitEtaDt(initEtaDt[i]);
                if (initEtbDt[i] != null)
                    model.setInitEtbDt(initEtbDt[i]);
                if (initEtdDt[i] != null)
                    model.setInitEtdDt(initEtdDt[i]);
                if (rmkSeq[i] != null) 
		    		model.setRmkSeq(rmkSeq[i]);
				if (rmkDesc[i] != null) 
		    		model.setRmkDesc(rmkDesc[i]);
				if (obCssmVoyNo[i] != null) 
		    		model.setObCssmVoyNo(obCssmVoyNo[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getLongRangeSkdInqVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return LongRangeSkdInqVO[]
	 */
    public LongRangeSkdInqVO[] getLongRangeSkdInqVOs() {
        LongRangeSkdInqVO[] vos = (LongRangeSkdInqVO[]) models.toArray(new LongRangeSkdInqVO[models.size()]);
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
        this.startDate = this.startDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsRmk = this.vpsRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsEtbDt = this.vpsEtbDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.etbDyCd = this.etbDyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pfSkdTpCd = this.pfSkdTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.endDate = this.endDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslSlanCd = this.vslSlanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsEtaDt = this.vpsEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.etdDyCd = this.etdDyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.clptSeq = this.clptSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsPortCd = this.vpsPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.grp = this.grp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lastGrp = this.lastGrp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.portSkdStsCd = this.portSkdStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.portRotnSeq = this.portRotnSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsEtdDt = this.vpsEtdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.minDt = this.minDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.etdTmHrmnt = this.etdTmHrmnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdCngStsCd = this.skdCngStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.etbTmHrmnt = this.etbTmHrmnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.clptIndSeq = this.clptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.maxNumber = this.maxNumber.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pfEtaDt = this.pfEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pfEtbDt = this.pfEtbDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pfEtdDt = this.pfEtdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.initEtaDt = this.initEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.initEtbDt = this.initEtbDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.initEtdDt = this.initEtdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rmkSeq = this.rmkSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rmkDesc = this.rmkDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obCssmVoyNo = this.obCssmVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

    }

    public boolean isEmptySkd() {
        return emptySkd;
    }

    public void setEmptySkd(boolean emptySkd) {
        this.emptySkd = emptySkd;
    }

    public boolean isAddingSkd() {
        return addingSkd;
    }

    public void setAddingSkd(boolean addingSkd) {
        this.addingSkd = addingSkd;
    }

    public boolean isReverse() {
        return reverse;
    }

    public void setReverse(boolean reverse) {
        this.reverse = reverse;
    }
}
