/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnewaySimulateBC.java
*@FileTitle : OnewaySimulate
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.14 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.onewaysimulate.basic;

import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.onewaysimulate.vo.EesEqr0010ConditionVO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.onewaysimulate.vo.EesEqr0010MutiVO;
import com.hanjin.framework.core.layer.event.EventException;
/**
 * ALPS-Simulationmanage Business Logic Command Interface<br>
 * - ALPS-Simulationmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Chae Change Ho
 * @see OnewaySimulateBC 참조
 * @since J2EE 1.6
 */

public interface OnewaySimulateBC {

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param conditionVO	EesEqr0010ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchTotalOneWayOffer(EesEqr0010ConditionVO conditionVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param conditionVO	EesEqr0010ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchTotalOneWayOfferExist(EesEqr0010ConditionVO conditionVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param conditionVO	EesEqr0010ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchTotalOneWayOfferGap(EesEqr0010ConditionVO conditionVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param conditionVO	EesEqr0010ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchTotalOneWayOfferMax(EesEqr0010ConditionVO conditionVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param conditionVO	EesEqr0010ConditionVO
	 * @param mutiVO	EesEqr0010MutiVO[]
	 * @param new_repo_id	String
	 * @exception EventException
	 */
	public void modifyOneWayOffer(EesEqr0010ConditionVO conditionVO , EesEqr0010MutiVO[] mutiVO , String new_repo_id) throws EventException;
	
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param conditionVO	EesEqr0010ConditionVO
	 * @exception EventException
	 */
	public void send0010ReRunSteve(EesEqr0010ConditionVO conditionVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param conditionVO	EesEqr0010ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchOneWayPlanCompare(EesEqr0010ConditionVO conditionVO) throws EventException;
	
}