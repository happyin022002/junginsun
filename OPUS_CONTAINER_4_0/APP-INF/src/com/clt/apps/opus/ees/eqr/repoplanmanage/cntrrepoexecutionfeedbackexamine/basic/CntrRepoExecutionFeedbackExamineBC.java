/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionFeedbackExamineBC.java
*@FileTitle : Execute Plan
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionfeedbackexamine.basic;

import com.clt.apps.opus.ees.eqr.common.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionfeedbackexamine.vo.EesEqr0063ConditionVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * -RepoExecutionFeedbackExamine Business Logic Command Interface<br>
 *
 * @author 
 * @see EventException 
 * @since J2EE 1.6
 */

public interface CntrRepoExecutionFeedbackExamineBC {

	/**
	 * retrieving for repo execution and Feedback (Sheet1)<br>
	 * 
	 * @param EesEqr0063ConditionVO	conditionVO
	 * @return CommonRsVO>
	 * @exception EventException
	 */
	public CommonRsVO searchCntrRepoExecutionFeedback(EesEqr0063ConditionVO conditionVO) throws EventException;
	
	/**retrieving for repo execution and Feedback (Sheet2)<br>
	 * 
	 * @param EesEqr0063ConditionVO	conditionVO
	 * @return CommonRsVO>
	 * @exception EventException
	 */
	public CommonRsVO searchCntrRepoExecutionFeedbcakExamine(EesEqr0063ConditionVO conditionVO) throws EventException;
}