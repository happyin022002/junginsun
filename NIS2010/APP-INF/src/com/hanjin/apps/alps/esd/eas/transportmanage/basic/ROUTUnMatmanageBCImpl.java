/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ROUTUnMatmanageBCImpl
*@FileTitle : Route Unmatch List
*Open Issues :
*Change history :
*@LastModifyDate : 2008-01-30
*@LastModifier : ho-sam lee
*@LastVersion : 1.0
* 2008-01-30 ho-sam lee
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.basic;

import com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0002Event;
import com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0902Event;
import com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0902EventResponse;
import com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0903Event;
import com.hanjin.apps.alps.esd.eas.transportmanage.integration.ROUTUnMatmanageDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ROUTUnMatmanageBCImpl PDTO(Data Transfer Object including Parameters)<br>
 * @author ho-sam lee
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public class ROUTUnMatmanageBCImpl extends BasicCommandSupport implements ROUTUnMatmanageBC {

	
	// Database Access Object
	private transient ROUTUnMatmanageDBDAO dbDao = null;

	/**
	 * OutstandingManageBCImpl 객체 생성<br>
	 * OutstandingManageDBDAO를 생성한다.<br>
	 */
	public ROUTUnMatmanageBCImpl(){
		dbDao = new ROUTUnMatmanageDBDAO();
	}

	/**
	 * Route Unmatch List Main
	 * @param e EsdEas0002Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchRoutUnMatList(Event e) throws EventException {

		EsdEas0002Event event=(EsdEas0002Event)e;
		
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet = dbDao.searchRoutUnMatList(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Route Unmatch List Detail First
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchRoutUnMatBlInforDetail(Event e) throws EventException {

		EsdEas0903Event event=(EsdEas0903Event)e;
		
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet = dbDao.searchRoutUnMatBlInforDetail(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Route Unmatch List Detail Second
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchRoutUnMatSoInforDetail(Event e) throws EventException {

		EsdEas0903Event event=(EsdEas0903Event)e;
		
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet = dbDao.searchRoutUnMatSoInforDetail(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
//2011.07.13 이정수 R4J소스품질 위배 및 미사용으로 인해 주석처리함   	
	/**
	 * Expense Audit Remark 조회
	 * @param e
	 * @return
	 * @throws EventException
	 */
/*	public EventResponse searchExpnAudRmk(Event e) throws EventException {

		EsdEas0902Event event=(EsdEas0902Event)e;
		
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet = dbDao.searchExpnAudRmk(event.getDataSet());
			return new EsdEas0902EventResponse(rowSet,"SUCCESS");
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}*/

//2011.07.13 이정수 R4J소스품질 위배 및 미사용으로 인해 주석처리함   	
	/**
	 * Expense Audit Remark 추가/수정
	 * @param e
	 * @return
	 * @throws EventException
	 */
/*	public EventResponse multiExpnAudRmk(Event e) throws EventException {

		EsdEas0902Event event=(EsdEas0902Event)e;
		
		try {
			dbDao.multiExpnAudRmk(event.getDataSet());
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}*/

}
