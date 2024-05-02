/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustomerIfVO.java
*@FileTitle : CustomerIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo;
 
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
public class CustomerIfVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<CustomerIfVO> models = new ArrayList<CustomerIfVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    private String custCntCd = null;
    private String custSeq = null;
    private String custGrpId = null;
    private String custLglEngNm = null;
    private String custLoclLangNm = null;
    private String custAbbrNm = null;
    private String cntrCustTpCd = null;
    private String indivCorpDivCd = null;
    private String ofcCd = null;
    private String fndtDt = null;
    private String custRgstNo = null;
    private String fincStsLvlCd = null;
    private String locCd = null;
    private String capiCurrCd = null;
    private String capiAmt = null;
    private String lstkFlg = null;
    private String empeKnt = null;
    private String vndrSeq = null;
    private String custRmk = null;
    private String vbsClssCd = null;
    private String nbsClssCd1 = null;
    private String nbsClssCd2 = null;
    private String nbsClssCd3 = null;
    private String nvoccCoScacCd = null;
    private String nvoccBdNo = null;
    private String nvoccLicNo = null;
    private String nvoccBdAmt = null;
    private String nvoccBdStEffDt = null;
    private String nvoccBdEndEffDt = null;
    private String indusDesc = null;
    private String crntVolKnt = null;
    private String cmptDesc = null;
    private String spclReqDesc = null;
    private String prfSvcDesc = null;
    private String prfSvcDtlDesc = null;
    private String prfGrpCmdtCd = null;
    private String prfCntrTpszCd = null;
    private String prfRepCmdtCd = null;
    private String srepCd = null;
    private String ctsNo = null;
    private String frtFwrdFmcNo = null;
    private String keyAcctFlg = null;
    private String keyAcctStEffDt = null;
    private String keyAcctEndEffDt = null;
    private String subsCoCd = null;
    private String keyAcctMgrUsrId = null;
    private String keyAcctMgrUsrNm = null;
    private String slsDeltEffDt = null;
    private String nmdCustFlg = null;
    private String mltTrdAcctFlg = null;
    private String custDivCd = null;
    private String modiCustCd = null;
    private String creUsrId = null;
    private String creDt = null;
    private String updUsrId = null;
    private String updDt = null;
    private String deltFlg = null;
    private String custIfSeq = null;
    private String r3InsfId = null;
    private String r3InsfPrsId = null;
    private String r3InsfDttm = null;
    private String r3InsfCnqeVal = null;
    private String r3InsfDvCd = null;
    private String r3InsfCnqeCont = null;
    private String ecomInsfId = null;
    private String ecomInsfPrsId = null;
    private String ecomInsfDttm = null;
    private String ecomInsfCnqeVal = null;
    private String ecomInsfDvCd = null;
    private String ecomInsfCnqeCont = null;

	private String addrTpCd = null;
	private String addrSeq = null;
	private String prmryChkFlg = null;
	private String bzetNm = null;
	private String bzetAddr = null;
	private String ctyNm = null;
	private String steCd = null;
	private String zipCd = null;
	private String cntcEml = null;
	private String cntcPsonNm = null;
	private String bzetRmk = null;
	private String loclAddr1 = null;
	private String loclAddr2 = null;
	private String loclAddr3 = null;
	private String loclAddr4 = null;
	private String cntCd = null;
	
	private String custCntcPntSeq = null;
	private String custEml = null;
	private String custUrl = null;
	private String intlPhnNo = null;
	private String phnNo = null;
	private String intlFaxNo = null;
	private String faxNo = null;
	
	private String opediInsfId = null;
    private String opediInsfDvCd = null;
    private String railRoadPrioFlg = null;
    private String modiCustCd2 = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public CustomerIfVO() {
    }

    public CustomerIfVO(String ibflag, String pagerows, String insfId, String insfCnqeVal, String insfDvCd, String insfPrsId, String insfCnqeCont, String insfDttm, String custCntCd, String custSeq, String custGrpId, String custLglEngNm, String custLoclLangNm, String custAbbrNm, String cntrCustTpCd, String indivCorpDivCd, String ofcCd, String fndtDt, String custRgstNo, String fincStsLvlCd, String locCd, String capiCurrCd, String capiAmt, String lstkFlg, String empeKnt, String vndrSeq, String custRmk, String vbsClssCd, String nbsClssCd1, String nbsClssCd2, String nbsClssCd3, String nvoccCoScacCd, String nvoccBdNo, String nvoccLicNo, String nvoccBdAmt, String nvoccBdStEffDt, String nvoccBdEndEffDt, String indusDesc, String crntVolKnt, String cmptDesc, String spclReqDesc, String prfSvcDesc, String prfSvcDtlDesc, String prfGrpCmdtCd, String prfCntrTpszCd, String prfRepCmdtCd, String srepCd, String ctsNo, String frtFwrdFmcNo, String keyAcctFlg, String keyAcctStEffDt, String keyAcctEndEffDt, String subsCoCd, String keyAcctMgrUsrId, String keyAcctMgrUsrNm, String slsDeltEffDt, String nmdCustFlg, String mltTrdAcctFlg, String custDivCd, String modiCustCd, String addrTpCd, String addrSeq, String prmryChkFlg, String bzetNm, String bzetAddr, String ctyNm, String steCd, String zipCd, String cntcEml, String cntcPsonNm, String bzetRmk, String loclAddr1, String loclAddr2, String loclAddr3, String loclAddr4, String cntCd, String custCntcPntSeq, String custEml, String custIp, String custUrl, String intlPhnNo, String phnNo, String intlFaxNo, String faxNo, String creUsrId, String creDt, String updUsrId, String updDt, String deltFlg, String custIfSeq, String r3InsfId, String r3InsfPrsId, String r3InsfDttm, String r3InsfCnqeVal, String r3InsfDvCd, String r3InsfCnqeCont, String ecomInsfId, String ecomInsfPrsId, String ecomInsfDttm, String ecomInsfCnqeVal, String ecomInsfDvCd, String ecomInsfCnqeCont, String opediInsfId, String opediInsfDvCd, String railRoadPrioFlg, String modiCustCd2) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.custCntCd = custCntCd;
        this.custSeq = custSeq;
        this.custGrpId = custGrpId;
        this.custLglEngNm = custLglEngNm;
        this.custLoclLangNm = custLoclLangNm;
        this.custAbbrNm = custAbbrNm;
        this.cntrCustTpCd = cntrCustTpCd;
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
        this.keyAcctMgrUsrId = keyAcctMgrUsrId;
        this.keyAcctMgrUsrNm = keyAcctMgrUsrNm;
        this.slsDeltEffDt = slsDeltEffDt;
        this.nmdCustFlg = nmdCustFlg;
        this.mltTrdAcctFlg = mltTrdAcctFlg;
        this.custDivCd = custDivCd;
        this.modiCustCd = modiCustCd;
        this.creUsrId = creUsrId;
        this.creDt = creDt;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.deltFlg = deltFlg;
        this.custIfSeq = custIfSeq;
        this.r3InsfId = r3InsfId;
        this.r3InsfPrsId = r3InsfPrsId;
        this.r3InsfDttm = r3InsfDttm;
        this.r3InsfCnqeVal = r3InsfCnqeVal;
        this.r3InsfDvCd = r3InsfDvCd;
        this.r3InsfCnqeCont = r3InsfCnqeCont;
        this.ecomInsfId = ecomInsfId;
        this.ecomInsfPrsId = ecomInsfPrsId;
        this.ecomInsfDttm = ecomInsfDttm;
        this.ecomInsfCnqeVal = ecomInsfCnqeVal;
        this.ecomInsfDvCd = ecomInsfDvCd;
        this.ecomInsfCnqeCont = ecomInsfCnqeCont;
        
        this.bzetAddr = bzetAddr;
        this.addrSeq = addrSeq;
        this.addrTpCd = addrTpCd;
		this.cntcEml = cntcEml;
		this.bzetRmk = bzetRmk;
		this.loclAddr4 = loclAddr4;
		this.loclAddr3 = loclAddr3;
		this.zipCd = zipCd;
		this.cntcPsonNm = cntcPsonNm;
		this.loclAddr2 = loclAddr2;
		this.cntCd = cntCd;
		this.prmryChkFlg = prmryChkFlg;
		this.loclAddr1 = loclAddr1;
		this.bzetNm = bzetNm;
		this.ctyNm = ctyNm;
		this.steCd = steCd;
        
        
        this.custCntcPntSeq = custCntcPntSeq;
        this.custEml = custEml;
        this.custUrl = custUrl;
        this.intlPhnNo = intlPhnNo;
        this.phnNo = phnNo;
        this.intlFaxNo = intlFaxNo;
        this.faxNo = faxNo;
        
        this.opediInsfId = opediInsfId;
        this.opediInsfDvCd = opediInsfDvCd;
        this.railRoadPrioFlg = railRoadPrioFlg;
        this.modiCustCd2 = modiCustCd2;
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
        this.hashColumns.put("cust_grp_id", getCustGrpId());
        this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
        this.hashColumns.put("cust_locl_lang_nm", getCustLoclLangNm());
        this.hashColumns.put("cust_abbr_nm", getCustAbbrNm());
        this.hashColumns.put("cntr_cust_tp_cd", getCntrCustTpCd());
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
        this.hashColumns.put("key_acct_mgr_usr_id", getKeyAcctMgrUsrId());
        this.hashColumns.put("key_acct_mgr_usr_nm", getKeyAcctMgrUsrNm());
        this.hashColumns.put("sls_delt_eff_dt", getSlsDeltEffDt());
        this.hashColumns.put("nmd_cust_flg", getNmdCustFlg());
        this.hashColumns.put("mlt_trd_acct_flg", getMltTrdAcctFlg());
        this.hashColumns.put("cust_div_cd", getCustDivCd());
        this.hashColumns.put("modi_cust_cd", getModiCustCd());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("delt_flg", getDeltFlg());
        this.hashColumns.put("cust_if_seq", getCustIfSeq());
        this.hashColumns.put("r3_insf_id", getR3InsfId());
        this.hashColumns.put("r3_insf_prs_id", getR3InsfPrsId());
        this.hashColumns.put("r3_insf_dttm", getR3InsfDttm());
        this.hashColumns.put("r3_insf_cnqe_val", getR3InsfCnqeVal());
        this.hashColumns.put("r3_insf_dv_cd", getR3InsfDvCd());
        this.hashColumns.put("r3_insf_cnqe_cont", getR3InsfCnqeCont());
        this.hashColumns.put("ecom_insf_id", getEcomInsfId());
        this.hashColumns.put("ecom_insf_prs_id", getEcomInsfPrsId());
        this.hashColumns.put("ecom_insf_dttm", getEcomInsfDttm());
        this.hashColumns.put("ecom_insf_cnqe_val", getEcomInsfCnqeVal());
        this.hashColumns.put("ecom_insf_dv_cd", getEcomInsfDvCd());
        this.hashColumns.put("ecom_insf_cnqe_cont", getEcomInsfCnqeCont());

		this.hashColumns.put("bzet_addr", getBzetAddr());
		this.hashColumns.put("addr_tp_cd", getAddrTpCd());
		this.hashColumns.put("addr_seq", getAddrSeq());
		this.hashColumns.put("cntc_eml", getCntcEml());
		this.hashColumns.put("bzet_rmk", getBzetRmk());
		this.hashColumns.put("locl_addr4", getLoclAddr4());
		this.hashColumns.put("locl_addr3", getLoclAddr3());
		this.hashColumns.put("zip_cd", getZipCd());
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
		this.hashColumns.put("locl_addr2", getLoclAddr2());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("prmry_chk_flg", getPrmryChkFlg());
		this.hashColumns.put("locl_addr1", getLoclAddr1());
		this.hashColumns.put("bzet_nm", getBzetNm());
		this.hashColumns.put("cty_nm", getCtyNm());
		this.hashColumns.put("ste_cd", getSteCd());
	
		this.hashColumns.put("cust_cntc_pnt_seq", getCustCntcPntSeq());
		this.hashColumns.put("cust_eml", getCustEml());
		this.hashColumns.put("cust_url", getCustUrl());
		this.hashColumns.put("intl_phn_no", getIntlPhnNo());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("intl_fax_no", getIntlFaxNo());
		this.hashColumns.put("fax_no", getFaxNo());

		this.hashColumns.put("opedi_insf_id", getOpediInsfId());
        this.hashColumns.put("opedi_insf_dv_cd", getOpediInsfDvCd());
        this.hashColumns.put("rail_road_prio_flg", getRailRoadPrioFlg());
        this.hashColumns.put("modi_cust_cd2", getModiCustCd2());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("insf_id", "insfId");
        this.hashFields.put("insf_cnqe_val", "insfCnqeVal");
        this.hashFields.put("insf_dv_cd", "insfDvCd");
        this.hashFields.put("insf_prs_id", "insfPrsId");
        this.hashFields.put("insf_cnqe_cont", "insfCnqeCont");
        this.hashFields.put("insf_dttm", "insfDttm");
        this.hashFields.put("cust_cnt_cd", "custCntCd");
        this.hashFields.put("cust_seq", "custSeq");
        this.hashFields.put("cust_grp_id", "custGrpId");
        this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
        this.hashFields.put("cust_locl_lang_nm", "custLoclLangNm");
        this.hashFields.put("cust_abbr_nm", "custAbbrNm");
        this.hashFields.put("cntr_cust_tp_cd", "cntrCustTpCd");
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
        this.hashFields.put("key_acct_mgr_usr_id", "keyAcctMgrUsrId");
        this.hashFields.put("key_acct_mgr_usr_nm", "keyAcctMgrUsrNm");
        this.hashFields.put("sls_delt_eff_dt", "slsDeltEffDt");
        this.hashFields.put("nmd_cust_flg", "nmdCustFlg");
        this.hashFields.put("mlt_trd_acct_flg", "mltTrdAcctFlg");
        this.hashFields.put("cust_div_cd", "custDivCd");
        this.hashFields.put("modi_cust_cd", "modiCustCd");
        this.hashFields.put("addr_tp_cd", "addrTpCd");
        this.hashFields.put("addr_seq", "addrSeq");
        this.hashFields.put("prmry_chk_flg", "prmryChkFlg");
        this.hashFields.put("bzet_nm", "bzetNm");
        this.hashFields.put("bzet_addr", "bzetAddr");
        this.hashFields.put("cty_nm", "ctyNm");
        this.hashFields.put("ste_cd", "steCd");
        this.hashFields.put("zip_cd", "zipCd");
        this.hashFields.put("cntc_eml", "cntcEml");
        this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
        this.hashFields.put("bzet_rmk", "bzetRmk");
        this.hashFields.put("locl_addr1", "loclAddr1");
        this.hashFields.put("locl_addr2", "loclAddr2");
        this.hashFields.put("locl_addr3", "loclAddr3");
        this.hashFields.put("locl_addr4", "loclAddr4");
        this.hashFields.put("cnt_cd", "cntCd");
        this.hashFields.put("cust_cntc_pnt_seq", "custCntcPntSeq");
        this.hashFields.put("cust_eml", "custEml");
        this.hashFields.put("cust_ip", "custIp");
        this.hashFields.put("cust_url", "custUrl");
        this.hashFields.put("intl_phn_no", "intlPhnNo");
        this.hashFields.put("phn_no", "phnNo");
        this.hashFields.put("intl_fax_no", "intlFaxNo");
        this.hashFields.put("fax_no", "faxNo");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("delt_flg", "deltFlg");
        this.hashFields.put("cust_if_seq", "custIfSeq");
        this.hashFields.put("r3_insf_id", "r3InsfId");
        this.hashFields.put("r3_insf_prs_id", "r3InsfPrsId");
        this.hashFields.put("r3_insf_dttm", "r3InsfDttm");
        this.hashFields.put("r3_insf_cnqe_val", "r3InsfCnqeVal");
        this.hashFields.put("r3_insf_dv_cd", "r3InsfDvCd");
        this.hashFields.put("r3_insf_cnqe_cont", "r3InsfCnqeCont");
        this.hashFields.put("ecom_insf_id", "ecomInsfId");
        this.hashFields.put("ecom_insf_prs_id", "ecomInsfPrsId");
        this.hashFields.put("ecom_insf_dttm", "ecomInsfDttm");
        this.hashFields.put("ecom_insf_cnqe_val", "ecomInsfCnqeVal");
        this.hashFields.put("ecom_insf_dv_cd", "ecomInsfDvCd");
        this.hashFields.put("ecom_insf_cnqe_cont", "ecomInsfCnqeCont");

		this.hashFields.put("opedi_insf_id", "opediInsfId");
        this.hashFields.put("opedi_insf_dv_cd", "opediInsfDvCd");
        this.hashFields.put("rail_road_prio_flg", "railRoadPrioFlg");
        this.hashFields.put("modi_cust_cd2", "modiCustCd2");
        return this.hashFields;
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

    public void setCustIfSeq(String custIfSeq) {
        this.custIfSeq = custIfSeq;
    }

    public String getCustIfSeq() {
        return this.custIfSeq;
    }

    public void setR3InsfId(String r3InsfId) {
        this.r3InsfId = r3InsfId;
    }

    public String getR3InsfId() {
        return this.r3InsfId;
    }

    public void setR3InsfPrsId(String r3InsfPrsId) {
        this.r3InsfPrsId = r3InsfPrsId;
    }

    public String getR3InsfPrsId() {
        return this.r3InsfPrsId;
    }

    public void setR3InsfDttm(String r3InsfDttm) {
        this.r3InsfDttm = r3InsfDttm;
    }

    public String getR3InsfDttm() {
        return this.r3InsfDttm;
    }

    public void setR3InsfCnqeVal(String r3InsfCnqeVal) {
        this.r3InsfCnqeVal = r3InsfCnqeVal;
    }

    public String getR3InsfCnqeVal() {
        return this.r3InsfCnqeVal;
    }

    public void setR3InsfDvCd(String r3InsfDvCd) {
        this.r3InsfDvCd = r3InsfDvCd;
    }

    public String getR3InsfDvCd() {
        return this.r3InsfDvCd;
    }

    public void setR3InsfCnqeCont(String r3InsfCnqeCont) {
        this.r3InsfCnqeCont = r3InsfCnqeCont;
    }

    public String getR3InsfCnqeCont() {
        return this.r3InsfCnqeCont;
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

	public String getBzetAddr() {
		return bzetAddr;
	}

	public void setBzetAddr(String bzetAddr) {
		this.bzetAddr = bzetAddr;
	}

	public String getAddrSeq() {
		return addrSeq;
	}

	public void setAddrSeq(String addrSeq) {
		this.addrSeq = addrSeq;
	}

	public String getAddrTpCd() {
		return addrTpCd;
	}

	public void setAddrTpCd(String addrTpCd) {
		this.addrTpCd = addrTpCd;
	}

	public String getCustCntcPntSeq() {
		return custCntcPntSeq;
	}

	public void setCustCntcPntSeq(String custCntcPntSeq) {
		this.custCntcPntSeq = custCntcPntSeq;
	}

	public String getCustEml() {
		return custEml;
	}

	public void setCustEml(String custEml) {
		this.custEml = custEml;
	}

	public String getCustUrl() {
		return custUrl;
	}

	public void setCustUrl(String custUrl) {
		this.custUrl = custUrl;
	}

	public String getIntlPhnNo() {
		return intlPhnNo;
	}

	public void setIntlPhnNo(String intlPhnNo) {
		this.intlPhnNo = intlPhnNo;
	}

	public String getPhnNo() {
		return phnNo;
	}

	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}

	public String getIntlFaxNo() {
		return intlFaxNo;
	}

	public void setIntlFaxNo(String intlFaxNo) {
		this.intlFaxNo = intlFaxNo;
	}

	public String getFaxNo() {
		return faxNo;
	}

	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
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
	
	/**
	 * Column Info
	 * @return cntcEml
	 */
	public String getCntcEml() {
		return this.cntcEml;
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
	 * @return bzetRmk
	 */
	public String getBzetRmk() {
		return this.bzetRmk;
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
	 * @return loclAddr4
	 */
	public String getLoclAddr4() {
		return this.loclAddr4;
	}
	
	/**
	 * Column Info
	 * @return loclAddr3
	 */
	public String getLoclAddr3() {
		return this.loclAddr3;
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
	 * @return cntcPsonNm
	 */
	public String getCntcPsonNm() {
		return this.cntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @return loclAddr2
	 */
	public String getLoclAddr2() {
		return this.loclAddr2;
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
	 * @return prmryChkFlg
	 */
	public String getPrmryChkFlg() {
		return this.prmryChkFlg;
	}
	
	/**
	 * Column Info
	 * @return loclAddr1
	 */
	public String getLoclAddr1() {
		return this.loclAddr1;
	}
	
	/**
	 * Column Info
	 * @return bzetNm
	 */
	public String getBzetNm() {
		return this.bzetNm;
	}
	
	/**
	 * Column Info
	 * @return ctyNm
	 */
	public String getCtyNm() {
		return this.ctyNm;
	}
	
	/**
	 * Column Info
	 * @return steCd
	 */
	public String getSteCd() {
		return this.steCd;
	}
	
	/**
	 * Column Info
	 * @return railRoadPrioFlg
	 */
	public String getRailRoadPrioFlg() {
		return this.railRoadPrioFlg;
	}

	/**
	 * Column Info
	 * @param cntcEml
	 */
	public void setCntcEml(String cntcEml) {
		this.cntcEml = cntcEml;
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
	 * @param bzetRmk
	 */
	public void setBzetRmk(String bzetRmk) {
		this.bzetRmk = bzetRmk;
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
	 * @param loclAddr4
	 */
	public void setLoclAddr4(String loclAddr4) {
		this.loclAddr4 = loclAddr4;
	}
	
	/**
	 * Column Info
	 * @param loclAddr3
	 */
	public void setLoclAddr3(String loclAddr3) {
		this.loclAddr3 = loclAddr3;
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
	 * @param cntcPsonNm
	 */
	public void setCntcPsonNm(String cntcPsonNm) {
		this.cntcPsonNm = cntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @param loclAddr2
	 */
	public void setLoclAddr2(String loclAddr2) {
		this.loclAddr2 = loclAddr2;
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
	 * @param prmryChkFlg
	 */
	public void setPrmryChkFlg(String prmryChkFlg) {
		this.prmryChkFlg = prmryChkFlg;
	}
	
	/**
	 * Column Info
	 * @param loclAddr1
	 */
	public void setLoclAddr1(String loclAddr1) {
		this.loclAddr1 = loclAddr1;
	}
	
	/**
	 * Column Info
	 * @param bzetNm
	 */
	public void setBzetNm(String bzetNm) {
		this.bzetNm = bzetNm;
	}
	
	/**
	 * Column Info
	 * @param ctyNm
	 */
	public void setCtyNm(String ctyNm) {
		this.ctyNm = ctyNm;
	}
	
	/**
	 * Column Info
	 * @param steCd
	 */
	public void setSteCd(String steCd) {
		this.steCd = steCd;
	}
	
	/**
	 * Column Info
	 * @param railRoadPrioFlg
	 */
	public void setRailRoadPrioFlg(String railRoadPrioFlg) {
		this.railRoadPrioFlg = railRoadPrioFlg;
	}

    public String getModiCustCd2() {
		return modiCustCd2;
	}

	public void setModiCustCd2(String modiCustCd2) {
		this.modiCustCd2 = modiCustCd2;
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
        setCustGrpId(JSPUtil.getParameter(request, prefix + "cust_grp_id", ""));
        setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
        setCustLoclLangNm(JSPUtil.getParameter(request, prefix + "cust_locl_lang_nm", ""));
        setCustAbbrNm(JSPUtil.getParameter(request, prefix + "cust_abbr_nm", ""));
        setCntrCustTpCd(JSPUtil.getParameter(request, prefix + "cntr_cust_tp_cd", ""));
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
        setKeyAcctMgrUsrId(JSPUtil.getParameter(request, prefix + "key_acct_mgr_usr_id", ""));
        setKeyAcctMgrUsrNm(JSPUtil.getParameter(request, prefix + "key_acct_mgr_usr_nm", ""));
        setSlsDeltEffDt(JSPUtil.getParameter(request, prefix + "sls_delt_eff_dt", ""));
        setNmdCustFlg(JSPUtil.getParameter(request, prefix + "nmd_cust_flg", ""));
        setMltTrdAcctFlg(JSPUtil.getParameter(request, prefix + "mlt_trd_acct_flg", ""));
        setCustDivCd(JSPUtil.getParameter(request, prefix + "cust_div_cd", ""));
        setModiCustCd(JSPUtil.getParameter(request, prefix + "modi_cust_cd", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
        setCustIfSeq(JSPUtil.getParameter(request, prefix + "cust_if_seq", ""));
        setR3InsfId(JSPUtil.getParameter(request, prefix + "r3_insf_id", ""));
        setR3InsfPrsId(JSPUtil.getParameter(request, prefix + "r3_insf_prs_id", ""));
        setR3InsfDttm(JSPUtil.getParameter(request, prefix + "r3_insf_dttm", ""));
        setR3InsfCnqeVal(JSPUtil.getParameter(request, prefix + "r3_insf_cnqe_val", ""));
        setR3InsfDvCd(JSPUtil.getParameter(request, prefix + "r3_insf_dv_cd", ""));
        setR3InsfCnqeCont(JSPUtil.getParameter(request, prefix + "r3_insf_cnqe_cont", ""));
        setEcomInsfId(JSPUtil.getParameter(request, prefix + "ecom_insf_id", ""));
        setEcomInsfPrsId(JSPUtil.getParameter(request, prefix + "ecom_insf_prs_id", ""));
        setEcomInsfDttm(JSPUtil.getParameter(request, prefix + "ecom_insf_dttm", ""));
        setEcomInsfCnqeVal(JSPUtil.getParameter(request, prefix + "ecom_insf_cnqe_val", ""));
        setEcomInsfDvCd(JSPUtil.getParameter(request, prefix + "ecom_insf_dv_cd", ""));
        setEcomInsfCnqeCont(JSPUtil.getParameter(request, prefix + "ecom_insf_cnqe_cont", ""));

		setBzetAddr(JSPUtil.getParameter(request, prefix + "bzet_addr", ""));
		setAddrSeq(JSPUtil.getParameter(request, prefix + "addr_seq", ""));
		setAddrTpCd(JSPUtil.getParameter(request, prefix + "addr_tp_cd", ""));
		setCustCntcPntSeq(JSPUtil.getParameter(request, prefix + "cust_cntc_pnt_seq", ""));
		setCustEml(JSPUtil.getParameter(request, prefix + "cust_eml", ""));
		setCustUrl(JSPUtil.getParameter(request, prefix + "cust_url", ""));
		setIntlPhnNo(JSPUtil.getParameter(request, prefix + "intl_phn_no", ""));
		setPhnNo(JSPUtil.getParameter(request, prefix + "phn_no", ""));
		setIntlFaxNo(JSPUtil.getParameter(request, prefix + "intl_fax_no", ""));
		setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));

		setOpediInsfId(JSPUtil.getParameter(request, prefix + "opedi_insf_id", ""));
        setOpediInsfDvCd(JSPUtil.getParameter(request, prefix + "opedi_insf_dv_cd", ""));
        setRailRoadPrioFlg(JSPUtil.getParameter(request, prefix + "rail_road_prio_flg", ""));
        setModiCustCd2(JSPUtil.getParameter(request, prefix + "modi_cust_cd2", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomerIfVO[]
	 */
    public CustomerIfVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomerIfVO[]
	 */
    public CustomerIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CustomerIfVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
            String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
            String[] custGrpId = (JSPUtil.getParameter(request, prefix + "cust_grp_id", length));
            String[] custLglEngNm = (JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", length));
            String[] custLoclLangNm = (JSPUtil.getParameter(request, prefix + "cust_locl_lang_nm", length));
            String[] custAbbrNm = (JSPUtil.getParameter(request, prefix + "cust_abbr_nm", length));
            String[] cntrCustTpCd = (JSPUtil.getParameter(request, prefix + "cntr_cust_tp_cd", length));
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
            String[] keyAcctMgrUsrId = (JSPUtil.getParameter(request, prefix + "key_acct_mgr_usr_id", length));
            String[] keyAcctMgrUsrNm = (JSPUtil.getParameter(request, prefix + "key_acct_mgr_usr_nm", length));
            String[] slsDeltEffDt = (JSPUtil.getParameter(request, prefix + "sls_delt_eff_dt", length));
            String[] nmdCustFlg = (JSPUtil.getParameter(request, prefix + "nmd_cust_flg", length));
            String[] mltTrdAcctFlg = (JSPUtil.getParameter(request, prefix + "mlt_trd_acct_flg", length));
            String[] custDivCd = (JSPUtil.getParameter(request, prefix + "cust_div_cd", length));
            String[] modiCustCd = (JSPUtil.getParameter(request, prefix + "modi_cust_cd", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
            String[] custIfSeq = (JSPUtil.getParameter(request, prefix + "cust_if_seq", length));
            String[] r3InsfId = (JSPUtil.getParameter(request, prefix + "r3_insf_id", length));
	    	String[] r3InsfPrsId = (JSPUtil.getParameter(request, prefix + "r3_insf_prs_id", length));
	    	String[] r3InsfDttm = (JSPUtil.getParameter(request, prefix + "r3_insf_dttm", length));
	    	String[] r3InsfCnqeVal = (JSPUtil.getParameter(request, prefix + "r3_insf_cnqe_val", length));
	    	String[] r3InsfDvCd = (JSPUtil.getParameter(request, prefix + "r3_insf_dv_cd", length));
	    	String[] r3InsfCnqeCont = (JSPUtil.getParameter(request, prefix + "r3_insf_cnqe_cont", length));
	    	String[] ecomInsfId = (JSPUtil.getParameter(request, prefix + "ecom_insf_id", length));
	    	String[] ecomInsfPrsId = (JSPUtil.getParameter(request, prefix + "ecom_insf_prs_id", length));
	    	String[] ecomInsfDttm = (JSPUtil.getParameter(request, prefix + "ecom_insf_dttm", length));
	    	String[] ecomInsfCnqeVal = (JSPUtil.getParameter(request, prefix + "ecom_insf_cnqe_val", length));
	    	String[] ecomInsfDvCd = (JSPUtil.getParameter(request, prefix + "ecom_insf_dv_cd", length));
	    	String[] ecomInsfCnqeCont = (JSPUtil.getParameter(request, prefix + "ecom_insf_cnqe_cont", length));

			String[] bzetAddr = (JSPUtil.getParameter(request, prefix	+ "bzet_addr", length));
			String[] addrSeq = (JSPUtil.getParameter(request, prefix	+ "addr_seq", length));
			String[] addrTpCd = (JSPUtil.getParameter(request, prefix	+ "addr_tp_cd", length));
			String[] cntcEml = (JSPUtil.getParameter(request, prefix	+ "cntc_eml", length));
			String[] bzetRmk = (JSPUtil.getParameter(request, prefix	+ "bzet_rmk", length));
			String[] loclAddr4 = (JSPUtil.getParameter(request, prefix	+ "locl_addr4", length));
			String[] loclAddr3 = (JSPUtil.getParameter(request, prefix	+ "locl_addr3", length));
			String[] zipCd = (JSPUtil.getParameter(request, prefix	+ "zip_cd", length));
			String[] cntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_nm", length));
			String[] loclAddr2 = (JSPUtil.getParameter(request, prefix	+ "locl_addr2", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] prmryChkFlg = (JSPUtil.getParameter(request, prefix	+ "prmry_chk_flg", length));
			String[] loclAddr1 = (JSPUtil.getParameter(request, prefix	+ "locl_addr1", length));
			String[] bzetNm = (JSPUtil.getParameter(request, prefix	+ "bzet_nm", length));
			String[] ctyNm = (JSPUtil.getParameter(request, prefix	+ "cty_nm", length));
			String[] steCd = (JSPUtil.getParameter(request, prefix	+ "ste_cd", length));
			
			String[] custCntcPntSeq = (JSPUtil.getParameter(request, prefix	+ "cust_cntc_pnt_seq", length));
			String[] custEml = (JSPUtil.getParameter(request, prefix	+ "cust_eml", length));
			String[] custUrl = (JSPUtil.getParameter(request, prefix	+ "cust_url", length));
			String[] intlPhnNo = (JSPUtil.getParameter(request, prefix	+ "intl_phn_no", length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] intlFaxNo = (JSPUtil.getParameter(request, prefix	+ "intl_fax_no", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));

			String[] opediInsfId = (JSPUtil.getParameter(request, prefix	+ "opedi_insf_id", length));
	    	String[] opediInsfDvCd = (JSPUtil.getParameter(request, prefix + "opedi_insf_dv_cd", length));
	    	String[] railRoadPrioFlg = (JSPUtil.getParameter(request, prefix + "rail_road_prio_flg", length));
	    	String[] modiCustCd2 = (JSPUtil.getParameter(request, prefix + "modi_cust_cd2", length));
			
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new CustomerIfVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (custCntCd[i] != null)
                    model.setCustCntCd(custCntCd[i]);
                if (custSeq[i] != null)
                    model.setCustSeq(custSeq[i]);
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
                if (keyAcctMgrUsrId[i] != null)
                    model.setKeyAcctMgrUsrId(keyAcctMgrUsrId[i]);
                if (keyAcctMgrUsrNm[i] != null)
                    model.setKeyAcctMgrUsrNm(keyAcctMgrUsrNm[i]);
                if (slsDeltEffDt[i] != null)
                    model.setSlsDeltEffDt(slsDeltEffDt[i]);
                if (nmdCustFlg[i] != null)
                    model.setNmdCustFlg(nmdCustFlg[i]);
                if (mltTrdAcctFlg[i] != null)
                    model.setMltTrdAcctFlg(mltTrdAcctFlg[i]);
                if (custDivCd[i] != null)
                    model.setCustDivCd(custDivCd[i]);
                if (modiCustCd[i] != null)
                    model.setModiCustCd(modiCustCd[i]);
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
                if (custIfSeq[i] != null)
                    model.setCustIfSeq(custIfSeq[i]);
                if (r3InsfId[i] != null) 
		    		model.setR3InsfId(r3InsfId[i]);
				if (r3InsfPrsId[i] != null) 
		    		model.setR3InsfPrsId(r3InsfPrsId[i]);
				if (r3InsfDttm[i] != null) 
		    		model.setR3InsfDttm(r3InsfDttm[i]);
				if (r3InsfCnqeVal[i] != null) 
		    		model.setR3InsfCnqeVal(r3InsfCnqeVal[i]);
				if (r3InsfDvCd[i] != null) 
		    		model.setR3InsfDvCd(r3InsfDvCd[i]);
				if (r3InsfCnqeCont[i] != null) 
		    		model.setR3InsfCnqeCont(r3InsfCnqeCont[i]);
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
				
				if (bzetAddr[i] != null)
					model.setBzetAddr(bzetAddr[i]);
				if (addrTpCd[i] != null)
					model.setAddrTpCd(addrTpCd[i]);
				if (addrSeq[i] != null)
					model.setAddrSeq(addrSeq[i]);
				if (cntcEml[i] != null)
					model.setCntcEml(cntcEml[i]);
				if (bzetRmk[i] != null)
					model.setBzetRmk(bzetRmk[i]);
				if (loclAddr4[i] != null)
					model.setLoclAddr4(loclAddr4[i]);
				if (loclAddr3[i] != null)
					model.setLoclAddr3(loclAddr3[i]);
				if (zipCd[i] != null)
					model.setZipCd(zipCd[i]);
				if (cntcPsonNm[i] != null)
					model.setCntcPsonNm(cntcPsonNm[i]);
				if (loclAddr2[i] != null)
					model.setLoclAddr2(loclAddr2[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (prmryChkFlg[i] != null)
					model.setPrmryChkFlg(prmryChkFlg[i]);
				if (loclAddr1[i] != null)
					model.setLoclAddr1(loclAddr1[i]);
				if (bzetNm[i] != null)
					model.setBzetNm(bzetNm[i]);
				if (ctyNm[i] != null)
					model.setCtyNm(ctyNm[i]);
				if (steCd[i] != null)
					model.setSteCd(steCd[i]);
				
				if (custCntcPntSeq[i] != null)
					model.setCustCntcPntSeq(custCntcPntSeq[i]);
				if (custEml[i] != null)
					model.setCustEml(custEml[i]);
				if (custUrl[i] != null)
					model.setCustUrl(custUrl[i]);
				if (intlPhnNo[i] != null)
					model.setIntlPhnNo(intlPhnNo[i]);
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (intlFaxNo[i] != null)
					model.setIntlFaxNo(intlFaxNo[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				
				if (opediInsfId[i] != null)
					model.setOpediInsfId(opediInsfId[i]);
				if (opediInsfDvCd[i] != null) 
		    		model.setOpediInsfDvCd(opediInsfDvCd[i]);
				if (railRoadPrioFlg[i] != null) 
		    		model.setRailRoadPrioFlg(railRoadPrioFlg[i]);
				if (modiCustCd2[i] != null) 
		    		model.setModiCustCd2(modiCustCd2[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCustomerIfVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return CustomerIfVO[]
	 */
    public CustomerIfVO[] getCustomerIfVOs() {
        CustomerIfVO[] vos = (CustomerIfVO[]) models.toArray(new CustomerIfVO[models.size()]);
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
        this.custGrpId = this.custGrpId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custLglEngNm = this.custLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custLoclLangNm = this.custLoclLangNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custAbbrNm = this.custAbbrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrCustTpCd = this.cntrCustTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
        this.keyAcctMgrUsrId = this.keyAcctMgrUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.keyAcctMgrUsrNm = this.keyAcctMgrUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slsDeltEffDt = this.slsDeltEffDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nmdCustFlg = this.nmdCustFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mltTrdAcctFlg = this.mltTrdAcctFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custDivCd = this.custDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.modiCustCd = this.modiCustCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custIfSeq = this.custIfSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.r3InsfId = this.r3InsfId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.r3InsfPrsId = this.r3InsfPrsId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.r3InsfDttm = this.r3InsfDttm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.r3InsfCnqeVal = this.r3InsfCnqeVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.r3InsfDvCd = this.r3InsfDvCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.r3InsfCnqeCont = this.r3InsfCnqeCont.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecomInsfId = this.ecomInsfId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecomInsfPrsId = this.ecomInsfPrsId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecomInsfDttm = this.ecomInsfDttm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecomInsfCnqeVal = this.ecomInsfCnqeVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecomInsfDvCd = this.ecomInsfDvCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecomInsfCnqeCont = this.ecomInsfCnqeCont.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.addrSeq = this.addrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addrTpCd = this.addrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzetAddr = this.bzetAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcEml = this.cntcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzetRmk = this.bzetRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAddr4 = this.loclAddr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAddr3 = this.loclAddr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zipCd = this.zipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm = this.cntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAddr2 = this.loclAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prmryChkFlg = this.prmryChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAddr1 = this.loclAddr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzetNm = this.bzetNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctyNm = this.ctyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCd = this.steCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.custCntcPntSeq = this.custCntcPntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEml = this.custEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custUrl = this.custUrl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intlPhnNo = this.intlPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intlFaxNo = this.intlFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.opediInsfId = this.opediInsfId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.opediInsfDvCd = this.opediInsfDvCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.railRoadPrioFlg = this.railRoadPrioFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.modiCustCd2 = this.modiCustCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
