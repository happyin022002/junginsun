/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ILeaseReportBCImpl.java
*@FileTitle : On Hire Result by Location / AGMT No(Contract No.)-Option
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.integration.LeaseReportDBDAO;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo.InventoryDetailVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo.InventorySummaryVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo.ReportSearchVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo.SearchParamVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo.SubLeaseOutDetailVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo.SubLeaseOutSummaryVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo.UsingDayDetailVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo.UsingDaySummaryVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Handling Biz Logic of ContainerLeaseMgt<br>
 *
 * @author 
 * @see EES_LSE_0036EventResponse,ILeaseReportBC 
 * @since J2EE 1.6
 */
public class LeaseReportBCImpl extends BasicCommandSupport implements LeaseReportBC {

	// Database Access Object
	private transient LeaseReportDBDAO dbDao = null;

	/**
	 * Generating ILeaseReportBCImpl <br>
	 * Generating ILeaseReportDBDAO <br>
	 */
	public LeaseReportBCImpl() {
		dbDao = new LeaseReportDBDAO();
	}
	/**
	 * Retrieving Hiring performance(ON Equipment)<br>
	 *
	 * @param  ReportSearchVO reportSearchVO
	 * @return List<ReportSearchVO>
	 * @exception EventException
	 */
	public List<ReportSearchVO> searchOnHireResultbyLocationAgreementSummaryBasic(ReportSearchVO reportSearchVO) throws EventException {
		List<ReportSearchVO> list = null;
		try {
			list = dbDao.searchOnHireResultbyLocationAgreementSummaryData(reportSearchVO);

			if ( list.size() < 1 ) {
				new EventException(new ErrorHandler("LSE01041",new String[]{"User Information"}).getMessage());
			}
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnHireResultbyLocationAgreementSummary Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnHireResultbyLocationAgreementSummary Search"}).getMessage(),ex);
		}
		return list;
	}
	/**
	 * Retrieving Hiring performance(ON Equipment) in detail<br>
	 *
	 * @param  ReportSearchVO reportSearchVO
	 * @return List<ReportSearchVO>
	 * @exception EventException
	 */
	public List<ReportSearchVO> searchOnHireResultbyLocationAgreementDetailBasic(ReportSearchVO reportSearchVO) throws EventException {
		List<ReportSearchVO> list = null;
		try {
			list = dbDao.searchOnHireResultbyLocationAgreementDetailData(reportSearchVO);
			if ( list.size() < 1 ) {
				new EventException(new ErrorHandler("LSE01041",new String[]{"User Information"}).getMessage());
			} else {
				list.get(0).setMaxRows(dbDao.searchOnHireResultbyLocationAgreementCountData(reportSearchVO));
			}
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnHireResultbyLocationAgreementDetail Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnHireResultbyLocationAgreementDetail Search"}).getMessage(),ex);
		}
		return list;
	}

	/**
	 * Retrieving Hiring performance(Off Equipment)<br>
	 *
	 * @param  ReportSearchVO reportSearchVO
	 * @return List<ReportSearchVO>
	 * @exception EventException
	 */
	public List<ReportSearchVO> searchOffHireResultbyLocationAgreementSummaryBasic(ReportSearchVO reportSearchVO) throws EventException {
		List<ReportSearchVO> list = null;
		try {
			list = dbDao.searchOffHireResultbyLocationAgreementSummaryData(reportSearchVO);
			if ( list.size() < 1 ) {
				new EventException(new ErrorHandler("LSE01041",new String[]{"User Information"}).getMessage());
			}
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OffHireResultbyLocationAgreementSummary Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OffHireResultbyLocationAgreementSummary Search"}).getMessage(),ex);
		}
		return list;
	}
	/**
	 * Retrieving Hiring performance(Off Equipment) in detail<br>
	 *
	 * @param  ReportSearchVO reportSearchVO
	 * @param  SignOnUserAccount account
	 * @return List<ReportSearchVO>
	 * @exception EventException
	 */
	public List<ReportSearchVO> searchOffHireResultbyLocationAgreementDetailBasic(ReportSearchVO reportSearchVO, SignOnUserAccount account) throws EventException {
		List<ReportSearchVO> list = null;
		try {
			list =  dbDao.searchOffHireResultbyLocationAgreementDetailData(reportSearchVO, account);
			if ( list.size() < 1 ) {
				new EventException(new ErrorHandler("LSE01041",new String[]{"User Information"}).getMessage());
			} else {
				list.get(0).setMaxRows(dbDao.searchOffHireResultbyLocationAgreementCountData(reportSearchVO));
			}
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OffHireResultbyLocationAgreementDetail Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OffHireResultbyLocationAgreementDetail Search"}).getMessage(),ex);
		}
		return list;
	}

	/**
	 * Retrieving avarage using performance list by Contract No. about returned hiring Equipment<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<UsingDaySummaryVO>
	 * @throws EventException
	 */
	public List<UsingDaySummaryVO> searchOffHireResultAvgUsingDaySummaryListBasic(SearchParamVO searchParamVO) throws EventException {
		List<UsingDaySummaryVO> resultVOs = null; 

		try {
			resultVOs = dbDao.searchOffHireResultAvgUsingDaySummaryListData(searchParamVO);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OffHireResultAverageUsingDaySummary Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OffHireResultAverageUsingDaySummary Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * Retrieving Using performance by hiring Equipment in detail<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @param  SignOnUserAccount account
	 * @return List<UsingDayDetailVO>
	 * @throws EventException
	 */
	public List<UsingDayDetailVO> searchOffHireResultAvgUsingDayDetailBasic(SearchParamVO searchParamVO, SignOnUserAccount account) throws EventException {
		List<UsingDayDetailVO> resultVOs = null; 

		try {
			resultVOs = dbDao.searchOffHireResultAvgUsingDayDetailData(searchParamVO, account);

			if(resultVOs.size() > 0) {
				resultVOs.get(0).setMaxRows(dbDao.searchOffHireResultAvgUsingDayCountData(searchParamVO));
			}
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OffHireResultAverageUsingDayDetail Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OffHireResultAverageUsingDayDetail Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * Retrieving Hiring performance Summary of hiring Equipment(On-Hire Result by Lease Term/Lessor-Option) <br>
	 *
	 * @param  ReportSearchVO reportSearchVO
	 * @return List<ReportSearchVO>
	 * @exception EventException
	 */

	public List<ReportSearchVO> searchOnHireResultbyTermLessorSummaryBasic(ReportSearchVO reportSearchVO) throws EventException {
		List<ReportSearchVO> list = null;
		try {
			list = dbDao.searchOnHireResultbyTermLessorSummaryData(reportSearchVO);
			if ( list.size() < 1 ) {
				new EventException(new ErrorHandler("LSE01041",new String[]{"User Information"}).getMessage());
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return list;
	}
	/**
	 * Retrieving Hiring performance of hiring Equipment in detail(On-Hire Result by Lease Term/Lessor-Option)<br>
	 *
	 * @param  ReportSearchVO reportSearchVO
	 * @return List<ReportSearchVO>
	 * @exception EventException
	 */

	public List<ReportSearchVO> searchOnHireResultbyTermLessorDetailBasic(ReportSearchVO reportSearchVO) throws EventException {
		List<ReportSearchVO> list = null;
		try {
			list = dbDao.searchOnHireResultbyTermLessorDetailData(reportSearchVO);
			if ( list.size() < 1 ) {
				new EventException(new ErrorHandler("LSE01041",new String[]{"User Information"}).getMessage());
			} else {
				list.get(0).setMaxRows(dbDao.searchOnHireResultbyTermLessorCountData(reportSearchVO));
			}
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnHireResultbyTermLessorDetail Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnHireResultbyTermLessorDetail Search"}).getMessage(),ex);
		}
		return list;
	}

	/**
	 * Retrieving Hiring performance Summary of hiring Equipment(Off-Hire Result by Lease Term/Lessor-Option) <br>
	 *
	 * @param  ReportSearchVO reportSearchVO
	 * @return List<ReportSearchVO>
	 * @exception EventException
	 */

	public List<ReportSearchVO> searchOffHireResultByTermLessorSummaryBasic (ReportSearchVO reportSearchVO) throws EventException {
		List<ReportSearchVO> list = null;
	    try {
			list = dbDao.searchOffHireResultByTermLessorSummaryData(reportSearchVO);
			if ( list.size() < 1 ) {
				new EventException(new ErrorHandler("LSE01041",new String[]{"User Information"}).getMessage());
			}
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OffHireResultByTermLessorSummary Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OffHireResultByTermLessorSummary Search"}).getMessage(),ex);
		}
		return list;
	}
	/**
	 * Retrieving Hiring performance of hiring Equipment in detail(Off-Hire Result by Lease Term/Lessor-Option)<br>
	 *
	 * @param  ReportSearchVO reportSearchVO
	 * @param  SignOnUserAccount account
	 * @return List<ReportSearchVO>
	 * @exception EventException
	 */

	public List<ReportSearchVO> searchOffHireResultByTermLessorDetailBasic (ReportSearchVO reportSearchVO, SignOnUserAccount account) throws EventException {
		List<ReportSearchVO> list = null;
		try {
			list = dbDao.searchOffHireResultByTermLessorDetailData(reportSearchVO,account);
			if ( list.size() < 1 ) {
				new EventException(new ErrorHandler("LSE01041",new String[]{"User Information"}).getMessage());
			} else {
				list.get(0).setMaxRows(dbDao.searchOffHireResultByTermLessorCountData(reportSearchVO));
			}
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OffHireResultByTermLessorDetail Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OffHireResultByTermLessorDetail Search"}).getMessage(),ex);
		}
		return list;
	}

	/**
	 * Retrieving Hiring performance Summary of hiring Equipment(Off-Hire Vs DOL) <br>
	 *
	 * @param  ReportSearchVO reportSearchVO
	 * @return List<ReportSearchVO>
	 * @exception EventException
	 */

	public List<ReportSearchVO> searchOffHireResultvsDOLSummaryBasic(ReportSearchVO reportSearchVO) throws EventException {
		List<ReportSearchVO> list = null;

		try {
			list = dbDao.searchOffHireResultvsDOLSummaryData(reportSearchVO);
			if ( list.size() < 1 ) {
				new EventException(new ErrorHandler("LSE01041",new String[]{"User Information"}).getMessage());
			}
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OffHireResultvsDOLSummary Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OffHireResultvsDOLSummary Search"}).getMessage(),ex);
		}
		return list;
	}
	/**
	 * Retrieving Hiring performance of hiring Equipment in detail(Off-Hire Vs DOL)<br>
	 *
	 * @param  ReportSearchVO reportSearchVO
	 * @param  SignOnUserAccount account
	 * @return List<ReportSearchVO>
	 * @exception EventException
	 */

	public List<ReportSearchVO> searchOffHireResultvsDOLDetailBasic(ReportSearchVO reportSearchVO, SignOnUserAccount account) throws EventException {
		List<ReportSearchVO> list = null;
		try {
			list = dbDao.searchOffHireResultvsDOLDetailData(reportSearchVO, account);
			if ( list.size() < 1 ) {
				new EventException(new ErrorHandler("LSE01041",new String[]{"User Information"}).getMessage());
			}
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OffHireResultvsDOLDetail Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OffHireResultvsDOLDetail Search"}).getMessage(),ex);
		}
		return list;
	}

	/**
	 * Retrieving current state of own and hiring Equipment List managed by Shiipping Company<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<InventorySummaryVO>
	 * @throws EventException
	 */
	public List<InventorySummaryVO> searchTotalContainerInventorySummaryListBasic(SearchParamVO searchParamVO) throws EventException {
		List<InventorySummaryVO> resultVOs = null; 

		try {
			resultVOs = dbDao.searchTotalContainerInventorySummaryListData(searchParamVO);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"TotalContainerInventorySummary Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"TotalContainerInventorySummary Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * Retrieving Details of own and hiring Equipment managed by Shiipping Company<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<InventoryDetailVO>
	 * @throws EventException
	 */
	public List<InventoryDetailVO> searchTotalContainerInventoryDetailBasic(SearchParamVO searchParamVO) throws EventException {
		List<InventoryDetailVO> resultVOs = null; 

		try {
			resultVOs = dbDao.searchTotalContainerInventoryDetailData(searchParamVO);

			if(resultVOs.size() > 0) {
				resultVOs.get(0).setMaxRows(dbDao.searchTotalContainerInventoryCountData(searchParamVO));
			}
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"TotalContainerInventorySummary Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"TotalContainerInventorySummary Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * Retriving new Equipment List <br>
	 *
	 * @param  ReportSearchVO reportSearchVO
	 * @return List<ReportSearchVO>
	 * @exception EventException
	 */

	public List<ReportSearchVO> searchNewContainerReceivingDetailBasic(ReportSearchVO reportSearchVO) throws EventException {
		List<ReportSearchVO> reportSearchVOs = null;
		List<ReportSearchVO> returnReportSearchVOs = new ArrayList<ReportSearchVO>();
		ReportSearchVO tempReportSearchVO  = null;
		ReportSearchVO tempReportSearchVO1 = null;
		ReportSearchVO tempReportSearchVO2 = null;
		try {
			reportSearchVOs = dbDao.searchNewContainerReceivingDetailData(reportSearchVO);
			int rowCnt = reportSearchVOs.size();

			int fRowCnt = rowCnt / 2 ;
			int othrCnt = rowCnt % 2 ;
			int sRowCnt = 0 ;

			if(rowCnt > 0){
			    int j = 0;
			    if(othrCnt == 1){
				    j = 1 ;
			    }
                for(int i = 1 ; i <=  fRowCnt + j ; i++){

            	    tempReportSearchVO   = new ReportSearchVO();
            	    tempReportSearchVO1  = new ReportSearchVO();
            	    tempReportSearchVO2  = new ReportSearchVO();

            	    sRowCnt = fRowCnt + i + j;

            	    tempReportSearchVO1 = reportSearchVOs.get(i-1);
            	    tempReportSearchVO.setGTtl(rowCnt + "");
                    tempReportSearchVO.setSeq1(i + "");
                    tempReportSearchVO.setCntrno1(tempReportSearchVO1.getCntrno());
                    tempReportSearchVO.setTysz1(tempReportSearchVO1.getTysz());
                    tempReportSearchVO.setRciveDt1(tempReportSearchVO1.getRciveDt());
                    tempReportSearchVO.setYard1(tempReportSearchVO1.getYard());

                    if(sRowCnt <=  rowCnt){
                	    tempReportSearchVO2 = reportSearchVOs.get(sRowCnt -1);
                	    tempReportSearchVO.setSeq2(sRowCnt + "");
                        tempReportSearchVO.setCntrno2(tempReportSearchVO2.getCntrno());
                        tempReportSearchVO.setTysz2(tempReportSearchVO2.getTysz());
                        tempReportSearchVO.setRciveDt2(tempReportSearchVO2.getRciveDt());
                        tempReportSearchVO.setYard2(tempReportSearchVO2.getYard());
                    }
                    returnReportSearchVOs.add(tempReportSearchVO);
                }
			}
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"NewContainerReceivingDetail Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"NewContainerReceivingDetail Search"}).getMessage(),ex);
		}
		return returnReportSearchVOs;
	}

	/**
	 * Retrieving current state of Sub Lease own Equipment and Miss Use hiring Equipment<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @param  SignOnUserAccount account
	 * @return List<SubLeaseOutSummaryVO>
	 * @throws EventException
	 */
	public List<SubLeaseOutSummaryVO> searchSubLeaseOutContainerSummaryListBasic(SearchParamVO searchParamVO, SignOnUserAccount account) throws EventException {
		List<SubLeaseOutSummaryVO> resultVOs = null; 

		try {
			resultVOs = dbDao.searchSubLeaseOutContainerSummaryListData(searchParamVO, account);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"SubLeaseOutContainerSummary Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"SubLeaseOutContainerSummary Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * Retrieving Details of Sub Lease own Equipment and Miss Use hiring Equipment<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @param  SignOnUserAccount account
	 * @return List<SubLeaseOutDetailVO>
	 * @throws EventException
	 */
	public List<SubLeaseOutDetailVO> searchSubLeaseOutContainerDetailBasic(SearchParamVO searchParamVO, SignOnUserAccount account) throws EventException {
		List<SubLeaseOutDetailVO> resultVOs = null; 

		try {
			resultVOs = dbDao.searchSubLeaseOutContainerDetailData(searchParamVO, account);

			if(resultVOs.size() > 0) {
				resultVOs.get(0).setMaxRows(dbDao.searchSubLeaseOutContainerCountData(searchParamVO));
			}
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"SubLeaseOutContainerDetail Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"SubLeaseOutContainerDetail Search"}).getMessage(),ex);
		}

		return resultVOs;
	}


	/**
	 * Retrieving Hireing performance by RCC <br>
	 *
	 * @param  ReportSearchVO reportSearchVO
	 * @return List<ReportSearchVO>
	 * @exception EventException
	 */

	public List<ReportSearchVO> searchOnHireReportbyRccSummaryBasic(ReportSearchVO reportSearchVO) throws EventException {
		List<ReportSearchVO> resultVOs = null; 
		try {
			resultVOs = dbDao.searchOnHireReportbyRccSummaryData(reportSearchVO);
			if ( resultVOs.size() < 1 ) {
				new EventException(new ErrorHandler("LSE01041",new String[]{"User Information"}).getMessage());
			}
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnHireReportbyRccSummary Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnHireReportbyRccSummary Search"}).getMessage(),ex);
		}
		return resultVOs;
	}
	/**
	 * Retrieving Monthly Hiring performance   <br>
	 *
	 * @param  ReportSearchVO reportSearchVO
	 * @return List<ReportSearchVO>
	 * @exception EventException
	 */

	public List<ReportSearchVO> searchOnHireReportbyMonthSummaryBasic(ReportSearchVO reportSearchVO) throws EventException {
		List<ReportSearchVO> resultVOs = null; 
		try {
			resultVOs = dbDao.searchOnHireReportbyMonthSummaryData(reportSearchVO);
			if ( resultVOs.size() < 1 ) {
				new EventException(new ErrorHandler("LSE01041",new String[]{"User Information"}).getMessage());
			}
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnHireReportbyMonthSummary Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnHireReportbyMonthSummary Search"}).getMessage(),ex);
		}
		return resultVOs;
	}

	/**
	 * Retrieving Return Performance by RCC  <br>
	 *
	 * @param  ReportSearchVO reportSearchVO
	 * @return List<ReportSearchVO>
	 * @exception EventException
	 */

	public List<ReportSearchVO> searchOffHireReportbyRccSummaryBasic(ReportSearchVO reportSearchVO) throws EventException {
		List<ReportSearchVO> resultVOs = null; 
		try {
			resultVOs = dbDao.searchOffHireReportbyRccSummaryData(reportSearchVO);
			if ( resultVOs.size() < 1 ) {
				new EventException(new ErrorHandler("LSE01041",new String[]{"User Information"}).getMessage());
			}
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OffHireReportbyRccSummary Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OffHireReportbyRccSummary Search"}).getMessage(),ex);
		}
		return resultVOs;
	}

	/**
	 * Retrieving Return Performance by RCC  <br>
	 *
	 * @param  ReportSearchVO reportSearchVO
	 * @return List<ReportSearchVO>
	 * @exception EventException
	 */

	public List<ReportSearchVO> searchOffHireReportbyMonthSummaryBasic(ReportSearchVO reportSearchVO) throws EventException {
		List<ReportSearchVO> resultVOs = null; 
		try {
			resultVOs = dbDao.searchOffHireReportbyMonthSummaryData(reportSearchVO);
			if ( resultVOs.size() < 1 ) {
				new EventException(new ErrorHandler("LSE01041",new String[]{"User Information"}).getMessage());
			}
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OffHireReportbyRccSummary Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OffHireReportbyRccSummary Search"}).getMessage(),ex);
		}
		return resultVOs;
	}

	/**
	 * Retrieving Performance comparing with Plan for taking over Owned and Long term equipment by Year/Contract<br>
	 *
	 * @param  ReportSearchVO reportSearchVO
	 * @return List<ReportSearchVO>
	 * @exception EventException
	 */
	public List<ReportSearchVO> searchOnHireTotalSummaryByLeaseTermYearBasic(ReportSearchVO reportSearchVO) throws EventException {
		List<ReportSearchVO> list = null;
		try {
			list = dbDao.searchOnHireTotalSummaryByLeaseTermYearData(reportSearchVO);
			if ( list.size() < 1 ) {
				new EventException(new ErrorHandler("LSE01041",new String[]{"User Information"}).getMessage());
			}
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"searchOnHireTotalSummaryByLeaseTermYear Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"searchOnHireTotalSummaryByLeaseTermYear Search"}).getMessage(),ex);
		}
		return list;
	}
	
}