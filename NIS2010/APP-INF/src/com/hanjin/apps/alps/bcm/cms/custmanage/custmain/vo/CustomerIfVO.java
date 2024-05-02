/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : CustomerIfVO.java
*@FileTitle : CustomerIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo;

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

	/* Column Info */
	private String custCntCd = null;

	/* Column Info */
	private String custSeq = null;

	/* Column Info */
	private String cntrDivFlg = null;

	/* Column Info */
	private String blkDivFlg = null;

	/* Column Info */
	private String custGrpCd = null;

	/* Column Info */
	private String custLglEngNm = null;

	/* Column Info */
	private String custLoclLangNm = null;

	/* Column Info */
	private String custAbbrNm = null;

	/* Column Info */
	private String rvisCntrCustTpCd = null;

	/* Column Info */
	private String blkCustTpCd = null;

	/* Column Info */
	private String dmstFrgnDivCd = null;

	/* Column Info */
	private String indivCorpDivCd = null;

	/* Column Info */
	private String mstOfcId = null;

	/* Column Info */
	private String ofcCd = null;

	/* Column Info */
	private String blkCntCd = null;

	/* Column Info */
	private String custIp = null;

	/* Column Info */
	private String custEml = null;

	/* Column Info */
	private String custUrl = null;

	/* Column Info */
	private String ownrNm = null;

	/* Column Info */
	private String bzctNm = null;

	/* Column Info */
	private String bztpDesc = null;

	/* Column Info */
	private String fndtDt = null;

	/* Column Info */
	private String custRgstNo = null;

	/* Column Info */
	private String custClssLvlCd = null;

	/* Column Info */
	private String fincStsLvlCd = null;

	/* Column Info */
	private String locCd = null;

	/* Column Info */
	private String capiCurrCd = null;

	/* Column Info */
	private String capiAmt = null;

	/* Column Info */
	private String sellCurrCd = null;

	/* Column Info */
	private String sellAmt = null;

	/* Column Info */
	private String lstkFlg = null;

	/* Column Info */
	private String empeKnt = null;

	/* Column Info */
	private String n1StBkgDt = null;

	/* Column Info */
	private String n1StBkgNo = null;

	/* Column Info */
	private String n1StBkgNoSplit = null;

	/* Column Info */
	private String vndrSeq = null;

	/* Column Info */
	private String custRmk = null;

	/* Column Info */
	private String valBseSegmClssCd = null;

	/* Column Info */
	private String ndsBseSegmClssCd1 = null;

	/* Column Info */
	private String ndsBseSegmClssCd2 = null;

	/* Column Info */
	private String ndsBseSegmClssCd3 = null;

	/* Column Info */
	private String mnIntlPhnNo = null;

	/* Column Info */
	private String mnArctPnnNo = null;

	/* Column Info */
	private String mnPhnNo = null;

	/* Column Info */
	private String mnFullPhnNo = null;

	/* Column Info */
	private String mnIntlFaxNo = null;

	/* Column Info */
	private String mnArctFaxNo = null;

	/* Column Info */
	private String mnFaxNo = null;

	/* Column Info */
	private String mnFullFaxNo = null;

	/* Column Info */
	private String custStsCd = null;

	/* Column Info */
	private String crmRowId = null;

	/* Column Info */
	private String nvoccHjsScacCd = null;

	/* Column Info */
	private String nvoccBdNo = null;

	/* Column Info */
	private String nvoccLicNo = null;

	/* Column Info */
	private String nvoccBdAmt = null;

	/* Column Info */
	private String nvoccBdStrtEffDt = null;

	/* Column Info */
	private String nvoccBdEndEffDt = null;

	/* Column Info */
	private String frtFwrdFmcNo = null;

	/* Column Info */
	private String frtFwrdEffDt = null;

	/* Column Info */
	private String fmcNoCd = null;

	/* Column Info */
	private String indusDesc = null;

	/* Column Info */
	private String crntVolKnt = null;

	/* Column Info */
	private String cpetiDesc = null;

	/* Column Info */
	private String spclReqDesc = null;

	/* Column Info */
	private String prfSvcDesc = null;

	/* Column Info */
	private String prfSvcDtlDesc = null;

	/* Column Info */
	private String prfGrpCmdtCd = null;

	/* Column Info */
	private String prfRepreCmdtCd = null;

	/* Column Info */
	private String prfCntrTpszCd = null;

	/* Column Info */
	private String srepCd = null;

	/* Column Info */
	private String ctsNo = null;

	/* Column Info */
	private String bfrOfcId = null;

	/* Column Info */
	private String bfrOfcCd = null;

	/* Column Info */
	private String bfrOfcChngDt = null;

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
	private String modiCustCntCd = null;

	/* Column Info */
	private String modiCustSeq = null;

	/* Column Info */
	private String oMstOfcId = null;

	/* Column Info */
	private String oOfcCd = null;

	/* Column Info */
	private String rtnEml = null;

	/* Column Info */
	private String custAddrRowId = null;

	/* Column Info */
	private String custAddrStsCd = null;

	/* Column Info */
	private String addrTpCd = null;

	/* Column Info */
	private String prmryChkFlg = null;

	/* Column Info */
	private String bzetAddr = null;

	/* Column Info */
	private String ctyNm = null;

	/* Column Info */
	private String steCd = null;

	/* Column Info */
	private String zipCd = null;

	/* Column Info */
	private String cntCd = null;

	/* Column Info */
	private String ssidiCoCd = null;

	/* Column Info */
	private String keyAcctFlg = null;

	/* Column Info */
	private String keyAcctStrtEffDt = null;

	/* Column Info */
	private String keyAcctEndEffDt = null;

	/* Column Info */
	private String deltEffDt = null;

	/* Column Info */
	private String slsDeltFlg = null;

	/* Column Info */
	private String keyAcctMgrGloUsrId = null;

	/* Column Info */
	private String keyAcctMgrGloUsrNm = null;

	/* Column Info */
	private String addrSeq = null;

	/* Column Info */
	private String subsCoFmDt = null;

	/* Column Info */
	private String subsCoToDt = null;

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
	private String nmdCustFlg = null;

	/* Column Info */
	private String mltTrdAcctFlg = null;

	/* Column Info */
	private String otiOrzNo = null;

	/* Column Info */
	private String rfAcctFlg = null;

	/* Column Info */
	private String slsDeltEffRsnCd = null;

	/* Column Info */
	private String newKeyAcctFlg = null;

	/* Column Info */
	private String gloAcctFlg = null;

	/* Column Info */
	private String rgnAcctFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CustomerIfVO() {}

	public CustomerIfVO(String ibflag, String pagerows, String custCntCd, String custSeq, String cntrDivFlg, String blkDivFlg, String custGrpCd, String custLglEngNm, String custLoclLangNm, String custAbbrNm, String rvisCntrCustTpCd, String blkCustTpCd, String dmstFrgnDivCd, String indivCorpDivCd, String mstOfcId, String ofcCd, String blkCntCd, String custIp, String custEml, String custUrl, String ownrNm, String bzctNm, String bztpDesc, String fndtDt, String custRgstNo, String custClssLvlCd, String fincStsLvlCd, String locCd, String capiCurrCd, String capiAmt, String sellCurrCd, String sellAmt, String lstkFlg, String empeKnt, String n1StBkgDt, String n1StBkgNo, String n1StBkgNoSplit, String vndrSeq, String custRmk, String valBseSegmClssCd, String ndsBseSegmClssCd1, String ndsBseSegmClssCd2, String ndsBseSegmClssCd3, String mnIntlPhnNo, String mnArctPnnNo, String mnPhnNo, String mnFullPhnNo, String mnIntlFaxNo, String mnArctFaxNo, String mnFaxNo, String mnFullFaxNo, String custStsCd, String crmRowId, String nvoccHjsScacCd, String nvoccBdNo, String nvoccLicNo, String nvoccBdAmt, String nvoccBdStrtEffDt, String nvoccBdEndEffDt, String frtFwrdFmcNo, String frtFwrdEffDt, String fmcNoCd, String indusDesc, String crntVolKnt, String cpetiDesc, String spclReqDesc, String prfSvcDesc, String prfSvcDtlDesc, String prfGrpCmdtCd, String prfRepreCmdtCd, String prfCntrTpszCd, String srepCd, String ctsNo, String bfrOfcId, String bfrOfcCd, String bfrOfcChngDt, String creUsrId, String creDt, String updUsrId, String updDt, String deltFlg, String modiCustCntCd, String modiCustSeq, String oMstOfcId, String oOfcCd, String rtnEml, String custAddrRowId, String custAddrStsCd, String addrTpCd, String prmryChkFlg, String bzetAddr, String ctyNm, String steCd, String zipCd, String cntCd, String ssidiCoCd, String keyAcctFlg, String keyAcctStrtEffDt, String keyAcctEndEffDt, String deltEffDt, String slsDeltFlg, String keyAcctMgrGloUsrId, String keyAcctMgrGloUsrNm, String addrSeq, String subsCoFmDt, String subsCoToDt, String bkgAltRsn, String bkgAltFmDt, String bkgAltToDt, String bkgAltMsg, String bkgAltCreUsrId, String bkgAltCreDt, String nmdCustFlg, String mltTrdAcctFlg, String otiOrzNo, String rfAcctFlg, String slsDeltEffRsnCd, String newKeyAcctFlg, String gloAcctFlg, String rgnAcctFlg) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.custCntCd = custCntCd;
		this.custSeq = custSeq;
		this.cntrDivFlg = cntrDivFlg;
		this.blkDivFlg = blkDivFlg;
		this.custGrpCd = custGrpCd;
		this.custLglEngNm = custLglEngNm;
		this.custLoclLangNm = custLoclLangNm;
		this.custAbbrNm = custAbbrNm;
		this.rvisCntrCustTpCd = rvisCntrCustTpCd;
		this.blkCustTpCd = blkCustTpCd;
		this.dmstFrgnDivCd = dmstFrgnDivCd;
		this.indivCorpDivCd = indivCorpDivCd;
		this.mstOfcId = mstOfcId;
		this.ofcCd = ofcCd;
		this.blkCntCd = blkCntCd;
		this.custIp = custIp;
		this.custEml = custEml;
		this.custUrl = custUrl;
		this.ownrNm = ownrNm;
		this.bzctNm = bzctNm;
		this.bztpDesc = bztpDesc;
		this.fndtDt = fndtDt;
		this.custRgstNo = custRgstNo;
		this.custClssLvlCd = custClssLvlCd;
		this.fincStsLvlCd = fincStsLvlCd;
		this.locCd = locCd;
		this.capiCurrCd = capiCurrCd;
		this.capiAmt = capiAmt;
		this.sellCurrCd = sellCurrCd;
		this.sellAmt = sellAmt;
		this.lstkFlg = lstkFlg;
		this.empeKnt = empeKnt;
		this.n1StBkgDt = n1StBkgDt;
		this.n1StBkgNo = n1StBkgNo;
		this.n1StBkgNoSplit = n1StBkgNoSplit;
		this.vndrSeq = vndrSeq;
		this.custRmk = custRmk;
		this.valBseSegmClssCd = valBseSegmClssCd;
		this.ndsBseSegmClssCd1 = ndsBseSegmClssCd1;
		this.ndsBseSegmClssCd2 = ndsBseSegmClssCd2;
		this.ndsBseSegmClssCd3 = ndsBseSegmClssCd3;
		this.mnIntlPhnNo = mnIntlPhnNo;
		this.mnArctPnnNo = mnArctPnnNo;
		this.mnPhnNo = mnPhnNo;
		this.mnFullPhnNo = mnFullPhnNo;
		this.mnIntlFaxNo = mnIntlFaxNo;
		this.mnArctFaxNo = mnArctFaxNo;
		this.mnFaxNo = mnFaxNo;
		this.mnFullFaxNo = mnFullFaxNo;
		this.custStsCd = custStsCd;
		this.crmRowId = crmRowId;
		this.nvoccHjsScacCd = nvoccHjsScacCd;
		this.nvoccBdNo = nvoccBdNo;
		this.nvoccLicNo = nvoccLicNo;
		this.nvoccBdAmt = nvoccBdAmt;
		this.nvoccBdStrtEffDt = nvoccBdStrtEffDt;
		this.nvoccBdEndEffDt = nvoccBdEndEffDt;
		this.frtFwrdFmcNo = frtFwrdFmcNo;
		this.frtFwrdEffDt = frtFwrdEffDt;
		this.fmcNoCd = fmcNoCd;
		this.indusDesc = indusDesc;
		this.crntVolKnt = crntVolKnt;
		this.cpetiDesc = cpetiDesc;
		this.spclReqDesc = spclReqDesc;
		this.prfSvcDesc = prfSvcDesc;
		this.prfSvcDtlDesc = prfSvcDtlDesc;
		this.prfGrpCmdtCd = prfGrpCmdtCd;
		this.prfRepreCmdtCd = prfRepreCmdtCd;
		this.prfCntrTpszCd = prfCntrTpszCd;
		this.srepCd = srepCd;
		this.ctsNo = ctsNo;
		this.bfrOfcId = bfrOfcId;
		this.bfrOfcCd = bfrOfcCd;
		this.bfrOfcChngDt = bfrOfcChngDt;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.deltFlg = deltFlg;
		this.modiCustCntCd = modiCustCntCd;
		this.modiCustSeq = modiCustSeq;
		this.oMstOfcId = oMstOfcId;
		this.oOfcCd = oOfcCd;
		this.rtnEml = rtnEml;
		this.custAddrRowId = custAddrRowId;
		this.custAddrStsCd = custAddrStsCd;
		this.addrTpCd = addrTpCd;
		this.prmryChkFlg = prmryChkFlg;
		this.bzetAddr = bzetAddr;
		this.ctyNm = ctyNm;
		this.steCd = steCd;
		this.zipCd = zipCd;
		this.cntCd = cntCd;
		this.ssidiCoCd = ssidiCoCd;
		this.keyAcctFlg = keyAcctFlg;
		this.keyAcctStrtEffDt = keyAcctStrtEffDt;
		this.keyAcctEndEffDt = keyAcctEndEffDt;
		this.deltEffDt = deltEffDt;
		this.slsDeltFlg = slsDeltFlg;
		this.keyAcctMgrGloUsrId = keyAcctMgrGloUsrId;
		this.keyAcctMgrGloUsrNm = keyAcctMgrGloUsrNm;
		this.addrSeq = addrSeq;
		this.subsCoFmDt = subsCoFmDt;
		this.subsCoToDt = subsCoToDt;
		this.bkgAltRsn = bkgAltRsn;
		this.bkgAltFmDt = bkgAltFmDt;
		this.bkgAltToDt = bkgAltToDt;
		this.bkgAltMsg = bkgAltMsg;
		this.bkgAltCreUsrId = bkgAltCreUsrId;
		this.bkgAltCreDt = bkgAltCreDt;
		this.nmdCustFlg = nmdCustFlg;
		this.mltTrdAcctFlg = mltTrdAcctFlg;
		this.otiOrzNo = otiOrzNo;
		this.rfAcctFlg = rfAcctFlg;
		this.slsDeltEffRsnCd = slsDeltEffRsnCd;
		this.newKeyAcctFlg = newKeyAcctFlg;
		this.gloAcctFlg = gloAcctFlg;
		this.rgnAcctFlg = rgnAcctFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cntr_div_flg", getCntrDivFlg());
		this.hashColumns.put("blk_div_flg", getBlkDivFlg());
		this.hashColumns.put("cust_grp_cd", getCustGrpCd());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("cust_locl_lang_nm", getCustLoclLangNm());
		this.hashColumns.put("cust_abbr_nm", getCustAbbrNm());
		this.hashColumns.put("rvis_cntr_cust_tp_cd", getRvisCntrCustTpCd());
		this.hashColumns.put("blk_cust_tp_cd", getBlkCustTpCd());
		this.hashColumns.put("dmst_frgn_div_cd", getDmstFrgnDivCd());
		this.hashColumns.put("indiv_corp_div_cd", getIndivCorpDivCd());
		this.hashColumns.put("mst_ofc_id", getMstOfcId());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("blk_cnt_cd", getBlkCntCd());
		this.hashColumns.put("cust_ip", getCustIp());
		this.hashColumns.put("cust_eml", getCustEml());
		this.hashColumns.put("cust_url", getCustUrl());
		this.hashColumns.put("ownr_nm", getOwnrNm());
		this.hashColumns.put("bzct_nm", getBzctNm());
		this.hashColumns.put("bztp_desc", getBztpDesc());
		this.hashColumns.put("fndt_dt", getFndtDt());
		this.hashColumns.put("cust_rgst_no", getCustRgstNo());
		this.hashColumns.put("cust_clss_lvl_cd", getCustClssLvlCd());
		this.hashColumns.put("finc_sts_lvl_cd", getFincStsLvlCd());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("capi_curr_cd", getCapiCurrCd());
		this.hashColumns.put("capi_amt", getCapiAmt());
		this.hashColumns.put("sell_curr_cd", getSellCurrCd());
		this.hashColumns.put("sell_amt", getSellAmt());
		this.hashColumns.put("lstk_flg", getLstkFlg());
		this.hashColumns.put("empe_knt", getEmpeKnt());
		this.hashColumns.put("n1st_bkg_dt", getN1StBkgDt());
		this.hashColumns.put("n1st_bkg_no", getN1StBkgNo());
		this.hashColumns.put("n1st_bkg_no_split", getN1StBkgNoSplit());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("cust_rmk", getCustRmk());
		this.hashColumns.put("val_bse_segm_clss_cd", getValBseSegmClssCd());
		this.hashColumns.put("nds_bse_segm_clss_cd1", getNdsBseSegmClssCd1());
		this.hashColumns.put("nds_bse_segm_clss_cd2", getNdsBseSegmClssCd2());
		this.hashColumns.put("nds_bse_segm_clss_cd3", getNdsBseSegmClssCd3());
		this.hashColumns.put("mn_intl_phn_no", getMnIntlPhnNo());
		this.hashColumns.put("mn_arct_pnn_no", getMnArctPnnNo());
		this.hashColumns.put("mn_phn_no", getMnPhnNo());
		this.hashColumns.put("mn_full_phn_no", getMnFullPhnNo());
		this.hashColumns.put("mn_intl_fax_no", getMnIntlFaxNo());
		this.hashColumns.put("mn_arct_fax_no", getMnArctFaxNo());
		this.hashColumns.put("mn_fax_no", getMnFaxNo());
		this.hashColumns.put("mn_full_fax_no", getMnFullFaxNo());
		this.hashColumns.put("cust_sts_cd", getCustStsCd());
		this.hashColumns.put("crm_row_id", getCrmRowId());
		this.hashColumns.put("nvocc_hjs_scac_cd", getNvoccHjsScacCd());
		this.hashColumns.put("nvocc_bd_no", getNvoccBdNo());
		this.hashColumns.put("nvocc_lic_no", getNvoccLicNo());
		this.hashColumns.put("nvocc_bd_amt", getNvoccBdAmt());
		this.hashColumns.put("nvocc_bd_strt_eff_dt", getNvoccBdStrtEffDt());
		this.hashColumns.put("nvocc_bd_end_eff_dt", getNvoccBdEndEffDt());
		this.hashColumns.put("frt_fwrd_fmc_no", getFrtFwrdFmcNo());
		this.hashColumns.put("frt_fwrd_eff_dt", getFrtFwrdEffDt());
		this.hashColumns.put("fmc_no_cd", getFmcNoCd());
		this.hashColumns.put("indus_desc", getIndusDesc());
		this.hashColumns.put("crnt_vol_knt", getCrntVolKnt());
		this.hashColumns.put("cpeti_desc", getCpetiDesc());
		this.hashColumns.put("spcl_req_desc", getSpclReqDesc());
		this.hashColumns.put("prf_svc_desc", getPrfSvcDesc());
		this.hashColumns.put("prf_svc_dtl_desc", getPrfSvcDtlDesc());
		this.hashColumns.put("prf_grp_cmdt_cd", getPrfGrpCmdtCd());
		this.hashColumns.put("prf_repre_cmdt_cd", getPrfRepreCmdtCd());
		this.hashColumns.put("prf_cntr_tpsz_cd", getPrfCntrTpszCd());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("cts_no", getCtsNo());
		this.hashColumns.put("bfr_ofc_id", getBfrOfcId());
		this.hashColumns.put("bfr_ofc_cd", getBfrOfcCd());
		this.hashColumns.put("bfr_ofc_chng_dt", getBfrOfcChngDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("modi_cust_cnt_cd", getModiCustCntCd());
		this.hashColumns.put("modi_cust_seq", getModiCustSeq());
		this.hashColumns.put("o_mst_ofc_id", getOMstOfcId());
		this.hashColumns.put("o_ofc_cd", getOOfcCd());
		this.hashColumns.put("rtn_eml", getRtnEml());
		this.hashColumns.put("cust_addr_row_id", getCustAddrRowId());
		this.hashColumns.put("cust_addr_sts_cd", getCustAddrStsCd());
		this.hashColumns.put("addr_tp_cd", getAddrTpCd());
		this.hashColumns.put("prmry_chk_flg", getPrmryChkFlg());
		this.hashColumns.put("bzet_addr", getBzetAddr());
		this.hashColumns.put("cty_nm", getCtyNm());
		this.hashColumns.put("ste_cd", getSteCd());
		this.hashColumns.put("zip_cd", getZipCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("ssidi_co_cd", getSsidiCoCd());
		this.hashColumns.put("key_acct_flg", getKeyAcctFlg());
		this.hashColumns.put("key_acct_strt_eff_dt", getKeyAcctStrtEffDt());
		this.hashColumns.put("key_acct_end_eff_dt", getKeyAcctEndEffDt());
		this.hashColumns.put("delt_eff_dt", getDeltEffDt());
		this.hashColumns.put("sls_delt_flg", getSlsDeltFlg());
		this.hashColumns.put("key_acct_mgr_glo_usr_id", getKeyAcctMgrGloUsrId());
		this.hashColumns.put("key_acct_mgr_glo_usr_nm", getKeyAcctMgrGloUsrNm());
		this.hashColumns.put("addr_seq", getAddrSeq());
		this.hashColumns.put("subs_co_fm_dt", getSubsCoFmDt());
		this.hashColumns.put("subs_co_to_dt", getSubsCoToDt());
		this.hashColumns.put("bkg_alt_rsn", getBkgAltRsn());
		this.hashColumns.put("bkg_alt_fm_dt", getBkgAltFmDt());
		this.hashColumns.put("bkg_alt_to_dt", getBkgAltToDt());
		this.hashColumns.put("bkg_alt_msg", getBkgAltMsg());
		this.hashColumns.put("bkg_alt_cre_usr_id", getBkgAltCreUsrId());
		this.hashColumns.put("bkg_alt_cre_dt", getBkgAltCreDt());
		this.hashColumns.put("nmd_cust_flg", getNmdCustFlg());
		this.hashColumns.put("mlt_trd_acct_flg", getMltTrdAcctFlg());
		this.hashColumns.put("oti_orz_no", getOtiOrzNo());
		this.hashColumns.put("rf_acct_flg", getRfAcctFlg());
		this.hashColumns.put("sls_delt_eff_rsn_cd", getSlsDeltEffRsnCd());
		this.hashColumns.put("new_key_acct_flg", getNewKeyAcctFlg());
		this.hashColumns.put("glo_acct_flg", getGloAcctFlg());
		this.hashColumns.put("rgn_acct_flg", getRgnAcctFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cntr_div_flg", "cntrDivFlg");
		this.hashFields.put("blk_div_flg", "blkDivFlg");
		this.hashFields.put("cust_grp_cd", "custGrpCd");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("cust_locl_lang_nm", "custLoclLangNm");
		this.hashFields.put("cust_abbr_nm", "custAbbrNm");
		this.hashFields.put("rvis_cntr_cust_tp_cd", "rvisCntrCustTpCd");
		this.hashFields.put("blk_cust_tp_cd", "blkCustTpCd");
		this.hashFields.put("dmst_frgn_div_cd", "dmstFrgnDivCd");
		this.hashFields.put("indiv_corp_div_cd", "indivCorpDivCd");
		this.hashFields.put("mst_ofc_id", "mstOfcId");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("blk_cnt_cd", "blkCntCd");
		this.hashFields.put("cust_ip", "custIp");
		this.hashFields.put("cust_eml", "custEml");
		this.hashFields.put("cust_url", "custUrl");
		this.hashFields.put("ownr_nm", "ownrNm");
		this.hashFields.put("bzct_nm", "bzctNm");
		this.hashFields.put("bztp_desc", "bztpDesc");
		this.hashFields.put("fndt_dt", "fndtDt");
		this.hashFields.put("cust_rgst_no", "custRgstNo");
		this.hashFields.put("cust_clss_lvl_cd", "custClssLvlCd");
		this.hashFields.put("finc_sts_lvl_cd", "fincStsLvlCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("capi_curr_cd", "capiCurrCd");
		this.hashFields.put("capi_amt", "capiAmt");
		this.hashFields.put("sell_curr_cd", "sellCurrCd");
		this.hashFields.put("sell_amt", "sellAmt");
		this.hashFields.put("lstk_flg", "lstkFlg");
		this.hashFields.put("empe_knt", "empeKnt");
		this.hashFields.put("n1st_bkg_dt", "n1StBkgDt");
		this.hashFields.put("n1st_bkg_no", "n1StBkgNo");
		this.hashFields.put("n1st_bkg_no_split", "n1StBkgNoSplit");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("cust_rmk", "custRmk");
		this.hashFields.put("val_bse_segm_clss_cd", "valBseSegmClssCd");
		this.hashFields.put("nds_bse_segm_clss_cd1", "ndsBseSegmClssCd1");
		this.hashFields.put("nds_bse_segm_clss_cd2", "ndsBseSegmClssCd2");
		this.hashFields.put("nds_bse_segm_clss_cd3", "ndsBseSegmClssCd3");
		this.hashFields.put("mn_intl_phn_no", "mnIntlPhnNo");
		this.hashFields.put("mn_arct_pnn_no", "mnArctPnnNo");
		this.hashFields.put("mn_phn_no", "mnPhnNo");
		this.hashFields.put("mn_full_phn_no", "mnFullPhnNo");
		this.hashFields.put("mn_intl_fax_no", "mnIntlFaxNo");
		this.hashFields.put("mn_arct_fax_no", "mnArctFaxNo");
		this.hashFields.put("mn_fax_no", "mnFaxNo");
		this.hashFields.put("mn_full_fax_no", "mnFullFaxNo");
		this.hashFields.put("cust_sts_cd", "custStsCd");
		this.hashFields.put("crm_row_id", "crmRowId");
		this.hashFields.put("nvocc_hjs_scac_cd", "nvoccHjsScacCd");
		this.hashFields.put("nvocc_bd_no", "nvoccBdNo");
		this.hashFields.put("nvocc_lic_no", "nvoccLicNo");
		this.hashFields.put("nvocc_bd_amt", "nvoccBdAmt");
		this.hashFields.put("nvocc_bd_strt_eff_dt", "nvoccBdStrtEffDt");
		this.hashFields.put("nvocc_bd_end_eff_dt", "nvoccBdEndEffDt");
		this.hashFields.put("frt_fwrd_fmc_no", "frtFwrdFmcNo");
		this.hashFields.put("frt_fwrd_eff_dt", "frtFwrdEffDt");
		this.hashFields.put("fmc_no_cd", "fmcNoCd");
		this.hashFields.put("indus_desc", "indusDesc");
		this.hashFields.put("crnt_vol_knt", "crntVolKnt");
		this.hashFields.put("cpeti_desc", "cpetiDesc");
		this.hashFields.put("spcl_req_desc", "spclReqDesc");
		this.hashFields.put("prf_svc_desc", "prfSvcDesc");
		this.hashFields.put("prf_svc_dtl_desc", "prfSvcDtlDesc");
		this.hashFields.put("prf_grp_cmdt_cd", "prfGrpCmdtCd");
		this.hashFields.put("prf_repre_cmdt_cd", "prfRepreCmdtCd");
		this.hashFields.put("prf_cntr_tpsz_cd", "prfCntrTpszCd");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("cts_no", "ctsNo");
		this.hashFields.put("bfr_ofc_id", "bfrOfcId");
		this.hashFields.put("bfr_ofc_cd", "bfrOfcCd");
		this.hashFields.put("bfr_ofc_chng_dt", "bfrOfcChngDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("modi_cust_cnt_cd", "modiCustCntCd");
		this.hashFields.put("modi_cust_seq", "modiCustSeq");
		this.hashFields.put("o_mst_ofc_id", "oMstOfcId");
		this.hashFields.put("o_ofc_cd", "oOfcCd");
		this.hashFields.put("rtn_eml", "rtnEml");
		this.hashFields.put("cust_addr_row_id", "custAddrRowId");
		this.hashFields.put("cust_addr_sts_cd", "custAddrStsCd");
		this.hashFields.put("addr_tp_cd", "addrTpCd");
		this.hashFields.put("prmry_chk_flg", "prmryChkFlg");
		this.hashFields.put("bzet_addr", "bzetAddr");
		this.hashFields.put("cty_nm", "ctyNm");
		this.hashFields.put("ste_cd", "steCd");
		this.hashFields.put("zip_cd", "zipCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("ssidi_co_cd", "ssidiCoCd");
		this.hashFields.put("key_acct_flg", "keyAcctFlg");
		this.hashFields.put("key_acct_strt_eff_dt", "keyAcctStrtEffDt");
		this.hashFields.put("key_acct_end_eff_dt", "keyAcctEndEffDt");
		this.hashFields.put("delt_eff_dt", "deltEffDt");
		this.hashFields.put("sls_delt_flg", "slsDeltFlg");
		this.hashFields.put("key_acct_mgr_glo_usr_id", "keyAcctMgrGloUsrId");
		this.hashFields.put("key_acct_mgr_glo_usr_nm", "keyAcctMgrGloUsrNm");
		this.hashFields.put("addr_seq", "addrSeq");
		this.hashFields.put("subs_co_fm_dt", "subsCoFmDt");
		this.hashFields.put("subs_co_to_dt", "subsCoToDt");
		this.hashFields.put("bkg_alt_rsn", "bkgAltRsn");
		this.hashFields.put("bkg_alt_fm_dt", "bkgAltFmDt");
		this.hashFields.put("bkg_alt_to_dt", "bkgAltToDt");
		this.hashFields.put("bkg_alt_msg", "bkgAltMsg");
		this.hashFields.put("bkg_alt_cre_usr_id", "bkgAltCreUsrId");
		this.hashFields.put("bkg_alt_cre_dt", "bkgAltCreDt");
		this.hashFields.put("nmd_cust_flg", "nmdCustFlg");
		this.hashFields.put("mlt_trd_acct_flg", "mltTrdAcctFlg");
		this.hashFields.put("oti_orz_no", "otiOrzNo");
		this.hashFields.put("rf_acct_flg", "rfAcctFlg");
		this.hashFields.put("sls_delt_eff_rsn_cd", "slsDeltEffRsnCd");
		this.hashFields.put("new_key_acct_flg", "newKeyAcctFlg");
		this.hashFields.put("glo_acct_flg", "gloAcctFlg");
		this.hashFields.put("rgn_acct_flg", "rgnAcctFlg");
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
	 * @param String custGrpCd
	 */
	public void setCustGrpCd(String custGrpCd) {
		this.custGrpCd = custGrpCd;
	}
	
	/**
	 * 
	 * @return String custGrpCd
	 */
	public String getCustGrpCd() {
		return this.custGrpCd;
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
	 * @param String rvisCntrCustTpCd
	 */
	public void setRvisCntrCustTpCd(String rvisCntrCustTpCd) {
		this.rvisCntrCustTpCd = rvisCntrCustTpCd;
	}
	
	/**
	 * 
	 * @return String rvisCntrCustTpCd
	 */
	public String getRvisCntrCustTpCd() {
		return this.rvisCntrCustTpCd;
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
	 * @param String dmstFrgnDivCd
	 */
	public void setDmstFrgnDivCd(String dmstFrgnDivCd) {
		this.dmstFrgnDivCd = dmstFrgnDivCd;
	}
	
	/**
	 * 
	 * @return String dmstFrgnDivCd
	 */
	public String getDmstFrgnDivCd() {
		return this.dmstFrgnDivCd;
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
	 * @param String mstOfcId
	 */
	public void setMstOfcId(String mstOfcId) {
		this.mstOfcId = mstOfcId;
	}
	
	/**
	 * 
	 * @return String mstOfcId
	 */
	public String getMstOfcId() {
		return this.mstOfcId;
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
	 * @param String blkCntCd
	 */
	public void setBlkCntCd(String blkCntCd) {
		this.blkCntCd = blkCntCd;
	}
	
	/**
	 * 
	 * @return String blkCntCd
	 */
	public String getBlkCntCd() {
		return this.blkCntCd;
	}
	
	/**
	 *
	 * @param String custIp
	 */
	public void setCustIp(String custIp) {
		this.custIp = custIp;
	}
	
	/**
	 * 
	 * @return String custIp
	 */
	public String getCustIp() {
		return this.custIp;
	}
	
	/**
	 *
	 * @param String custEml
	 */
	public void setCustEml(String custEml) {
		this.custEml = custEml;
	}
	
	/**
	 * 
	 * @return String custEml
	 */
	public String getCustEml() {
		return this.custEml;
	}
	
	/**
	 *
	 * @param String custUrl
	 */
	public void setCustUrl(String custUrl) {
		this.custUrl = custUrl;
	}
	
	/**
	 * 
	 * @return String custUrl
	 */
	public String getCustUrl() {
		return this.custUrl;
	}
	
	/**
	 *
	 * @param String ownrNm
	 */
	public void setOwnrNm(String ownrNm) {
		this.ownrNm = ownrNm;
	}
	
	/**
	 * 
	 * @return String ownrNm
	 */
	public String getOwnrNm() {
		return this.ownrNm;
	}
	
	/**
	 *
	 * @param String bzctNm
	 */
	public void setBzctNm(String bzctNm) {
		this.bzctNm = bzctNm;
	}
	
	/**
	 * 
	 * @return String bzctNm
	 */
	public String getBzctNm() {
		return this.bzctNm;
	}
	
	/**
	 *
	 * @param String bztpDesc
	 */
	public void setBztpDesc(String bztpDesc) {
		this.bztpDesc = bztpDesc;
	}
	
	/**
	 * 
	 * @return String bztpDesc
	 */
	public String getBztpDesc() {
		return this.bztpDesc;
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
	 * @param String custClssLvlCd
	 */
	public void setCustClssLvlCd(String custClssLvlCd) {
		this.custClssLvlCd = custClssLvlCd;
	}
	
	/**
	 * 
	 * @return String custClssLvlCd
	 */
	public String getCustClssLvlCd() {
		return this.custClssLvlCd;
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
	 * @param String sellCurrCd
	 */
	public void setSellCurrCd(String sellCurrCd) {
		this.sellCurrCd = sellCurrCd;
	}
	
	/**
	 * 
	 * @return String sellCurrCd
	 */
	public String getSellCurrCd() {
		return this.sellCurrCd;
	}
	
	/**
	 *
	 * @param String sellAmt
	 */
	public void setSellAmt(String sellAmt) {
		this.sellAmt = sellAmt;
	}
	
	/**
	 * 
	 * @return String sellAmt
	 */
	public String getSellAmt() {
		return this.sellAmt;
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
	 * @param String n1StBkgDt
	 */
	public void setN1StBkgDt(String n1StBkgDt) {
		this.n1StBkgDt = n1StBkgDt;
	}
	
	/**
	 * 
	 * @return String n1StBkgDt
	 */
	public String getN1StBkgDt() {
		return this.n1StBkgDt;
	}
	
	/**
	 *
	 * @param String n1StBkgNo
	 */
	public void setN1StBkgNo(String n1StBkgNo) {
		this.n1StBkgNo = n1StBkgNo;
	}
	
	/**
	 * 
	 * @return String n1StBkgNo
	 */
	public String getN1StBkgNo() {
		return this.n1StBkgNo;
	}
	
	/**
	 *
	 * @param String n1StBkgNoSplit
	 */
	public void setN1StBkgNoSplit(String n1StBkgNoSplit) {
		this.n1StBkgNoSplit = n1StBkgNoSplit;
	}
	
	/**
	 * 
	 * @return String n1StBkgNoSplit
	 */
	public String getN1StBkgNoSplit() {
		return this.n1StBkgNoSplit;
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
	 * @param String valBseSegmClssCd
	 */
	public void setValBseSegmClssCd(String valBseSegmClssCd) {
		this.valBseSegmClssCd = valBseSegmClssCd;
	}
	
	/**
	 * 
	 * @return String valBseSegmClssCd
	 */
	public String getValBseSegmClssCd() {
		return this.valBseSegmClssCd;
	}
	
	/**
	 *
	 * @param String ndsBseSegmClssCd1
	 */
	public void setNdsBseSegmClssCd1(String ndsBseSegmClssCd1) {
		this.ndsBseSegmClssCd1 = ndsBseSegmClssCd1;
	}
	
	/**
	 * 
	 * @return String ndsBseSegmClssCd1
	 */
	public String getNdsBseSegmClssCd1() {
		return this.ndsBseSegmClssCd1;
	}
	
	/**
	 *
	 * @param String ndsBseSegmClssCd2
	 */
	public void setNdsBseSegmClssCd2(String ndsBseSegmClssCd2) {
		this.ndsBseSegmClssCd2 = ndsBseSegmClssCd2;
	}
	
	/**
	 * 
	 * @return String ndsBseSegmClssCd2
	 */
	public String getNdsBseSegmClssCd2() {
		return this.ndsBseSegmClssCd2;
	}
	
	/**
	 *
	 * @param String ndsBseSegmClssCd3
	 */
	public void setNdsBseSegmClssCd3(String ndsBseSegmClssCd3) {
		this.ndsBseSegmClssCd3 = ndsBseSegmClssCd3;
	}
	
	/**
	 * 
	 * @return String ndsBseSegmClssCd3
	 */
	public String getNdsBseSegmClssCd3() {
		return this.ndsBseSegmClssCd3;
	}
	
	/**
	 *
	 * @param String mnIntlPhnNo
	 */
	public void setMnIntlPhnNo(String mnIntlPhnNo) {
		this.mnIntlPhnNo = mnIntlPhnNo;
	}
	
	/**
	 * 
	 * @return String mnIntlPhnNo
	 */
	public String getMnIntlPhnNo() {
		return this.mnIntlPhnNo;
	}
	
	/**
	 *
	 * @param String mnArctPnnNo
	 */
	public void setMnArctPnnNo(String mnArctPnnNo) {
		this.mnArctPnnNo = mnArctPnnNo;
	}
	
	/**
	 * 
	 * @return String mnArctPnnNo
	 */
	public String getMnArctPnnNo() {
		return this.mnArctPnnNo;
	}
	
	/**
	 *
	 * @param String mnPhnNo
	 */
	public void setMnPhnNo(String mnPhnNo) {
		this.mnPhnNo = mnPhnNo;
	}
	
	/**
	 * 
	 * @return String mnPhnNo
	 */
	public String getMnPhnNo() {
		return this.mnPhnNo;
	}
	
	/**
	 *
	 * @param String mnFullPhnNo
	 */
	public void setMnFullPhnNo(String mnFullPhnNo) {
		this.mnFullPhnNo = mnFullPhnNo;
	}
	
	/**
	 * 
	 * @return String mnFullPhnNo
	 */
	public String getMnFullPhnNo() {
		return this.mnFullPhnNo;
	}
	
	/**
	 *
	 * @param String mnIntlFaxNo
	 */
	public void setMnIntlFaxNo(String mnIntlFaxNo) {
		this.mnIntlFaxNo = mnIntlFaxNo;
	}
	
	/**
	 * 
	 * @return String mnIntlFaxNo
	 */
	public String getMnIntlFaxNo() {
		return this.mnIntlFaxNo;
	}
	
	/**
	 *
	 * @param String mnArctFaxNo
	 */
	public void setMnArctFaxNo(String mnArctFaxNo) {
		this.mnArctFaxNo = mnArctFaxNo;
	}
	
	/**
	 * 
	 * @return String mnArctFaxNo
	 */
	public String getMnArctFaxNo() {
		return this.mnArctFaxNo;
	}
	
	/**
	 *
	 * @param String mnFaxNo
	 */
	public void setMnFaxNo(String mnFaxNo) {
		this.mnFaxNo = mnFaxNo;
	}
	
	/**
	 * 
	 * @return String mnFaxNo
	 */
	public String getMnFaxNo() {
		return this.mnFaxNo;
	}
	
	/**
	 *
	 * @param String mnFullFaxNo
	 */
	public void setMnFullFaxNo(String mnFullFaxNo) {
		this.mnFullFaxNo = mnFullFaxNo;
	}
	
	/**
	 * 
	 * @return String mnFullFaxNo
	 */
	public String getMnFullFaxNo() {
		return this.mnFullFaxNo;
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
	 * @param String nvoccHjsScacCd
	 */
	public void setNvoccHjsScacCd(String nvoccHjsScacCd) {
		this.nvoccHjsScacCd = nvoccHjsScacCd;
	}
	
	/**
	 * 
	 * @return String nvoccHjsScacCd
	 */
	public String getNvoccHjsScacCd() {
		return this.nvoccHjsScacCd;
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
	 * @param String nvoccBdStrtEffDt
	 */
	public void setNvoccBdStrtEffDt(String nvoccBdStrtEffDt) {
		this.nvoccBdStrtEffDt = nvoccBdStrtEffDt;
	}
	
	/**
	 * 
	 * @return String nvoccBdStrtEffDt
	 */
	public String getNvoccBdStrtEffDt() {
		return this.nvoccBdStrtEffDt;
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
	 * @param String frtFwrdEffDt
	 */
	public void setFrtFwrdEffDt(String frtFwrdEffDt) {
		this.frtFwrdEffDt = frtFwrdEffDt;
	}
	
	/**
	 * 
	 * @return String frtFwrdEffDt
	 */
	public String getFrtFwrdEffDt() {
		return this.frtFwrdEffDt;
	}
	
	/**
	 *
	 * @param String fmcNoCd
	 */
	public void setFmcNoCd(String fmcNoCd) {
		this.fmcNoCd = fmcNoCd;
	}
	
	/**
	 * 
	 * @return String fmcNoCd
	 */
	public String getFmcNoCd() {
		return this.fmcNoCd;
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
	 * @param String cpetiDesc
	 */
	public void setCpetiDesc(String cpetiDesc) {
		this.cpetiDesc = cpetiDesc;
	}
	
	/**
	 * 
	 * @return String cpetiDesc
	 */
	public String getCpetiDesc() {
		return this.cpetiDesc;
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
	 * @param String prfRepreCmdtCd
	 */
	public void setPrfRepreCmdtCd(String prfRepreCmdtCd) {
		this.prfRepreCmdtCd = prfRepreCmdtCd;
	}
	
	/**
	 * 
	 * @return String prfRepreCmdtCd
	 */
	public String getPrfRepreCmdtCd() {
		return this.prfRepreCmdtCd;
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
	 * @param String bfrOfcId
	 */
	public void setBfrOfcId(String bfrOfcId) {
		this.bfrOfcId = bfrOfcId;
	}
	
	/**
	 * 
	 * @return String bfrOfcId
	 */
	public String getBfrOfcId() {
		return this.bfrOfcId;
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
	 * @param String bfrOfcChngDt
	 */
	public void setBfrOfcChngDt(String bfrOfcChngDt) {
		this.bfrOfcChngDt = bfrOfcChngDt;
	}
	
	/**
	 * 
	 * @return String bfrOfcChngDt
	 */
	public String getBfrOfcChngDt() {
		return this.bfrOfcChngDt;
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
	 * @param String oMstOfcId
	 */
	public void setOMstOfcId(String oMstOfcId) {
		this.oMstOfcId = oMstOfcId;
	}
	
	/**
	 * 
	 * @return String oMstOfcId
	 */
	public String getOMstOfcId() {
		return this.oMstOfcId;
	}
	
	/**
	 *
	 * @param String oOfcCd
	 */
	public void setOOfcCd(String oOfcCd) {
		this.oOfcCd = oOfcCd;
	}
	
	/**
	 * 
	 * @return String oOfcCd
	 */
	public String getOOfcCd() {
		return this.oOfcCd;
	}
	
	/**
	 *
	 * @param String rtnEml
	 */
	public void setRtnEml(String rtnEml) {
		this.rtnEml = rtnEml;
	}
	
	/**
	 * 
	 * @return String rtnEml
	 */
	public String getRtnEml() {
		return this.rtnEml;
	}
	
	/**
	 *
	 * @param String custAddrRowId
	 */
	public void setCustAddrRowId(String custAddrRowId) {
		this.custAddrRowId = custAddrRowId;
	}
	
	/**
	 * 
	 * @return String custAddrRowId
	 */
	public String getCustAddrRowId() {
		return this.custAddrRowId;
	}
	
	/**
	 *
	 * @param String custAddrStsCd
	 */
	public void setCustAddrStsCd(String custAddrStsCd) {
		this.custAddrStsCd = custAddrStsCd;
	}
	
	/**
	 * 
	 * @return String custAddrStsCd
	 */
	public String getCustAddrStsCd() {
		return this.custAddrStsCd;
	}
	
	/**
	 *
	 * @param String addrTpCd
	 */
	public void setAddrTpCd(String addrTpCd) {
		this.addrTpCd = addrTpCd;
	}
	
	/**
	 * 
	 * @return String addrTpCd
	 */
	public String getAddrTpCd() {
		return this.addrTpCd;
	}
	
	/**
	 *
	 * @param String prmryChkFlg
	 */
	public void setPrmryChkFlg(String prmryChkFlg) {
		this.prmryChkFlg = prmryChkFlg;
	}
	
	/**
	 * 
	 * @return String prmryChkFlg
	 */
	public String getPrmryChkFlg() {
		return this.prmryChkFlg;
	}
	
	/**
	 *
	 * @param String bzetAddr
	 */
	public void setBzetAddr(String bzetAddr) {
		this.bzetAddr = bzetAddr;
	}
	
	/**
	 * 
	 * @return String bzetAddr
	 */
	public String getBzetAddr() {
		return this.bzetAddr;
	}
	
	/**
	 *
	 * @param String ctyNm
	 */
	public void setCtyNm(String ctyNm) {
		this.ctyNm = ctyNm;
	}
	
	/**
	 * 
	 * @return String ctyNm
	 */
	public String getCtyNm() {
		return this.ctyNm;
	}
	
	/**
	 *
	 * @param String steCd
	 */
	public void setSteCd(String steCd) {
		this.steCd = steCd;
	}
	
	/**
	 * 
	 * @return String steCd
	 */
	public String getSteCd() {
		return this.steCd;
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
	 * @param String cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * 
	 * @return String cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 *
	 * @param String ssidiCoCd
	 */
	public void setSsidiCoCd(String ssidiCoCd) {
		this.ssidiCoCd = ssidiCoCd;
	}
	
	/**
	 * 
	 * @return String ssidiCoCd
	 */
	public String getSsidiCoCd() {
		return this.ssidiCoCd;
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
	 * @param String keyAcctStrtEffDt
	 */
	public void setKeyAcctStrtEffDt(String keyAcctStrtEffDt) {
		this.keyAcctStrtEffDt = keyAcctStrtEffDt;
	}
	
	/**
	 * 
	 * @return String keyAcctStrtEffDt
	 */
	public String getKeyAcctStrtEffDt() {
		return this.keyAcctStrtEffDt;
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
	 * @param String deltEffDt
	 */
	public void setDeltEffDt(String deltEffDt) {
		this.deltEffDt = deltEffDt;
	}
	
	/**
	 * 
	 * @return String deltEffDt
	 */
	public String getDeltEffDt() {
		return this.deltEffDt;
	}
	
	/**
	 *
	 * @param String slsDeltFlg
	 */
	public void setSlsDeltFlg(String slsDeltFlg) {
		this.slsDeltFlg = slsDeltFlg;
	}
	
	/**
	 * 
	 * @return String slsDeltFlg
	 */
	public String getSlsDeltFlg() {
		return this.slsDeltFlg;
	}
	
	/**
	 *
	 * @param String keyAcctMgrGloUsrId
	 */
	public void setKeyAcctMgrGloUsrId(String keyAcctMgrGloUsrId) {
		this.keyAcctMgrGloUsrId = keyAcctMgrGloUsrId;
	}
	
	/**
	 * 
	 * @return String keyAcctMgrGloUsrId
	 */
	public String getKeyAcctMgrGloUsrId() {
		return this.keyAcctMgrGloUsrId;
	}
	
	/**
	 *
	 * @param String keyAcctMgrGloUsrNm
	 */
	public void setKeyAcctMgrGloUsrNm(String keyAcctMgrGloUsrNm) {
		this.keyAcctMgrGloUsrNm = keyAcctMgrGloUsrNm;
	}
	
	/**
	 * 
	 * @return String keyAcctMgrGloUsrNm
	 */
	public String getKeyAcctMgrGloUsrNm() {
		return this.keyAcctMgrGloUsrNm;
	}
	
	/**
	 *
	 * @param String addrSeq
	 */
	public void setAddrSeq(String addrSeq) {
		this.addrSeq = addrSeq;
	}
	
	/**
	 * 
	 * @return String addrSeq
	 */
	public String getAddrSeq() {
		return this.addrSeq;
	}
	
	/**
	 *
	 * @param String subsCoFmDt
	 */
	public void setSubsCoFmDt(String subsCoFmDt) {
		this.subsCoFmDt = subsCoFmDt;
	}
	
	/**
	 * 
	 * @return String subsCoFmDt
	 */
	public String getSubsCoFmDt() {
		return this.subsCoFmDt;
	}
	
	/**
	 *
	 * @param String subsCoToDt
	 */
	public void setSubsCoToDt(String subsCoToDt) {
		this.subsCoToDt = subsCoToDt;
	}
	
	/**
	 * 
	 * @return String subsCoToDt
	 */
	public String getSubsCoToDt() {
		return this.subsCoToDt;
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
	 * @param String otiOrzNo
	 */
	public void setOtiOrzNo(String otiOrzNo) {
		this.otiOrzNo = otiOrzNo;
	}
	
	/**
	 * 
	 * @return String otiOrzNo
	 */
	public String getOtiOrzNo() {
		return this.otiOrzNo;
	}
	
	/**
	 *
	 * @param String rfAcctFlg
	 */
	public void setRfAcctFlg(String rfAcctFlg) {
		this.rfAcctFlg = rfAcctFlg;
	}
	
	/**
	 * 
	 * @return String rfAcctFlg
	 */
	public String getRfAcctFlg() {
		return this.rfAcctFlg;
	}
	
	/**
	 *
	 * @param String slsDeltEffRsnCd
	 */
	public void setSlsDeltEffRsnCd(String slsDeltEffRsnCd) {
		this.slsDeltEffRsnCd = slsDeltEffRsnCd;
	}
	
	/**
	 * 
	 * @return String slsDeltEffRsnCd
	 */
	public String getSlsDeltEffRsnCd() {
		return this.slsDeltEffRsnCd;
	}
	
	/**
	 *
	 * @param String newKeyAcctFlg
	 */
	public void setNewKeyAcctFlg(String newKeyAcctFlg) {
		this.newKeyAcctFlg = newKeyAcctFlg;
	}
	
	/**
	 * 
	 * @return String newKeyAcctFlg
	 */
	public String getNewKeyAcctFlg() {
		return this.newKeyAcctFlg;
	}
	
	/**
	 *
	 * @param String gloAcctFlg
	 */
	public void setGloAcctFlg(String gloAcctFlg) {
		this.gloAcctFlg = gloAcctFlg;
	}
	
	/**
	 * 
	 * @return String gloAcctFlg
	 */
	public String getGloAcctFlg() {
		return this.gloAcctFlg;
	}
	
	/**
	 *
	 * @param String rgnAcctFlg
	 */
	public void setRgnAcctFlg(String rgnAcctFlg) {
		this.rgnAcctFlg = rgnAcctFlg;
	}
	
	/**
	 * 
	 * @return String rgnAcctFlg
	 */
	public String getRgnAcctFlg() {
		return this.rgnAcctFlg;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setCntrDivFlg(JSPUtil.getParameter(request, prefix + "cntr_div_flg", ""));
		setBlkDivFlg(JSPUtil.getParameter(request, prefix + "blk_div_flg", ""));
		setCustGrpCd(JSPUtil.getParameter(request, prefix + "cust_grp_cd", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setCustLoclLangNm(JSPUtil.getParameter(request, prefix + "cust_locl_lang_nm", ""));
		setCustAbbrNm(JSPUtil.getParameter(request, prefix + "cust_abbr_nm", ""));
		setRvisCntrCustTpCd(JSPUtil.getParameter(request, prefix + "rvis_cntr_cust_tp_cd", ""));
		setBlkCustTpCd(JSPUtil.getParameter(request, prefix + "blk_cust_tp_cd", ""));
		setDmstFrgnDivCd(JSPUtil.getParameter(request, prefix + "dmst_frgn_div_cd", ""));
		setIndivCorpDivCd(JSPUtil.getParameter(request, prefix + "indiv_corp_div_cd", ""));
		setMstOfcId(JSPUtil.getParameter(request, prefix + "mst_ofc_id", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setBlkCntCd(JSPUtil.getParameter(request, prefix + "blk_cnt_cd", ""));
		setCustIp(JSPUtil.getParameter(request, prefix + "cust_ip", ""));
		setCustEml(JSPUtil.getParameter(request, prefix + "cust_eml", ""));
		setCustUrl(JSPUtil.getParameter(request, prefix + "cust_url", ""));
		setOwnrNm(JSPUtil.getParameter(request, prefix + "ownr_nm", ""));
		setBzctNm(JSPUtil.getParameter(request, prefix + "bzct_nm", ""));
		setBztpDesc(JSPUtil.getParameter(request, prefix + "bztp_desc", ""));
		setFndtDt(JSPUtil.getParameter(request, prefix + "fndt_dt", ""));
		setCustRgstNo(JSPUtil.getParameter(request, prefix + "cust_rgst_no", ""));
		setCustClssLvlCd(JSPUtil.getParameter(request, prefix + "cust_clss_lvl_cd", ""));
		setFincStsLvlCd(JSPUtil.getParameter(request, prefix + "finc_sts_lvl_cd", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setCapiCurrCd(JSPUtil.getParameter(request, prefix + "capi_curr_cd", ""));
		setCapiAmt(JSPUtil.getParameter(request, prefix + "capi_amt", ""));
		setSellCurrCd(JSPUtil.getParameter(request, prefix + "sell_curr_cd", ""));
		setSellAmt(JSPUtil.getParameter(request, prefix + "sell_amt", ""));
		setLstkFlg(JSPUtil.getParameter(request, prefix + "lstk_flg", ""));
		setEmpeKnt(JSPUtil.getParameter(request, prefix + "empe_knt", ""));
		setN1StBkgDt(JSPUtil.getParameter(request, prefix + "n1st_bkg_dt", ""));
		setN1StBkgNo(JSPUtil.getParameter(request, prefix + "n1st_bkg_no", ""));
		setN1StBkgNoSplit(JSPUtil.getParameter(request, prefix + "n1st_bkg_no_split", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setCustRmk(JSPUtil.getParameter(request, prefix + "cust_rmk", ""));
		setValBseSegmClssCd(JSPUtil.getParameter(request, prefix + "val_bse_segm_clss_cd", ""));
		setNdsBseSegmClssCd1(JSPUtil.getParameter(request, prefix + "nds_bse_segm_clss_cd1", ""));
		setNdsBseSegmClssCd2(JSPUtil.getParameter(request, prefix + "nds_bse_segm_clss_cd2", ""));
		setNdsBseSegmClssCd3(JSPUtil.getParameter(request, prefix + "nds_bse_segm_clss_cd3", ""));
		setMnIntlPhnNo(JSPUtil.getParameter(request, prefix + "mn_intl_phn_no", ""));
		setMnArctPnnNo(JSPUtil.getParameter(request, prefix + "mn_arct_pnn_no", ""));
		setMnPhnNo(JSPUtil.getParameter(request, prefix + "mn_phn_no", ""));
		setMnFullPhnNo(JSPUtil.getParameter(request, prefix + "mn_full_phn_no", ""));
		setMnIntlFaxNo(JSPUtil.getParameter(request, prefix + "mn_intl_fax_no", ""));
		setMnArctFaxNo(JSPUtil.getParameter(request, prefix + "mn_arct_fax_no", ""));
		setMnFaxNo(JSPUtil.getParameter(request, prefix + "mn_fax_no", ""));
		setMnFullFaxNo(JSPUtil.getParameter(request, prefix + "mn_full_fax_no", ""));
		setCustStsCd(JSPUtil.getParameter(request, prefix + "cust_sts_cd", ""));
		setCrmRowId(JSPUtil.getParameter(request, prefix + "crm_row_id", ""));
		setNvoccHjsScacCd(JSPUtil.getParameter(request, prefix + "nvocc_hjs_scac_cd", ""));
		setNvoccBdNo(JSPUtil.getParameter(request, prefix + "nvocc_bd_no", ""));
		setNvoccLicNo(JSPUtil.getParameter(request, prefix + "nvocc_lic_no", ""));
		setNvoccBdAmt(JSPUtil.getParameter(request, prefix + "nvocc_bd_amt", ""));
		setNvoccBdStrtEffDt(JSPUtil.getParameter(request, prefix + "nvocc_bd_strt_eff_dt", ""));
		setNvoccBdEndEffDt(JSPUtil.getParameter(request, prefix + "nvocc_bd_end_eff_dt", ""));
		setFrtFwrdFmcNo(JSPUtil.getParameter(request, prefix + "frt_fwrd_fmc_no", ""));
		setFrtFwrdEffDt(JSPUtil.getParameter(request, prefix + "frt_fwrd_eff_dt", ""));
		setFmcNoCd(JSPUtil.getParameter(request, prefix + "fmc_no_cd", ""));
		setIndusDesc(JSPUtil.getParameter(request, prefix + "indus_desc", ""));
		setCrntVolKnt(JSPUtil.getParameter(request, prefix + "crnt_vol_knt", ""));
		setCpetiDesc(JSPUtil.getParameter(request, prefix + "cpeti_desc", ""));
		setSpclReqDesc(JSPUtil.getParameter(request, prefix + "spcl_req_desc", ""));
		setPrfSvcDesc(JSPUtil.getParameter(request, prefix + "prf_svc_desc", ""));
		setPrfSvcDtlDesc(JSPUtil.getParameter(request, prefix + "prf_svc_dtl_desc", ""));
		setPrfGrpCmdtCd(JSPUtil.getParameter(request, prefix + "prf_grp_cmdt_cd", ""));
		setPrfRepreCmdtCd(JSPUtil.getParameter(request, prefix + "prf_repre_cmdt_cd", ""));
		setPrfCntrTpszCd(JSPUtil.getParameter(request, prefix + "prf_cntr_tpsz_cd", ""));
		setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
		setCtsNo(JSPUtil.getParameter(request, prefix + "cts_no", ""));
		setBfrOfcId(JSPUtil.getParameter(request, prefix + "bfr_ofc_id", ""));
		setBfrOfcCd(JSPUtil.getParameter(request, prefix + "bfr_ofc_cd", ""));
		setBfrOfcChngDt(JSPUtil.getParameter(request, prefix + "bfr_ofc_chng_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setModiCustCntCd(JSPUtil.getParameter(request, prefix + "modi_cust_cnt_cd", ""));
		setModiCustSeq(JSPUtil.getParameter(request, prefix + "modi_cust_seq", ""));
		setOMstOfcId(JSPUtil.getParameter(request, prefix + "o_mst_ofc_id", ""));
		setOOfcCd(JSPUtil.getParameter(request, prefix + "o_ofc_cd", ""));
		setRtnEml(JSPUtil.getParameter(request, prefix + "rtn_eml", ""));
		setCustAddrRowId(JSPUtil.getParameter(request, prefix + "cust_addr_row_id", ""));
		setCustAddrStsCd(JSPUtil.getParameter(request, prefix + "cust_addr_sts_cd", ""));
		setAddrTpCd(JSPUtil.getParameter(request, prefix + "addr_tp_cd", ""));
		setPrmryChkFlg(JSPUtil.getParameter(request, prefix + "prmry_chk_flg", ""));
		setBzetAddr(JSPUtil.getParameter(request, prefix + "bzet_addr", ""));
		setCtyNm(JSPUtil.getParameter(request, prefix + "cty_nm", ""));
		setSteCd(JSPUtil.getParameter(request, prefix + "ste_cd", ""));
		setZipCd(JSPUtil.getParameter(request, prefix + "zip_cd", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setSsidiCoCd(JSPUtil.getParameter(request, prefix + "ssidi_co_cd", ""));
		setKeyAcctFlg(JSPUtil.getParameter(request, prefix + "key_acct_flg", ""));
		setKeyAcctStrtEffDt(JSPUtil.getParameter(request, prefix + "key_acct_strt_eff_dt", ""));
		setKeyAcctEndEffDt(JSPUtil.getParameter(request, prefix + "key_acct_end_eff_dt", ""));
		setDeltEffDt(JSPUtil.getParameter(request, prefix + "delt_eff_dt", ""));
		setSlsDeltFlg(JSPUtil.getParameter(request, prefix + "sls_delt_flg", ""));
		setKeyAcctMgrGloUsrId(JSPUtil.getParameter(request, prefix + "key_acct_mgr_glo_usr_id", ""));
		setKeyAcctMgrGloUsrNm(JSPUtil.getParameter(request, prefix + "key_acct_mgr_glo_usr_nm", ""));
		setAddrSeq(JSPUtil.getParameter(request, prefix + "addr_seq", ""));
		setSubsCoFmDt(JSPUtil.getParameter(request, prefix + "subs_co_fm_dt", ""));
		setSubsCoToDt(JSPUtil.getParameter(request, prefix + "subs_co_to_dt", ""));
		setBkgAltRsn(JSPUtil.getParameter(request, prefix + "bkg_alt_rsn", ""));
		setBkgAltFmDt(JSPUtil.getParameter(request, prefix + "bkg_alt_fm_dt", ""));
		setBkgAltToDt(JSPUtil.getParameter(request, prefix + "bkg_alt_to_dt", ""));
		setBkgAltMsg(JSPUtil.getParameter(request, prefix + "bkg_alt_msg", ""));
		setBkgAltCreUsrId(JSPUtil.getParameter(request, prefix + "bkg_alt_cre_usr_id", ""));
		setBkgAltCreDt(JSPUtil.getParameter(request, prefix + "bkg_alt_cre_dt", ""));
		setNmdCustFlg(JSPUtil.getParameter(request, prefix + "nmd_cust_flg", ""));
		setMltTrdAcctFlg(JSPUtil.getParameter(request, prefix + "mlt_trd_acct_flg", ""));
		setOtiOrzNo(JSPUtil.getParameter(request, prefix + "oti_orz_no", ""));
		setRfAcctFlg(JSPUtil.getParameter(request, prefix + "rf_acct_flg", ""));
		setSlsDeltEffRsnCd(JSPUtil.getParameter(request, prefix + "sls_delt_eff_rsn_cd", ""));
		setNewKeyAcctFlg(JSPUtil.getParameter(request, prefix + "new_key_acct_flg", ""));
		setGloAcctFlg(JSPUtil.getParameter(request, prefix + "glo_acct_flg", ""));
		setRgnAcctFlg(JSPUtil.getParameter(request, prefix + "rgn_acct_flg", ""));
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
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] cntrDivFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_div_flg", length));
			String[] blkDivFlg = (JSPUtil.getParameter(request, prefix	+ "blk_div_flg", length));
			String[] custGrpCd = (JSPUtil.getParameter(request, prefix	+ "cust_grp_cd", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] custLoclLangNm = (JSPUtil.getParameter(request, prefix	+ "cust_locl_lang_nm", length));
			String[] custAbbrNm = (JSPUtil.getParameter(request, prefix	+ "cust_abbr_nm", length));
			String[] rvisCntrCustTpCd = (JSPUtil.getParameter(request, prefix	+ "rvis_cntr_cust_tp_cd", length));
			String[] blkCustTpCd = (JSPUtil.getParameter(request, prefix	+ "blk_cust_tp_cd", length));
			String[] dmstFrgnDivCd = (JSPUtil.getParameter(request, prefix	+ "dmst_frgn_div_cd", length));
			String[] indivCorpDivCd = (JSPUtil.getParameter(request, prefix	+ "indiv_corp_div_cd", length));
			String[] mstOfcId = (JSPUtil.getParameter(request, prefix	+ "mst_ofc_id", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] blkCntCd = (JSPUtil.getParameter(request, prefix	+ "blk_cnt_cd", length));
			String[] custIp = (JSPUtil.getParameter(request, prefix	+ "cust_ip", length));
			String[] custEml = (JSPUtil.getParameter(request, prefix	+ "cust_eml", length));
			String[] custUrl = (JSPUtil.getParameter(request, prefix	+ "cust_url", length));
			String[] ownrNm = (JSPUtil.getParameter(request, prefix	+ "ownr_nm", length));
			String[] bzctNm = (JSPUtil.getParameter(request, prefix	+ "bzct_nm", length));
			String[] bztpDesc = (JSPUtil.getParameter(request, prefix	+ "bztp_desc", length));
			String[] fndtDt = (JSPUtil.getParameter(request, prefix	+ "fndt_dt", length));
			String[] custRgstNo = (JSPUtil.getParameter(request, prefix	+ "cust_rgst_no", length));
			String[] custClssLvlCd = (JSPUtil.getParameter(request, prefix	+ "cust_clss_lvl_cd", length));
			String[] fincStsLvlCd = (JSPUtil.getParameter(request, prefix	+ "finc_sts_lvl_cd", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] capiCurrCd = (JSPUtil.getParameter(request, prefix	+ "capi_curr_cd", length));
			String[] capiAmt = (JSPUtil.getParameter(request, prefix	+ "capi_amt", length));
			String[] sellCurrCd = (JSPUtil.getParameter(request, prefix	+ "sell_curr_cd", length));
			String[] sellAmt = (JSPUtil.getParameter(request, prefix	+ "sell_amt", length));
			String[] lstkFlg = (JSPUtil.getParameter(request, prefix	+ "lstk_flg", length));
			String[] empeKnt = (JSPUtil.getParameter(request, prefix	+ "empe_knt", length));
			String[] n1StBkgDt = (JSPUtil.getParameter(request, prefix	+ "n1st_bkg_dt", length));
			String[] n1StBkgNo = (JSPUtil.getParameter(request, prefix	+ "n1st_bkg_no", length));
			String[] n1StBkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "n1st_bkg_no_split", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] custRmk = (JSPUtil.getParameter(request, prefix	+ "cust_rmk", length));
			String[] valBseSegmClssCd = (JSPUtil.getParameter(request, prefix	+ "val_bse_segm_clss_cd", length));
			String[] ndsBseSegmClssCd1 = (JSPUtil.getParameter(request, prefix	+ "nds_bse_segm_clss_cd1", length));
			String[] ndsBseSegmClssCd2 = (JSPUtil.getParameter(request, prefix	+ "nds_bse_segm_clss_cd2", length));
			String[] ndsBseSegmClssCd3 = (JSPUtil.getParameter(request, prefix	+ "nds_bse_segm_clss_cd3", length));
			String[] mnIntlPhnNo = (JSPUtil.getParameter(request, prefix	+ "mn_intl_phn_no", length));
			String[] mnArctPnnNo = (JSPUtil.getParameter(request, prefix	+ "mn_arct_pnn_no", length));
			String[] mnPhnNo = (JSPUtil.getParameter(request, prefix	+ "mn_phn_no", length));
			String[] mnFullPhnNo = (JSPUtil.getParameter(request, prefix	+ "mn_full_phn_no", length));
			String[] mnIntlFaxNo = (JSPUtil.getParameter(request, prefix	+ "mn_intl_fax_no", length));
			String[] mnArctFaxNo = (JSPUtil.getParameter(request, prefix	+ "mn_arct_fax_no", length));
			String[] mnFaxNo = (JSPUtil.getParameter(request, prefix	+ "mn_fax_no", length));
			String[] mnFullFaxNo = (JSPUtil.getParameter(request, prefix	+ "mn_full_fax_no", length));
			String[] custStsCd = (JSPUtil.getParameter(request, prefix	+ "cust_sts_cd", length));
			String[] crmRowId = (JSPUtil.getParameter(request, prefix	+ "crm_row_id", length));
			String[] nvoccHjsScacCd = (JSPUtil.getParameter(request, prefix	+ "nvocc_hjs_scac_cd", length));
			String[] nvoccBdNo = (JSPUtil.getParameter(request, prefix	+ "nvocc_bd_no", length));
			String[] nvoccLicNo = (JSPUtil.getParameter(request, prefix	+ "nvocc_lic_no", length));
			String[] nvoccBdAmt = (JSPUtil.getParameter(request, prefix	+ "nvocc_bd_amt", length));
			String[] nvoccBdStrtEffDt = (JSPUtil.getParameter(request, prefix	+ "nvocc_bd_strt_eff_dt", length));
			String[] nvoccBdEndEffDt = (JSPUtil.getParameter(request, prefix	+ "nvocc_bd_end_eff_dt", length));
			String[] frtFwrdFmcNo = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_fmc_no", length));
			String[] frtFwrdEffDt = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_eff_dt", length));
			String[] fmcNoCd = (JSPUtil.getParameter(request, prefix	+ "fmc_no_cd", length));
			String[] indusDesc = (JSPUtil.getParameter(request, prefix	+ "indus_desc", length));
			String[] crntVolKnt = (JSPUtil.getParameter(request, prefix	+ "crnt_vol_knt", length));
			String[] cpetiDesc = (JSPUtil.getParameter(request, prefix	+ "cpeti_desc", length));
			String[] spclReqDesc = (JSPUtil.getParameter(request, prefix	+ "spcl_req_desc", length));
			String[] prfSvcDesc = (JSPUtil.getParameter(request, prefix	+ "prf_svc_desc", length));
			String[] prfSvcDtlDesc = (JSPUtil.getParameter(request, prefix	+ "prf_svc_dtl_desc", length));
			String[] prfGrpCmdtCd = (JSPUtil.getParameter(request, prefix	+ "prf_grp_cmdt_cd", length));
			String[] prfRepreCmdtCd = (JSPUtil.getParameter(request, prefix	+ "prf_repre_cmdt_cd", length));
			String[] prfCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "prf_cntr_tpsz_cd", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] ctsNo = (JSPUtil.getParameter(request, prefix	+ "cts_no", length));
			String[] bfrOfcId = (JSPUtil.getParameter(request, prefix	+ "bfr_ofc_id", length));
			String[] bfrOfcCd = (JSPUtil.getParameter(request, prefix	+ "bfr_ofc_cd", length));
			String[] bfrOfcChngDt = (JSPUtil.getParameter(request, prefix	+ "bfr_ofc_chng_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] modiCustCntCd = (JSPUtil.getParameter(request, prefix	+ "modi_cust_cnt_cd", length));
			String[] modiCustSeq = (JSPUtil.getParameter(request, prefix	+ "modi_cust_seq", length));
			String[] oMstOfcId = (JSPUtil.getParameter(request, prefix	+ "o_mst_ofc_id", length));
			String[] oOfcCd = (JSPUtil.getParameter(request, prefix	+ "o_ofc_cd", length));
			String[] rtnEml = (JSPUtil.getParameter(request, prefix	+ "rtn_eml", length));
			String[] custAddrRowId = (JSPUtil.getParameter(request, prefix	+ "cust_addr_row_id", length));
			String[] custAddrStsCd = (JSPUtil.getParameter(request, prefix	+ "cust_addr_sts_cd", length));
			String[] addrTpCd = (JSPUtil.getParameter(request, prefix	+ "addr_tp_cd", length));
			String[] prmryChkFlg = (JSPUtil.getParameter(request, prefix	+ "prmry_chk_flg", length));
			String[] bzetAddr = (JSPUtil.getParameter(request, prefix	+ "bzet_addr", length));
			String[] ctyNm = (JSPUtil.getParameter(request, prefix	+ "cty_nm", length));
			String[] steCd = (JSPUtil.getParameter(request, prefix	+ "ste_cd", length));
			String[] zipCd = (JSPUtil.getParameter(request, prefix	+ "zip_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] ssidiCoCd = (JSPUtil.getParameter(request, prefix	+ "ssidi_co_cd", length));
			String[] keyAcctFlg = (JSPUtil.getParameter(request, prefix	+ "key_acct_flg", length));
			String[] keyAcctStrtEffDt = (JSPUtil.getParameter(request, prefix	+ "key_acct_strt_eff_dt", length));
			String[] keyAcctEndEffDt = (JSPUtil.getParameter(request, prefix	+ "key_acct_end_eff_dt", length));
			String[] deltEffDt = (JSPUtil.getParameter(request, prefix	+ "delt_eff_dt", length));
			String[] slsDeltFlg = (JSPUtil.getParameter(request, prefix	+ "sls_delt_flg", length));
			String[] keyAcctMgrGloUsrId = (JSPUtil.getParameter(request, prefix	+ "key_acct_mgr_glo_usr_id", length));
			String[] keyAcctMgrGloUsrNm = (JSPUtil.getParameter(request, prefix	+ "key_acct_mgr_glo_usr_nm", length));
			String[] addrSeq = (JSPUtil.getParameter(request, prefix	+ "addr_seq", length));
			String[] subsCoFmDt = (JSPUtil.getParameter(request, prefix	+ "subs_co_fm_dt", length));
			String[] subsCoToDt = (JSPUtil.getParameter(request, prefix	+ "subs_co_to_dt", length));
			String[] bkgAltRsn = (JSPUtil.getParameter(request, prefix	+ "bkg_alt_rsn", length));
			String[] bkgAltFmDt = (JSPUtil.getParameter(request, prefix	+ "bkg_alt_fm_dt", length));
			String[] bkgAltToDt = (JSPUtil.getParameter(request, prefix	+ "bkg_alt_to_dt", length));
			String[] bkgAltMsg = (JSPUtil.getParameter(request, prefix	+ "bkg_alt_msg", length));
			String[] bkgAltCreUsrId = (JSPUtil.getParameter(request, prefix	+ "bkg_alt_cre_usr_id", length));
			String[] bkgAltCreDt = (JSPUtil.getParameter(request, prefix	+ "bkg_alt_cre_dt", length));
			String[] nmdCustFlg = (JSPUtil.getParameter(request, prefix	+ "nmd_cust_flg", length));
			String[] mltTrdAcctFlg = (JSPUtil.getParameter(request, prefix	+ "mlt_trd_acct_flg", length));
			String[] otiOrzNo = (JSPUtil.getParameter(request, prefix	+ "oti_orz_no", length));
			String[] rfAcctFlg = (JSPUtil.getParameter(request, prefix	+ "rf_acct_flg", length));
			String[] slsDeltEffRsnCd = (JSPUtil.getParameter(request, prefix	+ "sls_delt_eff_rsn_cd", length));
			String[] newKeyAcctFlg = (JSPUtil.getParameter(request, prefix	+ "new_key_acct_flg", length));
			String[] gloAcctFlg = (JSPUtil.getParameter(request, prefix	+ "glo_acct_flg", length));
			String[] rgnAcctFlg = (JSPUtil.getParameter(request, prefix	+ "rgn_acct_flg", length));
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
				if (cntrDivFlg[i] != null) 
					model.setCntrDivFlg(cntrDivFlg[i]);
				if (blkDivFlg[i] != null) 
					model.setBlkDivFlg(blkDivFlg[i]);
				if (custGrpCd[i] != null) 
					model.setCustGrpCd(custGrpCd[i]);
				if (custLglEngNm[i] != null) 
					model.setCustLglEngNm(custLglEngNm[i]);
				if (custLoclLangNm[i] != null) 
					model.setCustLoclLangNm(custLoclLangNm[i]);
				if (custAbbrNm[i] != null) 
					model.setCustAbbrNm(custAbbrNm[i]);
				if (rvisCntrCustTpCd[i] != null) 
					model.setRvisCntrCustTpCd(rvisCntrCustTpCd[i]);
				if (blkCustTpCd[i] != null) 
					model.setBlkCustTpCd(blkCustTpCd[i]);
				if (dmstFrgnDivCd[i] != null) 
					model.setDmstFrgnDivCd(dmstFrgnDivCd[i]);
				if (indivCorpDivCd[i] != null) 
					model.setIndivCorpDivCd(indivCorpDivCd[i]);
				if (mstOfcId[i] != null) 
					model.setMstOfcId(mstOfcId[i]);
				if (ofcCd[i] != null) 
					model.setOfcCd(ofcCd[i]);
				if (blkCntCd[i] != null) 
					model.setBlkCntCd(blkCntCd[i]);
				if (custIp[i] != null) 
					model.setCustIp(custIp[i]);
				if (custEml[i] != null) 
					model.setCustEml(custEml[i]);
				if (custUrl[i] != null) 
					model.setCustUrl(custUrl[i]);
				if (ownrNm[i] != null) 
					model.setOwnrNm(ownrNm[i]);
				if (bzctNm[i] != null) 
					model.setBzctNm(bzctNm[i]);
				if (bztpDesc[i] != null) 
					model.setBztpDesc(bztpDesc[i]);
				if (fndtDt[i] != null) 
					model.setFndtDt(fndtDt[i]);
				if (custRgstNo[i] != null) 
					model.setCustRgstNo(custRgstNo[i]);
				if (custClssLvlCd[i] != null) 
					model.setCustClssLvlCd(custClssLvlCd[i]);
				if (fincStsLvlCd[i] != null) 
					model.setFincStsLvlCd(fincStsLvlCd[i]);
				if (locCd[i] != null) 
					model.setLocCd(locCd[i]);
				if (capiCurrCd[i] != null) 
					model.setCapiCurrCd(capiCurrCd[i]);
				if (capiAmt[i] != null) 
					model.setCapiAmt(capiAmt[i]);
				if (sellCurrCd[i] != null) 
					model.setSellCurrCd(sellCurrCd[i]);
				if (sellAmt[i] != null) 
					model.setSellAmt(sellAmt[i]);
				if (lstkFlg[i] != null) 
					model.setLstkFlg(lstkFlg[i]);
				if (empeKnt[i] != null) 
					model.setEmpeKnt(empeKnt[i]);
				if (n1StBkgDt[i] != null) 
					model.setN1StBkgDt(n1StBkgDt[i]);
				if (n1StBkgNo[i] != null) 
					model.setN1StBkgNo(n1StBkgNo[i]);
				if (n1StBkgNoSplit[i] != null) 
					model.setN1StBkgNoSplit(n1StBkgNoSplit[i]);
				if (vndrSeq[i] != null) 
					model.setVndrSeq(vndrSeq[i]);
				if (custRmk[i] != null) 
					model.setCustRmk(custRmk[i]);
				if (valBseSegmClssCd[i] != null) 
					model.setValBseSegmClssCd(valBseSegmClssCd[i]);
				if (ndsBseSegmClssCd1[i] != null) 
					model.setNdsBseSegmClssCd1(ndsBseSegmClssCd1[i]);
				if (ndsBseSegmClssCd2[i] != null) 
					model.setNdsBseSegmClssCd2(ndsBseSegmClssCd2[i]);
				if (ndsBseSegmClssCd3[i] != null) 
					model.setNdsBseSegmClssCd3(ndsBseSegmClssCd3[i]);
				if (mnIntlPhnNo[i] != null) 
					model.setMnIntlPhnNo(mnIntlPhnNo[i]);
				if (mnArctPnnNo[i] != null) 
					model.setMnArctPnnNo(mnArctPnnNo[i]);
				if (mnPhnNo[i] != null) 
					model.setMnPhnNo(mnPhnNo[i]);
				if (mnFullPhnNo[i] != null) 
					model.setMnFullPhnNo(mnFullPhnNo[i]);
				if (mnIntlFaxNo[i] != null) 
					model.setMnIntlFaxNo(mnIntlFaxNo[i]);
				if (mnArctFaxNo[i] != null) 
					model.setMnArctFaxNo(mnArctFaxNo[i]);
				if (mnFaxNo[i] != null) 
					model.setMnFaxNo(mnFaxNo[i]);
				if (mnFullFaxNo[i] != null) 
					model.setMnFullFaxNo(mnFullFaxNo[i]);
				if (custStsCd[i] != null) 
					model.setCustStsCd(custStsCd[i]);
				if (crmRowId[i] != null) 
					model.setCrmRowId(crmRowId[i]);
				if (nvoccHjsScacCd[i] != null) 
					model.setNvoccHjsScacCd(nvoccHjsScacCd[i]);
				if (nvoccBdNo[i] != null) 
					model.setNvoccBdNo(nvoccBdNo[i]);
				if (nvoccLicNo[i] != null) 
					model.setNvoccLicNo(nvoccLicNo[i]);
				if (nvoccBdAmt[i] != null) 
					model.setNvoccBdAmt(nvoccBdAmt[i]);
				if (nvoccBdStrtEffDt[i] != null) 
					model.setNvoccBdStrtEffDt(nvoccBdStrtEffDt[i]);
				if (nvoccBdEndEffDt[i] != null) 
					model.setNvoccBdEndEffDt(nvoccBdEndEffDt[i]);
				if (frtFwrdFmcNo[i] != null) 
					model.setFrtFwrdFmcNo(frtFwrdFmcNo[i]);
				if (frtFwrdEffDt[i] != null) 
					model.setFrtFwrdEffDt(frtFwrdEffDt[i]);
				if (fmcNoCd[i] != null) 
					model.setFmcNoCd(fmcNoCd[i]);
				if (indusDesc[i] != null) 
					model.setIndusDesc(indusDesc[i]);
				if (crntVolKnt[i] != null) 
					model.setCrntVolKnt(crntVolKnt[i]);
				if (cpetiDesc[i] != null) 
					model.setCpetiDesc(cpetiDesc[i]);
				if (spclReqDesc[i] != null) 
					model.setSpclReqDesc(spclReqDesc[i]);
				if (prfSvcDesc[i] != null) 
					model.setPrfSvcDesc(prfSvcDesc[i]);
				if (prfSvcDtlDesc[i] != null) 
					model.setPrfSvcDtlDesc(prfSvcDtlDesc[i]);
				if (prfGrpCmdtCd[i] != null) 
					model.setPrfGrpCmdtCd(prfGrpCmdtCd[i]);
				if (prfRepreCmdtCd[i] != null) 
					model.setPrfRepreCmdtCd(prfRepreCmdtCd[i]);
				if (prfCntrTpszCd[i] != null) 
					model.setPrfCntrTpszCd(prfCntrTpszCd[i]);
				if (srepCd[i] != null) 
					model.setSrepCd(srepCd[i]);
				if (ctsNo[i] != null) 
					model.setCtsNo(ctsNo[i]);
				if (bfrOfcId[i] != null) 
					model.setBfrOfcId(bfrOfcId[i]);
				if (bfrOfcCd[i] != null) 
					model.setBfrOfcCd(bfrOfcCd[i]);
				if (bfrOfcChngDt[i] != null) 
					model.setBfrOfcChngDt(bfrOfcChngDt[i]);
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
				if (modiCustCntCd[i] != null) 
					model.setModiCustCntCd(modiCustCntCd[i]);
				if (modiCustSeq[i] != null) 
					model.setModiCustSeq(modiCustSeq[i]);
				if (oMstOfcId[i] != null) 
					model.setOMstOfcId(oMstOfcId[i]);
				if (oOfcCd[i] != null) 
					model.setOOfcCd(oOfcCd[i]);
				if (rtnEml[i] != null) 
					model.setRtnEml(rtnEml[i]);
				if (custAddrRowId[i] != null) 
					model.setCustAddrRowId(custAddrRowId[i]);
				if (custAddrStsCd[i] != null) 
					model.setCustAddrStsCd(custAddrStsCd[i]);
				if (addrTpCd[i] != null) 
					model.setAddrTpCd(addrTpCd[i]);
				if (prmryChkFlg[i] != null) 
					model.setPrmryChkFlg(prmryChkFlg[i]);
				if (bzetAddr[i] != null) 
					model.setBzetAddr(bzetAddr[i]);
				if (ctyNm[i] != null) 
					model.setCtyNm(ctyNm[i]);
				if (steCd[i] != null) 
					model.setSteCd(steCd[i]);
				if (zipCd[i] != null) 
					model.setZipCd(zipCd[i]);
				if (cntCd[i] != null) 
					model.setCntCd(cntCd[i]);
				if (ssidiCoCd[i] != null) 
					model.setSsidiCoCd(ssidiCoCd[i]);
				if (keyAcctFlg[i] != null) 
					model.setKeyAcctFlg(keyAcctFlg[i]);
				if (keyAcctStrtEffDt[i] != null) 
					model.setKeyAcctStrtEffDt(keyAcctStrtEffDt[i]);
				if (keyAcctEndEffDt[i] != null) 
					model.setKeyAcctEndEffDt(keyAcctEndEffDt[i]);
				if (deltEffDt[i] != null) 
					model.setDeltEffDt(deltEffDt[i]);
				if (slsDeltFlg[i] != null) 
					model.setSlsDeltFlg(slsDeltFlg[i]);
				if (keyAcctMgrGloUsrId[i] != null) 
					model.setKeyAcctMgrGloUsrId(keyAcctMgrGloUsrId[i]);
				if (keyAcctMgrGloUsrNm[i] != null) 
					model.setKeyAcctMgrGloUsrNm(keyAcctMgrGloUsrNm[i]);
				if (addrSeq[i] != null) 
					model.setAddrSeq(addrSeq[i]);
				if (subsCoFmDt[i] != null) 
					model.setSubsCoFmDt(subsCoFmDt[i]);
				if (subsCoToDt[i] != null) 
					model.setSubsCoToDt(subsCoToDt[i]);
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
				if (nmdCustFlg[i] != null) 
					model.setNmdCustFlg(nmdCustFlg[i]);
				if (mltTrdAcctFlg[i] != null) 
					model.setMltTrdAcctFlg(mltTrdAcctFlg[i]);
				if (otiOrzNo[i] != null) 
					model.setOtiOrzNo(otiOrzNo[i]);
				if (rfAcctFlg[i] != null) 
					model.setRfAcctFlg(rfAcctFlg[i]);
				if (slsDeltEffRsnCd[i] != null) 
					model.setSlsDeltEffRsnCd(slsDeltEffRsnCd[i]);
				if (newKeyAcctFlg[i] != null) 
					model.setNewKeyAcctFlg(newKeyAcctFlg[i]);
				if (gloAcctFlg[i] != null) 
					model.setGloAcctFlg(gloAcctFlg[i]);
				if (rgnAcctFlg[i] != null) 
					model.setRgnAcctFlg(rgnAcctFlg[i]);
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
	public CustomerIfVO[] getCustomerIfVOs(){
		CustomerIfVO[] vos = (CustomerIfVO[])models.toArray(new CustomerIfVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDivFlg = this.cntrDivFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkDivFlg = this.blkDivFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpCd = this.custGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLoclLangNm = this.custLoclLangNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAbbrNm = this.custAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisCntrCustTpCd = this.rvisCntrCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkCustTpCd = this.blkCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmstFrgnDivCd = this.dmstFrgnDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.indivCorpDivCd = this.indivCorpDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstOfcId = this.mstOfcId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkCntCd = this.blkCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custIp = this.custIp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEml = this.custEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custUrl = this.custUrl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrNm = this.ownrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzctNm = this.bzctNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bztpDesc = this.bztpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fndtDt = this.fndtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRgstNo = this.custRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custClssLvlCd = this.custClssLvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincStsLvlCd = this.fincStsLvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.capiCurrCd = this.capiCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.capiAmt = this.capiAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sellCurrCd = this.sellCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sellAmt = this.sellAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstkFlg = this.lstkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.empeKnt = this.empeKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1StBkgDt = this.n1StBkgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1StBkgNo = this.n1StBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1StBkgNoSplit = this.n1StBkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRmk = this.custRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valBseSegmClssCd = this.valBseSegmClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ndsBseSegmClssCd1 = this.ndsBseSegmClssCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ndsBseSegmClssCd2 = this.ndsBseSegmClssCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ndsBseSegmClssCd3 = this.ndsBseSegmClssCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnIntlPhnNo = this.mnIntlPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnArctPnnNo = this.mnArctPnnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnPhnNo = this.mnPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnFullPhnNo = this.mnFullPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnIntlFaxNo = this.mnIntlFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnArctFaxNo = this.mnArctFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnFaxNo = this.mnFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnFullFaxNo = this.mnFullFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custStsCd = this.custStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crmRowId = this.crmRowId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvoccHjsScacCd = this.nvoccHjsScacCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvoccBdNo = this.nvoccBdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvoccLicNo = this.nvoccLicNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvoccBdAmt = this.nvoccBdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvoccBdStrtEffDt = this.nvoccBdStrtEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvoccBdEndEffDt = this.nvoccBdEndEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdFmcNo = this.frtFwrdFmcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdEffDt = this.frtFwrdEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmcNoCd = this.fmcNoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.indusDesc = this.indusDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntVolKnt = this.crntVolKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cpetiDesc = this.cpetiDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclReqDesc = this.spclReqDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prfSvcDesc = this.prfSvcDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prfSvcDtlDesc = this.prfSvcDtlDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prfGrpCmdtCd = this.prfGrpCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prfRepreCmdtCd = this.prfRepreCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prfCntrTpszCd = this.prfCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctsNo = this.ctsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrOfcId = this.bfrOfcId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrOfcCd = this.bfrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrOfcChngDt = this.bfrOfcChngDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiCustCntCd = this.modiCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiCustSeq = this.modiCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oMstOfcId = this.oMstOfcId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oOfcCd = this.oOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnEml = this.rtnEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddrRowId = this.custAddrRowId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddrStsCd = this.custAddrStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addrTpCd = this.addrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prmryChkFlg = this.prmryChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzetAddr = this.bzetAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctyNm = this.ctyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCd = this.steCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zipCd = this.zipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ssidiCoCd = this.ssidiCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyAcctFlg = this.keyAcctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyAcctStrtEffDt = this.keyAcctStrtEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyAcctEndEffDt = this.keyAcctEndEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltEffDt = this.deltEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsDeltFlg = this.slsDeltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyAcctMgrGloUsrId = this.keyAcctMgrGloUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyAcctMgrGloUsrNm = this.keyAcctMgrGloUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addrSeq = this.addrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subsCoFmDt = this.subsCoFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subsCoToDt = this.subsCoToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAltRsn = this.bkgAltRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAltFmDt = this.bkgAltFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAltToDt = this.bkgAltToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAltMsg = this.bkgAltMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAltCreUsrId = this.bkgAltCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAltCreDt = this.bkgAltCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nmdCustFlg = this.nmdCustFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mltTrdAcctFlg = this.mltTrdAcctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otiOrzNo = this.otiOrzNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfAcctFlg = this.rfAcctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsDeltEffRsnCd = this.slsDeltEffRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newKeyAcctFlg = this.newKeyAcctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAcctFlg = this.gloAcctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnAcctFlg = this.rgnAcctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}