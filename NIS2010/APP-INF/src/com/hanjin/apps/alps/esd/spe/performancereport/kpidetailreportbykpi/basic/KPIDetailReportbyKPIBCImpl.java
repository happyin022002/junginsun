/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : KPIDetailReportbyKPIBCImpl.java
*@FileTitle : KPI Detail Report by KPI
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancereport.kpidetailreportbykpi.basic;

import java.util.ArrayList;
import java.util.List;
import com.hanjin.apps.alps.esd.spe.performancereport.kpidetailreportbykpi.integration.KPIDetailReportbyKPIDBDAO;
import com.hanjin.apps.alps.esd.spe.performancereport.kpidetailreportbykpi.vo.KPIDetailReportVO;
import com.hanjin.apps.alps.esd.spe.performancereport.paresultdetaibysp.vo.PAResultDetaibySPVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-PerformanceReport Business Logic Command Interface<br>
 * - ALPS-PerformanceReport에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HI
 * @see
 * @since J2EE 1.6
 */
public class KPIDetailReportbyKPIBCImpl extends BasicCommandSupport implements KPIDetailReportbyKPIBC {

	// Database Access Object
	private transient KPIDetailReportbyKPIDBDAO dbDao = null;

	/**
	 * KPIDetailReportbyKPIBCImpl 객체 생성<br>
	 * KPIDetailReportbyKPIDBDAO를 생성한다.<br>
	 */
	public KPIDetailReportbyKPIBCImpl() {
		dbDao = new KPIDetailReportbyKPIDBDAO();
	}

	/**
	 * KPI Detail Report by KPI 데이터를 조회한다.<br>
	 * 
	 * @param KPIDetailReportVO kPIDetailReportVO
	 * @return List<PAResultDetaibySPVO>
	 * @exception EventException
	 */
	public List<KPIDetailReportVO> searchKPIDetailReport(KPIDetailReportVO kPIDetailReportVO)throws EventException{
		try {
			return dbDao.searchKPIDetailReport(kPIDetailReportVO);
		} catch(DAOException ex) {
 			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}		
	
}