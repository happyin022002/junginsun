/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SCompAgreementVO.java
*@FileTitle : SCompAgreementVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.27
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.07.27 김상수
* 1.0 Creation
* 
* 2016.04.21 박다은 [CSR:#11434] CSA - ACM - Special Compensation CSR to be created in local currency
=========================================================*/

package com.clt.apps.opus.esm.acm.acmagreement.spclcmpnagreement.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SCompAgreementVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<SCompAgreementVO> models = new ArrayList<SCompAgreementVO>();

	/* Column Info */
	private String spclRfTeuAmt = null;
	/* Column Info */
	private String spclTeuAmt = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String porGrpTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String podRoutCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String spclFeuAmt = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String fmEffDt = null;
	/* Column Info */
	private String shprCntNm = null;
	/* Column Info */
	private String porRoutCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String polRoutCd = null;
	/* Column Info */
	private String spclCntCustNm = null;
	/* Column Info */
	private String spclOfcCd = null;
	/* Column Info */
	private String polGrpTpCd = null;
	/* Column Info */
	private String spclAgmtSeq = null;
	/* Column Info */
	private String spclRfFeuAmt = null;
	/* Column Info */
	private String spclChgCtnt = null;
	/* Column Info */
	private String toEffDt = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String spclBxAmt = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String custCntSeq = null;
	/* Column Info */
	private String spclDivCd = null;
	/* Column Info */
	private String custKndCd = null;
	/* Column Info */
	private String cmdtTpCd = null;
	/* Column Info */
	private String spclBkgRt = null;
	/* Column Info */
	private String podGrpTpCd = null;
	/* Column Info */
	private String spclRfAmt = null;
	/* Column Info */
	private String shprCntSeq = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String fcustCntSeq = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String payXchRt = null;
	/* Column Info */
	private String gDeltFlg = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public SCompAgreementVO() {}

	public SCompAgreementVO(String ibflag, String pagerows, String spclOfcCd, String custCntCd, String custSeq, String custCntSeq, String spclCntCustNm, String spclAgmtSeq, String custKndCd, String scNo, String rfaNo, String shprCntSeq, String shprCntNm, String fmEffDt, String toEffDt, String cmdtTpCd, String cmdtCd, String cmdtNm, String porGrpTpCd, String porRoutCd, String polGrpTpCd, String polRoutCd, String podGrpTpCd, String podRoutCd, String spclDivCd, String spclBkgRt, String spclBxAmt, String spclTeuAmt, String spclFeuAmt, String spclRfAmt, String spclRfTeuAmt, String spclRfFeuAmt, String spclChgCtnt, String usrId, String deltFlg, String seq, String fcustCntSeq, String currCd, String payXchRt, String gDeltFlg) {
		this.spclRfTeuAmt = spclRfTeuAmt;
		this.spclTeuAmt = spclTeuAmt;
		this.deltFlg = deltFlg;
		this.porGrpTpCd = porGrpTpCd;
		this.pagerows = pagerows;
		this.rfaNo = rfaNo;
		this.podRoutCd = podRoutCd;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.cmdtCd = cmdtCd;
		this.spclFeuAmt = spclFeuAmt;
		this.scNo = scNo;
		this.fmEffDt = fmEffDt;
		this.shprCntNm = shprCntNm;
		this.porRoutCd = porRoutCd;
		this.custCntCd = custCntCd;
		this.polRoutCd = polRoutCd;
		this.spclCntCustNm = spclCntCustNm;
		this.spclOfcCd = spclOfcCd;
		this.polGrpTpCd = polGrpTpCd;
		this.spclAgmtSeq = spclAgmtSeq;
		this.spclRfFeuAmt = spclRfFeuAmt;
		this.spclChgCtnt = spclChgCtnt;
		this.toEffDt = toEffDt;
		this.custSeq = custSeq;
		this.spclBxAmt = spclBxAmt;
		this.cmdtNm = cmdtNm;
		this.custCntSeq = custCntSeq;
		this.spclDivCd = spclDivCd;
		this.custKndCd = custKndCd;
		this.cmdtTpCd = cmdtTpCd;
		this.spclBkgRt = spclBkgRt;
		this.podGrpTpCd = podGrpTpCd;
		this.spclRfAmt = spclRfAmt;
		this.shprCntSeq = shprCntSeq;
		this.seq = seq;
		this.fcustCntSeq = fcustCntSeq;
		this.currCd = currCd;
		this.payXchRt = payXchRt;
		this.gDeltFlg = gDeltFlg;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("spcl_rf_teu_amt", getSpclRfTeuAmt());
		this.hashColumns.put("spcl_teu_amt", getSpclTeuAmt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("por_grp_tp_cd", getPorGrpTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("pod_rout_cd", getPodRoutCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("spcl_feu_amt", getSpclFeuAmt());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("fm_eff_dt", getFmEffDt());
		this.hashColumns.put("shpr_cnt_nm", getShprCntNm());
		this.hashColumns.put("por_rout_cd", getPorRoutCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("pol_rout_cd", getPolRoutCd());
		this.hashColumns.put("spcl_cnt_cust_nm", getSpclCntCustNm());
		this.hashColumns.put("spcl_ofc_cd", getSpclOfcCd());
		this.hashColumns.put("pol_grp_tp_cd", getPolGrpTpCd());
		this.hashColumns.put("spcl_agmt_seq", getSpclAgmtSeq());
		this.hashColumns.put("spcl_rf_feu_amt", getSpclRfFeuAmt());
		this.hashColumns.put("spcl_chg_ctnt", getSpclChgCtnt());
		this.hashColumns.put("to_eff_dt", getToEffDt());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("spcl_bx_amt", getSpclBxAmt());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("cust_cnt_seq", getCustCntSeq());
		this.hashColumns.put("spcl_div_cd", getSpclDivCd());
		this.hashColumns.put("cust_knd_cd", getCustKndCd());
		this.hashColumns.put("cmdt_tp_cd", getCmdtTpCd());
		this.hashColumns.put("spcl_bkg_rt", getSpclBkgRt());
		this.hashColumns.put("pod_grp_tp_cd", getPodGrpTpCd());
		this.hashColumns.put("spcl_rf_amt", getSpclRfAmt());
		this.hashColumns.put("shpr_cnt_seq", getShprCntSeq());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("fcust_cnt_seq", getFcustCntSeq());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("pay_xch_rt", getPayXchRt());
		this.hashColumns.put("g_delt_flg", getGDeltFlg());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("spcl_rf_teu_amt", "spclRfTeuAmt");
		this.hashFields.put("spcl_teu_amt", "spclTeuAmt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("por_grp_tp_cd", "porGrpTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("pod_rout_cd", "podRoutCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("spcl_feu_amt", "spclFeuAmt");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("fm_eff_dt", "fmEffDt");
		this.hashFields.put("shpr_cnt_nm", "shprCntNm");
		this.hashFields.put("por_rout_cd", "porRoutCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("pol_rout_cd", "polRoutCd");
		this.hashFields.put("spcl_cnt_cust_nm", "spclCntCustNm");
		this.hashFields.put("spcl_ofc_cd", "spclOfcCd");
		this.hashFields.put("pol_grp_tp_cd", "polGrpTpCd");
		this.hashFields.put("spcl_agmt_seq", "spclAgmtSeq");
		this.hashFields.put("spcl_rf_feu_amt", "spclRfFeuAmt");
		this.hashFields.put("spcl_chg_ctnt", "spclChgCtnt");
		this.hashFields.put("to_eff_dt", "toEffDt");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("spcl_bx_amt", "spclBxAmt");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("cust_cnt_seq", "custCntSeq");
		this.hashFields.put("spcl_div_cd", "spclDivCd");
		this.hashFields.put("cust_knd_cd", "custKndCd");
		this.hashFields.put("cmdt_tp_cd", "cmdtTpCd");
		this.hashFields.put("spcl_bkg_rt", "spclBkgRt");
		this.hashFields.put("pod_grp_tp_cd", "podGrpTpCd");
		this.hashFields.put("spcl_rf_amt", "spclRfAmt");
		this.hashFields.put("shpr_cnt_seq", "shprCntSeq");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("fcust_cnt_seq", "fcustCntSeq");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("pay_xch_rt", "payXchRt");
		this.hashFields.put("g_delt_flg", "gDeltFlg");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return spclRfTeuAmt
	 */
	public String getSpclRfTeuAmt() {
		return this.spclRfTeuAmt;
	}

	/**
	 * Column Info
	 * @return spclTeuAmt
	 */
	public String getSpclTeuAmt() {
		return this.spclTeuAmt;
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
	 * @return porGrpTpCd
	 */
	public String getPorGrpTpCd() {
		return this.porGrpTpCd;
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
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
	}

	/**
	 * Column Info
	 * @return podRoutCd
	 */
	public String getPodRoutCd() {
		return this.podRoutCd;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}

	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}

	/**
	 * Column Info
	 * @return spclFeuAmt
	 */
	public String getSpclFeuAmt() {
		return this.spclFeuAmt;
	}

	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}

	/**
	 * Column Info
	 * @return fmEffDt
	 */
	public String getFmEffDt() {
		return this.fmEffDt;
	}

	/**
	 * Column Info
	 * @return shprCntNm
	 */
	public String getShprCntNm() {
		return this.shprCntNm;
	}

	/**
	 * Column Info
	 * @return porRoutCd
	 */
	public String getPorRoutCd() {
		return this.porRoutCd;
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
	 * @return polRoutCd
	 */
	public String getPolRoutCd() {
		return this.polRoutCd;
	}

	/**
	 * Column Info
	 * @return spclCntCustNm
	 */
	public String getSpclCntCustNm() {
		return this.spclCntCustNm;
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
	 * @return polGrpTpCd
	 */
	public String getPolGrpTpCd() {
		return this.polGrpTpCd;
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
	 * @return spclRfFeuAmt
	 */
	public String getSpclRfFeuAmt() {
		return this.spclRfFeuAmt;
	}

	/**
	 * Column Info
	 * @return spclChgCtnt
	 */
	public String getSpclChgCtnt() {
		return this.spclChgCtnt;
	}

	/**
	 * Column Info
	 * @return toEffDt
	 */
	public String getToEffDt() {
		return this.toEffDt;
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
	 * @return spclBxAmt
	 */
	public String getSpclBxAmt() {
		return this.spclBxAmt;
	}

	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
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
	 * @return spclDivCd
	 */
	public String getSpclDivCd() {
		return this.spclDivCd;
	}

	/**
	 * Column Info
	 * @return custKndCd
	 */
	public String getCustKndCd() {
		return this.custKndCd;
	}

	/**
	 * Column Info
	 * @return cmdtTpCd
	 */
	public String getCmdtTpCd() {
		return this.cmdtTpCd;
	}

	/**
	 * Column Info
	 * @return spclBkgRt
	 */
	public String getSpclBkgRt() {
		return this.spclBkgRt;
	}

	/**
	 * Column Info
	 * @return podGrpTpCd
	 */
	public String getPodGrpTpCd() {
		return this.podGrpTpCd;
	}

	/**
	 * Column Info
	 * @return spclRfAmt
	 */
	public String getSpclRfAmt() {
		return this.spclRfAmt;
	}

	/**
	 * Column Info
	 * @return shprCntSeq
	 */
	public String getShprCntSeq() {
		return this.shprCntSeq;
	}

	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
  
	/**
	 * Column Info
	 * @return fcustCntSeq
	 */
	public String getFcustCntSeq() {
		return this.fcustCntSeq;
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
	 * @return payXchRt
	 */
	public String getPayXchRt() {
		return this.payXchRt;
	}
	
	/**
	 * Column Info
	 * @return gDeltFlg
	 */
	public String getGDeltFlg() {
		return this.gDeltFlg;
	}
	
	/**
	 * Column Info
	 * @param spclRfTeuAmt
	 */
	public void setSpclRfTeuAmt(String spclRfTeuAmt) {
		this.spclRfTeuAmt = spclRfTeuAmt;
	}

	/**
	 * Column Info
	 * @param spclTeuAmt
	 */
	public void setSpclTeuAmt(String spclTeuAmt) {
		this.spclTeuAmt = spclTeuAmt;
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
	 * @param porGrpTpCd
	 */
	public void setPorGrpTpCd(String porGrpTpCd) {
		this.porGrpTpCd = porGrpTpCd;
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
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}

	/**
	 * Column Info
	 * @param podRoutCd
	 */
	public void setPodRoutCd(String podRoutCd) {
		this.podRoutCd = podRoutCd;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}

	/**
	 * Column Info
	 * @param spclFeuAmt
	 */
	public void setSpclFeuAmt(String spclFeuAmt) {
		this.spclFeuAmt = spclFeuAmt;
	}

	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}

	/**
	 * Column Info
	 * @param fmEffDt
	 */
	public void setFmEffDt(String fmEffDt) {
		this.fmEffDt = fmEffDt;
	}

	/**
	 * Column Info
	 * @param shprCntNm
	 */
	public void setShprCntNm(String shprCntNm) {
		this.shprCntNm = shprCntNm;
	}

	/**
	 * Column Info
	 * @param porRoutCd
	 */
	public void setPorRoutCd(String porRoutCd) {
		this.porRoutCd = porRoutCd;
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
	 * @param polRoutCd
	 */
	public void setPolRoutCd(String polRoutCd) {
		this.polRoutCd = polRoutCd;
	}

	/**
	 * Column Info
	 * @param spclCntCustNm
	 */
	public void setSpclCntCustNm(String spclCntCustNm) {
		this.spclCntCustNm = spclCntCustNm;
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
	 * @param polGrpTpCd
	 */
	public void setPolGrpTpCd(String polGrpTpCd) {
		this.polGrpTpCd = polGrpTpCd;
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
	 * @param spclRfFeuAmt
	 */
	public void setSpclRfFeuAmt(String spclRfFeuAmt) {
		this.spclRfFeuAmt = spclRfFeuAmt;
	}

	/**
	 * Column Info
	 * @param spclChgCtnt
	 */
	public void setSpclChgCtnt(String spclChgCtnt) {
		this.spclChgCtnt = spclChgCtnt;
	}

	/**
	 * Column Info
	 * @param toEffDt
	 */
	public void setToEffDt(String toEffDt) {
		this.toEffDt = toEffDt;
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
	 * @param spclBxAmt
	 */
	public void setSpclBxAmt(String spclBxAmt) {
		this.spclBxAmt = spclBxAmt;
	}

	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
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
	 * @param spclDivCd
	 */
	public void setSpclDivCd(String spclDivCd) {
		this.spclDivCd = spclDivCd;
	}

	/**
	 * Column Info
	 * @param custKndCd
	 */
	public void setCustKndCd(String custKndCd) {
		this.custKndCd = custKndCd;
	}

	/**
	 * Column Info
	 * @param cmdtTpCd
	 */
	public void setCmdtTpCd(String cmdtTpCd) {
		this.cmdtTpCd = cmdtTpCd;
	}

	/**
	 * Column Info
	 * @param spclBkgRt
	 */
	public void setSpclBkgRt(String spclBkgRt) {
		this.spclBkgRt = spclBkgRt;
	}

	/**
	 * Column Info
	 * @param podGrpTpCd
	 */
	public void setPodGrpTpCd(String podGrpTpCd) {
		this.podGrpTpCd = podGrpTpCd;
	}

	/**
	 * Column Info
	 * @param spclRfAmt
	 */
	public void setSpclRfAmt(String spclRfAmt) {
		this.spclRfAmt = spclRfAmt;
	}

	/**
	 * Column Info
	 * @param shprCntSeq
	 */
	public void setShprCntSeq(String shprCntSeq) {
		this.shprCntSeq = shprCntSeq;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param custCntSeq
	 */
	public void setFcustCntSeq(String fcustCntSeq) {
		this.fcustCntSeq = fcustCntSeq;
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
	 * @param payXchRt
	 */
	public void setPayXchRt(String payXchRt) {
		this.payXchRt = payXchRt;
	}
	
	/**
	 * Column Info
	 * @param gDeltFlg
	 */
	public void setGDeltFlg(String gDeltFlg) {
		this.gDeltFlg = gDeltFlg;
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
		setSpclRfTeuAmt(JSPUtil.getParameter(request, prefix + "spcl_rf_teu_amt", ""));
		setSpclTeuAmt(JSPUtil.getParameter(request, prefix + "spcl_teu_amt", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setPorGrpTpCd(JSPUtil.getParameter(request, prefix + "por_grp_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setPodRoutCd(JSPUtil.getParameter(request, prefix + "pod_rout_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setSpclFeuAmt(JSPUtil.getParameter(request, prefix + "spcl_feu_amt", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setFmEffDt(JSPUtil.getParameter(request, prefix + "fm_eff_dt", ""));
		setShprCntNm(JSPUtil.getParameter(request, prefix + "shpr_cnt_nm", ""));
		setPorRoutCd(JSPUtil.getParameter(request, prefix + "por_rout_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setPolRoutCd(JSPUtil.getParameter(request, prefix + "pol_rout_cd", ""));
		setSpclCntCustNm(JSPUtil.getParameter(request, prefix + "spcl_cnt_cust_nm", ""));
		setSpclOfcCd(JSPUtil.getParameter(request, prefix + "spcl_ofc_cd", ""));
		setPolGrpTpCd(JSPUtil.getParameter(request, prefix + "pol_grp_tp_cd", ""));
		setSpclAgmtSeq(JSPUtil.getParameter(request, prefix + "spcl_agmt_seq", ""));
		setSpclRfFeuAmt(JSPUtil.getParameter(request, prefix + "spcl_rf_feu_amt", ""));
		setSpclChgCtnt(JSPUtil.getParameter(request, prefix + "spcl_chg_ctnt", ""));
		setToEffDt(JSPUtil.getParameter(request, prefix + "to_eff_dt", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setSpclBxAmt(JSPUtil.getParameter(request, prefix + "spcl_bx_amt", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setCustCntSeq(JSPUtil.getParameter(request, prefix + "cust_cnt_seq", ""));
		setSpclDivCd(JSPUtil.getParameter(request, prefix + "spcl_div_cd", ""));
		setCustKndCd(JSPUtil.getParameter(request, prefix + "cust_knd_cd", ""));
		setCmdtTpCd(JSPUtil.getParameter(request, prefix + "cmdt_tp_cd", ""));
		setSpclBkgRt(JSPUtil.getParameter(request, prefix + "spcl_bkg_rt", ""));
		setPodGrpTpCd(JSPUtil.getParameter(request, prefix + "pod_grp_tp_cd", ""));
		setSpclRfAmt(JSPUtil.getParameter(request, prefix + "spcl_rf_amt", ""));
		setShprCntSeq(JSPUtil.getParameter(request, prefix + "shpr_cnt_seq", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setFcustCntSeq(JSPUtil.getParameter(request, prefix + "fcust_cnt_seq", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setPayXchRt(JSPUtil.getParameter(request, prefix + "pay_xch_rt", ""));
		setGDeltFlg(JSPUtil.getParameter(request, prefix + "g_delt_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SCompAgreementVO[]
	 */
	public SCompAgreementVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SCompAgreementVO[]
	 */
	public SCompAgreementVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SCompAgreementVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] spclRfTeuAmt = (JSPUtil.getParameter(request, prefix	+ "spcl_rf_teu_amt", length));
			String[] spclTeuAmt = (JSPUtil.getParameter(request, prefix	+ "spcl_teu_amt", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] porGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "por_grp_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] podRoutCd = (JSPUtil.getParameter(request, prefix	+ "pod_rout_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] spclFeuAmt = (JSPUtil.getParameter(request, prefix	+ "spcl_feu_amt", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] fmEffDt = (JSPUtil.getParameter(request, prefix	+ "fm_eff_dt", length));
			String[] shprCntNm = (JSPUtil.getParameter(request, prefix	+ "shpr_cnt_nm", length));
			String[] porRoutCd = (JSPUtil.getParameter(request, prefix	+ "por_rout_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] polRoutCd = (JSPUtil.getParameter(request, prefix	+ "pol_rout_cd", length));
			String[] spclCntCustNm = (JSPUtil.getParameter(request, prefix	+ "spcl_cnt_cust_nm", length));
			String[] spclOfcCd = (JSPUtil.getParameter(request, prefix	+ "spcl_ofc_cd", length));
			String[] polGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "pol_grp_tp_cd", length));
			String[] spclAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_agmt_seq", length));
			String[] spclRfFeuAmt = (JSPUtil.getParameter(request, prefix	+ "spcl_rf_feu_amt", length));
			String[] spclChgCtnt = (JSPUtil.getParameter(request, prefix	+ "spcl_chg_ctnt", length));
			String[] toEffDt = (JSPUtil.getParameter(request, prefix	+ "to_eff_dt", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] spclBxAmt = (JSPUtil.getParameter(request, prefix	+ "spcl_bx_amt", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] custCntSeq = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_seq", length));
			String[] spclDivCd = (JSPUtil.getParameter(request, prefix	+ "spcl_div_cd", length));
			String[] custKndCd = (JSPUtil.getParameter(request, prefix	+ "cust_knd_cd", length));
			String[] cmdtTpCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_tp_cd", length));
			String[] spclBkgRt = (JSPUtil.getParameter(request, prefix	+ "spcl_bkg_rt", length));
			String[] podGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "pod_grp_tp_cd", length));
			String[] spclRfAmt = (JSPUtil.getParameter(request, prefix	+ "spcl_rf_amt", length));
			String[] shprCntSeq = (JSPUtil.getParameter(request, prefix	+ "shpr_cnt_seq", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] fcustCntSeq = (JSPUtil.getParameter(request, prefix	+ "fcust_cnt_seq", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] payXchRt = (JSPUtil.getParameter(request, prefix	+ "pay_xch_rt", length));
			String[] gDeltFlg = (JSPUtil.getParameter(request, prefix	+ "g_delt_flg", length));

			for (int i = 0; i < length; i++) {
				model = new SCompAgreementVO();
				if (spclRfTeuAmt[i] != null)
					model.setSpclRfTeuAmt(spclRfTeuAmt[i]);
				if (spclTeuAmt[i] != null)
					model.setSpclTeuAmt(spclTeuAmt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (porGrpTpCd[i] != null)
					model.setPorGrpTpCd(porGrpTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (podRoutCd[i] != null)
					model.setPodRoutCd(podRoutCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (spclFeuAmt[i] != null)
					model.setSpclFeuAmt(spclFeuAmt[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (fmEffDt[i] != null)
					model.setFmEffDt(fmEffDt[i]);
				if (shprCntNm[i] != null)
					model.setShprCntNm(shprCntNm[i]);
				if (porRoutCd[i] != null)
					model.setPorRoutCd(porRoutCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (polRoutCd[i] != null)
					model.setPolRoutCd(polRoutCd[i]);
				if (spclCntCustNm[i] != null)
					model.setSpclCntCustNm(spclCntCustNm[i]);
				if (spclOfcCd[i] != null)
					model.setSpclOfcCd(spclOfcCd[i]);
				if (polGrpTpCd[i] != null)
					model.setPolGrpTpCd(polGrpTpCd[i]);
				if (spclAgmtSeq[i] != null)
					model.setSpclAgmtSeq(spclAgmtSeq[i]);
				if (spclRfFeuAmt[i] != null)
					model.setSpclRfFeuAmt(spclRfFeuAmt[i]);
				if (spclChgCtnt[i] != null)
					model.setSpclChgCtnt(spclChgCtnt[i]);
				if (toEffDt[i] != null)
					model.setToEffDt(toEffDt[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (spclBxAmt[i] != null)
					model.setSpclBxAmt(spclBxAmt[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (custCntSeq[i] != null)
					model.setCustCntSeq(custCntSeq[i]);
				if (spclDivCd[i] != null)
					model.setSpclDivCd(spclDivCd[i]);
				if (custKndCd[i] != null)
					model.setCustKndCd(custKndCd[i]);
				if (cmdtTpCd[i] != null)
					model.setCmdtTpCd(cmdtTpCd[i]);
				if (spclBkgRt[i] != null)
					model.setSpclBkgRt(spclBkgRt[i]);
				if (podGrpTpCd[i] != null)
					model.setPodGrpTpCd(podGrpTpCd[i]);
				if (spclRfAmt[i] != null)
					model.setSpclRfAmt(spclRfAmt[i]);
				if (shprCntSeq[i] != null)
					model.setShprCntSeq(shprCntSeq[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (fcustCntSeq[i] != null)
					model.setFcustCntSeq(fcustCntSeq[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (payXchRt[i] != null)
					model.setPayXchRt(payXchRt[i]);
				if (gDeltFlg[i] != null)
					model.setGDeltFlg(gDeltFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSCompAgreementVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SCompAgreementVO[]
	 */
	public SCompAgreementVO[] getSCompAgreementVOs(){
		SCompAgreementVO[] vos = (SCompAgreementVO[])models.toArray(new SCompAgreementVO[models.size()]);
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
		this.spclRfTeuAmt = this.spclRfTeuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclTeuAmt = this.spclTeuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porGrpTpCd = this.porGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podRoutCd = this.podRoutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclFeuAmt = this.spclFeuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEffDt = this.fmEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCntNm = this.shprCntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porRoutCd = this.porRoutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polRoutCd = this.polRoutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCntCustNm = this.spclCntCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclOfcCd = this.spclOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polGrpTpCd = this.polGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclAgmtSeq = this.spclAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclRfFeuAmt = this.spclRfFeuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclChgCtnt = this.spclChgCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEffDt = this.toEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclBxAmt = this.spclBxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntSeq = this.custCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclDivCd = this.spclDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custKndCd = this.custKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtTpCd = this.cmdtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclBkgRt = this.spclBkgRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podGrpTpCd = this.podGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclRfAmt = this.spclRfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCntSeq = this.shprCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcustCntSeq = this.fcustCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payXchRt = this.payXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gDeltFlg = this.gDeltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
