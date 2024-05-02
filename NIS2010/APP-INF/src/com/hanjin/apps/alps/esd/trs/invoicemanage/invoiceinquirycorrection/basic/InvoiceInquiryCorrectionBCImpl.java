/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceInquiryCorrectionBCImpl.java
*@FileTitle : Service Provider로부터 W/O실행 이후 비용 지불을 위한 Invoice를 일괄 Confirm하거나, Confirmed or Interfaced Invoice를 취소하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-26
*@LastModifier : poong_yeon
*@LastVersion : 1.0
* 2007-01-26 poong_yeon
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceinquirycorrection.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceinquirycorrection.event.EsdTrs0030Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceinquirycorrection.integration.InvoiceInquiryCorrectionDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;


/**
 * ESD-invoicemanage Business Logic Basic Command implementation<br>
 * - ESD-invoicemanage에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author poong_yeon
 * @see ESD_TRS_030EventResponse,InvoiceInquiryCorrectionBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class InvoiceInquiryCorrectionBCImpl   extends BasicCommandSupport implements InvoiceInquiryCorrectionBC {

	// Database Access Object
	private transient InvoiceInquiryCorrectionDBDAO dbDao=null;

	/**
	 * 추가 이벤트 처리<br>
	 * ESD_TRS_030 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_030Event
	 * @return EventResponse ESD_TRS_030EventResponse
	 * @exception EventException
	 */
	public EventResponse deleteInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0030Event event=(EsdTrs0030Event)e;

		try {
			dbDao.deleteInvoice(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 추가 이벤트 처리<br>
	 * ESD_TRS_030 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_030Event
	 * @return EventResponse ESD_TRS_030EventResponse
	 * @exception EventException
	 */
	public EventResponse confirmInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0030Event event=(EsdTrs0030Event)e;

		try {
			dbDao.confirmInvoice(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 추가 이벤트 처리<br>
	 * ESD_TRS_030 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_030Event
	 * @return EventResponse ESD_TRS_030EventResponse
	 * @exception EventException
	 */
	public EventResponse confirmCancelInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0030Event event=(EsdTrs0030Event)e;

		try {
			dbDao.confirmCancelInvoice(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 추가 이벤트 처리<br>
	 * ESD_TRS_030 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_030Event
	 * @return EventResponse ESD_TRS_030EventResponse
	 * @exception EventException
	 */
	public EventResponse saveHold(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0030Event event=(EsdTrs0030Event)e;

		try {
			dbDao.saveHold(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 추가 이벤트 처리<br>
	 * ESD_TRS_030 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_030Event
	 * @return EventResponse ESD_TRS_030EventResponse
	 * @exception EventException
	 */
	public EventResponse saveUpdUsrId(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0030Event event=(EsdTrs0030Event)e;

		try {
			dbDao.saveUpdUsrId(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * InvoiceInquiryCorrectionBCImpl 객체 생성<br>
	 * InvoiceInquiryCorrectionDBDAO를 생성한다.<br>
	 */
	public InvoiceInquiryCorrectionBCImpl(){
		dbDao = new InvoiceInquiryCorrectionDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * InvoiceInquiryCorrection화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_030EventResponse
	 * @exception EventException
	 */
	public EventResponse searchInvoiceInquiryCorrectionList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0030Event event=(EsdTrs0030Event)e;

		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchInvoiceInquiryCorrectionList(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * InvoiceInquiryCorrection화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_030EventResponse
	 * @exception EventException
	 */
	public EventResponse searchInvoiceEdiPdfFile(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0030Event event=(EsdTrs0030Event)e;

		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchInvoiceEdiPdfFile(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * InvoiceInquiryCorrection화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_030EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyInvOfcCdForSPP(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0030Event event=(EsdTrs0030Event)e;

		try {
			dbDao.modifyInvOfcCdForSPP(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * InvoiceInquiryCorrection화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_030EventResponse
	 * @exception EventException
	 */
	public EventResponse searchInvoiceConfrimAmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0030Event event=(EsdTrs0030Event)e;

		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet = dbDao.searchInvoiceConfrimAmt(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * InvoiceInquiryCorrection화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_030EventResponse
	 * @exception EventException
	 */
	public EventResponse searchInvoiceInquirySecondExcelForm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0030Event event=(EsdTrs0030Event)e;
		try {
			List rsList = dbDao.searchInvoiceInquirySecondExcelForm(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVoList(rsList);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	public EventResponse searchInvoiceInquiryIdaList(Event e) throws EventException {
		EsdTrs0030Event event=(EsdTrs0030Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		try {
			rowSet=dbDao.searchInvoiceInquiryIdaList(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * invoicemanage 업무 시나리오 마감작업<br>
	 * InvoiceInquiryCorrection업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}