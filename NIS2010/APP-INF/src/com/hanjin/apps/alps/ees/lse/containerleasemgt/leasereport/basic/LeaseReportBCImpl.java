/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ILeaseReportBCImpl.java
*@FileTitle : On Hire Result by Location / AGMT No(Contract No.)-Option
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.07.10 진준성
* 1.0 Creation
* =======================================================
* 2011.06.13 남궁진호 [CHM-201111467-01] [LSE] MDM에 R9 등록에 따른 추가 업무 진행 요청
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.integration.LeaseReportDBDAO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.vo.InventoryDetailVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.vo.InventorySummaryVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.vo.ReportSearchVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.vo.SearchParamVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.vo.SubLeaseOutDetailVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.vo.SubLeaseOutSummaryVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.vo.UsingDayDetailVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.vo.UsingDaySummaryVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * - ALPS-ContainerLeaseMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jin Jun Sung
 * @see EES_LSE_0036EventResponse,ILeaseReportBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class LeaseReportBCImpl extends BasicCommandSupport implements LeaseReportBC {

	// Database Access Object
	private transient LeaseReportDBDAO dbDao = null;

	/**
	 * ILeaseReportBCImpl 객체 생성<br>
	 * ILeaseReportDBDAO를 생성한다.<br>
	 */
	public LeaseReportBCImpl() {
		dbDao = new LeaseReportDBDAO();
	}
	/**
	 * 임차장비 임차 (ON 장비)실적을 조회<br>
	 *
	 * @param  ReportSearchVO reportSearchVO
	 * @return ReportSearchVO
	 * @exception EventException
	 */
	public ReportSearchVO searchOnHireResultbyLocationAgreementSummaryBasic(ReportSearchVO reportSearchVO) throws EventException {
		ReportSearchVO rsVo = new ReportSearchVO() ;
		try {
			rsVo = dbDao.searchOnHireResultbyLocationAgreementSummaryData(reportSearchVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnHireResultbyLocationAgreementSummary Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnHireResultbyLocationAgreementSummary Search"}).getMessage(),ex);
		}
		return rsVo;
	}
	/**
	 * 임차장비 임차 (ON 장비)실적을 상세조회<br>
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
	 * 임차장비 임차(Off 장비) 실적을 조회<br>
	 *
	 * @param  ReportSearchVO reportSearchVO
	 * @return ReportSearchVO
	 * @exception EventException
	 */
	public ReportSearchVO searchOffHireResultbyLocationAgreementSummaryBasic(ReportSearchVO reportSearchVO) throws EventException {
		ReportSearchVO rsVo = new ReportSearchVO() ;
		try {
			rsVo = dbDao.searchOffHireResultbyLocationAgreementSummaryData(reportSearchVO);
			
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OffHireResultbyLocationAgreementSummary Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OffHireResultbyLocationAgreementSummary Search"}).getMessage(),ex);
		}
		return rsVo;
	}
	/**
	 * 임차장비 임차 (Off 장비)실적을 상세조회<br>
	 *
	 * @param  ReportSearchVO reportSearchVO
	 * @return List<ReportSearchVO>
	 * @exception EventException
	 */
	public List<ReportSearchVO> searchOffHireResultbyLocationAgreementDetailBasic(ReportSearchVO reportSearchVO) throws EventException {
		List<ReportSearchVO> list = null;
		try {
			list =  dbDao.searchOffHireResultbyLocationAgreementDetailData(reportSearchVO);
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
	 * 반납 임차장비에 대한 계약번호별 평균사용 실적목록을 조회합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<UsingDaySummaryVO>
	 * @throws EventException
	 */
	public List<UsingDaySummaryVO> searchOffHireResultAvgUsingDaySummaryListBasic(SearchParamVO searchParamVO) throws EventException {
		List<UsingDaySummaryVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

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
	 * 임차장비별 사용실적에 대한 상세내역을 조회합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<UsingDayDetailVO>
	 * @throws EventException
	 */
	public List<UsingDayDetailVO> searchOffHireResultAvgUsingDayDetailBasic(SearchParamVO searchParamVO) throws EventException {
		List<UsingDayDetailVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

		try {
			resultVOs = dbDao.searchOffHireResultAvgUsingDayDetailData(searchParamVO);

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
	 * 임차장비 임차실적  Summary조회(On-Hire Result by Lease Term/Lessor-Option) <br>
	 *
	 * @param  ReportSearchVO reportSearchVO
	 * @return ReportSearchVO
	 * @exception EventException
	 */

	public ReportSearchVO searchOnHireResultbyTermLessorSummaryBasic(ReportSearchVO reportSearchVO) throws EventException {
		ReportSearchVO rsVo = new ReportSearchVO();
		try {
			rsVo = dbDao.searchOnHireResultbyTermLessorSummaryData(reportSearchVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return rsVo;
	}
	/**
	 * 임차장비 임차실적  상세조회(On-Hire Result by Lease Term/Lessor-Option)<br>
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
	 * 임차장비 임차실적  Summary조회(Off-Hire Result by Lease Term/Lessor-Option) <br>
	 *
	 * @param  ReportSearchVO reportSearchVO
	 * @return ReportSearchVO
	 * @exception EventException
	 */

	public ReportSearchVO searchOffHireResultByTermLessorSummaryBasic (ReportSearchVO reportSearchVO) throws EventException {
		ReportSearchVO rsVo = new ReportSearchVO();
	    try {
	    	 rsVo = dbDao.searchOffHireResultByTermLessorSummaryData(reportSearchVO);
		
	    } catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OffHireResultByTermLessorSummary Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OffHireResultByTermLessorSummary Search"}).getMessage(),ex);
		}
		return rsVo;
	}
	/**
	 * 임차장비 임차실적  상세조회(Off-Hire Result by Lease Term/Lessor-Option)<br>
	 *
	 * @param  ReportSearchVO reportSearchVO
	 * @return List<ReportSearchVO>
	 * @exception EventException
	 */

	public List<ReportSearchVO> searchOffHireResultByTermLessorDetailBasic (ReportSearchVO reportSearchVO) throws EventException {
		List<ReportSearchVO> list = null;
		try {
			list = dbDao.searchOffHireResultByTermLessorDetailData(reportSearchVO);
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
	 * 임차장비 임차실적  Summary조회(Off-Hire Vs DOL) <br>
	 *
	 * @param  ReportSearchVO reportSearchVO
	 * @return ReportSearchVO
	 * @exception EventException
	 */

	public ReportSearchVO searchOffHireResultvsDOLSummaryBasic(ReportSearchVO reportSearchVO) throws EventException {
		ReportSearchVO rsVo = new ReportSearchVO();

		try {
			rsVo = dbDao.searchOffHireResultvsDOLSummaryData(reportSearchVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OffHireResultvsDOLSummary Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OffHireResultvsDOLSummary Search"}).getMessage(),ex);
		}
		return rsVo;
	}
	/**
	 * 임차장비 임차실적  상세조회(Off-Hire Vs DOL)<br>
	 *
	 * @param  ReportSearchVO reportSearchVO
	 * @return List<ReportSearchVO>
	 * @exception EventException
	 */

	public List<ReportSearchVO> searchOffHireResultvsDOLDetailBasic(ReportSearchVO reportSearchVO) throws EventException {
		List<ReportSearchVO> list = null;
		try {
			list = dbDao.searchOffHireResultvsDOLDetailData(reportSearchVO);
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
	 * HJS의 관리하는 자가 및 임차장비의 현황목록을 조회합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<InventorySummaryVO>
	 * @throws EventException
	 */
	public List<InventorySummaryVO> searchTotalContainerInventorySummaryListBasic(SearchParamVO searchParamVO) throws EventException {
		List<InventorySummaryVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

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
	 * HJS의 관리하는 자가 및 임차장비의 상세내역을 조회합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<InventoryDetailVO>
	 * @throws EventException
	 */
	public List<InventoryDetailVO> searchTotalContainerInventoryDetailBasic(SearchParamVO searchParamVO) throws EventException {
		List<InventoryDetailVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

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
	 * 신조장비여부 리스트 조회 <br>
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
	 * Sub Lease 자사장비 및 Mis Use 타사장비의 현황목록을 조회합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<SubLeaseOutSummaryVO>
	 * @throws EventException
	 */
	public List<SubLeaseOutSummaryVO> searchSubLeaseOutContainerSummaryListBasic(SearchParamVO searchParamVO) throws EventException {
		List<SubLeaseOutSummaryVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

		try {
			resultVOs = dbDao.searchSubLeaseOutContainerSummaryListData(searchParamVO);
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
	 * Sub Lease 자사장비 및 Mis Use 타사장비의 상세내역을 조회합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<SubLeaseOutDetailVO>
	 * @throws EventException
	 */
	public List<SubLeaseOutDetailVO> searchSubLeaseOutContainerDetailBasic(SearchParamVO searchParamVO) throws EventException {
		List<SubLeaseOutDetailVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

		try {
			resultVOs = dbDao.searchSubLeaseOutContainerDetailData(searchParamVO);

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
	 * 임차 실적을 RCC별로 조회 <br>
	 *
	 * @param  ReportSearchVO reportSearchVO
	 * @return ReportSearchVO
	 * @exception EventException
	 */

	public ReportSearchVO searchOnHireReportbyRccSummaryBasic(ReportSearchVO reportSearchVO) throws EventException {
		ReportSearchVO rsVo = new ReportSearchVO(); // 데이터 전송을 위해 VO 객체
		try {
			rsVo = dbDao.searchOnHireReportbyRccSummaryData(reportSearchVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnHireReportbyRccSummary Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnHireReportbyRccSummary Search"}).getMessage(),ex);
		}
		return rsVo;
	}
	/**
	 * 월별로 임차한 실적을 조회  <br>
	 *
	 * @param  ReportSearchVO reportSearchVO
	 * @return ReportSearchVO
	 * @exception EventException
	 */

	public ReportSearchVO searchOnHireReportbyMonthSummaryBasic(ReportSearchVO reportSearchVO) throws EventException {
		ReportSearchVO rsVo = new ReportSearchVO(); // 데이터 전송을 위해 VO 객체
		try {
			rsVo = dbDao.searchOnHireReportbyMonthSummaryData(reportSearchVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnHireReportbyMonthSummary Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnHireReportbyMonthSummary Search"}).getMessage(),ex);
		}
		return rsVo;
	}

	/**
	 * 반납한 실적을 RCC별로 조회  <br>
	 *
	 * @param  ReportSearchVO reportSearchVO
	 * @return ReportSearchVO
	 * @exception EventException
	 */

	public ReportSearchVO searchOffHireReportbyRccSummaryBasic(ReportSearchVO reportSearchVO) throws EventException {
		ReportSearchVO rsVo = new ReportSearchVO(); // 데이터 전송을 위해 VO 객체
		try {
			rsVo = dbDao.searchOffHireReportbyRccSummaryData(reportSearchVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OffHireReportbyRccSummary Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OffHireReportbyRccSummary Search"}).getMessage(),ex);
		}
		return rsVo;
	}

	/**
	 * 반납한 실적을 RCC별로 조회  <br>
	 *
	 * @param  ReportSearchVO reportSearchVO
	 * @return ReportSearchVO
	 * @exception EventException
	 */

	public ReportSearchVO searchOffHireReportbyMonthSummaryBasic(ReportSearchVO reportSearchVO) throws EventException {
		ReportSearchVO rsVo = new ReportSearchVO(); // 데이터 전송을 위해 VO 객체
		try {
			rsVo = dbDao.searchOffHireReportbyMonthSummaryData(reportSearchVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OffHireReportbyRccSummary Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OffHireReportbyRccSummary Search"}).getMessage(),ex);
		}
		return rsVo;
	}

	/**
	 * 년도별/계약별 자가 및 장기 장비 인수 계획 대비 실적 조회<br>
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