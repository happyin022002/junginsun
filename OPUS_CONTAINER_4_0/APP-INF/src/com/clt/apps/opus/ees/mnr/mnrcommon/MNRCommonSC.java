/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MNRCommonSC.java
 *@FileTitle : MNRCommonSC
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.basic.PartnerMgtBC;
import com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.basic.PartnerMgtBCImpl;
import com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.vo.CustomMnrPartnerVO;
import com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.vo.RepairPartnerGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.statushistorymgt.basic.StatusHistoryMgtBC;
import com.clt.apps.opus.ees.mnr.generalmanage.statushistorymgt.basic.StatusHistoryMgtBCImpl;
import com.clt.apps.opus.ees.mnr.generalmanage.statushistorymgt.vo.StatusHistoryGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.basic.GeneralCodeCheckMgtBC;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.basic.GeneralCodeCheckMgtBCImpl;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.vo.GeneralCodeCheckMgtGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.basic.GeneralCodeSearchMgtBC;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.basic.GeneralCodeSearchMgtBCImpl;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.event.EesMnr0189Event;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.event.MnrComEvent;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration.GeneralCodeSearchMgtDBDAO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.AGMTRtGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.BkgTrdCodeVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CostCodeGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomCostCodeVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomMnrEqStsVVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.DefaultUnitOfMeasureVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.GeneralCodeSearchGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.ServiceProviderInfoListGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.UnitPriceGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.basic.InterfaceMgtBC;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.basic.InterfaceMgtBCImpl;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.event.MnrEDIInterfaceEvent;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.event.MnrInterfaceEvent;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrRprRqstTmpHdrVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.IFMnrFlagVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.InterfaceGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.basic.EQFlagMgtBC;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.basic.EQFlagMgtBCImpl;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqStsVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrFlgHisVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.EQFlagListGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.EQFlagListINVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.basic.RepairMgtBC;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.basic.RepairMgtBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
	
/**		
 * COM-MNRCommon Business Logic ServiceCommand - COM-MNRCommon business transaction dispose
 * 
 * @author
 * @see GeneralCodeSearchMgtDBDAO
 * @since J2EE 1.4
 */
   
public class MNRCommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;
	 
	/**
	 * MNRCommon system begin business processing<br>
	 * EES_MNR_INIT create object<br>
	 */ 
	
	public void doStart() {
		log.debug("Begin MNRCommonSC");
		try {
			//checking login
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * MNRCommon system end business processing<br>
	 * EES_MNR_INIT release object<br>
	 */
	public void doEnd() {
		log.debug("End MNRCommonSC");
	}	
	
	/**
	 * do processing case of event<br>
	 * COM-MNRCommon system - do processing case of business all event<br>
	 *  
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */

	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;     
		// Event handling part of SC
		if (e.getEventName().equalsIgnoreCase("MnrComEvent")) {
			//Retrieve common code for setting select box
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchComboInitDataService(e);
			//Retrieve common code for setting grid
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCommonInitDataService(e);    
			} 
			//Retrieve EQ General Info 
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchEQGeneralInfoService(e);    
			}     
			//Default Unit Of Measure 
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchDEFUnitOfMeasureService(e);       
			}  
			//Retrieve Service Provider Detail Information
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchRepairPartnerService(e);     
			}    
			//Retrieve Agreement Rate
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = searchAgmtRtInfoService(e);	        
			}	    
			//Retrieve Cost Code
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchCostCodeService(e); 	        
			}						    
			//Retrieve Vessel Name and Lane data
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = searchVesselInfoService(e); 	        
			}
			//Retrieve Status History
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = searchStatusHistoryService(e); 	        
			}	
			//Retrieve Unit Price 
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = searchUnitPriceService(e);  	        
			} 
			//Retrieve Customer
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = searchCustomerInfoService(e); 	        
			}
			//Retrieve Current Rate
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				eventResponse = searchCurrXchRtInfoService(e); 	        
			}
			//Check Tariff Flag
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH20)) {
				eventResponse = checkTariffFlagService(e); 	        
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH21)) {
				eventResponse = searchRfUnitMakerService(e); 	        
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH22)) {
				eventResponse = searchBkgTrdCodeService(e); 	        
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH23)) {
				eventResponse = searchOfcLccCdService(e);        
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH24)) {
				eventResponse = searchRhqOfcFmOfcCdService(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH25)) {
				eventResponse = searchAgmtGrpService(e);
			}
			//Common checking Data
			else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = checkGeneralCodeService(e);      
			}
			//EDI SEND(SUCCESS FLAG = XX)	   
			else if(e.getFormCommand().isCommand(FormCommand.COMMAND40)) {
				eventResponse = reSendErrorEDIService(e);					      
			}
		 } else if(e.getEventName().equalsIgnoreCase("EesMnr0189Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchServiceProviderInfoListService(e);    
			    }    	
		 } else if(e.getEventName().equalsIgnoreCase("MnrInterfaceEvent")) {
				if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
					eventResponse = createFileUploadService(e);     
				} else if(e.getFormCommand().isCommand(FormCommand.REMOVE)){
					eventResponse = removeFileUploadService(e);          
				} else if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
					eventResponse = searchFileUploadService(e);          
				} 	
		//EDI  		
		} else if(e.getEventName().equalsIgnoreCase("MnrEDIInterfaceEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {   
				eventResponse = manageMQEstimateService(e);         
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)){
				eventResponse = manageMQNewPorRepairInvoiceService(e);         
			}
		}   
		return eventResponse;
	}
	
	
	/**
	 * Received MQ-data insert<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException 
	 */    
	private  EventResponse manageMQNewPorRepairInvoiceService(Event e) throws EventException {		
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		InterfaceMgtBC command = new InterfaceMgtBCImpl();
//		RepairMgtBC command2 = new RepairMgtBCImpl();
//		EQFlagMgtBC command3 = new EQFlagMgtBCImpl(); 
//		
		MnrEDIInterfaceEvent event = (MnrEDIInterfaceEvent)e;
		 	
//		EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO(); 
			
		InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
		try{  		
			log.debug("============================TEST BATCH PROCESS START================================");
			
//			String eaiRecMsg = event.getEdi_msg();
//			log.debug(eaiRecMsg);
//			command.excuteNewportBatchBasic(eaiRecMsg);
//			int headerStart = eaiRecMsg.indexOf("CUR_CD",0); // HEAD의 DATA 시작
//			
//			String[] allHeadArray = eaiRecMsg.substring(headerStart).toUpperCase().trim().split("\\{HEAD"); // HEAD의 총 갯수
//			
//			// Temp Table VO
//			CustomMnrOrdTmpHdrVO[] customMnrOrdTmpHdrVOs = new CustomMnrOrdTmpHdrVO[allHeadArray.length];
////			CustomMnrOrdTmpDtlVO[][] customMnrOrdTmpDtlVOs = new CustomMnrOrdTmpDtlVO[allHeadArray.length][];
//			
//			for(int x= 0 ; x < allHeadArray.length ; x++){
//				begin();
//				//TMP table insert  
//				interfaceGRPVO.setEaiRecMsg(allHeadArray[x]);
//				interfaceGRPVO = command.manageMQNewPortRepairInvoiceBasic(interfaceGRPVO);
//////				CustomMnrOrdTmpHdrVO customMnrOrdTmpHdrVO = interfaceGRPVO.getCustomMnrOrdTmpHdrVO();
//				commit();
//				customMnrOrdTmpHdrVOs[x] = interfaceGRPVO.getCustomMnrOrdTmpHdrVO();
//			}
//			
//			interfaceGRPVO.setArrayCustomMnrOrdTmpHdrVOs(customMnrOrdTmpHdrVOs);
			begin();
			//TMP table insert  
			interfaceGRPVO.setEaiRecMsg(event.getEdi_msg());
			interfaceGRPVO = command.manageMQNewPortRepairInvoiceBasic(interfaceGRPVO);
////			CustomMnrOrdTmpHdrVO customMnrOrdTmpHdrVO = interfaceGRPVO.getCustomMnrOrdTmpHdrVO();
			commit();  
			begin();
			interfaceGRPVO = command.verifyNewPortTempDataBasic(interfaceGRPVO, account);
			commit();
			begin();
			interfaceGRPVO = command.manageNewPortWOInvoiceDataBasic(interfaceGRPVO, account);
			commit();
//			command.newPortEdiBackEndJobBasic(interfaceGRPVO, account);
		}
		catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}		
	
	
	/**
	 * Received MQ-data insert<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException 
	 */    
	private EventResponse manageMQEstimateService(Event e) throws EventException {		
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		InterfaceMgtBC command = new InterfaceMgtBCImpl();
		RepairMgtBC command2 = new RepairMgtBCImpl();
		EQFlagMgtBC command3 = new EQFlagMgtBCImpl(); 
		
		MnrEDIInterfaceEvent event = (MnrEDIInterfaceEvent)e;
		 	
		EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO(); 
			
		InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
		try{  		
			begin();	     
			//TMP table insert  
			interfaceGRPVO.setEaiRecMsg(event.getEdi_msg());
			interfaceGRPVO = command.manageMQEstimateBasic(interfaceGRPVO);
			CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO = interfaceGRPVO.getCustomMnrRprRqstTmpHdrVO();
			 	
			//account reset	  	   
			SignOnUserAccount ediAccount = new SignOnUserAccount(customMnrRprRqstTmpHdrVO.getCreUsrId(),null,null,null,null,null,null,null, customMnrRprRqstTmpHdrVO.getCreUsrId(), customMnrRprRqstTmpHdrVO.getCreDt() , customMnrRprRqstTmpHdrVO.getCreUsrId(), customMnrRprRqstTmpHdrVO.getCreDt(), customMnrRprRqstTmpHdrVO.getCostOfcCd(), null, null, null, null, null, null, null, null, null);
			
			interfaceGRPVO = command.checkEDIEstimateBasic(interfaceGRPVO);
				
			//validation
			if(interfaceGRPVO.getValidOk()){
				//Estimate table insert
				command2.ediEstimateCopyToEstimateBasic(interfaceGRPVO);
			
				/***********************FLAG *********************************/
				//STS VO
				CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
				customMnrEqStsVO.setEqNo(customMnrRprRqstTmpHdrVO.getRqstEqNo());
				customMnrEqStsVO.setEqKndCd(customMnrRprRqstTmpHdrVO.getEqKndCd());
				customMnrEqStsVO.setEqTpszCd(customMnrRprRqstTmpHdrVO.getEqTpszCd()); 
				java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
				String today = formatter.format(new java.util.Date());
				customMnrEqStsVO.setMnrDmgFlgDt(today);	 
				customMnrEqStsVO.setMnrDmgFlgYdCd(customMnrRprRqstTmpHdrVO.getRprYdCd()); 
				customMnrEqStsVO.setMnrStsRmk("From EDI REF_NO:" + customMnrRprRqstTmpHdrVO.getRqstRefNo()); 
				//FLG_HIS_VO
				CustomMnrFlgHisVO customMnrFlgHisVO = new CustomMnrFlgHisVO();
				customMnrFlgHisVO.setEqNo(customMnrRprRqstTmpHdrVO.getRqstEqNo());
				customMnrFlgHisVO.setEqTpszCd(customMnrRprRqstTmpHdrVO.getEqTpszCd());
				customMnrFlgHisVO.setMnrFlgTpCd("DMG"); 
				customMnrFlgHisVO.setMnrFlgInpTpCd("E");      
				customMnrFlgHisVO.setEqKndCd(customMnrRprRqstTmpHdrVO.getEqKndCd());
				customMnrFlgHisVO.setMnrFlgYdCd(customMnrRprRqstTmpHdrVO.getRprYdCd());
				customMnrFlgHisVO.setMnrFlgInpDt(today);         
				customMnrFlgHisVO.setMnrFlgRmk("From EDI REF_NO:" + customMnrRprRqstTmpHdrVO.getRqstRefNo());
				
				customMnrFlgHisVO.setMnrStsFlg("1");  
				
				CustomMnrEqStsVO[] arrCustomMnrEqStsVOS = new CustomMnrEqStsVO[1];     
				CustomMnrFlgHisVO[] arrCustomMnrFlgHisVOS = new CustomMnrFlgHisVO[1];
				  
				arrCustomMnrEqStsVOS[0] = customMnrEqStsVO;	
				arrCustomMnrFlgHisVOS[0] = customMnrFlgHisVO;	
						
				EQFlagListINVO eQFlagListINVO = new EQFlagListINVO();
				eQFlagListINVO.setMnrFlgTpCd("DMG");   
				eQFlagListGRPVO.setEQFlagListINVO(eQFlagListINVO); 
				eQFlagListGRPVO.setArrCustomMnrEqStsVOS(arrCustomMnrEqStsVOS);
				eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(arrCustomMnrFlgHisVOS);
				command3.manageEQFlagListBasic(eQFlagListGRPVO,ediAccount);
				/********************** FLAG END **********************************/

				/***************** MST begin - for outer interface call **********************/
				List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();
				for(int j = 0;j < arrCustomMnrEqStsVOS.length; j++){
					IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();    
					iFMnrFlagVO.setFlagOfcCd(ediAccount.getOfc_cd());	
					iFMnrFlagVO.setFlagUserId(ediAccount.getUsr_id());
					iFMnrFlagVO.setFlagType("DMG");
					iFMnrFlagVO.setRetireFlag("N");
					iFMnrFlagVO.setEqKindCd(arrCustomMnrEqStsVOS[j].getEqKndCd());
					iFMnrFlagVO.setEqNo(arrCustomMnrEqStsVOS[j].getEqNo());
					iFMnrFlagVO.setStsFlag("Y");	
					iFMnrFlagVO.setFlagDt(arrCustomMnrEqStsVOS[j].getMnrDmgFlgDt());
					iFMnrFlagVO.setFlagYdCd(arrCustomMnrEqStsVOS[j].getMnrDmgFlgYdCd());
					iFMnrFlagVOS.add(iFMnrFlagVO);
				}	
				interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);		
				command.manageIFFlagBasic(interfaceGRPVO,ediAccount);				
				/***************** MST end - for outer interface call *********************/
				
			}
			commit();  
			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_MNR_0218 : Retrieve <br>
	 * [EES_MNR_0218] Retrieve Tariff Detail Information Popup data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRepairPartnerService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		try {	
			MnrComEvent event = (MnrComEvent)e;           
			PartnerMgtBC command = new PartnerMgtBCImpl(); 
			RepairPartnerGRPVO repairPartnerGRPVO = new RepairPartnerGRPVO();
			repairPartnerGRPVO.setPartnerMgtINVO(event.getPartnerMgtINVO());   
				
			repairPartnerGRPVO = command.searchRepairPartnerBasic(repairPartnerGRPVO);
			
			//return list
			if(event.getPartnerMgtINVO().getMnrPrnrSeq().equals("") || event.getPartnerMgtINVO().getMnrPrnrSeq() == null){
				eventResponse.setRsVoList(repairPartnerGRPVO.getCustomMnrPartnerVOS());
			//return a data
			} else {
				CustomMnrPartnerVO customMnrPartnerVO = repairPartnerGRPVO.getCustomMnrPartnerVO();
				if(customMnrPartnerVO != null){ 
					Map<String, String> mapVO = customMnrPartnerVO.getColumnValues();
					eventResponse.setETCData(mapVO);   
				}  
			}
		} catch(EventException ex){ 
			throw ex; 
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
		return eventResponse; 
	}
	
	/**
	 * EES_MNR_0226 : Retrieve <br>
	 * [EES_MNR_0226]retrieve W/O Creation data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */					
	private EventResponse searchComboInitDataService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();  
		try {
			
			MnrComEvent event = (MnrComEvent)e;          
			GeneralCodeSearchMgtBC command = new GeneralCodeSearchMgtBCImpl(); 
			GeneralCodeSearchGRPVO generalCodeSearchGRPVO = new GeneralCodeSearchGRPVO();
			generalCodeSearchGRPVO.setComboInitDataINVOS(event.getComboInitDataINVOS());
			
			begin();
			generalCodeSearchGRPVO = command.searchComboInitDataListBasic(generalCodeSearchGRPVO,account);
			commit(); 
			
			for (int i = 0; i < generalCodeSearchGRPVO.getListCustomMnrGeneralCodeVOS().size(); i++) {
				eventResponse.setRsVoList(generalCodeSearchGRPVO.getListCustomMnrGeneralCodeVOS().get(i));
			}     
		} catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}	
		return eventResponse;
	}
		
	/**
	 * EES_MNR_0023 : t1sheet1_OnChange <br>
	 * [EES_MNR_0023]Retrieve Repair Estimate Creation data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostCodeService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();  
		try {
			MnrComEvent event = (MnrComEvent)e;            
			GeneralCodeSearchMgtBC command = new GeneralCodeSearchMgtBCImpl(); 
			CostCodeGRPVO costCodeGRPVO = command.searchCostCodeBasic(event.getCostCodeGRPVO());
			eventResponse.setRsVoList(costCodeGRPVO.getCustomCostCodeVOS());  
		 } catch(EventException ex){ 
				throw ex; 
		 } catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		 }	
		 return eventResponse;
	}
	
	/**
	 * EES_MNR_0223 : New <br>
	 * [EES_MNR_0223]Retrieve MNR PFMC by VNDR/Manufacturer data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommonInitDataService(Event e) throws EventException {
		try {	
			// PDTO(Data Transfer Object including Parameters)
			MnrComEvent event = (MnrComEvent)e;           
			GeneralCodeSearchMgtBC command = new GeneralCodeSearchMgtBCImpl(); 
			GeneralCodeSearchGRPVO generalCodeSearchGRPVO = new GeneralCodeSearchGRPVO();
			generalCodeSearchGRPVO.setCommonInitDataINVO(event.getCommonInitDataINVO());
			  
			generalCodeSearchGRPVO = command.searchCommonInitDataListBasic(generalCodeSearchGRPVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse(); 

			for (int i = 0; i < generalCodeSearchGRPVO.getListCustomMnrGeneralCodeVOS().size(); i++) {
				eventResponse.setRsVoList(generalCodeSearchGRPVO.getListCustomMnrGeneralCodeVOS().get(i));
			}
			return eventResponse;
		} catch(EventException ex){ 
			throw ex; 
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	}
	/**
	 * EES_MNR_0226 : Retrieve <br>
	 * [EES_MNR_0226]Retrieve Total Loss Request data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEQGeneralInfoService(Event e) throws EventException {
		try {	
			// PDTO(Data Transfer Object including Parameters)
			MnrComEvent event = (MnrComEvent)e;         
			GeneralCodeSearchMgtBC command = new GeneralCodeSearchMgtBCImpl(); 
			GeneralCodeSearchGRPVO generalCodeSearchGRPVO = new GeneralCodeSearchGRPVO();
			generalCodeSearchGRPVO.setEQGeneralInfoINVO(event.getEQGeneralInfoINVO());
			   
			generalCodeSearchGRPVO = command.searchEQGeneralInfoBasic(generalCodeSearchGRPVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();  
			
			for (int i = 0; i < generalCodeSearchGRPVO.getListCustomMnrEqStsVVOs().size(); i++) {
				eventResponse.setRsVoList(generalCodeSearchGRPVO.getListCustomMnrEqStsVVOs().get(i));
			}
			return eventResponse; 
		} catch(EventException ex){ 
			throw ex; 
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}     
	  
	/**
	 * EES_MNR_0226 : yd_cd_confirm <br>
	 * [EES_MNR_0226]Retrieve Vessel Reefer Spare Part Purchase W/O Creation data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkGeneralCodeService(Event e) throws EventException {
		try {	
			// PDTO(Data Transfer Object including Parameters) 
			MnrComEvent event = (MnrComEvent)e;          
			GeneralCodeCheckMgtBC command = new GeneralCodeCheckMgtBCImpl(); 
			GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO = new GeneralCodeCheckMgtGRPVO();
			generalCodeCheckMgtGRPVO.setGeneralCodeINVO(event.getGeneralCodeINVO());
			           
			generalCodeCheckMgtGRPVO = command.checkGeneralCodeBasic(generalCodeCheckMgtGRPVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();  
			         
			eventResponse.setRsVoList(generalCodeCheckMgtGRPVO.getCustomMnrGeneralCodeVOS());
			return eventResponse; 
		} catch(EventException ex){ 
			throw ex; 
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	}
    
    /**
     * EES_MNR_0011 : eq_knd_cd onChange <br>
     * [EES_MNR_0011] Retrieve unit of measure of EQ-Type code of standard tariff<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchDEFUnitOfMeasureService(Event e) throws EventException {
    	try {
    		MnrComEvent event = (MnrComEvent)e;    
	    	GeneralCodeSearchMgtBC command = new GeneralCodeSearchMgtBCImpl();  
	    	DefaultUnitOfMeasureVO defaultUnitOfMeasureVO = command.searchDEFUnitOfMeasureBasic(event.getDefaultUnitOfMeasureVO());
	    	GeneralEventResponse eventResponse = new GeneralEventResponse();    
	    	eventResponse.setETCData("Measure",defaultUnitOfMeasureVO.getMnrMeasUtCd()); 
	    	return eventResponse;  
    	} catch(EventException ex){ 
			throw ex; 
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
    }
  
	
	/**
	 * EES_MNR_0226 : calculateAgmtRateSubSum <br>
	 * [EES_MNR_0226]Retrieve Simple W/O Inquiry Pop-up data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgmtRtInfoService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			MnrComEvent event = (MnrComEvent)e;         
			GeneralCodeSearchMgtBC command = new GeneralCodeSearchMgtBCImpl(); 
			AGMTRtGRPVO agmtRtGRPVO = event.getAGMTRtGRPVO();
			agmtRtGRPVO = 	command.searchAgmtRtInfoBasic(agmtRtGRPVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();  
			
			eventResponse.setRsVoList(agmtRtGRPVO.getAGMTRtListVOS());
			return eventResponse;
		} catch(EventException ex){ 
			throw ex; 
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
	}
	
	/**
	 * EES_MNR_0200 : t2_sheet8_OnPopupClick <br>
	 * [EES_MNR_0200]Retrieve Total Loss Request data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFileUploadService(Event e) throws EventException {
		try {	
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			MnrInterfaceEvent event = (MnrInterfaceEvent)e;
			InterfaceMgtBC command = new InterfaceMgtBCImpl();    
						
			InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
			interfaceGRPVO = command.searchFileUploadBasic(event.getInterfaceGRPVO().getFileSeq(), account); 
			eventResponse.setRsVoList(interfaceGRPVO.getListCustomMnrFileAtchVOs());
			return eventResponse; 
		} catch(EventException ex){ 
			throw ex; 
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
	}
	
	/**
	 * FileUpload : upload file<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */ 
	private EventResponse createFileUploadService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		String seqValue  = "";
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MnrInterfaceEvent event = (MnrInterfaceEvent)e;
		InterfaceMgtBC command = new InterfaceMgtBCImpl(); 
		try{       
			begin();                   
			seqValue = command.createFileUploadBasic(event.getInterfaceGRPVO(), account); 			
			commit();                 
		}catch(EventException ex){ 
			rollback();  
			throw ex; 
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}

		eventResponse.setETCData("seqValue", seqValue);
		return eventResponse;		
	}	
	
	/**
	 * EES_MNR_0159 : file_Remove <br>
	 * [EES_MNR_0159]delete Total Loss Request data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeFileUploadService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MnrInterfaceEvent event = (MnrInterfaceEvent)e;
		InterfaceMgtBC command = new InterfaceMgtBCImpl();  
		try{       
			begin();	 	                  
			command.removeFileUploadBasic(event.getInterfaceGRPVO(), account);
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
	 * EES_MNR_0189 : doIBSEARCH <br>
	 * [EES_MNR_0189]Retrieve M&R Service Provider Inquiry_Pop-up data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchServiceProviderInfoListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();  
		try {
			EesMnr0189Event event = (EesMnr0189Event)e;         
			GeneralCodeSearchMgtBC command = new GeneralCodeSearchMgtBCImpl(); 
			ServiceProviderInfoListGRPVO serviceProviderInfoListGRPVO = event.getServiceProviderInfoListGRPVO();
			                                                     
			serviceProviderInfoListGRPVO = 	command.searchServiceProviderInfoListBasic(serviceProviderInfoListGRPVO);
			eventResponse.setRsVoList(serviceProviderInfoListGRPVO.getCustomMdmVendorVOS());
		 
		} catch(EventException ex){ 
			throw ex; 
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	

	/**
	 * EES_MNR_0194 : setVesselInfo <br>
	 * [EES_MNR_0194]Retrieve Vessel Reefer Spare Part Purchase W/O Creation data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchVesselInfoService(Event e) throws EventException {
    	try {	
    		// PDTO(Data Transfer Object including Parameters)
			MnrComEvent event = (MnrComEvent)e;          
			GeneralCodeSearchMgtBC command = new GeneralCodeSearchMgtBCImpl(); 
			GeneralCodeSearchGRPVO generalCodeSearchGRPVO = new GeneralCodeSearchGRPVO();
			generalCodeSearchGRPVO.setVesselInfoVO(event.getVesselInfoVO());
			
			generalCodeSearchGRPVO = command.searchVesselInfoBasic(generalCodeSearchGRPVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();  
			
			eventResponse.setRsVoList(generalCodeSearchGRPVO.getVesselInfoVOS());  
			return eventResponse;
    	} catch(EventException ex){ 
			throw ex; 
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
	}
    
    /**
     * EES_MNR_0155 : setCustomerName <br>
     * [EES_MNR_0155] Retrieve Disposal Buyer Management data<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCustomerInfoService(Event e) throws EventException {
    	try {
			// PDTO(Data Transfer Object including Parameters)
			MnrComEvent event = (MnrComEvent)e;          
			GeneralCodeSearchMgtBC command = new GeneralCodeSearchMgtBCImpl(); 
			GeneralCodeSearchGRPVO generalCodeSearchGRPVO = new GeneralCodeSearchGRPVO();
			generalCodeSearchGRPVO.setCustomerInfoVO(event.getCustomerInfoVO());
			
			generalCodeSearchGRPVO = command.searchCustomerInfoBasic(generalCodeSearchGRPVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();  
			
			eventResponse.setRsVoList(generalCodeSearchGRPVO.getCustomerInfoVOS());  
			return eventResponse;
    	} catch(EventException ex){ 
			throw ex; 
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	}
    
    /**
     * EES_MNR_0098 : sheet1_OnSearchEnd <br>
     * [EES_MNR_0098] Retrieve Total Loss Request data<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchStatusHistoryService(Event e) throws EventException {
		try {	
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse(); 
			MnrComEvent event = (MnrComEvent)e;           
			StatusHistoryMgtBC command = new StatusHistoryMgtBCImpl(); 
			StatusHistoryGRPVO statusHistoryGRPVO = event.getStatusHistoryGRPVO();
				
			statusHistoryGRPVO = command.searchStatusHistoryBasic(statusHistoryGRPVO);
			
			eventResponse.setRsVoList(statusHistoryGRPVO.getListCustomMnrStsHisVO());
			return eventResponse; 
		} catch(EventException ex){ 
			throw ex; 		
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
	}
	
	/**
	 * EES_MNR_0157 : setEqInfo <br>
	 * [EES_MNR_0157] Retrieve Disposal Request data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUnitPriceService(Event e) throws EventException {
		try {	
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse(); 
			MnrComEvent event = (MnrComEvent)e;            
			GeneralCodeSearchMgtBC command = new GeneralCodeSearchMgtBCImpl(); 
			UnitPriceGRPVO unitPriceGRPVO = event.getUnitPriceGRPVO();
			
			unitPriceGRPVO = command.searchUnitPriceBasic(unitPriceGRPVO); 
				
			eventResponse.setETCData("match_type",unitPriceGRPVO.getOutCustomUnitPriceVO().getMatchType());
			eventResponse.setETCData("match_cnt",unitPriceGRPVO.getOutCustomUnitPriceVO().getMatchCnt());
			eventResponse.setETCData("curr_cd",unitPriceGRPVO.getOutCustomUnitPriceVO().getCurrCd());
			eventResponse.setETCData("mnr_disp_trf_tot",unitPriceGRPVO.getOutCustomUnitPriceVO().getMnrDispTrfTot());
			eventResponse.setETCData("price",unitPriceGRPVO.getOutCustomUnitPriceVO().getMnrDispTrfAvg());
			return eventResponse; 
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	}
	
	/**
	 * [EES_MNR_QEXE] Re-send abnormal EDI data (FLAG XX) <br>
	 *	 	
	 * @param Event e		
	 * @return EventResponse	
	 * @exception EventException	
	 */
	private EventResponse reSendErrorEDIService(Event e) throws EventException {		
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		InterfaceMgtBC command = new InterfaceMgtBCImpl();
		RepairMgtBC command2 = new RepairMgtBCImpl();
		EQFlagMgtBC command3 = new EQFlagMgtBCImpl(); 
		
		EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO(); 
		InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
		begin();
		try{  		
			
			//Retrieve re-sending list 			  	
			interfaceGRPVO = command.searchReSendErrorEDIListBasic(interfaceGRPVO);
			List<CustomMnrRprRqstTmpHdrVO> customMnrRprRqstTmpHdrVOS = interfaceGRPVO.getCustomMnrRprRqstTmpHdrVOS();
			
			for (int i = 0; i < customMnrRprRqstTmpHdrVOS.size(); i++) {
				//Retrieve data for Re-sending 
				CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO = customMnrRprRqstTmpHdrVOS.get(i);
				interfaceGRPVO.setCustomMnrRprRqstTmpHdrVO(customMnrRprRqstTmpHdrVO);

				//case of vendor data = ""	
				if(customMnrRprRqstTmpHdrVO.getVndrSeq().equals("")){
					//VE
					interfaceGRPVO.setEdiErrCd("VE");	
					interfaceGRPVO = command.reSendErrorEDIBasic(interfaceGRPVO);
					continue;
				}
				
				//case of Estimate Number = "" 	
				if(customMnrRprRqstTmpHdrVO.getRqstRefNo().equals("")){
					//re-sending
					interfaceGRPVO.setEdiErrCd("RE");			
					interfaceGRPVO = command.reSendErrorEDIBasic(interfaceGRPVO);
					continue;			
				}

				//reset account	  	   
				SignOnUserAccount ediAccount = new SignOnUserAccount(customMnrRprRqstTmpHdrVO.getCreUsrId(),null,null,null,null,null,null,null, customMnrRprRqstTmpHdrVO.getCreUsrId(), customMnrRprRqstTmpHdrVO.getCreDt() , customMnrRprRqstTmpHdrVO.getCreUsrId(), customMnrRprRqstTmpHdrVO.getCreDt(), customMnrRprRqstTmpHdrVO.getCostOfcCd(), null, null, null, null, null, null, null, null, null);
				
				//1. case of error code XX = SS 	
				//2. Retrieve data
				interfaceGRPVO.setEdiErrCd("SS");
				interfaceGRPVO = command.reSendErrorEDIBasic(interfaceGRPVO);
				
				//insert estimate table
				command2.ediEstimateCopyToEstimateBasic(interfaceGRPVO);
					
				/***********************FLAG *********************************/
				//STS VO
				CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
				customMnrEqStsVO.setEqNo(customMnrRprRqstTmpHdrVO.getRqstEqNo());
				customMnrEqStsVO.setEqKndCd(customMnrRprRqstTmpHdrVO.getEqKndCd());
				customMnrEqStsVO.setEqTpszCd(customMnrRprRqstTmpHdrVO.getEqTpszCd()); 
				java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
				String today = formatter.format(new java.util.Date());
				customMnrEqStsVO.setMnrDmgFlgDt(today);	 
				customMnrEqStsVO.setMnrDmgFlgYdCd(customMnrRprRqstTmpHdrVO.getRprYdCd()); 
				customMnrEqStsVO.setMnrStsRmk("From EDI REF_NO:" + customMnrRprRqstTmpHdrVO.getRqstRefNo()); 
				//FLG_HIS_VO
				CustomMnrFlgHisVO customMnrFlgHisVO = new CustomMnrFlgHisVO();
				customMnrFlgHisVO.setEqNo(customMnrRprRqstTmpHdrVO.getRqstEqNo());
				customMnrFlgHisVO.setEqTpszCd(customMnrRprRqstTmpHdrVO.getEqTpszCd());
				customMnrFlgHisVO.setMnrFlgTpCd("DMG"); 
				customMnrFlgHisVO.setMnrFlgInpTpCd("E");      
				customMnrFlgHisVO.setEqKndCd(customMnrRprRqstTmpHdrVO.getEqKndCd());
				customMnrFlgHisVO.setMnrFlgYdCd(customMnrRprRqstTmpHdrVO.getRprYdCd());
				customMnrFlgHisVO.setMnrFlgInpDt(today);         
				customMnrFlgHisVO.setMnrFlgRmk("From EDI REF_NO:" + customMnrRprRqstTmpHdrVO.getRqstRefNo());
				
				customMnrFlgHisVO.setMnrStsFlg("1");  
				
				CustomMnrEqStsVO[] arrCustomMnrEqStsVOS = new CustomMnrEqStsVO[1];     
				CustomMnrFlgHisVO[] arrCustomMnrFlgHisVOS = new CustomMnrFlgHisVO[1];
				  
				arrCustomMnrEqStsVOS[0] = customMnrEqStsVO;	
				arrCustomMnrFlgHisVOS[0] = customMnrFlgHisVO;	
				
				EQFlagListINVO eQFlagListINVO = new EQFlagListINVO();
				eQFlagListINVO.setMnrFlgTpCd("DMG");   
				eQFlagListGRPVO.setEQFlagListINVO(eQFlagListINVO); 
				eQFlagListGRPVO.setArrCustomMnrEqStsVOS(arrCustomMnrEqStsVOS);
				eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(arrCustomMnrFlgHisVOS);
				command3.manageEQFlagListBasic(eQFlagListGRPVO,ediAccount);
				/********************** FLAG END **********************************/
				/******** MST - begin sector for outer interface call *************/
				List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();
				for(int j = 0;j < arrCustomMnrEqStsVOS.length; j++){
					IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();    
					iFMnrFlagVO.setFlagOfcCd(ediAccount.getOfc_cd());	
					iFMnrFlagVO.setFlagUserId(ediAccount.getUsr_id());
					iFMnrFlagVO.setFlagType("DMG");		
					iFMnrFlagVO.setRetireFlag("N");	
					iFMnrFlagVO.setEqKindCd(arrCustomMnrEqStsVOS[j].getEqKndCd());
					iFMnrFlagVO.setEqNo(arrCustomMnrEqStsVOS[j].getEqNo());
					iFMnrFlagVO.setStsFlag("Y");	
					iFMnrFlagVO.setFlagDt(arrCustomMnrEqStsVOS[j].getMnrDmgFlgDt());
					iFMnrFlagVO.setFlagYdCd(arrCustomMnrEqStsVOS[j].getMnrDmgFlgYdCd());
					iFMnrFlagVOS.add(iFMnrFlagVO);	
				}					
				interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);		
				command.manageIFFlagBasic(interfaceGRPVO,ediAccount);				
				/******** MST - end sector for outer interface call ***************/
			}
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0041 : setCurrRate <br>
	 * [EES_MNR_0041] Retrieve Current rate data for Conversion<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCurrXchRtInfoService(Event e) throws EventException {
		try {			
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse(); 
			MnrComEvent event = (MnrComEvent)e;            
			GeneralCodeSearchMgtBC command = new GeneralCodeSearchMgtBCImpl(); 
			UnitPriceGRPVO unitPriceGRPVO = event.getUnitPriceGRPVO();
					
			unitPriceGRPVO = command.searchCurrXchRtInfoBasic(unitPriceGRPVO);
			
			eventResponse.setETCData("XchRt",unitPriceGRPVO.getCustomCurrXchRtVO().getXchRt());
			eventResponse.setETCData("DpPrcsKnt",unitPriceGRPVO.getCustomCurrXchRtVO().getDpPrcsKnt());
			
			return eventResponse; 

    	} catch(EventException ex){ 
			throw ex; 
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	}
	
	/**
	 * common : checkTariffFlag <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkTariffFlagService(Event e) throws EventException {
		try {			
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse(); 
			String result = "";
			MnrComEvent event = (MnrComEvent)e;            
			GeneralCodeCheckMgtBC command = new GeneralCodeCheckMgtBCImpl(); 
			GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO = new GeneralCodeCheckMgtGRPVO();
			generalCodeCheckMgtGRPVO.setGeneralCodeINVO(event.getGeneralCodeINVO());
			
			result = command.checkTariffFlagBasic(generalCodeCheckMgtGRPVO, account);
			
			eventResponse.setETCData("CODE", result);
			
			return eventResponse; 

    	} catch(EventException ex){ 
			throw ex; 
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	}
	
    /**
    * EES_MNR_0019 : searchRfUnitMakerService <br>
    * [EES_MNR_0019] Searching rfUnitMaker <br>
    * 
     * @param  Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchRfUnitMakerService(Event e) throws EventException {
       try {
         // PDTO(Data Transfer Object including Parameters)
         MnrComEvent event = (MnrComEvent)e;          
         GeneralCodeSearchMgtBC command = new GeneralCodeSearchMgtBCImpl(); 
         CustomMnrEqStsVVO customMnrEqStsVVO = null;
         
         customMnrEqStsVVO = command.searchRfUnitMakerBasic(event.getCommonInitDataINVO().getEqNo());
         GeneralEventResponse eventResponse = new GeneralEventResponse();  
   
         if(customMnrEqStsVVO != null){
            eventResponse.setETCData("disposal", customMnrEqStsVVO.getDspFlag());  
            eventResponse.setETCData("rf_unit_maker", customMnrEqStsVVO.getMkrNm());   
         }else{
            eventResponse.setETCData("disposal", "");  
            eventResponse.setETCData("rf_unit_maker", "");
         }
         
         return eventResponse;
       } catch(EventException ex){ 
         throw ex; 
      } catch(Exception ex){
         throw new EventException(ex.getMessage(), ex);
      }   
   }
   
	/**
	 * EES_MNR_0052 : sheet1_OnChange <br>
	 * [EES_MNR_0052]Retrieve Booking No, Trade Code<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgTrdCodeService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			MnrComEvent event = (MnrComEvent) e;
			GeneralCodeSearchMgtBC command = new GeneralCodeSearchMgtBCImpl();
			List<BkgTrdCodeVO> list = command.searchBkgTrdCdBasic(event.getBkgTrdCodeVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * LCC CD Search
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchOfcLccCdService(Event e)throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			MnrComEvent event = (MnrComEvent) e;
			GeneralCodeSearchMgtBC command = new GeneralCodeSearchMgtBCImpl();
		
			String lccCd = command.searchOfcLccCdBasic(event.getCustomerInfoVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			if("".equals(lccCd) || lccCd == null){
				eventResponse.setETCData("lcc_cd", "");
			}else{
				eventResponse.setETCData("lcc_cd", lccCd);
			}
			
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * RHQ OFC Search
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRhqOfcFmOfcCdService(Event e)throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			MnrComEvent event = (MnrComEvent) e;
			GeneralCodeSearchMgtBC command = new GeneralCodeSearchMgtBCImpl();
		
			String rhqOfcCd = command.searchRhqOfcFmOfcCdBasic(event.getOfficeInfoListVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			if("".equals(rhqOfcCd) || rhqOfcCd == null){
				eventResponse.setETCData("rhq_ofc_cd", "");
			}else{
				eventResponse.setETCData("rhq_ofc_cd", rhqOfcCd);
			}
			
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * Agreement List : OPEN<br>
	 * Retrieving Agreement Group name information <br>
	 * 
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgmtGrpService(Event e) throws EventException {
		try {
			MnrComEvent event = (MnrComEvent) e;
			GeneralCodeSearchMgtBC command = new GeneralCodeSearchMgtBCImpl();
			List<CustomCostCodeVO> list = command.searchAgmtGrpBasic(event.getEQGeneralInfoINVO().getEqType());
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			StringBuilder sb = new StringBuilder();
			if (list.size() > 0) {
				for (int i = 0; i < list.size() - 1; i++) {
					sb.append(list.get(i).getCostCdNm());
					sb.append("|");
				}
				sb.append(list.get(list.size() - 1).getCostCdNm());
			}

			Map<String, String> etcData = new HashMap<String, String>();

			etcData.put("agmt_list", sb.toString());

			eventResponse.setETCData(etcData);

			return eventResponse;
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
}