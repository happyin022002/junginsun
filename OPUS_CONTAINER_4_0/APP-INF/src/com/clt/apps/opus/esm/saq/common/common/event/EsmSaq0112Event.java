/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSaq0112Event.java
*@FileTitle      : remark
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.saq.common.common.event;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.SaqMonQtaLodTgtRmkVO;
import com.clt.syscommon.common.table.SaqMonQtaRhqRmkVO;
import com.clt.syscommon.common.table.SaqMonQtaTrdRmkVO;

/**
 * ESM_SAQ_0112 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAQ_0112HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
* @author 최민철
 * @see ESM_SAQ_0112HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmSaq0112Event extends EventSupport {
	
	
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SaqMonQtaTrdRmkVO saqMonQtaTrdRmkVO = null;
	private SaqMonQtaRhqRmkVO saqMonQtaRhqRmkVO = null;
	private SaqMonQtaLodTgtRmkVO saqMonQtaLodTgtRmkVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private QuotaConditionVO quotaConditionVO = null;

	public EsmSaq0112Event(){}
	
	public void setSaqMonQtaTrdRmkVO(SaqMonQtaTrdRmkVO saqMonQtaTrdRmkVO){
		this. saqMonQtaTrdRmkVO = saqMonQtaTrdRmkVO;
	}
	public void setSaqMonQtaRhqRmkVO(SaqMonQtaRhqRmkVO saqMonQtaRhqRmkVO){
		this. saqMonQtaRhqRmkVO = saqMonQtaRhqRmkVO;
	}
	public void setSaqMonQtaLodTgtRmkVO(SaqMonQtaLodTgtRmkVO saqMonQtaLodTgtRmkVO){
		this. saqMonQtaLodTgtRmkVO = saqMonQtaLodTgtRmkVO;
	}

	public void setQuotaConditionVO(QuotaConditionVO quotaConditionVO){
		this. quotaConditionVO = quotaConditionVO;
	}

	public SaqMonQtaTrdRmkVO getSaqMonQtaTrdRmkVO(){
		return saqMonQtaTrdRmkVO;
	}
	public SaqMonQtaRhqRmkVO getSaqMonQtaRhqRmkVO(){
		return saqMonQtaRhqRmkVO;
	}
	public SaqMonQtaLodTgtRmkVO getSaqMonQtaLodTgtRmkVO(){
		return saqMonQtaLodTgtRmkVO;
	}

	public QuotaConditionVO getQuotaConditionVO(){
		return quotaConditionVO;
	}

	/*SaqMonQtaTrdRmkVO     saq_mon_qta_trd_rmk     = null;
	SaqMonQtaRhqRmkVO     saq_mon_qta_rhq_rmk     = null;
	SaqMonQtaLodTgtRmkVO  saq_mon_qta_lod_tgt_rmk = null;	
	
	String gline_ver_no = null;
	String mqta_step_cd = null;
	String bse_yr       = null;
	String bse_qtr_cd   = null;
	String trd_cd       = null;
	String dir_cd       = null;
	String mqta_ver_no  = null;
	String rlane_cd     = null;
	String sprt_grp_cd  = null;
	String bsa_grp_cd   = null;
	String bse_mon      = null;

	String rhq_cd       = null;
	String rgn_ofc_cd   = null;
	String pol_cd       = null;
	String pod_cd       = null;	
	
	String subj_ctnt    = null;
	String cre_ofc_cd   = null;
	String cmt_ctnt     = null;
	String saq_sts_cd   = null;
	
	String chkCommand   = null;
	
	*//**                               
	 * chkCommand 멤버변수의 getter method
	 *                                
	 * @return String                 
	 *//* 
	public String getChkCommand() {
		return chkCommand;
	}

	*//**
	 * chkCommand 멤버변수의 setter method
	 * 
	 * @param chkCommand 
	 *//*
	public void setChkCommand(String chkCommand) {
		this.chkCommand = chkCommand;
	}

	*//**                               
	 * bsa_grp_cd 멤버변수의 getter method
	 *                                
	 * @return String                 
	 *//*                               
	public String getBsa_grp_cd() {
		return bsa_grp_cd;
	}

	*//**
	 * bsa_grp_cd 멤버변수의 setter method
	 * 
	 * @param bsa_grp_cd 
	 *//*
	public void setBsa_grp_cd(String bsa_grp_cd) {
		this.bsa_grp_cd = bsa_grp_cd;
	}

	*//**                               
	 * bse_mon 멤버변수의 getter method
	 *                                
	 * @return String                 
	 *//*                               
	public String getBse_mon() {
		return bse_mon;
	}

	*//**
	 * bse_mon 멤버변수의 setter method
	 * 
	 * @param bse_mon 
	 *//*
	public void setBse_mon(String bse_mon) {
		this.bse_mon = bse_mon;
	}

	*//**                               
	 * bse_yr 멤버변수의 getter method
	 *                                
	 * @return String                 
	 *//*                               
	public String getBse_yr() {
		return bse_yr;
	}

	*//**
	 * bse_yr 멤버변수의 setter method
	 * 
	 * @param bse_yr 
	 *//*
	public void setBse_yr(String bse_yr) {
		this.bse_yr = bse_yr;
	}

	*//**                               
	 * cmt_ctnt 멤버변수의 getter method
	 *                                
	 * @return String                 
	 *//*                               
	public String getCmt_ctnt() {
		return cmt_ctnt;
	}

	*//**
	 * cmt_ctnt 멤버변수의 setter method
	 * 
	 * @param cmt_ctnt 
	 *//*
	public void setCmt_ctnt(String cmt_ctnt) {
		this.cmt_ctnt = cmt_ctnt;
	}

	*//**                               
	 * cre_ofc_cd 멤버변수의 getter method
	 *                                
	 * @return String                 
	 *//*                               
	public String getCre_ofc_cd() {
		return cre_ofc_cd;
	}

	*//**
	 * cre_ofc_cd 멤버변수의 setter method
	 * 
	 * @param cre_ofc_cd 
	 *//*
	public void setCre_ofc_cd(String cre_ofc_cd) {
		this.cre_ofc_cd = cre_ofc_cd;
	}

	*//**                               
	 * rhq_cd 멤버변수의 getter method
	 *                                
	 * @return String                 
	 *//*                               
	public String getRhq_cd() {
		return rhq_cd;
	}

	*//**
	 * ctrt_rhq_cd 멤버변수의 setter method
	 * 
	 * @param rhq_cd 
	 *//*
	public void setRhq_cd(String rhq_cd) {
		this.rhq_cd = rhq_cd;
	}

	*//**                               
	 * dir_cd 멤버변수의 getter method
	 *                                
	 * @return String                 
	 *//*                               
	public String getDir_cd() {
		return dir_cd;
	}

	*//**
	 * dir_cd 멤버변수의 setter method
	 * 
	 * @param dir_cd 
	 *//*
	public void setDir_cd(String dir_cd) {
		this.dir_cd = dir_cd;
	}

	*//**                               
	 * gline_ver_no 멤버변수의 getter method
	 *                                
	 * @return String                 
	 *//*                               
	public String getGline_ver_no() {
		return gline_ver_no;
	}

	*//**
	 * gline_ver_no 멤버변수의 setter method
	 * 
	 * @param gline_ver_no 
	 *//*
	public void setGline_ver_no(String gline_ver_no) {
		this.gline_ver_no = gline_ver_no;
	}

	*//**                               
	 * mqta_step_cd 멤버변수의 getter method
	 *                                
	 * @return String                 
	 *//*                               
	public String getMqta_step_cd() {
		return mqta_step_cd;
	}

	*//**
	 * mqta_step_cd 멤버변수의 setter method
	 * 
	 * @param mqta_step_cd 
	 *//*
	public void setMqta_step_cd(String mqta_step_cd) {
		this.mqta_step_cd = mqta_step_cd;
	}

	*//**                               
	 * mqta_ver_no 멤버변수의 getter method
	 *                                
	 * @return String                 
	 *//*                               
	public String getMqta_ver_no() {
		return mqta_ver_no;
	}

	*//**
	 * mqta_ver_no 멤버변수의 setter method
	 * 
	 * @param mqta_ver_no 
	 *//*
	public void setMqta_ver_no(String mqta_ver_no) {
		this.mqta_ver_no = mqta_ver_no;
	}

	*//**                               
	 * pod_cd 멤버변수의 getter method
	 *                                
	 * @return String                 
	 *//*                               
	public String getPod_cd() {
		return pod_cd;
	}

	*//**
	 * pod_cd 멤버변수의 setter method
	 * 
	 * @param pod_cd 
	 *//*
	public void setPod_cd(String pod_cd) {
		this.pod_cd = pod_cd;
	}

	*//**                               
	 * pol_cd 멤버변수의 getter method
	 *                                
	 * @return String                 
	 *//*                               
	public String getPol_cd() {
		return pol_cd;
	}

	*//**
	 * pol_cd 멤버변수의 setter method
	 * 
	 * @param pol_cd 
	 *//*
	public void setPol_cd(String pol_cd) {
		this.pol_cd = pol_cd;
	}

	*//**                               
	 * bse_qtr_cd 멤버변수의 getter method
	 *                                
	 * @return String                 
	 *//*                               
	public String getBse_qtr_cd() {
		return bse_qtr_cd;
	}

	*//**
	 * bse_qtr_cd 멤버변수의 setter method
	 * 
	 * @param bse_qtr_cd 
	 *//*
	public void setBse_qtr_cd(String bse_qtr_cd) {
		this.bse_qtr_cd = bse_qtr_cd;
	}

	*//**                               
	 * rlane_cd 멤버변수의 getter method
	 *                                
	 * @return String                 
	 *//*                               
	public String getRlane_cd() {
		return rlane_cd;
	}

	*//**
	 * rlane_cd 멤버변수의 setter method
	 * 
	 * @param rlane_cd 
	 *//*
	public void setRlane_cd(String rlane_cd) {
		this.rlane_cd = rlane_cd;
	}

	*//**                               
	 * saq_sts_cd 멤버변수의 getter method
	 *                                
	 * @return String                 
	 *//*                               
	public String getSaq_sts_cd() {
		return saq_sts_cd;
	}

	*//**
	 * saq_sts_cd 멤버변수의 setter method
	 * 
	 * @param saq_sts_cd 
	 *//*
	public void setSaq_sts_cd(String saq_sts_cd) {
		this.saq_sts_cd = saq_sts_cd;
	}

	*//**                               
	 * sprt_grp_cd 멤버변수의 getter method
	 *                                
	 * @return String                 
	 *//*                               
	public String getSprt_grp_cd() {
		return sprt_grp_cd;
	}

	*//**
	 * sprt_grp_cd 멤버변수의 setter method
	 * 
	 * @param sprt_grp_cd 
	 *//*
	public void setSprt_grp_cd(String sprt_grp_cd) {
		this.sprt_grp_cd = sprt_grp_cd;
	}

	*//**                               
	 * subj_ctnt 멤버변수의 getter method
	 *                                
	 * @return String                 
	 *//*                               
	public String getSubj_ctnt() {
		return subj_ctnt;
	}

	*//**
	 * subj_ctnt 멤버변수의 setter method
	 * 
	 * @param subj_ctnt 
	 *//*
	public void setSubj_ctnt(String subj_ctnt) {
		this.subj_ctnt = subj_ctnt;
	}

	*//**                               
	 * trd_cd 멤버변수의 getter method
	 *                                
	 * @return String                 
	 *//*                               
	public String getTrd_cd() {
		return trd_cd;
	}

	*//**
	 * trd_cd 멤버변수의 setter method
	 * 
	 * @param trd_cd 
	 *//*
	public void setTrd_cd(String trd_cd) {
		this.trd_cd = trd_cd;
	}

	*//**                               
	 * rgn_ofc_cd 멤버변수의 getter method
	 *                                
	 * @return String                 
	 *//*                               
	public String getRgn_ofc_cd() {
		return rgn_ofc_cd;
	}

	*//**
	 * rgn_ofc_cd 멤버변수의 setter method
	 * 
	 * @param rgn_ofc_cd 
	 *//*
	public void setRgn_ofc_cd(String rgn_ofc_cd) {
		this.rgn_ofc_cd = rgn_ofc_cd;
	}


	*//**
	 * saq_mon_qta_trd_rmk 멤버변수의 getter method
	 * 
	 * @return SAQ_MON_QTA_TRD_RMK 
	 *//*
	public SaqMonQtaTrdRmkVO getSaq_mon_qta_trd_rmk() {
		return saq_mon_qta_trd_rmk;
	}

	*//**
	 * saq_mon_qta_rhq_rmk 멤버변수의 setter method
	 * 
	 * @param saq_mon_qta_trd_rmk 
	 *//*
	public void setSaq_mon_qta_trd_rmk(SaqMonQtaTrdRmkVO saq_mon_qta_trd_rmk) {
		this.saq_mon_qta_trd_rmk = saq_mon_qta_trd_rmk;
	}

	*//**
	 * saq_mon_qta_rhq_rmk 멤버변수의 getter method
	 * 
	 * @return SAQ_MON_QTA_RHQ_RMK 
	 *//*
	public SaqMonQtaRhqRmkVO getSaq_mon_qta_rhq_rmk() {
		return saq_mon_qta_rhq_rmk;
	}
	
	*//**
	 * saq_mon_qta_rhq_rmk 멤버변수의 setter method
	 * 
	 * @param saq_mon_qta_rhq_rmk 
	 *//*
	public void setSaq_mon_qta_rhq_rmk(SaqMonQtaRhqRmkVO saq_mon_qta_rhq_rmk) {
		this.saq_mon_qta_rhq_rmk = saq_mon_qta_rhq_rmk;
	}		

	*//**
	 * saq_mon_qta_lod_tgt_rmk 멤버변수의 getter method
	 * 
	 * @return SAQ_MON_QTA_LOD_TGT_RMK 
	 *//*
	public SaqMonQtaLodTgtRmkVO getSaq_mon_qta_lod_tgt_rmk() {
		return saq_mon_qta_lod_tgt_rmk;
	}
	
	*//**
	 * saq_mon_qta_lod_tgt_rmk 멤버변수의 setter method
	 * 
	 * @param saq_mon_qta_lod_tgt_rmk 
	 *//*
	public void setSaq_mon_qta_lod_tgt_rmk(SaqMonQtaLodTgtRmkVO saq_mon_qta_lod_tgt_rmk) {
		this.saq_mon_qta_lod_tgt_rmk = saq_mon_qta_lod_tgt_rmk;
	}	

	*//**
	 * event 명을 반환한다.
	 * 
	 * @return String 
	 *//*
	public String getEventName() {
		return "EsmSaq0112Event";
	}

	*//**
	 * event 명을 반환한다.
	 * 
	 * @return String 
	 *//*
	public String toString() {
		return "EsmSaq0112Event";
	}*/


}