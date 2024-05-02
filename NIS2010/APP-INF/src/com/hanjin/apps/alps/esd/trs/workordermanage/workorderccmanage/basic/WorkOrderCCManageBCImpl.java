/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderCCManageBCImpl.java
*@FileTitle : Transportation Report & Code
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-07
*@LastModifier : poong_yeon
*@LastVersion : 1.0
* 2006-11-07 poong_yeon
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderccmanage.basic;

import com.hanjin.apps.alps.esd.trs.workordermanage.workorderccmanage.event.EsdTrs0072Event;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderccmanage.integration.WorkOrderCCManageDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ESD-WorkOrderManage Business Logic Basic Command implementation<br>
 * - ESD-WorkOrderManage에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author poong_yeon
 * @see ESD_TRS_072EventResponse,WorkOrderCCManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class WorkOrderCCManageBCImpl   extends BasicCommandSupport implements WorkOrderCCManageBC {

	// Database Access Object
	private transient WorkOrderCCManageDBDAO dbDao=null;

	/**
	 * WorkOrderCCManageBCImpl 객체 생성<br>
	 * WorkOrderCCManageDBDAO를 생성한다.<br>
	 */
	public WorkOrderCCManageBCImpl(){
		dbDao = new WorkOrderCCManageDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderCCManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return 
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderCCManageList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0072Event event=(EsdTrs0072Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		try {
			rowSet=dbDao.searchWorkOrderCCManageList(event);
			
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
	 * WorkOrderCCManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_072Event
	 * @return EventResponse ESD_TRS_072EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderCCFaxList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0072Event event=(EsdTrs0072Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		try {
			rowSet=dbDao.searchWorkOrderCCFaxList(event);
			
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
	 * WorkOrderCCManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_072Event
	 * @return EventResponse ESD_TRS_072EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderCCEmailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0072Event event=(EsdTrs0072Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		try {
			rowSet=dbDao.searchWorkOrderCCEmailList(event);
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);

			return eventResponse;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_072 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_072Event
	 * @return EventResponse ESD_TRS_072EventResponse
	 * @exception EventException
	 */
	public EventResponse multiWorkOrderCCManageList(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0072Event event=(EsdTrs0072Event)e;		
		try {
			dbDao.multiWorkOrderCCManageList(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * WorkOrderManage 업무 시나리오 마감작업<br>
	 * WorkOrderCCManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}