/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ContainerSelectPopupBCImpl.java
*@FileTitle : Empty Repo & S/T On/Off Hire S/O Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : kim_sang_geun
*@LastVersion : 1.0
* 2006-10-31 kim_sang_geun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.containerselectpopup.basic;

import com.hanjin.apps.alps.esd.trs.common.containerselectpopup.event.EsdTrs0908Event;
import com.hanjin.apps.alps.esd.trs.common.containerselectpopup.integration.ContainerSelectPopupDBDAO;
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
 * @author kim_sang_geun
 * @see ESD_TRS_908EventResponse,ContainerSelectPopupBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class ContainerSelectPopupBCImpl   extends BasicCommandSupport implements ContainerSelectPopupBC {

	// Database Access Object
	private transient ContainerSelectPopupDBDAO dbDao=null;

	/**
	 * ContainerSelectPopupBCImpl 객체 생성<br>
	 * ContainerSelectPopupDBDAO를 생성한다.<br>
	 */
	public ContainerSelectPopupBCImpl(){
		dbDao = new ContainerSelectPopupDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ContainerSelectPopup화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_908Event
	 * @return EventResponse ESD_TRS_908EventResponse
	 * @exception EventException
	 */
	public EventResponse searchContainerSelectPopup(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0908Event event=(EsdTrs0908Event)e;
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.searchContainerSelectPopup(event);
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
	 * ContainerSelectPopup화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_908Event
	 * @return EventResponse ESD_TRS_908EventResponse
	 * @exception EventException
	 */
	public EventResponse searchContainerSelectMainList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0908Event event=(EsdTrs0908Event)e;
		
		try {
			
//			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			
			return  dbDao.searchContainerSelectMainList(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ContainerSelectPopup화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_908Event
	 * @return EventResponse ESD_TRS_908EventResponse
	 * @exception EventException
	 */
	public EventResponse searchContainerSelectReplaceTPSZList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0908Event event=(EsdTrs0908Event)e;
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet dRs =null;
		
		try {
			dRs=dbDao.searchContainerSelectReplaceTPSZList(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(dRs);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ContainerSelectPopup화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_908Event
	 * @return EventResponse ESD_TRS_908EventResponse
	 * @exception EventException
	 */
	public EventResponse searchContainerSelectSubList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0908Event event=(EsdTrs0908Event)e;
		try {
			return dbDao.searchContainerSelectSubList(event);
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ContainerSelectPopup화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_908Event
	 * @return EventResponse ESD_TRS_908EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSplitBkgList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0908Event event=(EsdTrs0908Event)e;
		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.searchSplitBkgList(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			return eventResponse;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	

	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * ContainerSelectPopup업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}