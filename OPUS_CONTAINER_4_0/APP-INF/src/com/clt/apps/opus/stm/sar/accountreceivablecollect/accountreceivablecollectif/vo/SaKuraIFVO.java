/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SaKuraIFVO.java
*@FileTitle : SaKuraIFVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.20  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablecollectif.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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

public class SaKuraIFVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SaKuraIFVO> models = new ArrayList<SaKuraIFVO>();
	
	/* Column Info */
	private String ifDt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String asgnNo = null;
	/* Column Info */
	private String instrKeyCd1 = null;
	/* Column Info */
	private String automtcPayCurrCd = null;
	/* Column Info */
	private String mtrlNo = null;
	/* Column Info */
	private String instrKeyCd2 = null;
	/* Column Info */
	private String payCurrAmt = null;
	/* Column Info */
	private String refDocNo = null;
	/* Column Info */
	private String instrKeyCd3 = null;
	/* Column Info */
	private String loclTaxAmt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String ifFileId = null;
	/* Column Info */
	private String otsDtrbSeq = null;
	/* Column Info */
	private String glAcctNo = null;
	/* Column Info */
	private String erpIfErrFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ctrtNo = null;
	/* Column Info */
	private String budMgmtDivCd = null;
	/* Column Info */
	private String asetTjTpCd = null;
	/* Column Info */
	private String payRefCd = null;
	/* Column Info */
	private String asaFlg = null;
	/* Column Info */
	private String erpIfErrRsn = null;
	/* Column Info */
	private String arIfStsCd = null;
	/* Column Info */
	private String acctCoCd = null;
	/* Column Info */
	private String rvsFlg = null;
	/* Column Info */
	private String vvlCd = null;
	/* Column Info */
	private String husBankId = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String payBlckKeyCd = null;
	/* Column Info */
	private String ordNo = null;
	/* Column Info */
	private String docDt = null;
	/* Column Info */
	private String trnkVvdCd = null;
	/* Column Info */
	private String ifFlg = null;
	/* Column Info */
	private String asetValDt = null;
	/* Column Info */
	private String payRsnCd = null;
	/* Column Info */
	private String recId = null;
	/* Column Info */
	private String pstDt = null;
	/* Column Info */
	private String payMzdCd = null;
	/* Column Info */
	private String steCntrlBankIndCd = null;
	/* Column Info */
	private String n1stLodgPortCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String docHdrCd = null;
	/* Column Info */
	private String vatTaxCd = null;
	/* Column Info */
	private String subAsetNo = null;
	/* Column Info */
	private String dueDtCalcBselDt = null;
	/* Column Info */
	private String arIfErrDesc = null;
	/* Column Info */
	private String clssCd = null;
	/* Column Info */
	private String mnAsetNo = null;
	/* Column Info */
	private String lstDchgPortCd = null;
	/* Column Info */
	private String custNo = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String taxCalcAutoFlg = null;
	/* Column Info */
	private String ifSeqNo = null;
	/* Column Info */
	private String cltDtrbSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ctrtTpCd = null;
	/* Column Info */
	private String arIfSeq = null;
	/* Column Info */
	private String lineItmRefKeyCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lstDchgPortEtaDt = null;
	/* Column Info */
	private String bkgQty = null;
	/* Column Info */
	private String n1stLodgPortEtdDt = null;
	/* Column Info */
	private String fuelLandQty = null;
	/* Column Info */
	private String pfitctrCd = null;
	/* Column Info */
	private String altnAcctNo = null;
	/* Column Info */
	private String docTaxAmt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String pstKeyCd = null;
	/* Column Info */
	private String itmDesc = null;
	/* Column Info */
	private String recTpCd = null;
	/* Column Info */
	private String loclAmt = null;
	/* Column Info */
	private String costCtrCd = null;
	/* Column Info */
	private String plnDt = null;
	/* Column Info */
	private String measBseUtCd = null;
	/* Column Info */
	private String bizPrnrRefKeyCd1 = null;
	/* Column Info */
	private String entrExpnId = null;
	/* Column Info */
	private String bizPrnrRefKeyCd2 = null;
	/* Column Info */
	private String ifDocTpCd = null;
	/* Column Info */
	private String docAmt = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String actDt = null;
	/* Column Info */
	private String actPlcCd = null;
	/* Column Info */
	private String vndrCrtrAcctNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SaKuraIFVO() {}

	public SaKuraIFVO(String ibflag, String pagerows, String ifDt, String vslCd, String asgnNo, String instrKeyCd1, String automtcPayCurrCd, String mtrlNo, String instrKeyCd2, String payCurrAmt, String refDocNo, String instrKeyCd3, String trdCd, String loclTaxAmt, String otsDtrbSeq, String ifFileId, String glAcctNo, String erpIfErrFlg, String ctrtNo, String budMgmtDivCd, String asetTjTpCd, String payRefCd, String asaFlg, String arIfStsCd, String erpIfErrRsn, String acctCoCd, String vvlCd, String husBankId, String updUsrId, String payBlckKeyCd, String ordNo, String docDt, String trnkVvdCd, String ifFlg, String asetValDt, String payRsnCd, String recId, String pstDt, String payMzdCd, String steCntrlBankIndCd, String n1stLodgPortCd, String creUsrId, String docHdrCd, String vatTaxCd, String subAsetNo, String dueDtCalcBselDt, String arIfErrDesc, String clssCd, String mnAsetNo, String lstDchgPortCd, String custNo, String currCd, String taxCalcAutoFlg, String ifSeqNo, String cltDtrbSeq, String creDt, String ctrtTpCd, String lineItmRefKeyCd, String arIfSeq, String bkgQty, String lstDchgPortEtaDt, String n1stLodgPortEtdDt, String fuelLandQty, String altnAcctNo, String pfitctrCd, String docTaxAmt, String pstKeyCd, String updDt, String itmDesc, String loclAmt, String recTpCd, String bizPrnrRefKeyCd1, String measBseUtCd, String plnDt, String costCtrCd, String bizPrnrRefKeyCd2, String entrExpnId, String ifDocTpCd, String slanCd, String docAmt, String actDt, String actPlcCd, String vndrCrtrAcctNo, String rvsFlg) {
		this.ifDt = ifDt;
		this.vslCd = vslCd;
		this.asgnNo = asgnNo;
		this.instrKeyCd1 = instrKeyCd1;
		this.automtcPayCurrCd = automtcPayCurrCd;
		this.mtrlNo = mtrlNo;
		this.instrKeyCd2 = instrKeyCd2;
		this.payCurrAmt = payCurrAmt;
		this.refDocNo = refDocNo;
		this.instrKeyCd3 = instrKeyCd3;
		this.loclTaxAmt = loclTaxAmt;
		this.trdCd = trdCd;
		this.ifFileId = ifFileId;
		this.otsDtrbSeq = otsDtrbSeq;
		this.glAcctNo = glAcctNo;
		this.erpIfErrFlg = erpIfErrFlg;
		this.pagerows = pagerows;
		this.ctrtNo = ctrtNo;
		this.budMgmtDivCd = budMgmtDivCd;
		this.asetTjTpCd = asetTjTpCd;
		this.payRefCd = payRefCd;
		this.asaFlg = asaFlg;
		this.erpIfErrRsn = erpIfErrRsn;
		this.arIfStsCd = arIfStsCd;
		this.acctCoCd = acctCoCd;
		this.rvsFlg = rvsFlg;
		this.vvlCd = vvlCd;
		this.husBankId = husBankId;
		this.updUsrId = updUsrId;
		this.payBlckKeyCd = payBlckKeyCd;
		this.ordNo = ordNo;
		this.docDt = docDt;
		this.trnkVvdCd = trnkVvdCd;
		this.ifFlg = ifFlg;
		this.asetValDt = asetValDt;
		this.payRsnCd = payRsnCd;
		this.recId = recId;
		this.pstDt = pstDt;
		this.payMzdCd = payMzdCd;
		this.steCntrlBankIndCd = steCntrlBankIndCd;
		this.n1stLodgPortCd = n1stLodgPortCd;
		this.creUsrId = creUsrId;
		this.docHdrCd = docHdrCd;
		this.vatTaxCd = vatTaxCd;
		this.subAsetNo = subAsetNo;
		this.dueDtCalcBselDt = dueDtCalcBselDt;
		this.arIfErrDesc = arIfErrDesc;
		this.clssCd = clssCd;
		this.mnAsetNo = mnAsetNo;
		this.lstDchgPortCd = lstDchgPortCd;
		this.custNo = custNo;
		this.currCd = currCd;
		this.taxCalcAutoFlg = taxCalcAutoFlg;
		this.ifSeqNo = ifSeqNo;
		this.cltDtrbSeq = cltDtrbSeq;
		this.creDt = creDt;
		this.ctrtTpCd = ctrtTpCd;
		this.arIfSeq = arIfSeq;
		this.lineItmRefKeyCd = lineItmRefKeyCd;
		this.ibflag = ibflag;
		this.lstDchgPortEtaDt = lstDchgPortEtaDt;
		this.bkgQty = bkgQty;
		this.n1stLodgPortEtdDt = n1stLodgPortEtdDt;
		this.fuelLandQty = fuelLandQty;
		this.pfitctrCd = pfitctrCd;
		this.altnAcctNo = altnAcctNo;
		this.docTaxAmt = docTaxAmt;
		this.updDt = updDt;
		this.pstKeyCd = pstKeyCd;
		this.itmDesc = itmDesc;
		this.recTpCd = recTpCd;
		this.loclAmt = loclAmt;
		this.costCtrCd = costCtrCd;
		this.plnDt = plnDt;
		this.measBseUtCd = measBseUtCd;
		this.bizPrnrRefKeyCd1 = bizPrnrRefKeyCd1;
		this.entrExpnId = entrExpnId;
		this.bizPrnrRefKeyCd2 = bizPrnrRefKeyCd2;
		this.ifDocTpCd = ifDocTpCd;
		this.docAmt = docAmt;
		this.slanCd = slanCd;
		this.actDt = actDt;
		this.actPlcCd = actPlcCd;
		this.vndrCrtrAcctNo = vndrCrtrAcctNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("if_dt", getIfDt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("asgn_no", getAsgnNo());
		this.hashColumns.put("instr_key_cd1", getInstrKeyCd1());
		this.hashColumns.put("automtc_pay_curr_cd", getAutomtcPayCurrCd());
		this.hashColumns.put("mtrl_no", getMtrlNo());
		this.hashColumns.put("instr_key_cd2", getInstrKeyCd2());
		this.hashColumns.put("pay_curr_amt", getPayCurrAmt());
		this.hashColumns.put("ref_doc_no", getRefDocNo());
		this.hashColumns.put("instr_key_cd3", getInstrKeyCd3());
		this.hashColumns.put("locl_tax_amt", getLoclTaxAmt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("if_file_id", getIfFileId());
		this.hashColumns.put("ots_dtrb_seq", getOtsDtrbSeq());
		this.hashColumns.put("gl_acct_no", getGlAcctNo());
		this.hashColumns.put("erp_if_err_flg", getErpIfErrFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("bud_mgmt_div_cd", getBudMgmtDivCd());
		this.hashColumns.put("aset_tj_tp_cd", getAsetTjTpCd());
		this.hashColumns.put("pay_ref_cd", getPayRefCd());
		this.hashColumns.put("asa_flg", getAsaFlg());
		this.hashColumns.put("erp_if_err_rsn", getErpIfErrRsn());
		this.hashColumns.put("ar_if_sts_cd", getArIfStsCd());
		this.hashColumns.put("acct_co_cd", getAcctCoCd());
		this.hashColumns.put("rvs_flg", getRvsFlg());
		this.hashColumns.put("vvl_cd", getVvlCd());
		this.hashColumns.put("hus_bank_id", getHusBankId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pay_blck_key_cd", getPayBlckKeyCd());
		this.hashColumns.put("ord_no", getOrdNo());
		this.hashColumns.put("doc_dt", getDocDt());
		this.hashColumns.put("trnk_vvd_cd", getTrnkVvdCd());
		this.hashColumns.put("if_flg", getIfFlg());
		this.hashColumns.put("aset_val_dt", getAsetValDt());
		this.hashColumns.put("pay_rsn_cd", getPayRsnCd());
		this.hashColumns.put("rec_id", getRecId());
		this.hashColumns.put("pst_dt", getPstDt());
		this.hashColumns.put("pay_mzd_cd", getPayMzdCd());
		this.hashColumns.put("ste_cntrl_bank_ind_cd", getSteCntrlBankIndCd());
		this.hashColumns.put("n1st_lodg_port_cd", getN1stLodgPortCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("doc_hdr_cd", getDocHdrCd());
		this.hashColumns.put("vat_tax_cd", getVatTaxCd());
		this.hashColumns.put("sub_aset_no", getSubAsetNo());
		this.hashColumns.put("due_dt_calc_bsel_dt", getDueDtCalcBselDt());
		this.hashColumns.put("ar_if_err_desc", getArIfErrDesc());
		this.hashColumns.put("clss_cd", getClssCd());
		this.hashColumns.put("mn_aset_no", getMnAsetNo());
		this.hashColumns.put("lst_dchg_port_cd", getLstDchgPortCd());
		this.hashColumns.put("cust_no", getCustNo());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("tax_calc_auto_flg", getTaxCalcAutoFlg());
		this.hashColumns.put("if_seq_no", getIfSeqNo());
		this.hashColumns.put("clt_dtrb_seq", getCltDtrbSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ctrt_tp_cd", getCtrtTpCd());
		this.hashColumns.put("ar_if_seq", getArIfSeq());
		this.hashColumns.put("line_itm_ref_key_cd", getLineItmRefKeyCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lst_dchg_port_eta_dt", getLstDchgPortEtaDt());
		this.hashColumns.put("bkg_qty", getBkgQty());
		this.hashColumns.put("n1st_lodg_port_etd_dt", getN1stLodgPortEtdDt());
		this.hashColumns.put("fuel_land_qty", getFuelLandQty());
		this.hashColumns.put("pfitctr_cd", getPfitctrCd());
		this.hashColumns.put("altn_acct_no", getAltnAcctNo());
		this.hashColumns.put("doc_tax_amt", getDocTaxAmt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("pst_key_cd", getPstKeyCd());
		this.hashColumns.put("itm_desc", getItmDesc());
		this.hashColumns.put("rec_tp_cd", getRecTpCd());
		this.hashColumns.put("locl_amt", getLoclAmt());
		this.hashColumns.put("cost_ctr_cd", getCostCtrCd());
		this.hashColumns.put("pln_dt", getPlnDt());
		this.hashColumns.put("meas_bse_ut_cd", getMeasBseUtCd());
		this.hashColumns.put("biz_prnr_ref_key_cd1", getBizPrnrRefKeyCd1());
		this.hashColumns.put("entr_expn_id", getEntrExpnId());
		this.hashColumns.put("biz_prnr_ref_key_cd2", getBizPrnrRefKeyCd2());
		this.hashColumns.put("if_doc_tp_cd", getIfDocTpCd());
		this.hashColumns.put("doc_amt", getDocAmt());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("act_dt", getActDt());
		this.hashColumns.put("act_plc_cd", getActPlcCd());
		this.hashColumns.put("vndr_crtr_acct_no", getVndrCrtrAcctNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("if_dt", "ifDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("asgn_no", "asgnNo");
		this.hashFields.put("instr_key_cd1", "instrKeyCd1");
		this.hashFields.put("automtc_pay_curr_cd", "automtcPayCurrCd");
		this.hashFields.put("mtrl_no", "mtrlNo");
		this.hashFields.put("instr_key_cd2", "instrKeyCd2");
		this.hashFields.put("pay_curr_amt", "payCurrAmt");
		this.hashFields.put("ref_doc_no", "refDocNo");
		this.hashFields.put("instr_key_cd3", "instrKeyCd3");
		this.hashFields.put("locl_tax_amt", "loclTaxAmt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("if_file_id", "ifFileId");
		this.hashFields.put("ots_dtrb_seq", "otsDtrbSeq");
		this.hashFields.put("gl_acct_no", "glAcctNo");
		this.hashFields.put("erp_if_err_flg", "erpIfErrFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("bud_mgmt_div_cd", "budMgmtDivCd");
		this.hashFields.put("aset_tj_tp_cd", "asetTjTpCd");
		this.hashFields.put("pay_ref_cd", "payRefCd");
		this.hashFields.put("asa_flg", "asaFlg");
		this.hashFields.put("erp_if_err_rsn", "erpIfErrRsn");
		this.hashFields.put("ar_if_sts_cd", "arIfStsCd");
		this.hashFields.put("acct_co_cd", "acctCoCd");
		this.hashFields.put("rvs_flg", "rvsFlg");
		this.hashFields.put("vvl_cd", "vvlCd");
		this.hashFields.put("hus_bank_id", "husBankId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pay_blck_key_cd", "payBlckKeyCd");
		this.hashFields.put("ord_no", "ordNo");
		this.hashFields.put("doc_dt", "docDt");
		this.hashFields.put("trnk_vvd_cd", "trnkVvdCd");
		this.hashFields.put("if_flg", "ifFlg");
		this.hashFields.put("aset_val_dt", "asetValDt");
		this.hashFields.put("pay_rsn_cd", "payRsnCd");
		this.hashFields.put("rec_id", "recId");
		this.hashFields.put("pst_dt", "pstDt");
		this.hashFields.put("pay_mzd_cd", "payMzdCd");
		this.hashFields.put("ste_cntrl_bank_ind_cd", "steCntrlBankIndCd");
		this.hashFields.put("n1st_lodg_port_cd", "n1stLodgPortCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("doc_hdr_cd", "docHdrCd");
		this.hashFields.put("vat_tax_cd", "vatTaxCd");
		this.hashFields.put("sub_aset_no", "subAsetNo");
		this.hashFields.put("due_dt_calc_bsel_dt", "dueDtCalcBselDt");
		this.hashFields.put("ar_if_err_desc", "arIfErrDesc");
		this.hashFields.put("clss_cd", "clssCd");
		this.hashFields.put("mn_aset_no", "mnAsetNo");
		this.hashFields.put("lst_dchg_port_cd", "lstDchgPortCd");
		this.hashFields.put("cust_no", "custNo");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("tax_calc_auto_flg", "taxCalcAutoFlg");
		this.hashFields.put("if_seq_no", "ifSeqNo");
		this.hashFields.put("clt_dtrb_seq", "cltDtrbSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ctrt_tp_cd", "ctrtTpCd");
		this.hashFields.put("ar_if_seq", "arIfSeq");
		this.hashFields.put("line_itm_ref_key_cd", "lineItmRefKeyCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lst_dchg_port_eta_dt", "lstDchgPortEtaDt");
		this.hashFields.put("bkg_qty", "bkgQty");
		this.hashFields.put("n1st_lodg_port_etd_dt", "n1stLodgPortEtdDt");
		this.hashFields.put("fuel_land_qty", "fuelLandQty");
		this.hashFields.put("pfitctr_cd", "pfitctrCd");
		this.hashFields.put("altn_acct_no", "altnAcctNo");
		this.hashFields.put("doc_tax_amt", "docTaxAmt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("pst_key_cd", "pstKeyCd");
		this.hashFields.put("itm_desc", "itmDesc");
		this.hashFields.put("rec_tp_cd", "recTpCd");
		this.hashFields.put("locl_amt", "loclAmt");
		this.hashFields.put("cost_ctr_cd", "costCtrCd");
		this.hashFields.put("pln_dt", "plnDt");
		this.hashFields.put("meas_bse_ut_cd", "measBseUtCd");
		this.hashFields.put("biz_prnr_ref_key_cd1", "bizPrnrRefKeyCd1");
		this.hashFields.put("entr_expn_id", "entrExpnId");
		this.hashFields.put("biz_prnr_ref_key_cd2", "bizPrnrRefKeyCd2");
		this.hashFields.put("if_doc_tp_cd", "ifDocTpCd");
		this.hashFields.put("doc_amt", "docAmt");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("act_dt", "actDt");
		this.hashFields.put("act_plc_cd", "actPlcCd");
		this.hashFields.put("vndr_crtr_acct_no", "vndrCrtrAcctNo");
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return asgnNo
	 */
	public String getAsgnNo() {
		return this.asgnNo;
	}
	
	/**
	 * Column Info
	 * @return instrKeyCd1
	 */
	public String getInstrKeyCd1() {
		return this.instrKeyCd1;
	}
	
	/**
	 * Column Info
	 * @return automtcPayCurrCd
	 */
	public String getAutomtcPayCurrCd() {
		return this.automtcPayCurrCd;
	}
	
	/**
	 * Column Info
	 * @return mtrlNo
	 */
	public String getMtrlNo() {
		return this.mtrlNo;
	}
	
	/**
	 * Column Info
	 * @return instrKeyCd2
	 */
	public String getInstrKeyCd2() {
		return this.instrKeyCd2;
	}
	
	/**
	 * Column Info
	 * @return payCurrAmt
	 */
	public String getPayCurrAmt() {
		return this.payCurrAmt;
	}
	
	/**
	 * Column Info
	 * @return refDocNo
	 */
	public String getRefDocNo() {
		return this.refDocNo;
	}
	
	/**
	 * Column Info
	 * @return instrKeyCd3
	 */
	public String getInstrKeyCd3() {
		return this.instrKeyCd3;
	}
	
	/**
	 * Column Info
	 * @return loclTaxAmt
	 */
	public String getLoclTaxAmt() {
		return this.loclTaxAmt;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return ifFileId
	 */
	public String getIfFileId() {
		return this.ifFileId;
	}
	
	/**
	 * Column Info
	 * @return otsDtrbSeq
	 */
	public String getOtsDtrbSeq() {
		return this.otsDtrbSeq;
	}
	
	/**
	 * Column Info
	 * @return glAcctNo
	 */
	public String getGlAcctNo() {
		return this.glAcctNo;
	}
	
	/**
	 * Column Info
	 * @return erpIfErrFlg
	 */
	public String getErpIfErrFlg() {
		return this.erpIfErrFlg;
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
	 * @return ctrtNo
	 */
	public String getCtrtNo() {
		return this.ctrtNo;
	}
	
	/**
	 * Column Info
	 * @return budMgmtDivCd
	 */
	public String getBudMgmtDivCd() {
		return this.budMgmtDivCd;
	}
	
	/**
	 * Column Info
	 * @return asetTjTpCd
	 */
	public String getAsetTjTpCd() {
		return this.asetTjTpCd;
	}
	
	/**
	 * Column Info
	 * @return payRefCd
	 */
	public String getPayRefCd() {
		return this.payRefCd;
	}
	
	/**
	 * Column Info
	 * @return asaFlg
	 */
	public String getAsaFlg() {
		return this.asaFlg;
	}
	
	/**
	 * Column Info
	 * @return erpIfErrRsn
	 */
	public String getErpIfErrRsn() {
		return this.erpIfErrRsn;
	}
	
	/**
	 * Column Info
	 * @return arIfStsCd
	 */
	public String getArIfStsCd() {
		return this.arIfStsCd;
	}
	
	/**
	 * Column Info
	 * @return acctCoCd
	 */
	public String getAcctCoCd() {
		return this.acctCoCd;
	}
	
	/**
	 * Column Info
	 * @return rvsFlg
	 */
	public String getRvsFlg() {
		return this.rvsFlg;
	}
	
	/**
	 * Column Info
	 * @return vvlCd
	 */
	public String getVvlCd() {
		return this.vvlCd;
	}
	
	/**
	 * Column Info
	 * @return husBankId
	 */
	public String getHusBankId() {
		return this.husBankId;
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
	 * @return payBlckKeyCd
	 */
	public String getPayBlckKeyCd() {
		return this.payBlckKeyCd;
	}
	
	/**
	 * Column Info
	 * @return ordNo
	 */
	public String getOrdNo() {
		return this.ordNo;
	}
	
	/**
	 * Column Info
	 * @return docDt
	 */
	public String getDocDt() {
		return this.docDt;
	}
	
	/**
	 * Column Info
	 * @return trnkVvdCd
	 */
	public String getTrnkVvdCd() {
		return this.trnkVvdCd;
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
	 * @return asetValDt
	 */
	public String getAsetValDt() {
		return this.asetValDt;
	}
	
	/**
	 * Column Info
	 * @return payRsnCd
	 */
	public String getPayRsnCd() {
		return this.payRsnCd;
	}
	
	/**
	 * Column Info
	 * @return recId
	 */
	public String getRecId() {
		return this.recId;
	}
	
	/**
	 * Column Info
	 * @return pstDt
	 */
	public String getPstDt() {
		return this.pstDt;
	}
	
	/**
	 * Column Info
	 * @return payMzdCd
	 */
	public String getPayMzdCd() {
		return this.payMzdCd;
	}
	
	/**
	 * Column Info
	 * @return steCntrlBankIndCd
	 */
	public String getSteCntrlBankIndCd() {
		return this.steCntrlBankIndCd;
	}
	
	/**
	 * Column Info
	 * @return n1stLodgPortCd
	 */
	public String getN1stLodgPortCd() {
		return this.n1stLodgPortCd;
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
	 * @return docHdrCd
	 */
	public String getDocHdrCd() {
		return this.docHdrCd;
	}
	
	/**
	 * Column Info
	 * @return vatTaxCd
	 */
	public String getVatTaxCd() {
		return this.vatTaxCd;
	}
	
	/**
	 * Column Info
	 * @return subAsetNo
	 */
	public String getSubAsetNo() {
		return this.subAsetNo;
	}
	
	/**
	 * Column Info
	 * @return dueDtCalcBselDt
	 */
	public String getDueDtCalcBselDt() {
		return this.dueDtCalcBselDt;
	}
	
	/**
	 * Column Info
	 * @return arIfErrDesc
	 */
	public String getArIfErrDesc() {
		return this.arIfErrDesc;
	}
	
	/**
	 * Column Info
	 * @return clssCd
	 */
	public String getClssCd() {
		return this.clssCd;
	}
	
	/**
	 * Column Info
	 * @return mnAsetNo
	 */
	public String getMnAsetNo() {
		return this.mnAsetNo;
	}
	
	/**
	 * Column Info
	 * @return lstDchgPortCd
	 */
	public String getLstDchgPortCd() {
		return this.lstDchgPortCd;
	}
	
	/**
	 * Column Info
	 * @return custNo
	 */
	public String getCustNo() {
		return this.custNo;
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
	 * @return taxCalcAutoFlg
	 */
	public String getTaxCalcAutoFlg() {
		return this.taxCalcAutoFlg;
	}
	
	/**
	 * Column Info
	 * @return ifSeqNo
	 */
	public String getIfSeqNo() {
		return this.ifSeqNo;
	}
	
	/**
	 * Column Info
	 * @return cltDtrbSeq
	 */
	public String getCltDtrbSeq() {
		return this.cltDtrbSeq;
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
	 * @return ctrtTpCd
	 */
	public String getCtrtTpCd() {
		return this.ctrtTpCd;
	}
	
	/**
	 * Column Info
	 * @return arIfSeq
	 */
	public String getArIfSeq() {
		return this.arIfSeq;
	}
	
	/**
	 * Column Info
	 * @return lineItmRefKeyCd
	 */
	public String getLineItmRefKeyCd() {
		return this.lineItmRefKeyCd;
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
	 * @return lstDchgPortEtaDt
	 */
	public String getLstDchgPortEtaDt() {
		return this.lstDchgPortEtaDt;
	}
	
	/**
	 * Column Info
	 * @return bkgQty
	 */
	public String getBkgQty() {
		return this.bkgQty;
	}
	
	/**
	 * Column Info
	 * @return n1stLodgPortEtdDt
	 */
	public String getN1stLodgPortEtdDt() {
		return this.n1stLodgPortEtdDt;
	}
	
	/**
	 * Column Info
	 * @return fuelLandQty
	 */
	public String getFuelLandQty() {
		return this.fuelLandQty;
	}
	
	/**
	 * Column Info
	 * @return pfitctrCd
	 */
	public String getPfitctrCd() {
		return this.pfitctrCd;
	}
	
	/**
	 * Column Info
	 * @return altnAcctNo
	 */
	public String getAltnAcctNo() {
		return this.altnAcctNo;
	}
	
	/**
	 * Column Info
	 * @return docTaxAmt
	 */
	public String getDocTaxAmt() {
		return this.docTaxAmt;
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
	 * @return pstKeyCd
	 */
	public String getPstKeyCd() {
		return this.pstKeyCd;
	}
	
	/**
	 * Column Info
	 * @return itmDesc
	 */
	public String getItmDesc() {
		return this.itmDesc;
	}
	
	/**
	 * Column Info
	 * @return recTpCd
	 */
	public String getRecTpCd() {
		return this.recTpCd;
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
	 * @return costCtrCd
	 */
	public String getCostCtrCd() {
		return this.costCtrCd;
	}
	
	/**
	 * Column Info
	 * @return plnDt
	 */
	public String getPlnDt() {
		return this.plnDt;
	}
	
	/**
	 * Column Info
	 * @return measBseUtCd
	 */
	public String getMeasBseUtCd() {
		return this.measBseUtCd;
	}
	
	/**
	 * Column Info
	 * @return bizPrnrRefKeyCd1
	 */
	public String getBizPrnrRefKeyCd1() {
		return this.bizPrnrRefKeyCd1;
	}
	
	/**
	 * Column Info
	 * @return entrExpnId
	 */
	public String getEntrExpnId() {
		return this.entrExpnId;
	}
	
	/**
	 * Column Info
	 * @return bizPrnrRefKeyCd2
	 */
	public String getBizPrnrRefKeyCd2() {
		return this.bizPrnrRefKeyCd2;
	}
	
	/**
	 * Column Info
	 * @return ifDocTpCd
	 */
	public String getIfDocTpCd() {
		return this.ifDocTpCd;
	}
	
	/**
	 * Column Info
	 * @return docAmt
	 */
	public String getDocAmt() {
		return this.docAmt;
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
	 * @return actDt
	 */
	public String getActDt() {
		return this.actDt;
	}
	
	/**
	 * Column Info
	 * @return actPlcCd
	 */
	public String getActPlcCd() {
		return this.actPlcCd;
	}
	
	/**
	 * Column Info
	 * @return vndrCrtrAcctNo
	 */
	public String getVndrCrtrAcctNo() {
		return this.vndrCrtrAcctNo;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param asgnNo
	 */
	public void setAsgnNo(String asgnNo) {
		this.asgnNo = asgnNo;
	}
	
	/**
	 * Column Info
	 * @param instrKeyCd1
	 */
	public void setInstrKeyCd1(String instrKeyCd1) {
		this.instrKeyCd1 = instrKeyCd1;
	}
	
	/**
	 * Column Info
	 * @param automtcPayCurrCd
	 */
	public void setAutomtcPayCurrCd(String automtcPayCurrCd) {
		this.automtcPayCurrCd = automtcPayCurrCd;
	}
	
	/**
	 * Column Info
	 * @param mtrlNo
	 */
	public void setMtrlNo(String mtrlNo) {
		this.mtrlNo = mtrlNo;
	}
	
	/**
	 * Column Info
	 * @param instrKeyCd2
	 */
	public void setInstrKeyCd2(String instrKeyCd2) {
		this.instrKeyCd2 = instrKeyCd2;
	}
	
	/**
	 * Column Info
	 * @param payCurrAmt
	 */
	public void setPayCurrAmt(String payCurrAmt) {
		this.payCurrAmt = payCurrAmt;
	}
	
	/**
	 * Column Info
	 * @param refDocNo
	 */
	public void setRefDocNo(String refDocNo) {
		this.refDocNo = refDocNo;
	}
	
	/**
	 * Column Info
	 * @param instrKeyCd3
	 */
	public void setInstrKeyCd3(String instrKeyCd3) {
		this.instrKeyCd3 = instrKeyCd3;
	}
	
	/**
	 * Column Info
	 * @param loclTaxAmt
	 */
	public void setLoclTaxAmt(String loclTaxAmt) {
		this.loclTaxAmt = loclTaxAmt;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param ifFileId
	 */
	public void setIfFileId(String ifFileId) {
		this.ifFileId = ifFileId;
	}
	
	/**
	 * Column Info
	 * @param otsDtrbSeq
	 */
	public void setOtsDtrbSeq(String otsDtrbSeq) {
		this.otsDtrbSeq = otsDtrbSeq;
	}
	
	/**
	 * Column Info
	 * @param glAcctNo
	 */
	public void setGlAcctNo(String glAcctNo) {
		this.glAcctNo = glAcctNo;
	}
	
	/**
	 * Column Info
	 * @param erpIfErrFlg
	 */
	public void setErpIfErrFlg(String erpIfErrFlg) {
		this.erpIfErrFlg = erpIfErrFlg;
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
	 * @param ctrtNo
	 */
	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
	}
	
	/**
	 * Column Info
	 * @param budMgmtDivCd
	 */
	public void setBudMgmtDivCd(String budMgmtDivCd) {
		this.budMgmtDivCd = budMgmtDivCd;
	}
	
	/**
	 * Column Info
	 * @param asetTjTpCd
	 */
	public void setAsetTjTpCd(String asetTjTpCd) {
		this.asetTjTpCd = asetTjTpCd;
	}
	
	/**
	 * Column Info
	 * @param payRefCd
	 */
	public void setPayRefCd(String payRefCd) {
		this.payRefCd = payRefCd;
	}
	
	/**
	 * Column Info
	 * @param asaFlg
	 */
	public void setAsaFlg(String asaFlg) {
		this.asaFlg = asaFlg;
	}
	
	/**
	 * Column Info
	 * @param erpIfErrRsn
	 */
	public void setErpIfErrRsn(String erpIfErrRsn) {
		this.erpIfErrRsn = erpIfErrRsn;
	}
	
	/**
	 * Column Info
	 * @param arIfStsCd
	 */
	public void setArIfStsCd(String arIfStsCd) {
		this.arIfStsCd = arIfStsCd;
	}
	
	/**
	 * Column Info
	 * @param acctCoCd
	 */
	public void setAcctCoCd(String acctCoCd) {
		this.acctCoCd = acctCoCd;
	}
	
	/**
	 * Column Info
	 * @param rvsFlg
	 */
	public void setRvsFlg(String rvsFlg) {
		this.rvsFlg = rvsFlg;
	}
	
	/**
	 * Column Info
	 * @param vvlCd
	 */
	public void setVvlCd(String vvlCd) {
		this.vvlCd = vvlCd;
	}
	
	/**
	 * Column Info
	 * @param husBankId
	 */
	public void setHusBankId(String husBankId) {
		this.husBankId = husBankId;
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
	 * @param payBlckKeyCd
	 */
	public void setPayBlckKeyCd(String payBlckKeyCd) {
		this.payBlckKeyCd = payBlckKeyCd;
	}
	
	/**
	 * Column Info
	 * @param ordNo
	 */
	public void setOrdNo(String ordNo) {
		this.ordNo = ordNo;
	}
	
	/**
	 * Column Info
	 * @param docDt
	 */
	public void setDocDt(String docDt) {
		this.docDt = docDt;
	}
	
	/**
	 * Column Info
	 * @param trnkVvdCd
	 */
	public void setTrnkVvdCd(String trnkVvdCd) {
		this.trnkVvdCd = trnkVvdCd;
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
	 * @param asetValDt
	 */
	public void setAsetValDt(String asetValDt) {
		this.asetValDt = asetValDt;
	}
	
	/**
	 * Column Info
	 * @param payRsnCd
	 */
	public void setPayRsnCd(String payRsnCd) {
		this.payRsnCd = payRsnCd;
	}
	
	/**
	 * Column Info
	 * @param recId
	 */
	public void setRecId(String recId) {
		this.recId = recId;
	}
	
	/**
	 * Column Info
	 * @param pstDt
	 */
	public void setPstDt(String pstDt) {
		this.pstDt = pstDt;
	}
	
	/**
	 * Column Info
	 * @param payMzdCd
	 */
	public void setPayMzdCd(String payMzdCd) {
		this.payMzdCd = payMzdCd;
	}
	
	/**
	 * Column Info
	 * @param steCntrlBankIndCd
	 */
	public void setSteCntrlBankIndCd(String steCntrlBankIndCd) {
		this.steCntrlBankIndCd = steCntrlBankIndCd;
	}
	
	/**
	 * Column Info
	 * @param n1stLodgPortCd
	 */
	public void setN1stLodgPortCd(String n1stLodgPortCd) {
		this.n1stLodgPortCd = n1stLodgPortCd;
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
	 * @param docHdrCd
	 */
	public void setDocHdrCd(String docHdrCd) {
		this.docHdrCd = docHdrCd;
	}
	
	/**
	 * Column Info
	 * @param vatTaxCd
	 */
	public void setVatTaxCd(String vatTaxCd) {
		this.vatTaxCd = vatTaxCd;
	}
	
	/**
	 * Column Info
	 * @param subAsetNo
	 */
	public void setSubAsetNo(String subAsetNo) {
		this.subAsetNo = subAsetNo;
	}
	
	/**
	 * Column Info
	 * @param dueDtCalcBselDt
	 */
	public void setDueDtCalcBselDt(String dueDtCalcBselDt) {
		this.dueDtCalcBselDt = dueDtCalcBselDt;
	}
	
	/**
	 * Column Info
	 * @param arIfErrDesc
	 */
	public void setArIfErrDesc(String arIfErrDesc) {
		this.arIfErrDesc = arIfErrDesc;
	}
	
	/**
	 * Column Info
	 * @param clssCd
	 */
	public void setClssCd(String clssCd) {
		this.clssCd = clssCd;
	}
	
	/**
	 * Column Info
	 * @param mnAsetNo
	 */
	public void setMnAsetNo(String mnAsetNo) {
		this.mnAsetNo = mnAsetNo;
	}
	
	/**
	 * Column Info
	 * @param lstDchgPortCd
	 */
	public void setLstDchgPortCd(String lstDchgPortCd) {
		this.lstDchgPortCd = lstDchgPortCd;
	}
	
	/**
	 * Column Info
	 * @param custNo
	 */
	public void setCustNo(String custNo) {
		this.custNo = custNo;
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
	 * @param taxCalcAutoFlg
	 */
	public void setTaxCalcAutoFlg(String taxCalcAutoFlg) {
		this.taxCalcAutoFlg = taxCalcAutoFlg;
	}
	
	/**
	 * Column Info
	 * @param ifSeqNo
	 */
	public void setIfSeqNo(String ifSeqNo) {
		this.ifSeqNo = ifSeqNo;
	}
	
	/**
	 * Column Info
	 * @param cltDtrbSeq
	 */
	public void setCltDtrbSeq(String cltDtrbSeq) {
		this.cltDtrbSeq = cltDtrbSeq;
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
	 * @param ctrtTpCd
	 */
	public void setCtrtTpCd(String ctrtTpCd) {
		this.ctrtTpCd = ctrtTpCd;
	}
	
	/**
	 * Column Info
	 * @param arIfSeq
	 */
	public void setArIfSeq(String arIfSeq) {
		this.arIfSeq = arIfSeq;
	}
	
	/**
	 * Column Info
	 * @param lineItmRefKeyCd
	 */
	public void setLineItmRefKeyCd(String lineItmRefKeyCd) {
		this.lineItmRefKeyCd = lineItmRefKeyCd;
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
	 * @param lstDchgPortEtaDt
	 */
	public void setLstDchgPortEtaDt(String lstDchgPortEtaDt) {
		this.lstDchgPortEtaDt = lstDchgPortEtaDt;
	}
	
	/**
	 * Column Info
	 * @param bkgQty
	 */
	public void setBkgQty(String bkgQty) {
		this.bkgQty = bkgQty;
	}
	
	/**
	 * Column Info
	 * @param n1stLodgPortEtdDt
	 */
	public void setN1stLodgPortEtdDt(String n1stLodgPortEtdDt) {
		this.n1stLodgPortEtdDt = n1stLodgPortEtdDt;
	}
	
	/**
	 * Column Info
	 * @param fuelLandQty
	 */
	public void setFuelLandQty(String fuelLandQty) {
		this.fuelLandQty = fuelLandQty;
	}
	
	/**
	 * Column Info
	 * @param pfitctrCd
	 */
	public void setPfitctrCd(String pfitctrCd) {
		this.pfitctrCd = pfitctrCd;
	}
	
	/**
	 * Column Info
	 * @param altnAcctNo
	 */
	public void setAltnAcctNo(String altnAcctNo) {
		this.altnAcctNo = altnAcctNo;
	}
	
	/**
	 * Column Info
	 * @param docTaxAmt
	 */
	public void setDocTaxAmt(String docTaxAmt) {
		this.docTaxAmt = docTaxAmt;
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
	 * @param pstKeyCd
	 */
	public void setPstKeyCd(String pstKeyCd) {
		this.pstKeyCd = pstKeyCd;
	}
	
	/**
	 * Column Info
	 * @param itmDesc
	 */
	public void setItmDesc(String itmDesc) {
		this.itmDesc = itmDesc;
	}
	
	/**
	 * Column Info
	 * @param recTpCd
	 */
	public void setRecTpCd(String recTpCd) {
		this.recTpCd = recTpCd;
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
	 * @param costCtrCd
	 */
	public void setCostCtrCd(String costCtrCd) {
		this.costCtrCd = costCtrCd;
	}
	
	/**
	 * Column Info
	 * @param plnDt
	 */
	public void setPlnDt(String plnDt) {
		this.plnDt = plnDt;
	}
	
	/**
	 * Column Info
	 * @param measBseUtCd
	 */
	public void setMeasBseUtCd(String measBseUtCd) {
		this.measBseUtCd = measBseUtCd;
	}
	
	/**
	 * Column Info
	 * @param bizPrnrRefKeyCd1
	 */
	public void setBizPrnrRefKeyCd1(String bizPrnrRefKeyCd1) {
		this.bizPrnrRefKeyCd1 = bizPrnrRefKeyCd1;
	}
	
	/**
	 * Column Info
	 * @param entrExpnId
	 */
	public void setEntrExpnId(String entrExpnId) {
		this.entrExpnId = entrExpnId;
	}
	
	/**
	 * Column Info
	 * @param bizPrnrRefKeyCd2
	 */
	public void setBizPrnrRefKeyCd2(String bizPrnrRefKeyCd2) {
		this.bizPrnrRefKeyCd2 = bizPrnrRefKeyCd2;
	}
	
	/**
	 * Column Info
	 * @param ifDocTpCd
	 */
	public void setIfDocTpCd(String ifDocTpCd) {
		this.ifDocTpCd = ifDocTpCd;
	}
	
	/**
	 * Column Info
	 * @param docAmt
	 */
	public void setDocAmt(String docAmt) {
		this.docAmt = docAmt;
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
	 * @param actDt
	 */
	public void setActDt(String actDt) {
		this.actDt = actDt;
	}
	
	/**
	 * Column Info
	 * @param actPlcCd
	 */
	public void setActPlcCd(String actPlcCd) {
		this.actPlcCd = actPlcCd;
	}
	
	/**
	 * Column Info
	 * @param vndrCrtrAcctNo
	 */
	public void setVndrCrtrAcctNo(String vndrCrtrAcctNo) {
		this.vndrCrtrAcctNo = vndrCrtrAcctNo;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setAsgnNo(JSPUtil.getParameter(request, prefix + "asgn_no", ""));
		setInstrKeyCd1(JSPUtil.getParameter(request, prefix + "instr_key_cd1", ""));
		setAutomtcPayCurrCd(JSPUtil.getParameter(request, prefix + "automtc_pay_curr_cd", ""));
		setMtrlNo(JSPUtil.getParameter(request, prefix + "mtrl_no", ""));
		setInstrKeyCd2(JSPUtil.getParameter(request, prefix + "instr_key_cd2", ""));
		setPayCurrAmt(JSPUtil.getParameter(request, prefix + "pay_curr_amt", ""));
		setRefDocNo(JSPUtil.getParameter(request, prefix + "ref_doc_no", ""));
		setInstrKeyCd3(JSPUtil.getParameter(request, prefix + "instr_key_cd3", ""));
		setLoclTaxAmt(JSPUtil.getParameter(request, prefix + "locl_tax_amt", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setIfFileId(JSPUtil.getParameter(request, prefix + "if_file_id", ""));
		setOtsDtrbSeq(JSPUtil.getParameter(request, prefix + "ots_dtrb_seq", ""));
		setGlAcctNo(JSPUtil.getParameter(request, prefix + "gl_acct_no", ""));
		setErpIfErrFlg(JSPUtil.getParameter(request, prefix + "erp_if_err_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCtrtNo(JSPUtil.getParameter(request, prefix + "ctrt_no", ""));
		setBudMgmtDivCd(JSPUtil.getParameter(request, prefix + "bud_mgmt_div_cd", ""));
		setAsetTjTpCd(JSPUtil.getParameter(request, prefix + "aset_tj_tp_cd", ""));
		setPayRefCd(JSPUtil.getParameter(request, prefix + "pay_ref_cd", ""));
		setAsaFlg(JSPUtil.getParameter(request, prefix + "asa_flg", ""));
		setErpIfErrRsn(JSPUtil.getParameter(request, prefix + "erp_if_err_rsn", ""));
		setArIfStsCd(JSPUtil.getParameter(request, prefix + "ar_if_sts_cd", ""));
		setAcctCoCd(JSPUtil.getParameter(request, prefix + "acct_co_cd", ""));
		setRvsFlg(JSPUtil.getParameter(request, prefix + "rvs_flg", ""));
		setVvlCd(JSPUtil.getParameter(request, prefix + "vvl_cd", ""));
		setHusBankId(JSPUtil.getParameter(request, prefix + "hus_bank_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPayBlckKeyCd(JSPUtil.getParameter(request, prefix + "pay_blck_key_cd", ""));
		setOrdNo(JSPUtil.getParameter(request, prefix + "ord_no", ""));
		setDocDt(JSPUtil.getParameter(request, prefix + "doc_dt", ""));
		setTrnkVvdCd(JSPUtil.getParameter(request, prefix + "trnk_vvd_cd", ""));
		setIfFlg(JSPUtil.getParameter(request, prefix + "if_flg", ""));
		setAsetValDt(JSPUtil.getParameter(request, prefix + "aset_val_dt", ""));
		setPayRsnCd(JSPUtil.getParameter(request, prefix + "pay_rsn_cd", ""));
		setRecId(JSPUtil.getParameter(request, prefix + "rec_id", ""));
		setPstDt(JSPUtil.getParameter(request, prefix + "pst_dt", ""));
		setPayMzdCd(JSPUtil.getParameter(request, prefix + "pay_mzd_cd", ""));
		setSteCntrlBankIndCd(JSPUtil.getParameter(request, prefix + "ste_cntrl_bank_ind_cd", ""));
		setN1stLodgPortCd(JSPUtil.getParameter(request, prefix + "n1st_lodg_port_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setDocHdrCd(JSPUtil.getParameter(request, prefix + "doc_hdr_cd", ""));
		setVatTaxCd(JSPUtil.getParameter(request, prefix + "vat_tax_cd", ""));
		setSubAsetNo(JSPUtil.getParameter(request, prefix + "sub_aset_no", ""));
		setDueDtCalcBselDt(JSPUtil.getParameter(request, prefix + "due_dt_calc_bsel_dt", ""));
		setArIfErrDesc(JSPUtil.getParameter(request, prefix + "ar_if_err_desc", ""));
		setClssCd(JSPUtil.getParameter(request, prefix + "clss_cd", ""));
		setMnAsetNo(JSPUtil.getParameter(request, prefix + "mn_aset_no", ""));
		setLstDchgPortCd(JSPUtil.getParameter(request, prefix + "lst_dchg_port_cd", ""));
		setCustNo(JSPUtil.getParameter(request, prefix + "cust_no", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setTaxCalcAutoFlg(JSPUtil.getParameter(request, prefix + "tax_calc_auto_flg", ""));
		setIfSeqNo(JSPUtil.getParameter(request, prefix + "if_seq_no", ""));
		setCltDtrbSeq(JSPUtil.getParameter(request, prefix + "clt_dtrb_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCtrtTpCd(JSPUtil.getParameter(request, prefix + "ctrt_tp_cd", ""));
		setArIfSeq(JSPUtil.getParameter(request, prefix + "ar_if_seq", ""));
		setLineItmRefKeyCd(JSPUtil.getParameter(request, prefix + "line_itm_ref_key_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLstDchgPortEtaDt(JSPUtil.getParameter(request, prefix + "lst_dchg_port_eta_dt", ""));
		setBkgQty(JSPUtil.getParameter(request, prefix + "bkg_qty", ""));
		setN1stLodgPortEtdDt(JSPUtil.getParameter(request, prefix + "n1st_lodg_port_etd_dt", ""));
		setFuelLandQty(JSPUtil.getParameter(request, prefix + "fuel_land_qty", ""));
		setPfitctrCd(JSPUtil.getParameter(request, prefix + "pfitctr_cd", ""));
		setAltnAcctNo(JSPUtil.getParameter(request, prefix + "altn_acct_no", ""));
		setDocTaxAmt(JSPUtil.getParameter(request, prefix + "doc_tax_amt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setPstKeyCd(JSPUtil.getParameter(request, prefix + "pst_key_cd", ""));
		setItmDesc(JSPUtil.getParameter(request, prefix + "itm_desc", ""));
		setRecTpCd(JSPUtil.getParameter(request, prefix + "rec_tp_cd", ""));
		setLoclAmt(JSPUtil.getParameter(request, prefix + "locl_amt", ""));
		setCostCtrCd(JSPUtil.getParameter(request, prefix + "cost_ctr_cd", ""));
		setPlnDt(JSPUtil.getParameter(request, prefix + "pln_dt", ""));
		setMeasBseUtCd(JSPUtil.getParameter(request, prefix + "meas_bse_ut_cd", ""));
		setBizPrnrRefKeyCd1(JSPUtil.getParameter(request, prefix + "biz_prnr_ref_key_cd1", ""));
		setEntrExpnId(JSPUtil.getParameter(request, prefix + "entr_expn_id", ""));
		setBizPrnrRefKeyCd2(JSPUtil.getParameter(request, prefix + "biz_prnr_ref_key_cd2", ""));
		setIfDocTpCd(JSPUtil.getParameter(request, prefix + "if_doc_tp_cd", ""));
		setDocAmt(JSPUtil.getParameter(request, prefix + "doc_amt", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setActDt(JSPUtil.getParameter(request, prefix + "act_dt", ""));
		setActPlcCd(JSPUtil.getParameter(request, prefix + "act_plc_cd", ""));
		setVndrCrtrAcctNo(JSPUtil.getParameter(request, prefix + "vndr_crtr_acct_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SaKuraIFVO[]
	 */
	public SaKuraIFVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SaKuraIFVO[]
	 */
	public SaKuraIFVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SaKuraIFVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ifDt = (JSPUtil.getParameter(request, prefix	+ "if_dt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] asgnNo = (JSPUtil.getParameter(request, prefix	+ "asgn_no", length));
			String[] instrKeyCd1 = (JSPUtil.getParameter(request, prefix	+ "instr_key_cd1", length));
			String[] automtcPayCurrCd = (JSPUtil.getParameter(request, prefix	+ "automtc_pay_curr_cd", length));
			String[] mtrlNo = (JSPUtil.getParameter(request, prefix	+ "mtrl_no", length));
			String[] instrKeyCd2 = (JSPUtil.getParameter(request, prefix	+ "instr_key_cd2", length));
			String[] payCurrAmt = (JSPUtil.getParameter(request, prefix	+ "pay_curr_amt", length));
			String[] refDocNo = (JSPUtil.getParameter(request, prefix	+ "ref_doc_no", length));
			String[] instrKeyCd3 = (JSPUtil.getParameter(request, prefix	+ "instr_key_cd3", length));
			String[] loclTaxAmt = (JSPUtil.getParameter(request, prefix	+ "locl_tax_amt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] ifFileId = (JSPUtil.getParameter(request, prefix	+ "if_file_id", length));
			String[] otsDtrbSeq = (JSPUtil.getParameter(request, prefix	+ "ots_dtrb_seq", length));
			String[] glAcctNo = (JSPUtil.getParameter(request, prefix	+ "gl_acct_no", length));
			String[] erpIfErrFlg = (JSPUtil.getParameter(request, prefix	+ "erp_if_err_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ctrtNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_no", length));
			String[] budMgmtDivCd = (JSPUtil.getParameter(request, prefix	+ "bud_mgmt_div_cd", length));
			String[] asetTjTpCd = (JSPUtil.getParameter(request, prefix	+ "aset_tj_tp_cd", length));
			String[] payRefCd = (JSPUtil.getParameter(request, prefix	+ "pay_ref_cd", length));
			String[] asaFlg = (JSPUtil.getParameter(request, prefix	+ "asa_flg", length));
			String[] erpIfErrRsn = (JSPUtil.getParameter(request, prefix	+ "erp_if_err_rsn", length));
			String[] arIfStsCd = (JSPUtil.getParameter(request, prefix	+ "ar_if_sts_cd", length));
			String[] acctCoCd = (JSPUtil.getParameter(request, prefix	+ "acct_co_cd", length));
			String[] rvsFlg = (JSPUtil.getParameter(request, prefix	+ "rvs_flg", length));
			String[] vvlCd = (JSPUtil.getParameter(request, prefix	+ "vvl_cd", length));
			String[] husBankId = (JSPUtil.getParameter(request, prefix	+ "hus_bank_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] payBlckKeyCd = (JSPUtil.getParameter(request, prefix	+ "pay_blck_key_cd", length));
			String[] ordNo = (JSPUtil.getParameter(request, prefix	+ "ord_no", length));
			String[] docDt = (JSPUtil.getParameter(request, prefix	+ "doc_dt", length));
			String[] trnkVvdCd = (JSPUtil.getParameter(request, prefix	+ "trnk_vvd_cd", length));
			String[] ifFlg = (JSPUtil.getParameter(request, prefix	+ "if_flg", length));
			String[] asetValDt = (JSPUtil.getParameter(request, prefix	+ "aset_val_dt", length));
			String[] payRsnCd = (JSPUtil.getParameter(request, prefix	+ "pay_rsn_cd", length));
			String[] recId = (JSPUtil.getParameter(request, prefix	+ "rec_id", length));
			String[] pstDt = (JSPUtil.getParameter(request, prefix	+ "pst_dt", length));
			String[] payMzdCd = (JSPUtil.getParameter(request, prefix	+ "pay_mzd_cd", length));
			String[] steCntrlBankIndCd = (JSPUtil.getParameter(request, prefix	+ "ste_cntrl_bank_ind_cd", length));
			String[] n1stLodgPortCd = (JSPUtil.getParameter(request, prefix	+ "n1st_lodg_port_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] docHdrCd = (JSPUtil.getParameter(request, prefix	+ "doc_hdr_cd", length));
			String[] vatTaxCd = (JSPUtil.getParameter(request, prefix	+ "vat_tax_cd", length));
			String[] subAsetNo = (JSPUtil.getParameter(request, prefix	+ "sub_aset_no", length));
			String[] dueDtCalcBselDt = (JSPUtil.getParameter(request, prefix	+ "due_dt_calc_bsel_dt", length));
			String[] arIfErrDesc = (JSPUtil.getParameter(request, prefix	+ "ar_if_err_desc", length));
			String[] clssCd = (JSPUtil.getParameter(request, prefix	+ "clss_cd", length));
			String[] mnAsetNo = (JSPUtil.getParameter(request, prefix	+ "mn_aset_no", length));
			String[] lstDchgPortCd = (JSPUtil.getParameter(request, prefix	+ "lst_dchg_port_cd", length));
			String[] custNo = (JSPUtil.getParameter(request, prefix	+ "cust_no", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] taxCalcAutoFlg = (JSPUtil.getParameter(request, prefix	+ "tax_calc_auto_flg", length));
			String[] ifSeqNo = (JSPUtil.getParameter(request, prefix	+ "if_seq_no", length));
			String[] cltDtrbSeq = (JSPUtil.getParameter(request, prefix	+ "clt_dtrb_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ctrtTpCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_tp_cd", length));
			String[] arIfSeq = (JSPUtil.getParameter(request, prefix	+ "ar_if_seq", length));
			String[] lineItmRefKeyCd = (JSPUtil.getParameter(request, prefix	+ "line_itm_ref_key_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lstDchgPortEtaDt = (JSPUtil.getParameter(request, prefix	+ "lst_dchg_port_eta_dt", length));
			String[] bkgQty = (JSPUtil.getParameter(request, prefix	+ "bkg_qty", length));
			String[] n1stLodgPortEtdDt = (JSPUtil.getParameter(request, prefix	+ "n1st_lodg_port_etd_dt", length));
			String[] fuelLandQty = (JSPUtil.getParameter(request, prefix	+ "fuel_land_qty", length));
			String[] pfitctrCd = (JSPUtil.getParameter(request, prefix	+ "pfitctr_cd", length));
			String[] altnAcctNo = (JSPUtil.getParameter(request, prefix	+ "altn_acct_no", length));
			String[] docTaxAmt = (JSPUtil.getParameter(request, prefix	+ "doc_tax_amt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] pstKeyCd = (JSPUtil.getParameter(request, prefix	+ "pst_key_cd", length));
			String[] itmDesc = (JSPUtil.getParameter(request, prefix	+ "itm_desc", length));
			String[] recTpCd = (JSPUtil.getParameter(request, prefix	+ "rec_tp_cd", length));
			String[] loclAmt = (JSPUtil.getParameter(request, prefix	+ "locl_amt", length));
			String[] costCtrCd = (JSPUtil.getParameter(request, prefix	+ "cost_ctr_cd", length));
			String[] plnDt = (JSPUtil.getParameter(request, prefix	+ "pln_dt", length));
			String[] measBseUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_bse_ut_cd", length));
			String[] bizPrnrRefKeyCd1 = (JSPUtil.getParameter(request, prefix	+ "biz_prnr_ref_key_cd1", length));
			String[] entrExpnId = (JSPUtil.getParameter(request, prefix	+ "entr_expn_id", length));
			String[] bizPrnrRefKeyCd2 = (JSPUtil.getParameter(request, prefix	+ "biz_prnr_ref_key_cd2", length));
			String[] ifDocTpCd = (JSPUtil.getParameter(request, prefix	+ "if_doc_tp_cd", length));
			String[] docAmt = (JSPUtil.getParameter(request, prefix	+ "doc_amt", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] actDt = (JSPUtil.getParameter(request, prefix	+ "act_dt", length));
			String[] actPlcCd = (JSPUtil.getParameter(request, prefix	+ "act_plc_cd", length));
			String[] vndrCrtrAcctNo = (JSPUtil.getParameter(request, prefix	+ "vndr_crtr_acct_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SaKuraIFVO();
				if (ifDt[i] != null)
					model.setIfDt(ifDt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (asgnNo[i] != null)
					model.setAsgnNo(asgnNo[i]);
				if (instrKeyCd1[i] != null)
					model.setInstrKeyCd1(instrKeyCd1[i]);
				if (automtcPayCurrCd[i] != null)
					model.setAutomtcPayCurrCd(automtcPayCurrCd[i]);
				if (mtrlNo[i] != null)
					model.setMtrlNo(mtrlNo[i]);
				if (instrKeyCd2[i] != null)
					model.setInstrKeyCd2(instrKeyCd2[i]);
				if (payCurrAmt[i] != null)
					model.setPayCurrAmt(payCurrAmt[i]);
				if (refDocNo[i] != null)
					model.setRefDocNo(refDocNo[i]);
				if (instrKeyCd3[i] != null)
					model.setInstrKeyCd3(instrKeyCd3[i]);
				if (loclTaxAmt[i] != null)
					model.setLoclTaxAmt(loclTaxAmt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (ifFileId[i] != null)
					model.setIfFileId(ifFileId[i]);
				if (otsDtrbSeq[i] != null)
					model.setOtsDtrbSeq(otsDtrbSeq[i]);
				if (glAcctNo[i] != null)
					model.setGlAcctNo(glAcctNo[i]);
				if (erpIfErrFlg[i] != null)
					model.setErpIfErrFlg(erpIfErrFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ctrtNo[i] != null)
					model.setCtrtNo(ctrtNo[i]);
				if (budMgmtDivCd[i] != null)
					model.setBudMgmtDivCd(budMgmtDivCd[i]);
				if (asetTjTpCd[i] != null)
					model.setAsetTjTpCd(asetTjTpCd[i]);
				if (payRefCd[i] != null)
					model.setPayRefCd(payRefCd[i]);
				if (asaFlg[i] != null)
					model.setAsaFlg(asaFlg[i]);
				if (erpIfErrRsn[i] != null)
					model.setErpIfErrRsn(erpIfErrRsn[i]);
				if (arIfStsCd[i] != null)
					model.setArIfStsCd(arIfStsCd[i]);
				if (acctCoCd[i] != null)
					model.setAcctCoCd(acctCoCd[i]);
				if (rvsFlg[i] != null)
					model.setRvsFlg(rvsFlg[i]);
				if (vvlCd[i] != null)
					model.setVvlCd(vvlCd[i]);
				if (husBankId[i] != null)
					model.setHusBankId(husBankId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (payBlckKeyCd[i] != null)
					model.setPayBlckKeyCd(payBlckKeyCd[i]);
				if (ordNo[i] != null)
					model.setOrdNo(ordNo[i]);
				if (docDt[i] != null)
					model.setDocDt(docDt[i]);
				if (trnkVvdCd[i] != null)
					model.setTrnkVvdCd(trnkVvdCd[i]);
				if (ifFlg[i] != null)
					model.setIfFlg(ifFlg[i]);
				if (asetValDt[i] != null)
					model.setAsetValDt(asetValDt[i]);
				if (payRsnCd[i] != null)
					model.setPayRsnCd(payRsnCd[i]);
				if (recId[i] != null)
					model.setRecId(recId[i]);
				if (pstDt[i] != null)
					model.setPstDt(pstDt[i]);
				if (payMzdCd[i] != null)
					model.setPayMzdCd(payMzdCd[i]);
				if (steCntrlBankIndCd[i] != null)
					model.setSteCntrlBankIndCd(steCntrlBankIndCd[i]);
				if (n1stLodgPortCd[i] != null)
					model.setN1stLodgPortCd(n1stLodgPortCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (docHdrCd[i] != null)
					model.setDocHdrCd(docHdrCd[i]);
				if (vatTaxCd[i] != null)
					model.setVatTaxCd(vatTaxCd[i]);
				if (subAsetNo[i] != null)
					model.setSubAsetNo(subAsetNo[i]);
				if (dueDtCalcBselDt[i] != null)
					model.setDueDtCalcBselDt(dueDtCalcBselDt[i]);
				if (arIfErrDesc[i] != null)
					model.setArIfErrDesc(arIfErrDesc[i]);
				if (clssCd[i] != null)
					model.setClssCd(clssCd[i]);
				if (mnAsetNo[i] != null)
					model.setMnAsetNo(mnAsetNo[i]);
				if (lstDchgPortCd[i] != null)
					model.setLstDchgPortCd(lstDchgPortCd[i]);
				if (custNo[i] != null)
					model.setCustNo(custNo[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (taxCalcAutoFlg[i] != null)
					model.setTaxCalcAutoFlg(taxCalcAutoFlg[i]);
				if (ifSeqNo[i] != null)
					model.setIfSeqNo(ifSeqNo[i]);
				if (cltDtrbSeq[i] != null)
					model.setCltDtrbSeq(cltDtrbSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ctrtTpCd[i] != null)
					model.setCtrtTpCd(ctrtTpCd[i]);
				if (arIfSeq[i] != null)
					model.setArIfSeq(arIfSeq[i]);
				if (lineItmRefKeyCd[i] != null)
					model.setLineItmRefKeyCd(lineItmRefKeyCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lstDchgPortEtaDt[i] != null)
					model.setLstDchgPortEtaDt(lstDchgPortEtaDt[i]);
				if (bkgQty[i] != null)
					model.setBkgQty(bkgQty[i]);
				if (n1stLodgPortEtdDt[i] != null)
					model.setN1stLodgPortEtdDt(n1stLodgPortEtdDt[i]);
				if (fuelLandQty[i] != null)
					model.setFuelLandQty(fuelLandQty[i]);
				if (pfitctrCd[i] != null)
					model.setPfitctrCd(pfitctrCd[i]);
				if (altnAcctNo[i] != null)
					model.setAltnAcctNo(altnAcctNo[i]);
				if (docTaxAmt[i] != null)
					model.setDocTaxAmt(docTaxAmt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (pstKeyCd[i] != null)
					model.setPstKeyCd(pstKeyCd[i]);
				if (itmDesc[i] != null)
					model.setItmDesc(itmDesc[i]);
				if (recTpCd[i] != null)
					model.setRecTpCd(recTpCd[i]);
				if (loclAmt[i] != null)
					model.setLoclAmt(loclAmt[i]);
				if (costCtrCd[i] != null)
					model.setCostCtrCd(costCtrCd[i]);
				if (plnDt[i] != null)
					model.setPlnDt(plnDt[i]);
				if (measBseUtCd[i] != null)
					model.setMeasBseUtCd(measBseUtCd[i]);
				if (bizPrnrRefKeyCd1[i] != null)
					model.setBizPrnrRefKeyCd1(bizPrnrRefKeyCd1[i]);
				if (entrExpnId[i] != null)
					model.setEntrExpnId(entrExpnId[i]);
				if (bizPrnrRefKeyCd2[i] != null)
					model.setBizPrnrRefKeyCd2(bizPrnrRefKeyCd2[i]);
				if (ifDocTpCd[i] != null)
					model.setIfDocTpCd(ifDocTpCd[i]);
				if (docAmt[i] != null)
					model.setDocAmt(docAmt[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (actDt[i] != null)
					model.setActDt(actDt[i]);
				if (actPlcCd[i] != null)
					model.setActPlcCd(actPlcCd[i]);
				if (vndrCrtrAcctNo[i] != null)
					model.setVndrCrtrAcctNo(vndrCrtrAcctNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSaKuraIFVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SaKuraIFVO[]
	 */
	public SaKuraIFVO[] getSaKuraIFVOs(){
		SaKuraIFVO[] vos = (SaKuraIFVO[])models.toArray(new SaKuraIFVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgnNo = this.asgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.instrKeyCd1 = this.instrKeyCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.automtcPayCurrCd = this.automtcPayCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtrlNo = this.mtrlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.instrKeyCd2 = this.instrKeyCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payCurrAmt = this.payCurrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refDocNo = this.refDocNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.instrKeyCd3 = this.instrKeyCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclTaxAmt = this.loclTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifFileId = this.ifFileId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsDtrbSeq = this.otsDtrbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glAcctNo = this.glAcctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.erpIfErrFlg = this.erpIfErrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo = this.ctrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.budMgmtDivCd = this.budMgmtDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asetTjTpCd = this.asetTjTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payRefCd = this.payRefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaFlg = this.asaFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.erpIfErrRsn = this.erpIfErrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfStsCd = this.arIfStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCoCd = this.acctCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvsFlg = this.rvsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvlCd = this.vvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.husBankId = this.husBankId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payBlckKeyCd = this.payBlckKeyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ordNo = this.ordNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docDt = this.docDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkVvdCd = this.trnkVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifFlg = this.ifFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asetValDt = this.asetValDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payRsnCd = this.payRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recId = this.recId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstDt = this.pstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payMzdCd = this.payMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCntrlBankIndCd = this.steCntrlBankIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stLodgPortCd = this.n1stLodgPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docHdrCd = this.docHdrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatTaxCd = this.vatTaxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subAsetNo = this.subAsetNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDtCalcBselDt = this.dueDtCalcBselDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfErrDesc = this.arIfErrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clssCd = this.clssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnAsetNo = this.mnAsetNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstDchgPortCd = this.lstDchgPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNo = this.custNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxCalcAutoFlg = this.taxCalcAutoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifSeqNo = this.ifSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltDtrbSeq = this.cltDtrbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtTpCd = this.ctrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfSeq = this.arIfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lineItmRefKeyCd = this.lineItmRefKeyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstDchgPortEtaDt = this.lstDchgPortEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgQty = this.bkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stLodgPortEtdDt = this.n1stLodgPortEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fuelLandQty = this.fuelLandQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfitctrCd = this.pfitctrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.altnAcctNo = this.altnAcctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docTaxAmt = this.docTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstKeyCd = this.pstKeyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmDesc = this.itmDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recTpCd = this.recTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAmt = this.loclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCtrCd = this.costCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnDt = this.plnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measBseUtCd = this.measBseUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bizPrnrRefKeyCd1 = this.bizPrnrRefKeyCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.entrExpnId = this.entrExpnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bizPrnrRefKeyCd2 = this.bizPrnrRefKeyCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifDocTpCd = this.ifDocTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docAmt = this.docAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDt = this.actDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actPlcCd = this.actPlcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCrtrAcctNo = this.vndrCrtrAcctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
