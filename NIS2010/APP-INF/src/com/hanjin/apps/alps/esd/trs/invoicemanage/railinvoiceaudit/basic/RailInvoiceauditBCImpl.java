/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : railInvoiceauditBCImpl.java
*@FileTitle : USA Rail Invoice Agree and Confirm
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-08
*@LastModifier : chkong
*@LastVersion : 1.0
* 2006-12-08 chkong
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.basic;

import java.util.ArrayList;

import com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.event.EsdTrs0038Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.event.EsdTrs0923Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.event.EsdTrs0925Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.event.EsdTrs0929Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.integration.RailInvoiceauditDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author chkong
 * @see ESD_TRS_038EventResponse,railInvoiceauditBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class RailInvoiceauditBCImpl   extends BasicCommandSupport implements RailInvoiceauditBC 
{
	// Database Access Object
	private transient RailInvoiceauditDBDAO dbDao=null;

	/**
	 * railInvoiceauditBCImpl 객체 생성<br>
	 * railInvoiceauditDBDAO를 생성한다.<br>
	 */
	public RailInvoiceauditBCImpl(){
		dbDao = new RailInvoiceauditDBDAO();
	}

	/**
	 * Payment VNDR Info 이벤트 처리<br>
	 * railInvoiceaudit화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_038Event
	 * @return EventResponse ESD_TRS_038EventResponse
	 * @exception EventException
	 */
	public EventResponse searchPaymentVndrList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0038Event event=(EsdTrs0038Event)e;
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			rowSet=dbDao.searchPaymentVndrList(event);
			while(rowSet.next()){
				eventResponse.setETCData("payment_vndr_code", rowSet.getString("VNDR_SEQ"));
				eventResponse.setETCData("payment_vndr_name", rowSet.getString("VNDR_LGL_ENG_NM"));
				eventResponse.setETCData("flag", rowSet.getString("FLAG"));
			}
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage()); 
		}
	}
	
		
	/**
	 * 조회 이벤트 처리<br>
	 * Railinvoiceaudit화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_038EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRailinvoiceauditList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0038Event event=(EsdTrs0038Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		DBRowSet rowSet = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet1 = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet2 = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet3 = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		try {
			rowSet = dbDao.searchRailinvoiceaudit(event);
			rowSet1 = dbDao.searchRailinvoiceauditList(event , "C" );
			rowSet2 = dbDao.searchRailinvoiceauditList(event , "D" );
			rowSet3 = dbDao.searchRailinvoiceauditList(event , "I" );
			
			while(rowSet.next()){
				eventResponse.setETCData("trsp_inv_aud_sts_cd", rowSet.getString("TRSP_INV_AUD_STS_CD"));
				eventResponse.setETCData("payment_vndr_code", rowSet.getString("WO_VNDR_SEQ"));
				eventResponse.setETCData("payment_vndr_name", rowSet.getString("WO_VNDR_NM"));
				eventResponse.setETCData("rail_road_code", rowSet.getString("INV_VNDR_SEQ"));
				eventResponse.setETCData("rail_road_name", rowSet.getString("INV_VNDR_NM"));
				eventResponse.setETCData("receive_dt", rowSet.getString("INV_RCV_DT"));
				eventResponse.setETCData("issue_dt", rowSet.getString("INV_ISS_DT"));
				eventResponse.setETCData("currency", rowSet.getString("INV_CURR_CD"));
				eventResponse.setETCData("invoice_amt", rowSet.getString("INV_BZC_AMT"));
				eventResponse.setETCData("vat_amt", rowSet.getString("INV_VAT_AMT"));
			}			
			
			eventResponse.setRsVo(rowSet1);
			eventResponse.setRsVo(rowSet2);
			eventResponse.setRsVo(rowSet3);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage()); 
		}
	}

	
	/**
	 * 조회 이벤트 처리<br>
	 * Container History화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_038EventResponse
	 * @exception EventException
	 */
	public EventResponse searchPaymentHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0929Event event=(EsdTrs0929Event)e;
		DBRowSet rowSet = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			rowSet=dbDao.searchPaymentHistoryList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	

	/**
	 *수정 이벤트 처리<br>
	 * ESD_TRS_038 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_038Event
	 * @return EventResponse ESD_TRS_038EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyRailinvoiceaudit(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0038Event event=(EsdTrs0038Event)e;

		try {
				dbDao.modifyTRS_TRSP_RAIL_INV_DTL(event);
				return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * CLM History화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e 
	 * @return 
	 * @exception EventException
	 */
	public DBRowSet[] searchReAuditVerify(Event e) throws EventException {
//		 PDTO(Data Transfer Object including Parameters)
		EsdTrs0038Event event=(EsdTrs0038Event)e;
		
		try {
			return dbDao.searchReAuditVerify( event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * CLM History화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e 
	 * @return response ESD_TRS_038EventResponse
	 * @exception EventException
	 */
	public EventResponse searchReAuditInfoList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0925Event event=(EsdTrs0925Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSetSxml1=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSetSxml2=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSetSxml3=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		try {
			rowSetSxml1=dbDao.searchCLMHistory(event);
			rowSetSxml2=dbDao.searchInvoiceList(event);
			rowSetSxml3=dbDao.searchBillingList(event);
			
			eventResponse.setRsVo(rowSetSxml1);
			eventResponse.setRsVo(rowSetSxml2);
			eventResponse.setRsVo(rowSetSxml3);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Re Audit화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_038EventResponse
	 * @exception EventException
	 */
	public EventResponse searchContainerInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0038Event event=(EsdTrs0038Event)e;
		DBRowSet rowSet= null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			rowSet=dbDao.searchContainerInfo(event);
			eventResponse.setRsVo(rowSet);
		
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * Verify Cntr No 이벤트 처리<br>
	 * railInvoiceaudit화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_923Event
	 * @return EventResponse ESD_TRS_923EventResponse
	 * @exception EventException
	 */
	public ArrayList verifyInvoiceFileImportEqNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0923Event event=(EsdTrs0923Event)e;

		try {
			return dbDao.verifyInvoiceFileImportEqNo(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * Verify Cntr No 이벤트 처리<br>
	 * railInvoiceaudit화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_923Event
	 * @return EventResponse ESD_TRS_923EventResponse
	 * @exception EventException
	 */
	public ArrayList verifyInvoiceFileImportInvNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0923Event event=(EsdTrs0923Event)e;

		try {
			return dbDao.verifyInvoiceFileImportInvNo(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * Verify Cntr No 이벤트 처리<br>
	 * railInvoiceaudit화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_923Event
	 * @return EventResponse ESD_TRS_923EventResponse
	 * @exception EventException
	 */
	public ArrayList verifyInvoiceFileImportVndrSetList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0923Event event=(EsdTrs0923Event)e;

		try {
			return dbDao.verifyInvoiceFileImportVndrSetList(event);

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * Verify Cntr No 이벤트 처리<br>
	 * railInvoiceaudit화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_923Event
	 * @return EventResponse ESD_TRS_923EventResponse
	 * @exception EventException
	 */
	public ArrayList verifyInvoiceFileImportSoIFList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0923Event event=(EsdTrs0923Event)e;

		try {
			return dbDao.verifyInvoiceFileImportSoIFList(event);

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	
	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * railInvoiceaudit업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}