/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AccrualEmailSettingBCImpl.java
*@FileTitle : Accrual Mail Setting
*Open Issues :
*Change history :2007.01 Park Yeon Jin 최초생성
*@LastModifyDate : 2009.09.18
*@LastModifier : Jeon Jae Hong
*@LastVersion : 1.0
* 2009.09.18 Jeon Jae Hong
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualemailsetting.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualemailsetting.integration.AccrualEmailSettingDBDAO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualemailsetting.integration.AccrualEmailSettingEAIDAO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualemailsetting.vo.SearchAccrualEmailSettingVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualemailsetting.vo.SearchParameterAccrualEmailSettingVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.LeaEmlSetVO;

/**
 * ALPS-LogisticsExpenseAccrual Business Logic Basic Command implementation<br>
 * - ALPS-LogisticsExpenseAccrual에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jeon Jae Hong
 * @see ESD_LEA_0009EventResponse,AccrualEmailSettingBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class AccrualEmailSettingBCImpl extends BasicCommandSupport implements AccrualEmailSettingBC {

	// Database Access Object
	private transient AccrualEmailSettingDBDAO dbDao = null;
	private transient AccrualEmailSettingEAIDAO eaiDao = null;
	/**
	 * AccrualEmailSettingBCImpl 객체 생성<br>
	 * AccrualEmailSettingDBDAO를 생성한다.<br>
	 */
	public AccrualEmailSettingBCImpl() {
		dbDao = new AccrualEmailSettingDBDAO();
		eaiDao = new AccrualEmailSettingEAIDAO();
	}
	
	/**
	 * Batch 또는 ERP I/F 결과를 수신자 목록의 Email로 송신한다.<br>
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
	 * Email 송신을 위한  Parameter Setting 항목 조회<br>
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
	 * Email 송신을 위한  Setting 항목조회<br>
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
	 * Email 송신을 위한 Setting 항목 변경<br>
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
	 * Email 송신<br>
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