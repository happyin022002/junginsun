/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ApprovalStepSendBC.java
*@FileTitle : TRS의 Actual 비용 산출
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2013-04-22
=========================================================*/
package com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage.actualcostmanage.basic;


import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

import com.hanjin.syscommon.common.table.TrsActCostHdrVO;

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
	static final String ACT_COST_TRF_TP_SHUTTLE		= "S";
	static final String ACT_COST_TRF_TP_FEEDERAGE	= "F";
	
	/* ACT TP */
	static final String ACT_COST_ACT_TP_BATCH  	= "B";
	static final String ACT_COST_ACT_TP_ONLINE 	= "O";
	
	/* CNTR SZ */
	static final String ACT_COST_CNTR_TP_20FT 	= "2";
	static final String ACT_COST_CNTR_TP_40FT 	= "4";
	
	/* CALC UNIT TP */
	static final String ACT_COST_HDR      		= "ACT_COST_HDR";
	static final String ACT_COST_CALC_RESULT	= "ACT_COST_CALC_RESULT";

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
	public void logActCostCalcErrMsg(TrsActCostHdrVO actCostHdrVO) throws EventException;
	
}