/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : USAActualCustomerCodeManageBCImpl.java
*@FileTitle : USA Actual Customer Code Manage
*Open Issues :
*Change history :
*@LastModifyDate : 2007-10-16
*@LastModifier : Kim Jun Ho
*@LastVersion : 1.0
* 2007-10-16 Kim Jun Ho
* 1.0 최초 생성
* 2011.03.14 손은주 [CHM-201109256][TRS] Actual customer 상의 중복 Default 지정 Block 요청
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.usaactualcustomercodemanage.basic;

import java.sql.SQLException;

import com.clt.apps.opus.esd.trs.codemanage.usaactualcustomercodemanage.event.EsdTrs0082Event;
import com.clt.apps.opus.esd.trs.codemanage.usaactualcustomercodemanage.integration.USAActualCustomerCodeManageDBDAO;
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
 * @author Kim Jun Ho
 * @see ESD_TRS_082EventResponse,usaactualcustomercodemanageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class USAActualCustomerCodeManageBCImpl  extends BasicCommandSupport implements USAActualCustomerCodeManageBC {

// Database Access Object
	private transient USAActualCustomerCodeManageDBDAO dbDao=null;

	/**
	 * USAActualCustomerCodeManageBCImpl 객체 생성<br>
	 * USAActualCustomerCodeManageDBDAO를 생성한다.<br>
	 */
	public USAActualCustomerCodeManageBCImpl(){
		dbDao = new USAActualCustomerCodeManageDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * usaactualcustomercodemanage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_082EventResponse
	 * @exception EventException
	 */
	public EventResponse searchUSAActualCustomerCodeManageList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0082Event event=(EsdTrs0082Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchUSAActualCustomerCodeManageList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * usaactualcustomercodemanage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_082Event
	 * @return EventResponse ESD_TRS_082EventResponse
	 * @exception EventException
	 */
	public EventResponse searchUSAActualCustomerCodeManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0082Event event=(EsdTrs0082Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.searchUSAActualCustomerCodeManage(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * usaactualcustomercodemanage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_082Event
	 * @return EventResponse ESD_TRS_082EventResponse
	 * @exception EventException
	 */
	public EventResponse searchUSAActualCustomerName(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0082Event event=(EsdTrs0082Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.searchUSAActualCustomerName(event);
			if(rowSet.next()){
				eventResponse.setETCData("CUST_NM", rowSet.getString("act_cust_nm"));
			}else{
				eventResponse.setETCData("CUST_NM", "");
			}
			eventResponse.setRsVo(rowSet);
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
	 * 조회 이벤트 처리<br>
	 * usaactualcustomercodemanage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_082Event
	 * @return EventResponse ESD_TRS_082EventResponse
	 * @exception EventException
	 */
	public EventResponse searchUSAActualCustomerNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0082Event event=(EsdTrs0082Event)e;
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.searchUSAActualCustomerNo(event);
			if(rowSet.next()){
				eventResponse.setETCData("TEXT", rowSet.getString("trsp_act_cust_no"));
			}
			
			eventResponse.setRsVo(rowSet);
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
	 * 조회 이벤트 처리<br>
	 * usaactualcustomercodemanage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_082Event
	 * @return EventResponse ESD_TRS_082EventResponse
	 * @exception EventException
	 */
	public EventResponse searchUSAActualCustomerCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0082Event event=(EsdTrs0082Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		try {
			rowSet=dbDao.searchUSAActualCustomerCheck(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * usaactualcustomercodemanage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_082Event
	 * @return EventResponse ESD_TRS_082EventResponse
	 * @exception EventException
	 */
	public EventResponse searchUSAActualCustomerCodeExcel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0082Event event=(EsdTrs0082Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.searchUSAActualCustomerCodeExcel(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_082 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_082Event
	 * @return EventResponse ESD_TRS_082EventResponse
	 * @exception EventException
	 */
	public EventResponse multiUSAActualCustomerCodeManageList(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0082Event event = (EsdTrs0082Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			dbDao.multiUSAActualCustomerCodeManageList(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * usaactualcustomercodemanage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}