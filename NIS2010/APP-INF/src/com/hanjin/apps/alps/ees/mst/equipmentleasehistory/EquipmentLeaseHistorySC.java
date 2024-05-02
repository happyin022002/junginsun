/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EquipmentLeaseHistorySC.java
*@FileTitle : 임차 및 반납 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.06.09 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentleasehistory;

import java.util.List;

import com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.basic.LeaseSubleaseBC;
import com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.basic.LeaseSubleaseBCImpl;
import com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.event.EesMst0029Event;
import com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.event.EesMst0035Event;
import com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.event.EesMst0027Event;
import com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusGrpVO;
import com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusListVO;
import com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusReportListVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;

/**
 * ALPS-EquipmentLeaseHistory Business Logic ServiceCommand - ALPS-EquipmentLeaseHistory 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Lee Ho Sun
 * @see LeaseSubleaseDBDAO
 * @since J2EE 1.6
 */

public class EquipmentLeaseHistorySC extends ServiceCommandSupport {
	// Login User Information
	/**
	 * EquipmentLeaseHistory system 업무 시나리오 선행작업<br>
	 * EES_MST_0029업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
	}

	/**
	 * EquipmentLeaseHistory system 업무 시나리오 마감작업<br>
	 * EES_MST_0029 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-EquipmentLeaseHistory system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EesMst0029Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCntrStatusListByCntrNoService(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesMst0035Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCntrCheckDigitListService(e);
			}				
		}
		else if (e.getEventName().equalsIgnoreCase("EesMst0027Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCntrStatusReportListService(e);
			}
		}
		return eventResponse;
	}
	/**
	 * EesMst0029Event : retrieve<br>
	 * Container Status Inquiry 화면에 대한 조회를 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrStatusListByCntrNoService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMst0029Event event = (EesMst0029Event)e;   
		LeaseSubleaseBC command = new LeaseSubleaseBCImpl();

		// GROUPVO 생성
		CntrStatusGrpVO sgrVo = new CntrStatusGrpVO();
		// GROUPVO로 리턴값 받음
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			sgrVo = command.searchCntrStatusListByCntrNoBasic(event.getContainerConditionVO());
			eventResponse.setRsVoList(sgrVo.getCntrMstHeadVO());
			eventResponse.setRsVoList(sgrVo.getCntrStatusListVO());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}			
		return eventResponse;
	}
	/**
	 * EesMst0035Event : retrieve<br>
	 * Container Check Digit and Container Checking Inquiry 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrCheckDigitListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMst0035Event event = (EesMst0035Event)e;   
		LeaseSubleaseBC command = new LeaseSubleaseBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			// VO로 리턴값 받음
			List<CntrStatusListVO> list = command.searchCntrCheckDigitListBasic(event.getContainerConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);			
		}
		return eventResponse;
	}	
	
	/**
	 * EesMst0027Event : retrieve<br>
	 * Container Status List by Lost & Found 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchCntrStatusReportListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMst0027Event event = (EesMst0027Event)e;   
		LeaseSubleaseBC command = new LeaseSubleaseBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			// VO로 리턴값 받음
			List<CntrStatusReportListVO> list = command.searchCntrStatusReportListBasic(event.getCntrStatusOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);			
		}		
		return eventResponse;
	}		
	
}