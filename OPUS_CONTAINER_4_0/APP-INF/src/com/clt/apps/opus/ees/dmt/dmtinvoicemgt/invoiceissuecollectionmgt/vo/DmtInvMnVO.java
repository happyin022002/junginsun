/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DmtInvMnVO.java
*@FileTitle : DmtInvMnVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.18
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.18  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DmtInvMnVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DmtInvMnVO> models = new ArrayList<DmtInvMnVO>();
	
	/* Column Info */
	private String taxRto = null;
	/* Column Info */
	private String invPrtFlg = null;
	/* Column Info */
	private String invHldRsnNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String chgCurrCd = null;
	/* Column Info */
	private String dcAmt = null;
	/* Column Info */
	private String bkgCustNm = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String aftInvAdjAmt = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String aftExptAproNo = null;
	/* Column Info */
	private String ntcKntCd = null;
	/* Column Info */
	private String truckerCd = null;
	/* Column Info */
	private String issueOfcCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String payrCntcPntList = null;
	/* Column Info */
	private String dmdtInvStsDesc = null;
	/* Column Info */
	private String actCustCd = null;
	/* Column Info */
	private String dmdtPayrCntcPntNm = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String crArIfCd = null;
	/* Column Info */
	private String dmdtCxlRsnNm = null;
	/* Column Info */
	private String caller = null;
	/* Column Info */
	private String totAmt = null;
	/* Column Info */
	private String suthChnIssFlg = null;
	/* Column Info */
	private String mnlInvSndFlg = null;
	/* Column Info */
	private String actPayrCntCd = null;
	/* Column Info */
	private String taxAmt = null;
	/* Column Info */
	private String arIfNo = null;
	/* Column Info */
	private String dueDt = null;
	/* Column Info */
	private String issueDt = null;
	/* Column Info */
	private String crTermDys = null;
	/* Column Info */
	private String dmdtInvStsCd = null;
	/* Column Info */
	private String payrCntcPntEml = null;
	/* Column Info */
	private String invChgAmt = null;
	/* Column Info */
	private String dmdtInvNo = null;
	/* Column Info */
	private String arIfUsrId = null;
	/* Column Info */
	private String actPayrSeq = null;
	/* Column Info */
	private String issDtPrnFlg = null;
	/* Column Info */
	private String invRmk = null;
	/* Column Info */
	private String invHldRsnCd = null;
	/* Column Info */
	private String actPayrCustCd = null;
	/* Column Info */
	private String orgChgAmt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String oldDmdtInvNo = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String dmdtExptAmt = null;
	/* Column Info */
	private String arIfDt = null;
	/* Column Info */
	private String bkgCustCd = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String truckerNm = null;
	/* Column Info */
	private String dmdtPayrTpCd = null;
	/* Column Info */
	private String dmdtMnlInvRsnCd = null;
	/* Column Info */
	private String errCode = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String arIfOfcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String dmdtCxlRsnCd = null;
	/* Column Info */
	private String dfltTaxRto = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String errMsg = null;
	/* Column Info */
	private String mnlInpFlg = null;
	/* Column Info */
	private String dmdtArIfCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String custCntcPntSeq = null;
	/* Column Info */
	private String mnlInvRmk = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String invRmk2 = null;
	/* Column Info */
	private String invRmk1 = null;
	/* Column Info */
	private String bilAmt = null;
	/* Column Info */
	private String payrCntcPntFaxNo = null;
	/* Column Info */
	private String cxlRmk = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String crInvNo = null;
	/* Column Info */
	private String invHldRmk = null;
	/* Column Info */
	private String arIfUsrNm = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String invRefNo = null;
	/* Column Info */
	private String creCntCd = null;
	/* Column Info */
	private String dmdtChgTpCd = null;
	/* Column Info */
	private String actPayrCustNm = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String invCurrCd = null;
	/* Column Info */
	private String bilToLocDivCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String payrCntcPntPhnNo = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String dmdtMnlInvRsnNm = null;
	/* Column Info */
	private String actCustNm = null;
	/* Column Info */
	private String issueUsrNm = null;
	/* Column Info */
	private String updUsrNm = null;
	/* Column Info */
	private String bkgCntrQty = null;
	/* Column Info */
	private String idaHighEduTaxRt = null;
	/* Column Info */
	private String idaExpnTaxRt = null;
	/* Column Info */
	private String idaExpnTax = null;
	/* Column Info */
	private String idaEduTax = null;
	/* Column Info */
	private String idaHighEduTax = null;
	/* Column Info */
	private String idaEduTaxRt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DmtInvMnVO() {}

	public DmtInvMnVO(String ibflag, String pagerows, String taxRto, String taxAmt, String invAmt, String totAmt, String aftExptAproNo, String aftInvAdjAmt, String crInvNo, String crArIfCd, String invRmk, String invRmk1, String invRmk2, String dmdtArIfCd, String arIfNo, String arIfDt, String arIfUsrId, String arIfUsrNm, String arIfOfcCd, String ntcKntCd, String dmdtInvStsCd, String dmdtInvStsDesc, String dmdtCxlRsnCd, String dmdtCxlRsnNm, String cxlRmk, String invHldRsnCd, String invHldRsnNm, String invHldRmk, String invPrtFlg, String invRefNo, String creUsrId, String creDt, String updUsrId, String updUsrNm, String updDt, String updOfcCd, String dmdtInvNo, String creOfcCd, String dmdtTrfCd, String ioBndCd, String dmdtChgTpCd, String mnlInpFlg, String mnlInvSndFlg, String dmdtMnlInvRsnCd, String dmdtMnlInvRsnNm, String mnlInvRmk, String bkgNo, String blNo, String vslCd, String skdVoyNo, String skdDirCd, String custCntCd, String custSeq, String dmdtPayrTpCd, String actPayrCntCd, String actPayrSeq, String porCd, String polCd, String podCd, String delCd, String scNo, String rfaNo, String chgCurrCd, String orgChgAmt, String dmdtExptAmt, String dcAmt, String bilAmt, String bkgCntrQty, String invCurrCd, String invXchRt, String invChgAmt, String payrCntcPntList, String dmdtPayrCntcPntNm, String payrCntcPntPhnNo, String payrCntcPntFaxNo, String payrCntcPntEml, String issueDt, String issueOfcCd, String issueUsrNm, String truckerCd, String vndrSeq, String vndrNm, String truckerNm, String bkgCustCd, String bkgCustNm, String actCustCd, String actCustNm, String vvdCd, String rcvTermCd, String deTermCd, String actPayrCustCd, String actPayrCustNm, String crTermDys, String issDtPrnFlg, String dfltTaxRto, String dueDt, String oldDmdtInvNo, String errCode, String errMsg, String caller, String bilToLocDivCd, String creCntCd, String custCntcPntSeq, String suthChnIssFlg, String idaExpnTaxRt, String idaExpnTax, String idaEduTaxRt, String idaEduTax, String idaHighEduTaxRt, String idaHighEduTax) {
		this.taxRto = taxRto;
		this.invPrtFlg = invPrtFlg;
		this.invHldRsnNm = invHldRsnNm;
		this.pagerows = pagerows;
		this.chgCurrCd = chgCurrCd;
		this.dcAmt = dcAmt;
		this.bkgCustNm = bkgCustNm;
		this.vvdCd = vvdCd;
		this.aftInvAdjAmt = aftInvAdjAmt;
		this.dmdtTrfCd = dmdtTrfCd;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.invXchRt = invXchRt;
		this.aftExptAproNo = aftExptAproNo;
		this.ntcKntCd = ntcKntCd;
		this.truckerCd = truckerCd;
		this.issueOfcCd = issueOfcCd;
		this.skdVoyNo = skdVoyNo;
		this.payrCntcPntList = payrCntcPntList;
		this.dmdtInvStsDesc = dmdtInvStsDesc;
		this.actCustCd = actCustCd;
		this.dmdtPayrCntcPntNm = dmdtPayrCntcPntNm;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.crArIfCd = crArIfCd;
		this.dmdtCxlRsnNm = dmdtCxlRsnNm;
		this.caller = caller;
		this.totAmt = totAmt;
		this.suthChnIssFlg = suthChnIssFlg;
		this.mnlInvSndFlg = mnlInvSndFlg;
		this.actPayrCntCd = actPayrCntCd;
		this.taxAmt = taxAmt;
		this.arIfNo = arIfNo;
		this.dueDt = dueDt;
		this.issueDt = issueDt;
		this.crTermDys = crTermDys;
		this.dmdtInvStsCd = dmdtInvStsCd;
		this.payrCntcPntEml = payrCntcPntEml;
		this.invChgAmt = invChgAmt;
		this.dmdtInvNo = dmdtInvNo;
		this.arIfUsrId = arIfUsrId;
		this.actPayrSeq = actPayrSeq;
		this.issDtPrnFlg = issDtPrnFlg;
		this.invRmk = invRmk;
		this.invHldRsnCd = invHldRsnCd;
		this.actPayrCustCd = actPayrCustCd;
		this.orgChgAmt = orgChgAmt;
		this.vslCd = vslCd;
		this.oldDmdtInvNo = oldDmdtInvNo;
		this.blNo = blNo;
		this.vndrNm = vndrNm;
		this.polCd = polCd;
		this.scNo = scNo;
		this.dmdtExptAmt = dmdtExptAmt;
		this.arIfDt = arIfDt;
		this.bkgCustCd = bkgCustCd;
		this.updOfcCd = updOfcCd;
		this.truckerNm = truckerNm;
		this.dmdtPayrTpCd = dmdtPayrTpCd;
		this.dmdtMnlInvRsnCd = dmdtMnlInvRsnCd;
		this.errCode = errCode;
		this.delCd = delCd;
		this.arIfOfcCd = arIfOfcCd;
		this.creUsrId = creUsrId;
		this.dmdtCxlRsnCd = dmdtCxlRsnCd;
		this.dfltTaxRto = dfltTaxRto;
		this.vndrSeq = vndrSeq;
		this.errMsg = errMsg;
		this.mnlInpFlg = mnlInpFlg;
		this.dmdtArIfCd = dmdtArIfCd;
		this.porCd = porCd;
		this.custCntcPntSeq = custCntcPntSeq;
		this.mnlInvRmk = mnlInvRmk;
		this.creDt = creDt;
		this.invRmk2 = invRmk2;
		this.invRmk1 = invRmk1;
		this.bilAmt = bilAmt;
		this.payrCntcPntFaxNo = payrCntcPntFaxNo;
		this.cxlRmk = cxlRmk;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.creOfcCd = creOfcCd;
		this.invAmt = invAmt;
		this.rcvTermCd = rcvTermCd;
		this.crInvNo = crInvNo;
		this.invHldRmk = invHldRmk;
		this.arIfUsrNm = arIfUsrNm;
		this.updDt = updDt;
		this.invRefNo = invRefNo;
		this.creCntCd = creCntCd;
		this.dmdtChgTpCd = dmdtChgTpCd;
		this.actPayrCustNm = actPayrCustNm;
		this.ioBndCd = ioBndCd;
		this.custSeq = custSeq;
		this.invCurrCd = invCurrCd;
		this.bilToLocDivCd = bilToLocDivCd;
		this.skdDirCd = skdDirCd;
		this.payrCntcPntPhnNo = payrCntcPntPhnNo;
		this.deTermCd = deTermCd;
		this.dmdtMnlInvRsnNm = dmdtMnlInvRsnNm;
		this.actCustNm = actCustNm;
		this.issueUsrNm = issueUsrNm;
		this.updUsrNm = updUsrNm;
		this.bkgCntrQty = bkgCntrQty;
		this.idaHighEduTaxRt = idaHighEduTaxRt;
		this.idaExpnTaxRt = idaExpnTaxRt;
		this.idaExpnTax = idaExpnTax;
		this.idaEduTax = idaEduTax;
		this.idaHighEduTax = idaHighEduTax;
		this.idaEduTaxRt = idaEduTaxRt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tax_rto", getTaxRto());
		this.hashColumns.put("inv_prt_flg", getInvPrtFlg());
		this.hashColumns.put("inv_hld_rsn_nm", getInvHldRsnNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("chg_curr_cd", getChgCurrCd());
		this.hashColumns.put("dc_amt", getDcAmt());
		this.hashColumns.put("bkg_cust_nm", getBkgCustNm());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("aft_inv_adj_amt", getAftInvAdjAmt());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("aft_expt_apro_no", getAftExptAproNo());
		this.hashColumns.put("ntc_knt_cd", getNtcKntCd());
		this.hashColumns.put("trucker_cd", getTruckerCd());
		this.hashColumns.put("issue_ofc_cd", getIssueOfcCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("payr_cntc_pnt_list", getPayrCntcPntList());
		this.hashColumns.put("dmdt_inv_sts_desc", getDmdtInvStsDesc());
		this.hashColumns.put("act_cust_cd", getActCustCd());
		this.hashColumns.put("dmdt_payr_cntc_pnt_nm", getDmdtPayrCntcPntNm());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cr_ar_if_cd", getCrArIfCd());
		this.hashColumns.put("dmdt_cxl_rsn_nm", getDmdtCxlRsnNm());
		this.hashColumns.put("caller", getCaller());
		this.hashColumns.put("tot_amt", getTotAmt());
		this.hashColumns.put("suth_chn_iss_flg", getSuthChnIssFlg());
		this.hashColumns.put("mnl_inv_snd_flg", getMnlInvSndFlg());
		this.hashColumns.put("act_payr_cnt_cd", getActPayrCntCd());
		this.hashColumns.put("tax_amt", getTaxAmt());
		this.hashColumns.put("ar_if_no", getArIfNo());
		this.hashColumns.put("due_dt", getDueDt());
		this.hashColumns.put("issue_dt", getIssueDt());
		this.hashColumns.put("cr_term_dys", getCrTermDys());
		this.hashColumns.put("dmdt_inv_sts_cd", getDmdtInvStsCd());
		this.hashColumns.put("payr_cntc_pnt_eml", getPayrCntcPntEml());
		this.hashColumns.put("inv_chg_amt", getInvChgAmt());
		this.hashColumns.put("dmdt_inv_no", getDmdtInvNo());
		this.hashColumns.put("ar_if_usr_id", getArIfUsrId());
		this.hashColumns.put("act_payr_seq", getActPayrSeq());
		this.hashColumns.put("iss_dt_prn_flg", getIssDtPrnFlg());
		this.hashColumns.put("inv_rmk", getInvRmk());
		this.hashColumns.put("inv_hld_rsn_cd", getInvHldRsnCd());
		this.hashColumns.put("act_payr_cust_cd", getActPayrCustCd());
		this.hashColumns.put("org_chg_amt", getOrgChgAmt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("old_dmdt_inv_no", getOldDmdtInvNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("dmdt_expt_amt", getDmdtExptAmt());
		this.hashColumns.put("ar_if_dt", getArIfDt());
		this.hashColumns.put("bkg_cust_cd", getBkgCustCd());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("trucker_nm", getTruckerNm());
		this.hashColumns.put("dmdt_payr_tp_cd", getDmdtPayrTpCd());
		this.hashColumns.put("dmdt_mnl_inv_rsn_cd", getDmdtMnlInvRsnCd());
		this.hashColumns.put("err_code", getErrCode());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("ar_if_ofc_cd", getArIfOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("dmdt_cxl_rsn_cd", getDmdtCxlRsnCd());
		this.hashColumns.put("dflt_tax_rto", getDfltTaxRto());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("err_msg", getErrMsg());
		this.hashColumns.put("mnl_inp_flg", getMnlInpFlg());
		this.hashColumns.put("dmdt_ar_if_cd", getDmdtArIfCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("cust_cntc_pnt_seq", getCustCntcPntSeq());
		this.hashColumns.put("mnl_inv_rmk", getMnlInvRmk());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("inv_rmk2", getInvRmk2());
		this.hashColumns.put("inv_rmk1", getInvRmk1());
		this.hashColumns.put("bil_amt", getBilAmt());
		this.hashColumns.put("payr_cntc_pnt_fax_no", getPayrCntcPntFaxNo());
		this.hashColumns.put("cxl_rmk", getCxlRmk());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("cr_inv_no", getCrInvNo());
		this.hashColumns.put("inv_hld_rmk", getInvHldRmk());
		this.hashColumns.put("ar_if_usr_nm", getArIfUsrNm());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("inv_ref_no", getInvRefNo());
		this.hashColumns.put("cre_cnt_cd", getCreCntCd());
		this.hashColumns.put("dmdt_chg_tp_cd", getDmdtChgTpCd());
		this.hashColumns.put("act_payr_cust_nm", getActPayrCustNm());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());
		this.hashColumns.put("bil_to_loc_div_cd", getBilToLocDivCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("payr_cntc_pnt_phn_no", getPayrCntcPntPhnNo());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("dmdt_mnl_inv_rsn_nm", getDmdtMnlInvRsnNm());
		this.hashColumns.put("act_cust_nm", getActCustNm());
		this.hashColumns.put("issue_usr_nm", getIssueUsrNm());
		this.hashColumns.put("upd_usr_nm", getUpdUsrNm());
		this.hashColumns.put("bkg_cntr_qty", getBkgCntrQty());
		this.hashColumns.put("ida_high_edu_tax_rt", getIdaHighEduTaxRt());
		this.hashColumns.put("ida_expn_tax_rt", getIdaExpnTaxRt());
		this.hashColumns.put("ida_expn_tax", getIdaExpnTax());
		this.hashColumns.put("ida_edu_tax", getIdaEduTax());
		this.hashColumns.put("ida_high_edu_tax", getIdaHighEduTax());
		this.hashColumns.put("ida_edu_tax_rt", getIdaEduTaxRt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tax_rto", "taxRto");
		this.hashFields.put("inv_prt_flg", "invPrtFlg");
		this.hashFields.put("inv_hld_rsn_nm", "invHldRsnNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("chg_curr_cd", "chgCurrCd");
		this.hashFields.put("dc_amt", "dcAmt");
		this.hashFields.put("bkg_cust_nm", "bkgCustNm");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("aft_inv_adj_amt", "aftInvAdjAmt");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("aft_expt_apro_no", "aftExptAproNo");
		this.hashFields.put("ntc_knt_cd", "ntcKntCd");
		this.hashFields.put("trucker_cd", "truckerCd");
		this.hashFields.put("issue_ofc_cd", "issueOfcCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("payr_cntc_pnt_list", "payrCntcPntList");
		this.hashFields.put("dmdt_inv_sts_desc", "dmdtInvStsDesc");
		this.hashFields.put("act_cust_cd", "actCustCd");
		this.hashFields.put("dmdt_payr_cntc_pnt_nm", "dmdtPayrCntcPntNm");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cr_ar_if_cd", "crArIfCd");
		this.hashFields.put("dmdt_cxl_rsn_nm", "dmdtCxlRsnNm");
		this.hashFields.put("caller", "caller");
		this.hashFields.put("tot_amt", "totAmt");
		this.hashFields.put("suth_chn_iss_flg", "suthChnIssFlg");
		this.hashFields.put("mnl_inv_snd_flg", "mnlInvSndFlg");
		this.hashFields.put("act_payr_cnt_cd", "actPayrCntCd");
		this.hashFields.put("tax_amt", "taxAmt");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("issue_dt", "issueDt");
		this.hashFields.put("cr_term_dys", "crTermDys");
		this.hashFields.put("dmdt_inv_sts_cd", "dmdtInvStsCd");
		this.hashFields.put("payr_cntc_pnt_eml", "payrCntcPntEml");
		this.hashFields.put("inv_chg_amt", "invChgAmt");
		this.hashFields.put("dmdt_inv_no", "dmdtInvNo");
		this.hashFields.put("ar_if_usr_id", "arIfUsrId");
		this.hashFields.put("act_payr_seq", "actPayrSeq");
		this.hashFields.put("iss_dt_prn_flg", "issDtPrnFlg");
		this.hashFields.put("inv_rmk", "invRmk");
		this.hashFields.put("inv_hld_rsn_cd", "invHldRsnCd");
		this.hashFields.put("act_payr_cust_cd", "actPayrCustCd");
		this.hashFields.put("org_chg_amt", "orgChgAmt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("old_dmdt_inv_no", "oldDmdtInvNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("dmdt_expt_amt", "dmdtExptAmt");
		this.hashFields.put("ar_if_dt", "arIfDt");
		this.hashFields.put("bkg_cust_cd", "bkgCustCd");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("trucker_nm", "truckerNm");
		this.hashFields.put("dmdt_payr_tp_cd", "dmdtPayrTpCd");
		this.hashFields.put("dmdt_mnl_inv_rsn_cd", "dmdtMnlInvRsnCd");
		this.hashFields.put("err_code", "errCode");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("ar_if_ofc_cd", "arIfOfcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("dmdt_cxl_rsn_cd", "dmdtCxlRsnCd");
		this.hashFields.put("dflt_tax_rto", "dfltTaxRto");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("err_msg", "errMsg");
		this.hashFields.put("mnl_inp_flg", "mnlInpFlg");
		this.hashFields.put("dmdt_ar_if_cd", "dmdtArIfCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("cust_cntc_pnt_seq", "custCntcPntSeq");
		this.hashFields.put("mnl_inv_rmk", "mnlInvRmk");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("inv_rmk2", "invRmk2");
		this.hashFields.put("inv_rmk1", "invRmk1");
		this.hashFields.put("bil_amt", "bilAmt");
		this.hashFields.put("payr_cntc_pnt_fax_no", "payrCntcPntFaxNo");
		this.hashFields.put("cxl_rmk", "cxlRmk");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("cr_inv_no", "crInvNo");
		this.hashFields.put("inv_hld_rmk", "invHldRmk");
		this.hashFields.put("ar_if_usr_nm", "arIfUsrNm");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("inv_ref_no", "invRefNo");
		this.hashFields.put("cre_cnt_cd", "creCntCd");
		this.hashFields.put("dmdt_chg_tp_cd", "dmdtChgTpCd");
		this.hashFields.put("act_payr_cust_nm", "actPayrCustNm");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("bil_to_loc_div_cd", "bilToLocDivCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("payr_cntc_pnt_phn_no", "payrCntcPntPhnNo");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("dmdt_mnl_inv_rsn_nm", "dmdtMnlInvRsnNm");
		this.hashFields.put("act_cust_nm", "actCustNm");
		this.hashFields.put("issue_usr_nm", "issueUsrNm");
		this.hashFields.put("upd_usr_nm", "updUsrNm");
		this.hashFields.put("bkg_cntr_qty", "bkgCntrQty");
		this.hashFields.put("ida_high_edu_tax_rt", "idaHighEduTaxRt");
		this.hashFields.put("ida_expn_tax_rt", "idaExpnTaxRt");
		this.hashFields.put("ida_expn_tax", "idaExpnTax");
		this.hashFields.put("ida_edu_tax", "idaEduTax");
		this.hashFields.put("ida_high_edu_tax", "idaHighEduTax");
		this.hashFields.put("ida_edu_tax_rt", "idaEduTaxRt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return taxRto
	 */
	public String getTaxRto() {
		return this.taxRto;
	}
	
	/**
	 * Column Info
	 * @return invPrtFlg
	 */
	public String getInvPrtFlg() {
		return this.invPrtFlg;
	}
	
	/**
	 * Column Info
	 * @return invHldRsnNm
	 */
	public String getInvHldRsnNm() {
		return this.invHldRsnNm;
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
	 * @return chgCurrCd
	 */
	public String getChgCurrCd() {
		return this.chgCurrCd;
	}
	
	/**
	 * Column Info
	 * @return dcAmt
	 */
	public String getDcAmt() {
		return this.dcAmt;
	}
	
	/**
	 * Column Info
	 * @return bkgCustNm
	 */
	public String getBkgCustNm() {
		return this.bkgCustNm;
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
	 * @return aftInvAdjAmt
	 */
	public String getAftInvAdjAmt() {
		return this.aftInvAdjAmt;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
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
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return invXchRt
	 */
	public String getInvXchRt() {
		return this.invXchRt;
	}
	
	/**
	 * Column Info
	 * @return aftExptAproNo
	 */
	public String getAftExptAproNo() {
		return this.aftExptAproNo;
	}
	
	/**
	 * Column Info
	 * @return ntcKntCd
	 */
	public String getNtcKntCd() {
		return this.ntcKntCd;
	}
	
	/**
	 * Column Info
	 * @return truckerCd
	 */
	public String getTruckerCd() {
		return this.truckerCd;
	}
	
	/**
	 * Column Info
	 * @return issueOfcCd
	 */
	public String getIssueOfcCd() {
		return this.issueOfcCd;
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
	 * @return payrCntcPntList
	 */
	public String getPayrCntcPntList() {
		return this.payrCntcPntList;
	}
	
	/**
	 * Column Info
	 * @return dmdtInvStsDesc
	 */
	public String getDmdtInvStsDesc() {
		return this.dmdtInvStsDesc;
	}
	
	/**
	 * Column Info
	 * @return actCustCd
	 */
	public String getActCustCd() {
		return this.actCustCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtPayrCntcPntNm
	 */
	public String getDmdtPayrCntcPntNm() {
		return this.dmdtPayrCntcPntNm;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return crArIfCd
	 */
	public String getCrArIfCd() {
		return this.crArIfCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtCxlRsnNm
	 */
	public String getDmdtCxlRsnNm() {
		return this.dmdtCxlRsnNm;
	}
	
	/**
	 * Column Info
	 * @return caller
	 */
	public String getCaller() {
		return this.caller;
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
	 * @return suthChnIssFlg
	 */
	public String getSuthChnIssFlg() {
		return this.suthChnIssFlg;
	}
	
	/**
	 * Column Info
	 * @return mnlInvSndFlg
	 */
	public String getMnlInvSndFlg() {
		return this.mnlInvSndFlg;
	}
	
	/**
	 * Column Info
	 * @return actPayrCntCd
	 */
	public String getActPayrCntCd() {
		return this.actPayrCntCd;
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
	 * @return arIfNo
	 */
	public String getArIfNo() {
		return this.arIfNo;
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
	 * @return issueDt
	 */
	public String getIssueDt() {
		return this.issueDt;
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
	 * @return dmdtInvStsCd
	 */
	public String getDmdtInvStsCd() {
		return this.dmdtInvStsCd;
	}
	
	/**
	 * Column Info
	 * @return payrCntcPntEml
	 */
	public String getPayrCntcPntEml() {
		return this.payrCntcPntEml;
	}
	
	/**
	 * Column Info
	 * @return invChgAmt
	 */
	public String getInvChgAmt() {
		return this.invChgAmt;
	}
	
	/**
	 * Column Info
	 * @return dmdtInvNo
	 */
	public String getDmdtInvNo() {
		return this.dmdtInvNo;
	}
	
	/**
	 * Column Info
	 * @return arIfUsrId
	 */
	public String getArIfUsrId() {
		return this.arIfUsrId;
	}
	
	/**
	 * Column Info
	 * @return actPayrSeq
	 */
	public String getActPayrSeq() {
		return this.actPayrSeq;
	}
	
	/**
	 * Column Info
	 * @return issDtPrnFlg
	 */
	public String getIssDtPrnFlg() {
		return this.issDtPrnFlg;
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
	 * @return invHldRsnCd
	 */
	public String getInvHldRsnCd() {
		return this.invHldRsnCd;
	}
	
	/**
	 * Column Info
	 * @return actPayrCustCd
	 */
	public String getActPayrCustCd() {
		return this.actPayrCustCd;
	}
	
	/**
	 * Column Info
	 * @return orgChgAmt
	 */
	public String getOrgChgAmt() {
		return this.orgChgAmt;
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
	 * @return oldDmdtInvNo
	 */
	public String getOldDmdtInvNo() {
		return this.oldDmdtInvNo;
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
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
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
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return dmdtExptAmt
	 */
	public String getDmdtExptAmt() {
		return this.dmdtExptAmt;
	}
	
	/**
	 * Column Info
	 * @return arIfDt
	 */
	public String getArIfDt() {
		return this.arIfDt;
	}
	
	/**
	 * Column Info
	 * @return bkgCustCd
	 */
	public String getBkgCustCd() {
		return this.bkgCustCd;
	}
	
	/**
	 * Column Info
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
	}
	
	/**
	 * Column Info
	 * @return truckerNm
	 */
	public String getTruckerNm() {
		return this.truckerNm;
	}
	
	/**
	 * Column Info
	 * @return dmdtPayrTpCd
	 */
	public String getDmdtPayrTpCd() {
		return this.dmdtPayrTpCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtMnlInvRsnCd
	 */
	public String getDmdtMnlInvRsnCd() {
		return this.dmdtMnlInvRsnCd;
	}
	
	/**
	 * Column Info
	 * @return errCode
	 */
	public String getErrCode() {
		return this.errCode;
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
	 * @return arIfOfcCd
	 */
	public String getArIfOfcCd() {
		return this.arIfOfcCd;
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
	 * @return dmdtCxlRsnCd
	 */
	public String getDmdtCxlRsnCd() {
		return this.dmdtCxlRsnCd;
	}
	
	/**
	 * Column Info
	 * @return dfltTaxRto
	 */
	public String getDfltTaxRto() {
		return this.dfltTaxRto;
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
	 * @return errMsg
	 */
	public String getErrMsg() {
		return this.errMsg;
	}
	
	/**
	 * Column Info
	 * @return mnlInpFlg
	 */
	public String getMnlInpFlg() {
		return this.mnlInpFlg;
	}
	
	/**
	 * Column Info
	 * @return dmdtArIfCd
	 */
	public String getDmdtArIfCd() {
		return this.dmdtArIfCd;
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
	 * @return custCntcPntSeq
	 */
	public String getCustCntcPntSeq() {
		return this.custCntcPntSeq;
	}
	
	/**
	 * Column Info
	 * @return mnlInvRmk
	 */
	public String getMnlInvRmk() {
		return this.mnlInvRmk;
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
	 * @return invRmk2
	 */
	public String getInvRmk2() {
		return this.invRmk2;
	}
	
	/**
	 * Column Info
	 * @return invRmk1
	 */
	public String getInvRmk1() {
		return this.invRmk1;
	}
	
	/**
	 * Column Info
	 * @return bilAmt
	 */
	public String getBilAmt() {
		return this.bilAmt;
	}
	
	/**
	 * Column Info
	 * @return payrCntcPntFaxNo
	 */
	public String getPayrCntcPntFaxNo() {
		return this.payrCntcPntFaxNo;
	}
	
	/**
	 * Column Info
	 * @return cxlRmk
	 */
	public String getCxlRmk() {
		return this.cxlRmk;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return crInvNo
	 */
	public String getCrInvNo() {
		return this.crInvNo;
	}
	
	/**
	 * Column Info
	 * @return invHldRmk
	 */
	public String getInvHldRmk() {
		return this.invHldRmk;
	}
	
	/**
	 * Column Info
	 * @return arIfUsrNm
	 */
	public String getArIfUsrNm() {
		return this.arIfUsrNm;
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
	 * @return invRefNo
	 */
	public String getInvRefNo() {
		return this.invRefNo;
	}
	
	/**
	 * Column Info
	 * @return creCntCd
	 */
	public String getCreCntCd() {
		return this.creCntCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtChgTpCd
	 */
	public String getDmdtChgTpCd() {
		return this.dmdtChgTpCd;
	}
	
	/**
	 * Column Info
	 * @return actPayrCustNm
	 */
	public String getActPayrCustNm() {
		return this.actPayrCustNm;
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
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return invCurrCd
	 */
	public String getInvCurrCd() {
		return this.invCurrCd;
	}
	
	/**
	 * Column Info
	 * @return bilToLocDivCd
	 */
	public String getBilToLocDivCd() {
		return this.bilToLocDivCd;
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
	 * @return payrCntcPntPhnNo
	 */
	public String getPayrCntcPntPhnNo() {
		return this.payrCntcPntPhnNo;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtMnlInvRsnNm
	 */
	public String getDmdtMnlInvRsnNm() {
		return this.dmdtMnlInvRsnNm;
	}
	
	/**
	 * Column Info
	 * @return actCustNm
	 */
	public String getActCustNm() {
		return this.actCustNm;
	}
	
	/**
	 * Column Info
	 * @return issueUsrNm
	 */
	public String getIssueUsrNm() {
		return this.issueUsrNm;
	}
	
	/**
	 * Column Info
	 * @return updUsrNm
	 */
	public String getUpdUsrNm() {
		return this.updUsrNm;
	}
	
	/**
	 * Column Info
	 * @return bkgCntrQty
	 */
	public String getBkgCntrQty() {
		return this.bkgCntrQty;
	}
	

	/**
	 * Column Info
	 * @param taxRto
	 */
	public void setTaxRto(String taxRto) {
		this.taxRto = taxRto;
	}
	
	/**
	 * Column Info
	 * @param invPrtFlg
	 */
	public void setInvPrtFlg(String invPrtFlg) {
		this.invPrtFlg = invPrtFlg;
	}
	
	/**
	 * Column Info
	 * @param invHldRsnNm
	 */
	public void setInvHldRsnNm(String invHldRsnNm) {
		this.invHldRsnNm = invHldRsnNm;
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
	 * @param chgCurrCd
	 */
	public void setChgCurrCd(String chgCurrCd) {
		this.chgCurrCd = chgCurrCd;
	}
	
	/**
	 * Column Info
	 * @param dcAmt
	 */
	public void setDcAmt(String dcAmt) {
		this.dcAmt = dcAmt;
	}
	
	/**
	 * Column Info
	 * @param bkgCustNm
	 */
	public void setBkgCustNm(String bkgCustNm) {
		this.bkgCustNm = bkgCustNm;
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
	 * @param aftInvAdjAmt
	 */
	public void setAftInvAdjAmt(String aftInvAdjAmt) {
		this.aftInvAdjAmt = aftInvAdjAmt;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
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
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param invXchRt
	 */
	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
	}
	
	/**
	 * Column Info
	 * @param aftExptAproNo
	 */
	public void setAftExptAproNo(String aftExptAproNo) {
		this.aftExptAproNo = aftExptAproNo;
	}
	
	/**
	 * Column Info
	 * @param ntcKntCd
	 */
	public void setNtcKntCd(String ntcKntCd) {
		this.ntcKntCd = ntcKntCd;
	}
	
	/**
	 * Column Info
	 * @param truckerCd
	 */
	public void setTruckerCd(String truckerCd) {
		this.truckerCd = truckerCd;
	}
	
	/**
	 * Column Info
	 * @param issueOfcCd
	 */
	public void setIssueOfcCd(String issueOfcCd) {
		this.issueOfcCd = issueOfcCd;
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
	 * @param payrCntcPntList
	 */
	public void setPayrCntcPntList(String payrCntcPntList) {
		this.payrCntcPntList = payrCntcPntList;
	}
	
	/**
	 * Column Info
	 * @param dmdtInvStsDesc
	 */
	public void setDmdtInvStsDesc(String dmdtInvStsDesc) {
		this.dmdtInvStsDesc = dmdtInvStsDesc;
	}
	
	/**
	 * Column Info
	 * @param actCustCd
	 */
	public void setActCustCd(String actCustCd) {
		this.actCustCd = actCustCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtPayrCntcPntNm
	 */
	public void setDmdtPayrCntcPntNm(String dmdtPayrCntcPntNm) {
		this.dmdtPayrCntcPntNm = dmdtPayrCntcPntNm;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param crArIfCd
	 */
	public void setCrArIfCd(String crArIfCd) {
		this.crArIfCd = crArIfCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtCxlRsnNm
	 */
	public void setDmdtCxlRsnNm(String dmdtCxlRsnNm) {
		this.dmdtCxlRsnNm = dmdtCxlRsnNm;
	}
	
	/**
	 * Column Info
	 * @param caller
	 */
	public void setCaller(String caller) {
		this.caller = caller;
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
	 * @param suthChnIssFlg
	 */
	public void setSuthChnIssFlg(String suthChnIssFlg) {
		this.suthChnIssFlg = suthChnIssFlg;
	}
	
	/**
	 * Column Info
	 * @param mnlInvSndFlg
	 */
	public void setMnlInvSndFlg(String mnlInvSndFlg) {
		this.mnlInvSndFlg = mnlInvSndFlg;
	}
	
	/**
	 * Column Info
	 * @param actPayrCntCd
	 */
	public void setActPayrCntCd(String actPayrCntCd) {
		this.actPayrCntCd = actPayrCntCd;
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
	 * @param arIfNo
	 */
	public void setArIfNo(String arIfNo) {
		this.arIfNo = arIfNo;
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
	 * @param issueDt
	 */
	public void setIssueDt(String issueDt) {
		this.issueDt = issueDt;
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
	 * @param dmdtInvStsCd
	 */
	public void setDmdtInvStsCd(String dmdtInvStsCd) {
		this.dmdtInvStsCd = dmdtInvStsCd;
	}
	
	/**
	 * Column Info
	 * @param payrCntcPntEml
	 */
	public void setPayrCntcPntEml(String payrCntcPntEml) {
		this.payrCntcPntEml = payrCntcPntEml;
	}
	
	/**
	 * Column Info
	 * @param invChgAmt
	 */
	public void setInvChgAmt(String invChgAmt) {
		this.invChgAmt = invChgAmt;
	}
	
	/**
	 * Column Info
	 * @param dmdtInvNo
	 */
	public void setDmdtInvNo(String dmdtInvNo) {
		this.dmdtInvNo = dmdtInvNo;
	}
	
	/**
	 * Column Info
	 * @param arIfUsrId
	 */
	public void setArIfUsrId(String arIfUsrId) {
		this.arIfUsrId = arIfUsrId;
	}
	
	/**
	 * Column Info
	 * @param actPayrSeq
	 */
	public void setActPayrSeq(String actPayrSeq) {
		this.actPayrSeq = actPayrSeq;
	}
	
	/**
	 * Column Info
	 * @param issDtPrnFlg
	 */
	public void setIssDtPrnFlg(String issDtPrnFlg) {
		this.issDtPrnFlg = issDtPrnFlg;
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
	 * @param invHldRsnCd
	 */
	public void setInvHldRsnCd(String invHldRsnCd) {
		this.invHldRsnCd = invHldRsnCd;
	}
	
	/**
	 * Column Info
	 * @param actPayrCustCd
	 */
	public void setActPayrCustCd(String actPayrCustCd) {
		this.actPayrCustCd = actPayrCustCd;
	}
	
	/**
	 * Column Info
	 * @param orgChgAmt
	 */
	public void setOrgChgAmt(String orgChgAmt) {
		this.orgChgAmt = orgChgAmt;
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
	 * @param oldDmdtInvNo
	 */
	public void setOldDmdtInvNo(String oldDmdtInvNo) {
		this.oldDmdtInvNo = oldDmdtInvNo;
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
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
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
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param dmdtExptAmt
	 */
	public void setDmdtExptAmt(String dmdtExptAmt) {
		this.dmdtExptAmt = dmdtExptAmt;
	}
	
	/**
	 * Column Info
	 * @param arIfDt
	 */
	public void setArIfDt(String arIfDt) {
		this.arIfDt = arIfDt;
	}
	
	/**
	 * Column Info
	 * @param bkgCustCd
	 */
	public void setBkgCustCd(String bkgCustCd) {
		this.bkgCustCd = bkgCustCd;
	}
	
	/**
	 * Column Info
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
	}
	
	/**
	 * Column Info
	 * @param truckerNm
	 */
	public void setTruckerNm(String truckerNm) {
		this.truckerNm = truckerNm;
	}
	
	/**
	 * Column Info
	 * @param dmdtPayrTpCd
	 */
	public void setDmdtPayrTpCd(String dmdtPayrTpCd) {
		this.dmdtPayrTpCd = dmdtPayrTpCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtMnlInvRsnCd
	 */
	public void setDmdtMnlInvRsnCd(String dmdtMnlInvRsnCd) {
		this.dmdtMnlInvRsnCd = dmdtMnlInvRsnCd;
	}
	
	/**
	 * Column Info
	 * @param errCode
	 */
	public void setErrCode(String errCode) {
		this.errCode = errCode;
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
	 * @param arIfOfcCd
	 */
	public void setArIfOfcCd(String arIfOfcCd) {
		this.arIfOfcCd = arIfOfcCd;
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
	 * @param dmdtCxlRsnCd
	 */
	public void setDmdtCxlRsnCd(String dmdtCxlRsnCd) {
		this.dmdtCxlRsnCd = dmdtCxlRsnCd;
	}
	
	/**
	 * Column Info
	 * @param dfltTaxRto
	 */
	public void setDfltTaxRto(String dfltTaxRto) {
		this.dfltTaxRto = dfltTaxRto;
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
	 * @param errMsg
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	/**
	 * Column Info
	 * @param mnlInpFlg
	 */
	public void setMnlInpFlg(String mnlInpFlg) {
		this.mnlInpFlg = mnlInpFlg;
	}
	
	/**
	 * Column Info
	 * @param dmdtArIfCd
	 */
	public void setDmdtArIfCd(String dmdtArIfCd) {
		this.dmdtArIfCd = dmdtArIfCd;
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
	 * @param custCntcPntSeq
	 */
	public void setCustCntcPntSeq(String custCntcPntSeq) {
		this.custCntcPntSeq = custCntcPntSeq;
	}
	
	/**
	 * Column Info
	 * @param mnlInvRmk
	 */
	public void setMnlInvRmk(String mnlInvRmk) {
		this.mnlInvRmk = mnlInvRmk;
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
	 * @param invRmk2
	 */
	public void setInvRmk2(String invRmk2) {
		this.invRmk2 = invRmk2;
	}
	
	/**
	 * Column Info
	 * @param invRmk1
	 */
	public void setInvRmk1(String invRmk1) {
		this.invRmk1 = invRmk1;
	}
	
	/**
	 * Column Info
	 * @param bilAmt
	 */
	public void setBilAmt(String bilAmt) {
		this.bilAmt = bilAmt;
	}
	
	/**
	 * Column Info
	 * @param payrCntcPntFaxNo
	 */
	public void setPayrCntcPntFaxNo(String payrCntcPntFaxNo) {
		this.payrCntcPntFaxNo = payrCntcPntFaxNo;
	}
	
	/**
	 * Column Info
	 * @param cxlRmk
	 */
	public void setCxlRmk(String cxlRmk) {
		this.cxlRmk = cxlRmk;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param crInvNo
	 */
	public void setCrInvNo(String crInvNo) {
		this.crInvNo = crInvNo;
	}
	
	/**
	 * Column Info
	 * @param invHldRmk
	 */
	public void setInvHldRmk(String invHldRmk) {
		this.invHldRmk = invHldRmk;
	}
	
	/**
	 * Column Info
	 * @param arIfUsrNm
	 */
	public void setArIfUsrNm(String arIfUsrNm) {
		this.arIfUsrNm = arIfUsrNm;
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
	 * @param invRefNo
	 */
	public void setInvRefNo(String invRefNo) {
		this.invRefNo = invRefNo;
	}
	
	/**
	 * Column Info
	 * @param creCntCd
	 */
	public void setCreCntCd(String creCntCd) {
		this.creCntCd = creCntCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtChgTpCd
	 */
	public void setDmdtChgTpCd(String dmdtChgTpCd) {
		this.dmdtChgTpCd = dmdtChgTpCd;
	}
	
	/**
	 * Column Info
	 * @param actPayrCustNm
	 */
	public void setActPayrCustNm(String actPayrCustNm) {
		this.actPayrCustNm = actPayrCustNm;
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
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param invCurrCd
	 */
	public void setInvCurrCd(String invCurrCd) {
		this.invCurrCd = invCurrCd;
	}
	
	/**
	 * Column Info
	 * @param bilToLocDivCd
	 */
	public void setBilToLocDivCd(String bilToLocDivCd) {
		this.bilToLocDivCd = bilToLocDivCd;
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
	 * @param payrCntcPntPhnNo
	 */
	public void setPayrCntcPntPhnNo(String payrCntcPntPhnNo) {
		this.payrCntcPntPhnNo = payrCntcPntPhnNo;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtMnlInvRsnNm
	 */
	public void setDmdtMnlInvRsnNm(String dmdtMnlInvRsnNm) {
		this.dmdtMnlInvRsnNm = dmdtMnlInvRsnNm;
	}
	
	/**
	 * Column Info
	 * @param actCustNm
	 */
	public void setActCustNm(String actCustNm) {
		this.actCustNm = actCustNm;
	}
	
	/**
	 * Column Info
	 * @param issueUsrNm
	 */
	public void setIssueUsrNm(String issueUsrNm) {
		this.issueUsrNm = issueUsrNm;
	}
	
	/**
	 * Column Info
	 * @param updUsrNm
	 */
	public void setUpdUsrNm(String updUsrNm) {
		this.updUsrNm = updUsrNm;
	}
	
	/**
	 * Column Info
	 * @param bkgCntrQty
	 */
	public void setBkgCntrQty(String bkgCntrQty) {
		this.bkgCntrQty = bkgCntrQty;
	}
	
	/**
	 * Column Info
	 * @return idaHighEduTaxRt
	 */
	public String getIdaHighEduTaxRt() {
		return this.idaHighEduTaxRt;
	}
	
	/**
	 * Column Info
	 * @return idaExpnTaxRt
	 */
	public String getIdaExpnTaxRt() {
		return this.idaExpnTaxRt;
	}
	
	/**
	 * Column Info
	 * @return idaExpnTax
	 */
	public String getIdaExpnTax() {
		return this.idaExpnTax;
	}
	
	/**
	 * Column Info
	 * @return idaEduTax
	 */
	public String getIdaEduTax() {
		return this.idaEduTax;
	}
	
	/**
	 * Column Info
	 * @return idaHighEduTax
	 */
	public String getIdaHighEduTax() {
		return this.idaHighEduTax;
	}
	
	/**
	 * Column Info
	 * @return idaEduTaxRt
	 */
	public String getIdaEduTaxRt() {
		return this.idaEduTaxRt;
	}
	
	/**
	 * Column Info
	 * @param idaHighEduTaxRt
	 */
	public void setIdaHighEduTaxRt(String idaHighEduTaxRt) {
		this.idaHighEduTaxRt = idaHighEduTaxRt;
	}
	
	/**
	 * Column Info
	 * @param idaExpnTaxRt
	 */
	public void setIdaExpnTaxRt(String idaExpnTaxRt) {
		this.idaExpnTaxRt = idaExpnTaxRt;
	}
	
	/**
	 * Column Info
	 * @param idaExpnTax
	 */
	public void setIdaExpnTax(String idaExpnTax) {
		this.idaExpnTax = idaExpnTax;
	}
	
	/**
	 * Column Info
	 * @param idaEduTax
	 */
	public void setIdaEduTax(String idaEduTax) {
		this.idaEduTax = idaEduTax;
	}
	
	/**
	 * Column Info
	 * @param idaHighEduTax
	 */
	public void setIdaHighEduTax(String idaHighEduTax) {
		this.idaHighEduTax = idaHighEduTax;
	}
	
	/**
	 * Column Info
	 * @param idaEduTaxRt
	 */
	public void setIdaEduTaxRt(String idaEduTaxRt) {
		this.idaEduTaxRt = idaEduTaxRt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTaxRto(JSPUtil.getParameter(request, "tax_rto", ""));
		setInvPrtFlg(JSPUtil.getParameter(request, "inv_prt_flg", ""));
		setInvHldRsnNm(JSPUtil.getParameter(request, "inv_hld_rsn_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setChgCurrCd(JSPUtil.getParameter(request, "chg_curr_cd", ""));
		setDcAmt(JSPUtil.getParameter(request, "dc_amt", ""));
		setBkgCustNm(JSPUtil.getParameter(request, "bkg_cust_nm", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setAftInvAdjAmt(JSPUtil.getParameter(request, "aft_inv_adj_amt", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setInvXchRt(JSPUtil.getParameter(request, "inv_xch_rt", ""));
		setAftExptAproNo(JSPUtil.getParameter(request, "aft_expt_apro_no", ""));
		setNtcKntCd(JSPUtil.getParameter(request, "ntc_knt_cd", ""));
		setTruckerCd(JSPUtil.getParameter(request, "trucker_cd", ""));
		setIssueOfcCd(JSPUtil.getParameter(request, "issue_ofc_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setPayrCntcPntList(JSPUtil.getParameter(request, "payr_cntc_pnt_list", ""));
		setDmdtInvStsDesc(JSPUtil.getParameter(request, "dmdt_inv_sts_desc", ""));
		setActCustCd(JSPUtil.getParameter(request, "act_cust_cd", ""));
		setDmdtPayrCntcPntNm(JSPUtil.getParameter(request, "dmdt_payr_cntc_pnt_nm", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCrArIfCd(JSPUtil.getParameter(request, "cr_ar_if_cd", ""));
		setDmdtCxlRsnNm(JSPUtil.getParameter(request, "dmdt_cxl_rsn_nm", ""));
		setCaller(JSPUtil.getParameter(request, "caller", ""));
		setTotAmt(JSPUtil.getParameter(request, "tot_amt", ""));
		setSuthChnIssFlg(JSPUtil.getParameter(request, "suth_chn_iss_flg", ""));
		setMnlInvSndFlg(JSPUtil.getParameter(request, "mnl_inv_snd_flg", ""));
		setActPayrCntCd(JSPUtil.getParameter(request, "act_payr_cnt_cd", ""));
		setTaxAmt(JSPUtil.getParameter(request, "tax_amt", ""));
		setArIfNo(JSPUtil.getParameter(request, "ar_if_no", ""));
		setDueDt(JSPUtil.getParameter(request, "due_dt", ""));
		setIssueDt(JSPUtil.getParameter(request, "issue_dt", ""));
		setCrTermDys(JSPUtil.getParameter(request, "cr_term_dys", ""));
		setDmdtInvStsCd(JSPUtil.getParameter(request, "dmdt_inv_sts_cd", ""));
		setPayrCntcPntEml(JSPUtil.getParameter(request, "payr_cntc_pnt_eml", ""));
		setInvChgAmt(JSPUtil.getParameter(request, "inv_chg_amt", ""));
		setDmdtInvNo(JSPUtil.getParameter(request, "dmdt_inv_no", ""));
		setArIfUsrId(JSPUtil.getParameter(request, "ar_if_usr_id", ""));
		setActPayrSeq(JSPUtil.getParameter(request, "act_payr_seq", ""));
		setIssDtPrnFlg(JSPUtil.getParameter(request, "iss_dt_prn_flg", ""));
		setInvRmk(JSPUtil.getParameter(request, "inv_rmk", ""));
		setInvHldRsnCd(JSPUtil.getParameter(request, "inv_hld_rsn_cd", ""));
		setActPayrCustCd(JSPUtil.getParameter(request, "act_payr_cust_cd", ""));
		setOrgChgAmt(JSPUtil.getParameter(request, "org_chg_amt", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setOldDmdtInvNo(JSPUtil.getParameter(request, "old_dmdt_inv_no", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setVndrNm(JSPUtil.getParameter(request, "vndr_nm", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setDmdtExptAmt(JSPUtil.getParameter(request, "dmdt_expt_amt", ""));
		setArIfDt(JSPUtil.getParameter(request, "ar_if_dt", ""));
		setBkgCustCd(JSPUtil.getParameter(request, "bkg_cust_cd", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, "upd_ofc_cd", ""));
		setTruckerNm(JSPUtil.getParameter(request, "trucker_nm", ""));
		setDmdtPayrTpCd(JSPUtil.getParameter(request, "dmdt_payr_tp_cd", ""));
		setDmdtMnlInvRsnCd(JSPUtil.getParameter(request, "dmdt_mnl_inv_rsn_cd", ""));
		setErrCode(JSPUtil.getParameter(request, "err_code", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setArIfOfcCd(JSPUtil.getParameter(request, "ar_if_ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setDmdtCxlRsnCd(JSPUtil.getParameter(request, "dmdt_cxl_rsn_cd", ""));
		setDfltTaxRto(JSPUtil.getParameter(request, "dflt_tax_rto", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setErrMsg(JSPUtil.getParameter(request, "err_msg", ""));
		setMnlInpFlg(JSPUtil.getParameter(request, "mnl_inp_flg", ""));
		setDmdtArIfCd(JSPUtil.getParameter(request, "dmdt_ar_if_cd", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setCustCntcPntSeq(JSPUtil.getParameter(request, "cust_cntc_pnt_seq", ""));
		setMnlInvRmk(JSPUtil.getParameter(request, "mnl_inv_rmk", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setInvRmk2(JSPUtil.getParameter(request, "inv_rmk2", ""));
		setInvRmk1(JSPUtil.getParameter(request, "inv_rmk1", ""));
		setBilAmt(JSPUtil.getParameter(request, "bil_amt", ""));
		setPayrCntcPntFaxNo(JSPUtil.getParameter(request, "payr_cntc_pnt_fax_no", ""));
		setCxlRmk(JSPUtil.getParameter(request, "cxl_rmk", ""));
		setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setInvAmt(JSPUtil.getParameter(request, "inv_amt", ""));
		setRcvTermCd(JSPUtil.getParameter(request, "rcv_term_cd", ""));
		setCrInvNo(JSPUtil.getParameter(request, "cr_inv_no", ""));
		setInvHldRmk(JSPUtil.getParameter(request, "inv_hld_rmk", ""));
		setArIfUsrNm(JSPUtil.getParameter(request, "ar_if_usr_nm", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setInvRefNo(JSPUtil.getParameter(request, "inv_ref_no", ""));
		setCreCntCd(JSPUtil.getParameter(request, "cre_cnt_cd", ""));
		setDmdtChgTpCd(JSPUtil.getParameter(request, "dmdt_chg_tp_cd", ""));
		setActPayrCustNm(JSPUtil.getParameter(request, "act_payr_cust_nm", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setInvCurrCd(JSPUtil.getParameter(request, "inv_curr_cd", ""));
		setBilToLocDivCd(JSPUtil.getParameter(request, "bil_to_loc_div_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPayrCntcPntPhnNo(JSPUtil.getParameter(request, "payr_cntc_pnt_phn_no", ""));
		setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
		setDmdtMnlInvRsnNm(JSPUtil.getParameter(request, "dmdt_mnl_inv_rsn_nm", ""));
		setActCustNm(JSPUtil.getParameter(request, "act_cust_nm", ""));
		setIssueUsrNm(JSPUtil.getParameter(request, "issue_usr_nm", ""));
		setUpdUsrNm(JSPUtil.getParameter(request, "upd_usr_nm", ""));
		setBkgCntrQty(JSPUtil.getParameter(request, "bkg_cntr_qty", ""));
		setIdaHighEduTaxRt(JSPUtil.getParameter(request, "ida_high_edu_tax_rt", ""));
		setIdaExpnTaxRt(JSPUtil.getParameter(request, "ida_expn_tax_rt", ""));
		setIdaExpnTax(JSPUtil.getParameter(request, "ida_expn_tax", ""));
		setIdaEduTax(JSPUtil.getParameter(request, "ida_edu_tax", ""));
		setIdaHighEduTax(JSPUtil.getParameter(request, "ida_high_edu_tax", ""));
		setIdaEduTaxRt(JSPUtil.getParameter(request, "ida_edu_tax_rt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DmtInvMnVO[]
	 */
	public DmtInvMnVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DmtInvMnVO[]
	 */
	public DmtInvMnVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DmtInvMnVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] taxRto = (JSPUtil.getParameter(request, prefix	+ "tax_rto", length));
			String[] invPrtFlg = (JSPUtil.getParameter(request, prefix	+ "inv_prt_flg", length));
			String[] invHldRsnNm = (JSPUtil.getParameter(request, prefix	+ "inv_hld_rsn_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] chgCurrCd = (JSPUtil.getParameter(request, prefix	+ "chg_curr_cd", length));
			String[] dcAmt = (JSPUtil.getParameter(request, prefix	+ "dc_amt", length));
			String[] bkgCustNm = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_nm", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] aftInvAdjAmt = (JSPUtil.getParameter(request, prefix	+ "aft_inv_adj_amt", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] aftExptAproNo = (JSPUtil.getParameter(request, prefix	+ "aft_expt_apro_no", length));
			String[] ntcKntCd = (JSPUtil.getParameter(request, prefix	+ "ntc_knt_cd", length));
			String[] truckerCd = (JSPUtil.getParameter(request, prefix	+ "trucker_cd", length));
			String[] issueOfcCd = (JSPUtil.getParameter(request, prefix	+ "issue_ofc_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] payrCntcPntList = (JSPUtil.getParameter(request, prefix	+ "payr_cntc_pnt_list", length));
			String[] dmdtInvStsDesc = (JSPUtil.getParameter(request, prefix	+ "dmdt_inv_sts_desc", length));
			String[] actCustCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cd", length));
			String[] dmdtPayrCntcPntNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_payr_cntc_pnt_nm", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] crArIfCd = (JSPUtil.getParameter(request, prefix	+ "cr_ar_if_cd", length));
			String[] dmdtCxlRsnNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_cxl_rsn_nm", length));
			String[] caller = (JSPUtil.getParameter(request, prefix	+ "caller", length));
			String[] totAmt = (JSPUtil.getParameter(request, prefix	+ "tot_amt", length));
			String[] suthChnIssFlg = (JSPUtil.getParameter(request, prefix	+ "suth_chn_iss_flg", length));
			String[] mnlInvSndFlg = (JSPUtil.getParameter(request, prefix	+ "mnl_inv_snd_flg", length));
			String[] actPayrCntCd = (JSPUtil.getParameter(request, prefix	+ "act_payr_cnt_cd", length));
			String[] taxAmt = (JSPUtil.getParameter(request, prefix	+ "tax_amt", length));
			String[] arIfNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_no", length));
			String[] dueDt = (JSPUtil.getParameter(request, prefix	+ "due_dt", length));
			String[] issueDt = (JSPUtil.getParameter(request, prefix	+ "issue_dt", length));
			String[] crTermDys = (JSPUtil.getParameter(request, prefix	+ "cr_term_dys", length));
			String[] dmdtInvStsCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_inv_sts_cd", length));
			String[] payrCntcPntEml = (JSPUtil.getParameter(request, prefix	+ "payr_cntc_pnt_eml", length));
			String[] invChgAmt = (JSPUtil.getParameter(request, prefix	+ "inv_chg_amt", length));
			String[] dmdtInvNo = (JSPUtil.getParameter(request, prefix	+ "dmdt_inv_no", length));
			String[] arIfUsrId = (JSPUtil.getParameter(request, prefix	+ "ar_if_usr_id", length));
			String[] actPayrSeq = (JSPUtil.getParameter(request, prefix	+ "act_payr_seq", length));
			String[] issDtPrnFlg = (JSPUtil.getParameter(request, prefix	+ "iss_dt_prn_flg", length));
			String[] invRmk = (JSPUtil.getParameter(request, prefix	+ "inv_rmk", length));
			String[] invHldRsnCd = (JSPUtil.getParameter(request, prefix	+ "inv_hld_rsn_cd", length));
			String[] actPayrCustCd = (JSPUtil.getParameter(request, prefix	+ "act_payr_cust_cd", length));
			String[] orgChgAmt = (JSPUtil.getParameter(request, prefix	+ "org_chg_amt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] oldDmdtInvNo = (JSPUtil.getParameter(request, prefix	+ "old_dmdt_inv_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] dmdtExptAmt = (JSPUtil.getParameter(request, prefix	+ "dmdt_expt_amt", length));
			String[] arIfDt = (JSPUtil.getParameter(request, prefix	+ "ar_if_dt", length));
			String[] bkgCustCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_cd", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] truckerNm = (JSPUtil.getParameter(request, prefix	+ "trucker_nm", length));
			String[] dmdtPayrTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_payr_tp_cd", length));
			String[] dmdtMnlInvRsnCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_mnl_inv_rsn_cd", length));
			String[] errCode = (JSPUtil.getParameter(request, prefix	+ "err_code", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] arIfOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_if_ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] dmdtCxlRsnCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_cxl_rsn_cd", length));
			String[] dfltTaxRto = (JSPUtil.getParameter(request, prefix	+ "dflt_tax_rto", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] errMsg = (JSPUtil.getParameter(request, prefix	+ "err_msg", length));
			String[] mnlInpFlg = (JSPUtil.getParameter(request, prefix	+ "mnl_inp_flg", length));
			String[] dmdtArIfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_ar_if_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] custCntcPntSeq = (JSPUtil.getParameter(request, prefix	+ "cust_cntc_pnt_seq", length));
			String[] mnlInvRmk = (JSPUtil.getParameter(request, prefix	+ "mnl_inv_rmk", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] invRmk2 = (JSPUtil.getParameter(request, prefix	+ "inv_rmk2", length));
			String[] invRmk1 = (JSPUtil.getParameter(request, prefix	+ "inv_rmk1", length));
			String[] bilAmt = (JSPUtil.getParameter(request, prefix	+ "bil_amt", length));
			String[] payrCntcPntFaxNo = (JSPUtil.getParameter(request, prefix	+ "payr_cntc_pnt_fax_no", length));
			String[] cxlRmk = (JSPUtil.getParameter(request, prefix	+ "cxl_rmk", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] crInvNo = (JSPUtil.getParameter(request, prefix	+ "cr_inv_no", length));
			String[] invHldRmk = (JSPUtil.getParameter(request, prefix	+ "inv_hld_rmk", length));
			String[] arIfUsrNm = (JSPUtil.getParameter(request, prefix	+ "ar_if_usr_nm", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] invRefNo = (JSPUtil.getParameter(request, prefix	+ "inv_ref_no", length));
			String[] creCntCd = (JSPUtil.getParameter(request, prefix	+ "cre_cnt_cd", length));
			String[] dmdtChgTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_tp_cd", length));
			String[] actPayrCustNm = (JSPUtil.getParameter(request, prefix	+ "act_payr_cust_nm", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] invCurrCd = (JSPUtil.getParameter(request, prefix	+ "inv_curr_cd", length));
			String[] bilToLocDivCd = (JSPUtil.getParameter(request, prefix	+ "bil_to_loc_div_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] payrCntcPntPhnNo = (JSPUtil.getParameter(request, prefix	+ "payr_cntc_pnt_phn_no", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] dmdtMnlInvRsnNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_mnl_inv_rsn_nm", length));
			String[] actCustNm = (JSPUtil.getParameter(request, prefix	+ "act_cust_nm", length));
			String[] issueUsrNm = (JSPUtil.getParameter(request, prefix	+ "issue_usr_nm", length));
			String[] updUsrNm = (JSPUtil.getParameter(request, prefix	+ "upd_usr_nm", length));
			String[] bkgCntrQty = (JSPUtil.getParameter(request, prefix	+ "bkg_cntr_qty", length));
			String[] idaHighEduTaxRt = (JSPUtil.getParameter(request, prefix	+ "ida_high_edu_tax_rt", length));
			String[] idaExpnTaxRt = (JSPUtil.getParameter(request, prefix	+ "ida_expn_tax_rt", length));
			String[] idaExpnTax = (JSPUtil.getParameter(request, prefix	+ "ida_expn_tax", length));
			String[] idaEduTax = (JSPUtil.getParameter(request, prefix	+ "ida_edu_tax", length));
			String[] idaHighEduTax = (JSPUtil.getParameter(request, prefix	+ "ida_high_edu_tax", length));
			String[] idaEduTaxRt = (JSPUtil.getParameter(request, prefix	+ "ida_edu_tax_rt", length));
			
			for (int i = 0; i < length; i++) {
				model = new DmtInvMnVO();
				if (taxRto[i] != null)
					model.setTaxRto(taxRto[i]);
				if (invPrtFlg[i] != null)
					model.setInvPrtFlg(invPrtFlg[i]);
				if (invHldRsnNm[i] != null)
					model.setInvHldRsnNm(invHldRsnNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (chgCurrCd[i] != null)
					model.setChgCurrCd(chgCurrCd[i]);
				if (dcAmt[i] != null)
					model.setDcAmt(dcAmt[i]);
				if (bkgCustNm[i] != null)
					model.setBkgCustNm(bkgCustNm[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (aftInvAdjAmt[i] != null)
					model.setAftInvAdjAmt(aftInvAdjAmt[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (aftExptAproNo[i] != null)
					model.setAftExptAproNo(aftExptAproNo[i]);
				if (ntcKntCd[i] != null)
					model.setNtcKntCd(ntcKntCd[i]);
				if (truckerCd[i] != null)
					model.setTruckerCd(truckerCd[i]);
				if (issueOfcCd[i] != null)
					model.setIssueOfcCd(issueOfcCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (payrCntcPntList[i] != null)
					model.setPayrCntcPntList(payrCntcPntList[i]);
				if (dmdtInvStsDesc[i] != null)
					model.setDmdtInvStsDesc(dmdtInvStsDesc[i]);
				if (actCustCd[i] != null)
					model.setActCustCd(actCustCd[i]);
				if (dmdtPayrCntcPntNm[i] != null)
					model.setDmdtPayrCntcPntNm(dmdtPayrCntcPntNm[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (crArIfCd[i] != null)
					model.setCrArIfCd(crArIfCd[i]);
				if (dmdtCxlRsnNm[i] != null)
					model.setDmdtCxlRsnNm(dmdtCxlRsnNm[i]);
				if (caller[i] != null)
					model.setCaller(caller[i]);
				if (totAmt[i] != null)
					model.setTotAmt(totAmt[i]);
				if (suthChnIssFlg[i] != null)
					model.setSuthChnIssFlg(suthChnIssFlg[i]);
				if (mnlInvSndFlg[i] != null)
					model.setMnlInvSndFlg(mnlInvSndFlg[i]);
				if (actPayrCntCd[i] != null)
					model.setActPayrCntCd(actPayrCntCd[i]);
				if (taxAmt[i] != null)
					model.setTaxAmt(taxAmt[i]);
				if (arIfNo[i] != null)
					model.setArIfNo(arIfNo[i]);
				if (dueDt[i] != null)
					model.setDueDt(dueDt[i]);
				if (issueDt[i] != null)
					model.setIssueDt(issueDt[i]);
				if (crTermDys[i] != null)
					model.setCrTermDys(crTermDys[i]);
				if (dmdtInvStsCd[i] != null)
					model.setDmdtInvStsCd(dmdtInvStsCd[i]);
				if (payrCntcPntEml[i] != null)
					model.setPayrCntcPntEml(payrCntcPntEml[i]);
				if (invChgAmt[i] != null)
					model.setInvChgAmt(invChgAmt[i]);
				if (dmdtInvNo[i] != null)
					model.setDmdtInvNo(dmdtInvNo[i]);
				if (arIfUsrId[i] != null)
					model.setArIfUsrId(arIfUsrId[i]);
				if (actPayrSeq[i] != null)
					model.setActPayrSeq(actPayrSeq[i]);
				if (issDtPrnFlg[i] != null)
					model.setIssDtPrnFlg(issDtPrnFlg[i]);
				if (invRmk[i] != null)
					model.setInvRmk(invRmk[i]);
				if (invHldRsnCd[i] != null)
					model.setInvHldRsnCd(invHldRsnCd[i]);
				if (actPayrCustCd[i] != null)
					model.setActPayrCustCd(actPayrCustCd[i]);
				if (orgChgAmt[i] != null)
					model.setOrgChgAmt(orgChgAmt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (oldDmdtInvNo[i] != null)
					model.setOldDmdtInvNo(oldDmdtInvNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (dmdtExptAmt[i] != null)
					model.setDmdtExptAmt(dmdtExptAmt[i]);
				if (arIfDt[i] != null)
					model.setArIfDt(arIfDt[i]);
				if (bkgCustCd[i] != null)
					model.setBkgCustCd(bkgCustCd[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (truckerNm[i] != null)
					model.setTruckerNm(truckerNm[i]);
				if (dmdtPayrTpCd[i] != null)
					model.setDmdtPayrTpCd(dmdtPayrTpCd[i]);
				if (dmdtMnlInvRsnCd[i] != null)
					model.setDmdtMnlInvRsnCd(dmdtMnlInvRsnCd[i]);
				if (errCode[i] != null)
					model.setErrCode(errCode[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (arIfOfcCd[i] != null)
					model.setArIfOfcCd(arIfOfcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (dmdtCxlRsnCd[i] != null)
					model.setDmdtCxlRsnCd(dmdtCxlRsnCd[i]);
				if (dfltTaxRto[i] != null)
					model.setDfltTaxRto(dfltTaxRto[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (errMsg[i] != null)
					model.setErrMsg(errMsg[i]);
				if (mnlInpFlg[i] != null)
					model.setMnlInpFlg(mnlInpFlg[i]);
				if (dmdtArIfCd[i] != null)
					model.setDmdtArIfCd(dmdtArIfCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (custCntcPntSeq[i] != null)
					model.setCustCntcPntSeq(custCntcPntSeq[i]);
				if (mnlInvRmk[i] != null)
					model.setMnlInvRmk(mnlInvRmk[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (invRmk2[i] != null)
					model.setInvRmk2(invRmk2[i]);
				if (invRmk1[i] != null)
					model.setInvRmk1(invRmk1[i]);
				if (bilAmt[i] != null)
					model.setBilAmt(bilAmt[i]);
				if (payrCntcPntFaxNo[i] != null)
					model.setPayrCntcPntFaxNo(payrCntcPntFaxNo[i]);
				if (cxlRmk[i] != null)
					model.setCxlRmk(cxlRmk[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (crInvNo[i] != null)
					model.setCrInvNo(crInvNo[i]);
				if (invHldRmk[i] != null)
					model.setInvHldRmk(invHldRmk[i]);
				if (arIfUsrNm[i] != null)
					model.setArIfUsrNm(arIfUsrNm[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (invRefNo[i] != null)
					model.setInvRefNo(invRefNo[i]);
				if (creCntCd[i] != null)
					model.setCreCntCd(creCntCd[i]);
				if (dmdtChgTpCd[i] != null)
					model.setDmdtChgTpCd(dmdtChgTpCd[i]);
				if (actPayrCustNm[i] != null)
					model.setActPayrCustNm(actPayrCustNm[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (invCurrCd[i] != null)
					model.setInvCurrCd(invCurrCd[i]);
				if (bilToLocDivCd[i] != null)
					model.setBilToLocDivCd(bilToLocDivCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (payrCntcPntPhnNo[i] != null)
					model.setPayrCntcPntPhnNo(payrCntcPntPhnNo[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (dmdtMnlInvRsnNm[i] != null)
					model.setDmdtMnlInvRsnNm(dmdtMnlInvRsnNm[i]);
				if (actCustNm[i] != null)
					model.setActCustNm(actCustNm[i]);
				if (issueUsrNm[i] != null)
					model.setIssueUsrNm(issueUsrNm[i]);
				if (updUsrNm[i] != null)
					model.setUpdUsrNm(updUsrNm[i]);
				if (bkgCntrQty[i] != null)
					model.setBkgCntrQty(bkgCntrQty[i]);
				if (idaHighEduTaxRt[i] != null)
					model.setIdaHighEduTaxRt(idaHighEduTaxRt[i]);
				if (idaExpnTaxRt[i] != null)
					model.setIdaExpnTaxRt(idaExpnTaxRt[i]);
				if (idaExpnTax[i] != null)
					model.setIdaExpnTax(idaExpnTax[i]);
				if (idaEduTax[i] != null)
					model.setIdaEduTax(idaEduTax[i]);
				if (idaHighEduTax[i] != null)
					model.setIdaHighEduTax(idaHighEduTax[i]);
				if (idaEduTaxRt[i] != null)
					model.setIdaEduTaxRt(idaEduTaxRt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDmtInvMnVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DmtInvMnVO[]
	 */
	public DmtInvMnVO[] getDmtInvMnVOs(){
		DmtInvMnVO[] vos = (DmtInvMnVO[])models.toArray(new DmtInvMnVO[models.size()]);
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
		this.taxRto = this.taxRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invPrtFlg = this.invPrtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invHldRsnNm = this.invHldRsnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCurrCd = this.chgCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcAmt = this.dcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustNm = this.bkgCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftInvAdjAmt = this.aftInvAdjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptAproNo = this.aftExptAproNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcKntCd = this.ntcKntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.truckerCd = this.truckerCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issueOfcCd = this.issueOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payrCntcPntList = this.payrCntcPntList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtInvStsDesc = this.dmdtInvStsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCd = this.actCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtPayrCntcPntNm = this.dmdtPayrCntcPntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crArIfCd = this.crArIfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCxlRsnNm = this.dmdtCxlRsnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caller = this.caller .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totAmt = this.totAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.suthChnIssFlg = this.suthChnIssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlInvSndFlg = this.mnlInvSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actPayrCntCd = this.actPayrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxAmt = this.taxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo = this.arIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt = this.dueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issueDt = this.issueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crTermDys = this.crTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtInvStsCd = this.dmdtInvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payrCntcPntEml = this.payrCntcPntEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invChgAmt = this.invChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtInvNo = this.dmdtInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfUsrId = this.arIfUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actPayrSeq = this.actPayrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDtPrnFlg = this.issDtPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRmk = this.invRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invHldRsnCd = this.invHldRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actPayrCustCd = this.actPayrCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgChgAmt = this.orgChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldDmdtInvNo = this.oldDmdtInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtExptAmt = this.dmdtExptAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfDt = this.arIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustCd = this.bkgCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.truckerNm = this.truckerNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtPayrTpCd = this.dmdtPayrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtMnlInvRsnCd = this.dmdtMnlInvRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errCode = this.errCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfOfcCd = this.arIfOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCxlRsnCd = this.dmdtCxlRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltTaxRto = this.dfltTaxRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errMsg = this.errMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlInpFlg = this.mnlInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtArIfCd = this.dmdtArIfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntcPntSeq = this.custCntcPntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlInvRmk = this.mnlInvRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRmk2 = this.invRmk2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRmk1 = this.invRmk1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilAmt = this.bilAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payrCntcPntFaxNo = this.payrCntcPntFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlRmk = this.cxlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crInvNo = this.crInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invHldRmk = this.invHldRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfUsrNm = this.arIfUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRefNo = this.invRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creCntCd = this.creCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgTpCd = this.dmdtChgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actPayrCustNm = this.actPayrCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd = this.invCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToLocDivCd = this.bilToLocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payrCntcPntPhnNo = this.payrCntcPntPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtMnlInvRsnNm = this.dmdtMnlInvRsnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustNm = this.actCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issueUsrNm = this.issueUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrNm = this.updUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCntrQty = this.bkgCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaHighEduTaxRt = this.idaHighEduTaxRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaExpnTaxRt = this.idaExpnTaxRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaExpnTax = this.idaExpnTax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaEduTax = this.idaEduTax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaHighEduTax = this.idaHighEduTax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaEduTaxRt = this.idaEduTaxRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
