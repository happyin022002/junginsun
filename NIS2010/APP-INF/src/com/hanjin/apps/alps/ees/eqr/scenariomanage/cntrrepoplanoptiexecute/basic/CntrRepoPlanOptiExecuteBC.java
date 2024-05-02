/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanOptiExecuteBC.java
*@FileTitle : run_optimizer
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.07.28 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.basic;

import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.event.EesEqr0050Event;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.vo.CntrRepoPlanOptiExecuteRsVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.vo.EesEqr0049ConditionVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-CntrRepoPlanOptiExecute Business Logic Command Interface<br>
 * - ALPS-CntrRepoPlanOptiExecute 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Chae Change Ho
 * @see Ees_eqr_0049EventResponse 참조
 * @since J2EE 1.6
 */

public interface CntrRepoPlanOptiExecuteBC {

	/**
	 * 시나리오 정보를 조회하는 interface.<br>
	 * 
	 * @param eesEqr0049ConditionVO	EesEqr0049ConditionVO
	 * @return CntrRepoPlanOptiExecuteRsVO
	 * @exception EventException
	 */
	public CntrRepoPlanOptiExecuteRsVO searchScenarioList(EesEqr0049ConditionVO eesEqr0049ConditionVO) throws EventException;
	
		
	/**
	 * 엔진 running 체크 interface.<br>
	 * 
	 * @exception EventException
	 */
	public void selectEnginCheck() throws EventException;
	
	/**
	 * MAX repo_pln_id 구하기 interface.<br>
	 * 
	 * @param eesEqr0049ConditionVO EesEqr0049ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchMaxPlanID(EesEqr0049ConditionVO eesEqr0049ConditionVO) throws EventException;
	
	/**
	 * 엔진을 실행을 위한 환경값저장 interface.<br>
	 * 
	 * @param eesEqr0049ConditionVO EesEqr0049ConditionVO
	 * @param weekStdt String
	 * @param userId String
	 * @exception EventException
	 */
	public void createRepoPlanRunOptimizer(EesEqr0049ConditionVO eesEqr0049ConditionVO ,String weekStdt, String userId) throws EventException;
	
	/**
	 * 엔진환경 삭제  interface.<br>
	 * 
	 * @param eesEqr0049ConditionVO EesEqr0049ConditionVO
	 * @exception EventException
	 */
	public void deleteRepoPlanRunOptimizer(EesEqr0049ConditionVO eesEqr0049ConditionVO) throws EventException;
	
	/**
	 * JMS 환경으로 넘겨받은 트랜잭션을 다시 이어주는 메소드 interface.<br>
	 * 
	 * @param eesEqr0049ConditionVO EesEqr0049ConditionVO
	 * @param user_id String
	 * @exception EventException
	 */
	public void send0049ReRunSteve(EesEqr0049ConditionVO eesEqr0049ConditionVO ,String user_id) throws EventException;
	
	/**
	 * 엔진환경 셋팅은 위한 프로시져 실행 interface.<br>
	 * 
	 * @param eesEqr0049ConditionVO EesEqr0049ConditionVO
	 * @param weekStdt String
	 * @exception EventException
	 */
	public void enginRunOptimizer(EesEqr0049ConditionVO eesEqr0049ConditionVO , String weekStdt) throws EventException;
	
	/**
	 *  엔진 모니터링 interface.<br>
	 * 
	 * @param eesEqr0050Event EesEqr0050Event
	 * @param account SignOnUserAccount
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchMonitor(EesEqr0050Event eesEqr0050Event ,SignOnUserAccount account) throws EventException;
	/**
	 * OUT_PUT procedures 호출<br>
	 * EES_EQR_050화면에 대한 조회 이벤트 처리<br>
	 * @param str String
	 * @exception EventException
	 */ 
    public void enginOutput(String str) throws EventException;

    /**
	 * [ EES_EQR_0127 : Scenario Copy Monitoring ]<br>
	 * 
	 * @param scnr_id	String
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO scnrCopysearchMonitor (String scnr_id) throws EventException;
}
