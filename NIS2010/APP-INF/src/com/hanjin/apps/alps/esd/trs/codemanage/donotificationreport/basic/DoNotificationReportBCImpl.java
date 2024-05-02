/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DoNotificationReportBCImpl.java
*@FileTitle : D/O notification Report
*Open Issues :
*Change history :
*@LastModifyDate : 2016-06-03
*@LastModifier : 
*@LastVersion : 1.0
* 2016-06-03
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.donotificationreport.basic;

import java.sql.SQLException;

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
import com.hanjin.apps.alps.esd.trs.codemanage.donotificationreport.event.EsdTrs0291Event;
import com.hanjin.apps.alps.esd.trs.codemanage.donotificationreport.integration.DoNotificationReportDBDAO;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author SHIN DONG IL
 * @see ESD_TRS_0291EventResponse,DoNotificationReportBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class DoNotificationReportBCImpl  extends BasicCommandSupport implements DoNotificationReportBC {

// Database Access Object
	private transient DoNotificationReportDBDAO dbDao=null;

	/**
	 * DoNotificationReportBC 객체 생성<br>
	 * DoNotificationReportDBDAO 생성한다.<br>
	 */
	public DoNotificationReportBCImpl(){
		dbDao = new DoNotificationReportDBDAO();
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * D/O Notification Report 화면을 조회하는 이벤트 처리<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDoNotificationReportList(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0291Event event=(EsdTrs0291Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try{
			rowSet = dbDao.searchDoNotificationReportList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
}