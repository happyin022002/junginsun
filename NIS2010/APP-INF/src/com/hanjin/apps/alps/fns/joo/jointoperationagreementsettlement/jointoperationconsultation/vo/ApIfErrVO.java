/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ApIfErrVO.java
*@FileTitle : ApIfErrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.21
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.01.21 박희동 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo;

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
 * @author 박희동
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ApIfErrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ApIfErrVO> models = new ArrayList<ApIfErrVO>();
	
	/* Column Info */
	private String orgSlpFuncCd = null;
	/* Column Info */
	private String rcvErrRsn = null;
	/* Column Info */
	private String slpFuncCd = null;
	/* Column Info */
	private String csrDesc = null;
	/* Column Info */
	private String cxlFlg = null;
	/* Column Info */
	private String evidTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String csrLoclCurrCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String orgSlpSerNo = null;
	/* Column Info */
	private String cxlDesc = null;
	/* Column Info */
	private String orgSlpIssDt = null;
	/* Column Info */
	private String slpTpCd = null;
	/* Column Info */
	private String slpIssRgnCd = null;
	/* Column Info */
	private String aproFlg = null;
	/* Column Info */
	private String rqstLoclAmt = null;
	/* Column Info */
	private String csrTpCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String ifRcvMsg = null;
	/* Column Info */
	private String orgSlpTpCd = null;
	/* Column Info */
	private String rcvErrFlg = null;
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String ddctDesc = null;
	/* Column Info */
	private String slpIssInterCoCd = null;
	/* Column Info */
	private String joCrrCd = null;
	/* Column Info */
	private String ifFlg = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String aproDt = null;
	/* Column Info */
	private String slpIssDt = null;
	/* Column Info */
	private String slpOfcCd = null;
	/* Column Info */
	private String csrLoclAmt = null;
	/* Column Info */
	private String rjctCsrFlg = null;
	/* Column Info */
	private String acctYrmon = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String reDivrCd = null;
	/* Column Info */
	private String orgSlpOfcCd = null;
	/* Column Info */
	private String csrUsdAmt = null;
	/* Column Info */
	private String ddctLoclAmt = null;
	/* Column Info */
	private String rvsCsrFlg = null;
	/* Column Info */
	private String ddctFlg = null;
	/* Column Info */
	private String slpIssOfcCd = null;
	/* Column Info */
	private String csrOffstNo = null;
	/* Column Info */
	private String slpSerNo = null;
	/* Column Info */
	private String stlCmbSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ApIfErrVO() {}

	public ApIfErrVO(String ibflag, String pagerows, String csrNo, String slpTpCd, String slpFuncCd, String slpOfcCd, String slpIssDt, String slpSerNo, String vndrSeq, String custCntCd, String custSeq, String slpIssOfcCd, String csrDesc, String csrLoclCurrCd, String csrLoclAmt, String csrUsdAmt, String effDt, String evidTpCd, String aproFlg, String aproDt, String cxlFlg, String cxlDesc, String csrOffstNo, String ddctFlg, String ddctLoclAmt, String ddctDesc, String rqstLoclAmt, String rqstDt, String csrTpCd, String slpIssRgnCd, String slpIssInterCoCd, String rvsCsrFlg, String rjctCsrFlg, String orgSlpTpCd, String orgSlpFuncCd, String orgSlpOfcCd, String orgSlpIssDt, String orgSlpSerNo, String rcvErrRsn, String acctYrmon, String joCrrCd, String stlCmbSeq, String reDivrCd, String ifFlg, String rcvErrFlg, String ifRcvMsg) {
		this.orgSlpFuncCd = orgSlpFuncCd;
		this.rcvErrRsn = rcvErrRsn;
		this.slpFuncCd = slpFuncCd;
		this.csrDesc = csrDesc;
		this.cxlFlg = cxlFlg;
		this.evidTpCd = evidTpCd;
		this.pagerows = pagerows;
		this.csrLoclCurrCd = csrLoclCurrCd;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.orgSlpSerNo = orgSlpSerNo;
		this.cxlDesc = cxlDesc;
		this.orgSlpIssDt = orgSlpIssDt;
		this.slpTpCd = slpTpCd;
		this.slpIssRgnCd = slpIssRgnCd;
		this.aproFlg = aproFlg;
		this.rqstLoclAmt = rqstLoclAmt;
		this.csrTpCd = csrTpCd;
		this.custCntCd = custCntCd;
		this.ifRcvMsg = ifRcvMsg;
		this.orgSlpTpCd = orgSlpTpCd;
		this.rcvErrFlg = rcvErrFlg;
		this.rqstDt = rqstDt;
		this.csrNo = csrNo;
		this.ddctDesc = ddctDesc;
		this.slpIssInterCoCd = slpIssInterCoCd;
		this.joCrrCd = joCrrCd;
		this.ifFlg = ifFlg;
		this.custSeq = custSeq;
		this.aproDt = aproDt;
		this.slpIssDt = slpIssDt;
		this.slpOfcCd = slpOfcCd;
		this.csrLoclAmt = csrLoclAmt;
		this.rjctCsrFlg = rjctCsrFlg;
		this.acctYrmon = acctYrmon;
		this.vndrSeq = vndrSeq;
		this.reDivrCd = reDivrCd;
		this.orgSlpOfcCd = orgSlpOfcCd;
		this.csrUsdAmt = csrUsdAmt;
		this.ddctLoclAmt = ddctLoclAmt;
		this.rvsCsrFlg = rvsCsrFlg;
		this.ddctFlg = ddctFlg;
		this.slpIssOfcCd = slpIssOfcCd;
		this.csrOffstNo = csrOffstNo;
		this.slpSerNo = slpSerNo;
		this.stlCmbSeq = stlCmbSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("org_slp_func_cd", getOrgSlpFuncCd());
		this.hashColumns.put("rcv_err_rsn", getRcvErrRsn());
		this.hashColumns.put("slp_func_cd", getSlpFuncCd());
		this.hashColumns.put("csr_desc", getCsrDesc());
		this.hashColumns.put("cxl_flg", getCxlFlg());
		this.hashColumns.put("evid_tp_cd", getEvidTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("csr_locl_curr_cd", getCsrLoclCurrCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("org_slp_ser_no", getOrgSlpSerNo());
		this.hashColumns.put("cxl_desc", getCxlDesc());
		this.hashColumns.put("org_slp_iss_dt", getOrgSlpIssDt());
		this.hashColumns.put("slp_tp_cd", getSlpTpCd());
		this.hashColumns.put("slp_iss_rgn_cd", getSlpIssRgnCd());
		this.hashColumns.put("apro_flg", getAproFlg());
		this.hashColumns.put("rqst_locl_amt", getRqstLoclAmt());
		this.hashColumns.put("csr_tp_cd", getCsrTpCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("if_rcv_msg", getIfRcvMsg());
		this.hashColumns.put("org_slp_tp_cd", getOrgSlpTpCd());
		this.hashColumns.put("rcv_err_flg", getRcvErrFlg());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("ddct_desc", getDdctDesc());
		this.hashColumns.put("slp_iss_inter_co_cd", getSlpIssInterCoCd());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("if_flg", getIfFlg());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("apro_dt", getAproDt());
		this.hashColumns.put("slp_iss_dt", getSlpIssDt());
		this.hashColumns.put("slp_ofc_cd", getSlpOfcCd());
		this.hashColumns.put("csr_locl_amt", getCsrLoclAmt());
		this.hashColumns.put("rjct_csr_flg", getRjctCsrFlg());
		this.hashColumns.put("acct_yrmon", getAcctYrmon());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("re_divr_cd", getReDivrCd());
		this.hashColumns.put("org_slp_ofc_cd", getOrgSlpOfcCd());
		this.hashColumns.put("csr_usd_amt", getCsrUsdAmt());
		this.hashColumns.put("ddct_locl_amt", getDdctLoclAmt());
		this.hashColumns.put("rvs_csr_flg", getRvsCsrFlg());
		this.hashColumns.put("ddct_flg", getDdctFlg());
		this.hashColumns.put("slp_iss_ofc_cd", getSlpIssOfcCd());
		this.hashColumns.put("csr_offst_no", getCsrOffstNo());
		this.hashColumns.put("slp_ser_no", getSlpSerNo());
		this.hashColumns.put("stl_cmb_seq", getStlCmbSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("org_slp_func_cd", "orgSlpFuncCd");
		this.hashFields.put("rcv_err_rsn", "rcvErrRsn");
		this.hashFields.put("slp_func_cd", "slpFuncCd");
		this.hashFields.put("csr_desc", "csrDesc");
		this.hashFields.put("cxl_flg", "cxlFlg");
		this.hashFields.put("evid_tp_cd", "evidTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("csr_locl_curr_cd", "csrLoclCurrCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("org_slp_ser_no", "orgSlpSerNo");
		this.hashFields.put("cxl_desc", "cxlDesc");
		this.hashFields.put("org_slp_iss_dt", "orgSlpIssDt");
		this.hashFields.put("slp_tp_cd", "slpTpCd");
		this.hashFields.put("slp_iss_rgn_cd", "slpIssRgnCd");
		this.hashFields.put("apro_flg", "aproFlg");
		this.hashFields.put("rqst_locl_amt", "rqstLoclAmt");
		this.hashFields.put("csr_tp_cd", "csrTpCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("if_rcv_msg", "ifRcvMsg");
		this.hashFields.put("org_slp_tp_cd", "orgSlpTpCd");
		this.hashFields.put("rcv_err_flg", "rcvErrFlg");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("ddct_desc", "ddctDesc");
		this.hashFields.put("slp_iss_inter_co_cd", "slpIssInterCoCd");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("if_flg", "ifFlg");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("apro_dt", "aproDt");
		this.hashFields.put("slp_iss_dt", "slpIssDt");
		this.hashFields.put("slp_ofc_cd", "slpOfcCd");
		this.hashFields.put("csr_locl_amt", "csrLoclAmt");
		this.hashFields.put("rjct_csr_flg", "rjctCsrFlg");
		this.hashFields.put("acct_yrmon", "acctYrmon");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("re_divr_cd", "reDivrCd");
		this.hashFields.put("org_slp_ofc_cd", "orgSlpOfcCd");
		this.hashFields.put("csr_usd_amt", "csrUsdAmt");
		this.hashFields.put("ddct_locl_amt", "ddctLoclAmt");
		this.hashFields.put("rvs_csr_flg", "rvsCsrFlg");
		this.hashFields.put("ddct_flg", "ddctFlg");
		this.hashFields.put("slp_iss_ofc_cd", "slpIssOfcCd");
		this.hashFields.put("csr_offst_no", "csrOffstNo");
		this.hashFields.put("slp_ser_no", "slpSerNo");
		this.hashFields.put("stl_cmb_seq", "stlCmbSeq");
		return this.hashFields;
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
	 * @return csrDesc
	 */
	public String getCsrDesc() {
		return this.csrDesc;
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
	 * @return evidTpCd
	 */
	public String getEvidTpCd() {
		return this.evidTpCd;
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
	 * @return csrLoclCurrCd
	 */
	public String getCsrLoclCurrCd() {
		return this.csrLoclCurrCd;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return slpTpCd
	 */
	public String getSlpTpCd() {
		return this.slpTpCd;
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
	 * @return aproFlg
	 */
	public String getAproFlg() {
		return this.aproFlg;
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
	 * @return ifRcvMsg
	 */
	public String getIfRcvMsg() {
		return this.ifRcvMsg;
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
	 * @return rcvErrFlg
	 */
	public String getRcvErrFlg() {
		return this.rcvErrFlg;
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
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
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
	 * @return joCrrCd
	 */
	public String getJoCrrCd() {
		return this.joCrrCd;
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
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
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
	 * @return slpIssDt
	 */
	public String getSlpIssDt() {
		return this.slpIssDt;
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
	 * @return csrLoclAmt
	 */
	public String getCsrLoclAmt() {
		return this.csrLoclAmt;
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
	 * @return acctYrmon
	 */
	public String getAcctYrmon() {
		return this.acctYrmon;
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
	 * @return reDivrCd
	 */
	public String getReDivrCd() {
		return this.reDivrCd;
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
	 * @return csrUsdAmt
	 */
	public String getCsrUsdAmt() {
		return this.csrUsdAmt;
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
	 * @return rvsCsrFlg
	 */
	public String getRvsCsrFlg() {
		return this.rvsCsrFlg;
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
	 * @return slpIssOfcCd
	 */
	public String getSlpIssOfcCd() {
		return this.slpIssOfcCd;
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
	 * @param orgSlpFuncCd
	 */
	public void setOrgSlpFuncCd(String orgSlpFuncCd) {
		this.orgSlpFuncCd = orgSlpFuncCd;
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
	 * @param csrDesc
	 */
	public void setCsrDesc(String csrDesc) {
		this.csrDesc = csrDesc;
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
	 * @param evidTpCd
	 */
	public void setEvidTpCd(String evidTpCd) {
		this.evidTpCd = evidTpCd;
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
	 * @param csrLoclCurrCd
	 */
	public void setCsrLoclCurrCd(String csrLoclCurrCd) {
		this.csrLoclCurrCd = csrLoclCurrCd;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param slpTpCd
	 */
	public void setSlpTpCd(String slpTpCd) {
		this.slpTpCd = slpTpCd;
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
	 * @param aproFlg
	 */
	public void setAproFlg(String aproFlg) {
		this.aproFlg = aproFlg;
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
	 * @param ifRcvMsg
	 */
	public void setIfRcvMsg(String ifRcvMsg) {
		this.ifRcvMsg = ifRcvMsg;
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
	 * @param rcvErrFlg
	 */
	public void setRcvErrFlg(String rcvErrFlg) {
		this.rcvErrFlg = rcvErrFlg;
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
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
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
	 * @param joCrrCd
	 */
	public void setJoCrrCd(String joCrrCd) {
		this.joCrrCd = joCrrCd;
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
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
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
	 * @param slpIssDt
	 */
	public void setSlpIssDt(String slpIssDt) {
		this.slpIssDt = slpIssDt;
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
	 * @param csrLoclAmt
	 */
	public void setCsrLoclAmt(String csrLoclAmt) {
		this.csrLoclAmt = csrLoclAmt;
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
	 * @param acctYrmon
	 */
	public void setAcctYrmon(String acctYrmon) {
		this.acctYrmon = acctYrmon;
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
	 * @param reDivrCd
	 */
	public void setReDivrCd(String reDivrCd) {
		this.reDivrCd = reDivrCd;
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
	 * @param csrUsdAmt
	 */
	public void setCsrUsdAmt(String csrUsdAmt) {
		this.csrUsdAmt = csrUsdAmt;
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
	 * @param rvsCsrFlg
	 */
	public void setRvsCsrFlg(String rvsCsrFlg) {
		this.rvsCsrFlg = rvsCsrFlg;
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
	 * @param slpIssOfcCd
	 */
	public void setSlpIssOfcCd(String slpIssOfcCd) {
		this.slpIssOfcCd = slpIssOfcCd;
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
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOrgSlpFuncCd(JSPUtil.getParameter(request, "org_slp_func_cd", ""));
		setRcvErrRsn(JSPUtil.getParameter(request, "rcv_err_rsn", ""));
		setSlpFuncCd(JSPUtil.getParameter(request, "slp_func_cd", ""));
		setCsrDesc(JSPUtil.getParameter(request, "csr_desc", ""));
		setCxlFlg(JSPUtil.getParameter(request, "cxl_flg", ""));
		setEvidTpCd(JSPUtil.getParameter(request, "evid_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCsrLoclCurrCd(JSPUtil.getParameter(request, "csr_locl_curr_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setOrgSlpSerNo(JSPUtil.getParameter(request, "org_slp_ser_no", ""));
		setCxlDesc(JSPUtil.getParameter(request, "cxl_desc", ""));
		setOrgSlpIssDt(JSPUtil.getParameter(request, "org_slp_iss_dt", ""));
		setSlpTpCd(JSPUtil.getParameter(request, "slp_tp_cd", ""));
		setSlpIssRgnCd(JSPUtil.getParameter(request, "slp_iss_rgn_cd", ""));
		setAproFlg(JSPUtil.getParameter(request, "apro_flg", ""));
		setRqstLoclAmt(JSPUtil.getParameter(request, "rqst_locl_amt", ""));
		setCsrTpCd(JSPUtil.getParameter(request, "csr_tp_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setIfRcvMsg(JSPUtil.getParameter(request, "if_rcv_msg", ""));
		setOrgSlpTpCd(JSPUtil.getParameter(request, "org_slp_tp_cd", ""));
		setRcvErrFlg(JSPUtil.getParameter(request, "rcv_err_flg", ""));
		setRqstDt(JSPUtil.getParameter(request, "rqst_dt", ""));
		setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
		setDdctDesc(JSPUtil.getParameter(request, "ddct_desc", ""));
		setSlpIssInterCoCd(JSPUtil.getParameter(request, "slp_iss_inter_co_cd", ""));
		setJoCrrCd(JSPUtil.getParameter(request, "jo_crr_cd", ""));
		setIfFlg(JSPUtil.getParameter(request, "if_flg", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setAproDt(JSPUtil.getParameter(request, "apro_dt", ""));
		setSlpIssDt(JSPUtil.getParameter(request, "slp_iss_dt", ""));
		setSlpOfcCd(JSPUtil.getParameter(request, "slp_ofc_cd", ""));
		setCsrLoclAmt(JSPUtil.getParameter(request, "csr_locl_amt", ""));
		setRjctCsrFlg(JSPUtil.getParameter(request, "rjct_csr_flg", ""));
		setAcctYrmon(JSPUtil.getParameter(request, "acct_yrmon", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setReDivrCd(JSPUtil.getParameter(request, "re_divr_cd", ""));
		setOrgSlpOfcCd(JSPUtil.getParameter(request, "org_slp_ofc_cd", ""));
		setCsrUsdAmt(JSPUtil.getParameter(request, "csr_usd_amt", ""));
		setDdctLoclAmt(JSPUtil.getParameter(request, "ddct_locl_amt", ""));
		setRvsCsrFlg(JSPUtil.getParameter(request, "rvs_csr_flg", ""));
		setDdctFlg(JSPUtil.getParameter(request, "ddct_flg", ""));
		setSlpIssOfcCd(JSPUtil.getParameter(request, "slp_iss_ofc_cd", ""));
		setCsrOffstNo(JSPUtil.getParameter(request, "csr_offst_no", ""));
		setSlpSerNo(JSPUtil.getParameter(request, "slp_ser_no", ""));
		setStlCmbSeq(JSPUtil.getParameter(request, "stl_cmb_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ApIfErrVO[]
	 */
	public ApIfErrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ApIfErrVO[]
	 */
	public ApIfErrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ApIfErrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] orgSlpFuncCd = (JSPUtil.getParameter(request, prefix	+ "org_slp_func_cd", length));
			String[] rcvErrRsn = (JSPUtil.getParameter(request, prefix	+ "rcv_err_rsn", length));
			String[] slpFuncCd = (JSPUtil.getParameter(request, prefix	+ "slp_func_cd", length));
			String[] csrDesc = (JSPUtil.getParameter(request, prefix	+ "csr_desc", length));
			String[] cxlFlg = (JSPUtil.getParameter(request, prefix	+ "cxl_flg", length));
			String[] evidTpCd = (JSPUtil.getParameter(request, prefix	+ "evid_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] csrLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "csr_locl_curr_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] orgSlpSerNo = (JSPUtil.getParameter(request, prefix	+ "org_slp_ser_no", length));
			String[] cxlDesc = (JSPUtil.getParameter(request, prefix	+ "cxl_desc", length));
			String[] orgSlpIssDt = (JSPUtil.getParameter(request, prefix	+ "org_slp_iss_dt", length));
			String[] slpTpCd = (JSPUtil.getParameter(request, prefix	+ "slp_tp_cd", length));
			String[] slpIssRgnCd = (JSPUtil.getParameter(request, prefix	+ "slp_iss_rgn_cd", length));
			String[] aproFlg = (JSPUtil.getParameter(request, prefix	+ "apro_flg", length));
			String[] rqstLoclAmt = (JSPUtil.getParameter(request, prefix	+ "rqst_locl_amt", length));
			String[] csrTpCd = (JSPUtil.getParameter(request, prefix	+ "csr_tp_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] ifRcvMsg = (JSPUtil.getParameter(request, prefix	+ "if_rcv_msg", length));
			String[] orgSlpTpCd = (JSPUtil.getParameter(request, prefix	+ "org_slp_tp_cd", length));
			String[] rcvErrFlg = (JSPUtil.getParameter(request, prefix	+ "rcv_err_flg", length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] ddctDesc = (JSPUtil.getParameter(request, prefix	+ "ddct_desc", length));
			String[] slpIssInterCoCd = (JSPUtil.getParameter(request, prefix	+ "slp_iss_inter_co_cd", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] ifFlg = (JSPUtil.getParameter(request, prefix	+ "if_flg", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] aproDt = (JSPUtil.getParameter(request, prefix	+ "apro_dt", length));
			String[] slpIssDt = (JSPUtil.getParameter(request, prefix	+ "slp_iss_dt", length));
			String[] slpOfcCd = (JSPUtil.getParameter(request, prefix	+ "slp_ofc_cd", length));
			String[] csrLoclAmt = (JSPUtil.getParameter(request, prefix	+ "csr_locl_amt", length));
			String[] rjctCsrFlg = (JSPUtil.getParameter(request, prefix	+ "rjct_csr_flg", length));
			String[] acctYrmon = (JSPUtil.getParameter(request, prefix	+ "acct_yrmon", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] reDivrCd = (JSPUtil.getParameter(request, prefix	+ "re_divr_cd", length));
			String[] orgSlpOfcCd = (JSPUtil.getParameter(request, prefix	+ "org_slp_ofc_cd", length));
			String[] csrUsdAmt = (JSPUtil.getParameter(request, prefix	+ "csr_usd_amt", length));
			String[] ddctLoclAmt = (JSPUtil.getParameter(request, prefix	+ "ddct_locl_amt", length));
			String[] rvsCsrFlg = (JSPUtil.getParameter(request, prefix	+ "rvs_csr_flg", length));
			String[] ddctFlg = (JSPUtil.getParameter(request, prefix	+ "ddct_flg", length));
			String[] slpIssOfcCd = (JSPUtil.getParameter(request, prefix	+ "slp_iss_ofc_cd", length));
			String[] csrOffstNo = (JSPUtil.getParameter(request, prefix	+ "csr_offst_no", length));
			String[] slpSerNo = (JSPUtil.getParameter(request, prefix	+ "slp_ser_no", length));
			String[] stlCmbSeq = (JSPUtil.getParameter(request, prefix	+ "stl_cmb_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new ApIfErrVO();
				if (orgSlpFuncCd[i] != null)
					model.setOrgSlpFuncCd(orgSlpFuncCd[i]);
				if (rcvErrRsn[i] != null)
					model.setRcvErrRsn(rcvErrRsn[i]);
				if (slpFuncCd[i] != null)
					model.setSlpFuncCd(slpFuncCd[i]);
				if (csrDesc[i] != null)
					model.setCsrDesc(csrDesc[i]);
				if (cxlFlg[i] != null)
					model.setCxlFlg(cxlFlg[i]);
				if (evidTpCd[i] != null)
					model.setEvidTpCd(evidTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (csrLoclCurrCd[i] != null)
					model.setCsrLoclCurrCd(csrLoclCurrCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (orgSlpSerNo[i] != null)
					model.setOrgSlpSerNo(orgSlpSerNo[i]);
				if (cxlDesc[i] != null)
					model.setCxlDesc(cxlDesc[i]);
				if (orgSlpIssDt[i] != null)
					model.setOrgSlpIssDt(orgSlpIssDt[i]);
				if (slpTpCd[i] != null)
					model.setSlpTpCd(slpTpCd[i]);
				if (slpIssRgnCd[i] != null)
					model.setSlpIssRgnCd(slpIssRgnCd[i]);
				if (aproFlg[i] != null)
					model.setAproFlg(aproFlg[i]);
				if (rqstLoclAmt[i] != null)
					model.setRqstLoclAmt(rqstLoclAmt[i]);
				if (csrTpCd[i] != null)
					model.setCsrTpCd(csrTpCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (ifRcvMsg[i] != null)
					model.setIfRcvMsg(ifRcvMsg[i]);
				if (orgSlpTpCd[i] != null)
					model.setOrgSlpTpCd(orgSlpTpCd[i]);
				if (rcvErrFlg[i] != null)
					model.setRcvErrFlg(rcvErrFlg[i]);
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (ddctDesc[i] != null)
					model.setDdctDesc(ddctDesc[i]);
				if (slpIssInterCoCd[i] != null)
					model.setSlpIssInterCoCd(slpIssInterCoCd[i]);
				if (joCrrCd[i] != null)
					model.setJoCrrCd(joCrrCd[i]);
				if (ifFlg[i] != null)
					model.setIfFlg(ifFlg[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (aproDt[i] != null)
					model.setAproDt(aproDt[i]);
				if (slpIssDt[i] != null)
					model.setSlpIssDt(slpIssDt[i]);
				if (slpOfcCd[i] != null)
					model.setSlpOfcCd(slpOfcCd[i]);
				if (csrLoclAmt[i] != null)
					model.setCsrLoclAmt(csrLoclAmt[i]);
				if (rjctCsrFlg[i] != null)
					model.setRjctCsrFlg(rjctCsrFlg[i]);
				if (acctYrmon[i] != null)
					model.setAcctYrmon(acctYrmon[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (reDivrCd[i] != null)
					model.setReDivrCd(reDivrCd[i]);
				if (orgSlpOfcCd[i] != null)
					model.setOrgSlpOfcCd(orgSlpOfcCd[i]);
				if (csrUsdAmt[i] != null)
					model.setCsrUsdAmt(csrUsdAmt[i]);
				if (ddctLoclAmt[i] != null)
					model.setDdctLoclAmt(ddctLoclAmt[i]);
				if (rvsCsrFlg[i] != null)
					model.setRvsCsrFlg(rvsCsrFlg[i]);
				if (ddctFlg[i] != null)
					model.setDdctFlg(ddctFlg[i]);
				if (slpIssOfcCd[i] != null)
					model.setSlpIssOfcCd(slpIssOfcCd[i]);
				if (csrOffstNo[i] != null)
					model.setCsrOffstNo(csrOffstNo[i]);
				if (slpSerNo[i] != null)
					model.setSlpSerNo(slpSerNo[i]);
				if (stlCmbSeq[i] != null)
					model.setStlCmbSeq(stlCmbSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getApIfErrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ApIfErrVO[]
	 */
	public ApIfErrVO[] getApIfErrVOs(){
		ApIfErrVO[] vos = (ApIfErrVO[])models.toArray(new ApIfErrVO[models.size()]);
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
		this.orgSlpFuncCd = this.orgSlpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvErrRsn = this.rcvErrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpFuncCd = this.slpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrDesc = this.csrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlFlg = this.cxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evidTpCd = this.evidTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrLoclCurrCd = this.csrLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpSerNo = this.orgSlpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlDesc = this.cxlDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpIssDt = this.orgSlpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpTpCd = this.slpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpIssRgnCd = this.slpIssRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproFlg = this.aproFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstLoclAmt = this.rqstLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrTpCd = this.csrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifRcvMsg = this.ifRcvMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpTpCd = this.orgSlpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvErrFlg = this.rcvErrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddctDesc = this.ddctDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpIssInterCoCd = this.slpIssInterCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifFlg = this.ifFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDt = this.aproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpIssDt = this.slpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpOfcCd = this.slpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrLoclAmt = this.csrLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rjctCsrFlg = this.rjctCsrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctYrmon = this.acctYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reDivrCd = this.reDivrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpOfcCd = this.orgSlpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrUsdAmt = this.csrUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddctLoclAmt = this.ddctLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvsCsrFlg = this.rvsCsrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddctFlg = this.ddctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpIssOfcCd = this.slpIssOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrOffstNo = this.csrOffstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSerNo = this.slpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlCmbSeq = this.stlCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
