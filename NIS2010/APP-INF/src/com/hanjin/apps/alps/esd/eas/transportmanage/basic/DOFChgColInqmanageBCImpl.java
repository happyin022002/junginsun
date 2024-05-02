/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : DOFChgColInqmanageBC
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

import com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0005Event;
import com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0008Event;
import com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0008EventResponse;
import com.hanjin.apps.alps.esd.eas.transportmanage.integration.DOFChgColInqmanageDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * DOFChgColInqmanageBCImpl PDTO(Data Transfer Object including Parameters)<br>
 * @author ho-sam lee
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public class DOFChgColInqmanageBCImpl extends BasicCommandSupport implements DOFChgColInqmanageBC {

	
	// Database Access Object 
	private transient DOFChgColInqmanageDBDAO dbDao = null;

	/**
	 * OutstandingManageBCImpl 객체 생성<br>
	 * OutstandingManageDBDAO를 생성한다.<br>
	 */
	public DOFChgColInqmanageBCImpl(){
		dbDao = new DOFChgColInqmanageDBDAO();
	}
	
	/**
	 * Drop off charge col inquery Search list
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchDofChgColList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		EsdEas0008Event event  = (EsdEas0008Event)e ;
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null; 
		
		try {
//			SignOnUserAccount sa = event.getSignOnUserAccount();
//			event.getEventParams().put("user_ofc_cd", sa.getOfc_cd()); /// Add in 2007-04-05
//			log.debug("abc"+event);
			rowSet = dbDao.searchDofChgColList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

}
