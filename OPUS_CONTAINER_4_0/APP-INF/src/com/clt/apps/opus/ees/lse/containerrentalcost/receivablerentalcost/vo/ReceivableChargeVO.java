/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReceivableChargeVO.java
*@FileTitle : ReceivableChargeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.08.26 장준우
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 장준우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ReceivableChargeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<ReceivableChargeVO> models = new ArrayList<ReceivableChargeVO>();

	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String ttlChgAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String qtyYrmon = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String lseCntrChgStsCd = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String rcvRntlSeq = null;
	/* Column Info */
	private String invCreUsrId = null;
	/* Column Info */
	private String invCreDt = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String crAmt = null;
	/* Column Info */
	private String srcIfDt = null;
	/* Column Info */
	private String srcIfSeq = null;
	/* Column Info */
	private String glEffDt = null;
	/* Column Info */
	private String dueDt = null;
	/* Column Info */
	private String invIsuDt = null;
	/* Column Info */
	private String invDueDt = null;
	/* Column Info */
	private String invIfFlg = null;
	/* Column Info */
	private String ifErrRsn = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String custEngNm = null;
	/* Column Info */
	private String loclXchRt = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String loclTaxFlg = null;
	/* Column Info */
	private String loclTaxAmt = null;
	/* Column Info */
	private String loclTtlChgAmt = null;
	/* Column Info */
	private String loclChgAmt = null;
	/* Column Info */
	private String cfmFlg = null;
	/* Column Info */
	private String invCreOfcCd = null;
	/* Column Info */
	private String cfmOfcCd = null;
	/*	Column Info	*/
	private  String	 invTaxRt   =  null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public ReceivableChargeVO() {}

	public ReceivableChargeVO(String ibflag, String invCreOfcCd, String cfmOfcCd, String cfmFlg, String loclXchRt, String loclCurrCd, String loclTaxFlg, String loclTaxAmt, String loclTtlChgAmt, String loclChgAmt,
			String custCntCd, String custSeq, String custEngNm, String pagerows, String invIfFlg, String ifErrRsn, String invIsuDt, String invDueDt, String srcIfDt, String srcIfSeq, String glEffDt, String dueDt, String crAmt, String ofcCd, String costYrmon, String qtyYrmon, String rcvRntlSeq, String lseCntrChgStsCd, String lstmCd, String agmtCtyCd, String agmtSeq, String agmtNo, String refNo, String effDt, String expDt, String vndrAbbrNm, String vndrSeq, String currCd, String ttlChgAmt, String invNo, String creUsrId, String updUsrId, String invCreUsrId, String invCreDt,String invTaxRt) {
		this.currCd = currCd;
		this.agmtNo = agmtNo;
		this.agmtSeq = agmtSeq;
		this.ttlChgAmt = ttlChgAmt;
		this.pagerows = pagerows;
		this.invNo = invNo;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.costYrmon = costYrmon;
		this.vndrSeq = vndrSeq;
		this.qtyYrmon = qtyYrmon;
		this.agmtCtyCd = agmtCtyCd;
		this.lseCntrChgStsCd = lseCntrChgStsCd;
		this.refNo = refNo;
		this.vndrAbbrNm = vndrAbbrNm;
		this.expDt = expDt;
		this.lstmCd = lstmCd;
		this.updUsrId = updUsrId;
		this.rcvRntlSeq = rcvRntlSeq;
		this.invCreUsrId = invCreUsrId;
		this.invCreDt = invCreDt;
		this.ofcCd = ofcCd;
		this.crAmt = crAmt;
		this.srcIfDt  = srcIfDt;
		this.srcIfSeq = srcIfSeq;
		this.glEffDt  = glEffDt;
		this.dueDt    = dueDt;
		this.invIsuDt = invIsuDt;
		this.invDueDt = invDueDt;
		this.invIfFlg = invIfFlg;
		this.ifErrRsn = ifErrRsn;
		this.custCntCd = custCntCd;
		this.custSeq = custSeq;
		this.custEngNm = custEngNm;
		this.loclXchRt = loclXchRt;
		this.loclCurrCd = loclCurrCd;
		this.loclTaxFlg = loclTaxFlg;
		this.loclTaxAmt = loclTaxAmt;
		this.loclTtlChgAmt = loclTtlChgAmt;
		this.loclChgAmt = loclChgAmt;
		this.cfmFlg = cfmFlg;
		this.invCreOfcCd = invCreOfcCd;
		this.cfmOfcCd = cfmOfcCd;
		this.invTaxRt  = invTaxRt ;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("ttl_chg_amt", getTtlChgAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("qty_yrmon", getQtyYrmon());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("lse_cntr_chg_sts_cd", getLseCntrChgStsCd());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rcv_rntl_seq", getRcvRntlSeq());
		this.hashColumns.put("inv_cre_usr_id", getInvCreUsrId());
		this.hashColumns.put("inv_cre_dt", getInvCreDt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cr_amt", getCrAmt());
		this.hashColumns.put("src_if_dt", getSrcIfDt());
		this.hashColumns.put("src_if_seq", getSrcIfSeq());
		this.hashColumns.put("gl_eff_dt", getGlEffDt());
		this.hashColumns.put("due_dt", getDueDt());
		this.hashColumns.put("inv_isu_dt", getInvIsuDt());
		this.hashColumns.put("inv_due_dt", getInvDueDt());
		this.hashColumns.put("inv_if_flg", getInvIfFlg());
		this.hashColumns.put("if_err_rsn", getIfErrRsn());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cust_eng_nm", getCustEngNm());
		this.hashColumns.put("locl_xch_rt", getLoclXchRt());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("locl_tax_flg", getLoclTaxFlg());
		this.hashColumns.put("locl_tax_amt", getLoclTaxAmt());
		this.hashColumns.put("locl_ttl_chg_amt", getLoclTtlChgAmt());
		this.hashColumns.put("locl_chg_amt", getLoclChgAmt());
		this.hashColumns.put("cfm_flg", getCfmFlg());
		this.hashColumns.put("inv_cre_ofc_cd", getInvCreOfcCd());
		this.hashColumns.put("cfm_ofc_cd", getCfmOfcCd());
		this.hashColumns.put("inv_tax_rt", getInvTaxRt());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("ttl_chg_amt", "ttlChgAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("qty_yrmon", "qtyYrmon");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("lse_cntr_chg_sts_cd", "lseCntrChgStsCd");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rcv_rntl_seq", "rcvRntlSeq");
		this.hashFields.put("inv_cre_usr_id", "invCreUsrId");
		this.hashFields.put("inv_cre_dt", "invCreDt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cr_amt", "crAmt");
		this.hashFields.put("src_if_dt", "srcIfDt");
		this.hashFields.put("src_if_seq", "srcIfSeq");
		this.hashFields.put("gl_eff_dt", "glEffDt");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("inv_isu_dt", "invIsuDt");
		this.hashFields.put("inv_due_dt", "invDueDt");
		this.hashFields.put("inv_if_flg", "invIfFlg");
		this.hashFields.put("if_err_rsn", "ifErrRsn");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cust_eng_nm", "custEngNm");
		this.hashFields.put("locl_xch_rt", "loclXchRt");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("locl_tax_flg", "loclTaxFlg");
		this.hashFields.put("locl_tax_amt", "loclTaxAmt");
		this.hashFields.put("locl_ttl_chg_amt", "loclTtlChgAmt");
		this.hashFields.put("locl_chg_amt", "loclChgAmt");
		this.hashFields.put("cfm_flg", "cfmFlg");
		this.hashFields.put("inv_cre_ofc_cd", "invCreOfcCd");
		this.hashFields.put("cfm_ofc_cd", "cfmOfcCd");
		this.hashFields.put("inv_tax_rt", "invTaxRt");
		return this.hashFields;
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
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}

	/**
	 * Column Info
	 * @return ttlChgAmt
	 */
	public String getTtlChgAmt() {
		return this.ttlChgAmt;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}

	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
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
	 * @return qtyYrmon
	 */
	public String getQtyYrmon() {
		return this.qtyYrmon;
	}

	/**
	 * Column Info
	 * @return agmtCtyCd
	 */
	public String getAgmtCtyCd() {
		return this.agmtCtyCd;
	}

	/**
	 * Column Info
	 * @return lseCntrChgStsCd
	 */
	public String getLseCntrChgStsCd() {
		return this.lseCntrChgStsCd;
	}

	/**
	 * Column Info
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
	}

	/**
	 * Column Info
	 * @return vndrAbbrNm
	 */
	public String getVndrAbbrNm() {
		return this.vndrAbbrNm;
	}

	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}

	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
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
	 * @return rcvRntlSeq
	 */
	public String getRcvRntlSeq() {
		return this.rcvRntlSeq;
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
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}

	/**
	 * Column Info
	 * @param ttlChgAmt
	 */
	public void setTtlChgAmt(String ttlChgAmt) {
		this.ttlChgAmt = ttlChgAmt;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
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
	 * @param qtyYrmon
	 */
	public void setQtyYrmon(String qtyYrmon) {
		this.qtyYrmon = qtyYrmon;
	}

	/**
	 * Column Info
	 * @param agmtCtyCd
	 */
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
	}

	/**
	 * Column Info
	 * @param lseCntrChgStsCd
	 */
	public void setLseCntrChgStsCd(String lseCntrChgStsCd) {
		this.lseCntrChgStsCd = lseCntrChgStsCd;
	}

	/**
	 * Column Info
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	/**
	 * Column Info
	 * @param vndrAbbrNm
	 */
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
	}

	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}

	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
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
	 * @param rcvRntlSeq
	 */
	public void setRcvRntlSeq(String rcvRntlSeq) {
		this.rcvRntlSeq = rcvRntlSeq;
	}

	/**
	 * @return the agmtNo
	 */
	public String getAgmtNo() {
		return agmtNo;
	}

	/**
	 * @param agmtNo the agmtNo to set
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}

	/**
	 * @return the invCreUsrId
	 */
	public String getInvCreUsrId() {
		return invCreUsrId;
	}

	/**
	 * @param invCreUsrId the invCreUsrId to set
	 */
	public void setInvCreUsrId(String invCreUsrId) {
		this.invCreUsrId = invCreUsrId;
	}

	/**
	 * @return the invCreDt
	 */
	public String getInvCreDt() {
		return invCreDt;
	}

	/**
	 * @param invCreDt the invCreDt to set
	 */
	public void setInvCreDt(String invCreDt) {
		this.invCreDt = invCreDt;
	}

	/**
	 * @return the ofcCd
	 */
	public String getOfcCd() {
		return ofcCd;
	}

	/**
	 * @param ofcCd the ofcCd to set
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	/**
	 * @return the crAmt
	 */
	public String getCrAmt() {
		return crAmt;
	}

	/**
	 * @param crAmt the crAmt to set
	 */
	public void setCrAmt(String crAmt) {
		this.crAmt = crAmt;
	}

	/**
	 * @return the srcIfDt
	 */
	public String getSrcIfDt() {
		return srcIfDt;
	}

	/**
	 * @param srcIfDt the srcIfDt to set
	 */
	public void setSrcIfDt(String srcIfDt) {
		this.srcIfDt = srcIfDt;
	}

	/**
	 * @return the srcIfSeq
	 */
	public String getSrcIfSeq() {
		return srcIfSeq;
	}

	/**
	 * @param srcIfSeq the srcIfSeq to set
	 */
	public void setSrcIfSeq(String srcIfSeq) {
		this.srcIfSeq = srcIfSeq;
	}

	/**
	 * @return the glEffDt
	 */
	public String getGlEffDt() {
		return glEffDt;
	}

	/**
	 * @param glEffDt the glEffDt to set
	 */
	public void setGlEffDt(String glEffDt) {
		this.glEffDt = glEffDt;
	}

	/**
	 * @return the dueDt
	 */
	public String getDueDt() {
		return dueDt;
	}

	/**
	 * @param dueDt the dueDt to set
	 */
	public void setDueDt(String dueDt) {
		this.dueDt = dueDt;
	}

	/**
	 * @return the invIsuDt
	 */
	public String getInvIsuDt() {
		return invIsuDt;
	}

	/**
	 * @param invIsuDt the invIsuDt to set
	 */
	public void setInvIsuDt(String invIsuDt) {
		this.invIsuDt = invIsuDt;
	}

	/**
	 * @return the invDueDt
	 */
	public String getInvDueDt() {
		return invDueDt;
	}

	/**
	 * @param invDueDt the invDueDt to set
	 */
	public void setInvDueDt(String invDueDt) {
		this.invDueDt = invDueDt;
	}

	/**
	 * @return the invIfFlg
	 */
	public String getInvIfFlg() {
		return invIfFlg;
	}

	/**
	 * @param invIfFlg the invIfFlg to set
	 */
	public void setInvIfFlg(String invIfFlg) {
		this.invIfFlg = invIfFlg;
	}

	/**
	 * @return the ifErrRsn
	 */
	public String getIfErrRsn() {
		return ifErrRsn;
	}

	/**
	 * @param ifErrRsn the ifErrRsn to set
	 */
	public void setIfErrRsn(String ifErrRsn) {
		this.ifErrRsn = ifErrRsn;
	}

	/**
	 * @return the custCntCd
	 */
	public String getCustCntCd() {
		return custCntCd;
	}

	/**
	 * @param custCntCd the custCntCd to set
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}

	/**
	 * @return the custSeq
	 */
	public String getCustSeq() {
		return custSeq;
	}

	/**
	 * @param custSeq the custSeq to set
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}

	/**
	 * @return the custEngNm
	 */
	public String getCustEngNm() {
		return custEngNm;
	}

	/**
	 * @param custEngNm the custEngNm to set
	 */
	public void setCustEngNm(String custEngNm) {
		this.custEngNm = custEngNm;
	}

	/**
	 * @return the loclXchRt
	 */
	public String getLoclXchRt() {
		return loclXchRt;
	}

	/**
	 * @param loclXchRt the loclXchRt to set
	 */
	public void setLoclXchRt(String loclXchRt) {
		this.loclXchRt = loclXchRt;
	}

	/**
	 * @return the loclCurrCd
	 */
	public String getLoclCurrCd() {
		return loclCurrCd;
	}

	/**
	 * @param loclCurrCd the loclCurrCd to set
	 */
	public void setLoclCurrCd(String loclCurrCd) {
		this.loclCurrCd = loclCurrCd;
	}

	/**
	 * @return the loclTaxFlg
	 */
	public String getLoclTaxFlg() {
		return loclTaxFlg;
	}

	/**
	 * @param loclTaxFlg the loclTaxFlg to set
	 */
	public void setLoclTaxFlg(String loclTaxFlg) {
		this.loclTaxFlg = loclTaxFlg;
	}

	/**
	 * @return the loclTaxAmt
	 */
	public String getLoclTaxAmt() {
		return loclTaxAmt;
	}

	/**
	 * @param loclTaxAmt the loclTaxAmt to set
	 */
	public void setLoclTaxAmt(String loclTaxAmt) {
		this.loclTaxAmt = loclTaxAmt;
	}

	/**
	 * @return the loclTtlChgAmt
	 */
	public String getLoclTtlChgAmt() {
		return loclTtlChgAmt;
	}

	/**
	 * @param loclTtlChgAmt the loclTtlChgAmt to set
	 */
	public void setLoclTtlChgAmt(String loclTtlChgAmt) {
		this.loclTtlChgAmt = loclTtlChgAmt;
	}

	/**
	 * @return the loclChgAmt
	 */
	public String getLoclChgAmt() {
		return loclChgAmt;
	}

	/**
	 * @param loclChgAmt the loclChgAmt to set
	 */
	public void setLoclChgAmt(String loclChgAmt) {
		this.loclChgAmt = loclChgAmt;
	}

	/**
	 * @return the cfmFlg
	 */
	public String getCfmFlg() {
		return cfmFlg;
	}

	/**
	 * @param cfmFlg the cfmFlg to set
	 */
	public void setCfmFlg(String cfmFlg) {
		this.cfmFlg = cfmFlg;
	}

	/**
	 * @return the invCreOfcCd
	 */
	public String getInvCreOfcCd() {
		return invCreOfcCd;
	}

	/**
	 * @param invCreOfcCd the invCreOfcCd to set
	 */
	public void setInvCreOfcCd(String invCreOfcCd) {
		this.invCreOfcCd = invCreOfcCd;
	}

	/**
	 * @return the cfmOfcCd
	 */
	public String getCfmOfcCd() {
		return cfmOfcCd;
	}

	/**
	 * @param cfmOfcCd the cfmOfcCd to set
	 */
	public void setCfmOfcCd(String cfmOfcCd) {
		this.cfmOfcCd = cfmOfcCd;
	}
	
	/**
	* Column Info
	* @param  invTaxRt
	*/
	public void	setInvTaxRt( String	invTaxRt ) {
		this.invTaxRt =	invTaxRt;
	}
 
	/**
	 * Column Info
	 * @return	invTaxRt
	 */
	 public	 String	getInvTaxRt() {
		 return	this.invTaxRt;
	 } 

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setTtlChgAmt(JSPUtil.getParameter(request, "ttl_chg_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setQtyYrmon(JSPUtil.getParameter(request, "qty_yrmon", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setLseCntrChgStsCd(JSPUtil.getParameter(request, "lse_cntr_chg_sts_cd", ""));
		setRefNo(JSPUtil.getParameter(request, "ref_no", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, "vndr_abbr_nm", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setRcvRntlSeq(JSPUtil.getParameter(request, "rcv_rntl_seq", ""));
		setInvCreUsrId(JSPUtil.getParameter(request, "inv_cre_usr_id", ""));
		setInvCreDt(JSPUtil.getParameter(request, "inv_cre_dt", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCrAmt(JSPUtil.getParameter(request, "cr_amt", ""));
		setSrcIfDt(JSPUtil.getParameter(request, "src_if_dt", ""));
		setSrcIfSeq(JSPUtil.getParameter(request, "src_if_seq", ""));
		setGlEffDt(JSPUtil.getParameter(request, "gl_eff_dt", ""));
		setDueDt(JSPUtil.getParameter(request, "due_dt", ""));
		setInvIsuDt(JSPUtil.getParameter(request, "inv_isu_dt", ""));
		setInvDueDt(JSPUtil.getParameter(request, "inv_due_dt", ""));
		setInvIfFlg(JSPUtil.getParameter(request, "inv_if_flg", ""));
		setIfErrRsn(JSPUtil.getParameter(request, "f_err_rsn", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setCustEngNm(JSPUtil.getParameter(request, "cust_eng_nm", ""));
		setLoclXchRt(JSPUtil.getParameter(request, "locl_xch_rt", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, "locl_curr_cd", ""));
		setLoclTaxFlg(JSPUtil.getParameter(request, "locl_tax_flg", ""));
		setLoclTaxAmt(JSPUtil.getParameter(request, "locl_tax_amt", ""));
		setLoclTtlChgAmt(JSPUtil.getParameter(request, "locl_ttl_chg_amt", ""));
		setLoclChgAmt(JSPUtil.getParameter(request, "locl_chg_amt", ""));
		setCfmFlg(JSPUtil.getParameter(request, "cfm_flg", ""));
		setInvCreOfcCd(JSPUtil.getParameter(request, "inv_cre_ofc_cd", ""));
		setCfmOfcCd(JSPUtil.getParameter(request, "cfm_ofc_cd", ""));
		setInvTaxRt(JSPUtil.getParameter(request,	"inv_tax_rt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ReceivableChargeVO[]
	 */
	public ReceivableChargeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ReceivableChargeVO[]
	 */
	public ReceivableChargeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ReceivableChargeVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] ttlChgAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_chg_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] qtyYrmon = (JSPUtil.getParameter(request, prefix	+ "qty_yrmon", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] lseCntrChgStsCd = (JSPUtil.getParameter(request, prefix	+ "lse_cntr_chg_sts_cd", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] rcvRntlSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_rntl_seq", length));
			String[] invCreUsrId = (JSPUtil.getParameter(request, prefix	+ "inv_cre_usr_id", length));
			String[] invCreDt = (JSPUtil.getParameter(request, prefix	+ "inv_cre_dt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] crAmt = (JSPUtil.getParameter(request, prefix	+ "cr_amt", length));
			String[] srcIfDt = (JSPUtil.getParameter(request, prefix	+ "src_if_dt", length));
			String[] srcIfSeq = (JSPUtil.getParameter(request, prefix	+ "src_if_seq", length));
			String[] glEffDt = (JSPUtil.getParameter(request, prefix	+ "gl_eff_dt", length));
			String[] dueDt = (JSPUtil.getParameter(request, prefix	+ "due_dt", length));
			String[] invIsuDt = (JSPUtil.getParameter(request, prefix	+ "inv_isu_dt", length));
			String[] invDueDt = (JSPUtil.getParameter(request, prefix	+ "inv_due_dt", length));
			String[] invIfFlg = (JSPUtil.getParameter(request, prefix	+ "inv_if_flg", length));
			String[] ifErrRsn = (JSPUtil.getParameter(request, prefix	+ "if_err_rsn", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] custEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_eng_nm", length));
			String[] loclXchRt = (JSPUtil.getParameter(request, prefix	+ "locl_xch_rt", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] loclTaxFlg = (JSPUtil.getParameter(request, prefix	+ "locl_tax_flg", length));
			String[] loclTaxAmt = (JSPUtil.getParameter(request, prefix	+ "locl_tax_amt", length));
			String[] loclTtlChgAmt = (JSPUtil.getParameter(request, prefix	+ "locl_ttl_chg_amt", length));
			String[] loclChgAmt = (JSPUtil.getParameter(request, prefix	+ "locl_chg_amt", length));
			String[] cfmFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_flg", length));
			String[] invCreOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_cre_ofc_cd", length));
			String[] cfmOfcCd = (JSPUtil.getParameter(request, prefix	+ "cfm_ofc_cd", length));
			String[] invTaxRt =	(JSPUtil.getParameter(request, prefix +	"inv_tax_rt".trim(),	length));

			for (int i = 0; i < length; i++) {
				model = new ReceivableChargeVO();
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (ttlChgAmt[i] != null)
					model.setTtlChgAmt(ttlChgAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (qtyYrmon[i] != null)
					model.setQtyYrmon(qtyYrmon[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (lseCntrChgStsCd[i] != null)
					model.setLseCntrChgStsCd(lseCntrChgStsCd[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (rcvRntlSeq[i] != null)
					model.setRcvRntlSeq(rcvRntlSeq[i]);
				if (invCreUsrId[i] != null)
					model.setInvCreUsrId(invCreUsrId[i]);
				if (invCreDt[i] != null)
					model.setInvCreDt(invCreDt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (crAmt[i] != null)
					model.setCrAmt(crAmt[i]);
				if (srcIfDt[i] != null)
					model.setSrcIfDt(srcIfDt[i]);
				if (srcIfSeq[i] != null)
					model.setSrcIfSeq(srcIfSeq[i]);
				if (glEffDt[i] != null)
					model.setGlEffDt(glEffDt[i]);
				if (dueDt[i] != null)
					model.setDueDt(dueDt[i]);
				if (invIsuDt[i] != null)
					model.setInvIsuDt(invIsuDt[i]);
				if (invDueDt[i] != null)
					model.setInvDueDt(invDueDt[i]);
				if (invIfFlg[i] != null)
					model.setInvIfFlg(invIfFlg[i]);
				if (ifErrRsn[i] != null)
					model.setIfErrRsn(ifErrRsn[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (custEngNm[i] != null)
					model.setCustEngNm(custEngNm[i]);
				if (loclXchRt[i] != null)
					model.setLoclXchRt(loclXchRt[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (loclTaxFlg[i] != null)
					model.setLoclTaxFlg(loclTaxFlg[i]);
				if (loclTaxAmt[i] != null)
					model.setLoclTaxAmt(loclTaxAmt[i]);
				if (loclTtlChgAmt[i] != null)
					model.setLoclTtlChgAmt(loclTtlChgAmt[i]);
				if (loclChgAmt[i] != null)
					model.setLoclChgAmt(loclChgAmt[i]);
				if (cfmFlg[i] != null)
					model.setCfmFlg(cfmFlg[i]);
				if (invCreOfcCd[i] != null)
					model.setInvCreOfcCd(invCreOfcCd[i]);
				if (cfmOfcCd[i] != null)
					model.setCfmOfcCd(cfmOfcCd[i]);
				if ( invTaxRt[i] !=	null)
					model.setInvTaxRt( invTaxRt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getReceivableChargeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ReceivableChargeVO[]
	 */
	public ReceivableChargeVO[] getReceivableChargeVOs(){
		ReceivableChargeVO[] vos = (ReceivableChargeVO[])models.toArray(new ReceivableChargeVO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}

	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlChgAmt = this.ttlChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtyYrmon = this.qtyYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseCntrChgStsCd = this.lseCntrChgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvRntlSeq = this.rcvRntlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCreUsrId = this.invCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCreDt = this.invCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crAmt = this.crAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.srcIfDt = this.srcIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcIfSeq = this.srcIfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glEffDt = this.glEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt = this.dueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIsuDt = this.invIsuDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDueDt = this.invDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIfFlg = this.invIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifErrRsn = this.ifErrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEngNm = this.custEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclXchRt = this.loclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclTaxFlg = this.loclTaxFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclTaxAmt = this.loclTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclTtlChgAmt = this.loclTtlChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclChgAmt = this.loclChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlg = this.cfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCreOfcCd = this.invCreOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmOfcCd = this.cfmOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTaxRt =	this.invTaxRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
