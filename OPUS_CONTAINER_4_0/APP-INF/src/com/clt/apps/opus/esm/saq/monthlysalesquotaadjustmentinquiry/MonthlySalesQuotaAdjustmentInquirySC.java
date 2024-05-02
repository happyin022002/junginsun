/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName       : MonthlySalesQuotaAdjustmentInquirySC.java
 *@FileTitle      : Trade Group
 *Open Issues     :
 *Change history  :
 *@LastModifyDate : 
 *@LastModifier   : 
 *@LastVersion    : 
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotaadjustmentinquiry;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotaadjustmentinquiry.monthlyquotaadjustmentinquiry.basic.MonthlyQuotaAdjustmentInquiryBC;
import com.clt.apps.opus.esm.saq.monthlysalesquotaadjustmentinquiry.monthlyquotaadjustmentinquiry.basic.MonthlyQuotaAdjustmentInquiryBCImpl;
import com.clt.apps.opus.esm.saq.monthlysalesquotaadjustmentinquiry.monthlyquotaadjustmentinquiry.event.EsmSaq0049Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotaadjustmentinquiry.monthlyquotaadjustmentinquiry.event.EsmSaq0088Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotaadjustmentinquiry.monthlyquotaadjustmentinquiry.event.EsmSaq0089Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotaadjustmentinquiry.monthlyquotaadjustmentinquiry.integration.MonthlyQuotaAdjustmentInquiryDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;

/**
 * MonthlySalesQuotaAdjustmentInquiry Business Logic ServiceCommand
 * 
 * @author
 * @see MonthlyQuotaAdjustmentInquiryDBDAO
 * @since J2EE 1.6
 */

public class MonthlySalesQuotaAdjustmentInquirySC extends ServiceCommandSupport {
	/**
	 * MonthlySalesQuotaAdjustmentInquiry system preceding process for biz scenario<br>
	 * related objects creation<br>
	 */
	public void doStart() {
		log.debug("MonthlySalesQuotaAdjustmentInquirySC start");
		try {
			getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * MonthlySalesQuotaAdjustmentInquiry - biz scenario closing<br>
	 * clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("MonthlySalesQuotaAdjustmentInquirySC end");
	}

	/**
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		if (e.getEventName().equalsIgnoreCase("EsmSaq0049Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchMonthlyQuotaInquiry0049Tab01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchMonthlyQuotaInquiry0049Tab02(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchMonthlyQuotaInquiry0049Tab03(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST13)) {
				eventResponse = searchMonthlyQuotaInquiry0049Tab03Sub(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {
				eventResponse = searchMonthlyQuotaInquiry0049Tab04(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) {
				eventResponse = searchMonthlyQuotaInquiry0049Tab05(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSaq0088Event")) { // Regional Group
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { // Target Group/Trade/Sub Trade
				eventResponse = searchMonthlyQuotaInquiry0088Tab01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { // Lane
				eventResponse = searchMonthlyQuotaInquiry0088Tab02(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) { // RHQ/Area Director/Lane
				eventResponse = searchMonthlyQuotaInquiry0088Tab03(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST13)) { //
				eventResponse = searchMonthlyQuotaInquiry0088Tab03Child(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) { // Lane/Area Director/C.Office - Quota Total
				eventResponse = searchMonthlyQuotaInquiry0088Tab04(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) { // Lane/Area Direcotr/C. Office - Weekly
				eventResponse = searchMonthlyQuotaInquiry0088Tab05(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSaq0089Event")) { // Regional Office
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { // Target Group/Trade/Sub Trade
				eventResponse = searchMonthlyQuotaInquiry0089Tab01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { // Lane
				eventResponse = searchMonthlyQuotaInquiry0089Tab02(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) { // Lane/L. Office - Weekly
				eventResponse = searchMonthlyQuotaInquiry0089Tab04(e);
			}
		}

		return eventResponse;
	}

	/**
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaInquiry0049Tab01(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0049Event event = (EsmSaq0049Event) e;
		MonthlyQuotaAdjustmentInquiryBC command = new MonthlyQuotaAdjustmentInquiryBCImpl();

		try {

			QuotaConditionVO condition = event.getQuotaConditionVO();
			condition.setFormCommand(e.getFormCommand());

			ReturnVO returnVO = command.searchMonthlyQuotaInquiry0049Tab01(event.getQuotaConditionVO());

			eventResponse.setRsVo(returnVO);

		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaInquiry0049Tab02(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0049Event event = (EsmSaq0049Event) e;
		MonthlyQuotaAdjustmentInquiryBC command = new MonthlyQuotaAdjustmentInquiryBCImpl();

		try {

			QuotaConditionVO condition = event.getQuotaConditionVO();
			condition.setFormCommand(e.getFormCommand());

			ReturnVO returnVO = command.searchMonthlyQuotaInquiry0049Tab02(event.getQuotaConditionVO());

			eventResponse.setRsVo(returnVO);

		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaInquiry0049Tab03(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0049Event event = (EsmSaq0049Event) e;
		MonthlyQuotaAdjustmentInquiryBC command = new MonthlyQuotaAdjustmentInquiryBCImpl();

		try {

			QuotaConditionVO condition = event.getQuotaConditionVO();
			condition.setFormCommand(e.getFormCommand());

			ReturnVO returnVO = command.searchMonthlyQuotaInquiry0049Tab03(event.getQuotaConditionVO());

			eventResponse.setRsVo(returnVO);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaInquiry0049Tab03Sub(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0049Event event = (EsmSaq0049Event) e;
		MonthlyQuotaAdjustmentInquiryBC command = new MonthlyQuotaAdjustmentInquiryBCImpl();

		try {

			QuotaConditionVO condition = event.getQuotaConditionVO();
			condition.setFormCommand(e.getFormCommand());

			ReturnVO returnVO = command.searchMonthlyQuotaInquiry0049Tab03Sub(event.getQuotaConditionVO());

			eventResponse.setRsVo(returnVO);

		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaInquiry0049Tab04(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0049Event event = (EsmSaq0049Event) e;
		MonthlyQuotaAdjustmentInquiryBC command = new MonthlyQuotaAdjustmentInquiryBCImpl();

		try {

			QuotaConditionVO condition = event.getQuotaConditionVO();
			condition.setFormCommand(e.getFormCommand());

			ReturnVO returnVO = command.searchMonthlyQuotaInquiry0049Tab04(event.getQuotaConditionVO());

			eventResponse.setRsVo(returnVO);

		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaInquiry0049Tab05(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0049Event event = (EsmSaq0049Event) e;
		MonthlyQuotaAdjustmentInquiryBC command = new MonthlyQuotaAdjustmentInquiryBCImpl();

		try {

			QuotaConditionVO condition = event.getQuotaConditionVO();
			condition.setFormCommand(e.getFormCommand());

			ReturnVO returnVO = command.searchMonthlyQuotaInquiry0049Tab05(event.getQuotaConditionVO());

			eventResponse.setRsVo(returnVO);

		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaInquiry0088Tab01(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0088Event event = (EsmSaq0088Event) e;
		MonthlyQuotaAdjustmentInquiryBC command = new MonthlyQuotaAdjustmentInquiryBCImpl();

		try {
			// log.debug("===== SEARCHLIST01 ====");
			event.getQuotaConditionVO().setChkCommand("SEARCHLIST01");
			ReturnVO list = command.searchMonthlyQuotaInquiry0088Tab01(event.getQuotaConditionVO());
			list.setConditionVO(event.getQuotaConditionVO());
			eventResponse.setRsVo(list);

		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaInquiry0088Tab02(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0088Event event = (EsmSaq0088Event) e;
		MonthlyQuotaAdjustmentInquiryBC command = new MonthlyQuotaAdjustmentInquiryBCImpl();

		try {

			event.getQuotaConditionVO().setChkCommand("SEARCHLIST02");
			ReturnVO list = command.searchMonthlyQuotaInquiry0088Tab02(event.getQuotaConditionVO());
			list.setConditionVO(event.getQuotaConditionVO());
			eventResponse.setRsVo(list);

		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaInquiry0088Tab03(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0088Event event = (EsmSaq0088Event) e;
		MonthlyQuotaAdjustmentInquiryBC command = new MonthlyQuotaAdjustmentInquiryBCImpl();

		try {

			event.getQuotaConditionVO().setChkCommand("SEARCHLIST03");
			ReturnVO list = command.searchMonthlyQuotaInquiry0088Tab03(event.getQuotaConditionVO());
			list.setConditionVO(event.getQuotaConditionVO());
			eventResponse.setRsVo(list);

		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaInquiry0088Tab03Child(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0088Event event = (EsmSaq0088Event) e;
		MonthlyQuotaAdjustmentInquiryBC command = new MonthlyQuotaAdjustmentInquiryBCImpl();

		try {

			event.getQuotaConditionVO().setChkCommand("SEARCHLIST13");
			ReturnVO list = command.searchMonthlyQuotaInquiry0088Tab03Child(event.getQuotaConditionVO());
			list.setConditionVO(event.getQuotaConditionVO());
			eventResponse.setRsVo(list);

		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaInquiry0088Tab04(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0088Event event = (EsmSaq0088Event) e;
		MonthlyQuotaAdjustmentInquiryBC command = new MonthlyQuotaAdjustmentInquiryBCImpl();

		try {

			event.getQuotaConditionVO().setChkCommand("SEARCHLIST04");
			ReturnVO list = command.searchMonthlyQuotaInquiry0088Tab04(event.getQuotaConditionVO());
			list.setConditionVO(event.getQuotaConditionVO());
			eventResponse.setRsVo(list);

		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaInquiry0088Tab05(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0088Event event = (EsmSaq0088Event) e;
		MonthlyQuotaAdjustmentInquiryBC command = new MonthlyQuotaAdjustmentInquiryBCImpl();

		try {

			event.getQuotaConditionVO().setChkCommand("SEARCHLIST05");
			ReturnVO list = command.searchMonthlyQuotaInquiry0088Tab05(event.getQuotaConditionVO());
			list.setConditionVO(event.getQuotaConditionVO());
			eventResponse.setRsVo(list);

		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaInquiry0089Tab01(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0089Event event = (EsmSaq0089Event) e;
		MonthlyQuotaAdjustmentInquiryBC command = new MonthlyQuotaAdjustmentInquiryBCImpl();

		try {

			event.getQuotaConditionVO().setChkCommand("SEARCHLIST01");
			ReturnVO list = command.searchMonthlyQuotaInquiry0089Tab01(event.getQuotaConditionVO());
			list.setConditionVO(event.getQuotaConditionVO());
			eventResponse.setRsVo(list);

		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaInquiry0089Tab02(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0089Event event = (EsmSaq0089Event) e;
		MonthlyQuotaAdjustmentInquiryBC command = new MonthlyQuotaAdjustmentInquiryBCImpl();

		try {

			event.getQuotaConditionVO().setChkCommand("SEARCHLIST02");
			ReturnVO list = command.searchMonthlyQuotaInquiry0089Tab02(event.getQuotaConditionVO());
			list.setConditionVO(event.getQuotaConditionVO());
			eventResponse.setRsVo(list);

		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaInquiry0089Tab04(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0089Event event = (EsmSaq0089Event) e;
		MonthlyQuotaAdjustmentInquiryBC command = new MonthlyQuotaAdjustmentInquiryBCImpl();

		try {

			event.getQuotaConditionVO().setChkCommand("SEARCHLIST04");
			ReturnVO list = command.searchMonthlyQuotaInquiry0089Tab04(event.getQuotaConditionVO());
			list.setConditionVO(event.getQuotaConditionVO());
			eventResponse.setRsVo(list);

		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

}