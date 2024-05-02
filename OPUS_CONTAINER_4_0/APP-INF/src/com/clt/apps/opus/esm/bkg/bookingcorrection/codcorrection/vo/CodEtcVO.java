/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodEtcVO.java
*@FileTitle : CodEtcVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.29
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.12.29 류대영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo;

import java.lang.reflect.Field;
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
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CodEtcVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CodEtcVO> models = new ArrayList<CodEtcVO>();
	
	/* Column Info */
	private String newPodNodCd = null;
	/* Column Info */
	private String newPolNodCd = null;
	/* Column Info */
	private String oldDeTermCd = null;
	/* Column Info */
	private String newPstCd = null;
	/* Column Info */
	private String newPorNodCd = null;
	/* Column Info */
	private String oldPodNodCd = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String newDelNodCd = null;
	/* Column Info */
	private String oldPreNodCd = null;
	/* Column Info */
	private String approvalRso = null;
	/* Column Info */
	private String oldPorNodCd = null;
	/* Column Info */
	private String newDelCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pctlNo = null;
	/* Column Info */
	private String newPolCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String newPreNodCd = null;
	/* Column Info */
	private String oldPstNodCd = null;
	/* Column Info */
	private String oldDelCd = null;
	/* Column Info */
	private String rehandlingPort = null;
	/* Column Info */
	private String codReason = null;
	/* Column Info */
	private String newPreCd = null;
	/* Column Info */
	private String cannotConfirmFlg = null;
	/* Column Info */
	private String codMnlFlg = null;
	/* Column Info */
	private String oldTvvd = null;
	/* Column Info */
	private String newDeTermCd = null;
	/* Column Info */
	private String newPorCd = null;
	/* Column Info */
	private String newPstNodCd = null;
	/* Column Info */
	private String codStatus = null;
	/* Column Info */
	private String rejectReasonRemark = null;
	/* Column Info */
	private String oldPorCd = null;
	/* Column Info */
	private String oldPreCd = null;
	/* Column Info */
	private String oldPolCd = null;
	/* Column Info */
	private String oldPstCd = null;
	/* Column Info */
	private String arrpoval = null;
	/* Column Info */
	private String codRemark = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String rejectReasonCode = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String oldDelNodCd = null;
	/* Column Info */
	private String newTvvd = null;
	/* Column Info */
	private String oldPodCd = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String newPodCd = null;
	/* Column Info */
	private String oldPolNodCd = null;
	/* Column Info */
	private String maxSeq = null;
	/* Column Info */
	private String codCnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CodEtcVO() {}

	public CodEtcVO(String ibflag, String pagerows, String bkgNo, String blNo, String blTpCd, String codStatus, String seq, String arrpoval, String approvalRso, String codReason, String codRemark, String rehandlingPort, String rejectReasonCode, String rejectReasonRemark, String codMnlFlg, String pctlNo, String oldPorCd, String oldPorNodCd, String oldPolCd, String oldPolNodCd, String oldPodCd, String oldPodNodCd, String oldDelCd, String oldDelNodCd, String oldDeTermCd, String oldPreCd, String oldPreNodCd, String oldPstCd, String oldPstNodCd, String oldTvvd, String newPorCd, String newPorNodCd, String newPolCd, String newPolNodCd, String newPodCd, String newPodNodCd, String newDelCd, String newDelNodCd, String newDeTermCd, String newPreCd, String newPreNodCd, String newPstCd, String newPstNodCd, String newTvvd, String bkgStsCd, String bdrFlg, String cannotConfirmFlg, String maxSeq, String codCnt) {
		this.newPodNodCd = newPodNodCd;
		this.newPolNodCd = newPolNodCd;
		this.oldDeTermCd = oldDeTermCd;
		this.newPstCd = newPstCd;
		this.newPorNodCd = newPorNodCd;
		this.oldPodNodCd = oldPodNodCd;
		this.bdrFlg = bdrFlg;
		this.bkgStsCd = bkgStsCd;
		this.newDelNodCd = newDelNodCd;
		this.oldPreNodCd = oldPreNodCd;
		this.approvalRso = approvalRso;
		this.oldPorNodCd = oldPorNodCd;
		this.newDelCd = newDelCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.pctlNo = pctlNo;
		this.newPolCd = newPolCd;
		this.ibflag = ibflag;
		this.newPreNodCd = newPreNodCd;
		this.oldPstNodCd = oldPstNodCd;
		this.oldDelCd = oldDelCd;
		this.rehandlingPort = rehandlingPort;
		this.codReason = codReason;
		this.newPreCd = newPreCd;
		this.cannotConfirmFlg = cannotConfirmFlg;
		this.codMnlFlg = codMnlFlg;
		this.oldTvvd = oldTvvd;
		this.newDeTermCd = newDeTermCd;
		this.newPorCd = newPorCd;
		this.newPstNodCd = newPstNodCd;
		this.codStatus = codStatus;
		this.rejectReasonRemark = rejectReasonRemark;
		this.oldPorCd = oldPorCd;
		this.oldPreCd = oldPreCd;
		this.oldPolCd = oldPolCd;
		this.oldPstCd = oldPstCd;
		this.arrpoval = arrpoval;
		this.codRemark = codRemark;
		this.blTpCd = blTpCd;
		this.rejectReasonCode = rejectReasonCode;
		this.bkgNo = bkgNo;
		this.oldDelNodCd = oldDelNodCd;
		this.newTvvd = newTvvd;
		this.oldPodCd = oldPodCd;
		this.seq = seq;
		this.newPodCd = newPodCd;
		this.oldPolNodCd = oldPolNodCd;
		this.maxSeq = maxSeq;
		this.codCnt = codCnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("new_pod_nod_cd", getNewPodNodCd());
		this.hashColumns.put("new_pol_nod_cd", getNewPolNodCd());
		this.hashColumns.put("old_de_term_cd", getOldDeTermCd());
		this.hashColumns.put("new_pst_cd", getNewPstCd());
		this.hashColumns.put("new_por_nod_cd", getNewPorNodCd());
		this.hashColumns.put("old_pod_nod_cd", getOldPodNodCd());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("new_del_nod_cd", getNewDelNodCd());
		this.hashColumns.put("old_pre_nod_cd", getOldPreNodCd());
		this.hashColumns.put("approval_rso", getApprovalRso());
		this.hashColumns.put("old_por_nod_cd", getOldPorNodCd());
		this.hashColumns.put("new_del_cd", getNewDelCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pctl_no", getPctlNo());
		this.hashColumns.put("new_pol_cd", getNewPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("new_pre_nod_cd", getNewPreNodCd());
		this.hashColumns.put("old_pst_nod_cd", getOldPstNodCd());
		this.hashColumns.put("old_del_cd", getOldDelCd());
		this.hashColumns.put("rehandling_port", getRehandlingPort());
		this.hashColumns.put("cod_reason", getCodReason());
		this.hashColumns.put("new_pre_cd", getNewPreCd());
		this.hashColumns.put("cannot_confirm_flg", getCannotConfirmFlg());
		this.hashColumns.put("cod_mnl_flg", getCodMnlFlg());
		this.hashColumns.put("old_tvvd", getOldTvvd());
		this.hashColumns.put("new_de_term_cd", getNewDeTermCd());
		this.hashColumns.put("new_por_cd", getNewPorCd());
		this.hashColumns.put("new_pst_nod_cd", getNewPstNodCd());
		this.hashColumns.put("cod_status", getCodStatus());
		this.hashColumns.put("reject_reason_remark", getRejectReasonRemark());
		this.hashColumns.put("old_por_cd", getOldPorCd());
		this.hashColumns.put("old_pre_cd", getOldPreCd());
		this.hashColumns.put("old_pol_cd", getOldPolCd());
		this.hashColumns.put("old_pst_cd", getOldPstCd());
		this.hashColumns.put("arrpoval", getArrpoval());
		this.hashColumns.put("cod_remark", getCodRemark());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("reject_reason_code", getRejectReasonCode());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("old_del_nod_cd", getOldDelNodCd());
		this.hashColumns.put("new_tvvd", getNewTvvd());
		this.hashColumns.put("old_pod_cd", getOldPodCd());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("new_pod_cd", getNewPodCd());
		this.hashColumns.put("old_pol_nod_cd", getOldPolNodCd());
		this.hashColumns.put("max_seq", getMaxSeq());
		this.hashColumns.put("cod_cnt", getCodCnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("new_pod_nod_cd", "newPodNodCd");
		this.hashFields.put("new_pol_nod_cd", "newPolNodCd");
		this.hashFields.put("old_de_term_cd", "oldDeTermCd");
		this.hashFields.put("new_pst_cd", "newPstCd");
		this.hashFields.put("new_por_nod_cd", "newPorNodCd");
		this.hashFields.put("old_pod_nod_cd", "oldPodNodCd");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("new_del_nod_cd", "newDelNodCd");
		this.hashFields.put("old_pre_nod_cd", "oldPreNodCd");
		this.hashFields.put("approval_rso", "approvalRso");
		this.hashFields.put("old_por_nod_cd", "oldPorNodCd");
		this.hashFields.put("new_del_cd", "newDelCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pctl_no", "pctlNo");
		this.hashFields.put("new_pol_cd", "newPolCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("new_pre_nod_cd", "newPreNodCd");
		this.hashFields.put("old_pst_nod_cd", "oldPstNodCd");
		this.hashFields.put("old_del_cd", "oldDelCd");
		this.hashFields.put("rehandling_port", "rehandlingPort");
		this.hashFields.put("cod_reason", "codReason");
		this.hashFields.put("new_pre_cd", "newPreCd");
		this.hashFields.put("cannot_confirm_flg", "cannotConfirmFlg");
		this.hashFields.put("cod_mnl_flg", "codMnlFlg");
		this.hashFields.put("old_tvvd", "oldTvvd");
		this.hashFields.put("new_de_term_cd", "newDeTermCd");
		this.hashFields.put("new_por_cd", "newPorCd");
		this.hashFields.put("new_pst_nod_cd", "newPstNodCd");
		this.hashFields.put("cod_status", "codStatus");
		this.hashFields.put("reject_reason_remark", "rejectReasonRemark");
		this.hashFields.put("old_por_cd", "oldPorCd");
		this.hashFields.put("old_pre_cd", "oldPreCd");
		this.hashFields.put("old_pol_cd", "oldPolCd");
		this.hashFields.put("old_pst_cd", "oldPstCd");
		this.hashFields.put("arrpoval", "arrpoval");
		this.hashFields.put("cod_remark", "codRemark");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("reject_reason_code", "rejectReasonCode");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("old_del_nod_cd", "oldDelNodCd");
		this.hashFields.put("new_tvvd", "newTvvd");
		this.hashFields.put("old_pod_cd", "oldPodCd");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("new_pod_cd", "newPodCd");
		this.hashFields.put("old_pol_nod_cd", "oldPolNodCd");
		this.hashFields.put("max_seq", "maxSeq");
		this.hashFields.put("cod_cnt", "codCnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return newPodNodCd
	 */
	public String getNewPodNodCd() {
		return this.newPodNodCd;
	}
	
	/**
	 * Column Info
	 * @return newPolNodCd
	 */
	public String getNewPolNodCd() {
		return this.newPolNodCd;
	}
	
	/**
	 * Column Info
	 * @return oldDeTermCd
	 */
	public String getOldDeTermCd() {
		return this.oldDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return newPstCd
	 */
	public String getNewPstCd() {
		return this.newPstCd;
	}
	
	/**
	 * Column Info
	 * @return newPorNodCd
	 */
	public String getNewPorNodCd() {
		return this.newPorNodCd;
	}
	
	/**
	 * Column Info
	 * @return oldPodNodCd
	 */
	public String getOldPodNodCd() {
		return this.oldPodNodCd;
	}
	
	/**
	 * Column Info
	 * @return bdrFlg
	 */
	public String getBdrFlg() {
		return this.bdrFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return newDelNodCd
	 */
	public String getNewDelNodCd() {
		return this.newDelNodCd;
	}
	
	/**
	 * Column Info
	 * @return oldPreNodCd
	 */
	public String getOldPreNodCd() {
		return this.oldPreNodCd;
	}
	
	/**
	 * Column Info
	 * @return approvalRso
	 */
	public String getApprovalRso() {
		return this.approvalRso;
	}
	
	/**
	 * Column Info
	 * @return oldPorNodCd
	 */
	public String getOldPorNodCd() {
		return this.oldPorNodCd;
	}
	
	/**
	 * Column Info
	 * @return newDelCd
	 */
	public String getNewDelCd() {
		return this.newDelCd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return pctlNo
	 */
	public String getPctlNo() {
		return this.pctlNo;
	}
	
	/**
	 * Column Info
	 * @return newPolCd
	 */
	public String getNewPolCd() {
		return this.newPolCd;
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
	 * @return newPreNodCd
	 */
	public String getNewPreNodCd() {
		return this.newPreNodCd;
	}
	
	/**
	 * Column Info
	 * @return oldPstNodCd
	 */
	public String getOldPstNodCd() {
		return this.oldPstNodCd;
	}
	
	/**
	 * Column Info
	 * @return oldDelCd
	 */
	public String getOldDelCd() {
		return this.oldDelCd;
	}
	
	/**
	 * Column Info
	 * @return rehandlingPort
	 */
	public String getRehandlingPort() {
		return this.rehandlingPort;
	}
	
	/**
	 * Column Info
	 * @return codReason
	 */
	public String getCodReason() {
		return this.codReason;
	}
	
	/**
	 * Column Info
	 * @return newPreCd
	 */
	public String getNewPreCd() {
		return this.newPreCd;
	}
	
	/**
	 * Column Info
	 * @return cannotConfirmFlg
	 */
	public String getCannotConfirmFlg() {
		return this.cannotConfirmFlg;
	}
	
	/**
	 * Column Info
	 * @return codMnlFlg
	 */
	public String getCodMnlFlg() {
		return this.codMnlFlg;
	}
	
	/**
	 * Column Info
	 * @return oldTvvd
	 */
	public String getOldTvvd() {
		return this.oldTvvd;
	}
	
	/**
	 * Column Info
	 * @return newDeTermCd
	 */
	public String getNewDeTermCd() {
		return this.newDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return newPorCd
	 */
	public String getNewPorCd() {
		return this.newPorCd;
	}
	
	/**
	 * Column Info
	 * @return newPstNodCd
	 */
	public String getNewPstNodCd() {
		return this.newPstNodCd;
	}
	
	/**
	 * Column Info
	 * @return codStatus
	 */
	public String getCodStatus() {
		return this.codStatus;
	}
	
	/**
	 * Column Info
	 * @return rejectReasonRemark
	 */
	public String getRejectReasonRemark() {
		return this.rejectReasonRemark;
	}
	
	/**
	 * Column Info
	 * @return oldPorCd
	 */
	public String getOldPorCd() {
		return this.oldPorCd;
	}
	
	/**
	 * Column Info
	 * @return oldPreCd
	 */
	public String getOldPreCd() {
		return this.oldPreCd;
	}
	
	/**
	 * Column Info
	 * @return oldPolCd
	 */
	public String getOldPolCd() {
		return this.oldPolCd;
	}
	
	/**
	 * Column Info
	 * @return oldPstCd
	 */
	public String getOldPstCd() {
		return this.oldPstCd;
	}
	
	/**
	 * Column Info
	 * @return arrpoval
	 */
	public String getArrpoval() {
		return this.arrpoval;
	}
	
	/**
	 * Column Info
	 * @return codRemark
	 */
	public String getCodRemark() {
		return this.codRemark;
	}
	
	/**
	 * Column Info
	 * @return blTpCd
	 */
	public String getBlTpCd() {
		return this.blTpCd;
	}
	
	/**
	 * Column Info
	 * @return rejectReasonCode
	 */
	public String getRejectReasonCode() {
		return this.rejectReasonCode;
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
	 * @return oldDelNodCd
	 */
	public String getOldDelNodCd() {
		return this.oldDelNodCd;
	}
	
	/**
	 * Column Info
	 * @return newTvvd
	 */
	public String getNewTvvd() {
		return this.newTvvd;
	}
	
	/**
	 * Column Info
	 * @return oldPodCd
	 */
	public String getOldPodCd() {
		return this.oldPodCd;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return newPodCd
	 */
	public String getNewPodCd() {
		return this.newPodCd;
	}
	
	/**
	 * Column Info
	 * @return oldPolNodCd
	 */
	public String getOldPolNodCd() {
		return this.oldPolNodCd;
	}

	/**
	 * Column Info
	 * @return maxSeq
	 */
	public String getMaxSeq() {
		return this.maxSeq;
	}
	
	/**
	 * Column Info
	 * @return codCnt
	 */
	public String getCodCnt() {
		return this.codCnt;
	}

	/**
	 * Column Info
	 * @param newPodNodCd
	 */
	public void setNewPodNodCd(String newPodNodCd) {
		this.newPodNodCd = newPodNodCd;
	}
	
	/**
	 * Column Info
	 * @param newPolNodCd
	 */
	public void setNewPolNodCd(String newPolNodCd) {
		this.newPolNodCd = newPolNodCd;
	}
	
	/**
	 * Column Info
	 * @param oldDeTermCd
	 */
	public void setOldDeTermCd(String oldDeTermCd) {
		this.oldDeTermCd = oldDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param newPstCd
	 */
	public void setNewPstCd(String newPstCd) {
		this.newPstCd = newPstCd;
	}
	
	/**
	 * Column Info
	 * @param newPorNodCd
	 */
	public void setNewPorNodCd(String newPorNodCd) {
		this.newPorNodCd = newPorNodCd;
	}
	
	/**
	 * Column Info
	 * @param oldPodNodCd
	 */
	public void setOldPodNodCd(String oldPodNodCd) {
		this.oldPodNodCd = oldPodNodCd;
	}
	
	/**
	 * Column Info
	 * @param bdrFlg
	 */
	public void setBdrFlg(String bdrFlg) {
		this.bdrFlg = bdrFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param newDelNodCd
	 */
	public void setNewDelNodCd(String newDelNodCd) {
		this.newDelNodCd = newDelNodCd;
	}
	
	/**
	 * Column Info
	 * @param oldPreNodCd
	 */
	public void setOldPreNodCd(String oldPreNodCd) {
		this.oldPreNodCd = oldPreNodCd;
	}
	
	/**
	 * Column Info
	 * @param approvalRso
	 */
	public void setApprovalRso(String approvalRso) {
		this.approvalRso = approvalRso;
	}
	
	/**
	 * Column Info
	 * @param oldPorNodCd
	 */
	public void setOldPorNodCd(String oldPorNodCd) {
		this.oldPorNodCd = oldPorNodCd;
	}
	
	/**
	 * Column Info
	 * @param newDelCd
	 */
	public void setNewDelCd(String newDelCd) {
		this.newDelCd = newDelCd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param pctlNo
	 */
	public void setPctlNo(String pctlNo) {
		this.pctlNo = pctlNo;
	}
	
	/**
	 * Column Info
	 * @param newPolCd
	 */
	public void setNewPolCd(String newPolCd) {
		this.newPolCd = newPolCd;
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
	 * @param newPreNodCd
	 */
	public void setNewPreNodCd(String newPreNodCd) {
		this.newPreNodCd = newPreNodCd;
	}
	
	/**
	 * Column Info
	 * @param oldPstNodCd
	 */
	public void setOldPstNodCd(String oldPstNodCd) {
		this.oldPstNodCd = oldPstNodCd;
	}
	
	/**
	 * Column Info
	 * @param oldDelCd
	 */
	public void setOldDelCd(String oldDelCd) {
		this.oldDelCd = oldDelCd;
	}
	
	/**
	 * Column Info
	 * @param rehandlingPort
	 */
	public void setRehandlingPort(String rehandlingPort) {
		this.rehandlingPort = rehandlingPort;
	}
	
	/**
	 * Column Info
	 * @param codReason
	 */
	public void setCodReason(String codReason) {
		this.codReason = codReason;
	}
	
	/**
	 * Column Info
	 * @param newPreCd
	 */
	public void setNewPreCd(String newPreCd) {
		this.newPreCd = newPreCd;
	}
	
	/**
	 * Column Info
	 * @param cannotConfirmFlg
	 */
	public void setCannotConfirmFlg(String cannotConfirmFlg) {
		this.cannotConfirmFlg = cannotConfirmFlg;
	}
	
	/**
	 * Column Info
	 * @param codMnlFlg
	 */
	public void setCodMnlFlg(String codMnlFlg) {
		this.codMnlFlg = codMnlFlg;
	}
	
	/**
	 * Column Info
	 * @param oldTvvd
	 */
	public void setOldTvvd(String oldTvvd) {
		this.oldTvvd = oldTvvd;
	}
	
	/**
	 * Column Info
	 * @param newDeTermCd
	 */
	public void setNewDeTermCd(String newDeTermCd) {
		this.newDeTermCd = newDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param newPorCd
	 */
	public void setNewPorCd(String newPorCd) {
		this.newPorCd = newPorCd;
	}
	
	/**
	 * Column Info
	 * @param newPstNodCd
	 */
	public void setNewPstNodCd(String newPstNodCd) {
		this.newPstNodCd = newPstNodCd;
	}
	
	/**
	 * Column Info
	 * @param codStatus
	 */
	public void setCodStatus(String codStatus) {
		this.codStatus = codStatus;
	}
	
	/**
	 * Column Info
	 * @param rejectReasonRemark
	 */
	public void setRejectReasonRemark(String rejectReasonRemark) {
		this.rejectReasonRemark = rejectReasonRemark;
	}
	
	/**
	 * Column Info
	 * @param oldPorCd
	 */
	public void setOldPorCd(String oldPorCd) {
		this.oldPorCd = oldPorCd;
	}
	
	/**
	 * Column Info
	 * @param oldPreCd
	 */
	public void setOldPreCd(String oldPreCd) {
		this.oldPreCd = oldPreCd;
	}
	
	/**
	 * Column Info
	 * @param oldPolCd
	 */
	public void setOldPolCd(String oldPolCd) {
		this.oldPolCd = oldPolCd;
	}
	
	/**
	 * Column Info
	 * @param oldPstCd
	 */
	public void setOldPstCd(String oldPstCd) {
		this.oldPstCd = oldPstCd;
	}
	
	/**
	 * Column Info
	 * @param arrpoval
	 */
	public void setArrpoval(String arrpoval) {
		this.arrpoval = arrpoval;
	}
	
	/**
	 * Column Info
	 * @param codRemark
	 */
	public void setCodRemark(String codRemark) {
		this.codRemark = codRemark;
	}
	
	/**
	 * Column Info
	 * @param blTpCd
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
	}
	
	/**
	 * Column Info
	 * @param rejectReasonCode
	 */
	public void setRejectReasonCode(String rejectReasonCode) {
		this.rejectReasonCode = rejectReasonCode;
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
	 * @param oldDelNodCd
	 */
	public void setOldDelNodCd(String oldDelNodCd) {
		this.oldDelNodCd = oldDelNodCd;
	}
	
	/**
	 * Column Info
	 * @param newTvvd
	 */
	public void setNewTvvd(String newTvvd) {
		this.newTvvd = newTvvd;
	}
	
	/**
	 * Column Info
	 * @param oldPodCd
	 */
	public void setOldPodCd(String oldPodCd) {
		this.oldPodCd = oldPodCd;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param newPodCd
	 */
	public void setNewPodCd(String newPodCd) {
		this.newPodCd = newPodCd;
	}
	
	/**
	 * Column Info
	 * @param oldPolNodCd
	 */
	public void setOldPolNodCd(String oldPolNodCd) {
		this.oldPolNodCd = oldPolNodCd;
	}

	/**
	 * Column Info
	 * @param maxSeq
	 */
	public void setMaxSeq(String maxSeq) {
		this.maxSeq = maxSeq;
	}
	
	/**
	 * Column Info
	 * @param codCnt
	 */
	public void setCodCnt(String codCnt) {
		this.codCnt = codCnt;
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
		setNewPodNodCd(JSPUtil.getParameter(request, prefix + "new_pod_nod_cd", ""));
		setNewPolNodCd(JSPUtil.getParameter(request, prefix + "new_pol_nod_cd", ""));
		setOldDeTermCd(JSPUtil.getParameter(request, prefix + "old_de_term_cd", ""));
		setNewPstCd(JSPUtil.getParameter(request, prefix + "new_pst_cd", ""));
		setNewPorNodCd(JSPUtil.getParameter(request, prefix + "new_por_nod_cd", ""));
		setOldPodNodCd(JSPUtil.getParameter(request, prefix + "old_pod_nod_cd", ""));
		setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setNewDelNodCd(JSPUtil.getParameter(request, prefix + "new_del_nod_cd", ""));
		setOldPreNodCd(JSPUtil.getParameter(request, prefix + "old_pre_nod_cd", ""));
		setApprovalRso(JSPUtil.getParameter(request, prefix + "approval_rso", ""));
		setOldPorNodCd(JSPUtil.getParameter(request, prefix + "old_por_nod_cd", ""));
		setNewDelCd(JSPUtil.getParameter(request, prefix + "new_del_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPctlNo(JSPUtil.getParameter(request, prefix + "pctl_no", ""));
		setNewPolCd(JSPUtil.getParameter(request, prefix + "new_pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setNewPreNodCd(JSPUtil.getParameter(request, prefix + "new_pre_nod_cd", ""));
		setOldPstNodCd(JSPUtil.getParameter(request, prefix + "old_pst_nod_cd", ""));
		setOldDelCd(JSPUtil.getParameter(request, prefix + "old_del_cd", ""));
		setRehandlingPort(JSPUtil.getParameter(request, prefix + "rehandling_port", ""));
		setCodReason(JSPUtil.getParameter(request, prefix + "cod_reason", ""));
		setNewPreCd(JSPUtil.getParameter(request, prefix + "new_pre_cd", ""));
		setCannotConfirmFlg(JSPUtil.getParameter(request, prefix + "cannot_confirm_flg", ""));
		setCodMnlFlg(JSPUtil.getParameter(request, prefix + "cod_mnl_flg", ""));
		setOldTvvd(JSPUtil.getParameter(request, prefix + "old_tvvd", ""));
		setNewDeTermCd(JSPUtil.getParameter(request, prefix + "new_de_term_cd", ""));
		setNewPorCd(JSPUtil.getParameter(request, prefix + "new_por_cd", ""));
		setNewPstNodCd(JSPUtil.getParameter(request, prefix + "new_pst_nod_cd", ""));
		setCodStatus(JSPUtil.getParameter(request, prefix + "cod_status", ""));
		setRejectReasonRemark(JSPUtil.getParameter(request, prefix + "reject_reason_remark", ""));
		setOldPorCd(JSPUtil.getParameter(request, prefix + "old_por_cd", ""));
		setOldPreCd(JSPUtil.getParameter(request, prefix + "old_pre_cd", ""));
		setOldPolCd(JSPUtil.getParameter(request, prefix + "old_pol_cd", ""));
		setOldPstCd(JSPUtil.getParameter(request, prefix + "old_pst_cd", ""));
		setArrpoval(JSPUtil.getParameter(request, prefix + "arrpoval", ""));
		setCodRemark(JSPUtil.getParameter(request, prefix + "cod_remark", ""));
		setBlTpCd(JSPUtil.getParameter(request, prefix + "bl_tp_cd", ""));
		setRejectReasonCode(JSPUtil.getParameter(request, prefix + "reject_reason_code", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setOldDelNodCd(JSPUtil.getParameter(request, prefix + "old_del_nod_cd", ""));
		setNewTvvd(JSPUtil.getParameter(request, prefix + "new_tvvd", ""));
		setOldPodCd(JSPUtil.getParameter(request, prefix + "old_pod_cd", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setNewPodCd(JSPUtil.getParameter(request, prefix + "new_pod_cd", ""));
		setOldPolNodCd(JSPUtil.getParameter(request, prefix + "old_pol_nod_cd", ""));
		setMaxSeq(JSPUtil.getParameter(request, prefix + "max_seq", ""));
		setCodCnt(JSPUtil.getParameter(request, prefix + "cod_cnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CodEtcVO[]
	 */
	public CodEtcVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CodEtcVO[]
	 */
	public CodEtcVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CodEtcVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] newPodNodCd = (JSPUtil.getParameter(request, prefix	+ "new_pod_nod_cd", length));
			String[] newPolNodCd = (JSPUtil.getParameter(request, prefix	+ "new_pol_nod_cd", length));
			String[] oldDeTermCd = (JSPUtil.getParameter(request, prefix	+ "old_de_term_cd", length));
			String[] newPstCd = (JSPUtil.getParameter(request, prefix	+ "new_pst_cd", length));
			String[] newPorNodCd = (JSPUtil.getParameter(request, prefix	+ "new_por_nod_cd", length));
			String[] oldPodNodCd = (JSPUtil.getParameter(request, prefix	+ "old_pod_nod_cd", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] newDelNodCd = (JSPUtil.getParameter(request, prefix	+ "new_del_nod_cd", length));
			String[] oldPreNodCd = (JSPUtil.getParameter(request, prefix	+ "old_pre_nod_cd", length));
			String[] approvalRso = (JSPUtil.getParameter(request, prefix	+ "approval_rso", length));
			String[] oldPorNodCd = (JSPUtil.getParameter(request, prefix	+ "old_por_nod_cd", length));
			String[] newDelCd = (JSPUtil.getParameter(request, prefix	+ "new_del_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pctlNo = (JSPUtil.getParameter(request, prefix	+ "pctl_no", length));
			String[] newPolCd = (JSPUtil.getParameter(request, prefix	+ "new_pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] newPreNodCd = (JSPUtil.getParameter(request, prefix	+ "new_pre_nod_cd", length));
			String[] oldPstNodCd = (JSPUtil.getParameter(request, prefix	+ "old_pst_nod_cd", length));
			String[] oldDelCd = (JSPUtil.getParameter(request, prefix	+ "old_del_cd", length));
			String[] rehandlingPort = (JSPUtil.getParameter(request, prefix	+ "rehandling_port", length));
			String[] codReason = (JSPUtil.getParameter(request, prefix	+ "cod_reason", length));
			String[] newPreCd = (JSPUtil.getParameter(request, prefix	+ "new_pre_cd", length));
			String[] cannotConfirmFlg = (JSPUtil.getParameter(request, prefix	+ "cannot_confirm_flg", length));
			String[] codMnlFlg = (JSPUtil.getParameter(request, prefix	+ "cod_mnl_flg", length));
			String[] oldTvvd = (JSPUtil.getParameter(request, prefix	+ "old_tvvd", length));
			String[] newDeTermCd = (JSPUtil.getParameter(request, prefix	+ "new_de_term_cd", length));
			String[] newPorCd = (JSPUtil.getParameter(request, prefix	+ "new_por_cd", length));
			String[] newPstNodCd = (JSPUtil.getParameter(request, prefix	+ "new_pst_nod_cd", length));
			String[] codStatus = (JSPUtil.getParameter(request, prefix	+ "cod_status", length));
			String[] rejectReasonRemark = (JSPUtil.getParameter(request, prefix	+ "reject_reason_remark", length));
			String[] oldPorCd = (JSPUtil.getParameter(request, prefix	+ "old_por_cd", length));
			String[] oldPreCd = (JSPUtil.getParameter(request, prefix	+ "old_pre_cd", length));
			String[] oldPolCd = (JSPUtil.getParameter(request, prefix	+ "old_pol_cd", length));
			String[] oldPstCd = (JSPUtil.getParameter(request, prefix	+ "old_pst_cd", length));
			String[] arrpoval = (JSPUtil.getParameter(request, prefix	+ "arrpoval", length));
			String[] codRemark = (JSPUtil.getParameter(request, prefix	+ "cod_remark", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] rejectReasonCode = (JSPUtil.getParameter(request, prefix	+ "reject_reason_code", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] oldDelNodCd = (JSPUtil.getParameter(request, prefix	+ "old_del_nod_cd", length));
			String[] newTvvd = (JSPUtil.getParameter(request, prefix	+ "new_tvvd", length));
			String[] oldPodCd = (JSPUtil.getParameter(request, prefix	+ "old_pod_cd", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] newPodCd = (JSPUtil.getParameter(request, prefix	+ "new_pod_cd", length));
			String[] oldPolNodCd = (JSPUtil.getParameter(request, prefix	+ "old_pol_nod_cd", length));
			String[] maxSeq = (JSPUtil.getParameter(request, prefix	+ "max_seq", length));
			String[] codCnt = (JSPUtil.getParameter(request, prefix + "cod_cnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CodEtcVO();
				if (newPodNodCd[i] != null)
					model.setNewPodNodCd(newPodNodCd[i]);
				if (newPolNodCd[i] != null)
					model.setNewPolNodCd(newPolNodCd[i]);
				if (oldDeTermCd[i] != null)
					model.setOldDeTermCd(oldDeTermCd[i]);
				if (newPstCd[i] != null)
					model.setNewPstCd(newPstCd[i]);
				if (newPorNodCd[i] != null)
					model.setNewPorNodCd(newPorNodCd[i]);
				if (oldPodNodCd[i] != null)
					model.setOldPodNodCd(oldPodNodCd[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (newDelNodCd[i] != null)
					model.setNewDelNodCd(newDelNodCd[i]);
				if (oldPreNodCd[i] != null)
					model.setOldPreNodCd(oldPreNodCd[i]);
				if (approvalRso[i] != null)
					model.setApprovalRso(approvalRso[i]);
				if (oldPorNodCd[i] != null)
					model.setOldPorNodCd(oldPorNodCd[i]);
				if (newDelCd[i] != null)
					model.setNewDelCd(newDelCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pctlNo[i] != null)
					model.setPctlNo(pctlNo[i]);
				if (newPolCd[i] != null)
					model.setNewPolCd(newPolCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (newPreNodCd[i] != null)
					model.setNewPreNodCd(newPreNodCd[i]);
				if (oldPstNodCd[i] != null)
					model.setOldPstNodCd(oldPstNodCd[i]);
				if (oldDelCd[i] != null)
					model.setOldDelCd(oldDelCd[i]);
				if (rehandlingPort[i] != null)
					model.setRehandlingPort(rehandlingPort[i]);
				if (codReason[i] != null)
					model.setCodReason(codReason[i]);
				if (newPreCd[i] != null)
					model.setNewPreCd(newPreCd[i]);
				if (cannotConfirmFlg[i] != null)
					model.setCannotConfirmFlg(cannotConfirmFlg[i]);
				if (codMnlFlg[i] != null)
					model.setCodMnlFlg(codMnlFlg[i]);
				if (oldTvvd[i] != null)
					model.setOldTvvd(oldTvvd[i]);
				if (newDeTermCd[i] != null)
					model.setNewDeTermCd(newDeTermCd[i]);
				if (newPorCd[i] != null)
					model.setNewPorCd(newPorCd[i]);
				if (newPstNodCd[i] != null)
					model.setNewPstNodCd(newPstNodCd[i]);
				if (codStatus[i] != null)
					model.setCodStatus(codStatus[i]);
				if (rejectReasonRemark[i] != null)
					model.setRejectReasonRemark(rejectReasonRemark[i]);
				if (oldPorCd[i] != null)
					model.setOldPorCd(oldPorCd[i]);
				if (oldPreCd[i] != null)
					model.setOldPreCd(oldPreCd[i]);
				if (oldPolCd[i] != null)
					model.setOldPolCd(oldPolCd[i]);
				if (oldPstCd[i] != null)
					model.setOldPstCd(oldPstCd[i]);
				if (arrpoval[i] != null)
					model.setArrpoval(arrpoval[i]);
				if (codRemark[i] != null)
					model.setCodRemark(codRemark[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (rejectReasonCode[i] != null)
					model.setRejectReasonCode(rejectReasonCode[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (oldDelNodCd[i] != null)
					model.setOldDelNodCd(oldDelNodCd[i]);
				if (newTvvd[i] != null)
					model.setNewTvvd(newTvvd[i]);
				if (oldPodCd[i] != null)
					model.setOldPodCd(oldPodCd[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (newPodCd[i] != null)
					model.setNewPodCd(newPodCd[i]);
				if (oldPolNodCd[i] != null)
					model.setOldPolNodCd(oldPolNodCd[i]);
				if (maxSeq[i] != null)
					model.setMaxSeq(maxSeq[i]);
				if (codCnt[i] != null)
					model.setCodCnt(codCnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCodEtcVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CodEtcVO[]
	 */
	public CodEtcVO[] getCodEtcVOs(){
		CodEtcVO[] vos = (CodEtcVO[])models.toArray(new CodEtcVO[models.size()]);
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
		this.newPodNodCd = this.newPodNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPolNodCd = this.newPolNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldDeTermCd = this.oldDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPstCd = this.newPstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPorNodCd = this.newPorNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPodNodCd = this.oldPodNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newDelNodCd = this.newDelNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPreNodCd = this.oldPreNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.approvalRso = this.approvalRso .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPorNodCd = this.oldPorNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newDelCd = this.newDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlNo = this.pctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPolCd = this.newPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPreNodCd = this.newPreNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPstNodCd = this.oldPstNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldDelCd = this.oldDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rehandlingPort = this.rehandlingPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codReason = this.codReason .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPreCd = this.newPreCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cannotConfirmFlg = this.cannotConfirmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codMnlFlg = this.codMnlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldTvvd = this.oldTvvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newDeTermCd = this.newDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPorCd = this.newPorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPstNodCd = this.newPstNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codStatus = this.codStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rejectReasonRemark = this.rejectReasonRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPorCd = this.oldPorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPreCd = this.oldPreCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPolCd = this.oldPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPstCd = this.oldPstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrpoval = this.arrpoval .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codRemark = this.codRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rejectReasonCode = this.rejectReasonCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldDelNodCd = this.oldDelNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newTvvd = this.newTvvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPodCd = this.oldPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPodCd = this.newPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPolNodCd = this.oldPolNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxSeq = this.maxSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codCnt = this.codCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
