/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EquipmentManagementSC.java
*@FileTitle : ContainerOnOffhire
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.27
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.03 김석준
* 1.0 Creation
* 
* History
* 2010.12.27 진마리아 [CHM-201007809-01] OWN CNTR Creation화면에서 Unit Type에 DF/UF추가 및 Full Name 표기
=========================================================*/
package com.hanjin.apps.alps.ees.mst.mstcommon;

import java.util.List;

import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration.ContainerOnOffhireDBDAO;
import com.hanjin.apps.alps.ees.mst.mstcommon.mstcommon.basic.MSTCommonBC;
import com.hanjin.apps.alps.ees.mst.mstcommon.mstcommon.basic.MSTCommonBCImpl;
import com.hanjin.apps.alps.ees.mst.mstcommon.mstcommon.event.MstComEvent;
import com.hanjin.apps.alps.ees.mst.mstcommon.mstcommon.vo.AgmtInfoVO;
import com.hanjin.apps.alps.ees.mst.mstcommon.mstcommon.vo.CommonListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
/**
 * ALPS-EquipmentManagement Business Logic ServiceCommand - ALPS-EquipmentManagement 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Suk Jun Kim
 * @see ContainerOnOffhireDBDAO
 * @since J2EE 1.6
 */

public class MSTCommonSC extends ServiceCommandSupport {
	// Login User Information
	/**
	 * EquipmentManagement system 업무 시나리오 선행작업<br>
	 * EES_MST_0032업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
	}

	/**
	 * EquipmentManagement system 업무 시나리오 마감작업<br>
	 * EES_MST_0032 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-EquipmentManagement system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("MstComEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				// Common Code 조회
				eventResponse = searchManufacturerListService(e);
			} 
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				// IBCombo Agreement No에 해당하는 Pool List 조회
				eventResponse = searchEqTypeSizeListService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)){			// 수정
				// Delivery Location 코드의 존재여부 조회
				eventResponse = searchManufacturePlaceListService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)){	
				// Agreement Info 조회
				eventResponse = searchAgmtService(e);				
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)){
				// Yard Code 조회
				eventResponse = searchYardCodeService(e);	
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)){
				// Lessor 조회
				eventResponse = searchLessorCodeService(e);					
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)){
				// Unit Type 조회
				eventResponse = searchReeferTypeCodeListService(e);					
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)){
				// COM_INTG_CD 조회
				eventResponse = searchComIntgCdListService(e);					
			}
			
		}
		return eventResponse;
	}
	
	/**
	 * ManufacturerList : 공통 retrieve<br>
	 * Manufacturer List를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManufacturerListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		MSTCommonBC command = new MSTCommonBCImpl();
		MstComEvent event = (MstComEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		try{	
			List<CommonListVO> list = command.searchManufacturerListBasic(event.getCommonListVO());
			
			StringBuffer comboList = new StringBuffer("");
			 
			for(int i=0; i<list.size(); i++){
				CommonListVO commonListVO = (CommonListVO)list.get(i);
							
				String code = commonListVO.getCode();
				String name	= commonListVO.getCodeNm();
				
				name = name.replaceAll("\"", "");						
				comboList.append(code + '|' + name);
				if(i < list.size()-1) comboList.append("@");
			}
			
			eventResponse.setRsVoList(list);	
			eventResponse.setETCData("comboList", comboList.toString());		
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
		return eventResponse;
	}
	
	/**
	 * EqTypeSizeList :  공통 retrieve<br><br>
	 * Eq Type Size List를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEqTypeSizeListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		MSTCommonBC command = new MSTCommonBCImpl();
		MstComEvent event = (MstComEvent)e;
				
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{	
			List<CommonListVO> list = command.searchEqTypeSizeListBasic(event.getCommonListVO());
			eventResponse.setRsVoList(list);
			
			StringBuffer sCntrTpSzNm = new StringBuffer();
			StringBuffer sCntrTpSzCd = new StringBuffer();
	
			for ( int i = 0 ; i < list.size() ; i++ ) {
				if ( sCntrTpSzNm.toString().equals("") ) {
					sCntrTpSzNm.append(list.get(i).getCode());
					sCntrTpSzCd.append(list.get(i).getCode());
				} else {
					sCntrTpSzNm.append("|").append(list.get(i).getCode());
					sCntrTpSzCd.append("|").append(list.get(i).getCode());
				}
			}
				
			eventResponse.setETCData("cntr_tpsz_nm", sCntrTpSzNm.toString());
			eventResponse.setETCData("cntr_tpsz_cd", sCntrTpSzCd.toString());		
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}			
		return eventResponse;
	}
	
	/**
	 * ManufacturePlaceList : 공통 retrieve<br>
	 * Manufacture Place List를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManufacturePlaceListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		MSTCommonBC command = new MSTCommonBCImpl();
		MstComEvent event = (MstComEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<CommonListVO> list = command.searchManufacturePlaceListBasic(event.getCommonListVO());
			StringBuffer comboList = new StringBuffer("");
			for(int i=0; i<list.size(); i++){
				CommonListVO commonListVO = (CommonListVO)list.get(i);
							
				String code = commonListVO.getCode();
				String name	= commonListVO.getCodeNm();
							
				name = name.replaceAll("\"", "");						
				comboList.append(code + '|' + name);
				if(i < list.size()-1) comboList.append("@");
			}
			eventResponse.setRsVoList(list);
			eventResponse.setETCData("comboList", comboList.toString());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}			
		return eventResponse;
	}
	
	/** EES_MST_0014 에서 
	 * EES_LSE_0091 : Retrieve <br>
	 * Lease Agreement List 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgmtService(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MstComEvent event = (MstComEvent)e;
		MSTCommonBC command = new MSTCommonBCImpl();
		try{	
			List<AgmtInfoVO> list = command.searchAgmtBasic(event.getAgmtInfoVO());
			
			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			} else {
				eventResponse.setUserMessage(new ErrorHandler("LSE01048").getMessage());
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
		return eventResponse;
	}	
	
	/**
	 * EES_MST_0014, EES_MST_0024 : retrieve<br>
	 * 입력된 Yard Code를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchYardCodeService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		MSTCommonBC command = new MSTCommonBCImpl();
		MstComEvent event = (MstComEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			CommonListVO list = command.searchYardCodeBasic(event.getCommonListVO());
			eventResponse.setRsVo(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}			
		return eventResponse;
	}	
	
	
	/**
	 * EES_MST_0021 : retrieve<br>
	 * Lessor 코드명을 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchLessorCodeService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		MSTCommonBC command = new MSTCommonBCImpl();
		MstComEvent event = (MstComEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();				
		try{
			String code_nm= command.searchLessorCodeBasic(event.getCommonListVO());
			eventResponse.setETCData("code_nm",code_nm);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}			
		return eventResponse;
	}
	
	/**
	 * EES_MST_0016 : retrieve<br>
	 * Reefer Type Code를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchReeferTypeCodeListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		MSTCommonBC command = new MSTCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();				
		try{
			List<CommonListVO> list= command.searchReeferTypeCodeListBasic();
			
			StringBuilder sb = new StringBuilder();
			if(!list.isEmpty()){
				sb.append(list.get(0).getCode()+","+list.get(0).getCodeNm());
				for(int i=1; i<list.size(); i++){
					sb.append("|"+list.get(i).getCode()+","+list.get(i).getCodeNm());
				}
			}
			eventResponse.setRsVoList(list);
			eventResponse.setETCData("unit_type",sb.toString());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}			
		return eventResponse;
	}
	
	/**
	 * COM_INTG_CD를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchComIntgCdListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		MSTCommonBC command = new MSTCommonBCImpl();
		MstComEvent event = (MstComEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();				
		try{
			List<CommonListVO> list= command.searchComIntgCdListBasic(event.getIntgCdId(),event.getIntgCdVal());
			
			StringBuilder sb = new StringBuilder();
			if(!list.isEmpty()){
				sb.append(list.get(0).getCode()+"|"+list.get(0).getCodeNm());
				for(int i=1; i<list.size(); i++){
					sb.append("|"+list.get(i).getCode()+","+list.get(i).getCodeNm());
				}
			}
			eventResponse.setRsVoList(list);
			eventResponse.setETCData("code_nm",sb.toString());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}			
		return eventResponse;
	}
	
}