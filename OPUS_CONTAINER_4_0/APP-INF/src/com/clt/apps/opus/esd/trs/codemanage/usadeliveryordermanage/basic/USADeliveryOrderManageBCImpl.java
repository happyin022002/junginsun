/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : USADeliveryOrderManageBCImpl.java
 *@FileTitle : USA Delivery Order Manage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2008-10-20
 *@LastModifier : poong yeon cho
 *@LastVersion : 1.0
 * 2008-10-20 poong yeon cho
 * 1.0 최초 생성
 * -------------------------------------------------------
 * history
 * 2011.07.20 김영철 [CHM-201111871] [TRS] R4J 소스 품질 조치 내역 수정
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.usadeliveryordermanage.basic;

import com.clt.apps.opus.esd.trs.codemanage.usadeliveryordermanage.event.EsdTrs0083Event;
import com.clt.apps.opus.esd.trs.codemanage.usadeliveryordermanage.integration.USADeliveryOrderManageDBDAO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * ENIS-USADeliveryOrderManage Business Logic Basic Command implementation<br>
 * - ENIS-USADeliveryOrderManage에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author poong yeon cho
 * @see GeneralEventResponse,USADeliveryOrderManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class USADeliveryOrderManageBCImpl extends BasicCommandSupport implements USADeliveryOrderManageBC {
	private transient USADeliveryOrderManageDBDAO dbDao = null;

	/**
	 * USADeliveryOrderManageBCImpl 객체 생성<br>
	 * USADeliveryOrderManageDBDAO를 생성한다.<br>
	 */
	public USADeliveryOrderManageBCImpl() {
		dbDao = new USADeliveryOrderManageDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * USADeliveryOrderManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchUSADeliveryOrderManageList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0083Event event = (EsdTrs0083Event) e;
		try {
			eventResponse.setRsVo(dbDao.searchUSADeliveryOrderManageList(event));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * USADeliveryOrderManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchUSADeliveryOrderCheck(Event e) throws EventException {
		EsdTrs0083Event event = (EsdTrs0083Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse.setRsVo(dbDao.searchUSADeliveryOrderCheck(event));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_0083 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e EsdTrs0083Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse multiUSADeliveryOrderManage(Event e) throws EventException {
		EsdTrs0083Event event = (EsdTrs0083Event) e;
		try {
			dbDao.multiUSADeliveryOrderManage(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ESD_TRS_0083 화면에 대한 Consignee조회 이벤트 처리<br>
	 * 
	 * @param e EsdTrs0083Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchUSDeliveryOrderConsigneeManage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0083Event event = (EsdTrs0083Event) e;
		try {
			eventResponse.setRsVo(dbDao.searchUSDeliveryOrderConsigneeManage(event));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * USADeliveryOrderManage 업무 시나리오 마감작업<br>
	 * USADeliveryOrderManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}