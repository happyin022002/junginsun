/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CndVesselArrivalTransmitVO.java
*@FileTitle : CndVesselArrivalTransmitVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.25
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.03.25 김민정 
* 1.0 Creation
* -------------------------------------------------------
* History
* 2013.06.10 김보배 [CHM-201324023] ACI - Vessel Arrival Transmit (A6) 화면 및 로직 보완
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.VesselArrivalTransmitVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class CndVesselArrivalTransmitVO extends VesselArrivalTransmitVO {

    private static final long serialVersionUID = 1L;

    private Collection<CndVesselArrivalTransmitVO> models = new ArrayList<CndVesselArrivalTransmitVO>();

    /* Column Info */
    private String dtDiffChk = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String dtNullChk = null;

    /* Column Info */
    private String etaDt = null;

    /* Column Info */
    private String loaLen = null;

    /* Column Info */
    private String dwtWgt = null;

    /* Column Info */
    private String crwKnt = null;

    /* Column Info */
    private String blNo = null;

    /* Column Info */
    private String vpsEtaDt = null;

    /* Column Info */
    private String vslSftEqCertiExpDt = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String vpsPortCd = null;

    /* Column Info */
    private String polCd = null;

    /* Column Info */
    private String vslSftCstruCertiExpDt = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String vslRgstCntCd = null;

    /* Column Info */
    private String vslEngNm = null;

    /* Column Info */
    private String vslLodLineCertiExpDt = null;

    /* Column Info */
    private String othFul = null;

    /* Column Info */
    private String feuMty = null;

    /* Column Info */
    private String vslSftRdoCertiExpDt = null;

    /* Column Info */
    private String rgstDt = null;

    /* Column Info */
    private String capNm = null;

    /* Column Info */
    private String feuFul = null;

    /* Column Info */
    private String cgoWgt = null;

    /* Column Info */
    private String vslArrRptSndDt = null;

    /* Column Info */
    private String netRgstTongWgt = null;

    /* Column Info */
    private String rgstPortCd = null;

    /* Column Info */
    private String vpsEtdDt = null;

    /* Column Info */
    private String teuFul = null;

    /* Column Info */
    private String cndAckSubCd = null;

    /* Column Info */
    private String status = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String grsRgstTongWgt = null;

    /* Column Info */
    private String cvyRefNo = null;

    /* Column Info */
    private String westCvyRefNo = null;

    /* Column Info */
    private String teuMty = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Column Info */
    private String cndAckCtrlNo = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String vslDeratCertiExpDt = null;

    /* Column Info */
    private String othMty = null;

    /* Column Info */
    private String lloydNo = null;

    /* Column Info */
    private String rgstNo = null;

    /* Column Info */
    private String delFlag = null;

    /* Column Info */
    private String cndAckRspnCd = null;

    /* Column Info */
    private String actArrDt = null;

    /* Column Info */
    private String podNm = null;

    /* Column Info */
    private String pasgCnt = null;

    /* Column Info */
    private String ccTrans = null;

    /* Column Info */
    private String actDepDt = null;

    /* Column Info */
    private String etdDt = null;

    /* Column Info */
    private String polNm = null;

    /* Column Info */
    private String vslDepRptSndDt = null;

    /* Column Info */
    private String cstmsTrsmStsCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public CndVesselArrivalTransmitVO() {
    }

    public CndVesselArrivalTransmitVO(String ibflag, String pagerows, String vslSftCstruCertiExpDt, String vslSftRdoCertiExpDt, String vslSftEqCertiExpDt, String vslLodLineCertiExpDt, String vslDeratCertiExpDt, String lloydNo, String vslEngNm, String vslRgstCntCd, String rgstPortCd, String rgstNo, String netRgstTongWgt, String grsRgstTongWgt, String dwtWgt, String loaLen, String crwKnt, String rgstDt, String cndAckCtrlNo, String cvyRefNo, String westCvyRefNo, String capNm, String etaDt, String dtNullChk, String dtDiffChk, String vpsEtdDt, String cndAckSubCd, String cndAckRspnCd, String vslArrRptSndDt, String status, String polCd, String podCd, String vpsEtaDt, String vslCd, String skdVoyNo, String skdDirCd, String cgoWgt, String teuFul, String feuFul, String othFul, String teuMty, String feuMty, String othMty, String vpsPortCd, String delFlag, String blNo, String actArrDt, String podNm, String pasgCnt, String ccTrans, String actDepDt, String etdDt, String polNm, String vslDepRptSndDt, String cstmsTrsmStsCd) {
        this.dtDiffChk = dtDiffChk;
        this.vslCd = vslCd;
        this.dtNullChk = dtNullChk;
        this.etaDt = etaDt;
        this.loaLen = loaLen;
        this.dwtWgt = dwtWgt;
        this.crwKnt = crwKnt;
        this.blNo = blNo;
        this.vpsEtaDt = vpsEtaDt;
        this.vslSftEqCertiExpDt = vslSftEqCertiExpDt;
        this.pagerows = pagerows;
        this.vpsPortCd = vpsPortCd;
        this.polCd = polCd;
        this.vslSftCstruCertiExpDt = vslSftCstruCertiExpDt;
        this.ibflag = ibflag;
        this.vslRgstCntCd = vslRgstCntCd;
        this.vslEngNm = vslEngNm;
        this.vslLodLineCertiExpDt = vslLodLineCertiExpDt;
        this.othFul = othFul;
        this.feuMty = feuMty;
        this.vslSftRdoCertiExpDt = vslSftRdoCertiExpDt;
        this.rgstDt = rgstDt;
        this.capNm = capNm;
        this.feuFul = feuFul;
        this.cgoWgt = cgoWgt;
        this.vslArrRptSndDt = vslArrRptSndDt;
        this.netRgstTongWgt = netRgstTongWgt;
        this.rgstPortCd = rgstPortCd;
        this.vpsEtdDt = vpsEtdDt;
        this.teuFul = teuFul;
        this.cndAckSubCd = cndAckSubCd;
        this.status = status;
        this.skdVoyNo = skdVoyNo;
        this.grsRgstTongWgt = grsRgstTongWgt;
        this.cvyRefNo = cvyRefNo;
        this.westCvyRefNo = westCvyRefNo;
        this.teuMty = teuMty;
        this.skdDirCd = skdDirCd;
        this.cndAckCtrlNo = cndAckCtrlNo;
        this.podCd = podCd;
        this.vslDeratCertiExpDt = vslDeratCertiExpDt;
        this.othMty = othMty;
        this.lloydNo = lloydNo;
        this.rgstNo = rgstNo;
        this.delFlag = delFlag;
        this.cndAckRspnCd = cndAckRspnCd;
        this.actArrDt = actArrDt;
        this.podNm = podNm;
        this.pasgCnt = pasgCnt;
        this.ccTrans = ccTrans;
        this.actDepDt = actDepDt;
        this.etdDt = etdDt;
        this.polNm = polNm;
        this.vslDepRptSndDt = vslDepRptSndDt;
        this.cstmsTrsmStsCd = cstmsTrsmStsCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("dt_diff_chk", getDtDiffChk());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("dt_null_chk", getDtNullChk());
        this.hashColumns.put("eta_dt", getEtaDt());
        this.hashColumns.put("loa_len", getLoaLen());
        this.hashColumns.put("dwt_wgt", getDwtWgt());
        this.hashColumns.put("crw_knt", getCrwKnt());
        this.hashColumns.put("bl_no", getBlNo());
        this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
        this.hashColumns.put("vsl_sft_eq_certi_exp_dt", getVslSftEqCertiExpDt());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("vps_port_cd", getVpsPortCd());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("vsl_sft_cstru_certi_exp_dt", getVslSftCstruCertiExpDt());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("vsl_rgst_cnt_cd", getVslRgstCntCd());
        this.hashColumns.put("vsl_eng_nm", getVslEngNm());
        this.hashColumns.put("vsl_lod_line_certi_exp_dt", getVslLodLineCertiExpDt());
        this.hashColumns.put("oth_ful", getOthFul());
        this.hashColumns.put("feu_mty", getFeuMty());
        this.hashColumns.put("vsl_sft_rdo_certi_exp_dt", getVslSftRdoCertiExpDt());
        this.hashColumns.put("rgst_dt", getRgstDt());
        this.hashColumns.put("cap_nm", getCapNm());
        this.hashColumns.put("feu_ful", getFeuFul());
        this.hashColumns.put("cgo_wgt", getCgoWgt());
        this.hashColumns.put("vsl_arr_rpt_snd_dt", getVslArrRptSndDt());
        this.hashColumns.put("net_rgst_tong_wgt", getNetRgstTongWgt());
        this.hashColumns.put("rgst_port_cd", getRgstPortCd());
        this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
        this.hashColumns.put("teu_ful", getTeuFul());
        this.hashColumns.put("cnd_ack_sub_cd", getCndAckSubCd());
        this.hashColumns.put("status", getStatus());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("grs_rgst_tong_wgt", getGrsRgstTongWgt());
        this.hashColumns.put("cvy_ref_no", getCvyRefNo());
        this.hashColumns.put("west_cvy_ref_no", getWestCvyRefNo());
        this.hashColumns.put("teu_mty", getTeuMty());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("cnd_ack_ctrl_no", getCndAckCtrlNo());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("vsl_derat_certi_exp_dt", getVslDeratCertiExpDt());
        this.hashColumns.put("oth_mty", getOthMty());
        this.hashColumns.put("lloyd_no", getLloydNo());
        this.hashColumns.put("rgst_no", getRgstNo());
        this.hashColumns.put("del_flag", getDelFlag());
        this.hashColumns.put("cnd_ack_rspn_cd", getCndAckRspnCd());
        this.hashColumns.put("act_arr_dt", getActArrDt());
        this.hashColumns.put("pod_nm", getPodNm());
        this.hashColumns.put("pasg_cnt", getPasgCnt());
        this.hashColumns.put("cc_trans", getCcTrans());
        this.hashColumns.put("act_dep_dt", getActDepDt());
        this.hashColumns.put("etd_dt", getEtdDt());
        this.hashColumns.put("pol_nm", getPolNm());
        this.hashColumns.put("vsl_dep_rpt_snd_dt", getVslDepRptSndDt());
        this.hashColumns.put("cstms_trsm_sts_cd", getCstmsTrsmStsCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("dt_diff_chk", "dtDiffChk");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("dt_null_chk", "dtNullChk");
        this.hashFields.put("eta_dt", "etaDt");
        this.hashFields.put("loa_len", "loaLen");
        this.hashFields.put("dwt_wgt", "dwtWgt");
        this.hashFields.put("crw_knt", "crwKnt");
        this.hashFields.put("bl_no", "blNo");
        this.hashFields.put("vps_eta_dt", "vpsEtaDt");
        this.hashFields.put("vsl_sft_eq_certi_exp_dt", "vslSftEqCertiExpDt");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("vps_port_cd", "vpsPortCd");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("vsl_sft_cstru_certi_exp_dt", "vslSftCstruCertiExpDt");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("vsl_rgst_cnt_cd", "vslRgstCntCd");
        this.hashFields.put("vsl_eng_nm", "vslEngNm");
        this.hashFields.put("vsl_lod_line_certi_exp_dt", "vslLodLineCertiExpDt");
        this.hashFields.put("oth_ful", "othFul");
        this.hashFields.put("feu_mty", "feuMty");
        this.hashFields.put("vsl_sft_rdo_certi_exp_dt", "vslSftRdoCertiExpDt");
        this.hashFields.put("rgst_dt", "rgstDt");
        this.hashFields.put("cap_nm", "capNm");
        this.hashFields.put("feu_ful", "feuFul");
        this.hashFields.put("cgo_wgt", "cgoWgt");
        this.hashFields.put("vsl_arr_rpt_snd_dt", "vslArrRptSndDt");
        this.hashFields.put("net_rgst_tong_wgt", "netRgstTongWgt");
        this.hashFields.put("rgst_port_cd", "rgstPortCd");
        this.hashFields.put("vps_etd_dt", "vpsEtdDt");
        this.hashFields.put("teu_ful", "teuFul");
        this.hashFields.put("cnd_ack_sub_cd", "cndAckSubCd");
        this.hashFields.put("status", "status");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("grs_rgst_tong_wgt", "grsRgstTongWgt");
        this.hashFields.put("cvy_ref_no", "cvyRefNo");
        this.hashFields.put("west_cvy_ref_no", "westCvyRefNo");
        this.hashFields.put("teu_mty", "teuMty");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("cnd_ack_ctrl_no", "cndAckCtrlNo");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("vsl_derat_certi_exp_dt", "vslDeratCertiExpDt");
        this.hashFields.put("oth_mty", "othMty");
        this.hashFields.put("lloyd_no", "lloydNo");
        this.hashFields.put("rgst_no", "rgstNo");
        this.hashFields.put("del_flag", "delFlag");
        this.hashFields.put("cnd_ack_rspn_cd", "cndAckRspnCd");
        this.hashFields.put("act_arr_dt", "actArrDt");
        this.hashFields.put("pod_nm", "podNm");
        this.hashFields.put("pasg_cnt", "pasgCnt");
        this.hashFields.put("cc_trans", "ccTrans");
        this.hashFields.put("act_dep_dt", "actDepDt");
        this.hashFields.put("etd_dt", "etdDt");
        this.hashFields.put("pol_nm", "polNm");
        this.hashFields.put("vsl_dep_rpt_snd_dt", "vslDepRptSndDt");
        this.hashFields.put("cstms_trsm_sts_cd", "cstmsTrsmStsCd");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return dtDiffChk
	 */
    public String getDtDiffChk() {
        return this.dtDiffChk;
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
	 * @return dtNullChk
	 */
    public String getDtNullChk() {
        return this.dtNullChk;
    }

    /**
	 * Column Info
	 * @return etaDt
	 */
    public String getEtaDt() {
        return this.etaDt;
    }

    /**
	 * Column Info
	 * @return loaLen
	 */
    public String getLoaLen() {
        return this.loaLen;
    }

    /**
	 * Column Info
	 * @return dwtWgt
	 */
    public String getDwtWgt() {
        return this.dwtWgt;
    }

    /**
	 * Column Info
	 * @return crwKnt
	 */
    public String getCrwKnt() {
        return this.crwKnt;
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
	 * @return vpsEtaDt
	 */
    public String getVpsEtaDt() {
        return this.vpsEtaDt;
    }

    /**
	 * Column Info
	 * @return vslSftEqCertiExpDt
	 */
    public String getVslSftEqCertiExpDt() {
        return this.vslSftEqCertiExpDt;
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
	 * @return vpsPortCd
	 */
    public String getVpsPortCd() {
        return this.vpsPortCd;
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
	 * @return vslSftCstruCertiExpDt
	 */
    public String getVslSftCstruCertiExpDt() {
        return this.vslSftCstruCertiExpDt;
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
	 * @return vslRgstCntCd
	 */
    public String getVslRgstCntCd() {
        return this.vslRgstCntCd;
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
	 * @return vslLodLineCertiExpDt
	 */
    public String getVslLodLineCertiExpDt() {
        return this.vslLodLineCertiExpDt;
    }

    /**
	 * Column Info
	 * @return othFul
	 */
    public String getOthFul() {
        return this.othFul;
    }

    /**
	 * Column Info
	 * @return feuMty
	 */
    public String getFeuMty() {
        return this.feuMty;
    }

    /**
	 * Column Info
	 * @return vslSftRdoCertiExpDt
	 */
    public String getVslSftRdoCertiExpDt() {
        return this.vslSftRdoCertiExpDt;
    }

    /**
	 * Column Info
	 * @return rgstDt
	 */
    public String getRgstDt() {
        return this.rgstDt;
    }

    /**
	 * Column Info
	 * @return capNm
	 */
    public String getCapNm() {
        return this.capNm;
    }

    /**
	 * Column Info
	 * @return feuFul
	 */
    public String getFeuFul() {
        return this.feuFul;
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
	 * @return vslArrRptSndDt
	 */
    public String getVslArrRptSndDt() {
        return this.vslArrRptSndDt;
    }

    /**
	 * Column Info
	 * @return netRgstTongWgt
	 */
    public String getNetRgstTongWgt() {
        return this.netRgstTongWgt;
    }

    /**
	 * Column Info
	 * @return rgstPortCd
	 */
    public String getRgstPortCd() {
        return this.rgstPortCd;
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
	 * @return teuFul
	 */
    public String getTeuFul() {
        return this.teuFul;
    }

    /**
	 * Column Info
	 * @return cndAckSubCd
	 */
    public String getCndAckSubCd() {
        return this.cndAckSubCd;
    }

    /**
	 * Column Info
	 * @return status
	 */
    public String getStatus() {
        return this.status;
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
	 * @return grsRgstTongWgt
	 */
    public String getGrsRgstTongWgt() {
        return this.grsRgstTongWgt;
    }

    /**
	 * Column Info
	 * @return cvyRefNo
	 */
    public String getCvyRefNo() {
        return this.cvyRefNo;
    }

    /**
	 * Column Info
	 * @return westCvyRefNo
	 */
    public String getWestCvyRefNo() {
        return this.westCvyRefNo;
    }

    /**
	 * Column Info
	 * @return teuMty
	 */
    public String getTeuMty() {
        return this.teuMty;
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
	 * @return cndAckCtrlNo
	 */
    public String getCndAckCtrlNo() {
        return this.cndAckCtrlNo;
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
	 * @return vslDeratCertiExpDt
	 */
    public String getVslDeratCertiExpDt() {
        return this.vslDeratCertiExpDt;
    }

    /**
	 * Column Info
	 * @return othMty
	 */
    public String getOthMty() {
        return this.othMty;
    }

    /**
	 * Column Info
	 * @return lloydNo
	 */
    public String getLloydNo() {
        return this.lloydNo;
    }

    /**
	 * Column Info
	 * @return rgstNo
	 */
    public String getRgstNo() {
        return this.rgstNo;
    }

    /**
	 * Column Info
	 * @return delFlag
	 */
    public String getDelFlag() {
        return this.delFlag;
    }

    /**
	 * Column Info
	 * @return cndAckRspnCd
	 */
    public String getCndAckRspnCd() {
        return this.cndAckRspnCd;
    }

    /**
	 * Column Info
	 * @return actArrDt
	 */
    public String getActArrDt() {
        return this.actArrDt;
    }

    /**
	 * Column Info
	 * @return podNm
	 */
    public String getPodNm() {
        return this.podNm;
    }

    /**
	 * Column Info
	 * @return pasgCnt
	 */
    public String getPasgCnt() {
        return this.pasgCnt;
    }

    /**
	 * Column Info
	 * @param dtDiffChk
	 */
    public void setDtDiffChk(String dtDiffChk) {
        this.dtDiffChk = dtDiffChk;
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
	 * @param dtNullChk
	 */
    public void setDtNullChk(String dtNullChk) {
        this.dtNullChk = dtNullChk;
    }

    /**
	 * Column Info
	 * @param etaDt
	 */
    public void setEtaDt(String etaDt) {
        this.etaDt = etaDt;
    }

    /**
	 * Column Info
	 * @param loaLen
	 */
    public void setLoaLen(String loaLen) {
        this.loaLen = loaLen;
    }

    /**
	 * Column Info
	 * @param dwtWgt
	 */
    public void setDwtWgt(String dwtWgt) {
        this.dwtWgt = dwtWgt;
    }

    /**
	 * Column Info
	 * @param crwKnt
	 */
    public void setCrwKnt(String crwKnt) {
        this.crwKnt = crwKnt;
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
	 * @param vpsEtaDt
	 */
    public void setVpsEtaDt(String vpsEtaDt) {
        this.vpsEtaDt = vpsEtaDt;
    }

    /**
	 * Column Info
	 * @param vslSftEqCertiExpDt
	 */
    public void setVslSftEqCertiExpDt(String vslSftEqCertiExpDt) {
        this.vslSftEqCertiExpDt = vslSftEqCertiExpDt;
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
	 * @param vpsPortCd
	 */
    public void setVpsPortCd(String vpsPortCd) {
        this.vpsPortCd = vpsPortCd;
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
	 * @param vslSftCstruCertiExpDt
	 */
    public void setVslSftCstruCertiExpDt(String vslSftCstruCertiExpDt) {
        this.vslSftCstruCertiExpDt = vslSftCstruCertiExpDt;
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
	 * @param vslRgstCntCd
	 */
    public void setVslRgstCntCd(String vslRgstCntCd) {
        this.vslRgstCntCd = vslRgstCntCd;
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
	 * @param vslLodLineCertiExpDt
	 */
    public void setVslLodLineCertiExpDt(String vslLodLineCertiExpDt) {
        this.vslLodLineCertiExpDt = vslLodLineCertiExpDt;
    }

    /**
	 * Column Info
	 * @param othFul
	 */
    public void setOthFul(String othFul) {
        this.othFul = othFul;
    }

    /**
	 * Column Info
	 * @param feuMty
	 */
    public void setFeuMty(String feuMty) {
        this.feuMty = feuMty;
    }

    /**
	 * Column Info
	 * @param vslSftRdoCertiExpDt
	 */
    public void setVslSftRdoCertiExpDt(String vslSftRdoCertiExpDt) {
        this.vslSftRdoCertiExpDt = vslSftRdoCertiExpDt;
    }

    /**
	 * Column Info
	 * @param rgstDt
	 */
    public void setRgstDt(String rgstDt) {
        this.rgstDt = rgstDt;
    }

    /**
	 * Column Info
	 * @param capNm
	 */
    public void setCapNm(String capNm) {
        this.capNm = capNm;
    }

    /**
	 * Column Info
	 * @param feuFul
	 */
    public void setFeuFul(String feuFul) {
        this.feuFul = feuFul;
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
	 * @param vslArrRptSndDt
	 */
    public void setVslArrRptSndDt(String vslArrRptSndDt) {
        this.vslArrRptSndDt = vslArrRptSndDt;
    }

    /**
	 * Column Info
	 * @param netRgstTongWgt
	 */
    public void setNetRgstTongWgt(String netRgstTongWgt) {
        this.netRgstTongWgt = netRgstTongWgt;
    }

    /**
	 * Column Info
	 * @param rgstPortCd
	 */
    public void setRgstPortCd(String rgstPortCd) {
        this.rgstPortCd = rgstPortCd;
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
	 * @param teuFul
	 */
    public void setTeuFul(String teuFul) {
        this.teuFul = teuFul;
    }

    /**
	 * Column Info
	 * @param cndAckSubCd
	 */
    public void setCndAckSubCd(String cndAckSubCd) {
        this.cndAckSubCd = cndAckSubCd;
    }

    /**
	 * Column Info
	 * @param status
	 */
    public void setStatus(String status) {
        this.status = status;
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
	 * @param grsRgstTongWgt
	 */
    public void setGrsRgstTongWgt(String grsRgstTongWgt) {
        this.grsRgstTongWgt = grsRgstTongWgt;
    }

    /**
	 * Column Info
	 * @param cvyRefNo
	 */
    public void setCvyRefNo(String cvyRefNo) {
        this.cvyRefNo = cvyRefNo;
    }

    /**
	 * Column Info
	 * @param westCvyRefNo
	 */
    public void setWestCvyRefNo(String westCvyRefNo) {
        this.westCvyRefNo = westCvyRefNo;
    }

    /**
	 * Column Info
	 * @param teuMty
	 */
    public void setTeuMty(String teuMty) {
        this.teuMty = teuMty;
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
	 * @param cndAckCtrlNo
	 */
    public void setCndAckCtrlNo(String cndAckCtrlNo) {
        this.cndAckCtrlNo = cndAckCtrlNo;
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
	 * @param vslDeratCertiExpDt
	 */
    public void setVslDeratCertiExpDt(String vslDeratCertiExpDt) {
        this.vslDeratCertiExpDt = vslDeratCertiExpDt;
    }

    /**
	 * Column Info
	 * @param othMty
	 */
    public void setOthMty(String othMty) {
        this.othMty = othMty;
    }

    /**
	 * Column Info
	 * @param lloydNo
	 */
    public void setLloydNo(String lloydNo) {
        this.lloydNo = lloydNo;
    }

    /**
	 * Column Info
	 * @param rgstNo
	 */
    public void setRgstNo(String rgstNo) {
        this.rgstNo = rgstNo;
    }

    /**
	 * Column Info
	 * @param delFlag
	 */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /**
	 * Column Info
	 * @param cndAckRspnCd
	 */
    public void setCndAckRspnCd(String cndAckRspnCd) {
        this.cndAckRspnCd = cndAckRspnCd;
    }

    /**
	 * Column Info
	 * @param actArrDt
	 */
    public void setActArrDt(String actArrDt) {
        this.actArrDt = actArrDt;
    }

    /**
	 * Column Infof
	 * @param podNm
	 */
    public void setPodNm(String podNm) {
        this.podNm = podNm;
    }

    /**
	 * Column Infof
	 * @param pasgCnt
	 */
    public void setPasgCnt(String pasgCnt) {
        this.pasgCnt = pasgCnt;
    }

    public void setCcTrans(String ccTrans) {
        this.ccTrans = ccTrans;
    }

    public String getCcTrans() {
        return this.ccTrans;
    }

    public void setActDepDt(String actDepDt) {
        this.actDepDt = actDepDt;
    }

    public String getActDepDt() {
        return this.actDepDt;
    }

    public void setEtdDt(String etdDt) {
        this.etdDt = etdDt;
    }

    public String getEtdDt() {
        return this.etdDt;
    }

    public void setPolNm(String polNm) {
        this.polNm = polNm;
    }

    public String getPolNm() {
        return this.polNm;
    }

    public void setVslDepRptSndDt(String vslDepRptSndDt) {
        this.vslDepRptSndDt = vslDepRptSndDt;
    }

    public String getVslDepRptSndDt() {
        return this.vslDepRptSndDt;
    }

    public void setCstmsTrsmStsCd(String cstmsTrsmStsCd) {
        this.cstmsTrsmStsCd = cstmsTrsmStsCd;
    }

    public String getCstmsTrsmStsCd() {
        return this.cstmsTrsmStsCd;
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
        setDtDiffChk(JSPUtil.getParameter(request, prefix + "dt_diff_chk", ""));
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setDtNullChk(JSPUtil.getParameter(request, prefix + "dt_null_chk", ""));
        setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
        setLoaLen(JSPUtil.getParameter(request, prefix + "loa_len", ""));
        setDwtWgt(JSPUtil.getParameter(request, prefix + "dwt_wgt", ""));
        setCrwKnt(JSPUtil.getParameter(request, prefix + "crw_knt", ""));
        setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
        setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
        setVslSftEqCertiExpDt(JSPUtil.getParameter(request, prefix + "vsl_sft_eq_certi_exp_dt", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setVslSftCstruCertiExpDt(JSPUtil.getParameter(request, prefix + "vsl_sft_cstru_certi_exp_dt", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setVslRgstCntCd(JSPUtil.getParameter(request, prefix + "vsl_rgst_cnt_cd", ""));
        setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
        setVslLodLineCertiExpDt(JSPUtil.getParameter(request, prefix + "vsl_lod_line_certi_exp_dt", ""));
        setOthFul(JSPUtil.getParameter(request, prefix + "oth_ful", ""));
        setFeuMty(JSPUtil.getParameter(request, prefix + "feu_mty", ""));
        setVslSftRdoCertiExpDt(JSPUtil.getParameter(request, prefix + "vsl_sft_rdo_certi_exp_dt", ""));
        setRgstDt(JSPUtil.getParameter(request, prefix + "rgst_dt", ""));
        setCapNm(JSPUtil.getParameter(request, prefix + "cap_nm", ""));
        setFeuFul(JSPUtil.getParameter(request, prefix + "feu_ful", ""));
        setCgoWgt(JSPUtil.getParameter(request, prefix + "cgo_wgt", ""));
        setVslArrRptSndDt(JSPUtil.getParameter(request, prefix + "vsl_arr_rpt_snd_dt", ""));
        setNetRgstTongWgt(JSPUtil.getParameter(request, prefix + "net_rgst_tong_wgt", ""));
        setRgstPortCd(JSPUtil.getParameter(request, prefix + "rgst_port_cd", ""));
        setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
        setTeuFul(JSPUtil.getParameter(request, prefix + "teu_ful", ""));
        setCndAckSubCd(JSPUtil.getParameter(request, prefix + "cnd_ack_sub_cd", ""));
        setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setGrsRgstTongWgt(JSPUtil.getParameter(request, prefix + "grs_rgst_tong_wgt", ""));
        setCvyRefNo(JSPUtil.getParameter(request, prefix + "cvy_ref_no", ""));
        setWestCvyRefNo(JSPUtil.getParameter(request, prefix + "west_cvy_ref_no", ""));
        setTeuMty(JSPUtil.getParameter(request, prefix + "teu_mty", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setCndAckCtrlNo(JSPUtil.getParameter(request, prefix + "cnd_ack_ctrl_no", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setVslDeratCertiExpDt(JSPUtil.getParameter(request, prefix + "vsl_derat_certi_exp_dt", ""));
        setOthMty(JSPUtil.getParameter(request, prefix + "oth_mty", ""));
        setLloydNo(JSPUtil.getParameter(request, prefix + "lloyd_no", ""));
        setRgstNo(JSPUtil.getParameter(request, prefix + "rgst_no", ""));
        setDelFlag(JSPUtil.getParameter(request, prefix + "del_flag", ""));
        setCndAckRspnCd(JSPUtil.getParameter(request, prefix + "cnd_ack_rspn_cd", ""));
        setActArrDt(JSPUtil.getParameter(request, "act_arr_dt", ""));
        setPodNm(JSPUtil.getParameter(request, "pod_nm", ""));
        setPasgCnt(JSPUtil.getParameter(request, "pasg_cnt", ""));
        setCcTrans(JSPUtil.getParameter(request, prefix + "cc_trans", ""));
        setActDepDt(JSPUtil.getParameter(request, prefix + "act_dep_dt", ""));
        setEtdDt(JSPUtil.getParameter(request, prefix + "etd_dt", ""));
        setPolNm(JSPUtil.getParameter(request, prefix + "pol_nm", ""));
        setVslDepRptSndDt(JSPUtil.getParameter(request, prefix + "vsl_dep_rpt_snd_dt", ""));
        setCstmsTrsmStsCd(JSPUtil.getParameter(request, prefix + "cstms_trsm_sts_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CndVesselArrivalTransmitVO[]
	 */
    public CndVesselArrivalTransmitVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CndVesselArrivalTransmitVO[]
	 */
    public CndVesselArrivalTransmitVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CndVesselArrivalTransmitVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] dtDiffChk = (JSPUtil.getParameter(request, prefix + "dt_diff_chk", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] dtNullChk = (JSPUtil.getParameter(request, prefix + "dt_null_chk", length));
            String[] etaDt = (JSPUtil.getParameter(request, prefix + "eta_dt", length));
            String[] loaLen = (JSPUtil.getParameter(request, prefix + "loa_len", length));
            String[] dwtWgt = (JSPUtil.getParameter(request, prefix + "dwt_wgt", length));
            String[] crwKnt = (JSPUtil.getParameter(request, prefix + "crw_knt", length));
            String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
            String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix + "vps_eta_dt", length));
            String[] vslSftEqCertiExpDt = (JSPUtil.getParameter(request, prefix + "vsl_sft_eq_certi_exp_dt", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] vpsPortCd = (JSPUtil.getParameter(request, prefix + "vps_port_cd", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] vslSftCstruCertiExpDt = (JSPUtil.getParameter(request, prefix + "vsl_sft_cstru_certi_exp_dt", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] vslRgstCntCd = (JSPUtil.getParameter(request, prefix + "vsl_rgst_cnt_cd", length));
            String[] vslEngNm = (JSPUtil.getParameter(request, prefix + "vsl_eng_nm", length));
            String[] vslLodLineCertiExpDt = (JSPUtil.getParameter(request, prefix + "vsl_lod_line_certi_exp_dt", length));
            String[] othFul = (JSPUtil.getParameter(request, prefix + "oth_ful", length));
            String[] feuMty = (JSPUtil.getParameter(request, prefix + "feu_mty", length));
            String[] vslSftRdoCertiExpDt = (JSPUtil.getParameter(request, prefix + "vsl_sft_rdo_certi_exp_dt", length));
            String[] rgstDt = (JSPUtil.getParameter(request, prefix + "rgst_dt", length));
            String[] capNm = (JSPUtil.getParameter(request, prefix + "cap_nm", length));
            String[] feuFul = (JSPUtil.getParameter(request, prefix + "feu_ful", length));
            String[] cgoWgt = (JSPUtil.getParameter(request, prefix + "cgo_wgt", length));
            String[] vslArrRptSndDt = (JSPUtil.getParameter(request, prefix + "vsl_arr_rpt_snd_dt", length));
            String[] netRgstTongWgt = (JSPUtil.getParameter(request, prefix + "net_rgst_tong_wgt", length));
            String[] rgstPortCd = (JSPUtil.getParameter(request, prefix + "rgst_port_cd", length));
            String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix + "vps_etd_dt", length));
            String[] teuFul = (JSPUtil.getParameter(request, prefix + "teu_ful", length));
            String[] cndAckSubCd = (JSPUtil.getParameter(request, prefix + "cnd_ack_sub_cd", length));
            String[] status = (JSPUtil.getParameter(request, prefix + "status", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] grsRgstTongWgt = (JSPUtil.getParameter(request, prefix + "grs_rgst_tong_wgt", length));
            String[] cvyRefNo = (JSPUtil.getParameter(request, prefix + "cvy_ref_no", length));
            String[] westCvyRefNo = (JSPUtil.getParameter(request, prefix + "west_cvy_ref_no", length));
            String[] teuMty = (JSPUtil.getParameter(request, prefix + "teu_mty", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] cndAckCtrlNo = (JSPUtil.getParameter(request, prefix + "cnd_ack_ctrl_no", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] vslDeratCertiExpDt = (JSPUtil.getParameter(request, prefix + "vsl_derat_certi_exp_dt", length));
            String[] othMty = (JSPUtil.getParameter(request, prefix + "oth_mty", length));
            String[] lloydNo = (JSPUtil.getParameter(request, prefix + "lloyd_no", length));
            String[] rgstNo = (JSPUtil.getParameter(request, prefix + "rgst_no", length));
            String[] delFlag = (JSPUtil.getParameter(request, prefix + "del_flag", length));
            String[] cndAckRspnCd = (JSPUtil.getParameter(request, prefix + "cnd_ack_rspn_cd", length));
            String[] actArrDt = (JSPUtil.getParameter(request, prefix + "act_arr_dt".trim(), length));
            String[] podNm = (JSPUtil.getParameter(request, prefix + "pod_nm".trim(), length));
            String[] pasgCnt = (JSPUtil.getParameter(request, prefix + "pasg_cnt".trim(), length));
            String[] ccTrans = (JSPUtil.getParameter(request, prefix + "cc_trans", length));
            String[] actDepDt = (JSPUtil.getParameter(request, prefix + "act_dep_dt", length));
            String[] etdDt = (JSPUtil.getParameter(request, prefix + "etd_dt", length));
            String[] polNm = (JSPUtil.getParameter(request, prefix + "pol_nm", length));
            String[] vslDepRptSndDt = (JSPUtil.getParameter(request, prefix + "vsl_dep_rpt_snd_dt", length));
            String[] cstmsTrsmStsCd = (JSPUtil.getParameter(request, prefix + "cstms_trsm_sts_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new CndVesselArrivalTransmitVO();
                if (dtDiffChk[i] != null)
                    model.setDtDiffChk(dtDiffChk[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (dtNullChk[i] != null)
                    model.setDtNullChk(dtNullChk[i]);
                if (etaDt[i] != null)
                    model.setEtaDt(etaDt[i]);
                if (loaLen[i] != null)
                    model.setLoaLen(loaLen[i]);
                if (dwtWgt[i] != null)
                    model.setDwtWgt(dwtWgt[i]);
                if (crwKnt[i] != null)
                    model.setCrwKnt(crwKnt[i]);
                if (blNo[i] != null)
                    model.setBlNo(blNo[i]);
                if (vpsEtaDt[i] != null)
                    model.setVpsEtaDt(vpsEtaDt[i]);
                if (vslSftEqCertiExpDt[i] != null)
                    model.setVslSftEqCertiExpDt(vslSftEqCertiExpDt[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (vpsPortCd[i] != null)
                    model.setVpsPortCd(vpsPortCd[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (vslSftCstruCertiExpDt[i] != null)
                    model.setVslSftCstruCertiExpDt(vslSftCstruCertiExpDt[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (vslRgstCntCd[i] != null)
                    model.setVslRgstCntCd(vslRgstCntCd[i]);
                if (vslEngNm[i] != null)
                    model.setVslEngNm(vslEngNm[i]);
                if (vslLodLineCertiExpDt[i] != null)
                    model.setVslLodLineCertiExpDt(vslLodLineCertiExpDt[i]);
                if (othFul[i] != null)
                    model.setOthFul(othFul[i]);
                if (feuMty[i] != null)
                    model.setFeuMty(feuMty[i]);
                if (vslSftRdoCertiExpDt[i] != null)
                    model.setVslSftRdoCertiExpDt(vslSftRdoCertiExpDt[i]);
                if (rgstDt[i] != null)
                    model.setRgstDt(rgstDt[i]);
                if (capNm[i] != null)
                    model.setCapNm(capNm[i]);
                if (feuFul[i] != null)
                    model.setFeuFul(feuFul[i]);
                if (cgoWgt[i] != null)
                    model.setCgoWgt(cgoWgt[i]);
                if (vslArrRptSndDt[i] != null)
                    model.setVslArrRptSndDt(vslArrRptSndDt[i]);
                if (netRgstTongWgt[i] != null)
                    model.setNetRgstTongWgt(netRgstTongWgt[i]);
                if (rgstPortCd[i] != null)
                    model.setRgstPortCd(rgstPortCd[i]);
                if (vpsEtdDt[i] != null)
                    model.setVpsEtdDt(vpsEtdDt[i]);
                if (teuFul[i] != null)
                    model.setTeuFul(teuFul[i]);
                if (cndAckSubCd[i] != null)
                    model.setCndAckSubCd(cndAckSubCd[i]);
                if (status[i] != null)
                    model.setStatus(status[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (grsRgstTongWgt[i] != null)
                    model.setGrsRgstTongWgt(grsRgstTongWgt[i]);
                if (cvyRefNo[i] != null)
                    model.setCvyRefNo(cvyRefNo[i]);
                if (westCvyRefNo[i] != null)
                    model.setWestCvyRefNo(westCvyRefNo[i]);
                if (teuMty[i] != null)
                    model.setTeuMty(teuMty[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (cndAckCtrlNo[i] != null)
                    model.setCndAckCtrlNo(cndAckCtrlNo[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (vslDeratCertiExpDt[i] != null)
                    model.setVslDeratCertiExpDt(vslDeratCertiExpDt[i]);
                if (othMty[i] != null)
                    model.setOthMty(othMty[i]);
                if (lloydNo[i] != null)
                    model.setLloydNo(lloydNo[i]);
                if (rgstNo[i] != null)
                    model.setRgstNo(rgstNo[i]);
                if (delFlag[i] != null)
                    model.setDelFlag(delFlag[i]);
                if (cndAckRspnCd[i] != null)
                    model.setCndAckRspnCd(cndAckRspnCd[i]);
                if (actArrDt[i] != null)
                    model.setActArrDt(actArrDt[i]);
                if (podNm[i] != null)
                    model.setPodNm(podNm[i]);
                if (pasgCnt[i] != null)
                    model.setPasgCnt(pasgCnt[i]);
                if (ccTrans[i] != null)
                    model.setCcTrans(ccTrans[i]);
                if (actDepDt[i] != null)
                    model.setActDepDt(actDepDt[i]);
                if (etdDt[i] != null)
                    model.setEtdDt(etdDt[i]);
                if (polNm[i] != null)
                    model.setPolNm(polNm[i]);
                if (vslDepRptSndDt[i] != null)
                    model.setVslDepRptSndDt(vslDepRptSndDt[i]);
                if (cstmsTrsmStsCd[i] != null) 
		    		model.setCstmsTrsmStsCd(cstmsTrsmStsCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCndVesselArrivalTransmitVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return CndVesselArrivalTransmitVO[]
	 */
    public CndVesselArrivalTransmitVO[] getCndVesselArrivalTransmitVOs() {
        CndVesselArrivalTransmitVO[] vos = (CndVesselArrivalTransmitVO[]) models.toArray(new CndVesselArrivalTransmitVO[models.size()]);
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
        this.dtDiffChk = this.dtDiffChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dtNullChk = this.dtNullChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.etaDt = this.etaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.loaLen = this.loaLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dwtWgt = this.dwtWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crwKnt = this.crwKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsEtaDt = this.vpsEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslSftEqCertiExpDt = this.vslSftEqCertiExpDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsPortCd = this.vpsPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslSftCstruCertiExpDt = this.vslSftCstruCertiExpDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslRgstCntCd = this.vslRgstCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslEngNm = this.vslEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslLodLineCertiExpDt = this.vslLodLineCertiExpDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.othFul = this.othFul.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.feuMty = this.feuMty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslSftRdoCertiExpDt = this.vslSftRdoCertiExpDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rgstDt = this.rgstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.capNm = this.capNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.feuFul = this.feuFul.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cgoWgt = this.cgoWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslArrRptSndDt = this.vslArrRptSndDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.netRgstTongWgt = this.netRgstTongWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rgstPortCd = this.rgstPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsEtdDt = this.vpsEtdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.teuFul = this.teuFul.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cndAckSubCd = this.cndAckSubCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.status = this.status.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.grsRgstTongWgt = this.grsRgstTongWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cvyRefNo = this.cvyRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.westCvyRefNo = this.westCvyRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.teuMty = this.teuMty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cndAckCtrlNo = this.cndAckCtrlNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslDeratCertiExpDt = this.vslDeratCertiExpDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.othMty = this.othMty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lloydNo = this.lloydNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rgstNo = this.rgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delFlag = this.delFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cndAckRspnCd = this.cndAckRspnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actArrDt = this.actArrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podNm = this.podNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pasgCnt = this.pasgCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ccTrans = this.ccTrans.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actDepDt = this.actDepDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.etdDt = this.etdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polNm = this.polNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslDepRptSndDt = this.vslDepRptSndDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cstmsTrsmStsCd = this.cstmsTrsmStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
