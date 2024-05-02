/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ExpenseSummaryBCImpl.java
*@FileTitle : Expense Summary by S/P
*Open Issues :
*Change history :
*@LastModifyDate : 2009-01-07
*@LastModifier : jh choi
*@LastVersion : 1.0
* 2009-01-07 jh choi
* 1.0 최초 생성
* @history
* N200901080023 2009-03-04 Expense Summary Report S/P 메뉴개발
* 2013.08.22 조인영 [CHM-201326241] [TRS] Report data 개수 표시
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.expensesummary.basic;

import java.sql.SQLException;

import com.hanjin.apps.alps.esd.trs.report.expensesummary.event.EsdTrs0105Event;
import com.hanjin.apps.alps.esd.trs.report.expensesummary.event.EsdTrs0107Event;
import com.hanjin.apps.alps.esd.trs.report.expensesummary.integration.ExpenseSummaryBySpDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;



/**
 * ENIS-ExpenseSummary Business Logic Basic Command implementation<br>
 * - ENIS-ExpenseSummary에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author poong yeon cho
 * @see ESD_TRS_105EventResponse,ExpenseSummaryBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class ExpenseSummaryBySpBCImpl   extends BasicCommandSupport implements ExpenseSummaryBySpBC {

	// Database Access Object
	private transient ExpenseSummaryBySpDBDAO dbDao=null;

	/**
	 * ExpenseSummaryBCImpl 객체 생성<br>
	 * ExpenseSummaryBySpDBDAO를 생성한다.<br>
	 */
	public ExpenseSummaryBySpBCImpl(){
		dbDao = new ExpenseSummaryBySpDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ExpenseSummary화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_105Event
	 * @return EventResponse ESD_TRS_105EventResponse
	 * @exception EventException
	 */
	public EventResponse searchExpenseSummary(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0105Event event=(EsdTrs0105Event)e;
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.searchExpenseSummary(event);
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
	 * ExpenseSummary화면에서 Parent S/P 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_105Event
	 * @return EventResponse ESD_TRS_105EventResponse
	 * @exception EventException
	 */
	public EventResponse searchParentSP(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0105Event event=(EsdTrs0105Event)e;
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.searchParentSP(event);
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
	 * ExpenseDetail화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_105Event
	 * @return EventResponse ESD_TRS_105EventResponse
	 * @exception EventException
	 */
	public EventResponse searchExpenseDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0107Event event=(EsdTrs0107Event)e;
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.searchExpenseDetail(event);
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
	 * ExpenseDetail화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0107Event
	 * @return EventResponse ESD_TRS_0107EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDetailCount(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0107Event event=(EsdTrs0107Event)e;
		FormCommand formcommand = e.getFormCommand();	//ETC DATA를 위해서 필요
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.searchDetailCount(event);
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
	 * 조회 이벤트 처리<br>
	 * ExpenseSummary화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0105Event
	 * @return EventResponse ESD_TRS_0105EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSummaryCount(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0105Event event=(EsdTrs0105Event)e;
		FormCommand formcommand = e.getFormCommand();	//ETC DATA를 위해서 필요
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.searchSummaryCount(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
			if(formcommand.isCommand(FormCommand.SEARCH03)){
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