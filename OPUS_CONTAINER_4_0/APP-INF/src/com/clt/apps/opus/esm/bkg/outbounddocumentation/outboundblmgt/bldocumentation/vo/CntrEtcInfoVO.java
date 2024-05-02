/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrEtcInfoVO.java
*@FileTitle : CntrEtcInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.17
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.12.17 김영출 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo;

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
 * @author 김영출
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class CntrEtcInfoVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<CntrEtcInfoVO> models = new ArrayList<CntrEtcInfoVO>();

    /* Column Info */
    private String porCd = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String bkgCgoTpCd = null;

    /* Column Info */
    private String bdrFlg = null;

    /* Column Info */
    private String bkgStsCd = null;

    /* Column Info */
    private String bkgMeasUtCd = null;

    /* Column Info */
    private String blNo = null;

    /* Column Info */
    private String cgoRcvDt = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String corrFlg = null;

    /* Column Info */
    private String polCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String tVvd = null;

    /* Column Info */
    private String modifyFnlCfmFlg = null;

    /* Column Info */
    private String evntUsrId = null;

    /* Column Info */
    private String rcvTermCd = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String evntDt = null;

    /* Column Info */
    private String notUpdatedFlg = null;

    /* Column Info */
    private String delCd = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Column Info */
    private String blTpCd = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String cnFlg = null;

    /* Column Info */
    private String deTermCd = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String flexHgtFlg = null;

    /* Column Info */
    private String fnlCfmFlg = null;

    /* Column Info */
    private String bkgWgtUtCd = null;

    private String shpFlg = null;

    private String ucrFlg = null;

    /* Column Info */
    private String senderId = null;

    /* Column Info */
    private String rqstNo = null;

    /* Column Info */
    private String rqstSeq = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public CntrEtcInfoVO() {
    }

    public CntrEtcInfoVO(String ibflag, String pagerows, String bkgNo, String blNo, String blTpCd, String bkgStsCd, String bkgCgoTpCd, String tVvd, String vslCd, String skdVoyNo, String skdDirCd, String porCd, String polCd, String podCd, String delCd, String rcvTermCd, String deTermCd, String evntUsrId, String evntDt, String fnlCfmFlg, String modifyFnlCfmFlg, String bkgWgtUtCd, String bkgMeasUtCd, String cgoRcvDt, String corrFlg, String bdrFlg, String notUpdatedFlg, String cnFlg, String flexHgtFlg, String creUsrId, String updUsrId, String shpFlg, String ucrFlg, String senderId, String rqstNo, String rqstSeq) {
        this.porCd = porCd;
        this.vslCd = vslCd;
        this.bkgCgoTpCd = bkgCgoTpCd;
        this.bdrFlg = bdrFlg;
        this.bkgStsCd = bkgStsCd;
        this.bkgMeasUtCd = bkgMeasUtCd;
        this.blNo = blNo;
        this.cgoRcvDt = cgoRcvDt;
        this.pagerows = pagerows;
        this.corrFlg = corrFlg;
        this.polCd = polCd;
        this.ibflag = ibflag;
        this.tVvd = tVvd;
        this.modifyFnlCfmFlg = modifyFnlCfmFlg;
        this.evntUsrId = evntUsrId;
        this.rcvTermCd = rcvTermCd;
        this.updUsrId = updUsrId;
        this.evntDt = evntDt;
        this.notUpdatedFlg = notUpdatedFlg;
        this.delCd = delCd;
        this.skdVoyNo = skdVoyNo;
        this.skdDirCd = skdDirCd;
        this.blTpCd = blTpCd;
        this.podCd = podCd;
        this.cnFlg = cnFlg;
        this.deTermCd = deTermCd;
        this.creUsrId = creUsrId;
        this.bkgNo = bkgNo;
        this.flexHgtFlg = flexHgtFlg;
        this.fnlCfmFlg = fnlCfmFlg;
        this.bkgWgtUtCd = bkgWgtUtCd;
        this.shpFlg = shpFlg;
        this.ucrFlg = ucrFlg;
        this.senderId = senderId;
        this.rqstNo = rqstNo;
        this.rqstSeq = rqstSeq;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("por_cd", getPorCd());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
        this.hashColumns.put("bdr_flg", getBdrFlg());
        this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
        this.hashColumns.put("bkg_meas_ut_cd", getBkgMeasUtCd());
        this.hashColumns.put("bl_no", getBlNo());
        this.hashColumns.put("cgo_rcv_dt", getCgoRcvDt());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("corr_flg", getCorrFlg());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("t_vvd", getTVvd());
        this.hashColumns.put("modify_fnl_cfm_flg", getModifyFnlCfmFlg());
        this.hashColumns.put("evnt_usr_id", getEvntUsrId());
        this.hashColumns.put("rcv_term_cd", getRcvTermCd());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("evnt_dt", getEvntDt());
        this.hashColumns.put("not_updated_flg", getNotUpdatedFlg());
        this.hashColumns.put("del_cd", getDelCd());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("bl_tp_cd", getBlTpCd());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("cn_flg", getCnFlg());
        this.hashColumns.put("de_term_cd", getDeTermCd());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("flex_hgt_flg", getFlexHgtFlg());
        this.hashColumns.put("fnl_cfm_flg", getFnlCfmFlg());
        this.hashColumns.put("bkg_wgt_ut_cd", getBkgWgtUtCd());
        this.hashColumns.put("shp_flg", getShpFlg());
        this.hashColumns.put("ucr_flg", getUcrFlg());
        this.hashColumns.put("sender_id", getSenderId());
        this.hashColumns.put("rqst_no", getRqstNo());
        this.hashColumns.put("rqst_seq", getRqstSeq());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("por_cd", "porCd");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
        this.hashFields.put("bdr_flg", "bdrFlg");
        this.hashFields.put("bkg_sts_cd", "bkgStsCd");
        this.hashFields.put("bkg_meas_ut_cd", "bkgMeasUtCd");
        this.hashFields.put("bl_no", "blNo");
        this.hashFields.put("cgo_rcv_dt", "cgoRcvDt");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("corr_flg", "corrFlg");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("t_vvd", "tVvd");
        this.hashFields.put("modify_fnl_cfm_flg", "modifyFnlCfmFlg");
        this.hashFields.put("evnt_usr_id", "evntUsrId");
        this.hashFields.put("rcv_term_cd", "rcvTermCd");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("evnt_dt", "evntDt");
        this.hashFields.put("not_updated_flg", "notUpdatedFlg");
        this.hashFields.put("del_cd", "delCd");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("bl_tp_cd", "blTpCd");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("cn_flg", "cnFlg");
        this.hashFields.put("de_term_cd", "deTermCd");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("flex_hgt_flg", "flexHgtFlg");
        this.hashFields.put("fnl_cfm_flg", "fnlCfmFlg");
        this.hashFields.put("bkg_wgt_ut_cd", "bkgWgtUtCd");
        this.hashFields.put("shp_flg", "shpFlg");
        this.hashFields.put("ucr_flg", "ucrFlg");
        this.hashFields.put("sender_id", "senderId");
        this.hashFields.put("rqst_no", "rqstNo");
        this.hashFields.put("rqst_seq", "rqstSeq");
        return this.hashFields;
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
	 * @return vslCd
	 */
    public String getVslCd() {
        return this.vslCd;
    }

    /**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
    public String getBkgCgoTpCd() {
        return this.bkgCgoTpCd;
    }

    /**
	 * Column Info
	 * @return bdrFlg
	 */
    public String getBdrFlg() {
        return this.bdrFlg;
    }

    /**
	 * Column Info
	 * @return bkgStsCd
	 */
    public String getBkgStsCd() {
        return this.bkgStsCd;
    }

    /**
	 * Column Info
	 * @return bkgMeasUtCd
	 */
    public String getBkgMeasUtCd() {
        return this.bkgMeasUtCd;
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
	 * @return cgoRcvDt
	 */
    public String getCgoRcvDt() {
        return this.cgoRcvDt;
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
	 * @return corrFlg
	 */
    public String getCorrFlg() {
        return this.corrFlg;
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
	 * @return tVvd
	 */
    public String getTVvd() {
        return this.tVvd;
    }

    /**
	 * Column Info
	 * @return modifyFnlCfmFlg
	 */
    public String getModifyFnlCfmFlg() {
        return this.modifyFnlCfmFlg;
    }

    /**
	 * Column Info
	 * @return evntUsrId
	 */
    public String getEvntUsrId() {
        return this.evntUsrId;
    }

    /**
	 * Column Info
	 * @return rcvTermCd
	 */
    public String getRcvTermCd() {
        return this.rcvTermCd;
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
	 * @return evntDt
	 */
    public String getEvntDt() {
        return this.evntDt;
    }

    /**
	 * Column Info
	 * @return notUpdatedFlg
	 */
    public String getNotUpdatedFlg() {
        return this.notUpdatedFlg;
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
	 * @return skdVoyNo
	 */
    public String getSkdVoyNo() {
        return this.skdVoyNo;
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
	 * @return blTpCd
	 */
    public String getBlTpCd() {
        return this.blTpCd;
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
	 * @return cnFlg
	 */
    public String getCnFlg() {
        return this.cnFlg;
    }

    /**
	 * Column Info
	 * @return deTermCd
	 */
    public String getDeTermCd() {
        return this.deTermCd;
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
	 * @return bkgNo
	 */
    public String getBkgNo() {
        return this.bkgNo;
    }

    /**
	 * Column Info
	 * @return flexHgtFlg
	 */
    public String getFlexHgtFlg() {
        return this.flexHgtFlg;
    }

    /**
	 * Column Info
	 * @return fnlCfmFlg
	 */
    public String getFnlCfmFlg() {
        return this.fnlCfmFlg;
    }

    /**
	 * Column Info
	 * @return bkgWgtUtCd
	 */
    public String getBkgWgtUtCd() {
        return this.bkgWgtUtCd;
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
	 * @param vslCd
	 */
    public void setVslCd(String vslCd) {
        this.vslCd = vslCd;
    }

    /**
	 * Column Info
	 * @param bkgCgoTpCd
	 */
    public void setBkgCgoTpCd(String bkgCgoTpCd) {
        this.bkgCgoTpCd = bkgCgoTpCd;
    }

    /**
	 * Column Info
	 * @param bdrFlg
	 */
    public void setBdrFlg(String bdrFlg) {
        this.bdrFlg = bdrFlg;
    }

    /**
	 * Column Info
	 * @param bkgStsCd
	 */
    public void setBkgStsCd(String bkgStsCd) {
        this.bkgStsCd = bkgStsCd;
    }

    /**
	 * Column Info
	 * @param bkgMeasUtCd
	 */
    public void setBkgMeasUtCd(String bkgMeasUtCd) {
        this.bkgMeasUtCd = bkgMeasUtCd;
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
	 * @param cgoRcvDt
	 */
    public void setCgoRcvDt(String cgoRcvDt) {
        this.cgoRcvDt = cgoRcvDt;
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
	 * @param corrFlg
	 */
    public void setCorrFlg(String corrFlg) {
        this.corrFlg = corrFlg;
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
	 * @param tVvd
	 */
    public void setTVvd(String tVvd) {
        this.tVvd = tVvd;
    }

    /**
	 * Column Info
	 * @param modifyFnlCfmFlg
	 */
    public void setModifyFnlCfmFlg(String modifyFnlCfmFlg) {
        this.modifyFnlCfmFlg = modifyFnlCfmFlg;
    }

    /**
	 * Column Info
	 * @param evntUsrId
	 */
    public void setEvntUsrId(String evntUsrId) {
        this.evntUsrId = evntUsrId;
    }

    /**
	 * Column Info
	 * @param rcvTermCd
	 */
    public void setRcvTermCd(String rcvTermCd) {
        this.rcvTermCd = rcvTermCd;
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
	 * @param evntDt
	 */
    public void setEvntDt(String evntDt) {
        this.evntDt = evntDt;
    }

    /**
	 * Column Info
	 * @param notUpdatedFlg
	 */
    public void setNotUpdatedFlg(String notUpdatedFlg) {
        this.notUpdatedFlg = notUpdatedFlg;
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
	 * @param skdVoyNo
	 */
    public void setSkdVoyNo(String skdVoyNo) {
        this.skdVoyNo = skdVoyNo;
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
	 * @param blTpCd
	 */
    public void setBlTpCd(String blTpCd) {
        this.blTpCd = blTpCd;
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
	 * @param cnFlg
	 */
    public void setCnFlg(String cnFlg) {
        this.cnFlg = cnFlg;
    }

    /**
	 * Column Info
	 * @param deTermCd
	 */
    public void setDeTermCd(String deTermCd) {
        this.deTermCd = deTermCd;
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
	 * @param bkgNo
	 */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    /**
	 * Column Info
	 * @param flexHgtFlg
	 */
    public void setFlexHgtFlg(String flexHgtFlg) {
        this.flexHgtFlg = flexHgtFlg;
    }

    /**
	 * Column Info
	 * @param fnlCfmFlg
	 */
    public void setFnlCfmFlg(String fnlCfmFlg) {
        this.fnlCfmFlg = fnlCfmFlg;
    }

    /**
	 * Column Info
	 * @param bkgWgtUtCd
	 */
    public void setBkgWgtUtCd(String bkgWgtUtCd) {
        this.bkgWgtUtCd = bkgWgtUtCd;
    }

    /**
	 * @return the shpFlg
	 */
    public String getShpFlg() {
        return shpFlg;
    }

    /**
	 * @param shpFlg the shpFlg to set
	 */
    public void setShpFlg(String shpFlg) {
        this.shpFlg = shpFlg;
    }

    /**
	 * @return the ucrFlg
	 */
    public String getUcrFlg() {
        return ucrFlg;
    }

    /**
	 * @param ucrFlg the ucrFlg to set
	 */
    public void setUcrFlg(String ucrFlg) {
        this.ucrFlg = ucrFlg;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getSenderId() {
        return this.senderId;
    }

    public void setRqstNo(String rqstNo) {
        this.rqstNo = rqstNo;
    }

    public String getRqstNo() {
        return this.rqstNo;
    }

    public void setRqstSeq(String rqstSeq) {
        this.rqstSeq = rqstSeq;
    }

    public String getRqstSeq() {
        return this.rqstSeq;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
        setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
        setBkgCgoTpCd(JSPUtil.getParameter(request, "bkg_cgo_tp_cd", ""));
        setBdrFlg(JSPUtil.getParameter(request, "bdr_flg", ""));
        setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));
        setBkgMeasUtCd(JSPUtil.getParameter(request, "bkg_meas_ut_cd", ""));
        setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
        setCgoRcvDt(JSPUtil.getParameter(request, "cgo_rcv_dt", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setCorrFlg(JSPUtil.getParameter(request, "corr_flg", ""));
        setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setTVvd(JSPUtil.getParameter(request, "t_vvd", ""));
        setModifyFnlCfmFlg(JSPUtil.getParameter(request, "modify_fnl_cfm_flg", ""));
        setEvntUsrId(JSPUtil.getParameter(request, "evnt_usr_id", ""));
        setRcvTermCd(JSPUtil.getParameter(request, "rcv_term_cd", ""));
        setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
        setEvntDt(JSPUtil.getParameter(request, "evnt_dt", ""));
        setNotUpdatedFlg(JSPUtil.getParameter(request, "not_updated_flg", ""));
        setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
        setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
        setBlTpCd(JSPUtil.getParameter(request, "bl_tp_cd", ""));
        setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
        setCnFlg(JSPUtil.getParameter(request, "cn_flg", ""));
        setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
        setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
        setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
        setFlexHgtFlg(JSPUtil.getParameter(request, "flex_hgt_flg", ""));
        setFnlCfmFlg(JSPUtil.getParameter(request, "fnl_cfm_flg", ""));
        setBkgWgtUtCd(JSPUtil.getParameter(request, "bkg_wgt_ut_cd", ""));
        setShpFlg(JSPUtil.getParameter(request, "shp_flg", ""));
        setUcrFlg(JSPUtil.getParameter(request, "ucr_flg", ""));
        setRqstNo(JSPUtil.getParameter(request, "rqst_no", ""));
        setRqstSeq(JSPUtil.getParameter(request, "rqst_seq", ""));
        setSenderId(JSPUtil.getParameter(request, "sender_id", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CntrEtcInfoVO[]
	 */
    public CntrEtcInfoVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CntrEtcInfoVO[]
	 */
    public CntrEtcInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CntrEtcInfoVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] porCd = (JSPUtil.getParameter(request, prefix + "por_cd", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", length));
            String[] bdrFlg = (JSPUtil.getParameter(request, prefix + "bdr_flg", length));
            String[] bkgStsCd = (JSPUtil.getParameter(request, prefix + "bkg_sts_cd", length));
            String[] bkgMeasUtCd = (JSPUtil.getParameter(request, prefix + "bkg_meas_ut_cd", length));
            String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
            String[] cgoRcvDt = (JSPUtil.getParameter(request, prefix + "cgo_rcv_dt", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] corrFlg = (JSPUtil.getParameter(request, prefix + "corr_flg", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] tVvd = (JSPUtil.getParameter(request, prefix + "t_vvd", length));
            String[] modifyFnlCfmFlg = (JSPUtil.getParameter(request, prefix + "modify_fnl_cfm_flg", length));
            String[] evntUsrId = (JSPUtil.getParameter(request, prefix + "evnt_usr_id", length));
            String[] rcvTermCd = (JSPUtil.getParameter(request, prefix + "rcv_term_cd", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] evntDt = (JSPUtil.getParameter(request, prefix + "evnt_dt", length));
            String[] notUpdatedFlg = (JSPUtil.getParameter(request, prefix + "not_updated_flg", length));
            String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] blTpCd = (JSPUtil.getParameter(request, prefix + "bl_tp_cd", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] cnFlg = (JSPUtil.getParameter(request, prefix + "cn_flg", length));
            String[] deTermCd = (JSPUtil.getParameter(request, prefix + "de_term_cd", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] flexHgtFlg = (JSPUtil.getParameter(request, prefix + "flex_hgt_flg", length));
            String[] fnlCfmFlg = (JSPUtil.getParameter(request, prefix + "fnl_cfm_flg", length));
            String[] bkgWgtUtCd = (JSPUtil.getParameter(request, prefix + "bkg_wgt_ut_cd", length));
            String[] shpFlg = (JSPUtil.getParameter(request, prefix + "shp_flg", length));
            String[] ucrFlg = (JSPUtil.getParameter(request, prefix + "ucr_flg", length));
            String[] senderId = (JSPUtil.getParameter(request, prefix + "sender_id", length));
	    	String[] rqstNo = (JSPUtil.getParameter(request, prefix + "rqst_no", length));
	    	String[] rqstSeq = (JSPUtil.getParameter(request, prefix + "rqst_seq", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new CntrEtcInfoVO();
                if (porCd[i] != null)
                    model.setPorCd(porCd[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (bkgCgoTpCd[i] != null)
                    model.setBkgCgoTpCd(bkgCgoTpCd[i]);
                if (bdrFlg[i] != null)
                    model.setBdrFlg(bdrFlg[i]);
                if (bkgStsCd[i] != null)
                    model.setBkgStsCd(bkgStsCd[i]);
                if (bkgMeasUtCd[i] != null)
                    model.setBkgMeasUtCd(bkgMeasUtCd[i]);
                if (blNo[i] != null)
                    model.setBlNo(blNo[i]);
                if (cgoRcvDt[i] != null)
                    model.setCgoRcvDt(cgoRcvDt[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (corrFlg[i] != null)
                    model.setCorrFlg(corrFlg[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (tVvd[i] != null)
                    model.setTVvd(tVvd[i]);
                if (modifyFnlCfmFlg[i] != null)
                    model.setModifyFnlCfmFlg(modifyFnlCfmFlg[i]);
                if (evntUsrId[i] != null)
                    model.setEvntUsrId(evntUsrId[i]);
                if (rcvTermCd[i] != null)
                    model.setRcvTermCd(rcvTermCd[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (evntDt[i] != null)
                    model.setEvntDt(evntDt[i]);
                if (notUpdatedFlg[i] != null)
                    model.setNotUpdatedFlg(notUpdatedFlg[i]);
                if (delCd[i] != null)
                    model.setDelCd(delCd[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (blTpCd[i] != null)
                    model.setBlTpCd(blTpCd[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (cnFlg[i] != null)
                    model.setCnFlg(cnFlg[i]);
                if (deTermCd[i] != null)
                    model.setDeTermCd(deTermCd[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (flexHgtFlg[i] != null)
                    model.setFlexHgtFlg(flexHgtFlg[i]);
                if (fnlCfmFlg[i] != null)
                    model.setFnlCfmFlg(fnlCfmFlg[i]);
                if (bkgWgtUtCd[i] != null)
                    model.setBkgWgtUtCd(bkgWgtUtCd[i]);
                if (shpFlg[i] != null)
                    model.setShpFlg(shpFlg[i]);
                if (ucrFlg[i] != null)
                    model.setUcrFlg(ucrFlg[i]);
                if (senderId[i] != null) 
		    		model.setSenderId(senderId[i]);
				if (rqstNo[i] != null) 
		    		model.setRqstNo(rqstNo[i]);
				if (rqstSeq[i] != null) 
		    		model.setRqstSeq(rqstSeq[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCntrEtcInfoVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return CntrEtcInfoVO[]
	 */
    public CntrEtcInfoVO[] getCntrEtcInfoVOs() {
        CntrEtcInfoVO[] vos = (CntrEtcInfoVO[]) models.toArray(new CntrEtcInfoVO[models.size()]);
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
        this.porCd = this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCgoTpCd = this.bkgCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bdrFlg = this.bdrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgStsCd = this.bkgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgMeasUtCd = this.bkgMeasUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cgoRcvDt = this.cgoRcvDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.corrFlg = this.corrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tVvd = this.tVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.modifyFnlCfmFlg = this.modifyFnlCfmFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.evntUsrId = this.evntUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvTermCd = this.rcvTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.evntDt = this.evntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.notUpdatedFlg = this.notUpdatedFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blTpCd = this.blTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cnFlg = this.cnFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deTermCd = this.deTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.flexHgtFlg = this.flexHgtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fnlCfmFlg = this.fnlCfmFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgWgtUtCd = this.bkgWgtUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shpFlg = this.shpFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ucrFlg = this.ucrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.senderId = this.senderId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstNo = this.rqstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstSeq = this.rqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
