/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BankAccountListVO.java
*@FileTitle : BankAccountListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.21
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014.04.21 차상영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo;

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
 * @author 차상영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BankAccountListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BankAccountListVO> models = new ArrayList<BankAccountListVO>();
	
	/* Column Info */
	private String apCtrlOfcCd = null;
	/* Column Info */
	private String gainCoaRgnCd = null;
	/* Column Info */
	private String chgCdCmbSeq = null;
	/* Column Info */
	private String lssCoaRgnCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String gainCoaInterCoCd = null;
	/* Column Info */
	private String bankNm = null;
	/* Column Info */
	private String asetCoaVvdCd = null;
	/* Column Info */
	private String lssCoaCoCd = null;
	/* Column Info */
	private String cntcAreaNm = null;
	/* Column Info */
	private String asetCoaCtrCd = null;
	/* Column Info */
	private String schBankAcctNo = null;
	/* Column Info */
	private String bankAcctDesc = null;
	/* Column Info */
	private String bankAcctSeq = null;
	/* Column Info */
	private String acctTypeL = null;
	/* Column Info */
	private String lssCoaAcctNo = null;
	/* Column Info */
	private String asetCdCmbSeq = null;
	/* Column Info */
	private String asetCoaAcctNo = null;
	/* Column Info */
	private String gainCoaAcctNo = null;
	/* Column Info */
	private String bankBrncSeq = null;
	/* Column Info */
	private String acctTypeM = null;
	/* Column Info */
	private String opnOfcCd = null;
	/* Column Info */
	private String bankBrncNm = null;
	/* Column Info */
	private String dpsDivCd = null;
	/* Column Info */
	private String lssCoaInterCoCd = null;
	/* Column Info */
	private String gainCoaVvdCd = null;
	/* Column Info */
	private String chgCoaInterCoCd = null;
	/* Column Info */
	private String chgCoaCtrCd = null;
	/* Column Info */
	private String mltCurrFlg = null;
	/* Column Info */
	private String gainCoaCoCd = null;
	/* Column Info */
	private String lssCoaVvdCd = null;
	/* Column Info */
	private String bankAcctNo = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String cntcPhnNo = null;
	/* Column Info */
	private String bankAcctTpMnCd = null;
	/* Column Info */
	private String inactDt = null;
	/* Column Info */
	private String attrCtnt1 = null;
	/* Column Info */
	private String attrCtnt2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String bankAcctAltnNm = null;
	/* Column Info */
	private String bankAcctStDt = null;
	/* Column Info */
	private String bankAcctTpSubCd = null;
	/* Column Info */
	private String gainCoaCtrCd = null;
	/* Column Info */
	private String bankAcctNm = null;
	/* Column Info */
	private String lssCdCmbSeq = null;
	/* Column Info */
	private String chgCoaVvdCd = null;
	/* Column Info */
	private String bankCateCd = null;
	/* Column Info */
	private String chgCoaCoCd = null;
	/* Column Info */
	private String cntcAreaCd = null;
	/* Column Info */
	private String asetCoaInterCoCd = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String chgCoaAcctNo = null;
	/* Column Info */
	private String bankAcctTpNm = null;
	/* Column Info */
	private String cntcTitNm = null;
	/* Column Info */
	private String chgCoaRgnCd = null;
	/* Column Info */
	private String gainCdCmbSeq = null;
	/* Column Info */
	private String lssCoaCtrCd = null;
	/* Column Info */
	private String asetCoaCoCd = null;
	/* Column Info */
	private String asetCoaRgnCd = null;
	/* Column Info */
	private String cntcNm = null;
	/* Column Info */
	private String acctTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BankAccountListVO() {}

	public BankAccountListVO(String ibflag, String pagerows, String bankNm, String bankBrncNm, String bankBrncSeq, String bankAcctSeq, String bankAcctNm, String bankAcctAltnNm, String bankAcctDesc, String bankAcctNo, String bankAcctTpNm, String bankAcctStDt, String inactDt, String acctTpCd, String currCd, String cntcNm, String attrCtnt1, String attrCtnt2, String cntcAreaCd, String cntcAreaNm, String cntcPhnNo, String mltCurrFlg, String bankAcctTpMnCd, String bankAcctTpSubCd, String bankCateCd, String asetCdCmbSeq, String chgCdCmbSeq, String gainCdCmbSeq, String lssCdCmbSeq, String opnOfcCd, String apCtrlOfcCd, String arOfcCd, String dpsDivCd, String cntcTitNm, String acctTypeL, String acctTypeM, String usrId, String schBankAcctNo, String asetCoaCoCd, String asetCoaRgnCd, String asetCoaCtrCd, String asetCoaAcctNo, String asetCoaInterCoCd, String asetCoaVvdCd, String chgCoaCoCd, String chgCoaRgnCd, String chgCoaCtrCd, String chgCoaAcctNo, String chgCoaInterCoCd, String chgCoaVvdCd, String gainCoaCoCd, String gainCoaRgnCd, String gainCoaCtrCd, String gainCoaAcctNo, String gainCoaInterCoCd, String gainCoaVvdCd, String lssCoaCoCd, String lssCoaRgnCd, String lssCoaCtrCd, String lssCoaAcctNo, String lssCoaInterCoCd, String lssCoaVvdCd) {
		this.apCtrlOfcCd = apCtrlOfcCd;
		this.gainCoaRgnCd = gainCoaRgnCd;
		this.chgCdCmbSeq = chgCdCmbSeq;
		this.lssCoaRgnCd = lssCoaRgnCd;
		this.pagerows = pagerows;
		this.gainCoaInterCoCd = gainCoaInterCoCd;
		this.bankNm = bankNm;
		this.asetCoaVvdCd = asetCoaVvdCd;
		this.lssCoaCoCd = lssCoaCoCd;
		this.cntcAreaNm = cntcAreaNm;
		this.asetCoaCtrCd = asetCoaCtrCd;
		this.schBankAcctNo = schBankAcctNo;
		this.bankAcctDesc = bankAcctDesc;
		this.bankAcctSeq = bankAcctSeq;
		this.acctTypeL = acctTypeL;
		this.lssCoaAcctNo = lssCoaAcctNo;
		this.asetCdCmbSeq = asetCdCmbSeq;
		this.asetCoaAcctNo = asetCoaAcctNo;
		this.gainCoaAcctNo = gainCoaAcctNo;
		this.bankBrncSeq = bankBrncSeq;
		this.acctTypeM = acctTypeM;
		this.opnOfcCd = opnOfcCd;
		this.bankBrncNm = bankBrncNm;
		this.dpsDivCd = dpsDivCd;
		this.lssCoaInterCoCd = lssCoaInterCoCd;
		this.gainCoaVvdCd = gainCoaVvdCd;
		this.chgCoaInterCoCd = chgCoaInterCoCd;
		this.chgCoaCtrCd = chgCoaCtrCd;
		this.mltCurrFlg = mltCurrFlg;
		this.gainCoaCoCd = gainCoaCoCd;
		this.lssCoaVvdCd = lssCoaVvdCd;
		this.bankAcctNo = bankAcctNo;
		this.currCd = currCd;
		this.cntcPhnNo = cntcPhnNo;
		this.bankAcctTpMnCd = bankAcctTpMnCd;
		this.inactDt = inactDt;
		this.attrCtnt1 = attrCtnt1;
		this.attrCtnt2 = attrCtnt2;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.bankAcctAltnNm = bankAcctAltnNm;
		this.bankAcctStDt = bankAcctStDt;
		this.bankAcctTpSubCd = bankAcctTpSubCd;
		this.gainCoaCtrCd = gainCoaCtrCd;
		this.bankAcctNm = bankAcctNm;
		this.lssCdCmbSeq = lssCdCmbSeq;
		this.chgCoaVvdCd = chgCoaVvdCd;
		this.bankCateCd = bankCateCd;
		this.chgCoaCoCd = chgCoaCoCd;
		this.cntcAreaCd = cntcAreaCd;
		this.asetCoaInterCoCd = asetCoaInterCoCd;
		this.arOfcCd = arOfcCd;
		this.chgCoaAcctNo = chgCoaAcctNo;
		this.bankAcctTpNm = bankAcctTpNm;
		this.cntcTitNm = cntcTitNm;
		this.chgCoaRgnCd = chgCoaRgnCd;
		this.gainCdCmbSeq = gainCdCmbSeq;
		this.lssCoaCtrCd = lssCoaCtrCd;
		this.asetCoaCoCd = asetCoaCoCd;
		this.asetCoaRgnCd = asetCoaRgnCd;
		this.cntcNm = cntcNm;
		this.acctTpCd = acctTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ap_ctrl_ofc_cd", getApCtrlOfcCd());
		this.hashColumns.put("gain_coa_rgn_cd", getGainCoaRgnCd());
		this.hashColumns.put("chg_cd_cmb_seq", getChgCdCmbSeq());
		this.hashColumns.put("lss_coa_rgn_cd", getLssCoaRgnCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("gain_coa_inter_co_cd", getGainCoaInterCoCd());
		this.hashColumns.put("bank_nm", getBankNm());
		this.hashColumns.put("aset_coa_vvd_cd", getAsetCoaVvdCd());
		this.hashColumns.put("lss_coa_co_cd", getLssCoaCoCd());
		this.hashColumns.put("cntc_area_nm", getCntcAreaNm());
		this.hashColumns.put("aset_coa_ctr_cd", getAsetCoaCtrCd());
		this.hashColumns.put("sch_bank_acct_no", getSchBankAcctNo());
		this.hashColumns.put("bank_acct_desc", getBankAcctDesc());
		this.hashColumns.put("bank_acct_seq", getBankAcctSeq());
		this.hashColumns.put("acct_type_l", getAcctTypeL());
		this.hashColumns.put("lss_coa_acct_no", getLssCoaAcctNo());
		this.hashColumns.put("aset_cd_cmb_seq", getAsetCdCmbSeq());
		this.hashColumns.put("aset_coa_acct_no", getAsetCoaAcctNo());
		this.hashColumns.put("gain_coa_acct_no", getGainCoaAcctNo());
		this.hashColumns.put("bank_brnc_seq", getBankBrncSeq());
		this.hashColumns.put("acct_type_m", getAcctTypeM());
		this.hashColumns.put("opn_ofc_cd", getOpnOfcCd());
		this.hashColumns.put("bank_brnc_nm", getBankBrncNm());
		this.hashColumns.put("dps_div_cd", getDpsDivCd());
		this.hashColumns.put("lss_coa_inter_co_cd", getLssCoaInterCoCd());
		this.hashColumns.put("gain_coa_vvd_cd", getGainCoaVvdCd());
		this.hashColumns.put("chg_coa_inter_co_cd", getChgCoaInterCoCd());
		this.hashColumns.put("chg_coa_ctr_cd", getChgCoaCtrCd());
		this.hashColumns.put("mlt_curr_flg", getMltCurrFlg());
		this.hashColumns.put("gain_coa_co_cd", getGainCoaCoCd());
		this.hashColumns.put("lss_coa_vvd_cd", getLssCoaVvdCd());
		this.hashColumns.put("bank_acct_no", getBankAcctNo());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cntc_phn_no", getCntcPhnNo());
		this.hashColumns.put("bank_acct_tp_mn_cd", getBankAcctTpMnCd());
		this.hashColumns.put("inact_dt", getInactDt());
		this.hashColumns.put("attr_ctnt1", getAttrCtnt1());
		this.hashColumns.put("attr_ctnt2", getAttrCtnt2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("bank_acct_altn_nm", getBankAcctAltnNm());
		this.hashColumns.put("bank_acct_st_dt", getBankAcctStDt());
		this.hashColumns.put("bank_acct_tp_sub_cd", getBankAcctTpSubCd());
		this.hashColumns.put("gain_coa_ctr_cd", getGainCoaCtrCd());
		this.hashColumns.put("bank_acct_nm", getBankAcctNm());
		this.hashColumns.put("lss_cd_cmb_seq", getLssCdCmbSeq());
		this.hashColumns.put("chg_coa_vvd_cd", getChgCoaVvdCd());
		this.hashColumns.put("bank_cate_cd", getBankCateCd());
		this.hashColumns.put("chg_coa_co_cd", getChgCoaCoCd());
		this.hashColumns.put("cntc_area_cd", getCntcAreaCd());
		this.hashColumns.put("aset_coa_inter_co_cd", getAsetCoaInterCoCd());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("chg_coa_acct_no", getChgCoaAcctNo());
		this.hashColumns.put("bank_acct_tp_nm", getBankAcctTpNm());
		this.hashColumns.put("cntc_tit_nm", getCntcTitNm());
		this.hashColumns.put("chg_coa_rgn_cd", getChgCoaRgnCd());
		this.hashColumns.put("gain_cd_cmb_seq", getGainCdCmbSeq());
		this.hashColumns.put("lss_coa_ctr_cd", getLssCoaCtrCd());
		this.hashColumns.put("aset_coa_co_cd", getAsetCoaCoCd());
		this.hashColumns.put("aset_coa_rgn_cd", getAsetCoaRgnCd());
		this.hashColumns.put("cntc_nm", getCntcNm());
		this.hashColumns.put("acct_tp_cd", getAcctTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ap_ctrl_ofc_cd", "apCtrlOfcCd");
		this.hashFields.put("gain_coa_rgn_cd", "gainCoaRgnCd");
		this.hashFields.put("chg_cd_cmb_seq", "chgCdCmbSeq");
		this.hashFields.put("lss_coa_rgn_cd", "lssCoaRgnCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("gain_coa_inter_co_cd", "gainCoaInterCoCd");
		this.hashFields.put("bank_nm", "bankNm");
		this.hashFields.put("aset_coa_vvd_cd", "asetCoaVvdCd");
		this.hashFields.put("lss_coa_co_cd", "lssCoaCoCd");
		this.hashFields.put("cntc_area_nm", "cntcAreaNm");
		this.hashFields.put("aset_coa_ctr_cd", "asetCoaCtrCd");
		this.hashFields.put("sch_bank_acct_no", "schBankAcctNo");
		this.hashFields.put("bank_acct_desc", "bankAcctDesc");
		this.hashFields.put("bank_acct_seq", "bankAcctSeq");
		this.hashFields.put("acct_type_l", "acctTypeL");
		this.hashFields.put("lss_coa_acct_no", "lssCoaAcctNo");
		this.hashFields.put("aset_cd_cmb_seq", "asetCdCmbSeq");
		this.hashFields.put("aset_coa_acct_no", "asetCoaAcctNo");
		this.hashFields.put("gain_coa_acct_no", "gainCoaAcctNo");
		this.hashFields.put("bank_brnc_seq", "bankBrncSeq");
		this.hashFields.put("acct_type_m", "acctTypeM");
		this.hashFields.put("opn_ofc_cd", "opnOfcCd");
		this.hashFields.put("bank_brnc_nm", "bankBrncNm");
		this.hashFields.put("dps_div_cd", "dpsDivCd");
		this.hashFields.put("lss_coa_inter_co_cd", "lssCoaInterCoCd");
		this.hashFields.put("gain_coa_vvd_cd", "gainCoaVvdCd");
		this.hashFields.put("chg_coa_inter_co_cd", "chgCoaInterCoCd");
		this.hashFields.put("chg_coa_ctr_cd", "chgCoaCtrCd");
		this.hashFields.put("mlt_curr_flg", "mltCurrFlg");
		this.hashFields.put("gain_coa_co_cd", "gainCoaCoCd");
		this.hashFields.put("lss_coa_vvd_cd", "lssCoaVvdCd");
		this.hashFields.put("bank_acct_no", "bankAcctNo");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cntc_phn_no", "cntcPhnNo");
		this.hashFields.put("bank_acct_tp_mn_cd", "bankAcctTpMnCd");
		this.hashFields.put("inact_dt", "inactDt");
		this.hashFields.put("attr_ctnt1", "attrCtnt1");
		this.hashFields.put("attr_ctnt2", "attrCtnt2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("bank_acct_altn_nm", "bankAcctAltnNm");
		this.hashFields.put("bank_acct_st_dt", "bankAcctStDt");
		this.hashFields.put("bank_acct_tp_sub_cd", "bankAcctTpSubCd");
		this.hashFields.put("gain_coa_ctr_cd", "gainCoaCtrCd");
		this.hashFields.put("bank_acct_nm", "bankAcctNm");
		this.hashFields.put("lss_cd_cmb_seq", "lssCdCmbSeq");
		this.hashFields.put("chg_coa_vvd_cd", "chgCoaVvdCd");
		this.hashFields.put("bank_cate_cd", "bankCateCd");
		this.hashFields.put("chg_coa_co_cd", "chgCoaCoCd");
		this.hashFields.put("cntc_area_cd", "cntcAreaCd");
		this.hashFields.put("aset_coa_inter_co_cd", "asetCoaInterCoCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("chg_coa_acct_no", "chgCoaAcctNo");
		this.hashFields.put("bank_acct_tp_nm", "bankAcctTpNm");
		this.hashFields.put("cntc_tit_nm", "cntcTitNm");
		this.hashFields.put("chg_coa_rgn_cd", "chgCoaRgnCd");
		this.hashFields.put("gain_cd_cmb_seq", "gainCdCmbSeq");
		this.hashFields.put("lss_coa_ctr_cd", "lssCoaCtrCd");
		this.hashFields.put("aset_coa_co_cd", "asetCoaCoCd");
		this.hashFields.put("aset_coa_rgn_cd", "asetCoaRgnCd");
		this.hashFields.put("cntc_nm", "cntcNm");
		this.hashFields.put("acct_tp_cd", "acctTpCd");
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
	 * @return gainCoaRgnCd
	 */
	public String getGainCoaRgnCd() {
		return this.gainCoaRgnCd;
	}
	
	/**
	 * Column Info
	 * @return chgCdCmbSeq
	 */
	public String getChgCdCmbSeq() {
		return this.chgCdCmbSeq;
	}
	
	/**
	 * Column Info
	 * @return lssCoaRgnCd
	 */
	public String getLssCoaRgnCd() {
		return this.lssCoaRgnCd;
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
	 * @return gainCoaInterCoCd
	 */
	public String getGainCoaInterCoCd() {
		return this.gainCoaInterCoCd;
	}
	
	/**
	 * Column Info
	 * @return bankNm
	 */
	public String getBankNm() {
		return this.bankNm;
	}
	
	/**
	 * Column Info
	 * @return asetCoaVvdCd
	 */
	public String getAsetCoaVvdCd() {
		return this.asetCoaVvdCd;
	}
	
	/**
	 * Column Info
	 * @return lssCoaCoCd
	 */
	public String getLssCoaCoCd() {
		return this.lssCoaCoCd;
	}
	
	/**
	 * Column Info
	 * @return cntcAreaNm
	 */
	public String getCntcAreaNm() {
		return this.cntcAreaNm;
	}
	
	/**
	 * Column Info
	 * @return asetCoaCtrCd
	 */
	public String getAsetCoaCtrCd() {
		return this.asetCoaCtrCd;
	}
	
	/**
	 * Column Info
	 * @return schBankAcctNo
	 */
	public String getSchBankAcctNo() {
		return this.schBankAcctNo;
	}
	
	/**
	 * Column Info
	 * @return bankAcctDesc
	 */
	public String getBankAcctDesc() {
		return this.bankAcctDesc;
	}
	
	/**
	 * Column Info
	 * @return bankAcctSeq
	 */
	public String getBankAcctSeq() {
		return this.bankAcctSeq;
	}
	
	/**
	 * Column Info
	 * @return acctTypeL
	 */
	public String getAcctTypeL() {
		return this.acctTypeL;
	}
	
	/**
	 * Column Info
	 * @return lssCoaAcctNo
	 */
	public String getLssCoaAcctNo() {
		return this.lssCoaAcctNo;
	}
	
	/**
	 * Column Info
	 * @return asetCdCmbSeq
	 */
	public String getAsetCdCmbSeq() {
		return this.asetCdCmbSeq;
	}
	
	/**
	 * Column Info
	 * @return asetCoaAcctNo
	 */
	public String getAsetCoaAcctNo() {
		return this.asetCoaAcctNo;
	}
	
	/**
	 * Column Info
	 * @return gainCoaAcctNo
	 */
	public String getGainCoaAcctNo() {
		return this.gainCoaAcctNo;
	}
	
	/**
	 * Column Info
	 * @return bankBrncSeq
	 */
	public String getBankBrncSeq() {
		return this.bankBrncSeq;
	}
	
	/**
	 * Column Info
	 * @return acctTypeM
	 */
	public String getAcctTypeM() {
		return this.acctTypeM;
	}
	
	/**
	 * Column Info
	 * @return opnOfcCd
	 */
	public String getOpnOfcCd() {
		return this.opnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return bankBrncNm
	 */
	public String getBankBrncNm() {
		return this.bankBrncNm;
	}
	
	/**
	 * Column Info
	 * @return dpsDivCd
	 */
	public String getDpsDivCd() {
		return this.dpsDivCd;
	}
	
	/**
	 * Column Info
	 * @return lssCoaInterCoCd
	 */
	public String getLssCoaInterCoCd() {
		return this.lssCoaInterCoCd;
	}
	
	/**
	 * Column Info
	 * @return gainCoaVvdCd
	 */
	public String getGainCoaVvdCd() {
		return this.gainCoaVvdCd;
	}
	
	/**
	 * Column Info
	 * @return chgCoaInterCoCd
	 */
	public String getChgCoaInterCoCd() {
		return this.chgCoaInterCoCd;
	}
	
	/**
	 * Column Info
	 * @return chgCoaCtrCd
	 */
	public String getChgCoaCtrCd() {
		return this.chgCoaCtrCd;
	}
	
	/**
	 * Column Info
	 * @return mltCurrFlg
	 */
	public String getMltCurrFlg() {
		return this.mltCurrFlg;
	}
	
	/**
	 * Column Info
	 * @return gainCoaCoCd
	 */
	public String getGainCoaCoCd() {
		return this.gainCoaCoCd;
	}
	
	/**
	 * Column Info
	 * @return lssCoaVvdCd
	 */
	public String getLssCoaVvdCd() {
		return this.lssCoaVvdCd;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return cntcPhnNo
	 */
	public String getCntcPhnNo() {
		return this.cntcPhnNo;
	}
	
	/**
	 * Column Info
	 * @return bankAcctTpMnCd
	 */
	public String getBankAcctTpMnCd() {
		return this.bankAcctTpMnCd;
	}
	
	/**
	 * Column Info
	 * @return inactDt
	 */
	public String getInactDt() {
		return this.inactDt;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt1
	 */
	public String getAttrCtnt1() {
		return this.attrCtnt1;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt2
	 */
	public String getAttrCtnt2() {
		return this.attrCtnt2;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return bankAcctAltnNm
	 */
	public String getBankAcctAltnNm() {
		return this.bankAcctAltnNm;
	}
	
	/**
	 * Column Info
	 * @return bankAcctStDt
	 */
	public String getBankAcctStDt() {
		return this.bankAcctStDt;
	}
	
	/**
	 * Column Info
	 * @return bankAcctTpSubCd
	 */
	public String getBankAcctTpSubCd() {
		return this.bankAcctTpSubCd;
	}
	
	/**
	 * Column Info
	 * @return gainCoaCtrCd
	 */
	public String getGainCoaCtrCd() {
		return this.gainCoaCtrCd;
	}
	
	/**
	 * Column Info
	 * @return bankAcctNm
	 */
	public String getBankAcctNm() {
		return this.bankAcctNm;
	}
	
	/**
	 * Column Info
	 * @return lssCdCmbSeq
	 */
	public String getLssCdCmbSeq() {
		return this.lssCdCmbSeq;
	}
	
	/**
	 * Column Info
	 * @return chgCoaVvdCd
	 */
	public String getChgCoaVvdCd() {
		return this.chgCoaVvdCd;
	}
	
	/**
	 * Column Info
	 * @return bankCateCd
	 */
	public String getBankCateCd() {
		return this.bankCateCd;
	}
	
	/**
	 * Column Info
	 * @return chgCoaCoCd
	 */
	public String getChgCoaCoCd() {
		return this.chgCoaCoCd;
	}
	
	/**
	 * Column Info
	 * @return cntcAreaCd
	 */
	public String getCntcAreaCd() {
		return this.cntcAreaCd;
	}
	
	/**
	 * Column Info
	 * @return asetCoaInterCoCd
	 */
	public String getAsetCoaInterCoCd() {
		return this.asetCoaInterCoCd;
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
	 * @return chgCoaAcctNo
	 */
	public String getChgCoaAcctNo() {
		return this.chgCoaAcctNo;
	}
	
	/**
	 * Column Info
	 * @return bankAcctTpNm
	 */
	public String getBankAcctTpNm() {
		return this.bankAcctTpNm;
	}
	
	/**
	 * Column Info
	 * @return cntcTitNm
	 */
	public String getCntcTitNm() {
		return this.cntcTitNm;
	}
	
	/**
	 * Column Info
	 * @return chgCoaRgnCd
	 */
	public String getChgCoaRgnCd() {
		return this.chgCoaRgnCd;
	}
	
	/**
	 * Column Info
	 * @return gainCdCmbSeq
	 */
	public String getGainCdCmbSeq() {
		return this.gainCdCmbSeq;
	}
	
	/**
	 * Column Info
	 * @return lssCoaCtrCd
	 */
	public String getLssCoaCtrCd() {
		return this.lssCoaCtrCd;
	}
	
	/**
	 * Column Info
	 * @return asetCoaCoCd
	 */
	public String getAsetCoaCoCd() {
		return this.asetCoaCoCd;
	}
	
	/**
	 * Column Info
	 * @return asetCoaRgnCd
	 */
	public String getAsetCoaRgnCd() {
		return this.asetCoaRgnCd;
	}
	
	/**
	 * Column Info
	 * @return cntcNm
	 */
	public String getCntcNm() {
		return this.cntcNm;
	}
	
	/**
	 * Column Info
	 * @return acctTpCd
	 */
	public String getAcctTpCd() {
		return this.acctTpCd;
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
	 * @param gainCoaRgnCd
	 */
	public void setGainCoaRgnCd(String gainCoaRgnCd) {
		this.gainCoaRgnCd = gainCoaRgnCd;
	}
	
	/**
	 * Column Info
	 * @param chgCdCmbSeq
	 */
	public void setChgCdCmbSeq(String chgCdCmbSeq) {
		this.chgCdCmbSeq = chgCdCmbSeq;
	}
	
	/**
	 * Column Info
	 * @param lssCoaRgnCd
	 */
	public void setLssCoaRgnCd(String lssCoaRgnCd) {
		this.lssCoaRgnCd = lssCoaRgnCd;
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
	 * @param gainCoaInterCoCd
	 */
	public void setGainCoaInterCoCd(String gainCoaInterCoCd) {
		this.gainCoaInterCoCd = gainCoaInterCoCd;
	}
	
	/**
	 * Column Info
	 * @param bankNm
	 */
	public void setBankNm(String bankNm) {
		this.bankNm = bankNm;
	}
	
	/**
	 * Column Info
	 * @param asetCoaVvdCd
	 */
	public void setAsetCoaVvdCd(String asetCoaVvdCd) {
		this.asetCoaVvdCd = asetCoaVvdCd;
	}
	
	/**
	 * Column Info
	 * @param lssCoaCoCd
	 */
	public void setLssCoaCoCd(String lssCoaCoCd) {
		this.lssCoaCoCd = lssCoaCoCd;
	}
	
	/**
	 * Column Info
	 * @param cntcAreaNm
	 */
	public void setCntcAreaNm(String cntcAreaNm) {
		this.cntcAreaNm = cntcAreaNm;
	}
	
	/**
	 * Column Info
	 * @param asetCoaCtrCd
	 */
	public void setAsetCoaCtrCd(String asetCoaCtrCd) {
		this.asetCoaCtrCd = asetCoaCtrCd;
	}
	
	/**
	 * Column Info
	 * @param schBankAcctNo
	 */
	public void setSchBankAcctNo(String schBankAcctNo) {
		this.schBankAcctNo = schBankAcctNo;
	}
	
	/**
	 * Column Info
	 * @param bankAcctDesc
	 */
	public void setBankAcctDesc(String bankAcctDesc) {
		this.bankAcctDesc = bankAcctDesc;
	}
	
	/**
	 * Column Info
	 * @param bankAcctSeq
	 */
	public void setBankAcctSeq(String bankAcctSeq) {
		this.bankAcctSeq = bankAcctSeq;
	}
	
	/**
	 * Column Info
	 * @param acctTypeL
	 */
	public void setAcctTypeL(String acctTypeL) {
		this.acctTypeL = acctTypeL;
	}
	
	/**
	 * Column Info
	 * @param lssCoaAcctNo
	 */
	public void setLssCoaAcctNo(String lssCoaAcctNo) {
		this.lssCoaAcctNo = lssCoaAcctNo;
	}
	
	/**
	 * Column Info
	 * @param asetCdCmbSeq
	 */
	public void setAsetCdCmbSeq(String asetCdCmbSeq) {
		this.asetCdCmbSeq = asetCdCmbSeq;
	}
	
	/**
	 * Column Info
	 * @param asetCoaAcctNo
	 */
	public void setAsetCoaAcctNo(String asetCoaAcctNo) {
		this.asetCoaAcctNo = asetCoaAcctNo;
	}
	
	/**
	 * Column Info
	 * @param gainCoaAcctNo
	 */
	public void setGainCoaAcctNo(String gainCoaAcctNo) {
		this.gainCoaAcctNo = gainCoaAcctNo;
	}
	
	/**
	 * Column Info
	 * @param bankBrncSeq
	 */
	public void setBankBrncSeq(String bankBrncSeq) {
		this.bankBrncSeq = bankBrncSeq;
	}
	
	/**
	 * Column Info
	 * @param acctTypeM
	 */
	public void setAcctTypeM(String acctTypeM) {
		this.acctTypeM = acctTypeM;
	}
	
	/**
	 * Column Info
	 * @param opnOfcCd
	 */
	public void setOpnOfcCd(String opnOfcCd) {
		this.opnOfcCd = opnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param bankBrncNm
	 */
	public void setBankBrncNm(String bankBrncNm) {
		this.bankBrncNm = bankBrncNm;
	}
	
	/**
	 * Column Info
	 * @param dpsDivCd
	 */
	public void setDpsDivCd(String dpsDivCd) {
		this.dpsDivCd = dpsDivCd;
	}
	
	/**
	 * Column Info
	 * @param lssCoaInterCoCd
	 */
	public void setLssCoaInterCoCd(String lssCoaInterCoCd) {
		this.lssCoaInterCoCd = lssCoaInterCoCd;
	}
	
	/**
	 * Column Info
	 * @param gainCoaVvdCd
	 */
	public void setGainCoaVvdCd(String gainCoaVvdCd) {
		this.gainCoaVvdCd = gainCoaVvdCd;
	}
	
	/**
	 * Column Info
	 * @param chgCoaInterCoCd
	 */
	public void setChgCoaInterCoCd(String chgCoaInterCoCd) {
		this.chgCoaInterCoCd = chgCoaInterCoCd;
	}
	
	/**
	 * Column Info
	 * @param chgCoaCtrCd
	 */
	public void setChgCoaCtrCd(String chgCoaCtrCd) {
		this.chgCoaCtrCd = chgCoaCtrCd;
	}
	
	/**
	 * Column Info
	 * @param mltCurrFlg
	 */
	public void setMltCurrFlg(String mltCurrFlg) {
		this.mltCurrFlg = mltCurrFlg;
	}
	
	/**
	 * Column Info
	 * @param gainCoaCoCd
	 */
	public void setGainCoaCoCd(String gainCoaCoCd) {
		this.gainCoaCoCd = gainCoaCoCd;
	}
	
	/**
	 * Column Info
	 * @param lssCoaVvdCd
	 */
	public void setLssCoaVvdCd(String lssCoaVvdCd) {
		this.lssCoaVvdCd = lssCoaVvdCd;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param cntcPhnNo
	 */
	public void setCntcPhnNo(String cntcPhnNo) {
		this.cntcPhnNo = cntcPhnNo;
	}
	
	/**
	 * Column Info
	 * @param bankAcctTpMnCd
	 */
	public void setBankAcctTpMnCd(String bankAcctTpMnCd) {
		this.bankAcctTpMnCd = bankAcctTpMnCd;
	}
	
	/**
	 * Column Info
	 * @param inactDt
	 */
	public void setInactDt(String inactDt) {
		this.inactDt = inactDt;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt1
	 */
	public void setAttrCtnt1(String attrCtnt1) {
		this.attrCtnt1 = attrCtnt1;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt2
	 */
	public void setAttrCtnt2(String attrCtnt2) {
		this.attrCtnt2 = attrCtnt2;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param bankAcctAltnNm
	 */
	public void setBankAcctAltnNm(String bankAcctAltnNm) {
		this.bankAcctAltnNm = bankAcctAltnNm;
	}
	
	/**
	 * Column Info
	 * @param bankAcctStDt
	 */
	public void setBankAcctStDt(String bankAcctStDt) {
		this.bankAcctStDt = bankAcctStDt;
	}
	
	/**
	 * Column Info
	 * @param bankAcctTpSubCd
	 */
	public void setBankAcctTpSubCd(String bankAcctTpSubCd) {
		this.bankAcctTpSubCd = bankAcctTpSubCd;
	}
	
	/**
	 * Column Info
	 * @param gainCoaCtrCd
	 */
	public void setGainCoaCtrCd(String gainCoaCtrCd) {
		this.gainCoaCtrCd = gainCoaCtrCd;
	}
	
	/**
	 * Column Info
	 * @param bankAcctNm
	 */
	public void setBankAcctNm(String bankAcctNm) {
		this.bankAcctNm = bankAcctNm;
	}
	
	/**
	 * Column Info
	 * @param lssCdCmbSeq
	 */
	public void setLssCdCmbSeq(String lssCdCmbSeq) {
		this.lssCdCmbSeq = lssCdCmbSeq;
	}
	
	/**
	 * Column Info
	 * @param chgCoaVvdCd
	 */
	public void setChgCoaVvdCd(String chgCoaVvdCd) {
		this.chgCoaVvdCd = chgCoaVvdCd;
	}
	
	/**
	 * Column Info
	 * @param bankCateCd
	 */
	public void setBankCateCd(String bankCateCd) {
		this.bankCateCd = bankCateCd;
	}
	
	/**
	 * Column Info
	 * @param chgCoaCoCd
	 */
	public void setChgCoaCoCd(String chgCoaCoCd) {
		this.chgCoaCoCd = chgCoaCoCd;
	}
	
	/**
	 * Column Info
	 * @param cntcAreaCd
	 */
	public void setCntcAreaCd(String cntcAreaCd) {
		this.cntcAreaCd = cntcAreaCd;
	}
	
	/**
	 * Column Info
	 * @param asetCoaInterCoCd
	 */
	public void setAsetCoaInterCoCd(String asetCoaInterCoCd) {
		this.asetCoaInterCoCd = asetCoaInterCoCd;
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
	 * @param chgCoaAcctNo
	 */
	public void setChgCoaAcctNo(String chgCoaAcctNo) {
		this.chgCoaAcctNo = chgCoaAcctNo;
	}
	
	/**
	 * Column Info
	 * @param bankAcctTpNm
	 */
	public void setBankAcctTpNm(String bankAcctTpNm) {
		this.bankAcctTpNm = bankAcctTpNm;
	}
	
	/**
	 * Column Info
	 * @param cntcTitNm
	 */
	public void setCntcTitNm(String cntcTitNm) {
		this.cntcTitNm = cntcTitNm;
	}
	
	/**
	 * Column Info
	 * @param chgCoaRgnCd
	 */
	public void setChgCoaRgnCd(String chgCoaRgnCd) {
		this.chgCoaRgnCd = chgCoaRgnCd;
	}
	
	/**
	 * Column Info
	 * @param gainCdCmbSeq
	 */
	public void setGainCdCmbSeq(String gainCdCmbSeq) {
		this.gainCdCmbSeq = gainCdCmbSeq;
	}
	
	/**
	 * Column Info
	 * @param lssCoaCtrCd
	 */
	public void setLssCoaCtrCd(String lssCoaCtrCd) {
		this.lssCoaCtrCd = lssCoaCtrCd;
	}
	
	/**
	 * Column Info
	 * @param asetCoaCoCd
	 */
	public void setAsetCoaCoCd(String asetCoaCoCd) {
		this.asetCoaCoCd = asetCoaCoCd;
	}
	
	/**
	 * Column Info
	 * @param asetCoaRgnCd
	 */
	public void setAsetCoaRgnCd(String asetCoaRgnCd) {
		this.asetCoaRgnCd = asetCoaRgnCd;
	}
	
	/**
	 * Column Info
	 * @param cntcNm
	 */
	public void setCntcNm(String cntcNm) {
		this.cntcNm = cntcNm;
	}
	
	/**
	 * Column Info
	 * @param acctTpCd
	 */
	public void setAcctTpCd(String acctTpCd) {
		this.acctTpCd = acctTpCd;
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
		setGainCoaRgnCd(JSPUtil.getParameter(request, prefix + "gain_coa_rgn_cd", ""));
		setChgCdCmbSeq(JSPUtil.getParameter(request, prefix + "chg_cd_cmb_seq", ""));
		setLssCoaRgnCd(JSPUtil.getParameter(request, prefix + "lss_coa_rgn_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setGainCoaInterCoCd(JSPUtil.getParameter(request, prefix + "gain_coa_inter_co_cd", ""));
		setBankNm(JSPUtil.getParameter(request, prefix + "bank_nm", ""));
		setAsetCoaVvdCd(JSPUtil.getParameter(request, prefix + "aset_coa_vvd_cd", ""));
		setLssCoaCoCd(JSPUtil.getParameter(request, prefix + "lss_coa_co_cd", ""));
		setCntcAreaNm(JSPUtil.getParameter(request, prefix + "cntc_area_nm", ""));
		setAsetCoaCtrCd(JSPUtil.getParameter(request, prefix + "aset_coa_ctr_cd", ""));
		setSchBankAcctNo(JSPUtil.getParameter(request, prefix + "sch_bank_acct_no", ""));
		setBankAcctDesc(JSPUtil.getParameter(request, prefix + "bank_acct_desc", ""));
		setBankAcctSeq(JSPUtil.getParameter(request, prefix + "bank_acct_seq", ""));
		setAcctTypeL(JSPUtil.getParameter(request, prefix + "acct_type_l", ""));
		setLssCoaAcctNo(JSPUtil.getParameter(request, prefix + "lss_coa_acct_no", ""));
		setAsetCdCmbSeq(JSPUtil.getParameter(request, prefix + "aset_cd_cmb_seq", ""));
		setAsetCoaAcctNo(JSPUtil.getParameter(request, prefix + "aset_coa_acct_no", ""));
		setGainCoaAcctNo(JSPUtil.getParameter(request, prefix + "gain_coa_acct_no", ""));
		setBankBrncSeq(JSPUtil.getParameter(request, prefix + "bank_brnc_seq", ""));
		setAcctTypeM(JSPUtil.getParameter(request, prefix + "acct_type_m", ""));
		setOpnOfcCd(JSPUtil.getParameter(request, prefix + "opn_ofc_cd", ""));
		setBankBrncNm(JSPUtil.getParameter(request, prefix + "bank_brnc_nm", ""));
		setDpsDivCd(JSPUtil.getParameter(request, prefix + "dps_div_cd", ""));
		setLssCoaInterCoCd(JSPUtil.getParameter(request, prefix + "lss_coa_inter_co_cd", ""));
		setGainCoaVvdCd(JSPUtil.getParameter(request, prefix + "gain_coa_vvd_cd", ""));
		setChgCoaInterCoCd(JSPUtil.getParameter(request, prefix + "chg_coa_inter_co_cd", ""));
		setChgCoaCtrCd(JSPUtil.getParameter(request, prefix + "chg_coa_ctr_cd", ""));
		setMltCurrFlg(JSPUtil.getParameter(request, prefix + "mlt_curr_flg", ""));
		setGainCoaCoCd(JSPUtil.getParameter(request, prefix + "gain_coa_co_cd", ""));
		setLssCoaVvdCd(JSPUtil.getParameter(request, prefix + "lss_coa_vvd_cd", ""));
		setBankAcctNo(JSPUtil.getParameter(request, prefix + "bank_acct_no", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCntcPhnNo(JSPUtil.getParameter(request, prefix + "cntc_phn_no", ""));
		setBankAcctTpMnCd(JSPUtil.getParameter(request, prefix + "bank_acct_tp_mn_cd", ""));
		setInactDt(JSPUtil.getParameter(request, prefix + "inact_dt", ""));
		setAttrCtnt1(JSPUtil.getParameter(request, prefix + "attr_ctnt1", ""));
		setAttrCtnt2(JSPUtil.getParameter(request, prefix + "attr_ctnt2", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setBankAcctAltnNm(JSPUtil.getParameter(request, prefix + "bank_acct_altn_nm", ""));
		setBankAcctStDt(JSPUtil.getParameter(request, prefix + "bank_acct_st_dt", ""));
		setBankAcctTpSubCd(JSPUtil.getParameter(request, prefix + "bank_acct_tp_sub_cd", ""));
		setGainCoaCtrCd(JSPUtil.getParameter(request, prefix + "gain_coa_ctr_cd", ""));
		setBankAcctNm(JSPUtil.getParameter(request, prefix + "bank_acct_nm", ""));
		setLssCdCmbSeq(JSPUtil.getParameter(request, prefix + "lss_cd_cmb_seq", ""));
		setChgCoaVvdCd(JSPUtil.getParameter(request, prefix + "chg_coa_vvd_cd", ""));
		setBankCateCd(JSPUtil.getParameter(request, prefix + "bank_cate_cd", ""));
		setChgCoaCoCd(JSPUtil.getParameter(request, prefix + "chg_coa_co_cd", ""));
		setCntcAreaCd(JSPUtil.getParameter(request, prefix + "cntc_area_cd", ""));
		setAsetCoaInterCoCd(JSPUtil.getParameter(request, prefix + "aset_coa_inter_co_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setChgCoaAcctNo(JSPUtil.getParameter(request, prefix + "chg_coa_acct_no", ""));
		setBankAcctTpNm(JSPUtil.getParameter(request, prefix + "bank_acct_tp_nm", ""));
		setCntcTitNm(JSPUtil.getParameter(request, prefix + "cntc_tit_nm", ""));
		setChgCoaRgnCd(JSPUtil.getParameter(request, prefix + "chg_coa_rgn_cd", ""));
		setGainCdCmbSeq(JSPUtil.getParameter(request, prefix + "gain_cd_cmb_seq", ""));
		setLssCoaCtrCd(JSPUtil.getParameter(request, prefix + "lss_coa_ctr_cd", ""));
		setAsetCoaCoCd(JSPUtil.getParameter(request, prefix + "aset_coa_co_cd", ""));
		setAsetCoaRgnCd(JSPUtil.getParameter(request, prefix + "aset_coa_rgn_cd", ""));
		setCntcNm(JSPUtil.getParameter(request, prefix + "cntc_nm", ""));
		setAcctTpCd(JSPUtil.getParameter(request, prefix + "acct_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BankAccountListVO[]
	 */
	public BankAccountListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BankAccountListVO[]
	 */
	public BankAccountListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BankAccountListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] apCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ap_ctrl_ofc_cd", length));
			String[] gainCoaRgnCd = (JSPUtil.getParameter(request, prefix	+ "gain_coa_rgn_cd", length));
			String[] chgCdCmbSeq = (JSPUtil.getParameter(request, prefix	+ "chg_cd_cmb_seq", length));
			String[] lssCoaRgnCd = (JSPUtil.getParameter(request, prefix	+ "lss_coa_rgn_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] gainCoaInterCoCd = (JSPUtil.getParameter(request, prefix	+ "gain_coa_inter_co_cd", length));
			String[] bankNm = (JSPUtil.getParameter(request, prefix	+ "bank_nm", length));
			String[] asetCoaVvdCd = (JSPUtil.getParameter(request, prefix	+ "aset_coa_vvd_cd", length));
			String[] lssCoaCoCd = (JSPUtil.getParameter(request, prefix	+ "lss_coa_co_cd", length));
			String[] cntcAreaNm = (JSPUtil.getParameter(request, prefix	+ "cntc_area_nm", length));
			String[] asetCoaCtrCd = (JSPUtil.getParameter(request, prefix	+ "aset_coa_ctr_cd", length));
			String[] schBankAcctNo = (JSPUtil.getParameter(request, prefix	+ "sch_bank_acct_no", length));
			String[] bankAcctDesc = (JSPUtil.getParameter(request, prefix	+ "bank_acct_desc", length));
			String[] bankAcctSeq = (JSPUtil.getParameter(request, prefix	+ "bank_acct_seq", length));
			String[] acctTypeL = (JSPUtil.getParameter(request, prefix	+ "acct_type_l", length));
			String[] lssCoaAcctNo = (JSPUtil.getParameter(request, prefix	+ "lss_coa_acct_no", length));
			String[] asetCdCmbSeq = (JSPUtil.getParameter(request, prefix	+ "aset_cd_cmb_seq", length));
			String[] asetCoaAcctNo = (JSPUtil.getParameter(request, prefix	+ "aset_coa_acct_no", length));
			String[] gainCoaAcctNo = (JSPUtil.getParameter(request, prefix	+ "gain_coa_acct_no", length));
			String[] bankBrncSeq = (JSPUtil.getParameter(request, prefix	+ "bank_brnc_seq", length));
			String[] acctTypeM = (JSPUtil.getParameter(request, prefix	+ "acct_type_m", length));
			String[] opnOfcCd = (JSPUtil.getParameter(request, prefix	+ "opn_ofc_cd", length));
			String[] bankBrncNm = (JSPUtil.getParameter(request, prefix	+ "bank_brnc_nm", length));
			String[] dpsDivCd = (JSPUtil.getParameter(request, prefix	+ "dps_div_cd", length));
			String[] lssCoaInterCoCd = (JSPUtil.getParameter(request, prefix	+ "lss_coa_inter_co_cd", length));
			String[] gainCoaVvdCd = (JSPUtil.getParameter(request, prefix	+ "gain_coa_vvd_cd", length));
			String[] chgCoaInterCoCd = (JSPUtil.getParameter(request, prefix	+ "chg_coa_inter_co_cd", length));
			String[] chgCoaCtrCd = (JSPUtil.getParameter(request, prefix	+ "chg_coa_ctr_cd", length));
			String[] mltCurrFlg = (JSPUtil.getParameter(request, prefix	+ "mlt_curr_flg", length));
			String[] gainCoaCoCd = (JSPUtil.getParameter(request, prefix	+ "gain_coa_co_cd", length));
			String[] lssCoaVvdCd = (JSPUtil.getParameter(request, prefix	+ "lss_coa_vvd_cd", length));
			String[] bankAcctNo = (JSPUtil.getParameter(request, prefix	+ "bank_acct_no", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] cntcPhnNo = (JSPUtil.getParameter(request, prefix	+ "cntc_phn_no", length));
			String[] bankAcctTpMnCd = (JSPUtil.getParameter(request, prefix	+ "bank_acct_tp_mn_cd", length));
			String[] inactDt = (JSPUtil.getParameter(request, prefix	+ "inact_dt", length));
			String[] attrCtnt1 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt1", length));
			String[] attrCtnt2 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] bankAcctAltnNm = (JSPUtil.getParameter(request, prefix	+ "bank_acct_altn_nm", length));
			String[] bankAcctStDt = (JSPUtil.getParameter(request, prefix	+ "bank_acct_st_dt", length));
			String[] bankAcctTpSubCd = (JSPUtil.getParameter(request, prefix	+ "bank_acct_tp_sub_cd", length));
			String[] gainCoaCtrCd = (JSPUtil.getParameter(request, prefix	+ "gain_coa_ctr_cd", length));
			String[] bankAcctNm = (JSPUtil.getParameter(request, prefix	+ "bank_acct_nm", length));
			String[] lssCdCmbSeq = (JSPUtil.getParameter(request, prefix	+ "lss_cd_cmb_seq", length));
			String[] chgCoaVvdCd = (JSPUtil.getParameter(request, prefix	+ "chg_coa_vvd_cd", length));
			String[] bankCateCd = (JSPUtil.getParameter(request, prefix	+ "bank_cate_cd", length));
			String[] chgCoaCoCd = (JSPUtil.getParameter(request, prefix	+ "chg_coa_co_cd", length));
			String[] cntcAreaCd = (JSPUtil.getParameter(request, prefix	+ "cntc_area_cd", length));
			String[] asetCoaInterCoCd = (JSPUtil.getParameter(request, prefix	+ "aset_coa_inter_co_cd", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] chgCoaAcctNo = (JSPUtil.getParameter(request, prefix	+ "chg_coa_acct_no", length));
			String[] bankAcctTpNm = (JSPUtil.getParameter(request, prefix	+ "bank_acct_tp_nm", length));
			String[] cntcTitNm = (JSPUtil.getParameter(request, prefix	+ "cntc_tit_nm", length));
			String[] chgCoaRgnCd = (JSPUtil.getParameter(request, prefix	+ "chg_coa_rgn_cd", length));
			String[] gainCdCmbSeq = (JSPUtil.getParameter(request, prefix	+ "gain_cd_cmb_seq", length));
			String[] lssCoaCtrCd = (JSPUtil.getParameter(request, prefix	+ "lss_coa_ctr_cd", length));
			String[] asetCoaCoCd = (JSPUtil.getParameter(request, prefix	+ "aset_coa_co_cd", length));
			String[] asetCoaRgnCd = (JSPUtil.getParameter(request, prefix	+ "aset_coa_rgn_cd", length));
			String[] cntcNm = (JSPUtil.getParameter(request, prefix	+ "cntc_nm", length));
			String[] acctTpCd = (JSPUtil.getParameter(request, prefix	+ "acct_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BankAccountListVO();
				if (apCtrlOfcCd[i] != null)
					model.setApCtrlOfcCd(apCtrlOfcCd[i]);
				if (gainCoaRgnCd[i] != null)
					model.setGainCoaRgnCd(gainCoaRgnCd[i]);
				if (chgCdCmbSeq[i] != null)
					model.setChgCdCmbSeq(chgCdCmbSeq[i]);
				if (lssCoaRgnCd[i] != null)
					model.setLssCoaRgnCd(lssCoaRgnCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (gainCoaInterCoCd[i] != null)
					model.setGainCoaInterCoCd(gainCoaInterCoCd[i]);
				if (bankNm[i] != null)
					model.setBankNm(bankNm[i]);
				if (asetCoaVvdCd[i] != null)
					model.setAsetCoaVvdCd(asetCoaVvdCd[i]);
				if (lssCoaCoCd[i] != null)
					model.setLssCoaCoCd(lssCoaCoCd[i]);
				if (cntcAreaNm[i] != null)
					model.setCntcAreaNm(cntcAreaNm[i]);
				if (asetCoaCtrCd[i] != null)
					model.setAsetCoaCtrCd(asetCoaCtrCd[i]);
				if (schBankAcctNo[i] != null)
					model.setSchBankAcctNo(schBankAcctNo[i]);
				if (bankAcctDesc[i] != null)
					model.setBankAcctDesc(bankAcctDesc[i]);
				if (bankAcctSeq[i] != null)
					model.setBankAcctSeq(bankAcctSeq[i]);
				if (acctTypeL[i] != null)
					model.setAcctTypeL(acctTypeL[i]);
				if (lssCoaAcctNo[i] != null)
					model.setLssCoaAcctNo(lssCoaAcctNo[i]);
				if (asetCdCmbSeq[i] != null)
					model.setAsetCdCmbSeq(asetCdCmbSeq[i]);
				if (asetCoaAcctNo[i] != null)
					model.setAsetCoaAcctNo(asetCoaAcctNo[i]);
				if (gainCoaAcctNo[i] != null)
					model.setGainCoaAcctNo(gainCoaAcctNo[i]);
				if (bankBrncSeq[i] != null)
					model.setBankBrncSeq(bankBrncSeq[i]);
				if (acctTypeM[i] != null)
					model.setAcctTypeM(acctTypeM[i]);
				if (opnOfcCd[i] != null)
					model.setOpnOfcCd(opnOfcCd[i]);
				if (bankBrncNm[i] != null)
					model.setBankBrncNm(bankBrncNm[i]);
				if (dpsDivCd[i] != null)
					model.setDpsDivCd(dpsDivCd[i]);
				if (lssCoaInterCoCd[i] != null)
					model.setLssCoaInterCoCd(lssCoaInterCoCd[i]);
				if (gainCoaVvdCd[i] != null)
					model.setGainCoaVvdCd(gainCoaVvdCd[i]);
				if (chgCoaInterCoCd[i] != null)
					model.setChgCoaInterCoCd(chgCoaInterCoCd[i]);
				if (chgCoaCtrCd[i] != null)
					model.setChgCoaCtrCd(chgCoaCtrCd[i]);
				if (mltCurrFlg[i] != null)
					model.setMltCurrFlg(mltCurrFlg[i]);
				if (gainCoaCoCd[i] != null)
					model.setGainCoaCoCd(gainCoaCoCd[i]);
				if (lssCoaVvdCd[i] != null)
					model.setLssCoaVvdCd(lssCoaVvdCd[i]);
				if (bankAcctNo[i] != null)
					model.setBankAcctNo(bankAcctNo[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (cntcPhnNo[i] != null)
					model.setCntcPhnNo(cntcPhnNo[i]);
				if (bankAcctTpMnCd[i] != null)
					model.setBankAcctTpMnCd(bankAcctTpMnCd[i]);
				if (inactDt[i] != null)
					model.setInactDt(inactDt[i]);
				if (attrCtnt1[i] != null)
					model.setAttrCtnt1(attrCtnt1[i]);
				if (attrCtnt2[i] != null)
					model.setAttrCtnt2(attrCtnt2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (bankAcctAltnNm[i] != null)
					model.setBankAcctAltnNm(bankAcctAltnNm[i]);
				if (bankAcctStDt[i] != null)
					model.setBankAcctStDt(bankAcctStDt[i]);
				if (bankAcctTpSubCd[i] != null)
					model.setBankAcctTpSubCd(bankAcctTpSubCd[i]);
				if (gainCoaCtrCd[i] != null)
					model.setGainCoaCtrCd(gainCoaCtrCd[i]);
				if (bankAcctNm[i] != null)
					model.setBankAcctNm(bankAcctNm[i]);
				if (lssCdCmbSeq[i] != null)
					model.setLssCdCmbSeq(lssCdCmbSeq[i]);
				if (chgCoaVvdCd[i] != null)
					model.setChgCoaVvdCd(chgCoaVvdCd[i]);
				if (bankCateCd[i] != null)
					model.setBankCateCd(bankCateCd[i]);
				if (chgCoaCoCd[i] != null)
					model.setChgCoaCoCd(chgCoaCoCd[i]);
				if (cntcAreaCd[i] != null)
					model.setCntcAreaCd(cntcAreaCd[i]);
				if (asetCoaInterCoCd[i] != null)
					model.setAsetCoaInterCoCd(asetCoaInterCoCd[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (chgCoaAcctNo[i] != null)
					model.setChgCoaAcctNo(chgCoaAcctNo[i]);
				if (bankAcctTpNm[i] != null)
					model.setBankAcctTpNm(bankAcctTpNm[i]);
				if (cntcTitNm[i] != null)
					model.setCntcTitNm(cntcTitNm[i]);
				if (chgCoaRgnCd[i] != null)
					model.setChgCoaRgnCd(chgCoaRgnCd[i]);
				if (gainCdCmbSeq[i] != null)
					model.setGainCdCmbSeq(gainCdCmbSeq[i]);
				if (lssCoaCtrCd[i] != null)
					model.setLssCoaCtrCd(lssCoaCtrCd[i]);
				if (asetCoaCoCd[i] != null)
					model.setAsetCoaCoCd(asetCoaCoCd[i]);
				if (asetCoaRgnCd[i] != null)
					model.setAsetCoaRgnCd(asetCoaRgnCd[i]);
				if (cntcNm[i] != null)
					model.setCntcNm(cntcNm[i]);
				if (acctTpCd[i] != null)
					model.setAcctTpCd(acctTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBankAccountListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BankAccountListVO[]
	 */
	public BankAccountListVO[] getBankAccountListVOs(){
		BankAccountListVO[] vos = (BankAccountListVO[])models.toArray(new BankAccountListVO[models.size()]);
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
		this.gainCoaRgnCd = this.gainCoaRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCdCmbSeq = this.chgCdCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lssCoaRgnCd = this.lssCoaRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gainCoaInterCoCd = this.gainCoaInterCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankNm = this.bankNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asetCoaVvdCd = this.asetCoaVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lssCoaCoCd = this.lssCoaCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcAreaNm = this.cntcAreaNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asetCoaCtrCd = this.asetCoaCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schBankAcctNo = this.schBankAcctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctDesc = this.bankAcctDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctSeq = this.bankAcctSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctTypeL = this.acctTypeL .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lssCoaAcctNo = this.lssCoaAcctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asetCdCmbSeq = this.asetCdCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asetCoaAcctNo = this.asetCoaAcctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gainCoaAcctNo = this.gainCoaAcctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankBrncSeq = this.bankBrncSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctTypeM = this.acctTypeM .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opnOfcCd = this.opnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankBrncNm = this.bankBrncNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpsDivCd = this.dpsDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lssCoaInterCoCd = this.lssCoaInterCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gainCoaVvdCd = this.gainCoaVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCoaInterCoCd = this.chgCoaInterCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCoaCtrCd = this.chgCoaCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mltCurrFlg = this.mltCurrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gainCoaCoCd = this.gainCoaCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lssCoaVvdCd = this.lssCoaVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctNo = this.bankAcctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPhnNo = this.cntcPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctTpMnCd = this.bankAcctTpMnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inactDt = this.inactDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt1 = this.attrCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt2 = this.attrCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctAltnNm = this.bankAcctAltnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctStDt = this.bankAcctStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctTpSubCd = this.bankAcctTpSubCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gainCoaCtrCd = this.gainCoaCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctNm = this.bankAcctNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lssCdCmbSeq = this.lssCdCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCoaVvdCd = this.chgCoaVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankCateCd = this.bankCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCoaCoCd = this.chgCoaCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcAreaCd = this.cntcAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asetCoaInterCoCd = this.asetCoaInterCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCoaAcctNo = this.chgCoaAcctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctTpNm = this.bankAcctTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcTitNm = this.cntcTitNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCoaRgnCd = this.chgCoaRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gainCdCmbSeq = this.gainCdCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lssCoaCtrCd = this.lssCoaCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asetCoaCoCd = this.asetCoaCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asetCoaRgnCd = this.asetCoaRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcNm = this.cntcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctTpCd = this.acctTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
