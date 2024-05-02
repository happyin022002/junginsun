/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CombinedTransportationCaseTwoSOManageBCImpl.java
*@FileTitle : CY & Door S/O Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.cydoorsomanage.combinedtransportationcasetwosomanage.basic;

import com.clt.apps.opus.esd.trs.cydoorsomanage.combinedtransportationcasetwosomanage.event.EsdTrs0920Event;
import com.clt.apps.opus.esd.trs.cydoorsomanage.combinedtransportationcasetwosomanage.integration.CombinedTransportationCaseTwoSOManageDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;


/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author z_kim_sang_geun
 * @see CombinedTransportationCaseTwoSOManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class CombinedTransportationCaseTwoSOManageBCImpl   extends BasicCommandSupport implements CombinedTransportationCaseTwoSOManageBC
{
	// Database Access Object
	private transient CombinedTransportationCaseTwoSOManageDBDAO dbDao=null;

	/**
	 * CombinedTransportationCaseTwoSOManageBCImpl 객체 생성<br>
	 * CombinedTransportationCaseTwoSOManageDBDAO를 생성한다.<br>
	 */
	public CombinedTransportationCaseTwoSOManageBCImpl(){
		dbDao = new CombinedTransportationCaseTwoSOManageDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * CombinedTransportationCaseTwoSOManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e EsdTrs0920Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchCombinedTransportationCaseTwoSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0920Event event=(EsdTrs0920Event)e;

		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;

		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			rowSet=dbDao.searchCombinedTransportationCaseTwoSOManage(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * CombinedTransportationCaseTwoSOManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e EsdTrs0920Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse search02CombinedTransportationCaseTwoSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0920Event event=(EsdTrs0920Event)e;

		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;

		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			rowSet=dbDao.search02CombinedTransportationCaseTwoSOManage(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;				
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ServiceOfficeCodeSOManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e EsdTrs0920Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse search03ServiceOfficeCodeSOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0920Event event=(EsdTrs0920Event)e;

		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;

		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			rowSet=dbDao.search03ServiceOfficeCodeSOManage(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * CombinedTransportationCaseTwoSOManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}