/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LeaseInfoManageBC.java
*@FileTitle : ST On-Hire
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.07.27 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.basic;

import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.vo.EesEqr0017ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.vo.EesEqr0085ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.vo.EesEqr0086ConditionVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.EqrScnrLongTermOffhCondVO;
import com.hanjin.syscommon.common.table.EqrScnrShrtTermOffhCondVO;
import com.hanjin.syscommon.common.table.EqrScnrShrtTermOnhCondVO;

/**
 * ALPS-LeaseInfoManage Business Logic Command Interface<br>
 * - ALPS-LeaseInfoManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Haeng-ji,Lee
 * @see Ees_eqr_0017EventResponse 참조
 * @since J2EE 1.6
 */

public interface LeaseInfoManageBC {

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param eesEqr0017ConditionVO	EesEqr0017ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchSTOnHireInfo(EesEqr0017ConditionVO eesEqr0017ConditionVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param eqrScnrShrtTermOnhCond EqrScnrShrtTermOnhCondVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifySTOnHireinfo(EqrScnrShrtTermOnhCondVO[] eqrScnrShrtTermOnhCond,SignOnUserAccount account) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param eesEqr0086ConditionVO	EesEqr0086ConditionVO
	 * @param ecc_info	String
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchLTOffHireInfo(EesEqr0086ConditionVO eesEqr0086ConditionVO ,String ecc_info) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param eqrScnrLongTermOffhCondVO EqrScnrLongTermOffhCondVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyLTOffHireInfo(EqrScnrLongTermOffhCondVO[] eqrScnrLongTermOffhCondVO,SignOnUserAccount account) throws EventException;
	/**
	 * 조회 이벤트 처리<br>
	 * EES_EQR_085 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0085ConditionVO
	 * @param eccInfo String
	 * @return CommonRsVO
	 * @exception EventException
	 */	
	public CommonRsVO searchSTOffHireInfo(EesEqr0085ConditionVO conditionVO , String eccInfo) throws EventException;

	/**
	 * 수정 이벤트 처리<br>
	 * EES_EQR_085 화면에 대한 수정 이벤트 처리<br>
	 * 
	 * @param vos EqrScnrShrtTermOffhCondVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */	
	public void modifySTOffHireInfo(EqrScnrShrtTermOffhCondVO[] vos,SignOnUserAccount account) throws EventException;
	
}