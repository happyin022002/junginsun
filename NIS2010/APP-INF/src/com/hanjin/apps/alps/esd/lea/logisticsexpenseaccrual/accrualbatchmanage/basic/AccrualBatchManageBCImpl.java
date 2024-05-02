/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AccrualBatchManageBCImpl.java
*@FileTitle : Expense Accrual Batch Main
*Open Issues :
*Change history :2007.01 Park Yeon Jin 최초생성
*@LastModifyDate : 2009.10.05
*@LastModifier : Jeon Jae Hong
*@LastVersion : 1.0
* 2009.10.05 Jeon Jae Hong
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchmanage.basic;

import java.util.ArrayList;
import java.util.List;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchmanage.integration.AccrualBatchManageDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchmanage.vo.SearchAccrualBatchPreConditionVO;


/**
 * ALPS-LogisticsExpenseAccrual Business Logic Basic Command implementation
 * - ALPS-LogisticsExpenseAccrual에 대한 비지니스 로직을 처리한다.
 * @author Jeon Jae Hong
 * @see ESD_LEA_0001EventResponse,AccrualBatchManageBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class AccrualBatchManageBCImpl extends BasicCommandSupport implements AccrualBatchManageBC {

	/** Database Access Object*/
	private transient AccrualBatchManageDBDAO 	dbDao 		= null;

	/**
	 * AccrualBatchManageBCImpl 객체 생성
	 * AccrualBatchManageDBDAO를 생성한다.
	 */
	public AccrualBatchManageBCImpl() {
		dbDao 		= new AccrualBatchManageDBDAO();
		
	}

	/**
	 * 결산 배치 프로그램 실행 사전조건을 조회한다.<br>
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
	 * 결산 프로그램 실행 사전조건을 Confirm 한다.<br>
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
	 * 결산 배치 프로그램을 실행한다.<br>
	 * @param String frmExeYrmon
	 * @return String
	 * @exception EventException
	 */
	public String executeAccrualBatch(String frmExeYrmon) throws EventException{
		String 			returnMsg 				= "";
		final String 	sErrorMsgBatchStarted	= "Batch started.";
		final String 	sErrorMsgBatchRunning	= "Batch is already running.";
		
		/* Procedure Input+Output Parameter 정의
		 * =================================================================
		 * LEA_BAT_START_PRC(exe_yrmon_in IN VARCHAR2, msg_out OUT VARCHAR2)
		 * -----------------------------------------------------------------
		 * OUT Arguments : Variable Name - msg_out, Data Type - Varchar2 
		 * LEA00001 :: msg_out := 'Batch is already running.' 	Desc : '배치 작업이 이미 수행중입니다.'
		 * LEA00002 :: msg_out := 'Batch started.'				Desc : '작업이 시작되었습니다.'  
		 * =================================================================
		 * */		
		
		try {
			returnMsg = dbDao.executeAccrualBatch(frmExeYrmon);
			
//			if(sErrorMsgBatchStarted.equals(returnMsg)){
//				log.error("err " + sErrorMsgBatchStarted);
//				throw new DAOException(new ErrorHandler("LEA00002").getMessage());
//			}else if(sErrorMsgBatchRunning.equals(returnMsg)){
//				log.error("err " + sErrorMsgBatchRunning);
//				throw new DAOException(new ErrorHandler("LEA00001").getMessage());
//			}
			
			
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