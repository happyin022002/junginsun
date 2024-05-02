/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ChassisGensetSOManageSC.java
 *@FileTitle : Service Order - Chassis or Genset
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.chassisgensetsomanage;

import com.clt.apps.opus.esd.trs.chassisgensetsomanage.chassisgensetsomanage.basic.ChassisGensetSOManageBC;
import com.clt.apps.opus.esd.trs.chassisgensetsomanage.chassisgensetsomanage.basic.ChassisGensetSOManageBCImpl;
import com.clt.apps.opus.esd.trs.chassisgensetsomanage.chassisgensetsomanage.event.EsdTrs0014Event;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;

/**
 * ESD-TRS Business Logic ServiceCommand<br>
 * 
 * @author
 * @see ESD_TRS_0014EventResponse,ChassisGensetSOManageDBDAO
 * @since J2EE 1.4
 */
public class ChassisGensetSOManageSC extends ServiceCommandSupport {
	/**
	 * Generating the implicit object when ChassisGensetSOManage task is called.<br>
	 */
	public void doStart() {
		log.debug(" ChassisGensetSOManageSC Start");
	}

	/**
	 * End process of TRS task scenario<br>
	 * Releasing the related implicit object when ChassisGensetSOManage task is end.<br>
	 */
	public void doEnd() {
		log.debug(" ChassisGensetSOManageSC End");
	}

	/**
	 * Performing the task scenario corresponding each event.<br>
	 * Branch processing of every event occurring at ESD-TRS task<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;
		if (e.getEventName().equalsIgnoreCase("EsdTrs0014Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchChassisGensetSOManageList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = addTRS_TRSP_SVC_ORD(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = modifyChassisGensetSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchChassisSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGensetSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = verifyChassisGensetSOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = verifyEqNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = verifyEqNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchImportedChassis(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchImportedGenset(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchChassisCorrectionList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = searchGensetCorrectionList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchVendorList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchVendor(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = searchChassisTpSzCdList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = searchGensetTpSzCdList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = searchContainerTpSzCdList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = searchVendorChld(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				eventResponse = searchVendorPrnt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVELIST)) {
				eventResponse = removeChassisGensetList(e);
			}
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of ChassisGensetSOManage page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainerTpSzCdList(Event e) throws EventException {
		EventResponse eventResponse = null;
		try {
			ChassisGensetSOManageBC command = new ChassisGensetSOManageBCImpl();
			eventResponse = command.searchContainerTpSzCdList(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of ChassisGensetSOManage page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChassisTpSzCdList(Event e) throws EventException {
		EventResponse eventResponse = null;
		try {
			ChassisGensetSOManageBC command = new ChassisGensetSOManageBCImpl();
			eventResponse = command.searchChassisTpSzCdList(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of ChassisGensetSOManage page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGensetTpSzCdList(Event e) throws EventException {
		EventResponse eventResponse = null;
		try {
			ChassisGensetSOManageBC command = new ChassisGensetSOManageBCImpl();
			eventResponse = command.searchGensetTpSzCdList(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of ChassisGensetSOManage page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeChassisGensetList(Event e) throws EventException {
		EventResponse eventResponse = null;
		ChassisGensetSOManageBC command = new ChassisGensetSOManageBCImpl();
		try {
			begin();
			eventResponse = command.removeChassisGensetList(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of ChassisGensetSOManage page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVendorList(Event e) throws EventException {
		EventResponse eventResponse = null;
		try {
			ChassisGensetSOManageBC command = new ChassisGensetSOManageBCImpl();
			eventResponse = command.searchVendorList(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of ChassisGensetSOManage page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVendor(Event e) throws EventException {
		EventResponse eventResponse = null;
		try {
			ChassisGensetSOManageBC command = new ChassisGensetSOManageBCImpl();
			eventResponse = command.searchVendor(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of ChassisGensetSOManage page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVendorChld(Event e) throws EventException {
		EventResponse eventResponse = null;
		try {
			ChassisGensetSOManageBC command = new ChassisGensetSOManageBCImpl();
			eventResponse = command.searchVendorChld(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of ChassisGensetSOManage page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVendorPrnt(Event e) throws EventException {
		EventResponse eventResponse = null;
		try {
			ChassisGensetSOManageBC command = new ChassisGensetSOManageBCImpl();
			eventResponse = command.searchVendorPrnt(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of ChassisGensetSOManage page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChassisCorrectionList(Event e) throws EventException {
		EventResponse eventResponse = null;
		try {
			ChassisGensetSOManageBC command = new ChassisGensetSOManageBCImpl();
			eventResponse = command.searchChassisCorrectionList(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of ChassisGensetSOManage page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGensetCorrectionList(Event e) throws EventException {
		EventResponse eventResponse = null;
		try {
			ChassisGensetSOManageBC command = new ChassisGensetSOManageBCImpl();
			eventResponse = command.searchGensetCorrectionList(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of ChassisGensetSOManage page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchImportedChassis(Event e) throws EventException {
		EventResponse eventResponse = null;
		try {
			ChassisGensetSOManageBC command = new ChassisGensetSOManageBCImpl();
			eventResponse = command.searchImportedChassis(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of ChassisGensetSOManage page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchImportedGenset(Event e) throws EventException {
		EventResponse eventResponse = null;
		try {
			ChassisGensetSOManageBC command = new ChassisGensetSOManageBCImpl();
			eventResponse = command.searchImportedGenset(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of ChassisGensetSOManage page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyEqNo(Event e) throws EventException {

		EventResponse eventResponse = null;
		try {
			ChassisGensetSOManageBC command = new ChassisGensetSOManageBCImpl();
			eventResponse = command.verifyEqNo(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of ChassisGensetSOManage page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse addTRS_TRSP_SVC_ORD(Event e) throws EventException {
		EventResponse eventResponse = null;
		ChassisGensetSOManageBC command = new ChassisGensetSOManageBCImpl();
		try {
			begin();
			eventResponse = command.searchTrspSvcOrdList(command.addTRS_TRSP_SVC_ORD(e));
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of ChassisGensetSOManage page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyChassisGensetSOManage(Event e) throws EventException {
		EventResponse eventResponse = null;
		try {
			ChassisGensetSOManageBC command = new ChassisGensetSOManageBCImpl();
			eventResponse = command.verifyChassisGensetSOManage(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of ChassisGensetSOManage page<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChassisGensetSOManageList(Event e) throws EventException {
		EventResponse eventResponse = null;
		try {
			ChassisGensetSOManageBC command = new ChassisGensetSOManageBCImpl();
			eventResponse = command.searchChassisGensetSOManageList(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of ChassisGensetSOManage page<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChassisSOManage(Event e) throws EventException {
		EsdTrs0014Event event = (EsdTrs0014Event) e;
		EventResponse eventResponse = null;
		try {
			ChassisGensetSOManageBC command = new ChassisGensetSOManageBCImpl();
			eventResponse = command.searchChassisSOManage(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of ChassisGensetSOManage page<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGensetSOManage(Event e) throws EventException {
		EsdTrs0014Event event = (EsdTrs0014Event) e;
		EventResponse eventResponse = null;
		try {
			ChassisGensetSOManageBC command = new ChassisGensetSOManageBCImpl();
			eventResponse = command.searchGensetSOManage(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Modification event process of ChassisGensetSOManage page<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyChassisGensetSOManage(Event e) throws EventException {
		EsdTrs0014Event event = (EsdTrs0014Event) e;
		EventResponse eventResponse = null;
		ChassisGensetSOManageBC command = new ChassisGensetSOManageBCImpl();
		try {
			begin();
			eventResponse = command.modifyChassisGensetSOManage(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

}