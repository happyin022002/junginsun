/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchCustomerVO.java
*@FileTitle : SearchCustomerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.01
*@LastModifier : 이창원
*@LastVersion : 1.0
* 2011.06.01 이창원 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이창원
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchCustomerGrpVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCustomerGrpVO> models = new ArrayList<SearchCustomerGrpVO>();
	
	/* Column Info */
	private String indivCorpDivCd = null;
	/* Column Info */
	private String custLoclLangNm = null;
	/* Column Info */
	private String modiCustSeq = null;
	/* Column Info */
	private String fndtDt = null;
	/* Column Info */
	private String cntrDivFlg = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String custAbbrNm = null;
	/* Column Info */
	private String crmRowId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String eaiIfId = null;
	/* Column Info */
	private String custGrpSeq = null;
	/* Column Info */
	private String custRgstNo = null;
	/* Column Info */
	private String custStsCd = null;
	/* Column Info */
	private String lstkFlg = null;
	/* Column Info */
	private String blkCustTpCd = null;
	/* Column Info */
	private String srepCd = null;
	/* Column Info */
	private String pagerows = null;
	/* Column Info */
	private String rvisCntrCustTpCd = null;
	/* Column Info */
	private String keyAcctFlg = null;
	/* Column Info */
	private String vbsClssCd = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String blkDivFlg = null;
	/* Column Info */
	private String custGrpNm = null;
	/* Column Info */
	private String srepNm = null;
	/* Column Info */
	private String customerCode = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String slsDeltEffDt = null;
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String custGrpId = null;
	/* Column Info */
	private String primarySrepCd = null;
	/* Column Info */
	private String flg = null;
	/* Column Info */
	private String capiCurrCd = null;
	/* Column Info */
	private String eaiEvntDt = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String fincStsLvlCd = null;
	/* Column Info */
	private String srepPrmryFlg = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String custRmk = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String modiCustCntCd = null;
	/* Column Info */
	private String empeKnt = null;
	/* Column Info */
	private String mltTrdAcctFlg = null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCustomerGrpVO() {}

	public SearchCustomerGrpVO(String ibflag, String pagerows, String blkCustTpCd, String blkDivFlg, String capiCurrCd, String cntrDivFlg, String creDt, String creUsrId, String crmRowId, String custAbbrNm, String custCntCd, String custGrpId, String custGrpNm, String custGrpSeq, String custLglEngNm, String custLoclLangNm, String custRgstNo, String custRmk, String custSeq, String custStsCd, String customerCode, String deltFlg, String eaiEvntDt, String eaiIfId, String empeKnt, String fincStsLvlCd, String flg, String fndtDt, String indivCorpDivCd, String keyAcctFlg, String locCd, String lstkFlg, String mltTrdAcctFlg, String modiCustCntCd, String modiCustSeq, String ofcCd, String phnNo, String primarySrepCd, String rvisCntrCustTpCd, String slsDeltEffDt, String srepCd, String srepNm, String srepPrmryFlg, String updDt, String updUsrId, String vbsClssCd, String vndrSeq) {
		this.indivCorpDivCd = indivCorpDivCd;
		this.custLoclLangNm = custLoclLangNm;
		this.modiCustSeq = modiCustSeq;
		this.fndtDt = fndtDt;
		this.cntrDivFlg = cntrDivFlg;
		this.deltFlg = deltFlg;
		this.custAbbrNm = custAbbrNm;
		this.crmRowId = crmRowId;
		this.creDt = creDt;
		this.eaiIfId = eaiIfId;
		this.custGrpSeq = custGrpSeq;
		this.custRgstNo = custRgstNo;
		this.custStsCd = custStsCd;
		this.lstkFlg = lstkFlg;
		this.blkCustTpCd = blkCustTpCd;
		this.srepCd = srepCd;
		this.pagerows = pagerows;
		this.rvisCntrCustTpCd = rvisCntrCustTpCd;
		this.keyAcctFlg = keyAcctFlg;
		this.vbsClssCd = vbsClssCd;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.blkDivFlg = blkDivFlg;
		this.custGrpNm = custGrpNm;
		this.srepNm = srepNm;
		this.customerCode = customerCode;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.updDt = updDt;
		this.slsDeltEffDt = slsDeltEffDt;
		this.phnNo = phnNo;
		this.custGrpId = custGrpId;
		this.primarySrepCd = primarySrepCd;
		this.flg = flg;
		this.capiCurrCd = capiCurrCd;
		this.eaiEvntDt = eaiEvntDt;
		this.custSeq = custSeq;
		this.fincStsLvlCd = fincStsLvlCd;
		this.srepPrmryFlg = srepPrmryFlg;
		this.custLglEngNm = custLglEngNm;
		this.custRmk = custRmk;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.vndrSeq = vndrSeq;
		this.modiCustCntCd = modiCustCntCd;
		this.empeKnt = empeKnt;
		this.mltTrdAcctFlg = mltTrdAcctFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("indiv_corp_div_cd", getIndivCorpDivCd());
		this.hashColumns.put("cust_locl_lang_nm", getCustLoclLangNm());
		this.hashColumns.put("modi_cust_seq", getModiCustSeq());
		this.hashColumns.put("fndt_dt", getFndtDt());
		this.hashColumns.put("cntr_div_flg", getCntrDivFlg());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cust_abbr_nm", getCustAbbrNm());
		this.hashColumns.put("crm_row_id", getCrmRowId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("eai_if_id", getEaiIfId());
		this.hashColumns.put("cust_grp_seq", getCustGrpSeq());
		this.hashColumns.put("cust_rgst_no", getCustRgstNo());
		this.hashColumns.put("cust_sts_cd", getCustStsCd());
		this.hashColumns.put("lstk_flg", getLstkFlg());
		this.hashColumns.put("blk_cust_tp_cd", getBlkCustTpCd());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rvis_cntr_cust_tp_cd", getRvisCntrCustTpCd());
		this.hashColumns.put("key_acct_flg", getKeyAcctFlg());
		this.hashColumns.put("vbs_clss_cd", getVbsClssCd());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("blk_div_flg", getBlkDivFlg());
		this.hashColumns.put("cust_grp_nm", getCustGrpNm());
		this.hashColumns.put("srep_nm", getSrepNm());
		this.hashColumns.put("customer_code", getCustomerCode());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("sls_delt_eff_dt", getSlsDeltEffDt());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("cust_grp_id", getCustGrpId());
		this.hashColumns.put("primary_srep_cd", getPrimarySrepCd());
		this.hashColumns.put("flg", getFlg());
		this.hashColumns.put("capi_curr_cd", getCapiCurrCd());
		this.hashColumns.put("eai_evnt_dt", getEaiEvntDt());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("finc_sts_lvl_cd", getFincStsLvlCd());
		this.hashColumns.put("srep_prmry_flg", getSrepPrmryFlg());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("cust_rmk", getCustRmk());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("modi_cust_cnt_cd", getModiCustCntCd());
		this.hashColumns.put("empe_knt", getEmpeKnt());
		this.hashColumns.put("mlt_trd_acct_flg", getMltTrdAcctFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("indiv_corp_div_cd", "indivCorpDivCd");
		this.hashFields.put("cust_locl_lang_nm", "custLoclLangNm");
		this.hashFields.put("modi_cust_seq", "modiCustSeq");
		this.hashFields.put("fndt_dt", "fndtDt");
		this.hashFields.put("cntr_div_flg", "cntrDivFlg");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cust_abbr_nm", "custAbbrNm");
		this.hashFields.put("crm_row_id", "crmRowId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("eai_if_id", "eaiIfId");
		this.hashFields.put("cust_grp_seq", "custGrpSeq");
		this.hashFields.put("cust_rgst_no", "custRgstNo");
		this.hashFields.put("cust_sts_cd", "custStsCd");
		this.hashFields.put("lstk_flg", "lstkFlg");
		this.hashFields.put("blk_cust_tp_cd", "blkCustTpCd");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rvis_cntr_cust_tp_cd", "rvisCntrCustTpCd");
		this.hashFields.put("key_acct_flg", "keyAcctFlg");
		this.hashFields.put("vbs_clss_cd", "vbsClssCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("blk_div_flg", "blkDivFlg");
		this.hashFields.put("cust_grp_nm", "custGrpNm");
		this.hashFields.put("srep_nm", "srepNm");
		this.hashFields.put("customer_code", "customerCode");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("sls_delt_eff_dt", "slsDeltEffDt");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("cust_grp_id", "custGrpId");
		this.hashFields.put("primary_srep_cd", "primarySrepCd");
		this.hashFields.put("flg", "flg");
		this.hashFields.put("capi_curr_cd", "capiCurrCd");
		this.hashFields.put("eai_evnt_dt", "eaiEvntDt");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("finc_sts_lvl_cd", "fincStsLvlCd");
		this.hashFields.put("srep_prmry_flg", "srepPrmryFlg");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("cust_rmk", "custRmk");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("modi_cust_cnt_cd", "modiCustCntCd");
		this.hashFields.put("empe_knt", "empeKnt");
		this.hashFields.put("mlt_trd_acct_flg", "mltTrdAcctFlg");
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
	 * @return custLoclLangNm
	 */
	public String getCustLoclLangNm() {
		return this.custLoclLangNm;
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
	 * @return crmRowId
	 */
	public String getCrmRowId() {
		return this.crmRowId;
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
	 * @return eaiIfId
	 */
	public String getEaiIfId() {
		return this.eaiIfId;
	}
	
	/**
	 * Column Info
	 * @return custGrpSeq
	 */
	public String getCustGrpSeq() {
		return this.custGrpSeq;
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
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return rvisCntrCustTpCd
	 */
	public String getRvisCntrCustTpCd() {
		return this.rvisCntrCustTpCd;
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
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return custGrpNm
	 */
	public String getCustGrpNm() {
		return this.custGrpNm;
	}
	
	/**
	 * Column Info
	 * @return srepNm
	 */
	public String getSrepNm() {
		return this.srepNm;
	}
	
	/**
	 * Column Info
	 * @return customerCode
	 */
	public String getCustomerCode() {
		return this.customerCode;
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
	 * @return phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
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
	 * @return primarySrepCd
	 */
	public String getPrimarySrepCd() {
		return this.primarySrepCd;
	}
	
	/**
	 * Column Info
	 * @return flg
	 */
	public String getFlg() {
		return this.flg;
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
	 * @return fincStsLvlCd
	 */
	public String getFincStsLvlCd() {
		return this.fincStsLvlCd;
	}
	
	/**
	 * Column Info
	 * @return srepPrmryFlg
	 */
	public String getSrepPrmryFlg() {
		return this.srepPrmryFlg;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
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
	 * @param custLoclLangNm
	 */
	public void setCustLoclLangNm(String custLoclLangNm) {
		this.custLoclLangNm = custLoclLangNm;
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
	 * @param crmRowId
	 */
	public void setCrmRowId(String crmRowId) {
		this.crmRowId = crmRowId;
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
	 * @param eaiIfId
	 */
	public void setEaiIfId(String eaiIfId) {
		this.eaiIfId = eaiIfId;
	}
	
	/**
	 * Column Info
	 * @param custGrpSeq
	 */
	public void setCustGrpSeq(String custGrpSeq) {
		this.custGrpSeq = custGrpSeq;
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
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param rvisCntrCustTpCd
	 */
	public void setRvisCntrCustTpCd(String rvisCntrCustTpCd) {
		this.rvisCntrCustTpCd = rvisCntrCustTpCd;
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
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param custGrpNm
	 */
	public void setCustGrpNm(String custGrpNm) {
		this.custGrpNm = custGrpNm;
	}
	
	/**
	 * Column Info
	 * @param srepNm
	 */
	public void setSrepNm(String srepNm) {
		this.srepNm = srepNm;
	}
	
	/**
	 * Column Info
	 * @param customerCode
	 */
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
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
	 * @param phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
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
	 * @param primarySrepCd
	 */
	public void setPrimarySrepCd(String primarySrepCd) {
		this.primarySrepCd = primarySrepCd;
	}
	
	/**
	 * Column Info
	 * @param flg
	 */
	public void setFlg(String flg) {
		this.flg = flg;
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
	 * @param fincStsLvlCd
	 */
	public void setFincStsLvlCd(String fincStsLvlCd) {
		this.fincStsLvlCd = fincStsLvlCd;
	}
	
	/**
	 * Column Info
	 * @param srepPrmryFlg
	 */
	public void setSrepPrmryFlg(String srepPrmryFlg) {
		this.srepPrmryFlg = srepPrmryFlg;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
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
	 * @param mltTrdAcctFlg
	 */
	public void setMltTrdAcctFlg(String mltTrdAcctFlg) {
		this.mltTrdAcctFlg = mltTrdAcctFlg;
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
		setCustLoclLangNm(JSPUtil.getParameter(request, prefix + "cust_locl_lang_nm", ""));
		setModiCustSeq(JSPUtil.getParameter(request, prefix + "modi_cust_seq", ""));
		setFndtDt(JSPUtil.getParameter(request, prefix + "fndt_dt", ""));
		setCntrDivFlg(JSPUtil.getParameter(request, prefix + "cntr_div_flg", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCustAbbrNm(JSPUtil.getParameter(request, prefix + "cust_abbr_nm", ""));
		setCrmRowId(JSPUtil.getParameter(request, prefix + "crm_row_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setEaiIfId(JSPUtil.getParameter(request, prefix + "eai_if_id", ""));
		setCustGrpSeq(JSPUtil.getParameter(request, prefix + "cust_grp_seq", ""));
		setCustRgstNo(JSPUtil.getParameter(request, prefix + "cust_rgst_no", ""));
		setCustStsCd(JSPUtil.getParameter(request, prefix + "cust_sts_cd", ""));
		setLstkFlg(JSPUtil.getParameter(request, prefix + "lstk_flg", ""));
		setBlkCustTpCd(JSPUtil.getParameter(request, prefix + "blk_cust_tp_cd", ""));
		setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRvisCntrCustTpCd(JSPUtil.getParameter(request, prefix + "rvis_cntr_cust_tp_cd", ""));
		setKeyAcctFlg(JSPUtil.getParameter(request, prefix + "key_acct_flg", ""));
		setVbsClssCd(JSPUtil.getParameter(request, prefix + "vbs_clss_cd", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBlkDivFlg(JSPUtil.getParameter(request, prefix + "blk_div_flg", ""));
		setCustGrpNm(JSPUtil.getParameter(request, prefix + "cust_grp_nm", ""));
		setSrepNm(JSPUtil.getParameter(request, prefix + "srep_nm", ""));
		setCustomerCode(JSPUtil.getParameter(request, prefix + "customer_code", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setSlsDeltEffDt(JSPUtil.getParameter(request, prefix + "sls_delt_eff_dt", ""));
		setPhnNo(JSPUtil.getParameter(request, prefix + "phn_no", ""));
		setCustGrpId(JSPUtil.getParameter(request, prefix + "cust_grp_id", ""));
		setPrimarySrepCd(JSPUtil.getParameter(request, prefix + "primary_srep_cd", ""));
		setFlg(JSPUtil.getParameter(request, prefix + "flg", ""));
		setCapiCurrCd(JSPUtil.getParameter(request, prefix + "capi_curr_cd", ""));
		setEaiEvntDt(JSPUtil.getParameter(request, prefix + "eai_evnt_dt", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setFincStsLvlCd(JSPUtil.getParameter(request, prefix + "finc_sts_lvl_cd", ""));
		setSrepPrmryFlg(JSPUtil.getParameter(request, prefix + "srep_prmry_flg", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setCustRmk(JSPUtil.getParameter(request, prefix + "cust_rmk", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setModiCustCntCd(JSPUtil.getParameter(request, prefix + "modi_cust_cnt_cd", ""));
		setEmpeKnt(JSPUtil.getParameter(request, prefix + "empe_knt", ""));
		setMltTrdAcctFlg(JSPUtil.getParameter(request, prefix + "mlt_trd_acct_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCustomerVO[]
	 */
	public SearchCustomerGrpVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCustomerVO[]
	 */
	public SearchCustomerGrpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCustomerGrpVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] indivCorpDivCd = (JSPUtil.getParameter(request, prefix	+ "indiv_corp_div_cd", length));
			String[] custLoclLangNm = (JSPUtil.getParameter(request, prefix	+ "cust_locl_lang_nm", length));
			String[] modiCustSeq = (JSPUtil.getParameter(request, prefix	+ "modi_cust_seq", length));
			String[] fndtDt = (JSPUtil.getParameter(request, prefix	+ "fndt_dt", length));
			String[] cntrDivFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_div_flg", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] custAbbrNm = (JSPUtil.getParameter(request, prefix	+ "cust_abbr_nm", length));
			String[] crmRowId = (JSPUtil.getParameter(request, prefix	+ "crm_row_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] eaiIfId = (JSPUtil.getParameter(request, prefix	+ "eai_if_id", length));
			String[] custGrpSeq = (JSPUtil.getParameter(request, prefix	+ "cust_grp_seq", length));
			String[] custRgstNo = (JSPUtil.getParameter(request, prefix	+ "cust_rgst_no", length));
			String[] custStsCd = (JSPUtil.getParameter(request, prefix	+ "cust_sts_cd", length));
			String[] lstkFlg = (JSPUtil.getParameter(request, prefix	+ "lstk_flg", length));
			String[] blkCustTpCd = (JSPUtil.getParameter(request, prefix	+ "blk_cust_tp_cd", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rvisCntrCustTpCd = (JSPUtil.getParameter(request, prefix	+ "rvis_cntr_cust_tp_cd", length));
			String[] keyAcctFlg = (JSPUtil.getParameter(request, prefix	+ "key_acct_flg", length));
			String[] vbsClssCd = (JSPUtil.getParameter(request, prefix	+ "vbs_clss_cd", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] blkDivFlg = (JSPUtil.getParameter(request, prefix	+ "blk_div_flg", length));
			String[] custGrpNm = (JSPUtil.getParameter(request, prefix	+ "cust_grp_nm", length));
			String[] srepNm = (JSPUtil.getParameter(request, prefix	+ "srep_nm", length));
			String[] customerCode = (JSPUtil.getParameter(request, prefix	+ "customer_code", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] slsDeltEffDt = (JSPUtil.getParameter(request, prefix	+ "sls_delt_eff_dt", length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] custGrpId = (JSPUtil.getParameter(request, prefix	+ "cust_grp_id", length));
			String[] primarySrepCd = (JSPUtil.getParameter(request, prefix	+ "primary_srep_cd", length));
			String[] flg = (JSPUtil.getParameter(request, prefix	+ "flg", length));
			String[] capiCurrCd = (JSPUtil.getParameter(request, prefix	+ "capi_curr_cd", length));
			String[] eaiEvntDt = (JSPUtil.getParameter(request, prefix	+ "eai_evnt_dt", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] fincStsLvlCd = (JSPUtil.getParameter(request, prefix	+ "finc_sts_lvl_cd", length));
			String[] srepPrmryFlg = (JSPUtil.getParameter(request, prefix	+ "srep_prmry_flg", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] custRmk = (JSPUtil.getParameter(request, prefix	+ "cust_rmk", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] modiCustCntCd = (JSPUtil.getParameter(request, prefix	+ "modi_cust_cnt_cd", length));
			String[] empeKnt = (JSPUtil.getParameter(request, prefix	+ "empe_knt", length));
			String[] mltTrdAcctFlg = (JSPUtil.getParameter(request, prefix	+ "mlt_trd_acct_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCustomerGrpVO();
				if (indivCorpDivCd[i] != null)
					model.setIndivCorpDivCd(indivCorpDivCd[i]);
				if (custLoclLangNm[i] != null)
					model.setCustLoclLangNm(custLoclLangNm[i]);
				if (modiCustSeq[i] != null)
					model.setModiCustSeq(modiCustSeq[i]);
				if (fndtDt[i] != null)
					model.setFndtDt(fndtDt[i]);
				if (cntrDivFlg[i] != null)
					model.setCntrDivFlg(cntrDivFlg[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (custAbbrNm[i] != null)
					model.setCustAbbrNm(custAbbrNm[i]);
				if (crmRowId[i] != null)
					model.setCrmRowId(crmRowId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (eaiIfId[i] != null)
					model.setEaiIfId(eaiIfId[i]);
				if (custGrpSeq[i] != null)
					model.setCustGrpSeq(custGrpSeq[i]);
				if (custRgstNo[i] != null)
					model.setCustRgstNo(custRgstNo[i]);
				if (custStsCd[i] != null)
					model.setCustStsCd(custStsCd[i]);
				if (lstkFlg[i] != null)
					model.setLstkFlg(lstkFlg[i]);
				if (blkCustTpCd[i] != null)
					model.setBlkCustTpCd(blkCustTpCd[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rvisCntrCustTpCd[i] != null)
					model.setRvisCntrCustTpCd(rvisCntrCustTpCd[i]);
				if (keyAcctFlg[i] != null)
					model.setKeyAcctFlg(keyAcctFlg[i]);
				if (vbsClssCd[i] != null)
					model.setVbsClssCd(vbsClssCd[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (blkDivFlg[i] != null)
					model.setBlkDivFlg(blkDivFlg[i]);
				if (custGrpNm[i] != null)
					model.setCustGrpNm(custGrpNm[i]);
				if (srepNm[i] != null)
					model.setSrepNm(srepNm[i]);
				if (customerCode[i] != null)
					model.setCustomerCode(customerCode[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (slsDeltEffDt[i] != null)
					model.setSlsDeltEffDt(slsDeltEffDt[i]);
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (custGrpId[i] != null)
					model.setCustGrpId(custGrpId[i]);
				if (primarySrepCd[i] != null)
					model.setPrimarySrepCd(primarySrepCd[i]);
				if (flg[i] != null)
					model.setFlg(flg[i]);
				if (capiCurrCd[i] != null)
					model.setCapiCurrCd(capiCurrCd[i]);
				if (eaiEvntDt[i] != null)
					model.setEaiEvntDt(eaiEvntDt[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (fincStsLvlCd[i] != null)
					model.setFincStsLvlCd(fincStsLvlCd[i]);
				if (srepPrmryFlg[i] != null)
					model.setSrepPrmryFlg(srepPrmryFlg[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (custRmk[i] != null)
					model.setCustRmk(custRmk[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (modiCustCntCd[i] != null)
					model.setModiCustCntCd(modiCustCntCd[i]);
				if (empeKnt[i] != null)
					model.setEmpeKnt(empeKnt[i]);
				if (mltTrdAcctFlg[i] != null)
					model.setMltTrdAcctFlg(mltTrdAcctFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCustomerGrpVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCustomerVO[]
	 */
	public SearchCustomerGrpVO[] getSearchCustomerGrpVOs(){
		SearchCustomerGrpVO[] vos = (SearchCustomerGrpVO[])models.toArray(new SearchCustomerGrpVO[models.size()]);
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
		this.custLoclLangNm = this.custLoclLangNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiCustSeq = this.modiCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fndtDt = this.fndtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDivFlg = this.cntrDivFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAbbrNm = this.custAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crmRowId = this.crmRowId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiIfId = this.eaiIfId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpSeq = this.custGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRgstNo = this.custRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custStsCd = this.custStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstkFlg = this.lstkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkCustTpCd = this.blkCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisCntrCustTpCd = this.rvisCntrCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyAcctFlg = this.keyAcctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vbsClssCd = this.vbsClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkDivFlg = this.blkDivFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpNm = this.custGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepNm = this.srepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customerCode = this.customerCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsDeltEffDt = this.slsDeltEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpId = this.custGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.primarySrepCd = this.primarySrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flg = this.flg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.capiCurrCd = this.capiCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiEvntDt = this.eaiEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincStsLvlCd = this.fincStsLvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepPrmryFlg = this.srepPrmryFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRmk = this.custRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiCustCntCd = this.modiCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.empeKnt = this.empeKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mltTrdAcctFlg = this.mltTrdAcctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
