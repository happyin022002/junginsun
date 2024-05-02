/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MTYRepositionPerformanceAnalysisBCImpl.java
 *@FileTitle : Repo Result by Port
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.basic;

import java.util.List;

import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.integration.MTYRepositionPerformanceAnalysisDBDAO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.MTYCNTRPERFSearchOptionVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.REPOResultInGeneralVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.REPOResultSearchOptionByLocation;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.REPOResultSearchOptionByPortVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS--CNTROperatioNPerformanceMgt Business Logic Basic Command implementation<br>
 * handling OPUS--CNTROperatioNPerformanceMgt business logic
 * 
 * @author
 * @see EES_CIM_1033EventResponse,MTYRepositionPerformanceAnalysisBC DAO class reference
 * @since J2EE 1.6
 */
public class MTYRepositionPerformanceAnalysisBCImpl extends BasicCommandSupport implements
		MTYRepositionPerformanceAnalysisBC {

	// Database Access Object
	private transient MTYRepositionPerformanceAnalysisDBDAO dbDao = null;

	/**
	 * creating MTYRepositionPerformanceAnalysisBCImpl Object
	 * creating MTYRepositionPerformanceAnalysisDBDAO
	 */
	public MTYRepositionPerformanceAnalysisBCImpl() {
		dbDao = new MTYRepositionPerformanceAnalysisDBDAO();
	}

	/**
	 * retrieving REPOResultByPort
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
	 * retrieving REPOResultByLocation
	 * 
	 * @param rEPOResultSearchOptionByLocation
	 * @return List<REPOResultInGeneralVO>
	 * @exception EventException
	 */
	public List<REPOResultInGeneralVO> searchREPOResultByLocation(
			REPOResultSearchOptionByLocation rEPOResultSearchOptionByLocation) throws EventException {
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
	 * retrieving MTYCNTRPERFByMovementSMRY Tab
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
	 * retrieving MTYCNTRPERFByMovementDTL Tab
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
	 * retrieving MTYCNTRPERFByMovementTrend Tab
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
}