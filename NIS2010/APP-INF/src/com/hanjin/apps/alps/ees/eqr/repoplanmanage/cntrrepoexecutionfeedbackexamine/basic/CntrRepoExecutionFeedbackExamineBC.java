/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionFeedbackExamineBC.java
*@FileTitle : 컨테이너 이송실행 실적 및 Feedback 조회
*Open Issues :
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1		1.0		ChangHoChae					2006-10-24		1.0 최초 생성
* 2      	1.0      	Lee Byoung Hun				2009.09.23		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.09.23
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.09.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionfeedbackexamine.basic;

import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionfeedbackexamine.vo.EesEqr0063ConditionVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-RepoExecutionFeedbackExamine Business Logic Command Interface<br>
 * - ALPS-RepoExecutionFeedbackExamine 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 
 * @see EventException 참조
 * @since J2EE 1.6
 */

public interface CntrRepoExecutionFeedbackExamineBC {

	/**
	 * 컨테이너 이송실행 실적 및 Feedback 조회 이벤트 처리 (Sheet1)<br>
	 * 
	 * @param EesEqr0063ConditionVO	conditionVO
	 * @return CommonRsVO>
	 * @exception EventException
	 */
	public CommonRsVO searchCntrRepoExecutionFeedback(EesEqr0063ConditionVO conditionVO) throws EventException;
	
	/**
	 * 컨테이너 이송실행 실적 및 Feedback 조회 이벤트 처리 (Sheet2)<br>
	 * 
	 * @param EesEqr0063ConditionVO	conditionVO
	 * @return CommonRsVO>
	 * @exception EventException
	 */
	public CommonRsVO searchCntrRepoExecutionFeedbcakExamine(EesEqr0063ConditionVO conditionVO) throws EventException;
}