/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisReportBCImpl.java
*@FileTitle : Chassis Report
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.16
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2014.04.16 최덕우
* 1.0 Creation 
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassisreport.chassisreportinventory.basic;

import java.sql.SQLException;
import java.util.List;

import com.hanjin.apps.alps.ees.cgm.chassisreport.chassisreportinventory.integration.ChassisReportDBDAO;
import com.hanjin.apps.alps.ees.cgm.chassisreport.chassisreportinventory.vo.LandInvMonitoringVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-ChassisMgsetAgreementInvoice Business Logic Basic Command implementation<br>
 * - NIS2010-ChassisMgsetAgreementInvoice에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Choi, Duk Woo
 * @see ees_cgm_1157EventResponse,ChassisReportBC 각 DAO 클래스 참조
 * @since J2EE 1.4 
 */

public class ChassisReportBCImpl extends BasicCommandSupport implements ChassisReportBC {

	// Database Access Object
	private transient ChassisReportDBDAO dbDao = null;

	/**
	 * ChassisReportBCImpl 객체 생성<br>
	 * ChassisReportDBDAO를 생성한다.<br>
	 */
	public ChassisReportBCImpl() {
		dbDao = new ChassisReportDBDAO();
	}

	/**
	 * [EES_CGM_1157] Summary Tab Back End Job 시작<br>
	 *
	 * @param LandInvMonitoringVO landInvMonitoringVO
	 * @param SignOnUserAccount account
	 * @return String
	 */
	public String startBackEndJobSearchLandInvMonitoringSummary(LandInvMonitoringVO landInvMonitoringVO, SignOnUserAccount account) {
		ChassisReportLandInvMonitoringBackEndJob chassisReportLandInvMonitoringBackEndJob = new ChassisReportLandInvMonitoringBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		
		chassisReportLandInvMonitoringBackEndJob.setLandInvMonitoringVO(landInvMonitoringVO);
		return backEndJobManager.execute(chassisReportLandInvMonitoringBackEndJob, account.getUsr_id(), "EES_CGM_1157 Back End");
	}
	
	/**
	 * [EES_CGM_1157] Detail Tab Back End Job 시작<br>
	 *
	 * @param LandInvMonitoringVO landInvMonitoringVO
	 * @param SignOnUserAccount account
	 * @return String
	 */
	public String startBackEndJobSearchLandInvMonitoringDetail(LandInvMonitoringVO landInvMonitoringVO, SignOnUserAccount account) {
		ChassisReportLandInvMonitoringDetailBackEndJob chassisReportLandInvMonitoringDetailBackEndJob = new ChassisReportLandInvMonitoringDetailBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		
		chassisReportLandInvMonitoringDetailBackEndJob.setLandInvMonitoringVO(landInvMonitoringVO);
		return backEndJobManager.execute(chassisReportLandInvMonitoringDetailBackEndJob, account.getUsr_id(), "EES_CGM_1157 Back End");
	}
	
	/**
	 * BackEndJob공통 - Back End Job Status 조회<br>
	 *  (동일 BCImpl에 Back End Job이 여러개일때 공통으로 사용)
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String getBackEndJobStatus(String backEndJobKey) throws EventException {
		try {
			DBRowSet rowSet = new BackEndJobMetaDataSelector(backEndJobKey).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (BackEndJobException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (SQLException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (InterruptedException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1157] Back End Job 처리결과 return<br>
	 *   (Land Inventory Monitoring 목록을 조회)
	 *
	 * @param String backEndJobKey
	 * @return List<LandInvMonitoringVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<LandInvMonitoringVO> resultBackEndJobSearchLandInvMonitoring(String backEndJobKey) throws EventException {
		try {
			return (List<LandInvMonitoringVO>)BackEndJobResult.loadFromFile(backEndJobKey);
		} catch (BackEndJobException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
	    } catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [EES_CGM_1157]<br>
	 * TP/SZ List의 정보를 조회<br>
	 *
	 * @return List<LandInvMonitoringVO>
	 * @exception EventException
	 */
	public List<LandInvMonitoringVO> searchTpszList() throws EventException {
		try {
			return dbDao.searchTpszList();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
}