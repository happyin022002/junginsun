/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomerScheduleEdiSC.java
*@FileTitle : CustomerScheduleEdiSC
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esd.sce.customerscheduleedi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.esd.sce.customerscheduleedi.laneservice.basic.LaneServiceBC;
import com.clt.apps.opus.esd.sce.customerscheduleedi.laneservice.basic.LaneServiceBCImpl;
import com.clt.apps.opus.esd.sce.customerscheduleedi.laneservice.event.EsdSce0122Event;
import com.clt.apps.opus.esd.sce.customerscheduleedi.laneservice.vo.SearchGetPartnerVO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.laneservice.vo.SearchLaneServiceVO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.basic.PortPairExceptionBC;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.basic.PortPairExceptionBCImpl;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.event.EsdSce0123Event;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.event.EsdSce0124Event;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.event.EsdSce0125Event;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.vo.AdjustmentVO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.vo.BlockLaneVO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.vo.CustomerVO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.vo.ExceptionalRouteVO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.vo.RouteForBLVO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairroute.basic.PortPairRouteBC;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairroute.basic.PortPairRouteBCImpl;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairroute.event.EsdSce0120Event;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairroute.event.EsdSce0121Event;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairroute.vo.PortPairRouteConditionVO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairroute.vo.PortPairRouteDetailVO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairroute.vo.PortPairRouteMstVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * SCE VisibilityManage Business Logic ServiceCommand<br>
 * - SCE에 VisibilityManage handling business transaction.<br>
 * @param 
 * @author
 * @see VisibilityManageEvent, VisibilityManageEventResponse
 * @since J2EE 1.4
 */
public class CustomerScheduleEdiSC extends ServiceCommandSupport {
	private SignOnUserAccount account = null;

	/**
	 * SCE preceding process for biz scenario<br>
	 * ExceptionManage related objects creation<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {  
			log.error("error ExceptionManageSC related objects creation " + e.toString(), e);
		}
	}

	/**
	 * SCE biz scenario closing<br>
	 * ExceptionManage clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("ExceptionManageSC closing");
	}

	/**
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;
		
		if (e.getEventName().equalsIgnoreCase("EsdSce0120Event")) {
			   if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				   eventResponse = searchPortPairMasters(e);
			   }
			   else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				   eventResponse = searchPartnerName(e);
			   }
			   else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				   eventResponse = modifyPortPairMaster(e);
			   }
			   else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				   eventResponse = insertPartnerCode(e);
			   }
			   
		}
		else if (e.getEventName().equalsIgnoreCase("EsdSce0121Event")) {
			   if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				   eventResponse = searchPortPairDetails(e);
			   }
			   else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				   eventResponse = searchPartnerName(e);
			   }
			   else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				   eventResponse = modifyPortPairDetail(e);
			   }
		}
		else if (e.getEventName().equalsIgnoreCase("EsdSce0122Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCustomerName(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 
				eventResponse = searchLaneServiceList(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageLaneService(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsdSce0123Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 
				eventResponse = searchRouteListForAdjustment(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { 
				eventResponse = searchRouteListForBlockLane(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageAdjustment(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsdSce0124Event")) {
		   if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
			    eventResponse = searchBlockLaneList(e);
		   }
		   else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
			    eventResponse = manageBlockLane(e);
		   }			
			else{
				eventResponse = searchLaneCombo(e);	
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdSce0125Event")) {
			   if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				   eventResponse = searchExceptionalRouteList(e);
			   }
			   else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				   eventResponse = searchCustomerName(e);
			   }
			   else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				   eventResponse = manageExceptionRoute(e);
			   }
			   else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				   eventResponse = insertPartnerCode(e);
			   }
		}	   
		return eventResponse;
	}
	
    /**
     * retrieving TP Name <br>
     * @param e 
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCustomerName(Event e) throws EventException {
        EsdSce0122Event event = (EsdSce0122Event)e ;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        LaneServiceBC command = new LaneServiceBCImpl();
        String partnerId = event.getString("cust_trd_prnr_id");
        try {
        	List<SearchGetPartnerVO> list = command.searchCustomerInfo(partnerId);
            String custTrdPrnrId = "";	String custTrdPrnrNm = "";	String ediSvcTpNm = "";
            //2015.04.14 Modify Critical
            //if(!partnerId.equals(null)){
        	if(!StringUtils.isBlank(partnerId)){
        		Iterator<SearchGetPartnerVO> iter = list.iterator(); 
        		SearchGetPartnerVO getPartnerVO = new SearchGetPartnerVO();
        		
        		while(iter.hasNext()){
        			getPartnerVO = (SearchGetPartnerVO)iter.next();
        			custTrdPrnrId = getPartnerVO.getCustTrdPrnrId();
        			custTrdPrnrNm = getPartnerVO.getCustTrdPrnrNm();
        			ediSvcTpNm	  =	getPartnerVO.getEdiSvcTpNm();
        			
        			break;
        		}
        	}
        	//2015.04.14 Modify Critical
    		//if(!custTrdPrnrNm.equals(null)){
    		if(!StringUtils.isBlank(custTrdPrnrNm)){
    			eventResponse.setETCData("partnerName", custTrdPrnrNm);
    		}else{
    			eventResponse.setETCData("partnerName", "");
    		}
        	//2015.04.14 Modify Critical
    		//if(!custTrdPrnrId.equals(null)){
    		if(!StringUtils.isBlank(custTrdPrnrId)){
    			eventResponse.setETCData("custTrdPrnrId", custTrdPrnrId);
    			eventResponse.setETCData("ediSvcTpNm", ediSvcTpNm);
    		}else{
    			eventResponse.setETCData("custTrdPrnrId", "");
    			eventResponse.setETCData("ediSvcTpNm", "");
    		}
        	

        } catch (EventException de) {
			rollback();        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
     * retrieving Port Pair Master<br>
     * @param e 
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchLaneServiceList(Event e) throws EventException {
        EsdSce0122Event event = (EsdSce0122Event)e ;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        LaneServiceBC command = new LaneServiceBCImpl();
        String partnerId = event.getString("cust_trd_prnr_id");
        try {
        	List<SearchLaneServiceVO> list = command.searchLaneServiceList(partnerId);
        	eventResponse.setRsVoList(list);
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
     * setting Port Pair Detail<br>
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageLaneService(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsdSce0122Event event = (EsdSce0122Event)e ;
    	LaneServiceBC command = new LaneServiceBCImpl();
        try {
        	SearchLaneServiceVO[] portPairRVOs = event.getSearchLaneServiceVOs();
        	
			if(portPairRVOs!=null && portPairRVOs.length!=0){
				begin();
				command.manageLaneService(portPairRVOs, account);
				commit();
			}
			//eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
        } catch (EventException de) {
			rollback();        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
	/**
	 * ESD_SCE_0123<br>
	 * @param e 
	 * @return EventResponse
	 * @exception EventException
	 */ 
    private EventResponse manageAdjustment(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsdSce0123Event event = (EsdSce0123Event)e ;
    	PortPairExceptionBC command = new PortPairExceptionBCImpl();
        try {
        	AdjustmentVO[] adjustmentVOs = event.getAdjustmentVOs(); 
        	
			if(adjustmentVOs!=null && adjustmentVOs.length!=0){
				begin();
				command.manageAdjustment(adjustmentVOs, account);
				commit();
			}
			
        } catch (EventException de) {
			rollback();        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
     * retrieving Port Pair Detail <br>
     * @param e 
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRouteListForAdjustment(Event e) throws EventException {
		EsdSce0123Event event = (EsdSce0123Event) e;
		AdjustmentVO vo = event.getAdjustmentVO();

		PortPairExceptionBC command = new PortPairExceptionBCImpl();
		List<AdjustmentVO> list = command.searchRouteListForAdjustment(vo);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
    	 
    }
    
	/**
	 * retrieving BlockLane List<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchRouteListForBlockLane(Event e) throws EventException {
		EsdSce0123Event event = (EsdSce0123Event) e;
		RouteForBLVO vo = event.getRouteForBLVO();

		PortPairExceptionBC command = new PortPairExceptionBCImpl();
		List<RouteForBLVO> list = command.searchRouteListForBlockLane(vo);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
    	 
    }
    
	 /**
	  * ESD_SCE_124 : retrieving list<br>
	  * @param Event e
	  * @return EventResponse
	  * @exception EventException
	  */
	 private EventResponse searchBlockLaneList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdSce0124Event event = (EsdSce0124Event) e;
		BlockLaneVO vo = event.getBlockLaneVO();

		PortPairExceptionBC command = new PortPairExceptionBCImpl();
		List<BlockLaneVO> list = command.searchBlockLaneList(vo);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	 }
	 
	 /**
	  * ESD_SCE_124 : CUS<br>
	  * @param Event e
	  * @return EventResponse
	  * @exception EventException
	  */
	 private EventResponse manageBlockLane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdSce0124Event event = (EsdSce0124Event) e;
		BlockLaneVO[] vos = event.getBlockLaneVOs();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		PortPairExceptionBC command = new PortPairExceptionBCImpl();

		try {
			begin();
			command.manageBlockLane(vos, account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		}
		return eventResponse;
	 }
	 
	/**
	 * ESD_SCE_124
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchLaneCombo(Event e) throws EventException {
		PortPairExceptionBC command = new PortPairExceptionBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		CustomerVO customerVO = new CustomerVO();	//

		//retrieving Lane Code
		 List<CustomerVO> list = command.searchLaneCombo(customerVO);
		
		Iterator<CustomerVO> iterator = (Iterator<CustomerVO>) list.iterator();

		String rlaneComboList = "";
		String rlaneNmComboList = "";
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		while(iterator.hasNext()){
			customerVO = (CustomerVO)iterator.next();
			sb1.append(customerVO.getCode()+"|");
			sb2.append(customerVO.getName()+"|");
		}
		
		rlaneComboList = sb1.toString();
		rlaneNmComboList = sb2.toString();
		
		if (rlaneComboList.length() > 0){
			rlaneComboList = rlaneComboList.substring(0,rlaneComboList.length()-1);
			rlaneNmComboList = rlaneNmComboList.substring(0,rlaneNmComboList.length()-1);;
		}

		eventResponse.setETCData("rlaneSheetList", rlaneComboList);
		eventResponse.setETCData("rlaneNmSheetList", rlaneNmComboList);
		return eventResponse;
	}
	
	/**
	 * retrieving Port Pair Detail<br>
	 * @param e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExceptionalRouteList(Event e) throws EventException {
	    EsdSce0125Event event = (EsdSce0125Event)e ;
	    GeneralEventResponse eventResponse = new GeneralEventResponse();
	    PortPairExceptionBC command = new PortPairExceptionBCImpl();
	    try {
	    	List<ExceptionalRouteVO> list = command.searchExceptionalRouteList(event.getExceptionalRouteVO());
	    	eventResponse.setRsVoList(list);
	    } catch (EventException de) {
	        log.error("err " + de.toString(), de);
	        throw new EventException(de.getMessage());
	    }
	    return eventResponse;
	}
	
	/**
	 * ESD_SCE_0125 <br>
	 * @param e 
	 * @return EventResponse
	 * @exception EventException
	 */ 
	private EventResponse manageExceptionRoute(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0125Event event = (EsdSce0125Event)e ;
		PortPairExceptionBC command = new PortPairExceptionBCImpl();
	    try {
	    	ExceptionalRouteVO[] exceptionalRouteVOs = event.getExceptionalRouteVOs(); 
	    	
			if(exceptionalRouteVOs!=null && exceptionalRouteVOs.length!=0){
				begin();
				command.manageExceptionRoute(exceptionalRouteVOs, account);
				commit();
			}
			//eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
	    } catch (EventException de) {
	    	rollback();        	
	        log.error("err " + de.toString(), de);
	        throw new EventException(de.getMessage());
	    }
	    return eventResponse;
	}

	/**
     * retrieving Port Pair Master<br>
     * @param e 
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchPartnerName(Event e) throws EventException {
        EsdSce0120Event event = (EsdSce0120Event)e ;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PortPairRouteBC command = new PortPairRouteBCImpl();
        try {
        	String ret = command.searchPartnerName(event.getPartnerId());
        	eventResponse.setETCData("partner_name", ret);
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
	/**
     * retrieving Port Pair Master<br>
     * @param Event e 
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchPortPairMasters(Event e) throws EventException {
        EsdSce0120Event event = (EsdSce0120Event)e ;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PortPairRouteBC command = new PortPairRouteBCImpl();
        try {
        	List<PortPairRouteMstVO> list = command.searchPortPairMasters(event.getPortPairRouteConditionVO());
        	eventResponse.setRsVoList(list);
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
     * retrieving Port Pair Detail<br>
     * @param Event e 
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchPortPairDetails(Event e) throws EventException {
        EsdSce0121Event event = (EsdSce0121Event)e ;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PortPairRouteBC command = new PortPairRouteBCImpl();
        try {
        	List<PortPairRouteDetailVO> list = command.searchPortPairDetails(event.getPortPairRouteConditionVO());
        	eventResponse.setRsVoList(list);
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
     * registering Partner.<br>
     * @param Event e 
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse insertPartnerCode(Event e) throws EventException {
    	PortPairRouteConditionVO portPairRouteConditionVO = null;
		if (e.getEventName().equalsIgnoreCase("EsdSce0120Event")) {
			EsdSce0120Event event = (EsdSce0120Event) e;
			portPairRouteConditionVO = event.getPortPairRouteConditionVO();
		} else {
			EsdSce0125Event event = (EsdSce0125Event) e;
			portPairRouteConditionVO = event.getPortPairRouteConditionVO();
		}
    	
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PortPairRouteBC command = new PortPairRouteBCImpl();
        try {
        	if (!command.searchPartnerName(portPairRouteConditionVO.getPartnerId()).equals("")){
        		throw new EventException(new ErrorHandler("This Partner ID already existed.").getMessage());	
        	}
        	begin();
        	command.insertPartnerCode(portPairRouteConditionVO);
        	commit();
        } catch (EventException de) {
        	rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
     * managing PortPairMaster Info.<br>
     * @param Event e 
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse modifyPortPairMaster(Event e) throws EventException {
        EsdSce0120Event event = (EsdSce0120Event)e ;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PortPairRouteBC command = new PortPairRouteBCImpl();
        Collection<PortPairRouteMstVO> allMasters = new ArrayList<PortPairRouteMstVO>();
        Collection<PortPairRouteMstVO> noUseMasters = new ArrayList<PortPairRouteMstVO>();
//	        Collection<PortPairRouteDetailVO> noUseDetails = new ArrayList<PortPairRouteDetailVO>();
        
        try {
        	PortPairRouteConditionVO condition = event.getPortPairRouteConditionVO();
        	PortPairRouteMstVO[] mstVOs = event.getPortPairRouteMstVOs();
        	
        	for (int i=0; i<mstVOs.length; i++) {
        		if (mstVOs[i].getIbflag().equals("I")){	// if add Port Pair
        			
        			// mandatory condition(POL, POD)
        			// POR is not existing POL, DEL is not existing POD
        			if (mstVOs[i].getPorCd() == null || mstVOs[i].getPorCd().equals("")){
        				mstVOs[i].setPorCd(mstVOs[i].getPolCd());
        			}
        			
        			if (mstVOs[i].getDelCd() == null || mstVOs[i].getDelCd().equals("")){
        				mstVOs[i].setDelCd(mstVOs[i].getPodCd());
        			}
        			
        			DBRowSet dbRowset=command.searchPortPairMaster(mstVOs[i]);
        			
        			//checking duplication
        			if(dbRowset.getRowCount()>0){	// if that be duplicated..
        				throw new EventException(new ErrorHandler("PRD00051").getMessage());	
        			}
        		} else if (mstVOs[i].getIbflag().equals("U")){	// modify Port Pair
        			if(mstVOs[i].getUseFlg().equals("N")){	// if no use
        				noUseMasters.add(mstVOs[i]);
//	        				noUseDetails.addAll(command.searchPortPairDetails(mstVOs[i]));
        			}
        		}	
        		allMasters.add(mstVOs[i]);
        		
        	}
        	
        	begin();
        	// Masters will be Added Or Modified.
        	if ( allMasters.size  () > 0 )	command.modifyPortPairMaster(condition, (PortPairRouteMstVO[])allMasters.toArray(new PortPairRouteMstVO[0]));
        	// Details of Useless Master will be Added Or Modified.
        	if ( noUseMasters.size() > 0 )	command.modifyPortPairDetail(condition, (PortPairRouteMstVO[])noUseMasters.toArray(new PortPairRouteMstVO[0]));
        	// send Useless Port Pair Route to EDI I/F.
//	        	if ( noUseDetails.size() > 0 )	command.addPortPairRouteIF	(condition, noUseDetails);
        	commit();
        	
        } catch (EventException de) {
        	rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        } catch (Exception ae) {
        	log.error("err " + ae.toString(), ae);
	        throw new EventException(ae.getMessage());
        }
        return eventResponse;
    }
    
    /**
     * managing PortPairMaster Info.<br>
     * @param Event e 
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse modifyPortPairDetail(Event e) throws EventException {
        EsdSce0121Event event = (EsdSce0121Event)e ;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PortPairRouteBC command = new PortPairRouteBCImpl();
        Collection<PortPairRouteDetailVO> allDetails = new ArrayList<PortPairRouteDetailVO>();
        
        try {
        	PortPairRouteConditionVO condition = event.getPortPairRouteConditionVO();
        	PortPairRouteDetailVO[] detailVOs = event.getPortPairRouteDetailVOs();
        	
        	for (int i=0; i<detailVOs.length; i++) {
        		if (detailVOs[i].getIbflag().equals("I")){	// add Port Pair
        			detailVOs[i].setCustTrdPrnrId(condition.getPartnerId());
        			
        			//setting location to first pol_cd and last pod_cd
        			if (detailVOs[i].getPorCd()==null || detailVOs[i].getPorCd().length() == 0){
        				detailVOs[i].setPorCd(detailVOs[i].getPolCd());
        			}
        			if (detailVOs[i].getDelCd()==null || detailVOs[i].getDelCd().length() == 0){
        				detailVOs[i].setDelCd(detailVOs[i].getPodCd());
        			}
        			detailVOs[i].setN1stPolCd(detailVOs[i].getPolCd());
        			
        			if ( (detailVOs[i].getN2ndPolCd()==null || detailVOs[i].getN2ndPolCd().length() == 0) &&
        				 (detailVOs[i].getN3rdPolCd()==null || detailVOs[i].getN3rdPolCd().length() == 0) &&
        				 (detailVOs[i].getN4thPolCd()==null || detailVOs[i].getN4thPolCd().length() == 0) ){
        				detailVOs[i].setN1stPodCd(detailVOs[i].getPodCd());
        			}
        			
        			
        			if ( (detailVOs[i].getN2ndPolCd()!=null && detailVOs[i].getN2ndPolCd().length() > 0) &&
	        			 (detailVOs[i].getN3rdPolCd()==null || detailVOs[i].getN3rdPolCd().length() == 0) &&
	        			 (detailVOs[i].getN4thPolCd()==null || detailVOs[i].getN4thPolCd().length() == 0) ){
	        				detailVOs[i].setN2ndPodCd(detailVOs[i].getPodCd());
	        				detailVOs[i].setN1stPodCd(detailVOs[i].getN2ndPolCd());
	        		}
        			
        			
        			if ( (detailVOs[i].getN2ndPolCd()!=null && detailVOs[i].getN2ndPolCd().length() > 0) &&
		        		 (detailVOs[i].getN3rdPolCd()!=null && detailVOs[i].getN3rdPolCd().length() > 0) &&
		        		 (detailVOs[i].getN4thPolCd()==null || detailVOs[i].getN4thPolCd().length() == 0) ){
		        				detailVOs[i].setN3rdPodCd(detailVOs[i].getPodCd());
		        				detailVOs[i].setN1stPodCd(detailVOs[i].getN2ndPolCd());
		        				detailVOs[i].setN2ndPodCd(detailVOs[i].getN3rdPolCd());
        			}
        			
        			
        			if ( (detailVOs[i].getN2ndPolCd()!=null && detailVOs[i].getN2ndPolCd().length() > 0) &&
			        	 (detailVOs[i].getN3rdPolCd()!=null && detailVOs[i].getN3rdPolCd().length() > 0) &&
			        	 (detailVOs[i].getN4thPolCd()!=null && detailVOs[i].getN4thPolCd().length() > 0) ){
			        				detailVOs[i].setN3rdPodCd(detailVOs[i].getPodCd());
			        				detailVOs[i].setN1stPodCd(detailVOs[i].getN2ndPolCd());
			        				detailVOs[i].setN2ndPodCd(detailVOs[i].getN3rdPolCd());
			        				detailVOs[i].setN3rdPodCd(detailVOs[i].getN4thPolCd());
	        		}
        			
        			
        			//checking duplication at master
        			DBRowSet dbRowset=command.searchPortPairMaster(detailVOs[i]);
        			if(dbRowset.getRowCount()<1){	// if had no master.
        				throw new DAOException(new ErrorHandler("PRD00018").getMessage());
        			}
        			
        			//checking duplication
        			if(command.hasSameRoute(detailVOs[i])){	// has same route? 
        				throw new EventException(new ErrorHandler("PRD00051").getMessage());	
        			}
        			
        			detailVOs[i].setRoutRcvDt( command.getCurrentDate  () );
        			detailVOs[i].setRoutSeq  ( command.getNextRouteSeq () );
        			detailVOs[i].setMnlUseFlg( "Y" );
        			
        		} else if (detailVOs[i].getIbflag().equals("D")){	// no use.
        			detailVOs[i].setMnlUseFlg( "N" );
        		}	
        		
        		allDetails.add(detailVOs[i]);
        		
        	}
        	
        	// Details of Useless Port Pair Route Master will be Added Or Modified.
        	if ( allDetails.size() > 0 )	{
        		begin();
        		command.modifyPortPairDetail( condition, (PortPairRouteDetailVO[])allDetails.toArray(new PortPairRouteDetailVO[0]));
        		commit();
        	}
        	
        } catch (EventException de) {
        	rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        } catch (Exception ae) {
        	log.error("err " + ae.toString(), ae);
	        throw new EventException(ae.getMessage());
        }
        return eventResponse;
    }
	    
}