/*========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AvailableOffHireBackEndJob.java
 *@FileTitle : Available Off Hire Q'ty
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.19
 *@LastModifier : 장준우
 *@LastVersion : 1.0
 * 2009.10.19 장준우
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.integration.MTYRepositionPerformanceAnalysisDBDAO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.MTYCNTRPERFInDailyTrendVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.MTYCNTRPERFInDetailVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.MTYCNTRPERFSearchOptionVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.MTYCNTRPERFSummaryVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.MTYMonthlyWeeklyTrendSetVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 * ALPS-Containerleasemgt Business Logic Command Interface<br>
 * - ALPS-Containerleasemgt에 대한 비지니스 로직에 대한 BackEndJob 구상클래스<br>
 * 
 * @author Jang Jun-Woo
 * @see Ees_lse_0020EventResponse 참조
 * @since J2EE 1.6
 */
public class MTYRepositionPerformanceAnalysisBackEndJob extends BackEndCommandSupport {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8991259368143777211L;

	private String jobType = null;

	private MTYRepositionPerformanceAnalysisDBDAO dbDao = new MTYRepositionPerformanceAnalysisDBDAO();

	private MTYCNTRPERFSearchOptionVO mTYCNTRPERFSearchOptionVO;

	/**
	 * 요청작업의 수행을 BackEndJob으로 처리합니다.<br>
	 * 
	 * @return List list
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List doStart() throws Exception {
		List list = null;

		try {
			if (getJobType().equals("searchMTYCNTRPERFByMovementSMRY")) { // Turn Around Time TAB1

				list = (List<MTYCNTRPERFSummaryVO>) dbDao.searchMTYCNTRPERFByMovementSMRY(mTYCNTRPERFSearchOptionVO);

			}
			else if (getJobType().equals("searchMTYCNTRPERFByMovementDTL")) { // Turn Around Time TAB2

				list = (List<MTYCNTRPERFInDetailVO>) dbDao.searchMTYCNTRPERFByMovementDTL(mTYCNTRPERFSearchOptionVO);

			}
			else if (getJobType().equals("searchMTYCNTRPERFByMovementTrend")) { // Turn Around Time TAB3

				list = (List<MTYMonthlyWeeklyTrendSetVO>) dbDao.searchMTYCNTRPERFByMovementTrend(mTYCNTRPERFSearchOptionVO);

			}
			else if (getJobType().equals("searchMTYCNTRPERFByMovementDailyTrend")) { // Turn Around Time TAB4

				list = (List<MTYCNTRPERFInDailyTrendVO>) dbDao.searchMTYCNTRPERFByMovementDailyTrend(mTYCNTRPERFSearchOptionVO);

			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return list;
	}

	/**
	 * 검색 옵션 VO를 가지고 온다.
	 * @return mTYCNTRPERFSearchOptionVO
	 */
	public MTYCNTRPERFSearchOptionVO getMTYCNTRPERFSearchOptionVO() {
		return mTYCNTRPERFSearchOptionVO;
	}

	/**
	 * 검색 옵션 VO를 넘겨 받는다.
	 * @param searchOptionVO
	 */
	public void setMTYCNTRPERFSearchOptionVO(MTYCNTRPERFSearchOptionVO searchOptionVO) {
		mTYCNTRPERFSearchOptionVO = searchOptionVO;
	}

	/**
	 * @return the jobType
	 */
	public String getJobType() {
		return jobType;
	}

	/**
	 * @param jobType the jobType to set
	 */
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

}
