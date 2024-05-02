/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : SpclPlanningBC.java
*@FileTitle      : SpclPlanning
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.07.08
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.07.08 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.specialkpi.spclplanning.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SqmSpclLaneOfcCostVO;
import com.hanjin.syscommon.common.table.SqmSpclLodRevVO;

/**
 * ALPS-Planning Business Logic Command Interface<br>
 * - ALPS-SpclPlanning 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 이혜민
 * @see
 * @since J2EE 1.6
 */
public interface SpclPlanningBC {
	/**
	 * ESM_SQM_0501 : [SEARCH]<br>
	 * [KPI Input by Head Office]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SqmSpclLodRevVO>
	 * @exception EventException
	 */
	public List<SqmSpclLodRevVO> searchKpiInputbyHeadOffice(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_SQM_0501 : [SEARCH]<br>
	 * [KPI Input by Head Office]을 [Data Count] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchKpiInputbyHeadOfficeCnt(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_SQM_0501 : [MULTI]<br>
	 * [KPI Input by Head Office]을 [저장] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param SqmSpclLodRevVO[] sqmSpclLodRevVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageKpiInputbyHeadOffice(ConditionVO conditionVO, SqmSpclLodRevVO[] sqmSpclLodRevVOS, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_SQM_0501 : [MULTI01]<br>
	 * [KPI Input by Head Office]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String createKpiInputbyHeadOffice(ConditionVO conditionVO, String usrId) throws EventException;
	/**
	 * ESM_SQM_0502 : [SEARCH]<br>
	 * [Basic CMCB]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SqmSpclLaneOfcCostVO>
	 * @exception EventException
	 */
	public List<SqmSpclLaneOfcCostVO> searchBasicCmcb(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_SQM_0502 : [SEARCH]<br>
	 * [Basic CMCB]을 [Data Count] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchBasicCmcbCnt(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_SQM_0502 : [MULTI]<br>
	 * [Basic CMCB]을 [저장] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param SqmSpclLaneOfcCostVO[] sqmSpclLaneOfcCostVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageBasicCmcb(ConditionVO conditionVO, SqmSpclLaneOfcCostVO[] sqmSpclLaneOfcCostVOS, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_SQM_0502 : [MULTI01]<br>
	 * [Basic CMCB]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String createBasicCmcb(ConditionVO conditionVO, String usrId) throws EventException;
	/**
	 * ESM_SQM_0503 : [MULTI]<br>
	 * [Basic CMCB New Lane]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String createBasicCmcbNewLane(ConditionVO conditionVO, String usrId) throws EventException;

}