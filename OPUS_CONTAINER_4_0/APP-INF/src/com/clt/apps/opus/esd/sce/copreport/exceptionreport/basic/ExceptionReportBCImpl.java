/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : COPHistoryBCImpl.java
*@FileTitle : COP History Search
*Open Issues :
*Change history :
*2008-07-01: rowSize추가
*@LastModifyDate : 2008-07-01
*@LastModifier : Hun-Il Jung
*@LastVersion : 1.3
* 2008-03-03 minestar
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.copreport.exceptionreport.basic;

import com.clt.apps.opus.esd.sce.copreport.exceptionreport.integration.ExceptionReportDBDAO;
import com.clt.apps.opus.esd.sce.copreport.exceptionreport.vo.SearchNotifyFailureVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * SCE Business Logic Basic Command implementation<br>
 * - SCE에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author minestar
 * @see EsdSce001EventResponse,COPManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class ExceptionReportBCImpl   extends BasicCommandSupport implements ExceptionReportBC {

    // Database Access Object
    private transient ExceptionReportDBDAO dbDao = null;

    /**
     * ExceptionReportBCImpl 객체 생성<br>
     */
    public ExceptionReportBCImpl(){
        dbDao = new ExceptionReportDBDAO();
    }
    /**
     * Exception_Notification Failure Report 을 조회한다.
     * @param  SearchNotifyFailureVO searchNotifyFailureVO
     * @return EventResponse
     * @exception EventException
     */
	public EventResponse notificationFailure(SearchNotifyFailureVO searchNotifyFailureVO) throws EventException {

		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
        int cnt = 0;
		try {
			cnt    = dbDao.searchNotifyFailureCount(searchNotifyFailureVO);
            rowSet = dbDao.searchNotifyFailure(searchNotifyFailureVO);
            
            rowSet.setMaxRows(cnt); 
            GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	
}
