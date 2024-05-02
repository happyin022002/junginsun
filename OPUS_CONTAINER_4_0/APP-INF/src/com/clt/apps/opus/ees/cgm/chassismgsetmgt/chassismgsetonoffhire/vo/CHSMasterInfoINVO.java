/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CHSMasterInfoINVO.java
*@FileTitle : CHSMasterInfoINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.03
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.12.03 조재성 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 조재성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CHSMasterInfoINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSMasterInfoINVO> models = new ArrayList<CHSMasterInfoINVO>();
	
	/* Column Info */
	private String chssPoolCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String crntYdCd = null;
	/* Column Info */
	private String bareChk = null;
	/* Column Info */
	private String onhDt = null;
	/* Column Info */
	private String chssRgstPrdCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String chssMvmtDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String cntrChk = null;
	/* Column Info */
	private String atchMgs = null;
	/* Column Info */
	private String onhOfcCd = null;
	/* Column Info */
	private String lstayChk = null;
	/* Column Info */
	private String chssAlsNo = null;
	/* Column Info */
	private String eqSpecNo = null;
	/* Column Info */
	private String chssTareWgt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String actOnhDt = null;
	/* Column Info */
	private String agreementNo = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String chssRgstUpdDt = null;
	/* Column Info */
	private String agmtRefNo = null;
	/* Column Info */
	private String damageChk = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String chssTitNo = null;
	/* Column Info */
	private String mgsetChk = null;
	/* Column Info */
	private String chssRgstLicNo = null;
	/* Column Info */
	private String atchCntr = null;
	/* Column Info */
	private String chssRgstExpDt = null;
	/* Column Info */
	private String agmtLstmCd = null;
	/* Column Info */
	private String chssRgstUpdId = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String aciacDivCd = null;
	/* Column Info */
	private String n2ndChssAlsNo = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String mftDt = null;
	/* Column Info */
	private String dispFlg = null;
	/* Column Info */
	private String chssRgstYr = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String agmtOfcCtyCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String chssMvmtStsCd = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String chssRgstSteCd = null;
	/* Column Info */
	private String chssVehIdNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSMasterInfoINVO() {}

	public CHSMasterInfoINVO(String ibflag, String pagerows, String chssPoolCd, String creDt, String crntYdCd, String bareChk, String onhDt, String chssRgstPrdCd, String chssMvmtDt, String eqNo, String cntrChk, String onhOfcCd, String lstayChk, String chssAlsNo, String eqSpecNo, String chssTareWgt, String updUsrId, String actOnhDt, String agreementNo, String updDt, String chssRgstUpdDt, String agmtRefNo, String damageChk, String agmtSeq, String chssTitNo, String chssRgstLicNo, String mgsetChk, String chssRgstExpDt, String chssRgstUpdId, String agmtLstmCd, String aciacDivCd, String eqKndCd, String n2ndChssAlsNo, String eqTpszCd, String mftDt, String chssRgstYr, String dispFlg, String creUsrId, String vndrSeq, String agmtOfcCtyCd, String chssMvmtStsCd, String vndrAbbrNm, String chssRgstSteCd, String chssVehIdNo, String atchCntr, String atchMgs) {
		this.chssPoolCd = chssPoolCd;
		this.creDt = creDt;
		this.crntYdCd = crntYdCd;
		this.bareChk = bareChk;
		this.onhDt = onhDt;
		this.chssRgstPrdCd = chssRgstPrdCd;
		this.pagerows = pagerows;
		this.chssMvmtDt = chssMvmtDt;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.cntrChk = cntrChk;
		this.atchMgs = atchMgs;
		this.onhOfcCd = onhOfcCd;
		this.lstayChk = lstayChk;
		this.chssAlsNo = chssAlsNo;
		this.eqSpecNo = eqSpecNo;
		this.chssTareWgt = chssTareWgt;
		this.updUsrId = updUsrId;
		this.actOnhDt = actOnhDt;
		this.agreementNo = agreementNo;
		this.updDt = updDt;
		this.chssRgstUpdDt = chssRgstUpdDt;
		this.agmtRefNo = agmtRefNo;
		this.damageChk = damageChk;
		this.agmtSeq = agmtSeq;
		this.chssTitNo = chssTitNo;
		this.mgsetChk = mgsetChk;
		this.chssRgstLicNo = chssRgstLicNo;
		this.atchCntr = atchCntr;
		this.chssRgstExpDt = chssRgstExpDt;
		this.agmtLstmCd = agmtLstmCd;
		this.chssRgstUpdId = chssRgstUpdId;
		this.eqKndCd = eqKndCd;
		this.aciacDivCd = aciacDivCd;
		this.n2ndChssAlsNo = n2ndChssAlsNo;
		this.eqTpszCd = eqTpszCd;
		this.mftDt = mftDt;
		this.dispFlg = dispFlg;
		this.chssRgstYr = chssRgstYr;
		this.creUsrId = creUsrId;
		this.agmtOfcCtyCd = agmtOfcCtyCd;
		this.vndrSeq = vndrSeq;
		this.chssMvmtStsCd = chssMvmtStsCd;
		this.vndrAbbrNm = vndrAbbrNm;
		this.chssRgstSteCd = chssRgstSteCd;
		this.chssVehIdNo = chssVehIdNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("chss_pool_cd", getChssPoolCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("bare_chk", getBareChk());
		this.hashColumns.put("onh_dt", getOnhDt());
		this.hashColumns.put("chss_rgst_prd_cd", getChssRgstPrdCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("chss_mvmt_dt", getChssMvmtDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("cntr_chk", getCntrChk());
		this.hashColumns.put("atch_mgs", getAtchMgs());
		this.hashColumns.put("onh_ofc_cd", getOnhOfcCd());
		this.hashColumns.put("lstay_chk", getLstayChk());
		this.hashColumns.put("chss_als_no", getChssAlsNo());
		this.hashColumns.put("eq_spec_no", getEqSpecNo());
		this.hashColumns.put("chss_tare_wgt", getChssTareWgt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("act_onh_dt", getActOnhDt());
		this.hashColumns.put("agreement_no", getAgreementNo());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("chss_rgst_upd_dt", getChssRgstUpdDt());
		this.hashColumns.put("agmt_ref_no", getAgmtRefNo());
		this.hashColumns.put("damage_chk", getDamageChk());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("chss_tit_no", getChssTitNo());
		this.hashColumns.put("mgset_chk", getMgsetChk());
		this.hashColumns.put("chss_rgst_lic_no", getChssRgstLicNo());
		this.hashColumns.put("atch_cntr", getAtchCntr());
		this.hashColumns.put("chss_rgst_exp_dt", getChssRgstExpDt());
		this.hashColumns.put("agmt_lstm_cd", getAgmtLstmCd());
		this.hashColumns.put("chss_rgst_upd_id", getChssRgstUpdId());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("aciac_div_cd", getAciacDivCd());
		this.hashColumns.put("n2nd_chss_als_no", getN2ndChssAlsNo());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("mft_dt", getMftDt());
		this.hashColumns.put("disp_flg", getDispFlg());
		this.hashColumns.put("chss_rgst_yr", getChssRgstYr());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("chss_mvmt_sts_cd", getChssMvmtStsCd());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("chss_rgst_ste_cd", getChssRgstSteCd());
		this.hashColumns.put("chss_veh_id_no", getChssVehIdNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("chss_pool_cd", "chssPoolCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("bare_chk", "bareChk");
		this.hashFields.put("onh_dt", "onhDt");
		this.hashFields.put("chss_rgst_prd_cd", "chssRgstPrdCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("chss_mvmt_dt", "chssMvmtDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("cntr_chk", "cntrChk");
		this.hashFields.put("atch_mgs", "atchMgs");
		this.hashFields.put("onh_ofc_cd", "onhOfcCd");
		this.hashFields.put("lstay_chk", "lstayChk");
		this.hashFields.put("chss_als_no", "chssAlsNo");
		this.hashFields.put("eq_spec_no", "eqSpecNo");
		this.hashFields.put("chss_tare_wgt", "chssTareWgt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("act_onh_dt", "actOnhDt");
		this.hashFields.put("agreement_no", "agreementNo");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("chss_rgst_upd_dt", "chssRgstUpdDt");
		this.hashFields.put("agmt_ref_no", "agmtRefNo");
		this.hashFields.put("damage_chk", "damageChk");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("chss_tit_no", "chssTitNo");
		this.hashFields.put("mgset_chk", "mgsetChk");
		this.hashFields.put("chss_rgst_lic_no", "chssRgstLicNo");
		this.hashFields.put("atch_cntr", "atchCntr");
		this.hashFields.put("chss_rgst_exp_dt", "chssRgstExpDt");
		this.hashFields.put("agmt_lstm_cd", "agmtLstmCd");
		this.hashFields.put("chss_rgst_upd_id", "chssRgstUpdId");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("aciac_div_cd", "aciacDivCd");
		this.hashFields.put("n2nd_chss_als_no", "n2ndChssAlsNo");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("mft_dt", "mftDt");
		this.hashFields.put("disp_flg", "dispFlg");
		this.hashFields.put("chss_rgst_yr", "chssRgstYr");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("chss_mvmt_sts_cd", "chssMvmtStsCd");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("chss_rgst_ste_cd", "chssRgstSteCd");
		this.hashFields.put("chss_veh_id_no", "chssVehIdNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return chssPoolCd
	 */
	public String getChssPoolCd() {
		return this.chssPoolCd;
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
	 * @return crntYdCd
	 */
	public String getCrntYdCd() {
		return this.crntYdCd;
	}
	
	/**
	 * Column Info
	 * @return bareChk
	 */
	public String getBareChk() {
		return this.bareChk;
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
	 * @return chssRgstPrdCd
	 */
	public String getChssRgstPrdCd() {
		return this.chssRgstPrdCd;
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
	 * @return chssMvmtDt
	 */
	public String getChssMvmtDt() {
		return this.chssMvmtDt;
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
	 * @return cntrChk
	 */
	public String getCntrChk() {
		return this.cntrChk;
	}
	
	/**
	 * Column Info
	 * @return atchMgs
	 */
	public String getAtchMgs() {
		return this.atchMgs;
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
	 * @return lstayChk
	 */
	public String getLstayChk() {
		return this.lstayChk;
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
	 * @return eqSpecNo
	 */
	public String getEqSpecNo() {
		return this.eqSpecNo;
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
	 * @return actOnhDt
	 */
	public String getActOnhDt() {
		return this.actOnhDt;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return chssRgstUpdDt
	 */
	public String getChssRgstUpdDt() {
		return this.chssRgstUpdDt;
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
	 * @return damageChk
	 */
	public String getDamageChk() {
		return this.damageChk;
	}
	
	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
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
	 * @return mgsetChk
	 */
	public String getMgsetChk() {
		return this.mgsetChk;
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
	 * @return atchCntr
	 */
	public String getAtchCntr() {
		return this.atchCntr;
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
	 * @return chssRgstUpdId
	 */
	public String getChssRgstUpdId() {
		return this.chssRgstUpdId;
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
	 * @return aciacDivCd
	 */
	public String getAciacDivCd() {
		return this.aciacDivCd;
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
	 * @return dispFlg
	 */
	public String getDispFlg() {
		return this.dispFlg;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return agmtOfcCtyCd
	 */
	public String getAgmtOfcCtyCd() {
		return this.agmtOfcCtyCd;
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
	 * @return chssMvmtStsCd
	 */
	public String getChssMvmtStsCd() {
		return this.chssMvmtStsCd;
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
	 * @param chssPoolCd
	 */
	public void setChssPoolCd(String chssPoolCd) {
		this.chssPoolCd = chssPoolCd;
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
	 * @param crntYdCd
	 */
	public void setCrntYdCd(String crntYdCd) {
		this.crntYdCd = crntYdCd;
	}
	
	/**
	 * Column Info
	 * @param bareChk
	 */
	public void setBareChk(String bareChk) {
		this.bareChk = bareChk;
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
	 * @param chssRgstPrdCd
	 */
	public void setChssRgstPrdCd(String chssRgstPrdCd) {
		this.chssRgstPrdCd = chssRgstPrdCd;
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
	 * @param chssMvmtDt
	 */
	public void setChssMvmtDt(String chssMvmtDt) {
		this.chssMvmtDt = chssMvmtDt;
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
	 * @param cntrChk
	 */
	public void setCntrChk(String cntrChk) {
		this.cntrChk = cntrChk;
	}
	
	/**
	 * Column Info
	 * @param atchMgs
	 */
	public void setAtchMgs(String atchMgs) {
		this.atchMgs = atchMgs;
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
	 * @param lstayChk
	 */
	public void setLstayChk(String lstayChk) {
		this.lstayChk = lstayChk;
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
	 * @param eqSpecNo
	 */
	public void setEqSpecNo(String eqSpecNo) {
		this.eqSpecNo = eqSpecNo;
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
	 * @param actOnhDt
	 */
	public void setActOnhDt(String actOnhDt) {
		this.actOnhDt = actOnhDt;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param chssRgstUpdDt
	 */
	public void setChssRgstUpdDt(String chssRgstUpdDt) {
		this.chssRgstUpdDt = chssRgstUpdDt;
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
	 * @param damageChk
	 */
	public void setDamageChk(String damageChk) {
		this.damageChk = damageChk;
	}
	
	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
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
	 * @param mgsetChk
	 */
	public void setMgsetChk(String mgsetChk) {
		this.mgsetChk = mgsetChk;
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
	 * @param atchCntr
	 */
	public void setAtchCntr(String atchCntr) {
		this.atchCntr = atchCntr;
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
	 * @param chssRgstUpdId
	 */
	public void setChssRgstUpdId(String chssRgstUpdId) {
		this.chssRgstUpdId = chssRgstUpdId;
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
	 * @param aciacDivCd
	 */
	public void setAciacDivCd(String aciacDivCd) {
		this.aciacDivCd = aciacDivCd;
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
	 * @param dispFlg
	 */
	public void setDispFlg(String dispFlg) {
		this.dispFlg = dispFlg;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param agmtOfcCtyCd
	 */
	public void setAgmtOfcCtyCd(String agmtOfcCtyCd) {
		this.agmtOfcCtyCd = agmtOfcCtyCd;
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
	 * @param chssMvmtStsCd
	 */
	public void setChssMvmtStsCd(String chssMvmtStsCd) {
		this.chssMvmtStsCd = chssMvmtStsCd;
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
		setChssPoolCd(JSPUtil.getParameter(request, "chss_pool_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCrntYdCd(JSPUtil.getParameter(request, "crnt_yd_cd", ""));
		setBareChk(JSPUtil.getParameter(request, "bare_chk", ""));
		setOnhDt(JSPUtil.getParameter(request, "onh_dt", ""));
		setChssRgstPrdCd(JSPUtil.getParameter(request, "chss_rgst_prd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setChssMvmtDt(JSPUtil.getParameter(request, "chss_mvmt_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setCntrChk(JSPUtil.getParameter(request, "cntr_chk", ""));
		setAtchMgs(JSPUtil.getParameter(request, "atch_mgs", ""));
		setOnhOfcCd(JSPUtil.getParameter(request, "onh_ofc_cd", ""));
		setLstayChk(JSPUtil.getParameter(request, "lstay_chk", ""));
		setChssAlsNo(JSPUtil.getParameter(request, "chss_als_no", ""));
		setEqSpecNo(JSPUtil.getParameter(request, "eq_spec_no", ""));
		setChssTareWgt(JSPUtil.getParameter(request, "chss_tare_wgt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setActOnhDt(JSPUtil.getParameter(request, "act_onh_dt", ""));
		setAgreementNo(JSPUtil.getParameter(request, "agreement_no", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setChssRgstUpdDt(JSPUtil.getParameter(request, "chss_rgst_upd_dt", ""));
		setAgmtRefNo(JSPUtil.getParameter(request, "agmt_ref_no", ""));
		setDamageChk(JSPUtil.getParameter(request, "damage_chk", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setChssTitNo(JSPUtil.getParameter(request, "chss_tit_no", ""));
		setMgsetChk(JSPUtil.getParameter(request, "mgset_chk", ""));
		setChssRgstLicNo(JSPUtil.getParameter(request, "chss_rgst_lic_no", ""));
		setAtchCntr(JSPUtil.getParameter(request, "atch_cntr", ""));
		setChssRgstExpDt(JSPUtil.getParameter(request, "chss_rgst_exp_dt", ""));
		setAgmtLstmCd(JSPUtil.getParameter(request, "agmt_lstm_cd", ""));
		setChssRgstUpdId(JSPUtil.getParameter(request, "chss_rgst_upd_id", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setAciacDivCd(JSPUtil.getParameter(request, "aciac_div_cd", ""));
		setN2ndChssAlsNo(JSPUtil.getParameter(request, "n2nd_chss_als_no", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setMftDt(JSPUtil.getParameter(request, "mft_dt", ""));
		setDispFlg(JSPUtil.getParameter(request, "disp_flg", ""));
		setChssRgstYr(JSPUtil.getParameter(request, "chss_rgst_yr", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setAgmtOfcCtyCd(JSPUtil.getParameter(request, "agmt_ofc_cty_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setChssMvmtStsCd(JSPUtil.getParameter(request, "chss_mvmt_sts_cd", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, "vndr_abbr_nm", ""));
		setChssRgstSteCd(JSPUtil.getParameter(request, "chss_rgst_ste_cd", ""));
		setChssVehIdNo(JSPUtil.getParameter(request, "chss_veh_id_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSMasterInfoINVO[]
	 */
	public CHSMasterInfoINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSMasterInfoINVO[]
	 */
	public CHSMasterInfoINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSMasterInfoINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] chssPoolCd = (JSPUtil.getParameter(request, prefix	+ "chss_pool_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix	+ "crnt_yd_cd", length));
			String[] bareChk = (JSPUtil.getParameter(request, prefix	+ "bare_chk", length));
			String[] onhDt = (JSPUtil.getParameter(request, prefix	+ "onh_dt", length));
			String[] chssRgstPrdCd = (JSPUtil.getParameter(request, prefix	+ "chss_rgst_prd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] chssMvmtDt = (JSPUtil.getParameter(request, prefix	+ "chss_mvmt_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] cntrChk = (JSPUtil.getParameter(request, prefix	+ "cntr_chk", length));
			String[] atchMgs = (JSPUtil.getParameter(request, prefix	+ "atch_mgs", length));
			String[] onhOfcCd = (JSPUtil.getParameter(request, prefix	+ "onh_ofc_cd", length));
			String[] lstayChk = (JSPUtil.getParameter(request, prefix	+ "lstay_chk", length));
			String[] chssAlsNo = (JSPUtil.getParameter(request, prefix	+ "chss_als_no", length));
			String[] eqSpecNo = (JSPUtil.getParameter(request, prefix	+ "eq_spec_no", length));
			String[] chssTareWgt = (JSPUtil.getParameter(request, prefix	+ "chss_tare_wgt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] actOnhDt = (JSPUtil.getParameter(request, prefix	+ "act_onh_dt", length));
			String[] agreementNo = (JSPUtil.getParameter(request, prefix	+ "agreement_no", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] chssRgstUpdDt = (JSPUtil.getParameter(request, prefix	+ "chss_rgst_upd_dt", length));
			String[] agmtRefNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ref_no", length));
			String[] damageChk = (JSPUtil.getParameter(request, prefix	+ "damage_chk", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] chssTitNo = (JSPUtil.getParameter(request, prefix	+ "chss_tit_no", length));
			String[] mgsetChk = (JSPUtil.getParameter(request, prefix	+ "mgset_chk", length));
			String[] chssRgstLicNo = (JSPUtil.getParameter(request, prefix	+ "chss_rgst_lic_no", length));
			String[] atchCntr = (JSPUtil.getParameter(request, prefix	+ "atch_cntr", length));
			String[] chssRgstExpDt = (JSPUtil.getParameter(request, prefix	+ "chss_rgst_exp_dt", length));
			String[] agmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "agmt_lstm_cd", length));
			String[] chssRgstUpdId = (JSPUtil.getParameter(request, prefix	+ "chss_rgst_upd_id", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] aciacDivCd = (JSPUtil.getParameter(request, prefix	+ "aciac_div_cd", length));
			String[] n2ndChssAlsNo = (JSPUtil.getParameter(request, prefix	+ "n2nd_chss_als_no", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] mftDt = (JSPUtil.getParameter(request, prefix	+ "mft_dt", length));
			String[] dispFlg = (JSPUtil.getParameter(request, prefix	+ "disp_flg", length));
			String[] chssRgstYr = (JSPUtil.getParameter(request, prefix	+ "chss_rgst_yr", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] agmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cty_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] chssMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "chss_mvmt_sts_cd", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] chssRgstSteCd = (JSPUtil.getParameter(request, prefix	+ "chss_rgst_ste_cd", length));
			String[] chssVehIdNo = (JSPUtil.getParameter(request, prefix	+ "chss_veh_id_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSMasterInfoINVO();
				if (chssPoolCd[i] != null)
					model.setChssPoolCd(chssPoolCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);
				if (bareChk[i] != null)
					model.setBareChk(bareChk[i]);
				if (onhDt[i] != null)
					model.setOnhDt(onhDt[i]);
				if (chssRgstPrdCd[i] != null)
					model.setChssRgstPrdCd(chssRgstPrdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (chssMvmtDt[i] != null)
					model.setChssMvmtDt(chssMvmtDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (cntrChk[i] != null)
					model.setCntrChk(cntrChk[i]);
				if (atchMgs[i] != null)
					model.setAtchMgs(atchMgs[i]);
				if (onhOfcCd[i] != null)
					model.setOnhOfcCd(onhOfcCd[i]);
				if (lstayChk[i] != null)
					model.setLstayChk(lstayChk[i]);
				if (chssAlsNo[i] != null)
					model.setChssAlsNo(chssAlsNo[i]);
				if (eqSpecNo[i] != null)
					model.setEqSpecNo(eqSpecNo[i]);
				if (chssTareWgt[i] != null)
					model.setChssTareWgt(chssTareWgt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (actOnhDt[i] != null)
					model.setActOnhDt(actOnhDt[i]);
				if (agreementNo[i] != null)
					model.setAgreementNo(agreementNo[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (chssRgstUpdDt[i] != null)
					model.setChssRgstUpdDt(chssRgstUpdDt[i]);
				if (agmtRefNo[i] != null)
					model.setAgmtRefNo(agmtRefNo[i]);
				if (damageChk[i] != null)
					model.setDamageChk(damageChk[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (chssTitNo[i] != null)
					model.setChssTitNo(chssTitNo[i]);
				if (mgsetChk[i] != null)
					model.setMgsetChk(mgsetChk[i]);
				if (chssRgstLicNo[i] != null)
					model.setChssRgstLicNo(chssRgstLicNo[i]);
				if (atchCntr[i] != null)
					model.setAtchCntr(atchCntr[i]);
				if (chssRgstExpDt[i] != null)
					model.setChssRgstExpDt(chssRgstExpDt[i]);
				if (agmtLstmCd[i] != null)
					model.setAgmtLstmCd(agmtLstmCd[i]);
				if (chssRgstUpdId[i] != null)
					model.setChssRgstUpdId(chssRgstUpdId[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (aciacDivCd[i] != null)
					model.setAciacDivCd(aciacDivCd[i]);
				if (n2ndChssAlsNo[i] != null)
					model.setN2ndChssAlsNo(n2ndChssAlsNo[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (mftDt[i] != null)
					model.setMftDt(mftDt[i]);
				if (dispFlg[i] != null)
					model.setDispFlg(dispFlg[i]);
				if (chssRgstYr[i] != null)
					model.setChssRgstYr(chssRgstYr[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (agmtOfcCtyCd[i] != null)
					model.setAgmtOfcCtyCd(agmtOfcCtyCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (chssMvmtStsCd[i] != null)
					model.setChssMvmtStsCd(chssMvmtStsCd[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (chssRgstSteCd[i] != null)
					model.setChssRgstSteCd(chssRgstSteCd[i]);
				if (chssVehIdNo[i] != null)
					model.setChssVehIdNo(chssVehIdNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSMasterInfoINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSMasterInfoINVO[]
	 */
	public CHSMasterInfoINVO[] getCHSMasterInfoINVOs(){
		CHSMasterInfoINVO[] vos = (CHSMasterInfoINVO[])models.toArray(new CHSMasterInfoINVO[models.size()]);
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
		this.chssPoolCd = this.chssPoolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd = this.crntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bareChk = this.bareChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDt = this.onhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssRgstPrdCd = this.chssRgstPrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMvmtDt = this.chssMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrChk = this.cntrChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchMgs = this.atchMgs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhOfcCd = this.onhOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstayChk = this.lstayChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssAlsNo = this.chssAlsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSpecNo = this.eqSpecNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssTareWgt = this.chssTareWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actOnhDt = this.actOnhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agreementNo = this.agreementNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssRgstUpdDt = this.chssRgstUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRefNo = this.agmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.damageChk = this.damageChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssTitNo = this.chssTitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgsetChk = this.mgsetChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssRgstLicNo = this.chssRgstLicNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchCntr = this.atchCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssRgstExpDt = this.chssRgstExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstmCd = this.agmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssRgstUpdId = this.chssRgstUpdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aciacDivCd = this.aciacDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndChssAlsNo = this.n2ndChssAlsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftDt = this.mftDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispFlg = this.dispFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssRgstYr = this.chssRgstYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCtyCd = this.agmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMvmtStsCd = this.chssMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssRgstSteCd = this.chssRgstSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssVehIdNo = this.chssVehIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
