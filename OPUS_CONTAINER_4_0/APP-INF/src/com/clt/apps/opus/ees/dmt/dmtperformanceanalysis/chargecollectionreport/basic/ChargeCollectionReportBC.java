/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeCollectionReportBC.java
*@FileTitle : Current Collection Status by Office
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.basic;

import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.CollectionDetailReportByOfficeVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.CollectionReportParmVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.CollectionSummaryReportByOfficeVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.MonthlyCollectionByOfficeVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * Dmtperformanceanalysis Business Logic Command Interface<br>
 * 
 * @author
 * @see ChargeCollectionReportBCImpl Class reference
 * @since J2EE 1.6
 */

public interface ChargeCollectionReportBC {

	/**
	 *  Search detail list Collection Status Report by Office.
	 * 
	 * @param CollectionReportParmVO	collectionReportParmVO
	 * @return List<CollectionSummaryReportByOfficeVO>
	 * @exception EventException
	 */
	public List<CollectionSummaryReportByOfficeVO> searchCollectionSummaryReportByOffice(CollectionReportParmVO collectionReportParmVO) 
			throws EventException;


	/**
	 *  Search Charge Detail information that created Charge in duration and until currebt date.<br>
	 * 
	 * @param CollectionReportParmVO	collectionReportParmVO
	 * @return List<CollectionDetailReportByOfficeVO>
	 * @exception EventException
	 */
	public List<CollectionDetailReportByOfficeVO> searchCollectionDetailReportByOffice(CollectionReportParmVO collectionReportParmVO) 
			throws EventException;
	
	
	/**
	 * Search Billable/Invoiced/Collection amount information by month.<br>
	 * 
	 * @param CollectionReportParmVO collectionReportParmVO
	 * @return List<MonthlyCollectionByOfficeVO>
	 * @exception EventException
	 */
	public List<MonthlyCollectionByOfficeVO> searchMonthlyCollectionByOffice(CollectionReportParmVO collectionReportParmVO) 
			throws EventException;

}
