/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PendingListBCImpl.java
*@FileTitle : Pending List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-01
*@LastModifier : kimjin
*@LastVersion : 1.0
* 2009-10-01 kimjin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.chanalysis.basic;

import java.sql.SQLException;

import com.hanjin.apps.alps.esd.trs.report.chanalysis.event.EsdTrs0101Event;
import com.hanjin.apps.alps.esd.trs.report.chanalysis.integration.ChAnalysisReportDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;


/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author kimjin
 * @see ESD_TRS_001EventResponse,PendingListBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ChAnalysisReportBCImpl extends BasicCommandSupport implements ChAnalysisReportBC {
			 
	// Database Access Object
	private transient ChAnalysisReportDBDAO dbDao=null;

	/**
	 * PendingListBCImpl 객체 생성<br>
	 * PendingListDBDAO를 생성한다.<br>
	 */
	public ChAnalysisReportBCImpl(){
		dbDao = new ChAnalysisReportDBDAO();
	}
		

	/**
	 * 조회 이벤트 처리<br>
	 * PendingList화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_001EventResponse
	 * @exception EventException
	 */
	public EventResponse searchChAnalysis(Event e) throws EventException {
		EsdTrs0101Event event	= (EsdTrs0101Event)e;
		DBRowSet rowSet			= null; 
		
		try {
			rowSet = dbDao.searchChAnalysis(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 *  vvd체크  이벤트 처리<br>
	 * PendingList화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_001EventResponse
	 * @exception EventException
	 */
	public EventResponse search_vvd(Event e) throws EventException {
		EsdTrs0101Event event 	= (EsdTrs0101Event)e;
		DBRowSet rowSet 		= null; 
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			rowSet=dbDao.search_vvd(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
//			return new EsdTrs0101EventResponse(rowSet,"SUCCESS");
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 *  vvd체크  이벤트 처리<br>
	 * PendingList화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_001EventResponse
	 * @exception EventException
	 */
	public EventResponse search_ofc(Event e) throws EventException {
		EsdTrs0101Event event	= (EsdTrs0101Event)e;
		DBRowSet rowSet			= null; 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			rowSet=dbDao.search_ofc(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
//			return new EsdTrs0101EventResponse(rowSet,"SUCCESS");
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 *  vvd체크  이벤트 처리<br>
	 * PendingList화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_001EventResponse
	 * @exception EventException
	 */
	public EventResponse weekDate(Event e) throws EventException {
		EsdTrs0101Event event=(EsdTrs0101Event)e;
		DBRowSet rowSet=null; 
		
		try {
			rowSet=dbDao.weekDate(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			if(rowSet.next()){
				eventResponse.setETCData("fm_dt", rowSet.getString("FM_DT"));
				eventResponse.setETCData("to_dt", rowSet.getString("TO_DT"));
			}

			return eventResponse;			
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
	}		
	
	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * PendingList업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}