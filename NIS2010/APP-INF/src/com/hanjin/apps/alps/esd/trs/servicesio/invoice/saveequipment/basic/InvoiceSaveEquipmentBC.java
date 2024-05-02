/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceCreationBC.java
*@FileTitle : SPP TRS Invoice Basic Command 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-28
*@LastModifier : sunghwan cho
*@LastVersion : 1.0
* 2006-12-28 sunghwan cho
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.saveequipment.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * Basic Command<br>
 * - SPP TRS Invoice Basic Command<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public interface InvoiceSaveEquipmentBC  {

	/**
	 * checkInvoiceNumber<br>
	 * 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response int
	 * @exception EventException
	 */
	public int checkInvoiceNumber(Event e) throws EventException;

}