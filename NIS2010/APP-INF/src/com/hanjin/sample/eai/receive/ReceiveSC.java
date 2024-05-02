package com.hanjin.sample.eai.receive;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.EquipmentMovementMgtSC;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event.UbizhjsAlpsCtmEqmvmtEvent;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.EBookingConductSC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkgEBkgReceiptEvent;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkgWeb0090001Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.sample.eai.receive.event.ReceiveEvent;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;

public class ReceiveSC extends ServiceCommandSupport {
	// Login User Information 
	private SignOnUserAccount account = null;

	public void doEnd() {
		log.debug("EBookingConductSC 종료");
	}

	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-EBookingConduct system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
			if (e.getEventName().equalsIgnoreCase("ReceiveEvent")) {
				if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
					eventResponse = receiveEqMvmtEDIForGatenew(e);
				}else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
					eventResponse = receiptXterVGMRqst(e);
				}else if(e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
					eventResponse = eBookingAutoUpload(e);
				}else if(e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
					eventResponse = receiptXterRqst(e);
				}
				
			}
		}
		catch (EventException ex) {
			throw ex;
		}
		catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * Booking Receipt EDI
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse receiptXterRqst(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ReceiveEvent receiveEvent = (ReceiveEvent) e;
		Event event = null;
		try {
			EBookingConductSC eBookingConductSC = new EBookingConductSC();
			event = new EsmBkgEBkgReceiptEvent();
			eBookingConductSC = new EBookingConductSC();

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			if (!"".equals(JSPUtil.getNullNoTrim(receiveEvent.getMsg()))) {
				((EsmBkgEBkgReceiptEvent) event).setRcvMsg(receiveEvent.getMsg());
				eBookingConductSC.perform(event);
			}

		} catch (EventException e1) {
			rollback();
			throw new EventException(new ErrorHandler(e1).getMessage(), e1);
		}
		return eventResponse;
	}
	
	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse receiveEqMvmtEDIForGatenew(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ReceiveEvent receiveEvent = (ReceiveEvent)e;
		Event event = new UbizhjsAlpsCtmEqmvmtEvent();
		EquipmentMovementMgtSC sc = new EquipmentMovementMgtSC();
		FormCommand f = new FormCommand();
		f.setCommand(FormCommand.MULTI);
		event.setFormCommand(f);
		((UbizhjsAlpsCtmEqmvmtEvent) event).setFlatFile(receiveEvent.getMsg());
		try {
			sc.perform(event);
//			rollback();
		} catch (EventException ex) {
			rollback();
			throw new EventException(ex.getCause().getCause().getLocalizedMessage(), ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getCause().getCause().getLocalizedMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VGM EDI
	 * @param e
	 * @throws DAOException
	 */
	public EventResponse receiptXterVGMRqst( Event e) throws DAOException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		 ReceiveEvent receiveEvent = (ReceiveEvent)e;
	     Event event = null;
	     try {
	    	 EBookingConductSC eBookingConductSC = new EBookingConductSC();
	    	 event = new EsmBkgEBkgReceiptEvent();
	    	 eBookingConductSC = new EBookingConductSC();
	    	 
	    	 FormCommand f = new FormCommand();
			 f.setCommand(FormCommand.MULTI01);
			 event.setFormCommand(f);
	    	 ((EsmBkgEBkgReceiptEvent)event).setRcvMsg(receiveEvent.getMsg());
	    	 
	    	 eBookingConductSC.perform(event);
	    	 
	     } catch (EventException ee) {
	    	rollback();
            log.error("EventException ee : " + ee.toString(), ee);
            throw new DAOException(new ErrorHandler(ee).getMessage());
	 	 } catch (Exception e1) {
	 		rollback();
	 		log.error("Exception e : " + e1.toString());
	 		throw new DAOException(new ErrorHandler(e1).getMessage());
	     }
	     return eventResponse;
	}
	
	/**
	 * e-Booking Auto Upload
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse eBookingAutoUpload(Event e) throws EventException {
		EventResponse eventResponse = new GeneralEventResponse();
		ReceiveEvent receiveEvent = (ReceiveEvent)e;
		EsmBkgWeb0090001Event event = new EsmBkgWeb0090001Event();
		EBookingConductSC eBookingConductSC = new EBookingConductSC();
		try {
			event.setAttribute("com.hanjin.component.signon.SIGN_ON_USER_ACCOUNT", account);
			event.setAttribute("account", account);
			event.setBkgWebServiceVO(receiveEvent.getBkgWebServiceVO());
			eventResponse = eBookingConductSC.perform(event);
		} catch (EventException ex) {
			rollback();
			throw new EventException(ex.getCause().getCause().getLocalizedMessage(), ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getCause().getCause().getLocalizedMessage(), ex);
		}
		return eventResponse;
	}
}