/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OperationNPerformMasterDataMgtSC.java
*@FileTitle : Stevedore Damage Part Code (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt;

import java.util.List;

import com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.basic.OperationNPerformMasterDataMgtBC;
import com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.basic.OperationNPerformMasterDataMgtBCImpl;
import com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.event.VopOpf0034Event;
import com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.event.VopOpf0035Event;
import com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.event.VopOpf0048Event;
import com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.event.VopOpf0049Event;
import com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.event.VopOpf0050Event;
import com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.event.VopOpf0067Event;
import com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.event.VopOpf0068Event;
import com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.event.VopOpf0075Event;
import com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.event.VopOpf0087Event;
import com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.event.VopOpf9003Event;
import com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.integration.OperationNPerformMasterDataMgtDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmLocationVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;
import com.clt.syscommon.common.table.OpfCodDvsFeeVO;
import com.clt.syscommon.common.table.OpfCodRjctCdVO;
import com.clt.syscommon.common.table.OpfRstwgRsnCdVO;
import com.clt.syscommon.common.table.OpfStvDmgCdVO;
import com.clt.syscommon.common.table.OpfTmlProdRptRsnCdVO;


/**
 * OPUS-OperationNPerformMasterDataMgt Business Logic ServiceCommand - 
 * Handling business transaction about OPUS-OperationNPerformMasterDataMgt 
 * 
 * @author
 * @see OperationNPerformMasterDataMgtDBDAO
 * @since J2EE 1.4
 */

public class OperationNPerformMasterDataMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * OperationNPerformMasterDataMgt system preceding process for biz scenario<br>
	 * vop_opf_0048 related objects creation<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * OperationNPerformMasterDataMgt system  biz scenario closing<br>
	 * vop_opf_0048 clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("OperationNPerformMasterDataMgtSC 종료");
	}

	/**
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// Part of using in case SC handles many events
		if (e.getEventName().equalsIgnoreCase("VopOpf0048Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchStevedoreDamagePartCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageStevedoreDamagePartCode(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf0050Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchStevedoreDamagePartCodeInquiryList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf0049Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchStevedoreDamageReasonCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageStevedoreDamageReasonCode(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf0087Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchExcludeTPRReasonCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageExcludeTPRReasonCode(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf0075Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRestowReasonCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = mamageRestowReasonCode(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf0034Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCODRejectReasonCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCODRejectReasonCode(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf0035Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCODRejectReasonCodeInquiryList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf0067Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTPRTargetLaneList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageTPRTargetLaneList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf0068Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTPRTargetPortList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchRHQOfficeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageTPRTargetPort(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf9003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCODDiversionCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCODDiversionCode(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchContiCdUseYn(e);
			}
		}
		return eventResponse;
	}
	/**
	 * VOP_OPF_0075 : Retrieve <br>
	 * Retrieve StevedoreDamagePartCodeList <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStevedoreDamagePartCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0048Event event = (VopOpf0048Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
    		List<OpfStvDmgCdVO> list = command.searchStevedoreDamagePartCodeList(event.getOpfStvDmgCdVO());
 
    		eventResponse.setRsVoList(list);
        } catch (EventException ex) {
        	log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
        	log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Stevedore Damage Retrieve"}).getMessage(), ex);
        }
		return eventResponse;
	}  
	/**
	 * VOP_OPF_0075 : Retrieve <br>
	 * Retrieve StevedoreDamagePartCodeInquiryList <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStevedoreDamagePartCodeInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0050Event event = (VopOpf0050Event)e;
		OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
    		List<OpfStvDmgCdVO> list = command.searchStevedoreDamagePartCodeList(event.getOpfStvDmgCdVO());

    		eventResponse.setRsVoList(list);
        } catch (EventException ex) {
        	log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
        	log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Stevedore Damage Part Code Retrieve"}).getMessage(), ex);
        }

		return eventResponse;
	}	
	/**
	 * VOP_OPF_0075 : Retrieve <br>
	 * Retrieve StevedoreDamageReasonCodeList <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStevedoreDamageReasonCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0049Event event = (VopOpf0049Event)e;
	    GeneralEventResponse eventResponse = new GeneralEventResponse();
	    try{
    		OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
    		List<OpfStvDmgCdVO> list = command.searchStevedoreDamageReasonCodeList(event.getOpfStvDmgCdVO());

    		eventResponse.setRsVoList(list);
        } catch (EventException ex) {
        	log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
        	log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Stevedore Damage Reason Code Retrieve"}).getMessage(), ex);
        }

		return eventResponse;
	}
	/**
	 * VOP_OPF_0075 : Retrieve <br>
	 * Retrieve ExcludeTPRReasonCodeList <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExcludeTPRReasonCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0087Event event = (VopOpf0087Event)e;
	    GeneralEventResponse eventResponse = new GeneralEventResponse();
	    try{
    		OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
    		List<OpfTmlProdRptRsnCdVO> list = command.searchExcludeTPRReasonCodeList(event.getOpfTmlProdRptRsnCdVO());

    		eventResponse.setRsVoList(list);
        } catch (EventException ex) {
        	log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
        	log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Exclude TPRReason Code Retrieve"}).getMessage(), ex);
        }

		return eventResponse;
	}
	/**
	 * VOP_OPF_0075 : Save <br>
	 * Save StevedoreDamagePartCode <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageStevedoreDamagePartCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0048Event event = (VopOpf0048Event)e;
		OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
		try{
			begin();
			command.manageStevedoreDamagePartCode(event.getOpfStvDmgCdVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Stevedore Damage Part"}).getMessage(), ex);
        }
		return eventResponse;
	}
	/**
	 * VOP_OPF_0075 : Save <br>
	 * Save StevedoreDamageReasonCode <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageStevedoreDamageReasonCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0049Event event = (VopOpf0049Event)e;
		OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
		try{
			begin();
			command.manageStevedoreDamageReasonCode(event.getOpfStvDmgCdVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Stevedore Damage Reason"}).getMessage(), ex);
        }
		return eventResponse;
	}
	/**
	 * VOP_OPF_0075 : Save <br>
	 * Save ExcludeTPRReasonCode <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageExcludeTPRReasonCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0087Event event = (VopOpf0087Event)e;
		OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
		try{
			begin();
			command.manageExcludeTPRReasonCode(event.getOpfTmlProdRptRsnCdVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Exclude TPR Reason"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	// VOP_OPF_0075 Start ==========================================================//
	/**
	 * VOP_OPF_0075 : Retrieve <br>
	 * Retrieve Restow Reason Code <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRestowReasonCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0075Event event = (VopOpf0075Event)e;
	    GeneralEventResponse eventResponse = new GeneralEventResponse();
	    try{
    		OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
    		List<OpfRstwgRsnCdVO> list = command.searchRestowReasonCodeList(event.getOpfRstwgRsnCdVO());
            eventResponse.setRsVoList(list);
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Restow Reason Retrieve"}).getMessage(), ex);
        }

		return eventResponse;
	}
	/**
	 * VOP_OPF_0075 : Save <br>
	 * Save Restow Reason Code <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse mamageRestowReasonCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0075Event event = (VopOpf0075Event)e;
		OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
		try{
			begin();
			command.mamageRestowReasonCode(event.getOpfRstwgRsnCdVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Restow Reason Code"}).getMessage(), ex);
        }
		return eventResponse;
	}
	// VOP_OPF_0075 End ============================================================//
	
	// VOP_OPF_0034 Start ==========================================================//
	/**
	 * VOP_OPF_0034 : Retrieve <br>
	 * Retrieve COD Reject Reason Code <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCODRejectReasonCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0034Event event = (VopOpf0034Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
    		OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
    		List<OpfCodRjctCdVO> list = command.searchCODRejectReasonCodeList(event.getOpfCodRjctCdVO());

    		eventResponse.setRsVoList(list);
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"COD Reject Reason Retrieve"}).getMessage(), ex);
        }

		return eventResponse;
	}
	/**
	 * VOP_OPF_0034 : Save <br>
	 * Save COD Reject Reason Code <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCODRejectReasonCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0034Event event = (VopOpf0034Event)e;
		OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
		try{
			begin();
			command.manageCODRejectReasonCode(event.getOpfCodRjctCdVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"COD Reject Reason Code"}).getMessage(), ex);
        }
		return eventResponse;
	}
	// VOP_OPF_0034 End ============================================================//

	// VOP_OPF_0035 Start ============================================================//
	/**
	 * VOP_OPF_0035 : Retrieve <br>
	 * Retrieve COD Reject Reason Code <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCODRejectReasonCodeInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0035Event event = (VopOpf0035Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
    		OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
    		List<OpfCodRjctCdVO> list = command.searchCODRejectReasonCodeList(event.getOpfCodRjctCdVO());
    
    		eventResponse.setRsVoList(list);
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"COD Reject Reason Code Retrieve"}).getMessage(), ex);
        }

		return eventResponse;
	}
	// VOP_OPF_0035 End ============================================================//
	
	// VOP_OPF_0067 Start ==========================================================//
	/**
	 * VOP_OPF_0067 : TPR Target Lane Creation <br>
	 * Retrieve TPR Target Lane Creation <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTPRTargetLaneList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0067Event event = (VopOpf0067Event)e;
		OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
		try{
			List<MdmVslSvcLaneVO> list = command.searchTPRTargetLaneList(event.getMdmVslSvcLaneVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"TPR Target Lane Creation"}).getMessage(), ex);
		}
		
		return eventResponse;
	}
	/**
	 * Handling multi event<br>
	 * VOP_OPF_0067 : TPR Target Lane Creation <br>
	 * Save TPR Target Lane Creation <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTPRTargetLaneList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0067Event event = (VopOpf0067Event)e;
		OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
		try{
			begin();
			command.manageTPRTargetLaneList(event.getMdmVslSvcLaneVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TPR Target Lane Creation"}).getMessage(), ex);
        }
		return eventResponse;
	}

	// VOP_OPF_0067 End ============================================================//	
	// VOP_OPF_0068 Start ==========================================================//
	/**
	 * Retrieve RHQ List
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRHQOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0068Event event = (VopOpf0068Event)e;
		OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
		
			List<MdmLocationVO> list = command.searchRHQOfficeList(event.getMdmLocationVO());			
			eventResponse.setRsVoList(list);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"RHQ List"}).getMessage(), ex);
		}
		
		
		return eventResponse;
	}
	/**
	 * 1. Retrieve All Port except TPR <br>
	 * 2. Retrieve Port relevant TPR <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTPRTargetPortList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0068Event event = (VopOpf0068Event)e;
		OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<MdmLocationVO> list = command.searchAllPortList(event.getMdmLocationVO());
			List<MdmLocationVO> list2 = command.searchTPRTargetPortList(event.getMdmLocationVO());
			
			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(list2);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"TPR Target Lane Creation"}).getMessage(), ex);
		}
		
		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0068 : Save  <br>
	 * Save TPR Target Port Creation <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTPRTargetPort(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0068Event event = (VopOpf0068Event)e;
		OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
		try{
			begin();
			command.manageTPRTargetPort(event.getMdmLocationVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report Header"}).getMessage(), ex);
		}
		return eventResponse;
	}
	// VOP_OPF_0068 End ============================================================//	
	
	// VOP_OPF_9003 Start ==========================================================//
	
	/**
	 * VOP_OPF_9003 : Retrieve <br>
	 *  Conti Cd  Enable or disable search <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContiCdUseYn(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf9003Event event = (VopOpf9003Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
    		OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
    		String result = command.searchContiCdUseYn(event.getOpfCodDvsFeeVO());
    		
    		eventResponse.setETCData("RESULT", result);

        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"COD Diversion Fee Cdoe Retrieve"}).getMessage(), ex);
        }

		return eventResponse;
	}
	
	/**
	 * VOP_OPF_9003 : Retrieve <br>
	 * COD Diversion Fee Cdoe search <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCODDiversionCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf9003Event event = (VopOpf9003Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
    		OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
    		List<OpfCodDvsFeeVO> list = command.searchCODDiversionCodeList(event.getOpfCodDvsFeeVO());

    		eventResponse.setRsVoList(list);
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"COD Diversion Fee Cdoe Retrieve"}).getMessage(), ex);
        }

		return eventResponse;
	}
	/**
	 * VOP_OPF_9003 : Save <br>
	 * COD Diversion Fee Cdoe Save <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCODDiversionCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf9003Event event = (VopOpf9003Event)e;
		OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
		try{
			begin();
			command.manageCODDiversionCode(event.getOpfCodDvsFeeVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"COD Diversion Fee Cdoe"}).getMessage(), ex);
        }
		return eventResponse;
	}
	// VOP_OPF_9003 End ============================================================//
}