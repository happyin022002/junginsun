/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : PoolChassisBCImpl.java
*@FileTitle : Pool Chassis reposition cost 처리
*Open Issues :
*Change history :
*@LastModifyDate : 2008-12-04
*@LastModifier : ah young Han
*@LastVersion : 1.0  
* 2008-12-04 ah young Han
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.poolchassis.basic;


import java.sql.SQLException;
import com.hanjin.apps.alps.esd.trs.invoicemanage.poolchassis.event.EsdTrs0041Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.poolchassis.integration.PoolChassisDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;



/**  
 * ENIS-PoolChassis Business Logic Basic Command implementation<br>
 * - ENIS-PoolChassis에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author ah young Han
 * @see ESD_TRS_041EventResponse,PoolChassisBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class PoolChassisBCImpl extends BasicCommandSupport implements PoolChassisBC {

	// Database Access Object
	private transient PoolChassisDBDAO dbDao=null;

	/**
	 * PoolChassisBCImpl 객체 생성<br>
	 * PoolChassisDBDAO를 생성한다.<br>
	 */
	public PoolChassisBCImpl(){
		dbDao = new PoolChassisDBDAO();
	}

	/**
	 * Invoice No 내역을 조회한다.<br>
	 * PoolChassis화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_041EventResponse
	 * @exception EventException
	 */
	public EventResponse searchInvoicePoolChassisList(Event e) throws EventException {
		EsdTrs0041Event event=(EsdTrs0041Event)e;
		FormCommand formcommand = e.getFormCommand();
		DBRowSet rowSetHead=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSetHead=dbDao.searchInvociePoolChassisHead(event);
			rowSet=dbDao.searchInvoicePoolChassisList(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			while(rowSetHead.next()){				
				if(formcommand.isCommand(FormCommand.SEARCH01)){
					eventResponse.setETCData("inv_no", rowSetHead.getString("INV_NO"));  
					eventResponse.setETCData("paymt_sp_cd", rowSetHead.getString("INV_VNDR_SEQ"));  	
					eventResponse.setETCData("inv_curr_cd", rowSetHead.getString("INV_CURR_CD"));			 
					eventResponse.setETCData("inv_bzc_amt", rowSetHead.getString("INV_BZC_AMT")); 
					eventResponse.setETCData("inv_ttl_amt", rowSetHead.getString("INV_TTL_AMT"));  	 
					eventResponse.setETCData("inv_rcv_dt", rowSetHead.getString("INV_RCV_DT"));
					eventResponse.setETCData("inv_iss_dt", rowSetHead.getString("INV_ISS_DT"));
					eventResponse.setETCData("inv_vat_amt", rowSetHead.getString("INV_VAT_AMT")); 
					eventResponse.setETCData("pool_chss_cost_yrmon", rowSetHead.getString("POOL_CHSS_COST_YRMON"));  	 
					eventResponse.setETCData("chss_pool_cd", rowSetHead.getString("CHSS_POOL_CD"));
					eventResponse.setETCData("ofc_cd", rowSetHead.getString("CRE_OFC_CD"));
					eventResponse.setETCData("usr_id", rowSetHead.getString("CRE_USR_ID"));
					eventResponse.setETCData("trsp_inv_aud_sts_cd", rowSetHead.getString("TRSP_INV_AUD_STS_CD"));
					eventResponse.setETCData("inv_flag", String.valueOf(rowSet.getRowCount()));
				}
			}
			eventResponse.setRsVo(rowSet);
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
	 * Invoice No에 대한 중복 체크를 한다.<br>
	 * invoice refund화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_040EventResponse
	 * @exception EventException
	 */
	public EventResponse dupChkPoolChassisInvoiceNo(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0041Event event=(EsdTrs0041Event)e;
		FormCommand formcommand = e.getFormCommand();
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		try {
			rowSet = dbDao.dupChkPoolChassisInvoiceNo(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			while(rowSet.next()){				
				if(formcommand.isCommand(FormCommand.SEARCH03)){

					eventResponse.setETCData("inv_flag", rowSet.getString("INV_FLAG"));
					
				}
			}
			//eventResponse.setRsVo(rowSet);
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
	 * Pool 샤시 Invoice 정보를  Save 상태로 추가 저장한다.<br>
	 * invoiceaudit화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	public EventResponse insertInvoicePoolChassis(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0041Event event=(EsdTrs0041Event)e;

		try {
			dbDao.insertInvoicePoolChassis(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	
	/**
	 * Pool 샤시 Invoice 정보를 Save 상태로 저장한다.<br>
	 * invoiceaudit화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	public EventResponse updateInvoicePoolChassis(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0041Event event=(EsdTrs0041Event)e;

		try {
			dbDao.updateInvoicePoolChassis(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * Pool 샤시 Invoice 정보를 Confirm상태로 추가 저장한다.<br>
	 * invoiceaudit화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	public EventResponse confirmInsertInvoicePoolChassis(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0041Event event=(EsdTrs0041Event)e;

		try {
			dbDao.confirmInsertInvoicePoolChassis(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	
	/**
	 * Pool 샤시 Invoice 정보를 Confirm상태로 저장한다.<br>
	 * invoiceaudit화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	public EventResponse confirmUpdateInvoicePoolChassis(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0041Event event=(EsdTrs0041Event)e;

		try {
			dbDao.confirmUpdateInvoicePoolChassis(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}		
	  
	/**
	 * 샤시 Pool에 대한 Payment S/P를 가져온다.<br>
	 * invoiceaudit화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	public EventResponse getPaymentSPList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0041Event event=(EsdTrs0041Event)e;
		FormCommand formcommand = e.getFormCommand();
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		try {
			rowSet = dbDao.getPaymentSPList(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			while(rowSet.next()){				
				if(formcommand.isCommand(FormCommand.SEARCH10)){

					eventResponse.setETCData("paymt_sp_cd", rowSet.getString("INV_VNDR_SEQ"));
					eventResponse.setETCData("paymt_sp", rowSet.getString("VNDR_CNT_CD"));
					eventResponse.setETCData("paymt_sp_nm", rowSet.getString("INV_PAY_VNDR_NM"));
				}
			}
			//eventResponse.setRsVo(rowSet);
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
	 * invoice 를 Confirm상태로 저장한다.<br>
	 * invoiceaudit화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	public EventResponse confirmInvoicePoolChassis(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0041Event event=(EsdTrs0041Event)e;

		try {
			dbDao.confirmInvoicePoolChassis(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	/**
	 * Pool 샤시 Invoice에 대해 confirm된 것을 취소한다.<br>
	 * invoiceaudit화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	public EventResponse confirmCancelInvoicePoolChassis(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0041Event event=(EsdTrs0041Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		try {
			dbDao.confirmCancelInvoicePoolChassis(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	/**
	 * Pool 샤시 Invoice 정보를 삭제한다.<br>
	 * invoiceaudit화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	public EventResponse deleteInvoicePoolChassis(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0041Event event=(EsdTrs0041Event)e;

		try {
			dbDao.deleteInvoicePoolChassis(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * chassisPool을 조회한다.<br>
	 * PoolChassis화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response ESD_TRS_041EventResponse
	 * @exception EventException
	 */
	public EventResponse getPoolList(Event e) throws EventException {
		EsdTrs0041Event event=(EsdTrs0041Event)e;
		FormCommand formcommand = event.getFormCommand();
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		try {
			
			String chss_pool_cd = "";
			String chss_pool_nm = "";

			DBRowSet rowSet = dbDao.getPoolList();

			while(rowSet.next()){				
				if(formcommand.isCommand(FormCommand.SEARCH11)){
					chss_pool_cd = chss_pool_cd + "|" + rowSet.getString("CHSS_POOL_CD");
					chss_pool_nm = chss_pool_nm + "|" + rowSet.getString("CHSS_POOL_NM");
				}
			}

			eventResponse.setETCData("chss_pool_cd", chss_pool_cd);
			eventResponse.setETCData("chss_pool_nm", chss_pool_nm);
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
	 * PoolChassis 업무 시나리오 마감작업<br>
	 * PoolChassis업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}