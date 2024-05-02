/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AgentRateMasterBC.java
*@FileTitle : AgentRateMasterBC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.15
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.15 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmhistory.agncommagmthistory.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmhistory.agncommagmthistory.vo.AgncommagmtDetailHistoryVO;
import com.hanjin.apps.alps.esm.acm.acmhistory.agncommagmthistory.vo.AgncommagmtMasterHistoryVO;
import com.hanjin.apps.alps.esm.acm.acmhistory.agncommagmthistory.vo.AgncommagmthistoryVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-ACMAgreement Business Logic Command Interface<br>
 * - ALPS-ACMAgreement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Young-Oh
 * @see Esm_Acm_0017EventResponse 참조
 * @since J2EE 1.6
 */

public interface AGNCommAgmtHistoryBC {

	/**
	 * [ESM_ACM_0017]
	 * Agent Commission Agreement History (master) - Agreement List 목록을 조회<br>
	 *
	 * @param AgncommagmthistoryVO agncommagmthistoryVO
	 * @return List<AgncommagmthistoryVO>
	 * @exception EventException
	 */
	public List<AgncommagmthistoryVO> searchAgncommagmthistory(AgncommagmthistoryVO agncommagmthistoryVO) throws EventException;

	/**
	 * [ESM_ACM_0017]
	 * Agent Commission Agreement History (master) - Master History 목록을 조회<br>
	 *
	 * @param AgncommagmtMasterHistoryVO agncommagmtMasterHistoryVO
	 * @return List<AgncommagmtMasterHistoryVO>
	 * @exception EventException
	 */
	public List<AgncommagmtMasterHistoryVO> searchAgncommagmtMasterHistory(AgncommagmtMasterHistoryVO agncommagmtMasterHistoryVO) throws EventException;
	
	/**
	 * [ESM_ACM_0017]
	 * Agent Commission Agreement History (master) - Detail(Compensation) History 목록을 조회<br>
	 *
	 * @param AgncommagmtDetailHistoryVO agncommagmtDetailHistoryVO
	 * @return List<AgncommagmtDetailHistoryVO>
	 * @exception EventException
	 */
	public List<AgncommagmtDetailHistoryVO> searchAgncommagmtDetailHistory(AgncommagmtDetailHistoryVO agncommagmtDetailHistoryVO) throws EventException;
}