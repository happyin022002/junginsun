/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TpbMasterDataManageSC.java
*@FileTitle : CodeManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 황건하
*@LastVersion : 1.0
* 2009.07.02 황건하
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.masterdatamanage;

import java.util.List;

import com.hanjin.apps.alps.esd.tpb.masterdatamanage.codemanage.basic.CodeManageBC;
import com.hanjin.apps.alps.esd.tpb.masterdatamanage.codemanage.basic.CodeManageBCImpl;
import com.hanjin.apps.alps.esd.tpb.masterdatamanage.codemanage.event.EsdTpb0101Event;
import com.hanjin.apps.alps.esd.tpb.masterdatamanage.codemanage.event.EsdTpb0131Event;
import com.hanjin.apps.alps.esd.tpb.masterdatamanage.codemanage.vo.SearchCodeInquiryListVO;
import com.hanjin.apps.alps.esd.tpb.masterdatamanage.codemanage.vo.SearchCodeListVO;
import com.hanjin.apps.alps.esd.tpb.masterdatamanage.officemanage.basic.OfficeManageBC;
import com.hanjin.apps.alps.esd.tpb.masterdatamanage.officemanage.basic.OfficeManageBCImpl;
import com.hanjin.apps.alps.esd.tpb.masterdatamanage.officemanage.event.EsdTpb0102Event;
import com.hanjin.apps.alps.esd.tpb.masterdatamanage.officemanage.event.EsdTpb0132Event;
import com.hanjin.apps.alps.esd.tpb.masterdatamanage.officemanage.integration.OfficeManageDBDAO;
import com.hanjin.apps.alps.esd.tpb.masterdatamanage.officemanage.vo.SearchOfficeListForInquiryVO;
import com.hanjin.apps.alps.esd.tpb.masterdatamanage.officemanage.vo.SearchOfficeListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * NIS2010-TpbMasterDataManage Business Logic ServiceCommand - NIS2010-TpbMasterDataManage 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author GUN-HA HWANG
 * @see OfficeManageDBDAO
 * @since J2EE 1.6
 */

public class MasterDataManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * TpbMasterDataManage system 업무 시나리오 선행작업<br>
	 * ESD_TBP_102업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("TpbMasterDataManageSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * TpbMasterDataManage system 업무 시나리오 마감작업<br>
	 * ESD_TBP_102 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("TpbMasterDataManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-TpbMasterDataManage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdTpb0101Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCodeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiCodeManage(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0102Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOfficeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiOfficeManage(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0131Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCodeInquiryList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0132Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOfficeListForInquiry(e);
			}
		}
		
		return eventResponse;
	}
	/**
	 * 조회 이벤트 처리<br>
	 * TpbOfficeManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0101Event event = (EsdTpb0101Event)e;
		CodeManageBC command = new CodeManageBCImpl();
		try{
			List<SearchCodeListVO> list = command.searchCodeList(event.getSearchCodeListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * CodeManage의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiCodeManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0101Event event = (EsdTpb0101Event)e;
		CodeManageBC command = new CodeManageBCImpl();
		try{
			begin();
			log.debug("event.getSearchCodeListVOS()==>"+event.getSearchCodeListVOS());
			command.searchCodeList(event.getSearchCodeListVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * CodeManage의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiOfficeManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0102Event event = (EsdTpb0102Event)e;
		OfficeManageBC command = new OfficeManageBCImpl();
		try{
			begin();
			log.debug("event.getSearchOfficeListVOS()==>"+event.getSearchOfficeListVOS());
			command.searchOfficeList(event.getSearchOfficeListVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * TpbOfficeManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0102Event event = (EsdTpb0102Event)e;
		OfficeManageBC command = new OfficeManageBCImpl();
		
		try{
			List<SearchOfficeListVO> list = command.searchOfficeList(event.getSearchOfficeListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * TpbCodeManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCodeInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0131Event event = (EsdTpb0131Event)e;
		CodeManageBC command = new CodeManageBCImpl();

		try{
			List<SearchCodeInquiryListVO> list = command.searchCodeInquiryList(event.getSearchCodeInquiryListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * TpbCodeManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeListForInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0132Event event = (EsdTpb0132Event)e;
		OfficeManageBC command = new OfficeManageBCImpl();
		
		try{
			List<SearchOfficeListForInquiryVO> list = command.searchOfficeListForInquiry(event.getSearchOfficeListForInqiuryVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
}