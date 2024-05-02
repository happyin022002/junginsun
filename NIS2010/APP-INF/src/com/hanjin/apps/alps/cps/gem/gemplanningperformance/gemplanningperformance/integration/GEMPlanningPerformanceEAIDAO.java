/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : GEMPlanningPerformanceEAIDAO.java
 *@FileTitle : BackEndJob 결과Data조회
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.03
 *@LastModifier : choijungmi
 *@LastVersion : 1.0
 * 2009.07.03
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.List;

import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.DetailRequestExpenseRqstNoVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.DetailRequestExpenseVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.DetailYearlyExpenseVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.ReportAfterClosingVO;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;

/**
 * BackEndJob관련 LoadFile정보를 읽기위한 EAIDAO
 * 
 * @author choijungmi
 * @see GEMPlanningPerformanceEAIDAO
 * @since J2EE 1.4
 */
public class GEMPlanningPerformanceEAIDAO extends EAIDAOSupport {

	/**
	 * CPS_GEM_0019(01)화면의 Detail Yearly Expense의 BackEndJob 처리 결과를 조회
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0019_01
	 * @category getBackEndJobResutYearlyExpense
	 * 
	 * @param key BackEnd실행 key
	 * @return List<DetailYearlyExpenseVO> CPS_GEM_0019_01 VO
	 * @throws Exception
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DetailYearlyExpenseVO> getBackEndJobResutYearlyExpense(String key) throws Exception, DAOException {
		try {
			return (List<DetailYearlyExpenseVO>) BackEndJobResult.loadFromFile(key);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CPS_GEM_0019(02)화면의 Detail Request Expense of Initial의 BackEndJob 처리 결과를 조회
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0019_02
	 * @category getBackEndJobResutRequestExpense
	 * 
	 * @param key BackEnd실행 key
	 * @return List<DetailRequestExpenseVO>  CPS_GEM_0019_02 VO
	 * @throws Exception
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DetailRequestExpenseVO> getBackEndJobResutRequestExpense(String key) throws Exception, DAOException {
		try {
			return (List<DetailRequestExpenseVO>) BackEndJobResult.loadFromFile(key);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CPS_GEM_0019(03)화면의 Detail Request Expense of Initial의 Target이 Detail RQST NO인경우의 BackEndJob 처리 결과를 조회
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0019_03
	 * @category getBackEndJobResutRequestExpenseRqstNo
	 * 
	 * @param key BackEnd실행 key
	 * @return List<DetailRequestExpenseRqstNoVO>  CPS_GEM_0019_03 VO
	 * @throws Exception
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DetailRequestExpenseRqstNoVO> getBackEndJobResutRequestExpenseRqstNo(String key) throws Exception, DAOException {
		try {
			return (List<DetailRequestExpenseRqstNoVO>) BackEndJobResult.loadFromFile(key);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CPS_GEM_0018화면의 Report After Closing의 BackEndJob 처리 결과를 조회
	 * 
	 * @author P.C.J
	 * @category CPS_GEM_0018_01
	 * @category getBackEndJobResutReportAfterClosingAll
	 * 
	 * @param key BackEnd실행 key
	 * @return List<ReportAfterClosingVO>  
	 * @throws Exception
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ReportAfterClosingVO> getBackEndJobResutReportAfterClosingAll(String key) throws Exception, DAOException {
		try {
			return (List<ReportAfterClosingVO>) BackEndJobResult.loadFromFile(key);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}
