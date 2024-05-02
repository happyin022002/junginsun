/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorDiscCYBondInfoVO.java
*@FileTitle : KorDiscCYBondInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.10 박상훈 
* 1.0 Creation
* 2011.12.09 김종호 [CHM-201114963] [BKG] warehouse Assign by B/L 수정 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.DiscCYBondInfoVO;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박상훈
 * @since J2EE 1.6
 * @see DiscCYBondInfoVO
 */
public class KorDiscCYBondInfoVO extends com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.DiscCYBondInfoVO {

    private static final long serialVersionUID = 1L;

    private Collection<KorDiscCYBondInfoVO> models = new ArrayList<KorDiscCYBondInfoVO>();

    /* Column Info */
    private String cstmsDchgLocWhCd = null;

    /* Column Info */
    private String cstmsCrrInLocWhCd = null;

    /* Column Info */
    private String cstmsCrrInLocWhNm = null;

    /* Column Info */
    private String localTs = null;

    /* Column Info */
    private String searchType = null;

    /* Column Info */
    private String xptLicNo = null;

    /* Column Info */
    private String nfty = null;

    /* Column Info */
    private String blNo = null;

    /* Column Info */
    private String mfRefNo = null;

    /* Page Number */
    private String pagerows = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String locCd = null;

    /* Column Info */
    private String cstmsDesc = null;

    /* Column Info */
    private String cstmsClrTpCd = null;

    /* Column Info */
    private String krCstmsBlTpCd = null;

    /* Column Info */
    private String wgtUtCd = null;

    /* Column Info */
    private String measQty = null;

    /* Column Info */
    private String pckQty = null;

    /* Column Info */
    private String mfCfmFlg = null;

    /* Column Info */
    private String mrnBlTsCd = null;

    /* Column Info */
    private String pckTpCd = null;

    /* Column Info */
    private String measUtCd = null;

    /* Column Info */
    private String cstmsClrWhCd = null;

    /* Column Info */
    private String mrnChkNo = null;

    /* Column Info */
    private String delCd = null;

    /* Column Info */
    private String ioBndCd = null;

    /* Column Info */
    private String locNm = null;

    /* Column Info */
    private String actWgt = null;

    /* Column Info */
    private String whNm = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String polCd = null;

    /* Column Info */
    private String cstmsClrLocCd = null;

    /* Column Info */
    private String vvd = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String bdTpCd = null;

    /* Column Info */
    private String cnee = null;

    /* Column Info */
    private String bkgRtWhfExptCd = null;

    /* Column Info */
    private String whfShprRgstNo = null;

    /* Column Info */
    private String mfSeqNo = null;

    /* Column Info */
    private String slanCd = null;

    /* Column Info */
    private String usrId = null;

    private String updateChk = null;

    private String bkgDelCd = null;

    private String mdmLocNm = null;

    private String delTermCd = null;

    private String cltOfcCd = null;

    private KorBkgHistVO bkgHistVO = null;

    private KorBkgHistVO bkgHistDtlVO = null;

    private String whfMode = null;

    private KorWhfExptVO korWhfExptVO = null;

    private KorGrpMsnVO korGrpMsnVO = null;

    private String yard = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String viaWebMsg = null;

    /* Column Info */
    private String doNo = null;

    /* Column Info */
    private String evntDt = null;

    /* Column Info */
    private String bdrFlg = null;

    /* Column Info */
    private String rtSeq = null;

    /* Column Info */
    private String whfTp = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Column Info */
    private String cbmAmt = null;

    /* Column Info */
    private String tonAmt = null;

    /* Column Info */
    private String ratUtCd = null;

    /* Column Info */
    private String ratAsQty = null;

    /* Column Info */
    private String chgUtAmt = null;

    /* Column Info */
    private String chgAmt = null;

    /* Column Info */
    private String whfWave = null;

    /* Column Info */
    private String bfrWhfWave = null;

    /* Column Info */
    private String totalVol = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public KorDiscCYBondInfoVO() {
    }

    public KorDiscCYBondInfoVO(String ibflag, String pagerows, String vvd, String localTs, String mrnBlTsCd, String mfRefNo, String mrnChkNo, String mfSeqNo, String mfCfmFlg, String cnee, String nfty, String pckQty, String pckTpCd, String actWgt, String wgtUtCd, String measQty, String measUtCd, String cstmsDesc, String cstmsClrTpCd, String cstmsDchgLocWhCd, String cstmsCrrInLocWhCd, String cstmsCrrInLocWhNm, String locNm, String krCstmsBlTpCd, String cstmsClrWhCd, String whNm, String locCd, String bdTpCd, String bkgNo, String blNo, String cstmsClrLocCd, String delCd, String podCd, String polCd, String xptLicNo, String ioBndCd, String searchType, String usrId, String updateChk, String bkgRtWhfExptCd, String whfShprRgstNo, String slanCd, String skdDirCd, String bkgDelCd, String mdmLocNm, String delTermCd, String cltOfcCd, String yard, String updUsrId, String viaWebMsg, String doNo, String evntDt, String bdrFlg, String rtSeq, String whfTp, String vslCd, String skdVoyNo, String cbmAmt, String tonAmt, String ratUtCd, String ratAsQty, String chgUtAmt, String chgAmt, String whfWave, String bfrWhfWave, String totalVol) {
        this.cstmsDchgLocWhCd = cstmsDchgLocWhCd;
        this.cstmsCrrInLocWhCd = cstmsCrrInLocWhCd;
        this.cstmsCrrInLocWhNm = cstmsCrrInLocWhNm;
        this.localTs = localTs;
        this.searchType = searchType;
        this.xptLicNo = xptLicNo;
        this.nfty = nfty;
        this.blNo = blNo;
        this.mfRefNo = mfRefNo;
        this.pagerows = pagerows;
        this.ibflag = ibflag;
        this.locCd = locCd;
        this.cstmsDesc = cstmsDesc;
        this.cstmsClrTpCd = cstmsClrTpCd;
        this.krCstmsBlTpCd = krCstmsBlTpCd;
        this.wgtUtCd = wgtUtCd;
        this.measQty = measQty;
        this.pckQty = pckQty;
        this.mfCfmFlg = mfCfmFlg;
        this.mrnBlTsCd = mrnBlTsCd;
        this.pckTpCd = pckTpCd;
        this.measUtCd = measUtCd;
        this.cstmsClrWhCd = cstmsClrWhCd;
        this.mrnChkNo = mrnChkNo;
        this.delCd = delCd;
        this.ioBndCd = ioBndCd;
        this.locNm = locNm;
        this.actWgt = actWgt;
        this.whNm = whNm;
        this.podCd = podCd;
        this.polCd = polCd;
        this.cstmsClrLocCd = cstmsClrLocCd;
        this.vvd = vvd;
        this.bkgNo = bkgNo;
        this.bdTpCd = bdTpCd;
        this.cnee = cnee;
        this.mfSeqNo = mfSeqNo;
        this.usrId = usrId;
        this.updateChk = updateChk;
        this.bkgRtWhfExptCd = bkgRtWhfExptCd;
        this.whfShprRgstNo = whfShprRgstNo;
        this.slanCd = slanCd;
        this.skdDirCd = skdDirCd;
        this.bkgDelCd = bkgDelCd;
        this.mdmLocNm = mdmLocNm;
        this.delTermCd = delTermCd;
        this.cltOfcCd = cltOfcCd;
        this.yard = yard;
        this.updUsrId = updUsrId;
        this.viaWebMsg = viaWebMsg;
        this.doNo = doNo;
        this.evntDt = evntDt;
        this.bdrFlg = bdrFlg;
        this.rtSeq = rtSeq;
        this.whfTp = whfTp;
        this.vslCd = vslCd;
        this.skdVoyNo = skdVoyNo;
        this.cbmAmt = cbmAmt;
        this.tonAmt = tonAmt;
        this.ratUtCd = ratUtCd;
        this.ratAsQty = ratAsQty;
        this.chgUtAmt = chgUtAmt;
        this.chgAmt = chgAmt;
        this.whfWave = whfWave;
        this.bfrWhfWave = bfrWhfWave;
        this.totalVol = totalVol;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("cstms_dchg_loc_wh_cd", getCstmsDchgLocWhCd());
        this.hashColumns.put("cstms_crr_in_loc_wh_cd", getCstmsCrrInLocWhCd());
        this.hashColumns.put("cstms_crr_in_loc_wh_nm", getCstmsCrrInLocWhNm());
        this.hashColumns.put("local_ts", getLocalTs());
        this.hashColumns.put("search_type", getSearchType());
        this.hashColumns.put("xpt_lic_no", getXptLicNo());
        this.hashColumns.put("nfty", getNfty());
        this.hashColumns.put("bl_no", getBlNo());
        this.hashColumns.put("mf_ref_no", getMfRefNo());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("loc_cd", getLocCd());
        this.hashColumns.put("cstms_desc", getCstmsDesc());
        this.hashColumns.put("cstms_clr_tp_cd", getCstmsClrTpCd());
        this.hashColumns.put("kr_cstms_bl_tp_cd", getKrCstmsBlTpCd());
        this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
        this.hashColumns.put("meas_qty", getMeasQty());
        this.hashColumns.put("pck_qty", getPckQty());
        this.hashColumns.put("mf_cfm_flg", getMfCfmFlg());
        this.hashColumns.put("mrn_bl_ts_cd", getMrnBlTsCd());
        this.hashColumns.put("pck_tp_cd", getPckTpCd());
        this.hashColumns.put("meas_ut_cd", getMeasUtCd());
        this.hashColumns.put("cstms_clr_wh_cd", getCstmsClrWhCd());
        this.hashColumns.put("mrn_chk_no", getMrnChkNo());
        this.hashColumns.put("del_cd", getDelCd());
        this.hashColumns.put("io_bnd_cd", getIoBndCd());
        this.hashColumns.put("loc_nm", getLocNm());
        this.hashColumns.put("act_wgt", getActWgt());
        this.hashColumns.put("wh_nm", getWhNm());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("cstms_clr_loc_cd", getCstmsClrLocCd());
        this.hashColumns.put("vvd", getVvd());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("bd_tp_cd", getBdTpCd());
        this.hashColumns.put("cnee", getCnee());
        this.hashColumns.put("mf_seq_no", getMfSeqNo());
        this.hashColumns.put("usr_id", getUsrId());
        this.hashColumns.put("update_chk", getUpdateChk());
        this.hashColumns.put("bkg_rt_whf_expt_cd", getBkgRtWhfExptCd());
        this.hashColumns.put("whf_shpr_rgst_no", getWhfShprRgstNo());
        this.hashColumns.put("slan_cd", getSlanCd());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("bkg_del_cd", getBkgDelCd());
        this.hashColumns.put("mdm_loc_nm", getMdmLocNm());
        this.hashColumns.put("del_term_cd", getDelTermCd());
        this.hashColumns.put("clt_ofc_cd", getCltOfcCd());
        this.hashColumns.put("yard", getYard());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("viaWebMsg", getViaWebMsg());
        this.hashColumns.put("do_no", getDoNo());
        this.hashColumns.put("evnt_dt", getEvntDt());
        this.hashColumns.put("bdr_flg", getBdrFlg());
        this.hashColumns.put("rt_seq", getRtSeq());
        this.hashColumns.put("whf_tp", getWhfTp());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("cbm_amt", getCbmAmt());
        this.hashColumns.put("ton_amt", getTonAmt());
        this.hashColumns.put("rat_ut_cd", getRatUtCd());
        this.hashColumns.put("rat_as_qty", getRatAsQty());
        this.hashColumns.put("chg_ut_amt", getChgUtAmt());
        this.hashColumns.put("chg_amt", getChgAmt());
        this.hashColumns.put("whf_wave", getWhfWave());
        this.hashColumns.put("bfr_whf_wave", getBfrWhfWave());
        this.hashColumns.put("total_vol", getTotalVol());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("cstms_dchg_loc_wh_cd", "cstmsDchgLocWhCd");
        this.hashFields.put("cstms_crr_in_loc_wh_cd", "cstmsCrrInLocWhCd");
        this.hashFields.put("cstms_crr_in_loc_wh_nm", "cstmsCrrInLocWhNm");
        this.hashFields.put("local_ts", "localTs");
        this.hashFields.put("search_type", "searchType");
        this.hashFields.put("xpt_lic_no", "xptLicNo");
        this.hashFields.put("nfty", "nfty");
        this.hashFields.put("bl_no", "blNo");
        this.hashFields.put("mf_ref_no", "mfRefNo");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("loc_cd", "locCd");
        this.hashFields.put("cstms_desc", "cstmsDesc");
        this.hashFields.put("cstms_clr_tp_cd", "cstmsClrTpCd");
        this.hashFields.put("kr_cstms_bl_tp_cd", "krCstmsBlTpCd");
        this.hashFields.put("wgt_ut_cd", "wgtUtCd");
        this.hashFields.put("meas_qty", "measQty");
        this.hashFields.put("pck_qty", "pckQty");
        this.hashFields.put("mf_cfm_flg", "mfCfmFlg");
        this.hashFields.put("mrn_bl_ts_cd", "mrnBlTsCd");
        this.hashFields.put("pck_tp_cd", "pckTpCd");
        this.hashFields.put("meas_ut_cd", "measUtCd");
        this.hashFields.put("cstms_clr_wh_cd", "cstmsClrWhCd");
        this.hashFields.put("mrn_chk_no", "mrnChkNo");
        this.hashFields.put("del_cd", "delCd");
        this.hashFields.put("io_bnd_cd", "ioBndCd");
        this.hashFields.put("loc_nm", "locNm");
        this.hashFields.put("act_wgt", "actWgt");
        this.hashFields.put("wh_nm", "whNm");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("cstms_clr_loc_cd", "cstmsClrLocCd");
        this.hashFields.put("vvd", "vvd");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("bd_tp_cd", "bdTpCd");
        this.hashFields.put("cnee", "cnee");
        this.hashFields.put("mf_seq_no", "mfSeqNo");
        this.hashFields.put("usr_id", "usrId");
        this.hashFields.put("update_chk", "updateChk");
        this.hashFields.put("whf_shpr_rgst_no", "whfShprRgstNo");
        this.hashFields.put("bkg_rt_whf_expt_cd", "bkgRtWhfExptCd");
        this.hashFields.put("slan_cd", "slanCd");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("bkg_del_cd", "bkgDelCd");
        this.hashFields.put("mdm_loc_nm", "mdmLocNm");
        this.hashFields.put("del_term_cd", "delTermCd");
        this.hashFields.put("clt_ofc_cd", "cltOfcCd");
        this.hashFields.put("yard", "yard");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("viaWebMsg", "viaWebMsg");
        this.hashFields.put("doNo", "doNo");
        this.hashFields.put("evntDt", "evntDt");
        this.hashFields.put("bdr_flg", "bdrFlg");
        this.hashFields.put("rt_seq", "rtSeq");
        this.hashFields.put("whf_tp", "whfTp");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("cbm_amt", "cbmAmt");
        this.hashFields.put("ton_amt", "tonAmt");
        this.hashFields.put("rat_ut_cd", "ratUtCd");
        this.hashFields.put("rat_as_qty", "ratAsQty");
        this.hashFields.put("chg_ut_amt", "chgUtAmt");
        this.hashFields.put("chg_amt", "chgAmt");
        this.hashFields.put("whf_wave", "whfWave");
        this.hashFields.put("bfr_whf_wave", "bfrWhfWave");
        this.hashFields.put("total_vol", "totalVol");
        return this.hashFields;
    }
    
    /**
	 * @return the korGrpMsnVO
	 */
    public KorGrpMsnVO getKorGrpMsnVO() {
        return korGrpMsnVO;
    }

    /**
	 * @param korGrpMsnVO the korGrpMsnVO to set
	 */
    public void setKorGrpMsnVO(KorGrpMsnVO korGrpMsnVO) {
        this.korGrpMsnVO = korGrpMsnVO;
    }

    public String getYard() {
        return yard;
    }

    public void setYard(String yard) {
        this.yard = yard;
    }

    /**
	 * @return the cltOfcCd
	 */
    public String getCltOfcCd() {
        return cltOfcCd;
    }

    /**
	 * @param cltOfcCd the cltOfcCd to set
	 */
    public void setCltOfcCd(String cltOfcCd) {
        this.cltOfcCd = cltOfcCd;
    }

    /**
	 * @return the bkgHistVO
	 */
    public KorBkgHistVO getBkgHistVO() {
        return bkgHistVO;
    }

    /**
	 * @param bkgHistVO the bkgHistVO to set
	 */
    public void setBkgHistVO(KorBkgHistVO bkgHistVO) {
        this.bkgHistVO = bkgHistVO;
    }

    /**
	 * @return the bkgHistDtlVO
	 */
    public KorBkgHistVO getBkgHistDtlVO() {
        return bkgHistDtlVO;
    }

    /**
	 * @param bkgHistDtlVO the bkgHistDtlVO to set
	 */
    public void setBkgHistDtlVO(KorBkgHistVO bkgHistDtlVO) {
        this.bkgHistDtlVO = bkgHistDtlVO;
    }

    /**
	 * @return the whfMode
	 */
    public String getWhfMode() {
        return whfMode;
    }

    /**
	 * @param whfMode the whfMode to set
	 */
    public void setWhfMode(String whfMode) {
        this.whfMode = whfMode;
    }

    /**
	 * @return the korWhfExptVO
	 */
    public KorWhfExptVO getKorWhfExptVO() {
        return korWhfExptVO;
    }

    /**
	 * @param korWhfExptVO the korWhfExptVO to set
	 */
    public void setKorWhfExptVO(KorWhfExptVO korWhfExptVO) {
        this.korWhfExptVO = korWhfExptVO;
    }

    /**
	 * @return the updUsrId
	 */
    public String getUpdUsrId() {
        return updUsrId;
    }

    /**
	 * @param updUsrId the updUsrId to set
	 */
    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    /**
	 * @return the viaWebMsg
	 */
    public String getViaWebMsg() {
        return viaWebMsg;
    }

    /**
	 * @param viaWebMsg the viaWebMsg to set
	 */
    public void setViaWebMsg(String viaWebMsg) {
        this.viaWebMsg = viaWebMsg;
    }
    
    /**
	 * @return the bkgDelCd
	 */
    public String getBkgDelCd() {
        return bkgDelCd;
    }

    /**
	 * @param bkgDelCd the bkgDelCd to set
	 */
    public void setBkgDelCd(String bkgDelCd) {
        this.bkgDelCd = bkgDelCd;
    }

    /**
	 * @return the mdmLocNm
	 */
    public String getMdmLocNm() {
        return mdmLocNm;
    }

    /**
	 * @param mdmLocNm the mdmLocNm to set
	 */
    public void setMdmLocNm(String mdmLocNm) {
        this.mdmLocNm = mdmLocNm;
    }

    /**
	 * @return the delTermCd
	 */
    public String getDelTermCd() {
        return delTermCd;
    }

    /**
	 * @param delTermCd the delTermCd to set
	 */
    public void setDelTermCd(String delTermCd) {
        this.delTermCd = delTermCd;
    }

    /**
	 * @return the polCd
	 */
    public String getPolCd() {
        return polCd;
    }

    /**
	 * @param polCd the polCd to set
	 */
    public void setPolCd(String polCd) {
        this.polCd = polCd;
    }

    /**
	 * @return the slanCd
	 */
    public String getSlanCd() {
        return slanCd;
    }

    /**
	 * @param slanCd the slanCd to set
	 */
    public void setSlanCd(String slanCd) {
        this.slanCd = slanCd;
    }

    /**
	 * @return the skdDirCd
	 */
    public String getSkdDirCd() {
        return skdDirCd;
    }

    /**
	 * @param skdDirCd the skdDirCd to set
	 */
    public void setSkdDirCd(String skdDirCd) {
        this.skdDirCd = skdDirCd;
    }

    /**
	 * @return the bkgRtWhfExptCd
	 */
    public String getBkgRtWhfExptCd() {
        return bkgRtWhfExptCd;
    }

    /**
	 * @param bkgRtWhfExptCd the bkgRtWhfExptCd to set
	 */
    public void setBkgRtWhfExptCd(String bkgRtWhfExptCd) {
        this.bkgRtWhfExptCd = bkgRtWhfExptCd;
    }

    /**
	 * @return the whfShprRgstNo
	 */
    public String getWhfShprRgstNo() {
        return whfShprRgstNo;
    }

    /**
	 * @param whfShprRgstNo the whfShprRgstNo to set
	 */
    public void setWhfShprRgstNo(String whfShprRgstNo) {
        this.whfShprRgstNo = whfShprRgstNo;
    }

    /**
	 * @return the updateChk
	 */
    public String getUpdateChk() {
        return updateChk;
    }

    /**
	 * @param updateChk the updateChk to set
	 */
    public void setUpdateChk(String updateChk) {
        this.updateChk = updateChk;
    }

    /**
	 * @return the usrId
	 */
    public String getUsrId() {
        return usrId;
    }

    /**
	 * @param usrId the usrId to set
	 */
    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    /**
	 * Column Info
	 * @return cstmsDchgLocWhCd
	 */
    public String getCstmsDchgLocWhCd() {
        return this.cstmsDchgLocWhCd;
    }

    /**
	 * Column Info
	 * @return cstmsCrrInLocWhCd
	 */
    public String getCstmsCrrInLocWhCd() {
        return this.cstmsCrrInLocWhCd;
    }

    /**
	 * Column Info
	 * @return cstmsCrrInLocWhNm
	 */
    public String getCstmsCrrInLocWhNm() {
        return this.cstmsCrrInLocWhNm;
    }

    /**
	 * Column Info
	 * @return localTs
	 */
    public String getLocalTs() {
        return this.localTs;
    }

    /**
	 * Column Info
	 * @return searchType
	 */
    public String getSearchType() {
        return this.searchType;
    }

    /**
	 * Column Info
	 * @return xptLicNo
	 */
    public String getXptLicNo() {
        return this.xptLicNo;
    }

    /**
	 * Column Info
	 * @return nfty
	 */
    public String getNfty() {
        return this.nfty;
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
	 * @return mfRefNo
	 */
    public String getMfRefNo() {
        return this.mfRefNo;
    }

    /**
	 * Page Number
	 * @return pagerows
	 */
    public String getPagerows() {
        return this.pagerows;
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
	 * @return locCd
	 */
    public String getLocCd() {
        return this.locCd;
    }

    /**
	 * Column Info
	 * @return cstmsDesc
	 */
    public String getCstmsDesc() {
        return this.cstmsDesc;
    }

    /**
	 * Column Info
	 * @return cstmsClrTpCd
	 */
    public String getCstmsClrTpCd() {
        return this.cstmsClrTpCd;
    }

    /**
	 * Column Info
	 * @return krCstmsBlTpCd
	 */
    public String getKrCstmsBlTpCd() {
        return this.krCstmsBlTpCd;
    }

    /**
	 * Column Info
	 * @return wgtUtCd
	 */
    public String getWgtUtCd() {
        return this.wgtUtCd;
    }

    /**
	 * Column Info
	 * @return measQty
	 */
    public String getMeasQty() {
        return this.measQty;
    }

    /**
	 * Column Info
	 * @return pckQty
	 */
    public String getPckQty() {
        return this.pckQty;
    }

    /**
	 * Column Info
	 * @return mfCfmFlg
	 */
    public String getMfCfmFlg() {
        return this.mfCfmFlg;
    }

    /**
	 * Column Info
	 * @return mrnBlTsCd
	 */
    public String getMrnBlTsCd() {
        return this.mrnBlTsCd;
    }

    /**
	 * Column Info
	 * @return pckTpCd
	 */
    public String getPckTpCd() {
        return this.pckTpCd;
    }

    /**
	 * Column Info
	 * @return measUtCd
	 */
    public String getMeasUtCd() {
        return this.measUtCd;
    }

    /**
	 * Column Info
	 * @return cstmsClrWhCd
	 */
    public String getCstmsClrWhCd() {
        return this.cstmsClrWhCd;
    }

    /**
	 * Column Info
	 * @return mrnChkNo
	 */
    public String getMrnChkNo() {
        return this.mrnChkNo;
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
	 * @return ioBndCd
	 */
    public String getIoBndCd() {
        return this.ioBndCd;
    }

    /**
	 * Column Info
	 * @return locNm
	 */
    public String getLocNm() {
        return this.locNm;
    }

    /**
	 * Column Info
	 * @return actWgt
	 */
    public String getActWgt() {
        return this.actWgt;
    }

    /**
	 * Column Info
	 * @return whNm
	 */
    public String getWhNm() {
        return this.whNm;
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
	 * @return cstmsClrLocCd
	 */
    public String getCstmsClrLocCd() {
        return this.cstmsClrLocCd;
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
	 * @return bkgNo
	 */
    public String getBkgNo() {
        return this.bkgNo;
    }

    /**
	 * Column Info
	 * @return bdTpCd
	 */
    public String getBdTpCd() {
        return this.bdTpCd;
    }

    /**
	 * Column Info
	 * @return cnee
	 */
    public String getCnee() {
        return this.cnee;
    }

    /**
	 * Column Info
	 * @return mfSeqNo
	 */
    public String getMfSeqNo() {
        return this.mfSeqNo;
    }

    /**
	 * Column Info
	 * @return doNo
	 */
    public String getDoNo() {
        return this.doNo;
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
	 * @return bdrFlg
	 */
    public String getBdrFlg() {
        return this.bdrFlg;
    }

    /**
	 * Column Info
	 * @return rtSeq
	 */
    public String getRtSeq() {
        return this.rtSeq;
    }

    /**
	 * Column Info
	 * @return whfTp
	 */
    public String getWhfTp() {
        return this.whfTp;
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
	 * @return skdVoyNo
	 */
    public String getSkdVoyNo() {
        return this.skdVoyNo;
    }

    /**
	 * Column Info
	 * @return cbmAmt
	 */
    public String getCbmAmt() {
        return this.cbmAmt;
    }

    /**
	 * Column Info
	 * @return tonAmt
	 */
    public String getTonAmt() {
        return this.tonAmt;
    }

    /**
	 * Column Info
	 * @return ratUtCd
	 */
    public String getRatUtCd() {
        return this.ratUtCd;
    }

    /**
	 * Column Info
	 * @return ratAsQty
	 */
    public String getRatAsQty() {
        return this.ratAsQty;
    }

    /**
	 * Column Info
	 * @return chgUtAmt
	 */
    public String getChgUtAmt() {
        return this.chgUtAmt;
    }

    /**
	 * Column Info
	 * @return chgAmt
	 */
    public String getChgAmt() {
        return this.chgAmt;
    }

    /**
	 * Column Info
	 * @return whfWave
	 */
    public String getWhfWave() {
        return this.whfWave;
    }

    /**
	 * Column Info
	 * @return bfrWhfWave
	 */
    public String getBfrWhfWave() {
        return this.bfrWhfWave;
    }

    /**
	 * Column Info
	 * @param cstmsDchgLocWhCd
	 */
    public void setCstmsDchgLocWhCd(String cstmsDchgLocWhCd) {
        this.cstmsDchgLocWhCd = cstmsDchgLocWhCd;
    }

    /**
	 * Column Info
	 * @param cstmsCrrInLocWhCd
	 */
    public void setCstmsCrrInLocWhCd(String cstmsCrrInLocWhCd) {
        this.cstmsCrrInLocWhCd = cstmsCrrInLocWhCd;
    }

    /**
	 * Column Info
	 * @param cstmsCrrInLocWhNm
	 */
    public void setCstmsCrrInLocWhNm(String cstmsCrrInLocWhNm) {
        this.cstmsCrrInLocWhNm = cstmsCrrInLocWhNm;
    }

    /**
	 * Column Info
	 * @param localTs
	 */
    public void setLocalTs(String localTs) {
        this.localTs = localTs;
    }

    /**
	 * Column Info
	 * @param searchType
	 */
    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    /**
	 * Column Info
	 * @param xptLicNo
	 */
    public void setXptLicNo(String xptLicNo) {
        this.xptLicNo = xptLicNo;
    }

    /**
	 * Column Info
	 * @param nfty
	 */
    public void setNfty(String nfty) {
        this.nfty = nfty;
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
	 * @param mfRefNo
	 */
    public void setMfRefNo(String mfRefNo) {
        this.mfRefNo = mfRefNo;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
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
	 * @param locCd
	 */
    public void setLocCd(String locCd) {
        this.locCd = locCd;
    }

    /**
	 * Column Info
	 * @param cstmsDesc
	 */
    public void setCstmsDesc(String cstmsDesc) {
        this.cstmsDesc = cstmsDesc;
    }

    /**
	 * Column Info
	 * @param cstmsClrTpCd
	 */
    public void setCstmsClrTpCd(String cstmsClrTpCd) {
        this.cstmsClrTpCd = cstmsClrTpCd;
    }

    /**
	 * Column Info
	 * @param krCstmsBlTpCd
	 */
    public void setKrCstmsBlTpCd(String krCstmsBlTpCd) {
        this.krCstmsBlTpCd = krCstmsBlTpCd;
    }

    /**
	 * Column Info
	 * @param wgtUtCd
	 */
    public void setWgtUtCd(String wgtUtCd) {
        this.wgtUtCd = wgtUtCd;
    }

    /**
	 * Column Info
	 * @param measQty
	 */
    public void setMeasQty(String measQty) {
        this.measQty = measQty;
    }

    /**
	 * Column Info
	 * @param pckQty
	 */
    public void setPckQty(String pckQty) {
        this.pckQty = pckQty;
    }

    /**
	 * Column Info
	 * @param mfCfmFlg
	 */
    public void setMfCfmFlg(String mfCfmFlg) {
        this.mfCfmFlg = mfCfmFlg;
    }

    /**
	 * Column Info
	 * @param mrnBlTsCd
	 */
    public void setMrnBlTsCd(String mrnBlTsCd) {
        this.mrnBlTsCd = mrnBlTsCd;
    }

    /**
	 * Column Info
	 * @param pckTpCd
	 */
    public void setPckTpCd(String pckTpCd) {
        this.pckTpCd = pckTpCd;
    }

    /**
	 * Column Info
	 * @param measUtCd
	 */
    public void setMeasUtCd(String measUtCd) {
        this.measUtCd = measUtCd;
    }

    /**
	 * Column Info
	 * @param cstmsClrWhCd
	 */
    public void setCstmsClrWhCd(String cstmsClrWhCd) {
        this.cstmsClrWhCd = cstmsClrWhCd;
    }

    /**
	 * Column Info
	 * @param mrnChkNo
	 */
    public void setMrnChkNo(String mrnChkNo) {
        this.mrnChkNo = mrnChkNo;
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
	 * @param ioBndCd
	 */
    public void setIoBndCd(String ioBndCd) {
        this.ioBndCd = ioBndCd;
    }

    /**
	 * Column Info
	 * @param locNm
	 */
    public void setLocNm(String locNm) {
        this.locNm = locNm;
    }

    /**
	 * Column Info
	 * @param actWgt
	 */
    public void setActWgt(String actWgt) {
        this.actWgt = actWgt;
    }

    /**
	 * Column Info
	 * @param whNm
	 */
    public void setWhNm(String whNm) {
        this.whNm = whNm;
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
	 * @param cstmsClrLocCd
	 */
    public void setCstmsClrLocCd(String cstmsClrLocCd) {
        this.cstmsClrLocCd = cstmsClrLocCd;
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
	 * @param bkgNo
	 */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    /**
	 * Column Info
	 * @param bdTpCd
	 */
    public void setBdTpCd(String bdTpCd) {
        this.bdTpCd = bdTpCd;
    }

    /**
	 * Column Info
	 * @param cnee
	 */
    public void setCnee(String cnee) {
        this.cnee = cnee;
    }

    /**
	 * Column Info
	 * @param mfSeqNo
	 */
    public void setMfSeqNo(String mfSeqNo) {
        this.mfSeqNo = mfSeqNo;
    }

    /**
	 * Column Info
	 * @param doNo
	 */
    public void setDoNo(String doNo) {
        this.doNo = doNo;
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
	 * @param bdrFlg
	 */
    public void setBdrFlg(String bdrFlg) {
        this.bdrFlg = bdrFlg;
    }

    /**
	 * Column Info
	 * @param rtSeq
	 */
    public void setRtSeq(String rtSeq) {
        this.rtSeq = rtSeq;
    }

    /**
	 * Column Info
	 * @param whfTp
	 */
    public void setWhfTp(String whfTp) {
        this.whfTp = whfTp;
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
	 * @param skdVoyNo
	 */
    public void setSkdVoyNo(String skdVoyNo) {
        this.skdVoyNo = skdVoyNo;
    }

    /**
	 * Column Info
	 * @param cbmAmt
	 */
    public void setCbmAmt(String cbmAmt) {
        this.cbmAmt = cbmAmt;
    }

    /**
	 * Column Info
	 * @param tonAmt
	 */
    public void setTonAmt(String tonAmt) {
        this.tonAmt = tonAmt;
    }

    /**
	 * Column Info
	 * @param ratUtCd
	 */
    public void setRatUtCd(String ratUtCd) {
        this.ratUtCd = ratUtCd;
    }

    /**
	 * Column Info
	 * @param ratAsQty
	 */
    public void setRatAsQty(String ratAsQty) {
        this.ratAsQty = ratAsQty;
    }

    /**
	 * Column Info
	 * @param chgUtAmt
	 */
    public void setChgUtAmt(String chgUtAmt) {
        this.chgUtAmt = chgUtAmt;
    }

    /**
	 * Column Info
	 * @param chgAmt
	 */
    public void setChgAmt(String chgAmt) {
        this.chgAmt = chgAmt;
    }

    /**
	 * Column Info
	 * @param whfWave
	 */
    public void setWhfWave(String whfWave) {
        this.whfWave = whfWave;
    }

    /**
	 * Column Info
	 * @param bfrWhfWave
	 */
    public void setBfrWhfWave(String bfrWhfWave) {
        this.bfrWhfWave = bfrWhfWave;
    }

    public void setTotalVol(String totalVol) {
        this.totalVol = totalVol;
    }

    public String getTotalVol() {
        return this.totalVol;
    }

    public void fromRequest(HttpServletRequest request) {
    	fromRequest(request, "");
    }
    
    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request, String prefix) {
        setCstmsDchgLocWhCd(JSPUtil.getParameter(request, prefix + "cstms_dchg_loc_wh_cd", ""));
        setCstmsCrrInLocWhCd(JSPUtil.getParameter(request, prefix + "cstms_crr_in_loc_wh_cd", ""));
        setCstmsCrrInLocWhNm(JSPUtil.getParameter(request, prefix + "cstms_crr_in_loc_wh_nm", ""));
        setLocalTs(JSPUtil.getParameter(request, prefix + "local_ts", ""));
        setSearchType(JSPUtil.getParameter(request, prefix + "search_type", ""));
        setXptLicNo(JSPUtil.getParameter(request, prefix + "xpt_lic_no", ""));
        setNfty(JSPUtil.getParameter(request, prefix + "nfty", ""));
        setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
        setMfRefNo(JSPUtil.getParameter(request, prefix + "mf_ref_no", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
        setCstmsDesc(JSPUtil.getParameter(request, prefix + "cstms_desc", ""));
        setCstmsClrTpCd(JSPUtil.getParameter(request, prefix + "cstms_clr_tp_cd", ""));
        setKrCstmsBlTpCd(JSPUtil.getParameter(request, prefix + "kr_cstms_bl_tp_cd", ""));
        setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
        setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
        setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
        setMfCfmFlg(JSPUtil.getParameter(request, prefix + "mf_cfm_flg", ""));
        setMrnBlTsCd(JSPUtil.getParameter(request, prefix + "mrn_bl_ts_cd", ""));
        setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
        setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
        setCstmsClrWhCd(JSPUtil.getParameter(request, prefix + "cstms_clr_wh_cd", ""));
        setMrnChkNo(JSPUtil.getParameter(request, prefix + "mrn_chk_no", ""));
        setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
        setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
        setLocNm(JSPUtil.getParameter(request, prefix + "loc_nm", ""));
        setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
        setWhNm(JSPUtil.getParameter(request, prefix + "wh_nm", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setCstmsClrLocCd(JSPUtil.getParameter(request, prefix + "cstms_clr_loc_cd", ""));
        setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setBdTpCd(JSPUtil.getParameter(request, prefix + "bd_tp_cd", ""));
        setCnee(JSPUtil.getParameter(request, prefix + "cnee", ""));
        setMfSeqNo(JSPUtil.getParameter(request, prefix + "mf_seq_no", ""));
        setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
        setUpdateChk(JSPUtil.getParameter(request, prefix + "update_chk", ""));
        setWhfShprRgstNo(JSPUtil.getParameter(request, prefix + "whf_shpr_rgst_no", ""));
        setBkgRtWhfExptCd(JSPUtil.getParameter(request, prefix + "bkg_rt_whf_expt_cd", ""));
        setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setBkgDelCd(JSPUtil.getParameter(request, prefix + "bkg_del_cd", ""));
        setMdmLocNm(JSPUtil.getParameter(request, prefix + "mdm_loc_nm", ""));
        setDelTermCd(JSPUtil.getParameter(request, prefix + "del_term_cd", ""));
        setCltOfcCd(JSPUtil.getParameter(request, prefix + "clt_ofc_cd", ""));
        setYard(JSPUtil.getParameter(request, prefix + "yard", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setViaWebMsg(JSPUtil.getParameter(request, prefix + "viaWebMsg", ""));
        setDoNo(JSPUtil.getParameter(request, prefix + "doNo", ""));
        setEvntDt(JSPUtil.getParameter(request, prefix + "evntDt", ""));
        setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
        setRtSeq(JSPUtil.getParameter(request, prefix + "rt_seq", ""));
        setWhfTp(JSPUtil.getParameter(request, prefix + "whf_tp", ""));
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setCbmAmt(JSPUtil.getParameter(request, prefix + "cbm_amt", ""));
        setTonAmt(JSPUtil.getParameter(request, prefix + "ton_amt", ""));
        setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
        setRatAsQty(JSPUtil.getParameter(request, prefix + "rat_as_qty", ""));
        setChgUtAmt(JSPUtil.getParameter(request, prefix + "chg_ut_amt", ""));
        setChgAmt(JSPUtil.getParameter(request, prefix + "chg_amt", ""));
        setWhfWave(JSPUtil.getParameter(request, prefix + "whf_wave", ""));
        setBfrWhfWave(JSPUtil.getParameter(request, prefix + "bfr_whf_wave", ""));
        setTotalVol(JSPUtil.getParameter(request, prefix + "total_vol", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorDiscCYBondInfoVO[]
	 */
    public KorDiscCYBondInfoVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorDiscCYBondInfoVO[]
	 */
    public KorDiscCYBondInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        KorDiscCYBondInfoVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] cstmsDchgLocWhCd = (JSPUtil.getParameter(request, prefix + "cstms_dchg_loc_wh_cd", length));
            String[] cstmsCrrInLocWhCd = (JSPUtil.getParameter(request, prefix + "cstms_crr_in_loc_wh_cd", length));
            String[] cstmsCrrInLocWhNm = (JSPUtil.getParameter(request, prefix + "cstms_crr_in_loc_wh_nm", length));
            String[] localTs = (JSPUtil.getParameter(request, prefix + "local_ts", length));
            String[] searchType = (JSPUtil.getParameter(request, prefix + "search_type", length));
            String[] xptLicNo = (JSPUtil.getParameter(request, prefix + "xpt_lic_no", length));
            String[] nfty = (JSPUtil.getParameter(request, prefix + "nfty", length));
            String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
            String[] mfRefNo = (JSPUtil.getParameter(request, prefix + "mf_ref_no", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] locCd = (JSPUtil.getParameter(request, prefix + "loc_cd", length));
            String[] cstmsDesc = (JSPUtil.getParameter(request, prefix + "cstms_desc", length));
            String[] cstmsClrTpCd = (JSPUtil.getParameter(request, prefix + "cstms_clr_tp_cd", length));
            String[] krCstmsBlTpCd = (JSPUtil.getParameter(request, prefix + "kr_cstms_bl_tp_cd", length));
            String[] wgtUtCd = (JSPUtil.getParameter(request, prefix + "wgt_ut_cd", length));
            String[] measQty = (JSPUtil.getParameter(request, prefix + "meas_qty", length));
            String[] pckQty = (JSPUtil.getParameter(request, prefix + "pck_qty", length));
            String[] mfCfmFlg = (JSPUtil.getParameter(request, prefix + "mf_cfm_flg", length));
            String[] mrnBlTsCd = (JSPUtil.getParameter(request, prefix + "mrn_bl_ts_cd", length));
            String[] pckTpCd = (JSPUtil.getParameter(request, prefix + "pck_tp_cd", length));
            String[] measUtCd = (JSPUtil.getParameter(request, prefix + "meas_ut_cd", length));
            String[] cstmsClrWhCd = (JSPUtil.getParameter(request, prefix + "cstms_clr_wh_cd", length));
            String[] mrnChkNo = (JSPUtil.getParameter(request, prefix + "mrn_chk_no", length));
            String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
            String[] ioBndCd = (JSPUtil.getParameter(request, prefix + "io_bnd_cd", length));
            String[] locNm = (JSPUtil.getParameter(request, prefix + "loc_nm", length));
            String[] actWgt = (JSPUtil.getParameter(request, prefix + "act_wgt", length));
            String[] whNm = (JSPUtil.getParameter(request, prefix + "wh_nm", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] cstmsClrLocCd = (JSPUtil.getParameter(request, prefix + "cstms_clr_loc_cd", length));
            String[] vvd = (JSPUtil.getParameter(request, prefix + "vvd", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] bdTpCd = (JSPUtil.getParameter(request, prefix + "bd_tp_cd", length));
            String[] cnee = (JSPUtil.getParameter(request, prefix + "cnee", length));
            String[] mfSeqNo = (JSPUtil.getParameter(request, prefix + "mf_seq_no", length));
            String[] usrId = (JSPUtil.getParameter(request, prefix + "usr_id", length));
            String[] updateChk = (JSPUtil.getParameter(request, prefix + "update_chk", length));
            String[] whfShprRgstNo = (JSPUtil.getParameter(request, prefix + "whf_shpr_rgst_no", length));
            String[] bkgRtWhfExptCd = (JSPUtil.getParameter(request, prefix + "bkg_rt_whf_expt_cd", length));
            String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] bkgDelCd = (JSPUtil.getParameter(request, prefix + "bkg_del_cd", length));
            String[] mdmLocNm = (JSPUtil.getParameter(request, prefix + "mdm_loc_nm", length));
            String[] delTermCd = (JSPUtil.getParameter(request, prefix + "del_term_cd", length));
            String[] cltOfcCd = (JSPUtil.getParameter(request, prefix + "clf_ofc_cd", length));
            String[] yard = (JSPUtil.getParameter(request, prefix + "yard", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] viaWebMsg = (JSPUtil.getParameter(request, prefix + "viaWebMsg", length));
            String[] doNo = (JSPUtil.getParameter(request, prefix + "doNo", length));
            String[] evntDt = (JSPUtil.getParameter(request, prefix + "evntDt", length));
            String[] bdrFlg = (JSPUtil.getParameter(request, prefix + "bdr_flg", length));
            String[] rtSeq = (JSPUtil.getParameter(request, prefix + "rt_seq", length));
            String[] whfTp = (JSPUtil.getParameter(request, prefix + "whf_tp", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd".trim(), length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no".trim(), length));
            String[] cbmAmt = (JSPUtil.getParameter(request, prefix + "cbm_amt".trim(), length));
            String[] tonAmt = (JSPUtil.getParameter(request, prefix + "ton_amt".trim(), length));
            String[] ratUtCd = (JSPUtil.getParameter(request, prefix + "rat_ut_cd".trim(), length));
            String[] ratAsQty = (JSPUtil.getParameter(request, prefix + "rat_as_qty".trim(), length));
            String[] chgUtAmt = (JSPUtil.getParameter(request, prefix + "chg_ut_amt".trim(), length));
            String[] chgAmt = (JSPUtil.getParameter(request, prefix + "chg_amt".trim(), length));
            String[] whfWave = (JSPUtil.getParameter(request, prefix + "whf_wave".trim(), length));
            String[] bfrWhfWave = (JSPUtil.getParameter(request, prefix + "bfr_whf_wave".trim(), length));
            String[] totalVol = (JSPUtil.getParameter(request, prefix + "total_vol", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new KorDiscCYBondInfoVO();
                if (cstmsDchgLocWhCd[i] != null)
                    model.setCstmsDchgLocWhCd(cstmsDchgLocWhCd[i]);
                if (cstmsCrrInLocWhCd[i] != null)
                    model.setCstmsCrrInLocWhCd(cstmsCrrInLocWhCd[i]);
                if (cstmsCrrInLocWhNm[i] != null)
                    model.setCstmsCrrInLocWhNm(cstmsCrrInLocWhNm[i]);
                if (localTs[i] != null)
                    model.setLocalTs(localTs[i]);
                if (searchType[i] != null)
                    model.setSearchType(searchType[i]);
                if (xptLicNo[i] != null)
                    model.setXptLicNo(xptLicNo[i]);
                if (nfty[i] != null)
                    model.setNfty(nfty[i]);
                if (blNo[i] != null)
                    model.setBlNo(blNo[i]);
                if (mfRefNo[i] != null)
                    model.setMfRefNo(mfRefNo[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (locCd[i] != null)
                    model.setLocCd(locCd[i]);
                if (cstmsDesc[i] != null)
                    model.setCstmsDesc(cstmsDesc[i]);
                if (cstmsClrTpCd[i] != null)
                    model.setCstmsClrTpCd(cstmsClrTpCd[i]);
                if (krCstmsBlTpCd[i] != null)
                    model.setKrCstmsBlTpCd(krCstmsBlTpCd[i]);
                if (wgtUtCd[i] != null)
                    model.setWgtUtCd(wgtUtCd[i]);
                if (measQty[i] != null)
                    model.setMeasQty(measQty[i]);
                if (pckQty[i] != null)
                    model.setPckQty(pckQty[i]);
                if (mfCfmFlg[i] != null)
                    model.setMfCfmFlg(mfCfmFlg[i]);
                if (mrnBlTsCd[i] != null)
                    model.setMrnBlTsCd(mrnBlTsCd[i]);
                if (pckTpCd[i] != null)
                    model.setPckTpCd(pckTpCd[i]);
                if (measUtCd[i] != null)
                    model.setMeasUtCd(measUtCd[i]);
                if (cstmsClrWhCd[i] != null)
                    model.setCstmsClrWhCd(cstmsClrWhCd[i]);
                if (mrnChkNo[i] != null)
                    model.setMrnChkNo(mrnChkNo[i]);
                if (delCd[i] != null)
                    model.setDelCd(delCd[i]);
                if (ioBndCd[i] != null)
                    model.setIoBndCd(ioBndCd[i]);
                if (locNm[i] != null)
                    model.setLocNm(locNm[i]);
                if (actWgt[i] != null)
                    model.setActWgt(actWgt[i]);
                if (whNm[i] != null)
                    model.setWhNm(whNm[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (cstmsClrLocCd[i] != null)
                    model.setCstmsClrLocCd(cstmsClrLocCd[i]);
                if (vvd[i] != null)
                    model.setVvd(vvd[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (bdTpCd[i] != null)
                    model.setBdTpCd(bdTpCd[i]);
                if (cnee[i] != null)
                    model.setCnee(cnee[i]);
                if (mfSeqNo[i] != null)
                    model.setMfSeqNo(mfSeqNo[i]);
                if (usrId[i] != null)
                    model.setUsrId(usrId[i]);
                if (updateChk[i] != null)
                    model.setUpdateChk(updateChk[i]);
                if (whfShprRgstNo[i] != null)
                    model.setWhfShprRgstNo(whfShprRgstNo[i]);
                if (bkgRtWhfExptCd[i] != null)
                    model.setBkgRtWhfExptCd(bkgRtWhfExptCd[i]);
                if (slanCd[i] != null)
                    model.setSlanCd(slanCd[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (bkgDelCd[i] != null)
                    model.setBkgDelCd(bkgDelCd[i]);
                if (mdmLocNm[i] != null)
                    model.setMdmLocNm(mdmLocNm[i]);
                if (delTermCd[i] != null)
                    model.setDelTermCd(delTermCd[i]);
                if (cltOfcCd[i] != null)
                    model.setCltOfcCd(cltOfcCd[i]);
                if (yard[i] != null)
                    model.setYard(yard[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (viaWebMsg[i] != null)
                    model.setViaWebMsg(viaWebMsg[i]);
                if (doNo[i] != null)
                    model.setViaWebMsg(doNo[i]);
                if (evntDt[i] != null)
                    model.setViaWebMsg(evntDt[i]);
                if (bdrFlg[i] != null)
                    model.setBdrFlg(bdrFlg[i]);
                if (rtSeq[i] != null)
                    model.setRtSeq(rtSeq[i]);
                if (whfTp[i] != null)
                    model.setWhfTp(whfTp[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (cbmAmt[i] != null)
                    model.setCbmAmt(cbmAmt[i]);
                if (tonAmt[i] != null)
                    model.setTonAmt(tonAmt[i]);
                if (ratUtCd[i] != null)
                    model.setRatUtCd(ratUtCd[i]);
                if (ratAsQty[i] != null)
                    model.setRatAsQty(ratAsQty[i]);
                if (chgUtAmt[i] != null)
                    model.setChgUtAmt(chgUtAmt[i]);
                if (chgAmt[i] != null)
                    model.setChgAmt(chgAmt[i]);
                if (whfWave[i] != null)
                    model.setWhfWave(whfWave[i]);
                if (bfrWhfWave[i] != null)
                    model.setBfrWhfWave(bfrWhfWave[i]);
                if (totalVol[i] != null) 
		    		model.setTotalVol(totalVol[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getKorDiscCYBondInfoVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return KorDiscCYBondInfoVO[]
	 */
    public KorDiscCYBondInfoVO[] getKorDiscCYBondInfoVOs() {
        KorDiscCYBondInfoVO[] vos = (KorDiscCYBondInfoVO[]) models.toArray(new KorDiscCYBondInfoVO[models.size()]);
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
        this.cstmsDchgLocWhCd = this.cstmsDchgLocWhCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cstmsCrrInLocWhCd = this.cstmsCrrInLocWhCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cstmsCrrInLocWhNm = this.cstmsCrrInLocWhNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.localTs = this.localTs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.searchType = this.searchType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xptLicNo = this.xptLicNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nfty = this.nfty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mfRefNo = this.mfRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locCd = this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cstmsDesc = this.cstmsDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cstmsClrTpCd = this.cstmsClrTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.krCstmsBlTpCd = this.krCstmsBlTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.wgtUtCd = this.wgtUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.measQty = this.measQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckQty = this.pckQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mfCfmFlg = this.mfCfmFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mrnBlTsCd = this.mrnBlTsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckTpCd = this.pckTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.measUtCd = this.measUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cstmsClrWhCd = this.cstmsClrWhCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mrnChkNo = this.mrnChkNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ioBndCd = this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locNm = this.locNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actWgt = this.actWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.whNm = this.whNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cstmsClrLocCd = this.cstmsClrLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvd = this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bdTpCd = this.bdTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cnee = this.cnee.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mfSeqNo = this.mfSeqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrId = this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updateChk = this.updateChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgRtWhfExptCd = this.bkgRtWhfExptCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.whfShprRgstNo = this.whfShprRgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgDelCd = this.bkgDelCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mdmLocNm = this.mdmLocNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delTermCd = this.delTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cltOfcCd = this.cltOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.yard = this.yard.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.doNo = this.doNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.evntDt = this.evntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bdrFlg = this.bdrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtSeq = this.rtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.whfTp = this.whfTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cbmAmt = this.cbmAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tonAmt = this.tonAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ratUtCd = this.ratUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ratAsQty = this.ratAsQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chgUtAmt = this.chgUtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chgAmt = this.chgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.whfWave = this.whfWave.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bfrWhfWave = this.bfrWhfWave.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalVol = this.totalVol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
