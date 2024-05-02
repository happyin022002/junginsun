/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TPBInterfaceSC.java
*@FileTitle : 3rd Party Interface Test
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.common.tpbinterface;

import com.clt.apps.opus.esd.tpb.common.tpbinterface.basic.TPBInterfaceBC;
import com.clt.apps.opus.esd.tpb.common.tpbinterface.basic.TPBInterfaceBCImpl;
import com.clt.apps.opus.esd.tpb.common.tpbinterface.event.TPBInterfaceEvent;
import com.clt.apps.opus.esd.tpb.common.tpbinterface.integration.TPBInterfaceDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * -ESD Business Logic ServiceCommand - -CandidateManage business transaction process
 * 
 * @author 
 * @see TPBInterfaceDBDAO
 * @since J2EE 1.6
 */ 

public class TPBInterfaceSC extends ServiceCommandSupport {
	// Login User Information
	@SuppressWarnings("unused")
	private SignOnUserAccount account = null;

	/**
	 * TPBInterfaceSC system business scenario<br>
	 * business scenario call<br>
	 */
	public void doStart() {
		log.debug("TPBInterfaceSC 시작");
		try {
			//checking login
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * TPBInterfaceSC system business scenario deadline<br>
	 * business scenario deadline<br>
	 */
	public void doEnd() {
		log.debug("TPBInterfaceSC 종료");
	}


	/**
	 * processing business scenario<br>
	 * branch processing all event by CandidateManage system business<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		TPBInterfaceEvent event = (TPBInterfaceEvent)e;
		EventResponse eventResponse = null;
		
		// SC event
		if (e.getEventName().equalsIgnoreCase("TPBInterfaceEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)){
				log.debug(" event.getBiz_mode_flag() : " + event.getBiz_mode_flag());
				if ( event.getBiz_mode_flag().equals("TESTPB")){
					eventResponse = createTESTPB(e);
				}else if ( event.getBiz_mode_flag().equals("TRSTPB")){
					eventResponse = createTRSTPB(e);
				}else if ( event.getBiz_mode_flag().equals("MNRTPB")){
					eventResponse = createMNRTPB(e);
				}else if ( event.getBiz_mode_flag().equals("TESTPBFLAG")){
					eventResponse = searchTpbTesDltFlg(e);
				}
			}
		} 
		return eventResponse;
	}
	
	/**
	 * TPBInterfaceEvent<br>
	 * <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createTESTPB(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TPBInterfaceEvent event = (TPBInterfaceEvent)e;
		TPBInterfaceBC command = new TPBInterfaceBCImpl();

		try{
			begin();
			boolean isSuccessful = command.createTESTPB(event.getTpbInterfaceVOs());
			event.setSuccessful(isSuccessful);
			
			String successYN = isSuccessful?"Y":"N";
			eventResponse.setETCData("successYN",successYN);
			
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Receving Data From TRS process<br>
	 * <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createTRSTPB(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TPBInterfaceEvent event = (TPBInterfaceEvent)e;
		TPBInterfaceBC command = new TPBInterfaceBCImpl();
		
		try{
			begin();
			boolean isSuccessful = command.createTRSTPB(event.getTpbInterfaceVOs());
			event.setSuccessful(isSuccessful);
			
			String successYN = isSuccessful?"Y":"N";
			eventResponse.setETCData("successYN",successYN);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * Receving Data From MNR process<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createMNRTPB(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TPBInterfaceEvent event = (TPBInterfaceEvent)e;
		TPBInterfaceBC command = new TPBInterfaceBCImpl();
		
		try{
			begin();
			boolean isSuccessful = command.createMNRTPB(event.getTpbInterfaceVOs());
			event.setSuccessful(isSuccessful);
			
			String successYN = isSuccessful?"Y":"N";
			eventResponse.setETCData("successYN",successYN);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * TPBInterfaceEvent<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTpbTesDltFlg(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TPBInterfaceEvent event = (TPBInterfaceEvent)e;
		TPBInterfaceBC command = new TPBInterfaceBCImpl();

		try{
			begin();
			String reValueAll = "";
			StringBuffer  reValueAllBuf = new StringBuffer();
			String successYN = "N";
			String[] reValue = command.searchTpbTesDltFlg(event.getTpbInterfaceVOs());
			
			for(int i=0 ; i < reValue.length ; i++){
//				reValueAll = reValueAll + reValue[i] + "|";
				reValueAllBuf.append(reValue[i]).append("|");
			}
			reValueAll = reValueAllBuf.toString();
			
			if(reValueAll.length()>0){
				successYN = "Y";
			}
			eventResponse.setETCData("successYN",successYN);
			eventResponse.setETCData("reValue",reValueAll);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	
}
