/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CHSOnHireMGTVO.java
*@FileTitle : CHSOnHireMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.07.14 최민회 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo;

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
 * @author 최민회
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CHSOnHireMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSOnHireMGTVO> models = new ArrayList<CHSOnHireMGTVO>();
	
	/* Column Info */
	private String onhYdCd = null;
	/* Column Info */
	private String verify = null;
	/* Column Info */
	private String chssVehIdNoTmp = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String onhDt = null;
	/* Column Info */
	private String chssTitNoTmp = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String chssAlsNoTmp = null;
	/* Column Info */
	private String onhOfcCd = null;
	/* Column Info */
	private String chssAlsNo = null;
	/* Column Info */
	private String chssTareWgt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String agreementNo = null;
	/* Column Info */
	private String n2ndChssAlsNoTmp = null;
	/* Column Info */
	private String ownLse = null;
	/* Column Info */
	private String agmtRefNo = null;
	/* Column Info */
	private String chssTitNo = null;
	/* Column Info */
	private String chssRgstLicNo = null;
	/* Column Info */
	private String chssRgstExpDt = null;
	/* Column Info */
	private String agmtLstmCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String n2ndChssAlsNo = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String mftDt = null;
	/* Column Info */
	private String chssRgstYr = null;
	/* Column Info */
	private String delChk = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String chssRgstExpDiv = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String onhDtHm = null;
	/* Column Info */
	private String agmtVerNo = null;
	/* Column Info */
	private String chssRgstSteCd = null;
	/* Column Info */
	private String chssVehIdNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSOnHireMGTVO() {}

	public CHSOnHireMGTVO(String ibflag, String pagerows, String delChk, String onhYdCd, String verify, String chssVehIdNoTmp, String vndrLglEngNm, String creDt, String onhDt, String chssTitNoTmp, String eqNo, String chssAlsNoTmp, String onhOfcCd, String chssAlsNo, String chssTareWgt, String updUsrId, String agreementNo, String n2ndChssAlsNoTmp, String ownLse, String agmtRefNo, String chssTitNo, String chssRgstLicNo, String chssRgstExpDt, String agmtLstmCd, String eqKndCd, String n2ndChssAlsNo, String eqTpszCd, String mftDt, String chssRgstYr, String chssRgstExpDiv, String creUsrId, String vndrSeq, String onhDtHm, String chssRgstSteCd, String chssVehIdNo, String agmtVerNo) {
		this.onhYdCd = onhYdCd;
		this.verify = verify;
		this.chssVehIdNoTmp = chssVehIdNoTmp;
		this.creDt = creDt;
		this.vndrLglEngNm = vndrLglEngNm;
		this.onhDt = onhDt;
		this.chssTitNoTmp = chssTitNoTmp;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.chssAlsNoTmp = chssAlsNoTmp;
		this.onhOfcCd = onhOfcCd;
		this.chssAlsNo = chssAlsNo;
		this.chssTareWgt = chssTareWgt;
		this.updUsrId = updUsrId;
		this.agreementNo = agreementNo;
		this.n2ndChssAlsNoTmp = n2ndChssAlsNoTmp;
		this.ownLse = ownLse;
		this.agmtRefNo = agmtRefNo;
		this.chssTitNo = chssTitNo;
		this.chssRgstLicNo = chssRgstLicNo;
		this.chssRgstExpDt = chssRgstExpDt;
		this.agmtLstmCd = agmtLstmCd;
		this.eqKndCd = eqKndCd;
		this.n2ndChssAlsNo = n2ndChssAlsNo;
		this.eqTpszCd = eqTpszCd;
		this.mftDt = mftDt;
		this.chssRgstYr = chssRgstYr;
		this.delChk = delChk;
		this.creUsrId = creUsrId;
		this.chssRgstExpDiv = chssRgstExpDiv;
		this.vndrSeq = vndrSeq;
		this.onhDtHm = onhDtHm;
		this.agmtVerNo = agmtVerNo;
		this.chssRgstSteCd = chssRgstSteCd;
		this.chssVehIdNo = chssVehIdNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("onh_yd_cd", getOnhYdCd());
		this.hashColumns.put("verify", getVerify());
		this.hashColumns.put("chss_veh_id_no_tmp", getChssVehIdNoTmp());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("onh_dt", getOnhDt());
		this.hashColumns.put("chss_tit_no_tmp", getChssTitNoTmp());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("chss_als_no_tmp", getChssAlsNoTmp());
		this.hashColumns.put("onh_ofc_cd", getOnhOfcCd());
		this.hashColumns.put("chss_als_no", getChssAlsNo());
		this.hashColumns.put("chss_tare_wgt", getChssTareWgt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("agreement_no", getAgreementNo());
		this.hashColumns.put("n2nd_chss_als_no_tmp", getN2ndChssAlsNoTmp());
		this.hashColumns.put("own_lse", getOwnLse());
		this.hashColumns.put("agmt_ref_no", getAgmtRefNo());
		this.hashColumns.put("chss_tit_no", getChssTitNo());
		this.hashColumns.put("chss_rgst_lic_no", getChssRgstLicNo());
		this.hashColumns.put("chss_rgst_exp_dt", getChssRgstExpDt());
		this.hashColumns.put("agmt_lstm_cd", getAgmtLstmCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("n2nd_chss_als_no", getN2ndChssAlsNo());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("mft_dt", getMftDt());
		this.hashColumns.put("chss_rgst_yr", getChssRgstYr());
		this.hashColumns.put("del_chk", getDelChk());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("chss_rgst_exp_div", getChssRgstExpDiv());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("onh_dt_hm", getOnhDtHm());
		this.hashColumns.put("agmt_ver_no", getAgmtVerNo());
		this.hashColumns.put("chss_rgst_ste_cd", getChssRgstSteCd());
		this.hashColumns.put("chss_veh_id_no", getChssVehIdNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("onh_yd_cd", "onhYdCd");
		this.hashFields.put("verify", "verify");
		this.hashFields.put("chss_veh_id_no_tmp", "chssVehIdNoTmp");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("onh_dt", "onhDt");
		this.hashFields.put("chss_tit_no_tmp", "chssTitNoTmp");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("chss_als_no_tmp", "chssAlsNoTmp");
		this.hashFields.put("onh_ofc_cd", "onhOfcCd");
		this.hashFields.put("chss_als_no", "chssAlsNo");
		this.hashFields.put("chss_tare_wgt", "chssTareWgt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("agreement_no", "agreementNo");
		this.hashFields.put("n2nd_chss_als_no_tmp", "n2ndChssAlsNoTmp");
		this.hashFields.put("own_lse", "ownLse");
		this.hashFields.put("agmt_ref_no", "agmtRefNo");
		this.hashFields.put("chss_tit_no", "chssTitNo");
		this.hashFields.put("chss_rgst_lic_no", "chssRgstLicNo");
		this.hashFields.put("chss_rgst_exp_dt", "chssRgstExpDt");
		this.hashFields.put("agmt_lstm_cd", "agmtLstmCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("n2nd_chss_als_no", "n2ndChssAlsNo");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("mft_dt", "mftDt");
		this.hashFields.put("chss_rgst_yr", "chssRgstYr");
		this.hashFields.put("del_chk", "delChk");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("chss_rgst_exp_div", "chssRgstExpDiv");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("onh_dt_hm", "onhDtHm");
		this.hashFields.put("agmt_ver_no", "agmtVerNo");
		this.hashFields.put("chss_rgst_ste_cd", "chssRgstSteCd");
		this.hashFields.put("chss_veh_id_no", "chssVehIdNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return onhYdCd
	 */
	public String getOnhYdCd() {
		return this.onhYdCd;
	}
	
	/**
	 * Column Info
	 * @return verify
	 */
	public String getVerify() {
		return this.verify;
	}
	
	/**
	 * Column Info
	 * @return chssVehIdNoTmp
	 */
	public String getChssVehIdNoTmp() {
		return this.chssVehIdNoTmp;
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
	 * @return onhDt
	 */
	public String getOnhDt() {
		return this.onhDt;
	}
	
	/**
	 * Column Info
	 * @return chssTitNoTmp
	 */
	public String getChssTitNoTmp() {
		return this.chssTitNoTmp;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return chssAlsNoTmp
	 */
	public String getChssAlsNoTmp() {
		return this.chssAlsNoTmp;
	}
	
	/**
	 * Column Info
	 * @return onhOfcCd
	 */
	public String getOnhOfcCd() {
		return this.onhOfcCd;
	}
	
	/**
	 * Column Info
	 * @return chssAlsNo
	 */
	public String getChssAlsNo() {
		return this.chssAlsNo;
	}
	
	/**
	 * Column Info
	 * @return chssTareWgt
	 */
	public String getChssTareWgt() {
		return this.chssTareWgt;
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
	 * @return agreementNo
	 */
	public String getAgreementNo() {
		return this.agreementNo;
	}
	
	/**
	 * Column Info
	 * @return n2ndChssAlsNoTmp
	 */
	public String getN2ndChssAlsNoTmp() {
		return this.n2ndChssAlsNoTmp;
	}
	
	/**
	 * Column Info
	 * @return ownLse
	 */
	public String getOwnLse() {
		return this.ownLse;
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
	 * @return chssTitNo
	 */
	public String getChssTitNo() {
		return this.chssTitNo;
	}
	
	/**
	 * Column Info
	 * @return chssRgstLicNo
	 */
	public String getChssRgstLicNo() {
		return this.chssRgstLicNo;
	}
	
	/**
	 * Column Info
	 * @return chssRgstExpDt
	 */
	public String getChssRgstExpDt() {
		return this.chssRgstExpDt;
	}
	
	/**
	 * Column Info
	 * @return agmtLstmCd
	 */
	public String getAgmtLstmCd() {
		return this.agmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return n2ndChssAlsNo
	 */
	public String getN2ndChssAlsNo() {
		return this.n2ndChssAlsNo;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return mftDt
	 */
	public String getMftDt() {
		return this.mftDt;
	}
	
	/**
	 * Column Info
	 * @return chssRgstYr
	 */
	public String getChssRgstYr() {
		return this.chssRgstYr;
	}
	
	/**
	 * Column Info
	 * @return delChk
	 */
	public String getDelChk() {
		return this.delChk;
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
	 * @return chssRgstExpDiv
	 */
	public String getChssRgstExpDiv() {
		return this.chssRgstExpDiv;
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
	 * @return onhDtHm
	 */
	public String getOnhDtHm() {
		return this.onhDtHm;
	}
	
	/**
	 * Column Info
	 * @return agmtVerNo
	 */
	public String getAgmtVerNo() {
		return this.agmtVerNo;
	}
	
	/**
	 * Column Info
	 * @return chssRgstSteCd
	 */
	public String getChssRgstSteCd() {
		return this.chssRgstSteCd;
	}
	
	/**
	 * Column Info
	 * @return chssVehIdNo
	 */
	public String getChssVehIdNo() {
		return this.chssVehIdNo;
	}
	

	/**
	 * Column Info
	 * @param onhYdCd
	 */
	public void setOnhYdCd(String onhYdCd) {
		this.onhYdCd = onhYdCd;
	}
	
	/**
	 * Column Info
	 * @param verify
	 */
	public void setVerify(String verify) {
		this.verify = verify;
	}
	
	/**
	 * Column Info
	 * @param chssVehIdNoTmp
	 */
	public void setChssVehIdNoTmp(String chssVehIdNoTmp) {
		this.chssVehIdNoTmp = chssVehIdNoTmp;
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
	 * @param onhDt
	 */
	public void setOnhDt(String onhDt) {
		this.onhDt = onhDt;
	}
	
	/**
	 * Column Info
	 * @param chssTitNoTmp
	 */
	public void setChssTitNoTmp(String chssTitNoTmp) {
		this.chssTitNoTmp = chssTitNoTmp;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param chssAlsNoTmp
	 */
	public void setChssAlsNoTmp(String chssAlsNoTmp) {
		this.chssAlsNoTmp = chssAlsNoTmp;
	}
	
	/**
	 * Column Info
	 * @param onhOfcCd
	 */
	public void setOnhOfcCd(String onhOfcCd) {
		this.onhOfcCd = onhOfcCd;
	}
	
	/**
	 * Column Info
	 * @param chssAlsNo
	 */
	public void setChssAlsNo(String chssAlsNo) {
		this.chssAlsNo = chssAlsNo;
	}
	
	/**
	 * Column Info
	 * @param chssTareWgt
	 */
	public void setChssTareWgt(String chssTareWgt) {
		this.chssTareWgt = chssTareWgt;
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
	 * @param agreementNo
	 */
	public void setAgreementNo(String agreementNo) {
		this.agreementNo = agreementNo;
	}
	
	/**
	 * Column Info
	 * @param n2ndChssAlsNoTmp
	 */
	public void setN2ndChssAlsNoTmp(String n2ndChssAlsNoTmp) {
		this.n2ndChssAlsNoTmp = n2ndChssAlsNoTmp;
	}
	
	/**
	 * Column Info
	 * @param ownLse
	 */
	public void setOwnLse(String ownLse) {
		this.ownLse = ownLse;
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
	 * @param chssTitNo
	 */
	public void setChssTitNo(String chssTitNo) {
		this.chssTitNo = chssTitNo;
	}
	
	/**
	 * Column Info
	 * @param chssRgstLicNo
	 */
	public void setChssRgstLicNo(String chssRgstLicNo) {
		this.chssRgstLicNo = chssRgstLicNo;
	}
	
	/**
	 * Column Info
	 * @param chssRgstExpDt
	 */
	public void setChssRgstExpDt(String chssRgstExpDt) {
		this.chssRgstExpDt = chssRgstExpDt;
	}
	
	/**
	 * Column Info
	 * @param agmtLstmCd
	 */
	public void setAgmtLstmCd(String agmtLstmCd) {
		this.agmtLstmCd = agmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param n2ndChssAlsNo
	 */
	public void setN2ndChssAlsNo(String n2ndChssAlsNo) {
		this.n2ndChssAlsNo = n2ndChssAlsNo;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param mftDt
	 */
	public void setMftDt(String mftDt) {
		this.mftDt = mftDt;
	}
	
	/**
	 * Column Info
	 * @param chssRgstYr
	 */
	public void setChssRgstYr(String chssRgstYr) {
		this.chssRgstYr = chssRgstYr;
	}
	
	/**
	 * Column Info
	 * @param delChk
	 */
	public void setDelChk(String delChk) {
		this.delChk = delChk;
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
	 * @param chssRgstExpDiv
	 */
	public void setChssRgstExpDiv(String chssRgstExpDiv) {
		this.chssRgstExpDiv = chssRgstExpDiv;
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
	 * @param onhDtHm
	 */
	public void setOnhDtHm(String onhDtHm) {
		this.onhDtHm = onhDtHm;
	}
	
	/**
	 * Column Info
	 * @param agmtVerNo
	 */
	public void setAgmtVerNo(String agmtVerNo) {
		this.agmtVerNo = agmtVerNo;
	}
	
	/**
	 * Column Info
	 * @param chssRgstSteCd
	 */
	public void setChssRgstSteCd(String chssRgstSteCd) {
		this.chssRgstSteCd = chssRgstSteCd;
	}
	
	/**
	 * Column Info
	 * @param chssVehIdNo
	 */
	public void setChssVehIdNo(String chssVehIdNo) {
		this.chssVehIdNo = chssVehIdNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOnhYdCd(JSPUtil.getParameter(request, "onh_yd_cd", ""));
		setVerify(JSPUtil.getParameter(request, "verify", ""));
		setChssVehIdNoTmp(JSPUtil.getParameter(request, "chss_veh_id_no_tmp", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setOnhDt(JSPUtil.getParameter(request, "onh_dt", ""));
		setChssTitNoTmp(JSPUtil.getParameter(request, "chss_tit_no_tmp", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setChssAlsNoTmp(JSPUtil.getParameter(request, "chss_als_no_tmp", ""));
		setOnhOfcCd(JSPUtil.getParameter(request, "onh_ofc_cd", ""));
		setChssAlsNo(JSPUtil.getParameter(request, "chss_als_no", ""));
		setChssTareWgt(JSPUtil.getParameter(request, "chss_tare_wgt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setAgreementNo(JSPUtil.getParameter(request, "agreement_no", ""));
		setN2ndChssAlsNoTmp(JSPUtil.getParameter(request, "n2nd_chss_als_no_tmp", ""));
		setOwnLse(JSPUtil.getParameter(request, "own_lse", ""));
		setAgmtRefNo(JSPUtil.getParameter(request, "agmt_ref_no", ""));
		setChssTitNo(JSPUtil.getParameter(request, "chss_tit_no", ""));
		setChssRgstLicNo(JSPUtil.getParameter(request, "chss_rgst_lic_no", ""));
		setChssRgstExpDt(JSPUtil.getParameter(request, "chss_rgst_exp_dt", ""));
		setAgmtLstmCd(JSPUtil.getParameter(request, "agmt_lstm_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setN2ndChssAlsNo(JSPUtil.getParameter(request, "n2nd_chss_als_no", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setMftDt(JSPUtil.getParameter(request, "mft_dt", ""));
		setChssRgstYr(JSPUtil.getParameter(request, "chss_rgst_yr", ""));
		setDelChk(JSPUtil.getParameter(request, "del_chk", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setChssRgstExpDiv(JSPUtil.getParameter(request, "chss_rgst_exp_div", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setOnhDtHm(JSPUtil.getParameter(request, "onh_dt_hm", ""));
		setAgmtVerNo(JSPUtil.getParameter(request, "agmt_ver_no", ""));
		setChssRgstSteCd(JSPUtil.getParameter(request, "chss_rgst_ste_cd", ""));
		setChssVehIdNo(JSPUtil.getParameter(request, "chss_veh_id_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSOnHireMGTVO[]
	 */
	public CHSOnHireMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSOnHireMGTVO[]
	 */
	public CHSOnHireMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSOnHireMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] onhYdCd = (JSPUtil.getParameter(request, prefix	+ "onh_yd_cd", length));
			String[] verify = (JSPUtil.getParameter(request, prefix	+ "verify", length));
			String[] chssVehIdNoTmp = (JSPUtil.getParameter(request, prefix	+ "chss_veh_id_no_tmp", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] onhDt = (JSPUtil.getParameter(request, prefix	+ "onh_dt", length));
			String[] chssTitNoTmp = (JSPUtil.getParameter(request, prefix	+ "chss_tit_no_tmp", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] chssAlsNoTmp = (JSPUtil.getParameter(request, prefix	+ "chss_als_no_tmp", length));
			String[] onhOfcCd = (JSPUtil.getParameter(request, prefix	+ "onh_ofc_cd", length));
			String[] chssAlsNo = (JSPUtil.getParameter(request, prefix	+ "chss_als_no", length));
			String[] chssTareWgt = (JSPUtil.getParameter(request, prefix	+ "chss_tare_wgt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] agreementNo = (JSPUtil.getParameter(request, prefix	+ "agreement_no", length));
			String[] n2ndChssAlsNoTmp = (JSPUtil.getParameter(request, prefix	+ "n2nd_chss_als_no_tmp", length));
			String[] ownLse = (JSPUtil.getParameter(request, prefix	+ "own_lse", length));
			String[] agmtRefNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ref_no", length));
			String[] chssTitNo = (JSPUtil.getParameter(request, prefix	+ "chss_tit_no", length));
			String[] chssRgstLicNo = (JSPUtil.getParameter(request, prefix	+ "chss_rgst_lic_no", length));
			String[] chssRgstExpDt = (JSPUtil.getParameter(request, prefix	+ "chss_rgst_exp_dt", length));
			String[] agmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "agmt_lstm_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] n2ndChssAlsNo = (JSPUtil.getParameter(request, prefix	+ "n2nd_chss_als_no", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] mftDt = (JSPUtil.getParameter(request, prefix	+ "mft_dt", length));
			String[] chssRgstYr = (JSPUtil.getParameter(request, prefix	+ "chss_rgst_yr", length));
			String[] delChk = (JSPUtil.getParameter(request, prefix	+ "del_chk", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] chssRgstExpDiv = (JSPUtil.getParameter(request, prefix	+ "chss_rgst_exp_div", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] onhDtHm = (JSPUtil.getParameter(request, prefix	+ "onh_dt_hm", length));
			String[] agmtVerNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ver_no", length));
			String[] chssRgstSteCd = (JSPUtil.getParameter(request, prefix	+ "chss_rgst_ste_cd", length));
			String[] chssVehIdNo = (JSPUtil.getParameter(request, prefix	+ "chss_veh_id_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSOnHireMGTVO();
				if (onhYdCd[i] != null)
					model.setOnhYdCd(onhYdCd[i]);
				if (verify[i] != null)
					model.setVerify(verify[i]);
				if (chssVehIdNoTmp[i] != null)
					model.setChssVehIdNoTmp(chssVehIdNoTmp[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (onhDt[i] != null)
					model.setOnhDt(onhDt[i]);
				if (chssTitNoTmp[i] != null)
					model.setChssTitNoTmp(chssTitNoTmp[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (chssAlsNoTmp[i] != null)
					model.setChssAlsNoTmp(chssAlsNoTmp[i]);
				if (onhOfcCd[i] != null)
					model.setOnhOfcCd(onhOfcCd[i]);
				if (chssAlsNo[i] != null)
					model.setChssAlsNo(chssAlsNo[i]);
				if (chssTareWgt[i] != null)
					model.setChssTareWgt(chssTareWgt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (agreementNo[i] != null)
					model.setAgreementNo(agreementNo[i]);
				if (n2ndChssAlsNoTmp[i] != null)
					model.setN2ndChssAlsNoTmp(n2ndChssAlsNoTmp[i]);
				if (ownLse[i] != null)
					model.setOwnLse(ownLse[i]);
				if (agmtRefNo[i] != null)
					model.setAgmtRefNo(agmtRefNo[i]);
				if (chssTitNo[i] != null)
					model.setChssTitNo(chssTitNo[i]);
				if (chssRgstLicNo[i] != null)
					model.setChssRgstLicNo(chssRgstLicNo[i]);
				if (chssRgstExpDt[i] != null)
					model.setChssRgstExpDt(chssRgstExpDt[i]);
				if (agmtLstmCd[i] != null)
					model.setAgmtLstmCd(agmtLstmCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (n2ndChssAlsNo[i] != null)
					model.setN2ndChssAlsNo(n2ndChssAlsNo[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (mftDt[i] != null)
					model.setMftDt(mftDt[i]);
				if (chssRgstYr[i] != null)
					model.setChssRgstYr(chssRgstYr[i]);
				if (delChk[i] != null)
					model.setDelChk(delChk[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (chssRgstExpDiv[i] != null)
					model.setChssRgstExpDiv(chssRgstExpDiv[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (onhDtHm[i] != null)
					model.setOnhDtHm(onhDtHm[i]);
				if (agmtVerNo[i] != null)
					model.setAgmtVerNo(agmtVerNo[i]);
				if (chssRgstSteCd[i] != null)
					model.setChssRgstSteCd(chssRgstSteCd[i]);
				if (chssVehIdNo[i] != null)
					model.setChssVehIdNo(chssVehIdNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSOnHireMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSOnHireMGTVO[]
	 */
	public CHSOnHireMGTVO[] getCHSOnHireMGTVOs(){
		CHSOnHireMGTVO[] vos = (CHSOnHireMGTVO[])models.toArray(new CHSOnHireMGTVO[models.size()]);
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
		this.onhYdCd = this.onhYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.verify = this.verify .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssVehIdNoTmp = this.chssVehIdNoTmp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDt = this.onhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssTitNoTmp = this.chssTitNoTmp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssAlsNoTmp = this.chssAlsNoTmp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhOfcCd = this.onhOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssAlsNo = this.chssAlsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssTareWgt = this.chssTareWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agreementNo = this.agreementNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndChssAlsNoTmp = this.n2ndChssAlsNoTmp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownLse = this.ownLse .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRefNo = this.agmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssTitNo = this.chssTitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssRgstLicNo = this.chssRgstLicNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssRgstExpDt = this.chssRgstExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstmCd = this.agmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndChssAlsNo = this.n2ndChssAlsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftDt = this.mftDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssRgstYr = this.chssRgstYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delChk = this.delChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssRgstExpDiv = this.chssRgstExpDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDtHm = this.onhDtHm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVerNo = this.agmtVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssRgstSteCd = this.chssRgstSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssVehIdNo = this.chssVehIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
