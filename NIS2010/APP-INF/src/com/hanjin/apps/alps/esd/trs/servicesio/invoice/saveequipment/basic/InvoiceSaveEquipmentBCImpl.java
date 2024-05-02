/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceCreationBCImpl.java
*@FileTitle : SPP TRS Invoice Basic Command Implementation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-28
*@LastModifier : sunghwan cho
*@LastVersion : 1.0
* 2006-12-28 sunghwan cho : 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.saveequipment.basic;

import com.hanjin.apps.alps.esd.trs.servicesio.invoice.saveequipment.integration.InvoiceSaveEquipmentDBDAO;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.saveequipment.event.SppTrsI03Event;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * Basic Command Implementation<br>
 * - SPP TRS Invoice Basic Command Implementation<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public class InvoiceSaveEquipmentBCImpl extends BasicCommandSupport implements InvoiceSaveEquipmentBC {
	private static final long serialVersionUID = 1L;
	
	//Database Access Object
	private transient InvoiceSaveEquipmentDBDAO dbDao=null;

	/**
	 * 생성자<br>
	 * 
	 * @param void
	 * @return void
	 * @exception 
	 */
	public InvoiceSaveEquipmentBCImpl(){
		dbDao = new InvoiceSaveEquipmentDBDAO();
	}

	/**
	 * doEnd<br>
	 * 
	 */
	public void doEnd() {
		dbDao = null;
	}
	
	/**
	 * checkInvoiceNumber<br>
	 * 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return iResult int
	 * @exception EventException
	 */
	public int checkInvoiceNumber(Event e) throws EventException {
		
		//PDTO(Data Transfer Object including Parameters)
		SppTrsI03Event event = (SppTrsI03Event)e;
		int iResult = 0;

		try {
			iResult = dbDao.checkInvoiceNumber(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return iResult;
		
	}
	
}