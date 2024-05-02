/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepoConstraintBC.java
*@FileTitle : Constraint by Lane/ECC
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	Se-Hoon Park		2006-11-03		1.0 최초 생성
* 2		1.0      	Lee Byoung Hun	2009.08.12		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.08.12
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.08.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.repoconstraint.basic;

import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.repoconstraint.vo.EesEqr0138ConditionVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.EqrScnrPortDchgCnstVO;
import com.hanjin.syscommon.common.table.EqrScnrRepoCnstVO;

/**
 * ALPS-RepoConstraint Business Logic Command Interface<br>
 * - ALPS-RepoConstraint에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 
 * @see Ees_eqr_0138EventResponse 참조
 * @since J2EE 1.6
 */

public interface RepoConstraintBC {

	/**
	 * Constraint by Lane/ECC 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO
	 * @return
	 * @exception EventException
	 */
	public CommonRsVO searchConstraintLaneEccInfo(EesEqr0138ConditionVO conditionVO) throws EventException;
	
	/**
	 * Constraint by Lane/ECC 멀티 이벤트 처리<br>
	 * 
	 * @param eqrScnrPortDchgCnstVOS
	 * @param account
	 * @exception EventException
	 */
	public void modifyConstraintLaneEccInfo(EqrScnrPortDchgCnstVO[] eqrScnrPortDchgCnstVOS, SignOnUserAccount account) throws EventException;
	/**
	 * 조회 이벤트 처리<br>
	 * EES_EQR_0022 화면에 대한 조회 이벤트 처리<br>
	 * 
     * @param scnrid
     * @param cnsttype
     * @param tpsz
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchEmptyRepoConstraintInfo(String scnrid ,String cnsttype , String tpsz) throws EventException;

	/**
	 * 수정 이벤트 처리<br>
	 * EES_EQR_0022 화면에 대한 조회 이벤트 처리<br>
	 * 
     * @param scnrid
     * @param cnsttype
     * @param tpsz
     * @param vos EqrScnrRepoCnstVO[]
     * @param account SignOnUserAccount
     * @return CommonRsVO
	 * @exception EventException
	 */	
	public CommonRsVO modifyEmptyRepoConstraintInfo(String scnrId ,String cnsttype , String tpsz ,EqrScnrRepoCnstVO[] vos , SignOnUserAccount account ) throws EventException;
	
	
	
}