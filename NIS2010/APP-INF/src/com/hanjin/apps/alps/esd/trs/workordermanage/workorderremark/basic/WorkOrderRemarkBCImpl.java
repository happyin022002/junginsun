/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderRemarkBCImpl.java
*@FileTitle : Office별로 Cost/Trans Mode 및 IN/OUT Bound 별 W/O에 공통 적용할 비고 사항을 관리하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-08
*@LastModifier : poong_yeon
*@LastVersion : 1.0
* 2006-11-08 poong_yeon
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderremark.basic;

import com.hanjin.apps.alps.esd.trs.workordermanage.workorderremark.event.EsdTrs0078Event;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderremark.integration.WorkOrderRemarkDBDAO;
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
 * @see ESD_TRS_078EventResponse,WorkOrderRemarkBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class WorkOrderRemarkBCImpl   extends BasicCommandSupport implements WorkOrderRemarkBC {

	// Database Access Object
	private transient WorkOrderRemarkDBDAO dbDao=null;

	/**
	 * WorkOrderRemarkBCImpl 객체 생성<br>
	 * WorkOrderRemarkDBDAO를 생성한다.<br>
	 */
	public WorkOrderRemarkBCImpl(){
		dbDao = new WorkOrderRemarkDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderRemark화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_078Event
	 * @return EventResponse ESD_TRS_078EventResponse
	 * @exception EventException
	 * @author choice
	 * @deprecated
	 */
	public EventResponse searchWorkOrderRemark(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0078Event event=(EsdTrs0078Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.searchWorkOrderRemark(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 추가 이벤트 처리<br>
	 * ESD_TRS_078 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_078Event
	 * @return EventResponse ESD_TRS_078EventResponse
	 * @exception EventException
	 */
	public EventResponse addWorkOrderRemark(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0078Event event=(EsdTrs0078Event)e;

		try {
			dbDao.addWorkOrderRemark(event);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 수정 이벤트 처리<br>
	 * ESD_TRS_078 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_078Event
	 * @return EventResponse ESD_TRS_078EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyWorkOrderRemark(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0078Event event=(EsdTrs0078Event)e;

		try {
			dbDao.modifyWorkOrderRemark(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 삭제 이벤트 처리<br>
	 * ESD_TRS_078 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_078Event
	 * @return EventResponse ESD_TRS_078EventResponse
	 * @exception EventException
	 */
	public EventResponse removeWorkOrderRemark(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0078Event event=(EsdTrs0078Event)e;

		try {
			dbDao.removeWorkOrderRemark(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_078 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_078Event
	 * @return EventResponse ESD_TRS_078EventResponse
	 * @exception EventException
	 */
	public EventResponse multiWorkOrderRemark(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0078Event event=(EsdTrs0078Event)e;

		try {
			dbDao.multiWorkOrderRemark(event);
			return eventResponse;
		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage(),de);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderRemark화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_078EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderRemarkList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0078Event event=(EsdTrs0078Event)e;
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		try {
			rowSet=dbDao.searchWorkOrderRemarkList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * WorkOrderManage 업무 시나리오 마감작업<br>
	 * WorkOrderRemark업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}