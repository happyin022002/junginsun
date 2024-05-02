/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeCalculationReportBC.java
*@FileTitle : Deleted Charge Report by Office
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.basic;

import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.DeleteInquiryByOfficeDetailVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.DeleteInquiryByOfficeVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.DeleteInquiryParmVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.SummaryReportByCustomerDetailVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.SummaryReportByCustomerParmVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.SummaryReportByCustomerVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * Dmtperformanceanalysis Business Logic Command Interface<br>
 * 
 * @author
 * @see SummaryReportByCustomerDetailVO reference
 * @since J2EE 1.6
 */

public interface ChargeCalculationReportBC {

	/**
	 * Search Summaryinformation of Deleted Charge.<br>
	 * 
	 * @param DeleteInquiryParmVO	deleteInquiryParmVO
	 * @return List<DeleteInquiryByOfficeVO>
	 * @exception EventException
	 */
	public List<DeleteInquiryByOfficeVO> searchDeletedChargeListByOffice(DeleteInquiryParmVO deleteInquiryParmVO) throws EventException;
	
	
	/**
	 * Search detail information of Delete Inquiry by Office.<br>
	 * 
	 * @param DeleteInquiryParmVO	deleteInquiryParmVO
	 * @return List<DeleteInquiryByOfficeDetailVO>
	 * @exception EventException
	 */
	public List<DeleteInquiryByOfficeDetailVO> searchDeletedChargeDetailListByOffice(DeleteInquiryParmVO deleteInquiryParmVO) throws EventException;
	
	
	/**
	 * Search Summary of Chargeinformation by Customer.<br>
	 * 
	 * @param SummaryReportByCustomerParmVO summaryReportByCustomerParmVO
	 * @return List<SummaryReportByCustomerVO>
	 * @exception EventException
	 */
	public List<SummaryReportByCustomerVO> searchSummaryReportByCustomer(SummaryReportByCustomerParmVO summaryReportByCustomerParmVO) throws EventException;


	/**
	 * Search Detail information by Customer.<br>
	 * 
	 * @param SummaryReportByCustomerParmVO summaryReportByCustomerParmVO
	 * @return List<SummaryReportByCustomerDetailVO>
	 * @exception EventException
	 */
	public List<SummaryReportByCustomerDetailVO> searchSummaryReportDetailByCustomer(SummaryReportByCustomerParmVO summaryReportByCustomerParmVO) throws EventException;

}
