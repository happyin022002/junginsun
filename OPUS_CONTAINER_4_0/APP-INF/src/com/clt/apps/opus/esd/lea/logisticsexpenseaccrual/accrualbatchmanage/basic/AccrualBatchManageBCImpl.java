/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AccrualBatchManageBCImpl.java
*@FileTitle : Expense Accrual Batch Main
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchmanage.integration.AccrualBatchManageDBDAO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchmanage.vo.SearchAccrualBatchPreConditionVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-LogisticsExpenseAccrual Business Logic Basic Command implementation
 * - Process the business logic about ALPS-LogisticsExpenseAccrual.
 * @author 
 * @see ESD_LEA_0001EventResponse,AccrualBatchManageBC
 * @since J2EE 1.6
 */
public class AccrualBatchManageBCImpl extends BasicCommandSupport implements AccrualBatchManageBC {

	/** Database Access Object*/
	private transient AccrualBatchManageDBDAO 	dbDao 		= null;

	/**
	 * Create AccrualBatchManageBCImpl object.
	 * Create AccrualBatchManageDBDAO.
	 */
	public AccrualBatchManageBCImpl() {
		dbDao 		= new AccrualBatchManageDBDAO();
		
	}

	/**
	 * Inquiring the the preceding condition of the settling program.<br>
	 * @param SearchAccrualBatchPreConditionVO searchAccrualBatchPreConditionVO 
	 * @param SignOnUserAccount account
	 * @return List<SearchAccrualBatchPreConditionVO>
	 * @exception EventException
	 */
	public List<SearchAccrualBatchPreConditionVO> searchAccrualBatchPreCondition(SearchAccrualBatchPreConditionVO searchAccrualBatchPreConditionVO , SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchAccrualBatchPreCondition(searchAccrualBatchPreConditionVO , account );
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * Confirming the preceding condition of the settling program<br>
	 * @param String frmExeYrmon
	 * @param String frmConfirmDiv
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyAccrualBatchPreConditionConfirm(String frmExeYrmon , String frmConfirmDiv ,SignOnUserAccount account) throws EventException{
		try {
			
			if ("E".equals(frmConfirmDiv)){					
				dbDao.removeModifyAccrualBatchPreConditionConfirmS(frmExeYrmon);
				dbDao.addModifyAccrualBatchPreConditionConfirmS(frmExeYrmon);
				dbDao.modifyModifyAccrualBatchPreConditionConfirmS(frmExeYrmon, frmConfirmDiv , account.getUsr_id(),account.getOfc_cd()); 				
			}else {						
				dbDao.modifyModifyAccrualBatchPreConditionConfirmS(frmExeYrmon, frmConfirmDiv , account.getUsr_id(),account.getOfc_cd());				
			}
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * Executing the settling batch program.<br>
	 * @param String frmExeYrmon
	 * @return String
	 * @exception EventException
	 */
	public String executeAccrualBatch(String frmExeYrmon) throws EventException{
		String 			returnMsg 				= "";
		final String 	sErrorMsgBatchStarted	= "Batch started.";
		final String 	sErrorMsgBatchRunning	= "Batch is already running.";
		
		/* Procedure Input+Output Parameter
		 * =================================================================
		 * LEA_BAT_START_PRC(exe_yrmon_in IN VARCHAR2, msg_out OUT VARCHAR2)
		 * -----------------------------------------------------------------
		 * OUT Arguments : Variable Name - msg_out, Data Type - Varchar2 
		 * LEA00001 :: msg_out := 'Batch is already running.' 	Desc : ''
		 * LEA00002 :: msg_out := 'Batch started.'				Desc : ''  
		 * =================================================================
		 * */		
		
		try {
			returnMsg = dbDao.executeAccrualBatch(frmExeYrmon);
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		return returnMsg;
	}
	
}