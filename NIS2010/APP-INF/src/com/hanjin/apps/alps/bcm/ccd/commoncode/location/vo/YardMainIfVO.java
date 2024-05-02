/*=========================================================
*Copyright(c) 2018 Smline
*@FileName : YardMainIfVO.java
*@FileTitle : YardMainIfVO
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

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class YardMainIfVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<YardMainIfVO> models = new ArrayList<YardMainIfVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String ydCd = null;

    /* Column Info */
    private String ydNm = null;

    /* Column Info */
    private String locCd = null;

    /* Column Info */
    private String n1stVndrCntCd = null;

    /* Column Info */
    private String n1stVndrSeq = null;

    /* Column Info */
    private String n2ndVndrCntCd = null;

    /* Column Info */
    private String n2ndVndrSeq = null;

    /* Column Info */
    private String n3rdVndrCntCd = null;

    /* Column Info */
    private String n3rdVndrSeq = null;

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String hubYdFlg = null;

    /* Column Info */
    private String ydChrCd = null;

    /* Column Info */
    private String ydFctyTpMrnTmlFlg = null;

    /* Column Info */
    private String ydFctyTpCyFlg = null;

    /* Column Info */
    private String ydFctyTpCfsFlg = null;

    /* Column Info */
    private String ydFctyTpRailRmpFlg = null;

    /* Column Info */
    private String ydOshpCd = null;

    /* Column Info */
    private String bdYdFlg = null;

    /* Column Info */
    private String ydAddr = null;

    /* Column Info */
    private String zipCd = null;

    /* Column Info */
    private String intlPhnNo = null;

    /* Column Info */
    private String phnNo = null;

    /* Column Info */
    private String faxNo = null;

    /* Column Info */
    private String ydPicNm = null;

    /* Column Info */
    private String ydCeoNm = null;

    /* Column Info */
    private String gateOpnHrmnt = null;

    /* Column Info */
    private String gateClzHrmnt = null;

    /* Column Info */
    private String holGateOpnHrmnt = null;

    /* Column Info */
    private String holGateClzHrmnt = null;

    /* Column Info */
    private String sunGateOpnHrmnt = null;

    /* Column Info */
    private String sunGateClzHrmnt = null;

    /* Column Info */
    private String satGateOpnHrmnt = null;

    /* Column Info */
    private String satGateClzHrmnt = null;

    /* Column Info */
    private String ydRmk = null;

    /* Column Info */
    private String brthNo = null;

    /* Column Info */
    private String ydBrthLen = null;

    /* Column Info */
    private String ydBrthAlngSdDesc = null;

    /* Column Info */
    private String ydBrthDpthChnlKnt = null;

    /* Column Info */
    private String ydTtlSpc = null;

    /* Column Info */
    private String ydActSpc = null;

    /* Column Info */
    private String ydHjsSpc = null;

    /* Column Info */
    private String ydHndlCapa = null;

    /* Column Info */
    private String ydRfRcpt440VKnt = null;

    /* Column Info */
    private String ydRfRcpt220VKnt = null;

    /* Column Info */
    private String ydRfRcptDulKnt = null;

    /* Column Info */
    private String ydOpSysCd = null;

    /* Column Info */
    private String ydCfsSpc = null;

    /* Column Info */
    private String mnrShopFlg = null;

    /* Column Info */
    private String ydHndlYr = null;

    /* Column Info */
    private String ydTtlVolTeuKnt = null;

    /* Column Info */
    private String ydTtlVolBxKnt = null;

    /* Column Info */
    private String ydHjsVolTeuKnt = null;

    /* Column Info */
    private String ydHjsVolBxKnt = null;

    /* Column Info */
    private String trstrKnt = null;

    /* Column Info */
    private String frkKnt = null;

    /* Column Info */
    private String ydStrdlCrrKnt = null;

    /* Column Info */
    private String ydTrctKnt = null;

    /* Column Info */
    private String ydTopLftKnt = null;

    /* Column Info */
    private String tmlChssKnt = null;

    /* Column Info */
    private String eirSvcFlg = null;

    /* Column Info */
    private String tmlProdKnt = null;

    /* Column Info */
    private String ydCstmsNo = null;

    /* Column Info */
    private String ydFctyTpPsdoYdFlg = null;

    /* Column Info */
    private String ydEml = null;

    /* Column Info */
    private String demIbCltFlg = null;

    /* Column Info */
    private String demObCltFlg = null;

    /* Column Info */
    private String bkgPodYdFlg = null;

    /* Column Info */
    private String ydFctyTpBrgRmpFlg = null;

    /* Column Info */
    private String bfrOfcCd = null;

    /* Column Info */
    private String bfrOfcCngDt = null;

    /* Column Info */
    private String modiYdCd = null;

    /* Column Info */
    private String dmdtOfcCd = null;

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
    private String repYdTpCd = null;

    /* Column Info */
    private String dryAvgDwllHrs = null;

    /* Column Info */
    private String dryMinDwllHrs = null;

    /* Column Info */
    private String dryYdFtHrs = null;

    /* Column Info */
    private String ydLoclLangNm = null;

    /* Column Info */
    private String ydLoclLangAddr = null;

    /* Column Info */
    private String cudFlg = null;

    /* Column Info */
    private String usrId = null;

    /* Column Info */
    private String ydCgoClzHrmntMsg = null;

    /* Column Info */
    private String ydInrlFlg = null;

    /* Column Info */
    private String onfHirYdFlg = null;

    /* Column Info */
    private String ydPstPgcKnt = null;

    /* Column Info */
    private String ydPgcKnt = null;

    /* Column Info */
    private String repZnCd = null;

    /* Column Info */
    private String rfAvgDwllHrs = null;

    /* Column Info */
    private String rfMinDwllHrs = null;

    /* Column Info */
    private String rfYdFtHrs = null;

    /* Column Info */
    private String eaiEvntDt = null;

    /* Column Info */
    private String eaiIfId = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public YardMainIfVO() {
    }

    public YardMainIfVO(String ibflag, String pagerows, String ydCd, String ydNm, String locCd, String n1stVndrCntCd, String n1stVndrSeq, String n2ndVndrCntCd, String n2ndVndrSeq, String n3rdVndrCntCd, String n3rdVndrSeq, String ofcCd, String hubYdFlg, String ydChrCd, String ydFctyTpMrnTmlFlg, String ydFctyTpCyFlg, String ydFctyTpCfsFlg, String ydFctyTpRailRmpFlg, String ydOshpCd, String bdYdFlg, String ydAddr, String zipCd, String intlPhnNo, String phnNo, String faxNo, String ydPicNm, String ydCeoNm, String gateOpnHrmnt, String gateClzHrmnt, String holGateOpnHrmnt, String holGateClzHrmnt, String sunGateOpnHrmnt, String sunGateClzHrmnt, String satGateOpnHrmnt, String satGateClzHrmnt, String ydRmk, String brthNo, String ydBrthLen, String ydBrthAlngSdDesc, String ydBrthDpthChnlKnt, String ydTtlSpc, String ydActSpc, String ydHjsSpc, String ydHndlCapa, String ydRfRcpt440VKnt, String ydRfRcpt220VKnt, String ydRfRcptDulKnt, String ydOpSysCd, String ydCfsSpc, String mnrShopFlg, String ydHndlYr, String ydTtlVolTeuKnt, String ydTtlVolBxKnt, String ydHjsVolTeuKnt, String ydHjsVolBxKnt, String trstrKnt, String frkKnt, String ydStrdlCrrKnt, String ydTrctKnt, String ydTopLftKnt, String tmlChssKnt, String eirSvcFlg, String tmlProdKnt, String ydCstmsNo, String ydFctyTpPsdoYdFlg, String ydEml, String demIbCltFlg, String demObCltFlg, String bkgPodYdFlg, String ydFctyTpBrgRmpFlg, String bfrOfcCd, String bfrOfcCngDt, String modiYdCd, String dmdtOfcCd, String creUsrId, String creDt, String updUsrId, String updDt, String deltFlg, String repYdTpCd, String dryAvgDwllHrs, String dryMinDwllHrs, String dryYdFtHrs, String ydLoclLangNm, String ydLoclLangAddr, String cudFlg, String usrId, String ydCgoClzHrmntMsg, String ydInrlFlg, String onfHirYdFlg, String ydPstPgcKnt, String ydPgcKnt, String repZnCd, String rfAvgDwllHrs, String rfMinDwllHrs, String rfYdFtHrs, String eaiEvntDt, String eaiIfId) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.ydCd = ydCd;
        this.ydNm = ydNm;
        this.locCd = locCd;
        this.n1stVndrCntCd = n1stVndrCntCd;
        this.n1stVndrSeq = n1stVndrSeq;
        this.n2ndVndrCntCd = n2ndVndrCntCd;
        this.n2ndVndrSeq = n2ndVndrSeq;
        this.n3rdVndrCntCd = n3rdVndrCntCd;
        this.n3rdVndrSeq = n3rdVndrSeq;
        this.ofcCd = ofcCd;
        this.hubYdFlg = hubYdFlg;
        this.ydChrCd = ydChrCd;
        this.ydFctyTpMrnTmlFlg = ydFctyTpMrnTmlFlg;
        this.ydFctyTpCyFlg = ydFctyTpCyFlg;
        this.ydFctyTpCfsFlg = ydFctyTpCfsFlg;
        this.ydFctyTpRailRmpFlg = ydFctyTpRailRmpFlg;
        this.ydOshpCd = ydOshpCd;
        this.bdYdFlg = bdYdFlg;
        this.ydAddr = ydAddr;
        this.zipCd = zipCd;
        this.intlPhnNo = intlPhnNo;
        this.phnNo = phnNo;
        this.faxNo = faxNo;
        this.ydPicNm = ydPicNm;
        this.ydCeoNm = ydCeoNm;
        this.gateOpnHrmnt = gateOpnHrmnt;
        this.gateClzHrmnt = gateClzHrmnt;
        this.holGateOpnHrmnt = holGateOpnHrmnt;
        this.holGateClzHrmnt = holGateClzHrmnt;
        this.sunGateOpnHrmnt = sunGateOpnHrmnt;
        this.sunGateClzHrmnt = sunGateClzHrmnt;
        this.satGateOpnHrmnt = satGateOpnHrmnt;
        this.satGateClzHrmnt = satGateClzHrmnt;
        this.ydRmk = ydRmk;
        this.brthNo = brthNo;
        this.ydBrthLen = ydBrthLen;
        this.ydBrthAlngSdDesc = ydBrthAlngSdDesc;
        this.ydBrthDpthChnlKnt = ydBrthDpthChnlKnt;
        this.ydTtlSpc = ydTtlSpc;
        this.ydActSpc = ydActSpc;
        this.ydHjsSpc = ydHjsSpc;
        this.ydHndlCapa = ydHndlCapa;
        this.ydRfRcpt440VKnt = ydRfRcpt440VKnt;
        this.ydRfRcpt220VKnt = ydRfRcpt220VKnt;
        this.ydRfRcptDulKnt = ydRfRcptDulKnt;
        this.ydOpSysCd = ydOpSysCd;
        this.ydCfsSpc = ydCfsSpc;
        this.mnrShopFlg = mnrShopFlg;
        this.ydHndlYr = ydHndlYr;
        this.ydTtlVolTeuKnt = ydTtlVolTeuKnt;
        this.ydTtlVolBxKnt = ydTtlVolBxKnt;
        this.ydHjsVolTeuKnt = ydHjsVolTeuKnt;
        this.ydHjsVolBxKnt = ydHjsVolBxKnt;
        this.trstrKnt = trstrKnt;
        this.frkKnt = frkKnt;
        this.ydStrdlCrrKnt = ydStrdlCrrKnt;
        this.ydTrctKnt = ydTrctKnt;
        this.ydTopLftKnt = ydTopLftKnt;
        this.tmlChssKnt = tmlChssKnt;
        this.eirSvcFlg = eirSvcFlg;
        this.tmlProdKnt = tmlProdKnt;
        this.ydCstmsNo = ydCstmsNo;
        this.ydFctyTpPsdoYdFlg = ydFctyTpPsdoYdFlg;
        this.ydEml = ydEml;
        this.demIbCltFlg = demIbCltFlg;
        this.demObCltFlg = demObCltFlg;
        this.bkgPodYdFlg = bkgPodYdFlg;
        this.ydFctyTpBrgRmpFlg = ydFctyTpBrgRmpFlg;
        this.bfrOfcCd = bfrOfcCd;
        this.bfrOfcCngDt = bfrOfcCngDt;
        this.modiYdCd = modiYdCd;
        this.dmdtOfcCd = dmdtOfcCd;
        this.creUsrId = creUsrId;
        this.creDt = creDt;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.deltFlg = deltFlg;
        this.repYdTpCd = repYdTpCd;
        this.dryAvgDwllHrs = dryAvgDwllHrs;
        this.dryMinDwllHrs = dryMinDwllHrs;
        this.dryYdFtHrs = dryYdFtHrs;
        this.ydLoclLangNm = ydLoclLangNm;
        this.ydLoclLangAddr = ydLoclLangAddr;
        this.cudFlg = cudFlg;
        this.usrId = usrId;
        this.ydCgoClzHrmntMsg = ydCgoClzHrmntMsg;
        this.ydInrlFlg = ydInrlFlg;
        this.onfHirYdFlg = onfHirYdFlg;
        this.ydPstPgcKnt = ydPstPgcKnt;
        this.ydPgcKnt = ydPgcKnt;
        this.repZnCd = repZnCd;
        this.rfAvgDwllHrs = rfAvgDwllHrs;
        this.rfMinDwllHrs = rfMinDwllHrs;
        this.rfYdFtHrs = rfYdFtHrs;
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
        this.hashColumns.put("yd_cd", getYdCd());
        this.hashColumns.put("yd_nm", getYdNm());
        this.hashColumns.put("loc_cd", getLocCd());
        this.hashColumns.put("n1st_vndr_cnt_cd", getN1stVndrCntCd());
        this.hashColumns.put("n1st_vndr_seq", getN1stVndrSeq());
        this.hashColumns.put("n2nd_vndr_cnt_cd", getN2ndVndrCntCd());
        this.hashColumns.put("n2nd_vndr_seq", getN2ndVndrSeq());
        this.hashColumns.put("n3rd_vndr_cnt_cd", getN3rdVndrCntCd());
        this.hashColumns.put("n3rd_vndr_seq", getN3rdVndrSeq());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("hub_yd_flg", getHubYdFlg());
        this.hashColumns.put("yd_chr_cd", getYdChrCd());
        this.hashColumns.put("yd_fcty_tp_mrn_tml_flg", getYdFctyTpMrnTmlFlg());
        this.hashColumns.put("yd_fcty_tp_cy_flg", getYdFctyTpCyFlg());
        this.hashColumns.put("yd_fcty_tp_cfs_flg", getYdFctyTpCfsFlg());
        this.hashColumns.put("yd_fcty_tp_rail_rmp_flg", getYdFctyTpRailRmpFlg());
        this.hashColumns.put("yd_oshp_cd", getYdOshpCd());
        this.hashColumns.put("bd_yd_flg", getBdYdFlg());
        this.hashColumns.put("yd_addr", getYdAddr());
        this.hashColumns.put("zip_cd", getZipCd());
        this.hashColumns.put("intl_phn_no", getIntlPhnNo());
        this.hashColumns.put("phn_no", getPhnNo());
        this.hashColumns.put("fax_no", getFaxNo());
        this.hashColumns.put("yd_pic_nm", getYdPicNm());
        this.hashColumns.put("yd_ceo_nm", getYdCeoNm());
        this.hashColumns.put("gate_opn_hrmnt", getGateOpnHrmnt());
        this.hashColumns.put("gate_clz_hrmnt", getGateClzHrmnt());
        this.hashColumns.put("hol_gate_opn_hrmnt", getHolGateOpnHrmnt());
        this.hashColumns.put("hol_gate_clz_hrmnt", getHolGateClzHrmnt());
        this.hashColumns.put("sun_gate_opn_hrmnt", getSunGateOpnHrmnt());
        this.hashColumns.put("sun_gate_clz_hrmnt", getSunGateClzHrmnt());
        this.hashColumns.put("sat_gate_opn_hrmnt", getSatGateOpnHrmnt());
        this.hashColumns.put("sat_gate_clz_hrmnt", getSatGateClzHrmnt());
        this.hashColumns.put("yd_rmk", getYdRmk());
        this.hashColumns.put("brth_no", getBrthNo());
        this.hashColumns.put("yd_brth_len", getYdBrthLen());
        this.hashColumns.put("yd_brth_alng_sd_desc", getYdBrthAlngSdDesc());
        this.hashColumns.put("yd_brth_dpth_chnl_knt", getYdBrthDpthChnlKnt());
        this.hashColumns.put("yd_ttl_spc", getYdTtlSpc());
        this.hashColumns.put("yd_act_spc", getYdActSpc());
        this.hashColumns.put("yd_hjs_spc", getYdHjsSpc());
        this.hashColumns.put("yd_hndl_capa", getYdHndlCapa());
        this.hashColumns.put("yd_rf_rcpt_440V_knt", getYdRfRcpt440VKnt());
        this.hashColumns.put("yd_rf_rcpt_220V_knt", getYdRfRcpt220VKnt());
        this.hashColumns.put("yd_rf_rcpt_dul_knt", getYdRfRcptDulKnt());
        this.hashColumns.put("yd_op_sys_cd", getYdOpSysCd());
        this.hashColumns.put("yd_cfs_spc", getYdCfsSpc());
        this.hashColumns.put("mnr_shop_flg", getMnrShopFlg());
        this.hashColumns.put("yd_hndl_yr", getYdHndlYr());
        this.hashColumns.put("yd_ttl_vol_teu_knt", getYdTtlVolTeuKnt());
        this.hashColumns.put("yd_ttl_vol_bx_knt", getYdTtlVolBxKnt());
        this.hashColumns.put("yd_hjs_vol_teu_knt", getYdHjsVolTeuKnt());
        this.hashColumns.put("yd_hjs_vol_bx_knt", getYdHjsVolBxKnt());
        this.hashColumns.put("trstr_knt", getTrstrKnt());
        this.hashColumns.put("frk_knt", getFrkKnt());
        this.hashColumns.put("yd_strdl_crr_knt", getYdStrdlCrrKnt());
        this.hashColumns.put("yd_trct_knt", getYdTrctKnt());
        this.hashColumns.put("yd_top_lft_knt", getYdTopLftKnt());
        this.hashColumns.put("tml_chss_knt", getTmlChssKnt());
        this.hashColumns.put("eir_svc_flg", getEirSvcFlg());
        this.hashColumns.put("tml_prod_knt", getTmlProdKnt());
        this.hashColumns.put("yd_cstms_no", getYdCstmsNo());
        this.hashColumns.put("yd_fcty_tp_psdo_yd_flg", getYdFctyTpPsdoYdFlg());
        this.hashColumns.put("yd_eml", getYdEml());
        this.hashColumns.put("dem_ib_clt_flg", getDemIbCltFlg());
        this.hashColumns.put("dem_ob_clt_flg", getDemObCltFlg());
        this.hashColumns.put("bkg_pod_yd_flg", getBkgPodYdFlg());
        this.hashColumns.put("yd_fcty_tp_brg_rmp_flg", getYdFctyTpBrgRmpFlg());
        this.hashColumns.put("bfr_ofc_cd", getBfrOfcCd());
        this.hashColumns.put("bfr_ofc_cng_dt", getBfrOfcCngDt());
        this.hashColumns.put("modi_yd_cd", getModiYdCd());
        this.hashColumns.put("dmdt_ofc_cd", getDmdtOfcCd());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("delt_flg", getDeltFlg());
        this.hashColumns.put("rep_yd_tp_cd", getRepYdTpCd());
        this.hashColumns.put("dry_avg_dwll_hrs", getDryAvgDwllHrs());
        this.hashColumns.put("dry_min_dwll_hrs", getDryMinDwllHrs());
        this.hashColumns.put("dry_yd_ft_hrs", getDryYdFtHrs());
        this.hashColumns.put("yd_locl_lang_nm", getYdLoclLangNm());
        this.hashColumns.put("yd_locl_lang_addr", getYdLoclLangAddr());
        this.hashColumns.put("cud_flg", getCudFlg());
        this.hashColumns.put("usr_id", getUsrId());
        this.hashColumns.put("yd_cgo_clz_hrmnt_msg", getYdCgoClzHrmntMsg());
        this.hashColumns.put("yd_inrl_flg", getYdInrlFlg());
        this.hashColumns.put("onf_hir_yd_flg", getOnfHirYdFlg());
        this.hashColumns.put("yd_pst_pgc_knt", getYdPstPgcKnt());
        this.hashColumns.put("yd_pgc_knt", getYdPgcKnt());
        this.hashColumns.put("rep_zn_cd", getRepZnCd());
        this.hashColumns.put("rf_avg_dwll_hrs", getRfAvgDwllHrs());
        this.hashColumns.put("rf_min_dwll_hrs", getRfMinDwllHrs());
        this.hashColumns.put("rf_yd_ft_hrs", getRfYdFtHrs());
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
        this.hashFields.put("yd_cd", "ydCd");
        this.hashFields.put("yd_nm", "ydNm");
        this.hashFields.put("loc_cd", "locCd");
        this.hashFields.put("n1st_vndr_cnt_cd", "n1stVndrCntCd");
        this.hashFields.put("n1st_vndr_seq", "n1stVndrSeq");
        this.hashFields.put("n2nd_vndr_cnt_cd", "n2ndVndrCntCd");
        this.hashFields.put("n2nd_vndr_seq", "n2ndVndrSeq");
        this.hashFields.put("n3rd_vndr_cnt_cd", "n3rdVndrCntCd");
        this.hashFields.put("n3rd_vndr_seq", "n3rdVndrSeq");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("hub_yd_flg", "hubYdFlg");
        this.hashFields.put("yd_chr_cd", "ydChrCd");
        this.hashFields.put("yd_fcty_tp_mrn_tml_flg", "ydFctyTpMrnTmlFlg");
        this.hashFields.put("yd_fcty_tp_cy_flg", "ydFctyTpCyFlg");
        this.hashFields.put("yd_fcty_tp_cfs_flg", "ydFctyTpCfsFlg");
        this.hashFields.put("yd_fcty_tp_rail_rmp_flg", "ydFctyTpRailRmpFlg");
        this.hashFields.put("yd_oshp_cd", "ydOshpCd");
        this.hashFields.put("bd_yd_flg", "bdYdFlg");
        this.hashFields.put("yd_addr", "ydAddr");
        this.hashFields.put("zip_cd", "zipCd");
        this.hashFields.put("intl_phn_no", "intlPhnNo");
        this.hashFields.put("phn_no", "phnNo");
        this.hashFields.put("fax_no", "faxNo");
        this.hashFields.put("yd_pic_nm", "ydPicNm");
        this.hashFields.put("yd_ceo_nm", "ydCeoNm");
        this.hashFields.put("gate_opn_hrmnt", "gateOpnHrmnt");
        this.hashFields.put("gate_clz_hrmnt", "gateClzHrmnt");
        this.hashFields.put("hol_gate_opn_hrmnt", "holGateOpnHrmnt");
        this.hashFields.put("hol_gate_clz_hrmnt", "holGateClzHrmnt");
        this.hashFields.put("sun_gate_opn_hrmnt", "sunGateOpnHrmnt");
        this.hashFields.put("sun_gate_clz_hrmnt", "sunGateClzHrmnt");
        this.hashFields.put("sat_gate_opn_hrmnt", "satGateOpnHrmnt");
        this.hashFields.put("sat_gate_clz_hrmnt", "satGateClzHrmnt");
        this.hashFields.put("yd_rmk", "ydRmk");
        this.hashFields.put("brth_no", "brthNo");
        this.hashFields.put("yd_brth_len", "ydBrthLen");
        this.hashFields.put("yd_brth_alng_sd_desc", "ydBrthAlngSdDesc");
        this.hashFields.put("yd_brth_dpth_chnl_knt", "ydBrthDpthChnlKnt");
        this.hashFields.put("yd_ttl_spc", "ydTtlSpc");
        this.hashFields.put("yd_act_spc", "ydActSpc");
        this.hashFields.put("yd_hjs_spc", "ydHjsSpc");
        this.hashFields.put("yd_hndl_capa", "ydHndlCapa");
        this.hashFields.put("yd_rf_rcpt_440v_knt", "ydRfRcpt440VKnt");
        this.hashFields.put("yd_rf_rcpt_220v_knt", "ydRfRcpt220VKnt");
        this.hashFields.put("yd_rf_rcpt_dul_knt", "ydRfRcptDulKnt");
        this.hashFields.put("yd_op_sys_cd", "ydOpSysCd");
        this.hashFields.put("yd_cfs_spc", "ydCfsSpc");
        this.hashFields.put("mnr_shop_flg", "mnrShopFlg");
        this.hashFields.put("yd_hndl_yr", "ydHndlYr");
        this.hashFields.put("yd_ttl_vol_teu_knt", "ydTtlVolTeuKnt");
        this.hashFields.put("yd_ttl_vol_bx_knt", "ydTtlVolBxKnt");
        this.hashFields.put("yd_hjs_vol_teu_knt", "ydHjsVolTeuKnt");
        this.hashFields.put("yd_hjs_vol_bx_knt", "ydHjsVolBxKnt");
        this.hashFields.put("trstr_knt", "trstrKnt");
        this.hashFields.put("frk_knt", "frkKnt");
        this.hashFields.put("yd_strdl_crr_knt", "ydStrdlCrrKnt");
        this.hashFields.put("yd_trct_knt", "ydTrctKnt");
        this.hashFields.put("yd_top_lft_knt", "ydTopLftKnt");
        this.hashFields.put("tml_chss_knt", "tmlChssKnt");
        this.hashFields.put("eir_svc_flg", "eirSvcFlg");
        this.hashFields.put("tml_prod_knt", "tmlProdKnt");
        this.hashFields.put("yd_cstms_no", "ydCstmsNo");
        this.hashFields.put("yd_fcty_tp_psdo_yd_flg", "ydFctyTpPsdoYdFlg");
        this.hashFields.put("yd_eml", "ydEml");
        this.hashFields.put("dem_ib_clt_flg", "demIbCltFlg");
        this.hashFields.put("dem_ob_clt_flg", "demObCltFlg");
        this.hashFields.put("bkg_pod_yd_flg", "bkgPodYdFlg");
        this.hashFields.put("yd_fcty_tp_brg_rmp_flg", "ydFctyTpBrgRmpFlg");
        this.hashFields.put("bfr_ofc_cd", "bfrOfcCd");
        this.hashFields.put("bfr_ofc_cng_dt", "bfrOfcCngDt");
        this.hashFields.put("modi_yd_cd", "modiYdCd");
        this.hashFields.put("dmdt_ofc_cd", "dmdtOfcCd");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("delt_flg", "deltFlg");
        this.hashFields.put("rep_yd_tp_cd", "repYdTpCd");
        this.hashFields.put("dry_avg_dwll_hrs", "dryAvgDwllHrs");
        this.hashFields.put("dry_min_dwll_hrs", "dryMinDwllHrs");
        this.hashFields.put("dry_yd_ft_hrs", "dryYdFtHrs");
        this.hashFields.put("yd_locl_lang_nm", "ydLoclLangNm");
        this.hashFields.put("yd_locl_lang_addr", "ydLoclLangAddr");
        this.hashFields.put("cud_flg", "cudFlg");
        this.hashFields.put("usr_id", "usrId");
        this.hashFields.put("yd_cgo_clz_hrmnt_msg", "ydCgoClzHrmntMsg");
        this.hashFields.put("yd_inrl_flg", "ydInrlFlg");
        this.hashFields.put("onf_hir_yd_flg", "onfHirYdFlg");
        this.hashFields.put("yd_pst_pgc_knt", "ydPstPgcKnt");
        this.hashFields.put("yd_pgc_knt", "ydPgcKnt");
        this.hashFields.put("rep_zn_cd", "repZnCd");
        this.hashFields.put("rf_avg_dwll_hrs", "rfAvgDwllHrs");
        this.hashFields.put("rf_min_dwll_hrs", "rfMinDwllHrs");
        this.hashFields.put("rf_yd_ft_hrs", "rfYdFtHrs");
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

    public void setYdCd(String ydCd) {
        this.ydCd = ydCd;
    }

    public String getYdCd() {
        return this.ydCd;
    }

    public void setYdNm(String ydNm) {
        this.ydNm = ydNm;
    }

    public String getYdNm() {
        return this.ydNm;
    }

    public void setLocCd(String locCd) {
        this.locCd = locCd;
    }

    public String getLocCd() {
        return this.locCd;
    }

    public void setN1stVndrCntCd(String n1stVndrCntCd) {
        this.n1stVndrCntCd = n1stVndrCntCd;
    }

    public String getN1stVndrCntCd() {
        return this.n1stVndrCntCd;
    }

    public void setN1stVndrSeq(String n1stVndrSeq) {
        this.n1stVndrSeq = n1stVndrSeq;
    }

    public String getN1stVndrSeq() {
        return this.n1stVndrSeq;
    }

    public void setN2ndVndrCntCd(String n2ndVndrCntCd) {
        this.n2ndVndrCntCd = n2ndVndrCntCd;
    }

    public String getN2ndVndrCntCd() {
        return this.n2ndVndrCntCd;
    }

    public void setN2ndVndrSeq(String n2ndVndrSeq) {
        this.n2ndVndrSeq = n2ndVndrSeq;
    }

    public String getN2ndVndrSeq() {
        return this.n2ndVndrSeq;
    }

    public void setN3rdVndrCntCd(String n3rdVndrCntCd) {
        this.n3rdVndrCntCd = n3rdVndrCntCd;
    }

    public String getN3rdVndrCntCd() {
        return this.n3rdVndrCntCd;
    }

    public void setN3rdVndrSeq(String n3rdVndrSeq) {
        this.n3rdVndrSeq = n3rdVndrSeq;
    }

    public String getN3rdVndrSeq() {
        return this.n3rdVndrSeq;
    }

    public void setOfcCd(String ofcCd) {
        this.ofcCd = ofcCd;
    }

    public String getOfcCd() {
        return this.ofcCd;
    }

    public void setHubYdFlg(String hubYdFlg) {
        this.hubYdFlg = hubYdFlg;
    }

    public String getHubYdFlg() {
        return this.hubYdFlg;
    }

    public void setYdChrCd(String ydChrCd) {
        this.ydChrCd = ydChrCd;
    }

    public String getYdChrCd() {
        return this.ydChrCd;
    }

    public void setYdFctyTpMrnTmlFlg(String ydFctyTpMrnTmlFlg) {
        this.ydFctyTpMrnTmlFlg = ydFctyTpMrnTmlFlg;
    }

    public String getYdFctyTpMrnTmlFlg() {
        return this.ydFctyTpMrnTmlFlg;
    }

    public void setYdFctyTpCyFlg(String ydFctyTpCyFlg) {
        this.ydFctyTpCyFlg = ydFctyTpCyFlg;
    }

    public String getYdFctyTpCyFlg() {
        return this.ydFctyTpCyFlg;
    }

    public void setYdFctyTpCfsFlg(String ydFctyTpCfsFlg) {
        this.ydFctyTpCfsFlg = ydFctyTpCfsFlg;
    }

    public String getYdFctyTpCfsFlg() {
        return this.ydFctyTpCfsFlg;
    }

    public void setYdFctyTpRailRmpFlg(String ydFctyTpRailRmpFlg) {
        this.ydFctyTpRailRmpFlg = ydFctyTpRailRmpFlg;
    }

    public String getYdFctyTpRailRmpFlg() {
        return this.ydFctyTpRailRmpFlg;
    }

    public void setYdOshpCd(String ydOshpCd) {
        this.ydOshpCd = ydOshpCd;
    }

    public String getYdOshpCd() {
        return this.ydOshpCd;
    }

    public void setBdYdFlg(String bdYdFlg) {
        this.bdYdFlg = bdYdFlg;
    }

    public String getBdYdFlg() {
        return this.bdYdFlg;
    }

    public void setYdAddr(String ydAddr) {
        this.ydAddr = ydAddr;
    }

    public String getYdAddr() {
        return this.ydAddr;
    }

    public void setZipCd(String zipCd) {
        this.zipCd = zipCd;
    }

    public String getZipCd() {
        return this.zipCd;
    }

    public void setIntlPhnNo(String intlPhnNo) {
        this.intlPhnNo = intlPhnNo;
    }

    public String getIntlPhnNo() {
        return this.intlPhnNo;
    }

    public void setPhnNo(String phnNo) {
        this.phnNo = phnNo;
    }

    public String getPhnNo() {
        return this.phnNo;
    }

    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }

    public String getFaxNo() {
        return this.faxNo;
    }

    public void setYdPicNm(String ydPicNm) {
        this.ydPicNm = ydPicNm;
    }

    public String getYdPicNm() {
        return this.ydPicNm;
    }

    public void setYdCeoNm(String ydCeoNm) {
        this.ydCeoNm = ydCeoNm;
    }

    public String getYdCeoNm() {
        return this.ydCeoNm;
    }

    public void setGateOpnHrmnt(String gateOpnHrmnt) {
        this.gateOpnHrmnt = gateOpnHrmnt;
    }

    public String getGateOpnHrmnt() {
        return this.gateOpnHrmnt;
    }

    public void setGateClzHrmnt(String gateClzHrmnt) {
        this.gateClzHrmnt = gateClzHrmnt;
    }

    public String getGateClzHrmnt() {
        return this.gateClzHrmnt;
    }

    public void setHolGateOpnHrmnt(String holGateOpnHrmnt) {
        this.holGateOpnHrmnt = holGateOpnHrmnt;
    }

    public String getHolGateOpnHrmnt() {
        return this.holGateOpnHrmnt;
    }

    public void setHolGateClzHrmnt(String holGateClzHrmnt) {
        this.holGateClzHrmnt = holGateClzHrmnt;
    }

    public String getHolGateClzHrmnt() {
        return this.holGateClzHrmnt;
    }

    public void setSunGateOpnHrmnt(String sunGateOpnHrmnt) {
        this.sunGateOpnHrmnt = sunGateOpnHrmnt;
    }

    public String getSunGateOpnHrmnt() {
        return this.sunGateOpnHrmnt;
    }

    public void setSunGateClzHrmnt(String sunGateClzHrmnt) {
        this.sunGateClzHrmnt = sunGateClzHrmnt;
    }

    public String getSunGateClzHrmnt() {
        return this.sunGateClzHrmnt;
    }

    public void setSatGateOpnHrmnt(String satGateOpnHrmnt) {
        this.satGateOpnHrmnt = satGateOpnHrmnt;
    }

    public String getSatGateOpnHrmnt() {
        return this.satGateOpnHrmnt;
    }

    public void setSatGateClzHrmnt(String satGateClzHrmnt) {
        this.satGateClzHrmnt = satGateClzHrmnt;
    }

    public String getSatGateClzHrmnt() {
        return this.satGateClzHrmnt;
    }

    public void setYdRmk(String ydRmk) {
        this.ydRmk = ydRmk;
    }

    public String getYdRmk() {
        return this.ydRmk;
    }

    public void setBrthNo(String brthNo) {
        this.brthNo = brthNo;
    }

    public String getBrthNo() {
        return this.brthNo;
    }

    public void setYdBrthLen(String ydBrthLen) {
        this.ydBrthLen = ydBrthLen;
    }

    public String getYdBrthLen() {
        return this.ydBrthLen;
    }

    public void setYdBrthAlngSdDesc(String ydBrthAlngSdDesc) {
        this.ydBrthAlngSdDesc = ydBrthAlngSdDesc;
    }

    public String getYdBrthAlngSdDesc() {
        return this.ydBrthAlngSdDesc;
    }

    public void setYdBrthDpthChnlKnt(String ydBrthDpthChnlKnt) {
        this.ydBrthDpthChnlKnt = ydBrthDpthChnlKnt;
    }

    public String getYdBrthDpthChnlKnt() {
        return this.ydBrthDpthChnlKnt;
    }

    public void setYdTtlSpc(String ydTtlSpc) {
        this.ydTtlSpc = ydTtlSpc;
    }

    public String getYdTtlSpc() {
        return this.ydTtlSpc;
    }

    public void setYdActSpc(String ydActSpc) {
        this.ydActSpc = ydActSpc;
    }

    public String getYdActSpc() {
        return this.ydActSpc;
    }

    public void setYdHjsSpc(String ydHjsSpc) {
        this.ydHjsSpc = ydHjsSpc;
    }

    public String getYdHjsSpc() {
        return this.ydHjsSpc;
    }

    public void setYdHndlCapa(String ydHndlCapa) {
        this.ydHndlCapa = ydHndlCapa;
    }

    public String getYdHndlCapa() {
        return this.ydHndlCapa;
    }

    public void setYdRfRcpt440VKnt(String ydRfRcpt440VKnt) {
        this.ydRfRcpt440VKnt = ydRfRcpt440VKnt;
    }

    public String getYdRfRcpt440VKnt() {
        return this.ydRfRcpt440VKnt;
    }

    public void setYdRfRcpt220VKnt(String ydRfRcpt220VKnt) {
        this.ydRfRcpt220VKnt = ydRfRcpt220VKnt;
    }

    public String getYdRfRcpt220VKnt() {
        return this.ydRfRcpt220VKnt;
    }

    public void setYdRfRcptDulKnt(String ydRfRcptDulKnt) {
        this.ydRfRcptDulKnt = ydRfRcptDulKnt;
    }

    public String getYdRfRcptDulKnt() {
        return this.ydRfRcptDulKnt;
    }

    public void setYdOpSysCd(String ydOpSysCd) {
        this.ydOpSysCd = ydOpSysCd;
    }

    public String getYdOpSysCd() {
        return this.ydOpSysCd;
    }

    public void setYdCfsSpc(String ydCfsSpc) {
        this.ydCfsSpc = ydCfsSpc;
    }

    public String getYdCfsSpc() {
        return this.ydCfsSpc;
    }

    public void setMnrShopFlg(String mnrShopFlg) {
        this.mnrShopFlg = mnrShopFlg;
    }

    public String getMnrShopFlg() {
        return this.mnrShopFlg;
    }

    public void setYdHndlYr(String ydHndlYr) {
        this.ydHndlYr = ydHndlYr;
    }

    public String getYdHndlYr() {
        return this.ydHndlYr;
    }

    public void setYdTtlVolTeuKnt(String ydTtlVolTeuKnt) {
        this.ydTtlVolTeuKnt = ydTtlVolTeuKnt;
    }

    public String getYdTtlVolTeuKnt() {
        return this.ydTtlVolTeuKnt;
    }

    public void setYdTtlVolBxKnt(String ydTtlVolBxKnt) {
        this.ydTtlVolBxKnt = ydTtlVolBxKnt;
    }

    public String getYdTtlVolBxKnt() {
        return this.ydTtlVolBxKnt;
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

    public void setTrstrKnt(String trstrKnt) {
        this.trstrKnt = trstrKnt;
    }

    public String getTrstrKnt() {
        return this.trstrKnt;
    }

    public void setFrkKnt(String frkKnt) {
        this.frkKnt = frkKnt;
    }

    public String getFrkKnt() {
        return this.frkKnt;
    }

    public void setYdStrdlCrrKnt(String ydStrdlCrrKnt) {
        this.ydStrdlCrrKnt = ydStrdlCrrKnt;
    }

    public String getYdStrdlCrrKnt() {
        return this.ydStrdlCrrKnt;
    }

    public void setYdTrctKnt(String ydTrctKnt) {
        this.ydTrctKnt = ydTrctKnt;
    }

    public String getYdTrctKnt() {
        return this.ydTrctKnt;
    }

    public void setYdTopLftKnt(String ydTopLftKnt) {
        this.ydTopLftKnt = ydTopLftKnt;
    }

    public String getYdTopLftKnt() {
        return this.ydTopLftKnt;
    }

    public void setTmlChssKnt(String tmlChssKnt) {
        this.tmlChssKnt = tmlChssKnt;
    }

    public String getTmlChssKnt() {
        return this.tmlChssKnt;
    }

    public void setEirSvcFlg(String eirSvcFlg) {
        this.eirSvcFlg = eirSvcFlg;
    }

    public String getEirSvcFlg() {
        return this.eirSvcFlg;
    }

    public void setTmlProdKnt(String tmlProdKnt) {
        this.tmlProdKnt = tmlProdKnt;
    }

    public String getTmlProdKnt() {
        return this.tmlProdKnt;
    }

    public void setYdCstmsNo(String ydCstmsNo) {
        this.ydCstmsNo = ydCstmsNo;
    }

    public String getYdCstmsNo() {
        return this.ydCstmsNo;
    }

    public void setYdFctyTpPsdoYdFlg(String ydFctyTpPsdoYdFlg) {
        this.ydFctyTpPsdoYdFlg = ydFctyTpPsdoYdFlg;
    }

    public String getYdFctyTpPsdoYdFlg() {
        return this.ydFctyTpPsdoYdFlg;
    }

    public void setYdEml(String ydEml) {
        this.ydEml = ydEml;
    }

    public String getYdEml() {
        return this.ydEml;
    }

    public void setDemIbCltFlg(String demIbCltFlg) {
        this.demIbCltFlg = demIbCltFlg;
    }

    public String getDemIbCltFlg() {
        return this.demIbCltFlg;
    }

    public void setDemObCltFlg(String demObCltFlg) {
        this.demObCltFlg = demObCltFlg;
    }

    public String getDemObCltFlg() {
        return this.demObCltFlg;
    }

    public void setBkgPodYdFlg(String bkgPodYdFlg) {
        this.bkgPodYdFlg = bkgPodYdFlg;
    }

    public String getBkgPodYdFlg() {
        return this.bkgPodYdFlg;
    }

    public void setYdFctyTpBrgRmpFlg(String ydFctyTpBrgRmpFlg) {
        this.ydFctyTpBrgRmpFlg = ydFctyTpBrgRmpFlg;
    }

    public String getYdFctyTpBrgRmpFlg() {
        return this.ydFctyTpBrgRmpFlg;
    }

    public void setBfrOfcCd(String bfrOfcCd) {
        this.bfrOfcCd = bfrOfcCd;
    }

    public String getBfrOfcCd() {
        return this.bfrOfcCd;
    }

    public void setBfrOfcCngDt(String bfrOfcCngDt) {
        this.bfrOfcCngDt = bfrOfcCngDt;
    }

    public String getBfrOfcCngDt() {
        return this.bfrOfcCngDt;
    }

    public void setModiYdCd(String modiYdCd) {
        this.modiYdCd = modiYdCd;
    }

    public String getModiYdCd() {
        return this.modiYdCd;
    }

    public void setDmdtOfcCd(String dmdtOfcCd) {
        this.dmdtOfcCd = dmdtOfcCd;
    }

    public String getDmdtOfcCd() {
        return this.dmdtOfcCd;
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

    public void setRepYdTpCd(String repYdTpCd) {
        this.repYdTpCd = repYdTpCd;
    }

    public String getRepYdTpCd() {
        return this.repYdTpCd;
    }

    public void setDryAvgDwllHrs(String dryAvgDwllHrs) {
        this.dryAvgDwllHrs = dryAvgDwllHrs;
    }

    public String getDryAvgDwllHrs() {
        return this.dryAvgDwllHrs;
    }

    public void setDryMinDwllHrs(String dryMinDwllHrs) {
        this.dryMinDwllHrs = dryMinDwllHrs;
    }

    public String getDryMinDwllHrs() {
        return this.dryMinDwllHrs;
    }

    public void setDryYdFtHrs(String dryYdFtHrs) {
        this.dryYdFtHrs = dryYdFtHrs;
    }

    public String getDryYdFtHrs() {
        return this.dryYdFtHrs;
    }

    public void setYdLoclLangNm(String ydLoclLangNm) {
        this.ydLoclLangNm = ydLoclLangNm;
    }

    public String getYdLoclLangNm() {
        return this.ydLoclLangNm;
    }

    public void setYdLoclLangAddr(String ydLoclLangAddr) {
        this.ydLoclLangAddr = ydLoclLangAddr;
    }

    public String getYdLoclLangAddr() {
        return this.ydLoclLangAddr;
    }

    public void setCudFlg(String cudFlg) {
        this.cudFlg = cudFlg;
    }

    public String getCudFlg() {
        return this.cudFlg;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    public String getUsrId() {
        return this.usrId;
    }

    public void setYdCgoClzHrmntMsg(String ydCgoClzHrmntMsg) {
        this.ydCgoClzHrmntMsg = ydCgoClzHrmntMsg;
    }

    public String getYdCgoClzHrmntMsg() {
        return this.ydCgoClzHrmntMsg;
    }

    public void setYdInrlFlg(String ydInrlFlg) {
        this.ydInrlFlg = ydInrlFlg;
    }

    public String getYdInrlFlg() {
        return this.ydInrlFlg;
    }

    public void setOnfHirYdFlg(String onfHirYdFlg) {
        this.onfHirYdFlg = onfHirYdFlg;
    }

    public String getOnfHirYdFlg() {
        return this.onfHirYdFlg;
    }

    public void setYdPstPgcKnt(String ydPstPgcKnt) {
        this.ydPstPgcKnt = ydPstPgcKnt;
    }

    public String getYdPstPgcKnt() {
        return this.ydPstPgcKnt;
    }

    public void setYdPgcKnt(String ydPgcKnt) {
        this.ydPgcKnt = ydPgcKnt;
    }

    public String getYdPgcKnt() {
        return this.ydPgcKnt;
    }

    public void setRepZnCd(String repZnCd) {
        this.repZnCd = repZnCd;
    }

    public String getRepZnCd() {
        return this.repZnCd;
    }

    public void setRfAvgDwllHrs(String rfAvgDwllHrs) {
        this.rfAvgDwllHrs = rfAvgDwllHrs;
    }

    public String getRfAvgDwllHrs() {
        return this.rfAvgDwllHrs;
    }

    public void setRfMinDwllHrs(String rfMinDwllHrs) {
        this.rfMinDwllHrs = rfMinDwllHrs;
    }

    public String getRfMinDwllHrs() {
        return this.rfMinDwllHrs;
    }

    public void setRfYdFtHrs(String rfYdFtHrs) {
        this.rfYdFtHrs = rfYdFtHrs;
    }

    public String getRfYdFtHrs() {
        return this.rfYdFtHrs;
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
        setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
        setYdNm(JSPUtil.getParameter(request, prefix + "yd_nm", ""));
        setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
        setN1stVndrCntCd(JSPUtil.getParameter(request, prefix + "n1st_vndr_cnt_cd", ""));
        setN1stVndrSeq(JSPUtil.getParameter(request, prefix + "n1st_vndr_seq", ""));
        setN2ndVndrCntCd(JSPUtil.getParameter(request, prefix + "n2nd_vndr_cnt_cd", ""));
        setN2ndVndrSeq(JSPUtil.getParameter(request, prefix + "n2nd_vndr_seq", ""));
        setN3rdVndrCntCd(JSPUtil.getParameter(request, prefix + "n3rd_vndr_cnt_cd", ""));
        setN3rdVndrSeq(JSPUtil.getParameter(request, prefix + "n3rd_vndr_seq", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setHubYdFlg(JSPUtil.getParameter(request, prefix + "hub_yd_flg", ""));
        setYdChrCd(JSPUtil.getParameter(request, prefix + "yd_chr_cd", ""));
        setYdFctyTpMrnTmlFlg(JSPUtil.getParameter(request, prefix + "yd_fcty_tp_mrn_tml_flg", ""));
        setYdFctyTpCyFlg(JSPUtil.getParameter(request, prefix + "yd_fcty_tp_cy_flg", ""));
        setYdFctyTpCfsFlg(JSPUtil.getParameter(request, prefix + "yd_fcty_tp_cfs_flg", ""));
        setYdFctyTpRailRmpFlg(JSPUtil.getParameter(request, prefix + "yd_fcty_tp_rail_rmp_flg", ""));
        setYdOshpCd(JSPUtil.getParameter(request, prefix + "yd_oshp_cd", ""));
        setBdYdFlg(JSPUtil.getParameter(request, prefix + "bd_yd_flg", ""));
        setYdAddr(JSPUtil.getParameter(request, prefix + "yd_addr", ""));
        setZipCd(JSPUtil.getParameter(request, prefix + "zip_cd", ""));
        setIntlPhnNo(JSPUtil.getParameter(request, prefix + "intl_phn_no", ""));
        setPhnNo(JSPUtil.getParameter(request, prefix + "phn_no", ""));
        setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
        setYdPicNm(JSPUtil.getParameter(request, prefix + "yd_pic_nm", ""));
        setYdCeoNm(JSPUtil.getParameter(request, prefix + "yd_ceo_nm", ""));
        setGateOpnHrmnt(JSPUtil.getParameter(request, prefix + "gate_opn_hrmnt", ""));
        setGateClzHrmnt(JSPUtil.getParameter(request, prefix + "gate_clz_hrmnt", ""));
        setHolGateOpnHrmnt(JSPUtil.getParameter(request, prefix + "hol_gate_opn_hrmnt", ""));
        setHolGateClzHrmnt(JSPUtil.getParameter(request, prefix + "hol_gate_clz_hrmnt", ""));
        setSunGateOpnHrmnt(JSPUtil.getParameter(request, prefix + "sun_gate_opn_hrmnt", ""));
        setSunGateClzHrmnt(JSPUtil.getParameter(request, prefix + "sun_gate_clz_hrmnt", ""));
        setSatGateOpnHrmnt(JSPUtil.getParameter(request, prefix + "sat_gate_opn_hrmnt", ""));
        setSatGateClzHrmnt(JSPUtil.getParameter(request, prefix + "sat_gate_clz_hrmnt", ""));
        setYdRmk(JSPUtil.getParameter(request, prefix + "yd_rmk", ""));
        setBrthNo(JSPUtil.getParameter(request, prefix + "brth_no", ""));
        setYdBrthLen(JSPUtil.getParameter(request, prefix + "yd_brth_len", ""));
        setYdBrthAlngSdDesc(JSPUtil.getParameter(request, prefix + "yd_brth_alng_sd_desc", ""));
        setYdBrthDpthChnlKnt(JSPUtil.getParameter(request, prefix + "yd_brth_dpth_chnl_knt", ""));
        setYdTtlSpc(JSPUtil.getParameter(request, prefix + "yd_ttl_spc", ""));
        setYdActSpc(JSPUtil.getParameter(request, prefix + "yd_act_spc", ""));
        setYdHjsSpc(JSPUtil.getParameter(request, prefix + "yd_hjs_spc", ""));
        setYdHndlCapa(JSPUtil.getParameter(request, prefix + "yd_hndl_capa", ""));
        setYdRfRcpt440VKnt(JSPUtil.getParameter(request, prefix + "yd_rf_rcpt_440v_knt", ""));
        setYdRfRcpt220VKnt(JSPUtil.getParameter(request, prefix + "yd_rf_rcpt_220v_knt", ""));
        setYdRfRcptDulKnt(JSPUtil.getParameter(request, prefix + "yd_rf_rcpt_dul_knt", ""));
        setYdOpSysCd(JSPUtil.getParameter(request, prefix + "yd_op_sys_cd", ""));
        setYdCfsSpc(JSPUtil.getParameter(request, prefix + "yd_cfs_spc", ""));
        setMnrShopFlg(JSPUtil.getParameter(request, prefix + "mnr_shop_flg", ""));
        setYdHndlYr(JSPUtil.getParameter(request, prefix + "yd_hndl_yr", ""));
        setYdTtlVolTeuKnt(JSPUtil.getParameter(request, prefix + "yd_ttl_vol_teu_knt", ""));
        setYdTtlVolBxKnt(JSPUtil.getParameter(request, prefix + "yd_ttl_vol_bx_knt", ""));
        setYdHjsVolTeuKnt(JSPUtil.getParameter(request, prefix + "yd_hjs_vol_teu_knt", ""));
        setYdHjsVolBxKnt(JSPUtil.getParameter(request, prefix + "yd_hjs_vol_bx_knt", ""));
        setTrstrKnt(JSPUtil.getParameter(request, prefix + "trstr_knt", ""));
        setFrkKnt(JSPUtil.getParameter(request, prefix + "frk_knt", ""));
        setYdStrdlCrrKnt(JSPUtil.getParameter(request, prefix + "yd_strdl_crr_knt", ""));
        setYdTrctKnt(JSPUtil.getParameter(request, prefix + "yd_trct_knt", ""));
        setYdTopLftKnt(JSPUtil.getParameter(request, prefix + "yd_top_lft_knt", ""));
        setTmlChssKnt(JSPUtil.getParameter(request, prefix + "tml_chss_knt", ""));
        setEirSvcFlg(JSPUtil.getParameter(request, prefix + "eir_svc_flg", ""));
        setTmlProdKnt(JSPUtil.getParameter(request, prefix + "tml_prod_knt", ""));
        setYdCstmsNo(JSPUtil.getParameter(request, prefix + "yd_cstms_no", ""));
        setYdFctyTpPsdoYdFlg(JSPUtil.getParameter(request, prefix + "yd_fcty_tp_psdo_yd_flg", ""));
        setYdEml(JSPUtil.getParameter(request, prefix + "yd_eml", ""));
        setDemIbCltFlg(JSPUtil.getParameter(request, prefix + "dem_ib_clt_flg", ""));
        setDemObCltFlg(JSPUtil.getParameter(request, prefix + "dem_ob_clt_flg", ""));
        setBkgPodYdFlg(JSPUtil.getParameter(request, prefix + "bkg_pod_yd_flg", ""));
        setYdFctyTpBrgRmpFlg(JSPUtil.getParameter(request, prefix + "yd_fcty_tp_brg_rmp_flg", ""));
        setBfrOfcCd(JSPUtil.getParameter(request, prefix + "bfr_ofc_cd", ""));
        setBfrOfcCngDt(JSPUtil.getParameter(request, prefix + "bfr_ofc_cng_dt", ""));
        setModiYdCd(JSPUtil.getParameter(request, prefix + "modi_yd_cd", ""));
        setDmdtOfcCd(JSPUtil.getParameter(request, prefix + "dmdt_ofc_cd", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
        setRepYdTpCd(JSPUtil.getParameter(request, prefix + "rep_yd_tp_cd", ""));
        setDryAvgDwllHrs(JSPUtil.getParameter(request, prefix + "dry_avg_dwll_hrs", ""));
        setDryMinDwllHrs(JSPUtil.getParameter(request, prefix + "dry_min_dwll_hrs", ""));
        setDryYdFtHrs(JSPUtil.getParameter(request, prefix + "dry_yd_ft_hrs", ""));
        setYdLoclLangNm(JSPUtil.getParameter(request, prefix + "yd_locl_lang_nm", ""));
        setYdLoclLangAddr(JSPUtil.getParameter(request, prefix + "yd_locl_lang_addr", ""));
        setCudFlg(JSPUtil.getParameter(request, prefix + "cud_flg", ""));
        setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
        setYdCgoClzHrmntMsg(JSPUtil.getParameter(request, prefix + "yd_cgo_clz_hrmnt_msg", ""));
        setYdInrlFlg(JSPUtil.getParameter(request, prefix + "yd_inrl_flg", ""));
        setOnfHirYdFlg(JSPUtil.getParameter(request, prefix + "onf_hir_yd_flg", ""));
        setYdPstPgcKnt(JSPUtil.getParameter(request, prefix + "yd_pst_pgc_knt", ""));
        setYdPgcKnt(JSPUtil.getParameter(request, prefix + "yd_pgc_knt", ""));
        setRepZnCd(JSPUtil.getParameter(request, prefix + "rep_zn_cd", ""));
        setRfAvgDwllHrs(JSPUtil.getParameter(request, prefix + "rf_avg_dwll_hrs", ""));
        setRfMinDwllHrs(JSPUtil.getParameter(request, prefix + "rf_min_dwll_hrs", ""));
        setRfYdFtHrs(JSPUtil.getParameter(request, prefix + "rf_yd_ft_hrs", ""));
        setEaiEvntDt(JSPUtil.getParameter(request, prefix + "eai_evnt_dt", ""));
        setEaiIfId(JSPUtil.getParameter(request, prefix + "eai_if_id", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return YarMaindIfVO[]
	 */
    public YardMainIfVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return YardMainIfVO[]
	 */
    public YardMainIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        YardMainIfVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] ydCd = (JSPUtil.getParameter(request, prefix + "yd_cd", length));
            String[] ydNm = (JSPUtil.getParameter(request, prefix + "yd_nm", length));
            String[] locCd = (JSPUtil.getParameter(request, prefix + "loc_cd", length));
            String[] n1stVndrCntCd = (JSPUtil.getParameter(request, prefix + "n1st_vndr_cnt_cd", length));
            String[] n1stVndrSeq = (JSPUtil.getParameter(request, prefix + "n1st_vndr_seq", length));
            String[] n2ndVndrCntCd = (JSPUtil.getParameter(request, prefix + "n2nd_vndr_cnt_cd", length));
            String[] n2ndVndrSeq = (JSPUtil.getParameter(request, prefix + "n2nd_vndr_seq", length));
            String[] n3rdVndrCntCd = (JSPUtil.getParameter(request, prefix + "n3rd_vndr_cnt_cd", length));
            String[] n3rdVndrSeq = (JSPUtil.getParameter(request, prefix + "n3rd_vndr_seq", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] hubYdFlg = (JSPUtil.getParameter(request, prefix + "hub_yd_flg", length));
            String[] ydChrCd = (JSPUtil.getParameter(request, prefix + "yd_chr_cd", length));
            String[] ydFctyTpMrnTmlFlg = (JSPUtil.getParameter(request, prefix + "yd_fcty_tp_mrn_tml_flg", length));
            String[] ydFctyTpCyFlg = (JSPUtil.getParameter(request, prefix + "yd_fcty_tp_cy_flg", length));
            String[] ydFctyTpCfsFlg = (JSPUtil.getParameter(request, prefix + "yd_fcty_tp_cfs_flg", length));
            String[] ydFctyTpRailRmpFlg = (JSPUtil.getParameter(request, prefix + "yd_fcty_tp_rail_rmp_flg", length));
            String[] ydOshpCd = (JSPUtil.getParameter(request, prefix + "yd_oshp_cd", length));
            String[] bdYdFlg = (JSPUtil.getParameter(request, prefix + "bd_yd_flg", length));
            String[] ydAddr = (JSPUtil.getParameter(request, prefix + "yd_addr", length));
            String[] zipCd = (JSPUtil.getParameter(request, prefix + "zip_cd", length));
            String[] intlPhnNo = (JSPUtil.getParameter(request, prefix + "intl_phn_no", length));
            String[] phnNo = (JSPUtil.getParameter(request, prefix + "phn_no", length));
            String[] faxNo = (JSPUtil.getParameter(request, prefix + "fax_no", length));
            String[] ydPicNm = (JSPUtil.getParameter(request, prefix + "yd_pic_nm", length));
            String[] ydCeoNm = (JSPUtil.getParameter(request, prefix + "yd_ceo_nm", length));
            String[] gateOpnHrmnt = (JSPUtil.getParameter(request, prefix + "gate_opn_hrmnt", length));
            String[] gateClzHrmnt = (JSPUtil.getParameter(request, prefix + "gate_clz_hrmnt", length));
            String[] holGateOpnHrmnt = (JSPUtil.getParameter(request, prefix + "hol_gate_opn_hrmnt", length));
            String[] holGateClzHrmnt = (JSPUtil.getParameter(request, prefix + "hol_gate_clz_hrmnt", length));
            String[] sunGateOpnHrmnt = (JSPUtil.getParameter(request, prefix + "sun_gate_opn_hrmnt", length));
            String[] sunGateClzHrmnt = (JSPUtil.getParameter(request, prefix + "sun_gate_clz_hrmnt", length));
            String[] satGateOpnHrmnt = (JSPUtil.getParameter(request, prefix + "sat_gate_opn_hrmnt", length));
            String[] satGateClzHrmnt = (JSPUtil.getParameter(request, prefix + "sat_gate_clz_hrmnt", length));
            String[] ydRmk = (JSPUtil.getParameter(request, prefix + "yd_rmk", length));
            String[] brthNo = (JSPUtil.getParameter(request, prefix + "brth_no", length));
            String[] ydBrthLen = (JSPUtil.getParameter(request, prefix + "yd_brth_len", length));
            String[] ydBrthAlngSdDesc = (JSPUtil.getParameter(request, prefix + "yd_brth_alng_sd_desc", length));
            String[] ydBrthDpthChnlKnt = (JSPUtil.getParameter(request, prefix + "yd_brth_dpth_chnl_knt", length));
            String[] ydTtlSpc = (JSPUtil.getParameter(request, prefix + "yd_ttl_spc", length));
            String[] ydActSpc = (JSPUtil.getParameter(request, prefix + "yd_act_spc", length));
            String[] ydHjsSpc = (JSPUtil.getParameter(request, prefix + "yd_hjs_spc", length));
            String[] ydHndlCapa = (JSPUtil.getParameter(request, prefix + "yd_hndl_capa", length));
            String[] ydRfRcpt440VKnt = (JSPUtil.getParameter(request, prefix + "yd_rf_rcpt_440v_knt", length));
            String[] ydRfRcpt220VKnt = (JSPUtil.getParameter(request, prefix + "yd_rf_rcpt_220v_knt", length));
            String[] ydRfRcptDulKnt = (JSPUtil.getParameter(request, prefix + "yd_rf_rcpt_dul_knt", length));
            String[] ydOpSysCd = (JSPUtil.getParameter(request, prefix + "yd_op_sys_cd", length));
            String[] ydCfsSpc = (JSPUtil.getParameter(request, prefix + "yd_cfs_spc", length));
            String[] mnrShopFlg = (JSPUtil.getParameter(request, prefix + "mnr_shop_flg", length));
            String[] ydHndlYr = (JSPUtil.getParameter(request, prefix + "yd_hndl_yr", length));
            String[] ydTtlVolTeuKnt = (JSPUtil.getParameter(request, prefix + "yd_ttl_vol_teu_knt", length));
            String[] ydTtlVolBxKnt = (JSPUtil.getParameter(request, prefix + "yd_ttl_vol_bx_knt", length));
            String[] ydHjsVolTeuKnt = (JSPUtil.getParameter(request, prefix + "yd_hjs_vol_teu_knt", length));
            String[] ydHjsVolBxKnt = (JSPUtil.getParameter(request, prefix + "yd_hjs_vol_bx_knt", length));
            String[] trstrKnt = (JSPUtil.getParameter(request, prefix + "trstr_knt", length));
            String[] frkKnt = (JSPUtil.getParameter(request, prefix + "frk_knt", length));
            String[] ydStrdlCrrKnt = (JSPUtil.getParameter(request, prefix + "yd_strdl_crr_knt", length));
            String[] ydTrctKnt = (JSPUtil.getParameter(request, prefix + "yd_trct_knt", length));
            String[] ydTopLftKnt = (JSPUtil.getParameter(request, prefix + "yd_top_lft_knt", length));
            String[] tmlChssKnt = (JSPUtil.getParameter(request, prefix + "tml_chss_knt", length));
            String[] eirSvcFlg = (JSPUtil.getParameter(request, prefix + "eir_svc_flg", length));
            String[] tmlProdKnt = (JSPUtil.getParameter(request, prefix + "tml_prod_knt", length));
            String[] ydCstmsNo = (JSPUtil.getParameter(request, prefix + "yd_cstms_no", length));
            String[] ydFctyTpPsdoYdFlg = (JSPUtil.getParameter(request, prefix + "yd_fcty_tp_psdo_yd_flg", length));
            String[] ydEml = (JSPUtil.getParameter(request, prefix + "yd_eml", length));
            String[] demIbCltFlg = (JSPUtil.getParameter(request, prefix + "dem_ib_clt_flg", length));
            String[] demObCltFlg = (JSPUtil.getParameter(request, prefix + "dem_ob_clt_flg", length));
            String[] bkgPodYdFlg = (JSPUtil.getParameter(request, prefix + "bkg_pod_yd_flg", length));
            String[] ydFctyTpBrgRmpFlg = (JSPUtil.getParameter(request, prefix + "yd_fcty_tp_brg_rmp_flg", length));
            String[] bfrOfcCd = (JSPUtil.getParameter(request, prefix + "bfr_ofc_cd", length));
            String[] bfrOfcCngDt = (JSPUtil.getParameter(request, prefix + "bfr_ofc_cng_dt", length));
            String[] modiYdCd = (JSPUtil.getParameter(request, prefix + "modi_yd_cd", length));
            String[] dmdtOfcCd = (JSPUtil.getParameter(request, prefix + "dmdt_ofc_cd", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
            String[] repYdTpCd = (JSPUtil.getParameter(request, prefix + "rep_yd_tp_cd", length));
            String[] dryAvgDwllHrs = (JSPUtil.getParameter(request, prefix + "dry_avg_dwll_hrs", length));
            String[] dryMinDwllHrs = (JSPUtil.getParameter(request, prefix + "dry_min_dwll_hrs", length));
            String[] dryYdFtHrs = (JSPUtil.getParameter(request, prefix + "dry_yd_ft_hrs", length));
            String[] ydLoclLangNm = (JSPUtil.getParameter(request, prefix + "yd_locl_lang_nm", length));
            String[] ydLoclLangAddr = (JSPUtil.getParameter(request, prefix + "yd_locl_lang_addr", length));
            String[] cudFlg = (JSPUtil.getParameter(request, prefix + "cud_flg", length));
            String[] usrId = (JSPUtil.getParameter(request, prefix + "usr_id", length));
            String[] ydCgoClzHrmntMsg = (JSPUtil.getParameter(request, prefix + "yd_cgo_clz_hrmnt_msg", length));
	    	String[] ydInrlFlg = (JSPUtil.getParameter(request, prefix + "yd_inrl_flg", length));
	    	String[] onfHirYdFlg = (JSPUtil.getParameter(request, prefix + "onf_hir_yd_flg", length));
	    	String[] ydPstPgcKnt = (JSPUtil.getParameter(request, prefix + "yd_pst_pgc_knt", length));
	    	String[] ydPgcKnt = (JSPUtil.getParameter(request, prefix + "yd_pgc_knt", length));
	    	String[] repZnCd = (JSPUtil.getParameter(request, prefix + "rep_zn_cd", length));
	    	String[] rfAvgDwllHrs = (JSPUtil.getParameter(request, prefix + "rf_avg_dwll_hrs", length));
	    	String[] rfMinDwllHrs = (JSPUtil.getParameter(request, prefix + "rf_min_dwll_hrs", length));
	    	String[] rfYdFtHrs = (JSPUtil.getParameter(request, prefix + "rf_yd_ft_hrs", length));
	    	String[] eaiEvntDt = (JSPUtil.getParameter(request, prefix + "eai_evnt_dt", length));
	    	String[] eaiIfId = (JSPUtil.getParameter(request, prefix + "eai_if_id", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new YardMainIfVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ydCd[i] != null)
                    model.setYdCd(ydCd[i]);
                if (ydNm[i] != null)
                    model.setYdNm(ydNm[i]);
                if (locCd[i] != null)
                    model.setLocCd(locCd[i]);
                if (n1stVndrCntCd[i] != null)
                    model.setN1stVndrCntCd(n1stVndrCntCd[i]);
                if (n1stVndrSeq[i] != null)
                    model.setN1stVndrSeq(n1stVndrSeq[i]);
                if (n2ndVndrCntCd[i] != null)
                    model.setN2ndVndrCntCd(n2ndVndrCntCd[i]);
                if (n2ndVndrSeq[i] != null)
                    model.setN2ndVndrSeq(n2ndVndrSeq[i]);
                if (n3rdVndrCntCd[i] != null)
                    model.setN3rdVndrCntCd(n3rdVndrCntCd[i]);
                if (n3rdVndrSeq[i] != null)
                    model.setN3rdVndrSeq(n3rdVndrSeq[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (hubYdFlg[i] != null)
                    model.setHubYdFlg(hubYdFlg[i]);
                if (ydChrCd[i] != null)
                    model.setYdChrCd(ydChrCd[i]);
                if (ydFctyTpMrnTmlFlg[i] != null)
                    model.setYdFctyTpMrnTmlFlg(ydFctyTpMrnTmlFlg[i]);
                if (ydFctyTpCyFlg[i] != null)
                    model.setYdFctyTpCyFlg(ydFctyTpCyFlg[i]);
                if (ydFctyTpCfsFlg[i] != null)
                    model.setYdFctyTpCfsFlg(ydFctyTpCfsFlg[i]);
                if (ydFctyTpRailRmpFlg[i] != null)
                    model.setYdFctyTpRailRmpFlg(ydFctyTpRailRmpFlg[i]);
                if (ydOshpCd[i] != null)
                    model.setYdOshpCd(ydOshpCd[i]);
                if (bdYdFlg[i] != null)
                    model.setBdYdFlg(bdYdFlg[i]);
                if (ydAddr[i] != null)
                    model.setYdAddr(ydAddr[i]);
                if (zipCd[i] != null)
                    model.setZipCd(zipCd[i]);
                if (intlPhnNo[i] != null)
                    model.setIntlPhnNo(intlPhnNo[i]);
                if (phnNo[i] != null)
                    model.setPhnNo(phnNo[i]);
                if (faxNo[i] != null)
                    model.setFaxNo(faxNo[i]);
                if (ydPicNm[i] != null)
                    model.setYdPicNm(ydPicNm[i]);
                if (ydCeoNm[i] != null)
                    model.setYdCeoNm(ydCeoNm[i]);
                if (gateOpnHrmnt[i] != null)
                    model.setGateOpnHrmnt(gateOpnHrmnt[i]);
                if (gateClzHrmnt[i] != null)
                    model.setGateClzHrmnt(gateClzHrmnt[i]);
                if (holGateOpnHrmnt[i] != null)
                    model.setHolGateOpnHrmnt(holGateOpnHrmnt[i]);
                if (holGateClzHrmnt[i] != null)
                    model.setHolGateClzHrmnt(holGateClzHrmnt[i]);
                if (sunGateOpnHrmnt[i] != null)
                    model.setSunGateOpnHrmnt(sunGateOpnHrmnt[i]);
                if (sunGateClzHrmnt[i] != null)
                    model.setSunGateClzHrmnt(sunGateClzHrmnt[i]);
                if (satGateOpnHrmnt[i] != null)
                    model.setSatGateOpnHrmnt(satGateOpnHrmnt[i]);
                if (satGateClzHrmnt[i] != null)
                    model.setSatGateClzHrmnt(satGateClzHrmnt[i]);
                if (ydRmk[i] != null)
                    model.setYdRmk(ydRmk[i]);
                if (brthNo[i] != null)
                    model.setBrthNo(brthNo[i]);
                if (ydBrthLen[i] != null)
                    model.setYdBrthLen(ydBrthLen[i]);
                if (ydBrthAlngSdDesc[i] != null)
                    model.setYdBrthAlngSdDesc(ydBrthAlngSdDesc[i]);
                if (ydBrthDpthChnlKnt[i] != null)
                    model.setYdBrthDpthChnlKnt(ydBrthDpthChnlKnt[i]);
                if (ydTtlSpc[i] != null)
                    model.setYdTtlSpc(ydTtlSpc[i]);
                if (ydActSpc[i] != null)
                    model.setYdActSpc(ydActSpc[i]);
                if (ydHjsSpc[i] != null)
                    model.setYdHjsSpc(ydHjsSpc[i]);
                if (ydHndlCapa[i] != null)
                    model.setYdHndlCapa(ydHndlCapa[i]);
                if (ydRfRcpt440VKnt[i] != null)
                    model.setYdRfRcpt440VKnt(ydRfRcpt440VKnt[i]);
                if (ydRfRcpt220VKnt[i] != null)
                    model.setYdRfRcpt220VKnt(ydRfRcpt220VKnt[i]);
                if (ydRfRcptDulKnt[i] != null)
                    model.setYdRfRcptDulKnt(ydRfRcptDulKnt[i]);
                if (ydOpSysCd[i] != null)
                    model.setYdOpSysCd(ydOpSysCd[i]);
                if (ydCfsSpc[i] != null)
                    model.setYdCfsSpc(ydCfsSpc[i]);
                if (mnrShopFlg[i] != null)
                    model.setMnrShopFlg(mnrShopFlg[i]);
                if (ydHndlYr[i] != null)
                    model.setYdHndlYr(ydHndlYr[i]);
                if (ydTtlVolTeuKnt[i] != null)
                    model.setYdTtlVolTeuKnt(ydTtlVolTeuKnt[i]);
                if (ydTtlVolBxKnt[i] != null)
                    model.setYdTtlVolBxKnt(ydTtlVolBxKnt[i]);
                if (ydHjsVolTeuKnt[i] != null)
                    model.setYdHjsVolTeuKnt(ydHjsVolTeuKnt[i]);
                if (ydHjsVolBxKnt[i] != null)
                    model.setYdHjsVolBxKnt(ydHjsVolBxKnt[i]);
                if (trstrKnt[i] != null)
                    model.setTrstrKnt(trstrKnt[i]);
                if (frkKnt[i] != null)
                    model.setFrkKnt(frkKnt[i]);
                if (ydStrdlCrrKnt[i] != null)
                    model.setYdStrdlCrrKnt(ydStrdlCrrKnt[i]);
                if (ydTrctKnt[i] != null)
                    model.setYdTrctKnt(ydTrctKnt[i]);
                if (ydTopLftKnt[i] != null)
                    model.setYdTopLftKnt(ydTopLftKnt[i]);
                if (tmlChssKnt[i] != null)
                    model.setTmlChssKnt(tmlChssKnt[i]);
                if (eirSvcFlg[i] != null)
                    model.setEirSvcFlg(eirSvcFlg[i]);
                if (tmlProdKnt[i] != null)
                    model.setTmlProdKnt(tmlProdKnt[i]);
                if (ydCstmsNo[i] != null)
                    model.setYdCstmsNo(ydCstmsNo[i]);
                if (ydFctyTpPsdoYdFlg[i] != null)
                    model.setYdFctyTpPsdoYdFlg(ydFctyTpPsdoYdFlg[i]);
                if (ydEml[i] != null)
                    model.setYdEml(ydEml[i]);
                if (demIbCltFlg[i] != null)
                    model.setDemIbCltFlg(demIbCltFlg[i]);
                if (demObCltFlg[i] != null)
                    model.setDemObCltFlg(demObCltFlg[i]);
                if (bkgPodYdFlg[i] != null)
                    model.setBkgPodYdFlg(bkgPodYdFlg[i]);
                if (ydFctyTpBrgRmpFlg[i] != null)
                    model.setYdFctyTpBrgRmpFlg(ydFctyTpBrgRmpFlg[i]);
                if (bfrOfcCd[i] != null)
                    model.setBfrOfcCd(bfrOfcCd[i]);
                if (bfrOfcCngDt[i] != null)
                    model.setBfrOfcCngDt(bfrOfcCngDt[i]);
                if (modiYdCd[i] != null)
                    model.setModiYdCd(modiYdCd[i]);
                if (dmdtOfcCd[i] != null)
                    model.setDmdtOfcCd(dmdtOfcCd[i]);
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
                if (repYdTpCd[i] != null)
                    model.setRepYdTpCd(repYdTpCd[i]);
                if (dryAvgDwllHrs[i] != null)
                    model.setDryAvgDwllHrs(dryAvgDwllHrs[i]);
                if (dryMinDwllHrs[i] != null)
                    model.setDryMinDwllHrs(dryMinDwllHrs[i]);
                if (dryYdFtHrs[i] != null)
                    model.setDryYdFtHrs(dryYdFtHrs[i]);
                if (ydLoclLangNm[i] != null)
                    model.setYdLoclLangNm(ydLoclLangNm[i]);
                if (ydLoclLangAddr[i] != null)
                    model.setYdLoclLangAddr(ydLoclLangAddr[i]);
                if (cudFlg[i] != null)
                    model.setCudFlg(cudFlg[i]);
                if (usrId[i] != null)
                    model.setUsrId(usrId[i]);
                if (ydCgoClzHrmntMsg[i] != null) 
		    		model.setYdCgoClzHrmntMsg(ydCgoClzHrmntMsg[i]);
				if (ydInrlFlg[i] != null) 
		    		model.setYdInrlFlg(ydInrlFlg[i]);
				if (onfHirYdFlg[i] != null) 
		    		model.setOnfHirYdFlg(onfHirYdFlg[i]);
				if (ydPstPgcKnt[i] != null) 
		    		model.setYdPstPgcKnt(ydPstPgcKnt[i]);
				if (ydPgcKnt[i] != null) 
		    		model.setYdPgcKnt(ydPgcKnt[i]);
				if (repZnCd[i] != null) 
		    		model.setRepZnCd(repZnCd[i]);
				if (rfAvgDwllHrs[i] != null) 
		    		model.setRfAvgDwllHrs(rfAvgDwllHrs[i]);
				if (rfMinDwllHrs[i] != null) 
		    		model.setRfMinDwllHrs(rfMinDwllHrs[i]);
				if (rfYdFtHrs[i] != null) 
		    		model.setRfYdFtHrs(rfYdFtHrs[i]);
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
        return getYardMainIfVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return YardMainIfVO[]
	 */
    public YardMainIfVO[] getYardMainIfVOs() {
        YardMainIfVO[] vos = (YardMainIfVO[]) models.toArray(new YardMainIfVO[models.size()]);
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
        this.ydCd = this.ydCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydNm = this.ydNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locCd = this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n1stVndrCntCd = this.n1stVndrCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n1stVndrSeq = this.n1stVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n2ndVndrCntCd = this.n2ndVndrCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n2ndVndrSeq = this.n2ndVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n3rdVndrCntCd = this.n3rdVndrCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n3rdVndrSeq = this.n3rdVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hubYdFlg = this.hubYdFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydChrCd = this.ydChrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydFctyTpMrnTmlFlg = this.ydFctyTpMrnTmlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydFctyTpCyFlg = this.ydFctyTpCyFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydFctyTpCfsFlg = this.ydFctyTpCfsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydFctyTpRailRmpFlg = this.ydFctyTpRailRmpFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydOshpCd = this.ydOshpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bdYdFlg = this.bdYdFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydAddr = this.ydAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.zipCd = this.zipCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intlPhnNo = this.intlPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.phnNo = this.phnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.faxNo = this.faxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydPicNm = this.ydPicNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydCeoNm = this.ydCeoNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.gateOpnHrmnt = this.gateOpnHrmnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.gateClzHrmnt = this.gateClzHrmnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.holGateOpnHrmnt = this.holGateOpnHrmnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.holGateClzHrmnt = this.holGateClzHrmnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sunGateOpnHrmnt = this.sunGateOpnHrmnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sunGateClzHrmnt = this.sunGateClzHrmnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.satGateOpnHrmnt = this.satGateOpnHrmnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.satGateClzHrmnt = this.satGateClzHrmnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydRmk = this.ydRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.brthNo = this.brthNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydBrthLen = this.ydBrthLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydBrthAlngSdDesc = this.ydBrthAlngSdDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydBrthDpthChnlKnt = this.ydBrthDpthChnlKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydTtlSpc = this.ydTtlSpc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydActSpc = this.ydActSpc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydHjsSpc = this.ydHjsSpc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydHndlCapa = this.ydHndlCapa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydRfRcpt440VKnt = this.ydRfRcpt440VKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydRfRcpt220VKnt = this.ydRfRcpt220VKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydRfRcptDulKnt = this.ydRfRcptDulKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydOpSysCd = this.ydOpSysCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydCfsSpc = this.ydCfsSpc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mnrShopFlg = this.mnrShopFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydHndlYr = this.ydHndlYr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydTtlVolTeuKnt = this.ydTtlVolTeuKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydTtlVolBxKnt = this.ydTtlVolBxKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydHjsVolTeuKnt = this.ydHjsVolTeuKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydHjsVolBxKnt = this.ydHjsVolBxKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trstrKnt = this.trstrKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frkKnt = this.frkKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydStrdlCrrKnt = this.ydStrdlCrrKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydTrctKnt = this.ydTrctKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydTopLftKnt = this.ydTopLftKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tmlChssKnt = this.tmlChssKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eirSvcFlg = this.eirSvcFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tmlProdKnt = this.tmlProdKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydCstmsNo = this.ydCstmsNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydFctyTpPsdoYdFlg = this.ydFctyTpPsdoYdFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydEml = this.ydEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.demIbCltFlg = this.demIbCltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.demObCltFlg = this.demObCltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgPodYdFlg = this.bkgPodYdFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydFctyTpBrgRmpFlg = this.ydFctyTpBrgRmpFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bfrOfcCd = this.bfrOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bfrOfcCngDt = this.bfrOfcCngDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.modiYdCd = this.modiYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtOfcCd = this.dmdtOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.repYdTpCd = this.repYdTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dryAvgDwllHrs = this.dryAvgDwllHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dryMinDwllHrs = this.dryMinDwllHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dryYdFtHrs = this.dryYdFtHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydLoclLangNm = this.ydLoclLangNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydLoclLangAddr = this.ydLoclLangAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cudFlg = this.cudFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrId = this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydCgoClzHrmntMsg = this.ydCgoClzHrmntMsg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydInrlFlg = this.ydInrlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.onfHirYdFlg = this.onfHirYdFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydPstPgcKnt = this.ydPstPgcKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydPgcKnt = this.ydPgcKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.repZnCd = this.repZnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfAvgDwllHrs = this.rfAvgDwllHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfMinDwllHrs = this.rfMinDwllHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfYdFtHrs = this.rfYdFtHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eaiEvntDt = this.eaiEvntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eaiIfId = this.eaiIfId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
