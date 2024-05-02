/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodSimulateBC.java
*@FileTitle : Change POD
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.basic;

import com.clt.apps.opus.ees.eqr.common.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.vo.EesEqr0012ConditionVO;
import com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.vo.EesEqr0012MultiVO;
import com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.vo.EesEqr0140ConditionVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * -CodSimulate Business Logic Command Interface<br>
 * - -CodSimulate에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Chae Change Ho
 * @see EventResponse 참조
 * @since J2EE 1.6
 */

public interface CodSimulateBC {

	/**
	 * [EES_EQR_0012] 신규생성되는 Repo ID에 대한 정보를 조회<br>
	 * 
	 * @param conditionVO EesEqr0012ConditionVO
	 * @param account SignOnUserAccount
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchRepoPlanPreInfo(EesEqr0012ConditionVO conditionVO ,SignOnUserAccount account) throws EventException;
	
	/**
	 * [Change POD화면에서 조건으로]을 [조회] 합니다.<br>
	 * 
	 * @param conditionVO EesEqr0012ConditionVO
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
	 * @param account			SignOnUserAccount
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchCntrRepoInOutPlanVvdInfo(EesEqr0012ConditionVO conditionVO,SignOnUserAccount account) throws EventException;
	
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param eesEqr0012ConditionVO EesEqr0012ConditionVO
	 * @return String
	 * @exception EventException
	 */
	public CommonRsVO searchCODVskLaneData(EesEqr0012ConditionVO eesEqr0012ConditionVO) throws EventException;
		
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
	 * @param conditionVO EesEqr0012ConditionVO
	 * @param mutiVO EesEqr0012MultiVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void  modifyRepoPlanInfo(EesEqr0012ConditionVO conditionVO, EesEqr0012MultiVO[] mutiVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [Change POD]을 [MULTI] 합니다.<br>
	 * 
	 * @param conditionVO	EesEqr0012ConditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void  modifyComfirmRepoPlanInfo(EesEqr0012ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * [Change POD]을 [MULTI] 합니다.<br>
	 * 
	 * @param conditionVO	EesEqr0012ConditionVO
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String createManualRepoPlanId(EesEqr0012ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * 멀티 이벤트 처리<br>
	 * [EES_EQR_0012 : Repo Plan Id 삭제 ]<br>
	 * 
	 * @param conditionVO EesEqr0012ConditionVO
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String deleteRepoPlanId( EesEqr0012ConditionVO conditionVO ,SignOnUserAccount account) throws EventException;
		
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
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param conditionVO EesEqr0012ConditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyRepoPlnIdNm(EesEqr0012ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Plan ID 등록여부조회<br>
	 * 
	 * @param conditionVO EesEqr0012ConditionVO
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String searchRepoPlanIdViewInfo( EesEqr0012ConditionVO conditionVO ,SignOnUserAccount account) throws EventException;
	
	/**
	 * [Change POD]을 [MULTI] 합니다.<br>
	 * 
	 * @param conditionVO	EesEqr0012ConditionVO
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String createManualNewRepoPlanId(EesEqr0012ConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	
	/**
	 * 
	 * @param eesEqr0012ConditionVO
	 * @return
	 * @throws EventException
	 */
	public CommonRsVO searchCODVskLaneLocData(EesEqr0012ConditionVO eesEqr0012ConditionVO) throws EventException;
}