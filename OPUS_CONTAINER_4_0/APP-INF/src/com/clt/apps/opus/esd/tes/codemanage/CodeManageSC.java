/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CodeManageSC.java
*@FileTitle : Cost Code Creation
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tes.codemanage;

import com.clt.apps.opus.esd.tes.codemanage.codemanage.basic.CodeManageBC;
import com.clt.apps.opus.esd.tes.codemanage.codemanage.basic.CodeManageBCImpl;
import com.clt.apps.opus.esd.tes.codemanage.codemanage.event.EsdTes0027Event;
import com.clt.apps.opus.esd.tes.codemanage.codemanage.event.EsdTes0028Event;
import com.clt.apps.opus.esd.tes.codemanage.codemanage.event.EsdTes0031Event;
import com.clt.apps.opus.esd.tes.codemanage.codemanage.event.EsdTes0038Event;
import com.clt.apps.opus.esd.tes.codemanage.codemanage.event.EsdTes0036Event;
import com.clt.apps.opus.esd.tes.codemanage.codemanage.event.EsdTes0037Event;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ESD Business Logic ServiceCommand<br>
 * Handling business transaction for ESD<br>
 * 
 * @author jongbaemoon
 * @see CodeManageDBDAO
 * @since J2EE 1.6
 */
public class CodeManageSC extends ServiceCommandSupport {
	// Login User Information
//	private SignOnUserAccount account = null;

	/**
	 * ESD preceding process for biz scenario<br>
	 * CodeManage preceding process for biz scenario<br>
	 */
	public void doStart() {
	}

	/**
	 * ESD Handling for the end of working scenario<br>
	 * CodeManage Clearing object by the end of work scenario<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("CodeManageSC end");
	}

	/**
	 * ESD Handling working scenario of each event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		log.debug("CodeManageSC :: " + e.getEventName());

		if (e.getEventName().equalsIgnoreCase("EsdTes0027Event")) {			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCostCodeInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.ADD)) {				
				eventResponse = createCostCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {				
				eventResponse = modifyCostCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {				
				eventResponse = modifyCostCodeDelete(e);								
			} else {
				eventResponse = searchAcctCodeList();
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("EsdTes0028Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCostCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {				
				eventResponse = searchCostcdOption(e);				
			} else {
				//eventResponse = searchCostCode(e);
			}			
			//eventResponse = searchCostCode(e);
		}		
		
		// Agreement User Password Check
//		if (e.getEventName().equalsIgnoreCase("EsdTes9090Event")) {
//			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				
//				eventResponse = checkMandatory(e);
//			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {				
//				eventResponse = checkAgreementPassWord(e);
//			}  			
//		}
		
        // EsdTes0031Event Process
        if (e.getEventName().equalsIgnoreCase("EsdTes0031Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchCarrierCode(e);
//            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
//                eventResponse = multiCarrierCode(e);
            } else {
            	eventResponse = searchCarrierCode(e);
            }
        }	
        
        // EsdTes0038Event Process
        if (e.getEventName().equalsIgnoreCase("EsdTes0038Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchTmnlSoCostCode(e);
            } else {
            	eventResponse = searchTmnlSoCostCode(e);
            }
        }
        
        // EsdTes0036Event Process
        if (e.getEventName().equalsIgnoreCase("EsdTes0036Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchTmnlAgmtCostCode(e);
            } else {
            	eventResponse = searchTmnlAgmtCostCode(e);
            }
        }
        
        // EsdTes0037Event Process
        if (e.getEventName().equalsIgnoreCase("EsdTes0037Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchTmnlAgmtVrfyMzdCode(e);
            } else {
            	eventResponse = searchTmnlAgmtVrfyMzdCode(e);
            }
        }
        
		return eventResponse;
	}

	
	private EventResponse searchAcctCodeList() throws EventException {	
		// Object including the result of user request (DB Result Set, Object and etc)
		EventResponse eventResponse = null;
		
		try {
			CodeManageBC command = new CodeManageBCImpl();
			eventResponse = command.searchAcctCodeList();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * retrieve event process
	 * CodeManage cost code list retrieve event process
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0028Event event = (EsdTes0028Event)e;
		// Object including the result of user request (DB Result Set, Object and etc)
		EventResponse eventResponse = null;
		
		try {
			CodeManageBC command = new CodeManageBCImpl();
			eventResponse = command.searchCostCode(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event process
	 * CodeManage cost code Specific information retrieve event process
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostCodeInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0027Event event = (EsdTes0027Event)e;
		// Object including the result of user request (DB Result Set, Object and etc)
		EventResponse eventResponse = null;
		
		try {
			CodeManageBC command = new CodeManageBCImpl();
			eventResponse = command.searchCostCodeInfo(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * retrieve event process
	 * CodeManage user Specific information retrieve event process
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
//	private EventResponse checkMandatory(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		EsdTes9090Event event = (EsdTes9090Event)e;
//		// Object including the result of user request (DB Result Set, Object and etc)
//		EventResponse eventResponse = null;
//		
//		try {
//			CodeManageBC command = new CodeManageBCImpl();
//			eventResponse = command.checkMandatory(event);
//		} catch (EventException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//		return eventResponse;
//	}
	
	/**
	 * retrieve event process
	 * CodeManage user Specific information retrieve event process
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
//	private EventResponse checkAgreementPassWord(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		EsdTes9090Event event = (EsdTes9090Event)e;
//		// Object including the result of user request (DB Result Set, Object and etc)
//		EventResponse eventResponse = null;
//		
//		try {
//			CodeManageBC command = new CodeManageBCImpl();
//			eventResponse = command.checkAgreementPassWord(event);
//		} catch (EventException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//		return eventResponse;
//	}	
	
	/**
	 * Create, Update, Delete event process<br>
	 * CodeManage cost code Create, Update, Delete event process<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createCostCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0027Event event = (EsdTes0027Event)e;

		try {
			begin();
			CodeManageBC command = new CodeManageBCImpl();
			command.createCostCode(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return this.searchCostCodeInfo(e);
	}	
	
	/**
	 * Create, Update, Delete event process<br>
	 * CodeManage cost code Create, Update, Delete event process<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyCostCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0027Event event = (EsdTes0027Event)e;

		try {
			begin();
			CodeManageBC command = new CodeManageBCImpl();
			command.modifyCostCode(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return this.searchCostCodeInfo(e);
	}
	
	/**
	 * Create, Update, Delete event process<br>
	 * CodeManage cost code Create, Update, Delete event process<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyCostCodeDelete(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0027Event event = (EsdTes0027Event)e;

		try {
			begin();
			CodeManageBC command = new CodeManageBCImpl();
			command.modifyCostCodeDelete(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
//		return this.searchCostCodeInfo(e);
		return null;
	}	
	
	   /**
     * retrieve event process
     * CodeManage Specific List retrieve event process
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchCarrierCode(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsdTes0031Event event = (EsdTes0031Event)e;
        // Object including the result of user request (DB Result Set, Object and etc)
        EventResponse eventResponse = null;
        
        try {
            CodeManageBC command = new CodeManageBCImpl();
            eventResponse = command.searchCarrierCode(event);
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }

	/**
     * Terminal SO Cost Code retrieve event process<br>
     * CodeManage Specific List retrieve event process<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchTmnlSoCostCode(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	EsdTes0038Event event = (EsdTes0038Event)e;
    	// Object including the result of user request (DB Result Set, Object and etc)
        EventResponse eventResponse = null;
        
        try {
            CodeManageBC command = new CodeManageBCImpl();
            eventResponse = command.searchTmnlSoCostCode(event);
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }   
    
    /**
     * Terminal Agreement Cost Code retrieve event process<br>
     * CodeManage Specific List retrieve event process<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchTmnlAgmtCostCode(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	EsdTes0036Event event = (EsdTes0036Event)e;
    	// Object including the result of user request (DB Result Set, Object and etc)
        EventResponse eventResponse = null;
        
        try {
            CodeManageBC command = new CodeManageBCImpl();
            eventResponse = command.searchTmnlAgmtCostCode(event);
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
        
    /**
     * Terminal Agreement Cost Code retrieve event process<br>
     * CodeManage Specific List retrieve event process<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchTmnlAgmtVrfyMzdCode(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsdTes0037Event event = (EsdTes0037Event)e;
     // Object including the result of user request (DB Result Set, Object and etc)
        EventResponse eventResponse = null;
        
        try {
            CodeManageBC command = new CodeManageBCImpl();
            eventResponse = command.searchTmnlAgmtVrfyMzdCode(event);
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
     * retrieve event process
     * ESD_SCE_013 Specific List retrieve event process
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchCostcdOption(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsdTes0028Event event = (EsdTes0028Event)e;
        // Object including the result of user request (DB Result Set, Object and etc)
        EventResponse eventResponse = null;
        
        try {
        	CodeManageBC command = new CodeManageBCImpl();
            eventResponse = command.searchCostcdOption(event);
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
}