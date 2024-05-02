/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomPamCsulSlpVO.java
*@FileTitle : CustomPamCsulSlpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.09.02 정윤태 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정윤태
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomPamCsulSlpVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomPamCsulSlpVO> models = new ArrayList<CustomPamCsulSlpVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String fletSrcTpCd = null;
	/* Column Info */
	private String ownrAcctSlpCsrNo = null;
	/* Column Info */
	private String slpFuncCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String seqNo = null;
	/* Column Info */
	private String csrDesc = null;
	/* Column Info */
	private String bunkerVvd = null;
	/* Column Info */
	private String invSeq = null;
	/* Column Info */
	private String keyNumber = null;
	/* Column Info */
	private String fletIssTpCd = null;
	/* Column Info */
	private String fletCtrtNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String ctrCd = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String apSlpTpCd = null;
	/* Column Info */
	private String slpEffDt = null;
	/* Column Info */
	private String slpTpCd = null;
	/* Column Info */
	private String vatFlg = null;
	/* Column Info */
	private String apSlpIssDt = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String apSlpSerNo = null;
	/* Column Info */
	private String apSlpFuncCd = null;
	/* Column Info */
	private String csulSlpOfcCd = null;
	/* Column Info */
	private String vatApply = null;
	/* Column Info */
	private String slpSeqNo = null;
	/* Column Info */
	private String bnkSeq = null;
	/* Column Info */
	private String slpIssDt = null;
	/* Column Info */
	private String slpOfcCd = null;
	/* Column Info */
	private String apSlpSeqNo = null;
	/* Column Info */
	private String apSlpOfcCd = null;
	/* Column Info */
	private String csulSlpIssDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String csulSlpSerNo = null;
	/* Column Info */
	private String csulSlpFuncCd = null;
	/* Column Info */
	private String csulSlpTpCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String keyFlg = null;
	/* Column Info */
	private String invDtlSeq = null;
	/* Column Info */
	private String csrAmt = null;
	/* Column Info */
	private String popGb = null;
	/* Column Info */
	private String slpSerNo = null;
	/* Column Info */
	private String slpLocCd = null;
	/* Column Info */
	private String autoFlg = null;
	/* Column Info */
	private String orgFletCtrtNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomPamCsulSlpVO() {}

	public CustomPamCsulSlpVO(String ibflag, String pagerows, String seqNo, String acctCd, String vndrSeq, String ctrCd, String slpLocCd, String slpEffDt, String csrAmt, String bunkerVvd, String keyNumber, String csrDesc, String invSeq, String fletSrcTpCd, String invDtlSeq, String ownrAcctSlpCsrNo, String bnkSeq, String fletIssTpCd, String effDt, String expDt, String vatApply, String popGb, String vatFlg, String slpTpCd, String slpFuncCd, String slpOfcCd, String slpIssDt, String slpSerNo, String slpSeqNo, String fletCtrtNo, String keyFlg, String creUsrId, String updUsrId, String currCd, String vslCd, String csulSlpTpCd, String csulSlpFuncCd, String csulSlpOfcCd, String csulSlpIssDt, String csulSlpSerNo, String apSlpTpCd, String apSlpFuncCd, String apSlpOfcCd, String apSlpIssDt, String apSlpSerNo, String apSlpSeqNo, String autoFlg, String orgFletCtrtNo) {
		this.vslCd = vslCd;
		this.fletSrcTpCd = fletSrcTpCd;
		this.ownrAcctSlpCsrNo = ownrAcctSlpCsrNo;
		this.slpFuncCd = slpFuncCd;
		this.currCd = currCd;
		this.seqNo = seqNo;
		this.csrDesc = csrDesc;
		this.bunkerVvd = bunkerVvd;
		this.invSeq = invSeq;
		this.keyNumber = keyNumber;
		this.fletIssTpCd = fletIssTpCd;
		this.fletCtrtNo = fletCtrtNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.ctrCd = ctrCd;
		this.acctCd = acctCd;
		this.apSlpTpCd = apSlpTpCd;
		this.slpEffDt = slpEffDt;
		this.slpTpCd = slpTpCd;
		this.vatFlg = vatFlg;
		this.apSlpIssDt = apSlpIssDt;
		this.expDt = expDt;
		this.updUsrId = updUsrId;
		this.apSlpSerNo = apSlpSerNo;
		this.apSlpFuncCd = apSlpFuncCd;
		this.csulSlpOfcCd = csulSlpOfcCd;
		this.vatApply = vatApply;
		this.slpSeqNo = slpSeqNo;
		this.bnkSeq = bnkSeq;
		this.slpIssDt = slpIssDt;
		this.slpOfcCd = slpOfcCd;
		this.apSlpSeqNo = apSlpSeqNo;
		this.apSlpOfcCd = apSlpOfcCd;
		this.csulSlpIssDt = csulSlpIssDt;
		this.creUsrId = creUsrId;
		this.csulSlpSerNo = csulSlpSerNo;
		this.csulSlpFuncCd = csulSlpFuncCd;
		this.csulSlpTpCd = csulSlpTpCd;
		this.vndrSeq = vndrSeq;
		this.keyFlg = keyFlg;
		this.invDtlSeq = invDtlSeq;
		this.csrAmt = csrAmt;
		this.popGb = popGb;
		this.slpSerNo = slpSerNo;
		this.slpLocCd = slpLocCd;
		this.autoFlg = autoFlg;
		this.orgFletCtrtNo = orgFletCtrtNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("flet_src_tp_cd", getFletSrcTpCd());
		this.hashColumns.put("ownr_acct_slp_csr_no", getOwnrAcctSlpCsrNo());
		this.hashColumns.put("slp_func_cd", getSlpFuncCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("seq_no", getSeqNo());
		this.hashColumns.put("csr_desc", getCsrDesc());
		this.hashColumns.put("bunker_vvd", getBunkerVvd());
		this.hashColumns.put("inv_seq", getInvSeq());
		this.hashColumns.put("key_number", getKeyNumber());
		this.hashColumns.put("flet_iss_tp_cd", getFletIssTpCd());
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ctr_cd", getCtrCd());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("ap_slp_tp_cd", getApSlpTpCd());
		this.hashColumns.put("slp_eff_dt", getSlpEffDt());
		this.hashColumns.put("slp_tp_cd", getSlpTpCd());
		this.hashColumns.put("vat_flg", getVatFlg());
		this.hashColumns.put("ap_slp_iss_dt", getApSlpIssDt());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ap_slp_ser_no", getApSlpSerNo());
		this.hashColumns.put("ap_slp_func_cd", getApSlpFuncCd());
		this.hashColumns.put("csul_slp_ofc_cd", getCsulSlpOfcCd());
		this.hashColumns.put("vat_apply", getVatApply());
		this.hashColumns.put("slp_seq_no", getSlpSeqNo());
		this.hashColumns.put("bnk_seq", getBnkSeq());
		this.hashColumns.put("slp_iss_dt", getSlpIssDt());
		this.hashColumns.put("slp_ofc_cd", getSlpOfcCd());
		this.hashColumns.put("ap_slp_seq_no", getApSlpSeqNo());
		this.hashColumns.put("ap_slp_ofc_cd", getApSlpOfcCd());
		this.hashColumns.put("csul_slp_iss_dt", getCsulSlpIssDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("csul_slp_ser_no", getCsulSlpSerNo());
		this.hashColumns.put("csul_slp_func_cd", getCsulSlpFuncCd());
		this.hashColumns.put("csul_slp_tp_cd", getCsulSlpTpCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("key_flg", getKeyFlg());
		this.hashColumns.put("inv_dtl_seq", getInvDtlSeq());
		this.hashColumns.put("csr_amt", getCsrAmt());
		this.hashColumns.put("pop_gb", getPopGb());
		this.hashColumns.put("slp_ser_no", getSlpSerNo());
		this.hashColumns.put("slp_loc_cd", getSlpLocCd());
		this.hashColumns.put("auto_flg", getAutoFlg());
		this.hashColumns.put("org_flet_ctrt_no", getOrgFletCtrtNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("flet_src_tp_cd", "fletSrcTpCd");
		this.hashFields.put("ownr_acct_slp_csr_no", "ownrAcctSlpCsrNo");
		this.hashFields.put("slp_func_cd", "slpFuncCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("seq_no", "seqNo");
		this.hashFields.put("csr_desc", "csrDesc");
		this.hashFields.put("bunker_vvd", "bunkerVvd");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("key_number", "keyNumber");
		this.hashFields.put("flet_iss_tp_cd", "fletIssTpCd");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ctr_cd", "ctrCd");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("ap_slp_tp_cd", "apSlpTpCd");
		this.hashFields.put("slp_eff_dt", "slpEffDt");
		this.hashFields.put("slp_tp_cd", "slpTpCd");
		this.hashFields.put("vat_flg", "vatFlg");
		this.hashFields.put("ap_slp_iss_dt", "apSlpIssDt");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ap_slp_ser_no", "apSlpSerNo");
		this.hashFields.put("ap_slp_func_cd", "apSlpFuncCd");
		this.hashFields.put("csul_slp_ofc_cd", "csulSlpOfcCd");
		this.hashFields.put("vat_apply", "vatApply");
		this.hashFields.put("slp_seq_no", "slpSeqNo");
		this.hashFields.put("bnk_seq", "bnkSeq");
		this.hashFields.put("slp_iss_dt", "slpIssDt");
		this.hashFields.put("slp_ofc_cd", "slpOfcCd");
		this.hashFields.put("ap_slp_seq_no", "apSlpSeqNo");
		this.hashFields.put("ap_slp_ofc_cd", "apSlpOfcCd");
		this.hashFields.put("csul_slp_iss_dt", "csulSlpIssDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("csul_slp_ser_no", "csulSlpSerNo");
		this.hashFields.put("csul_slp_func_cd", "csulSlpFuncCd");
		this.hashFields.put("csul_slp_tp_cd", "csulSlpTpCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("key_flg", "keyFlg");
		this.hashFields.put("inv_dtl_seq", "invDtlSeq");
		this.hashFields.put("csr_amt", "csrAmt");
		this.hashFields.put("pop_gb", "popGb");
		this.hashFields.put("slp_ser_no", "slpSerNo");
		this.hashFields.put("slp_loc_cd", "slpLocCd");
		this.hashFields.put("auto_flg", "autoFlg");
		this.hashFields.put("auto_flg", "autoFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return fletSrcTpCd
	 */
	public String getFletSrcTpCd() {
		return this.fletSrcTpCd;
	}
	
	/**
	 * Column Info
	 * @return ownrAcctSlpCsrNo
	 */
	public String getOwnrAcctSlpCsrNo() {
		return this.ownrAcctSlpCsrNo;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return seqNo
	 */
	public String getSeqNo() {
		return this.seqNo;
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
	 * @return bunkerVvd
	 */
	public String getBunkerVvd() {
		return this.bunkerVvd;
	}
	
	/**
	 * Column Info
	 * @return invSeq
	 */
	public String getInvSeq() {
		return this.invSeq;
	}
	
	/**
	 * Column Info
	 * @return keyNumber
	 */
	public String getKeyNumber() {
		return this.keyNumber;
	}
	
	/**
	 * Column Info
	 * @return fletIssTpCd
	 */
	public String getFletIssTpCd() {
		return this.fletIssTpCd;
	}
	
	/**
	 * Column Info
	 * @return fletCtrtNo
	 */
	public String getFletCtrtNo() {
		return this.fletCtrtNo;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return ctrCd
	 */
	public String getCtrCd() {
		return this.ctrCd;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return apSlpTpCd
	 */
	public String getApSlpTpCd() {
		return this.apSlpTpCd;
	}
	
	/**
	 * Column Info
	 * @return slpEffDt
	 */
	public String getSlpEffDt() {
		return this.slpEffDt;
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
	 * @return vatFlg
	 */
	public String getVatFlg() {
		return this.vatFlg;
	}
	
	/**
	 * Column Info
	 * @return apSlpIssDt
	 */
	public String getApSlpIssDt() {
		return this.apSlpIssDt;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return apSlpSerNo
	 */
	public String getApSlpSerNo() {
		return this.apSlpSerNo;
	}
	
	/**
	 * Column Info
	 * @return apSlpFuncCd
	 */
	public String getApSlpFuncCd() {
		return this.apSlpFuncCd;
	}
	
	/**
	 * Column Info
	 * @return csulSlpOfcCd
	 */
	public String getCsulSlpOfcCd() {
		return this.csulSlpOfcCd;
	}
	
	/**
	 * Column Info
	 * @return vatApply
	 */
	public String getVatApply() {
		return this.vatApply;
	}
	
	/**
	 * Column Info
	 * @return slpSeqNo
	 */
	public String getSlpSeqNo() {
		return this.slpSeqNo;
	}
	
	/**
	 * Column Info
	 * @return bnkSeq
	 */
	public String getBnkSeq() {
		return this.bnkSeq;
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
	 * @return apSlpSeqNo
	 */
	public String getApSlpSeqNo() {
		return this.apSlpSeqNo;
	}
	
	/**
	 * Column Info
	 * @return apSlpOfcCd
	 */
	public String getApSlpOfcCd() {
		return this.apSlpOfcCd;
	}
	
	/**
	 * Column Info
	 * @return csulSlpIssDt
	 */
	public String getCsulSlpIssDt() {
		return this.csulSlpIssDt;
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
	 * @return csulSlpSerNo
	 */
	public String getCsulSlpSerNo() {
		return this.csulSlpSerNo;
	}
	
	/**
	 * Column Info
	 * @return csulSlpFuncCd
	 */
	public String getCsulSlpFuncCd() {
		return this.csulSlpFuncCd;
	}
	
	/**
	 * Column Info
	 * @return csulSlpTpCd
	 */
	public String getCsulSlpTpCd() {
		return this.csulSlpTpCd;
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
	 * @return keyFlg
	 */
	public String getKeyFlg() {
		return this.keyFlg;
	}
	
	/**
	 * Column Info
	 * @return invDtlSeq
	 */
	public String getInvDtlSeq() {
		return this.invDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return csrAmt
	 */
	public String getCsrAmt() {
		return this.csrAmt;
	}
	
	/**
	 * Column Info
	 * @return popGb
	 */
	public String getPopGb() {
		return this.popGb;
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
	 * @return slpLocCd
	 */
	public String getSlpLocCd() {
		return this.slpLocCd;
	}
	
	/**
	 * Column Info
	 * @return autoFlg
	 */
	public String getAutoFlg() {
		return this.autoFlg;
	}
	
	/**
	 * Column Info
	 * @return orgFletCtrtNo
	 */
	public String getOrgFletCtrtNo() {
		return this.orgFletCtrtNo;
	}
	

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param fletSrcTpCd
	 */
	public void setFletSrcTpCd(String fletSrcTpCd) {
		this.fletSrcTpCd = fletSrcTpCd;
	}
	
	/**
	 * Column Info
	 * @param ownrAcctSlpCsrNo
	 */
	public void setOwnrAcctSlpCsrNo(String ownrAcctSlpCsrNo) {
		this.ownrAcctSlpCsrNo = ownrAcctSlpCsrNo;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param seqNo
	 */
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
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
	 * @param bunkerVvd
	 */
	public void setBunkerVvd(String bunkerVvd) {
		this.bunkerVvd = bunkerVvd;
	}
	
	/**
	 * Column Info
	 * @param invSeq
	 */
	public void setInvSeq(String invSeq) {
		this.invSeq = invSeq;
	}
	
	/**
	 * Column Info
	 * @param keyNumber
	 */
	public void setKeyNumber(String keyNumber) {
		this.keyNumber = keyNumber;
	}
	
	/**
	 * Column Info
	 * @param fletIssTpCd
	 */
	public void setFletIssTpCd(String fletIssTpCd) {
		this.fletIssTpCd = fletIssTpCd;
	}
	
	/**
	 * Column Info
	 * @param fletCtrtNo
	 */
	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param ctrCd
	 */
	public void setCtrCd(String ctrCd) {
		this.ctrCd = ctrCd;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param apSlpTpCd
	 */
	public void setApSlpTpCd(String apSlpTpCd) {
		this.apSlpTpCd = apSlpTpCd;
	}
	
	/**
	 * Column Info
	 * @param slpEffDt
	 */
	public void setSlpEffDt(String slpEffDt) {
		this.slpEffDt = slpEffDt;
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
	 * @param vatFlg
	 */
	public void setVatFlg(String vatFlg) {
		this.vatFlg = vatFlg;
	}
	
	/**
	 * Column Info
	 * @param apSlpIssDt
	 */
	public void setApSlpIssDt(String apSlpIssDt) {
		this.apSlpIssDt = apSlpIssDt;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param apSlpSerNo
	 */
	public void setApSlpSerNo(String apSlpSerNo) {
		this.apSlpSerNo = apSlpSerNo;
	}
	
	/**
	 * Column Info
	 * @param apSlpFuncCd
	 */
	public void setApSlpFuncCd(String apSlpFuncCd) {
		this.apSlpFuncCd = apSlpFuncCd;
	}
	
	/**
	 * Column Info
	 * @param csulSlpOfcCd
	 */
	public void setCsulSlpOfcCd(String csulSlpOfcCd) {
		this.csulSlpOfcCd = csulSlpOfcCd;
	}
	
	/**
	 * Column Info
	 * @param vatApply
	 */
	public void setVatApply(String vatApply) {
		this.vatApply = vatApply;
	}
	
	/**
	 * Column Info
	 * @param slpSeqNo
	 */
	public void setSlpSeqNo(String slpSeqNo) {
		this.slpSeqNo = slpSeqNo;
	}
	
	/**
	 * Column Info
	 * @param bnkSeq
	 */
	public void setBnkSeq(String bnkSeq) {
		this.bnkSeq = bnkSeq;
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
	 * @param apSlpSeqNo
	 */
	public void setApSlpSeqNo(String apSlpSeqNo) {
		this.apSlpSeqNo = apSlpSeqNo;
	}
	
	/**
	 * Column Info
	 * @param apSlpOfcCd
	 */
	public void setApSlpOfcCd(String apSlpOfcCd) {
		this.apSlpOfcCd = apSlpOfcCd;
	}
	
	/**
	 * Column Info
	 * @param csulSlpIssDt
	 */
	public void setCsulSlpIssDt(String csulSlpIssDt) {
		this.csulSlpIssDt = csulSlpIssDt;
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
	 * @param csulSlpSerNo
	 */
	public void setCsulSlpSerNo(String csulSlpSerNo) {
		this.csulSlpSerNo = csulSlpSerNo;
	}
	
	/**
	 * Column Info
	 * @param csulSlpFuncCd
	 */
	public void setCsulSlpFuncCd(String csulSlpFuncCd) {
		this.csulSlpFuncCd = csulSlpFuncCd;
	}
	
	/**
	 * Column Info
	 * @param csulSlpTpCd
	 */
	public void setCsulSlpTpCd(String csulSlpTpCd) {
		this.csulSlpTpCd = csulSlpTpCd;
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
	 * @param keyFlg
	 */
	public void setKeyFlg(String keyFlg) {
		this.keyFlg = keyFlg;
	}
	
	/**
	 * Column Info
	 * @param invDtlSeq
	 */
	public void setInvDtlSeq(String invDtlSeq) {
		this.invDtlSeq = invDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param csrAmt
	 */
	public void setCsrAmt(String csrAmt) {
		this.csrAmt = csrAmt;
	}
	
	/**
	 * Column Info
	 * @param popGb
	 */
	public void setPopGb(String popGb) {
		this.popGb = popGb;
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
	 * @param slpLocCd
	 */
	public void setSlpLocCd(String slpLocCd) {
		this.slpLocCd = slpLocCd;
	}
	
	/**
	 * Column Info
	 * @param autoFlg
	 */
	public void setAutoFlg(String autoFlg) {
		this.autoFlg = autoFlg;
	}
	
	/**
	 * Column Info
	 * @param orgFletCtrtNo
	 */
	public void setOrgFletCtrtNo(String orgFletCtrtNo) {
		this.orgFletCtrtNo = orgFletCtrtNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setFletSrcTpCd(JSPUtil.getParameter(request, "flet_src_tp_cd", ""));
		setOwnrAcctSlpCsrNo(JSPUtil.getParameter(request, "ownr_acct_slp_csr_no", ""));
		setSlpFuncCd(JSPUtil.getParameter(request, "slp_func_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setSeqNo(JSPUtil.getParameter(request, "seq_no", ""));
		setCsrDesc(JSPUtil.getParameter(request, "csr_desc", ""));
		setBunkerVvd(JSPUtil.getParameter(request, "bunker_vvd", ""));
		setInvSeq(JSPUtil.getParameter(request, "inv_seq", ""));
		setKeyNumber(JSPUtil.getParameter(request, "key_number", ""));
		setFletIssTpCd(JSPUtil.getParameter(request, "flet_iss_tp_cd", ""));
		setFletCtrtNo(JSPUtil.getParameter(request, "flet_ctrt_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setCtrCd(JSPUtil.getParameter(request, "ctr_cd", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setApSlpTpCd(JSPUtil.getParameter(request, "ap_slp_tp_cd", ""));
		setSlpEffDt(JSPUtil.getParameter(request, "slp_eff_dt", ""));
		setSlpTpCd(JSPUtil.getParameter(request, "slp_tp_cd", ""));
		setVatFlg(JSPUtil.getParameter(request, "vat_flg", ""));
		setApSlpIssDt(JSPUtil.getParameter(request, "ap_slp_iss_dt", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setApSlpSerNo(JSPUtil.getParameter(request, "ap_slp_ser_no", ""));
		setApSlpFuncCd(JSPUtil.getParameter(request, "ap_slp_func_cd", ""));
		setCsulSlpOfcCd(JSPUtil.getParameter(request, "csul_slp_ofc_cd", ""));
		setVatApply(JSPUtil.getParameter(request, "vat_apply", ""));
		setSlpSeqNo(JSPUtil.getParameter(request, "slp_seq_no", ""));
		setBnkSeq(JSPUtil.getParameter(request, "bnk_seq", ""));
		setSlpIssDt(JSPUtil.getParameter(request, "slp_iss_dt", ""));
		setSlpOfcCd(JSPUtil.getParameter(request, "slp_ofc_cd", ""));
		setApSlpSeqNo(JSPUtil.getParameter(request, "ap_slp_seq_no", ""));
		setApSlpOfcCd(JSPUtil.getParameter(request, "ap_slp_ofc_cd", ""));
		setCsulSlpIssDt(JSPUtil.getParameter(request, "csul_slp_iss_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCsulSlpSerNo(JSPUtil.getParameter(request, "csul_slp_ser_no", ""));
		setCsulSlpFuncCd(JSPUtil.getParameter(request, "csul_slp_func_cd", ""));
		setCsulSlpTpCd(JSPUtil.getParameter(request, "csul_slp_tp_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setKeyFlg(JSPUtil.getParameter(request, "key_flg", ""));
		setInvDtlSeq(JSPUtil.getParameter(request, "inv_dtl_seq", ""));
		setCsrAmt(JSPUtil.getParameter(request, "csr_amt", ""));
		setPopGb(JSPUtil.getParameter(request, "pop_gb", ""));
		setSlpSerNo(JSPUtil.getParameter(request, "slp_ser_no", ""));
		setSlpLocCd(JSPUtil.getParameter(request, "slp_loc_cd", ""));
		setAutoFlg(JSPUtil.getParameter(request, "auto_flg", ""));
		setOrgFletCtrtNo(JSPUtil.getParameter(request, "org_flet_ctrt_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomPamCsulSlpVO[]
	 */
	public CustomPamCsulSlpVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomPamCsulSlpVO[]
	 */
	public CustomPamCsulSlpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomPamCsulSlpVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] fletSrcTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_src_tp_cd", length));
			String[] ownrAcctSlpCsrNo = (JSPUtil.getParameter(request, prefix	+ "ownr_acct_slp_csr_no", length));
			String[] slpFuncCd = (JSPUtil.getParameter(request, prefix	+ "slp_func_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] seqNo = (JSPUtil.getParameter(request, prefix	+ "seq_no", length));
			String[] csrDesc = (JSPUtil.getParameter(request, prefix	+ "csr_desc", length));
			String[] bunkerVvd = (JSPUtil.getParameter(request, prefix	+ "bunker_vvd", length));
			String[] invSeq = (JSPUtil.getParameter(request, prefix	+ "inv_seq", length));
			String[] keyNumber = (JSPUtil.getParameter(request, prefix	+ "key_number", length));
			String[] fletIssTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_iss_tp_cd", length));
			String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ctrCd = (JSPUtil.getParameter(request, prefix	+ "ctr_cd", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] apSlpTpCd = (JSPUtil.getParameter(request, prefix	+ "ap_slp_tp_cd", length));
			String[] slpEffDt = (JSPUtil.getParameter(request, prefix	+ "slp_eff_dt", length));
			String[] slpTpCd = (JSPUtil.getParameter(request, prefix	+ "slp_tp_cd", length));
			String[] vatFlg = (JSPUtil.getParameter(request, prefix	+ "vat_flg", length));
			String[] apSlpIssDt = (JSPUtil.getParameter(request, prefix	+ "ap_slp_iss_dt", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] apSlpSerNo = (JSPUtil.getParameter(request, prefix	+ "ap_slp_ser_no", length));
			String[] apSlpFuncCd = (JSPUtil.getParameter(request, prefix	+ "ap_slp_func_cd", length));
			String[] csulSlpOfcCd = (JSPUtil.getParameter(request, prefix	+ "csul_slp_ofc_cd", length));
			String[] vatApply = (JSPUtil.getParameter(request, prefix	+ "vat_apply", length));
			String[] slpSeqNo = (JSPUtil.getParameter(request, prefix	+ "slp_seq_no", length));
			String[] bnkSeq = (JSPUtil.getParameter(request, prefix	+ "bnk_seq", length));
			String[] slpIssDt = (JSPUtil.getParameter(request, prefix	+ "slp_iss_dt", length));
			String[] slpOfcCd = (JSPUtil.getParameter(request, prefix	+ "slp_ofc_cd", length));
			String[] apSlpSeqNo = (JSPUtil.getParameter(request, prefix	+ "ap_slp_seq_no", length));
			String[] apSlpOfcCd = (JSPUtil.getParameter(request, prefix	+ "ap_slp_ofc_cd", length));
			String[] csulSlpIssDt = (JSPUtil.getParameter(request, prefix	+ "csul_slp_iss_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] csulSlpSerNo = (JSPUtil.getParameter(request, prefix	+ "csul_slp_ser_no", length));
			String[] csulSlpFuncCd = (JSPUtil.getParameter(request, prefix	+ "csul_slp_func_cd", length));
			String[] csulSlpTpCd = (JSPUtil.getParameter(request, prefix	+ "csul_slp_tp_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] keyFlg = (JSPUtil.getParameter(request, prefix	+ "key_flg", length));
			String[] invDtlSeq = (JSPUtil.getParameter(request, prefix	+ "inv_dtl_seq", length));
			String[] csrAmt = (JSPUtil.getParameter(request, prefix	+ "csr_amt", length));
			String[] popGb = (JSPUtil.getParameter(request, prefix	+ "pop_gb", length));
			String[] slpSerNo = (JSPUtil.getParameter(request, prefix	+ "slp_ser_no", length));
			String[] slpLocCd = (JSPUtil.getParameter(request, prefix	+ "slp_loc_cd", length));
			String[] autoFlg = (JSPUtil.getParameter(request, prefix	+ "auto_flg", length));
			String[] orgFletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "org_flet_ctrt_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomPamCsulSlpVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (fletSrcTpCd[i] != null)
					model.setFletSrcTpCd(fletSrcTpCd[i]);
				if (ownrAcctSlpCsrNo[i] != null)
					model.setOwnrAcctSlpCsrNo(ownrAcctSlpCsrNo[i]);
				if (slpFuncCd[i] != null)
					model.setSlpFuncCd(slpFuncCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (seqNo[i] != null)
					model.setSeqNo(seqNo[i]);
				if (csrDesc[i] != null)
					model.setCsrDesc(csrDesc[i]);
				if (bunkerVvd[i] != null)
					model.setBunkerVvd(bunkerVvd[i]);
				if (invSeq[i] != null)
					model.setInvSeq(invSeq[i]);
				if (keyNumber[i] != null)
					model.setKeyNumber(keyNumber[i]);
				if (fletIssTpCd[i] != null)
					model.setFletIssTpCd(fletIssTpCd[i]);
				if (fletCtrtNo[i] != null)
					model.setFletCtrtNo(fletCtrtNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ctrCd[i] != null)
					model.setCtrCd(ctrCd[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (apSlpTpCd[i] != null)
					model.setApSlpTpCd(apSlpTpCd[i]);
				if (slpEffDt[i] != null)
					model.setSlpEffDt(slpEffDt[i]);
				if (slpTpCd[i] != null)
					model.setSlpTpCd(slpTpCd[i]);
				if (vatFlg[i] != null)
					model.setVatFlg(vatFlg[i]);
				if (apSlpIssDt[i] != null)
					model.setApSlpIssDt(apSlpIssDt[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (apSlpSerNo[i] != null)
					model.setApSlpSerNo(apSlpSerNo[i]);
				if (apSlpFuncCd[i] != null)
					model.setApSlpFuncCd(apSlpFuncCd[i]);
				if (csulSlpOfcCd[i] != null)
					model.setCsulSlpOfcCd(csulSlpOfcCd[i]);
				if (vatApply[i] != null)
					model.setVatApply(vatApply[i]);
				if (slpSeqNo[i] != null)
					model.setSlpSeqNo(slpSeqNo[i]);
				if (bnkSeq[i] != null)
					model.setBnkSeq(bnkSeq[i]);
				if (slpIssDt[i] != null)
					model.setSlpIssDt(slpIssDt[i]);
				if (slpOfcCd[i] != null)
					model.setSlpOfcCd(slpOfcCd[i]);
				if (apSlpSeqNo[i] != null)
					model.setApSlpSeqNo(apSlpSeqNo[i]);
				if (apSlpOfcCd[i] != null)
					model.setApSlpOfcCd(apSlpOfcCd[i]);
				if (csulSlpIssDt[i] != null)
					model.setCsulSlpIssDt(csulSlpIssDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (csulSlpSerNo[i] != null)
					model.setCsulSlpSerNo(csulSlpSerNo[i]);
				if (csulSlpFuncCd[i] != null)
					model.setCsulSlpFuncCd(csulSlpFuncCd[i]);
				if (csulSlpTpCd[i] != null)
					model.setCsulSlpTpCd(csulSlpTpCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (keyFlg[i] != null)
					model.setKeyFlg(keyFlg[i]);
				if (invDtlSeq[i] != null)
					model.setInvDtlSeq(invDtlSeq[i]);
				if (csrAmt[i] != null)
					model.setCsrAmt(csrAmt[i]);
				if (popGb[i] != null)
					model.setPopGb(popGb[i]);
				if (slpSerNo[i] != null)
					model.setSlpSerNo(slpSerNo[i]);
				if (slpLocCd[i] != null)
					model.setSlpLocCd(slpLocCd[i]);
				if (autoFlg[i] != null)
					model.setAutoFlg(autoFlg[i]);
				if (orgFletCtrtNo[i] != null)
					model.setOrgFletCtrtNo(orgFletCtrtNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomPamCsulSlpVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomPamCsulSlpVO[]
	 */
	public CustomPamCsulSlpVO[] getCustomPamCsulSlpVOs(){
		CustomPamCsulSlpVO[] vos = (CustomPamCsulSlpVO[])models.toArray(new CustomPamCsulSlpVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletSrcTpCd = this.fletSrcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrAcctSlpCsrNo = this.ownrAcctSlpCsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpFuncCd = this.slpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seqNo = this.seqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrDesc = this.csrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bunkerVvd = this.bunkerVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq = this.invSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyNumber = this.keyNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletIssTpCd = this.fletIssTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo = this.fletCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrCd = this.ctrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apSlpTpCd = this.apSlpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpEffDt = this.slpEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpTpCd = this.slpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatFlg = this.vatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apSlpIssDt = this.apSlpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apSlpSerNo = this.apSlpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apSlpFuncCd = this.apSlpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csulSlpOfcCd = this.csulSlpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatApply = this.vatApply .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSeqNo = this.slpSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnkSeq = this.bnkSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpIssDt = this.slpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpOfcCd = this.slpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apSlpSeqNo = this.apSlpSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apSlpOfcCd = this.apSlpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csulSlpIssDt = this.csulSlpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csulSlpSerNo = this.csulSlpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csulSlpFuncCd = this.csulSlpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csulSlpTpCd = this.csulSlpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyFlg = this.keyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDtlSeq = this.invDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrAmt = this.csrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.popGb = this.popGb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSerNo = this.slpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpLocCd = this.slpLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoFlg = this.autoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgFletCtrtNo = this.orgFletCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
