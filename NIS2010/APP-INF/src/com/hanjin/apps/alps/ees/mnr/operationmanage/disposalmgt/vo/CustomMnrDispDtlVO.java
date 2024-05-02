/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CustomMnrDispDtlVO.java
*@FileTitle : CustomMnrDispDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.27
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2011.05.27 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomMnrDispDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrDispDtlVO> models = new ArrayList<CustomMnrDispDtlVO>();
	
	/* Column Info */
	private String oldEqDispYdCd = null;
	/* Column Info */
	private String mtrlNm = null;
	/* Column Info */
	private String sdaysDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mnrPrnrSeq = null;
	/* Column Info */
	private String dispSoldDtFlg = null;
	/* Column Info */
	private String rcvInvSeq = null;
	/* Column Info */
	private String dispRsnCd = null;
	/* Column Info */
	private String eqTpszDesc = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String dispRlseNo = null;
	/* Column Info */
	private String dispTrfUtPrc = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String dispNo = null;
	/* Column Info */
	private String dispRlseNoFlg = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String dispVrfyTpCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String mvntDt = null;
	/* Column Info */
	private String fileSeq = null;
	/* Column Info */
	private String rprCostAmt = null;
	/* Column Info */
	private String userOfcCd = null;
	/* Column Info */
	private String dispSoldDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String mnrDispDtlRmk = null;
	/* Column Info */
	private String mkrNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String mnrPrnrCntCd = null;
	/* Column Info */
	private String dispQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String partAmt = null;
	/* Column Info */
	private String dispUtPrc = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String oldEqNo = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String dispTpCd = null;
	/* Column Info */
	private String mdlNm = null;
	/* Column Info */
	private String oldEqTpszCd = null;
	/* Column Info */
	private String dispTrkrNm = null;
	/* Column Info */
	private String mvmtCd = null;
	/* Column Info */
	private String dispDtlSeq = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String dispTpNm = null;
	/* Column Info */
	private String oldSoldDt = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String dispYdCd = null;
	/* Column Info */
	private String dispUtTpCd = null;
	/* Column Info */
	private String lccDiffFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomMnrDispDtlVO() {}

	public CustomMnrDispDtlVO(String ibflag, String pagerows, String oldEqDispYdCd, String rprCostAmt, String dispSoldDt, String currCd, String mtrlNm, String mnrDispDtlRmk, String mkrNm, String creDt, String mnrPrnrCntCd, String sdaysDt, String dispQty, String mnrPrnrSeq, String eqNo, String dispSoldDtFlg, String partAmt, String invAmt, String dispUtPrc, String rcvInvSeq, String dispRsnCd, String eqTpszDesc, String lstmCd, String oldEqNo, String dispRlseNo, String dispTrfUtPrc, String updUsrId, String updDt, String dispTpCd, String mdlNm, String oldEqTpszCd, String dispNo, String dispTrkrNm, String mvmtCd, String dispDtlSeq, String eqKndCd, String dispRlseNoFlg, String dispTpNm, String eqTpszCd, String dispVrfyTpCd, String oldSoldDt, String invNo, String bkgNo, String creUsrId, String dispYdCd, String dispUtTpCd, String mvntDt, String fileSeq, String userOfcCd, String lccDiffFlg) {
		this.oldEqDispYdCd = oldEqDispYdCd;
		this.mtrlNm = mtrlNm;
		this.sdaysDt = sdaysDt;
		this.pagerows = pagerows;
		this.mnrPrnrSeq = mnrPrnrSeq;
		this.dispSoldDtFlg = dispSoldDtFlg;
		this.rcvInvSeq = rcvInvSeq;
		this.dispRsnCd = dispRsnCd;
		this.eqTpszDesc = eqTpszDesc;
		this.lstmCd = lstmCd;
		this.dispRlseNo = dispRlseNo;
		this.dispTrfUtPrc = dispTrfUtPrc;
		this.updUsrId = updUsrId;
		this.dispNo = dispNo;
		this.dispRlseNoFlg = dispRlseNoFlg;
		this.eqTpszCd = eqTpszCd;
		this.dispVrfyTpCd = dispVrfyTpCd;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.mvntDt = mvntDt;
		this.fileSeq = fileSeq;
		this.rprCostAmt = rprCostAmt;
		this.userOfcCd = userOfcCd;
		this.dispSoldDt = dispSoldDt;
		this.currCd = currCd;
		this.mnrDispDtlRmk = mnrDispDtlRmk;
		this.mkrNm = mkrNm;
		this.creDt = creDt;
		this.mnrPrnrCntCd = mnrPrnrCntCd;
		this.dispQty = dispQty;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.partAmt = partAmt;
		this.dispUtPrc = dispUtPrc;
		this.invAmt = invAmt;
		this.oldEqNo = oldEqNo;
		this.updDt = updDt;
		this.dispTpCd = dispTpCd;
		this.mdlNm = mdlNm;
		this.oldEqTpszCd = oldEqTpszCd;
		this.dispTrkrNm = dispTrkrNm;
		this.mvmtCd = mvmtCd;
		this.dispDtlSeq = dispDtlSeq;
		this.eqKndCd = eqKndCd;
		this.dispTpNm = dispTpNm;
		this.oldSoldDt = oldSoldDt;
		this.invNo = invNo;
		this.dispYdCd = dispYdCd;
		this.dispUtTpCd = dispUtTpCd;
		this.lccDiffFlg = lccDiffFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("old_eq_disp_yd_cd", getOldEqDispYdCd());
		this.hashColumns.put("mtrl_nm", getMtrlNm());
		this.hashColumns.put("sdays_dt", getSdaysDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mnr_prnr_seq", getMnrPrnrSeq());
		this.hashColumns.put("disp_sold_dt_flg", getDispSoldDtFlg());
		this.hashColumns.put("rcv_inv_seq", getRcvInvSeq());
		this.hashColumns.put("disp_rsn_cd", getDispRsnCd());
		this.hashColumns.put("eq_tpsz_desc", getEqTpszDesc());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("disp_rlse_no", getDispRlseNo());
		this.hashColumns.put("disp_trf_ut_prc", getDispTrfUtPrc());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("disp_no", getDispNo());
		this.hashColumns.put("disp_rlse_no_flg", getDispRlseNoFlg());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("disp_vrfy_tp_cd", getDispVrfyTpCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("mvnt_dt", getMvntDt());
		this.hashColumns.put("file_seq", getFileSeq());
		this.hashColumns.put("rpr_cost_amt", getRprCostAmt());
		this.hashColumns.put("user_ofc_cd", getUserOfcCd());
		this.hashColumns.put("disp_sold_dt", getDispSoldDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("mnr_disp_dtl_rmk", getMnrDispDtlRmk());
		this.hashColumns.put("mkr_nm", getMkrNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("mnr_prnr_cnt_cd", getMnrPrnrCntCd());
		this.hashColumns.put("disp_qty", getDispQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("part_amt", getPartAmt());
		this.hashColumns.put("disp_ut_prc", getDispUtPrc());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("old_eq_no", getOldEqNo());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("disp_tp_cd", getDispTpCd());
		this.hashColumns.put("mdl_nm", getMdlNm());
		this.hashColumns.put("old_eq_tpsz_cd", getOldEqTpszCd());
		this.hashColumns.put("disp_trkr_nm", getDispTrkrNm());
		this.hashColumns.put("mvmt_cd", getMvmtCd());
		this.hashColumns.put("disp_dtl_seq", getDispDtlSeq());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("disp_tp_nm", getDispTpNm());
		this.hashColumns.put("old_sold_dt", getOldSoldDt());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("disp_yd_cd", getDispYdCd());
		this.hashColumns.put("disp_ut_tp_cd", getDispUtTpCd());
		this.hashColumns.put("lcc_diff_flg", getLccDiffFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("old_eq_disp_yd_cd", "oldEqDispYdCd");
		this.hashFields.put("mtrl_nm", "mtrlNm");
		this.hashFields.put("sdays_dt", "sdaysDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mnr_prnr_seq", "mnrPrnrSeq");
		this.hashFields.put("disp_sold_dt_flg", "dispSoldDtFlg");
		this.hashFields.put("rcv_inv_seq", "rcvInvSeq");
		this.hashFields.put("disp_rsn_cd", "dispRsnCd");
		this.hashFields.put("eq_tpsz_desc", "eqTpszDesc");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("disp_rlse_no", "dispRlseNo");
		this.hashFields.put("disp_trf_ut_prc", "dispTrfUtPrc");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("disp_no", "dispNo");
		this.hashFields.put("disp_rlse_no_flg", "dispRlseNoFlg");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("disp_vrfy_tp_cd", "dispVrfyTpCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("mvnt_dt", "mvntDt");
		this.hashFields.put("file_seq", "fileSeq");
		this.hashFields.put("rpr_cost_amt", "rprCostAmt");
		this.hashFields.put("user_ofc_cd", "userOfcCd");
		this.hashFields.put("disp_sold_dt", "dispSoldDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("mnr_disp_dtl_rmk", "mnrDispDtlRmk");
		this.hashFields.put("mkr_nm", "mkrNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("mnr_prnr_cnt_cd", "mnrPrnrCntCd");
		this.hashFields.put("disp_qty", "dispQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("part_amt", "partAmt");
		this.hashFields.put("disp_ut_prc", "dispUtPrc");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("old_eq_no", "oldEqNo");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("disp_tp_cd", "dispTpCd");
		this.hashFields.put("mdl_nm", "mdlNm");
		this.hashFields.put("old_eq_tpsz_cd", "oldEqTpszCd");
		this.hashFields.put("disp_trkr_nm", "dispTrkrNm");
		this.hashFields.put("mvmt_cd", "mvmtCd");
		this.hashFields.put("disp_dtl_seq", "dispDtlSeq");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("disp_tp_nm", "dispTpNm");
		this.hashFields.put("old_sold_dt", "oldSoldDt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("disp_yd_cd", "dispYdCd");
		this.hashFields.put("disp_ut_tp_cd", "dispUtTpCd");
		this.hashFields.put("lcc_diff_flg", "lccDiffFlg");
		return this.hashFields;
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
	 * @return mtrlNm
	 */
	public String getMtrlNm() {
		return this.mtrlNm;
	}
	
	/**
	 * Column Info
	 * @return sdaysDt
	 */
	public String getSdaysDt() {
		return this.sdaysDt;
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
	 * Column Info
	 * @return dispSoldDtFlg
	 */
	public String getDispSoldDtFlg() {
		return this.dispSoldDtFlg;
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
	 * @return dispRlseNo
	 */
	public String getDispRlseNo() {
		return this.dispRlseNo;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @return dispVrfyTpCd
	 */
	public String getDispVrfyTpCd() {
		return this.dispVrfyTpCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return fileSeq
	 */
	public String getFileSeq() {
		return this.fileSeq;
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
	 * @return userOfcCd
	 */
	public String getUserOfcCd() {
		return this.userOfcCd;
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
	 * @return mkrNm
	 */
	public String getMkrNm() {
		return this.mkrNm;
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
	 * @return mnrPrnrCntCd
	 */
	public String getMnrPrnrCntCd() {
		return this.mnrPrnrCntCd;
	}
	
	/**
	 * Column Info
	 * @return dispQty
	 */
	public String getDispQty() {
		return this.dispQty;
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
	 * @return partAmt
	 */
	public String getPartAmt() {
		return this.partAmt;
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
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
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
	 * @return mdlNm
	 */
	public String getMdlNm() {
		return this.mdlNm;
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
	 * @return dispDtlSeq
	 */
	public String getDispDtlSeq() {
		return this.dispDtlSeq;
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
	 * @return dispTpNm
	 */
	public String getDispTpNm() {
		return this.dispTpNm;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
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
	 * @return lccDiffFlg
	 */
	public String getLccDiffFlg() {
		return this.lccDiffFlg;
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
	 * @param mtrlNm
	 */
	public void setMtrlNm(String mtrlNm) {
		this.mtrlNm = mtrlNm;
	}
	
	/**
	 * Column Info
	 * @param sdaysDt
	 */
	public void setSdaysDt(String sdaysDt) {
		this.sdaysDt = sdaysDt;
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
	 * Column Info
	 * @param dispSoldDtFlg
	 */
	public void setDispSoldDtFlg(String dispSoldDtFlg) {
		this.dispSoldDtFlg = dispSoldDtFlg;
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
	 * @param dispRlseNo
	 */
	public void setDispRlseNo(String dispRlseNo) {
		this.dispRlseNo = dispRlseNo;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param dispVrfyTpCd
	 */
	public void setDispVrfyTpCd(String dispVrfyTpCd) {
		this.dispVrfyTpCd = dispVrfyTpCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param mvntDt
	 */
	public void setMvntDt(String mvntDt) {
		this.mvntDt = mvntDt;
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
	 * @param rprCostAmt
	 */
	public void setRprCostAmt(String rprCostAmt) {
		this.rprCostAmt = rprCostAmt;
	}
	
	/**
	 * Column Info
	 * @param userOfcCd
	 */
	public void setUserOfcCd(String userOfcCd) {
		this.userOfcCd = userOfcCd;
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
	 * @param mkrNm
	 */
	public void setMkrNm(String mkrNm) {
		this.mkrNm = mkrNm;
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
	 * @param mnrPrnrCntCd
	 */
	public void setMnrPrnrCntCd(String mnrPrnrCntCd) {
		this.mnrPrnrCntCd = mnrPrnrCntCd;
	}
	
	/**
	 * Column Info
	 * @param dispQty
	 */
	public void setDispQty(String dispQty) {
		this.dispQty = dispQty;
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
	 * @param partAmt
	 */
	public void setPartAmt(String partAmt) {
		this.partAmt = partAmt;
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
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
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
	 * @param mdlNm
	 */
	public void setMdlNm(String mdlNm) {
		this.mdlNm = mdlNm;
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
	 * @param dispDtlSeq
	 */
	public void setDispDtlSeq(String dispDtlSeq) {
		this.dispDtlSeq = dispDtlSeq;
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
	 * @param dispTpNm
	 */
	public void setDispTpNm(String dispTpNm) {
		this.dispTpNm = dispTpNm;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
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
	 * @param lccDiffFlg
	 */
	public void setLccDiffFlg(String lccDiffFlg) {
		this.lccDiffFlg = lccDiffFlg;
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
		setOldEqDispYdCd(JSPUtil.getParameter(request, prefix + "old_eq_disp_yd_cd", ""));
		setMtrlNm(JSPUtil.getParameter(request, prefix + "mtrl_nm", ""));
		setSdaysDt(JSPUtil.getParameter(request, prefix + "sdays_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMnrPrnrSeq(JSPUtil.getParameter(request, prefix + "mnr_prnr_seq", ""));
		setDispSoldDtFlg(JSPUtil.getParameter(request, prefix + "disp_sold_dt_flg", ""));
		setRcvInvSeq(JSPUtil.getParameter(request, prefix + "rcv_inv_seq", ""));
		setDispRsnCd(JSPUtil.getParameter(request, prefix + "disp_rsn_cd", ""));
		setEqTpszDesc(JSPUtil.getParameter(request, prefix + "eq_tpsz_desc", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setDispRlseNo(JSPUtil.getParameter(request, prefix + "disp_rlse_no", ""));
		setDispTrfUtPrc(JSPUtil.getParameter(request, prefix + "disp_trf_ut_prc", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setDispNo(JSPUtil.getParameter(request, prefix + "disp_no", ""));
		setDispRlseNoFlg(JSPUtil.getParameter(request, prefix + "disp_rlse_no_flg", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setDispVrfyTpCd(JSPUtil.getParameter(request, prefix + "disp_vrfy_tp_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setMvntDt(JSPUtil.getParameter(request, prefix + "mvnt_dt", ""));
		setFileSeq(JSPUtil.getParameter(request, prefix + "file_seq", ""));
		setRprCostAmt(JSPUtil.getParameter(request, prefix + "rpr_cost_amt", ""));
		setUserOfcCd(JSPUtil.getParameter(request, prefix + "user_ofc_cd", ""));
		setDispSoldDt(JSPUtil.getParameter(request, prefix + "disp_sold_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setMnrDispDtlRmk(JSPUtil.getParameter(request, prefix + "mnr_disp_dtl_rmk", ""));
		setMkrNm(JSPUtil.getParameter(request, prefix + "mkr_nm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setMnrPrnrCntCd(JSPUtil.getParameter(request, prefix + "mnr_prnr_cnt_cd", ""));
		setDispQty(JSPUtil.getParameter(request, prefix + "disp_qty", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setPartAmt(JSPUtil.getParameter(request, prefix + "part_amt", ""));
		setDispUtPrc(JSPUtil.getParameter(request, prefix + "disp_ut_prc", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setOldEqNo(JSPUtil.getParameter(request, prefix + "old_eq_no", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setDispTpCd(JSPUtil.getParameter(request, prefix + "disp_tp_cd", ""));
		setMdlNm(JSPUtil.getParameter(request, prefix + "mdl_nm", ""));
		setOldEqTpszCd(JSPUtil.getParameter(request, prefix + "old_eq_tpsz_cd", ""));
		setDispTrkrNm(JSPUtil.getParameter(request, prefix + "disp_trkr_nm", ""));
		setMvmtCd(JSPUtil.getParameter(request, prefix + "mvmt_cd", ""));
		setDispDtlSeq(JSPUtil.getParameter(request, prefix + "disp_dtl_seq", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setDispTpNm(JSPUtil.getParameter(request, prefix + "disp_tp_nm", ""));
		setOldSoldDt(JSPUtil.getParameter(request, prefix + "old_sold_dt", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setDispYdCd(JSPUtil.getParameter(request, prefix + "disp_yd_cd", ""));
		setDispUtTpCd(JSPUtil.getParameter(request, prefix + "disp_ut_tp_cd", ""));
		setLccDiffFlg(JSPUtil.getParameter(request, prefix + "lccDiffFlg", ""));
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
			String[] oldEqDispYdCd = (JSPUtil.getParameter(request, prefix	+ "old_eq_disp_yd_cd", length));
			String[] mtrlNm = (JSPUtil.getParameter(request, prefix	+ "mtrl_nm", length));
			String[] sdaysDt = (JSPUtil.getParameter(request, prefix	+ "sdays_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mnrPrnrSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_seq", length));
			String[] dispSoldDtFlg = (JSPUtil.getParameter(request, prefix	+ "disp_sold_dt_flg", length));
			String[] rcvInvSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_inv_seq", length));
			String[] dispRsnCd = (JSPUtil.getParameter(request, prefix	+ "disp_rsn_cd", length));
			String[] eqTpszDesc = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_desc", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] dispRlseNo = (JSPUtil.getParameter(request, prefix	+ "disp_rlse_no", length));
			String[] dispTrfUtPrc = (JSPUtil.getParameter(request, prefix	+ "disp_trf_ut_prc", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] dispNo = (JSPUtil.getParameter(request, prefix	+ "disp_no", length));
			String[] dispRlseNoFlg = (JSPUtil.getParameter(request, prefix	+ "disp_rlse_no_flg", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] dispVrfyTpCd = (JSPUtil.getParameter(request, prefix	+ "disp_vrfy_tp_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] mvntDt = (JSPUtil.getParameter(request, prefix	+ "mvnt_dt", length));
			String[] fileSeq = (JSPUtil.getParameter(request, prefix	+ "file_seq", length));
			String[] rprCostAmt = (JSPUtil.getParameter(request, prefix	+ "rpr_cost_amt", length));
			String[] userOfcCd = (JSPUtil.getParameter(request, prefix	+ "user_ofc_cd", length));
			String[] dispSoldDt = (JSPUtil.getParameter(request, prefix	+ "disp_sold_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] mnrDispDtlRmk = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_dtl_rmk", length));
			String[] mkrNm = (JSPUtil.getParameter(request, prefix	+ "mkr_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] mnrPrnrCntCd = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_cnt_cd", length));
			String[] dispQty = (JSPUtil.getParameter(request, prefix	+ "disp_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] partAmt = (JSPUtil.getParameter(request, prefix	+ "part_amt", length));
			String[] dispUtPrc = (JSPUtil.getParameter(request, prefix	+ "disp_ut_prc", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] oldEqNo = (JSPUtil.getParameter(request, prefix	+ "old_eq_no", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] dispTpCd = (JSPUtil.getParameter(request, prefix	+ "disp_tp_cd", length));
			String[] mdlNm = (JSPUtil.getParameter(request, prefix	+ "mdl_nm", length));
			String[] oldEqTpszCd = (JSPUtil.getParameter(request, prefix	+ "old_eq_tpsz_cd", length));
			String[] dispTrkrNm = (JSPUtil.getParameter(request, prefix	+ "disp_trkr_nm", length));
			String[] mvmtCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_cd", length));
			String[] dispDtlSeq = (JSPUtil.getParameter(request, prefix	+ "disp_dtl_seq", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] dispTpNm = (JSPUtil.getParameter(request, prefix	+ "disp_tp_nm", length));
			String[] oldSoldDt = (JSPUtil.getParameter(request, prefix	+ "old_sold_dt", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] dispYdCd = (JSPUtil.getParameter(request, prefix	+ "disp_yd_cd", length));
			String[] dispUtTpCd = (JSPUtil.getParameter(request, prefix	+ "disp_ut_tp_cd", length));
			String[] lccDiffFlg = (JSPUtil.getParameter(request, prefix	+ "lcc_diff_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrDispDtlVO();
				if (oldEqDispYdCd[i] != null)
					model.setOldEqDispYdCd(oldEqDispYdCd[i]);
				if (mtrlNm[i] != null)
					model.setMtrlNm(mtrlNm[i]);
				if (sdaysDt[i] != null)
					model.setSdaysDt(sdaysDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mnrPrnrSeq[i] != null)
					model.setMnrPrnrSeq(mnrPrnrSeq[i]);
				if (dispSoldDtFlg[i] != null)
					model.setDispSoldDtFlg(dispSoldDtFlg[i]);
				if (rcvInvSeq[i] != null)
					model.setRcvInvSeq(rcvInvSeq[i]);
				if (dispRsnCd[i] != null)
					model.setDispRsnCd(dispRsnCd[i]);
				if (eqTpszDesc[i] != null)
					model.setEqTpszDesc(eqTpszDesc[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (dispRlseNo[i] != null)
					model.setDispRlseNo(dispRlseNo[i]);
				if (dispTrfUtPrc[i] != null)
					model.setDispTrfUtPrc(dispTrfUtPrc[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (dispNo[i] != null)
					model.setDispNo(dispNo[i]);
				if (dispRlseNoFlg[i] != null)
					model.setDispRlseNoFlg(dispRlseNoFlg[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (dispVrfyTpCd[i] != null)
					model.setDispVrfyTpCd(dispVrfyTpCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (mvntDt[i] != null)
					model.setMvntDt(mvntDt[i]);
				if (fileSeq[i] != null)
					model.setFileSeq(fileSeq[i]);
				if (rprCostAmt[i] != null)
					model.setRprCostAmt(rprCostAmt[i]);
				if (userOfcCd[i] != null)
					model.setUserOfcCd(userOfcCd[i]);
				if (dispSoldDt[i] != null)
					model.setDispSoldDt(dispSoldDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (mnrDispDtlRmk[i] != null)
					model.setMnrDispDtlRmk(mnrDispDtlRmk[i]);
				if (mkrNm[i] != null)
					model.setMkrNm(mkrNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (mnrPrnrCntCd[i] != null)
					model.setMnrPrnrCntCd(mnrPrnrCntCd[i]);
				if (dispQty[i] != null)
					model.setDispQty(dispQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (partAmt[i] != null)
					model.setPartAmt(partAmt[i]);
				if (dispUtPrc[i] != null)
					model.setDispUtPrc(dispUtPrc[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (oldEqNo[i] != null)
					model.setOldEqNo(oldEqNo[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (dispTpCd[i] != null)
					model.setDispTpCd(dispTpCd[i]);
				if (mdlNm[i] != null)
					model.setMdlNm(mdlNm[i]);
				if (oldEqTpszCd[i] != null)
					model.setOldEqTpszCd(oldEqTpszCd[i]);
				if (dispTrkrNm[i] != null)
					model.setDispTrkrNm(dispTrkrNm[i]);
				if (mvmtCd[i] != null)
					model.setMvmtCd(mvmtCd[i]);
				if (dispDtlSeq[i] != null)
					model.setDispDtlSeq(dispDtlSeq[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (dispTpNm[i] != null)
					model.setDispTpNm(dispTpNm[i]);
				if (oldSoldDt[i] != null)
					model.setOldSoldDt(oldSoldDt[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (dispYdCd[i] != null)
					model.setDispYdCd(dispYdCd[i]);
				if (dispUtTpCd[i] != null)
					model.setDispUtTpCd(dispUtTpCd[i]);
				if (lccDiffFlg[i] != null)
					model.setLccDiffFlg(lccDiffFlg[i]);
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
		this.oldEqDispYdCd = this.oldEqDispYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtrlNm = this.mtrlNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sdaysDt = this.sdaysDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrSeq = this.mnrPrnrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispSoldDtFlg = this.dispSoldDtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvInvSeq = this.rcvInvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispRsnCd = this.dispRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszDesc = this.eqTpszDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispRlseNo = this.dispRlseNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispTrfUtPrc = this.dispTrfUtPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispNo = this.dispNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispRlseNoFlg = this.dispRlseNoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispVrfyTpCd = this.dispVrfyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvntDt = this.mvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSeq = this.fileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprCostAmt = this.rprCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userOfcCd = this.userOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispSoldDt = this.dispSoldDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispDtlRmk = this.mnrDispDtlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkrNm = this.mkrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrCntCd = this.mnrPrnrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispQty = this.dispQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.partAmt = this.partAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispUtPrc = this.dispUtPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldEqNo = this.oldEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispTpCd = this.dispTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdlNm = this.mdlNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldEqTpszCd = this.oldEqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispTrkrNm = this.dispTrkrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtCd = this.mvmtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispDtlSeq = this.dispDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispTpNm = this.dispTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldSoldDt = this.oldSoldDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispYdCd = this.dispYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispUtTpCd = this.dispUtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccDiffFlg = this.lccDiffFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
