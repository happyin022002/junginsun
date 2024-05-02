/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeCalculationReportBC.java
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
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DeleteReasonListVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.DeleteInquiryByOfficeDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.DeleteInquiryByOfficeVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.DeleteInquiryParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.SummaryReportByCustomerDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.SummaryReportByCustomerParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.SummaryReportByCustomerVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.UsLfdEdiAudidtListVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.UsLfdEdiAudidtParmVO;

/**
 * ALPS-Dmtperformanceanalysis Business Logic Command Interface<br>
 * - ALPS-Dmtperformanceanalysis에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Hwang HyoKeun
 * @see SummaryReportByCustomerDetailVO 참조
 * @since J2EE 1.6
 */

public interface ChargeCalculationReportBC {

	/**
	 * Delete된 Charge의 Summary정보를 조회한다.<br>
	 * 
	 * @param DeleteInquiryParmVO	deleteInquiryParmVO
	 * @return List<DeleteInquiryByOfficeVO>
	 * @exception EventException
	 */
	public List<DeleteInquiryByOfficeVO> searchDeletedChargeListByOffice(DeleteInquiryParmVO deleteInquiryParmVO) throws EventException;
	
	
	/**
	 * Delete Inquiry by Office의 상세내역을 조회한다.<br>
	 * 
	 * @param DeleteInquiryParmVO	deleteInquiryParmVO
	 * @return List<DeleteInquiryByOfficeDetailVO>
	 * @exception EventException
	 */
	public List<DeleteInquiryByOfficeDetailVO> searchDeletedChargeDetailListByOffice(DeleteInquiryParmVO deleteInquiryParmVO) throws EventException;
	
	
	/**
	 * Customer별 발생 Charge정보의 Summary조회한다.<br>
	 * 
	 * @param SummaryReportByCustomerParmVO summaryReportByCustomerParmVO
	 * @return List<SummaryReportByCustomerVO>
	 * @exception EventException
	 */
	public List<SummaryReportByCustomerVO> searchSummaryReportByCustomer(SummaryReportByCustomerParmVO summaryReportByCustomerParmVO) throws EventException;


	/**
	 * Customer별 발생 Charge의 Detail 정보를 조회한다.<br>
	 * 
	 * @param SummaryReportByCustomerParmVO summaryReportByCustomerParmVO
	 * @return List<SummaryReportByCustomerDetailVO>
	 * @exception EventException
	 */
	public List<SummaryReportByCustomerDetailVO> searchSummaryReportDetailByCustomer(SummaryReportByCustomerParmVO summaryReportByCustomerParmVO) throws EventException;


	/**
	 * US LFD EDI Audidt 정보를 조회한다.<br>
	 * 
	 * @param UsLfdEdiAudidtParmVO usLfdEdiAudidtParmVO
	 * @return List<UsLfdEdiAudidtListVO>
	 * @exception EventException
	 */
	public List<UsLfdEdiAudidtListVO> searchUsLfdEdiAudidtList(UsLfdEdiAudidtParmVO usLfdEdiAudidtParmVO)  throws EventException;


	/**
	 * Charge Delete시 Delete Reason Data들의 List를 조회하고,
	 * 공통코드 테이블에서 Delete Reason Code와 Description을 조회한다.<br>
	 * 
	 * @return List<DeleteReasonListVO>
	 * @exception EventException
	 */
	public List<DeleteReasonListVO> searchDeleteReasonList() throws EventException;

	/**
	 * Charge Delete시 Delete Reason Data들의 List를 조회하고,
	 * 공통코드 테이블에서 Delete Reason Code와 Description을 조회한다.<br>
	 * 
	 * @param String delCd
	 * @return List<DeleteReasonListVO>
	 * @exception EventException
	 */
	public List<DeleteReasonListVO> searchDeleteSpecificReasonList(String delCd) throws EventException;

}