/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BkgMdmCustomerVO.java
*@FileTitle : BkgMdmCustomerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class BkgMdmCustomerVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BkgMdmCustomerVO> models = new ArrayList<BkgMdmCustomerVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String custCntCd = null;

    /* Column Info */
    private String custSeq = null;

    /* Column Info */
    private String cntrDivFlg = null;

    /* Column Info */
    private String blkDivFlg = null;

    /* Column Info */
    private String custGrpId = null;

    /* Column Info */
    private String custLglEngNm = null;

    /* Column Info */
    private String custLoclLangNm = null;

    /* Column Info */
    private String custAbbrNm = null;

    /* Column Info */
    private String cntrCustTpCd = null;

    /* Column Info */
    private String blkCustTpCd = null;

    /* Column Info */
    private String indivCorpDivCd = null;

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String fndtDt = null;

    /* Column Info */
    private String custRgstNo = null;

    /* Column Info */
    private String fincStsLvlCd = null;

    /* Column Info */
    private String locCd = null;

    /* Column Info */
    private String capiCurrCd = null;

    /* Column Info */
    private String capiAmt = null;

    /* Column Info */
    private String lstkFlg = null;

    /* Column Info */
    private String empeKnt = null;

    /* Column Info */
    private String vndrSeq = null;

    /* Column Info */
    private String custRmk = null;

    /* Column Info */
    private String vbsClssCd = null;

    /* Column Info */
    private String nbsClssCd1 = null;

    /* Column Info */
    private String nbsClssCd2 = null;

    /* Column Info */
    private String nbsClssCd3 = null;

    /* Column Info */
    private String custStsCd = null;

    /* Column Info */
    private String crmRowId = null;

    /* Column Info */
    private String nvoccCoScacCd = null;

    /* Column Info */
    private String nvoccBdNo = null;

    /* Column Info */
    private String nvoccLicNo = null;

    /* Column Info */
    private String nvoccBdAmt = null;

    /* Column Info */
    private String nvoccBdStEffDt = null;

    /* Column Info */
    private String nvoccBdEndEffDt = null;

    /* Column Info */
    private String indusDesc = null;

    /* Column Info */
    private String crntVolKnt = null;

    /* Column Info */
    private String cmptDesc = null;

    /* Column Info */
    private String spclReqDesc = null;

    /* Column Info */
    private String prfSvcDesc = null;

    /* Column Info */
    private String prfSvcDtlDesc = null;

    /* Column Info */
    private String prfGrpCmdtCd = null;

    /* Column Info */
    private String prfCntrTpszCd = null;

    /* Column Info */
    private String prfRepCmdtCd = null;

    /* Column Info */
    private String srepCd = null;

    /* Column Info */
    private String ctsNo = null;

    /* Column Info */
    private String frtFwrdFmcNo = null;

    /* Column Info */
    private String keyAcctFlg = null;

    /* Column Info */
    private String keyAcctStEffDt = null;

    /* Column Info */
    private String keyAcctEndEffDt = null;

    /* Column Info */
    private String subsCoCd = null;

    /* Column Info */
    private String modiCustCntCd = null;

    /* Column Info */
    private String modiCustSeq = null;

    /* Column Info */
    private String rfndPsdoVndrSeq = null;

    /* Column Info */
    private String bfrOfcCd = null;

    /* Column Info */
    private String bfrOfcCngDt = null;

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
    private String keyAcctMgrUsrId = null;

    /* Column Info */
    private String keyAcctMgrUsrNm = null;

    /* Column Info */
    private String slsDeltEffDt = null;

    /* Column Info */
    private String fletMgmtOwnrCustSeq = null;

    /* Column Info */
    private String invIssCurrTpCd = null;

    /* Column Info */
    private String invIssTpCd = null;

    /* Column Info */
    private String nmdCustFlg = null;

    /* Column Info */
    private String bkgAltRsn = null;

    /* Column Info */
    private String bkgAltFmDt = null;

    /* Column Info */
    private String bkgAltToDt = null;

    /* Column Info */
    private String bkgAltMsg = null;

    /* Column Info */
    private String bkgAltCreUsrId = null;

    /* Column Info */
    private String bkgAltCreDt = null;

    /* Column Info */
    private String eaiIfId = null;

    /* Column Info */
    private String mltTrdAcctFlg = null;

    /* Column Info */
    private String custDivCd = null;

    /* Column Info */
    private String modiCustCd = null;

    /* Column Info */
    private String cnsdCustCntCd = null;

    /* Column Info */
    private String cnsdCustSeq = null;

    /* Column Info */
    private String sprsPayLtrFlg = null;

    /* Column Info */
    private String payRqstLtrFmtCd = null;

    /* Column Info */
    private String invEdiLvlCd = null;

    /* Column Info */
    private String dfltInvCurrDivCd = null;

    /* Column Info */
    private String fwrdCntCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public BkgMdmCustomerVO() {
    }

    public BkgMdmCustomerVO(String ibflag, String pagerows, String custCntCd, String custSeq, String cntrDivFlg, String blkDivFlg, String custGrpId, String custLglEngNm, String custLoclLangNm, String custAbbrNm, String cntrCustTpCd, String blkCustTpCd, String indivCorpDivCd, String ofcCd, String fndtDt, String custRgstNo, String fincStsLvlCd, String locCd, String capiCurrCd, String capiAmt, String lstkFlg, String empeKnt, String vndrSeq, String custRmk, String vbsClssCd, String nbsClssCd1, String nbsClssCd2, String nbsClssCd3, String custStsCd, String crmRowId, String nvoccCoScacCd, String nvoccBdNo, String nvoccLicNo, String nvoccBdAmt, String nvoccBdStEffDt, String nvoccBdEndEffDt, String indusDesc, String crntVolKnt, String cmptDesc, String spclReqDesc, String prfSvcDesc, String prfSvcDtlDesc, String prfGrpCmdtCd, String prfCntrTpszCd, String prfRepCmdtCd, String srepCd, String ctsNo, String frtFwrdFmcNo, String keyAcctFlg, String keyAcctStEffDt, String keyAcctEndEffDt, String subsCoCd, String modiCustCntCd, String modiCustSeq, String rfndPsdoVndrSeq, String bfrOfcCd, String bfrOfcCngDt, String creUsrId, String creDt, String updUsrId, String updDt, String deltFlg, String eaiEvntDt, String keyAcctMgrUsrId, String keyAcctMgrUsrNm, String slsDeltEffDt, String fletMgmtOwnrCustSeq, String invIssCurrTpCd, String invIssTpCd, String nmdCustFlg, String bkgAltRsn, String bkgAltFmDt, String bkgAltToDt, String bkgAltMsg, String bkgAltCreUsrId, String bkgAltCreDt, String eaiIfId, String mltTrdAcctFlg, String custDivCd, String modiCustCd, String cnsdCustCntCd, String cnsdCustSeq, String sprsPayLtrFlg, String payRqstLtrFmtCd, String invEdiLvlCd, String dfltInvCurrDivCd, String fwrdCntCd) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.custCntCd = custCntCd;
        this.custSeq = custSeq;
        this.cntrDivFlg = cntrDivFlg;
        this.blkDivFlg = blkDivFlg;
        this.custGrpId = custGrpId;
        this.custLglEngNm = custLglEngNm;
        this.custLoclLangNm = custLoclLangNm;
        this.custAbbrNm = custAbbrNm;
        this.cntrCustTpCd = cntrCustTpCd;
        this.blkCustTpCd = blkCustTpCd;
        this.indivCorpDivCd = indivCorpDivCd;
        this.ofcCd = ofcCd;
        this.fndtDt = fndtDt;
        this.custRgstNo = custRgstNo;
        this.fincStsLvlCd = fincStsLvlCd;
        this.locCd = locCd;
        this.capiCurrCd = capiCurrCd;
        this.capiAmt = capiAmt;
        this.lstkFlg = lstkFlg;
        this.empeKnt = empeKnt;
        this.vndrSeq = vndrSeq;
        this.custRmk = custRmk;
        this.vbsClssCd = vbsClssCd;
        this.nbsClssCd1 = nbsClssCd1;
        this.nbsClssCd2 = nbsClssCd2;
        this.nbsClssCd3 = nbsClssCd3;
        this.custStsCd = custStsCd;
        this.crmRowId = crmRowId;
        this.nvoccCoScacCd = nvoccCoScacCd;
        this.nvoccBdNo = nvoccBdNo;
        this.nvoccLicNo = nvoccLicNo;
        this.nvoccBdAmt = nvoccBdAmt;
        this.nvoccBdStEffDt = nvoccBdStEffDt;
        this.nvoccBdEndEffDt = nvoccBdEndEffDt;
        this.indusDesc = indusDesc;
        this.crntVolKnt = crntVolKnt;
        this.cmptDesc = cmptDesc;
        this.spclReqDesc = spclReqDesc;
        this.prfSvcDesc = prfSvcDesc;
        this.prfSvcDtlDesc = prfSvcDtlDesc;
        this.prfGrpCmdtCd = prfGrpCmdtCd;
        this.prfCntrTpszCd = prfCntrTpszCd;
        this.prfRepCmdtCd = prfRepCmdtCd;
        this.srepCd = srepCd;
        this.ctsNo = ctsNo;
        this.frtFwrdFmcNo = frtFwrdFmcNo;
        this.keyAcctFlg = keyAcctFlg;
        this.keyAcctStEffDt = keyAcctStEffDt;
        this.keyAcctEndEffDt = keyAcctEndEffDt;
        this.subsCoCd = subsCoCd;
        this.modiCustCntCd = modiCustCntCd;
        this.modiCustSeq = modiCustSeq;
        this.rfndPsdoVndrSeq = rfndPsdoVndrSeq;
        this.bfrOfcCd = bfrOfcCd;
        this.bfrOfcCngDt = bfrOfcCngDt;
        this.creUsrId = creUsrId;
        this.creDt = creDt;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.deltFlg = deltFlg;
        this.eaiEvntDt = eaiEvntDt;
        this.keyAcctMgrUsrId = keyAcctMgrUsrId;
        this.keyAcctMgrUsrNm = keyAcctMgrUsrNm;
        this.slsDeltEffDt = slsDeltEffDt;
        this.fletMgmtOwnrCustSeq = fletMgmtOwnrCustSeq;
        this.invIssCurrTpCd = invIssCurrTpCd;
        this.invIssTpCd = invIssTpCd;
        this.nmdCustFlg = nmdCustFlg;
        this.bkgAltRsn = bkgAltRsn;
        this.bkgAltFmDt = bkgAltFmDt;
        this.bkgAltToDt = bkgAltToDt;
        this.bkgAltMsg = bkgAltMsg;
        this.bkgAltCreUsrId = bkgAltCreUsrId;
        this.bkgAltCreDt = bkgAltCreDt;
        this.eaiIfId = eaiIfId;
        this.mltTrdAcctFlg = mltTrdAcctFlg;
        this.custDivCd = custDivCd;
        this.modiCustCd = modiCustCd;
        this.cnsdCustCntCd = cnsdCustCntCd;
        this.cnsdCustSeq = cnsdCustSeq;
        this.sprsPayLtrFlg = sprsPayLtrFlg;
        this.payRqstLtrFmtCd = payRqstLtrFmtCd;
        this.invEdiLvlCd = invEdiLvlCd;
        this.dfltInvCurrDivCd = dfltInvCurrDivCd;
        this.fwrdCntCd = fwrdCntCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("cust_cnt_cd", getCustCntCd());
        this.hashColumns.put("cust_seq", getCustSeq());
        this.hashColumns.put("cntr_div_flg", getCntrDivFlg());
        this.hashColumns.put("blk_div_flg", getBlkDivFlg());
        this.hashColumns.put("cust_grp_id", getCustGrpId());
        this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
        this.hashColumns.put("cust_locl_lang_nm", getCustLoclLangNm());
        this.hashColumns.put("cust_abbr_nm", getCustAbbrNm());
        this.hashColumns.put("cntr_cust_tp_cd", getCntrCustTpCd());
        this.hashColumns.put("blk_cust_tp_cd", getBlkCustTpCd());
        this.hashColumns.put("indiv_corp_div_cd", getIndivCorpDivCd());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("fndt_dt", getFndtDt());
        this.hashColumns.put("cust_rgst_no", getCustRgstNo());
        this.hashColumns.put("finc_sts_lvl_cd", getFincStsLvlCd());
        this.hashColumns.put("loc_cd", getLocCd());
        this.hashColumns.put("capi_curr_cd", getCapiCurrCd());
        this.hashColumns.put("capi_amt", getCapiAmt());
        this.hashColumns.put("lstk_flg", getLstkFlg());
        this.hashColumns.put("empe_knt", getEmpeKnt());
        this.hashColumns.put("vndr_seq", getVndrSeq());
        this.hashColumns.put("cust_rmk", getCustRmk());
        this.hashColumns.put("vbs_clss_cd", getVbsClssCd());
        this.hashColumns.put("nbs_clss_cd1", getNbsClssCd1());
        this.hashColumns.put("nbs_clss_cd2", getNbsClssCd2());
        this.hashColumns.put("nbs_clss_cd3", getNbsClssCd3());
        this.hashColumns.put("cust_sts_cd", getCustStsCd());
        this.hashColumns.put("crm_row_id", getCrmRowId());
        this.hashColumns.put("nvocc_co_scac_cd", getNvoccCoScacCd());
        this.hashColumns.put("nvocc_bd_no", getNvoccBdNo());
        this.hashColumns.put("nvocc_lic_no", getNvoccLicNo());
        this.hashColumns.put("nvocc_bd_amt", getNvoccBdAmt());
        this.hashColumns.put("nvocc_bd_st_eff_dt", getNvoccBdStEffDt());
        this.hashColumns.put("nvocc_bd_end_eff_dt", getNvoccBdEndEffDt());
        this.hashColumns.put("indus_desc", getIndusDesc());
        this.hashColumns.put("crnt_vol_knt", getCrntVolKnt());
        this.hashColumns.put("cmpt_desc", getCmptDesc());
        this.hashColumns.put("spcl_req_desc", getSpclReqDesc());
        this.hashColumns.put("prf_svc_desc", getPrfSvcDesc());
        this.hashColumns.put("prf_svc_dtl_desc", getPrfSvcDtlDesc());
        this.hashColumns.put("prf_grp_cmdt_cd", getPrfGrpCmdtCd());
        this.hashColumns.put("prf_cntr_tpsz_cd", getPrfCntrTpszCd());
        this.hashColumns.put("prf_rep_cmdt_cd", getPrfRepCmdtCd());
        this.hashColumns.put("srep_cd", getSrepCd());
        this.hashColumns.put("cts_no", getCtsNo());
        this.hashColumns.put("frt_fwrd_fmc_no", getFrtFwrdFmcNo());
        this.hashColumns.put("key_acct_flg", getKeyAcctFlg());
        this.hashColumns.put("key_acct_st_eff_dt", getKeyAcctStEffDt());
        this.hashColumns.put("key_acct_end_eff_dt", getKeyAcctEndEffDt());
        this.hashColumns.put("subs_co_cd", getSubsCoCd());
        this.hashColumns.put("modi_cust_cnt_cd", getModiCustCntCd());
        this.hashColumns.put("modi_cust_seq", getModiCustSeq());
        this.hashColumns.put("rfnd_psdo_vndr_seq", getRfndPsdoVndrSeq());
        this.hashColumns.put("bfr_ofc_cd", getBfrOfcCd());
        this.hashColumns.put("bfr_ofc_cng_dt", getBfrOfcCngDt());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("delt_flg", getDeltFlg());
        this.hashColumns.put("eai_evnt_dt", getEaiEvntDt());
        this.hashColumns.put("key_acct_mgr_usr_id", getKeyAcctMgrUsrId());
        this.hashColumns.put("key_acct_mgr_usr_nm", getKeyAcctMgrUsrNm());
        this.hashColumns.put("sls_delt_eff_dt", getSlsDeltEffDt());
        this.hashColumns.put("flet_mgmt_ownr_cust_seq", getFletMgmtOwnrCustSeq());
        this.hashColumns.put("inv_iss_curr_tp_cd", getInvIssCurrTpCd());
        this.hashColumns.put("inv_iss_tp_cd", getInvIssTpCd());
        this.hashColumns.put("nmd_cust_flg", getNmdCustFlg());
        this.hashColumns.put("bkg_alt_rsn", getBkgAltRsn());
        this.hashColumns.put("bkg_alt_fm_dt", getBkgAltFmDt());
        this.hashColumns.put("bkg_alt_to_dt", getBkgAltToDt());
        this.hashColumns.put("bkg_alt_msg", getBkgAltMsg());
        this.hashColumns.put("bkg_alt_cre_usr_id", getBkgAltCreUsrId());
        this.hashColumns.put("bkg_alt_cre_dt", getBkgAltCreDt());
        this.hashColumns.put("eai_if_id", getEaiIfId());
        this.hashColumns.put("mlt_trd_acct_flg", getMltTrdAcctFlg());
        this.hashColumns.put("cust_div_cd", getCustDivCd());
        this.hashColumns.put("modi_cust_cd", getModiCustCd());
        this.hashColumns.put("cnsd_cust_cnt_cd", getCnsdCustCntCd());
        this.hashColumns.put("cnsd_cust_seq", getCnsdCustSeq());
        this.hashColumns.put("sprs_pay_ltr_flg", getSprsPayLtrFlg());
        this.hashColumns.put("pay_rqst_ltr_fmt_cd", getPayRqstLtrFmtCd());
        this.hashColumns.put("inv_edi_lvl_cd", getInvEdiLvlCd());
        this.hashColumns.put("dflt_inv_curr_div_cd", getDfltInvCurrDivCd());
        this.hashColumns.put("fwrd_cnt_cd", getFwrdCntCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("cust_cnt_cd", "custCntCd");
        this.hashFields.put("cust_seq", "custSeq");
        this.hashFields.put("cntr_div_flg", "cntrDivFlg");
        this.hashFields.put("blk_div_flg", "blkDivFlg");
        this.hashFields.put("cust_grp_id", "custGrpId");
        this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
        this.hashFields.put("cust_locl_lang_nm", "custLoclLangNm");
        this.hashFields.put("cust_abbr_nm", "custAbbrNm");
        this.hashFields.put("cntr_cust_tp_cd", "cntrCustTpCd");
        this.hashFields.put("blk_cust_tp_cd", "blkCustTpCd");
        this.hashFields.put("indiv_corp_div_cd", "indivCorpDivCd");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("fndt_dt", "fndtDt");
        this.hashFields.put("cust_rgst_no", "custRgstNo");
        this.hashFields.put("finc_sts_lvl_cd", "fincStsLvlCd");
        this.hashFields.put("loc_cd", "locCd");
        this.hashFields.put("capi_curr_cd", "capiCurrCd");
        this.hashFields.put("capi_amt", "capiAmt");
        this.hashFields.put("lstk_flg", "lstkFlg");
        this.hashFields.put("empe_knt", "empeKnt");
        this.hashFields.put("vndr_seq", "vndrSeq");
        this.hashFields.put("cust_rmk", "custRmk");
        this.hashFields.put("vbs_clss_cd", "vbsClssCd");
        this.hashFields.put("nbs_clss_cd1", "nbsClssCd1");
        this.hashFields.put("nbs_clss_cd2", "nbsClssCd2");
        this.hashFields.put("nbs_clss_cd3", "nbsClssCd3");
        this.hashFields.put("cust_sts_cd", "custStsCd");
        this.hashFields.put("crm_row_id", "crmRowId");
        this.hashFields.put("nvocc_co_scac_cd", "nvoccCoScacCd");
        this.hashFields.put("nvocc_bd_no", "nvoccBdNo");
        this.hashFields.put("nvocc_lic_no", "nvoccLicNo");
        this.hashFields.put("nvocc_bd_amt", "nvoccBdAmt");
        this.hashFields.put("nvocc_bd_st_eff_dt", "nvoccBdStEffDt");
        this.hashFields.put("nvocc_bd_end_eff_dt", "nvoccBdEndEffDt");
        this.hashFields.put("indus_desc", "indusDesc");
        this.hashFields.put("crnt_vol_knt", "crntVolKnt");
        this.hashFields.put("cmpt_desc", "cmptDesc");
        this.hashFields.put("spcl_req_desc", "spclReqDesc");
        this.hashFields.put("prf_svc_desc", "prfSvcDesc");
        this.hashFields.put("prf_svc_dtl_desc", "prfSvcDtlDesc");
        this.hashFields.put("prf_grp_cmdt_cd", "prfGrpCmdtCd");
        this.hashFields.put("prf_cntr_tpsz_cd", "prfCntrTpszCd");
        this.hashFields.put("prf_rep_cmdt_cd", "prfRepCmdtCd");
        this.hashFields.put("srep_cd", "srepCd");
        this.hashFields.put("cts_no", "ctsNo");
        this.hashFields.put("frt_fwrd_fmc_no", "frtFwrdFmcNo");
        this.hashFields.put("key_acct_flg", "keyAcctFlg");
        this.hashFields.put("key_acct_st_eff_dt", "keyAcctStEffDt");
        this.hashFields.put("key_acct_end_eff_dt", "keyAcctEndEffDt");
        this.hashFields.put("subs_co_cd", "subsCoCd");
        this.hashFields.put("modi_cust_cnt_cd", "modiCustCntCd");
        this.hashFields.put("modi_cust_seq", "modiCustSeq");
        this.hashFields.put("rfnd_psdo_vndr_seq", "rfndPsdoVndrSeq");
        this.hashFields.put("bfr_ofc_cd", "bfrOfcCd");
        this.hashFields.put("bfr_ofc_cng_dt", "bfrOfcCngDt");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("delt_flg", "deltFlg");
        this.hashFields.put("eai_evnt_dt", "eaiEvntDt");
        this.hashFields.put("key_acct_mgr_usr_id", "keyAcctMgrUsrId");
        this.hashFields.put("key_acct_mgr_usr_nm", "keyAcctMgrUsrNm");
        this.hashFields.put("sls_delt_eff_dt", "slsDeltEffDt");
        this.hashFields.put("flet_mgmt_ownr_cust_seq", "fletMgmtOwnrCustSeq");
        this.hashFields.put("inv_iss_curr_tp_cd", "invIssCurrTpCd");
        this.hashFields.put("inv_iss_tp_cd", "invIssTpCd");
        this.hashFields.put("nmd_cust_flg", "nmdCustFlg");
        this.hashFields.put("bkg_alt_rsn", "bkgAltRsn");
        this.hashFields.put("bkg_alt_fm_dt", "bkgAltFmDt");
        this.hashFields.put("bkg_alt_to_dt", "bkgAltToDt");
        this.hashFields.put("bkg_alt_msg", "bkgAltMsg");
        this.hashFields.put("bkg_alt_cre_usr_id", "bkgAltCreUsrId");
        this.hashFields.put("bkg_alt_cre_dt", "bkgAltCreDt");
        this.hashFields.put("eai_if_id", "eaiIfId");
        this.hashFields.put("mlt_trd_acct_flg", "mltTrdAcctFlg");
        this.hashFields.put("cust_div_cd", "custDivCd");
        this.hashFields.put("modi_cust_cd", "modiCustCd");
        this.hashFields.put("cnsd_cust_cnt_cd", "cnsdCustCntCd");
        this.hashFields.put("cnsd_cust_seq", "cnsdCustSeq");
        this.hashFields.put("sprs_pay_ltr_flg", "sprsPayLtrFlg");
        this.hashFields.put("pay_rqst_ltr_fmt_cd", "payRqstLtrFmtCd");
        this.hashFields.put("inv_edi_lvl_cd", "invEdiLvlCd");
        this.hashFields.put("dflt_inv_curr_div_cd", "dfltInvCurrDivCd");
        this.hashFields.put("fwrd_cnt_cd", "fwrdCntCd");
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
	 * @param String custCntCd
	 */
    public void setCustCntCd(String custCntCd) {
        this.custCntCd = custCntCd;
    }

    /**
	 * 
	 * @return String custCntCd
	 */
    public String getCustCntCd() {
        return this.custCntCd;
    }

    /**
	 *
	 * @param String custSeq
	 */
    public void setCustSeq(String custSeq) {
        this.custSeq = custSeq;
    }

    /**
	 * 
	 * @return String custSeq
	 */
    public String getCustSeq() {
        return this.custSeq;
    }

    /**
	 *
	 * @param String cntrDivFlg
	 */
    public void setCntrDivFlg(String cntrDivFlg) {
        this.cntrDivFlg = cntrDivFlg;
    }

    /**
	 * 
	 * @return String cntrDivFlg
	 */
    public String getCntrDivFlg() {
        return this.cntrDivFlg;
    }

    /**
	 *
	 * @param String blkDivFlg
	 */
    public void setBlkDivFlg(String blkDivFlg) {
        this.blkDivFlg = blkDivFlg;
    }

    /**
	 * 
	 * @return String blkDivFlg
	 */
    public String getBlkDivFlg() {
        return this.blkDivFlg;
    }

    /**
	 *
	 * @param String custGrpId
	 */
    public void setCustGrpId(String custGrpId) {
        this.custGrpId = custGrpId;
    }

    /**
	 * 
	 * @return String custGrpId
	 */
    public String getCustGrpId() {
        return this.custGrpId;
    }

    /**
	 *
	 * @param String custLglEngNm
	 */
    public void setCustLglEngNm(String custLglEngNm) {
        this.custLglEngNm = custLglEngNm;
    }

    /**
	 * 
	 * @return String custLglEngNm
	 */
    public String getCustLglEngNm() {
        return this.custLglEngNm;
    }

    /**
	 *
	 * @param String custLoclLangNm
	 */
    public void setCustLoclLangNm(String custLoclLangNm) {
        this.custLoclLangNm = custLoclLangNm;
    }

    /**
	 * 
	 * @return String custLoclLangNm
	 */
    public String getCustLoclLangNm() {
        return this.custLoclLangNm;
    }

    /**
	 *
	 * @param String custAbbrNm
	 */
    public void setCustAbbrNm(String custAbbrNm) {
        this.custAbbrNm = custAbbrNm;
    }

    /**
	 * 
	 * @return String custAbbrNm
	 */
    public String getCustAbbrNm() {
        return this.custAbbrNm;
    }

    /**
	 *
	 * @param String cntrCustTpCd
	 */
    public void setCntrCustTpCd(String cntrCustTpCd) {
        this.cntrCustTpCd = cntrCustTpCd;
    }

    /**
	 * 
	 * @return String cntrCustTpCd
	 */
    public String getCntrCustTpCd() {
        return this.cntrCustTpCd;
    }

    /**
	 *
	 * @param String blkCustTpCd
	 */
    public void setBlkCustTpCd(String blkCustTpCd) {
        this.blkCustTpCd = blkCustTpCd;
    }

    /**
	 * 
	 * @return String blkCustTpCd
	 */
    public String getBlkCustTpCd() {
        return this.blkCustTpCd;
    }

    /**
	 *
	 * @param String indivCorpDivCd
	 */
    public void setIndivCorpDivCd(String indivCorpDivCd) {
        this.indivCorpDivCd = indivCorpDivCd;
    }

    /**
	 * 
	 * @return String indivCorpDivCd
	 */
    public String getIndivCorpDivCd() {
        return this.indivCorpDivCd;
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
	 * @param String fndtDt
	 */
    public void setFndtDt(String fndtDt) {
        this.fndtDt = fndtDt;
    }

    /**
	 * 
	 * @return String fndtDt
	 */
    public String getFndtDt() {
        return this.fndtDt;
    }

    /**
	 *
	 * @param String custRgstNo
	 */
    public void setCustRgstNo(String custRgstNo) {
        this.custRgstNo = custRgstNo;
    }

    /**
	 * 
	 * @return String custRgstNo
	 */
    public String getCustRgstNo() {
        return this.custRgstNo;
    }

    /**
	 *
	 * @param String fincStsLvlCd
	 */
    public void setFincStsLvlCd(String fincStsLvlCd) {
        this.fincStsLvlCd = fincStsLvlCd;
    }

    /**
	 * 
	 * @return String fincStsLvlCd
	 */
    public String getFincStsLvlCd() {
        return this.fincStsLvlCd;
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
	 * @param String capiCurrCd
	 */
    public void setCapiCurrCd(String capiCurrCd) {
        this.capiCurrCd = capiCurrCd;
    }

    /**
	 * 
	 * @return String capiCurrCd
	 */
    public String getCapiCurrCd() {
        return this.capiCurrCd;
    }

    /**
	 *
	 * @param String capiAmt
	 */
    public void setCapiAmt(String capiAmt) {
        this.capiAmt = capiAmt;
    }

    /**
	 * 
	 * @return String capiAmt
	 */
    public String getCapiAmt() {
        return this.capiAmt;
    }

    /**
	 *
	 * @param String lstkFlg
	 */
    public void setLstkFlg(String lstkFlg) {
        this.lstkFlg = lstkFlg;
    }

    /**
	 * 
	 * @return String lstkFlg
	 */
    public String getLstkFlg() {
        return this.lstkFlg;
    }

    /**
	 *
	 * @param String empeKnt
	 */
    public void setEmpeKnt(String empeKnt) {
        this.empeKnt = empeKnt;
    }

    /**
	 * 
	 * @return String empeKnt
	 */
    public String getEmpeKnt() {
        return this.empeKnt;
    }

    /**
	 *
	 * @param String vndrSeq
	 */
    public void setVndrSeq(String vndrSeq) {
        this.vndrSeq = vndrSeq;
    }

    /**
	 * 
	 * @return String vndrSeq
	 */
    public String getVndrSeq() {
        return this.vndrSeq;
    }

    /**
	 *
	 * @param String custRmk
	 */
    public void setCustRmk(String custRmk) {
        this.custRmk = custRmk;
    }

    /**
	 * 
	 * @return String custRmk
	 */
    public String getCustRmk() {
        return this.custRmk;
    }

    /**
	 *
	 * @param String vbsClssCd
	 */
    public void setVbsClssCd(String vbsClssCd) {
        this.vbsClssCd = vbsClssCd;
    }

    /**
	 * 
	 * @return String vbsClssCd
	 */
    public String getVbsClssCd() {
        return this.vbsClssCd;
    }

    /**
	 *
	 * @param String nbsClssCd1
	 */
    public void setNbsClssCd1(String nbsClssCd1) {
        this.nbsClssCd1 = nbsClssCd1;
    }

    /**
	 * 
	 * @return String nbsClssCd1
	 */
    public String getNbsClssCd1() {
        return this.nbsClssCd1;
    }

    /**
	 *
	 * @param String nbsClssCd2
	 */
    public void setNbsClssCd2(String nbsClssCd2) {
        this.nbsClssCd2 = nbsClssCd2;
    }

    /**
	 * 
	 * @return String nbsClssCd2
	 */
    public String getNbsClssCd2() {
        return this.nbsClssCd2;
    }

    /**
	 *
	 * @param String nbsClssCd3
	 */
    public void setNbsClssCd3(String nbsClssCd3) {
        this.nbsClssCd3 = nbsClssCd3;
    }

    /**
	 * 
	 * @return String nbsClssCd3
	 */
    public String getNbsClssCd3() {
        return this.nbsClssCd3;
    }

    /**
	 *
	 * @param String custStsCd
	 */
    public void setCustStsCd(String custStsCd) {
        this.custStsCd = custStsCd;
    }

    /**
	 * 
	 * @return String custStsCd
	 */
    public String getCustStsCd() {
        return this.custStsCd;
    }

    /**
	 *
	 * @param String crmRowId
	 */
    public void setCrmRowId(String crmRowId) {
        this.crmRowId = crmRowId;
    }

    /**
	 * 
	 * @return String crmRowId
	 */
    public String getCrmRowId() {
        return this.crmRowId;
    }

    /**
	 *
	 * @param String nvoccCoScacCd
	 */
    public void setNvoccCoScacCd(String nvoccCoScacCd) {
        this.nvoccCoScacCd = nvoccCoScacCd;
    }

    /**
	 * 
	 * @return String nvoccCoScacCd
	 */
    public String getNvoccCoScacCd() {
        return this.nvoccCoScacCd;
    }

    /**
	 *
	 * @param String nvoccBdNo
	 */
    public void setNvoccBdNo(String nvoccBdNo) {
        this.nvoccBdNo = nvoccBdNo;
    }

    /**
	 * 
	 * @return String nvoccBdNo
	 */
    public String getNvoccBdNo() {
        return this.nvoccBdNo;
    }

    /**
	 *
	 * @param String nvoccLicNo
	 */
    public void setNvoccLicNo(String nvoccLicNo) {
        this.nvoccLicNo = nvoccLicNo;
    }

    /**
	 * 
	 * @return String nvoccLicNo
	 */
    public String getNvoccLicNo() {
        return this.nvoccLicNo;
    }

    /**
	 *
	 * @param String nvoccBdAmt
	 */
    public void setNvoccBdAmt(String nvoccBdAmt) {
        this.nvoccBdAmt = nvoccBdAmt;
    }

    /**
	 * 
	 * @return String nvoccBdAmt
	 */
    public String getNvoccBdAmt() {
        return this.nvoccBdAmt;
    }

    /**
	 *
	 * @param String nvoccBdStEffDt
	 */
    public void setNvoccBdStEffDt(String nvoccBdStEffDt) {
        this.nvoccBdStEffDt = nvoccBdStEffDt;
    }

    /**
	 * 
	 * @return String nvoccBdStEffDt
	 */
    public String getNvoccBdStEffDt() {
        return this.nvoccBdStEffDt;
    }

    /**
	 *
	 * @param String nvoccBdEndEffDt
	 */
    public void setNvoccBdEndEffDt(String nvoccBdEndEffDt) {
        this.nvoccBdEndEffDt = nvoccBdEndEffDt;
    }

    /**
	 * 
	 * @return String nvoccBdEndEffDt
	 */
    public String getNvoccBdEndEffDt() {
        return this.nvoccBdEndEffDt;
    }

    /**
	 *
	 * @param String indusDesc
	 */
    public void setIndusDesc(String indusDesc) {
        this.indusDesc = indusDesc;
    }

    /**
	 * 
	 * @return String indusDesc
	 */
    public String getIndusDesc() {
        return this.indusDesc;
    }

    /**
	 *
	 * @param String crntVolKnt
	 */
    public void setCrntVolKnt(String crntVolKnt) {
        this.crntVolKnt = crntVolKnt;
    }

    /**
	 * 
	 * @return String crntVolKnt
	 */
    public String getCrntVolKnt() {
        return this.crntVolKnt;
    }

    /**
	 *
	 * @param String cmptDesc
	 */
    public void setCmptDesc(String cmptDesc) {
        this.cmptDesc = cmptDesc;
    }

    /**
	 * 
	 * @return String cmptDesc
	 */
    public String getCmptDesc() {
        return this.cmptDesc;
    }

    /**
	 *
	 * @param String spclReqDesc
	 */
    public void setSpclReqDesc(String spclReqDesc) {
        this.spclReqDesc = spclReqDesc;
    }

    /**
	 * 
	 * @return String spclReqDesc
	 */
    public String getSpclReqDesc() {
        return this.spclReqDesc;
    }

    /**
	 *
	 * @param String prfSvcDesc
	 */
    public void setPrfSvcDesc(String prfSvcDesc) {
        this.prfSvcDesc = prfSvcDesc;
    }

    /**
	 * 
	 * @return String prfSvcDesc
	 */
    public String getPrfSvcDesc() {
        return this.prfSvcDesc;
    }

    /**
	 *
	 * @param String prfSvcDtlDesc
	 */
    public void setPrfSvcDtlDesc(String prfSvcDtlDesc) {
        this.prfSvcDtlDesc = prfSvcDtlDesc;
    }

    /**
	 * 
	 * @return String prfSvcDtlDesc
	 */
    public String getPrfSvcDtlDesc() {
        return this.prfSvcDtlDesc;
    }

    /**
	 *
	 * @param String prfGrpCmdtCd
	 */
    public void setPrfGrpCmdtCd(String prfGrpCmdtCd) {
        this.prfGrpCmdtCd = prfGrpCmdtCd;
    }

    /**
	 * 
	 * @return String prfGrpCmdtCd
	 */
    public String getPrfGrpCmdtCd() {
        return this.prfGrpCmdtCd;
    }

    /**
	 *
	 * @param String prfCntrTpszCd
	 */
    public void setPrfCntrTpszCd(String prfCntrTpszCd) {
        this.prfCntrTpszCd = prfCntrTpszCd;
    }

    /**
	 * 
	 * @return String prfCntrTpszCd
	 */
    public String getPrfCntrTpszCd() {
        return this.prfCntrTpszCd;
    }

    /**
	 *
	 * @param String prfRepCmdtCd
	 */
    public void setPrfRepCmdtCd(String prfRepCmdtCd) {
        this.prfRepCmdtCd = prfRepCmdtCd;
    }

    /**
	 * 
	 * @return String prfRepCmdtCd
	 */
    public String getPrfRepCmdtCd() {
        return this.prfRepCmdtCd;
    }

    /**
	 *
	 * @param String srepCd
	 */
    public void setSrepCd(String srepCd) {
        this.srepCd = srepCd;
    }

    /**
	 * 
	 * @return String srepCd
	 */
    public String getSrepCd() {
        return this.srepCd;
    }

    /**
	 *
	 * @param String ctsNo
	 */
    public void setCtsNo(String ctsNo) {
        this.ctsNo = ctsNo;
    }

    /**
	 * 
	 * @return String ctsNo
	 */
    public String getCtsNo() {
        return this.ctsNo;
    }

    /**
	 *
	 * @param String frtFwrdFmcNo
	 */
    public void setFrtFwrdFmcNo(String frtFwrdFmcNo) {
        this.frtFwrdFmcNo = frtFwrdFmcNo;
    }

    /**
	 * 
	 * @return String frtFwrdFmcNo
	 */
    public String getFrtFwrdFmcNo() {
        return this.frtFwrdFmcNo;
    }

    /**
	 *
	 * @param String keyAcctFlg
	 */
    public void setKeyAcctFlg(String keyAcctFlg) {
        this.keyAcctFlg = keyAcctFlg;
    }

    /**
	 * 
	 * @return String keyAcctFlg
	 */
    public String getKeyAcctFlg() {
        return this.keyAcctFlg;
    }

    /**
	 *
	 * @param String keyAcctStEffDt
	 */
    public void setKeyAcctStEffDt(String keyAcctStEffDt) {
        this.keyAcctStEffDt = keyAcctStEffDt;
    }

    /**
	 * 
	 * @return String keyAcctStEffDt
	 */
    public String getKeyAcctStEffDt() {
        return this.keyAcctStEffDt;
    }

    /**
	 *
	 * @param String keyAcctEndEffDt
	 */
    public void setKeyAcctEndEffDt(String keyAcctEndEffDt) {
        this.keyAcctEndEffDt = keyAcctEndEffDt;
    }

    /**
	 * 
	 * @return String keyAcctEndEffDt
	 */
    public String getKeyAcctEndEffDt() {
        return this.keyAcctEndEffDt;
    }

    /**
	 *
	 * @param String subsCoCd
	 */
    public void setSubsCoCd(String subsCoCd) {
        this.subsCoCd = subsCoCd;
    }

    /**
	 * 
	 * @return String subsCoCd
	 */
    public String getSubsCoCd() {
        return this.subsCoCd;
    }

    /**
	 *
	 * @param String modiCustCntCd
	 */
    public void setModiCustCntCd(String modiCustCntCd) {
        this.modiCustCntCd = modiCustCntCd;
    }

    /**
	 * 
	 * @return String modiCustCntCd
	 */
    public String getModiCustCntCd() {
        return this.modiCustCntCd;
    }

    /**
	 *
	 * @param String modiCustSeq
	 */
    public void setModiCustSeq(String modiCustSeq) {
        this.modiCustSeq = modiCustSeq;
    }

    /**
	 * 
	 * @return String modiCustSeq
	 */
    public String getModiCustSeq() {
        return this.modiCustSeq;
    }

    /**
	 *
	 * @param String rfndPsdoVndrSeq
	 */
    public void setRfndPsdoVndrSeq(String rfndPsdoVndrSeq) {
        this.rfndPsdoVndrSeq = rfndPsdoVndrSeq;
    }

    /**
	 * 
	 * @return String rfndPsdoVndrSeq
	 */
    public String getRfndPsdoVndrSeq() {
        return this.rfndPsdoVndrSeq;
    }

    /**
	 *
	 * @param String bfrOfcCd
	 */
    public void setBfrOfcCd(String bfrOfcCd) {
        this.bfrOfcCd = bfrOfcCd;
    }

    /**
	 * 
	 * @return String bfrOfcCd
	 */
    public String getBfrOfcCd() {
        return this.bfrOfcCd;
    }

    /**
	 *
	 * @param String bfrOfcCngDt
	 */
    public void setBfrOfcCngDt(String bfrOfcCngDt) {
        this.bfrOfcCngDt = bfrOfcCngDt;
    }

    /**
	 * 
	 * @return String bfrOfcCngDt
	 */
    public String getBfrOfcCngDt() {
        return this.bfrOfcCngDt;
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
	 * @param String keyAcctMgrUsrId
	 */
    public void setKeyAcctMgrUsrId(String keyAcctMgrUsrId) {
        this.keyAcctMgrUsrId = keyAcctMgrUsrId;
    }

    /**
	 * 
	 * @return String keyAcctMgrUsrId
	 */
    public String getKeyAcctMgrUsrId() {
        return this.keyAcctMgrUsrId;
    }

    /**
	 *
	 * @param String keyAcctMgrUsrNm
	 */
    public void setKeyAcctMgrUsrNm(String keyAcctMgrUsrNm) {
        this.keyAcctMgrUsrNm = keyAcctMgrUsrNm;
    }

    /**
	 * 
	 * @return String keyAcctMgrUsrNm
	 */
    public String getKeyAcctMgrUsrNm() {
        return this.keyAcctMgrUsrNm;
    }

    /**
	 *
	 * @param String slsDeltEffDt
	 */
    public void setSlsDeltEffDt(String slsDeltEffDt) {
        this.slsDeltEffDt = slsDeltEffDt;
    }

    /**
	 * 
	 * @return String slsDeltEffDt
	 */
    public String getSlsDeltEffDt() {
        return this.slsDeltEffDt;
    }

    /**
	 *
	 * @param String fletMgmtOwnrCustSeq
	 */
    public void setFletMgmtOwnrCustSeq(String fletMgmtOwnrCustSeq) {
        this.fletMgmtOwnrCustSeq = fletMgmtOwnrCustSeq;
    }

    /**
	 * 
	 * @return String fletMgmtOwnrCustSeq
	 */
    public String getFletMgmtOwnrCustSeq() {
        return this.fletMgmtOwnrCustSeq;
    }

    /**
	 *
	 * @param String invIssCurrTpCd
	 */
    public void setInvIssCurrTpCd(String invIssCurrTpCd) {
        this.invIssCurrTpCd = invIssCurrTpCd;
    }

    /**
	 * 
	 * @return String invIssCurrTpCd
	 */
    public String getInvIssCurrTpCd() {
        return this.invIssCurrTpCd;
    }

    /**
	 *
	 * @param String invIssTpCd
	 */
    public void setInvIssTpCd(String invIssTpCd) {
        this.invIssTpCd = invIssTpCd;
    }

    /**
	 * 
	 * @return String invIssTpCd
	 */
    public String getInvIssTpCd() {
        return this.invIssTpCd;
    }

    /**
	 *
	 * @param String nmdCustFlg
	 */
    public void setNmdCustFlg(String nmdCustFlg) {
        this.nmdCustFlg = nmdCustFlg;
    }

    /**
	 * 
	 * @return String nmdCustFlg
	 */
    public String getNmdCustFlg() {
        return this.nmdCustFlg;
    }

    /**
	 *
	 * @param String bkgAltRsn
	 */
    public void setBkgAltRsn(String bkgAltRsn) {
        this.bkgAltRsn = bkgAltRsn;
    }

    /**
	 * 
	 * @return String bkgAltRsn
	 */
    public String getBkgAltRsn() {
        return this.bkgAltRsn;
    }

    /**
	 *
	 * @param String bkgAltFmDt
	 */
    public void setBkgAltFmDt(String bkgAltFmDt) {
        this.bkgAltFmDt = bkgAltFmDt;
    }

    /**
	 * 
	 * @return String bkgAltFmDt
	 */
    public String getBkgAltFmDt() {
        return this.bkgAltFmDt;
    }

    /**
	 *
	 * @param String bkgAltToDt
	 */
    public void setBkgAltToDt(String bkgAltToDt) {
        this.bkgAltToDt = bkgAltToDt;
    }

    /**
	 * 
	 * @return String bkgAltToDt
	 */
    public String getBkgAltToDt() {
        return this.bkgAltToDt;
    }

    /**
	 *
	 * @param String bkgAltMsg
	 */
    public void setBkgAltMsg(String bkgAltMsg) {
        this.bkgAltMsg = bkgAltMsg;
    }

    /**
	 * 
	 * @return String bkgAltMsg
	 */
    public String getBkgAltMsg() {
        return this.bkgAltMsg;
    }

    /**
	 *
	 * @param String bkgAltCreUsrId
	 */
    public void setBkgAltCreUsrId(String bkgAltCreUsrId) {
        this.bkgAltCreUsrId = bkgAltCreUsrId;
    }

    /**
	 * 
	 * @return String bkgAltCreUsrId
	 */
    public String getBkgAltCreUsrId() {
        return this.bkgAltCreUsrId;
    }

    /**
	 *
	 * @param String bkgAltCreDt
	 */
    public void setBkgAltCreDt(String bkgAltCreDt) {
        this.bkgAltCreDt = bkgAltCreDt;
    }

    /**
	 * 
	 * @return String bkgAltCreDt
	 */
    public String getBkgAltCreDt() {
        return this.bkgAltCreDt;
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
	 * @param String mltTrdAcctFlg
	 */
    public void setMltTrdAcctFlg(String mltTrdAcctFlg) {
        this.mltTrdAcctFlg = mltTrdAcctFlg;
    }

    /**
	 * 
	 * @return String mltTrdAcctFlg
	 */
    public String getMltTrdAcctFlg() {
        return this.mltTrdAcctFlg;
    }

    /**
	 *
	 * @param String custDivCd
	 */
    public void setCustDivCd(String custDivCd) {
        this.custDivCd = custDivCd;
    }

    /**
	 * 
	 * @return String custDivCd
	 */
    public String getCustDivCd() {
        return this.custDivCd;
    }

    /**
	 *
	 * @param String modiCustCd
	 */
    public void setModiCustCd(String modiCustCd) {
        this.modiCustCd = modiCustCd;
    }

    /**
	 * 
	 * @return String modiCustCd
	 */
    public String getModiCustCd() {
        return this.modiCustCd;
    }

    /**
	 *
	 * @param String cnsdCustCntCd
	 */
    public void setCnsdCustCntCd(String cnsdCustCntCd) {
        this.cnsdCustCntCd = cnsdCustCntCd;
    }

    /**
	 * 
	 * @return String cnsdCustCntCd
	 */
    public String getCnsdCustCntCd() {
        return this.cnsdCustCntCd;
    }

    /**
	 *
	 * @param String cnsdCustSeq
	 */
    public void setCnsdCustSeq(String cnsdCustSeq) {
        this.cnsdCustSeq = cnsdCustSeq;
    }

    /**
	 * 
	 * @return String cnsdCustSeq
	 */
    public String getCnsdCustSeq() {
        return this.cnsdCustSeq;
    }

    /**
	 *
	 * @param String sprsPayLtrFlg
	 */
    public void setSprsPayLtrFlg(String sprsPayLtrFlg) {
        this.sprsPayLtrFlg = sprsPayLtrFlg;
    }

    /**
	 * 
	 * @return String sprsPayLtrFlg
	 */
    public String getSprsPayLtrFlg() {
        return this.sprsPayLtrFlg;
    }

    /**
	 *
	 * @param String payRqstLtrFmtCd
	 */
    public void setPayRqstLtrFmtCd(String payRqstLtrFmtCd) {
        this.payRqstLtrFmtCd = payRqstLtrFmtCd;
    }

    /**
	 * 
	 * @return String payRqstLtrFmtCd
	 */
    public String getPayRqstLtrFmtCd() {
        return this.payRqstLtrFmtCd;
    }

    /**
	 *
	 * @param String invEdiLvlCd
	 */
    public void setInvEdiLvlCd(String invEdiLvlCd) {
        this.invEdiLvlCd = invEdiLvlCd;
    }

    /**
	 * 
	 * @return String invEdiLvlCd
	 */
    public String getInvEdiLvlCd() {
        return this.invEdiLvlCd;
    }

    /**
	 *
	 * @param String dfltInvCurrDivCd
	 */
    public void setDfltInvCurrDivCd(String dfltInvCurrDivCd) {
        this.dfltInvCurrDivCd = dfltInvCurrDivCd;
    }

    /**
	 * 
	 * @return String dfltInvCurrDivCd
	 */
    public String getDfltInvCurrDivCd() {
        return this.dfltInvCurrDivCd;
    }

    public void setFwrdCntCd(String fwrdCntCd) {
        this.fwrdCntCd = fwrdCntCd;
    }

    public String getFwrdCntCd() {
        return this.fwrdCntCd;
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
        setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
        setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
        setCntrDivFlg(JSPUtil.getParameter(request, prefix + "cntr_div_flg", ""));
        setBlkDivFlg(JSPUtil.getParameter(request, prefix + "blk_div_flg", ""));
        setCustGrpId(JSPUtil.getParameter(request, prefix + "cust_grp_id", ""));
        setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
        setCustLoclLangNm(JSPUtil.getParameter(request, prefix + "cust_locl_lang_nm", ""));
        setCustAbbrNm(JSPUtil.getParameter(request, prefix + "cust_abbr_nm", ""));
        setCntrCustTpCd(JSPUtil.getParameter(request, prefix + "cntr_cust_tp_cd", ""));
        setBlkCustTpCd(JSPUtil.getParameter(request, prefix + "blk_cust_tp_cd", ""));
        setIndivCorpDivCd(JSPUtil.getParameter(request, prefix + "indiv_corp_div_cd", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setFndtDt(JSPUtil.getParameter(request, prefix + "fndt_dt", ""));
        setCustRgstNo(JSPUtil.getParameter(request, prefix + "cust_rgst_no", ""));
        setFincStsLvlCd(JSPUtil.getParameter(request, prefix + "finc_sts_lvl_cd", ""));
        setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
        setCapiCurrCd(JSPUtil.getParameter(request, prefix + "capi_curr_cd", ""));
        setCapiAmt(JSPUtil.getParameter(request, prefix + "capi_amt", ""));
        setLstkFlg(JSPUtil.getParameter(request, prefix + "lstk_flg", ""));
        setEmpeKnt(JSPUtil.getParameter(request, prefix + "empe_knt", ""));
        setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
        setCustRmk(JSPUtil.getParameter(request, prefix + "cust_rmk", ""));
        setVbsClssCd(JSPUtil.getParameter(request, prefix + "vbs_clss_cd", ""));
        setNbsClssCd1(JSPUtil.getParameter(request, prefix + "nbs_clss_cd1", ""));
        setNbsClssCd2(JSPUtil.getParameter(request, prefix + "nbs_clss_cd2", ""));
        setNbsClssCd3(JSPUtil.getParameter(request, prefix + "nbs_clss_cd3", ""));
        setCustStsCd(JSPUtil.getParameter(request, prefix + "cust_sts_cd", ""));
        setCrmRowId(JSPUtil.getParameter(request, prefix + "crm_row_id", ""));
        setNvoccCoScacCd(JSPUtil.getParameter(request, prefix + "nvocc_co_scac_cd", ""));
        setNvoccBdNo(JSPUtil.getParameter(request, prefix + "nvocc_bd_no", ""));
        setNvoccLicNo(JSPUtil.getParameter(request, prefix + "nvocc_lic_no", ""));
        setNvoccBdAmt(JSPUtil.getParameter(request, prefix + "nvocc_bd_amt", ""));
        setNvoccBdStEffDt(JSPUtil.getParameter(request, prefix + "nvocc_bd_st_eff_dt", ""));
        setNvoccBdEndEffDt(JSPUtil.getParameter(request, prefix + "nvocc_bd_end_eff_dt", ""));
        setIndusDesc(JSPUtil.getParameter(request, prefix + "indus_desc", ""));
        setCrntVolKnt(JSPUtil.getParameter(request, prefix + "crnt_vol_knt", ""));
        setCmptDesc(JSPUtil.getParameter(request, prefix + "cmpt_desc", ""));
        setSpclReqDesc(JSPUtil.getParameter(request, prefix + "spcl_req_desc", ""));
        setPrfSvcDesc(JSPUtil.getParameter(request, prefix + "prf_svc_desc", ""));
        setPrfSvcDtlDesc(JSPUtil.getParameter(request, prefix + "prf_svc_dtl_desc", ""));
        setPrfGrpCmdtCd(JSPUtil.getParameter(request, prefix + "prf_grp_cmdt_cd", ""));
        setPrfCntrTpszCd(JSPUtil.getParameter(request, prefix + "prf_cntr_tpsz_cd", ""));
        setPrfRepCmdtCd(JSPUtil.getParameter(request, prefix + "prf_rep_cmdt_cd", ""));
        setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
        setCtsNo(JSPUtil.getParameter(request, prefix + "cts_no", ""));
        setFrtFwrdFmcNo(JSPUtil.getParameter(request, prefix + "frt_fwrd_fmc_no", ""));
        setKeyAcctFlg(JSPUtil.getParameter(request, prefix + "key_acct_flg", ""));
        setKeyAcctStEffDt(JSPUtil.getParameter(request, prefix + "key_acct_st_eff_dt", ""));
        setKeyAcctEndEffDt(JSPUtil.getParameter(request, prefix + "key_acct_end_eff_dt", ""));
        setSubsCoCd(JSPUtil.getParameter(request, prefix + "subs_co_cd", ""));
        setModiCustCntCd(JSPUtil.getParameter(request, prefix + "modi_cust_cnt_cd", ""));
        setModiCustSeq(JSPUtil.getParameter(request, prefix + "modi_cust_seq", ""));
        setRfndPsdoVndrSeq(JSPUtil.getParameter(request, prefix + "rfnd_psdo_vndr_seq", ""));
        setBfrOfcCd(JSPUtil.getParameter(request, prefix + "bfr_ofc_cd", ""));
        setBfrOfcCngDt(JSPUtil.getParameter(request, prefix + "bfr_ofc_cng_dt", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
        setEaiEvntDt(JSPUtil.getParameter(request, prefix + "eai_evnt_dt", ""));
        setKeyAcctMgrUsrId(JSPUtil.getParameter(request, prefix + "key_acct_mgr_usr_id", ""));
        setKeyAcctMgrUsrNm(JSPUtil.getParameter(request, prefix + "key_acct_mgr_usr_nm", ""));
        setSlsDeltEffDt(JSPUtil.getParameter(request, prefix + "sls_delt_eff_dt", ""));
        setFletMgmtOwnrCustSeq(JSPUtil.getParameter(request, prefix + "flet_mgmt_ownr_cust_seq", ""));
        setInvIssCurrTpCd(JSPUtil.getParameter(request, prefix + "inv_iss_curr_tp_cd", ""));
        setInvIssTpCd(JSPUtil.getParameter(request, prefix + "inv_iss_tp_cd", ""));
        setNmdCustFlg(JSPUtil.getParameter(request, prefix + "nmd_cust_flg", ""));
        setBkgAltRsn(JSPUtil.getParameter(request, prefix + "bkg_alt_rsn", ""));
        setBkgAltFmDt(JSPUtil.getParameter(request, prefix + "bkg_alt_fm_dt", ""));
        setBkgAltToDt(JSPUtil.getParameter(request, prefix + "bkg_alt_to_dt", ""));
        setBkgAltMsg(JSPUtil.getParameter(request, prefix + "bkg_alt_msg", ""));
        setBkgAltCreUsrId(JSPUtil.getParameter(request, prefix + "bkg_alt_cre_usr_id", ""));
        setBkgAltCreDt(JSPUtil.getParameter(request, prefix + "bkg_alt_cre_dt", ""));
        setEaiIfId(JSPUtil.getParameter(request, prefix + "eai_if_id", ""));
        setMltTrdAcctFlg(JSPUtil.getParameter(request, prefix + "mlt_trd_acct_flg", ""));
        setCustDivCd(JSPUtil.getParameter(request, prefix + "cust_div_cd", ""));
        setModiCustCd(JSPUtil.getParameter(request, prefix + "modi_cust_cd", ""));
        setCnsdCustCntCd(JSPUtil.getParameter(request, prefix + "cnsd_cust_cnt_cd", ""));
        setCnsdCustSeq(JSPUtil.getParameter(request, prefix + "cnsd_cust_seq", ""));
        setSprsPayLtrFlg(JSPUtil.getParameter(request, prefix + "sprs_pay_ltr_flg", ""));
        setPayRqstLtrFmtCd(JSPUtil.getParameter(request, prefix + "pay_rqst_ltr_fmt_cd", ""));
        setInvEdiLvlCd(JSPUtil.getParameter(request, prefix + "inv_edi_lvl_cd", ""));
        setDfltInvCurrDivCd(JSPUtil.getParameter(request, prefix + "dflt_inv_curr_div_cd", ""));
        setFwrdCntCd(JSPUtil.getParameter(request, prefix + "fwrd_cnt_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgMdmCustomerVO[]
	 */
    public BkgMdmCustomerVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgMdmCustomerVO[]
	 */
    public BkgMdmCustomerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BkgMdmCustomerVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
            String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
            String[] cntrDivFlg = (JSPUtil.getParameter(request, prefix + "cntr_div_flg", length));
            String[] blkDivFlg = (JSPUtil.getParameter(request, prefix + "blk_div_flg", length));
            String[] custGrpId = (JSPUtil.getParameter(request, prefix + "cust_grp_id", length));
            String[] custLglEngNm = (JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", length));
            String[] custLoclLangNm = (JSPUtil.getParameter(request, prefix + "cust_locl_lang_nm", length));
            String[] custAbbrNm = (JSPUtil.getParameter(request, prefix + "cust_abbr_nm", length));
            String[] cntrCustTpCd = (JSPUtil.getParameter(request, prefix + "cntr_cust_tp_cd", length));
            String[] blkCustTpCd = (JSPUtil.getParameter(request, prefix + "blk_cust_tp_cd", length));
            String[] indivCorpDivCd = (JSPUtil.getParameter(request, prefix + "indiv_corp_div_cd", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] fndtDt = (JSPUtil.getParameter(request, prefix + "fndt_dt", length));
            String[] custRgstNo = (JSPUtil.getParameter(request, prefix + "cust_rgst_no", length));
            String[] fincStsLvlCd = (JSPUtil.getParameter(request, prefix + "finc_sts_lvl_cd", length));
            String[] locCd = (JSPUtil.getParameter(request, prefix + "loc_cd", length));
            String[] capiCurrCd = (JSPUtil.getParameter(request, prefix + "capi_curr_cd", length));
            String[] capiAmt = (JSPUtil.getParameter(request, prefix + "capi_amt", length));
            String[] lstkFlg = (JSPUtil.getParameter(request, prefix + "lstk_flg", length));
            String[] empeKnt = (JSPUtil.getParameter(request, prefix + "empe_knt", length));
            String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq", length));
            String[] custRmk = (JSPUtil.getParameter(request, prefix + "cust_rmk", length));
            String[] vbsClssCd = (JSPUtil.getParameter(request, prefix + "vbs_clss_cd", length));
            String[] nbsClssCd1 = (JSPUtil.getParameter(request, prefix + "nbs_clss_cd1", length));
            String[] nbsClssCd2 = (JSPUtil.getParameter(request, prefix + "nbs_clss_cd2", length));
            String[] nbsClssCd3 = (JSPUtil.getParameter(request, prefix + "nbs_clss_cd3", length));
            String[] custStsCd = (JSPUtil.getParameter(request, prefix + "cust_sts_cd", length));
            String[] crmRowId = (JSPUtil.getParameter(request, prefix + "crm_row_id", length));
            String[] nvoccCoScacCd = (JSPUtil.getParameter(request, prefix + "nvocc_co_scac_cd", length));
            String[] nvoccBdNo = (JSPUtil.getParameter(request, prefix + "nvocc_bd_no", length));
            String[] nvoccLicNo = (JSPUtil.getParameter(request, prefix + "nvocc_lic_no", length));
            String[] nvoccBdAmt = (JSPUtil.getParameter(request, prefix + "nvocc_bd_amt", length));
            String[] nvoccBdStEffDt = (JSPUtil.getParameter(request, prefix + "nvocc_bd_st_eff_dt", length));
            String[] nvoccBdEndEffDt = (JSPUtil.getParameter(request, prefix + "nvocc_bd_end_eff_dt", length));
            String[] indusDesc = (JSPUtil.getParameter(request, prefix + "indus_desc", length));
            String[] crntVolKnt = (JSPUtil.getParameter(request, prefix + "crnt_vol_knt", length));
            String[] cmptDesc = (JSPUtil.getParameter(request, prefix + "cmpt_desc", length));
            String[] spclReqDesc = (JSPUtil.getParameter(request, prefix + "spcl_req_desc", length));
            String[] prfSvcDesc = (JSPUtil.getParameter(request, prefix + "prf_svc_desc", length));
            String[] prfSvcDtlDesc = (JSPUtil.getParameter(request, prefix + "prf_svc_dtl_desc", length));
            String[] prfGrpCmdtCd = (JSPUtil.getParameter(request, prefix + "prf_grp_cmdt_cd", length));
            String[] prfCntrTpszCd = (JSPUtil.getParameter(request, prefix + "prf_cntr_tpsz_cd", length));
            String[] prfRepCmdtCd = (JSPUtil.getParameter(request, prefix + "prf_rep_cmdt_cd", length));
            String[] srepCd = (JSPUtil.getParameter(request, prefix + "srep_cd", length));
            String[] ctsNo = (JSPUtil.getParameter(request, prefix + "cts_no", length));
            String[] frtFwrdFmcNo = (JSPUtil.getParameter(request, prefix + "frt_fwrd_fmc_no", length));
            String[] keyAcctFlg = (JSPUtil.getParameter(request, prefix + "key_acct_flg", length));
            String[] keyAcctStEffDt = (JSPUtil.getParameter(request, prefix + "key_acct_st_eff_dt", length));
            String[] keyAcctEndEffDt = (JSPUtil.getParameter(request, prefix + "key_acct_end_eff_dt", length));
            String[] subsCoCd = (JSPUtil.getParameter(request, prefix + "subs_co_cd", length));
            String[] modiCustCntCd = (JSPUtil.getParameter(request, prefix + "modi_cust_cnt_cd", length));
            String[] modiCustSeq = (JSPUtil.getParameter(request, prefix + "modi_cust_seq", length));
            String[] rfndPsdoVndrSeq = (JSPUtil.getParameter(request, prefix + "rfnd_psdo_vndr_seq", length));
            String[] bfrOfcCd = (JSPUtil.getParameter(request, prefix + "bfr_ofc_cd", length));
            String[] bfrOfcCngDt = (JSPUtil.getParameter(request, prefix + "bfr_ofc_cng_dt", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
            String[] eaiEvntDt = (JSPUtil.getParameter(request, prefix + "eai_evnt_dt", length));
            String[] keyAcctMgrUsrId = (JSPUtil.getParameter(request, prefix + "key_acct_mgr_usr_id", length));
            String[] keyAcctMgrUsrNm = (JSPUtil.getParameter(request, prefix + "key_acct_mgr_usr_nm", length));
            String[] slsDeltEffDt = (JSPUtil.getParameter(request, prefix + "sls_delt_eff_dt", length));
            String[] fletMgmtOwnrCustSeq = (JSPUtil.getParameter(request, prefix + "flet_mgmt_ownr_cust_seq", length));
            String[] invIssCurrTpCd = (JSPUtil.getParameter(request, prefix + "inv_iss_curr_tp_cd", length));
            String[] invIssTpCd = (JSPUtil.getParameter(request, prefix + "inv_iss_tp_cd", length));
            String[] nmdCustFlg = (JSPUtil.getParameter(request, prefix + "nmd_cust_flg", length));
            String[] bkgAltRsn = (JSPUtil.getParameter(request, prefix + "bkg_alt_rsn", length));
            String[] bkgAltFmDt = (JSPUtil.getParameter(request, prefix + "bkg_alt_fm_dt", length));
            String[] bkgAltToDt = (JSPUtil.getParameter(request, prefix + "bkg_alt_to_dt", length));
            String[] bkgAltMsg = (JSPUtil.getParameter(request, prefix + "bkg_alt_msg", length));
            String[] bkgAltCreUsrId = (JSPUtil.getParameter(request, prefix + "bkg_alt_cre_usr_id", length));
            String[] bkgAltCreDt = (JSPUtil.getParameter(request, prefix + "bkg_alt_cre_dt", length));
            String[] eaiIfId = (JSPUtil.getParameter(request, prefix + "eai_if_id", length));
            String[] mltTrdAcctFlg = (JSPUtil.getParameter(request, prefix + "mlt_trd_acct_flg", length));
            String[] custDivCd = (JSPUtil.getParameter(request, prefix + "cust_div_cd", length));
            String[] modiCustCd = (JSPUtil.getParameter(request, prefix + "modi_cust_cd", length));
            String[] cnsdCustCntCd = (JSPUtil.getParameter(request, prefix + "cnsd_cust_cnt_cd", length));
            String[] cnsdCustSeq = (JSPUtil.getParameter(request, prefix + "cnsd_cust_seq", length));
            String[] sprsPayLtrFlg = (JSPUtil.getParameter(request, prefix + "sprs_pay_ltr_flg", length));
            String[] payRqstLtrFmtCd = (JSPUtil.getParameter(request, prefix + "pay_rqst_ltr_fmt_cd", length));
            String[] invEdiLvlCd = (JSPUtil.getParameter(request, prefix + "inv_edi_lvl_cd", length));
            String[] dfltInvCurrDivCd = (JSPUtil.getParameter(request, prefix + "dflt_inv_curr_div_cd", length));
            String[] fwrdCntCd = (JSPUtil.getParameter(request, prefix + "fwrd_cnt_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new BkgMdmCustomerVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (custCntCd[i] != null)
                    model.setCustCntCd(custCntCd[i]);
                if (custSeq[i] != null)
                    model.setCustSeq(custSeq[i]);
                if (cntrDivFlg[i] != null)
                    model.setCntrDivFlg(cntrDivFlg[i]);
                if (blkDivFlg[i] != null)
                    model.setBlkDivFlg(blkDivFlg[i]);
                if (custGrpId[i] != null)
                    model.setCustGrpId(custGrpId[i]);
                if (custLglEngNm[i] != null)
                    model.setCustLglEngNm(custLglEngNm[i]);
                if (custLoclLangNm[i] != null)
                    model.setCustLoclLangNm(custLoclLangNm[i]);
                if (custAbbrNm[i] != null)
                    model.setCustAbbrNm(custAbbrNm[i]);
                if (cntrCustTpCd[i] != null)
                    model.setCntrCustTpCd(cntrCustTpCd[i]);
                if (blkCustTpCd[i] != null)
                    model.setBlkCustTpCd(blkCustTpCd[i]);
                if (indivCorpDivCd[i] != null)
                    model.setIndivCorpDivCd(indivCorpDivCd[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (fndtDt[i] != null)
                    model.setFndtDt(fndtDt[i]);
                if (custRgstNo[i] != null)
                    model.setCustRgstNo(custRgstNo[i]);
                if (fincStsLvlCd[i] != null)
                    model.setFincStsLvlCd(fincStsLvlCd[i]);
                if (locCd[i] != null)
                    model.setLocCd(locCd[i]);
                if (capiCurrCd[i] != null)
                    model.setCapiCurrCd(capiCurrCd[i]);
                if (capiAmt[i] != null)
                    model.setCapiAmt(capiAmt[i]);
                if (lstkFlg[i] != null)
                    model.setLstkFlg(lstkFlg[i]);
                if (empeKnt[i] != null)
                    model.setEmpeKnt(empeKnt[i]);
                if (vndrSeq[i] != null)
                    model.setVndrSeq(vndrSeq[i]);
                if (custRmk[i] != null)
                    model.setCustRmk(custRmk[i]);
                if (vbsClssCd[i] != null)
                    model.setVbsClssCd(vbsClssCd[i]);
                if (nbsClssCd1[i] != null)
                    model.setNbsClssCd1(nbsClssCd1[i]);
                if (nbsClssCd2[i] != null)
                    model.setNbsClssCd2(nbsClssCd2[i]);
                if (nbsClssCd3[i] != null)
                    model.setNbsClssCd3(nbsClssCd3[i]);
                if (custStsCd[i] != null)
                    model.setCustStsCd(custStsCd[i]);
                if (crmRowId[i] != null)
                    model.setCrmRowId(crmRowId[i]);
                if (nvoccCoScacCd[i] != null)
                    model.setNvoccCoScacCd(nvoccCoScacCd[i]);
                if (nvoccBdNo[i] != null)
                    model.setNvoccBdNo(nvoccBdNo[i]);
                if (nvoccLicNo[i] != null)
                    model.setNvoccLicNo(nvoccLicNo[i]);
                if (nvoccBdAmt[i] != null)
                    model.setNvoccBdAmt(nvoccBdAmt[i]);
                if (nvoccBdStEffDt[i] != null)
                    model.setNvoccBdStEffDt(nvoccBdStEffDt[i]);
                if (nvoccBdEndEffDt[i] != null)
                    model.setNvoccBdEndEffDt(nvoccBdEndEffDt[i]);
                if (indusDesc[i] != null)
                    model.setIndusDesc(indusDesc[i]);
                if (crntVolKnt[i] != null)
                    model.setCrntVolKnt(crntVolKnt[i]);
                if (cmptDesc[i] != null)
                    model.setCmptDesc(cmptDesc[i]);
                if (spclReqDesc[i] != null)
                    model.setSpclReqDesc(spclReqDesc[i]);
                if (prfSvcDesc[i] != null)
                    model.setPrfSvcDesc(prfSvcDesc[i]);
                if (prfSvcDtlDesc[i] != null)
                    model.setPrfSvcDtlDesc(prfSvcDtlDesc[i]);
                if (prfGrpCmdtCd[i] != null)
                    model.setPrfGrpCmdtCd(prfGrpCmdtCd[i]);
                if (prfCntrTpszCd[i] != null)
                    model.setPrfCntrTpszCd(prfCntrTpszCd[i]);
                if (prfRepCmdtCd[i] != null)
                    model.setPrfRepCmdtCd(prfRepCmdtCd[i]);
                if (srepCd[i] != null)
                    model.setSrepCd(srepCd[i]);
                if (ctsNo[i] != null)
                    model.setCtsNo(ctsNo[i]);
                if (frtFwrdFmcNo[i] != null)
                    model.setFrtFwrdFmcNo(frtFwrdFmcNo[i]);
                if (keyAcctFlg[i] != null)
                    model.setKeyAcctFlg(keyAcctFlg[i]);
                if (keyAcctStEffDt[i] != null)
                    model.setKeyAcctStEffDt(keyAcctStEffDt[i]);
                if (keyAcctEndEffDt[i] != null)
                    model.setKeyAcctEndEffDt(keyAcctEndEffDt[i]);
                if (subsCoCd[i] != null)
                    model.setSubsCoCd(subsCoCd[i]);
                if (modiCustCntCd[i] != null)
                    model.setModiCustCntCd(modiCustCntCd[i]);
                if (modiCustSeq[i] != null)
                    model.setModiCustSeq(modiCustSeq[i]);
                if (rfndPsdoVndrSeq[i] != null)
                    model.setRfndPsdoVndrSeq(rfndPsdoVndrSeq[i]);
                if (bfrOfcCd[i] != null)
                    model.setBfrOfcCd(bfrOfcCd[i]);
                if (bfrOfcCngDt[i] != null)
                    model.setBfrOfcCngDt(bfrOfcCngDt[i]);
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
                if (keyAcctMgrUsrId[i] != null)
                    model.setKeyAcctMgrUsrId(keyAcctMgrUsrId[i]);
                if (keyAcctMgrUsrNm[i] != null)
                    model.setKeyAcctMgrUsrNm(keyAcctMgrUsrNm[i]);
                if (slsDeltEffDt[i] != null)
                    model.setSlsDeltEffDt(slsDeltEffDt[i]);
                if (fletMgmtOwnrCustSeq[i] != null)
                    model.setFletMgmtOwnrCustSeq(fletMgmtOwnrCustSeq[i]);
                if (invIssCurrTpCd[i] != null)
                    model.setInvIssCurrTpCd(invIssCurrTpCd[i]);
                if (invIssTpCd[i] != null)
                    model.setInvIssTpCd(invIssTpCd[i]);
                if (nmdCustFlg[i] != null)
                    model.setNmdCustFlg(nmdCustFlg[i]);
                if (bkgAltRsn[i] != null)
                    model.setBkgAltRsn(bkgAltRsn[i]);
                if (bkgAltFmDt[i] != null)
                    model.setBkgAltFmDt(bkgAltFmDt[i]);
                if (bkgAltToDt[i] != null)
                    model.setBkgAltToDt(bkgAltToDt[i]);
                if (bkgAltMsg[i] != null)
                    model.setBkgAltMsg(bkgAltMsg[i]);
                if (bkgAltCreUsrId[i] != null)
                    model.setBkgAltCreUsrId(bkgAltCreUsrId[i]);
                if (bkgAltCreDt[i] != null)
                    model.setBkgAltCreDt(bkgAltCreDt[i]);
                if (eaiIfId[i] != null)
                    model.setEaiIfId(eaiIfId[i]);
                if (mltTrdAcctFlg[i] != null)
                    model.setMltTrdAcctFlg(mltTrdAcctFlg[i]);
                if (custDivCd[i] != null)
                    model.setCustDivCd(custDivCd[i]);
                if (modiCustCd[i] != null)
                    model.setModiCustCd(modiCustCd[i]);
                if (cnsdCustCntCd[i] != null)
                    model.setCnsdCustCntCd(cnsdCustCntCd[i]);
                if (cnsdCustSeq[i] != null)
                    model.setCnsdCustSeq(cnsdCustSeq[i]);
                if (sprsPayLtrFlg[i] != null)
                    model.setSprsPayLtrFlg(sprsPayLtrFlg[i]);
                if (payRqstLtrFmtCd[i] != null)
                    model.setPayRqstLtrFmtCd(payRqstLtrFmtCd[i]);
                if (invEdiLvlCd[i] != null)
                    model.setInvEdiLvlCd(invEdiLvlCd[i]);
                if (dfltInvCurrDivCd[i] != null)
                    model.setDfltInvCurrDivCd(dfltInvCurrDivCd[i]);
                if (fwrdCntCd[i] != null) 
		    		model.setFwrdCntCd(fwrdCntCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getBkgMdmCustomerVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BkgMdmCustomerVO[]
	 */
    public BkgMdmCustomerVO[] getBkgMdmCustomerVOs() {
        BkgMdmCustomerVO[] vos = (BkgMdmCustomerVO[]) models.toArray(new BkgMdmCustomerVO[models.size()]);
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
        this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrDivFlg = this.cntrDivFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blkDivFlg = this.blkDivFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custGrpId = this.custGrpId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custLglEngNm = this.custLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custLoclLangNm = this.custLoclLangNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custAbbrNm = this.custAbbrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrCustTpCd = this.cntrCustTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blkCustTpCd = this.blkCustTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.indivCorpDivCd = this.indivCorpDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fndtDt = this.fndtDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custRgstNo = this.custRgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fincStsLvlCd = this.fincStsLvlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locCd = this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.capiCurrCd = this.capiCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.capiAmt = this.capiAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lstkFlg = this.lstkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.empeKnt = this.empeKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custRmk = this.custRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vbsClssCd = this.vbsClssCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nbsClssCd1 = this.nbsClssCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nbsClssCd2 = this.nbsClssCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nbsClssCd3 = this.nbsClssCd3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custStsCd = this.custStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crmRowId = this.crmRowId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nvoccCoScacCd = this.nvoccCoScacCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nvoccBdNo = this.nvoccBdNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nvoccLicNo = this.nvoccLicNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nvoccBdAmt = this.nvoccBdAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nvoccBdStEffDt = this.nvoccBdStEffDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nvoccBdEndEffDt = this.nvoccBdEndEffDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.indusDesc = this.indusDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crntVolKnt = this.crntVolKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmptDesc = this.cmptDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclReqDesc = this.spclReqDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prfSvcDesc = this.prfSvcDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prfSvcDtlDesc = this.prfSvcDtlDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prfGrpCmdtCd = this.prfGrpCmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prfCntrTpszCd = this.prfCntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prfRepCmdtCd = this.prfRepCmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.srepCd = this.srepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctsNo = this.ctsNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frtFwrdFmcNo = this.frtFwrdFmcNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.keyAcctFlg = this.keyAcctFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.keyAcctStEffDt = this.keyAcctStEffDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.keyAcctEndEffDt = this.keyAcctEndEffDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.subsCoCd = this.subsCoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.modiCustCntCd = this.modiCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.modiCustSeq = this.modiCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfndPsdoVndrSeq = this.rfndPsdoVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bfrOfcCd = this.bfrOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bfrOfcCngDt = this.bfrOfcCngDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eaiEvntDt = this.eaiEvntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.keyAcctMgrUsrId = this.keyAcctMgrUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.keyAcctMgrUsrNm = this.keyAcctMgrUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slsDeltEffDt = this.slsDeltEffDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fletMgmtOwnrCustSeq = this.fletMgmtOwnrCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invIssCurrTpCd = this.invIssCurrTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invIssTpCd = this.invIssTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nmdCustFlg = this.nmdCustFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgAltRsn = this.bkgAltRsn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgAltFmDt = this.bkgAltFmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgAltToDt = this.bkgAltToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgAltMsg = this.bkgAltMsg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgAltCreUsrId = this.bkgAltCreUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgAltCreDt = this.bkgAltCreDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eaiIfId = this.eaiIfId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mltTrdAcctFlg = this.mltTrdAcctFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custDivCd = this.custDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.modiCustCd = this.modiCustCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cnsdCustCntCd = this.cnsdCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cnsdCustSeq = this.cnsdCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sprsPayLtrFlg = this.sprsPayLtrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.payRqstLtrFmtCd = this.payRqstLtrFmtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invEdiLvlCd = this.invEdiLvlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dfltInvCurrDivCd = this.dfltInvCurrDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fwrdCntCd = this.fwrdCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
