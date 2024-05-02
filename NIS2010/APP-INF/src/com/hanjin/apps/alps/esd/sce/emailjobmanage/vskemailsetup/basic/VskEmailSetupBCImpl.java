/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VskEmailSetupBCImpl.java
*@FileTitle : VSL SKD e-mailing Set-up
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.06
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2010.08.06 박준용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.emailjobmanage.vskemailsetup.basic;

import com.hanjin.apps.alps.esd.sce.emailjobmanage.vskemailsetup.event.EsdSce0119Event;
import com.hanjin.apps.alps.esd.sce.emailjobmanage.vskemailsetup.integration.VskEmailSetupDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-EmailJobManage Business Logic Command Interface<br>
 * - ALPS-EmailJobManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Park Jun Yong
 * @see BasicCommandSupport , VskEmailSetupBC
 * @since J2EE 1.6
 */
public class VskEmailSetupBCImpl extends BasicCommandSupport implements VskEmailSetupBC {

	// Database Access Object
	private transient VskEmailSetupDBDAO dbDao = null;

	/**
	 * VskEmailSetupBCImpl 객체 생성<br>
	 * VskEmailSetupDBDAO를 생성한다.<br>
	 */
	public VskEmailSetupBCImpl() {
		dbDao = new VskEmailSetupDBDAO();
	}
	
	/**
	 * VSL E-MAIL 대상 조회<br>
	 * @return GeneralEventResponse
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.emailjobmanage.vskemailsetup.basic.VskEmailSetupBC#searchVslSkdEmlSetUp()
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
	 * @see com.hanjin.apps.alps.esd.sce.emailjobmanage.vskemailsetup.basic.VskEmailSetupBC#addVslSkdEmlSetUp(com.hanjin.framework.core.layer.event.Event)
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
	 * @see com.hanjin.apps.alps.esd.sce.emailjobmanage.vskemailsetup.basic.VskEmailSetupBC#addVslSkdEmlSetUp(com.hanjin.framework.core.layer.event.Event)
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
	 * @see com.hanjin.apps.alps.esd.sce.emailjobmanage.vskemailsetup.basic.VskEmailSetupBC#searchLaneVerify()
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
	 * @see com.hanjin.apps.alps.esd.sce.emailjobmanage.vskemailsetup.basic.VskEmailSetupBC#searchPortVerify()
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