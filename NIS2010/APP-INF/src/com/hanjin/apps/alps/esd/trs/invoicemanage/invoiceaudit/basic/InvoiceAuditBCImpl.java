/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : invoiceauditBCImpl.java
*@FileTitle : invoice Audit Manage
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-06
*@LastModifier : Lee_SangWoo
*@LastVersion : 1.0
* 2006-12-06 Lee_SangWoo
* 1.0 최초 생성
* 2013.02.26 조인영 [CHM-201323086] Invoice Audit시 validation 추가 요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.basic;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.event.EsdTrs0033Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.event.EsdTrs0040Event;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.integration.InvoiceAuditDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.TrsTrspSvcOrdVO;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * ESD-invoicemanage Business Logic Basic Command implementation<br>
 * - ESD-invoicemanage에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Lee_SangWoo
 * @see ESD_TRS_910EventResponse,InvoiceAuditBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class InvoiceAuditBCImpl   extends BasicCommandSupport implements InvoiceAuditBC {
	// Database Access Object
	private transient InvoiceAuditDBDAO dbDao=null;

	/**
	 * InvoiceAuditBCImpl 객체 생성<br>
	 * InvoiceAuditDBDAO를 생성한다.<br>
	 */
	public InvoiceAuditBCImpl(){
		dbDao = new InvoiceAuditDBDAO();
	}
	
	/**
	 * bkg_no와 EQ가 mapping이 되어있는 컨테이너를 조회<br>
	 * 조회 이벤트 처리<br>
	 * 
	 * @param inputRs
	 * @param model
	 * @return String
	 * @exception EventException
	 */
	public String searchInvoiceImportBkgBkgCntr(DBRowSet inputRs, TrsTrspSvcOrdVO model) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		try {
			return dbDao.searchInvoiceImportBkgBkgCntr(inputRs, model);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * bkg_no와 EQ가 mapping이 되어있는 컨테이너를 조회<br>
	 * 조회 이벤트 처리<br>
	 * 
	 * @param svcModel
	 * @param model
	 * @return String
	 * @exception EventException
	 */
	public String searchInvoiceImportBkgBkgCntr2(TrsTrspSvcOrdVO svcModel, TrsTrspSvcOrdVO model) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		try {
			return dbDao.searchInvoiceImportBkgBkgCntr2(svcModel, model);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Reject Invoice<br>
	 * Reject 이벤트 처리<br>
	 * 
	 * @param eqNo
	 * @return 
	 * @exception EventException
	 */
	public String verifyEqNo(String eqNo) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		try {
			return dbDao.verifyEqNo(eqNo);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Reject Invoice<br>
	 * Reject 이벤트 처리<br>
	 * 
	 * @param e
	 * @return 
	 * @exception EventException
	 */
	public EventResponse searchTruckInvoiceFileImport(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event=(EsdTrs0033Event)e;
		
		try {
			List rsList = dbDao.searchTruckInvoiceFileImport(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVoList(rsList);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Reject Invoice<br>
	 * Reject 이벤트 처리<br>
	 * 
	 * @param e
	 * @return 
	 * @exception EventException
	 */
	public ArrayList searchInvoiceImportSO(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event=(EsdTrs0033Event)e;
		try {
			return dbDao.searchInvoiceImportSO(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Reject Invoice<br>
	 * Reject 이벤트 처리<br>
	 * 
	 * @param e
	 * @return 
	 * @exception EventException
	 */
	public ArrayList searchInvoiceImportWO(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event=(EsdTrs0033Event)e;
		try {
			return dbDao.searchInvoiceImportWO(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Reject Invoice<br>
	 * Reject 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	public ArrayList searchInvoiceImportEmptyWO(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event=(EsdTrs0033Event)e;
		try {
			return dbDao.searchInvoiceImportEmptyWO(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Reject Invoice<br>
	 * Reject 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	public EventResponse rejectInvoice(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event=(EsdTrs0033Event)e;
		try {
			dbDao.rejectInvoice(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Reject Invoice<br>
	 * Reject 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMdmOrganization(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event=(EsdTrs0033Event)e;
		FormCommand formcommand = e.getFormCommand();
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		try {
			rowSet = dbDao.searchMdmOrganization(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			while(rowSet.next()){				
				if(formcommand.isCommand(FormCommand.SEARCH12)){
					eventResponse.setETCData("bil_curr_cd", rowSet.getString("BIL_CURR_CD"));
					eventResponse.setETCData("cnt_cd", rowSet.getString("CNT_CD"));
					
				}
			}
			return eventResponse;
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());						
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Invoice File Import의 verify<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	public EventResponse searchInvOfcCd(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event=(EsdTrs0033Event)e;
		FormCommand formcommand = e.getFormCommand();
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet = dbDao.searchInvOfcCd(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			StringBuffer returnStr = new StringBuffer();
			int cnt = 0;
			if(formcommand.isCommand(FormCommand.SEARCH10)){
				while(rowSet != null && rowSet.next()){	
					if(cnt == 0){
						returnStr.append(rowSet.getString("OFC_CD"));
						cnt++;
					}else{
						returnStr.append("|");
						returnStr.append(rowSet.getString("OFC_CD"));
						cnt++;
					}
				}
			
				eventResponse.setETCData("ofc_cd", returnStr.toString());
					
			}

			return eventResponse;
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());						
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
	}
	
	/**
	 * invoiceaudit화면에 대한 저장 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	public EventResponse saveInvoiceAudit(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event=(EsdTrs0033Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		try {
			dbDao.saveInvoiceAudit(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * invoice 리스트 가져오기<br>
	 * invoice audit 화면에 대한 Confirm 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	public EventResponse confirmInvoiceAudit(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event=(EsdTrs0033Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		try {
			dbDao.confirmInvoiceAudit(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * invoice 리스트 가져오기<br>
	 * invoiceaudit화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_0033EventResponse
	 * @exception EventException
	 */
	public EventResponse searchInvoiceAuditList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event=(EsdTrs0033Event)e;

		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchInvoiceAuditList(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * invoice 리스트 가져오기<br>
	 * invoiceaudit화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	public EventResponse searchInvoiceAuditListByInvoiceNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event=(EsdTrs0033Event)e;

		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchInvoiceAuditListByInvoiceNo(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			String[] colValue = null;
			if( rowSet != null ){
				colValue = new String[rowSet.getMetaData().getColumnCount()];
				for(int k=1; k<rowSet.getMetaData().getColumnCount()+1 ; k++) {
					colValue[k-1] = rowSet.getMetaData().getColumnName(k);
				}
			
				Map<String, String[]> colOrders = new HashMap<String, String[]>();
				colOrders.put("COLORDER", colValue);
				eventResponse.setColOrders(colOrders);
			}

			return eventResponse;
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());						
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * invoiceaudit화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchDupChkInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event=(EsdTrs0033Event)e;

		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		try {
			rowSet=dbDao.searchDupChkInvoice(event);
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
	 * invoiceaudit화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	public EventResponse searchPaymentSP(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event=(EsdTrs0033Event)e;
		FormCommand formcommand = e.getFormCommand();
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchPaymentSP(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			
			while(rowSet.next()){				
				if(formcommand.isCommand(FormCommand.SEARCH02)){
					eventResponse.setETCData("prnt_vndr_seq", rowSet.getString("PRNT_VNDR_SEQ"));
					eventResponse.setETCData("prnt_vndr_nm", rowSet.getString("PRNT_VNDR_NM"));
					
					eventResponse.setETCData("ida_gst_rgst_sts_cd",      rowSet.getString("IDA_GST_RGST_STS_CD"));
					eventResponse.setETCData("ida_gst_rgst_no",          rowSet.getString("IDA_GST_RGST_NO"));
					eventResponse.setETCData("ida_ste_cd",               rowSet.getString("IDA_STE_CD"));
					eventResponse.setETCData("ida_ste_nm",               rowSet.getString("IDA_STE_NM"));					
					eventResponse.setETCData("prnt_ida_gst_rgst_sts_cd", rowSet.getString("PRNT_IDA_GST_RGST_STS_CD"));
					eventResponse.setETCData("prnt_ida_gst_rgst_no",     rowSet.getString("PRNT_IDA_GST_RGST_NO"));
					eventResponse.setETCData("prnt_ida_ste_cd",          rowSet.getString("PRNT_IDA_STE_CD"));
					eventResponse.setETCData("prnt_ida_ste_nm",          rowSet.getString("PRNT_IDA_STE_NM"));
				}
			}
			
			return eventResponse;
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());						
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
		
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * invoice refund화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_040EventResponse
	 * @exception EventException
	 */
	public EventResponse multiInvoiceAuditRefund(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0040Event event=(EsdTrs0040Event)e;

		try {
			dbDao.multiTRS_TRSP_RFND_INV(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	

			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * invoice refund화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_040EventResponse
	 * @exception EventException
	 */
	public EventResponse searchPaymentVnder(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0040Event event=(EsdTrs0040Event)e;
		FormCommand formcommand = e.getFormCommand();
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet = dbDao.searchPaymentVnder(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			
			
			while(rowSet.next()){				
				if(formcommand.isCommand(FormCommand.SEARCH02)){
					eventResponse.setETCData("inv_vndr_seq", rowSet.getString("INV_VNDR_SEQ"));
					eventResponse.setETCData("inv_vndr_nm", rowSet.getString("INV_VNDR_NM"));
				}
			}
			return eventResponse;
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());						
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * invoice refund화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchInvoiceNo(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
				
		EsdTrs0040Event event=(EsdTrs0040Event)e;
		FormCommand formcommand = e.getFormCommand();
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchInvoiceNo(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			
			while(rowSet.next()){				
				if(formcommand.isCommand(FormCommand.SEARCH02)){
					eventResponse.setETCData("inv_flag", rowSet.getString("INV_FLAG"));
				}
			}
			
			return eventResponse;
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());						
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * invoice refund화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRefundList(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0040Event event=(EsdTrs0040Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet = dbDao.searchRefundList(event);
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
	 * Invoice File Import의 verify<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse verifyEqNo(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event=(EsdTrs0033Event)e;
		DBRowSet[] rowSets =null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSets = dbDao.verifyEqNo(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSets);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Invoice File EXCHAGE RATE계산<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse calculateExchangeRate(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event=(EsdTrs0033Event)e;
		FormCommand formcommand = e.getFormCommand();
		DBRowSet rowSet =null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			
			rowSet=dbDao.calculateExchangeRate(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			
			while(rowSet.next()){				
				if(formcommand.isCommand(FormCommand.SEARCH13)){
					eventResponse.setETCData("inv_bzc_amt", rowSet.getString("INV_BZC_AMT"));
				}
			}
			
			return eventResponse;
			
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());						
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
	}
	
	/**
	 * searchPaymentChildVnder<br>
	 * select 이벤트 처리<br>
	 * 
	 * @param vndrSeq
	 * @return ArrayList
	 * @exception EventException
	 */
	public ArrayList searchPaymentChildVnder(String vndrSeq) throws EventException{
		try {
			return dbDao.searchPaymentChildVnder(vndrSeq);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * searchInvoiceImportDuplicateCheckByDate<br>
	 * data에 의한 중복체크 처리 +- 2일 <br>
	 * 
	 * @param model TrsTrspSvcOrdVO
	 * @return ArrayList
	 * @exception EventException
	 */
	public ArrayList searchInvoiceImportDuplicateCheckByDate(TrsTrspSvcOrdVO model) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		try {
			return dbDao.searchInvoiceImportDuplicateCheckByDate(model);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * S/O Creation 날짜 기준으로 Invoice 중복여부를 조회<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchInvoiceImportDuplicateCheckByDate2(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event=(EsdTrs0033Event)e;
		try {
			List rsList = dbDao.searchInvoiceImportDuplicateCheckByDate2(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(rsList);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
	}
	
	/**
	 *  SO의 Suchargy를 가지고 온다.<br>
	 * 
	 * @param event
	 * 
	 * @return ArrayList
	 * @throws EventException
	 */
	public ArrayList searchWoSurcharge(EsdTrs0033Event event) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		try {
			return dbDao.searchWoSurcharge(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * WO issue , Invoice 처리 안된 데이터인지 체크.<br>
	 * 
	 * @param event
	 * @throws EventException
	 */
	public void checkConfirmInvoice(EsdTrs0033Event event) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		try {
			dbDao.checkConfirmInvoice(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Invoice confirm 생성 및 수정<br>
	 * 
	 * @param event
	 * 
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse confirmInvoiceAuditForMain(EsdTrs0033Event event) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		try {
			 dbDao.confirmInvoiceAuditForMain(event);
			 GeneralEventResponse eventResponse = new GeneralEventResponse();	
			 return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Invoice Confirm 처리한다.<br>
	 * 
	 * @param event
	 * @param row
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse confirmInvoiceAuditForSvcOrd(EsdTrs0033Event event, int row) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		try {
			 dbDao.confirmInvoiceAuditForSvcOrd(event, row);
			 GeneralEventResponse eventResponse = new GeneralEventResponse();	
			 return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Invoice 상태를 Save 상태로 Rollback.<br>
	 * 
	 * @param event
	 * @throws EventException
	 */
	public void rollbackInvoiceAuditForMain(EsdTrs0033Event event) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		try {
			dbDao.rollbackInvoiceAuditForMain(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * invoicemanage 업무 시나리오 마감작업<br>
	 * invoiceaudit업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
	
	/**
	 * 기존 저장된 3rd party billing currency를 가져온다.<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchN3ptyCurrCd(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event=(EsdTrs0033Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet = dbDao.searchN3ptyCurrCd(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * WO SP의 PARENTS SP를 가져온다<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchVendor(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0040Event event=(EsdTrs0040Event)e;
		FormCommand formcommand = e.getFormCommand();
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchVendor(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			
			while(rowSet.next()){				
				if(formcommand.isCommand(FormCommand.SEARCH03)){
					eventResponse.setETCData("vndr_no", rowSet.getString("VNDR_NO"));
					eventResponse.setETCData("vndr_nm_eng", rowSet.getString("VNDR_NM_ENG"));
				}
			}
			
			return eventResponse;
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());						
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
		
	}
	/**
	 * 조회 이벤트 처리<br>
	 * SO Amt 일치 여부를 검사한다.<br>
	 * 
	 * @param model TrsTrspSvcOrdVO
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchSOAmt(TrsTrspSvcOrdVO model) throws EventException {
		DBRowSet rowSet = null; 
		try {
			rowSet = dbDao.searchSOAmt(model);
			//eventResponse.setRs(rowSet);
			return rowSet;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
	}
	
	public String getIndiaOfcCdChk(String ofcCd) throws EventException {		
		try {
			return dbDao.getIndiaOfcCdChk(ofcCd) ;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	public EventResponse searchIdaTaxRto(Event e) throws EventException {
		DBRowSet rowSet=null;
		EsdTrs0033Event event=(EsdTrs0033Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			rowSet=dbDao.searchIdaTaxRto(event);
			if(rowSet.next()){
				eventResponse.setETCData("ida_cgst_rto", JSPUtil.getNull(rowSet.getString("IDA_CGST_RTO"),""));
				eventResponse.setETCData("ida_sgst_rto", JSPUtil.getNull(rowSet.getString("IDA_SGST_RTO"),""));
				eventResponse.setETCData("ida_igst_rto", JSPUtil.getNull(rowSet.getString("IDA_IGST_RTO"),""));
				eventResponse.setETCData("ida_ugst_rto", JSPUtil.getNull(rowSet.getString("IDA_UGST_RTO"),""));
			}
			eventResponse.setRsVo(rowSet);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return eventResponse;
	}

	public EventResponse verifySacNo(Event e) throws EventException {
		DBRowSet rowSet=null;
		EsdTrs0033Event event=(EsdTrs0033Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			rowSet = dbDao.verifySacNo(event);
			if(rowSet.next()){
				eventResponse.setETCData("sac_no_exist", JSPUtil.getNull(rowSet.getString("SAC_NO_EXIST"),""));
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return eventResponse;
	}

}