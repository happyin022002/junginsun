/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : US204EDISetupBCImpl.java
*@FileTitle : US 204 EDI Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2012-04-22
*@LastModifier : 조인영
*@LastVersion : 1.0
* 2012-04-22 조인영
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.us204edisetup.basic;

import java.sql.SQLException;

import com.hanjin.apps.alps.esd.trs.codemanage.us204edisetup.event.EsdTrs0085Event;
import com.hanjin.apps.alps.esd.trs.codemanage.us204edisetup.integration.US204EDISetupDBDAO;
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
 * @author 조인영
 * @see ESD_TRS_085EventResponse,US204EDISetupBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class US204EDISetupBCImpl  extends BasicCommandSupport implements US204EDISetupBC {

// Database Access Object
	private transient US204EDISetupDBDAO dbDao=null;

	/**
	 * US204EDISetupBCImpl 객체 생성<br>
	 * US204EDISetupDBDAO를 생성한다.<br>
	 */
	public US204EDISetupBCImpl(){
		dbDao = new US204EDISetupDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * US204EDI SetUp 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_085EventResponse
	 * @exception EventException
	 */
	public EventResponse searchUS204EDISetupList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0085Event event=(EsdTrs0085Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchUS204EDISetupList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * US204EDI SetUp 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_085EventResponse
	 * @exception EventException
	 */
	public EventResponse searchUS204EDISetupVndr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0085Event event=(EsdTrs0085Event)e;
		FormCommand formcommand = e.getFormCommand();	//ETC DATA를 위해서 필요
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchUS204EDISetupVndr(event);
			eventResponse.setRsVo(rowSet);
			if(formcommand.isCommand(FormCommand.SEARCH01)){
				if(rowSet.next()){		
					eventResponse.setETCData("vndr_no", 			rowSet.getString("vndr_no"));
					eventResponse.setETCData("vndr_nm_eng", 		rowSet.getString("vndr_nm_eng"));
				}
			}
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());		
		}
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * US204EDI SetUp 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_085EventResponse
	 * @exception EventException
	 */
	public EventResponse multiUS204EDISetup(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0085Event event=(EsdTrs0085Event)e;
		try {
			dbDao.multiUS204EDISetupList(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * US204EDI SetUp 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}