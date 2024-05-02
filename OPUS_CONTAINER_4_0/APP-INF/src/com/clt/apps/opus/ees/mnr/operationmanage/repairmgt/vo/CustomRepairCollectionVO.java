/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomRepairCollectionVO.java
*@FileTitle : CustomRepairCollectionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.18
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.01.18 박명신 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo;

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
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomRepairCollectionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomRepairCollectionVO> models = new ArrayList<CustomRepairCollectionVO>();
	
	/* Column Info */
	private String mnrVrfyTpCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String rprRqstVerNo = null;
	/* Column Info */
	private String rqstRefNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String mnrWoTpCd = null;
	/* Column Info */
	private String totalAmt = null;
	/* Column Info */
	private String agmtOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String issDt = null;
	/* Column Info */
	private String mnrOrdOfcCtyCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costCd = null;
	/* Column Info */
	private String rqstEqNo = null;
	/* Column Info */
	private String mnrWrkAmt = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String rprRqstSeq = null;
	/* Column Info */
	private String estDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String rprRqstLstVerFlg = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String n3ptyFlg = null;
	/* Column Info */
	private String inputDt = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String rprStsCd = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String costCdNm = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String trsmModCd = null;
	/* Column Info */
	private String sprPrtSplYdCd = null;
	/* Column Info */
	private String ordHdrRmk = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String dmgFlag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String mnrOrdSeq = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String mnrOrdSndDt = null;
	/* Column Info */
	private String tmpSeq = null;
	/* Column Info */
	private String mnrInpTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CustomRepairCollectionVO() {}

	public CustomRepairCollectionVO(String ibflag, String pagerows, String mnrVrfyTpCd, String currCd, String rprRqstVerNo, String rqstRefNo, String creDt, String totalAmt, String mnrWoTpCd, String agmtOfcCd, String vndrNm, String mnrOrdOfcCtyCd, String issDt, String costCd, String rqstEqNo, String mnrWrkAmt, String invAmt, String woNo, String rprRqstSeq, String estDt, String updUsrId, String rprRqstLstVerFlg, String updDt, String n3ptyFlg, String inputDt, String costOfcCd, String rprStsCd, String status, String costCdNm, String eqKndCd, String trsmModCd, String eqTpszCd, String ordHdrRmk, String sprPrtSplYdCd, String invNo, String vvd, String dmgFlag, String creUsrId, String mnrOrdSeq, String mnrOrdSndDt, String vndrSeq, String tmpSeq, String mnrInpTpCd) {
		this.mnrVrfyTpCd = mnrVrfyTpCd;
		this.currCd = currCd;
		this.rprRqstVerNo = rprRqstVerNo;
		this.rqstRefNo = rqstRefNo;
		this.creDt = creDt;
		this.mnrWoTpCd = mnrWoTpCd;
		this.totalAmt = totalAmt;
		this.agmtOfcCd = agmtOfcCd;
		this.pagerows = pagerows;
		this.vndrNm = vndrNm;
		this.issDt = issDt;
		this.mnrOrdOfcCtyCd = mnrOrdOfcCtyCd;
		this.ibflag = ibflag;
		this.costCd = costCd;
		this.rqstEqNo = rqstEqNo;
		this.mnrWrkAmt = mnrWrkAmt;
		this.invAmt = invAmt;
		this.woNo = woNo;
		this.rprRqstSeq = rprRqstSeq;
		this.estDt = estDt;
		this.updUsrId = updUsrId;
		this.rprRqstLstVerFlg = rprRqstLstVerFlg;
		this.updDt = updDt;
		this.n3ptyFlg = n3ptyFlg;
		this.inputDt = inputDt;
		this.costOfcCd = costOfcCd;
		this.rprStsCd = rprStsCd;
		this.status = status;
		this.costCdNm = costCdNm;
		this.eqKndCd = eqKndCd;
		this.trsmModCd = trsmModCd;
		this.sprPrtSplYdCd = sprPrtSplYdCd;
		this.ordHdrRmk = ordHdrRmk;
		this.eqTpszCd = eqTpszCd;
		this.vvd = vvd;
		this.invNo = invNo;
		this.dmgFlag = dmgFlag;
		this.creUsrId = creUsrId;
		this.mnrOrdSeq = mnrOrdSeq;
		this.vndrSeq = vndrSeq;
		this.mnrOrdSndDt = mnrOrdSndDt;
		this.tmpSeq = tmpSeq;
		this.mnrInpTpCd = mnrInpTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mnr_wo_tp_cd", getMnrWoTpCd());
		this.hashColumns.put("agmt_ofc_cd", getAgmtOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("mnr_ord_ofc_cty_cd", getMnrOrdOfcCtyCd());
		this.hashColumns.put("cost_cd", getCostCd());
		this.hashColumns.put("mnr_wrk_amt", getMnrWrkAmt());
		this.hashColumns.put("rpr_rqst_seq", getRprRqstSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rpr_sts_cd", getRprStsCd());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("trsm_mod_cd", getTrsmModCd());
		this.hashColumns.put("ord_hdr_rmk", getOrdHdrRmk());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("dmg_flag", getDmgFlag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("mnr_vrfy_tp_cd", getMnrVrfyTpCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("rpr_rqst_ver_no", getRprRqstVerNo());
		this.hashColumns.put("rqst_ref_no", getRqstRefNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("total_amt", getTotalAmt());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rqst_eq_no", getRqstEqNo());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("est_dt", getEstDt());
		this.hashColumns.put("rpr_rqst_lst_ver_flg", getRprRqstLstVerFlg());
		this.hashColumns.put("n3pty_flg", getN3ptyFlg());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("input_dt", getInputDt());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("cost_cd_nm", getCostCdNm());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("spr_prt_spl_yd_cd", getSprPrtSplYdCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("mnr_ord_seq", getMnrOrdSeq());
		this.hashColumns.put("mnr_ord_snd_dt", getMnrOrdSndDt());
		this.hashColumns.put("tmp_seq", getTmpSeq());
		this.hashColumns.put("mnr_inp_tp_cd", getMnrInpTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mnr_wo_tp_cd", "mnrWoTpCd");
		this.hashFields.put("agmt_ofc_cd", "agmtOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("mnr_ord_ofc_cty_cd", "mnrOrdOfcCtyCd");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("mnr_wrk_amt", "mnrWrkAmt");
		this.hashFields.put("rpr_rqst_seq", "rprRqstSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rpr_sts_cd", "rprStsCd");
		this.hashFields.put("status", "status");
		this.hashFields.put("trsm_mod_cd", "trsmModCd");
		this.hashFields.put("ord_hdr_rmk", "ordHdrRmk");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("dmg_flag", "dmgFlag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("mnr_vrfy_tp_cd", "mnrVrfyTpCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("rpr_rqst_ver_no", "rprRqstVerNo");
		this.hashFields.put("rqst_ref_no", "rqstRefNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("total_amt", "totalAmt");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rqst_eq_no", "rqstEqNo");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("est_dt", "estDt");
		this.hashFields.put("rpr_rqst_lst_ver_flg", "rprRqstLstVerFlg");
		this.hashFields.put("n3pty_flg", "n3ptyFlg");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("input_dt", "inputDt");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("cost_cd_nm", "costCdNm");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("spr_prt_spl_yd_cd", "sprPrtSplYdCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("mnr_ord_seq", "mnrOrdSeq");
		this.hashFields.put("mnr_ord_snd_dt", "mnrOrdSndDt");
		this.hashFields.put("tmp_seq", "tmpSeq");
		this.hashFields.put("mnr_inp_tp_cd", "mnrInpTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mnrVrfyTpCd
	 */
	public String getMnrVrfyTpCd() {
		return this.mnrVrfyTpCd;
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
	 * @return rprRqstVerNo
	 */
	public String getRprRqstVerNo() {
		return this.rprRqstVerNo;
	}
	
	/**
	 * Column Info
	 * @return rqstRefNo
	 */
	public String getRqstRefNo() {
		return this.rqstRefNo;
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
	 * @return mnrWoTpCd
	 */
	public String getMnrWoTpCd() {
		return this.mnrWoTpCd;
	}
	
	/**
	 * Column Info
	 * @return totalAmt
	 */
	public String getTotalAmt() {
		return this.totalAmt;
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
	 * @return issDt
	 */
	public String getIssDt() {
		return this.issDt;
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
	 * @return costCd
	 */
	public String getCostCd() {
		return this.costCd;
	}
	
	/**
	 * Column Info
	 * @return rqstEqNo
	 */
	public String getRqstEqNo() {
		return this.rqstEqNo;
	}
	
	/**
	 * Column Info
	 * @return mnrWrkAmt
	 */
	public String getMnrWrkAmt() {
		return this.mnrWrkAmt;
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
	 * @return woNo
	 */
	public String getWoNo() {
		return this.woNo;
	}
	
	/**
	 * Column Info
	 * @return rprRqstSeq
	 */
	public String getRprRqstSeq() {
		return this.rprRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return estDt
	 */
	public String getEstDt() {
		return this.estDt;
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
	 * @return rprRqstLstVerFlg
	 */
	public String getRprRqstLstVerFlg() {
		return this.rprRqstLstVerFlg;
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
	 * @return n3ptyFlg
	 */
	public String getN3ptyFlg() {
		return this.n3ptyFlg;
	}
	
	/**
	 * Column Info
	 * @return inputDt
	 */
	public String getInputDt() {
		return this.inputDt;
	}
	
	/**
	 * Column Info
	 * @return costOfcCd
	 */
	public String getCostOfcCd() {
		return this.costOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rprStsCd
	 */
	public String getRprStsCd() {
		return this.rprStsCd;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return costCdNm
	 */
	public String getCostCdNm() {
		return this.costCdNm;
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
	 * @return trsmModCd
	 */
	public String getTrsmModCd() {
		return this.trsmModCd;
	}
	
	/**
	 * Column Info
	 * @return sprPrtSplYdCd
	 */
	public String getSprPrtSplYdCd() {
		return this.sprPrtSplYdCd;
	}
	
	/**
	 * Column Info
	 * @return ordHdrRmk
	 */
	public String getOrdHdrRmk() {
		return this.ordHdrRmk;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return dmgFlag
	 */
	public String getDmgFlag() {
		return this.dmgFlag;
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
	 * @return mnrOrdSeq
	 */
	public String getMnrOrdSeq() {
		return this.mnrOrdSeq;
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
	 * @return mnrOrdSndDt
	 */
	public String getMnrOrdSndDt() {
		return this.mnrOrdSndDt;
	}
	
	/**
	 * Column Info
	 * @return tmpSeq
	 */
	public String getTmpSeq() {
		return this.tmpSeq;
	}
	
	/**
	 * Column Info
	 * @return mnrInpTpCd
	 */
	public String getMnrInpTpCd() {
		return this.mnrInpTpCd;
	}
	
	/**
	 * Column Info
	 * @param mnrVrfyTpCd
	 */
	public void setMnrVrfyTpCd(String mnrVrfyTpCd) {
		this.mnrVrfyTpCd = mnrVrfyTpCd;
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
	 * @param rprRqstVerNo
	 */
	public void setRprRqstVerNo(String rprRqstVerNo) {
		this.rprRqstVerNo = rprRqstVerNo;
	}
	
	/**
	 * Column Info
	 * @param rqstRefNo
	 */
	public void setRqstRefNo(String rqstRefNo) {
		this.rqstRefNo = rqstRefNo;
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
	 * @param mnrWoTpCd
	 */
	public void setMnrWoTpCd(String mnrWoTpCd) {
		this.mnrWoTpCd = mnrWoTpCd;
	}
	
	/**
	 * Column Info
	 * @param totalAmt
	 */
	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
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
	 * @param issDt
	 */
	public void setIssDt(String issDt) {
		this.issDt = issDt;
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
	 * @param costCd
	 */
	public void setCostCd(String costCd) {
		this.costCd = costCd;
	}
	
	/**
	 * Column Info
	 * @param rqstEqNo
	 */
	public void setRqstEqNo(String rqstEqNo) {
		this.rqstEqNo = rqstEqNo;
	}
	
	/**
	 * Column Info
	 * @param mnrWrkAmt
	 */
	public void setMnrWrkAmt(String mnrWrkAmt) {
		this.mnrWrkAmt = mnrWrkAmt;
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
	 * @param woNo
	 */
	public void setWoNo(String woNo) {
		this.woNo = woNo;
	}
	
	/**
	 * Column Info
	 * @param rprRqstSeq
	 */
	public void setRprRqstSeq(String rprRqstSeq) {
		this.rprRqstSeq = rprRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param estDt
	 */
	public void setEstDt(String estDt) {
		this.estDt = estDt;
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
	 * @param rprRqstLstVerFlg
	 */
	public void setRprRqstLstVerFlg(String rprRqstLstVerFlg) {
		this.rprRqstLstVerFlg = rprRqstLstVerFlg;
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
	 * @param n3ptyFlg
	 */
	public void setN3ptyFlg(String n3ptyFlg) {
		this.n3ptyFlg = n3ptyFlg;
	}
	
	/**
	 * Column Info
	 * @param inputDt
	 */
	public void setInputDt(String inputDt) {
		this.inputDt = inputDt;
	}
	
	/**
	 * Column Info
	 * @param costOfcCd
	 */
	public void setCostOfcCd(String costOfcCd) {
		this.costOfcCd = costOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rprStsCd
	 */
	public void setRprStsCd(String rprStsCd) {
		this.rprStsCd = rprStsCd;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param costCdNm
	 */
	public void setCostCdNm(String costCdNm) {
		this.costCdNm = costCdNm;
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
	 * @param trsmModCd
	 */
	public void setTrsmModCd(String trsmModCd) {
		this.trsmModCd = trsmModCd;
	}
	
	/**
	 * Column Info
	 * @param sprPrtSplYdCd
	 */
	public void setSprPrtSplYdCd(String sprPrtSplYdCd) {
		this.sprPrtSplYdCd = sprPrtSplYdCd;
	}
	
	/**
	 * Column Info
	 * @param ordHdrRmk
	 */
	public void setOrdHdrRmk(String ordHdrRmk) {
		this.ordHdrRmk = ordHdrRmk;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param dmgFlag
	 */
	public void setDmgFlag(String dmgFlag) {
		this.dmgFlag = dmgFlag;
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
	 * @param mnrOrdSeq
	 */
	public void setMnrOrdSeq(String mnrOrdSeq) {
		this.mnrOrdSeq = mnrOrdSeq;
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
	 * @param mnrOrdSndDt
	 */
	public void setMnrOrdSndDt(String mnrOrdSndDt) {
		this.mnrOrdSndDt = mnrOrdSndDt;
	}
	
	/**
	 * Column Info
	 * @param tmpSeq
	 */
	public void setTmpSeq(String tmpSeq) {
		this.tmpSeq = tmpSeq;
	}
	
	/**
	 * Column Info
	 * @param mnrInpTpCd
	 */
	public void setMnrInpTpCd(String mnrInpTpCd) {
		this.mnrInpTpCd = mnrInpTpCd;
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
		setMnrVrfyTpCd(JSPUtil.getParameter(request, prefix + "mnr_vrfy_tp_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setRprRqstVerNo(JSPUtil.getParameter(request, prefix + "rpr_rqst_ver_no", ""));
		setRqstRefNo(JSPUtil.getParameter(request, prefix + "rqst_ref_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setMnrWoTpCd(JSPUtil.getParameter(request, prefix + "mnr_wo_tp_cd", ""));
		setTotalAmt(JSPUtil.getParameter(request, prefix + "total_amt", ""));
		setAgmtOfcCd(JSPUtil.getParameter(request, prefix + "agmt_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setIssDt(JSPUtil.getParameter(request, prefix + "iss_dt", ""));
		setMnrOrdOfcCtyCd(JSPUtil.getParameter(request, prefix + "mnr_ord_ofc_cty_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostCd(JSPUtil.getParameter(request, prefix + "cost_cd", ""));
		setRqstEqNo(JSPUtil.getParameter(request, prefix + "rqst_eq_no", ""));
		setMnrWrkAmt(JSPUtil.getParameter(request, prefix + "mnr_wrk_amt", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setWoNo(JSPUtil.getParameter(request, prefix + "wo_no", ""));
		setRprRqstSeq(JSPUtil.getParameter(request, prefix + "rpr_rqst_seq", ""));
		setEstDt(JSPUtil.getParameter(request, prefix + "est_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setRprRqstLstVerFlg(JSPUtil.getParameter(request, prefix + "rpr_rqst_lst_ver_flg", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setN3ptyFlg(JSPUtil.getParameter(request, prefix + "n3pty_flg", ""));
		setInputDt(JSPUtil.getParameter(request, prefix + "input_dt", ""));
		setCostOfcCd(JSPUtil.getParameter(request, prefix + "cost_ofc_cd", ""));
		setRprStsCd(JSPUtil.getParameter(request, prefix + "rpr_sts_cd", ""));
		setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
		setCostCdNm(JSPUtil.getParameter(request, prefix + "cost_cd_nm", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setTrsmModCd(JSPUtil.getParameter(request, prefix + "trsm_mod_cd", ""));
		setSprPrtSplYdCd(JSPUtil.getParameter(request, prefix + "spr_prt_spl_yd_cd", ""));
		setOrdHdrRmk(JSPUtil.getParameter(request, prefix + "ord_hdr_rmk", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setDmgFlag(JSPUtil.getParameter(request, prefix + "dmg_flag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setMnrOrdSeq(JSPUtil.getParameter(request, prefix + "mnr_ord_seq", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setMnrOrdSndDt(JSPUtil.getParameter(request, prefix + "mnr_ord_snd_dt", ""));
		setTmpSeq(JSPUtil.getParameter(request, prefix + "tmp_seq", ""));
		setMnrInpTpCd(JSPUtil.getParameter(request, prefix + "mnr_inp_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomRepairCollectionVO[]
	 */
	public CustomRepairCollectionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomRepairCollectionVO[]
	 */
	public CustomRepairCollectionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomRepairCollectionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mnrVrfyTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_vrfy_tp_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] rprRqstVerNo = (JSPUtil.getParameter(request, prefix	+ "rpr_rqst_ver_no", length));
			String[] rqstRefNo = (JSPUtil.getParameter(request, prefix	+ "rqst_ref_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] mnrWoTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_wo_tp_cd", length));
			String[] totalAmt = (JSPUtil.getParameter(request, prefix	+ "total_amt", length));
			String[] agmtOfcCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] mnrOrdOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "mnr_ord_ofc_cty_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costCd = (JSPUtil.getParameter(request, prefix	+ "cost_cd", length));
			String[] rqstEqNo = (JSPUtil.getParameter(request, prefix	+ "rqst_eq_no", length));
			String[] mnrWrkAmt = (JSPUtil.getParameter(request, prefix	+ "mnr_wrk_amt", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] rprRqstSeq = (JSPUtil.getParameter(request, prefix	+ "rpr_rqst_seq", length));
			String[] estDt = (JSPUtil.getParameter(request, prefix	+ "est_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] rprRqstLstVerFlg = (JSPUtil.getParameter(request, prefix	+ "rpr_rqst_lst_ver_flg", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] n3ptyFlg = (JSPUtil.getParameter(request, prefix	+ "n3pty_flg", length));
			String[] inputDt = (JSPUtil.getParameter(request, prefix	+ "input_dt", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd", length));
			String[] rprStsCd = (JSPUtil.getParameter(request, prefix	+ "rpr_sts_cd", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] costCdNm = (JSPUtil.getParameter(request, prefix	+ "cost_cd_nm", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] trsmModCd = (JSPUtil.getParameter(request, prefix	+ "trsm_mod_cd", length));
			String[] sprPrtSplYdCd = (JSPUtil.getParameter(request, prefix	+ "spr_prt_spl_yd_cd", length));
			String[] ordHdrRmk = (JSPUtil.getParameter(request, prefix	+ "ord_hdr_rmk", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] dmgFlag = (JSPUtil.getParameter(request, prefix	+ "dmg_flag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] mnrOrdSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_ord_seq", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] mnrOrdSndDt = (JSPUtil.getParameter(request, prefix	+ "mnr_ord_snd_dt", length));
			String[] tmpSeq = (JSPUtil.getParameter(request, prefix	+ "tmp_seq", length));
			String[] mnrInpTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_inp_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomRepairCollectionVO();
				if (mnrVrfyTpCd[i] != null)
					model.setMnrVrfyTpCd(mnrVrfyTpCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (rprRqstVerNo[i] != null)
					model.setRprRqstVerNo(rprRqstVerNo[i]);
				if (rqstRefNo[i] != null)
					model.setRqstRefNo(rqstRefNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (mnrWoTpCd[i] != null)
					model.setMnrWoTpCd(mnrWoTpCd[i]);
				if (totalAmt[i] != null)
					model.setTotalAmt(totalAmt[i]);
				if (agmtOfcCd[i] != null)
					model.setAgmtOfcCd(agmtOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (mnrOrdOfcCtyCd[i] != null)
					model.setMnrOrdOfcCtyCd(mnrOrdOfcCtyCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costCd[i] != null)
					model.setCostCd(costCd[i]);
				if (rqstEqNo[i] != null)
					model.setRqstEqNo(rqstEqNo[i]);
				if (mnrWrkAmt[i] != null)
					model.setMnrWrkAmt(mnrWrkAmt[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (rprRqstSeq[i] != null)
					model.setRprRqstSeq(rprRqstSeq[i]);
				if (estDt[i] != null)
					model.setEstDt(estDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (rprRqstLstVerFlg[i] != null)
					model.setRprRqstLstVerFlg(rprRqstLstVerFlg[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (n3ptyFlg[i] != null)
					model.setN3ptyFlg(n3ptyFlg[i]);
				if (inputDt[i] != null)
					model.setInputDt(inputDt[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (rprStsCd[i] != null)
					model.setRprStsCd(rprStsCd[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (costCdNm[i] != null)
					model.setCostCdNm(costCdNm[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (trsmModCd[i] != null)
					model.setTrsmModCd(trsmModCd[i]);
				if (sprPrtSplYdCd[i] != null)
					model.setSprPrtSplYdCd(sprPrtSplYdCd[i]);
				if (ordHdrRmk[i] != null)
					model.setOrdHdrRmk(ordHdrRmk[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (dmgFlag[i] != null)
					model.setDmgFlag(dmgFlag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (mnrOrdSeq[i] != null)
					model.setMnrOrdSeq(mnrOrdSeq[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (mnrOrdSndDt[i] != null)
					model.setMnrOrdSndDt(mnrOrdSndDt[i]);
				if (tmpSeq[i] != null)
					model.setTmpSeq(tmpSeq[i]);
				if (mnrInpTpCd[i] != null)
					model.setMnrInpTpCd(mnrInpTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomRepairCollectionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomRepairCollectionVO[]
	 */
	public CustomRepairCollectionVO[] getCustomRepairCollectionVOs(){
		CustomRepairCollectionVO[] vos = (CustomRepairCollectionVO[])models.toArray(new CustomRepairCollectionVO[models.size()]);
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
		this.mnrVrfyTpCd = this.mnrVrfyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRqstVerNo = this.rprRqstVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstRefNo = this.rqstRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrWoTpCd = this.mnrWoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalAmt = this.totalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCd = this.agmtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdOfcCtyCd = this.mnrOrdOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd = this.costCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstEqNo = this.rqstEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrWrkAmt = this.mnrWrkAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRqstSeq = this.rprRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estDt = this.estDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRqstLstVerFlg = this.rprRqstLstVerFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyFlg = this.n3ptyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputDt = this.inputDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprStsCd = this.rprStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCdNm = this.costCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmModCd = this.trsmModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtSplYdCd = this.sprPrtSplYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ordHdrRmk = this.ordHdrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlag = this.dmgFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdSeq = this.mnrOrdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdSndDt = this.mnrOrdSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpSeq = this.tmpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrInpTpCd = this.mnrInpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
