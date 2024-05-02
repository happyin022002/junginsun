/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AccrualBatchManageBC.java
*@FileTitle : Expense Accrual Batch Main
*Open Issues :
*Change history : 2007.01 Park Yeon Jin 최초생성
*@LastModifyDate : 2009.10.05
*@LastModifier : Jeon Jae Hong
*@LastVersion : 1.0
* 2009.10.05 Jeon Jae Hong
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchmanage.basic;

import java.util.List;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.LeaAcclCondItmVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchmanage.vo.SearchAccrualBatchPreConditionVO;
import com.hanjin.syscommon.common.table.GlAcclIfVO;

/**
 * ALPS-Logisticsexpenseaccrual Business Logic Command Interface<br>
 * - ALPS-Logisticsexpenseaccrual에 대한 비지니스 로직에 대한 인터페이스<br>
 * @author Jeon Jae Hong
 * @see Esd_lea_0001EventResponse 참조
 * @since J2EE 1.6
 */

public interface AccrualBatchManageBC {

	/**
	 * 결산 배치 프로그램 실행 사전조건을 조회한다.<br>
	 * @param SearchAccrualBatchPreConditionVO searchAccrualBatchPreConditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchAccrualBatchPreConditionVO>
	 * @exception EventException
	 */
	public List<SearchAccrualBatchPreConditionVO> searchAccrualBatchPreCondition(SearchAccrualBatchPreConditionVO searchAccrualBatchPreConditionVO , SignOnUserAccount account) throws EventException;
	
	
	/**
	 * 결산 배치 프로그램 실행 사전조건을 Confirm 한다.<br>
	 * @param String frmExeYrmon 
	 * @param String frmConfirmDiv
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyAccrualBatchPreConditionConfirm(String frmExeYrmon , String frmConfirmDiv, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * 결산 배치 프로그램을 실행한다.<br>
	 * @param String frmExeYrmon
	 * @return String
	 * @exception EventException
	 */
	public String executeAccrualBatch(String frmExeYrmon) throws EventException;

}