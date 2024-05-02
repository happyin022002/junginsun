/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EurCostMgtSC.java
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
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.eurcostmgt;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.aoc.common.aoccommon.basic.AocCommonBC;
import com.hanjin.apps.alps.esd.aoc.common.aoccommon.basic.AocCommonBCImpl;
import com.hanjin.apps.alps.esd.aoc.common.aoccommon.basic.AocUtil;
import com.hanjin.apps.alps.esd.aoc.common.aoccommon.vo.AocComboVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.basic.EurInlandCostManageBC;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.basic.EurInlandCostManageBCImpl;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.event.EsdAoc3002Event;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.event.EsdAoc3003Event;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.event.EsdAoc3004Event;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.event.EsdAoc3010Event;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.event.EsdAoc3011Event;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlandCostAccountVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlandCostDetailVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlandCostSpecialCargoVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlandCostTariffInfoVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlandCostTariffNoVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlandCostVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlnadCostInquiryVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlnadCostSpeInquiryVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurStatusMonitorVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.basic.EurOceanFeederCostManageBC;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.basic.EurOceanFeederCostManageBCImpl;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.event.EsdAoc3022Event;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.event.EsdAoc3023Event;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.event.EsdAoc3025Event;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederCostAccountVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederCostDGVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederCostInquiryVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederCostTariffInfoVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederCostTariffNoVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederCostVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederDgCostVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederReeferCostVO;
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
 * @see EurPnlReportManageDBDAO
 * @since J2EE 1.6
 */

public class EurCostMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * InlandCostManage system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("EurCostMgtSC 시작");
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
		log.debug("EurCostMgtSC 종료");
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
		if( e.getEventName().equalsIgnoreCase("EsdAoc3002Event") ){
			if( e.getFormCommand().isCommand(FormCommand.SEARCH) ){ //Dry, DG, RF 조회
				eventResponse = searchInlandCost(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH02) ){ //Cost Tariff No
				eventResponse= searchInlandCostTariffNo(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH03) ){ //Cost Tariff No Info
				eventResponse= searchInlandCostTariffInfo(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH04) ){ //Country Code
				eventResponse= verifyCountryCode(e);
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
		} else if( e.getEventName().equalsIgnoreCase("EsdAoc3003Event") ){
			if( e.getFormCommand().isCommand(FormCommand.SEARCH) ){
				eventResponse = searchInlandCostDetail(e);
			} else if( e.getFormCommand().isCommand(FormCommand.MULTI01) ){
				eventResponse = multiInlandCostDetail(e);
			} else if( e.getFormCommand().isCommand(FormCommand.MULTI02) ){
				eventResponse = multiInlandCostDetailDelete(e);
			}
		} else if ( e.getEventName().equalsIgnoreCase("EsdAoc3004Event") ){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInlandCostAccount(e);
			}
		} else if( e.getEventName().equalsIgnoreCase("EsdAoc3010Event") ){
			if( e.getFormCommand().isCommand(FormCommand.SEARCH) ){
				eventResponse = searchInlnadCostInquiry(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH01) ){
				eventResponse= searchInlnadCostInquiryExcel(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH02) ){
				eventResponse= verifyInlndCostTrfNo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdAoc3022Event")) {
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
			} else if( e.getFormCommand().isCommand(FormCommand.MULTI06) ){ //Delete
				eventResponse = removeFeederCost(e);
			}
		} else if( e.getEventName().equalsIgnoreCase("EsdAoc3025Event")) {
			if ( e.getFormCommand().isCommand(FormCommand.SEARCH) ){
				eventResponse = searchFeederCostInquiry(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH01) ){
				eventResponse= searchFeederCostInquiryExcel(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH02) ){
				eventResponse= verifyFeederCostTrfNo(e);
			}		
		} else if( e.getEventName().equalsIgnoreCase("EsdAoc3011Event") ){
			if( e.getFormCommand().isCommand(FormCommand.SEARCH) ){
				eventResponse = searchStatusMonitor(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH01) ){ //RHQ : RHQ Office Code List Search
				eventResponse= searchRHQOfficeCode(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH02) ){ //Combo : Combo List Search
				eventResponse= searchCombo3011(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH03) ){ //Country Code Validation
				eventResponse= checkingCountryCode(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdAoc3023Event")) {
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
		EsdAoc3002Event event = (EsdAoc3002Event)e;
		EurInlandCostManageBC command = new EurInlandCostManageBCImpl();

		try{
			List<EurInlandCostVO> list1 				= command.searchInlandCost(event.getInlandCostConditionVO());
			List<EurInlandCostSpecialCargoVO> list2 	= command.searchInlandCostSpecialCargo(event.getInlandCostConditionVO());
			List<EurInlandCostVO> list3 				= command.searchInlandCostReefer(event.getInlandCostConditionVO());
			
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
		EsdAoc3002Event event = (EsdAoc3002Event)e;
		EurInlandCostManageBC command = new EurInlandCostManageBCImpl();

		try{
			List<EurInlandCostTariffNoVO> list = command.searchInlandCostTariffNo(event.getInCntCd());
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
		EsdAoc3002Event event = (EsdAoc3002Event)e;
		EurInlandCostManageBC command = new EurInlandCostManageBCImpl();

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
		EsdAoc3002Event event = (EsdAoc3002Event)e;
		EurInlandCostManageBC command = new EurInlandCostManageBCImpl();

		try{
			EurInlandCostTariffInfoVO vo  = command.searchInlandCostTariffInfo(event.getInCostTrfNo());
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
	private EventResponse multiInlandCostDry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3002Event event = (EsdAoc3002Event)e;
		EurInlandCostManageBC command = new EurInlandCostManageBCImpl();
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
		EsdAoc3002Event event = (EsdAoc3002Event)e;
		EurInlandCostManageBC command = new EurInlandCostManageBCImpl();
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
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse confirmInlandCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3002Event event = (EsdAoc3002Event)e;
		EurInlandCostManageBC command = new EurInlandCostManageBCImpl();
		try{
			String cfmCnt = command.verifyInlandCostConfirm(event.getInlandCostConditionVO().getInCostTrfNo());
			String locGrpErrCnt = command.verifyInlandCostLocGrpCnt(event.getInlandCostConditionVO().getInCostTrfNo());
			if( !"0".equals(cfmCnt) ){
				eventResponse.setETCData("cfmCnt", cfmCnt);
			} else if( !"0".equals(locGrpErrCnt) ){
				eventResponse.setETCData("locGrpErrCnt", locGrpErrCnt);
			} else{
				begin();
				command.confirmInlandCostPreVer(event.getInlandCostConditionVO(), account);
				command.confirmInlandCost(event.getInlandCostConditionVO(), account);
				eventResponse.setUserMessage(new ErrorHandler("COM12191", new String[]{"Confirm"}).getUserMessage());
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
	 * Inland Cost Management - Confirm Cancel<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyInlandCostMgtCfmCxl(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3002Event event = (EsdAoc3002Event)e;
		EurInlandCostManageBC command = new EurInlandCostManageBCImpl();
		
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
		EsdAoc3002Event event = (EsdAoc3002Event)e;
		EurInlandCostManageBC command = new EurInlandCostManageBCImpl();
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
		EsdAoc3003Event event = (EsdAoc3003Event)e;
		EurInlandCostManageBC command = new EurInlandCostManageBCImpl();

		try{
			List<EurInlandCostDetailVO> list = command.searchInlandCostDetail(event.getInlandCostConditionVO());
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
		EsdAoc3003Event event = (EsdAoc3003Event)e;
		EurInlandCostManageBC command = new EurInlandCostManageBCImpl();
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
		EsdAoc3003Event event = (EsdAoc3003Event)e;
		EurInlandCostManageBC command = new EurInlandCostManageBCImpl();
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
	 * Ocean Feeder Cost Management tab Dry - Retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFeederCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3022Event event = (EsdAoc3022Event)e;
		EurOceanFeederCostManageBC command = new EurOceanFeederCostManageBCImpl();

		try{
			List<EurFeederCostVO> 			list1 = command.searchFeederCost(event.getEurFeederMgtCondVO());
			List<EurFeederDgCostVO> 		list2 = command.searchFeederDgCost(event.getEurFeederMgtCondVO());
			List<EurFeederReeferCostVO> 	list3 = command.searchFeederRfCost(event.getEurFeederMgtCondVO());
			
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
		EsdAoc3022Event event = (EsdAoc3022Event)e;
		EurOceanFeederCostManageBC command = new EurOceanFeederCostManageBCImpl();

		try{
			List<EurFeederCostTariffNoVO> list = command.searchFeederCostTariffNo(event.getEurFeederMgtCondVO());
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
		EsdAoc3022Event event = (EsdAoc3022Event)e;
		EurOceanFeederCostManageBC command = new EurOceanFeederCostManageBCImpl();

		try{
			EurFeederCostTariffInfoVO vo  = command.searchFeederCostTariffInfo(event.getEurFeederMgtCondVO());
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
		EsdAoc3022Event event = (EsdAoc3022Event)e;
		EurOceanFeederCostManageBC command = new EurOceanFeederCostManageBCImpl();
		try{
			String cnt = command.verifyFeederCostConfirm(event.getEurFeederMgtCondVO());
			if( cnt.equals("0") ){
				begin();
				command.multiFeederCost(event.getEurFeederCostVOs(), account);
				command.multiFeederCostHdr(event.getEurFeederMgtCondVO(), account);
				if( event.getEurFeederMgtCondVO().getInBtnSts().equals("S") ){
					eventResponse.setUserMessage(new ErrorHandler("COM12191", new String[]{"Data"}).getUserMessage());
				}
				
				commit();
			} else{
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
		EsdAoc3022Event event = (EsdAoc3022Event)e;
		EurOceanFeederCostManageBC command = new EurOceanFeederCostManageBCImpl();
		try{
			String cnt = command.verifyFeederCostConfirm(event.getEurFeederMgtCondVO());
			if(cnt.equals("0")){
				begin();
				command.multiFeederDgCost(event.getEurFeederDgCostVOs(), account);
				command.multiFeederCostHdr(event.getEurFeederMgtCondVO(), account);
				if(event.getEurFeederMgtCondVO().getInBtnSts().equals("S")){
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
	 * Ocean Feeder Cost - Delete<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse removeFeederCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3022Event event = (EsdAoc3022Event)e;
		EurOceanFeederCostManageBC command = new EurOceanFeederCostManageBCImpl();
		try{
			String cnt = command.verifyFeederCostConfirm(event.getEurFeederMgtCondVO());
			if(cnt.equals("0")){
				begin();
				command.removeFdrTrfDtl(event.getEurFeederCostVOs(), account);
				command.multiFeederCostHdr(event.getEurFeederMgtCondVO(), account);
				
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
		EsdAoc3022Event event = (EsdAoc3022Event)e;
		EurOceanFeederCostManageBC command = new EurOceanFeederCostManageBCImpl();
		try{
			String cnt = command.verifyFeederCostConfirm(event.getEurFeederMgtCondVO());
			if(cnt.equals("0")){
				begin();
				command.multiFeederRfCost(event.getEurFeederReeferCostVOs(), account);
				command.multiFeederCostHdr(event.getEurFeederMgtCondVO(), account);
				if(event.getEurFeederMgtCondVO().getInBtnSts().equals("S")){
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
		EsdAoc3022Event event = (EsdAoc3022Event)e;
		EurOceanFeederCostManageBC command = new EurOceanFeederCostManageBCImpl();
		try{
			String cnt = command.verifyFeederCostConfirm(event.getEurFeederMgtCondVO());
			if(cnt.equals("0")){
				begin();
				command.confirmFeederCostPreVer(event.getEurFeederMgtCondVO(), account);
				command.confirmFeederCost(event.getEurFeederMgtCondVO(), account);
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
		EsdAoc3022Event event = (EsdAoc3022Event)e;
		EurOceanFeederCostManageBC command = new EurOceanFeederCostManageBCImpl();
		
		try{
			String[] existFlgArr = command.searchFeederCostGuidelineExist(event.getEurFeederMgtCondVO()).split(",");
			
			if( "Y".equals(existFlgArr[0]) ){
				eventResponse.setUserMessage(new ErrorHandler("AOC00003").getUserMessage());
			}else if( "Y".equals(existFlgArr[1]) ){
				eventResponse.setUserMessage(new ErrorHandler("AOC00002").getUserMessage());
			}else{
				begin();
				command.modifyFeederCostMgtCfmCxl(event.getEurFeederMgtCondVO(), account);
				command.modifyFeederCostMgtCfmCxlPreVer(event.getEurFeederMgtCondVO(), account);
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
		EsdAoc3004Event event = (EsdAoc3004Event)e;
		EurInlandCostManageBC command = new EurInlandCostManageBCImpl();

		try{
			List<EurInlandCostAccountVO> list = command.searchInlandCostAccount(event.getSearchInlandCostAccountVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
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
		EsdAoc3023Event event = (EsdAoc3023Event)e;
		EurOceanFeederCostManageBC command = new EurOceanFeederCostManageBCImpl();

		try{
			List<EurFeederCostAccountVO> list = command.searchOceanFeederCostAccount(event.getSearchOceanFeederCostAccountVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESD_AOC_3011 : 화면에 대한 콤보리스트 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCombo3011(Event e) throws EventException {
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
	 * ESD_AOC_3011 : 화면에 대한 RHQ Office Code 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRHQOfficeCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		AocCommonBC commCommand = new AocCommonBCImpl();
		EurInlandCostManageBC command = new EurInlandCostManageBCImpl();

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
	 * ESD_AOC_3011 : Country Code Verify.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkingCountryCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3011Event event = (EsdAoc3011Event)e;
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
		EsdAoc3011Event event = (EsdAoc3011Event)e;
		EurInlandCostManageBC command = new EurInlandCostManageBCImpl();

		try{
			List<EurStatusMonitorVO> list = command.searchStatusMonitor(event.getSearchStatusMonitorVO());
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
		EsdAoc3010Event event = (EsdAoc3010Event)e;
		EurInlandCostManageBC command = new EurInlandCostManageBCImpl();

		try{
			List<EurInlnadCostInquiryVO> list = command.searchInlnadCostInquiry(event.getInlandCostConditionVO());
			List<EurInlnadCostSpeInquiryVO> list2 = command.searchInlnadCostSpeInquiry(event.getInlandCostConditionVO());
			List<EurInlnadCostInquiryVO> list3 = command.searchInlnadCostRefInquiry(event.getInlandCostConditionVO());
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
		EsdAoc3010Event event = (EsdAoc3010Event)e;
		EurInlandCostManageBC command = new EurInlandCostManageBCImpl();

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
			}  else if( "R".equals(event.getInlandCostConditionVO().getBntFlg()) ){
				
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
		EsdAoc3010Event event = (EsdAoc3010Event)e;
		EurInlandCostManageBC command = new EurInlandCostManageBCImpl();

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
		EsdAoc3025Event event = (EsdAoc3025Event)e;
		EurOceanFeederCostManageBC command = new EurOceanFeederCostManageBCImpl();

		try{
			List<EurFeederCostInquiryVO> list1 	= command.searchFeederCostInquiry(event.getOceanFeederCostCondVO());
			List<EurFeederCostDGVO> list2 			= command.searchFeederCostDG(event.getOceanFeederCostCondVO());
			List<EurFeederCostInquiryVO> list3 	= command.searchFeederCostRF(event.getOceanFeederCostCondVO());
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
		EsdAoc3025Event event = (EsdAoc3025Event)e;
		EurOceanFeederCostManageBC command = new EurOceanFeederCostManageBCImpl();

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
		EsdAoc3025Event event = (EsdAoc3025Event)e;
		EurOceanFeederCostManageBC command = new EurOceanFeederCostManageBCImpl();

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