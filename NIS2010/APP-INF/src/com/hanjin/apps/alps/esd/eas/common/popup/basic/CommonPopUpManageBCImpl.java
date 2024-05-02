/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CommonPopUpManageBCImpl.java
*@FileTitle : CY & Door S/O Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2007-11-29
*@LastModifier : yujin
*@LastVersion : 1.0
* 2007-11-29 yujin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.common.popup.basic;

import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.eas.common.popup.event.EsdEasCom0001Event;
import com.hanjin.apps.alps.esd.eas.common.popup.event.EsdEasCom0001EventResponse;
import com.hanjin.apps.alps.esd.eas.common.popup.integration.CommonPopUpManageDBDAO;
import com.hanjin.apps.alps.esd.eas.common.popup.event.EsdEasCom0002Event;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;


/**
 * ESD-EAS Business Logic Basic Command implementation<br>
 * - ESD-EAS에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author yujin
 * @see CommonPopUpManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class CommonPopUpManageBCImpl extends BasicCommandSupport implements CommonPopUpManageBC
{

	// Database Access Object
	private transient CommonPopUpManageDBDAO dbDao=null;

	/**
	 * CommonPopUpManageBCImpl 객체 생성<br>
	 * CommonPopUpManageDBDAO를 생성한다.<br>
	 */
	public CommonPopUpManageBCImpl(){
		dbDao = new CommonPopUpManageDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Common Office 화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_EAS_COM_001
	 * @return EventResponse ESD_EAS_COM_001EventResponse
	 * @exception EventException
	 */
	public EventResponse searchServiceOfficeCodeManage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		EsdEasCom0001Event event=(EsdEasCom0001Event)e;
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.searchServiceOfficeCodeManage(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Common Office 화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_EAS_COM_001
	 * @return EventResponse ESD_EAS_COM_001EventResponse
	 * @exception EventException
	 */
	public EventResponse searchServiceOfficeCodeManage2(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		EsdEasCom0002Event event=(EsdEasCom0002Event)e;
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.searchServiceOfficeCodeManage2(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Office Hierarchy 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	public EventResponse searchTroSubOfc(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdEasCom0002Event event=(EsdEasCom0002Event)e;

		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		Map<String, String>		etcData			= new HashMap<String, String>();
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;

		try {
			rowSet=dbDao.searchTroSubOfc(event);
			eventResponse.setRs(rowSet);
			etcData.put("successFlag", "SUCCESS" );
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * EAS 업무 시나리오 마감작업<br>
	 * Common Office 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}