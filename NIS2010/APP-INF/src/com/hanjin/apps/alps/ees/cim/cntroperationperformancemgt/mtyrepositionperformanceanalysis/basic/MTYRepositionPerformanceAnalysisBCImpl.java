/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MTYRepositionPerformanceAnalysisBCImpl.java
 *@FileTitle : Repo Result by Port
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.26
 *@LastModifier : 박광석
 *@LastVersion : 1.0
 * 2009.05.26 박광석
 * 1.0 Creation
 * ======================================================
 * 2010.10.01 남궁진호 [CHM-201006256-01] Session User Id 변경, CreUsrId -> UsrId
 *             searchMTYCNTRPERFByMovementSMRY,searchMTYCNTRPERFByMovementDTL
 *             searchMTYCNTRPERFByMovementTrend            
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.basic;

import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.integration.MTYRepositionPerformanceAnalysisDBDAO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.MTYCNTRPERFSearchOptionVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.REPOResultInGeneralVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.REPOResultSearchOptionByLocationVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.REPOResultSearchOptionByPortVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-CNTROperatioNPerformanceMgt Business Logic Basic Command implementation<br>
 * - ALPS-CNTROperatioNPerformanceMgt에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Prak Kwang Seok
 * @see EES_CIM_1033EventResponse,MTYRepositionPerformanceAnalysisBC 각 DAO 클래스
 *      참조
 * @since J2EE 1.6
 */
public class MTYRepositionPerformanceAnalysisBCImpl extends BasicCommandSupport implements
		MTYRepositionPerformanceAnalysisBC {

	// Database Access Object
	private transient MTYRepositionPerformanceAnalysisDBDAO dbDao = null;

	/**
	 * MTYRepositionPerformanceAnalysisBCImpl 객체 생성<br>
	 * MTYRepositionPerformanceAnalysisDBDAO를 생성한다.<br>
	 */
	public MTYRepositionPerformanceAnalysisBCImpl() {
		dbDao = new MTYRepositionPerformanceAnalysisDBDAO();
	}

	/**
	 * REPOResultByPort 을 조회 합니다. <br>
	 * 
	 * @param rEPOResultSearchOptionByPortVO
	 * @return List<REPOResultInGeneralVO>
	 * @exception EventException
	 */
	public List<REPOResultInGeneralVO> searchREPOResultByPort(
			REPOResultSearchOptionByPortVO rEPOResultSearchOptionByPortVO) throws EventException {
		List<REPOResultInGeneralVO> list = null;
		try {
			list = dbDao.searchREPOResultByPort(rEPOResultSearchOptionByPortVO);

			// if(list.size() <= 1){
			// throw new EventException(new
			// ErrorHandler("CIM21006").getMessage());
			// }

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[] { "Repo. Result by Port Retrieve" })
					.getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[] { "Repo. Result by Port Retrieve" })
					.getMessage(), ex);
		}
		return list;
	}

	/**
	 * REPOResultByLocation 을 조회 합니다. <br>
	 * 
	 * @param rEPOResultSearchOptionByLocation
	 * @return List<REPOResultInGeneralVO>
	 * @exception EventException
	 */
	public List<REPOResultInGeneralVO> searchREPOResultByLocation(
			REPOResultSearchOptionByLocationVO rEPOResultSearchOptionByLocation) throws EventException {
		List<REPOResultInGeneralVO> list = null;
		try {
			list = dbDao.searchREPOResultByLocation(rEPOResultSearchOptionByLocation);

			// if(list.size() <= 1){
			// throw new EventException(new
			// ErrorHandler("CIM21038").getMessage());
			// }

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "Repo. Result by Location & Domestic Retrieve" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "Repo. Result by Location & Domestic Retrieve" }).getMessage(), ex);
		}
		return list;
	}

	/**
	 * MTYCNTRPERFByMovementSMRY Tab 을 조회 합니다. <br>
	 * 
	 * @param mTYCNTRPERFSearchOptionVO
	 * @param account
	 * @return String
	 * @exception EventException
	 */
	public String searchMTYCNTRPERFByMovementSMRY(MTYCNTRPERFSearchOptionVO mTYCNTRPERFSearchOptionVO,
			SignOnUserAccount account) throws EventException {
		MTYRepositionPerformanceAnalysisBackEndJob backEndJob = new MTYRepositionPerformanceAnalysisBackEndJob();
		backEndJob.setJobType("searchMTYCNTRPERFByMovementSMRY");
		backEndJob.setMTYCNTRPERFSearchOptionVO(mTYCNTRPERFSearchOptionVO);
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			return backEndJobManager.execute(backEndJob, account.getUsr_id(),
					"MTY CNTR PFMC by MVMT Summary Retrieve BackEndJob");
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "MTY CNTR PFMC by MVMT Summary Retrieve BackEndJob" }).getMessage(), ex);
		}
	}

	/**
	 * MTYCNTRPERFByMovementDTL Tab 을 조회 합니다. <br>
	 * 
	 * @param mTYCNTRPERFSearchOptionVO
	 * @param account
	 * @return String
	 * @exception EventException
	 */
	public String searchMTYCNTRPERFByMovementDTL(MTYCNTRPERFSearchOptionVO mTYCNTRPERFSearchOptionVO,
			SignOnUserAccount account) throws EventException {
		MTYRepositionPerformanceAnalysisBackEndJob backEndJob = new MTYRepositionPerformanceAnalysisBackEndJob();
		backEndJob.setJobType("searchMTYCNTRPERFByMovementDTL");
		backEndJob.setMTYCNTRPERFSearchOptionVO(mTYCNTRPERFSearchOptionVO);
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			return backEndJobManager.execute(backEndJob, account.getUsr_id(),
					"MTY CNTR PFMC by MVMT Detail Retrieve BackEndJob");
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "MTY CNTR PFMC by MVMT Detail Retrieve BackEndJob" }).getMessage(), ex);
		}
	}

	/**
	 * MTYCNTRPERFByMovementTrend Tab 을 조회 합니다. <br>
	 * 
	 * @param mTYCNTRPERFSearchOptionVO
	 * @param account
	 * @return String
	 * @exception EventException
	 */
	public String searchMTYCNTRPERFByMovementTrend(MTYCNTRPERFSearchOptionVO mTYCNTRPERFSearchOptionVO,
			SignOnUserAccount account) throws EventException {
		MTYRepositionPerformanceAnalysisBackEndJob backEndJob = new MTYRepositionPerformanceAnalysisBackEndJob();
		backEndJob.setJobType("searchMTYCNTRPERFByMovementTrend");
		backEndJob.setMTYCNTRPERFSearchOptionVO(mTYCNTRPERFSearchOptionVO);
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			return backEndJobManager.execute(backEndJob, account.getUsr_id(),
					"MTY CNTR PFMC by MVMT Trend Retrieve BackEndJob");
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "MTY CNTR PFMC by MVMT Trend Retrieve BackEndJob" }).getMessage(), ex);
		}
	}
	
	/**
	 * MTYCNTRPERFByMovementDailyTrend Tab 을 조회 합니다. <br>
	 * 
	 * @param mTYCNTRPERFSearchOptionVO
	 * @param account
	 * @return String
	 * @exception EventException
	 */
	public String searchMTYCNTRPERFByMovementDailyTrend(MTYCNTRPERFSearchOptionVO mTYCNTRPERFSearchOptionVO,
			SignOnUserAccount account) throws EventException {
		MTYRepositionPerformanceAnalysisBackEndJob backEndJob = new MTYRepositionPerformanceAnalysisBackEndJob();
		backEndJob.setJobType("searchMTYCNTRPERFByMovementDailyTrend");
		backEndJob.setMTYCNTRPERFSearchOptionVO(mTYCNTRPERFSearchOptionVO);
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			return backEndJobManager.execute(backEndJob, account.getUsr_id(),
					"MTY CNTR PFMC by MVMT Daily Trend Retrieve BackEndJob");
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011",
					new String[] { "MTY CNTR PFMC by MVMT Daily Trend Retrieve BackEndJob" }).getMessage(), ex);
		}
	}	
}