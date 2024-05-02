/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BatchHistoryReportBCImpl.java
*@FileTitle : Daily Batch Job Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.batchhistoryreport.basic;

import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.batchhistoryreport.integration.BatchHistoryReportDBDAO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.batchhistoryreport.vo.BatHistParmVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.batchhistoryreport.vo.DmtBatHisVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * DMTPerformanceAnalysis Business Logic Basic Command implementation<br>
 * 
 * @author
 * @see ees_dmt_7007EventResponse,BatchHistoryReportBC DAO class reference
 * @since J2EE 1.4
 */

public class BatchHistoryReportBCImpl extends BasicCommandSupport implements BatchHistoryReportBC {

	// Database Access Object
	private transient BatchHistoryReportDBDAO dbDao = null;

	/**
	 * BatchHistoryReportBCImpl Create object<br>
	 * BatchHistoryReportDBDAO를 Create한다.<br>
	 */
	public BatchHistoryReportBCImpl() {
		dbDao = new BatchHistoryReportDBDAO();
	}
	/** 
	 * @param BatHistParmVO batHistParmVO
	 * @return List<DmtBatHisVO>
	 * @exception EventException
	 */
	public List<DmtBatHisVO> searchBatchHistory(BatHistParmVO batHistParmVO) throws EventException {
		try {
			batHistParmVO.setFmDt(batHistParmVO.getFmDt().replaceAll("-", ""));
			batHistParmVO.setToDt(batHistParmVO.getToDt().replaceAll("-", ""));
			return dbDao.searchBatchHistory(batHistParmVO);
		} catch (DAOException ex) {
			throw new EventException((String)new ErrorHandler("DMT00006", new String[]{"Batch History Report"}).getMessage());
		} catch (Exception ex) {
			throw new EventException((String)new ErrorHandler("DMT00006", new String[]{"Batch History Report"}).getMessage());
		}
	}
}
