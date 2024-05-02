/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ContainerVesselIfVO.java
*@FileTitle : ContainerVesselIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.06
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.asset.vo;
 
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
public class ContainerVesselIfVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<ContainerVesselIfVO> models = new ArrayList<ContainerVesselIfVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String vslCntrIfSeq = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String vslClssFlg = null;

    /* Column Info */
    private String vslEngNm = null;

    /* Column Info */
    private String vslLoclNm = null;

    /* Column Info */
    private String foilCapa = null;

    /* Column Info */
    private String doilCapa = null;

    /* Column Info */
    private String frshWtrCapa = null;

    /* Column Info */
    private String callSgnNo = null;

    /* Column Info */
    private String rgstNo = null;

    /* Column Info */
    private String phnNo = null;

    /* Column Info */
    private String faxNo = null;

    /* Column Info */
    private String tlxNo = null;

    /* Column Info */
    private String vslEml = null;

    /* Column Info */
    private String piclbDesc = null;

    /* Column Info */
    private String rgstPortCd = null;

    /* Column Info */
    private String clssNoRgstAreaNm = null;

    /* Column Info */
    private String vslClssNo = null;

    /* Column Info */
    private String vslBldrNm = null;

    /* Column Info */
    private String loaLen = null;

    /* Column Info */
    private String lbpLen = null;

    /* Column Info */
    private String vslWdt = null;

    /* Column Info */
    private String vslDpth = null;

    /* Column Info */
    private String smrDrftHgt = null;

    /* Column Info */
    private String dwtWgt = null;

    /* Column Info */
    private String lgtShpTongWgt = null;

    /* Column Info */
    private String grsRgstTongWgt = null;

    /* Column Info */
    private String netRgstTongWgt = null;

    /* Column Info */
    private String pnmGtWgt = null;

    /* Column Info */
    private String pnmNetTongWgt = null;

    /* Column Info */
    private String suzGtWgt = null;

    /* Column Info */
    private String suzNetTongWgt = null;

    /* Column Info */
    private String mnEngMkrNm = null;

    /* Column Info */
    private String mnEngTpDesc = null;

    /* Column Info */
    private String mnEngBhpPwr = null;

    /* Column Info */
    private String vslOwnIndCd = null;

    /* Column Info */
    private String vslRgstCntCd = null;

    /* Column Info */
    private String vslBldCd = null;

    /* Column Info */
    private String crrCd = null;

    /* Column Info */
    private String fdrDivCd = null;

    /* Column Info */
    private String vslSvcSpd = null;

    /* Column Info */
    private String maxSpd = null;

    /* Column Info */
    private String ecnSpd = null;

    /* Column Info */
    private String crwKnt = null;

    /* Column Info */
    private String cntrDznCapa = null;

    /* Column Info */
    private String cntrOpCapa = null;

    /* Column Info */
    private String cntrPnmCapa = null;

    /* Column Info */
    private String cntrVslClssCapa = null;

    /* Column Info */
    private String rfRcptKnt = null;

    /* Column Info */
    private String rfRcptMaxKnt = null;

    /* Column Info */
    private String fbdCapa = null;

    /* Column Info */
    private String dplCapa = null;

    /* Column Info */
    private String blstTnkCapa = null;

    /* Column Info */
    private String foilCsm = null;

    /* Column Info */
    private String doilCsm = null;

    /* Column Info */
    private String frshWtrCsm = null;

    /* Column Info */
    private String mnEngRpmPwr = null;

    /* Column Info */
    private String gnrRpmPwr = null;

    /* Column Info */
    private String vslHgt = null;

    /* Column Info */
    private String rgstDt = null;

    /* Column Info */
    private String vslEdiNm = null;

    /* Column Info */
    private String coCd = null;

    /* Column Info */
    private String vslClzDt = null;

    /* Column Info */
    private String vslCreOfcCd = null;

    /* Column Info */
    private String vslDeltOfcCd = null;

    /* Column Info */
    private String vslBldAreaNm = null;

    /* Column Info */
    private String gnrMkrNm = null;

    /* Column Info */
    private String gnrTpDesc = null;

    /* Column Info */
    private String gnrBhpPwr = null;

    /* Column Info */
    private String bwthstMkrNm = null;

    /* Column Info */
    private String bwthstTpDesc = null;

    /* Column Info */
    private String bwthstBhpPwr = null;

    /* Column Info */
    private String bwthstRpmPwr = null;

    /* Column Info */
    private String lloydNo = null;

    /* Column Info */
    private String vslLnchDt = null;

    /* Column Info */
    private String vslDeDt = null;

    /* Column Info */
    private String vslKelLyDt = null;

    /* Column Info */
    private String vslHlNo = null;

    /* Column Info */
    private String ttlTeuKnt = null;

    /* Column Info */
    private String vslHtchKnt = null;

    /* Column Info */
    private String vslHldKnt = null;

    /* Column Info */
    private String vslRmk = null;

    /* Column Info */
    private String intlTongCertiFlg = null;

    /* Column Info */
    private String madnVoySuzNetTongWgt = null;

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
    private String eaiEvntDt = null;

    /* Column Info */
    private String eaiIfId = null;

    /* Column Info */
    private String modiVslCd = null;

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
    private String modiVslOprTpCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public ContainerVesselIfVO() {
    }

    public ContainerVesselIfVO(String ibflag, String pagerows, String vslCntrIfSeq, String vslCd, String vslClssFlg, String vslEngNm, String vslLoclNm, String foilCapa, String doilCapa, String frshWtrCapa, String callSgnNo, String rgstNo, String phnNo, String faxNo, String tlxNo, String vslEml, String piclbDesc, String rgstPortCd, String clssNoRgstAreaNm, String vslClssNo, String vslBldrNm, String loaLen, String lbpLen, String vslWdt, String vslDpth, String smrDrftHgt, String dwtWgt, String lgtShpTongWgt, String grsRgstTongWgt, String netRgstTongWgt, String pnmGtWgt, String pnmNetTongWgt, String suzGtWgt, String suzNetTongWgt, String mnEngMkrNm, String mnEngTpDesc, String mnEngBhpPwr, String vslOwnIndCd, String vslRgstCntCd, String vslBldCd, String crrCd, String fdrDivCd, String vslSvcSpd, String maxSpd, String ecnSpd, String crwKnt, String cntrDznCapa, String cntrOpCapa, String cntrPnmCapa, String cntrVslClssCapa, String rfRcptKnt, String rfRcptMaxKnt, String fbdCapa, String dplCapa, String blstTnkCapa, String foilCsm, String doilCsm, String frshWtrCsm, String mnEngRpmPwr, String gnrRpmPwr, String vslHgt, String rgstDt, String vslEdiNm, String coCd, String vslClzDt, String vslCreOfcCd, String vslDeltOfcCd, String vslBldAreaNm, String gnrMkrNm, String gnrTpDesc, String gnrBhpPwr, String bwthstMkrNm, String bwthstTpDesc, String bwthstBhpPwr, String bwthstRpmPwr, String lloydNo, String vslLnchDt, String vslDeDt, String vslKelLyDt, String vslHlNo, String ttlTeuKnt, String vslHtchKnt, String vslHldKnt, String vslRmk, String intlTongCertiFlg, String madnVoySuzNetTongWgt, String creUsrId, String creDt, String updUsrId, String updDt, String deltFlg, String eaiEvntDt, String eaiIfId, String modiVslCd, String insfId, String insfPrsId, String insfDttm, String insfCnqeVal, String insfDvCd, String insfCnqeCont, String ecomInsfId, String ecomInsfPrsId, String ecomInsfDttm, String ecomInsfCnqeVal, String ecomInsfDvCd, String ecomInsfCnqeCont, String ocediInsfId, String ocediInsfPrsId, String ocediInsfDttm, String ocediInsfCnqeVal, String ocediInsfDvCd, String ocediInsfCnqeCont, String modiVslOprTpCd) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.vslCntrIfSeq = vslCntrIfSeq;
        this.vslCd = vslCd;
        this.vslClssFlg = vslClssFlg;
        this.vslEngNm = vslEngNm;
        this.vslLoclNm = vslLoclNm;
        this.foilCapa = foilCapa;
        this.doilCapa = doilCapa;
        this.frshWtrCapa = frshWtrCapa;
        this.callSgnNo = callSgnNo;
        this.rgstNo = rgstNo;
        this.phnNo = phnNo;
        this.faxNo = faxNo;
        this.tlxNo = tlxNo;
        this.vslEml = vslEml;
        this.piclbDesc = piclbDesc;
        this.rgstPortCd = rgstPortCd;
        this.clssNoRgstAreaNm = clssNoRgstAreaNm;
        this.vslClssNo = vslClssNo;
        this.vslBldrNm = vslBldrNm;
        this.loaLen = loaLen;
        this.lbpLen = lbpLen;
        this.vslWdt = vslWdt;
        this.vslDpth = vslDpth;
        this.smrDrftHgt = smrDrftHgt;
        this.dwtWgt = dwtWgt;
        this.lgtShpTongWgt = lgtShpTongWgt;
        this.grsRgstTongWgt = grsRgstTongWgt;
        this.netRgstTongWgt = netRgstTongWgt;
        this.pnmGtWgt = pnmGtWgt;
        this.pnmNetTongWgt = pnmNetTongWgt;
        this.suzGtWgt = suzGtWgt;
        this.suzNetTongWgt = suzNetTongWgt;
        this.mnEngMkrNm = mnEngMkrNm;
        this.mnEngTpDesc = mnEngTpDesc;
        this.mnEngBhpPwr = mnEngBhpPwr;
        this.vslOwnIndCd = vslOwnIndCd;
        this.vslRgstCntCd = vslRgstCntCd;
        this.vslBldCd = vslBldCd;
        this.crrCd = crrCd;
        this.fdrDivCd = fdrDivCd;
        this.vslSvcSpd = vslSvcSpd;
        this.maxSpd = maxSpd;
        this.ecnSpd = ecnSpd;
        this.crwKnt = crwKnt;
        this.cntrDznCapa = cntrDznCapa;
        this.cntrOpCapa = cntrOpCapa;
        this.cntrPnmCapa = cntrPnmCapa;
        this.cntrVslClssCapa = cntrVslClssCapa;
        this.rfRcptKnt = rfRcptKnt;
        this.rfRcptMaxKnt = rfRcptMaxKnt;
        this.fbdCapa = fbdCapa;
        this.dplCapa = dplCapa;
        this.blstTnkCapa = blstTnkCapa;
        this.foilCsm = foilCsm;
        this.doilCsm = doilCsm;
        this.frshWtrCsm = frshWtrCsm;
        this.mnEngRpmPwr = mnEngRpmPwr;
        this.gnrRpmPwr = gnrRpmPwr;
        this.vslHgt = vslHgt;
        this.rgstDt = rgstDt;
        this.vslEdiNm = vslEdiNm;
        this.coCd = coCd;
        this.vslClzDt = vslClzDt;
        this.vslCreOfcCd = vslCreOfcCd;
        this.vslDeltOfcCd = vslDeltOfcCd;
        this.vslBldAreaNm = vslBldAreaNm;
        this.gnrMkrNm = gnrMkrNm;
        this.gnrTpDesc = gnrTpDesc;
        this.gnrBhpPwr = gnrBhpPwr;
        this.bwthstMkrNm = bwthstMkrNm;
        this.bwthstTpDesc = bwthstTpDesc;
        this.bwthstBhpPwr = bwthstBhpPwr;
        this.bwthstRpmPwr = bwthstRpmPwr;
        this.lloydNo = lloydNo;
        this.vslLnchDt = vslLnchDt;
        this.vslDeDt = vslDeDt;
        this.vslKelLyDt = vslKelLyDt;
        this.vslHlNo = vslHlNo;
        this.ttlTeuKnt = ttlTeuKnt;
        this.vslHtchKnt = vslHtchKnt;
        this.vslHldKnt = vslHldKnt;
        this.vslRmk = vslRmk;
        this.intlTongCertiFlg = intlTongCertiFlg;
        this.madnVoySuzNetTongWgt = madnVoySuzNetTongWgt;
        this.creUsrId = creUsrId;
        this.creDt = creDt;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.deltFlg = deltFlg;
        this.eaiEvntDt = eaiEvntDt;
        this.eaiIfId = eaiIfId;
        this.modiVslCd = modiVslCd;
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
        this.modiVslOprTpCd = modiVslOprTpCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("vsl_cntr_if_seq", getVslCntrIfSeq());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("vsl_clss_flg", getVslClssFlg());
        this.hashColumns.put("vsl_eng_nm", getVslEngNm());
        this.hashColumns.put("vsl_locl_nm", getVslLoclNm());
        this.hashColumns.put("foil_capa", getFoilCapa());
        this.hashColumns.put("doil_capa", getDoilCapa());
        this.hashColumns.put("frsh_wtr_capa", getFrshWtrCapa());
        this.hashColumns.put("call_sgn_no", getCallSgnNo());
        this.hashColumns.put("rgst_no", getRgstNo());
        this.hashColumns.put("phn_no", getPhnNo());
        this.hashColumns.put("fax_no", getFaxNo());
        this.hashColumns.put("tlx_no", getTlxNo());
        this.hashColumns.put("vsl_eml", getVslEml());
        this.hashColumns.put("piclb_desc", getPiclbDesc());
        this.hashColumns.put("rgst_port_cd", getRgstPortCd());
        this.hashColumns.put("clss_no_rgst_area_nm", getClssNoRgstAreaNm());
        this.hashColumns.put("vsl_clss_no", getVslClssNo());
        this.hashColumns.put("vsl_bldr_nm", getVslBldrNm());
        this.hashColumns.put("loa_len", getLoaLen());
        this.hashColumns.put("lbp_len", getLbpLen());
        this.hashColumns.put("vsl_wdt", getVslWdt());
        this.hashColumns.put("vsl_dpth", getVslDpth());
        this.hashColumns.put("smr_drft_hgt", getSmrDrftHgt());
        this.hashColumns.put("dwt_wgt", getDwtWgt());
        this.hashColumns.put("lgt_shp_tong_wgt", getLgtShpTongWgt());
        this.hashColumns.put("grs_rgst_tong_wgt", getGrsRgstTongWgt());
        this.hashColumns.put("net_rgst_tong_wgt", getNetRgstTongWgt());
        this.hashColumns.put("pnm_gt_wgt", getPnmGtWgt());
        this.hashColumns.put("pnm_net_tong_wgt", getPnmNetTongWgt());
        this.hashColumns.put("suz_gt_wgt", getSuzGtWgt());
        this.hashColumns.put("suz_net_tong_wgt", getSuzNetTongWgt());
        this.hashColumns.put("mn_eng_mkr_nm", getMnEngMkrNm());
        this.hashColumns.put("mn_eng_tp_desc", getMnEngTpDesc());
        this.hashColumns.put("mn_eng_bhp_pwr", getMnEngBhpPwr());
        this.hashColumns.put("vsl_own_ind_cd", getVslOwnIndCd());
        this.hashColumns.put("vsl_rgst_cnt_cd", getVslRgstCntCd());
        this.hashColumns.put("vsl_bld_cd", getVslBldCd());
        this.hashColumns.put("crr_cd", getCrrCd());
        this.hashColumns.put("fdr_div_cd", getFdrDivCd());
        this.hashColumns.put("vsl_svc_spd", getVslSvcSpd());
        this.hashColumns.put("max_spd", getMaxSpd());
        this.hashColumns.put("ecn_spd", getEcnSpd());
        this.hashColumns.put("crw_knt", getCrwKnt());
        this.hashColumns.put("cntr_dzn_capa", getCntrDznCapa());
        this.hashColumns.put("cntr_op_capa", getCntrOpCapa());
        this.hashColumns.put("cntr_pnm_capa", getCntrPnmCapa());
        this.hashColumns.put("cntr_vsl_clss_capa", getCntrVslClssCapa());
        this.hashColumns.put("rf_rcpt_knt", getRfRcptKnt());
        this.hashColumns.put("rf_rcpt_max_knt", getRfRcptMaxKnt());
        this.hashColumns.put("fbd_capa", getFbdCapa());
        this.hashColumns.put("dpl_capa", getDplCapa());
        this.hashColumns.put("blst_tnk_capa", getBlstTnkCapa());
        this.hashColumns.put("foil_csm", getFoilCsm());
        this.hashColumns.put("doil_csm", getDoilCsm());
        this.hashColumns.put("frsh_wtr_csm", getFrshWtrCsm());
        this.hashColumns.put("mn_eng_rpm_pwr", getMnEngRpmPwr());
        this.hashColumns.put("gnr_rpm_pwr", getGnrRpmPwr());
        this.hashColumns.put("vsl_hgt", getVslHgt());
        this.hashColumns.put("rgst_dt", getRgstDt());
        this.hashColumns.put("vsl_edi_nm", getVslEdiNm());
        this.hashColumns.put("co_cd", getCoCd());
        this.hashColumns.put("vsl_clz_dt", getVslClzDt());
        this.hashColumns.put("vsl_cre_ofc_cd", getVslCreOfcCd());
        this.hashColumns.put("vsl_delt_ofc_cd", getVslDeltOfcCd());
        this.hashColumns.put("vsl_bld_area_nm", getVslBldAreaNm());
        this.hashColumns.put("gnr_mkr_nm", getGnrMkrNm());
        this.hashColumns.put("gnr_tp_desc", getGnrTpDesc());
        this.hashColumns.put("gnr_bhp_pwr", getGnrBhpPwr());
        this.hashColumns.put("bwthst_mkr_nm", getBwthstMkrNm());
        this.hashColumns.put("bwthst_tp_desc", getBwthstTpDesc());
        this.hashColumns.put("bwthst_bhp_pwr", getBwthstBhpPwr());
        this.hashColumns.put("bwthst_rpm_pwr", getBwthstRpmPwr());
        this.hashColumns.put("lloyd_no", getLloydNo());
        this.hashColumns.put("vsl_lnch_dt", getVslLnchDt());
        this.hashColumns.put("vsl_de_dt", getVslDeDt());
        this.hashColumns.put("vsl_kel_ly_dt", getVslKelLyDt());
        this.hashColumns.put("vsl_hl_no", getVslHlNo());
        this.hashColumns.put("ttl_teu_knt", getTtlTeuKnt());
        this.hashColumns.put("vsl_htch_knt", getVslHtchKnt());
        this.hashColumns.put("vsl_hld_knt", getVslHldKnt());
        this.hashColumns.put("vsl_rmk", getVslRmk());
        this.hashColumns.put("intl_tong_certi_flg", getIntlTongCertiFlg());
        this.hashColumns.put("madn_voy_suz_net_tong_wgt", getMadnVoySuzNetTongWgt());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("delt_flg", getDeltFlg());
        this.hashColumns.put("eai_evnt_dt", getEaiEvntDt());
        this.hashColumns.put("eai_if_id", getEaiIfId());
        this.hashColumns.put("modi_vsl_cd", getModiVslCd());
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
        this.hashColumns.put("modi_vsl_opr_tp_cd", getModiVslOprTpCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("vsl_cntr_if_seq", "vslCntrIfSeq");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("vsl_clss_flg", "vslClssFlg");
        this.hashFields.put("vsl_eng_nm", "vslEngNm");
        this.hashFields.put("vsl_locl_nm", "vslLoclNm");
        this.hashFields.put("foil_capa", "foilCapa");
        this.hashFields.put("doil_capa", "doilCapa");
        this.hashFields.put("frsh_wtr_capa", "frshWtrCapa");
        this.hashFields.put("call_sgn_no", "callSgnNo");
        this.hashFields.put("rgst_no", "rgstNo");
        this.hashFields.put("phn_no", "phnNo");
        this.hashFields.put("fax_no", "faxNo");
        this.hashFields.put("tlx_no", "tlxNo");
        this.hashFields.put("vsl_eml", "vslEml");
        this.hashFields.put("piclb_desc", "piclbDesc");
        this.hashFields.put("rgst_port_cd", "rgstPortCd");
        this.hashFields.put("clss_no_rgst_area_nm", "clssNoRgstAreaNm");
        this.hashFields.put("vsl_clss_no", "vslClssNo");
        this.hashFields.put("vsl_bldr_nm", "vslBldrNm");
        this.hashFields.put("loa_len", "loaLen");
        this.hashFields.put("lbp_len", "lbpLen");
        this.hashFields.put("vsl_wdt", "vslWdt");
        this.hashFields.put("vsl_dpth", "vslDpth");
        this.hashFields.put("smr_drft_hgt", "smrDrftHgt");
        this.hashFields.put("dwt_wgt", "dwtWgt");
        this.hashFields.put("lgt_shp_tong_wgt", "lgtShpTongWgt");
        this.hashFields.put("grs_rgst_tong_wgt", "grsRgstTongWgt");
        this.hashFields.put("net_rgst_tong_wgt", "netRgstTongWgt");
        this.hashFields.put("pnm_gt_wgt", "pnmGtWgt");
        this.hashFields.put("pnm_net_tong_wgt", "pnmNetTongWgt");
        this.hashFields.put("suz_gt_wgt", "suzGtWgt");
        this.hashFields.put("suz_net_tong_wgt", "suzNetTongWgt");
        this.hashFields.put("mn_eng_mkr_nm", "mnEngMkrNm");
        this.hashFields.put("mn_eng_tp_desc", "mnEngTpDesc");
        this.hashFields.put("mn_eng_bhp_pwr", "mnEngBhpPwr");
        this.hashFields.put("vsl_own_ind_cd", "vslOwnIndCd");
        this.hashFields.put("vsl_rgst_cnt_cd", "vslRgstCntCd");
        this.hashFields.put("vsl_bld_cd", "vslBldCd");
        this.hashFields.put("crr_cd", "crrCd");
        this.hashFields.put("fdr_div_cd", "fdrDivCd");
        this.hashFields.put("vsl_svc_spd", "vslSvcSpd");
        this.hashFields.put("max_spd", "maxSpd");
        this.hashFields.put("ecn_spd", "ecnSpd");
        this.hashFields.put("crw_knt", "crwKnt");
        this.hashFields.put("cntr_dzn_capa", "cntrDznCapa");
        this.hashFields.put("cntr_op_capa", "cntrOpCapa");
        this.hashFields.put("cntr_pnm_capa", "cntrPnmCapa");
        this.hashFields.put("cntr_vsl_clss_capa", "cntrVslClssCapa");
        this.hashFields.put("rf_rcpt_knt", "rfRcptKnt");
        this.hashFields.put("rf_rcpt_max_knt", "rfRcptMaxKnt");
        this.hashFields.put("fbd_capa", "fbdCapa");
        this.hashFields.put("dpl_capa", "dplCapa");
        this.hashFields.put("blst_tnk_capa", "blstTnkCapa");
        this.hashFields.put("foil_csm", "foilCsm");
        this.hashFields.put("doil_csm", "doilCsm");
        this.hashFields.put("frsh_wtr_csm", "frshWtrCsm");
        this.hashFields.put("mn_eng_rpm_pwr", "mnEngRpmPwr");
        this.hashFields.put("gnr_rpm_pwr", "gnrRpmPwr");
        this.hashFields.put("vsl_hgt", "vslHgt");
        this.hashFields.put("rgst_dt", "rgstDt");
        this.hashFields.put("vsl_edi_nm", "vslEdiNm");
        this.hashFields.put("co_cd", "coCd");
        this.hashFields.put("vsl_clz_dt", "vslClzDt");
        this.hashFields.put("vsl_cre_ofc_cd", "vslCreOfcCd");
        this.hashFields.put("vsl_delt_ofc_cd", "vslDeltOfcCd");
        this.hashFields.put("vsl_bld_area_nm", "vslBldAreaNm");
        this.hashFields.put("gnr_mkr_nm", "gnrMkrNm");
        this.hashFields.put("gnr_tp_desc", "gnrTpDesc");
        this.hashFields.put("gnr_bhp_pwr", "gnrBhpPwr");
        this.hashFields.put("bwthst_mkr_nm", "bwthstMkrNm");
        this.hashFields.put("bwthst_tp_desc", "bwthstTpDesc");
        this.hashFields.put("bwthst_bhp_pwr", "bwthstBhpPwr");
        this.hashFields.put("bwthst_rpm_pwr", "bwthstRpmPwr");
        this.hashFields.put("lloyd_no", "lloydNo");
        this.hashFields.put("vsl_lnch_dt", "vslLnchDt");
        this.hashFields.put("vsl_de_dt", "vslDeDt");
        this.hashFields.put("vsl_kel_ly_dt", "vslKelLyDt");
        this.hashFields.put("vsl_hl_no", "vslHlNo");
        this.hashFields.put("ttl_teu_knt", "ttlTeuKnt");
        this.hashFields.put("vsl_htch_knt", "vslHtchKnt");
        this.hashFields.put("vsl_hld_knt", "vslHldKnt");
        this.hashFields.put("vsl_rmk", "vslRmk");
        this.hashFields.put("intl_tong_certi_flg", "intlTongCertiFlg");
        this.hashFields.put("madn_voy_suz_net_tong_wgt", "madnVoySuzNetTongWgt");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("delt_flg", "deltFlg");
        this.hashFields.put("eai_evnt_dt", "eaiEvntDt");
        this.hashFields.put("eai_if_id", "eaiIfId");
        this.hashFields.put("modi_vsl_cd", "modiVslCd");
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
        this.hashFields.put("modi_vsl_opr_tp_cd", "modiVslOprTpCd");
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
	 * @param String vslCntrIfSeq
	 */
    public void setVslCntrIfSeq(String vslCntrIfSeq) {
        this.vslCntrIfSeq = vslCntrIfSeq;
    }

    /**
	 * 
	 * @return String vslCntrIfSeq
	 */
    public String getVslCntrIfSeq() {
        return this.vslCntrIfSeq;
    }

    /**
	 *
	 * @param String vslCd
	 */
    public void setVslCd(String vslCd) {
        this.vslCd = vslCd;
    }

    /**
	 * 
	 * @return String vslCd
	 */
    public String getVslCd() {
        return this.vslCd;
    }

    /**
	 *
	 * @param String vslClssFlg
	 */
    public void setVslClssFlg(String vslClssFlg) {
        this.vslClssFlg = vslClssFlg;
    }

    /**
	 * 
	 * @return String vslClssFlg
	 */
    public String getVslClssFlg() {
        return this.vslClssFlg;
    }

    /**
	 *
	 * @param String vslEngNm
	 */
    public void setVslEngNm(String vslEngNm) {
        this.vslEngNm = vslEngNm;
    }

    /**
	 * 
	 * @return String vslEngNm
	 */
    public String getVslEngNm() {
        return this.vslEngNm;
    }

    /**
	 *
	 * @param String vslLoclNm
	 */
    public void setVslLoclNm(String vslLoclNm) {
        this.vslLoclNm = vslLoclNm;
    }

    /**
	 * 
	 * @return String vslLoclNm
	 */
    public String getVslLoclNm() {
        return this.vslLoclNm;
    }

    /**
	 *
	 * @param String foilCapa
	 */
    public void setFoilCapa(String foilCapa) {
        this.foilCapa = foilCapa;
    }

    /**
	 * 
	 * @return String foilCapa
	 */
    public String getFoilCapa() {
        return this.foilCapa;
    }

    /**
	 *
	 * @param String doilCapa
	 */
    public void setDoilCapa(String doilCapa) {
        this.doilCapa = doilCapa;
    }

    /**
	 * 
	 * @return String doilCapa
	 */
    public String getDoilCapa() {
        return this.doilCapa;
    }

    /**
	 *
	 * @param String frshWtrCapa
	 */
    public void setFrshWtrCapa(String frshWtrCapa) {
        this.frshWtrCapa = frshWtrCapa;
    }

    /**
	 * 
	 * @return String frshWtrCapa
	 */
    public String getFrshWtrCapa() {
        return this.frshWtrCapa;
    }

    /**
	 *
	 * @param String callSgnNo
	 */
    public void setCallSgnNo(String callSgnNo) {
        this.callSgnNo = callSgnNo;
    }

    /**
	 * 
	 * @return String callSgnNo
	 */
    public String getCallSgnNo() {
        return this.callSgnNo;
    }

    /**
	 *
	 * @param String rgstNo
	 */
    public void setRgstNo(String rgstNo) {
        this.rgstNo = rgstNo;
    }

    /**
	 * 
	 * @return String rgstNo
	 */
    public String getRgstNo() {
        return this.rgstNo;
    }

    /**
	 *
	 * @param String phnNo
	 */
    public void setPhnNo(String phnNo) {
        this.phnNo = phnNo;
    }

    /**
	 * 
	 * @return String phnNo
	 */
    public String getPhnNo() {
        return this.phnNo;
    }

    /**
	 *
	 * @param String faxNo
	 */
    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }

    /**
	 * 
	 * @return String faxNo
	 */
    public String getFaxNo() {
        return this.faxNo;
    }

    /**
	 *
	 * @param String tlxNo
	 */
    public void setTlxNo(String tlxNo) {
        this.tlxNo = tlxNo;
    }

    /**
	 * 
	 * @return String tlxNo
	 */
    public String getTlxNo() {
        return this.tlxNo;
    }

    /**
	 *
	 * @param String vslEml
	 */
    public void setVslEml(String vslEml) {
        this.vslEml = vslEml;
    }

    /**
	 * 
	 * @return String vslEml
	 */
    public String getVslEml() {
        return this.vslEml;
    }

    /**
	 *
	 * @param String piclbDesc
	 */
    public void setPiclbDesc(String piclbDesc) {
        this.piclbDesc = piclbDesc;
    }

    /**
	 * 
	 * @return String piclbDesc
	 */
    public String getPiclbDesc() {
        return this.piclbDesc;
    }

    /**
	 *
	 * @param String rgstPortCd
	 */
    public void setRgstPortCd(String rgstPortCd) {
        this.rgstPortCd = rgstPortCd;
    }

    /**
	 * 
	 * @return String rgstPortCd
	 */
    public String getRgstPortCd() {
        return this.rgstPortCd;
    }

    /**
	 *
	 * @param String clssNoRgstAreaNm
	 */
    public void setClssNoRgstAreaNm(String clssNoRgstAreaNm) {
        this.clssNoRgstAreaNm = clssNoRgstAreaNm;
    }

    /**
	 * 
	 * @return String clssNoRgstAreaNm
	 */
    public String getClssNoRgstAreaNm() {
        return this.clssNoRgstAreaNm;
    }

    /**
	 *
	 * @param String vslClssNo
	 */
    public void setVslClssNo(String vslClssNo) {
        this.vslClssNo = vslClssNo;
    }

    /**
	 * 
	 * @return String vslClssNo
	 */
    public String getVslClssNo() {
        return this.vslClssNo;
    }

    /**
	 *
	 * @param String vslBldrNm
	 */
    public void setVslBldrNm(String vslBldrNm) {
        this.vslBldrNm = vslBldrNm;
    }

    /**
	 * 
	 * @return String vslBldrNm
	 */
    public String getVslBldrNm() {
        return this.vslBldrNm;
    }

    /**
	 *
	 * @param String loaLen
	 */
    public void setLoaLen(String loaLen) {
        this.loaLen = loaLen;
    }

    /**
	 * 
	 * @return String loaLen
	 */
    public String getLoaLen() {
        return this.loaLen;
    }

    /**
	 *
	 * @param String lbpLen
	 */
    public void setLbpLen(String lbpLen) {
        this.lbpLen = lbpLen;
    }

    /**
	 * 
	 * @return String lbpLen
	 */
    public String getLbpLen() {
        return this.lbpLen;
    }

    /**
	 *
	 * @param String vslWdt
	 */
    public void setVslWdt(String vslWdt) {
        this.vslWdt = vslWdt;
    }

    /**
	 * 
	 * @return String vslWdt
	 */
    public String getVslWdt() {
        return this.vslWdt;
    }

    /**
	 *
	 * @param String vslDpth
	 */
    public void setVslDpth(String vslDpth) {
        this.vslDpth = vslDpth;
    }

    /**
	 * 
	 * @return String vslDpth
	 */
    public String getVslDpth() {
        return this.vslDpth;
    }

    /**
	 *
	 * @param String smrDrftHgt
	 */
    public void setSmrDrftHgt(String smrDrftHgt) {
        this.smrDrftHgt = smrDrftHgt;
    }

    /**
	 * 
	 * @return String smrDrftHgt
	 */
    public String getSmrDrftHgt() {
        return this.smrDrftHgt;
    }

    /**
	 *
	 * @param String dwtWgt
	 */
    public void setDwtWgt(String dwtWgt) {
        this.dwtWgt = dwtWgt;
    }

    /**
	 * 
	 * @return String dwtWgt
	 */
    public String getDwtWgt() {
        return this.dwtWgt;
    }

    /**
	 *
	 * @param String lgtShpTongWgt
	 */
    public void setLgtShpTongWgt(String lgtShpTongWgt) {
        this.lgtShpTongWgt = lgtShpTongWgt;
    }

    /**
	 * 
	 * @return String lgtShpTongWgt
	 */
    public String getLgtShpTongWgt() {
        return this.lgtShpTongWgt;
    }

    /**
	 *
	 * @param String grsRgstTongWgt
	 */
    public void setGrsRgstTongWgt(String grsRgstTongWgt) {
        this.grsRgstTongWgt = grsRgstTongWgt;
    }

    /**
	 * 
	 * @return String grsRgstTongWgt
	 */
    public String getGrsRgstTongWgt() {
        return this.grsRgstTongWgt;
    }

    /**
	 *
	 * @param String netRgstTongWgt
	 */
    public void setNetRgstTongWgt(String netRgstTongWgt) {
        this.netRgstTongWgt = netRgstTongWgt;
    }

    /**
	 * 
	 * @return String netRgstTongWgt
	 */
    public String getNetRgstTongWgt() {
        return this.netRgstTongWgt;
    }

    /**
	 *
	 * @param String pnmGtWgt
	 */
    public void setPnmGtWgt(String pnmGtWgt) {
        this.pnmGtWgt = pnmGtWgt;
    }

    /**
	 * 
	 * @return String pnmGtWgt
	 */
    public String getPnmGtWgt() {
        return this.pnmGtWgt;
    }

    /**
	 *
	 * @param String pnmNetTongWgt
	 */
    public void setPnmNetTongWgt(String pnmNetTongWgt) {
        this.pnmNetTongWgt = pnmNetTongWgt;
    }

    /**
	 * 
	 * @return String pnmNetTongWgt
	 */
    public String getPnmNetTongWgt() {
        return this.pnmNetTongWgt;
    }

    /**
	 *
	 * @param String suzGtWgt
	 */
    public void setSuzGtWgt(String suzGtWgt) {
        this.suzGtWgt = suzGtWgt;
    }

    /**
	 * 
	 * @return String suzGtWgt
	 */
    public String getSuzGtWgt() {
        return this.suzGtWgt;
    }

    /**
	 *
	 * @param String suzNetTongWgt
	 */
    public void setSuzNetTongWgt(String suzNetTongWgt) {
        this.suzNetTongWgt = suzNetTongWgt;
    }

    /**
	 * 
	 * @return String suzNetTongWgt
	 */
    public String getSuzNetTongWgt() {
        return this.suzNetTongWgt;
    }

    /**
	 *
	 * @param String mnEngMkrNm
	 */
    public void setMnEngMkrNm(String mnEngMkrNm) {
        this.mnEngMkrNm = mnEngMkrNm;
    }

    /**
	 * 
	 * @return String mnEngMkrNm
	 */
    public String getMnEngMkrNm() {
        return this.mnEngMkrNm;
    }

    /**
	 *
	 * @param String mnEngTpDesc
	 */
    public void setMnEngTpDesc(String mnEngTpDesc) {
        this.mnEngTpDesc = mnEngTpDesc;
    }

    /**
	 * 
	 * @return String mnEngTpDesc
	 */
    public String getMnEngTpDesc() {
        return this.mnEngTpDesc;
    }

    /**
	 *
	 * @param String mnEngBhpPwr
	 */
    public void setMnEngBhpPwr(String mnEngBhpPwr) {
        this.mnEngBhpPwr = mnEngBhpPwr;
    }

    /**
	 * 
	 * @return String mnEngBhpPwr
	 */
    public String getMnEngBhpPwr() {
        return this.mnEngBhpPwr;
    }

    /**
	 *
	 * @param String vslOwnIndCd
	 */
    public void setVslOwnIndCd(String vslOwnIndCd) {
        this.vslOwnIndCd = vslOwnIndCd;
    }

    /**
	 * 
	 * @return String vslOwnIndCd
	 */
    public String getVslOwnIndCd() {
        return this.vslOwnIndCd;
    }

    /**
	 *
	 * @param String vslRgstCntCd
	 */
    public void setVslRgstCntCd(String vslRgstCntCd) {
        this.vslRgstCntCd = vslRgstCntCd;
    }

    /**
	 * 
	 * @return String vslRgstCntCd
	 */
    public String getVslRgstCntCd() {
        return this.vslRgstCntCd;
    }

    /**
	 *
	 * @param String vslBldCd
	 */
    public void setVslBldCd(String vslBldCd) {
        this.vslBldCd = vslBldCd;
    }

    /**
	 * 
	 * @return String vslBldCd
	 */
    public String getVslBldCd() {
        return this.vslBldCd;
    }

    /**
	 *
	 * @param String crrCd
	 */
    public void setCrrCd(String crrCd) {
        this.crrCd = crrCd;
    }

    /**
	 * 
	 * @return String crrCd
	 */
    public String getCrrCd() {
        return this.crrCd;
    }

    /**
	 *
	 * @param String fdrDivCd
	 */
    public void setFdrDivCd(String fdrDivCd) {
        this.fdrDivCd = fdrDivCd;
    }

    /**
	 * 
	 * @return String fdrDivCd
	 */
    public String getFdrDivCd() {
        return this.fdrDivCd;
    }

    /**
	 *
	 * @param String vslSvcSpd
	 */
    public void setVslSvcSpd(String vslSvcSpd) {
        this.vslSvcSpd = vslSvcSpd;
    }

    /**
	 * 
	 * @return String vslSvcSpd
	 */
    public String getVslSvcSpd() {
        return this.vslSvcSpd;
    }

    /**
	 *
	 * @param String maxSpd
	 */
    public void setMaxSpd(String maxSpd) {
        this.maxSpd = maxSpd;
    }

    /**
	 * 
	 * @return String maxSpd
	 */
    public String getMaxSpd() {
        return this.maxSpd;
    }

    /**
	 *
	 * @param String ecnSpd
	 */
    public void setEcnSpd(String ecnSpd) {
        this.ecnSpd = ecnSpd;
    }

    /**
	 * 
	 * @return String ecnSpd
	 */
    public String getEcnSpd() {
        return this.ecnSpd;
    }

    /**
	 *
	 * @param String crwKnt
	 */
    public void setCrwKnt(String crwKnt) {
        this.crwKnt = crwKnt;
    }

    /**
	 * 
	 * @return String crwKnt
	 */
    public String getCrwKnt() {
        return this.crwKnt;
    }

    /**
	 *
	 * @param String cntrDznCapa
	 */
    public void setCntrDznCapa(String cntrDznCapa) {
        this.cntrDznCapa = cntrDznCapa;
    }

    /**
	 * 
	 * @return String cntrDznCapa
	 */
    public String getCntrDznCapa() {
        return this.cntrDznCapa;
    }

    /**
	 *
	 * @param String cntrOpCapa
	 */
    public void setCntrOpCapa(String cntrOpCapa) {
        this.cntrOpCapa = cntrOpCapa;
    }

    /**
	 * 
	 * @return String cntrOpCapa
	 */
    public String getCntrOpCapa() {
        return this.cntrOpCapa;
    }

    /**
	 *
	 * @param String cntrPnmCapa
	 */
    public void setCntrPnmCapa(String cntrPnmCapa) {
        this.cntrPnmCapa = cntrPnmCapa;
    }

    /**
	 * 
	 * @return String cntrPnmCapa
	 */
    public String getCntrPnmCapa() {
        return this.cntrPnmCapa;
    }

    /**
	 *
	 * @param String cntrVslClssCapa
	 */
    public void setCntrVslClssCapa(String cntrVslClssCapa) {
        this.cntrVslClssCapa = cntrVslClssCapa;
    }

    /**
	 * 
	 * @return String cntrVslClssCapa
	 */
    public String getCntrVslClssCapa() {
        return this.cntrVslClssCapa;
    }

    /**
	 *
	 * @param String rfRcptKnt
	 */
    public void setRfRcptKnt(String rfRcptKnt) {
        this.rfRcptKnt = rfRcptKnt;
    }

    /**
	 * 
	 * @return String rfRcptKnt
	 */
    public String getRfRcptKnt() {
        return this.rfRcptKnt;
    }

    /**
	 *
	 * @param String rfRcptMaxKnt
	 */
    public void setRfRcptMaxKnt(String rfRcptMaxKnt) {
        this.rfRcptMaxKnt = rfRcptMaxKnt;
    }

    /**
	 * 
	 * @return String rfRcptMaxKnt
	 */
    public String getRfRcptMaxKnt() {
        return this.rfRcptMaxKnt;
    }

    /**
	 *
	 * @param String fbdCapa
	 */
    public void setFbdCapa(String fbdCapa) {
        this.fbdCapa = fbdCapa;
    }

    /**
	 * 
	 * @return String fbdCapa
	 */
    public String getFbdCapa() {
        return this.fbdCapa;
    }

    /**
	 *
	 * @param String dplCapa
	 */
    public void setDplCapa(String dplCapa) {
        this.dplCapa = dplCapa;
    }

    /**
	 * 
	 * @return String dplCapa
	 */
    public String getDplCapa() {
        return this.dplCapa;
    }

    /**
	 *
	 * @param String blstTnkCapa
	 */
    public void setBlstTnkCapa(String blstTnkCapa) {
        this.blstTnkCapa = blstTnkCapa;
    }

    /**
	 * 
	 * @return String blstTnkCapa
	 */
    public String getBlstTnkCapa() {
        return this.blstTnkCapa;
    }

    /**
	 *
	 * @param String foilCsm
	 */
    public void setFoilCsm(String foilCsm) {
        this.foilCsm = foilCsm;
    }

    /**
	 * 
	 * @return String foilCsm
	 */
    public String getFoilCsm() {
        return this.foilCsm;
    }

    /**
	 *
	 * @param String doilCsm
	 */
    public void setDoilCsm(String doilCsm) {
        this.doilCsm = doilCsm;
    }

    /**
	 * 
	 * @return String doilCsm
	 */
    public String getDoilCsm() {
        return this.doilCsm;
    }

    /**
	 *
	 * @param String frshWtrCsm
	 */
    public void setFrshWtrCsm(String frshWtrCsm) {
        this.frshWtrCsm = frshWtrCsm;
    }

    /**
	 * 
	 * @return String frshWtrCsm
	 */
    public String getFrshWtrCsm() {
        return this.frshWtrCsm;
    }

    /**
	 *
	 * @param String mnEngRpmPwr
	 */
    public void setMnEngRpmPwr(String mnEngRpmPwr) {
        this.mnEngRpmPwr = mnEngRpmPwr;
    }

    /**
	 * 
	 * @return String mnEngRpmPwr
	 */
    public String getMnEngRpmPwr() {
        return this.mnEngRpmPwr;
    }

    /**
	 *
	 * @param String gnrRpmPwr
	 */
    public void setGnrRpmPwr(String gnrRpmPwr) {
        this.gnrRpmPwr = gnrRpmPwr;
    }

    /**
	 * 
	 * @return String gnrRpmPwr
	 */
    public String getGnrRpmPwr() {
        return this.gnrRpmPwr;
    }

    /**
	 *
	 * @param String vslHgt
	 */
    public void setVslHgt(String vslHgt) {
        this.vslHgt = vslHgt;
    }

    /**
	 * 
	 * @return String vslHgt
	 */
    public String getVslHgt() {
        return this.vslHgt;
    }

    /**
	 *
	 * @param String rgstDt
	 */
    public void setRgstDt(String rgstDt) {
        this.rgstDt = rgstDt;
    }

    /**
	 * 
	 * @return String rgstDt
	 */
    public String getRgstDt() {
        return this.rgstDt;
    }

    /**
	 *
	 * @param String vslEdiNm
	 */
    public void setVslEdiNm(String vslEdiNm) {
        this.vslEdiNm = vslEdiNm;
    }

    /**
	 * 
	 * @return String vslEdiNm
	 */
    public String getVslEdiNm() {
        return this.vslEdiNm;
    }

    /**
	 *
	 * @param String coCd
	 */
    public void setCoCd(String coCd) {
        this.coCd = coCd;
    }

    /**
	 * 
	 * @return String coCd
	 */
    public String getCoCd() {
        return this.coCd;
    }

    /**
	 *
	 * @param String vslClzDt
	 */
    public void setVslClzDt(String vslClzDt) {
        this.vslClzDt = vslClzDt;
    }

    /**
	 * 
	 * @return String vslClzDt
	 */
    public String getVslClzDt() {
        return this.vslClzDt;
    }

    /**
	 *
	 * @param String vslCreOfcCd
	 */
    public void setVslCreOfcCd(String vslCreOfcCd) {
        this.vslCreOfcCd = vslCreOfcCd;
    }

    /**
	 * 
	 * @return String vslCreOfcCd
	 */
    public String getVslCreOfcCd() {
        return this.vslCreOfcCd;
    }

    /**
	 *
	 * @param String vslDeltOfcCd
	 */
    public void setVslDeltOfcCd(String vslDeltOfcCd) {
        this.vslDeltOfcCd = vslDeltOfcCd;
    }

    /**
	 * 
	 * @return String vslDeltOfcCd
	 */
    public String getVslDeltOfcCd() {
        return this.vslDeltOfcCd;
    }

    /**
	 *
	 * @param String vslBldAreaNm
	 */
    public void setVslBldAreaNm(String vslBldAreaNm) {
        this.vslBldAreaNm = vslBldAreaNm;
    }

    /**
	 * 
	 * @return String vslBldAreaNm
	 */
    public String getVslBldAreaNm() {
        return this.vslBldAreaNm;
    }

    /**
	 *
	 * @param String gnrMkrNm
	 */
    public void setGnrMkrNm(String gnrMkrNm) {
        this.gnrMkrNm = gnrMkrNm;
    }

    /**
	 * 
	 * @return String gnrMkrNm
	 */
    public String getGnrMkrNm() {
        return this.gnrMkrNm;
    }

    /**
	 *
	 * @param String gnrTpDesc
	 */
    public void setGnrTpDesc(String gnrTpDesc) {
        this.gnrTpDesc = gnrTpDesc;
    }

    /**
	 * 
	 * @return String gnrTpDesc
	 */
    public String getGnrTpDesc() {
        return this.gnrTpDesc;
    }

    /**
	 *
	 * @param String gnrBhpPwr
	 */
    public void setGnrBhpPwr(String gnrBhpPwr) {
        this.gnrBhpPwr = gnrBhpPwr;
    }

    /**
	 * 
	 * @return String gnrBhpPwr
	 */
    public String getGnrBhpPwr() {
        return this.gnrBhpPwr;
    }

    /**
	 *
	 * @param String bwthstMkrNm
	 */
    public void setBwthstMkrNm(String bwthstMkrNm) {
        this.bwthstMkrNm = bwthstMkrNm;
    }

    /**
	 * 
	 * @return String bwthstMkrNm
	 */
    public String getBwthstMkrNm() {
        return this.bwthstMkrNm;
    }

    /**
	 *
	 * @param String bwthstTpDesc
	 */
    public void setBwthstTpDesc(String bwthstTpDesc) {
        this.bwthstTpDesc = bwthstTpDesc;
    }

    /**
	 * 
	 * @return String bwthstTpDesc
	 */
    public String getBwthstTpDesc() {
        return this.bwthstTpDesc;
    }

    /**
	 *
	 * @param String bwthstBhpPwr
	 */
    public void setBwthstBhpPwr(String bwthstBhpPwr) {
        this.bwthstBhpPwr = bwthstBhpPwr;
    }

    /**
	 * 
	 * @return String bwthstBhpPwr
	 */
    public String getBwthstBhpPwr() {
        return this.bwthstBhpPwr;
    }

    /**
	 *
	 * @param String bwthstRpmPwr
	 */
    public void setBwthstRpmPwr(String bwthstRpmPwr) {
        this.bwthstRpmPwr = bwthstRpmPwr;
    }

    /**
	 * 
	 * @return String bwthstRpmPwr
	 */
    public String getBwthstRpmPwr() {
        return this.bwthstRpmPwr;
    }

    /**
	 *
	 * @param String lloydNo
	 */
    public void setLloydNo(String lloydNo) {
        this.lloydNo = lloydNo;
    }

    /**
	 * 
	 * @return String lloydNo
	 */
    public String getLloydNo() {
        return this.lloydNo;
    }

    /**
	 *
	 * @param String vslLnchDt
	 */
    public void setVslLnchDt(String vslLnchDt) {
        this.vslLnchDt = vslLnchDt;
    }

    /**
	 * 
	 * @return String vslLnchDt
	 */
    public String getVslLnchDt() {
        return this.vslLnchDt;
    }

    /**
	 *
	 * @param String vslDeDt
	 */
    public void setVslDeDt(String vslDeDt) {
        this.vslDeDt = vslDeDt;
    }

    /**
	 * 
	 * @return String vslDeDt
	 */
    public String getVslDeDt() {
        return this.vslDeDt;
    }

    /**
	 *
	 * @param String vslKelLyDt
	 */
    public void setVslKelLyDt(String vslKelLyDt) {
        this.vslKelLyDt = vslKelLyDt;
    }

    /**
	 * 
	 * @return String vslKelLyDt
	 */
    public String getVslKelLyDt() {
        return this.vslKelLyDt;
    }

    /**
	 *
	 * @param String vslHlNo
	 */
    public void setVslHlNo(String vslHlNo) {
        this.vslHlNo = vslHlNo;
    }

    /**
	 * 
	 * @return String vslHlNo
	 */
    public String getVslHlNo() {
        return this.vslHlNo;
    }

    /**
	 *
	 * @param String ttlTeuKnt
	 */
    public void setTtlTeuKnt(String ttlTeuKnt) {
        this.ttlTeuKnt = ttlTeuKnt;
    }

    /**
	 * 
	 * @return String ttlTeuKnt
	 */
    public String getTtlTeuKnt() {
        return this.ttlTeuKnt;
    }

    /**
	 *
	 * @param String vslHtchKnt
	 */
    public void setVslHtchKnt(String vslHtchKnt) {
        this.vslHtchKnt = vslHtchKnt;
    }

    /**
	 * 
	 * @return String vslHtchKnt
	 */
    public String getVslHtchKnt() {
        return this.vslHtchKnt;
    }

    /**
	 *
	 * @param String vslHldKnt
	 */
    public void setVslHldKnt(String vslHldKnt) {
        this.vslHldKnt = vslHldKnt;
    }

    /**
	 * 
	 * @return String vslHldKnt
	 */
    public String getVslHldKnt() {
        return this.vslHldKnt;
    }

    /**
	 *
	 * @param String vslRmk
	 */
    public void setVslRmk(String vslRmk) {
        this.vslRmk = vslRmk;
    }

    /**
	 * 
	 * @return String vslRmk
	 */
    public String getVslRmk() {
        return this.vslRmk;
    }

    /**
	 *
	 * @param String intlTongCertiFlg
	 */
    public void setIntlTongCertiFlg(String intlTongCertiFlg) {
        this.intlTongCertiFlg = intlTongCertiFlg;
    }

    /**
	 * 
	 * @return String intlTongCertiFlg
	 */
    public String getIntlTongCertiFlg() {
        return this.intlTongCertiFlg;
    }

    /**
	 *
	 * @param String madnVoySuzNetTongWgt
	 */
    public void setMadnVoySuzNetTongWgt(String madnVoySuzNetTongWgt) {
        this.madnVoySuzNetTongWgt = madnVoySuzNetTongWgt;
    }

    /**
	 * 
	 * @return String madnVoySuzNetTongWgt
	 */
    public String getMadnVoySuzNetTongWgt() {
        return this.madnVoySuzNetTongWgt;
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
	 * @param String eaiEvntDt
	 */
    public void setEaiEvntDt(String eaiEvntDt) {
        this.eaiEvntDt = eaiEvntDt;
    }

    /**
	 * 
	 * @return String eaiEvntDt
	 */
    public String getEaiEvntDt() {
        return this.eaiEvntDt;
    }

    /**
	 *
	 * @param String eaiIfId
	 */
    public void setEaiIfId(String eaiIfId) {
        this.eaiIfId = eaiIfId;
    }

    /**
	 * 
	 * @return String eaiIfId
	 */
    public String getEaiIfId() {
        return this.eaiIfId;
    }

    /**
	 *
	 * @param String modiVslCd
	 */
    public void setModiVslCd(String modiVslCd) {
        this.modiVslCd = modiVslCd;
    }

    /**
	 * 
	 * @return String modiVslCd
	 */
    public String getModiVslCd() {
        return this.modiVslCd;
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
    
    public String getModiVslOprTpCd() {
		return modiVslOprTpCd;
	}

	public void setModiVslOprTpCd(String modiVslOprTpCd) {
		this.modiVslOprTpCd = modiVslOprTpCd;
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
        setVslCntrIfSeq(JSPUtil.getParameter(request, prefix + "vsl_cntr_if_seq", ""));
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setVslClssFlg(JSPUtil.getParameter(request, prefix + "vsl_clss_flg", ""));
        setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
        setVslLoclNm(JSPUtil.getParameter(request, prefix + "vsl_locl_nm", ""));
        setFoilCapa(JSPUtil.getParameter(request, prefix + "foil_capa", ""));
        setDoilCapa(JSPUtil.getParameter(request, prefix + "doil_capa", ""));
        setFrshWtrCapa(JSPUtil.getParameter(request, prefix + "frsh_wtr_capa", ""));
        setCallSgnNo(JSPUtil.getParameter(request, prefix + "call_sgn_no", ""));
        setRgstNo(JSPUtil.getParameter(request, prefix + "rgst_no", ""));
        setPhnNo(JSPUtil.getParameter(request, prefix + "phn_no", ""));
        setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
        setTlxNo(JSPUtil.getParameter(request, prefix + "tlx_no", ""));
        setVslEml(JSPUtil.getParameter(request, prefix + "vsl_eml", ""));
        setPiclbDesc(JSPUtil.getParameter(request, prefix + "piclb_desc", ""));
        setRgstPortCd(JSPUtil.getParameter(request, prefix + "rgst_port_cd", ""));
        setClssNoRgstAreaNm(JSPUtil.getParameter(request, prefix + "clss_no_rgst_area_nm", ""));
        setVslClssNo(JSPUtil.getParameter(request, prefix + "vsl_clss_no", ""));
        setVslBldrNm(JSPUtil.getParameter(request, prefix + "vsl_bldr_nm", ""));
        setLoaLen(JSPUtil.getParameter(request, prefix + "loa_len", ""));
        setLbpLen(JSPUtil.getParameter(request, prefix + "lbp_len", ""));
        setVslWdt(JSPUtil.getParameter(request, prefix + "vsl_wdt", ""));
        setVslDpth(JSPUtil.getParameter(request, prefix + "vsl_dpth", ""));
        setSmrDrftHgt(JSPUtil.getParameter(request, prefix + "smr_drft_hgt", ""));
        setDwtWgt(JSPUtil.getParameter(request, prefix + "dwt_wgt", ""));
        setLgtShpTongWgt(JSPUtil.getParameter(request, prefix + "lgt_shp_tong_wgt", ""));
        setGrsRgstTongWgt(JSPUtil.getParameter(request, prefix + "grs_rgst_tong_wgt", ""));
        setNetRgstTongWgt(JSPUtil.getParameter(request, prefix + "net_rgst_tong_wgt", ""));
        setPnmGtWgt(JSPUtil.getParameter(request, prefix + "pnm_gt_wgt", ""));
        setPnmNetTongWgt(JSPUtil.getParameter(request, prefix + "pnm_net_tong_wgt", ""));
        setSuzGtWgt(JSPUtil.getParameter(request, prefix + "suz_gt_wgt", ""));
        setSuzNetTongWgt(JSPUtil.getParameter(request, prefix + "suz_net_tong_wgt", ""));
        setMnEngMkrNm(JSPUtil.getParameter(request, prefix + "mn_eng_mkr_nm", ""));
        setMnEngTpDesc(JSPUtil.getParameter(request, prefix + "mn_eng_tp_desc", ""));
        setMnEngBhpPwr(JSPUtil.getParameter(request, prefix + "mn_eng_bhp_pwr", ""));
        setVslOwnIndCd(JSPUtil.getParameter(request, prefix + "vsl_own_ind_cd", ""));
        setVslRgstCntCd(JSPUtil.getParameter(request, prefix + "vsl_rgst_cnt_cd", ""));
        setVslBldCd(JSPUtil.getParameter(request, prefix + "vsl_bld_cd", ""));
        setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
        setFdrDivCd(JSPUtil.getParameter(request, prefix + "fdr_div_cd", ""));
        setVslSvcSpd(JSPUtil.getParameter(request, prefix + "vsl_svc_spd", ""));
        setMaxSpd(JSPUtil.getParameter(request, prefix + "max_spd", ""));
        setEcnSpd(JSPUtil.getParameter(request, prefix + "ecn_spd", ""));
        setCrwKnt(JSPUtil.getParameter(request, prefix + "crw_knt", ""));
        setCntrDznCapa(JSPUtil.getParameter(request, prefix + "cntr_dzn_capa", ""));
        setCntrOpCapa(JSPUtil.getParameter(request, prefix + "cntr_op_capa", ""));
        setCntrPnmCapa(JSPUtil.getParameter(request, prefix + "cntr_pnm_capa", ""));
        setCntrVslClssCapa(JSPUtil.getParameter(request, prefix + "cntr_vsl_clss_capa", ""));
        setRfRcptKnt(JSPUtil.getParameter(request, prefix + "rf_rcpt_knt", ""));
        setRfRcptMaxKnt(JSPUtil.getParameter(request, prefix + "rf_rcpt_max_knt", ""));
        setFbdCapa(JSPUtil.getParameter(request, prefix + "fbd_capa", ""));
        setDplCapa(JSPUtil.getParameter(request, prefix + "dpl_capa", ""));
        setBlstTnkCapa(JSPUtil.getParameter(request, prefix + "blst_tnk_capa", ""));
        setFoilCsm(JSPUtil.getParameter(request, prefix + "foil_csm", ""));
        setDoilCsm(JSPUtil.getParameter(request, prefix + "doil_csm", ""));
        setFrshWtrCsm(JSPUtil.getParameter(request, prefix + "frsh_wtr_csm", ""));
        setMnEngRpmPwr(JSPUtil.getParameter(request, prefix + "mn_eng_rpm_pwr", ""));
        setGnrRpmPwr(JSPUtil.getParameter(request, prefix + "gnr_rpm_pwr", ""));
        setVslHgt(JSPUtil.getParameter(request, prefix + "vsl_hgt", ""));
        setRgstDt(JSPUtil.getParameter(request, prefix + "rgst_dt", ""));
        setVslEdiNm(JSPUtil.getParameter(request, prefix + "vsl_edi_nm", ""));
        setCoCd(JSPUtil.getParameter(request, prefix + "co_cd", ""));
        setVslClzDt(JSPUtil.getParameter(request, prefix + "vsl_clz_dt", ""));
        setVslCreOfcCd(JSPUtil.getParameter(request, prefix + "vsl_cre_ofc_cd", ""));
        setVslDeltOfcCd(JSPUtil.getParameter(request, prefix + "vsl_delt_ofc_cd", ""));
        setVslBldAreaNm(JSPUtil.getParameter(request, prefix + "vsl_bld_area_nm", ""));
        setGnrMkrNm(JSPUtil.getParameter(request, prefix + "gnr_mkr_nm", ""));
        setGnrTpDesc(JSPUtil.getParameter(request, prefix + "gnr_tp_desc", ""));
        setGnrBhpPwr(JSPUtil.getParameter(request, prefix + "gnr_bhp_pwr", ""));
        setBwthstMkrNm(JSPUtil.getParameter(request, prefix + "bwthst_mkr_nm", ""));
        setBwthstTpDesc(JSPUtil.getParameter(request, prefix + "bwthst_tp_desc", ""));
        setBwthstBhpPwr(JSPUtil.getParameter(request, prefix + "bwthst_bhp_pwr", ""));
        setBwthstRpmPwr(JSPUtil.getParameter(request, prefix + "bwthst_rpm_pwr", ""));
        setLloydNo(JSPUtil.getParameter(request, prefix + "lloyd_no", ""));
        setVslLnchDt(JSPUtil.getParameter(request, prefix + "vsl_lnch_dt", ""));
        setVslDeDt(JSPUtil.getParameter(request, prefix + "vsl_de_dt", ""));
        setVslKelLyDt(JSPUtil.getParameter(request, prefix + "vsl_kel_ly_dt", ""));
        setVslHlNo(JSPUtil.getParameter(request, prefix + "vsl_hl_no", ""));
        setTtlTeuKnt(JSPUtil.getParameter(request, prefix + "ttl_teu_knt", ""));
        setVslHtchKnt(JSPUtil.getParameter(request, prefix + "vsl_htch_knt", ""));
        setVslHldKnt(JSPUtil.getParameter(request, prefix + "vsl_hld_knt", ""));
        setVslRmk(JSPUtil.getParameter(request, prefix + "vsl_rmk", ""));
        setIntlTongCertiFlg(JSPUtil.getParameter(request, prefix + "intl_tong_certi_flg", ""));
        setMadnVoySuzNetTongWgt(JSPUtil.getParameter(request, prefix + "madn_voy_suz_net_tong_wgt", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
        setEaiEvntDt(JSPUtil.getParameter(request, prefix + "eai_evnt_dt", ""));
        setEaiIfId(JSPUtil.getParameter(request, prefix + "eai_if_id", ""));
        setModiVslCd(JSPUtil.getParameter(request, prefix + "modi_vsl_cd", ""));
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
        setModiVslOprTpCd(JSPUtil.getParameter(request, prefix + "modi_vsl_opr_tp_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ContainerVesselIfVO[]
	 */
    public ContainerVesselIfVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ContainerVesselIfVO[]
	 */
    public ContainerVesselIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ContainerVesselIfVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] vslCntrIfSeq = (JSPUtil.getParameter(request, prefix + "vsl_cntr_if_seq", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] vslClssFlg = (JSPUtil.getParameter(request, prefix + "vsl_clss_flg", length));
            String[] vslEngNm = (JSPUtil.getParameter(request, prefix + "vsl_eng_nm", length));
            String[] vslLoclNm = (JSPUtil.getParameter(request, prefix + "vsl_locl_nm", length));
            String[] foilCapa = (JSPUtil.getParameter(request, prefix + "foil_capa", length));
            String[] doilCapa = (JSPUtil.getParameter(request, prefix + "doil_capa", length));
            String[] frshWtrCapa = (JSPUtil.getParameter(request, prefix + "frsh_wtr_capa", length));
            String[] callSgnNo = (JSPUtil.getParameter(request, prefix + "call_sgn_no", length));
            String[] rgstNo = (JSPUtil.getParameter(request, prefix + "rgst_no", length));
            String[] phnNo = (JSPUtil.getParameter(request, prefix + "phn_no", length));
            String[] faxNo = (JSPUtil.getParameter(request, prefix + "fax_no", length));
            String[] tlxNo = (JSPUtil.getParameter(request, prefix + "tlx_no", length));
            String[] vslEml = (JSPUtil.getParameter(request, prefix + "vsl_eml", length));
            String[] piclbDesc = (JSPUtil.getParameter(request, prefix + "piclb_desc", length));
            String[] rgstPortCd = (JSPUtil.getParameter(request, prefix + "rgst_port_cd", length));
            String[] clssNoRgstAreaNm = (JSPUtil.getParameter(request, prefix + "clss_no_rgst_area_nm", length));
            String[] vslClssNo = (JSPUtil.getParameter(request, prefix + "vsl_clss_no", length));
            String[] vslBldrNm = (JSPUtil.getParameter(request, prefix + "vsl_bldr_nm", length));
            String[] loaLen = (JSPUtil.getParameter(request, prefix + "loa_len", length));
            String[] lbpLen = (JSPUtil.getParameter(request, prefix + "lbp_len", length));
            String[] vslWdt = (JSPUtil.getParameter(request, prefix + "vsl_wdt", length));
            String[] vslDpth = (JSPUtil.getParameter(request, prefix + "vsl_dpth", length));
            String[] smrDrftHgt = (JSPUtil.getParameter(request, prefix + "smr_drft_hgt", length));
            String[] dwtWgt = (JSPUtil.getParameter(request, prefix + "dwt_wgt", length));
            String[] lgtShpTongWgt = (JSPUtil.getParameter(request, prefix + "lgt_shp_tong_wgt", length));
            String[] grsRgstTongWgt = (JSPUtil.getParameter(request, prefix + "grs_rgst_tong_wgt", length));
            String[] netRgstTongWgt = (JSPUtil.getParameter(request, prefix + "net_rgst_tong_wgt", length));
            String[] pnmGtWgt = (JSPUtil.getParameter(request, prefix + "pnm_gt_wgt", length));
            String[] pnmNetTongWgt = (JSPUtil.getParameter(request, prefix + "pnm_net_tong_wgt", length));
            String[] suzGtWgt = (JSPUtil.getParameter(request, prefix + "suz_gt_wgt", length));
            String[] suzNetTongWgt = (JSPUtil.getParameter(request, prefix + "suz_net_tong_wgt", length));
            String[] mnEngMkrNm = (JSPUtil.getParameter(request, prefix + "mn_eng_mkr_nm", length));
            String[] mnEngTpDesc = (JSPUtil.getParameter(request, prefix + "mn_eng_tp_desc", length));
            String[] mnEngBhpPwr = (JSPUtil.getParameter(request, prefix + "mn_eng_bhp_pwr", length));
            String[] vslOwnIndCd = (JSPUtil.getParameter(request, prefix + "vsl_own_ind_cd", length));
            String[] vslRgstCntCd = (JSPUtil.getParameter(request, prefix + "vsl_rgst_cnt_cd", length));
            String[] vslBldCd = (JSPUtil.getParameter(request, prefix + "vsl_bld_cd", length));
            String[] crrCd = (JSPUtil.getParameter(request, prefix + "crr_cd", length));
            String[] fdrDivCd = (JSPUtil.getParameter(request, prefix + "fdr_div_cd", length));
            String[] vslSvcSpd = (JSPUtil.getParameter(request, prefix + "vsl_svc_spd", length));
            String[] maxSpd = (JSPUtil.getParameter(request, prefix + "max_spd", length));
            String[] ecnSpd = (JSPUtil.getParameter(request, prefix + "ecn_spd", length));
            String[] crwKnt = (JSPUtil.getParameter(request, prefix + "crw_knt", length));
            String[] cntrDznCapa = (JSPUtil.getParameter(request, prefix + "cntr_dzn_capa", length));
            String[] cntrOpCapa = (JSPUtil.getParameter(request, prefix + "cntr_op_capa", length));
            String[] cntrPnmCapa = (JSPUtil.getParameter(request, prefix + "cntr_pnm_capa", length));
            String[] cntrVslClssCapa = (JSPUtil.getParameter(request, prefix + "cntr_vsl_clss_capa", length));
            String[] rfRcptKnt = (JSPUtil.getParameter(request, prefix + "rf_rcpt_knt", length));
            String[] rfRcptMaxKnt = (JSPUtil.getParameter(request, prefix + "rf_rcpt_max_knt", length));
            String[] fbdCapa = (JSPUtil.getParameter(request, prefix + "fbd_capa", length));
            String[] dplCapa = (JSPUtil.getParameter(request, prefix + "dpl_capa", length));
            String[] blstTnkCapa = (JSPUtil.getParameter(request, prefix + "blst_tnk_capa", length));
            String[] foilCsm = (JSPUtil.getParameter(request, prefix + "foil_csm", length));
            String[] doilCsm = (JSPUtil.getParameter(request, prefix + "doil_csm", length));
            String[] frshWtrCsm = (JSPUtil.getParameter(request, prefix + "frsh_wtr_csm", length));
            String[] mnEngRpmPwr = (JSPUtil.getParameter(request, prefix + "mn_eng_rpm_pwr", length));
            String[] gnrRpmPwr = (JSPUtil.getParameter(request, prefix + "gnr_rpm_pwr", length));
            String[] vslHgt = (JSPUtil.getParameter(request, prefix + "vsl_hgt", length));
            String[] rgstDt = (JSPUtil.getParameter(request, prefix + "rgst_dt", length));
            String[] vslEdiNm = (JSPUtil.getParameter(request, prefix + "vsl_edi_nm", length));
            String[] coCd = (JSPUtil.getParameter(request, prefix + "co_cd", length));
            String[] vslClzDt = (JSPUtil.getParameter(request, prefix + "vsl_clz_dt", length));
            String[] vslCreOfcCd = (JSPUtil.getParameter(request, prefix + "vsl_cre_ofc_cd", length));
            String[] vslDeltOfcCd = (JSPUtil.getParameter(request, prefix + "vsl_delt_ofc_cd", length));
            String[] vslBldAreaNm = (JSPUtil.getParameter(request, prefix + "vsl_bld_area_nm", length));
            String[] gnrMkrNm = (JSPUtil.getParameter(request, prefix + "gnr_mkr_nm", length));
            String[] gnrTpDesc = (JSPUtil.getParameter(request, prefix + "gnr_tp_desc", length));
            String[] gnrBhpPwr = (JSPUtil.getParameter(request, prefix + "gnr_bhp_pwr", length));
            String[] bwthstMkrNm = (JSPUtil.getParameter(request, prefix + "bwthst_mkr_nm", length));
            String[] bwthstTpDesc = (JSPUtil.getParameter(request, prefix + "bwthst_tp_desc", length));
            String[] bwthstBhpPwr = (JSPUtil.getParameter(request, prefix + "bwthst_bhp_pwr", length));
            String[] bwthstRpmPwr = (JSPUtil.getParameter(request, prefix + "bwthst_rpm_pwr", length));
            String[] lloydNo = (JSPUtil.getParameter(request, prefix + "lloyd_no", length));
            String[] vslLnchDt = (JSPUtil.getParameter(request, prefix + "vsl_lnch_dt", length));
            String[] vslDeDt = (JSPUtil.getParameter(request, prefix + "vsl_de_dt", length));
            String[] vslKelLyDt = (JSPUtil.getParameter(request, prefix + "vsl_kel_ly_dt", length));
            String[] vslHlNo = (JSPUtil.getParameter(request, prefix + "vsl_hl_no", length));
            String[] ttlTeuKnt = (JSPUtil.getParameter(request, prefix + "ttl_teu_knt", length));
            String[] vslHtchKnt = (JSPUtil.getParameter(request, prefix + "vsl_htch_knt", length));
            String[] vslHldKnt = (JSPUtil.getParameter(request, prefix + "vsl_hld_knt", length));
            String[] vslRmk = (JSPUtil.getParameter(request, prefix + "vsl_rmk", length));
            String[] intlTongCertiFlg = (JSPUtil.getParameter(request, prefix + "intl_tong_certi_flg", length));
            String[] madnVoySuzNetTongWgt = (JSPUtil.getParameter(request, prefix + "madn_voy_suz_net_tong_wgt", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
            String[] eaiEvntDt = (JSPUtil.getParameter(request, prefix + "eai_evnt_dt", length));
            String[] eaiIfId = (JSPUtil.getParameter(request, prefix + "eai_if_id", length));
            String[] modiVslCd = (JSPUtil.getParameter(request, prefix + "modi_vsl_cd", length));
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
	    	String[] modiVslOprTpCd = (JSPUtil.getParameter(request, prefix + "modi_vsl_opr_tp_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new ContainerVesselIfVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (vslCntrIfSeq[i] != null)
                    model.setVslCntrIfSeq(vslCntrIfSeq[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (vslClssFlg[i] != null)
                    model.setVslClssFlg(vslClssFlg[i]);
                if (vslEngNm[i] != null)
                    model.setVslEngNm(vslEngNm[i]);
                if (vslLoclNm[i] != null)
                    model.setVslLoclNm(vslLoclNm[i]);
                if (foilCapa[i] != null)
                    model.setFoilCapa(foilCapa[i]);
                if (doilCapa[i] != null)
                    model.setDoilCapa(doilCapa[i]);
                if (frshWtrCapa[i] != null)
                    model.setFrshWtrCapa(frshWtrCapa[i]);
                if (callSgnNo[i] != null)
                    model.setCallSgnNo(callSgnNo[i]);
                if (rgstNo[i] != null)
                    model.setRgstNo(rgstNo[i]);
                if (phnNo[i] != null)
                    model.setPhnNo(phnNo[i]);
                if (faxNo[i] != null)
                    model.setFaxNo(faxNo[i]);
                if (tlxNo[i] != null)
                    model.setTlxNo(tlxNo[i]);
                if (vslEml[i] != null)
                    model.setVslEml(vslEml[i]);
                if (piclbDesc[i] != null)
                    model.setPiclbDesc(piclbDesc[i]);
                if (rgstPortCd[i] != null)
                    model.setRgstPortCd(rgstPortCd[i]);
                if (clssNoRgstAreaNm[i] != null)
                    model.setClssNoRgstAreaNm(clssNoRgstAreaNm[i]);
                if (vslClssNo[i] != null)
                    model.setVslClssNo(vslClssNo[i]);
                if (vslBldrNm[i] != null)
                    model.setVslBldrNm(vslBldrNm[i]);
                if (loaLen[i] != null)
                    model.setLoaLen(loaLen[i]);
                if (lbpLen[i] != null)
                    model.setLbpLen(lbpLen[i]);
                if (vslWdt[i] != null)
                    model.setVslWdt(vslWdt[i]);
                if (vslDpth[i] != null)
                    model.setVslDpth(vslDpth[i]);
                if (smrDrftHgt[i] != null)
                    model.setSmrDrftHgt(smrDrftHgt[i]);
                if (dwtWgt[i] != null)
                    model.setDwtWgt(dwtWgt[i]);
                if (lgtShpTongWgt[i] != null)
                    model.setLgtShpTongWgt(lgtShpTongWgt[i]);
                if (grsRgstTongWgt[i] != null)
                    model.setGrsRgstTongWgt(grsRgstTongWgt[i]);
                if (netRgstTongWgt[i] != null)
                    model.setNetRgstTongWgt(netRgstTongWgt[i]);
                if (pnmGtWgt[i] != null)
                    model.setPnmGtWgt(pnmGtWgt[i]);
                if (pnmNetTongWgt[i] != null)
                    model.setPnmNetTongWgt(pnmNetTongWgt[i]);
                if (suzGtWgt[i] != null)
                    model.setSuzGtWgt(suzGtWgt[i]);
                if (suzNetTongWgt[i] != null)
                    model.setSuzNetTongWgt(suzNetTongWgt[i]);
                if (mnEngMkrNm[i] != null)
                    model.setMnEngMkrNm(mnEngMkrNm[i]);
                if (mnEngTpDesc[i] != null)
                    model.setMnEngTpDesc(mnEngTpDesc[i]);
                if (mnEngBhpPwr[i] != null)
                    model.setMnEngBhpPwr(mnEngBhpPwr[i]);
                if (vslOwnIndCd[i] != null)
                    model.setVslOwnIndCd(vslOwnIndCd[i]);
                if (vslRgstCntCd[i] != null)
                    model.setVslRgstCntCd(vslRgstCntCd[i]);
                if (vslBldCd[i] != null)
                    model.setVslBldCd(vslBldCd[i]);
                if (crrCd[i] != null)
                    model.setCrrCd(crrCd[i]);
                if (fdrDivCd[i] != null)
                    model.setFdrDivCd(fdrDivCd[i]);
                if (vslSvcSpd[i] != null)
                    model.setVslSvcSpd(vslSvcSpd[i]);
                if (maxSpd[i] != null)
                    model.setMaxSpd(maxSpd[i]);
                if (ecnSpd[i] != null)
                    model.setEcnSpd(ecnSpd[i]);
                if (crwKnt[i] != null)
                    model.setCrwKnt(crwKnt[i]);
                if (cntrDznCapa[i] != null)
                    model.setCntrDznCapa(cntrDznCapa[i]);
                if (cntrOpCapa[i] != null)
                    model.setCntrOpCapa(cntrOpCapa[i]);
                if (cntrPnmCapa[i] != null)
                    model.setCntrPnmCapa(cntrPnmCapa[i]);
                if (cntrVslClssCapa[i] != null)
                    model.setCntrVslClssCapa(cntrVslClssCapa[i]);
                if (rfRcptKnt[i] != null)
                    model.setRfRcptKnt(rfRcptKnt[i]);
                if (rfRcptMaxKnt[i] != null)
                    model.setRfRcptMaxKnt(rfRcptMaxKnt[i]);
                if (fbdCapa[i] != null)
                    model.setFbdCapa(fbdCapa[i]);
                if (dplCapa[i] != null)
                    model.setDplCapa(dplCapa[i]);
                if (blstTnkCapa[i] != null)
                    model.setBlstTnkCapa(blstTnkCapa[i]);
                if (foilCsm[i] != null)
                    model.setFoilCsm(foilCsm[i]);
                if (doilCsm[i] != null)
                    model.setDoilCsm(doilCsm[i]);
                if (frshWtrCsm[i] != null)
                    model.setFrshWtrCsm(frshWtrCsm[i]);
                if (mnEngRpmPwr[i] != null)
                    model.setMnEngRpmPwr(mnEngRpmPwr[i]);
                if (gnrRpmPwr[i] != null)
                    model.setGnrRpmPwr(gnrRpmPwr[i]);
                if (vslHgt[i] != null)
                    model.setVslHgt(vslHgt[i]);
                if (rgstDt[i] != null)
                    model.setRgstDt(rgstDt[i]);
                if (vslEdiNm[i] != null)
                    model.setVslEdiNm(vslEdiNm[i]);
                if (coCd[i] != null)
                    model.setCoCd(coCd[i]);
                if (vslClzDt[i] != null)
                    model.setVslClzDt(vslClzDt[i]);
                if (vslCreOfcCd[i] != null)
                    model.setVslCreOfcCd(vslCreOfcCd[i]);
                if (vslDeltOfcCd[i] != null)
                    model.setVslDeltOfcCd(vslDeltOfcCd[i]);
                if (vslBldAreaNm[i] != null)
                    model.setVslBldAreaNm(vslBldAreaNm[i]);
                if (gnrMkrNm[i] != null)
                    model.setGnrMkrNm(gnrMkrNm[i]);
                if (gnrTpDesc[i] != null)
                    model.setGnrTpDesc(gnrTpDesc[i]);
                if (gnrBhpPwr[i] != null)
                    model.setGnrBhpPwr(gnrBhpPwr[i]);
                if (bwthstMkrNm[i] != null)
                    model.setBwthstMkrNm(bwthstMkrNm[i]);
                if (bwthstTpDesc[i] != null)
                    model.setBwthstTpDesc(bwthstTpDesc[i]);
                if (bwthstBhpPwr[i] != null)
                    model.setBwthstBhpPwr(bwthstBhpPwr[i]);
                if (bwthstRpmPwr[i] != null)
                    model.setBwthstRpmPwr(bwthstRpmPwr[i]);
                if (lloydNo[i] != null)
                    model.setLloydNo(lloydNo[i]);
                if (vslLnchDt[i] != null)
                    model.setVslLnchDt(vslLnchDt[i]);
                if (vslDeDt[i] != null)
                    model.setVslDeDt(vslDeDt[i]);
                if (vslKelLyDt[i] != null)
                    model.setVslKelLyDt(vslKelLyDt[i]);
                if (vslHlNo[i] != null)
                    model.setVslHlNo(vslHlNo[i]);
                if (ttlTeuKnt[i] != null)
                    model.setTtlTeuKnt(ttlTeuKnt[i]);
                if (vslHtchKnt[i] != null)
                    model.setVslHtchKnt(vslHtchKnt[i]);
                if (vslHldKnt[i] != null)
                    model.setVslHldKnt(vslHldKnt[i]);
                if (vslRmk[i] != null)
                    model.setVslRmk(vslRmk[i]);
                if (intlTongCertiFlg[i] != null)
                    model.setIntlTongCertiFlg(intlTongCertiFlg[i]);
                if (madnVoySuzNetTongWgt[i] != null)
                    model.setMadnVoySuzNetTongWgt(madnVoySuzNetTongWgt[i]);
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
                if (eaiEvntDt[i] != null)
                    model.setEaiEvntDt(eaiEvntDt[i]);
                if (eaiIfId[i] != null)
                    model.setEaiIfId(eaiIfId[i]);
                if (modiVslCd[i] != null)
                    model.setModiVslCd(modiVslCd[i]);
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
				if (modiVslOprTpCd[i] != null) 
		    		model.setModiVslOprTpCd(modiVslOprTpCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getContainerVesselIfVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return ContainerVesselIfVO[]
	 */
    public ContainerVesselIfVO[] getContainerVesselIfVOs() {
        ContainerVesselIfVO[] vos = (ContainerVesselIfVO[]) models.toArray(new ContainerVesselIfVO[models.size()]);
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
        this.vslCntrIfSeq = this.vslCntrIfSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslClssFlg = this.vslClssFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslEngNm = this.vslEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslLoclNm = this.vslLoclNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.foilCapa = this.foilCapa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.doilCapa = this.doilCapa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frshWtrCapa = this.frshWtrCapa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.callSgnNo = this.callSgnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rgstNo = this.rgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.phnNo = this.phnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.faxNo = this.faxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tlxNo = this.tlxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslEml = this.vslEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.piclbDesc = this.piclbDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rgstPortCd = this.rgstPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.clssNoRgstAreaNm = this.clssNoRgstAreaNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslClssNo = this.vslClssNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslBldrNm = this.vslBldrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.loaLen = this.loaLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lbpLen = this.lbpLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslWdt = this.vslWdt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslDpth = this.vslDpth.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.smrDrftHgt = this.smrDrftHgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dwtWgt = this.dwtWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lgtShpTongWgt = this.lgtShpTongWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.grsRgstTongWgt = this.grsRgstTongWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.netRgstTongWgt = this.netRgstTongWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pnmGtWgt = this.pnmGtWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pnmNetTongWgt = this.pnmNetTongWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.suzGtWgt = this.suzGtWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.suzNetTongWgt = this.suzNetTongWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mnEngMkrNm = this.mnEngMkrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mnEngTpDesc = this.mnEngTpDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mnEngBhpPwr = this.mnEngBhpPwr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslOwnIndCd = this.vslOwnIndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslRgstCntCd = this.vslRgstCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslBldCd = this.vslBldCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crrCd = this.crrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fdrDivCd = this.fdrDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslSvcSpd = this.vslSvcSpd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.maxSpd = this.maxSpd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecnSpd = this.ecnSpd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crwKnt = this.crwKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrDznCapa = this.cntrDznCapa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrOpCapa = this.cntrOpCapa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrPnmCapa = this.cntrPnmCapa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrVslClssCapa = this.cntrVslClssCapa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfRcptKnt = this.rfRcptKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfRcptMaxKnt = this.rfRcptMaxKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fbdCapa = this.fbdCapa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dplCapa = this.dplCapa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blstTnkCapa = this.blstTnkCapa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.foilCsm = this.foilCsm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.doilCsm = this.doilCsm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frshWtrCsm = this.frshWtrCsm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mnEngRpmPwr = this.mnEngRpmPwr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.gnrRpmPwr = this.gnrRpmPwr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslHgt = this.vslHgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rgstDt = this.rgstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslEdiNm = this.vslEdiNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.coCd = this.coCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslClzDt = this.vslClzDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCreOfcCd = this.vslCreOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslDeltOfcCd = this.vslDeltOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslBldAreaNm = this.vslBldAreaNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.gnrMkrNm = this.gnrMkrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.gnrTpDesc = this.gnrTpDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.gnrBhpPwr = this.gnrBhpPwr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bwthstMkrNm = this.bwthstMkrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bwthstTpDesc = this.bwthstTpDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bwthstBhpPwr = this.bwthstBhpPwr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bwthstRpmPwr = this.bwthstRpmPwr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lloydNo = this.lloydNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslLnchDt = this.vslLnchDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslDeDt = this.vslDeDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslKelLyDt = this.vslKelLyDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslHlNo = this.vslHlNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ttlTeuKnt = this.ttlTeuKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslHtchKnt = this.vslHtchKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslHldKnt = this.vslHldKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslRmk = this.vslRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intlTongCertiFlg = this.intlTongCertiFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.madnVoySuzNetTongWgt = this.madnVoySuzNetTongWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eaiEvntDt = this.eaiEvntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eaiIfId = this.eaiIfId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.modiVslCd = this.modiVslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
        this.modiVslOprTpCd = this.modiVslOprTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
