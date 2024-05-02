/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralManageSC.java
*@FileTitle : EQ Component
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage;
  
import org.apache.log4j.Logger;

import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.basic.CEDEXCodeMgtBC;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.basic.CEDEXCodeMgtBCImpl;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.event.EesMnr0002Event;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.event.EesMnr0003Event;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.event.EesMnr0004Event;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.event.EesMnr0142Event;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.event.EesMnr0193Event;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.event.EesMnr0225Event;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.integration.CEDEXCodeMgtDBDAO;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.CedexOtherCodeListGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.CodeRelationGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.ComponentCodeListGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.DamageLocationCodeListGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.DivisionCodeGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.RepairCodeFindListGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.dvfactormgt.basic.DVFactorMgtBC;
import com.clt.apps.opus.ees.mnr.generalmanage.dvfactormgt.basic.DVFactorMgtBCImpl;
import com.clt.apps.opus.ees.mnr.generalmanage.dvfactormgt.event.EesMnr0107Event;
import com.clt.apps.opus.ees.mnr.generalmanage.dvfactormgt.vo.DVFactorGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.fqaresultmgt.basic.FQAResultMgtBC;
import com.clt.apps.opus.ees.mnr.generalmanage.fqaresultmgt.basic.FQAResultMgtBCImpl;
import com.clt.apps.opus.ees.mnr.generalmanage.fqaresultmgt.event.EesMnr0029Event;
import com.clt.apps.opus.ees.mnr.generalmanage.fqaresultmgt.event.EesMnr0222Event;
import com.clt.apps.opus.ees.mnr.generalmanage.fqaresultmgt.event.EesMnr0223Event;
import com.clt.apps.opus.ees.mnr.generalmanage.fqaresultmgt.vo.FQAResultMgtGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.fqaresultmgt.vo.MnrFieldQualityAuditResultVO;
import com.clt.apps.opus.ees.mnr.generalmanage.generalcodemgt.basic.GeneralCodeMgtBC;
import com.clt.apps.opus.ees.mnr.generalmanage.generalcodemgt.basic.GeneralCodeMgtBCImpl;
import com.clt.apps.opus.ees.mnr.generalmanage.generalcodemgt.event.EesMnr0009Event;
import com.clt.apps.opus.ees.mnr.generalmanage.generalcodemgt.vo.GeneralCodeMgtGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.hangerinventorymgt.basic.HangerInventoryMgtBC;
import com.clt.apps.opus.ees.mnr.generalmanage.hangerinventorymgt.basic.HangerInventoryMgtBCImpl;
import com.clt.apps.opus.ees.mnr.generalmanage.hangerinventorymgt.event.EesMnr0110Event;
import com.clt.apps.opus.ees.mnr.generalmanage.hangerinventorymgt.event.EesMnr0224Event;
import com.clt.apps.opus.ees.mnr.generalmanage.hangerinventorymgt.vo.HangerInventoryListGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.officegeneralinfomgt.basic.OfficeGeneralInfoMgtBC;
import com.clt.apps.opus.ees.mnr.generalmanage.officegeneralinfomgt.basic.OfficeGeneralInfoMgtBCImpl;
import com.clt.apps.opus.ees.mnr.generalmanage.officegeneralinfomgt.event.EesMnr0010Event;
import com.clt.apps.opus.ees.mnr.generalmanage.officegeneralinfomgt.event.EesMnr0135Event;
import com.clt.apps.opus.ees.mnr.generalmanage.officegeneralinfomgt.event.EesMnr0217Event;
import com.clt.apps.opus.ees.mnr.generalmanage.officegeneralinfomgt.event.EesMnr0239Event;
import com.clt.apps.opus.ees.mnr.generalmanage.officegeneralinfomgt.vo.ColleagueTreeGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.officegeneralinfomgt.vo.CustomMnrOfcGenInfoVO;
import com.clt.apps.opus.ees.mnr.generalmanage.officegeneralinfomgt.vo.OfficeGeneralInfoListGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.basic.PartnerMgtBC;
import com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.basic.PartnerMgtBCImpl;
import com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.event.EesMnr0155Event;
import com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.vo.DisposalPartnerGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.basic.ReeferSparePartMgtBC;
import com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.basic.ReeferSparePartMgtBCImpl;
import com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.event.EesMnr0056Event;
import com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.event.EesMnr0137Event;
import com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.event.EesMnr0198Event;
import com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.event.EesMnr0214Event;
import com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.vo.RFSparePartCodeMgtGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.vo.RFSparePartInventoryMgtGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.warrantymgt.basic.WarrantyMgtBC;
import com.clt.apps.opus.ees.mnr.generalmanage.warrantymgt.basic.WarrantyMgtBCImpl;
import com.clt.apps.opus.ees.mnr.generalmanage.warrantymgt.event.EesMnr0170Event;
import com.clt.apps.opus.ees.mnr.generalmanage.warrantymgt.event.EesMnr0213Event;
import com.clt.apps.opus.ees.mnr.generalmanage.warrantymgt.vo.WarrantyAlertInfoGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.warrantymgt.vo.WarrantyAlertListGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.basic.InterfaceMgtBC;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.basic.InterfaceMgtBCImpl;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrFileAtchVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.InterfaceGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.basic.EQFlagMgtBC;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.basic.EQFlagMgtBCImpl;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
           
/**
 * COM-GeneralManage Business Logic ServiceCommand - COM-GeneralManage handling business transaction
 *  
 * @author    
 * @see CEDEXCodeMgtDBDAO
 * @since J2EE 1.4       
 */
   
public class GeneralManageSC extends ServiceCommandSupport {
	// Login User Information 
	private SignOnUserAccount account = null;
	private Logger log = Logger.getLogger("com.clt.apps.opus.ees.mnr.generalmanage");
	 
	/**
	 * GeneralManage system preceding process for biz scenario<br>
	 * EES_MNR_0003 related objects creation<br>
	 */
	public void doStart() {  
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getMessage(),e);    
		} 
	}

	/**
	 * GeneralManage system biz scenario closing<br>
	 * EES_MNR_0003 clearing related objects<br>
	 */ 
	public void doEnd() {
		log.debug("GeneralManageSC End");
	}
	   
	/**
	 * COM-GeneralManage system <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException 
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null; 

		if (e.getEventName().equalsIgnoreCase("EesMnr0003Event")) {
			//LOCATION CODE 
 			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDamageLocationCodeListService(e);
			}   
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDamageLocationCodeService(e); 
			} 
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0193Event")) {
			//LOCATION POPUP  
 			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDamageLocationCodeListService(e);
			}	
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0002Event")) {
			//Retrieving Combo List, Grid List 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComponentCodeListService(e);
			}
			//Retrieving Pop up Grid List
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCodeRelationListService(e);
			}
			//Save main Grid
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageComponentCodeService(e);
			}
			//Save Popup Grid
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageCodeRelationService(e);
			}  
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0004Event")) {
			//Retrieving Combo List, Grid List 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCedexOtherCodeListService(e);
			}//Save Grid   
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCedexOtherCodeService(e);  
			}      
		//MNR Other Code
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0009Event")) {
			//Retrieving Combo, Grid List 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGeneralCodeListService(e);
			}//Save Grid      
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageGeneralCodeService(e);  
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGeneralCodeService(e);
			}     
		//FQAResultMgt
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0029Event")) {
			//Retrieving Combo, Grid List 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFQAResultListService(e);
			}//Save Grid   
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageFQAResultService(e);  
			}
			else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeFQAResultService(e);  
			}    
		//DV Factor
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0107Event")) {
			//Retrieving 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDVFactorListService(e);
			}//Save
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDVFactorService(e);  
			}        
		//Warranty alert POP-UP
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0213Event")) {
			//Retrieving   
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 
				eventResponse = searchWarrantyAlertInfoService(e);
			}             
			
		//OfficeGeneralInfoMgtBC
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0217Event")) {
			//Retrieving  
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 
				eventResponse = searchColleagueTreeListService(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageColleagueTreeListService(e);
			}
		//Reefer Unit Warranty Period 	
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0170Event")) {
			//Retrieving       
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchWarrantyAlertListService(e);
			}//saving   
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageWarrantyAlertService(e);  
			} 
		//Disposal Buyer Management
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0155Event")) {
			//Retrieving       
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalPartnerListService(e);
			}//saving
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDisposalPartnerService(e);  
			}//deleting		
			else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeDisposalPartnerService(e); 
			} 
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDupDSPBuyerService(e);
			} 			
		//RepairCodeFindListBC - popup
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0142Event")) {
			//Retrieving  
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 
				eventResponse = searchRepairCodeFindListService(e);
			}	
		//Repair Approval Authority
	   } else if (e.getEventName().equalsIgnoreCase("EesMnr0010Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 
				eventResponse = searchOfficeGeneralInfoListService(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageOfficeGeneralInfoListService(e);
			}
		//Equipment Repair Approval Authority Inquiry
	   } else if (e.getEventName().equalsIgnoreCase("EesMnr0135Event")) {
		
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 
				eventResponse = searchOfficeGeneralInfoListService(e);
			}
		//Hanger Bar Inventory List
	   } else if (e.getEventName().equalsIgnoreCase("EesMnr0110Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchHangerInventoryListService(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageHangerInventoryService(e);
			}
	   // Reefer Spare Parts List
	   } else if (e.getEventName().equalsIgnoreCase("EesMnr0056Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 
				eventResponse = searchRFSparePartInventoryListService(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageRFSparePartInventoryService(e);
			}				
	   // Reefer Spare Parts List
	   } else if (e.getEventName().equalsIgnoreCase("EesMnr0137Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 
				eventResponse = searchRFsparePartCodeListService(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageRFsparePartCodeService(e);
			}			
	   // Reefer Spare Parts List
	   } else if (e.getEventName().equalsIgnoreCase("EesMnr0214Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 
				eventResponse = searchRFsparePartCodeListService(e);
			}	
	   // Reefer Spare Parts List
	   } else if (e.getEventName().equalsIgnoreCase("EesMnr0198Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 
				eventResponse = searchRFsparePartCodeListService(e);
			}
	   //Division Code Creation     	
	   } else if (e.getEventName().equalsIgnoreCase("EesMnr0225Event")) { 
		   if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 
				eventResponse = searchDivisionCodeListService(e);
		   } else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageDivisionCodeService(e);
		   }    
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0222Event")) {
			//retrieving Combo, retrieving grid 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFQAListService(e);
			}    
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0223Event")) {
			//retrieving Combo, retrieving grid 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFQAResultListService(e);
			}
		//Hanger Bar Inventory History Pop Up
	   } else if (e.getEventName().equalsIgnoreCase("EesMnr0224Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 
				eventResponse = searchHangerInventoryDetailListService(e);
			}
		//Office Control Info
	   } else if (e.getEventName().equalsIgnoreCase("EesMnr0239Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 
				eventResponse = searchOfficeGeneralInfoListService(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageOfficeGeneralInfoListService(e);
			}
	   }
		return eventResponse;    
	}	 
	
	/**
	 * EES_MNR_0225 : Retrieve <br>
	 * [EES_MNR_0225]Retrieving Division Code Creation <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDivisionCodeListService(Event e) throws EventException {
		EesMnr0225Event event = (EesMnr0225Event)e; 
		CEDEXCodeMgtBC command = new CEDEXCodeMgtBCImpl();  
		DivisionCodeGRPVO divisionCodeGRPVO = event.getDivisionCodeGRPVO();
		
		divisionCodeGRPVO = command.searchDivisionCodeListBasic(divisionCodeGRPVO,account);  
		GeneralEventResponse eventResponse = new GeneralEventResponse();          
		eventResponse.setRsVoList(divisionCodeGRPVO.getListCustomMnrCdRltVOS()); 
		     
		return eventResponse;      
	}
	
	/**
	 * EES_MNR_0225 : Save <br>
	 * [EES_MNR_0225] adding/modification/deletion Division Code Creation. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDivisionCodeService(Event e) throws EventException {
		EesMnr0225Event event = (EesMnr0225Event)e; 
		CEDEXCodeMgtBC command = new CEDEXCodeMgtBCImpl();  
		DivisionCodeGRPVO divisionCodeGRPVO = event.getDivisionCodeGRPVO();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		try{
			begin();
			command.manageDivisionCodeBasic(divisionCodeGRPVO, account);
			commit();  
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		} 
		return eventResponse;  
	}
	
	/**
	 * EES_MNR_0010 : Save <br>
	 * [EES_MNR_0010] adding/modification/deletion Repair Approval Authority. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageOfficeGeneralInfoListService(Event e) throws EventException {
		
		OfficeGeneralInfoMgtBC command = new OfficeGeneralInfoMgtBCImpl();  
		OfficeGeneralInfoListGRPVO  officeGeneralInfoListGRPVO = new OfficeGeneralInfoListGRPVO();
		
		if (e.getEventName().equalsIgnoreCase("EesMnr0010Event")) {
			EesMnr0010Event event = (EesMnr0010Event)e; 
			officeGeneralInfoListGRPVO = event.getOfficeGeneralInfoListGRPVO();

			CustomMnrOfcGenInfoVO[] arrCustomMnrOfcGenInfoVOs = officeGeneralInfoListGRPVO.getArrCustomMnrOfcGenInfoVO();
			for ( int i = 0; i < arrCustomMnrOfcGenInfoVOs.length; i++ ) {
				arrCustomMnrOfcGenInfoVOs[i].setMnrGrpTpCd("RPR");
			}
			
			officeGeneralInfoListGRPVO.setArrCustomMnrOfcGenInfoVO(arrCustomMnrOfcGenInfoVOs);
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0239Event")) {
			EesMnr0239Event event = (EesMnr0239Event)e; 
			officeGeneralInfoListGRPVO = event.getOfficeGeneralInfoListGRPVO();
			
			CustomMnrOfcGenInfoVO[] arrCustomMnrOfcGenInfoVOs = officeGeneralInfoListGRPVO.getArrCustomMnrOfcGenInfoVO();
			for ( int i = 0; i < arrCustomMnrOfcGenInfoVOs.length; i++ ) {
				arrCustomMnrOfcGenInfoVOs[i].setMnrGrpTpCd("OFC");
			}
			
			officeGeneralInfoListGRPVO.setArrCustomMnrOfcGenInfoVO(arrCustomMnrOfcGenInfoVOs);
		}
		
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		
		try{
			begin();
			command.manageOfficeGeneralInfoListBasic(officeGeneralInfoListGRPVO, account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;  
	}
	
	/**
	 * EES_MNR_0135 : Retrieve <br>
	 * [EES_MNR_0135]Retrieving Repair Approval Authority. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeGeneralInfoListService(Event e) throws EventException {

		OfficeGeneralInfoMgtBC command = new OfficeGeneralInfoMgtBCImpl();  
		OfficeGeneralInfoListGRPVO  officeGeneralInfoListGRPVO = new OfficeGeneralInfoListGRPVO();
		
		if(e.getEventName().equalsIgnoreCase("EesMnr0010Event"))
		{
			EesMnr0010Event event = (EesMnr0010Event)e; 
			officeGeneralInfoListGRPVO = event.getOfficeGeneralInfoListGRPVO();
			officeGeneralInfoListGRPVO.getOfficeGeneralInfoMgtINVO().setMnrGrpTpCd("RPR");
		}
		else if(e.getEventName().equalsIgnoreCase("EesMnr0135Event"))
		{
			EesMnr0135Event event = (EesMnr0135Event)e; 
			officeGeneralInfoListGRPVO = event.getOfficeGeneralInfoListGRPVO();
			officeGeneralInfoListGRPVO.getOfficeGeneralInfoMgtINVO().setMnrGrpTpCd("RPR");
		}
		else if(e.getEventName().equalsIgnoreCase("EesMnr0239Event"))
		{
			EesMnr0239Event event = (EesMnr0239Event)e; 
			officeGeneralInfoListGRPVO = event.getOfficeGeneralInfoListGRPVO();
			officeGeneralInfoListGRPVO.getOfficeGeneralInfoMgtINVO().setMnrGrpTpCd("OFC");
		}

		officeGeneralInfoListGRPVO = command.searchOfficeGeneralInfoListBasic(officeGeneralInfoListGRPVO);  
		GeneralEventResponse eventResponse = new GeneralEventResponse();          
		eventResponse.setRsVoList(officeGeneralInfoListGRPVO.getCustomMnrOfcGenInfoVOS());
		     
		return eventResponse;      
	}
	
	/**
	 * EES_MNR_0142 : Retrieve <br>
	 * [EES_MNR_0142]Retrieving Pop Up_Tariff Code Finding. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRepairCodeFindListService(Event e) throws EventException {
		EesMnr0142Event event = (EesMnr0142Event)e; 
		CEDEXCodeMgtBC command = new CEDEXCodeMgtBCImpl(); 
		RepairCodeFindListGRPVO repairCodeFindListGRPVO = event.getRepairCodeFindListGRPVO();
		repairCodeFindListGRPVO = command.searchRepairCodeFindListBasic(repairCodeFindListGRPVO);
  
		GeneralEventResponse eventResponse = new GeneralEventResponse();          
		eventResponse.setRsVoList(repairCodeFindListGRPVO.getCustomMnrEqCmpoCdVOS());
		     
		return eventResponse;      
	}
	
	/**
	 * EES_MNR_0217 : Save <br>
	 * [EES_MNR_0217] adding/modification/deletion M&R Colleague Tree. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageColleagueTreeListService(Event e) throws EventException {
		EesMnr0217Event event = (EesMnr0217Event)e; 
		OfficeGeneralInfoMgtBC command = new OfficeGeneralInfoMgtBCImpl();  
		ColleagueTreeGRPVO officeGeneralInfoMgtGRPVO = event.getColleagueTreeGRPVO();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		try{
			
			begin();
			command.manageColleagueTreeBasic(officeGeneralInfoMgtGRPVO, account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;  
	}
	
	/**
	 * EES_MNR_0217 : Retrieve <br>
	 * [EES_MNR_0217]Retrieving M&R Colleague Tree. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */ 
	private EventResponse searchColleagueTreeListService(Event e) throws EventException {
		EesMnr0217Event event = (EesMnr0217Event)e; 
		OfficeGeneralInfoMgtBC command = new OfficeGeneralInfoMgtBCImpl();  
		
		ColleagueTreeGRPVO officeGeneralInfoMgtGRPVO = event.getColleagueTreeGRPVO();
 
		officeGeneralInfoMgtGRPVO = command.searchColleagueTreeListBasic(officeGeneralInfoMgtGRPVO);  
		GeneralEventResponse eventResponse = new GeneralEventResponse();          
		eventResponse.setRsVoList(officeGeneralInfoMgtGRPVO.getCustomMnrOfcCntcPsonVOS());
		     
		return eventResponse;      
	}
	/**
	 * EES_MNR_0213 : Retrieve <br>
	 * [EES_MNR_0213]Retrieving Warranty Alert_Pop Up. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWarrantyAlertInfoService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0213Event event = (EesMnr0213Event)e; 
		WarrantyMgtBC command = new WarrantyMgtBCImpl();  
		WarrantyAlertInfoGRPVO warrantyAlertInfoGRPVO = new WarrantyAlertInfoGRPVO();
		warrantyAlertInfoGRPVO.setWarrantyAlertInfoINVO((event.getWarrantyAlertInfoINVO())); 
		warrantyAlertInfoGRPVO = command.searchWarrantyAlertInfoBasic(warrantyAlertInfoGRPVO);  
		GeneralEventResponse eventResponse = new GeneralEventResponse();          
		eventResponse.setRsVoList(warrantyAlertInfoGRPVO.getCustomMnrEqRngStsVOS());
		     
		return eventResponse;      
	} 
	
	/**
	 * EES_MNR_0004 : Retrieve <br>
	 * [EES_MNR_0004]Retrieving Damage Type. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCedexOtherCodeListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0004Event event = (EesMnr0004Event)e;
		CEDEXCodeMgtBC command = new CEDEXCodeMgtBCImpl(); 
		CedexOtherCodeListGRPVO cedexOtherCodeListGRPVO = new CedexOtherCodeListGRPVO();
		cedexOtherCodeListGRPVO.setCedexOtherCodeListINVO((event.getCedexOtherCodeListINVO())); 
		cedexOtherCodeListGRPVO = command.searchCedexOtherCodeListBasic(cedexOtherCodeListGRPVO);  
		GeneralEventResponse eventResponse = new GeneralEventResponse();   
		eventResponse.setRsVoList(cedexOtherCodeListGRPVO.getCustomMnrCedexOtrCdVOS());
		
		return eventResponse;     
	}  
	
	/**
	 * EES_MNR_0004 : Save <br>
	 * [EES_MNR_0004] adding/modification/deletion Damage Type. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCedexOtherCodeService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0004Event event = (EesMnr0004Event)e;
		CEDEXCodeMgtBC command = new CEDEXCodeMgtBCImpl(); 
		         				  
		try{       
			begin();                   
			CedexOtherCodeListGRPVO cedexOtherCodeListGRPVO = new CedexOtherCodeListGRPVO(); 
			cedexOtherCodeListGRPVO.setArrCustomMnrCedexOtrCdVOS(event.getCustomMnrCedexOtrCdVOS());
			command.manageCedexOtherCodeListBasic(cedexOtherCodeListGRPVO,account);  
			commit();                  
		}catch(EventException ex){ 
			rollback();   
			throw ex; 
		}catch(Exception ex){
			rollback(); 
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	     
	/**
	 * EES_MNR_0003 : Save <br>
	 * [EES_MNR_0003] adding/modification/deletion Damage Location. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDamageLocationCodeService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0003Event event = (EesMnr0003Event)e;
		CEDEXCodeMgtBC command = new CEDEXCodeMgtBCImpl(); 
		       				  
		try{      
			begin();                   
			DamageLocationCodeListGRPVO damageLocationCodeListGRPVO = new DamageLocationCodeListGRPVO(); 
			damageLocationCodeListGRPVO.setArrCustomMnrEqLocCdVOS(event.getCustomMnrEqLocCdVOS());
			command.manageDamageLocationCodeBasic(damageLocationCodeListGRPVO,account);  
			commit();                 
		}catch(EventException ex){ 
			rollback();  
			throw ex; 
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_MNR_0193 : Retrieve <br>
	 * [EES_MNR_0193]Retrieving Location Code Inquiry_Pop Up. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDamageLocationCodeListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CEDEXCodeMgtBC command = new CEDEXCodeMgtBCImpl();
		DamageLocationCodeListGRPVO damageLocationCodeListGRPVO = new DamageLocationCodeListGRPVO();
		if(e.getEventName().equals("EesMnr0003Event")){
			EesMnr0003Event event = (EesMnr0003Event)e;
			damageLocationCodeListGRPVO.setDamageLocationCodeListINVO((event.getDamageLocationCodeListINVO())); 
		} else {
			EesMnr0193Event event = (EesMnr0193Event)e;
			damageLocationCodeListGRPVO.setDamageLocationCodeListINVO((event.getDamageLocationCodeListINVO())); 
		}	
			
		damageLocationCodeListGRPVO = command.searchDamageLocationCodeListBasic(damageLocationCodeListGRPVO);  
		GeneralEventResponse eventResponse = new GeneralEventResponse();  
			
		for (int i = 0; i < damageLocationCodeListGRPVO.getListCustomMnrEqLocCdVOS().size(); i++) {
			eventResponse.setRsVoList(damageLocationCodeListGRPVO.getListCustomMnrEqLocCdVOS().get(i));
		}       
		return eventResponse;      
	}  
	
	/**
	 * EES_MNR_0002 : Retrieve <br>
	 * [EES_MNR_0002]Retrieving EQ Component. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComponentCodeListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0002Event event = (EesMnr0002Event)e;
		CEDEXCodeMgtBC command = new CEDEXCodeMgtBCImpl();
		ComponentCodeListGRPVO componentCodeListGRPVO = new ComponentCodeListGRPVO();
		componentCodeListGRPVO.setComponentCodeListINVO(event.getComponentCodeListINVO());
		componentCodeListGRPVO = command.searchComponentCodeListBasic(componentCodeListGRPVO); 
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		//Retrieving multiple search
		for (int i = 0; i < componentCodeListGRPVO.getListCustomMnrEqCmpoCdVOS().size(); i++) {
		    eventResponse.setRsVoList(componentCodeListGRPVO.getListCustomMnrEqCmpoCdVOS().get(i));
		} 
		return eventResponse;
	}
	/**
	 * EES_MNR_0002 : Save <br>
	 * [EES_MNR_0002] adding/modification/deletion EQ Component. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageComponentCodeService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0002Event event = (EesMnr0002Event)e;  
		CEDEXCodeMgtBC command = new CEDEXCodeMgtBCImpl();   
		      
		try{
			begin();  
			ComponentCodeListGRPVO componentCodeListGRPVO = new ComponentCodeListGRPVO();
			componentCodeListGRPVO.setCustomMnrEqCmpoCdVOs(event.getCustomMnrEqCmpoCdVOS());
			command.manageComponentCodeBasic(componentCodeListGRPVO,account);
			commit(); 
		}catch(EventException ex){ 
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	/**
	 * EES_MNR_0145 : Retrieve <br>
	 * [EES_MNR_0145]Retrieving EQ Component Grouping by Location & Damage Type. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCodeRelationListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0002Event event = (EesMnr0002Event)e;
		CEDEXCodeMgtBC command = new CEDEXCodeMgtBCImpl();
		CodeRelationGRPVO codeRelationGRPVO = new CodeRelationGRPVO();
		codeRelationGRPVO.setCodeRelationINVO(event.getCodeRelationINVO());
		codeRelationGRPVO = command.searchCodeRelationListBasic(codeRelationGRPVO); 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
			
		//Retrieving multiple search				
		eventResponse.setRsVoList(codeRelationGRPVO.getListCustomMnrCdRltByLocVO());
		eventResponse.setRsVoList(codeRelationGRPVO.getListCustomMnrCdRltByDmgVO());;
		eventResponse.setRsVoList(codeRelationGRPVO.getListCustomMnrCdRltByRprVO());;

		return eventResponse;
	}
	/**
	 * EES_MNR_0145 : Save <br>
	 * [EES_MNR_0145] adding/modification/deletion EQ Component Grouping by Location & Damage Type. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCodeRelationService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0002Event event = (EesMnr0002Event)e;  
		CEDEXCodeMgtBC command = new CEDEXCodeMgtBCImpl();   
		      
		try{ 	
			begin();   	
			CodeRelationGRPVO codeRelationGRPVO = new CodeRelationGRPVO();
			codeRelationGRPVO.setCustomMnrCdRltByLocVOS(event.getCustomMnrCdRltByLocVOS());
			command.manageCodeRelationBasic(codeRelationGRPVO,account);
			commit();	 
		}catch(EventException ex){ 
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	/**
	 * EES_MNR_0009 : Retrieve <br>
	 * [EES_MNR_0009]Retrieving M&R Other Code. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGeneralCodeListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0009Event event = (EesMnr0009Event)e;
		GeneralCodeMgtBC command = new GeneralCodeMgtBCImpl();
		GeneralCodeMgtGRPVO generalCodeMgtGRPVO = new GeneralCodeMgtGRPVO();
		generalCodeMgtGRPVO.setGeneralCodeMgtINVO(event.getGeneralCodeMgtINVO());
		
		generalCodeMgtGRPVO = command.searchGeneralCodeListBasic(generalCodeMgtGRPVO); 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		//Retrieving multiple search
		for (int i = 0; i < generalCodeMgtGRPVO.getListCustomMnrGenCdVOs().size(); i++) {
		    eventResponse.setRsVoList(generalCodeMgtGRPVO.getListCustomMnrGenCdVOs().get(i));
		}

		return eventResponse;
	}
	
	/**
	 * EES_MNR_0009 : Retrieve01 <br>
	 * [EES_MNR_0009]Retrieving M&R Other Code. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGeneralCodeService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0009Event event = (EesMnr0009Event)e;
		GeneralCodeMgtBC command = new GeneralCodeMgtBCImpl();
		GeneralCodeMgtGRPVO generalCodeMgtGRPVO = new GeneralCodeMgtGRPVO();
		generalCodeMgtGRPVO.setGeneralCodeMgtINVO(event.getGeneralCodeMgtINVO());
		
		generalCodeMgtGRPVO = command.searchGeneralCodeBasic(generalCodeMgtGRPVO); 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		eventResponse.setRsVoList(generalCodeMgtGRPVO.getListCustomMnrGenCdVOs().get(0));

		return eventResponse;
	}
	
	/**
	 * EES_MNR_0009 : Save <br>
	 * [EES_MNR_0009] adding/modification/deletion M&R Other Code. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageGeneralCodeService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0009Event event = (EesMnr0009Event)e;  
		GeneralCodeMgtBC command = new GeneralCodeMgtBCImpl();   
		      
		try{
			begin();  
			GeneralCodeMgtGRPVO generalCodeMgtGRPVO = new GeneralCodeMgtGRPVO();
			generalCodeMgtGRPVO.setArrayCustomMnrGenCdVOs(event.getCustomMnrGenCdVOs());
			command.manageGeneralCodeBasic(generalCodeMgtGRPVO,account);
			commit(); 
		}catch(EventException ex){ 
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	/**
	 * EES_MNR_0223 : Retrieve <br>
	 * [EES_MNR_0223]Retrieving FQA Result Detail Pop Up. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFQAResultListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		FQAResultMgtBC command = new FQAResultMgtBCImpl(); 
		InterfaceMgtBC command2 = new  InterfaceMgtBCImpl();
		
		FQAResultMgtGRPVO fQAResultMgtGRPVO = new FQAResultMgtGRPVO();
		if (e.getEventName().equalsIgnoreCase("EesMnr0223Event")) {
			EesMnr0223Event event = (EesMnr0223Event)e;
			fQAResultMgtGRPVO.setFQAResultMgtINVO((event.getFQAResultMgtINVO())); 
		}else{
			EesMnr0029Event event = (EesMnr0029Event)e;
			fQAResultMgtGRPVO.setFQAResultMgtINVO((event.getFQAResultMgtINVO())); 
		}
		
		fQAResultMgtGRPVO = command.searchFQAResultListBasic(fQAResultMgtGRPVO);  
		
		
		String fileSeq ="";
		MnrFieldQualityAuditResultVO mnrFieldQualityAuditResultVO = new MnrFieldQualityAuditResultVO();
		
		for (int i = 0; i < fQAResultMgtGRPVO.getMnrFieldQualityAuditResultVOS().size(); i++) {
			mnrFieldQualityAuditResultVO = (MnrFieldQualityAuditResultVO)fQAResultMgtGRPVO.getMnrFieldQualityAuditResultVOS().get(i);
			if (!mnrFieldQualityAuditResultVO.getFileSeq().equals("0")){
				fileSeq = mnrFieldQualityAuditResultVO.getFileSeq();
				break;
			}
		}
		InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
		interfaceGRPVO = command2.searchFileUploadBasic(fileSeq, account);
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(fQAResultMgtGRPVO.getMnrFieldQualityAuditResultVOS());
		eventResponse.setRsVoList(interfaceGRPVO.getListCustomMnrFileAtchVOs());
			       	
		return eventResponse;     
	}  
	/**
	 * EES_MNR_0029 : Save <br>
	 * [EES_MNR_0029] adding/modification/deletion FQA Result Creation. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageFQAResultService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0029Event event = (EesMnr0029Event)e;
		FQAResultMgtBC command = new FQAResultMgtBCImpl(); 
		InterfaceMgtBC command2 = new  InterfaceMgtBCImpl(); 
		
		try{       
			begin();                   
			FQAResultMgtGRPVO fQAResultMgtGRPVO = new FQAResultMgtGRPVO(); 
			fQAResultMgtGRPVO.setFQAResultMgtINVO((event.getFQAResultMgtINVO()));
			fQAResultMgtGRPVO.setMnrFieldQualityAuditResultVOs(event.getMnrFieldQualityAuditResultVOS());
			command.manageFQAResultBasic(fQAResultMgtGRPVO, account); 
			
			InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
			interfaceGRPVO.setCustomMnrFileAtchVOs(event.getCustomMnrFileAtchVOs());

			CustomMnrFileAtchVO[] customMnrFileAtchVOs = interfaceGRPVO.getCustomMnrFileAtchVOs();
			if(customMnrFileAtchVOs != null){
				String delChk="";
				CustomMnrFileAtchVO[] newCustomMnrFileAtchVOs = new CustomMnrFileAtchVO[customMnrFileAtchVOs.length];
				for ( int i=0; i<customMnrFileAtchVOs.length; i++ ) {
					CustomMnrFileAtchVO customMnrFileAtchVO = new CustomMnrFileAtchVO();
					if (customMnrFileAtchVOs[i].getIbflag().equals("D")){
						customMnrFileAtchVO.setFileSeq(customMnrFileAtchVOs[i].getFileSeq());
						customMnrFileAtchVO.setFileDtlSeq(customMnrFileAtchVOs[i].getFileDtlSeq());
						delChk="Y";
					}
					newCustomMnrFileAtchVOs[i] = customMnrFileAtchVO;
				}
				if(delChk.equals("Y")){
					interfaceGRPVO.setCustomMnrFileAtchVOs(newCustomMnrFileAtchVOs);
					command2.removeFileUploadBasic(interfaceGRPVO, account);
				}
			}

			commit();                 
		}catch(EventException ex){ 
			rollback();  
			throw ex; 
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * EES_MNR_0029 : Delete <br>
	 * [EES_MNR_0029] deleting FQA Result Creation. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeFQAResultService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0029Event event = (EesMnr0029Event)e;
		FQAResultMgtBC command = new FQAResultMgtBCImpl(); 
		InterfaceMgtBC command2 = new  InterfaceMgtBCImpl(); 
		
		try{       
			begin();                   
			FQAResultMgtGRPVO fQAResultMgtGRPVO = new FQAResultMgtGRPVO(); 
			fQAResultMgtGRPVO.setMnrFieldQualityAuditResultVOs(event.getMnrFieldQualityAuditResultVOS());
			fQAResultMgtGRPVO.setFQAResultMgtINVO(event.getFQAResultMgtINVO());

			command.removeFQAResultBasic(fQAResultMgtGRPVO, account);  
			
			String fileSeq ="";
			MnrFieldQualityAuditResultVO[] mnrFieldQualityAuditResultVO = fQAResultMgtGRPVO.getArrayMnrFieldQualityAuditResultVOs();
			if(mnrFieldQualityAuditResultVO != null){
				for ( int i=0; i<mnrFieldQualityAuditResultVO.length; i++ ) {
					if (!mnrFieldQualityAuditResultVO[i].getFileSeq().equals("0")){
						fileSeq = mnrFieldQualityAuditResultVO[i].getFileSeq();
						break;
					}
				}

			}
			command2.removeFileUploadAllBasic(fileSeq, account);
			commit(); 
                
		}catch(EventException ex){ 
			rollback();  
			throw ex; 
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * EES_MNR_0107 : Retrieve <br>
	 * [EES_MNR_0107]Retrieving DV Factor. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDVFactorListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0107Event event = (EesMnr0107Event)e;
		DVFactorMgtBC command = new DVFactorMgtBCImpl();
		DVFactorGRPVO dVFactorGRPVO = new DVFactorGRPVO();
		dVFactorGRPVO.setDVFactorINVO(event.getDVFactorINVO());
		dVFactorGRPVO = command.searchDVFactorListBasic(dVFactorGRPVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		// Retrieving multiple search
		for (int i = 0; i < dVFactorGRPVO.getListCustomMnrEqDpcVOs().size(); i++) {
		    eventResponse.setRsVoList(dVFactorGRPVO.getListCustomMnrEqDpcVOs().get(i));
		}

		return eventResponse;
	} 
	/**
	 * EES_MNR_0107 : Save <br>
	 * [EES_MNR_0107] adding/modification/deletion DV Factor. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDVFactorService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0107Event event = (EesMnr0107Event)e;  
		DVFactorMgtBC command = new DVFactorMgtBCImpl();   
		
		try{
			begin();  
			
			DVFactorGRPVO dVFactorGRPVO = new DVFactorGRPVO();
			dVFactorGRPVO.setArrayCustomMnrEqDpcVOs(event.getCustomMnrEqDpcVOs());
			command.manageDVFactorBasic(dVFactorGRPVO,account);
			
			commit(); 
		}catch(EventException ex){ 
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}	
	
	/**
	 * EES_MNR_0170 : Retrieve <br>
	 * [EES_MNR_0170]Retrieving Reefer Unit Warranty Period. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWarrantyAlertListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0170Event event = (EesMnr0170Event)e;
		WarrantyMgtBC command = new WarrantyMgtBCImpl();
		WarrantyAlertListGRPVO warrantyAlertListGRPVO = new WarrantyAlertListGRPVO();
		warrantyAlertListGRPVO.setWarrantyAlertListINVO(event.getWarrantyAlertListINVO());
		warrantyAlertListGRPVO = command.searchWarrantyAlertListBasic(warrantyAlertListGRPVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	    eventResponse.setRsVoList(warrantyAlertListGRPVO.getCustomWarrantyAlertListVOS());
		    
		return eventResponse;
	}   
	 
	/**
	 * EES_MNR_0170 : Save <br>
	 * [EES_MNR_0170] adding/modification/deletion Reefer Unit Warranty Period. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageWarrantyAlertService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0170Event event = (EesMnr0170Event)e;  
		EQFlagMgtBC command = new EQFlagMgtBCImpl();   
		   
		try{
			begin();    
			 
			WarrantyAlertListGRPVO warrantyAlertListGRPVO = new WarrantyAlertListGRPVO();
			warrantyAlertListGRPVO.setArrCustomWarrantyAlertListVOS(event.getCustomWarrantyAlertListVOs());
			command.manageWarrantyAlertBasic(warrantyAlertListGRPVO, account);
			   
			commit(); 
		}catch(EventException ex){ 
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_MNR_0110 : Retrieve <br>
	 * [EES_MNR_0110]Retrieving Hanger Bar Inventory List. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHangerInventoryListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0110Event event = (EesMnr0110Event)e;
		HangerInventoryMgtBC command = new HangerInventoryMgtBCImpl();
		HangerInventoryListGRPVO hangerInventoryListGRPVO = new HangerInventoryListGRPVO();

		hangerInventoryListGRPVO.setHangerInventoryListINVO(event.getHangerInventoryListINVO());


		hangerInventoryListGRPVO = command.searchHangerInventoryListBasic(hangerInventoryListGRPVO, account);
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		eventResponse.setRsVoList(hangerInventoryListGRPVO.getCustomHangerInventoryListVOs());


		return eventResponse;
	}

	/**
	 * EES_MNR_0110 : Save <br>
	 * [EES_MNR_0110] adding/modification/deletion Hanger Bar Inventory List. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageHangerInventoryService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0110Event event = (EesMnr0110Event)e;
		HangerInventoryMgtBC command = new HangerInventoryMgtBCImpl();

		try{
			begin();
			HangerInventoryListGRPVO hangerInventoryListGRPVO = new HangerInventoryListGRPVO();

			hangerInventoryListGRPVO.setArrCustomHangerInventoryListVOs(event.getCustomHangerInventoryListVOs());

			command.manageHangerInventoryBasic(hangerInventoryListGRPVO, account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_MNR_0214 : Retrieve <br>
	 * [EES_MNR_0214]Retrieving Vessel Reefer Spare Part Purchase W/O Creation. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRFsparePartCodeListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)

		
		ReeferSparePartMgtBC command = new ReeferSparePartMgtBCImpl();
		RFSparePartCodeMgtGRPVO rfSparePartCodeMgtGRPVO = new RFSparePartCodeMgtGRPVO();
		
		if(e.getEventName().equalsIgnoreCase("EesMnr0137Event")){
			EesMnr0137Event event = (EesMnr0137Event)e;
			rfSparePartCodeMgtGRPVO.setRFSparePartCodeMgtINVO(event.getRFSparePartCodeMgtINVO());
		}else if(e.getEventName().equalsIgnoreCase("EesMnr0214Event")){
			EesMnr0214Event event = (EesMnr0214Event)e;
			rfSparePartCodeMgtGRPVO.setRFSparePartCodeMgtINVO(event.getRFSparePartCodeMgtINVO());
		}else if(e.getEventName().equalsIgnoreCase("EesMnr0198Event")){
			EesMnr0198Event event = (EesMnr0198Event)e;
			rfSparePartCodeMgtGRPVO.setRFSparePartCodeMgtINVO(event.getRFSparePartCodeMgtINVO());
		}
		rfSparePartCodeMgtGRPVO = command.searchRFsparePartCodeListBasic(rfSparePartCodeMgtGRPVO); 
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		eventResponse.setRsVoList(rfSparePartCodeMgtGRPVO.getMnrReeferSparePartCodeVOs());
		

		return eventResponse;
	}
	/**
	 * EES_MNR_0137 : Save <br>
	 * [EES_MNR_0137] adding/modification/deletion Standard Reefer Spare Parts List of the vsl. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRFsparePartCodeService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0137Event event = (EesMnr0137Event)e;  
		ReeferSparePartMgtBC command = new ReeferSparePartMgtBCImpl();   
		      
		try{
			begin();  
			RFSparePartCodeMgtGRPVO rfSparePartCodeMgtGRPVO = new RFSparePartCodeMgtGRPVO();
			rfSparePartCodeMgtGRPVO.setArrayMnrReeferSparePartCodeVOs(event.getMnrReeferSparePartCodeVOs());
			command.manageRFsparePartCodeBasic(rfSparePartCodeMgtGRPVO, account);
			commit(); 
		}catch(EventException ex){ 
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}	
	
	/**
	 * EES_MNR_0056 : Retrieve <br>
	 * [EES_MNR_0056]Retrieving VSL Reefer Spare part Inventory. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRFSparePartInventoryListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)

		
		ReeferSparePartMgtBC command = new ReeferSparePartMgtBCImpl();
		RFSparePartInventoryMgtGRPVO rfSparePartInventoryMgtGRPVO = new RFSparePartInventoryMgtGRPVO();

		EesMnr0056Event event = (EesMnr0056Event)e;
		rfSparePartInventoryMgtGRPVO.setRFSparePartInventoryMgtINVO(event.getRFSparePartInventoryMgtINVO());

		rfSparePartInventoryMgtGRPVO = command.searchRFSparePartInventoryListBasic(rfSparePartInventoryMgtGRPVO); 
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		eventResponse.setRsVoList(rfSparePartInventoryMgtGRPVO.getRFSparePartInventoryListVOs());
		

		return eventResponse;
	}
	/**
	 * EES_MNR_0056 : Save <br>
	 * [EES_MNR_0056] adding/modification/deletion VSL Reefer Spare part Inventory. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRFSparePartInventoryService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0056Event event = (EesMnr0056Event)e;  
		ReeferSparePartMgtBC command = new ReeferSparePartMgtBCImpl();   
		      
		try{
			begin();  
			RFSparePartInventoryMgtGRPVO rfSparePartInventoryMgtGRPVO = new RFSparePartInventoryMgtGRPVO();
			
			rfSparePartInventoryMgtGRPVO.setArrayRFSparePartInventoryListVOs(event.getRFSparePartInventoryListVOs());
			
			command.manageRFSparePartInventoryBasic(rfSparePartInventoryMgtGRPVO, account);
			commit(); 
		}catch(EventException ex){ 
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}		
	
	/**
	 * EES_MNR_0155 : Retrieve <br>
	 * [EES_MNR_0155]Retrieving Disposal Buyer Management. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDisposalPartnerListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		PartnerMgtBC command = new PartnerMgtBCImpl();
		DisposalPartnerGRPVO disposalPartnerGRPVO = new DisposalPartnerGRPVO();

		EesMnr0155Event event = (EesMnr0155Event)e;
		disposalPartnerGRPVO.setDisposalPartnerMgtINVO(event.getDisposalPartnerMgtINVO());
		disposalPartnerGRPVO = command.searchDisposalPartnerListBasic(disposalPartnerGRPVO, account);
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(disposalPartnerGRPVO.getCustomMnrPartnerVOS());
		if(!event.getDisposalPartnerMgtINVO().getFGubuns().equalsIgnoreCase("EXIST"))
		{
			eventResponse.setRsVoList(disposalPartnerGRPVO.getCustomMnrPrnrCntcPntVOS());
		}

		return eventResponse;
	}
	/**
	 * EES_MNR_0155 : Save <br>
	 * [EES_MNR_0155] adding/modification/deletion Disposal Buyer Management. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDisposalPartnerService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0155Event event = (EesMnr0155Event)e;  
		PartnerMgtBC command = new PartnerMgtBCImpl();   
		      
		try{
			begin();  
			DisposalPartnerGRPVO disposalPartnerGRPVO = new DisposalPartnerGRPVO();
			disposalPartnerGRPVO.setCustomMnrPartnerVO(event.getCustomMnrPartnerVO());
			disposalPartnerGRPVO.setArrayCustomMnrPartnerVOs(event.getCustomMnrPartnerVOs());
			disposalPartnerGRPVO.setArrayCustomMnrPrnrCntcPntVOs(event.getCustomMnrPrnrCntcPntVOs());
			 
			command.manageDisposalPartnerBasic(disposalPartnerGRPVO, account);
			commit(); 
		}catch(EventException ex){ 
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}			
		
	/**
	 * EES_MNR_0155 : Delete <br>
	 * [EES_MNR_0155] deleting Disposal Buyer Management. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeDisposalPartnerService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0155Event event = (EesMnr0155Event)e;  
		PartnerMgtBC command = new PartnerMgtBCImpl();   
		      
		try{
			begin();   
			DisposalPartnerGRPVO disposalPartnerGRPVO = new DisposalPartnerGRPVO();
			disposalPartnerGRPVO.setCustomMnrPartnerVO(event.getCustomMnrPartnerVO());
			command.removeDisposalPartnerBasic(disposalPartnerGRPVO);
			commit(); 
		}catch(EventException ex){ 
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}		
	/**
	 * EES_MNR_0222 : Retrieve <br>
	 * [EES_MNR_0222]Retrieving FQA Result Inquiry. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFQAListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0222Event event = (EesMnr0222Event)e;
		FQAResultMgtBC command = new FQAResultMgtBCImpl(); 

		FQAResultMgtGRPVO fQAResultMgtGRPVO = new FQAResultMgtGRPVO();
		fQAResultMgtGRPVO.setFQAResultMgtINVO((event.getFQAResultMgtINVO())); 
		fQAResultMgtGRPVO = command.searchFQAListBasic(fQAResultMgtGRPVO);  
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(fQAResultMgtGRPVO.getMnrFieldQualityAuditResultVOS());
    	
		return eventResponse;     
	}  

	/**
	 * EES_MNR_0224 : Retrieve <br>
	 * [EES_MNR_0224]Retrieving Hanger Bar Inventory History Pop Up. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHangerInventoryDetailListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0224Event event = (EesMnr0224Event)e;
		HangerInventoryMgtBC command = new HangerInventoryMgtBCImpl();
		HangerInventoryListGRPVO hangerInventoryListGRPVO = new HangerInventoryListGRPVO();
		
		hangerInventoryListGRPVO.setHangerInventoryListINVO(event.getHangerInventoryListINVO());
		
		hangerInventoryListGRPVO = command.searchHangerInventoryDetailListBasic(hangerInventoryListGRPVO, account); 
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		eventResponse.setRsVoList(hangerInventoryListGRPVO.getCustomHangerInventoryListVOs());
		
		return eventResponse;
	}
	
	/**
	 * EES_MNR_0155 : Check <br>
	 * [EES_MNR_0155]Searching Duplicated Buyer <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDupDSPBuyerService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		PartnerMgtBC command = new PartnerMgtBCImpl();
		DisposalPartnerGRPVO disposalPartnerGRPVO = new DisposalPartnerGRPVO();

		EesMnr0155Event event = (EesMnr0155Event)e;
		disposalPartnerGRPVO.setCustomMnrPartnerVO(event.getCustomMnrPartnerVO());
		
		String result = command.searchDupDSPBuyerBasic(disposalPartnerGRPVO, account);
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("status", result);
		
		return eventResponse;
	}
		
}