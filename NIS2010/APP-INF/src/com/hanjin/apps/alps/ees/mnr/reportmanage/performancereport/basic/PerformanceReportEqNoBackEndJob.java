/*========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PerformanceReportBackEndJob.java
*@FileTitle : PerformanceReportBackEndJob
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.29
*@LastModifier : 박명신 
*@LastVersion : 1.0
* 2010.09.29 박명신	
* 1.0 Creation
* 2011.03.02 김영오 [CHM-201108369] M&R PFMC by Eq No  신규화면 개발
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.integration.PerformanceReportDBDAO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByEqNoINVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
				
				
/**
 * ALPS-Performancereport Business Logic Command Interface<br>
 * - ALPS-Performancereport에 대한 비지니스 로직에 대한 BackEndJob 구상클래스<br>
 *
 * @author Young Oh Kim
 * @see Ees_mnr_0115EventResponse 참조
 * @since J2EE 1.6	
 */
public class PerformanceReportEqNoBackEndJob extends BackEndCommandSupport {
	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;		
				
	private PerformanceReportDBDAO dbDao = new PerformanceReportDBDAO();
	
	private String jobType = null;

	private RepairPFMCByEqNoINVO repairPFMCByEqNoINVO = null;
	
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
			list = dbDao.searchRepairPFMCByEqNoListCCData(repairPFMCByEqNoINVO);
		} catch (DAOException ex) {	
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}	

		return list;
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
	
	
	public PerformanceReportDBDAO getDbDao() {
		return dbDao;
	}

	public void setDbDao(PerformanceReportDBDAO dbDao) {
		this.dbDao = dbDao;
	}

	public RepairPFMCByEqNoINVO getRepairPFMCByEqNoINVO() {
		return repairPFMCByEqNoINVO;
	}

	public void setRepairPFMCByEqNoINVO(RepairPFMCByEqNoINVO repairPFMCByEqNoINVO) {
		this.repairPFMCByEqNoINVO = repairPFMCByEqNoINVO;
	}
}
