/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ReceiveEAISC.java
*@FileTitle : Receive EAI SC
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-06
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2006-12-15 Yong-cheon Shin
* 1.0 최초 생성
* 2009-10-06 전병석
* 1.3 버전 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edisetup;

import com.hanjin.apps.alps.esd.sce.edisetup.basic.EDISetupBC;
import com.hanjin.apps.alps.esd.sce.edisetup.basic.EDISetupBCImpl;
import com.hanjin.apps.alps.esd.sce.edisetup.event.EDISetupEvent;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingMasterMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingMasterMgtBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
/**
 * ENIS-SCE Business Logic ServiceCommand<br>
 * - ENIS-SCE에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author Yong-cheon Shin
 * @see ReceiveEAIResponse,ReceiveEAIDAO 참조
 * @since J2EE 1.4
 */
public class EDISetupSC   extends ServiceCommandSupport  {
    /**
     * @param  e Event
     * @return EventResponse
     * @throws EventException
     */
	@Override
	public EventResponse perform(Event e) throws EventException {
        EventResponse eventResponse = null;
        log.debug("event name : " + e.getEventName());
        if(e.getEventName().equals("EDISetupEvent")){
        	if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
        		eventResponse = syncEdi_cgo_stnd_sts(e);
        	}
			if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = syncEdi_group(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.MODIFY03)) {
				eventResponse = syncEdi_grp_cgo(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.MODIFY04)) {
				eventResponse = syncEdi_grp_cust(e);
			}
        }
        return eventResponse;
	}
    /**
     * @param  e Event
     * @return EventResponse
     * @throws EventException
     */	
	public EventResponse syncEdi_cgo_stnd_sts(Event e) throws EventException {
		log.debug("EDISetupSC :" + "function of syncEdi_cgo_stnd_sts started.");
		// PDTO(Data Transfer Object including Parameters)
		EDISetupEvent event = (EDISetupEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EDISetupBC command = new EDISetupBCImpl();

		try{
			  begin();
			  command.syncEdi_cgo_stnd_sts(event.getMessage());
			  commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

			return eventResponse;
		}
	
    /** EAI로 부터 JMS를 통해 들어온 값을 받아서 처리한다.(ESD0320001)
     * @param  e Event
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse syncEdi_group(Event e)  throws EventException {
		log.debug("EDISetupSC :" + "function of syncEdi_group started.");
		// PDTO(Data Transfer Object including Parameters)
		EDISetupEvent event = (EDISetupEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EDISetupBC command = new EDISetupBCImpl();
		
		BookingMasterMgtBC bkgMstBC = new BookingMasterMgtBCImpl();
    	try {
    		 begin();
    		 command.syncEdi_group(event.getMessage());
    		 commit();
    		 
    		 begin();
    		 bkgMstBC.manageBkgEdiGrp(event.getMessage());
    		 commit();
    		 
    	} catch (EventException de) {
            rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
    	} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    	return eventResponse;
    	
    }	
    /** EAI로 부터 JMS를 통해 들어온 값을 받아서 처리한다.(ESD0330001)
     * @param  e Event 
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse syncEdi_grp_cgo(Event e)  throws EventException {
		log.debug("EDISetupSC :" + "function of syncEdi_grp_cgo started.");
		// PDTO(Data Transfer Object including Parameters)
		EDISetupEvent event = (EDISetupEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EDISetupBC command = new EDISetupBCImpl();
    	try {
    		  begin();
    		  command.syncEdi_grp_cgo(event.getMessage());
    		  commit();
    	} catch (EventException de) {
            rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        } catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
    }
	
    /** EAI로 부터 JMS를 통해 들어온 값을 받아서 처리한다.(ESD0340001)
     * @param  e Event 
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse syncEdi_grp_cust(Event e) throws EventException {
        //public String syncEdi_grp_cust(String str)  throws EventException {
    	log.debug("EDISetupSC :" + "function of syncEdi_grp_cust started.");
		EDISetupEvent event = (EDISetupEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EDISetupBC command = new EDISetupBCImpl();
		
		BookingMasterMgtBC bkgMstBC = new BookingMasterMgtBCImpl();
    	try {
    		  begin();
    	      command.syncEdi_grp_cust(event.getMessage());
    		  commit();
    	
    		  begin();
    		  bkgMstBC.manageBkgEdiGrpCust(event.getMessage());
    		  commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
			return eventResponse;
		}	

}
