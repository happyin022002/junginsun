/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeCollectionReportBCImpl.java
*@FileTitle : Current Collection Status by Office
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.basic;

import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.integration.ChargeCollectionReportDBDAO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.CollectionDetailReportByOfficeVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.CollectionReportParmVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.CollectionSummaryReportByOfficeVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.MonthlyCollectionByOfficeVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * DMTPerformanceAnalysis Business Logic Command Interface<br>
 * 
 * @author
 * @see ChargeCollectionReportDBDAO Class reference
 * @since J2EE 1.6
 */
public class ChargeCollectionReportBCImpl extends BasicCommandSupport implements ChargeCollectionReportBC {

	// Database Access Object
	private transient ChargeCollectionReportDBDAO dbDao = null;

	/**
	 * ChargeCollectionReportBCImpl Create object<br>
	 * ChargeCollectionReportDBDAO Create.<br>
	 */
	public ChargeCollectionReportBCImpl() {
		dbDao = new ChargeCollectionReportDBDAO();
	}
	
	/**
	 *  Search detail list Collection Status Report by Office.
	 * 
	 * @param CollectionReportParmVO collectionReportParmVO
	 * @return List<CollectionSummaryReportByOfficeVO>
	 * @exception EventException
	 */
	public List<CollectionSummaryReportByOfficeVO> searchCollectionSummaryReportByOffice(CollectionReportParmVO collectionReportParmVO) throws EventException {
		try {
			return dbDao.searchCollectionSummaryReportByOffice(collectionReportParmVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	
	/**
	 *  Search Charge Detail information that created Charge in duration and until currebt date.<br>
	 * 
	 * @param CollectionReportParmVO collectionReportParmVO
	 * @return List<CollectionDetailReportByOfficeVO>
	 * @exception EventException
	 */
	public List<CollectionDetailReportByOfficeVO> searchCollectionDetailReportByOffice(CollectionReportParmVO collectionReportParmVO) throws EventException {
		try {
			return dbDao.searchCollectionDetailReportByOffice(collectionReportParmVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	
	/**
	 *  Search Billable/Invoiced/Collection amount information by month.<br>
	 * 
	 * @param CollectionReportParmVO collectionReportParmVO
	 * @return List<MonthlyCollectionByOfficeVO>
	 * @exception EventException
	 */
	public List<MonthlyCollectionByOfficeVO> searchMonthlyCollectionByOffice(CollectionReportParmVO collectionReportParmVO) throws EventException {
		try {
			return dbDao.searchMonthlyCollectionByOffice(collectionReportParmVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
}
