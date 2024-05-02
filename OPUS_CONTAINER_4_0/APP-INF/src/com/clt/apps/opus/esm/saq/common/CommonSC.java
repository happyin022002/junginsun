/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName       : CommonSC.java
 *@FileTitle      : Common
 *Open Issues     :
 *Change history  :
 *@LastModifyDate : 
 *@LastModifier   : 
 *@LastVersion    :
=========================================================*/

package com.clt.apps.opus.esm.saq.common;

import java.util.List;

import com.clt.apps.opus.esm.saq.common.common.basic.CommonBC;
import com.clt.apps.opus.esm.saq.common.common.basic.CommonBCImpl;
import com.clt.apps.opus.esm.saq.common.common.event.EsmSaq0112Event;
import com.clt.apps.opus.esm.saq.common.common.event.EsmSaq0116Event;
import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.common.common.vo.SearchMonthlyQuotaAdjustmentVVD0116ListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Common Business Logic ServiceCommand
 * - handling business transaction
 * 
 * @author
 * @see ComboxEventResponse,CommonDBDAO
 * @since J2EE 1.4
 */

public class CommonSC extends ServiceCommandSupport {

	SignOnUserAccount account = null;

	/**
	 * preceding process for biz scenario<br>
	 * related objects creation<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error("CommonSC preceding process error " + e.toString(), e);
		}
	}

	/**
	 * Common biz scenario closing<br>
	 * Common업무 clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("CommonSC end");
	}

	/**
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;
		if (e.getEventName().equalsIgnoreCase("EsmSaqCodEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST) || e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchCommonCodeList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSaq0112Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchMonthlyQuotaTradeRemarkList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = addMonthlyQuotaTradeRemark(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchMonthlyQuotaRHQRemarkList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = addMonthlyQuotaRHQRemark(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchMonthlyQuotaSlsRHQRemarkList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY03)) {
				eventResponse = addMonthlyQuotaSlsRHQRemark(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSaq0116Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchMonthlyQuotaAdjustmentVVD0116List(e);
			}
		}
		return eventResponse;
	}

	// /**
	// *
	// * @param del
	// * @param isRepTrade
	// * @return
	// * @throws EventException
	// */
	// public EventResponse searchTradeComboList(String del, boolean isRepTrade) throws EventException {
	// EventResponse eventResponse = null;
	//
	// try {
	// CommonBC command = new CommonBCImpl();
	// eventResponse = command.searchTradeComboList(del, new Boolean(isRepTrade));
	// } catch (EventException de) {
	// log.error("err " + de.toString(), de);
	// throw new EventException(de.getMessage());
	// }
	// return eventResponse;
	// }

	// /**
	// *
	// * @param del
	// * @param isRepTrade
	// * @param isAll
	// * @return
	// * @throws EventException
	// */
	// public EventResponse searchSubTradeComboList(String del, boolean isRepTrade, boolean isAll)
	// throws EventException {
	// EventResponse eventResponse = null;
	//
	// try {
	// CommonBC command = new CommonBCImpl();
	// eventResponse = command.searchSubTradeComboList(del, new Boolean(isRepTrade),
	// new Boolean(isAll));
	// } catch (EventException de) {
	// log.error("err " + de.toString(), de);
	// throw new EventException(de.getMessage());
	// }
	// return eventResponse;
	// }

	// /**
	// *
	// * @param del
	// * @return
	// * @throws EventException
	// */
	// public EventResponse searchRLaneComboList(String del) throws EventException {
	// return searchRLaneComboList(del, new Boolean(false));
	// }
	//
	// /**
	// *
	// * @param del
	// * @param ipc
	// * @return
	// * @throws EventException
	// */
	// public EventResponse searchRLaneComboList(String del, Boolean ipc) throws EventException {
	// EventResponse eventResponse = null;
	//
	// try {
	// CommonBC command = new CommonBCImpl();
	// eventResponse = command.searchRLaneComboList(del, ipc);
	// } catch (EventException de) {
	// log.error("err " + de.toString(), de);
	// throw new EventException(de.getMessage());
	// }
	// return eventResponse;
	// }

	// /**
	// *
	// * @param method
	// * @param del
	// * @return
	// * @throws EventException
	// */
	// public EventResponse searchCodeList(String method, String del) throws EventException {
	// EventResponse eventResponse = null;
	//
	// try {
	// CommonBC command = new CommonBCImpl();
	// eventResponse = command.searchCodeList(method, del);
	// } catch (EventException de) {
	// log.error("err " + de.toString(), de);
	// throw new EventException(de.getMessage());
	// }
	// return eventResponse;
	// }

	// /**
	// *
	// * @param code
	// * @param del
	// * @return
	// * @throws EventException
	// */
	// public EventResponse searchCommonCodeList(String code, String del) throws EventException {
	// EventResponse eventResponse = null;
	//
	// try {
	// CommonBC command = new CommonBCImpl();
	// eventResponse = command.searchCommonCodeList(code, del);
	// } catch (EventException de) {
	// log.error("err " + de.toString(), de);
	// throw new EventException(de.getMessage());
	// }
	// return eventResponse;
	// }

	/**
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommonCodeList(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			CommonBC command = new CommonBCImpl();
			eventResponse = command.searchCommonCodeList(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	// /**
	// *
	// * @param del
	// * @return
	// * @throws EventException
	// */
	// public EventResponse searchRHQComboList(String del) throws EventException {
	// EventResponse eventResponse = null;
	//
	// try {
	// CommonBC command = new CommonBCImpl();
	// eventResponse = command.searchRHQComboList(del);
	// } catch (EventException de) {
	// log.error("err " + de.toString(), de);
	// throw new EventException(de.getMessage());
	// }
	// return eventResponse;
	// }

	// /**
	// *
	// * @param module
	// * @param rhq
	// * @param del
	// * @return
	// * @throws EventException
	// */
	// public EventResponse searchAQComboList(String module, String rhq, String del)
	// throws EventException {
	// EventResponse eventResponse = null;
	//
	// try {
	// CommonBC command = new CommonBCImpl();
	// eventResponse = command.searchAQComboList(module, rhq, del);
	// } catch (EventException de) {
	// log.error("err " + de.toString(), de);
	// throw new EventException(de.getMessage());
	// }
	// return eventResponse;
	// }

	// /**
	// *
	// * @param ofc
	// * @param del
	// * @return
	// * @throws EventException
	// */
	// public EventResponse searchTargetGroupComboList(String ofc, String del) throws EventException {
	// EventResponse eventResponse = null;
	//
	// try {
	// CommonBC command = new CommonBCImpl();
	// eventResponse = command.searchTargetGroupComboList(ofc, del);
	// } catch (EventException de) {
	// log.error("err " + de.toString(), de);
	// throw new EventException(de.getMessage());
	// }
	// return eventResponse;
	// }

	// /**
	// *
	// * @param module
	// * @param rhq
	// * @param del
	// * @return
	// * @throws EventException
	// */
	// public EventResponse searchRgnOfcComboList(String module, String rhq, String del)
	// throws EventException {
	// EventResponse eventResponse = null;
	//
	// try {
	// CommonBC command = new CommonBCImpl();
	// eventResponse = command.searchRgnOfcComboList(module, rhq, del);
	// } catch (EventException de) {
	// log.error("err " + de.toString(), de);
	// throw new EventException(de.getMessage());
	// }
	// return eventResponse;
	// }

	// /**
	// *
	// * @param del
	// * @return
	// * @throws EventException
	// */
	// public EventResponse searchKAMerComboList(String del) throws EventException {
	// EventResponse eventResponse = null;
	//
	// try {
	// CommonBC command = new CommonBCImpl();
	// eventResponse = command.searchKAMerComboList(del);
	// } catch (EventException de) {
	// log.error("err " + de.toString(), de);
	// throw new EventException(de.getMessage());
	// }
	// return eventResponse;
	// }

	/**
	 * ESM_SAQ_112 TRD_RMK - retrieving from ESM_SAQ_112 TRD_RMK<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaTradeRemarkList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0112Event event = (EsmSaq0112Event) e;
		QuotaConditionVO quotaConditionVO = event.getQuotaConditionVO();
		try {
			quotaConditionVO.setChkCommand("SEARCHLIST01");

			CommonBC command = new CommonBCImpl();
			ReturnVO list = command.searchMonthlyQuotaTradeRemarkList(e);

			list.setConditionVO(quotaConditionVO);

			eventResponse.setRsVo(list);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse addMonthlyQuotaTradeRemark(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();
			CommonBC command = new CommonBCImpl();
			command.addMonthlyQuotaTradeRemark(e);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("status", "OK");
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaRHQRemarkList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0112Event event = (EsmSaq0112Event) e;
		QuotaConditionVO quotaConditionVO = event.getQuotaConditionVO();

		try {

			CommonBC command = new CommonBCImpl();

			// event.setChkCommand("SEARCHLIST02");
			quotaConditionVO.setChkCommand("SEARCHLIST02");

			ReturnVO list = command.searchMonthlyQuotaRHQRemarkList(e);

			// list.addList(event);
			list.setConditionVO(quotaConditionVO);

			eventResponse.setRsVo(list);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaSlsRHQRemarkList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0112Event event = (EsmSaq0112Event) e;
		QuotaConditionVO quotaConditionVO = event.getQuotaConditionVO();

		try {
			CommonBC command = new CommonBCImpl();

			// event.setChkCommand("SEARCHLIST03");
			quotaConditionVO.setChkCommand("SEARCHLIST03");

			ReturnVO list = command.searchMonthlyQuotaSlsRHQRemarkList(e);
			// list.addList(event);
			list.setConditionVO(quotaConditionVO);

			eventResponse.setRsVo(list);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse addMonthlyQuotaRHQRemark(Event e) throws EventException {

		// EventResponse eventResponse = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();
			CommonBC command = new CommonBCImpl();
			command.addMonthlyQuotaRHQRemark(e);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("status", "OK");
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse addMonthlyQuotaSlsRHQRemark(Event e) throws EventException {

		// EventResponse eventResponse = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();
			CommonBC command = new CommonBCImpl();
			command.addMonthlyQuotaSlsRHQRemark(e);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("status", "OK");
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */

	private EventResponse searchMonthlyQuotaAdjustmentVVD0116List(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0116Event event = (EsmSaq0116Event) e;
		CommonBC command = new CommonBCImpl();

		try {

			QuotaConditionVO quotaConditionVO = event.getQuotaConditionVO();
			List<SearchMonthlyQuotaAdjustmentVVD0116ListVO> list = command.searchMonthlyQuotaAdjustmentVVD0116List(quotaConditionVO);

			eventResponse.setRsVoList(list);
			eventResponse.setETCData("status", "OK");

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

}