/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : GEMDetailYearlyExpenseBackEndBCImpl.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 
 * 
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.basic;

import java.util.List;

import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration.GEMPlanningPerformanceDBDAO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.DetailYearlyExpenseVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.SearchYearlyExpenseVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 * CPS_GEM_0019화면에 관련한 BACKEND에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author choijungmi
 * @see UI_GEM_0019EventResponse,GEMPlanningPerformanceBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class GEMDetailYearlyExpenseBackEndJob extends BackEndCommandSupport {
	
	private static final long serialVersionUID = -8569053557386320221L;
	
	/**
	 * Backend job을 위한 DAO
	 */
	private GEMPlanningPerformanceDBDAO dbDao;
	
	/**
     * GEMPlanningPerformanceBCImpl 객체 생성<br>
     * GEMPlanningPerformanceDBDAO 생성한다.<br>
     */
    public GEMDetailYearlyExpenseBackEndJob() {
        dbDao = new GEMPlanningPerformanceDBDAO();
    }

    private SearchYearlyExpenseVO searchYearlyExpenseVO;
	
	public void setSearchYearlyExpenseVO(SearchYearlyExpenseVO searchYearlyExpenseVO) {
		this.searchYearlyExpenseVO = searchYearlyExpenseVO;
	}

	// ===========================================================================
	// C.J.M
	// ===========================================================================

	// ---------------------------------------------------------------------------
	// [CPS_GEM_0019] Detail_Yearly Expense
	// ---------------------------------------------------------------------------

	/**
	 * CPS_GEM_0019화면의 DownExcel클릭시 Yearly Expense 검색관련 조회.
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0019
	 * @category doStart
	 * @return List<DetailYearlyExpenseVO>
	 * @exception EventException
	 */
	@Override
	public List<DetailYearlyExpenseVO> doStart() throws Exception {
		this.dbDao = new GEMPlanningPerformanceDBDAO();
		try {			
			return dbDao.searchDetailByYearlyExpense(this.searchYearlyExpenseVO);						
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
}