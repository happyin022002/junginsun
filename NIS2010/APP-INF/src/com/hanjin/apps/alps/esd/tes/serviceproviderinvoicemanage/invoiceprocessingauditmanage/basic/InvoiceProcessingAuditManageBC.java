/***************************************************************************************
 * =========================================================
 * Copyright(c) 2006 CyberLogitec
 * @FileName : InvoiceProcessingAuditManageBC.java
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

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ALPS-ESD Business Logic Command Interface<br>
 * - ALPS-ESD에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 
 * @see EventResponse 참조
 * @since J2EE 1.6 
 */
public interface InvoiceProcessingAuditManageBC  {


	/**
	 * 추가 이벤트 처리<br>
	 * ESD_TES_0015 에 대한 추가 이벤트 처리<br>
	 *
	 * @param e EsdTes0015Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAuditTerminalInvoiceContainerList(Event e) throws EventException;

	/**
	 * 추가 이벤트 처리<br>
	 * ESD_TES_0015 에 대한 추가 이벤트 처리<br>
	 *
	 * @param e EsdTes0015Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAuditOndockRailChargeContainerList(Event e) throws EventException;
	
	/**
	 * 추가 이벤트 처리<br>
	 * ESD_TES_0015 에 대한 추가 이벤트 처리<br>
	 *
	 * @param e EsdTes0015Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAuditOffdockCYContainerList(Event e) throws EventException;
	
	/**
	 * 추가 이벤트 처리<br>
	 * ESD_TES_0015 에 대한 추가 이벤트 처리<br>
	 *
	 * @param e EsdTes0015Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAuditStorageContainerList(Event e) throws EventException;
	

}