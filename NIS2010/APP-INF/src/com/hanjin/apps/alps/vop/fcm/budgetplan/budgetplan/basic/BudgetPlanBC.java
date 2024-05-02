/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TrendLineBC.java
*@FileTitle : TrendLine
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.15
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.11.15 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.budgetplan.budgetplan.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.fcm.budgetplan.budgetplan.vo.FcmBudTgtVvdCsmVO;
import com.hanjin.apps.alps.vop.fcm.budgetplan.budgetplan.vo.FcmBudTgtVvdInqVO;
import com.hanjin.apps.alps.vop.fcm.budgetplan.budgetplan.vo.FcmBudTgtVvdVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-BudgetPlan Business Logic Command Interface<br>
 * - ALPS-BudgetPlan에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Ryu Hyuk
 * @see BudgetPlanEventResponse 참조
 * @since J2EE 1.6
 */
public interface BudgetPlanBC {
	
	/**
	 * Budget plan에 대한 주어진 구간의 스케줄 정보를 조회한다.<br>
	 * 
	 * @param FcmBudTgtVvdInqVO fcmBudTgtVvdInqVO
	 * @return List<FcmBudTgtVvdVO>
	 * @exception EventException
	 */
	public List<FcmBudTgtVvdVO> searchBudTgtVvdList(FcmBudTgtVvdInqVO fcmBudTgtVvdInqVO) throws EventException;
	
	
	/**
	 * Budget plan에 대한 주어진 구간의 스케줄 정보를 조회한다.<br>
	 * 
	 * @param FcmBudTgtVvdInqVO fcmBudTgtVvdInqVO
	 * @return List<FcmBudTgtVvdCsmVO>
	 * @exception EventException
	 */
	public List<FcmBudTgtVvdCsmVO> searchBudTgtVvdCsmList(FcmBudTgtVvdInqVO fcmBudTgtVvdInqVO) throws EventException;
	

}
