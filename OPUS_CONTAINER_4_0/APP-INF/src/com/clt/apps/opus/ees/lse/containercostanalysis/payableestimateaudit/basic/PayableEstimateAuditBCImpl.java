/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PayableEstimateAuditBCImpl.java
*@FileTitle : Estimate expense
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.lse.containercostanalysis.payableestimateaudit.basic;

import java.util.List;

import com.clt.apps.opus.ees.lse.containercostanalysis.payableestimateaudit.integration.PayableEstimateAuditDBDAO;
import com.clt.apps.opus.ees.lse.containercostanalysis.payableestimateaudit.vo.EstimatedAuditVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ContainerCostAnalysis Business Logic Command Interface<br>
 *
 * @author
 * @see EES_LSE_0018EventResponse,PayableEstimateAuditBC 
 * @since J2EE 1.6
 */
public class PayableEstimateAuditBCImpl extends BasicCommandSupport implements PayableEstimateAuditBC {

	// Database Access Object
	private transient PayableEstimateAuditDBDAO dbDao = null;

	/**
	 * creating PayableEstimateAuditBCImpl object<br>
	 * creating PayableEstimateAuditDBDAO<br>
	 */
	public PayableEstimateAuditBCImpl() {
		dbDao = new PayableEstimateAuditDBDAO();
	}
	
	/**
	 * retrieving for payable estimate audit<br>
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
	 * calculation payalbe estivate audit<br>
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
	 * saving payable estimate audit<br>
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
			        	if(!"".equals(estimatedAuditVOs[i].getActualMonth())) {
			        		dbDao.addPayableEstimateAuditData(estimatedAuditVOs[i] ,  account);
			        	}
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
	
}