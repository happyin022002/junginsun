/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommAuditVO.java
*@FileTitle : AGNCommAuditVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.12
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.07.12 김봉균
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.acm.acmaudit.agncommaudit.vo;

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

public class AGNCommAuditVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<AGNCommAuditVO> models = new ArrayList<AGNCommAuditVO>();

	/* Column Info */
	private String dateFm = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String dffAmt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Column Info */
	private String chfAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String agnCd = null;
	/* Column Info */
	private String audNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String crossAmt = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String creTm = null;
	/* Column Info */
	private String dateDiv = null;
	/* Column Info */
	private String payIfAmt = null;
	/* Column Info */
	private String acStsCd = null;
	/* Column Info */
	private String payXchRt = null;
	/* Column Info */
	private String brogAmt = null;
	/* Column Info */
	private String crntRevAmt = null;
	/* Column Info */
	private String generalAmt = null;
	/* Column Info */
	private String ddctTrspAmt = null;
	/* Column Info */
	private String commVvd = null;
	/* Column Info */
	private String ddctChgAmt = null;
	/* Column Info */
	private String dateTo = null;
	/* Column Info */
	private String ppdAmt = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String tsAmt = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String usdAmt = null;
	/* Column Info */
	private String acSeq = null;
	/* Column Info */
	private String postRevAmt = null;
	/* Column Info */
	private String acProcDesc = null;
	/* Column Info */
	private String auditRqst = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String csfAmt = null;
	/* Column Info */
	private String rcsfAmt = null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public AGNCommAuditVO() {}

	public AGNCommAuditVO(String ibflag, String pagerows, String audNo, String arOfcCd, String agnCd, String acStsCd, String dateDiv, String dateFm, String dateTo, String vvdCd, String bkgNo, String blNo, String ioBndCd, String commVvd, String sailArrDt, String acSeq, String bkgStsCd, String ppdAmt, String generalAmt, String brogAmt, String chfAmt, String tsAmt, String crossAmt, String usdAmt, String dffAmt, String payXchRt, String currCd, String payIfAmt, String creDt, String creTm, String bdrFlg, String acProcDesc, String usrId, String crntRevAmt, String ddctChgAmt, String ddctTrspAmt, String postRevAmt, String auditRqst, String csrNo, String csfAmt, String rcsfAmt) {
		this.dateFm = dateFm;
		this.currCd = currCd;
		this.bdrFlg = bdrFlg;
		this.bkgStsCd = bkgStsCd;
		this.creDt = creDt;
		this.dffAmt = dffAmt;
		this.blNo = blNo;
		this.sailArrDt = sailArrDt;
		this.chfAmt = chfAmt;
		this.pagerows = pagerows;
		this.agnCd = agnCd;
		this.audNo = audNo;
		this.ibflag = ibflag;
		this.crossAmt = crossAmt;
		this.vvdCd = vvdCd;
		this.usrId = usrId;
		this.creTm = creTm;
		this.dateDiv = dateDiv;
		this.payIfAmt = payIfAmt;
		this.acStsCd = acStsCd;
		this.payXchRt = payXchRt;
		this.brogAmt = brogAmt;
		this.crntRevAmt = crntRevAmt;
		this.generalAmt = generalAmt;
		this.ddctTrspAmt = ddctTrspAmt;
		this.commVvd = commVvd;
		this.ddctChgAmt = ddctChgAmt;
		this.dateTo = dateTo;
		this.ppdAmt = ppdAmt;
		this.ioBndCd = ioBndCd;
		this.tsAmt = tsAmt;
		this.arOfcCd = arOfcCd;
		this.bkgNo = bkgNo;
		this.usdAmt = usdAmt;
		this.acSeq = acSeq;
		this.postRevAmt = postRevAmt;
		this.acProcDesc = acProcDesc;
		this.auditRqst = auditRqst;
		this.csrNo = csrNo;
		this.csfAmt = csfAmt;
		this.rcsfAmt = rcsfAmt;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("date_fm", getDateFm());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("dff_amt", getDffAmt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("chf_amt", getChfAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("agn_cd", getAgnCd());
		this.hashColumns.put("aud_no", getAudNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cross_amt", getCrossAmt());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("cre_tm", getCreTm());
		this.hashColumns.put("date_div", getDateDiv());
		this.hashColumns.put("pay_if_amt", getPayIfAmt());
		this.hashColumns.put("ac_sts_cd", getAcStsCd());
		this.hashColumns.put("pay_xch_rt", getPayXchRt());
		this.hashColumns.put("brog_amt", getBrogAmt());
		this.hashColumns.put("crnt_rev_amt", getCrntRevAmt());
		this.hashColumns.put("general_amt", getGeneralAmt());
		this.hashColumns.put("ddct_trsp_amt", getDdctTrspAmt());
		this.hashColumns.put("comm_vvd", getCommVvd());
		this.hashColumns.put("ddct_chg_amt", getDdctChgAmt());
		this.hashColumns.put("date_to", getDateTo());
		this.hashColumns.put("ppd_amt", getPpdAmt());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("ts_amt", getTsAmt());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("usd_amt", getUsdAmt());
		this.hashColumns.put("ac_seq", getAcSeq());
		this.hashColumns.put("post_rev_amt", getPostRevAmt());
		this.hashColumns.put("ac_proc_desc", getAcProcDesc());
		this.hashColumns.put("aud_rqst_dt", getAuditRqst());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("csf_amt", getCsfAmt());
		this.hashColumns.put("rcsf_amt", getRcsfAmt());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("date_fm", "dateFm");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("dff_amt", "dffAmt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("chf_amt", "chfAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("aud_no", "audNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cross_amt", "crossAmt");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("cre_tm", "creTm");
		this.hashFields.put("date_div", "dateDiv");
		this.hashFields.put("pay_if_amt", "payIfAmt");
		this.hashFields.put("ac_sts_cd", "acStsCd");
		this.hashFields.put("pay_xch_rt", "payXchRt");
		this.hashFields.put("brog_amt", "brogAmt");
		this.hashFields.put("crnt_rev_amt", "crntRevAmt");
		this.hashFields.put("general_amt", "generalAmt");
		this.hashFields.put("ddct_trsp_amt", "ddctTrspAmt");
		this.hashFields.put("comm_vvd", "commVvd");
		this.hashFields.put("ddct_chg_amt", "ddctChgAmt");
		this.hashFields.put("date_to", "dateTo");
		this.hashFields.put("ppd_amt", "ppdAmt");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("ts_amt", "tsAmt");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("usd_amt", "usdAmt");
		this.hashFields.put("ac_seq", "acSeq");
		this.hashFields.put("post_rev_amt", "postRevAmt");
		this.hashFields.put("ac_proc_desc", "acProcDesc");
		this.hashFields.put("aud_rqst_dt", "auditRqst");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("csf_amt", "csfAmt");
		this.hashFields.put("rcsf_amt", "rcsfAmt");
		return this.hashFields;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}

	/**
	 * Column Info
	 * @return bdrFlg
	 */
	public String getBdrFlg() {
		return this.bdrFlg;
	}

	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
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
	 * @return dffAmt
	 */
	public String getDffAmt() {
		return this.dffAmt;
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
	 * @return sailArrDt
	 */
	public String getSailArrDt() {
		return this.sailArrDt;
	}

	/**
	 * Column Info
	 * @return chfAmt
	 */
	public String getChfAmt() {
		return this.chfAmt;
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
	 * @return agnCd
	 */
	public String getAgnCd() {
		return this.agnCd;
	}

	/**
	 * Column Info
	 * @return audNo
	 */
	public String getAudNo() {
		return this.audNo;
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
	 * @return crossAmt
	 */
	public String getCrossAmt() {
		return this.crossAmt;
	}

	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
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
	 * @return creTm
	 */
	public String getCreTm() {
		return this.creTm;
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
	 * @return payIfAmt
	 */
	public String getPayIfAmt() {
		return this.payIfAmt;
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
	 * @return payXchRt
	 */
	public String getPayXchRt() {
		return this.payXchRt;
	}

	/**
	 * Column Info
	 * @return brogAmt
	 */
	public String getBrogAmt() {
		return this.brogAmt;
	}

	/**
	 * Column Info
	 * @return crntRevAmt
	 */
	public String getCrntRevAmt() {
		return this.crntRevAmt;
	}

	/**
	 * Column Info
	 * @return generalAmt
	 */
	public String getGeneralAmt() {
		return this.generalAmt;
	}

	/**
	 * Column Info
	 * @return ddctTrspAmt
	 */
	public String getDdctTrspAmt() {
		return this.ddctTrspAmt;
	}

	/**
	 * Column Info
	 * @return commVvd
	 */
	public String getCommVvd() {
		return this.commVvd;
	}

	/**
	 * Column Info
	 * @return ddctChgAmt
	 */
	public String getDdctChgAmt() {
		return this.ddctChgAmt;
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
	 * @return ppdAmt
	 */
	public String getPpdAmt() {
		return this.ppdAmt;
	}

	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}

	/**
	 * Column Info
	 * @return tsAmt
	 */
	public String getTsAmt() {
		return this.tsAmt;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}

	/**
	 * Column Info
	 * @return usdAmt
	 */
	public String getUsdAmt() {
		return this.usdAmt;
	}

	/**
	 * Column Info
	 * @return acSeq
	 */
	public String getAcSeq() {
		return this.acSeq;
	}

	/**
	 * Column Info
	 * @return postRevAmt
	 */
	public String getPostRevAmt() {
		return this.postRevAmt;
	}

	/**
	 * Column Info
	 * @return acProcDesc
	 */
	public String getAcProcDesc() {
		return this.acProcDesc;
	}
	
	/**
	 * Column Info
	 * @param auditRqst
	 */
	public String getAuditRqst() {
		return this.auditRqst;
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
	 * @return csfAmt
	 */
	public String getCsfAmt() {
		return csfAmt;
	}
	
	/**
	 * Column Info
	 * @return rcsfAmt
	 */
	public String getRcsfAmt() {
		return rcsfAmt;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}

	/**
	 * Column Info
	 * @param bdrFlg
	 */
	public void setBdrFlg(String bdrFlg) {
		this.bdrFlg = bdrFlg;
	}

	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
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
	 * @param dffAmt
	 */
	public void setDffAmt(String dffAmt) {
		this.dffAmt = dffAmt;
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
	 * @param sailArrDt
	 */
	public void setSailArrDt(String sailArrDt) {
		this.sailArrDt = sailArrDt;
	}

	/**
	 * Column Info
	 * @param chfAmt
	 */
	public void setChfAmt(String chfAmt) {
		this.chfAmt = chfAmt;
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
	 * @param agnCd
	 */
	public void setAgnCd(String agnCd) {
		this.agnCd = agnCd;
	}

	/**
	 * Column Info
	 * @param audNo
	 */
	public void setAudNo(String audNo) {
		this.audNo = audNo;
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
	 * @param crossAmt
	 */
	public void setCrossAmt(String crossAmt) {
		this.crossAmt = crossAmt;
	}

	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
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
	 * @param creTm
	 */
	public void setCreTm(String creTm) {
		this.creTm = creTm;
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
	 * @param payIfAmt
	 */
	public void setPayIfAmt(String payIfAmt) {
		this.payIfAmt = payIfAmt;
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
	 * @param payXchRt
	 */
	public void setPayXchRt(String payXchRt) {
		this.payXchRt = payXchRt;
	}

	/**
	 * Column Info
	 * @param brogAmt
	 */
	public void setBrogAmt(String brogAmt) {
		this.brogAmt = brogAmt;
	}

	/**
	 * Column Info
	 * @param crntRevAmt
	 */
	public void setCrntRevAmt(String crntRevAmt) {
		this.crntRevAmt = crntRevAmt;
	}

	/**
	 * Column Info
	 * @param generalAmt
	 */
	public void setGeneralAmt(String generalAmt) {
		this.generalAmt = generalAmt;
	}

	/**
	 * Column Info
	 * @param ddctTrspAmt
	 */
	public void setDdctTrspAmt(String ddctTrspAmt) {
		this.ddctTrspAmt = ddctTrspAmt;
	}

	/**
	 * Column Info
	 * @param commVvd
	 */
	public void setCommVvd(String commVvd) {
		this.commVvd = commVvd;
	}

	/**
	 * Column Info
	 * @param ddctChgAmt
	 */
	public void setDdctChgAmt(String ddctChgAmt) {
		this.ddctChgAmt = ddctChgAmt;
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
	 * @param ppdAmt
	 */
	public void setPpdAmt(String ppdAmt) {
		this.ppdAmt = ppdAmt;
	}

	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}

	/**
	 * Column Info
	 * @param tsAmt
	 */
	public void setTsAmt(String tsAmt) {
		this.tsAmt = tsAmt;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * Column Info
	 * @param usdAmt
	 */
	public void setUsdAmt(String usdAmt) {
		this.usdAmt = usdAmt;
	}

	/**
	 * Column Info
	 * @param acSeq
	 */
	public void setAcSeq(String acSeq) {
		this.acSeq = acSeq;
	}

	/**
	 * Column Info
	 * @param postRevAmt
	 */
	public void setPostRevAmt(String postRevAmt) {
		this.postRevAmt = postRevAmt;
	}

	/**
	 * Column Info
	 * @param acProcDesc
	 */
	public void setAcProcDesc(String acProcDesc) {
		this.acProcDesc = acProcDesc;
	}
	
	/**
	 * Column Info
	 * @param auditRqst
	 */
	public void setAuditRqst(String auditRqst) {
		this.auditRqst = auditRqst;
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
	 * @param csfAmt
	 */
	public void setCsfAmt(String csfAmt) {
		this.csfAmt = csfAmt;
	}

	/**
	 * Column Info
	 * @param rcsfAmt
	 */
	public void setRcsfAmt(String rcsfAmt) {
		this.rcsfAmt = rcsfAmt;
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
		setDateFm(JSPUtil.getParameter(request, prefix + "date_fm", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setDffAmt(JSPUtil.getParameter(request, prefix + "dff_amt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setSailArrDt(JSPUtil.getParameter(request, prefix + "sail_arr_dt", ""));
		setChfAmt(JSPUtil.getParameter(request, prefix + "chf_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAgnCd(JSPUtil.getParameter(request, prefix + "agn_cd", ""));
		setAudNo(JSPUtil.getParameter(request, prefix + "aud_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCrossAmt(JSPUtil.getParameter(request, prefix + "cross_amt", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setCreTm(JSPUtil.getParameter(request, prefix + "cre_tm", ""));
		setDateDiv(JSPUtil.getParameter(request, prefix + "date_div", ""));
		setPayIfAmt(JSPUtil.getParameter(request, prefix + "pay_if_amt", ""));
		setAcStsCd(JSPUtil.getParameter(request, prefix + "ac_sts_cd", ""));
		setPayXchRt(JSPUtil.getParameter(request, prefix + "pay_xch_rt", ""));
		setBrogAmt(JSPUtil.getParameter(request, prefix + "brog_amt", ""));
		setCrntRevAmt(JSPUtil.getParameter(request, prefix + "crnt_rev_amt", ""));
		setGeneralAmt(JSPUtil.getParameter(request, prefix + "general_amt", ""));
		setDdctTrspAmt(JSPUtil.getParameter(request, prefix + "ddct_trsp_amt", ""));
		setCommVvd(JSPUtil.getParameter(request, prefix + "comm_vvd", ""));
		setDdctChgAmt(JSPUtil.getParameter(request, prefix + "ddct_chg_amt", ""));
		setDateTo(JSPUtil.getParameter(request, prefix + "date_to", ""));
		setPpdAmt(JSPUtil.getParameter(request, prefix + "ppd_amt", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setTsAmt(JSPUtil.getParameter(request, prefix + "ts_amt", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setUsdAmt(JSPUtil.getParameter(request, prefix + "usd_amt", ""));
		setAcSeq(JSPUtil.getParameter(request, prefix + "ac_seq", ""));
		setPostRevAmt(JSPUtil.getParameter(request, prefix + "post_rev_amt", ""));
		setAcProcDesc(JSPUtil.getParameter(request, prefix + "ac_proc_desc", ""));
		setAuditRqst(JSPUtil.getParameter(request, prefix + "aud_rqst_dt", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));		
		setCsfAmt(JSPUtil.getParameter(request, prefix + "csf_amt", ""));
		setRcsfAmt(JSPUtil.getParameter(request, prefix + "rcsf_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AGNCommAuditVO[]
	 */
	public AGNCommAuditVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return AGNCommAuditVO[]
	 */
	public AGNCommAuditVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AGNCommAuditVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] dateFm = (JSPUtil.getParameter(request, prefix	+ "date_fm", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] dffAmt = (JSPUtil.getParameter(request, prefix	+ "dff_amt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] chfAmt = (JSPUtil.getParameter(request, prefix	+ "chf_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] agnCd = (JSPUtil.getParameter(request, prefix	+ "agn_cd", length));
			String[] audNo = (JSPUtil.getParameter(request, prefix	+ "aud_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] crossAmt = (JSPUtil.getParameter(request, prefix	+ "cross_amt", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] creTm = (JSPUtil.getParameter(request, prefix	+ "cre_tm", length));
			String[] dateDiv = (JSPUtil.getParameter(request, prefix	+ "date_div", length));
			String[] payIfAmt = (JSPUtil.getParameter(request, prefix	+ "pay_if_amt", length));
			String[] acStsCd = (JSPUtil.getParameter(request, prefix	+ "ac_sts_cd", length));
			String[] payXchRt = (JSPUtil.getParameter(request, prefix	+ "pay_xch_rt", length));
			String[] brogAmt = (JSPUtil.getParameter(request, prefix	+ "brog_amt", length));
			String[] crntRevAmt = (JSPUtil.getParameter(request, prefix	+ "crnt_rev_amt", length));
			String[] generalAmt = (JSPUtil.getParameter(request, prefix	+ "general_amt", length));
			String[] ddctTrspAmt = (JSPUtil.getParameter(request, prefix	+ "ddct_trsp_amt", length));
			String[] commVvd = (JSPUtil.getParameter(request, prefix	+ "comm_vvd", length));
			String[] ddctChgAmt = (JSPUtil.getParameter(request, prefix	+ "ddct_chg_amt", length));
			String[] dateTo = (JSPUtil.getParameter(request, prefix	+ "date_to", length));
			String[] ppdAmt = (JSPUtil.getParameter(request, prefix	+ "ppd_amt", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] tsAmt = (JSPUtil.getParameter(request, prefix	+ "ts_amt", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] usdAmt = (JSPUtil.getParameter(request, prefix	+ "usd_amt", length));
			String[] acSeq = (JSPUtil.getParameter(request, prefix	+ "ac_seq", length));
			String[] postRevAmt = (JSPUtil.getParameter(request, prefix	+ "post_rev_amt", length));
			String[] acProcDesc = (JSPUtil.getParameter(request, prefix	+ "ac_proc_desc", length));
			String[] auditRqst = (JSPUtil.getParameter(request, prefix + "aud_rqst_dt", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] csfAmt = (JSPUtil.getParameter(request, prefix + "csf_amt", length));
			String[] rcsfAmt = (JSPUtil.getParameter(request, prefix	+ "rcsf_amt", length));


			for (int i = 0; i < length; i++) {
				model = new AGNCommAuditVO();
				if (dateFm[i] != null)
					model.setDateFm(dateFm[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (dffAmt[i] != null)
					model.setDffAmt(dffAmt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (chfAmt[i] != null)
					model.setChfAmt(chfAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (agnCd[i] != null)
					model.setAgnCd(agnCd[i]);
				if (audNo[i] != null)
					model.setAudNo(audNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (crossAmt[i] != null)
					model.setCrossAmt(crossAmt[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (creTm[i] != null)
					model.setCreTm(creTm[i]);
				if (dateDiv[i] != null)
					model.setDateDiv(dateDiv[i]);
				if (payIfAmt[i] != null)
					model.setPayIfAmt(payIfAmt[i]);
				if (acStsCd[i] != null)
					model.setAcStsCd(acStsCd[i]);
				if (payXchRt[i] != null)
					model.setPayXchRt(payXchRt[i]);
				if (brogAmt[i] != null)
					model.setBrogAmt(brogAmt[i]);
				if (crntRevAmt[i] != null)
					model.setCrntRevAmt(crntRevAmt[i]);
				if (generalAmt[i] != null)
					model.setGeneralAmt(generalAmt[i]);
				if (ddctTrspAmt[i] != null)
					model.setDdctTrspAmt(ddctTrspAmt[i]);
				if (commVvd[i] != null)
					model.setCommVvd(commVvd[i]);
				if (ddctChgAmt[i] != null)
					model.setDdctChgAmt(ddctChgAmt[i]);
				if (dateTo[i] != null)
					model.setDateTo(dateTo[i]);
				if (ppdAmt[i] != null)
					model.setPpdAmt(ppdAmt[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (tsAmt[i] != null)
					model.setTsAmt(tsAmt[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (usdAmt[i] != null)
					model.setUsdAmt(usdAmt[i]);
				if (acSeq[i] != null)
					model.setAcSeq(acSeq[i]);
				if (postRevAmt[i] != null)
					model.setPostRevAmt(postRevAmt[i]);
				if (acProcDesc[i] != null)
					model.setAcProcDesc(acProcDesc[i]);
				if (auditRqst[i] != null)
					model.setAuditRqst(auditRqst[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (csfAmt[i] != null)
					model.setCsfAmt(csfAmt[i]);
				if (rcsfAmt[i] != null)
					model.setRcsfAmt(rcsfAmt[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAGNCommAuditVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AGNCommAuditVO[]
	 */
	public AGNCommAuditVO[] getAGNCommAuditVOs(){
		AGNCommAuditVO[] vos = (AGNCommAuditVO[])models.toArray(new AGNCommAuditVO[models.size()]);
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
		this.dateFm = this.dateFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dffAmt = this.dffAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chfAmt = this.chfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd = this.agnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audNo = this.audNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crossAmt = this.crossAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creTm = this.creTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateDiv = this.dateDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payIfAmt = this.payIfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acStsCd = this.acStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payXchRt = this.payXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogAmt = this.brogAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntRevAmt = this.crntRevAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.generalAmt = this.generalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddctTrspAmt = this.ddctTrspAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commVvd = this.commVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddctChgAmt = this.ddctChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateTo = this.dateTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdAmt = this.ppdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsAmt = this.tsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdAmt = this.usdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acSeq = this.acSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postRevAmt = this.postRevAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acProcDesc = this.acProcDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.auditRqst = this.auditRqst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csfAmt = this.csfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcsfAmt = this.rcsfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
