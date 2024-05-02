/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EquipmentOperationPlanSC.java
*@FileTitle : Container Purchasing Trend by Year & input & update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.06.11 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentoperationplan;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.basic.ContainerSupplyDemandPlanBC;
import com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.basic.ContainerSupplyDemandPlanBCImpl;
import com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.event.EesMst0033Event;
import com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.event.EesMst0034Event;
import com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.event.EesMst0039Event;
import com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.event.EesMst0040Event;
import com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.integration.ContainerSupplyDemandPlanDBDAO;
import com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.vo.EqPriceDetailVO;
import com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.vo.EqPurSubListVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-EquipmentOperationPlan Business Logic ServiceCommand - ALPS-EquipmentOperationPlan 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Lee Ho Sun
 * @see ContainerSupplyDemandPlanDBDAO
 * @since J2EE 1.6
 */

public class EquipmentOperationPlanSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * EquipmentOperationPlan system 업무 시나리오 선행작업<br>
	 * EES_MST_0034업무 시나리오 호출시 관련 내부객체 생성<br>
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
	 * EquipmentOperationPlan system 업무 시나리오 마감작업<br>
	 * EES_MST_0034 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-EquipmentOperationPlan system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EesMst0034Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEqPriceListService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageEqPriceService(e);
			} 
		}
		else if (e.getEventName().equalsIgnoreCase("EesMst0039Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEqPriceReportService(e);
			} 
		}
		else if (e.getEventName().equalsIgnoreCase("EesMst0033Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchProcurementPlanResultReportService(e);
			} 			
		}
		else if (e.getEventName().equalsIgnoreCase("EesMst0040Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchProcurementPlanListService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)){ 			
				eventResponse = manageProcurementPlanService(e);
			} 						
		}
		
		return eventResponse;
	}
	/**
	 * EES_MST_0034 : retrieve<br>
	 * Year/Month와 EQ Type으로 해당되는 값을 검색한다<br> 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEqPriceListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMst0034Event event = (EesMst0034Event)e;
		ContainerSupplyDemandPlanBC command = new ContainerSupplyDemandPlanBCImpl();

		try{
			eventResponse.setRsVoList(command.searchEqPriceListBasic(event.getEqPriceOptionVO()));
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_MST_0034 : save<br>
	 * Manufacturer, Delivery Location, TP/SZ, QTY, Price등을 포함한 데이타를 추가/삭제/수정 한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageEqPriceService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMst0034Event event = (EesMst0034Event)e;
		List<EqPriceDetailVO> retVoList = new ArrayList<EqPriceDetailVO>();	
		ContainerSupplyDemandPlanBC command = new ContainerSupplyDemandPlanBCImpl();
		try{
			begin();
			retVoList = command.manageEqPriceBasic(event.getEqPriceDetailVos(),account);
			commit();
			eventResponse.setRsVoList(retVoList);
		}catch(EventException ex){
			rollback();
			throw ex;   
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
		
	}
	
	/**
	 * EES_MST_0039 : retrieve<br>
	 * Year/Month / Location / TPSZ으로 EQ Price Trend Inquiry를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	
	private EventResponse searchEqPriceReportService(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMst0039Event event = (EesMst0039Event)e;
		ContainerSupplyDemandPlanBC command = new ContainerSupplyDemandPlanBCImpl();
		List<EqPurSubListVO> list = new ArrayList<EqPurSubListVO>();
		List<EqPurSubListVO> listRep = new ArrayList<EqPurSubListVO>();
		try{
			
			list = command.searchEqPriceReportLocListBasic(event.getEqPriceOptionVO());	
			
			String totLocCd = "";
			for ( int i=0; i<list.size(); i++) {
				if ( i == list.size()-1) {
					totLocCd = totLocCd+list.get(i).getPurList();
				} else {
					totLocCd = totLocCd+list.get(i).getPurList()+"|";
				}
			}			
			
			listRep = command.searchEqPriceReportBasic(event.getEqPriceOptionVO(), list);
			
			eventResponse.setETCData("pur_list", totLocCd);
			eventResponse.setRsVoList(listRep);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;		
	}
	
	/**
	 * EES_MST_0033 : Retrieve<br>
	 * 연도별 Equipment Procurement를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProcurementPlanResultReportService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMst0033Event event = (EesMst0033Event)e;
		ContainerSupplyDemandPlanBC command = new ContainerSupplyDemandPlanBCImpl();

		try{
			eventResponse.setRsVoList(command.searchProcurementPlanResultReportBasic(event.getProcurementDetailVO()));
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}		
	
	
	/**
	 * EES_MST_0040 : retrieve<br>
	 * 연말 추정 재고를 기초로 작성한 장비 TY-SZ별 차년도 장비 확보 계획을 조회한다.<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProcurementPlanListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMst0040Event event = (EesMst0040Event)e;
		ContainerSupplyDemandPlanBC command = new ContainerSupplyDemandPlanBCImpl();

		try{
			eventResponse.setRsVoList(command.searchProcurementPlanListBasic(event.getProcurementDetailVO()));
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;		
	}		
	
	/**
	 * EES_MST_0040 : save<br>
	 * 연말 추정 재고를 기초로 작성한 월별/장비 TY-SZ별 차년도 장비 확보 계획을 생성,수정한다.<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageProcurementPlanService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMst0040Event event = (EesMst0040Event)e;
		ContainerSupplyDemandPlanBC command = new ContainerSupplyDemandPlanBCImpl();
		
		try{
			begin();			
			command.manageProcurementPlanBasic(event.getProcurementDetailVOS(),account);
// js에서 '저장메시지'를 보여준다.			
//			eventResponse.setUserMessage(new ErrorHandler("MST00003").getMessage());
			commit();			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}		
		
}