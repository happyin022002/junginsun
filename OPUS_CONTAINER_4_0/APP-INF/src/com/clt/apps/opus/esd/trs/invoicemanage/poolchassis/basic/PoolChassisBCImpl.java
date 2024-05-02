/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : PoolChassisBCImpl.java
*@FileTitle : Pool Chassis reposition cost process
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0  
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.poolchassis.basic;


import java.sql.SQLException;
import java.util.List;

import com.clt.apps.opus.esd.trs.invoicemanage.poolchassis.event.EsdTrs0041Event;
import com.clt.apps.opus.esd.trs.invoicemanage.poolchassis.integration.PoolChassisDBDAO;
import com.clt.apps.opus.esd.trs.invoicemanage.poolchassis.vo.SearchInvoicePoolChassisVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.ApPayInvDtlVO;
import com.clt.syscommon.common.table.ApPayInvVO;



/**  
 * PoolChassis Business Logic Basic Command implementation<br>
 * PoolChassis handling business logic.<br>
 * 
 * @author 
 * @see ESD_TRS_041EventResponse,PoolChassisBC refer to each DAO classes
 * @since 
 */
public class PoolChassisBCImpl extends BasicCommandSupport implements PoolChassisBC {

	// Database Access Object
	private transient PoolChassisDBDAO dbDao=null;

	/**
	 * PoolChassisBCImpl object creation<br>
	 * Generate PoolChassisDBDAO<br>
	 */
	public PoolChassisBCImpl(){
		dbDao = new PoolChassisDBDAO();
	}

	/**
	 * Invoice No list retrieve.<br>
	 * PoolChassis retrieve event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_041EventResponse
	 * @exception EventException
	 */
	public EventResponse searchInvoicePoolChassisList(Event e) throws EventException {
		EsdTrs0041Event event=(EsdTrs0041Event)e;
		FormCommand formcommand = e.getFormCommand();
		DBRowSet rowSetHead=null; //For transferring data to DB ResultSet object
		DBRowSet rowSet=null; //For transferring data to DB ResultSet object
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
					eventResponse.setETCData("chss_pool_nm", rowSetHead.getString("CHSS_POOL_NM"));
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
	 * Redundancy check with invoice No<br>
	 * invoice refund retrieve event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_040EventResponse
	 * @exception EventException
	 */
	public EventResponse dupChkPoolChassisInvoiceNo(Event e) throws EventException{
		EsdTrs0041Event event=(EsdTrs0041Event)e;
		FormCommand formcommand = e.getFormCommand();
		DBRowSet rowSet=null; //For transferring data to DB ResultSet object
		
		try {
			rowSet = dbDao.dupChkPoolChassisInvoiceNo(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			if(formcommand.isCommand(FormCommand.SEARCH03)){
				eventResponse.setETCData("inv_flag", String.valueOf(rowSet.getRowCount()));
			}
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
	}
	
	
	/**
	 * Pool Chassis Invoice information is stored with the Save status.<br>
	 * invoiceaudit retrieve event process<br>
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
	 * Pool Chassis Invoice information is stored with the Save status.<br>
	 * invoiceaudit retrieve event process<br>
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
	 * Pool Chassis Invoice information is stored with the Confirm status.<br>
	 * invoiceaudit retrieve event process<br>
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
	 * Pool Chassis Invoice information set in ApPayInvVO.<br>
	 * 
	 * @param e
	 * @return apPayInvVO ApPayInvVO
	 * @exception EventException
	 */
	public ApPayInvVO searchApPayInvMain(Event e) throws EventException {
		ApPayInvVO apPayInvVO = new ApPayInvVO();
		EsdTrs0041Event event=(EsdTrs0041Event)e;
		SearchInvoicePoolChassisVO searchInvoicePoolChassisVo = event.getSearchInvoicePoolChassisVo();
		
		try {
			List<ApPayInvVO> list = dbDao.searchApPayInvMain(searchInvoicePoolChassisVo);
			apPayInvVO = (ApPayInvVO)list.get(0);
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
		
		return apPayInvVO;
	}
	
	/**
	 * Pool Chassis Invoice Detail information set in ApPayInvDtlVOs.<br>
	 * 
	 * @param e
	 * @return apPayInvVOs ApPayInvDtlVO[]
	 * @exception EventException
	 */
	public ApPayInvDtlVO[] searchApPayInvDetail(Event e) throws EventException {
		ApPayInvDtlVO[] apPayInvDtlVOs = null;
		EsdTrs0041Event event=(EsdTrs0041Event)e;
		SearchInvoicePoolChassisVO searchInvoicePoolChassisVo = event.getSearchInvoicePoolChassisVo();
		
		try {
			List<ApPayInvDtlVO> list = dbDao.searchApPayInvDetail(searchInvoicePoolChassisVo);
			
			if(list != null){
				apPayInvDtlVOs = new ApPayInvDtlVO[list.size()];
				
				for(int i=0; i<list.size(); i++){
					ApPayInvDtlVO apPayInvDtlVO = new ApPayInvDtlVO();
					apPayInvDtlVO = (ApPayInvDtlVO)list.get(i);
					apPayInvDtlVOs[i] = apPayInvDtlVO;
				}	
			}
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
		
		return apPayInvDtlVOs;
	}
	
	
	/**
	 * Pool Chassis Invoice information is stored with the Confirm status.<br>
	 * invoiceaudit retrieve event process<br>
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
	 * Chassis for Pool Payment S / P to be viewed.<br>
	 * invoiceaudit retrieve event process<br>
	 * 
	 * @return response ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	public EventResponse getPaymentSPList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0041Event event=(EsdTrs0041Event)e;
		FormCommand formcommand = e.getFormCommand();
		DBRowSet rowSet=null; //For transferring data to DB ResultSet object
		
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
	 * Invoice information is stored with the Confirm status.<br>
	 * invoiceaudit retrieve event process<br>
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
	 * Chassis Pool Invoice was about to confirm will be canceled.<br>
	 * invoiceaudit retrieve event process<br>
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
	 * Chassis Pool Invoice information delete.<br>
	 * invoiceaudit retrieve event process<br>
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
	 * PoolChassis  retrieve.<br>
	 * PoolChassis retrieve event process<br>
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
	 * PoolChassis biz scenario closing<br>
	 * PoolChassis clearing related objects<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}