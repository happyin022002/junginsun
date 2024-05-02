/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : PreDispatchStatusBCImpl.java
*@FileTitle : Pre-Dispatch Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-19
*@LastModifier : kim_sang_geun
*@LastVersion : 1.0
* 2006-12-19 kim_sang_geun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.predispatchstatus.basic;

import com.hanjin.apps.alps.esd.trs.workordermanage.predispatchstatus.event.EsdTrs0020Event;
import com.hanjin.apps.alps.esd.trs.workordermanage.predispatchstatus.integration.PreDispatchStatusDBDAO;
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
 * @see ESD_TRS_020EventResponse,PreDispatchStatusBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class PreDispatchStatusBCImpl   extends BasicCommandSupport implements PreDispatchStatusBC {

	// Database Access Object
	private transient PreDispatchStatusDBDAO dbDao=null;

	/**
	 * PreDispatchStatusBCImpl 객체 생성<br>
	 * PreDispatchStatusDBDAO를 생성한다.<br>
	 */
	public PreDispatchStatusBCImpl(){
		dbDao = new PreDispatchStatusDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * PreDispatchStatus화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_020Event
	 * @return EventResponse ESD_TRS_020EventResponse
	 * @exception EventException
	 */
	public EventResponse searchPreDispatchStatus(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0020Event event=(EsdTrs0020Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.searchPreDispatchStatus(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * PreDispatchStatus화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_020Event
	 * @return EventResponse ESD_TRS_020EventResponse
	 * @exception EventException
	 */
	public EventResponse search01PreDispatchStatus(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0020Event event=(EsdTrs0020Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.search01PreDispatchStatus(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * PreDispatchStatus업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}