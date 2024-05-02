/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OfficeReportVO.java
*@FileTitle : OfficeReportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.06  
* 1.0 Creation
=========================================================*/
 
package com.hanjin.apps.alps.bcm.ccd.commoncode.report.vo;

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

public class OfficeReportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OfficeReportVO> models = new ArrayList<OfficeReportVO>();
	
	/* Column Info */
	private String apCtrlOfcCd = null;
	/* Column Info */
	private String vndrCntCd = null;
	/* Column Info */
	private String agnKndCd = null;
	/* Column Info */
	private String fincRgnCd = null;
	/* Column Info */
	private String ppdPtyTpCd = null;
	/* Column Info */
	private String ofcTpCd = null;
	/* Column Info */
	private String modiAgnCd = null;
	/* Column Info */
	private String arCtrlOfcCd = null;
	/* Column Info */
	private String obCrTermDys = null;
	/* Column Info */
	private String bilCurrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fxCurrRt = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String ofcCmmcCd = null;
	/* Column Info */
	private String clzDt = null;
	/* Column Info */
	private String ofcZipCd = null;
	/* Column Info */
	private String ofcAddr = null;
	/* Column Info */
	private String commIfIndCd = null;
	/* Column Info */
	private String apOfcCd = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String arCurrCd = null;
	/* Column Info */
	private String asaCrTermDys = null;
	/* Column Info */
	private String arHdQtrOfcCd = null;
	/* Column Info */
	private String faxIp = null;
	/* Column Info */
	private String fincHideFlg = null;
	/* Column Info */
	private String subsCoFlg = null;
	/* Column Info */
	private String ofcRfaScUseFlg = null;
	/* Column Info */
	private String altnCurrDivCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String ofcRmk = null;
	/* Column Info */
	private String ofcUrl = null;
	/* Column Info */
	private String modiCostCtrCd = null;
	/* Column Info */
	private String apCtrCd = null;
	/* Column Info */
	private String ofcFaxNo = null;
	/* Column Info */
	private String ofcRepEml = null;
	/* Column Info */
	private String docRcvrHideFlg = null;
	/* Column Info */
	private String ofcTaxId = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String ofcLoclLangAddr = null;
	/* Column Info */
	private String ofcEngNm = null;
	/* Column Info */
	private String arCtrCd = null;
	/* Column Info */
	private String ibCrTermDys = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mnlBkgNoOptCd = null;
	/* Column Info */
	private String ofcPhnNo = null;
	/* Column Info */
	private String intlFaxNo = null;
	/* Column Info */
	private String invPfxCd = null;
	/* Column Info */
	private String soIfCd = null;
	/* Column Info */
	private String ofcKndCd = null;
	/* Column Info */
	private String glCtrCd = null;
	/* Column Info */
	private String opnDt = null;
	/* Column Info */
	private String repCustCd = null;
	/* Column Info */
	private String fincPsdoOfcFlg = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String subAgnFlg = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String prntOfcCd = null;
	/* Column Info */
	private String ofcSlsDeltFlg = null;
	/* Column Info */
	private String arAgnStlCd = null;
	/* Column Info */
	private String ofcLoclNm = null;
	/* Column Info */
	private String intlPhnNo = null;
	/* Column Info */
	private String slsOfcDivCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public OfficeReportVO() {}

	public OfficeReportVO(String ibflag, String pagerows, String ofcCd, String ofcEngNm, String ofcLoclNm, String intlPhnNo, String ofcPhnNo, String intlFaxNo, String ofcFaxNo, String ofcUrl, String ofcRepEml, String ofcZipCd, String ofcAddr, String ofcLoclLangAddr, String ofcTpCd, String ofcCmmcCd, String ofcKndCd, String agnKndCd, String prntOfcCd, String ofcSlsDeltFlg, String locCd, String faxIp, String opnDt, String clzDt, String fincPsdoOfcFlg, String docRcvrHideFlg, String fincHideFlg, String subsCoFlg, String slsOfcDivCd, String ofcRfaScUseFlg, String ofcRmk, String arOfcCd, String arCtrlOfcCd, String arHdQtrOfcCd, String arCtrCd, String fincRgnCd, String obCrTermDys, String ibCrTermDys, String arCurrCd, String repCustCd, String invPfxCd, String fxCurrRt, String ofcTaxId, String asaCrTermDys, String subAgnFlg, String arAgnStlCd, String apOfcCd, String apCtrlOfcCd, String apCtrCd, String glCtrCd, String commIfIndCd, String bilCurrCd, String vndrCntCd, String vndrSeq, String soIfCd, String deltFlg, String ppdPtyTpCd, String altnCurrDivCd, String mnlBkgNoOptCd, String modiCostCtrCd, String modiAgnCd, String status, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.apCtrlOfcCd = apCtrlOfcCd;
		this.vndrCntCd = vndrCntCd;
		this.agnKndCd = agnKndCd;
		this.fincRgnCd = fincRgnCd;
		this.ppdPtyTpCd = ppdPtyTpCd;
		this.ofcTpCd = ofcTpCd;
		this.modiAgnCd = modiAgnCd;
		this.arCtrlOfcCd = arCtrlOfcCd;
		this.obCrTermDys = obCrTermDys;
		this.bilCurrCd = bilCurrCd;
		this.pagerows = pagerows;
		this.fxCurrRt = fxCurrRt;
		this.locCd = locCd;
		this.ofcCmmcCd = ofcCmmcCd;
		this.clzDt = clzDt;
		this.ofcZipCd = ofcZipCd;
		this.ofcAddr = ofcAddr;
		this.commIfIndCd = commIfIndCd;
		this.apOfcCd = apOfcCd;
		this.status = status;
		this.arCurrCd = arCurrCd;
		this.asaCrTermDys = asaCrTermDys;
		this.arHdQtrOfcCd = arHdQtrOfcCd;
		this.faxIp = faxIp;
		this.fincHideFlg = fincHideFlg;
		this.subsCoFlg = subsCoFlg;
		this.ofcRfaScUseFlg = ofcRfaScUseFlg;
		this.altnCurrDivCd = altnCurrDivCd;
		this.vndrSeq = vndrSeq;
		this.ofcRmk = ofcRmk;
		this.ofcUrl = ofcUrl;
		this.modiCostCtrCd = modiCostCtrCd;
		this.apCtrCd = apCtrCd;
		this.ofcFaxNo = ofcFaxNo;
		this.ofcRepEml = ofcRepEml;
		this.docRcvrHideFlg = docRcvrHideFlg;
		this.ofcTaxId = ofcTaxId;
		this.deltFlg = deltFlg;
		this.ofcLoclLangAddr = ofcLoclLangAddr;
		this.ofcEngNm = ofcEngNm;
		this.arCtrCd = arCtrCd;
		this.ibCrTermDys = ibCrTermDys;
		this.ibflag = ibflag;
		this.mnlBkgNoOptCd = mnlBkgNoOptCd;
		this.ofcPhnNo = ofcPhnNo;
		this.intlFaxNo = intlFaxNo;
		this.invPfxCd = invPfxCd;
		this.soIfCd = soIfCd;
		this.ofcKndCd = ofcKndCd;
		this.glCtrCd = glCtrCd;
		this.opnDt = opnDt;
		this.repCustCd = repCustCd;
		this.fincPsdoOfcFlg = fincPsdoOfcFlg;
		this.arOfcCd = arOfcCd;
		this.subAgnFlg = subAgnFlg;
		this.ofcCd = ofcCd;
		this.prntOfcCd = prntOfcCd;
		this.ofcSlsDeltFlg = ofcSlsDeltFlg;
		this.arAgnStlCd = arAgnStlCd;
		this.ofcLoclNm = ofcLoclNm;
		this.intlPhnNo = intlPhnNo;
		this.slsOfcDivCd = slsOfcDivCd;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ap_ctrl_ofc_cd", getApCtrlOfcCd());
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
		this.hashColumns.put("agn_knd_cd", getAgnKndCd());
		this.hashColumns.put("finc_rgn_cd", getFincRgnCd());
		this.hashColumns.put("ppd_pty_tp_cd", getPpdPtyTpCd());
		this.hashColumns.put("ofc_tp_cd", getOfcTpCd());
		this.hashColumns.put("modi_agn_cd", getModiAgnCd());
		this.hashColumns.put("ar_ctrl_ofc_cd", getArCtrlOfcCd());
		this.hashColumns.put("ob_cr_term_dys", getObCrTermDys());
		this.hashColumns.put("bil_curr_cd", getBilCurrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fx_curr_rt", getFxCurrRt());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ofc_cmmc_cd", getOfcCmmcCd());
		this.hashColumns.put("clz_dt", getClzDt());
		this.hashColumns.put("ofc_zip_cd", getOfcZipCd());
		this.hashColumns.put("ofc_addr", getOfcAddr());
		this.hashColumns.put("comm_if_ind_cd", getCommIfIndCd());
		this.hashColumns.put("ap_ofc_cd", getApOfcCd());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("ar_curr_cd", getArCurrCd());
		this.hashColumns.put("asa_cr_term_dys", getAsaCrTermDys());
		this.hashColumns.put("ar_hd_qtr_ofc_cd", getArHdQtrOfcCd());
		this.hashColumns.put("fax_ip", getFaxIp());
		this.hashColumns.put("finc_hide_flg", getFincHideFlg());
		this.hashColumns.put("subs_co_flg", getSubsCoFlg());
		this.hashColumns.put("ofc_rfa_sc_use_flg", getOfcRfaScUseFlg());
		this.hashColumns.put("altn_curr_div_cd", getAltnCurrDivCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("ofc_rmk", getOfcRmk());
		this.hashColumns.put("ofc_url", getOfcUrl());
		this.hashColumns.put("modi_cost_ctr_cd", getModiCostCtrCd());
		this.hashColumns.put("ap_ctr_cd", getApCtrCd());
		this.hashColumns.put("ofc_fax_no", getOfcFaxNo());
		this.hashColumns.put("ofc_rep_eml", getOfcRepEml());
		this.hashColumns.put("doc_rcvr_hide_flg", getDocRcvrHideFlg());
		this.hashColumns.put("ofc_tax_id", getOfcTaxId());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("ofc_locl_lang_addr", getOfcLoclLangAddr());
		this.hashColumns.put("ofc_eng_nm", getOfcEngNm());
		this.hashColumns.put("ar_ctr_cd", getArCtrCd());
		this.hashColumns.put("ib_cr_term_dys", getIbCrTermDys());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mnl_bkg_no_opt_cd", getMnlBkgNoOptCd());
		this.hashColumns.put("ofc_phn_no", getOfcPhnNo());
		this.hashColumns.put("intl_fax_no", getIntlFaxNo());
		this.hashColumns.put("inv_pfx_cd", getInvPfxCd());
		this.hashColumns.put("so_if_cd", getSoIfCd());
		this.hashColumns.put("ofc_knd_cd", getOfcKndCd());
		this.hashColumns.put("gl_ctr_cd", getGlCtrCd());
		this.hashColumns.put("opn_dt", getOpnDt());
		this.hashColumns.put("rep_cust_cd", getRepCustCd());
		this.hashColumns.put("finc_psdo_ofc_flg", getFincPsdoOfcFlg());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("sub_agn_flg", getSubAgnFlg());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("prnt_ofc_cd", getPrntOfcCd());
		this.hashColumns.put("ofc_sls_delt_flg", getOfcSlsDeltFlg());
		this.hashColumns.put("ar_agn_stl_cd", getArAgnStlCd());
		this.hashColumns.put("ofc_locl_nm", getOfcLoclNm());
		this.hashColumns.put("intl_phn_no", getIntlPhnNo());
		this.hashColumns.put("sls_ofc_div_cd", getSlsOfcDivCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ap_ctrl_ofc_cd", "apCtrlOfcCd");
		this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
		this.hashFields.put("agn_knd_cd", "agnKndCd");
		this.hashFields.put("finc_rgn_cd", "fincRgnCd");
		this.hashFields.put("ppd_pty_tp_cd", "ppdPtyTpCd");
		this.hashFields.put("ofc_tp_cd", "ofcTpCd");
		this.hashFields.put("modi_agn_cd", "modiAgnCd");
		this.hashFields.put("ar_ctrl_ofc_cd", "arCtrlOfcCd");
		this.hashFields.put("ob_cr_term_dys", "obCrTermDys");
		this.hashFields.put("bil_curr_cd", "bilCurrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fx_curr_rt", "fxCurrRt");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ofc_cmmc_cd", "ofcCmmcCd");
		this.hashFields.put("clz_dt", "clzDt");
		this.hashFields.put("ofc_zip_cd", "ofcZipCd");
		this.hashFields.put("ofc_addr", "ofcAddr");
		this.hashFields.put("comm_if_ind_cd", "commIfIndCd");
		this.hashFields.put("ap_ofc_cd", "apOfcCd");
		this.hashFields.put("status", "status");
		this.hashFields.put("ar_curr_cd", "arCurrCd");
		this.hashFields.put("asa_cr_term_dys", "asaCrTermDys");
		this.hashFields.put("ar_hd_qtr_ofc_cd", "arHdQtrOfcCd");
		this.hashFields.put("fax_ip", "faxIp");
		this.hashFields.put("finc_hide_flg", "fincHideFlg");
		this.hashFields.put("subs_co_flg", "subsCoFlg");
		this.hashFields.put("ofc_rfa_sc_use_flg", "ofcRfaScUseFlg");
		this.hashFields.put("altn_curr_div_cd", "altnCurrDivCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("ofc_rmk", "ofcRmk");
		this.hashFields.put("ofc_url", "ofcUrl");
		this.hashFields.put("modi_cost_ctr_cd", "modiCostCtrCd");
		this.hashFields.put("ap_ctr_cd", "apCtrCd");
		this.hashFields.put("ofc_fax_no", "ofcFaxNo");
		this.hashFields.put("ofc_rep_eml", "ofcRepEml");
		this.hashFields.put("doc_rcvr_hide_flg", "docRcvrHideFlg");
		this.hashFields.put("ofc_tax_id", "ofcTaxId");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("ofc_locl_lang_addr", "ofcLoclLangAddr");
		this.hashFields.put("ofc_eng_nm", "ofcEngNm");
		this.hashFields.put("ar_ctr_cd", "arCtrCd");
		this.hashFields.put("ib_cr_term_dys", "ibCrTermDys");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mnl_bkg_no_opt_cd", "mnlBkgNoOptCd");
		this.hashFields.put("ofc_phn_no", "ofcPhnNo");
		this.hashFields.put("intl_fax_no", "intlFaxNo");
		this.hashFields.put("inv_pfx_cd", "invPfxCd");
		this.hashFields.put("so_if_cd", "soIfCd");
		this.hashFields.put("ofc_knd_cd", "ofcKndCd");
		this.hashFields.put("gl_ctr_cd", "glCtrCd");
		this.hashFields.put("opn_dt", "opnDt");
		this.hashFields.put("rep_cust_cd", "repCustCd");
		this.hashFields.put("finc_psdo_ofc_flg", "fincPsdoOfcFlg");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("sub_agn_flg", "subAgnFlg");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("prnt_ofc_cd", "prntOfcCd");
		this.hashFields.put("ofc_sls_delt_flg", "ofcSlsDeltFlg");
		this.hashFields.put("ar_agn_stl_cd", "arAgnStlCd");
		this.hashFields.put("ofc_locl_nm", "ofcLoclNm");
		this.hashFields.put("intl_phn_no", "intlPhnNo");
		this.hashFields.put("sls_ofc_div_cd", "slsOfcDivCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
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
	 * @return ppdPtyTpCd
	 */
	public String getPpdPtyTpCd() {
		return this.ppdPtyTpCd;
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
	 * @return modiAgnCd
	 */
	public String getModiAgnCd() {
		return this.modiAgnCd;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return commIfIndCd
	 */
	public String getCommIfIndCd() {
		return this.commIfIndCd;
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
	 * @return status
	 */
	public String getStatus() {
		return this.status;
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
	 * @return asaCrTermDys
	 */
	public String getAsaCrTermDys() {
		return this.asaCrTermDys;
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
	 * @return ofcRfaScUseFlg
	 */
	public String getOfcRfaScUseFlg() {
		return this.ofcRfaScUseFlg;
	}
	
	/**
	 * Column Info
	 * @return altnCurrDivCd
	 */
	public String getAltnCurrDivCd() {
		return this.altnCurrDivCd;
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
	 * @return ofcUrl
	 */
	public String getOfcUrl() {
		return this.ofcUrl;
	}
	
	/**
	 * Column Info
	 * @return modiCostCtrCd
	 */
	public String getModiCostCtrCd() {
		return this.modiCostCtrCd;
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
	 * @return ofcRepEml
	 */
	public String getOfcRepEml() {
		return this.ofcRepEml;
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
	 * @return ofcTaxId
	 */
	public String getOfcTaxId() {
		return this.ofcTaxId;
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
	 * @return ofcLoclLangAddr
	 */
	public String getOfcLoclLangAddr() {
		return this.ofcLoclLangAddr;
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
	 * @return arCtrCd
	 */
	public String getArCtrCd() {
		return this.arCtrCd;
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
	 * @return mnlBkgNoOptCd
	 */
	public String getMnlBkgNoOptCd() {
		return this.mnlBkgNoOptCd;
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
	 * @return intlFaxNo
	 */
	public String getIntlFaxNo() {
		return this.intlFaxNo;
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
	 * @return soIfCd
	 */
	public String getSoIfCd() {
		return this.soIfCd;
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
	 * @return glCtrCd
	 */
	public String getGlCtrCd() {
		return this.glCtrCd;
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
	 * @return repCustCd
	 */
	public String getRepCustCd() {
		return this.repCustCd;
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
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
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
	 * @return ofcSlsDeltFlg
	 */
	public String getOfcSlsDeltFlg() {
		return this.ofcSlsDeltFlg;
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
	 * @return ofcLoclNm
	 */
	public String getOfcLoclNm() {
		return this.ofcLoclNm;
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
	 * @return slsOfcDivCd
	 */
	public String getSlsOfcDivCd() {
		return this.slsOfcDivCd;
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
	 * @param ppdPtyTpCd
	 */
	public void setPpdPtyTpCd(String ppdPtyTpCd) {
		this.ppdPtyTpCd = ppdPtyTpCd;
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
	 * @param modiAgnCd
	 */
	public void setModiAgnCd(String modiAgnCd) {
		this.modiAgnCd = modiAgnCd;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param commIfIndCd
	 */
	public void setCommIfIndCd(String commIfIndCd) {
		this.commIfIndCd = commIfIndCd;
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
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * @param asaCrTermDys
	 */
	public void setAsaCrTermDys(String asaCrTermDys) {
		this.asaCrTermDys = asaCrTermDys;
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
	 * @param ofcRfaScUseFlg
	 */
	public void setOfcRfaScUseFlg(String ofcRfaScUseFlg) {
		this.ofcRfaScUseFlg = ofcRfaScUseFlg;
	}
	
	/**
	 * Column Info
	 * @param altnCurrDivCd
	 */
	public void setAltnCurrDivCd(String altnCurrDivCd) {
		this.altnCurrDivCd = altnCurrDivCd;
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
	 * @param ofcUrl
	 */
	public void setOfcUrl(String ofcUrl) {
		this.ofcUrl = ofcUrl;
	}
	
	/**
	 * Column Info
	 * @param modiCostCtrCd
	 */
	public void setModiCostCtrCd(String modiCostCtrCd) {
		this.modiCostCtrCd = modiCostCtrCd;
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
	 * @param ofcRepEml
	 */
	public void setOfcRepEml(String ofcRepEml) {
		this.ofcRepEml = ofcRepEml;
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
	 * @param ofcTaxId
	 */
	public void setOfcTaxId(String ofcTaxId) {
		this.ofcTaxId = ofcTaxId;
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
	 * @param ofcLoclLangAddr
	 */
	public void setOfcLoclLangAddr(String ofcLoclLangAddr) {
		this.ofcLoclLangAddr = ofcLoclLangAddr;
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
	 * @param arCtrCd
	 */
	public void setArCtrCd(String arCtrCd) {
		this.arCtrCd = arCtrCd;
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
	 * @param mnlBkgNoOptCd
	 */
	public void setMnlBkgNoOptCd(String mnlBkgNoOptCd) {
		this.mnlBkgNoOptCd = mnlBkgNoOptCd;
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
	 * @param intlFaxNo
	 */
	public void setIntlFaxNo(String intlFaxNo) {
		this.intlFaxNo = intlFaxNo;
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
	 * @param soIfCd
	 */
	public void setSoIfCd(String soIfCd) {
		this.soIfCd = soIfCd;
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
	 * @param glCtrCd
	 */
	public void setGlCtrCd(String glCtrCd) {
		this.glCtrCd = glCtrCd;
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
	 * @param repCustCd
	 */
	public void setRepCustCd(String repCustCd) {
		this.repCustCd = repCustCd;
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
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
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
	 * @param ofcSlsDeltFlg
	 */
	public void setOfcSlsDeltFlg(String ofcSlsDeltFlg) {
		this.ofcSlsDeltFlg = ofcSlsDeltFlg;
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
	 * @param ofcLoclNm
	 */
	public void setOfcLoclNm(String ofcLoclNm) {
		this.ofcLoclNm = ofcLoclNm;
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
	 * @param slsOfcDivCd
	 */
	public void setSlsOfcDivCd(String slsOfcDivCd) {
		this.slsOfcDivCd = slsOfcDivCd;
	}
	
	public String getCreUsrId() {
		return creUsrId;
	}

	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	public String getCreDt() {
		return creDt;
	}

	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	public String getUpdUsrId() {
		return updUsrId;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	public String getUpdDt() {
		return updDt;
	}

	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
		setVndrCntCd(JSPUtil.getParameter(request, prefix + "vndr_cnt_cd", ""));
		setAgnKndCd(JSPUtil.getParameter(request, prefix + "agn_knd_cd", ""));
		setFincRgnCd(JSPUtil.getParameter(request, prefix + "finc_rgn_cd", ""));
		setPpdPtyTpCd(JSPUtil.getParameter(request, prefix + "ppd_pty_tp_cd", ""));
		setOfcTpCd(JSPUtil.getParameter(request, prefix + "ofc_tp_cd", ""));
		setModiAgnCd(JSPUtil.getParameter(request, prefix + "modi_agn_cd", ""));
		setArCtrlOfcCd(JSPUtil.getParameter(request, prefix + "ar_ctrl_ofc_cd", ""));
		setObCrTermDys(JSPUtil.getParameter(request, prefix + "ob_cr_term_dys", ""));
		setBilCurrCd(JSPUtil.getParameter(request, prefix + "bil_curr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFxCurrRt(JSPUtil.getParameter(request, prefix + "fx_curr_rt", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setOfcCmmcCd(JSPUtil.getParameter(request, prefix + "ofc_cmmc_cd", ""));
		setClzDt(JSPUtil.getParameter(request, prefix + "clz_dt", ""));
		setOfcZipCd(JSPUtil.getParameter(request, prefix + "ofc_zip_cd", ""));
		setOfcAddr(JSPUtil.getParameter(request, prefix + "ofc_addr", ""));
		setCommIfIndCd(JSPUtil.getParameter(request, prefix + "comm_if_ind_cd", ""));
		setApOfcCd(JSPUtil.getParameter(request, prefix + "ap_ofc_cd", ""));
		setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
		setArCurrCd(JSPUtil.getParameter(request, prefix + "ar_curr_cd", ""));
		setAsaCrTermDys(JSPUtil.getParameter(request, prefix + "asa_cr_term_dys", ""));
		setArHdQtrOfcCd(JSPUtil.getParameter(request, prefix + "ar_hd_qtr_ofc_cd", ""));
		setFaxIp(JSPUtil.getParameter(request, prefix + "fax_ip", ""));
		setFincHideFlg(JSPUtil.getParameter(request, prefix + "finc_hide_flg", ""));
		setSubsCoFlg(JSPUtil.getParameter(request, prefix + "subs_co_flg", ""));
		setOfcRfaScUseFlg(JSPUtil.getParameter(request, prefix + "ofc_rfa_sc_use_flg", ""));
		setAltnCurrDivCd(JSPUtil.getParameter(request, prefix + "altn_curr_div_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setOfcRmk(JSPUtil.getParameter(request, prefix + "ofc_rmk", ""));
		setOfcUrl(JSPUtil.getParameter(request, prefix + "ofc_url", ""));
		setModiCostCtrCd(JSPUtil.getParameter(request, prefix + "modi_cost_ctr_cd", ""));
		setApCtrCd(JSPUtil.getParameter(request, prefix + "ap_ctr_cd", ""));
		setOfcFaxNo(JSPUtil.getParameter(request, prefix + "ofc_fax_no", ""));
		setOfcRepEml(JSPUtil.getParameter(request, prefix + "ofc_rep_eml", ""));
		setDocRcvrHideFlg(JSPUtil.getParameter(request, prefix + "doc_rcvr_hide_flg", ""));
		setOfcTaxId(JSPUtil.getParameter(request, prefix + "ofc_tax_id", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setOfcLoclLangAddr(JSPUtil.getParameter(request, prefix + "ofc_locl_lang_addr", ""));
		setOfcEngNm(JSPUtil.getParameter(request, prefix + "ofc_eng_nm", ""));
		setArCtrCd(JSPUtil.getParameter(request, prefix + "ar_ctr_cd", ""));
		setIbCrTermDys(JSPUtil.getParameter(request, prefix + "ib_cr_term_dys", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMnlBkgNoOptCd(JSPUtil.getParameter(request, prefix + "mnl_bkg_no_opt_cd", ""));
		setOfcPhnNo(JSPUtil.getParameter(request, prefix + "ofc_phn_no", ""));
		setIntlFaxNo(JSPUtil.getParameter(request, prefix + "intl_fax_no", ""));
		setInvPfxCd(JSPUtil.getParameter(request, prefix + "inv_pfx_cd", ""));
		setSoIfCd(JSPUtil.getParameter(request, prefix + "so_if_cd", ""));
		setOfcKndCd(JSPUtil.getParameter(request, prefix + "ofc_knd_cd", ""));
		setGlCtrCd(JSPUtil.getParameter(request, prefix + "gl_ctr_cd", ""));
		setOpnDt(JSPUtil.getParameter(request, prefix + "opn_dt", ""));
		setRepCustCd(JSPUtil.getParameter(request, prefix + "rep_cust_cd", ""));
		setFincPsdoOfcFlg(JSPUtil.getParameter(request, prefix + "finc_psdo_ofc_flg", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setSubAgnFlg(JSPUtil.getParameter(request, prefix + "sub_agn_flg", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setPrntOfcCd(JSPUtil.getParameter(request, prefix + "prnt_ofc_cd", ""));
		setOfcSlsDeltFlg(JSPUtil.getParameter(request, prefix + "ofc_sls_delt_flg", ""));
		setArAgnStlCd(JSPUtil.getParameter(request, prefix + "ar_agn_stl_cd", ""));
		setOfcLoclNm(JSPUtil.getParameter(request, prefix + "ofc_locl_nm", ""));
		setIntlPhnNo(JSPUtil.getParameter(request, prefix + "intl_phn_no", ""));
		setSlsOfcDivCd(JSPUtil.getParameter(request, prefix + "sls_ofc_div_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OfficeReportVO[]
	 */
	public OfficeReportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OfficeReportVO[]
	 */
	public OfficeReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OfficeReportVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] apCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ap_ctrl_ofc_cd", length));
			String[] vndrCntCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_cd", length));
			String[] agnKndCd = (JSPUtil.getParameter(request, prefix	+ "agn_knd_cd", length));
			String[] fincRgnCd = (JSPUtil.getParameter(request, prefix	+ "finc_rgn_cd", length));
			String[] ppdPtyTpCd = (JSPUtil.getParameter(request, prefix	+ "ppd_pty_tp_cd", length));
			String[] ofcTpCd = (JSPUtil.getParameter(request, prefix	+ "ofc_tp_cd", length));
			String[] modiAgnCd = (JSPUtil.getParameter(request, prefix	+ "modi_agn_cd", length));
			String[] arCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ctrl_ofc_cd", length));
			String[] obCrTermDys = (JSPUtil.getParameter(request, prefix	+ "ob_cr_term_dys", length));
			String[] bilCurrCd = (JSPUtil.getParameter(request, prefix	+ "bil_curr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fxCurrRt = (JSPUtil.getParameter(request, prefix	+ "fx_curr_rt", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ofcCmmcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cmmc_cd", length));
			String[] clzDt = (JSPUtil.getParameter(request, prefix	+ "clz_dt", length));
			String[] ofcZipCd = (JSPUtil.getParameter(request, prefix	+ "ofc_zip_cd", length));
			String[] ofcAddr = (JSPUtil.getParameter(request, prefix	+ "ofc_addr", length));
			String[] commIfIndCd = (JSPUtil.getParameter(request, prefix	+ "comm_if_ind_cd", length));
			String[] apOfcCd = (JSPUtil.getParameter(request, prefix	+ "ap_ofc_cd", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] arCurrCd = (JSPUtil.getParameter(request, prefix	+ "ar_curr_cd", length));
			String[] asaCrTermDys = (JSPUtil.getParameter(request, prefix	+ "asa_cr_term_dys", length));
			String[] arHdQtrOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_hd_qtr_ofc_cd", length));
			String[] faxIp = (JSPUtil.getParameter(request, prefix	+ "fax_ip", length));
			String[] fincHideFlg = (JSPUtil.getParameter(request, prefix	+ "finc_hide_flg", length));
			String[] subsCoFlg = (JSPUtil.getParameter(request, prefix	+ "subs_co_flg", length));
			String[] ofcRfaScUseFlg = (JSPUtil.getParameter(request, prefix	+ "ofc_rfa_sc_use_flg", length));
			String[] altnCurrDivCd = (JSPUtil.getParameter(request, prefix	+ "altn_curr_div_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] ofcRmk = (JSPUtil.getParameter(request, prefix	+ "ofc_rmk", length));
			String[] ofcUrl = (JSPUtil.getParameter(request, prefix	+ "ofc_url", length));
			String[] modiCostCtrCd = (JSPUtil.getParameter(request, prefix	+ "modi_cost_ctr_cd", length));
			String[] apCtrCd = (JSPUtil.getParameter(request, prefix	+ "ap_ctr_cd", length));
			String[] ofcFaxNo = (JSPUtil.getParameter(request, prefix	+ "ofc_fax_no", length));
			String[] ofcRepEml = (JSPUtil.getParameter(request, prefix	+ "ofc_rep_eml", length));
			String[] docRcvrHideFlg = (JSPUtil.getParameter(request, prefix	+ "doc_rcvr_hide_flg", length));
			String[] ofcTaxId = (JSPUtil.getParameter(request, prefix	+ "ofc_tax_id", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] ofcLoclLangAddr = (JSPUtil.getParameter(request, prefix	+ "ofc_locl_lang_addr", length));
			String[] ofcEngNm = (JSPUtil.getParameter(request, prefix	+ "ofc_eng_nm", length));
			String[] arCtrCd = (JSPUtil.getParameter(request, prefix	+ "ar_ctr_cd", length));
			String[] ibCrTermDys = (JSPUtil.getParameter(request, prefix	+ "ib_cr_term_dys", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mnlBkgNoOptCd = (JSPUtil.getParameter(request, prefix	+ "mnl_bkg_no_opt_cd", length));
			String[] ofcPhnNo = (JSPUtil.getParameter(request, prefix	+ "ofc_phn_no", length));
			String[] intlFaxNo = (JSPUtil.getParameter(request, prefix	+ "intl_fax_no", length));
			String[] invPfxCd = (JSPUtil.getParameter(request, prefix	+ "inv_pfx_cd", length));
			String[] soIfCd = (JSPUtil.getParameter(request, prefix	+ "so_if_cd", length));
			String[] ofcKndCd = (JSPUtil.getParameter(request, prefix	+ "ofc_knd_cd", length));
			String[] glCtrCd = (JSPUtil.getParameter(request, prefix	+ "gl_ctr_cd", length));
			String[] opnDt = (JSPUtil.getParameter(request, prefix	+ "opn_dt", length));
			String[] repCustCd = (JSPUtil.getParameter(request, prefix	+ "rep_cust_cd", length));
			String[] fincPsdoOfcFlg = (JSPUtil.getParameter(request, prefix	+ "finc_psdo_ofc_flg", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] subAgnFlg = (JSPUtil.getParameter(request, prefix	+ "sub_agn_flg", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] prntOfcCd = (JSPUtil.getParameter(request, prefix	+ "prnt_ofc_cd", length));
			String[] ofcSlsDeltFlg = (JSPUtil.getParameter(request, prefix	+ "ofc_sls_delt_flg", length));
			String[] arAgnStlCd = (JSPUtil.getParameter(request, prefix	+ "ar_agn_stl_cd", length));
			String[] ofcLoclNm = (JSPUtil.getParameter(request, prefix	+ "ofc_locl_nm", length));
			String[] intlPhnNo = (JSPUtil.getParameter(request, prefix	+ "intl_phn_no", length));
			String[] slsOfcDivCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_div_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new OfficeReportVO();
				if (apCtrlOfcCd[i] != null)
					model.setApCtrlOfcCd(apCtrlOfcCd[i]);
				if (vndrCntCd[i] != null)
					model.setVndrCntCd(vndrCntCd[i]);
				if (agnKndCd[i] != null)
					model.setAgnKndCd(agnKndCd[i]);
				if (fincRgnCd[i] != null)
					model.setFincRgnCd(fincRgnCd[i]);
				if (ppdPtyTpCd[i] != null)
					model.setPpdPtyTpCd(ppdPtyTpCd[i]);
				if (ofcTpCd[i] != null)
					model.setOfcTpCd(ofcTpCd[i]);
				if (modiAgnCd[i] != null)
					model.setModiAgnCd(modiAgnCd[i]);
				if (arCtrlOfcCd[i] != null)
					model.setArCtrlOfcCd(arCtrlOfcCd[i]);
				if (obCrTermDys[i] != null)
					model.setObCrTermDys(obCrTermDys[i]);
				if (bilCurrCd[i] != null)
					model.setBilCurrCd(bilCurrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fxCurrRt[i] != null)
					model.setFxCurrRt(fxCurrRt[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ofcCmmcCd[i] != null)
					model.setOfcCmmcCd(ofcCmmcCd[i]);
				if (clzDt[i] != null)
					model.setClzDt(clzDt[i]);
				if (ofcZipCd[i] != null)
					model.setOfcZipCd(ofcZipCd[i]);
				if (ofcAddr[i] != null)
					model.setOfcAddr(ofcAddr[i]);
				if (commIfIndCd[i] != null)
					model.setCommIfIndCd(commIfIndCd[i]);
				if (apOfcCd[i] != null)
					model.setApOfcCd(apOfcCd[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (arCurrCd[i] != null)
					model.setArCurrCd(arCurrCd[i]);
				if (asaCrTermDys[i] != null)
					model.setAsaCrTermDys(asaCrTermDys[i]);
				if (arHdQtrOfcCd[i] != null)
					model.setArHdQtrOfcCd(arHdQtrOfcCd[i]);
				if (faxIp[i] != null)
					model.setFaxIp(faxIp[i]);
				if (fincHideFlg[i] != null)
					model.setFincHideFlg(fincHideFlg[i]);
				if (subsCoFlg[i] != null)
					model.setSubsCoFlg(subsCoFlg[i]);
				if (ofcRfaScUseFlg[i] != null)
					model.setOfcRfaScUseFlg(ofcRfaScUseFlg[i]);
				if (altnCurrDivCd[i] != null)
					model.setAltnCurrDivCd(altnCurrDivCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (ofcRmk[i] != null)
					model.setOfcRmk(ofcRmk[i]);
				if (ofcUrl[i] != null)
					model.setOfcUrl(ofcUrl[i]);
				if (modiCostCtrCd[i] != null)
					model.setModiCostCtrCd(modiCostCtrCd[i]);
				if (apCtrCd[i] != null)
					model.setApCtrCd(apCtrCd[i]);
				if (ofcFaxNo[i] != null)
					model.setOfcFaxNo(ofcFaxNo[i]);
				if (ofcRepEml[i] != null)
					model.setOfcRepEml(ofcRepEml[i]);
				if (docRcvrHideFlg[i] != null)
					model.setDocRcvrHideFlg(docRcvrHideFlg[i]);
				if (ofcTaxId[i] != null)
					model.setOfcTaxId(ofcTaxId[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (ofcLoclLangAddr[i] != null)
					model.setOfcLoclLangAddr(ofcLoclLangAddr[i]);
				if (ofcEngNm[i] != null)
					model.setOfcEngNm(ofcEngNm[i]);
				if (arCtrCd[i] != null)
					model.setArCtrCd(arCtrCd[i]);
				if (ibCrTermDys[i] != null)
					model.setIbCrTermDys(ibCrTermDys[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mnlBkgNoOptCd[i] != null)
					model.setMnlBkgNoOptCd(mnlBkgNoOptCd[i]);
				if (ofcPhnNo[i] != null)
					model.setOfcPhnNo(ofcPhnNo[i]);
				if (intlFaxNo[i] != null)
					model.setIntlFaxNo(intlFaxNo[i]);
				if (invPfxCd[i] != null)
					model.setInvPfxCd(invPfxCd[i]);
				if (soIfCd[i] != null)
					model.setSoIfCd(soIfCd[i]);
				if (ofcKndCd[i] != null)
					model.setOfcKndCd(ofcKndCd[i]);
				if (glCtrCd[i] != null)
					model.setGlCtrCd(glCtrCd[i]);
				if (opnDt[i] != null)
					model.setOpnDt(opnDt[i]);
				if (repCustCd[i] != null)
					model.setRepCustCd(repCustCd[i]);
				if (fincPsdoOfcFlg[i] != null)
					model.setFincPsdoOfcFlg(fincPsdoOfcFlg[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (subAgnFlg[i] != null)
					model.setSubAgnFlg(subAgnFlg[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (prntOfcCd[i] != null)
					model.setPrntOfcCd(prntOfcCd[i]);
				if (ofcSlsDeltFlg[i] != null)
					model.setOfcSlsDeltFlg(ofcSlsDeltFlg[i]);
				if (arAgnStlCd[i] != null)
					model.setArAgnStlCd(arAgnStlCd[i]);
				if (ofcLoclNm[i] != null)
					model.setOfcLoclNm(ofcLoclNm[i]);
				if (intlPhnNo[i] != null)
					model.setIntlPhnNo(intlPhnNo[i]);
				if (slsOfcDivCd[i] != null)
					model.setSlsOfcDivCd(slsOfcDivCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOfficeReportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OfficeReportVO[]
	 */
	public OfficeReportVO[] getOfficeReportVOs(){
		OfficeReportVO[] vos = (OfficeReportVO[])models.toArray(new OfficeReportVO[models.size()]);
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
		this.vndrCntCd = this.vndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnKndCd = this.agnKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincRgnCd = this.fincRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdPtyTpCd = this.ppdPtyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTpCd = this.ofcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiAgnCd = this.modiAgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arCtrlOfcCd = this.arCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCrTermDys = this.obCrTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilCurrCd = this.bilCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fxCurrRt = this.fxCurrRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCmmcCd = this.ofcCmmcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clzDt = this.clzDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcZipCd = this.ofcZipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcAddr = this.ofcAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commIfIndCd = this.commIfIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apOfcCd = this.apOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arCurrCd = this.arCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaCrTermDys = this.asaCrTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arHdQtrOfcCd = this.arHdQtrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxIp = this.faxIp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincHideFlg = this.fincHideFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subsCoFlg = this.subsCoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcRfaScUseFlg = this.ofcRfaScUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.altnCurrDivCd = this.altnCurrDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcRmk = this.ofcRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcUrl = this.ofcUrl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiCostCtrCd = this.modiCostCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apCtrCd = this.apCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcFaxNo = this.ofcFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcRepEml = this.ofcRepEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docRcvrHideFlg = this.docRcvrHideFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTaxId = this.ofcTaxId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcLoclLangAddr = this.ofcLoclLangAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcEngNm = this.ofcEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arCtrCd = this.arCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCrTermDys = this.ibCrTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlBkgNoOptCd = this.mnlBkgNoOptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcPhnNo = this.ofcPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intlFaxNo = this.intlFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invPfxCd = this.invPfxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soIfCd = this.soIfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcKndCd = this.ofcKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glCtrCd = this.glCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opnDt = this.opnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCustCd = this.repCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincPsdoOfcFlg = this.fincPsdoOfcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subAgnFlg = this.subAgnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prntOfcCd = this.prntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcSlsDeltFlg = this.ofcSlsDeltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arAgnStlCd = this.arAgnStlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcLoclNm = this.ofcLoclNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intlPhnNo = this.intlPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcDivCd = this.slsOfcDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
