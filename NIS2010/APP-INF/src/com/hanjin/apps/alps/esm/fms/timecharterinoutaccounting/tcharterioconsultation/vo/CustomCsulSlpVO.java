/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomCsulSlpVO.java
*@FileTitle : CustomCsulSlpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.09.22 최우석 
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
 * @author 최우석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomCsulSlpVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomCsulSlpVO> models = new ArrayList<CustomCsulSlpVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String orgSlpSeqNo = null;
	/* Column Info */
	private String fletSrcTpCd = null;
	/* Column Info */
	private String slpFuncCd = null;
	/* Column Info */
	private String stlFlg = null;
	/* Column Info */
	private String csrDesc = null;
	/* Column Info */
	private String csrCurrCd = null;
	/* Column Info */
	private String fletIssTpCd = null;
	/* Column Info */
	private String applyChk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fletCtrtNo = null;
	/* Column Info */
	private String vvdEffDt = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String orgSlpSerNo = null;
	/* Column Info */
	private String apSlpTpCd = null;
	/* Column Info */
	private String slpTpCd = null;
	/* Column Info */
	private String n1stCurrCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String orgSlpTpCd = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String apSlpSerNo = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String slpSeqNo = null;
	/* Column Info */
	private String apSlpSeqNo = null;
	/* Column Info */
	private String apSlpOfcCd = null;
	/* Column Info */
	private String lsgGrNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String orgSlipNo = null;
	/* Column Info */
	private String slpSerNo = null;
	/* Column Info */
	private String slpLocCd = null;
	/* Column Info */
	private String orgSlpFuncCd = null;
	/* Column Info */
	private String trnsCurrCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String orgIssDt = null;
	/* Column Info */
	private String invSeq = null;
	/* Column Info */
	private String rvsAcctCd = null;
	/* Column Info */
	private String revDirCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrCd = null;
	/* Column Info */
	private String n1stAmt = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String slpKeyNo = null;
	/* Column Info */
	private String orgSlpIssDt = null;
	/* Column Info */
	private String vatFlg = null;
	/* Column Info */
	private String apSlpIssDt = null;
	/* Column Info */
	private String fletPpayRltCd = null;
	/* Column Info */
	private String trnsAmt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String apSlpFuncCd = null;
	/* Column Info */
	private String vvdExpDt = null;
	/* Column Info */
	private String rvsAcctItmSeq = null;
	/* Column Info */
	private String bnkSeq = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String slpOfcCd = null;
	/* Column Info */
	private String slpIssDt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String orgSlpOfcCd = null;
	/* Column Info */
	private String invDtlSeq = null;
	/* Column Info */
	private String csrAmt = null;
	/* Column Info */
	private String toInvNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomCsulSlpVO() {}

	public CustomCsulSlpVO(String ibflag, String pagerows, String vslCd, String orgSlpSeqNo, String fletSrcTpCd, String slpFuncCd, String stlFlg, String csrDesc, String csrCurrCd, String fletIssTpCd, String applyChk, String fletCtrtNo, String vvdEffDt, String vvdCd, String orgSlpSerNo, String apSlpTpCd, String slpTpCd, String n1stCurrCd, String updUsrId, String custCntCd, String orgSlpTpCd, String apSlpSerNo, String skdVoyNo, String slpSeqNo, String apSlpSeqNo, String apSlpOfcCd, String lsgGrNo, String creUsrId, String vndrSeq, String orgSlipNo, String slpSerNo, String slpLocCd, String orgSlpFuncCd, String trnsCurrCd, String creDt, String orgIssDt, String invSeq, String rvsAcctCd, String revDirCd, String ctrCd, String n1stAmt, String acctCd, String slpKeyNo, String orgSlpIssDt, String vatFlg, String apSlpIssDt, String fletPpayRltCd, String trnsAmt, String updDt, String apSlpFuncCd, String vvdExpDt, String rvsAcctItmSeq, String custSeq, String skdDirCd, String slpIssDt, String slpOfcCd, String invDtlSeq, String orgSlpOfcCd, String csrAmt, String toInvNo, String csrNo, String bnkSeq) {
		this.vslCd = vslCd;
		this.orgSlpSeqNo = orgSlpSeqNo;
		this.fletSrcTpCd = fletSrcTpCd;
		this.slpFuncCd = slpFuncCd;
		this.stlFlg = stlFlg;
		this.csrDesc = csrDesc;
		this.csrCurrCd = csrCurrCd;
		this.fletIssTpCd = fletIssTpCd;
		this.applyChk = applyChk;
		this.pagerows = pagerows;
		this.fletCtrtNo = fletCtrtNo;
		this.vvdEffDt = vvdEffDt;
		this.vvdCd = vvdCd;
		this.orgSlpSerNo = orgSlpSerNo;
		this.apSlpTpCd = apSlpTpCd;
		this.slpTpCd = slpTpCd;
		this.n1stCurrCd = n1stCurrCd;
		this.custCntCd = custCntCd;
		this.updUsrId = updUsrId;
		this.orgSlpTpCd = orgSlpTpCd;
		this.csrNo = csrNo;
		this.apSlpSerNo = apSlpSerNo;
		this.skdVoyNo = skdVoyNo;
		this.slpSeqNo = slpSeqNo;
		this.apSlpSeqNo = apSlpSeqNo;
		this.apSlpOfcCd = apSlpOfcCd;
		this.lsgGrNo = lsgGrNo;
		this.creUsrId = creUsrId;
		this.vndrSeq = vndrSeq;
		this.orgSlipNo = orgSlipNo;
		this.slpSerNo = slpSerNo;
		this.slpLocCd = slpLocCd;
		this.orgSlpFuncCd = orgSlpFuncCd;
		this.trnsCurrCd = trnsCurrCd;
		this.creDt = creDt;
		this.orgIssDt = orgIssDt;
		this.invSeq = invSeq;
		this.rvsAcctCd = rvsAcctCd;
		this.revDirCd = revDirCd;
		this.ibflag = ibflag;
		this.ctrCd = ctrCd;
		this.n1stAmt = n1stAmt;
		this.acctCd = acctCd;
		this.slpKeyNo = slpKeyNo;
		this.orgSlpIssDt = orgSlpIssDt;
		this.vatFlg = vatFlg;
		this.apSlpIssDt = apSlpIssDt;
		this.fletPpayRltCd = fletPpayRltCd;
		this.trnsAmt = trnsAmt;
		this.updDt = updDt;
		this.apSlpFuncCd = apSlpFuncCd;
		this.vvdExpDt = vvdExpDt;
		this.rvsAcctItmSeq = rvsAcctItmSeq;
		this.bnkSeq = bnkSeq;
		this.custSeq = custSeq;
		this.slpOfcCd = slpOfcCd;
		this.slpIssDt = slpIssDt;
		this.skdDirCd = skdDirCd;
		this.orgSlpOfcCd = orgSlpOfcCd;
		this.invDtlSeq = invDtlSeq;
		this.csrAmt = csrAmt;
		this.toInvNo = toInvNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("org_slp_seq_no", getOrgSlpSeqNo());
		this.hashColumns.put("flet_src_tp_cd", getFletSrcTpCd());
		this.hashColumns.put("slp_func_cd", getSlpFuncCd());
		this.hashColumns.put("stl_flg", getStlFlg());
		this.hashColumns.put("csr_desc", getCsrDesc());
		this.hashColumns.put("csr_curr_cd", getCsrCurrCd());
		this.hashColumns.put("flet_iss_tp_cd", getFletIssTpCd());
		this.hashColumns.put("apply_chk", getApplyChk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
		this.hashColumns.put("vvd_eff_dt", getVvdEffDt());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("org_slp_ser_no", getOrgSlpSerNo());
		this.hashColumns.put("ap_slp_tp_cd", getApSlpTpCd());
		this.hashColumns.put("slp_tp_cd", getSlpTpCd());
		this.hashColumns.put("n1st_curr_cd", getN1stCurrCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("org_slp_tp_cd", getOrgSlpTpCd());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("ap_slp_ser_no", getApSlpSerNo());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("slp_seq_no", getSlpSeqNo());
		this.hashColumns.put("ap_slp_seq_no", getApSlpSeqNo());
		this.hashColumns.put("ap_slp_ofc_cd", getApSlpOfcCd());
		this.hashColumns.put("lsg_gr_no", getLsgGrNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("org_slip_no", getOrgSlipNo());
		this.hashColumns.put("slp_ser_no", getSlpSerNo());
		this.hashColumns.put("slp_loc_cd", getSlpLocCd());
		this.hashColumns.put("org_slp_func_cd", getOrgSlpFuncCd());
		this.hashColumns.put("trns_curr_cd", getTrnsCurrCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("org_iss_dt", getOrgIssDt());
		this.hashColumns.put("inv_seq", getInvSeq());
		this.hashColumns.put("rvs_acct_cd", getRvsAcctCd());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctr_cd", getCtrCd());
		this.hashColumns.put("n1st_amt", getN1stAmt());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("slp_key_no", getSlpKeyNo());
		this.hashColumns.put("org_slp_iss_dt", getOrgSlpIssDt());
		this.hashColumns.put("vat_flg", getVatFlg());
		this.hashColumns.put("ap_slp_iss_dt", getApSlpIssDt());
		this.hashColumns.put("flet_ppay_rlt_cd", getFletPpayRltCd());
		this.hashColumns.put("trns_amt", getTrnsAmt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ap_slp_func_cd", getApSlpFuncCd());
		this.hashColumns.put("vvd_exp_dt", getVvdExpDt());
		this.hashColumns.put("rvs_acct_itm_seq", getRvsAcctItmSeq());
		this.hashColumns.put("bnk_seq", getBnkSeq());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("slp_ofc_cd", getSlpOfcCd());
		this.hashColumns.put("slp_iss_dt", getSlpIssDt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("org_slp_ofc_cd", getOrgSlpOfcCd());
		this.hashColumns.put("inv_dtl_seq", getInvDtlSeq());
		this.hashColumns.put("csr_amt", getCsrAmt());
		this.hashColumns.put("to_inv_no", getToInvNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("org_slp_seq_no", "orgSlpSeqNo");
		this.hashFields.put("flet_src_tp_cd", "fletSrcTpCd");
		this.hashFields.put("slp_func_cd", "slpFuncCd");
		this.hashFields.put("stl_flg", "stlFlg");
		this.hashFields.put("csr_desc", "csrDesc");
		this.hashFields.put("csr_curr_cd", "csrCurrCd");
		this.hashFields.put("flet_iss_tp_cd", "fletIssTpCd");
		this.hashFields.put("apply_chk", "applyChk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("vvd_eff_dt", "vvdEffDt");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("org_slp_ser_no", "orgSlpSerNo");
		this.hashFields.put("ap_slp_tp_cd", "apSlpTpCd");
		this.hashFields.put("slp_tp_cd", "slpTpCd");
		this.hashFields.put("n1st_curr_cd", "n1stCurrCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("org_slp_tp_cd", "orgSlpTpCd");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("ap_slp_ser_no", "apSlpSerNo");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("slp_seq_no", "slpSeqNo");
		this.hashFields.put("ap_slp_seq_no", "apSlpSeqNo");
		this.hashFields.put("ap_slp_ofc_cd", "apSlpOfcCd");
		this.hashFields.put("lsg_gr_no", "lsgGrNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("org_slip_no", "orgSlipNo");
		this.hashFields.put("slp_ser_no", "slpSerNo");
		this.hashFields.put("slp_loc_cd", "slpLocCd");
		this.hashFields.put("org_slp_func_cd", "orgSlpFuncCd");
		this.hashFields.put("trns_curr_cd", "trnsCurrCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("org_iss_dt", "orgIssDt");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("rvs_acct_cd", "rvsAcctCd");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctr_cd", "ctrCd");
		this.hashFields.put("n1st_amt", "n1stAmt");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("slp_key_no", "slpKeyNo");
		this.hashFields.put("org_slp_iss_dt", "orgSlpIssDt");
		this.hashFields.put("vat_flg", "vatFlg");
		this.hashFields.put("ap_slp_iss_dt", "apSlpIssDt");
		this.hashFields.put("flet_ppay_rlt_cd", "fletPpayRltCd");
		this.hashFields.put("trns_amt", "trnsAmt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ap_slp_func_cd", "apSlpFuncCd");
		this.hashFields.put("vvd_exp_dt", "vvdExpDt");
		this.hashFields.put("rvs_acct_itm_seq", "rvsAcctItmSeq");
		this.hashFields.put("bnk_seq", "bnkSeq");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("slp_ofc_cd", "slpOfcCd");
		this.hashFields.put("slp_iss_dt", "slpIssDt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("org_slp_ofc_cd", "orgSlpOfcCd");
		this.hashFields.put("inv_dtl_seq", "invDtlSeq");
		this.hashFields.put("csr_amt", "csrAmt");
		this.hashFields.put("to_inv_no", "toInvNo");
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
	 * @return orgSlpSeqNo
	 */
	public String getOrgSlpSeqNo() {
		return this.orgSlpSeqNo;
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
	 * @return slpFuncCd
	 */
	public String getSlpFuncCd() {
		return this.slpFuncCd;
	}
	
	/**
	 * Column Info
	 * @return stlFlg
	 */
	public String getStlFlg() {
		return this.stlFlg;
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
	 * @return csrCurrCd
	 */
	public String getCsrCurrCd() {
		return this.csrCurrCd;
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
	 * @return applyChk
	 */
	public String getApplyChk() {
		return this.applyChk;
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
	 * @return fletCtrtNo
	 */
	public String getFletCtrtNo() {
		return this.fletCtrtNo;
	}
	
	/**
	 * Column Info
	 * @return vvdEffDt
	 */
	public String getVvdEffDt() {
		return this.vvdEffDt;
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
	 * @return orgSlpSerNo
	 */
	public String getOrgSlpSerNo() {
		return this.orgSlpSerNo;
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
	 * @return slpTpCd
	 */
	public String getSlpTpCd() {
		return this.slpTpCd;
	}
	
	/**
	 * Column Info
	 * @return n1stCurrCd
	 */
	public String getN1stCurrCd() {
		return this.n1stCurrCd;
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
	 * @return apSlpSerNo
	 */
	public String getApSlpSerNo() {
		return this.apSlpSerNo;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
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
	 * @return lsgGrNo
	 */
	public String getLsgGrNo() {
		return this.lsgGrNo;
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
	 * @return orgSlipNo
	 */
	public String getOrgSlipNo() {
		return this.orgSlipNo;
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
	 * @return orgSlpFuncCd
	 */
	public String getOrgSlpFuncCd() {
		return this.orgSlpFuncCd;
	}
	
	/**
	 * Column Info
	 * @return trnsCurrCd
	 */
	public String getTrnsCurrCd() {
		return this.trnsCurrCd;
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
	 * @return orgIssDt
	 */
	public String getOrgIssDt() {
		return this.orgIssDt;
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
	 * @return rvsAcctCd
	 */
	public String getRvsAcctCd() {
		return this.rvsAcctCd;
	}
	
	/**
	 * Column Info
	 * @return revDirCd
	 */
	public String getRevDirCd() {
		return this.revDirCd;
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
	 * @return ctrCd
	 */
	public String getCtrCd() {
		return this.ctrCd;
	}
	
	/**
	 * Column Info
	 * @return n1stAmt
	 */
	public String getN1stAmt() {
		return this.n1stAmt;
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
	 * @return slpKeyNo
	 */
	public String getSlpKeyNo() {
		return this.slpKeyNo;
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
	 * @return fletPpayRltCd
	 */
	public String getFletPpayRltCd() {
		return this.fletPpayRltCd;
	}
	
	/**
	 * Column Info
	 * @return trnsAmt
	 */
	public String getTrnsAmt() {
		return this.trnsAmt;
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
	 * @return apSlpFuncCd
	 */
	public String getApSlpFuncCd() {
		return this.apSlpFuncCd;
	}
	
	/**
	 * Column Info
	 * @return vvdExpDt
	 */
	public String getVvdExpDt() {
		return this.vvdExpDt;
	}
	
	/**
	 * Column Info
	 * @return rvsAcctItmSeq
	 */
	public String getRvsAcctItmSeq() {
		return this.rvsAcctItmSeq;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return toInvNo
	 */
	public String getToInvNo() {
		return this.toInvNo;
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
	 * @param orgSlpSeqNo
	 */
	public void setOrgSlpSeqNo(String orgSlpSeqNo) {
		this.orgSlpSeqNo = orgSlpSeqNo;
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
	 * @param slpFuncCd
	 */
	public void setSlpFuncCd(String slpFuncCd) {
		this.slpFuncCd = slpFuncCd;
	}
	
	/**
	 * Column Info
	 * @param stlFlg
	 */
	public void setStlFlg(String stlFlg) {
		this.stlFlg = stlFlg;
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
	 * @param csrCurrCd
	 */
	public void setCsrCurrCd(String csrCurrCd) {
		this.csrCurrCd = csrCurrCd;
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
	 * @param applyChk
	 */
	public void setApplyChk(String applyChk) {
		this.applyChk = applyChk;
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
	 * @param fletCtrtNo
	 */
	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
	}
	
	/**
	 * Column Info
	 * @param vvdEffDt
	 */
	public void setVvdEffDt(String vvdEffDt) {
		this.vvdEffDt = vvdEffDt;
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
	 * @param orgSlpSerNo
	 */
	public void setOrgSlpSerNo(String orgSlpSerNo) {
		this.orgSlpSerNo = orgSlpSerNo;
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
	 * @param slpTpCd
	 */
	public void setSlpTpCd(String slpTpCd) {
		this.slpTpCd = slpTpCd;
	}
	
	/**
	 * Column Info
	 * @param n1stCurrCd
	 */
	public void setN1stCurrCd(String n1stCurrCd) {
		this.n1stCurrCd = n1stCurrCd;
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
	 * @param apSlpSerNo
	 */
	public void setApSlpSerNo(String apSlpSerNo) {
		this.apSlpSerNo = apSlpSerNo;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
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
	 * @param lsgGrNo
	 */
	public void setLsgGrNo(String lsgGrNo) {
		this.lsgGrNo = lsgGrNo;
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
	 * @param orgSlipNo
	 */
	public void setOrgSlipNo(String orgSlipNo) {
		this.orgSlipNo = orgSlipNo;
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
	 * @param orgSlpFuncCd
	 */
	public void setOrgSlpFuncCd(String orgSlpFuncCd) {
		this.orgSlpFuncCd = orgSlpFuncCd;
	}
	
	/**
	 * Column Info
	 * @param trnsCurrCd
	 */
	public void setTrnsCurrCd(String trnsCurrCd) {
		this.trnsCurrCd = trnsCurrCd;
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
	 * @param orgIssDt
	 */
	public void setOrgIssDt(String orgIssDt) {
		this.orgIssDt = orgIssDt;
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
	 * @param rvsAcctCd
	 */
	public void setRvsAcctCd(String rvsAcctCd) {
		this.rvsAcctCd = rvsAcctCd;
	}
	
	/**
	 * Column Info
	 * @param revDirCd
	 */
	public void setRevDirCd(String revDirCd) {
		this.revDirCd = revDirCd;
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
	 * @param ctrCd
	 */
	public void setCtrCd(String ctrCd) {
		this.ctrCd = ctrCd;
	}
	
	/**
	 * Column Info
	 * @param n1stAmt
	 */
	public void setN1stAmt(String n1stAmt) {
		this.n1stAmt = n1stAmt;
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
	 * @param slpKeyNo
	 */
	public void setSlpKeyNo(String slpKeyNo) {
		this.slpKeyNo = slpKeyNo;
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
	 * @param fletPpayRltCd
	 */
	public void setFletPpayRltCd(String fletPpayRltCd) {
		this.fletPpayRltCd = fletPpayRltCd;
	}
	
	/**
	 * Column Info
	 * @param trnsAmt
	 */
	public void setTrnsAmt(String trnsAmt) {
		this.trnsAmt = trnsAmt;
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
	 * @param apSlpFuncCd
	 */
	public void setApSlpFuncCd(String apSlpFuncCd) {
		this.apSlpFuncCd = apSlpFuncCd;
	}
	
	/**
	 * Column Info
	 * @param vvdExpDt
	 */
	public void setVvdExpDt(String vvdExpDt) {
		this.vvdExpDt = vvdExpDt;
	}
	
	/**
	 * Column Info
	 * @param rvsAcctItmSeq
	 */
	public void setRvsAcctItmSeq(String rvsAcctItmSeq) {
		this.rvsAcctItmSeq = rvsAcctItmSeq;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param toInvNo
	 */
	public void setToInvNo(String toInvNo) {
		this.toInvNo = toInvNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setOrgSlpSeqNo(JSPUtil.getParameter(request, "org_slp_seq_no", ""));
		setFletSrcTpCd(JSPUtil.getParameter(request, "flet_src_tp_cd", ""));
		setSlpFuncCd(JSPUtil.getParameter(request, "slp_func_cd", ""));
		setStlFlg(JSPUtil.getParameter(request, "stl_flg", ""));
		setCsrDesc(JSPUtil.getParameter(request, "csr_desc", ""));
		setCsrCurrCd(JSPUtil.getParameter(request, "csr_curr_cd", ""));
		setFletIssTpCd(JSPUtil.getParameter(request, "flet_iss_tp_cd", ""));
		setApplyChk(JSPUtil.getParameter(request, "apply_chk", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFletCtrtNo(JSPUtil.getParameter(request, "flet_ctrt_no", ""));
		setVvdEffDt(JSPUtil.getParameter(request, "vvd_eff_dt", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setOrgSlpSerNo(JSPUtil.getParameter(request, "org_slp_ser_no", ""));
		setApSlpTpCd(JSPUtil.getParameter(request, "ap_slp_tp_cd", ""));
		setSlpTpCd(JSPUtil.getParameter(request, "slp_tp_cd", ""));
		setN1stCurrCd(JSPUtil.getParameter(request, "n1st_curr_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setOrgSlpTpCd(JSPUtil.getParameter(request, "org_slp_tp_cd", ""));
		setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
		setApSlpSerNo(JSPUtil.getParameter(request, "ap_slp_ser_no", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setSlpSeqNo(JSPUtil.getParameter(request, "slp_seq_no", ""));
		setApSlpSeqNo(JSPUtil.getParameter(request, "ap_slp_seq_no", ""));
		setApSlpOfcCd(JSPUtil.getParameter(request, "ap_slp_ofc_cd", ""));
		setLsgGrNo(JSPUtil.getParameter(request, "lsg_gr_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setOrgSlipNo(JSPUtil.getParameter(request, "org_slip_no", ""));
		setSlpSerNo(JSPUtil.getParameter(request, "slp_ser_no", ""));
		setSlpLocCd(JSPUtil.getParameter(request, "slp_loc_cd", ""));
		setOrgSlpFuncCd(JSPUtil.getParameter(request, "org_slp_func_cd", ""));
		setTrnsCurrCd(JSPUtil.getParameter(request, "trns_curr_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setOrgIssDt(JSPUtil.getParameter(request, "org_iss_dt", ""));
		setInvSeq(JSPUtil.getParameter(request, "inv_seq", ""));
		setRvsAcctCd(JSPUtil.getParameter(request, "rvs_acct_cd", ""));
		setRevDirCd(JSPUtil.getParameter(request, "rev_dir_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCtrCd(JSPUtil.getParameter(request, "ctr_cd", ""));
		setN1stAmt(JSPUtil.getParameter(request, "n1st_amt", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setSlpKeyNo(JSPUtil.getParameter(request, "slp_key_no", ""));
		setOrgSlpIssDt(JSPUtil.getParameter(request, "org_slp_iss_dt", ""));
		setVatFlg(JSPUtil.getParameter(request, "vat_flg", ""));
		setApSlpIssDt(JSPUtil.getParameter(request, "ap_slp_iss_dt", ""));
		setFletPpayRltCd(JSPUtil.getParameter(request, "flet_ppay_rlt_cd", ""));
		setTrnsAmt(JSPUtil.getParameter(request, "trns_amt", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setApSlpFuncCd(JSPUtil.getParameter(request, "ap_slp_func_cd", ""));
		setVvdExpDt(JSPUtil.getParameter(request, "vvd_exp_dt", ""));
		setRvsAcctItmSeq(JSPUtil.getParameter(request, "rvs_acct_itm_seq", ""));
		setBnkSeq(JSPUtil.getParameter(request, "bnk_seq", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setSlpOfcCd(JSPUtil.getParameter(request, "slp_ofc_cd", ""));
		setSlpIssDt(JSPUtil.getParameter(request, "slp_iss_dt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setOrgSlpOfcCd(JSPUtil.getParameter(request, "org_slp_ofc_cd", ""));
		setInvDtlSeq(JSPUtil.getParameter(request, "inv_dtl_seq", ""));
		setCsrAmt(JSPUtil.getParameter(request, "csr_amt", ""));
		setToInvNo(JSPUtil.getParameter(request, "to_inv_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomCsulSlpVO[]
	 */
	public CustomCsulSlpVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomCsulSlpVO[]
	 */
	public CustomCsulSlpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomCsulSlpVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] orgSlpSeqNo = (JSPUtil.getParameter(request, prefix	+ "org_slp_seq_no", length));
			String[] fletSrcTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_src_tp_cd", length));
			String[] slpFuncCd = (JSPUtil.getParameter(request, prefix	+ "slp_func_cd", length));
			String[] stlFlg = (JSPUtil.getParameter(request, prefix	+ "stl_flg", length));
			String[] csrDesc = (JSPUtil.getParameter(request, prefix	+ "csr_desc", length));
			String[] csrCurrCd = (JSPUtil.getParameter(request, prefix	+ "csr_curr_cd", length));
			String[] fletIssTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_iss_tp_cd", length));
			String[] applyChk = (JSPUtil.getParameter(request, prefix	+ "apply_chk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_no", length));
			String[] vvdEffDt = (JSPUtil.getParameter(request, prefix	+ "vvd_eff_dt", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] orgSlpSerNo = (JSPUtil.getParameter(request, prefix	+ "org_slp_ser_no", length));
			String[] apSlpTpCd = (JSPUtil.getParameter(request, prefix	+ "ap_slp_tp_cd", length));
			String[] slpTpCd = (JSPUtil.getParameter(request, prefix	+ "slp_tp_cd", length));
			String[] n1stCurrCd = (JSPUtil.getParameter(request, prefix	+ "n1st_curr_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] orgSlpTpCd = (JSPUtil.getParameter(request, prefix	+ "org_slp_tp_cd", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] apSlpSerNo = (JSPUtil.getParameter(request, prefix	+ "ap_slp_ser_no", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] slpSeqNo = (JSPUtil.getParameter(request, prefix	+ "slp_seq_no", length));
			String[] apSlpSeqNo = (JSPUtil.getParameter(request, prefix	+ "ap_slp_seq_no", length));
			String[] apSlpOfcCd = (JSPUtil.getParameter(request, prefix	+ "ap_slp_ofc_cd", length));
			String[] lsgGrNo = (JSPUtil.getParameter(request, prefix	+ "lsg_gr_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] orgSlipNo = (JSPUtil.getParameter(request, prefix	+ "org_slip_no", length));
			String[] slpSerNo = (JSPUtil.getParameter(request, prefix	+ "slp_ser_no", length));
			String[] slpLocCd = (JSPUtil.getParameter(request, prefix	+ "slp_loc_cd", length));
			String[] orgSlpFuncCd = (JSPUtil.getParameter(request, prefix	+ "org_slp_func_cd", length));
			String[] trnsCurrCd = (JSPUtil.getParameter(request, prefix	+ "trns_curr_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] orgIssDt = (JSPUtil.getParameter(request, prefix	+ "org_iss_dt", length));
			String[] invSeq = (JSPUtil.getParameter(request, prefix	+ "inv_seq", length));
			String[] rvsAcctCd = (JSPUtil.getParameter(request, prefix	+ "rvs_acct_cd", length));
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrCd = (JSPUtil.getParameter(request, prefix	+ "ctr_cd", length));
			String[] n1stAmt = (JSPUtil.getParameter(request, prefix	+ "n1st_amt", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] slpKeyNo = (JSPUtil.getParameter(request, prefix	+ "slp_key_no", length));
			String[] orgSlpIssDt = (JSPUtil.getParameter(request, prefix	+ "org_slp_iss_dt", length));
			String[] vatFlg = (JSPUtil.getParameter(request, prefix	+ "vat_flg", length));
			String[] apSlpIssDt = (JSPUtil.getParameter(request, prefix	+ "ap_slp_iss_dt", length));
			String[] fletPpayRltCd = (JSPUtil.getParameter(request, prefix	+ "flet_ppay_rlt_cd", length));
			String[] trnsAmt = (JSPUtil.getParameter(request, prefix	+ "trns_amt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] apSlpFuncCd = (JSPUtil.getParameter(request, prefix	+ "ap_slp_func_cd", length));
			String[] vvdExpDt = (JSPUtil.getParameter(request, prefix	+ "vvd_exp_dt", length));
			String[] rvsAcctItmSeq = (JSPUtil.getParameter(request, prefix	+ "rvs_acct_itm_seq", length));
			String[] bnkSeq = (JSPUtil.getParameter(request, prefix	+ "bnk_seq", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] slpOfcCd = (JSPUtil.getParameter(request, prefix	+ "slp_ofc_cd", length));
			String[] slpIssDt = (JSPUtil.getParameter(request, prefix	+ "slp_iss_dt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] orgSlpOfcCd = (JSPUtil.getParameter(request, prefix	+ "org_slp_ofc_cd", length));
			String[] invDtlSeq = (JSPUtil.getParameter(request, prefix	+ "inv_dtl_seq", length));
			String[] csrAmt = (JSPUtil.getParameter(request, prefix	+ "csr_amt", length));
			String[] toInvNo = (JSPUtil.getParameter(request, prefix	+ "to_inv_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomCsulSlpVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (orgSlpSeqNo[i] != null)
					model.setOrgSlpSeqNo(orgSlpSeqNo[i]);
				if (fletSrcTpCd[i] != null)
					model.setFletSrcTpCd(fletSrcTpCd[i]);
				if (slpFuncCd[i] != null)
					model.setSlpFuncCd(slpFuncCd[i]);
				if (stlFlg[i] != null)
					model.setStlFlg(stlFlg[i]);
				if (csrDesc[i] != null)
					model.setCsrDesc(csrDesc[i]);
				if (csrCurrCd[i] != null)
					model.setCsrCurrCd(csrCurrCd[i]);
				if (fletIssTpCd[i] != null)
					model.setFletIssTpCd(fletIssTpCd[i]);
				if (applyChk[i] != null)
					model.setApplyChk(applyChk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fletCtrtNo[i] != null)
					model.setFletCtrtNo(fletCtrtNo[i]);
				if (vvdEffDt[i] != null)
					model.setVvdEffDt(vvdEffDt[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (orgSlpSerNo[i] != null)
					model.setOrgSlpSerNo(orgSlpSerNo[i]);
				if (apSlpTpCd[i] != null)
					model.setApSlpTpCd(apSlpTpCd[i]);
				if (slpTpCd[i] != null)
					model.setSlpTpCd(slpTpCd[i]);
				if (n1stCurrCd[i] != null)
					model.setN1stCurrCd(n1stCurrCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (orgSlpTpCd[i] != null)
					model.setOrgSlpTpCd(orgSlpTpCd[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (apSlpSerNo[i] != null)
					model.setApSlpSerNo(apSlpSerNo[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (slpSeqNo[i] != null)
					model.setSlpSeqNo(slpSeqNo[i]);
				if (apSlpSeqNo[i] != null)
					model.setApSlpSeqNo(apSlpSeqNo[i]);
				if (apSlpOfcCd[i] != null)
					model.setApSlpOfcCd(apSlpOfcCd[i]);
				if (lsgGrNo[i] != null)
					model.setLsgGrNo(lsgGrNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (orgSlipNo[i] != null)
					model.setOrgSlipNo(orgSlipNo[i]);
				if (slpSerNo[i] != null)
					model.setSlpSerNo(slpSerNo[i]);
				if (slpLocCd[i] != null)
					model.setSlpLocCd(slpLocCd[i]);
				if (orgSlpFuncCd[i] != null)
					model.setOrgSlpFuncCd(orgSlpFuncCd[i]);
				if (trnsCurrCd[i] != null)
					model.setTrnsCurrCd(trnsCurrCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (orgIssDt[i] != null)
					model.setOrgIssDt(orgIssDt[i]);
				if (invSeq[i] != null)
					model.setInvSeq(invSeq[i]);
				if (rvsAcctCd[i] != null)
					model.setRvsAcctCd(rvsAcctCd[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrCd[i] != null)
					model.setCtrCd(ctrCd[i]);
				if (n1stAmt[i] != null)
					model.setN1stAmt(n1stAmt[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (slpKeyNo[i] != null)
					model.setSlpKeyNo(slpKeyNo[i]);
				if (orgSlpIssDt[i] != null)
					model.setOrgSlpIssDt(orgSlpIssDt[i]);
				if (vatFlg[i] != null)
					model.setVatFlg(vatFlg[i]);
				if (apSlpIssDt[i] != null)
					model.setApSlpIssDt(apSlpIssDt[i]);
				if (fletPpayRltCd[i] != null)
					model.setFletPpayRltCd(fletPpayRltCd[i]);
				if (trnsAmt[i] != null)
					model.setTrnsAmt(trnsAmt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (apSlpFuncCd[i] != null)
					model.setApSlpFuncCd(apSlpFuncCd[i]);
				if (vvdExpDt[i] != null)
					model.setVvdExpDt(vvdExpDt[i]);
				if (rvsAcctItmSeq[i] != null)
					model.setRvsAcctItmSeq(rvsAcctItmSeq[i]);
				if (bnkSeq[i] != null)
					model.setBnkSeq(bnkSeq[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (slpOfcCd[i] != null)
					model.setSlpOfcCd(slpOfcCd[i]);
				if (slpIssDt[i] != null)
					model.setSlpIssDt(slpIssDt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (orgSlpOfcCd[i] != null)
					model.setOrgSlpOfcCd(orgSlpOfcCd[i]);
				if (invDtlSeq[i] != null)
					model.setInvDtlSeq(invDtlSeq[i]);
				if (csrAmt[i] != null)
					model.setCsrAmt(csrAmt[i]);
				if (toInvNo[i] != null)
					model.setToInvNo(toInvNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomCsulSlpVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomCsulSlpVO[]
	 */
	public CustomCsulSlpVO[] getCustomCsulSlpVOs(){
		CustomCsulSlpVO[] vos = (CustomCsulSlpVO[])models.toArray(new CustomCsulSlpVO[models.size()]);
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
		this.orgSlpSeqNo = this.orgSlpSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletSrcTpCd = this.fletSrcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpFuncCd = this.slpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlFlg = this.stlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrDesc = this.csrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrCurrCd = this.csrCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletIssTpCd = this.fletIssTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.applyChk = this.applyChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo = this.fletCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdEffDt = this.vvdEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpSerNo = this.orgSlpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apSlpTpCd = this.apSlpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpTpCd = this.slpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCurrCd = this.n1stCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpTpCd = this.orgSlpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apSlpSerNo = this.apSlpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSeqNo = this.slpSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apSlpSeqNo = this.apSlpSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apSlpOfcCd = this.apSlpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsgGrNo = this.lsgGrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlipNo = this.orgSlipNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSerNo = this.slpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpLocCd = this.slpLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpFuncCd = this.orgSlpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsCurrCd = this.trnsCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgIssDt = this.orgIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq = this.invSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvsAcctCd = this.rvsAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrCd = this.ctrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stAmt = this.n1stAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpKeyNo = this.slpKeyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpIssDt = this.orgSlpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatFlg = this.vatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apSlpIssDt = this.apSlpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletPpayRltCd = this.fletPpayRltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsAmt = this.trnsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apSlpFuncCd = this.apSlpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdExpDt = this.vvdExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvsAcctItmSeq = this.rvsAcctItmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnkSeq = this.bnkSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpOfcCd = this.slpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpIssDt = this.slpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpOfcCd = this.orgSlpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDtlSeq = this.invDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrAmt = this.csrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toInvNo = this.toInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
