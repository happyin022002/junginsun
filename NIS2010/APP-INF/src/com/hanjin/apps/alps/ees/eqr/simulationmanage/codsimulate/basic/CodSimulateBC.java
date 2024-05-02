/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodSimulateBC.java
*@FileTitle : Change POD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.08.24 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.codsimulate.basic;

import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.codsimulate.vo.EesEqr0012ConditionVO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.codsimulate.vo.EesEqr0140ConditionVO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.codsimulate.vo.EesEqr0012MultiVO;

import com.hanjin.syscommon.common.table.EqrVslLdisPlnCodTmpVO;
import com.hanjin.syscommon.common.table.EqrVslPlnCodQtyVO;
/**
 * ALPS-CodSimulate Business Logic Command Interface<br>
 * - ALPS-CodSimulate에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Chae Change Ho
 * @see EventResponse 참조
 * @since J2EE 1.6
 */

public interface CodSimulateBC {

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param conditionVO	EesEqr0012ConditionVO
	 * @param account SignOnUserAccount
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchRepoPlanInfo(EesEqr0012ConditionVO conditionVO ,SignOnUserAccount account) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param conditionVO	EesEqr0012ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchKeyRepoPlanInfo(EesEqr0012ConditionVO conditionVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param conditionVO	EesEqr0012ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchCntrRepoInOutPlanVvdInfo(EesEqr0012ConditionVO conditionVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param conditionVO	EesEqr0012ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchLaneExistInfo(EesEqr0012ConditionVO conditionVO) throws EventException;
	
	/**
	 * [Change POD]을 [MULTI] 합니다.<br>
	 * 
	 * @param vos EqrVslLdisPlnCodTmpVO[]
	 * @param vos1 EqrVslPlnCodQtyVO[]
	 * @param conditionVO EesEqr0012ConditionVO
	 * @param mutiVO EesEqr0012MultiVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void  modifyRepoPlanInfo(EqrVslLdisPlnCodTmpVO[] vos, EqrVslPlnCodQtyVO[] vos1, EesEqr0012ConditionVO conditionVO, EesEqr0012MultiVO[] mutiVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [Change POD]을 [MULTI] 합니다.<br>
	 * 
	 * @param conditionVO	EesEqr0012ConditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void  modifyComfirmRepoPlanInfo(EesEqr0012ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param conditionVO	EesEqr0012ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchPOLChangePlanCompare(EesEqr0012ConditionVO conditionVO ) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param conditionVO	EesEqr0012ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchPODChangePlanCompare(EesEqr0012ConditionVO conditionVO ) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param conditionVO	EesEqr0140ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchBayPlan(EesEqr0140ConditionVO conditionVO ) throws EventException;
	
}