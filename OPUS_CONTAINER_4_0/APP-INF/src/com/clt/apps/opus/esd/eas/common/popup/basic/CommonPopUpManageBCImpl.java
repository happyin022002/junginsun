/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CommonPopUpManageBCImpl.java
*@FileTitle : CY & Door S/O Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.esd.eas.common.popup.basic;

import com.clt.apps.opus.esd.eas.common.popup.event.EsdEasCom0001Event;
import com.clt.apps.opus.esd.eas.common.popup.event.EsdEasCom0001EventResponse;
import com.clt.apps.opus.esd.eas.common.popup.integration.CommonPopUpManageDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;


/**
 * ESD-EAS Business Logic Basic Command implementation<br>
 * - handling business transaction abount ESD-EAS .<br>
 */
public class CommonPopUpManageBCImpl extends BasicCommandSupport implements CommonPopUpManageBC
{

	// Database Access Object
	private transient CommonPopUpManageDBDAO dbDao=null;

	/**
	 * CommonPopUpManageBCImpl Create Object<br>
	 * Create CommonPopUpManageDBDAO.<br>
	 */
	public CommonPopUpManageBCImpl(){
		dbDao = new CommonPopUpManageDBDAO();
	}

	/**
	 * Retrive Event<br>
	 *
	 * @param e ESD_EAS_COM_001
	 * @return EventResponse ESD_EAS_COM_001EventResponse
	 * @exception EventException
	 */
	public EventResponse searchServiceOfficeCodeManage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		EsdEasCom0001Event event=(EsdEasCom0001Event)e;

		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.searchServiceOfficeCodeManage(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	
	/**
	 * EAS biz scenario closing<br>
	 * clearing related objects of Common Office <br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}