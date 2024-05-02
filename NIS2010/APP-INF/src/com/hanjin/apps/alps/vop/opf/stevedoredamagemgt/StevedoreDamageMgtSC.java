/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StevedoreDamageMgtSC.java
*@FileTitle : Damage Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.05.18 이선영
* 1.0 Creation
* 2010.10.12 이석준 [CSR전 사전 작업] VVD,VSL,Lane,Port 유효성 검사 로직 추가 
*            Delete시 유효성 check logic 추가
* 2010.10.15 이상민 [CHM-201007482-01] 1053 event에 COMMAND01 - checkTabSavable() 추가
* 2011.01.12 진마리아 [CHM-201108239-01] SDMS내 demage date및 삭제 권한 변경 요청 건
* 2011.04.01 공창식 [CHM-201109535-01] SDMS Damage Creation 변경 요청사항
* 2011.10.21 김민아 [CHM-201113609-01] SDMS 신속 처리를 위한 Auto mailing 기능 추가 - 담당자 선택 기능 추가 및 Auto mailing 기능 추가
* 2011.11.08 김민아 [CHM-201114487-01] SDMS내 과거 SDR 입력 불가 관련 기능 개선 요청
* 2011.11.21 김민아 [CHM-201114254-01] [VOP-OPF/SDMS] Repaur VVD 및 Port 설정 기능 변경
=========================================================*/
package com.hanjin.apps.alps.vop.opf.stevedoredamagemgt;

import java.util.List;

import com.hanjin.apps.alps.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.basic.OperationNPerformMasterDataMgtBC;
import com.hanjin.apps.alps.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.basic.OperationNPerformMasterDataMgtBCImpl;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.basic.OpfUtilBC;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.basic.OpfUtilBCImpl;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.MdmVslCntrInfoVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.OpfComboVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.OpfUtilSearchOptVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.SearchVVDVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.basic.StevedoreDamageMgtBC;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.basic.StevedoreDamageMgtBCImpl;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event.VopOpf0052Event;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event.VopOpf0053Event;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event.VopOpf0054Event;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event.VopOpf0056Event;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event.VopOpf1052Event;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event.VopOpf1053Event;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration.StevedoreDamageMgtDBDAO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.OpfStvDmgCmpnVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.OpfStvDmgCreateVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.RsltOpfStvDmgEmlSndHisVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsCompensationReportVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsDamageReportVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsDetailsGRPVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsOptionVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsPortStayingDatesVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsRepairReportVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsReportVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsSettlementReportVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsStepHistoryVO;
import com.hanjin.bizcommon.currency.vo.MdmCurrencyVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ComIntgCdDtlVO;
import com.hanjin.syscommon.common.table.ComUserVO;
import com.hanjin.syscommon.common.table.MdmOrganizationVO;
import com.hanjin.syscommon.common.table.OpfStvDmgAtchFileVO;
import com.hanjin.syscommon.common.table.OpfStvDmgCdVO;
import com.hanjin.syscommon.common.table.OpfStvDmgDtlVO;
import com.hanjin.syscommon.common.table.OpfStvDmgRprVO;
import com.hanjin.syscommon.common.table.OpfStvDmgStlVO;
import com.hanjin.syscommon.common.table.OpfStvDmgVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;
import com.hanjin.syscommon.common.table.VskVslSkdVO;

/**
 * NIS2010-StevedoreDamageMgt Business Logic ServiceCommand - NIS2010-StevedoreDamageMgt 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Sunyoung
 * @see StevedoreDamageMgtDBDAO
 * @since J2EE 1.4
 */

public class StevedoreDamageMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * StevedoreDamageMgt system 업무 시나리오 선행작업<br>
	 * VOP_OPF_0052업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * StevedoreDamageMgt system 업무 시나리오 마감작업<br>
	 * VOP_OPF_0052 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("StevedoreDamageMgtSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-StevedoreDamageMgt system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
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
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchMdmVslCntrInfoList ( e );
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
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)){
				eventResponse = searchVesselPortSkd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)){
				eventResponse = searchVesselPortStayingDates(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)){
				eventResponse = searchReqVesselPortSkd(e);
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
			}//2010.12.15 이상민
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = checkTabSavable(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = searchMdmLocation(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)) {
				eventResponse = searchReqVesselPortSkd(e);
			}//2011.1.7 진마리아
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
	 * Stevedore Damage 정보를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDamage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0052Event event = (VopOpf0052Event)e;
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
		OpfUtilBC command2 = new OpfUtilBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
		try{
    		List<OpfStvDmgCreateVO> list = command.searchDamage(event.getOpfStvDmgCreateVO());
    		List<RsltOpfStvDmgEmlSndHisVO> list2 = command.searchDamageClaimHandlingUser(event.getOpfStvDmgEmlSndHisVO());
    		StringBuffer data01 = new StringBuffer();
    		
    		if(list != null && list.size() > 0){
    			OpfUtilSearchOptVO opfUtilSearchOptVO = new OpfUtilSearchOptVO();
    			opfUtilSearchOptVO.setVslCd(list.get(0).getReqVslCd());
    			opfUtilSearchOptVO.setVoyNo(list.get(0).getReqSkdVoyNo());
    			opfUtilSearchOptVO.setDirCd(list.get(0).getReqSkdDirCd());
    			
            	//Requirement port combo 구하기
            	List<OpfComboVO> list3 = command2.searchVskVslPortEtaList(opfUtilSearchOptVO);
            	//List<VskVslPortSkdVO> list2 = command2.searchVskVslPortSkdVO(event.getOpfStvDmgCreateVO());
            	
        		if(list3 != null && list3.size() > 0){
        			for (int i = 0; i < list3.size(); i++) {    				    				
        				data01.append(list3.get(i).getComboCd()+","+list3.get(i).getClptIndSeq()+","+list3.get(i).getVal());

        				if (i < list3.size()-1)
        					data01.append("|");
        			}
        		}
    		}
    		
			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(list2);
			
			eventResponse.setETCData("reqPortComboList", data01.toString());
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
	 * Stevedore Damage 정보를 조회 합니다. <br>
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
	 * VOP_OPF_0052 : Retrieve <br>
	 * Stevedore Damage 의 VesselCategory 정보를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmVslCntrInfoList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0052Event event = (VopOpf0052Event)e;
		OpfUtilBC command = new OpfUtilBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();				
        try{        	
        	List<MdmVslCntrInfoVO> list = command.searchMdmVslCntrInfoList(event.getOpfStvDmgCreateVO());

        	if(list != null && list.size() > 0){
        		eventResponse.setETCData("vslCategoryCd", list.get(0).getVslOshpCntrBlkTpCd());
        		eventResponse.setETCData("vslCategoryNm", list.get(0).getVslOshpCntrBlkTpCdDesc());
        	}		
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Stevedore Damage VesselCategory Retrieve"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0052 : Delete <br>
	 * Stevedore Damage 정보를 삭제 합니다. <br>
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
	 * Stevedore Damage 정보를 저장 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDamage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		VopOpf0052Event 		event 			= (VopOpf0052Event)e;
		StevedoreDamageMgtBC 	command 		= new StevedoreDamageMgtBCImpl();
		
		try{
			begin();
			String etcData = command.manageDamage(event.getOpfStvDmgCreateVOS(),event.getOpfStvDmgAtchFileVOS(), event.getStrKeys(), event.getOpfStvDmgEmlSndHisVOS(), account);
			String[] arrData = etcData.split("[.]");
			eventResponse.setETCData("stvDmgNoList", arrData[0]);

			// Success Message.
			if("Y".equals(arrData[1])){
				eventResponse.setUserMessage(new ErrorHandler("OPF00009",new String[]{""}).getUserMessage());
			}else{
				eventResponse.setUserMessage(new ErrorHandler("OPF50006",new String[]{"Data"}).getUserMessage());
			}
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
	 * Stevedore Damage 의 Approval 정보를 저장 합니다. <br>
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
	 * Stevedore Damage 의 Port 정보를 조회 합니다. <br>
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
    				
    				data.append(list.get(i).getVpsPortCd()+","+list.get(i).getYdCd());
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
	 * Stevedore Damage 의 Lane 정보를 조회 합니다. <br>
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
	 * Stevedore Damage 의 event에 대한 Default Combo Data 조회 이벤트 처리<br>
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
		//eventResponse.setETCData("vslCategory", searchVesselCategoryList());
		// Damage Category Combo List.
		eventResponse.setETCData("categoryCode", searchDamageCategoryList());
		// Damage Part Combo List.
		eventResponse.setETCData("damageCode", searchDamagePartList());
		// Requirement - Damage Reason Combo List.
		eventResponse.setETCData("reqReasonCode", searchRequirementReasonCodeList("req"));
		// Responsible Party Combo List.
		eventResponse.setETCData("responsiblePartyCode", searchResponsiblePartyList());
		// Responsible - Damage Reason Combo List.
		eventResponse.setETCData("resReasonCode", searchRequirementReasonCodeList("res"));
		
		
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
	 * Vessel Category Code Combo Data 조회<br>
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
	 * Responsible Party Code Combo Data 조회<br>
	 * 
	 * @param  String rsnFlag
	 * @return String
	 * @exception EventException
	 */
	private String searchResponsiblePartyList() throws EventException {		
		StringBuffer data = new StringBuffer();
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
		try{
		List<ComIntgCdDtlVO> responsiblePartyCode = command.searchComCodeList("CD02809");

		if(responsiblePartyCode != null && responsiblePartyCode.size() > 0){
			for (int i = 0; i < responsiblePartyCode.size(); i++) {
				
				data.append(responsiblePartyCode.get(i).getIntgCdValCtnt()+","+responsiblePartyCode.get(i).getIntgCdValDesc());
				if (i < responsiblePartyCode.size()-1)
					data.append("|");
			}
		}
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("CD02809", new String[]{"Damage Reason Retrieve"}).getMessage(), ex);
        }
		return data.toString();
	}
	
	/**
	 * VOP_OPF_0052 : Retrieve <br>
	 * Damage Category Code Combo Data 조회<br>
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
	 * Damage Part Code Combo Data 조회<br>
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
	 * Damage Reason Code Combo Data 조회<br>
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
	 * Vessel Category Part Code Combo Data 조회<br>
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
				//선택된 Category에 해당하는 Part Code만 가져온다.
				if(event.getOpfStvDmgCreateVO().getStvDmgPrtCateCd().equals(list.get(i).getStvDmgCateCd())){
					data.append(list.get(i).getStvDmgCd()+","+list.get(i).getStvDmgCdDesc()+"|");
				}
			}
		}
		data.delete(data.length()-1, data.length()); //마지막 구분자 ("|")제거.
		

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
	 * Stevedore Damage 의 Approval permission 정보를 조회 합니다.<br>
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
    //		// 오늘날짜 구하기.
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
	 * Stevedore Damage 의 ETA/ETD Date 정보를 조회 합니다.<br>
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
	 * Stevedore Damage 의 Office Code 정보를 조회 합니다.<br>
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
	 * Stevedore Damage 의 E-mail [PIC of Claim Handling Office] 정보를 조회 합니다.<br>
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
	 * Stevedore Damage Inquiry 정보를 조회 합니다.<br>
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
	 * Stevedore Damage의 event에 대한 Default Combo Data 조회 이벤트 처리<br>
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
	 * Process Category Code Combo Data 조회<br>
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
	 * Process Repair Code Combo Data 조회<br>
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
	 * Process Compensation Code Combo Data 조회<br>
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
	 * Process Settlement Code Combo Data 조회<br>
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
	 * Stevedore Damage Detail 정보를 조회 합니다.<br>
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
		OpfUtilBC command2 = new OpfUtilBCImpl();
		
		SdmsDetailsGRPVO grpVO = command.searchSdmsDetails(event.getOpfStvDmgVO().getStvDmgNo());
		List<OpfStvDmgVO>         dmgVOs     = null;
		List<OpfStvDmgDtlVO>      dmgDtlVOs  = null;
		List<OpfStvDmgRprVO>      dmgRprVOs  = null;
		List<OpfStvDmgCmpnVO>     dmgCmpnVOs = null;
		List<OpfStvDmgStlVO>      dmgStlVOs  = null;
		List<OpfStvDmgAtchFileVO> dmgAtchFileDSDRVOs = null;
		List<OpfStvDmgAtchFileVO> dmgAtchFileDPICVOs = null;
		List<OpfStvDmgAtchFileVO> dmgAtchFileDDOCVOs = null;
		
		List<OpfStvDmgAtchFileVO> dmgAtchFileRRESVOs = null;
		List<OpfStvDmgAtchFileVO> dmgAtchFileRINVVOs = null;
		List<OpfStvDmgAtchFileVO> dmgAtchFileRPICVOs = null;
		List<OpfStvDmgAtchFileVO> dmgAtchFileRDOCVOs = null;
		
		List<OpfStvDmgAtchFileVO> dmgAtchFileSINVVOs = null;
		List<OpfStvDmgAtchFileVO> dmgAtchFileSDOCVOs = null;
		
		// Claim Handling User 셋팅
		List<RsltOpfStvDmgEmlSndHisVO> rsltOpfStvDmgEmlSndHisVOs = command.searchDamageClaimHandlingUser(event.getOpfStvDmgEmlSndHisVO());
		
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

		if ( dmgVOs !=  null ) {
			eventResponse.setRsVoList(dmgVOs);
		}
		if ( dmgDtlVOs !=  null ) {
			eventResponse.setRsVoList(dmgDtlVOs);
			
			OpfUtilSearchOptVO opfUtilSearchOptVO = new OpfUtilSearchOptVO();
			opfUtilSearchOptVO.setVslCd(dmgDtlVOs.get(0).getReqVslCd());
			opfUtilSearchOptVO.setVoyNo(dmgDtlVOs.get(0).getReqSkdVoyNo());
			opfUtilSearchOptVO.setDirCd(dmgDtlVOs.get(0).getReqSkdDirCd());
			
			//Requirement port combo 구하기
	    	List<OpfComboVO> list2 = command2.searchVskVslPortEtaList(opfUtilSearchOptVO);
	    	
	    	StringBuffer data01 = new StringBuffer();
	    	
			if(list2 != null && list2.size() > 0){
				for (int i = 0; i < list2.size(); i++) {    				    				
					data01.append(list2.get(i).getComboCd()+","+list2.get(i).getClptIndSeq()+","+list2.get(i).getVal());

					if (i < list2.size()-1)
						data01.append("|");
				}
			}
			eventResponse.setETCData("reqPortComboList", data01.toString());
		}
		if ( dmgRprVOs !=  null ) {
			eventResponse.setRsVoList(dmgRprVOs);
		}
		if ( dmgCmpnVOs !=  null ) {
			eventResponse.setRsVoList(dmgCmpnVOs);
		}
		if ( dmgStlVOs !=  null ) {
			eventResponse.setRsVoList(dmgStlVOs);
		}
		if ( dmgAtchFileDSDRVOs !=  null ) {
			eventResponse.setRsVoList(dmgAtchFileDSDRVOs);
		}
		if ( dmgAtchFileDPICVOs !=  null ) {
			eventResponse.setRsVoList(dmgAtchFileDPICVOs);
		}
		if ( dmgAtchFileDDOCVOs !=  null ) {
			eventResponse.setRsVoList(dmgAtchFileDDOCVOs);
		}
			
		if ( dmgAtchFileRRESVOs !=  null ) {
			eventResponse.setRsVoList(dmgAtchFileRRESVOs);
		}
		if ( dmgAtchFileRINVVOs !=  null ) {
			eventResponse.setRsVoList(dmgAtchFileRINVVOs);
		}
		if ( dmgAtchFileRPICVOs !=  null ) {
			eventResponse.setRsVoList(dmgAtchFileRPICVOs);
		}
		if ( dmgAtchFileRDOCVOs !=  null ) {
			eventResponse.setRsVoList(dmgAtchFileRDOCVOs);
		}
			
		if ( dmgAtchFileSINVVOs !=  null ) {
			eventResponse.setRsVoList(dmgAtchFileSINVVOs);
		}
		if ( dmgAtchFileSDOCVOs !=  null ) {
			eventResponse.setRsVoList(dmgAtchFileSDOCVOs);
		}
		
		if ( rsltOpfStvDmgEmlSndHisVOs != null ) {
			eventResponse.setRsVoList(rsltOpfStvDmgEmlSndHisVOs);
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
		
		// Responsible Party Combo List.
		eventResponse.setETCData("responsiblePartyCode", searchResponsiblePartyList());
		
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
	 * Stevedore Damage Detail의 Approval permission 정보를 조회 합니다.<br>
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
	 * Stevedore Damage의 VVD Port 리스트 조회 이벤트 처리<br>
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
	 * Stevedore Damage의 Default Currency Code 조회 이벤트 처리<br>
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
	 * USD 정보를 조회 합니다.<br>
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
	 * StevedoreDamageMgt의 Currency Code 리스트 조회 이벤트 처리<br>
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
	 * Stevedore Damage 정보를 조회 합니다.<br>
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
	 * Stevedore Damage Detail 정보를 조회 합니다.<br>
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
	 * Stevedore Damage Repair 정보를 조회 합니다.<br>
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
	 * Stevedore Damage Compensation 정보를 조회 합니다.<br>
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
	 * Stevedore Damage Settlement 정보를 조회 합니다.<br>
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
	 * Stevedore Damage 정보를 저장 합니다.<br>
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
			command.manageStvDamage(event.getOpfStvDmgVOs(), account);
			
			String emailSendMark = command.manageDamageDetail(event.getOpfStvDmgDtlVOs(), event.getOpfStvDmgAtchFileVOS(), event.getKeys(), event.getOpfStvDmgEmlSndHisVOs(), account);
			// Success Message.
			if("Y".equals(emailSendMark)){
				eventResponse.setUserMessage(new ErrorHandler("OPF00009",new String[]{""}).getUserMessage());
			}else{
				eventResponse.setUserMessage(new ErrorHandler("OPF50006",new String[]{"Data"}).getUserMessage());
			}
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
	 * Stevedore Damage Detail 정보를 저장 합니다.<br>
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
			String emailSendMark = command.manageDamageDetail(event.getOpfStvDmgDtlVOs(), event.getOpfStvDmgAtchFileVOS(), event.getKeys(), event.getOpfStvDmgEmlSndHisVOs(), account);
			
			// Success Message.
			if("Y".equals(emailSendMark)){
				eventResponse.setUserMessage(new ErrorHandler("OPF00009",new String[]{""}).getUserMessage());
			}else {
				eventResponse.setUserMessage(new ErrorHandler("OPF50006",new String[]{"Data"}).getUserMessage());
			}
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
	 * Stevedore Damage Repair 정보를 저장 합니다.<br>
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
			String emailSendMark = command.manageDamageRepair(event.getOpfStvDmgRprVOs(), event.getOpfStvDmgAtchFileVOS(), event.getKeys(), event.getOpfStvDmgEmlSndHisVOs(), account);
			// Success Message.
			if("Y".equals(emailSendMark)){
				eventResponse.setUserMessage(new ErrorHandler("OPF00009",new String[]{""}).getUserMessage());
			}else {
				eventResponse.setUserMessage(new ErrorHandler("OPF50006",new String[]{"Data"}).getUserMessage());
			}
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
	 * Stevedore Damage Compensation 정보를 저장 합니다.<br>
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
	 * Stevedore Damage Settlement 정보를 저장 합니다.<br>
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
	 * Stevedore Damage Inquiry - popup화면에서 각 탭의 정보를 저장할 수 있는지 판단합니다.<br>
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
	 * Stevedore Damage History 정보를 조회 합니다.<br>
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
	 * Stevedore Damage History 정보를 저장 합니다.<br>
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
	 * 조회 이벤트 처리<br>
	 * StevedoreDamageMgt의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * File Upload Data 조회.
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDamageAttachFile(Event e, String eventGubun) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			if(eventGubun.equals("1052")){
				VopOpf1052Event event = (VopOpf1052Event)e;
				StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
				List<OpfStvDmgAtchFileVO> fileList = command.searchDamageAttachFile(event.getOpfStvDmgAtchFileVO());
				eventResponse.setRsVoList(fileList);
			}
			else if(eventGubun.equals("0052")){
				VopOpf0052Event event = (VopOpf0052Event)e;
				StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
				List<OpfStvDmgAtchFileVO> fileList = command.searchDamageAttachFile(event.getOpfStvDmgAtchFileVO());
				eventResponse.setRsVoList(fileList);
			}
			else if(eventGubun.equals("1053")){
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
	 * Stevedore Damage Report 정보를 조회 합니다.<br>
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
	 * Sdms Report 화면의 Default Combo Data 조회.
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
	 * VOP_OPF_0052 : key in시에 validation check(vsl,vvd,port,lane)
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

			//2011.01.07 P.H.D PORT인 경우 ETB,ETD일자를 조회한다. 
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
	 * VOP_OPF_0052 : key in시에 validation check(vsl,vvd,port)
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchVesselPortSkd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		OpfUtilBC command = new OpfUtilBCImpl();
//		StevedoreDamageMgtBC command2 = new StevedoreDamageMgtBCImpl();
		VopOpf0052Event event = (VopOpf0052Event)e;
		
		try{
			List<SearchVVDVO> list = command.searchVVD(event.getVskVslSkdVO());

        	if(list != null && list.size() > 0){
        		eventResponse.setETCData("vslCd", list.get(0).getVslCd());
        	}else{
        		return eventResponse;
        	}				
        	
        	//Requirement port combo 구하기
        	List<OpfComboVO> list2 = command.searchVskVslPortList(event.getTerminalDepartureReportCondVO());
        	//List<VskVslPortSkdVO> list2 = command2.searchVskVslPortSkdVO(event.getOpfStvDmgCreateVO());
        	
        	StringBuffer data01 = new StringBuffer();
        	StringBuffer data02 = new StringBuffer();
        	StringBuffer data03 = new StringBuffer();
    		if(list2 != null && list2.size() > 0){
    			for (int i = 0; i < list2.size(); i++) {    				    				
    				//data.append(list2.get(i).getVal()+","+list2.get(i).getYdCd()+","+list2.get(i).getTurnPortIndCd());
    				//data.append(list2.get(i).getVpsPortCd()+","+list2.get(i).getYdCd());
    				data01.append(list2.get(i).getVal()+","+list2.get(i).getYdCd());
    				data02.append(list2.get(i).getYdCd()+","+list2.get(i).getYdCd());
    				data03.append(list2.get(i).getTurnPortIndCd()+","+list2.get(i).getTurnPortIndCd());
    				if (i < list2.size()-1)
    					data01.append("|");
	    				data02.append("|");
	    				data03.append("|");
    			}
    		}
    		eventResponse.setETCData("portComboList", data01.toString());
    		eventResponse.setETCData("ydComboList", data02.toString());
    		eventResponse.setETCData("turnPortindCdComboList", data03.toString());
    		
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Stevedore Damage Creation"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0052 : key in시에 validation check(port)
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchVesselPortStayingDates(Event e) throws EventException {
		
		VopOpf0052Event event = (VopOpf0052Event)e;
        OpfUtilBC command = new OpfUtilBCImpl();
		StevedoreDamageMgtBC command2 = new StevedoreDamageMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			//텍스트 입력
			if("".equals(event.getOpfUtilSearchOptVO().getYdCd())){
				List<OpfComboVO> list = command.searchPortInfo(event.getOpfUtilSearchOptVO());
				if(list != null && list.size() > 0){
	        		//결과값 있으면 유효한 port
					event.getVskVslPortSkdVO().setVpsPortCd(list.get(0).getVal());
	        	}else{
	        		//결과값 없으면 리턴
					//eventResponse.setETCData("result", list.get(0).getVal());
					return eventResponse;
	        	}			
			}
			
			//텍스트 입력, 콤보선택
			List<SdmsPortStayingDatesVO> list2 = command2.searchVesselPortStayingDates(event.getVskVslPortSkdVO());
			eventResponse.setETCData("ofcCd", list2.get(0).getOfcCd());
			
			StringBuffer data = new StringBuffer();
    		if(list2 != null && list2.size() > 0){
    			for (int i = 0; i < list2.size(); i++) {
    				data.append(list2.get(i).getStayingDt()+","+list2.get(i).getStayingDt());
    				if (i < list2.size()-1)
    					data.append("|");
    			}
    		}

    		eventResponse.setETCData("dmgDt", data.toString());
    		eventResponse.setETCData("result", "true");
			
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Stevedore Damage Creation"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0052 : Delete시에 delete 가능 여부 확인 로직 추가
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
	 * Stevedore Damage Detail 정보를 삭제 합니다. <br>
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
	
	/**
	 * VOP_OPF_0052, VOP_OPF_1053 : Requirement Voyage No. 에 따른 Port 및 ETA 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchReqVesselPortSkd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		OpfUtilBC command = new OpfUtilBCImpl();
		OpfUtilSearchOptVO paramVO = new OpfUtilSearchOptVO();
		
		if(e.getEventName().equalsIgnoreCase("VopOpf0052Event")){
			VopOpf0052Event event = (VopOpf0052Event)e;
			paramVO = event.getOpfUtilSearchOptVO();
		} else if(e.getEventName().equalsIgnoreCase("VopOpf1053Event")){
			VopOpf1053Event event = (VopOpf1053Event)e;
			paramVO = event.getOpfUtilSearchOptVO();
		}
		
		try{
        	//Requirement port combo 구하기
        	List<OpfComboVO> list = command.searchVskVslPortEtaList(paramVO);
        	
        	StringBuffer data01 = new StringBuffer();
        	
    		if(list != null && list.size() > 0){
    			for (int i = 0; i < list.size(); i++) {    				    				
    				data01.append(list.get(i).getComboCd()+","+list.get(i).getClptIndSeq()+","+list.get(i).getVal());

    				if (i < list.size()-1)
    					data01.append("|");
    			}
    		}
    		eventResponse.setETCData("reqPortComboList", data01.toString());
    		
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Stevedore Damage Creation"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_1053 : Port 에 해당하는 Claim Handling Office 가져오기
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchMdmLocation(Event e) throws EventException {
		
		VopOpf1053Event event = (VopOpf1053Event)e;
		StevedoreDamageMgtBC command = new StevedoreDamageMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			
			//텍스트 입력, 콤보선택
			List<SdmsPortStayingDatesVO> list2 = command.searchVesselPortStayingDates(event.getVskVslPortSkdVO());
			eventResponse.setETCData("ofcCd", list2.get(0).getOfcCd());
			
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Stevedore Damage Creation"}).getMessage(), ex);
        }
		return eventResponse;
	}
		
}