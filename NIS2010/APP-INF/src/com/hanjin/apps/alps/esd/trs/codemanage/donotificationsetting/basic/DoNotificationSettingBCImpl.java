/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DoNotificationSettingBCImpl.java
*@FileTitle : D/O notification Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2016-05-30
*@LastModifier : geun hwan park
*@LastVersion : 1.0
* 2016-05-30 geun hwan park
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.donotificationsetting.basic;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.apps.alps.esd.trs.codemanage.donotificationsetting.event.EsdTrs0290Event;
import com.hanjin.apps.alps.esd.trs.codemanage.donotificationsetting.integration.DoNotificationSettingDBDAO;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author SHIN DONG IL
 * @see ESD_TRS_0280EventResponse,DoNotificationSettingBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class DoNotificationSettingBCImpl  extends BasicCommandSupport implements DoNotificationSettingBC {

// Database Access Object
	private transient DoNotificationSettingDBDAO dbDao=null;

	/**
	 * DoNotificationSettingBC 객체 생성<br>
	 * DoNotificationSettingDBDAO 생성한다.<br>
	 */
	public DoNotificationSettingBCImpl(){
		dbDao = new DoNotificationSettingDBDAO();
	}
	
	/**
	 * 조회 이벤트 처리<br>
	  * D/O Notificatio Setting 화면을 조회하는 이벤트 처리<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDoNotificationSetting(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0290Event event=(EsdTrs0290Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try{
			rowSet = dbDao.searchDoNotificationSetting(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	  * D/O Notificatio Setting 화면을 조회하는 이벤트 처리<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDoScNo(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0290Event event=(EsdTrs0290Event)e;
		DBRowSet rowSet = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try{
			rowSet = dbDao.searchDoScNo(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * D/O Notification Setting 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 * @param account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiDoScNo(Event e,SignOnUserAccount account) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0290Event event = (EsdTrs0290Event)e;
		try {
			dbDao.multiDoScNo(event,account);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * D/O Notification Setting 화면에 대한 Row Delete 이벤트 처리<br>
	 * 
	 * @param e
	 * @param account
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse removeDoNotificationSetting(Event e,SignOnUserAccount account) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0290Event event = (EsdTrs0290Event)e;
		try {
			dbDao.removeDoNotificationSetting(event,account);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Grid Door Yard 변경시 Yard name 조회<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDorYdNm(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0290Event event=(EsdTrs0290Event)e;
		DBRowSet rowSet = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try{
			rowSet = dbDao.searchDorYdNm(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
}