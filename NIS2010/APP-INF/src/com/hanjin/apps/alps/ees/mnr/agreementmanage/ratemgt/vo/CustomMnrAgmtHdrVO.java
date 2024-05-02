/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomMnrAgmtHdrVO.java
*@FileTitle : CustomMnrAgmtHdrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.18
*@LastModifier : Chagn Young Kim
*@LastVersion : 1.0
* 2009.07.03 박명신 
* 1.0 Creation
* History
* 2014.11 Chagn Young Kim 10만불 결제관련
* 2014-12-18 Chang Young Kim [CHM-201433304] CSR 승인 강화에 따른 ALPS MNR-AGMT에 GW Document Contract Link 관련 추가 요청 사항
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo;

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
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
	
public class CustomMnrAgmtHdrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrAgmtHdrVO> models = new ArrayList<CustomMnrAgmtHdrVO>();
	
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String agmtDisplayType = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String agmtDt = null;
	/* Column Info */
	private String agmtOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String agmtRmk = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String agmtRefNo = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String payTermDys = null;
	/* Column Info */
	private String trsmModCd = null;
	/* Column Info */
	private String agmtPrifix = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String isversionup = null;
	/* Column Info */
	private String agmtTypeTpsz = null;
	/* Column Info */
	private String agmtLstVerFlg = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String agmtOfcCtyCd = null;
	/* Column Info */
	private String trfNo = null;
	/* Column Info */
	private String agmtVerNo = null;
	/* Column Info */
	private String ediId = null;
	/* Column Info */
	private String eqTypeName = null; 
	/* Column Info */
	private String MnrMeasUtNm = null;
	/* Column Info */
	private String gwUqDocTitNm = null;
	/* Column Info */
	private String gwUqDocNo = null;
	/* Column Info */
	private String fileAtchFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomMnrAgmtHdrVO() {}

	public CustomMnrAgmtHdrVO(String ibflag, String pagerows, String currCd, String deltFlg, String agmtDt, String creDt, String agmtDisplayType, String agmtOfcCd, String vndrNm, String effDt, String agmtRmk, String expDt, String updUsrId, String updDt, String agmtRefNo, String agmtSeq, String agmtNo, String eqKndCd, String payTermDys, String agmtPrifix, String creUsrId, String isversionup, String agmtTypeTpsz, String agmtLstVerFlg, String trfNo, String agmtOfcCtyCd, String vndrSeq, String agmtVerNo, String trsmModCd,String ediId,String eqTypeName,String MnrMeasUtNm, String gwUqDocTitNm, String gwUqDocNo, String fileAtchFlg) {
		this.currCd = currCd;
		this.deltFlg = deltFlg;
		this.agmtDisplayType = agmtDisplayType;
		this.creDt = creDt;
		this.agmtDt = agmtDt;
		this.agmtOfcCd = agmtOfcCd;
		this.pagerows = pagerows;
		this.vndrNm = vndrNm;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.agmtRmk = agmtRmk;
		this.expDt = expDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.agmtRefNo = agmtRefNo;
		this.agmtSeq = agmtSeq;
		this.agmtNo = agmtNo;
		this.eqKndCd = eqKndCd;
		this.payTermDys = payTermDys;
		this.trsmModCd = trsmModCd;
		this.agmtPrifix = agmtPrifix;
		this.creUsrId = creUsrId;
		this.isversionup = isversionup;
		this.agmtTypeTpsz = agmtTypeTpsz;
		this.agmtLstVerFlg = agmtLstVerFlg;
		this.vndrSeq = vndrSeq;
		this.agmtOfcCtyCd = agmtOfcCtyCd;
		this.trfNo = trfNo;
		this.agmtVerNo = agmtVerNo;
		this.ediId = ediId;
		this.eqTypeName = eqTypeName;
		this.MnrMeasUtNm = MnrMeasUtNm;
		this.gwUqDocTitNm = gwUqDocTitNm;
		this.gwUqDocNo = gwUqDocNo;
		this.fileAtchFlg = fileAtchFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("agmt_display_type", getAgmtDisplayType());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("agmt_dt", getAgmtDt());
		this.hashColumns.put("agmt_ofc_cd", getAgmtOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("agmt_rmk", getAgmtRmk());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("agmt_ref_no", getAgmtRefNo());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("pay_term_dys", getPayTermDys());
		this.hashColumns.put("trsm_mod_cd", getTrsmModCd());
		this.hashColumns.put("agmt_prifix", getAgmtPrifix());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("isversionup", getIsversionup());
		this.hashColumns.put("agmt_type_tpsz", getAgmtTypeTpsz());
		this.hashColumns.put("agmt_lst_ver_flg", getAgmtLstVerFlg());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());
		this.hashColumns.put("trf_no", getTrfNo());
		this.hashColumns.put("agmt_ver_no", getAgmtVerNo());
		this.hashColumns.put("edi_id", getEdiId());  
		this.hashColumns.put("eq_type_name", getEqTypeName());  
		this.hashColumns.put("mnr_meas_ut_nm", getMnrMeasUtNm());
		this.hashColumns.put("gw_uq_doc_tit_nm", getGwUqDocTitNm());
		this.hashColumns.put("gw_uq_doc_no", getGwUqDocNo());
		this.hashColumns.put("file_atch_flg", getFileAtchFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("agmt_display_type", "agmtDisplayType");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("agmt_dt", "agmtDt");
		this.hashFields.put("agmt_ofc_cd", "agmtOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("agmt_rmk", "agmtRmk");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("agmt_ref_no", "agmtRefNo");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("pay_term_dys", "payTermDys");
		this.hashFields.put("trsm_mod_cd", "trsmModCd");
		this.hashFields.put("agmt_prifix", "agmtPrifix");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("isversionup", "isversionup");
		this.hashFields.put("agmt_type_tpsz", "agmtTypeTpsz");
		this.hashFields.put("agmt_lst_ver_flg", "agmtLstVerFlg");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
		this.hashFields.put("trf_no", "trfNo");
		this.hashFields.put("agmt_ver_no", "agmtVerNo");
		this.hashFields.put("edi_id", "ediId");
		this.hashFields.put("eq_type_name", "eqTypeName");
		this.hashFields.put("mnr_meas_ut_nm", "MnrMeasUtNm");
		this.hashFields.put("gw_uq_doc_tit_nm", "gwUqDocTitNm");
		this.hashFields.put("gw_uq_doc_no", "gwUqDocNo");
		this.hashFields.put("file_atch_flg", "fileAtchFlg");
		return this.hashFields;
	}
	
	public String getEqTypeName() {
		return eqTypeName;
	}

	public void setEqTypeName(String eqTypeName) {
		this.eqTypeName = eqTypeName;
	}

	/**
	 * Column Info
	 * @return ediId
	 */
	public String getEdiId() {
		return ediId;
	}
	
	/**
	 * Column Info
	 * @param ediId
	 */
	public void setEdiId(String ediId) {
		this.ediId = ediId;
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
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return agmtDisplayType
	 */
	public String getAgmtDisplayType() {
		return this.agmtDisplayType;
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
	 * @return agmtDt
	 */
	public String getAgmtDt() {
		return this.agmtDt;
	}
	
	/**
	 * Column Info
	 * @return agmtOfcCd
	 */
	public String getAgmtOfcCd() {
		return this.agmtOfcCd;
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
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return agmtRmk
	 */
	public String getAgmtRmk() {
		return this.agmtRmk;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
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
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
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
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return payTermDys
	 */
	public String getPayTermDys() {
		return this.payTermDys;
	}
	
	/**
	 * Column Info
	 * @return trsmModCd
	 */
	public String getTrsmModCd() {
		return this.trsmModCd;
	}
	
	/**
	 * Column Info
	 * @return agmtPrifix
	 */
	public String getAgmtPrifix() {
		return this.agmtPrifix;
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
	 * @return isversionup
	 */
	public String getIsversionup() {
		return this.isversionup;
	}
	
	/**
	 * Column Info
	 * @return agmtTypeTpsz
	 */
	public String getAgmtTypeTpsz() {
		return this.agmtTypeTpsz;
	}
	
	/**
	 * Column Info
	 * @return agmtLstVerFlg
	 */
	public String getAgmtLstVerFlg() {
		return this.agmtLstVerFlg;
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
	 * @return agmtOfcCtyCd
	 */
	public String getAgmtOfcCtyCd() {
		return this.agmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return trfNo
	 */
	public String getTrfNo() {
		return this.trfNo;
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
	 * @return MnrMeasUtNm
	 */
	public String getMnrMeasUtNm() {
		return this.MnrMeasUtNm; 
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
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param agmtDisplayType
	 */
	public void setAgmtDisplayType(String agmtDisplayType) {
		this.agmtDisplayType = agmtDisplayType;
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
	 * @param agmtDt
	 */
	public void setAgmtDt(String agmtDt) {
		this.agmtDt = agmtDt;
	}
	
	/**
	 * Column Info
	 * @param agmtOfcCd
	 */
	public void setAgmtOfcCd(String agmtOfcCd) {
		this.agmtOfcCd = agmtOfcCd;
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
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param agmtRmk
	 */
	public void setAgmtRmk(String agmtRmk) {
		this.agmtRmk = agmtRmk;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
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
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
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
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param payTermDys
	 */
	public void setPayTermDys(String payTermDys) {
		this.payTermDys = payTermDys;
	}
	
	/**
	 * Column Info
	 * @param trsmModCd
	 */
	public void setTrsmModCd(String trsmModCd) {
		this.trsmModCd = trsmModCd;
	}
	
	/**
	 * Column Info
	 * @param agmtPrifix
	 */
	public void setAgmtPrifix(String agmtPrifix) {
		this.agmtPrifix = agmtPrifix;
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
	 * @param isversionup
	 */
	public void setIsversionup(String isversionup) {
		this.isversionup = isversionup;
	}
	
	/**
	 * Column Info
	 * @param agmtTypeTpsz
	 */
	public void setAgmtTypeTpsz(String agmtTypeTpsz) {
		this.agmtTypeTpsz = agmtTypeTpsz;
	}
	
	/**
	 * Column Info
	 * @param agmtLstVerFlg
	 */
	public void setAgmtLstVerFlg(String agmtLstVerFlg) {
		this.agmtLstVerFlg = agmtLstVerFlg;
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
	 * @param agmtOfcCtyCd
	 */
	public void setAgmtOfcCtyCd(String agmtOfcCtyCd) {
		this.agmtOfcCtyCd = agmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param trfNo
	 */
	public void setTrfNo(String trfNo) {
		this.trfNo = trfNo;
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
	 * @param mnrMeasUtNm
	 */
	public void setMnrMeasUtNm(String mnrMeasUtNm) {
		this.MnrMeasUtNm = mnrMeasUtNm;
	}
	
	/**
	 * Column Info
	 * @return gwUqDocTitNm
	 */
	public String getGwUqDocTitNm() {
		return this.gwUqDocTitNm;
	}

	/**
	 * Column Info
	 * @return gwUqDocNo
	 */
	public String getGwUqDocNo() {
		return this.gwUqDocNo;
	}
	
	/**
	 * Column Info
	 * @return gwUqDocTitNm
	 */
	public void setGwUqDocTitNm(String gwUqDocTitNm) {
		this.gwUqDocTitNm = gwUqDocTitNm;
	}

	/**
	 * Column Info
	 * @return gwUqDocNo
	 */
	public void setGwUqDocNo(String gwUqDocNo) {
		this.gwUqDocNo = gwUqDocNo;
	}
	
	/**
	 * Column Info
	 * @return fileAtchFlg
	 */
	public String getFileAtchFlg() {
		return this.fileAtchFlg;
	}
	
	/**
	 * Column Info
	 * @return fileAtchFlg
	 */
	public void setFileAtchFlg(String fileAtchFlg) {
		this.fileAtchFlg = fileAtchFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setAgmtDisplayType(JSPUtil.getParameter(request, "agmt_display_type", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setAgmtDt(JSPUtil.getParameter(request, "agmt_dt", ""));
		setAgmtOfcCd(JSPUtil.getParameter(request, "agmt_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVndrNm(JSPUtil.getParameter(request, "vndr_nm", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAgmtRmk(JSPUtil.getParameter(request, "agmt_rmk", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setAgmtRefNo(JSPUtil.getParameter(request, "agmt_ref_no", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setPayTermDys(JSPUtil.getParameter(request, "pay_term_dys", ""));
		setTrsmModCd(JSPUtil.getParameter(request, "trsm_mod_cd", ""));
		setAgmtPrifix(JSPUtil.getParameter(request, "agmt_prifix", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIsversionup(JSPUtil.getParameter(request, "isversionup", ""));
		setAgmtTypeTpsz(JSPUtil.getParameter(request, "agmt_type_tpsz", ""));
		setAgmtLstVerFlg(JSPUtil.getParameter(request, "agmt_lst_ver_flg", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setAgmtOfcCtyCd(JSPUtil.getParameter(request, "agmt_ofc_cty_cd", ""));
		setTrfNo(JSPUtil.getParameter(request, "trf_no", ""));
		setAgmtVerNo(JSPUtil.getParameter(request, "agmt_ver_no", ""));
		setEdiId(JSPUtil.getParameter(request, "edi_id", ""));
		setEqTypeName(JSPUtil.getParameter(request, "eq_type_name", ""));
		setMnrMeasUtNm(JSPUtil.getParameter(request, "mnr_meas_ut_nm", ""));
		setGwUqDocTitNm(JSPUtil.getParameter(request, "gw_uq_doc_tit_nm", ""));
		setGwUqDocNo(JSPUtil.getParameter(request, "gw_uq_doc_no", ""));
		setFileAtchFlg(JSPUtil.getParameter(request, "file_atch_flg", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrAgmtHdrVO[]
	 */
	public CustomMnrAgmtHdrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}
	
	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomMnrAgmtHdrVO[]
	 */
	public CustomMnrAgmtHdrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrAgmtHdrVO model = null;
			
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;
  		
  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] agmtDisplayType = (JSPUtil.getParameter(request, prefix	+ "agmt_display_type", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] agmtDt = (JSPUtil.getParameter(request, prefix	+ "agmt_dt", length));
			String[] agmtOfcCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] agmtRmk = (JSPUtil.getParameter(request, prefix	+ "agmt_rmk", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] agmtRefNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ref_no", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] payTermDys = (JSPUtil.getParameter(request, prefix	+ "pay_term_dys", length));
			String[] trsmModCd = (JSPUtil.getParameter(request, prefix	+ "trsm_mod_cd", length));
			String[] agmtPrifix = (JSPUtil.getParameter(request, prefix	+ "agmt_prifix", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] isversionup = (JSPUtil.getParameter(request, prefix	+ "isversionup", length));
			String[] agmtTypeTpsz = (JSPUtil.getParameter(request, prefix	+ "agmt_type_tpsz", length));
			String[] agmtLstVerFlg = (JSPUtil.getParameter(request, prefix	+ "agmt_lst_ver_flg", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] agmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cty_cd", length));
			String[] trfNo = (JSPUtil.getParameter(request, prefix	+ "trf_no", length));
			String[] agmtVerNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ver_no", length));
			String[] ediId = (JSPUtil.getParameter(request, prefix	+ "edi_id", length));
			String[] eqTypeName = (JSPUtil.getParameter(request, prefix	+ "eq_type_name", length));
			String[] MnrMeasUtNm = (JSPUtil.getParameter(request, prefix	+ "mnr_meas_ut_nm", length));
			String[] gwUqDocTitNm = (JSPUtil.getParameter(request, prefix + "gw_uq_doc_tit_nm", length));
			String[] gwUqDocNo = (JSPUtil.getParameter(request, prefix + "gw_uq_doc_no", length));
			String[] fileAtchFlg = (JSPUtil.getParameter(request, prefix + "file_atch_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrAgmtHdrVO();
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (agmtDisplayType[i] != null)
					model.setAgmtDisplayType(agmtDisplayType[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (agmtDt[i] != null)
					model.setAgmtDt(agmtDt[i]);
				if (agmtOfcCd[i] != null)
					model.setAgmtOfcCd(agmtOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (agmtRmk[i] != null)
					model.setAgmtRmk(agmtRmk[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (agmtRefNo[i] != null)
					model.setAgmtRefNo(agmtRefNo[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (payTermDys[i] != null)
					model.setPayTermDys(payTermDys[i]);
				if (trsmModCd[i] != null)
					model.setTrsmModCd(trsmModCd[i]);
				if (agmtPrifix[i] != null)
					model.setAgmtPrifix(agmtPrifix[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (isversionup[i] != null)
					model.setIsversionup(isversionup[i]);
				if (agmtTypeTpsz[i] != null)
					model.setAgmtTypeTpsz(agmtTypeTpsz[i]);
				if (agmtLstVerFlg[i] != null)
					model.setAgmtLstVerFlg(agmtLstVerFlg[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (agmtOfcCtyCd[i] != null)
					model.setAgmtOfcCtyCd(agmtOfcCtyCd[i]);
				if (trfNo[i] != null)
					model.setTrfNo(trfNo[i]);
				if (agmtVerNo[i] != null)
					model.setAgmtVerNo(agmtVerNo[i]);
				if (ediId[i] != null)
					model.setEdiId(ediId[i]);
				if (eqTypeName[i] != null)
					model.setEqTypeName(eqTypeName[i]);
				if (MnrMeasUtNm[i] != null)  
					model.setMnrMeasUtNm(MnrMeasUtNm[i]);
				if (gwUqDocTitNm[i] != null)
					model.setGwUqDocTitNm(gwUqDocTitNm[i]);
				if (gwUqDocNo[i] != null)
					model.setGwUqDocNo(gwUqDocNo[i]);
				if (fileAtchFlg[i] != null)
					model.setFileAtchFlg(fileAtchFlg[i]);
				models.add(model); 
			}
			
		} catch (Exception e) {
			return null;
		}	 
		return getCustomMnrAgmtHdrVOs();
	}
	
	/**
	 * VO 배열을 반환
	 * @return CustomMnrAgmtHdrVO[]
	 */
	public CustomMnrAgmtHdrVO[] getCustomMnrAgmtHdrVOs(){
		CustomMnrAgmtHdrVO[] vos = (CustomMnrAgmtHdrVO[])models.toArray(new CustomMnrAgmtHdrVO[models.size()]);
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
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtDisplayType = this.agmtDisplayType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtDt = this.agmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCd = this.agmtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRmk = this.agmtRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRefNo = this.agmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTermDys = this.payTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmModCd = this.trsmModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtPrifix = this.agmtPrifix .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isversionup = this.isversionup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtTypeTpsz = this.agmtTypeTpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstVerFlg = this.agmtLstVerFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCtyCd = this.agmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfNo = this.trfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVerNo = this.agmtVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediId = this.ediId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTypeName = this.eqTypeName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 
		this.MnrMeasUtNm = this.MnrMeasUtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gwUqDocTitNm = this.gwUqDocTitNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gwUqDocNo = this.gwUqDocNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileAtchFlg = this.fileAtchFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	 
} 
