/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ILeaseReportBC.java
*@FileTitle : On Hire Result by Location / AGMT No(Contract No.)-Option
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.07.10 진준성
* 1.0 Creation
* ========================================================
* 2011.06.13 남궁진호 [CHM-201111467-01] [LSE] MDM에 R9 등록에 따른 추가 업무 진행 요청
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.vo.InventoryDetailVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.vo.InventorySummaryVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.vo.ReportSearchVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.vo.SearchParamVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.vo.SubLeaseOutDetailVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.vo.SubLeaseOutSummaryVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.vo.UsingDayDetailVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.vo.UsingDaySummaryVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-Containerleasemgt Business Logic Command Interface<br>
 * - ALPS-Containerleasemgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jin Jun Sung
 * @see Ees_lse_0036EventResponse 참조
 * @since J2EE 1.6
 */

public interface LeaseReportBC {

	/**
	 * 임차장비 임차실적(ON 장비) 조회.<br>
	 * 
	 * @param  ReportSearchVO reportSearchVO
	 * @return ReportSearchVO
	 * @exception EventException
	 */
	public ReportSearchVO searchOnHireResultbyLocationAgreementSummaryBasic(ReportSearchVO reportSearchVO) throws EventException;
	/**
	 *임차장비 임차실적(ON장비) 상세조회<br>
	 * 
	 * @param  ReportSearchVO reportSearchVO
	 * @return List<ReportSearchVO>
	 * @exception EventException
	 */
	public List<ReportSearchVO> searchOnHireResultbyLocationAgreementDetailBasic(ReportSearchVO reportSearchVO) throws EventException;
	/**
	 * 임차장비 임차실적 조회.<br>
	 * 
	 * @param  ReportSearchVO reportSearchVO
	 * @return ReportSearchVO
	 * @exception EventException
	 */
	public ReportSearchVO searchOffHireResultbyLocationAgreementSummaryBasic(ReportSearchVO reportSearchVO) throws EventException;
	/**
	 *임차장비 임차실적(Off장비) 상세조회<br>
	 * 
	 * @param  ReportSearchVO reportSearchVO
	 * @return List<ReportSearchVO>
	 * @exception EventException
	 */
	public List<ReportSearchVO> searchOffHireResultbyLocationAgreementDetailBasic(ReportSearchVO reportSearchVO) throws EventException;
	
	/**
	 * 반납 임차장비에 대한 계약번호별 평균사용 실적목록을 조회합니다.<br>
	 * 
	 * @param  SearchParamVO searchParamVO
	 * @return List<UsingDaySummaryVO>
	 * @throws EventException
	 */
	public List<UsingDaySummaryVO> searchOffHireResultAvgUsingDaySummaryListBasic(SearchParamVO searchParamVO) throws EventException;
	
	/**
	 * 임차장비별 사용실적에 대한 상세내역을 조회합니다.<br>
	 * 
	 * @param  SearchParamVO searchParamVO
	 * @return List<UsingDayDetailVO>
	 * @throws EventException
	 */
	public List<UsingDayDetailVO> searchOffHireResultAvgUsingDayDetailBasic(SearchParamVO searchParamVO) throws EventException;
	
	/**
	 *임차장비 임차실적 Summary조회(On-Hire Result by Lease Term/Lessor-Option) <br>
	 * 
	 * @param  ReportSearchVO reportSearchVO
	 * @return ReportSearchVO
	 * @exception EventException
	 */
	public ReportSearchVO searchOnHireResultbyTermLessorSummaryBasic (ReportSearchVO reportSearchVO) throws EventException;
	

	/**
	 *임차장비 임차실적  상세조회(On-Hire Result by Lease Term/Lessor-Option) <br>
	 * 
	 * @param  ReportSearchVO reportSearchVO
	 * @return List<ReportSearchVO>
	 * @exception EventException
	 */
	public List<ReportSearchVO> searchOnHireResultbyTermLessorDetailBasic(ReportSearchVO reportSearchVO) throws EventException;
	
	
	/**
	 * 임차장비 임차실적  Summary조회(Off-Hire Result by Lease Term/Lessor-Option) <br>
	 * 
	 * @param  ReportSearchVO reportSearchVO
	 * @return ReportSearchVO
	 * @exception EventException
	 */
	public ReportSearchVO searchOffHireResultByTermLessorSummaryBasic (ReportSearchVO reportSearchVO) throws EventException;
	
	/**
	 * 임차장비 임차실적  상세 조회(Off-Hire Result by Lease Term/Lessor-Option) <br>
	 * 
	 * @param  ReportSearchVO reportSearchVO
	 * @return List<ReportSearchVO>
	 * @exception EventException
	 */
	public List<ReportSearchVO>  searchOffHireResultByTermLessorDetailBasic(ReportSearchVO reportSearchVO) throws EventException;
	
	/**
	 * 임차장비 임차실적  Summary조회(Off-Hire Vs DOL) <br>
	 * 
	 * @param  ReportSearchVO reportSearchVO
	 * @return ReportSearchVO
	 * @exception EventException
	 */
	public ReportSearchVO searchOffHireResultvsDOLSummaryBasic(ReportSearchVO reportSearchVO) throws EventException;
			
	/**
	 * 임차장비 임차실적  상세 조회(Off-Hire Vs DOL) <br>
	 * 
	 * @param  ReportSearchVO reportSearchVO
	 * @return List<ReportSearchVO>
	 * @exception EventException
	 */
	public List<ReportSearchVO>  searchOffHireResultvsDOLDetailBasic(ReportSearchVO reportSearchVO) throws EventException;
	
	/**
	 * HJS의 관리하는 자가 및 임차장비의 현황목록을 조회합니다.<br>
	 * 
	 * @param  SearchParamVO searchParamVO
	 * @return List<InventorySummaryVO>
	 * @throws EventException
	 */
	public List<InventorySummaryVO> searchTotalContainerInventorySummaryListBasic(SearchParamVO searchParamVO) throws EventException;
	
	/**
	 * HJS의 관리하는 자가 및 임차장비의 상세내역을 조회합니다.<br>
	 * 
	 * @param  SearchParamVO searchParamVO
	 * @return List<InventoryDetailVO>
	 * @throws EventException
	 */
	public List<InventoryDetailVO> searchTotalContainerInventoryDetailBasic(SearchParamVO searchParamVO) throws EventException;
	
	/**
	 * 신조장비여부 조회<br>
	 * 
	 * @param  ReportSearchVO reportSearchVO
	 * @return List<ReportSearchVO>
	 * @throws EventException
	 */
	public List<ReportSearchVO> searchNewContainerReceivingDetailBasic(ReportSearchVO reportSearchVO) throws EventException;
	
	/**
	 * Sub Lease 자사장비 및 Mis Use 타사장비의 현황목록을 조회합니다.<br>
	 * 
	 * @param  SearchParamVO searchParamVO
	 * @return List<SubLeaseOutSummaryVO>
	 * @throws EventException
	 */
	public List<SubLeaseOutSummaryVO> searchSubLeaseOutContainerSummaryListBasic(SearchParamVO searchParamVO) throws EventException;
	
	/**
	 * Sub Lease 자사장비 및 Mis Use 타사장비의 상세내역을 조회합니다.<br>
	 * 
	 * @param  SearchParamVO searchParamVO
	 * @return List<SubLeaseOutDetailVO>
	 * @throws EventException
	 */
	public List<SubLeaseOutDetailVO> searchSubLeaseOutContainerDetailBasic(SearchParamVO searchParamVO) throws EventException;
	
	/**
	 * 임차 실적을 RCC별로 조회<br>
	 * 
	 * @param  ReportSearchVO rportSearchVO
	 * @return ReportSearchVO
	 * @throws EventException
	 */
	public ReportSearchVO searchOnHireReportbyRccSummaryBasic(ReportSearchVO rportSearchVO) throws EventException;
	
	/**
	 * 월별로 임차한 실적으로 조회<br>
	 * 
	 * @param  ReportSearchVO rportSearchVO
	 * @return ReportSearchVO
	 * @throws EventException
	 */
	public ReportSearchVO searchOnHireReportbyMonthSummaryBasic(ReportSearchVO rportSearchVO) throws EventException;
	
	/**
	 * 반납한 실적을 RCC별로 조회<br>
	 * 
	 * @param  ReportSearchVO rportSearchVO
	 * @return ReportSearchVO
	 * @throws EventException
	 */
	public ReportSearchVO searchOffHireReportbyRccSummaryBasic(ReportSearchVO rportSearchVO) throws EventException;
	
	/**
	 *  월별로 반납한 실적조회<br>
	 * 
	 * @param  ReportSearchVO rportSearchVO
	 * @return ReportSearchVO
	 * @throws EventException
	 */
	public ReportSearchVO searchOffHireReportbyMonthSummaryBasic(ReportSearchVO rportSearchVO) throws EventException;
	/**
	 * 년도별/계약별 자가 및 장기 장비 인수 계획 대비 실적 조회<br>
	 * 
	 * @param  ReportSearchVO reportSearchVO
	 * @return List<ReportSearchVO>
	 * @exception EventException
	 */
	public List<ReportSearchVO> searchOnHireTotalSummaryByLeaseTermYearBasic(ReportSearchVO reportSearchVO) throws EventException;
}