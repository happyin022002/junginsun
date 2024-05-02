/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeCalculationReportBCImpl.java
*@FileTitle : Deleted Charge Report by Office
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.basic;

import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.integration.ChargeCalculationReportDBDAO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.DeleteInquiryByOfficeDetailVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.DeleteInquiryByOfficeVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.DeleteInquiryParmVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.SummaryReportByCustomerDetailVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.SummaryReportByCustomerParmVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.SummaryReportByCustomerVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * DMTPerformanceAnalysis Business Logic Command Interface<br>
 * 
 * @author
 * @see ChargeCalculationReportDBDAO Class reference
 * @since J2EE 1.6
 */
public class ChargeCalculationReportBCImpl extends BasicCommandSupport implements ChargeCalculationReportBC {

	// Database Access Object
	private transient ChargeCalculationReportDBDAO dbDao = null;

	/**
	 * ChargeCalculationReportBCImpl Create object<br>
	 * ChargeCalculationReportDBDAO Create.<br>
	 */
	public ChargeCalculationReportBCImpl() {
		dbDao = new ChargeCalculationReportDBDAO();
	}
	
	
	/**
	 * Search Summaryinformation of Deleted Charge.<br>
	 * 
	 * @param DeleteInquiryParmVO deleteInquiryParmVO
	 * @return List<DeleteInquiryParmVO>
	 * @exception EventException
	 */
	public List<DeleteInquiryByOfficeVO> searchDeletedChargeListByOffice(DeleteInquiryParmVO deleteInquiryParmVO) throws EventException {
		try {
			return dbDao.searchDeletedChargeListByOffice(deleteInquiryParmVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	
	/**
	 *  Search detail information of Delete Inquiry by Office.<br>
	 * 
	 * @param DeleteInquiryParmVO deleteInquiryParmVO
	 * @return List<DeleteInquiryByOfficeDetailVO>
	 * @exception EventException
	 */
	public List<DeleteInquiryByOfficeDetailVO> searchDeletedChargeDetailListByOffice(DeleteInquiryParmVO deleteInquiryParmVO) throws EventException {
		try {
			return dbDao.searchDeletedChargeDetailListByOffice(deleteInquiryParmVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	
	/**
	 * Search Summary of Chargeinformation by Customer.<br>
	 * 
	 * @param SummaryReportByCustomerParmVO summaryReportByCustomerParmVO
	 * @return List<SummaryReportByCustomerVO>
	 * @exception EventException
	 */
	public List<SummaryReportByCustomerVO> searchSummaryReportByCustomer(SummaryReportByCustomerParmVO summaryReportByCustomerParmVO) throws EventException {
		try {
			return dbDao.searchSummaryReportByCustomer(summaryReportByCustomerParmVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	
	/**
	 * Search Detail information by Customer.<br>
	 * 
	 * @param SummaryReportByCustomerParmVO summaryReportByCustomerParmVO
	 * @return List<SummaryReportByCustomerDetailVO>
	 * @exception EventException
	 */
	public List<SummaryReportByCustomerDetailVO> searchSummaryReportDetailByCustomer(SummaryReportByCustomerParmVO summaryReportByCustomerParmVO) throws EventException {
		try {
			return dbDao.searchSummaryReportDetailByCustomer(summaryReportByCustomerParmVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
}
