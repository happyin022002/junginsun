/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : GEMReportAfterClosingBackEndBCImpl.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 
 * 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.basic;

import java.util.List;

import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.integration.GEMPlanningPerformanceDBDAO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.ReportAfterClosingVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.RqstInfoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;

/**
 * CPS_GEM_0018화면에 관련한 BACKEND에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author P.C.J
 * @see UI_GEM_0018EventResponse,GEMPlanningPerformanceBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class GEMReportAfterClosingBackEndJob extends BackEndCommandSupport {
	
	private static final long serialVersionUID = -8569053557386320221L;
	
	/**
	 * Backend job을 위한 DAO
	 */
	private GEMPlanningPerformanceDBDAO dbDao;

	private RqstInfoVO rqstInfoVO;
	
	public void setRqstInfoVO(RqstInfoVO rqstInfoVO) {
		this.rqstInfoVO = rqstInfoVO;
	}

	// ===========================================================================
	// P.C.J
	// ===========================================================================

	// ---------------------------------------------------------------------------
	// [CPS_GEM_0018] Summary_After Closing
	// ---------------------------------------------------------------------------

	/**
	 * CPS_GEM_0018_01화면의 DownExcel클릭시 Report After Closing 검색관련 조회.
	 * 
	 * @author P.C.J
	 * @category CPS_GEM_0018_01
	 * @category doStart	 
	 * @return List<ReportAfterClosingVO>
	 * @exception EventException
	 */
	@Override
	public List<ReportAfterClosingVO> doStart() throws Exception {
		this.dbDao = new GEMPlanningPerformanceDBDAO();
		try {			
			return dbDao.searchReportAfterClosingAll(this.rqstInfoVO);						
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
}