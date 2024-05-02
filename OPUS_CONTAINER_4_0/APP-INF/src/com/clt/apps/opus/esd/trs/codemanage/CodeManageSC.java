/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CodeManageSC.java
 *@FileTitle : TRS CodeManagement
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion :  1.0
 * --------------------------------------------------------
 * History
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage;

import com.clt.apps.opus.esd.trs.codemanage.commoditygroupcodemanage.basic.CommodityGroupCodeManageBC;
import com.clt.apps.opus.esd.trs.codemanage.commoditygroupcodemanage.basic.CommodityGroupCodeManageBCImpl;
import com.clt.apps.opus.esd.trs.codemanage.controlofficeexceptioncasemanage.basic.ControlOfficeExceptionCaseManageBC;
import com.clt.apps.opus.esd.trs.codemanage.controlofficeexceptioncasemanage.basic.ControlOfficeExceptionCaseManageBCImpl;
import com.clt.apps.opus.esd.trs.codemanage.controlofficeexceptioncasemanage.event.EsdTrs0079Event;
import com.clt.apps.opus.esd.trs.codemanage.exceptionackrailroad.basic.ExceptionAckRailRoadBC;
import com.clt.apps.opus.esd.trs.codemanage.exceptionackrailroad.basic.ExceptionAckRailRoadBCImpl;
import com.clt.apps.opus.esd.trs.codemanage.invoiceofficeauthoritymanagement.basic.InvOfcAtrtMgmtBC;
import com.clt.apps.opus.esd.trs.codemanage.invoiceofficeauthoritymanagement.basic.InvOfcAtrtMgmtBCImpl;
import com.clt.apps.opus.esd.trs.codemanage.invoiceofficeauthoritymanagement.event.EsdTrs0976Event;
import com.clt.apps.opus.esd.trs.codemanage.invoiceofficeauthoritymanagement.vo.InvoiceOfficeAuthorityManagementVO;
import com.clt.apps.opus.esd.trs.codemanage.multipleinquiry.basic.MultipleInquiryBC;
import com.clt.apps.opus.esd.trs.codemanage.multipleinquiry.basic.MultipleInquiryBCImpl;
import com.clt.apps.opus.esd.trs.codemanage.usaactualcustomercodemanage.basic.USAActualCustomerCodeManageBC;
import com.clt.apps.opus.esd.trs.codemanage.usaactualcustomercodemanage.basic.USAActualCustomerCodeManageBCImpl;
import com.clt.apps.opus.esd.trs.codemanage.usaactualcustomercodemanage.event.EsdTrs0082Event;
import com.clt.apps.opus.esd.trs.codemanage.usadeliveryordermanage.basic.USADeliveryOrderManageBC;
import com.clt.apps.opus.esd.trs.codemanage.usadeliveryordermanage.basic.USADeliveryOrderManageBCImpl;
import com.clt.apps.opus.esd.trs.codemanage.usadeliveryordermanage.event.EsdTrs0083Event;
import com.clt.apps.opus.esd.trs.codemanage.usalastcitymanage.basic.USALastCityManageBC;
import com.clt.apps.opus.esd.trs.codemanage.usalastcitymanage.basic.USALastCityManageBCImpl;
import com.clt.apps.opus.esd.trs.codemanage.usalastcitymanage.event.EsdTrs0076Event;
import com.clt.apps.opus.esd.trs.codemanage.usarailyardmanage.basic.UsaRailYardManageBC;
import com.clt.apps.opus.esd.trs.codemanage.usarailyardmanage.basic.UsaRailYardManageBCImpl;
import com.clt.apps.opus.esd.trs.codemanage.usarailyardmanage.event.EsdTrs0084Event;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;

/**
 * ESD-TRS Business Logic ServiceCommand<br>
 * - ESD-TRS handling business transaction.<br>
 * 
 * @author
 * @see refer to ESD_TRS_076EventResponse,UsaLastCityManagementDBDAO
 * @since
 */

public class CodeManageSC extends ServiceCommandSupport {

	/**
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;
		if (e.getEventName().equalsIgnoreCase("EsdTrs0076Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUSALastCityManageList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiUSALastCityManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchLocalCodeManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchUSALastCityComboList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0079Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchControlOfficeExceptionCaseManageList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiControlOfficeExceptionCaseManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchYardCodeManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCountryCodeManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchControlOfficeCodeManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchEquipmentSZ(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchEquipmentTP(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = verifyControlOfficeCD(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchYardCodeName(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0906Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMultipleInquiryList();
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0075Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCommodityGroupCodeManageList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMdm_commodity(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchrep_commodity(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = search_commodity(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = search_vndr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = search_vndr_commodity(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = search_sub_commodity(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multi_vndr_commodity(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multi_delete_commodity(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = multi_part_commodity(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0082Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUSAActualCustomerCodeManageList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchUSAActualCustomerCodeManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchUSAActualCustomerName(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchUSAActualCustomerCodeExcel(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchUSAActualCustomerNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchUSAActualCustomerCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiUSAActualCustomerCodeManageList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0083Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUSDeliveryOrderConsigneeManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchUSADeliveryOrderManageList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchUSADeliveryOrderCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiUSADeliveryOrderManage(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0976Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {
				eventResponse = searchInvOfcAtrtMgmtList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) {
				eventResponse = searchOfficeCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiInvoiceOfficeAuthorityManagement(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeInvoiceOffice(e);
			} else {
				return eventResponse;
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0084Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUsaRailYardManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiUsaRailYardManage(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0077Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchExceptionAckRailRoadVendorList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiExceptionAckRailRoadVendor(e);
			}
		}
		return eventResponse;
	}

	/**
	 * Multi event process<br>
	 * InvoiceOfficeAuthorityManagement save event process<br<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiInvoiceOfficeAuthorityManagement(Event e) throws EventException {
		EsdTrs0976Event event = (EsdTrs0976Event) e;
		EventResponse eventResponse = null;
		try {
			begin();
			InvOfcAtrtMgmtBC command = new InvOfcAtrtMgmtBCImpl();
			eventResponse = command.multiInvoiceOfficeAuthorityManagement(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event process <br>
	 * Invoice office Authority Management retrieve event process<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	// invoice office management List retrieve event process search20
	private EventResponse searchInvOfcAtrtMgmtList(Event e) throws EventException {
		EsdTrs0976Event event = (EsdTrs0976Event) e;

		EventResponse eventResponse = null;
		try {
			InvOfcAtrtMgmtBC command = new InvOfcAtrtMgmtBCImpl();
			eventResponse = command.searchInvOfcAtrtMgmtList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event process <br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */

	private EventResponse searchOfficeCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0976Event event = (EsdTrs0976Event) e;

		InvoiceOfficeAuthorityManagementVO vo = null;
		try {
			InvOfcAtrtMgmtBC command = new InvOfcAtrtMgmtBCImpl();
			vo = command.searchOfficeCode(event);
			String ofcEngName = vo.getOfcEngNm();
			eventResponse.setETCData("ofcEngName", ofcEngName);
			eventResponse.setRsVo(vo);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * delete event process<br>
	 * Invoice office Authority Management delete event process<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeInvoiceOffice(Event e) throws EventException {
		EsdTrs0976Event event = (EsdTrs0976Event) e;
		EventResponse eventResponse = null;
		try {
			begin();
			InvOfcAtrtMgmtBC command = new InvOfcAtrtMgmtBCImpl();
			eventResponse = command.removeInvoiceOffice(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event process<br>
	 * UsaLastCityManagement retrieve event process<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUSALastCityManageList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0076Event event = (EsdTrs0076Event) e;
		EventResponse eventResponse = null;

		try {
			USALastCityManageBC command = new USALastCityManageBCImpl();
			eventResponse = command.searchUSALastCityManageList(event);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * multi event process <br>
	 * UsaLastCityManagement event process<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiUSALastCityManage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();
			USALastCityManageBC command = new USALastCityManageBCImpl();
			command.multiUSALastCityManage(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * SEARCH01 event process<br>
	 * CodeManage event process<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchLocalCodeManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		// ESD_TRS_076Event event = (ESD_TRS_076Event)e;
		EventResponse eventResponse = null;

		try {
			USALastCityManageBC command = new USALastCityManageBCImpl();
			eventResponse = command.searchLocalCodeManage(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event process<br>
	 * UsaLastCityManagement retrieve event process for Combo<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUSALastCityComboList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0076Event event = (EsdTrs0076Event) e;
		EventResponse eventResponse = null;

		try {
			USALastCityManageBC command = new USALastCityManageBCImpl();
			eventResponse = command.searchUSALastCityComboList(event);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event process<br>
	 * ControlOfficeExceptionCaseManage retrieve event process<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchControlOfficeExceptionCaseManageList(Event e) throws EventException {
		EsdTrs0079Event event = (EsdTrs0079Event) e;
		EventResponse eventResponse = null;

		try {
			ControlOfficeExceptionCaseManageBC command = new ControlOfficeExceptionCaseManageBCImpl();
			eventResponse = command.searchControlOfficeExceptionCaseManageList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * multi event process<br>
	 * ControlOfficeExceptionCaseManage event process<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiControlOfficeExceptionCaseManage(Event e) throws EventException {
		try {
			begin();
			ControlOfficeExceptionCaseManageBC command = new ControlOfficeExceptionCaseManageBCImpl();
			command.multiControlOfficeExceptionCaseManage(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return this.searchControlOfficeExceptionCaseManageList(e);
	}

	/**
	 * SEARCH01 event process<<br>
	 * CodeManage event process<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchYardCodeManage(Event e) throws EventException {
		EventResponse eventResponse = null;
		try {
			ControlOfficeExceptionCaseManageBC command = new ControlOfficeExceptionCaseManageBCImpl();
			eventResponse = command.searchYardCodeManage(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * SEARCH01 event process<<br>
	 * CodeManage event process<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchYardCodeName(Event e) throws EventException {
		EventResponse eventResponse = null;
		try {
			ControlOfficeExceptionCaseManageBC command = new ControlOfficeExceptionCaseManageBCImpl();
			eventResponse = command.searchYardCodeName(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * SEARCH01 event process<br>
	 * CodeManage event process<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCountryCodeManage(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			ControlOfficeExceptionCaseManageBC command = new ControlOfficeExceptionCaseManageBCImpl();
			eventResponse = command.searchCountryCodeManage(e);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * SEARCH02 event process<br>
	 * CodeManage event process<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchEquipmentSZ(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			ControlOfficeExceptionCaseManageBC command = new ControlOfficeExceptionCaseManageBCImpl();
			eventResponse = command.searchEquipmentSZ(e);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * SEARCH02 event process<br>
	 * CodeManage multi event process<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchEquipmentTP(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			ControlOfficeExceptionCaseManageBC command = new ControlOfficeExceptionCaseManageBCImpl();
			eventResponse = command.searchEquipmentTP(e);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * SEARCH02 event process<br>
	 * CodeManage multi event process<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse verifyControlOfficeCD(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			ControlOfficeExceptionCaseManageBC command = new ControlOfficeExceptionCaseManageBCImpl();
			eventResponse = command.verifyControlOfficeCD(e);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * SEARCH02event process<br>
	 * CodeManage multi event process<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchControlOfficeCodeManage(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			begin();
			ControlOfficeExceptionCaseManageBC command = new ControlOfficeExceptionCaseManageBCImpl();
			eventResponse = command.searchControlOfficeCodeManage(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event process<br>
	 * MultipleInquiry retrieve event process<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMultipleInquiryList() throws EventException {
		EventResponse eventResponse = null;

		try {
			MultipleInquiryBC command = new MultipleInquiryBCImpl();
			eventResponse = command.searchMultipleInquiryList();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event process<br>
	 * CommodityGroupCodeManage retrieve event process<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCommodityGroupCodeManageList(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			begin();
			CommodityGroupCodeManageBC command = new CommodityGroupCodeManageBCImpl();
			eventResponse = command.searchCommodityGroupCodeManageList(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * retrieve event process<br>
	 * CommodityGroupCodeManage retrieve event process<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMdm_commodity(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			begin();
			CommodityGroupCodeManageBC command = new CommodityGroupCodeManageBCImpl();
			eventResponse = command.searchMdm_commodity(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event process<br>
	 * CommodityGroupCodeManage retrieve event process<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchrep_commodity(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			begin();
			CommodityGroupCodeManageBC command = new CommodityGroupCodeManageBCImpl();
			eventResponse = command.searchrep_commodity(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * retrieve event process<br>
	 * CommodityGroupCodeManage retrieve event process<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse search_commodity(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			begin();
			CommodityGroupCodeManageBC command = new CommodityGroupCodeManageBCImpl();
			eventResponse = command.search_commodity(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event process<br>
	 * CommodityGroupCodeManage retrieve event process<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse search_vndr(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			begin();
			CommodityGroupCodeManageBC command = new CommodityGroupCodeManageBCImpl();
			eventResponse = command.search_vndr(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event process<br>
	 * CommodityGroupCodeManage retrieve event process<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse search_vndr_commodity(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			begin();
			CommodityGroupCodeManageBC command = new CommodityGroupCodeManageBCImpl();
			eventResponse = command.search_vndr_commodity(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event process<br>
	 * CommodityGroupCodeManage retrieve event process<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse search_sub_commodity(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			begin();
			CommodityGroupCodeManageBC command = new CommodityGroupCodeManageBCImpl();
			eventResponse = command.search_sub_commodity(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * multi event process<br>
	 * CommodityGroupCodeManage multi event process<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multi_vndr_commodity(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			CommodityGroupCodeManageBC command = new CommodityGroupCodeManageBCImpl();
			command.multi_vndr_commodity(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * multi event process<br>
	 * CommodityGroupCodeManage multi event process<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multi_delete_commodity(Event e) throws EventException {
		try {
			begin();
			CommodityGroupCodeManageBC command = new CommodityGroupCodeManageBCImpl();
			command.multi_delete_commodity(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return this.searchCommodityGroupCodeManageList(e);
	}

	/**
	 * multi event process<br>
	 * CommodityGroupCodeManage multi event process<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multi_part_commodity(Event e) throws EventException {
		try {
			begin();
			CommodityGroupCodeManageBC command = new CommodityGroupCodeManageBCImpl();
			command.multi_part_commodity(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return this.searchCommodityGroupCodeManageList(e);
	}

	/**
	 * USA RAIL YARD retrieve event process<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUsaRailYardManage(Event e) throws EventException {
		EsdTrs0084Event event = (EsdTrs0084Event) e;
		EventResponse eventResponse = null;

		try {
			UsaRailYardManageBC command = new UsaRailYardManageBCImpl();
			eventResponse = command.searchUsaRailYardManage(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * USA RAIL YARD save event process<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiUsaRailYardManage(Event e) throws EventException {
		EsdTrs0084Event event = (EsdTrs0084Event) e;

		try {
			begin();
			UsaRailYardManageBC command = new UsaRailYardManageBCImpl();
			command.multiUsaRailYardManage(event);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return this.searchUsaRailYardManage(e);
	}

	/**
	 * US D/O INPUT Consignee 조회 이벤트 처리<br>
	 * D/O INPUT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUSDeliveryOrderConsigneeManage(Event e) throws EventException {
		EsdTrs0083Event event = (EsdTrs0083Event) e;
		EventResponse eventResponse = null;

		try {
			USADeliveryOrderManageBC command = new USADeliveryOrderManageBCImpl();
			eventResponse = command.searchUSDeliveryOrderConsigneeManage(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * US D/O INPUT Consignee 조회 이벤트 처리<br>
	 * D/O INPUT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUSADeliveryOrderManageList(Event e) throws EventException {
		EsdTrs0083Event event = (EsdTrs0083Event) e;
		EventResponse eventResponse = null;
		try {
			USADeliveryOrderManageBC command = new USADeliveryOrderManageBCImpl();
			eventResponse = command.searchUSADeliveryOrderManageList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * US D/O INPUT Consignee 저장가능여부 체크 이벤트 처리<br>
	 * D/O INPUT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUSADeliveryOrderCheck(Event e) throws EventException {
		EsdTrs0083Event event = (EsdTrs0083Event) e;
		EventResponse eventResponse = null;

		try {
			USADeliveryOrderManageBC command = new USADeliveryOrderManageBCImpl();
			eventResponse = command.searchUSADeliveryOrderCheck(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * D/O INPUT의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiUSADeliveryOrderManage(Event e) throws EventException {
		try {
			begin();
			USADeliveryOrderManageBC command = new USADeliveryOrderManageBCImpl();
			command.multiUSADeliveryOrderManage(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return this.searchUSADeliveryOrderManageList(e);
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Actual Customer의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUSAActualCustomerCodeManageList(Event e) throws EventException {
		EsdTrs0082Event event = (EsdTrs0082Event) e;
		EventResponse eventResponse = null;

		try {
			USAActualCustomerCodeManageBC command = new USAActualCustomerCodeManageBCImpl();
			eventResponse = command.searchUSAActualCustomerCodeManageList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * DistanceCreation의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUSAActualCustomerCodeManage(Event e) throws EventException {
		EsdTrs0082Event event = (EsdTrs0082Event) e;
		EventResponse eventResponse = null;

		try {
			USAActualCustomerCodeManageBC command = new USAActualCustomerCodeManageBCImpl();
			eventResponse = command.searchUSAActualCustomerCodeManage(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * USAActualCustomerCodeManage의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiUSAActualCustomerCodeManageList(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			begin();
			USAActualCustomerCodeManageBC command = new USAActualCustomerCodeManageBCImpl();
			eventResponse = command.multiUSAActualCustomerCodeManageList(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * searchUSAActualCustomerName의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchUSAActualCustomerName(Event e) throws EventException {

		EventResponse eventResponse = null;
		EsdTrs0082Event event = (EsdTrs0082Event) e;

		try {
			USAActualCustomerCodeManageBC command = new USAActualCustomerCodeManageBCImpl();
			eventResponse = command.searchUSAActualCustomerName(event);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * searchUSAActualCustomerNo의 event에 대한 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchUSAActualCustomerNo(Event e) throws EventException {

		EventResponse eventResponse = null;
		EsdTrs0082Event event = (EsdTrs0082Event) e;

		try {
			USAActualCustomerCodeManageBC command = new USAActualCustomerCodeManageBCImpl();
			eventResponse = command.searchUSAActualCustomerNo(event);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * searchUSAActualCustomerCheck의 event에 대한 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchUSAActualCustomerCheck(Event e) throws EventException {

		EventResponse eventResponse = null;
		EsdTrs0082Event event = (EsdTrs0082Event) e;

		try {
			USAActualCustomerCodeManageBC command = new USAActualCustomerCodeManageBCImpl();
			eventResponse = command.searchUSAActualCustomerCheck(event);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * DowntoExcel 이벤트 처리<br>
	 * searchUSAActualCustomerCodeExcel의 event에 대한 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchUSAActualCustomerCodeExcel(Event e) throws EventException {

		EventResponse eventResponse = null;
		EsdTrs0082Event event = (EsdTrs0082Event) e;

		try {
			USAActualCustomerCodeManageBC command = new USAActualCustomerCodeManageBCImpl();
			eventResponse = command.searchUSAActualCustomerCodeExcel(event);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Exception Rail Road Vendor - RETRIEVE
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchExceptionAckRailRoadVendorList(Event e) throws EventException {
		EventResponse eventResponse = null;
		ExceptionAckRailRoadBC command = new ExceptionAckRailRoadBCImpl();
		try {
			eventResponse = command.searchExceptionAckRailRoadVendorList(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Exception Rail Road Vendor - SAVE
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse multiExceptionAckRailRoadVendor(Event e) throws EventException {
		EventResponse eventResponse = new GeneralEventResponse();
		ExceptionAckRailRoadBC command = new ExceptionAckRailRoadBCImpl();
		try {
			command.multiExceptionAckRailRoadVendor(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
}