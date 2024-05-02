/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChinaBlInfoListVO.java
*@FileTitle : ChinaBlInfoListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.17
*@LastModifier : 
*@LastVersion : 1.1
* 2010.04.02  
* 1.0 Creation
* 1.1 2014.06.17
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoVO;
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
public class ChinaBlInfoListVO extends BlInfoVO {

    private static final long serialVersionUID = 1L;

    private Collection<ChinaBlInfoListVO> models = new ArrayList<ChinaBlInfoListVO>();

    /* Column Info */
    private String total = null;

    /* Column Info */
    private String etaFlg = null;

    /* Column Info */
    private String sndDate = null;

    /* Column Info */
    private String vpsEtbDt = null;

    /* Column Info */
    private String bkgCgoTpCd = null;

    /* Column Info */
    private String cneeAddr = null;

    /* Column Info */
    private String tr = null;

    /* Column Info */
    private String sealerCdFlg = null;

    /* Column Info */
    private String vpsEtaDt = null;

    /* Column Info */
    private String blNo = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String locCd = null;

    /* Column Info */
    private String bkgPodCd = null;

    /* Column Info */
    private String polCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String trsmMsgTpId = null;

    /* Column Info */
    private String shprAddr = null;

    /* Column Info */
    private String vslEngNm = null;

    /* Column Info */
    private String mfSndDt = null;

    /* Column Info */
    private String wgtUtCd = null;

    /* Column Info */
    private String dcgoFlg = null;

    /* Column Info */
    private String pckQty = null;

    /* Column Info */
    private String shprNm = null;

    /* Column Info */
    private String pckTpCd = null;

    /* Column Info */
    private String prePort = null;

    /* Column Info */
    private String ntfyAddr = null;

    /* Column Info */
    private String bkgPolCd = null;

    /* Column Info */
    private String vpsEtdDt = null;

    /* Column Info */
    private String callSgnNo = null;

    /* Column Info */
    private String delCd = null;

    /* Column Info */
    private String cntrCnt = null;

    /* Column Info */
    private String ntfyNm = null;

    /* Column Info */
    private String nxtPort = null;

    /* Column Info */
    private String actWgt = null;

    /* Column Info */
    private String vvd = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String transMode = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String cneeNm = null;

    /* Column Info */
    private String rcFlg = null;

    /* Column Info */
    private String sealNoFlg = null;

    /* Column Info */
    private String sealKndFlg = null;

    /* Column Info */
    private String etdFlg = null;

    /*	Column Info	*/
    private String meaQty = null;

    /*	Column Info	*/
    private String cntcPsonNm = null;

    /*	Column Info	*/
    private String cntcPsonTelcmNo = null;

    /*	Column Info	*/
    private String imdgUnNo = null;

    /*	Column Info	*/
    private String frtTermCd = null;

    /*	Column Info	*/
    private String rcvTermCd = null;

    /*	Column Info	*/
    private String deTermCd = null;

    /*	Column Info	*/
    private String blMkDesc = null;

    /*	Column Info	*/
    private String cmPckQty = null;

    /*	Column Info	*/
    private String cmPckTpCd = null;

    /*	Column Info	*/
    private String cmCntrMfWgt = null;

    /* Column Info */
    private String shprRgstNo = null;

    /* Column Info */
    private String cneeRgstNo = null;

    /* Column Info */
    private String ntfyRgstNo = null;

    /* Column Info */
    private String shprCnt = null;

    /* Column Info */
    private String shprStPo = null;

    /* Column Info */
    private String shprFax = null;

    /* Column Info */
    private String shprEml = null;

    /* Column Info */
    private String shprPhn = null;

    /* Column Info */
    private String cneeCnt = null;

    /* Column Info */
    private String cneeStPo = null;

    /* Column Info */
    private String cneeFax = null;

    /* Column Info */
    private String cneeEml = null;

    /* Column Info */
    private String cneePhn = null;

    /* Column Info */
    private String ntfyCnt = null;

    /* Column Info */
    private String ntfyStPo = null;

    /* Column Info */
    private String ntfyFax = null;

    /* Column Info */
    private String ntfyEml = null;

    /* Column Info */
    private String ntfyPhn = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public ChinaBlInfoListVO() {
    }

    public ChinaBlInfoListVO(String ibflag, String pagerows, String bkgNo, String blNo, String polCd, String podCd, String bkgPolCd, String bkgPodCd, String delCd, String pckQty, String pckTpCd, String actWgt, String wgtUtCd, String sealNoFlg, String sealerCdFlg, String sealKndFlg, String shprNm, String shprAddr, String cneeNm, String cneeAddr, String ntfyNm, String ntfyAddr, String bkgCgoTpCd, String tr, String dcgoFlg, String rcFlg, String cntrCnt, String trsmMsgTpId, String mfSndDt, String callSgnNo, String prePort, String nxtPort, String vpsEtaDt, String vpsEtdDt, String vpsEtbDt, String vslEngNm, String sndDate, String etaFlg, String etdFlg, String vvd, String locCd, String transMode, String total, String meaQty, String cntcPsonNm, String cntcPsonTelcmNo, String imdgUnNo, String frtTermCd, String rcvTermCd, String deTermCd, String blMkDesc, String cmPckQty, String cmPckTpCd, String cmCntrMfWgt, String shprRgstNo, String cneeRgstNo, String ntfyRgstNo, String shprCnt, String shprStPo, String shprFax, String shprEml, String shprPhn, String cneeCnt, String cneeStPo, String cneeFax, String cneeEml, String cneePhn, String ntfyCnt, String ntfyStPo, String ntfyFax, String ntfyEml, String ntfyPhn) {
        this.total = total;
        this.etaFlg = etaFlg;
        this.sndDate = sndDate;
        this.vpsEtbDt = vpsEtbDt;
        this.bkgCgoTpCd = bkgCgoTpCd;
        this.cneeAddr = cneeAddr;
        this.tr = tr;
        this.sealerCdFlg = sealerCdFlg;
        this.vpsEtaDt = vpsEtaDt;
        this.blNo = blNo;
        this.pagerows = pagerows;
        this.locCd = locCd;
        this.bkgPodCd = bkgPodCd;
        this.polCd = polCd;
        this.ibflag = ibflag;
        this.trsmMsgTpId = trsmMsgTpId;
        this.shprAddr = shprAddr;
        this.vslEngNm = vslEngNm;
        this.mfSndDt = mfSndDt;
        this.wgtUtCd = wgtUtCd;
        this.dcgoFlg = dcgoFlg;
        this.pckQty = pckQty;
        this.shprNm = shprNm;
        this.pckTpCd = pckTpCd;
        this.prePort = prePort;
        this.ntfyAddr = ntfyAddr;
        this.bkgPolCd = bkgPolCd;
        this.vpsEtdDt = vpsEtdDt;
        this.callSgnNo = callSgnNo;
        this.delCd = delCd;
        this.cntrCnt = cntrCnt;
        this.ntfyNm = ntfyNm;
        this.nxtPort = nxtPort;
        this.actWgt = actWgt;
        this.vvd = vvd;
        this.podCd = podCd;
        this.transMode = transMode;
        this.bkgNo = bkgNo;
        this.cneeNm = cneeNm;
        this.rcFlg = rcFlg;
        this.sealNoFlg = sealNoFlg;
        this.sealKndFlg = sealKndFlg;
        this.etdFlg = etdFlg;
        this.meaQty = meaQty;
        this.cntcPsonNm = cntcPsonNm;
        this.cntcPsonTelcmNo = cntcPsonTelcmNo;
        this.imdgUnNo = imdgUnNo;
        this.frtTermCd = frtTermCd;
        this.rcvTermCd = rcvTermCd;
        this.deTermCd = deTermCd;
        this.blMkDesc = blMkDesc;
        this.cmPckQty = cmPckQty;
        this.cmPckTpCd = cmPckTpCd;
        this.cmCntrMfWgt = cmCntrMfWgt;
        this.shprRgstNo = shprRgstNo;
        this.cneeRgstNo = cneeRgstNo;
        this.ntfyRgstNo = ntfyRgstNo;
        this.shprCnt = shprCnt;
        this.shprStPo = shprStPo;
        this.shprFax = shprFax;
        this.shprEml = shprEml;
        this.shprPhn = shprPhn;
        this.cneeCnt = cneeCnt;
        this.cneeStPo = cneeStPo;
        this.cneeFax = cneeFax;
        this.cneeEml = cneeEml;
        this.cneePhn = cneePhn;
        this.ntfyCnt = ntfyCnt;
        this.ntfyStPo = ntfyStPo;
        this.ntfyFax = ntfyFax;
        this.ntfyEml = ntfyEml;
        this.ntfyPhn = ntfyPhn;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("total", getTotal());
        this.hashColumns.put("eta_flg", getEtaFlg());
        this.hashColumns.put("snd_date", getSndDate());
        this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
        this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
        this.hashColumns.put("cnee_addr", getCneeAddr());
        this.hashColumns.put("tr", getTr());
        this.hashColumns.put("sealer_cd_flg", getSealerCdFlg());
        this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
        this.hashColumns.put("bl_no", getBlNo());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("loc_cd", getLocCd());
        this.hashColumns.put("bkg_pod_cd", getBkgPodCd());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("trsm_msg_tp_id", getTrsmMsgTpId());
        this.hashColumns.put("shpr_addr", getShprAddr());
        this.hashColumns.put("vsl_eng_nm", getVslEngNm());
        this.hashColumns.put("mf_snd_dt", getMfSndDt());
        this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
        this.hashColumns.put("dcgo_flg", getDcgoFlg());
        this.hashColumns.put("pck_qty", getPckQty());
        this.hashColumns.put("shpr_nm", getShprNm());
        this.hashColumns.put("pck_tp_cd", getPckTpCd());
        this.hashColumns.put("pre_port", getPrePort());
        this.hashColumns.put("ntfy_addr", getNtfyAddr());
        this.hashColumns.put("bkg_pol_cd", getBkgPolCd());
        this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
        this.hashColumns.put("call_sgn_no", getCallSgnNo());
        this.hashColumns.put("del_cd", getDelCd());
        this.hashColumns.put("cntr_cnt", getCntrCnt());
        this.hashColumns.put("ntfy_nm", getNtfyNm());
        this.hashColumns.put("nxt_port", getNxtPort());
        this.hashColumns.put("act_wgt", getActWgt());
        this.hashColumns.put("vvd", getVvd());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("trans_mode", getTransMode());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("cnee_nm", getCneeNm());
        this.hashColumns.put("rc_flg", getRcFlg());
        this.hashColumns.put("seal_no_flg", getSealNoFlg());
        this.hashColumns.put("seal_knd_flg", getSealKndFlg());
        this.hashColumns.put("etd_flg", getEtdFlg());
        this.hashColumns.put("mea_qty", getMeaQty());
        this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
        this.hashColumns.put("cntc_pson_telcm_no", getCntcPsonTelcmNo());
        this.hashColumns.put("imdg_un_no", getImdgUnNo());
        this.hashColumns.put("frt_term_cd", getFrtTermCd());
        this.hashColumns.put("rcv_term_cd", getRcvTermCd());
        this.hashColumns.put("de_term_cd", getDeTermCd());
        this.hashColumns.put("bl_mk_desc", getBlMkDesc());
        this.hashColumns.put("cm_pck_qty", getCmPckQty());
        this.hashColumns.put("cm_pck_tp_cd", getCmPckTpCd());
        this.hashColumns.put("cm_cntr_mf_wgt", getCmCntrMfWgt());
        this.hashColumns.put("shpr_rgst_no", getShprRgstNo());
        this.hashColumns.put("cnee_rgst_no", getCneeRgstNo());
        this.hashColumns.put("ntfy_rgst_no", getNtfyRgstNo());
        this.hashColumns.put("shpr_cnt", getShprCnt());
        this.hashColumns.put("shpr_st_po", getShprStPo());
        this.hashColumns.put("shpr_fax", getShprFax());
        this.hashColumns.put("shpr_eml", getShprEml());
        this.hashColumns.put("shpr_phn", getShprPhn());
        this.hashColumns.put("cnee_cnt", getCneeCnt());
        this.hashColumns.put("cnee_st_po", getCneeStPo());
        this.hashColumns.put("cnee_fax", getCneeFax());
        this.hashColumns.put("cnee_eml", getCneeEml());
        this.hashColumns.put("cnee_phn", getCneePhn());
        this.hashColumns.put("ntfy_cnt", getNtfyCnt());
        this.hashColumns.put("ntfy_st_po", getNtfyStPo());
        this.hashColumns.put("ntfy_fax", getNtfyFax());
        this.hashColumns.put("ntfy_eml", getNtfyEml());
        this.hashColumns.put("ntfy_phn", getNtfyPhn());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("total", "total");
        this.hashFields.put("eta_flg", "etaFlg");
        this.hashFields.put("snd_date", "sndDate");
        this.hashFields.put("vps_etb_dt", "vpsEtbDt");
        this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
        this.hashFields.put("cnee_addr", "cneeAddr");
        this.hashFields.put("tr", "tr");
        this.hashFields.put("sealer_cd_flg", "sealerCdFlg");
        this.hashFields.put("vps_eta_dt", "vpsEtaDt");
        this.hashFields.put("bl_no", "blNo");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("loc_cd", "locCd");
        this.hashFields.put("bkg_pod_cd", "bkgPodCd");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("trsm_msg_tp_id", "trsmMsgTpId");
        this.hashFields.put("shpr_addr", "shprAddr");
        this.hashFields.put("vsl_eng_nm", "vslEngNm");
        this.hashFields.put("mf_snd_dt", "mfSndDt");
        this.hashFields.put("wgt_ut_cd", "wgtUtCd");
        this.hashFields.put("dcgo_flg", "dcgoFlg");
        this.hashFields.put("pck_qty", "pckQty");
        this.hashFields.put("shpr_nm", "shprNm");
        this.hashFields.put("pck_tp_cd", "pckTpCd");
        this.hashFields.put("pre_port", "prePort");
        this.hashFields.put("ntfy_addr", "ntfyAddr");
        this.hashFields.put("bkg_pol_cd", "bkgPolCd");
        this.hashFields.put("vps_etd_dt", "vpsEtdDt");
        this.hashFields.put("call_sgn_no", "callSgnNo");
        this.hashFields.put("del_cd", "delCd");
        this.hashFields.put("cntr_cnt", "cntrCnt");
        this.hashFields.put("ntfy_nm", "ntfyNm");
        this.hashFields.put("nxt_port", "nxtPort");
        this.hashFields.put("act_wgt", "actWgt");
        this.hashFields.put("vvd", "vvd");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("trans_mode", "transMode");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("cnee_nm", "cneeNm");
        this.hashFields.put("rc_flg", "rcFlg");
        this.hashFields.put("seal_no_flg", "sealNoFlg");
        this.hashFields.put("seal_knd_flg", "sealKndFlg");
        this.hashFields.put("etd_flg", "etdFlg");
        this.hashFields.put("mea_qty", "meaQty");
        this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
        this.hashFields.put("cntc_pson_telcm_no", "cntcPsonTelcmNo");
        this.hashFields.put("imdg_un_no", "imdgUnNo");
        this.hashFields.put("frt_term_cd", "frtTermCd");
        this.hashFields.put("rcv_term_cd", "rcvTermCd");
        this.hashFields.put("de_term_cd", "deTermCd");
        this.hashFields.put("bl_mk_desc", "blMkDesc");
        this.hashFields.put("cm_pck_qty", "cmPckQty");
        this.hashFields.put("cm_pck_tp_cd", "cmPckTpCd");
        this.hashFields.put("cm_cntr_mf_wgt", "cmCntrMfWgt");
        this.hashFields.put("shpr_rgst_no", "shprRgstNo");
        this.hashFields.put("cnee_rgst_no", "cneeRgstNo");
        this.hashFields.put("ntfy_rgst_no", "ntfyRgstNo");
        this.hashFields.put("shpr_cnt", "shprCnt");
        this.hashFields.put("shpr_st_po", "shprStPo");
        this.hashFields.put("shpr_fax", "shprFax");
        this.hashFields.put("shpr_eml", "shprEml");
        this.hashFields.put("shpr_phn", "shprPhn");
        this.hashFields.put("cnee_cnt", "cneeCnt");
        this.hashFields.put("cnee_st_po", "cneeStPo");
        this.hashFields.put("cnee_fax", "cneeFax");
        this.hashFields.put("cnee_eml", "cneeEml");
        this.hashFields.put("cnee_phn", "cneePhn");
        this.hashFields.put("ntfy_cnt", "ntfyCnt");
        this.hashFields.put("ntfy_st_po", "ntfyStPo");
        this.hashFields.put("ntfy_fax", "ntfyFax");
        this.hashFields.put("ntfy_eml", "ntfyEml");
        this.hashFields.put("ntfy_phn", "ntfyPhn");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return total
	 */
    public String getTotal() {
        return this.total;
    }

    /**
	 * Column Info
	 * @return etaFlg
	 */
    public String getEtaFlg() {
        return this.etaFlg;
    }

    /**
	 * Column Info
	 * @return sndDate
	 */
    public String getSndDate() {
        return this.sndDate;
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
	 * @return bkgCgoTpCd
	 */
    public String getBkgCgoTpCd() {
        return this.bkgCgoTpCd;
    }

    /**
	 * Column Info
	 * @return cneeAddr
	 */
    public String getCneeAddr() {
        return this.cneeAddr;
    }

    /**
	 * Column Info
	 * @return tr
	 */
    public String getTr() {
        return this.tr;
    }

    /**
	 * Column Info
	 * @return sealerCdFlg
	 */
    public String getSealerCdFlg() {
        return this.sealerCdFlg;
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
	 * @return blNo
	 */
    public String getBlNo() {
        return this.blNo;
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
	 * @return locCd
	 */
    public String getLocCd() {
        return this.locCd;
    }

    /**
	 * Column Info
	 * @return bkgPodCd
	 */
    public String getBkgPodCd() {
        return this.bkgPodCd;
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
	 * @return trsmMsgTpId
	 */
    public String getTrsmMsgTpId() {
        return this.trsmMsgTpId;
    }

    /**
	 * Column Info
	 * @return shprAddr
	 */
    public String getShprAddr() {
        return this.shprAddr;
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
	 * @return mfSndDt
	 */
    public String getMfSndDt() {
        return this.mfSndDt;
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
	 * @return dcgoFlg
	 */
    public String getDcgoFlg() {
        return this.dcgoFlg;
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
	 * @return shprNm
	 */
    public String getShprNm() {
        return this.shprNm;
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
	 * @return prePort
	 */
    public String getPrePort() {
        return this.prePort;
    }

    /**
	 * Column Info
	 * @return ntfyAddr
	 */
    public String getNtfyAddr() {
        return this.ntfyAddr;
    }

    /**
	 * Column Info
	 * @return bkgPolCd
	 */
    public String getBkgPolCd() {
        return this.bkgPolCd;
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
	 * @return callSgnNo
	 */
    public String getCallSgnNo() {
        return this.callSgnNo;
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
	 * @return cntrCnt
	 */
    public String getCntrCnt() {
        return this.cntrCnt;
    }

    /**
	 * Column Info
	 * @return ntfyNm
	 */
    public String getNtfyNm() {
        return this.ntfyNm;
    }

    /**
	 * Column Info
	 * @return nxtPort
	 */
    public String getNxtPort() {
        return this.nxtPort;
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
	 * @return vvd
	 */
    public String getVvd() {
        return this.vvd;
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
	 * @return transMode
	 */
    public String getTransMode() {
        return this.transMode;
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
	 * @return cneeNm
	 */
    public String getCneeNm() {
        return this.cneeNm;
    }

    /**
	 * Column Info
	 * @return rcFlg
	 */
    public String getRcFlg() {
        return this.rcFlg;
    }

    /**
	 * Column Info
	 * @return sealNoFlg
	 */
    public String getSealNoFlg() {
        return this.sealNoFlg;
    }

    /**
	 * Column Info
	 * @return sealKndFlg
	 */
    public String getSealKndFlg() {
        return this.sealKndFlg;
    }

    /**
	 * Column Info
	 * @return etdFlg
	 */
    public String getEtdFlg() {
        return this.etdFlg;
    }

    /**
	 * Column Info
	 * @param total
	 */
    public void setTotal(String total) {
        this.total = total;
    }

    /**
	 * Column Info
	 * @param etaFlg
	 */
    public void setEtaFlg(String etaFlg) {
        this.etaFlg = etaFlg;
    }

    /**
	 * Column Info
	 * @param sndDate
	 */
    public void setSndDate(String sndDate) {
        this.sndDate = sndDate;
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
	 * @param bkgCgoTpCd
	 */
    public void setBkgCgoTpCd(String bkgCgoTpCd) {
        this.bkgCgoTpCd = bkgCgoTpCd;
    }

    /**
	 * Column Info
	 * @param cneeAddr
	 */
    public void setCneeAddr(String cneeAddr) {
        this.cneeAddr = cneeAddr;
    }

    /**
	 * Column Info
	 * @param tr
	 */
    public void setTr(String tr) {
        this.tr = tr;
    }

    /**
	 * Column Info
	 * @param sealerCdFlg
	 */
    public void setSealerCdFlg(String sealerCdFlg) {
        this.sealerCdFlg = sealerCdFlg;
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
	 * @param blNo
	 */
    public void setBlNo(String blNo) {
        this.blNo = blNo;
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
	 * @param locCd
	 */
    public void setLocCd(String locCd) {
        this.locCd = locCd;
    }

    /**
	 * Column Info
	 * @param bkgPodCd
	 */
    public void setBkgPodCd(String bkgPodCd) {
        this.bkgPodCd = bkgPodCd;
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
	 * @param trsmMsgTpId
	 */
    public void setTrsmMsgTpId(String trsmMsgTpId) {
        this.trsmMsgTpId = trsmMsgTpId;
    }

    /**
	 * Column Info
	 * @param shprAddr
	 */
    public void setShprAddr(String shprAddr) {
        this.shprAddr = shprAddr;
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
	 * @param mfSndDt
	 */
    public void setMfSndDt(String mfSndDt) {
        this.mfSndDt = mfSndDt;
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
	 * @param dcgoFlg
	 */
    public void setDcgoFlg(String dcgoFlg) {
        this.dcgoFlg = dcgoFlg;
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
	 * @param shprNm
	 */
    public void setShprNm(String shprNm) {
        this.shprNm = shprNm;
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
	 * @param prePort
	 */
    public void setPrePort(String prePort) {
        this.prePort = prePort;
    }

    /**
	 * Column Info
	 * @param ntfyAddr
	 */
    public void setNtfyAddr(String ntfyAddr) {
        this.ntfyAddr = ntfyAddr;
    }

    /**
	 * Column Info
	 * @param bkgPolCd
	 */
    public void setBkgPolCd(String bkgPolCd) {
        this.bkgPolCd = bkgPolCd;
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
	 * @param callSgnNo
	 */
    public void setCallSgnNo(String callSgnNo) {
        this.callSgnNo = callSgnNo;
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
	 * @param cntrCnt
	 */
    public void setCntrCnt(String cntrCnt) {
        this.cntrCnt = cntrCnt;
    }

    /**
	 * Column Info
	 * @param ntfyNm
	 */
    public void setNtfyNm(String ntfyNm) {
        this.ntfyNm = ntfyNm;
    }

    /**
	 * Column Info
	 * @param nxtPort
	 */
    public void setNxtPort(String nxtPort) {
        this.nxtPort = nxtPort;
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
	 * @param vvd
	 */
    public void setVvd(String vvd) {
        this.vvd = vvd;
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
	 * @param transMode
	 */
    public void setTransMode(String transMode) {
        this.transMode = transMode;
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
	 * @param cneeNm
	 */
    public void setCneeNm(String cneeNm) {
        this.cneeNm = cneeNm;
    }

    /**
	 * Column Info
	 * @param rcFlg
	 */
    public void setRcFlg(String rcFlg) {
        this.rcFlg = rcFlg;
    }

    /**
	 * Column Info
	 * @param sealNoFlg
	 */
    public void setSealNoFlg(String sealNoFlg) {
        this.sealNoFlg = sealNoFlg;
    }

    /**
	 * Column Info
	 * @param sealKndFlg
	 */
    public void setSealKndFlg(String sealKndFlg) {
        this.sealKndFlg = sealKndFlg;
    }

    /**
	 * Column Info
	 * @param etdFlg
	 */
    public void setEtdFlg(String etdFlg) {
        this.etdFlg = etdFlg;
    }

    /**
	* Column Info
	* @param  meaQty
	*/
    public void setMeaQty(String meaQty) {
        this.meaQty = meaQty;
    }

    /**
	 * Column Info
	 * @return	meaQty
	 */
    public String getMeaQty() {
        return this.meaQty;
    }

    /**
	* Column Info
	* @param  cntcPsonNm
	*/
    public void setCntcPsonNm(String cntcPsonNm) {
        this.cntcPsonNm = cntcPsonNm;
    }

    /**
	 * Column Info
	 * @return	cntcPsonNm
	 */
    public String getCntcPsonNm() {
        return this.cntcPsonNm;
    }

    /**
	* Column Info
	* @param  cntcPsonTelcmNo
	*/
    public void setCntcPsonTelcmNo(String cntcPsonTelcmNo) {
        this.cntcPsonTelcmNo = cntcPsonTelcmNo;
    }

    /**
	 * Column Info
	 * @return	cntcPsonTelcmNo
	 */
    public String getCntcPsonTelcmNo() {
        return this.cntcPsonTelcmNo;
    }

    /**
	* Column Info
	* @param  imdgUnNo
	*/
    public void setImdgUnNo(String imdgUnNo) {
        this.imdgUnNo = imdgUnNo;
    }

    /**
	 * Column Info
	 * @return	imdgUnNo
	 */
    public String getImdgUnNo() {
        return this.imdgUnNo;
    }

    /**
	* Column Info
	* @param  frtTermCd
	*/
    public void setFrtTermCd(String frtTermCd) {
        this.frtTermCd = frtTermCd;
    }

    /**
	 * Column Info
	 * @return	frtTermCd
	 */
    public String getFrtTermCd() {
        return this.frtTermCd;
    }

    /**
	* Column Info
	* @param  rcvTermCd
	*/
    public void setRcvTermCd(String rcvTermCd) {
        this.rcvTermCd = rcvTermCd;
    }

    /**
	 * Column Info
	 * @return	rcvTermCd
	 */
    public String getRcvTermCd() {
        return this.rcvTermCd;
    }

    /**
	* Column Info
	* @param  deTermCd
	*/
    public void setDeTermCd(String deTermCd) {
        this.deTermCd = deTermCd;
    }

    /**
	 * Column Info
	 * @return	deTermCd
	 */
    public String getDeTermCd() {
        return this.deTermCd;
    }

    /**
	* Column Info
	* @param  blMkDesc
	*/
    public void setBlMkDesc(String blMkDesc) {
        this.blMkDesc = blMkDesc;
    }

    /**
	 * Column Info
	 * @return	blMkDesc
	 */
    public String getBlMkDesc() {
        return this.blMkDesc;
    }

    /**
	* Column Info
	* @param  cmPckQty
	*/
    public void setCmPckQty(String cmPckQty) {
        this.cmPckQty = cmPckQty;
    }

    /**
	 * Column Info
	 * @return	cmPckQty
	 */
    public String getCmPckQty() {
        return this.cmPckQty;
    }

    /**
	* Column Info
	* @param  cmPckTpCd
	*/
    public void setCmPckTpCd(String cmPckTpCd) {
        this.cmPckTpCd = cmPckTpCd;
    }

    /**
	 * Column Info
	 * @return	cmPckTpCd
	 */
    public String getCmPckTpCd() {
        return this.cmPckTpCd;
    }

    /**
	* Column Info
	* @param  cmCntrMfWgt
	*/
    public void setCmCntrMfWgt(String cmCntrMfWgt) {
        this.cmCntrMfWgt = cmCntrMfWgt;
    }

    /**
	 * Column Info
	 * @return	cmCntrMfWgt
	 */
    public String getCmCntrMfWgt() {
        return this.cmCntrMfWgt;
    }

    public void setShprRgstNo(String shprRgstNo) {
        this.shprRgstNo = shprRgstNo;
    }

    public String getShprRgstNo() {
        return this.shprRgstNo;
    }

    public void setCneeRgstNo(String cneeRgstNo) {
        this.cneeRgstNo = cneeRgstNo;
    }

    public String getCneeRgstNo() {
        return this.cneeRgstNo;
    }

    public void setNtfyRgstNo(String ntfyRgstNo) {
        this.ntfyRgstNo = ntfyRgstNo;
    }

    public String getNtfyRgstNo() {
        return this.ntfyRgstNo;
    }

    public void setShprCnt(String shprCnt) {
        this.shprCnt = shprCnt;
    }

    public String getShprCnt() {
        return this.shprCnt;
    }

    public void setShprStPo(String shprStPo) {
        this.shprStPo = shprStPo;
    }

    public String getShprStPo() {
        return this.shprStPo;
    }

    public void setShprFax(String shprFax) {
        this.shprFax = shprFax;
    }

    public String getShprFax() {
        return this.shprFax;
    }

    public void setShprEml(String shprEml) {
        this.shprEml = shprEml;
    }

    public String getShprEml() {
        return this.shprEml;
    }

    public void setShprPhn(String shprPhn) {
        this.shprPhn = shprPhn;
    }

    public String getShprPhn() {
        return this.shprPhn;
    }

    public void setCneeCnt(String cneeCnt) {
        this.cneeCnt = cneeCnt;
    }

    public String getCneeCnt() {
        return this.cneeCnt;
    }

    public void setCneeStPo(String cneeStPo) {
        this.cneeStPo = cneeStPo;
    }

    public String getCneeStPo() {
        return this.cneeStPo;
    }

    public void setCneeFax(String cneeFax) {
        this.cneeFax = cneeFax;
    }

    public String getCneeFax() {
        return this.cneeFax;
    }

    public void setCneeEml(String cneeEml) {
        this.cneeEml = cneeEml;
    }

    public String getCneeEml() {
        return this.cneeEml;
    }

    public void setCneePhn(String cneePhn) {
        this.cneePhn = cneePhn;
    }

    public String getCneePhn() {
        return this.cneePhn;
    }

    public void setNtfyCnt(String ntfyCnt) {
        this.ntfyCnt = ntfyCnt;
    }

    public String getNtfyCnt() {
        return this.ntfyCnt;
    }

    public void setNtfyStPo(String ntfyStPo) {
        this.ntfyStPo = ntfyStPo;
    }

    public String getNtfyStPo() {
        return this.ntfyStPo;
    }

    public void setNtfyFax(String ntfyFax) {
        this.ntfyFax = ntfyFax;
    }

    public String getNtfyFax() {
        return this.ntfyFax;
    }

    public void setNtfyEml(String ntfyEml) {
        this.ntfyEml = ntfyEml;
    }

    public String getNtfyEml() {
        return this.ntfyEml;
    }

    public void setNtfyPhn(String ntfyPhn) {
        this.ntfyPhn = ntfyPhn;
    }

    public String getNtfyPhn() {
        return this.ntfyPhn;
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
        setTotal(JSPUtil.getParameter(request, prefix + "total", ""));
        setEtaFlg(JSPUtil.getParameter(request, prefix + "eta_flg", ""));
        setSndDate(JSPUtil.getParameter(request, prefix + "snd_date", ""));
        setVpsEtbDt(JSPUtil.getParameter(request, prefix + "vps_etb_dt", ""));
        setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
        setCneeAddr(JSPUtil.getParameter(request, prefix + "cnee_addr", ""));
        setTr(JSPUtil.getParameter(request, prefix + "tr", ""));
        setSealerCdFlg(JSPUtil.getParameter(request, prefix + "sealer_cd_flg", ""));
        setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
        setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
        setBkgPodCd(JSPUtil.getParameter(request, prefix + "bkg_pod_cd", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setTrsmMsgTpId(JSPUtil.getParameter(request, prefix + "trsm_msg_tp_id", ""));
        setShprAddr(JSPUtil.getParameter(request, prefix + "shpr_addr", ""));
        setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
        setMfSndDt(JSPUtil.getParameter(request, prefix + "mf_snd_dt", ""));
        setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
        setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
        setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
        setShprNm(JSPUtil.getParameter(request, prefix + "shpr_nm", ""));
        setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
        setPrePort(JSPUtil.getParameter(request, prefix + "pre_port", ""));
        setNtfyAddr(JSPUtil.getParameter(request, prefix + "ntfy_addr", ""));
        setBkgPolCd(JSPUtil.getParameter(request, prefix + "bkg_pol_cd", ""));
        setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
        setCallSgnNo(JSPUtil.getParameter(request, prefix + "call_sgn_no", ""));
        setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
        setCntrCnt(JSPUtil.getParameter(request, prefix + "cntr_cnt", ""));
        setNtfyNm(JSPUtil.getParameter(request, prefix + "ntfy_nm", ""));
        setNxtPort(JSPUtil.getParameter(request, prefix + "nxt_port", ""));
        setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
        setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setTransMode(JSPUtil.getParameter(request, prefix + "trans_mode", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setCneeNm(JSPUtil.getParameter(request, prefix + "cnee_nm", ""));
        setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
        setSealNoFlg(JSPUtil.getParameter(request, prefix + "seal_no_flg", ""));
        setSealKndFlg(JSPUtil.getParameter(request, prefix + "seal_knd_flg", ""));
        setEtdFlg(JSPUtil.getParameter(request, prefix + "etd_flg", ""));
        setMeaQty(JSPUtil.getParameter(request, prefix + "mea_qty", ""));
        setCntcPsonNm(JSPUtil.getParameter(request, prefix + "cntc_pson_nm", ""));
        setCntcPsonTelcmNo(JSPUtil.getParameter(request, prefix + "cntc_pson_telcm_no", ""));
        setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
        setFrtTermCd(JSPUtil.getParameter(request, prefix + "frt_term_cd", ""));
        setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
        setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
        setBlMkDesc(JSPUtil.getParameter(request, prefix + "bl_mk_desc", ""));
        setCmPckQty(JSPUtil.getParameter(request, prefix + "cm_pck_qty", ""));
        setCmPckTpCd(JSPUtil.getParameter(request, prefix + "cm_pck_tp_cd", ""));
        setCmCntrMfWgt(JSPUtil.getParameter(request, prefix + "cm_cntr_mf_wgt", ""));
        setShprRgstNo(JSPUtil.getParameter(request, prefix + "shpr_rgst_no", ""));
        setCneeRgstNo(JSPUtil.getParameter(request, prefix + "cnee_rgst_no", ""));
        setNtfyRgstNo(JSPUtil.getParameter(request, prefix + "ntfy_rgst_no", ""));
        setShprCnt(JSPUtil.getParameter(request, prefix + "shpr_cnt", ""));
        setShprStPo(JSPUtil.getParameter(request, prefix + "shpr_st_po", ""));
        setShprFax(JSPUtil.getParameter(request, prefix + "shpr_fax", ""));
        setShprEml(JSPUtil.getParameter(request, prefix + "shpr_eml", ""));
        setShprPhn(JSPUtil.getParameter(request, prefix + "shpr_phn", ""));
        setCneeCnt(JSPUtil.getParameter(request, prefix + "cnee_cnt", ""));
        setCneeStPo(JSPUtil.getParameter(request, prefix + "cnee_st_po", ""));
        setCneeFax(JSPUtil.getParameter(request, prefix + "cnee_fax", ""));
        setCneeEml(JSPUtil.getParameter(request, prefix + "cnee_eml", ""));
        setCneePhn(JSPUtil.getParameter(request, prefix + "cnee_phn", ""));
        setNtfyCnt(JSPUtil.getParameter(request, prefix + "ntfy_cnt", ""));
        setNtfyStPo(JSPUtil.getParameter(request, prefix + "ntfy_st_po", ""));
        setNtfyFax(JSPUtil.getParameter(request, prefix + "ntfy_fax", ""));
        setNtfyEml(JSPUtil.getParameter(request, prefix + "ntfy_eml", ""));
        setNtfyPhn(JSPUtil.getParameter(request, prefix + "ntfy_phn", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChinaBlInfoListVO[]
	 */
    public ChinaBlInfoListVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChinaBlInfoListVO[]
	 */
    public ChinaBlInfoListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ChinaBlInfoListVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] total = (JSPUtil.getParameter(request, prefix + "total", length));
            String[] etaFlg = (JSPUtil.getParameter(request, prefix + "eta_flg", length));
            String[] sndDate = (JSPUtil.getParameter(request, prefix + "snd_date", length));
            String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix + "vps_etb_dt", length));
            String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", length));
            String[] cneeAddr = (JSPUtil.getParameter(request, prefix + "cnee_addr", length));
            String[] tr = (JSPUtil.getParameter(request, prefix + "tr", length));
            String[] sealerCdFlg = (JSPUtil.getParameter(request, prefix + "sealer_cd_flg", length));
            String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix + "vps_eta_dt", length));
            String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] locCd = (JSPUtil.getParameter(request, prefix + "loc_cd", length));
            String[] bkgPodCd = (JSPUtil.getParameter(request, prefix + "bkg_pod_cd", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] trsmMsgTpId = (JSPUtil.getParameter(request, prefix + "trsm_msg_tp_id", length));
            String[] shprAddr = (JSPUtil.getParameter(request, prefix + "shpr_addr", length));
            String[] vslEngNm = (JSPUtil.getParameter(request, prefix + "vsl_eng_nm", length));
            String[] mfSndDt = (JSPUtil.getParameter(request, prefix + "mf_snd_dt", length));
            String[] wgtUtCd = (JSPUtil.getParameter(request, prefix + "wgt_ut_cd", length));
            String[] dcgoFlg = (JSPUtil.getParameter(request, prefix + "dcgo_flg", length));
            String[] pckQty = (JSPUtil.getParameter(request, prefix + "pck_qty", length));
            String[] shprNm = (JSPUtil.getParameter(request, prefix + "shpr_nm", length));
            String[] pckTpCd = (JSPUtil.getParameter(request, prefix + "pck_tp_cd", length));
            String[] prePort = (JSPUtil.getParameter(request, prefix + "pre_port", length));
            String[] ntfyAddr = (JSPUtil.getParameter(request, prefix + "ntfy_addr", length));
            String[] bkgPolCd = (JSPUtil.getParameter(request, prefix + "bkg_pol_cd", length));
            String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix + "vps_etd_dt", length));
            String[] callSgnNo = (JSPUtil.getParameter(request, prefix + "call_sgn_no", length));
            String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
            String[] cntrCnt = (JSPUtil.getParameter(request, prefix + "cntr_cnt", length));
            String[] ntfyNm = (JSPUtil.getParameter(request, prefix + "ntfy_nm", length));
            String[] nxtPort = (JSPUtil.getParameter(request, prefix + "nxt_port", length));
            String[] actWgt = (JSPUtil.getParameter(request, prefix + "act_wgt", length));
            String[] vvd = (JSPUtil.getParameter(request, prefix + "vvd", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] transMode = (JSPUtil.getParameter(request, prefix + "trans_mode", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] cneeNm = (JSPUtil.getParameter(request, prefix + "cnee_nm", length));
            String[] rcFlg = (JSPUtil.getParameter(request, prefix + "rc_flg", length));
            String[] sealNoFlg = (JSPUtil.getParameter(request, prefix + "seal_no_flg", length));
            String[] sealKndFlg = (JSPUtil.getParameter(request, prefix + "seal_knd_flg", length));
            String[] etdFlg = (JSPUtil.getParameter(request, prefix + "etd_flg", length));
            String[] meaQty = (JSPUtil.getParameter(request, prefix + "mea_qty".trim(), length));
            String[] cntcPsonNm = (JSPUtil.getParameter(request, prefix + "cntc_pson_nm".trim(), length));
            String[] cntcPsonTelcmNo = (JSPUtil.getParameter(request, prefix + "cntc_pson_telcm_no".trim(), length));
            String[] imdgUnNo = (JSPUtil.getParameter(request, prefix + "imdg_un_no".trim(), length));
            String[] frtTermCd = (JSPUtil.getParameter(request, prefix + "frt_term_cd".trim(), length));
            String[] rcvTermCd = (JSPUtil.getParameter(request, prefix + "rcv_term_cd".trim(), length));
            String[] deTermCd = (JSPUtil.getParameter(request, prefix + "de_term_cd".trim(), length));
            String[] blMkDesc = (JSPUtil.getParameter(request, prefix + "bl_mk_desc".trim(), length));
            String[] cmPckQty = (JSPUtil.getParameter(request, prefix + "cm_pck_qty".trim(), length));
            String[] cmPckTpCd = (JSPUtil.getParameter(request, prefix + "cm_pck_tp_cd".trim(), length));
            String[] cmCntrMfWgt = (JSPUtil.getParameter(request, prefix + "cm_cntr_mf_wgt".trim(), length));
            String[] shprRgstNo = (JSPUtil.getParameter(request, prefix + "shpr_rgst_no", length));
            String[] cneeRgstNo = (JSPUtil.getParameter(request, prefix + "cnee_rgst_no", length));
            String[] ntfyRgstNo = (JSPUtil.getParameter(request, prefix + "ntfy_rgst_no", length));
            String[] shprCnt = (JSPUtil.getParameter(request, prefix + "shpr_cnt", length));
	    	String[] shprStPo = (JSPUtil.getParameter(request, prefix + "shpr_st_po", length));
	    	String[] shprFax = (JSPUtil.getParameter(request, prefix + "shpr_fax", length));
	    	String[] shprEml = (JSPUtil.getParameter(request, prefix + "shpr_eml", length));
	    	String[] shprPhn = (JSPUtil.getParameter(request, prefix + "shpr_phn", length));
	    	String[] cneeCnt = (JSPUtil.getParameter(request, prefix + "cnee_cnt", length));
	    	String[] cneeStPo = (JSPUtil.getParameter(request, prefix + "cnee_st_po", length));
	    	String[] cneeFax = (JSPUtil.getParameter(request, prefix + "cnee_fax", length));
	    	String[] cneeEml = (JSPUtil.getParameter(request, prefix + "cnee_eml", length));
	    	String[] cneePhn = (JSPUtil.getParameter(request, prefix + "cnee_phn", length));
	    	String[] ntfyCnt = (JSPUtil.getParameter(request, prefix + "ntfy_cnt", length));
	    	String[] ntfyStPo = (JSPUtil.getParameter(request, prefix + "ntfy_st_po", length));
	    	String[] ntfyFax = (JSPUtil.getParameter(request, prefix + "ntfy_fax", length));
	    	String[] ntfyEml = (JSPUtil.getParameter(request, prefix + "ntfy_eml", length));
	    	String[] ntfyPhn = (JSPUtil.getParameter(request, prefix + "ntfy_phn", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new ChinaBlInfoListVO();
                if (total[i] != null)
                    model.setTotal(total[i]);
                if (etaFlg[i] != null)
                    model.setEtaFlg(etaFlg[i]);
                if (sndDate[i] != null)
                    model.setSndDate(sndDate[i]);
                if (vpsEtbDt[i] != null)
                    model.setVpsEtbDt(vpsEtbDt[i]);
                if (bkgCgoTpCd[i] != null)
                    model.setBkgCgoTpCd(bkgCgoTpCd[i]);
                if (cneeAddr[i] != null)
                    model.setCneeAddr(cneeAddr[i]);
                if (tr[i] != null)
                    model.setTr(tr[i]);
                if (sealerCdFlg[i] != null)
                    model.setSealerCdFlg(sealerCdFlg[i]);
                if (vpsEtaDt[i] != null)
                    model.setVpsEtaDt(vpsEtaDt[i]);
                if (blNo[i] != null)
                    model.setBlNo(blNo[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (locCd[i] != null)
                    model.setLocCd(locCd[i]);
                if (bkgPodCd[i] != null)
                    model.setBkgPodCd(bkgPodCd[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (trsmMsgTpId[i] != null)
                    model.setTrsmMsgTpId(trsmMsgTpId[i]);
                if (shprAddr[i] != null)
                    model.setShprAddr(shprAddr[i]);
                if (vslEngNm[i] != null)
                    model.setVslEngNm(vslEngNm[i]);
                if (mfSndDt[i] != null)
                    model.setMfSndDt(mfSndDt[i]);
                if (wgtUtCd[i] != null)
                    model.setWgtUtCd(wgtUtCd[i]);
                if (dcgoFlg[i] != null)
                    model.setDcgoFlg(dcgoFlg[i]);
                if (pckQty[i] != null)
                    model.setPckQty(pckQty[i]);
                if (shprNm[i] != null)
                    model.setShprNm(shprNm[i]);
                if (pckTpCd[i] != null)
                    model.setPckTpCd(pckTpCd[i]);
                if (prePort[i] != null)
                    model.setPrePort(prePort[i]);
                if (ntfyAddr[i] != null)
                    model.setNtfyAddr(ntfyAddr[i]);
                if (bkgPolCd[i] != null)
                    model.setBkgPolCd(bkgPolCd[i]);
                if (vpsEtdDt[i] != null)
                    model.setVpsEtdDt(vpsEtdDt[i]);
                if (callSgnNo[i] != null)
                    model.setCallSgnNo(callSgnNo[i]);
                if (delCd[i] != null)
                    model.setDelCd(delCd[i]);
                if (cntrCnt[i] != null)
                    model.setCntrCnt(cntrCnt[i]);
                if (ntfyNm[i] != null)
                    model.setNtfyNm(ntfyNm[i]);
                if (nxtPort[i] != null)
                    model.setNxtPort(nxtPort[i]);
                if (actWgt[i] != null)
                    model.setActWgt(actWgt[i]);
                if (vvd[i] != null)
                    model.setVvd(vvd[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (transMode[i] != null)
                    model.setTransMode(transMode[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (cneeNm[i] != null)
                    model.setCneeNm(cneeNm[i]);
                if (rcFlg[i] != null)
                    model.setRcFlg(rcFlg[i]);
                if (sealNoFlg[i] != null)
                    model.setSealNoFlg(sealNoFlg[i]);
                if (sealKndFlg[i] != null)
                    model.setSealKndFlg(sealKndFlg[i]);
                if (etdFlg[i] != null)
                    model.setEtdFlg(etdFlg[i]);
                if (meaQty[i] != null)
                    model.setMeaQty(meaQty[i]);
                if (cntcPsonNm[i] != null)
                    model.setCntcPsonNm(cntcPsonNm[i]);
                if (cntcPsonTelcmNo[i] != null)
                    model.setCntcPsonTelcmNo(cntcPsonTelcmNo[i]);
                if (imdgUnNo[i] != null)
                    model.setImdgUnNo(imdgUnNo[i]);
                if (frtTermCd[i] != null)
                    model.setFrtTermCd(frtTermCd[i]);
                if (rcvTermCd[i] != null)
                    model.setRcvTermCd(rcvTermCd[i]);
                if (deTermCd[i] != null)
                    model.setDeTermCd(deTermCd[i]);
                if (blMkDesc[i] != null)
                    model.setBlMkDesc(blMkDesc[i]);
                if (cmPckQty[i] != null)
                    model.setCmPckQty(cmPckQty[i]);
                if (cmPckTpCd[i] != null)
                    model.setCmPckTpCd(cmPckTpCd[i]);
                if (cmCntrMfWgt[i] != null)
                    model.setCmCntrMfWgt(cmCntrMfWgt[i]);
                if (shprRgstNo[i] != null)
                    model.setShprRgstNo(shprRgstNo[i]);
                if (cneeRgstNo[i] != null)
                    model.setCneeRgstNo(cneeRgstNo[i]);
                if (ntfyRgstNo[i] != null)
                    model.setNtfyRgstNo(ntfyRgstNo[i]);
                if (shprCnt[i] != null) 
		    		model.setShprCnt(shprCnt[i]);
				if (shprStPo[i] != null) 
		    		model.setShprStPo(shprStPo[i]);
				if (shprFax[i] != null) 
		    		model.setShprFax(shprFax[i]);
				if (shprEml[i] != null) 
		    		model.setShprEml(shprEml[i]);
				if (shprPhn[i] != null) 
		    		model.setShprPhn(shprPhn[i]);
				if (cneeCnt[i] != null) 
		    		model.setCneeCnt(cneeCnt[i]);
				if (cneeStPo[i] != null) 
		    		model.setCneeStPo(cneeStPo[i]);
				if (cneeFax[i] != null) 
		    		model.setCneeFax(cneeFax[i]);
				if (cneeEml[i] != null) 
		    		model.setCneeEml(cneeEml[i]);
				if (cneePhn[i] != null) 
		    		model.setCneePhn(cneePhn[i]);
				if (ntfyCnt[i] != null) 
		    		model.setNtfyCnt(ntfyCnt[i]);
				if (ntfyStPo[i] != null) 
		    		model.setNtfyStPo(ntfyStPo[i]);
				if (ntfyFax[i] != null) 
		    		model.setNtfyFax(ntfyFax[i]);
				if (ntfyEml[i] != null) 
		    		model.setNtfyEml(ntfyEml[i]);
				if (ntfyPhn[i] != null) 
		    		model.setNtfyPhn(ntfyPhn[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getChinaBlInfoListVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return ChinaBlInfoListVO[]
	 */
    public ChinaBlInfoListVO[] getChinaBlInfoListVOs() {
        ChinaBlInfoListVO[] vos = (ChinaBlInfoListVO[]) models.toArray(new ChinaBlInfoListVO[models.size()]);
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
        this.total = this.total.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.etaFlg = this.etaFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sndDate = this.sndDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsEtbDt = this.vpsEtbDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCgoTpCd = this.bkgCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneeAddr = this.cneeAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tr = this.tr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sealerCdFlg = this.sealerCdFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsEtaDt = this.vpsEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locCd = this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgPodCd = this.bkgPodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trsmMsgTpId = this.trsmMsgTpId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shprAddr = this.shprAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslEngNm = this.vslEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mfSndDt = this.mfSndDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.wgtUtCd = this.wgtUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoFlg = this.dcgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckQty = this.pckQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shprNm = this.shprNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckTpCd = this.pckTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prePort = this.prePort.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfyAddr = this.ntfyAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgPolCd = this.bkgPolCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsEtdDt = this.vpsEtdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.callSgnNo = this.callSgnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrCnt = this.cntrCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfyNm = this.ntfyNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nxtPort = this.nxtPort.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actWgt = this.actWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvd = this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.transMode = this.transMode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneeNm = this.cneeNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcFlg = this.rcFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sealNoFlg = this.sealNoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sealKndFlg = this.sealKndFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.etdFlg = this.etdFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.meaQty = this.meaQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntcPsonNm = this.cntcPsonNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntcPsonTelcmNo = this.cntcPsonTelcmNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgUnNo = this.imdgUnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frtTermCd = this.frtTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvTermCd = this.rcvTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deTermCd = this.deTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blMkDesc = this.blMkDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmPckQty = this.cmPckQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmPckTpCd = this.cmPckTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmCntrMfWgt = this.cmCntrMfWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shprRgstNo = this.shprRgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneeRgstNo = this.cneeRgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfyRgstNo = this.ntfyRgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shprCnt = this.shprCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shprStPo = this.shprStPo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shprFax = this.shprFax.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shprEml = this.shprEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shprPhn = this.shprPhn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneeCnt = this.cneeCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneeStPo = this.cneeStPo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneeFax = this.cneeFax.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneeEml = this.cneeEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneePhn = this.cneePhn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfyCnt = this.ntfyCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfyStPo = this.ntfyStPo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfyFax = this.ntfyFax.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfyEml = this.ntfyEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntfyPhn = this.ntfyPhn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
