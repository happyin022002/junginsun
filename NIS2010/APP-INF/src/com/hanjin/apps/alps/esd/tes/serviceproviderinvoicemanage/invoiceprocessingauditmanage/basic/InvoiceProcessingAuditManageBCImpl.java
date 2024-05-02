/***************************************************************************************
 * =========================================================
 * Copyright(c) 2006 CyberLogitec
 * @FileName : InvoiceProcessingAuditManageBCImpl.java
 * @FileTitle : Invoice Processing Audit Inquiry View
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2014-06-19
 * @LastModifier : yOng hO lEE
 * @LastVersion : 1.0
 * 2014-06-19 yOng hO lEE
 * 1.0 최초 생성
 * =========================================================
 ***************************************************************************************/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.invoiceprocessingauditmanage.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.invoiceprocessingauditmanage.event.EsdTes0015Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.invoiceprocessingauditmanage.integration.InvoiceProcessingAuditManageDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;


/**
 * ALPS-ESD Business Logic Basic Command implementation<br>
 * - ALPS-ESD에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author 
 * @see InvoiceProcessingAuditManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4 
 */
public class InvoiceProcessingAuditManageBCImpl extends BasicCommandSupport implements InvoiceProcessingAuditManageBC {

	// Database Access Object
	private transient InvoiceProcessingAuditManageDBDAO dbDao=null;

	/**
	 * InvoiceProcessingAuditManageBCImpl 객체 생성<br>
	 * InvoiceProcessingAuditManageDBDAO를 생성한다.<br>
	 */
	public InvoiceProcessingAuditManageBCImpl(){
		dbDao = new InvoiceProcessingAuditManageDBDAO();
	}

	/**
	 * INVOICE Layer
	 * 1 : Marine Terminal Invoice
	 * 2 : On-dock Rail Charge Invoice
	 * 3 : Off-dock CY Invoice
	 * 4 : Marine Terminal Strorage Invoice
	 */	 

	/**
	 * 조회 이벤트 처리<br>
	 * searchAuditTerminalInvoiceContainerList 대한 조회 이벤트 처리<br>
	 *
	 * @param e EsdTes0015Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchAuditTerminalInvoiceContainerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0015Event event = (EsdTes0015Event)e;
		
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		ArrayList<DBRowSet>	arrList 			= new ArrayList<DBRowSet>();
		Map<String, String>	etcData			= new HashMap<String, String>();
		
		if(log.isDebugEnabled())log.debug("\n==========InvoiceProcessingAuditManageBCImpl    searchAuditTerminalInvoiceContainerList() ============");
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			int	iPage	= event.getIPage();

			arrList.add(dbDao.searchAuditTerminalInvoiceContainerList	(event, "CO", iPage ) );
			arrList.add(dbDao.searchAuditTerminalInvoiceContainerList	(event, "DC", iPage ));
			arrList.add(dbDao.searchAuditTerminalInvoiceCalculationList	(event));

			
			etcData.put("successFlag", "SUCCESS" );
			
			eventResponse.setRsList(arrList);
			eventResponse.setETCData(etcData);
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * searchAuditTerminalInvoiceContainerList 대한 조회 이벤트 처리<br>
	 *
	 * @param e EsdTes0015Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchAuditOndockRailChargeContainerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0015Event event = (EsdTes0015Event)e;
		
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		ArrayList<DBRowSet>	arrList 			= new ArrayList<DBRowSet>();
		Map<String, String>	etcData			= new HashMap<String, String>();
		
		if(log.isDebugEnabled())log.debug("\n==========InvoiceProcessingAuditManageBCImpl    searchAuditTerminalInvoiceContainerList() ============");
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		try {
			int	iPage	= event.getIPage();

			arrList.add(dbDao.searchAuditOndockRailChargeContainerList	(event, "CO", iPage));
			arrList.add(dbDao.searchAuditOndockRailChargeContainerList	(event, "DC", iPage));
			arrList.add(dbDao.searchAuditOndockCostCalculationList(event));

			etcData.put("successFlag", "SUCCESS" );
			
			eventResponse.setRsList(arrList);
			eventResponse.setETCData(etcData);
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * searchAuditTerminalInvoiceContainerList 대한 조회 이벤트 처리<br>
	 *
	 * @param e EsdTes0015Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchAuditOffdockCYContainerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0015Event event = (EsdTes0015Event)e;
		
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		ArrayList<DBRowSet>	arrList 			= new ArrayList<DBRowSet>();
		Map<String, String>	etcData			= new HashMap<String, String>();
		
		if(log.isDebugEnabled())log.debug("\n==========InvoiceProcessingAuditManageBCImpl    searchAuditOffdockCYContainerList() ============");
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		try {
			int iPage = event.getIPage();
			
			arrList.add(dbDao.searchAuditOffdockCYContainerList	(event, "CO", iPage));
			arrList.add(dbDao.searchAuditOffdockCYContainerList(event, "DC", iPage));
			arrList.add(dbDao.searchAuditOffdockCYCalcCostTMNLList(event));
			arrList.add(dbDao.searchAuditOffdockCYCalcCostByDayList(event));
			arrList.add(dbDao.searchAuditOffdockCYCalcCostByPoolList(event));
			
			etcData.put("successFlag", "SUCCESS" );
			
			eventResponse.setRsList(arrList);
			eventResponse.setETCData(etcData);
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * searchAuditStorageContainerList 대한 조회 이벤트 처리<br>
	 *
	 * @param e EsdTes0015Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchAuditStorageContainerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0015Event event = (EsdTes0015Event)e;
		
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		ArrayList<DBRowSet>	arrList 			= new ArrayList<DBRowSet>();
		Map<String, String>	etcData			= new HashMap<String, String>();
		
		if(log.isDebugEnabled())log.debug("\n==========InvoiceProcessingAuditManageBCImpl    searchAuditStorageContainerList() ============");
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		try {
			int iPage	= event.getIPage();

			arrList.add(dbDao.searchAuditStorageContainerList	(event, "CO", iPage));
			arrList.add(dbDao.searchAuditStorageContainerList	(event, "DC", iPage));
			arrList.add(dbDao.searchAuditStorageInvoiceCalculationList(event, "SD"));
			arrList.add(dbDao.searchAuditStorageInvoiceCalculationList(event, "SP"));

			etcData.put("successFlag", "SUCCESS" );
			
			eventResponse.setRsList(arrList);
			eventResponse.setETCData(etcData);
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	

}