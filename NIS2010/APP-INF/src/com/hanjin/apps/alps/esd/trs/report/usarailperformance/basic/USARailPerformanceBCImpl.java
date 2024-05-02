/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : USA Rail PerformanceBCImpl.java
*@FileTitle : USA Rail Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2011-06-10
*@LastModifier : 김종호
*@LastVersion : 1.10
* 2007-12-19 Jun Ho Kim
* 1.0 최초 생성
* 1.10 2011.06.10 김종호 [CHM-201110817] [TRS] US Rail report 기능 보완 / 추가 요청
* 2013.05.15 조인영 [CHM-201324500] Rail performance report by SO (NYCNA) domestic data 추가
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.usarailperformance.basic;

import com.hanjin.apps.alps.esd.trs.report.usarailperformance.event.EsdTrs0102Event;
import com.hanjin.apps.alps.esd.trs.report.usarailperformance.event.EsdTrs0103Event;
import com.hanjin.apps.alps.esd.trs.report.usarailperformance.integration.USARailPerformanceDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;


/**
 * ENIS-USA Rail Performance Business Logic Basic Command implementation<br>
 * - ENIS-USA Rail Performance에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Jun Ho Kim
 * @see ESD_TRS_102EventResponse,USA Rail PerformanceBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class USARailPerformanceBCImpl  extends BasicCommandSupport implements USARailPerformanceBC {

	// Database Access Object
	private transient USARailPerformanceDBDAO dbDao=null;

	/**
	 * USA Rail PerformanceBCImpl 객체 생성<br>
	 * USA Rail PerformanceDBDAO를 생성한다.<br>
	 */
	public USARailPerformanceBCImpl(){
		dbDao = new USARailPerformanceDBDAO(); 
	}

	/**
	 * 조회 이벤트 처리<br>
	 * USA Rail Performance화면에 대한 조회 이벤트 처리<br>
	 * SEN - Invoice별, Lane/VVD checked
	 * 
	 * @param e
	 * @return response ESD_TRS_102EventResponse
	 * @exception EventException
	 */
	public EventResponse searchENISInvRailPerformanceByLaneVvd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0102Event event=(EsdTrs0102Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchENISInvRailPerformanceByLaneVvd(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * USA Rail Performance화면에 대한 조회 이벤트 처리<br>
	 * SEN - Invoice별, Lane/VVD Unchecked
	 * 
	 * @param e
	 * @return response ESD_TRS_102EventResponse
	 * @exception EventException
	 */
	public EventResponse searchENISInvRailPerformance(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0102Event event=(EsdTrs0102Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchENISInvRailPerformance(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * USA Rail Performance화면에 대한 조회 이벤트 처리<br>
	 * HJS - SO (Vendor별), Lane/VVD checked
	 * 
	 * @param e
	 * @return response ESD_TRS_102EventResponse
	 * @exception EventException
	 */
	public EventResponse searchENISSOCRailPerformanceByLaneVvd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0103Event event=(EsdTrs0103Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchENISSOCRailPerformanceByLaneVvd(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * USA Rail Performance화면에 대한 조회 이벤트 처리<br>
	 * HJS - SO (Route별), Lane/VVD checked
	 * 
	 * @param e
	 * @return response ESD_TRS_102EventResponse
	 * @exception EventException
	 */
	public EventResponse searchENISSORRailPerformanceByLaneVvd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0103Event event=(EsdTrs0103Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchENISSORRailPerformanceByLaneVvd(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * USA Rail Performance화면에 대한 조회 이벤트 처리<br>
	 * HJS - SO (Vendor별), Lane/VVD Unchecked
	 * 
	 * @param e
	 * @return response ESD_TRS_102EventResponse
	 * @exception EventException
	 */
	public EventResponse searchENISSOCRailPerformance(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0103Event event=(EsdTrs0103Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchENISSOCRailPerformance(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * USA Rail Performance화면에 대한 조회 이벤트 처리<br>
	 * HJS - SO (Route별), Lane/VVD Unchecked
	 * 
	 * @param e
	 * @return response ESD_TRS_102EventResponse
	 * @exception EventException
	 */
	public EventResponse searchENISSORRailPerformance(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0103Event event=(EsdTrs0103Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchENISSORRailPerformance(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * USA Rail Performance화면에 대한 조회 이벤트 처리<br>
	 * SEN - SO (Vendor별)
	 * 
	 * @param e
	 * @return response ESD_TRS_102EventResponse
	 * @exception EventException
	 */
	public EventResponse searchNISSOCRailPerformance(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0103Event event=(EsdTrs0103Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchNISSOCRailPerformance(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * USA Rail Performance화면에 대한 조회 이벤트 처리<br>
	 * SEN - SO (Route별)
	 * 
	 * @param e
	 * @return response ESD_TRS_102EventResponse
	 * @exception EventException
	 */
	public EventResponse searchNISSORRailPerformance(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0103Event event=(EsdTrs0103Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchNISSORRailPerformance(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}

	
	/**
	 * 조회 이벤트 처리<br>
	 * USA Rail Performance화면에 대한 조회 이벤트 처리<br>
	 * ALL - SO (Route별), Lane/VVD checked
	 * 
	 * @param e
	 * @return response ESD_TRS_102EventResponse
	 * @exception EventException
	 */
	public EventResponse searchALLSORRailPerformanceByLaneVvd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0103Event event=(EsdTrs0103Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchALLSORRailPerformanceByLaneVvd(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * USA Rail Performance화면에 대한 조회 이벤트 처리<br>
	 * ALL - SO (Route별), Lane/VVD unchecked
	 * 
	 * @param e
	 * @return response ESD_TRS_102EventResponse
	 * @exception EventException
	 */
	public EventResponse searchALLSORRailPerformance(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0103Event event=(EsdTrs0103Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchALLSORRailPerformance(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * USA Rail Performance화면에 대한 조회 이벤트 처리<br>
	 * ALL - SO (Vendor별), Lane/VVD checked
	 * 
	 * @param e
	 * @return response ESD_TRS_102EventResponse
	 * @exception EventException
	 */
	public EventResponse searchALLSOCRailPerformanceByLaneVvd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0103Event event=(EsdTrs0103Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchALLSOCRailPerformanceByLaneVvd(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * USA Rail Performance화면에 대한 조회 이벤트 처리<br>
	 * ALL - SO (Vendor별), Lane/VVD unchecked
	 * 
	 * @param e
	 * @return response ESD_TRS_102EventResponse
	 * @exception EventException
	 */
	public EventResponse searchALLSOCRailPerformance(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0103Event event=(EsdTrs0103Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchALLSOCRailPerformance(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	/**
	 * USA Rail Performance 업무 시나리오 마감작업<br>
	 * USA Rail Performance업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}