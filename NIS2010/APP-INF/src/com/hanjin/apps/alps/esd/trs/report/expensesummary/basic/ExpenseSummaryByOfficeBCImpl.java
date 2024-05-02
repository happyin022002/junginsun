/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ExpenseSummaryByOfficeBCImpl.java
*@FileTitle : Expense Summary by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009-02-27 
*@LastModifier : ah young Han
*@LastVersion : 1.0
* 2009-01-08 ah young Han
* 1.0 최초 생성
* N200901080024  2009-02-27 'Report(Expense Summary by Office) 메뉴 개발 요청 ' 
* 2013.08.22 조인영 [CHM-201326241] [TRS] Report data 개수 표시
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.expensesummary.basic;

import java.sql.SQLException;

import com.hanjin.apps.alps.esd.trs.report.expensesummary.event.EsdTrs0104Event;
import com.hanjin.apps.alps.esd.trs.report.expensesummary.integration.ExpenseSummaryByOfficeDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;



/**
 * ENIS-Transportation S/O Business Logic Basic Command implementation<br>
 * - ENIS-Transportation S/O에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author ah young Han
 * @see ESD_TRS_104EventResponse,ExpenseSummaryByOfficeBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class ExpenseSummaryByOfficeBCImpl extends BasicCommandSupport implements ExpenseSummaryByOfficeBC {
 
//	 Database Access Object
	private transient ExpenseSummaryByOfficeDBDAO dbDao=null;

	/**
	 * ExpenseSummaryBCImpl 객체 생성<br>
	 * ExpenseSummaryBySpDBDAO를 생성한다.<br>
	 */  
	public ExpenseSummaryByOfficeBCImpl(){
		dbDao = new ExpenseSummaryByOfficeDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ExpenseSummary화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e EsdTrs0104Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchExpenseSummaryByOffice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0104Event event=(EsdTrs0104Event)e;
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.searchExpenseSummaryByOffice(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	
	/**
	 * 조회 이벤트 처리<br>
	 * ExpenseSummary화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0104Event
	 * @return EventResponse ESD_TRS_0104EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOfficeCount(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0104Event event=(EsdTrs0104Event)e;
		FormCommand formcommand = e.getFormCommand();	//ETC DATA를 위해서 필요
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.searchOfficeCount(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
			if(formcommand.isCommand(FormCommand.SEARCH02)){
				if(rowSet.next()){		
					eventResponse.setETCData("cnt", 			rowSet.getString("cnt"));
				}
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
	 * ExpenseSummary 업무 시나리오 마감작업<br>
	 * ExpenseSummary업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}