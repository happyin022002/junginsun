/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : DistanceCreationBCImpl.java
*@FileTitle : Distance Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.17
*@LastModifier : 최 선
*@LastVersion : 1.1
* 2006.10.31 juhyun
* 1.0 최초 생성
* --------------------------------------------------------
* History
* 2010.09.17 최 선  1.1 [] SAVE시, Distance 중복 등록  현상 처리
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.distancecreation.basic;

import java.sql.SQLException;

import com.hanjin.apps.alps.esd.trs.codemanage.distancecreation.event.EsdTrs0080Event;
import com.hanjin.apps.alps.esd.trs.codemanage.distancecreation.integration.DistanceCreationDBDAO;
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
 * @author juhyun
 * @see ESD_TRS_0080EventResponse,DistanceCreationBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class DistanceCreationBCImpl   extends BasicCommandSupport implements DistanceCreationBC {

	// Database Access Object
	private transient DistanceCreationDBDAO dbDao=null;

	/**
	 * DistanceCreationBCImpl 객체 생성<br>
	 * DistanceCreationDBDAO를 생성한다.<br>
	 */
	public DistanceCreationBCImpl(){
		dbDao = new DistanceCreationDBDAO();
	}


	/**
	 * 조회 이벤트 처리<br>
	 * DistanceCreation화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0080Event
	 * @return EventResponse ESD_TRS_0080EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDistanceCreation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0080Event event=(EsdTrs0080Event)e;
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.searchDistanceCreation(event);
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
	 * DistanceCreation화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0080Event
	 * @return EventResponse ESD_TRS_0080EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDistanceHistory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0080Event event=(EsdTrs0080Event)e;
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.searchDistanceHistory(event);
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
	 * DistanceCreation화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0080Event
	 * @return EventResponse ESD_TRS_0080EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDistanceCreationDuple(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0080Event event=(EsdTrs0080Event)e;
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.searchDistanceCreationDuple(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			
			if(rowSet.next()){
				eventResponse.setETCData("CNT_CD", rowSet.getString("duple2"));
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
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_0080 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0080Event
	 * @return EventResponse ESD_TRS_0080EventResponse
	 * @exception EventException
	 */
	public EventResponse multiDistanceCreation(Event e) throws EventException{    
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0080Event event=(EsdTrs0080Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			dbDao.multiTRS_AGMT_DIST(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_0080 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0080Event
	 * @return EventResponse ESD_TRS_0080EventResponse
	 * @exception EventException
	 */
	public EventResponse multiDistanceCreationhis(Event e) throws EventException{    
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0080Event event=(EsdTrs0080Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			dbDao.multiTRS_AGMT_DIST_HIS(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_0080 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0080Event
	 * @return EventResponse ESD_TRS_0080EventResponse
	 * @exception EventException
	 */
	public EventResponse multiDistanceDelete(Event e) throws EventException{ 
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0080Event event=(EsdTrs0080Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			dbDao.multiDistanceDelete(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * DistanceCreation업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}