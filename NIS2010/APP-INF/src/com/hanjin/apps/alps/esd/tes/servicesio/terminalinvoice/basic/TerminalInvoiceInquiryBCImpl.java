/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TerminalInvoiceInquiryBCImpl.java
*@FileTitle : TerminalInvoiceInquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-18
*@LastModifier : doomi	
*@LastVersion : 1.0
* 2007-01-20 doomi
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.basic;

import com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event.TerminalInvoiceInquiryList;

import com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event.MarineTerminalInvoiceDiscrepancyCntrList;
import com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event.MarineTerminalStorageInvoiceDiscrepancyCntrList;
import com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event.OffDockCYInvoiceDiscrepancyCntr;
import com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event.OffDockCYInvoiceDiscrepancyCntrList;
import com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event.SppTes0005Event;
import com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event.SppTes0005EventResponse;
import com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event.SppTes0006Event;
import com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event.SppTes0006EventResponse;
import com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.integration.TerminalInvoiceInquiryDBDAO;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;


/**
 * SPP_TES Business Logic Basic Command implementation<br>
 * - SPP_TES에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author doomi
 * @see SPP_TES_005EventResponse,TerminalInvoiceInquiryBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class TerminalInvoiceInquiryBCImpl   extends BasicCommandSupport implements TerminalInvoiceInquiryBC {

	private static final long serialVersionUID = 1L;
	
	// Database Access Object
	private transient TerminalInvoiceInquiryDBDAO dbDao=null;

	/**
	 * TerminalInvoiceInquiryBCImpl 객체 생성<br>
	 * TerminalInvoiceInquiryDBDAO를 생성한다.<br>
	 */
	public TerminalInvoiceInquiryBCImpl(){
		dbDao = new TerminalInvoiceInquiryDBDAO();
	}


	/**
	 * TerminalInvoiceInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e SPP_TES_005Event
	 * @return EventResponse SPP_TES_005EventResponse
	 * @exception EventException
	 */
   
	public EventResponse searchTerminalInvoiceList(Event e) throws EventException {
		
		SppTes0005Event event=(SppTes0005Event)e;
        SppTes0005EventResponse eventResponse = null;


		try {
			Object[] result = dbDao.searchTerminalInvoiceList(event);
            eventResponse = new SppTes0005EventResponse((TerminalInvoiceInquiryList[])result[0],"SUCCESS"); 
            eventResponse.setTotalCount(((Integer)result[1]).intValue());
            
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse;
		
	}
	
	/**
	 * TerminalInvoiceInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e SPP_TES_005Event
	 * @return EventResponse SPP_TES_005EventResponse
	 * @exception EventException
	 */
   
	public EventResponse searchTerminalInvoiceExcelPrint(Event e) throws EventException {
		
		SppTes0005Event event=(SppTes0005Event)e;
        SppTes0005EventResponse eventResponse = null;

		try {
			Object[] result = dbDao.searchTerminalInvoiceExcelPrint(event);
            eventResponse = new SppTes0005EventResponse((TerminalInvoiceInquiryList[])result[0],"SUCCESS"); 
            eventResponse.setTotalCount(((Integer)result[1]).intValue());
            
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse;
		
	}

	/**
	 * TerminalInvoiceInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e SPP_TES_006Event
	 * @return EventResponse SPP_TES_006EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMarineTerminalInvoiceDiscrepancyCntr(Event e) throws EventException {
		SppTes0006Event event=(SppTes0006Event)e;
        SppTes0006EventResponse eventResponse = null;
		
		try {
			Object[] result = dbDao.searchMarineTerminalInvoiceDiscrepancyCntr(event);
            eventResponse = new SppTes0006EventResponse((MarineTerminalInvoiceDiscrepancyCntrList[])result[0],"SUCCESS"); 
            eventResponse.setTotalCount(((Integer)result[1]).intValue());
            
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}        
        return eventResponse;
	}
	
	/**
	 * TerminalInvoiceInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e SPP_TES_006Event
	 * @return EventResponse SPP_TES_006EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffDockCYInvoiceDiscrepancyCntr(Event e)throws EventException{
		SppTes0006Event event=(SppTes0006Event)e;
		SppTes0006EventResponse eventResponse = null;
		
		try {
			Object[] result = dbDao.searchOffDockCYInvoiceDiscrepancyCntr(event);
            eventResponse = new SppTes0006EventResponse((OffDockCYInvoiceDiscrepancyCntrList[])result[0],"SUCCESS"); 
            eventResponse.setTotalCount(((Integer)result[1]).intValue());
            
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());		
		}
        return eventResponse;		
	}
	
	/**
	 * TerminalInvoiceInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e SPP_TES_006Event
	 * @return EventResponse SPP_TES_006EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMarineTerminalStorageInvoiceDiscrepancyCntr(Event e) throws EventException{
		SppTes0006Event event=(SppTes0006Event)e;
		SppTes0006EventResponse eventResponse = null;
		
		try {
			Object[] result = dbDao.searchMarineTerminalStorageInvoiceDiscrepancyCntr(event);
            eventResponse = new SppTes0006EventResponse((MarineTerminalStorageInvoiceDiscrepancyCntrList[])result[0],"SUCCESS"); 
            eventResponse.setTotalCount(((Integer)result[1]).intValue());
            
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());		
		}
        return eventResponse;		
	}

	/**
	 * tes 업무 시나리오 마감작업<br>
	 * TerminalInvoiceInquiry업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}