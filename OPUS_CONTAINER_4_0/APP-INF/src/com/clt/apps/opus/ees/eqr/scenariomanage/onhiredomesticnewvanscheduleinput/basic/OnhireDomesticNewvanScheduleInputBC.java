/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnhireDomesticNewvanScheduleInputBC.java
*@FileTitle : 연간신조 및 L/T 계획 조회 / 수정
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	jungran yang		2006-09-20		1.0 최초 생성
* 2      	1.0      	Lee Byoung Hun	2009.07.29		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.07.29
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.07.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.basic;

import com.clt.apps.opus.ees.eqr.common.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.vo.EesEqr0020ConditionVO;
import com.clt.apps.opus.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.vo.EesEqr0021ConditionVO;
import com.clt.apps.opus.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.vo.EesEqr0090ConditionVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.EqrScnrDmstVO;
import com.clt.syscommon.common.table.EqrScnrNewVanLongTermVO;
import com.clt.syscommon.common.table.EqrScnrSlseVO;

/**
 * ALPS-OnhireDomesticNewvanScheduleInput Business Logic Command Interface<br>
 * - ALPS-OnhireDomesticNewvanScheduleInput에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 
 * @see Ees_eqr_0020EventResponse 참조
 * @since J2EE 1.6
 */

public interface OnhireDomesticNewvanScheduleInputBC {
	
	/**
	 * 연간신조 및 L/T 계획 조회 / 수정 조회 이벤트 처리 (상단 Sheet 조회)<br>
	 * 
	 * @param conditionVO	EesEqr0020ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchYearNewvanPlan(EesEqr0020ConditionVO conditionVO) throws EventException;

	/**
	 * 연간신조 및 L/T 계획 조회 / 수정 조회 이벤트 처리 (하단 Sheet 조회)<br>
	 * 
	 * @param conditionVO	EesEqr0020ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchWeeklyNewvanPlan(EesEqr0020ConditionVO conditionVO) throws EventException;
	
	/**
	 * 연간신조 및 L/T 계획 조회 / 수정 조회 이벤트 처리 (코드 조회)<br>
	 * 
	 * @param searchword	String
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO codeLocsearch(String searchword) throws EventException;
	
	
	
	/**
	 * 연간신조 및 L/T 계획 조회 / 수정 조회 이벤트 처리 (코드 조회)<br>
	 * 
	 * @param searchword	String
	 * @param account		SignOnUserAccount
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO codeEqrLocsearch(String searchword ,  SignOnUserAccount account) throws EventException;
	
	
	/**
	 * 연간신조 및 L/T 계획 조회 / 수정 조회 이벤트 처리 (코드 조회)<br>
	 * 
	 * @param searchword	String
	 * @param account		SignOnUserAccount
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO codeEqrTruckLocsearch(String searchword ,  SignOnUserAccount account) throws EventException;
	
	/**
	 * 연간신조 및 L/T 계획 조회 / 수정 멀티 이벤트 처리<br>
	 * 
	 * @param eqrScnrNewVanLongTermVOS EqrScnrNewVanLongTermVO[]\
	 * @param scnrId String
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyYearNewvanPlan(EqrScnrNewVanLongTermVO[] eqrScnrNewVanLongTermVOS, String scnrId, SignOnUserAccount account) throws EventException;
	
	/**
	 * US Domestic 물량 조회/수정 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO	EesEqr0021ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchYearDomesticPlan(EesEqr0021ConditionVO conditionVO) throws EventException;
	
	/**
	 * US Domestic 물량 조회/수정 Share 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0021ConditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void searchDomesticPerformance(EesEqr0021ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * US Domestic 물량 조회/수정 Save 이벤트 처리<br>
	 * 
	 * @param eqrScnrDmstVOS EqrScnrDmstVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyYearDomesticPlan(EqrScnrDmstVO[] eqrScnrDmstVOS, SignOnUserAccount account) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * OnhireDomesticNewvanScheduleInput화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0090ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */	
	public CommonRsVO searchYearSubleasePlan(EesEqr0090ConditionVO conditionVO) throws EventException;
	/**
	 * 수정 이벤트 처리<br>
	 * EES_EQR_090 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param vos EqrScnrSlseVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	
	public void modifyYearSubleasePlan(EqrScnrSlseVO[] vos  , SignOnUserAccount account) throws EventException;
	/**
     * Share 이벤트 처리<br>
     * EES_EQR_090 화면에 대한 Share 이벤트 처리<br>
     * 
	 * @param conditionVO EesEqr0090ConditionVO
	 * @param account SignOnUserAccount
     * @exception EventException
     */
	public void searchSubleasePerformance(EesEqr0090ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
}