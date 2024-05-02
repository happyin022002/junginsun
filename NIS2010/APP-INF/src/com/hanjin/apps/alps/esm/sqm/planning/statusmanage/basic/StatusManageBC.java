/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : StatusManageBC.java
*@FileTitle      : StatusManageBC
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.31
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.31 SQM USER
* 1.0 Creation
* 2015.05.15 이혜민 [CHM-201535608] Freezing전 RHQ별 Portion 존재하고, Office portion이 없는 List 조회.
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.statusmanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.sqm.planning.statusmanage.vo.SearchQtaEstablishingStatusListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SqmQtaStepVerVO;

/**
 * ALPS-StatusManage Business Logic Command Interface<br>
 * - ALPS-StatusManage 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SQM USER
 * @see
 * @since J2EE 1.6
 */
public interface StatusManageBC {
	
	/**
	 * ESM_SQM_0028 : SEARCH 이벤트 처리<br>
	 * [QTA Establishing Status]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaEstablishingStatusListVO>
	 * @throws EventException
	 */
	public List<SearchQtaEstablishingStatusListVO> searchQtaEstablishingStatusList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_SQM_0028 : MULTI 이벤트 처리<br>
	 * [QTA Establishing Status]을 [Cancel Confirm] 합니다.<br>
	 * 
	 * @param SqmQtaStepVerVO[] sqmQtaStepVerVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void cancelConfirmQtaStepVer(SqmQtaStepVerVO[] sqmQtaStepVerVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0028 : MULTI 이벤트 처리<br>
	 * [QTA Establishing Status]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @param String step
	 * @throws EventException
	 */
	public void createQtaStepVer(ConditionVO conditionVO, SignOnUserAccount account, String step) throws EventException;
	
	/**
	 * ESM_SQM_0028 : SEARCH 이벤트 처리<br>
	 * [QTA Establishing Status]을 [Step 별 Count 를 확인] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @throws EventException
	 */
	public String searchQtaStepCnt(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_SQM_0028 : MULTI04 이벤트 처리<br>
	 * [QTA Establishing Status]을 [생성] 전 RHQ에는 Portion을 부여했으나 해당 RHQ 산하의 Office에게 Portion을 부여하지 않은 RHQ List를 조회합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchOfcZeroPortion(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_SQM_0028 : MULTI04 이벤트 처리<br>
	 * [QTA Establishing Status]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String createQtaFreezing(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0028 : MULTI05 이벤트 처리<br>
	 * [QTA Establishing Status]을 [연간으로 1Q 생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String createQtaTransfer(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * BackEndJob의 상태값을 조회한다.<br>
	 * 
	 * @param String key
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchBackEndJobVO(String key) throws EventException;
}