/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StmOfcInfoVO.java
*@FileTitle : StmOfcInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.01
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.01  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo;

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

public class StmOfcInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<StmOfcInfoVO> models = new ArrayList<StmOfcInfoVO>();
	
	/* Column Info */
	private String apCtrlOfcCd = null;
	/* Column Info */
	private String bankChgAcctCd = null;
	/* Column Info */
	private String ofcTpCd = null;
	/* Column Info */
	private String arCtrlOfcCd = null;
	/* Column Info */
	private String obCrTermDys = null;
	/* Column Info */
	private String agnOtsLmtAmt = null;
	/* Column Info */
	private String bilCurrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fxCurrRt = null;
	/* Column Info */
	private String bankCtrlCd = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String rctOfcAddr = null;
	/* Column Info */
	private String teamMgrNm = null;
	/* Column Info */
	private String arPrnTitNm = null;
	/* Column Info */
	private String agnCurrCd = null;
	/* Column Info */
	private String rctDocCd = null;
	/* Column Info */
	private String modiOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String apOfcCd = null;
	/* Column Info */
	private String arCurrCd = null;
	/* Column Info */
	private String arHdQtrOfcCd = null;
	/* Column Info */
	private String faxIp = null;
	/* Column Info */
	private String fincHideFlg = null;
	/* Column Info */
	private String subsCoFlg = null;
	/* Column Info */
	private String ofcUrl = null;
	/* Column Info */
	private String apEuroCurrUseFlg = null;
	/* Column Info */
	private String agnCmbCd = null;
	/* Column Info */
	private String miscLssLmtAmt = null;
	/* Column Info */
	private String ofcRepEml = null;
	/* Column Info */
	private String ofcInqLvlCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String otsSmryCd = null;
	/* Column Info */
	private String ofcEngNm = null;
	/* Column Info */
	private String bkgSvrSrchRoutCd = null;
	/* Column Info */
	private String arCtrCd = null;
	/* Column Info */
	private String ofcCntCd = null;
	/* Column Info */
	private String intlFaxNo = null;
	/* Column Info */
	private String soIfCd = null;
	/* Column Info */
	private String bfrOfcCd = null;
	/* Column Info */
	private String rctTitNm = null;
	/* Column Info */
	private String prcOfcCd = null;
	/* Column Info */
	private String apHoAcctCd = null;
	/* Column Info */
	private String opnDt = null;
	/* Column Info */
	private String arPrnCtnt = null;
	/* Column Info */
	private String enblFlg = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String fincPsdoOfcFlg = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String prntOfcCd = null;
	/* Column Info */
	private String rctOfcTitNm = null;
	/* Column Info */
	private String repOtsOfcCd = null;
	/* Column Info */
	private String ofcWrtfTpCd1 = null;
	/* Column Info */
	private String vndrCntCd = null;
	/* Column Info */
	private String agnKndCd = null;
	/* Column Info */
	private String fincRgnCd = null;
	/* Column Info */
	private String ofcWrtfTpCd4 = null;
	/* Column Info */
	private String ofcWrtfTpCd5 = null;
	/* Column Info */
	private String ofcWrtfTpCd2 = null;
	/* Column Info */
	private String ofcWrtfTpCd3 = null;
	/* Column Info */
	private String miscIncmLmtAmt = null;
	/* Column Info */
	private String ofcCmmcCd = null;
	/* Column Info */
	private String repCustCntCd = null;
	/* Column Info */
	private String ofcEntrLvlCd = null;
	/* Column Info */
	private String clzDt = null;
	/* Column Info */
	private String ofcZipCd = null;
	/* Column Info */
	private String ofcAddr = null;
	/* Column Info */
	private String ovpayTpCd = null;
	/* Column Info */
	private String commIfIndCd = null;
	/* Column Info */
	private String ofcBrncAgnTpCd = null;
	/* Column Info */
	private String teamFaxNo = null;
	/* Column Info */
	private String asaCrTermDys = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String ofcRfaScUseFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String ofcRmk = null;
	/* Column Info */
	private String rctSpclRmk = null;
	/* Column Info */
	private String repCustSeq = null;
	/* Column Info */
	private String apCtrCd = null;
	/* Column Info */
	private String ofcFaxNo = null;
	/* Column Info */
	private String ofcTaxId = null;
	/* Column Info */
	private String docRcvrHideFlg = null;
	/* Column Info */
	private String agnPfxCd = null;
	/* Column Info */
	private String otsIfFlg = null;
	/* Column Info */
	private String ofcLoclLangAddr = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String eaiIfId = null;
	/* Column Info */
	private String ibCrTermDys = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usaBrkBrncRqstCtrlOfcCd = null;
	/* Column Info */
	private String ofcPhnNo = null;
	/* Column Info */
	private String rctOfcSpclNoCtnt = null;
	/* Column Info */
	private String invPfxCd = null;
	/* Column Info */
	private String slsOfcUseFlg = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ofcKndCd = null;
	/* Column Info */
	private String rctRmk = null;
	/* Column Info */
	private String glCtrCd = null;
	/* Column Info */
	private String ofcPsonKnt = null;
	/* Column Info */
	private String rctOfcTelcmFaxNoCtnt = null;
	/* Column Info */
	private String eaiEvntDt = null;
	/* Column Info */
	private String subAgnFlg = null;
	/* Column Info */
	private String otsCateCd = null;
	/* Column Info */
	private String otsCd = null;
	/* Column Info */
	private String bankOfc = null;
	/* Column Info */
	private String rctTpCd = null;
	/* Column Info */
	private String arAgnStlCd = null;
	/* Column Info */
	private String ofcSlsDeltFlg = null;
	/* Column Info */
	private String ofcLoclNm = null;
	/* Column Info */
	private String slsOfcDivCd = null;
	/* Column Info */
	private String intlPhnNo = null;
	/* Column Info */
	private String rctUnapyFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public StmOfcInfoVO() {}

	public StmOfcInfoVO(String ibflag, String pagerows, String ofcCd, String ofcEngNm, String ofcLoclNm, String ofcAddr, String ofcZipCd, String ofcKndCd, String agnKndCd, String vndrCntCd, String vndrSeq, String intlPhnNo, String ofcPhnNo, String intlFaxNo, String ofcFaxNo, String ofcPsonKnt, String ofcRmk, String locCd, String bilCurrCd, String arCurrCd, String arCtrCd, String prntOfcCd, String opnDt, String clzDt, String fincRgnCd, String arOfcCd, String arCtrlOfcCd, String arHdQtrOfcCd, String ibCrTermDys, String obCrTermDys, String subAgnFlg, String repCustCntCd, String repCustSeq, String invPfxCd, String apOfcCd, String apCtrlOfcCd, String apHoAcctCd, String apCtrCd, String arAgnStlCd, String fxCurrRt, String apEuroCurrUseFlg, String usaBrkBrncRqstCtrlOfcCd, String asaCrTermDys, String soIfCd, String slsOfcUseFlg, String slsOfcDivCd, String ofcTaxId, String ofcRfaScUseFlg, String commIfIndCd, String faxIp, String bfrOfcCd, String modiOfcCd, String ofcCmmcCd, String ofcTpCd, String prcOfcCd, String ofcUrl, String ofcRepEml, String bkgSvrSrchRoutCd, String ofcSlsDeltFlg, String docRcvrHideFlg, String fincHideFlg, String fincPsdoOfcFlg, String subsCoFlg, String glCtrCd, String teamMgrNm, String teamFaxNo, String ofcLoclLangAddr, String creUsrId, String creDt, String updUsrId, String updDt, String deltFlg, String eaiEvntDt, String eaiIfId, String ofcEntrLvlCd, String bankCtrlCd, String otsCd, String repOtsOfcCd, String miscLssLmtAmt, String miscIncmLmtAmt, String agnCmbCd, String agnPfxCd, String otsCateCd, String agnCurrCd, String agnOtsLmtAmt, String otsIfFlg, String bankChgAcctCd, String ovpayTpCd, String ofcInqLvlCd, String loclCurrCd, String ofcCntCd, String rctTpCd, String rctUnapyFlg, String ofcBrncAgnTpCd, String bankOfc, String enblFlg, String arPrnCtnt, String arPrnTitNm, String otsSmryCd, String rctOfcTitNm, String rctOfcAddr, String rctOfcTelcmFaxNoCtnt, String rctOfcSpclNoCtnt, String rctTitNm, String rctRmk, String rctSpclRmk, String rctDocCd, String ofcWrtfTpCd1, String ofcWrtfTpCd2, String ofcWrtfTpCd3, String ofcWrtfTpCd4, String ofcWrtfTpCd5) {
		this.apCtrlOfcCd = apCtrlOfcCd;
		this.bankChgAcctCd = bankChgAcctCd;
		this.ofcTpCd = ofcTpCd;
		this.arCtrlOfcCd = arCtrlOfcCd;
		this.obCrTermDys = obCrTermDys;
		this.agnOtsLmtAmt = agnOtsLmtAmt;
		this.bilCurrCd = bilCurrCd;
		this.pagerows = pagerows;
		this.fxCurrRt = fxCurrRt;
		this.bankCtrlCd = bankCtrlCd;
		this.locCd = locCd;
		this.rctOfcAddr = rctOfcAddr;
		this.teamMgrNm = teamMgrNm;
		this.arPrnTitNm = arPrnTitNm;
		this.agnCurrCd = agnCurrCd;
		this.rctDocCd = rctDocCd;
		this.modiOfcCd = modiOfcCd;
		this.updUsrId = updUsrId;
		this.apOfcCd = apOfcCd;
		this.arCurrCd = arCurrCd;
		this.arHdQtrOfcCd = arHdQtrOfcCd;
		this.faxIp = faxIp;
		this.fincHideFlg = fincHideFlg;
		this.subsCoFlg = subsCoFlg;
		this.ofcUrl = ofcUrl;
		this.apEuroCurrUseFlg = apEuroCurrUseFlg;
		this.agnCmbCd = agnCmbCd;
		this.miscLssLmtAmt = miscLssLmtAmt;
		this.ofcRepEml = ofcRepEml;
		this.ofcInqLvlCd = ofcInqLvlCd;
		this.deltFlg = deltFlg;
		this.otsSmryCd = otsSmryCd;
		this.ofcEngNm = ofcEngNm;
		this.bkgSvrSrchRoutCd = bkgSvrSrchRoutCd;
		this.arCtrCd = arCtrCd;
		this.ofcCntCd = ofcCntCd;
		this.intlFaxNo = intlFaxNo;
		this.soIfCd = soIfCd;
		this.bfrOfcCd = bfrOfcCd;
		this.rctTitNm = rctTitNm;
		this.prcOfcCd = prcOfcCd;
		this.apHoAcctCd = apHoAcctCd;
		this.opnDt = opnDt;
		this.arPrnCtnt = arPrnCtnt;
		this.enblFlg = enblFlg;
		this.arOfcCd = arOfcCd;
		this.fincPsdoOfcFlg = fincPsdoOfcFlg;
		this.ofcCd = ofcCd;
		this.prntOfcCd = prntOfcCd;
		this.rctOfcTitNm = rctOfcTitNm;
		this.repOtsOfcCd = repOtsOfcCd;
		this.ofcWrtfTpCd1 = ofcWrtfTpCd1;
		this.vndrCntCd = vndrCntCd;
		this.agnKndCd = agnKndCd;
		this.fincRgnCd = fincRgnCd;
		this.ofcWrtfTpCd4 = ofcWrtfTpCd4;
		this.ofcWrtfTpCd5 = ofcWrtfTpCd5;
		this.ofcWrtfTpCd2 = ofcWrtfTpCd2;
		this.ofcWrtfTpCd3 = ofcWrtfTpCd3;
		this.miscIncmLmtAmt = miscIncmLmtAmt;
		this.ofcCmmcCd = ofcCmmcCd;
		this.repCustCntCd = repCustCntCd;
		this.ofcEntrLvlCd = ofcEntrLvlCd;
		this.clzDt = clzDt;
		this.ofcZipCd = ofcZipCd;
		this.ofcAddr = ofcAddr;
		this.ovpayTpCd = ovpayTpCd;
		this.commIfIndCd = commIfIndCd;
		this.ofcBrncAgnTpCd = ofcBrncAgnTpCd;
		this.teamFaxNo = teamFaxNo;
		this.asaCrTermDys = asaCrTermDys;
		this.loclCurrCd = loclCurrCd;
		this.ofcRfaScUseFlg = ofcRfaScUseFlg;
		this.creUsrId = creUsrId;
		this.vndrSeq = vndrSeq;
		this.ofcRmk = ofcRmk;
		this.rctSpclRmk = rctSpclRmk;
		this.repCustSeq = repCustSeq;
		this.apCtrCd = apCtrCd;
		this.ofcFaxNo = ofcFaxNo;
		this.ofcTaxId = ofcTaxId;
		this.docRcvrHideFlg = docRcvrHideFlg;
		this.agnPfxCd = agnPfxCd;
		this.otsIfFlg = otsIfFlg;
		this.ofcLoclLangAddr = ofcLoclLangAddr;
		this.creDt = creDt;
		this.eaiIfId = eaiIfId;
		this.ibCrTermDys = ibCrTermDys;
		this.ibflag = ibflag;
		this.usaBrkBrncRqstCtrlOfcCd = usaBrkBrncRqstCtrlOfcCd;
		this.ofcPhnNo = ofcPhnNo;
		this.rctOfcSpclNoCtnt = rctOfcSpclNoCtnt;
		this.invPfxCd = invPfxCd;
		this.slsOfcUseFlg = slsOfcUseFlg;
		this.updDt = updDt;
		this.ofcKndCd = ofcKndCd;
		this.rctRmk = rctRmk;
		this.glCtrCd = glCtrCd;
		this.ofcPsonKnt = ofcPsonKnt;
		this.rctOfcTelcmFaxNoCtnt = rctOfcTelcmFaxNoCtnt;
		this.eaiEvntDt = eaiEvntDt;
		this.subAgnFlg = subAgnFlg;
		this.otsCateCd = otsCateCd;
		this.otsCd = otsCd;
		this.bankOfc = bankOfc;
		this.rctTpCd = rctTpCd;
		this.arAgnStlCd = arAgnStlCd;
		this.ofcSlsDeltFlg = ofcSlsDeltFlg;
		this.ofcLoclNm = ofcLoclNm;
		this.slsOfcDivCd = slsOfcDivCd;
		this.intlPhnNo = intlPhnNo;
		this.rctUnapyFlg = rctUnapyFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ap_ctrl_ofc_cd", getApCtrlOfcCd());
		this.hashColumns.put("bank_chg_acct_cd", getBankChgAcctCd());
		this.hashColumns.put("ofc_tp_cd", getOfcTpCd());
		this.hashColumns.put("ar_ctrl_ofc_cd", getArCtrlOfcCd());
		this.hashColumns.put("ob_cr_term_dys", getObCrTermDys());
		this.hashColumns.put("agn_ots_lmt_amt", getAgnOtsLmtAmt());
		this.hashColumns.put("bil_curr_cd", getBilCurrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fx_curr_rt", getFxCurrRt());
		this.hashColumns.put("bank_ctrl_cd", getBankCtrlCd());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("rct_ofc_addr", getRctOfcAddr());
		this.hashColumns.put("team_mgr_nm", getTeamMgrNm());
		this.hashColumns.put("ar_prn_tit_nm", getArPrnTitNm());
		this.hashColumns.put("agn_curr_cd", getAgnCurrCd());
		this.hashColumns.put("rct_doc_cd", getRctDocCd());
		this.hashColumns.put("modi_ofc_cd", getModiOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ap_ofc_cd", getApOfcCd());
		this.hashColumns.put("ar_curr_cd", getArCurrCd());
		this.hashColumns.put("ar_hd_qtr_ofc_cd", getArHdQtrOfcCd());
		this.hashColumns.put("fax_ip", getFaxIp());
		this.hashColumns.put("finc_hide_flg", getFincHideFlg());
		this.hashColumns.put("subs_co_flg", getSubsCoFlg());
		this.hashColumns.put("ofc_url", getOfcUrl());
		this.hashColumns.put("ap_euro_curr_use_flg", getApEuroCurrUseFlg());
		this.hashColumns.put("agn_cmb_cd", getAgnCmbCd());
		this.hashColumns.put("misc_lss_lmt_amt", getMiscLssLmtAmt());
		this.hashColumns.put("ofc_rep_eml", getOfcRepEml());
		this.hashColumns.put("ofc_inq_lvl_cd", getOfcInqLvlCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("ots_smry_cd", getOtsSmryCd());
		this.hashColumns.put("ofc_eng_nm", getOfcEngNm());
		this.hashColumns.put("bkg_svr_srch_rout_cd", getBkgSvrSrchRoutCd());
		this.hashColumns.put("ar_ctr_cd", getArCtrCd());
		this.hashColumns.put("ofc_cnt_cd", getOfcCntCd());
		this.hashColumns.put("intl_fax_no", getIntlFaxNo());
		this.hashColumns.put("so_if_cd", getSoIfCd());
		this.hashColumns.put("bfr_ofc_cd", getBfrOfcCd());
		this.hashColumns.put("rct_tit_nm", getRctTitNm());
		this.hashColumns.put("prc_ofc_cd", getPrcOfcCd());
		this.hashColumns.put("ap_ho_acct_cd", getApHoAcctCd());
		this.hashColumns.put("opn_dt", getOpnDt());
		this.hashColumns.put("ar_prn_ctnt", getArPrnCtnt());
		this.hashColumns.put("enbl_flg", getEnblFlg());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("finc_psdo_ofc_flg", getFincPsdoOfcFlg());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("prnt_ofc_cd", getPrntOfcCd());
		this.hashColumns.put("rct_ofc_tit_nm", getRctOfcTitNm());
		this.hashColumns.put("rep_ots_ofc_cd", getRepOtsOfcCd());
		this.hashColumns.put("ofc_wrtf_tp_cd1", getOfcWrtfTpCd1());
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
		this.hashColumns.put("agn_knd_cd", getAgnKndCd());
		this.hashColumns.put("finc_rgn_cd", getFincRgnCd());
		this.hashColumns.put("ofc_wrtf_tp_cd4", getOfcWrtfTpCd4());
		this.hashColumns.put("ofc_wrtf_tp_cd5", getOfcWrtfTpCd5());
		this.hashColumns.put("ofc_wrtf_tp_cd2", getOfcWrtfTpCd2());
		this.hashColumns.put("ofc_wrtf_tp_cd3", getOfcWrtfTpCd3());
		this.hashColumns.put("misc_incm_lmt_amt", getMiscIncmLmtAmt());
		this.hashColumns.put("ofc_cmmc_cd", getOfcCmmcCd());
		this.hashColumns.put("rep_cust_cnt_cd", getRepCustCntCd());
		this.hashColumns.put("ofc_entr_lvl_cd", getOfcEntrLvlCd());
		this.hashColumns.put("clz_dt", getClzDt());
		this.hashColumns.put("ofc_zip_cd", getOfcZipCd());
		this.hashColumns.put("ofc_addr", getOfcAddr());
		this.hashColumns.put("ovpay_tp_cd", getOvpayTpCd());
		this.hashColumns.put("comm_if_ind_cd", getCommIfIndCd());
		this.hashColumns.put("ofc_brnc_agn_tp_cd", getOfcBrncAgnTpCd());
		this.hashColumns.put("team_fax_no", getTeamFaxNo());
		this.hashColumns.put("asa_cr_term_dys", getAsaCrTermDys());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("ofc_rfa_sc_use_flg", getOfcRfaScUseFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("ofc_rmk", getOfcRmk());
		this.hashColumns.put("rct_spcl_rmk", getRctSpclRmk());
		this.hashColumns.put("rep_cust_seq", getRepCustSeq());
		this.hashColumns.put("ap_ctr_cd", getApCtrCd());
		this.hashColumns.put("ofc_fax_no", getOfcFaxNo());
		this.hashColumns.put("ofc_tax_id", getOfcTaxId());
		this.hashColumns.put("doc_rcvr_hide_flg", getDocRcvrHideFlg());
		this.hashColumns.put("agn_pfx_cd", getAgnPfxCd());
		this.hashColumns.put("ots_if_flg", getOtsIfFlg());
		this.hashColumns.put("ofc_locl_lang_addr", getOfcLoclLangAddr());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("eai_if_id", getEaiIfId());
		this.hashColumns.put("ib_cr_term_dys", getIbCrTermDys());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usa_brk_brnc_rqst_ctrl_ofc_cd", getUsaBrkBrncRqstCtrlOfcCd());
		this.hashColumns.put("ofc_phn_no", getOfcPhnNo());
		this.hashColumns.put("rct_ofc_spcl_no_ctnt", getRctOfcSpclNoCtnt());
		this.hashColumns.put("inv_pfx_cd", getInvPfxCd());
		this.hashColumns.put("sls_ofc_use_flg", getSlsOfcUseFlg());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ofc_knd_cd", getOfcKndCd());
		this.hashColumns.put("rct_rmk", getRctRmk());
		this.hashColumns.put("gl_ctr_cd", getGlCtrCd());
		this.hashColumns.put("ofc_pson_knt", getOfcPsonKnt());
		this.hashColumns.put("rct_ofc_telcm_fax_no_ctnt", getRctOfcTelcmFaxNoCtnt());
		this.hashColumns.put("eai_evnt_dt", getEaiEvntDt());
		this.hashColumns.put("sub_agn_flg", getSubAgnFlg());
		this.hashColumns.put("ots_cate_cd", getOtsCateCd());
		this.hashColumns.put("ots_cd", getOtsCd());
		this.hashColumns.put("bank_ofc", getBankOfc());
		this.hashColumns.put("rct_tp_cd", getRctTpCd());
		this.hashColumns.put("ar_agn_stl_cd", getArAgnStlCd());
		this.hashColumns.put("ofc_sls_delt_flg", getOfcSlsDeltFlg());
		this.hashColumns.put("ofc_locl_nm", getOfcLoclNm());
		this.hashColumns.put("sls_ofc_div_cd", getSlsOfcDivCd());
		this.hashColumns.put("intl_phn_no", getIntlPhnNo());
		this.hashColumns.put("rct_unapy_flg", getRctUnapyFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ap_ctrl_ofc_cd", "apCtrlOfcCd");
		this.hashFields.put("bank_chg_acct_cd", "bankChgAcctCd");
		this.hashFields.put("ofc_tp_cd", "ofcTpCd");
		this.hashFields.put("ar_ctrl_ofc_cd", "arCtrlOfcCd");
		this.hashFields.put("ob_cr_term_dys", "obCrTermDys");
		this.hashFields.put("agn_ots_lmt_amt", "agnOtsLmtAmt");
		this.hashFields.put("bil_curr_cd", "bilCurrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fx_curr_rt", "fxCurrRt");
		this.hashFields.put("bank_ctrl_cd", "bankCtrlCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("rct_ofc_addr", "rctOfcAddr");
		this.hashFields.put("team_mgr_nm", "teamMgrNm");
		this.hashFields.put("ar_prn_tit_nm", "arPrnTitNm");
		this.hashFields.put("agn_curr_cd", "agnCurrCd");
		this.hashFields.put("rct_doc_cd", "rctDocCd");
		this.hashFields.put("modi_ofc_cd", "modiOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ap_ofc_cd", "apOfcCd");
		this.hashFields.put("ar_curr_cd", "arCurrCd");
		this.hashFields.put("ar_hd_qtr_ofc_cd", "arHdQtrOfcCd");
		this.hashFields.put("fax_ip", "faxIp");
		this.hashFields.put("finc_hide_flg", "fincHideFlg");
		this.hashFields.put("subs_co_flg", "subsCoFlg");
		this.hashFields.put("ofc_url", "ofcUrl");
		this.hashFields.put("ap_euro_curr_use_flg", "apEuroCurrUseFlg");
		this.hashFields.put("agn_cmb_cd", "agnCmbCd");
		this.hashFields.put("misc_lss_lmt_amt", "miscLssLmtAmt");
		this.hashFields.put("ofc_rep_eml", "ofcRepEml");
		this.hashFields.put("ofc_inq_lvl_cd", "ofcInqLvlCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("ots_smry_cd", "otsSmryCd");
		this.hashFields.put("ofc_eng_nm", "ofcEngNm");
		this.hashFields.put("bkg_svr_srch_rout_cd", "bkgSvrSrchRoutCd");
		this.hashFields.put("ar_ctr_cd", "arCtrCd");
		this.hashFields.put("ofc_cnt_cd", "ofcCntCd");
		this.hashFields.put("intl_fax_no", "intlFaxNo");
		this.hashFields.put("so_if_cd", "soIfCd");
		this.hashFields.put("bfr_ofc_cd", "bfrOfcCd");
		this.hashFields.put("rct_tit_nm", "rctTitNm");
		this.hashFields.put("prc_ofc_cd", "prcOfcCd");
		this.hashFields.put("ap_ho_acct_cd", "apHoAcctCd");
		this.hashFields.put("opn_dt", "opnDt");
		this.hashFields.put("ar_prn_ctnt", "arPrnCtnt");
		this.hashFields.put("enbl_flg", "enblFlg");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("finc_psdo_ofc_flg", "fincPsdoOfcFlg");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("prnt_ofc_cd", "prntOfcCd");
		this.hashFields.put("rct_ofc_tit_nm", "rctOfcTitNm");
		this.hashFields.put("rep_ots_ofc_cd", "repOtsOfcCd");
		this.hashFields.put("ofc_wrtf_tp_cd1", "ofcWrtfTpCd1");
		this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
		this.hashFields.put("agn_knd_cd", "agnKndCd");
		this.hashFields.put("finc_rgn_cd", "fincRgnCd");
		this.hashFields.put("ofc_wrtf_tp_cd4", "ofcWrtfTpCd4");
		this.hashFields.put("ofc_wrtf_tp_cd5", "ofcWrtfTpCd5");
		this.hashFields.put("ofc_wrtf_tp_cd2", "ofcWrtfTpCd2");
		this.hashFields.put("ofc_wrtf_tp_cd3", "ofcWrtfTpCd3");
		this.hashFields.put("misc_incm_lmt_amt", "miscIncmLmtAmt");
		this.hashFields.put("ofc_cmmc_cd", "ofcCmmcCd");
		this.hashFields.put("rep_cust_cnt_cd", "repCustCntCd");
		this.hashFields.put("ofc_entr_lvl_cd", "ofcEntrLvlCd");
		this.hashFields.put("clz_dt", "clzDt");
		this.hashFields.put("ofc_zip_cd", "ofcZipCd");
		this.hashFields.put("ofc_addr", "ofcAddr");
		this.hashFields.put("ovpay_tp_cd", "ovpayTpCd");
		this.hashFields.put("comm_if_ind_cd", "commIfIndCd");
		this.hashFields.put("ofc_brnc_agn_tp_cd", "ofcBrncAgnTpCd");
		this.hashFields.put("team_fax_no", "teamFaxNo");
		this.hashFields.put("asa_cr_term_dys", "asaCrTermDys");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("ofc_rfa_sc_use_flg", "ofcRfaScUseFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("ofc_rmk", "ofcRmk");
		this.hashFields.put("rct_spcl_rmk", "rctSpclRmk");
		this.hashFields.put("rep_cust_seq", "repCustSeq");
		this.hashFields.put("ap_ctr_cd", "apCtrCd");
		this.hashFields.put("ofc_fax_no", "ofcFaxNo");
		this.hashFields.put("ofc_tax_id", "ofcTaxId");
		this.hashFields.put("doc_rcvr_hide_flg", "docRcvrHideFlg");
		this.hashFields.put("agn_pfx_cd", "agnPfxCd");
		this.hashFields.put("ots_if_flg", "otsIfFlg");
		this.hashFields.put("ofc_locl_lang_addr", "ofcLoclLangAddr");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("eai_if_id", "eaiIfId");
		this.hashFields.put("ib_cr_term_dys", "ibCrTermDys");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usa_brk_brnc_rqst_ctrl_ofc_cd", "usaBrkBrncRqstCtrlOfcCd");
		this.hashFields.put("ofc_phn_no", "ofcPhnNo");
		this.hashFields.put("rct_ofc_spcl_no_ctnt", "rctOfcSpclNoCtnt");
		this.hashFields.put("inv_pfx_cd", "invPfxCd");
		this.hashFields.put("sls_ofc_use_flg", "slsOfcUseFlg");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ofc_knd_cd", "ofcKndCd");
		this.hashFields.put("rct_rmk", "rctRmk");
		this.hashFields.put("gl_ctr_cd", "glCtrCd");
		this.hashFields.put("ofc_pson_knt", "ofcPsonKnt");
		this.hashFields.put("rct_ofc_telcm_fax_no_ctnt", "rctOfcTelcmFaxNoCtnt");
		this.hashFields.put("eai_evnt_dt", "eaiEvntDt");
		this.hashFields.put("sub_agn_flg", "subAgnFlg");
		this.hashFields.put("ots_cate_cd", "otsCateCd");
		this.hashFields.put("ots_cd", "otsCd");
		this.hashFields.put("bank_ofc", "bankOfc");
		this.hashFields.put("rct_tp_cd", "rctTpCd");
		this.hashFields.put("ar_agn_stl_cd", "arAgnStlCd");
		this.hashFields.put("ofc_sls_delt_flg", "ofcSlsDeltFlg");
		this.hashFields.put("ofc_locl_nm", "ofcLoclNm");
		this.hashFields.put("sls_ofc_div_cd", "slsOfcDivCd");
		this.hashFields.put("intl_phn_no", "intlPhnNo");
		this.hashFields.put("rct_unapy_flg", "rctUnapyFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return apCtrlOfcCd
	 */
	public String getApCtrlOfcCd() {
		return this.apCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return bankChgAcctCd
	 */
	public String getBankChgAcctCd() {
		return this.bankChgAcctCd;
	}
	
	/**
	 * Column Info
	 * @return ofcTpCd
	 */
	public String getOfcTpCd() {
		return this.ofcTpCd;
	}
	
	/**
	 * Column Info
	 * @return arCtrlOfcCd
	 */
	public String getArCtrlOfcCd() {
		return this.arCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return obCrTermDys
	 */
	public String getObCrTermDys() {
		return this.obCrTermDys;
	}
	
	/**
	 * Column Info
	 * @return agnOtsLmtAmt
	 */
	public String getAgnOtsLmtAmt() {
		return this.agnOtsLmtAmt;
	}
	
	/**
	 * Column Info
	 * @return bilCurrCd
	 */
	public String getBilCurrCd() {
		return this.bilCurrCd;
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
	 * @return fxCurrRt
	 */
	public String getFxCurrRt() {
		return this.fxCurrRt;
	}
	
	/**
	 * Column Info
	 * @return bankCtrlCd
	 */
	public String getBankCtrlCd() {
		return this.bankCtrlCd;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return rctOfcAddr
	 */
	public String getRctOfcAddr() {
		return this.rctOfcAddr;
	}
	
	/**
	 * Column Info
	 * @return teamMgrNm
	 */
	public String getTeamMgrNm() {
		return this.teamMgrNm;
	}
	
	/**
	 * Column Info
	 * @return arPrnTitNm
	 */
	public String getArPrnTitNm() {
		return this.arPrnTitNm;
	}
	
	/**
	 * Column Info
	 * @return agnCurrCd
	 */
	public String getAgnCurrCd() {
		return this.agnCurrCd;
	}
	
	/**
	 * Column Info
	 * @return rctDocCd
	 */
	public String getRctDocCd() {
		return this.rctDocCd;
	}
	
	/**
	 * Column Info
	 * @return modiOfcCd
	 */
	public String getModiOfcCd() {
		return this.modiOfcCd;
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
	 * @return apOfcCd
	 */
	public String getApOfcCd() {
		return this.apOfcCd;
	}
	
	/**
	 * Column Info
	 * @return arCurrCd
	 */
	public String getArCurrCd() {
		return this.arCurrCd;
	}
	
	/**
	 * Column Info
	 * @return arHdQtrOfcCd
	 */
	public String getArHdQtrOfcCd() {
		return this.arHdQtrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return faxIp
	 */
	public String getFaxIp() {
		return this.faxIp;
	}
	
	/**
	 * Column Info
	 * @return fincHideFlg
	 */
	public String getFincHideFlg() {
		return this.fincHideFlg;
	}
	
	/**
	 * Column Info
	 * @return subsCoFlg
	 */
	public String getSubsCoFlg() {
		return this.subsCoFlg;
	}
	
	/**
	 * Column Info
	 * @return ofcUrl
	 */
	public String getOfcUrl() {
		return this.ofcUrl;
	}
	
	/**
	 * Column Info
	 * @return apEuroCurrUseFlg
	 */
	public String getApEuroCurrUseFlg() {
		return this.apEuroCurrUseFlg;
	}
	
	/**
	 * Column Info
	 * @return agnCmbCd
	 */
	public String getAgnCmbCd() {
		return this.agnCmbCd;
	}
	
	/**
	 * Column Info
	 * @return miscLssLmtAmt
	 */
	public String getMiscLssLmtAmt() {
		return this.miscLssLmtAmt;
	}
	
	/**
	 * Column Info
	 * @return ofcRepEml
	 */
	public String getOfcRepEml() {
		return this.ofcRepEml;
	}
	
	/**
	 * Column Info
	 * @return ofcInqLvlCd
	 */
	public String getOfcInqLvlCd() {
		return this.ofcInqLvlCd;
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
	 * @return otsSmryCd
	 */
	public String getOtsSmryCd() {
		return this.otsSmryCd;
	}
	
	/**
	 * Column Info
	 * @return ofcEngNm
	 */
	public String getOfcEngNm() {
		return this.ofcEngNm;
	}
	
	/**
	 * Column Info
	 * @return bkgSvrSrchRoutCd
	 */
	public String getBkgSvrSrchRoutCd() {
		return this.bkgSvrSrchRoutCd;
	}
	
	/**
	 * Column Info
	 * @return arCtrCd
	 */
	public String getArCtrCd() {
		return this.arCtrCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCntCd
	 */
	public String getOfcCntCd() {
		return this.ofcCntCd;
	}
	
	/**
	 * Column Info
	 * @return intlFaxNo
	 */
	public String getIntlFaxNo() {
		return this.intlFaxNo;
	}
	
	/**
	 * Column Info
	 * @return soIfCd
	 */
	public String getSoIfCd() {
		return this.soIfCd;
	}
	
	/**
	 * Column Info
	 * @return bfrOfcCd
	 */
	public String getBfrOfcCd() {
		return this.bfrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rctTitNm
	 */
	public String getRctTitNm() {
		return this.rctTitNm;
	}
	
	/**
	 * Column Info
	 * @return prcOfcCd
	 */
	public String getPrcOfcCd() {
		return this.prcOfcCd;
	}
	
	/**
	 * Column Info
	 * @return apHoAcctCd
	 */
	public String getApHoAcctCd() {
		return this.apHoAcctCd;
	}
	
	/**
	 * Column Info
	 * @return opnDt
	 */
	public String getOpnDt() {
		return this.opnDt;
	}
	
	/**
	 * Column Info
	 * @return arPrnCtnt
	 */
	public String getArPrnCtnt() {
		return this.arPrnCtnt;
	}
	
	/**
	 * Column Info
	 * @return enblFlg
	 */
	public String getEnblFlg() {
		return this.enblFlg;
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
	 * @return fincPsdoOfcFlg
	 */
	public String getFincPsdoOfcFlg() {
		return this.fincPsdoOfcFlg;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return prntOfcCd
	 */
	public String getPrntOfcCd() {
		return this.prntOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rctOfcTitNm
	 */
	public String getRctOfcTitNm() {
		return this.rctOfcTitNm;
	}
	
	/**
	 * Column Info
	 * @return repOtsOfcCd
	 */
	public String getRepOtsOfcCd() {
		return this.repOtsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ofcWrtfTpCd1
	 */
	public String getOfcWrtfTpCd1() {
		return this.ofcWrtfTpCd1;
	}
	
	/**
	 * Column Info
	 * @return vndrCntCd
	 */
	public String getVndrCntCd() {
		return this.vndrCntCd;
	}
	
	/**
	 * Column Info
	 * @return agnKndCd
	 */
	public String getAgnKndCd() {
		return this.agnKndCd;
	}
	
	/**
	 * Column Info
	 * @return fincRgnCd
	 */
	public String getFincRgnCd() {
		return this.fincRgnCd;
	}
	
	/**
	 * Column Info
	 * @return ofcWrtfTpCd4
	 */
	public String getOfcWrtfTpCd4() {
		return this.ofcWrtfTpCd4;
	}
	
	/**
	 * Column Info
	 * @return ofcWrtfTpCd5
	 */
	public String getOfcWrtfTpCd5() {
		return this.ofcWrtfTpCd5;
	}
	
	/**
	 * Column Info
	 * @return ofcWrtfTpCd2
	 */
	public String getOfcWrtfTpCd2() {
		return this.ofcWrtfTpCd2;
	}
	
	/**
	 * Column Info
	 * @return ofcWrtfTpCd3
	 */
	public String getOfcWrtfTpCd3() {
		return this.ofcWrtfTpCd3;
	}
	
	/**
	 * Column Info
	 * @return miscIncmLmtAmt
	 */
	public String getMiscIncmLmtAmt() {
		return this.miscIncmLmtAmt;
	}
	
	/**
	 * Column Info
	 * @return ofcCmmcCd
	 */
	public String getOfcCmmcCd() {
		return this.ofcCmmcCd;
	}
	
	/**
	 * Column Info
	 * @return repCustCntCd
	 */
	public String getRepCustCntCd() {
		return this.repCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return ofcEntrLvlCd
	 */
	public String getOfcEntrLvlCd() {
		return this.ofcEntrLvlCd;
	}
	
	/**
	 * Column Info
	 * @return clzDt
	 */
	public String getClzDt() {
		return this.clzDt;
	}
	
	/**
	 * Column Info
	 * @return ofcZipCd
	 */
	public String getOfcZipCd() {
		return this.ofcZipCd;
	}
	
	/**
	 * Column Info
	 * @return ofcAddr
	 */
	public String getOfcAddr() {
		return this.ofcAddr;
	}
	
	/**
	 * Column Info
	 * @return ovpayTpCd
	 */
	public String getOvpayTpCd() {
		return this.ovpayTpCd;
	}
	
	/**
	 * Column Info
	 * @return commIfIndCd
	 */
	public String getCommIfIndCd() {
		return this.commIfIndCd;
	}
	
	/**
	 * Column Info
	 * @return ofcBrncAgnTpCd
	 */
	public String getOfcBrncAgnTpCd() {
		return this.ofcBrncAgnTpCd;
	}
	
	/**
	 * Column Info
	 * @return teamFaxNo
	 */
	public String getTeamFaxNo() {
		return this.teamFaxNo;
	}
	
	/**
	 * Column Info
	 * @return asaCrTermDys
	 */
	public String getAsaCrTermDys() {
		return this.asaCrTermDys;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCd
	 */
	public String getLoclCurrCd() {
		return this.loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return ofcRfaScUseFlg
	 */
	public String getOfcRfaScUseFlg() {
		return this.ofcRfaScUseFlg;
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
	 * @return ofcRmk
	 */
	public String getOfcRmk() {
		return this.ofcRmk;
	}
	
	/**
	 * Column Info
	 * @return rctSpclRmk
	 */
	public String getRctSpclRmk() {
		return this.rctSpclRmk;
	}
	
	/**
	 * Column Info
	 * @return repCustSeq
	 */
	public String getRepCustSeq() {
		return this.repCustSeq;
	}
	
	/**
	 * Column Info
	 * @return apCtrCd
	 */
	public String getApCtrCd() {
		return this.apCtrCd;
	}
	
	/**
	 * Column Info
	 * @return ofcFaxNo
	 */
	public String getOfcFaxNo() {
		return this.ofcFaxNo;
	}
	
	/**
	 * Column Info
	 * @return ofcTaxId
	 */
	public String getOfcTaxId() {
		return this.ofcTaxId;
	}
	
	/**
	 * Column Info
	 * @return docRcvrHideFlg
	 */
	public String getDocRcvrHideFlg() {
		return this.docRcvrHideFlg;
	}
	
	/**
	 * Column Info
	 * @return agnPfxCd
	 */
	public String getAgnPfxCd() {
		return this.agnPfxCd;
	}
	
	/**
	 * Column Info
	 * @return otsIfFlg
	 */
	public String getOtsIfFlg() {
		return this.otsIfFlg;
	}
	
	/**
	 * Column Info
	 * @return ofcLoclLangAddr
	 */
	public String getOfcLoclLangAddr() {
		return this.ofcLoclLangAddr;
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
	 * @return eaiIfId
	 */
	public String getEaiIfId() {
		return this.eaiIfId;
	}
	
	/**
	 * Column Info
	 * @return ibCrTermDys
	 */
	public String getIbCrTermDys() {
		return this.ibCrTermDys;
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
	 * @return usaBrkBrncRqstCtrlOfcCd
	 */
	public String getUsaBrkBrncRqstCtrlOfcCd() {
		return this.usaBrkBrncRqstCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ofcPhnNo
	 */
	public String getOfcPhnNo() {
		return this.ofcPhnNo;
	}
	
	/**
	 * Column Info
	 * @return rctOfcSpclNoCtnt
	 */
	public String getRctOfcSpclNoCtnt() {
		return this.rctOfcSpclNoCtnt;
	}
	
	/**
	 * Column Info
	 * @return invPfxCd
	 */
	public String getInvPfxCd() {
		return this.invPfxCd;
	}
	
	/**
	 * Column Info
	 * @return slsOfcUseFlg
	 */
	public String getSlsOfcUseFlg() {
		return this.slsOfcUseFlg;
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
	 * @return ofcKndCd
	 */
	public String getOfcKndCd() {
		return this.ofcKndCd;
	}
	
	/**
	 * Column Info
	 * @return rctRmk
	 */
	public String getRctRmk() {
		return this.rctRmk;
	}
	
	/**
	 * Column Info
	 * @return glCtrCd
	 */
	public String getGlCtrCd() {
		return this.glCtrCd;
	}
	
	/**
	 * Column Info
	 * @return ofcPsonKnt
	 */
	public String getOfcPsonKnt() {
		return this.ofcPsonKnt;
	}
	
	/**
	 * Column Info
	 * @return rctOfcTelcmFaxNoCtnt
	 */
	public String getRctOfcTelcmFaxNoCtnt() {
		return this.rctOfcTelcmFaxNoCtnt;
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
	 * @return subAgnFlg
	 */
	public String getSubAgnFlg() {
		return this.subAgnFlg;
	}
	
	/**
	 * Column Info
	 * @return otsCateCd
	 */
	public String getOtsCateCd() {
		return this.otsCateCd;
	}
	
	/**
	 * Column Info
	 * @return otsCd
	 */
	public String getOtsCd() {
		return this.otsCd;
	}
	
	/**
	 * Column Info
	 * @return bankOfc
	 */
	public String getBankOfc() {
		return this.bankOfc;
	}
	
	/**
	 * Column Info
	 * @return rctTpCd
	 */
	public String getRctTpCd() {
		return this.rctTpCd;
	}
	
	/**
	 * Column Info
	 * @return arAgnStlCd
	 */
	public String getArAgnStlCd() {
		return this.arAgnStlCd;
	}
	
	/**
	 * Column Info
	 * @return ofcSlsDeltFlg
	 */
	public String getOfcSlsDeltFlg() {
		return this.ofcSlsDeltFlg;
	}
	
	/**
	 * Column Info
	 * @return ofcLoclNm
	 */
	public String getOfcLoclNm() {
		return this.ofcLoclNm;
	}
	
	/**
	 * Column Info
	 * @return slsOfcDivCd
	 */
	public String getSlsOfcDivCd() {
		return this.slsOfcDivCd;
	}
	
	/**
	 * Column Info
	 * @return intlPhnNo
	 */
	public String getIntlPhnNo() {
		return this.intlPhnNo;
	}
	
	/**
	 * Column Info
	 * @return rctUnapyFlg
	 */
	public String getRctUnapyFlg() {
		return this.rctUnapyFlg;
	}
	

	/**
	 * Column Info
	 * @param apCtrlOfcCd
	 */
	public void setApCtrlOfcCd(String apCtrlOfcCd) {
		this.apCtrlOfcCd = apCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param bankChgAcctCd
	 */
	public void setBankChgAcctCd(String bankChgAcctCd) {
		this.bankChgAcctCd = bankChgAcctCd;
	}
	
	/**
	 * Column Info
	 * @param ofcTpCd
	 */
	public void setOfcTpCd(String ofcTpCd) {
		this.ofcTpCd = ofcTpCd;
	}
	
	/**
	 * Column Info
	 * @param arCtrlOfcCd
	 */
	public void setArCtrlOfcCd(String arCtrlOfcCd) {
		this.arCtrlOfcCd = arCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param obCrTermDys
	 */
	public void setObCrTermDys(String obCrTermDys) {
		this.obCrTermDys = obCrTermDys;
	}
	
	/**
	 * Column Info
	 * @param agnOtsLmtAmt
	 */
	public void setAgnOtsLmtAmt(String agnOtsLmtAmt) {
		this.agnOtsLmtAmt = agnOtsLmtAmt;
	}
	
	/**
	 * Column Info
	 * @param bilCurrCd
	 */
	public void setBilCurrCd(String bilCurrCd) {
		this.bilCurrCd = bilCurrCd;
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
	 * @param fxCurrRt
	 */
	public void setFxCurrRt(String fxCurrRt) {
		this.fxCurrRt = fxCurrRt;
	}
	
	/**
	 * Column Info
	 * @param bankCtrlCd
	 */
	public void setBankCtrlCd(String bankCtrlCd) {
		this.bankCtrlCd = bankCtrlCd;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param rctOfcAddr
	 */
	public void setRctOfcAddr(String rctOfcAddr) {
		this.rctOfcAddr = rctOfcAddr;
	}
	
	/**
	 * Column Info
	 * @param teamMgrNm
	 */
	public void setTeamMgrNm(String teamMgrNm) {
		this.teamMgrNm = teamMgrNm;
	}
	
	/**
	 * Column Info
	 * @param arPrnTitNm
	 */
	public void setArPrnTitNm(String arPrnTitNm) {
		this.arPrnTitNm = arPrnTitNm;
	}
	
	/**
	 * Column Info
	 * @param agnCurrCd
	 */
	public void setAgnCurrCd(String agnCurrCd) {
		this.agnCurrCd = agnCurrCd;
	}
	
	/**
	 * Column Info
	 * @param rctDocCd
	 */
	public void setRctDocCd(String rctDocCd) {
		this.rctDocCd = rctDocCd;
	}
	
	/**
	 * Column Info
	 * @param modiOfcCd
	 */
	public void setModiOfcCd(String modiOfcCd) {
		this.modiOfcCd = modiOfcCd;
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
	 * @param apOfcCd
	 */
	public void setApOfcCd(String apOfcCd) {
		this.apOfcCd = apOfcCd;
	}
	
	/**
	 * Column Info
	 * @param arCurrCd
	 */
	public void setArCurrCd(String arCurrCd) {
		this.arCurrCd = arCurrCd;
	}
	
	/**
	 * Column Info
	 * @param arHdQtrOfcCd
	 */
	public void setArHdQtrOfcCd(String arHdQtrOfcCd) {
		this.arHdQtrOfcCd = arHdQtrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param faxIp
	 */
	public void setFaxIp(String faxIp) {
		this.faxIp = faxIp;
	}
	
	/**
	 * Column Info
	 * @param fincHideFlg
	 */
	public void setFincHideFlg(String fincHideFlg) {
		this.fincHideFlg = fincHideFlg;
	}
	
	/**
	 * Column Info
	 * @param subsCoFlg
	 */
	public void setSubsCoFlg(String subsCoFlg) {
		this.subsCoFlg = subsCoFlg;
	}
	
	/**
	 * Column Info
	 * @param ofcUrl
	 */
	public void setOfcUrl(String ofcUrl) {
		this.ofcUrl = ofcUrl;
	}
	
	/**
	 * Column Info
	 * @param apEuroCurrUseFlg
	 */
	public void setApEuroCurrUseFlg(String apEuroCurrUseFlg) {
		this.apEuroCurrUseFlg = apEuroCurrUseFlg;
	}
	
	/**
	 * Column Info
	 * @param agnCmbCd
	 */
	public void setAgnCmbCd(String agnCmbCd) {
		this.agnCmbCd = agnCmbCd;
	}
	
	/**
	 * Column Info
	 * @param miscLssLmtAmt
	 */
	public void setMiscLssLmtAmt(String miscLssLmtAmt) {
		this.miscLssLmtAmt = miscLssLmtAmt;
	}
	
	/**
	 * Column Info
	 * @param ofcRepEml
	 */
	public void setOfcRepEml(String ofcRepEml) {
		this.ofcRepEml = ofcRepEml;
	}
	
	/**
	 * Column Info
	 * @param ofcInqLvlCd
	 */
	public void setOfcInqLvlCd(String ofcInqLvlCd) {
		this.ofcInqLvlCd = ofcInqLvlCd;
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
	 * @param otsSmryCd
	 */
	public void setOtsSmryCd(String otsSmryCd) {
		this.otsSmryCd = otsSmryCd;
	}
	
	/**
	 * Column Info
	 * @param ofcEngNm
	 */
	public void setOfcEngNm(String ofcEngNm) {
		this.ofcEngNm = ofcEngNm;
	}
	
	/**
	 * Column Info
	 * @param bkgSvrSrchRoutCd
	 */
	public void setBkgSvrSrchRoutCd(String bkgSvrSrchRoutCd) {
		this.bkgSvrSrchRoutCd = bkgSvrSrchRoutCd;
	}
	
	/**
	 * Column Info
	 * @param arCtrCd
	 */
	public void setArCtrCd(String arCtrCd) {
		this.arCtrCd = arCtrCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCntCd
	 */
	public void setOfcCntCd(String ofcCntCd) {
		this.ofcCntCd = ofcCntCd;
	}
	
	/**
	 * Column Info
	 * @param intlFaxNo
	 */
	public void setIntlFaxNo(String intlFaxNo) {
		this.intlFaxNo = intlFaxNo;
	}
	
	/**
	 * Column Info
	 * @param soIfCd
	 */
	public void setSoIfCd(String soIfCd) {
		this.soIfCd = soIfCd;
	}
	
	/**
	 * Column Info
	 * @param bfrOfcCd
	 */
	public void setBfrOfcCd(String bfrOfcCd) {
		this.bfrOfcCd = bfrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rctTitNm
	 */
	public void setRctTitNm(String rctTitNm) {
		this.rctTitNm = rctTitNm;
	}
	
	/**
	 * Column Info
	 * @param prcOfcCd
	 */
	public void setPrcOfcCd(String prcOfcCd) {
		this.prcOfcCd = prcOfcCd;
	}
	
	/**
	 * Column Info
	 * @param apHoAcctCd
	 */
	public void setApHoAcctCd(String apHoAcctCd) {
		this.apHoAcctCd = apHoAcctCd;
	}
	
	/**
	 * Column Info
	 * @param opnDt
	 */
	public void setOpnDt(String opnDt) {
		this.opnDt = opnDt;
	}
	
	/**
	 * Column Info
	 * @param arPrnCtnt
	 */
	public void setArPrnCtnt(String arPrnCtnt) {
		this.arPrnCtnt = arPrnCtnt;
	}
	
	/**
	 * Column Info
	 * @param enblFlg
	 */
	public void setEnblFlg(String enblFlg) {
		this.enblFlg = enblFlg;
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
	 * @param fincPsdoOfcFlg
	 */
	public void setFincPsdoOfcFlg(String fincPsdoOfcFlg) {
		this.fincPsdoOfcFlg = fincPsdoOfcFlg;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param prntOfcCd
	 */
	public void setPrntOfcCd(String prntOfcCd) {
		this.prntOfcCd = prntOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rctOfcTitNm
	 */
	public void setRctOfcTitNm(String rctOfcTitNm) {
		this.rctOfcTitNm = rctOfcTitNm;
	}
	
	/**
	 * Column Info
	 * @param repOtsOfcCd
	 */
	public void setRepOtsOfcCd(String repOtsOfcCd) {
		this.repOtsOfcCd = repOtsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ofcWrtfTpCd1
	 */
	public void setOfcWrtfTpCd1(String ofcWrtfTpCd1) {
		this.ofcWrtfTpCd1 = ofcWrtfTpCd1;
	}
	
	/**
	 * Column Info
	 * @param vndrCntCd
	 */
	public void setVndrCntCd(String vndrCntCd) {
		this.vndrCntCd = vndrCntCd;
	}
	
	/**
	 * Column Info
	 * @param agnKndCd
	 */
	public void setAgnKndCd(String agnKndCd) {
		this.agnKndCd = agnKndCd;
	}
	
	/**
	 * Column Info
	 * @param fincRgnCd
	 */
	public void setFincRgnCd(String fincRgnCd) {
		this.fincRgnCd = fincRgnCd;
	}
	
	/**
	 * Column Info
	 * @param ofcWrtfTpCd4
	 */
	public void setOfcWrtfTpCd4(String ofcWrtfTpCd4) {
		this.ofcWrtfTpCd4 = ofcWrtfTpCd4;
	}
	
	/**
	 * Column Info
	 * @param ofcWrtfTpCd5
	 */
	public void setOfcWrtfTpCd5(String ofcWrtfTpCd5) {
		this.ofcWrtfTpCd5 = ofcWrtfTpCd5;
	}
	
	/**
	 * Column Info
	 * @param ofcWrtfTpCd2
	 */
	public void setOfcWrtfTpCd2(String ofcWrtfTpCd2) {
		this.ofcWrtfTpCd2 = ofcWrtfTpCd2;
	}
	
	/**
	 * Column Info
	 * @param ofcWrtfTpCd3
	 */
	public void setOfcWrtfTpCd3(String ofcWrtfTpCd3) {
		this.ofcWrtfTpCd3 = ofcWrtfTpCd3;
	}
	
	/**
	 * Column Info
	 * @param miscIncmLmtAmt
	 */
	public void setMiscIncmLmtAmt(String miscIncmLmtAmt) {
		this.miscIncmLmtAmt = miscIncmLmtAmt;
	}
	
	/**
	 * Column Info
	 * @param ofcCmmcCd
	 */
	public void setOfcCmmcCd(String ofcCmmcCd) {
		this.ofcCmmcCd = ofcCmmcCd;
	}
	
	/**
	 * Column Info
	 * @param repCustCntCd
	 */
	public void setRepCustCntCd(String repCustCntCd) {
		this.repCustCntCd = repCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param ofcEntrLvlCd
	 */
	public void setOfcEntrLvlCd(String ofcEntrLvlCd) {
		this.ofcEntrLvlCd = ofcEntrLvlCd;
	}
	
	/**
	 * Column Info
	 * @param clzDt
	 */
	public void setClzDt(String clzDt) {
		this.clzDt = clzDt;
	}
	
	/**
	 * Column Info
	 * @param ofcZipCd
	 */
	public void setOfcZipCd(String ofcZipCd) {
		this.ofcZipCd = ofcZipCd;
	}
	
	/**
	 * Column Info
	 * @param ofcAddr
	 */
	public void setOfcAddr(String ofcAddr) {
		this.ofcAddr = ofcAddr;
	}
	
	/**
	 * Column Info
	 * @param ovpayTpCd
	 */
	public void setOvpayTpCd(String ovpayTpCd) {
		this.ovpayTpCd = ovpayTpCd;
	}
	
	/**
	 * Column Info
	 * @param commIfIndCd
	 */
	public void setCommIfIndCd(String commIfIndCd) {
		this.commIfIndCd = commIfIndCd;
	}
	
	/**
	 * Column Info
	 * @param ofcBrncAgnTpCd
	 */
	public void setOfcBrncAgnTpCd(String ofcBrncAgnTpCd) {
		this.ofcBrncAgnTpCd = ofcBrncAgnTpCd;
	}
	
	/**
	 * Column Info
	 * @param teamFaxNo
	 */
	public void setTeamFaxNo(String teamFaxNo) {
		this.teamFaxNo = teamFaxNo;
	}
	
	/**
	 * Column Info
	 * @param asaCrTermDys
	 */
	public void setAsaCrTermDys(String asaCrTermDys) {
		this.asaCrTermDys = asaCrTermDys;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCd
	 */
	public void setLoclCurrCd(String loclCurrCd) {
		this.loclCurrCd = loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param ofcRfaScUseFlg
	 */
	public void setOfcRfaScUseFlg(String ofcRfaScUseFlg) {
		this.ofcRfaScUseFlg = ofcRfaScUseFlg;
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
	 * @param ofcRmk
	 */
	public void setOfcRmk(String ofcRmk) {
		this.ofcRmk = ofcRmk;
	}
	
	/**
	 * Column Info
	 * @param rctSpclRmk
	 */
	public void setRctSpclRmk(String rctSpclRmk) {
		this.rctSpclRmk = rctSpclRmk;
	}
	
	/**
	 * Column Info
	 * @param repCustSeq
	 */
	public void setRepCustSeq(String repCustSeq) {
		this.repCustSeq = repCustSeq;
	}
	
	/**
	 * Column Info
	 * @param apCtrCd
	 */
	public void setApCtrCd(String apCtrCd) {
		this.apCtrCd = apCtrCd;
	}
	
	/**
	 * Column Info
	 * @param ofcFaxNo
	 */
	public void setOfcFaxNo(String ofcFaxNo) {
		this.ofcFaxNo = ofcFaxNo;
	}
	
	/**
	 * Column Info
	 * @param ofcTaxId
	 */
	public void setOfcTaxId(String ofcTaxId) {
		this.ofcTaxId = ofcTaxId;
	}
	
	/**
	 * Column Info
	 * @param docRcvrHideFlg
	 */
	public void setDocRcvrHideFlg(String docRcvrHideFlg) {
		this.docRcvrHideFlg = docRcvrHideFlg;
	}
	
	/**
	 * Column Info
	 * @param agnPfxCd
	 */
	public void setAgnPfxCd(String agnPfxCd) {
		this.agnPfxCd = agnPfxCd;
	}
	
	/**
	 * Column Info
	 * @param otsIfFlg
	 */
	public void setOtsIfFlg(String otsIfFlg) {
		this.otsIfFlg = otsIfFlg;
	}
	
	/**
	 * Column Info
	 * @param ofcLoclLangAddr
	 */
	public void setOfcLoclLangAddr(String ofcLoclLangAddr) {
		this.ofcLoclLangAddr = ofcLoclLangAddr;
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
	 * @param eaiIfId
	 */
	public void setEaiIfId(String eaiIfId) {
		this.eaiIfId = eaiIfId;
	}
	
	/**
	 * Column Info
	 * @param ibCrTermDys
	 */
	public void setIbCrTermDys(String ibCrTermDys) {
		this.ibCrTermDys = ibCrTermDys;
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
	 * @param usaBrkBrncRqstCtrlOfcCd
	 */
	public void setUsaBrkBrncRqstCtrlOfcCd(String usaBrkBrncRqstCtrlOfcCd) {
		this.usaBrkBrncRqstCtrlOfcCd = usaBrkBrncRqstCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ofcPhnNo
	 */
	public void setOfcPhnNo(String ofcPhnNo) {
		this.ofcPhnNo = ofcPhnNo;
	}
	
	/**
	 * Column Info
	 * @param rctOfcSpclNoCtnt
	 */
	public void setRctOfcSpclNoCtnt(String rctOfcSpclNoCtnt) {
		this.rctOfcSpclNoCtnt = rctOfcSpclNoCtnt;
	}
	
	/**
	 * Column Info
	 * @param invPfxCd
	 */
	public void setInvPfxCd(String invPfxCd) {
		this.invPfxCd = invPfxCd;
	}
	
	/**
	 * Column Info
	 * @param slsOfcUseFlg
	 */
	public void setSlsOfcUseFlg(String slsOfcUseFlg) {
		this.slsOfcUseFlg = slsOfcUseFlg;
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
	 * @param ofcKndCd
	 */
	public void setOfcKndCd(String ofcKndCd) {
		this.ofcKndCd = ofcKndCd;
	}
	
	/**
	 * Column Info
	 * @param rctRmk
	 */
	public void setRctRmk(String rctRmk) {
		this.rctRmk = rctRmk;
	}
	
	/**
	 * Column Info
	 * @param glCtrCd
	 */
	public void setGlCtrCd(String glCtrCd) {
		this.glCtrCd = glCtrCd;
	}
	
	/**
	 * Column Info
	 * @param ofcPsonKnt
	 */
	public void setOfcPsonKnt(String ofcPsonKnt) {
		this.ofcPsonKnt = ofcPsonKnt;
	}
	
	/**
	 * Column Info
	 * @param rctOfcTelcmFaxNoCtnt
	 */
	public void setRctOfcTelcmFaxNoCtnt(String rctOfcTelcmFaxNoCtnt) {
		this.rctOfcTelcmFaxNoCtnt = rctOfcTelcmFaxNoCtnt;
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
	 * @param subAgnFlg
	 */
	public void setSubAgnFlg(String subAgnFlg) {
		this.subAgnFlg = subAgnFlg;
	}
	
	/**
	 * Column Info
	 * @param otsCateCd
	 */
	public void setOtsCateCd(String otsCateCd) {
		this.otsCateCd = otsCateCd;
	}
	
	/**
	 * Column Info
	 * @param otsCd
	 */
	public void setOtsCd(String otsCd) {
		this.otsCd = otsCd;
	}
	
	/**
	 * Column Info
	 * @param bankOfc
	 */
	public void setBankOfc(String bankOfc) {
		this.bankOfc = bankOfc;
	}
	
	/**
	 * Column Info
	 * @param rctTpCd
	 */
	public void setRctTpCd(String rctTpCd) {
		this.rctTpCd = rctTpCd;
	}
	
	/**
	 * Column Info
	 * @param arAgnStlCd
	 */
	public void setArAgnStlCd(String arAgnStlCd) {
		this.arAgnStlCd = arAgnStlCd;
	}
	
	/**
	 * Column Info
	 * @param ofcSlsDeltFlg
	 */
	public void setOfcSlsDeltFlg(String ofcSlsDeltFlg) {
		this.ofcSlsDeltFlg = ofcSlsDeltFlg;
	}
	
	/**
	 * Column Info
	 * @param ofcLoclNm
	 */
	public void setOfcLoclNm(String ofcLoclNm) {
		this.ofcLoclNm = ofcLoclNm;
	}
	
	/**
	 * Column Info
	 * @param slsOfcDivCd
	 */
	public void setSlsOfcDivCd(String slsOfcDivCd) {
		this.slsOfcDivCd = slsOfcDivCd;
	}
	
	/**
	 * Column Info
	 * @param intlPhnNo
	 */
	public void setIntlPhnNo(String intlPhnNo) {
		this.intlPhnNo = intlPhnNo;
	}
	
	/**
	 * Column Info
	 * @param rctUnapyFlg
	 */
	public void setRctUnapyFlg(String rctUnapyFlg) {
		this.rctUnapyFlg = rctUnapyFlg;
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
		setApCtrlOfcCd(JSPUtil.getParameter(request, prefix + "ap_ctrl_ofc_cd", ""));
		setBankChgAcctCd(JSPUtil.getParameter(request, prefix + "bank_chg_acct_cd", ""));
		setOfcTpCd(JSPUtil.getParameter(request, prefix + "ofc_tp_cd", ""));
		setArCtrlOfcCd(JSPUtil.getParameter(request, prefix + "ar_ctrl_ofc_cd", ""));
		setObCrTermDys(JSPUtil.getParameter(request, prefix + "ob_cr_term_dys", ""));
		setAgnOtsLmtAmt(JSPUtil.getParameter(request, prefix + "agn_ots_lmt_amt", ""));
		setBilCurrCd(JSPUtil.getParameter(request, prefix + "bil_curr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFxCurrRt(JSPUtil.getParameter(request, prefix + "fx_curr_rt", ""));
		setBankCtrlCd(JSPUtil.getParameter(request, prefix + "bank_ctrl_cd", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setRctOfcAddr(JSPUtil.getParameter(request, prefix + "rct_ofc_addr", ""));
		setTeamMgrNm(JSPUtil.getParameter(request, prefix + "team_mgr_nm", ""));
		setArPrnTitNm(JSPUtil.getParameter(request, prefix + "ar_prn_tit_nm", ""));
		setAgnCurrCd(JSPUtil.getParameter(request, prefix + "agn_curr_cd", ""));
		setRctDocCd(JSPUtil.getParameter(request, prefix + "rct_doc_cd", ""));
		setModiOfcCd(JSPUtil.getParameter(request, prefix + "modi_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setApOfcCd(JSPUtil.getParameter(request, prefix + "ap_ofc_cd", ""));
		setArCurrCd(JSPUtil.getParameter(request, prefix + "ar_curr_cd", ""));
		setArHdQtrOfcCd(JSPUtil.getParameter(request, prefix + "ar_hd_qtr_ofc_cd", ""));
		setFaxIp(JSPUtil.getParameter(request, prefix + "fax_ip", ""));
		setFincHideFlg(JSPUtil.getParameter(request, prefix + "finc_hide_flg", ""));
		setSubsCoFlg(JSPUtil.getParameter(request, prefix + "subs_co_flg", ""));
		setOfcUrl(JSPUtil.getParameter(request, prefix + "ofc_url", ""));
		setApEuroCurrUseFlg(JSPUtil.getParameter(request, prefix + "ap_euro_curr_use_flg", ""));
		setAgnCmbCd(JSPUtil.getParameter(request, prefix + "agn_cmb_cd", ""));
		setMiscLssLmtAmt(JSPUtil.getParameter(request, prefix + "misc_lss_lmt_amt", ""));
		setOfcRepEml(JSPUtil.getParameter(request, prefix + "ofc_rep_eml", ""));
		setOfcInqLvlCd(JSPUtil.getParameter(request, prefix + "ofc_inq_lvl_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setOtsSmryCd(JSPUtil.getParameter(request, prefix + "ots_smry_cd", ""));
		setOfcEngNm(JSPUtil.getParameter(request, prefix + "ofc_eng_nm", ""));
		setBkgSvrSrchRoutCd(JSPUtil.getParameter(request, prefix + "bkg_svr_srch_rout_cd", ""));
		setArCtrCd(JSPUtil.getParameter(request, prefix + "ar_ctr_cd", ""));
		setOfcCntCd(JSPUtil.getParameter(request, prefix + "ofc_cnt_cd", ""));
		setIntlFaxNo(JSPUtil.getParameter(request, prefix + "intl_fax_no", ""));
		setSoIfCd(JSPUtil.getParameter(request, prefix + "so_if_cd", ""));
		setBfrOfcCd(JSPUtil.getParameter(request, prefix + "bfr_ofc_cd", ""));
		setRctTitNm(JSPUtil.getParameter(request, prefix + "rct_tit_nm", ""));
		setPrcOfcCd(JSPUtil.getParameter(request, prefix + "prc_ofc_cd", ""));
		setApHoAcctCd(JSPUtil.getParameter(request, prefix + "ap_ho_acct_cd", ""));
		setOpnDt(JSPUtil.getParameter(request, prefix + "opn_dt", ""));
		setArPrnCtnt(JSPUtil.getParameter(request, prefix + "ar_prn_ctnt", ""));
		setEnblFlg(JSPUtil.getParameter(request, prefix + "enbl_flg", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setFincPsdoOfcFlg(JSPUtil.getParameter(request, prefix + "finc_psdo_ofc_flg", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setPrntOfcCd(JSPUtil.getParameter(request, prefix + "prnt_ofc_cd", ""));
		setRctOfcTitNm(JSPUtil.getParameter(request, prefix + "rct_ofc_tit_nm", ""));
		setRepOtsOfcCd(JSPUtil.getParameter(request, prefix + "rep_ots_ofc_cd", ""));
		setOfcWrtfTpCd1(JSPUtil.getParameter(request, prefix + "ofc_wrtf_tp_cd1", ""));
		setVndrCntCd(JSPUtil.getParameter(request, prefix + "vndr_cnt_cd", ""));
		setAgnKndCd(JSPUtil.getParameter(request, prefix + "agn_knd_cd", ""));
		setFincRgnCd(JSPUtil.getParameter(request, prefix + "finc_rgn_cd", ""));
		setOfcWrtfTpCd4(JSPUtil.getParameter(request, prefix + "ofc_wrtf_tp_cd4", ""));
		setOfcWrtfTpCd5(JSPUtil.getParameter(request, prefix + "ofc_wrtf_tp_cd5", ""));
		setOfcWrtfTpCd2(JSPUtil.getParameter(request, prefix + "ofc_wrtf_tp_cd2", ""));
		setOfcWrtfTpCd3(JSPUtil.getParameter(request, prefix + "ofc_wrtf_tp_cd3", ""));
		setMiscIncmLmtAmt(JSPUtil.getParameter(request, prefix + "misc_incm_lmt_amt", ""));
		setOfcCmmcCd(JSPUtil.getParameter(request, prefix + "ofc_cmmc_cd", ""));
		setRepCustCntCd(JSPUtil.getParameter(request, prefix + "rep_cust_cnt_cd", ""));
		setOfcEntrLvlCd(JSPUtil.getParameter(request, prefix + "ofc_entr_lvl_cd", ""));
		setClzDt(JSPUtil.getParameter(request, prefix + "clz_dt", ""));
		setOfcZipCd(JSPUtil.getParameter(request, prefix + "ofc_zip_cd", ""));
		setOfcAddr(JSPUtil.getParameter(request, prefix + "ofc_addr", ""));
		setOvpayTpCd(JSPUtil.getParameter(request, prefix + "ovpay_tp_cd", ""));
		setCommIfIndCd(JSPUtil.getParameter(request, prefix + "comm_if_ind_cd", ""));
		setOfcBrncAgnTpCd(JSPUtil.getParameter(request, prefix + "ofc_brnc_agn_tp_cd", ""));
		setTeamFaxNo(JSPUtil.getParameter(request, prefix + "team_fax_no", ""));
		setAsaCrTermDys(JSPUtil.getParameter(request, prefix + "asa_cr_term_dys", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
		setOfcRfaScUseFlg(JSPUtil.getParameter(request, prefix + "ofc_rfa_sc_use_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setOfcRmk(JSPUtil.getParameter(request, prefix + "ofc_rmk", ""));
		setRctSpclRmk(JSPUtil.getParameter(request, prefix + "rct_spcl_rmk", ""));
		setRepCustSeq(JSPUtil.getParameter(request, prefix + "rep_cust_seq", ""));
		setApCtrCd(JSPUtil.getParameter(request, prefix + "ap_ctr_cd", ""));
		setOfcFaxNo(JSPUtil.getParameter(request, prefix + "ofc_fax_no", ""));
		setOfcTaxId(JSPUtil.getParameter(request, prefix + "ofc_tax_id", ""));
		setDocRcvrHideFlg(JSPUtil.getParameter(request, prefix + "doc_rcvr_hide_flg", ""));
		setAgnPfxCd(JSPUtil.getParameter(request, prefix + "agn_pfx_cd", ""));
		setOtsIfFlg(JSPUtil.getParameter(request, prefix + "ots_if_flg", ""));
		setOfcLoclLangAddr(JSPUtil.getParameter(request, prefix + "ofc_locl_lang_addr", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setEaiIfId(JSPUtil.getParameter(request, prefix + "eai_if_id", ""));
		setIbCrTermDys(JSPUtil.getParameter(request, prefix + "ib_cr_term_dys", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsaBrkBrncRqstCtrlOfcCd(JSPUtil.getParameter(request, prefix + "usa_brk_brnc_rqst_ctrl_ofc_cd", ""));
		setOfcPhnNo(JSPUtil.getParameter(request, prefix + "ofc_phn_no", ""));
		setRctOfcSpclNoCtnt(JSPUtil.getParameter(request, prefix + "rct_ofc_spcl_no_ctnt", ""));
		setInvPfxCd(JSPUtil.getParameter(request, prefix + "inv_pfx_cd", ""));
		setSlsOfcUseFlg(JSPUtil.getParameter(request, prefix + "sls_ofc_use_flg", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setOfcKndCd(JSPUtil.getParameter(request, prefix + "ofc_knd_cd", ""));
		setRctRmk(JSPUtil.getParameter(request, prefix + "rct_rmk", ""));
		setGlCtrCd(JSPUtil.getParameter(request, prefix + "gl_ctr_cd", ""));
		setOfcPsonKnt(JSPUtil.getParameter(request, prefix + "ofc_pson_knt", ""));
		setRctOfcTelcmFaxNoCtnt(JSPUtil.getParameter(request, prefix + "rct_ofc_telcm_fax_no_ctnt", ""));
		setEaiEvntDt(JSPUtil.getParameter(request, prefix + "eai_evnt_dt", ""));
		setSubAgnFlg(JSPUtil.getParameter(request, prefix + "sub_agn_flg", ""));
		setOtsCateCd(JSPUtil.getParameter(request, prefix + "ots_cate_cd", ""));
		setOtsCd(JSPUtil.getParameter(request, prefix + "ots_cd", ""));
		setBankOfc(JSPUtil.getParameter(request, prefix + "bank_ofc", ""));
		setRctTpCd(JSPUtil.getParameter(request, prefix + "rct_tp_cd", ""));
		setArAgnStlCd(JSPUtil.getParameter(request, prefix + "ar_agn_stl_cd", ""));
		setOfcSlsDeltFlg(JSPUtil.getParameter(request, prefix + "ofc_sls_delt_flg", ""));
		setOfcLoclNm(JSPUtil.getParameter(request, prefix + "ofc_locl_nm", ""));
		setSlsOfcDivCd(JSPUtil.getParameter(request, prefix + "sls_ofc_div_cd", ""));
		setIntlPhnNo(JSPUtil.getParameter(request, prefix + "intl_phn_no", ""));
		setRctUnapyFlg(JSPUtil.getParameter(request, prefix + "rct_unapy_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return StmOfcInfoVO[]
	 */
	public StmOfcInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return StmOfcInfoVO[]
	 */
	public StmOfcInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		StmOfcInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] apCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ap_ctrl_ofc_cd", length));
			String[] bankChgAcctCd = (JSPUtil.getParameter(request, prefix	+ "bank_chg_acct_cd", length));
			String[] ofcTpCd = (JSPUtil.getParameter(request, prefix	+ "ofc_tp_cd", length));
			String[] arCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ctrl_ofc_cd", length));
			String[] obCrTermDys = (JSPUtil.getParameter(request, prefix	+ "ob_cr_term_dys", length));
			String[] agnOtsLmtAmt = (JSPUtil.getParameter(request, prefix	+ "agn_ots_lmt_amt", length));
			String[] bilCurrCd = (JSPUtil.getParameter(request, prefix	+ "bil_curr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fxCurrRt = (JSPUtil.getParameter(request, prefix	+ "fx_curr_rt", length));
			String[] bankCtrlCd = (JSPUtil.getParameter(request, prefix	+ "bank_ctrl_cd", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] rctOfcAddr = (JSPUtil.getParameter(request, prefix	+ "rct_ofc_addr", length));
			String[] teamMgrNm = (JSPUtil.getParameter(request, prefix	+ "team_mgr_nm", length));
			String[] arPrnTitNm = (JSPUtil.getParameter(request, prefix	+ "ar_prn_tit_nm", length));
			String[] agnCurrCd = (JSPUtil.getParameter(request, prefix	+ "agn_curr_cd", length));
			String[] rctDocCd = (JSPUtil.getParameter(request, prefix	+ "rct_doc_cd", length));
			String[] modiOfcCd = (JSPUtil.getParameter(request, prefix	+ "modi_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] apOfcCd = (JSPUtil.getParameter(request, prefix	+ "ap_ofc_cd", length));
			String[] arCurrCd = (JSPUtil.getParameter(request, prefix	+ "ar_curr_cd", length));
			String[] arHdQtrOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_hd_qtr_ofc_cd", length));
			String[] faxIp = (JSPUtil.getParameter(request, prefix	+ "fax_ip", length));
			String[] fincHideFlg = (JSPUtil.getParameter(request, prefix	+ "finc_hide_flg", length));
			String[] subsCoFlg = (JSPUtil.getParameter(request, prefix	+ "subs_co_flg", length));
			String[] ofcUrl = (JSPUtil.getParameter(request, prefix	+ "ofc_url", length));
			String[] apEuroCurrUseFlg = (JSPUtil.getParameter(request, prefix	+ "ap_euro_curr_use_flg", length));
			String[] agnCmbCd = (JSPUtil.getParameter(request, prefix	+ "agn_cmb_cd", length));
			String[] miscLssLmtAmt = (JSPUtil.getParameter(request, prefix	+ "misc_lss_lmt_amt", length));
			String[] ofcRepEml = (JSPUtil.getParameter(request, prefix	+ "ofc_rep_eml", length));
			String[] ofcInqLvlCd = (JSPUtil.getParameter(request, prefix	+ "ofc_inq_lvl_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] otsSmryCd = (JSPUtil.getParameter(request, prefix	+ "ots_smry_cd", length));
			String[] ofcEngNm = (JSPUtil.getParameter(request, prefix	+ "ofc_eng_nm", length));
			String[] bkgSvrSrchRoutCd = (JSPUtil.getParameter(request, prefix	+ "bkg_svr_srch_rout_cd", length));
			String[] arCtrCd = (JSPUtil.getParameter(request, prefix	+ "ar_ctr_cd", length));
			String[] ofcCntCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cnt_cd", length));
			String[] intlFaxNo = (JSPUtil.getParameter(request, prefix	+ "intl_fax_no", length));
			String[] soIfCd = (JSPUtil.getParameter(request, prefix	+ "so_if_cd", length));
			String[] bfrOfcCd = (JSPUtil.getParameter(request, prefix	+ "bfr_ofc_cd", length));
			String[] rctTitNm = (JSPUtil.getParameter(request, prefix	+ "rct_tit_nm", length));
			String[] prcOfcCd = (JSPUtil.getParameter(request, prefix	+ "prc_ofc_cd", length));
			String[] apHoAcctCd = (JSPUtil.getParameter(request, prefix	+ "ap_ho_acct_cd", length));
			String[] opnDt = (JSPUtil.getParameter(request, prefix	+ "opn_dt", length));
			String[] arPrnCtnt = (JSPUtil.getParameter(request, prefix	+ "ar_prn_ctnt", length));
			String[] enblFlg = (JSPUtil.getParameter(request, prefix	+ "enbl_flg", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] fincPsdoOfcFlg = (JSPUtil.getParameter(request, prefix	+ "finc_psdo_ofc_flg", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] prntOfcCd = (JSPUtil.getParameter(request, prefix	+ "prnt_ofc_cd", length));
			String[] rctOfcTitNm = (JSPUtil.getParameter(request, prefix	+ "rct_ofc_tit_nm", length));
			String[] repOtsOfcCd = (JSPUtil.getParameter(request, prefix	+ "rep_ots_ofc_cd", length));
			String[] ofcWrtfTpCd1 = (JSPUtil.getParameter(request, prefix	+ "ofc_wrtf_tp_cd1", length));
			String[] vndrCntCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_cd", length));
			String[] agnKndCd = (JSPUtil.getParameter(request, prefix	+ "agn_knd_cd", length));
			String[] fincRgnCd = (JSPUtil.getParameter(request, prefix	+ "finc_rgn_cd", length));
			String[] ofcWrtfTpCd4 = (JSPUtil.getParameter(request, prefix	+ "ofc_wrtf_tp_cd4", length));
			String[] ofcWrtfTpCd5 = (JSPUtil.getParameter(request, prefix	+ "ofc_wrtf_tp_cd5", length));
			String[] ofcWrtfTpCd2 = (JSPUtil.getParameter(request, prefix	+ "ofc_wrtf_tp_cd2", length));
			String[] ofcWrtfTpCd3 = (JSPUtil.getParameter(request, prefix	+ "ofc_wrtf_tp_cd3", length));
			String[] miscIncmLmtAmt = (JSPUtil.getParameter(request, prefix	+ "misc_incm_lmt_amt", length));
			String[] ofcCmmcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cmmc_cd", length));
			String[] repCustCntCd = (JSPUtil.getParameter(request, prefix	+ "rep_cust_cnt_cd", length));
			String[] ofcEntrLvlCd = (JSPUtil.getParameter(request, prefix	+ "ofc_entr_lvl_cd", length));
			String[] clzDt = (JSPUtil.getParameter(request, prefix	+ "clz_dt", length));
			String[] ofcZipCd = (JSPUtil.getParameter(request, prefix	+ "ofc_zip_cd", length));
			String[] ofcAddr = (JSPUtil.getParameter(request, prefix	+ "ofc_addr", length));
			String[] ovpayTpCd = (JSPUtil.getParameter(request, prefix	+ "ovpay_tp_cd", length));
			String[] commIfIndCd = (JSPUtil.getParameter(request, prefix	+ "comm_if_ind_cd", length));
			String[] ofcBrncAgnTpCd = (JSPUtil.getParameter(request, prefix	+ "ofc_brnc_agn_tp_cd", length));
			String[] teamFaxNo = (JSPUtil.getParameter(request, prefix	+ "team_fax_no", length));
			String[] asaCrTermDys = (JSPUtil.getParameter(request, prefix	+ "asa_cr_term_dys", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] ofcRfaScUseFlg = (JSPUtil.getParameter(request, prefix	+ "ofc_rfa_sc_use_flg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] ofcRmk = (JSPUtil.getParameter(request, prefix	+ "ofc_rmk", length));
			String[] rctSpclRmk = (JSPUtil.getParameter(request, prefix	+ "rct_spcl_rmk", length));
			String[] repCustSeq = (JSPUtil.getParameter(request, prefix	+ "rep_cust_seq", length));
			String[] apCtrCd = (JSPUtil.getParameter(request, prefix	+ "ap_ctr_cd", length));
			String[] ofcFaxNo = (JSPUtil.getParameter(request, prefix	+ "ofc_fax_no", length));
			String[] ofcTaxId = (JSPUtil.getParameter(request, prefix	+ "ofc_tax_id", length));
			String[] docRcvrHideFlg = (JSPUtil.getParameter(request, prefix	+ "doc_rcvr_hide_flg", length));
			String[] agnPfxCd = (JSPUtil.getParameter(request, prefix	+ "agn_pfx_cd", length));
			String[] otsIfFlg = (JSPUtil.getParameter(request, prefix	+ "ots_if_flg", length));
			String[] ofcLoclLangAddr = (JSPUtil.getParameter(request, prefix	+ "ofc_locl_lang_addr", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] eaiIfId = (JSPUtil.getParameter(request, prefix	+ "eai_if_id", length));
			String[] ibCrTermDys = (JSPUtil.getParameter(request, prefix	+ "ib_cr_term_dys", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usaBrkBrncRqstCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "usa_brk_brnc_rqst_ctrl_ofc_cd", length));
			String[] ofcPhnNo = (JSPUtil.getParameter(request, prefix	+ "ofc_phn_no", length));
			String[] rctOfcSpclNoCtnt = (JSPUtil.getParameter(request, prefix	+ "rct_ofc_spcl_no_ctnt", length));
			String[] invPfxCd = (JSPUtil.getParameter(request, prefix	+ "inv_pfx_cd", length));
			String[] slsOfcUseFlg = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_use_flg", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ofcKndCd = (JSPUtil.getParameter(request, prefix	+ "ofc_knd_cd", length));
			String[] rctRmk = (JSPUtil.getParameter(request, prefix	+ "rct_rmk", length));
			String[] glCtrCd = (JSPUtil.getParameter(request, prefix	+ "gl_ctr_cd", length));
			String[] ofcPsonKnt = (JSPUtil.getParameter(request, prefix	+ "ofc_pson_knt", length));
			String[] rctOfcTelcmFaxNoCtnt = (JSPUtil.getParameter(request, prefix	+ "rct_ofc_telcm_fax_no_ctnt", length));
			String[] eaiEvntDt = (JSPUtil.getParameter(request, prefix	+ "eai_evnt_dt", length));
			String[] subAgnFlg = (JSPUtil.getParameter(request, prefix	+ "sub_agn_flg", length));
			String[] otsCateCd = (JSPUtil.getParameter(request, prefix	+ "ots_cate_cd", length));
			String[] otsCd = (JSPUtil.getParameter(request, prefix	+ "ots_cd", length));
			String[] bankOfc = (JSPUtil.getParameter(request, prefix	+ "bank_ofc", length));
			String[] rctTpCd = (JSPUtil.getParameter(request, prefix	+ "rct_tp_cd", length));
			String[] arAgnStlCd = (JSPUtil.getParameter(request, prefix	+ "ar_agn_stl_cd", length));
			String[] ofcSlsDeltFlg = (JSPUtil.getParameter(request, prefix	+ "ofc_sls_delt_flg", length));
			String[] ofcLoclNm = (JSPUtil.getParameter(request, prefix	+ "ofc_locl_nm", length));
			String[] slsOfcDivCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_div_cd", length));
			String[] intlPhnNo = (JSPUtil.getParameter(request, prefix	+ "intl_phn_no", length));
			String[] rctUnapyFlg = (JSPUtil.getParameter(request, prefix	+ "rct_unapy_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new StmOfcInfoVO();
				if (apCtrlOfcCd[i] != null)
					model.setApCtrlOfcCd(apCtrlOfcCd[i]);
				if (bankChgAcctCd[i] != null)
					model.setBankChgAcctCd(bankChgAcctCd[i]);
				if (ofcTpCd[i] != null)
					model.setOfcTpCd(ofcTpCd[i]);
				if (arCtrlOfcCd[i] != null)
					model.setArCtrlOfcCd(arCtrlOfcCd[i]);
				if (obCrTermDys[i] != null)
					model.setObCrTermDys(obCrTermDys[i]);
				if (agnOtsLmtAmt[i] != null)
					model.setAgnOtsLmtAmt(agnOtsLmtAmt[i]);
				if (bilCurrCd[i] != null)
					model.setBilCurrCd(bilCurrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fxCurrRt[i] != null)
					model.setFxCurrRt(fxCurrRt[i]);
				if (bankCtrlCd[i] != null)
					model.setBankCtrlCd(bankCtrlCd[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (rctOfcAddr[i] != null)
					model.setRctOfcAddr(rctOfcAddr[i]);
				if (teamMgrNm[i] != null)
					model.setTeamMgrNm(teamMgrNm[i]);
				if (arPrnTitNm[i] != null)
					model.setArPrnTitNm(arPrnTitNm[i]);
				if (agnCurrCd[i] != null)
					model.setAgnCurrCd(agnCurrCd[i]);
				if (rctDocCd[i] != null)
					model.setRctDocCd(rctDocCd[i]);
				if (modiOfcCd[i] != null)
					model.setModiOfcCd(modiOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (apOfcCd[i] != null)
					model.setApOfcCd(apOfcCd[i]);
				if (arCurrCd[i] != null)
					model.setArCurrCd(arCurrCd[i]);
				if (arHdQtrOfcCd[i] != null)
					model.setArHdQtrOfcCd(arHdQtrOfcCd[i]);
				if (faxIp[i] != null)
					model.setFaxIp(faxIp[i]);
				if (fincHideFlg[i] != null)
					model.setFincHideFlg(fincHideFlg[i]);
				if (subsCoFlg[i] != null)
					model.setSubsCoFlg(subsCoFlg[i]);
				if (ofcUrl[i] != null)
					model.setOfcUrl(ofcUrl[i]);
				if (apEuroCurrUseFlg[i] != null)
					model.setApEuroCurrUseFlg(apEuroCurrUseFlg[i]);
				if (agnCmbCd[i] != null)
					model.setAgnCmbCd(agnCmbCd[i]);
				if (miscLssLmtAmt[i] != null)
					model.setMiscLssLmtAmt(miscLssLmtAmt[i]);
				if (ofcRepEml[i] != null)
					model.setOfcRepEml(ofcRepEml[i]);
				if (ofcInqLvlCd[i] != null)
					model.setOfcInqLvlCd(ofcInqLvlCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (otsSmryCd[i] != null)
					model.setOtsSmryCd(otsSmryCd[i]);
				if (ofcEngNm[i] != null)
					model.setOfcEngNm(ofcEngNm[i]);
				if (bkgSvrSrchRoutCd[i] != null)
					model.setBkgSvrSrchRoutCd(bkgSvrSrchRoutCd[i]);
				if (arCtrCd[i] != null)
					model.setArCtrCd(arCtrCd[i]);
				if (ofcCntCd[i] != null)
					model.setOfcCntCd(ofcCntCd[i]);
				if (intlFaxNo[i] != null)
					model.setIntlFaxNo(intlFaxNo[i]);
				if (soIfCd[i] != null)
					model.setSoIfCd(soIfCd[i]);
				if (bfrOfcCd[i] != null)
					model.setBfrOfcCd(bfrOfcCd[i]);
				if (rctTitNm[i] != null)
					model.setRctTitNm(rctTitNm[i]);
				if (prcOfcCd[i] != null)
					model.setPrcOfcCd(prcOfcCd[i]);
				if (apHoAcctCd[i] != null)
					model.setApHoAcctCd(apHoAcctCd[i]);
				if (opnDt[i] != null)
					model.setOpnDt(opnDt[i]);
				if (arPrnCtnt[i] != null)
					model.setArPrnCtnt(arPrnCtnt[i]);
				if (enblFlg[i] != null)
					model.setEnblFlg(enblFlg[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (fincPsdoOfcFlg[i] != null)
					model.setFincPsdoOfcFlg(fincPsdoOfcFlg[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (prntOfcCd[i] != null)
					model.setPrntOfcCd(prntOfcCd[i]);
				if (rctOfcTitNm[i] != null)
					model.setRctOfcTitNm(rctOfcTitNm[i]);
				if (repOtsOfcCd[i] != null)
					model.setRepOtsOfcCd(repOtsOfcCd[i]);
				if (ofcWrtfTpCd1[i] != null)
					model.setOfcWrtfTpCd1(ofcWrtfTpCd1[i]);
				if (vndrCntCd[i] != null)
					model.setVndrCntCd(vndrCntCd[i]);
				if (agnKndCd[i] != null)
					model.setAgnKndCd(agnKndCd[i]);
				if (fincRgnCd[i] != null)
					model.setFincRgnCd(fincRgnCd[i]);
				if (ofcWrtfTpCd4[i] != null)
					model.setOfcWrtfTpCd4(ofcWrtfTpCd4[i]);
				if (ofcWrtfTpCd5[i] != null)
					model.setOfcWrtfTpCd5(ofcWrtfTpCd5[i]);
				if (ofcWrtfTpCd2[i] != null)
					model.setOfcWrtfTpCd2(ofcWrtfTpCd2[i]);
				if (ofcWrtfTpCd3[i] != null)
					model.setOfcWrtfTpCd3(ofcWrtfTpCd3[i]);
				if (miscIncmLmtAmt[i] != null)
					model.setMiscIncmLmtAmt(miscIncmLmtAmt[i]);
				if (ofcCmmcCd[i] != null)
					model.setOfcCmmcCd(ofcCmmcCd[i]);
				if (repCustCntCd[i] != null)
					model.setRepCustCntCd(repCustCntCd[i]);
				if (ofcEntrLvlCd[i] != null)
					model.setOfcEntrLvlCd(ofcEntrLvlCd[i]);
				if (clzDt[i] != null)
					model.setClzDt(clzDt[i]);
				if (ofcZipCd[i] != null)
					model.setOfcZipCd(ofcZipCd[i]);
				if (ofcAddr[i] != null)
					model.setOfcAddr(ofcAddr[i]);
				if (ovpayTpCd[i] != null)
					model.setOvpayTpCd(ovpayTpCd[i]);
				if (commIfIndCd[i] != null)
					model.setCommIfIndCd(commIfIndCd[i]);
				if (ofcBrncAgnTpCd[i] != null)
					model.setOfcBrncAgnTpCd(ofcBrncAgnTpCd[i]);
				if (teamFaxNo[i] != null)
					model.setTeamFaxNo(teamFaxNo[i]);
				if (asaCrTermDys[i] != null)
					model.setAsaCrTermDys(asaCrTermDys[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (ofcRfaScUseFlg[i] != null)
					model.setOfcRfaScUseFlg(ofcRfaScUseFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (ofcRmk[i] != null)
					model.setOfcRmk(ofcRmk[i]);
				if (rctSpclRmk[i] != null)
					model.setRctSpclRmk(rctSpclRmk[i]);
				if (repCustSeq[i] != null)
					model.setRepCustSeq(repCustSeq[i]);
				if (apCtrCd[i] != null)
					model.setApCtrCd(apCtrCd[i]);
				if (ofcFaxNo[i] != null)
					model.setOfcFaxNo(ofcFaxNo[i]);
				if (ofcTaxId[i] != null)
					model.setOfcTaxId(ofcTaxId[i]);
				if (docRcvrHideFlg[i] != null)
					model.setDocRcvrHideFlg(docRcvrHideFlg[i]);
				if (agnPfxCd[i] != null)
					model.setAgnPfxCd(agnPfxCd[i]);
				if (otsIfFlg[i] != null)
					model.setOtsIfFlg(otsIfFlg[i]);
				if (ofcLoclLangAddr[i] != null)
					model.setOfcLoclLangAddr(ofcLoclLangAddr[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (eaiIfId[i] != null)
					model.setEaiIfId(eaiIfId[i]);
				if (ibCrTermDys[i] != null)
					model.setIbCrTermDys(ibCrTermDys[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usaBrkBrncRqstCtrlOfcCd[i] != null)
					model.setUsaBrkBrncRqstCtrlOfcCd(usaBrkBrncRqstCtrlOfcCd[i]);
				if (ofcPhnNo[i] != null)
					model.setOfcPhnNo(ofcPhnNo[i]);
				if (rctOfcSpclNoCtnt[i] != null)
					model.setRctOfcSpclNoCtnt(rctOfcSpclNoCtnt[i]);
				if (invPfxCd[i] != null)
					model.setInvPfxCd(invPfxCd[i]);
				if (slsOfcUseFlg[i] != null)
					model.setSlsOfcUseFlg(slsOfcUseFlg[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ofcKndCd[i] != null)
					model.setOfcKndCd(ofcKndCd[i]);
				if (rctRmk[i] != null)
					model.setRctRmk(rctRmk[i]);
				if (glCtrCd[i] != null)
					model.setGlCtrCd(glCtrCd[i]);
				if (ofcPsonKnt[i] != null)
					model.setOfcPsonKnt(ofcPsonKnt[i]);
				if (rctOfcTelcmFaxNoCtnt[i] != null)
					model.setRctOfcTelcmFaxNoCtnt(rctOfcTelcmFaxNoCtnt[i]);
				if (eaiEvntDt[i] != null)
					model.setEaiEvntDt(eaiEvntDt[i]);
				if (subAgnFlg[i] != null)
					model.setSubAgnFlg(subAgnFlg[i]);
				if (otsCateCd[i] != null)
					model.setOtsCateCd(otsCateCd[i]);
				if (otsCd[i] != null)
					model.setOtsCd(otsCd[i]);
				if (bankOfc[i] != null)
					model.setBankOfc(bankOfc[i]);
				if (rctTpCd[i] != null)
					model.setRctTpCd(rctTpCd[i]);
				if (arAgnStlCd[i] != null)
					model.setArAgnStlCd(arAgnStlCd[i]);
				if (ofcSlsDeltFlg[i] != null)
					model.setOfcSlsDeltFlg(ofcSlsDeltFlg[i]);
				if (ofcLoclNm[i] != null)
					model.setOfcLoclNm(ofcLoclNm[i]);
				if (slsOfcDivCd[i] != null)
					model.setSlsOfcDivCd(slsOfcDivCd[i]);
				if (intlPhnNo[i] != null)
					model.setIntlPhnNo(intlPhnNo[i]);
				if (rctUnapyFlg[i] != null)
					model.setRctUnapyFlg(rctUnapyFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getStmOfcInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return StmOfcInfoVO[]
	 */
	public StmOfcInfoVO[] getStmOfcInfoVOs(){
		StmOfcInfoVO[] vos = (StmOfcInfoVO[])models.toArray(new StmOfcInfoVO[models.size()]);
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
		this.apCtrlOfcCd = this.apCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankChgAcctCd = this.bankChgAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTpCd = this.ofcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arCtrlOfcCd = this.arCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCrTermDys = this.obCrTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnOtsLmtAmt = this.agnOtsLmtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilCurrCd = this.bilCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fxCurrRt = this.fxCurrRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankCtrlCd = this.bankCtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctOfcAddr = this.rctOfcAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teamMgrNm = this.teamMgrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arPrnTitNm = this.arPrnTitNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCurrCd = this.agnCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctDocCd = this.rctDocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiOfcCd = this.modiOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apOfcCd = this.apOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arCurrCd = this.arCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arHdQtrOfcCd = this.arHdQtrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxIp = this.faxIp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincHideFlg = this.fincHideFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subsCoFlg = this.subsCoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcUrl = this.ofcUrl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apEuroCurrUseFlg = this.apEuroCurrUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCmbCd = this.agnCmbCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.miscLssLmtAmt = this.miscLssLmtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcRepEml = this.ofcRepEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcInqLvlCd = this.ofcInqLvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsSmryCd = this.otsSmryCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcEngNm = this.ofcEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSvrSrchRoutCd = this.bkgSvrSrchRoutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arCtrCd = this.arCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCntCd = this.ofcCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intlFaxNo = this.intlFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soIfCd = this.soIfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrOfcCd = this.bfrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctTitNm = this.rctTitNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcOfcCd = this.prcOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apHoAcctCd = this.apHoAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opnDt = this.opnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arPrnCtnt = this.arPrnCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.enblFlg = this.enblFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincPsdoOfcFlg = this.fincPsdoOfcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prntOfcCd = this.prntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctOfcTitNm = this.rctOfcTitNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repOtsOfcCd = this.repOtsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcWrtfTpCd1 = this.ofcWrtfTpCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntCd = this.vndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnKndCd = this.agnKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincRgnCd = this.fincRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcWrtfTpCd4 = this.ofcWrtfTpCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcWrtfTpCd5 = this.ofcWrtfTpCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcWrtfTpCd2 = this.ofcWrtfTpCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcWrtfTpCd3 = this.ofcWrtfTpCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.miscIncmLmtAmt = this.miscIncmLmtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCmmcCd = this.ofcCmmcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCustCntCd = this.repCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcEntrLvlCd = this.ofcEntrLvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clzDt = this.clzDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcZipCd = this.ofcZipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcAddr = this.ofcAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovpayTpCd = this.ovpayTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commIfIndCd = this.commIfIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcBrncAgnTpCd = this.ofcBrncAgnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teamFaxNo = this.teamFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaCrTermDys = this.asaCrTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcRfaScUseFlg = this.ofcRfaScUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcRmk = this.ofcRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctSpclRmk = this.rctSpclRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCustSeq = this.repCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apCtrCd = this.apCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcFaxNo = this.ofcFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTaxId = this.ofcTaxId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docRcvrHideFlg = this.docRcvrHideFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnPfxCd = this.agnPfxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsIfFlg = this.otsIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcLoclLangAddr = this.ofcLoclLangAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiIfId = this.eaiIfId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCrTermDys = this.ibCrTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaBrkBrncRqstCtrlOfcCd = this.usaBrkBrncRqstCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcPhnNo = this.ofcPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctOfcSpclNoCtnt = this.rctOfcSpclNoCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invPfxCd = this.invPfxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcUseFlg = this.slsOfcUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcKndCd = this.ofcKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctRmk = this.rctRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glCtrCd = this.glCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcPsonKnt = this.ofcPsonKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctOfcTelcmFaxNoCtnt = this.rctOfcTelcmFaxNoCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiEvntDt = this.eaiEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subAgnFlg = this.subAgnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsCateCd = this.otsCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsCd = this.otsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankOfc = this.bankOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctTpCd = this.rctTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arAgnStlCd = this.arAgnStlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcSlsDeltFlg = this.ofcSlsDeltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcLoclNm = this.ofcLoclNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcDivCd = this.slsOfcDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intlPhnNo = this.intlPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctUnapyFlg = this.rctUnapyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
