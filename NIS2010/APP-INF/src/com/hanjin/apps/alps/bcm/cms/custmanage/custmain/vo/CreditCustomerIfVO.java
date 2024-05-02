/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : CreditCustomerIfVO.java
*@FileTitle : CreditCustomerIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo;

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
public class CreditCustomerIfVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CreditCustomerIfVO> models = new ArrayList<CreditCustomerIfVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private String custCntCd = null;

	/* Column Info */
	private String custSeq = null;

	/* Column Info */
	private String actCustCntCd = null;

	/* Column Info */
	private String actCustSeq = null;

	/* Column Info */
	private String custRlseCtrlFlg = null;

	/* Column Info */
	private String crFlg = null;

	/* Column Info */
	private String crCurrCd = null;

	/* Column Info */
	private String crAmt = null;

	/* Column Info */
	private String crCltOfcCd = null;

	/* Column Info */
	private String crCltMstOfcId1 = null;

	/* Column Info */
	private String crCustRmk = null;

	/* Column Info */
	private String ibCrTermDys = null;

	/* Column Info */
	private String obCrTermDys = null;

	/* Column Info */
	private String payDivCd = null;

	/* Column Info */
	private String crStrtDt = null;

	/* Column Info */
	private String crEndDt = null;

	/* Column Info */
	private String crCustTpCd = null;

	/* Column Info */
	private String krIbOfcCd = null;

	/* Column Info */
	private String krIbMstOfcId = null;

	/* Column Info */
	private String obEml = null;

	/* Column Info */
	private String ibEml = null;

	/* Column Info */
	private String xchRtDivCd = null;

	/* Column Info */
	private String chngIndivCd = null;

	/* Column Info */
	private String dyXchApplStrtDt = null;

	/* Column Info */
	private String issDivCd = null;

	/* Column Info */
	private String bankAcctNo = null;

	/* Column Info */
	private String bfrCrCltOfcId = null;

	/* Column Info */
	private String bfrCrCltOfcCd = null;

	/* Column Info */
	private String bfrOfcChngDt = null;

	/* Column Info */
	private String bfrKrIbOfcId = null;

	/* Column Info */
	private String bfrKrIbOfcCd = null;

	/* Column Info */
	private String cntcPsonNm = null;

	/* Column Info */
	private String dueDtCrteDivCd = null;

	/* Column Info */
	private String payDtDy1 = null;

	/* Column Info */
	private String payDtDy2 = null;

	/* Column Info */
	private String payDtDy3 = null;

	/* Column Info */
	private String payDtDy4 = null;

	/* Column Info */
	private String loclNm = null;

	/* Column Info */
	private String loclAddr1 = null;

	/* Column Info */
	private String loclAddr2 = null;

	/* Column Info */
	private String loclAddr3 = null;

	/* Column Info */
	private String loclAddr4 = null;

	/* Column Info */
	private String loclZipCd = null;

	/* Column Info */
	private String ibPhnNo = null;

	/* Column Info */
	private String ibFaxNo = null;

	/* Column Info */
	private String creUsrId = null;

	/* Column Info */
	private String creDt = null;

	/* Column Info */
	private String updUsrId = null;

	/* Column Info */
	private String updDt = null;

	/* Column Info */
	private String deltFlg = null;

	/* Column Info */
	private String obPhnNo = null;

	/* Column Info */
	private String obFaxNo = null;

	/* Column Info */
	private String ownrNm = null;

	/* Column Info */
	private String bzctNm = null;

	/* Column Info */
	private String bztpDesc = null;

	/* Column Info */
	private String invDueDtDpFlg = null;

	/* Column Info */
	private String indivCorpDivCd = null;

	/* Column Info */
	private String custRgstNo = null;

	/* Column Info */
	private String rissInvFlg = null;

	/* Column Info */
	private String invIssCurrTpCd = null;

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
	private String autoRmdrSndFlg = null;

	/* Column Info */
	private String autoRmdrHjsRefNo = null;

	/* Column Info */
	private String autoRmdrHjsRefPhnno = null;

	/* Column Info */
	private String autoRmdrSndTermCd = null;

	/* Column Info */
	private String autoRmdrIbEml = null;

	/* Column Info */
	private String autoRmdrObEml = null;

	/* Column Info */
	private String localInfoRmrk = null;

	/* Column Info */
	private String payDtDy5 = null;

	/* Column Info */
	private String payWkDay = null;

	/* Column Info */
	private String payTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CreditCustomerIfVO() {}

	public CreditCustomerIfVO(String ibflag, String pagerows, String custCntCd, String custSeq, String actCustCntCd, String actCustSeq, String custRlseCtrlFlg, String crFlg, String crCurrCd, String crAmt, String crCltOfcCd, String crCltMstOfcId1, String crCustRmk, String ibCrTermDys, String obCrTermDys, String payDivCd, String crStrtDt, String crEndDt, String crCustTpCd, String krIbOfcCd, String krIbMstOfcId, String obEml, String ibEml, String xchRtDivCd, String chngIndivCd, String dyXchApplStrtDt, String issDivCd, String bankAcctNo, String bfrCrCltOfcId, String bfrCrCltOfcCd, String bfrOfcChngDt, String bfrKrIbOfcId, String bfrKrIbOfcCd, String cntcPsonNm, String dueDtCrteDivCd, String payDtDy1, String payDtDy2, String payDtDy3, String payDtDy4, String loclNm, String loclAddr1, String loclAddr2, String loclAddr3, String loclAddr4, String loclZipCd, String ibPhnNo, String ibFaxNo, String creUsrId, String creDt, String updUsrId, String updDt, String deltFlg, String obPhnNo, String obFaxNo, String ownrNm, String bzctNm, String bztpDesc, String invDueDtDpFlg, String indivCorpDivCd, String custRgstNo, String rissInvFlg, String invIssCurrTpCd, String custRlseCtrlRmk, String subSysNm, String autoInvIbFlg, String autoInvIbHjsRefNo, String autoInvIbHjsRefPhnNo, String autoInvIbCustRefNoFlg, String autoInvIbLoclChgFlg, String autoInvIbEml, String autoInvObFlg, String autoInvObHjsRefNo, String autoInvObHjsRefPhnNo, String autoInvObCustRefNoFlg, String autoInvObLoclChgFlg, String autoInvObEml, String autoRmdrSndFlg, String autoRmdrHjsRefNo, String autoRmdrHjsRefPhnno, String autoRmdrSndTermCd, String autoRmdrIbEml, String autoRmdrObEml, String localInfoRmrk, String payDtDy5, String payWkDay, String payTpCd) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.custCntCd = custCntCd;
		this.custSeq = custSeq;
		this.actCustCntCd = actCustCntCd;
		this.actCustSeq = actCustSeq;
		this.custRlseCtrlFlg = custRlseCtrlFlg;
		this.crFlg = crFlg;
		this.crCurrCd = crCurrCd;
		this.crAmt = crAmt;
		this.crCltOfcCd = crCltOfcCd;
		this.crCltMstOfcId1 = crCltMstOfcId1;
		this.crCustRmk = crCustRmk;
		this.ibCrTermDys = ibCrTermDys;
		this.obCrTermDys = obCrTermDys;
		this.payDivCd = payDivCd;
		this.crStrtDt = crStrtDt;
		this.crEndDt = crEndDt;
		this.crCustTpCd = crCustTpCd;
		this.krIbOfcCd = krIbOfcCd;
		this.krIbMstOfcId = krIbMstOfcId;
		this.obEml = obEml;
		this.ibEml = ibEml;
		this.xchRtDivCd = xchRtDivCd;
		this.chngIndivCd = chngIndivCd;
		this.dyXchApplStrtDt = dyXchApplStrtDt;
		this.issDivCd = issDivCd;
		this.bankAcctNo = bankAcctNo;
		this.bfrCrCltOfcId = bfrCrCltOfcId;
		this.bfrCrCltOfcCd = bfrCrCltOfcCd;
		this.bfrOfcChngDt = bfrOfcChngDt;
		this.bfrKrIbOfcId = bfrKrIbOfcId;
		this.bfrKrIbOfcCd = bfrKrIbOfcCd;
		this.cntcPsonNm = cntcPsonNm;
		this.dueDtCrteDivCd = dueDtCrteDivCd;
		this.payDtDy1 = payDtDy1;
		this.payDtDy2 = payDtDy2;
		this.payDtDy3 = payDtDy3;
		this.payDtDy4 = payDtDy4;
		this.loclNm = loclNm;
		this.loclAddr1 = loclAddr1;
		this.loclAddr2 = loclAddr2;
		this.loclAddr3 = loclAddr3;
		this.loclAddr4 = loclAddr4;
		this.loclZipCd = loclZipCd;
		this.ibPhnNo = ibPhnNo;
		this.ibFaxNo = ibFaxNo;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.deltFlg = deltFlg;
		this.obPhnNo = obPhnNo;
		this.obFaxNo = obFaxNo;
		this.ownrNm = ownrNm;
		this.bzctNm = bzctNm;
		this.bztpDesc = bztpDesc;
		this.invDueDtDpFlg = invDueDtDpFlg;
		this.indivCorpDivCd = indivCorpDivCd;
		this.custRgstNo = custRgstNo;
		this.rissInvFlg = rissInvFlg;
		this.invIssCurrTpCd = invIssCurrTpCd;
		this.custRlseCtrlRmk = custRlseCtrlRmk;
		this.subSysNm = subSysNm;
		this.autoInvIbFlg = autoInvIbFlg;
		this.autoInvIbHjsRefNo = autoInvIbHjsRefNo;
		this.autoInvIbHjsRefPhnNo = autoInvIbHjsRefPhnNo;
		this.autoInvIbCustRefNoFlg = autoInvIbCustRefNoFlg;
		this.autoInvIbLoclChgFlg = autoInvIbLoclChgFlg;
		this.autoInvIbEml = autoInvIbEml;
		this.autoInvObFlg = autoInvObFlg;
		this.autoInvObHjsRefNo = autoInvObHjsRefNo;
		this.autoInvObHjsRefPhnNo = autoInvObHjsRefPhnNo;
		this.autoInvObCustRefNoFlg = autoInvObCustRefNoFlg;
		this.autoInvObLoclChgFlg = autoInvObLoclChgFlg;
		this.autoInvObEml = autoInvObEml;
		this.autoRmdrSndFlg = autoRmdrSndFlg;
		this.autoRmdrHjsRefNo = autoRmdrHjsRefNo;
		this.autoRmdrHjsRefPhnno = autoRmdrHjsRefPhnno;
		this.autoRmdrSndTermCd = autoRmdrSndTermCd;
		this.autoRmdrIbEml = autoRmdrIbEml;
		this.autoRmdrObEml = autoRmdrObEml;
		this.localInfoRmrk = localInfoRmrk;
		this.payDtDy5 = payDtDy5;
		this.payWkDay = payWkDay;
		this.payTpCd = payTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("cust_rlse_ctrl_flg", getCustRlseCtrlFlg());
		this.hashColumns.put("cr_flg", getCrFlg());
		this.hashColumns.put("cr_curr_cd", getCrCurrCd());
		this.hashColumns.put("cr_amt", getCrAmt());
		this.hashColumns.put("cr_clt_ofc_cd", getCrCltOfcCd());
		this.hashColumns.put("cr_clt_mst_ofc_id1", getCrCltMstOfcId1());
		this.hashColumns.put("cr_cust_rmk", getCrCustRmk());
		this.hashColumns.put("ib_cr_term_dys", getIbCrTermDys());
		this.hashColumns.put("ob_cr_term_dys", getObCrTermDys());
		this.hashColumns.put("pay_div_cd", getPayDivCd());
		this.hashColumns.put("cr_strt_dt", getCrStrtDt());
		this.hashColumns.put("cr_end_dt", getCrEndDt());
		this.hashColumns.put("cr_cust_tp_cd", getCrCustTpCd());
		this.hashColumns.put("kr_ib_ofc_cd", getKrIbOfcCd());
		this.hashColumns.put("kr_ib_mst_ofc_id", getKrIbMstOfcId());
		this.hashColumns.put("ob_eml", getObEml());
		this.hashColumns.put("ib_eml", getIbEml());
		this.hashColumns.put("xch_rt_div_cd", getXchRtDivCd());
		this.hashColumns.put("chng_indiv_cd", getChngIndivCd());
		this.hashColumns.put("dy_xch_appl_strt_dt", getDyXchApplStrtDt());
		this.hashColumns.put("iss_div_cd", getIssDivCd());
		this.hashColumns.put("bank_acct_no", getBankAcctNo());
		this.hashColumns.put("bfr_cr_clt_ofc_id", getBfrCrCltOfcId());
		this.hashColumns.put("bfr_cr_clt_ofc_cd", getBfrCrCltOfcCd());
		this.hashColumns.put("bfr_ofc_chng_dt", getBfrOfcChngDt());
		this.hashColumns.put("bfr_kr_ib_ofc_id", getBfrKrIbOfcId());
		this.hashColumns.put("bfr_kr_ib_ofc_cd", getBfrKrIbOfcCd());
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
		this.hashColumns.put("due_dt_crte_div_cd", getDueDtCrteDivCd());
		this.hashColumns.put("pay_dt_dy1", getPayDtDy1());
		this.hashColumns.put("pay_dt_dy2", getPayDtDy2());
		this.hashColumns.put("pay_dt_dy3", getPayDtDy3());
		this.hashColumns.put("pay_dt_dy4", getPayDtDy4());
		this.hashColumns.put("locl_nm", getLoclNm());
		this.hashColumns.put("locl_addr1", getLoclAddr1());
		this.hashColumns.put("locl_addr2", getLoclAddr2());
		this.hashColumns.put("locl_addr3", getLoclAddr3());
		this.hashColumns.put("locl_addr4", getLoclAddr4());
		this.hashColumns.put("locl_zip_cd", getLoclZipCd());
		this.hashColumns.put("ib_phn_no", getIbPhnNo());
		this.hashColumns.put("ib_fax_no", getIbFaxNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("ob_phn_no", getObPhnNo());
		this.hashColumns.put("ob_fax_no", getObFaxNo());
		this.hashColumns.put("ownr_nm", getOwnrNm());
		this.hashColumns.put("bzct_nm", getBzctNm());
		this.hashColumns.put("bztp_desc", getBztpDesc());
		this.hashColumns.put("inv_due_dt_dp_flg", getInvDueDtDpFlg());
		this.hashColumns.put("indiv_corp_div_cd", getIndivCorpDivCd());
		this.hashColumns.put("cust_rgst_no", getCustRgstNo());
		this.hashColumns.put("riss_inv_flg", getRissInvFlg());
		this.hashColumns.put("inv_iss_curr_tp_cd", getInvIssCurrTpCd());
		this.hashColumns.put("cust_rlse_ctrl_rmk", getCustRlseCtrlRmk());
		this.hashColumns.put("sub_sys_nm", getSubSysNm());
		this.hashColumns.put("auto_inv_ib_flg", getAutoInvIbFlg());
		this.hashColumns.put("auto_inv_ib_hjs_ref_no", getAutoInvIbHjsRefNo());
		this.hashColumns.put("auto_inv_ib_hjs_ref_phn_no", getAutoInvIbHjsRefPhnNo());
		this.hashColumns.put("auto_inv_ib_cust_ref_no_flg", getAutoInvIbCustRefNoFlg());
		this.hashColumns.put("auto_inv_ib_locl_chg_flg", getAutoInvIbLoclChgFlg());
		this.hashColumns.put("auto_inv_ib_eml", getAutoInvIbEml());
		this.hashColumns.put("auto_inv_ob_flg", getAutoInvObFlg());
		this.hashColumns.put("auto_inv_ob_hjs_ref_no", getAutoInvObHjsRefNo());
		this.hashColumns.put("auto_inv_ob_hjs_ref_phn_no", getAutoInvObHjsRefPhnNo());
		this.hashColumns.put("auto_inv_ob_cust_ref_no_flg", getAutoInvObCustRefNoFlg());
		this.hashColumns.put("auto_inv_ob_locl_chg_flg", getAutoInvObLoclChgFlg());
		this.hashColumns.put("auto_inv_ob_eml", getAutoInvObEml());
		this.hashColumns.put("auto_rmdr_snd_flg", getAutoRmdrSndFlg());
		this.hashColumns.put("auto_rmdr_hjs_ref_no", getAutoRmdrHjsRefNo());
		this.hashColumns.put("auto_rmdr_hjs_ref_phnno", getAutoRmdrHjsRefPhnno());
		this.hashColumns.put("auto_rmdr_snd_term_cd", getAutoRmdrSndTermCd());
		this.hashColumns.put("auto_rmdr_ib_eml", getAutoRmdrIbEml());
		this.hashColumns.put("auto_rmdr_ob_eml", getAutoRmdrObEml());
		this.hashColumns.put("local_info_rmrk", getLocalInfoRmrk());
		this.hashColumns.put("pay_dt_dy5", getPayDtDy5());
		this.hashColumns.put("pay_wk_day", getPayWkDay());
		this.hashColumns.put("pay_tp_cd", getPayTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("cust_rlse_ctrl_flg", "custRlseCtrlFlg");
		this.hashFields.put("cr_flg", "crFlg");
		this.hashFields.put("cr_curr_cd", "crCurrCd");
		this.hashFields.put("cr_amt", "crAmt");
		this.hashFields.put("cr_clt_ofc_cd", "crCltOfcCd");
		this.hashFields.put("cr_clt_mst_ofc_id1", "crCltMstOfcId1");
		this.hashFields.put("cr_cust_rmk", "crCustRmk");
		this.hashFields.put("ib_cr_term_dys", "ibCrTermDys");
		this.hashFields.put("ob_cr_term_dys", "obCrTermDys");
		this.hashFields.put("pay_div_cd", "payDivCd");
		this.hashFields.put("cr_strt_dt", "crStrtDt");
		this.hashFields.put("cr_end_dt", "crEndDt");
		this.hashFields.put("cr_cust_tp_cd", "crCustTpCd");
		this.hashFields.put("kr_ib_ofc_cd", "krIbOfcCd");
		this.hashFields.put("kr_ib_mst_ofc_id", "krIbMstOfcId");
		this.hashFields.put("ob_eml", "obEml");
		this.hashFields.put("ib_eml", "ibEml");
		this.hashFields.put("xch_rt_div_cd", "xchRtDivCd");
		this.hashFields.put("chng_indiv_cd", "chngIndivCd");
		this.hashFields.put("dy_xch_appl_strt_dt", "dyXchApplStrtDt");
		this.hashFields.put("iss_div_cd", "issDivCd");
		this.hashFields.put("bank_acct_no", "bankAcctNo");
		this.hashFields.put("bfr_cr_clt_ofc_id", "bfrCrCltOfcId");
		this.hashFields.put("bfr_cr_clt_ofc_cd", "bfrCrCltOfcCd");
		this.hashFields.put("bfr_ofc_chng_dt", "bfrOfcChngDt");
		this.hashFields.put("bfr_kr_ib_ofc_id", "bfrKrIbOfcId");
		this.hashFields.put("bfr_kr_ib_ofc_cd", "bfrKrIbOfcCd");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
		this.hashFields.put("due_dt_crte_div_cd", "dueDtCrteDivCd");
		this.hashFields.put("pay_dt_dy1", "payDtDy1");
		this.hashFields.put("pay_dt_dy2", "payDtDy2");
		this.hashFields.put("pay_dt_dy3", "payDtDy3");
		this.hashFields.put("pay_dt_dy4", "payDtDy4");
		this.hashFields.put("locl_nm", "loclNm");
		this.hashFields.put("locl_addr1", "loclAddr1");
		this.hashFields.put("locl_addr2", "loclAddr2");
		this.hashFields.put("locl_addr3", "loclAddr3");
		this.hashFields.put("locl_addr4", "loclAddr4");
		this.hashFields.put("locl_zip_cd", "loclZipCd");
		this.hashFields.put("ib_phn_no", "ibPhnNo");
		this.hashFields.put("ib_fax_no", "ibFaxNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("ob_phn_no", "obPhnNo");
		this.hashFields.put("ob_fax_no", "obFaxNo");
		this.hashFields.put("ownr_nm", "ownrNm");
		this.hashFields.put("bzct_nm", "bzctNm");
		this.hashFields.put("bztp_desc", "bztpDesc");
		this.hashFields.put("inv_due_dt_dp_flg", "invDueDtDpFlg");
		this.hashFields.put("indiv_corp_div_cd", "indivCorpDivCd");
		this.hashFields.put("cust_rgst_no", "custRgstNo");
		this.hashFields.put("riss_inv_flg", "rissInvFlg");
		this.hashFields.put("inv_iss_curr_tp_cd", "invIssCurrTpCd");
		this.hashFields.put("cust_rlse_ctrl_rmk", "custRlseCtrlRmk");
		this.hashFields.put("sub_sys_nm", "subSysNm");
		this.hashFields.put("auto_inv_ib_flg", "autoInvIbFlg");
		this.hashFields.put("auto_inv_ib_hjs_ref_no", "autoInvIbHjsRefNo");
		this.hashFields.put("auto_inv_ib_hjs_ref_phn_no", "autoInvIbHjsRefPhnNo");
		this.hashFields.put("auto_inv_ib_cust_ref_no_flg", "autoInvIbCustRefNoFlg");
		this.hashFields.put("auto_inv_ib_locl_chg_flg", "autoInvIbLoclChgFlg");
		this.hashFields.put("auto_inv_ib_eml", "autoInvIbEml");
		this.hashFields.put("auto_inv_ob_flg", "autoInvObFlg");
		this.hashFields.put("auto_inv_ob_hjs_ref_no", "autoInvObHjsRefNo");
		this.hashFields.put("auto_inv_ob_hjs_ref_phn_no", "autoInvObHjsRefPhnNo");
		this.hashFields.put("auto_inv_ob_cust_ref_no_flg", "autoInvObCustRefNoFlg");
		this.hashFields.put("auto_inv_ob_locl_chg_flg", "autoInvObLoclChgFlg");
		this.hashFields.put("auto_inv_ob_eml", "autoInvObEml");
		this.hashFields.put("auto_rmdr_snd_flg", "autoRmdrSndFlg");
		this.hashFields.put("auto_rmdr_hjs_ref_no", "autoRmdrHjsRefNo");
		this.hashFields.put("auto_rmdr_hjs_ref_phnno", "autoRmdrHjsRefPhnno");
		this.hashFields.put("auto_rmdr_snd_term_cd", "autoRmdrSndTermCd");
		this.hashFields.put("auto_rmdr_ib_eml", "autoRmdrIbEml");
		this.hashFields.put("auto_rmdr_ob_eml", "autoRmdrObEml");
		this.hashFields.put("local_info_rmrk", "localInfoRmrk");
		this.hashFields.put("pay_dt_dy5", "payDtDy5");
		this.hashFields.put("pay_wk_day", "payWkDay");
		this.hashFields.put("pay_tp_cd", "payTpCd");
		return this.hashFields;
	}
	
	/**
	 *
	 * @param String ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * 
	 * @return String ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 *
	 * @param String pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * 
	 * @return String pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 *
	 * @param String custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * 
	 * @return String custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 *
	 * @param String custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * 
	 * @return String custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 *
	 * @param String actCustCntCd
	 */
	public void setActCustCntCd(String actCustCntCd) {
		this.actCustCntCd = actCustCntCd;
	}
	
	/**
	 * 
	 * @return String actCustCntCd
	 */
	public String getActCustCntCd() {
		return this.actCustCntCd;
	}
	
	/**
	 *
	 * @param String actCustSeq
	 */
	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
	}
	
	/**
	 * 
	 * @return String actCustSeq
	 */
	public String getActCustSeq() {
		return this.actCustSeq;
	}
	
	/**
	 *
	 * @param String custRlseCtrlFlg
	 */
	public void setCustRlseCtrlFlg(String custRlseCtrlFlg) {
		this.custRlseCtrlFlg = custRlseCtrlFlg;
	}
	
	/**
	 * 
	 * @return String custRlseCtrlFlg
	 */
	public String getCustRlseCtrlFlg() {
		return this.custRlseCtrlFlg;
	}
	
	/**
	 *
	 * @param String crFlg
	 */
	public void setCrFlg(String crFlg) {
		this.crFlg = crFlg;
	}
	
	/**
	 * 
	 * @return String crFlg
	 */
	public String getCrFlg() {
		return this.crFlg;
	}
	
	/**
	 *
	 * @param String crCurrCd
	 */
	public void setCrCurrCd(String crCurrCd) {
		this.crCurrCd = crCurrCd;
	}
	
	/**
	 * 
	 * @return String crCurrCd
	 */
	public String getCrCurrCd() {
		return this.crCurrCd;
	}
	
	/**
	 *
	 * @param String crAmt
	 */
	public void setCrAmt(String crAmt) {
		this.crAmt = crAmt;
	}
	
	/**
	 * 
	 * @return String crAmt
	 */
	public String getCrAmt() {
		return this.crAmt;
	}
	
	/**
	 *
	 * @param String crCltOfcCd
	 */
	public void setCrCltOfcCd(String crCltOfcCd) {
		this.crCltOfcCd = crCltOfcCd;
	}
	
	/**
	 * 
	 * @return String crCltOfcCd
	 */
	public String getCrCltOfcCd() {
		return this.crCltOfcCd;
	}
	
	/**
	 *
	 * @param String crCltMstOfcId1
	 */
	public void setCrCltMstOfcId1(String crCltMstOfcId1) {
		this.crCltMstOfcId1 = crCltMstOfcId1;
	}
	
	/**
	 * 
	 * @return String crCltMstOfcId1
	 */
	public String getCrCltMstOfcId1() {
		return this.crCltMstOfcId1;
	}
	
	/**
	 *
	 * @param String crCustRmk
	 */
	public void setCrCustRmk(String crCustRmk) {
		this.crCustRmk = crCustRmk;
	}
	
	/**
	 * 
	 * @return String crCustRmk
	 */
	public String getCrCustRmk() {
		return this.crCustRmk;
	}
	
	/**
	 *
	 * @param String ibCrTermDys
	 */
	public void setIbCrTermDys(String ibCrTermDys) {
		this.ibCrTermDys = ibCrTermDys;
	}
	
	/**
	 * 
	 * @return String ibCrTermDys
	 */
	public String getIbCrTermDys() {
		return this.ibCrTermDys;
	}
	
	/**
	 *
	 * @param String obCrTermDys
	 */
	public void setObCrTermDys(String obCrTermDys) {
		this.obCrTermDys = obCrTermDys;
	}
	
	/**
	 * 
	 * @return String obCrTermDys
	 */
	public String getObCrTermDys() {
		return this.obCrTermDys;
	}
	
	/**
	 *
	 * @param String payDivCd
	 */
	public void setPayDivCd(String payDivCd) {
		this.payDivCd = payDivCd;
	}
	
	/**
	 * 
	 * @return String payDivCd
	 */
	public String getPayDivCd() {
		return this.payDivCd;
	}
	
	/**
	 *
	 * @param String crStrtDt
	 */
	public void setCrStrtDt(String crStrtDt) {
		this.crStrtDt = crStrtDt;
	}
	
	/**
	 * 
	 * @return String crStrtDt
	 */
	public String getCrStrtDt() {
		return this.crStrtDt;
	}
	
	/**
	 *
	 * @param String crEndDt
	 */
	public void setCrEndDt(String crEndDt) {
		this.crEndDt = crEndDt;
	}
	
	/**
	 * 
	 * @return String crEndDt
	 */
	public String getCrEndDt() {
		return this.crEndDt;
	}
	
	/**
	 *
	 * @param String crCustTpCd
	 */
	public void setCrCustTpCd(String crCustTpCd) {
		this.crCustTpCd = crCustTpCd;
	}
	
	/**
	 * 
	 * @return String crCustTpCd
	 */
	public String getCrCustTpCd() {
		return this.crCustTpCd;
	}
	
	/**
	 *
	 * @param String krIbOfcCd
	 */
	public void setKrIbOfcCd(String krIbOfcCd) {
		this.krIbOfcCd = krIbOfcCd;
	}
	
	/**
	 * 
	 * @return String krIbOfcCd
	 */
	public String getKrIbOfcCd() {
		return this.krIbOfcCd;
	}
	
	/**
	 *
	 * @param String krIbMstOfcId
	 */
	public void setKrIbMstOfcId(String krIbMstOfcId) {
		this.krIbMstOfcId = krIbMstOfcId;
	}
	
	/**
	 * 
	 * @return String krIbMstOfcId
	 */
	public String getKrIbMstOfcId() {
		return this.krIbMstOfcId;
	}
	
	/**
	 *
	 * @param String obEml
	 */
	public void setObEml(String obEml) {
		this.obEml = obEml;
	}
	
	/**
	 * 
	 * @return String obEml
	 */
	public String getObEml() {
		return this.obEml;
	}
	
	/**
	 *
	 * @param String ibEml
	 */
	public void setIbEml(String ibEml) {
		this.ibEml = ibEml;
	}
	
	/**
	 * 
	 * @return String ibEml
	 */
	public String getIbEml() {
		return this.ibEml;
	}
	
	/**
	 *
	 * @param String xchRtDivCd
	 */
	public void setXchRtDivCd(String xchRtDivCd) {
		this.xchRtDivCd = xchRtDivCd;
	}
	
	/**
	 * 
	 * @return String xchRtDivCd
	 */
	public String getXchRtDivCd() {
		return this.xchRtDivCd;
	}
	
	/**
	 *
	 * @param String chngIndivCd
	 */
	public void setChngIndivCd(String chngIndivCd) {
		this.chngIndivCd = chngIndivCd;
	}
	
	/**
	 * 
	 * @return String chngIndivCd
	 */
	public String getChngIndivCd() {
		return this.chngIndivCd;
	}
	
	/**
	 *
	 * @param String dyXchApplStrtDt
	 */
	public void setDyXchApplStrtDt(String dyXchApplStrtDt) {
		this.dyXchApplStrtDt = dyXchApplStrtDt;
	}
	
	/**
	 * 
	 * @return String dyXchApplStrtDt
	 */
	public String getDyXchApplStrtDt() {
		return this.dyXchApplStrtDt;
	}
	
	/**
	 *
	 * @param String issDivCd
	 */
	public void setIssDivCd(String issDivCd) {
		this.issDivCd = issDivCd;
	}
	
	/**
	 * 
	 * @return String issDivCd
	 */
	public String getIssDivCd() {
		return this.issDivCd;
	}
	
	/**
	 *
	 * @param String bankAcctNo
	 */
	public void setBankAcctNo(String bankAcctNo) {
		this.bankAcctNo = bankAcctNo;
	}
	
	/**
	 * 
	 * @return String bankAcctNo
	 */
	public String getBankAcctNo() {
		return this.bankAcctNo;
	}
	
	/**
	 *
	 * @param String bfrCrCltOfcId
	 */
	public void setBfrCrCltOfcId(String bfrCrCltOfcId) {
		this.bfrCrCltOfcId = bfrCrCltOfcId;
	}
	
	/**
	 * 
	 * @return String bfrCrCltOfcId
	 */
	public String getBfrCrCltOfcId() {
		return this.bfrCrCltOfcId;
	}
	
	/**
	 *
	 * @param String bfrCrCltOfcCd
	 */
	public void setBfrCrCltOfcCd(String bfrCrCltOfcCd) {
		this.bfrCrCltOfcCd = bfrCrCltOfcCd;
	}
	
	/**
	 * 
	 * @return String bfrCrCltOfcCd
	 */
	public String getBfrCrCltOfcCd() {
		return this.bfrCrCltOfcCd;
	}
	
	/**
	 *
	 * @param String bfrOfcChngDt
	 */
	public void setBfrOfcChngDt(String bfrOfcChngDt) {
		this.bfrOfcChngDt = bfrOfcChngDt;
	}
	
	/**
	 * 
	 * @return String bfrOfcChngDt
	 */
	public String getBfrOfcChngDt() {
		return this.bfrOfcChngDt;
	}
	
	/**
	 *
	 * @param String bfrKrIbOfcId
	 */
	public void setBfrKrIbOfcId(String bfrKrIbOfcId) {
		this.bfrKrIbOfcId = bfrKrIbOfcId;
	}
	
	/**
	 * 
	 * @return String bfrKrIbOfcId
	 */
	public String getBfrKrIbOfcId() {
		return this.bfrKrIbOfcId;
	}
	
	/**
	 *
	 * @param String bfrKrIbOfcCd
	 */
	public void setBfrKrIbOfcCd(String bfrKrIbOfcCd) {
		this.bfrKrIbOfcCd = bfrKrIbOfcCd;
	}
	
	/**
	 * 
	 * @return String bfrKrIbOfcCd
	 */
	public String getBfrKrIbOfcCd() {
		return this.bfrKrIbOfcCd;
	}
	
	/**
	 *
	 * @param String cntcPsonNm
	 */
	public void setCntcPsonNm(String cntcPsonNm) {
		this.cntcPsonNm = cntcPsonNm;
	}
	
	/**
	 * 
	 * @return String cntcPsonNm
	 */
	public String getCntcPsonNm() {
		return this.cntcPsonNm;
	}
	
	/**
	 *
	 * @param String dueDtCrteDivCd
	 */
	public void setDueDtCrteDivCd(String dueDtCrteDivCd) {
		this.dueDtCrteDivCd = dueDtCrteDivCd;
	}
	
	/**
	 * 
	 * @return String dueDtCrteDivCd
	 */
	public String getDueDtCrteDivCd() {
		return this.dueDtCrteDivCd;
	}
	
	/**
	 *
	 * @param String payDtDy1
	 */
	public void setPayDtDy1(String payDtDy1) {
		this.payDtDy1 = payDtDy1;
	}
	
	/**
	 * 
	 * @return String payDtDy1
	 */
	public String getPayDtDy1() {
		return this.payDtDy1;
	}
	
	/**
	 *
	 * @param String payDtDy2
	 */
	public void setPayDtDy2(String payDtDy2) {
		this.payDtDy2 = payDtDy2;
	}
	
	/**
	 * 
	 * @return String payDtDy2
	 */
	public String getPayDtDy2() {
		return this.payDtDy2;
	}
	
	/**
	 *
	 * @param String payDtDy3
	 */
	public void setPayDtDy3(String payDtDy3) {
		this.payDtDy3 = payDtDy3;
	}
	
	/**
	 * 
	 * @return String payDtDy3
	 */
	public String getPayDtDy3() {
		return this.payDtDy3;
	}
	
	/**
	 *
	 * @param String payDtDy4
	 */
	public void setPayDtDy4(String payDtDy4) {
		this.payDtDy4 = payDtDy4;
	}
	
	/**
	 * 
	 * @return String payDtDy4
	 */
	public String getPayDtDy4() {
		return this.payDtDy4;
	}
	
	/**
	 *
	 * @param String loclNm
	 */
	public void setLoclNm(String loclNm) {
		this.loclNm = loclNm;
	}
	
	/**
	 * 
	 * @return String loclNm
	 */
	public String getLoclNm() {
		return this.loclNm;
	}
	
	/**
	 *
	 * @param String loclAddr1
	 */
	public void setLoclAddr1(String loclAddr1) {
		this.loclAddr1 = loclAddr1;
	}
	
	/**
	 * 
	 * @return String loclAddr1
	 */
	public String getLoclAddr1() {
		return this.loclAddr1;
	}
	
	/**
	 *
	 * @param String loclAddr2
	 */
	public void setLoclAddr2(String loclAddr2) {
		this.loclAddr2 = loclAddr2;
	}
	
	/**
	 * 
	 * @return String loclAddr2
	 */
	public String getLoclAddr2() {
		return this.loclAddr2;
	}
	
	/**
	 *
	 * @param String loclAddr3
	 */
	public void setLoclAddr3(String loclAddr3) {
		this.loclAddr3 = loclAddr3;
	}
	
	/**
	 * 
	 * @return String loclAddr3
	 */
	public String getLoclAddr3() {
		return this.loclAddr3;
	}
	
	/**
	 *
	 * @param String loclAddr4
	 */
	public void setLoclAddr4(String loclAddr4) {
		this.loclAddr4 = loclAddr4;
	}
	
	/**
	 * 
	 * @return String loclAddr4
	 */
	public String getLoclAddr4() {
		return this.loclAddr4;
	}
	
	/**
	 *
	 * @param String loclZipCd
	 */
	public void setLoclZipCd(String loclZipCd) {
		this.loclZipCd = loclZipCd;
	}
	
	/**
	 * 
	 * @return String loclZipCd
	 */
	public String getLoclZipCd() {
		return this.loclZipCd;
	}
	
	/**
	 *
	 * @param String ibPhnNo
	 */
	public void setIbPhnNo(String ibPhnNo) {
		this.ibPhnNo = ibPhnNo;
	}
	
	/**
	 * 
	 * @return String ibPhnNo
	 */
	public String getIbPhnNo() {
		return this.ibPhnNo;
	}
	
	/**
	 *
	 * @param String ibFaxNo
	 */
	public void setIbFaxNo(String ibFaxNo) {
		this.ibFaxNo = ibFaxNo;
	}
	
	/**
	 * 
	 * @return String ibFaxNo
	 */
	public String getIbFaxNo() {
		return this.ibFaxNo;
	}
	
	/**
	 *
	 * @param String creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * 
	 * @return String creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 *
	 * @param String creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * 
	 * @return String creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 *
	 * @param String updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 
	 * @return String updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 *
	 * @param String updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * 
	 * @return String updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 *
	 * @param String deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * 
	 * @return String deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 *
	 * @param String obPhnNo
	 */
	public void setObPhnNo(String obPhnNo) {
		this.obPhnNo = obPhnNo;
	}
	
	/**
	 * 
	 * @return String obPhnNo
	 */
	public String getObPhnNo() {
		return this.obPhnNo;
	}
	
	/**
	 *
	 * @param String obFaxNo
	 */
	public void setObFaxNo(String obFaxNo) {
		this.obFaxNo = obFaxNo;
	}
	
	/**
	 * 
	 * @return String obFaxNo
	 */
	public String getObFaxNo() {
		return this.obFaxNo;
	}
	
	/**
	 *
	 * @param String ownrNm
	 */
	public void setOwnrNm(String ownrNm) {
		this.ownrNm = ownrNm;
	}
	
	/**
	 * 
	 * @return String ownrNm
	 */
	public String getOwnrNm() {
		return this.ownrNm;
	}
	
	/**
	 *
	 * @param String bzctNm
	 */
	public void setBzctNm(String bzctNm) {
		this.bzctNm = bzctNm;
	}
	
	/**
	 * 
	 * @return String bzctNm
	 */
	public String getBzctNm() {
		return this.bzctNm;
	}
	
	/**
	 *
	 * @param String bztpDesc
	 */
	public void setBztpDesc(String bztpDesc) {
		this.bztpDesc = bztpDesc;
	}
	
	/**
	 * 
	 * @return String bztpDesc
	 */
	public String getBztpDesc() {
		return this.bztpDesc;
	}
	
	/**
	 *
	 * @param String invDueDtDpFlg
	 */
	public void setInvDueDtDpFlg(String invDueDtDpFlg) {
		this.invDueDtDpFlg = invDueDtDpFlg;
	}
	
	/**
	 * 
	 * @return String invDueDtDpFlg
	 */
	public String getInvDueDtDpFlg() {
		return this.invDueDtDpFlg;
	}
	
	/**
	 *
	 * @param String indivCorpDivCd
	 */
	public void setIndivCorpDivCd(String indivCorpDivCd) {
		this.indivCorpDivCd = indivCorpDivCd;
	}
	
	/**
	 * 
	 * @return String indivCorpDivCd
	 */
	public String getIndivCorpDivCd() {
		return this.indivCorpDivCd;
	}
	
	/**
	 *
	 * @param String custRgstNo
	 */
	public void setCustRgstNo(String custRgstNo) {
		this.custRgstNo = custRgstNo;
	}
	
	/**
	 * 
	 * @return String custRgstNo
	 */
	public String getCustRgstNo() {
		return this.custRgstNo;
	}
	
	/**
	 *
	 * @param String rissInvFlg
	 */
	public void setRissInvFlg(String rissInvFlg) {
		this.rissInvFlg = rissInvFlg;
	}
	
	/**
	 * 
	 * @return String rissInvFlg
	 */
	public String getRissInvFlg() {
		return this.rissInvFlg;
	}
	
	/**
	 *
	 * @param String invIssCurrTpCd
	 */
	public void setInvIssCurrTpCd(String invIssCurrTpCd) {
		this.invIssCurrTpCd = invIssCurrTpCd;
	}
	
	/**
	 * 
	 * @return String invIssCurrTpCd
	 */
	public String getInvIssCurrTpCd() {
		return this.invIssCurrTpCd;
	}
	
	/**
	 *
	 * @param String custRlseCtrlRmk
	 */
	public void setCustRlseCtrlRmk(String custRlseCtrlRmk) {
		this.custRlseCtrlRmk = custRlseCtrlRmk;
	}
	
	/**
	 * 
	 * @return String custRlseCtrlRmk
	 */
	public String getCustRlseCtrlRmk() {
		return this.custRlseCtrlRmk;
	}
	
	/**
	 *
	 * @param String subSysNm
	 */
	public void setSubSysNm(String subSysNm) {
		this.subSysNm = subSysNm;
	}
	
	/**
	 * 
	 * @return String subSysNm
	 */
	public String getSubSysNm() {
		return this.subSysNm;
	}
	
	/**
	 *
	 * @param String autoInvIbFlg
	 */
	public void setAutoInvIbFlg(String autoInvIbFlg) {
		this.autoInvIbFlg = autoInvIbFlg;
	}
	
	/**
	 * 
	 * @return String autoInvIbFlg
	 */
	public String getAutoInvIbFlg() {
		return this.autoInvIbFlg;
	}
	
	/**
	 *
	 * @param String autoInvIbHjsRefNo
	 */
	public void setAutoInvIbHjsRefNo(String autoInvIbHjsRefNo) {
		this.autoInvIbHjsRefNo = autoInvIbHjsRefNo;
	}
	
	/**
	 * 
	 * @return String autoInvIbHjsRefNo
	 */
	public String getAutoInvIbHjsRefNo() {
		return this.autoInvIbHjsRefNo;
	}
	
	/**
	 *
	 * @param String autoInvIbHjsRefPhnNo
	 */
	public void setAutoInvIbHjsRefPhnNo(String autoInvIbHjsRefPhnNo) {
		this.autoInvIbHjsRefPhnNo = autoInvIbHjsRefPhnNo;
	}
	
	/**
	 * 
	 * @return String autoInvIbHjsRefPhnNo
	 */
	public String getAutoInvIbHjsRefPhnNo() {
		return this.autoInvIbHjsRefPhnNo;
	}
	
	/**
	 *
	 * @param String autoInvIbCustRefNoFlg
	 */
	public void setAutoInvIbCustRefNoFlg(String autoInvIbCustRefNoFlg) {
		this.autoInvIbCustRefNoFlg = autoInvIbCustRefNoFlg;
	}
	
	/**
	 * 
	 * @return String autoInvIbCustRefNoFlg
	 */
	public String getAutoInvIbCustRefNoFlg() {
		return this.autoInvIbCustRefNoFlg;
	}
	
	/**
	 *
	 * @param String autoInvIbLoclChgFlg
	 */
	public void setAutoInvIbLoclChgFlg(String autoInvIbLoclChgFlg) {
		this.autoInvIbLoclChgFlg = autoInvIbLoclChgFlg;
	}
	
	/**
	 * 
	 * @return String autoInvIbLoclChgFlg
	 */
	public String getAutoInvIbLoclChgFlg() {
		return this.autoInvIbLoclChgFlg;
	}
	
	/**
	 *
	 * @param String autoInvIbEml
	 */
	public void setAutoInvIbEml(String autoInvIbEml) {
		this.autoInvIbEml = autoInvIbEml;
	}
	
	/**
	 * 
	 * @return String autoInvIbEml
	 */
	public String getAutoInvIbEml() {
		return this.autoInvIbEml;
	}
	
	/**
	 *
	 * @param String autoInvObFlg
	 */
	public void setAutoInvObFlg(String autoInvObFlg) {
		this.autoInvObFlg = autoInvObFlg;
	}
	
	/**
	 * 
	 * @return String autoInvObFlg
	 */
	public String getAutoInvObFlg() {
		return this.autoInvObFlg;
	}
	
	/**
	 *
	 * @param String autoInvObHjsRefNo
	 */
	public void setAutoInvObHjsRefNo(String autoInvObHjsRefNo) {
		this.autoInvObHjsRefNo = autoInvObHjsRefNo;
	}
	
	/**
	 * 
	 * @return String autoInvObHjsRefNo
	 */
	public String getAutoInvObHjsRefNo() {
		return this.autoInvObHjsRefNo;
	}
	
	/**
	 *
	 * @param String autoInvObHjsRefPhnNo
	 */
	public void setAutoInvObHjsRefPhnNo(String autoInvObHjsRefPhnNo) {
		this.autoInvObHjsRefPhnNo = autoInvObHjsRefPhnNo;
	}
	
	/**
	 * 
	 * @return String autoInvObHjsRefPhnNo
	 */
	public String getAutoInvObHjsRefPhnNo() {
		return this.autoInvObHjsRefPhnNo;
	}
	
	/**
	 *
	 * @param String autoInvObCustRefNoFlg
	 */
	public void setAutoInvObCustRefNoFlg(String autoInvObCustRefNoFlg) {
		this.autoInvObCustRefNoFlg = autoInvObCustRefNoFlg;
	}
	
	/**
	 * 
	 * @return String autoInvObCustRefNoFlg
	 */
	public String getAutoInvObCustRefNoFlg() {
		return this.autoInvObCustRefNoFlg;
	}
	
	/**
	 *
	 * @param String autoInvObLoclChgFlg
	 */
	public void setAutoInvObLoclChgFlg(String autoInvObLoclChgFlg) {
		this.autoInvObLoclChgFlg = autoInvObLoclChgFlg;
	}
	
	/**
	 * 
	 * @return String autoInvObLoclChgFlg
	 */
	public String getAutoInvObLoclChgFlg() {
		return this.autoInvObLoclChgFlg;
	}
	
	/**
	 *
	 * @param String autoInvObEml
	 */
	public void setAutoInvObEml(String autoInvObEml) {
		this.autoInvObEml = autoInvObEml;
	}
	
	/**
	 * 
	 * @return String autoInvObEml
	 */
	public String getAutoInvObEml() {
		return this.autoInvObEml;
	}
	
	/**
	 *
	 * @param String autoRmdrSndFlg
	 */
	public void setAutoRmdrSndFlg(String autoRmdrSndFlg) {
		this.autoRmdrSndFlg = autoRmdrSndFlg;
	}
	
	/**
	 * 
	 * @return String autoRmdrSndFlg
	 */
	public String getAutoRmdrSndFlg() {
		return this.autoRmdrSndFlg;
	}
	
	/**
	 *
	 * @param String autoRmdrHjsRefNo
	 */
	public void setAutoRmdrHjsRefNo(String autoRmdrHjsRefNo) {
		this.autoRmdrHjsRefNo = autoRmdrHjsRefNo;
	}
	
	/**
	 * 
	 * @return String autoRmdrHjsRefNo
	 */
	public String getAutoRmdrHjsRefNo() {
		return this.autoRmdrHjsRefNo;
	}
	
	/**
	 *
	 * @param String autoRmdrHjsRefPhnno
	 */
	public void setAutoRmdrHjsRefPhnno(String autoRmdrHjsRefPhnno) {
		this.autoRmdrHjsRefPhnno = autoRmdrHjsRefPhnno;
	}
	
	/**
	 * 
	 * @return String autoRmdrHjsRefPhnno
	 */
	public String getAutoRmdrHjsRefPhnno() {
		return this.autoRmdrHjsRefPhnno;
	}
	
	/**
	 *
	 * @param String autoRmdrSndTermCd
	 */
	public void setAutoRmdrSndTermCd(String autoRmdrSndTermCd) {
		this.autoRmdrSndTermCd = autoRmdrSndTermCd;
	}
	
	/**
	 * 
	 * @return String autoRmdrSndTermCd
	 */
	public String getAutoRmdrSndTermCd() {
		return this.autoRmdrSndTermCd;
	}
	
	/**
	 *
	 * @param String autoRmdrIbEml
	 */
	public void setAutoRmdrIbEml(String autoRmdrIbEml) {
		this.autoRmdrIbEml = autoRmdrIbEml;
	}
	
	/**
	 * 
	 * @return String autoRmdrIbEml
	 */
	public String getAutoRmdrIbEml() {
		return this.autoRmdrIbEml;
	}
	
	/**
	 *
	 * @param String autoRmdrObEml
	 */
	public void setAutoRmdrObEml(String autoRmdrObEml) {
		this.autoRmdrObEml = autoRmdrObEml;
	}
	
	/**
	 * 
	 * @return String autoRmdrObEml
	 */
	public String getAutoRmdrObEml() {
		return this.autoRmdrObEml;
	}
	
	/**
	 *
	 * @param String localInfoRmrk
	 */
	public void setLocalInfoRmrk(String localInfoRmrk) {
		this.localInfoRmrk = localInfoRmrk;
	}
	
	/**
	 * 
	 * @return String localInfoRmrk
	 */
	public String getLocalInfoRmrk() {
		return this.localInfoRmrk;
	}
	
	/**
	 *
	 * @param String payDtDy5
	 */
	public void setPayDtDy5(String payDtDy5) {
		this.payDtDy5 = payDtDy5;
	}
	
	/**
	 * 
	 * @return String payDtDy5
	 */
	public String getPayDtDy5() {
		return this.payDtDy5;
	}
	
	/**
	 *
	 * @param String payWkDay
	 */
	public void setPayWkDay(String payWkDay) {
		this.payWkDay = payWkDay;
	}
	
	/**
	 * 
	 * @return String payWkDay
	 */
	public String getPayWkDay() {
		return this.payWkDay;
	}
	
	/**
	 *
	 * @param String payTpCd
	 */
	public void setPayTpCd(String payTpCd) {
		this.payTpCd = payTpCd;
	}
	
	/**
	 * 
	 * @return String payTpCd
	 */
	public String getPayTpCd() {
		return this.payTpCd;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setActCustCntCd(JSPUtil.getParameter(request, prefix + "act_cust_cnt_cd", ""));
		setActCustSeq(JSPUtil.getParameter(request, prefix + "act_cust_seq", ""));
		setCustRlseCtrlFlg(JSPUtil.getParameter(request, prefix + "cust_rlse_ctrl_flg", ""));
		setCrFlg(JSPUtil.getParameter(request, prefix + "cr_flg", ""));
		setCrCurrCd(JSPUtil.getParameter(request, prefix + "cr_curr_cd", ""));
		setCrAmt(JSPUtil.getParameter(request, prefix + "cr_amt", ""));
		setCrCltOfcCd(JSPUtil.getParameter(request, prefix + "cr_clt_ofc_cd", ""));
		setCrCltMstOfcId1(JSPUtil.getParameter(request, prefix + "cr_clt_mst_ofc_id1", ""));
		setCrCustRmk(JSPUtil.getParameter(request, prefix + "cr_cust_rmk", ""));
		setIbCrTermDys(JSPUtil.getParameter(request, prefix + "ib_cr_term_dys", ""));
		setObCrTermDys(JSPUtil.getParameter(request, prefix + "ob_cr_term_dys", ""));
		setPayDivCd(JSPUtil.getParameter(request, prefix + "pay_div_cd", ""));
		setCrStrtDt(JSPUtil.getParameter(request, prefix + "cr_strt_dt", ""));
		setCrEndDt(JSPUtil.getParameter(request, prefix + "cr_end_dt", ""));
		setCrCustTpCd(JSPUtil.getParameter(request, prefix + "cr_cust_tp_cd", ""));
		setKrIbOfcCd(JSPUtil.getParameter(request, prefix + "kr_ib_ofc_cd", ""));
		setKrIbMstOfcId(JSPUtil.getParameter(request, prefix + "kr_ib_mst_ofc_id", ""));
		setObEml(JSPUtil.getParameter(request, prefix + "ob_eml", ""));
		setIbEml(JSPUtil.getParameter(request, prefix + "ib_eml", ""));
		setXchRtDivCd(JSPUtil.getParameter(request, prefix + "xch_rt_div_cd", ""));
		setChngIndivCd(JSPUtil.getParameter(request, prefix + "chng_indiv_cd", ""));
		setDyXchApplStrtDt(JSPUtil.getParameter(request, prefix + "dy_xch_appl_strt_dt", ""));
		setIssDivCd(JSPUtil.getParameter(request, prefix + "iss_div_cd", ""));
		setBankAcctNo(JSPUtil.getParameter(request, prefix + "bank_acct_no", ""));
		setBfrCrCltOfcId(JSPUtil.getParameter(request, prefix + "bfr_cr_clt_ofc_id", ""));
		setBfrCrCltOfcCd(JSPUtil.getParameter(request, prefix + "bfr_cr_clt_ofc_cd", ""));
		setBfrOfcChngDt(JSPUtil.getParameter(request, prefix + "bfr_ofc_chng_dt", ""));
		setBfrKrIbOfcId(JSPUtil.getParameter(request, prefix + "bfr_kr_ib_ofc_id", ""));
		setBfrKrIbOfcCd(JSPUtil.getParameter(request, prefix + "bfr_kr_ib_ofc_cd", ""));
		setCntcPsonNm(JSPUtil.getParameter(request, prefix + "cntc_pson_nm", ""));
		setDueDtCrteDivCd(JSPUtil.getParameter(request, prefix + "due_dt_crte_div_cd", ""));
		setPayDtDy1(JSPUtil.getParameter(request, prefix + "pay_dt_dy1", ""));
		setPayDtDy2(JSPUtil.getParameter(request, prefix + "pay_dt_dy2", ""));
		setPayDtDy3(JSPUtil.getParameter(request, prefix + "pay_dt_dy3", ""));
		setPayDtDy4(JSPUtil.getParameter(request, prefix + "pay_dt_dy4", ""));
		setLoclNm(JSPUtil.getParameter(request, prefix + "locl_nm", ""));
		setLoclAddr1(JSPUtil.getParameter(request, prefix + "locl_addr1", ""));
		setLoclAddr2(JSPUtil.getParameter(request, prefix + "locl_addr2", ""));
		setLoclAddr3(JSPUtil.getParameter(request, prefix + "locl_addr3", ""));
		setLoclAddr4(JSPUtil.getParameter(request, prefix + "locl_addr4", ""));
		setLoclZipCd(JSPUtil.getParameter(request, prefix + "locl_zip_cd", ""));
		setIbPhnNo(JSPUtil.getParameter(request, prefix + "ib_phn_no", ""));
		setIbFaxNo(JSPUtil.getParameter(request, prefix + "ib_fax_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setObPhnNo(JSPUtil.getParameter(request, prefix + "ob_phn_no", ""));
		setObFaxNo(JSPUtil.getParameter(request, prefix + "ob_fax_no", ""));
		setOwnrNm(JSPUtil.getParameter(request, prefix + "ownr_nm", ""));
		setBzctNm(JSPUtil.getParameter(request, prefix + "bzct_nm", ""));
		setBztpDesc(JSPUtil.getParameter(request, prefix + "bztp_desc", ""));
		setInvDueDtDpFlg(JSPUtil.getParameter(request, prefix + "inv_due_dt_dp_flg", ""));
		setIndivCorpDivCd(JSPUtil.getParameter(request, prefix + "indiv_corp_div_cd", ""));
		setCustRgstNo(JSPUtil.getParameter(request, prefix + "cust_rgst_no", ""));
		setRissInvFlg(JSPUtil.getParameter(request, prefix + "riss_inv_flg", ""));
		setInvIssCurrTpCd(JSPUtil.getParameter(request, prefix + "inv_iss_curr_tp_cd", ""));
		setCustRlseCtrlRmk(JSPUtil.getParameter(request, prefix + "cust_rlse_ctrl_rmk", ""));
		setSubSysNm(JSPUtil.getParameter(request, prefix + "sub_sys_nm", ""));
		setAutoInvIbFlg(JSPUtil.getParameter(request, prefix + "auto_inv_ib_flg", ""));
		setAutoInvIbHjsRefNo(JSPUtil.getParameter(request, prefix + "auto_inv_ib_hjs_ref_no", ""));
		setAutoInvIbHjsRefPhnNo(JSPUtil.getParameter(request, prefix + "auto_inv_ib_hjs_ref_phn_no", ""));
		setAutoInvIbCustRefNoFlg(JSPUtil.getParameter(request, prefix + "auto_inv_ib_cust_ref_no_flg", ""));
		setAutoInvIbLoclChgFlg(JSPUtil.getParameter(request, prefix + "auto_inv_ib_locl_chg_flg", ""));
		setAutoInvIbEml(JSPUtil.getParameter(request, prefix + "auto_inv_ib_eml", ""));
		setAutoInvObFlg(JSPUtil.getParameter(request, prefix + "auto_inv_ob_flg", ""));
		setAutoInvObHjsRefNo(JSPUtil.getParameter(request, prefix + "auto_inv_ob_hjs_ref_no", ""));
		setAutoInvObHjsRefPhnNo(JSPUtil.getParameter(request, prefix + "auto_inv_ob_hjs_ref_phn_no", ""));
		setAutoInvObCustRefNoFlg(JSPUtil.getParameter(request, prefix + "auto_inv_ob_cust_ref_no_flg", ""));
		setAutoInvObLoclChgFlg(JSPUtil.getParameter(request, prefix + "auto_inv_ob_locl_chg_flg", ""));
		setAutoInvObEml(JSPUtil.getParameter(request, prefix + "auto_inv_ob_eml", ""));
		setAutoRmdrSndFlg(JSPUtil.getParameter(request, prefix + "auto_rmdr_snd_flg", ""));
		setAutoRmdrHjsRefNo(JSPUtil.getParameter(request, prefix + "auto_rmdr_hjs_ref_no", ""));
		setAutoRmdrHjsRefPhnno(JSPUtil.getParameter(request, prefix + "auto_rmdr_hjs_ref_phnno", ""));
		setAutoRmdrSndTermCd(JSPUtil.getParameter(request, prefix + "auto_rmdr_snd_term_cd", ""));
		setAutoRmdrIbEml(JSPUtil.getParameter(request, prefix + "auto_rmdr_ib_eml", ""));
		setAutoRmdrObEml(JSPUtil.getParameter(request, prefix + "auto_rmdr_ob_eml", ""));
		setLocalInfoRmrk(JSPUtil.getParameter(request, prefix + "local_info_rmrk", ""));
		setPayDtDy5(JSPUtil.getParameter(request, prefix + "pay_dt_dy5", ""));
		setPayWkDay(JSPUtil.getParameter(request, prefix + "pay_wk_day", ""));
		setPayTpCd(JSPUtil.getParameter(request, prefix + "pay_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CreditCustomerIfVO[]
	 */
	public CreditCustomerIfVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CreditCustomerIfVO[]
	 */
	public CreditCustomerIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CreditCustomerIfVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] actCustCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cnt_cd", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] custRlseCtrlFlg = (JSPUtil.getParameter(request, prefix	+ "cust_rlse_ctrl_flg", length));
			String[] crFlg = (JSPUtil.getParameter(request, prefix	+ "cr_flg", length));
			String[] crCurrCd = (JSPUtil.getParameter(request, prefix	+ "cr_curr_cd", length));
			String[] crAmt = (JSPUtil.getParameter(request, prefix	+ "cr_amt", length));
			String[] crCltOfcCd = (JSPUtil.getParameter(request, prefix	+ "cr_clt_ofc_cd", length));
			String[] crCltMstOfcId1 = (JSPUtil.getParameter(request, prefix	+ "cr_clt_mst_ofc_id1", length));
			String[] crCustRmk = (JSPUtil.getParameter(request, prefix	+ "cr_cust_rmk", length));
			String[] ibCrTermDys = (JSPUtil.getParameter(request, prefix	+ "ib_cr_term_dys", length));
			String[] obCrTermDys = (JSPUtil.getParameter(request, prefix	+ "ob_cr_term_dys", length));
			String[] payDivCd = (JSPUtil.getParameter(request, prefix	+ "pay_div_cd", length));
			String[] crStrtDt = (JSPUtil.getParameter(request, prefix	+ "cr_strt_dt", length));
			String[] crEndDt = (JSPUtil.getParameter(request, prefix	+ "cr_end_dt", length));
			String[] crCustTpCd = (JSPUtil.getParameter(request, prefix	+ "cr_cust_tp_cd", length));
			String[] krIbOfcCd = (JSPUtil.getParameter(request, prefix	+ "kr_ib_ofc_cd", length));
			String[] krIbMstOfcId = (JSPUtil.getParameter(request, prefix	+ "kr_ib_mst_ofc_id", length));
			String[] obEml = (JSPUtil.getParameter(request, prefix	+ "ob_eml", length));
			String[] ibEml = (JSPUtil.getParameter(request, prefix	+ "ib_eml", length));
			String[] xchRtDivCd = (JSPUtil.getParameter(request, prefix	+ "xch_rt_div_cd", length));
			String[] chngIndivCd = (JSPUtil.getParameter(request, prefix	+ "chng_indiv_cd", length));
			String[] dyXchApplStrtDt = (JSPUtil.getParameter(request, prefix	+ "dy_xch_appl_strt_dt", length));
			String[] issDivCd = (JSPUtil.getParameter(request, prefix	+ "iss_div_cd", length));
			String[] bankAcctNo = (JSPUtil.getParameter(request, prefix	+ "bank_acct_no", length));
			String[] bfrCrCltOfcId = (JSPUtil.getParameter(request, prefix	+ "bfr_cr_clt_ofc_id", length));
			String[] bfrCrCltOfcCd = (JSPUtil.getParameter(request, prefix	+ "bfr_cr_clt_ofc_cd", length));
			String[] bfrOfcChngDt = (JSPUtil.getParameter(request, prefix	+ "bfr_ofc_chng_dt", length));
			String[] bfrKrIbOfcId = (JSPUtil.getParameter(request, prefix	+ "bfr_kr_ib_ofc_id", length));
			String[] bfrKrIbOfcCd = (JSPUtil.getParameter(request, prefix	+ "bfr_kr_ib_ofc_cd", length));
			String[] cntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_nm", length));
			String[] dueDtCrteDivCd = (JSPUtil.getParameter(request, prefix	+ "due_dt_crte_div_cd", length));
			String[] payDtDy1 = (JSPUtil.getParameter(request, prefix	+ "pay_dt_dy1", length));
			String[] payDtDy2 = (JSPUtil.getParameter(request, prefix	+ "pay_dt_dy2", length));
			String[] payDtDy3 = (JSPUtil.getParameter(request, prefix	+ "pay_dt_dy3", length));
			String[] payDtDy4 = (JSPUtil.getParameter(request, prefix	+ "pay_dt_dy4", length));
			String[] loclNm = (JSPUtil.getParameter(request, prefix	+ "locl_nm", length));
			String[] loclAddr1 = (JSPUtil.getParameter(request, prefix	+ "locl_addr1", length));
			String[] loclAddr2 = (JSPUtil.getParameter(request, prefix	+ "locl_addr2", length));
			String[] loclAddr3 = (JSPUtil.getParameter(request, prefix	+ "locl_addr3", length));
			String[] loclAddr4 = (JSPUtil.getParameter(request, prefix	+ "locl_addr4", length));
			String[] loclZipCd = (JSPUtil.getParameter(request, prefix	+ "locl_zip_cd", length));
			String[] ibPhnNo = (JSPUtil.getParameter(request, prefix	+ "ib_phn_no", length));
			String[] ibFaxNo = (JSPUtil.getParameter(request, prefix	+ "ib_fax_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] obPhnNo = (JSPUtil.getParameter(request, prefix	+ "ob_phn_no", length));
			String[] obFaxNo = (JSPUtil.getParameter(request, prefix	+ "ob_fax_no", length));
			String[] ownrNm = (JSPUtil.getParameter(request, prefix	+ "ownr_nm", length));
			String[] bzctNm = (JSPUtil.getParameter(request, prefix	+ "bzct_nm", length));
			String[] bztpDesc = (JSPUtil.getParameter(request, prefix	+ "bztp_desc", length));
			String[] invDueDtDpFlg = (JSPUtil.getParameter(request, prefix	+ "inv_due_dt_dp_flg", length));
			String[] indivCorpDivCd = (JSPUtil.getParameter(request, prefix	+ "indiv_corp_div_cd", length));
			String[] custRgstNo = (JSPUtil.getParameter(request, prefix	+ "cust_rgst_no", length));
			String[] rissInvFlg = (JSPUtil.getParameter(request, prefix	+ "riss_inv_flg", length));
			String[] invIssCurrTpCd = (JSPUtil.getParameter(request, prefix	+ "inv_iss_curr_tp_cd", length));
			String[] custRlseCtrlRmk = (JSPUtil.getParameter(request, prefix	+ "cust_rlse_ctrl_rmk", length));
			String[] subSysNm = (JSPUtil.getParameter(request, prefix	+ "sub_sys_nm", length));
			String[] autoInvIbFlg = (JSPUtil.getParameter(request, prefix	+ "auto_inv_ib_flg", length));
			String[] autoInvIbHjsRefNo = (JSPUtil.getParameter(request, prefix	+ "auto_inv_ib_hjs_ref_no", length));
			String[] autoInvIbHjsRefPhnNo = (JSPUtil.getParameter(request, prefix	+ "auto_inv_ib_hjs_ref_phn_no", length));
			String[] autoInvIbCustRefNoFlg = (JSPUtil.getParameter(request, prefix	+ "auto_inv_ib_cust_ref_no_flg", length));
			String[] autoInvIbLoclChgFlg = (JSPUtil.getParameter(request, prefix	+ "auto_inv_ib_locl_chg_flg", length));
			String[] autoInvIbEml = (JSPUtil.getParameter(request, prefix	+ "auto_inv_ib_eml", length));
			String[] autoInvObFlg = (JSPUtil.getParameter(request, prefix	+ "auto_inv_ob_flg", length));
			String[] autoInvObHjsRefNo = (JSPUtil.getParameter(request, prefix	+ "auto_inv_ob_hjs_ref_no", length));
			String[] autoInvObHjsRefPhnNo = (JSPUtil.getParameter(request, prefix	+ "auto_inv_ob_hjs_ref_phn_no", length));
			String[] autoInvObCustRefNoFlg = (JSPUtil.getParameter(request, prefix	+ "auto_inv_ob_cust_ref_no_flg", length));
			String[] autoInvObLoclChgFlg = (JSPUtil.getParameter(request, prefix	+ "auto_inv_ob_locl_chg_flg", length));
			String[] autoInvObEml = (JSPUtil.getParameter(request, prefix	+ "auto_inv_ob_eml", length));
			String[] autoRmdrSndFlg = (JSPUtil.getParameter(request, prefix	+ "auto_rmdr_snd_flg", length));
			String[] autoRmdrHjsRefNo = (JSPUtil.getParameter(request, prefix	+ "auto_rmdr_hjs_ref_no", length));
			String[] autoRmdrHjsRefPhnno = (JSPUtil.getParameter(request, prefix	+ "auto_rmdr_hjs_ref_phnno", length));
			String[] autoRmdrSndTermCd = (JSPUtil.getParameter(request, prefix	+ "auto_rmdr_snd_term_cd", length));
			String[] autoRmdrIbEml = (JSPUtil.getParameter(request, prefix	+ "auto_rmdr_ib_eml", length));
			String[] autoRmdrObEml = (JSPUtil.getParameter(request, prefix	+ "auto_rmdr_ob_eml", length));
			String[] localInfoRmrk = (JSPUtil.getParameter(request, prefix	+ "local_info_rmrk", length));
			String[] payDtDy5 = (JSPUtil.getParameter(request, prefix	+ "pay_dt_dy5", length));
			String[] payWkDay = (JSPUtil.getParameter(request, prefix	+ "pay_wk_day", length));
			String[] payTpCd = (JSPUtil.getParameter(request, prefix	+ "pay_tp_cd", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new CreditCustomerIfVO();
				if (ibflag[i] != null) 
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null) 
					model.setPagerows(pagerows[i]);
				if (custCntCd[i] != null) 
					model.setCustCntCd(custCntCd[i]);
				if (custSeq[i] != null) 
					model.setCustSeq(custSeq[i]);
				if (actCustCntCd[i] != null) 
					model.setActCustCntCd(actCustCntCd[i]);
				if (actCustSeq[i] != null) 
					model.setActCustSeq(actCustSeq[i]);
				if (custRlseCtrlFlg[i] != null) 
					model.setCustRlseCtrlFlg(custRlseCtrlFlg[i]);
				if (crFlg[i] != null) 
					model.setCrFlg(crFlg[i]);
				if (crCurrCd[i] != null) 
					model.setCrCurrCd(crCurrCd[i]);
				if (crAmt[i] != null) 
					model.setCrAmt(crAmt[i]);
				if (crCltOfcCd[i] != null) 
					model.setCrCltOfcCd(crCltOfcCd[i]);
				if (crCltMstOfcId1[i] != null) 
					model.setCrCltMstOfcId1(crCltMstOfcId1[i]);
				if (crCustRmk[i] != null) 
					model.setCrCustRmk(crCustRmk[i]);
				if (ibCrTermDys[i] != null) 
					model.setIbCrTermDys(ibCrTermDys[i]);
				if (obCrTermDys[i] != null) 
					model.setObCrTermDys(obCrTermDys[i]);
				if (payDivCd[i] != null) 
					model.setPayDivCd(payDivCd[i]);
				if (crStrtDt[i] != null) 
					model.setCrStrtDt(crStrtDt[i]);
				if (crEndDt[i] != null) 
					model.setCrEndDt(crEndDt[i]);
				if (crCustTpCd[i] != null) 
					model.setCrCustTpCd(crCustTpCd[i]);
				if (krIbOfcCd[i] != null) 
					model.setKrIbOfcCd(krIbOfcCd[i]);
				if (krIbMstOfcId[i] != null) 
					model.setKrIbMstOfcId(krIbMstOfcId[i]);
				if (obEml[i] != null) 
					model.setObEml(obEml[i]);
				if (ibEml[i] != null) 
					model.setIbEml(ibEml[i]);
				if (xchRtDivCd[i] != null) 
					model.setXchRtDivCd(xchRtDivCd[i]);
				if (chngIndivCd[i] != null) 
					model.setChngIndivCd(chngIndivCd[i]);
				if (dyXchApplStrtDt[i] != null) 
					model.setDyXchApplStrtDt(dyXchApplStrtDt[i]);
				if (issDivCd[i] != null) 
					model.setIssDivCd(issDivCd[i]);
				if (bankAcctNo[i] != null) 
					model.setBankAcctNo(bankAcctNo[i]);
				if (bfrCrCltOfcId[i] != null) 
					model.setBfrCrCltOfcId(bfrCrCltOfcId[i]);
				if (bfrCrCltOfcCd[i] != null) 
					model.setBfrCrCltOfcCd(bfrCrCltOfcCd[i]);
				if (bfrOfcChngDt[i] != null) 
					model.setBfrOfcChngDt(bfrOfcChngDt[i]);
				if (bfrKrIbOfcId[i] != null) 
					model.setBfrKrIbOfcId(bfrKrIbOfcId[i]);
				if (bfrKrIbOfcCd[i] != null) 
					model.setBfrKrIbOfcCd(bfrKrIbOfcCd[i]);
				if (cntcPsonNm[i] != null) 
					model.setCntcPsonNm(cntcPsonNm[i]);
				if (dueDtCrteDivCd[i] != null) 
					model.setDueDtCrteDivCd(dueDtCrteDivCd[i]);
				if (payDtDy1[i] != null) 
					model.setPayDtDy1(payDtDy1[i]);
				if (payDtDy2[i] != null) 
					model.setPayDtDy2(payDtDy2[i]);
				if (payDtDy3[i] != null) 
					model.setPayDtDy3(payDtDy3[i]);
				if (payDtDy4[i] != null) 
					model.setPayDtDy4(payDtDy4[i]);
				if (loclNm[i] != null) 
					model.setLoclNm(loclNm[i]);
				if (loclAddr1[i] != null) 
					model.setLoclAddr1(loclAddr1[i]);
				if (loclAddr2[i] != null) 
					model.setLoclAddr2(loclAddr2[i]);
				if (loclAddr3[i] != null) 
					model.setLoclAddr3(loclAddr3[i]);
				if (loclAddr4[i] != null) 
					model.setLoclAddr4(loclAddr4[i]);
				if (loclZipCd[i] != null) 
					model.setLoclZipCd(loclZipCd[i]);
				if (ibPhnNo[i] != null) 
					model.setIbPhnNo(ibPhnNo[i]);
				if (ibFaxNo[i] != null) 
					model.setIbFaxNo(ibFaxNo[i]);
				if (creUsrId[i] != null) 
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null) 
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null) 
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null) 
					model.setUpdDt(updDt[i]);
				if (deltFlg[i] != null) 
					model.setDeltFlg(deltFlg[i]);
				if (obPhnNo[i] != null) 
					model.setObPhnNo(obPhnNo[i]);
				if (obFaxNo[i] != null) 
					model.setObFaxNo(obFaxNo[i]);
				if (ownrNm[i] != null) 
					model.setOwnrNm(ownrNm[i]);
				if (bzctNm[i] != null) 
					model.setBzctNm(bzctNm[i]);
				if (bztpDesc[i] != null) 
					model.setBztpDesc(bztpDesc[i]);
				if (invDueDtDpFlg[i] != null) 
					model.setInvDueDtDpFlg(invDueDtDpFlg[i]);
				if (indivCorpDivCd[i] != null) 
					model.setIndivCorpDivCd(indivCorpDivCd[i]);
				if (custRgstNo[i] != null) 
					model.setCustRgstNo(custRgstNo[i]);
				if (rissInvFlg[i] != null) 
					model.setRissInvFlg(rissInvFlg[i]);
				if (invIssCurrTpCd[i] != null) 
					model.setInvIssCurrTpCd(invIssCurrTpCd[i]);
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
				if (autoRmdrSndFlg[i] != null) 
					model.setAutoRmdrSndFlg(autoRmdrSndFlg[i]);
				if (autoRmdrHjsRefNo[i] != null) 
					model.setAutoRmdrHjsRefNo(autoRmdrHjsRefNo[i]);
				if (autoRmdrHjsRefPhnno[i] != null) 
					model.setAutoRmdrHjsRefPhnno(autoRmdrHjsRefPhnno[i]);
				if (autoRmdrSndTermCd[i] != null) 
					model.setAutoRmdrSndTermCd(autoRmdrSndTermCd[i]);
				if (autoRmdrIbEml[i] != null) 
					model.setAutoRmdrIbEml(autoRmdrIbEml[i]);
				if (autoRmdrObEml[i] != null) 
					model.setAutoRmdrObEml(autoRmdrObEml[i]);
				if (localInfoRmrk[i] != null) 
					model.setLocalInfoRmrk(localInfoRmrk[i]);
				if (payDtDy5[i] != null) 
					model.setPayDtDy5(payDtDy5[i]);
				if (payWkDay[i] != null) 
					model.setPayWkDay(payWkDay[i]);
				if (payTpCd[i] != null) 
					model.setPayTpCd(payTpCd[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCreditCustomerIfVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CreditCustomerIfVO[]
	 */
	public CreditCustomerIfVO[] getCreditCustomerIfVOs(){
		CreditCustomerIfVO[] vos = (CreditCustomerIfVO[])models.toArray(new CreditCustomerIfVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd = this.actCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRlseCtrlFlg = this.custRlseCtrlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crFlg = this.crFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCurrCd = this.crCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crAmt = this.crAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCltOfcCd = this.crCltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCltMstOfcId1 = this.crCltMstOfcId1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCustRmk = this.crCustRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCrTermDys = this.ibCrTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCrTermDys = this.obCrTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDivCd = this.payDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crStrtDt = this.crStrtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crEndDt = this.crEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCustTpCd = this.crCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krIbOfcCd = this.krIbOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krIbMstOfcId = this.krIbMstOfcId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obEml = this.obEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibEml = this.ibEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtDivCd = this.xchRtDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chngIndivCd = this.chngIndivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dyXchApplStrtDt = this.dyXchApplStrtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDivCd = this.issDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctNo = this.bankAcctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrCrCltOfcId = this.bfrCrCltOfcId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrCrCltOfcCd = this.bfrCrCltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrOfcChngDt = this.bfrOfcChngDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrKrIbOfcId = this.bfrKrIbOfcId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrKrIbOfcCd = this.bfrKrIbOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm = this.cntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDtCrteDivCd = this.dueDtCrteDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDtDy1 = this.payDtDy1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDtDy2 = this.payDtDy2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDtDy3 = this.payDtDy3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDtDy4 = this.payDtDy4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclNm = this.loclNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAddr1 = this.loclAddr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAddr2 = this.loclAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAddr3 = this.loclAddr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAddr4 = this.loclAddr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclZipCd = this.loclZipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibPhnNo = this.ibPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibFaxNo = this.ibFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obPhnNo = this.obPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obFaxNo = this.obFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrNm = this.ownrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzctNm = this.bzctNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bztpDesc = this.bztpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDueDtDpFlg = this.invDueDtDpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.indivCorpDivCd = this.indivCorpDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRgstNo = this.custRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rissInvFlg = this.rissInvFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssCurrTpCd = this.invIssCurrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRlseCtrlRmk = this.custRlseCtrlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subSysNm = this.subSysNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoInvIbFlg = this.autoInvIbFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoInvIbHjsRefNo = this.autoInvIbHjsRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoInvIbHjsRefPhnNo = this.autoInvIbHjsRefPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoInvIbCustRefNoFlg = this.autoInvIbCustRefNoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoInvIbLoclChgFlg = this.autoInvIbLoclChgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoInvIbEml = this.autoInvIbEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoInvObFlg = this.autoInvObFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoInvObHjsRefNo = this.autoInvObHjsRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoInvObHjsRefPhnNo = this.autoInvObHjsRefPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoInvObCustRefNoFlg = this.autoInvObCustRefNoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoInvObLoclChgFlg = this.autoInvObLoclChgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoInvObEml = this.autoInvObEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoRmdrSndFlg = this.autoRmdrSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoRmdrHjsRefNo = this.autoRmdrHjsRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoRmdrHjsRefPhnno = this.autoRmdrHjsRefPhnno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoRmdrSndTermCd = this.autoRmdrSndTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoRmdrIbEml = this.autoRmdrIbEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoRmdrObEml = this.autoRmdrObEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.localInfoRmrk = this.localInfoRmrk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDtDy5 = this.payDtDy5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payWkDay = this.payWkDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTpCd = this.payTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}