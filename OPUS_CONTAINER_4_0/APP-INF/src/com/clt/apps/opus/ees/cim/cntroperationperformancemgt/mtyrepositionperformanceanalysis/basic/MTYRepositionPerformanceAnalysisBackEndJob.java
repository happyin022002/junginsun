/*========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AvailableOffHireBackEndJob.java
 *@FileTitle : Available Off Hire Q'ty
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.basic;

import java.util.List;

import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.integration.MTYRepositionPerformanceAnalysisDBDAO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.MTYCNTRPERFInDetailVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.MTYCNTRPERFSearchOptionVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.MTYCNTRPERFSummaryVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.MTYMonthlyWeeklyTrendSetVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;

/**
 * OPUS--Containerleasemgt Business Logic Command Interface<br>
 * 
 * @author
 * @see Ees_lse_0020EventResponse reference
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
	 * handling requested process by BackEndJob
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
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return list;
	}

	/**
	 * getting search option VO
	 * @return mTYCNTRPERFSearchOptionVO
	 */
	public MTYCNTRPERFSearchOptionVO getMTYCNTRPERFSearchOptionVO() {
		return mTYCNTRPERFSearchOptionVO;
	}

	/**
	 * taking over search option VO
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
