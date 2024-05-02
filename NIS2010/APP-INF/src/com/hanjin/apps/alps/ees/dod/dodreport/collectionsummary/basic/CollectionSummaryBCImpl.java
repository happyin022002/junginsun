/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CollectionSummaryBCImpl.java
*@FileTitle : DOD Collection Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2016-05-11
*@LastModifier : Hong Seong Pil
*@LastVersion : 1.0
* 2016-05-11 Hong Seong Pil
* 1.0 최초 생성
*  
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.basic;

import java.sql.SQLException;
import java.util.List;

import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.integration.CollectionSummaryDBDAO;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.vo.CollectionSummaryByCustomerDetailVO;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.vo.CollectionSummaryByCustomerVO;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.vo.OfficeSubVO;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.vo.SumbyOfcDetailVO;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.vo.SumbyOfcVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.rowset.DBRowSet;
/**
 * CollectionSummary Business Logic Basic Command implementation<br>
 * - CollectionSummary에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Son, Jin-Hwan
 * @since J2EE 1.6 
 */
public class CollectionSummaryBCImpl extends BasicCommandSupport implements CollectionSummaryBC {
	// Database Access Object
	private transient CollectionSummaryDBDAO dbDao = null;
	
	public CollectionSummaryBCImpl(){
		dbDao = new CollectionSummaryDBDAO();
	}
	
	/**
	 * DOD Collection Summary by Customer list
	 * 
	 * @category EES_DOD_0016
	 * @param CollectionSummaryByCustomerVO collectionSummaryINVO
	 * @return List<CollectionSummaryByCustomerVO>
	 * @throws EventException
	 */
	public List<CollectionSummaryByCustomerVO> searchCollectionSummaryByCustomer(CollectionSummaryByCustomerVO collectionSummaryINVO) throws EventException{
		try {
			return dbDao.searchCollectionSummaryByCustomer(collectionSummaryINVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * DOD Collection Summary by Customer Detail list
	 * 
	 * @category EES_DOD_0017
	 * @param CollectionSummaryByCustomerDetailVO collectionSummaryDetailINVO
	 * @return String
	 * @throws EventException
	 */
	public String searchCollectionSummaryByCustomerDetailList(CollectionSummaryByCustomerDetailVO collectionSummaryDetailINVO, SignOnUserAccount account) throws EventException{
		try{
			CollectionSummaryBackEndJob backEndJob = new CollectionSummaryBackEndJob();
			backEndJob.setJobType("DOD_COLLECTION_SUMMARY_DETAIL_LIST");
			backEndJob.setCollectionSummaryByCustomerDetailVO(collectionSummaryDetailINVO);
			
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "DOD_COLLECTION_SUMMARY_DETAIL_LIST");
		} catch(Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * DOD Collection Summary by Office - Combobox RHQ Office List
	 * 
	 * @category EES_DOD_0009
	 * @param 
	 * @return List<String>
	 * @throws EventException
	 */

	public List<String> searchRHQOfcList() throws EventException 
	{
		try {
			return dbDao.searchRHQOfcList();
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	
	/**
	 * DOD Collection Summary by Office - Combobox Office List
	 * 
	 * @category EES_DOD_0009
	 * @param 
	 * @return List<String>
	 * @throws EventException
	 */
	
	public List<String> searchOfcList() throws EventException 
	{
		try {
			return dbDao.searchOfcList();
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}	
	
	
	 /**
	 * DOD Collection Summary by Office - Combobox Sub Office List
	 * 
	 * @category EES_DOD_0009
	 * @param 
	 * @return List<String>
	 * @throws EventException
	 */
	public List<String> searchSubOfcList(OfficeSubVO officeSubVO) throws EventException 
	{
		try {
			return dbDao.searchSubOfcList(officeSubVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}	
	
	
	/**
	 * DOD Collection Summary by Office
	 * 
	 * @category EES_DOD_0009
	 * @param sumbyOfcVO SumbyOfcVO
	 * @return List<SumbyOfcVO>
	 * @throws EventException
	 */	
	public List<SumbyOfcVO> searchSumbyOfc(SumbyOfcVO sumbyOfcVO) throws EventException {
		try {
			List<SumbyOfcVO> list = dbDao.searchSumbyOfc(sumbyOfcVO);
			return list;
			
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	
 	/**
 * DOD Collection Summary by Office Detail
 * 
 * @category EES_DOD_0010
 * @param sumbyOfcDetailVO SumbyOfcDetailVO
 * @return List<SumbyOfcDetailVO>
 * @throws EventException
 */	
	public List<SumbyOfcDetailVO> searchSumbyOfcDetail(SumbyOfcDetailVO sumbyOfcDetailVO) throws EventException {
		try {
			List<SumbyOfcDetailVO> list = dbDao.searchSumbyOfcDetail(sumbyOfcDetailVO);
			return list;
			
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
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
		} catch(BackEndJobException e) {
			throw new EventException(e.getMessage());
		} catch(SQLException e) {
			throw new EventException(e.getMessage());
		} catch(InterruptedException e) {
			throw new EventException(e.getMessage());
		} catch(Exception e) {
			throw new EventException(e.getMessage());
		}
	}

}
