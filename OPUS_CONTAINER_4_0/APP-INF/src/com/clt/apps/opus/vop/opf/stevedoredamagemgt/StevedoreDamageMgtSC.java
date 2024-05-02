/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StevedoreDamageMgtSC.java
*@FileTitle : Damage Creation
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.vop.opf.stevedoredamagemgt;

import java.util.List;

import com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.basic.OperationNPerformMasterDataMgtBC;
import com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.basic.OperationNPerformMasterDataMgtBCImpl;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.basic.StevedoreDamageMgtBC;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.basic.StevedoreDamageMgtBCImpl;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event.VopOpf0052Event;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event.VopOpf0053Event;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event.VopOpf0054Event;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event.VopOpf0056Event;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event.VopOpf1052Event;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event.VopOpf1053Event;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration.StevedoreDamageMgtDBDAO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.OpfStvDmgCmpnVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.OpfStvDmgCreateVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsCompensationReportVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsDamageReportVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsDetailsGRPVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsOptionVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsRepairReportVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsReportVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsSettlementReportVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsStepHistoryVO;
import com.clt.bizcommon.currency.vo.MdmCurrencyVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ComIntgCdDtlVO;
import com.clt.syscommon.common.table.ComUserVO;
import com.clt.syscommon.common.table.MdmOrganizationVO;
import com.clt.syscommon.common.table.OpfStvDmgAtchFileVO;
import com.clt.syscommon.common.table.OpfStvDmgCdVO;
import com.clt.syscommon.common.table.OpfStvDmgDtlVO;
import com.clt.syscommon.common.table.OpfStvDmgRprVO;
import com.clt.syscommon.common.table.OpfStvDmgStlVO;
import com.clt.syscommon.common.table.OpfStvDmgVO;
import com.clt.syscommon.common.table.VskVslPortSkdVO;
import com.clt.syscommon.common.table.VskVslSkdVO;


/**
 * OPUS-StevedoreDamageMgt Business Logic ServiceCommand - Handling business transaction about OPUS-StevedoreDamageMgt
 * 
 * @author 
 * @see StevedoreDamageMgtDBDAO
 * @since J2EE 1.4
 */

public class StevedoreDamageMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * StevedoreDamageMgt system preceding process for biz scenario<br>
	 * VOP_OPF_0052 related objects creation<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * StevedoreDamageMgt system biz scenario closing<br>
	 * VOP_OPF_0052 clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("StevedoreDamageMgtSC 종료");
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
		if (e.getEventName().equalsIgnoreCase("VopOpf0052Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDamage(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchPort(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchLane(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchStevedoreDamagePartCodeList(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				// Approval Auth Check.
				eventResponse = searchApprovalPermissionCheck(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				// File Upload Data Search.
				eventResponse = searchDamageAttachFile(e,"0052");
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				// ETA/ETD Date Search.
				eventResponse = searchDamageDate(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				// Office Code Search.
				eventResponse = searchOfficeCode(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				// Mail Content PIC Search.
				eventResponse = searchMailContentPic(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				//VVD CD/Port/DamageDate Check.
				eventResponse = checkVVDInfo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDamage(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = manageApproval(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeDamage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)){

				eventResponse = checkMainCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)){

				eventResponse = checkDeleteFlag(e);
			}
			else{
				// Default Combo Data Setting.
				eventResponse = searchComboData(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf0053Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSDList(e);
			}
			else{
				// Default Combo Data Setting.
				eventResponse = search0053ComboData(e);
			}
		}
		else if(e.getEventName().equalsIgnoreCase("VopOpf1053Event")){
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSdmsDetails(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchStvDamage(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchDamageDetail(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchDamageRepair(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchDamageCompensation(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchDamageSettlement(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = new GeneralEventResponse();
				eventResponse.setETCData("usdAmt", searchLocalPayUsd(e));
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = new GeneralEventResponse();
				eventResponse.setETCData("usdAmt", searchLocalPayUsd(e));
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				// File Upload Data Search.
				eventResponse = searchDamageAttachFile(e,"1053");
			}			
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageStvDamage(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageDamageDetail(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = manageDamageRepair(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = manageDamageCompensation(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = manageDamageSettlement(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = manageApproval(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = checkTabSavable(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeDamageDetail(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf0054Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSDHistoryList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDamageHistory(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf1052Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDamageAttachFile(e,"1052");
			}
		}
		else if(e.getEventName().equalsIgnoreCase("VopOpf0056Event")){
			
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSdmsReportList(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSdmsReportComboList(e);
			}
		}
		return eventResponse;
	}
	
	
	// VOP_OPF_0052 Start ============================================================//
	/**
	 * VOP_OPF_0052 : Retrieve <br>
	 * Retrieve Stevedore Damage Info <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDamage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0052Event event = (VopOpf0052Event)e;
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
    		List<OpfStvDmgCreateVO> list = command.searchDamage(event.getOpfStvDmgCreateVO());
		    eventResponse.setRsVoList(list);
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Stevedore Damage Retrieve"}).getMessage(), ex);
        }

		return eventResponse;
	} 
	
	/**
	 * VOP_OPF_0052 : Retrieve <br>
	 * Retrieve Stevedore Damage Info <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkVVDInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0052Event event = (VopOpf0052Event)e;
	    GeneralEventResponse eventResponse = new GeneralEventResponse();
	    try{
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
		List<OpfStvDmgVO> list = command.checkVVDInfo(event.getOpfStvDmgCreateVO());

		eventResponse.setRsVoList(list);
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Stevedore Damage Retrieve"}).getMessage(), ex);
        }
		return eventResponse;
	} 
	
	/**
	 * VOP_OPF_0052 : Delete <br>
	 * Delete Stevedore Damage Info <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeDamage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0052Event event = (VopOpf0052Event)e;
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
		try{
			begin();
			command.removeDamage(event.getAttribute("del_stv_dmg_no").toString(), account);
			// Success Message.
			//eventResponse.setUserMessage(new ErrorHandler("OPF00027").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12196", new String[]{"Stevedore Damage Data"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0052 : Save <br>
	 * Save Stevedore Damage Info. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDamage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0052Event event = (VopOpf0052Event)e;
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
		try{
			begin();
			String etcData = command.manageDamage(event.getOpfStvDmgCreateVOS(),event.getOpfStvDmgAtchFileVOS(), event.getKeys(), account);
			eventResponse.setETCData("stvDmgNoList", etcData);
			// Success Message.
			eventResponse.setUserMessage(new ErrorHandler("OPF50006",new String[]{"Data"}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Stevedore Damage Data"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0052 : Approval <br>
	 * Save Approval Info of Stevedore Damage  <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageApproval(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0052Event event = (VopOpf0052Event)e;
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
		try{
			begin();
			command.manageApproval(event.getOpfStvDmgCreateVO(),account);
			// Success Message.
			eventResponse.setUserMessage(new ErrorHandler("OPF50006",new String[]{"Data"}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("OPF50006", new String[]{"Data"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0052 : Retrieve <br>
	 * Retrieve Port Info of Stevedore Damage  <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPort(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		OpfStvDmgCreateVO vo = new OpfStvDmgCreateVO();
		VopOpf0052Event event = (VopOpf0052Event)e;
		vo = event.getOpfStvDmgCreateVO();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
		try{
    		List<VskVslPortSkdVO> list = command.searchVskVslPortSkdVO(vo);
    		StringBuffer data = new StringBuffer();
    		if(list != null && list.size() > 0){
    			for (int i = 0; i < list.size(); i++) {
    				
    				data.append(list.get(i).getVpsPortCd()+","+list.get(i).getVpsPortCd());
    				if (i < list.size()-1)
    					data.append("|");
    			}
    		}

    		eventResponse.setETCData("vvdPortComboList", data.toString());
		
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Stevedore Damage Retrieve"}).getMessage(), ex);
        }
    
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0052 : Retrieve <br>
	 * Retrieve Lane Info of Stevedore Damage  <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0052Event event = (VopOpf0052Event)e;
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
		List<VskVslSkdVO> list = command.searchLaneCode(event.getOpfStvDmgCreateVO());
//		StringBuffer data = new StringBuffer();
//		if(list != null && list.size() > 0){
//			for (int i = 0; i < list.size(); i++) {
//				
//				data.append(list.get(i).getSlanCd());
//				if (i < list.size()-1)
//					data.append("|");
//			}
//		}

		if(list != null && list.size() > 0){
			eventResponse.setETCData("laneCode", list.get(0).getVslSlanCd());
		}
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Stevedore Damage Lane Retrieve"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0052 : Retrieve <br>
	 * Handling Default Combo Data retrieve event about event of Stevedore Damage <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComboData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		//VopOpf0052Event event = (VopOpf0052Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
		// Vessel Category Combo List.
		eventResponse.setETCData("vslCategory", searchVesselCategoryList());
		// Damage Category Combo List.
		eventResponse.setETCData("categoryCode", searchDamageCategoryList());
		// Damage Part Combo List.
		eventResponse.setETCData("damageCode", searchDamagePartList());
		// Requirement - Damage Reason Combo List.
		eventResponse.setETCData("reqReasonCode", searchRequirementReasonCodeList("req"));
		// Responsible - Damage Reason Combo List.
		eventResponse.setETCData("resReasonCode", searchRequirementReasonCodeList("res"));
		
		// Approval Auth Check.
		eventResponse.setETCData("approvalPermission", searchApprovalPermissionFlag(e));
		
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Stevedore Damage Retrieve"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0052 : Retrieve <br>
	 * Retrieve Vessel Category Code Combo Data <br>
	 * 
	 * @param 
	 * @return String
	 * @exception EventException
	 */
	private String searchVesselCategoryList() throws EventException {
	    StringBuffer data = new StringBuffer();
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
		try{
		List<ComIntgCdDtlVO> vslCateList = command.searchComCodeList("CD02122");

		if(vslCateList != null && vslCateList.size() > 0){
			for (int i = 0; i < vslCateList.size(); i++) {
				
				data.append(vslCateList.get(i).getIntgCdValCtnt()+","+vslCateList.get(i).getIntgCdValDesc());
				if (i < vslCateList.size()-1)
					data.append("|");
			}
		}
		
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Vessel Category Retrieve"}).getMessage(), ex);
        }
		return data.toString();
	}
	
	/**
	 * VOP_OPF_0052 : Retrieve <br>
	 * Retrieve Damage Category Code Combo Data <br>
	 * 
	 * @param 
	 * @return String
	 * @exception EventException
	 */
	private String searchDamageCategoryList() throws EventException {
		
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
        StringBuffer data = new StringBuffer();
        String returnStr = "";
		try{
		List<ComIntgCdDtlVO> categoryList = command.searchComCodeList("CD01882");

		if(categoryList != null && categoryList.size() > 0){
			for (int i = 0; i < categoryList.size(); i++) {
				if(!(categoryList.get(i).getIntgCdValCtnt().equals("NOTH"))
					&& !(categoryList.get(i).getIntgCdValCtnt().equals("QUOT")))
				{
					data.append(categoryList.get(i).getIntgCdValCtnt()+","+categoryList.get(i).getIntgCdValDesc());
					data.append("|");
				}
			}
			if (data.length() > 0){
				returnStr = data.toString();
				returnStr = returnStr.substring(0, returnStr.length()-1);
			}
		}
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Damage Category Retrieve"}).getMessage(), ex);
        }
		return returnStr;
	}
	
	/**
	 * VOP_OPF_0052 : Retrieve <br>
	 * Retrieve Damage Part Code Combo Data <br>
	 * 
	 * @param 
	 * @return String
	 * @exception EventException
	 */
	private String searchDamagePartList() throws EventException {
		
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
		

		StringBuffer data = new StringBuffer();
		String returnStr = "";
		try{
        List<ComIntgCdDtlVO> damageList = command.searchComCodeList("CD01890");
		if(damageList != null && damageList.size() > 0){
			for (int i = 0; i < damageList.size(); i++) {
				
				if( !(damageList.get(i).getIntgCdValCtnt().equals("HULL"))
					&& !(damageList.get(i).getIntgCdValCtnt().equals("SPILL")))
				{
					data.append(damageList.get(i).getIntgCdValCtnt()+","+damageList.get(i).getIntgCdValDesc());
					data.append("|");
				}
				if (data.length() > 0){
					returnStr = data.toString();
					returnStr = returnStr.substring(0, returnStr.length()-1);
				}
			}
		}
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Damage Part Code Retrieve"}).getMessage(), ex);
        }
		return returnStr;
	}
	
	/**
	 * VOP_OPF_0052 : Retrieve <br>
	 * Retrieve Damage Reason Code Combo Data<br>
	 * 
	 * @param  String rsnFlag
	 * @return String
	 * @exception EventException
	 */
	private String searchRequirementReasonCodeList(String rsnFlag) throws EventException {
		
		OperationNPerformMasterDataMgtBC command02 = new OperationNPerformMasterDataMgtBCImpl();
	      String returnStr = "";
		try{
		List<OpfStvDmgCdVO> list = command02.searchStevedoreDamageReasonCodeList(null);
		StringBuffer data = new StringBuffer();

		if(list != null && list.size() > 0){
			for (int i = 0; i < list.size(); i++) {
				if(rsnFlag.equals("req")){
					if(list.get(i).getStvDmgCateCd().equals("QUOT")){
						data.append(list.get(i).getStvDmgCateCd()+","+list.get(i).getStvDmgCd()+","+list.get(i).getStvDmgCdDesc());
						data.append("|");
					}
				}
				else if(rsnFlag.equals("res")){
					if(list.get(i).getStvDmgCateCd().equals("NOTH")){
						data.append(list.get(i).getStvDmgCateCd()+","+list.get(i).getStvDmgCd()+","+list.get(i).getStvDmgCdDesc());
						data.append("|");
					}
				}
				else{
					data.append(list.get(i).getStvDmgCateCd()+","+list.get(i).getStvDmgCd()+","+list.get(i).getStvDmgCdDesc());
					data.append("|");
				}
				if (data.length() > 0){
					returnStr = data.toString();
					returnStr = returnStr.substring(0, returnStr.length()-1);
				}
			}
		}
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Damage Reason Retrieve"}).getMessage(), ex);
        }
		return returnStr;
	}
	
	/**
	 * VOP_OPF_0052 : Change <br>
	 * Retrieve Vessel Category Part Code Combo Data <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStevedoreDamagePartCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0052Event event = (VopOpf0052Event)e;
		OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
	    GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
		List<OpfStvDmgCdVO> list = command.searchStevedoreDamagePartCodeList(null);
		StringBuffer data = new StringBuffer();
		
		if(list != null && list.size() > 0){
			for (int i = 0; i < list.size(); i++) {
				//Retrieve Part Code corresponding to Category chosen 
				if(event.getOpfStvDmgCreateVO().getStvDmgPrtCateCd().equals(list.get(i).getStvDmgCateCd())){
					data.append(list.get(i).getStvDmgCd()+","+list.get(i).getStvDmgCdDesc()+"|");
				}
			}
		}
		data.delete(data.length()-1, data.length()); //remove ("|")
		

		eventResponse.setETCData("catePart", data.toString());
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Vessel Category Part Retrieve"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0052 : Retrieve <br>
	 * Retrieve Approval permission Info of Stevedore Damage<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchApprovalPermissionCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
	    try{
    		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
    		int data = command.searchApprovalPermissionCheck(account);
    		if(data > 0){
    			data = 1;
    		}else{
    			data = 0;
    		}
    //		//get today's date
    //		Calendar cal = Calendar.getInstance();
    //		SimpleDateFormat sDateFormat = new SimpleDateFormat("YYYYMMDD");
    //		String today = sDateFormat.format(cal.getTime());
    		
    		String paramData = String.valueOf(data);
    		

    		eventResponse.setETCData("approvalPermission", paramData);
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Approval permission Retrieve"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0052 : Blur <br>
	 * Retrieve ETA/ETD Date Info of Stevedore Damage<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDamageDate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		OpfStvDmgCreateVO vo = new OpfStvDmgCreateVO();
		VopOpf0052Event event = (VopOpf0052Event)e;
		vo = event.getOpfStvDmgCreateVO();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
    		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
    		List<VskVslPortSkdVO> list = command.searchVskVslPortSkdVO(vo);
    		if(list != null && list.size() > 0){
    			eventResponse.setETCData("eta_date", list.get(0).getVpsEtaDt());
    			eventResponse.setETCData("etd_date", list.get(0).getVpsEtdDt());
    		}
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Approval permission Retrieve"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0052 : Blur <br>
	 * Retrieve Office Code Info of Stevedore Damage.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0052Event event = (VopOpf0052Event)e;
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
		List<MdmOrganizationVO> list = command.searchOfficeCode(event.getAttribute("ofc_cd").toString());

		eventResponse.setRsVoList(list);
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Approval permission Retrieve"}).getMessage(), ex);
        }		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0052 : Blur <br>
	 * Retrieve E-mail [PIC of Claim Handling Office] Info of Stevedore Damage <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMailContentPic(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0052Event event = (VopOpf0052Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
		StringBuffer data_pic = new StringBuffer();
		try{
		List<ComUserVO> list = command.searchMailContentPic(event.getAttribute("ofc_cd").toString());
		if(list != null && list.size() > 0){
			data_pic.append("[PIC of Claim Handling Office]");
			for (int i = 0; i < list.size(); i++) {
				data_pic.append("<br> -"+list.get(i).getUsrNm()+":"+list.get(i).getUsrEml());
			}
		}
		eventResponse.setETCData("mail_content_pic", data_pic.toString());
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Approval permission Retrieve"}).getMessage(), ex);
        }
		return eventResponse;
	}	
	// VOP_OPF_0052 End ============================================================//

	// VOP_OPF_0053 Start ============================================================//
	/**
	 * VOP_OPF_0053 : Retrieve <br>
	 * Retrieve Stevedore Damage Inquiry Info<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSDList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0053Event event = (VopOpf0053Event)e;
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
		List<SdmsOptionVO> list = command.searchSDList(event.getSdmsOptionVO());

		eventResponse.setRsVoList(list);
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Approval permission Retrieve"}).getMessage(), ex);
        }		
		return eventResponse;
	}
	/**
	 * VOP_OPF_0053 : Retrieve <br>
	 * Handling Default Combo Data retrieve event about event of Stevedore Damage<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search0053ComboData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		//VopOpf0052Event event = (VopOpf0052Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
		// Vessel Category Combo List.
		eventResponse.setETCData("vslCategory", searchVesselCategoryList());
		// Process Category Combo List.
		eventResponse.setETCData("categoryCode", searchProcessCategoryList());
		// Process Repair Combo List.
		eventResponse.setETCData("repairCode", searchProcessRepairList());
		// Process Compensation Combo List.
		eventResponse.setETCData("compenCode", searchProcessCompensationList());
		// Process Settlement Combo List.
		eventResponse.setETCData("stlmntCode", searchProcessSettlementList());
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Approval permission Retrieve"}).getMessage(), ex);
        }		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0053 : Retrieve <br>
	 * Retrieve Process Category Code Combo Data <br>
	 * 
	 * @param 
	 * @return String
	 * @exception EventException
	 */
	private String searchProcessCategoryList() throws EventException {
		
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
        StringBuffer data = new StringBuffer();
		try{
		// Process Category Combo List.
		List<ComIntgCdDtlVO> categoryList = command.searchComCodeList("CD01888");

		if(categoryList != null && categoryList.size() > 0){
			for (int i = 0; i < categoryList.size(); i++) {
				
				data.append(categoryList.get(i).getIntgCdValCtnt()+","+categoryList.get(i).getIntgCdValDesc());
				if (i < categoryList.size()-1)
					data.append("|");
			}
		}
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Approval permission Retrieve"}).getMessage(), ex);
        }		
		return data.toString();
	}
	/**
	 * VOP_OPF_0053 : Retrieve <br>
	 * Retrieve Process Repair Code Combo Data<br>
	 * 
	 * @param 
	 * @return String
	 * @exception EventException
	 */
	private String searchProcessRepairList() throws EventException {
		
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
		

		StringBuffer data = new StringBuffer();
		try{
	        List<ComIntgCdDtlVO> repairList = command.searchComCodeList("CD01887");		    
		if(repairList != null && repairList.size() > 0){
			for (int i = 0; i < repairList.size(); i++) {
				
				data.append(repairList.get(i).getIntgCdValCtnt()+","+repairList.get(i).getIntgCdValDesc());
				if (i < repairList.size()-1)
					data.append("|");
			}
		}
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Approval permission Retrieve"}).getMessage(), ex);
        }		
		return data.toString();
	}
	/**
	 * VOP_OPF_0053 : Retrieve <br>
	 * Retrieve Process Compensation Code Combo Data<br>
	 * 
	 * @param 
	 * @return String
	 * @exception EventException
	 */
	private String searchProcessCompensationList() throws EventException {
		
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
        StringBuffer data = new StringBuffer();
		try{
		// Damage Combo List.
		List<ComIntgCdDtlVO> compenList = command.searchComCodeList("CD01884");

		if(compenList != null && compenList.size() > 0){
			for (int i = 0; i < compenList.size(); i++) {
				
				data.append(compenList.get(i).getIntgCdValCtnt()+","+compenList.get(i).getIntgCdValDesc());
				if (i < compenList.size()-1)
					data.append("|");
			}
		}
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Approval permission Retrieve"}).getMessage(), ex);
        }		
		return data.toString();
	}
	/**
	 * VOP_OPF_0053 : Retrieve <br>
	 * Retrieve Process Settlement Code Combo Data <br>
	 * 
	 * @param 
	 * @return String
	 * @exception EventException
	 */
	private String searchProcessSettlementList() throws EventException {
		
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
        StringBuffer data = new StringBuffer();
		try{
		List<ComIntgCdDtlVO> stlmntList = command.searchComCodeList("CD01889");

		if(stlmntList != null && stlmntList.size() > 0){
			for (int i = 0; i < stlmntList.size(); i++) {
				
				data.append(stlmntList.get(i).getIntgCdValCtnt()+","+stlmntList.get(i).getIntgCdValDesc());
				if (i < stlmntList.size()-1)
					data.append("|");
			}
		}
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Approval permission Retrieve"}).getMessage(), ex);
        }		
		return data.toString();
	}
	// VOP_OPF_0053 End ============================================================//
	
	// VOP_OPF_1053 Start ============================================================//
	/**
	 * VOP_OPF_1053 : Retrieve <br>
	 * Retrieve Stevedore Damage Detail Info<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSdmsDetails(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf1053Event event = (VopOpf1053Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
		SdmsDetailsGRPVO grpVO = command.searchSdmsDetails(event.getOpfStvDmgVO().getStvDmgNo());
		List<OpfStvDmgVO> dmgVOs = null;
		List<OpfStvDmgDtlVO> dmgDtlVOs = null;
		List<OpfStvDmgRprVO> dmgRprVOs = null;
		List<OpfStvDmgCmpnVO> dmgCmpnVOs = null;
		List<OpfStvDmgStlVO> dmgStlVOs = null;
		List<OpfStvDmgAtchFileVO> dmgAtchFileDSDRVOs = null;
		List<OpfStvDmgAtchFileVO> dmgAtchFileDPICVOs = null;
		List<OpfStvDmgAtchFileVO> dmgAtchFileDDOCVOs = null;
		
		List<OpfStvDmgAtchFileVO> dmgAtchFileRRESVOs = null;
		List<OpfStvDmgAtchFileVO> dmgAtchFileRINVVOs = null;
		List<OpfStvDmgAtchFileVO> dmgAtchFileRPICVOs = null;
		List<OpfStvDmgAtchFileVO> dmgAtchFileRDOCVOs = null;
		
		List<OpfStvDmgAtchFileVO> dmgAtchFileSINVVOs = null;
		List<OpfStvDmgAtchFileVO> dmgAtchFileSDOCVOs = null;
		
		if(grpVO!=null){
			dmgVOs = grpVO.getOpfStvDmgVOs();
			dmgDtlVOs = grpVO.getOpfStvDmgDtlVOs();
			dmgRprVOs = grpVO.getOpfStvDmgRprVOs();
			dmgCmpnVOs = grpVO.getOpfStvDmgCmpnVOs();
			dmgStlVOs = grpVO.getOpfStvDmgStlVOs();
			
			dmgAtchFileDSDRVOs = grpVO.getOpfStvDmgAtchFileDSDRVOs();
			dmgAtchFileDPICVOs = grpVO.getOpfStvDmgAtchFileDPICVOs();
			dmgAtchFileDDOCVOs = grpVO.getOpfStvDmgAtchFileDDOCVOs();
			
			dmgAtchFileRRESVOs = grpVO.getOpfStvDmgAtchFileRRESVOs();
			dmgAtchFileRINVVOs = grpVO.getOpfStvDmgAtchFileRINVVOs();
			dmgAtchFileRPICVOs = grpVO.getOpfStvDmgAtchFileRPICVOs();
			dmgAtchFileRDOCVOs = grpVO.getOpfStvDmgAtchFileRDOCVOs();
			
			dmgAtchFileSINVVOs = grpVO.getOpfStvDmgAtchFileSINVVOs();
			dmgAtchFileSDOCVOs = grpVO.getOpfStvDmgAtchFileSDOCVOs();
		}
		
		if(dmgVOs != null) {
			eventResponse.setRsVoList(dmgVOs);
		}
		if(dmgDtlVOs != null) {
			eventResponse.setRsVoList(dmgDtlVOs);
		}
		if(dmgRprVOs != null) {
			eventResponse.setRsVoList(dmgRprVOs);
		}
		if(dmgCmpnVOs != null) {
			eventResponse.setRsVoList(dmgCmpnVOs);
		}
		if(dmgStlVOs != null) {
			eventResponse.setRsVoList(dmgStlVOs);
		}
		if(dmgAtchFileDSDRVOs != null) {
			eventResponse.setRsVoList(dmgAtchFileDSDRVOs);
		}
		if(dmgAtchFileDPICVOs != null) {
			eventResponse.setRsVoList(dmgAtchFileDPICVOs);
		}
		if(dmgAtchFileDDOCVOs != null) {
			eventResponse.setRsVoList(dmgAtchFileDDOCVOs);
		}
		if(dmgAtchFileRRESVOs != null) {
			eventResponse.setRsVoList(dmgAtchFileRRESVOs);
		}
		if(dmgAtchFileRINVVOs != null) {
			eventResponse.setRsVoList(dmgAtchFileRINVVOs);
		}
		if(dmgAtchFileRPICVOs != null) {
			eventResponse.setRsVoList(dmgAtchFileRPICVOs);
		}
		if(dmgAtchFileRDOCVOs != null) {
			eventResponse.setRsVoList(dmgAtchFileRDOCVOs);
		}
		if(dmgAtchFileSINVVOs != null) {
			eventResponse.setRsVoList(dmgAtchFileSINVVOs);
		}
		if(dmgAtchFileSDOCVOs != null) {
			eventResponse.setRsVoList(dmgAtchFileSDOCVOs);
		}
		
		// Approval Auth Check.
		eventResponse.setETCData("approvalPermission", searchApprovalPermissionFlag(e));
		
		// Default Combo Data Setting ======================================//
		// vvd Port Combo List.
		eventResponse.setETCData("vvdPortComboList", searchPortStr(e));
		// Vessel Category Combo List.
		eventResponse.setETCData("vslCategory", searchVesselCategoryList());
		// Damage Category Combo List.
		eventResponse.setETCData("categoryCode", searchDamageCategoryList());
		// Damage Part Combo List.
		eventResponse.setETCData("damageCode", searchDamagePartList());
		// Requirement - Damage Reason Combo List.
		eventResponse.setETCData("reqReasonCode", searchRequirementReasonCodeList("req"));
		// Responsible - Damage Reason Combo List.
		eventResponse.setETCData("resReasonCode", searchRequirementReasonCodeList("res"));
		
		// Currency Code Combo List
		eventResponse.setETCData("currencyCode", searchCurrencyCode(e));
		//==================================================================//
		
		// Repair Default Currency Code.
		eventResponse.setETCData("defaultCurrency", searchDefaultCurrency(e));
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Approval permission Retrieve"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_1053 : Retrieve <br>
	 * Retrieve Approval permission Info of Stevedore Damage Detail<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private String searchApprovalPermissionFlag(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
		int data = 0;
		try{
    		data = command.searchApprovalPermissionCheck(account);
    		if(data > 0){
    			data = 1;
    		}else{
    			data = 0;
    		}
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Approval permission Retrieve"}).getMessage(), ex);
        }
		return String.valueOf(data);
	}
	/**
	 * VOP_OPF_1053 : Blur <br>
	 * Handling VVD Port list retrieve event of Stevedore Damage<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private String searchPortStr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		OpfStvDmgCreateVO vo = new OpfStvDmgCreateVO();
		VopOpf1053Event event = (VopOpf1053Event)e;
		OpfStvDmgVO dtlVo = event.getOpfStvDmgVO();
		vo.setVslCd(dtlVo.getVslCd());
		vo.setSkdVoyNo(dtlVo.getSkdVoyNo());
		vo.setSkdDirCd(dtlVo.getSkdDirCd());
		
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
        StringBuffer data = new StringBuffer();
		try{
		List<VskVslPortSkdVO> list = command.searchVskVslPortSkdVO(vo);

		if(list != null && list.size() > 0){
			for (int i = 0; i < list.size(); i++) {
				
				data.append(list.get(i).getVpsPortCd()+","+list.get(i).getVpsPortCd());
				if (i < list.size()-1)
					data.append("|");
			}
		}
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Approval permission Retrieve"}).getMessage(), ex);
        }
		return data.toString();
	}
	
	/**
	 * VOP_OPF_1053 : Retrieve <br>
	 * Handling Default Currency Code retrieve event of Stevedore Damage<br>
	 * 
	 * @param e Event
	 * @return strData String
	 * @exception EventException
	 */
	private String searchDefaultCurrency(Event e) throws EventException {
		
		VopOpf1053Event event = (VopOpf1053Event)e;
		String currencyCode = "";
		try{
    		 StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
    		 currencyCode = command.searchDefaultCurrency(event.getAttribute("ofc_cd").toString());
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Approval permission Retrieve"}).getMessage(), ex);
        }
		return currencyCode;
	}

	/**
	 * VOP_OPF_1053 : Stevedore Damage Detail <br>
	 * Retrieve USD Info<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private String searchLocalPayUsd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf1053Event event = (VopOpf1053Event)e;
		
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
		String usdAmt = "";
		try{
		    usdAmt = command.searchLocalPayUsd(event.getAttribute("local_amt").toString(), event.getAttribute("curr_cd").toString());
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Approval permission Retrieve"}).getMessage(), ex);
        }
		return usdAmt;
	}	
	
	/**
	 * VOP_OPF_1053 : Retrieve <br>
	 * Handling Currency Code list retrieve event of StevedoreDamageMgt<br>
	 * 
	 * @param e Event
	 * @return strData String
	 * @exception EventException
	 */
	private String searchCurrencyCode(Event e) throws EventException {
		
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
	      StringBuffer data = new StringBuffer();
		try{
		List<MdmCurrencyVO> list = command.searchCurrencyCode();

		if(list != null && list.size() > 0){
			for (int i = 0; i < list.size(); i++) {
				
				data.append(list.get(i).getCurrCd()+","+list.get(i).getCurrCd());
				if (i < list.size()-1)
					data.append("|");
			}
		}
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Approval permission Retrieve"}).getMessage(), ex);
        }
		return data.toString();
	}
	
	/**
	 * VOP_OPF_1053 : Retrieve <br>
	 * Retrieve Stevedore Damage Info.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStvDamage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf1053Event event = (VopOpf1053Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
		try{
		    List<OpfStvDmgVO> list = command.searchStvDamage(event.getOpfStvDmgVO());

    		eventResponse.setRsVoList(list);
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Approval permission Retrieve"}).getMessage(), ex);
        }
		return eventResponse;
	}
	/**
	 * VOP_OPF_1053 : Retrieve <br>
	 * Retrieve Stevedore Damage Detail Info<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDamageDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf1053Event event = (VopOpf1053Event)e;
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
 
		try{
		List<OpfStvDmgDtlVO> list = command.searchDamageDetail(event.getOpfStvDmgDtlVO());

		eventResponse.setRsVoList(list);
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Approval permission Retrieve"}).getMessage(), ex);
        }
		return eventResponse;
	}
	/**
	 * VOP_OPF_1053 : Retrieve <br>
	 * Retrieve Stevedore Damage Repair Info<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDamageRepair(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf1053Event event = (VopOpf1053Event)e;
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
		List<OpfStvDmgRprVO> list = command.searchDamageRepair(event.getOpfStvDmgRprVO());

		eventResponse.setRsVoList(list);
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Approval permission Retrieve"}).getMessage(), ex);
        }
		return eventResponse;
	}
	/**
	 * VOP_OPF_1053 : Retrieve <br>
	 * Retrieve Stevedore Damage Compensation Info.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDamageCompensation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf1053Event event = (VopOpf1053Event)e;
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
		List<OpfStvDmgCmpnVO> list = command.searchDamageCompensation(event.getOpfStvDmgCmpnVO());

		eventResponse.setRsVoList(list);
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Approval permission Retrieve"}).getMessage(), ex);
        }
		return eventResponse;
	}
	/**
	 * VOP_OPF_1053 : Retrieve <br>
	 * Retrieve Stevedore Damage Settlement Info<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDamageSettlement(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf1053Event event = (VopOpf1053Event)e;
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
		List<OpfStvDmgStlVO> list = command.searchDamageSettlement(event.getOpfStvDmgStlVO());

		eventResponse.setRsVoList(list);
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Approval permission Retrieve"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_1053 : Save <br>
	 * Save Stevedore Damage Info<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageStvDamage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf1053Event event = (VopOpf1053Event)e;
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
		try{
			begin();
			command.manageStvDamage(event.getOpfStvDmgVOs(),account);
			// Success Message.
			eventResponse.setUserMessage(new ErrorHandler("OPF50006",new String[]{"Data"}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("OPF50006", new String[]{"Data"}).getMessage(), ex);
        }
		return eventResponse;
	}
	/**
	 * VOP_OPF_1053 : Save <br>
	 * Save Stevedore Damage Detail Info<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDamageDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf1053Event event = (VopOpf1053Event)e;
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
		try{
			begin();
			//command.manageDamageDetail(event.getOpfStvDmgDtlVOs(),account);
			command.manageDamageDetail(event.getOpfStvDmgDtlVOs(), event.getOpfStvDmgAtchFileVOS(), event.getKeys(), account);
			// Success Message.
			eventResponse.setUserMessage(new ErrorHandler("OPF50006",new String[]{"Data"}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("OPF50006", new String[]{"Data"}).getMessage(), ex);
        }
		return eventResponse;
	}
	/**
	 * VOP_OPF_1053 : Save <br>
	 * Save Stevedore Damage Repair Info<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDamageRepair(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf1053Event event = (VopOpf1053Event)e;
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
		try{
			begin();
			//command.manageDamageRepair(event.getOpfStvDmgRprVOs(),account);
			command.manageDamageRepair(event.getOpfStvDmgRprVOs(), event.getOpfStvDmgAtchFileVOS(), event.getKeys(), account);
			// Success Message.
			eventResponse.setUserMessage(new ErrorHandler("OPF50006",new String[]{"Data"}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("OPF50006", new String[]{"Data"}).getMessage(), ex);
        }
		return eventResponse;
	}
	/**
	 * VOP_OPF_1053 : Save <br>
	 * Save Stevedore Damage Compensation Info.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDamageCompensation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf1053Event event = (VopOpf1053Event)e;
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
		try{
			begin();
			command.manageDamageCompensation(event.getOpfStvDmgCmpnVOs(),account);
			
			eventResponse.setETCData("clmHndlOfc", account.getOfc_cd());
			eventResponse.setETCData("clmHndlUsrId", account.getUsr_id());
			eventResponse.setETCData("clmHndlUsrNm", account.getUsr_nm());
			// Success Message.
			eventResponse.setUserMessage(new ErrorHandler("OPF50006",new String[]{"Data"}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("OPF50006", new String[]{"Data"}).getMessage(), ex);
        }
		return eventResponse;
	}
	/**
	 * VOP_OPF_1053 : Save <br>
	 * Save Stevedore Damage Settlement Info<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDamageSettlement(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf1053Event event = (VopOpf1053Event)e;
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
		try{
			begin();
			//command.manageDamageSettlement(event.getOpfStvDmgStlVOs(),account);
			command.manageDamageSettlement(event.getOpfStvDmgStlVOs(), event.getOpfStvDmgAtchFileVOS(), event.getKeys(), account);
			// Success Message.
			eventResponse.setUserMessage(new ErrorHandler("OPF50006",new String[]{"Data"}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("OPF50006", new String[]{"Data"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_1053 : tab <br>
	 * Stevedore Damage Inquiry - Judging whether saving information of each tap is available in Pop-up page<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkTabSavable(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
		VopOpf1053Event event = (VopOpf1053Event)e;
		String result = null;
		try{ 
			result = command.checkTabSavable((String)event.getAttribute("tab_name"), (String)event.getAttribute("stv_dmg_no"));
						
			eventResponse.setETCData("save_check_ind", result);
			
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Stevedore Damage Report"}).getMessage(), ex);
        }
		return eventResponse;
	}	
	
	// VOP_OPF_1053 End ============================================================//
	
	// VOP_OPF_0054 Start ============================================================//
	/**
	 * VOP_OPF_0054 : Retrieve <br>
	 * Retrieve Stevedore Damage History Info<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSDHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0054Event event = (VopOpf0054Event)e;
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
		List<SdmsStepHistoryVO> list = command.searchSDHistoryList(event.getSdmsStepHistoryVO());

		eventResponse.setRsVoList(list);
		
		if(list.size()>0){
			SdmsStepHistoryVO hisVO = list.get(0);
			eventResponse.setETCData("vsl_cd", hisVO.getVslCd());
			eventResponse.setETCData("skd_voy_no", hisVO.getSkdVoyNo());
			eventResponse.setETCData("skd_dir_cd", hisVO.getSkdDirCd());
			eventResponse.setETCData("vps_port_cd", hisVO.getVpsPortCd());
			eventResponse.setETCData("stv_dmg_evnt_dt", hisVO.getStvDmgEvntDt());
			eventResponse.setETCData("slan_cd", hisVO.getSlanCd());
			eventResponse.setETCData("vsl_oshp_cntr_blk_tp_cd", hisVO.getVslOshpCntrBlkTpCd());
			eventResponse.setETCData("stv_dmg_ref_no", hisVO.getStvDmgRefNo());
			eventResponse.setETCData("clm_hndl_ofc_cd", hisVO.getClmHndlOfcCd());
		}
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Stevedore Damage History Retrieve"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0054 : Save <br>
	 * Save Stevedore Damage History Info<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDamageHistory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0054Event event = (VopOpf0054Event)e;
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
		try{
			begin();
			command.manageDamageHistory(event.getOpfStvDmgStepHisVOS(),account);
			// Success Message.
			//eventResponse.setUserMessage(new ErrorHandler("OPF00027").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("OPF50006", new String[]{"Stevedore Damage History"}).getMessage(), ex);
        }
		return eventResponse;
	}
	// VOP_OPF_0054 End ============================================================//
	   
	// VOP_OPF_1052 Start ============================================================//
	/**
	 * Handling certain list retrieve event about event of StevedoreDamageMgt<br>
	 * Retrieve File Upload Data .
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDamageAttachFile(Event e, String eventGubun) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			if("1052".compareTo(eventGubun)==0){  //if(eventGubun=="1052")
			VopOpf1052Event event = (VopOpf1052Event)e;
			StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
			List<OpfStvDmgAtchFileVO> fileList = command.searchDamageAttachFile(event.getOpfStvDmgAtchFileVO());
			eventResponse.setRsVoList(fileList);
		}
		else if("0052".compareTo(eventGubun)==0){    //if(eventGubun=="0052")
			VopOpf0052Event event = (VopOpf0052Event)e;
			StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
			List<OpfStvDmgAtchFileVO> fileList = command.searchDamageAttachFile(event.getOpfStvDmgAtchFileVO());
			eventResponse.setRsVoList(fileList);
		}
		else  if("1053".compareTo(eventGubun)==0){  //if(eventGubun=="1053")
			VopOpf1053Event event = (VopOpf1053Event)e;
			StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
			List<OpfStvDmgAtchFileVO> fileList = command.searchDamageAttachFile(event.getOpfStvDmgAtchFileVO());
			eventResponse.setRsVoList(fileList);
		}		
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"File Upload Data Retrieve"}).getMessage(), ex);
        }
		return eventResponse;
		
	}
	// VOP_OPF_1052 End ============================================================//
	
	// VOP_OPF_0056 Start ============================================================//
	/**
	 * VOP_OPF_0056 : Retrieve <br>
	 * Retrieve Stevedore Damage Report Info.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSdmsReportList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
		VopOpf0056Event event = (VopOpf0056Event)e;
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
		
		List<SdmsReportVO> reportVOs = command.searchSdmsReportList(event.getSdmsReportVO());
		List<SdmsDamageReportVO> dmgVOs = command.searchDamageReportList(event.getSdmsReportVO());
		List<SdmsRepairReportVO> rprVOs = command.searchRepairReportList(event.getSdmsReportVO());
		List<SdmsCompensationReportVO> cmpnVOs = command.searchCompensationReportList(event.getSdmsReportVO());
		List<SdmsSettlementReportVO> stlVOs = command.searchSettlementReportList(event.getSdmsReportVO());
		
		eventResponse.setRsVoList(reportVOs);
		eventResponse.setRsVoList(dmgVOs);
		eventResponse.setRsVoList(rprVOs);
		eventResponse.setRsVoList(cmpnVOs);
		eventResponse.setRsVoList(stlVOs);
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Stevedore Damage Report"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0056 : Retrieve <br>
	 * Retrieve Default Combo Data in Sdms Report page.
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSdmsReportComboList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
		// Vessel Category Combo List.
		eventResponse.setETCData("vslCategory", searchVesselCategoryList());
		// Damage Category Combo List.
		eventResponse.setETCData("categoryCode", searchDamageCategoryList());
		// Damage Part Combo List.
		eventResponse.setETCData("damageCode", searchDamagePartList());
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Sdms Report"}).getMessage(), ex);
        }
		return eventResponse;
		
	}
	// VOP_OPF_0056 End ============================================================//
	/**
	 * VOP_OPF_0052 :in case 'key in', validation check(vsl,vvd,port,lane)
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse checkMainCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
		VopOpf0052Event event = (VopOpf0052Event)e;
		String result = null;
		try{
			VskVslPortSkdVO vskVslPortSkdVO = event.getVskVslPortSkdVO();
			result = command.checkMainCode(vskVslPortSkdVO);
			eventResponse.setETCData("result_chk", result);

			//in case 'P.H.D PORT', retrieve ETB,ETD. 
			if ("PORT".equals(vskVslPortSkdVO.getAutoSkdCngFlg())){
				List<VskVslPortSkdVO> list = command.searchVpsEtbEtdDtList(event.getVskVslPortSkdVO());
				
				StringBuffer vpsEtbEtdDt = new StringBuffer();
				log.debug("\n\n\nlist.size()="+list.size()+"\n\n\n");
				if (list != null && !list.isEmpty()){
					for (int i = 0; i < list.size(); i++){
						if (i == 0)
							vpsEtbEtdDt.append(list.get(i).getVpsEtbDt()+","+list.get(i).getVpsEtdDt());
						else
							vpsEtbEtdDt.append("|"+list.get(i).getVpsEtbDt()+","+list.get(i).getVpsEtdDt());
					}
				}
				
				eventResponse.setETCData("VPS_ETB_DT", vpsEtbEtdDt.toString());
			}
			
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Stevedore Damage Report"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0052 : Adding delete available check logic in case 'Delete'
	 * 
	 * @param String stvDmgNo
	 * @return String
	 * @exception EventException
	 */	
	private EventResponse checkDeleteFlag(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
		VopOpf0052Event event = (VopOpf0052Event)e;
		String result = null;
		try{ 
			result = command.checkDeleteFlag(event.getOpfStvDmgCreateVO().getStvDmgNo());
						
			eventResponse.setETCData("del_check_ind", result);
			
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Stevedore Damage Report"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_1053 : Delete <br>
	 * Delete Stevedore Damage Detail Info <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeDamageDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf1053Event event = (VopOpf1053Event)e;
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
		try{
			begin();
			command.removeDamageDetail(event.getAttribute("del_stv_dmg_no").toString(), event.getAttribute("tab_no").toString(), account);
			// Success Message.
			//eventResponse.setUserMessage(new ErrorHandler("OPF00027").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12196", new String[]{"Stevedore Damage Data"}).getMessage(), ex);
        }
		return eventResponse;
	}
		
}