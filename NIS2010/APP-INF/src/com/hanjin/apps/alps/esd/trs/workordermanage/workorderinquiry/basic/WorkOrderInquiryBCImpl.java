/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderInquiryBCImpl.java
*@FileTitle : W/O 발행내역을 조회하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-26
*@LastModifier : poong_yeon
*@LastVersion : 1.0
* 2006-12-26 poong_yeon
* 1.0 최초 생성
* 2015.07.20 9014787 [CHM-201536387] ALPS Auth 사후 결재 기능 개발
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderinquiry.basic;

import com.hanjin.apps.alps.esd.trs.workordermanage.workorderinquiry.event.EsdTrs0025Event;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderinquiry.event.EsdTrs0939Event;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderinquiry.integration.WorkOrderInquiryDBDAO;
import com.hanjin.bizcommon.approval.event.ComEns0U1Event;
import com.hanjin.bizcommon.approval.event.ComEns0U2Event;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
//import com.hanjin.syscommon.common.table.TRS_TRSP_WRK_ORD;


/**
 * ESD-workordermanage Business Logic Basic Command implementation<br>
 * - ESD-workordermanage에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author poong_yeon
 * @see ESD_TRS_025EventResponse,WorkOrderInquiryBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class WorkOrderInquiryBCImpl   extends BasicCommandSupport implements WorkOrderInquiryBC {

	// Database Access Object
	private transient WorkOrderInquiryDBDAO dbDao=null;

	/**
	 * WorkOrderInquiryBCImpl 객체 생성<br>
	 * WorkOrderInquiryDBDAO를 생성한다.<br>
	 */
	public WorkOrderInquiryBCImpl(){
		dbDao = new WorkOrderInquiryDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e 
	 * @return response ESD_TRS_025EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0025Event event=(EsdTrs0025Event)e;

		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchWorkOrderList(event);
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
	 * WorkOrderInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e 
	 * @return response ESD_TRS_025EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0025Event event=(EsdTrs0025Event)e;

		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchWorkOrderInquiryList(event);
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
	 * WorkOrderInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_025Event
	 * @return EventResponse ESD_TRS_025EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0025Event event=(EsdTrs0025Event)e;
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.searchWorkOrderInquiry(event);
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
	 * WorkOrderInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_025Event
	 * @return EventResponse ESD_TRS_025EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderInquiryAddCancel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0025Event event=(EsdTrs0025Event)e;
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.searchWorkOrderInquiryAddCancel(event);
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
	 * WorkOrderInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_025Event
	 * @return EventResponse ESD_TRS_025EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSvcOrdHisList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0025Event event=(EsdTrs0025Event)e;
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.searchSvcOrdHisList(event);
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
	 * WorkOrder Auth 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAuthWrkOrdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0939Event event=(EsdTrs0939Event)e;

		DBRowSet rowSet=null;

		try {
			rowSet = dbDao.searchAuthWrkOrdList(event);
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
	 * Authorization Approval Confirm 화면에 대한 TRS 용 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	public EventResponse searchAuthApproTrsList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ComEns0U1Event event=(ComEns0U1Event)e;

		DBRowSet rowSet=null;

		try {
			rowSet = dbDao.searchAuthApproTrsList(event);
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
	 * Authorization Approval Inquiry 화면에 대한 TRS 용 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	public EventResponse searchAuthAproTrsInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ComEns0U2Event event=(ComEns0U2Event)e;

		DBRowSet rowSet=null;

		try {
			rowSet = dbDao.searchAuthAproTrsInquiry(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * workordermanage 업무 시나리오 마감작업<br>
	 * WorkOrderInquiry업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}