/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaRailYardManageBCImpl.java
*@FileTitle : UsaRailYardManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009-05-11
*@LastModifier : Jun Yong Park
*@LastVersion : 1.0
* 2009-05-11 Jun Yong Park
* 1.0 최초 생성
* N200905150040 2009-05-20 [TRS]USA RAIL YARD 정보 저장 화면 개발
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.usarailyardmanage.basic;

import com.hanjin.apps.alps.esd.trs.codemanage.usarailyardmanage.event.EsdTrs0084Event;
import com.hanjin.apps.alps.esd.trs.codemanage.usarailyardmanage.integration.UsaRailYardManageDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;



/**
 * ENIS-UsaRailYardManage Business Logic Basic Command implementation<br>
 * - ENIS-UsaRailYardManage에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author poong yeon cho
 * @see UsaRailYardManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class UsaRailYardManageBCImpl extends BasicCommandSupport implements UsaRailYardManageBC {

	// Database Access Object
	private transient UsaRailYardManageDBDAO dbDao=null;

	/**
	 * UsaRailYardManageBCImpl 객체 생성<br>
	 * UsaRailYardManageDBDAO를 생성한다.<br>
	 */
	public UsaRailYardManageBCImpl(){
		dbDao = new UsaRailYardManageDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * UsaRailYardManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0084Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchUsaRailYardManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0084Event event=(EsdTrs0084Event)e;
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			rowSet=dbDao.searchUsaRailYardManage(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_084 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0084Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse multiUsaRailYardManage(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0084Event event=(EsdTrs0084Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			dbDao.multiUsaRailYardManage(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * UsaRailYardManage 업무 시나리오 마감작업<br>
	 * UsaRailYardManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}