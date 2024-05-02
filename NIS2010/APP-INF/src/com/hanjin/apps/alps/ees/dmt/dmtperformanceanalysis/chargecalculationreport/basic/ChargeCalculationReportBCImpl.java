/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeCalculationReportBCImpl.java
*@FileTitle : Deleted Charge Report by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.15 황효근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DeleteReasonListVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.integration.ChargeCalculationReportDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.DeleteInquiryByOfficeDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.DeleteInquiryByOfficeVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.DeleteInquiryParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.SummaryReportByCustomerDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.SummaryReportByCustomerParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.SummaryReportByCustomerVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.UsLfdEdiAudidtListVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.UsLfdEdiAudidtParmVO;

/**
 * ALPS-DMTPerformanceAnalysis Business Logic Command Interface<br>
 * - ALPS-DMTPerformanceAnalysis에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Hwang HyoKeun
 * @see ChargeCalculationReportDBDAO Class 참조
 * @since J2EE 1.6
 */
public class ChargeCalculationReportBCImpl extends BasicCommandSupport implements ChargeCalculationReportBC {

	// Database Access Object
	private transient ChargeCalculationReportDBDAO dbDao = null;

	/**
	 * ChargeCalculationReportBCImpl 객체 생성<br>
	 * ChargeCalculationReportDBDAO를 생성한다.<br>
	 */
	public ChargeCalculationReportBCImpl() {
		dbDao = new ChargeCalculationReportDBDAO();
	}
	
	
	/**
	 * Delete된 Charge의 Summary정보를 조회한다.<br>
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
	 * Delete Inquiry by Office의 상세내역을 조회한다.<br>
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
	 * Customer별 발생 Charge정보의 Summary조회한다.<br>
	 * 
	 * @param SummaryReportByCustomerParmVO summaryReportByCustomerParmVO
	 * @return List<SummaryReportByCustomerVO>
	 * @exception EventException
	 */
	public List<SummaryReportByCustomerVO> searchSummaryReportByCustomer(SummaryReportByCustomerParmVO summaryReportByCustomerParmVO) throws EventException {
		try {
			
			if (("BKG").equals(summaryReportByCustomerParmVO.getCustFlg()) && summaryReportByCustomerParmVO.getCustType() != null ){
				return dbDao.searchSummaryReportByCustomerBkg(summaryReportByCustomerParmVO);
			} else {
				return dbDao.searchSummaryReportByCustomer(summaryReportByCustomerParmVO);
			}
//			return dbDao.searchSummaryReportByCustomer(summaryReportByCustomerParmVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	
	/**
	 * Customer별 발생 Charge의 Detail 정보를 조회한다.<br>
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
	
	/**
	 * US LFD EDI Audidt 정보를 조회한다.<br>
	 * 
	 * @param UsLfdEdiAudidtParmVO usLfdEdiAudidtParmVO
	 * @return List<UsLfdEdiAudidtListVO>
	 * @exception EventException
	 */
	public List<UsLfdEdiAudidtListVO> searchUsLfdEdiAudidtList(UsLfdEdiAudidtParmVO usLfdEdiAudidtParmVO) throws EventException {
		try {
			return dbDao.searchUsLfdEdiAudidtList(usLfdEdiAudidtParmVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * Charge Delete시 Delete Reason Data들의 List를 조회한다<br>
	 * 공통코드 테이블에서 Delete Reason Code와 Description을 조회한다<br>
	 * 
	 * @return List<DeleteReasonListVO>
	 */
	public List<DeleteReasonListVO> searchDeleteReasonList() throws EventException {
		
		try {
			return dbDao.searchDeleteReasonList();
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Exemption Reason Entry"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Exemption Reason Entry"}).getMessage());
		}
	}
	

	/**
	 * Charge Delete시 Delete Reason Data들의 List를 조회한다<br>
	 * 공통코드 테이블에서 Delete Reason Code와 Description을 조회한다<br>
	 * 
	 * @param String delCd
	 * @return List<DeleteReasonListVO>
	 */
	public List<DeleteReasonListVO> searchDeleteSpecificReasonList(String delCd) throws EventException {
		
		try {
			return dbDao.searchDeleteSpecificReasonList(delCd);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Exemption Reason Entry"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Exemption Reason Entry"}).getMessage());
		}
	}
}