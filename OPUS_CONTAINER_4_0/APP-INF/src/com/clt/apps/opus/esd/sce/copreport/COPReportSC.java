/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : COPHistoryBC.java
*@FileTitle : COP History Search
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.sce.copreport;

import java.util.List;


import com.clt.apps.opus.esd.sce.bkgcopmanage.basic.BkgCopManageBC;
import com.clt.apps.opus.esd.sce.bkgcopmanage.basic.BkgCopManageBCImpl;
import com.clt.apps.opus.esd.sce.bkgcopmanage.vo.BkgCopManageVO;
import com.clt.apps.opus.esd.sce.copreport.actmappinghis.basic.ActMappingHisBC;
import com.clt.apps.opus.esd.sce.copreport.actmappinghis.basic.ActMappingHisBCImpl;
import com.clt.apps.opus.esd.sce.copreport.actmappinghis.event.EsdSce0120Event;
import com.clt.apps.opus.esd.sce.copreport.actmappinghis.vo.SearchActMappingHisVO;
import com.clt.apps.opus.esd.sce.copreport.cophsitory.basic.COPHistoryBC;
import com.clt.apps.opus.esd.sce.copreport.cophsitory.basic.COPHistoryBCImpl;
import com.clt.apps.opus.esd.sce.copreport.cophsitory.event.EsdSce0071Event;
import com.clt.apps.opus.esd.sce.copreport.cophsitory.vo.SearchCOPHistoryVO;
import com.clt.apps.opus.esd.sce.copreport.exceptionreport.basic.ExceptionReportBC;
import com.clt.apps.opus.esd.sce.copreport.exceptionreport.basic.ExceptionReportBCImpl;
import com.clt.apps.opus.esd.sce.copreport.exceptionreport.event.EsdSce0078Event;
import com.clt.apps.opus.esd.sce.copreport.manualcntrmapping.basic.ManualCntrMappBC;
import com.clt.apps.opus.esd.sce.copreport.manualcntrmapping.basic.ManualCntrMappBCImpl;
import com.clt.apps.opus.esd.sce.copreport.manualcntrmapping.event.EsdSce0115Event;
import com.clt.apps.opus.esd.sce.copreport.manualcntrmapping.vo.SearchCntrMapgListVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SceCopHdrVO;



/**
 * SCE Business Logic ServiceCommand<br>
 * - Business transactions are processed for SCE.<br>
 *
 * @author 
 * @see EsdSce001EventResponse,COPReport
 * @since J2EE 1.4
 */
public class COPReportSC extends ServiceCommandSupport {

	// Login User Information
    @SuppressWarnings("unused")
	private SignOnUserAccount account = null;

	/**
     * SCE predecessor business scenarios<br>
     * COPReport business scenarios related internal object creation during calls<br>
     */
    public void doStart() {
        try {
            // One comment -> Log in Check part
            account = getSignOnUserAccount();
        } catch (Exception e) {
            log.error("COPReportSC Error when the predecessor " + e.toString(), e);
        }
    }

    /**
     * Deadline SCE business scenarios<br>
     * At the end of business-related internal objects COPReport release scenarios<br>
     */
    public void doEnd() {
        // command.doEnd();
        log.debug("COPReportSC End");
    }

    /**
     * Perform tasks that correspond to each event scenario<br>
     * SCE events that occur in a branch of business processing<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
	public EventResponse perform(Event e) throws EventException {

		EventResponse eventResponse = null;

        // If the SC is used to handle multiple events that need to be
        // COP Inquiry Customer Name Search
        if (e.getEventName().equalsIgnoreCase("EsdSce0071Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
                eventResponse = searchCOPHistory(e);
            }
        } else if ( e.getEventName().equalsIgnoreCase("EsdSce0078Event")) {
        	if( e.getFormCommand().isCommand( FormCommand.SEARCHLIST)) {
        		eventResponse = searchFailureReport( e);
        	}
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) { //Sub-Office
        		log.debug("\n COPReportSC EventName : "+e.getEventName());
    			//eventResponse = searchSubOfficeList(e);
    		}
        } else if (e.getEventName().equalsIgnoreCase("EsdSce0115Event")) {
			// Retrieve When clicked - top the list
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				log.debug("\n SEARCH01************");
				eventResponse = searchCntrMapgList(e);
				// When you click Save - save 
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				log.debug("\n 0115 command MULTI01" );
				eventResponse = multiCntrMapg(e);
			// Click Save when - the bottom of the list
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				log.debug("\n SEARCHLIST************" );
				eventResponse = searchCopMapgList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdSce0120Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				log.debug("\n SEARCH01************");
				eventResponse = searchCntrMapgList(e);
				// When you click Save - save 
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				log.debug("\n 0115 command MULTI01" );
				eventResponse = multiCntrMapg(e);
			// Click Save when - the bottom of the list
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				log.debug("\n SEARCHLIST************" );
				eventResponse = searchActMappingHis(e);
			}
		}

        log.debug("\n SC END!!!");

    	return eventResponse;
	}
	/**
	 *  Exception Notification Failure Report will return the query results.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFailureReport(Event e) throws EventException {
		EventResponse eventResponse = null;
		EsdSce0078Event event = (EsdSce0078Event)e;
		ExceptionReportBC command = new ExceptionReportBCImpl(); 
		
		try{
			eventResponse = command.notificationFailure(event.getSearchNotifyFailureVO());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * COP History will return the query results.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCOPHistory(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsdSce0071Event event         = (EsdSce0071Event)e ;
    	List<SearchCOPHistoryVO> list = null;
 	
        try {
        	COPHistoryBC command = new COPHistoryBCImpl();
            list = command.searchCOPHistory(event.getConditionVO());
			eventResponse.setRsVoList(list);            
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        } 
        return eventResponse;
	}

    /**
     * Manual Container Mapping (the bottom of list views) 
     *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */
	private EventResponse searchCopMapgList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		EsdSce0115Event event         = (EsdSce0115Event)e;

		try {
			ManualCntrMappBC command = new ManualCntrMappBCImpl();
			List<SceCopHdrVO> list =  command.searchCopMapgList(event.getManualReplanInfoVOs());
			eventResponse.setRsVoList(list);
			
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
    /**
     * Manual Container Mapping (top of the list views) &&&
     *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */
	private EventResponse searchCntrMapgList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		EsdSce0115Event event   = (EsdSce0115Event) e;

		try {
			ManualCntrMappBC command = new ManualCntrMappBCImpl();
			List<SearchCntrMapgListVO>  list = command.searchCntrMapgList(event.getManualReplanInfoVO());
			eventResponse.setRsVoList(list);
			
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

    /**
     * Manual Container Mapping (Save-save)
     *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */
	public EventResponse multiCntrMapg(Event e) throws EventException {
		EsdSce0115Event event   = (EsdSce0115Event) e;
		//2015.04.14 Modify Critical
		//EventResponse eventResponse = null; 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			
//			ManualCntrMappBC command = new ManualCntrMappBCImpl();
			BkgCopManageVO[] vos = event.getBkgCopManageVOs();
		
			begin();			
//			command.multiCntrMapg(vos);
			BkgCopManageBC command = new BkgCopManageBCImpl();
			if(vos != null){
				for(int i=0; i<vos.length; i++){
					BkgCopManageVO bkgCopManageVO = vos[i];
					command.attachCntr(bkgCopManageVO.getBkgNo(), bkgCopManageVO.getCntrNo(), bkgCopManageVO.getFlgPartial());
				}
			}
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}
	
    /**
     * Actual Mapping History Inquiry
     *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */
	public EventResponse searchActMappingHis(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0120Event event = (EsdSce0120Event)e;
		ActMappingHisBC command = new ActMappingHisBCImpl();

        try {
			List<SearchActMappingHisVO> list = command.searchActMappingHisList(event.getSearchActMappingHisVO());
			eventResponse.setRsVoList(list);
            
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}	
}
