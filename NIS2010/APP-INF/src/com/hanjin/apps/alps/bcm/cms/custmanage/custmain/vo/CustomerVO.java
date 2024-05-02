/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : CustomerVO.java
*@FileTitle : CustomerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.07  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
public class CustomerVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<CustomerVO> models = new ArrayList<CustomerVO>();

    /* Column Info */
    private String indivCorpDivCd = null;

    /* Column Info */
    private String modiCustSeq = null;

    /* Column Info */
    private String fndtDt = null;

    /* Column Info */
    private String cntrDivFlg = null;

    /* Column Info */
    private String keyAcctEndEffDt = null;

    /* Column Info */
    private String prfCntrTpszCd = null;

    /* Column Info */
    private String bzetAddr = null;

    /* Column Info */
    private String blkCustTpCd = null;

    /* Column Info */
    private String srepCd = null;

    /* Column Info */
    private String keyAcctStEffDt = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String nvoccBdAmt = null;

    /* Column Info */
    private String rvisCntrCustTpCd = null;

    /* Column Info */
    private String bkgAltToDt = null;

    /* Column Info */
    private String locCd = null;

    /* Column Info */
    private String subsCoCd = null;

    /* Column Info */
    private String bfrOfcCngDt = null;

    /* Column Info */
    private String nmdCustFlg = null;

    /* Column Info */
    private String keyAcctMgrUsrNm = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String custCntCd = null;

    /* Column Info */
    private String custGrpId = null;

    /* Column Info */
    private String nvoccBdStEffDt = null;

    /* Column Info */
    private String bkgAltCreDt = null;

    /* Column Info */
    private String invIssCurrTpCd = null;

    /* Column Info */
    private String fincStsLvlCd = null;

    /* Column Info */
    private String custLglEngNm = null;

    /* Column Info */
    private String custRmk = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String frtFwrdFmcNo = null;

    /* Column Info */
    private String vndrSeq = null;

    /* Column Info */
    private String nvoccBdNo = null;

    /* Column Info */
    private String spclReqDesc = null;

    /* Column Info */
    private String nbsClssCd1 = null;

    /* Column Info */
    private String capiAmt = null;

    /* Column Info */
    private String nbsClssCd2 = null;

    /* Column Info */
    private String bkgAltFmDt = null;

    /* Column Info */
    private String bkgAltRsn = null;

    /* Column Info */
    private String nbsClssCd3 = null;

    /* Column Info */
    private String custLoclLangNm = null;

    /* Column Info */
    private String deltFlg = null;

    /* Column Info */
    private String custAbbrNm = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String crmRowId = null;

    /* Column Info */
    private String eaiIfId = null;

    /* Column Info */
    private String prfGrpCmdtCd = null;

    /* Column Info */
    private String custRgstNo = null;

    /* Column Info */
    private String custStsCd = null;

    /* Column Info */
    private String lstkFlg = null;

    /* Column Info */
    private String nvoccBdEndEffDt = null;

    /* Column Info */
    private String nvoccCoScacCd = null;

    /* Column Info */
    private String rfndPsdoVndrSeq = null;

    /* Column Info */
    private String fletMgmtOwnrCustSeq = null;

    /* Column Info */
    private String keyAcctFlg = null;

    /* Column Info */
    private String invIssTpCd = null;

    /* Column Info */
    private String vbsClssCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String blkDivFlg = null;

    /* Column Info */
    private String keyAcctMgrUsrId = null;

    /* Column Info */
    private String bfrOfcCd = null;

    /* Column Info */
    private String cmptDesc = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String slsDeltEffDt = null;

    /* Column Info */
    private String nvoccLicNo = null;

    /* Column Info */
    private String prfRepCmdtCd = null;

    /* Column Info */
    private String capiCurrCd = null;

    /* Column Info */
    private String eaiEvntDt = null;

    /* Column Info */
    private String custSeq = null;

    /* Column Info */
    private String indusDesc = null;

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String prfSvcDesc = null;

    /* Column Info */
    private String bkgAltMsg = null;

    /* Column Info */
    private String crntVolKnt = null;

    /* Column Info */
    private String ctsNo = null;

    /* Column Info */
    private String modiCustCntCd = null;

    /* Column Info */
    private String empeKnt = null;

    /* Column Info */
    private String prfSvcDtlDesc = null;

    /* Column Info */
    private String mltTrdAcctFlg = null;

    /* Column Info */
    private String bkgAltCreUsrId = null;

    /* Column Info */
    private String addrSeq = null;

    /* Column Info */
    private String addrTpCd = null;

    /* Column Info */
    private String cntrCustTpCd = null;

    /* Column Info */
    private String custDivCd = null;

    /* Column Info */
    private String modiCustCd = null;

    /* Column Info */
    private String cnsdCustCnCd = null;

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
    private String custCntcPntSeq = null;

    /* Column Info */
    private String custEml = null;

    /* Column Info */
    private String custUrl = null;

    /* Column Info */
    private String intlPhnNo = null;

    /* Column Info */
    private String phnNo = null;

    /* Column Info */
    private String intlFaxNo = null;

    /* Column Info */
    private String faxNo = null;

    /* Column Info */
    private String railRoadPrioFlg = null;

    /* Column Info */
    private String modiCustCd2 = null;

    /* Column Info */
    private String ediIfFlg = null;

    /* Column Info */
    private String sprtEmlInvFlg = null;

    /* Column Info */
    private String rgnAcctFlg = null;

    /* Column Info */
    private String newKeyAcctFlg = null;

    /* Column Info */
    private String nvoccHjsScacCd = null;

    /* Column Info */
    private String indSteCd = null;

    /* Column Info */
    private String indPanNo = null;

    /* Column Info */
    private String indGstRgstNo = null;

    /* Column Info */
    private String indSezUtFlg = null;

    /* Column Info */
    private String steNm = null;

    /* Column Info */
    private String indTerrDivCd = null;

    /* Column Info */
    private String fileSavId = null;

    /* Column Info */
    private String fileNm = null;

    /* Column Info */
    private String indComTpCd = null;

    /* Column Info */
    private String indCustEml = null;

    /* Column Info */
    private String custCd = null;

    /* Column Info */
    private String steCd = null;

    /* Column Info */
    private String zipCd = null;

    /* Column Info */
    private String otiOrzNo = null;

    /* Column Info */
    private String ctyNm = null;

    /* Column Info */
    private String grpIndivDiv = null;

    /* Column Info */
    private String gloAcctFlg = null;

    /* Column Info */
    private String rfAcctFlg = null;

    /* Column Info */
    private String idaSteCd = null;

    /* Column Info */
    private String idaPanNo = null;

    /* Column Info */
    private String idaGstRgstNo = null;

    /* Column Info */
    private String idaSpclEcnZnUtFlg = null;

    /* Column Info */
    private String idaCoTypeCd = null;

    /* Column Info */
    private String idaCustEml = null;

    /* Column Info */
    private String idaTerrDivCd = null;

    /* Column Info */
    private String rqstNo = null;

    /* Column Info */
    private String custRowId = null;

    /* Column Info */
    private String addrRowId = null;

    /* Column Info */
    private String rqstSts = null;

    /* Column Info */
    private String rqstDt = null;

    /* Column Info */
    private String appDt = null;

    /* Column Info */
    private String mstRqstStsCd = null;

    /* Column Info */
    private String aproDt = null;

    /* Column Info */
    private String aproUsrId = null;

    /* Column Info */
    private String rjctRsnRmk = null;

    /* Column Info */
    private String rjctRsnCd = null;

    /* Column Info */
    private String cudFlg = null;

    /* Column Info */
    private String custAddrStsCd = null;

    /* Column Info */
    private String prmryChkFlg = null;

    /* Column Info */
    private String cntCd = null;

    private String CntAd = null;

    /* Column Info */
    private String coChnTpCd = null;

    /* Column Info */
    private String coChnNo = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public CustomerVO() {
    }

    public CustomerVO(String ibflag, String addrSeq, String addrTpCd, String pagerows, String custCntCd, String custSeq, String cntrDivFlg, String blkDivFlg, String custGrpId, String custLglEngNm, String custLoclLangNm, String custAbbrNm, String rvisCntrCustTpCd, String blkCustTpCd, String indivCorpDivCd, String ofcCd, String fndtDt, String custRgstNo, String fincStsLvlCd, String locCd, String capiCurrCd, String capiAmt, String lstkFlg, String empeKnt, String vndrSeq, String custRmk, String vbsClssCd, String nbsClssCd1, String nbsClssCd2, String nbsClssCd3, String custStsCd, String crmRowId, String nvoccCoScacCd, String nvoccBdNo, String nvoccLicNo, String nvoccBdAmt, String nvoccBdStEffDt, String nvoccBdEndEffDt, String indusDesc, String crntVolKnt, String cmptDesc, String spclReqDesc, String prfSvcDesc, String prfSvcDtlDesc, String prfGrpCmdtCd, String prfCntrTpszCd, String prfRepCmdtCd, String srepCd, String ctsNo, String frtFwrdFmcNo, String keyAcctFlg, String keyAcctStEffDt, String keyAcctEndEffDt, String subsCoCd, String modiCustCntCd, String modiCustSeq, String rfndPsdoVndrSeq, String bfrOfcCd, String bfrOfcCngDt, String creUsrId, String creDt, String updUsrId, String updDt, String deltFlg, String eaiEvntDt, String keyAcctMgrUsrId, String keyAcctMgrUsrNm, String slsDeltEffDt, String fletMgmtOwnrCustSeq, String invIssCurrTpCd, String invIssTpCd, String nmdCustFlg, String bkgAltRsn, String bkgAltFmDt, String bkgAltToDt, String bkgAltMsg, String bkgAltCreUsrId, String bkgAltCreDt, String eaiIfId, String mltTrdAcctFlg, String bzetAddr, String cntrCustTpCd, String custDivCd, String modiCustCd, String cnsdCustCnCd, String cnsdCustSeq, String sprsPayLtrFlg, String payRqstLtrFmtCd, String invEdiLvlCd, String dfltInvCurrDivCd, String custCntcPntSeq, String custEml, String custUrl, String intlPhnNo, String phnNo, String intlFaxNo, String faxNo, String railRoadPrioFlg, String modiCustCd2, String ediIfFlg, String sprtEmlInvFlg, String rgnAcctFlg, String newKeyAcctFlg, String nvoccHjsScacCd, String indSteCd, String indPanNo, String indGstRgstNo, String indSezUtFlg, String steNm, String indTerrDivCd, String fileSavId, String fileNm, String indComTpCd, String indCustEml, String custCd, String steCd, String zipCd, String otiOrzNo, String ctyNm, String grpIndivDiv, String gloAcctFlg, String rfAcctFlg, String idaSteCd, String idaPanNo, String idaGstRgstNo, String idaSpclEcnZnUtFlg, String idaCoTypeCd, String idaCustEml, String idaTerrDivCd, String rqstNo, String custRowId, String addrRowId, String rqstSts, String rqstDt, String appDt, String mstRqstStsCd, String aproDt, String aproUsrId, String rjctRsnRmk, String rjctRsnCd, String cudFlg, String custAddrStsCd, String prmryChkFlg, String cntCd, String coChnTpCd, String coChnNo) {
        this.indivCorpDivCd = indivCorpDivCd;
        this.modiCustSeq = modiCustSeq;
        this.fndtDt = fndtDt;
        this.cntrDivFlg = cntrDivFlg;
        this.keyAcctEndEffDt = keyAcctEndEffDt;
        this.prfCntrTpszCd = prfCntrTpszCd;
        this.bzetAddr = bzetAddr;
        this.blkCustTpCd = blkCustTpCd;
        this.srepCd = srepCd;
        this.keyAcctStEffDt = keyAcctStEffDt;
        this.pagerows = pagerows;
        this.nvoccBdAmt = nvoccBdAmt;
        this.rvisCntrCustTpCd = rvisCntrCustTpCd;
        this.bkgAltToDt = bkgAltToDt;
        this.locCd = locCd;
        this.subsCoCd = subsCoCd;
        this.bfrOfcCngDt = bfrOfcCngDt;
        this.nmdCustFlg = nmdCustFlg;
        this.keyAcctMgrUsrNm = keyAcctMgrUsrNm;
        this.updUsrId = updUsrId;
        this.custCntCd = custCntCd;
        this.custGrpId = custGrpId;
        this.nvoccBdStEffDt = nvoccBdStEffDt;
        this.bkgAltCreDt = bkgAltCreDt;
        this.invIssCurrTpCd = invIssCurrTpCd;
        this.fincStsLvlCd = fincStsLvlCd;
        this.custLglEngNm = custLglEngNm;
        this.custRmk = custRmk;
        this.creUsrId = creUsrId;
        this.frtFwrdFmcNo = frtFwrdFmcNo;
        this.vndrSeq = vndrSeq;
        this.nvoccBdNo = nvoccBdNo;
        this.spclReqDesc = spclReqDesc;
        this.nbsClssCd1 = nbsClssCd1;
        this.capiAmt = capiAmt;
        this.nbsClssCd2 = nbsClssCd2;
        this.bkgAltFmDt = bkgAltFmDt;
        this.bkgAltRsn = bkgAltRsn;
        this.nbsClssCd3 = nbsClssCd3;
        this.custLoclLangNm = custLoclLangNm;
        this.deltFlg = deltFlg;
        this.custAbbrNm = custAbbrNm;
        this.creDt = creDt;
        this.crmRowId = crmRowId;
        this.eaiIfId = eaiIfId;
        this.prfGrpCmdtCd = prfGrpCmdtCd;
        this.custRgstNo = custRgstNo;
        this.custStsCd = custStsCd;
        this.lstkFlg = lstkFlg;
        this.nvoccBdEndEffDt = nvoccBdEndEffDt;
        this.nvoccCoScacCd = nvoccCoScacCd;
        this.rfndPsdoVndrSeq = rfndPsdoVndrSeq;
        this.fletMgmtOwnrCustSeq = fletMgmtOwnrCustSeq;
        this.keyAcctFlg = keyAcctFlg;
        this.invIssTpCd = invIssTpCd;
        this.vbsClssCd = vbsClssCd;
        this.ibflag = ibflag;
        this.blkDivFlg = blkDivFlg;
        this.keyAcctMgrUsrId = keyAcctMgrUsrId;
        this.bfrOfcCd = bfrOfcCd;
        this.cmptDesc = cmptDesc;
        this.updDt = updDt;
        this.slsDeltEffDt = slsDeltEffDt;
        this.nvoccLicNo = nvoccLicNo;
        this.prfRepCmdtCd = prfRepCmdtCd;
        this.capiCurrCd = capiCurrCd;
        this.eaiEvntDt = eaiEvntDt;
        this.custSeq = custSeq;
        this.indusDesc = indusDesc;
        this.ofcCd = ofcCd;
        this.prfSvcDesc = prfSvcDesc;
        this.bkgAltMsg = bkgAltMsg;
        this.crntVolKnt = crntVolKnt;
        this.ctsNo = ctsNo;
        this.modiCustCntCd = modiCustCntCd;
        this.empeKnt = empeKnt;
        this.prfSvcDtlDesc = prfSvcDtlDesc;
        this.mltTrdAcctFlg = mltTrdAcctFlg;
        this.bkgAltCreUsrId = bkgAltCreUsrId;
        this.addrTpCd = addrTpCd;
        this.addrSeq = addrSeq;
        this.cntrCustTpCd = cntrCustTpCd;
        this.custDivCd = custDivCd;
        this.modiCustCd = modiCustCd;
        this.cnsdCustCnCd = cnsdCustCnCd;
        this.cnsdCustSeq = cnsdCustSeq;
        this.sprsPayLtrFlg = sprsPayLtrFlg;
        this.payRqstLtrFmtCd = payRqstLtrFmtCd;
        this.invEdiLvlCd = invEdiLvlCd;
        this.dfltInvCurrDivCd = dfltInvCurrDivCd;
        this.custCntcPntSeq = custCntcPntSeq;
        this.custEml = custEml;
        this.custUrl = custUrl;
        this.intlPhnNo = intlPhnNo;
        this.phnNo = phnNo;
        this.intlFaxNo = intlFaxNo;
        this.faxNo = faxNo;
        this.railRoadPrioFlg = railRoadPrioFlg;
        this.modiCustCd2 = modiCustCd2;
        this.ediIfFlg = ediIfFlg;
        this.sprtEmlInvFlg = sprtEmlInvFlg;
        this.rgnAcctFlg = rgnAcctFlg;
        this.newKeyAcctFlg = newKeyAcctFlg;
        this.nvoccHjsScacCd = nvoccHjsScacCd;
        this.indSteCd = indSteCd;
        this.indPanNo = indPanNo;
        this.indGstRgstNo = indGstRgstNo;
        this.indSezUtFlg = indSezUtFlg;
        this.steNm = steNm;
        this.indTerrDivCd = indTerrDivCd;
        this.fileSavId = fileSavId;
        this.fileNm = fileNm;
        this.indComTpCd = indComTpCd;
        this.indCustEml = indCustEml;
        this.custCd = custCd;
        this.steCd = steCd;
        this.zipCd = zipCd;
        this.otiOrzNo = otiOrzNo;
        this.ctyNm = ctyNm;
        this.grpIndivDiv = grpIndivDiv;
        this.gloAcctFlg = gloAcctFlg;
        this.rfAcctFlg = rfAcctFlg;
        this.idaSteCd = idaSteCd;
        this.idaPanNo = idaPanNo;
        this.idaGstRgstNo = idaGstRgstNo;
        this.idaSpclEcnZnUtFlg = idaSpclEcnZnUtFlg;
        this.idaCoTypeCd = idaCoTypeCd;
        this.idaCustEml = idaCustEml;
        this.idaTerrDivCd = idaTerrDivCd;
        this.rqstNo = rqstNo;
        this.custRowId = custRowId;
        this.addrRowId = addrRowId;
        this.rqstSts = rqstSts;
        this.rqstDt = rqstDt;
        this.appDt = appDt;
        this.mstRqstStsCd = mstRqstStsCd;
        this.aproDt = aproDt;
        this.aproUsrId = aproUsrId;
        this.rjctRsnRmk = rjctRsnRmk;
        this.rjctRsnCd = rjctRsnCd;
        this.cudFlg = cudFlg;
        this.custAddrStsCd = custAddrStsCd;
        this.prmryChkFlg = prmryChkFlg;
        this.cntCd = cntCd;
        this.coChnTpCd = coChnTpCd;
        this.coChnNo = coChnNo;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("indiv_corp_div_cd", getIndivCorpDivCd());
        this.hashColumns.put("modi_cust_seq", getModiCustSeq());
        this.hashColumns.put("fndt_dt", getFndtDt());
        this.hashColumns.put("cntr_div_flg", getCntrDivFlg());
        this.hashColumns.put("key_acct_end_eff_dt", getKeyAcctEndEffDt());
        this.hashColumns.put("prf_cntr_tpsz_cd", getPrfCntrTpszCd());
        this.hashColumns.put("bzet_addr", getBzetAddr());
        this.hashColumns.put("blk_cust_tp_cd", getBlkCustTpCd());
        this.hashColumns.put("srep_cd", getSrepCd());
        this.hashColumns.put("key_acct_st_eff_dt", getKeyAcctStEffDt());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("nvocc_bd_amt", getNvoccBdAmt());
        this.hashColumns.put("rvis_cntr_cust_tp_cd", getRvisCntrCustTpCd());
        this.hashColumns.put("bkg_alt_to_dt", getBkgAltToDt());
        this.hashColumns.put("loc_cd", getLocCd());
        this.hashColumns.put("subs_co_cd", getSubsCoCd());
        this.hashColumns.put("bfr_ofc_cng_dt", getBfrOfcCngDt());
        this.hashColumns.put("nmd_cust_flg", getNmdCustFlg());
        this.hashColumns.put("key_acct_mgr_usr_nm", getKeyAcctMgrUsrNm());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("cust_cnt_cd", getCustCntCd());
        this.hashColumns.put("cust_grp_id", getCustGrpId());
        this.hashColumns.put("nvocc_bd_st_eff_dt", getNvoccBdStEffDt());
        this.hashColumns.put("bkg_alt_cre_dt", getBkgAltCreDt());
        this.hashColumns.put("inv_iss_curr_tp_cd", getInvIssCurrTpCd());
        this.hashColumns.put("finc_sts_lvl_cd", getFincStsLvlCd());
        this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
        this.hashColumns.put("cust_rmk", getCustRmk());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("frt_fwrd_fmc_no", getFrtFwrdFmcNo());
        this.hashColumns.put("vndr_seq", getVndrSeq());
        this.hashColumns.put("nvocc_bd_no", getNvoccBdNo());
        this.hashColumns.put("spcl_req_desc", getSpclReqDesc());
        this.hashColumns.put("nbs_clss_cd1", getNbsClssCd1());
        this.hashColumns.put("capi_amt", getCapiAmt());
        this.hashColumns.put("nbs_clss_cd2", getNbsClssCd2());
        this.hashColumns.put("bkg_alt_fm_dt", getBkgAltFmDt());
        this.hashColumns.put("bkg_alt_rsn", getBkgAltRsn());
        this.hashColumns.put("nbs_clss_cd3", getNbsClssCd3());
        this.hashColumns.put("cust_locl_lang_nm", getCustLoclLangNm());
        this.hashColumns.put("delt_flg", getDeltFlg());
        this.hashColumns.put("cust_abbr_nm", getCustAbbrNm());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("crm_row_id", getCrmRowId());
        this.hashColumns.put("eai_if_id", getEaiIfId());
        this.hashColumns.put("prf_grp_cmdt_cd", getPrfGrpCmdtCd());
        this.hashColumns.put("cust_rgst_no", getCustRgstNo());
        this.hashColumns.put("cust_sts_cd", getCustStsCd());
        this.hashColumns.put("lstk_flg", getLstkFlg());
        this.hashColumns.put("nvocc_bd_end_eff_dt", getNvoccBdEndEffDt());
        this.hashColumns.put("nvocc_co_scac_cd", getNvoccCoScacCd());
        this.hashColumns.put("rfnd_psdo_vndr_seq", getRfndPsdoVndrSeq());
        this.hashColumns.put("flet_mgmt_ownr_cust_seq", getFletMgmtOwnrCustSeq());
        this.hashColumns.put("key_acct_flg", getKeyAcctFlg());
        this.hashColumns.put("inv_iss_tp_cd", getInvIssTpCd());
        this.hashColumns.put("vbs_clss_cd", getVbsClssCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("blk_div_flg", getBlkDivFlg());
        this.hashColumns.put("key_acct_mgr_usr_id", getKeyAcctMgrUsrId());
        this.hashColumns.put("bfr_ofc_cd", getBfrOfcCd());
        this.hashColumns.put("cmpt_desc", getCmptDesc());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("sls_delt_eff_dt", getSlsDeltEffDt());
        this.hashColumns.put("nvocc_lic_no", getNvoccLicNo());
        this.hashColumns.put("prf_rep_cmdt_cd", getPrfRepCmdtCd());
        this.hashColumns.put("capi_curr_cd", getCapiCurrCd());
        this.hashColumns.put("eai_evnt_dt", getEaiEvntDt());
        this.hashColumns.put("cust_seq", getCustSeq());
        this.hashColumns.put("indus_desc", getIndusDesc());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("prf_svc_desc", getPrfSvcDesc());
        this.hashColumns.put("bkg_alt_msg", getBkgAltMsg());
        this.hashColumns.put("crnt_vol_knt", getCrntVolKnt());
        this.hashColumns.put("cts_no", getCtsNo());
        this.hashColumns.put("modi_cust_cnt_cd", getModiCustCntCd());
        this.hashColumns.put("empe_knt", getEmpeKnt());
        this.hashColumns.put("prf_svc_dtl_desc", getPrfSvcDtlDesc());
        this.hashColumns.put("mlt_trd_acct_flg", getMltTrdAcctFlg());
        this.hashColumns.put("bkg_alt_cre_usr_id", getBkgAltCreUsrId());
        this.hashColumns.put("addr_tp_cd", getAddrTpCd());
        this.hashColumns.put("addr_seq", getAddrSeq());
        this.hashColumns.put("cntr_cust_tp_cd", getCntrCustTpCd());
        this.hashColumns.put("cust_div_cd", getCustDivCd());
        this.hashColumns.put("modi_cust_cd", getModiCustCd());
        this.hashColumns.put("cnsd_cust_cnt_cd", getCnsdCustCntCd());
        this.hashColumns.put("cnsd_cust_seq", getCnsdCustSeq());
        this.hashColumns.put("sprs_pay_ltr_flg", getSprsPayLtrFlg());
        this.hashColumns.put("pay_rqst_ltr_fmt_cd", getPayRqstLtrFmtCd());
        this.hashColumns.put("inv_edi_lvl_cd", getInvEdiLvlCd());
        this.hashColumns.put("dflt_inv_curr_div_cd", getDfltInvCurrDivCd());
        this.hashColumns.put("cust_cntc_pnt_seq", getCustCntcPntSeq());
        this.hashColumns.put("cust_eml", getCustEml());
        this.hashColumns.put("cust_url", getCustUrl());
        this.hashColumns.put("intl_phn_no", getIntlPhnNo());
        this.hashColumns.put("phn_no", getPhnNo());
        this.hashColumns.put("intl_fax_no", getIntlFaxNo());
        this.hashColumns.put("fax_no", getFaxNo());
        this.hashColumns.put("rail_road_prio_flg", getRailRoadPrioFlg());
        this.hashColumns.put("modi_cust_cd2", getModiCustCd2());
        this.hashColumns.put("edi_if_flg", getEdiIfFlg());
        this.hashColumns.put("sprt_eml_inv_flg", getSprtEmlInvFlg());
        this.hashColumns.put("rgn_acct_flg", getRgnAcctFlg());
        this.hashColumns.put("new_key_acct_flg", getNewKeyAcctFlg());
        this.hashColumns.put("nvocc_hjs_scac_cd", getNvoccHjsScacCd());
        this.hashColumns.put("ind_ste_cd", getIndSteCd());
        this.hashColumns.put("ind_pan_no", getIndPanNo());
        this.hashColumns.put("ind_gst_rgst_no", getIndGstRgstNo());
        this.hashColumns.put("ind_sez_ut_flg", getIndSezUtFlg());
        this.hashColumns.put("ste_nm", getSteNm());
        this.hashColumns.put("ind_terr_div_cd", getIndTerrDivCd());
        this.hashColumns.put("file_sav_id", getFileSavId());
        this.hashColumns.put("file_nm", getFileNm());
        this.hashColumns.put("ind_com_tp_cd", getIndComTpCd());
        this.hashColumns.put("ind_cust_eml", getIndCustEml());
        this.hashColumns.put("cust_cd", getCustCd());
        this.hashColumns.put("ste_cd", getSteCd());
        this.hashColumns.put("zip_cd", getZipCd());
        this.hashColumns.put("oti_orz_no", getOtiOrzNo());
        this.hashColumns.put("cty_nm", getCtyNm());
        this.hashColumns.put("grp_indiv_div", getGrpIndivDiv());
        this.hashColumns.put("glo_acct_flg", getGloAcctFlg());
        this.hashColumns.put("rf_acct_flg", getRfAcctFlg());
        this.hashColumns.put("ida_ste_cd", getIdaSteCd());
        this.hashColumns.put("ida_pan_no", getIdaPanNo());
        this.hashColumns.put("ida_gst_rgst_no", getIdaGstRgstNo());
        this.hashColumns.put("ida_spcl_ecn_zn_ut_flg", getIdaSpclEcnZnUtFlg());
        this.hashColumns.put("ida_co_type_cd", getIdaCoTypeCd());
        this.hashColumns.put("ida_cust_eml", getIdaCustEml());
        this.hashColumns.put("ida_terr_div_cd", getIdaTerrDivCd());
        this.hashColumns.put("rqst_no", getRqstNo());
        this.hashColumns.put("cust_row_id", getCustRowId());
        this.hashColumns.put("addr_row_id", getAddrRowId());
        this.hashColumns.put("rqst_sts", getRqstSts());
        this.hashColumns.put("rqst_dt", getRqstDt());
        this.hashColumns.put("app_dt", getAppDt());
        this.hashColumns.put("mst_rqst_sts_cd", getMstRqstStsCd());
        this.hashColumns.put("apro_dt", getAproDt());
        this.hashColumns.put("apro_usr_id", getAproUsrId());
        this.hashColumns.put("rjct_rsn_rmk", getRjctRsnRmk());
        this.hashColumns.put("rjct_rsn_cd", getRjctRsnCd());
        this.hashColumns.put("cud_flg", getCudFlg());
        this.hashColumns.put("cust_addr_sts_cd", getCustAddrStsCd());
        this.hashColumns.put("prmry_chk_flg", getPrmryChkFlg());
        this.hashColumns.put("cnt_cd", getCntCd());
        this.hashColumns.put("co_chn_tp_cd", getCoChnTpCd());
        this.hashColumns.put("co_chn_no", getCoChnNo());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("indiv_corp_div_cd", "indivCorpDivCd");
        this.hashFields.put("modi_cust_seq", "modiCustSeq");
        this.hashFields.put("fndt_dt", "fndtDt");
        this.hashFields.put("cntr_div_flg", "cntrDivFlg");
        this.hashFields.put("key_acct_end_eff_dt", "keyAcctEndEffDt");
        this.hashFields.put("prf_cntr_tpsz_cd", "prfCntrTpszCd");
        this.hashFields.put("bzet_addr", "bzetAddr");
        this.hashFields.put("blk_cust_tp_cd", "blkCustTpCd");
        this.hashFields.put("srep_cd", "srepCd");
        this.hashFields.put("key_acct_st_eff_dt", "keyAcctStEffDt");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("nvocc_bd_amt", "nvoccBdAmt");
        this.hashFields.put("rvis_cntr_cust_tp_cd", "rvisCntrCustTpCd");
        this.hashFields.put("bkg_alt_to_dt", "bkgAltToDt");
        this.hashFields.put("loc_cd", "locCd");
        this.hashFields.put("subs_co_cd", "subsCoCd");
        this.hashFields.put("bfr_ofc_cng_dt", "bfrOfcCngDt");
        this.hashFields.put("nmd_cust_flg", "nmdCustFlg");
        this.hashFields.put("key_acct_mgr_usr_nm", "keyAcctMgrUsrNm");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("cust_cnt_cd", "custCntCd");
        this.hashFields.put("cust_grp_id", "custGrpId");
        this.hashFields.put("nvocc_bd_st_eff_dt", "nvoccBdStEffDt");
        this.hashFields.put("bkg_alt_cre_dt", "bkgAltCreDt");
        this.hashFields.put("inv_iss_curr_tp_cd", "invIssCurrTpCd");
        this.hashFields.put("finc_sts_lvl_cd", "fincStsLvlCd");
        this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
        this.hashFields.put("cust_rmk", "custRmk");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("frt_fwrd_fmc_no", "frtFwrdFmcNo");
        this.hashFields.put("vndr_seq", "vndrSeq");
        this.hashFields.put("nvocc_bd_no", "nvoccBdNo");
        this.hashFields.put("spcl_req_desc", "spclReqDesc");
        this.hashFields.put("nbs_clss_cd1", "nbsClssCd1");
        this.hashFields.put("capi_amt", "capiAmt");
        this.hashFields.put("nbs_clss_cd2", "nbsClssCd2");
        this.hashFields.put("bkg_alt_fm_dt", "bkgAltFmDt");
        this.hashFields.put("bkg_alt_rsn", "bkgAltRsn");
        this.hashFields.put("nbs_clss_cd3", "nbsClssCd3");
        this.hashFields.put("cust_locl_lang_nm", "custLoclLangNm");
        this.hashFields.put("delt_flg", "deltFlg");
        this.hashFields.put("cust_abbr_nm", "custAbbrNm");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("crm_row_id", "crmRowId");
        this.hashFields.put("eai_if_id", "eaiIfId");
        this.hashFields.put("prf_grp_cmdt_cd", "prfGrpCmdtCd");
        this.hashFields.put("cust_rgst_no", "custRgstNo");
        this.hashFields.put("cust_sts_cd", "custStsCd");
        this.hashFields.put("lstk_flg", "lstkFlg");
        this.hashFields.put("nvocc_bd_end_eff_dt", "nvoccBdEndEffDt");
        this.hashFields.put("nvocc_co_scac_cd", "nvoccCoScacCd");
        this.hashFields.put("rfnd_psdo_vndr_seq", "rfndPsdoVndrSeq");
        this.hashFields.put("flet_mgmt_ownr_cust_seq", "fletMgmtOwnrCustSeq");
        this.hashFields.put("key_acct_flg", "keyAcctFlg");
        this.hashFields.put("inv_iss_tp_cd", "invIssTpCd");
        this.hashFields.put("vbs_clss_cd", "vbsClssCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("blk_div_flg", "blkDivFlg");
        this.hashFields.put("key_acct_mgr_usr_id", "keyAcctMgrUsrId");
        this.hashFields.put("bfr_ofc_cd", "bfrOfcCd");
        this.hashFields.put("cmpt_desc", "cmptDesc");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("sls_delt_eff_dt", "slsDeltEffDt");
        this.hashFields.put("nvocc_lic_no", "nvoccLicNo");
        this.hashFields.put("prf_rep_cmdt_cd", "prfRepCmdtCd");
        this.hashFields.put("capi_curr_cd", "capiCurrCd");
        this.hashFields.put("eai_evnt_dt", "eaiEvntDt");
        this.hashFields.put("cust_seq", "custSeq");
        this.hashFields.put("indus_desc", "indusDesc");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("prf_svc_desc", "prfSvcDesc");
        this.hashFields.put("bkg_alt_msg", "bkgAltMsg");
        this.hashFields.put("crnt_vol_knt", "crntVolKnt");
        this.hashFields.put("cts_no", "ctsNo");
        this.hashFields.put("modi_cust_cnt_cd", "modiCustCntCd");
        this.hashFields.put("empe_knt", "empeKnt");
        this.hashFields.put("prf_svc_dtl_desc", "prfSvcDtlDesc");
        this.hashFields.put("mlt_trd_acct_flg", "mltTrdAcctFlg");
        this.hashFields.put("bkg_alt_cre_usr_id", "bkgAltCreUsrId");
        this.hashFields.put("addr_tp_cd", "addrTpCd");
        this.hashFields.put("addr_seq", "addrSeq");
        this.hashFields.put("cntr_cust_tp_cd", "cntrCustTpCd");
        this.hashFields.put("cust_div_cd", "custDivCd");
        this.hashFields.put("modi_cust_cd", "modiCustCd");
        this.hashFields.put("cnsd_cust_cnt_cd", "cnsdCustCnCd");
        this.hashFields.put("cnsd_cust_seq", "cnsdCustSeq");
        this.hashFields.put("sprs_pay_ltr_flg", "sprsPayLtrFlg");
        this.hashFields.put("pay_rqst_ltr_fmt_cd", "payRqstLtrFmtCd");
        this.hashFields.put("inv_edi_lvl_cd", "invEdiLvlCd");
        this.hashFields.put("dflt_inv_curr_div_cd", "dfltInvCurrDivCd");
        this.hashFields.put("cust_cntc_pnt_seq", "custCntcPntSeq");
        this.hashFields.put("cust_eml", "custEml");
        this.hashFields.put("cust_url", "custUrl");
        this.hashFields.put("intl_phn_no", "intlPhnNo");
        this.hashFields.put("phn_no", "phnNo");
        this.hashFields.put("intl_fax_no", "intlFaxNo");
        this.hashFields.put("fax_no", "faxNo");
        this.hashFields.put("rail_road_prio_flg", "railRoadPrioFlg");
        this.hashFields.put("modi_cust_cd2", "modiCustCd2");
        this.hashFields.put("edi_if_flg", "ediIfFlg");
        this.hashFields.put("sprt_eml_inv_flg", "sprtEmlInvFlg");
        this.hashFields.put("rgn_acct_flg", "rgnAcctFlg");
        this.hashFields.put("new_key_acct_flg", "newKeyAcctFlg");
        this.hashFields.put("nvocc_hjs_scac_cd", "nvoccHjsScacCd");
        this.hashFields.put("ind_ste_cd", "indSteCd");
        this.hashFields.put("ind_pan_no", "indPanNo");
        this.hashFields.put("ind_gst_rgst_no", "indGstRgstNo");
        this.hashFields.put("ind_sez_ut_flg", "indSezUtFlg");
        this.hashFields.put("ste_nm", "steNm");
        this.hashFields.put("ind_terr_div_cd", "indTerrDivCd");
        this.hashFields.put("file_sav_id", "fileSavId");
        this.hashFields.put("file_nm", "fileNm");
        this.hashFields.put("ind_com_tp_cd", "indComTpCd");
        this.hashFields.put("ind_cust_eml", "indCustEml");
        this.hashFields.put("cust_cd", "custCd");
        this.hashFields.put("ste_cd", "steCd");
        this.hashFields.put("zip_cd", "zipCd");
        this.hashFields.put("oti_orz_no", "otiOrzNo");
        this.hashFields.put("cty_nm", "ctyNm");
        this.hashFields.put("grp_indiv_div", "grpIndivDiv");
        this.hashFields.put("glo_acct_flg", "gloAcctFlg");
        this.hashFields.put("rf_acct_flg", "rfAcctFlg");
        this.hashFields.put("ida_ste_cd", "idaSteCd");
        this.hashFields.put("ida_pan_no", "idaPanNo");
        this.hashFields.put("ida_gst_rgst_no", "idaGstRgstNo");
        this.hashFields.put("ida_spcl_ecn_zn_ut_flg", "idaSpclEcnZnUtFlg");
        this.hashFields.put("ida_co_type_cd", "idaCoTypeCd");
        this.hashFields.put("ida_cust_eml", "idaCustEml");
        this.hashFields.put("ida_terr_div_cd", "idaTerrDivCd");
        this.hashFields.put("rqst_no", "rqstNo");
        this.hashFields.put("cust_row_id", "custRowId");
        this.hashFields.put("addr_row_id", "addrRowId");
        this.hashFields.put("rqst_sts", "rqstSts");
        this.hashFields.put("rqst_dt", "rqstDt");
        this.hashFields.put("app_dt", "appDt");
        this.hashFields.put("mst_rqst_sts_cd", "mstRqstStsCd");
        this.hashFields.put("apro_dt", "aproDt");
        this.hashFields.put("apro_usr_id", "aproUsrId");
        this.hashFields.put("rjct_rsn_rmk", "rjctRsnRmk");
        this.hashFields.put("rjct_rsn_cd", "rjctRsnCd");
        this.hashFields.put("cud_flg", "cudFlg");
        this.hashFields.put("cust_addr_sts_cd", "custAddrStsCd");
        this.hashFields.put("prmry_chk_flg", "prmryChkFlg");
        this.hashFields.put("cnt_cd", "cntCd");
        this.hashFields.put("co_chn_tp_cd", "coChnTpCd");
        this.hashFields.put("co_chn_no", "coChnNo");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return indivCorpDivCd
	 */
    public String getIndivCorpDivCd() {
        return this.indivCorpDivCd;
    }

    /**
	 * Column Info
	 * @return modiCustSeq
	 */
    public String getModiCustSeq() {
        return this.modiCustSeq;
    }

    /**
	 * Column Info
	 * @return fndtDt
	 */
    public String getFndtDt() {
        return this.fndtDt;
    }

    /**
	 * Column Info
	 * @return cntrDivFlg
	 */
    public String getCntrDivFlg() {
        return this.cntrDivFlg;
    }

    /**
	 * Column Info
	 * @return keyAcctEndEffDt
	 */
    public String getKeyAcctEndEffDt() {
        return this.keyAcctEndEffDt;
    }

    /**
	 * Column Info
	 * @return prfCntrTpszCd
	 */
    public String getPrfCntrTpszCd() {
        return this.prfCntrTpszCd;
    }

    /**
	 * Column Info
	 * @return bzetAddr
	 */
    public String getBzetAddr() {
        return this.bzetAddr;
    }

    /**
	 * Column Info
	 * @return blkCustTpCd
	 */
    public String getBlkCustTpCd() {
        return this.blkCustTpCd;
    }

    /**
	 * Column Info
	 * @return srepCd
	 */
    public String getSrepCd() {
        return this.srepCd;
    }

    /**
	 * Column Info
	 * @return keyAcctStEffDt
	 */
    public String getKeyAcctStEffDt() {
        return this.keyAcctStEffDt;
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
	 * @return nvoccBdAmt
	 */
    public String getNvoccBdAmt() {
        return this.nvoccBdAmt;
    }

    /**
	 * Column Info
	 * @return bkgAltToDt
	 */
    public String getBkgAltToDt() {
        return this.bkgAltToDt;
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
	 * @return subsCoCd
	 */
    public String getSubsCoCd() {
        return this.subsCoCd;
    }

    /**
	 * Column Info
	 * @return bfrOfcCngDt
	 */
    public String getBfrOfcCngDt() {
        return this.bfrOfcCngDt;
    }

    /**
	 * Column Info
	 * @return nmdCustFlg
	 */
    public String getNmdCustFlg() {
        return this.nmdCustFlg;
    }

    /**
	 * Column Info
	 * @return keyAcctMgrUsrNm
	 */
    public String getKeyAcctMgrUsrNm() {
        return this.keyAcctMgrUsrNm;
    }

    /**
	 * Column Info
	 * @return updUsrId
	 */
    public String getUpdUsrId() {
        return this.updUsrId;
    }

    /**
	 * Column Info
	 * @return custCntCd
	 */
    public String getCustCntCd() {
        return this.custCntCd;
    }

    /**
	 * Column Info
	 * @return custGrpId
	 */
    public String getCustGrpId() {
        return this.custGrpId;
    }

    /**
	 * Column Info
	 * @return nvoccBdStEffDt
	 */
    public String getNvoccBdStEffDt() {
        return this.nvoccBdStEffDt;
    }

    /**
	 * Column Info
	 * @return bkgAltCreDt
	 */
    public String getBkgAltCreDt() {
        return this.bkgAltCreDt;
    }

    /**
	 * Column Info
	 * @return invIssCurrTpCd
	 */
    public String getInvIssCurrTpCd() {
        return this.invIssCurrTpCd;
    }

    /**
	 * Column Info
	 * @return fincStsLvlCd
	 */
    public String getFincStsLvlCd() {
        return this.fincStsLvlCd;
    }

    /**
	 * Column Info
	 * @return custLglEngNm
	 */
    public String getCustLglEngNm() {
        return this.custLglEngNm;
    }

    /**
	 * Column Info
	 * @return custRmk
	 */
    public String getCustRmk() {
        return this.custRmk;
    }

    /**
	 * Column Info
	 * @return creUsrId
	 */
    public String getCreUsrId() {
        return this.creUsrId;
    }

    /**
	 * Column Info
	 * @return frtFwrdFmcNo
	 */
    public String getFrtFwrdFmcNo() {
        return this.frtFwrdFmcNo;
    }

    /**
	 * Column Info
	 * @return vndrSeq
	 */
    public String getVndrSeq() {
        return this.vndrSeq;
    }

    /**
	 * Column Info
	 * @return nvoccBdNo
	 */
    public String getNvoccBdNo() {
        return this.nvoccBdNo;
    }

    /**
	 * Column Info
	 * @return spclReqDesc
	 */
    public String getSpclReqDesc() {
        return this.spclReqDesc;
    }

    /**
	 * Column Info
	 * @return nbsClssCd1
	 */
    public String getNbsClssCd1() {
        return this.nbsClssCd1;
    }

    /**
	 * Column Info
	 * @return capiAmt
	 */
    public String getCapiAmt() {
        return this.capiAmt;
    }

    /**
	 * Column Info
	 * @return nbsClssCd2
	 */
    public String getNbsClssCd2() {
        return this.nbsClssCd2;
    }

    /**
	 * Column Info
	 * @return bkgAltFmDt
	 */
    public String getBkgAltFmDt() {
        return this.bkgAltFmDt;
    }

    /**
	 * Column Info
	 * @return bkgAltRsn
	 */
    public String getBkgAltRsn() {
        return this.bkgAltRsn;
    }

    /**
	 * Column Info
	 * @return nbsClssCd3
	 */
    public String getNbsClssCd3() {
        return this.nbsClssCd3;
    }

    /**
	 * Column Info
	 * @return custLoclLangNm
	 */
    public String getCustLoclLangNm() {
        return this.custLoclLangNm;
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
	 * @return custAbbrNm
	 */
    public String getCustAbbrNm() {
        return this.custAbbrNm;
    }

    /**
	 * Column Info
	 * @return creDt
	 */
    public String getCreDt() {
        return this.creDt;
    }

    /**
	 * Column Info
	 * @return crmRowId
	 */
    public String getCrmRowId() {
        return this.crmRowId;
    }

    /**
	 * Column Info
	 * @return eaiIfId
	 */
    public String getEaiIfId() {
        return this.eaiIfId;
    }

    /**
	 * Column Info
	 * @return prfGrpCmdtCd
	 */
    public String getPrfGrpCmdtCd() {
        return this.prfGrpCmdtCd;
    }

    /**
	 * Column Info
	 * @return custRgstNo
	 */
    public String getCustRgstNo() {
        return this.custRgstNo;
    }

    /**
	 * Column Info
	 * @return custStsCd
	 */
    public String getCustStsCd() {
        return this.custStsCd;
    }

    /**
	 * Column Info
	 * @return lstkFlg
	 */
    public String getLstkFlg() {
        return this.lstkFlg;
    }

    /**
	 * Column Info
	 * @return nvoccBdEndEffDt
	 */
    public String getNvoccBdEndEffDt() {
        return this.nvoccBdEndEffDt;
    }

    /**
	 * Column Info
	 * @return nvoccCoScacCd
	 */
    public String getNvoccCoScacCd() {
        return this.nvoccCoScacCd;
    }

    /**
	 * Column Info
	 * @return rfndPsdoVndrSeq
	 */
    public String getRfndPsdoVndrSeq() {
        return this.rfndPsdoVndrSeq;
    }

    /**
	 * Column Info
	 * @return fletMgmtOwnrCustSeq
	 */
    public String getFletMgmtOwnrCustSeq() {
        return this.fletMgmtOwnrCustSeq;
    }

    /**
	 * Column Info
	 * @return keyAcctFlg
	 */
    public String getKeyAcctFlg() {
        return this.keyAcctFlg;
    }

    /**
	 * Column Info
	 * @return invIssTpCd
	 */
    public String getInvIssTpCd() {
        return this.invIssTpCd;
    }

    /**
	 * Column Info
	 * @return vbsClssCd
	 */
    public String getVbsClssCd() {
        return this.vbsClssCd;
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
	 * @return blkDivFlg
	 */
    public String getBlkDivFlg() {
        return this.blkDivFlg;
    }

    /**
	 * Column Info
	 * @return keyAcctMgrUsrId
	 */
    public String getKeyAcctMgrUsrId() {
        return this.keyAcctMgrUsrId;
    }

    /**
	 * Column Info
	 * @return bfrOfcCd
	 */
    public String getBfrOfcCd() {
        return this.bfrOfcCd;
    }

    /**
	 * Column Info
	 * @return cmptDesc
	 */
    public String getCmptDesc() {
        return this.cmptDesc;
    }

    /**
	 * Column Info
	 * @return updDt
	 */
    public String getUpdDt() {
        return this.updDt;
    }

    /**
	 * Column Info
	 * @return slsDeltEffDt
	 */
    public String getSlsDeltEffDt() {
        return this.slsDeltEffDt;
    }

    /**
	 * Column Info
	 * @return nvoccLicNo
	 */
    public String getNvoccLicNo() {
        return this.nvoccLicNo;
    }

    /**
	 * Column Info
	 * @return prfRepCmdtCd
	 */
    public String getPrfRepCmdtCd() {
        return this.prfRepCmdtCd;
    }

    /**
	 * Column Info
	 * @return capiCurrCd
	 */
    public String getCapiCurrCd() {
        return this.capiCurrCd;
    }

    /**
	 * Column Info
	 * @return eaiEvntDt
	 */
    public String getEaiEvntDt() {
        return this.eaiEvntDt;
    }

    /**
	 * Column Info
	 * @return custSeq
	 */
    public String getCustSeq() {
        return this.custSeq;
    }

    /**
	 * Column Info
	 * @return indusDesc
	 */
    public String getIndusDesc() {
        return this.indusDesc;
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
	 * @return prfSvcDesc
	 */
    public String getPrfSvcDesc() {
        return this.prfSvcDesc;
    }

    /**
	 * Column Info
	 * @return bkgAltMsg
	 */
    public String getBkgAltMsg() {
        return this.bkgAltMsg;
    }

    /**
	 * Column Info
	 * @return crntVolKnt
	 */
    public String getCrntVolKnt() {
        return this.crntVolKnt;
    }

    /**
	 * Column Info
	 * @return ctsNo
	 */
    public String getCtsNo() {
        return this.ctsNo;
    }

    /**
	 * Column Info
	 * @return modiCustCntCd
	 */
    public String getModiCustCntCd() {
        return this.modiCustCntCd;
    }

    /**
	 * Column Info
	 * @return empeKnt
	 */
    public String getEmpeKnt() {
        return this.empeKnt;
    }

    /**
	 * Column Info
	 * @return prfSvcDtlDesc
	 */
    public String getPrfSvcDtlDesc() {
        return this.prfSvcDtlDesc;
    }

    /**
	 * Column Info
	 * @return mltTrdAcctFlg
	 */
    public String getMltTrdAcctFlg() {
        return this.mltTrdAcctFlg;
    }

    /**
	 * Column Info
	 * @return bkgAltCreUsrId
	 */
    public String getBkgAltCreUsrId() {
        return this.bkgAltCreUsrId;
    }

    /**
	 * Column Info
	 * @return addrSeq
	 */
    public String getAddrSeq() {
        return this.addrSeq;
    }

    /**
	 * Column Info
	 * @return addrTpCd
	 */
    public String getAddrTpCd() {
        return this.addrTpCd;
    }

    public String getCntrCustTpCd() {
        return cntrCustTpCd;
    }

    public String getCustDivCd() {
        return custDivCd;
    }

    /**
	 * Column Info
	 * @return modiCustCd
	 */
    public String getModiCustCd() {
        return this.modiCustCd;
    }

    /**
	 * Column Info
	 * @return cnsdCustCnCd
	 */
    public String getCnsdCustCntCd() {
        return this.cnsdCustCnCd;
    }

    /**
	 * Column Info
	 * @return cnsdCustSeq
	 */
    public String getCnsdCustSeq() {
        return this.cnsdCustSeq;
    }

    /**
	 * Column Info
	 * @return sprsPayLtrFlg
	 */
    public String getSprsPayLtrFlg() {
        return this.sprsPayLtrFlg;
    }

    /**
	 * Column Info
	 * @return payRqstLtrFmtCd
	 */
    public String getPayRqstLtrFmtCd() {
        return this.payRqstLtrFmtCd;
    }

    /**
	 * Column Info
	 * @return invEdiLvlCd
	 */
    public String getInvEdiLvlCd() {
        return this.invEdiLvlCd;
    }

    /**
	 * Column Info
	 * @return dfltInvCurrDivCd
	 */
    public String getDfltInvCurrDivCd() {
        return this.dfltInvCurrDivCd;
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
	 * @return modiCustCd2
	 */
    public String getModiCustCd2() {
        return this.modiCustCd2;
    }

    /**
	 * Column Info
	 * @param indivCorpDivCd
	 */
    public void setIndivCorpDivCd(String indivCorpDivCd) {
        this.indivCorpDivCd = indivCorpDivCd;
    }

    /**
	 * Column Info
	 * @param modiCustSeq
	 */
    public void setModiCustSeq(String modiCustSeq) {
        this.modiCustSeq = modiCustSeq;
    }

    /**
	 * Column Info
	 * @param fndtDt
	 */
    public void setFndtDt(String fndtDt) {
        this.fndtDt = fndtDt;
    }

    /**
	 * Column Info
	 * @param cntrDivFlg
	 */
    public void setCntrDivFlg(String cntrDivFlg) {
        this.cntrDivFlg = cntrDivFlg;
    }

    /**
	 * Column Info
	 * @param keyAcctEndEffDt
	 */
    public void setKeyAcctEndEffDt(String keyAcctEndEffDt) {
        this.keyAcctEndEffDt = keyAcctEndEffDt;
    }

    /**
	 * Column Info
	 * @param prfCntrTpszCd
	 */
    public void setPrfCntrTpszCd(String prfCntrTpszCd) {
        this.prfCntrTpszCd = prfCntrTpszCd;
    }

    /**
	 * Column Info
	 * @param bzetAddr
	 */
    public void setBzetAddr(String bzetAddr) {
        this.bzetAddr = bzetAddr;
    }

    /**
	 * Column Info
	 * @param blkCustTpCd
	 */
    public void setBlkCustTpCd(String blkCustTpCd) {
        this.blkCustTpCd = blkCustTpCd;
    }

    /**
	 * Column Info
	 * @param srepCd
	 */
    public void setSrepCd(String srepCd) {
        this.srepCd = srepCd;
    }

    /**
	 * Column Info
	 * @param keyAcctStEffDt
	 */
    public void setKeyAcctStEffDt(String keyAcctStEffDt) {
        this.keyAcctStEffDt = keyAcctStEffDt;
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
	 * @param nvoccBdAmt
	 */
    public void setNvoccBdAmt(String nvoccBdAmt) {
        this.nvoccBdAmt = nvoccBdAmt;
    }

    /**
	 * Column Info
	 * @param bkgAltToDt
	 */
    public void setBkgAltToDt(String bkgAltToDt) {
        this.bkgAltToDt = bkgAltToDt;
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
	 * @param subsCoCd
	 */
    public void setSubsCoCd(String subsCoCd) {
        this.subsCoCd = subsCoCd;
    }

    /**
	 * Column Info
	 * @param bfrOfcCngDt
	 */
    public void setBfrOfcCngDt(String bfrOfcCngDt) {
        this.bfrOfcCngDt = bfrOfcCngDt;
    }

    /**
	 * Column Info
	 * @param nmdCustFlg
	 */
    public void setNmdCustFlg(String nmdCustFlg) {
        this.nmdCustFlg = nmdCustFlg;
    }

    /**
	 * Column Info
	 * @param keyAcctMgrUsrNm
	 */
    public void setKeyAcctMgrUsrNm(String keyAcctMgrUsrNm) {
        this.keyAcctMgrUsrNm = keyAcctMgrUsrNm;
    }

    /**
	 * Column Info
	 * @param updUsrId
	 */
    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    /**
	 * Column Info
	 * @param custCntCd
	 */
    public void setCustCntCd(String custCntCd) {
        this.custCntCd = custCntCd;
    }

    /**
	 * Column Info
	 * @param custGrpId
	 */
    public void setCustGrpId(String custGrpId) {
        this.custGrpId = custGrpId;
    }

    /**
	 * Column Info
	 * @param nvoccBdStEffDt
	 */
    public void setNvoccBdStEffDt(String nvoccBdStEffDt) {
        this.nvoccBdStEffDt = nvoccBdStEffDt;
    }

    /**
	 * Column Info
	 * @param bkgAltCreDt
	 */
    public void setBkgAltCreDt(String bkgAltCreDt) {
        this.bkgAltCreDt = bkgAltCreDt;
    }

    /**
	 * Column Info
	 * @param invIssCurrTpCd
	 */
    public void setInvIssCurrTpCd(String invIssCurrTpCd) {
        this.invIssCurrTpCd = invIssCurrTpCd;
    }

    /**
	 * Column Info
	 * @param fincStsLvlCd
	 */
    public void setFincStsLvlCd(String fincStsLvlCd) {
        this.fincStsLvlCd = fincStsLvlCd;
    }

    /**
	 * Column Info
	 * @param custLglEngNm
	 */
    public void setCustLglEngNm(String custLglEngNm) {
        this.custLglEngNm = custLglEngNm;
    }

    /**
	 * Column Info
	 * @param custRmk
	 */
    public void setCustRmk(String custRmk) {
        this.custRmk = custRmk;
    }

    /**
	 * Column Info
	 * @param creUsrId
	 */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    /**
	 * Column Info
	 * @param frtFwrdFmcNo
	 */
    public void setFrtFwrdFmcNo(String frtFwrdFmcNo) {
        this.frtFwrdFmcNo = frtFwrdFmcNo;
    }

    /**
	 * Column Info
	 * @param vndrSeq
	 */
    public void setVndrSeq(String vndrSeq) {
        this.vndrSeq = vndrSeq;
    }

    /**
	 * Column Info
	 * @param nvoccBdNo
	 */
    public void setNvoccBdNo(String nvoccBdNo) {
        this.nvoccBdNo = nvoccBdNo;
    }

    /**
	 * Column Info
	 * @param spclReqDesc
	 */
    public void setSpclReqDesc(String spclReqDesc) {
        this.spclReqDesc = spclReqDesc;
    }

    /**
	 * Column Info
	 * @param nbsClssCd1
	 */
    public void setNbsClssCd1(String nbsClssCd1) {
        this.nbsClssCd1 = nbsClssCd1;
    }

    /**
	 * Column Info
	 * @param capiAmt
	 */
    public void setCapiAmt(String capiAmt) {
        this.capiAmt = capiAmt;
    }

    /**
	 * Column Info
	 * @param nbsClssCd2
	 */
    public void setNbsClssCd2(String nbsClssCd2) {
        this.nbsClssCd2 = nbsClssCd2;
    }

    /**
	 * Column Info
	 * @param bkgAltFmDt
	 */
    public void setBkgAltFmDt(String bkgAltFmDt) {
        this.bkgAltFmDt = bkgAltFmDt;
    }

    /**
	 * Column Info
	 * @param bkgAltRsn
	 */
    public void setBkgAltRsn(String bkgAltRsn) {
        this.bkgAltRsn = bkgAltRsn;
    }

    /**
	 * Column Info
	 * @param nbsClssCd3
	 */
    public void setNbsClssCd3(String nbsClssCd3) {
        this.nbsClssCd3 = nbsClssCd3;
    }

    /**
	 * Column Info
	 * @param custLoclLangNm
	 */
    public void setCustLoclLangNm(String custLoclLangNm) {
        this.custLoclLangNm = custLoclLangNm;
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
	 * @param custAbbrNm
	 */
    public void setCustAbbrNm(String custAbbrNm) {
        this.custAbbrNm = custAbbrNm;
    }

    /**
	 * Column Info
	 * @param creDt
	 */
    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    /**
	 * Column Info
	 * @param crmRowId
	 */
    public void setCrmRowId(String crmRowId) {
        this.crmRowId = crmRowId;
    }

    /**
	 * Column Info
	 * @param eaiIfId
	 */
    public void setEaiIfId(String eaiIfId) {
        this.eaiIfId = eaiIfId;
    }

    /**
	 * Column Info
	 * @param prfGrpCmdtCd
	 */
    public void setPrfGrpCmdtCd(String prfGrpCmdtCd) {
        this.prfGrpCmdtCd = prfGrpCmdtCd;
    }

    /**
	 * Column Info
	 * @param custRgstNo
	 */
    public void setCustRgstNo(String custRgstNo) {
        this.custRgstNo = custRgstNo;
    }

    /**
	 * Column Info
	 * @param custStsCd
	 */
    public void setCustStsCd(String custStsCd) {
        this.custStsCd = custStsCd;
    }

    /**
	 * Column Info
	 * @param lstkFlg
	 */
    public void setLstkFlg(String lstkFlg) {
        this.lstkFlg = lstkFlg;
    }

    /**
	 * Column Info
	 * @param nvoccBdEndEffDt
	 */
    public void setNvoccBdEndEffDt(String nvoccBdEndEffDt) {
        this.nvoccBdEndEffDt = nvoccBdEndEffDt;
    }

    /**
	 * Column Info
	 * @param nvoccCoScacCd
	 */
    public void setNvoccCoScacCd(String nvoccCoScacCd) {
        this.nvoccCoScacCd = nvoccCoScacCd;
    }

    /**
	 * Column Info
	 * @param rfndPsdoVndrSeq
	 */
    public void setRfndPsdoVndrSeq(String rfndPsdoVndrSeq) {
        this.rfndPsdoVndrSeq = rfndPsdoVndrSeq;
    }

    /**
	 * Column Info
	 * @param fletMgmtOwnrCustSeq
	 */
    public void setFletMgmtOwnrCustSeq(String fletMgmtOwnrCustSeq) {
        this.fletMgmtOwnrCustSeq = fletMgmtOwnrCustSeq;
    }

    /**
	 * Column Info
	 * @param keyAcctFlg
	 */
    public void setKeyAcctFlg(String keyAcctFlg) {
        this.keyAcctFlg = keyAcctFlg;
    }

    /**
	 * Column Info
	 * @param invIssTpCd
	 */
    public void setInvIssTpCd(String invIssTpCd) {
        this.invIssTpCd = invIssTpCd;
    }

    /**
	 * Column Info
	 * @param vbsClssCd
	 */
    public void setVbsClssCd(String vbsClssCd) {
        this.vbsClssCd = vbsClssCd;
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
	 * @param blkDivFlg
	 */
    public void setBlkDivFlg(String blkDivFlg) {
        this.blkDivFlg = blkDivFlg;
    }

    /**
	 * Column Info
	 * @param keyAcctMgrUsrId
	 */
    public void setKeyAcctMgrUsrId(String keyAcctMgrUsrId) {
        this.keyAcctMgrUsrId = keyAcctMgrUsrId;
    }

    /**
	 * Column Info
	 * @param bfrOfcCd
	 */
    public void setBfrOfcCd(String bfrOfcCd) {
        this.bfrOfcCd = bfrOfcCd;
    }

    /**
	 * Column Info
	 * @param cmptDesc
	 */
    public void setCmptDesc(String cmptDesc) {
        this.cmptDesc = cmptDesc;
    }

    /**
	 * Column Info
	 * @param updDt
	 */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
	 * Column Info
	 * @param slsDeltEffDt
	 */
    public void setSlsDeltEffDt(String slsDeltEffDt) {
        this.slsDeltEffDt = slsDeltEffDt;
    }

    /**
	 * Column Info
	 * @param nvoccLicNo
	 */
    public void setNvoccLicNo(String nvoccLicNo) {
        this.nvoccLicNo = nvoccLicNo;
    }

    /**
	 * Column Info
	 * @param prfRepCmdtCd
	 */
    public void setPrfRepCmdtCd(String prfRepCmdtCd) {
        this.prfRepCmdtCd = prfRepCmdtCd;
    }

    /**
	 * Column Info
	 * @param capiCurrCd
	 */
    public void setCapiCurrCd(String capiCurrCd) {
        this.capiCurrCd = capiCurrCd;
    }

    /**
	 * Column Info
	 * @param eaiEvntDt
	 */
    public void setEaiEvntDt(String eaiEvntDt) {
        this.eaiEvntDt = eaiEvntDt;
    }

    /**
	 * Column Info
	 * @param custSeq
	 */
    public void setCustSeq(String custSeq) {
        this.custSeq = custSeq;
    }

    /**
	 * Column Info
	 * @param indusDesc
	 */
    public void setIndusDesc(String indusDesc) {
        this.indusDesc = indusDesc;
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
	 * @param prfSvcDesc
	 */
    public void setPrfSvcDesc(String prfSvcDesc) {
        this.prfSvcDesc = prfSvcDesc;
    }

    /**
	 * Column Info
	 * @param bkgAltMsg
	 */
    public void setBkgAltMsg(String bkgAltMsg) {
        this.bkgAltMsg = bkgAltMsg;
    }

    /**
	 * Column Info
	 * @param crntVolKnt
	 */
    public void setCrntVolKnt(String crntVolKnt) {
        this.crntVolKnt = crntVolKnt;
    }

    /**
	 * Column Info
	 * @param ctsNo
	 */
    public void setCtsNo(String ctsNo) {
        this.ctsNo = ctsNo;
    }

    /**
	 * Column Info
	 * @param modiCustCntCd
	 */
    public void setModiCustCntCd(String modiCustCntCd) {
        this.modiCustCntCd = modiCustCntCd;
    }

    /**
	 * Column Info
	 * @param empeKnt
	 */
    public void setEmpeKnt(String empeKnt) {
        this.empeKnt = empeKnt;
    }

    /**
	 * Column Info
	 * @param prfSvcDtlDesc
	 */
    public void setPrfSvcDtlDesc(String prfSvcDtlDesc) {
        this.prfSvcDtlDesc = prfSvcDtlDesc;
    }

    /**
	 * Column Info
	 * @param mltTrdAcctFlg
	 */
    public void setMltTrdAcctFlg(String mltTrdAcctFlg) {
        this.mltTrdAcctFlg = mltTrdAcctFlg;
    }

    /**
	 * Column Info
	 * @param bkgAltCreUsrId
	 */
    public void setBkgAltCreUsrId(String bkgAltCreUsrId) {
        this.bkgAltCreUsrId = bkgAltCreUsrId;
    }

    /**
	 * Column Info
	 * @param addrTpCd
	 */
    public void setAddrTpCd(String addrTpCd) {
        this.addrTpCd = addrTpCd;
    }

    /**
	 * Column Info
	 * @param addrSeq
	 */
    public void setAddrSeq(String addrSeq) {
        this.addrSeq = addrSeq;
    }

    public void setCntrCustTpCd(String cntrCustTpCd) {
        this.cntrCustTpCd = cntrCustTpCd;
    }

    public void setCustDivCd(String custDivCd) {
        this.custDivCd = custDivCd;
    }

    /**
	 * Column Info
	 * @param modiCustCd
	 */
    public void setModiCustCd(String modiCustCd) {
        this.modiCustCd = modiCustCd;
    }

    /**
	 * Column Info
	 * @param cnsdCustCnCd
	 */
    public void setCnsdCustCntCd(String cnsdCustCnCd) {
        this.cnsdCustCnCd = cnsdCustCnCd;
    }

    /**
	 * Column Info
	 * @param cnsdCustSeq
	 */
    public void setCnsdCustSeq(String cnsdCustSeq) {
        this.cnsdCustSeq = cnsdCustSeq;
    }

    /**
	 * Column Info
	 * @param sprsPayLtrFlg
	 */
    public void setSprsPayLtrFlg(String sprsPayLtrFlg) {
        this.sprsPayLtrFlg = sprsPayLtrFlg;
    }

    /**
	 * Column Info
	 * @param payRqstLtrFmtCd
	 */
    public void setPayRqstLtrFmtCd(String payRqstLtrFmtCd) {
        this.payRqstLtrFmtCd = payRqstLtrFmtCd;
    }

    /**
	 * Column Info
	 * @param invEdiLvlCd
	 */
    public void setInvEdiLvlCd(String invEdiLvlCd) {
        this.invEdiLvlCd = invEdiLvlCd;
    }

    /**
	 * Column Info
	 * @param dfltInvCurrDivCd
	 */
    public void setDfltInvCurrDivCd(String dfltInvCurrDivCd) {
        this.dfltInvCurrDivCd = dfltInvCurrDivCd;
    }

    /**
	 * Column Info
	 * @param railRoadPrioFlg
	 */
    public void setRailRoadPrioFlg(String railRoadPrioFlg) {
        this.railRoadPrioFlg = railRoadPrioFlg;
    }

    /**
	 * Column Info
	 * @param modiCustCd2
	 */
    public void setModiCustCd2(String modiCustCd2) {
        this.modiCustCd2 = modiCustCd2;
    }

    public String getCnsdCustCnCd() {
        return cnsdCustCnCd;
    }

    public void setCnsdCustCnCd(String cnsdCustCnCd) {
        this.cnsdCustCnCd = cnsdCustCnCd;
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

    public String getEdiIfFlg() {
        return ediIfFlg;
    }

    public void setEdiIfFlg(String ediIfFlg) {
        this.ediIfFlg = ediIfFlg;
    }

    public String getSprtEmlInvFlg() {
        return sprtEmlInvFlg;
    }

    public void setSprtEmlInvFlg(String sprtEmlInvFlg) {
        this.sprtEmlInvFlg = sprtEmlInvFlg;
    }

    public void setRvisCntrCustTpCd(String rvisCntrCustTpCd) {
        this.rvisCntrCustTpCd = rvisCntrCustTpCd;
    }

    public String getRvisCntrCustTpCd() {
        return this.rvisCntrCustTpCd;
    }

    public void setRgnAcctFlg(String rgnAcctFlg) {
        this.rgnAcctFlg = rgnAcctFlg;
    }

    public String getRgnAcctFlg() {
        return this.rgnAcctFlg;
    }

    public void setNewKeyAcctFlg(String newKeyAcctFlg) {
        this.newKeyAcctFlg = newKeyAcctFlg;
    }

    public String getNewKeyAcctFlg() {
        return this.newKeyAcctFlg;
    }

    public void setNvoccHjsScacCd(String nvoccHjsScacCd) {
        this.nvoccHjsScacCd = nvoccHjsScacCd;
    }

    public String getNvoccHjsScacCd() {
        return this.nvoccHjsScacCd;
    }

    public void setIndSteCd(String indSteCd) {
        this.indSteCd = indSteCd;
    }

    public String getIndSteCd() {
        return this.indSteCd;
    }

    public void setIndPanNo(String indPanNo) {
        this.indPanNo = indPanNo;
    }

    public String getIndPanNo() {
        return this.indPanNo;
    }

    public void setIndGstRgstNo(String indGstRgstNo) {
        this.indGstRgstNo = indGstRgstNo;
    }

    public String getIndGstRgstNo() {
        return this.indGstRgstNo;
    }

    public void setIndSezUtFlg(String indSezUtFlg) {
        this.indSezUtFlg = indSezUtFlg;
    }

    public String getIndSezUtFlg() {
        return this.indSezUtFlg;
    }

    public void setSteNm(String steNm) {
        this.steNm = steNm;
    }

    public String getSteNm() {
        return this.steNm;
    }

    public void setIndTerrDivCd(String indTerrDivCd) {
        this.indTerrDivCd = indTerrDivCd;
    }

    public String getIndTerrDivCd() {
        return this.indTerrDivCd;
    }

    public void setFileSavId(String fileSavId) {
        this.fileSavId = fileSavId;
    }

    public String getFileSavId() {
        return this.fileSavId;
    }

    public void setFileNm(String fileNm) {
        this.fileNm = fileNm;
    }

    public String getFileNm() {
        return this.fileNm;
    }

    public void setIndComTpCd(String indComTpCd) {
        this.indComTpCd = indComTpCd;
    }

    public String getIndComTpCd() {
        return this.indComTpCd;
    }

    public void setIndCustEml(String indCustEml) {
        this.indCustEml = indCustEml;
    }

    public String getIndCustEml() {
        return this.indCustEml;
    }

    public void setCustCd(String custCd) {
        this.custCd = custCd;
    }

    public String getCustCd() {
        return this.custCd;
    }

    public void setSteCd(String steCd) {
        this.steCd = steCd;
    }

    public String getSteCd() {
        return this.steCd;
    }

    public void setZipCd(String zipCd) {
        this.zipCd = zipCd;
    }

    public String getZipCd() {
        return this.zipCd;
    }

    public void setOtiOrzNo(String otiOrzNo) {
        this.otiOrzNo = otiOrzNo;
    }

    public String getOtiOrzNo() {
        return this.otiOrzNo;
    }

    public void setCtyNm(String ctyNm) {
        this.ctyNm = ctyNm;
    }

    public String getCtyNm() {
        return this.ctyNm;
    }

    public void setGrpIndivDiv(String grpIndivDiv) {
        this.grpIndivDiv = grpIndivDiv;
    }

    public String getGrpIndivDiv() {
        return this.grpIndivDiv;
    }

    public void setGloAcctFlg(String gloAcctFlg) {
        this.gloAcctFlg = gloAcctFlg;
    }

    public String getGloAcctFlg() {
        return this.gloAcctFlg;
    }

    public void setRfAcctFlg(String rfAcctFlg) {
        this.rfAcctFlg = rfAcctFlg;
    }

    public String getRfAcctFlg() {
        return this.rfAcctFlg;
    }

    public void setIdaSteCd(String idaSteCd) {
        this.idaSteCd = idaSteCd;
    }

    public String getIdaSteCd() {
        return this.idaSteCd;
    }

    public void setIdaPanNo(String idaPanNo) {
        this.idaPanNo = idaPanNo;
    }

    public String getIdaPanNo() {
        return this.idaPanNo;
    }

    public void setIdaGstRgstNo(String idaGstRgstNo) {
        this.idaGstRgstNo = idaGstRgstNo;
    }

    public String getIdaGstRgstNo() {
        return this.idaGstRgstNo;
    }

    public void setIdaSpclEcnZnUtFlg(String idaSpclEcnZnUtFlg) {
        this.idaSpclEcnZnUtFlg = idaSpclEcnZnUtFlg;
    }

    public String getIdaSpclEcnZnUtFlg() {
        return this.idaSpclEcnZnUtFlg;
    }

    public void setIdaCoTypeCd(String idaCoTypeCd) {
        this.idaCoTypeCd = idaCoTypeCd;
    }

    public String getIdaCoTypeCd() {
        return this.idaCoTypeCd;
    }

    public void setIdaCustEml(String idaCustEml) {
        this.idaCustEml = idaCustEml;
    }

    public String getIdaCustEml() {
        return this.idaCustEml;
    }

    public void setIdaTerrDivCd(String idaTerrDivCd) {
        this.idaTerrDivCd = idaTerrDivCd;
    }

    public String getIdaTerrDivCd() {
        return this.idaTerrDivCd;
    }

    public void setRqstNo(String rqstNo) {
        this.rqstNo = rqstNo;
    }

    public String getRqstNo() {
        return this.rqstNo;
    }

    public void setCustRowId(String custRowId) {
        this.custRowId = custRowId;
    }

    public String getCustRowId() {
        return this.custRowId;
    }

    public void setAddrRowId(String addrRowId) {
        this.addrRowId = addrRowId;
    }

    public String getAddrRowId() {
        return this.addrRowId;
    }

    public void setRqstSts(String rqstSts) {
        this.rqstSts = rqstSts;
    }

    public String getRqstSts() {
        return this.rqstSts;
    }

    public void setRqstDt(String rqstDt) {
        this.rqstDt = rqstDt;
    }

    public String getRqstDt() {
        return this.rqstDt;
    }

    public void setAppDt(String appDt) {
        this.appDt = appDt;
    }

    public String getAppDt() {
        return this.appDt;
    }

    public void setMstRqstStsCd(String mstRqstStsCd) {
        this.mstRqstStsCd = mstRqstStsCd;
    }

    public String getMstRqstStsCd() {
        return this.mstRqstStsCd;
    }

    public void setAproDt(String aproDt) {
        this.aproDt = aproDt;
    }

    public String getAproDt() {
        return this.aproDt;
    }

    public void setAproUsrId(String aproUsrId) {
        this.aproUsrId = aproUsrId;
    }

    public String getAproUsrId() {
        return this.aproUsrId;
    }

    public void setRjctRsnRmk(String rjctRsnRmk) {
        this.rjctRsnRmk = rjctRsnRmk;
    }

    public String getRjctRsnRmk() {
        return this.rjctRsnRmk;
    }

    public void setRjctRsnCd(String rjctRsnCd) {
        this.rjctRsnCd = rjctRsnCd;
    }

    public String getRjctRsnCd() {
        return this.rjctRsnCd;
    }

    public void setCudFlg(String cudFlg) {
        this.cudFlg = cudFlg;
    }

    public String getCudFlg() {
        return this.cudFlg;
    }

    public void setCustAddrStsCd(String custAddrStsCd) {
        this.custAddrStsCd = custAddrStsCd;
    }

    public String getCustAddrStsCd() {
        return this.custAddrStsCd;
    }

    public void setPrmryChkFlg(String prmryChkFlg) {
        this.prmryChkFlg = prmryChkFlg;
    }

    public String getPrmryChkFlg() {
        return this.prmryChkFlg;
    }

    public void setCntCd(String cntCd) {
        this.cntCd = cntCd;
    }

    public String getCntCd() {
        return this.cntCd;
    }

    public void setCoChnTpCd(String coChnTpCd) {
        this.coChnTpCd = coChnTpCd;
    }

    public String getCoChnTpCd() {
        return this.coChnTpCd;
    }

    public void setCoChnNo(String coChnNo) {
        this.coChnNo = coChnNo;
    }

    public String getCoChnNo() {
        return this.coChnNo;
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
        setIndivCorpDivCd(JSPUtil.getParameter(request, prefix + "indiv_corp_div_cd", ""));
        setModiCustSeq(JSPUtil.getParameter(request, prefix + "modi_cust_seq", ""));
        setFndtDt(JSPUtil.getParameter(request, prefix + "fndt_dt", ""));
        setCntrDivFlg(JSPUtil.getParameter(request, prefix + "cntr_div_flg", ""));
        setKeyAcctEndEffDt(JSPUtil.getParameter(request, prefix + "key_acct_end_eff_dt", ""));
        setPrfCntrTpszCd(JSPUtil.getParameter(request, prefix + "prf_cntr_tpsz_cd", ""));
        setBzetAddr(JSPUtil.getParameter(request, prefix + "bzet_addr", ""));
        setBlkCustTpCd(JSPUtil.getParameter(request, prefix + "blk_cust_tp_cd", ""));
        setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
        setKeyAcctStEffDt(JSPUtil.getParameter(request, prefix + "key_acct_st_eff_dt", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setNvoccBdAmt(JSPUtil.getParameter(request, prefix + "nvocc_bd_amt", ""));
        setRvisCntrCustTpCd(JSPUtil.getParameter(request, prefix + "rvis_cntr_cust_tp_cd", ""));
        setBkgAltToDt(JSPUtil.getParameter(request, prefix + "bkg_alt_to_dt", ""));
        setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
        setSubsCoCd(JSPUtil.getParameter(request, prefix + "subs_co_cd", ""));
        setBfrOfcCngDt(JSPUtil.getParameter(request, prefix + "bfr_ofc_cng_dt", ""));
        setNmdCustFlg(JSPUtil.getParameter(request, prefix + "nmd_cust_flg", ""));
        setKeyAcctMgrUsrNm(JSPUtil.getParameter(request, prefix + "key_acct_mgr_usr_nm", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
        setCustGrpId(JSPUtil.getParameter(request, prefix + "cust_grp_id", ""));
        setNvoccBdStEffDt(JSPUtil.getParameter(request, prefix + "nvocc_bd_st_eff_dt", ""));
        setBkgAltCreDt(JSPUtil.getParameter(request, prefix + "bkg_alt_cre_dt", ""));
        setInvIssCurrTpCd(JSPUtil.getParameter(request, prefix + "inv_iss_curr_tp_cd", ""));
        setFincStsLvlCd(JSPUtil.getParameter(request, prefix + "finc_sts_lvl_cd", ""));
        setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
        setCustRmk(JSPUtil.getParameter(request, prefix + "cust_rmk", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setFrtFwrdFmcNo(JSPUtil.getParameter(request, prefix + "frt_fwrd_fmc_no", ""));
        setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
        setNvoccBdNo(JSPUtil.getParameter(request, prefix + "nvocc_bd_no", ""));
        setSpclReqDesc(JSPUtil.getParameter(request, prefix + "spcl_req_desc", ""));
        setNbsClssCd1(JSPUtil.getParameter(request, prefix + "nbs_clss_cd1", ""));
        setCapiAmt(JSPUtil.getParameter(request, prefix + "capi_amt", ""));
        setNbsClssCd2(JSPUtil.getParameter(request, prefix + "nbs_clss_cd2", ""));
        setBkgAltFmDt(JSPUtil.getParameter(request, prefix + "bkg_alt_fm_dt", ""));
        setBkgAltRsn(JSPUtil.getParameter(request, prefix + "bkg_alt_rsn", ""));
        setNbsClssCd3(JSPUtil.getParameter(request, prefix + "nbs_clss_cd3", ""));
        setCustLoclLangNm(JSPUtil.getParameter(request, prefix + "cust_locl_lang_nm", ""));
        setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
        setCustAbbrNm(JSPUtil.getParameter(request, prefix + "cust_abbr_nm", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setCrmRowId(JSPUtil.getParameter(request, prefix + "crm_row_id", ""));
        setEaiIfId(JSPUtil.getParameter(request, prefix + "eai_if_id", ""));
        setPrfGrpCmdtCd(JSPUtil.getParameter(request, prefix + "prf_grp_cmdt_cd", ""));
        setCustRgstNo(JSPUtil.getParameter(request, prefix + "cust_rgst_no", ""));
        setCustStsCd(JSPUtil.getParameter(request, prefix + "cust_sts_cd", ""));
        setLstkFlg(JSPUtil.getParameter(request, prefix + "lstk_flg", ""));
        setNvoccBdEndEffDt(JSPUtil.getParameter(request, prefix + "nvocc_bd_end_eff_dt", ""));
        setNvoccCoScacCd(JSPUtil.getParameter(request, prefix + "nvocc_co_scac_cd", ""));
        setRfndPsdoVndrSeq(JSPUtil.getParameter(request, prefix + "rfnd_psdo_vndr_seq", ""));
        setFletMgmtOwnrCustSeq(JSPUtil.getParameter(request, prefix + "flet_mgmt_ownr_cust_seq", ""));
        setKeyAcctFlg(JSPUtil.getParameter(request, prefix + "key_acct_flg", ""));
        setInvIssTpCd(JSPUtil.getParameter(request, prefix + "inv_iss_tp_cd", ""));
        setVbsClssCd(JSPUtil.getParameter(request, prefix + "vbs_clss_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setBlkDivFlg(JSPUtil.getParameter(request, prefix + "blk_div_flg", ""));
        setKeyAcctMgrUsrId(JSPUtil.getParameter(request, prefix + "key_acct_mgr_usr_id", ""));
        setBfrOfcCd(JSPUtil.getParameter(request, prefix + "bfr_ofc_cd", ""));
        setCmptDesc(JSPUtil.getParameter(request, prefix + "cmpt_desc", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setSlsDeltEffDt(JSPUtil.getParameter(request, prefix + "sls_delt_eff_dt", ""));
        setNvoccLicNo(JSPUtil.getParameter(request, prefix + "nvocc_lic_no", ""));
        setPrfRepCmdtCd(JSPUtil.getParameter(request, prefix + "prf_rep_cmdt_cd", ""));
        setCapiCurrCd(JSPUtil.getParameter(request, prefix + "capi_curr_cd", ""));
        setEaiEvntDt(JSPUtil.getParameter(request, prefix + "eai_evnt_dt", ""));
        setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
        setIndusDesc(JSPUtil.getParameter(request, prefix + "indus_desc", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setPrfSvcDesc(JSPUtil.getParameter(request, prefix + "prf_svc_desc", ""));
        setBkgAltMsg(JSPUtil.getParameter(request, prefix + "bkg_alt_msg", ""));
        setCrntVolKnt(JSPUtil.getParameter(request, prefix + "crnt_vol_knt", ""));
        setCtsNo(JSPUtil.getParameter(request, prefix + "cts_no", ""));
        setModiCustCntCd(JSPUtil.getParameter(request, prefix + "modi_cust_cnt_cd", ""));
        setEmpeKnt(JSPUtil.getParameter(request, prefix + "empe_knt", ""));
        setPrfSvcDtlDesc(JSPUtil.getParameter(request, prefix + "prf_svc_dtl_desc", ""));
        setMltTrdAcctFlg(JSPUtil.getParameter(request, prefix + "mlt_trd_acct_flg", ""));
        setBkgAltCreUsrId(JSPUtil.getParameter(request, prefix + "bkg_alt_cre_usr_id", ""));
        setAddrSeq(JSPUtil.getParameter(request, prefix + "addr_seq", ""));
        setAddrTpCd(JSPUtil.getParameter(request, prefix + "addr_tp_cd", ""));
        setCntrCustTpCd(JSPUtil.getParameter(request, prefix + "cntr_cust_tp_cd", ""));
        setCustDivCd(JSPUtil.getParameter(request, prefix + "cust_div_cd", ""));
        setModiCustCd(JSPUtil.getParameter(request, prefix + "modi_cust_cd", ""));
        setCnsdCustCntCd(JSPUtil.getParameter(request, prefix + "cnsd_cust_cnt_cd", ""));
        setCnsdCustSeq(JSPUtil.getParameter(request, prefix + "cnsd_cust_seq", ""));
        setSprsPayLtrFlg(JSPUtil.getParameter(request, prefix + "sprs_pay_ltr_flg", ""));
        setPayRqstLtrFmtCd(JSPUtil.getParameter(request, prefix + "pay_rqst_ltr_fmt_cd", ""));
        setInvEdiLvlCd(JSPUtil.getParameter(request, prefix + "inv_edi_lvl_cd", ""));
        setDfltInvCurrDivCd(JSPUtil.getParameter(request, prefix + "dflt_inv_curr_div_cd", ""));
        setCustCntcPntSeq(JSPUtil.getParameter(request, prefix + "cust_cntc_pnt_seq", ""));
        setCustEml(JSPUtil.getParameter(request, prefix + "cust_eml", ""));
        setCustUrl(JSPUtil.getParameter(request, prefix + "cust_url", ""));
        setIntlPhnNo(JSPUtil.getParameter(request, prefix + "intl_phn_no", ""));
        setPhnNo(JSPUtil.getParameter(request, prefix + "phn_no", ""));
        setIntlFaxNo(JSPUtil.getParameter(request, prefix + "intl_fax_no", ""));
        setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
        setRailRoadPrioFlg(JSPUtil.getParameter(request, prefix + "rail_road_prio_flg", ""));
        setModiCustCd2(JSPUtil.getParameter(request, prefix + "modi_cust_cd2", ""));
        setEdiIfFlg(JSPUtil.getParameter(request, prefix + "edi_if_flg", ""));
        setSprtEmlInvFlg(JSPUtil.getParameter(request, prefix + "sprt_eml_inv_flg", ""));
        setRgnAcctFlg(JSPUtil.getParameter(request, prefix + "rgn_acct_flg", ""));
        setNewKeyAcctFlg(JSPUtil.getParameter(request, prefix + "new_key_acct_flg", ""));
        setNvoccHjsScacCd(JSPUtil.getParameter(request, prefix + "nvocc_hjs_scac_cd", ""));
        setIndSteCd(JSPUtil.getParameter(request, prefix + "ind_ste_cd", ""));
        setIndPanNo(JSPUtil.getParameter(request, prefix + "ind_pan_no", ""));
        setIndGstRgstNo(JSPUtil.getParameter(request, prefix + "ind_gst_rgst_no", ""));
        setIndSezUtFlg(JSPUtil.getParameter(request, prefix + "ind_sez_ut_flg", ""));
        setSteNm(JSPUtil.getParameter(request, prefix + "ste_nm", ""));
        setIndTerrDivCd(JSPUtil.getParameter(request, prefix + "ind_terr_div_cd", ""));
        setFileSavId(JSPUtil.getParameter(request, prefix + "file_sav_id", ""));
        setFileNm(JSPUtil.getParameter(request, prefix + "file_nm", ""));
        setIndComTpCd(JSPUtil.getParameter(request, prefix + "ind_com_tp_cd", ""));
        setIndCustEml(JSPUtil.getParameter(request, prefix + "ind_cust_eml", ""));
        setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
        setSteCd(JSPUtil.getParameter(request, prefix + "ste_cd", ""));
        setZipCd(JSPUtil.getParameter(request, prefix + "zip_cd", ""));
        setOtiOrzNo(JSPUtil.getParameter(request, prefix + "oti_orz_no", ""));
        setCtyNm(JSPUtil.getParameter(request, prefix + "cty_nm", ""));
        setGrpIndivDiv(JSPUtil.getParameter(request, prefix + "grp_indiv_div", ""));
        setGloAcctFlg(JSPUtil.getParameter(request, prefix + "glo_acct_flg", ""));
        setRfAcctFlg(JSPUtil.getParameter(request, prefix + "rf_acct_flg", ""));
        setIdaSteCd(JSPUtil.getParameter(request, prefix + "ida_ste_cd", ""));
        setIdaPanNo(JSPUtil.getParameter(request, prefix + "ida_pan_no", ""));
        setIdaGstRgstNo(JSPUtil.getParameter(request, prefix + "ida_gst_rgst_no", ""));
        setIdaSpclEcnZnUtFlg(JSPUtil.getParameter(request, prefix + "ida_spcl_ecn_zn_ut_flg", ""));
        setIdaCoTypeCd(JSPUtil.getParameter(request, prefix + "ida_co_type_cd", ""));
        setIdaCustEml(JSPUtil.getParameter(request, prefix + "ida_cust_eml", ""));
        setIdaTerrDivCd(JSPUtil.getParameter(request, prefix + "ida_terr_div_cd", ""));
        setRqstNo(JSPUtil.getParameter(request, prefix + "rqst_no", ""));
        setCustRowId(JSPUtil.getParameter(request, prefix + "cust_row_id", ""));
        setAddrRowId(JSPUtil.getParameter(request, prefix + "addr_row_id", ""));
        setRqstSts(JSPUtil.getParameter(request, prefix + "rqst_sts", ""));
        setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
        setAppDt(JSPUtil.getParameter(request, prefix + "app_dt", ""));
        setMstRqstStsCd(JSPUtil.getParameter(request, prefix + "mst_rqst_sts_cd", ""));
        setAproDt(JSPUtil.getParameter(request, prefix + "apro_dt", ""));
        setAproUsrId(JSPUtil.getParameter(request, prefix + "apro_usr_id", ""));
        setRjctRsnRmk(JSPUtil.getParameter(request, prefix + "rjct_rsn_rmk", ""));
        setRjctRsnCd(JSPUtil.getParameter(request, prefix + "rjct_rsn_cd", ""));
        setCudFlg(JSPUtil.getParameter(request, prefix + "cud_flg", ""));
        setCustAddrStsCd(JSPUtil.getParameter(request, prefix + "cust_addr_sts_cd", ""));
        setPrmryChkFlg(JSPUtil.getParameter(request, prefix + "prmry_chk_flg", ""));
        setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
        setCoChnTpCd(JSPUtil.getParameter(request, prefix + "co_chn_tp_cd", ""));
        setCoChnNo(JSPUtil.getParameter(request, prefix + "co_chn_no", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomerVO[]
	 */
    public CustomerVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomerVO[]
	 */
    public CustomerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CustomerVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] indivCorpDivCd = (JSPUtil.getParameter(request, prefix + "indiv_corp_div_cd", length));
            String[] modiCustSeq = (JSPUtil.getParameter(request, prefix + "modi_cust_seq", length));
            String[] fndtDt = (JSPUtil.getParameter(request, prefix + "fndt_dt", length));
            String[] cntrDivFlg = (JSPUtil.getParameter(request, prefix + "cntr_div_flg", length));
            String[] keyAcctEndEffDt = (JSPUtil.getParameter(request, prefix + "key_acct_end_eff_dt", length));
            String[] prfCntrTpszCd = (JSPUtil.getParameter(request, prefix + "prf_cntr_tpsz_cd", length));
            String[] bzetAddr = (JSPUtil.getParameter(request, prefix + "bzet_addr", length));
            String[] blkCustTpCd = (JSPUtil.getParameter(request, prefix + "blk_cust_tp_cd", length));
            String[] srepCd = (JSPUtil.getParameter(request, prefix + "srep_cd", length));
            String[] keyAcctStEffDt = (JSPUtil.getParameter(request, prefix + "key_acct_st_eff_dt", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] nvoccBdAmt = (JSPUtil.getParameter(request, prefix + "nvocc_bd_amt", length));
            String[] rvisCntrCustTpCd = (JSPUtil.getParameter(request, prefix + "rvis_cntr_cust_tp_cd", length));
            String[] bkgAltToDt = (JSPUtil.getParameter(request, prefix + "bkg_alt_to_dt", length));
            String[] locCd = (JSPUtil.getParameter(request, prefix + "loc_cd", length));
            String[] subsCoCd = (JSPUtil.getParameter(request, prefix + "subs_co_cd", length));
            String[] bfrOfcCngDt = (JSPUtil.getParameter(request, prefix + "bfr_ofc_cng_dt", length));
            String[] nmdCustFlg = (JSPUtil.getParameter(request, prefix + "nmd_cust_flg", length));
            String[] keyAcctMgrUsrNm = (JSPUtil.getParameter(request, prefix + "key_acct_mgr_usr_nm", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
            String[] custGrpId = (JSPUtil.getParameter(request, prefix + "cust_grp_id", length));
            String[] nvoccBdStEffDt = (JSPUtil.getParameter(request, prefix + "nvocc_bd_st_eff_dt", length));
            String[] bkgAltCreDt = (JSPUtil.getParameter(request, prefix + "bkg_alt_cre_dt", length));
            String[] invIssCurrTpCd = (JSPUtil.getParameter(request, prefix + "inv_iss_curr_tp_cd", length));
            String[] fincStsLvlCd = (JSPUtil.getParameter(request, prefix + "finc_sts_lvl_cd", length));
            String[] custLglEngNm = (JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", length));
            String[] custRmk = (JSPUtil.getParameter(request, prefix + "cust_rmk", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] frtFwrdFmcNo = (JSPUtil.getParameter(request, prefix + "frt_fwrd_fmc_no", length));
            String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq", length));
            String[] nvoccBdNo = (JSPUtil.getParameter(request, prefix + "nvocc_bd_no", length));
            String[] spclReqDesc = (JSPUtil.getParameter(request, prefix + "spcl_req_desc", length));
            String[] nbsClssCd1 = (JSPUtil.getParameter(request, prefix + "nbs_clss_cd1", length));
            String[] capiAmt = (JSPUtil.getParameter(request, prefix + "capi_amt", length));
            String[] nbsClssCd2 = (JSPUtil.getParameter(request, prefix + "nbs_clss_cd2", length));
            String[] bkgAltFmDt = (JSPUtil.getParameter(request, prefix + "bkg_alt_fm_dt", length));
            String[] bkgAltRsn = (JSPUtil.getParameter(request, prefix + "bkg_alt_rsn", length));
            String[] nbsClssCd3 = (JSPUtil.getParameter(request, prefix + "nbs_clss_cd3", length));
            String[] custLoclLangNm = (JSPUtil.getParameter(request, prefix + "cust_locl_lang_nm", length));
            String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
            String[] custAbbrNm = (JSPUtil.getParameter(request, prefix + "cust_abbr_nm", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] crmRowId = (JSPUtil.getParameter(request, prefix + "crm_row_id", length));
            String[] eaiIfId = (JSPUtil.getParameter(request, prefix + "eai_if_id", length));
            String[] prfGrpCmdtCd = (JSPUtil.getParameter(request, prefix + "prf_grp_cmdt_cd", length));
            String[] custRgstNo = (JSPUtil.getParameter(request, prefix + "cust_rgst_no", length));
            String[] custStsCd = (JSPUtil.getParameter(request, prefix + "cust_sts_cd", length));
            String[] lstkFlg = (JSPUtil.getParameter(request, prefix + "lstk_flg", length));
            String[] nvoccBdEndEffDt = (JSPUtil.getParameter(request, prefix + "nvocc_bd_end_eff_dt", length));
            String[] nvoccCoScacCd = (JSPUtil.getParameter(request, prefix + "nvocc_co_scac_cd", length));
            String[] rfndPsdoVndrSeq = (JSPUtil.getParameter(request, prefix + "rfnd_psdo_vndr_seq", length));
            String[] fletMgmtOwnrCustSeq = (JSPUtil.getParameter(request, prefix + "flet_mgmt_ownr_cust_seq", length));
            String[] keyAcctFlg = (JSPUtil.getParameter(request, prefix + "key_acct_flg", length));
            String[] invIssTpCd = (JSPUtil.getParameter(request, prefix + "inv_iss_tp_cd", length));
            String[] vbsClssCd = (JSPUtil.getParameter(request, prefix + "vbs_clss_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] blkDivFlg = (JSPUtil.getParameter(request, prefix + "blk_div_flg", length));
            String[] keyAcctMgrUsrId = (JSPUtil.getParameter(request, prefix + "key_acct_mgr_usr_id", length));
            String[] bfrOfcCd = (JSPUtil.getParameter(request, prefix + "bfr_ofc_cd", length));
            String[] cmptDesc = (JSPUtil.getParameter(request, prefix + "cmpt_desc", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] slsDeltEffDt = (JSPUtil.getParameter(request, prefix + "sls_delt_eff_dt", length));
            String[] nvoccLicNo = (JSPUtil.getParameter(request, prefix + "nvocc_lic_no", length));
            String[] prfRepCmdtCd = (JSPUtil.getParameter(request, prefix + "prf_rep_cmdt_cd", length));
            String[] capiCurrCd = (JSPUtil.getParameter(request, prefix + "capi_curr_cd", length));
            String[] eaiEvntDt = (JSPUtil.getParameter(request, prefix + "eai_evnt_dt", length));
            String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
            String[] indusDesc = (JSPUtil.getParameter(request, prefix + "indus_desc", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] prfSvcDesc = (JSPUtil.getParameter(request, prefix + "prf_svc_desc", length));
            String[] bkgAltMsg = (JSPUtil.getParameter(request, prefix + "bkg_alt_msg", length));
            String[] crntVolKnt = (JSPUtil.getParameter(request, prefix + "crnt_vol_knt", length));
            String[] ctsNo = (JSPUtil.getParameter(request, prefix + "cts_no", length));
            String[] modiCustCntCd = (JSPUtil.getParameter(request, prefix + "modi_cust_cnt_cd", length));
            String[] empeKnt = (JSPUtil.getParameter(request, prefix + "empe_knt", length));
            String[] prfSvcDtlDesc = (JSPUtil.getParameter(request, prefix + "prf_svc_dtl_desc", length));
            String[] mltTrdAcctFlg = (JSPUtil.getParameter(request, prefix + "mlt_trd_acct_flg", length));
            String[] bkgAltCreUsrId = (JSPUtil.getParameter(request, prefix + "bkg_alt_cre_usr_id", length));
            String[] addrSeq = (JSPUtil.getParameter(request, prefix + "addr_seq", length));
            String[] addrTpCd = (JSPUtil.getParameter(request, prefix + "addr_tp_cd", length));
            String[] cntrCustTpCd = (JSPUtil.getParameter(request, prefix + "cntr_cust_tp_cd", length));
            String[] custDivCd = (JSPUtil.getParameter(request, prefix + "cust_div_cd", length));
            String[] modiCustCd = (JSPUtil.getParameter(request, prefix + "modi_cust_cd", length));
            String[] cnsdCustCnCd = (JSPUtil.getParameter(request, prefix + "cnsd_cust_cnt_cd", length));
            String[] cnsdCustSeq = (JSPUtil.getParameter(request, prefix + "cnsd_cust_seq", length));
            String[] sprsPayLtrFlg = (JSPUtil.getParameter(request, prefix + "sprs_pay_ltr_flg", length));
            String[] payRqstLtrFmtCd = (JSPUtil.getParameter(request, prefix + "pay_rqst_ltr_fmt_cd", length));
            String[] invEdiLvlCd = (JSPUtil.getParameter(request, prefix + "inv_edi_lvl_cd", length));
            String[] dfltInvCurrDivCd = (JSPUtil.getParameter(request, prefix + "dflt_inv_curr_div_cd", length));
            String[] custCntcPntSeq = (JSPUtil.getParameter(request, prefix + "cust_cntc_pnt_seq", length));
            String[] custEml = (JSPUtil.getParameter(request, prefix + "cust_eml", length));
            String[] custUrl = (JSPUtil.getParameter(request, prefix + "cust_url", length));
            String[] intlPhnNo = (JSPUtil.getParameter(request, prefix + "intl_phn_no", length));
            String[] phnNo = (JSPUtil.getParameter(request, prefix + "phn_no", length));
            String[] intlFaxNo = (JSPUtil.getParameter(request, prefix + "intl_fax_no", length));
            String[] faxNo = (JSPUtil.getParameter(request, prefix + "fax_no", length));
            String[] railRoadPrioFlg = (JSPUtil.getParameter(request, prefix + "rail_road_prio_flg", length));
            String[] modiCustCd2 = (JSPUtil.getParameter(request, prefix + "modi_cust_cd2", length));
            String[] ediIfFlg = (JSPUtil.getParameter(request, prefix + "edi_if_flg", length));
            String[] sprtEmlInvFlg = (JSPUtil.getParameter(request, prefix + "sprt_eml_inv_flg", length));
            String[] rgnAcctFlg = (JSPUtil.getParameter(request, prefix + "rgn_acct_flg", length));
            String[] newKeyAcctFlg = (JSPUtil.getParameter(request, prefix + "new_key_acct_flg", length));
            String[] nvoccHjsScacCd = (JSPUtil.getParameter(request, prefix + "nvocc_hjs_scac_cd", length));
            String[] indSteCd = (JSPUtil.getParameter(request, prefix + "ind_ste_cd", length));
            String[] indPanNo = (JSPUtil.getParameter(request, prefix + "ind_pan_no", length));
            String[] indGstRgstNo = (JSPUtil.getParameter(request, prefix + "ind_gst_rgst_no", length));
            String[] indSezUtFlg = (JSPUtil.getParameter(request, prefix + "ind_sez_ut_flg", length));
            String[] steNm = (JSPUtil.getParameter(request, prefix + "ste_nm", length));
            String[] indTerrDivCd = (JSPUtil.getParameter(request, prefix + "ind_terr_div_cd", length));
            String[] fileSavId = (JSPUtil.getParameter(request, prefix + "file_sav_id", length));
            String[] fileNm = (JSPUtil.getParameter(request, prefix + "file_nm", length));
            String[] indComTpCd = (JSPUtil.getParameter(request, prefix + "ind_com_tp_cd", length));
            String[] indCustEml = (JSPUtil.getParameter(request, prefix + "ind_cust_eml", length));
            String[] custCd = (JSPUtil.getParameter(request, prefix + "cust_cd", length));
            String[] steCd = (JSPUtil.getParameter(request, prefix + "ste_cd", length));
            String[] zipCd = (JSPUtil.getParameter(request, prefix + "zip_cd", length));
            String[] otiOrzNo = (JSPUtil.getParameter(request, prefix + "oti_orz_no", length));
            String[] ctyNm = (JSPUtil.getParameter(request, prefix + "cty_nm", length));
            String[] grpIndivDiv = (JSPUtil.getParameter(request, prefix + "grp_indiv_div", length));
            String[] gloAcctFlg = (JSPUtil.getParameter(request, prefix + "glo_acct_flg", length));
            String[] rfAcctFlg = (JSPUtil.getParameter(request, prefix + "rf_acct_flg", length));
            String[] idaSteCd = (JSPUtil.getParameter(request, prefix + "ida_ste_cd", length));
            String[] idaPanNo = (JSPUtil.getParameter(request, prefix + "ida_pan_no", length));
            String[] idaGstRgstNo = (JSPUtil.getParameter(request, prefix + "ida_gst_rgst_no", length));
            String[] idaSpclEcnZnUtFlg = (JSPUtil.getParameter(request, prefix + "ida_spcl_ecn_zn_ut_flg", length));
            String[] idaCoTypeCd = (JSPUtil.getParameter(request, prefix + "ida_co_type_cd", length));
            String[] idaCustEml = (JSPUtil.getParameter(request, prefix + "ida_cust_eml", length));
            String[] idaTerrDivCd = (JSPUtil.getParameter(request, prefix + "ida_terr_div_cd", length));
            String[] rqstNo = (JSPUtil.getParameter(request, prefix + "rqst_no", length));
            String[] custRowId = (JSPUtil.getParameter(request, prefix + "cust_row_id", length));
            String[] addrRowId = (JSPUtil.getParameter(request, prefix + "addr_row_id", length));
            String[] rqstSts = (JSPUtil.getParameter(request, prefix + "rqst_sts", length));
            String[] rqstDt = (JSPUtil.getParameter(request, prefix + "rqst_dt", length));
            String[] appDt = (JSPUtil.getParameter(request, prefix + "app_dt", length));
            String[] mstRqstStsCd = (JSPUtil.getParameter(request, prefix + "mst_rqst_sts_cd", length));
            String[] aproDt = (JSPUtil.getParameter(request, prefix + "apro_dt", length));
            String[] aproUsrId = (JSPUtil.getParameter(request, prefix + "aproUsrId", length));
            String[] rjctRsnRmk = (JSPUtil.getParameter(request, prefix + "rjct_rsn_rmk", length));
            String[] rjctRsnCd = (JSPUtil.getParameter(request, prefix + "rjct_rsn_cd", length));
            String[] cudFlg = (JSPUtil.getParameter(request, prefix + "cud_flg", length));
            String[] custAddrStsCd = (JSPUtil.getParameter(request, prefix + "cust_addr_sts_cd", length));
            String[] prmryChkFlg = (JSPUtil.getParameter(request, prefix + "prmry_chk_flg", length));
            String[] cntCd = (JSPUtil.getParameter(request, prefix + "cnt_cd", length));
            String[] coChnTpCd = (JSPUtil.getParameter(request, prefix + "co_chn_tp_cd", length));
	    	String[] coChnNo = (JSPUtil.getParameter(request, prefix + "co_chn_no", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new CustomerVO();
                if (indivCorpDivCd[i] != null)
                    model.setIndivCorpDivCd(indivCorpDivCd[i]);
                if (modiCustSeq[i] != null)
                    model.setModiCustSeq(modiCustSeq[i]);
                if (fndtDt[i] != null)
                    model.setFndtDt(fndtDt[i]);
                if (cntrDivFlg[i] != null)
                    model.setCntrDivFlg(cntrDivFlg[i]);
                if (keyAcctEndEffDt[i] != null)
                    model.setKeyAcctEndEffDt(keyAcctEndEffDt[i]);
                if (prfCntrTpszCd[i] != null)
                    model.setPrfCntrTpszCd(prfCntrTpszCd[i]);
                if (bzetAddr[i] != null)
                    model.setBzetAddr(bzetAddr[i]);
                if (blkCustTpCd[i] != null)
                    model.setBlkCustTpCd(blkCustTpCd[i]);
                if (srepCd[i] != null)
                    model.setSrepCd(srepCd[i]);
                if (keyAcctStEffDt[i] != null)
                    model.setKeyAcctStEffDt(keyAcctStEffDt[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (nvoccBdAmt[i] != null)
                    model.setNvoccBdAmt(nvoccBdAmt[i]);
                if (rvisCntrCustTpCd[i] != null)
                    model.setRvisCntrCustTpCd(rvisCntrCustTpCd[i]);
                if (bkgAltToDt[i] != null)
                    model.setBkgAltToDt(bkgAltToDt[i]);
                if (locCd[i] != null)
                    model.setLocCd(locCd[i]);
                if (subsCoCd[i] != null)
                    model.setSubsCoCd(subsCoCd[i]);
                if (bfrOfcCngDt[i] != null)
                    model.setBfrOfcCngDt(bfrOfcCngDt[i]);
                if (nmdCustFlg[i] != null)
                    model.setNmdCustFlg(nmdCustFlg[i]);
                if (keyAcctMgrUsrNm[i] != null)
                    model.setKeyAcctMgrUsrNm(keyAcctMgrUsrNm[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (custCntCd[i] != null)
                    model.setCustCntCd(custCntCd[i]);
                if (custGrpId[i] != null)
                    model.setCustGrpId(custGrpId[i]);
                if (nvoccBdStEffDt[i] != null)
                    model.setNvoccBdStEffDt(nvoccBdStEffDt[i]);
                if (bkgAltCreDt[i] != null)
                    model.setBkgAltCreDt(bkgAltCreDt[i]);
                if (invIssCurrTpCd[i] != null)
                    model.setInvIssCurrTpCd(invIssCurrTpCd[i]);
                if (fincStsLvlCd[i] != null)
                    model.setFincStsLvlCd(fincStsLvlCd[i]);
                if (custLglEngNm[i] != null)
                    model.setCustLglEngNm(custLglEngNm[i]);
                if (custRmk[i] != null)
                    model.setCustRmk(custRmk[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (frtFwrdFmcNo[i] != null)
                    model.setFrtFwrdFmcNo(frtFwrdFmcNo[i]);
                if (vndrSeq[i] != null)
                    model.setVndrSeq(vndrSeq[i]);
                if (nvoccBdNo[i] != null)
                    model.setNvoccBdNo(nvoccBdNo[i]);
                if (spclReqDesc[i] != null)
                    model.setSpclReqDesc(spclReqDesc[i]);
                if (nbsClssCd1[i] != null)
                    model.setNbsClssCd1(nbsClssCd1[i]);
                if (capiAmt[i] != null)
                    model.setCapiAmt(capiAmt[i]);
                if (nbsClssCd2[i] != null)
                    model.setNbsClssCd2(nbsClssCd2[i]);
                if (bkgAltFmDt[i] != null)
                    model.setBkgAltFmDt(bkgAltFmDt[i]);
                if (bkgAltRsn[i] != null)
                    model.setBkgAltRsn(bkgAltRsn[i]);
                if (nbsClssCd3[i] != null)
                    model.setNbsClssCd3(nbsClssCd3[i]);
                if (custLoclLangNm[i] != null)
                    model.setCustLoclLangNm(custLoclLangNm[i]);
                if (deltFlg[i] != null)
                    model.setDeltFlg(deltFlg[i]);
                if (custAbbrNm[i] != null)
                    model.setCustAbbrNm(custAbbrNm[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (crmRowId[i] != null)
                    model.setCrmRowId(crmRowId[i]);
                if (eaiIfId[i] != null)
                    model.setEaiIfId(eaiIfId[i]);
                if (prfGrpCmdtCd[i] != null)
                    model.setPrfGrpCmdtCd(prfGrpCmdtCd[i]);
                if (custRgstNo[i] != null)
                    model.setCustRgstNo(custRgstNo[i]);
                if (custStsCd[i] != null)
                    model.setCustStsCd(custStsCd[i]);
                if (lstkFlg[i] != null)
                    model.setLstkFlg(lstkFlg[i]);
                if (nvoccBdEndEffDt[i] != null)
                    model.setNvoccBdEndEffDt(nvoccBdEndEffDt[i]);
                if (nvoccCoScacCd[i] != null)
                    model.setNvoccCoScacCd(nvoccCoScacCd[i]);
                if (rfndPsdoVndrSeq[i] != null)
                    model.setRfndPsdoVndrSeq(rfndPsdoVndrSeq[i]);
                if (fletMgmtOwnrCustSeq[i] != null)
                    model.setFletMgmtOwnrCustSeq(fletMgmtOwnrCustSeq[i]);
                if (keyAcctFlg[i] != null)
                    model.setKeyAcctFlg(keyAcctFlg[i]);
                if (invIssTpCd[i] != null)
                    model.setInvIssTpCd(invIssTpCd[i]);
                if (vbsClssCd[i] != null)
                    model.setVbsClssCd(vbsClssCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (blkDivFlg[i] != null)
                    model.setBlkDivFlg(blkDivFlg[i]);
                if (keyAcctMgrUsrId[i] != null)
                    model.setKeyAcctMgrUsrId(keyAcctMgrUsrId[i]);
                if (bfrOfcCd[i] != null)
                    model.setBfrOfcCd(bfrOfcCd[i]);
                if (cmptDesc[i] != null)
                    model.setCmptDesc(cmptDesc[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (slsDeltEffDt[i] != null)
                    model.setSlsDeltEffDt(slsDeltEffDt[i]);
                if (nvoccLicNo[i] != null)
                    model.setNvoccLicNo(nvoccLicNo[i]);
                if (prfRepCmdtCd[i] != null)
                    model.setPrfRepCmdtCd(prfRepCmdtCd[i]);
                if (capiCurrCd[i] != null)
                    model.setCapiCurrCd(capiCurrCd[i]);
                if (eaiEvntDt[i] != null)
                    model.setEaiEvntDt(eaiEvntDt[i]);
                if (custSeq[i] != null)
                    model.setCustSeq(custSeq[i]);
                if (indusDesc[i] != null)
                    model.setIndusDesc(indusDesc[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (prfSvcDesc[i] != null)
                    model.setPrfSvcDesc(prfSvcDesc[i]);
                if (bkgAltMsg[i] != null)
                    model.setBkgAltMsg(bkgAltMsg[i]);
                if (crntVolKnt[i] != null)
                    model.setCrntVolKnt(crntVolKnt[i]);
                if (ctsNo[i] != null)
                    model.setCtsNo(ctsNo[i]);
                if (modiCustCntCd[i] != null)
                    model.setModiCustCntCd(modiCustCntCd[i]);
                if (empeKnt[i] != null)
                    model.setEmpeKnt(empeKnt[i]);
                if (prfSvcDtlDesc[i] != null)
                    model.setPrfSvcDtlDesc(prfSvcDtlDesc[i]);
                if (mltTrdAcctFlg[i] != null)
                    model.setMltTrdAcctFlg(mltTrdAcctFlg[i]);
                if (bkgAltCreUsrId[i] != null)
                    model.setBkgAltCreUsrId(bkgAltCreUsrId[i]);
                if (addrTpCd[i] != null)
                    model.setAddrTpCd(addrTpCd[i]);
                if (addrSeq[i] != null)
                    model.setAddrSeq(addrSeq[i]);
                if (cntrCustTpCd[i] != null)
                    model.setCntrCustTpCd(cntrCustTpCd[i]);
                if (custDivCd[i] != null)
                    model.setCustDivCd(custDivCd[i]);
                if (modiCustCd[i] != null)
                    model.setModiCustCd(modiCustCd[i]);
                if (cnsdCustCnCd[i] != null)
                    model.setCnsdCustCntCd(cnsdCustCnCd[i]);
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
                if (railRoadPrioFlg[i] != null)
                    model.setRailRoadPrioFlg(railRoadPrioFlg[i]);
                if (modiCustCd2[i] != null)
                    model.setModiCustCd2(modiCustCd2[i]);
                if (ediIfFlg[i] != null)
                    model.setEdiIfFlg(ediIfFlg[i]);
                if (sprtEmlInvFlg[i] != null)
                    model.setSprtEmlInvFlg(sprtEmlInvFlg[i]);
                if (rvisCntrCustTpCd[i] != null)
                    model.setRvisCntrCustTpCd(rvisCntrCustTpCd[i]);
                if (rgnAcctFlg[i] != null)
                    model.setRgnAcctFlg(rgnAcctFlg[i]);
                if (newKeyAcctFlg[i] != null)
                    model.setNewKeyAcctFlg(newKeyAcctFlg[i]);
                if (nvoccHjsScacCd[i] != null)
                    model.setNvoccHjsScacCd(nvoccHjsScacCd[i]);
                if (indSteCd[i] != null)
                    model.setIndSteCd(indSteCd[i]);
                if (indPanNo[i] != null)
                    model.setIndPanNo(indPanNo[i]);
                if (indGstRgstNo[i] != null)
                    model.setIndGstRgstNo(indGstRgstNo[i]);
                if (indSezUtFlg[i] != null)
                    model.setIndSezUtFlg(indSezUtFlg[i]);
                if (steNm[i] != null)
                    model.setSteNm(steNm[i]);
                if (indTerrDivCd[i] != null)
                    model.setIndTerrDivCd(indTerrDivCd[i]);
                if (fileSavId[i] != null)
                    model.setFileSavId(fileSavId[i]);
                if (fileNm[i] != null)
                    model.setFileNm(fileNm[i]);
                if (indComTpCd[i] != null)
                    model.setIndComTpCd(indComTpCd[i]);
                if (indCustEml[i] != null)
                    model.setIndCustEml(indCustEml[i]);
                if (custCd[i] != null)
                    model.setCustCd(custCd[i]);
                if (steCd[i] != null)
                    model.setSteCd(steCd[i]);
                if (zipCd[i] != null)
                    model.setZipCd(zipCd[i]);
                if (otiOrzNo[i] != null)
                    model.setOtiOrzNo(otiOrzNo[i]);
                if (ctyNm[i] != null)
                    model.setCtyNm(ctyNm[i]);
                if (grpIndivDiv[i] != null)
                    model.setGrpIndivDiv(grpIndivDiv[i]);
                if (gloAcctFlg[i] != null)
                    model.setGloAcctFlg(gloAcctFlg[i]);
                if (rfAcctFlg[i] != null)
                    model.setRfAcctFlg(rfAcctFlg[i]);
                if (idaSteCd[i] != null)
                    model.setIdaSteCd(idaSteCd[i]);
                if (idaPanNo[i] != null)
                    model.setIdaPanNo(idaPanNo[i]);
                if (idaGstRgstNo[i] != null)
                    model.setIdaGstRgstNo(idaGstRgstNo[i]);
                if (idaSpclEcnZnUtFlg[i] != null)
                    model.setIdaSpclEcnZnUtFlg(idaSpclEcnZnUtFlg[i]);
                if (idaCoTypeCd[i] != null)
                    model.setIdaCoTypeCd(idaCoTypeCd[i]);
                if (idaCustEml[i] != null)
                    model.setIdaCustEml(idaCustEml[i]);
                if (idaTerrDivCd[i] != null)
                    model.setIdaTerrDivCd(idaTerrDivCd[i]);
                if (rqstNo[i] != null)
                    model.setRqstNo(rqstNo[i]);
                if (custRowId[i] != null)
                    model.setCustRowId(custRowId[i]);
                if (addrRowId[i] != null)
                    model.setAddrRowId(addrRowId[i]);
                if (rqstSts[i] != null)
                    model.setRqstSts(rqstSts[i]);
                if (rqstDt[i] != null)
                    model.setRqstDt(rqstDt[i]);
                if (appDt[i] != null)
                    model.setAppDt(appDt[i]);
                if (mstRqstStsCd[i] != null)
                    model.setMstRqstStsCd(mstRqstStsCd[i]);
                if (aproDt[i] != null)
                    model.setAproDt(aproDt[i]);
                if (aproUsrId[i] != null)
                    model.setAproUsrId(aproUsrId[i]);
                if (rjctRsnRmk[i] != null)
                    model.setRjctRsnRmk(rjctRsnRmk[i]);
                if (rjctRsnCd[i] != null)
                    model.setRjctRsnCd(rjctRsnCd[i]);
                if (cudFlg[i] != null)
                    model.setCudFlg(cudFlg[i]);
                if (custAddrStsCd[i] != null)
                    model.setCustAddrStsCd(custAddrStsCd[i]);
                if (prmryChkFlg[i] != null)
                    model.setPrmryChkFlg(prmryChkFlg[i]);
                if (cntCd[i] != null)
                    model.setCntCd(cntCd[i]);
                if (coChnTpCd[i] != null) 
		    		model.setCoChnTpCd(coChnTpCd[i]);
				if (coChnNo[i] != null) 
		    		model.setCoChnNo(coChnNo[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCustomerVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return CustomerVO[]
	 */
    public CustomerVO[] getCustomerVOs() {
        CustomerVO[] vos = (CustomerVO[]) models.toArray(new CustomerVO[models.size()]);
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
        this.indivCorpDivCd = this.indivCorpDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.modiCustSeq = this.modiCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fndtDt = this.fndtDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrDivFlg = this.cntrDivFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.keyAcctEndEffDt = this.keyAcctEndEffDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prfCntrTpszCd = this.prfCntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bzetAddr = this.bzetAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blkCustTpCd = this.blkCustTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.srepCd = this.srepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.keyAcctStEffDt = this.keyAcctStEffDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nvoccBdAmt = this.nvoccBdAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rvisCntrCustTpCd = this.rvisCntrCustTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgAltToDt = this.bkgAltToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locCd = this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.subsCoCd = this.subsCoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bfrOfcCngDt = this.bfrOfcCngDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nmdCustFlg = this.nmdCustFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.keyAcctMgrUsrNm = this.keyAcctMgrUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custGrpId = this.custGrpId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nvoccBdStEffDt = this.nvoccBdStEffDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgAltCreDt = this.bkgAltCreDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invIssCurrTpCd = this.invIssCurrTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fincStsLvlCd = this.fincStsLvlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custLglEngNm = this.custLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custRmk = this.custRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frtFwrdFmcNo = this.frtFwrdFmcNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nvoccBdNo = this.nvoccBdNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclReqDesc = this.spclReqDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nbsClssCd1 = this.nbsClssCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.capiAmt = this.capiAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nbsClssCd2 = this.nbsClssCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgAltFmDt = this.bkgAltFmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgAltRsn = this.bkgAltRsn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nbsClssCd3 = this.nbsClssCd3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custLoclLangNm = this.custLoclLangNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custAbbrNm = this.custAbbrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crmRowId = this.crmRowId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eaiIfId = this.eaiIfId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prfGrpCmdtCd = this.prfGrpCmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custRgstNo = this.custRgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custStsCd = this.custStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lstkFlg = this.lstkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nvoccBdEndEffDt = this.nvoccBdEndEffDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nvoccCoScacCd = this.nvoccCoScacCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfndPsdoVndrSeq = this.rfndPsdoVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fletMgmtOwnrCustSeq = this.fletMgmtOwnrCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.keyAcctFlg = this.keyAcctFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invIssTpCd = this.invIssTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vbsClssCd = this.vbsClssCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blkDivFlg = this.blkDivFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.keyAcctMgrUsrId = this.keyAcctMgrUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bfrOfcCd = this.bfrOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmptDesc = this.cmptDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slsDeltEffDt = this.slsDeltEffDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nvoccLicNo = this.nvoccLicNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prfRepCmdtCd = this.prfRepCmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.capiCurrCd = this.capiCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eaiEvntDt = this.eaiEvntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.indusDesc = this.indusDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prfSvcDesc = this.prfSvcDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgAltMsg = this.bkgAltMsg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crntVolKnt = this.crntVolKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctsNo = this.ctsNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.modiCustCntCd = this.modiCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.empeKnt = this.empeKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prfSvcDtlDesc = this.prfSvcDtlDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mltTrdAcctFlg = this.mltTrdAcctFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgAltCreUsrId = this.bkgAltCreUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.addrSeq = this.addrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.addrTpCd = this.addrTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrCustTpCd = this.cntrCustTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custDivCd = this.custDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.modiCustCd = this.modiCustCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cnsdCustCnCd = this.cnsdCustCnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cnsdCustSeq = this.cnsdCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sprsPayLtrFlg = this.sprsPayLtrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.payRqstLtrFmtCd = this.payRqstLtrFmtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invEdiLvlCd = this.invEdiLvlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dfltInvCurrDivCd = this.dfltInvCurrDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntcPntSeq = this.custCntcPntSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custEml = this.custEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custUrl = this.custUrl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intlPhnNo = this.intlPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.phnNo = this.phnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intlFaxNo = this.intlFaxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.faxNo = this.faxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.railRoadPrioFlg = this.railRoadPrioFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.modiCustCd2 = this.modiCustCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediIfFlg = this.ediIfFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sprtEmlInvFlg = this.sprtEmlInvFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rgnAcctFlg = this.rgnAcctFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.newKeyAcctFlg = this.newKeyAcctFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nvoccHjsScacCd = this.nvoccHjsScacCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.indSteCd = this.indSteCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.indPanNo = this.indPanNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.indGstRgstNo = this.indGstRgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.indSezUtFlg = this.indSezUtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.steNm = this.steNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.indTerrDivCd = this.indTerrDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fileSavId = this.fileSavId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fileNm = this.fileNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.indComTpCd = this.indComTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.indCustEml = this.indCustEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCd = this.custCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.steCd = this.steCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.zipCd = this.zipCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.otiOrzNo = this.otiOrzNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctyNm = this.ctyNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.grpIndivDiv = this.grpIndivDiv.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.gloAcctFlg = this.gloAcctFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfAcctFlg = this.rfAcctFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaSteCd = this.idaSteCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaPanNo = this.idaPanNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaGstRgstNo = this.idaGstRgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaSpclEcnZnUtFlg = this.idaSpclEcnZnUtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaCoTypeCd = this.idaCoTypeCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaCustEml = this.idaCustEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaTerrDivCd = this.idaTerrDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstNo = this.rqstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custRowId = this.custRowId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.addrRowId = this.addrRowId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstSts = this.rqstSts.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstDt = this.rqstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.appDt = this.appDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mstRqstStsCd = this.mstRqstStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aproDt = this.aproDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aproUsrId = this.aproUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rjctRsnRmk = this.rjctRsnRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rjctRsnCd = this.rjctRsnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cudFlg = this.cudFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custAddrStsCd = this.custAddrStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prmryChkFlg = this.prmryChkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntCd = this.cntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.coChnTpCd = this.coChnTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.coChnNo = this.coChnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}