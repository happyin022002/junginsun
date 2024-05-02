/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : DOFChgColPermanageBC
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2008-01-30
*@LastModifier : ho-sam lee
*@LastVersion : 1.0
* 2008-01-30 ho-sam lee
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.basic;

import com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0009Event;
import com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0009EventResponse;
import com.hanjin.apps.alps.esd.eas.transportmanage.integration.DOFChgColPermanageDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * DOFChgColPermanageBCImpl PDTO(Data Transfer Object including Parameters)<br>
 * @author ho-sam lee
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public class DOFChgColPermanageBCImpl extends BasicCommandSupport implements DOFChgColPermanageBC {

	
	// Database Access Object 
	private transient DOFChgColPermanageDBDAO dbDao = null;

	/**
	 * OutstandingManageBCImpl 객체 생성<br>
	 * OutstandingManageDBDAO를 생성한다.<br>
	 */
	public DOFChgColPermanageBCImpl(){
		dbDao = new DOFChgColPermanageDBDAO();
	}

	/**
	 * Drop off charge collection Performance Search list
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchDofChgColPerList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		EsdEas0009Event event=(EsdEas0009Event)e; 
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		try {
//			SignOnUserAccount sa = event.getSignOnUserAccount();
//			event.getEventParams().put("user_ofc_cd", sa.getOfc_cd()); /// Add in 2007-04-05
//			log.debug("abc"+event);
			rowSet = dbDao.searchDofChgColPerList(event); 
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

}
