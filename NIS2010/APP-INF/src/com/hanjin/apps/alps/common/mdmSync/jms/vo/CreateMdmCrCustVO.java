/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MdmCrCustVO.java
*@FileTitle : MdmCrCustVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 김준호
*@LastVersion : 1.0
* 2010.02.23 김준호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.common.mdmSync.jms.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김준호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CreateMdmCrCustVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CreateMdmCrCustVO> models = new ArrayList<CreateMdmCrCustVO>();
	
	/* Column Info */
	private String bzctNm = null;
	/* Column Info */
	private String bfrCrCltOfcCd = null;
	/* Column Info */
	private String bztpNm = null;
	/* Column Info */
	private String obCrTermDys = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cngIndivCd = null;
	/* Column Info */
	private String crAmt = null;
	/* Column Info */
	private String dyXchAplyStDt = null;
	/* Column Info */
	private String crStDt = null;
	/* Column Info */
	private String bfrOfcCngDt = null;
	/* Column Info */
	private String ibPhnNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String ibEml = null;
	/* Column Info */
	private String invIssCurrTpCd = null;
	/* Column Info */
	private String obFaxNo = null;
	/* Column Info */
	private String rissInvFlg = null;
	/* Column Info */
	private String crCustRmk = null;
	/* Column Info */
	private String obPhnNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String loclZipCd = null;
	/* Column Info */
	private String bfrKrIbOfcCd = null;
	/* Column Info */
	private String ownrNm = null;
	/* Column Info */
	private String xchRtDivCd = null;
	/* Column Info */
	private String issDivCd = null;
	/* Column Info */
	private String bankAcctNo = null;
	/* Column Info */
	private String loclNm = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String crCustTpCd = null;
	/* Column Info */
	private String obEml = null;
	/* Column Info */
	private String custCrDueDtDivCd = null;
	/* Column Info */
	private String crCltOfcCd = null;
	/* Column Info */
	private String payDtDy4 = null;
	/* Column Info */
	private String ibCrTermDys = null;
	/* Column Info */
	private String payDtDy3 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String payDtDy2 = null;
	/* Column Info */
	private String payDtDy1 = null;
	/* Column Info */
	private String loclAddr4 = null;
	/* Column Info */
	private String loclAddr3 = null;
	/* Column Info */
	private String cntcPsonNm = null;
	/* Column Info */
	private String loclAddr2 = null;
	/* Column Info */
	private String loclAddr1 = null;
	/* Column Info */
	private String actCustCntCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String payDivCd = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String invDueDtDpFlg = null;
	/* Column Info */
	private String eaiEvntDt = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String crFlg = null;
	/* Column Info */
	private String ibFaxNo = null;
	/* Column Info */
	private String crCurrCd = null;
	/* Column Info */
	private String custRlseCtrlFlg = null;
	/* Column Info */
	private String krIbOfcCd = null;
	/* Column Info */
	private String crEndDt = null;
	/* Column Info */
	private String eaiIfId = null;
	/* Column Info */
	private String custRlseCtrlRmk = null;
	/* Column Info */
	private String subSysNm = null;
	/* Column Info */
	private String autoInvIbFlg = null;
	/* Column Info */
	private String autoInvIbHjsRefNo = null;
	/* Column Info */
	private String autoInvIbHjsRefPhnNo = null;
	/* Column Info */
	private String autoInvIbCustRefNoFlg = null;
	/* Column Info */
	private String autoInvIbLoclChgFlg = null;
	/* Column Info */
	private String autoInvIbEml = null;
	/* Column Info */
	private String autoInvObFlg = null;
	/* Column Info */
	private String autoInvObHjsRefNo = null;
	/* Column Info */
	private String autoInvObHjsRefPhnNo = null;
	/* Column Info */
	private String autoInvObCustRefNoFlg = null;
	/* Column Info */
	private String autoInvObLoclChgFlg = null;
	/* Column Info */
	private String autoInvObEml = null;
	/* Column Info */
	private String payDtDy5 = null;
	/* Column Info */
	private String payWkDyCd = null;
	/* Column Info */
	private String payTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CreateMdmCrCustVO() {}

	public CreateMdmCrCustVO(String ibflag, String pagerows, String custCntCd, String custSeq, String actCustCntCd, String actCustSeq, String custRlseCtrlFlg, String crFlg, String crCurrCd, String crAmt, String crCltOfcCd, String crCustRmk, String ibCrTermDys, String obCrTermDys, String payDivCd, String crStDt, String crEndDt, String crCustTpCd, String krIbOfcCd, String obEml, String ibEml, String obPhnNo, String ibPhnNo, String obFaxNo, String ibFaxNo, String xchRtDivCd, String cngIndivCd, String dyXchAplyStDt, String issDivCd, String bankAcctNo, String cntcPsonNm, String custCrDueDtDivCd, String ownrNm, String bzctNm, String bztpNm, String payDtDy1, String payDtDy2, String payDtDy3, String payDtDy4, String loclNm, String loclAddr1, String loclAddr2, String loclAddr3, String loclAddr4, String loclZipCd, String bfrCrCltOfcCd, String bfrOfcCngDt, String bfrKrIbOfcCd, String invDueDtDpFlg, String rissInvFlg, String invIssCurrTpCd, String creUsrId, String creDt, String updUsrId, String updDt, String deltFlg, String eaiEvntDt, String eaiIfId, String custRlseCtrlRmk ,String subSysNm,String autoInvIbFlg,String autoInvIbHjsRefNo,String autoInvIbHjsRefPhnNo,String autoInvIbCustRefNoFlg,String autoInvIbLoclChgFlg,String autoInvIbEml,String autoInvObFlg,String autoInvObHjsRefNo,String autoInvObHjsRefPhnNo,String autoInvObCustRefNoFlg,String autoInvObLoclChgFlg,String autoInvObEml, String payDtDy5, String payWkDyCd, String payTpCd ) {
		this.bzctNm = bzctNm;
		this.bfrCrCltOfcCd = bfrCrCltOfcCd;
		this.bztpNm = bztpNm;
		this.obCrTermDys = obCrTermDys;
		this.pagerows = pagerows;
		this.cngIndivCd = cngIndivCd;
		this.crAmt = crAmt;
		this.dyXchAplyStDt = dyXchAplyStDt;
		this.crStDt = crStDt;
		this.bfrOfcCngDt = bfrOfcCngDt;
		this.ibPhnNo = ibPhnNo;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.ibEml = ibEml;
		this.invIssCurrTpCd = invIssCurrTpCd;
		this.obFaxNo = obFaxNo;
		this.rissInvFlg = rissInvFlg;
		this.crCustRmk = crCustRmk;
		this.obPhnNo = obPhnNo;
		this.creUsrId = creUsrId;
		this.loclZipCd = loclZipCd;
		this.bfrKrIbOfcCd = bfrKrIbOfcCd;
		this.ownrNm = ownrNm;
		this.xchRtDivCd = xchRtDivCd;
		this.issDivCd = issDivCd;
		this.bankAcctNo = bankAcctNo;
		this.loclNm = loclNm;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.crCustTpCd = crCustTpCd;
		this.obEml = obEml;
		this.custCrDueDtDivCd = custCrDueDtDivCd;
		this.crCltOfcCd = crCltOfcCd;
		this.payDtDy4 = payDtDy4;
		this.ibCrTermDys = ibCrTermDys;
		this.payDtDy3 = payDtDy3;
		this.ibflag = ibflag;
		this.payDtDy2 = payDtDy2;
		this.payDtDy1 = payDtDy1;
		this.loclAddr4 = loclAddr4;
		this.loclAddr3 = loclAddr3;
		this.cntcPsonNm = cntcPsonNm;
		this.loclAddr2 = loclAddr2;
		this.loclAddr1 = loclAddr1;
		this.actCustCntCd = actCustCntCd;
		this.updDt = updDt;
		this.payDivCd = payDivCd;
		this.actCustSeq = actCustSeq;
		this.invDueDtDpFlg = invDueDtDpFlg;
		this.eaiEvntDt = eaiEvntDt;
		this.custSeq = custSeq;
		this.crFlg = crFlg;
		this.ibFaxNo = ibFaxNo;
		this.crCurrCd = crCurrCd;
		this.custRlseCtrlFlg = custRlseCtrlFlg;
		this.krIbOfcCd = krIbOfcCd;
		this.crEndDt = crEndDt;
		this.eaiIfId = eaiIfId;
		this.custRlseCtrlRmk = custRlseCtrlRmk;
		this.subSysNm  = subSysNm;
		this.autoInvIbFlg  = autoInvIbFlg;
		this.autoInvIbHjsRefNo  = autoInvIbHjsRefNo;
		this.autoInvIbHjsRefPhnNo  = autoInvIbHjsRefPhnNo;
		this.autoInvIbCustRefNoFlg  = autoInvIbCustRefNoFlg;
		this.autoInvIbLoclChgFlg  = autoInvIbLoclChgFlg;
		this.autoInvIbEml  = autoInvIbEml;
		this.autoInvObFlg  = autoInvObFlg;
		this.autoInvObHjsRefNo  = autoInvObHjsRefNo;
		this.autoInvObHjsRefPhnNo  = autoInvObHjsRefPhnNo;
		this.autoInvObCustRefNoFlg  = autoInvObCustRefNoFlg;
		this.autoInvObLoclChgFlg  = autoInvObLoclChgFlg;
		this.autoInvObEml  = autoInvObEml;
		this.payDtDy5  = payDtDy5;
		this.payWkDyCd  = payWkDyCd;
		this.payTpCd  = payTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bzct_nm", getBzctNm());
		this.hashColumns.put("bfr_cr_clt_ofc_cd", getBfrCrCltOfcCd());
		this.hashColumns.put("bztp_nm", getBztpNm());
		this.hashColumns.put("ob_cr_term_dys", getObCrTermDys());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cng_indiv_cd", getCngIndivCd());
		this.hashColumns.put("cr_amt", getCrAmt());
		this.hashColumns.put("dy_xch_aply_st_dt", getDyXchAplyStDt());
		this.hashColumns.put("cr_st_dt", getCrStDt());
		this.hashColumns.put("bfr_ofc_cng_dt", getBfrOfcCngDt());
		this.hashColumns.put("ib_phn_no", getIbPhnNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("ib_eml", getIbEml());
		this.hashColumns.put("inv_iss_curr_tp_cd", getInvIssCurrTpCd());
		this.hashColumns.put("ob_fax_no", getObFaxNo());
		this.hashColumns.put("riss_inv_flg", getRissInvFlg());
		this.hashColumns.put("cr_cust_rmk", getCrCustRmk());
		this.hashColumns.put("ob_phn_no", getObPhnNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("locl_zip_cd", getLoclZipCd());
		this.hashColumns.put("bfr_kr_ib_ofc_cd", getBfrKrIbOfcCd());
		this.hashColumns.put("ownr_nm", getOwnrNm());
		this.hashColumns.put("xch_rt_div_cd", getXchRtDivCd());
		this.hashColumns.put("iss_div_cd", getIssDivCd());
		this.hashColumns.put("bank_acct_no", getBankAcctNo());
		this.hashColumns.put("locl_nm", getLoclNm());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cr_cust_tp_cd", getCrCustTpCd());
		this.hashColumns.put("ob_eml", getObEml());
		this.hashColumns.put("cust_cr_due_dt_div_cd", getCustCrDueDtDivCd());
		this.hashColumns.put("cr_clt_ofc_cd", getCrCltOfcCd());
		this.hashColumns.put("pay_dt_dy4", getPayDtDy4());
		this.hashColumns.put("ib_cr_term_dys", getIbCrTermDys());
		this.hashColumns.put("pay_dt_dy3", getPayDtDy3());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pay_dt_dy2", getPayDtDy2());
		this.hashColumns.put("pay_dt_dy1", getPayDtDy1());
		this.hashColumns.put("locl_addr4", getLoclAddr4());
		this.hashColumns.put("locl_addr3", getLoclAddr3());
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
		this.hashColumns.put("locl_addr2", getLoclAddr2());
		this.hashColumns.put("locl_addr1", getLoclAddr1());
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("pay_div_cd", getPayDivCd());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("inv_due_dt_dp_flg", getInvDueDtDpFlg());
		this.hashColumns.put("eai_evnt_dt", getEaiEvntDt());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cr_flg", getCrFlg());
		this.hashColumns.put("ib_fax_no", getIbFaxNo());
		this.hashColumns.put("cr_curr_cd", getCrCurrCd());
		this.hashColumns.put("cust_rlse_ctrl_flg", getCustRlseCtrlFlg());
		this.hashColumns.put("kr_ib_ofc_cd", getKrIbOfcCd());
		this.hashColumns.put("cr_end_dt", getCrEndDt());
		this.hashColumns.put("eai_if_id", getEaiIfId());
		this.hashColumns.put("cust_rlse_ctrl_rmk", getCustRlseCtrlRmk());
		this.hashColumns.put("sub_sys_nm", getSubSysNm());
		this.hashColumns.put("auto_invoice_inbound_flag", getAutoInvIbFlg());
		this.hashColumns.put("auto_invoice_inbound_hjs_referance_number", getAutoInvIbHjsRefNo());
		this.hashColumns.put("auto_invoice_inbound_hjs_referance_phone_number", getAutoInvIbHjsRefPhnNo());
		this.hashColumns.put("auto_invoice_inbound_customer_referance_number_flag", getAutoInvIbCustRefNoFlg());
		this.hashColumns.put("auto_invoice_inbound_local_charge_flag", getAutoInvIbLoclChgFlg());
		this.hashColumns.put("auto_invoice_inbound_email", getAutoInvIbEml());
		this.hashColumns.put("auto_invoice_outbound_flag", getAutoInvObFlg());
		this.hashColumns.put("auto_invoice_outbound_hjs_referance_number", getAutoInvObHjsRefNo());
		this.hashColumns.put("auto_invoice_outbound_hjs_referance_phone_number", getAutoInvObHjsRefPhnNo());
		this.hashColumns.put("auto_invoice_outbound_customer_referance_number_flag", getAutoInvObCustRefNoFlg());
		this.hashColumns.put("auto_invoice_outbound_local_charge_flag", getAutoInvObLoclChgFlg());
		this.hashColumns.put("auto_invoice_outbound_email", getAutoInvObEml());
		this.hashColumns.put("pay_dt_dy5", getPayDtDy5());
		this.hashColumns.put("pay_wk_dy_cd", getPayWkDyCd());
		this.hashColumns.put("pay_tp_cd", getPayTpCd());

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bzct_nm", "bzctNm");
		this.hashFields.put("bfr_cr_clt_ofc_cd", "bfrCrCltOfcCd");
		this.hashFields.put("bztp_nm", "bztpNm");
		this.hashFields.put("ob_cr_term_dys", "obCrTermDys");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cng_indiv_cd", "cngIndivCd");
		this.hashFields.put("cr_amt", "crAmt");
		this.hashFields.put("dy_xch_aply_st_dt", "dyXchAplyStDt");
		this.hashFields.put("cr_st_dt", "crStDt");
		this.hashFields.put("bfr_ofc_cng_dt", "bfrOfcCngDt");
		this.hashFields.put("ib_phn_no", "ibPhnNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("ib_eml", "ibEml");
		this.hashFields.put("inv_iss_curr_tp_cd", "invIssCurrTpCd");
		this.hashFields.put("ob_fax_no", "obFaxNo");
		this.hashFields.put("riss_inv_flg", "rissInvFlg");
		this.hashFields.put("cr_cust_rmk", "crCustRmk");
		this.hashFields.put("ob_phn_no", "obPhnNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("locl_zip_cd", "loclZipCd");
		this.hashFields.put("bfr_kr_ib_ofc_cd", "bfrKrIbOfcCd");
		this.hashFields.put("ownr_nm", "ownrNm");
		this.hashFields.put("xch_rt_div_cd", "xchRtDivCd");
		this.hashFields.put("iss_div_cd", "issDivCd");
		this.hashFields.put("bank_acct_no", "bankAcctNo");
		this.hashFields.put("locl_nm", "loclNm");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cr_cust_tp_cd", "crCustTpCd");
		this.hashFields.put("ob_eml", "obEml");
		this.hashFields.put("cust_cr_due_dt_div_cd", "custCrDueDtDivCd");
		this.hashFields.put("cr_clt_ofc_cd", "crCltOfcCd");
		this.hashFields.put("pay_dt_dy4", "payDtDy4");
		this.hashFields.put("ib_cr_term_dys", "ibCrTermDys");
		this.hashFields.put("pay_dt_dy3", "payDtDy3");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pay_dt_dy2", "payDtDy2");
		this.hashFields.put("pay_dt_dy1", "payDtDy1");
		this.hashFields.put("locl_addr4", "loclAddr4");
		this.hashFields.put("locl_addr3", "loclAddr3");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
		this.hashFields.put("locl_addr2", "loclAddr2");
		this.hashFields.put("locl_addr1", "loclAddr1");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("pay_div_cd", "payDivCd");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("inv_due_dt_dp_flg", "invDueDtDpFlg");
		this.hashFields.put("eai_evnt_dt", "eaiEvntDt");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cr_flg", "crFlg");
		this.hashFields.put("ib_fax_no", "ibFaxNo");
		this.hashFields.put("cr_curr_cd", "crCurrCd");
		this.hashFields.put("cust_rlse_ctrl_flg", "custRlseCtrlFlg");
		this.hashFields.put("kr_ib_ofc_cd", "krIbOfcCd");
		this.hashFields.put("cr_end_dt", "crEndDt");
		this.hashFields.put("eai_if_id", "eaiIfId");
		this.hashFields.put("cust_rlse_ctrl_rmk", "custRlseCtrlRmk");
		this.hashFields.put("sub_sys_nm", " subSysNm");
		this.hashFields.put("auto_invoice_inbound_flag", "autoInvIbFlg");
		this.hashFields.put("auto_invoice_inbound_hjs_referance_number", "autoInvIbHjsRefNo");
		this.hashFields.put("auto_invoice_inbound_hjs_referance_phone_number", "autoInvIbHjsRefPhnNo");
		this.hashFields.put("auto_invoice_inbound_customer_referance_number_flag", "autoInvIbCustRefNoFlg");
		this.hashFields.put("auto_invoice_inbound_local_charge_flag", "autoInvIbLoclChgFlg");
		this.hashFields.put("auto_invoice_inbound_email", "autoInvIbEml");
		this.hashFields.put("auto_invoice_outbound_flag", "autoInvObFlg");
		this.hashFields.put("auto_invoice_outbound_hjs_referance_number", "autoInvObHjsRefNo");
		this.hashFields.put("auto_invoice_outbound_hjs_referance_phone_number", "autoInvObHjsRefPhnNo");
		this.hashFields.put("auto_invoice_outbound_customer_referance_number_flag", "autoInvObCustRefNoFlg");
		this.hashFields.put("auto_invoice_outbound_local_charge_flag", "autoInvObLoclChgFlg");
		this.hashFields.put("auto_invoice_outbound_email", "autoInvObEml");
		this.hashFields.put("pay_dt_dy5", "payDtDy5");
		this.hashFields.put("pay_wk_dy_cd", "payWkDyCd");
		this.hashFields.put("pay_tp_cd", "payTpCd");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bzctNm
	 */
	public String getBzctNm() {
		return this.bzctNm;
	}
	
	/**
	 * Column Info
	 * @return bfrCrCltOfcCd
	 */
	public String getBfrCrCltOfcCd() {
		return this.bfrCrCltOfcCd;
	}
	
	/**
	 * Column Info
	 * @return bztpNm
	 */
	public String getBztpNm() {
		return this.bztpNm;
	}
	
	/**
	 * Column Info
	 * @return obCrTermDys
	 */
	public String getObCrTermDys() {
		return this.obCrTermDys;
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
	 * @return cngIndivCd
	 */
	public String getCngIndivCd() {
		return this.cngIndivCd;
	}
	
	/**
	 * Column Info
	 * @return crAmt
	 */
	public String getCrAmt() {
		return this.crAmt;
	}
	
	/**
	 * Column Info
	 * @return dyXchAplyStDt
	 */
	public String getDyXchAplyStDt() {
		return this.dyXchAplyStDt;
	}
	
	/**
	 * Column Info
	 * @return crStDt
	 */
	public String getCrStDt() {
		return this.crStDt;
	}
	
	/**
	 * Column Info
	 * @return bfrOfcCngDt
	 */
	public String getBfrOfcCngDt() {
		return this.bfrOfcCngDt;
	}
	
	/**
	 * Column Info
	 * @return ibPhnNo
	 */
	public String getIbPhnNo() {
		return this.ibPhnNo;
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
	 * @return ibEml
	 */
	public String getIbEml() {
		return this.ibEml;
	}
	
	/**
	 * Column Info
	 * @return invIssCurrTpCd
	 */
	public String getInvIssCurrTpCd() {
		return this.invIssCurrTpCd;
	}
	
	/**
	 * Column Info
	 * @return obFaxNo
	 */
	public String getObFaxNo() {
		return this.obFaxNo;
	}
	
	/**
	 * Column Info
	 * @return rissInvFlg
	 */
	public String getRissInvFlg() {
		return this.rissInvFlg;
	}
	
	/**
	 * Column Info
	 * @return crCustRmk
	 */
	public String getCrCustRmk() {
		return this.crCustRmk;
	}
	
	/**
	 * Column Info
	 * @return obPhnNo
	 */
	public String getObPhnNo() {
		return this.obPhnNo;
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
	 * @return loclZipCd
	 */
	public String getLoclZipCd() {
		return this.loclZipCd;
	}
	
	/**
	 * Column Info
	 * @return bfrKrIbOfcCd
	 */
	public String getBfrKrIbOfcCd() {
		return this.bfrKrIbOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ownrNm
	 */
	public String getOwnrNm() {
		return this.ownrNm;
	}
	
	/**
	 * Column Info
	 * @return xchRtDivCd
	 */
	public String getXchRtDivCd() {
		return this.xchRtDivCd;
	}
	
	/**
	 * Column Info
	 * @return issDivCd
	 */
	public String getIssDivCd() {
		return this.issDivCd;
	}
	
	/**
	 * Column Info
	 * @return bankAcctNo
	 */
	public String getBankAcctNo() {
		return this.bankAcctNo;
	}
	
	/**
	 * Column Info
	 * @return loclNm
	 */
	public String getLoclNm() {
		return this.loclNm;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return crCustTpCd
	 */
	public String getCrCustTpCd() {
		return this.crCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return obEml
	 */
	public String getObEml() {
		return this.obEml;
	}
	
	/**
	 * Column Info
	 * @return custCrDueDtDivCd
	 */
	public String getCustCrDueDtDivCd() {
		return this.custCrDueDtDivCd;
	}
	
	/**
	 * Column Info
	 * @return crCltOfcCd
	 */
	public String getCrCltOfcCd() {
		return this.crCltOfcCd;
	}
	
	/**
	 * Column Info
	 * @return payDtDy4
	 */
	public String getPayDtDy4() {
		return this.payDtDy4;
	}
	
	/**
	 * Column Info
	 * @return ibCrTermDys
	 */
	public String getIbCrTermDys() {
		return this.ibCrTermDys;
	}
	
	/**
	 * Column Info
	 * @return payDtDy3
	 */
	public String getPayDtDy3() {
		return this.payDtDy3;
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
	 * @return payDtDy2
	 */
	public String getPayDtDy2() {
		return this.payDtDy2;
	}
	
	/**
	 * Column Info
	 * @return payDtDy1
	 */
	public String getPayDtDy1() {
		return this.payDtDy1;
	}
	
	/**
	 * Column Info
	 * @return loclAddr4
	 */
	public String getLoclAddr4() {
		return this.loclAddr4;
	}
	
	/**
	 * Column Info
	 * @return loclAddr3
	 */
	public String getLoclAddr3() {
		return this.loclAddr3;
	}
	
	/**
	 * Column Info
	 * @return cntcPsonNm
	 */
	public String getCntcPsonNm() {
		return this.cntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @return loclAddr2
	 */
	public String getLoclAddr2() {
		return this.loclAddr2;
	}
	
	/**
	 * Column Info
	 * @return loclAddr1
	 */
	public String getLoclAddr1() {
		return this.loclAddr1;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return payDivCd
	 */
	public String getPayDivCd() {
		return this.payDivCd;
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
	 * @return invDueDtDpFlg
	 */
	public String getInvDueDtDpFlg() {
		return this.invDueDtDpFlg;
	}
	
	/**
	 * Column Info
	 * @return eaiEvntDt
	 */
	public String getEaiEvntDt() {
		return this.eaiEvntDt;
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
	 * @return crFlg
	 */
	public String getCrFlg() {
		return this.crFlg;
	}
	
	/**
	 * Column Info
	 * @return ibFaxNo
	 */
	public String getIbFaxNo() {
		return this.ibFaxNo;
	}
	
	/**
	 * Column Info
	 * @return crCurrCd
	 */
	public String getCrCurrCd() {
		return this.crCurrCd;
	}
	
	/**
	 * Column Info
	 * @return custRlseCtrlFlg
	 */
	public String getCustRlseCtrlFlg() {
		return this.custRlseCtrlFlg;
	}
	
	/**
	 * Column Info
	 * @return krIbOfcCd
	 */
	public String getKrIbOfcCd() {
		return this.krIbOfcCd;
	}
	
	/**
	 * Column Info
	 * @return crEndDt
	 */
	public String getCrEndDt() {
		return this.crEndDt;
	}
	
	/**
	 * Column Info
	 * @return eaiIfId
	 */
	public String getEaiIfId() {
		return this.eaiIfId;
	}
	
	/**
	 * Column Info
	 * @return payDtDy5
	 */
	public String getPayDtDy5() {
		return this.payDtDy5;
	}
	
	/**
	 * Column Info
	 * @return payWkDyCd
	 */
	public String getPayWkDyCd() {
		return this.payWkDyCd;
	}
	
	/**
	 * Column Info
	 * @return payTpCd
	 */
	public String getPayTpCd() {
		return this.payTpCd;
	}
	
	/**
	 * Column Info
	 * @return custRlseCtrlRmk
	 */
	public String getCustRlseCtrlRmk() {
		return custRlseCtrlRmk;
	}

	/**
	 * Column Info
	 * @param bzctNm
	 */
	public void setBzctNm(String bzctNm) {
		this.bzctNm = bzctNm;
	}
	
	/**
	 * Column Info
	 * @param bfrCrCltOfcCd
	 */
	public void setBfrCrCltOfcCd(String bfrCrCltOfcCd) {
		this.bfrCrCltOfcCd = bfrCrCltOfcCd;
	}
	
	/**
	 * Column Info
	 * @param bztpNm
	 */
	public void setBztpNm(String bztpNm) {
		this.bztpNm = bztpNm;
	}
	
	/**
	 * Column Info
	 * @param obCrTermDys
	 */
	public void setObCrTermDys(String obCrTermDys) {
		this.obCrTermDys = obCrTermDys;
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
	 * @param cngIndivCd
	 */
	public void setCngIndivCd(String cngIndivCd) {
		this.cngIndivCd = cngIndivCd;
	}
	
	/**
	 * Column Info
	 * @param crAmt
	 */
	public void setCrAmt(String crAmt) {
		this.crAmt = crAmt;
	}
	
	/**
	 * Column Info
	 * @param dyXchAplyStDt
	 */
	public void setDyXchAplyStDt(String dyXchAplyStDt) {
		this.dyXchAplyStDt = dyXchAplyStDt;
	}
	
	/**
	 * Column Info
	 * @param crStDt
	 */
	public void setCrStDt(String crStDt) {
		this.crStDt = crStDt;
	}
	
	/**
	 * Column Info
	 * @param bfrOfcCngDt
	 */
	public void setBfrOfcCngDt(String bfrOfcCngDt) {
		this.bfrOfcCngDt = bfrOfcCngDt;
	}
	
	/**
	 * Column Info
	 * @param ibPhnNo
	 */
	public void setIbPhnNo(String ibPhnNo) {
		this.ibPhnNo = ibPhnNo;
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
	 * @param ibEml
	 */
	public void setIbEml(String ibEml) {
		this.ibEml = ibEml;
	}
	
	/**
	 * Column Info
	 * @param invIssCurrTpCd
	 */
	public void setInvIssCurrTpCd(String invIssCurrTpCd) {
		this.invIssCurrTpCd = invIssCurrTpCd;
	}
	
	/**
	 * Column Info
	 * @param obFaxNo
	 */
	public void setObFaxNo(String obFaxNo) {
		this.obFaxNo = obFaxNo;
	}
	
	/**
	 * Column Info
	 * @param rissInvFlg
	 */
	public void setRissInvFlg(String rissInvFlg) {
		this.rissInvFlg = rissInvFlg;
	}
	
	/**
	 * Column Info
	 * @param crCustRmk
	 */
	public void setCrCustRmk(String crCustRmk) {
		this.crCustRmk = crCustRmk;
	}
	
	/**
	 * Column Info
	 * @param obPhnNo
	 */
	public void setObPhnNo(String obPhnNo) {
		this.obPhnNo = obPhnNo;
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
	 * @param loclZipCd
	 */
	public void setLoclZipCd(String loclZipCd) {
		this.loclZipCd = loclZipCd;
	}
	
	/**
	 * Column Info
	 * @param bfrKrIbOfcCd
	 */
	public void setBfrKrIbOfcCd(String bfrKrIbOfcCd) {
		this.bfrKrIbOfcCd = bfrKrIbOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ownrNm
	 */
	public void setOwnrNm(String ownrNm) {
		this.ownrNm = ownrNm;
	}
	
	/**
	 * Column Info
	 * @param xchRtDivCd
	 */
	public void setXchRtDivCd(String xchRtDivCd) {
		this.xchRtDivCd = xchRtDivCd;
	}
	
	/**
	 * Column Info
	 * @param issDivCd
	 */
	public void setIssDivCd(String issDivCd) {
		this.issDivCd = issDivCd;
	}
	
	/**
	 * Column Info
	 * @param bankAcctNo
	 */
	public void setBankAcctNo(String bankAcctNo) {
		this.bankAcctNo = bankAcctNo;
	}
	
	/**
	 * Column Info
	 * @param loclNm
	 */
	public void setLoclNm(String loclNm) {
		this.loclNm = loclNm;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param crCustTpCd
	 */
	public void setCrCustTpCd(String crCustTpCd) {
		this.crCustTpCd = crCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param obEml
	 */
	public void setObEml(String obEml) {
		this.obEml = obEml;
	}
	
	/**
	 * Column Info
	 * @param custCrDueDtDivCd
	 */
	public void setCustCrDueDtDivCd(String custCrDueDtDivCd) {
		this.custCrDueDtDivCd = custCrDueDtDivCd;
	}
	
	/**
	 * Column Info
	 * @param crCltOfcCd
	 */
	public void setCrCltOfcCd(String crCltOfcCd) {
		this.crCltOfcCd = crCltOfcCd;
	}
	
	/**
	 * Column Info
	 * @param payDtDy4
	 */
	public void setPayDtDy4(String payDtDy4) {
		this.payDtDy4 = payDtDy4;
	}
	
	/**
	 * Column Info
	 * @param ibCrTermDys
	 */
	public void setIbCrTermDys(String ibCrTermDys) {
		this.ibCrTermDys = ibCrTermDys;
	}
	
	/**
	 * Column Info
	 * @param payDtDy3
	 */
	public void setPayDtDy3(String payDtDy3) {
		this.payDtDy3 = payDtDy3;
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
	 * @param payDtDy2
	 */
	public void setPayDtDy2(String payDtDy2) {
		this.payDtDy2 = payDtDy2;
	}
	
	/**
	 * Column Info
	 * @param payDtDy1
	 */
	public void setPayDtDy1(String payDtDy1) {
		this.payDtDy1 = payDtDy1;
	}
	
	/**
	 * Column Info
	 * @param loclAddr4
	 */
	public void setLoclAddr4(String loclAddr4) {
		this.loclAddr4 = loclAddr4;
	}
	
	/**
	 * Column Info
	 * @param loclAddr3
	 */
	public void setLoclAddr3(String loclAddr3) {
		this.loclAddr3 = loclAddr3;
	}
	
	/**
	 * Column Info
	 * @param cntcPsonNm
	 */
	public void setCntcPsonNm(String cntcPsonNm) {
		this.cntcPsonNm = cntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @param loclAddr2
	 */
	public void setLoclAddr2(String loclAddr2) {
		this.loclAddr2 = loclAddr2;
	}
	
	/**
	 * Column Info
	 * @param loclAddr1
	 */
	public void setLoclAddr1(String loclAddr1) {
		this.loclAddr1 = loclAddr1;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param payDivCd
	 */
	public void setPayDivCd(String payDivCd) {
		this.payDivCd = payDivCd;
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
	 * @param invDueDtDpFlg
	 */
	public void setInvDueDtDpFlg(String invDueDtDpFlg) {
		this.invDueDtDpFlg = invDueDtDpFlg;
	}
	
	/**
	 * Column Info
	 * @param eaiEvntDt
	 */
	public void setEaiEvntDt(String eaiEvntDt) {
		this.eaiEvntDt = eaiEvntDt;
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
	 * @param crFlg
	 */
	public void setCrFlg(String crFlg) {
		this.crFlg = crFlg;
	}
	
	/**
	 * Column Info
	 * @param ibFaxNo
	 */
	public void setIbFaxNo(String ibFaxNo) {
		this.ibFaxNo = ibFaxNo;
	}
	
	/**
	 * Column Info
	 * @param crCurrCd
	 */
	public void setCrCurrCd(String crCurrCd) {
		this.crCurrCd = crCurrCd;
	}
	
	/**
	 * Column Info
	 * @param custRlseCtrlFlg
	 */
	public void setCustRlseCtrlFlg(String custRlseCtrlFlg) {
		this.custRlseCtrlFlg = custRlseCtrlFlg;
	}
	
	/**
	 * Column Info
	 * @param krIbOfcCd
	 */
	public void setKrIbOfcCd(String krIbOfcCd) {
		this.krIbOfcCd = krIbOfcCd;
	}
	
	/**
	 * Column Info
	 * @param crEndDt
	 */
	public void setCrEndDt(String crEndDt) {
		this.crEndDt = crEndDt;
	}
	
	/**
	 * Column Info
	 * @param eaiIfId
	 */
	public void setEaiIfId(String eaiIfId) {
		this.eaiIfId = eaiIfId;
	}
	
	/**
	 * Column Info
	 * @param custRlseCtrlRmk
	 */
	public void setCustRlseCtrlRmk(String custRlseCtrlRmk) {
		this.custRlseCtrlRmk = custRlseCtrlRmk;
	}
	
   /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Column Info
	 * @return subSysNm
	 */
	public String getSubSysNm() {
		return subSysNm;
    }

	/**
	 * Column Info
	 * @param subSysNm
	 */
	public void setSubSysNm(String subSysNm) {
		this.subSysNm = subSysNm;
	}

	/**
	 * Column Info
	 * @return autoInvIbFlg
	 */
	public String getAutoInvIbFlg() {
		return autoInvIbFlg;
	}
	
	/**
	 * Column Info
	 * @param autoInvIbFlg
	 */
	public void setAutoInvIbFlg(String autoInvIbFlg) {
		this.autoInvIbFlg = autoInvIbFlg;
	}

	/**
	 * Column Info
	 * @return autoInvIbHjsRefNo
	 */
	public String getAutoInvIbHjsRefNo() {
		return autoInvIbHjsRefNo;
	}
	
	/**
	 * Column Info
	 * @param autoInvIbHjsRefNo
	 */
	public void setAutoInvIbHjsRefNo(String autoInvIbHjsRefNo) {
		this.autoInvIbHjsRefNo = autoInvIbHjsRefNo;
	}

	/**
	 * Column Info
	 * @return autoInvIbHjsRefPhnNo
	 */
	public String getAutoInvIbHjsRefPhnNo() {
		return autoInvIbHjsRefPhnNo;
	}
	
	/**
	 * Column Info
	 * @param autoInvIbHjsRefPhnNo
	 */
	public void setAutoInvIbHjsRefPhnNo(String autoInvIbHjsRefPhnNo) {
		this.autoInvIbHjsRefPhnNo = autoInvIbHjsRefPhnNo;
	}

	/**
	 * Column Info
	 * @return autoInvIbCustRefNoFlg
	 */
	public String getAutoInvIbCustRefNoFlg() {
		return autoInvIbCustRefNoFlg;
	}
	
	/**
	 * Column Info
	 * @param autoInvIbCustRefNoFlg
	 */
	public void setAutoInvIbCustRefNoFlg(String autoInvIbCustRefNoFlg) {
		this.autoInvIbCustRefNoFlg = autoInvIbCustRefNoFlg;
	}

	/**
	 * Column Info
	 * @return autoInvIbLoclChgFlg
	 */
	public String getAutoInvIbLoclChgFlg() {
		return autoInvIbLoclChgFlg;
	}
	
	/**
	 * Column Info
	 * @param autoInvIbLoclChgFlg
	 */
	public void setAutoInvIbLoclChgFlg(String autoInvIbLoclChgFlg) {
		this.autoInvIbLoclChgFlg = autoInvIbLoclChgFlg;
	}

	/**
	 * Column Info
	 * @return autoInvIbEml
	 */
	public String getAutoInvIbEml() {
		return autoInvIbEml;
	}
	
	/**
	 * Column Info
	 * @param autoInvIbEml
	 */
	public void setAutoInvIbEml(String autoInvIbEml) {
		this.autoInvIbEml = autoInvIbEml;
	}

	/**
	 * Column Info
	 * @return autoInvObFlg
	 */
	public String getAutoInvObFlg() {
		return autoInvObFlg;
	}
	
	/**
	 * Column Info
	 * @param autoInvObFlg
	 */
	public void setAutoInvObFlg(String autoInvObFlg) {
		this.autoInvObFlg = autoInvObFlg;
	}

	/**
	 * Column Info
	 * @return autoInvObHjsRefNo
	 */
	public String getAutoInvObHjsRefNo() {
		return autoInvObHjsRefNo;
	}
	
	/**
	 * Column Info
	 * @param autoInvObHjsRefNo
	 */
	public void setAutoInvObHjsRefNo(String autoInvObHjsRefNo) {
		this.autoInvObHjsRefNo = autoInvObHjsRefNo;
	}

	/**
	 * Column Info
	 * @return autoInvObHjsRefPhnNo
	 */
	public String getAutoInvObHjsRefPhnNo() {
		return autoInvObHjsRefPhnNo;
	}
	
	/**
	 * Column Info
	 * @param autoInvObHjsRefPhnNo
	 */
	public void setAutoInvObHjsRefPhnNo(String autoInvObHjsRefPhnNo) {
		this.autoInvObHjsRefPhnNo = autoInvObHjsRefPhnNo;
	}

	/**
	 * Column Info
	 * @return autoInvObCustRefNoFlg
	 */
	public String getAutoInvObCustRefNoFlg() {
		return autoInvObCustRefNoFlg;
	}
	
	/**
	 * Column Info
	 * @param autoInvObCustRefNoFlg
	 */
	public void setAutoInvObCustRefNoFlg(String autoInvObCustRefNoFlg) {
		this.autoInvObCustRefNoFlg = autoInvObCustRefNoFlg;
	}

	/**
	 * Column Info
	 * @return autoInvObLoclChgFlg
	 */
	public String getAutoInvObLoclChgFlg() {
		return autoInvObLoclChgFlg;
	}
	
	/**
	 * Column Info
	 * @param autoInvObLoclChgFlg
	 */
	public void setAutoInvObLoclChgFlg(String autoInvObLoclChgFlg) {
		this.autoInvObLoclChgFlg = autoInvObLoclChgFlg;
	}

	/**
	 * Column Info
	 * @return autoInvObEml
	 */
	public String getAutoInvObEml() {
		return autoInvObEml;
	}
	
	/**
	 * Column Info
	 * @param autoInvObEml
	 */
	public void setAutoInvObEml(String autoInvObEml) {
		this.autoInvObEml = autoInvObEml;
	}
	
	/**
	 * Column Info
	 * @param payDtDy5
	 */
	public void setPayDtDy5(String payDtDy5) {
		this.payDtDy5 = payDtDy5;
	}
	
	/**
	 * Column Info
	 * @param payWkDyCd
	 */
	public void setPayWkDyCd(String payWkDyCd) {
		this.payWkDyCd = payWkDyCd;
	}
	
	/**
	 * Column Info
	 * @param payTpCd
	 */
	public void setPayTpCd(String payTpCd) {
		this.payTpCd = payTpCd;
	}
	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setBzctNm(JSPUtil.getParameter(request, prefix + "bzct_nm", ""));
		setBfrCrCltOfcCd(JSPUtil.getParameter(request, prefix + "bfr_cr_clt_ofc_cd", ""));
		setBztpNm(JSPUtil.getParameter(request, prefix + "bztp_nm", ""));
		setObCrTermDys(JSPUtil.getParameter(request, prefix + "ob_cr_term_dys", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCngIndivCd(JSPUtil.getParameter(request, prefix + "cng_indiv_cd", ""));
		setCrAmt(JSPUtil.getParameter(request, prefix + "cr_amt", ""));
		setDyXchAplyStDt(JSPUtil.getParameter(request, prefix + "dy_xch_aply_st_dt", ""));
		setCrStDt(JSPUtil.getParameter(request, prefix + "cr_st_dt", ""));
		setBfrOfcCngDt(JSPUtil.getParameter(request, prefix + "bfr_ofc_cng_dt", ""));
		setIbPhnNo(JSPUtil.getParameter(request, prefix + "ib_phn_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setIbEml(JSPUtil.getParameter(request, prefix + "ib_eml", ""));
		setInvIssCurrTpCd(JSPUtil.getParameter(request, prefix + "inv_iss_curr_tp_cd", ""));
		setObFaxNo(JSPUtil.getParameter(request, prefix + "ob_fax_no", ""));
		setRissInvFlg(JSPUtil.getParameter(request, prefix + "riss_inv_flg", ""));
		setCrCustRmk(JSPUtil.getParameter(request, prefix + "cr_cust_rmk", ""));
		setObPhnNo(JSPUtil.getParameter(request, prefix + "ob_phn_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setLoclZipCd(JSPUtil.getParameter(request, prefix + "locl_zip_cd", ""));
		setBfrKrIbOfcCd(JSPUtil.getParameter(request, prefix + "bfr_kr_ib_ofc_cd", ""));
		setOwnrNm(JSPUtil.getParameter(request, prefix + "ownr_nm", ""));
		setXchRtDivCd(JSPUtil.getParameter(request, prefix + "xch_rt_div_cd", ""));
		setIssDivCd(JSPUtil.getParameter(request, prefix + "iss_div_cd", ""));
		setBankAcctNo(JSPUtil.getParameter(request, prefix + "bank_acct_no", ""));
		setLoclNm(JSPUtil.getParameter(request, prefix + "locl_nm", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCrCustTpCd(JSPUtil.getParameter(request, prefix + "cr_cust_tp_cd", ""));
		setObEml(JSPUtil.getParameter(request, prefix + "ob_eml", ""));
		setCustCrDueDtDivCd(JSPUtil.getParameter(request, prefix + "cust_cr_due_dt_div_cd", ""));
		setCrCltOfcCd(JSPUtil.getParameter(request, prefix + "cr_clt_ofc_cd", ""));
		setPayDtDy4(JSPUtil.getParameter(request, prefix + "pay_dt_dy4", ""));
		setIbCrTermDys(JSPUtil.getParameter(request, prefix + "ib_cr_term_dys", ""));
		setPayDtDy3(JSPUtil.getParameter(request, prefix + "pay_dt_dy3", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPayDtDy2(JSPUtil.getParameter(request, prefix + "pay_dt_dy2", ""));
		setPayDtDy1(JSPUtil.getParameter(request, prefix + "pay_dt_dy1", ""));
		setLoclAddr4(JSPUtil.getParameter(request, prefix + "locl_addr4", ""));
		setLoclAddr3(JSPUtil.getParameter(request, prefix + "locl_addr3", ""));
		setCntcPsonNm(JSPUtil.getParameter(request, prefix + "cntc_pson_nm", ""));
		setLoclAddr2(JSPUtil.getParameter(request, prefix + "locl_addr2", ""));
		setLoclAddr1(JSPUtil.getParameter(request, prefix + "locl_addr1", ""));
		setActCustCntCd(JSPUtil.getParameter(request, prefix + "act_cust_cnt_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setPayDivCd(JSPUtil.getParameter(request, prefix + "pay_div_cd", ""));
		setActCustSeq(JSPUtil.getParameter(request, prefix + "act_cust_seq", ""));
		setInvDueDtDpFlg(JSPUtil.getParameter(request, prefix + "inv_due_dt_dp_flg", ""));
		setEaiEvntDt(JSPUtil.getParameter(request, prefix + "eai_evnt_dt", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setCrFlg(JSPUtil.getParameter(request, prefix + "cr_flg", ""));
		setIbFaxNo(JSPUtil.getParameter(request, prefix + "ib_fax_no", ""));
		setCrCurrCd(JSPUtil.getParameter(request, prefix + "cr_curr_cd", ""));
		setCustRlseCtrlFlg(JSPUtil.getParameter(request, prefix + "cust_rlse_ctrl_flg", ""));
		setKrIbOfcCd(JSPUtil.getParameter(request, prefix + "kr_ib_ofc_cd", ""));
		setCrEndDt(JSPUtil.getParameter(request, prefix + "cr_end_dt", ""));
		setEaiIfId(JSPUtil.getParameter(request, "eai_if_id", ""));
		setCustRlseCtrlRmk(JSPUtil.getParameter(request, prefix + "cust_rlse_ctrl_rmk", ""));
		setSubSysNm(JSPUtil.getParameter(request, prefix + "sub_sys_nm", ""));
		setAutoInvIbFlg(JSPUtil.getParameter(request, prefix + "auto_invoice_inbound_flag", ""));
		setAutoInvIbHjsRefNo(JSPUtil.getParameter(request, prefix + "auto_invoice_inbound_hjs_referance_number", ""));
		setAutoInvIbHjsRefPhnNo(JSPUtil.getParameter(request, prefix + "auto_invoice_inbound_hjs_referance_phone_number", ""));
		setAutoInvIbCustRefNoFlg(JSPUtil.getParameter(request, prefix + "auto_invoice_inbound_customer_referance_number_flag", ""));
		setAutoInvIbLoclChgFlg(JSPUtil.getParameter(request, prefix + "auto_invoice_inbound_local_charge_flag", ""));
		setAutoInvIbEml(JSPUtil.getParameter(request, prefix + "auto_invoice_inbound_email", ""));
		setAutoInvObFlg(JSPUtil.getParameter(request, prefix + "auto_invoice_outbound_flag", ""));
		setAutoInvObHjsRefNo(JSPUtil.getParameter(request, prefix + "auto_invoice_outbound_hjs_referance_number", ""));
		setAutoInvObHjsRefPhnNo(JSPUtil.getParameter(request, prefix + "auto_invoice_outbound_hjs_referance_phone_number", ""));
		setAutoInvObCustRefNoFlg(JSPUtil.getParameter(request, prefix + "auto_invoice_outbound_customer_referance_number_flag", ""));
		setAutoInvObLoclChgFlg(JSPUtil.getParameter(request, prefix + "auto_invoice_outbound_local_charge_flag", ""));
		setAutoInvObEml(JSPUtil.getParameter(request, prefix + "auto_invoice_outbound_email", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CreateMdmCrCustVO[]
	 */
	public CreateMdmCrCustVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CreateMdmCrCustVO[]
	 */
	public CreateMdmCrCustVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CreateMdmCrCustVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bzctNm = (JSPUtil.getParameter(request, prefix	+ "bzct_nm", length));
			String[] bfrCrCltOfcCd = (JSPUtil.getParameter(request, prefix	+ "bfr_cr_clt_ofc_cd", length));
			String[] bztpNm = (JSPUtil.getParameter(request, prefix	+ "bztp_nm", length));
			String[] obCrTermDys = (JSPUtil.getParameter(request, prefix	+ "ob_cr_term_dys", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cngIndivCd = (JSPUtil.getParameter(request, prefix	+ "cng_indiv_cd", length));
			String[] crAmt = (JSPUtil.getParameter(request, prefix	+ "cr_amt", length));
			String[] dyXchAplyStDt = (JSPUtil.getParameter(request, prefix	+ "dy_xch_aply_st_dt", length));
			String[] crStDt = (JSPUtil.getParameter(request, prefix	+ "cr_st_dt", length));
			String[] bfrOfcCngDt = (JSPUtil.getParameter(request, prefix	+ "bfr_ofc_cng_dt", length));
			String[] ibPhnNo = (JSPUtil.getParameter(request, prefix	+ "ib_phn_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] ibEml = (JSPUtil.getParameter(request, prefix	+ "ib_eml", length));
			String[] invIssCurrTpCd = (JSPUtil.getParameter(request, prefix	+ "inv_iss_curr_tp_cd", length));
			String[] obFaxNo = (JSPUtil.getParameter(request, prefix	+ "ob_fax_no", length));
			String[] rissInvFlg = (JSPUtil.getParameter(request, prefix	+ "riss_inv_flg", length));
			String[] crCustRmk = (JSPUtil.getParameter(request, prefix	+ "cr_cust_rmk", length));
			String[] obPhnNo = (JSPUtil.getParameter(request, prefix	+ "ob_phn_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] loclZipCd = (JSPUtil.getParameter(request, prefix	+ "locl_zip_cd", length));
			String[] bfrKrIbOfcCd = (JSPUtil.getParameter(request, prefix	+ "bfr_kr_ib_ofc_cd", length));
			String[] ownrNm = (JSPUtil.getParameter(request, prefix	+ "ownr_nm", length));
			String[] xchRtDivCd = (JSPUtil.getParameter(request, prefix	+ "xch_rt_div_cd", length));
			String[] issDivCd = (JSPUtil.getParameter(request, prefix	+ "iss_div_cd", length));
			String[] bankAcctNo = (JSPUtil.getParameter(request, prefix	+ "bank_acct_no", length));
			String[] loclNm = (JSPUtil.getParameter(request, prefix	+ "locl_nm", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] crCustTpCd = (JSPUtil.getParameter(request, prefix	+ "cr_cust_tp_cd", length));
			String[] obEml = (JSPUtil.getParameter(request, prefix	+ "ob_eml", length));
			String[] custCrDueDtDivCd = (JSPUtil.getParameter(request, prefix	+ "cust_cr_due_dt_div_cd", length));
			String[] crCltOfcCd = (JSPUtil.getParameter(request, prefix	+ "cr_clt_ofc_cd", length));
			String[] payDtDy4 = (JSPUtil.getParameter(request, prefix	+ "pay_dt_dy4", length));
			String[] ibCrTermDys = (JSPUtil.getParameter(request, prefix	+ "ib_cr_term_dys", length));
			String[] payDtDy3 = (JSPUtil.getParameter(request, prefix	+ "pay_dt_dy3", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] payDtDy2 = (JSPUtil.getParameter(request, prefix	+ "pay_dt_dy2", length));
			String[] payDtDy1 = (JSPUtil.getParameter(request, prefix	+ "pay_dt_dy1", length));
			String[] loclAddr4 = (JSPUtil.getParameter(request, prefix	+ "locl_addr4", length));
			String[] loclAddr3 = (JSPUtil.getParameter(request, prefix	+ "locl_addr3", length));
			String[] cntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_nm", length));
			String[] loclAddr2 = (JSPUtil.getParameter(request, prefix	+ "locl_addr2", length));
			String[] loclAddr1 = (JSPUtil.getParameter(request, prefix	+ "locl_addr1", length));
			String[] actCustCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cnt_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] payDivCd = (JSPUtil.getParameter(request, prefix	+ "pay_div_cd", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] invDueDtDpFlg = (JSPUtil.getParameter(request, prefix	+ "inv_due_dt_dp_flg", length));
			String[] eaiEvntDt = (JSPUtil.getParameter(request, prefix	+ "eai_evnt_dt", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] crFlg = (JSPUtil.getParameter(request, prefix	+ "cr_flg", length));
			String[] ibFaxNo = (JSPUtil.getParameter(request, prefix	+ "ib_fax_no", length));
			String[] crCurrCd = (JSPUtil.getParameter(request, prefix	+ "cr_curr_cd", length));
			String[] custRlseCtrlFlg = (JSPUtil.getParameter(request, prefix	+ "cust_rlse_ctrl_flg", length));
			String[] krIbOfcCd = (JSPUtil.getParameter(request, prefix	+ "kr_ib_ofc_cd", length));
			String[] crEndDt = (JSPUtil.getParameter(request, prefix	+ "cr_end_dt", length));
			String[] eaiIfId = (JSPUtil.getParameter(request, prefix	+ "eai_if_id", length));
			String[] custRlseCtrlRmk = (JSPUtil.getParameter(request, prefix	+ "cust_rlse_ctrl_rmk", length));
			String[] subSysNm = (JSPUtil.getParameter(request, prefix	+ "sub_sys_nm", length));
			String[] autoInvIbFlg = (JSPUtil.getParameter(request, prefix	+ "auto_invoice_inbound_flag", length));
			String[] autoInvIbHjsRefNo = (JSPUtil.getParameter(request, prefix	+ "auto_invoice_inbound_hjs_referance_number", length));
			String[] autoInvIbHjsRefPhnNo = (JSPUtil.getParameter(request, prefix	+ "auto_invoice_inbound_hjs_referance_phone_number", length));
			String[] autoInvIbCustRefNoFlg = (JSPUtil.getParameter(request, prefix	+ "auto_invoice_inbound_customer_referance_number_flag", length));
			String[] autoInvIbLoclChgFlg = (JSPUtil.getParameter(request, prefix	+ "auto_invoice_inbound_local_charge_flag", length));
			String[] autoInvIbEml = (JSPUtil.getParameter(request, prefix	+ "auto_invoice_inbound_email", length));
			String[] autoInvObFlg = (JSPUtil.getParameter(request, prefix	+ "auto_invoice_outbound_flag", length));
			String[] autoInvObHjsRefNo = (JSPUtil.getParameter(request, prefix	+ "auto_invoice_outbound_hjs_referance_number", length));
			String[] autoInvObHjsRefPhnNo = (JSPUtil.getParameter(request, prefix	+ "auto_invoice_outbound_hjs_referance_phone_number", length));
			String[] autoInvObCustRefNoFlg = (JSPUtil.getParameter(request, prefix	+ "auto_invoice_outbound_customer_referance_number_flag", length));
			String[] autoInvObLoclChgFlg = (JSPUtil.getParameter(request, prefix	+ "auto_invoice_outbound_local_charge_flag", length));
			String[] autoInvObEml = (JSPUtil.getParameter(request, prefix	+ "auto_invoice_outbound_email", length));

			for (int i = 0; i < length; i++) {
				model = new CreateMdmCrCustVO();
				if (bzctNm[i] != null)
					model.setBzctNm(bzctNm[i]);
				if (bfrCrCltOfcCd[i] != null)
					model.setBfrCrCltOfcCd(bfrCrCltOfcCd[i]);
				if (bztpNm[i] != null)
					model.setBztpNm(bztpNm[i]);
				if (obCrTermDys[i] != null)
					model.setObCrTermDys(obCrTermDys[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cngIndivCd[i] != null)
					model.setCngIndivCd(cngIndivCd[i]);
				if (crAmt[i] != null)
					model.setCrAmt(crAmt[i]);
				if (dyXchAplyStDt[i] != null)
					model.setDyXchAplyStDt(dyXchAplyStDt[i]);
				if (crStDt[i] != null)
					model.setCrStDt(crStDt[i]);
				if (bfrOfcCngDt[i] != null)
					model.setBfrOfcCngDt(bfrOfcCngDt[i]);
				if (ibPhnNo[i] != null)
					model.setIbPhnNo(ibPhnNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (ibEml[i] != null)
					model.setIbEml(ibEml[i]);
				if (invIssCurrTpCd[i] != null)
					model.setInvIssCurrTpCd(invIssCurrTpCd[i]);
				if (obFaxNo[i] != null)
					model.setObFaxNo(obFaxNo[i]);
				if (rissInvFlg[i] != null)
					model.setRissInvFlg(rissInvFlg[i]);
				if (crCustRmk[i] != null)
					model.setCrCustRmk(crCustRmk[i]);
				if (obPhnNo[i] != null)
					model.setObPhnNo(obPhnNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (loclZipCd[i] != null)
					model.setLoclZipCd(loclZipCd[i]);
				if (bfrKrIbOfcCd[i] != null)
					model.setBfrKrIbOfcCd(bfrKrIbOfcCd[i]);
				if (ownrNm[i] != null)
					model.setOwnrNm(ownrNm[i]);
				if (xchRtDivCd[i] != null)
					model.setXchRtDivCd(xchRtDivCd[i]);
				if (issDivCd[i] != null)
					model.setIssDivCd(issDivCd[i]);
				if (bankAcctNo[i] != null)
					model.setBankAcctNo(bankAcctNo[i]);
				if (loclNm[i] != null)
					model.setLoclNm(loclNm[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (crCustTpCd[i] != null)
					model.setCrCustTpCd(crCustTpCd[i]);
				if (obEml[i] != null)
					model.setObEml(obEml[i]);
				if (custCrDueDtDivCd[i] != null)
					model.setCustCrDueDtDivCd(custCrDueDtDivCd[i]);
				if (crCltOfcCd[i] != null)
					model.setCrCltOfcCd(crCltOfcCd[i]);
				if (payDtDy4[i] != null)
					model.setPayDtDy4(payDtDy4[i]);
				if (ibCrTermDys[i] != null)
					model.setIbCrTermDys(ibCrTermDys[i]);
				if (payDtDy3[i] != null)
					model.setPayDtDy3(payDtDy3[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (payDtDy2[i] != null)
					model.setPayDtDy2(payDtDy2[i]);
				if (payDtDy1[i] != null)
					model.setPayDtDy1(payDtDy1[i]);
				if (loclAddr4[i] != null)
					model.setLoclAddr4(loclAddr4[i]);
				if (loclAddr3[i] != null)
					model.setLoclAddr3(loclAddr3[i]);
				if (cntcPsonNm[i] != null)
					model.setCntcPsonNm(cntcPsonNm[i]);
				if (loclAddr2[i] != null)
					model.setLoclAddr2(loclAddr2[i]);
				if (loclAddr1[i] != null)
					model.setLoclAddr1(loclAddr1[i]);
				if (actCustCntCd[i] != null)
					model.setActCustCntCd(actCustCntCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (payDivCd[i] != null)
					model.setPayDivCd(payDivCd[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (invDueDtDpFlg[i] != null)
					model.setInvDueDtDpFlg(invDueDtDpFlg[i]);
				if (eaiEvntDt[i] != null)
					model.setEaiEvntDt(eaiEvntDt[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (crFlg[i] != null)
					model.setCrFlg(crFlg[i]);
				if (ibFaxNo[i] != null)
					model.setIbFaxNo(ibFaxNo[i]);
				if (crCurrCd[i] != null)
					model.setCrCurrCd(crCurrCd[i]);
				if (custRlseCtrlFlg[i] != null)
					model.setCustRlseCtrlFlg(custRlseCtrlFlg[i]);
				if (krIbOfcCd[i] != null)
					model.setKrIbOfcCd(krIbOfcCd[i]);
				if (crEndDt[i] != null)
					model.setCrEndDt(crEndDt[i]);
				if (eaiIfId[i] != null)
					model.setEaiIfId(eaiIfId[i]);
				if (custRlseCtrlRmk[i] != null)
					model.setCustRlseCtrlRmk(custRlseCtrlRmk[i]);
				if (subSysNm[i] != null)
					model.setSubSysNm(subSysNm[i]);
				if (autoInvIbFlg[i] != null)
					model.setAutoInvIbFlg(autoInvIbFlg[i]);
				if (autoInvIbHjsRefNo[i] != null)
					model.setAutoInvIbHjsRefNo(autoInvIbHjsRefNo[i]);
				if (autoInvIbHjsRefPhnNo[i] != null)
					model.setAutoInvIbHjsRefPhnNo(autoInvIbHjsRefPhnNo[i]);
				if (autoInvIbCustRefNoFlg[i] != null)
					model.setAutoInvIbCustRefNoFlg(autoInvIbCustRefNoFlg[i]);
				if (autoInvIbLoclChgFlg[i] != null)
					model.setAutoInvIbLoclChgFlg(autoInvIbLoclChgFlg[i]);
				if (autoInvIbEml[i] != null)
					model.setAutoInvIbEml(autoInvIbEml[i]);
				if (autoInvObFlg[i] != null)
					model.setAutoInvObFlg(autoInvObFlg[i]);
				if (autoInvObHjsRefNo[i] != null)
					model.setAutoInvObHjsRefNo(autoInvObHjsRefNo[i]);
				if (autoInvObHjsRefPhnNo[i] != null)
					model.setAutoInvObHjsRefPhnNo(autoInvObHjsRefPhnNo[i]);
				if (autoInvObCustRefNoFlg[i] != null)
					model.setAutoInvObCustRefNoFlg(autoInvObCustRefNoFlg[i]);
				if (autoInvObLoclChgFlg[i] != null)
					model.setAutoInvObLoclChgFlg(autoInvObLoclChgFlg[i]);
				if (autoInvObEml[i] != null)
					model.setAutoInvObEml(autoInvObEml[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCreateMdmCrCustVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CreateMdmCrCustVO[]
	 */
	public CreateMdmCrCustVO[] getCreateMdmCrCustVOs(){
		CreateMdmCrCustVO[] vos = (CreateMdmCrCustVO[])models.toArray(new CreateMdmCrCustVO[models.size()]);
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
		this.bzctNm = this.bzctNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrCrCltOfcCd = this.bfrCrCltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bztpNm = this.bztpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCrTermDys = this.obCrTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngIndivCd = this.cngIndivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crAmt = this.crAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dyXchAplyStDt = this.dyXchAplyStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crStDt = this.crStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrOfcCngDt = this.bfrOfcCngDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibPhnNo = this.ibPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibEml = this.ibEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssCurrTpCd = this.invIssCurrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obFaxNo = this.obFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rissInvFlg = this.rissInvFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCustRmk = this.crCustRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obPhnNo = this.obPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclZipCd = this.loclZipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrKrIbOfcCd = this.bfrKrIbOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrNm = this.ownrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtDivCd = this.xchRtDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDivCd = this.issDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctNo = this.bankAcctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclNm = this.loclNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCustTpCd = this.crCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obEml = this.obEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCrDueDtDivCd = this.custCrDueDtDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCltOfcCd = this.crCltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDtDy4 = this.payDtDy4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCrTermDys = this.ibCrTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDtDy3 = this.payDtDy3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDtDy2 = this.payDtDy2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDtDy1 = this.payDtDy1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAddr4 = this.loclAddr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAddr3 = this.loclAddr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm = this.cntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAddr2 = this.loclAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAddr1 = this.loclAddr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd = this.actCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDivCd = this.payDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDueDtDpFlg = this.invDueDtDpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiEvntDt = this.eaiEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crFlg = this.crFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibFaxNo = this.ibFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCurrCd = this.crCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRlseCtrlFlg = this.custRlseCtrlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krIbOfcCd = this.krIbOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crEndDt = this.crEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiIfId = this.eaiIfId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRlseCtrlRmk = this.custRlseCtrlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subSysNm = this.subSysNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoInvIbFlg = this.autoInvIbFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoInvIbHjsRefNo = this.autoInvIbHjsRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoInvIbHjsRefPhnNo = this.autoInvIbHjsRefPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoInvIbCustRefNoFlg = this.autoInvIbCustRefNoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoInvIbLoclChgFlg = this.autoInvIbLoclChgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoInvIbEml = this.autoInvIbEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoInvObFlg = this.autoInvObFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoInvObHjsRefNo = this.autoInvObHjsRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoInvObHjsRefPhnNo = this.autoInvObHjsRefPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoInvObCustRefNoFlg = this.autoInvObCustRefNoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoInvObLoclChgFlg = this.autoInvObLoclChgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoInvObEml = this.autoInvObEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

}
