/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SPCLCmpnApprovalMasterVO.java
*@FileTitle : SPCLCmpnApprovalMasterVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.16
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.08.16 김봉균
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.acm.acmapproval.spclcmpnapproval.vo;

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
 * @author 김봉균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SPCLCmpnApprovalMasterVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<SPCLCmpnApprovalMasterVO> models = new ArrayList<SPCLCmpnApprovalMasterVO>();

	/* Column Info */
	private String ifDt = null;
	/* Column Info */
	private String aproStep = null;
	/* Column Info */
	private String dateFm = null;
	/* Column Info */
	private String payDt = null;
	/* Column Info */
	private String totAmt = null;
	/* Column Info */
	private String ifOpt = null;
	/* Column Info */
	private String ifDate = null;
	/* Column Info */
	private String vat = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String ffCntSeq = null;
	/* Column Info */
	private String fwdrName = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invDesc = null;
	/* Column Info */
	private String netAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String payAmt = null;
	/* Column Info */
	private String dateDiv = null;
	/* Column Info */
	private String usrEml = null;
	/* Column Info */
	private String ftuUseCtnt1 = null;
	/* Column Info */
	private String invTaxRt = null;
	/* Column Info */
	private String invDt = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String vndrTermNm = null;
	/* Column Info */
	private String apOfcCd = null;
	/* Column Info */
	private String totCnt = null;
	/* Column Info */
	private String dateTo = null;
	/* Column Info */
	private String ifFlg = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String rcvFlg = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String custCntSeq = null;
	/* Column Info */
	private String ifRsn = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String payMzdLuCd = null;
	/* Column Info */
	private String rcvRsn = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String coaInterCompyCd = null;
	/* Column Info */
	private String rqstUsrId = null;
	/* Column Info */
	private String rqstUsrNm = null;
	/* Column Info */
	private String aproUsrId = null;
	/* Column Info */
	private String aproUsrNm = null;
	/* Column Info */
	private String asaNo = null;
	/* Column Info */
	private String payXchRt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String payTotAmt = null;
	/* Column Info */
	private String spclOfcCd = null;
	/* Column Info */
	private String spclCmpnSeq = null;
	/* Column Info */
	private String spclCmpnStsCd = null;
	/* Column Info */
	private String spclAgmtSeq = null;
	/* Column Info */
	private String csrCreDt = null;
	
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public SPCLCmpnApprovalMasterVO() {}

	public SPCLCmpnApprovalMasterVO(String ibflag, String pagerows, String dateFm, String payDt, String totAmt, String ifOpt, String ifDate, String vat, String blNo, String ffCntSeq, String fwdrName, String netAmt, String invDesc, String payAmt, String dateDiv, String ftuUseCtnt1, String csrNo, String vndrTermNm, String apOfcCd, String totCnt, String dateTo, String ifFlg, String arOfcCd, String rcvFlg, String ifRsn, String custCntSeq, String rcvRsn, String payMzdLuCd, String vndrSeq, String coaInterCompyCd, String aproStep, String usrId, String usrNm, String usrEml, String invDt, String invTaxRt, String bkgNo, String custLglEngNm, String ifDt, String rqstUsrId, String rqstUsrNm, String aproUsrId, String aproUsrNm, String asaNo, String payXchRt, String currCd, String payTotAmt, String spclOfcCd, String spclCmpnSeq, String spclCmpnStsCd, String spclAgmtSeq, String csrCreDt) {
		this.ifDt = ifDt;
		this.aproStep = aproStep;
		this.dateFm = dateFm;
		this.payDt = payDt;
		this.totAmt = totAmt;
		this.ifOpt = ifOpt;
		this.ifDate = ifDate;
		this.vat = vat;
		this.blNo = blNo;
		this.ffCntSeq = ffCntSeq;
		this.fwdrName = fwdrName;
		this.pagerows = pagerows;
		this.invDesc = invDesc;
		this.netAmt = netAmt;
		this.ibflag = ibflag;
		this.usrNm = usrNm;
		this.usrId = usrId;
		this.payAmt = payAmt;
		this.dateDiv = dateDiv;
		this.usrEml = usrEml;
		this.ftuUseCtnt1 = ftuUseCtnt1;
		this.invTaxRt = invTaxRt;
		this.invDt = invDt;
		this.csrNo = csrNo;
		this.vndrTermNm = vndrTermNm;
		this.apOfcCd = apOfcCd;
		this.totCnt = totCnt;
		this.dateTo = dateTo;
		this.ifFlg = ifFlg;
		this.arOfcCd = arOfcCd;
		this.rcvFlg = rcvFlg;
		this.custLglEngNm = custLglEngNm;
		this.custCntSeq = custCntSeq;
		this.ifRsn = ifRsn;
		this.bkgNo = bkgNo;
		this.payMzdLuCd = payMzdLuCd;
		this.rcvRsn = rcvRsn;
		this.vndrSeq = vndrSeq;
		this.coaInterCompyCd = coaInterCompyCd;
		this.rqstUsrId = rqstUsrId;
		this.rqstUsrNm = rqstUsrNm;
		this.aproUsrId = aproUsrId;
		this.aproUsrNm = aproUsrNm;
		this.asaNo = asaNo;
		this.payXchRt = payXchRt;
		this.currCd = currCd;
		this.payTotAmt = payTotAmt;
		this.spclOfcCd = spclOfcCd;
		this.spclCmpnSeq = spclCmpnSeq;
		this.spclCmpnStsCd = spclCmpnStsCd;
		this.spclAgmtSeq = spclAgmtSeq;
		this.csrCreDt = csrCreDt;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("if_dt", getIfDt());
		this.hashColumns.put("apro_step", getAproStep());
		this.hashColumns.put("date_fm", getDateFm());
		this.hashColumns.put("pay_dt", getPayDt());
		this.hashColumns.put("tot_amt", getTotAmt());
		this.hashColumns.put("if_opt", getIfOpt());
		this.hashColumns.put("if_date", getIfDate());
		this.hashColumns.put("vat", getVat());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("ff_cnt_seq", getFfCntSeq());
		this.hashColumns.put("fwdr_name", getFwdrName());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_desc", getInvDesc());
		this.hashColumns.put("net_amt", getNetAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("pay_amt", getPayAmt());
		this.hashColumns.put("date_div", getDateDiv());
		this.hashColumns.put("usr_eml", getUsrEml());
		this.hashColumns.put("ftu_use_ctnt1", getFtuUseCtnt1());
		this.hashColumns.put("inv_tax_rt", getInvTaxRt());
		this.hashColumns.put("inv_dt", getInvDt());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("vndr_term_nm", getVndrTermNm());
		this.hashColumns.put("ap_ofc_cd", getApOfcCd());
		this.hashColumns.put("tot_cnt", getTotCnt());
		this.hashColumns.put("date_to", getDateTo());	
		this.hashColumns.put("if_flg", getIfFlg());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("rcv_flg", getRcvFlg());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("cust_cnt_seq", getCustCntSeq());
		this.hashColumns.put("if_rsn", getIfRsn());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pay_mzd_lu_cd", getPayMzdLuCd());
		this.hashColumns.put("rcv_rsn", getRcvRsn());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("coa_inter_compy_cd", getCoaInterCompyCd());
		this.hashColumns.put("rqst_usr_id", getRqstUsrId());
		this.hashColumns.put("rqst_usr_nm", getRqstUsrNm());
		this.hashColumns.put("apro_usr_id", getAproUsrId());
		this.hashColumns.put("apro_usr_nm", getAproUsrNm());
		this.hashColumns.put("asa_no", getAsaNo());
		this.hashColumns.put("pay_xch_rt", getPayXchRt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("pay_tot_amt", getPayTotAmt());
		this.hashColumns.put("spcl_ofc_cd", getSpclOfcCd());
		this.hashColumns.put("spcl_cmpn_seq", getSpclCmpnSeq());
		this.hashColumns.put("spcl_cmpn_sts_cd", getSpclCmpnStsCd());
		this.hashColumns.put("spcl_agmt_seq", getSpclAgmtSeq());
		this.hashColumns.put("csr_cre_dt", getCsrCreDt());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("if_dt", "ifDt");
		this.hashFields.put("apro_step", "aproStep");
		this.hashFields.put("date_fm", "dateFm");
		this.hashFields.put("pay_dt", "payDt");
		this.hashFields.put("tot_amt", "totAmt");
		this.hashFields.put("if_opt", "ifOpt");
		this.hashFields.put("if_date", "ifDate");
		this.hashFields.put("vat", "vat");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("ff_cnt_seq", "ffCntSeq");
		this.hashFields.put("fwdr_name", "fwdrName");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_desc", "invDesc");
		this.hashFields.put("net_amt", "netAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("pay_amt", "payAmt");
		this.hashFields.put("date_div", "dateDiv");
		this.hashFields.put("usr_eml", "usrEml");
		this.hashFields.put("ftu_use_ctnt1", "ftuUseCtnt1");
		this.hashFields.put("inv_tax_rt", "invTaxRt");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("vndr_term_nm", "vndrTermNm");
		this.hashFields.put("ap_ofc_cd", "apOfcCd");
		this.hashFields.put("tot_cnt", "totCnt");
		this.hashFields.put("date_to", "dateTo");
		this.hashFields.put("if_flg", "ifFlg");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("rcv_flg", "rcvFlg");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("cust_cnt_seq", "custCntSeq");
		this.hashFields.put("if_rsn", "ifRsn");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pay_mzd_lu_cd", "payMzdLuCd");
		this.hashFields.put("rcv_rsn", "rcvRsn");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("coa_inter_compy_cd", "coaInterCompyCd");
		this.hashFields.put("rqst_usr_id", "rqstUsrId");
		this.hashFields.put("rqst_usr_nm", "rqstUsrNm");
		this.hashFields.put("apro_usr_id", "aproUsrId");
		this.hashFields.put("apro_usr_nm", "aproUsrNm");
		this.hashFields.put("asa_no", "asaNo");
		this.hashFields.put("pay_xch_rt", "payXchRt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("pay_tot_amt", "payTotAmt");
		this.hashFields.put("spcl_ofc_cd", "spclOfcCd");
		this.hashFields.put("spcl_cmpn_seq", "spclCmpnSeq");
		this.hashFields.put("spcl_cmpn_sts_cd", "spclCmpnStsCd");
		this.hashFields.put("spcl_agmt_seq", "spclAgmtSeq");
		this.hashFields.put("csr_cre_dt", "csrCreDt");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return ifDt
	 */
	public String getIfDt() {
		return this.ifDt;
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
	 * @return dateFm
	 */
	public String getDateFm() {
		return this.dateFm;
	}

	/**
	 * Column Info
	 * @return payDt
	 */
	public String getPayDt() {
		return this.payDt;
	}

	/**
	 * Column Info
	 * @return totAmt
	 */
	public String getTotAmt() {
		return this.totAmt;
	}

	/**
	 * Column Info
	 * @return ifOpt
	 */
	public String getIfOpt() {
		return this.ifOpt;
	}

	/**
	 * Column Info
	 * @return ifDate
	 */
	public String getIfDate() {
		return this.ifDate;
	}

	/**
	 * Column Info
	 * @return vat
	 */
	public String getVat() {
		return this.vat;
	}

	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}

	/**
	 * Column Info
	 * @return ffCntSeq
	 */
	public String getFfCntSeq() {
		return this.ffCntSeq;
	}

	/**
	 * Column Info
	 * @return fwdrName
	 */
	public String getFwdrName() {
		return this.fwdrName;
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
	 * @return invDesc
	 */
	public String getInvDesc() {
		return this.invDesc;
	}

	/**
	 * Column Info
	 * @return netAmt
	 */
	public String getNetAmt() {
		return this.netAmt;
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
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}

	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}

	/**
	 * Column Info
	 * @return payAmt
	 */
	public String getPayAmt() {
		return this.payAmt;
	}

	/**
	 * Column Info
	 * @return dateDiv
	 */
	public String getDateDiv() {
		return this.dateDiv;
	}

	/**
	 * Column Info
	 * @return usrEml
	 */
	public String getUsrEml() {
		return this.usrEml;
	}

	/**
	 * Column Info
	 * @return ftuUseCtnt1
	 */
	public String getFtuUseCtnt1() {
		return this.ftuUseCtnt1;
	}

	/**
	 * Column Info
	 * @return invTaxRt
	 */
	public String getInvTaxRt() {
		return this.invTaxRt;
	}

	/**
	 * Column Info
	 * @return invDt
	 */
	public String getInvDt() {
		return this.invDt;
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
	 * @return vndrTermNm
	 */
	public String getVndrTermNm() {
		return this.vndrTermNm;
	}

	/**
	 * Column Info
	 * @return apOfcCd
	 */
	public String getApOfcCd() {
		return this.apOfcCd;
	}

	/**
	 * Column Info
	 * @return totCnt
	 */
	public String getTotCnt() {
		return this.totCnt;
	}

	/**
	 * Column Info
	 * @return dateTo
	 */
	public String getDateTo() {
		return this.dateTo;
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
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
	}

	/**
	 * Column Info
	 * @return rcvFlg
	 */
	public String getRcvFlg() {
		return this.rcvFlg;
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
	 * @return custCntSeq
	 */
	public String getCustCntSeq() {
		return this.custCntSeq;
	}

	/**
	 * Column Info
	 * @return ifRsn
	 */
	public String getIfRsn() {
		return this.ifRsn;
	}

	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}

	/**
	 * Column Info
	 * @return payMzdLuCd
	 */
	public String getPayMzdLuCd() {
		return this.payMzdLuCd;
	}

	/**
	 * Column Info
	 * @return rcvRsn
	 */
	public String getRcvRsn() {
		return this.rcvRsn;
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
	 * @return coaInterCompyCd
	 */
	public String getCoaInterCompyCd() {
		return this.coaInterCompyCd;
	}

	
	/**
	 * Column Info
	 * @return rqstUsrId
	 */
	public String getRqstUsrId() {
		return this.rqstUsrId;
	}
	
	/**
	 * Column Info
	 * @return rqstUsrNm
	 */
	public String getRqstUsrNm() {
		return this.rqstUsrNm;
	}
	
	/**
	 * Column Info
	 * @return aproUsrId
	 */
	public String getAproUsrId() {
		return this.aproUsrId;
	}
	
	/**
	 * Column Info
	 * @return aproUsrNm
	 */
	public String getAproUsrNm() {
		return this.aproUsrNm;
	}	
	
	/**
	 * Column Info
	 * @return asaNo
	 */
	public String getAsaNo() {
		return this.asaNo;
	}	
	
	/**
	 * Column Info
	 * @return payXchRt
	 */
	public String getPayXchRt() {
		return this.payXchRt;
	}	
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}	
	
	/**
	 * Column Info
	 * @return payTotAmt
	 */
	public String getPayTotAmt() {
		return this.payTotAmt;
	}	
	
	/**
	 * Column Info
	 * @return spclOfcCd
	 */
	public String getSpclOfcCd() {
		return this.spclOfcCd;
	}	
	
	/**
	 * Column Info
	 * @return spclCmpnSeq
	 */
	public String getSpclCmpnSeq() {
		return this.spclCmpnSeq;
	}	
	
	/**
	 * Column Info
	 * @return spclCmpnStsCd
	 */
	public String getSpclCmpnStsCd() {
		return this.spclCmpnStsCd;
	}	
	
	/**
	 * Column Info
	 * @return spclAgmtSeq
	 */
	public String getSpclAgmtSeq() {
		return this.spclAgmtSeq;
	}	
	
	/**
	 * Column Info
	 * @return csrCreDt
	 */
	public String getCsrCreDt() {
		return this.csrCreDt;
	}	


	/**
	 * Column Info
	 * @param ifDt
	 */
	public void setIfDt(String ifDt) {
		this.ifDt = ifDt;
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
	 * @param dateFm
	 */
	public void setDateFm(String dateFm) {
		this.dateFm = dateFm;
	}

	/**
	 * Column Info
	 * @param payDt
	 */
	public void setPayDt(String payDt) {
		this.payDt = payDt;
	}

	/**
	 * Column Info
	 * @param totAmt
	 */
	public void setTotAmt(String totAmt) {
		this.totAmt = totAmt;
	}

	/**
	 * Column Info
	 * @param ifOpt
	 */
	public void setIfOpt(String ifOpt) {
		this.ifOpt = ifOpt;
	}

	/**
	 * Column Info
	 * @param ifDate
	 */
	public void setIfDate(String ifDate) {
		this.ifDate = ifDate;
	}

	/**
	 * Column Info
	 * @param vat
	 */
	public void setVat(String vat) {
		this.vat = vat;
	}

	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	/**
	 * Column Info
	 * @param ffCntSeq
	 */
	public void setFfCntSeq(String ffCntSeq) {
		this.ffCntSeq = ffCntSeq;
	}

	/**
	 * Column Info
	 * @param fwdrName
	 */
	public void setFwdrName(String fwdrName) {
		this.fwdrName = fwdrName;
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
	 * @param invDesc
	 */
	public void setInvDesc(String invDesc) {
		this.invDesc = invDesc;
	}

	/**
	 * Column Info
	 * @param netAmt
	 */
	public void setNetAmt(String netAmt) {
		this.netAmt = netAmt;
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
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}

	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	/**
	 * Column Info
	 * @param payAmt
	 */
	public void setPayAmt(String payAmt) {
		this.payAmt = payAmt;
	}

	/**
	 * Column Info
	 * @param dateDiv
	 */
	public void setDateDiv(String dateDiv) {
		this.dateDiv = dateDiv;
	}

	/**
	 * Column Info
	 * @param usrEml
	 */
	public void setUsrEml(String usrEml) {
		this.usrEml = usrEml;
	}

	/**
	 * Column Info
	 * @param ftuUseCtnt1
	 */
	public void setFtuUseCtnt1(String ftuUseCtnt1) {
		this.ftuUseCtnt1 = ftuUseCtnt1;
	}

	/**
	 * Column Info
	 * @param invTaxRt
	 */
	public void setInvTaxRt(String invTaxRt) {
		this.invTaxRt = invTaxRt;
	}

	/**
	 * Column Info
	 * @param invDt
	 */
	public void setInvDt(String invDt) {
		this.invDt = invDt;
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
	 * @param vndrTermNm
	 */
	public void setVndrTermNm(String vndrTermNm) {
		this.vndrTermNm = vndrTermNm;
	}

	/**
	 * Column Info
	 * @param apOfcCd
	 */
	public void setApOfcCd(String apOfcCd) {
		this.apOfcCd = apOfcCd;
	}

	/**
	 * Column Info
	 * @param totCnt
	 */
	public void setTotCnt(String totCnt) {
		this.totCnt = totCnt;
	}

	/**
	 * Column Info
	 * @param dateTo
	 */
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
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
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}

	/**
	 * Column Info
	 * @param rcvFlg
	 */
	public void setRcvFlg(String rcvFlg) {
		this.rcvFlg = rcvFlg;
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
	 * @param custCntSeq
	 */
	public void setCustCntSeq(String custCntSeq) {
		this.custCntSeq = custCntSeq;
	}

	/**
	 * Column Info
	 * @param ifRsn
	 */
	public void setIfRsn(String ifRsn) {
		this.ifRsn = ifRsn;
	}

	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * Column Info
	 * @param payMzdLuCd
	 */
	public void setPayMzdLuCd(String payMzdLuCd) {
		this.payMzdLuCd = payMzdLuCd;
	}

	/**
	 * Column Info
	 * @param rcvRsn
	 */
	public void setRcvRsn(String rcvRsn) {
		this.rcvRsn = rcvRsn;
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
	 * @param coaInterCompyCd
	 */
	public void setCoaInterCompyCd(String coaInterCompyCd) {
		this.coaInterCompyCd = coaInterCompyCd;
	}

	/**
	 * Column Info
	 * @param rqstUsrId
	 */
	public void setRqstUsrId(String rqstUsrId) {
		this.rqstUsrId = rqstUsrId;
	}
	
	/**
	 * Column Info
	 * @param rqstUsrNm
	 */
	public void setRqstUsrNm(String rqstUsrNm) {
		this.rqstUsrNm = rqstUsrNm;
	}
	
	/**
	 * Column Info
	 * @param aproUsrId
	 */
	public void setAproUsrId(String aproUsrId) {
		this.aproUsrId = aproUsrId;
	}
	
	/**
	 * Column Info
	 * @param aproUsrNm
	 */
	public void setAproUsrNm(String aproUsrNm) {
		this.aproUsrNm = aproUsrNm;
	}	
	
	/**
	 * Column Info
	 * @param asaNo
	 */
	public void setAsaNo(String asaNo) {
		this.asaNo = asaNo;
	}	
	
	/**
	 * Column Info
	 * @param payXchRt
	 */
	public void setPayXchRt(String payXchRt) {
		this.payXchRt = payXchRt;
	}	
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}	
	
	/**
	 * Column Info
	 * @param payTotAmt
	 */
	public void setPayTotAmt(String payTotAmt) {
		this.payTotAmt = payTotAmt;
	}	
	
	/**
	 * Column Info
	 * @param spclOfcCd
	 */
	public void setSpclOfcCd(String spclOfcCd) {
		this.spclOfcCd = spclOfcCd;
	}	
	
	/**
	 * Column Info
	 * @param spclCmpnSeq
	 */
	public void setSpclCmpnSeq(String spclCmpnSeq) {
		this.spclCmpnSeq = spclCmpnSeq;
	}	
	
	/**
	 * Column Info
	 * @param spclCmpnStsCd
	 */
	public void setSpclCmpnStsCd(String spclCmpnStsCd) {
		this.spclCmpnStsCd = spclCmpnStsCd;
	}	
	
	/**
	 * Column Info
	 * @param spclAgmtSeq
	 */
	public void setSpclAgmtSeq(String spclAgmtSeq) {
		this.spclAgmtSeq = spclAgmtSeq;
	}	
	
	/**
	 * Column Info
	 * @param csrCreDt
	 */
	public void setCsrCreDt(String csrCreDt) {
		this.csrCreDt = csrCreDt;
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
		setIfDt(JSPUtil.getParameter(request, prefix + "if_dt", ""));
		setAproStep(JSPUtil.getParameter(request, prefix + "apro_step", ""));
		setDateFm(JSPUtil.getParameter(request, prefix + "date_fm", ""));
		setPayDt(JSPUtil.getParameter(request, prefix + "pay_dt", ""));
		setTotAmt(JSPUtil.getParameter(request, prefix + "tot_amt", ""));
		setIfOpt(JSPUtil.getParameter(request, prefix + "if_opt", ""));
		setIfDate(JSPUtil.getParameter(request, prefix + "if_date", ""));
		setVat(JSPUtil.getParameter(request, prefix + "vat", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setFfCntSeq(JSPUtil.getParameter(request, prefix + "ff_cnt_seq", ""));
		setFwdrName(JSPUtil.getParameter(request, prefix + "fwdr_name", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInvDesc(JSPUtil.getParameter(request, prefix + "inv_desc", ""));
		setNetAmt(JSPUtil.getParameter(request, prefix + "net_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setPayAmt(JSPUtil.getParameter(request, prefix + "pay_amt", ""));
		setDateDiv(JSPUtil.getParameter(request, prefix + "date_div", ""));
		setUsrEml(JSPUtil.getParameter(request, prefix + "usr_eml", ""));
		setFtuUseCtnt1(JSPUtil.getParameter(request, prefix + "ftu_use_ctnt1", ""));
		setInvTaxRt(JSPUtil.getParameter(request, prefix + "inv_tax_rt", ""));
		setInvDt(JSPUtil.getParameter(request, prefix + "inv_dt", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setVndrTermNm(JSPUtil.getParameter(request, prefix + "vndr_term_nm", ""));
		setApOfcCd(JSPUtil.getParameter(request, prefix + "ap_ofc_cd", ""));
		setTotCnt(JSPUtil.getParameter(request, prefix + "tot_cnt", ""));
		setDateTo(JSPUtil.getParameter(request, prefix + "date_to", ""));
		setIfFlg(JSPUtil.getParameter(request, prefix + "if_flg", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setRcvFlg(JSPUtil.getParameter(request, prefix + "rcv_flg", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setCustCntSeq(JSPUtil.getParameter(request, prefix + "cust_cnt_seq", ""));
		setIfRsn(JSPUtil.getParameter(request, prefix + "if_rsn", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPayMzdLuCd(JSPUtil.getParameter(request, prefix + "pay_mzd_lu_cd", ""));
		setRcvRsn(JSPUtil.getParameter(request, prefix + "rcv_rsn", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setCoaInterCompyCd(JSPUtil.getParameter(request, prefix + "coa_inter_compy_cd", ""));
		setRqstUsrId(JSPUtil.getParameter(request, prefix + "rqst_usr_id", ""));
		setRqstUsrNm(JSPUtil.getParameter(request, prefix + "rqst_usr_nm", ""));
		setAproUsrId(JSPUtil.getParameter(request, prefix + "apro_usr_id", ""));
		setAproUsrNm(JSPUtil.getParameter(request, prefix + "apro_usr_nm", ""));
		setAsaNo(JSPUtil.getParameter(request, prefix + "asa_no", ""));
		setPayXchRt(JSPUtil.getParameter(request, prefix + "pay_xch_rt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setPayTotAmt(JSPUtil.getParameter(request, prefix + "pay_tot_amt", ""));
		setSpclOfcCd(JSPUtil.getParameter(request, prefix + "spcl_ofc_cd", ""));
		setSpclCmpnSeq(JSPUtil.getParameter(request, prefix + "spcl_cmpn_seq", ""));
		setSpclCmpnStsCd(JSPUtil.getParameter(request, prefix + "spcl_cmpn_sts_cd", ""));
		setSpclAgmtSeq(JSPUtil.getParameter(request, prefix + "spcl_agmt_seq", ""));
		setCsrCreDt(JSPUtil.getParameter(request, prefix + "csr_cre_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SPCLCmpnApprovalMasterVO[]
	 */
	public SPCLCmpnApprovalMasterVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SPCLCmpnApprovalMasterVO[]
	 */
	public SPCLCmpnApprovalMasterVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SPCLCmpnApprovalMasterVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ifDt = (JSPUtil.getParameter(request, prefix	+ "if_dt", length));
			String[] aproStep = (JSPUtil.getParameter(request, prefix	+ "apro_step", length));
			String[] dateFm = (JSPUtil.getParameter(request, prefix	+ "date_fm", length));
			String[] payDt = (JSPUtil.getParameter(request, prefix	+ "pay_dt", length));
			String[] totAmt = (JSPUtil.getParameter(request, prefix	+ "tot_amt", length));
			String[] ifOpt = (JSPUtil.getParameter(request, prefix	+ "if_opt", length));
			String[] ifDate = (JSPUtil.getParameter(request, prefix	+ "if_date", length));
			String[] vat = (JSPUtil.getParameter(request, prefix	+ "vat", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] ffCntSeq = (JSPUtil.getParameter(request, prefix	+ "ff_cnt_seq", length));
			String[] fwdrName = (JSPUtil.getParameter(request, prefix	+ "fwdr_name", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invDesc = (JSPUtil.getParameter(request, prefix	+ "inv_desc", length));
			String[] netAmt = (JSPUtil.getParameter(request, prefix	+ "net_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] payAmt = (JSPUtil.getParameter(request, prefix	+ "pay_amt", length));
			String[] dateDiv = (JSPUtil.getParameter(request, prefix	+ "date_div", length));
			String[] usrEml = (JSPUtil.getParameter(request, prefix	+ "usr_eml", length));
			String[] ftuUseCtnt1 = (JSPUtil.getParameter(request, prefix	+ "ftu_use_ctnt1", length));
			String[] invTaxRt = (JSPUtil.getParameter(request, prefix	+ "inv_tax_rt", length));
			String[] invDt = (JSPUtil.getParameter(request, prefix	+ "inv_dt", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] vndrTermNm = (JSPUtil.getParameter(request, prefix	+ "vndr_term_nm", length));
			String[] apOfcCd = (JSPUtil.getParameter(request, prefix	+ "ap_ofc_cd", length));
			String[] totCnt = (JSPUtil.getParameter(request, prefix	+ "tot_cnt", length));
			String[] dateTo = (JSPUtil.getParameter(request, prefix	+ "date_to", length));
			String[] ifFlg = (JSPUtil.getParameter(request, prefix	+ "if_flg", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] rcvFlg = (JSPUtil.getParameter(request, prefix	+ "rcv_flg", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] custCntSeq = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_seq", length));
			String[] ifRsn = (JSPUtil.getParameter(request, prefix	+ "if_rsn", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] payMzdLuCd = (JSPUtil.getParameter(request, prefix	+ "pay_mzd_lu_cd", length));
			String[] rcvRsn = (JSPUtil.getParameter(request, prefix	+ "rcv_rsn", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] coaInterCompyCd = (JSPUtil.getParameter(request, prefix	+ "coa_inter_compy_cd", length));
			String[] rqstUsrId = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_id", length));
			String[] rqstUsrNm = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_nm", length));
			String[] aproUsrId = (JSPUtil.getParameter(request, prefix	+ "apro_usr_id", length));
			String[] aproUsrNm = (JSPUtil.getParameter(request, prefix	+ "apro_usr_nm", length));
			String[] asaNo = (JSPUtil.getParameter(request, prefix	+ "asa_no", length));
			String[] payXchRt = (JSPUtil.getParameter(request, prefix	+ "pay_xch_rt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] payTotAmt = (JSPUtil.getParameter(request, prefix	+ "pay_tot_amt", length));
			String[] spclOfcCd = (JSPUtil.getParameter(request, prefix	+ "spcl_ofc_cd", length));
			String[] spclCmpnSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cmpn_seq", length));
			String[] spclCmpnStsCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cmpn_sts_cd", length));
			String[] spclAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_agmt_seq", length));
			String[] csrCreDt = (JSPUtil.getParameter(request, prefix	+ "csr_cre_dt", length));

			for (int i = 0; i < length; i++) {
				model = new SPCLCmpnApprovalMasterVO();
				if (ifDt[i] != null)
					model.setIfDt(ifDt[i]);
				if (aproStep[i] != null)
					model.setAproStep(aproStep[i]);
				if (dateFm[i] != null)
					model.setDateFm(dateFm[i]);
				if (payDt[i] != null)
					model.setPayDt(payDt[i]);
				if (totAmt[i] != null)
					model.setTotAmt(totAmt[i]);
				if (ifOpt[i] != null)
					model.setIfOpt(ifOpt[i]);
				if (ifDate[i] != null)
					model.setIfDate(ifDate[i]);
				if (vat[i] != null)
					model.setVat(vat[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (ffCntSeq[i] != null)
					model.setFfCntSeq(ffCntSeq[i]);
				if (fwdrName[i] != null)
					model.setFwdrName(fwdrName[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invDesc[i] != null)
					model.setInvDesc(invDesc[i]);
				if (netAmt[i] != null)
					model.setNetAmt(netAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (payAmt[i] != null)
					model.setPayAmt(payAmt[i]);
				if (dateDiv[i] != null)
					model.setDateDiv(dateDiv[i]);
				if (usrEml[i] != null)
					model.setUsrEml(usrEml[i]);
				if (ftuUseCtnt1[i] != null)
					model.setFtuUseCtnt1(ftuUseCtnt1[i]);
				if (invTaxRt[i] != null)
					model.setInvTaxRt(invTaxRt[i]);
				if (invDt[i] != null)
					model.setInvDt(invDt[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (vndrTermNm[i] != null)
					model.setVndrTermNm(vndrTermNm[i]);
				if (apOfcCd[i] != null)
					model.setApOfcCd(apOfcCd[i]);
				if (totCnt[i] != null)
					model.setTotCnt(totCnt[i]);
				if (dateTo[i] != null)
					model.setDateTo(dateTo[i]);
				if (ifFlg[i] != null)
					model.setIfFlg(ifFlg[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (rcvFlg[i] != null)
					model.setRcvFlg(rcvFlg[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (custCntSeq[i] != null)
					model.setCustCntSeq(custCntSeq[i]);
				if (ifRsn[i] != null)
					model.setIfRsn(ifRsn[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (payMzdLuCd[i] != null)
					model.setPayMzdLuCd(payMzdLuCd[i]);
				if (rcvRsn[i] != null)
					model.setRcvRsn(rcvRsn[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (coaInterCompyCd[i] != null)
					model.setCoaInterCompyCd(coaInterCompyCd[i]);
				if (rqstUsrId[i] != null)
					model.setRqstUsrId(rqstUsrId[i]);
				if (rqstUsrNm[i] != null)
					model.setRqstUsrNm(rqstUsrNm[i]);
				if (aproUsrId[i] != null)
					model.setAproUsrId(aproUsrId[i]);
				if (aproUsrNm[i] != null)
					model.setAproUsrNm(aproUsrNm[i]);
				if (asaNo[i] != null)
					model.setAsaNo(asaNo[i]);
				if (payXchRt[i] != null)
					model.setPayXchRt(payXchRt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (payTotAmt[i] != null)
					model.setPayTotAmt(payTotAmt[i]);
				if (spclOfcCd[i] != null)
					model.setSpclOfcCd(spclOfcCd[i]);
				if (spclCmpnSeq[i] != null)
					model.setSpclCmpnSeq(spclCmpnSeq[i]);
				if (spclCmpnStsCd[i] != null)
					model.setSpclCmpnStsCd(spclCmpnStsCd[i]);
				if (spclAgmtSeq[i] != null)
					model.setSpclAgmtSeq(spclAgmtSeq[i]);
				if (csrCreDt[i] != null)
					model.setCsrCreDt(csrCreDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSPCLCmpnApprovalMasterVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SPCLCmpnApprovalMasterVO[]
	 */
	public SPCLCmpnApprovalMasterVO[] getSPCLCmpnApprovalMasterVOs(){
		SPCLCmpnApprovalMasterVO[] vos = (SPCLCmpnApprovalMasterVO[])models.toArray(new SPCLCmpnApprovalMasterVO[models.size()]);
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
		this.ifDt = this.ifDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproStep = this.aproStep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateFm = this.dateFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDt = this.payDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totAmt = this.totAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifOpt = this.ifOpt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifDate = this.ifDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vat = this.vat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCntSeq = this.ffCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fwdrName = this.fwdrName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDesc = this.invDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netAmt = this.netAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payAmt = this.payAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateDiv = this.dateDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrEml = this.usrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftuUseCtnt1 = this.ftuUseCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTaxRt = this.invTaxRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt = this.invDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrTermNm = this.vndrTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apOfcCd = this.apOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totCnt = this.totCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateTo = this.dateTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifFlg = this.ifFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvFlg = this.rcvFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntSeq = this.custCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifRsn = this.ifRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payMzdLuCd = this.payMzdLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvRsn = this.rcvRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaInterCompyCd = this.coaInterCompyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrId = this.rqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrNm = this.rqstUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrId = this.aproUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrNm = this.aproUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaNo = this.asaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payXchRt = this.payXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTotAmt = this.payTotAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclOfcCd = this.spclOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCmpnSeq = this.spclCmpnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCmpnStsCd = this.spclCmpnStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclAgmtSeq = this.spclAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrCreDt = this.csrCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
