/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BatchHistoryReportBCImpl.java
*@FileTitle : Daily Batch Job Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.05.12 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.batchhistoryreport.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.batchhistoryreport.integration.BatchHistoryReportDBDAO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.batchhistoryreport.vo.BatHistParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.batchhistoryreport.vo.DmtBatHisVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * NIS2010-DMTPerformanceAnalysis Business Logic Basic Command implementation<br>
 * - NIS2010-DMTPerformanceAnalysis에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Choi Sung Hwan
 * @see ees_dmt_7007EventResponse,BatchHistoryReportBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class BatchHistoryReportBCImpl extends BasicCommandSupport implements BatchHistoryReportBC {

	// Database Access Object
	private transient BatchHistoryReportDBDAO dbDao = null;

	/**
	 * BatchHistoryReportBCImpl 객체 생성<br>
	 * BatchHistoryReportDBDAO를 생성한다.<br>
	 */
	public BatchHistoryReportBCImpl() {
		dbDao = new BatchHistoryReportDBDAO();
	}
	/**
	 * 각 지역 서버별로 배치 이력을 조회 한다<br>
	 *  BatchHistoryReport화면에 대한 조회 이벤트 처리<br>
	 * 
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