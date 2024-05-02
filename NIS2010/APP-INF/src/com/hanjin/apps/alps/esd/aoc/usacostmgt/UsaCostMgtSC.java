/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UsaCostMgtSC.java
*@FileTitle : Cost Manage
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2012.10.04 변종건 [CHM-201220395] Add-on Tariff Management 개선 프로젝트
* 2013.02.26 이재위 [CHM-201323148] RF 와 DG 변경시 상태 업데이트
* 2013.09.24 서미진 [CHM-201326830] Batch RF tab 관련 화면로직 보완
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.usacostmgt;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.aoc.common.aoccommon.basic.AocCommonBC;
import com.hanjin.apps.alps.esd.aoc.common.aoccommon.basic.AocCommonBCImpl;
import com.hanjin.apps.alps.esd.aoc.common.aoccommon.basic.AocUtil;
import com.hanjin.apps.alps.esd.aoc.common.aoccommon.vo.AocComboVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.basic.UsaInlandCostManageBC;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.basic.UsaInlandCostManageBCImpl;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.event.EsdAoc3302Event;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.event.EsdAoc3303Event;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.event.EsdAoc3304Event;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.event.EsdAoc3310Event;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.event.EsdAoc3311Event;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlandCostAccountVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlandCostDetailVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlandCostSpecialCargoVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlandCostTariffInfoVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlandCostTariffNoVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlandCostVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlnadCostInquiryVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlnadCostSpeInquiryVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaIpiPortVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaStatusMonitorVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-InlandCostManage Business Logic ServiceCommand - ALPS-InlandCostManage 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author 
 * @see UsaInlandCostManageBCImpl
 * @since J2EE 1.6
 */

public class UsaCostMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * InlandCostManage system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("UsaCostMgtSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * InlandCostManage system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("UsaCostMgtSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-InlandCostManage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if( e.getEventName().equalsIgnoreCase("EsdAoc3302Event") ){
			if(e.getFormCommand().isCommand(FormCommand.SEARCH) ){ //Dry, DG, RF 조회
				eventResponse = searchInlandCost(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH02) ){ //Cost Tariff No
				eventResponse= searchInlandCostTariffNo(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH03) ){ //Cost Tariff No Info
				eventResponse= searchInlandCostTariffInfo(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH04) ){ //Country Code
				eventResponse= verifyCountryCode(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH05) ){ //Check 0 or minus value service mode
				eventResponse= verifyServiceMode(e);
			} else if( e.getFormCommand().isCommand(FormCommand.MULTI01) ){ //Dry Save
				eventResponse = multiInlandCostDry(e);				
			} else if( e.getFormCommand().isCommand(FormCommand.MULTI02) ){ //DG Save
				eventResponse = multiInlandCostSpecialCargo(e);
			} else if( e.getFormCommand().isCommand(FormCommand.MULTI03) ){ //Confirm
				eventResponse = confirmInlandCost(e);
			} else if( e.getFormCommand().isCommand(FormCommand.MULTI04) ){ //Confirm Cancel
				eventResponse = modifyInlandCostMgtCfmCxl(e);
			} else if( e.getFormCommand().isCommand(FormCommand.MULTI05) ){ //Reefer Save
				eventResponse = multiInlandCostReefer(e);				
			}
		}else if( e.getEventName().equalsIgnoreCase("EsdAoc3303Event") ){
			if( e.getFormCommand().isCommand(FormCommand.SEARCH) ){
				eventResponse = searchInlandCostDetail(e);
			} else if( e.getFormCommand().isCommand(FormCommand.MULTI01) ){
				eventResponse = multiInlandCostDetail(e);
			} else if( e.getFormCommand().isCommand(FormCommand.MULTI02) ){
				eventResponse = multiInlandCostDetailDelete(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdAoc3304Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInlandCostAccount(e);
			}
		} else if( e.getEventName().equalsIgnoreCase("EsdAoc3310Event") ){
			if( e.getFormCommand().isCommand(FormCommand.SEARCH) ){
				eventResponse = searchInlnadCostInquiry(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH01) ){
				eventResponse= searchInlnadCostInquiryExcel(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH02) ){
				eventResponse= verifyInlndCostTrfNo(e);
			}
		} else if( e.getEventName().equalsIgnoreCase("EsdAoc3311Event") ){
			if( e.getFormCommand().isCommand(FormCommand.SEARCH) ){
				eventResponse = searchStatusMonitor(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH01) ){ //RHQ : RHQ Office Code List Search
				eventResponse= searchRHQOfficeCode(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH02) ){ //Combo : Combo List Search
				eventResponse= searchCombo3311(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH03) ){ //Country Code Validation
				eventResponse= checkingCountryCode(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * Inland Cost Management tab Dry - Retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3302Event event = (EsdAoc3302Event)e;
		UsaInlandCostManageBC command = new UsaInlandCostManageBCImpl();

		try{
			List<UsaInlandCostVO> list1 				= command.searchInlandCost(event.getInlandCostConditionVO());
			List<UsaInlandCostSpecialCargoVO> list2 	= command.searchInlandCostSpecialCargo(event.getInlandCostConditionVO());
			List<UsaInlandCostVO> list3 				= command.searchInlandCostReefer(event.getInlandCostConditionVO());
			
			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
			eventResponse.setRsVoList(list3);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inland Cost Management - Cost Tariff No <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandCostTariffNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3302Event event = (EsdAoc3302Event)e;
		UsaInlandCostManageBC command = new UsaInlandCostManageBCImpl();

		try{
			List<UsaInlandCostTariffNoVO> list = command.searchInlandCostTariffNo(event.getInCntCd());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inland Cost Management - Country Code 확인 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyCountryCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3302Event event = (EsdAoc3302Event)e;
		UsaInlandCostManageBC command = new UsaInlandCostManageBCImpl();

		try{
			String cnt = command.verifyCountryCode(event.getInCntCd());
			eventResponse.setETCData("cnt", cnt);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Inland Cost Management - Cost Tariff No Info<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandCostTariffInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3302Event event = (EsdAoc3302Event)e;
		UsaInlandCostManageBC command = new UsaInlandCostManageBCImpl();

		try{
			UsaInlandCostTariffInfoVO vo  	= command.searchInlandCostTariffInfo(event.getInCostTrfNo());
			List<UsaIpiPortVO> list 		= command.searchUsaIpiPort(event.getInCostTrfNo());
			eventResponse.setETCData(vo.getColumnValues());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Inland Cost Management tab Dry - Save<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiInlandCostDry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3302Event event = (EsdAoc3302Event)e;
		UsaInlandCostManageBC command = new UsaInlandCostManageBCImpl();
		try{
			String cnt = command.verifyInlandCostConfirm(event.getInlandCostConditionVO().getInCostTrfNo());
			if(cnt.equals("0")){
				begin();
				command.multiInlandCost(event.getInlandCostVOS(), account);
				command.multiInlandCostHdr(event.getInlandCostConditionVO(), account);
				if(event.getInBtnSts().equals("S")){
					eventResponse.setUserMessage(new ErrorHandler("COM12191", new String[]{"Data"}).getUserMessage());
				}
				commit();
			}else{
				eventResponse.setETCData("cnt", cnt);
			}
        } catch (EventException ex) {
        	log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
        	log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Date"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * Inland Cost Management tab Reefer - Save<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse multiInlandCostReefer(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3302Event event = (EsdAoc3302Event)e;
		UsaInlandCostManageBC command = new UsaInlandCostManageBCImpl();
		try{
			String cnt = command.verifyInlandCostConfirm(event.getInlandCostConditionVO().getInCostTrfNo());
			if(cnt.equals("0")){
				begin();
				command.multiInlandCostReefer(event.getInlandCostVOS(), account);
				command.multiInlandCostHdr(event.getInlandCostConditionVO(), account);
				if(event.getInBtnSts().equals("S")){
					eventResponse.setUserMessage(new ErrorHandler("COM12191", new String[]{"Data"}).getUserMessage());
				}	
				commit();
			}else{
				eventResponse.setETCData("cnt", cnt);
			}
        } catch (EventException ex) {
        	log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
        	log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Date"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * Inland Cost Management - Confirm<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmInlandCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3302Event event = (EsdAoc3302Event)e;
		UsaInlandCostManageBC command = new UsaInlandCostManageBCImpl();
		try{
			String cnt = command.verifyInlandCostConfirm(event.getInlandCostConditionVO().getInCostTrfNo());
			if(cnt.equals("0")){
				begin();
				command.confirmInlandCostPreVer(event.getInlandCostConditionVO(), account);
				command.confirmInlandCost(event.getInlandCostConditionVO(), account);
				eventResponse.setUserMessage(new ErrorHandler("COM12191", new String[]{"Confirm"}).getUserMessage());
				commit();
			}else{
				eventResponse.setETCData("cnt", cnt);
			}
        } catch (EventException ex) {
        	log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
        	log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Date"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * Inland Cost Management - Confirm Cancel<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyInlandCostMgtCfmCxl(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3302Event event = (EsdAoc3302Event)e;
		UsaInlandCostManageBC command = new UsaInlandCostManageBCImpl();
		
		try{
			String[] existFlgArr =  command.searchInlandCostGuidelineExist(event.getInlandCostConditionVO().getInCostTrfNo()).split(",");
			
			if( "Y".equals(existFlgArr[0]) ){
				eventResponse.setUserMessage(new ErrorHandler("AOC00003").getUserMessage());
			}else if( "Y".equals(existFlgArr[1]) ){
				eventResponse.setUserMessage(new ErrorHandler("AOC00002").getUserMessage());
			}else{
				begin();			
				command.modifyInlandCostMgtCfmCxl(event.getInlandCostConditionVO(), account);
				command.modifyInlandCostMgtCfmCxlPreVer(event.getInlandCostConditionVO(), account);
				eventResponse.setUserMessage(new ErrorHandler("COM12191", new String[]{"Confirm Cancel"}).getUserMessage());
				commit();
			}
        } catch (EventException ex) {
        	log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
        	log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Date"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * Inland Cost Management tab Special - Save<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiInlandCostSpecialCargo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3302Event event = (EsdAoc3302Event)e;
		UsaInlandCostManageBC command = new UsaInlandCostManageBCImpl();
		try{
			String cnt = command.verifyInlandCostConfirm(event.getInlandCostConditionVO().getInCostTrfNo());
			if(cnt.equals("0")){
				begin();
				command.multiInlandCostSpecialCargo(event.getInlandCostSpecialCargoVOS(), account);
				command.multiInlandCostHdr(event.getInlandCostConditionVO(), account);
				if(event.getInBtnSts().equals("S")){
					eventResponse.setUserMessage(new ErrorHandler("COM12191", new String[]{"Data"}).getUserMessage());
				}
				commit();
			}else{
				eventResponse.setETCData("cnt", cnt);
			}			
        } catch (EventException ex) {
        	log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
        	log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Date"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * Inland Cost Management – Route Detail - Retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandCostDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3303Event event = (EsdAoc3303Event)e;
		UsaInlandCostManageBC command = new UsaInlandCostManageBCImpl();

		try{
			List<UsaInlandCostDetailVO> list = command.searchInlandCostDetail(event.getInlandCostConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Inland Cost Management – Route Detail - Apply<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiInlandCostDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3303Event event = (EsdAoc3303Event)e;
		UsaInlandCostManageBC command = new UsaInlandCostManageBCImpl();
		try{
			begin();
			command.multiInlandCostHdr(event.getInlandCostConditionVO(), account);
			command.multiInlandCostDetailSelect(event.getInlandCostDetailVOS(), account);
			command.multiInlandCostDetailRest(event.getInlandCostDetailVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("COM12191", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
        	log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
        	log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Date"}).getMessage(), ex);
        }
		return eventResponse;
	}

	/**
	 * Inland Cost Management – Route Detail - Delete<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiInlandCostDetailDelete(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3303Event event = (EsdAoc3303Event)e;
		UsaInlandCostManageBC command = new UsaInlandCostManageBCImpl();
		try{
			String cnt = command.searchInlandCostDetailDeleteCheck(event.getInlandCostDetailVOS());
			if(cnt.equals("0")){
				begin();
				command.multiInlandCostDetailDelete(event.getInlandCostDetailVOS(), account);
				eventResponse.setUserMessage(new ErrorHandler("COM12191", new String[]{"Data"}).getUserMessage());
				commit();
			}else{
				eventResponse.setUserMessage(new ErrorHandler("AOC00004").getUserMessage());
			}
        } catch (EventException ex) {
        	log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
        	log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Date"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	

	
	/**
	 * Inland Cost Management - Cost Detail Retrieve. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandCostAccount(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3304Event event = (EsdAoc3304Event)e;
		UsaInlandCostManageBC command = new UsaInlandCostManageBCImpl();

		try{
			List<UsaInlandCostAccountVO> list = command.searchInlandCostAccount(event.getSearchInlandCostAccountVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESD_AOC_3311 : 화면에 대한 콤보리스트 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCombo3311(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		AocUtil aocUtil = new AocUtil();
		List<AocComboVO> list = new ArrayList<AocComboVO>();
		AocComboVO combovo = new AocComboVO();
		
		try {
			/* RHQ Office Combo List */
			list = aocUtil.searchCombo("CD00961");
			combovo.setVal("");
			combovo.setName("All");
			list.add(0,combovo);
			eventResponse.setRsVoList(list);
			
			/* Status Combo List */
			list = aocUtil.searchCombo("CD03051");
			combovo.setVal("");
			combovo.setName("All");
			list.add(0,combovo);
			//Created(B), Updated(U), Confirm(C) 이외의 대상들은 제외
			for( int idx = list.size() - 1; idx >= 0; idx-- ){
				if( !"".equals(list.get(idx).getVal()) && !"B".equals(list.get(idx).getVal()) && !"U".equals(list.get(idx).getVal()) && !"C".equals(list.get(idx).getVal()) ){
					list.remove(idx);
				}
			}
			eventResponse.setRsVoList(list);
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * ESD_AOC_3311 : 화면에 대한 RHQ Office Code 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRHQOfficeCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		AocCommonBC commCommand = new AocCommonBCImpl();
		UsaInlandCostManageBC command = new UsaInlandCostManageBCImpl();

		try {
			/* RHQ Office Code */
			String rhqCd = commCommand.searchRHQOfficeCode(account.getOfc_cd());
			String shqFlg = command.searchShqOfcFlg(account.getOfc_cd());
			eventResponse.setETCData("rhq_cd", rhqCd);
			eventResponse.setETCData("shq_flg", shqFlg);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * ESD_AOC_3311 : Country Code Verify.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkingCountryCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3311Event event = (EsdAoc3311Event)e;
		AocCommonBC commCommand = new AocCommonBCImpl();

		try {
			/* Country Code Verify */
			String errFlg = commCommand.verifyCountryCode(event.getSearchStatusMonitorVO().getCntCd());
			eventResponse.setETCData("err_flg", errFlg);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Cost & Guideline Tariff Status Monitoring - Retrieve. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStatusMonitor(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3311Event event = (EsdAoc3311Event)e;
		UsaInlandCostManageBC command = new UsaInlandCostManageBCImpl();

		try{
			List<UsaStatusMonitorVO> list = command.searchStatusMonitor(event.getSearchStatusMonitorVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Inland Cost Inquiry tab Dry - Retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlnadCostInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3310Event event = (EsdAoc3310Event)e;
		UsaInlandCostManageBC command = new UsaInlandCostManageBCImpl();

		try{
			List<UsaInlnadCostInquiryVO> list = command.searchInlnadCostInquiry(event.getInlandCostConditionVO());
			List<UsaInlnadCostSpeInquiryVO> list2 = command.searchInlnadCostSpeInquiry(event.getInlandCostConditionVO());
			List<UsaInlnadCostInquiryVO> list3 = command.searchInlnadCostRefInquiry(event.getInlandCostConditionVO());
			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(list2);
			eventResponse.setRsVoList(list3);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inland Cost Inquiry tab Dry - Down Excel without Displaying<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlnadCostInquiryExcel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3310Event event = (EsdAoc3310Event)e;
		UsaInlandCostManageBC command = new UsaInlandCostManageBCImpl();

		try{
			if( "D".equals(event.getInlandCostConditionVO().getBntFlg()) ){
				eventResponse.setCustomData("rowset", command.getDryRowSet(event.getInlandCostConditionVO()));
				eventResponse.setCustomData("title", command.getDryTitle(1));
				eventResponse.setCustomData("title2", command.getDryTitle(2));
				eventResponse.setCustomData("columns", command.getDryColumns());
				eventResponse.setCustomData("fileName", "Inland_Cost_Inquiry_Dry.csv");
				eventResponse.setCustomData("isZip", true);
			} else if( "S".equals(event.getInlandCostConditionVO().getBntFlg()) ){
				eventResponse.setCustomData("rowset", command.getSpeRowSet(event.getInlandCostConditionVO()));
				eventResponse.setCustomData("title", command.getSpeTitle(1));
				eventResponse.setCustomData("title2", command.getSpeTitle(2));
				eventResponse.setCustomData("columns", command.getSpeColumns());
				eventResponse.setCustomData("fileName", "Inland_Cost_Inquiry_Special.csv");
				eventResponse.setCustomData("isZip", true);	
			} else if( "R".equals(event.getInlandCostConditionVO().getBntFlg()) ){
				eventResponse.setCustomData("rowset", command.getRefRowSet(event.getInlandCostConditionVO()));
				eventResponse.setCustomData("title", command.getRefTitle(1));
				eventResponse.setCustomData("title2", command.getRefTitle(2));
				eventResponse.setCustomData("columns", command.getRefColumns());
				eventResponse.setCustomData("fileName", "Inland_Cost_Inquiry_Reefer.csv");
				eventResponse.setCustomData("isZip", true);
			}
			
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	
	
	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse verifyInlndCostTrfNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3310Event event = (EsdAoc3310Event)e;
		UsaInlandCostManageBC command = new UsaInlandCostManageBCImpl();

		try {
			/* Cost Tariff No. Verify */
			String errFlg = command.verifyInlndCostTrfNo(event.getInlandCostConditionVO().getCostTrfNo());
			eventResponse.setETCData("err_flg", errFlg);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}

	/**
	 * ESD_AOC_3302
	 * Confirm : verify service mode (0 or minus value)<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyServiceMode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3302Event event = (EsdAoc3302Event)e;
		UsaInlandCostManageBC command = new UsaInlandCostManageBCImpl();
		try{
			String verify_dry = command.verifyServiceMode(event.getInlandCostConditionVO());	
			eventResponse.setETCData("verify_dry", verify_dry);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}	
}