/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CustomMnrDispDtlVO.java
*@FileTitle : CustomMnrDispDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.15
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2011.09.15 김상수 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomMnrDispDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrDispDtlVO> models = new ArrayList<CustomMnrDispDtlVO>();
	
	/* Column Info */
	private String rprCostAmt = null;
	/* Column Info */
	private String oldEqDispYdCd = null;
	/* Column Info */
	private String dispSoldDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String mnrDispDtlRmk = null;
	/* Column Info */
	private String mtrlNm = null;
	/* Column Info */
	private String mkrNm = null;
	/* Column Info */
	private String mnrPrnrCntCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String sdaysDt = null;
	/* Column Info */
	private String dispQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mnrPrnrSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String dispSoldDtFlg = null;
	/* Column Info */
	private String partAmt = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String dispUtPrc = null;
	/* Column Info */
	private String rcvInvSeq = null;
	/* Column Info */
	private String dispRsnCd = null;
	/* Column Info */
	private String eqTpszDesc = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String oldEqNo = null;
	/* Column Info */
	private String dispRlseNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String dispTrfUtPrc = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String dispTpCd = null;
	/* Column Info */
	private String oldEqTpszCd = null;
	/* Column Info */
	private String mdlNm = null;
	/* Column Info */
	private String dispNo = null;
	/* Column Info */
	private String dispTrkrNm = null;
	/* Column Info */
	private String mvmtCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String dispDtlSeq = null;
	/* Column Info */
	private String dispRlseNoFlg = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String oldSoldDt = null;
	/* Column Info */
	private String dispVrfyTpCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String dispYdCd = null;
	/* Column Info */
	private String dispUtTpCd = null;
	/* Column Info */
	private String fileSeq = null;
	/* Column Info */
	private String mvntDt = null;
	/* Column Info */
	private String chgCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CustomMnrDispDtlVO() {}

	public CustomMnrDispDtlVO(String ibflag, String pagerows, String oldEqDispYdCd, String rprCostAmt, String dispSoldDt, String currCd, String mtrlNm, String mnrDispDtlRmk, String mkrNm, String creDt, String mnrPrnrCntCd, String sdaysDt, String dispQty, String mnrPrnrSeq, String eqNo, String dispSoldDtFlg, String partAmt, String invAmt, String dispUtPrc, String rcvInvSeq, String dispRsnCd, String eqTpszDesc, String lstmCd, String oldEqNo, String dispRlseNo, String dispTrfUtPrc, String updUsrId, String updDt, String dispTpCd, String mdlNm, String oldEqTpszCd, String dispNo, String dispTrkrNm, String mvmtCd, String dispDtlSeq, String eqKndCd, String dispRlseNoFlg, String eqTpszCd, String dispVrfyTpCd, String oldSoldDt, String invNo, String bkgNo, String creUsrId, String dispYdCd, String dispUtTpCd, String mvntDt, String fileSeq, String chgCd) {
		this.rprCostAmt = rprCostAmt;
		this.oldEqDispYdCd = oldEqDispYdCd;
		this.dispSoldDt = dispSoldDt;
		this.currCd = currCd;
		this.mnrDispDtlRmk = mnrDispDtlRmk;
		this.mtrlNm = mtrlNm;
		this.mkrNm = mkrNm;
		this.mnrPrnrCntCd = mnrPrnrCntCd;
		this.creDt = creDt;
		this.sdaysDt = sdaysDt;
		this.dispQty = dispQty;
		this.pagerows = pagerows;
		this.mnrPrnrSeq = mnrPrnrSeq;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.dispSoldDtFlg = dispSoldDtFlg;
		this.partAmt = partAmt;
		this.invAmt = invAmt;
		this.dispUtPrc = dispUtPrc;
		this.rcvInvSeq = rcvInvSeq;
		this.dispRsnCd = dispRsnCd;
		this.eqTpszDesc = eqTpszDesc;
		this.lstmCd = lstmCd;
		this.oldEqNo = oldEqNo;
		this.dispRlseNo = dispRlseNo;
		this.updUsrId = updUsrId;
		this.dispTrfUtPrc = dispTrfUtPrc;
		this.updDt = updDt;
		this.dispTpCd = dispTpCd;
		this.oldEqTpszCd = oldEqTpszCd;
		this.mdlNm = mdlNm;
		this.dispNo = dispNo;
		this.dispTrkrNm = dispTrkrNm;
		this.mvmtCd = mvmtCd;
		this.eqKndCd = eqKndCd;
		this.dispDtlSeq = dispDtlSeq;
		this.dispRlseNoFlg = dispRlseNoFlg;
		this.eqTpszCd = eqTpszCd;
		this.invNo = invNo;
		this.oldSoldDt = oldSoldDt;
		this.dispVrfyTpCd = dispVrfyTpCd;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.dispYdCd = dispYdCd;
		this.dispUtTpCd = dispUtTpCd;
		this.fileSeq = fileSeq;
		this.mvntDt = mvntDt;
		this.chgCd = chgCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rpr_cost_amt", getRprCostAmt());
		this.hashColumns.put("old_eq_disp_yd_cd", getOldEqDispYdCd());
		this.hashColumns.put("disp_sold_dt", getDispSoldDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("mnr_disp_dtl_rmk", getMnrDispDtlRmk());
		this.hashColumns.put("mtrl_nm", getMtrlNm());
		this.hashColumns.put("mkr_nm", getMkrNm());
		this.hashColumns.put("mnr_prnr_cnt_cd", getMnrPrnrCntCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("sdays_dt", getSdaysDt());
		this.hashColumns.put("disp_qty", getDispQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mnr_prnr_seq", getMnrPrnrSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("disp_sold_dt_flg", getDispSoldDtFlg());
		this.hashColumns.put("part_amt", getPartAmt());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("disp_ut_prc", getDispUtPrc());
		this.hashColumns.put("rcv_inv_seq", getRcvInvSeq());
		this.hashColumns.put("disp_rsn_cd", getDispRsnCd());
		this.hashColumns.put("eq_tpsz_desc", getEqTpszDesc());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("old_eq_no", getOldEqNo());
		this.hashColumns.put("disp_rlse_no", getDispRlseNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("disp_trf_ut_prc", getDispTrfUtPrc());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("disp_tp_cd", getDispTpCd());
		this.hashColumns.put("old_eq_tpsz_cd", getOldEqTpszCd());
		this.hashColumns.put("mdl_nm", getMdlNm());
		this.hashColumns.put("disp_no", getDispNo());
		this.hashColumns.put("disp_trkr_nm", getDispTrkrNm());
		this.hashColumns.put("mvmt_cd", getMvmtCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("disp_dtl_seq", getDispDtlSeq());
		this.hashColumns.put("disp_rlse_no_flg", getDispRlseNoFlg());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("old_sold_dt", getOldSoldDt());
		this.hashColumns.put("disp_vrfy_tp_cd", getDispVrfyTpCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("disp_yd_cd", getDispYdCd());
		this.hashColumns.put("disp_ut_tp_cd", getDispUtTpCd());
		this.hashColumns.put("file_seq", getFileSeq());
		this.hashColumns.put("mvnt_dt", getMvntDt());
		this.hashColumns.put("chg_cd", getChgCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rpr_cost_amt", "rprCostAmt");
		this.hashFields.put("old_eq_disp_yd_cd", "oldEqDispYdCd");
		this.hashFields.put("disp_sold_dt", "dispSoldDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("mnr_disp_dtl_rmk", "mnrDispDtlRmk");
		this.hashFields.put("mtrl_nm", "mtrlNm");
		this.hashFields.put("mkr_nm", "mkrNm");
		this.hashFields.put("mnr_prnr_cnt_cd", "mnrPrnrCntCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("sdays_dt", "sdaysDt");
		this.hashFields.put("disp_qty", "dispQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mnr_prnr_seq", "mnrPrnrSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("disp_sold_dt_flg", "dispSoldDtFlg");
		this.hashFields.put("part_amt", "partAmt");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("disp_ut_prc", "dispUtPrc");
		this.hashFields.put("rcv_inv_seq", "rcvInvSeq");
		this.hashFields.put("disp_rsn_cd", "dispRsnCd");
		this.hashFields.put("eq_tpsz_desc", "eqTpszDesc");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("old_eq_no", "oldEqNo");
		this.hashFields.put("disp_rlse_no", "dispRlseNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("disp_trf_ut_prc", "dispTrfUtPrc");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("disp_tp_cd", "dispTpCd");
		this.hashFields.put("old_eq_tpsz_cd", "oldEqTpszCd");
		this.hashFields.put("mdl_nm", "mdlNm");
		this.hashFields.put("disp_no", "dispNo");
		this.hashFields.put("disp_trkr_nm", "dispTrkrNm");
		this.hashFields.put("mvmt_cd", "mvmtCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("disp_dtl_seq", "dispDtlSeq");
		this.hashFields.put("disp_rlse_no_flg", "dispRlseNoFlg");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("old_sold_dt", "oldSoldDt");
		this.hashFields.put("disp_vrfy_tp_cd", "dispVrfyTpCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("disp_yd_cd", "dispYdCd");
		this.hashFields.put("disp_ut_tp_cd", "dispUtTpCd");
		this.hashFields.put("file_seq", "fileSeq");
		this.hashFields.put("mvnt_dt", "mvntDt");
		this.hashFields.put("chg_cd", "chgCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rprCostAmt
	 */
	public String getRprCostAmt() {
		return this.rprCostAmt;
	}
	
	/**
	 * Column Info
	 * @return oldEqDispYdCd
	 */
	public String getOldEqDispYdCd() {
		return this.oldEqDispYdCd;
	}
	
	/**
	 * Column Info
	 * @return dispSoldDt
	 */
	public String getDispSoldDt() {
		return this.dispSoldDt;
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
	 * @return mnrDispDtlRmk
	 */
	public String getMnrDispDtlRmk() {
		return this.mnrDispDtlRmk;
	}
	
	/**
	 * Column Info
	 * @return mtrlNm
	 */
	public String getMtrlNm() {
		return this.mtrlNm;
	}
	
	/**
	 * Column Info
	 * @return mkrNm
	 */
	public String getMkrNm() {
		return this.mkrNm;
	}
	
	/**
	 * Column Info
	 * @return mnrPrnrCntCd
	 */
	public String getMnrPrnrCntCd() {
		return this.mnrPrnrCntCd;
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
	 * @return sdaysDt
	 */
	public String getSdaysDt() {
		return this.sdaysDt;
	}
	
	/**
	 * Column Info
	 * @return dispQty
	 */
	public String getDispQty() {
		return this.dispQty;
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
	 * @return mnrPrnrSeq
	 */
	public String getMnrPrnrSeq() {
		return this.mnrPrnrSeq;
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
	 * @return dispSoldDtFlg
	 */
	public String getDispSoldDtFlg() {
		return this.dispSoldDtFlg;
	}
	
	/**
	 * Column Info
	 * @return partAmt
	 */
	public String getPartAmt() {
		return this.partAmt;
	}
	
	/**
	 * Column Info
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
	}
	
	/**
	 * Column Info
	 * @return dispUtPrc
	 */
	public String getDispUtPrc() {
		return this.dispUtPrc;
	}
	
	/**
	 * Column Info
	 * @return rcvInvSeq
	 */
	public String getRcvInvSeq() {
		return this.rcvInvSeq;
	}
	
	/**
	 * Column Info
	 * @return dispRsnCd
	 */
	public String getDispRsnCd() {
		return this.dispRsnCd;
	}
	
	/**
	 * Column Info
	 * @return eqTpszDesc
	 */
	public String getEqTpszDesc() {
		return this.eqTpszDesc;
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
	 * @return oldEqNo
	 */
	public String getOldEqNo() {
		return this.oldEqNo;
	}
	
	/**
	 * Column Info
	 * @return dispRlseNo
	 */
	public String getDispRlseNo() {
		return this.dispRlseNo;
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
	 * @return dispTrfUtPrc
	 */
	public String getDispTrfUtPrc() {
		return this.dispTrfUtPrc;
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
	 * @return dispTpCd
	 */
	public String getDispTpCd() {
		return this.dispTpCd;
	}
	
	/**
	 * Column Info
	 * @return oldEqTpszCd
	 */
	public String getOldEqTpszCd() {
		return this.oldEqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return mdlNm
	 */
	public String getMdlNm() {
		return this.mdlNm;
	}
	
	/**
	 * Column Info
	 * @return dispNo
	 */
	public String getDispNo() {
		return this.dispNo;
	}
	
	/**
	 * Column Info
	 * @return dispTrkrNm
	 */
	public String getDispTrkrNm() {
		return this.dispTrkrNm;
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
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return dispDtlSeq
	 */
	public String getDispDtlSeq() {
		return this.dispDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return dispRlseNoFlg
	 */
	public String getDispRlseNoFlg() {
		return this.dispRlseNoFlg;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return oldSoldDt
	 */
	public String getOldSoldDt() {
		return this.oldSoldDt;
	}
	
	/**
	 * Column Info
	 * @return dispVrfyTpCd
	 */
	public String getDispVrfyTpCd() {
		return this.dispVrfyTpCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return dispYdCd
	 */
	public String getDispYdCd() {
		return this.dispYdCd;
	}
	
	/**
	 * Column Info
	 * @return dispUtTpCd
	 */
	public String getDispUtTpCd() {
		return this.dispUtTpCd;
	}
	
	/**
	 * Column Info
	 * @return fileSeq
	 */
	public String getFileSeq() {
		return this.fileSeq;
	}
	
	/**
	 * Column Info
	 * @return mvntDt
	 */
	public String getMvntDt() {
		return this.mvntDt;
	}
	

	/**
	 * Column Info
	 * @param rprCostAmt
	 */
	public void setRprCostAmt(String rprCostAmt) {
		this.rprCostAmt = rprCostAmt;
	}
	
	/**
	 * Column Info
	 * @param oldEqDispYdCd
	 */
	public void setOldEqDispYdCd(String oldEqDispYdCd) {
		this.oldEqDispYdCd = oldEqDispYdCd;
	}
	
	/**
	 * Column Info
	 * @param dispSoldDt
	 */
	public void setDispSoldDt(String dispSoldDt) {
		this.dispSoldDt = dispSoldDt;
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
	 * @param mnrDispDtlRmk
	 */
	public void setMnrDispDtlRmk(String mnrDispDtlRmk) {
		this.mnrDispDtlRmk = mnrDispDtlRmk;
	}
	
	/**
	 * Column Info
	 * @param mtrlNm
	 */
	public void setMtrlNm(String mtrlNm) {
		this.mtrlNm = mtrlNm;
	}
	
	/**
	 * Column Info
	 * @param mkrNm
	 */
	public void setMkrNm(String mkrNm) {
		this.mkrNm = mkrNm;
	}
	
	/**
	 * Column Info
	 * @param mnrPrnrCntCd
	 */
	public void setMnrPrnrCntCd(String mnrPrnrCntCd) {
		this.mnrPrnrCntCd = mnrPrnrCntCd;
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
	 * @param sdaysDt
	 */
	public void setSdaysDt(String sdaysDt) {
		this.sdaysDt = sdaysDt;
	}
	
	/**
	 * Column Info
	 * @param dispQty
	 */
	public void setDispQty(String dispQty) {
		this.dispQty = dispQty;
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
	 * @param mnrPrnrSeq
	 */
	public void setMnrPrnrSeq(String mnrPrnrSeq) {
		this.mnrPrnrSeq = mnrPrnrSeq;
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
	 * @param dispSoldDtFlg
	 */
	public void setDispSoldDtFlg(String dispSoldDtFlg) {
		this.dispSoldDtFlg = dispSoldDtFlg;
	}
	
	/**
	 * Column Info
	 * @param partAmt
	 */
	public void setPartAmt(String partAmt) {
		this.partAmt = partAmt;
	}
	
	/**
	 * Column Info
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	
	/**
	 * Column Info
	 * @param dispUtPrc
	 */
	public void setDispUtPrc(String dispUtPrc) {
		this.dispUtPrc = dispUtPrc;
	}
	
	/**
	 * Column Info
	 * @param rcvInvSeq
	 */
	public void setRcvInvSeq(String rcvInvSeq) {
		this.rcvInvSeq = rcvInvSeq;
	}
	
	/**
	 * Column Info
	 * @param dispRsnCd
	 */
	public void setDispRsnCd(String dispRsnCd) {
		this.dispRsnCd = dispRsnCd;
	}
	
	/**
	 * Column Info
	 * @param eqTpszDesc
	 */
	public void setEqTpszDesc(String eqTpszDesc) {
		this.eqTpszDesc = eqTpszDesc;
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
	 * @param oldEqNo
	 */
	public void setOldEqNo(String oldEqNo) {
		this.oldEqNo = oldEqNo;
	}
	
	/**
	 * Column Info
	 * @param dispRlseNo
	 */
	public void setDispRlseNo(String dispRlseNo) {
		this.dispRlseNo = dispRlseNo;
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
	 * @param dispTrfUtPrc
	 */
	public void setDispTrfUtPrc(String dispTrfUtPrc) {
		this.dispTrfUtPrc = dispTrfUtPrc;
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
	 * @param dispTpCd
	 */
	public void setDispTpCd(String dispTpCd) {
		this.dispTpCd = dispTpCd;
	}
	
	/**
	 * Column Info
	 * @param oldEqTpszCd
	 */
	public void setOldEqTpszCd(String oldEqTpszCd) {
		this.oldEqTpszCd = oldEqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param mdlNm
	 */
	public void setMdlNm(String mdlNm) {
		this.mdlNm = mdlNm;
	}
	
	/**
	 * Column Info
	 * @param dispNo
	 */
	public void setDispNo(String dispNo) {
		this.dispNo = dispNo;
	}
	
	/**
	 * Column Info
	 * @param dispTrkrNm
	 */
	public void setDispTrkrNm(String dispTrkrNm) {
		this.dispTrkrNm = dispTrkrNm;
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
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param dispDtlSeq
	 */
	public void setDispDtlSeq(String dispDtlSeq) {
		this.dispDtlSeq = dispDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param dispRlseNoFlg
	 */
	public void setDispRlseNoFlg(String dispRlseNoFlg) {
		this.dispRlseNoFlg = dispRlseNoFlg;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param oldSoldDt
	 */
	public void setOldSoldDt(String oldSoldDt) {
		this.oldSoldDt = oldSoldDt;
	}
	
	/**
	 * Column Info
	 * @param dispVrfyTpCd
	 */
	public void setDispVrfyTpCd(String dispVrfyTpCd) {
		this.dispVrfyTpCd = dispVrfyTpCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param dispYdCd
	 */
	public void setDispYdCd(String dispYdCd) {
		this.dispYdCd = dispYdCd;
	}
	
	/**
	 * Column Info
	 * @param dispUtTpCd
	 */
	public void setDispUtTpCd(String dispUtTpCd) {
		this.dispUtTpCd = dispUtTpCd;
	}
	
	/**
	 * Column Info
	 * @param fileSeq
	 */
	public void setFileSeq(String fileSeq) {
		this.fileSeq = fileSeq;
	}
	
	/**
	 * Column Info
	 * @param mvntDt
	 */
	public void setMvntDt(String mvntDt) {
		this.mvntDt = mvntDt;
	}
	
	public String getChgCd() {
		return chgCd;
	}

	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
		setRprCostAmt(JSPUtil.getParameter(request, prefix + "rpr_cost_amt", ""));
		setOldEqDispYdCd(JSPUtil.getParameter(request, prefix + "old_eq_disp_yd_cd", ""));
		setDispSoldDt(JSPUtil.getParameter(request, prefix + "disp_sold_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setMnrDispDtlRmk(JSPUtil.getParameter(request, prefix + "mnr_disp_dtl_rmk", ""));
		setMtrlNm(JSPUtil.getParameter(request, prefix + "mtrl_nm", ""));
		setMkrNm(JSPUtil.getParameter(request, prefix + "mkr_nm", ""));
		setMnrPrnrCntCd(JSPUtil.getParameter(request, prefix + "mnr_prnr_cnt_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSdaysDt(JSPUtil.getParameter(request, prefix + "sdays_dt", ""));
		setDispQty(JSPUtil.getParameter(request, prefix + "disp_qty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMnrPrnrSeq(JSPUtil.getParameter(request, prefix + "mnr_prnr_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setDispSoldDtFlg(JSPUtil.getParameter(request, prefix + "disp_sold_dt_flg", ""));
		setPartAmt(JSPUtil.getParameter(request, prefix + "part_amt", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setDispUtPrc(JSPUtil.getParameter(request, prefix + "disp_ut_prc", ""));
		setRcvInvSeq(JSPUtil.getParameter(request, prefix + "rcv_inv_seq", ""));
		setDispRsnCd(JSPUtil.getParameter(request, prefix + "disp_rsn_cd", ""));
		setEqTpszDesc(JSPUtil.getParameter(request, prefix + "eq_tpsz_desc", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setOldEqNo(JSPUtil.getParameter(request, prefix + "old_eq_no", ""));
		setDispRlseNo(JSPUtil.getParameter(request, prefix + "disp_rlse_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setDispTrfUtPrc(JSPUtil.getParameter(request, prefix + "disp_trf_ut_prc", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setDispTpCd(JSPUtil.getParameter(request, prefix + "disp_tp_cd", ""));
		setOldEqTpszCd(JSPUtil.getParameter(request, prefix + "old_eq_tpsz_cd", ""));
		setMdlNm(JSPUtil.getParameter(request, prefix + "mdl_nm", ""));
		setDispNo(JSPUtil.getParameter(request, prefix + "disp_no", ""));
		setDispTrkrNm(JSPUtil.getParameter(request, prefix + "disp_trkr_nm", ""));
		setMvmtCd(JSPUtil.getParameter(request, prefix + "mvmt_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setDispDtlSeq(JSPUtil.getParameter(request, prefix + "disp_dtl_seq", ""));
		setDispRlseNoFlg(JSPUtil.getParameter(request, prefix + "disp_rlse_no_flg", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setOldSoldDt(JSPUtil.getParameter(request, prefix + "old_sold_dt", ""));
		setDispVrfyTpCd(JSPUtil.getParameter(request, prefix + "disp_vrfy_tp_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setDispYdCd(JSPUtil.getParameter(request, prefix + "disp_yd_cd", ""));
		setDispUtTpCd(JSPUtil.getParameter(request, prefix + "disp_ut_tp_cd", ""));
		setFileSeq(JSPUtil.getParameter(request, prefix + "file_seq", ""));
		setMvntDt(JSPUtil.getParameter(request, prefix + "mvnt_dt", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrDispDtlVO[]
	 */
	public CustomMnrDispDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomMnrDispDtlVO[]
	 */
	public CustomMnrDispDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrDispDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rprCostAmt = (JSPUtil.getParameter(request, prefix	+ "rpr_cost_amt", length));
			String[] oldEqDispYdCd = (JSPUtil.getParameter(request, prefix	+ "old_eq_disp_yd_cd", length));
			String[] dispSoldDt = (JSPUtil.getParameter(request, prefix	+ "disp_sold_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] mnrDispDtlRmk = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_dtl_rmk", length));
			String[] mtrlNm = (JSPUtil.getParameter(request, prefix	+ "mtrl_nm", length));
			String[] mkrNm = (JSPUtil.getParameter(request, prefix	+ "mkr_nm", length));
			String[] mnrPrnrCntCd = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_cnt_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] sdaysDt = (JSPUtil.getParameter(request, prefix	+ "sdays_dt", length));
			String[] dispQty = (JSPUtil.getParameter(request, prefix	+ "disp_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mnrPrnrSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] dispSoldDtFlg = (JSPUtil.getParameter(request, prefix	+ "disp_sold_dt_flg", length));
			String[] partAmt = (JSPUtil.getParameter(request, prefix	+ "part_amt", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] dispUtPrc = (JSPUtil.getParameter(request, prefix	+ "disp_ut_prc", length));
			String[] rcvInvSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_inv_seq", length));
			String[] dispRsnCd = (JSPUtil.getParameter(request, prefix	+ "disp_rsn_cd", length));
			String[] eqTpszDesc = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_desc", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] oldEqNo = (JSPUtil.getParameter(request, prefix	+ "old_eq_no", length));
			String[] dispRlseNo = (JSPUtil.getParameter(request, prefix	+ "disp_rlse_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] dispTrfUtPrc = (JSPUtil.getParameter(request, prefix	+ "disp_trf_ut_prc", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] dispTpCd = (JSPUtil.getParameter(request, prefix	+ "disp_tp_cd", length));
			String[] oldEqTpszCd = (JSPUtil.getParameter(request, prefix	+ "old_eq_tpsz_cd", length));
			String[] mdlNm = (JSPUtil.getParameter(request, prefix	+ "mdl_nm", length));
			String[] dispNo = (JSPUtil.getParameter(request, prefix	+ "disp_no", length));
			String[] dispTrkrNm = (JSPUtil.getParameter(request, prefix	+ "disp_trkr_nm", length));
			String[] mvmtCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] dispDtlSeq = (JSPUtil.getParameter(request, prefix	+ "disp_dtl_seq", length));
			String[] dispRlseNoFlg = (JSPUtil.getParameter(request, prefix	+ "disp_rlse_no_flg", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] oldSoldDt = (JSPUtil.getParameter(request, prefix	+ "old_sold_dt", length));
			String[] dispVrfyTpCd = (JSPUtil.getParameter(request, prefix	+ "disp_vrfy_tp_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] dispYdCd = (JSPUtil.getParameter(request, prefix	+ "disp_yd_cd", length));
			String[] dispUtTpCd = (JSPUtil.getParameter(request, prefix	+ "disp_ut_tp_cd", length));
			String[] fileSeq = (JSPUtil.getParameter(request, prefix	+ "file_seq", length));
			String[] mvntDt = (JSPUtil.getParameter(request, prefix	+ "mvnt_dt", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrDispDtlVO();
				if (rprCostAmt[i] != null)
					model.setRprCostAmt(rprCostAmt[i]);
				if (oldEqDispYdCd[i] != null)
					model.setOldEqDispYdCd(oldEqDispYdCd[i]);
				if (dispSoldDt[i] != null)
					model.setDispSoldDt(dispSoldDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (mnrDispDtlRmk[i] != null)
					model.setMnrDispDtlRmk(mnrDispDtlRmk[i]);
				if (mtrlNm[i] != null)
					model.setMtrlNm(mtrlNm[i]);
				if (mkrNm[i] != null)
					model.setMkrNm(mkrNm[i]);
				if (mnrPrnrCntCd[i] != null)
					model.setMnrPrnrCntCd(mnrPrnrCntCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (sdaysDt[i] != null)
					model.setSdaysDt(sdaysDt[i]);
				if (dispQty[i] != null)
					model.setDispQty(dispQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mnrPrnrSeq[i] != null)
					model.setMnrPrnrSeq(mnrPrnrSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (dispSoldDtFlg[i] != null)
					model.setDispSoldDtFlg(dispSoldDtFlg[i]);
				if (partAmt[i] != null)
					model.setPartAmt(partAmt[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (dispUtPrc[i] != null)
					model.setDispUtPrc(dispUtPrc[i]);
				if (rcvInvSeq[i] != null)
					model.setRcvInvSeq(rcvInvSeq[i]);
				if (dispRsnCd[i] != null)
					model.setDispRsnCd(dispRsnCd[i]);
				if (eqTpszDesc[i] != null)
					model.setEqTpszDesc(eqTpszDesc[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (oldEqNo[i] != null)
					model.setOldEqNo(oldEqNo[i]);
				if (dispRlseNo[i] != null)
					model.setDispRlseNo(dispRlseNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (dispTrfUtPrc[i] != null)
					model.setDispTrfUtPrc(dispTrfUtPrc[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (dispTpCd[i] != null)
					model.setDispTpCd(dispTpCd[i]);
				if (oldEqTpszCd[i] != null)
					model.setOldEqTpszCd(oldEqTpszCd[i]);
				if (mdlNm[i] != null)
					model.setMdlNm(mdlNm[i]);
				if (dispNo[i] != null)
					model.setDispNo(dispNo[i]);
				if (dispTrkrNm[i] != null)
					model.setDispTrkrNm(dispTrkrNm[i]);
				if (mvmtCd[i] != null)
					model.setMvmtCd(mvmtCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (dispDtlSeq[i] != null)
					model.setDispDtlSeq(dispDtlSeq[i]);
				if (dispRlseNoFlg[i] != null)
					model.setDispRlseNoFlg(dispRlseNoFlg[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (oldSoldDt[i] != null)
					model.setOldSoldDt(oldSoldDt[i]);
				if (dispVrfyTpCd[i] != null)
					model.setDispVrfyTpCd(dispVrfyTpCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (dispYdCd[i] != null)
					model.setDispYdCd(dispYdCd[i]);
				if (dispUtTpCd[i] != null)
					model.setDispUtTpCd(dispUtTpCd[i]);
				if (fileSeq[i] != null)
					model.setFileSeq(fileSeq[i]);
				if (mvntDt[i] != null)
					model.setMvntDt(mvntDt[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMnrDispDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMnrDispDtlVO[]
	 */
	public CustomMnrDispDtlVO[] getCustomMnrDispDtlVOs(){
		CustomMnrDispDtlVO[] vos = (CustomMnrDispDtlVO[])models.toArray(new CustomMnrDispDtlVO[models.size()]);
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
		this.rprCostAmt = this.rprCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldEqDispYdCd = this.oldEqDispYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispSoldDt = this.dispSoldDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispDtlRmk = this.mnrDispDtlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtrlNm = this.mtrlNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkrNm = this.mkrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrCntCd = this.mnrPrnrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sdaysDt = this.sdaysDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispQty = this.dispQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrSeq = this.mnrPrnrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispSoldDtFlg = this.dispSoldDtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.partAmt = this.partAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispUtPrc = this.dispUtPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvInvSeq = this.rcvInvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispRsnCd = this.dispRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszDesc = this.eqTpszDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldEqNo = this.oldEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispRlseNo = this.dispRlseNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispTrfUtPrc = this.dispTrfUtPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispTpCd = this.dispTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldEqTpszCd = this.oldEqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdlNm = this.mdlNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispNo = this.dispNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispTrkrNm = this.dispTrkrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtCd = this.mvmtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispDtlSeq = this.dispDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispRlseNoFlg = this.dispRlseNoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldSoldDt = this.oldSoldDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispVrfyTpCd = this.dispVrfyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispYdCd = this.dispYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispUtTpCd = this.dispUtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSeq = this.fileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvntDt = this.mvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
