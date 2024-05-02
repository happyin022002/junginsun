/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtSC.java
*@FileTitle : Load Reject Reason (Creation)
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargomasterdatamgt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.basic.IMDGCodeMgtBC;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.basic.IMDGCodeMgtBCImpl;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.basic.SpecialCargoMasterDataMgtBC;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.basic.SpecialCargoMasterDataMgtBCImpl;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0031Event;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0032Event;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0033Event;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0034Event;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0035Event;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0036Event;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0037Event;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0039Event;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0040Event;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0041Event;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0042Event;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0043Event;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0044Event;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0045Event;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0046Event;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0047Event;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0049Event;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0051Event;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0053Event;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0066Event;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0067Event;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0070Event;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0073Event;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0077Event;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration.SpecialCargoMasterDataMgtDBDAO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.GetLoadingPortRsoVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.MdmVslSvcLaneListVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgCntcPntVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgImdgPckInstrVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgImdgSpclProvisVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgImdgUnNoOrgRactVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgMailTampletVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.SearchIrregularTypeCodeListVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.SearchLoadingPortRsoVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.SearchRsoComboListVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.VopScg0070VO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmCarrierVO;
import com.clt.syscommon.common.table.ScgImdgAbbrVO;
import com.clt.syscommon.common.table.ScgImdgClssCdVO;
import com.clt.syscommon.common.table.ScgImdgCompGrpVO;
import com.clt.syscommon.common.table.ScgImdgExptQtyVO;
import com.clt.syscommon.common.table.ScgImdgMrnPolutVO;
import com.clt.syscommon.common.table.ScgImdgPckCdVO;
import com.clt.syscommon.common.table.ScgImdgPckGrpVO;
import com.clt.syscommon.common.table.ScgImdgSegrSymVO;
import com.clt.syscommon.common.table.ScgImdgSpclProviVO;
import com.clt.syscommon.common.table.ScgImdgTnkTpVO;
import com.clt.syscommon.common.table.ScgLodRjctCdVO;
import com.clt.syscommon.common.table.ScgRgnShpOprCdVO;



/**
 * OPUS-SpecialCargoMasterDataMgt Business Logic ServiceCommand - Handling business transactions of OPUS-SpecialCargoMasterDataMgt.
 * 
 * @author Dohyoung Lee
 * @see SpecialCargoMasterDataMgtDBDAO
 * @since J2EE 1.4
 */

public class SpecialCargoMasterDataMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * SpecialCargoMasterDataMgt system preceding process for biz scenario<br>
	 * VOP_SCG-0031 related objects creation<br>
	 */
	public void doStart() {
		try {
			// comment --> login check
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());			
		}
	}

	/**
	 * SpecialCargoMasterDataMgt system biz scenario closing<br>
	 * VOP_SCG-0031 clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("SpecialCargoMasterDataMgtSC end");
	}

	/**
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// When SC handles multiple events
		if (e.getEventName().equalsIgnoreCase("VopScg0031Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)
					||e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchLoadRejectReasonCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageLoadRejectReasonCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0032Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRegionalShipOperatorCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageRegionalShipOperatorCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0034Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPartnerLineContactPointList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSpclCgoRsoList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchSpclCgoRsoforEdiUnmapList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCarrierCode(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePartnerLineContactPoint(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0036Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchIrregularTypeCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageIrregularTypeCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0037Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchClassDefinitionList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageClassDefinition(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0039Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMarinePollutantCodeList(e);
			}                   
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageMarinePollutantCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0040Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPackingGroupCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePackingGroupCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0041Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSpecialProvisionList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSpecialProvision(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0043Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPackingCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePackingCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0044Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchIMOTankTypeCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageIMOTankTypeCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0045Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDGAbbreviationCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDGAbbreviationCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0046Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchNumberNSymbolCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageNumberNSymbolCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0047Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCompatibilityGroupCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCompatibilityGroupCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0063Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDGAbbreviationCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDGAbbreviationCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0067Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchExceptedQuantityCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageExceptedQuantityCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0070Event")) {	//Segregation Groups (Creation)
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSegregationGroupList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSegregationGroupList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchSegregationGroupList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSegregationGroup(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0033Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLoadingPortRSOList(e);
			}
			/**
			 * Combo retrieve
			 */
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRsoList(e);

			}			
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				 eventResponse = manageLoadingPortRSO(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				 eventResponse = searchLoadingPortRSO(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				 eventResponse = searchLoadingPortRSODupChk(e);
			}	
 		
 			
		}else if (e.getEventName().equalsIgnoreCase("VopScg0051Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLoadingPortRSOListForInQuiry(e);
			}
			/**
			 * Combo retrieve
			 */
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRsoListForInQuiry(e);
			}			
		}else if (e.getEventName().equalsIgnoreCase("VopScg0035Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchApprovalTargetLaneList(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchApprovalTargetLane(e);
			}			
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageApprovalTargetLane(e);
			}		
 		
		}else if (e.getEventName().equalsIgnoreCase("VopScg0042Event")) {	//Packing Instructions/Provisions (Creation)
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPackingInstructionList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				 eventResponse = managePackingInstruction(e);
			} 
		}else if (e.getEventName().equalsIgnoreCase("VopScg0053Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchApprovalTargetLaneList(e,"VopScg0053Event");
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0049Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchLoadRejectReasonCodeList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0066Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchOrganicPeroxideCodeList(e);
            }
        }else if (e.getEventName().equalsIgnoreCase("VopScg0073Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
                eventResponse = searchSpecialProvisionSegregationList(e);
            }
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchSubsidiaryRisks(e);
            }            
 
            if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageSpecialProvisionSegregationList(e);
            }                   
        }else if (e.getEventName().equalsIgnoreCase("VopScg0077Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSCGMailTamplet(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSCGMailTamplet(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * Load Reject Reason  : Retrieve <br>
	 * Load Reject Reason retrieve <br>
	 * 
	 * @param Event e 
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchLoadRejectReasonCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		
    		List<ScgLodRjctCdVO> list = null;
    	    if ( e.getEventName().equalsIgnoreCase("VopScg0031Event")) {
    			VopScg0031Event event = (VopScg0031Event)e;
    			list = command.searchLoadRejectReasonCodeList(event.getScgLodRjctCdVO());
    	    }
    	    if ( e.getEventName().equalsIgnoreCase("VopScg0049Event")) {
    			VopScg0049Event event = (VopScg0049Event)e;	    
    			list = command.searchLoadRejectReasonCodeList(event.getScgLodRjctCdVO());			
    	    }
     	
    		
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		if(list != null){
    			eventResponse.setRsVoList(list);
    		}
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Load Reject Reason"}).getMessage(), ex);
        }
	}
	
	/**
	 * Load Reject Reason   : Save <br>
	 * Load Reject Reason create, modify, delete <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse manageLoadRejectReasonCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0031Event event = (VopScg0031Event)e;

		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
		try{
			begin();			
			command.manageLoadRejectReasonCode(event.getScgLodRjctCdVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Load Reject Reason"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0032  : Retrieve <br>
	 * SPCL CGO RSO retrieve <br>
	 * 
	 * @param Event e 
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchRegionalShipOperatorCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		VopScg0032Event event = (VopScg0032Event)e;
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		List<ScgRgnShpOprCdVO> list = command.searchRegionalShipOperatorCodeList(event.getScgRgnShpOprCdVO());
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO RSO"}).getMessage(), ex);
        }
	}
	
	/**
	 * VOP_SCG_0032  : Save <br>
	 * SPCL CGO RSO create, modify, delete <br>
	 * 
	 * @param Event e 
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse manageRegionalShipOperatorCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0032Event event = (VopScg0032Event)e;

		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
		try{
			begin();
			
			command.manageRegionalShipOperatorCode(event.getScgRgnShpOprCdVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO RSO"}).getMessage(), ex);
        }
        
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0034  : Retrieve <br>
	 * Partner's Contact Point for SPCL CGO retrieve <br>
	 * 
	 * @param Event e 
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchPartnerLineContactPointList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
	    	VopScg0034Event event = (VopScg0034Event)e;
	    	SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
		
	    	event.getScgCntcPntVO().setTransmitTarget("SpclCgo");
	    	List<ScgCntcPntVO> list1 = command.searchPartnerLineContactPointList(event.getScgCntcPntVO());
	    	event.getScgCntcPntVO().setTransmitTarget("TdrRdr");
	    	List<ScgCntcPntVO> list2 = command.searchPartnerLineContactPointList(event.getScgCntcPntVO());
	    	event.getScgCntcPntVO().setTransmitTarget("Baplie");
	    	List<ScgCntcPntVO> list3 = command.searchPartnerLineContactPointList(event.getScgCntcPntVO());
	    	GeneralEventResponse eventResponse = new GeneralEventResponse();
	    	eventResponse.setRsVoList(list1);
	    	eventResponse.setRsVoList(list2);
	    	eventResponse.setRsVoList(list3);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Partner's Contact Point for SPCL CGO"}).getMessage(), ex);
        }
	}
	
	/**
	 * VOP_SCG_0034  : OnLoad <br>
	 * RSO retrieve <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchSpclCgoRsoList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//VopScg0034Event event = (VopScg0034Event)e;
	    try{
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		List<ScgRgnShpOprCdVO> list = command.searchSpclCgoRsoList();
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Partner's Contact Point for SPCL CGO"}).getMessage(), ex);
        }
	}

	/**
	 * VOP_SCG_0034  : OnLoad <br>
	 * RSO retrieve <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchSpclCgoRsoforEdiUnmapList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopScg0034Event event = (VopScg0034Event)e;
		
	    try{
    		SpecialCargoMasterDataMgtBC command 		= new SpecialCargoMasterDataMgtBCImpl();
    		List<ScgRgnShpOprCdVO> 		list 			= command.searchSpclCgoRsoforEdiUnmapList(event.getScgRgnShpOprCdVO());
    		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		
    		return eventResponse;
    		
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Partner's Contact Point for SPCL CGO"}).getMessage(), ex);
        }
	}
	
	
	/**
	 * VOP_SCG_0034  : Save <br>
	 * Partner's Contact Point for SPCL CGO create, modify, delete <br>
	 * 
	 * @param Event  e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse managePartnerLineContactPoint(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0034Event event = (VopScg0034Event)e;

		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
		try{
			begin();
			
			command.managePartnerLineContactPoint(event.getScgCntcPntVOS(),event.getScgCntcPntVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Partner's Contact Point for SPCL CGO"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0036  : Retrieve <br>
	 * SPCL CGO Irregular Type retrieve <br>
	 * 
	 * @param Event e 
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchIrregularTypeCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		VopScg0036Event event = (VopScg0036Event)e;
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		List<SearchIrregularTypeCodeListVO> list = command.searchIrregularTypeCodeList(event.getSearchIrregularTypeCodeListVO());
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO Irregular Type"}).getMessage(), ex);
        }
	}
	/**
	 * VOP_SCG_0036  : Save <br>
	 * SPCL CGO Irregular Type create, modify, delete <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageIrregularTypeCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0036Event event = (VopScg0036Event)e;

		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
		try{
			begin();
			
			command.manageIrregularTypeCode(event.getSearchIrregularTypeCodeListVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            rollback();
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO Irregular Type"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0037  : Retrieve <br>
	 * Definition of Class retrieve <br>
	 * 
	 * @param   Event e 
	 * @return  EventResponseresponse 
	 * @exception EventException
	 */
	private EventResponse searchClassDefinitionList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		VopScg0037Event event = (VopScg0037Event)e;
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		List<ScgImdgClssCdVO> list = command.searchClassDefinitionList(event.getScgImdgClssCdVO());
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Definition of Class"}).getMessage(), ex);
        }
	}
	
	/**
	 * VOP_SCG_0037  : Save <br>
	 * Definition of Class create, modify, delete <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageClassDefinition(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0037Event event = (VopScg0037Event)e;

		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
		try{
			begin();
			
			command.manageClassDefinition(event.getScgImdgClssCdVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            rollback();
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Definition of Class"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0039  : Retrieve <br>
	 * Marine Pollutant retrieve <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchMarinePollutantCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		VopScg0039Event event = (VopScg0039Event)e;
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		List<ScgImdgMrnPolutVO> list = command.searchMarinePollutantCodeList(event.getScgImdgMrnPolutVO());
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Marine Pollutant"}).getMessage(), ex);
        }
	}
	/**
	 * VOP_SCG_0039  : Save <br>
	 * Marine Pollutant create, modify, delete <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMarinePollutantCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0039Event event = (VopScg0039Event)e;

		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
		try{
			begin();
			
			command.manageMarinePollutantCode(event.getScgImdgMrnPolutVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            rollback();
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Marine Pollutant"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0040  : Retrieve <br>
	 * Packing Group retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPackingGroupCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		VopScg0040Event event = (VopScg0040Event)e;
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		List<ScgImdgPckGrpVO> list = command.searchPackingGroupCodeList(event.getScgImdgPckGrpVO());
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Packing Group"}).getMessage(), ex);
        }
	}
	/**
	 * VOP_SCG_0040  : Save <br>
	 * Packing Group create, modify, delete <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse managePackingGroupCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0040Event event = (VopScg0040Event)e;

		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
		try{
			begin();
			
			command.managePackingGroupCode(event.getScgImdgPckGrpVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            rollback();
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Packing Group"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0041  : Retrieve <br>
	 * Special Provisions retrieve <br>
	 * 
	 * @param   Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchSpecialProvisionList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		VopScg0041Event event = (VopScg0041Event)e;
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		List<ScgImdgSpclProviVO> list = command.searchSpecialProvisionList(event.getScgImdgSpclProviVO());
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Special Provisions"}).getMessage(), ex);
        }		
	}
	/**
	 * VOP_SCG_0041  : Save <br>
	 * Special Provisions create, modify, delete <br>
	 * 
	 * @param Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse manageSpecialProvision(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0041Event event = (VopScg0041Event)e;

		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
		try{
			begin();
			
			command.manageSpecialProvision(event.getScgImdgSpclProviVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            rollback();
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Special Provisions"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0043  : Retrieve <br>
	 * Packaging Code retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPackingCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		VopScg0043Event event = (VopScg0043Event)e;
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		List<ScgImdgPckCdVO> list = command.searchPackingCodeList(event.getScgImdgPckCdVO());
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Packaging Code"}).getMessage(), ex);

        }		
	}

	/**
	 * VOP_SCG_0043  : Save <br>
	 * Packaging Code create, modify, delete <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse managePackingCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0043Event event = (VopScg0043Event)e;

		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
		try{
			begin();
			
			command.managePackingCode(event.getScgImdgPckCdVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            rollback();
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Packaging Code"}).getMessage(), ex);

        }
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0044  : Retrieve <br>
	 * IMO Type Portable Tanks retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIMOTankTypeCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		VopScg0044Event event = (VopScg0044Event)e;
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		List<ScgImdgTnkTpVO> list = command.searchIMOTankTypeCodeList(event.getScgImdgTnkTpVO());
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"IMO Type Portable Tanks"}).getMessage(), ex);
        }		
	}
	/**
	 * VOP_SCG_0044  : Save <br>
	 * IMO Type Portable Tanks create, modify, delete <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageIMOTankTypeCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0044Event event = (VopScg0044Event)e;

		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
		try{
			begin();
			
			command.manageIMOTankTypeCode(event.getScgImdgTnkTpVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            rollback();
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"IMO Type Portable Tanks"}).getMessage(), ex);
        }
		return eventResponse;
	}

	/**
	 * VOP_SCG_0045  : Retrieve <br>
	 * DG Abbreviation retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDGAbbreviationCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		VopScg0045Event event = (VopScg0045Event)e;
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		List<ScgImdgAbbrVO> list = command.searchDGAbbreviationCodeList(event.getScgImdgAbbrVO());
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"DG Abbreviation"}).getMessage(), ex);
        }		
	}
	/**
	 * VOP_SCG_0045  : Save <br>
	 * DG Abbreviation create, modify, delete <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDGAbbreviationCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0045Event event = (VopScg0045Event)e;

		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
		try{
			begin();
			
			command.manageDGAbbreviationCode(event.getScgImdgAbbrVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"DG Abbreviation"}).getMessage(), ex);
        }
		return eventResponse;
	}

	/**
	 * VOP_SCG_0046  : Retrieve <br>
	 * No. & Symbols in SEG Table/Mixed STWG retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNumberNSymbolCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		VopScg0046Event event = (VopScg0046Event)e;
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		List<ScgImdgSegrSymVO> list = command.searchNumberNSymbolCodeList(event.getScgImdgSegrSymVO());
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"No. & Symbols in SEG Table/Mixed STWG"}).getMessage(), ex);
        }		
	}
	/**
	 * VOP_SCG_0046  : Save <br>
	 * No. & Symbols in SEG Table/Mixed STWG create, modify, delete <br>
	 * 
	 * @param Event e 
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse manageNumberNSymbolCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0046Event event = (VopScg0046Event)e;

		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
		try{
			begin();
			
			command.manageNumberNSymbolCode(event.getScgImdgSegrSymVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"No. & Symbols in SEG Table/Mixed STWG"}).getMessage(), ex);
        }
		return eventResponse;
	}

	/**
	 * VOP_SCG_0047  : Retrieve <br>
	 * Compatibility Groups of Class 1 retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCompatibilityGroupCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		VopScg0047Event event = (VopScg0047Event)e;
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		List<ScgImdgCompGrpVO> list = command.searchCompatibilityGroupCodeList(event.getScgImdgCompGrpVO());
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Compatibility Groups of Class"}).getMessage(), ex);
        }		
	}
	/**
	 * VOP_SCG_0047  : Save <br>
	 * Compatibility Groups of Class 1 create, modify, delete <br>
	 * 
	 * @param   Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse manageCompatibilityGroupCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0047Event event = (VopScg0047Event)e;

		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
		try{
			begin();
			
			command.manageCompatibilityGroupCode(event.getScgImdgCompGrpVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            rollback();
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Compatibility Groups of Class"}).getMessage(), ex);
        }
		return eventResponse;
	}

	/**
	 * VOP_SCG_0067  : Retrieve <br>
	 * Excepted Quantities retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExceptedQuantityCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		VopScg0067Event event = (VopScg0067Event)e;
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		List<ScgImdgExptQtyVO> list = command.searchExceptedQuantityCodeList(event.getScgImdgExptQtyVO());
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Excepted Quantities"}).getMessage(), ex);
        }		
	}
	/**
	 * VOP_SCG_0067  : Save <br>
	 * Excepted Quantities create, modify, delete <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageExceptedQuantityCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0067Event event = (VopScg0067Event)e;
 
		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
		try{
			begin();
			
			command.manageExceptedQuantityCode(event.getScgImdgExptQtyVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            rollback();
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Excepted Quantities"}).getMessage(), ex);
        }
		return eventResponse;
	}

	/**
	 * VOP_SCG-0070 : Retrieve <br>
	 * Segregation Groups (Creation) retrieve<br>
	 * 
	 * @param     Event e 
	 * @return    EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchSegregationGroupList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		VopScg0070Event event = (VopScg0070Event)e;
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		
    		VopScg0070VO vopScg0070VO = command.searchSegregationGroupList(event.getScgImdgSegrGrpVO(), event.getScgImdgSegrGrpDtlVO(), e.getFormCommand());
    		
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		
    		if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
    			eventResponse.setRsVoList(vopScg0070VO.getScgImdgSegrGrpVOL());
    		} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
    			eventResponse.setRsVoList(vopScg0070VO.getScgImdgSegrGrpDtlVOL());
    		} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
    			eventResponse.setRsVoList(vopScg0070VO.getScgImdgSegrGrpDtlVOL());
    		}			
    		
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Segregation Groups"}).getMessage(), ex);
        }
	}
	
	/**
	 * VOP_SCG-0070 : Save <br>
	 * Segregation Groups (Creation) save<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSegregationGroup(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0070Event event = (VopScg0070Event)e;

		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
		try{
			begin();
			
			VopScg0070VO vopScg0070VO = new VopScg0070VO(event.getScgImdgSegrGrpVOS(), event.getScgImdgSegrGrpDtlVOS());
			command.manageSegregationGroup(vopScg0070VO, account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Segregation Groups"}).getMessage(), ex);
        }
		return eventResponse;
	}

	/**
	 * VOP_SCG-0033: onchagne <br>
     * Loading Port for RSO retrieve
	 *  
	 * @param  Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */

	private EventResponse searchLoadingPortRSOList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		VopScg0033Event event = (VopScg0033Event)e;  
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		List<SearchLoadingPortRsoVO> list       = command.searchLoadingPortRSOList( event.getSearchRsoComboListVO() );
    		
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);

    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{" Loading Port for RSO"}).getMessage(), ex);
        }
	}
	/**
	 * VOP_SCG-0051: RETRIEVE <br>
	 * Loading Port for RSO retrieve
	 * 
	 * @param  Event e
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */

	private EventResponse searchLoadingPortRSOListForInQuiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
    		VopScg0051Event event = (VopScg0051Event)e;  
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		List<SearchLoadingPortRsoVO> list       = command.searchLoadingPortRSOList( event.getSearchRsoComboListVO() );
    		
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
     
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Loading Port for RSO"}).getMessage(), ex);
        }
	}	
  	/**
     * VOP_SCG_0051 : SEARCH
	 * SpecialCargoMasterDataMgtDBDAO Loading Port for RSO retrieve<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRsoList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		// VopScg0033Event event = (VopScg0033Event)e;
	    try{
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		List<SearchRsoComboListVO> rsolist   = command.searchRsoList( );		
    		
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		StringBuffer str = new StringBuffer();
    		for(int i=0;i<rsolist.size();i++){
    			 str.append( ((SearchRsoComboListVO)rsolist.get(i)).getRso()+"%" );
    		}
     
    		Map<String,String> etcData = new HashMap<String,String>();
    		etcData.put("cmbRso", str.toString() );
    		eventResponse.setETCData(etcData);
     
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Loading Port for RSO"}).getMessage(), ex);
        }
	}	
	 
	/**
	 * VOP_SCG_0051 : RETRIEVE
	 * Loading Port for RSO retrieve
	 * 
	 * @param  Event e 
	 * @return  EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRsoListForInQuiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		// VopScg0051Event event = (VopScg0051Event)e;
	    try{
			SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
			List<SearchRsoComboListVO> rsolist   =  command.searchRsoList( );		
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			StringBuffer str = new StringBuffer();
			for(int i=0;i<rsolist.size();i++){
				 str.append( ((SearchRsoComboListVO)rsolist.get(i)).getRso()+"%" );
			}
	 
			Map<String,String> etcData = new HashMap<String,String>();
			etcData.put("cmbRso", str.toString() );
			eventResponse.setETCData(etcData);
	 
			return eventResponse;
	    } catch (EventException ex) {
	        log.error("error:"+ex.toString(), ex);
	        throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        log.error("error:"+ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Loading Port for RSO"}).getMessage(), ex);
	    }
	}
	 
	/**
	 * VOP_SCG-0033 : Save  <br>
	 * Loading Port for RSO save
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 * @author jkc
	 */
	 private EventResponse manageLoadingPortRSO(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
				GeneralEventResponse eventResponse = new GeneralEventResponse();
				VopScg0033Event event = (VopScg0033Event)e;
	
				SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
				try{
					begin();
					
					command.manageLoadingPortRSO(event.getScgRgnShpOprPortListVOs() ,account);
	 
		            eventResponse.setUserMessage(  new ErrorHandler("SCG00001", new String[]{"Data"} ).getUserMessage() );
			commit();
	    } catch (EventException ex) {
	        log.error("error:"+ex.toString(), ex);
	        rollback();
	        throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        log.error("error:"+ex.toString(), ex);
	        rollback();
	        throw new EventException(new ErrorHandler("COM12192", new String[]{"Loading Port for RSO"}).getMessage(), ex);
	
	    }
		return eventResponse;
	}	 
	/**
	 * VOP_SCG-0033 : retrieve <br>
	 * Loading Port for RSO retrieve
	 * 
	 * @param     Event e
	 * @return    EventResponse response
	 * @exception EventException
	 */		
	private EventResponse searchLoadingPortRSO(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
			VopScg0033Event event = (VopScg0033Event)e;  
			SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
			List<GetLoadingPortRsoVO>  rso    = command.searchLoadingPortRSO((String)event.getAttribute("loc_cd"));	
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			StringBuffer str = new StringBuffer();
			if(rso.size() > 0){
	            str.append( ((GetLoadingPortRsoVO)rso.get(0)).getLocCd()+"|"  );
	            str.append( ((GetLoadingPortRsoVO)rso.get(0)).getRgnShpOprCd()+"|");
	            str.append( ((GetLoadingPortRsoVO)rso.get(0)).getCntNm()+"|"  );
	            str.append( ((GetLoadingPortRsoVO)rso.get(0)).getLocNm()+"|"  );
	        }else{
	            eventResponse.setUserMessage(new ErrorHandler("SCG50010",new  String[]{"Port Code"} ).getUserMessage());                
	        }
			Map<String,String> etcData = new HashMap<String,String>();
			etcData.put("loc_info", str.toString() );
			eventResponse.setETCData(etcData);
			return eventResponse;
	    } catch (EventException ex) {
	        log.error("error:"+ex.toString(), ex);
	        throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        log.error("error:"+ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Loading Port for RSO"}).getMessage(), ex);
	    }
	
	}
	/**
	 * VOP_SCG-0033 : RSO Dup Check <br>
	 * Loading Port for RSO Retrieve Dup Check
	 * 
	 * @param     Event e
	 * @return    EventResponse response
	 * @exception EventException
	 */		
	private EventResponse searchLoadingPortRSODupChk(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopScg0033Event event = (VopScg0033Event)e;
		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String dupChk = "N";
		
	    try{
			List<GetLoadingPortRsoVO>  rso = command.searchLoadingPortRSODupChk((String)event.getAttribute("loc_cd"));	
			if(rso.size() > 0){
				dupChk = "Y";
			}
			
			Map<String,String> etcData = new HashMap<String,String>();
			etcData.put("dup_chk", dupChk );
			eventResponse.setETCData(etcData);
			return eventResponse;
	    } catch (EventException ex) {
	        log.error("error:"+ex.toString(), ex);
	        throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        log.error("error:"+ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Loading Port for RSO"}).getMessage(), ex);
	    }
	
	}
	/**
	 * VOP_SCG-0035 : RETRIEVE<br>
	 * Target Lane for SPCL CGO APVL retrieve
	 * 
	 * @param  Event e
	 * @return EventResponse  
	 * @exception EventException
	 */
	
	private EventResponse searchApprovalTargetLaneList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
			VopScg0035Event event = (VopScg0035Event)e;  
			SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
			List<MdmVslSvcLaneListVO> list       = command.searchApprovalTargetLaneList( event.getMdmVslSvcLaneListVO() );
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
	//    			if(list.size()==0){
	//    			    eventResponse.setUserMessage(new ErrorHandler("SCG00008").getUserMessage());
	//    			    //eventResponse.setUserMessage( "데이타가 존재하지 않습니다.");			
	//    			}
			return eventResponse;
	    } catch (EventException ex) {
	        log.error("error:"+ex.toString(), ex);
	        throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        log.error("error:"+ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Target Lane for SPCL CGO APVL"}).getMessage(), ex);
	    }
	}	
	/**
	 * VOP_SCG-0053:RETRIEVE<br>
	 * Target Lane for SPCL CGO APVL 
	
	 * @param e VOP_SCG-0053Event
	 * @return EventResponse VOP_SCG-0053EventResponse
	 * @exception EventException
	 */
	
	private EventResponse searchApprovalTargetLaneList(Event e,String gb) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
			VopScg0053Event event = (VopScg0053Event)e;  
			SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
			List<MdmVslSvcLaneListVO> list       = command.searchApprovalTargetLaneList( event.getMdmVslSvcLaneListVO() );
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
	//    			if(list.size()==0){
	//    			    eventResponse.setUserMessage(new ErrorHandler("SCG00008").getUserMessage());
	//    			    //eventResponse.setUserMessage( "데이타가 존재하지 않습니다.");			
	//    			}
			return eventResponse;
	    } catch (EventException ex) {
	        log.error("error:"+ex.toString(), ex);
	        throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        log.error("error:"+ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Target Lane for SPCL CGO APVL"}).getMessage(), ex);
	    }
	}		
	/** 
	 * VOP_SCG-0035: ONCHANGE<br>
	 * Target Lane for SPCL CGO APVL retrieve
	 * 
	 * @param e VOP_SCG-0035Event
	 * @return EventResponse VOP_SCG-0033EventResponse
	 * @exception EventException
	 */
	
	private EventResponse searchApprovalTargetLane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
			VopScg0035Event event = (VopScg0035Event)e;  
			SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
			List<MdmVslSvcLaneListVO> list       = command.searchApprovalTargetLaneList( event.getMdmVslSvcLaneListVO() );
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			StringBuffer str = new StringBuffer();
	
			
			for(int i=0;i<list.size();i++){
				 str.append( ((MdmVslSvcLaneListVO)list.get(i)).getVslSlanCd()+"|" );
				 str.append( ((MdmVslSvcLaneListVO)list.get(i)).getVslSlanNm()+"|" );
				 str.append( ((MdmVslSvcLaneListVO)list.get(i)).getSvcTypeName()+"|" );				 
			} 
			
			Map<String,String> etcData = new HashMap<String,String>();
			etcData.put("VslSlanCd", str.toString() );
			eventResponse.setETCData(etcData);		
	        if(list.size()==0){
	            eventResponse.setUserMessage(new ErrorHandler("SCG50010",new  String[]{"Target Lane"} ).getUserMessage());         
	                }
	 
	    			return eventResponse;
	            } catch (EventException ex) {
	                log.error("error:"+ex.toString(), ex);
	        throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        log.error("error:"+ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Target Lane for SPCL CGO APVL"}).getMessage(), ex);
	    }
	}		
	
	
	/**
	 * VOP_SCG-0035 : SAVE<br>
	 * Target Lane for SPCL CGO APVL save
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
			private EventResponse manageApprovalTargetLane(Event e) throws EventException {
	 
				GeneralEventResponse eventResponse = new GeneralEventResponse();
				VopScg0035Event event = (VopScg0035Event)e;
	
				SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
				try{
					begin();
					
					command.manageApprovalTargetLane( event.getMdmVslSvcLaneListVOS() , account);
	 
	                eventResponse.setUserMessage(  new ErrorHandler("SCG00001", new String[]{"Data"} ).getUserMessage() );
			commit(); 
	    } catch (EventException ex) {
	        log.error("error:"+ex.toString(), ex);
	        rollback();
	        throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        log.error("error:"+ex.toString(), ex);
	        rollback();
	        throw new EventException(new ErrorHandler("COM12192", new String[]{"Target Lane for SPCL CGO APVL"}).getMessage(), ex);
	    }
		return eventResponse;
	}	
	
	/**
	 * VOP_SCG_0042 : Retrieve <br>
	 * Packing Instructions/Provisions (Creation) retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPackingInstructionList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	    try{
			VopScg0042Event event = (VopScg0042Event)e;
			SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
			
			List<ScgImdgPckInstrVO> list = command.searchPackingInstructionList(event.getScgImdgPckInstrVO().getImdgPckInstrCd());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			eventResponse.setRsVoList(list);			
			
			return eventResponse;
	    } catch (EventException ex) {
	        log.error("error:"+ex.toString(), ex);
	        throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        log.error("error:"+ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Packing Instructions/Provisions"}).getMessage(), ex);
	    }
	}
	
	/**
	 * VOP_SCG_0042 : Save <br>
	 * Packing Instructions/Provisions (Creation) save <br>
	 * 
	 * @param Event e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse managePackingInstruction(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0042Event event = (VopScg0042Event)e;
	
		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
		try{
			begin();
			
			command.managePackingInstruction(event.getScgImdgPckInstrVOS(), event.getKeys(), account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			
			commit();
	    } catch (EventException ex) {
	        log.error("error:"+ex.toString(), ex);
	        rollback();
	        throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        log.error("error:"+ex.toString(), ex);
	        rollback();
	        throw new EventException(new ErrorHandler("COM12192", new String[]{"Packing Instructions/Provisions"}).getMessage(), ex);
		        }
				return eventResponse;
			}
	 
	        /**
	 * VOP_SCG_0066 : retrieve<br>
	 * Organic Peroxides & Self-Reactive Substances retrieve <br>
	 * 
	 * @param  Event e
	 * @return EventResponse response 
	 * @exception EventException
	 * @author jkc
	 */
	private EventResponse searchOrganicPeroxideCodeList(Event e) throws EventException {
	    try{
	        SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
	        VopScg0066Event event = (VopScg0066Event)e;            
	        List<ScgImdgUnNoOrgRactVO> list = command.searchOrganicPeroxideCodeList(event.getScgImdgCrrRstrVO().getImdgUnNo());
	        
	        GeneralEventResponse eventResponse = new GeneralEventResponse();
	        eventResponse.setRsVoList(list);
	        return eventResponse;
	    } catch (EventException ex) {
	        log.error("error:"+ex.toString(), ex);
	        throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        log.error("error:"+ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Organic Peroxides & Self-Reactive Substances"}).getMessage(), ex);
	    }
	}	
	/**
	 * VOP_SCG_0073 : retrieve<br>
	 * Special Provisions for Segregation (Creation) Retrieve<br>
	 *
	 * @param  Event e
	 * @throws EventException
	 * @return EventResponse
	 * @author jang kang cheol
	 */
	private EventResponse searchSpecialProvisionSegregationList(Event e) throws EventException {
	    try{
	        SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
	        VopScg0073Event event = (VopScg0073Event)e;   
	        List<ScgImdgSpclProvisVO> list     = command.searchSpecialProvisionSegregationList(event.getImdgsclprovino());
	          
	        GeneralEventResponse eventResponse  = new GeneralEventResponse();
	        eventResponse.setRsVoList(list);
	        return eventResponse;
	    } catch (EventException ex) {
	        log.error("error:"+ex.toString(), ex);
	        throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        log.error("error:"+ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Special Provisions for Segregation"}).getMessage(), ex);
	    }
	
	}   
	/**
	 * VOP_SCG_0073 : save<br>
	 * Special Provisions for Segregation (Creation) Save<br>
	 *
	 * @param  Event e
	 * @throws EventException
	 * @return EventResponse
	 * @author jang kang cheol
	 */
	        private EventResponse manageSpecialProvisionSegregationList(Event e) throws EventException {
	            
	            IMDGCodeMgtBC command = new IMDGCodeMgtBCImpl();
	            VopScg0073Event event = (VopScg0073Event)e;            
	 
	            GeneralEventResponse eventResponse  = new GeneralEventResponse();
	             
	            try{
	                begin();
	                
	                command.manageSpecialProvisionSegregationList( event.getScgImdgSpclProvisVOs(), event.getImdgsclprovino(),this.account.getUsr_id() );
	                String msg = new ErrorHandler("SCG00001", new String[]{"Data"} ).getUserMessage();
	        eventResponse.setUserMessage(  msg  );
	        commit();
	    } catch (EventException ex) {
	        log.error("error:"+ex.toString(), ex);
	        rollback();
	        throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        log.error("error:"+ex.toString(), ex);
	        rollback();
	        throw new EventException(new ErrorHandler("COM12192", new String[]{"Special Provisions for Segregation"}).getMessage(), ex);
	    }          
	    return eventResponse;
	}          
	/**
	 * VOP_SCG_0073 : retrieve<br>
	 * Special Provisions for Segregation (Creation) Subsidiary Get<br>
	 * 
	 * @param  Event e
	 * @throws EventException  
	 * @return EventResponse
	 * @author jang kang cheol
	 */
	    private EventResponse searchSubsidiaryRisks(Event e) throws EventException {
	        try{
	            SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
	
	            
	            VopScg0073Event event = (VopScg0073Event)e;
	            GeneralEventResponse eventResponse  = new GeneralEventResponse();
	  
	            List<ScgImdgSpclProvisVO> list     = command.searchSubsidiaryRisks(event.getImdgunno() , event.getImdgunnoseq()  );
	            
	            eventResponse.setRsVoList(list);
	            return eventResponse;
	        } catch (EventException ex) {
	            log.error("error:"+ex.toString(), ex);
	        throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        log.error("error:"+ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Special Provisions for Segregation"}).getMessage(), ex);
	    }
	}  
	
	/**
	 * VOP_SCG_0077 : Retrieve <br>
	 * Setup mail contents for SPCL CGO application retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSCGMailTamplet(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0077Event event = (VopScg0077Event)e;
		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
	
		try{
			event.getScgMailTampletVO().setEmlSndUsrId(account.getUsr_id());
			
			List<ScgMailTampletVO> scgMailTampletVOs = command.searchSCGMailTamplet(event.getScgMailTampletVO());
	
			eventResponse.setRsVoList(scgMailTampletVOs);
	
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Setup mail contents for SPCL CGO application"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0077 : Save <br>
	 * Setup mail contents for SPCL CGO application modify <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSCGMailTamplet(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		VopScg0077Event event = (VopScg0077Event)e;		
		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
		
		try{
			begin();
			command.manageSCGMailTamplet(event.getScgMailTampletVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			commit();
			
		}catch(EventException ex){
			rollback();
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        rollback();
	        throw new EventException(new ErrorHandler("COM12192", new String[]{"Setup mail contents for SPCL CGO application"}).getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * VOP_SCG_0034  : OnLoad <br>
	 * carrier code retrieve <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchCarrierCode(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0034Event event = (VopScg0034Event)e;	
	    try{
    		SpecialCargoMasterDataMgtBC command = new SpecialCargoMasterDataMgtBCImpl();
    		List<MdmCarrierVO> list = command.searchCarrierCode(event.getScgCntcPntVO().getCrrCd());
    		
    		eventResponse.setRsVoList(list);
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Partner's Contact Point for SPCL CGO"}).getMessage(), ex);
        }
	}
}