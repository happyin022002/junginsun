/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : PoolChassisBC.java
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
  
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ENIS-PoolChassis Business Logic Command Interface<br>
 * - ENIS-PoolChassis에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author ah young Han
 * @see EsdTrs0041EventResponse 참조
 * @since J2EE 1.4
 */
public interface PoolChassisBC  {
  
	/**
	 * Invoice Pool 샤시를 임시적으로 저장시 추가하는 이벤트처리<br>
	 * 
	 * @param e ESD_TRS_041Event
	 * @return EventResponse ESD_TRS_041EventResponse
	 * @exception EventException
	 */
	public EventResponse insertInvoicePoolChassis(Event e) throws EventException;
	/**
	 * Invoice Pool 샤시를 임시적으로 저장시 업데이트하는 이벤트처리<br>
	 * 
	 * @param e ESD_TRS_041Event
	 * @return EventResponse ESD_TRS_041EventResponse
	 * @exception EventException
	 */
	public EventResponse updateInvoicePoolChassis(Event e) throws EventException;


	/**
	 * Invoice Pool 샤시를 confirm 및 저장 추가 이벤트처리<br>
	 * 
	 * @param e ESD_TRS_041Event
	 * @return EventResponse ESD_TRS_041EventResponse
	 * @exception EventException
	 */
	public EventResponse confirmInsertInvoicePoolChassis(Event e) throws EventException;
	/**
	 * Invoice Pool 샤시를 confirm 및 저장 업데이트 이벤트처리<br>
	 * 
	 * @param e ESD_TRS_041Event
	 * @return EventResponse ESD_TRS_041EventResponse
	 * @exception EventException
	 */
	public EventResponse confirmUpdateInvoicePoolChassis(Event e) throws EventException;

	/**
	 * Invoice Pool 샤시를 조회하는 이벤트처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchInvoicePoolChassisList(Event e) throws EventException;
	

	/**
	 * 샤시 Pool에 대해 매핑된 Payment S/P 를 조회한다.<br>
	 * 
	 * @return response ESD_TRS_041EventResponse
	 * @exception EventException
	 */
	public EventResponse getPaymentSPList(Event e) throws EventException;	

	
	/**
	 * Invoice No에 대하여 중복체크를 한다.<br>	 
	 * 
	 * @param e ESD_TRS_041Event
	 * @return EventResponse ESD_TRS_041EventResponse
	 * @exception EventException
	 */
	public EventResponse dupChkPoolChassisInvoiceNo(Event e) throws EventException;

	/**
	 * Invoice No에 다한 Confirm 처리하는 이벤트 <br>	
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse confirmInvoicePoolChassis(Event e) throws EventException;
	

	/**
	 * Invoice No에 다한 Confirm 을 Cancel 처리하는 이벤트 <br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse confirmCancelInvoicePoolChassis(Event e) throws EventException;		
	/**
	 * Invoice Pool 샤시를 삭제하는 이벤트 <br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse deleteInvoicePoolChassis(Event e) throws EventException;
	/**
	 * chss Pool 을 조회하는 이벤트 <br>
	 * 
	 * @return response ESD_TRS_041EventResponse
	 * @exception EventException
	 */
	public EventResponse getPoolList(Event e) throws EventException;
}