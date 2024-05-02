/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DeliveryMonitorBCImpl.java
*@FileTitle : Delivery Monitoring
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.deliverymonitor.basic;

import com.hanjin.apps.alps.esd.trs.report.deliverymonitor.event.EsdTrs0260Event;
import com.hanjin.apps.alps.esd.trs.report.deliverymonitor.event.EsdTrs0270Event;
import com.hanjin.apps.alps.esd.trs.report.deliverymonitor.integration.DeliveryMonitorDBDAO;
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
 * @author 
 * @see ESD_TRS_0260EventResponse,DistanceCreationBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class DeliveryMonitorBCImpl   extends BasicCommandSupport implements DeliveryMonitorBC {

	// Database Access Object
	private transient DeliveryMonitorDBDAO dbDao=null;

	/**
	 * DeliveryMonitorBCImpl 객체 생성<br>
	 * DeliveryMonitorDBDAO 생성한다.<br>
	 */
	public DeliveryMonitorBCImpl(){
		dbDao = new DeliveryMonitorDBDAO();
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Delivery Monitoring화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0260Event
	 * @return EventResponse ESD_TRS_0260EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDelivery(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0260Event event=(EsdTrs0260Event)e;
		
		try {
			rowSet=dbDao.searchDelivery(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 *  Delivery Monitoring Detail화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0270Event
	 * @return EventResponse ESD_TRS_0270EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDeliveryDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdTrs0270Event event=(EsdTrs0270Event)e;
		
		try {
			rowSet=dbDao.searchDeliveryDetail(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	
	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * DistanceCreation업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}