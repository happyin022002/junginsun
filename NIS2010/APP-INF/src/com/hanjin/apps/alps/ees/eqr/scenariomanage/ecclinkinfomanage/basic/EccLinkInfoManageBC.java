/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EccLinkInfoManageBC.java
*@FileTitle : SCNR Link 정보 조회/수정
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	yongchan shin		2006-10-17		1.0 최초 생성
* 2      	1.0      	Lee Byoung Hun	2009.07.24		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.07.24
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.07.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.ecclinkinfomanage.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.eqr.scenariomanage.ecclinkinfomanage.vo.EesEqr0009ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.ecclinkinfomanage.vo.SearchEccLinkInfoVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.EqrScnrEccLnkVO;

/**
 * ALPS-EccLinkInfoManage Business Logic Command Interface<br>
 * - ALPS-EccLinkInfoManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 
 * @see Ees_eqr_009EventResponse 참조
 * @since J2EE 1.6
 */

public interface EccLinkInfoManageBC {
	/**
	 * 조회 이벤트 처리<br>
	 * Ecclinkinfomanage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0009ConditionVO
	 * @return List<SearchEccLinkInfoVO>
	 * @exception EventException
	 */
	public List<SearchEccLinkInfoVO> searchECCLinkInfo(EesEqr0009ConditionVO conditionVO) throws EventException;
	
	/**
	 * ECC 정보 조회/수정의 멀티 이벤트 처리<br>
	 * Update 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param eqrScnrEccLnkVOs EqrScnrEccLnkVO[]
	 * @param scnrId String
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyECCLinkInfo(EqrScnrEccLnkVO[] eqrScnrEccLnkVOs, String scnrId, SignOnUserAccount account) throws EventException;
	
}