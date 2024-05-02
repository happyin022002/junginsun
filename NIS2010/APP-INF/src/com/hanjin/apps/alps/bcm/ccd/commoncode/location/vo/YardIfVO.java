/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : YardIfVO.java
*@FileTitle : YardIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.04
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.04 
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
public class YardIfVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<YardIfVO> models = new ArrayList<YardIfVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String ydIfSeq = null;

    /* Column Info */
    private String ydCd = null;

    /* Column Info */
    private String ydNm = null;

    /* Column Info */
    private String locCd = null;

    /* Column Info */
    private String eqSccCd = null;

    /* Column Info */
    private String n1stVndrCntCd = null;

    /* Column Info */
    private String n1stVndrSeq = null;

    /* Column Info */
    private String ofcCd = null;

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
    private String repZnCd = null;

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
    private String ydCgoClzHrmntMsg = null;

    /* Column Info */
    private String ydRmk = null;

    /* Column Info */
    private String brthNo = null;

    /* Column Info */
    private String ydBrthLen = null;

    /* Column Info */
    private String ydBrthDpthChnlKnt = null;

    /* Column Info */
    private String ydTtlSpc = null;

    /* Column Info */
    private String ydActSpc = null;

    /* Column Info */
    private String ydHndlCapa = null;

    /* Column Info */
    private String ydRfRcpt440vKnt = null;

    /* Column Info */
    private String ydRfRcpt220vKnt = null;

    /* Column Info */
    private String ydRfRcptDulKnt = null;

    /* Column Info */
    private String ydOpSysCd = null;

    /* Column Info */
    private String ydInrlFlg = null;

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
    private String ydCoVolTeuKnt = null;

    /* Column Info */
    private String ydCoVolBxKnt = null;

    /* Column Info */
    private String ydPstPgcKnt = null;

    /* Column Info */
    private String ydPgcKnt = null;

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
    private String n2ndVndrCntCd = null;

    /* Column Info */
    private String n2ndVndrSeq = null;

    /* Column Info */
    private String n3rdVndrCntCd = null;

    /* Column Info */
    private String n3rdVndrSeq = null;

    /* Column Info */
    private String dmdtOfcCd = null;

    /* Column Info */
    private String repYdTpCd = null;

    /* Column Info */
    private String hubYdFlg = null;

    /* Column Info */
    private String ydLoclLangNm = null;

    /* Column Info */
    private String ydLoclLangAddr = null;

    /* Column Info */
    private String deltFlg = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String creUsrId = null;

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
	private String opediInsfId = null;

    /* Column Info */
    private String opediInsfDvCd = null;
	/* Column Info */
	private String modiYdCd = null;
	/* Column Info */
	private String ydLat = null;
	/* Column Info */
	private String ydLon = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public YardIfVO() {
    }

    public YardIfVO(String ibflag, String pagerows, String ydIfSeq, String ydCd, String ydNm, String locCd, String eqSccCd, String n1stVndrCntCd, String n1stVndrSeq, String ofcCd, String ydChrCd, String ydFctyTpMrnTmlFlg, String ydFctyTpCyFlg, String ydFctyTpCfsFlg, String ydFctyTpRailRmpFlg, String ydOshpCd, String bdYdFlg, String repZnCd, String ydAddr, String zipCd, String intlPhnNo, String phnNo, String faxNo, String ydPicNm, String ydCeoNm, String gateOpnHrmnt, String gateClzHrmnt, String holGateOpnHrmnt, String holGateClzHrmnt, String sunGateOpnHrmnt, String sunGateClzHrmnt, String satGateOpnHrmnt, String satGateClzHrmnt, String ydCgoClzHrmntMsg, String ydRmk, String brthNo, String ydBrthLen, String ydBrthDpthChnlKnt, String ydTtlSpc, String ydActSpc, String ydHndlCapa, String ydRfRcpt440vKnt, String ydRfRcpt220vKnt, String ydRfRcptDulKnt, String ydOpSysCd, String ydInrlFlg, String ydCfsSpc, String mnrShopFlg, String ydHndlYr, String ydTtlVolTeuKnt, String ydTtlVolBxKnt, String ydCoVolTeuKnt, String ydCoVolBxKnt, String ydPstPgcKnt, String ydPgcKnt, String trstrKnt, String frkKnt, String ydStrdlCrrKnt, String ydTrctKnt, String ydTopLftKnt, String tmlChssKnt, String eirSvcFlg, String tmlProdKnt, String ydCstmsNo, String ydFctyTpPsdoYdFlg, String ydEml, String demIbCltFlg, String demObCltFlg, String bkgPodYdFlg, String n2ndVndrCntCd, String n2ndVndrSeq, String n3rdVndrCntCd, String n3rdVndrSeq, String dmdtOfcCd, String repYdTpCd, String hubYdFlg, String ydLoclLangNm, String ydLoclLangAddr, String deltFlg, String creDt, String updUsrId, String updDt, String insfId, String insfPrsId, String insfDttm, String insfCnqeVal, String insfDvCd, String insfCnqeCont, String creUsrId, String ecomInsfId, String ecomInsfPrsId, String ecomInsfDttm, String ecomInsfCnqeVal, String ecomInsfDvCd, String ecomInsfCnqeCont, String ocediInsfId, String ocediInsfPrsId, String ocediInsfDttm, String ocediInsfCnqeVal, String ocediInsfDvCd, String ocediInsfCnqeCont, String opediInsfId, String opediInsfDvCd, String modiYdCd, String ydLat, String ydLon) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.ydIfSeq = ydIfSeq;
        this.ydCd = ydCd;
        this.ydNm = ydNm;
        this.locCd = locCd;
        this.eqSccCd = eqSccCd;
        this.n1stVndrCntCd = n1stVndrCntCd;
        this.n1stVndrSeq = n1stVndrSeq;
        this.ofcCd = ofcCd;
        this.ydChrCd = ydChrCd;
        this.ydFctyTpMrnTmlFlg = ydFctyTpMrnTmlFlg;
        this.ydFctyTpCyFlg = ydFctyTpCyFlg;
        this.ydFctyTpCfsFlg = ydFctyTpCfsFlg;
        this.ydFctyTpRailRmpFlg = ydFctyTpRailRmpFlg;
        this.ydOshpCd = ydOshpCd;
        this.bdYdFlg = bdYdFlg;
        this.repZnCd = repZnCd;
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
        this.ydCgoClzHrmntMsg = ydCgoClzHrmntMsg;
        this.ydRmk = ydRmk;
        this.brthNo = brthNo;
        this.ydBrthLen = ydBrthLen;
        this.ydBrthDpthChnlKnt = ydBrthDpthChnlKnt;
        this.ydTtlSpc = ydTtlSpc;
        this.ydActSpc = ydActSpc;
        this.ydHndlCapa = ydHndlCapa;
        this.ydRfRcpt440vKnt = ydRfRcpt440vKnt;
        this.ydRfRcpt220vKnt = ydRfRcpt220vKnt;
        this.ydRfRcptDulKnt = ydRfRcptDulKnt;
        this.ydOpSysCd = ydOpSysCd;
        this.ydInrlFlg = ydInrlFlg;
        this.ydCfsSpc = ydCfsSpc;
        this.mnrShopFlg = mnrShopFlg;
        this.ydHndlYr = ydHndlYr;
        this.ydTtlVolTeuKnt = ydTtlVolTeuKnt;
        this.ydTtlVolBxKnt = ydTtlVolBxKnt;
        this.ydCoVolTeuKnt = ydCoVolTeuKnt;
        this.ydCoVolBxKnt = ydCoVolBxKnt;
        this.ydPstPgcKnt = ydPstPgcKnt;
        this.ydPgcKnt = ydPgcKnt;
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
        this.n2ndVndrCntCd = n2ndVndrCntCd;
        this.n2ndVndrSeq = n2ndVndrSeq;
        this.n3rdVndrCntCd = n3rdVndrCntCd;
        this.n3rdVndrSeq = n3rdVndrSeq;
        this.dmdtOfcCd = dmdtOfcCd;
        this.repYdTpCd = repYdTpCd;
        this.hubYdFlg = hubYdFlg;
        this.ydLoclLangNm = ydLoclLangNm;
        this.ydLoclLangAddr = ydLoclLangAddr;
        this.deltFlg = deltFlg;
        this.creDt = creDt;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.creUsrId = creUsrId;
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
        
        this.opediInsfId = opediInsfId;
        this.opediInsfDvCd = opediInsfDvCd;
        this.modiYdCd = modiYdCd;
        this.ydLat = ydLat;
        this.ydLon = ydLon;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("yd_if_seq", getYdIfSeq());
        this.hashColumns.put("yd_cd", getYdCd());
        this.hashColumns.put("yd_nm", getYdNm());
        this.hashColumns.put("loc_cd", getLocCd());
        this.hashColumns.put("eq_scc_cd", getEqSccCd());
        this.hashColumns.put("n1st_vndr_cnt_cd", getN1stVndrCntCd());
        this.hashColumns.put("n1st_vndr_seq", getN1stVndrSeq());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("yd_chr_cd", getYdChrCd());
        this.hashColumns.put("yd_fcty_tp_mrn_tml_flg", getYdFctyTpMrnTmlFlg());
        this.hashColumns.put("yd_fcty_tp_cy_flg", getYdFctyTpCyFlg());
        this.hashColumns.put("yd_fcty_tp_cfs_flg", getYdFctyTpCfsFlg());
        this.hashColumns.put("yd_fcty_tp_rail_rmp_flg", getYdFctyTpRailRmpFlg());
        this.hashColumns.put("yd_oshp_cd", getYdOshpCd());
        this.hashColumns.put("bd_yd_flg", getBdYdFlg());
        this.hashColumns.put("rep_zn_cd", getRepZnCd());
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
        this.hashColumns.put("yd_cgo_clz_hrmnt_msg", getYdCgoClzHrmntMsg());
        this.hashColumns.put("yd_rmk", getYdRmk());
        this.hashColumns.put("brth_no", getBrthNo());
        this.hashColumns.put("yd_brth_len", getYdBrthLen());
        this.hashColumns.put("yd_brth_dpth_chnl_knt", getYdBrthDpthChnlKnt());
        this.hashColumns.put("yd_ttl_spc", getYdTtlSpc());
        this.hashColumns.put("yd_act_spc", getYdActSpc());
        this.hashColumns.put("yd_hndl_capa", getYdHndlCapa());
        this.hashColumns.put("yd_rf_rcpt440v_knt", getYdRfRcpt440vKnt());
        this.hashColumns.put("yd_rf_rcpt220v_knt", getYdRfRcpt220vKnt());
        this.hashColumns.put("yd_rf_rcpt_dul_knt", getYdRfRcptDulKnt());
        this.hashColumns.put("yd_op_sys_cd", getYdOpSysCd());
        this.hashColumns.put("yd_inrl_flg", getYdInrlFlg());
        this.hashColumns.put("yd_cfs_spc", getYdCfsSpc());
        this.hashColumns.put("mnr_shop_flg", getMnrShopFlg());
        this.hashColumns.put("yd_hndl_yr", getYdHndlYr());
        this.hashColumns.put("yd_ttl_vol_teu_knt", getYdTtlVolTeuKnt());
        this.hashColumns.put("yd_ttl_vol_bx_knt", getYdTtlVolBxKnt());
        this.hashColumns.put("yd_co_vol_teu_knt", getYdCoVolTeuKnt());
        this.hashColumns.put("yd_co_vol_bx_knt", getYdCoVolBxKnt());
        this.hashColumns.put("yd_pst_pgc_knt", getYdPstPgcKnt());
        this.hashColumns.put("yd_pgc_knt", getYdPgcKnt());
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
        this.hashColumns.put("n2nd_vndr_cnt_cd", getN2ndVndrCntCd());
        this.hashColumns.put("n2nd_vndr_seq", getN2ndVndrSeq());
        this.hashColumns.put("n3rd_vndr_cnt_cd", getN3rdVndrCntCd());
        this.hashColumns.put("n3rd_vndr_seq", getN3rdVndrSeq());
        this.hashColumns.put("dmdt_ofc_cd", getDmdtOfcCd());
        this.hashColumns.put("rep_yd_tp_cd", getRepYdTpCd());
        this.hashColumns.put("hub_yd_flg", getHubYdFlg());
        this.hashColumns.put("yd_locl_lang_nm", getYdLoclLangNm());
        this.hashColumns.put("yd_locl_lang_addr", getYdLoclLangAddr());
        this.hashColumns.put("delt_flg", getDeltFlg());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
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

		this.hashColumns.put("opedi_insf_id", getOpediInsfId());
        this.hashColumns.put("opedi_insf_dv_cd", getOpediInsfDvCd());
		this.hashColumns.put("modi_yd_cd", getModiYdCd());
		this.hashColumns.put("yd_lat", getYdLat());
		this.hashColumns.put("yd_lon", getYdLon());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("yd_if_seq", "ydIfSeq");
        this.hashFields.put("yd_cd", "ydCd");
        this.hashFields.put("yd_nm", "ydNm");
        this.hashFields.put("loc_cd", "locCd");
        this.hashFields.put("eq_scc_cd", "eqSccCd");
        this.hashFields.put("n1st_vndr_cnt_cd", "n1stVndrCntCd");
        this.hashFields.put("n1st_vndr_seq", "n1stVndrSeq");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("yd_chr_cd", "ydChrCd");
        this.hashFields.put("yd_fcty_tp_mrn_tml_flg", "ydFctyTpMrnTmlFlg");
        this.hashFields.put("yd_fcty_tp_cy_flg", "ydFctyTpCyFlg");
        this.hashFields.put("yd_fcty_tp_cfs_flg", "ydFctyTpCfsFlg");
        this.hashFields.put("yd_fcty_tp_rail_rmp_flg", "ydFctyTpRailRmpFlg");
        this.hashFields.put("yd_oshp_cd", "ydOshpCd");
        this.hashFields.put("bd_yd_flg", "bdYdFlg");
        this.hashFields.put("rep_zn_cd", "repZnCd");
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
        this.hashFields.put("yd_cgo_clz_hrmnt_msg", "ydCgoClzHrmntMsg");
        this.hashFields.put("yd_rmk", "ydRmk");
        this.hashFields.put("brth_no", "brthNo");
        this.hashFields.put("yd_brth_len", "ydBrthLen");
        this.hashFields.put("yd_brth_dpth_chnl_knt", "ydBrthDpthChnlKnt");
        this.hashFields.put("yd_ttl_spc", "ydTtlSpc");
        this.hashFields.put("yd_act_spc", "ydActSpc");
        this.hashFields.put("yd_hndl_capa", "ydHndlCapa");
        this.hashFields.put("yd_rf_rcpt440v_knt", "ydRfRcpt440vKnt");
        this.hashFields.put("yd_rf_rcpt220v_knt", "ydRfRcpt220vKnt");
        this.hashFields.put("yd_rf_rcpt_dul_knt", "ydRfRcptDulKnt");
        this.hashFields.put("yd_op_sys_cd", "ydOpSysCd");
        this.hashFields.put("yd_inrl_flg", "ydInrlFlg");
        this.hashFields.put("yd_cfs_spc", "ydCfsSpc");
        this.hashFields.put("mnr_shop_flg", "mnrShopFlg");
        this.hashFields.put("yd_hndl_yr", "ydHndlYr");
        this.hashFields.put("yd_ttl_vol_teu_knt", "ydTtlVolTeuKnt");
        this.hashFields.put("yd_ttl_vol_bx_knt", "ydTtlVolBxKnt");
        this.hashFields.put("yd_co_vol_teu_knt", "ydCoVolTeuKnt");
        this.hashFields.put("yd_co_vol_bx_knt", "ydCoVolBxKnt");
        this.hashFields.put("yd_pst_pgc_knt", "ydPstPgcKnt");
        this.hashFields.put("yd_pgc_knt", "ydPgcKnt");
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
        this.hashFields.put("n2nd_vndr_cnt_cd", "n2ndVndrCntCd");
        this.hashFields.put("n2nd_vndr_seq", "n2ndVndrSeq");
        this.hashFields.put("n3rd_vndr_cnt_cd", "n3rdVndrCntCd");
        this.hashFields.put("n3rd_vndr_seq", "n3rdVndrSeq");
        this.hashFields.put("dmdt_ofc_cd", "dmdtOfcCd");
        this.hashFields.put("rep_yd_tp_cd", "repYdTpCd");
        this.hashFields.put("hub_yd_flg", "hubYdFlg");
        this.hashFields.put("yd_locl_lang_nm", "ydLoclLangNm");
        this.hashFields.put("yd_locl_lang_addr", "ydLoclLangAddr");
        this.hashFields.put("delt_flg", "deltFlg");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("insf_id", "insfId");
        this.hashFields.put("insf_prs_id", "insfPrsId");
        this.hashFields.put("insf_dttm", "insfDttm");
        this.hashFields.put("insf_cnqe_val", "insfCnqeVal");
        this.hashFields.put("insf_dv_cd", "insfDvCd");
        this.hashFields.put("insf_cnqe_cont", "insfCnqeCont");
        this.hashFields.put("cre_usr_id", "creUsrId");
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

		this.hashFields.put("opedi_insf_id", "opediInsfId");
        this.hashFields.put("opedi_insf_dv_cd", "opediInsfDvCd");
		this.hashFields.put("modi_yd_cd", "modiYdCd");
		this.hashFields.put("yd_lat", "ydLat");
		this.hashFields.put("yd_lon", "ydLon");
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
	 * @param String ydIfSeq
	 */
    public void setYdIfSeq(String ydIfSeq) {
        this.ydIfSeq = ydIfSeq;
    }

    /**
	 * 
	 * @return String ydIfSeq
	 */
    public String getYdIfSeq() {
        return this.ydIfSeq;
    }

    /**
	 *
	 * @param String ydCd
	 */
    public void setYdCd(String ydCd) {
        this.ydCd = ydCd;
    }

    /**
	 * 
	 * @return String ydCd
	 */
    public String getYdCd() {
        return this.ydCd;
    }

    /**
	 *
	 * @param String ydNm
	 */
    public void setYdNm(String ydNm) {
        this.ydNm = ydNm;
    }

    /**
	 * 
	 * @return String ydNm
	 */
    public String getYdNm() {
        return this.ydNm;
    }

    /**
	 *
	 * @param String locCd
	 */
    public void setLocCd(String locCd) {
        this.locCd = locCd;
    }

    /**
	 * 
	 * @return String locCd
	 */
    public String getLocCd() {
        return this.locCd;
    }

    /**
	 *
	 * @param String eqSccCd
	 */
    public void setEqSccCd(String eqSccCd) {
        this.eqSccCd = eqSccCd;
    }

    /**
	 * 
	 * @return String eqSccCd
	 */
    public String getEqSccCd() {
        return this.eqSccCd;
    }

    /**
	 *
	 * @param String n1stVndrCntCd
	 */
    public void setN1stVndrCntCd(String n1stVndrCntCd) {
        this.n1stVndrCntCd = n1stVndrCntCd;
    }

    /**
	 * 
	 * @return String n1stVndrCntCd
	 */
    public String getN1stVndrCntCd() {
        return this.n1stVndrCntCd;
    }

    /**
	 *
	 * @param String n1stVndrSeq
	 */
    public void setN1stVndrSeq(String n1stVndrSeq) {
        this.n1stVndrSeq = n1stVndrSeq;
    }

    /**
	 * 
	 * @return String n1stVndrSeq
	 */
    public String getN1stVndrSeq() {
        return this.n1stVndrSeq;
    }

    /**
	 *
	 * @param String ofcCd
	 */
    public void setOfcCd(String ofcCd) {
        this.ofcCd = ofcCd;
    }

    /**
	 * 
	 * @return String ofcCd
	 */
    public String getOfcCd() {
        return this.ofcCd;
    }

    /**
	 *
	 * @param String ydChrCd
	 */
    public void setYdChrCd(String ydChrCd) {
        this.ydChrCd = ydChrCd;
    }

    /**
	 * 
	 * @return String ydChrCd
	 */
    public String getYdChrCd() {
        return this.ydChrCd;
    }

    /**
	 *
	 * @param String ydFctyTpMrnTmlFlg
	 */
    public void setYdFctyTpMrnTmlFlg(String ydFctyTpMrnTmlFlg) {
        this.ydFctyTpMrnTmlFlg = ydFctyTpMrnTmlFlg;
    }

    /**
	 * 
	 * @return String ydFctyTpMrnTmlFlg
	 */
    public String getYdFctyTpMrnTmlFlg() {
        return this.ydFctyTpMrnTmlFlg;
    }

    /**
	 *
	 * @param String ydFctyTpCyFlg
	 */
    public void setYdFctyTpCyFlg(String ydFctyTpCyFlg) {
        this.ydFctyTpCyFlg = ydFctyTpCyFlg;
    }

    /**
	 * 
	 * @return String ydFctyTpCyFlg
	 */
    public String getYdFctyTpCyFlg() {
        return this.ydFctyTpCyFlg;
    }

    /**
	 *
	 * @param String ydFctyTpCfsFlg
	 */
    public void setYdFctyTpCfsFlg(String ydFctyTpCfsFlg) {
        this.ydFctyTpCfsFlg = ydFctyTpCfsFlg;
    }

    /**
	 * 
	 * @return String ydFctyTpCfsFlg
	 */
    public String getYdFctyTpCfsFlg() {
        return this.ydFctyTpCfsFlg;
    }

    /**
	 *
	 * @param String ydFctyTpRailRmpFlg
	 */
    public void setYdFctyTpRailRmpFlg(String ydFctyTpRailRmpFlg) {
        this.ydFctyTpRailRmpFlg = ydFctyTpRailRmpFlg;
    }

    /**
	 * 
	 * @return String ydFctyTpRailRmpFlg
	 */
    public String getYdFctyTpRailRmpFlg() {
        return this.ydFctyTpRailRmpFlg;
    }

    /**
	 *
	 * @param String ydOshpCd
	 */
    public void setYdOshpCd(String ydOshpCd) {
        this.ydOshpCd = ydOshpCd;
    }

    /**
	 * 
	 * @return String ydOshpCd
	 */
    public String getYdOshpCd() {
        return this.ydOshpCd;
    }

    /**
	 *
	 * @param String bdYdFlg
	 */
    public void setBdYdFlg(String bdYdFlg) {
        this.bdYdFlg = bdYdFlg;
    }

    /**
	 * 
	 * @return String bdYdFlg
	 */
    public String getBdYdFlg() {
        return this.bdYdFlg;
    }

    /**
	 *
	 * @param String repZnCd
	 */
    public void setRepZnCd(String repZnCd) {
        this.repZnCd = repZnCd;
    }

    /**
	 * 
	 * @return String repZnCd
	 */
    public String getRepZnCd() {
        return this.repZnCd;
    }

    /**
	 *
	 * @param String ydAddr
	 */
    public void setYdAddr(String ydAddr) {
        this.ydAddr = ydAddr;
    }

    /**
	 * 
	 * @return String ydAddr
	 */
    public String getYdAddr() {
        return this.ydAddr;
    }

    /**
	 *
	 * @param String zipCd
	 */
    public void setZipCd(String zipCd) {
        this.zipCd = zipCd;
    }

    /**
	 * 
	 * @return String zipCd
	 */
    public String getZipCd() {
        return this.zipCd;
    }

    /**
	 *
	 * @param String intlPhnNo
	 */
    public void setIntlPhnNo(String intlPhnNo) {
        this.intlPhnNo = intlPhnNo;
    }

    /**
	 * 
	 * @return String intlPhnNo
	 */
    public String getIntlPhnNo() {
        return this.intlPhnNo;
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
	 * @param String ydPicNm
	 */
    public void setYdPicNm(String ydPicNm) {
        this.ydPicNm = ydPicNm;
    }

    /**
	 * 
	 * @return String ydPicNm
	 */
    public String getYdPicNm() {
        return this.ydPicNm;
    }

    /**
	 *
	 * @param String ydCeoNm
	 */
    public void setYdCeoNm(String ydCeoNm) {
        this.ydCeoNm = ydCeoNm;
    }

    /**
	 * 
	 * @return String ydCeoNm
	 */
    public String getYdCeoNm() {
        return this.ydCeoNm;
    }

    /**
	 *
	 * @param String gateOpnHrmnt
	 */
    public void setGateOpnHrmnt(String gateOpnHrmnt) {
        this.gateOpnHrmnt = gateOpnHrmnt;
    }

    /**
	 * 
	 * @return String gateOpnHrmnt
	 */
    public String getGateOpnHrmnt() {
        return this.gateOpnHrmnt;
    }

    /**
	 *
	 * @param String gateClzHrmnt
	 */
    public void setGateClzHrmnt(String gateClzHrmnt) {
        this.gateClzHrmnt = gateClzHrmnt;
    }

    /**
	 * 
	 * @return String gateClzHrmnt
	 */
    public String getGateClzHrmnt() {
        return this.gateClzHrmnt;
    }

    /**
	 *
	 * @param String holGateOpnHrmnt
	 */
    public void setHolGateOpnHrmnt(String holGateOpnHrmnt) {
        this.holGateOpnHrmnt = holGateOpnHrmnt;
    }

    /**
	 * 
	 * @return String holGateOpnHrmnt
	 */
    public String getHolGateOpnHrmnt() {
        return this.holGateOpnHrmnt;
    }

    /**
	 *
	 * @param String holGateClzHrmnt
	 */
    public void setHolGateClzHrmnt(String holGateClzHrmnt) {
        this.holGateClzHrmnt = holGateClzHrmnt;
    }

    /**
	 * 
	 * @return String holGateClzHrmnt
	 */
    public String getHolGateClzHrmnt() {
        return this.holGateClzHrmnt;
    }

    /**
	 *
	 * @param String sunGateOpnHrmnt
	 */
    public void setSunGateOpnHrmnt(String sunGateOpnHrmnt) {
        this.sunGateOpnHrmnt = sunGateOpnHrmnt;
    }

    /**
	 * 
	 * @return String sunGateOpnHrmnt
	 */
    public String getSunGateOpnHrmnt() {
        return this.sunGateOpnHrmnt;
    }

    /**
	 *
	 * @param String sunGateClzHrmnt
	 */
    public void setSunGateClzHrmnt(String sunGateClzHrmnt) {
        this.sunGateClzHrmnt = sunGateClzHrmnt;
    }

    /**
	 * 
	 * @return String sunGateClzHrmnt
	 */
    public String getSunGateClzHrmnt() {
        return this.sunGateClzHrmnt;
    }

    /**
	 *
	 * @param String satGateOpnHrmnt
	 */
    public void setSatGateOpnHrmnt(String satGateOpnHrmnt) {
        this.satGateOpnHrmnt = satGateOpnHrmnt;
    }

    /**
	 * 
	 * @return String satGateOpnHrmnt
	 */
    public String getSatGateOpnHrmnt() {
        return this.satGateOpnHrmnt;
    }

    /**
	 *
	 * @param String satGateClzHrmnt
	 */
    public void setSatGateClzHrmnt(String satGateClzHrmnt) {
        this.satGateClzHrmnt = satGateClzHrmnt;
    }

    /**
	 * 
	 * @return String satGateClzHrmnt
	 */
    public String getSatGateClzHrmnt() {
        return this.satGateClzHrmnt;
    }

    /**
	 *
	 * @param String ydCgoClzHrmntMsg
	 */
    public void setYdCgoClzHrmntMsg(String ydCgoClzHrmntMsg) {
        this.ydCgoClzHrmntMsg = ydCgoClzHrmntMsg;
    }

    /**
	 * 
	 * @return String ydCgoClzHrmntMsg
	 */
    public String getYdCgoClzHrmntMsg() {
        return this.ydCgoClzHrmntMsg;
    }

    /**
	 *
	 * @param String ydRmk
	 */
    public void setYdRmk(String ydRmk) {
        this.ydRmk = ydRmk;
    }

    /**
	 * 
	 * @return String ydRmk
	 */
    public String getYdRmk() {
        return this.ydRmk;
    }

    /**
	 *
	 * @param String brthNo
	 */
    public void setBrthNo(String brthNo) {
        this.brthNo = brthNo;
    }

    /**
	 * 
	 * @return String brthNo
	 */
    public String getBrthNo() {
        return this.brthNo;
    }

    /**
	 *
	 * @param String ydBrthLen
	 */
    public void setYdBrthLen(String ydBrthLen) {
        this.ydBrthLen = ydBrthLen;
    }

    /**
	 * 
	 * @return String ydBrthLen
	 */
    public String getYdBrthLen() {
        return this.ydBrthLen;
    }

    /**
	 *
	 * @param String ydBrthDpthChnlKnt
	 */
    public void setYdBrthDpthChnlKnt(String ydBrthDpthChnlKnt) {
        this.ydBrthDpthChnlKnt = ydBrthDpthChnlKnt;
    }

    /**
	 * 
	 * @return String ydBrthDpthChnlKnt
	 */
    public String getYdBrthDpthChnlKnt() {
        return this.ydBrthDpthChnlKnt;
    }

    /**
	 *
	 * @param String ydTtlSpc
	 */
    public void setYdTtlSpc(String ydTtlSpc) {
        this.ydTtlSpc = ydTtlSpc;
    }

    /**
	 * 
	 * @return String ydTtlSpc
	 */
    public String getYdTtlSpc() {
        return this.ydTtlSpc;
    }

    /**
	 *
	 * @param String ydActSpc
	 */
    public void setYdActSpc(String ydActSpc) {
        this.ydActSpc = ydActSpc;
    }

    /**
	 * 
	 * @return String ydActSpc
	 */
    public String getYdActSpc() {
        return this.ydActSpc;
    }

    /**
	 *
	 * @param String ydHndlCapa
	 */
    public void setYdHndlCapa(String ydHndlCapa) {
        this.ydHndlCapa = ydHndlCapa;
    }

    /**
	 * 
	 * @return String ydHndlCapa
	 */
    public String getYdHndlCapa() {
        return this.ydHndlCapa;
    }

    /**
	 *
	 * @param String ydRfRcpt440vKnt
	 */
    public void setYdRfRcpt440vKnt(String ydRfRcpt440vKnt) {
        this.ydRfRcpt440vKnt = ydRfRcpt440vKnt;
    }

    /**
	 * 
	 * @return String ydRfRcpt440vKnt
	 */
    public String getYdRfRcpt440vKnt() {
        return this.ydRfRcpt440vKnt;
    }

    /**
	 *
	 * @param String ydRfRcpt220vKnt
	 */
    public void setYdRfRcpt220vKnt(String ydRfRcpt220vKnt) {
        this.ydRfRcpt220vKnt = ydRfRcpt220vKnt;
    }

    /**
	 * 
	 * @return String ydRfRcpt220vKnt
	 */
    public String getYdRfRcpt220vKnt() {
        return this.ydRfRcpt220vKnt;
    }

    /**
	 *
	 * @param String ydRfRcptDulKnt
	 */
    public void setYdRfRcptDulKnt(String ydRfRcptDulKnt) {
        this.ydRfRcptDulKnt = ydRfRcptDulKnt;
    }

    /**
	 * 
	 * @return String ydRfRcptDulKnt
	 */
    public String getYdRfRcptDulKnt() {
        return this.ydRfRcptDulKnt;
    }

    /**
	 *
	 * @param String ydOpSysCd
	 */
    public void setYdOpSysCd(String ydOpSysCd) {
        this.ydOpSysCd = ydOpSysCd;
    }

    /**
	 * 
	 * @return String ydOpSysCd
	 */
    public String getYdOpSysCd() {
        return this.ydOpSysCd;
    }

    /**
	 *
	 * @param String ydInrlFlg
	 */
    public void setYdInrlFlg(String ydInrlFlg) {
        this.ydInrlFlg = ydInrlFlg;
    }

    /**
	 * 
	 * @return String ydInrlFlg
	 */
    public String getYdInrlFlg() {
        return this.ydInrlFlg;
    }

    /**
	 *
	 * @param String ydCfsSpc
	 */
    public void setYdCfsSpc(String ydCfsSpc) {
        this.ydCfsSpc = ydCfsSpc;
    }

    /**
	 * 
	 * @return String ydCfsSpc
	 */
    public String getYdCfsSpc() {
        return this.ydCfsSpc;
    }

    /**
	 *
	 * @param String mnrShopFlg
	 */
    public void setMnrShopFlg(String mnrShopFlg) {
        this.mnrShopFlg = mnrShopFlg;
    }

    /**
	 * 
	 * @return String mnrShopFlg
	 */
    public String getMnrShopFlg() {
        return this.mnrShopFlg;
    }

    /**
	 *
	 * @param String ydHndlYr
	 */
    public void setYdHndlYr(String ydHndlYr) {
        this.ydHndlYr = ydHndlYr;
    }

    /**
	 * 
	 * @return String ydHndlYr
	 */
    public String getYdHndlYr() {
        return this.ydHndlYr;
    }

    /**
	 *
	 * @param String ydTtlVolTeuKnt
	 */
    public void setYdTtlVolTeuKnt(String ydTtlVolTeuKnt) {
        this.ydTtlVolTeuKnt = ydTtlVolTeuKnt;
    }

    /**
	 * 
	 * @return String ydTtlVolTeuKnt
	 */
    public String getYdTtlVolTeuKnt() {
        return this.ydTtlVolTeuKnt;
    }

    /**
	 *
	 * @param String ydTtlVolBxKnt
	 */
    public void setYdTtlVolBxKnt(String ydTtlVolBxKnt) {
        this.ydTtlVolBxKnt = ydTtlVolBxKnt;
    }

    /**
	 * 
	 * @return String ydTtlVolBxKnt
	 */
    public String getYdTtlVolBxKnt() {
        return this.ydTtlVolBxKnt;
    }

    /**
	 *
	 * @param String ydCoVolTeuKnt
	 */
    public void setYdCoVolTeuKnt(String ydCoVolTeuKnt) {
        this.ydCoVolTeuKnt = ydCoVolTeuKnt;
    }

    /**
	 * 
	 * @return String ydCoVolTeuKnt
	 */
    public String getYdCoVolTeuKnt() {
        return this.ydCoVolTeuKnt;
    }

    /**
	 *
	 * @param String ydCoVolBxKnt
	 */
    public void setYdCoVolBxKnt(String ydCoVolBxKnt) {
        this.ydCoVolBxKnt = ydCoVolBxKnt;
    }

    /**
	 * 
	 * @return String ydCoVolBxKnt
	 */
    public String getYdCoVolBxKnt() {
        return this.ydCoVolBxKnt;
    }

    /**
	 *
	 * @param String ydPstPgcKnt
	 */
    public void setYdPstPgcKnt(String ydPstPgcKnt) {
        this.ydPstPgcKnt = ydPstPgcKnt;
    }

    /**
	 * 
	 * @return String ydPstPgcKnt
	 */
    public String getYdPstPgcKnt() {
        return this.ydPstPgcKnt;
    }

    /**
	 *
	 * @param String ydPgcKnt
	 */
    public void setYdPgcKnt(String ydPgcKnt) {
        this.ydPgcKnt = ydPgcKnt;
    }

    /**
	 * 
	 * @return String ydPgcKnt
	 */
    public String getYdPgcKnt() {
        return this.ydPgcKnt;
    }

    /**
	 *
	 * @param String trstrKnt
	 */
    public void setTrstrKnt(String trstrKnt) {
        this.trstrKnt = trstrKnt;
    }

    /**
	 * 
	 * @return String trstrKnt
	 */
    public String getTrstrKnt() {
        return this.trstrKnt;
    }

    /**
	 *
	 * @param String frkKnt
	 */
    public void setFrkKnt(String frkKnt) {
        this.frkKnt = frkKnt;
    }

    /**
	 * 
	 * @return String frkKnt
	 */
    public String getFrkKnt() {
        return this.frkKnt;
    }

    /**
	 *
	 * @param String ydStrdlCrrKnt
	 */
    public void setYdStrdlCrrKnt(String ydStrdlCrrKnt) {
        this.ydStrdlCrrKnt = ydStrdlCrrKnt;
    }

    /**
	 * 
	 * @return String ydStrdlCrrKnt
	 */
    public String getYdStrdlCrrKnt() {
        return this.ydStrdlCrrKnt;
    }

    /**
	 *
	 * @param String ydTrctKnt
	 */
    public void setYdTrctKnt(String ydTrctKnt) {
        this.ydTrctKnt = ydTrctKnt;
    }

    /**
	 * 
	 * @return String ydTrctKnt
	 */
    public String getYdTrctKnt() {
        return this.ydTrctKnt;
    }

    /**
	 *
	 * @param String ydTopLftKnt
	 */
    public void setYdTopLftKnt(String ydTopLftKnt) {
        this.ydTopLftKnt = ydTopLftKnt;
    }

    /**
	 * 
	 * @return String ydTopLftKnt
	 */
    public String getYdTopLftKnt() {
        return this.ydTopLftKnt;
    }

    /**
	 *
	 * @param String tmlChssKnt
	 */
    public void setTmlChssKnt(String tmlChssKnt) {
        this.tmlChssKnt = tmlChssKnt;
    }

    /**
	 * 
	 * @return String tmlChssKnt
	 */
    public String getTmlChssKnt() {
        return this.tmlChssKnt;
    }

    /**
	 *
	 * @param String eirSvcFlg
	 */
    public void setEirSvcFlg(String eirSvcFlg) {
        this.eirSvcFlg = eirSvcFlg;
    }

    /**
	 * 
	 * @return String eirSvcFlg
	 */
    public String getEirSvcFlg() {
        return this.eirSvcFlg;
    }

    /**
	 *
	 * @param String tmlProdKnt
	 */
    public void setTmlProdKnt(String tmlProdKnt) {
        this.tmlProdKnt = tmlProdKnt;
    }

    /**
	 * 
	 * @return String tmlProdKnt
	 */
    public String getTmlProdKnt() {
        return this.tmlProdKnt;
    }

    /**
	 *
	 * @param String ydCstmsNo
	 */
    public void setYdCstmsNo(String ydCstmsNo) {
        this.ydCstmsNo = ydCstmsNo;
    }

    /**
	 * 
	 * @return String ydCstmsNo
	 */
    public String getYdCstmsNo() {
        return this.ydCstmsNo;
    }

    /**
	 *
	 * @param String ydFctyTpPsdoYdFlg
	 */
    public void setYdFctyTpPsdoYdFlg(String ydFctyTpPsdoYdFlg) {
        this.ydFctyTpPsdoYdFlg = ydFctyTpPsdoYdFlg;
    }

    /**
	 * 
	 * @return String ydFctyTpPsdoYdFlg
	 */
    public String getYdFctyTpPsdoYdFlg() {
        return this.ydFctyTpPsdoYdFlg;
    }

    /**
	 *
	 * @param String ydEml
	 */
    public void setYdEml(String ydEml) {
        this.ydEml = ydEml;
    }

    /**
	 * 
	 * @return String ydEml
	 */
    public String getYdEml() {
        return this.ydEml;
    }

    /**
	 *
	 * @param String demIbCltFlg
	 */
    public void setDemIbCltFlg(String demIbCltFlg) {
        this.demIbCltFlg = demIbCltFlg;
    }

    /**
	 * 
	 * @return String demIbCltFlg
	 */
    public String getDemIbCltFlg() {
        return this.demIbCltFlg;
    }

    /**
	 *
	 * @param String demObCltFlg
	 */
    public void setDemObCltFlg(String demObCltFlg) {
        this.demObCltFlg = demObCltFlg;
    }

    /**
	 * 
	 * @return String demObCltFlg
	 */
    public String getDemObCltFlg() {
        return this.demObCltFlg;
    }

    /**
	 *
	 * @param String bkgPodYdFlg
	 */
    public void setBkgPodYdFlg(String bkgPodYdFlg) {
        this.bkgPodYdFlg = bkgPodYdFlg;
    }

    /**
	 * 
	 * @return String bkgPodYdFlg
	 */
    public String getBkgPodYdFlg() {
        return this.bkgPodYdFlg;
    }

    /**
	 *
	 * @param String n2ndVndrCntCd
	 */
    public void setN2ndVndrCntCd(String n2ndVndrCntCd) {
        this.n2ndVndrCntCd = n2ndVndrCntCd;
    }

    /**
	 * 
	 * @return String n2ndVndrCntCd
	 */
    public String getN2ndVndrCntCd() {
        return this.n2ndVndrCntCd;
    }

    /**
	 *
	 * @param String n2ndVndrSeq
	 */
    public void setN2ndVndrSeq(String n2ndVndrSeq) {
        this.n2ndVndrSeq = n2ndVndrSeq;
    }

    /**
	 * 
	 * @return String n2ndVndrSeq
	 */
    public String getN2ndVndrSeq() {
        return this.n2ndVndrSeq;
    }

    /**
	 *
	 * @param String n3rdVndrCntCd
	 */
    public void setN3rdVndrCntCd(String n3rdVndrCntCd) {
        this.n3rdVndrCntCd = n3rdVndrCntCd;
    }

    /**
	 * 
	 * @return String n3rdVndrCntCd
	 */
    public String getN3rdVndrCntCd() {
        return this.n3rdVndrCntCd;
    }

    /**
	 *
	 * @param String n3rdVndrSeq
	 */
    public void setN3rdVndrSeq(String n3rdVndrSeq) {
        this.n3rdVndrSeq = n3rdVndrSeq;
    }

    /**
	 * 
	 * @return String n3rdVndrSeq
	 */
    public String getN3rdVndrSeq() {
        return this.n3rdVndrSeq;
    }

    /**
	 *
	 * @param String dmdtOfcCd
	 */
    public void setDmdtOfcCd(String dmdtOfcCd) {
        this.dmdtOfcCd = dmdtOfcCd;
    }

    /**
	 * 
	 * @return String dmdtOfcCd
	 */
    public String getDmdtOfcCd() {
        return this.dmdtOfcCd;
    }

    /**
	 *
	 * @param String repYdTpCd
	 */
    public void setRepYdTpCd(String repYdTpCd) {
        this.repYdTpCd = repYdTpCd;
    }

    /**
	 * 
	 * @return String repYdTpCd
	 */
    public String getRepYdTpCd() {
        return this.repYdTpCd;
    }

    /**
	 *
	 * @param String hubYdFlg
	 */
    public void setHubYdFlg(String hubYdFlg) {
        this.hubYdFlg = hubYdFlg;
    }

    /**
	 * 
	 * @return String hubYdFlg
	 */
    public String getHubYdFlg() {
        return this.hubYdFlg;
    }

    /**
	 *
	 * @param String ydLoclLangNm
	 */
    public void setYdLoclLangNm(String ydLoclLangNm) {
        this.ydLoclLangNm = ydLoclLangNm;
    }

    /**
	 * 
	 * @return String ydLoclLangNm
	 */
    public String getYdLoclLangNm() {
        return this.ydLoclLangNm;
    }

    /**
	 *
	 * @param String ydLoclLangAddr
	 */
    public void setYdLoclLangAddr(String ydLoclLangAddr) {
        this.ydLoclLangAddr = ydLoclLangAddr;
    }

    /**
	 * 
	 * @return String ydLoclLangAddr
	 */
    public String getYdLoclLangAddr() {
        return this.ydLoclLangAddr;
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

    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    public String getCreUsrId() {
        return this.creUsrId;
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

	public String getOpediInsfId() {
		return opediInsfId;
	}

	public void setOpediInsfId(String opediInsfId) {
		this.opediInsfId = opediInsfId;
	}

    public void setOpediInsfDvCd(String opediInsfDvCd) {
        this.opediInsfDvCd = opediInsfDvCd;
    }

    public String getOpediInsfDvCd() {
        return this.opediInsfDvCd;
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

	/**
	 * Column Info
	 * @return modiYdCd
	 */
	public String getModiYdCd() {
		return this.modiYdCd;
	}

	/**
	 * Column Info
	 * @param modiYdCd
	 */
	public void setModiYdCd(String modiYdCd) {
		this.modiYdCd = modiYdCd;
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
        setYdIfSeq(JSPUtil.getParameter(request, prefix + "yd_if_seq", ""));
        setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
        setYdNm(JSPUtil.getParameter(request, prefix + "yd_nm", ""));
        setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
        setEqSccCd(JSPUtil.getParameter(request, prefix + "eq_scc_cd", ""));
        setN1stVndrCntCd(JSPUtil.getParameter(request, prefix + "n1st_vndr_cnt_cd", ""));
        setN1stVndrSeq(JSPUtil.getParameter(request, prefix + "n1st_vndr_seq", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setYdChrCd(JSPUtil.getParameter(request, prefix + "yd_chr_cd", ""));
        setYdFctyTpMrnTmlFlg(JSPUtil.getParameter(request, prefix + "yd_fcty_tp_mrn_tml_flg", ""));
        setYdFctyTpCyFlg(JSPUtil.getParameter(request, prefix + "yd_fcty_tp_cy_flg", ""));
        setYdFctyTpCfsFlg(JSPUtil.getParameter(request, prefix + "yd_fcty_tp_cfs_flg", ""));
        setYdFctyTpRailRmpFlg(JSPUtil.getParameter(request, prefix + "yd_fcty_tp_rail_rmp_fl", ""));
        setYdOshpCd(JSPUtil.getParameter(request, prefix + "yd_oshp_cd", ""));
        setBdYdFlg(JSPUtil.getParameter(request, prefix + "bd_yd_flg", ""));
        setRepZnCd(JSPUtil.getParameter(request, prefix + "rep_zn_cd", ""));
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
        setYdCgoClzHrmntMsg(JSPUtil.getParameter(request, prefix + "yd_cgo_clz_hrmnt_msg", ""));
        setYdRmk(JSPUtil.getParameter(request, prefix + "yd_rmk", ""));
        setBrthNo(JSPUtil.getParameter(request, prefix + "brth_no", ""));
        setYdBrthLen(JSPUtil.getParameter(request, prefix + "yd_brth_len", ""));
        setYdBrthDpthChnlKnt(JSPUtil.getParameter(request, prefix + "yd_brth_dpth_chnl_knt", ""));
        setYdTtlSpc(JSPUtil.getParameter(request, prefix + "yd_ttl_spc", ""));
        setYdActSpc(JSPUtil.getParameter(request, prefix + "yd_act_spc", ""));
        setYdHndlCapa(JSPUtil.getParameter(request, prefix + "yd_hndl_capa", ""));
        setYdRfRcpt440vKnt(JSPUtil.getParameter(request, prefix + "yd_rf_rcpt440v_knt", ""));
        setYdRfRcpt220vKnt(JSPUtil.getParameter(request, prefix + "yd_rf_rcpt220v_knt", ""));
        setYdRfRcptDulKnt(JSPUtil.getParameter(request, prefix + "yd_rf_rcpt_dul_knt", ""));
        setYdOpSysCd(JSPUtil.getParameter(request, prefix + "yd_op_sys_cd", ""));
        setYdInrlFlg(JSPUtil.getParameter(request, prefix + "yd_inrl_flg", ""));
        setYdCfsSpc(JSPUtil.getParameter(request, prefix + "yd_cfs_spc", ""));
        setMnrShopFlg(JSPUtil.getParameter(request, prefix + "mnr_shop_flg", ""));
        setYdHndlYr(JSPUtil.getParameter(request, prefix + "yd_hndl_yr", ""));
        setYdTtlVolTeuKnt(JSPUtil.getParameter(request, prefix + "yd_ttl_vol_teu_knt", ""));
        setYdTtlVolBxKnt(JSPUtil.getParameter(request, prefix + "yd_ttl_vol_bx_knt", ""));
        setYdCoVolTeuKnt(JSPUtil.getParameter(request, prefix + "yd_co_vol_teu_knt", ""));
        setYdCoVolBxKnt(JSPUtil.getParameter(request, prefix + "yd_co_vol_bx_knt", ""));
        setYdPstPgcKnt(JSPUtil.getParameter(request, prefix + "yd_pst_pgc_knt", ""));
        setYdPgcKnt(JSPUtil.getParameter(request, prefix + "yd_pgc_knt", ""));
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
        setN2ndVndrCntCd(JSPUtil.getParameter(request, prefix + "n2nd_vndr_cnt_cd", ""));
        setN2ndVndrSeq(JSPUtil.getParameter(request, prefix + "n2nd_vndr_seq", ""));
        setN3rdVndrCntCd(JSPUtil.getParameter(request, prefix + "n3rd_vndr_cnt_cd", ""));
        setN3rdVndrSeq(JSPUtil.getParameter(request, prefix + "n3rd_vndr_seq", ""));
        setDmdtOfcCd(JSPUtil.getParameter(request, prefix + "dmdt_ofc_cd", ""));
        setRepYdTpCd(JSPUtil.getParameter(request, prefix + "rep_yd_tp_cd", ""));
        setHubYdFlg(JSPUtil.getParameter(request, prefix + "hub_yd_flg", ""));
        setYdLoclLangNm(JSPUtil.getParameter(request, prefix + "yd_locl_lang_nm", ""));
        setYdLoclLangAddr(JSPUtil.getParameter(request, prefix + "yd_locl_lang_addr", ""));
        setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
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

		setOpediInsfId(JSPUtil.getParameter(request, prefix + "opedi_insf_id", ""));
        setOpediInsfDvCd(JSPUtil.getParameter(request, prefix + "opedi_insf_dv_cd", ""));
		setModiYdCd(JSPUtil.getParameter(request, prefix + "modi_yd_cd", ""));
		setYdLat(JSPUtil.getParameter(request, prefix + "yd_lat", ""));
		setYdLon(JSPUtil.getParameter(request, prefix + "yd_lon", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return YardIfVO[]
	 */
    public YardIfVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return YardIfVO[]
	 */
    public YardIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        YardIfVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] ydIfSeq = (JSPUtil.getParameter(request, prefix + "yd_if_seq", length));
            String[] ydCd = (JSPUtil.getParameter(request, prefix + "yd_cd", length));
            String[] ydNm = (JSPUtil.getParameter(request, prefix + "yd_nm", length));
            String[] locCd = (JSPUtil.getParameter(request, prefix + "loc_cd", length));
            String[] eqSccCd = (JSPUtil.getParameter(request, prefix + "eq_scc_cd", length));
            String[] n1stVndrCntCd = (JSPUtil.getParameter(request, prefix + "n1st_vndr_cnt_cd", length));
            String[] n1stVndrSeq = (JSPUtil.getParameter(request, prefix + "n1st_vndr_seq", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] ydChrCd = (JSPUtil.getParameter(request, prefix + "yd_chr_cd", length));
            String[] ydFctyTpMrnTmlFlg = (JSPUtil.getParameter(request, prefix + "yd_fcty_tp_mrn_tml_flg", length));
            String[] ydFctyTpCyFlg = (JSPUtil.getParameter(request, prefix + "yd_fcty_tp_cy_flg", length));
            String[] ydFctyTpCfsFlg = (JSPUtil.getParameter(request, prefix + "yd_fcty_tp_cfs_flg", length));
            String[] ydFctyTpRailRmpFlg = (JSPUtil.getParameter(request, prefix + "yd_fcty_tp_rail_rmp_flg", length));
            String[] ydOshpCd = (JSPUtil.getParameter(request, prefix + "yd_oshp_cd", length));
            String[] bdYdFlg = (JSPUtil.getParameter(request, prefix + "bd_yd_flg", length));
            String[] repZnCd = (JSPUtil.getParameter(request, prefix + "rep_zn_cd", length));
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
            String[] ydCgoClzHrmntMsg = (JSPUtil.getParameter(request, prefix + "yd_cgo_clz_hrmnt_msg", length));
            String[] ydRmk = (JSPUtil.getParameter(request, prefix + "yd_rmk", length));
            String[] brthNo = (JSPUtil.getParameter(request, prefix + "brth_no", length));
            String[] ydBrthLen = (JSPUtil.getParameter(request, prefix + "yd_brth_len", length));
            String[] ydBrthDpthChnlKnt = (JSPUtil.getParameter(request, prefix + "yd_brth_dpth_chnl_knt", length));
            String[] ydTtlSpc = (JSPUtil.getParameter(request, prefix + "yd_ttl_spc", length));
            String[] ydActSpc = (JSPUtil.getParameter(request, prefix + "yd_act_spc", length));
            String[] ydHndlCapa = (JSPUtil.getParameter(request, prefix + "yd_hndl_capa", length));
            String[] ydRfRcpt440vKnt = (JSPUtil.getParameter(request, prefix + "yd_rf_rcpt440v_knt", length));
            String[] ydRfRcpt220vKnt = (JSPUtil.getParameter(request, prefix + "yd_rf_rcpt220v_knt", length));
            String[] ydRfRcptDulKnt = (JSPUtil.getParameter(request, prefix + "yd_rf_rcpt_dul_knt", length));
            String[] ydOpSysCd = (JSPUtil.getParameter(request, prefix + "yd_op_sys_cd", length));
            String[] ydInrlFlg = (JSPUtil.getParameter(request, prefix + "yd_inrl_flg", length));
            String[] ydCfsSpc = (JSPUtil.getParameter(request, prefix + "yd_cfs_spc", length));
            String[] mnrShopFlg = (JSPUtil.getParameter(request, prefix + "mnr_shop_flg", length));
            String[] ydHndlYr = (JSPUtil.getParameter(request, prefix + "yd_hndl_yr", length));
            String[] ydTtlVolTeuKnt = (JSPUtil.getParameter(request, prefix + "yd_ttl_vol_teu_knt", length));
            String[] ydTtlVolBxKnt = (JSPUtil.getParameter(request, prefix + "yd_ttl_vol_bx_knt", length));
            String[] ydCoVolTeuKnt = (JSPUtil.getParameter(request, prefix + "yd_co_vol_teu_knt", length));
            String[] ydCoVolBxKnt = (JSPUtil.getParameter(request, prefix + "yd_co_vol_bx_knt", length));
            String[] ydPstPgcKnt = (JSPUtil.getParameter(request, prefix + "yd_pst_pgc_knt", length));
            String[] ydPgcKnt = (JSPUtil.getParameter(request, prefix + "yd_pgc_knt", length));
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
            String[] n2ndVndrCntCd = (JSPUtil.getParameter(request, prefix + "n2nd_vndr_cnt_cd", length));
            String[] n2ndVndrSeq = (JSPUtil.getParameter(request, prefix + "n2nd_vndr_seq", length));
            String[] n3rdVndrCntCd = (JSPUtil.getParameter(request, prefix + "n3rd_vndr_cnt_cd", length));
            String[] n3rdVndrSeq = (JSPUtil.getParameter(request, prefix + "n3rd_vndr_seq", length));
            String[] dmdtOfcCd = (JSPUtil.getParameter(request, prefix + "dmdt_ofc_cd", length));
            String[] repYdTpCd = (JSPUtil.getParameter(request, prefix + "rep_yd_tp_cd", length));
            String[] hubYdFlg = (JSPUtil.getParameter(request, prefix + "hub_yd_flg", length));
            String[] ydLoclLangNm = (JSPUtil.getParameter(request, prefix + "yd_locl_lang_nm", length));
            String[] ydLoclLangAddr = (JSPUtil.getParameter(request, prefix + "yd_locl_lang_addr", length));
            String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
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

			String[] opediInsfId = (JSPUtil.getParameter(request, prefix	+ "opedi_insf_id", length));
	    	String[] opediInsfDvCd = (JSPUtil.getParameter(request, prefix + "opedi_insf_dv_cd", length));
			String[] modiYdCd = (JSPUtil.getParameter(request, prefix	+ "modi_yd_cd", length));
			
			String[] ydLat = (JSPUtil.getParameter(request, prefix	+ "yd_lat", length));
			String[] ydLon = (JSPUtil.getParameter(request, prefix	+ "yd_lon", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new YardIfVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ydIfSeq[i] != null)
                    model.setYdIfSeq(ydIfSeq[i]);
                if (ydCd[i] != null)
                    model.setYdCd(ydCd[i]);
                if (ydNm[i] != null)
                    model.setYdNm(ydNm[i]);
                if (locCd[i] != null)
                    model.setLocCd(locCd[i]);
                if (eqSccCd[i] != null)
                    model.setEqSccCd(eqSccCd[i]);
                if (n1stVndrCntCd[i] != null)
                    model.setN1stVndrCntCd(n1stVndrCntCd[i]);
                if (n1stVndrSeq[i] != null)
                    model.setN1stVndrSeq(n1stVndrSeq[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
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
                if (repZnCd[i] != null)
                    model.setRepZnCd(repZnCd[i]);
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
                if (ydCgoClzHrmntMsg[i] != null)
                    model.setYdCgoClzHrmntMsg(ydCgoClzHrmntMsg[i]);
                if (ydRmk[i] != null)
                    model.setYdRmk(ydRmk[i]);
                if (brthNo[i] != null)
                    model.setBrthNo(brthNo[i]);
                if (ydBrthLen[i] != null)
                    model.setYdBrthLen(ydBrthLen[i]);
                if (ydBrthDpthChnlKnt[i] != null)
                    model.setYdBrthDpthChnlKnt(ydBrthDpthChnlKnt[i]);
                if (ydTtlSpc[i] != null)
                    model.setYdTtlSpc(ydTtlSpc[i]);
                if (ydActSpc[i] != null)
                    model.setYdActSpc(ydActSpc[i]);
                if (ydHndlCapa[i] != null)
                    model.setYdHndlCapa(ydHndlCapa[i]);
                if (ydRfRcpt440vKnt[i] != null)
                    model.setYdRfRcpt440vKnt(ydRfRcpt440vKnt[i]);
                if (ydRfRcpt220vKnt[i] != null)
                    model.setYdRfRcpt220vKnt(ydRfRcpt220vKnt[i]);
                if (ydRfRcptDulKnt[i] != null)
                    model.setYdRfRcptDulKnt(ydRfRcptDulKnt[i]);
                if (ydOpSysCd[i] != null)
                    model.setYdOpSysCd(ydOpSysCd[i]);
                if (ydInrlFlg[i] != null)
                    model.setYdInrlFlg(ydInrlFlg[i]);
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
                if (ydCoVolTeuKnt[i] != null)
                    model.setYdCoVolTeuKnt(ydCoVolTeuKnt[i]);
                if (ydCoVolBxKnt[i] != null)
                    model.setYdCoVolBxKnt(ydCoVolBxKnt[i]);
                if (ydPstPgcKnt[i] != null)
                    model.setYdPstPgcKnt(ydPstPgcKnt[i]);
                if (ydPgcKnt[i] != null)
                    model.setYdPgcKnt(ydPgcKnt[i]);
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
                if (n2ndVndrCntCd[i] != null)
                    model.setN2ndVndrCntCd(n2ndVndrCntCd[i]);
                if (n2ndVndrSeq[i] != null)
                    model.setN2ndVndrSeq(n2ndVndrSeq[i]);
                if (n3rdVndrCntCd[i] != null)
                    model.setN3rdVndrCntCd(n3rdVndrCntCd[i]);
                if (n3rdVndrSeq[i] != null)
                    model.setN3rdVndrSeq(n3rdVndrSeq[i]);
                if (dmdtOfcCd[i] != null)
                    model.setDmdtOfcCd(dmdtOfcCd[i]);
                if (repYdTpCd[i] != null)
                    model.setRepYdTpCd(repYdTpCd[i]);
                if (hubYdFlg[i] != null)
                    model.setHubYdFlg(hubYdFlg[i]);
                if (ydLoclLangNm[i] != null)
                    model.setYdLoclLangNm(ydLoclLangNm[i]);
                if (ydLoclLangAddr[i] != null)
                    model.setYdLoclLangAddr(ydLoclLangAddr[i]);
                if (deltFlg[i] != null)
                    model.setDeltFlg(deltFlg[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
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
				
				if (opediInsfId[i] != null)
					model.setOpediInsfId(opediInsfId[i]);
				if (opediInsfDvCd[i] != null) 
		    		model.setOpediInsfDvCd(opediInsfDvCd[i]);
				if (modiYdCd[i] != null)
					model.setModiYdCd(modiYdCd[i]);
				if (ydLat[i] != null)
					model.setYdLat(ydLat[i]);
				if (ydLon[i] != null)
					model.setYdLon(ydLon[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getYardIfVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return YardIfVO[]
	 */
    public YardIfVO[] getYardIfVOs() {
        YardIfVO[] vos = (YardIfVO[]) models.toArray(new YardIfVO[models.size()]);
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
        this.ydIfSeq = this.ydIfSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydCd = this.ydCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydNm = this.ydNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locCd = this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqSccCd = this.eqSccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n1stVndrCntCd = this.n1stVndrCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n1stVndrSeq = this.n1stVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydChrCd = this.ydChrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydFctyTpMrnTmlFlg = this.ydFctyTpMrnTmlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydFctyTpCyFlg = this.ydFctyTpCyFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydFctyTpCfsFlg = this.ydFctyTpCfsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydFctyTpRailRmpFlg = this.ydFctyTpRailRmpFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydOshpCd = this.ydOshpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bdYdFlg = this.bdYdFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.repZnCd = this.repZnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
        this.ydCgoClzHrmntMsg = this.ydCgoClzHrmntMsg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydRmk = this.ydRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.brthNo = this.brthNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydBrthLen = this.ydBrthLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydBrthDpthChnlKnt = this.ydBrthDpthChnlKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydTtlSpc = this.ydTtlSpc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydActSpc = this.ydActSpc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydHndlCapa = this.ydHndlCapa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydRfRcpt440vKnt = this.ydRfRcpt440vKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydRfRcpt220vKnt = this.ydRfRcpt220vKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydRfRcptDulKnt = this.ydRfRcptDulKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydOpSysCd = this.ydOpSysCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydInrlFlg = this.ydInrlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydCfsSpc = this.ydCfsSpc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mnrShopFlg = this.mnrShopFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydHndlYr = this.ydHndlYr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydTtlVolTeuKnt = this.ydTtlVolTeuKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydTtlVolBxKnt = this.ydTtlVolBxKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydCoVolTeuKnt = this.ydCoVolTeuKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydCoVolBxKnt = this.ydCoVolBxKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydPstPgcKnt = this.ydPstPgcKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydPgcKnt = this.ydPgcKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
        this.n2ndVndrCntCd = this.n2ndVndrCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n2ndVndrSeq = this.n2ndVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n3rdVndrCntCd = this.n3rdVndrCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n3rdVndrSeq = this.n3rdVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtOfcCd = this.dmdtOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.repYdTpCd = this.repYdTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hubYdFlg = this.hubYdFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydLoclLangNm = this.ydLoclLangNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydLoclLangAddr = this.ydLoclLangAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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

		this.opediInsfId = this.opediInsfId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.opediInsfDvCd = this.opediInsfDvCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiYdCd = this.modiYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydLat = this.ydLat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydLon = this.ydLon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
