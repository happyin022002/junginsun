/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PayableEstimateAuditBCImpl.java
*@FileTitle : Estimate expense
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.10.06 진준성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containercostanalysis.payableestimateaudit.basic;

import java.util.List;
import java.sql.SQLException;

import com.hanjin.apps.alps.ees.lse.containercostanalysis.payableestimateaudit.integration.PayableEstimateAuditDBDAO;
import com.hanjin.apps.alps.ees.lse.containercostanalysis.payableestimateaudit.vo.EstimatedAuditVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;

/**
 * ALPS-ContainerCostAnalysis Business Logic Command Interface<br>
 * - ALPS-ContainerCostAnalysis에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jin Jun Sung 
 * @see EES_LSE_0018EventResponse,PayableEstimateAuditBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class PayableEstimateAuditBCImpl extends BasicCommandSupport implements PayableEstimateAuditBC {

	// Database Access Object
	private transient PayableEstimateAuditDBDAO dbDao = null;

	/**
	 * PayableEstimateAuditBCImpl 객체 생성<br>
	 * PayableEstimateAuditDBDAO를 생성한다.<br>
	 */
	public PayableEstimateAuditBCImpl() {
		dbDao = new PayableEstimateAuditDBDAO();
	}
	
	/**
	 * 임차료에 대한 추정 실적 조회 합니다.<br>
	 * 
	 * @param EstimatedAuditVO estimatedAuditVO
	 * @return List<EstimatedAuditVO>
	 * @exception EventException
	 */
	public List<EstimatedAuditVO> searchPayableEstimateAuditBasic( EstimatedAuditVO estimatedAuditVO ) throws EventException {
		try {
			return dbDao.searchPayableEstimateAuditData ( estimatedAuditVO );
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"verifyImportOnOffHireList Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"verifyImportOnOffHireList Search"}).getMessage(),ex);
		}
	}
	/**
	 * 임차료에 대한 추정 실적 계산 합니다.<br>
	 * 
	 * @param EstimatedAuditVO estimatedAuditVO
	 * @return List<EstimatedAuditVO>
	 * @exception EventException
	 */
	public List<EstimatedAuditVO> calculationPayableEstimateAuditBasic( EstimatedAuditVO estimatedAuditVO ) throws EventException {
		try {
			return dbDao.calculationPayableEstimateAuditData ( estimatedAuditVO );
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"verifyImportOnOffHireList Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"verifyImportOnOffHireList Search"}).getMessage(),ex);
		}
	}
	
	/**
	 * 임차료에 대한 추정 실적 계산 합니다.<br>
	 * 
	 * @param EstimatedAuditVO[] estimatedAuditVOs
	 * @param String yearMonth
	 * @param SignOnUserAccount	account
	 * @exception EventException
	 */
	public void savePayableEstimateAuditBasic( EstimatedAuditVO[] estimatedAuditVOs , String yearMonth , SignOnUserAccount account) throws EventException {
		try {
			if(estimatedAuditVOs != null){
				
				if(estimatedAuditVOs.length > 0){
				    
					/*String strActualMonth = estimatedAuditVOs[0].getActualMonth();
				    if(strActualMonth != null){
					    strActualMonth = strActualMonth.replaceAll("-", "");
			        }
				    dbDao.removePayableEstimateAuditData(strActualMonth);*/
			        dbDao.removePayableEstimateAuditData(yearMonth);
			        for(int i = 0 ; i < estimatedAuditVOs.length ; i++){
                        dbDao.addPayableEstimateAuditData(estimatedAuditVOs[i] ,  account);
			        }
				}
			}
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease ImportOnOffHireListBasic Create"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease ImportOnOffHireListBasic Create"}).getMessage(),ex);
		}
	}

	/**
	 * 임차료에 대한 추정 실적 계산 합니다 backend job.<br>
	 *
	 * @param  EstimatedAuditVO estimatedAuditVO
	 * @param  SignOnUserAccount userAccount
	 * @return String
	 * @throws EventException
	 */
	public String backEndCalculationPayableEstimateAuditBasic(EstimatedAuditVO estimatedAuditVO, SignOnUserAccount userAccount) throws EventException {
		PayableEstimateAuditBackEndJob backEndJob = new PayableEstimateAuditBackEndJob();
		backEndJob.setJobType("SearchPayableEstimateAuditService");
		backEndJob.setEstimatedAuditVO(estimatedAuditVO);
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			return backEndJobManager.execute(backEndJob, userAccount.getUsr_id(), "SearchPayableEstimateAuditBasic BackEndJob");
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"SearchPayableEstimateAuditBasic BackEndJob"}).getMessage(),ex);
		}
	}	
	
	/**
	 * BackEndJob의 실행결과에 대한 상태값을 조회합니다.<br>
	 *
	 * @param String key
	 * @return String 
	 * @exception EventException
	 */
	public String searchComBackEndJobStatusBasic(String key) throws EventException {
		DBRowSet rowSet;

		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (BackEndJobException e) {
			throw new EventException(e.getMessage());
		} catch (SQLException e) {
			throw new EventException(e.getMessage());
		} catch (InterruptedException e) {
			throw new EventException(e.getMessage());
		} catch(Exception e){
			throw new EventException(e.getMessage());
		}
	}

}