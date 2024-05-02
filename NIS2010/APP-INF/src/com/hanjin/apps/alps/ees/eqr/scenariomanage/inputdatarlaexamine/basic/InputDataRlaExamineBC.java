/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InputDataRlaExamineBC.java
*@FileTitle : Input Data Red Light Alert 조회/수정
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-19
*@LastModifier : yongchan shin
*@LastVersion : 1.0
* 2006-10-19 yongchan shin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.inputdatarlaexamine.basic;

import com.hanjin.apps.alps.ees.eqr.scenariomanage.inputdatarlaexamine.vo.EesEqr0003ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.inputdatarlaexamine.vo.InputDataRLAExamineRsVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.EqrScnrEccVO;

/**
 * ALPS-InputDataRlaExamine Business Logic Command Interface<br>
 * - ENIS-InputDataRlaExamine에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author yongchan shin
 * @see EES_EQR_003EventResponse 참조
 * @since J2EE 1.4
 */
public interface InputDataRlaExamineBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * EES_EQR_009 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param vo EesEqr0003ConditionVO
	 * @param fromEccWhere String
	 * @param toEccWhere String
	 * @return InputDataRLAExamineRsVO
	 * @exception EventException
	 */	
	public InputDataRLAExamineRsVO searchInputDataRLAList(EesEqr0003ConditionVO vo ,String fromEccWhere , String toEccWhere) throws EventException;

	/**
	 * 수정 이벤트 처리<br>
	 * EES_EQR_003 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param cvo EesDqr0003ConditionVO
	 * @param vos EqrScnrEccVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */	
	public void modifyInputDataRLAList(EesEqr0003ConditionVO cvo, EqrScnrEccVO[] vos , SignOnUserAccount account) throws EventException;

}