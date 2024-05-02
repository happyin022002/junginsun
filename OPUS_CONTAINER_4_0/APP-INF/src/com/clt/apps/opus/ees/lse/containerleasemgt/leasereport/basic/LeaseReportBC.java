/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ILeaseReportBC.java
*@FileTitle : On Hire Result by Location / AGMT No(Contract No.)-Option
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.basic;

import java.util.List;

import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo.InventoryDetailVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo.InventorySummaryVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo.ReportSearchVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo.SearchParamVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo.SubLeaseOutDetailVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo.SubLeaseOutSummaryVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo.UsingDayDetailVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo.UsingDaySummaryVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Containerleasemgt Business Logic Command Interface<br>
 * Containerleasemgt Biz Logic Interface<br>
 *
 * @author
 * @see Ees_lse_0036EventResponse 
 * @since J2EE 1.6
 */

public interface LeaseReportBC {

	/**
	 * Retrieving Hiring performance(ON Equipment)<br>
	 * 
	 * @param  ReportSearchVO reportSearchVO
	 * @return List<ReportSearchVO>
	 * @exception EventException
	 */
	public List<ReportSearchVO> searchOnHireResultbyLocationAgreementSummaryBasic(ReportSearchVO reportSearchVO) throws EventException;
	/**
	 *Retrieving Hiring performance(ON Equipment) in detail<br>
	 * 
	 * @param  ReportSearchVO reportSearchVO
	 * @return List<ReportSearchVO>
	 * @exception EventException
	 */
	public List<ReportSearchVO> searchOnHireResultbyLocationAgreementDetailBasic(ReportSearchVO reportSearchVO) throws EventException;
	/**
	 * Retrieving Hiring performance(Off Equipment).<br>
	 * 
	 * @param  ReportSearchVO reportSearchVO
	 * @return List<ReportSearchVO>
	 * @exception EventException
	 */
	public List<ReportSearchVO> searchOffHireResultbyLocationAgreementSummaryBasic(ReportSearchVO reportSearchVO) throws EventException;
	/**
	 *Retrieving Hiring performance(Off Equipment) in detail<br>
	 * 
	 * @param  ReportSearchVO reportSearchVO
	 * @param  SignOnUserAccount account
	 * @return List<ReportSearchVO>
	 * @exception EventException
	 */
	public List<ReportSearchVO> searchOffHireResultbyLocationAgreementDetailBasic(ReportSearchVO reportSearchVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieving avarage using performance list by Contract No. about returned hiring Equipment<br>
	 * 
	 * @param  SearchParamVO searchParamVO
	 * @return List<UsingDaySummaryVO>
	 * @throws EventException
	 */
	public List<UsingDaySummaryVO> searchOffHireResultAvgUsingDaySummaryListBasic(SearchParamVO searchParamVO) throws EventException;
	
	/**
	 * Retrieving Using performance by hiring Equipment in detail<br>
	 * 
	 * @param  SearchParamVO searchParamVO
	 * @param  SignOnUserAccount account
	 * @return List<UsingDayDetailVO>
	 * @throws EventException
	 */
	public List<UsingDayDetailVO> searchOffHireResultAvgUsingDayDetailBasic(SearchParamVO searchParamVO, SignOnUserAccount account) throws EventException;
	
	/**
	 *Retrieving Hiring performance Summary of hiring Equipment(On-Hire Result by Lease Term/Lessor-Option) <br>
	 * 
	 * @param  ReportSearchVO reportSearchVO
	 * @return List<ReportSearchVO>
	 * @exception EventException
	 */
	public List<ReportSearchVO> searchOnHireResultbyTermLessorSummaryBasic (ReportSearchVO reportSearchVO) throws EventException;
	

	/**
	 *Retrieving Hiring performance of hiring Equipment in detail(On-Hire Result by Lease Term/Lessor-Option) <br>
	 * 
	 * @param  ReportSearchVO reportSearchVO
	 * @return List<ReportSearchVO>
	 * @exception EventException
	 */
	public List<ReportSearchVO> searchOnHireResultbyTermLessorDetailBasic(ReportSearchVO reportSearchVO) throws EventException;
	
	
	/**
	 * Retrieving Hiring performance Summary of hiring Equipment(Off-Hire Result by Lease Term/Lessor-Option) <br>
	 * 
	 * @param  ReportSearchVO reportSearchVO
	 * @return List<ReportSearchVO>
	 * @exception EventException
	 */
	public List<ReportSearchVO> searchOffHireResultByTermLessorSummaryBasic (ReportSearchVO reportSearchVO) throws EventException;
	
	/**
	 * Retrieving Hiring performance of hiring Equipment in detail(Off-Hire Result by Lease Term/Lessor-Option) <br>
	 * 
	 * @param  ReportSearchVO reportSearchVO
	 * @param  SignOnUserAccount account
	 * @return List<ReportSearchVO>
	 * @exception EventException
	 */
	public List<ReportSearchVO>  searchOffHireResultByTermLessorDetailBasic(ReportSearchVO reportSearchVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieving Hiring performance Summary of hiring Equipment(Off-Hire Vs DOL) <br>
	 * 
	 * @param  ReportSearchVO reportSearchVO
	 * @return List<ReportSearchVO>
	 * @exception EventException
	 */
	public List<ReportSearchVO> searchOffHireResultvsDOLSummaryBasic(ReportSearchVO reportSearchVO) throws EventException;
			
	/**
	 * Retrieving Hiring performance of hiring Equipment in detail(Off-Hire Vs DOL) <br>
	 * 
	 * @param  ReportSearchVO reportSearchVO
	 * @param  SignOnUserAccount account
	 * @return List<ReportSearchVO>
	 * @exception EventException
	 */
	public List<ReportSearchVO>  searchOffHireResultvsDOLDetailBasic(ReportSearchVO reportSearchVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieving current state of own and hiring Equipment List managed by Shiipping Company<br>
	 * 
	 * @param  SearchParamVO searchParamVO
	 * @return List<InventorySummaryVO>
	 * @throws EventException
	 */
	public List<InventorySummaryVO> searchTotalContainerInventorySummaryListBasic(SearchParamVO searchParamVO) throws EventException;
	
	/**
	 * Retrieving Details of own and hiring Equipment managed by Shiipping Company<br>
	 * 
	 * @param  SearchParamVO searchParamVO
	 * @return List<InventoryDetailVO>
	 * @throws EventException
	 */
	public List<InventoryDetailVO> searchTotalContainerInventoryDetailBasic(SearchParamVO searchParamVO) throws EventException;
	
	/**
	 * Retriving new Equipment List <br>
	 * 
	 * @param  ReportSearchVO reportSearchVO
	 * @return List<ReportSearchVO>
	 * @throws EventException
	 */
	public List<ReportSearchVO> searchNewContainerReceivingDetailBasic(ReportSearchVO reportSearchVO) throws EventException;
	
	/**
	 * Retrieving current state of Sub Lease own Equipment and Miss Use hiring Equipment<br>
	 * 
	 * @param  SearchParamVO searchParamVO
	 * @param  SignOnUserAccount account
	 * @return List<SubLeaseOutSummaryVO>
	 * @throws EventException
	 */
	public List<SubLeaseOutSummaryVO> searchSubLeaseOutContainerSummaryListBasic(SearchParamVO searchParamVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieving Details of Sub Lease own Equipment and Miss Use hiring Equipment<br>
	 * 
	 * @param  SearchParamVO searchParamVO
	 * @param  SignOnUserAccount account
	 * @return List<SubLeaseOutDetailVO>
	 * @throws EventException
	 */
	public List<SubLeaseOutDetailVO> searchSubLeaseOutContainerDetailBasic(SearchParamVO searchParamVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieving Hireing performance by RCC<br>
	 * 
	 * @param  ReportSearchVO rportSearchVO
	 * @return List<ReportSearchVO>
	 * @throws EventException
	 */
	public List<ReportSearchVO> searchOnHireReportbyRccSummaryBasic(ReportSearchVO rportSearchVO) throws EventException;
	
	/**
	 * Retrieving Monthly Hiring performance<br>
	 * 
	 * @param  ReportSearchVO rportSearchVO
	 * @return List<ReportSearchVO>
	 * @throws EventException
	 */
	public List<ReportSearchVO> searchOnHireReportbyMonthSummaryBasic(ReportSearchVO rportSearchVO) throws EventException;
	
	/**
	 * Retrieving Return Performance by RCC<br>
	 * 
	 * @param  ReportSearchVO rportSearchVO
	 * @return List<ReportSearchVO>
	 * @throws EventException
	 */
	public List<ReportSearchVO> searchOffHireReportbyRccSummaryBasic(ReportSearchVO rportSearchVO) throws EventException;
	
	/**
	 *  Retrieving Return Performance by RCC<br>
	 * 
	 * @param  ReportSearchVO rportSearchVO
	 * @return List<ReportSearchVO>
	 * @throws EventException
	 */
	public List<ReportSearchVO> searchOffHireReportbyMonthSummaryBasic(ReportSearchVO rportSearchVO) throws EventException;
	/**
	 * Retrieving Performance comparing with Plan for taking over Owned and Long term equipment by Year/Contract<br>
	 * 
	 * @param  ReportSearchVO reportSearchVO
	 * @return List<ReportSearchVO>
	 * @exception EventException
	 */
	public List<ReportSearchVO> searchOnHireTotalSummaryByLeaseTermYearBasic(ReportSearchVO reportSearchVO) throws EventException;
	
}