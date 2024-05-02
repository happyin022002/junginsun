/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : PoolChassisBC.java
*@FileTitle : Pool Chassis reposition cost process
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.poolchassis.basic;
  
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.syscommon.common.table.ApPayInvDtlVO;
import com.clt.syscommon.common.table.ApPayInvVO;

/**
 * PoolChassis Business Logic Command Interface<br>
 * An interface to the business logic for Pool Chassis reposition cost<br>
 *
 * @author
 * @see Refer to EsdTrs0041EventResponse
 * @since 
 */
public interface PoolChassisBC  {
  
	/**
	 * Stored temporarily on the Invoice Pool chassis to add event handling <br>
	 * 
	 * @param e ESD_TRS_041Event
	 * @return EventResponse ESD_TRS_041EventResponse
	 * @exception EventException
	 */
	public EventResponse insertInvoicePoolChassis(Event e) throws EventException;
	/**
	 * Stored temporarily on the Invoice Pool chassis to add event handling <br>
	 * 
	 * @param e ESD_TRS_041Event
	 * @return EventResponse ESD_TRS_041EventResponse
	 * @exception EventException
	 */
	public EventResponse updateInvoicePoolChassis(Event e) throws EventException;


	/**
	 * Stored temporarily on the Invoice Pool chassis to add and save event handling <br>
	 * 
	 * @param e ESD_TRS_041Event
	 * @return EventResponse ESD_TRS_041EventResponse
	 * @exception EventException
	 */
	public EventResponse confirmInsertInvoicePoolChassis(Event e) throws EventException;
	
	/**
	 * AP_INV_MAIN set<br>
	 * 
	 * @param e ESD_TRS_041Event
	 * @return AP_INV_MAIN set
	 * @exception EventException
	 */
	public ApPayInvVO searchApPayInvMain(Event e) throws EventException;
	
	/**
	 * AP_INV_DTL Set<br>
	 * 
	 * @param e ESD_TRS_041Event
	 * @return AP_INV_DTL Set
	 * @exception EventException
	 */
	public ApPayInvDtlVO[] searchApPayInvDetail(Event e) throws EventException;
	
	/**
	 * Invoice Pool chassis confirm the event process and store updates<br>
	 * 
	 * @param e ESD_TRS_041Event
	 * @return EventResponse ESD_TRS_041EventResponse
	 * @exception EventException
	 */
	public EventResponse confirmUpdateInvoicePoolChassis(Event e) throws EventException;

	/**
	 * Invoice Pool chassis retrieve event process<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchInvoicePoolChassisList(Event e) throws EventException;
	

	/**
	 * Mapped for Chassis Pool Payment S / P to be viewed.<br>
	 * 
	 * @return response ESD_TRS_041EventResponse
	 * @exception EventException
	 */
	public EventResponse getPaymentSPList(Event e) throws EventException;	

	
	/**
	 * Redundancy check with Invoice No<br>	 
	 * 
	 * @param e ESD_TRS_041Event
	 * @return EventResponse ESD_TRS_041EventResponse
	 * @exception EventException
	 */
	public EventResponse dupChkPoolChassisInvoiceNo(Event e) throws EventException;

	/**
	 * Invoice No Confirm event process <br>	
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse confirmInvoicePoolChassis(Event e) throws EventException;
	

	/**
	 * Invoice No Confirm to Cancel event process <br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse confirmCancelInvoicePoolChassis(Event e) throws EventException;		
	/**
	 * Delete the event that the Invoice Pool chassis <br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse deleteInvoicePoolChassis(Event e) throws EventException;
	/**
	 * chassis Pool retrieve event process <br>
	 * 
	 * @return response ESD_TRS_041EventResponse
	 * @exception EventException
	 */
	public EventResponse getPoolList(Event e) throws EventException;
}