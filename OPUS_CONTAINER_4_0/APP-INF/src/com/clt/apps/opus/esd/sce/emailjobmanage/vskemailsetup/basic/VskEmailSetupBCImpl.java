/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VskEmailSetupBCImpl.java
*@FileTitle : VSL SKD e-mailing Set-up
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsetup.basic;

import com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsetup.event.EsdSce0119Event;
import com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsetup.integration.VskEmailSetupDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * EmailJobManage Business Logic Command Interface<br>
  *
 * @author 
 * @see BasicCommandSupport , VskEmailSetupBC
 * @since J2EE 1.6
 */
public class VskEmailSetupBCImpl extends BasicCommandSupport implements VskEmailSetupBC {

	// Database Access Object
	private transient VskEmailSetupDBDAO dbDao = null;

	/**
	 * VskEmailSetupBCImpl related objects creation<br>
	 * VskEmailSetupDBDAO objects creation.<br>
	 */
	public VskEmailSetupBCImpl() {
		dbDao = new VskEmailSetupDBDAO();
	}
	
	/**
	 * Destination Lookup VSL E-MAIL<br>
	 * @return GeneralEventResponse
	 * @throws EventException
	 * @see com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsetup.basic.VskEmailSetupBC#searchVslSkdEmlSetUp()
	 */
	public GeneralEventResponse searchVslSkdEmlSetUp() throws EventException {
		try {
			return dbDao.searchVslSkdEmlSetUp();
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	
	/**
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 * @see com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsetup.basic.VskEmailSetupBC#addVslSkdEmlSetUp(com.clt.framework.core.layer.event.Event)
	 */
	public EventResponse addVslSkdEmlSetUp(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdSce0119Event event=(EsdSce0119Event)e;
		try {	
			dbDao.addVslSkdEmlSetUp(event);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 * @see com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsetup.basic.VskEmailSetupBC#addVslSkdEmlSetUp(com.clt.framework.core.layer.event.Event)
	 */
	public EventResponse removeVslSkdEmlSetUp(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters) 
		EsdSce0119Event event=(EsdSce0119Event)e;
		try {	
			dbDao.removeVslSkdEmlSetUp(event);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * @param e
	 * @return GeneralEventResponse
	 * @throws EventException
	 * @see com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsetup.basic.VskEmailSetupBC#searchLaneVerify()
	 */
	public GeneralEventResponse searchLaneVerify(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdSce0119Event event=(EsdSce0119Event)e;
		try {
			return dbDao.searchLaneVerify(event);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * @param e
	 * @return GeneralEventResponse
	 * @throws EventException
	 * @see com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsetup.basic.VskEmailSetupBC#searchPortVerify()
	 */
	public GeneralEventResponse searchPortVerify(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdSce0119Event event=(EsdSce0119Event)e;
		try {
			return dbDao.searchPortVerify(event);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
}