/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AccrualEmailSettingBCImpl.java
*@FileTitle : Accrual Mail Setting
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.integration.AccrualEmailSettingDBDAO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.integration.AccrualEmailSettingEAIDAO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.vo.SearchAccrualEmailSettingVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.vo.SearchParameterAccrualEmailSettingVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.LeaEmlSetVO;

/**
 * ALPS-LogisticsExpenseAccrual Business Logic Basic Command implementation<br>
 * - Handling the business logic about ALPS-LogisticsExpenseAccrual<br>
 *
 * @author 
 * @see ESD_LEA_0009EventResponse,AccrualEmailSettingBC
 * @since J2EE 1.6
 */
public class AccrualEmailSettingBCImpl extends BasicCommandSupport implements AccrualEmailSettingBC {

	// Database Access Object
	private transient AccrualEmailSettingDBDAO dbDao = null;
	private transient AccrualEmailSettingEAIDAO eaiDao = null;
	/**
	 * Creating AccrualEmailSettingBCImpl class<br>
	 * Create AccrualEmailSettingDBDAO class<br>
	 */
	public AccrualEmailSettingBCImpl() {
		dbDao = new AccrualEmailSettingDBDAO();
		eaiDao = new AccrualEmailSettingEAIDAO();
	}
	
	/**
	 * Sending the result of the batch or ERP I/F to the list of the receivers by email.<br>
	 * @param SearchParameterAccrualEmailSettingVO searchParameterAccrualEmailSettingVO
	 * @exception EventException
	 */
	public void sendTestAccrualEmailSetting(SearchParameterAccrualEmailSettingVO searchParameterAccrualEmailSettingVO) throws EventException {
		try {
			dbDao.sendTestAccrualEmailSetting(searchParameterAccrualEmailSettingVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Inquiring the parameter settings for sending email<br>
	 * @param SearchParameterAccrualEmailSettingVO searchParameterAccrualEmailSettingVO
	 * @return List<SearchParameterAccrualEmailSettingVO>
	 * @exception EventException
	 */
	public List<SearchParameterAccrualEmailSettingVO> searchParameterAccrualEmailSetting(SearchParameterAccrualEmailSettingVO searchParameterAccrualEmailSettingVO) throws EventException {
		try {
			return dbDao.searchParameterAccrualEmailSetting(searchParameterAccrualEmailSettingVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Inquiring the setting items for sending email<br>
	 * 					 
	 * @param SearchAccrualEmailSettingVO searchAccrualEmailSettingVO
	 * @return List<SearchAccrualEmailSettingVO>
	 * @exception EventException
	 */
	public List<SearchAccrualEmailSettingVO> searchAccrualEmailSetting(SearchAccrualEmailSettingVO searchAccrualEmailSettingVO) throws EventException {
		try {
			return dbDao.searchAccrualEmailSetting(searchAccrualEmailSettingVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Modifying the setting items for sending email.<br>
	 * @param LeaEmlSetVO[] leaEmlSetVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyAccrualEmailSetting(LeaEmlSetVO[] leaEmlSetVOs, SignOnUserAccount account) throws EventException{
		try {
			List<LeaEmlSetVO> updateVoList = new ArrayList<LeaEmlSetVO>();

			for ( int i=0; i<leaEmlSetVOs.length; i++ ) {
				leaEmlSetVOs[i].setUpdUsrId(account.getUsr_id());
				updateVoList.add(leaEmlSetVOs[i]);
			}
			
			dbDao.modifyModifyAccrualEmailSettingS(updateVoList);

		} catch (DAOException ex) {			
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {		
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * Sending email.<br>
	 * 
	 * @param String str_fm_eml
	 * @param String[] to_eml
	 * @param String subject_nm
	 * @param String contents
	 * @exception EventException
	 */
	public void sendEml(String str_fm_eml, String[] to_eml, String subject_nm, String contents) throws EventException {
				
		try {			
			eaiDao.sendEml(str_fm_eml, to_eml, subject_nm, contents);	
		} catch (Exception de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}	
	}
}