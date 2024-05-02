/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AGNCommApprovalMasterVO.java
*@FileTitle : AGNCommApprovalMasterVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.11  
* 1.0 Creation
* 
* 2014.06.27 박다은 [CHM-201430726] Audit / CSR 생성 시 건수 제한 로직 추가 요청
=========================================================*/

package com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo;

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

public class AGNCommApprovalMasterVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AGNCommApprovalMasterVO> models = new ArrayList<AGNCommApprovalMasterVO>();
	
	/* Column Info */
	private String ifDt = null;
	/* Column Info */
	private String aproStep = null;
	/* Column Info */
	private String dateFm = null;
	/* Column Info */
	private String payDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String whldTaxRt = null;
	/* Column Info */
	private String vat = null;
	/* Column Info */
	private String ttlAmt = null;
	/* Column Info */
	private String sRevChg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String audNo = null;
	private String audNos = null;
	/* Column Info */
	private String agnCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String netAmt = null;
	/* Column Info */
	private String payAmt = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String whld = null;
	/* Column Info */
	private String acStsCd = null;
	/* Column Info */
	private String invTaxRt = null;
	/* Column Info */
	private String invDt = null;
	/* Column Info */
	private String rcvErrFlg = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String cnt = null;
	/* Column Info */
	private String dateTo = null;
	/* Column Info */
	private String ifFlg = null;
	/* Column Info */
	private String aproDt = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String hCsrno = null;
	/* Column Info */
	private String payMzdLuCd = null;
	/* Column Info */
	private String chk = null;
	/* Column Info */
	private String rcvErrFlgMsg = null;
	/* Column Info */
	private String asaNo = null;
	/* Column Info */
	private String ifFlgMsg = null;
	/* Column Info */
	private String vvdCnt = null;
	/* Column Info */
	private String approYN = null;
	/* Column Info */
	private String commStndCostCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AGNCommApprovalMasterVO() {}

	public AGNCommApprovalMasterVO(String ibflag, String pagerows, String hCsrno, String usrId, String arOfcCd, String acStsCd, String dateFm, String dateTo, String asaNo, String invDt, String invTaxRt, String sRevChg, String aproStep, String chk, String whldTaxRt, String whld, String cnt, String audNo, String audNos, String agnCd, String vvdCnt, String currCd, String netAmt, String vat, String ttlAmt, String csrNo, String aproDt, String ifDt, String ifFlgMsg, String rcvErrFlgMsg, String ifFlg, String rcvErrFlg, String payAmt, String payDt, String payMzdLuCd, String approYN, String commStndCostCd) {
		this.ifDt = ifDt;
		this.aproStep = aproStep;
		this.dateFm = dateFm;
		this.payDt = payDt;
		this.currCd = currCd;
		this.whldTaxRt = whldTaxRt;
		this.vat = vat;
		this.ttlAmt = ttlAmt;
		this.sRevChg = sRevChg;
		this.pagerows = pagerows;
		this.audNo = audNo;
		this.audNos = audNos;
		this.agnCd = agnCd;
		this.ibflag = ibflag;
		this.netAmt = netAmt;
		this.payAmt = payAmt;
		this.usrId = usrId;
		this.whld = whld;
		this.acStsCd = acStsCd;
		this.invTaxRt = invTaxRt;
		this.invDt = invDt;
		this.rcvErrFlg = rcvErrFlg;
		this.csrNo = csrNo;
		this.cnt = cnt;
		this.dateTo = dateTo;
		this.ifFlg = ifFlg;
		this.aproDt = aproDt;
		this.arOfcCd = arOfcCd;
		this.hCsrno = hCsrno;
		this.payMzdLuCd = payMzdLuCd;
		this.chk = chk;
		this.rcvErrFlgMsg = rcvErrFlgMsg;
		this.asaNo = asaNo;
		this.ifFlgMsg = ifFlgMsg;
		this.vvdCnt = vvdCnt;
		this.approYN = approYN;
		this.commStndCostCd = commStndCostCd;
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
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("whld_tax_rt", getWhldTaxRt());
		this.hashColumns.put("vat", getVat());
		this.hashColumns.put("ttl_amt", getTtlAmt());
		this.hashColumns.put("s_rev_chg", getSRevChg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("aud_no", getAudNo());
		this.hashColumns.put("aud_nos", getAudNos());
		this.hashColumns.put("agn_cd", getAgnCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("net_amt", getNetAmt());
		this.hashColumns.put("pay_amt", getPayAmt());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("whld", getWhld());
		this.hashColumns.put("ac_sts_cd", getAcStsCd());
		this.hashColumns.put("inv_tax_rt", getInvTaxRt());
		this.hashColumns.put("inv_dt", getInvDt());
		this.hashColumns.put("rcv_err_flg", getRcvErrFlg());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("cnt", getCnt());
		this.hashColumns.put("date_to", getDateTo());
		this.hashColumns.put("if_flg", getIfFlg());
		this.hashColumns.put("apro_dt", getAproDt());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("h_csrno", getHCsrno());
		this.hashColumns.put("pay_mzd_lu_cd", getPayMzdLuCd());
		this.hashColumns.put("chk", getChk());
		this.hashColumns.put("rcv_err_flg_msg", getRcvErrFlgMsg());
		this.hashColumns.put("asa_no", getAsaNo());
		this.hashColumns.put("if_flg_msg", getIfFlgMsg());
		this.hashColumns.put("vvd_cnt", getVvdCnt());
		this.hashColumns.put("appro_yn", getApproYN());
		this.hashColumns.put("comm_stnd_cost_cd", getCommStndCostCd());
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
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("whld_tax_rt", "whldTaxRt");
		this.hashFields.put("vat", "vat");
		this.hashFields.put("ttl_amt", "ttlAmt");
		this.hashFields.put("s_rev_chg", "sRevChg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("aud_no", "audNo");
		this.hashFields.put("aud_nos", "audNos");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("net_amt", "netAmt");
		this.hashFields.put("pay_amt", "payAmt");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("whld", "whld");
		this.hashFields.put("ac_sts_cd", "acStsCd");
		this.hashFields.put("inv_tax_rt", "invTaxRt");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("rcv_err_flg", "rcvErrFlg");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("cnt", "cnt");
		this.hashFields.put("date_to", "dateTo");
		this.hashFields.put("if_flg", "ifFlg");
		this.hashFields.put("apro_dt", "aproDt");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("h_csrno", "hCsrno");
		this.hashFields.put("pay_mzd_lu_cd", "payMzdLuCd");
		this.hashFields.put("chk", "chk");
		this.hashFields.put("rcv_err_flg_msg", "rcvErrFlgMsg");
		this.hashFields.put("asa_no", "asaNo");
		this.hashFields.put("if_flg_msg", "ifFlgMsg");
		this.hashFields.put("vvd_cnt", "vvdCnt");
		this.hashFields.put("appro_yn", "approYN");
		this.hashFields.put("comm_stnd_cost_cd", "commStndCostCd");
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return whldTaxRt
	 */
	public String getWhldTaxRt() {
		return this.whldTaxRt;
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
	 * @return ttlAmt
	 */
	public String getTtlAmt() {
		return this.ttlAmt;
	}
	
	/**
	 * Column Info
	 * @return sRevChg
	 */
	public String getSRevChg() {
		return this.sRevChg;
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
	 * @return audNo
	 */
	public String getAudNo() {
		return this.audNo;
	}
	
	public String getAudNos() {
		return audNos;
	}

	public void setAudNos(String audNos) {
		this.audNos = audNos;
	}

	/**
	 * Column Info
	 * @return agnCd
	 */
	public String getAgnCd() {
		return this.agnCd;
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
	 * @return netAmt
	 */
	public String getNetAmt() {
		return this.netAmt;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return whld
	 */
	public String getWhld() {
		return this.whld;
	}
	
	/**
	 * Column Info
	 * @return acStsCd
	 */
	public String getAcStsCd() {
		return this.acStsCd;
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
	 * @return rcvErrFlg
	 */
	public String getRcvErrFlg() {
		return this.rcvErrFlg;
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
	 * @return cnt
	 */
	public String getCnt() {
		return this.cnt;
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
	 * @return aproDt
	 */
	public String getAproDt() {
		return this.aproDt;
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
	 * @return hCsrno
	 */
	public String getHCsrno() {
		return this.hCsrno;
	}
	
	public String getApproYN() {
		return approYN;
	}

	public void setApproYN(String approYN) {
		this.approYN = approYN;
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
	 * @return chk
	 */
	public String getChk() {
		return this.chk;
	}
	
	/**
	 * Column Info
	 * @return rcvErrFlgMsg
	 */
	public String getRcvErrFlgMsg() {
		return this.rcvErrFlgMsg;
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
	 * @return ifFlgMsg
	 */
	public String getIfFlgMsg() {
		return this.ifFlgMsg;
	}
	
	/**
	 * Column Info
	 * @return vvdCnt
	 */
	public String getVvdCnt() {
		return this.vvdCnt;
	}

	/**
	 * Column Info
	 * @return commStndCostCd
	 */
	public String getCommStndCostCd() {
		return commStndCostCd;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param whldTaxRt
	 */
	public void setWhldTaxRt(String whldTaxRt) {
		this.whldTaxRt = whldTaxRt;
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
	 * @param ttlAmt
	 */
	public void setTtlAmt(String ttlAmt) {
		this.ttlAmt = ttlAmt;
	}
	
	/**
	 * Column Info
	 * @param sRevChg
	 */
	public void setSRevChg(String sRevChg) {
		this.sRevChg = sRevChg;
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
	 * @param audNo
	 */
	public void setAudNo(String audNo) {
		this.audNo = audNo;
	}
	
	/**
	 * Column Info
	 * @param agnCd
	 */
	public void setAgnCd(String agnCd) {
		this.agnCd = agnCd;
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
	 * @param netAmt
	 */
	public void setNetAmt(String netAmt) {
		this.netAmt = netAmt;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param whld
	 */
	public void setWhld(String whld) {
		this.whld = whld;
	}
	
	/**
	 * Column Info
	 * @param acStsCd
	 */
	public void setAcStsCd(String acStsCd) {
		this.acStsCd = acStsCd;
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
	 * @param rcvErrFlg
	 */
	public void setRcvErrFlg(String rcvErrFlg) {
		this.rcvErrFlg = rcvErrFlg;
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
	 * @param cnt
	 */
	public void setCnt(String cnt) {
		this.cnt = cnt;
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
	 * @param aproDt
	 */
	public void setAproDt(String aproDt) {
		this.aproDt = aproDt;
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
	 * @param hCsrno
	 */
	public void setHCsrno(String hCsrno) {
		this.hCsrno = hCsrno;
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
	 * @param chk
	 */
	public void setChk(String chk) {
		this.chk = chk;
	}
	
	/**
	 * Column Info
	 * @param rcvErrFlgMsg
	 */
	public void setRcvErrFlgMsg(String rcvErrFlgMsg) {
		this.rcvErrFlgMsg = rcvErrFlgMsg;
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
	 * @param ifFlgMsg
	 */
	public void setIfFlgMsg(String ifFlgMsg) {
		this.ifFlgMsg = ifFlgMsg;
	}
	
	/**
	 * Column Info
	 * @param vvdCnt
	 */
	public void setVvdCnt(String vvdCnt) {
		this.vvdCnt = vvdCnt;
	}

	/**
	 * Column Info
	 * @param commStndCostCd
	 */
	public void setCommStndCostCd(String commStndCostCd) {
		this.commStndCostCd = commStndCostCd;
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
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setWhldTaxRt(JSPUtil.getParameter(request, prefix + "whld_tax_rt", ""));
		setVat(JSPUtil.getParameter(request, prefix + "vat", ""));
		setTtlAmt(JSPUtil.getParameter(request, prefix + "ttl_amt", ""));
		setSRevChg(JSPUtil.getParameter(request, prefix + "s_rev_chg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAudNo(JSPUtil.getParameter(request, prefix + "aud_no", ""));
		setAudNos(JSPUtil.getParameter(request, prefix + "aud_nos", ""));
		setAgnCd(JSPUtil.getParameter(request, prefix + "agn_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setNetAmt(JSPUtil.getParameter(request, prefix + "net_amt", ""));
		setPayAmt(JSPUtil.getParameter(request, prefix + "pay_amt", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setWhld(JSPUtil.getParameter(request, prefix + "whld", ""));
		setAcStsCd(JSPUtil.getParameter(request, prefix + "ac_sts_cd", ""));
		setInvTaxRt(JSPUtil.getParameter(request, prefix + "inv_tax_rt", ""));
		setInvDt(JSPUtil.getParameter(request, prefix + "inv_dt", ""));
		setRcvErrFlg(JSPUtil.getParameter(request, prefix + "rcv_err_flg", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setCnt(JSPUtil.getParameter(request, prefix + "cnt", ""));
		setDateTo(JSPUtil.getParameter(request, prefix + "date_to", ""));
		setIfFlg(JSPUtil.getParameter(request, prefix + "if_flg", ""));
		setAproDt(JSPUtil.getParameter(request, prefix + "apro_dt", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setHCsrno(JSPUtil.getParameter(request, prefix + "h_csrno", ""));
		setPayMzdLuCd(JSPUtil.getParameter(request, prefix + "pay_mzd_lu_cd", ""));
		setChk(JSPUtil.getParameter(request, prefix + "chk", ""));
		setRcvErrFlgMsg(JSPUtil.getParameter(request, prefix + "rcv_err_flg_msg", ""));
		setAsaNo(JSPUtil.getParameter(request, prefix + "asa_no", ""));
		setIfFlgMsg(JSPUtil.getParameter(request, prefix + "if_flg_msg", ""));
		setVvdCnt(JSPUtil.getParameter(request, prefix + "vvd_cnt", ""));
		setApproYN(JSPUtil.getParameter(request, prefix + "appro_yn", ""));
		setCommStndCostCd(JSPUtil.getParameter(request, prefix + "comm_stnd_cost_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AGNCommApprovalMasterVO[]
	 */
	public AGNCommApprovalMasterVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AGNCommApprovalMasterVO[]
	 */
	public AGNCommApprovalMasterVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AGNCommApprovalMasterVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ifDt = (JSPUtil.getParameter(request, prefix	+ "if_dt", length));
			String[] aproStep = (JSPUtil.getParameter(request, prefix	+ "apro_step", length));
			String[] dateFm = (JSPUtil.getParameter(request, prefix	+ "date_fm", length));
			String[] payDt = (JSPUtil.getParameter(request, prefix	+ "pay_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] whldTaxRt = (JSPUtil.getParameter(request, prefix	+ "whld_tax_rt", length));
			String[] vat = (JSPUtil.getParameter(request, prefix	+ "vat", length));
			String[] ttlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_amt", length));
			String[] sRevChg = (JSPUtil.getParameter(request, prefix	+ "s_rev_chg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] audNo = (JSPUtil.getParameter(request, prefix	+ "aud_no", length));
			String[] audNos = (JSPUtil.getParameter(request, prefix	+ "aud_nos", length));
			String[] agnCd = (JSPUtil.getParameter(request, prefix	+ "agn_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] netAmt = (JSPUtil.getParameter(request, prefix	+ "net_amt", length));
			String[] payAmt = (JSPUtil.getParameter(request, prefix	+ "pay_amt", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] whld = (JSPUtil.getParameter(request, prefix	+ "whld", length));
			String[] acStsCd = (JSPUtil.getParameter(request, prefix	+ "ac_sts_cd", length));
			String[] invTaxRt = (JSPUtil.getParameter(request, prefix	+ "inv_tax_rt", length));
			String[] invDt = (JSPUtil.getParameter(request, prefix	+ "inv_dt", length));
			String[] rcvErrFlg = (JSPUtil.getParameter(request, prefix	+ "rcv_err_flg", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] cnt = (JSPUtil.getParameter(request, prefix	+ "cnt", length));
			String[] dateTo = (JSPUtil.getParameter(request, prefix	+ "date_to", length));
			String[] ifFlg = (JSPUtil.getParameter(request, prefix	+ "if_flg", length));
			String[] aproDt = (JSPUtil.getParameter(request, prefix	+ "apro_dt", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] hCsrno = (JSPUtil.getParameter(request, prefix	+ "h_csrno", length));
			String[] payMzdLuCd = (JSPUtil.getParameter(request, prefix	+ "pay_mzd_lu_cd", length));
			String[] chk = (JSPUtil.getParameter(request, prefix	+ "chk", length));
			String[] rcvErrFlgMsg = (JSPUtil.getParameter(request, prefix	+ "rcv_err_flg_msg", length));
			String[] asaNo = (JSPUtil.getParameter(request, prefix	+ "asa_no", length));
			String[] ifFlgMsg = (JSPUtil.getParameter(request, prefix	+ "if_flg_msg", length));
			String[] vvdCnt = (JSPUtil.getParameter(request, prefix	+ "vvd_cnt", length));
			String[] approYN = (JSPUtil.getParameter(request, prefix	+ "appro_yn", length));
			String[] commStndCostCd = (JSPUtil.getParameter(request, prefix	+ "comm_stnd_cost_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new AGNCommApprovalMasterVO();
				if (ifDt[i] != null)
					model.setIfDt(ifDt[i]);
				if (aproStep[i] != null)
					model.setAproStep(aproStep[i]);
				if (dateFm[i] != null)
					model.setDateFm(dateFm[i]);
				if (payDt[i] != null)
					model.setPayDt(payDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (whldTaxRt[i] != null)
					model.setWhldTaxRt(whldTaxRt[i]);
				if (vat[i] != null)
					model.setVat(vat[i]);
				if (ttlAmt[i] != null)
					model.setTtlAmt(ttlAmt[i]);
				if (sRevChg[i] != null)
					model.setSRevChg(sRevChg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (audNo[i] != null)
					model.setAudNo(audNo[i]);
				if (audNos[i] != null)
					model.setAudNos(audNos[i]);				
				if (agnCd[i] != null)
					model.setAgnCd(agnCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (netAmt[i] != null)
					model.setNetAmt(netAmt[i]);
				if (payAmt[i] != null)
					model.setPayAmt(payAmt[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (whld[i] != null)
					model.setWhld(whld[i]);
				if (acStsCd[i] != null)
					model.setAcStsCd(acStsCd[i]);
				if (invTaxRt[i] != null)
					model.setInvTaxRt(invTaxRt[i]);
				if (invDt[i] != null)
					model.setInvDt(invDt[i]);
				if (rcvErrFlg[i] != null)
					model.setRcvErrFlg(rcvErrFlg[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (cnt[i] != null)
					model.setCnt(cnt[i]);
				if (dateTo[i] != null)
					model.setDateTo(dateTo[i]);
				if (ifFlg[i] != null)
					model.setIfFlg(ifFlg[i]);
				if (aproDt[i] != null)
					model.setAproDt(aproDt[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (hCsrno[i] != null)
					model.setHCsrno(hCsrno[i]);
				if (payMzdLuCd[i] != null)
					model.setPayMzdLuCd(payMzdLuCd[i]);
				if (chk[i] != null)
					model.setChk(chk[i]);
				if (rcvErrFlgMsg[i] != null)
					model.setRcvErrFlgMsg(rcvErrFlgMsg[i]);
				if (asaNo[i] != null)
					model.setAsaNo(asaNo[i]);
				if (ifFlgMsg[i] != null)
					model.setIfFlgMsg(ifFlgMsg[i]);
				if (vvdCnt[i] != null)
					model.setVvdCnt(vvdCnt[i]);
				if (approYN[i] != null)
					model.setApproYN(approYN[i]);
				if (commStndCostCd[i] != null)
					model.setCommStndCostCd(commStndCostCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAGNCommApprovalMasterVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AGNCommApprovalMasterVO[]
	 */
	public AGNCommApprovalMasterVO[] getAGNCommApprovalMasterVOs(){
		AGNCommApprovalMasterVO[] vos = (AGNCommApprovalMasterVO[])models.toArray(new AGNCommApprovalMasterVO[models.size()]);
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
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whldTaxRt = this.whldTaxRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vat = this.vat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt = this.ttlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRevChg = this.sRevChg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audNo = this.audNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audNos = this.audNos .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd = this.agnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netAmt = this.netAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payAmt = this.payAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whld = this.whld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acStsCd = this.acStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTaxRt = this.invTaxRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt = this.invDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvErrFlg = this.rcvErrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt = this.cnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateTo = this.dateTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifFlg = this.ifFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDt = this.aproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hCsrno = this.hCsrno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payMzdLuCd = this.payMzdLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk = this.chk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvErrFlgMsg = this.rcvErrFlgMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaNo = this.asaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifFlgMsg = this.ifFlgMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCnt = this.vvdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.approYN = this.approYN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commStndCostCd = this.commStndCostCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
