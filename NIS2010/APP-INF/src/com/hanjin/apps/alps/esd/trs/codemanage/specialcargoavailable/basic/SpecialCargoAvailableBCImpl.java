/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SpecialCargoAvailableBCImpl.java
*@FileTitle : Special Cargo Available S/P
*Open Issues :
*Change history :
*@LastModifyDate : 2014-12-30
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2014-12-30 SHIN DONG IL
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.specialcargoavailable.basic;

import java.sql.SQLException;

import com.hanjin.apps.alps.esd.trs.codemanage.specialcargoavailable.event.EsdTrs0088Event;
import com.hanjin.apps.alps.esd.trs.codemanage.specialcargoavailable.integration.SpecialCargoAvailableDBDAO;
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


/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author SHIN DONG IL
 * @see ESD_TRS_088EventResponse,SpecialCargoAvailableBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class SpecialCargoAvailableBCImpl  extends BasicCommandSupport implements SpecialCargoAvailableBC {

// Database Access Object
	private transient SpecialCargoAvailableDBDAO dbDao=null;

	/**
	 * SpecialCargoAvailableBC 객체 생성<br>
	 * SpecialCargoAvailableDAO 생성한다.<br>
	 */
	public SpecialCargoAvailableBCImpl(){
		dbDao = new SpecialCargoAvailableDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Special Cargo Available S/P 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSpecialCargoAvailableList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0088Event event=(EsdTrs0088Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchSpecialCargoAvailableList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


	
	/**
	 * 멀티 이벤트 처리<br>
	 * Special Cargo Available S/P 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiSpecialCargoAvailable(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0088Event event=(EsdTrs0088Event)e;
		try {
			dbDao.multiSpecialCargoAvailable(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * Special Cargo Available S/P 화면에 대한 Row Delete 이벤트 처리<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse removeSpecialCargoAvailable(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0088Event event=(EsdTrs0088Event)e;
		try {
			dbDao.removeSpecialCargoAvailable(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Special Cargo Available S/P 화면에 Vendor 체크로직<br>
	 * 
	 * @param e
	 * @return String
	 * @exception EventException
	 */
	public String searchVendorCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0088Event event=(EsdTrs0088Event)e;
		String rtn_val = "";
		try {
			rtn_val=dbDao.searchVendorCheck(event);
			return rtn_val;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} 
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Special Cargo Available S/P 화면에 Office 체크로직<br>
	 * 
	 * @param e
	 * @return String
	 * @exception EventException
	 */
	public String searchSoCreOfc(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0088Event event=(EsdTrs0088Event)e;
		String rtn_val = "";
		try {
			rtn_val=dbDao.searchSoCreOfc(event);

			return rtn_val;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	
	
	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * Special Cargo Available S/P 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}