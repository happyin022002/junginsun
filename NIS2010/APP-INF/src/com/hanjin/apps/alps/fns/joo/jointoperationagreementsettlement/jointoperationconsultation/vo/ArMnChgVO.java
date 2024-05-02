/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ArMnChgVO.java
*@FileTitle : ArMnChgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.06
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.11.06 박희동 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo;

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
 * @author 박희동
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ArMnChgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ArMnChgVO> models = new ArrayList<ArMnChgVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String repChgCd = null;
	/* Column Info */
	private String glDt = null;
	/* Column Info */
	private String joBlNo = null;
	/* Column Info */
	private String invCoaRevDirCd = null;
	/* Column Info */
	private String taxXchRt = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String invCtrtNo = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Column Info */
	private String invCoaCoCd = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String invCoaAcctCd = null;
	/* Column Info */
	private String invCustCntCd = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String slsOfcCd = null;
	/* Column Info */
	private String revCoaCoCd = null;
	/* Column Info */
	private String invCoaRgnCd = null;
	/* Column Info */
	private String invCoaVoyNo = null;
	/* Column Info */
	private String znIocCd = null;
	/* Column Info */
	private String revCoaVslCd = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String revSkdVoyNo = null;
	/* Column Info */
	private String chgFullNm = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String arLocCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String invCoaCtrCd = null;
	/* Column Info */
	private String revCoaSkdDirCd = null;
	/* Column Info */
	private String revCoaRgnCd = null;
	/* Column Info */
	private String sailDt = null;
	/* Column Info */
	private String revVslCd = null;
	/* Column Info */
	private String custCrFlg = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String trnkVslCd = null;
	/* Column Info */
	private String revCoaInterCoCd = null;
	/* Column Info */
	private String trnkSkdVoyNo = null;
	/* Column Info */
	private String arIfSerNo = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String xchRtTpCd = null;
	/* Column Info */
	private String revCoaDirCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String arTaxIndCd = null;
	/* Column Info */
	private String trfRtAmt = null;
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String logUpdDt = null;
	/* Column Info */
	private String revCoaAcctCd = null;
	/* Column Info */
	private String issDt = null;
	/* Column Info */
	private String revDirCd = null;
	/* Column Info */
	private String trnkSkdDirCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String taxAmt = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String arIfNo = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String revCoaCtrCd = null;
	/* Column Info */
	private String joRevTpCd = null;
	/* Column Info */
	private String actCustCntCd = null;
	/* Column Info */
	private String erpIfFlg = null;
	/* Column Info */
	private String dueDt = null;
	/* Column Info */
	private String invCoaInterCoCd = null;
	/* Column Info */
	private String sobId = null;
	/* Column Info */
	private String invCoaVslCd = null;
	/* Column Info */
	private String crTermDys = null;
	/* Column Info */
	private String revSkdDirCd = null;
	/* Column Info */
	private String invCustSeq = null;
	/* Column Info */
	private String arSrcCd = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String invCoaSkdDirCd = null;
	/* Column Info */
	private String loclAmt = null;
	/* Column Info */
	private String slpNo = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String erpIfDt = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String revCoaVoyNo = null;
	/* Column Info */
	private String usdAmt = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String invRmk = null;
	/* Column Info */
	private String csrOffstNo = null;
	/* Column Info */
	private String ratAsCntrQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ArMnChgVO() {}

	public ArMnChgVO(String ibflag, String pagerows, String arIfNo, String arIfSerNo, String joBlNo, String arSrcCd, String invNo, String rhqCd, String arOfcCd, String actCustCntCd, String actCustSeq, String invCustCntCd, String invCustSeq, String vslCd, String skdVoyNo, String skdDirCd, String trnkVslCd, String trnkSkdVoyNo, String trnkSkdDirCd, String revVslCd, String revSkdVoyNo, String revSkdDirCd, String revDirCd, String sailArrDt, String porCd, String polCd, String podCd, String delCd, String slanCd, String ioBndCd, String custCrFlg, String dueDt, String usdAmt, String loclAmt, String znIocCd, String erpIfFlg, String erpIfDt, String invCoaCoCd, String invCoaRgnCd, String invCoaCtrCd, String invCoaAcctCd, String invCoaInterCoCd, String invCoaVslCd, String invCoaVoyNo, String invCoaSkdDirCd, String invCoaRevDirCd, String rlaneCd, String invCtrtNo, String crTermDys, String sailDt, String glDt, String xchRtTpCd, String csrOffstNo, String taxXchRt, String arTaxIndCd, String arLocCd, String slsOfcCd, String invRmk, String currCd, String usrId, String logUpdDt, String issDt, String slpNo, String chgSeq, String chgCd, String repChgCd, String joRevTpCd, String chgAmt, String taxAmt, String revCoaCoCd, String revCoaRgnCd, String revCoaCtrCd, String revCoaAcctCd, String revCoaInterCoCd, String revCoaVslCd, String revCoaVoyNo, String revCoaSkdDirCd, String revCoaDirCd, String trfRtAmt, String ratAsCntrQty, String sobId, String chgFullNm, String acctCd) {
		this.vslCd = vslCd;
		this.repChgCd = repChgCd;
		this.glDt = glDt;
		this.joBlNo = joBlNo;
		this.invCoaRevDirCd = invCoaRevDirCd;
		this.taxXchRt = taxXchRt;
		this.rlaneCd = rlaneCd;
		this.invCtrtNo = invCtrtNo;
		this.sailArrDt = sailArrDt;
		this.invCoaCoCd = invCoaCoCd;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.invCoaAcctCd = invCoaAcctCd;
		this.invCustCntCd = invCustCntCd;
		this.chgAmt = chgAmt;
		this.slsOfcCd = slsOfcCd;
		this.revCoaCoCd = revCoaCoCd;
		this.invCoaRgnCd = invCoaRgnCd;
		this.invCoaVoyNo = invCoaVoyNo;
		this.znIocCd = znIocCd;
		this.revCoaVslCd = revCoaVslCd;
		this.rhqCd = rhqCd;
		this.revSkdVoyNo = revSkdVoyNo;
		this.chgFullNm = chgFullNm;
		this.delCd = delCd;
		this.arLocCd = arLocCd;
		this.skdVoyNo = skdVoyNo;
		this.invCoaCtrCd = invCoaCtrCd;
		this.revCoaSkdDirCd = revCoaSkdDirCd;
		this.revCoaRgnCd = revCoaRgnCd;
		this.sailDt = sailDt;
		this.revVslCd = revVslCd;
		this.custCrFlg = custCrFlg;
		this.podCd = podCd;
		this.trnkVslCd = trnkVslCd;
		this.revCoaInterCoCd = revCoaInterCoCd;
		this.trnkSkdVoyNo = trnkSkdVoyNo;
		this.arIfSerNo = arIfSerNo;
		this.porCd = porCd;
		this.xchRtTpCd = xchRtTpCd;
		this.revCoaDirCd = revCoaDirCd;
		this.currCd = currCd;
		this.arTaxIndCd = arTaxIndCd;
		this.trfRtAmt = trfRtAmt;
		this.chgSeq = chgSeq;
		this.logUpdDt = logUpdDt;
		this.revCoaAcctCd = revCoaAcctCd;
		this.issDt = issDt;
		this.revDirCd = revDirCd;
		this.trnkSkdDirCd = trnkSkdDirCd;
		this.ibflag = ibflag;
		this.taxAmt = taxAmt;
		this.usrId = usrId;
		this.arIfNo = arIfNo;
		this.acctCd = acctCd;
		this.revCoaCtrCd = revCoaCtrCd;
		this.joRevTpCd = joRevTpCd;
		this.actCustCntCd = actCustCntCd;
		this.erpIfFlg = erpIfFlg;
		this.dueDt = dueDt;
		this.invCoaInterCoCd = invCoaInterCoCd;
		this.sobId = sobId;
		this.invCoaVslCd = invCoaVslCd;
		this.crTermDys = crTermDys;
		this.revSkdDirCd = revSkdDirCd;
		this.invCustSeq = invCustSeq;
		this.arSrcCd = arSrcCd;
		this.actCustSeq = actCustSeq;
		this.invCoaSkdDirCd = invCoaSkdDirCd;
		this.loclAmt = loclAmt;
		this.slpNo = slpNo;
		this.ioBndCd = ioBndCd;
		this.skdDirCd = skdDirCd;
		this.arOfcCd = arOfcCd;
		this.erpIfDt = erpIfDt;
		this.invNo = invNo;
		this.revCoaVoyNo = revCoaVoyNo;
		this.usdAmt = usdAmt;
		this.slanCd = slanCd;
		this.invRmk = invRmk;
		this.csrOffstNo = csrOffstNo;
		this.ratAsCntrQty = ratAsCntrQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("rep_chg_cd", getRepChgCd());
		this.hashColumns.put("gl_dt", getGlDt());
		this.hashColumns.put("jo_bl_no", getJoBlNo());
		this.hashColumns.put("inv_coa_rev_dir_cd", getInvCoaRevDirCd());
		this.hashColumns.put("tax_xch_rt", getTaxXchRt());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("inv_ctrt_no", getInvCtrtNo());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("inv_coa_co_cd", getInvCoaCoCd());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("inv_coa_acct_cd", getInvCoaAcctCd());
		this.hashColumns.put("inv_cust_cnt_cd", getInvCustCntCd());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
		this.hashColumns.put("rev_coa_co_cd", getRevCoaCoCd());
		this.hashColumns.put("inv_coa_rgn_cd", getInvCoaRgnCd());
		this.hashColumns.put("inv_coa_voy_no", getInvCoaVoyNo());
		this.hashColumns.put("zn_ioc_cd", getZnIocCd());
		this.hashColumns.put("rev_coa_vsl_cd", getRevCoaVslCd());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("rev_skd_voy_no", getRevSkdVoyNo());
		this.hashColumns.put("chg_full_nm", getChgFullNm());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("ar_loc_cd", getArLocCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("inv_coa_ctr_cd", getInvCoaCtrCd());
		this.hashColumns.put("rev_coa_skd_dir_cd", getRevCoaSkdDirCd());
		this.hashColumns.put("rev_coa_rgn_cd", getRevCoaRgnCd());
		this.hashColumns.put("sail_dt", getSailDt());
		this.hashColumns.put("rev_vsl_cd", getRevVslCd());
		this.hashColumns.put("cust_cr_flg", getCustCrFlg());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("trnk_vsl_cd", getTrnkVslCd());
		this.hashColumns.put("rev_coa_inter_co_cd", getRevCoaInterCoCd());
		this.hashColumns.put("trnk_skd_voy_no", getTrnkSkdVoyNo());
		this.hashColumns.put("ar_if_ser_no", getArIfSerNo());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("xch_rt_tp_cd", getXchRtTpCd());
		this.hashColumns.put("rev_coa_dir_cd", getRevCoaDirCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("ar_tax_ind_cd", getArTaxIndCd());
		this.hashColumns.put("trf_rt_amt", getTrfRtAmt());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("log_upd_dt", getLogUpdDt());
		this.hashColumns.put("rev_coa_acct_cd", getRevCoaAcctCd());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("trnk_skd_dir_cd", getTrnkSkdDirCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tax_amt", getTaxAmt());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("ar_if_no", getArIfNo());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("rev_coa_ctr_cd", getRevCoaCtrCd());
		this.hashColumns.put("jo_rev_tp_cd", getJoRevTpCd());
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());
		this.hashColumns.put("erp_if_flg", getErpIfFlg());
		this.hashColumns.put("due_dt", getDueDt());
		this.hashColumns.put("inv_coa_inter_co_cd", getInvCoaInterCoCd());
		this.hashColumns.put("sob_id", getSobId());
		this.hashColumns.put("inv_coa_vsl_cd", getInvCoaVslCd());
		this.hashColumns.put("cr_term_dys", getCrTermDys());
		this.hashColumns.put("rev_skd_dir_cd", getRevSkdDirCd());
		this.hashColumns.put("inv_cust_seq", getInvCustSeq());
		this.hashColumns.put("ar_src_cd", getArSrcCd());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("inv_coa_skd_dir_cd", getInvCoaSkdDirCd());
		this.hashColumns.put("locl_amt", getLoclAmt());
		this.hashColumns.put("slp_no", getSlpNo());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("erp_if_dt", getErpIfDt());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("rev_coa_voy_no", getRevCoaVoyNo());
		this.hashColumns.put("usd_amt", getUsdAmt());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("inv_rmk", getInvRmk());
		this.hashColumns.put("csr_offst_no", getCsrOffstNo());
		this.hashColumns.put("rat_as_cntr_qty", getRatAsCntrQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("rep_chg_cd", "repChgCd");
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("jo_bl_no", "joBlNo");
		this.hashFields.put("inv_coa_rev_dir_cd", "invCoaRevDirCd");
		this.hashFields.put("tax_xch_rt", "taxXchRt");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("inv_ctrt_no", "invCtrtNo");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("inv_coa_co_cd", "invCoaCoCd");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("inv_coa_acct_cd", "invCoaAcctCd");
		this.hashFields.put("inv_cust_cnt_cd", "invCustCntCd");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("sls_ofc_cd", "slsOfcCd");
		this.hashFields.put("rev_coa_co_cd", "revCoaCoCd");
		this.hashFields.put("inv_coa_rgn_cd", "invCoaRgnCd");
		this.hashFields.put("inv_coa_voy_no", "invCoaVoyNo");
		this.hashFields.put("zn_ioc_cd", "znIocCd");
		this.hashFields.put("rev_coa_vsl_cd", "revCoaVslCd");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("rev_skd_voy_no", "revSkdVoyNo");
		this.hashFields.put("chg_full_nm", "chgFullNm");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("ar_loc_cd", "arLocCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("inv_coa_ctr_cd", "invCoaCtrCd");
		this.hashFields.put("rev_coa_skd_dir_cd", "revCoaSkdDirCd");
		this.hashFields.put("rev_coa_rgn_cd", "revCoaRgnCd");
		this.hashFields.put("sail_dt", "sailDt");
		this.hashFields.put("rev_vsl_cd", "revVslCd");
		this.hashFields.put("cust_cr_flg", "custCrFlg");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("trnk_vsl_cd", "trnkVslCd");
		this.hashFields.put("rev_coa_inter_co_cd", "revCoaInterCoCd");
		this.hashFields.put("trnk_skd_voy_no", "trnkSkdVoyNo");
		this.hashFields.put("ar_if_ser_no", "arIfSerNo");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("xch_rt_tp_cd", "xchRtTpCd");
		this.hashFields.put("rev_coa_dir_cd", "revCoaDirCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("ar_tax_ind_cd", "arTaxIndCd");
		this.hashFields.put("trf_rt_amt", "trfRtAmt");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("log_upd_dt", "logUpdDt");
		this.hashFields.put("rev_coa_acct_cd", "revCoaAcctCd");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("trnk_skd_dir_cd", "trnkSkdDirCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tax_amt", "taxAmt");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("rev_coa_ctr_cd", "revCoaCtrCd");
		this.hashFields.put("jo_rev_tp_cd", "joRevTpCd");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("erp_if_flg", "erpIfFlg");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("inv_coa_inter_co_cd", "invCoaInterCoCd");
		this.hashFields.put("sob_id", "sobId");
		this.hashFields.put("inv_coa_vsl_cd", "invCoaVslCd");
		this.hashFields.put("cr_term_dys", "crTermDys");
		this.hashFields.put("rev_skd_dir_cd", "revSkdDirCd");
		this.hashFields.put("inv_cust_seq", "invCustSeq");
		this.hashFields.put("ar_src_cd", "arSrcCd");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("inv_coa_skd_dir_cd", "invCoaSkdDirCd");
		this.hashFields.put("locl_amt", "loclAmt");
		this.hashFields.put("slp_no", "slpNo");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("erp_if_dt", "erpIfDt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("rev_coa_voy_no", "revCoaVoyNo");
		this.hashFields.put("usd_amt", "usdAmt");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("inv_rmk", "invRmk");
		this.hashFields.put("csr_offst_no", "csrOffstNo");
		this.hashFields.put("rat_as_cntr_qty", "ratAsCntrQty");
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
	 * @return repChgCd
	 */
	public String getRepChgCd() {
		return this.repChgCd;
	}
	
	/**
	 * Column Info
	 * @return glDt
	 */
	public String getGlDt() {
		return this.glDt;
	}
	
	/**
	 * Column Info
	 * @return joBlNo
	 */
	public String getJoBlNo() {
		return this.joBlNo;
	}
	
	/**
	 * Column Info
	 * @return invCoaRevDirCd
	 */
	public String getInvCoaRevDirCd() {
		return this.invCoaRevDirCd;
	}
	
	/**
	 * Column Info
	 * @return taxXchRt
	 */
	public String getTaxXchRt() {
		return this.taxXchRt;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return invCtrtNo
	 */
	public String getInvCtrtNo() {
		return this.invCtrtNo;
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
	 * @return invCoaCoCd
	 */
	public String getInvCoaCoCd() {
		return this.invCoaCoCd;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return invCoaAcctCd
	 */
	public String getInvCoaAcctCd() {
		return this.invCoaAcctCd;
	}
	
	/**
	 * Column Info
	 * @return invCustCntCd
	 */
	public String getInvCustCntCd() {
		return this.invCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return chgAmt
	 */
	public String getChgAmt() {
		return this.chgAmt;
	}
	
	/**
	 * Column Info
	 * @return slsOfcCd
	 */
	public String getSlsOfcCd() {
		return this.slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return revCoaCoCd
	 */
	public String getRevCoaCoCd() {
		return this.revCoaCoCd;
	}
	
	/**
	 * Column Info
	 * @return invCoaRgnCd
	 */
	public String getInvCoaRgnCd() {
		return this.invCoaRgnCd;
	}
	
	/**
	 * Column Info
	 * @return invCoaVoyNo
	 */
	public String getInvCoaVoyNo() {
		return this.invCoaVoyNo;
	}
	
	/**
	 * Column Info
	 * @return znIocCd
	 */
	public String getZnIocCd() {
		return this.znIocCd;
	}
	
	/**
	 * Column Info
	 * @return revCoaVslCd
	 */
	public String getRevCoaVslCd() {
		return this.revCoaVslCd;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return revSkdVoyNo
	 */
	public String getRevSkdVoyNo() {
		return this.revSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return chgFullNm
	 */
	public String getChgFullNm() {
		return this.chgFullNm;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return arLocCd
	 */
	public String getArLocCd() {
		return this.arLocCd;
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
	 * @return invCoaCtrCd
	 */
	public String getInvCoaCtrCd() {
		return this.invCoaCtrCd;
	}
	
	/**
	 * Column Info
	 * @return revCoaSkdDirCd
	 */
	public String getRevCoaSkdDirCd() {
		return this.revCoaSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return revCoaRgnCd
	 */
	public String getRevCoaRgnCd() {
		return this.revCoaRgnCd;
	}
	
	/**
	 * Column Info
	 * @return sailDt
	 */
	public String getSailDt() {
		return this.sailDt;
	}
	
	/**
	 * Column Info
	 * @return revVslCd
	 */
	public String getRevVslCd() {
		return this.revVslCd;
	}
	
	/**
	 * Column Info
	 * @return custCrFlg
	 */
	public String getCustCrFlg() {
		return this.custCrFlg;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return trnkVslCd
	 */
	public String getTrnkVslCd() {
		return this.trnkVslCd;
	}
	
	/**
	 * Column Info
	 * @return revCoaInterCoCd
	 */
	public String getRevCoaInterCoCd() {
		return this.revCoaInterCoCd;
	}
	
	/**
	 * Column Info
	 * @return trnkSkdVoyNo
	 */
	public String getTrnkSkdVoyNo() {
		return this.trnkSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return arIfSerNo
	 */
	public String getArIfSerNo() {
		return this.arIfSerNo;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return xchRtTpCd
	 */
	public String getXchRtTpCd() {
		return this.xchRtTpCd;
	}
	
	/**
	 * Column Info
	 * @return revCoaDirCd
	 */
	public String getRevCoaDirCd() {
		return this.revCoaDirCd;
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
	 * @return arTaxIndCd
	 */
	public String getArTaxIndCd() {
		return this.arTaxIndCd;
	}
	
	/**
	 * Column Info
	 * @return trfRtAmt
	 */
	public String getTrfRtAmt() {
		return this.trfRtAmt;
	}
	
	/**
	 * Column Info
	 * @return chgSeq
	 */
	public String getChgSeq() {
		return this.chgSeq;
	}
	
	/**
	 * Column Info
	 * @return logUpdDt
	 */
	public String getLogUpdDt() {
		return this.logUpdDt;
	}
	
	/**
	 * Column Info
	 * @return revCoaAcctCd
	 */
	public String getRevCoaAcctCd() {
		return this.revCoaAcctCd;
	}
	
	/**
	 * Column Info
	 * @return issDt
	 */
	public String getIssDt() {
		return this.issDt;
	}
	
	/**
	 * Column Info
	 * @return revDirCd
	 */
	public String getRevDirCd() {
		return this.revDirCd;
	}
	
	/**
	 * Column Info
	 * @return trnkSkdDirCd
	 */
	public String getTrnkSkdDirCd() {
		return this.trnkSkdDirCd;
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
	 * @return taxAmt
	 */
	public String getTaxAmt() {
		return this.taxAmt;
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
	 * @return arIfNo
	 */
	public String getArIfNo() {
		return this.arIfNo;
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
	 * @return revCoaCtrCd
	 */
	public String getRevCoaCtrCd() {
		return this.revCoaCtrCd;
	}
	
	/**
	 * Column Info
	 * @return joRevTpCd
	 */
	public String getJoRevTpCd() {
		return this.joRevTpCd;
	}
	
	/**
	 * Column Info
	 * @return actCustCntCd
	 */
	public String getActCustCntCd() {
		return this.actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return erpIfFlg
	 */
	public String getErpIfFlg() {
		return this.erpIfFlg;
	}
	
	/**
	 * Column Info
	 * @return dueDt
	 */
	public String getDueDt() {
		return this.dueDt;
	}
	
	/**
	 * Column Info
	 * @return invCoaInterCoCd
	 */
	public String getInvCoaInterCoCd() {
		return this.invCoaInterCoCd;
	}
	
	/**
	 * Column Info
	 * @return sobId
	 */
	public String getSobId() {
		return this.sobId;
	}
	
	/**
	 * Column Info
	 * @return invCoaVslCd
	 */
	public String getInvCoaVslCd() {
		return this.invCoaVslCd;
	}
	
	/**
	 * Column Info
	 * @return crTermDys
	 */
	public String getCrTermDys() {
		return this.crTermDys;
	}
	
	/**
	 * Column Info
	 * @return revSkdDirCd
	 */
	public String getRevSkdDirCd() {
		return this.revSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return invCustSeq
	 */
	public String getInvCustSeq() {
		return this.invCustSeq;
	}
	
	/**
	 * Column Info
	 * @return arSrcCd
	 */
	public String getArSrcCd() {
		return this.arSrcCd;
	}
	
	/**
	 * Column Info
	 * @return actCustSeq
	 */
	public String getActCustSeq() {
		return this.actCustSeq;
	}
	
	/**
	 * Column Info
	 * @return invCoaSkdDirCd
	 */
	public String getInvCoaSkdDirCd() {
		return this.invCoaSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return loclAmt
	 */
	public String getLoclAmt() {
		return this.loclAmt;
	}
	
	/**
	 * Column Info
	 * @return slpNo
	 */
	public String getSlpNo() {
		return this.slpNo;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return erpIfDt
	 */
	public String getErpIfDt() {
		return this.erpIfDt;
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
	 * @return revCoaVoyNo
	 */
	public String getRevCoaVoyNo() {
		return this.revCoaVoyNo;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return invRmk
	 */
	public String getInvRmk() {
		return this.invRmk;
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
	 * @return ratAsCntrQty
	 */
	public String getRatAsCntrQty() {
		return this.ratAsCntrQty;
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
	 * @param repChgCd
	 */
	public void setRepChgCd(String repChgCd) {
		this.repChgCd = repChgCd;
	}
	
	/**
	 * Column Info
	 * @param glDt
	 */
	public void setGlDt(String glDt) {
		this.glDt = glDt;
	}
	
	/**
	 * Column Info
	 * @param joBlNo
	 */
	public void setJoBlNo(String joBlNo) {
		this.joBlNo = joBlNo;
	}
	
	/**
	 * Column Info
	 * @param invCoaRevDirCd
	 */
	public void setInvCoaRevDirCd(String invCoaRevDirCd) {
		this.invCoaRevDirCd = invCoaRevDirCd;
	}
	
	/**
	 * Column Info
	 * @param taxXchRt
	 */
	public void setTaxXchRt(String taxXchRt) {
		this.taxXchRt = taxXchRt;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param invCtrtNo
	 */
	public void setInvCtrtNo(String invCtrtNo) {
		this.invCtrtNo = invCtrtNo;
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
	 * @param invCoaCoCd
	 */
	public void setInvCoaCoCd(String invCoaCoCd) {
		this.invCoaCoCd = invCoaCoCd;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param invCoaAcctCd
	 */
	public void setInvCoaAcctCd(String invCoaAcctCd) {
		this.invCoaAcctCd = invCoaAcctCd;
	}
	
	/**
	 * Column Info
	 * @param invCustCntCd
	 */
	public void setInvCustCntCd(String invCustCntCd) {
		this.invCustCntCd = invCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param chgAmt
	 */
	public void setChgAmt(String chgAmt) {
		this.chgAmt = chgAmt;
	}
	
	/**
	 * Column Info
	 * @param slsOfcCd
	 */
	public void setSlsOfcCd(String slsOfcCd) {
		this.slsOfcCd = slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param revCoaCoCd
	 */
	public void setRevCoaCoCd(String revCoaCoCd) {
		this.revCoaCoCd = revCoaCoCd;
	}
	
	/**
	 * Column Info
	 * @param invCoaRgnCd
	 */
	public void setInvCoaRgnCd(String invCoaRgnCd) {
		this.invCoaRgnCd = invCoaRgnCd;
	}
	
	/**
	 * Column Info
	 * @param invCoaVoyNo
	 */
	public void setInvCoaVoyNo(String invCoaVoyNo) {
		this.invCoaVoyNo = invCoaVoyNo;
	}
	
	/**
	 * Column Info
	 * @param znIocCd
	 */
	public void setZnIocCd(String znIocCd) {
		this.znIocCd = znIocCd;
	}
	
	/**
	 * Column Info
	 * @param revCoaVslCd
	 */
	public void setRevCoaVslCd(String revCoaVslCd) {
		this.revCoaVslCd = revCoaVslCd;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param revSkdVoyNo
	 */
	public void setRevSkdVoyNo(String revSkdVoyNo) {
		this.revSkdVoyNo = revSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param chgFullNm
	 */
	public void setChgFullNm(String chgFullNm) {
		this.chgFullNm = chgFullNm;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param arLocCd
	 */
	public void setArLocCd(String arLocCd) {
		this.arLocCd = arLocCd;
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
	 * @param invCoaCtrCd
	 */
	public void setInvCoaCtrCd(String invCoaCtrCd) {
		this.invCoaCtrCd = invCoaCtrCd;
	}
	
	/**
	 * Column Info
	 * @param revCoaSkdDirCd
	 */
	public void setRevCoaSkdDirCd(String revCoaSkdDirCd) {
		this.revCoaSkdDirCd = revCoaSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param revCoaRgnCd
	 */
	public void setRevCoaRgnCd(String revCoaRgnCd) {
		this.revCoaRgnCd = revCoaRgnCd;
	}
	
	/**
	 * Column Info
	 * @param sailDt
	 */
	public void setSailDt(String sailDt) {
		this.sailDt = sailDt;
	}
	
	/**
	 * Column Info
	 * @param revVslCd
	 */
	public void setRevVslCd(String revVslCd) {
		this.revVslCd = revVslCd;
	}
	
	/**
	 * Column Info
	 * @param custCrFlg
	 */
	public void setCustCrFlg(String custCrFlg) {
		this.custCrFlg = custCrFlg;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param trnkVslCd
	 */
	public void setTrnkVslCd(String trnkVslCd) {
		this.trnkVslCd = trnkVslCd;
	}
	
	/**
	 * Column Info
	 * @param revCoaInterCoCd
	 */
	public void setRevCoaInterCoCd(String revCoaInterCoCd) {
		this.revCoaInterCoCd = revCoaInterCoCd;
	}
	
	/**
	 * Column Info
	 * @param trnkSkdVoyNo
	 */
	public void setTrnkSkdVoyNo(String trnkSkdVoyNo) {
		this.trnkSkdVoyNo = trnkSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param arIfSerNo
	 */
	public void setArIfSerNo(String arIfSerNo) {
		this.arIfSerNo = arIfSerNo;
	}
	
	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param xchRtTpCd
	 */
	public void setXchRtTpCd(String xchRtTpCd) {
		this.xchRtTpCd = xchRtTpCd;
	}
	
	/**
	 * Column Info
	 * @param revCoaDirCd
	 */
	public void setRevCoaDirCd(String revCoaDirCd) {
		this.revCoaDirCd = revCoaDirCd;
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
	 * @param arTaxIndCd
	 */
	public void setArTaxIndCd(String arTaxIndCd) {
		this.arTaxIndCd = arTaxIndCd;
	}
	
	/**
	 * Column Info
	 * @param trfRtAmt
	 */
	public void setTrfRtAmt(String trfRtAmt) {
		this.trfRtAmt = trfRtAmt;
	}
	
	/**
	 * Column Info
	 * @param chgSeq
	 */
	public void setChgSeq(String chgSeq) {
		this.chgSeq = chgSeq;
	}
	
	/**
	 * Column Info
	 * @param logUpdDt
	 */
	public void setLogUpdDt(String logUpdDt) {
		this.logUpdDt = logUpdDt;
	}
	
	/**
	 * Column Info
	 * @param revCoaAcctCd
	 */
	public void setRevCoaAcctCd(String revCoaAcctCd) {
		this.revCoaAcctCd = revCoaAcctCd;
	}
	
	/**
	 * Column Info
	 * @param issDt
	 */
	public void setIssDt(String issDt) {
		this.issDt = issDt;
	}
	
	/**
	 * Column Info
	 * @param revDirCd
	 */
	public void setRevDirCd(String revDirCd) {
		this.revDirCd = revDirCd;
	}
	
	/**
	 * Column Info
	 * @param trnkSkdDirCd
	 */
	public void setTrnkSkdDirCd(String trnkSkdDirCd) {
		this.trnkSkdDirCd = trnkSkdDirCd;
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
	 * @param taxAmt
	 */
	public void setTaxAmt(String taxAmt) {
		this.taxAmt = taxAmt;
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
	 * @param arIfNo
	 */
	public void setArIfNo(String arIfNo) {
		this.arIfNo = arIfNo;
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
	 * @param revCoaCtrCd
	 */
	public void setRevCoaCtrCd(String revCoaCtrCd) {
		this.revCoaCtrCd = revCoaCtrCd;
	}
	
	/**
	 * Column Info
	 * @param joRevTpCd
	 */
	public void setJoRevTpCd(String joRevTpCd) {
		this.joRevTpCd = joRevTpCd;
	}
	
	/**
	 * Column Info
	 * @param actCustCntCd
	 */
	public void setActCustCntCd(String actCustCntCd) {
		this.actCustCntCd = actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param erpIfFlg
	 */
	public void setErpIfFlg(String erpIfFlg) {
		this.erpIfFlg = erpIfFlg;
	}
	
	/**
	 * Column Info
	 * @param dueDt
	 */
	public void setDueDt(String dueDt) {
		this.dueDt = dueDt;
	}
	
	/**
	 * Column Info
	 * @param invCoaInterCoCd
	 */
	public void setInvCoaInterCoCd(String invCoaInterCoCd) {
		this.invCoaInterCoCd = invCoaInterCoCd;
	}
	
	/**
	 * Column Info
	 * @param sobId
	 */
	public void setSobId(String sobId) {
		this.sobId = sobId;
	}
	
	/**
	 * Column Info
	 * @param invCoaVslCd
	 */
	public void setInvCoaVslCd(String invCoaVslCd) {
		this.invCoaVslCd = invCoaVslCd;
	}
	
	/**
	 * Column Info
	 * @param crTermDys
	 */
	public void setCrTermDys(String crTermDys) {
		this.crTermDys = crTermDys;
	}
	
	/**
	 * Column Info
	 * @param revSkdDirCd
	 */
	public void setRevSkdDirCd(String revSkdDirCd) {
		this.revSkdDirCd = revSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param invCustSeq
	 */
	public void setInvCustSeq(String invCustSeq) {
		this.invCustSeq = invCustSeq;
	}
	
	/**
	 * Column Info
	 * @param arSrcCd
	 */
	public void setArSrcCd(String arSrcCd) {
		this.arSrcCd = arSrcCd;
	}
	
	/**
	 * Column Info
	 * @param actCustSeq
	 */
	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
	}
	
	/**
	 * Column Info
	 * @param invCoaSkdDirCd
	 */
	public void setInvCoaSkdDirCd(String invCoaSkdDirCd) {
		this.invCoaSkdDirCd = invCoaSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param loclAmt
	 */
	public void setLoclAmt(String loclAmt) {
		this.loclAmt = loclAmt;
	}
	
	/**
	 * Column Info
	 * @param slpNo
	 */
	public void setSlpNo(String slpNo) {
		this.slpNo = slpNo;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param erpIfDt
	 */
	public void setErpIfDt(String erpIfDt) {
		this.erpIfDt = erpIfDt;
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
	 * @param revCoaVoyNo
	 */
	public void setRevCoaVoyNo(String revCoaVoyNo) {
		this.revCoaVoyNo = revCoaVoyNo;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param invRmk
	 */
	public void setInvRmk(String invRmk) {
		this.invRmk = invRmk;
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
	 * @param ratAsCntrQty
	 */
	public void setRatAsCntrQty(String ratAsCntrQty) {
		this.ratAsCntrQty = ratAsCntrQty;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setRepChgCd(JSPUtil.getParameter(request, "rep_chg_cd", ""));
		setGlDt(JSPUtil.getParameter(request, "gl_dt", ""));
		setJoBlNo(JSPUtil.getParameter(request, "jo_bl_no", ""));
		setInvCoaRevDirCd(JSPUtil.getParameter(request, "inv_coa_rev_dir_cd", ""));
		setTaxXchRt(JSPUtil.getParameter(request, "tax_xch_rt", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setInvCtrtNo(JSPUtil.getParameter(request, "inv_ctrt_no", ""));
		setSailArrDt(JSPUtil.getParameter(request, "sail_arr_dt", ""));
		setInvCoaCoCd(JSPUtil.getParameter(request, "inv_coa_co_cd", ""));
		setChgCd(JSPUtil.getParameter(request, "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setInvCoaAcctCd(JSPUtil.getParameter(request, "inv_coa_acct_cd", ""));
		setInvCustCntCd(JSPUtil.getParameter(request, "inv_cust_cnt_cd", ""));
		setChgAmt(JSPUtil.getParameter(request, "chg_amt", ""));
		setSlsOfcCd(JSPUtil.getParameter(request, "sls_ofc_cd", ""));
		setRevCoaCoCd(JSPUtil.getParameter(request, "rev_coa_co_cd", ""));
		setInvCoaRgnCd(JSPUtil.getParameter(request, "inv_coa_rgn_cd", ""));
		setInvCoaVoyNo(JSPUtil.getParameter(request, "inv_coa_voy_no", ""));
		setZnIocCd(JSPUtil.getParameter(request, "zn_ioc_cd", ""));
		setRevCoaVslCd(JSPUtil.getParameter(request, "rev_coa_vsl_cd", ""));
		setRhqCd(JSPUtil.getParameter(request, "rhq_cd", ""));
		setRevSkdVoyNo(JSPUtil.getParameter(request, "rev_skd_voy_no", ""));
		setChgFullNm(JSPUtil.getParameter(request, "chg_full_nm", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setArLocCd(JSPUtil.getParameter(request, "ar_loc_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setInvCoaCtrCd(JSPUtil.getParameter(request, "inv_coa_ctr_cd", ""));
		setRevCoaSkdDirCd(JSPUtil.getParameter(request, "rev_coa_skd_dir_cd", ""));
		setRevCoaRgnCd(JSPUtil.getParameter(request, "rev_coa_rgn_cd", ""));
		setSailDt(JSPUtil.getParameter(request, "sail_dt", ""));
		setRevVslCd(JSPUtil.getParameter(request, "rev_vsl_cd", ""));
		setCustCrFlg(JSPUtil.getParameter(request, "cust_cr_flg", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setTrnkVslCd(JSPUtil.getParameter(request, "trnk_vsl_cd", ""));
		setRevCoaInterCoCd(JSPUtil.getParameter(request, "rev_coa_inter_co_cd", ""));
		setTrnkSkdVoyNo(JSPUtil.getParameter(request, "trnk_skd_voy_no", ""));
		setArIfSerNo(JSPUtil.getParameter(request, "ar_if_ser_no", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setXchRtTpCd(JSPUtil.getParameter(request, "xch_rt_tp_cd", ""));
		setRevCoaDirCd(JSPUtil.getParameter(request, "rev_coa_dir_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setArTaxIndCd(JSPUtil.getParameter(request, "ar_tax_ind_cd", ""));
		setTrfRtAmt(JSPUtil.getParameter(request, "trf_rt_amt", ""));
		setChgSeq(JSPUtil.getParameter(request, "chg_seq", ""));
		setLogUpdDt(JSPUtil.getParameter(request, "log_upd_dt", ""));
		setRevCoaAcctCd(JSPUtil.getParameter(request, "rev_coa_acct_cd", ""));
		setIssDt(JSPUtil.getParameter(request, "iss_dt", ""));
		setRevDirCd(JSPUtil.getParameter(request, "rev_dir_cd", ""));
		setTrnkSkdDirCd(JSPUtil.getParameter(request, "trnk_skd_dir_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTaxAmt(JSPUtil.getParameter(request, "tax_amt", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setArIfNo(JSPUtil.getParameter(request, "ar_if_no", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setRevCoaCtrCd(JSPUtil.getParameter(request, "rev_coa_ctr_cd", ""));
		setJoRevTpCd(JSPUtil.getParameter(request, "jo_rev_tp_cd", ""));
		setActCustCntCd(JSPUtil.getParameter(request, "act_cust_cnt_cd", ""));
		setErpIfFlg(JSPUtil.getParameter(request, "erp_if_flg", ""));
		setDueDt(JSPUtil.getParameter(request, "due_dt", ""));
		setInvCoaInterCoCd(JSPUtil.getParameter(request, "inv_coa_inter_co_cd", ""));
		setSobId(JSPUtil.getParameter(request, "sob_id", ""));
		setInvCoaVslCd(JSPUtil.getParameter(request, "inv_coa_vsl_cd", ""));
		setCrTermDys(JSPUtil.getParameter(request, "cr_term_dys", ""));
		setRevSkdDirCd(JSPUtil.getParameter(request, "rev_skd_dir_cd", ""));
		setInvCustSeq(JSPUtil.getParameter(request, "inv_cust_seq", ""));
		setArSrcCd(JSPUtil.getParameter(request, "ar_src_cd", ""));
		setActCustSeq(JSPUtil.getParameter(request, "act_cust_seq", ""));
		setInvCoaSkdDirCd(JSPUtil.getParameter(request, "inv_coa_skd_dir_cd", ""));
		setLoclAmt(JSPUtil.getParameter(request, "locl_amt", ""));
		setSlpNo(JSPUtil.getParameter(request, "slp_no", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request, "ar_ofc_cd", ""));
		setErpIfDt(JSPUtil.getParameter(request, "erp_if_dt", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setRevCoaVoyNo(JSPUtil.getParameter(request, "rev_coa_voy_no", ""));
		setUsdAmt(JSPUtil.getParameter(request, "usd_amt", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setInvRmk(JSPUtil.getParameter(request, "inv_rmk", ""));
		setCsrOffstNo(JSPUtil.getParameter(request, "csr_offst_no", ""));
		setRatAsCntrQty(JSPUtil.getParameter(request, "rat_as_cntr_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ArMnChgVO[]
	 */
	public ArMnChgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ArMnChgVO[]
	 */
	public ArMnChgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ArMnChgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] repChgCd = (JSPUtil.getParameter(request, prefix	+ "rep_chg_cd", length));
			String[] glDt = (JSPUtil.getParameter(request, prefix	+ "gl_dt", length));
			String[] joBlNo = (JSPUtil.getParameter(request, prefix	+ "jo_bl_no", length));
			String[] invCoaRevDirCd = (JSPUtil.getParameter(request, prefix	+ "inv_coa_rev_dir_cd", length));
			String[] taxXchRt = (JSPUtil.getParameter(request, prefix	+ "tax_xch_rt", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] invCtrtNo = (JSPUtil.getParameter(request, prefix	+ "inv_ctrt_no", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] invCoaCoCd = (JSPUtil.getParameter(request, prefix	+ "inv_coa_co_cd", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] invCoaAcctCd = (JSPUtil.getParameter(request, prefix	+ "inv_coa_acct_cd", length));
			String[] invCustCntCd = (JSPUtil.getParameter(request, prefix	+ "inv_cust_cnt_cd", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] slsOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_cd", length));
			String[] revCoaCoCd = (JSPUtil.getParameter(request, prefix	+ "rev_coa_co_cd", length));
			String[] invCoaRgnCd = (JSPUtil.getParameter(request, prefix	+ "inv_coa_rgn_cd", length));
			String[] invCoaVoyNo = (JSPUtil.getParameter(request, prefix	+ "inv_coa_voy_no", length));
			String[] znIocCd = (JSPUtil.getParameter(request, prefix	+ "zn_ioc_cd", length));
			String[] revCoaVslCd = (JSPUtil.getParameter(request, prefix	+ "rev_coa_vsl_cd", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] revSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "rev_skd_voy_no", length));
			String[] chgFullNm = (JSPUtil.getParameter(request, prefix	+ "chg_full_nm", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] arLocCd = (JSPUtil.getParameter(request, prefix	+ "ar_loc_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] invCoaCtrCd = (JSPUtil.getParameter(request, prefix	+ "inv_coa_ctr_cd", length));
			String[] revCoaSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_coa_skd_dir_cd", length));
			String[] revCoaRgnCd = (JSPUtil.getParameter(request, prefix	+ "rev_coa_rgn_cd", length));
			String[] sailDt = (JSPUtil.getParameter(request, prefix	+ "sail_dt", length));
			String[] revVslCd = (JSPUtil.getParameter(request, prefix	+ "rev_vsl_cd", length));
			String[] custCrFlg = (JSPUtil.getParameter(request, prefix	+ "cust_cr_flg", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] trnkVslCd = (JSPUtil.getParameter(request, prefix	+ "trnk_vsl_cd", length));
			String[] revCoaInterCoCd = (JSPUtil.getParameter(request, prefix	+ "rev_coa_inter_co_cd", length));
			String[] trnkSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "trnk_skd_voy_no", length));
			String[] arIfSerNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_ser_no", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] xchRtTpCd = (JSPUtil.getParameter(request, prefix	+ "xch_rt_tp_cd", length));
			String[] revCoaDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_coa_dir_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] arTaxIndCd = (JSPUtil.getParameter(request, prefix	+ "ar_tax_ind_cd", length));
			String[] trfRtAmt = (JSPUtil.getParameter(request, prefix	+ "trf_rt_amt", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] logUpdDt = (JSPUtil.getParameter(request, prefix	+ "log_upd_dt", length));
			String[] revCoaAcctCd = (JSPUtil.getParameter(request, prefix	+ "rev_coa_acct_cd", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd", length));
			String[] trnkSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "trnk_skd_dir_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] taxAmt = (JSPUtil.getParameter(request, prefix	+ "tax_amt", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] arIfNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_no", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] revCoaCtrCd = (JSPUtil.getParameter(request, prefix	+ "rev_coa_ctr_cd", length));
			String[] joRevTpCd = (JSPUtil.getParameter(request, prefix	+ "jo_rev_tp_cd", length));
			String[] actCustCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cnt_cd", length));
			String[] erpIfFlg = (JSPUtil.getParameter(request, prefix	+ "erp_if_flg", length));
			String[] dueDt = (JSPUtil.getParameter(request, prefix	+ "due_dt", length));
			String[] invCoaInterCoCd = (JSPUtil.getParameter(request, prefix	+ "inv_coa_inter_co_cd", length));
			String[] sobId = (JSPUtil.getParameter(request, prefix	+ "sob_id", length));
			String[] invCoaVslCd = (JSPUtil.getParameter(request, prefix	+ "inv_coa_vsl_cd", length));
			String[] crTermDys = (JSPUtil.getParameter(request, prefix	+ "cr_term_dys", length));
			String[] revSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_skd_dir_cd", length));
			String[] invCustSeq = (JSPUtil.getParameter(request, prefix	+ "inv_cust_seq", length));
			String[] arSrcCd = (JSPUtil.getParameter(request, prefix	+ "ar_src_cd", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] invCoaSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "inv_coa_skd_dir_cd", length));
			String[] loclAmt = (JSPUtil.getParameter(request, prefix	+ "locl_amt", length));
			String[] slpNo = (JSPUtil.getParameter(request, prefix	+ "slp_no", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] erpIfDt = (JSPUtil.getParameter(request, prefix	+ "erp_if_dt", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] revCoaVoyNo = (JSPUtil.getParameter(request, prefix	+ "rev_coa_voy_no", length));
			String[] usdAmt = (JSPUtil.getParameter(request, prefix	+ "usd_amt", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] invRmk = (JSPUtil.getParameter(request, prefix	+ "inv_rmk", length));
			String[] csrOffstNo = (JSPUtil.getParameter(request, prefix	+ "csr_offst_no", length));
			String[] ratAsCntrQty = (JSPUtil.getParameter(request, prefix	+ "rat_as_cntr_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new ArMnChgVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (repChgCd[i] != null)
					model.setRepChgCd(repChgCd[i]);
				if (glDt[i] != null)
					model.setGlDt(glDt[i]);
				if (joBlNo[i] != null)
					model.setJoBlNo(joBlNo[i]);
				if (invCoaRevDirCd[i] != null)
					model.setInvCoaRevDirCd(invCoaRevDirCd[i]);
				if (taxXchRt[i] != null)
					model.setTaxXchRt(taxXchRt[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (invCtrtNo[i] != null)
					model.setInvCtrtNo(invCtrtNo[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (invCoaCoCd[i] != null)
					model.setInvCoaCoCd(invCoaCoCd[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (invCoaAcctCd[i] != null)
					model.setInvCoaAcctCd(invCoaAcctCd[i]);
				if (invCustCntCd[i] != null)
					model.setInvCustCntCd(invCustCntCd[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (slsOfcCd[i] != null)
					model.setSlsOfcCd(slsOfcCd[i]);
				if (revCoaCoCd[i] != null)
					model.setRevCoaCoCd(revCoaCoCd[i]);
				if (invCoaRgnCd[i] != null)
					model.setInvCoaRgnCd(invCoaRgnCd[i]);
				if (invCoaVoyNo[i] != null)
					model.setInvCoaVoyNo(invCoaVoyNo[i]);
				if (znIocCd[i] != null)
					model.setZnIocCd(znIocCd[i]);
				if (revCoaVslCd[i] != null)
					model.setRevCoaVslCd(revCoaVslCd[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (revSkdVoyNo[i] != null)
					model.setRevSkdVoyNo(revSkdVoyNo[i]);
				if (chgFullNm[i] != null)
					model.setChgFullNm(chgFullNm[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (arLocCd[i] != null)
					model.setArLocCd(arLocCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (invCoaCtrCd[i] != null)
					model.setInvCoaCtrCd(invCoaCtrCd[i]);
				if (revCoaSkdDirCd[i] != null)
					model.setRevCoaSkdDirCd(revCoaSkdDirCd[i]);
				if (revCoaRgnCd[i] != null)
					model.setRevCoaRgnCd(revCoaRgnCd[i]);
				if (sailDt[i] != null)
					model.setSailDt(sailDt[i]);
				if (revVslCd[i] != null)
					model.setRevVslCd(revVslCd[i]);
				if (custCrFlg[i] != null)
					model.setCustCrFlg(custCrFlg[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (trnkVslCd[i] != null)
					model.setTrnkVslCd(trnkVslCd[i]);
				if (revCoaInterCoCd[i] != null)
					model.setRevCoaInterCoCd(revCoaInterCoCd[i]);
				if (trnkSkdVoyNo[i] != null)
					model.setTrnkSkdVoyNo(trnkSkdVoyNo[i]);
				if (arIfSerNo[i] != null)
					model.setArIfSerNo(arIfSerNo[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (xchRtTpCd[i] != null)
					model.setXchRtTpCd(xchRtTpCd[i]);
				if (revCoaDirCd[i] != null)
					model.setRevCoaDirCd(revCoaDirCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (arTaxIndCd[i] != null)
					model.setArTaxIndCd(arTaxIndCd[i]);
				if (trfRtAmt[i] != null)
					model.setTrfRtAmt(trfRtAmt[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (logUpdDt[i] != null)
					model.setLogUpdDt(logUpdDt[i]);
				if (revCoaAcctCd[i] != null)
					model.setRevCoaAcctCd(revCoaAcctCd[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (trnkSkdDirCd[i] != null)
					model.setTrnkSkdDirCd(trnkSkdDirCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (taxAmt[i] != null)
					model.setTaxAmt(taxAmt[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (arIfNo[i] != null)
					model.setArIfNo(arIfNo[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (revCoaCtrCd[i] != null)
					model.setRevCoaCtrCd(revCoaCtrCd[i]);
				if (joRevTpCd[i] != null)
					model.setJoRevTpCd(joRevTpCd[i]);
				if (actCustCntCd[i] != null)
					model.setActCustCntCd(actCustCntCd[i]);
				if (erpIfFlg[i] != null)
					model.setErpIfFlg(erpIfFlg[i]);
				if (dueDt[i] != null)
					model.setDueDt(dueDt[i]);
				if (invCoaInterCoCd[i] != null)
					model.setInvCoaInterCoCd(invCoaInterCoCd[i]);
				if (sobId[i] != null)
					model.setSobId(sobId[i]);
				if (invCoaVslCd[i] != null)
					model.setInvCoaVslCd(invCoaVslCd[i]);
				if (crTermDys[i] != null)
					model.setCrTermDys(crTermDys[i]);
				if (revSkdDirCd[i] != null)
					model.setRevSkdDirCd(revSkdDirCd[i]);
				if (invCustSeq[i] != null)
					model.setInvCustSeq(invCustSeq[i]);
				if (arSrcCd[i] != null)
					model.setArSrcCd(arSrcCd[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (invCoaSkdDirCd[i] != null)
					model.setInvCoaSkdDirCd(invCoaSkdDirCd[i]);
				if (loclAmt[i] != null)
					model.setLoclAmt(loclAmt[i]);
				if (slpNo[i] != null)
					model.setSlpNo(slpNo[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (erpIfDt[i] != null)
					model.setErpIfDt(erpIfDt[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (revCoaVoyNo[i] != null)
					model.setRevCoaVoyNo(revCoaVoyNo[i]);
				if (usdAmt[i] != null)
					model.setUsdAmt(usdAmt[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (invRmk[i] != null)
					model.setInvRmk(invRmk[i]);
				if (csrOffstNo[i] != null)
					model.setCsrOffstNo(csrOffstNo[i]);
				if (ratAsCntrQty[i] != null)
					model.setRatAsCntrQty(ratAsCntrQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getArMnChgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ArMnChgVO[]
	 */
	public ArMnChgVO[] getArMnChgVOs(){
		ArMnChgVO[] vos = (ArMnChgVO[])models.toArray(new ArMnChgVO[models.size()]);
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
		this.repChgCd = this.repChgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDt = this.glDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joBlNo = this.joBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCoaRevDirCd = this.invCoaRevDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxXchRt = this.taxXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCtrtNo = this.invCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCoaCoCd = this.invCoaCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCoaAcctCd = this.invCoaAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustCntCd = this.invCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcCd = this.slsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaCoCd = this.revCoaCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCoaRgnCd = this.invCoaRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCoaVoyNo = this.invCoaVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.znIocCd = this.znIocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaVslCd = this.revCoaVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revSkdVoyNo = this.revSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgFullNm = this.chgFullNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arLocCd = this.arLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCoaCtrCd = this.invCoaCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaSkdDirCd = this.revCoaSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaRgnCd = this.revCoaRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailDt = this.sailDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVslCd = this.revVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCrFlg = this.custCrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkVslCd = this.trnkVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaInterCoCd = this.revCoaInterCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkSkdVoyNo = this.trnkSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfSerNo = this.arIfSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtTpCd = this.xchRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaDirCd = this.revCoaDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arTaxIndCd = this.arTaxIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfRtAmt = this.trfRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.logUpdDt = this.logUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaAcctCd = this.revCoaAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkSkdDirCd = this.trnkSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxAmt = this.taxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo = this.arIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaCtrCd = this.revCoaCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRevTpCd = this.joRevTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd = this.actCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.erpIfFlg = this.erpIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt = this.dueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCoaInterCoCd = this.invCoaInterCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sobId = this.sobId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCoaVslCd = this.invCoaVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crTermDys = this.crTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revSkdDirCd = this.revSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustSeq = this.invCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arSrcCd = this.arSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCoaSkdDirCd = this.invCoaSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAmt = this.loclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpNo = this.slpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.erpIfDt = this.erpIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaVoyNo = this.revCoaVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdAmt = this.usdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRmk = this.invRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrOffstNo = this.csrOffstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratAsCntrQty = this.ratAsCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
