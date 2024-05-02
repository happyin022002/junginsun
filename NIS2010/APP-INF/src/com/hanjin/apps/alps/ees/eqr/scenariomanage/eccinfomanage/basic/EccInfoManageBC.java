/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EccInfoManageBC.java
*@FileTitle : SCNR ECC 정보 조회/수정
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	yongchan shin		2006-09-28		1.0 최초 생성
* 2      	1.0      	Lee Byoung Hun	2009.07.20		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.07.20
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.07.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.eccinfomanage.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.eqr.scenariomanage.eccinfomanage.vo.EesEqr0007ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.eccinfomanage.vo.SearchEccInfoVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.eccinfomanage.vo.SearchEccTSTMLInfoVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.EqrScnrEccVO;
import com.hanjin.syscommon.common.table.EqrScnrTsTmlVO;

/**
 * NIS2010-EccInfoManage Business Logic Command Interface<br>
 * - NIS2010-EccInfoManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 
 * @see Ees_eqr_007EventResponse 참조
 * @since J2EE 1.6
 */

public interface EccInfoManageBC {
	
	/**
	 * 조회 이벤트 처리<br>
	 * Eccinfomanage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0007ConditionVO
	 * @return List<SearchEccInfoVO>
	 * @exception EventException
	 */
	public List<SearchEccInfoVO> searchECCInfo(EesEqr0007ConditionVO conditionVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Eccinfomanage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0007ConditionVO
	 * @return List<SearchEccTSTMLInfoVO>
	 * @exception EventException
	 */
	public List<SearchEccTSTMLInfoVO> searchTSTMLInfo(EesEqr0007ConditionVO conditionVO) throws EventException;
	
	/**
	 * ECC 정보 조회/수정의 멀티 이벤트 처리<br>
	 * Update 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param eqrScnrEccVOs EqrScnrEccVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyECCInfo(EqrScnrEccVO[] eqrScnrEccVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * ECC 정보 조회/수정의 멀티 이벤트 처리<br>
	 * Update 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param eqrScnrTsTmlVOs EqrScnrTsTmlVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyTSTMLInfo(EqrScnrTsTmlVO[] eqrScnrTsTmlVOs,SignOnUserAccount account) throws EventException;
	
}