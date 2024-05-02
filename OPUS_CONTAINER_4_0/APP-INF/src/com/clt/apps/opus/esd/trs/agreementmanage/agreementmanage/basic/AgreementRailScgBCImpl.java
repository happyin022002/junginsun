/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AgreementRailScgBCImpl.java
*@FileTitle : Agreement Rail Surcharge
*Open Issues :
*Change history :
*@LastModifyDate : 2010-05-17
*@LastModifier : pjy
*@LastVersion : 1.0
* 2010-05-17 pjy
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.basic;

import java.sql.SQLException;

import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0223Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0233Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0234Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration.AgreementRailScgDBDAO;
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
 * @author agreement
 * @see ESD_TRS_0223EventResponse,AgreementRailScgBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class AgreementRailScgBCImpl extends BasicCommandSupport implements AgreementRailScgBC {

	// Database Access Object
	private transient AgreementRailScgDBDAO dbDao=null;

	/**
	 * AgreementImportBCImpl 객체 생성<br>
	 * AgreementImportDAO를 생성한다.<br>
	 */
	public AgreementRailScgBCImpl(){
		dbDao = new AgreementRailScgDBDAO();
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * US RAIL Surcharge 화면의 US RAIL Agreement Fuel Surcharge 조회<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRailFuelScgAgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0223Event event=(EsdTrs0223Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {	
			rowSet=dbDao.searchRailFuelScgAgmt(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 저장 이벤트 처리<br>
	 * US RAIL Surcharge 화면의 US RAIL Agreement Fuel Surcharge 저장<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiRailFuelScgAgmt(Event e) throws EventException {
		EsdTrs0223Event event=(EsdTrs0223Event)e;
		try {	
			dbDao.multiRailFuelScgAgmt(event);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 삭제 이벤트 처리<br>
	 * US RAIL Surcharge 화면의 US RAIL Agreement Fuel Surcharge 삭제<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse deleteRailFuelScgAgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0223Event event=(EsdTrs0223Event)e;
		try {	
			dbDao.deleteRailFuelScgAgmt(event);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * 조회 이벤트 처리<br>
	 * US RAIL Surcharge 화면의 US RAIL Agreement Fixed Surcharge 조회<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRailFixScgAgmt(Event e) throws EventException {
		EsdTrs0223Event event=(EsdTrs0223Event)e;
		DBRowSet rowSet=null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {	
			rowSet=dbDao.searchRailFixScgAgmt(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 저장 이벤트 처리<br>
	 * US RAIL Surcharge 화면의 US RAIL Agreement Fixed Surcharge 저장<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiRailFixScgAgmt(Event e) throws EventException {
		EsdTrs0223Event event=(EsdTrs0223Event)e;
		try {	
			dbDao.multiRailFixScgAgmt(event);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 삭제 이벤트 처리<br>
	 * US RAIL Surcharge 화면의 US RAIL Agreement Fixed Surcharge 삭제<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse deleteRailFixScgAgmt(Event e) throws EventException {
		EsdTrs0223Event event=(EsdTrs0223Event)e;
		try {	
			dbDao.deleteRailFixScgAgmt(event);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Sequence 생성<br>
	 * Verify시 Sequence생성<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchRailFuelFixScgAgmtVerifySeq() throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		String newAgmtTmpSeq  = null;
		try {
			rowSet=dbDao.searchRailFuelFixScgAgmtVerifySeq();
			if(rowSet.next())	newAgmtTmpSeq = rowSet.getString(1);
			return newAgmtTmpSeq;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());						
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 		
	}
	
	/**
	 * Agreement Verify 처리<br>
	 * AgreementImport화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @exception EventException
	 */
	public void insertRailFuelFixScgAgmtVerifyData(Event e) throws EventException {
		EsdTrs0223Event event = (EsdTrs0223Event)e;
		try {
			dbDao.insertRailFuelFixScgAgmtVerifyData(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Verify 이벤트 처리<br>
	 * Agreement Rail Surcharge 화면의 Fuel Type Verify 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_0223EventResponse
	 * @exception EventException
	 */
	public EventResponse verifyAgmtFuel(Event e) throws EventException {
		EsdTrs0223Event 	event	= (EsdTrs0223Event)e;
		DBRowSet 			rowSet = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			rowSet = dbDao.verifyAgmtFuel(event);
			eventResponse.setRsVo(rowSet);
		} catch (DAOException de) {
			log.error("err "+de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Verify 이벤트 처리<br>
	 * Agreement Rail Surcharge 화면의 Fix Type Verify 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_0223EventResponse
	 * @exception EventException
	 */
	public EventResponse verifyAgmtFix(Event e) throws EventException {
		EsdTrs0223Event 	event	= (EsdTrs0223Event)e;
		DBRowSet 			rowSet = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			rowSet = dbDao.verifyAgmtFix(event);
			eventResponse.setRsVo(rowSet);
		} catch (DAOException de) {
			log.error("err "+de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Agreement Verify 처리<br>
	 * AgreementImport화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @exception EventException
	 */
	public void deleteRailFuelFixScgAgmtVerifyData(Event e) throws EventException {
		EsdTrs0223Event 	event	= (EsdTrs0223Event)e;
		try {
			dbDao.deleteRailFuelFixScgAgmtVerifyData(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Agreement No 조회<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAgmtNo(Event e) throws EventException {
		EsdTrs0233Event event=(EsdTrs0233Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {	
			rowSet=dbDao.searchAgmtNo(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * US RAIL Surcharge 화면의 US RAIL Agreement Surcharge History 조회<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRailScgAgmtHis(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0234Event event=(EsdTrs0234Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {	
			rowSet=dbDao.searchRailScgAgmtHis(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * US RAIL Surcharge 화면의 US RAIL Agreement Surcharge History Popup조회<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRailScgAgmtHisPop(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0234Event event=(EsdTrs0234Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {	
			rowSet=dbDao.searchRailScgAgmtHisPop(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * AgreementFileImport업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}