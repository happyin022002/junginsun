/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaAiBlInfoVO.java
*@FileTitle : UsaAiBlInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.11
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.08.11 김민정 
* 1.0 Creation
* -----------------------------------------------------
* History
* 2012.01.31 민정호 [CHM-201215726-01] AMS 전송시 Customs 로직 추가 요청 
* 2012.05.10 김보배 [CHM-201217461] [BKG] [ACE M1] US AMS 전송후 1J 이후 Diversion 요청 기능 추가
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo;

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
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class UsaAiBlInfoVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<UsaAiBlInfoVO> models = new ArrayList<UsaAiBlInfoVO>();

    /* Column Info */
    private String usaLstLocCd = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String cstmsFileTpCd = null;

    /* Column Info */
    private String bkgCustTpCd = null;

    /* Column Info */
    private String cstmsClrTpCdChg = null;

    /* Column Info */
    private String preMfNo = null;

    /* Column Info */
    private String ibdTrspTpCdChg = null;

    /* Column Info */
    private String blNo = null;

    /* Column Info */
    private String scNo = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String polCd = null;

    /* Column Info */
    private String frtCltFlg = null;

    /* Column Info */
    private String rnum = null;

    /* Column Info */
    private String cntCd = null;

    /* Column Info */
    private String amsPckTpCd = null;

    /* Column Info */
    private String wgtUtCd = null;

    /* Column Info */
    private String cgoWgt = null;

    /* Column Info */
    private String cstmsLocCd = null;

    /* Column Info */
    private String ibdTrspNo = null;

    /* Column Info */
    private String trnkBdrFlg = null;

    /* Column Info */
    private String delCd = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String oblRdemFlg = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String vvd = null;

    /* Column Info */
    private String loclClrIpiMvmtFlg = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String fullMtyCd = null;

    /* Column Info */
    private String loclTrnsCd = null;

    /* Column Info */
    private String vpsEtaDt = null;

    /* Column Info */
    private String hblCnt = null;

    /* Column Info */
    private String mfStsCd = null;

    /* Column Info */
    private String cstmsMfTpCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String vslEngNm = null;

    /* Column Info */
    private String vpsEtaDt2 = null;

    /* Column Info */
    private String cgorTeamCd = null;

    /* Column Info */
    private String pckQty = null;

    /* Column Info */
    private String actFileVvd = null;

    /* Column Info */
    private String rcvTermCd = null;

    /* Column Info */
    private String customs = null;

    /* Column Info */
    private String freeTrdZnFlg = null;

    /* Column Info */
    private String cstmsClrCd = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Column Info */
    private String blTpCd = null;

    /* Column Info */
    private String ibdTpCd = null;

    /* Column Info */
    private String deTermCd = null;

    /* Column Info */
    private String diffRmk = null;

    /* Column Info */
    private String isfActCd = null;

    /* Column Info */
    private String mblNo = null;

    /* Column Info */
    private String hubLocCd = null;

    /* Column Info */
    private String fPod = null;

    /* Column Info */
    private String blCnt = null;

    /* Column Info */
    private String cstmsPortCd = null;

    /* Column Info */
    private String divInd = null;

    /* Column Info */
    private String pttFrmCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public UsaAiBlInfoVO() {
    }

    public UsaAiBlInfoVO(String ibflag, String pagerows, String cntCd, String blNo, String scNo, String bkgNo, String blTpCd, String cstmsFileTpCd, String bkgCustTpCd, String mfStsCd, String loclTrnsCd, String fullMtyCd, String cstmsMfTpCd, String frtCltFlg, String oblRdemFlg, String cstmsClrCd, String cgorTeamCd, String mblNo, String preMfNo, String vslCd, String skdVoyNo, String skdDirCd, String vvd, String vslEngNm, String podCd, String vpsEtaDt, String vpsEtaDt2, String polCd, String delCd, String hubLocCd, String usaLstLocCd, String cstmsLocCd, String fPod, String pckQty, String amsPckTpCd, String cgoWgt, String wgtUtCd, String ibdTrspNo, String ibdTpCd, String rcvTermCd, String deTermCd, String diffRmk, String actFileVvd, String customs, String isfActCd, String hblCnt, String blCnt, String trnkBdrFlg, String rnum, String freeTrdZnFlg, String loclClrIpiMvmtFlg, String cstmsClrTpCdChg, String ibdTrspTpCdChg, String cstmsPortCd, String divInd, String pttFrmCd) {
        this.usaLstLocCd = usaLstLocCd;
        this.vslCd = vslCd;
        this.cstmsFileTpCd = cstmsFileTpCd;
        this.bkgCustTpCd = bkgCustTpCd;
        this.cstmsClrTpCdChg = cstmsClrTpCdChg;
        this.preMfNo = preMfNo;
        this.ibdTrspTpCdChg = ibdTrspTpCdChg;
        this.blNo = blNo;
        this.scNo = scNo;
        this.pagerows = pagerows;
        this.polCd = polCd;
        this.frtCltFlg = frtCltFlg;
        this.rnum = rnum;
        this.cntCd = cntCd;
        this.amsPckTpCd = amsPckTpCd;
        this.wgtUtCd = wgtUtCd;
        this.cgoWgt = cgoWgt;
        this.cstmsLocCd = cstmsLocCd;
        this.ibdTrspNo = ibdTrspNo;
        this.trnkBdrFlg = trnkBdrFlg;
        this.delCd = delCd;
        this.skdVoyNo = skdVoyNo;
        this.oblRdemFlg = oblRdemFlg;
        this.podCd = podCd;
        this.vvd = vvd;
        this.loclClrIpiMvmtFlg = loclClrIpiMvmtFlg;
        this.bkgNo = bkgNo;
        this.fullMtyCd = fullMtyCd;
        this.loclTrnsCd = loclTrnsCd;
        this.vpsEtaDt = vpsEtaDt;
        this.hblCnt = hblCnt;
        this.mfStsCd = mfStsCd;
        this.cstmsMfTpCd = cstmsMfTpCd;
        this.ibflag = ibflag;
        this.vslEngNm = vslEngNm;
        this.vpsEtaDt2 = vpsEtaDt2;
        this.cgorTeamCd = cgorTeamCd;
        this.pckQty = pckQty;
        this.actFileVvd = actFileVvd;
        this.rcvTermCd = rcvTermCd;
        this.customs = customs;
        this.freeTrdZnFlg = freeTrdZnFlg;
        this.cstmsClrCd = cstmsClrCd;
        this.skdDirCd = skdDirCd;
        this.blTpCd = blTpCd;
        this.ibdTpCd = ibdTpCd;
        this.deTermCd = deTermCd;
        this.diffRmk = diffRmk;
        this.isfActCd = isfActCd;
        this.mblNo = mblNo;
        this.hubLocCd = hubLocCd;
        this.fPod = fPod;
        this.blCnt = blCnt;
        this.cstmsPortCd = cstmsPortCd;
        this.divInd = divInd;
        this.pttFrmCd = pttFrmCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("usa_lst_loc_cd", getUsaLstLocCd());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("cstms_file_tp_cd", getCstmsFileTpCd());
        this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
        this.hashColumns.put("cstms_clr_tp_cd_chg", getCstmsClrTpCdChg());
        this.hashColumns.put("pre_mf_no", getPreMfNo());
        this.hashColumns.put("ibd_trsp_tp_cd_chg", getIbdTrspTpCdChg());
        this.hashColumns.put("bl_no", getBlNo());
        this.hashColumns.put("sc_no", getScNo());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("frt_clt_flg", getFrtCltFlg());
        this.hashColumns.put("rnum", getRnum());
        this.hashColumns.put("cnt_cd", getCntCd());
        this.hashColumns.put("ams_pck_tp_cd", getAmsPckTpCd());
        this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
        this.hashColumns.put("cgo_wgt", getCgoWgt());
        this.hashColumns.put("cstms_loc_cd", getCstmsLocCd());
        this.hashColumns.put("ibd_trsp_no", getIbdTrspNo());
        this.hashColumns.put("trnk_bdr_flg", getTrnkBdrFlg());
        this.hashColumns.put("del_cd", getDelCd());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("obl_rdem_flg", getOblRdemFlg());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("vvd", getVvd());
        this.hashColumns.put("locl_clr_ipi_mvmt_flg", getLoclClrIpiMvmtFlg());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("full_mty_cd", getFullMtyCd());
        this.hashColumns.put("locl_trns_cd", getLoclTrnsCd());
        this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
        this.hashColumns.put("hbl_cnt", getHblCnt());
        this.hashColumns.put("mf_sts_cd", getMfStsCd());
        this.hashColumns.put("cstms_mf_tp_cd", getCstmsMfTpCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("vsl_eng_nm", getVslEngNm());
        this.hashColumns.put("vps_eta_dt2", getVpsEtaDt2());
        this.hashColumns.put("cgor_team_cd", getCgorTeamCd());
        this.hashColumns.put("pck_qty", getPckQty());
        this.hashColumns.put("act_file_vvd", getActFileVvd());
        this.hashColumns.put("rcv_term_cd", getRcvTermCd());
        this.hashColumns.put("customs", getCustoms());
        this.hashColumns.put("free_trd_zn_flg", getFreeTrdZnFlg());
        this.hashColumns.put("cstms_clr_cd", getCstmsClrCd());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("bl_tp_cd", getBlTpCd());
        this.hashColumns.put("ibd_tp_cd", getIbdTpCd());
        this.hashColumns.put("de_term_cd", getDeTermCd());
        this.hashColumns.put("diff_rmk", getDiffRmk());
        this.hashColumns.put("isf_act_cd", getIsfActCd());
        this.hashColumns.put("mbl_no", getMblNo());
        this.hashColumns.put("hub_loc_cd", getHubLocCd());
        this.hashColumns.put("f_pod", getFPod());
        this.hashColumns.put("bl_cnt", getBlCnt());
        this.hashColumns.put("cstms_port_cd", getCstmsPortCd());
        this.hashColumns.put("div_ind", getDivInd());
        this.hashColumns.put("ptt_frm_cd", getPttFrmCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("usa_lst_loc_cd", "usaLstLocCd");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("cstms_file_tp_cd", "cstmsFileTpCd");
        this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
        this.hashFields.put("cstms_clr_tp_cd_chg", "cstmsClrTpCdChg");
        this.hashFields.put("pre_mf_no", "preMfNo");
        this.hashFields.put("ibd_trsp_tp_cd_chg", "ibdTrspTpCdChg");
        this.hashFields.put("bl_no", "blNo");
        this.hashFields.put("sc_no", "scNo");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("frt_clt_flg", "frtCltFlg");
        this.hashFields.put("rnum", "rnum");
        this.hashFields.put("cnt_cd", "cntCd");
        this.hashFields.put("ams_pck_tp_cd", "amsPckTpCd");
        this.hashFields.put("wgt_ut_cd", "wgtUtCd");
        this.hashFields.put("cgo_wgt", "cgoWgt");
        this.hashFields.put("cstms_loc_cd", "cstmsLocCd");
        this.hashFields.put("ibd_trsp_no", "ibdTrspNo");
        this.hashFields.put("trnk_bdr_flg", "trnkBdrFlg");
        this.hashFields.put("del_cd", "delCd");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("obl_rdem_flg", "oblRdemFlg");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("vvd", "vvd");
        this.hashFields.put("locl_clr_ipi_mvmt_flg", "loclClrIpiMvmtFlg");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("full_mty_cd", "fullMtyCd");
        this.hashFields.put("locl_trns_cd", "loclTrnsCd");
        this.hashFields.put("vps_eta_dt", "vpsEtaDt");
        this.hashFields.put("hbl_cnt", "hblCnt");
        this.hashFields.put("mf_sts_cd", "mfStsCd");
        this.hashFields.put("cstms_mf_tp_cd", "cstmsMfTpCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("vsl_eng_nm", "vslEngNm");
        this.hashFields.put("vps_eta_dt2", "vpsEtaDt2");
        this.hashFields.put("cgor_team_cd", "cgorTeamCd");
        this.hashFields.put("pck_qty", "pckQty");
        this.hashFields.put("act_file_vvd", "actFileVvd");
        this.hashFields.put("rcv_term_cd", "rcvTermCd");
        this.hashFields.put("customs", "customs");
        this.hashFields.put("free_trd_zn_flg", "freeTrdZnFlg");
        this.hashFields.put("cstms_clr_cd", "cstmsClrCd");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("bl_tp_cd", "blTpCd");
        this.hashFields.put("ibd_tp_cd", "ibdTpCd");
        this.hashFields.put("de_term_cd", "deTermCd");
        this.hashFields.put("diff_rmk", "diffRmk");
        this.hashFields.put("isf_act_cd", "isfActCd");
        this.hashFields.put("mbl_no", "mblNo");
        this.hashFields.put("hub_loc_cd", "hubLocCd");
        this.hashFields.put("f_pod", "fPod");
        this.hashFields.put("bl_cnt", "blCnt");
        this.hashFields.put("cstms_port_cd", "cstmsPortCd");
        this.hashFields.put("div_ind", "divInd");
        this.hashFields.put("ptt_frm_cd", "pttFrmCd");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return usaLstLocCd
	 */
    public String getUsaLstLocCd() {
        return this.usaLstLocCd;
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
	 * @return cstmsFileTpCd
	 */
    public String getCstmsFileTpCd() {
        return this.cstmsFileTpCd;
    }

    /**
	 * Column Info
	 * @return bkgCustTpCd
	 */
    public String getBkgCustTpCd() {
        return this.bkgCustTpCd;
    }

    /**
	 * Column Info
	 * @return cstmsClrTpCdChg
	 */
    public String getCstmsClrTpCdChg() {
        return this.cstmsClrTpCdChg;
    }

    /**
	 * Column Info
	 * @return preMfNo
	 */
    public String getPreMfNo() {
        return this.preMfNo;
    }

    /**
	 * Column Info
	 * @return ibdTrspTpCdChg
	 */
    public String getIbdTrspTpCdChg() {
        return this.ibdTrspTpCdChg;
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
	 * @return scNo
	 */
    public String getScNo() {
        return this.scNo;
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
	 * @return polCd
	 */
    public String getPolCd() {
        return this.polCd;
    }

    /**
	 * Column Info
	 * @return frtCltFlg
	 */
    public String getFrtCltFlg() {
        return this.frtCltFlg;
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
	 * @return cntCd
	 */
    public String getCntCd() {
        return this.cntCd;
    }

    /**
	 * Column Info
	 * @return amsPckTpCd
	 */
    public String getAmsPckTpCd() {
        return this.amsPckTpCd;
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
	 * @return cgoWgt
	 */
    public String getCgoWgt() {
        return this.cgoWgt;
    }

    /**
	 * Column Info
	 * @return cstmsLocCd
	 */
    public String getCstmsLocCd() {
        return this.cstmsLocCd;
    }

    /**
	 * Column Info
	 * @return ibdTrspNo
	 */
    public String getIbdTrspNo() {
        return this.ibdTrspNo;
    }

    /**
	 * Column Info
	 * @return trnkBdrFlg
	 */
    public String getTrnkBdrFlg() {
        return this.trnkBdrFlg;
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
	 * @return oblRdemFlg
	 */
    public String getOblRdemFlg() {
        return this.oblRdemFlg;
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
	 * @return vvd
	 */
    public String getVvd() {
        return this.vvd;
    }

    /**
	 * Column Info
	 * @return loclClrIpiMvmtFlg
	 */
    public String getLoclClrIpiMvmtFlg() {
        return this.loclClrIpiMvmtFlg;
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
	 * @return fullMtyCd
	 */
    public String getFullMtyCd() {
        return this.fullMtyCd;
    }

    /**
	 * Column Info
	 * @return loclTrnsCd
	 */
    public String getLoclTrnsCd() {
        return this.loclTrnsCd;
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
	 * @return hblCnt
	 */
    public String getHblCnt() {
        return this.hblCnt;
    }

    /**
	 * Column Info
	 * @return mfStsCd
	 */
    public String getMfStsCd() {
        return this.mfStsCd;
    }

    /**
	 * Column Info
	 * @return cstmsMfTpCd
	 */
    public String getCstmsMfTpCd() {
        return this.cstmsMfTpCd;
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
	 * @return vslEngNm
	 */
    public String getVslEngNm() {
        return this.vslEngNm;
    }

    /**
	 * Column Info
	 * @return vpsEtaDt2
	 */
    public String getVpsEtaDt2() {
        return this.vpsEtaDt2;
    }

    /**
	 * Column Info
	 * @return cgorTeamCd
	 */
    public String getCgorTeamCd() {
        return this.cgorTeamCd;
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
	 * @return actFileVvd
	 */
    public String getActFileVvd() {
        return this.actFileVvd;
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
	 * @return customs
	 */
    public String getCustoms() {
        return this.customs;
    }

    /**
	 * Column Info
	 * @return freeTrdZnFlg
	 */
    public String getFreeTrdZnFlg() {
        return this.freeTrdZnFlg;
    }

    /**
	 * Column Info
	 * @return cstmsClrCd
	 */
    public String getCstmsClrCd() {
        return this.cstmsClrCd;
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
	 * @return ibdTpCd
	 */
    public String getIbdTpCd() {
        return this.ibdTpCd;
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
	 * @return diffRmk
	 */
    public String getDiffRmk() {
        return this.diffRmk;
    }

    /**
	 * Column Info
	 * @return isfActCd
	 */
    public String getIsfActCd() {
        return this.isfActCd;
    }

    /**
	 * Column Info
	 * @return mblNo
	 */
    public String getMblNo() {
        return this.mblNo;
    }

    /**
	 * Column Info
	 * @return hubLocCd
	 */
    public String getHubLocCd() {
        return this.hubLocCd;
    }

    /**
	 * Column Info
	 * @return fPod
	 */
    public String getFPod() {
        return this.fPod;
    }

    /**
	 * Column Info
	 * @return blCnt
	 */
    public String getBlCnt() {
        return this.blCnt;
    }

    /**
	 * Column Info
	 * @return cstmsPortCd
	 */
    public String getCstmsPortCd() {
        return this.cstmsPortCd;
    }

    /**
	 * Column Info
	 * @return divInd
	 */
    public String getDivInd() {
        return this.divInd;
    }

    /**
	 * Column Info
	 * @param usaLstLocCd
	 */
    public void setUsaLstLocCd(String usaLstLocCd) {
        this.usaLstLocCd = usaLstLocCd;
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
	 * @param cstmsFileTpCd
	 */
    public void setCstmsFileTpCd(String cstmsFileTpCd) {
        this.cstmsFileTpCd = cstmsFileTpCd;
    }

    /**
	 * Column Info
	 * @param bkgCustTpCd
	 */
    public void setBkgCustTpCd(String bkgCustTpCd) {
        this.bkgCustTpCd = bkgCustTpCd;
    }

    /**
	 * Column Info
	 * @param cstmsClrTpCdChg
	 */
    public void setCstmsClrTpCdChg(String cstmsClrTpCdChg) {
        this.cstmsClrTpCdChg = cstmsClrTpCdChg;
    }

    /**
	 * Column Info
	 * @param preMfNo
	 */
    public void setPreMfNo(String preMfNo) {
        this.preMfNo = preMfNo;
    }

    /**
	 * Column Info
	 * @param ibdTrspTpCdChg
	 */
    public void setIbdTrspTpCdChg(String ibdTrspTpCdChg) {
        this.ibdTrspTpCdChg = ibdTrspTpCdChg;
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
	 * @param scNo
	 */
    public void setScNo(String scNo) {
        this.scNo = scNo;
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
	 * @param polCd
	 */
    public void setPolCd(String polCd) {
        this.polCd = polCd;
    }

    /**
	 * Column Info
	 * @param frtCltFlg
	 */
    public void setFrtCltFlg(String frtCltFlg) {
        this.frtCltFlg = frtCltFlg;
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
	 * @param cntCd
	 */
    public void setCntCd(String cntCd) {
        this.cntCd = cntCd;
    }

    /**
	 * Column Info
	 * @param amsPckTpCd
	 */
    public void setAmsPckTpCd(String amsPckTpCd) {
        this.amsPckTpCd = amsPckTpCd;
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
	 * @param cgoWgt
	 */
    public void setCgoWgt(String cgoWgt) {
        this.cgoWgt = cgoWgt;
    }

    /**
	 * Column Info
	 * @param cstmsLocCd
	 */
    public void setCstmsLocCd(String cstmsLocCd) {
        this.cstmsLocCd = cstmsLocCd;
    }

    /**
	 * Column Info
	 * @param ibdTrspNo
	 */
    public void setIbdTrspNo(String ibdTrspNo) {
        this.ibdTrspNo = ibdTrspNo;
    }

    /**
	 * Column Info
	 * @param trnkBdrFlg
	 */
    public void setTrnkBdrFlg(String trnkBdrFlg) {
        this.trnkBdrFlg = trnkBdrFlg;
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
	 * @param oblRdemFlg
	 */
    public void setOblRdemFlg(String oblRdemFlg) {
        this.oblRdemFlg = oblRdemFlg;
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
	 * @param vvd
	 */
    public void setVvd(String vvd) {
        this.vvd = vvd;
    }

    /**
	 * Column Info
	 * @param loclClrIpiMvmtFlg
	 */
    public void setLoclClrIpiMvmtFlg(String loclClrIpiMvmtFlg) {
        this.loclClrIpiMvmtFlg = loclClrIpiMvmtFlg;
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
	 * @param fullMtyCd
	 */
    public void setFullMtyCd(String fullMtyCd) {
        this.fullMtyCd = fullMtyCd;
    }

    /**
	 * Column Info
	 * @param loclTrnsCd
	 */
    public void setLoclTrnsCd(String loclTrnsCd) {
        this.loclTrnsCd = loclTrnsCd;
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
	 * @param hblCnt
	 */
    public void setHblCnt(String hblCnt) {
        this.hblCnt = hblCnt;
    }

    /**
	 * Column Info
	 * @param mfStsCd
	 */
    public void setMfStsCd(String mfStsCd) {
        this.mfStsCd = mfStsCd;
    }

    /**
	 * Column Info
	 * @param cstmsMfTpCd
	 */
    public void setCstmsMfTpCd(String cstmsMfTpCd) {
        this.cstmsMfTpCd = cstmsMfTpCd;
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
	 * @param vslEngNm
	 */
    public void setVslEngNm(String vslEngNm) {
        this.vslEngNm = vslEngNm;
    }

    /**
	 * Column Info
	 * @param vpsEtaDt2
	 */
    public void setVpsEtaDt2(String vpsEtaDt2) {
        this.vpsEtaDt2 = vpsEtaDt2;
    }

    /**
	 * Column Info
	 * @param cgorTeamCd
	 */
    public void setCgorTeamCd(String cgorTeamCd) {
        this.cgorTeamCd = cgorTeamCd;
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
	 * @param actFileVvd
	 */
    public void setActFileVvd(String actFileVvd) {
        this.actFileVvd = actFileVvd;
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
	 * @param customs
	 */
    public void setCustoms(String customs) {
        this.customs = customs;
    }

    /**
	 * Column Info
	 * @param freeTrdZnFlg
	 */
    public void setFreeTrdZnFlg(String freeTrdZnFlg) {
        this.freeTrdZnFlg = freeTrdZnFlg;
    }

    /**
	 * Column Info
	 * @param cstmsClrCd
	 */
    public void setCstmsClrCd(String cstmsClrCd) {
        this.cstmsClrCd = cstmsClrCd;
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
	 * @param ibdTpCd
	 */
    public void setIbdTpCd(String ibdTpCd) {
        this.ibdTpCd = ibdTpCd;
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
	 * @param diffRmk
	 */
    public void setDiffRmk(String diffRmk) {
        this.diffRmk = diffRmk;
    }

    /**
	 * Column Info
	 * @param isfActCd
	 */
    public void setIsfActCd(String isfActCd) {
        this.isfActCd = isfActCd;
    }

    /**
	 * Column Info
	 * @param mblNo
	 */
    public void setMblNo(String mblNo) {
        this.mblNo = mblNo;
    }

    /**
	 * Column Info
	 * @param hubLocCd
	 */
    public void setHubLocCd(String hubLocCd) {
        this.hubLocCd = hubLocCd;
    }

    /**
	 * Column Info
	 * @param fPod
	 */
    public void setFPod(String fPod) {
        this.fPod = fPod;
    }

    /**
	 * Column Info
	 * @param blCnt
	 */
    public void setBlCnt(String blCnt) {
        this.blCnt = blCnt;
    }

    /**
	 * Column Info
	 * @param cstmsPortCd
	 */
    public void setCstmsPortCd(String cstmsPortCd) {
        this.cstmsPortCd = cstmsPortCd;
    }

    /**
	 * Column Info
	 * @param divInd
	 */
    public void setDivInd(String divInd) {
        this.divInd = divInd;
    }

    public void setPttFrmCd(String pttFrmCd) {
        this.pttFrmCd = pttFrmCd;
    }

    public String getPttFrmCd() {
        return this.pttFrmCd;
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
        setUsaLstLocCd(JSPUtil.getParameter(request, prefix + "usa_lst_loc_cd", ""));
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setCstmsFileTpCd(JSPUtil.getParameter(request, prefix + "cstms_file_tp_cd", ""));
        setBkgCustTpCd(JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", ""));
        setCstmsClrTpCdChg(JSPUtil.getParameter(request, prefix + "cstms_clr_tp_cd_chg", ""));
        setPreMfNo(JSPUtil.getParameter(request, prefix + "pre_mf_no", ""));
        setIbdTrspTpCdChg(JSPUtil.getParameter(request, prefix + "ibd_trsp_tp_cd_chg", ""));
        setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
        setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setFrtCltFlg(JSPUtil.getParameter(request, prefix + "frt_clt_flg", ""));
        setRnum(JSPUtil.getParameter(request, prefix + "rnum", ""));
        setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
        setAmsPckTpCd(JSPUtil.getParameter(request, prefix + "ams_pck_tp_cd", ""));
        setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
        setCgoWgt(JSPUtil.getParameter(request, prefix + "cgo_wgt", ""));
        setCstmsLocCd(JSPUtil.getParameter(request, prefix + "cstms_loc_cd", ""));
        setIbdTrspNo(JSPUtil.getParameter(request, prefix + "ibd_trsp_no", ""));
        setTrnkBdrFlg(JSPUtil.getParameter(request, prefix + "trnk_bdr_flg", ""));
        setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setOblRdemFlg(JSPUtil.getParameter(request, prefix + "obl_rdem_flg", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
        setLoclClrIpiMvmtFlg(JSPUtil.getParameter(request, prefix + "locl_clr_ipi_mvmt_flg", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setFullMtyCd(JSPUtil.getParameter(request, prefix + "full_mty_cd", ""));
        setLoclTrnsCd(JSPUtil.getParameter(request, prefix + "locl_trns_cd", ""));
        setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
        setHblCnt(JSPUtil.getParameter(request, prefix + "hbl_cnt", ""));
        setMfStsCd(JSPUtil.getParameter(request, prefix + "mf_sts_cd", ""));
        setCstmsMfTpCd(JSPUtil.getParameter(request, prefix + "cstms_mf_tp_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
        setVpsEtaDt2(JSPUtil.getParameter(request, prefix + "vps_eta_dt2", ""));
        setCgorTeamCd(JSPUtil.getParameter(request, prefix + "cgor_team_cd", ""));
        setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
        setActFileVvd(JSPUtil.getParameter(request, prefix + "act_file_vvd", ""));
        setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
        setCustoms(JSPUtil.getParameter(request, prefix + "customs", ""));
        setFreeTrdZnFlg(JSPUtil.getParameter(request, prefix + "free_trd_zn_flg", ""));
        setCstmsClrCd(JSPUtil.getParameter(request, prefix + "cstms_clr_cd", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setBlTpCd(JSPUtil.getParameter(request, prefix + "bl_tp_cd", ""));
        setIbdTpCd(JSPUtil.getParameter(request, prefix + "ibd_tp_cd", ""));
        setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
        setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
        setIsfActCd(JSPUtil.getParameter(request, prefix + "isf_act_cd", ""));
        setMblNo(JSPUtil.getParameter(request, prefix + "mbl_no", ""));
        setHubLocCd(JSPUtil.getParameter(request, prefix + "hub_loc_cd", ""));
        setFPod(JSPUtil.getParameter(request, prefix + "f_pod", ""));
        setBlCnt(JSPUtil.getParameter(request, prefix + "bl_cnt", ""));
        setCstmsPortCd(JSPUtil.getParameter(request, prefix + "cstms_port_cd", ""));
        setDivInd(JSPUtil.getParameter(request, prefix + "div_ind", ""));
        setPttFrmCd(JSPUtil.getParameter(request, prefix + "ptt_frm_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaAiBlInfoVO[]
	 */
    public UsaAiBlInfoVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaAiBlInfoVO[]
	 */
    public UsaAiBlInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        UsaAiBlInfoVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] usaLstLocCd = (JSPUtil.getParameter(request, prefix + "usa_lst_loc_cd", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] cstmsFileTpCd = (JSPUtil.getParameter(request, prefix + "cstms_file_tp_cd", length));
            String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", length));
            String[] cstmsClrTpCdChg = (JSPUtil.getParameter(request, prefix + "cstms_clr_tp_cd_chg", length));
            String[] preMfNo = (JSPUtil.getParameter(request, prefix + "pre_mf_no", length));
            String[] ibdTrspTpCdChg = (JSPUtil.getParameter(request, prefix + "ibd_trsp_tp_cd_chg", length));
            String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
            String[] scNo = (JSPUtil.getParameter(request, prefix + "sc_no", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] frtCltFlg = (JSPUtil.getParameter(request, prefix + "frt_clt_flg", length));
            String[] rnum = (JSPUtil.getParameter(request, prefix + "rnum", length));
            String[] cntCd = (JSPUtil.getParameter(request, prefix + "cnt_cd", length));
            String[] amsPckTpCd = (JSPUtil.getParameter(request, prefix + "ams_pck_tp_cd", length));
            String[] wgtUtCd = (JSPUtil.getParameter(request, prefix + "wgt_ut_cd", length));
            String[] cgoWgt = (JSPUtil.getParameter(request, prefix + "cgo_wgt", length));
            String[] cstmsLocCd = (JSPUtil.getParameter(request, prefix + "cstms_loc_cd", length));
            String[] ibdTrspNo = (JSPUtil.getParameter(request, prefix + "ibd_trsp_no", length));
            String[] trnkBdrFlg = (JSPUtil.getParameter(request, prefix + "trnk_bdr_flg", length));
            String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] oblRdemFlg = (JSPUtil.getParameter(request, prefix + "obl_rdem_flg", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] vvd = (JSPUtil.getParameter(request, prefix + "vvd", length));
            String[] loclClrIpiMvmtFlg = (JSPUtil.getParameter(request, prefix + "locl_clr_ipi_mvmt_flg", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] fullMtyCd = (JSPUtil.getParameter(request, prefix + "full_mty_cd", length));
            String[] loclTrnsCd = (JSPUtil.getParameter(request, prefix + "locl_trns_cd", length));
            String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix + "vps_eta_dt", length));
            String[] hblCnt = (JSPUtil.getParameter(request, prefix + "hbl_cnt", length));
            String[] mfStsCd = (JSPUtil.getParameter(request, prefix + "mf_sts_cd", length));
            String[] cstmsMfTpCd = (JSPUtil.getParameter(request, prefix + "cstms_mf_tp_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] vslEngNm = (JSPUtil.getParameter(request, prefix + "vsl_eng_nm", length));
            String[] vpsEtaDt2 = (JSPUtil.getParameter(request, prefix + "vps_eta_dt2", length));
            String[] cgorTeamCd = (JSPUtil.getParameter(request, prefix + "cgor_team_cd", length));
            String[] pckQty = (JSPUtil.getParameter(request, prefix + "pck_qty", length));
            String[] actFileVvd = (JSPUtil.getParameter(request, prefix + "act_file_vvd", length));
            String[] rcvTermCd = (JSPUtil.getParameter(request, prefix + "rcv_term_cd", length));
            String[] customs = (JSPUtil.getParameter(request, prefix + "customs", length));
            String[] freeTrdZnFlg = (JSPUtil.getParameter(request, prefix + "free_trd_zn_flg", length));
            String[] cstmsClrCd = (JSPUtil.getParameter(request, prefix + "cstms_clr_cd", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] blTpCd = (JSPUtil.getParameter(request, prefix + "bl_tp_cd", length));
            String[] ibdTpCd = (JSPUtil.getParameter(request, prefix + "ibd_tp_cd", length));
            String[] deTermCd = (JSPUtil.getParameter(request, prefix + "de_term_cd", length));
            String[] diffRmk = (JSPUtil.getParameter(request, prefix + "diff_rmk", length));
            String[] isfActCd = (JSPUtil.getParameter(request, prefix + "isf_act_cd", length));
            String[] mblNo = (JSPUtil.getParameter(request, prefix + "mbl_no", length));
            String[] hubLocCd = (JSPUtil.getParameter(request, prefix + "hub_loc_cd", length));
            String[] fPod = (JSPUtil.getParameter(request, prefix + "f_pod", length));
            String[] blCnt = (JSPUtil.getParameter(request, prefix + "bl_cnt", length));
            String[] cstmsPortCd = (JSPUtil.getParameter(request, prefix + "cstms_port_cd", length));
            String[] divInd = (JSPUtil.getParameter(request, prefix + "div_ind", length));
            String[] pttFrmCd = (JSPUtil.getParameter(request, prefix + "ptt_frm_cd", length));
            
            for (int i = 0; i < length; i++) {
                model = new UsaAiBlInfoVO();
                if (usaLstLocCd[i] != null)
                    model.setUsaLstLocCd(usaLstLocCd[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (cstmsFileTpCd[i] != null)
                    model.setCstmsFileTpCd(cstmsFileTpCd[i]);
                if (bkgCustTpCd[i] != null)
                    model.setBkgCustTpCd(bkgCustTpCd[i]);
                if (cstmsClrTpCdChg[i] != null)
                    model.setCstmsClrTpCdChg(cstmsClrTpCdChg[i]);
                if (preMfNo[i] != null)
                    model.setPreMfNo(preMfNo[i]);
                if (ibdTrspTpCdChg[i] != null)
                    model.setIbdTrspTpCdChg(ibdTrspTpCdChg[i]);
                if (blNo[i] != null)
                    model.setBlNo(blNo[i]);
                if (scNo[i] != null)
                    model.setScNo(scNo[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (frtCltFlg[i] != null)
                    model.setFrtCltFlg(frtCltFlg[i]);
                if (rnum[i] != null)
                    model.setRnum(rnum[i]);
                if (cntCd[i] != null)
                    model.setCntCd(cntCd[i]);
                if (amsPckTpCd[i] != null)
                    model.setAmsPckTpCd(amsPckTpCd[i]);
                if (wgtUtCd[i] != null)
                    model.setWgtUtCd(wgtUtCd[i]);
                if (cgoWgt[i] != null)
                    model.setCgoWgt(cgoWgt[i]);
                if (cstmsLocCd[i] != null)
                    model.setCstmsLocCd(cstmsLocCd[i]);
                if (ibdTrspNo[i] != null)
                    model.setIbdTrspNo(ibdTrspNo[i]);
                if (trnkBdrFlg[i] != null)
                    model.setTrnkBdrFlg(trnkBdrFlg[i]);
                if (delCd[i] != null)
                    model.setDelCd(delCd[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (oblRdemFlg[i] != null)
                    model.setOblRdemFlg(oblRdemFlg[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (vvd[i] != null)
                    model.setVvd(vvd[i]);
                if (loclClrIpiMvmtFlg[i] != null)
                    model.setLoclClrIpiMvmtFlg(loclClrIpiMvmtFlg[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (fullMtyCd[i] != null)
                    model.setFullMtyCd(fullMtyCd[i]);
                if (loclTrnsCd[i] != null)
                    model.setLoclTrnsCd(loclTrnsCd[i]);
                if (vpsEtaDt[i] != null)
                    model.setVpsEtaDt(vpsEtaDt[i]);
                if (hblCnt[i] != null)
                    model.setHblCnt(hblCnt[i]);
                if (mfStsCd[i] != null)
                    model.setMfStsCd(mfStsCd[i]);
                if (cstmsMfTpCd[i] != null)
                    model.setCstmsMfTpCd(cstmsMfTpCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (vslEngNm[i] != null)
                    model.setVslEngNm(vslEngNm[i]);
                if (vpsEtaDt2[i] != null)
                    model.setVpsEtaDt2(vpsEtaDt2[i]);
                if (cgorTeamCd[i] != null)
                    model.setCgorTeamCd(cgorTeamCd[i]);
                if (pckQty[i] != null)
                    model.setPckQty(pckQty[i]);
                if (actFileVvd[i] != null)
                    model.setActFileVvd(actFileVvd[i]);
                if (rcvTermCd[i] != null)
                    model.setRcvTermCd(rcvTermCd[i]);
                if (customs[i] != null)
                    model.setCustoms(customs[i]);
                if (freeTrdZnFlg[i] != null)
                    model.setFreeTrdZnFlg(freeTrdZnFlg[i]);
                if (cstmsClrCd[i] != null)
                    model.setCstmsClrCd(cstmsClrCd[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (blTpCd[i] != null)
                    model.setBlTpCd(blTpCd[i]);
                if (ibdTpCd[i] != null)
                    model.setIbdTpCd(ibdTpCd[i]);
                if (deTermCd[i] != null)
                    model.setDeTermCd(deTermCd[i]);
                if (diffRmk[i] != null)
                    model.setDiffRmk(diffRmk[i]);
                if (isfActCd[i] != null)
                    model.setIsfActCd(isfActCd[i]);
                if (mblNo[i] != null)
                    model.setMblNo(mblNo[i]);
                if (hubLocCd[i] != null)
                    model.setHubLocCd(hubLocCd[i]);
                if (fPod[i] != null)
                    model.setFPod(fPod[i]);
                if (blCnt[i] != null)
                    model.setBlCnt(blCnt[i]);
                if (cstmsPortCd[i] != null)
                    model.setCstmsPortCd(cstmsPortCd[i]);
                if (divInd[i] != null)
                    model.setDivInd(divInd[i]);
                if (pttFrmCd[i] != null)
                    model.setPttFrmCd(pttFrmCd[i]);
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getUsaAiBlInfoVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return UsaAiBlInfoVO[]
	 */
    public UsaAiBlInfoVO[] getUsaAiBlInfoVOs() {
        UsaAiBlInfoVO[] vos = (UsaAiBlInfoVO[]) models.toArray(new UsaAiBlInfoVO[models.size()]);
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
        this.usaLstLocCd = this.usaLstLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cstmsFileTpCd = this.cstmsFileTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCustTpCd = this.bkgCustTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cstmsClrTpCdChg = this.cstmsClrTpCdChg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.preMfNo = this.preMfNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibdTrspTpCdChg = this.ibdTrspTpCdChg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scNo = this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frtCltFlg = this.frtCltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rnum = this.rnum.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntCd = this.cntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.amsPckTpCd = this.amsPckTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.wgtUtCd = this.wgtUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cgoWgt = this.cgoWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cstmsLocCd = this.cstmsLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibdTrspNo = this.ibdTrspNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trnkBdrFlg = this.trnkBdrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oblRdemFlg = this.oblRdemFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvd = this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.loclClrIpiMvmtFlg = this.loclClrIpiMvmtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fullMtyCd = this.fullMtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.loclTrnsCd = this.loclTrnsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsEtaDt = this.vpsEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hblCnt = this.hblCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mfStsCd = this.mfStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cstmsMfTpCd = this.cstmsMfTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslEngNm = this.vslEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsEtaDt2 = this.vpsEtaDt2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cgorTeamCd = this.cgorTeamCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckQty = this.pckQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actFileVvd = this.actFileVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvTermCd = this.rcvTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.customs = this.customs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.freeTrdZnFlg = this.freeTrdZnFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cstmsClrCd = this.cstmsClrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blTpCd = this.blTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibdTpCd = this.ibdTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deTermCd = this.deTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diffRmk = this.diffRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.isfActCd = this.isfActCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mblNo = this.mblNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hubLocCd = this.hubLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fPod = this.fPod.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blCnt = this.blCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cstmsPortCd = this.blCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.divInd = this.divInd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pttFrmCd = this.pttFrmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
