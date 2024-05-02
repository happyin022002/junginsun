/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : InlandCostManageSC.java
*@FileTitle : Inland Cost Manage
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2012.07.03 변종건 [CHM-201217633] Ocean Feeder Cost Management 수정 및 신규 탭 추가
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costmanage;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.trs.common.trscommon.basic.TrsCommonBC;
import com.hanjin.apps.alps.esd.trs.common.trscommon.basic.TrsCommonBCImpl;
import com.hanjin.apps.alps.esd.trs.common.trscommon.basic.TrsUtil;
import com.hanjin.apps.alps.esd.trs.common.trscommon.vo.TrsComboVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.basic.InlandCostManageBC;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.basic.InlandCostManageBCImpl;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.event.EsdTrs3001Event;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.event.EsdTrs3002Event;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.event.EsdTrs3005Event;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.event.EsdTrs3007Event;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.event.EsdTrs3015Event;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.event.EsdTrs3016Event;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.integration.InlandCostManageDBDAO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.CntDefaultCurrVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.CntInfoVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlandCostDetailVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlandCostSpecialCargoVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlandCostTariffInfoVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlandCostTariffNoVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlandCostVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlnadCostInquiryVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlnadCostSpeInquiryVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.RHQComboVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.SearchInlandCostAccountVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.SearchStatusMonitorVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.basic.OceanFeederCostManageBC;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.basic.OceanFeederCostManageBCImpl;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.event.EsdTrs3009Event;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.event.EsdTrs3013Event;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.event.EsdTrs3019Event;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.FeederCostDGVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.FeederCostInquiryVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.FeederCostTariffInfoVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.FeederCostTariffNoVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.FeederCostVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.SearchFeederDgCostVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.SearchFeederReeferCostVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.SearchOceanFeederCostAccountVO;
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
 * @author Kim Jong Ock
 * @see InlandCostManageDBDAO
 * @since J2EE 1.6
 */

public class CostManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * InlandCostManage system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("InlandCostManageSC 시작");
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
		log.debug("InlandCostManageSC 종료");
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
		if (e.getEventName().equalsIgnoreCase("EsdTrs3001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { //Dry
				eventResponse = searchInlandCost(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //Special
				eventResponse= searchInlandCostSpecialCargo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { //Cost Tariff No
				eventResponse= searchInlandCostTariffNo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { //Cost Tariff No Info
				eventResponse= searchInlandCostTariffInfo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) { //Country Code
				eventResponse= verifyCountryCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){ //Dry
				eventResponse = multiInlandCost(e);				
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){ //Special
				eventResponse = multiInlandCostSpecialCargo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI03)){ //Confirm				  
				eventResponse = confirmInlandCost(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI04)){ //Confirm Cancel
				eventResponse = modifyInlandCostMgtCfmCxl(e);				
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdTrs3002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInlandCostDetail(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = multiInlandCostDetail(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){
				eventResponse = multiInlandCostDetailDelete(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdTrs3005Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInlandCostAccount(e);
			}
		} else if( e.getEventName().equalsIgnoreCase("EsdTrs3007Event") ){
			if( e.getFormCommand().isCommand(FormCommand.SEARCH) ){
				eventResponse = searchInlnadCostInquiry(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH01) ){
				eventResponse= searchInlnadCostInquiryExcel(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH02) ){
				eventResponse= verifyInlndCostTrfNo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs3009Event")) {
			if( e.getFormCommand().isCommand(FormCommand.SEARCH) ){
				eventResponse = searchFeederCost(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH02) ){ //Cost Tariff No
				eventResponse= searchFeederCostTariffNo(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH03) ){ //Cost Tariff No Info
				eventResponse= searchFeederCostTariffInfo(e);
			} else if( e.getFormCommand().isCommand(FormCommand.MULTI01) ){ //Dry
				eventResponse = multiFeederCost(e);				
			} else if( e.getFormCommand().isCommand(FormCommand.MULTI02) ){ //Reefer
				eventResponse = multiFeederRfCost(e);
			} else if( e.getFormCommand().isCommand(FormCommand.MULTI03) ){ //Confirm
				eventResponse = confirmFeederCost(e);				
			} else if( e.getFormCommand().isCommand(FormCommand.MULTI04) ){ //Confirm Cancel
				eventResponse = modifyFeederCostMgtCfmCxl(e);				
			} else if( e.getFormCommand().isCommand(FormCommand.MULTI05) ){ //Dangerous
				eventResponse = multiFeederDgCost(e);
			}
		} else if( e.getEventName().equalsIgnoreCase("EsdTrs3013Event")) {
			if ( e.getFormCommand().isCommand(FormCommand.SEARCH) ){
				eventResponse = searchFeederCostInquiry(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH01) ){
				eventResponse= searchFeederCostInquiryExcel(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH02) ){
				eventResponse= verifyFeederCostTrfNo(e);
			}		
		} else if( e.getEventName().equalsIgnoreCase("EsdTrs3015Event") ){
			if( e.getFormCommand().isCommand(FormCommand.SEARCH) ){
				eventResponse = searchStatusMonitor(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH01) ){ //RHQ : RHQ Office Code List Search
				eventResponse= searchRHQOfficeCode(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH02) ){ //Combo : Combo List Search
				eventResponse= searchCombo3015(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH03) ){ //Country Code Validation
				eventResponse= checkingCountryCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdTrs3016Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCntDefaultCurr(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //RHQ 
				eventResponse= searchRHQCombo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { //Country Code
				eventResponse= searchCntInfo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { //Currency Code
				eventResponse= searchCurrNm(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) { //Currency Code 확인
				eventResponse= verifyCurrencyCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = multiCntDefaultCurr(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){
				eventResponse = removeCntDefaultCurr(e);				
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdTrs3019Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOceanFeederCostAccount(e);
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
		EsdTrs3001Event event = (EsdTrs3001Event)e;
		InlandCostManageBC command = new InlandCostManageBCImpl();

		try{
			List<InlandCostVO> list = command.searchInlandCost(event.getInlandCostConditionVO());
			List<InlandCostSpecialCargoVO> list2 = command.searchInlandCostSpecialCargo(event.getInlandCostConditionVO());
			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(list2);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Inland Cost Management tab Special - Retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandCostSpecialCargo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs3001Event event = (EsdTrs3001Event)e;
		InlandCostManageBC command = new InlandCostManageBCImpl();

		try{
			List<InlandCostSpecialCargoVO> list = command.searchInlandCostSpecialCargo(event.getInlandCostConditionVO());
			eventResponse.setRsVoList(list);
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
		EsdTrs3001Event event = (EsdTrs3001Event)e;
		InlandCostManageBC command = new InlandCostManageBCImpl();

		try{
			List<InlandCostTariffNoVO> list = command.searchInlandCostTariffNo(event.getInCntCd());
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
		EsdTrs3001Event event = (EsdTrs3001Event)e;
		InlandCostManageBC command = new InlandCostManageBCImpl();

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
		EsdTrs3001Event event = (EsdTrs3001Event)e;
		InlandCostManageBC command = new InlandCostManageBCImpl();

		try{
			InlandCostTariffInfoVO vo  = command.searchInlandCostTariffInfo(event.getInCostTrfNo());
			eventResponse.setETCData(vo.getColumnValues());
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
	private EventResponse multiInlandCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs3001Event event = (EsdTrs3001Event)e;
		InlandCostManageBC command = new InlandCostManageBCImpl();
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
	 * Inland Cost Management - Confirm<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmInlandCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs3001Event event = (EsdTrs3001Event)e;
		InlandCostManageBC command = new InlandCostManageBCImpl();
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
		EsdTrs3001Event event = (EsdTrs3001Event)e;
		InlandCostManageBC command = new InlandCostManageBCImpl();
		
		try{
			String[] existFlgArr =  command.searchInlandCostGuidelineExist(event.getInlandCostConditionVO().getInCostTrfNo()).split(",");
			
			if( "Y".equals(existFlgArr[0]) ){
				eventResponse.setUserMessage(new ErrorHandler("TRS50114").getUserMessage());
			}else if( "Y".equals(existFlgArr[1]) ){
				eventResponse.setUserMessage(new ErrorHandler("TRS50113").getUserMessage());
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
		EsdTrs3001Event event = (EsdTrs3001Event)e;
		InlandCostManageBC command = new InlandCostManageBCImpl();
		try{
			String cnt = command.verifyInlandCostConfirm(event.getInlandCostConditionVO().getInCostTrfNo());
			if(cnt.equals("0")){
				begin();
				command.multiInlandCostSpecialCargo(event.getInlandCostSpecialCargoVOS(), account);
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
		EsdTrs3002Event event = (EsdTrs3002Event)e;
		InlandCostManageBC command = new InlandCostManageBCImpl();

		try{
			List<InlandCostDetailVO> list = command.searchInlandCostDetail(event.getInlandCostConditionVO());
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
		EsdTrs3002Event event = (EsdTrs3002Event)e;
		InlandCostManageBC command = new InlandCostManageBCImpl();
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
		EsdTrs3002Event event = (EsdTrs3002Event)e;
		InlandCostManageBC command = new InlandCostManageBCImpl();
		try{
			String cnt = command.searchInlandCostDetailDeleteCheck(event.getInlandCostDetailVOS());
			if(cnt.equals("0")){
				begin();
				command.multiInlandCostDetailDelete(event.getInlandCostDetailVOS(), account);
				eventResponse.setUserMessage(new ErrorHandler("COM12191", new String[]{"Data"}).getUserMessage());
				commit();
			}else{
				eventResponse.setUserMessage(new ErrorHandler("TRS50115", new String[]{"Data"}).getUserMessage());
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
	 * Ocean Feeder Cost Management tab Dry - Retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFeederCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs3009Event event = (EsdTrs3009Event)e;
		OceanFeederCostManageBC command = new OceanFeederCostManageBCImpl();

		try{
			List<FeederCostVO> 				list1 = command.searchFeederCost(event.getInCostTrfNo());
			List<SearchFeederDgCostVO> 		list2 = command.searchFeederDgCost(event.getInCostTrfNo());
			List<SearchFeederReeferCostVO> 	list3 = command.searchFeederRfCost(event.getInCostTrfNo());
			
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
	 * Ocean Feeder Cost Management - Cost Tariff No <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFeederCostTariffNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs3009Event event = (EsdTrs3009Event)e;
		OceanFeederCostManageBC command = new OceanFeederCostManageBCImpl();

		try{
			List<FeederCostTariffNoVO> list = command.searchFeederCostTariffNo(event.getInOfcCd());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Ocean Feeder Cost Management - Cost Tariff No Info<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFeederCostTariffInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs3009Event event = (EsdTrs3009Event)e;
		OceanFeederCostManageBC command = new OceanFeederCostManageBCImpl();

		try{
			FeederCostTariffInfoVO vo  = command.searchFeederCostTariffInfo(event.getInCostTrfNo(), event.getInOfcCd());
			eventResponse.setETCData(vo.getColumnValues());
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Ocean Feeder Cost Management tab Dry - Save<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiFeederCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs3009Event event = (EsdTrs3009Event)e;
		OceanFeederCostManageBC command = new OceanFeederCostManageBCImpl();
		try{
			String cnt = command.verifyFeederCostConfirm(event.getInCostTrfNo());
			if(cnt.equals("0")){
				begin();
				command.multiFeederCost(event.getFeederCostVOS(), account);
				command.multiFeederCostHdr(event.getInCostTrfNo(), account);
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
	 * Ocean Feeder Cost Management tab Dangerous - Save<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse multiFeederDgCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs3009Event event = (EsdTrs3009Event)e;
		OceanFeederCostManageBC command = new OceanFeederCostManageBCImpl();
		try{
			String cnt = command.verifyFeederCostConfirm(event.getInCostTrfNo());
			if(cnt.equals("0")){
				begin();
				command.multiFeederDgCost(event.getSearchFeederDgCostVOs(), account);
				command.multiFeederCostHdr(event.getInCostTrfNo(), account);
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
	 * Ocean Feeder Cost Management tab Reefer - Save<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse multiFeederRfCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs3009Event event = (EsdTrs3009Event)e;
		OceanFeederCostManageBC command = new OceanFeederCostManageBCImpl();
		try{
			String cnt = command.verifyFeederCostConfirm(event.getInCostTrfNo());
			if(cnt.equals("0")){
				begin();
				command.multiFeederRfCost(event.getSearchFeederReeferCostVOs(), account);
				command.multiFeederCostHdr(event.getInCostTrfNo(), account);
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
	 * Ocean Feeder Cost Management - Confirm<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmFeederCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs3009Event event = (EsdTrs3009Event)e;
		OceanFeederCostManageBC command = new OceanFeederCostManageBCImpl();
		try{
			String cnt = command.verifyFeederCostConfirm(event.getInCostTrfNo());
			if(cnt.equals("0")){
				begin();
				command.confirmFeederCostPreVer(event.getInCostTrfNo(), account);
				command.confirmFeederCost(event.getInCostTrfNo(), account);
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
	 * Ocean Feeder Cost Management - Confirm Cancel<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyFeederCostMgtCfmCxl(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs3009Event event = (EsdTrs3009Event)e;
		OceanFeederCostManageBC command = new OceanFeederCostManageBCImpl();
		
		try{
			String[] existFlgArr = command.searchFeederCostGuidelineExist(event.getInCostTrfNo(), event.getInRhqCd()).split(",");
			
			if( "Y".equals(existFlgArr[0]) ){
				eventResponse.setUserMessage(new ErrorHandler("TRS50114").getUserMessage());
			}else if( "Y".equals(existFlgArr[1]) ){
				eventResponse.setUserMessage(new ErrorHandler("TRS50113").getUserMessage());
			}else{
				begin();
				command.modifyFeederCostMgtCfmCxl(event.getInCostTrfNo(), account);
				command.modifyFeederCostMgtCfmCxlPreVer(event.getInCostTrfNo(), event.getInRhqCd(), account);
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
	 * Inland Cost Management - Cost Detail Retrieve. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandCostAccount(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs3005Event event = (EsdTrs3005Event)e;
		InlandCostManageBC command = new InlandCostManageBCImpl();

		try{
			List<SearchInlandCostAccountVO> list = command.searchInlandCostAccount(event.getSearchInlandCostAccountVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Default Currency Creation - Retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntDefaultCurr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs3016Event event = (EsdTrs3016Event)e;
		InlandCostManageBC command = new InlandCostManageBCImpl();

		try{
			List<CntDefaultCurrVO> list = command.searchCntDefaultCurr(event.getInlandCostConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Default Currency Creation - RHQ<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRHQCombo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		InlandCostManageBC command = new InlandCostManageBCImpl();
		List<RHQComboVO> list = new ArrayList<RHQComboVO>();
		RHQComboVO combovo = new RHQComboVO();
		try{
			list = command.searchRHQCombo();
			combovo.setRhqCd("");
			combovo.setRhqNm("All");
			list.add(0,combovo);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}


	/**
	 * Default Currency Creation - Country Info<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs3016Event event = (EsdTrs3016Event)e;
		InlandCostManageBC command = new InlandCostManageBCImpl();

		try{
			CntInfoVO vo  = command.searchCntInfo(event.getCntCd());
			eventResponse.setETCData(vo.getColumnValues());
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Default Currency Creation - Currency Info<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCurrNm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs3016Event event = (EsdTrs3016Event)e;
		InlandCostManageBC command = new InlandCostManageBCImpl();

		try{
			String curr_nm  = command.searchCurrNm(event.getCurrCd());
			eventResponse.setETCData("curr_nm", curr_nm);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}	

	/**
	 * Default Currency Creation - Save<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiCntDefaultCurr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs3016Event event = (EsdTrs3016Event)e;
		InlandCostManageBC command = new InlandCostManageBCImpl();
		try{
			begin();
			command.multiCntDefaultCurr(event.getCntDefaultCurrVOS(), account);
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
	 * Default Currency Creation - Delete<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeCntDefaultCurr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs3016Event event = (EsdTrs3016Event)e;
		InlandCostManageBC command = new InlandCostManageBCImpl();
		try{
			begin();
			command.removeCntDefaultCurr(event.getCntDefaultCurrVOS(), account);
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
	 * Ocean Feeder Cost Management - Cost Detail Retrieve. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOceanFeederCostAccount(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs3019Event event = (EsdTrs3019Event)e;
		OceanFeederCostManageBC command = new OceanFeederCostManageBCImpl();

		try{
			List<SearchOceanFeederCostAccountVO> list = command.searchOceanFeederCostAccount(event.getSearchOceanFeederCostAccountVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Ocean Feeder Cost Management - Currency Code 확인 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyCurrencyCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs3016Event event = (EsdTrs3016Event)e;
		InlandCostManageBC commCommand = new InlandCostManageBCImpl();

		try {
			String errFlg = commCommand.verifyCurrencyCode(event.getCurrCd());
			eventResponse.setETCData("err_flg", errFlg);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * ESD_TRS_3015 : 화면에 대한 콤보리스트 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCombo3015(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		TrsUtil trsUtil = new TrsUtil();
		List<TrsComboVO> list = new ArrayList<TrsComboVO>();
		TrsComboVO combovo = new TrsComboVO();
		
		try {
			/* RHQ Office Combo List */
			list = trsUtil.searchCombo("CD00961");
			combovo.setVal("");
			combovo.setName("All");
			list.add(0,combovo);
			eventResponse.setRsVoList(list);
			
			/* Status Combo List */
			list = trsUtil.searchCombo("CD03047");
			combovo.setVal("");
			combovo.setName("All");
			list.add(0,combovo);
			//Waiting(W), Processing(P), Error(E), Cancel(X) 제외
			for( int idx = list.size() - 1; idx >= 0; idx-- ){
				if( "W".equals(list.get(idx).getVal()) || "P".equals(list.get(idx).getVal()) || "E".equals(list.get(idx).getVal()) || "X".equals(list.get(idx).getVal()) ){
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
	 * ESD_TRS_3015 : 화면에 대한 RHQ Office Code 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRHQOfficeCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		TrsCommonBC commCommand = new TrsCommonBCImpl();
		InlandCostManageBC command = new InlandCostManageBCImpl();

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
	 * ESD_TRS_3015 : Country Code Verify.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkingCountryCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs3015Event event = (EsdTrs3015Event)e;
		TrsCommonBC commCommand = new TrsCommonBCImpl();

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
		EsdTrs3015Event event = (EsdTrs3015Event)e;
		InlandCostManageBC command = new InlandCostManageBCImpl();

		try{
			List<SearchStatusMonitorVO> list = command.searchStatusMonitor(event.getSearchStatusMonitorVO());
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
		EsdTrs3007Event event = (EsdTrs3007Event)e;
		InlandCostManageBC command = new InlandCostManageBCImpl();

		try{
			List<InlnadCostInquiryVO> list = command.searchInlnadCostInquiry(event.getInlandCostConditionVO());
			List<InlnadCostSpeInquiryVO> list2 = command.searchInlnadCostSpeInquiry(event.getInlandCostConditionVO());
			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(list2);
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
		EsdTrs3007Event event = (EsdTrs3007Event)e;
		InlandCostManageBC command = new InlandCostManageBCImpl();

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
		EsdTrs3007Event event = (EsdTrs3007Event)e;
		InlandCostManageBC command = new InlandCostManageBCImpl();

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
	 * Ocean Feeder Cost Inquiry tab Dry - Retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFeederCostInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs3013Event event = (EsdTrs3013Event)e;
		OceanFeederCostManageBC command = new OceanFeederCostManageBCImpl();

		try{
			List<FeederCostInquiryVO> list1 	= command.searchFeederCostInquiry(event.getOceanFeederCostCondVO());
			List<FeederCostDGVO> list2 			= command.searchFeederCostDG(event.getOceanFeederCostCondVO());
			List<FeederCostInquiryVO> list3 	= command.searchFeederCostRF(event.getOceanFeederCostCondVO());
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
	 * Ocean Feeder Cost Inquiry tab Dry - Down Excel without Displaying<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFeederCostInquiryExcel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs3013Event event = (EsdTrs3013Event)e;
		OceanFeederCostManageBC command = new OceanFeederCostManageBCImpl();

		try{
			if( "DRY".equals(event.getOceanFeederCostCondVO().getBntFlg()) ){
				eventResponse.setCustomData("rowset", command.getDryRowSet(event.getOceanFeederCostCondVO()));
				eventResponse.setCustomData("title", command.getDryTitle(1));
				eventResponse.setCustomData("title2", command.getDryTitle(2));
				eventResponse.setCustomData("columns", command.getDryColumns());
				eventResponse.setCustomData("fileName", "Ocean_Feeder_Cost_Inquiry_Dry.csv");
				eventResponse.setCustomData("isZip", true);
			} else if( "DG".equals(event.getOceanFeederCostCondVO().getBntFlg()) ){
				eventResponse.setCustomData("rowset", command.getDGRowSet(event.getOceanFeederCostCondVO()));
				eventResponse.setCustomData("title", command.getDGTitle(1));
				eventResponse.setCustomData("title2", command.getDGTitle(2));
				eventResponse.setCustomData("columns", command.getDGColumns());
				eventResponse.setCustomData("fileName", "Ocean_Feeder_Cost_Inquiry_DG.csv");
				eventResponse.setCustomData("isZip", true);	
			} else if( "RF".equals(event.getOceanFeederCostCondVO().getBntFlg()) ){
				eventResponse.setCustomData("rowset", command.getRFRowSet(event.getOceanFeederCostCondVO()));
				eventResponse.setCustomData("title", command.getRFTitle(1));
				eventResponse.setCustomData("title2", command.getRFTitle(2));
				eventResponse.setCustomData("columns", command.getRFColumns());
				eventResponse.setCustomData("fileName", "Ocean_Feeder_Cost_Inquiry_RF.csv");
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
	private EventResponse verifyFeederCostTrfNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs3013Event event = (EsdTrs3013Event)e;
		OceanFeederCostManageBC command = new OceanFeederCostManageBCImpl();

		try {
			/* Cost Tariff No. Verify */
			String errFlg = command.verifyFeederCostTrfNo(event.getOceanFeederCostCondVO().getCostTrfNo());
			eventResponse.setETCData("err_flg", errFlg);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
}