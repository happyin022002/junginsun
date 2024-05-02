/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MtyRepoSelectPopupBCImpl.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.common.mtyreposelectpopup.basic;


import com.clt.apps.opus.esd.trs.common.mtyreposelectpopup.event.EsdTrs0909Event;
import com.clt.apps.opus.esd.trs.common.mtyreposelectpopup.integration.MtyRepoSelectPopupDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;



/**
 * ENIS-MtyRepoSelectPopup Business Logic Basic Command implementation<br>
 * 
 * @author
 * @see ESD_TRS_909EventResponse,MtyRepoSelectPopupBC
 * @since J2EE 1.4
 */
public class MtyRepoSelectPopupBCImpl   extends BasicCommandSupport implements MtyRepoSelectPopupBC {
	private transient MtyRepoSelectPopupDBDAO dbDao=null;

	/**
	 * MtyRepoSelectPopupBCImpl <br>
	 * MtyRepoSelectPopupDBDAO<br>
	 */
	public MtyRepoSelectPopupBCImpl(){
		dbDao = new MtyRepoSelectPopupDBDAO();
	}

	
	/**
	 * Inquiry event process<br>
	 * MtyRepoSelectPopup - Inquiry event process<br>
	 * 
	 * @param e ESD_TRS_909Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchMtyRepoSelectPopup(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0909Event event=(EsdTrs0909Event)e;
		
		// DB ResultSet for sending data
		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.searchMtyRepoSelectPopup(event);
			//return new EsdTrs909EventResponse(rowSet,"SUCCESS");
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			return eventResponse;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	


	/**
	 * End process of MtyRepoSelectPopup task scenario<br>
	 * Releasing the related implicit object when MtyRepoSelectPopup task is end.<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}