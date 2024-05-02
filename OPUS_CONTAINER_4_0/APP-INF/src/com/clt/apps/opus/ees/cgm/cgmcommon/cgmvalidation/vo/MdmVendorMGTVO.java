/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MdmVendorVO.java
*@FileTitle : MdmVendorVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.22
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.04.22 우경민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 우경민
 * @since J2EE 1.5
 */

public class MdmVendorMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MdmVendorMGTVO> models = new ArrayList<MdmVendorMGTVO>();
	
	/* Column Inpo */
	private String rgstNo = null;
	/* Column Inpo */
	private String genPayTermCd = null;
	/* Column Inpo */
	private String svcPrdRmk = null;
	/* Column Inpo */
	private String prntVndrSeq = null;
	/* Column Inpo */
	private String chkDeCntCd = null;
	/* Column Inpo */
	private String cnlAgnFlg = null;
	/* Column Inpo */
	private String ofcCd = null;
	/* Column Inpo */
	private String eaiEvntDt = null;
	/* Column Inpo */
	private String updUsrId = null;
	/* Column Inpo */
	private String rfndPsdoCustCd = null;
	/* Column Inpo */
	private String chkDeAddr1 = null;
	/* Column Inpo */
	private String usaEdiCd = null;
	/* Column Inpo */
	private String subsCoCd = null;
	/* Column Inpo */
	private String updDt = null;
	/* Column Inpo */
	private String otrFlg = null;
	/* Column Inpo */
	private String deltFlg = null;
	/* Column Inpo */
	private String locCd = null;
	/* Column Inpo */
	private String mtyRroEdiUseFlg = null;
	/* Column Inpo */
	private String interCoFlg = null;
	/* Column Inpo */
	private String woAtchFileFlg = null;
	/* Status */
	private String ibflag = null;
	/* Column Inpo */
	private String lgsFlg = null;
	/* Column Inpo */
	private String vndrAbbrNm = null;
	/* Column Inpo */
	private String cnlAgnBankDesc = null;
	/* Column Inpo */
	private String mnrDfltTrsmCd = null;
	/* Column Inpo */
	private String prntCntCd = null;
	/* Column Inpo */
	private String cntcPsonNm = null;
	/* Column Inpo */
	private String payTermTpCd = null;
	/* Column Inpo */
	private String vndrLoclLangNm = null;
	/* Column Inpo */
	private String procuFlg = null;
	/* Column Inpo */
	private String zipCd = null;
	/* Column Inpo */
	private String invCurrCd = null;
	/* Column Inpo */
	private String taxId = null;
	/* Column Inpo */
	private String fincFlg = null;
	/* Column Inpo */
	private String chkDeZipCd = null;
	/* Column Inpo */
	private String chkDeAddr3 = null;
	/* Column Inpo */
	private String payCurrCd = null;
	/* Column Inpo */
	private String woEdiUseFlg = null;
	/* Column Inpo */
	private String chkDeCtyNm = null;
	/* Column Inpo */
	private String dcgoHndlFlg = null;
	/* Column Inpo */
	private String invEdiUseFlg = null;
	/* Column Inpo */
	private String vndrOfcCd = null;
	/* Column Inpo */
	private String bztpNm = null;
	/* Column Inpo */
	private String svcScpCdNm = null;
	/* Column Inpo */
	private String engAddr = null;
	/* Column Inpo */
	private String chkDeSteCd = null;
	/* Column Inpo */
	private String vndrCntCd = null;
	/* Column Inpo */
	private String chkDeAddr2 = null;
	/* Column Inpo */
	private String teamFlg = null;
	/* Column Inpo */
	private String modiVndrSeq = null;
	/* Column Inpo */
	private String loclLangAddr = null;
	/* Column Inpo */
	private String ceoNm = null;
	/* Column Inpo */
	private String luDeltFlg = null;
	/* Column Inpo */
	private String vndrSeq = null;
	/* Column Inpo */
	private String payMzdCd = null;
	/* Column Inpo */
	private String vndrLglEngNm = null;
	/* Column Inpo */
	private String svcPrdTpNm = null;
	/* Column Inpo */
	private String fletMgmtOwnrVndrSeq = null;
	/* Column Inpo */
	private String blkVndrSvcCd = null;
	/* Column Inpo */
	private String creDt = null;
	/* Column Inpo */
	private String bzctNm = null;
	/* Column Inpo */
	private String creUsrId = null;
	/* Column Inpo */
	private String blkFlg = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MdmVendorMGTVO() {}

	public MdmVendorMGTVO(String ibflag, String pagerows, String vndrSeq, String vndrCntCd, String vndrLglEngNm, String vndrLoclLangNm, String vndrAbbrNm, String lgsFlg, String procuFlg, String teamFlg, String fincFlg, String blkFlg, String interCoFlg, String locCd, String ofcCd, String ceoNm, String rgstNo, String taxId, String prntCntCd, String prntVndrSeq, String dcgoHndlFlg, String svcScpCdNm, String svcPrdTpNm, String svcPrdRmk, String bzctNm, String bztpNm, String genPayTermCd, String engAddr, String loclLangAddr, String zipCd, String cntcPsonNm, String invCurrCd, String payCurrCd, String payMzdCd, String usaEdiCd, String woAtchFileFlg, String woEdiUseFlg, String invEdiUseFlg, String mtyRroEdiUseFlg, String blkVndrSvcCd, String subsCoCd, String otrFlg, String vndrOfcCd, String modiVndrSeq, String creUsrId, String creDt, String updUsrId, String updDt, String deltFlg, String eaiEvntDt, String rfndPsdoCustCd, String payTermTpCd, String chkDeAddr1, String chkDeAddr2, String chkDeAddr3, String chkDeCtyNm, String chkDeSteCd, String chkDeZipCd, String chkDeCntCd, String luDeltFlg, String fletMgmtOwnrVndrSeq, String cnlAgnFlg, String cnlAgnBankDesc, String mnrDfltTrsmCd) {
		this.rgstNo = rgstNo;
		this.genPayTermCd = genPayTermCd;
		this.svcPrdRmk = svcPrdRmk;
		this.prntVndrSeq = prntVndrSeq;
		this.chkDeCntCd = chkDeCntCd;
		this.cnlAgnFlg = cnlAgnFlg;
		this.ofcCd = ofcCd;
		this.eaiEvntDt = eaiEvntDt;
		this.updUsrId = updUsrId;
		this.rfndPsdoCustCd = rfndPsdoCustCd;
		this.chkDeAddr1 = chkDeAddr1;
		this.usaEdiCd = usaEdiCd;
		this.subsCoCd = subsCoCd;
		this.updDt = updDt;
		this.otrFlg = otrFlg;
		this.deltFlg = deltFlg;
		this.locCd = locCd;
		this.mtyRroEdiUseFlg = mtyRroEdiUseFlg;
		this.interCoFlg = interCoFlg;
		this.woAtchFileFlg = woAtchFileFlg;
		this.ibflag = ibflag;
		this.lgsFlg = lgsFlg;
		this.vndrAbbrNm = vndrAbbrNm;
		this.cnlAgnBankDesc = cnlAgnBankDesc;
		this.mnrDfltTrsmCd = mnrDfltTrsmCd;
		this.prntCntCd = prntCntCd;
		this.cntcPsonNm = cntcPsonNm;
		this.payTermTpCd = payTermTpCd;
		this.vndrLoclLangNm = vndrLoclLangNm;
		this.procuFlg = procuFlg;
		this.zipCd = zipCd;
		this.invCurrCd = invCurrCd;
		this.taxId = taxId;
		this.fincFlg = fincFlg;
		this.chkDeZipCd = chkDeZipCd;
		this.chkDeAddr3 = chkDeAddr3;
		this.payCurrCd = payCurrCd;
		this.woEdiUseFlg = woEdiUseFlg;
		this.chkDeCtyNm = chkDeCtyNm;
		this.dcgoHndlFlg = dcgoHndlFlg;
		this.invEdiUseFlg = invEdiUseFlg;
		this.vndrOfcCd = vndrOfcCd;
		this.bztpNm = bztpNm;
		this.svcScpCdNm = svcScpCdNm;
		this.engAddr = engAddr;
		this.chkDeSteCd = chkDeSteCd;
		this.vndrCntCd = vndrCntCd;
		this.chkDeAddr2 = chkDeAddr2;
		this.teamFlg = teamFlg;
		this.modiVndrSeq = modiVndrSeq;
		this.loclLangAddr = loclLangAddr;
		this.ceoNm = ceoNm;
		this.luDeltFlg = luDeltFlg;
		this.vndrSeq = vndrSeq;
		this.payMzdCd = payMzdCd;
		this.vndrLglEngNm = vndrLglEngNm;
		this.svcPrdTpNm = svcPrdTpNm;
		this.fletMgmtOwnrVndrSeq = fletMgmtOwnrVndrSeq;
		this.blkVndrSvcCd = blkVndrSvcCd;
		this.creDt = creDt;
		this.bzctNm = bzctNm;
		this.creUsrId = creUsrId;
		this.blkFlg = blkFlg;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rgst_no", getRgstNo());
		this.hashColumns.put("gen_pay_term_cd", getGenPayTermCd());
		this.hashColumns.put("svc_prd_rmk", getSvcPrdRmk());
		this.hashColumns.put("prnt_vndr_seq", getPrntVndrSeq());
		this.hashColumns.put("chk_de_cnt_cd", getChkDeCntCd());
		this.hashColumns.put("cnl_agn_flg", getCnlAgnFlg());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("eai_evnt_dt", getEaiEvntDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rfnd_psdo_cust_cd", getRfndPsdoCustCd());
		this.hashColumns.put("chk_de_addr1", getChkDeAddr1());
		this.hashColumns.put("usa_edi_cd", getUsaEdiCd());
		this.hashColumns.put("subs_co_cd", getSubsCoCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("otr_flg", getOtrFlg());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("mty_rro_edi_use_flg", getMtyRroEdiUseFlg());
		this.hashColumns.put("inter_co_flg", getInterCoFlg());
		this.hashColumns.put("wo_atch_file_flg", getWoAtchFileFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lgs_flg", getLgsFlg());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("cnl_agn_bank_desc", getCnlAgnBankDesc());
		this.hashColumns.put("mnr_dflt_trsm_cd", getMnrDfltTrsmCd());
		this.hashColumns.put("prnt_cnt_cd", getPrntCntCd());
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
		this.hashColumns.put("pay_term_tp_cd", getPayTermTpCd());
		this.hashColumns.put("vndr_locl_lang_nm", getVndrLoclLangNm());
		this.hashColumns.put("procu_flg", getProcuFlg());
		this.hashColumns.put("zip_cd", getZipCd());
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());
		this.hashColumns.put("tax_id", getTaxId());
		this.hashColumns.put("finc_flg", getFincFlg());
		this.hashColumns.put("chk_de_zip_cd", getChkDeZipCd());
		this.hashColumns.put("chk_de_addr3", getChkDeAddr3());
		this.hashColumns.put("pay_curr_cd", getPayCurrCd());
		this.hashColumns.put("wo_edi_use_flg", getWoEdiUseFlg());
		this.hashColumns.put("chk_de_cty_nm", getChkDeCtyNm());
		this.hashColumns.put("dcgo_hndl_flg", getDcgoHndlFlg());
		this.hashColumns.put("inv_edi_use_flg", getInvEdiUseFlg());
		this.hashColumns.put("vndr_ofc_cd", getVndrOfcCd());
		this.hashColumns.put("bztp_nm", getBztpNm());
		this.hashColumns.put("svc_scp_cd_nm", getSvcScpCdNm());
		this.hashColumns.put("eng_addr", getEngAddr());
		this.hashColumns.put("chk_de_ste_cd", getChkDeSteCd());
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
		this.hashColumns.put("chk_de_addr2", getChkDeAddr2());
		this.hashColumns.put("team_flg", getTeamFlg());
		this.hashColumns.put("modi_vndr_seq", getModiVndrSeq());
		this.hashColumns.put("locl_lang_addr", getLoclLangAddr());
		this.hashColumns.put("ceo_nm", getCeoNm());
		this.hashColumns.put("lu_delt_flg", getLuDeltFlg());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("pay_mzd_cd", getPayMzdCd());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("svc_prd_tp_nm", getSvcPrdTpNm());
		this.hashColumns.put("flet_mgmt_ownr_vndr_seq", getFletMgmtOwnrVndrSeq());
		this.hashColumns.put("blk_vndr_svc_cd", getBlkVndrSvcCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("bzct_nm", getBzctNm());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("blk_flg", getBlkFlg());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rgst_no", "rgstNo");
		this.hashFields.put("gen_pay_term_cd", "genPayTermCd");
		this.hashFields.put("svc_prd_rmk", "svcPrdRmk");
		this.hashFields.put("prnt_vndr_seq", "prntVndrSeq");
		this.hashFields.put("chk_de_cnt_cd", "chkDeCntCd");
		this.hashFields.put("cnl_agn_flg", "cnlAgnFlg");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("eai_evnt_dt", "eaiEvntDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rfnd_psdo_cust_cd", "rfndPsdoCustCd");
		this.hashFields.put("chk_de_addr1", "chkDeAddr1");
		this.hashFields.put("usa_edi_cd", "usaEdiCd");
		this.hashFields.put("subs_co_cd", "subsCoCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("otr_flg", "otrFlg");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("mty_rro_edi_use_flg", "mtyRroEdiUseFlg");
		this.hashFields.put("inter_co_flg", "interCoFlg");
		this.hashFields.put("wo_atch_file_flg", "woAtchFileFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lgs_flg", "lgsFlg");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("cnl_agn_bank_desc", "cnlAgnBankDesc");
		this.hashFields.put("mnr_dflt_trsm_cd", "mnrDfltTrsmCd");
		this.hashFields.put("prnt_cnt_cd", "prntCntCd");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
		this.hashFields.put("pay_term_tp_cd", "payTermTpCd");
		this.hashFields.put("vndr_locl_lang_nm", "vndrLoclLangNm");
		this.hashFields.put("procu_flg", "procuFlg");
		this.hashFields.put("zip_cd", "zipCd");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("tax_id", "taxId");
		this.hashFields.put("finc_flg", "fincFlg");
		this.hashFields.put("chk_de_zip_cd", "chkDeZipCd");
		this.hashFields.put("chk_de_addr3", "chkDeAddr3");
		this.hashFields.put("pay_curr_cd", "payCurrCd");
		this.hashFields.put("wo_edi_use_flg", "woEdiUseFlg");
		this.hashFields.put("chk_de_cty_nm", "chkDeCtyNm");
		this.hashFields.put("dcgo_hndl_flg", "dcgoHndlFlg");
		this.hashFields.put("inv_edi_use_flg", "invEdiUseFlg");
		this.hashFields.put("vndr_ofc_cd", "vndrOfcCd");
		this.hashFields.put("bztp_nm", "bztpNm");
		this.hashFields.put("svc_scp_cd_nm", "svcScpCdNm");
		this.hashFields.put("eng_addr", "engAddr");
		this.hashFields.put("chk_de_ste_cd", "chkDeSteCd");
		this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
		this.hashFields.put("chk_de_addr2", "chkDeAddr2");
		this.hashFields.put("team_flg", "teamFlg");
		this.hashFields.put("modi_vndr_seq", "modiVndrSeq");
		this.hashFields.put("locl_lang_addr", "loclLangAddr");
		this.hashFields.put("ceo_nm", "ceoNm");
		this.hashFields.put("lu_delt_flg", "luDeltFlg");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("pay_mzd_cd", "payMzdCd");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("svc_prd_tp_nm", "svcPrdTpNm");
		this.hashFields.put("flet_mgmt_ownr_vndr_seq", "fletMgmtOwnrVndrSeq");
		this.hashFields.put("blk_vndr_svc_cd", "blkVndrSvcCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("bzct_nm", "bzctNm");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("blk_flg", "blkFlg");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getRgstNo() {
		return this.rgstNo;
	}
	public String getGenPayTermCd() {
		return this.genPayTermCd;
	}
	public String getSvcPrdRmk() {
		return this.svcPrdRmk;
	}
	public String getPrntVndrSeq() {
		return this.prntVndrSeq;
	}
	public String getChkDeCntCd() {
		return this.chkDeCntCd;
	}
	public String getCnlAgnFlg() {
		return this.cnlAgnFlg;
	}
	public String getOfcCd() {
		return this.ofcCd;
	}
	public String getEaiEvntDt() {
		return this.eaiEvntDt;
	}
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	public String getRfndPsdoCustCd() {
		return this.rfndPsdoCustCd;
	}
	public String getChkDeAddr1() {
		return this.chkDeAddr1;
	}
	public String getUsaEdiCd() {
		return this.usaEdiCd;
	}
	public String getSubsCoCd() {
		return this.subsCoCd;
	}
	public String getUpdDt() {
		return this.updDt;
	}
	public String getOtrFlg() {
		return this.otrFlg;
	}
	public String getDeltFlg() {
		return this.deltFlg;
	}
	public String getLocCd() {
		return this.locCd;
	}
	public String getMtyRroEdiUseFlg() {
		return this.mtyRroEdiUseFlg;
	}
	public String getInterCoFlg() {
		return this.interCoFlg;
	}
	public String getWoAtchFileFlg() {
		return this.woAtchFileFlg;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getLgsFlg() {
		return this.lgsFlg;
	}
	public String getVndrAbbrNm() {
		return this.vndrAbbrNm;
	}
	public String getCnlAgnBankDesc() {
		return this.cnlAgnBankDesc;
	}
	public String getMnrDfltTrsmCd() {
		return this.mnrDfltTrsmCd;
	}
	public String getPrntCntCd() {
		return this.prntCntCd;
	}
	public String getCntcPsonNm() {
		return this.cntcPsonNm;
	}
	public String getPayTermTpCd() {
		return this.payTermTpCd;
	}
	public String getVndrLoclLangNm() {
		return this.vndrLoclLangNm;
	}
	public String getProcuFlg() {
		return this.procuFlg;
	}
	public String getZipCd() {
		return this.zipCd;
	}
	public String getInvCurrCd() {
		return this.invCurrCd;
	}
	public String getTaxId() {
		return this.taxId;
	}
	public String getFincFlg() {
		return this.fincFlg;
	}
	public String getChkDeZipCd() {
		return this.chkDeZipCd;
	}
	public String getChkDeAddr3() {
		return this.chkDeAddr3;
	}
	public String getPayCurrCd() {
		return this.payCurrCd;
	}
	public String getWoEdiUseFlg() {
		return this.woEdiUseFlg;
	}
	public String getChkDeCtyNm() {
		return this.chkDeCtyNm;
	}
	public String getDcgoHndlFlg() {
		return this.dcgoHndlFlg;
	}
	public String getInvEdiUseFlg() {
		return this.invEdiUseFlg;
	}
	public String getVndrOfcCd() {
		return this.vndrOfcCd;
	}
	public String getBztpNm() {
		return this.bztpNm;
	}
	public String getSvcScpCdNm() {
		return this.svcScpCdNm;
	}
	public String getEngAddr() {
		return this.engAddr;
	}
	public String getChkDeSteCd() {
		return this.chkDeSteCd;
	}
	public String getVndrCntCd() {
		return this.vndrCntCd;
	}
	public String getChkDeAddr2() {
		return this.chkDeAddr2;
	}
	public String getTeamFlg() {
		return this.teamFlg;
	}
	public String getModiVndrSeq() {
		return this.modiVndrSeq;
	}
	public String getLoclLangAddr() {
		return this.loclLangAddr;
	}
	public String getCeoNm() {
		return this.ceoNm;
	}
	public String getLuDeltFlg() {
		return this.luDeltFlg;
	}
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	public String getPayMzdCd() {
		return this.payMzdCd;
	}
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	public String getSvcPrdTpNm() {
		return this.svcPrdTpNm;
	}
	public String getFletMgmtOwnrVndrSeq() {
		return this.fletMgmtOwnrVndrSeq;
	}
	public String getBlkVndrSvcCd() {
		return this.blkVndrSvcCd;
	}
	public String getCreDt() {
		return this.creDt;
	}
	public String getBzctNm() {
		return this.bzctNm;
	}
	public String getCreUsrId() {
		return this.creUsrId;
	}
	public String getBlkFlg() {
		return this.blkFlg;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setRgstNo(String rgstNo) {
		this.rgstNo = rgstNo;
		//this.rgstNo=true;
	}
	public void setGenPayTermCd(String genPayTermCd) {
		this.genPayTermCd = genPayTermCd;
		//this.genPayTermCd=true;
	}
	public void setSvcPrdRmk(String svcPrdRmk) {
		this.svcPrdRmk = svcPrdRmk;
		//this.svcPrdRmk=true;
	}
	public void setPrntVndrSeq(String prntVndrSeq) {
		this.prntVndrSeq = prntVndrSeq;
		//this.prntVndrSeq=true;
	}
	public void setChkDeCntCd(String chkDeCntCd) {
		this.chkDeCntCd = chkDeCntCd;
		//this.chkDeCntCd=true;
	}
	public void setCnlAgnFlg(String cnlAgnFlg) {
		this.cnlAgnFlg = cnlAgnFlg;
		//this.cnlAgnFlg=true;
	}
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
		//this.ofcCd=true;
	}
	public void setEaiEvntDt(String eaiEvntDt) {
		this.eaiEvntDt = eaiEvntDt;
		//this.eaiEvntDt=true;
	}
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
		//this.updUsrId=true;
	}
	public void setRfndPsdoCustCd(String rfndPsdoCustCd) {
		this.rfndPsdoCustCd = rfndPsdoCustCd;
		//this.rfndPsdoCustCd=true;
	}
	public void setChkDeAddr1(String chkDeAddr1) {
		this.chkDeAddr1 = chkDeAddr1;
		//this.chkDeAddr1=true;
	}
	public void setUsaEdiCd(String usaEdiCd) {
		this.usaEdiCd = usaEdiCd;
		//this.usaEdiCd=true;
	}
	public void setSubsCoCd(String subsCoCd) {
		this.subsCoCd = subsCoCd;
		//this.subsCoCd=true;
	}
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
		//this.updDt=true;
	}
	public void setOtrFlg(String otrFlg) {
		this.otrFlg = otrFlg;
		//this.otrFlg=true;
	}
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
		//this.deltFlg=true;
	}
	public void setLocCd(String locCd) {
		this.locCd = locCd;
		//this.locCd=true;
	}
	public void setMtyRroEdiUseFlg(String mtyRroEdiUseFlg) {
		this.mtyRroEdiUseFlg = mtyRroEdiUseFlg;
		//this.mtyRroEdiUseFlg=true;
	}
	public void setInterCoFlg(String interCoFlg) {
		this.interCoFlg = interCoFlg;
		//this.interCoFlg=true;
	}
	public void setWoAtchFileFlg(String woAtchFileFlg) {
		this.woAtchFileFlg = woAtchFileFlg;
		//this.woAtchFileFlg=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setLgsFlg(String lgsFlg) {
		this.lgsFlg = lgsFlg;
		//this.lgsFlg=true;
	}
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
		//this.vndrAbbrNm=true;
	}
	public void setCnlAgnBankDesc(String cnlAgnBankDesc) {
		this.cnlAgnBankDesc = cnlAgnBankDesc;
		//this.cnlAgnBankDesc=true;
	}
	public void setMnrDfltTrsmCd(String mnrDfltTrsmCd) {
		this.mnrDfltTrsmCd = mnrDfltTrsmCd;
		//this.mnrDfltTrsmCd=true;
	}
	public void setPrntCntCd(String prntCntCd) {
		this.prntCntCd = prntCntCd;
		//this.prntCntCd=true;
	}
	public void setCntcPsonNm(String cntcPsonNm) {
		this.cntcPsonNm = cntcPsonNm;
		//this.cntcPsonNm=true;
	}
	public void setPayTermTpCd(String payTermTpCd) {
		this.payTermTpCd = payTermTpCd;
		//this.payTermTpCd=true;
	}
	public void setVndrLoclLangNm(String vndrLoclLangNm) {
		this.vndrLoclLangNm = vndrLoclLangNm;
		//this.vndrLoclLangNm=true;
	}
	public void setProcuFlg(String procuFlg) {
		this.procuFlg = procuFlg;
		//this.procuFlg=true;
	}
	public void setZipCd(String zipCd) {
		this.zipCd = zipCd;
		//this.zipCd=true;
	}
	public void setInvCurrCd(String invCurrCd) {
		this.invCurrCd = invCurrCd;
		//this.invCurrCd=true;
	}
	public void setTaxId(String taxId) {
		this.taxId = taxId;
		//this.taxId=true;
	}
	public void setFincFlg(String fincFlg) {
		this.fincFlg = fincFlg;
		//this.fincFlg=true;
	}
	public void setChkDeZipCd(String chkDeZipCd) {
		this.chkDeZipCd = chkDeZipCd;
		//this.chkDeZipCd=true;
	}
	public void setChkDeAddr3(String chkDeAddr3) {
		this.chkDeAddr3 = chkDeAddr3;
		//this.chkDeAddr3=true;
	}
	public void setPayCurrCd(String payCurrCd) {
		this.payCurrCd = payCurrCd;
		//this.payCurrCd=true;
	}
	public void setWoEdiUseFlg(String woEdiUseFlg) {
		this.woEdiUseFlg = woEdiUseFlg;
		//this.woEdiUseFlg=true;
	}
	public void setChkDeCtyNm(String chkDeCtyNm) {
		this.chkDeCtyNm = chkDeCtyNm;
		//this.chkDeCtyNm=true;
	}
	public void setDcgoHndlFlg(String dcgoHndlFlg) {
		this.dcgoHndlFlg = dcgoHndlFlg;
		//this.dcgoHndlFlg=true;
	}
	public void setInvEdiUseFlg(String invEdiUseFlg) {
		this.invEdiUseFlg = invEdiUseFlg;
		//this.invEdiUseFlg=true;
	}
	public void setVndrOfcCd(String vndrOfcCd) {
		this.vndrOfcCd = vndrOfcCd;
		//this.vndrOfcCd=true;
	}
	public void setBztpNm(String bztpNm) {
		this.bztpNm = bztpNm;
		//this.bztpNm=true;
	}
	public void setSvcScpCdNm(String svcScpCdNm) {
		this.svcScpCdNm = svcScpCdNm;
		//this.svcScpCdNm=true;
	}
	public void setEngAddr(String engAddr) {
		this.engAddr = engAddr;
		//this.engAddr=true;
	}
	public void setChkDeSteCd(String chkDeSteCd) {
		this.chkDeSteCd = chkDeSteCd;
		//this.chkDeSteCd=true;
	}
	public void setVndrCntCd(String vndrCntCd) {
		this.vndrCntCd = vndrCntCd;
		//this.vndrCntCd=true;
	}
	public void setChkDeAddr2(String chkDeAddr2) {
		this.chkDeAddr2 = chkDeAddr2;
		//this.chkDeAddr2=true;
	}
	public void setTeamFlg(String teamFlg) {
		this.teamFlg = teamFlg;
		//this.teamFlg=true;
	}
	public void setModiVndrSeq(String modiVndrSeq) {
		this.modiVndrSeq = modiVndrSeq;
		//this.modiVndrSeq=true;
	}
	public void setLoclLangAddr(String loclLangAddr) {
		this.loclLangAddr = loclLangAddr;
		//this.loclLangAddr=true;
	}
	public void setCeoNm(String ceoNm) {
		this.ceoNm = ceoNm;
		//this.ceoNm=true;
	}
	public void setLuDeltFlg(String luDeltFlg) {
		this.luDeltFlg = luDeltFlg;
		//this.luDeltFlg=true;
	}
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
		//this.vndrSeq=true;
	}
	public void setPayMzdCd(String payMzdCd) {
		this.payMzdCd = payMzdCd;
		//this.payMzdCd=true;
	}
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
		//this.vndrLglEngNm=true;
	}
	public void setSvcPrdTpNm(String svcPrdTpNm) {
		this.svcPrdTpNm = svcPrdTpNm;
		//this.svcPrdTpNm=true;
	}
	public void setFletMgmtOwnrVndrSeq(String fletMgmtOwnrVndrSeq) {
		this.fletMgmtOwnrVndrSeq = fletMgmtOwnrVndrSeq;
		//this.fletMgmtOwnrVndrSeq=true;
	}
	public void setBlkVndrSvcCd(String blkVndrSvcCd) {
		this.blkVndrSvcCd = blkVndrSvcCd;
		//this.blkVndrSvcCd=true;
	}
	public void setCreDt(String creDt) {
		this.creDt = creDt;
		//this.creDt=true;
	}
	public void setBzctNm(String bzctNm) {
		this.bzctNm = bzctNm;
		//this.bzctNm=true;
	}
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
		//this.creUsrId=true;
	}
	public void setBlkFlg(String blkFlg) {
		this.blkFlg = blkFlg;
		//this.blkFlg=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setRgstNo(JSPUtil.getParameter(request, "rgst_no", ""));
		setGenPayTermCd(JSPUtil.getParameter(request, "gen_pay_term_cd", ""));
		setSvcPrdRmk(JSPUtil.getParameter(request, "svc_prd_rmk", ""));
		setPrntVndrSeq(JSPUtil.getParameter(request, "prnt_vndr_seq", ""));
		setChkDeCntCd(JSPUtil.getParameter(request, "chk_de_cnt_cd", ""));
		setCnlAgnFlg(JSPUtil.getParameter(request, "cnl_agn_flg", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setEaiEvntDt(JSPUtil.getParameter(request, "eai_evnt_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setRfndPsdoCustCd(JSPUtil.getParameter(request, "rfnd_psdo_cust_cd", ""));
		setChkDeAddr1(JSPUtil.getParameter(request, "chk_de_addr1", ""));
		setUsaEdiCd(JSPUtil.getParameter(request, "usa_edi_cd", ""));
		setSubsCoCd(JSPUtil.getParameter(request, "subs_co_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setOtrFlg(JSPUtil.getParameter(request, "otr_flg", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setMtyRroEdiUseFlg(JSPUtil.getParameter(request, "mty_rro_edi_use_flg", ""));
		setInterCoFlg(JSPUtil.getParameter(request, "inter_co_flg", ""));
		setWoAtchFileFlg(JSPUtil.getParameter(request, "wo_atch_file_flg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLgsFlg(JSPUtil.getParameter(request, "lgs_flg", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, "vndr_abbr_nm", ""));
		setCnlAgnBankDesc(JSPUtil.getParameter(request, "cnl_agn_bank_desc", ""));
		setMnrDfltTrsmCd(JSPUtil.getParameter(request, "mnr_dflt_trsm_cd", ""));
		setPrntCntCd(JSPUtil.getParameter(request, "prnt_cnt_cd", ""));
		setCntcPsonNm(JSPUtil.getParameter(request, "cntc_pson_nm", ""));
		setPayTermTpCd(JSPUtil.getParameter(request, "pay_term_tp_cd", ""));
		setVndrLoclLangNm(JSPUtil.getParameter(request, "vndr_locl_lang_nm", ""));
		setProcuFlg(JSPUtil.getParameter(request, "procu_flg", ""));
		setZipCd(JSPUtil.getParameter(request, "zip_cd", ""));
		setInvCurrCd(JSPUtil.getParameter(request, "inv_curr_cd", ""));
		setTaxId(JSPUtil.getParameter(request, "tax_id", ""));
		setFincFlg(JSPUtil.getParameter(request, "finc_flg", ""));
		setChkDeZipCd(JSPUtil.getParameter(request, "chk_de_zip_cd", ""));
		setChkDeAddr3(JSPUtil.getParameter(request, "chk_de_addr3", ""));
		setPayCurrCd(JSPUtil.getParameter(request, "pay_curr_cd", ""));
		setWoEdiUseFlg(JSPUtil.getParameter(request, "wo_edi_use_flg", ""));
		setChkDeCtyNm(JSPUtil.getParameter(request, "chk_de_cty_nm", ""));
		setDcgoHndlFlg(JSPUtil.getParameter(request, "dcgo_hndl_flg", ""));
		setInvEdiUseFlg(JSPUtil.getParameter(request, "inv_edi_use_flg", ""));
		setVndrOfcCd(JSPUtil.getParameter(request, "vndr_ofc_cd", ""));
		setBztpNm(JSPUtil.getParameter(request, "bztp_nm", ""));
		setSvcScpCdNm(JSPUtil.getParameter(request, "svc_scp_cd_nm", ""));
		setEngAddr(JSPUtil.getParameter(request, "eng_addr", ""));
		setChkDeSteCd(JSPUtil.getParameter(request, "chk_de_ste_cd", ""));
		setVndrCntCd(JSPUtil.getParameter(request, "vndr_cnt_cd", ""));
		setChkDeAddr2(JSPUtil.getParameter(request, "chk_de_addr2", ""));
		setTeamFlg(JSPUtil.getParameter(request, "team_flg", ""));
		setModiVndrSeq(JSPUtil.getParameter(request, "modi_vndr_seq", ""));
		setLoclLangAddr(JSPUtil.getParameter(request, "locl_lang_addr", ""));
		setCeoNm(JSPUtil.getParameter(request, "ceo_nm", ""));
		setLuDeltFlg(JSPUtil.getParameter(request, "lu_delt_flg", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setPayMzdCd(JSPUtil.getParameter(request, "pay_mzd_cd", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setSvcPrdTpNm(JSPUtil.getParameter(request, "svc_prd_tp_nm", ""));
		setFletMgmtOwnrVndrSeq(JSPUtil.getParameter(request, "flet_mgmt_ownr_vndr_seq", ""));
		setBlkVndrSvcCd(JSPUtil.getParameter(request, "blk_vndr_svc_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setBzctNm(JSPUtil.getParameter(request, "bzct_nm", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setBlkFlg(JSPUtil.getParameter(request, "blk_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public MdmVendorMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public MdmVendorMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MdmVendorMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rgstNo = (JSPUtil.getParameter(request, prefix	+ "rgst_no".trim(), length));
			String[] genPayTermCd = (JSPUtil.getParameter(request, prefix	+ "gen_pay_term_cd".trim(), length));
			String[] svcPrdRmk = (JSPUtil.getParameter(request, prefix	+ "svc_prd_rmk".trim(), length));
			String[] prntVndrSeq = (JSPUtil.getParameter(request, prefix	+ "prnt_vndr_seq".trim(), length));
			String[] chkDeCntCd = (JSPUtil.getParameter(request, prefix	+ "chk_de_cnt_cd".trim(), length));
			String[] cnlAgnFlg = (JSPUtil.getParameter(request, prefix	+ "cnl_agn_flg".trim(), length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd".trim(), length));
			String[] eaiEvntDt = (JSPUtil.getParameter(request, prefix	+ "eai_evnt_dt".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] rfndPsdoCustCd = (JSPUtil.getParameter(request, prefix	+ "rfnd_psdo_cust_cd".trim(), length));
			String[] chkDeAddr1 = (JSPUtil.getParameter(request, prefix	+ "chk_de_addr1".trim(), length));
			String[] usaEdiCd = (JSPUtil.getParameter(request, prefix	+ "usa_edi_cd".trim(), length));
			String[] subsCoCd = (JSPUtil.getParameter(request, prefix	+ "subs_co_cd".trim(), length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] otrFlg = (JSPUtil.getParameter(request, prefix	+ "otr_flg".trim(), length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg".trim(), length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd".trim(), length));
			String[] mtyRroEdiUseFlg = (JSPUtil.getParameter(request, prefix	+ "mty_rro_edi_use_flg".trim(), length));
			String[] interCoFlg = (JSPUtil.getParameter(request, prefix	+ "inter_co_flg".trim(), length));
			String[] woAtchFileFlg = (JSPUtil.getParameter(request, prefix	+ "wo_atch_file_flg".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] lgsFlg = (JSPUtil.getParameter(request, prefix	+ "lgs_flg".trim(), length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm".trim(), length));
			String[] cnlAgnBankDesc = (JSPUtil.getParameter(request, prefix	+ "cnl_agn_bank_desc".trim(), length));
			String[] mnrDfltTrsmCd = (JSPUtil.getParameter(request, prefix	+ "mnr_dflt_trsm_cd".trim(), length));
			String[] prntCntCd = (JSPUtil.getParameter(request, prefix	+ "prnt_cnt_cd".trim(), length));
			String[] cntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_nm".trim(), length));
			String[] payTermTpCd = (JSPUtil.getParameter(request, prefix	+ "pay_term_tp_cd".trim(), length));
			String[] vndrLoclLangNm = (JSPUtil.getParameter(request, prefix	+ "vndr_locl_lang_nm".trim(), length));
			String[] procuFlg = (JSPUtil.getParameter(request, prefix	+ "procu_flg".trim(), length));
			String[] zipCd = (JSPUtil.getParameter(request, prefix	+ "zip_cd".trim(), length));
			String[] invCurrCd = (JSPUtil.getParameter(request, prefix	+ "inv_curr_cd".trim(), length));
			String[] taxId = (JSPUtil.getParameter(request, prefix	+ "tax_id".trim(), length));
			String[] fincFlg = (JSPUtil.getParameter(request, prefix	+ "finc_flg".trim(), length));
			String[] chkDeZipCd = (JSPUtil.getParameter(request, prefix	+ "chk_de_zip_cd".trim(), length));
			String[] chkDeAddr3 = (JSPUtil.getParameter(request, prefix	+ "chk_de_addr3".trim(), length));
			String[] payCurrCd = (JSPUtil.getParameter(request, prefix	+ "pay_curr_cd".trim(), length));
			String[] woEdiUseFlg = (JSPUtil.getParameter(request, prefix	+ "wo_edi_use_flg".trim(), length));
			String[] chkDeCtyNm = (JSPUtil.getParameter(request, prefix	+ "chk_de_cty_nm".trim(), length));
			String[] dcgoHndlFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_hndl_flg".trim(), length));
			String[] invEdiUseFlg = (JSPUtil.getParameter(request, prefix	+ "inv_edi_use_flg".trim(), length));
			String[] vndrOfcCd = (JSPUtil.getParameter(request, prefix	+ "vndr_ofc_cd".trim(), length));
			String[] bztpNm = (JSPUtil.getParameter(request, prefix	+ "bztp_nm".trim(), length));
			String[] svcScpCdNm = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd_nm".trim(), length));
			String[] engAddr = (JSPUtil.getParameter(request, prefix	+ "eng_addr".trim(), length));
			String[] chkDeSteCd = (JSPUtil.getParameter(request, prefix	+ "chk_de_ste_cd".trim(), length));
			String[] vndrCntCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_cd".trim(), length));
			String[] chkDeAddr2 = (JSPUtil.getParameter(request, prefix	+ "chk_de_addr2".trim(), length));
			String[] teamFlg = (JSPUtil.getParameter(request, prefix	+ "team_flg".trim(), length));
			String[] modiVndrSeq = (JSPUtil.getParameter(request, prefix	+ "modi_vndr_seq".trim(), length));
			String[] loclLangAddr = (JSPUtil.getParameter(request, prefix	+ "locl_lang_addr".trim(), length));
			String[] ceoNm = (JSPUtil.getParameter(request, prefix	+ "ceo_nm".trim(), length));
			String[] luDeltFlg = (JSPUtil.getParameter(request, prefix	+ "lu_delt_flg".trim(), length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq".trim(), length));
			String[] payMzdCd = (JSPUtil.getParameter(request, prefix	+ "pay_mzd_cd".trim(), length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm".trim(), length));
			String[] svcPrdTpNm = (JSPUtil.getParameter(request, prefix	+ "svc_prd_tp_nm".trim(), length));
			String[] fletMgmtOwnrVndrSeq = (JSPUtil.getParameter(request, prefix	+ "flet_mgmt_ownr_vndr_seq".trim(), length));
			String[] blkVndrSvcCd = (JSPUtil.getParameter(request, prefix	+ "blk_vndr_svc_cd".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] bzctNm = (JSPUtil.getParameter(request, prefix	+ "bzct_nm".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] blkFlg = (JSPUtil.getParameter(request, prefix	+ "blk_flg".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new MdmVendorMGTVO();
				if (rgstNo[i] != null)
					model.setRgstNo(rgstNo[i]);
				if (genPayTermCd[i] != null)
					model.setGenPayTermCd(genPayTermCd[i]);
				if (svcPrdRmk[i] != null)
					model.setSvcPrdRmk(svcPrdRmk[i]);
				if (prntVndrSeq[i] != null)
					model.setPrntVndrSeq(prntVndrSeq[i]);
				if (chkDeCntCd[i] != null)
					model.setChkDeCntCd(chkDeCntCd[i]);
				if (cnlAgnFlg[i] != null)
					model.setCnlAgnFlg(cnlAgnFlg[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (eaiEvntDt[i] != null)
					model.setEaiEvntDt(eaiEvntDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (rfndPsdoCustCd[i] != null)
					model.setRfndPsdoCustCd(rfndPsdoCustCd[i]);
				if (chkDeAddr1[i] != null)
					model.setChkDeAddr1(chkDeAddr1[i]);
				if (usaEdiCd[i] != null)
					model.setUsaEdiCd(usaEdiCd[i]);
				if (subsCoCd[i] != null)
					model.setSubsCoCd(subsCoCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (otrFlg[i] != null)
					model.setOtrFlg(otrFlg[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (mtyRroEdiUseFlg[i] != null)
					model.setMtyRroEdiUseFlg(mtyRroEdiUseFlg[i]);
				if (interCoFlg[i] != null)
					model.setInterCoFlg(interCoFlg[i]);
				if (woAtchFileFlg[i] != null)
					model.setWoAtchFileFlg(woAtchFileFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lgsFlg[i] != null)
					model.setLgsFlg(lgsFlg[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (cnlAgnBankDesc[i] != null)
					model.setCnlAgnBankDesc(cnlAgnBankDesc[i]);
				if (mnrDfltTrsmCd[i] != null)
					model.setMnrDfltTrsmCd(mnrDfltTrsmCd[i]);
				if (prntCntCd[i] != null)
					model.setPrntCntCd(prntCntCd[i]);
				if (cntcPsonNm[i] != null)
					model.setCntcPsonNm(cntcPsonNm[i]);
				if (payTermTpCd[i] != null)
					model.setPayTermTpCd(payTermTpCd[i]);
				if (vndrLoclLangNm[i] != null)
					model.setVndrLoclLangNm(vndrLoclLangNm[i]);
				if (procuFlg[i] != null)
					model.setProcuFlg(procuFlg[i]);
				if (zipCd[i] != null)
					model.setZipCd(zipCd[i]);
				if (invCurrCd[i] != null)
					model.setInvCurrCd(invCurrCd[i]);
				if (taxId[i] != null)
					model.setTaxId(taxId[i]);
				if (fincFlg[i] != null)
					model.setFincFlg(fincFlg[i]);
				if (chkDeZipCd[i] != null)
					model.setChkDeZipCd(chkDeZipCd[i]);
				if (chkDeAddr3[i] != null)
					model.setChkDeAddr3(chkDeAddr3[i]);
				if (payCurrCd[i] != null)
					model.setPayCurrCd(payCurrCd[i]);
				if (woEdiUseFlg[i] != null)
					model.setWoEdiUseFlg(woEdiUseFlg[i]);
				if (chkDeCtyNm[i] != null)
					model.setChkDeCtyNm(chkDeCtyNm[i]);
				if (dcgoHndlFlg[i] != null)
					model.setDcgoHndlFlg(dcgoHndlFlg[i]);
				if (invEdiUseFlg[i] != null)
					model.setInvEdiUseFlg(invEdiUseFlg[i]);
				if (vndrOfcCd[i] != null)
					model.setVndrOfcCd(vndrOfcCd[i]);
				if (bztpNm[i] != null)
					model.setBztpNm(bztpNm[i]);
				if (svcScpCdNm[i] != null)
					model.setSvcScpCdNm(svcScpCdNm[i]);
				if (engAddr[i] != null)
					model.setEngAddr(engAddr[i]);
				if (chkDeSteCd[i] != null)
					model.setChkDeSteCd(chkDeSteCd[i]);
				if (vndrCntCd[i] != null)
					model.setVndrCntCd(vndrCntCd[i]);
				if (chkDeAddr2[i] != null)
					model.setChkDeAddr2(chkDeAddr2[i]);
				if (teamFlg[i] != null)
					model.setTeamFlg(teamFlg[i]);
				if (modiVndrSeq[i] != null)
					model.setModiVndrSeq(modiVndrSeq[i]);
				if (loclLangAddr[i] != null)
					model.setLoclLangAddr(loclLangAddr[i]);
				if (ceoNm[i] != null)
					model.setCeoNm(ceoNm[i]);
				if (luDeltFlg[i] != null)
					model.setLuDeltFlg(luDeltFlg[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (payMzdCd[i] != null)
					model.setPayMzdCd(payMzdCd[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (svcPrdTpNm[i] != null)
					model.setSvcPrdTpNm(svcPrdTpNm[i]);
				if (fletMgmtOwnrVndrSeq[i] != null)
					model.setFletMgmtOwnrVndrSeq(fletMgmtOwnrVndrSeq[i]);
				if (blkVndrSvcCd[i] != null)
					model.setBlkVndrSvcCd(blkVndrSvcCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (bzctNm[i] != null)
					model.setBzctNm(bzctNm[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (blkFlg[i] != null)
					model.setBlkFlg(blkFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getMdmVendorVOs();
	}

	public MdmVendorMGTVO[] getMdmVendorVOs(){
		MdmVendorMGTVO[] vos = (MdmVendorMGTVO[])models.toArray(new MdmVendorMGTVO[models.size()]);
		return vos;
	}
	
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
		} catch (Exception ex) {}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.rgstNo = this.rgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genPayTermCd = this.genPayTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcPrdRmk = this.svcPrdRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prntVndrSeq = this.prntVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkDeCntCd = this.chkDeCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnlAgnFlg = this.cnlAgnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiEvntDt = this.eaiEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfndPsdoCustCd = this.rfndPsdoCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkDeAddr1 = this.chkDeAddr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaEdiCd = this.usaEdiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subsCoCd = this.subsCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrFlg = this.otrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyRroEdiUseFlg = this.mtyRroEdiUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interCoFlg = this.interCoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woAtchFileFlg = this.woAtchFileFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsFlg = this.lgsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnlAgnBankDesc = this.cnlAgnBankDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDfltTrsmCd = this.mnrDfltTrsmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prntCntCd = this.prntCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm = this.cntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTermTpCd = this.payTermTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLoclLangNm = this.vndrLoclLangNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.procuFlg = this.procuFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zipCd = this.zipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd = this.invCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxId = this.taxId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincFlg = this.fincFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkDeZipCd = this.chkDeZipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkDeAddr3 = this.chkDeAddr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payCurrCd = this.payCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woEdiUseFlg = this.woEdiUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkDeCtyNm = this.chkDeCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoHndlFlg = this.dcgoHndlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEdiUseFlg = this.invEdiUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrOfcCd = this.vndrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bztpNm = this.bztpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCdNm = this.svcScpCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.engAddr = this.engAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkDeSteCd = this.chkDeSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntCd = this.vndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkDeAddr2 = this.chkDeAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teamFlg = this.teamFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiVndrSeq = this.modiVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclLangAddr = this.loclLangAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ceoNm = this.ceoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.luDeltFlg = this.luDeltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payMzdCd = this.payMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcPrdTpNm = this.svcPrdTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletMgmtOwnrVndrSeq = this.fletMgmtOwnrVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkVndrSvcCd = this.blkVndrSvcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzctNm = this.bzctNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkFlg = this.blkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
