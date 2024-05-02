/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : ContainerVesselMainIfVO.java
*@FileTitle : ContainerVesselMainIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.08 
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
public class ContainerVesselMainIfVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<ContainerVesselMainIfVO> models = new ArrayList<ContainerVesselMainIfVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String blstTnkCapa = null;

    /* Column Info */
    private String bwthstBhpPwr = null;

    /* Column Info */
    private String bwthstMkrNm = null;

    /* Column Info */
    private String bwthstRpmPwr = null;

    /* Column Info */
    private String bwthstTpDesc = null;

    /* Column Info */
    private String callSgnNo = null;

    /* Column Info */
    private String clssNoRgstAreaNm = null;

    /* Column Info */
    private String cntrDznCapa = null;

    /* Column Info */
    private String cntrOpCapa = null;

    /* Column Info */
    private String cntrPnmCapa = null;

    /* Column Info */
    private String cntrVslClssCapa = null;

    /* Column Info */
    private String coCd = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String crrCd = null;

    /* Column Info */
    private String crwKnt = null;

    /* Column Info */
    private String deltFlg = null;

    /* Column Info */
    private String doilCapa = null;

    /* Column Info */
    private String doilCsm = null;

    /* Column Info */
    private String dplCapa = null;

    /* Column Info */
    private String dwtWgt = null;

    /* Column Info */
    private String ecnSpd = null;

    /* Column Info */
    private String faxNo = null;

    /* Column Info */
    private String fbdCapa = null;

    /* Column Info */
    private String fdrDivCd = null;

    /* Column Info */
    private String foilCapa = null;

    /* Column Info */
    private String foilCsm = null;

    /* Column Info */
    private String frshWtrCapa = null;

    /* Column Info */
    private String frshWtrCsm = null;

    /* Column Info */
    private String gnrBhpPwr = null;

    /* Column Info */
    private String gnrMkrNm = null;

    /* Column Info */
    private String gnrRpmPwr = null;

    /* Column Info */
    private String gnrTpDesc = null;

    /* Column Info */
    private String grsRgstTongWgt = null;

    /* Column Info */
    private String intlTongCertiFlg = null;

    /* Column Info */
    private String lbpLen = null;

    /* Column Info */
    private String lgtShpTongWgt = null;

    /* Column Info */
    private String lloydNo = null;

    /* Column Info */
    private String loaLen = null;

    /* Column Info */
    private String madnVoySuzNetTongWgt = null;

    /* Column Info */
    private String maxSpd = null;

    /* Column Info */
    private String mnEngHorPwrUtCd = null;

    /* Column Info */
    private String mnEngBhpPwr = null;

    /* Column Info */
    private String mnEngMkrNm = null;

    /* Column Info */
    private String mnEngRpmPwr = null;

    /* Column Info */
    private String mnEngTpDesc = null;

    /* Column Info */
    private String netRgstTongWgt = null;

    /* Column Info */
    private String phnNo = null;

    /* Column Info */
    private String piclbDesc = null;

    /* Column Info */
    private String pnmGtWgt = null;

    /* Column Info */
    private String pnmNetTongWgt = null;

    /* Column Info */
    private String rfRcptKnt = null;

    /* Column Info */
    private String rfRcptMaxKnt = null;

    /* Column Info */
    private String rgstDt = null;

    /* Column Info */
    private String rgstNo = null;

    /* Column Info */
    private String rgstPortCd = null;

    /* Column Info */
    private String smrDrftHgt = null;

    /* Column Info */
    private String suzGtWgt = null;

    /* Column Info */
    private String suzNetTongWgt = null;

    /* Column Info */
    private String tlxNo = null;

    /* Column Info */
    private String ttlTeuKnt = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String vslBldAreaNm = null;

    /* Column Info */
    private String vslBldrNm = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String vslClssFlg = null;

    /* Column Info */
    private String vslClssNo = null;

    /* Column Info */
    private String vslClzDt = null;

    /* Column Info */
    private String vslCreOfcCd = null;

    /* Column Info */
    private String vslDeDt = null;

    /* Column Info */
    private String vslDeltOfcCd = null;

    /* Column Info */
    private String vslDpth = null;

    /* Column Info */
    private String vslEdiNm = null;

    /* Column Info */
    private String vslEml = null;

    /* Column Info */
    private String vslEngNm = null;

    /* Column Info */
    private String vslHgt = null;

    /* Column Info */
    private String vslHlNo = null;

    /* Column Info */
    private String vslHldKnt = null;

    /* Column Info */
    private String vslHtchKnt = null;

    /* Column Info */
    private String vslKelLyDt = null;

    /* Column Info */
    private String vslKrnNm = null;

    /* Column Info */
    private String vslLnchDt = null;

    /* Column Info */
    private String vslLoclNm = null;

    /* Column Info */
    private String vslOwnIndCd = null;

    /* Column Info */
    private String vslRgstCntCd = null;

    /* Column Info */
    private String vslRmk = null;

    /* Column Info */
    private String vslSvcSpd = null;

    /* Column Info */
    private String vslWdt = null;

    /* Column Info */
    private String cudFlg = null;

    /* Column Info */
    private String eaiEvntDt = null;

    /* Column Info */
    private String eaiIfId = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public ContainerVesselMainIfVO() {
    }

    public ContainerVesselMainIfVO(String ibflag, String pagerows, String blstTnkCapa, String bwthstBhpPwr, String bwthstMkrNm, String bwthstRpmPwr, String bwthstTpDesc, String callSgnNo, String clssNoRgstAreaNm, String cntrDznCapa, String cntrOpCapa, String cntrPnmCapa, String cntrVslClssCapa, String coCd, String creDt, String creUsrId, String crrCd, String crwKnt, String deltFlg, String doilCapa, String doilCsm, String dplCapa, String dwtWgt, String ecnSpd, String faxNo, String fbdCapa, String fdrDivCd, String foilCapa, String foilCsm, String frshWtrCapa, String frshWtrCsm, String gnrBhpPwr, String gnrMkrNm, String gnrRpmPwr, String gnrTpDesc, String grsRgstTongWgt, String intlTongCertiFlg, String lbpLen, String lgtShpTongWgt, String lloydNo, String loaLen, String madnVoySuzNetTongWgt, String maxSpd, String mnEngHorPwrUtCd, String mnEngBhpPwr, String mnEngMkrNm, String mnEngRpmPwr, String mnEngTpDesc, String netRgstTongWgt, String phnNo, String piclbDesc, String pnmGtWgt, String pnmNetTongWgt, String rfRcptKnt, String rfRcptMaxKnt, String rgstDt, String rgstNo, String rgstPortCd, String smrDrftHgt, String suzGtWgt, String suzNetTongWgt, String tlxNo, String ttlTeuKnt, String updDt, String updUsrId, String vslBldAreaNm, String vslBldrNm, String vslCd, String vslClssFlg, String vslClssNo, String vslClzDt, String vslCreOfcCd, String vslDeDt, String vslDeltOfcCd, String vslDpth, String vslEdiNm, String vslEml, String vslEngNm, String vslHgt, String vslHlNo, String vslHldKnt, String vslHtchKnt, String vslKelLyDt, String vslKrnNm, String vslLnchDt, String vslLoclNm, String vslOwnIndCd, String vslRgstCntCd, String vslRmk, String vslSvcSpd, String vslWdt, String cudFlg, String eaiEvntDt, String eaiIfId) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.blstTnkCapa = blstTnkCapa;
        this.bwthstBhpPwr = bwthstBhpPwr;
        this.bwthstMkrNm = bwthstMkrNm;
        this.bwthstRpmPwr = bwthstRpmPwr;
        this.bwthstTpDesc = bwthstTpDesc;
        this.callSgnNo = callSgnNo;
        this.clssNoRgstAreaNm = clssNoRgstAreaNm;
        this.cntrDznCapa = cntrDznCapa;
        this.cntrOpCapa = cntrOpCapa;
        this.cntrPnmCapa = cntrPnmCapa;
        this.cntrVslClssCapa = cntrVslClssCapa;
        this.coCd = coCd;
        this.creDt = creDt;
        this.creUsrId = creUsrId;
        this.crrCd = crrCd;
        this.crwKnt = crwKnt;
        this.deltFlg = deltFlg;
        this.doilCapa = doilCapa;
        this.doilCsm = doilCsm;
        this.dplCapa = dplCapa;
        this.dwtWgt = dwtWgt;
        this.ecnSpd = ecnSpd;
        this.faxNo = faxNo;
        this.fbdCapa = fbdCapa;
        this.fdrDivCd = fdrDivCd;
        this.foilCapa = foilCapa;
        this.foilCsm = foilCsm;
        this.frshWtrCapa = frshWtrCapa;
        this.frshWtrCsm = frshWtrCsm;
        this.gnrBhpPwr = gnrBhpPwr;
        this.gnrMkrNm = gnrMkrNm;
        this.gnrRpmPwr = gnrRpmPwr;
        this.gnrTpDesc = gnrTpDesc;
        this.grsRgstTongWgt = grsRgstTongWgt;
        this.intlTongCertiFlg = intlTongCertiFlg;
        this.lbpLen = lbpLen;
        this.lgtShpTongWgt = lgtShpTongWgt;
        this.lloydNo = lloydNo;
        this.loaLen = loaLen;
        this.madnVoySuzNetTongWgt = madnVoySuzNetTongWgt;
        this.maxSpd = maxSpd;
        this.mnEngHorPwrUtCd = mnEngHorPwrUtCd;
        this.mnEngBhpPwr = mnEngBhpPwr;
        this.mnEngMkrNm = mnEngMkrNm;
        this.mnEngRpmPwr = mnEngRpmPwr;
        this.mnEngTpDesc = mnEngTpDesc;
        this.netRgstTongWgt = netRgstTongWgt;
        this.phnNo = phnNo;
        this.piclbDesc = piclbDesc;
        this.pnmGtWgt = pnmGtWgt;
        this.pnmNetTongWgt = pnmNetTongWgt;
        this.rfRcptKnt = rfRcptKnt;
        this.rfRcptMaxKnt = rfRcptMaxKnt;
        this.rgstDt = rgstDt;
        this.rgstNo = rgstNo;
        this.rgstPortCd = rgstPortCd;
        this.smrDrftHgt = smrDrftHgt;
        this.suzGtWgt = suzGtWgt;
        this.suzNetTongWgt = suzNetTongWgt;
        this.tlxNo = tlxNo;
        this.ttlTeuKnt = ttlTeuKnt;
        this.updDt = updDt;
        this.updUsrId = updUsrId;
        this.vslBldAreaNm = vslBldAreaNm;
        this.vslBldrNm = vslBldrNm;
        this.vslCd = vslCd;
        this.vslClssFlg = vslClssFlg;
        this.vslClssNo = vslClssNo;
        this.vslClzDt = vslClzDt;
        this.vslCreOfcCd = vslCreOfcCd;
        this.vslDeDt = vslDeDt;
        this.vslDeltOfcCd = vslDeltOfcCd;
        this.vslDpth = vslDpth;
        this.vslEdiNm = vslEdiNm;
        this.vslEml = vslEml;
        this.vslEngNm = vslEngNm;
        this.vslHgt = vslHgt;
        this.vslHlNo = vslHlNo;
        this.vslHldKnt = vslHldKnt;
        this.vslHtchKnt = vslHtchKnt;
        this.vslKelLyDt = vslKelLyDt;
        this.vslKrnNm = vslKrnNm;
        this.vslLnchDt = vslLnchDt;
        this.vslLoclNm = vslLoclNm;
        this.vslOwnIndCd = vslOwnIndCd;
        this.vslRgstCntCd = vslRgstCntCd;
        this.vslRmk = vslRmk;
        this.vslSvcSpd = vslSvcSpd;
        this.vslWdt = vslWdt;
        this.cudFlg = cudFlg;
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
        this.hashColumns.put("blst_tnk_capa", getBlstTnkCapa());
        this.hashColumns.put("bwthst_bhp_pwr", getBwthstBhpPwr());
        this.hashColumns.put("bwthst_mkr_nm", getBwthstMkrNm());
        this.hashColumns.put("bwthst_rpm_pwr", getBwthstRpmPwr());
        this.hashColumns.put("bwthst_tp_desc", getBwthstTpDesc());
        this.hashColumns.put("call_sgn_no", getCallSgnNo());
        this.hashColumns.put("clss_no_rgst_area_nm", getClssNoRgstAreaNm());
        this.hashColumns.put("cntr_dzn_capa", getCntrDznCapa());
        this.hashColumns.put("cntr_op_capa", getCntrOpCapa());
        this.hashColumns.put("cntr_pnm_capa", getCntrPnmCapa());
        this.hashColumns.put("cntr_vsl_clss_capa", getCntrVslClssCapa());
        this.hashColumns.put("co_cd", getCoCd());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("crr_cd", getCrrCd());
        this.hashColumns.put("crw_knt", getCrwKnt());
        this.hashColumns.put("delt_flg", getDeltFlg());
        this.hashColumns.put("doil_capa", getDoilCapa());
        this.hashColumns.put("doil_csm", getDoilCsm());
        this.hashColumns.put("dpl_capa", getDplCapa());
        this.hashColumns.put("dwt_wgt", getDwtWgt());
        this.hashColumns.put("ecn_spd", getEcnSpd());
        this.hashColumns.put("fax_no", getFaxNo());
        this.hashColumns.put("fbd_capa", getFbdCapa());
        this.hashColumns.put("fdr_div_cd", getFdrDivCd());
        this.hashColumns.put("foil_capa", getFoilCapa());
        this.hashColumns.put("foil_csm", getFoilCsm());
        this.hashColumns.put("frsh_wtr_capa", getFrshWtrCapa());
        this.hashColumns.put("frsh_wtr_csm", getFrshWtrCsm());
        this.hashColumns.put("gnr_bhp_pwr", getGnrBhpPwr());
        this.hashColumns.put("gnr_mkr_nm", getGnrMkrNm());
        this.hashColumns.put("gnr_rpm_pwr", getGnrRpmPwr());
        this.hashColumns.put("gnr_tp_desc", getGnrTpDesc());
        this.hashColumns.put("grs_rgst_tong_wgt", getGrsRgstTongWgt());
        this.hashColumns.put("intl_tong_certi_flg", getIntlTongCertiFlg());
        this.hashColumns.put("lbp_len", getLbpLen());
        this.hashColumns.put("lgt_shp_tong_wgt", getLgtShpTongWgt());
        this.hashColumns.put("lloyd_no", getLloydNo());
        this.hashColumns.put("loa_len", getLoaLen());
        this.hashColumns.put("madn_voy_suz_net_tong_wgt", getMadnVoySuzNetTongWgt());
        this.hashColumns.put("max_spd", getMaxSpd());
        this.hashColumns.put("mn_eng_hor_pwr_ut_cd", getMnEngHorPwrUtCd());
        this.hashColumns.put("mn_eng_bhp_pwr", getMnEngBhpPwr());
        this.hashColumns.put("mn_eng_mkr_nm", getMnEngMkrNm());
        this.hashColumns.put("mn_eng_rpm_pwr", getMnEngRpmPwr());
        this.hashColumns.put("mn_eng_tp_desc", getMnEngTpDesc());
        this.hashColumns.put("net_rgst_tong_wgt", getNetRgstTongWgt());
        this.hashColumns.put("phn_no", getPhnNo());
        this.hashColumns.put("piclb_desc", getPiclbDesc());
        this.hashColumns.put("pnm_gt_wgt", getPnmGtWgt());
        this.hashColumns.put("pnm_net_tong_wgt", getPnmNetTongWgt());
        this.hashColumns.put("rf_rcpt_knt", getRfRcptKnt());
        this.hashColumns.put("rf_rcpt_max_knt", getRfRcptMaxKnt());
        this.hashColumns.put("rgst_dt", getRgstDt());
        this.hashColumns.put("rgst_no", getRgstNo());
        this.hashColumns.put("rgst_port_cd", getRgstPortCd());
        this.hashColumns.put("smr_drft_hgt", getSmrDrftHgt());
        this.hashColumns.put("suz_gt_wgt", getSuzGtWgt());
        this.hashColumns.put("suz_net_tong_wgt", getSuzNetTongWgt());
        this.hashColumns.put("tlx_no", getTlxNo());
        this.hashColumns.put("ttl_teu_knt", getTtlTeuKnt());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("vsl_bld_area_nm", getVslBldAreaNm());
        this.hashColumns.put("vsl_bldr_nm", getVslBldrNm());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("vsl_clss_flg", getVslClssFlg());
        this.hashColumns.put("vsl_clss_no", getVslClssNo());
        this.hashColumns.put("vsl_clz_dt", getVslClzDt());
        this.hashColumns.put("vsl_cre_ofc_cd", getVslCreOfcCd());
        this.hashColumns.put("vsl_de_dt", getVslDeDt());
        this.hashColumns.put("vsl_delt_ofc_cd", getVslDeltOfcCd());
        this.hashColumns.put("vsl_dpth", getVslDpth());
        this.hashColumns.put("vsl_edi_nm", getVslEdiNm());
        this.hashColumns.put("vsl_eml", getVslEml());
        this.hashColumns.put("vsl_eng_nm", getVslEngNm());
        this.hashColumns.put("vsl_hgt", getVslHgt());
        this.hashColumns.put("vsl_hl_no", getVslHlNo());
        this.hashColumns.put("vsl_hld_knt", getVslHldKnt());
        this.hashColumns.put("vsl_htch_knt", getVslHtchKnt());
        this.hashColumns.put("vsl_kel_ly_dt", getVslKelLyDt());
        this.hashColumns.put("vsl_krn_nm", getVslKrnNm());
        this.hashColumns.put("vsl_lnch_dt", getVslLnchDt());
        this.hashColumns.put("vsl_locl_nm", getVslLoclNm());
        this.hashColumns.put("vsl_own_ind_cd", getVslOwnIndCd());
        this.hashColumns.put("vsl_rgst_cnt_cd", getVslRgstCntCd());
        this.hashColumns.put("vsl_rmk", getVslRmk());
        this.hashColumns.put("vsl_svc_spd", getVslSvcSpd());
        this.hashColumns.put("vsl_wdt", getVslWdt());
        this.hashColumns.put("cud_flg", getCudFlg());
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
        this.hashFields.put("blst_tnk_capa", "blstTnkCapa");
        this.hashFields.put("bwthst_bhp_pwr", "bwthstBhpPwr");
        this.hashFields.put("bwthst_mkr_nm", "bwthstMkrNm");
        this.hashFields.put("bwthst_rpm_pwr", "bwthstRpmPwr");
        this.hashFields.put("bwthst_tp_desc", "bwthstTpDesc");
        this.hashFields.put("call_sgn_no", "callSgnNo");
        this.hashFields.put("clss_no_rgst_area_nm", "clssNoRgstAreaNm");
        this.hashFields.put("cntr_dzn_capa", "cntrDznCapa");
        this.hashFields.put("cntr_op_capa", "cntrOpCapa");
        this.hashFields.put("cntr_pnm_capa", "cntrPnmCapa");
        this.hashFields.put("cntr_vsl_clss_capa", "cntrVslClssCapa");
        this.hashFields.put("co_cd", "coCd");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("crr_cd", "crrCd");
        this.hashFields.put("crw_knt", "crwKnt");
        this.hashFields.put("delt_flg", "deltFlg");
        this.hashFields.put("doil_capa", "doilCapa");
        this.hashFields.put("doil_csm", "doilCsm");
        this.hashFields.put("dpl_capa", "dplCapa");
        this.hashFields.put("dwt_wgt", "dwtWgt");
        this.hashFields.put("ecn_spd", "ecnSpd");
        this.hashFields.put("fax_no", "faxNo");
        this.hashFields.put("fbd_capa", "fbdCapa");
        this.hashFields.put("fdr_div_cd", "fdrDivCd");
        this.hashFields.put("foil_capa", "foilCapa");
        this.hashFields.put("foil_csm", "foilCsm");
        this.hashFields.put("frsh_wtr_capa", "frshWtrCapa");
        this.hashFields.put("frsh_wtr_csm", "frshWtrCsm");
        this.hashFields.put("gnr_bhp_pwr", "gnrBhpPwr");
        this.hashFields.put("gnr_mkr_nm", "gnrMkrNm");
        this.hashFields.put("gnr_rpm_pwr", "gnrRpmPwr");
        this.hashFields.put("gnr_tp_desc", "gnrTpDesc");
        this.hashFields.put("grs_rgst_tong_wgt", "grsRgstTongWgt");
        this.hashFields.put("intl_tong_certi_flg", "intlTongCertiFlg");
        this.hashFields.put("lbp_len", "lbpLen");
        this.hashFields.put("lgt_shp_tong_wgt", "lgtShpTongWgt");
        this.hashFields.put("lloyd_no", "lloydNo");
        this.hashFields.put("loa_len", "loaLen");
        this.hashFields.put("madn_voy_suz_net_tong_wgt", "madnVoySuzNetTongWgt");
        this.hashFields.put("max_spd", "maxSpd");
        this.hashFields.put("mn_eng_hor_pwr_ut_cd", "mnEngHorPwrUtCd");
        this.hashFields.put("mn_eng_bhp_pwr", "mnEngBhpPwr");
        this.hashFields.put("mn_eng_mkr_nm", "mnEngMkrNm");
        this.hashFields.put("mn_eng_rpm_pwr", "mnEngRpmPwr");
        this.hashFields.put("mn_eng_tp_desc", "mnEngTpDesc");
        this.hashFields.put("net_rgst_tong_wgt", "netRgstTongWgt");
        this.hashFields.put("phn_no", "phnNo");
        this.hashFields.put("piclb_desc", "piclbDesc");
        this.hashFields.put("pnm_gt_wgt", "pnmGtWgt");
        this.hashFields.put("pnm_net_tong_wgt", "pnmNetTongWgt");
        this.hashFields.put("rf_rcpt_knt", "rfRcptKnt");
        this.hashFields.put("rf_rcpt_max_knt", "rfRcptMaxKnt");
        this.hashFields.put("rgst_dt", "rgstDt");
        this.hashFields.put("rgst_no", "rgstNo");
        this.hashFields.put("rgst_port_cd", "rgstPortCd");
        this.hashFields.put("smr_drft_hgt", "smrDrftHgt");
        this.hashFields.put("suz_gt_wgt", "suzGtWgt");
        this.hashFields.put("suz_net_tong_wgt", "suzNetTongWgt");
        this.hashFields.put("tlx_no", "tlxNo");
        this.hashFields.put("ttl_teu_knt", "ttlTeuKnt");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("vsl_bld_area_nm", "vslBldAreaNm");
        this.hashFields.put("vsl_bldr_nm", "vslBldrNm");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("vsl_clss_flg", "vslClssFlg");
        this.hashFields.put("vsl_clss_no", "vslClssNo");
        this.hashFields.put("vsl_clz_dt", "vslClzDt");
        this.hashFields.put("vsl_cre_ofc_cd", "vslCreOfcCd");
        this.hashFields.put("vsl_de_dt", "vslDeDt");
        this.hashFields.put("vsl_delt_ofc_cd", "vslDeltOfcCd");
        this.hashFields.put("vsl_dpth", "vslDpth");
        this.hashFields.put("vsl_edi_nm", "vslEdiNm");
        this.hashFields.put("vsl_eml", "vslEml");
        this.hashFields.put("vsl_eng_nm", "vslEngNm");
        this.hashFields.put("vsl_hgt", "vslHgt");
        this.hashFields.put("vsl_hl_no", "vslHlNo");
        this.hashFields.put("vsl_hld_knt", "vslHldKnt");
        this.hashFields.put("vsl_htch_knt", "vslHtchKnt");
        this.hashFields.put("vsl_kel_ly_dt", "vslKelLyDt");
        this.hashFields.put("vsl_krn_nm", "vslKrnNm");
        this.hashFields.put("vsl_lnch_dt", "vslLnchDt");
        this.hashFields.put("vsl_locl_nm", "vslLoclNm");
        this.hashFields.put("vsl_own_ind_cd", "vslOwnIndCd");
        this.hashFields.put("vsl_rgst_cnt_cd", "vslRgstCntCd");
        this.hashFields.put("vsl_rmk", "vslRmk");
        this.hashFields.put("vsl_svc_spd", "vslSvcSpd");
        this.hashFields.put("vsl_wdt", "vslWdt");
        this.hashFields.put("cud_flg", "cudFlg");
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
	 * @param String mnEngHorPwrUtCd
	 */
    public void setMnEngHorPwrUtCd(String mnEngHorPwrUtCd) {
        this.mnEngHorPwrUtCd = mnEngHorPwrUtCd;
    }

    /**
	 * 
	 * @return String mnEngHorPwrUtCd
	 */
    public String getMnEngHorPwrUtCd() {
        return this.mnEngHorPwrUtCd;
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
	 * @param String vslKrnNm
	 */
    public void setVslKrnNm(String vslKrnNm) {
        this.vslKrnNm = vslKrnNm;
    }

    /**
	 * 
	 * @return String vslKrnNm
	 */
    public String getVslKrnNm() {
        return this.vslKrnNm;
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
	 * @param String cudFlg
	 */
    public void setCudFlg(String cudFlg) {
        this.cudFlg = cudFlg;
    }

    /**
	 * 
	 * @return String cudFlg
	 */
    public String getCudFlg() {
        return this.cudFlg;
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
        setBlstTnkCapa(JSPUtil.getParameter(request, prefix + "blst_tnk_capa", ""));
        setBwthstBhpPwr(JSPUtil.getParameter(request, prefix + "bwthst_bhp_pwr", ""));
        setBwthstMkrNm(JSPUtil.getParameter(request, prefix + "bwthst_mkr_nm", ""));
        setBwthstRpmPwr(JSPUtil.getParameter(request, prefix + "bwthst_rpm_pwr", ""));
        setBwthstTpDesc(JSPUtil.getParameter(request, prefix + "bwthst_tp_desc", ""));
        setCallSgnNo(JSPUtil.getParameter(request, prefix + "call_sgn_no", ""));
        setClssNoRgstAreaNm(JSPUtil.getParameter(request, prefix + "clss_no_rgst_area_nm", ""));
        setCntrDznCapa(JSPUtil.getParameter(request, prefix + "cntr_dzn_capa", ""));
        setCntrOpCapa(JSPUtil.getParameter(request, prefix + "cntr_op_capa", ""));
        setCntrPnmCapa(JSPUtil.getParameter(request, prefix + "cntr_pnm_capa", ""));
        setCntrVslClssCapa(JSPUtil.getParameter(request, prefix + "cntr_vsl_clss_capa", ""));
        setCoCd(JSPUtil.getParameter(request, prefix + "co_cd", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
        setCrwKnt(JSPUtil.getParameter(request, prefix + "crw_knt", ""));
        setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
        setDoilCapa(JSPUtil.getParameter(request, prefix + "doil_capa", ""));
        setDoilCsm(JSPUtil.getParameter(request, prefix + "doil_csm", ""));
        setDplCapa(JSPUtil.getParameter(request, prefix + "dpl_capa", ""));
        setDwtWgt(JSPUtil.getParameter(request, prefix + "dwt_wgt", ""));
        setEcnSpd(JSPUtil.getParameter(request, prefix + "ecn_spd", ""));
        setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
        setFbdCapa(JSPUtil.getParameter(request, prefix + "fbd_capa", ""));
        setFdrDivCd(JSPUtil.getParameter(request, prefix + "fdr_div_cd", ""));
        setFoilCapa(JSPUtil.getParameter(request, prefix + "foil_capa", ""));
        setFoilCsm(JSPUtil.getParameter(request, prefix + "foil_csm", ""));
        setFrshWtrCapa(JSPUtil.getParameter(request, prefix + "frsh_wtr_capa", ""));
        setFrshWtrCsm(JSPUtil.getParameter(request, prefix + "frsh_wtr_csm", ""));
        setGnrBhpPwr(JSPUtil.getParameter(request, prefix + "gnr_bhp_pwr", ""));
        setGnrMkrNm(JSPUtil.getParameter(request, prefix + "gnr_mkr_nm", ""));
        setGnrRpmPwr(JSPUtil.getParameter(request, prefix + "gnr_rpm_pwr", ""));
        setGnrTpDesc(JSPUtil.getParameter(request, prefix + "gnr_tp_desc", ""));
        setGrsRgstTongWgt(JSPUtil.getParameter(request, prefix + "grs_rgst_tong_wgt", ""));
        setIntlTongCertiFlg(JSPUtil.getParameter(request, prefix + "intl_tong_certi_flg", ""));
        setLbpLen(JSPUtil.getParameter(request, prefix + "lbp_len", ""));
        setLgtShpTongWgt(JSPUtil.getParameter(request, prefix + "lgt_shp_tong_wgt", ""));
        setLloydNo(JSPUtil.getParameter(request, prefix + "lloyd_no", ""));
        setLoaLen(JSPUtil.getParameter(request, prefix + "loa_len", ""));
        setMadnVoySuzNetTongWgt(JSPUtil.getParameter(request, prefix + "madn_voy_suz_net_tong_wgt", ""));
        setMaxSpd(JSPUtil.getParameter(request, prefix + "max_spd", ""));
        setMnEngHorPwrUtCd(JSPUtil.getParameter(request, prefix + "mn_eng_hor_pwr_ut_cd", ""));
        setMnEngBhpPwr(JSPUtil.getParameter(request, prefix + "mn_eng_bhp_pwr", ""));
        setMnEngMkrNm(JSPUtil.getParameter(request, prefix + "mn_eng_mkr_nm", ""));
        setMnEngRpmPwr(JSPUtil.getParameter(request, prefix + "mn_eng_rpm_pwr", ""));
        setMnEngTpDesc(JSPUtil.getParameter(request, prefix + "mn_eng_tp_desc", ""));
        setNetRgstTongWgt(JSPUtil.getParameter(request, prefix + "net_rgst_tong_wgt", ""));
        setPhnNo(JSPUtil.getParameter(request, prefix + "phn_no", ""));
        setPiclbDesc(JSPUtil.getParameter(request, prefix + "piclb_desc", ""));
        setPnmGtWgt(JSPUtil.getParameter(request, prefix + "pnm_gt_wgt", ""));
        setPnmNetTongWgt(JSPUtil.getParameter(request, prefix + "pnm_net_tong_wgt", ""));
        setRfRcptKnt(JSPUtil.getParameter(request, prefix + "rf_rcpt_knt", ""));
        setRfRcptMaxKnt(JSPUtil.getParameter(request, prefix + "rf_rcpt_max_knt", ""));
        setRgstDt(JSPUtil.getParameter(request, prefix + "rgst_dt", ""));
        setRgstNo(JSPUtil.getParameter(request, prefix + "rgst_no", ""));
        setRgstPortCd(JSPUtil.getParameter(request, prefix + "rgst_port_cd", ""));
        setSmrDrftHgt(JSPUtil.getParameter(request, prefix + "smr_drft_hgt", ""));
        setSuzGtWgt(JSPUtil.getParameter(request, prefix + "suz_gt_wgt", ""));
        setSuzNetTongWgt(JSPUtil.getParameter(request, prefix + "suz_net_tong_wgt", ""));
        setTlxNo(JSPUtil.getParameter(request, prefix + "tlx_no", ""));
        setTtlTeuKnt(JSPUtil.getParameter(request, prefix + "ttl_teu_knt", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setVslBldAreaNm(JSPUtil.getParameter(request, prefix + "vsl_bld_area_nm", ""));
        setVslBldrNm(JSPUtil.getParameter(request, prefix + "vsl_bldr_nm", ""));
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setVslClssFlg(JSPUtil.getParameter(request, prefix + "vsl_clss_flg", ""));
        setVslClssNo(JSPUtil.getParameter(request, prefix + "vsl_clss_no", ""));
        setVslClzDt(JSPUtil.getParameter(request, prefix + "vsl_clz_dt", ""));
        setVslCreOfcCd(JSPUtil.getParameter(request, prefix + "vsl_cre_ofc_cd", ""));
        setVslDeDt(JSPUtil.getParameter(request, prefix + "vsl_de_dt", ""));
        setVslDeltOfcCd(JSPUtil.getParameter(request, prefix + "vsl_delt_ofc_cd", ""));
        setVslDpth(JSPUtil.getParameter(request, prefix + "vsl_dpth", ""));
        setVslEdiNm(JSPUtil.getParameter(request, prefix + "vsl_edi_nm", ""));
        setVslEml(JSPUtil.getParameter(request, prefix + "vsl_eml", ""));
        setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
        setVslHgt(JSPUtil.getParameter(request, prefix + "vsl_hgt", ""));
        setVslHlNo(JSPUtil.getParameter(request, prefix + "vsl_hl_no", ""));
        setVslHldKnt(JSPUtil.getParameter(request, prefix + "vsl_hld_knt", ""));
        setVslHtchKnt(JSPUtil.getParameter(request, prefix + "vsl_htch_knt", ""));
        setVslKelLyDt(JSPUtil.getParameter(request, prefix + "vsl_kel_ly_dt", ""));
        setVslKrnNm(JSPUtil.getParameter(request, prefix + "vsl_krn_nm", ""));
        setVslLnchDt(JSPUtil.getParameter(request, prefix + "vsl_lnch_dt", ""));
        setVslLoclNm(JSPUtil.getParameter(request, prefix + "vsl_locl_nm", ""));
        setVslOwnIndCd(JSPUtil.getParameter(request, prefix + "vsl_own_ind_cd", ""));
        setVslRgstCntCd(JSPUtil.getParameter(request, prefix + "vsl_rgst_cnt_cd", ""));
        setVslRmk(JSPUtil.getParameter(request, prefix + "vsl_rmk", ""));
        setVslSvcSpd(JSPUtil.getParameter(request, prefix + "vsl_svc_spd", ""));
        setVslWdt(JSPUtil.getParameter(request, prefix + "vsl_wdt", ""));
        setCudFlg(JSPUtil.getParameter(request, prefix + "cud_flg", ""));
        setEaiEvntDt(JSPUtil.getParameter(request, prefix + "eai_evnt_dt", ""));
        setEaiIfId(JSPUtil.getParameter(request, prefix + "eai_if_id", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ContainerVesselMainIfVO[]
	 */
    public ContainerVesselMainIfVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ContainerVesselMainIfVO[]
	 */
    public ContainerVesselMainIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ContainerVesselMainIfVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] blstTnkCapa = (JSPUtil.getParameter(request, prefix + "blst_tnk_capa", length));
            String[] bwthstBhpPwr = (JSPUtil.getParameter(request, prefix + "bwthst_bhp_pwr", length));
            String[] bwthstMkrNm = (JSPUtil.getParameter(request, prefix + "bwthst_mkr_nm", length));
            String[] bwthstRpmPwr = (JSPUtil.getParameter(request, prefix + "bwthst_rpm_pwr", length));
            String[] bwthstTpDesc = (JSPUtil.getParameter(request, prefix + "bwthst_tp_desc", length));
            String[] callSgnNo = (JSPUtil.getParameter(request, prefix + "call_sgn_no", length));
            String[] clssNoRgstAreaNm = (JSPUtil.getParameter(request, prefix + "clss_no_rgst_area_nm", length));
            String[] cntrDznCapa = (JSPUtil.getParameter(request, prefix + "cntr_dzn_capa", length));
            String[] cntrOpCapa = (JSPUtil.getParameter(request, prefix + "cntr_op_capa", length));
            String[] cntrPnmCapa = (JSPUtil.getParameter(request, prefix + "cntr_pnm_capa", length));
            String[] cntrVslClssCapa = (JSPUtil.getParameter(request, prefix + "cntr_vsl_clss_capa", length));
            String[] coCd = (JSPUtil.getParameter(request, prefix + "co_cd", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] crrCd = (JSPUtil.getParameter(request, prefix + "crr_cd", length));
            String[] crwKnt = (JSPUtil.getParameter(request, prefix + "crw_knt", length));
            String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
            String[] doilCapa = (JSPUtil.getParameter(request, prefix + "doil_capa", length));
            String[] doilCsm = (JSPUtil.getParameter(request, prefix + "doil_csm", length));
            String[] dplCapa = (JSPUtil.getParameter(request, prefix + "dpl_capa", length));
            String[] dwtWgt = (JSPUtil.getParameter(request, prefix + "dwt_wgt", length));
            String[] ecnSpd = (JSPUtil.getParameter(request, prefix + "ecn_spd", length));
            String[] faxNo = (JSPUtil.getParameter(request, prefix + "fax_no", length));
            String[] fbdCapa = (JSPUtil.getParameter(request, prefix + "fbd_capa", length));
            String[] fdrDivCd = (JSPUtil.getParameter(request, prefix + "fdr_div_cd", length));
            String[] foilCapa = (JSPUtil.getParameter(request, prefix + "foil_capa", length));
            String[] foilCsm = (JSPUtil.getParameter(request, prefix + "foil_csm", length));
            String[] frshWtrCapa = (JSPUtil.getParameter(request, prefix + "frsh_wtr_capa", length));
            String[] frshWtrCsm = (JSPUtil.getParameter(request, prefix + "frsh_wtr_csm", length));
            String[] gnrBhpPwr = (JSPUtil.getParameter(request, prefix + "gnr_bhp_pwr", length));
            String[] gnrMkrNm = (JSPUtil.getParameter(request, prefix + "gnr_mkr_nm", length));
            String[] gnrRpmPwr = (JSPUtil.getParameter(request, prefix + "gnr_rpm_pwr", length));
            String[] gnrTpDesc = (JSPUtil.getParameter(request, prefix + "gnr_tp_desc", length));
            String[] grsRgstTongWgt = (JSPUtil.getParameter(request, prefix + "grs_rgst_tong_wgt", length));
            String[] intlTongCertiFlg = (JSPUtil.getParameter(request, prefix + "intl_tong_certi_flg", length));
            String[] lbpLen = (JSPUtil.getParameter(request, prefix + "lbp_len", length));
            String[] lgtShpTongWgt = (JSPUtil.getParameter(request, prefix + "lgt_shp_tong_wgt", length));
            String[] lloydNo = (JSPUtil.getParameter(request, prefix + "lloyd_no", length));
            String[] loaLen = (JSPUtil.getParameter(request, prefix + "loa_len", length));
            String[] madnVoySuzNetTongWgt = (JSPUtil.getParameter(request, prefix + "madn_voy_suz_net_tong_wgt", length));
            String[] maxSpd = (JSPUtil.getParameter(request, prefix + "max_spd", length));
            String[] mnEngHorPwrUtCd = (JSPUtil.getParameter(request, prefix + "mn_eng_hor_pwr_ut_cd", length));
            String[] mnEngBhpPwr = (JSPUtil.getParameter(request, prefix + "mn_eng_bhp_pwr", length));
            String[] mnEngMkrNm = (JSPUtil.getParameter(request, prefix + "mn_eng_mkr_nm", length));
            String[] mnEngRpmPwr = (JSPUtil.getParameter(request, prefix + "mn_eng_rpm_pwr", length));
            String[] mnEngTpDesc = (JSPUtil.getParameter(request, prefix + "mn_eng_tp_desc", length));
            String[] netRgstTongWgt = (JSPUtil.getParameter(request, prefix + "net_rgst_tong_wgt", length));
            String[] phnNo = (JSPUtil.getParameter(request, prefix + "phn_no", length));
            String[] piclbDesc = (JSPUtil.getParameter(request, prefix + "piclb_desc", length));
            String[] pnmGtWgt = (JSPUtil.getParameter(request, prefix + "pnm_gt_wgt", length));
            String[] pnmNetTongWgt = (JSPUtil.getParameter(request, prefix + "pnm_net_tong_wgt", length));
            String[] rfRcptKnt = (JSPUtil.getParameter(request, prefix + "rf_rcpt_knt", length));
            String[] rfRcptMaxKnt = (JSPUtil.getParameter(request, prefix + "rf_rcpt_max_knt", length));
            String[] rgstDt = (JSPUtil.getParameter(request, prefix + "rgst_dt", length));
            String[] rgstNo = (JSPUtil.getParameter(request, prefix + "rgst_no", length));
            String[] rgstPortCd = (JSPUtil.getParameter(request, prefix + "rgst_port_cd", length));
            String[] smrDrftHgt = (JSPUtil.getParameter(request, prefix + "smr_drft_hgt", length));
            String[] suzGtWgt = (JSPUtil.getParameter(request, prefix + "suz_gt_wgt", length));
            String[] suzNetTongWgt = (JSPUtil.getParameter(request, prefix + "suz_net_tong_wgt", length));
            String[] tlxNo = (JSPUtil.getParameter(request, prefix + "tlx_no", length));
            String[] ttlTeuKnt = (JSPUtil.getParameter(request, prefix + "ttl_teu_knt", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] vslBldAreaNm = (JSPUtil.getParameter(request, prefix + "vsl_bld_area_nm", length));
            String[] vslBldrNm = (JSPUtil.getParameter(request, prefix + "vsl_bldr_nm", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] vslClssFlg = (JSPUtil.getParameter(request, prefix + "vsl_clss_flg", length));
            String[] vslClssNo = (JSPUtil.getParameter(request, prefix + "vsl_clss_no", length));
            String[] vslClzDt = (JSPUtil.getParameter(request, prefix + "vsl_clz_dt", length));
            String[] vslCreOfcCd = (JSPUtil.getParameter(request, prefix + "vsl_cre_ofc_cd", length));
            String[] vslDeDt = (JSPUtil.getParameter(request, prefix + "vsl_de_dt", length));
            String[] vslDeltOfcCd = (JSPUtil.getParameter(request, prefix + "vsl_delt_ofc_cd", length));
            String[] vslDpth = (JSPUtil.getParameter(request, prefix + "vsl_dpth", length));
            String[] vslEdiNm = (JSPUtil.getParameter(request, prefix + "vsl_edi_nm", length));
            String[] vslEml = (JSPUtil.getParameter(request, prefix + "vsl_eml", length));
            String[] vslEngNm = (JSPUtil.getParameter(request, prefix + "vsl_eng_nm", length));
            String[] vslHgt = (JSPUtil.getParameter(request, prefix + "vsl_hgt", length));
            String[] vslHlNo = (JSPUtil.getParameter(request, prefix + "vsl_hl_no", length));
            String[] vslHldKnt = (JSPUtil.getParameter(request, prefix + "vsl_hld_knt", length));
            String[] vslHtchKnt = (JSPUtil.getParameter(request, prefix + "vsl_htch_knt", length));
            String[] vslKelLyDt = (JSPUtil.getParameter(request, prefix + "vsl_kel_ly_dt", length));
            String[] vslKrnNm = (JSPUtil.getParameter(request, prefix + "vsl_krn_nm", length));
            String[] vslLnchDt = (JSPUtil.getParameter(request, prefix + "vsl_lnch_dt", length));
            String[] vslLoclNm = (JSPUtil.getParameter(request, prefix + "vsl_locl_nm", length));
            String[] vslOwnIndCd = (JSPUtil.getParameter(request, prefix + "vsl_own_ind_cd", length));
            String[] vslRgstCntCd = (JSPUtil.getParameter(request, prefix + "vsl_rgst_cnt_cd", length));
            String[] vslRmk = (JSPUtil.getParameter(request, prefix + "vsl_rmk", length));
            String[] vslSvcSpd = (JSPUtil.getParameter(request, prefix + "vsl_svc_spd", length));
            String[] vslWdt = (JSPUtil.getParameter(request, prefix + "vsl_wdt", length));
            String[] cudFlg = (JSPUtil.getParameter(request, prefix + "cud_flg", length));
            String[] eaiEvntDt = (JSPUtil.getParameter(request, prefix + "eai_evnt_dt", length));
	    	String[] eaiIfId = (JSPUtil.getParameter(request, prefix + "eai_if_id", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new ContainerVesselMainIfVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (blstTnkCapa[i] != null)
                    model.setBlstTnkCapa(blstTnkCapa[i]);
                if (bwthstBhpPwr[i] != null)
                    model.setBwthstBhpPwr(bwthstBhpPwr[i]);
                if (bwthstMkrNm[i] != null)
                    model.setBwthstMkrNm(bwthstMkrNm[i]);
                if (bwthstRpmPwr[i] != null)
                    model.setBwthstRpmPwr(bwthstRpmPwr[i]);
                if (bwthstTpDesc[i] != null)
                    model.setBwthstTpDesc(bwthstTpDesc[i]);
                if (callSgnNo[i] != null)
                    model.setCallSgnNo(callSgnNo[i]);
                if (clssNoRgstAreaNm[i] != null)
                    model.setClssNoRgstAreaNm(clssNoRgstAreaNm[i]);
                if (cntrDznCapa[i] != null)
                    model.setCntrDznCapa(cntrDznCapa[i]);
                if (cntrOpCapa[i] != null)
                    model.setCntrOpCapa(cntrOpCapa[i]);
                if (cntrPnmCapa[i] != null)
                    model.setCntrPnmCapa(cntrPnmCapa[i]);
                if (cntrVslClssCapa[i] != null)
                    model.setCntrVslClssCapa(cntrVslClssCapa[i]);
                if (coCd[i] != null)
                    model.setCoCd(coCd[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (crrCd[i] != null)
                    model.setCrrCd(crrCd[i]);
                if (crwKnt[i] != null)
                    model.setCrwKnt(crwKnt[i]);
                if (deltFlg[i] != null)
                    model.setDeltFlg(deltFlg[i]);
                if (doilCapa[i] != null)
                    model.setDoilCapa(doilCapa[i]);
                if (doilCsm[i] != null)
                    model.setDoilCsm(doilCsm[i]);
                if (dplCapa[i] != null)
                    model.setDplCapa(dplCapa[i]);
                if (dwtWgt[i] != null)
                    model.setDwtWgt(dwtWgt[i]);
                if (ecnSpd[i] != null)
                    model.setEcnSpd(ecnSpd[i]);
                if (faxNo[i] != null)
                    model.setFaxNo(faxNo[i]);
                if (fbdCapa[i] != null)
                    model.setFbdCapa(fbdCapa[i]);
                if (fdrDivCd[i] != null)
                    model.setFdrDivCd(fdrDivCd[i]);
                if (foilCapa[i] != null)
                    model.setFoilCapa(foilCapa[i]);
                if (foilCsm[i] != null)
                    model.setFoilCsm(foilCsm[i]);
                if (frshWtrCapa[i] != null)
                    model.setFrshWtrCapa(frshWtrCapa[i]);
                if (frshWtrCsm[i] != null)
                    model.setFrshWtrCsm(frshWtrCsm[i]);
                if (gnrBhpPwr[i] != null)
                    model.setGnrBhpPwr(gnrBhpPwr[i]);
                if (gnrMkrNm[i] != null)
                    model.setGnrMkrNm(gnrMkrNm[i]);
                if (gnrRpmPwr[i] != null)
                    model.setGnrRpmPwr(gnrRpmPwr[i]);
                if (gnrTpDesc[i] != null)
                    model.setGnrTpDesc(gnrTpDesc[i]);
                if (grsRgstTongWgt[i] != null)
                    model.setGrsRgstTongWgt(grsRgstTongWgt[i]);
                if (intlTongCertiFlg[i] != null)
                    model.setIntlTongCertiFlg(intlTongCertiFlg[i]);
                if (lbpLen[i] != null)
                    model.setLbpLen(lbpLen[i]);
                if (lgtShpTongWgt[i] != null)
                    model.setLgtShpTongWgt(lgtShpTongWgt[i]);
                if (lloydNo[i] != null)
                    model.setLloydNo(lloydNo[i]);
                if (loaLen[i] != null)
                    model.setLoaLen(loaLen[i]);
                if (madnVoySuzNetTongWgt[i] != null)
                    model.setMadnVoySuzNetTongWgt(madnVoySuzNetTongWgt[i]);
                if (maxSpd[i] != null)
                    model.setMaxSpd(maxSpd[i]);
                if (mnEngHorPwrUtCd[i] != null)
                    model.setMnEngHorPwrUtCd(mnEngHorPwrUtCd[i]);
                if (mnEngBhpPwr[i] != null)
                    model.setMnEngBhpPwr(mnEngBhpPwr[i]);
                if (mnEngMkrNm[i] != null)
                    model.setMnEngMkrNm(mnEngMkrNm[i]);
                if (mnEngRpmPwr[i] != null)
                    model.setMnEngRpmPwr(mnEngRpmPwr[i]);
                if (mnEngTpDesc[i] != null)
                    model.setMnEngTpDesc(mnEngTpDesc[i]);
                if (netRgstTongWgt[i] != null)
                    model.setNetRgstTongWgt(netRgstTongWgt[i]);
                if (phnNo[i] != null)
                    model.setPhnNo(phnNo[i]);
                if (piclbDesc[i] != null)
                    model.setPiclbDesc(piclbDesc[i]);
                if (pnmGtWgt[i] != null)
                    model.setPnmGtWgt(pnmGtWgt[i]);
                if (pnmNetTongWgt[i] != null)
                    model.setPnmNetTongWgt(pnmNetTongWgt[i]);
                if (rfRcptKnt[i] != null)
                    model.setRfRcptKnt(rfRcptKnt[i]);
                if (rfRcptMaxKnt[i] != null)
                    model.setRfRcptMaxKnt(rfRcptMaxKnt[i]);
                if (rgstDt[i] != null)
                    model.setRgstDt(rgstDt[i]);
                if (rgstNo[i] != null)
                    model.setRgstNo(rgstNo[i]);
                if (rgstPortCd[i] != null)
                    model.setRgstPortCd(rgstPortCd[i]);
                if (smrDrftHgt[i] != null)
                    model.setSmrDrftHgt(smrDrftHgt[i]);
                if (suzGtWgt[i] != null)
                    model.setSuzGtWgt(suzGtWgt[i]);
                if (suzNetTongWgt[i] != null)
                    model.setSuzNetTongWgt(suzNetTongWgt[i]);
                if (tlxNo[i] != null)
                    model.setTlxNo(tlxNo[i]);
                if (ttlTeuKnt[i] != null)
                    model.setTtlTeuKnt(ttlTeuKnt[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (vslBldAreaNm[i] != null)
                    model.setVslBldAreaNm(vslBldAreaNm[i]);
                if (vslBldrNm[i] != null)
                    model.setVslBldrNm(vslBldrNm[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (vslClssFlg[i] != null)
                    model.setVslClssFlg(vslClssFlg[i]);
                if (vslClssNo[i] != null)
                    model.setVslClssNo(vslClssNo[i]);
                if (vslClzDt[i] != null)
                    model.setVslClzDt(vslClzDt[i]);
                if (vslCreOfcCd[i] != null)
                    model.setVslCreOfcCd(vslCreOfcCd[i]);
                if (vslDeDt[i] != null)
                    model.setVslDeDt(vslDeDt[i]);
                if (vslDeltOfcCd[i] != null)
                    model.setVslDeltOfcCd(vslDeltOfcCd[i]);
                if (vslDpth[i] != null)
                    model.setVslDpth(vslDpth[i]);
                if (vslEdiNm[i] != null)
                    model.setVslEdiNm(vslEdiNm[i]);
                if (vslEml[i] != null)
                    model.setVslEml(vslEml[i]);
                if (vslEngNm[i] != null)
                    model.setVslEngNm(vslEngNm[i]);
                if (vslHgt[i] != null)
                    model.setVslHgt(vslHgt[i]);
                if (vslHlNo[i] != null)
                    model.setVslHlNo(vslHlNo[i]);
                if (vslHldKnt[i] != null)
                    model.setVslHldKnt(vslHldKnt[i]);
                if (vslHtchKnt[i] != null)
                    model.setVslHtchKnt(vslHtchKnt[i]);
                if (vslKelLyDt[i] != null)
                    model.setVslKelLyDt(vslKelLyDt[i]);
                if (vslKrnNm[i] != null)
                    model.setVslKrnNm(vslKrnNm[i]);
                if (vslLnchDt[i] != null)
                    model.setVslLnchDt(vslLnchDt[i]);
                if (vslLoclNm[i] != null)
                    model.setVslLoclNm(vslLoclNm[i]);
                if (vslOwnIndCd[i] != null)
                    model.setVslOwnIndCd(vslOwnIndCd[i]);
                if (vslRgstCntCd[i] != null)
                    model.setVslRgstCntCd(vslRgstCntCd[i]);
                if (vslRmk[i] != null)
                    model.setVslRmk(vslRmk[i]);
                if (vslSvcSpd[i] != null)
                    model.setVslSvcSpd(vslSvcSpd[i]);
                if (vslWdt[i] != null)
                    model.setVslWdt(vslWdt[i]);
                if (cudFlg[i] != null)
                    model.setCudFlg(cudFlg[i]);
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
        return getContainerVesselMainIfVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return ContainerVesselMainIfVO[]
	 */
    public ContainerVesselMainIfVO[] getContainerVesselMainIfVOs() {
        ContainerVesselMainIfVO[] vos = (ContainerVesselMainIfVO[]) models.toArray(new ContainerVesselMainIfVO[models.size()]);
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
        this.blstTnkCapa = this.blstTnkCapa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bwthstBhpPwr = this.bwthstBhpPwr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bwthstMkrNm = this.bwthstMkrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bwthstRpmPwr = this.bwthstRpmPwr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bwthstTpDesc = this.bwthstTpDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.callSgnNo = this.callSgnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.clssNoRgstAreaNm = this.clssNoRgstAreaNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrDznCapa = this.cntrDznCapa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrOpCapa = this.cntrOpCapa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrPnmCapa = this.cntrPnmCapa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrVslClssCapa = this.cntrVslClssCapa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.coCd = this.coCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crrCd = this.crrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crwKnt = this.crwKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.doilCapa = this.doilCapa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.doilCsm = this.doilCsm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dplCapa = this.dplCapa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dwtWgt = this.dwtWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecnSpd = this.ecnSpd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.faxNo = this.faxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fbdCapa = this.fbdCapa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fdrDivCd = this.fdrDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.foilCapa = this.foilCapa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.foilCsm = this.foilCsm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frshWtrCapa = this.frshWtrCapa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frshWtrCsm = this.frshWtrCsm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.gnrBhpPwr = this.gnrBhpPwr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.gnrMkrNm = this.gnrMkrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.gnrRpmPwr = this.gnrRpmPwr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.gnrTpDesc = this.gnrTpDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.grsRgstTongWgt = this.grsRgstTongWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intlTongCertiFlg = this.intlTongCertiFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lbpLen = this.lbpLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lgtShpTongWgt = this.lgtShpTongWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lloydNo = this.lloydNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.loaLen = this.loaLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.madnVoySuzNetTongWgt = this.madnVoySuzNetTongWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.maxSpd = this.maxSpd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mnEngHorPwrUtCd = this.mnEngHorPwrUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mnEngBhpPwr = this.mnEngBhpPwr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mnEngMkrNm = this.mnEngMkrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mnEngRpmPwr = this.mnEngRpmPwr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mnEngTpDesc = this.mnEngTpDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.netRgstTongWgt = this.netRgstTongWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.phnNo = this.phnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.piclbDesc = this.piclbDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pnmGtWgt = this.pnmGtWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pnmNetTongWgt = this.pnmNetTongWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfRcptKnt = this.rfRcptKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfRcptMaxKnt = this.rfRcptMaxKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rgstDt = this.rgstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rgstNo = this.rgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rgstPortCd = this.rgstPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.smrDrftHgt = this.smrDrftHgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.suzGtWgt = this.suzGtWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.suzNetTongWgt = this.suzNetTongWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tlxNo = this.tlxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ttlTeuKnt = this.ttlTeuKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslBldAreaNm = this.vslBldAreaNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslBldrNm = this.vslBldrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslClssFlg = this.vslClssFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslClssNo = this.vslClssNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslClzDt = this.vslClzDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCreOfcCd = this.vslCreOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslDeDt = this.vslDeDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslDeltOfcCd = this.vslDeltOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslDpth = this.vslDpth.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslEdiNm = this.vslEdiNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslEml = this.vslEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslEngNm = this.vslEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslHgt = this.vslHgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslHlNo = this.vslHlNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslHldKnt = this.vslHldKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslHtchKnt = this.vslHtchKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslKelLyDt = this.vslKelLyDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslKrnNm = this.vslKrnNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslLnchDt = this.vslLnchDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslLoclNm = this.vslLoclNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslOwnIndCd = this.vslOwnIndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslRgstCntCd = this.vslRgstCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslRmk = this.vslRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslSvcSpd = this.vslSvcSpd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslWdt = this.vslWdt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cudFlg = this.cudFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eaiEvntDt = this.eaiEvntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eaiIfId = this.eaiIfId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
