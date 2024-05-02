/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CHSTermStatusMGTVO.java
*@FileTitle : CHSTermStatusMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.06.26 김창식 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo;

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
 * @author 김창식
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CHSTermStatusMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSTermStatusMGTVO> models = new ArrayList<CHSTermStatusMGTVO>();
	
	/* Column Info */
	private String newAgmtOfcCtyCd = null;
	/* Column Info */
	private String newAgmtLstmCd = null;
	/* Column Info */
	private String newAgmtSeq = null;
	/* Column Info */
	private String newAgmtNo = null;
	/* Column Info */
	private String newAgmtVerNo = null;
	/* Column Info */
	private String stsEvntYdCd = null;
	/* Column Info */
	private String onhDt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String newVndrSeq = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String eqAsetStsCd = null;
	/* Column Info */
	private String onhOfcCd = null;
	/* Column Info */
	private String newAgmtRefNo = null;
	/* Column Info */
	private String stsEvntDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String stsEvntOfcCd = null;
	/* Column Info */
	private String agmtRefNo = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String agmtLstmCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String aciacDivCd = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String termCngSeq = null;
	/* Column Info */
	private String stsEvntLocCd = null;
	/* Column Info */
	private String agmtOfcCtyCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String agmtVerNo = null;
	/* Column Info */
	private String eqStsSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSTermStatusMGTVO() {}

	public CHSTermStatusMGTVO(String ibflag, String pagerows, String eqKndCd, String stsEvntDt, String stsEvntOfcCd, String stsEvntLocCd, String stsEvntYdCd, String termCngSeq, String eqStsSeq, String agmtNo, String agmtOfcCtyCd, String agmtSeq, String agmtVerNo, String agmtRefNo, String agmtLstmCd, String vndrSeq, String eqNo, String eqTpszCd, String aciacDivCd, String eqAsetStsCd, String newAgmtNo, String newAgmtOfcCtyCd, String newAgmtSeq, String newAgmtVerNo, String newAgmtRefNo, String newAgmtLstmCd, String newVndrSeq, String onhOfcCd, String onhDt, String creUsrId, String updUsrId) {
		this.newAgmtOfcCtyCd = newAgmtOfcCtyCd;
		this.newAgmtLstmCd = newAgmtLstmCd;
		this.newAgmtSeq = newAgmtSeq;
		this.newAgmtNo = newAgmtNo;
		this.newAgmtVerNo = newAgmtVerNo;
		this.stsEvntYdCd = stsEvntYdCd;
		this.onhDt = onhDt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.newVndrSeq = newVndrSeq;
		this.eqNo = eqNo;
		this.eqAsetStsCd = eqAsetStsCd;
		this.onhOfcCd = onhOfcCd;
		this.newAgmtRefNo = newAgmtRefNo;
		this.stsEvntDt = stsEvntDt;
		this.updUsrId = updUsrId;
		this.stsEvntOfcCd = stsEvntOfcCd;
		this.agmtRefNo = agmtRefNo;
		this.agmtSeq = agmtSeq;
		this.agmtNo = agmtNo;
		this.agmtLstmCd = agmtLstmCd;
		this.eqKndCd = eqKndCd;
		this.aciacDivCd = aciacDivCd;
		this.eqTpszCd = eqTpszCd;
		this.creUsrId = creUsrId;
		this.termCngSeq = termCngSeq;
		this.stsEvntLocCd = stsEvntLocCd;
		this.agmtOfcCtyCd = agmtOfcCtyCd;
		this.vndrSeq = vndrSeq;
		this.agmtVerNo = agmtVerNo;
		this.eqStsSeq = eqStsSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("new_agmt_ofc_cty_cd", getNewAgmtOfcCtyCd());
		this.hashColumns.put("new_agmt_lstm_cd", getNewAgmtLstmCd());
		this.hashColumns.put("new_agmt_seq", getNewAgmtSeq());
		this.hashColumns.put("new_agmt_no", getNewAgmtNo());
		this.hashColumns.put("new_agmt_ver_no", getNewAgmtVerNo());
		this.hashColumns.put("sts_evnt_yd_cd", getStsEvntYdCd());
		this.hashColumns.put("onh_dt", getOnhDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("new_vndr_seq", getNewVndrSeq());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("eq_aset_sts_cd", getEqAsetStsCd());
		this.hashColumns.put("onh_ofc_cd", getOnhOfcCd());
		this.hashColumns.put("new_agmt_ref_no", getNewAgmtRefNo());
		this.hashColumns.put("sts_evnt_dt", getStsEvntDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("sts_evnt_ofc_cd", getStsEvntOfcCd());
		this.hashColumns.put("agmt_ref_no", getAgmtRefNo());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("agmt_lstm_cd", getAgmtLstmCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("aciac_div_cd", getAciacDivCd());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("term_cng_seq", getTermCngSeq());
		this.hashColumns.put("sts_evnt_loc_cd", getStsEvntLocCd());
		this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("agmt_ver_no", getAgmtVerNo());
		this.hashColumns.put("eq_sts_seq", getEqStsSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("new_agmt_ofc_cty_cd", "newAgmtOfcCtyCd");
		this.hashFields.put("new_agmt_lstm_cd", "newAgmtLstmCd");
		this.hashFields.put("new_agmt_seq", "newAgmtSeq");
		this.hashFields.put("new_agmt_no", "newAgmtNo");
		this.hashFields.put("new_agmt_ver_no", "newAgmtVerNo");
		this.hashFields.put("sts_evnt_yd_cd", "stsEvntYdCd");
		this.hashFields.put("onh_dt", "onhDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("new_vndr_seq", "newVndrSeq");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("eq_aset_sts_cd", "eqAsetStsCd");
		this.hashFields.put("onh_ofc_cd", "onhOfcCd");
		this.hashFields.put("new_agmt_ref_no", "newAgmtRefNo");
		this.hashFields.put("sts_evnt_dt", "stsEvntDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("sts_evnt_ofc_cd", "stsEvntOfcCd");
		this.hashFields.put("agmt_ref_no", "agmtRefNo");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("agmt_lstm_cd", "agmtLstmCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("aciac_div_cd", "aciacDivCd");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("term_cng_seq", "termCngSeq");
		this.hashFields.put("sts_evnt_loc_cd", "stsEvntLocCd");
		this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("agmt_ver_no", "agmtVerNo");
		this.hashFields.put("eq_sts_seq", "eqStsSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return newAgmtOfcCtyCd
	 */
	public String getNewAgmtOfcCtyCd() {
		return this.newAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return newAgmtLstmCd
	 */
	public String getNewAgmtLstmCd() {
		return this.newAgmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @return newAgmtSeq
	 */
	public String getNewAgmtSeq() {
		return this.newAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @return newAgmtNo
	 */
	public String getNewAgmtNo() {
		return this.newAgmtNo;
	}
	
	/**
	 * Column Info
	 * @return newAgmtVerNo
	 */
	public String getNewAgmtVerNo() {
		return this.newAgmtVerNo;
	}
	
	/**
	 * Column Info
	 * @return stsEvntYdCd
	 */
	public String getStsEvntYdCd() {
		return this.stsEvntYdCd;
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
	 * @return newVndrSeq
	 */
	public String getNewVndrSeq() {
		return this.newVndrSeq;
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
	 * @return eqAsetStsCd
	 */
	public String getEqAsetStsCd() {
		return this.eqAsetStsCd;
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
	 * @return newAgmtRefNo
	 */
	public String getNewAgmtRefNo() {
		return this.newAgmtRefNo;
	}
	
	/**
	 * Column Info
	 * @return stsEvntDt
	 */
	public String getStsEvntDt() {
		return this.stsEvntDt;
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
	 * @return stsEvntOfcCd
	 */
	public String getStsEvntOfcCd() {
		return this.stsEvntOfcCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return termCngSeq
	 */
	public String getTermCngSeq() {
		return this.termCngSeq;
	}
	
	/**
	 * Column Info
	 * @return stsEvntLocCd
	 */
	public String getStsEvntLocCd() {
		return this.stsEvntLocCd;
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
	 * @return agmtVerNo
	 */
	public String getAgmtVerNo() {
		return this.agmtVerNo;
	}
	
	/**
	 * Column Info
	 * @return eqStsSeq
	 */
	public String getEqStsSeq() {
		return this.eqStsSeq;
	}
	

	/**
	 * Column Info
	 * @param newAgmtOfcCtyCd
	 */
	public void setNewAgmtOfcCtyCd(String newAgmtOfcCtyCd) {
		this.newAgmtOfcCtyCd = newAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param newAgmtLstmCd
	 */
	public void setNewAgmtLstmCd(String newAgmtLstmCd) {
		this.newAgmtLstmCd = newAgmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @param newAgmtSeq
	 */
	public void setNewAgmtSeq(String newAgmtSeq) {
		this.newAgmtSeq = newAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @param newAgmtNo
	 */
	public void setNewAgmtNo(String newAgmtNo) {
		this.newAgmtNo = newAgmtNo;
	}
	
	/**
	 * Column Info
	 * @param newAgmtVerNo
	 */
	public void setNewAgmtVerNo(String newAgmtVerNo) {
		this.newAgmtVerNo = newAgmtVerNo;
	}
	
	/**
	 * Column Info
	 * @param stsEvntYdCd
	 */
	public void setStsEvntYdCd(String stsEvntYdCd) {
		this.stsEvntYdCd = stsEvntYdCd;
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
	 * @param newVndrSeq
	 */
	public void setNewVndrSeq(String newVndrSeq) {
		this.newVndrSeq = newVndrSeq;
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
	 * @param eqAsetStsCd
	 */
	public void setEqAsetStsCd(String eqAsetStsCd) {
		this.eqAsetStsCd = eqAsetStsCd;
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
	 * @param newAgmtRefNo
	 */
	public void setNewAgmtRefNo(String newAgmtRefNo) {
		this.newAgmtRefNo = newAgmtRefNo;
	}
	
	/**
	 * Column Info
	 * @param stsEvntDt
	 */
	public void setStsEvntDt(String stsEvntDt) {
		this.stsEvntDt = stsEvntDt;
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
	 * @param stsEvntOfcCd
	 */
	public void setStsEvntOfcCd(String stsEvntOfcCd) {
		this.stsEvntOfcCd = stsEvntOfcCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param termCngSeq
	 */
	public void setTermCngSeq(String termCngSeq) {
		this.termCngSeq = termCngSeq;
	}
	
	/**
	 * Column Info
	 * @param stsEvntLocCd
	 */
	public void setStsEvntLocCd(String stsEvntLocCd) {
		this.stsEvntLocCd = stsEvntLocCd;
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
	 * @param agmtVerNo
	 */
	public void setAgmtVerNo(String agmtVerNo) {
		this.agmtVerNo = agmtVerNo;
	}
	
	/**
	 * Column Info
	 * @param eqStsSeq
	 */
	public void setEqStsSeq(String eqStsSeq) {
		this.eqStsSeq = eqStsSeq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setNewAgmtOfcCtyCd(JSPUtil.getParameter(request, "new_agmt_ofc_cty_cd", ""));
		setNewAgmtLstmCd(JSPUtil.getParameter(request, "new_agmt_lstm_cd", ""));
		setNewAgmtSeq(JSPUtil.getParameter(request, "new_agmt_seq", ""));
		setNewAgmtNo(JSPUtil.getParameter(request, "new_agmt_no", ""));
		setNewAgmtVerNo(JSPUtil.getParameter(request, "new_agmt_ver_no", ""));
		setStsEvntYdCd(JSPUtil.getParameter(request, "sts_evnt_yd_cd", ""));
		setOnhDt(JSPUtil.getParameter(request, "onh_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setNewVndrSeq(JSPUtil.getParameter(request, "new_vndr_seq", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setEqAsetStsCd(JSPUtil.getParameter(request, "eq_aset_sts_cd", ""));
		setOnhOfcCd(JSPUtil.getParameter(request, "onh_ofc_cd", ""));
		setNewAgmtRefNo(JSPUtil.getParameter(request, "new_agmt_ref_no", ""));
		setStsEvntDt(JSPUtil.getParameter(request, "sts_evnt_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setStsEvntOfcCd(JSPUtil.getParameter(request, "sts_evnt_ofc_cd", ""));
		setAgmtRefNo(JSPUtil.getParameter(request, "agmt_ref_no", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setAgmtLstmCd(JSPUtil.getParameter(request, "agmt_lstm_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setAciacDivCd(JSPUtil.getParameter(request, "aciac_div_cd", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setTermCngSeq(JSPUtil.getParameter(request, "term_cng_seq", ""));
		setStsEvntLocCd(JSPUtil.getParameter(request, "sts_evnt_loc_cd", ""));
		setAgmtOfcCtyCd(JSPUtil.getParameter(request, "agmt_ofc_cty_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setAgmtVerNo(JSPUtil.getParameter(request, "agmt_ver_no", ""));
		setEqStsSeq(JSPUtil.getParameter(request, "eq_sts_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSTermStatusMGTVO[]
	 */
	public CHSTermStatusMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSTermStatusMGTVO[]
	 */
	public CHSTermStatusMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSTermStatusMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] newAgmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "new_agmt_ofc_cty_cd", length));
			String[] newAgmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "new_agmt_lstm_cd", length));
			String[] newAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "new_agmt_seq", length));
			String[] newAgmtNo = (JSPUtil.getParameter(request, prefix	+ "new_agmt_no", length));
			String[] newAgmtVerNo = (JSPUtil.getParameter(request, prefix	+ "new_agmt_ver_no", length));
			String[] stsEvntYdCd = (JSPUtil.getParameter(request, prefix	+ "sts_evnt_yd_cd", length));
			String[] onhDt = (JSPUtil.getParameter(request, prefix	+ "onh_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] newVndrSeq = (JSPUtil.getParameter(request, prefix	+ "new_vndr_seq", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] eqAsetStsCd = (JSPUtil.getParameter(request, prefix	+ "eq_aset_sts_cd", length));
			String[] onhOfcCd = (JSPUtil.getParameter(request, prefix	+ "onh_ofc_cd", length));
			String[] newAgmtRefNo = (JSPUtil.getParameter(request, prefix	+ "new_agmt_ref_no", length));
			String[] stsEvntDt = (JSPUtil.getParameter(request, prefix	+ "sts_evnt_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] stsEvntOfcCd = (JSPUtil.getParameter(request, prefix	+ "sts_evnt_ofc_cd", length));
			String[] agmtRefNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ref_no", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] agmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "agmt_lstm_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] aciacDivCd = (JSPUtil.getParameter(request, prefix	+ "aciac_div_cd", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] termCngSeq = (JSPUtil.getParameter(request, prefix	+ "term_cng_seq", length));
			String[] stsEvntLocCd = (JSPUtil.getParameter(request, prefix	+ "sts_evnt_loc_cd", length));
			String[] agmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cty_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] agmtVerNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ver_no", length));
			String[] eqStsSeq = (JSPUtil.getParameter(request, prefix	+ "eq_sts_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSTermStatusMGTVO();
				if (newAgmtOfcCtyCd[i] != null)
					model.setNewAgmtOfcCtyCd(newAgmtOfcCtyCd[i]);
				if (newAgmtLstmCd[i] != null)
					model.setNewAgmtLstmCd(newAgmtLstmCd[i]);
				if (newAgmtSeq[i] != null)
					model.setNewAgmtSeq(newAgmtSeq[i]);
				if (newAgmtNo[i] != null)
					model.setNewAgmtNo(newAgmtNo[i]);
				if (newAgmtVerNo[i] != null)
					model.setNewAgmtVerNo(newAgmtVerNo[i]);
				if (stsEvntYdCd[i] != null)
					model.setStsEvntYdCd(stsEvntYdCd[i]);
				if (onhDt[i] != null)
					model.setOnhDt(onhDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (newVndrSeq[i] != null)
					model.setNewVndrSeq(newVndrSeq[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (eqAsetStsCd[i] != null)
					model.setEqAsetStsCd(eqAsetStsCd[i]);
				if (onhOfcCd[i] != null)
					model.setOnhOfcCd(onhOfcCd[i]);
				if (newAgmtRefNo[i] != null)
					model.setNewAgmtRefNo(newAgmtRefNo[i]);
				if (stsEvntDt[i] != null)
					model.setStsEvntDt(stsEvntDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (stsEvntOfcCd[i] != null)
					model.setStsEvntOfcCd(stsEvntOfcCd[i]);
				if (agmtRefNo[i] != null)
					model.setAgmtRefNo(agmtRefNo[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (agmtLstmCd[i] != null)
					model.setAgmtLstmCd(agmtLstmCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (aciacDivCd[i] != null)
					model.setAciacDivCd(aciacDivCd[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (termCngSeq[i] != null)
					model.setTermCngSeq(termCngSeq[i]);
				if (stsEvntLocCd[i] != null)
					model.setStsEvntLocCd(stsEvntLocCd[i]);
				if (agmtOfcCtyCd[i] != null)
					model.setAgmtOfcCtyCd(agmtOfcCtyCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (agmtVerNo[i] != null)
					model.setAgmtVerNo(agmtVerNo[i]);
				if (eqStsSeq[i] != null)
					model.setEqStsSeq(eqStsSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSTermStatusMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSTermStatusMGTVO[]
	 */
	public CHSTermStatusMGTVO[] getCHSTermStatusMGTVOs(){
		CHSTermStatusMGTVO[] vos = (CHSTermStatusMGTVO[])models.toArray(new CHSTermStatusMGTVO[models.size()]);
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
		this.newAgmtOfcCtyCd = this.newAgmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newAgmtLstmCd = this.newAgmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newAgmtSeq = this.newAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newAgmtNo = this.newAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newAgmtVerNo = this.newAgmtVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsEvntYdCd = this.stsEvntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDt = this.onhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newVndrSeq = this.newVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqAsetStsCd = this.eqAsetStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhOfcCd = this.onhOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newAgmtRefNo = this.newAgmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsEvntDt = this.stsEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsEvntOfcCd = this.stsEvntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRefNo = this.agmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstmCd = this.agmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aciacDivCd = this.aciacDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.termCngSeq = this.termCngSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsEvntLocCd = this.stsEvntLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCtyCd = this.agmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVerNo = this.agmtVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqStsSeq = this.eqStsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
