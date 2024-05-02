/*========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PerformanceReportPFMCbyEstimateBackEndJob.java
*@FileTitle : PerformanceReportPFMCbyEstimateBackEndJob
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.23
*@LastModifier : 조경완 
*@LastVersion : 1.0
* 2013.05.23 조경완	
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.integration.PerformanceReportDBDAO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByESTINVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
				
				
/**
 * ALPS-Performancereport Business Logic Command Interface<br>
 * - ALPS-Performancereport에 대한 비지니스 로직에 대한 BackEndJob 구상클래스<br>
 *
 * @author Kyoung Wan CHO
 * @see Ees_mnr_0121EventResponse 참조
 * @since J2EE 1.6	
 */
public class PerformanceReportPFMCbyEstimateBackEndJob extends BackEndCommandSupport {
	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;		
				
	private PerformanceReportDBDAO dbDao = new PerformanceReportDBDAO();
	
	private String jobType = null;
	
	private RepairPFMCByESTINVO repairPFMCByESTINVO = null;
	
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
			if("SP".equals(repairPFMCByESTINVO.getReportType())){
				list = dbDao.searchRepairPFMCByESTListSPData(repairPFMCByESTINVO);
			}else{ // By Cedex Code
				list = dbDao.searchRepairPFMCByESTListCCData(repairPFMCByESTINVO);
			}
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
	
	public RepairPFMCByESTINVO getRepairPFMCByESTINVO() {
		return repairPFMCByESTINVO;
	}

	public void setRepairPFMCByESTINVO(RepairPFMCByESTINVO repairPFMCByESTINVO) {
		this.repairPFMCByESTINVO = repairPFMCByESTINVO;
	}

	
	public PerformanceReportDBDAO getDbDao() {
		return dbDao;
	}

	public void setDbDao(PerformanceReportDBDAO dbDao) {
		this.dbDao = dbDao;
	}

}
