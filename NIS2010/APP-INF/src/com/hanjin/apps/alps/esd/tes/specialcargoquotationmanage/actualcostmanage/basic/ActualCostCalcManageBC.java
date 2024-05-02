/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ApprovalStepSendBC.java
*@FileTitle : TES의 Actual 비용 산출
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2013-03-21
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.actualcostmanage.basic;


import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

import com.hanjin.syscommon.common.table.TesActCostHdrVO;

/**
 * ALPS-ESD Business Logic Command Interface<br>
 * - ALPS-ESD에 대한 비지니스 로직에 대한 인터페이스<br> 
 *
 * @author 
 * @see ActualCostCalcManageBCImpl 참조
 * @since J2EE 1.4
 */
public interface ActualCostCalcManageBC  {
	
	/* TRF TP */
	static final String ACT_COST_TRF_TP_BASIC  	= "B";
	static final String ACT_COST_TRF_TP_TS  	= "T";
	static final String ACT_COST_TRF_TP_ADDON  	= "A";
	
	/* ACT TP */
	static final String ACT_COST_ACT_TP_BATCH  	= "B";
	static final String ACT_COST_ACT_TP_ONLINE 	= "O";
	
	/* CNTR SZ */
	static final String ACT_COST_CNTR_TP_20FT 	= "2";
	static final String ACT_COST_CNTR_TP_40FT 	= "4";
	
	/* CALC UNIT TP */
	static final String ACT_COST_HDR      		= "ACT_COST_HDR";
	static final String ACT_COST_CALC_RESULT	= "ACT_COST_CALC_RESULT";

	/* AWK COMM ERR TP */
	static final String AWK_CGO_ERR_TP_BATCH	= "AWK_CGO_ERR_TP_BATCH";
	static final String AWK_CGO_ERR_TP_CALC		= "AWK_CGO_ERR_TP_CALC";
	static final String AWK_CGO_ERR_TP_COND		= "AWK_CGO_ERR_TP_COND";
	static final String AWK_CGO_ERR_TP_ETC		= "AWK_CGO_ERR_TP_ETC";

	/* TML_AWK_UC_CALC_TP_CD  */
	static final String AWK_UC_CALC_TP_CD_AUTO			= "A";
	static final String AWK_UC_CALC_TP_CD_CALC			= "C";
	static final String AWK_UC_CALC_TP_CD_FORMULA		= "F";
	static final String AWK_UC_CALC_TP_CD_MANUAL		= "M";
	static final String AWK_UC_CALC_TP_CD_SUM			= "S";
	static final String AWK_UC_CALC_TP_CD_TTLCOSTMANUAL	= "T";
	
	/**
	 * Actual Cost Calc 초기화
	 * @param eventResponse
	 * @throws EventException
	 */
	public void initCalcActualCOST(EventResponse eventResponse) throws EventException;
	
	/**
	 * Actual Cost 산출
	 * @param eventResponse
	 * @throws EventException
	 */
	public void calcActualCOST(EventResponse eventResponse) throws EventException;
	
	/**
	 * Actual Cost 저장
	 * @param eventResponse
	 * @throws EventException
	 */
	public void saveCalcActualCOST(EventResponse eventResponse) throws EventException;
	
	/**
	 * Actual Cost 상태 처리 완료
	 * @param eventResponse
	 * @throws EventException
	 */
	public void completeCalcActualCOST(EventResponse eventResponse) throws EventException;
	
	/**
	 * Actual Cost Calc Error 처리
	 * @param actCostHdrVO
	 * @throws EventException
	 */
	public void logActCostCalcErrMsg(TesActCostHdrVO actCostHdrVO) throws EventException;

	/**
	 * [BASIC] USD환율 변경으로 인한 AMT 차이를 감지하여 UPDATE 대상 조회
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageAwkCgoBasicTrfToUpdateUSDAmt() throws EventException;
	
	/**
	 * [T/S] USD환율 변경으로 인한 AMT 차이를 감지하여 UPDATE 대상 조회
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageAwkCgoTsTrfToUpdateUSDAmt() throws EventException;
	
	/**
	 * [ADD-ON] USD환율 변경으로 인한 AMT 차이를 감지하여 UPDATE 대상 조회
	 * @return
	 * @throws EventException
	 */
	public EventResponse manageAwkCgoAddOnTrfToUpdateUSDAmt() throws EventException;
	
}