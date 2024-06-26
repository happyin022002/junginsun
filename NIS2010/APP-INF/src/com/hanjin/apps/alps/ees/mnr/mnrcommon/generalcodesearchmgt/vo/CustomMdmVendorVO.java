/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomMdmVendorVO.java
*@FileTitle : CustomMdmVendorVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 정영훈
*@LastVersion : 1.0
* 2009.06.19 정영훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo;

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
 * @author 정영훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomMdmVendorVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMdmVendorVO> models = new ArrayList<CustomMdmVendorVO>();
	
	/* Column Info */
	private String vndrCntCd = null;
	/* Column Info */
	private String bzctNm = null;
	/* Column Info */
	private String chkDeCntCd = null;
	/* Column Info */
	private String bztpNm = null;
	/* Column Info */
	private String procuFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String chkDeZipCd = null;
	/* Column Info */
	private String otrFlg = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String dcgoHndlFlg = null;
	/* Column Info */
	private String subsCoCd = null;
	/* Column Info */
	private String interCoFlg = null;
	/* Column Info */
	private String fletMgmtOwnrVndrSeq = null;
	/* Column Info */
	private String chkDeAddr2 = null;
	/* Column Info */
	private String chkDeAddr3 = null;
	/* Column Info */
	private String chkDeAddr1 = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String chkDeCtyNm = null;
	/* Column Info */
	private String agmtRefNo = null;
	/* Column Info */
	private String engAddr = null;
	/* Column Info */
	private String vndrOfcCd = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String svcScpCdNm = null;
	/* Column Info */
	private String payMzdCd = null;
	/* Column Info */
	private String svcPrdTpNm = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String taxId = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String prntCntCd = null;
	/* Column Info */
	private String zipCd = null;
	/* Column Info */
	private String usaEdiCd = null;
	/* Column Info */
	private String fincFlg = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String mnrDfltTrsmCd = null;
	/* Column Info */
	private String payTermTpCd = null;
	/* Column Info */
	private String rgstNo = null;
	/* Column Info */
	private String invEdiUseFlg = null;
	/* Column Info */
	private String prntVndrSeq = null;
	/* Column Info */
	private String lgsFlg = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String teamFlg = null;
	/* Column Info */
	private String vndrLoclLangNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effectDt = null;
	/* Column Info */
	private String woEdiUseFlg = null;
	/* Column Info */
	private String luDeltFlg = null;
	/* Column Info */
	private String cntcPsonNm = null;
	/* Column Info */
	private String modiVndrSeq = null;
	/* Column Info */
	private String mtyRroEdiUseFlg = null;
	/* Column Info */
	private String blkFlg = null;
	/* Column Info */
	private String rfndPsdoCustCd = null;
	/* Column Info */
	private String cnlAgnFlg = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String blkVndrSvcCd = null;
	/* Column Info */
	private String loclLangAddr = null;
	/* Column Info */
	private String svcPrdRmk = null;
	/* Column Info */
	private String genPayTermCd = null;
	/* Column Info */
	private String cnlAgnBankDesc = null;
	/* Column Info */
	private String eaiEvntDt = null;
	/* Column Info */
	private String invCurrCd = null;
	/* Column Info */
	private String payCurrCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String ceoNm = null;
	/* Column Info */
	private String chkDeSteCd = null;
	/* Column Info */
	private String woAtchFileFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	 /**
	 * CustomMdmVendorVO을 생성함
	 */
	public CustomMdmVendorVO() {}

     /**
     * CustomMdmVendorVO을 생성함
     */
	public CustomMdmVendorVO(String ibflag, String pagerows, String effectDt, String vndrCntCd, String bzctNm, String chkDeCntCd, String bztpNm, String procuFlg, String chkDeZipCd, String otrFlg, String locCd, String dcgoHndlFlg, String subsCoCd, String chkDeAddr2, String fletMgmtOwnrVndrSeq, String interCoFlg, String chkDeAddr3, String chkDeAddr1, String updUsrId, String chkDeCtyNm, String agmtRefNo, String engAddr, String vndrOfcCd, String agmtNo, String svcScpCdNm, String payMzdCd, String svcPrdTpNm, String creUsrId, String taxId, String vndrSeq, String prntCntCd, String zipCd, String usaEdiCd, String fincFlg, String vndrAbbrNm, String mnrDfltTrsmCd, String payTermTpCd, String rgstNo, String invEdiUseFlg, String prntVndrSeq, String lgsFlg, String deltFlg, String creDt, String vndrLglEngNm, String teamFlg, String vndrLoclLangNm, String woEdiUseFlg, String luDeltFlg, String modiVndrSeq, String cntcPsonNm, String mtyRroEdiUseFlg, String blkFlg, String rfndPsdoCustCd, String cnlAgnFlg, String updDt, String blkVndrSvcCd, String loclLangAddr, String svcPrdRmk, String genPayTermCd, String cnlAgnBankDesc, String eaiEvntDt, String invCurrCd, String ofcCd, String payCurrCd, String ceoNm, String chkDeSteCd, String woAtchFileFlg) {
		this.vndrCntCd = vndrCntCd;
		this.bzctNm = bzctNm;
		this.chkDeCntCd = chkDeCntCd;
		this.bztpNm = bztpNm;
		this.procuFlg = procuFlg;
		this.pagerows = pagerows;
		this.chkDeZipCd = chkDeZipCd;
		this.otrFlg = otrFlg;
		this.locCd = locCd;
		this.dcgoHndlFlg = dcgoHndlFlg;
		this.subsCoCd = subsCoCd;
		this.interCoFlg = interCoFlg;
		this.fletMgmtOwnrVndrSeq = fletMgmtOwnrVndrSeq;
		this.chkDeAddr2 = chkDeAddr2;
		this.chkDeAddr3 = chkDeAddr3;
		this.chkDeAddr1 = chkDeAddr1;
		this.updUsrId = updUsrId;
		this.chkDeCtyNm = chkDeCtyNm;
		this.agmtRefNo = agmtRefNo;
		this.engAddr = engAddr;
		this.vndrOfcCd = vndrOfcCd;
		this.agmtNo = agmtNo;
		this.svcScpCdNm = svcScpCdNm;
		this.payMzdCd = payMzdCd;
		this.svcPrdTpNm = svcPrdTpNm;
		this.creUsrId = creUsrId;
		this.taxId = taxId;
		this.vndrSeq = vndrSeq;
		this.prntCntCd = prntCntCd;
		this.zipCd = zipCd;
		this.usaEdiCd = usaEdiCd;
		this.fincFlg = fincFlg;
		this.vndrAbbrNm = vndrAbbrNm;
		this.mnrDfltTrsmCd = mnrDfltTrsmCd;
		this.payTermTpCd = payTermTpCd;
		this.rgstNo = rgstNo;
		this.invEdiUseFlg = invEdiUseFlg;
		this.prntVndrSeq = prntVndrSeq;
		this.lgsFlg = lgsFlg;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.vndrLglEngNm = vndrLglEngNm;
		this.teamFlg = teamFlg;
		this.vndrLoclLangNm = vndrLoclLangNm;
		this.ibflag = ibflag;
		this.effectDt = effectDt;
		this.woEdiUseFlg = woEdiUseFlg;
		this.luDeltFlg = luDeltFlg;
		this.cntcPsonNm = cntcPsonNm;
		this.modiVndrSeq = modiVndrSeq;
		this.mtyRroEdiUseFlg = mtyRroEdiUseFlg;
		this.blkFlg = blkFlg;
		this.rfndPsdoCustCd = rfndPsdoCustCd;
		this.cnlAgnFlg = cnlAgnFlg;
		this.updDt = updDt;
		this.blkVndrSvcCd = blkVndrSvcCd;
		this.loclLangAddr = loclLangAddr;
		this.svcPrdRmk = svcPrdRmk;
		this.genPayTermCd = genPayTermCd;
		this.cnlAgnBankDesc = cnlAgnBankDesc;
		this.eaiEvntDt = eaiEvntDt;
		this.invCurrCd = invCurrCd;
		this.payCurrCd = payCurrCd;
		this.ofcCd = ofcCd;
		this.ceoNm = ceoNm;
		this.chkDeSteCd = chkDeSteCd;
		this.woAtchFileFlg = woAtchFileFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
		this.hashColumns.put("bzct_nm", getBzctNm());
		this.hashColumns.put("chk_de_cnt_cd", getChkDeCntCd());
		this.hashColumns.put("bztp_nm", getBztpNm());
		this.hashColumns.put("procu_flg", getProcuFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("chk_de_zip_cd", getChkDeZipCd());
		this.hashColumns.put("otr_flg", getOtrFlg());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("dcgo_hndl_flg", getDcgoHndlFlg());
		this.hashColumns.put("subs_co_cd", getSubsCoCd());
		this.hashColumns.put("inter_co_flg", getInterCoFlg());
		this.hashColumns.put("flet_mgmt_ownr_vndr_seq", getFletMgmtOwnrVndrSeq());
		this.hashColumns.put("chk_de_addr2", getChkDeAddr2());
		this.hashColumns.put("chk_de_addr3", getChkDeAddr3());
		this.hashColumns.put("chk_de_addr1", getChkDeAddr1());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("chk_de_cty_nm", getChkDeCtyNm());
		this.hashColumns.put("agmt_ref_no", getAgmtRefNo());
		this.hashColumns.put("eng_addr", getEngAddr());
		this.hashColumns.put("vndr_ofc_cd", getVndrOfcCd());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("svc_scp_cd_nm", getSvcScpCdNm());
		this.hashColumns.put("pay_mzd_cd", getPayMzdCd());
		this.hashColumns.put("svc_prd_tp_nm", getSvcPrdTpNm());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("tax_id", getTaxId());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("prnt_cnt_cd", getPrntCntCd());
		this.hashColumns.put("zip_cd", getZipCd());
		this.hashColumns.put("usa_edi_cd", getUsaEdiCd());
		this.hashColumns.put("finc_flg", getFincFlg());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("mnr_dflt_trsm_cd", getMnrDfltTrsmCd());
		this.hashColumns.put("pay_term_tp_cd", getPayTermTpCd());
		this.hashColumns.put("rgst_no", getRgstNo());
		this.hashColumns.put("inv_edi_use_flg", getInvEdiUseFlg());
		this.hashColumns.put("prnt_vndr_seq", getPrntVndrSeq());
		this.hashColumns.put("lgs_flg", getLgsFlg());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("team_flg", getTeamFlg());
		this.hashColumns.put("vndr_locl_lang_nm", getVndrLoclLangNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("effect_dt", getEffectDt());
		this.hashColumns.put("wo_edi_use_flg", getWoEdiUseFlg());
		this.hashColumns.put("lu_delt_flg", getLuDeltFlg());
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
		this.hashColumns.put("modi_vndr_seq", getModiVndrSeq());
		this.hashColumns.put("mty_rro_edi_use_flg", getMtyRroEdiUseFlg());
		this.hashColumns.put("blk_flg", getBlkFlg());
		this.hashColumns.put("rfnd_psdo_cust_cd", getRfndPsdoCustCd());
		this.hashColumns.put("cnl_agn_flg", getCnlAgnFlg());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("blk_vndr_svc_cd", getBlkVndrSvcCd());
		this.hashColumns.put("locl_lang_addr", getLoclLangAddr());
		this.hashColumns.put("svc_prd_rmk", getSvcPrdRmk());
		this.hashColumns.put("gen_pay_term_cd", getGenPayTermCd());
		this.hashColumns.put("cnl_agn_bank_desc", getCnlAgnBankDesc());
		this.hashColumns.put("eai_evnt_dt", getEaiEvntDt());
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());
		this.hashColumns.put("pay_curr_cd", getPayCurrCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ceo_nm", getCeoNm());
		this.hashColumns.put("chk_de_ste_cd", getChkDeSteCd());
		this.hashColumns.put("wo_atch_file_flg", getWoAtchFileFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
		this.hashFields.put("bzct_nm", "bzctNm");
		this.hashFields.put("chk_de_cnt_cd", "chkDeCntCd");
		this.hashFields.put("bztp_nm", "bztpNm");
		this.hashFields.put("procu_flg", "procuFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("chk_de_zip_cd", "chkDeZipCd");
		this.hashFields.put("otr_flg", "otrFlg");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("dcgo_hndl_flg", "dcgoHndlFlg");
		this.hashFields.put("subs_co_cd", "subsCoCd");
		this.hashFields.put("inter_co_flg", "interCoFlg");
		this.hashFields.put("flet_mgmt_ownr_vndr_seq", "fletMgmtOwnrVndrSeq");
		this.hashFields.put("chk_de_addr2", "chkDeAddr2");
		this.hashFields.put("chk_de_addr3", "chkDeAddr3");
		this.hashFields.put("chk_de_addr1", "chkDeAddr1");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("chk_de_cty_nm", "chkDeCtyNm");
		this.hashFields.put("agmt_ref_no", "agmtRefNo");
		this.hashFields.put("eng_addr", "engAddr");
		this.hashFields.put("vndr_ofc_cd", "vndrOfcCd");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("svc_scp_cd_nm", "svcScpCdNm");
		this.hashFields.put("pay_mzd_cd", "payMzdCd");
		this.hashFields.put("svc_prd_tp_nm", "svcPrdTpNm");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("tax_id", "taxId");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("prnt_cnt_cd", "prntCntCd");
		this.hashFields.put("zip_cd", "zipCd");
		this.hashFields.put("usa_edi_cd", "usaEdiCd");
		this.hashFields.put("finc_flg", "fincFlg");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("mnr_dflt_trsm_cd", "mnrDfltTrsmCd");
		this.hashFields.put("pay_term_tp_cd", "payTermTpCd");
		this.hashFields.put("rgst_no", "rgstNo");
		this.hashFields.put("inv_edi_use_flg", "invEdiUseFlg");
		this.hashFields.put("prnt_vndr_seq", "prntVndrSeq");
		this.hashFields.put("lgs_flg", "lgsFlg");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("team_flg", "teamFlg");
		this.hashFields.put("vndr_locl_lang_nm", "vndrLoclLangNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("effect_dt", "effectDt");
		this.hashFields.put("wo_edi_use_flg", "woEdiUseFlg");
		this.hashFields.put("lu_delt_flg", "luDeltFlg");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
		this.hashFields.put("modi_vndr_seq", "modiVndrSeq");
		this.hashFields.put("mty_rro_edi_use_flg", "mtyRroEdiUseFlg");
		this.hashFields.put("blk_flg", "blkFlg");
		this.hashFields.put("rfnd_psdo_cust_cd", "rfndPsdoCustCd");
		this.hashFields.put("cnl_agn_flg", "cnlAgnFlg");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("blk_vndr_svc_cd", "blkVndrSvcCd");
		this.hashFields.put("locl_lang_addr", "loclLangAddr");
		this.hashFields.put("svc_prd_rmk", "svcPrdRmk");
		this.hashFields.put("gen_pay_term_cd", "genPayTermCd");
		this.hashFields.put("cnl_agn_bank_desc", "cnlAgnBankDesc");
		this.hashFields.put("eai_evnt_dt", "eaiEvntDt");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("pay_curr_cd", "payCurrCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ceo_nm", "ceoNm");
		this.hashFields.put("chk_de_ste_cd", "chkDeSteCd");
		this.hashFields.put("wo_atch_file_flg", "woAtchFileFlg");
		return this.hashFields;
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
	 * @return bzctNm
	 */
	public String getBzctNm() {
		return this.bzctNm;
	}
	
	/**
	 * Column Info
	 * @return chkDeCntCd
	 */
	public String getChkDeCntCd() {
		return this.chkDeCntCd;
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
	 * @return procuFlg
	 */
	public String getProcuFlg() {
		return this.procuFlg;
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
	 * @return chkDeZipCd
	 */
	public String getChkDeZipCd() {
		return this.chkDeZipCd;
	}
	
	/**
	 * Column Info
	 * @return otrFlg
	 */
	public String getOtrFlg() {
		return this.otrFlg;
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
	 * @return dcgoHndlFlg
	 */
	public String getDcgoHndlFlg() {
		return this.dcgoHndlFlg;
	}
	
	/**
	 * Column Info
	 * @return subsCoCd
	 */
	public String getSubsCoCd() {
		return this.subsCoCd;
	}
	
	/**
	 * Column Info
	 * @return interCoFlg
	 */
	public String getInterCoFlg() {
		return this.interCoFlg;
	}
	
	/**
	 * Column Info
	 * @return fletMgmtOwnrVndrSeq
	 */
	public String getFletMgmtOwnrVndrSeq() {
		return this.fletMgmtOwnrVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return chkDeAddr2
	 */
	public String getChkDeAddr2() {
		return this.chkDeAddr2;
	}
	
	/**
	 * Column Info
	 * @return chkDeAddr3
	 */
	public String getChkDeAddr3() {
		return this.chkDeAddr3;
	}
	
	/**
	 * Column Info
	 * @return chkDeAddr1
	 */
	public String getChkDeAddr1() {
		return this.chkDeAddr1;
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
	 * @return chkDeCtyNm
	 */
	public String getChkDeCtyNm() {
		return this.chkDeCtyNm;
	}
	
	/**
	 * Column Info
	 * @return agmtRefNo
	 */
	public String getAgmtRefNo() {
		return this.agmtRefNo;
	}
	
	/**
	 * Column Info
	 * @return engAddr
	 */
	public String getEngAddr() {
		return this.engAddr;
	}
	
	/**
	 * Column Info
	 * @return vndrOfcCd
	 */
	public String getVndrOfcCd() {
		return this.vndrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return svcScpCdNm
	 */
	public String getSvcScpCdNm() {
		return this.svcScpCdNm;
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
	 * @return svcPrdTpNm
	 */
	public String getSvcPrdTpNm() {
		return this.svcPrdTpNm;
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
	 * @return taxId
	 */
	public String getTaxId() {
		return this.taxId;
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
	 * @return prntCntCd
	 */
	public String getPrntCntCd() {
		return this.prntCntCd;
	}
	
	/**
	 * Column Info
	 * @return zipCd
	 */
	public String getZipCd() {
		return this.zipCd;
	}
	
	/**
	 * Column Info
	 * @return usaEdiCd
	 */
	public String getUsaEdiCd() {
		return this.usaEdiCd;
	}
	
	/**
	 * Column Info
	 * @return fincFlg
	 */
	public String getFincFlg() {
		return this.fincFlg;
	}
	
	/**
	 * Column Info
	 * @return vndrAbbrNm
	 */
	public String getVndrAbbrNm() {
		return this.vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return mnrDfltTrsmCd
	 */
	public String getMnrDfltTrsmCd() {
		return this.mnrDfltTrsmCd;
	}
	
	/**
	 * Column Info
	 * @return payTermTpCd
	 */
	public String getPayTermTpCd() {
		return this.payTermTpCd;
	}
	
	/**
	 * Column Info
	 * @return rgstNo
	 */
	public String getRgstNo() {
		return this.rgstNo;
	}
	
	/**
	 * Column Info
	 * @return invEdiUseFlg
	 */
	public String getInvEdiUseFlg() {
		return this.invEdiUseFlg;
	}
	
	/**
	 * Column Info
	 * @return prntVndrSeq
	 */
	public String getPrntVndrSeq() {
		return this.prntVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return lgsFlg
	 */
	public String getLgsFlg() {
		return this.lgsFlg;
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
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return teamFlg
	 */
	public String getTeamFlg() {
		return this.teamFlg;
	}
	
	/**
	 * Column Info
	 * @return vndrLoclLangNm
	 */
	public String getVndrLoclLangNm() {
		return this.vndrLoclLangNm;
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
	 * @return effectDt
	 */
	public String getEffectDt() {
		return this.effectDt;
	}
	
	/**
	 * Column Info
	 * @return woEdiUseFlg
	 */
	public String getWoEdiUseFlg() {
		return this.woEdiUseFlg;
	}
	
	/**
	 * Column Info
	 * @return luDeltFlg
	 */
	public String getLuDeltFlg() {
		return this.luDeltFlg;
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
	 * @return modiVndrSeq
	 */
	public String getModiVndrSeq() {
		return this.modiVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return mtyRroEdiUseFlg
	 */
	public String getMtyRroEdiUseFlg() {
		return this.mtyRroEdiUseFlg;
	}
	
	/**
	 * Column Info
	 * @return blkFlg
	 */
	public String getBlkFlg() {
		return this.blkFlg;
	}
	
	/**
	 * Column Info
	 * @return rfndPsdoCustCd
	 */
	public String getRfndPsdoCustCd() {
		return this.rfndPsdoCustCd;
	}
	
	/**
	 * Column Info
	 * @return cnlAgnFlg
	 */
	public String getCnlAgnFlg() {
		return this.cnlAgnFlg;
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
	 * @return blkVndrSvcCd
	 */
	public String getBlkVndrSvcCd() {
		return this.blkVndrSvcCd;
	}
	
	/**
	 * Column Info
	 * @return loclLangAddr
	 */
	public String getLoclLangAddr() {
		return this.loclLangAddr;
	}
	
	/**
	 * Column Info
	 * @return svcPrdRmk
	 */
	public String getSvcPrdRmk() {
		return this.svcPrdRmk;
	}
	
	/**
	 * Column Info
	 * @return genPayTermCd
	 */
	public String getGenPayTermCd() {
		return this.genPayTermCd;
	}
	
	/**
	 * Column Info
	 * @return cnlAgnBankDesc
	 */
	public String getCnlAgnBankDesc() {
		return this.cnlAgnBankDesc;
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
	 * @return invCurrCd
	 */
	public String getInvCurrCd() {
		return this.invCurrCd;
	}
	
	/**
	 * Column Info
	 * @return payCurrCd
	 */
	public String getPayCurrCd() {
		return this.payCurrCd;
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
	 * @return ceoNm
	 */
	public String getCeoNm() {
		return this.ceoNm;
	}
	
	/**
	 * Column Info
	 * @return chkDeSteCd
	 */
	public String getChkDeSteCd() {
		return this.chkDeSteCd;
	}
	
	/**
	 * Column Info
	 * @return woAtchFileFlg
	 */
	public String getWoAtchFileFlg() {
		return this.woAtchFileFlg;
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
	 * @param bzctNm
	 */
	public void setBzctNm(String bzctNm) {
		this.bzctNm = bzctNm;
	}
	
	/**
	 * Column Info
	 * @param chkDeCntCd
	 */
	public void setChkDeCntCd(String chkDeCntCd) {
		this.chkDeCntCd = chkDeCntCd;
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
	 * @param procuFlg
	 */
	public void setProcuFlg(String procuFlg) {
		this.procuFlg = procuFlg;
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
	 * @param chkDeZipCd
	 */
	public void setChkDeZipCd(String chkDeZipCd) {
		this.chkDeZipCd = chkDeZipCd;
	}
	
	/**
	 * Column Info
	 * @param otrFlg
	 */
	public void setOtrFlg(String otrFlg) {
		this.otrFlg = otrFlg;
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
	 * @param dcgoHndlFlg
	 */
	public void setDcgoHndlFlg(String dcgoHndlFlg) {
		this.dcgoHndlFlg = dcgoHndlFlg;
	}
	
	/**
	 * Column Info
	 * @param subsCoCd
	 */
	public void setSubsCoCd(String subsCoCd) {
		this.subsCoCd = subsCoCd;
	}
	
	/**
	 * Column Info
	 * @param interCoFlg
	 */
	public void setInterCoFlg(String interCoFlg) {
		this.interCoFlg = interCoFlg;
	}
	
	/**
	 * Column Info
	 * @param fletMgmtOwnrVndrSeq
	 */
	public void setFletMgmtOwnrVndrSeq(String fletMgmtOwnrVndrSeq) {
		this.fletMgmtOwnrVndrSeq = fletMgmtOwnrVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param chkDeAddr2
	 */
	public void setChkDeAddr2(String chkDeAddr2) {
		this.chkDeAddr2 = chkDeAddr2;
	}
	
	/**
	 * Column Info
	 * @param chkDeAddr3
	 */
	public void setChkDeAddr3(String chkDeAddr3) {
		this.chkDeAddr3 = chkDeAddr3;
	}
	
	/**
	 * Column Info
	 * @param chkDeAddr1
	 */
	public void setChkDeAddr1(String chkDeAddr1) {
		this.chkDeAddr1 = chkDeAddr1;
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
	 * @param chkDeCtyNm
	 */
	public void setChkDeCtyNm(String chkDeCtyNm) {
		this.chkDeCtyNm = chkDeCtyNm;
	}
	
	/**
	 * Column Info
	 * @param agmtRefNo
	 */
	public void setAgmtRefNo(String agmtRefNo) {
		this.agmtRefNo = agmtRefNo;
	}
	
	/**
	 * Column Info
	 * @param engAddr
	 */
	public void setEngAddr(String engAddr) {
		this.engAddr = engAddr;
	}
	
	/**
	 * Column Info
	 * @param vndrOfcCd
	 */
	public void setVndrOfcCd(String vndrOfcCd) {
		this.vndrOfcCd = vndrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param svcScpCdNm
	 */
	public void setSvcScpCdNm(String svcScpCdNm) {
		this.svcScpCdNm = svcScpCdNm;
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
	 * @param svcPrdTpNm
	 */
	public void setSvcPrdTpNm(String svcPrdTpNm) {
		this.svcPrdTpNm = svcPrdTpNm;
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
	 * @param taxId
	 */
	public void setTaxId(String taxId) {
		this.taxId = taxId;
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
	 * @param prntCntCd
	 */
	public void setPrntCntCd(String prntCntCd) {
		this.prntCntCd = prntCntCd;
	}
	
	/**
	 * Column Info
	 * @param zipCd
	 */
	public void setZipCd(String zipCd) {
		this.zipCd = zipCd;
	}
	
	/**
	 * Column Info
	 * @param usaEdiCd
	 */
	public void setUsaEdiCd(String usaEdiCd) {
		this.usaEdiCd = usaEdiCd;
	}
	
	/**
	 * Column Info
	 * @param fincFlg
	 */
	public void setFincFlg(String fincFlg) {
		this.fincFlg = fincFlg;
	}
	
	/**
	 * Column Info
	 * @param vndrAbbrNm
	 */
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param mnrDfltTrsmCd
	 */
	public void setMnrDfltTrsmCd(String mnrDfltTrsmCd) {
		this.mnrDfltTrsmCd = mnrDfltTrsmCd;
	}
	
	/**
	 * Column Info
	 * @param payTermTpCd
	 */
	public void setPayTermTpCd(String payTermTpCd) {
		this.payTermTpCd = payTermTpCd;
	}
	
	/**
	 * Column Info
	 * @param rgstNo
	 */
	public void setRgstNo(String rgstNo) {
		this.rgstNo = rgstNo;
	}
	
	/**
	 * Column Info
	 * @param invEdiUseFlg
	 */
	public void setInvEdiUseFlg(String invEdiUseFlg) {
		this.invEdiUseFlg = invEdiUseFlg;
	}
	
	/**
	 * Column Info
	 * @param prntVndrSeq
	 */
	public void setPrntVndrSeq(String prntVndrSeq) {
		this.prntVndrSeq = prntVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param lgsFlg
	 */
	public void setLgsFlg(String lgsFlg) {
		this.lgsFlg = lgsFlg;
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
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param teamFlg
	 */
	public void setTeamFlg(String teamFlg) {
		this.teamFlg = teamFlg;
	}
	
	/**
	 * Column Info
	 * @param vndrLoclLangNm
	 */
	public void setVndrLoclLangNm(String vndrLoclLangNm) {
		this.vndrLoclLangNm = vndrLoclLangNm;
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
	 * @param effectDt
	 */
	public void setEffectDt(String effectDt) {
		this.effectDt = effectDt;
	}
	
	/**
	 * Column Info
	 * @param woEdiUseFlg
	 */
	public void setWoEdiUseFlg(String woEdiUseFlg) {
		this.woEdiUseFlg = woEdiUseFlg;
	}
	
	/**
	 * Column Info
	 * @param luDeltFlg
	 */
	public void setLuDeltFlg(String luDeltFlg) {
		this.luDeltFlg = luDeltFlg;
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
	 * @param modiVndrSeq
	 */
	public void setModiVndrSeq(String modiVndrSeq) {
		this.modiVndrSeq = modiVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param mtyRroEdiUseFlg
	 */
	public void setMtyRroEdiUseFlg(String mtyRroEdiUseFlg) {
		this.mtyRroEdiUseFlg = mtyRroEdiUseFlg;
	}
	
	/**
	 * Column Info
	 * @param blkFlg
	 */
	public void setBlkFlg(String blkFlg) {
		this.blkFlg = blkFlg;
	}
	
	/**
	 * Column Info
	 * @param rfndPsdoCustCd
	 */
	public void setRfndPsdoCustCd(String rfndPsdoCustCd) {
		this.rfndPsdoCustCd = rfndPsdoCustCd;
	}
	
	/**
	 * Column Info
	 * @param cnlAgnFlg
	 */
	public void setCnlAgnFlg(String cnlAgnFlg) {
		this.cnlAgnFlg = cnlAgnFlg;
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
	 * @param blkVndrSvcCd
	 */
	public void setBlkVndrSvcCd(String blkVndrSvcCd) {
		this.blkVndrSvcCd = blkVndrSvcCd;
	}
	
	/**
	 * Column Info
	 * @param loclLangAddr
	 */
	public void setLoclLangAddr(String loclLangAddr) {
		this.loclLangAddr = loclLangAddr;
	}
	
	/**
	 * Column Info
	 * @param svcPrdRmk
	 */
	public void setSvcPrdRmk(String svcPrdRmk) {
		this.svcPrdRmk = svcPrdRmk;
	}
	
	/**
	 * Column Info
	 * @param genPayTermCd
	 */
	public void setGenPayTermCd(String genPayTermCd) {
		this.genPayTermCd = genPayTermCd;
	}
	
	/**
	 * Column Info
	 * @param cnlAgnBankDesc
	 */
	public void setCnlAgnBankDesc(String cnlAgnBankDesc) {
		this.cnlAgnBankDesc = cnlAgnBankDesc;
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
	 * @param invCurrCd
	 */
	public void setInvCurrCd(String invCurrCd) {
		this.invCurrCd = invCurrCd;
	}
	
	/**
	 * Column Info
	 * @param payCurrCd
	 */
	public void setPayCurrCd(String payCurrCd) {
		this.payCurrCd = payCurrCd;
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
	 * @param ceoNm
	 */
	public void setCeoNm(String ceoNm) {
		this.ceoNm = ceoNm;
	}
	
	/**
	 * Column Info
	 * @param chkDeSteCd
	 */
	public void setChkDeSteCd(String chkDeSteCd) {
		this.chkDeSteCd = chkDeSteCd;
	}
	
	/**
	 * Column Info
	 * @param woAtchFileFlg
	 */
	public void setWoAtchFileFlg(String woAtchFileFlg) {
		this.woAtchFileFlg = woAtchFileFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVndrCntCd(JSPUtil.getParameter(request, "vndr_cnt_cd", ""));
		setBzctNm(JSPUtil.getParameter(request, "bzct_nm", ""));
		setChkDeCntCd(JSPUtil.getParameter(request, "chk_de_cnt_cd", ""));
		setBztpNm(JSPUtil.getParameter(request, "bztp_nm", ""));
		setProcuFlg(JSPUtil.getParameter(request, "procu_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setChkDeZipCd(JSPUtil.getParameter(request, "chk_de_zip_cd", ""));
		setOtrFlg(JSPUtil.getParameter(request, "otr_flg", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setDcgoHndlFlg(JSPUtil.getParameter(request, "dcgo_hndl_flg", ""));
		setSubsCoCd(JSPUtil.getParameter(request, "subs_co_cd", ""));
		setInterCoFlg(JSPUtil.getParameter(request, "inter_co_flg", ""));
		setFletMgmtOwnrVndrSeq(JSPUtil.getParameter(request, "flet_mgmt_ownr_vndr_seq", ""));
		setChkDeAddr2(JSPUtil.getParameter(request, "chk_de_addr2", ""));
		setChkDeAddr3(JSPUtil.getParameter(request, "chk_de_addr3", ""));
		setChkDeAddr1(JSPUtil.getParameter(request, "chk_de_addr1", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setChkDeCtyNm(JSPUtil.getParameter(request, "chk_de_cty_nm", ""));
		setAgmtRefNo(JSPUtil.getParameter(request, "agmt_ref_no", ""));
		setEngAddr(JSPUtil.getParameter(request, "eng_addr", ""));
		setVndrOfcCd(JSPUtil.getParameter(request, "vndr_ofc_cd", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setSvcScpCdNm(JSPUtil.getParameter(request, "svc_scp_cd_nm", ""));
		setPayMzdCd(JSPUtil.getParameter(request, "pay_mzd_cd", ""));
		setSvcPrdTpNm(JSPUtil.getParameter(request, "svc_prd_tp_nm", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setTaxId(JSPUtil.getParameter(request, "tax_id", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setPrntCntCd(JSPUtil.getParameter(request, "prnt_cnt_cd", ""));
		setZipCd(JSPUtil.getParameter(request, "zip_cd", ""));
		setUsaEdiCd(JSPUtil.getParameter(request, "usa_edi_cd", ""));
		setFincFlg(JSPUtil.getParameter(request, "finc_flg", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, "vndr_abbr_nm", ""));
		setMnrDfltTrsmCd(JSPUtil.getParameter(request, "mnr_dflt_trsm_cd", ""));
		setPayTermTpCd(JSPUtil.getParameter(request, "pay_term_tp_cd", ""));
		setRgstNo(JSPUtil.getParameter(request, "rgst_no", ""));
		setInvEdiUseFlg(JSPUtil.getParameter(request, "inv_edi_use_flg", ""));
		setPrntVndrSeq(JSPUtil.getParameter(request, "prnt_vndr_seq", ""));
		setLgsFlg(JSPUtil.getParameter(request, "lgs_flg", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setTeamFlg(JSPUtil.getParameter(request, "team_flg", ""));
		setVndrLoclLangNm(JSPUtil.getParameter(request, "vndr_locl_lang_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffectDt(JSPUtil.getParameter(request, "effect_dt", ""));
		setWoEdiUseFlg(JSPUtil.getParameter(request, "wo_edi_use_flg", ""));
		setLuDeltFlg(JSPUtil.getParameter(request, "lu_delt_flg", ""));
		setCntcPsonNm(JSPUtil.getParameter(request, "cntc_pson_nm", ""));
		setModiVndrSeq(JSPUtil.getParameter(request, "modi_vndr_seq", ""));
		setMtyRroEdiUseFlg(JSPUtil.getParameter(request, "mty_rro_edi_use_flg", ""));
		setBlkFlg(JSPUtil.getParameter(request, "blk_flg", ""));
		setRfndPsdoCustCd(JSPUtil.getParameter(request, "rfnd_psdo_cust_cd", ""));
		setCnlAgnFlg(JSPUtil.getParameter(request, "cnl_agn_flg", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setBlkVndrSvcCd(JSPUtil.getParameter(request, "blk_vndr_svc_cd", ""));
		setLoclLangAddr(JSPUtil.getParameter(request, "locl_lang_addr", ""));
		setSvcPrdRmk(JSPUtil.getParameter(request, "svc_prd_rmk", ""));
		setGenPayTermCd(JSPUtil.getParameter(request, "gen_pay_term_cd", ""));
		setCnlAgnBankDesc(JSPUtil.getParameter(request, "cnl_agn_bank_desc", ""));
		setEaiEvntDt(JSPUtil.getParameter(request, "eai_evnt_dt", ""));
		setInvCurrCd(JSPUtil.getParameter(request, "inv_curr_cd", ""));
		setPayCurrCd(JSPUtil.getParameter(request, "pay_curr_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCeoNm(JSPUtil.getParameter(request, "ceo_nm", ""));
		setChkDeSteCd(JSPUtil.getParameter(request, "chk_de_ste_cd", ""));
		setWoAtchFileFlg(JSPUtil.getParameter(request, "wo_atch_file_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMdmVendorVO[]
	 */
	public CustomMdmVendorVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomMdmVendorVO[]
	 */
	public CustomMdmVendorVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMdmVendorVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vndrCntCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_cd", length));
			String[] bzctNm = (JSPUtil.getParameter(request, prefix	+ "bzct_nm", length));
			String[] chkDeCntCd = (JSPUtil.getParameter(request, prefix	+ "chk_de_cnt_cd", length));
			String[] bztpNm = (JSPUtil.getParameter(request, prefix	+ "bztp_nm", length));
			String[] procuFlg = (JSPUtil.getParameter(request, prefix	+ "procu_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] chkDeZipCd = (JSPUtil.getParameter(request, prefix	+ "chk_de_zip_cd", length));
			String[] otrFlg = (JSPUtil.getParameter(request, prefix	+ "otr_flg", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] dcgoHndlFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_hndl_flg", length));
			String[] subsCoCd = (JSPUtil.getParameter(request, prefix	+ "subs_co_cd", length));
			String[] interCoFlg = (JSPUtil.getParameter(request, prefix	+ "inter_co_flg", length));
			String[] fletMgmtOwnrVndrSeq = (JSPUtil.getParameter(request, prefix	+ "flet_mgmt_ownr_vndr_seq", length));
			String[] chkDeAddr2 = (JSPUtil.getParameter(request, prefix	+ "chk_de_addr2", length));
			String[] chkDeAddr3 = (JSPUtil.getParameter(request, prefix	+ "chk_de_addr3", length));
			String[] chkDeAddr1 = (JSPUtil.getParameter(request, prefix	+ "chk_de_addr1", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] chkDeCtyNm = (JSPUtil.getParameter(request, prefix	+ "chk_de_cty_nm", length));
			String[] agmtRefNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ref_no", length));
			String[] engAddr = (JSPUtil.getParameter(request, prefix	+ "eng_addr", length));
			String[] vndrOfcCd = (JSPUtil.getParameter(request, prefix	+ "vndr_ofc_cd", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] svcScpCdNm = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd_nm", length));
			String[] payMzdCd = (JSPUtil.getParameter(request, prefix	+ "pay_mzd_cd", length));
			String[] svcPrdTpNm = (JSPUtil.getParameter(request, prefix	+ "svc_prd_tp_nm", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] taxId = (JSPUtil.getParameter(request, prefix	+ "tax_id", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] prntCntCd = (JSPUtil.getParameter(request, prefix	+ "prnt_cnt_cd", length));
			String[] zipCd = (JSPUtil.getParameter(request, prefix	+ "zip_cd", length));
			String[] usaEdiCd = (JSPUtil.getParameter(request, prefix	+ "usa_edi_cd", length));
			String[] fincFlg = (JSPUtil.getParameter(request, prefix	+ "finc_flg", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] mnrDfltTrsmCd = (JSPUtil.getParameter(request, prefix	+ "mnr_dflt_trsm_cd", length));
			String[] payTermTpCd = (JSPUtil.getParameter(request, prefix	+ "pay_term_tp_cd", length));
			String[] rgstNo = (JSPUtil.getParameter(request, prefix	+ "rgst_no", length));
			String[] invEdiUseFlg = (JSPUtil.getParameter(request, prefix	+ "inv_edi_use_flg", length));
			String[] prntVndrSeq = (JSPUtil.getParameter(request, prefix	+ "prnt_vndr_seq", length));
			String[] lgsFlg = (JSPUtil.getParameter(request, prefix	+ "lgs_flg", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] teamFlg = (JSPUtil.getParameter(request, prefix	+ "team_flg", length));
			String[] vndrLoclLangNm = (JSPUtil.getParameter(request, prefix	+ "vndr_locl_lang_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effectDt = (JSPUtil.getParameter(request, prefix	+ "effect_dt", length));
			String[] woEdiUseFlg = (JSPUtil.getParameter(request, prefix	+ "wo_edi_use_flg", length));
			String[] luDeltFlg = (JSPUtil.getParameter(request, prefix	+ "lu_delt_flg", length));
			String[] cntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_nm", length));
			String[] modiVndrSeq = (JSPUtil.getParameter(request, prefix	+ "modi_vndr_seq", length));
			String[] mtyRroEdiUseFlg = (JSPUtil.getParameter(request, prefix	+ "mty_rro_edi_use_flg", length));
			String[] blkFlg = (JSPUtil.getParameter(request, prefix	+ "blk_flg", length));
			String[] rfndPsdoCustCd = (JSPUtil.getParameter(request, prefix	+ "rfnd_psdo_cust_cd", length));
			String[] cnlAgnFlg = (JSPUtil.getParameter(request, prefix	+ "cnl_agn_flg", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] blkVndrSvcCd = (JSPUtil.getParameter(request, prefix	+ "blk_vndr_svc_cd", length));
			String[] loclLangAddr = (JSPUtil.getParameter(request, prefix	+ "locl_lang_addr", length));
			String[] svcPrdRmk = (JSPUtil.getParameter(request, prefix	+ "svc_prd_rmk", length));
			String[] genPayTermCd = (JSPUtil.getParameter(request, prefix	+ "gen_pay_term_cd", length));
			String[] cnlAgnBankDesc = (JSPUtil.getParameter(request, prefix	+ "cnl_agn_bank_desc", length));
			String[] eaiEvntDt = (JSPUtil.getParameter(request, prefix	+ "eai_evnt_dt", length));
			String[] invCurrCd = (JSPUtil.getParameter(request, prefix	+ "inv_curr_cd", length));
			String[] payCurrCd = (JSPUtil.getParameter(request, prefix	+ "pay_curr_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ceoNm = (JSPUtil.getParameter(request, prefix	+ "ceo_nm", length));
			String[] chkDeSteCd = (JSPUtil.getParameter(request, prefix	+ "chk_de_ste_cd", length));
			String[] woAtchFileFlg = (JSPUtil.getParameter(request, prefix	+ "wo_atch_file_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMdmVendorVO();
				if (vndrCntCd[i] != null)
					model.setVndrCntCd(vndrCntCd[i]);
				if (bzctNm[i] != null)
					model.setBzctNm(bzctNm[i]);
				if (chkDeCntCd[i] != null)
					model.setChkDeCntCd(chkDeCntCd[i]);
				if (bztpNm[i] != null)
					model.setBztpNm(bztpNm[i]);
				if (procuFlg[i] != null)
					model.setProcuFlg(procuFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (chkDeZipCd[i] != null)
					model.setChkDeZipCd(chkDeZipCd[i]);
				if (otrFlg[i] != null)
					model.setOtrFlg(otrFlg[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (dcgoHndlFlg[i] != null)
					model.setDcgoHndlFlg(dcgoHndlFlg[i]);
				if (subsCoCd[i] != null)
					model.setSubsCoCd(subsCoCd[i]);
				if (interCoFlg[i] != null)
					model.setInterCoFlg(interCoFlg[i]);
				if (fletMgmtOwnrVndrSeq[i] != null)
					model.setFletMgmtOwnrVndrSeq(fletMgmtOwnrVndrSeq[i]);
				if (chkDeAddr2[i] != null)
					model.setChkDeAddr2(chkDeAddr2[i]);
				if (chkDeAddr3[i] != null)
					model.setChkDeAddr3(chkDeAddr3[i]);
				if (chkDeAddr1[i] != null)
					model.setChkDeAddr1(chkDeAddr1[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (chkDeCtyNm[i] != null)
					model.setChkDeCtyNm(chkDeCtyNm[i]);
				if (agmtRefNo[i] != null)
					model.setAgmtRefNo(agmtRefNo[i]);
				if (engAddr[i] != null)
					model.setEngAddr(engAddr[i]);
				if (vndrOfcCd[i] != null)
					model.setVndrOfcCd(vndrOfcCd[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (svcScpCdNm[i] != null)
					model.setSvcScpCdNm(svcScpCdNm[i]);
				if (payMzdCd[i] != null)
					model.setPayMzdCd(payMzdCd[i]);
				if (svcPrdTpNm[i] != null)
					model.setSvcPrdTpNm(svcPrdTpNm[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (taxId[i] != null)
					model.setTaxId(taxId[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (prntCntCd[i] != null)
					model.setPrntCntCd(prntCntCd[i]);
				if (zipCd[i] != null)
					model.setZipCd(zipCd[i]);
				if (usaEdiCd[i] != null)
					model.setUsaEdiCd(usaEdiCd[i]);
				if (fincFlg[i] != null)
					model.setFincFlg(fincFlg[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (mnrDfltTrsmCd[i] != null)
					model.setMnrDfltTrsmCd(mnrDfltTrsmCd[i]);
				if (payTermTpCd[i] != null)
					model.setPayTermTpCd(payTermTpCd[i]);
				if (rgstNo[i] != null)
					model.setRgstNo(rgstNo[i]);
				if (invEdiUseFlg[i] != null)
					model.setInvEdiUseFlg(invEdiUseFlg[i]);
				if (prntVndrSeq[i] != null)
					model.setPrntVndrSeq(prntVndrSeq[i]);
				if (lgsFlg[i] != null)
					model.setLgsFlg(lgsFlg[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (teamFlg[i] != null)
					model.setTeamFlg(teamFlg[i]);
				if (vndrLoclLangNm[i] != null)
					model.setVndrLoclLangNm(vndrLoclLangNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effectDt[i] != null)
					model.setEffectDt(effectDt[i]);
				if (woEdiUseFlg[i] != null)
					model.setWoEdiUseFlg(woEdiUseFlg[i]);
				if (luDeltFlg[i] != null)
					model.setLuDeltFlg(luDeltFlg[i]);
				if (cntcPsonNm[i] != null)
					model.setCntcPsonNm(cntcPsonNm[i]);
				if (modiVndrSeq[i] != null)
					model.setModiVndrSeq(modiVndrSeq[i]);
				if (mtyRroEdiUseFlg[i] != null)
					model.setMtyRroEdiUseFlg(mtyRroEdiUseFlg[i]);
				if (blkFlg[i] != null)
					model.setBlkFlg(blkFlg[i]);
				if (rfndPsdoCustCd[i] != null)
					model.setRfndPsdoCustCd(rfndPsdoCustCd[i]);
				if (cnlAgnFlg[i] != null)
					model.setCnlAgnFlg(cnlAgnFlg[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (blkVndrSvcCd[i] != null)
					model.setBlkVndrSvcCd(blkVndrSvcCd[i]);
				if (loclLangAddr[i] != null)
					model.setLoclLangAddr(loclLangAddr[i]);
				if (svcPrdRmk[i] != null)
					model.setSvcPrdRmk(svcPrdRmk[i]);
				if (genPayTermCd[i] != null)
					model.setGenPayTermCd(genPayTermCd[i]);
				if (cnlAgnBankDesc[i] != null)
					model.setCnlAgnBankDesc(cnlAgnBankDesc[i]);
				if (eaiEvntDt[i] != null)
					model.setEaiEvntDt(eaiEvntDt[i]);
				if (invCurrCd[i] != null)
					model.setInvCurrCd(invCurrCd[i]);
				if (payCurrCd[i] != null)
					model.setPayCurrCd(payCurrCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ceoNm[i] != null)
					model.setCeoNm(ceoNm[i]);
				if (chkDeSteCd[i] != null)
					model.setChkDeSteCd(chkDeSteCd[i]);
				if (woAtchFileFlg[i] != null)
					model.setWoAtchFileFlg(woAtchFileFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMdmVendorVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMdmVendorVO[]
	 */
	public CustomMdmVendorVO[] getCustomMdmVendorVOs(){
		CustomMdmVendorVO[] vos = (CustomMdmVendorVO[])models.toArray(new CustomMdmVendorVO[models.size()]);
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
		this.vndrCntCd = this.vndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzctNm = this.bzctNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkDeCntCd = this.chkDeCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bztpNm = this.bztpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.procuFlg = this.procuFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkDeZipCd = this.chkDeZipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrFlg = this.otrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoHndlFlg = this.dcgoHndlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subsCoCd = this.subsCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interCoFlg = this.interCoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletMgmtOwnrVndrSeq = this.fletMgmtOwnrVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkDeAddr2 = this.chkDeAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkDeAddr3 = this.chkDeAddr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkDeAddr1 = this.chkDeAddr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkDeCtyNm = this.chkDeCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRefNo = this.agmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.engAddr = this.engAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrOfcCd = this.vndrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCdNm = this.svcScpCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payMzdCd = this.payMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcPrdTpNm = this.svcPrdTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxId = this.taxId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prntCntCd = this.prntCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zipCd = this.zipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaEdiCd = this.usaEdiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincFlg = this.fincFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDfltTrsmCd = this.mnrDfltTrsmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTermTpCd = this.payTermTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstNo = this.rgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEdiUseFlg = this.invEdiUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prntVndrSeq = this.prntVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsFlg = this.lgsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teamFlg = this.teamFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLoclLangNm = this.vndrLoclLangNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effectDt = this.effectDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woEdiUseFlg = this.woEdiUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.luDeltFlg = this.luDeltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm = this.cntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiVndrSeq = this.modiVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyRroEdiUseFlg = this.mtyRroEdiUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkFlg = this.blkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfndPsdoCustCd = this.rfndPsdoCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnlAgnFlg = this.cnlAgnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkVndrSvcCd = this.blkVndrSvcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclLangAddr = this.loclLangAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcPrdRmk = this.svcPrdRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genPayTermCd = this.genPayTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnlAgnBankDesc = this.cnlAgnBankDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiEvntDt = this.eaiEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd = this.invCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payCurrCd = this.payCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ceoNm = this.ceoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkDeSteCd = this.chkDeSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woAtchFileFlg = this.woAtchFileFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
