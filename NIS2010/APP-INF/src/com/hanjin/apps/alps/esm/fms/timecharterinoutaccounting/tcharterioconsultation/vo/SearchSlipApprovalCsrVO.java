/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchSlipApprovalCsrVO.java
*@FileTitle : SearchSlipApprovalCsrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.01
*@LastModifier : 이영두
*@LastVersion : 1.0
* 2015.09.01 이영두 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo;

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
 * @author 이영두
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSlipApprovalCsrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSlipApprovalCsrVO> models = new ArrayList<SearchSlipApprovalCsrVO>();
	
	/* Column Info */
	private String rcvErrRsn = null;
	/* Column Info */
	private String slpFuncCd = null;
	/* Column Info */
	private String cxlFlg = null;
	/* Column Info */
	private String csrDesc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String evidTpNm = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String effDtFr = null;
	/* Column Info */
	private String orgSlpSerNo = null;
	/* Column Info */
	private String rvsCmbFlg = null;
	/* Column Info */
	private String slpTpCd = null;
	/* Column Info */
	private String aproFlg = null;
	/* Column Info */
	private String csrTpCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String orgSlpTpCd = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String authOfcCd = null;
	/* Column Info */
	private String ddctDesc = null;
	/* Column Info */
	private String slpIssInterCoCd = null;
	/* Column Info */
	private String vndrCustSeq = null;
	/* Column Info */
	private String ifFlg = null;
	/* Column Info */
	private String aproDt = null;
	/* Column Info */
	private String lglEngNm = null;
	/* Column Info */
	private String csrLoclAmt = null;
	/* Column Info */
	private String acctYrmon = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String aproRqstNo = null;
	/* Column Info */
	private String issuer = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String ddctLoclAmt = null;
	/* Column Info */
	private String ddctFlg = null;
	/* Column Info */
	private String slpSerNo = null;
	/* Column Info */
	private String stlCmbSeq = null;
	/* Column Info */
	private String aproStep = null;
	/* Column Info */
	private String orgSlpFuncCd = null;
	/* Column Info */
	private String evidTpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String csrLoclCurrCd = null;
	/* Column Info */
	private String authCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDtTo = null;
	/* Column Info */
	private String cxlDesc = null;
	/* Column Info */
	private String orgSlpIssDt = null;
	/* Column Info */
	private String slpIssRgnCd = null;
	/* Column Info */
	private String rqstLoclAmt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String aproRqstSeq = null;
	/* Column Info */
	private String lstAproFlg = null;
	/* Column Info */
	private String joCrrCd = null;
	/* Column Info */
	private String clzStsCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String slpOfcCd = null;
	/* Column Info */
	private String slpIssDt = null;
	/* Column Info */
	private String rjctCmbFlg = null;
	/* Column Info */
	private String rjctCsrFlg = null;
	/* Column Info */
	private String reDivrCd = null;
	/* Column Info */
	private String csrUsdAmt = null;
	/* Column Info */
	private String orgSlpOfcCd = null;
	/* Column Info */
	private String rvsCsrFlg = null;
	/* Column Info */
	private String csrOffstNo = null;
	/* Column Info */
	private String slpIssOfcCd = null;
	/* Column Info */
	private String aproFlgUpdateYn = null;	
	/* Column Info */
	private String agmtDocNo = null;	
	/* Column Info */
	private String agmtDocDesc = null;		

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSlipApprovalCsrVO() {}

	public SearchSlipApprovalCsrVO(String ibflag, String pagerows, String csrNo, String slpTpCd, String slpFuncCd, String slpOfcCd, String slpIssDt, String slpSerNo, String vndrSeq, String custCntCd, String custSeq, String slpIssOfcCd, String csrDesc, String csrLoclCurrCd, String csrLoclAmt, String csrUsdAmt, String effDt, String evidTpCd, String aproFlg, String aproDt, String cxlFlg, String cxlDesc, String csrOffstNo, String ddctFlg, String ddctLoclAmt, String ddctDesc, String rqstLoclAmt, String rqstDt, String csrTpCd, String slpIssRgnCd, String slpIssInterCoCd, String rvsCsrFlg, String orgSlpTpCd, String orgSlpFuncCd, String orgSlpOfcCd, String orgSlpIssDt, String orgSlpSerNo, String acctYrmon, String joCrrCd, String stlCmbSeq, String reDivrCd, String rvsCmbFlg, String creDt, String creUsrId, String updDt, String updUsrId, String issuer, String evidTpNm, String vndrCustSeq, String lglEngNm, String clzStsCd, String rjctCsrFlg, String rjctCmbFlg, String rcvErrRsn, String effDtFr, String effDtTo, String authOfcCd, String authCd, String ifFlg, String aproStep, String lstAproFlg, String aproRqstNo, String aproRqstSeq, String aproFlgUpdateYn, String agmtDocNo, String agmtDocDesc) {
		this.rcvErrRsn = rcvErrRsn;
		this.slpFuncCd = slpFuncCd;
		this.cxlFlg = cxlFlg;
		this.csrDesc = csrDesc;
		this.pagerows = pagerows;
		this.evidTpNm = evidTpNm;
		this.effDt = effDt;
		this.effDtFr = effDtFr;
		this.orgSlpSerNo = orgSlpSerNo;
		this.rvsCmbFlg = rvsCmbFlg;
		this.slpTpCd = slpTpCd;
		this.aproFlg = aproFlg;
		this.csrTpCd = csrTpCd;
		this.custCntCd = custCntCd;
		this.updUsrId = updUsrId;
		this.orgSlpTpCd = orgSlpTpCd;
		this.csrNo = csrNo;
		this.authOfcCd = authOfcCd;
		this.ddctDesc = ddctDesc;
		this.slpIssInterCoCd = slpIssInterCoCd;
		this.vndrCustSeq = vndrCustSeq;
		this.ifFlg = ifFlg;
		this.aproDt = aproDt;
		this.lglEngNm = lglEngNm;
		this.csrLoclAmt = csrLoclAmt;
		this.acctYrmon = acctYrmon;
		this.creUsrId = creUsrId;
		this.aproRqstNo = aproRqstNo;
		this.issuer = issuer;
		this.vndrSeq = vndrSeq;
		this.ddctLoclAmt = ddctLoclAmt;
		this.ddctFlg = ddctFlg;
		this.slpSerNo = slpSerNo;
		this.stlCmbSeq = stlCmbSeq;
		this.aproStep = aproStep;
		this.orgSlpFuncCd = orgSlpFuncCd;
		this.evidTpCd = evidTpCd;
		this.creDt = creDt;
		this.csrLoclCurrCd = csrLoclCurrCd;
		this.authCd = authCd;
		this.ibflag = ibflag;
		this.effDtTo = effDtTo;
		this.cxlDesc = cxlDesc;
		this.orgSlpIssDt = orgSlpIssDt;
		this.slpIssRgnCd = slpIssRgnCd;
		this.rqstLoclAmt = rqstLoclAmt;
		this.updDt = updDt;
		this.rqstDt = rqstDt;
		this.aproRqstSeq = aproRqstSeq;
		this.lstAproFlg = lstAproFlg;
		this.joCrrCd = joCrrCd;
		this.clzStsCd = clzStsCd;
		this.custSeq = custSeq;
		this.slpOfcCd = slpOfcCd;
		this.slpIssDt = slpIssDt;
		this.rjctCmbFlg = rjctCmbFlg;
		this.rjctCsrFlg = rjctCsrFlg;
		this.reDivrCd = reDivrCd;
		this.csrUsdAmt = csrUsdAmt;
		this.orgSlpOfcCd = orgSlpOfcCd;
		this.rvsCsrFlg = rvsCsrFlg;
		this.csrOffstNo = csrOffstNo;
		this.slpIssOfcCd = slpIssOfcCd;
		this.aproFlgUpdateYn = aproFlgUpdateYn;		
		this.agmtDocNo = agmtDocNo;
		this.agmtDocDesc = agmtDocDesc;		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rcv_err_rsn", getRcvErrRsn());
		this.hashColumns.put("slp_func_cd", getSlpFuncCd());
		this.hashColumns.put("cxl_flg", getCxlFlg());
		this.hashColumns.put("csr_desc", getCsrDesc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("evid_tp_nm", getEvidTpNm());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("eff_dt_fr", getEffDtFr());
		this.hashColumns.put("org_slp_ser_no", getOrgSlpSerNo());
		this.hashColumns.put("rvs_cmb_flg", getRvsCmbFlg());
		this.hashColumns.put("slp_tp_cd", getSlpTpCd());
		this.hashColumns.put("apro_flg", getAproFlg());
		this.hashColumns.put("csr_tp_cd", getCsrTpCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("org_slp_tp_cd", getOrgSlpTpCd());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("auth_ofc_cd", getAuthOfcCd());
		this.hashColumns.put("ddct_desc", getDdctDesc());
		this.hashColumns.put("slp_iss_inter_co_cd", getSlpIssInterCoCd());
		this.hashColumns.put("vndr_cust_seq", getVndrCustSeq());
		this.hashColumns.put("if_flg", getIfFlg());
		this.hashColumns.put("apro_dt", getAproDt());
		this.hashColumns.put("lgl_eng_nm", getLglEngNm());
		this.hashColumns.put("csr_locl_amt", getCsrLoclAmt());
		this.hashColumns.put("acct_yrmon", getAcctYrmon());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("apro_rqst_no", getAproRqstNo());
		this.hashColumns.put("issuer", getIssuer());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("ddct_locl_amt", getDdctLoclAmt());
		this.hashColumns.put("ddct_flg", getDdctFlg());
		this.hashColumns.put("slp_ser_no", getSlpSerNo());
		this.hashColumns.put("stl_cmb_seq", getStlCmbSeq());
		this.hashColumns.put("apro_step", getAproStep());
		this.hashColumns.put("org_slp_func_cd", getOrgSlpFuncCd());
		this.hashColumns.put("evid_tp_cd", getEvidTpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("csr_locl_curr_cd", getCsrLoclCurrCd());
		this.hashColumns.put("auth_cd", getAuthCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt_to", getEffDtTo());
		this.hashColumns.put("cxl_desc", getCxlDesc());
		this.hashColumns.put("org_slp_iss_dt", getOrgSlpIssDt());
		this.hashColumns.put("slp_iss_rgn_cd", getSlpIssRgnCd());
		this.hashColumns.put("rqst_locl_amt", getRqstLoclAmt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("apro_rqst_seq", getAproRqstSeq());
		this.hashColumns.put("lst_apro_flg", getLstAproFlg());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("clz_sts_cd", getClzStsCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("slp_ofc_cd", getSlpOfcCd());
		this.hashColumns.put("slp_iss_dt", getSlpIssDt());
		this.hashColumns.put("rjct_cmb_flg", getRjctCmbFlg());
		this.hashColumns.put("rjct_csr_flg", getRjctCsrFlg());
		this.hashColumns.put("re_divr_cd", getReDivrCd());
		this.hashColumns.put("csr_usd_amt", getCsrUsdAmt());
		this.hashColumns.put("org_slp_ofc_cd", getOrgSlpOfcCd());
		this.hashColumns.put("rvs_csr_flg", getRvsCsrFlg());
		this.hashColumns.put("csr_offst_no", getCsrOffstNo());
		this.hashColumns.put("slp_iss_ofc_cd", getSlpIssOfcCd());
		this.hashColumns.put("apro_flg_update_yn", getAproFlgUpdateYn());		
		this.hashColumns.put("agmt_doc_no", getAgmtDocNo());
		this.hashColumns.put("agmt_doc_desc", getAgmtDocDesc());		
		
		
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rcv_err_rsn", "rcvErrRsn");
		this.hashFields.put("slp_func_cd", "slpFuncCd");
		this.hashFields.put("cxl_flg", "cxlFlg");
		this.hashFields.put("csr_desc", "csrDesc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("evid_tp_nm", "evidTpNm");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("eff_dt_fr", "effDtFr");
		this.hashFields.put("org_slp_ser_no", "orgSlpSerNo");
		this.hashFields.put("rvs_cmb_flg", "rvsCmbFlg");
		this.hashFields.put("slp_tp_cd", "slpTpCd");
		this.hashFields.put("apro_flg", "aproFlg");
		this.hashFields.put("csr_tp_cd", "csrTpCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("org_slp_tp_cd", "orgSlpTpCd");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("auth_ofc_cd", "authOfcCd");
		this.hashFields.put("ddct_desc", "ddctDesc");
		this.hashFields.put("slp_iss_inter_co_cd", "slpIssInterCoCd");
		this.hashFields.put("vndr_cust_seq", "vndrCustSeq");
		this.hashFields.put("if_flg", "ifFlg");
		this.hashFields.put("apro_dt", "aproDt");
		this.hashFields.put("lgl_eng_nm", "lglEngNm");
		this.hashFields.put("csr_locl_amt", "csrLoclAmt");
		this.hashFields.put("acct_yrmon", "acctYrmon");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("apro_rqst_no", "aproRqstNo");
		this.hashFields.put("issuer", "issuer");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("ddct_locl_amt", "ddctLoclAmt");
		this.hashFields.put("ddct_flg", "ddctFlg");
		this.hashFields.put("slp_ser_no", "slpSerNo");
		this.hashFields.put("stl_cmb_seq", "stlCmbSeq");
		this.hashFields.put("apro_step", "aproStep");
		this.hashFields.put("org_slp_func_cd", "orgSlpFuncCd");
		this.hashFields.put("evid_tp_cd", "evidTpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("csr_locl_curr_cd", "csrLoclCurrCd");
		this.hashFields.put("auth_cd", "authCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt_to", "effDtTo");
		this.hashFields.put("cxl_desc", "cxlDesc");
		this.hashFields.put("org_slp_iss_dt", "orgSlpIssDt");
		this.hashFields.put("slp_iss_rgn_cd", "slpIssRgnCd");
		this.hashFields.put("rqst_locl_amt", "rqstLoclAmt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("apro_rqst_seq", "aproRqstSeq");
		this.hashFields.put("lst_apro_flg", "lstAproFlg");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("clz_sts_cd", "clzStsCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("slp_ofc_cd", "slpOfcCd");
		this.hashFields.put("slp_iss_dt", "slpIssDt");
		this.hashFields.put("rjct_cmb_flg", "rjctCmbFlg");
		this.hashFields.put("rjct_csr_flg", "rjctCsrFlg");
		this.hashFields.put("re_divr_cd", "reDivrCd");
		this.hashFields.put("csr_usd_amt", "csrUsdAmt");
		this.hashFields.put("org_slp_ofc_cd", "orgSlpOfcCd");
		this.hashFields.put("rvs_csr_flg", "rvsCsrFlg");
		this.hashFields.put("csr_offst_no", "csrOffstNo");
		this.hashFields.put("slp_iss_ofc_cd", "slpIssOfcCd");
		this.hashFields.put("urg_pay_flg", "urgPayFlg");
		this.hashFields.put("urg_pay_yn", "urgPayYn");
		this.hashFields.put("apro_flg_update_yn", "aproFlgUpdateYn");		
		this.hashFields.put("agmt_doc_no", "agmtDocNo");
		this.hashFields.put("agmt_doc_desc", "agmtDocDesc");		

		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rcvErrRsn
	 */
	public String getRcvErrRsn() {
		return this.rcvErrRsn;
	}
	
	/**
	 * Column Info
	 * @return slpFuncCd
	 */
	public String getSlpFuncCd() {
		return this.slpFuncCd;
	}
	
	/**
	 * Column Info
	 * @return cxlFlg
	 */
	public String getCxlFlg() {
		return this.cxlFlg;
	}
	
	/**
	 * Column Info
	 * @return csrDesc
	 */
	public String getCsrDesc() {
		return this.csrDesc;
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
	 * @return evidTpNm
	 */
	public String getEvidTpNm() {
		return this.evidTpNm;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return effDtFr
	 */
	public String getEffDtFr() {
		return this.effDtFr;
	}
	
	/**
	 * Column Info
	 * @return orgSlpSerNo
	 */
	public String getOrgSlpSerNo() {
		return this.orgSlpSerNo;
	}
	
	/**
	 * Column Info
	 * @return rvsCmbFlg
	 */
	public String getRvsCmbFlg() {
		return this.rvsCmbFlg;
	}
	
	/**
	 * Column Info
	 * @return slpTpCd
	 */
	public String getSlpTpCd() {
		return this.slpTpCd;
	}
	
	/**
	 * Column Info
	 * @return aproFlg
	 */
	public String getAproFlg() {
		return this.aproFlg;
	}
	
	/**
	 * Column Info
	 * @return csrTpCd
	 */
	public String getCsrTpCd() {
		return this.csrTpCd;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return orgSlpTpCd
	 */
	public String getOrgSlpTpCd() {
		return this.orgSlpTpCd;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}
	
	/**
	 * Column Info
	 * @return authOfcCd
	 */
	public String getAuthOfcCd() {
		return this.authOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ddctDesc
	 */
	public String getDdctDesc() {
		return this.ddctDesc;
	}
	
	/**
	 * Column Info
	 * @return slpIssInterCoCd
	 */
	public String getSlpIssInterCoCd() {
		return this.slpIssInterCoCd;
	}
	
	/**
	 * Column Info
	 * @return vndrCustSeq
	 */
	public String getVndrCustSeq() {
		return this.vndrCustSeq;
	}
	
	/**
	 * Column Info
	 * @return ifFlg
	 */
	public String getIfFlg() {
		return this.ifFlg;
	}
	
	/**
	 * Column Info
	 * @return aproDt
	 */
	public String getAproDt() {
		return this.aproDt;
	}
	
	/**
	 * Column Info
	 * @return lglEngNm
	 */
	public String getLglEngNm() {
		return this.lglEngNm;
	}
	
	/**
	 * Column Info
	 * @return csrLoclAmt
	 */
	public String getCsrLoclAmt() {
		return this.csrLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return acctYrmon
	 */
	public String getAcctYrmon() {
		return this.acctYrmon;
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
	 * @return aproRqstNo
	 */
	public String getAproRqstNo() {
		return this.aproRqstNo;
	}
	
	/**
	 * Column Info
	 * @return issuer
	 */
	public String getIssuer() {
		return this.issuer;
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
	 * @return ddctLoclAmt
	 */
	public String getDdctLoclAmt() {
		return this.ddctLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return ddctFlg
	 */
	public String getDdctFlg() {
		return this.ddctFlg;
	}
	
	/**
	 * Column Info
	 * @return slpSerNo
	 */
	public String getSlpSerNo() {
		return this.slpSerNo;
	}
	
	/**
	 * Column Info
	 * @return stlCmbSeq
	 */
	public String getStlCmbSeq() {
		return this.stlCmbSeq;
	}
	
	/**
	 * Column Info
	 * @return aproStep
	 */
	public String getAproStep() {
		return this.aproStep;
	}
	
	/**
	 * Column Info
	 * @return orgSlpFuncCd
	 */
	public String getOrgSlpFuncCd() {
		return this.orgSlpFuncCd;
	}
	
	/**
	 * Column Info
	 * @return evidTpCd
	 */
	public String getEvidTpCd() {
		return this.evidTpCd;
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
	 * @return csrLoclCurrCd
	 */
	public String getCsrLoclCurrCd() {
		return this.csrLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return authCd
	 */
	public String getAuthCd() {
		return this.authCd;
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
	 * @return effDtTo
	 */
	public String getEffDtTo() {
		return this.effDtTo;
	}
	
	/**
	 * Column Info
	 * @return cxlDesc
	 */
	public String getCxlDesc() {
		return this.cxlDesc;
	}
	
	/**
	 * Column Info
	 * @return orgSlpIssDt
	 */
	public String getOrgSlpIssDt() {
		return this.orgSlpIssDt;
	}
	
	/**
	 * Column Info
	 * @return slpIssRgnCd
	 */
	public String getSlpIssRgnCd() {
		return this.slpIssRgnCd;
	}
	
	/**
	 * Column Info
	 * @return rqstLoclAmt
	 */
	public String getRqstLoclAmt() {
		return this.rqstLoclAmt;
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
	 * @return rqstDt
	 */
	public String getRqstDt() {
		return this.rqstDt;
	}
	
	/**
	 * Column Info
	 * @return aproRqstSeq
	 */
	public String getAproRqstSeq() {
		return this.aproRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return lstAproFlg
	 */
	public String getLstAproFlg() {
		return this.lstAproFlg;
	}
	
	/**
	 * Column Info
	 * @return joCrrCd
	 */
	public String getJoCrrCd() {
		return this.joCrrCd;
	}
	
	/**
	 * Column Info
	 * @return clzStsCd
	 */
	public String getClzStsCd() {
		return this.clzStsCd;
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
	 * @return slpOfcCd
	 */
	public String getSlpOfcCd() {
		return this.slpOfcCd;
	}
	
	/**
	 * Column Info
	 * @return slpIssDt
	 */
	public String getSlpIssDt() {
		return this.slpIssDt;
	}
	
	/**
	 * Column Info
	 * @return rjctCmbFlg
	 */
	public String getRjctCmbFlg() {
		return this.rjctCmbFlg;
	}
	
	/**
	 * Column Info
	 * @return rjctCsrFlg
	 */
	public String getRjctCsrFlg() {
		return this.rjctCsrFlg;
	}
	
	/**
	 * Column Info
	 * @return reDivrCd
	 */
	public String getReDivrCd() {
		return this.reDivrCd;
	}
	
	/**
	 * Column Info
	 * @return csrUsdAmt
	 */
	public String getCsrUsdAmt() {
		return this.csrUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return orgSlpOfcCd
	 */
	public String getOrgSlpOfcCd() {
		return this.orgSlpOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rvsCsrFlg
	 */
	public String getRvsCsrFlg() {
		return this.rvsCsrFlg;
	}
	
	/**
	 * Column Info
	 * @return csrOffstNo
	 */
	public String getCsrOffstNo() {
		return this.csrOffstNo;
	}
	
	/**
	 * Column Info
	 * @return slpIssOfcCd
	 */
	public String getSlpIssOfcCd() {
		return this.slpIssOfcCd;
	}
	
	/**
	 * Column Info
	 * @return aproFlgUpdateYn
	 */
	public String getAproFlgUpdateYn() {
		return this.aproFlgUpdateYn;
	}

	/**
	 * Column Info
	 * @return agmtDocNo
	 */
	public String getAgmtDocNo() {
		return this.agmtDocNo;
	}

	
	/**
	 * Column Info
	 * @return agmtDocDesc
	 */
	public String getAgmtDocDesc() {
		return this.agmtDocDesc;
	}
	
	
	/**
	 * Column Info
	 * @param rcvErrRsn
	 */
	public void setRcvErrRsn(String rcvErrRsn) {
		this.rcvErrRsn = rcvErrRsn;
	}
	
	/**
	 * Column Info
	 * @param slpFuncCd
	 */
	public void setSlpFuncCd(String slpFuncCd) {
		this.slpFuncCd = slpFuncCd;
	}
		
	/**
	 * Column Info
	 * @param cxlFlg
	 */
	public void setCxlFlg(String cxlFlg) {
		this.cxlFlg = cxlFlg;
	}
	
	/**
	 * Column Info
	 * @param csrDesc
	 */
	public void setCsrDesc(String csrDesc) {
		this.csrDesc = csrDesc;
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
	 * @param evidTpNm
	 */
	public void setEvidTpNm(String evidTpNm) {
		this.evidTpNm = evidTpNm;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param effDtFr
	 */
	public void setEffDtFr(String effDtFr) {
		this.effDtFr = effDtFr;
	}
	
	/**
	 * Column Info
	 * @param orgSlpSerNo
	 */
	public void setOrgSlpSerNo(String orgSlpSerNo) {
		this.orgSlpSerNo = orgSlpSerNo;
	}
	
	/**
	 * Column Info
	 * @param rvsCmbFlg
	 */
	public void setRvsCmbFlg(String rvsCmbFlg) {
		this.rvsCmbFlg = rvsCmbFlg;
	}
	
	/**
	 * Column Info
	 * @param slpTpCd
	 */
	public void setSlpTpCd(String slpTpCd) {
		this.slpTpCd = slpTpCd;
	}
	
	/**
	 * Column Info
	 * @param aproFlg
	 */
	public void setAproFlg(String aproFlg) {
		this.aproFlg = aproFlg;
	}
	
	/**
	 * Column Info
	 * @param csrTpCd
	 */
	public void setCsrTpCd(String csrTpCd) {
		this.csrTpCd = csrTpCd;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param orgSlpTpCd
	 */
	public void setOrgSlpTpCd(String orgSlpTpCd) {
		this.orgSlpTpCd = orgSlpTpCd;
	}
	
	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	/**
	 * Column Info
	 * @param authOfcCd
	 */
	public void setAuthOfcCd(String authOfcCd) {
		this.authOfcCd = authOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ddctDesc
	 */
	public void setDdctDesc(String ddctDesc) {
		this.ddctDesc = ddctDesc;
	}
	
	/**
	 * Column Info
	 * @param slpIssInterCoCd
	 */
	public void setSlpIssInterCoCd(String slpIssInterCoCd) {
		this.slpIssInterCoCd = slpIssInterCoCd;
	}
	
	/**
	 * Column Info
	 * @param vndrCustSeq
	 */
	public void setVndrCustSeq(String vndrCustSeq) {
		this.vndrCustSeq = vndrCustSeq;
	}
	
	/**
	 * Column Info
	 * @param ifFlg
	 */
	public void setIfFlg(String ifFlg) {
		this.ifFlg = ifFlg;
	}
	
	/**
	 * Column Info
	 * @param aproDt
	 */
	public void setAproDt(String aproDt) {
		this.aproDt = aproDt;
	}
	
	/**
	 * Column Info
	 * @param lglEngNm
	 */
	public void setLglEngNm(String lglEngNm) {
		this.lglEngNm = lglEngNm;
	}
	
	/**
	 * Column Info
	 * @param csrLoclAmt
	 */
	public void setCsrLoclAmt(String csrLoclAmt) {
		this.csrLoclAmt = csrLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param acctYrmon
	 */
	public void setAcctYrmon(String acctYrmon) {
		this.acctYrmon = acctYrmon;
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
	 * @param aproRqstNo
	 */
	public void setAproRqstNo(String aproRqstNo) {
		this.aproRqstNo = aproRqstNo;
	}
	
	/**
	 * Column Info
	 * @param issuer
	 */
	public void setIssuer(String issuer) {
		this.issuer = issuer;
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
	 * @param ddctLoclAmt
	 */
	public void setDdctLoclAmt(String ddctLoclAmt) {
		this.ddctLoclAmt = ddctLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param ddctFlg
	 */
	public void setDdctFlg(String ddctFlg) {
		this.ddctFlg = ddctFlg;
	}
	
	/**
	 * Column Info
	 * @param slpSerNo
	 */
	public void setSlpSerNo(String slpSerNo) {
		this.slpSerNo = slpSerNo;
	}
	
	/**
	 * Column Info
	 * @param stlCmbSeq
	 */
	public void setStlCmbSeq(String stlCmbSeq) {
		this.stlCmbSeq = stlCmbSeq;
	}
	
	/**
	 * Column Info
	 * @param aproStep
	 */
	public void setAproStep(String aproStep) {
		this.aproStep = aproStep;
	}
	
	/**
	 * Column Info
	 * @param orgSlpFuncCd
	 */
	public void setOrgSlpFuncCd(String orgSlpFuncCd) {
		this.orgSlpFuncCd = orgSlpFuncCd;
	}
	
	/**
	 * Column Info
	 * @param evidTpCd
	 */
	public void setEvidTpCd(String evidTpCd) {
		this.evidTpCd = evidTpCd;
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
	 * @param csrLoclCurrCd
	 */
	public void setCsrLoclCurrCd(String csrLoclCurrCd) {
		this.csrLoclCurrCd = csrLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param authCd
	 */
	public void setAuthCd(String authCd) {
		this.authCd = authCd;
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
	 * @param effDtTo
	 */
	public void setEffDtTo(String effDtTo) {
		this.effDtTo = effDtTo;
	}
	
	/**
	 * Column Info
	 * @param cxlDesc
	 */
	public void setCxlDesc(String cxlDesc) {
		this.cxlDesc = cxlDesc;
	}
	
	/**
	 * Column Info
	 * @param orgSlpIssDt
	 */
	public void setOrgSlpIssDt(String orgSlpIssDt) {
		this.orgSlpIssDt = orgSlpIssDt;
	}
	
	/**
	 * Column Info
	 * @param slpIssRgnCd
	 */
	public void setSlpIssRgnCd(String slpIssRgnCd) {
		this.slpIssRgnCd = slpIssRgnCd;
	}
	
	/**
	 * Column Info
	 * @param rqstLoclAmt
	 */
	public void setRqstLoclAmt(String rqstLoclAmt) {
		this.rqstLoclAmt = rqstLoclAmt;
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
	 * @param rqstDt
	 */
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}
	
	/**
	 * Column Info
	 * @param aproRqstSeq
	 */
	public void setAproRqstSeq(String aproRqstSeq) {
		this.aproRqstSeq = aproRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param lstAproFlg
	 */
	public void setLstAproFlg(String lstAproFlg) {
		this.lstAproFlg = lstAproFlg;
	}
	
	/**
	 * Column Info
	 * @param joCrrCd
	 */
	public void setJoCrrCd(String joCrrCd) {
		this.joCrrCd = joCrrCd;
	}
	
	/**
	 * Column Info
	 * @param clzStsCd
	 */
	public void setClzStsCd(String clzStsCd) {
		this.clzStsCd = clzStsCd;
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
	 * @param slpOfcCd
	 */
	public void setSlpOfcCd(String slpOfcCd) {
		this.slpOfcCd = slpOfcCd;
	}
	
	/**
	 * Column Info
	 * @param slpIssDt
	 */
	public void setSlpIssDt(String slpIssDt) {
		this.slpIssDt = slpIssDt;
	}
	
	/**
	 * Column Info
	 * @param rjctCmbFlg
	 */
	public void setRjctCmbFlg(String rjctCmbFlg) {
		this.rjctCmbFlg = rjctCmbFlg;
	}
	
	/**
	 * Column Info
	 * @param rjctCsrFlg
	 */
	public void setRjctCsrFlg(String rjctCsrFlg) {
		this.rjctCsrFlg = rjctCsrFlg;
	}
	
	/**
	 * Column Info
	 * @param reDivrCd
	 */
	public void setReDivrCd(String reDivrCd) {
		this.reDivrCd = reDivrCd;
	}
	
	/**
	 * Column Info
	 * @param csrUsdAmt
	 */
	public void setCsrUsdAmt(String csrUsdAmt) {
		this.csrUsdAmt = csrUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param orgSlpOfcCd
	 */
	public void setOrgSlpOfcCd(String orgSlpOfcCd) {
		this.orgSlpOfcCd = orgSlpOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rvsCsrFlg
	 */
	public void setRvsCsrFlg(String rvsCsrFlg) {
		this.rvsCsrFlg = rvsCsrFlg;
	}
	
	/**
	 * Column Info
	 * @param csrOffstNo
	 */
	public void setCsrOffstNo(String csrOffstNo) {
		this.csrOffstNo = csrOffstNo;
	}
	
	/**
	 * Column Info
	 * @param slpIssOfcCd
	 */
	public void setSlpIssOfcCd(String slpIssOfcCd) {
		this.slpIssOfcCd = slpIssOfcCd;
	}
	
	/**
	 * Column Info
	 * @param aproFlgUpdateYn
	 */
	public void setAproFlgUpdateYn(String aproFlgUpdateYn) {
		this.aproFlgUpdateYn = aproFlgUpdateYn;
	}

	/**
	 * Column Info
	 * @param agmtDocNo
	 */
	public void setAgmtDocNo(String agmtDocNo) {
		this.agmtDocNo = agmtDocNo;
	}

	/**
	 * Column Info
	 * @param agmtDocDesc
	 */
	public void setAgmtDocDesc(String agmtDocDesc) {
		this.agmtDocDesc = agmtDocDesc;
	}
	
	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRcvErrRsn(JSPUtil.getParameter(request, "rcv_err_rsn", ""));
		setSlpFuncCd(JSPUtil.getParameter(request, "slp_func_cd", ""));
		setCxlFlg(JSPUtil.getParameter(request, "cxl_flg", ""));
		setCsrDesc(JSPUtil.getParameter(request, "csr_desc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEvidTpNm(JSPUtil.getParameter(request, "evid_tp_nm", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setEffDtFr(JSPUtil.getParameter(request, "eff_dt_fr", ""));
		setOrgSlpSerNo(JSPUtil.getParameter(request, "org_slp_ser_no", ""));
		setRvsCmbFlg(JSPUtil.getParameter(request, "rvs_cmb_flg", ""));
		setSlpTpCd(JSPUtil.getParameter(request, "slp_tp_cd", ""));
		setAproFlg(JSPUtil.getParameter(request, "apro_flg", ""));
		setCsrTpCd(JSPUtil.getParameter(request, "csr_tp_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setOrgSlpTpCd(JSPUtil.getParameter(request, "org_slp_tp_cd", ""));
		setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
		setAuthOfcCd(JSPUtil.getParameter(request, "auth_ofc_cd", ""));
		setDdctDesc(JSPUtil.getParameter(request, "ddct_desc", ""));
		setSlpIssInterCoCd(JSPUtil.getParameter(request, "slp_iss_inter_co_cd", ""));
		setVndrCustSeq(JSPUtil.getParameter(request, "vndr_cust_seq", ""));
		setIfFlg(JSPUtil.getParameter(request, "if_flg", ""));
		setAproDt(JSPUtil.getParameter(request, "apro_dt", ""));
		setLglEngNm(JSPUtil.getParameter(request, "lgl_eng_nm", ""));
		setCsrLoclAmt(JSPUtil.getParameter(request, "csr_locl_amt", ""));
		setAcctYrmon(JSPUtil.getParameter(request, "acct_yrmon", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setAproRqstNo(JSPUtil.getParameter(request, "apro_rqst_no", ""));
		setIssuer(JSPUtil.getParameter(request, "issuer", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setDdctLoclAmt(JSPUtil.getParameter(request, "ddct_locl_amt", ""));
		setDdctFlg(JSPUtil.getParameter(request, "ddct_flg", ""));
		setSlpSerNo(JSPUtil.getParameter(request, "slp_ser_no", ""));
		setStlCmbSeq(JSPUtil.getParameter(request, "stl_cmb_seq", ""));
		setAproStep(JSPUtil.getParameter(request, "apro_step", ""));
		setOrgSlpFuncCd(JSPUtil.getParameter(request, "org_slp_func_cd", ""));
		setEvidTpCd(JSPUtil.getParameter(request, "evid_tp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCsrLoclCurrCd(JSPUtil.getParameter(request, "csr_locl_curr_cd", ""));
		setAuthCd(JSPUtil.getParameter(request, "auth_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDtTo(JSPUtil.getParameter(request, "eff_dt_to", ""));
		setCxlDesc(JSPUtil.getParameter(request, "cxl_desc", ""));
		setOrgSlpIssDt(JSPUtil.getParameter(request, "org_slp_iss_dt", ""));
		setSlpIssRgnCd(JSPUtil.getParameter(request, "slp_iss_rgn_cd", ""));
		setRqstLoclAmt(JSPUtil.getParameter(request, "rqst_locl_amt", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setRqstDt(JSPUtil.getParameter(request, "rqst_dt", ""));
		setAproRqstSeq(JSPUtil.getParameter(request, "apro_rqst_seq", ""));
		setLstAproFlg(JSPUtil.getParameter(request, "lst_apro_flg", ""));
		setJoCrrCd(JSPUtil.getParameter(request, "jo_crr_cd", ""));
		setClzStsCd(JSPUtil.getParameter(request, "clz_sts_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setSlpOfcCd(JSPUtil.getParameter(request, "slp_ofc_cd", ""));
		setSlpIssDt(JSPUtil.getParameter(request, "slp_iss_dt", ""));
		setRjctCmbFlg(JSPUtil.getParameter(request, "rjct_cmb_flg", ""));
		setRjctCsrFlg(JSPUtil.getParameter(request, "rjct_csr_flg", ""));
		setReDivrCd(JSPUtil.getParameter(request, "re_divr_cd", ""));
		setCsrUsdAmt(JSPUtil.getParameter(request, "csr_usd_amt", ""));
		setOrgSlpOfcCd(JSPUtil.getParameter(request, "org_slp_ofc_cd", ""));
		setRvsCsrFlg(JSPUtil.getParameter(request, "rvs_csr_flg", ""));
		setCsrOffstNo(JSPUtil.getParameter(request, "csr_offst_no", ""));
		setSlpIssOfcCd(JSPUtil.getParameter(request, "slp_iss_ofc_cd", ""));
		setAproFlgUpdateYn(JSPUtil.getParameter(request, "apro_flg_update_yn", ""));
		setAgmtDocNo(JSPUtil.getParameter(request, "agmt_doc_no", ""));
		setAgmtDocDesc(JSPUtil.getParameter(request, "agmt_doc_desc", ""));		
				
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSlipApprovalCsrVO[]
	 */
	public SearchSlipApprovalCsrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSlipApprovalCsrVO[]
	 */
	public SearchSlipApprovalCsrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSlipApprovalCsrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rcvErrRsn = (JSPUtil.getParameter(request, prefix	+ "rcv_err_rsn", length));
			String[] slpFuncCd = (JSPUtil.getParameter(request, prefix	+ "slp_func_cd", length));
			String[] cxlFlg = (JSPUtil.getParameter(request, prefix	+ "cxl_flg", length));
			String[] csrDesc = (JSPUtil.getParameter(request, prefix	+ "csr_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] evidTpNm = (JSPUtil.getParameter(request, prefix	+ "evid_tp_nm", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] effDtFr = (JSPUtil.getParameter(request, prefix	+ "eff_dt_fr", length));
			String[] orgSlpSerNo = (JSPUtil.getParameter(request, prefix	+ "org_slp_ser_no", length));
			String[] rvsCmbFlg = (JSPUtil.getParameter(request, prefix	+ "rvs_cmb_flg", length));
			String[] slpTpCd = (JSPUtil.getParameter(request, prefix	+ "slp_tp_cd", length));
			String[] aproFlg = (JSPUtil.getParameter(request, prefix	+ "apro_flg", length));
			String[] csrTpCd = (JSPUtil.getParameter(request, prefix	+ "csr_tp_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] orgSlpTpCd = (JSPUtil.getParameter(request, prefix	+ "org_slp_tp_cd", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] authOfcCd = (JSPUtil.getParameter(request, prefix	+ "auth_ofc_cd", length));
			String[] ddctDesc = (JSPUtil.getParameter(request, prefix	+ "ddct_desc", length));
			String[] slpIssInterCoCd = (JSPUtil.getParameter(request, prefix	+ "slp_iss_inter_co_cd", length));
			String[] vndrCustSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_cust_seq", length));
			String[] ifFlg = (JSPUtil.getParameter(request, prefix	+ "if_flg", length));
			String[] aproDt = (JSPUtil.getParameter(request, prefix	+ "apro_dt", length));
			String[] lglEngNm = (JSPUtil.getParameter(request, prefix	+ "lgl_eng_nm", length));
			String[] csrLoclAmt = (JSPUtil.getParameter(request, prefix	+ "csr_locl_amt", length));
			String[] acctYrmon = (JSPUtil.getParameter(request, prefix	+ "acct_yrmon", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] aproRqstNo = (JSPUtil.getParameter(request, prefix	+ "apro_rqst_no", length));
			String[] issuer = (JSPUtil.getParameter(request, prefix	+ "issuer", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] ddctLoclAmt = (JSPUtil.getParameter(request, prefix	+ "ddct_locl_amt", length));
			String[] ddctFlg = (JSPUtil.getParameter(request, prefix	+ "ddct_flg", length));
			String[] slpSerNo = (JSPUtil.getParameter(request, prefix	+ "slp_ser_no", length));
			String[] stlCmbSeq = (JSPUtil.getParameter(request, prefix	+ "stl_cmb_seq", length));
			String[] aproStep = (JSPUtil.getParameter(request, prefix	+ "apro_step", length));
			String[] orgSlpFuncCd = (JSPUtil.getParameter(request, prefix	+ "org_slp_func_cd", length));
			String[] evidTpCd = (JSPUtil.getParameter(request, prefix	+ "evid_tp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] csrLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "csr_locl_curr_cd", length));
			String[] authCd = (JSPUtil.getParameter(request, prefix	+ "auth_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDtTo = (JSPUtil.getParameter(request, prefix	+ "eff_dt_to", length));
			String[] cxlDesc = (JSPUtil.getParameter(request, prefix	+ "cxl_desc", length));
			String[] orgSlpIssDt = (JSPUtil.getParameter(request, prefix	+ "org_slp_iss_dt", length));
			String[] slpIssRgnCd = (JSPUtil.getParameter(request, prefix	+ "slp_iss_rgn_cd", length));
			String[] rqstLoclAmt = (JSPUtil.getParameter(request, prefix	+ "rqst_locl_amt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] aproRqstSeq = (JSPUtil.getParameter(request, prefix	+ "apro_rqst_seq", length));
			String[] lstAproFlg = (JSPUtil.getParameter(request, prefix	+ "lst_apro_flg", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] clzStsCd = (JSPUtil.getParameter(request, prefix	+ "clz_sts_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] slpOfcCd = (JSPUtil.getParameter(request, prefix	+ "slp_ofc_cd", length));
			String[] slpIssDt = (JSPUtil.getParameter(request, prefix	+ "slp_iss_dt", length));
			String[] rjctCmbFlg = (JSPUtil.getParameter(request, prefix	+ "rjct_cmb_flg", length));
			String[] rjctCsrFlg = (JSPUtil.getParameter(request, prefix	+ "rjct_csr_flg", length));
			String[] reDivrCd = (JSPUtil.getParameter(request, prefix	+ "re_divr_cd", length));
			String[] csrUsdAmt = (JSPUtil.getParameter(request, prefix	+ "csr_usd_amt", length));
			String[] orgSlpOfcCd = (JSPUtil.getParameter(request, prefix	+ "org_slp_ofc_cd", length));
			String[] rvsCsrFlg = (JSPUtil.getParameter(request, prefix	+ "rvs_csr_flg", length));
			String[] csrOffstNo = (JSPUtil.getParameter(request, prefix	+ "csr_offst_no", length));
			String[] slpIssOfcCd = (JSPUtil.getParameter(request, prefix	+ "slp_iss_ofc_cd", length));
			String[] aproFlgUpdateYn = (JSPUtil.getParameter(request, prefix	+ "apro_flg_update_yn", length));		
			String[] agmtDocNo = (JSPUtil.getParameter(request, prefix	+ "agmt_doc_no", length));
			String[] agmtDocDesc = (JSPUtil.getParameter(request, prefix	+ "agmt_doc_desc", length));			
									
			for (int i = 0; i < length; i++) {
				model = new SearchSlipApprovalCsrVO();
				if (rcvErrRsn[i] != null)
					model.setRcvErrRsn(rcvErrRsn[i]);
				if (slpFuncCd[i] != null)
					model.setSlpFuncCd(slpFuncCd[i]);
				if (cxlFlg[i] != null)
					model.setCxlFlg(cxlFlg[i]);
				if (csrDesc[i] != null)
					model.setCsrDesc(csrDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (evidTpNm[i] != null)
					model.setEvidTpNm(evidTpNm[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (effDtFr[i] != null)
					model.setEffDtFr(effDtFr[i]);
				if (orgSlpSerNo[i] != null)
					model.setOrgSlpSerNo(orgSlpSerNo[i]);
				if (rvsCmbFlg[i] != null)
					model.setRvsCmbFlg(rvsCmbFlg[i]);
				if (slpTpCd[i] != null)
					model.setSlpTpCd(slpTpCd[i]);
				if (aproFlg[i] != null)
					model.setAproFlg(aproFlg[i]);
				if (csrTpCd[i] != null)
					model.setCsrTpCd(csrTpCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (orgSlpTpCd[i] != null)
					model.setOrgSlpTpCd(orgSlpTpCd[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (authOfcCd[i] != null)
					model.setAuthOfcCd(authOfcCd[i]);
				if (ddctDesc[i] != null)
					model.setDdctDesc(ddctDesc[i]);
				if (slpIssInterCoCd[i] != null)
					model.setSlpIssInterCoCd(slpIssInterCoCd[i]);
				if (vndrCustSeq[i] != null)
					model.setVndrCustSeq(vndrCustSeq[i]);
				if (ifFlg[i] != null)
					model.setIfFlg(ifFlg[i]);
				if (aproDt[i] != null)
					model.setAproDt(aproDt[i]);
				if (lglEngNm[i] != null)
					model.setLglEngNm(lglEngNm[i]);
				if (csrLoclAmt[i] != null)
					model.setCsrLoclAmt(csrLoclAmt[i]);
				if (acctYrmon[i] != null)
					model.setAcctYrmon(acctYrmon[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (aproRqstNo[i] != null)
					model.setAproRqstNo(aproRqstNo[i]);
				if (issuer[i] != null)
					model.setIssuer(issuer[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (ddctLoclAmt[i] != null)
					model.setDdctLoclAmt(ddctLoclAmt[i]);
				if (ddctFlg[i] != null)
					model.setDdctFlg(ddctFlg[i]);
				if (slpSerNo[i] != null)
					model.setSlpSerNo(slpSerNo[i]);
				if (stlCmbSeq[i] != null)
					model.setStlCmbSeq(stlCmbSeq[i]);
				if (aproStep[i] != null)
					model.setAproStep(aproStep[i]);
				if (orgSlpFuncCd[i] != null)
					model.setOrgSlpFuncCd(orgSlpFuncCd[i]);
				if (evidTpCd[i] != null)
					model.setEvidTpCd(evidTpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (csrLoclCurrCd[i] != null)
					model.setCsrLoclCurrCd(csrLoclCurrCd[i]);
				if (authCd[i] != null)
					model.setAuthCd(authCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDtTo[i] != null)
					model.setEffDtTo(effDtTo[i]);
				if (cxlDesc[i] != null)
					model.setCxlDesc(cxlDesc[i]);
				if (orgSlpIssDt[i] != null)
					model.setOrgSlpIssDt(orgSlpIssDt[i]);
				if (slpIssRgnCd[i] != null)
					model.setSlpIssRgnCd(slpIssRgnCd[i]);
				if (rqstLoclAmt[i] != null)
					model.setRqstLoclAmt(rqstLoclAmt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (aproRqstSeq[i] != null)
					model.setAproRqstSeq(aproRqstSeq[i]);
				if (lstAproFlg[i] != null)
					model.setLstAproFlg(lstAproFlg[i]);
				if (joCrrCd[i] != null)
					model.setJoCrrCd(joCrrCd[i]);
				if (clzStsCd[i] != null)
					model.setClzStsCd(clzStsCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (slpOfcCd[i] != null)
					model.setSlpOfcCd(slpOfcCd[i]);
				if (slpIssDt[i] != null)
					model.setSlpIssDt(slpIssDt[i]);
				if (rjctCmbFlg[i] != null)
					model.setRjctCmbFlg(rjctCmbFlg[i]);
				if (rjctCsrFlg[i] != null)
					model.setRjctCsrFlg(rjctCsrFlg[i]);
				if (reDivrCd[i] != null)
					model.setReDivrCd(reDivrCd[i]);
				if (csrUsdAmt[i] != null)
					model.setCsrUsdAmt(csrUsdAmt[i]);
				if (orgSlpOfcCd[i] != null)
					model.setOrgSlpOfcCd(orgSlpOfcCd[i]);
				if (rvsCsrFlg[i] != null)
					model.setRvsCsrFlg(rvsCsrFlg[i]);
				if (csrOffstNo[i] != null)
					model.setCsrOffstNo(csrOffstNo[i]);
				if (slpIssOfcCd[i] != null)
					model.setSlpIssOfcCd(slpIssOfcCd[i]);
				if (aproFlgUpdateYn[i] != null)
					model.setAproFlgUpdateYn(aproFlgUpdateYn[i]);
				if (agmtDocNo[i] != null)
					model.setAgmtDocNo(agmtDocNo[i]);
				if (agmtDocDesc[i] != null)
					model.setAgmtDocDesc(agmtDocDesc[i]);

				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSlipApprovalCsrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSlipApprovalCsrVO[]
	 */
	public SearchSlipApprovalCsrVO[] getSearchSlipApprovalCsrVOs(){
		SearchSlipApprovalCsrVO[] vos = (SearchSlipApprovalCsrVO[])models.toArray(new SearchSlipApprovalCsrVO[models.size()]);
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
		this.rcvErrRsn = this.rcvErrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpFuncCd = this.slpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlFlg = this.cxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrDesc = this.csrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evidTpNm = this.evidTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDtFr = this.effDtFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpSerNo = this.orgSlpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvsCmbFlg = this.rvsCmbFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpTpCd = this.slpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproFlg = this.aproFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrTpCd = this.csrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpTpCd = this.orgSlpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authOfcCd = this.authOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddctDesc = this.ddctDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpIssInterCoCd = this.slpIssInterCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCustSeq = this.vndrCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifFlg = this.ifFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDt = this.aproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lglEngNm = this.lglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrLoclAmt = this.csrLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctYrmon = this.acctYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRqstNo = this.aproRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issuer = this.issuer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddctLoclAmt = this.ddctLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddctFlg = this.ddctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSerNo = this.slpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlCmbSeq = this.stlCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproStep = this.aproStep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpFuncCd = this.orgSlpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evidTpCd = this.evidTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrLoclCurrCd = this.csrLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authCd = this.authCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDtTo = this.effDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlDesc = this.cxlDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpIssDt = this.orgSlpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpIssRgnCd = this.slpIssRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstLoclAmt = this.rqstLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRqstSeq = this.aproRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstAproFlg = this.lstAproFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clzStsCd = this.clzStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpOfcCd = this.slpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpIssDt = this.slpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rjctCmbFlg = this.rjctCmbFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rjctCsrFlg = this.rjctCsrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reDivrCd = this.reDivrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrUsdAmt = this.csrUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpOfcCd = this.orgSlpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvsCsrFlg = this.rvsCsrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrOffstNo = this.csrOffstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpIssOfcCd = this.slpIssOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproFlgUpdateYn = this.aproFlgUpdateYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.agmtDocNo = this.agmtDocNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtDocDesc = this.agmtDocDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
	}
}
