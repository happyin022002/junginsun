/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : YardVO.java
*@FileTitle : YardVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.02  
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
 
/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class YardVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<YardVO> models = new ArrayList<YardVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    private String pagerows = null;

    /* Column Info */
    private String ydCgoClzHrmntMsg = null;

    private String ydTrctKnt = null;

    private String ydActSpc = null;

    private String ydRfRcpt220vKnt = null;

    private String holGateClzHrmnt = null;

    private String ydBrthDpthChnlKnt = null;

    private String ydFctyTpBrgRmpFlg = null;

    private String holGateOpnHrmnt = null;

    private String ydCoSpc = null;

    private String ydCoVolBxKnt = null;

    private String ydRmk = null;

    private String demObCltFlg = null;

    private String ydTtlVolBxKnt = null;

    private String brthNo = null;

    private String ydCoVolTeuKnt = null;

    private String repZnCd = null;

    private String ydFctyTpCyFlg = null;

    private String phnNo = null;

    private String trstrKnt = null;

    private String n2ndVndrSeq = null;

    private String sunGateOpnHrmnt = null;

    private String ydCeoNm = null;

    private String tmlProdKnt = null;

    private String ydPicNm = null;

    private String ydHndlYr = null;

    private String ydCfsSpc = null;

    private String ydChrCd = null;

    private String zipCd = null;

    private String ydNm = null;

    private String faxNo = null;

    private String ydOshpCd = null;

    private String sunGateClzHrmnt = null;

    private String hubYdFlg = null;

    private String deltFlg = null;

    private String ydStrdlCrrKnt = null;

    private String ydRfRcptDulKnt = null;

    private String ydFctyTpPsdoYdFlg = null;

    private String ydTopLftKnt = null;

    private String ydPstPgcKnt = null;

    private String ydFctyTpCfsFlg = null;

    private String ydInrlFlg = null;

    private String ydPgcKnt = null;

    private String ydTtlVolTeuKnt = null;

    private String usrId = null;

    private String n1stVndrSeq = null;

    private String gateClzHrmnt = null;

    private String demIbCltFlg = null;

    private String satGateOpnHrmnt = null;

    private String n3rdVndrSeq = null;

    private String ydCstmsNo = null;

    private String ydTtlSpc = null;

    private String dmdtOfcCd = null;

    private String ydBrthAlngSdDesc = null;

    private String gateOpnHrmnt = null;

    private String ydFctyTpRailRmpFlg = null;

    private String ydFctyTpMrnTmlFlg = null;

    private String ydHndlCapa = null;

    private String ydRfRcpt440vKnt = null;

    private String mnrShopFlg = null;

    private String eirSvcFlg = null;

    private String tmlChssKnt = null;

    private String ofcCd = null;

    private String satGateClzHrmnt = null;

    private String ydCd = null;

    private String frkKnt = null;

    private String ydBrthLen = null;

    private String ydAddr = null;

    private String ydOpSysCd = null;

    private String bdYdFlg = null;

    private String ydEml = null;

    private String intlPhnNo = null;

    private String n1stVndrNm = null;

    private String n2ndVndrNm = null;

    private String n3rdVndrNm = null;

    private String ydLoclLangNm = null;

    private String ydLoclLangAddr = null;

    private String bkgPodYdFlg = null;

    private String eqSccCd = null;

    private String rqstNo = null;

    private String modiYdCd = null;

    private String rfMinDwllHrs = null;

    private String dryMinDwllHrs = null;

    private String rfAvgDwllHrs = null;

    private String dryAvgDwllHrs = null;

    private String railArrNtfcFlg = null;

    private String creUsrId = null;

    private String creDt = null;

    private String updUsrId = null;

    private String updDt = null;

    private String ediIfFlg = null;

    private String ydLat = null;

    private String ydLon = null;

    /* Column Info */
    private String cudFlg = null;

    /* Column Info */
    private String ydHjsSpc = null;

    /* Column Info */
    private String ydHjsVolTeuKnt = null;

    /* Column Info */
    private String ydHjsVolBxKnt = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public YardVO() {
    }

    public YardVO(String ibflag, String pagerows, String ydCd, String ydNm, String ydChrCd, String ydFctyTpCyFlg, String ydFctyTpRailRmpFlg, String ydFctyTpMrnTmlFlg, String ydFctyTpCfsFlg, String ydFctyTpBrgRmpFlg, String ydFctyTpPsdoYdFlg, String n1stVndrSeq, String n2ndVndrSeq, String n3rdVndrSeq, String ofcCd, String dmdtOfcCd, String demIbCltFlg, String demObCltFlg, String repZnCd, String ydOshpCd, String bdYdFlg, String mnrShopFlg, String eirSvcFlg, String hubYdFlg, String ydAddr, String ydCstmsNo, String ydCeoNm, String ydPicNm, String ydEml, String zipCd, String intlPhnNo, String phnNo, String faxNo, String gateOpnHrmnt, String gateClzHrmnt, String satGateOpnHrmnt, String satGateClzHrmnt, String sunGateOpnHrmnt, String sunGateClzHrmnt, String holGateOpnHrmnt, String holGateClzHrmnt, String ydInrlFlg, String ydCgoClzHrmntMsg, String brthNo, String ydBrthLen, String ydBrthAlngSdDesc, String ydBrthDpthChnlKnt, String ydTtlSpc, String ydActSpc, String ydCoSpc, String ydCfsSpc, String ydRfRcpt440vKnt, String ydRfRcpt220vKnt, String ydRfRcptDulKnt, String ydOpSysCd, String ydPstPgcKnt, String ydPgcKnt, String trstrKnt, String frkKnt, String ydStrdlCrrKnt, String ydTrctKnt, String ydTopLftKnt, String tmlChssKnt, String ydHndlYr, String ydHndlCapa, String tmlProdKnt, String ydTtlVolTeuKnt, String ydTtlVolBxKnt, String ydCoVolTeuKnt, String ydCoVolBxKnt, String ydRmk, String deltFlg, String usrId, String n1stVndrNm, String n2ndVndrNm, String n3rdVndrNm, String ydLoclLangNm, String ydLoclLangAddr, String bkgPodYdFlg, String eqSccCd, String rqstNo, String modiYdCd, String dryAvgDwllHrs, String dryMinDwllHrs, String rfAvgDwllHrs, String rfMinDwllHrs, String railArrNtfcFlg, String creUsrId, String creDt, String updUsrId, String updDt, String ediIfFlg, String ydLat, String ydLon, String cudFlg, String ydHjsSpc, String ydHjsVolTeuKnt, String ydHjsVolBxKnt) {
        this.ydCgoClzHrmntMsg = ydCgoClzHrmntMsg;
        this.ydTrctKnt = ydTrctKnt;
        this.ydActSpc = ydActSpc;
        this.ydRfRcpt220vKnt = ydRfRcpt220vKnt;
        this.holGateClzHrmnt = holGateClzHrmnt;
        this.ydBrthDpthChnlKnt = ydBrthDpthChnlKnt;
        this.ydFctyTpBrgRmpFlg = ydFctyTpBrgRmpFlg;
        this.holGateOpnHrmnt = holGateOpnHrmnt;
        this.ydCoSpc = ydCoSpc;
        this.pagerows = pagerows;
        this.ydCoVolBxKnt = ydCoVolBxKnt;
        this.ydRmk = ydRmk;
        this.demObCltFlg = demObCltFlg;
        this.ydTtlVolBxKnt = ydTtlVolBxKnt;
        this.brthNo = brthNo;
        this.ydCoVolTeuKnt = ydCoVolTeuKnt;
        this.repZnCd = repZnCd;
        this.ydFctyTpCyFlg = ydFctyTpCyFlg;
        this.phnNo = phnNo;
        this.trstrKnt = trstrKnt;
        this.n2ndVndrSeq = n2ndVndrSeq;
        this.sunGateOpnHrmnt = sunGateOpnHrmnt;
        this.ydCeoNm = ydCeoNm;
        this.tmlProdKnt = tmlProdKnt;
        this.ydPicNm = ydPicNm;
        this.ydHndlYr = ydHndlYr;
        this.ydCfsSpc = ydCfsSpc;
        this.ydChrCd = ydChrCd;
        this.zipCd = zipCd;
        this.ydNm = ydNm;
        this.faxNo = faxNo;
        this.ydOshpCd = ydOshpCd;
        this.sunGateClzHrmnt = sunGateClzHrmnt;
        this.hubYdFlg = hubYdFlg;
        this.deltFlg = deltFlg;
        this.ydStrdlCrrKnt = ydStrdlCrrKnt;
        this.ydRfRcptDulKnt = ydRfRcptDulKnt;
        this.ydFctyTpPsdoYdFlg = ydFctyTpPsdoYdFlg;
        this.ydTopLftKnt = ydTopLftKnt;
        this.ydPstPgcKnt = ydPstPgcKnt;
        this.ydFctyTpCfsFlg = ydFctyTpCfsFlg;
        this.ydInrlFlg = ydInrlFlg;
        this.ydPgcKnt = ydPgcKnt;
        this.ibflag = ibflag;
        this.ydTtlVolTeuKnt = ydTtlVolTeuKnt;
        this.usrId = usrId;
        this.n1stVndrSeq = n1stVndrSeq;
        this.gateClzHrmnt = gateClzHrmnt;
        this.demIbCltFlg = demIbCltFlg;
        this.satGateOpnHrmnt = satGateOpnHrmnt;
        this.n3rdVndrSeq = n3rdVndrSeq;
        this.ydCstmsNo = ydCstmsNo;
        this.ydTtlSpc = ydTtlSpc;
        this.dmdtOfcCd = dmdtOfcCd;
        this.ydBrthAlngSdDesc = ydBrthAlngSdDesc;
        this.gateOpnHrmnt = gateOpnHrmnt;
        this.ydFctyTpRailRmpFlg = ydFctyTpRailRmpFlg;
        this.ydFctyTpMrnTmlFlg = ydFctyTpMrnTmlFlg;
        this.ydHndlCapa = ydHndlCapa;
        this.ydRfRcpt440vKnt = ydRfRcpt440vKnt;
        this.mnrShopFlg = mnrShopFlg;
        this.eirSvcFlg = eirSvcFlg;
        this.tmlChssKnt = tmlChssKnt;
        this.ofcCd = ofcCd;
        this.satGateClzHrmnt = satGateClzHrmnt;
        this.ydCd = ydCd;
        this.frkKnt = frkKnt;
        this.ydBrthLen = ydBrthLen;
        this.ydAddr = ydAddr;
        this.ydOpSysCd = ydOpSysCd;
        this.bdYdFlg = bdYdFlg;
        this.ydEml = ydEml;
        this.intlPhnNo = intlPhnNo;
        this.n1stVndrNm = n1stVndrNm;
        this.n2ndVndrNm = n2ndVndrNm;
        this.n3rdVndrNm = n3rdVndrNm;
        this.ydLoclLangNm = ydLoclLangNm;
        this.ydLoclLangAddr = ydLoclLangAddr;
        this.bkgPodYdFlg = bkgPodYdFlg;
        this.eqSccCd = eqSccCd;
        this.rqstNo = rqstNo;
        this.modiYdCd = modiYdCd;
        this.rfMinDwllHrs = rfMinDwllHrs;
        this.dryMinDwllHrs = dryMinDwllHrs;
        this.rfAvgDwllHrs = rfAvgDwllHrs;
        this.dryAvgDwllHrs = dryAvgDwllHrs;
        this.railArrNtfcFlg = railArrNtfcFlg;
        this.creUsrId = creUsrId;
        this.creDt = creDt;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.ediIfFlg = ediIfFlg;
        this.ydLat = ydLat;
        this.ydLon = ydLon;
        this.cudFlg = cudFlg;
        this.ydHjsSpc = ydHjsSpc;
        this.ydHjsVolTeuKnt = ydHjsVolTeuKnt;
        this.ydHjsVolBxKnt = ydHjsVolBxKnt;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("yd_cgo_clz_hrmnt_msg", getYdCgoClzHrmntMsg());
        this.hashColumns.put("yd_trct_knt", getYdTrctKnt());
        this.hashColumns.put("yd_act_spc", getYdActSpc());
        this.hashColumns.put("yd_rf_rcpt_220v_knt", getYdRfRcpt220vKnt());
        this.hashColumns.put("hol_gate_clz_hrmnt", getHolGateClzHrmnt());
        this.hashColumns.put("yd_brth_dpth_chnl_knt", getYdBrthDpthChnlKnt());
        this.hashColumns.put("yd_fcty_tp_brg_rmp_flg", getYdFctyTpBrgRmpFlg());
        this.hashColumns.put("hol_gate_opn_hrmnt", getHolGateOpnHrmnt());
        this.hashColumns.put("yd_co_spc", getYdCoSpc());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("yd_co_vol_bx_knt", getYdCoVolBxKnt());
        this.hashColumns.put("yd_rmk", getYdRmk());
        this.hashColumns.put("dem_ob_clt_flg", getDemObCltFlg());
        this.hashColumns.put("yd_ttl_vol_bx_knt", getYdTtlVolBxKnt());
        this.hashColumns.put("brth_no", getBrthNo());
        this.hashColumns.put("yd_co_vol_teu_knt", getYdCoVolTeuKnt());
        this.hashColumns.put("rep_zn_cd", getRepZnCd());
        this.hashColumns.put("yd_fcty_tp_cy_flg", getYdFctyTpCyFlg());
        this.hashColumns.put("phn_no", getPhnNo());
        this.hashColumns.put("trstr_knt", getTrstrKnt());
        this.hashColumns.put("n2nd_vndr_seq", getN2ndVndrSeq());
        this.hashColumns.put("sun_gate_opn_hrmnt", getSunGateOpnHrmnt());
        this.hashColumns.put("yd_ceo_nm", getYdCeoNm());
        this.hashColumns.put("tml_prod_knt", getTmlProdKnt());
        this.hashColumns.put("yd_pic_nm", getYdPicNm());
        this.hashColumns.put("yd_hndl_yr", getYdHndlYr());
        this.hashColumns.put("yd_cfs_spc", getYdCfsSpc());
        this.hashColumns.put("yd_chr_cd", getYdChrCd());
        this.hashColumns.put("zip_cd", getZipCd());
        this.hashColumns.put("yd_nm", getYdNm());
        this.hashColumns.put("fax_no", getFaxNo());
        this.hashColumns.put("yd_oshp_cd", getYdOshpCd());
        this.hashColumns.put("sun_gate_clz_hrmnt", getSunGateClzHrmnt());
        this.hashColumns.put("hub_yd_flg", getHubYdFlg());
        this.hashColumns.put("delt_flg", getDeltFlg());
        this.hashColumns.put("yd_strdl_crr_knt", getYdStrdlCrrKnt());
        this.hashColumns.put("yd_rf_rcpt_dul_knt", getYdRfRcptDulKnt());
        this.hashColumns.put("yd_fcty_tp_psdo_yd_flg", getYdFctyTpPsdoYdFlg());
        this.hashColumns.put("yd_top_lft_knt", getYdTopLftKnt());
        this.hashColumns.put("yd_pst_pgc_knt", getYdPstPgcKnt());
        this.hashColumns.put("yd_fcty_tp_cfs_flg", getYdFctyTpCfsFlg());
        this.hashColumns.put("yd_inrl_flg", getYdInrlFlg());
        this.hashColumns.put("yd_pgc_knt", getYdPgcKnt());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("yd_ttl_vol_teu_knt", getYdTtlVolTeuKnt());
        this.hashColumns.put("usr_id", getUsrId());
        this.hashColumns.put("n1st_vndr_seq", getN1stVndrSeq());
        this.hashColumns.put("gate_clz_hrmnt", getGateClzHrmnt());
        this.hashColumns.put("dem_ib_clt_flg", getDemIbCltFlg());
        this.hashColumns.put("sat_gate_opn_hrmnt", getSatGateOpnHrmnt());
        this.hashColumns.put("n3rd_vndr_seq", getN3rdVndrSeq());
        this.hashColumns.put("yd_cstms_no", getYdCstmsNo());
        this.hashColumns.put("yd_ttl_spc", getYdTtlSpc());
        this.hashColumns.put("dmdt_ofc_cd", getDmdtOfcCd());
        this.hashColumns.put("yd_brth_alng_sd_desc", getYdBrthAlngSdDesc());
        this.hashColumns.put("gate_opn_hrmnt", getGateOpnHrmnt());
        this.hashColumns.put("yd_fcty_tp_rail_rmp_flg", getYdFctyTpRailRmpFlg());
        this.hashColumns.put("yd_fcty_tp_mrn_tml_flg", getYdFctyTpMrnTmlFlg());
        this.hashColumns.put("yd_hndl_capa", getYdHndlCapa());
        this.hashColumns.put("yd_rf_rcpt_440v_knt", getYdRfRcpt440vKnt());
        this.hashColumns.put("mnr_shop_flg", getMnrShopFlg());
        this.hashColumns.put("eir_svc_flg", getEirSvcFlg());
        this.hashColumns.put("tml_chss_knt", getTmlChssKnt());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("sat_gate_clz_hrmnt", getSatGateClzHrmnt());
        this.hashColumns.put("yd_cd", getYdCd());
        this.hashColumns.put("frk_knt", getFrkKnt());
        this.hashColumns.put("yd_brth_len", getYdBrthLen());
        this.hashColumns.put("yd_addr", getYdAddr());
        this.hashColumns.put("yd_op_sys_cd", getYdOpSysCd());
        this.hashColumns.put("bd_yd_flg", getBdYdFlg());
        this.hashColumns.put("yd_eml", getYdEml());
        this.hashColumns.put("intl_phn_no", getIntlPhnNo());
        this.hashColumns.put("n1st_vndr_nm", getN1stVndrNm());
        this.hashColumns.put("n2nd_vndr_nm", getN2ndVndrNm());
        this.hashColumns.put("n3rd_vndr_nm", getN3rdVndrNm());
        this.hashColumns.put("yd_locl_lang_nm", getYdLoclLangNm());
        this.hashColumns.put("yd_locl_lang_addr", getYdLoclLangAddr());
        this.hashColumns.put("bkg_pod_yd_flg", getBkgPodYdFlg());
        this.hashColumns.put("eq_scc_cd", getEqSccCd());
        this.hashColumns.put("rqst_no", getRqstNo());
        this.hashColumns.put("modi_yd_cd", getModiYdCd());
        this.hashColumns.put("rf_min_dwll_hrs", getRfMinDwllHrs());
        this.hashColumns.put("dry_min_dwll_hrs", getDryMinDwllHrs());
        this.hashColumns.put("rf_avg_dwll_hrs", getRfAvgDwllHrs());
        this.hashColumns.put("dry_avg_dwll_hrs", getDryAvgDwllHrs());
        this.hashColumns.put("rail_arr_ntfc_flg", getRailArrNtfcFlg());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("edi_if_flg", getEdiIfFlg());
        this.hashColumns.put("yd_lat", getYdLat());
        this.hashColumns.put("yd_lon", getYdLon());
        this.hashColumns.put("cud_flg", getCudFlg());
        this.hashColumns.put("yd_hjs_spc", getYdHjsSpc());
        this.hashColumns.put("yd_hjs_vol_teu_knt", getYdHjsVolTeuKnt());
        this.hashColumns.put("yd_hjs_vol_bx_knt", getYdHjsVolBxKnt());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("yd_cgo_clz_hrmnt_msg", "ydCgoClzHrmntMsg");
        this.hashFields.put("yd_trct_knt", "ydTrctKnt");
        this.hashFields.put("yd_act_spc", "ydActSpc");
        this.hashFields.put("yd_rf_rcpt_220v_knt", "ydRfRcpt220vKnt");
        this.hashFields.put("hol_gate_clz_hrmnt", "holGateClzHrmnt");
        this.hashFields.put("yd_brth_dpth_chnl_knt", "ydBrthDpthChnlKnt");
        this.hashFields.put("yd_fcty_tp_brg_rmp_flg", "ydFctyTpBrgRmpFlg");
        this.hashFields.put("hol_gate_opn_hrmnt", "holGateOpnHrmnt");
        this.hashFields.put("yd_co_spc", "ydCoSpc");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("yd_co_vol_bx_knt", "ydCoVolBxKnt");
        this.hashFields.put("yd_rmk", "ydRmk");
        this.hashFields.put("dem_ob_clt_flg", "demObCltFlg");
        this.hashFields.put("yd_ttl_vol_bx_knt", "ydTtlVolBxKnt");
        this.hashFields.put("brth_no", "brthNo");
        this.hashFields.put("yd_co_vol_teu_knt", "ydCoVolTeuKnt");
        this.hashFields.put("rep_zn_cd", "repZnCd");
        this.hashFields.put("yd_fcty_tp_cy_flg", "ydFctyTpCyFlg");
        this.hashFields.put("phn_no", "phnNo");
        this.hashFields.put("trstr_knt", "trstrKnt");
        this.hashFields.put("n2nd_vndr_seq", "n2ndVndrSeq");
        this.hashFields.put("sun_gate_opn_hrmnt", "sunGateOpnHrmnt");
        this.hashFields.put("yd_ceo_nm", "ydCeoNm");
        this.hashFields.put("tml_prod_knt", "tmlProdKnt");
        this.hashFields.put("yd_pic_nm", "ydPicNm");
        this.hashFields.put("yd_hndl_yr", "ydHndlYr");
        this.hashFields.put("yd_cfs_spc", "ydCfsSpc");
        this.hashFields.put("yd_chr_cd", "ydChrCd");
        this.hashFields.put("zip_cd", "zipCd");
        this.hashFields.put("yd_nm", "ydNm");
        this.hashFields.put("fax_no", "faxNo");
        this.hashFields.put("yd_oshp_cd", "ydOshpCd");
        this.hashFields.put("sun_gate_clz_hrmnt", "sunGateClzHrmnt");
        this.hashFields.put("hub_yd_flg", "hubYdFlg");
        this.hashFields.put("delt_flg", "deltFlg");
        this.hashFields.put("yd_strdl_crr_knt", "ydStrdlCrrKnt");
        this.hashFields.put("yd_rf_rcpt_dul_knt", "ydRfRcptDulKnt");
        this.hashFields.put("yd_fcty_tp_psdo_yd_flg", "ydFctyTpPsdoYdFlg");
        this.hashFields.put("yd_top_lft_knt", "ydTopLftKnt");
        this.hashFields.put("yd_pst_pgc_knt", "ydPstPgcKnt");
        this.hashFields.put("yd_fcty_tp_cfs_flg", "ydFctyTpCfsFlg");
        this.hashFields.put("yd_inrl_flg", "ydInrlFlg");
        this.hashFields.put("yd_pgc_knt", "ydPgcKnt");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("yd_ttl_vol_teu_knt", "ydTtlVolTeuKnt");
        this.hashFields.put("usr_id", "usrId");
        this.hashFields.put("n1st_vndr_seq", "n1stVndrSeq");
        this.hashFields.put("gate_clz_hrmnt", "gateClzHrmnt");
        this.hashFields.put("dem_ib_clt_flg", "demIbCltFlg");
        this.hashFields.put("sat_gate_opn_hrmnt", "satGateOpnHrmnt");
        this.hashFields.put("n3rd_vndr_seq", "n3rdVndrSeq");
        this.hashFields.put("yd_cstms_no", "ydCstmsNo");
        this.hashFields.put("yd_ttl_spc", "ydTtlSpc");
        this.hashFields.put("dmdt_ofc_cd", "dmdtOfcCd");
        this.hashFields.put("yd_brth_alng_sd_desc", "ydBrthAlngSdDesc");
        this.hashFields.put("gate_opn_hrmnt", "gateOpnHrmnt");
        this.hashFields.put("yd_fcty_tp_rail_rmp_flg", "ydFctyTpRailRmpFlg");
        this.hashFields.put("yd_fcty_tp_mrn_tml_flg", "ydFctyTpMrnTmlFlg");
        this.hashFields.put("yd_hndl_capa", "ydHndlCapa");
        this.hashFields.put("yd_rf_rcpt_440v_knt", "ydRfRcpt440vKnt");
        this.hashFields.put("mnr_shop_flg", "mnrShopFlg");
        this.hashFields.put("eir_svc_flg", "eirSvcFlg");
        this.hashFields.put("tml_chss_knt", "tmlChssKnt");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("sat_gate_clz_hrmnt", "satGateClzHrmnt");
        this.hashFields.put("yd_cd", "ydCd");
        this.hashFields.put("frk_knt", "frkKnt");
        this.hashFields.put("yd_brth_len", "ydBrthLen");
        this.hashFields.put("yd_addr", "ydAddr");
        this.hashFields.put("yd_op_sys_cd", "ydOpSysCd");
        this.hashFields.put("bd_yd_flg", "bdYdFlg");
        this.hashFields.put("yd_eml", "ydEml");
        this.hashFields.put("intl_phn_no", "intlPhnNo");
        this.hashFields.put("n1st_vndr_nm", "n1stVndrNm");
        this.hashFields.put("n2nd_vndr_nm", "n2ndVndrNm");
        this.hashFields.put("n3rd_vndr_nm", "n3rdVndrNm");
        this.hashFields.put("yd_locl_lang_nm", "ydLoclLangNm");
        this.hashFields.put("yd_locl_lang_addr", "ydLoclLangAddr");
        this.hashFields.put("bkg_pod_yd_flg", "bkgPodYdFlg");
        this.hashFields.put("eq_scc_cd", "eqSccCd");
        this.hashFields.put("rqst_no", "rqstNo");
        this.hashFields.put("modi_yd_cd", "modiYdCd");
        this.hashFields.put("rf_min_dwll_hrs", "rfMinDwllHrs");
        this.hashFields.put("dry_min_dwll_hrs", "dryMinDwllHrs");
        this.hashFields.put("rf_avg_dwll_hrs", "rfAvgDwllHrs");
        this.hashFields.put("dry_avg_dwll_hrs", "dryAvgDwllHrs");
        this.hashFields.put("rail_arr_ntfc_flg", "railArrNtfcFlg");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("edi_if_flg", "ediIfFlg");
        this.hashFields.put("yd_lat", "ydLat");
        this.hashFields.put("yd_lon", "ydLon");
        this.hashFields.put("cud_flg", "cudFlg");
        this.hashFields.put("yd_hjs_spc", "ydHjsSpc");
        this.hashFields.put("yd_hjs_vol_teu_knt", "ydHjsVolTeuKnt");
        this.hashFields.put("yd_hjs_vol_bx_knt", "ydHjsVolBxKnt");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return ydCgoClzHrmntMsg
	 */
    public String getYdCgoClzHrmntMsg() {
        return this.ydCgoClzHrmntMsg;
    }

    /**
	 * Column Info
	 * @return ydTrctKnt
	 */
    public String getYdTrctKnt() {
        return this.ydTrctKnt;
    }

    /**
	 * Column Info
	 * @return ydActSpc
	 */
    public String getYdActSpc() {
        return this.ydActSpc;
    }

    /**
	 * Column Info
	 * @return ydRfRcpt220vKnt
	 */
    public String getYdRfRcpt220vKnt() {
        return this.ydRfRcpt220vKnt;
    }

    /**
	 * Column Info
	 * @return holGateClzHrmnt
	 */
    public String getHolGateClzHrmnt() {
        return this.holGateClzHrmnt;
    }

    /**
	 * Column Info
	 * @return ydBrthDpthChnlKnt
	 */
    public String getYdBrthDpthChnlKnt() {
        return this.ydBrthDpthChnlKnt;
    }

    /**
	 * Column Info
	 * @return ydFctyTpBrgRmpFlg
	 */
    public String getYdFctyTpBrgRmpFlg() {
        return this.ydFctyTpBrgRmpFlg;
    }

    /**
	 * Column Info
	 * @return holGateOpnHrmnt
	 */
    public String getHolGateOpnHrmnt() {
        return this.holGateOpnHrmnt;
    }

    /**
	 * Column Info
	 * @return ydCoSpc
	 */
    public String getYdCoSpc() {
        return this.ydCoSpc;
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
	 * @return ydCoVolBxKnt
	 */
    public String getYdCoVolBxKnt() {
        return this.ydCoVolBxKnt;
    }

    /**
	 * Column Info
	 * @return ydRmk
	 */
    public String getYdRmk() {
        return this.ydRmk;
    }

    /**
	 * Column Info
	 * @return demObCltFlg
	 */
    public String getDemObCltFlg() {
        return this.demObCltFlg;
    }

    /**
	 * Column Info
	 * @return ydTtlVolBxKnt
	 */
    public String getYdTtlVolBxKnt() {
        return this.ydTtlVolBxKnt;
    }

    /**
	 * Column Info
	 * @return brthNo
	 */
    public String getBrthNo() {
        return this.brthNo;
    }

    /**
	 * Column Info
	 * @return ydCoVolTeuKnt
	 */
    public String getYdCoVolTeuKnt() {
        return this.ydCoVolTeuKnt;
    }

    /**
	 * Column Info
	 * @return repZnCd
	 */
    public String getRepZnCd() {
        return this.repZnCd;
    }

    /**
	 * Column Info
	 * @return ydFctyTpCyFlg
	 */
    public String getYdFctyTpCyFlg() {
        return this.ydFctyTpCyFlg;
    }

    /**
	 * Column Info
	 * @return phnNo
	 */
    public String getPhnNo() {
        return this.phnNo;
    }

    /**
	 * Column Info
	 * @return trstrKnt
	 */
    public String getTrstrKnt() {
        return this.trstrKnt;
    }

    /**
	 * Column Info
	 * @return n2ndVndrSeq
	 */
    public String getN2ndVndrSeq() {
        return this.n2ndVndrSeq;
    }

    /**
	 * Column Info
	 * @return sunGateOpnHrmnt
	 */
    public String getSunGateOpnHrmnt() {
        return this.sunGateOpnHrmnt;
    }

    /**
	 * Column Info
	 * @return ydCeoNm
	 */
    public String getYdCeoNm() {
        return this.ydCeoNm;
    }

    /**
	 * Column Info
	 * @return tmlProdKnt
	 */
    public String getTmlProdKnt() {
        return this.tmlProdKnt;
    }

    /**
	 * Column Info
	 * @return ydPicNm
	 */
    public String getYdPicNm() {
        return this.ydPicNm;
    }

    /**
	 * Column Info
	 * @return ydHndlYr
	 */
    public String getYdHndlYr() {
        return this.ydHndlYr;
    }

    /**
	 * Column Info
	 * @return ydCfsSpc
	 */
    public String getYdCfsSpc() {
        return this.ydCfsSpc;
    }

    /**
	 * Column Info
	 * @return ydChrCd
	 */
    public String getYdChrCd() {
        return this.ydChrCd;
    }

    /**
	 * Column Info
	 * @return zipCd
	 */
    public String getZipCd() {
        return this.zipCd;
    }

    /**
	 * Column Info
	 * @return ydNm
	 */
    public String getYdNm() {
        return this.ydNm;
    }

    /**
	 * Column Info
	 * @return faxNo
	 */
    public String getFaxNo() {
        return this.faxNo;
    }

    /**
	 * Column Info
	 * @return ydOshpCd
	 */
    public String getYdOshpCd() {
        return this.ydOshpCd;
    }

    /**
	 * Column Info
	 * @return sunGateClzHrmnt
	 */
    public String getSunGateClzHrmnt() {
        return this.sunGateClzHrmnt;
    }

    /**
	 * Column Info
	 * @return hubYdFlg
	 */
    public String getHubYdFlg() {
        return this.hubYdFlg;
    }

    /**
	 * Column Info
	 * @return deltFlg
	 */
    public String getDeltFlg() {
        return this.deltFlg;
    }

    /**
	 * Column Info
	 * @return ydStrdlCrrKnt
	 */
    public String getYdStrdlCrrKnt() {
        return this.ydStrdlCrrKnt;
    }

    /**
	 * Column Info
	 * @return ydRfRcptDulKnt
	 */
    public String getYdRfRcptDulKnt() {
        return this.ydRfRcptDulKnt;
    }

    /**
	 * Column Info
	 * @return ydFctyTpPsdoYdFlg
	 */
    public String getYdFctyTpPsdoYdFlg() {
        return this.ydFctyTpPsdoYdFlg;
    }

    /**
	 * Column Info
	 * @return ydTopLftKnt
	 */
    public String getYdTopLftKnt() {
        return this.ydTopLftKnt;
    }

    /**
	 * Column Info
	 * @return ydPstPgcKnt
	 */
    public String getYdPstPgcKnt() {
        return this.ydPstPgcKnt;
    }

    /**
	 * Column Info
	 * @return ydFctyTpCfsFlg
	 */
    public String getYdFctyTpCfsFlg() {
        return this.ydFctyTpCfsFlg;
    }

    /**
	 * Column Info
	 * @return ydInrlFlg
	 */
    public String getYdInrlFlg() {
        return this.ydInrlFlg;
    }

    /**
	 * Column Info
	 * @return ydPgcKnt
	 */
    public String getYdPgcKnt() {
        return this.ydPgcKnt;
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
	 * @return ydTtlVolTeuKnt
	 */
    public String getYdTtlVolTeuKnt() {
        return this.ydTtlVolTeuKnt;
    }

    /**
	 * Column Info
	 * @return usrId
	 */
    public String getUsrId() {
        return this.usrId;
    }

    /**
	 * Column Info
	 * @return n1stVndrSeq
	 */
    public String getN1stVndrSeq() {
        return this.n1stVndrSeq;
    }

    /**
	 * Column Info
	 * @return gateClzHrmnt
	 */
    public String getGateClzHrmnt() {
        return this.gateClzHrmnt;
    }

    /**
	 * Column Info
	 * @return demIbCltFlg
	 */
    public String getDemIbCltFlg() {
        return this.demIbCltFlg;
    }

    /**
	 * Column Info
	 * @return satGateOpnHrmnt
	 */
    public String getSatGateOpnHrmnt() {
        return this.satGateOpnHrmnt;
    }

    /**
	 * Column Info
	 * @return n3rdVndrSeq
	 */
    public String getN3rdVndrSeq() {
        return this.n3rdVndrSeq;
    }

    /**
	 * Column Info
	 * @return ydCstmsNo
	 */
    public String getYdCstmsNo() {
        return this.ydCstmsNo;
    }

    /**
	 * Column Info
	 * @return ydTtlSpc
	 */
    public String getYdTtlSpc() {
        return this.ydTtlSpc;
    }

    /**
	 * Column Info
	 * @return dmdtOfcCd
	 */
    public String getDmdtOfcCd() {
        return this.dmdtOfcCd;
    }

    /**
	 * Column Info
	 * @return ydBrthAlngSdDesc
	 */
    public String getYdBrthAlngSdDesc() {
        return this.ydBrthAlngSdDesc;
    }

    /**
	 * Column Info
	 * @return gateOpnHrmnt
	 */
    public String getGateOpnHrmnt() {
        return this.gateOpnHrmnt;
    }

    /**
	 * Column Info
	 * @return ydFctyTpRailRmpFlg
	 */
    public String getYdFctyTpRailRmpFlg() {
        return this.ydFctyTpRailRmpFlg;
    }

    /**
	 * Column Info
	 * @return ydFctyTpMrnTmlFlg
	 */
    public String getYdFctyTpMrnTmlFlg() {
        return this.ydFctyTpMrnTmlFlg;
    }

    /**
	 * Column Info
	 * @return ydHndlCapa
	 */
    public String getYdHndlCapa() {
        return this.ydHndlCapa;
    }

    /**
	 * Column Info
	 * @return ydRfRcpt440vKnt
	 */
    public String getYdRfRcpt440vKnt() {
        return this.ydRfRcpt440vKnt;
    }

    /**
	 * Column Info
	 * @return mnrShopFlg
	 */
    public String getMnrShopFlg() {
        return this.mnrShopFlg;
    }

    /**
	 * Column Info
	 * @return eirSvcFlg
	 */
    public String getEirSvcFlg() {
        return this.eirSvcFlg;
    }

    /**
	 * Column Info
	 * @return tmlChssKnt
	 */
    public String getTmlChssKnt() {
        return this.tmlChssKnt;
    }

    /**
	 * Column Info
	 * @return ofcCd
	 */
    public String getOfcCd() {
        return this.ofcCd;
    }

    /**
	 * Column Info
	 * @return satGateClzHrmnt
	 */
    public String getSatGateClzHrmnt() {
        return this.satGateClzHrmnt;
    }

    /**
	 * Column Info
	 * @return ydCd
	 */
    public String getYdCd() {
        return this.ydCd;
    }

    /**
	 * Column Info
	 * @return frkKnt
	 */
    public String getFrkKnt() {
        return this.frkKnt;
    }

    /**
	 * Column Info
	 * @return ydBrthLen
	 */
    public String getYdBrthLen() {
        return this.ydBrthLen;
    }

    /**
	 * Column Info
	 * @return ydAddr
	 */
    public String getYdAddr() {
        return this.ydAddr;
    }

    /**
	 * Column Info
	 * @return ydOpSysCd
	 */
    public String getYdOpSysCd() {
        return this.ydOpSysCd;
    }

    /**
	 * Column Info
	 * @return bdYdFlg
	 */
    public String getBdYdFlg() {
        return this.bdYdFlg;
    }

    /**
	 * Column Info
	 * @return ydEml
	 */
    public String getYdEml() {
        return this.ydEml;
    }

    /**
	 * Column Info
	 * @return intlPhnNo
	 */
    public String getIntlPhnNo() {
        return this.intlPhnNo;
    }

    /**
	 * Column Info
	 * @return n1stVndrNm
	 */
    public String getN1stVndrNm() {
        return this.n1stVndrNm;
    }

    /**
	 * Column Info
	 * @return n2ndVndrNm
	 */
    public String getN2ndVndrNm() {
        return this.n2ndVndrNm;
    }

    /**
	 * Column Info
	 * @return n3rdVndrNm
	 */
    public String getN3rdVndrNm() {
        return this.n3rdVndrNm;
    }

    /**
	 * Column Info
	 * @return ydLoclLangNm
	 */
    public String getYdLoclLangNm() {
        return this.ydLoclLangNm;
    }

    /**
	 * Column Info
	 * @return ydLoclLangAddr
	 */
    public String getYdLoclLangAddr() {
        return this.ydLoclLangAddr;
    }

    /**
	 * Column Info
	 * @return bkgPodYdFlg
	 */
    public String getBkgPodYdFlg() {
        return this.bkgPodYdFlg;
    }

    /**
	 * Column Info
	 * @return eqSccCd
	 */
    public String getEqSccCd() {
        return this.eqSccCd;
    }

    /**
	 * Column Info
	 * @return rqstNo
	 */
    public String getRqstNo() {
        return this.rqstNo;
    }

    /**
	 * Column Info
	 * @return modiYdCd
	 */
    public String getModiYdCd() {
        return this.modiYdCd;
    }

    /**
	 * Column Info
	 * @param ydCgoClzHrmntMsg
	 */
    public void setYdCgoClzHrmntMsg(String ydCgoClzHrmntMsg) {
        this.ydCgoClzHrmntMsg = ydCgoClzHrmntMsg;
    }

    /**
	 * Column Info
	 * @param ydTrctKnt
	 */
    public void setYdTrctKnt(String ydTrctKnt) {
        this.ydTrctKnt = ydTrctKnt;
    }

    /**
	 * Column Info
	 * @param ydActSpc
	 */
    public void setYdActSpc(String ydActSpc) {
        this.ydActSpc = ydActSpc;
    }

    /**
	 * Column Info
	 * @param ydRfRcpt220vKnt
	 */
    public void setYdRfRcpt220vKnt(String ydRfRcpt220vKnt) {
        this.ydRfRcpt220vKnt = ydRfRcpt220vKnt;
    }

    /**
	 * Column Info
	 * @param holGateClzHrmnt
	 */
    public void setHolGateClzHrmnt(String holGateClzHrmnt) {
        this.holGateClzHrmnt = holGateClzHrmnt;
    }

    /**
	 * Column Info
	 * @param ydBrthDpthChnlKnt
	 */
    public void setYdBrthDpthChnlKnt(String ydBrthDpthChnlKnt) {
        this.ydBrthDpthChnlKnt = ydBrthDpthChnlKnt;
    }

    /**
	 * Column Info
	 * @param ydFctyTpBrgRmpFlg
	 */
    public void setYdFctyTpBrgRmpFlg(String ydFctyTpBrgRmpFlg) {
        this.ydFctyTpBrgRmpFlg = ydFctyTpBrgRmpFlg;
    }

    /**
	 * Column Info
	 * @param holGateOpnHrmnt
	 */
    public void setHolGateOpnHrmnt(String holGateOpnHrmnt) {
        this.holGateOpnHrmnt = holGateOpnHrmnt;
    }

    /**
	 * Column Info
	 * @param ydCoSpc
	 */
    public void setYdCoSpc(String ydCoSpc) {
        this.ydCoSpc = ydCoSpc;
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
	 * @param ydCoVolBxKnt
	 */
    public void setYdCoVolBxKnt(String ydCoVolBxKnt) {
        this.ydCoVolBxKnt = ydCoVolBxKnt;
    }

    /**
	 * Column Info
	 * @param ydRmk
	 */
    public void setYdRmk(String ydRmk) {
        this.ydRmk = ydRmk;
    }

    /**
	 * Column Info
	 * @param demObCltFlg
	 */
    public void setDemObCltFlg(String demObCltFlg) {
        this.demObCltFlg = demObCltFlg;
    }

    /**
	 * Column Info
	 * @param ydTtlVolBxKnt
	 */
    public void setYdTtlVolBxKnt(String ydTtlVolBxKnt) {
        this.ydTtlVolBxKnt = ydTtlVolBxKnt;
    }

    /**
	 * Column Info
	 * @param brthNo
	 */
    public void setBrthNo(String brthNo) {
        this.brthNo = brthNo;
    }

    /**
	 * Column Info
	 * @param ydCoVolTeuKnt
	 */
    public void setYdCoVolTeuKnt(String ydCoVolTeuKnt) {
        this.ydCoVolTeuKnt = ydCoVolTeuKnt;
    }

    /**
	 * Column Info
	 * @param repZnCd
	 */
    public void setRepZnCd(String repZnCd) {
        this.repZnCd = repZnCd;
    }

    /**
	 * Column Info
	 * @param ydFctyTpCyFlg
	 */
    public void setYdFctyTpCyFlg(String ydFctyTpCyFlg) {
        this.ydFctyTpCyFlg = ydFctyTpCyFlg;
    }

    /**
	 * Column Info
	 * @param phnNo
	 */
    public void setPhnNo(String phnNo) {
        this.phnNo = phnNo;
    }

    /**
	 * Column Info
	 * @param trstrKnt
	 */
    public void setTrstrKnt(String trstrKnt) {
        this.trstrKnt = trstrKnt;
    }

    /**
	 * Column Info
	 * @param n2ndVndrSeq
	 */
    public void setN2ndVndrSeq(String n2ndVndrSeq) {
        this.n2ndVndrSeq = n2ndVndrSeq;
    }

    /**
	 * Column Info
	 * @param sunGateOpnHrmnt
	 */
    public void setSunGateOpnHrmnt(String sunGateOpnHrmnt) {
        this.sunGateOpnHrmnt = sunGateOpnHrmnt;
    }

    /**
	 * Column Info
	 * @param ydCeoNm
	 */
    public void setYdCeoNm(String ydCeoNm) {
        this.ydCeoNm = ydCeoNm;
    }

    /**
	 * Column Info
	 * @param tmlProdKnt
	 */
    public void setTmlProdKnt(String tmlProdKnt) {
        this.tmlProdKnt = tmlProdKnt;
    }

    /**
	 * Column Info
	 * @param ydPicNm
	 */
    public void setYdPicNm(String ydPicNm) {
        this.ydPicNm = ydPicNm;
    }

    /**
	 * Column Info
	 * @param ydHndlYr
	 */
    public void setYdHndlYr(String ydHndlYr) {
        this.ydHndlYr = ydHndlYr;
    }

    /**
	 * Column Info
	 * @param ydCfsSpc
	 */
    public void setYdCfsSpc(String ydCfsSpc) {
        this.ydCfsSpc = ydCfsSpc;
    }

    /**
	 * Column Info
	 * @param ydChrCd
	 */
    public void setYdChrCd(String ydChrCd) {
        this.ydChrCd = ydChrCd;
    }

    /**
	 * Column Info
	 * @param zipCd
	 */
    public void setZipCd(String zipCd) {
        this.zipCd = zipCd;
    }

    /**
	 * Column Info
	 * @param ydNm
	 */
    public void setYdNm(String ydNm) {
        this.ydNm = ydNm;
    }

    /**
	 * Column Info
	 * @param faxNo
	 */
    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }

    /**
	 * Column Info
	 * @param ydOshpCd
	 */
    public void setYdOshpCd(String ydOshpCd) {
        this.ydOshpCd = ydOshpCd;
    }

    /**
	 * Column Info
	 * @param sunGateClzHrmnt
	 */
    public void setSunGateClzHrmnt(String sunGateClzHrmnt) {
        this.sunGateClzHrmnt = sunGateClzHrmnt;
    }

    /**
	 * Column Info
	 * @param hubYdFlg
	 */
    public void setHubYdFlg(String hubYdFlg) {
        this.hubYdFlg = hubYdFlg;
    }

    /**
	 * Column Info
	 * @param deltFlg
	 */
    public void setDeltFlg(String deltFlg) {
        this.deltFlg = deltFlg;
    }

    /**
	 * Column Info
	 * @param ydStrdlCrrKnt
	 */
    public void setYdStrdlCrrKnt(String ydStrdlCrrKnt) {
        this.ydStrdlCrrKnt = ydStrdlCrrKnt;
    }

    /**
	 * Column Info
	 * @param ydRfRcptDulKnt
	 */
    public void setYdRfRcptDulKnt(String ydRfRcptDulKnt) {
        this.ydRfRcptDulKnt = ydRfRcptDulKnt;
    }

    /**
	 * Column Info
	 * @param ydFctyTpPsdoYdFlg
	 */
    public void setYdFctyTpPsdoYdFlg(String ydFctyTpPsdoYdFlg) {
        this.ydFctyTpPsdoYdFlg = ydFctyTpPsdoYdFlg;
    }

    /**
	 * Column Info
	 * @param ydTopLftKnt
	 */
    public void setYdTopLftKnt(String ydTopLftKnt) {
        this.ydTopLftKnt = ydTopLftKnt;
    }

    /**
	 * Column Info
	 * @param ydPstPgcKnt
	 */
    public void setYdPstPgcKnt(String ydPstPgcKnt) {
        this.ydPstPgcKnt = ydPstPgcKnt;
    }

    /**
	 * Column Info
	 * @param ydFctyTpCfsFlg
	 */
    public void setYdFctyTpCfsFlg(String ydFctyTpCfsFlg) {
        this.ydFctyTpCfsFlg = ydFctyTpCfsFlg;
    }

    /**
	 * Column Info
	 * @param ydInrlFlg
	 */
    public void setYdInrlFlg(String ydInrlFlg) {
        this.ydInrlFlg = ydInrlFlg;
    }

    /**
	 * Column Info
	 * @param ydPgcKnt
	 */
    public void setYdPgcKnt(String ydPgcKnt) {
        this.ydPgcKnt = ydPgcKnt;
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
	 * @param ydTtlVolTeuKnt
	 */
    public void setYdTtlVolTeuKnt(String ydTtlVolTeuKnt) {
        this.ydTtlVolTeuKnt = ydTtlVolTeuKnt;
    }

    /**
	 * Column Info
	 * @param usrId
	 */
    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    /**
	 * Column Info
	 * @param n1stVndrSeq
	 */
    public void setN1stVndrSeq(String n1stVndrSeq) {
        this.n1stVndrSeq = n1stVndrSeq;
    }

    /**
	 * Column Info
	 * @param gateClzHrmnt
	 */
    public void setGateClzHrmnt(String gateClzHrmnt) {
        this.gateClzHrmnt = gateClzHrmnt;
    }

    /**
	 * Column Info
	 * @param demIbCltFlg
	 */
    public void setDemIbCltFlg(String demIbCltFlg) {
        this.demIbCltFlg = demIbCltFlg;
    }

    /**
	 * Column Info
	 * @param satGateOpnHrmnt
	 */
    public void setSatGateOpnHrmnt(String satGateOpnHrmnt) {
        this.satGateOpnHrmnt = satGateOpnHrmnt;
    }

    /**
	 * Column Info
	 * @param n3rdVndrSeq
	 */
    public void setN3rdVndrSeq(String n3rdVndrSeq) {
        this.n3rdVndrSeq = n3rdVndrSeq;
    }

    /**
	 * Column Info
	 * @param ydCstmsNo
	 */
    public void setYdCstmsNo(String ydCstmsNo) {
        this.ydCstmsNo = ydCstmsNo;
    }

    /**
	 * Column Info
	 * @param ydTtlSpc
	 */
    public void setYdTtlSpc(String ydTtlSpc) {
        this.ydTtlSpc = ydTtlSpc;
    }

    /**
	 * Column Info
	 * @param dmdtOfcCd
	 */
    public void setDmdtOfcCd(String dmdtOfcCd) {
        this.dmdtOfcCd = dmdtOfcCd;
    }

    /**
	 * Column Info
	 * @param ydBrthAlngSdDesc
	 */
    public void setYdBrthAlngSdDesc(String ydBrthAlngSdDesc) {
        this.ydBrthAlngSdDesc = ydBrthAlngSdDesc;
    }

    /**
	 * Column Info
	 * @param gateOpnHrmnt
	 */
    public void setGateOpnHrmnt(String gateOpnHrmnt) {
        this.gateOpnHrmnt = gateOpnHrmnt;
    }

    /**
	 * Column Info
	 * @param ydFctyTpRailRmpFlg
	 */
    public void setYdFctyTpRailRmpFlg(String ydFctyTpRailRmpFlg) {
        this.ydFctyTpRailRmpFlg = ydFctyTpRailRmpFlg;
    }

    /**
	 * Column Info
	 * @param ydFctyTpMrnTmlFlg
	 */
    public void setYdFctyTpMrnTmlFlg(String ydFctyTpMrnTmlFlg) {
        this.ydFctyTpMrnTmlFlg = ydFctyTpMrnTmlFlg;
    }

    /**
	 * Column Info
	 * @param ydHndlCapa
	 */
    public void setYdHndlCapa(String ydHndlCapa) {
        this.ydHndlCapa = ydHndlCapa;
    }

    /**
	 * Column Info
	 * @param ydRfRcpt440vKnt
	 */
    public void setYdRfRcpt440vKnt(String ydRfRcpt440vKnt) {
        this.ydRfRcpt440vKnt = ydRfRcpt440vKnt;
    }

    /**
	 * Column Info
	 * @param mnrShopFlg
	 */
    public void setMnrShopFlg(String mnrShopFlg) {
        this.mnrShopFlg = mnrShopFlg;
    }

    /**
	 * Column Info
	 * @param eirSvcFlg
	 */
    public void setEirSvcFlg(String eirSvcFlg) {
        this.eirSvcFlg = eirSvcFlg;
    }

    /**
	 * Column Info
	 * @param tmlChssKnt
	 */
    public void setTmlChssKnt(String tmlChssKnt) {
        this.tmlChssKnt = tmlChssKnt;
    }

    /**
	 * Column Info
	 * @param ofcCd
	 */
    public void setOfcCd(String ofcCd) {
        this.ofcCd = ofcCd;
    }

    /**
	 * Column Info
	 * @param satGateClzHrmnt
	 */
    public void setSatGateClzHrmnt(String satGateClzHrmnt) {
        this.satGateClzHrmnt = satGateClzHrmnt;
    }

    /**
	 * Column Info
	 * @param ydCd
	 */
    public void setYdCd(String ydCd) {
        this.ydCd = ydCd;
    }

    /**
	 * Column Info
	 * @param frkKnt
	 */
    public void setFrkKnt(String frkKnt) {
        this.frkKnt = frkKnt;
    }

    /**
	 * Column Info
	 * @param ydBrthLen
	 */
    public void setYdBrthLen(String ydBrthLen) {
        this.ydBrthLen = ydBrthLen;
    }

    /**
	 * Column Info
	 * @param ydAddr
	 */
    public void setYdAddr(String ydAddr) {
        this.ydAddr = ydAddr;
    }

    /**
	 * Column Info
	 * @param ydOpSysCd
	 */
    public void setYdOpSysCd(String ydOpSysCd) {
        this.ydOpSysCd = ydOpSysCd;
    }

    /**
	 * Column Info
	 * @param bdYdFlg
	 */
    public void setBdYdFlg(String bdYdFlg) {
        this.bdYdFlg = bdYdFlg;
    }

    /**
	 * Column Info
	 * @param ydEml
	 */
    public void setYdEml(String ydEml) {
        this.ydEml = ydEml;
    }

    /**
	 * Column Info
	 * @param intlPhnNo
	 */
    public void setIntlPhnNo(String intlPhnNo) {
        this.intlPhnNo = intlPhnNo;
    }

    /**
	 * Column Info
	 * @param n1stVndrNm
	 */
    public void setN1stVndrNm(String n1stVndrNm) {
        this.n1stVndrNm = n1stVndrNm;
    }

    /**
	 * Column Info
	 * @param n2ndVndrNm
	 */
    public void setN2ndVndrNm(String n2ndVndrNm) {
        this.n2ndVndrNm = n2ndVndrNm;
    }

    /**
	 * Column Info
	 * @param n3rdVndrNm
	 */
    public void setN3rdVndrNm(String n3rdVndrNm) {
        this.n3rdVndrNm = n3rdVndrNm;
    }

    /**
	 * Column Info
	 * @param ydLoclLangNm
	 */
    public void setYdLoclLangNm(String ydLoclLangNm) {
        this.ydLoclLangNm = ydLoclLangNm;
    }

    /**
	 * Column Info
	 * @param ydLoclLangAddr
	 */
    public void setYdLoclLangAddr(String ydLoclLangAddr) {
        this.ydLoclLangAddr = ydLoclLangAddr;
    }

    /**
	 * Column Info
	 * @param bkgPodYdFlg
	 */
    public void setBkgPodYdFlg(String bkgPodYdFlg) {
        this.bkgPodYdFlg = bkgPodYdFlg;
    }

    /**
	 * Column Info
	 * @param eqSccCd
	 */
    public void setEqSccCd(String eqSccCd) {
        this.eqSccCd = eqSccCd;
    }

    /**
	 * Column Info
	 * @param rqstNo
	 */
    public void setRqstNo(String rqstNo) {
        this.rqstNo = rqstNo;
    }

    /**
	 * Column Info
	 * @param modiYdCd
	 */
    public void setModiYdCd(String modiYdCd) {
        this.modiYdCd = modiYdCd;
    }

    /**
	 * Column Info
	 * @return rfMinDwllHrs
	 */
    public String getRfMinDwllHrs() {
        return this.rfMinDwllHrs;
    }

    /**
	 * Column Info
	 * @return dryMinDwllHrs
	 */
    public String getDryMinDwllHrs() {
        return this.dryMinDwllHrs;
    }

    /**
	 * Column Info
	 * @return rfAvgDwllHrs
	 */
    public String getRfAvgDwllHrs() {
        return this.rfAvgDwllHrs;
    }

    /**
	 * Column Info
	 * @return dryAvgDwllHrs
	 */
    public String getDryAvgDwllHrs() {
        return this.dryAvgDwllHrs;
    }

    /**
	 * Column Info
	 * @param rfMinDwllHrs
	 */
    public void setRfMinDwllHrs(String rfMinDwllHrs) {
        this.rfMinDwllHrs = rfMinDwllHrs;
    }

    /**
	 * Column Info
	 * @param dryMinDwllHrs
	 */
    public void setDryMinDwllHrs(String dryMinDwllHrs) {
        this.dryMinDwllHrs = dryMinDwllHrs;
    }

    /**
	 * Column Info
	 * @param rfAvgDwllHrs
	 */
    public void setRfAvgDwllHrs(String rfAvgDwllHrs) {
        this.rfAvgDwllHrs = rfAvgDwllHrs;
    }

    /**
	 * Column Info
	 * @param dryAvgDwllHrs
	 */
    public void setDryAvgDwllHrs(String dryAvgDwllHrs) {
        this.dryAvgDwllHrs = dryAvgDwllHrs;
    }

    /**
	 * Column Info
	 * @return railArrNtfcFlg
	 */
    public String getRailArrNtfcFlg() {
        return this.railArrNtfcFlg;
    }

    /**
	 * Column Info
	 * @param railArrNtfcFlg
	 */
    public void setRailArrNtfcFlg(String railArrNtfcFlg) {
        this.railArrNtfcFlg = railArrNtfcFlg;
    }

    public void setCudFlg(String cudFlg) {
        this.cudFlg = cudFlg;
    }

    public String getCudFlg() {
        return this.cudFlg;
    }

    public void setYdHjsSpc(String ydHjsSpc) {
        this.ydHjsSpc = ydHjsSpc;
    }

    public String getYdHjsSpc() {
        return this.ydHjsSpc;
    }

    public String getCreUsrId() {
        return creUsrId;
    }

    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    public String getCreDt() {
        return creDt;
    }

    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    public String getUpdUsrId() {
        return updUsrId;
    }

    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    public String getUpdDt() {
        return updDt;
    }

    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    public String getEdiIfFlg() {
        return ediIfFlg;
    }

    public void setEdiIfFlg(String ediIfFlg) {
        this.ediIfFlg = ediIfFlg;
    }

    public String getYdLat() {
        return ydLat;
    }

    public void setYdLat(String ydLat) {
        this.ydLat = ydLat;
    }

    public String getYdLon() {
        return ydLon;
    }

    public void setYdLon(String ydLon) {
        this.ydLon = ydLon;
    }

    public void setYdHjsVolTeuKnt(String ydHjsVolTeuKnt) {
        this.ydHjsVolTeuKnt = ydHjsVolTeuKnt;
    }

    public String getYdHjsVolTeuKnt() {
        return this.ydHjsVolTeuKnt;
    }

    public void setYdHjsVolBxKnt(String ydHjsVolBxKnt) {
        this.ydHjsVolBxKnt = ydHjsVolBxKnt;
    }

    public String getYdHjsVolBxKnt() {
        return this.ydHjsVolBxKnt;
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
        setYdCgoClzHrmntMsg(JSPUtil.getParameter(request, prefix + "yd_cgo_clz_hrmnt_msg", ""));
        setYdTrctKnt(JSPUtil.getParameter(request, prefix + "yd_trct_knt", ""));
        setYdActSpc(JSPUtil.getParameter(request, prefix + "yd_act_spc", ""));
        setYdRfRcpt220vKnt(JSPUtil.getParameter(request, prefix + "yd_rf_rcpt_220v_knt", ""));
        setHolGateClzHrmnt(JSPUtil.getParameter(request, prefix + "hol_gate_clz_hrmnt", ""));
        setYdBrthDpthChnlKnt(JSPUtil.getParameter(request, prefix + "yd_brth_dpth_chnl_knt", ""));
        setYdFctyTpBrgRmpFlg(JSPUtil.getParameter(request, prefix + "yd_fcty_tp_brg_rmp_flg", ""));
        setHolGateOpnHrmnt(JSPUtil.getParameter(request, prefix + "hol_gate_opn_hrmnt", ""));
        setYdCoSpc(JSPUtil.getParameter(request, prefix + "yd_co_spc", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setYdCoVolBxKnt(JSPUtil.getParameter(request, prefix + "yd_co_vol_bx_knt", ""));
        setYdRmk(JSPUtil.getParameter(request, prefix + "yd_rmk", ""));
        setDemObCltFlg(JSPUtil.getParameter(request, prefix + "dem_ob_clt_flg", ""));
        setYdTtlVolBxKnt(JSPUtil.getParameter(request, prefix + "yd_ttl_vol_bx_knt", ""));
        setBrthNo(JSPUtil.getParameter(request, prefix + "brth_no", ""));
        setYdCoVolTeuKnt(JSPUtil.getParameter(request, prefix + "yd_co_vol_teu_knt", ""));
        setRepZnCd(JSPUtil.getParameter(request, prefix + "rep_zn_cd", ""));
        setYdFctyTpCyFlg(JSPUtil.getParameter(request, prefix + "yd_fcty_tp_cy_flg", ""));
        setPhnNo(JSPUtil.getParameter(request, prefix + "phn_no", ""));
        setTrstrKnt(JSPUtil.getParameter(request, prefix + "trstr_knt", ""));
        setN2ndVndrSeq(JSPUtil.getParameter(request, prefix + "n2nd_vndr_seq", ""));
        setSunGateOpnHrmnt(JSPUtil.getParameter(request, prefix + "sun_gate_opn_hrmnt", ""));
        setYdCeoNm(JSPUtil.getParameter(request, prefix + "yd_ceo_nm", ""));
        setTmlProdKnt(JSPUtil.getParameter(request, prefix + "tml_prod_knt", ""));
        setYdPicNm(JSPUtil.getParameter(request, prefix + "yd_pic_nm", ""));
        setYdHndlYr(JSPUtil.getParameter(request, prefix + "yd_hndl_yr", ""));
        setYdCfsSpc(JSPUtil.getParameter(request, prefix + "yd_cfs_spc", ""));
        setYdChrCd(JSPUtil.getParameter(request, prefix + "yd_chr_cd", ""));
        setZipCd(JSPUtil.getParameter(request, prefix + "zip_cd", ""));
        setYdNm(JSPUtil.getParameter(request, prefix + "yd_nm", ""));
        setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
        setYdOshpCd(JSPUtil.getParameter(request, prefix + "yd_oshp_cd", ""));
        setSunGateClzHrmnt(JSPUtil.getParameter(request, prefix + "sun_gate_clz_hrmnt", ""));
        setHubYdFlg(JSPUtil.getParameter(request, prefix + "hub_yd_flg", ""));
        setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
        setYdStrdlCrrKnt(JSPUtil.getParameter(request, prefix + "yd_strdl_crr_knt", ""));
        setYdRfRcptDulKnt(JSPUtil.getParameter(request, prefix + "yd_rf_rcpt_dul_knt", ""));
        setYdFctyTpPsdoYdFlg(JSPUtil.getParameter(request, prefix + "yd_fcty_tp_psdo_yd_flg", ""));
        setYdTopLftKnt(JSPUtil.getParameter(request, prefix + "yd_top_lft_knt", ""));
        setYdPstPgcKnt(JSPUtil.getParameter(request, prefix + "yd_pst_pgc_knt", ""));
        setYdFctyTpCfsFlg(JSPUtil.getParameter(request, prefix + "yd_fcty_tp_cfs_flg", ""));
        setYdInrlFlg(JSPUtil.getParameter(request, prefix + "yd_inrl_flg", ""));
        setYdPgcKnt(JSPUtil.getParameter(request, prefix + "yd_pgc_knt", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setYdTtlVolTeuKnt(JSPUtil.getParameter(request, prefix + "yd_ttl_vol_teu_knt", ""));
        setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
        setN1stVndrSeq(JSPUtil.getParameter(request, prefix + "n1st_vndr_seq", ""));
        setGateClzHrmnt(JSPUtil.getParameter(request, prefix + "gate_clz_hrmnt", ""));
        setDemIbCltFlg(JSPUtil.getParameter(request, prefix + "dem_ib_clt_flg", ""));
        setSatGateOpnHrmnt(JSPUtil.getParameter(request, prefix + "sat_gate_opn_hrmnt", ""));
        setN3rdVndrSeq(JSPUtil.getParameter(request, prefix + "n3rd_vndr_seq", ""));
        setYdCstmsNo(JSPUtil.getParameter(request, prefix + "yd_cstms_no", ""));
        setYdTtlSpc(JSPUtil.getParameter(request, prefix + "yd_ttl_spc", ""));
        setDmdtOfcCd(JSPUtil.getParameter(request, prefix + "dmdt_ofc_cd", ""));
        setYdBrthAlngSdDesc(JSPUtil.getParameter(request, prefix + "yd_brth_alng_sd_desc", ""));
        setGateOpnHrmnt(JSPUtil.getParameter(request, prefix + "gate_opn_hrmnt", ""));
        setYdFctyTpRailRmpFlg(JSPUtil.getParameter(request, prefix + "yd_fcty_tp_rail_rmp_flg", ""));
        setYdFctyTpMrnTmlFlg(JSPUtil.getParameter(request, prefix + "yd_fcty_tp_mrn_tml_flg", ""));
        setYdHndlCapa(JSPUtil.getParameter(request, prefix + "yd_hndl_capa", ""));
        setYdRfRcpt440vKnt(JSPUtil.getParameter(request, prefix + "yd_rf_rcpt_440v_knt", ""));
        setMnrShopFlg(JSPUtil.getParameter(request, prefix + "mnr_shop_flg", ""));
        setEirSvcFlg(JSPUtil.getParameter(request, prefix + "eir_svc_flg", ""));
        setTmlChssKnt(JSPUtil.getParameter(request, prefix + "tml_chss_knt", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setSatGateClzHrmnt(JSPUtil.getParameter(request, prefix + "sat_gate_clz_hrmnt", ""));
        setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
        setFrkKnt(JSPUtil.getParameter(request, prefix + "frk_knt", ""));
        setYdBrthLen(JSPUtil.getParameter(request, prefix + "yd_brth_len", ""));
        setYdAddr(JSPUtil.getParameter(request, prefix + "yd_addr", ""));
        setYdOpSysCd(JSPUtil.getParameter(request, prefix + "yd_op_sys_cd", ""));
        setBdYdFlg(JSPUtil.getParameter(request, prefix + "bd_yd_flg", ""));
        setYdEml(JSPUtil.getParameter(request, prefix + "yd_eml", ""));
        setIntlPhnNo(JSPUtil.getParameter(request, prefix + "intl_phn_no", ""));
        setN1stVndrNm(JSPUtil.getParameter(request, prefix + "n1st_vndr_nm", ""));
        setN2ndVndrNm(JSPUtil.getParameter(request, prefix + "n2nd_vndr_nm", ""));
        setN3rdVndrNm(JSPUtil.getParameter(request, prefix + "n3rd_vndr_nm", ""));
        setYdLoclLangNm(JSPUtil.getParameter(request, prefix + "yd_locl_lang_nm", ""));
        setYdLoclLangAddr(JSPUtil.getParameter(request, prefix + "yd_locl_lang_addr", ""));
        setBkgPodYdFlg(JSPUtil.getParameter(request, prefix + "bkg_pod_yd_flg", ""));
        setEqSccCd(JSPUtil.getParameter(request, prefix + "eq_scc_cd", ""));
        setRqstNo(JSPUtil.getParameter(request, prefix + "rqst_no", ""));
        setModiYdCd(JSPUtil.getParameter(request, prefix + "modi_yd_cd", ""));
        setRfMinDwllHrs(JSPUtil.getParameter(request, prefix + "rf_min_dwll_hrs", ""));
        setDryMinDwllHrs(JSPUtil.getParameter(request, prefix + "dry_min_dwll_hrs", ""));
        setRfAvgDwllHrs(JSPUtil.getParameter(request, prefix + "rf_avg_dwll_hrs", ""));
        setDryAvgDwllHrs(JSPUtil.getParameter(request, prefix + "dry_avg_dwll_hrs", ""));
        setRailArrNtfcFlg(JSPUtil.getParameter(request, prefix + "rail_arr_ntfc_flg", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setEdiIfFlg(JSPUtil.getParameter(request, prefix + "edi_if_flg", ""));
        setYdLat(JSPUtil.getParameter(request, prefix + "yd_lat", ""));
        setYdLon(JSPUtil.getParameter(request, prefix + "yd_lon", ""));
        setCudFlg(JSPUtil.getParameter(request, prefix + "cud_flg", ""));
        setYdHjsSpc(JSPUtil.getParameter(request, prefix + "yd_hjs_spc", ""));
        setYdHjsVolTeuKnt(JSPUtil.getParameter(request, prefix + "yd_hjs_vol_teu_knt", ""));
        setYdHjsVolBxKnt(JSPUtil.getParameter(request, prefix + "yd_hjs_vol_bx_knt", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return YardVO[]
	 */
    public YardVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return YardVO[]
	 */
    public YardVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        YardVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ydCgoClzHrmntMsg = (JSPUtil.getParameter(request, prefix + "yd_cgo_clz_hrmnt_msg", length));
            String[] ydTrctKnt = (JSPUtil.getParameter(request, prefix + "yd_trct_knt", length));
            String[] ydActSpc = (JSPUtil.getParameter(request, prefix + "yd_act_spc", length));
            String[] ydRfRcpt220vKnt = (JSPUtil.getParameter(request, prefix + "yd_rf_rcpt_220v_knt", length));
            String[] holGateClzHrmnt = (JSPUtil.getParameter(request, prefix + "hol_gate_clz_hrmnt", length));
            String[] ydBrthDpthChnlKnt = (JSPUtil.getParameter(request, prefix + "yd_brth_dpth_chnl_knt", length));
            String[] ydFctyTpBrgRmpFlg = (JSPUtil.getParameter(request, prefix + "yd_fcty_tp_brg_rmp_flg", length));
            String[] holGateOpnHrmnt = (JSPUtil.getParameter(request, prefix + "hol_gate_opn_hrmnt", length));
            String[] ydCoSpc = (JSPUtil.getParameter(request, prefix + "yd_co_spc", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] ydCoVolBxKnt = (JSPUtil.getParameter(request, prefix + "yd_co_vol_bx_knt", length));
            String[] ydRmk = (JSPUtil.getParameter(request, prefix + "yd_rmk", length));
            String[] demObCltFlg = (JSPUtil.getParameter(request, prefix + "dem_ob_clt_flg", length));
            String[] ydTtlVolBxKnt = (JSPUtil.getParameter(request, prefix + "yd_ttl_vol_bx_knt", length));
            String[] brthNo = (JSPUtil.getParameter(request, prefix + "brth_no", length));
            String[] ydCoVolTeuKnt = (JSPUtil.getParameter(request, prefix + "yd_co_vol_teu_knt", length));
            String[] repZnCd = (JSPUtil.getParameter(request, prefix + "rep_zn_cd", length));
            String[] ydFctyTpCyFlg = (JSPUtil.getParameter(request, prefix + "yd_fcty_tp_cy_flg", length));
            String[] phnNo = (JSPUtil.getParameter(request, prefix + "phn_no", length));
            String[] trstrKnt = (JSPUtil.getParameter(request, prefix + "trstr_knt", length));
            String[] n2ndVndrSeq = (JSPUtil.getParameter(request, prefix + "n2nd_vndr_seq", length));
            String[] sunGateOpnHrmnt = (JSPUtil.getParameter(request, prefix + "sun_gate_opn_hrmnt", length));
            String[] ydCeoNm = (JSPUtil.getParameter(request, prefix + "yd_ceo_nm", length));
            String[] tmlProdKnt = (JSPUtil.getParameter(request, prefix + "tml_prod_knt", length));
            String[] ydPicNm = (JSPUtil.getParameter(request, prefix + "yd_pic_nm", length));
            String[] ydHndlYr = (JSPUtil.getParameter(request, prefix + "yd_hndl_yr", length));
            String[] ydCfsSpc = (JSPUtil.getParameter(request, prefix + "yd_cfs_spc", length));
            String[] ydChrCd = (JSPUtil.getParameter(request, prefix + "yd_chr_cd", length));
            String[] zipCd = (JSPUtil.getParameter(request, prefix + "zip_cd", length));
            String[] ydNm = (JSPUtil.getParameter(request, prefix + "yd_nm", length));
            String[] faxNo = (JSPUtil.getParameter(request, prefix + "fax_no", length));
            String[] ydOshpCd = (JSPUtil.getParameter(request, prefix + "yd_oshp_cd", length));
            String[] sunGateClzHrmnt = (JSPUtil.getParameter(request, prefix + "sun_gate_clz_hrmnt", length));
            String[] hubYdFlg = (JSPUtil.getParameter(request, prefix + "hub_yd_flg", length));
            String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
            String[] ydStrdlCrrKnt = (JSPUtil.getParameter(request, prefix + "yd_strdl_crr_knt", length));
            String[] ydRfRcptDulKnt = (JSPUtil.getParameter(request, prefix + "yd_rf_rcpt_dul_knt", length));
            String[] ydFctyTpPsdoYdFlg = (JSPUtil.getParameter(request, prefix + "yd_fcty_tp_psdo_yd_flg", length));
            String[] ydTopLftKnt = (JSPUtil.getParameter(request, prefix + "yd_top_lft_knt", length));
            String[] ydPstPgcKnt = (JSPUtil.getParameter(request, prefix + "yd_pst_pgc_knt", length));
            String[] ydFctyTpCfsFlg = (JSPUtil.getParameter(request, prefix + "yd_fcty_tp_cfs_flg", length));
            String[] ydInrlFlg = (JSPUtil.getParameter(request, prefix + "yd_inrl_flg", length));
            String[] ydPgcKnt = (JSPUtil.getParameter(request, prefix + "yd_pgc_knt", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] ydTtlVolTeuKnt = (JSPUtil.getParameter(request, prefix + "yd_ttl_vol_teu_knt", length));
            String[] usrId = (JSPUtil.getParameter(request, prefix + "usr_id", length));
            String[] n1stVndrSeq = (JSPUtil.getParameter(request, prefix + "n1st_vndr_seq", length));
            String[] gateClzHrmnt = (JSPUtil.getParameter(request, prefix + "gate_clz_hrmnt", length));
            String[] demIbCltFlg = (JSPUtil.getParameter(request, prefix + "dem_ib_clt_flg", length));
            String[] satGateOpnHrmnt = (JSPUtil.getParameter(request, prefix + "sat_gate_opn_hrmnt", length));
            String[] n3rdVndrSeq = (JSPUtil.getParameter(request, prefix + "n3rd_vndr_seq", length));
            String[] ydCstmsNo = (JSPUtil.getParameter(request, prefix + "yd_cstms_no", length));
            String[] ydTtlSpc = (JSPUtil.getParameter(request, prefix + "yd_ttl_spc", length));
            String[] dmdtOfcCd = (JSPUtil.getParameter(request, prefix + "dmdt_ofc_cd", length));
            String[] ydBrthAlngSdDesc = (JSPUtil.getParameter(request, prefix + "yd_brth_alng_sd_desc", length));
            String[] gateOpnHrmnt = (JSPUtil.getParameter(request, prefix + "gate_opn_hrmnt", length));
            String[] ydFctyTpRailRmpFlg = (JSPUtil.getParameter(request, prefix + "yd_fcty_tp_rail_rmp_flg", length));
            String[] ydFctyTpMrnTmlFlg = (JSPUtil.getParameter(request, prefix + "yd_fcty_tp_mrn_tml_flg", length));
            String[] ydHndlCapa = (JSPUtil.getParameter(request, prefix + "yd_hndl_capa", length));
            String[] ydRfRcpt440vKnt = (JSPUtil.getParameter(request, prefix + "yd_rf_rcpt_440v_knt", length));
            String[] mnrShopFlg = (JSPUtil.getParameter(request, prefix + "mnr_shop_flg", length));
            String[] eirSvcFlg = (JSPUtil.getParameter(request, prefix + "eir_svc_flg", length));
            String[] tmlChssKnt = (JSPUtil.getParameter(request, prefix + "tml_chss_knt", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] satGateClzHrmnt = (JSPUtil.getParameter(request, prefix + "sat_gate_clz_hrmnt", length));
            String[] ydCd = (JSPUtil.getParameter(request, prefix + "yd_cd", length));
            String[] frkKnt = (JSPUtil.getParameter(request, prefix + "frk_knt", length));
            String[] ydBrthLen = (JSPUtil.getParameter(request, prefix + "yd_brth_len", length));
            String[] ydAddr = (JSPUtil.getParameter(request, prefix + "yd_addr", length));
            String[] ydOpSysCd = (JSPUtil.getParameter(request, prefix + "yd_op_sys_cd", length));
            String[] bdYdFlg = (JSPUtil.getParameter(request, prefix + "bd_yd_flg", length));
            String[] ydEml = (JSPUtil.getParameter(request, prefix + "yd_eml", length));
            String[] intlPhnNo = (JSPUtil.getParameter(request, prefix + "intl_phn_no", length));
            String[] n1stVndrNm = (JSPUtil.getParameter(request, prefix + "n1st_vndr_nm", length));
            String[] n2ndVndrNm = (JSPUtil.getParameter(request, prefix + "n2nd_vndr_nm", length));
            String[] n3rdVndrNm = (JSPUtil.getParameter(request, prefix + "n3rd_vndr_nm", length));
            String[] ydLoclLangNm = (JSPUtil.getParameter(request, prefix + "yd_locl_lang_nm", length));
            String[] ydLoclLangAddr = (JSPUtil.getParameter(request, prefix + "yd_locl_lang_addr", length));
            String[] bkgPodYdFlg = (JSPUtil.getParameter(request, prefix + "bkg_pod_yd_flg", length));
            String[] eqSccCd = (JSPUtil.getParameter(request, prefix + "eq_scc_cd", length));
            String[] rqstNo = (JSPUtil.getParameter(request, prefix + "rqst_no", length));
            String[] modiYdCd = (JSPUtil.getParameter(request, prefix + "modi_yd_cd", length));
            String[] rfMinDwllHrs = (JSPUtil.getParameter(request, prefix + "rf_min_dwll_hrs", length));
            String[] dryMinDwllHrs = (JSPUtil.getParameter(request, prefix + "dry_min_dwll_hrs", length));
            String[] rfAvgDwllHrs = (JSPUtil.getParameter(request, prefix + "rf_avg_dwll_hrs", length));
            String[] dryAvgDwllHrs = (JSPUtil.getParameter(request, prefix + "dry_avg_dwll_hrs", length));
            String[] railArrNtfcFlg = (JSPUtil.getParameter(request, prefix + "rail_arr_ntfc_flg", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] ediIfFlg = (JSPUtil.getParameter(request, prefix + "edi_if_flg", length));
            String[] ydLat = (JSPUtil.getParameter(request, prefix + "yd_lat", length));
            String[] ydLon = (JSPUtil.getParameter(request, prefix + "yd_lon", length));
            String[] cudFlg = (JSPUtil.getParameter(request, prefix + "cud_flg", length));
            String[] ydHjsSpc = (JSPUtil.getParameter(request, prefix + "yd_hjs_spc", length));
            String[] ydHjsVolTeuKnt = (JSPUtil.getParameter(request, prefix + "yd_hjs_vol_teu_knt", length));
	    	String[] ydHjsVolBxKnt = (JSPUtil.getParameter(request, prefix + "yd_hjs_vol_bx_knt", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new YardVO();
                if (ydCgoClzHrmntMsg[i] != null)
                    model.setYdCgoClzHrmntMsg(ydCgoClzHrmntMsg[i]);
                if (ydTrctKnt[i] != null)
                    model.setYdTrctKnt(ydTrctKnt[i]);
                if (ydActSpc[i] != null)
                    model.setYdActSpc(ydActSpc[i]);
                if (ydRfRcpt220vKnt[i] != null)
                    model.setYdRfRcpt220vKnt(ydRfRcpt220vKnt[i]);
                if (holGateClzHrmnt[i] != null)
                    model.setHolGateClzHrmnt(holGateClzHrmnt[i]);
                if (ydBrthDpthChnlKnt[i] != null)
                    model.setYdBrthDpthChnlKnt(ydBrthDpthChnlKnt[i]);
                if (ydFctyTpBrgRmpFlg[i] != null)
                    model.setYdFctyTpBrgRmpFlg(ydFctyTpBrgRmpFlg[i]);
                if (holGateOpnHrmnt[i] != null)
                    model.setHolGateOpnHrmnt(holGateOpnHrmnt[i]);
                if (ydCoSpc[i] != null)
                    model.setYdCoSpc(ydCoSpc[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ydCoVolBxKnt[i] != null)
                    model.setYdCoVolBxKnt(ydCoVolBxKnt[i]);
                if (ydRmk[i] != null)
                    model.setYdRmk(ydRmk[i]);
                if (demObCltFlg[i] != null)
                    model.setDemObCltFlg(demObCltFlg[i]);
                if (ydTtlVolBxKnt[i] != null)
                    model.setYdTtlVolBxKnt(ydTtlVolBxKnt[i]);
                if (brthNo[i] != null)
                    model.setBrthNo(brthNo[i]);
                if (ydCoVolTeuKnt[i] != null)
                    model.setYdCoVolTeuKnt(ydCoVolTeuKnt[i]);
                if (repZnCd[i] != null)
                    model.setRepZnCd(repZnCd[i]);
                if (ydFctyTpCyFlg[i] != null)
                    model.setYdFctyTpCyFlg(ydFctyTpCyFlg[i]);
                if (phnNo[i] != null)
                    model.setPhnNo(phnNo[i]);
                if (trstrKnt[i] != null)
                    model.setTrstrKnt(trstrKnt[i]);
                if (n2ndVndrSeq[i] != null)
                    model.setN2ndVndrSeq(n2ndVndrSeq[i]);
                if (sunGateOpnHrmnt[i] != null)
                    model.setSunGateOpnHrmnt(sunGateOpnHrmnt[i]);
                if (ydCeoNm[i] != null)
                    model.setYdCeoNm(ydCeoNm[i]);
                if (tmlProdKnt[i] != null)
                    model.setTmlProdKnt(tmlProdKnt[i]);
                if (ydPicNm[i] != null)
                    model.setYdPicNm(ydPicNm[i]);
                if (ydHndlYr[i] != null)
                    model.setYdHndlYr(ydHndlYr[i]);
                if (ydCfsSpc[i] != null)
                    model.setYdCfsSpc(ydCfsSpc[i]);
                if (ydChrCd[i] != null)
                    model.setYdChrCd(ydChrCd[i]);
                if (zipCd[i] != null)
                    model.setZipCd(zipCd[i]);
                if (ydNm[i] != null)
                    model.setYdNm(ydNm[i]);
                if (faxNo[i] != null)
                    model.setFaxNo(faxNo[i]);
                if (ydOshpCd[i] != null)
                    model.setYdOshpCd(ydOshpCd[i]);
                if (sunGateClzHrmnt[i] != null)
                    model.setSunGateClzHrmnt(sunGateClzHrmnt[i]);
                if (hubYdFlg[i] != null)
                    model.setHubYdFlg(hubYdFlg[i]);
                if (deltFlg[i] != null)
                    model.setDeltFlg(deltFlg[i]);
                if (ydStrdlCrrKnt[i] != null)
                    model.setYdStrdlCrrKnt(ydStrdlCrrKnt[i]);
                if (ydRfRcptDulKnt[i] != null)
                    model.setYdRfRcptDulKnt(ydRfRcptDulKnt[i]);
                if (ydFctyTpPsdoYdFlg[i] != null)
                    model.setYdFctyTpPsdoYdFlg(ydFctyTpPsdoYdFlg[i]);
                if (ydTopLftKnt[i] != null)
                    model.setYdTopLftKnt(ydTopLftKnt[i]);
                if (ydPstPgcKnt[i] != null)
                    model.setYdPstPgcKnt(ydPstPgcKnt[i]);
                if (ydFctyTpCfsFlg[i] != null)
                    model.setYdFctyTpCfsFlg(ydFctyTpCfsFlg[i]);
                if (ydInrlFlg[i] != null)
                    model.setYdInrlFlg(ydInrlFlg[i]);
                if (ydPgcKnt[i] != null)
                    model.setYdPgcKnt(ydPgcKnt[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (ydTtlVolTeuKnt[i] != null)
                    model.setYdTtlVolTeuKnt(ydTtlVolTeuKnt[i]);
                if (usrId[i] != null)
                    model.setUsrId(usrId[i]);
                if (n1stVndrSeq[i] != null)
                    model.setN1stVndrSeq(n1stVndrSeq[i]);
                if (gateClzHrmnt[i] != null)
                    model.setGateClzHrmnt(gateClzHrmnt[i]);
                if (demIbCltFlg[i] != null)
                    model.setDemIbCltFlg(demIbCltFlg[i]);
                if (satGateOpnHrmnt[i] != null)
                    model.setSatGateOpnHrmnt(satGateOpnHrmnt[i]);
                if (n3rdVndrSeq[i] != null)
                    model.setN3rdVndrSeq(n3rdVndrSeq[i]);
                if (ydCstmsNo[i] != null)
                    model.setYdCstmsNo(ydCstmsNo[i]);
                if (ydTtlSpc[i] != null)
                    model.setYdTtlSpc(ydTtlSpc[i]);
                if (dmdtOfcCd[i] != null)
                    model.setDmdtOfcCd(dmdtOfcCd[i]);
                if (ydBrthAlngSdDesc[i] != null)
                    model.setYdBrthAlngSdDesc(ydBrthAlngSdDesc[i]);
                if (gateOpnHrmnt[i] != null)
                    model.setGateOpnHrmnt(gateOpnHrmnt[i]);
                if (ydFctyTpRailRmpFlg[i] != null)
                    model.setYdFctyTpRailRmpFlg(ydFctyTpRailRmpFlg[i]);
                if (ydFctyTpMrnTmlFlg[i] != null)
                    model.setYdFctyTpMrnTmlFlg(ydFctyTpMrnTmlFlg[i]);
                if (ydHndlCapa[i] != null)
                    model.setYdHndlCapa(ydHndlCapa[i]);
                if (ydRfRcpt440vKnt[i] != null)
                    model.setYdRfRcpt440vKnt(ydRfRcpt440vKnt[i]);
                if (mnrShopFlg[i] != null)
                    model.setMnrShopFlg(mnrShopFlg[i]);
                if (eirSvcFlg[i] != null)
                    model.setEirSvcFlg(eirSvcFlg[i]);
                if (tmlChssKnt[i] != null)
                    model.setTmlChssKnt(tmlChssKnt[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (satGateClzHrmnt[i] != null)
                    model.setSatGateClzHrmnt(satGateClzHrmnt[i]);
                if (ydCd[i] != null)
                    model.setYdCd(ydCd[i]);
                if (frkKnt[i] != null)
                    model.setFrkKnt(frkKnt[i]);
                if (ydBrthLen[i] != null)
                    model.setYdBrthLen(ydBrthLen[i]);
                if (ydAddr[i] != null)
                    model.setYdAddr(ydAddr[i]);
                if (ydOpSysCd[i] != null)
                    model.setYdOpSysCd(ydOpSysCd[i]);
                if (bdYdFlg[i] != null)
                    model.setBdYdFlg(bdYdFlg[i]);
                if (ydEml[i] != null)
                    model.setYdEml(ydEml[i]);
                if (intlPhnNo[i] != null)
                    model.setIntlPhnNo(intlPhnNo[i]);
                if (n1stVndrNm[i] != null)
                    model.setN1stVndrNm(n1stVndrNm[i]);
                if (n2ndVndrNm[i] != null)
                    model.setN2ndVndrNm(n2ndVndrNm[i]);
                if (n3rdVndrNm[i] != null)
                    model.setN3rdVndrNm(n3rdVndrNm[i]);
                if (ydLoclLangNm[i] != null)
                    model.setYdLoclLangNm(ydLoclLangNm[i]);
                if (ydLoclLangAddr[i] != null)
                    model.setYdLoclLangAddr(ydLoclLangAddr[i]);
                if (bkgPodYdFlg[i] != null)
                    model.setBkgPodYdFlg(bkgPodYdFlg[i]);
                if (eqSccCd[i] != null)
                    model.setEqSccCd(eqSccCd[i]);
                if (rqstNo[i] != null)
                    model.setRqstNo(rqstNo[i]);
                if (modiYdCd[i] != null)
                    model.setModiYdCd(modiYdCd[i]);
                if (rfMinDwllHrs[i] != null)
                    model.setRfMinDwllHrs(rfMinDwllHrs[i]);
                if (dryMinDwllHrs[i] != null)
                    model.setDryMinDwllHrs(dryMinDwllHrs[i]);
                if (rfAvgDwllHrs[i] != null)
                    model.setRfAvgDwllHrs(rfAvgDwllHrs[i]);
                if (dryAvgDwllHrs[i] != null)
                    model.setDryAvgDwllHrs(dryAvgDwllHrs[i]);
                if (railArrNtfcFlg[i] != null)
                    model.setRailArrNtfcFlg(railArrNtfcFlg[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (ediIfFlg[i] != null)
                    model.setEdiIfFlg(ediIfFlg[i]);
                if (ydLat[i] != null)
                    model.setYdLat(ydLat[i]);
                if (ydLon[i] != null)
                    model.setYdLon(ydLon[i]);
                if (cudFlg[i] != null)
                    model.setCudFlg(cudFlg[i]);
                if (ydHjsSpc[i] != null)
                    model.setYdHjsSpc(ydHjsSpc[i]);
                if (ydHjsVolTeuKnt[i] != null) 
		    		model.setYdHjsVolTeuKnt(ydHjsVolTeuKnt[i]);
				if (ydHjsVolBxKnt[i] != null) 
		    		model.setYdHjsVolBxKnt(ydHjsVolBxKnt[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getYardVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return YardVO[]
	 */
    public YardVO[] getYardVOs() {
        YardVO[] vos = (YardVO[]) models.toArray(new YardVO[models.size()]);
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
        this.ydCgoClzHrmntMsg = this.ydCgoClzHrmntMsg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydTrctKnt = this.ydTrctKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydActSpc = this.ydActSpc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydRfRcpt220vKnt = this.ydRfRcpt220vKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.holGateClzHrmnt = this.holGateClzHrmnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydBrthDpthChnlKnt = this.ydBrthDpthChnlKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydFctyTpBrgRmpFlg = this.ydFctyTpBrgRmpFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.holGateOpnHrmnt = this.holGateOpnHrmnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydCoSpc = this.ydCoSpc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydCoVolBxKnt = this.ydCoVolBxKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydRmk = this.ydRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.demObCltFlg = this.demObCltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydTtlVolBxKnt = this.ydTtlVolBxKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.brthNo = this.brthNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydCoVolTeuKnt = this.ydCoVolTeuKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.repZnCd = this.repZnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydFctyTpCyFlg = this.ydFctyTpCyFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.phnNo = this.phnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trstrKnt = this.trstrKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n2ndVndrSeq = this.n2ndVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sunGateOpnHrmnt = this.sunGateOpnHrmnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydCeoNm = this.ydCeoNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tmlProdKnt = this.tmlProdKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydPicNm = this.ydPicNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydHndlYr = this.ydHndlYr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydCfsSpc = this.ydCfsSpc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydChrCd = this.ydChrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.zipCd = this.zipCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydNm = this.ydNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.faxNo = this.faxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydOshpCd = this.ydOshpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sunGateClzHrmnt = this.sunGateClzHrmnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hubYdFlg = this.hubYdFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydStrdlCrrKnt = this.ydStrdlCrrKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydRfRcptDulKnt = this.ydRfRcptDulKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydFctyTpPsdoYdFlg = this.ydFctyTpPsdoYdFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydTopLftKnt = this.ydTopLftKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydPstPgcKnt = this.ydPstPgcKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydFctyTpCfsFlg = this.ydFctyTpCfsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydInrlFlg = this.ydInrlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydPgcKnt = this.ydPgcKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydTtlVolTeuKnt = this.ydTtlVolTeuKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrId = this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n1stVndrSeq = this.n1stVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.gateClzHrmnt = this.gateClzHrmnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.demIbCltFlg = this.demIbCltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.satGateOpnHrmnt = this.satGateOpnHrmnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n3rdVndrSeq = this.n3rdVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydCstmsNo = this.ydCstmsNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydTtlSpc = this.ydTtlSpc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtOfcCd = this.dmdtOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydBrthAlngSdDesc = this.ydBrthAlngSdDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.gateOpnHrmnt = this.gateOpnHrmnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydFctyTpRailRmpFlg = this.ydFctyTpRailRmpFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydFctyTpMrnTmlFlg = this.ydFctyTpMrnTmlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydHndlCapa = this.ydHndlCapa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydRfRcpt440vKnt = this.ydRfRcpt440vKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mnrShopFlg = this.mnrShopFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eirSvcFlg = this.eirSvcFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tmlChssKnt = this.tmlChssKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.satGateClzHrmnt = this.satGateClzHrmnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydCd = this.ydCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frkKnt = this.frkKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydBrthLen = this.ydBrthLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydAddr = this.ydAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydOpSysCd = this.ydOpSysCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bdYdFlg = this.bdYdFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydEml = this.ydEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intlPhnNo = this.intlPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n1stVndrNm = this.n1stVndrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n2ndVndrNm = this.n2ndVndrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n3rdVndrNm = this.n3rdVndrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydLoclLangNm = this.ydLoclLangNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydLoclLangAddr = this.ydLoclLangAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgPodYdFlg = this.bkgPodYdFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqSccCd = this.eqSccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstNo = this.rqstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.modiYdCd = this.modiYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfMinDwllHrs = this.rfMinDwllHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dryMinDwllHrs = this.dryMinDwllHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfAvgDwllHrs = this.rfAvgDwllHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dryAvgDwllHrs = this.dryAvgDwllHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.railArrNtfcFlg = this.railArrNtfcFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediIfFlg = this.ediIfFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydLat = this.ydLat.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydLon = this.ydLon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cudFlg = this.cudFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydHjsSpc = this.ydHjsSpc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydHjsVolTeuKnt = this.ydHjsVolTeuKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydHjsVolBxKnt = this.ydHjsVolBxKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
