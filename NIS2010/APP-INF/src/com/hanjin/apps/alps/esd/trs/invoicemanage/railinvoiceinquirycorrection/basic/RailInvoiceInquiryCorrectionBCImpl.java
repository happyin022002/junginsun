/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailInvoiceInquiryCorrectionBCImpl.java
*@FileTitle : Service Provider로부터 W/O실행 이후 비용 지불을 위한 Invoice를 일괄 Confirm하거나, Confirmed or Interfaced Invoice를 취소하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-30
*@LastModifier : chkong
*@LastVersion : 1.0
* 2007-01-30 chkong
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceinquirycorrection.basic;

import com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceinquirycorrection.event.EsdTrs0046Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceinquirycorrection.integration.RailInvoiceInquiryCorrectionDBDAO;
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
 * @author chkong
 * @see ESD_TRS_046EventResponse,RailInvoiceInquiryCorrectionBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class RailInvoiceInquiryCorrectionBCImpl   extends BasicCommandSupport implements RailInvoiceInquiryCorrectionBC {

	// Database Access Object
	private transient RailInvoiceInquiryCorrectionDBDAO dbDao=null;

	/**
	 * InvoiceInquiryCorrectionBCImpl 객체 생성<br>
	 * InvoiceInquiryCorrectionDBDAO를 생성한다.<br>
	 */
	public RailInvoiceInquiryCorrectionBCImpl(){
		dbDao = new RailInvoiceInquiryCorrectionDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * RailInvoiceInquiryCorrection화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_046EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRailInvoiceInquiryCorrectionList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0046Event event=(EsdTrs0046Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchRailInvoiceInquiryCorrectionList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_046 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_046Event
	 * @return EventResponse ESD_TRS_046EventResponse
	 * @exception EventException
	 */
	public EventResponse multiRailInvoiceHold(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0046Event event=(EsdTrs0046Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			dbDao.multiRailInvoiceHold(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * 삭제 이벤트 처리<br>
	 * ESD_TRS_046 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_046Event
	 * @return EventResponse ESD_TRS_046EventResponse
	 * @exception EventException
	 */
	public EventResponse removeRailInvoiceInquiryCorrection(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0046Event event=(EsdTrs0046Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			dbDao.removeRailInvoiceInquiryCorrection(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_046 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_046Event
	 * @return EventResponse ESD_TRS_046EventResponse
	 * @exception EventException
	 */
	public EventResponse multiRailInvoiceConfirmCancel(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0046Event event=(EsdTrs0046Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			dbDao.multiRailInvoiceConfirmCancel(event);
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