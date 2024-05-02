/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommAgreementBC.java
*@FileTitle : AGNCommAgreementBC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.20
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmagreement.agncommagreement.basic;

import java.util.List;

import com.clt.apps.opus.esm.acm.acmagreement.agncommagreement.vo.AgentRateDetailVO;
import com.clt.apps.opus.esm.acm.acmagreement.agncommagreement.vo.AgentRateMasterVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-ACMAgreement Business Logic Command Interface<br>
 *
 * @author KIM, Sang-Soo
 * @see Esm_Acm_0001EventResponse 
 * @since J2EE 1.6
 */

public interface AGNCommAgreementBC {

	/**
	 * [ESM_ACM_0001-01 / ESM_ACM_0001-03 / ESM_ACM_0101] Retrieve<br>
	 * [Master] tab / [Summary] tab - Master Agreement List retrieve<br>
	 *
	 * @param AgentRateMasterVO agentRateMasterVO
	 * @return List<AgentRateMasterVO>
	 * @exception EventException
	 */
	public List<AgentRateMasterVO> searchAgentRateMaster(AgentRateMasterVO agentRateMasterVO) throws EventException;

	/**
	 * [ESM_ACM_0001-01]
	 * [Master]tab list save<br>
	 *
	 * @param AgentRateMasterVO[] agentRateMasterVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAgentRateMaster(AgentRateMasterVO[] agentRateMasterVOs, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_ACM_0001-02 / ESM_ACM_0001-03]
	 * [Detail]tab - Compensation Master / [Summary]tab - Detail list retrieve<br>
	 *
	 * @param AgentRateMasterVO agentRateMasterVO
	 * @return List<AgentRateDetailVO>
	 * @exception EventException
	 */
	public List<AgentRateDetailVO> searchAgentRateDetail(AgentRateMasterVO agentRateMasterVO) throws EventException;

	/**
	 * [ESM_ACM_0001-02]
	 * [Detail]tab - Compensation Master list save<br>
	 *
	 * @param AgentRateDetailVO[] agentRateDetailVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageAgentRateDetail(AgentRateDetailVO[] agentRateDetailVOs, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_ACM_0001-01 / ESM_ACM_0101]
	 * New Agreement No. retrieve<br>
	 *
	 * @param AgentRateMasterVO agentRateMasterVO
	 * @return List<AgentRateMasterVO>
	 * @exception EventException
	 */
	public List<AgentRateMasterVO> getNewAgreementNo(AgentRateMasterVO agentRateMasterVO) throws EventException;

	/**
	 * [ESM_ACM_0101]
	 * Validation of new agreement No. <br>
	 *
	 * @param AgentRateMasterVO agentRateMasterVO
	 * @exception EventException
	 */
	public void getAgreementNoInfo(AgentRateMasterVO agentRateMasterVO) throws EventException;

	/**
	 * [ESM_ACM_0101]
	 * Agreement number copy<br>
	 *
	 * @param AgentRateMasterVO agentRateMasterVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAgmtCopy(AgentRateMasterVO agentRateMasterVO, SignOnUserAccount account) throws EventException;

}