/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MGSEquipmentINVO.java
*@FileTitle : MGSEquipmentINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.04.23 조재성 
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

public class MGSEquipmentINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MGSEquipmentINVO> models = new ArrayList<MGSEquipmentINVO>();
	
	/* Column Info */
	private String orgAtchDt = null;
	/* Column Info */
	private String mgstFuelCapa = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String crntYdCd = null;
	/* Column Info */
	private String bareChk = null;
	/* Column Info */
	private String onhDt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String mgstWarrEndDt = null;
	/* Column Info */
	private String mgstRunHrsUpdDt = null;
	/* Column Info */
	private String cntrChk = null;
	/* Column Info */
	private String onhOfcCd = null;
	/* Column Info */
	private String eqSpecNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String agreementNo = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String agmtRefNo = null;
	/* Column Info */
	private String mgstRunHrs = null;
	/* Column Info */
	private String damageChk = null;
	/* Column Info */
	private String atchChs = null;
	/* Column Info */
	private String atchCntr = null;
	/* Column Info */
	private String mgstMchnSerNo = null;
	/* Column Info */
	private String mgstVltgCapa = null;
	/* Column Info */
	private String agmtLstmCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String aciacDivCd = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String mftDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String chsChk = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String masterSaveFlag = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MGSEquipmentINVO() {}

	public MGSEquipmentINVO(String ibflag, String pagerows, String creDt, String vndrLglEngNm, String mgstFuelCapa, String crntYdCd, String bareChk, String onhDt, String mgstWarrEndDt, String eqNo, String cntrChk, String mgstRunHrsUpdDt, String onhOfcCd, String eqSpecNo, String updUsrId, String agreementNo, String updDt, String agmtRefNo, String mgstRunHrs, String damageChk, String atchChs, String atchCntr, String mgstMchnSerNo, String mgstVltgCapa, String agmtLstmCd, String aciacDivCd, String eqKndCd, String eqTpszCd, String mftDt, String chsChk, String creUsrId, String vndrSeq, String masterSaveFlag, String orgAtchDt) {
		this.orgAtchDt = orgAtchDt;
		this.mgstFuelCapa = mgstFuelCapa;
		this.vndrLglEngNm = vndrLglEngNm;
		this.creDt = creDt;
		this.crntYdCd = crntYdCd;
		this.bareChk = bareChk;
		this.onhDt = onhDt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.mgstWarrEndDt = mgstWarrEndDt;
		this.mgstRunHrsUpdDt = mgstRunHrsUpdDt;
		this.cntrChk = cntrChk;
		this.onhOfcCd = onhOfcCd;
		this.eqSpecNo = eqSpecNo;
		this.updUsrId = updUsrId;
		this.agreementNo = agreementNo;
		this.updDt = updDt;
		this.agmtRefNo = agmtRefNo;
		this.mgstRunHrs = mgstRunHrs;
		this.damageChk = damageChk;
		this.atchChs = atchChs;
		this.atchCntr = atchCntr;
		this.mgstMchnSerNo = mgstMchnSerNo;
		this.mgstVltgCapa = mgstVltgCapa;
		this.agmtLstmCd = agmtLstmCd;
		this.eqKndCd = eqKndCd;
		this.aciacDivCd = aciacDivCd;
		this.eqTpszCd = eqTpszCd;
		this.mftDt = mftDt;
		this.creUsrId = creUsrId;
		this.chsChk = chsChk;
		this.vndrSeq = vndrSeq;
		this.masterSaveFlag = masterSaveFlag;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("org_atch_dt", getOrgAtchDt());
		this.hashColumns.put("mgst_fuel_capa", getMgstFuelCapa());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("bare_chk", getBareChk());
		this.hashColumns.put("onh_dt", getOnhDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("mgst_warr_end_dt", getMgstWarrEndDt());
		this.hashColumns.put("mgst_run_hrs_upd_dt", getMgstRunHrsUpdDt());
		this.hashColumns.put("cntr_chk", getCntrChk());
		this.hashColumns.put("onh_ofc_cd", getOnhOfcCd());
		this.hashColumns.put("eq_spec_no", getEqSpecNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("agreement_no", getAgreementNo());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("agmt_ref_no", getAgmtRefNo());
		this.hashColumns.put("mgst_run_hrs", getMgstRunHrs());
		this.hashColumns.put("damage_chk", getDamageChk());
		this.hashColumns.put("atch_chs", getAtchChs());
		this.hashColumns.put("atch_cntr", getAtchCntr());
		this.hashColumns.put("mgst_mchn_ser_no", getMgstMchnSerNo());
		this.hashColumns.put("mgst_vltg_capa", getMgstVltgCapa());
		this.hashColumns.put("agmt_lstm_cd", getAgmtLstmCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("aciac_div_cd", getAciacDivCd());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("mft_dt", getMftDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("chs_chk", getChsChk());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("master_save_flag", getMasterSaveFlag());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("org_atch_dt", "orgAtchDt");
		this.hashFields.put("mgst_fuel_capa", "mgstFuelCapa");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("bare_chk", "bareChk");
		this.hashFields.put("onh_dt", "onhDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("mgst_warr_end_dt", "mgstWarrEndDt");
		this.hashFields.put("mgst_run_hrs_upd_dt", "mgstRunHrsUpdDt");
		this.hashFields.put("cntr_chk", "cntrChk");
		this.hashFields.put("onh_ofc_cd", "onhOfcCd");
		this.hashFields.put("eq_spec_no", "eqSpecNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("agreement_no", "agreementNo");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("agmt_ref_no", "agmtRefNo");
		this.hashFields.put("mgst_run_hrs", "mgstRunHrs");
		this.hashFields.put("damage_chk", "damageChk");
		this.hashFields.put("atch_chs", "atchChs");
		this.hashFields.put("atch_cntr", "atchCntr");
		this.hashFields.put("mgst_mchn_ser_no", "mgstMchnSerNo");
		this.hashFields.put("mgst_vltg_capa", "mgstVltgCapa");
		this.hashFields.put("agmt_lstm_cd", "agmtLstmCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("aciac_div_cd", "aciacDivCd");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("mft_dt", "mftDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("chs_chk", "chsChk");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("master_save_flag", "masterSaveFlag");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return orgAtchDt
	 */
	public String getOrgAtchDt() {
		return this.orgAtchDt;
	}
	
	/**
	 * Column Info
	 * @return mgstFuelCapa
	 */
	public String getMgstFuelCapa() {
		return this.mgstFuelCapa;
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
	 * @return mgstWarrEndDt
	 */
	public String getMgstWarrEndDt() {
		return this.mgstWarrEndDt;
	}
	
	/**
	 * Column Info
	 * @return mgstRunHrsUpdDt
	 */
	public String getMgstRunHrsUpdDt() {
		return this.mgstRunHrsUpdDt;
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
	 * @return onhOfcCd
	 */
	public String getOnhOfcCd() {
		return this.onhOfcCd;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @return mgstRunHrs
	 */
	public String getMgstRunHrs() {
		return this.mgstRunHrs;
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
	 * @return atchChs
	 */
	public String getAtchChs() {
		return this.atchChs;
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
	 * @return mgstMchnSerNo
	 */
	public String getMgstMchnSerNo() {
		return this.mgstMchnSerNo;
	}
	
	/**
	 * Column Info
	 * @return mgstVltgCapa
	 */
	public String getMgstVltgCapa() {
		return this.mgstVltgCapa;
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
	 * @return aciacDivCd
	 */
	public String getAciacDivCd() {
		return this.aciacDivCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return chsChk
	 */
	public String getChsChk() {
		return this.chsChk;
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
	 * @return masterSaveFlag
	 */
	public String getMasterSaveFlag() {
		return this.masterSaveFlag;
	}
	

	/**
	 * Column Info
	 * @param orgAtchDt
	 */
	public void setOrgAtchDt(String orgAtchDt) {
		this.orgAtchDt = orgAtchDt;
	}
	
	/**
	 * Column Info
	 * @param mgstFuelCapa
	 */
	public void setMgstFuelCapa(String mgstFuelCapa) {
		this.mgstFuelCapa = mgstFuelCapa;
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
	 * @param mgstWarrEndDt
	 */
	public void setMgstWarrEndDt(String mgstWarrEndDt) {
		this.mgstWarrEndDt = mgstWarrEndDt;
	}
	
	/**
	 * Column Info
	 * @param mgstRunHrsUpdDt
	 */
	public void setMgstRunHrsUpdDt(String mgstRunHrsUpdDt) {
		this.mgstRunHrsUpdDt = mgstRunHrsUpdDt;
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
	 * @param onhOfcCd
	 */
	public void setOnhOfcCd(String onhOfcCd) {
		this.onhOfcCd = onhOfcCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param mgstRunHrs
	 */
	public void setMgstRunHrs(String mgstRunHrs) {
		this.mgstRunHrs = mgstRunHrs;
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
	 * @param atchChs
	 */
	public void setAtchChs(String atchChs) {
		this.atchChs = atchChs;
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
	 * @param mgstMchnSerNo
	 */
	public void setMgstMchnSerNo(String mgstMchnSerNo) {
		this.mgstMchnSerNo = mgstMchnSerNo;
	}
	
	/**
	 * Column Info
	 * @param mgstVltgCapa
	 */
	public void setMgstVltgCapa(String mgstVltgCapa) {
		this.mgstVltgCapa = mgstVltgCapa;
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
	 * @param aciacDivCd
	 */
	public void setAciacDivCd(String aciacDivCd) {
		this.aciacDivCd = aciacDivCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param chsChk
	 */
	public void setChsChk(String chsChk) {
		this.chsChk = chsChk;
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
	 * @param masterSaveFlag
	 */
	public void setMasterSaveFlag(String masterSaveFlag) {
		this.masterSaveFlag = masterSaveFlag;
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
		setOrgAtchDt(JSPUtil.getParameter(request, prefix + "org_atch_dt", ""));
		setMgstFuelCapa(JSPUtil.getParameter(request, prefix + "mgst_fuel_capa", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCrntYdCd(JSPUtil.getParameter(request, prefix + "crnt_yd_cd", ""));
		setBareChk(JSPUtil.getParameter(request, prefix + "bare_chk", ""));
		setOnhDt(JSPUtil.getParameter(request, prefix + "onh_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setMgstWarrEndDt(JSPUtil.getParameter(request, prefix + "mgst_warr_end_dt", ""));
		setMgstRunHrsUpdDt(JSPUtil.getParameter(request, prefix + "mgst_run_hrs_upd_dt", ""));
		setCntrChk(JSPUtil.getParameter(request, prefix + "cntr_chk", ""));
		setOnhOfcCd(JSPUtil.getParameter(request, prefix + "onh_ofc_cd", ""));
		setEqSpecNo(JSPUtil.getParameter(request, prefix + "eq_spec_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setAgreementNo(JSPUtil.getParameter(request, prefix + "agreement_no", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setAgmtRefNo(JSPUtil.getParameter(request, prefix + "agmt_ref_no", ""));
		setMgstRunHrs(JSPUtil.getParameter(request, prefix + "mgst_run_hrs", ""));
		setDamageChk(JSPUtil.getParameter(request, prefix + "damage_chk", ""));
		setAtchChs(JSPUtil.getParameter(request, prefix + "atch_chs", ""));
		setAtchCntr(JSPUtil.getParameter(request, prefix + "atch_cntr", ""));
		setMgstMchnSerNo(JSPUtil.getParameter(request, prefix + "mgst_mchn_ser_no", ""));
		setMgstVltgCapa(JSPUtil.getParameter(request, prefix + "mgst_vltg_capa", ""));
		setAgmtLstmCd(JSPUtil.getParameter(request, prefix + "agmt_lstm_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setAciacDivCd(JSPUtil.getParameter(request, prefix + "aciac_div_cd", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setMftDt(JSPUtil.getParameter(request, prefix + "mft_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setChsChk(JSPUtil.getParameter(request, prefix + "chs_chk", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setMasterSaveFlag(JSPUtil.getParameter(request, prefix + "master_save_flag", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MGSEquipmentINVO[]
	 */
	public MGSEquipmentINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MGSEquipmentINVO[]
	 */
	public MGSEquipmentINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MGSEquipmentINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] orgAtchDt = (JSPUtil.getParameter(request, prefix	+ "org_atch_dt", length));
			String[] mgstFuelCapa = (JSPUtil.getParameter(request, prefix	+ "mgst_fuel_capa", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix	+ "crnt_yd_cd", length));
			String[] bareChk = (JSPUtil.getParameter(request, prefix	+ "bare_chk", length));
			String[] onhDt = (JSPUtil.getParameter(request, prefix	+ "onh_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] mgstWarrEndDt = (JSPUtil.getParameter(request, prefix	+ "mgst_warr_end_dt", length));
			String[] mgstRunHrsUpdDt = (JSPUtil.getParameter(request, prefix	+ "mgst_run_hrs_upd_dt", length));
			String[] cntrChk = (JSPUtil.getParameter(request, prefix	+ "cntr_chk", length));
			String[] onhOfcCd = (JSPUtil.getParameter(request, prefix	+ "onh_ofc_cd", length));
			String[] eqSpecNo = (JSPUtil.getParameter(request, prefix	+ "eq_spec_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] agreementNo = (JSPUtil.getParameter(request, prefix	+ "agreement_no", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] agmtRefNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ref_no", length));
			String[] mgstRunHrs = (JSPUtil.getParameter(request, prefix	+ "mgst_run_hrs", length));
			String[] damageChk = (JSPUtil.getParameter(request, prefix	+ "damage_chk", length));
			String[] atchChs = (JSPUtil.getParameter(request, prefix	+ "atch_chs", length));
			String[] atchCntr = (JSPUtil.getParameter(request, prefix	+ "atch_cntr", length));
			String[] mgstMchnSerNo = (JSPUtil.getParameter(request, prefix	+ "mgst_mchn_ser_no", length));
			String[] mgstVltgCapa = (JSPUtil.getParameter(request, prefix	+ "mgst_vltg_capa", length));
			String[] agmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "agmt_lstm_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] aciacDivCd = (JSPUtil.getParameter(request, prefix	+ "aciac_div_cd", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] mftDt = (JSPUtil.getParameter(request, prefix	+ "mft_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] chsChk = (JSPUtil.getParameter(request, prefix	+ "chs_chk", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] masterSaveFlag = (JSPUtil.getParameter(request, prefix	+ "master_save_flag", length));
			
			for (int i = 0; i < length; i++) {
				model = new MGSEquipmentINVO();
				if (orgAtchDt[i] != null)
					model.setOrgAtchDt(orgAtchDt[i]);
				if (mgstFuelCapa[i] != null)
					model.setMgstFuelCapa(mgstFuelCapa[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);
				if (bareChk[i] != null)
					model.setBareChk(bareChk[i]);
				if (onhDt[i] != null)
					model.setOnhDt(onhDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (mgstWarrEndDt[i] != null)
					model.setMgstWarrEndDt(mgstWarrEndDt[i]);
				if (mgstRunHrsUpdDt[i] != null)
					model.setMgstRunHrsUpdDt(mgstRunHrsUpdDt[i]);
				if (cntrChk[i] != null)
					model.setCntrChk(cntrChk[i]);
				if (onhOfcCd[i] != null)
					model.setOnhOfcCd(onhOfcCd[i]);
				if (eqSpecNo[i] != null)
					model.setEqSpecNo(eqSpecNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (agreementNo[i] != null)
					model.setAgreementNo(agreementNo[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (agmtRefNo[i] != null)
					model.setAgmtRefNo(agmtRefNo[i]);
				if (mgstRunHrs[i] != null)
					model.setMgstRunHrs(mgstRunHrs[i]);
				if (damageChk[i] != null)
					model.setDamageChk(damageChk[i]);
				if (atchChs[i] != null)
					model.setAtchChs(atchChs[i]);
				if (atchCntr[i] != null)
					model.setAtchCntr(atchCntr[i]);
				if (mgstMchnSerNo[i] != null)
					model.setMgstMchnSerNo(mgstMchnSerNo[i]);
				if (mgstVltgCapa[i] != null)
					model.setMgstVltgCapa(mgstVltgCapa[i]);
				if (agmtLstmCd[i] != null)
					model.setAgmtLstmCd(agmtLstmCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (aciacDivCd[i] != null)
					model.setAciacDivCd(aciacDivCd[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (mftDt[i] != null)
					model.setMftDt(mftDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (chsChk[i] != null)
					model.setChsChk(chsChk[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (masterSaveFlag[i] != null)
					model.setMasterSaveFlag(masterSaveFlag[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMGSEquipmentINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MGSEquipmentINVO[]
	 */
	public MGSEquipmentINVO[] getMGSEquipmentINVOs(){
		MGSEquipmentINVO[] vos = (MGSEquipmentINVO[])models.toArray(new MGSEquipmentINVO[models.size()]);
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
		this.orgAtchDt = this.orgAtchDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstFuelCapa = this.mgstFuelCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd = this.crntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bareChk = this.bareChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDt = this.onhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstWarrEndDt = this.mgstWarrEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstRunHrsUpdDt = this.mgstRunHrsUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrChk = this.cntrChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhOfcCd = this.onhOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSpecNo = this.eqSpecNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agreementNo = this.agreementNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRefNo = this.agmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstRunHrs = this.mgstRunHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.damageChk = this.damageChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchChs = this.atchChs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchCntr = this.atchCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstMchnSerNo = this.mgstMchnSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstVltgCapa = this.mgstVltgCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstmCd = this.agmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aciacDivCd = this.aciacDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftDt = this.mftDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chsChk = this.chsChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masterSaveFlag = this.masterSaveFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
