/*=========================================================
*Copyright(c) 2018 SMLines
*@FileName : LocationMainIfVO.java
*@FileTitle : LocationMainIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.08 
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
 
public class LocationMainIfVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<LocationMainIfVO> models = new ArrayList<LocationMainIfVO>();

    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    private String locCd = null;

    private String sccCd = null;

    private String locNm = null;

    private String rgnCd = null;

    private String cntCd = null;

    private String steCd = null;

    private String contiCd = null;

    private String scontiCd = null;

    private String portInlndCd = null;

    private String locChrCd = null;

    private String blkPortFlg = null;

    private String hubLocCd = null;

    private String slsOfcCd = null;

    private String locGrdNo = null;

    private String gmtHrs = null;

    private String bkgBlPfxCd = null;

    private String callPortFlg = null;

    private String locAmsPortCd = null;

    private String fincCtrlOfcCd = null;

    private String eqCtrlOfcCd = null;

    private String mtyPkupYdCd = null;

    private String senEqOfcCd = null;

    private String eqRtnYdCd = null;

    private String unLocCd = null;

    private String cmlZnFlg = null;

    private String cstmsCd = null;

    private String locTpCd = null;

    private String bfrFincCtrlOfcCd = null;

    private String bfrEqCtrlOfcCd = null;

    private String bfrOfcCngDt = null;

    private String zipCd = null;

    private String creUsrId = null;

    private String creDt = null;

    private String updUsrId = null;

    private String updDt = null;

    private String deltFlg = null;

    private String repZnCd = null;

    private String locLoclLangNm = null;

    private String locLat = null;

    private String latUtCd = null;

    private String locLon = null;

    private String lonUtCd = null;

    private String usrId = null;

    private String cudFlg = null;

    private String bfrSlsOfcCd = null;

    private String unLocIndCd = null;

    private String eaiEvntDt = null;

    private String eaiIfId = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public LocationMainIfVO() {
    }

    public LocationMainIfVO(String ibflag, String pagerows, String locCd, String sccCd, String locNm, String rgnCd, String cntCd, String steCd, String contiCd, String scontiCd, String portInlndCd, String locChrCd, String blkPortFlg, String hubLocCd, String slsOfcCd, String locGrdNo, String gmtHrs, String bkgBlPfxCd, String callPortFlg, String locAmsPortCd, String fincCtrlOfcCd, String eqCtrlOfcCd, String mtyPkupYdCd, String senEqOfcCd, String eqRtnYdCd, String unLocCd, String cmlZnFlg, String cstmsCd, String locTpCd, String bfrFincCtrlOfcCd, String bfrEqCtrlOfcCd, String bfrOfcCngDt, String zipCd, String creUsrId, String creDt, String updUsrId, String updDt, String deltFlg, String repZnCd, String locLoclLangNm, String locLat, String latUtCd, String locLon, String lonUtCd, String usrId, String cudFlg, String bfrSlsOfcCd, String unLocIndCd, String eaiEvntDt, String eaiIfId) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.locCd = locCd;
        this.sccCd = sccCd;
        this.locNm = locNm;
        this.rgnCd = rgnCd;
        this.cntCd = cntCd;
        this.steCd = steCd;
        this.contiCd = contiCd;
        this.scontiCd = scontiCd;
        this.portInlndCd = portInlndCd;
        this.locChrCd = locChrCd;
        this.blkPortFlg = blkPortFlg;
        this.hubLocCd = hubLocCd;
        this.slsOfcCd = slsOfcCd;
        this.locGrdNo = locGrdNo;
        this.gmtHrs = gmtHrs;
        this.bkgBlPfxCd = bkgBlPfxCd;
        this.callPortFlg = callPortFlg;
        this.locAmsPortCd = locAmsPortCd;
        this.fincCtrlOfcCd = fincCtrlOfcCd;
        this.eqCtrlOfcCd = eqCtrlOfcCd;
        this.mtyPkupYdCd = mtyPkupYdCd;
        this.senEqOfcCd = senEqOfcCd;
        this.eqRtnYdCd = eqRtnYdCd;
        this.unLocCd = unLocCd;
        this.cmlZnFlg = cmlZnFlg;
        this.cstmsCd = cstmsCd;
        this.locTpCd = locTpCd;
        this.bfrFincCtrlOfcCd = bfrFincCtrlOfcCd;
        this.bfrEqCtrlOfcCd = bfrEqCtrlOfcCd;
        this.bfrOfcCngDt = bfrOfcCngDt;
        this.zipCd = zipCd;
        this.creUsrId = creUsrId;
        this.creDt = creDt;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.deltFlg = deltFlg;
        this.repZnCd = repZnCd;
        this.locLoclLangNm = locLoclLangNm;
        this.locLat = locLat;
        this.latUtCd = latUtCd;
        this.locLon = locLon;
        this.lonUtCd = lonUtCd;
        this.usrId = usrId;
        this.cudFlg = cudFlg;
        this.bfrSlsOfcCd = bfrSlsOfcCd;
        this.unLocIndCd = unLocIndCd;
        this.eaiEvntDt = eaiEvntDt;
        this.eaiIfId = eaiIfId;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("loc_cd", getLocCd());
        this.hashColumns.put("scc_cd", getSccCd());
        this.hashColumns.put("loc_nm", getLocNm());
        this.hashColumns.put("rgn_cd", getRgnCd());
        this.hashColumns.put("cnt_cd", getCntCd());
        this.hashColumns.put("ste_cd", getSteCd());
        this.hashColumns.put("conti_cd", getContiCd());
        this.hashColumns.put("sconti_cd", getScontiCd());
        this.hashColumns.put("port_inlnd_cd", getPortInlndCd());
        this.hashColumns.put("loc_chr_cd", getLocChrCd());
        this.hashColumns.put("blk_port_flg", getBlkPortFlg());
        this.hashColumns.put("hub_loc_cd", getHubLocCd());
        this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
        this.hashColumns.put("loc_grd_no", getLocGrdNo());
        this.hashColumns.put("gmt_hrs", getGmtHrs());
        this.hashColumns.put("bkg_bl_pfx_cd", getBkgBlPfxCd());
        this.hashColumns.put("call_port_flg", getCallPortFlg());
        this.hashColumns.put("loc_ams_port_cd", getLocAmsPortCd());
        this.hashColumns.put("finc_ctrl_ofc_cd", getFincCtrlOfcCd());
        this.hashColumns.put("eq_ctrl_ofc_cd", getEqCtrlOfcCd());
        this.hashColumns.put("mty_pkup_yd_cd", getMtyPkupYdCd());
        this.hashColumns.put("sen_eq_ofc_cd", getSenEqOfcCd());
        this.hashColumns.put("eq_rtn_yd_cd", getEqRtnYdCd());
        this.hashColumns.put("un_loc_cd", getUnLocCd());
        this.hashColumns.put("cml_zn_flg", getCmlZnFlg());
        this.hashColumns.put("cstms_cd", getCstmsCd());
        this.hashColumns.put("loc_tp_cd", getLocTpCd());
        this.hashColumns.put("bfr_finc_ctrl_ofc_cd", getBfrFincCtrlOfcCd());
        this.hashColumns.put("bfr_eq_ctrl_ofc_cd", getBfrEqCtrlOfcCd());
        this.hashColumns.put("bfr_ofc_cng_dt", getBfrOfcCngDt());
        this.hashColumns.put("zip_cd", getZipCd());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("delt_flg", getDeltFlg());
        this.hashColumns.put("rep_zn_cd", getRepZnCd());
        this.hashColumns.put("loc_locl_lang_nm", getLocLoclLangNm());
        this.hashColumns.put("loc_lat", getLocLat());
        this.hashColumns.put("lat_ut_cd", getLatUtCd());
        this.hashColumns.put("loc_lon", getLocLon());
        this.hashColumns.put("lon_ut_cd", getLonUtCd());
        this.hashColumns.put("usr_id", getUsrId());
        this.hashColumns.put("cud_flg", getCudFlg());
        this.hashColumns.put("bfr_sls_ofc_cd", getBfrSlsOfcCd());
        this.hashColumns.put("un_loc_ind_cd", getUnLocIndCd());
        this.hashColumns.put("eai_evnt_dt", getEaiEvntDt());
        this.hashColumns.put("eai_if_id", getEaiIfId());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("loc_cd", "locCd");
        this.hashFields.put("scc_cd", "sccCd");
        this.hashFields.put("loc_nm", "locNm");
        this.hashFields.put("rgn_cd", "rgnCd");
        this.hashFields.put("cnt_cd", "cntCd");
        this.hashFields.put("ste_cd", "steCd");
        this.hashFields.put("conti_cd", "contiCd");
        this.hashFields.put("sconti_cd", "scontiCd");
        this.hashFields.put("port_inlnd_cd", "portInlndCd");
        this.hashFields.put("loc_chr_cd", "locChrCd");
        this.hashFields.put("blk_port_flg", "blkPortFlg");
        this.hashFields.put("hub_loc_cd", "hubLocCd");
        this.hashFields.put("sls_ofc_cd", "slsOfcCd");
        this.hashFields.put("loc_grd_no", "locGrdNo");
        this.hashFields.put("gmt_hrs", "gmtHrs");
        this.hashFields.put("bkg_bl_pfx_cd", "bkgBlPfxCd");
        this.hashFields.put("call_port_flg", "callPortFlg");
        this.hashFields.put("loc_ams_port_cd", "locAmsPortCd");
        this.hashFields.put("finc_ctrl_ofc_cd", "fincCtrlOfcCd");
        this.hashFields.put("eq_ctrl_ofc_cd", "eqCtrlOfcCd");
        this.hashFields.put("mty_pkup_yd_cd", "mtyPkupYdCd");
        this.hashFields.put("sen_eq_ofc_cd", "senEqOfcCd");
        this.hashFields.put("eq_rtn_yd_cd", "eqRtnYdCd");
        this.hashFields.put("un_loc_cd", "unLocCd");
        this.hashFields.put("cml_zn_flg", "cmlZnFlg");
        this.hashFields.put("cstms_cd", "cstmsCd");
        this.hashFields.put("loc_tp_cd", "locTpCd");
        this.hashFields.put("bfr_finc_ctrl_ofc_cd", "bfrFincCtrlOfcCd");
        this.hashFields.put("bfr_eq_ctrl_ofc_cd", "bfrEqCtrlOfcCd");
        this.hashFields.put("bfr_ofc_cng_dt", "bfrOfcCngDt");
        this.hashFields.put("zip_cd", "zipCd");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("delt_flg", "deltFlg");
        this.hashFields.put("rep_zn_cd", "repZnCd");
        this.hashFields.put("loc_locl_lang_nm", "locLoclLangNm");
        this.hashFields.put("loc_lat", "locLat");
        this.hashFields.put("lat_ut_cd", "latUtCd");
        this.hashFields.put("loc_lon", "locLon");
        this.hashFields.put("lon_ut_cd", "lonUtCd");
        this.hashFields.put("usr_id", "usrId");
        this.hashFields.put("cud_flg", "cudFlg");
        this.hashFields.put("bfr_sls_ofc_cd", "bfrSlsOfcCd");
        this.hashFields.put("un_loc_ind_cd", "unLocIndCd");
        this.hashFields.put("eai_evnt_dt", "eaiEvntDt");
        this.hashFields.put("eai_if_id", "eaiIfId");
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

    public void setLocCd(String locCd) {
        this.locCd = locCd;
    }

    public String getLocCd() {
        return this.locCd;
    }

    public void setSccCd(String sccCd) {
        this.sccCd = sccCd;
    }

    public String getSccCd() {
        return this.sccCd;
    }

    public void setLocNm(String locNm) {
        this.locNm = locNm;
    }

    public String getLocNm() {
        return this.locNm;
    }

    public void setRgnCd(String rgnCd) {
        this.rgnCd = rgnCd;
    }

    public String getRgnCd() {
        return this.rgnCd;
    }

    public void setCntCd(String cntCd) {
        this.cntCd = cntCd;
    }

    public String getCntCd() {
        return this.cntCd;
    }

    public void setSteCd(String steCd) {
        this.steCd = steCd;
    }

    public String getSteCd() {
        return this.steCd;
    }

    public void setContiCd(String contiCd) {
        this.contiCd = contiCd;
    }

    public String getContiCd() {
        return this.contiCd;
    }

    public void setScontiCd(String scontiCd) {
        this.scontiCd = scontiCd;
    }

    public String getScontiCd() {
        return this.scontiCd;
    }

    public void setPortInlndCd(String portInlndCd) {
        this.portInlndCd = portInlndCd;
    }

    public String getPortInlndCd() {
        return this.portInlndCd;
    }

    public void setLocChrCd(String locChrCd) {
        this.locChrCd = locChrCd;
    }

    public String getLocChrCd() {
        return this.locChrCd;
    }

    public void setBlkPortFlg(String blkPortFlg) {
        this.blkPortFlg = blkPortFlg;
    }

    public String getBlkPortFlg() {
        return this.blkPortFlg;
    }

    public void setHubLocCd(String hubLocCd) {
        this.hubLocCd = hubLocCd;
    }

    public String getHubLocCd() {
        return this.hubLocCd;
    }

    public void setSlsOfcCd(String slsOfcCd) {
        this.slsOfcCd = slsOfcCd;
    }

    public String getSlsOfcCd() {
        return this.slsOfcCd;
    }

    public void setLocGrdNo(String locGrdNo) {
        this.locGrdNo = locGrdNo;
    }

    public String getLocGrdNo() {
        return this.locGrdNo;
    }

    public void setGmtHrs(String gmtHrs) {
        this.gmtHrs = gmtHrs;
    }

    public String getGmtHrs() {
        return this.gmtHrs;
    }

    public void setBkgBlPfxCd(String bkgBlPfxCd) {
        this.bkgBlPfxCd = bkgBlPfxCd;
    }

    public String getBkgBlPfxCd() {
        return this.bkgBlPfxCd;
    }

    public void setCallPortFlg(String callPortFlg) {
        this.callPortFlg = callPortFlg;
    }

    public String getCallPortFlg() {
        return this.callPortFlg;
    }

    public void setLocAmsPortCd(String locAmsPortCd) {
        this.locAmsPortCd = locAmsPortCd;
    }

    public String getLocAmsPortCd() {
        return this.locAmsPortCd;
    }

    public void setFincCtrlOfcCd(String fincCtrlOfcCd) {
        this.fincCtrlOfcCd = fincCtrlOfcCd;
    }

    public String getFincCtrlOfcCd() {
        return this.fincCtrlOfcCd;
    }

    public void setEqCtrlOfcCd(String eqCtrlOfcCd) {
        this.eqCtrlOfcCd = eqCtrlOfcCd;
    }

    public String getEqCtrlOfcCd() {
        return this.eqCtrlOfcCd;
    }

    public void setMtyPkupYdCd(String mtyPkupYdCd) {
        this.mtyPkupYdCd = mtyPkupYdCd;
    }

    public String getMtyPkupYdCd() {
        return this.mtyPkupYdCd;
    }

    public void setSenEqOfcCd(String senEqOfcCd) {
        this.senEqOfcCd = senEqOfcCd;
    }

    public String getSenEqOfcCd() {
        return this.senEqOfcCd;
    }

    public void setEqRtnYdCd(String eqRtnYdCd) {
        this.eqRtnYdCd = eqRtnYdCd;
    }

    public String getEqRtnYdCd() {
        return this.eqRtnYdCd;
    }

    public void setUnLocCd(String unLocCd) {
        this.unLocCd = unLocCd;
    }

    public String getUnLocCd() {
        return this.unLocCd;
    }

    public void setCmlZnFlg(String cmlZnFlg) {
        this.cmlZnFlg = cmlZnFlg;
    }

    public String getCmlZnFlg() {
        return this.cmlZnFlg;
    }

    public void setCstmsCd(String cstmsCd) {
        this.cstmsCd = cstmsCd;
    }

    public String getCstmsCd() {
        return this.cstmsCd;
    }

    public void setLocTpCd(String locTpCd) {
        this.locTpCd = locTpCd;
    }

    public String getLocTpCd() {
        return this.locTpCd;
    }

    public void setBfrFincCtrlOfcCd(String bfrFincCtrlOfcCd) {
        this.bfrFincCtrlOfcCd = bfrFincCtrlOfcCd;
    }

    public String getBfrFincCtrlOfcCd() {
        return this.bfrFincCtrlOfcCd;
    }

    public void setBfrEqCtrlOfcCd(String bfrEqCtrlOfcCd) {
        this.bfrEqCtrlOfcCd = bfrEqCtrlOfcCd;
    }

    public String getBfrEqCtrlOfcCd() {
        return this.bfrEqCtrlOfcCd;
    }

    public void setBfrOfcCngDt(String bfrOfcCngDt) {
        this.bfrOfcCngDt = bfrOfcCngDt;
    }

    public String getBfrOfcCngDt() {
        return this.bfrOfcCngDt;
    }

    public void setZipCd(String zipCd) {
        this.zipCd = zipCd;
    }

    public String getZipCd() {
        return this.zipCd;
    }

    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    public String getCreUsrId() {
        return this.creUsrId;
    }

    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    public String getCreDt() {
        return this.creDt;
    }

    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    public String getUpdUsrId() {
        return this.updUsrId;
    }

    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    public String getUpdDt() {
        return this.updDt;
    }

    public void setDeltFlg(String deltFlg) {
        this.deltFlg = deltFlg;
    }

    public String getDeltFlg() {
        return this.deltFlg;
    }

    public void setRepZnCd(String repZnCd) {
        this.repZnCd = repZnCd;
    }

    public String getRepZnCd() {
        return this.repZnCd;
    }

    public void setLocLoclLangNm(String locLoclLangNm) {
        this.locLoclLangNm = locLoclLangNm;
    }

    public String getLocLoclLangNm() {
        return this.locLoclLangNm;
    }

    public void setLocLat(String locLat) {
        this.locLat = locLat;
    }

    public String getLocLat() {
        return this.locLat;
    }

    public void setLatUtCd(String latUtCd) {
        this.latUtCd = latUtCd;
    }

    public String getLatUtCd() {
        return this.latUtCd;
    }

    public void setLocLon(String locLon) {
        this.locLon = locLon;
    }

    public String getLocLon() {
        return this.locLon;
    }

    public void setLonUtCd(String lonUtCd) {
        this.lonUtCd = lonUtCd;
    }

    public String getLonUtCd() {
        return this.lonUtCd;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    public String getUsrId() {
        return this.usrId;
    }

    public void setCudFlg(String cudFlg) {
        this.cudFlg = cudFlg;
    }

    public String getCudFlg() {
        return this.cudFlg;
    }

    public void setBfrSlsOfcCd(String bfrSlsOfcCd) {
        this.bfrSlsOfcCd = bfrSlsOfcCd;
    }

    public String getBfrSlsOfcCd() {
        return this.bfrSlsOfcCd;
    }

    public void setUnLocIndCd(String unLocIndCd) {
        this.unLocIndCd = unLocIndCd;
    }

    public String getUnLocIndCd() {
        return this.unLocIndCd;
    }

    public void setEaiEvntDt(String eaiEvntDt) {
        this.eaiEvntDt = eaiEvntDt;
    }

    public String getEaiEvntDt() {
        return this.eaiEvntDt;
    }

    public void setEaiIfId(String eaiIfId) {
        this.eaiIfId = eaiIfId;
    }

    public String getEaiIfId() {
        return this.eaiIfId;
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
        setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
        setSccCd(JSPUtil.getParameter(request, prefix + "scc_cd", ""));
        setLocNm(JSPUtil.getParameter(request, prefix + "loc_nm", ""));
        setRgnCd(JSPUtil.getParameter(request, prefix + "rgn_cd", ""));
        setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
        setSteCd(JSPUtil.getParameter(request, prefix + "ste_cd", ""));
        setContiCd(JSPUtil.getParameter(request, prefix + "conti_cd", ""));
        setScontiCd(JSPUtil.getParameter(request, prefix + "sconti_cd", ""));
        setPortInlndCd(JSPUtil.getParameter(request, prefix + "port_inlnd_cd", ""));
        setLocChrCd(JSPUtil.getParameter(request, prefix + "loc_chr_cd", ""));
        setBlkPortFlg(JSPUtil.getParameter(request, prefix + "blk_port_flg", ""));
        setHubLocCd(JSPUtil.getParameter(request, prefix + "hub_loc_cd", ""));
        setSlsOfcCd(JSPUtil.getParameter(request, prefix + "sls_ofc_cd", ""));
        setLocGrdNo(JSPUtil.getParameter(request, prefix + "loc_grd_no", ""));
        setGmtHrs(JSPUtil.getParameter(request, prefix + "gmt_hrs", ""));
        setBkgBlPfxCd(JSPUtil.getParameter(request, prefix + "bkg_bl_pfx_cd", ""));
        setCallPortFlg(JSPUtil.getParameter(request, prefix + "call_port_flg", ""));
        setLocAmsPortCd(JSPUtil.getParameter(request, prefix + "loc_ams_port_cd", ""));
        setFincCtrlOfcCd(JSPUtil.getParameter(request, prefix + "finc_ctrl_ofc_cd", ""));
        setEqCtrlOfcCd(JSPUtil.getParameter(request, prefix + "eq_ctrl_ofc_cd", ""));
        setMtyPkupYdCd(JSPUtil.getParameter(request, prefix + "mty_pkup_yd_cd", ""));
        setSenEqOfcCd(JSPUtil.getParameter(request, prefix + "sen_eq_ofc_cd", ""));
        setEqRtnYdCd(JSPUtil.getParameter(request, prefix + "eq_rtn_yd_cd", ""));
        setUnLocCd(JSPUtil.getParameter(request, prefix + "un_loc_cd", ""));
        setCmlZnFlg(JSPUtil.getParameter(request, prefix + "cml_zn_flg", ""));
        setCstmsCd(JSPUtil.getParameter(request, prefix + "cstms_cd", ""));
        setLocTpCd(JSPUtil.getParameter(request, prefix + "loc_tp_cd", ""));
        setBfrFincCtrlOfcCd(JSPUtil.getParameter(request, prefix + "bfr_finc_ctrl_ofc_cd", ""));
        setBfrEqCtrlOfcCd(JSPUtil.getParameter(request, prefix + "bfr_eq_ctrl_ofc_cd", ""));
        setBfrOfcCngDt(JSPUtil.getParameter(request, prefix + "bfr_ofc_cng_dt", ""));
        setZipCd(JSPUtil.getParameter(request, prefix + "zip_cd", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
        setRepZnCd(JSPUtil.getParameter(request, prefix + "rep_zn_cd", ""));
        setLocLoclLangNm(JSPUtil.getParameter(request, prefix + "loc_locl_lang_nm", ""));
        setLocLat(JSPUtil.getParameter(request, prefix + "loc_lat", ""));
        setLatUtCd(JSPUtil.getParameter(request, prefix + "lat_ut_cd", ""));
        setLocLon(JSPUtil.getParameter(request, prefix + "loc_lon", ""));
        setLonUtCd(JSPUtil.getParameter(request, prefix + "lon_ut_cd", ""));
        setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
        setCudFlg(JSPUtil.getParameter(request, prefix + "cud_flg", ""));
        setBfrSlsOfcCd(JSPUtil.getParameter(request, prefix + "bfr_sls_ofc_cd", ""));
        setUnLocIndCd(JSPUtil.getParameter(request, prefix + "un_loc_ind_cd", ""));
        setEaiEvntDt(JSPUtil.getParameter(request, prefix + "eai_evnt_dt", ""));
        setEaiIfId(JSPUtil.getParameter(request, prefix + "eai_if_id", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return LocationIfVO[]
	 */
    public LocationMainIfVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return LocationIfVO[]
	 */
    public LocationMainIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        LocationMainIfVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] locCd = (JSPUtil.getParameter(request, prefix + "loc_cd", length));
            String[] sccCd = (JSPUtil.getParameter(request, prefix + "scc_cd", length));
            String[] locNm = (JSPUtil.getParameter(request, prefix + "loc_nm", length));
            String[] rgnCd = (JSPUtil.getParameter(request, prefix + "rgn_cd", length));
            String[] cntCd = (JSPUtil.getParameter(request, prefix + "cnt_cd", length));
            String[] steCd = (JSPUtil.getParameter(request, prefix + "ste_cd", length));
            String[] contiCd = (JSPUtil.getParameter(request, prefix + "conti_cd", length));
            String[] scontiCd = (JSPUtil.getParameter(request, prefix + "sconti_cd", length));
            String[] portInlndCd = (JSPUtil.getParameter(request, prefix + "port_inlnd_cd", length));
            String[] locChrCd = (JSPUtil.getParameter(request, prefix + "loc_chr_cd", length));
            String[] blkPortFlg = (JSPUtil.getParameter(request, prefix + "blk_port_flg", length));
            String[] hubLocCd = (JSPUtil.getParameter(request, prefix + "hub_loc_cd", length));
            String[] slsOfcCd = (JSPUtil.getParameter(request, prefix + "sls_ofc_cd", length));
            String[] locGrdNo = (JSPUtil.getParameter(request, prefix + "loc_grd_no", length));
            String[] gmtHrs = (JSPUtil.getParameter(request, prefix + "gmt_hrs", length));
            String[] bkgBlPfxCd = (JSPUtil.getParameter(request, prefix + "bkg_bl_pfx_cd", length));
            String[] callPortFlg = (JSPUtil.getParameter(request, prefix + "call_port_flg", length));
            String[] locAmsPortCd = (JSPUtil.getParameter(request, prefix + "loc_ams_port_cd", length));
            String[] fincCtrlOfcCd = (JSPUtil.getParameter(request, prefix + "finc_ctrl_ofc_cd", length));
            String[] eqCtrlOfcCd = (JSPUtil.getParameter(request, prefix + "eq_ctrl_ofc_cd", length));
            String[] mtyPkupYdCd = (JSPUtil.getParameter(request, prefix + "mty_pkup_yd_cd", length));
            String[] senEqOfcCd = (JSPUtil.getParameter(request, prefix + "sen_eq_ofc_cd", length));
            String[] eqRtnYdCd = (JSPUtil.getParameter(request, prefix + "eq_rtn_yd_cd", length));
            String[] unLocCd = (JSPUtil.getParameter(request, prefix + "un_loc_cd", length));
            String[] cmlZnFlg = (JSPUtil.getParameter(request, prefix + "cml_zn_flg", length));
            String[] cstmsCd = (JSPUtil.getParameter(request, prefix + "cstms_cd", length));
            String[] locTpCd = (JSPUtil.getParameter(request, prefix + "loc_tp_cd", length));
            String[] bfrFincCtrlOfcCd = (JSPUtil.getParameter(request, prefix + "bfr_finc_ctrl_ofc_cd", length));
            String[] bfrEqCtrlOfcCd = (JSPUtil.getParameter(request, prefix + "bfr_eq_ctrl_ofc_cd", length));
            String[] bfrOfcCngDt = (JSPUtil.getParameter(request, prefix + "bfr_ofc_cng_dt", length));
            String[] zipCd = (JSPUtil.getParameter(request, prefix + "zip_cd", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
            String[] repZnCd = (JSPUtil.getParameter(request, prefix + "rep_zn_cd", length));
            String[] locLoclLangNm = (JSPUtil.getParameter(request, prefix + "loc_locl_lang_nm", length));
            String[] locLat = (JSPUtil.getParameter(request, prefix + "loc_lat", length));
            String[] latUtCd = (JSPUtil.getParameter(request, prefix + "lat_ut_cd", length));
            String[] locLon = (JSPUtil.getParameter(request, prefix + "loc_lon", length));
            String[] lonUtCd = (JSPUtil.getParameter(request, prefix + "lon_ut_cd", length));
            String[] usrId = (JSPUtil.getParameter(request, prefix + "usr_id", length));
            String[] cudFlg = (JSPUtil.getParameter(request, prefix + "cud_flg", length));
            String[] bfrSlsOfcCd = (JSPUtil.getParameter(request, prefix + "bfr_sls_ofc_cd", length));
            String[] unLocIndCd = (JSPUtil.getParameter(request, prefix + "un_loc_ind_cd", length));
            String[] eaiEvntDt = (JSPUtil.getParameter(request, prefix + "eai_evnt_dt", length));
	    	String[] eaiIfId = (JSPUtil.getParameter(request, prefix + "eai_if_id", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new LocationMainIfVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
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
                if (scontiCd[i] != null)
                    model.setScontiCd(scontiCd[i]);
                if (portInlndCd[i] != null)
                    model.setPortInlndCd(portInlndCd[i]);
                if (locChrCd[i] != null)
                    model.setLocChrCd(locChrCd[i]);
                if (blkPortFlg[i] != null)
                    model.setBlkPortFlg(blkPortFlg[i]);
                if (hubLocCd[i] != null)
                    model.setHubLocCd(hubLocCd[i]);
                if (slsOfcCd[i] != null)
                    model.setSlsOfcCd(slsOfcCd[i]);
                if (locGrdNo[i] != null)
                    model.setLocGrdNo(locGrdNo[i]);
                if (gmtHrs[i] != null)
                    model.setGmtHrs(gmtHrs[i]);
                if (bkgBlPfxCd[i] != null)
                    model.setBkgBlPfxCd(bkgBlPfxCd[i]);
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
                if (senEqOfcCd[i] != null)
                    model.setSenEqOfcCd(senEqOfcCd[i]);
                if (eqRtnYdCd[i] != null)
                    model.setEqRtnYdCd(eqRtnYdCd[i]);
                if (unLocCd[i] != null)
                    model.setUnLocCd(unLocCd[i]);
                if (cmlZnFlg[i] != null)
                    model.setCmlZnFlg(cmlZnFlg[i]);
                if (cstmsCd[i] != null)
                    model.setCstmsCd(cstmsCd[i]);
                if (locTpCd[i] != null)
                    model.setLocTpCd(locTpCd[i]);
                if (bfrFincCtrlOfcCd[i] != null)
                    model.setBfrFincCtrlOfcCd(bfrFincCtrlOfcCd[i]);
                if (bfrEqCtrlOfcCd[i] != null)
                    model.setBfrEqCtrlOfcCd(bfrEqCtrlOfcCd[i]);
                if (bfrOfcCngDt[i] != null)
                    model.setBfrOfcCngDt(bfrOfcCngDt[i]);
                if (zipCd[i] != null)
                    model.setZipCd(zipCd[i]);
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
                if (repZnCd[i] != null)
                    model.setRepZnCd(repZnCd[i]);
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
                if (usrId[i] != null)
                    model.setUsrId(usrId[i]);
                if (cudFlg[i] != null)
                    model.setCudFlg(cudFlg[i]);
                if (bfrSlsOfcCd[i] != null)
                    model.setBfrSlsOfcCd(bfrSlsOfcCd[i]);
                if (unLocIndCd[i] != null)
                    model.setUnLocIndCd(unLocIndCd[i]);
                if (eaiEvntDt[i] != null) 
		    		model.setEaiEvntDt(eaiEvntDt[i]);
				if (eaiIfId[i] != null) 
		    		model.setEaiIfId(eaiIfId[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getLocationMainIfVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return LocationIfVO[]
	 */
    public LocationMainIfVO[] getLocationMainIfVOs() {
        LocationMainIfVO[] vos = (LocationMainIfVO[]) models.toArray(new LocationMainIfVO[models.size()]);
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
        this.locCd = this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sccCd = this.sccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locNm = this.locNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rgnCd = this.rgnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntCd = this.cntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.steCd = this.steCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.contiCd = this.contiCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scontiCd = this.scontiCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.portInlndCd = this.portInlndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locChrCd = this.locChrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blkPortFlg = this.blkPortFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hubLocCd = this.hubLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slsOfcCd = this.slsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locGrdNo = this.locGrdNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.gmtHrs = this.gmtHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgBlPfxCd = this.bkgBlPfxCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.callPortFlg = this.callPortFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locAmsPortCd = this.locAmsPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fincCtrlOfcCd = this.fincCtrlOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqCtrlOfcCd = this.eqCtrlOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mtyPkupYdCd = this.mtyPkupYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.senEqOfcCd = this.senEqOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqRtnYdCd = this.eqRtnYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.unLocCd = this.unLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmlZnFlg = this.cmlZnFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cstmsCd = this.cstmsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locTpCd = this.locTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bfrFincCtrlOfcCd = this.bfrFincCtrlOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bfrEqCtrlOfcCd = this.bfrEqCtrlOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bfrOfcCngDt = this.bfrOfcCngDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.zipCd = this.zipCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.repZnCd = this.repZnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locLoclLangNm = this.locLoclLangNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locLat = this.locLat.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.latUtCd = this.latUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locLon = this.locLon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lonUtCd = this.lonUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrId = this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cudFlg = this.cudFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bfrSlsOfcCd = this.bfrSlsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.unLocIndCd = this.unLocIndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eaiEvntDt = this.eaiEvntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eaiIfId = this.eaiIfId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
