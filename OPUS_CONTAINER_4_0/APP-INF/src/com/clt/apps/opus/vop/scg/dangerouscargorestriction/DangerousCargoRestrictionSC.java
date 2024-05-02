/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DangerousCargoRestrictionSC.java
*@FileTitle : DG Restriction by Port (Creation)
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.scg.dangerouscargorestriction;

import java.util.List;

import com.clt.apps.opus.vop.scg.dangerouscargorestriction.carrierrestriction.basic.CarrierRestrictionBC;
import com.clt.apps.opus.vop.scg.dangerouscargorestriction.carrierrestriction.basic.CarrierRestrictionBCImpl;
import com.clt.apps.opus.vop.scg.dangerouscargorestriction.carrierrestriction.event.VopScg0009Event;
import com.clt.apps.opus.vop.scg.dangerouscargorestriction.carrierrestriction.vo.CarrierRestrictionOptionVO;
import com.clt.apps.opus.vop.scg.dangerouscargorestriction.carrierrestriction.vo.CarrierRestrictionVO;
import com.clt.apps.opus.vop.scg.dangerouscargorestriction.carrierrestriction.vo.PortRestrictionOptionVO;
import com.clt.apps.opus.vop.scg.dangerouscargorestriction.carrierrestriction.vo.ScgImdgCrrRstrVO;
import com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.basic.PortRestrictionBC;
import com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.basic.PortRestrictionBCImpl;
import com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.event.VopScg0005Event;
import com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.event.VopScg0011Event;
import com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.event.VopScg0076Event;
import com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.event.VopScg1005Event;
import com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.integration.PortRestrictionDBDAO;
import com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.vo.PortRestrictionDtlVO;
import com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.vo.PortRestrictionVO;
import com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.vo.PortRestrictonOptionVO;
import com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.basic.SCGExternalFinderBC;
import com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.basic.SCGExternalFinderBCImpl;
import com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.basic.SCGInternalFinderBC;
import com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.basic.SCGInternalFinderBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ScgImdgClssCdVO;


/**
 * OPUS-DangerousCargoRestriction Business Logic ServiceCommand - Handling business transactions of OPUS-DangerousCargoRestriction.
 * 
 * @author
 * @see PortRestrictionDBDAO
 * @since J2EE 1.6
 */

public class DangerousCargoRestrictionSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * DangerousCargoRestriction system preceding process for biz scenario<br>
	 * VOP_SCG_0005 related objects creation<br>
	 */
	public void doStart() {
		log.debug("DangerousCargoRestrictionSC start");
		try {
			// comment --> login check
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * DangerousCargoRestriction system biz scenario closing<br>
	 * VOP_SCG_0005 clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("DangerousCargoRestrictionSC end");
	}

	/**
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
	    try{
    		EventResponse eventResponse = null;
    
    		// When SC handles multiple events
    		if (e.getEventName().equalsIgnoreCase("VopScg0005Event")) {
    			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
    				eventResponse = searchPortRestriction(e  );
    			}	
    			/**
    			 * Save Button process
    			 */						
    			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
    				eventResponse = managePortRestriction(e);
    			}
    			/** 
    			 * Delete Button process
    			 */			
    			if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
    				eventResponse = removePortRestriction(e);
    			}
     	
     
    		}
    		if (e.getEventName().equalsIgnoreCase("VopScg1005Event")) {
     
    			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
    				eventResponse =  managePortRestrictionSaveAs(e );
    			}			
    		}
     
    		/**
    		 * VSL OPR's Restriction on DG (Creation)
    		 * 
    		 */
    		if (e.getEventName().equalsIgnoreCase("VopScg0009Event")) {
    			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
    				eventResponse = searchCarrierRestriction(e );
    			}
    			/********************** Initializing Combo Code etc. **************************************/
    			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
    				eventResponse = searchCompGrpUNClassComeCode(e );
    			}		
     			
    			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
    				eventResponse = manageCarrierRestriction(e );
    			}
    		} 
    		/**
    		 * Port & VSL OPR’s Restriction En-route main retrieve
    		 * 
    		 */
    		if (e.getEventName().equalsIgnoreCase("VopScg0011Event")) {
    			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
    				eventResponse = searchPortCarrierEnRouteList(e );
    			}
    			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
    				eventResponse = searchPortRotnSeq(e );
    			}
    		} 		
            /**
             * DG Prohibition Summary by Port
             * 
             */
            if (e.getEventName().equalsIgnoreCase("VopScg0076Event")) {
                if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                    eventResponse = searchPortRestrictionSummary(e );
                }
            } 
    		
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }    		
	}
	/**
	 * SCG_0005 : Save process <br>
	 * PortRestriction Restriction info all save <br>
	 * 
	 * @param     Event e
	 * @return    EventResponse response
	 * @exception EventException
	 */
	private EventResponse managePortRestriction(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0005Event event = (VopScg0005Event)e;
		PortRestrictionBC command = new PortRestrictionBCImpl();
		try{
			begin();
			
			command.removePortRestriction(  event.getVopScg004ContainVO().getCondition() );			
			String sImdgPortRstrSeq = command.managePortRestriction(  event.getVopScg004ContainVO() , account);
			String msg = new ErrorHandler("SCG00001", new String[]{"Data"} ).getUserMessage();
 		
			eventResponse.setETCData("NEW_IMDG_PORT_RSTR_SEQ", sImdgPortRstrSeq);				
			eventResponse.setUserMessage( msg ); 
 
			commit();
 
			return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Restriction"}).getMessage(), ex);
        }

	}
	/**
	 * VOP_SCG_1005 : SAVE <br>
	 * PortRestriction Save As process<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse managePortRestrictionSaveAs(Event e ) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg1005Event event = (VopScg1005Event)e;
		PortRestrictionBC command = new PortRestrictionBCImpl();
		try{
			begin();
			int rslt = command.managePortRestrictionSaveAs( event.getCondition(), event.getSearchScgImdgPortRstrVOs() , account); 
			
			String msg = "";
			if (rslt == -1) {
				msg = new ErrorHandler("SCG00001", new String[]{"Data"} ).getUserMessage();	
			}else{
				msg = new ErrorHandler("SCG50033", new String[]{"Data"} ).getUserMessage();					
			}
			eventResponse.setUserMessage(msg);
			
			eventResponse.setETCData("row", Integer.toString(rslt));
			
			commit();
 
			return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Restriction Save As"}).getMessage(), ex);
        }
		
	}	
	/**
	 * VOP_SCG_0005 : Delete<br>
	 * Port Restriction delete<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse response 
	 * @exception EventException
	 */
	private EventResponse removePortRestriction(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0005Event event = (VopScg0005Event)e;
		PortRestrictionBC command = new PortRestrictionBCImpl();
		try{
			begin();
			command.removePortRestriction(event.getVopScg004ContainVO().getCondition() );
            String msg = new ErrorHandler("SCG00006", new String[]{"Data"} ).getUserMessage();
 
			eventResponse.setUserMessage(msg);
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Restriction"}).getMessage(), ex);
        }

		return eventResponse;
	}
 
    /**
     * 
     * VOP_SCG-0005 : Retrieve <br>
     * Port Restriction retrieve process <br>
     *
     * @author
     * @category searchPortRestriction
     * @param  Event e
     * @return EventResponse
     * @throws EventException
     */
	private EventResponse  searchPortRestriction(Event e  )  throws EventException{
	    try{
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		VopScg0005Event event = (  VopScg0005Event)e;
     
    		PortRestrictionBC command = new PortRestrictionBCImpl();
    		PortRestrictonOptionVO portRestrictonOptionVO = event.getVopScg004ContainVO().getCondition();	
    		String optClass = (String)e.getAttribute("optClass");		
    		List<PortRestrictionVO> list = null;
    		String msg = "";
    		/*******************class retrieve************************/
    		if(optClass.equals("class")){
    		    portRestrictonOptionVO.setImdgUnNo("");
    		    portRestrictonOptionVO.setImdgUnNoSeq("");			
    			list = command.searchPortRestriction( portRestrictonOptionVO );
    			if(list.size() == 0){
    			    msg = new ErrorHandler("SCG00034").getUserMessage();
    			}
    		}else if(optClass.equals("unno")){
    			/*******************Un No retrieve**************************************************
    			 * 1. When retrieved by Un No instead of Class, 
    			 *    1) In case there's no data, find matching Class Code and retrieve by Class Code.
    			 * 	 
    			 * ※ SCG00034 : No data found !  Do you want to insert new data ?
    			 *               UnNo retrieve ->Get  Class Code -> Class Code retrieve
    			 *                 [if rs.size == 0 ],
    			 * ※ SCG00035 : This UN No./Seq. restriction is based on Class restriction.
    			 *               UnNo retrieve ->Get Class Code  -> Class Code retrieve
    			 *                 [if rs.size > 0 ],
    			 ***********************************************************************************/
    		    portRestrictonOptionVO.setImdgClssCd("");	
    			list = command.searchPortRestriction( portRestrictonOptionVO );
    			String[] classcd = command.getImdgClssCd(  portRestrictonOptionVO.getImdgUnNo(), portRestrictonOptionVO.getImdgUnNoSeq() );
    			eventResponse.setETCData("imdg_clss_cd"     , classcd [0] );				
    			eventResponse.setETCData("imdg_clss_cd_desc", classcd [1] );
                eventResponse.setETCData("NO_DATA_MSG"      , "" );
    			if( list.size() == 0){
    
    				if( classcd[0].equals("") ){
    					eventResponse.setETCData("NO_DATA_MSG", "NO_DATA" );	 
    					msg = new ErrorHandler("SCG00034").getUserMessage();		
    					eventResponse.setUserMessage(msg);
    					return eventResponse;	
    				}else{
    					/*******************In case data doesn't exist when retrieved by Un No, extract CLASSCD in UNNO table**************/
    				    portRestrictonOptionVO.setImdgClssCd( classcd [0] );
    				    portRestrictonOptionVO.setImdgUnNo("");
    				    portRestrictonOptionVO.setImdgUnNoSeq("");						
    					list = command.searchPortRestriction( portRestrictonOptionVO );
    					eventResponse.setETCData("imdg_clss_cd"     , classcd [0] );				
    					eventResponse.setETCData("imdg_clss_cd_desc", classcd [1] );
    					
    					if( list.size() > 0){
    						eventResponse.setETCData("NO_DATA_MSG", "USE_UNNO" );
    						msg = new ErrorHandler("SCG00035").getUserMessage();		
    						eventResponse.setUserMessage(msg);						
    					}else{
    						eventResponse.setETCData("NO_DATA_MSG", "NO_DATA" );	
    						msg = new ErrorHandler("SCG00034").getUserMessage();		
    						eventResponse.setUserMessage(msg);
    						return eventResponse;	
    					}
    				}
    			}
    		}		
     
     
    		String sImdgPortRstrSeq = "";
    		if(list != null){
        		if ( list.size()!=0 ) {
        			sImdgPortRstrSeq = list.get(0).getImdgPortRstrSeq();
        		}    			
    		}
    		portRestrictonOptionVO.setImdgPortRstrSeq( sImdgPortRstrSeq  );
    
    		
    		if( msg.equals("") ){
    			msg = "NO_DATA";
    		}
    		
    		if(list != null){
        		if( list.size() == 0 ){
        			eventResponse.setUserMessage(msg);
        			return eventResponse;	
        		}	    			
    		}
	
    		List<PortRestrictionDtlVO> list2 = command.searchPortRestrictionDetail( portRestrictonOptionVO );		
    		if(list != null){
    			eventResponse.setRsVoList( list );	
    		}
    		eventResponse.setRsVoList( list2 );
    		eventResponse.setRsVoList( list2 );
    		eventResponse.setRsVoList( list2 );
    		eventResponse.setRsVoList( list2 );		
    		return eventResponse;		
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Restriction"}).getMessage(), ex);
        }
		
	}
 
	/**
	 * VOP_SCG-0009: Retrieve <br>
	 * Carrier Retriection retrieve<br>
	 * 
	 * @param ScgImdgClssCdListVO   scgImdgClssCdListVO
	 * @return List<ScgImdgClssCdListVO>
	 * @exception EventException
	 */
	private EventResponse  searchCarrierRestriction(Event e)  throws EventException{
	    try{
    		GeneralEventResponse eventResponse      = new GeneralEventResponse();
    		VopScg0009Event event                   = (VopScg0009Event)e;
    		CarrierRestrictionBC command            = new CarrierRestrictionBCImpl();
     
    		 List<CarrierRestrictionVO>  list = null;
     
    		CarrierRestrictionOptionVO  cont = event.getContainer();
     
    		list = command.searchCarrierRestriction( cont );		
    		eventResponse.setRsVoList( list );
     
            if( cont.getMsgCode()== "COM10001" ){   
    			eventResponse.setUserMessage( new ErrorHandler( cont.getMsgCode(),new String[]{""} ).getUserMessage()  );            	
            }
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Carrier Restriction"}).getMessage(), ex);
        }
	}	
	/**
	 * VOP_SCG_0009 : OPEN
	 * Group UNClass retrieving for MultiCombo basic setting in case carrier restriction opens.
	 * @param  Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCompGrpUNClassComeCode(Event e) throws EventException {
	    try{
    		VopScg0009Event event = (VopScg0009Event)e;		
 
    		SCGInternalFinderBC command2 = new SCGInternalFinderBCImpl();
            SCGExternalFinderBC command = new SCGExternalFinderBCImpl();    		
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    
    		List<ScgImdgClssCdVO> list2 = command2.searchUNClass();
    		eventResponse.setRsVoList(list2);
            String exceptKey = event.getExceptKey();
            String codeinfo = command.getCodeSelect(event.getAttribute("code").toString(), 0, exceptKey );

    		eventResponse.setETCData("codeinfo",  codeinfo);
    		
    	    exceptKey="";
    	    String codeinfoAll =  command.getCodeSelect(event.getAttribute("code").toString(), 0, exceptKey );

            eventResponse.setETCData("codeinfoAll", codeinfoAll);		
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Comp Group UNClass"}).getMessage(), ex);
        }
	}
	/**
	 * VOP_SCG_0009: SAVE <br>
	 * Carrier Restiction save
	 *  
	 * @param     Event e 
	 * @return    EventResponse response
	 * @exception EventException
	 */
	private EventResponse manageCarrierRestriction(Event e ) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0009Event event = (VopScg0009Event)e;
		CarrierRestrictionBC command = new CarrierRestrictionBCImpl();
		CarrierRestrictionOptionVO  cont = null;
 
		try{
			begin();
			    cont = event.getContainer();
				command.manageCarrierRestriction(   cont , account);
				if( cont.getMsgCode() != null && cont.getMsgCode() != ""){
					if( cont.getMsgCode().equals( "SCG50005") ){
					   eventResponse.setUserMessage(new ErrorHandler("SCG50005",new String[]{"Data"}).getUserMessage() );
					}
				}else{ 
		            String msg = new ErrorHandler("SCG00001", new String[]{"Data"} ).getUserMessage();
		            eventResponse.setUserMessage( msg );
					eventResponse.setRsVoList(cont.getList());					
				}

 			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Carrier Restriction"}).getMessage(), ex);
        }
		return eventResponse;
	}
 
 
	/**
	 * 
     * VOP_SCG_0011 : Retrieve 
     * Port & VSL OPR’s Restriction En-route retrieve<br>
     * 
	 * @param  Event e
	 * @throws EventException
	 * @return EventResponse
	 * @author
	 */
	private EventResponse searchPortCarrierEnRouteList(Event e) throws EventException {
	    try{
    		VopScg0011Event event = (VopScg0011Event)e;
    		//PortRestrictionBC 		command1 = new PortRestrictionBCImpl();
    		CarrierRestrictionBC 	command2 = new CarrierRestrictionBCImpl();
     
            List<ScgImdgCrrRstrVO> list1 = null;
            List<PortRestrictionOptionVO> list2 = null;        
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
     
     
    		PortRestrictionOptionVO portRestrictionOptionVO = event.getContition();
    					
    		list2 = command2.searchPortEnRouteList(    portRestrictionOptionVO  );
    		
    		String imdgClsscd     = portRestrictionOptionVO.getImdgClssCd();
    		//portRestrictionOptionVO.setImdgClssCd("");
    		
    		list1 = command2.searchCarrierEnRouteList( portRestrictionOptionVO  );	
    		if( list1.size()  == 0){
    		    portRestrictionOptionVO.setImdgClssCd( imdgClsscd );
    		    portRestrictionOptionVO.setImdgUnNo   ("");
    		    portRestrictionOptionVO.setImdgUnNoSeq("");
    	        list1 = command2.searchCarrierEnRouteList( portRestrictionOptionVO  );    
    	        eventResponse.setETCData("SEARCH_METHOD","class");
    		}else{
    		    eventResponse.setETCData("SEARCH_METHOD","unno");
    		}
    		
    
    		eventResponse.setRsVoList(list1);
    		eventResponse.setRsVoList(list2);		
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Carrier EnRouteList"}).getMessage(), ex);
        }
	}	 

	/**
	 * 
     * VOP_SCG_0011 : Retrieve 
     * Port & VSL OPR’s Restriction En-route retrieve<br>
     * 
	 * @param  Event e
	 * @throws EventException
	 * @return EventResponse
	 * @author
	 */
	private EventResponse searchPortRotnSeq(Event e) throws EventException {
	    try{
    		VopScg0011Event event = (VopScg0011Event)e;
    		CarrierRestrictionBC 	command = new CarrierRestrictionBCImpl();
     
            List<PortRestrictionOptionVO> list = null;
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
     
     
    		PortRestrictionOptionVO portRestrictionOptionVO = event.getContition();
    					
    		list = command.searchPortRotnSeq(   portRestrictionOptionVO  );
    		
    		eventResponse.setRsVoList(list);

    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Carrier EnRouteList"}).getMessage(), ex);
        }
	}	 

	/**
     * VOP_SCG_0076 : Retrieve
     * DG Prohibition Summary by Port retrieve<br>
     *
     * @param  Event  e
     * @throws EventException
     * @return EventResponse
     * @author
     */
    private EventResponse searchPortRestrictionSummary(Event e) throws EventException {
        try{
            VopScg0076Event event = (VopScg0076Event)e;     
            PortRestrictionBC command = new PortRestrictionBCImpl();
     
            List<PortRestrictionVO> list1 = null;        
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            PortRestrictonOptionVO portRestrictonOptionVO = event.getPortRestrictonOptionVO();
            list1 = command.searchPortRestrictionSummary( portRestrictonOptionVO  );             
            eventResponse.setRsVoList(list1);
        
            return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"DG Prohibition Summary by Port"}).getMessage(), ex);
        }
    }    
}
