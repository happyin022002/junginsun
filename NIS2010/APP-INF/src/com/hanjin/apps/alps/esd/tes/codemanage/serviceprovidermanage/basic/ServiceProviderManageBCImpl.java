/*=========================================================
*Copyright(c) 2017 HiplusCard
*@FileName : ServiceProviderManageBCImpl.java
*@FileTitle : Service Provider Master
*Open Issues :
*Change history :
*@LastModifyDate : 2017-06-29
*@LastModifier : 
*@LastVersion : 1.0
* 2017-06-29 
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.codemanage.serviceprovidermanage.basic;

import com.hanjin.apps.alps.esd.tes.codemanage.serviceprovidermanage.event.EsdTes0032Event;
import com.hanjin.apps.alps.esd.tes.codemanage.serviceprovidermanage.integration.ServiceProviderManageDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-ServiceProviderAgreementManage Business Logic Basic Command implementation<br>
 * - ALPS-ServiceProviderAgreementManage 대한 비지니스 로직을 처리한다.<br>
 *
 * @author yOng hO lEE
 * @see ESD_TES_0039EventResponse,TerminalAgreementManageBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ServiceProviderManageBCImpl extends BasicCommandSupport implements ServiceProviderManageBC {
	
	private transient ServiceProviderManageDBDAO dbDao = null;
	
	public ServiceProviderManageBCImpl() {
		dbDao = new ServiceProviderManageDBDAO();
	}
	
	/**
	 * MDM VENDOR INFO
	 *  
	 * @param e
	 * @return eventResponse
	 * @throws EventException
	 */
	public EventResponse searchMdmVendorInfo(Event e) throws EventException {
		
		EsdTes0032Event			event			= (EsdTes0032Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		DBRowSet rowSet = null;
		
		try {					
			rowSet = dbDao.searchMdmVendorInfo(event.getMdmVendorInfoVO());			
			eventResponse.setRs(rowSet);	
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
	}
	
	/**
	 * MDM VENDOR INDIA INFO
	 * 
	 * @param e
	 * @return eventResponse
	 * @throws EventException
	 */
	public EventResponse searchMdmVendorIndiaInfo(Event e) throws EventException {	
    	EsdTes0032Event			event			= (EsdTes0032Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		DBRowSet rowSet = null;
		
		try {					
			rowSet = dbDao.searchMdmVendorIndiaInfo(event.getMdmVendorInfoVO().getIdaVndrSeq());			
			eventResponse.setRs(rowSet);	
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
    }
	
	
	
	/**
	 * Modify MDM VENDOR INDIA INFO
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse modifyMdmVendorIndiaInfo(Event e) throws EventException {	
    	EsdTes0032Event			event			= (EsdTes0032Event)e;
    	try {			
			event.getMdmVendorInfoVO().setUpdUsrId(event.getSignOnUserAccount().getUsr_id());		
			dbDao.modifyMdmVendorIndiaInfo(event.getMdmVendorInfoVO());
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
}