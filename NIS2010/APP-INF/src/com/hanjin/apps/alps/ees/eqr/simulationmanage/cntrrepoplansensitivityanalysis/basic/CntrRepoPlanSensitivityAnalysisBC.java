/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanSensitivityAnalysisBC.java
*@FileTitle : 민감도 조회
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.18 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.basic;

import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.vo.EesEqr0065ConditionVO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.vo.EesEqr0065MultiVO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.vo.EesEqr0088ConditionVO;

/**
 * ALPS-CntrRepoPlanSensitivityAnalysis Business Logic Command Interface<br>
 * - ALPS-CntrRepoPlanSensitivityAnalysis에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Chae Change Ho
 * @see EventResponse 참조
 * @since J2EE 1.6
 */

public interface CntrRepoPlanSensitivityAnalysisBC {

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param condtionVO	EesEqr0065ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchPlanSensitivity(EesEqr0065ConditionVO condtionVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param multiVO EesEqr0065MultiVO[]
	 * @param condtionVO	EesEqr0065ConditionVO
	 * @param old_scnr_id String
	 * @exception EventException
	 */
	public void modifyPlanSensitivity(EesEqr0065MultiVO[] multiVO ,EesEqr0065ConditionVO condtionVO ,String old_scnr_id) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param condtionVO	EesEqr0065ConditionVO
	 * @exception EventException
	 */
	public void send0065ReRunSteve(EesEqr0065ConditionVO condtionVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param condtionVO	EesEqr0088ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchPlanSensitivityCompare(EesEqr0088ConditionVO condtionVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param condtionVO	EesEqr0088ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchUnitCostSensitivityCompare(EesEqr0088ConditionVO condtionVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param condtionVO	EesEqr0088ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchRepoPlanType(EesEqr0088ConditionVO condtionVO) throws EventException;
}