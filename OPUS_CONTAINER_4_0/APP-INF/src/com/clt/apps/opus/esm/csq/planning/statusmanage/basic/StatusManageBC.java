/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : StatusManageBC.java
*@FileTitle      : StatusManageBC
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.31
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.05.31 CSQ USER
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.planning.statusmanage.basic;

import java.util.List;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.apps.opus.esm.csq.planning.statusmanage.vo.SearchQtaEstablishingStatusListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CsqQtaStepVerVO;

/**
 * ALPS-StatusManage Business Logic Command Interface<br>
 * - ALPS-StatusManage 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CSQ USER
 * @see
 * @since J2EE 1.6
 */
public interface StatusManageBC {
	
	/**
	 * ESM_CSQ_0036 : SEARCH 이벤트 처리<br>
	 * [QTA Establishing Status]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaEstablishingStatusListVO>
	 * @throws EventException
	 */
	public List<SearchQtaEstablishingStatusListVO> searchQtaEstablishingStatusList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_CSQ_0036 : MULTI 이벤트 처리<br>
	 * [QTA Establishing Status]을 [Cancel Confirm] 합니다.<br>
	 * 
	 * @param CsqQtaStepVerVO[] csqQtaStepVerVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void cancelConfirmQtaStepVer(CsqQtaStepVerVO[] csqQtaStepVerVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_CSQ_0036 : MULTI 이벤트 처리<br>
	 * [QTA Establishing Status]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @param String step
	 * @throws EventException
	 */
	public void createQtaStepVer(ConditionVO conditionVO, SignOnUserAccount account, String step) throws EventException;
	
	/**
	 * ESM_CSQ_0036 : SEARCH 이벤트 처리<br>
	 * [QTA Establishing Status]을 [Step 별 Count 를 확인] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @throws EventException
	 */
	public String searchQtaStepCnt(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_CSQ_0036 : MULTI04 이벤트 처리<br>
	 * [QTA Establishing Status]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String createQtaFreezing(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_CSQ_0036 : MULTI05 이벤트 처리<br>
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