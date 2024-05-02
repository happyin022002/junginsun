/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName       : MonthlySalesQuotaInquirySC.java
 *@FileTitle      : MonthlySalesQuotaInquirySC
 *Open Issues     :
 *Change history  :
 *@LastModifyDate : 
 *@LastModifier   : 
 *@LastVersion    : 
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotainquiry;

import java.util.List;

import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.basic.MonthlyQuotaInquiryBC;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.basic.MonthlyQuotaInquiryBCImpl;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.event.EsmSaq0126Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.event.EsmSaq0127Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.event.EsmSaq0128Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.event.EsmSaq0139Event;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;

/**
 * MonthlySalesQuotaInquiry Business Logic ServiceCommand
 * 
 * @author
 * @see MonthlyQuotaInquiryDBDAO
 * @since J2EE 1.6
 */

public class MonthlySalesQuotaInquirySC extends ServiceCommandSupport {
	// Login User Information

	/**
	 * MonthlySalesQuotaInquiry preceding process for biz scenario<br>
	 * related objects creation<br>
	 */
	public void doStart() {
		log.debug("MonthlySalesQuotaInquirySC start");
	}

	/**
	 * MonthlySalesQuotaInquiry biz scenario closing<br>
	 * clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("MonthlySalesQuotaInquirySC end");
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

		if (e.getEventName().equalsIgnoreCase("EsmSaq0139Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchMonthlyQuotaInquiry0139Tab01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchMonthlyQuotaInquiry0139Tab02(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchMonthlyQuotaInquiry0139Tab03(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST13)) {
				eventResponse = searchMonthlyQuotaInquiry0139Tab03Sub01(e);
			}
		}

		else if (e.getEventName().equalsIgnoreCase("EsmSaq0126Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchMonthlyQuotaInquiry0126Tab01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchMonthlyQuotaInquiry0126Tab02(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchMonthlyQuotaInquiry0126Tab03HR(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST13)) {
				eventResponse = searchMonthlyQuotaInquiry0126Tab03Sub01HR(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {
				eventResponse = searchMonthlyQuotaInquiry0126Tab04(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) {
				eventResponse = searchMonthlyQuotaInquiry0126Tab05(e);
			}
		}

		else if (e.getEventName().equalsIgnoreCase("EsmSaq0127Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchMonthlyQuotaInquiry0127Tab01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchMonthlyQuotaInquiry0127Tab02(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchMonthlyQuotaInquiry0127Tab03(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST13)) {
				eventResponse = searchMonthlyQuotaInquiry0127Tab03Sub01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {
				eventResponse = searchMonthlyQuotaInquiry0127Tab04(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) {
				eventResponse = searchMonthlyQuotaInquiry0127Tab05(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)) {
				eventResponse = searchMonthlyQuotaInquiry0127Tab10(e); // 맨 앞 total tab
			}
		}

		else if (e.getEventName().equalsIgnoreCase("EsmSaq0128Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchMonthlyQuotaInquiry0128Tab01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchMonthlyQuotaInquiry0128Tab02(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchMonthlyQuotaInquiry0128Tab03(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)) {
				eventResponse = searchMonthlyQuotaInquiry0128Tab10(e);
			}
		}

		return eventResponse;
	}

	/**
	 * ESM_SAQ_0139 : [event]<br>
	 * [Container SBU] COMMAND ID : SEARCHLIST01<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private EventResponse searchMonthlyQuotaInquiry0139Tab01(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0139Event event = (EsmSaq0139Event) e;
		MonthlyQuotaInquiryBC command = new MonthlyQuotaInquiryBCImpl();
		ReturnVO returnVO = new ReturnVO();

		try {
			List list = command.searchMonthlyQuotaInquiry0139Tab01(event.getQuotaConditionVO());
			if (list.size() > 0) {
				returnVO.setConditionVO(event.getQuotaConditionVO());
				returnVO.setValueObjectVOs(list);
				eventResponse.setRsVo(returnVO);
			} else {
				eventResponse.setRsVoList(list);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0139 : [EVENT]<br>
	 * [Container SBU] COMMAND ID : SEARCHLIST02<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private EventResponse searchMonthlyQuotaInquiry0139Tab02(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0139Event event = (EsmSaq0139Event) e;
		MonthlyQuotaInquiryBC command = new MonthlyQuotaInquiryBCImpl();
		ReturnVO returnVO = new ReturnVO();

		try {
			List list = command.searchMonthlyQuotaInquiry0139Tab02(event.getQuotaConditionVO());
			if (list.size() > 0) {
				returnVO.setConditionVO(event.getQuotaConditionVO());
				returnVO.setValueObjectVOs(list);
				eventResponse.setRsVo(returnVO);
			} else {
				eventResponse.setRsVoList(list);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0139 : [EVENT]<br>
	 * [Container SBU] COMMAND ID :SEARCHLIST03<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private EventResponse searchMonthlyQuotaInquiry0139Tab03(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0139Event event = (EsmSaq0139Event) e;
		MonthlyQuotaInquiryBC command = new MonthlyQuotaInquiryBCImpl();
		ReturnVO returnVO = new ReturnVO();

		try {
			List list = command.searchMonthlyQuotaInquiry0139Tab03(event.getQuotaConditionVO());
			if (list.size() > 0) {
				returnVO.setConditionVO(event.getQuotaConditionVO());
				returnVO.setValueObjectVOs(list);
				eventResponse.setRsVo(returnVO);
			} else {
				eventResponse.setRsVoList(list);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0139 : [EVENT]<br>
	 * [Container SBU] COMMAND ID : SEARCHLIST13.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private EventResponse searchMonthlyQuotaInquiry0139Tab03Sub01(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0139Event event = (EsmSaq0139Event) e;
		MonthlyQuotaInquiryBC command = new MonthlyQuotaInquiryBCImpl();
		ReturnVO returnVO = new ReturnVO();

		try {
			List list = command.searchMonthlyQuotaInquiry0139Tab03Sub01(event.getQuotaConditionVO());
			if (list.size() > 0) {
				returnVO.setConditionVO(event.getQuotaConditionVO());
				returnVO.setValueObjectVOs(list);
				eventResponse.setRsVo(returnVO);
			} else {
				eventResponse.setRsVoList(list);
			}

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0126 : [EVENT]<br>
	 * [Trade Group] COMMAND ID : SEARCHLIST01.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private EventResponse searchMonthlyQuotaInquiry0126Tab01(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0126Event event = (EsmSaq0126Event) e;
		MonthlyQuotaInquiryBC command = new MonthlyQuotaInquiryBCImpl();
		ReturnVO returnVO = new ReturnVO();

		try {
			List list = command.searchMonthlyQuotaInquiry0126Tab01(event.getQuotaConditionVO());
			if (list.size() > 0) {
				returnVO.setConditionVO(event.getQuotaConditionVO());
				returnVO.setValueObjectVOs(list);
				eventResponse.setRsVo(returnVO);
			} else {
				eventResponse.setRsVoList(list);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0126 : [EVENT]<br>
	 * [Trade Group] COMMAND ID : SEARCHLIST02.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private EventResponse searchMonthlyQuotaInquiry0126Tab02(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0126Event event = (EsmSaq0126Event) e;
		MonthlyQuotaInquiryBC command = new MonthlyQuotaInquiryBCImpl();
		ReturnVO returnVO = new ReturnVO();

		try {
			List list = command.searchMonthlyQuotaInquiry0126Tab02(event.getQuotaConditionVO());
			if (list.size() > 0) {
				returnVO.setConditionVO(event.getQuotaConditionVO());
				returnVO.setValueObjectVOs(list);
				eventResponse.setRsVo(returnVO);
			} else {
				eventResponse.setRsVoList(list);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0126 : [EVENT]<br>
	 * [Trade Group] COMMAND ID : SEARCHLIST03.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private EventResponse searchMonthlyQuotaInquiry0126Tab03HR(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0126Event event = (EsmSaq0126Event) e;
		MonthlyQuotaInquiryBC command = new MonthlyQuotaInquiryBCImpl();
		ReturnVO returnVO = new ReturnVO();

		try {
			List list = command.searchMonthlyQuotaInquiry0126Tab03HR(event.getQuotaConditionVO());
			if (list.size() > 0) {
				returnVO.setConditionVO(event.getQuotaConditionVO());
				returnVO.setValueObjectVOs(list);
				eventResponse.setRsVo(returnVO);
			} else {
				eventResponse.setRsVoList(list);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0126 : [EVENT]<br>
	 * [Trade Group] COMMAND ID : SEARCHLIST13.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private EventResponse searchMonthlyQuotaInquiry0126Tab03Sub01HR(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0126Event event = (EsmSaq0126Event) e;
		MonthlyQuotaInquiryBC command = new MonthlyQuotaInquiryBCImpl();
		ReturnVO returnVO = new ReturnVO();

		try {
			List list = command.searchMonthlyQuotaInquiry0126Tab03Sub01HR(event.getQuotaConditionVO());
			if (list.size() > 0) {
				returnVO.setConditionVO(event.getQuotaConditionVO());
				returnVO.setValueObjectVOs(list);
				eventResponse.setRsVo(returnVO);
			} else {
				eventResponse.setRsVoList(list);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0126 : [EVENT]<br>
	 * [Trade Group] COMMAND ID : SEARCHLIST04.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private EventResponse searchMonthlyQuotaInquiry0126Tab04(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0126Event event = (EsmSaq0126Event) e;
		MonthlyQuotaInquiryBC command = new MonthlyQuotaInquiryBCImpl();
		ReturnVO returnVO = new ReturnVO();

		try {
			List list = command.searchMonthlyQuotaInquiry0126Tab04(event.getQuotaConditionVO());
			if (list.size() > 0) {
				returnVO.setConditionVO(event.getQuotaConditionVO());
				returnVO.setValueObjectVOs(list);
				eventResponse.setRsVo(returnVO);
			} else {
				eventResponse.setRsVoList(list);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0126 : [EVENT]<br>
	 * [Trade Group] COMMAND ID : SEARCHLIST05.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private EventResponse searchMonthlyQuotaInquiry0126Tab05(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0126Event event = (EsmSaq0126Event) e;
		MonthlyQuotaInquiryBC command = new MonthlyQuotaInquiryBCImpl();
		ReturnVO returnVO = new ReturnVO();

		try {
			List list = command.searchMonthlyQuotaInquiry0126Tab05(event.getQuotaConditionVO());
			if (list.size() > 0) {
				returnVO.setConditionVO(event.getQuotaConditionVO());
				returnVO.setValueObjectVOs(list);
				eventResponse.setRsVo(returnVO);
			} else {
				eventResponse.setRsVoList(list);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0127 : [EVENT]<br>
	 * [Regional Group] COMMAND ID : SEARCHLIST01.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private EventResponse searchMonthlyQuotaInquiry0127Tab01(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0127Event event = (EsmSaq0127Event) e;
		MonthlyQuotaInquiryBC command = new MonthlyQuotaInquiryBCImpl();
		ReturnVO returnVO = new ReturnVO();

		try {
			List list = command.searchMonthlyQuotaInquiry0127Tab01(event.getQuotaConditionVO());
			if (list.size() > 0) {
				returnVO.setConditionVO(event.getQuotaConditionVO());
				returnVO.setValueObjectVOs(list);
				eventResponse.setRsVo(returnVO);
			} else {
				eventResponse.setRsVoList(list);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0127 : [EVENT]<br>
	 * [Regional Group] COMMAND ID : SEARCHLIST02.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private EventResponse searchMonthlyQuotaInquiry0127Tab02(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0127Event event = (EsmSaq0127Event) e;
		MonthlyQuotaInquiryBC command = new MonthlyQuotaInquiryBCImpl();
		ReturnVO returnVO = new ReturnVO();

		try {
			List list = command.searchMonthlyQuotaInquiry0127Tab02(event.getQuotaConditionVO());
			if (list.size() > 0) {
				returnVO.setConditionVO(event.getQuotaConditionVO());
				returnVO.setValueObjectVOs(list);
				eventResponse.setRsVo(returnVO);
			} else {
				eventResponse.setRsVoList(list);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0127 : [EVENT]<br>
	 * [Regional Group] COMMAND ID : SEARCHLIST03.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private EventResponse searchMonthlyQuotaInquiry0127Tab03(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0127Event event = (EsmSaq0127Event) e;
		MonthlyQuotaInquiryBC command = new MonthlyQuotaInquiryBCImpl();
		ReturnVO returnVO = new ReturnVO();

		try {
			List list = command.searchMonthlyQuotaInquiry0127Tab03(event.getQuotaConditionVO());
			if (list.size() > 0) {
				returnVO.setConditionVO(event.getQuotaConditionVO());
				returnVO.setValueObjectVOs(list);
				eventResponse.setRsVo(returnVO);
			} else {
				eventResponse.setRsVoList(list);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0127 : [EVENT]<br>
	 * [Regional Group] COMMAND ID : SEARCHLIST13.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private EventResponse searchMonthlyQuotaInquiry0127Tab03Sub01(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0127Event event = (EsmSaq0127Event) e;
		MonthlyQuotaInquiryBC command = new MonthlyQuotaInquiryBCImpl();
		ReturnVO returnVO = new ReturnVO();

		try {
			List list = command.searchMonthlyQuotaInquiry0127Tab03Sub01(event.getQuotaConditionVO());
			if (list.size() > 0) {
				returnVO.setConditionVO(event.getQuotaConditionVO());
				returnVO.setValueObjectVOs(list);
				eventResponse.setRsVo(returnVO);
			} else {
				eventResponse.setRsVoList(list);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0127 : [EVENT]<br>
	 * [Regional Group] COMMAND ID : SEARCHLIST04.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private EventResponse searchMonthlyQuotaInquiry0127Tab04(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0127Event event = (EsmSaq0127Event) e;
		MonthlyQuotaInquiryBC command = new MonthlyQuotaInquiryBCImpl();
		ReturnVO returnVO = new ReturnVO();

		try {
			List list = command.searchMonthlyQuotaInquiry0127Tab04(event.getQuotaConditionVO());
			if (list.size() > 0) {
				returnVO.setConditionVO(event.getQuotaConditionVO());
				returnVO.setValueObjectVOs(list);
				eventResponse.setRsVo(returnVO);
			} else {
				eventResponse.setRsVoList(list);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0127 : [EVENT]<br>
	 * [Regional Group] COMMAND ID : SEARCHLIST05.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private EventResponse searchMonthlyQuotaInquiry0127Tab05(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0127Event event = (EsmSaq0127Event) e;
		MonthlyQuotaInquiryBC command = new MonthlyQuotaInquiryBCImpl();
		ReturnVO returnVO = new ReturnVO();

		try {
			List list = command.searchMonthlyQuotaInquiry0127Tab05(event.getQuotaConditionVO());
			if (list.size() > 0) {
				returnVO.setConditionVO(event.getQuotaConditionVO());
				returnVO.setValueObjectVOs(list);
				eventResponse.setRsVo(returnVO);
			} else {
				eventResponse.setRsVoList(list);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0127 : [EVENT]<br>
	 * [Regional Group] COMMAND ID : SEARCHLIST10.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private EventResponse searchMonthlyQuotaInquiry0127Tab10(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0127Event event = (EsmSaq0127Event) e;
		MonthlyQuotaInquiryBC command = new MonthlyQuotaInquiryBCImpl();
		ReturnVO returnVO = new ReturnVO();

		try {
			List list = command.searchMonthlyQuotaInquiry0127Tab10(event.getQuotaConditionVO());
			if (list.size() > 0) {
				returnVO.setConditionVO(event.getQuotaConditionVO());
				returnVO.setValueObjectVOs(list);
				eventResponse.setRsVo(returnVO);
			} else {
				eventResponse.setRsVoList(list);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0128 : [EVENT]<br>
	 * [Regional Office] COMMAND ID : SEARCHLIST01.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private EventResponse searchMonthlyQuotaInquiry0128Tab01(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0128Event event = (EsmSaq0128Event) e;
		MonthlyQuotaInquiryBC command = new MonthlyQuotaInquiryBCImpl();
		ReturnVO returnVO = new ReturnVO();

		try {
			List list = command.searchMonthlyQuotaInquiry0128Tab01(event.getQuotaConditionVO());
			if (list.size() > 0) {
				returnVO.setConditionVO(event.getQuotaConditionVO());
				returnVO.setValueObjectVOs(list);
				eventResponse.setRsVo(returnVO);
			} else {
				eventResponse.setRsVoList(list);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0128 : [EVENT]<br>
	 * [Regional Office] COMMAND ID : SEARCHLIST02.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private EventResponse searchMonthlyQuotaInquiry0128Tab02(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0128Event event = (EsmSaq0128Event) e;
		MonthlyQuotaInquiryBC command = new MonthlyQuotaInquiryBCImpl();
		ReturnVO returnVO = new ReturnVO();

		try {
			List list = command.searchMonthlyQuotaInquiry0128Tab02(event.getQuotaConditionVO());
			if (list.size() > 0) {
				returnVO.setConditionVO(event.getQuotaConditionVO());
				returnVO.setValueObjectVOs(list);
				eventResponse.setRsVo(returnVO);
			} else {
				eventResponse.setRsVoList(list);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0128 : [EVENT]<br>
	 * [Regional Office] COMMAND ID : SEARCHLIST03.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private EventResponse searchMonthlyQuotaInquiry0128Tab03(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0128Event event = (EsmSaq0128Event) e;
		MonthlyQuotaInquiryBC command = new MonthlyQuotaInquiryBCImpl();
		ReturnVO returnVO = new ReturnVO();

		try {
			List list = command.searchMonthlyQuotaInquiry0128Tab03(event.getQuotaConditionVO());
			if (list.size() > 0) {
				returnVO.setConditionVO(event.getQuotaConditionVO());
				returnVO.setValueObjectVOs(list);
				eventResponse.setRsVo(returnVO);
			} else {
				eventResponse.setRsVoList(list);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0128 : [EVENT]<br>
	 * [Regional Office] COMMAND ID : SEARCHLIST10.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private EventResponse searchMonthlyQuotaInquiry0128Tab10(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0128Event event = (EsmSaq0128Event) e;
		MonthlyQuotaInquiryBC command = new MonthlyQuotaInquiryBCImpl();
		ReturnVO returnVO = new ReturnVO();

		try {
			List list = command.searchMonthlyQuotaInquiry0128Tab10(event.getQuotaConditionVO());
			if (list.size() > 0) {
				returnVO.setConditionVO(event.getQuotaConditionVO());
				returnVO.setValueObjectVOs(list);
				eventResponse.setRsVo(returnVO);
			} else {
				eventResponse.setRsVoList(list);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
}