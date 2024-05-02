/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AccrualBatchManageBC.java
*@FileTitle : Expense Accrual Batch Main
*Open Issues :
*Change history : 
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchmanage.basic;

import java.util.List;

import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchmanage.vo.SearchAccrualBatchPreConditionVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.GlAcclIfVO;
import com.clt.syscommon.common.table.LeaAcclCondItmVO;

/**
 * ALPS-LogisticsExpenseAccrual Business Logic Command Interface<br>
 * - The interface of business logic about ALPS-LogisticsExpenseAccrual<br>
 * @author
 * @see Esd_lea_0001EventResponse 
 * @since J2EE 1.6
 */

public interface AccrualBatchManageBC {

	/**
	 * Inquiring the the preceding condition of the settling program<br>
	 * @param SearchAccrualBatchPreConditionVO searchAccrualBatchPreConditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchAccrualBatchPreConditionVO>
	 * @exception EventException
	 */
	public List<SearchAccrualBatchPreConditionVO> searchAccrualBatchPreCondition(SearchAccrualBatchPreConditionVO searchAccrualBatchPreConditionVO , SignOnUserAccount account) throws EventException;
	
	
	/**
	 * Confirming the preceding condition of the settling program<br>
	 * @param String frmExeYrmon 
	 * @param String frmConfirmDiv
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyAccrualBatchPreConditionConfirm(String frmExeYrmon , String frmConfirmDiv, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * Executing the settling batch program.<br>
	 * @param String frmExeYrmon
	 * @return String
	 * @exception EventException
	 */
	public String executeAccrualBatch(String frmExeYrmon) throws EventException;

}