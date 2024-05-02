/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TransportmanageSC.java
*@FileTitle : C/H Audit
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage;

import java.util.List;

import com.clt.apps.opus.esd.eas.transportmanage.basic.CHAuditTroArmanageBC;
import com.clt.apps.opus.esd.eas.transportmanage.basic.CHAuditTroArmanageBCImpl;
import com.clt.apps.opus.esd.eas.transportmanage.basic.CnlBKGCntrmanageBC;
import com.clt.apps.opus.esd.eas.transportmanage.basic.CnlBKGCntrmanageBCImpl;
import com.clt.apps.opus.esd.eas.transportmanage.basic.DOFChgColInqmanageBC;
import com.clt.apps.opus.esd.eas.transportmanage.basic.DOFChgColInqmanageBCImpl;
import com.clt.apps.opus.esd.eas.transportmanage.basic.DOFChgColPermanageBC;
import com.clt.apps.opus.esd.eas.transportmanage.basic.DOFChgColPermanageBCImpl;
import com.clt.apps.opus.esd.eas.transportmanage.basic.DOFChgTrfmanageBC;
import com.clt.apps.opus.esd.eas.transportmanage.basic.DOFChgTrfmanageBCImpl;
import com.clt.apps.opus.esd.eas.transportmanage.basic.MSCCheckmanageBC;
import com.clt.apps.opus.esd.eas.transportmanage.basic.MSCCheckmanageBCImpl;
import com.clt.apps.opus.esd.eas.transportmanage.basic.ROUTUnMatmanageBC;
import com.clt.apps.opus.esd.eas.transportmanage.basic.ROUTUnMatmanageBCImpl;
import com.clt.apps.opus.esd.eas.transportmanage.basic.SpecialSOCheckBC;
import com.clt.apps.opus.esd.eas.transportmanage.basic.SpecialSOCheckBCImpl;
import com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0003Event;
import com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0004Event;
import com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0005Event;
import com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0006Event;
import com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0008Event;
import com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0009Event;
import com.clt.apps.opus.esd.eas.transportmanage.ocpchgcolmanage.basic.OCPChgColmanageBC;
import com.clt.apps.opus.esd.eas.transportmanage.ocpchgcolmanage.basic.OCPChgColmanageBCImpl;
import com.clt.apps.opus.esd.eas.transportmanage.ocpchgcolmanage.event.EsdEas0010Event;
import com.clt.apps.opus.esd.eas.transportmanage.ocpchgcolmanage.vo.SearchOCPChgListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

public class TransportmanageSC extends ServiceCommandSupport {

	
    // Login User Information
    private SignOnUserAccount account = null;

    /**
     * EAS preceding process for biz scenario<br>
     * TransportmanageSCrelated objects creation<br>
     */
    public void doStart() {
        try {
         
            account=getSignOnUserAccount();
        } catch (Exception e) {
            log.error("TransportmanageSC Operation error" + e.toString(), e);
        }
    }

    /**
     * EAS biz scenario closing<br>
     * TransportmanageSC clearing related objects<br>
     */
    public void doEnd() {

        log.debug("TransportmanageSC End");
    }

	/**
	 *Handling Search event about Transportmanage <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {

        EventResponse eventResponse = null;
       

        if (e.getEventName().equalsIgnoreCase("EsdEas0004Event")) {

            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { 
                eventResponse = searchChAuditList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { 
                eventResponse = searchChAuditBKGList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) { //Sub-Office
    			eventResponse = searchSubOfficeList(e);
    		} 

        } else if (e.getEventName().equalsIgnoreCase("EsdEas0005Event")) {

        	if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { 
                eventResponse = searchCnlBKGCntrList(e);
            }

        } else if (e.getEventName().equalsIgnoreCase("ESD_EAS_0903Event")) {

            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchRoutUnMatBlInforDetail(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchRoutUnMatSoInforDetail(e);
            }

        } else if (e.getEventName().equalsIgnoreCase("ESD_EAS_0902Event")) {

            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchExpnAudRmk(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = multiExpnAudRmk(e);
            }

        } else if (e.getEventName().equalsIgnoreCase("EsdEas0002Event")) {
        	//Route UnMatch List
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 
                eventResponse = searchRoutUnMatList(e);
            }

        } else if (e.getEventName().equalsIgnoreCase("EsdEas0007Event")) {

            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 
                eventResponse = searchDofChgTrfList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
                eventResponse = searchEffDT(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = multiDofChgTrf(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchEUROffcd(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchDofChgDupCnt(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = verifyLocCd(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = verifyCustCd(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
                eventResponse = verifyTpSz(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
                eventResponse = verifyCurr(e);
            }

        } else if (e.getEventName().equalsIgnoreCase("EsdEas0008Event")) {

            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 
                eventResponse = searchDofChgColList(e);
            }

        } else if (e.getEventName().equalsIgnoreCase("EsdEas0009Event")) {

            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 
                eventResponse = searchDofChgColPerList(e);
            }

        } else if (e.getEventName().equalsIgnoreCase("EsdEas0006Event")) {

            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { 
                eventResponse = searchMSCList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
    			eventResponse = searchSubOfcList(e);
    		}

        } else if (e.getEventName().equalsIgnoreCase("EsdEas0003Event")) {
        	//Special S/O of Transport
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSpecialSOCheckList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOtherSOCheckList(e);
			}

        } else if (e.getEventName().equalsIgnoreCase("EsdEas0010Event")) {
        	//Special S/O of Transport
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOcpChgList(e);
			}	
			
		}else {
			eventResponse = null;
		}
        		
		return eventResponse;
	}

	/**
	 * C/H Audit 
	 * @param e 
	 * @return
	 * @throws EventException
	 */
    private EventResponse searchChAuditList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdEas0004Event event = (EsdEas0004Event)e;

        EventResponse eventResponse = null;
        
        try {
        	CHAuditTroArmanageBC command = new CHAuditTroArmanageBCImpl();
            eventResponse = command.searchChAuditList(event);
            
        } catch (EventException de) {
        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }

	/**
	 * C/H Audit Detail 
	 * @param e 
	 * @return
	 * @throws EventException
	 */
    private EventResponse searchChAuditBKGList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdEas0004Event event = (EsdEas0004Event)e;

        EventResponse eventResponse = null;
        
        try {
        	CHAuditTroArmanageBC command = new CHAuditTroArmanageBCImpl();
            eventResponse = command.searchChAuditBKGList(event);
            
        } catch (EventException de) {
        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }

	/**
	 * Expense Audit Remark 
	 * @param e 
	 * @return
	 * @throws EventException
	 */
    private EventResponse searchExpnAudRmk(Event e) throws EventException {

        EventResponse eventResponse = null;
        
        try {
        	ROUTUnMatmanageBC command = new ROUTUnMatmanageBCImpl();
            eventResponse = command.searchExpnAudRmk(e);
            
        } catch (EventException de) {
        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
	 * Expense Audit Remark Modify
	 * @param e 
	 * @return
	 * @throws EventException
	 */
    private EventResponse multiExpnAudRmk(Event e) throws EventException {

        EventResponse eventResponse = null;
        try {
        	begin();
            
        	ROUTUnMatmanageBC command = new ROUTUnMatmanageBCImpl();
            eventResponse = command.multiExpnAudRmk(e);
            
            commit();
        } catch (EventException de) {
        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
	 * Route Unmatch List Search
	 * @param e 
	 * @return
	 * @throws EventException
	 */
    private EventResponse searchRoutUnMatList(Event e) throws EventException {
 
        EventResponse eventResponse = null;
        
        try {
        	ROUTUnMatmanageBC command = new ROUTUnMatmanageBCImpl();
            eventResponse = command.searchRoutUnMatList(e);
            
        } catch (EventException de) {
        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }

	/**
	 * Drop off charge tariff list search
	 * @param e 
	 * @return
	 * @throws EventException
	 */
    private EventResponse searchDofChgTrfList(Event e) throws EventException {

        EventResponse eventResponse = null;
        
        try {
        	DOFChgTrfmanageBC command = new DOFChgTrfmanageBCImpl();
            eventResponse = command.searchDofChgTrfList(e);
            
        } catch (EventException de) {
        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
     *  Customer infotmation Effect date List Search
	 * @param e 
	 * @return
	 * @throws EventException
	 */
    private EventResponse searchEffDT(Event e) throws EventException {

        EventResponse eventResponse = null;
        
        try {
        	DOFChgTrfmanageBC command = new DOFChgTrfmanageBCImpl();
            eventResponse = command.searchEffDT(e);
            
        } catch (EventException de) {
        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
	 * Drop off charge collection Inquery List Search
	 * @param e 
	 * @return
	 * @throws EventException
	 */
    private EventResponse searchDofChgColList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdEas0008Event event = (EsdEas0008Event)e;

        EventResponse eventResponse = null;
        
        try {
        	DOFChgColInqmanageBC command = new DOFChgColInqmanageBCImpl();
            eventResponse = command.searchDofChgColList(event);
            
        } catch (EventException de) {
        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
	/**
	 *  Drop off charge collection preperence List Search
	 * @param e 
	 * @return
	 * @throws EventException
	 */
    private EventResponse searchDofChgColPerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdEas0009Event event = (EsdEas0009Event)e;
 
        EventResponse eventResponse = null;
        
        try {
        	DOFChgColPermanageBC command = new DOFChgColPermanageBCImpl();
            eventResponse = command.searchDofChgColPerList(event);
            
        } catch (EventException de) {
        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
	/**
	 * Canceled BKG Cntr List Search.
	 * @param e 
	 * @return
	 * @throws EventException
	 */
    private EventResponse searchCnlBKGCntrList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdEas0005Event event = (EsdEas0005Event)e;
        
        EventResponse eventResponse = null;

        try {
        	CnlBKGCntrmanageBC command = new CnlBKGCntrmanageBCImpl();
            eventResponse = command.searchCnlBKGCntrList(event);
            
        } catch (EventException de) {
        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
	/**
	 * Search List by Route Unmatch BL Info
	 * @param e 
	 * @return
	 * @throws EventException
	 */
    private EventResponse searchRoutUnMatBlInforDetail(Event e) throws EventException {

        EventResponse eventResponse = null;
        
        try {
        	ROUTUnMatmanageBC command = new ROUTUnMatmanageBCImpl();
            eventResponse = command.searchRoutUnMatBlInforDetail(e);
            
        } catch (EventException de) {
        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }

	/**
	 * Search List by Route Unmatch SO Info
	 * @param e 
	 * @return
	 * @throws EventException
	 */
    private EventResponse searchRoutUnMatSoInforDetail(Event e) throws EventException {

        EventResponse eventResponse = null;
        
        try {
        	ROUTUnMatmanageBC command = new ROUTUnMatmanageBCImpl();
            eventResponse = command.searchRoutUnMatSoInforDetail(e);
            
        } catch (EventException de) {
        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }

	/**
	 * MSC Amount Check List Search 
	 * @param e 
	 * @return
	 * @throws EventException
	 */
    private EventResponse searchMSCList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdEas0006Event event = (EsdEas0006Event)e;

		EventResponse eventResponse = null;
        
        try {
        	MSCCheckmanageBC command = new MSCCheckmanageBCImpl();
            eventResponse = command.searchMSCList(event);
            
        } catch (EventException de) {
        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }

	/**
	 * Special SO Search List
	 * @param e 
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchSpecialSOCheckList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdEas0003Event event = (EsdEas0003Event)e;

		EventResponse eventResponse = null;
		
		try {
			SpecialSOCheckBC command = new SpecialSOCheckBCImpl();
			eventResponse = command.searchSpecialSOCheckList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Other SO Search List
	 * @param e 
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchOtherSOCheckList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdEas0003Event event = (EsdEas0003Event)e;
		
		EventResponse eventResponse = null;
		
		try {
			SpecialSOCheckBC command = new SpecialSOCheckBCImpl();
			eventResponse = command.searchOtherSOCheckList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Function for Select Sub Office of User Office
	 * @param e 
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchSubOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdEas0004Event event = (EsdEas0004Event)e;
	
		EventResponse eventResponse = null;
		try {
			CHAuditTroArmanageBC command = new CHAuditTroArmanageBCImpl();
			eventResponse = command.searchSubOfficeList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}    

	/**
	 * Function for Select Sub Office of User Office
	 * @param e 
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchSubOfcList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdEas0006Event event = (EsdEas0006Event)e;

		EventResponse eventResponse = null;
		try {
			MSCCheckmanageBC command = new MSCCheckmanageBCImpl();
			eventResponse = command.searchSubOfcList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}   

	/**
	 * Drop Off Charge Tariff Modify , Handling for IBLSheet Event Function.
	 * @param e 
	 * @return
	 * @throws EventException
	 */
	private EventResponse multiDofChgTrf(Event e) throws EventException {
	
		
		EventResponse eventResponse = null;
		try {
			begin();
			
			DOFChgTrfmanageBC command = new DOFChgTrfmanageBCImpl();
			eventResponse = command.multiDofChgTrf(e);

			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}   

	/**
	 * Search EUR Office.
	 * @param e 
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchEUROffcd(Event e) throws EventException {

		EventResponse eventResponse = null;
		try {
			DOFChgTrfmanageBC command = new DOFChgTrfmanageBCImpl();
			eventResponse = command.searchEUROffcd(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	} 
	
	/**
	 * searchDofChgDupCnt .
	 * @param e 
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchDofChgDupCnt(Event e) throws EventException {
		
		EventResponse eventResponse = null;
		try {
			DOFChgTrfmanageBC command = new DOFChgTrfmanageBCImpl();
			eventResponse = command.searchDofChgDupCnt(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * verify LocCd .
	 * @param e 
	 * @return
	 * @throws EventException
	 */
	private EventResponse verifyLocCd(Event e) throws EventException {

		EventResponse eventResponse = null;
		try {
			DOFChgTrfmanageBC command = new DOFChgTrfmanageBCImpl();
			eventResponse = command.verifyLocCd(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	} 
	
	/**
	 * verify CustCd.
	 * @param e 
	 * @return
	 * @throws EventException
	 */
	private EventResponse verifyCustCd(Event e) throws EventException {
		
		EventResponse eventResponse = null;
		try {
			DOFChgTrfmanageBC command = new DOFChgTrfmanageBCImpl();
			eventResponse = command.verifyCustCd(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * verify TpSz .
	 * @param e 
	 * @return
	 * @throws EventException
	 */
	private EventResponse verifyTpSz(Event e) throws EventException {
		
		EventResponse eventResponse = null;
		try {
			DOFChgTrfmanageBC command = new DOFChgTrfmanageBCImpl();
			eventResponse = command.verifyTpSz(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * verify Curr .
	 * @param e 
	 * @return
	 * @throws EventException
	 */
	private EventResponse verifyCurr(Event e) throws EventException {
		
		EventResponse eventResponse = null;
		try {
			DOFChgTrfmanageBC command = new DOFChgTrfmanageBCImpl();
			eventResponse = command.verifyCurr(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	
	/**
	 * ocp charge collectio list.
	 * @param e 
	 * @return
	 * @throws EventException
	 */
	
	private EventResponse searchOcpChgList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0010Event event = (EsdEas0010Event)e;
		OCPChgColmanageBC command = new OCPChgColmanageBCImpl();

		try{
			List<SearchOCPChgListVO> list = command.searchOcpChgList(event.getSearchOCPChgListVo());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
 
}
