/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CustomerReportVO.java
*@FileTitle : CustomerReportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.06  
* 1.0 Creation
=========================================================*/
 
package com.hanjin.apps.alps.bcm.ccd.commoncode.report.vo;

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

public class CustomerReportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomerReportVO> models = new ArrayList<CustomerReportVO>();
	
	/* Column Info */
	private String indivCorpDivCd = null;
	/* Column Info */
	private String custDivCd = null;
	/* Column Info */
	private String cntrDivFlg = null;
	/* Column Info */
	private String fndtDt = null;
	/* Column Info */
	private String keyAcctEndEffDt = null;
	/* Column Info */
	private String prfCntrTpszCd = null;
	/* Column Info */
	private String modiCustCd = null;
	/* Column Info */
	private String bzetAddr = null;
	/* Column Info */
	private String srepCd = null;
	/* Column Info */
	private String keyAcctStEffDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String nvoccBdAmt = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String cnsdCustSeq = null;
	/* Column Info */
	private String nmdCustFlg = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String custGrpId = null;
	/* Column Info */
	private String nvoccBdStEffDt = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String cntrCustTpCd = null;
	/* Column Info */
	private String fincStsLvlCd = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String custRmk = null;
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
	private String nbsClssCd2 = null;
	/* Column Info */
	private String capiAmt = null;
	/* Column Info */
	private String nbsClssCd3 = null;
	/* Column Info */
	private String custLoclLangNm = null;
	/* Column Info */
	private String sprsPayLtrFlg = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String custAbbrNm = null;
	/* Column Info */
	private String prfGrpCmdtCd = null;
	/* Column Info */
	private String custRgstNo = null;
	/* Column Info */
	private String lstkFlg = null;
	/* Column Info */
	private String dfltInvCurrDivCd = null;
	/* Column Info */
	private String nvoccBdEndEffDt = null;
	/* Column Info */
	private String nvoccCoScacCd = null;
	/* Column Info */
	private String keyAcctFlg = null;
	/* Column Info */
	private String vbsClssCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String payRqstLtrFmtCd = null;
	/* Column Info */
	private String cmptDesc = null;
	/* Column Info */
	private String slsDeltEffDt = null;
	/* Column Info */
	private String nvoccLicNo = null;
	/* Column Info */
	private String prfRepCmdtCd = null;
	/* Column Info */
	private String invEdiLvlCd = null;
	/* Column Info */
	private String capiCurrCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String indusDesc = null;
	/* Column Info */
	private String prfSvcDesc = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String crntVolKnt = null;
	/* Column Info */
	private String ctsNo = null;
	/* Column Info */
	private String cnsdCustCntCd = null;
	/* Column Info */
	private String prfSvcDtlDesc = null;
	/* Column Info */
	private String empeKnt = null;
	/* Column Info */
	private String mltTrdAcctFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String modiCustCd2 = null;
	/* Column Info */
	private String railRoadPrioFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CustomerReportVO() {}

	public CustomerReportVO(String ibflag, String pagerows, String custCntCd, String custSeq, String custLglEngNm, String custLoclLangNm, String bzetAddr, String custAbbrNm, String custRgstNo, String locCd, String ofcCd, String srepCd, String indivCorpDivCd, String cntrDivFlg, String cntrCustTpCd, String nbsClssCd1, String nbsClssCd2, String nbsClssCd3, String vbsClssCd, String vndrSeq, String custGrpId, String mltTrdAcctFlg, String nmdCustFlg, String keyAcctFlg, String keyAcctStEffDt, String keyAcctEndEffDt, String fndtDt, String fincStsLvlCd, String empeKnt, String indusDesc, String crntVolKnt, String lstkFlg, String ctsNo, String capiCurrCd, String capiAmt, String custRmk, String nvoccCoScacCd, String nvoccLicNo, String nvoccBdNo, String nvoccBdAmt, String nvoccBdStEffDt, String nvoccBdEndEffDt, String frtFwrdFmcNo, String deltFlg, String cnsdCustCntCd, String cnsdCustSeq, String custDivCd, String dfltInvCurrDivCd, String invEdiLvlCd, String modiCustCd, String payRqstLtrFmtCd, String slsDeltEffDt, String sprsPayLtrFlg, String status, String prfCntrTpszCd, String spclReqDesc, String prfGrpCmdtCd, String cmptDesc, String prfRepCmdtCd, String prfSvcDesc, String prfSvcDtlDesc, String creUsrId, String creDt, String updUsrId, String updDt, String modiCustCd2, String railRoadPrioFlg) {
		this.indivCorpDivCd = indivCorpDivCd;
		this.custDivCd = custDivCd;
		this.cntrDivFlg = cntrDivFlg;
		this.fndtDt = fndtDt;
		this.keyAcctEndEffDt = keyAcctEndEffDt;
		this.prfCntrTpszCd = prfCntrTpszCd;
		this.modiCustCd = modiCustCd;
		this.bzetAddr = bzetAddr;
		this.srepCd = srepCd;
		this.keyAcctStEffDt = keyAcctStEffDt;
		this.pagerows = pagerows;
		this.nvoccBdAmt = nvoccBdAmt;
		this.locCd = locCd;
		this.cnsdCustSeq = cnsdCustSeq;
		this.nmdCustFlg = nmdCustFlg;
		this.custCntCd = custCntCd;
		this.custGrpId = custGrpId;
		this.nvoccBdStEffDt = nvoccBdStEffDt;
		this.status = status;
		this.cntrCustTpCd = cntrCustTpCd;
		this.fincStsLvlCd = fincStsLvlCd;
		this.custLglEngNm = custLglEngNm;
		this.custRmk = custRmk;
		this.frtFwrdFmcNo = frtFwrdFmcNo;
		this.vndrSeq = vndrSeq;
		this.nvoccBdNo = nvoccBdNo;
		this.spclReqDesc = spclReqDesc;
		this.nbsClssCd1 = nbsClssCd1;
		this.nbsClssCd2 = nbsClssCd2;
		this.capiAmt = capiAmt;
		this.nbsClssCd3 = nbsClssCd3;
		this.custLoclLangNm = custLoclLangNm;
		this.sprsPayLtrFlg = sprsPayLtrFlg;
		this.deltFlg = deltFlg;
		this.custAbbrNm = custAbbrNm;
		this.prfGrpCmdtCd = prfGrpCmdtCd;
		this.custRgstNo = custRgstNo;
		this.lstkFlg = lstkFlg;
		this.dfltInvCurrDivCd = dfltInvCurrDivCd;
		this.nvoccBdEndEffDt = nvoccBdEndEffDt;
		this.nvoccCoScacCd = nvoccCoScacCd;
		this.keyAcctFlg = keyAcctFlg;
		this.vbsClssCd = vbsClssCd;
		this.ibflag = ibflag;
		this.payRqstLtrFmtCd = payRqstLtrFmtCd;
		this.cmptDesc = cmptDesc;
		this.slsDeltEffDt = slsDeltEffDt;
		this.nvoccLicNo = nvoccLicNo;
		this.prfRepCmdtCd = prfRepCmdtCd;
		this.invEdiLvlCd = invEdiLvlCd;
		this.capiCurrCd = capiCurrCd;
		this.custSeq = custSeq;
		this.indusDesc = indusDesc;
		this.prfSvcDesc = prfSvcDesc;
		this.ofcCd = ofcCd;
		this.crntVolKnt = crntVolKnt;
		this.ctsNo = ctsNo;
		this.cnsdCustCntCd = cnsdCustCntCd;
		this.prfSvcDtlDesc = prfSvcDtlDesc;
		this.empeKnt = empeKnt;
		this.mltTrdAcctFlg = mltTrdAcctFlg;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.modiCustCd2 = modiCustCd2;
		this.railRoadPrioFlg = railRoadPrioFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("indiv_corp_div_cd", getIndivCorpDivCd());
		this.hashColumns.put("cust_div_cd", getCustDivCd());
		this.hashColumns.put("cntr_div_flg", getCntrDivFlg());
		this.hashColumns.put("fndt_dt", getFndtDt());
		this.hashColumns.put("key_acct_end_eff_dt", getKeyAcctEndEffDt());
		this.hashColumns.put("prf_cntr_tpsz_cd", getPrfCntrTpszCd());
		this.hashColumns.put("modi_cust_cd", getModiCustCd());
		this.hashColumns.put("bzet_addr", getBzetAddr());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("key_acct_st_eff_dt", getKeyAcctStEffDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("nvocc_bd_amt", getNvoccBdAmt());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("cnsd_cust_seq", getCnsdCustSeq());
		this.hashColumns.put("nmd_cust_flg", getNmdCustFlg());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_grp_id", getCustGrpId());
		this.hashColumns.put("nvocc_bd_st_eff_dt", getNvoccBdStEffDt());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("cntr_cust_tp_cd", getCntrCustTpCd());
		this.hashColumns.put("finc_sts_lvl_cd", getFincStsLvlCd());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("cust_rmk", getCustRmk());
		this.hashColumns.put("frt_fwrd_fmc_no", getFrtFwrdFmcNo());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("nvocc_bd_no", getNvoccBdNo());
		this.hashColumns.put("spcl_req_desc", getSpclReqDesc());
		this.hashColumns.put("nbs_clss_cd1", getNbsClssCd1());
		this.hashColumns.put("nbs_clss_cd2", getNbsClssCd2());
		this.hashColumns.put("capi_amt", getCapiAmt());
		this.hashColumns.put("nbs_clss_cd3", getNbsClssCd3());
		this.hashColumns.put("cust_locl_lang_nm", getCustLoclLangNm());
		this.hashColumns.put("sprs_pay_ltr_flg", getSprsPayLtrFlg());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cust_abbr_nm", getCustAbbrNm());
		this.hashColumns.put("prf_grp_cmdt_cd", getPrfGrpCmdtCd());
		this.hashColumns.put("cust_rgst_no", getCustRgstNo());
		this.hashColumns.put("lstk_flg", getLstkFlg());
		this.hashColumns.put("dflt_inv_curr_div_cd", getDfltInvCurrDivCd());
		this.hashColumns.put("nvocc_bd_end_eff_dt", getNvoccBdEndEffDt());
		this.hashColumns.put("nvocc_co_scac_cd", getNvoccCoScacCd());
		this.hashColumns.put("key_acct_flg", getKeyAcctFlg());
		this.hashColumns.put("vbs_clss_cd", getVbsClssCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pay_rqst_ltr_fmt_cd", getPayRqstLtrFmtCd());
		this.hashColumns.put("cmpt_desc", getCmptDesc());
		this.hashColumns.put("sls_delt_eff_dt", getSlsDeltEffDt());
		this.hashColumns.put("nvocc_lic_no", getNvoccLicNo());
		this.hashColumns.put("prf_rep_cmdt_cd", getPrfRepCmdtCd());
		this.hashColumns.put("inv_edi_lvl_cd", getInvEdiLvlCd());
		this.hashColumns.put("capi_curr_cd", getCapiCurrCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("indus_desc", getIndusDesc());
		this.hashColumns.put("prf_svc_desc", getPrfSvcDesc());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("crnt_vol_knt", getCrntVolKnt());
		this.hashColumns.put("cts_no", getCtsNo());
		this.hashColumns.put("cnsd_cust_cnt_cd", getCnsdCustCntCd());
		this.hashColumns.put("prf_svc_dtl_desc", getPrfSvcDtlDesc());
		this.hashColumns.put("empe_knt", getEmpeKnt());
		this.hashColumns.put("mlt_trd_acct_flg", getMltTrdAcctFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("modi_cust_cd2", getModiCustCd2());
		this.hashColumns.put("rail_road_prio_flg", getRailRoadPrioFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("indiv_corp_div_cd", "indivCorpDivCd");
		this.hashFields.put("cust_div_cd", "custDivCd");
		this.hashFields.put("cntr_div_flg", "cntrDivFlg");
		this.hashFields.put("fndt_dt", "fndtDt");
		this.hashFields.put("key_acct_end_eff_dt", "keyAcctEndEffDt");
		this.hashFields.put("prf_cntr_tpsz_cd", "prfCntrTpszCd");
		this.hashFields.put("modi_cust_cd", "modiCustCd");
		this.hashFields.put("bzet_addr", "bzetAddr");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("key_acct_st_eff_dt", "keyAcctStEffDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("nvocc_bd_amt", "nvoccBdAmt");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("cnsd_cust_seq", "cnsdCustSeq");
		this.hashFields.put("nmd_cust_flg", "nmdCustFlg");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_grp_id", "custGrpId");
		this.hashFields.put("nvocc_bd_st_eff_dt", "nvoccBdStEffDt");
		this.hashFields.put("status", "status");
		this.hashFields.put("cntr_cust_tp_cd", "cntrCustTpCd");
		this.hashFields.put("finc_sts_lvl_cd", "fincStsLvlCd");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("cust_rmk", "custRmk");
		this.hashFields.put("frt_fwrd_fmc_no", "frtFwrdFmcNo");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("nvocc_bd_no", "nvoccBdNo");
		this.hashFields.put("spcl_req_desc", "spclReqDesc");
		this.hashFields.put("nbs_clss_cd1", "nbsClssCd1");
		this.hashFields.put("nbs_clss_cd2", "nbsClssCd2");
		this.hashFields.put("capi_amt", "capiAmt");
		this.hashFields.put("nbs_clss_cd3", "nbsClssCd3");
		this.hashFields.put("cust_locl_lang_nm", "custLoclLangNm");
		this.hashFields.put("sprs_pay_ltr_flg", "sprsPayLtrFlg");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cust_abbr_nm", "custAbbrNm");
		this.hashFields.put("prf_grp_cmdt_cd", "prfGrpCmdtCd");
		this.hashFields.put("cust_rgst_no", "custRgstNo");
		this.hashFields.put("lstk_flg", "lstkFlg");
		this.hashFields.put("dflt_inv_curr_div_cd", "dfltInvCurrDivCd");
		this.hashFields.put("nvocc_bd_end_eff_dt", "nvoccBdEndEffDt");
		this.hashFields.put("nvocc_co_scac_cd", "nvoccCoScacCd");
		this.hashFields.put("key_acct_flg", "keyAcctFlg");
		this.hashFields.put("vbs_clss_cd", "vbsClssCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pay_rqst_ltr_fmt_cd", "payRqstLtrFmtCd");
		this.hashFields.put("cmpt_desc", "cmptDesc");
		this.hashFields.put("sls_delt_eff_dt", "slsDeltEffDt");
		this.hashFields.put("nvocc_lic_no", "nvoccLicNo");
		this.hashFields.put("prf_rep_cmdt_cd", "prfRepCmdtCd");
		this.hashFields.put("inv_edi_lvl_cd", "invEdiLvlCd");
		this.hashFields.put("capi_curr_cd", "capiCurrCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("indus_desc", "indusDesc");
		this.hashFields.put("prf_svc_desc", "prfSvcDesc");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("crnt_vol_knt", "crntVolKnt");
		this.hashFields.put("cts_no", "ctsNo");
		this.hashFields.put("cnsd_cust_cnt_cd", "cnsdCustCntCd");
		this.hashFields.put("prf_svc_dtl_desc", "prfSvcDtlDesc");
		this.hashFields.put("empe_knt", "empeKnt");
		this.hashFields.put("mlt_trd_acct_flg", "mltTrdAcctFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("modi_cust_cd2", "modiCustCd2");
		this.hashFields.put("rail_road_prio_flg", "railRoadPrioFlg");
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
	 * @return custDivCd
	 */
	public String getCustDivCd() {
		return this.custDivCd;
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
	 * @return fndtDt
	 */
	public String getFndtDt() {
		return this.fndtDt;
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
	 * @return modiCustCd
	 */
	public String getModiCustCd() {
		return this.modiCustCd;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return nmdCustFlg
	 */
	public String getNmdCustFlg() {
		return this.nmdCustFlg;
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
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return cntrCustTpCd
	 */
	public String getCntrCustTpCd() {
		return this.cntrCustTpCd;
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
	 * @return nbsClssCd2
	 */
	public String getNbsClssCd2() {
		return this.nbsClssCd2;
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
	 * @return sprsPayLtrFlg
	 */
	public String getSprsPayLtrFlg() {
		return this.sprsPayLtrFlg;
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
	 * @return lstkFlg
	 */
	public String getLstkFlg() {
		return this.lstkFlg;
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
	 * @return keyAcctFlg
	 */
	public String getKeyAcctFlg() {
		return this.keyAcctFlg;
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
	 * @return payRqstLtrFmtCd
	 */
	public String getPayRqstLtrFmtCd() {
		return this.payRqstLtrFmtCd;
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
	 * @return invEdiLvlCd
	 */
	public String getInvEdiLvlCd() {
		return this.invEdiLvlCd;
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
	 * @return prfSvcDesc
	 */
	public String getPrfSvcDesc() {
		return this.prfSvcDesc;
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
	 * @return cnsdCustCntCd
	 */
	public String getCnsdCustCntCd() {
		return this.cnsdCustCntCd;
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
	 * @return empeKnt
	 */
	public String getEmpeKnt() {
		return this.empeKnt;
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
	 * @param indivCorpDivCd
	 */
	public void setIndivCorpDivCd(String indivCorpDivCd) {
		this.indivCorpDivCd = indivCorpDivCd;
	}
	
	/**
	 * Column Info
	 * @param custDivCd
	 */
	public void setCustDivCd(String custDivCd) {
		this.custDivCd = custDivCd;
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
	 * @param fndtDt
	 */
	public void setFndtDt(String fndtDt) {
		this.fndtDt = fndtDt;
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
	 * @param modiCustCd
	 */
	public void setModiCustCd(String modiCustCd) {
		this.modiCustCd = modiCustCd;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param nmdCustFlg
	 */
	public void setNmdCustFlg(String nmdCustFlg) {
		this.nmdCustFlg = nmdCustFlg;
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
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param cntrCustTpCd
	 */
	public void setCntrCustTpCd(String cntrCustTpCd) {
		this.cntrCustTpCd = cntrCustTpCd;
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
	 * @param nbsClssCd2
	 */
	public void setNbsClssCd2(String nbsClssCd2) {
		this.nbsClssCd2 = nbsClssCd2;
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
	 * @param sprsPayLtrFlg
	 */
	public void setSprsPayLtrFlg(String sprsPayLtrFlg) {
		this.sprsPayLtrFlg = sprsPayLtrFlg;
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
	 * @param lstkFlg
	 */
	public void setLstkFlg(String lstkFlg) {
		this.lstkFlg = lstkFlg;
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
	 * @param keyAcctFlg
	 */
	public void setKeyAcctFlg(String keyAcctFlg) {
		this.keyAcctFlg = keyAcctFlg;
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
	 * @param payRqstLtrFmtCd
	 */
	public void setPayRqstLtrFmtCd(String payRqstLtrFmtCd) {
		this.payRqstLtrFmtCd = payRqstLtrFmtCd;
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
	 * @param invEdiLvlCd
	 */
	public void setInvEdiLvlCd(String invEdiLvlCd) {
		this.invEdiLvlCd = invEdiLvlCd;
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
	 * @param prfSvcDesc
	 */
	public void setPrfSvcDesc(String prfSvcDesc) {
		this.prfSvcDesc = prfSvcDesc;
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
	 * @param cnsdCustCntCd
	 */
	public void setCnsdCustCntCd(String cnsdCustCntCd) {
		this.cnsdCustCntCd = cnsdCustCntCd;
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
	 * @param empeKnt
	 */
	public void setEmpeKnt(String empeKnt) {
		this.empeKnt = empeKnt;
	}
	
	/**
	 * Column Info
	 * @param mltTrdAcctFlg
	 */
	public void setMltTrdAcctFlg(String mltTrdAcctFlg) {
		this.mltTrdAcctFlg = mltTrdAcctFlg;
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
	
	public String getModiCustCd2() {
		return modiCustCd2;
	}

	public void setModiCustCd2(String modiCustCd2) {
		this.modiCustCd2 = modiCustCd2;
	}

	public String getRailRoadPrioFlg() {
		return railRoadPrioFlg;
	}

	public void setRailRoadPrioFlg(String railRoadPrioFlg) {
		this.railRoadPrioFlg = railRoadPrioFlg;
	}

/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setIndivCorpDivCd(JSPUtil.getParameter(request, prefix + "indiv_corp_div_cd", ""));
		setCustDivCd(JSPUtil.getParameter(request, prefix + "cust_div_cd", ""));
		setCntrDivFlg(JSPUtil.getParameter(request, prefix + "cntr_div_flg", ""));
		setFndtDt(JSPUtil.getParameter(request, prefix + "fndt_dt", ""));
		setKeyAcctEndEffDt(JSPUtil.getParameter(request, prefix + "key_acct_end_eff_dt", ""));
		setPrfCntrTpszCd(JSPUtil.getParameter(request, prefix + "prf_cntr_tpsz_cd", ""));
		setModiCustCd(JSPUtil.getParameter(request, prefix + "modi_cust_cd", ""));
		setBzetAddr(JSPUtil.getParameter(request, prefix + "bzet_addr", ""));
		setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
		setKeyAcctStEffDt(JSPUtil.getParameter(request, prefix + "key_acct_st_eff_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setNvoccBdAmt(JSPUtil.getParameter(request, prefix + "nvocc_bd_amt", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setCnsdCustSeq(JSPUtil.getParameter(request, prefix + "cnsd_cust_seq", ""));
		setNmdCustFlg(JSPUtil.getParameter(request, prefix + "nmd_cust_flg", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setCustGrpId(JSPUtil.getParameter(request, prefix + "cust_grp_id", ""));
		setNvoccBdStEffDt(JSPUtil.getParameter(request, prefix + "nvocc_bd_st_eff_dt", ""));
		setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
		setCntrCustTpCd(JSPUtil.getParameter(request, prefix + "cntr_cust_tp_cd", ""));
		setFincStsLvlCd(JSPUtil.getParameter(request, prefix + "finc_sts_lvl_cd", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setCustRmk(JSPUtil.getParameter(request, prefix + "cust_rmk", ""));
		setFrtFwrdFmcNo(JSPUtil.getParameter(request, prefix + "frt_fwrd_fmc_no", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setNvoccBdNo(JSPUtil.getParameter(request, prefix + "nvocc_bd_no", ""));
		setSpclReqDesc(JSPUtil.getParameter(request, prefix + "spcl_req_desc", ""));
		setNbsClssCd1(JSPUtil.getParameter(request, prefix + "nbs_clss_cd1", ""));
		setNbsClssCd2(JSPUtil.getParameter(request, prefix + "nbs_clss_cd2", ""));
		setCapiAmt(JSPUtil.getParameter(request, prefix + "capi_amt", ""));
		setNbsClssCd3(JSPUtil.getParameter(request, prefix + "nbs_clss_cd3", ""));
		setCustLoclLangNm(JSPUtil.getParameter(request, prefix + "cust_locl_lang_nm", ""));
		setSprsPayLtrFlg(JSPUtil.getParameter(request, prefix + "sprs_pay_ltr_flg", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCustAbbrNm(JSPUtil.getParameter(request, prefix + "cust_abbr_nm", ""));
		setPrfGrpCmdtCd(JSPUtil.getParameter(request, prefix + "prf_grp_cmdt_cd", ""));
		setCustRgstNo(JSPUtil.getParameter(request, prefix + "cust_rgst_no", ""));
		setLstkFlg(JSPUtil.getParameter(request, prefix + "lstk_flg", ""));
		setDfltInvCurrDivCd(JSPUtil.getParameter(request, prefix + "dflt_inv_curr_div_cd", ""));
		setNvoccBdEndEffDt(JSPUtil.getParameter(request, prefix + "nvocc_bd_end_eff_dt", ""));
		setNvoccCoScacCd(JSPUtil.getParameter(request, prefix + "nvocc_co_scac_cd", ""));
		setKeyAcctFlg(JSPUtil.getParameter(request, prefix + "key_acct_flg", ""));
		setVbsClssCd(JSPUtil.getParameter(request, prefix + "vbs_clss_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPayRqstLtrFmtCd(JSPUtil.getParameter(request, prefix + "pay_rqst_ltr_fmt_cd", ""));
		setCmptDesc(JSPUtil.getParameter(request, prefix + "cmpt_desc", ""));
		setSlsDeltEffDt(JSPUtil.getParameter(request, prefix + "sls_delt_eff_dt", ""));
		setNvoccLicNo(JSPUtil.getParameter(request, prefix + "nvocc_lic_no", ""));
		setPrfRepCmdtCd(JSPUtil.getParameter(request, prefix + "prf_rep_cmdt_cd", ""));
		setInvEdiLvlCd(JSPUtil.getParameter(request, prefix + "inv_edi_lvl_cd", ""));
		setCapiCurrCd(JSPUtil.getParameter(request, prefix + "capi_curr_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setIndusDesc(JSPUtil.getParameter(request, prefix + "indus_desc", ""));
		setPrfSvcDesc(JSPUtil.getParameter(request, prefix + "prf_svc_desc", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setCrntVolKnt(JSPUtil.getParameter(request, prefix + "crnt_vol_knt", ""));
		setCtsNo(JSPUtil.getParameter(request, prefix + "cts_no", ""));
		setCnsdCustCntCd(JSPUtil.getParameter(request, prefix + "cnsd_cust_cnt_cd", ""));
		setPrfSvcDtlDesc(JSPUtil.getParameter(request, prefix + "prf_svc_dtl_desc", ""));
		setEmpeKnt(JSPUtil.getParameter(request, prefix + "empe_knt", ""));
		setMltTrdAcctFlg(JSPUtil.getParameter(request, prefix + "mlt_trd_acct_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setModiCustCd2(JSPUtil.getParameter(request, prefix + "modi_cust_cd2", ""));
		setRailRoadPrioFlg(JSPUtil.getParameter(request, prefix + "rail_road_prio_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomerReportVO[]
	 */
	public CustomerReportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomerReportVO[]
	 */
	public CustomerReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomerReportVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] indivCorpDivCd = (JSPUtil.getParameter(request, prefix	+ "indiv_corp_div_cd", length));
			String[] custDivCd = (JSPUtil.getParameter(request, prefix	+ "cust_div_cd", length));
			String[] cntrDivFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_div_flg", length));
			String[] fndtDt = (JSPUtil.getParameter(request, prefix	+ "fndt_dt", length));
			String[] keyAcctEndEffDt = (JSPUtil.getParameter(request, prefix	+ "key_acct_end_eff_dt", length));
			String[] prfCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "prf_cntr_tpsz_cd", length));
			String[] modiCustCd = (JSPUtil.getParameter(request, prefix	+ "modi_cust_cd", length));
			String[] bzetAddr = (JSPUtil.getParameter(request, prefix	+ "bzet_addr", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] keyAcctStEffDt = (JSPUtil.getParameter(request, prefix	+ "key_acct_st_eff_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] nvoccBdAmt = (JSPUtil.getParameter(request, prefix	+ "nvocc_bd_amt", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] cnsdCustSeq = (JSPUtil.getParameter(request, prefix	+ "cnsd_cust_seq", length));
			String[] nmdCustFlg = (JSPUtil.getParameter(request, prefix	+ "nmd_cust_flg", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] custGrpId = (JSPUtil.getParameter(request, prefix	+ "cust_grp_id", length));
			String[] nvoccBdStEffDt = (JSPUtil.getParameter(request, prefix	+ "nvocc_bd_st_eff_dt", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] cntrCustTpCd = (JSPUtil.getParameter(request, prefix	+ "cntr_cust_tp_cd", length));
			String[] fincStsLvlCd = (JSPUtil.getParameter(request, prefix	+ "finc_sts_lvl_cd", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] custRmk = (JSPUtil.getParameter(request, prefix	+ "cust_rmk", length));
			String[] frtFwrdFmcNo = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_fmc_no", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] nvoccBdNo = (JSPUtil.getParameter(request, prefix	+ "nvocc_bd_no", length));
			String[] spclReqDesc = (JSPUtil.getParameter(request, prefix	+ "spcl_req_desc", length));
			String[] nbsClssCd1 = (JSPUtil.getParameter(request, prefix	+ "nbs_clss_cd1", length));
			String[] nbsClssCd2 = (JSPUtil.getParameter(request, prefix	+ "nbs_clss_cd2", length));
			String[] capiAmt = (JSPUtil.getParameter(request, prefix	+ "capi_amt", length));
			String[] nbsClssCd3 = (JSPUtil.getParameter(request, prefix	+ "nbs_clss_cd3", length));
			String[] custLoclLangNm = (JSPUtil.getParameter(request, prefix	+ "cust_locl_lang_nm", length));
			String[] sprsPayLtrFlg = (JSPUtil.getParameter(request, prefix	+ "sprs_pay_ltr_flg", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] custAbbrNm = (JSPUtil.getParameter(request, prefix	+ "cust_abbr_nm", length));
			String[] prfGrpCmdtCd = (JSPUtil.getParameter(request, prefix	+ "prf_grp_cmdt_cd", length));
			String[] custRgstNo = (JSPUtil.getParameter(request, prefix	+ "cust_rgst_no", length));
			String[] lstkFlg = (JSPUtil.getParameter(request, prefix	+ "lstk_flg", length));
			String[] dfltInvCurrDivCd = (JSPUtil.getParameter(request, prefix	+ "dflt_inv_curr_div_cd", length));
			String[] nvoccBdEndEffDt = (JSPUtil.getParameter(request, prefix	+ "nvocc_bd_end_eff_dt", length));
			String[] nvoccCoScacCd = (JSPUtil.getParameter(request, prefix	+ "nvocc_co_scac_cd", length));
			String[] keyAcctFlg = (JSPUtil.getParameter(request, prefix	+ "key_acct_flg", length));
			String[] vbsClssCd = (JSPUtil.getParameter(request, prefix	+ "vbs_clss_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] payRqstLtrFmtCd = (JSPUtil.getParameter(request, prefix	+ "pay_rqst_ltr_fmt_cd", length));
			String[] cmptDesc = (JSPUtil.getParameter(request, prefix	+ "cmpt_desc", length));
			String[] slsDeltEffDt = (JSPUtil.getParameter(request, prefix	+ "sls_delt_eff_dt", length));
			String[] nvoccLicNo = (JSPUtil.getParameter(request, prefix	+ "nvocc_lic_no", length));
			String[] prfRepCmdtCd = (JSPUtil.getParameter(request, prefix	+ "prf_rep_cmdt_cd", length));
			String[] invEdiLvlCd = (JSPUtil.getParameter(request, prefix	+ "inv_edi_lvl_cd", length));
			String[] capiCurrCd = (JSPUtil.getParameter(request, prefix	+ "capi_curr_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] indusDesc = (JSPUtil.getParameter(request, prefix	+ "indus_desc", length));
			String[] prfSvcDesc = (JSPUtil.getParameter(request, prefix	+ "prf_svc_desc", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] crntVolKnt = (JSPUtil.getParameter(request, prefix	+ "crnt_vol_knt", length));
			String[] ctsNo = (JSPUtil.getParameter(request, prefix	+ "cts_no", length));
			String[] cnsdCustCntCd = (JSPUtil.getParameter(request, prefix	+ "cnsd_cust_cnt_cd", length));
			String[] prfSvcDtlDesc = (JSPUtil.getParameter(request, prefix	+ "prf_svc_dtl_desc", length));
			String[] empeKnt = (JSPUtil.getParameter(request, prefix	+ "empe_knt", length));
			String[] mltTrdAcctFlg = (JSPUtil.getParameter(request, prefix	+ "mlt_trd_acct_flg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] modiCustCd2 = (JSPUtil.getParameter(request, prefix	+ "modi_cust_cd2", length));
			String[] railRoadPrioFlg = (JSPUtil.getParameter(request, prefix	+ "rail_road_prio_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomerReportVO();
				if (indivCorpDivCd[i] != null)
					model.setIndivCorpDivCd(indivCorpDivCd[i]);
				if (custDivCd[i] != null)
					model.setCustDivCd(custDivCd[i]);
				if (cntrDivFlg[i] != null)
					model.setCntrDivFlg(cntrDivFlg[i]);
				if (fndtDt[i] != null)
					model.setFndtDt(fndtDt[i]);
				if (keyAcctEndEffDt[i] != null)
					model.setKeyAcctEndEffDt(keyAcctEndEffDt[i]);
				if (prfCntrTpszCd[i] != null)
					model.setPrfCntrTpszCd(prfCntrTpszCd[i]);
				if (modiCustCd[i] != null)
					model.setModiCustCd(modiCustCd[i]);
				if (bzetAddr[i] != null)
					model.setBzetAddr(bzetAddr[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (keyAcctStEffDt[i] != null)
					model.setKeyAcctStEffDt(keyAcctStEffDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (nvoccBdAmt[i] != null)
					model.setNvoccBdAmt(nvoccBdAmt[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (cnsdCustSeq[i] != null)
					model.setCnsdCustSeq(cnsdCustSeq[i]);
				if (nmdCustFlg[i] != null)
					model.setNmdCustFlg(nmdCustFlg[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (custGrpId[i] != null)
					model.setCustGrpId(custGrpId[i]);
				if (nvoccBdStEffDt[i] != null)
					model.setNvoccBdStEffDt(nvoccBdStEffDt[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (cntrCustTpCd[i] != null)
					model.setCntrCustTpCd(cntrCustTpCd[i]);
				if (fincStsLvlCd[i] != null)
					model.setFincStsLvlCd(fincStsLvlCd[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (custRmk[i] != null)
					model.setCustRmk(custRmk[i]);
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
				if (nbsClssCd2[i] != null)
					model.setNbsClssCd2(nbsClssCd2[i]);
				if (capiAmt[i] != null)
					model.setCapiAmt(capiAmt[i]);
				if (nbsClssCd3[i] != null)
					model.setNbsClssCd3(nbsClssCd3[i]);
				if (custLoclLangNm[i] != null)
					model.setCustLoclLangNm(custLoclLangNm[i]);
				if (sprsPayLtrFlg[i] != null)
					model.setSprsPayLtrFlg(sprsPayLtrFlg[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (custAbbrNm[i] != null)
					model.setCustAbbrNm(custAbbrNm[i]);
				if (prfGrpCmdtCd[i] != null)
					model.setPrfGrpCmdtCd(prfGrpCmdtCd[i]);
				if (custRgstNo[i] != null)
					model.setCustRgstNo(custRgstNo[i]);
				if (lstkFlg[i] != null)
					model.setLstkFlg(lstkFlg[i]);
				if (dfltInvCurrDivCd[i] != null)
					model.setDfltInvCurrDivCd(dfltInvCurrDivCd[i]);
				if (nvoccBdEndEffDt[i] != null)
					model.setNvoccBdEndEffDt(nvoccBdEndEffDt[i]);
				if (nvoccCoScacCd[i] != null)
					model.setNvoccCoScacCd(nvoccCoScacCd[i]);
				if (keyAcctFlg[i] != null)
					model.setKeyAcctFlg(keyAcctFlg[i]);
				if (vbsClssCd[i] != null)
					model.setVbsClssCd(vbsClssCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (payRqstLtrFmtCd[i] != null)
					model.setPayRqstLtrFmtCd(payRqstLtrFmtCd[i]);
				if (cmptDesc[i] != null)
					model.setCmptDesc(cmptDesc[i]);
				if (slsDeltEffDt[i] != null)
					model.setSlsDeltEffDt(slsDeltEffDt[i]);
				if (nvoccLicNo[i] != null)
					model.setNvoccLicNo(nvoccLicNo[i]);
				if (prfRepCmdtCd[i] != null)
					model.setPrfRepCmdtCd(prfRepCmdtCd[i]);
				if (invEdiLvlCd[i] != null)
					model.setInvEdiLvlCd(invEdiLvlCd[i]);
				if (capiCurrCd[i] != null)
					model.setCapiCurrCd(capiCurrCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (indusDesc[i] != null)
					model.setIndusDesc(indusDesc[i]);
				if (prfSvcDesc[i] != null)
					model.setPrfSvcDesc(prfSvcDesc[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (crntVolKnt[i] != null)
					model.setCrntVolKnt(crntVolKnt[i]);
				if (ctsNo[i] != null)
					model.setCtsNo(ctsNo[i]);
				if (cnsdCustCntCd[i] != null)
					model.setCnsdCustCntCd(cnsdCustCntCd[i]);
				if (prfSvcDtlDesc[i] != null)
					model.setPrfSvcDtlDesc(prfSvcDtlDesc[i]);
				if (empeKnt[i] != null)
					model.setEmpeKnt(empeKnt[i]);
				if (mltTrdAcctFlg[i] != null)
					model.setMltTrdAcctFlg(mltTrdAcctFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (modiCustCd2[i] != null)
					model.setModiCustCd2(modiCustCd2[i]);
				if (railRoadPrioFlg[i] != null)
					model.setRailRoadPrioFlg(railRoadPrioFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomerReportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomerReportVO[]
	 */
	public CustomerReportVO[] getCustomerReportVOs(){
		CustomerReportVO[] vos = (CustomerReportVO[])models.toArray(new CustomerReportVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.indivCorpDivCd = this.indivCorpDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custDivCd = this.custDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDivFlg = this.cntrDivFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fndtDt = this.fndtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyAcctEndEffDt = this.keyAcctEndEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prfCntrTpszCd = this.prfCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiCustCd = this.modiCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzetAddr = this.bzetAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyAcctStEffDt = this.keyAcctStEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvoccBdAmt = this.nvoccBdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnsdCustSeq = this.cnsdCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nmdCustFlg = this.nmdCustFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpId = this.custGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvoccBdStEffDt = this.nvoccBdStEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCustTpCd = this.cntrCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincStsLvlCd = this.fincStsLvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRmk = this.custRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdFmcNo = this.frtFwrdFmcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvoccBdNo = this.nvoccBdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclReqDesc = this.spclReqDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nbsClssCd1 = this.nbsClssCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nbsClssCd2 = this.nbsClssCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.capiAmt = this.capiAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nbsClssCd3 = this.nbsClssCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLoclLangNm = this.custLoclLangNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprsPayLtrFlg = this.sprsPayLtrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAbbrNm = this.custAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prfGrpCmdtCd = this.prfGrpCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRgstNo = this.custRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstkFlg = this.lstkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltInvCurrDivCd = this.dfltInvCurrDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvoccBdEndEffDt = this.nvoccBdEndEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvoccCoScacCd = this.nvoccCoScacCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyAcctFlg = this.keyAcctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vbsClssCd = this.vbsClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payRqstLtrFmtCd = this.payRqstLtrFmtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmptDesc = this.cmptDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsDeltEffDt = this.slsDeltEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvoccLicNo = this.nvoccLicNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prfRepCmdtCd = this.prfRepCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEdiLvlCd = this.invEdiLvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.capiCurrCd = this.capiCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.indusDesc = this.indusDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prfSvcDesc = this.prfSvcDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntVolKnt = this.crntVolKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctsNo = this.ctsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnsdCustCntCd = this.cnsdCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prfSvcDtlDesc = this.prfSvcDtlDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.empeKnt = this.empeKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mltTrdAcctFlg = this.mltTrdAcctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiCustCd2= this.modiCustCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railRoadPrioFlg = this.railRoadPrioFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
