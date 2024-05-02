/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CustomMnrFlgHisVO.java
*@FileTitle : CustomMnrFlgHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.12
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2011.01.12 김영오
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo;

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
 * @author 김영오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomMnrFlgHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CustomMnrFlgHisVO> models = new ArrayList<CustomMnrFlgHisVO>();

	/* Column Info */
	private String mnrHngrTrfOtrDesc = null;
	/* Column Info */
	private String hngrBarTtlQty = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String crntYdCd = null;
	/* Column Info */
	private String hngrBarAmdQty = null;
	/* Column Info */
	private String mnrStsRmk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String barAtchKnt = null;
	/* Column Info */
	private String mnrOrdOfcCtyCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String mnrFlgInpDt = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String mnrHngrBarTpCd = null;
	/* Column Info */
	private String mnrLostHngrQty = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String eqMvmtIdNo = null;
	/* Column Info */
	private String mnrDispHngrQty = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String mnrHngrDtlOffrDesc = null;
	/* Column Info */
	private String mnrFlgTpCd = null;
	/* Column Info */
	private String hngrBarAtchKnt = null;
	/* Column Info */
	private String mnrFlgYdCd = null;
	/* Column Info */
	private String mvmtCd = null;
	/* Column Info */
	private String mnrFlgInpTpCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String actInvtQty = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String mnrHngrRckCd = null;
	/* Column Info */
	private String mnrOrdSeq = null;
	/* Column Info */
	private String mnrStsFlg = null;
	/* Column Info */
	private String mnrHngrFlg = null;
	/* Column Info */
	private String mnrFlgSeq = null;
	/* Column Info */
	private String mnrHngrDmgQty = null;
	/* Column Info */
	private String mnrFlgCmplDt = null;
	/* Column Info */
	private String mnrFlgRmk = null;
	/* Column Info */
	private String mnrHngrTrfCd = null;
	/* Column Info */
	private String eqMvmtYr = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

	public CustomMnrFlgHisVO() {}

	public CustomMnrFlgHisVO(String ibflag, String pagerows, String mnrHngrTrfOtrDesc, String hngrBarTtlQty, String creDt, String crntYdCd, String hngrBarAmdQty, String mnrStsRmk, String mnrOrdOfcCtyCd, String mnrFlgInpDt, String eqNo, String creOfcCd, String mnrHngrBarTpCd, String mnrLostHngrQty, String woNo, String eqMvmtIdNo, String mnrDispHngrQty, String mnrHngrDtlOffrDesc, String mnrFlgTpCd, String hngrBarAtchKnt, String mnrFlgYdCd, String mvmtCd, String mnrFlgInpTpCd, String eqKndCd, String actInvtQty, String eqTpszCd, String ofcCd, String creUsrId, String mnrOrdSeq, String mnrHngrRckCd, String mnrHngrFlg, String mnrStsFlg, String mnrFlgSeq, String mnrFlgRmk, String mnrFlgCmplDt, String mnrHngrDmgQty, String mnrHngrTrfCd, String barAtchKnt, String lstmCd, String eqMvmtYr) {
		this.mnrHngrTrfOtrDesc = mnrHngrTrfOtrDesc;
		this.hngrBarTtlQty = hngrBarTtlQty;
		this.creDt = creDt;
		this.crntYdCd = crntYdCd;
		this.hngrBarAmdQty = hngrBarAmdQty;
		this.mnrStsRmk = mnrStsRmk;
		this.pagerows = pagerows;
		this.barAtchKnt = barAtchKnt;
		this.mnrOrdOfcCtyCd = mnrOrdOfcCtyCd;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.mnrFlgInpDt = mnrFlgInpDt;
		this.creOfcCd = creOfcCd;
		this.mnrHngrBarTpCd = mnrHngrBarTpCd;
		this.mnrLostHngrQty = mnrLostHngrQty;
		this.woNo = woNo;
		this.eqMvmtIdNo = eqMvmtIdNo;
		this.mnrDispHngrQty = mnrDispHngrQty;
		this.lstmCd = lstmCd;
		this.mnrHngrDtlOffrDesc = mnrHngrDtlOffrDesc;
		this.mnrFlgTpCd = mnrFlgTpCd;
		this.hngrBarAtchKnt = hngrBarAtchKnt;
		this.mnrFlgYdCd = mnrFlgYdCd;
		this.mvmtCd = mvmtCd;
		this.mnrFlgInpTpCd = mnrFlgInpTpCd;
		this.eqKndCd = eqKndCd;
		this.actInvtQty = actInvtQty;
		this.eqTpszCd = eqTpszCd;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.mnrHngrRckCd = mnrHngrRckCd;
		this.mnrOrdSeq = mnrOrdSeq;
		this.mnrStsFlg = mnrStsFlg;
		this.mnrHngrFlg = mnrHngrFlg;
		this.mnrFlgSeq = mnrFlgSeq;
		this.mnrHngrDmgQty = mnrHngrDmgQty;
		this.mnrFlgCmplDt = mnrFlgCmplDt;
		this.mnrFlgRmk = mnrFlgRmk;
		this.mnrHngrTrfCd = mnrHngrTrfCd;
		this.eqMvmtYr = eqMvmtYr;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mnr_hngr_trf_otr_desc", getMnrHngrTrfOtrDesc());
		this.hashColumns.put("hngr_bar_ttl_qty", getHngrBarTtlQty());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("hngr_bar_amd_qty", getHngrBarAmdQty());
		this.hashColumns.put("mnr_sts_rmk", getMnrStsRmk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bar_atch_knt", getBarAtchKnt());
		this.hashColumns.put("mnr_ord_ofc_cty_cd", getMnrOrdOfcCtyCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("mnr_flg_inp_dt", getMnrFlgInpDt());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("mnr_hngr_bar_tp_cd", getMnrHngrBarTpCd());
		this.hashColumns.put("mnr_lost_hngr_qty", getMnrLostHngrQty());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("eq_mvmt_id_no", getEqMvmtIdNo());
		this.hashColumns.put("mnr_disp_hngr_qty", getMnrDispHngrQty());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("mnr_hngr_dtl_offr_desc", getMnrHngrDtlOffrDesc());
		this.hashColumns.put("mnr_flg_tp_cd", getMnrFlgTpCd());
		this.hashColumns.put("hngr_bar_atch_knt", getHngrBarAtchKnt());
		this.hashColumns.put("mnr_flg_yd_cd", getMnrFlgYdCd());
		this.hashColumns.put("mvmt_cd", getMvmtCd());
		this.hashColumns.put("mnr_flg_inp_tp_cd", getMnrFlgInpTpCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("act_invt_qty", getActInvtQty());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("mnr_hngr_rck_cd", getMnrHngrRckCd());
		this.hashColumns.put("mnr_ord_seq", getMnrOrdSeq());
		this.hashColumns.put("mnr_sts_flg", getMnrStsFlg());
		this.hashColumns.put("mnr_hngr_flg", getMnrHngrFlg());
		this.hashColumns.put("mnr_flg_seq", getMnrFlgSeq());
		this.hashColumns.put("mnr_hngr_dmg_qty", getMnrHngrDmgQty());
		this.hashColumns.put("mnr_flg_cmpl_dt", getMnrFlgCmplDt());
		this.hashColumns.put("mnr_flg_rmk", getMnrFlgRmk());
		this.hashColumns.put("mnr_hngr_trf_cd", getMnrHngrTrfCd());
		this.hashColumns.put("eq_mvmt_yr", getEqMvmtYr());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mnr_hngr_trf_otr_desc", "mnrHngrTrfOtrDesc");
		this.hashFields.put("hngr_bar_ttl_qty", "hngrBarTtlQty");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("hngr_bar_amd_qty", "hngrBarAmdQty");
		this.hashFields.put("mnr_sts_rmk", "mnrStsRmk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bar_atch_knt", "barAtchKnt");
		this.hashFields.put("mnr_ord_ofc_cty_cd", "mnrOrdOfcCtyCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("mnr_flg_inp_dt", "mnrFlgInpDt");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("mnr_hngr_bar_tp_cd", "mnrHngrBarTpCd");
		this.hashFields.put("mnr_lost_hngr_qty", "mnrLostHngrQty");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("eq_mvmt_id_no", "eqMvmtIdNo");
		this.hashFields.put("mnr_disp_hngr_qty", "mnrDispHngrQty");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("mnr_hngr_dtl_offr_desc", "mnrHngrDtlOffrDesc");
		this.hashFields.put("mnr_flg_tp_cd", "mnrFlgTpCd");
		this.hashFields.put("hngr_bar_atch_knt", "hngrBarAtchKnt");
		this.hashFields.put("mnr_flg_yd_cd", "mnrFlgYdCd");
		this.hashFields.put("mvmt_cd", "mvmtCd");
		this.hashFields.put("mnr_flg_inp_tp_cd", "mnrFlgInpTpCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("act_invt_qty", "actInvtQty");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("mnr_hngr_rck_cd", "mnrHngrRckCd");
		this.hashFields.put("mnr_ord_seq", "mnrOrdSeq");
		this.hashFields.put("mnr_sts_flg", "mnrStsFlg");
		this.hashFields.put("mnr_hngr_flg", "mnrHngrFlg");
		this.hashFields.put("mnr_flg_seq", "mnrFlgSeq");
		this.hashFields.put("mnr_hngr_dmg_qty", "mnrHngrDmgQty");
		this.hashFields.put("mnr_flg_cmpl_dt", "mnrFlgCmplDt");
		this.hashFields.put("mnr_flg_rmk", "mnrFlgRmk");
		this.hashFields.put("mnr_hngr_trf_cd", "mnrHngrTrfCd");
		this.hashFields.put("eq_mvmt_yr", "eqMvmtYr");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return mnrHngrTrfOtrDesc
	 */
	public String getMnrHngrTrfOtrDesc() {
		return this.mnrHngrTrfOtrDesc;
	}

	/**
	 * Column Info
	 * @return hngrBarTtlQty
	 */
	public String getHngrBarTtlQty() {
		return this.hngrBarTtlQty;
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
	 * @return hngrBarAmdQty
	 */
	public String getHngrBarAmdQty() {
		return this.hngrBarAmdQty;
	}

	/**
	 * Column Info
	 * @return mnrStsRmk
	 */
	public String getMnrStsRmk() {
		return this.mnrStsRmk;
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
	 * @return barAtchKnt
	 */
	public String getBarAtchKnt() {
		return this.barAtchKnt;
	}

	/**
	 * Column Info
	 * @return mnrOrdOfcCtyCd
	 */
	public String getMnrOrdOfcCtyCd() {
		return this.mnrOrdOfcCtyCd;
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
	 * @return mnrFlgInpDt
	 */
	public String getMnrFlgInpDt() {
		return this.mnrFlgInpDt;
	}

	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}

	/**
	 * Column Info
	 * @return mnrHngrBarTpCd
	 */
	public String getMnrHngrBarTpCd() {
		return this.mnrHngrBarTpCd;
	}

	/**
	 * Column Info
	 * @return mnrLostHngrQty
	 */
	public String getMnrLostHngrQty() {
		return this.mnrLostHngrQty;
	}

	/**
	 * Column Info
	 * @return woNo
	 */
	public String getWoNo() {
		return this.woNo;
	}

	/**
	 * Column Info
	 * @return eqMvmtIdNo
	 */
	public String getEqMvmtIdNo() {
		return this.eqMvmtIdNo;
	}

	/**
	 * Column Info
	 * @return mnrDispHngrQty
	 */
	public String getMnrDispHngrQty() {
		return this.mnrDispHngrQty;
	}

	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}

	/**
	 * Column Info
	 * @return mnrHngrDtlOffrDesc
	 */
	public String getMnrHngrDtlOffrDesc() {
		return this.mnrHngrDtlOffrDesc;
	}

	/**
	 * Column Info
	 * @return mnrFlgTpCd
	 */
	public String getMnrFlgTpCd() {
		return this.mnrFlgTpCd;
	}

	/**
	 * Column Info
	 * @return hngrBarAtchKnt
	 */
	public String getHngrBarAtchKnt() {
		return this.hngrBarAtchKnt;
	}

	/**
	 * Column Info
	 * @return mnrFlgYdCd
	 */
	public String getMnrFlgYdCd() {
		return this.mnrFlgYdCd;
	}

	/**
	 * Column Info
	 * @return mvmtCd
	 */
	public String getMvmtCd() {
		return this.mvmtCd;
	}

	/**
	 * Column Info
	 * @return mnrFlgInpTpCd
	 */
	public String getMnrFlgInpTpCd() {
		return this.mnrFlgInpTpCd;
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
	 * @return actInvtQty
	 */
	public String getActInvtQty() {
		return this.actInvtQty;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return mnrHngrRckCd
	 */
	public String getMnrHngrRckCd() {
		return this.mnrHngrRckCd;
	}

	/**
	 * Column Info
	 * @return mnrOrdSeq
	 */
	public String getMnrOrdSeq() {
		return this.mnrOrdSeq;
	}

	/**
	 * Column Info
	 * @return mnrStsFlg
	 */
	public String getMnrStsFlg() {
		return this.mnrStsFlg;
	}

	/**
	 * Column Info
	 * @return mnrHngrFlg
	 */
	public String getMnrHngrFlg() {
		return this.mnrHngrFlg;
	}

	/**
	 * Column Info
	 * @return mnrFlgSeq
	 */
	public String getMnrFlgSeq() {
		return this.mnrFlgSeq;
	}

	/**
	 * Column Info
	 * @return mnrHngrDmgQty
	 */
	public String getMnrHngrDmgQty() {
		return this.mnrHngrDmgQty;
	}

	/**
	 * Column Info
	 * @return mnrFlgCmplDt
	 */
	public String getMnrFlgCmplDt() {
		return this.mnrFlgCmplDt;
	}

	/**
	 * Column Info
	 * @return mnrFlgRmk
	 */
	public String getMnrFlgRmk() {
		return this.mnrFlgRmk;
	}

	/**
	 * Column Info
	 * @return mnrHngrTrfCd
	 */
	public String getMnrHngrTrfCd() {
		return this.mnrHngrTrfCd;
	}

	/**
	 * Column Info
	 * @return eqMvmtYr
	 */
	public String getEqMvmtYr() {
		return this.eqMvmtYr;
	}


	/**
	 * Column Info
	 * @param mnrHngrTrfOtrDesc
	 */
	public void setMnrHngrTrfOtrDesc(String mnrHngrTrfOtrDesc) {
		this.mnrHngrTrfOtrDesc = mnrHngrTrfOtrDesc;
	}

	/**
	 * Column Info
	 * @param hngrBarTtlQty
	 */
	public void setHngrBarTtlQty(String hngrBarTtlQty) {
		this.hngrBarTtlQty = hngrBarTtlQty;
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
	 * @param hngrBarAmdQty
	 */
	public void setHngrBarAmdQty(String hngrBarAmdQty) {
		this.hngrBarAmdQty = hngrBarAmdQty;
	}

	/**
	 * Column Info
	 * @param mnrStsRmk
	 */
	public void setMnrStsRmk(String mnrStsRmk) {
		this.mnrStsRmk = mnrStsRmk;
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
	 * @param barAtchKnt
	 */
	public void setBarAtchKnt(String barAtchKnt) {
		this.barAtchKnt = barAtchKnt;
	}

	/**
	 * Column Info
	 * @param mnrOrdOfcCtyCd
	 */
	public void setMnrOrdOfcCtyCd(String mnrOrdOfcCtyCd) {
		this.mnrOrdOfcCtyCd = mnrOrdOfcCtyCd;
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
	 * @param mnrFlgInpDt
	 */
	public void setMnrFlgInpDt(String mnrFlgInpDt) {
		this.mnrFlgInpDt = mnrFlgInpDt;
	}

	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}

	/**
	 * Column Info
	 * @param mnrHngrBarTpCd
	 */
	public void setMnrHngrBarTpCd(String mnrHngrBarTpCd) {
		this.mnrHngrBarTpCd = mnrHngrBarTpCd;
	}

	/**
	 * Column Info
	 * @param mnrLostHngrQty
	 */
	public void setMnrLostHngrQty(String mnrLostHngrQty) {
		this.mnrLostHngrQty = mnrLostHngrQty;
	}

	/**
	 * Column Info
	 * @param woNo
	 */
	public void setWoNo(String woNo) {
		this.woNo = woNo;
	}

	/**
	 * Column Info
	 * @param eqMvmtIdNo
	 */
	public void setEqMvmtIdNo(String eqMvmtIdNo) {
		this.eqMvmtIdNo = eqMvmtIdNo;
	}

	/**
	 * Column Info
	 * @param mnrDispHngrQty
	 */
	public void setMnrDispHngrQty(String mnrDispHngrQty) {
		this.mnrDispHngrQty = mnrDispHngrQty;
	}

	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}

	/**
	 * Column Info
	 * @param mnrHngrDtlOffrDesc
	 */
	public void setMnrHngrDtlOffrDesc(String mnrHngrDtlOffrDesc) {
		this.mnrHngrDtlOffrDesc = mnrHngrDtlOffrDesc;
	}

	/**
	 * Column Info
	 * @param mnrFlgTpCd
	 */
	public void setMnrFlgTpCd(String mnrFlgTpCd) {
		this.mnrFlgTpCd = mnrFlgTpCd;
	}

	/**
	 * Column Info
	 * @param hngrBarAtchKnt
	 */
	public void setHngrBarAtchKnt(String hngrBarAtchKnt) {
		this.hngrBarAtchKnt = hngrBarAtchKnt;
	}

	/**
	 * Column Info
	 * @param mnrFlgYdCd
	 */
	public void setMnrFlgYdCd(String mnrFlgYdCd) {
		this.mnrFlgYdCd = mnrFlgYdCd;
	}

	/**
	 * Column Info
	 * @param mvmtCd
	 */
	public void setMvmtCd(String mvmtCd) {
		this.mvmtCd = mvmtCd;
	}

	/**
	 * Column Info
	 * @param mnrFlgInpTpCd
	 */
	public void setMnrFlgInpTpCd(String mnrFlgInpTpCd) {
		this.mnrFlgInpTpCd = mnrFlgInpTpCd;
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
	 * @param actInvtQty
	 */
	public void setActInvtQty(String actInvtQty) {
		this.actInvtQty = actInvtQty;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param mnrHngrRckCd
	 */
	public void setMnrHngrRckCd(String mnrHngrRckCd) {
		this.mnrHngrRckCd = mnrHngrRckCd;
	}

	/**
	 * Column Info
	 * @param mnrOrdSeq
	 */
	public void setMnrOrdSeq(String mnrOrdSeq) {
		this.mnrOrdSeq = mnrOrdSeq;
	}

	/**
	 * Column Info
	 * @param mnrStsFlg
	 */
	public void setMnrStsFlg(String mnrStsFlg) {
		this.mnrStsFlg = mnrStsFlg;
	}

	/**
	 * Column Info
	 * @param mnrHngrFlg
	 */
	public void setMnrHngrFlg(String mnrHngrFlg) {
		this.mnrHngrFlg = mnrHngrFlg;
	}

	/**
	 * Column Info
	 * @param mnrFlgSeq
	 */
	public void setMnrFlgSeq(String mnrFlgSeq) {
		this.mnrFlgSeq = mnrFlgSeq;
	}

	/**
	 * Column Info
	 * @param mnrHngrDmgQty
	 */
	public void setMnrHngrDmgQty(String mnrHngrDmgQty) {
		this.mnrHngrDmgQty = mnrHngrDmgQty;
	}

	/**
	 * Column Info
	 * @param mnrFlgCmplDt
	 */
	public void setMnrFlgCmplDt(String mnrFlgCmplDt) {
		this.mnrFlgCmplDt = mnrFlgCmplDt;
	}

	/**
	 * Column Info
	 * @param mnrFlgRmk
	 */
	public void setMnrFlgRmk(String mnrFlgRmk) {
		this.mnrFlgRmk = mnrFlgRmk;
	}

	/**
	 * Column Info
	 * @param mnrHngrTrfCd
	 */
	public void setMnrHngrTrfCd(String mnrHngrTrfCd) {
		this.mnrHngrTrfCd = mnrHngrTrfCd;
	}

	/**
	 * Column Info
	 * @param eqMvmtYr
	 */
	public void setEqMvmtYr(String eqMvmtYr) {
		this.eqMvmtYr = eqMvmtYr;
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
		setMnrHngrTrfOtrDesc(JSPUtil.getParameter(request, prefix + "mnr_hngr_trf_otr_desc", ""));
		setHngrBarTtlQty(JSPUtil.getParameter(request, prefix + "hngr_bar_ttl_qty", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCrntYdCd(JSPUtil.getParameter(request, prefix + "crnt_yd_cd", ""));
		setHngrBarAmdQty(JSPUtil.getParameter(request, prefix + "hngr_bar_amd_qty", ""));
		setMnrStsRmk(JSPUtil.getParameter(request, prefix + "mnr_sts_rmk", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBarAtchKnt(JSPUtil.getParameter(request, prefix + "bar_atch_knt", ""));
		setMnrOrdOfcCtyCd(JSPUtil.getParameter(request, prefix + "mnr_ord_ofc_cty_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setMnrFlgInpDt(JSPUtil.getParameter(request, prefix + "mnr_flg_inp_dt", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setMnrHngrBarTpCd(JSPUtil.getParameter(request, prefix + "mnr_hngr_bar_tp_cd", ""));
		setMnrLostHngrQty(JSPUtil.getParameter(request, prefix + "mnr_lost_hngr_qty", ""));
		setWoNo(JSPUtil.getParameter(request, prefix + "wo_no", ""));
		setEqMvmtIdNo(JSPUtil.getParameter(request, prefix + "eq_mvmt_id_no", ""));
		setMnrDispHngrQty(JSPUtil.getParameter(request, prefix + "mnr_disp_hngr_qty", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setMnrHngrDtlOffrDesc(JSPUtil.getParameter(request, prefix + "mnr_hngr_dtl_offr_desc", ""));
		setMnrFlgTpCd(JSPUtil.getParameter(request, prefix + "mnr_flg_tp_cd", ""));
		setHngrBarAtchKnt(JSPUtil.getParameter(request, prefix + "hngr_bar_atch_knt", ""));
		setMnrFlgYdCd(JSPUtil.getParameter(request, prefix + "mnr_flg_yd_cd", ""));
		setMvmtCd(JSPUtil.getParameter(request, prefix + "mvmt_cd", ""));
		setMnrFlgInpTpCd(JSPUtil.getParameter(request, prefix + "mnr_flg_inp_tp_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setActInvtQty(JSPUtil.getParameter(request, prefix + "act_invt_qty", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setMnrHngrRckCd(JSPUtil.getParameter(request, prefix + "mnr_hngr_rck_cd", ""));
		setMnrOrdSeq(JSPUtil.getParameter(request, prefix + "mnr_ord_seq", ""));
		setMnrStsFlg(JSPUtil.getParameter(request, prefix + "mnr_sts_flg", ""));
		setMnrHngrFlg(JSPUtil.getParameter(request, prefix + "mnr_hngr_flg", ""));
		setMnrFlgSeq(JSPUtil.getParameter(request, prefix + "mnr_flg_seq", ""));
		setMnrHngrDmgQty(JSPUtil.getParameter(request, prefix + "mnr_hngr_dmg_qty", ""));
		setMnrFlgCmplDt(JSPUtil.getParameter(request, prefix + "mnr_flg_cmpl_dt", ""));
		setMnrFlgRmk(JSPUtil.getParameter(request, prefix + "mnr_flg_rmk", ""));
		setMnrHngrTrfCd(JSPUtil.getParameter(request, prefix + "mnr_hngr_trf_cd", ""));
		setEqMvmtYr(JSPUtil.getParameter(request, prefix + "eq_mvmt_yr", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrFlgHisVO[]
	 */
	public CustomMnrFlgHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CustomMnrFlgHisVO[]
	 */
	public CustomMnrFlgHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrFlgHisVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] mnrHngrTrfOtrDesc = (JSPUtil.getParameter(request, prefix	+ "mnr_hngr_trf_otr_desc", length));
			String[] hngrBarTtlQty = (JSPUtil.getParameter(request, prefix	+ "hngr_bar_ttl_qty", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix	+ "crnt_yd_cd", length));
			String[] hngrBarAmdQty = (JSPUtil.getParameter(request, prefix	+ "hngr_bar_amd_qty", length));
			String[] mnrStsRmk = (JSPUtil.getParameter(request, prefix	+ "mnr_sts_rmk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] barAtchKnt = (JSPUtil.getParameter(request, prefix	+ "bar_atch_knt", length));
			String[] mnrOrdOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "mnr_ord_ofc_cty_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] mnrFlgInpDt = (JSPUtil.getParameter(request, prefix	+ "mnr_flg_inp_dt", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] mnrHngrBarTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_hngr_bar_tp_cd", length));
			String[] mnrLostHngrQty = (JSPUtil.getParameter(request, prefix	+ "mnr_lost_hngr_qty", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] eqMvmtIdNo = (JSPUtil.getParameter(request, prefix	+ "eq_mvmt_id_no", length));
			String[] mnrDispHngrQty = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_hngr_qty", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] mnrHngrDtlOffrDesc = (JSPUtil.getParameter(request, prefix	+ "mnr_hngr_dtl_offr_desc", length));
			String[] mnrFlgTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_flg_tp_cd", length));
			String[] hngrBarAtchKnt = (JSPUtil.getParameter(request, prefix	+ "hngr_bar_atch_knt", length));
			String[] mnrFlgYdCd = (JSPUtil.getParameter(request, prefix	+ "mnr_flg_yd_cd", length));
			String[] mvmtCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_cd", length));
			String[] mnrFlgInpTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_flg_inp_tp_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] actInvtQty = (JSPUtil.getParameter(request, prefix	+ "act_invt_qty", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] mnrHngrRckCd = (JSPUtil.getParameter(request, prefix	+ "mnr_hngr_rck_cd", length));
			String[] mnrOrdSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_ord_seq", length));
			String[] mnrStsFlg = (JSPUtil.getParameter(request, prefix	+ "mnr_sts_flg", length));
			String[] mnrHngrFlg = (JSPUtil.getParameter(request, prefix	+ "mnr_hngr_flg", length));
			String[] mnrFlgSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_flg_seq", length));
			String[] mnrHngrDmgQty = (JSPUtil.getParameter(request, prefix	+ "mnr_hngr_dmg_qty", length));
			String[] mnrFlgCmplDt = (JSPUtil.getParameter(request, prefix	+ "mnr_flg_cmpl_dt", length));
			String[] mnrFlgRmk = (JSPUtil.getParameter(request, prefix	+ "mnr_flg_rmk", length));
			String[] mnrHngrTrfCd = (JSPUtil.getParameter(request, prefix	+ "mnr_hngr_trf_cd", length));
			String[] eqMvmtYr = (JSPUtil.getParameter(request, prefix	+ "eq_mvmt_yr", length));

			for (int i = 0; i < length; i++) {
				model = new CustomMnrFlgHisVO();
				if (mnrHngrTrfOtrDesc[i] != null)
					model.setMnrHngrTrfOtrDesc(mnrHngrTrfOtrDesc[i]);
				if (hngrBarTtlQty[i] != null)
					model.setHngrBarTtlQty(hngrBarTtlQty[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);
				if (hngrBarAmdQty[i] != null)
					model.setHngrBarAmdQty(hngrBarAmdQty[i]);
				if (mnrStsRmk[i] != null)
					model.setMnrStsRmk(mnrStsRmk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (barAtchKnt[i] != null)
					model.setBarAtchKnt(barAtchKnt[i]);
				if (mnrOrdOfcCtyCd[i] != null)
					model.setMnrOrdOfcCtyCd(mnrOrdOfcCtyCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (mnrFlgInpDt[i] != null)
					model.setMnrFlgInpDt(mnrFlgInpDt[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (mnrHngrBarTpCd[i] != null)
					model.setMnrHngrBarTpCd(mnrHngrBarTpCd[i]);
				if (mnrLostHngrQty[i] != null)
					model.setMnrLostHngrQty(mnrLostHngrQty[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (eqMvmtIdNo[i] != null)
					model.setEqMvmtIdNo(eqMvmtIdNo[i]);
				if (mnrDispHngrQty[i] != null)
					model.setMnrDispHngrQty(mnrDispHngrQty[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (mnrHngrDtlOffrDesc[i] != null)
					model.setMnrHngrDtlOffrDesc(mnrHngrDtlOffrDesc[i]);
				if (mnrFlgTpCd[i] != null)
					model.setMnrFlgTpCd(mnrFlgTpCd[i]);
				if (hngrBarAtchKnt[i] != null)
					model.setHngrBarAtchKnt(hngrBarAtchKnt[i]);
				if (mnrFlgYdCd[i] != null)
					model.setMnrFlgYdCd(mnrFlgYdCd[i]);
				if (mvmtCd[i] != null)
					model.setMvmtCd(mvmtCd[i]);
				if (mnrFlgInpTpCd[i] != null)
					model.setMnrFlgInpTpCd(mnrFlgInpTpCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (actInvtQty[i] != null)
					model.setActInvtQty(actInvtQty[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (mnrHngrRckCd[i] != null)
					model.setMnrHngrRckCd(mnrHngrRckCd[i]);
				if (mnrOrdSeq[i] != null)
					model.setMnrOrdSeq(mnrOrdSeq[i]);
				if (mnrStsFlg[i] != null)
					model.setMnrStsFlg(mnrStsFlg[i]);
				if (mnrHngrFlg[i] != null)
					model.setMnrHngrFlg(mnrHngrFlg[i]);
				if (mnrFlgSeq[i] != null)
					model.setMnrFlgSeq(mnrFlgSeq[i]);
				if (mnrHngrDmgQty[i] != null)
					model.setMnrHngrDmgQty(mnrHngrDmgQty[i]);
				if (mnrFlgCmplDt[i] != null)
					model.setMnrFlgCmplDt(mnrFlgCmplDt[i]);
				if (mnrFlgRmk[i] != null)
					model.setMnrFlgRmk(mnrFlgRmk[i]);
				if (mnrHngrTrfCd[i] != null)
					model.setMnrHngrTrfCd(mnrHngrTrfCd[i]);
				if (eqMvmtYr[i] != null)
					model.setEqMvmtYr(eqMvmtYr[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMnrFlgHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMnrFlgHisVO[]
	 */
	public CustomMnrFlgHisVO[] getCustomMnrFlgHisVOs(){
		CustomMnrFlgHisVO[] vos = (CustomMnrFlgHisVO[])models.toArray(new CustomMnrFlgHisVO[models.size()]);
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
		this.mnrHngrTrfOtrDesc = this.mnrHngrTrfOtrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hngrBarTtlQty = this.hngrBarTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd = this.crntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hngrBarAmdQty = this.hngrBarAmdQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrStsRmk = this.mnrStsRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.barAtchKnt = this.barAtchKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdOfcCtyCd = this.mnrOrdOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrFlgInpDt = this.mnrFlgInpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrBarTpCd = this.mnrHngrBarTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrLostHngrQty = this.mnrLostHngrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqMvmtIdNo = this.eqMvmtIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispHngrQty = this.mnrDispHngrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrDtlOffrDesc = this.mnrHngrDtlOffrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrFlgTpCd = this.mnrFlgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hngrBarAtchKnt = this.hngrBarAtchKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrFlgYdCd = this.mnrFlgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtCd = this.mvmtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrFlgInpTpCd = this.mnrFlgInpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actInvtQty = this.actInvtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrRckCd = this.mnrHngrRckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdSeq = this.mnrOrdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrStsFlg = this.mnrStsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrFlg = this.mnrHngrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrFlgSeq = this.mnrFlgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrDmgQty = this.mnrHngrDmgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrFlgCmplDt = this.mnrFlgCmplDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrFlgRmk = this.mnrFlgRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrTrfCd = this.mnrHngrTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqMvmtYr = this.eqMvmtYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
