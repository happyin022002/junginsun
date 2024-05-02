/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CommonPopUpManageSC.java
 *@FileTitle : EsdSce0103
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.28
 *@LastModifier : 신한성
 *@LastVersion : 1.0
 * 2009.07.28 신한성
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.sce.common.popup.basic.CommonPopUpManageBC;
import com.hanjin.apps.alps.esd.sce.common.popup.basic.CommonPopUpManageBCImpl;
import com.hanjin.apps.alps.esd.sce.common.popup.event.CommonPopUpManageEvent;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.COPSummaryVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.ComMailManagementConditionVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.ComOfficeManagementVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.ComVvdManagementVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.SearchContiManageVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.SearchSceClmDataVO;
import com.hanjin.framework.component.javamail.SingleMailAttachedFile;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-common Business Logic ServiceCommand - ALPS-common 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Shin Han Sung
 * @see popupDBDAO
 * @since J2EE 1.6
 */

public class CommonPopUpManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * common system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("CommonPopUpManageSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * common system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("CommonPopUpManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-common system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("CommonPopUpManageEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCOPSmryManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchVVDManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchOfcManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchSCNOManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchContiManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchSceClmList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchEMAILForException(e);
			}
		}
		return eventResponse; 
	}

	/**
	 * EsdSce0103 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVVDManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonPopUpManageEvent event = (CommonPopUpManageEvent) e;
		CommonPopUpManageBC command = new CommonPopUpManageBCImpl();

		try {
			List<ComVvdManagementVO> list = command.searchVVDManage(event
					.getComVvdManagementConditionVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * EsdSce0103 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfcManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonPopUpManageEvent event = (CommonPopUpManageEvent) e;
		CommonPopUpManageBC command = new CommonPopUpManageBCImpl();

		try {
			List<ComOfficeManagementVO> list = command
					.searchServiceOfficeCodeManage(event
							.getComOfficeManagementVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * EsdSce0103 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	/*
	private EventResponse searchCodeNameListString(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonPopUpManageEvent event = (CommonPopUpManageEvent) e;
		CodeUtilBC command = new CodeUtilBCImpl();

		try {
			List<CodeUtilVO> list = command.searchCodeNameListString(event
					.getCodeUtilVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
*/
	/**
	 * EsdSce0103 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEMAILForException(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonPopUpManageBC command = new CommonPopUpManageBCImpl();
		Map<String, String> data = new HashMap<String, String>();
		DBRowSet dbRowSet = null;
		StringBuffer sb = new StringBuffer();
		try {
			dbRowSet = command
					.searchEMAILRecipients(((CommonPopUpManageEvent) e)
							.getBkgNo());

			if (dbRowSet!=null && dbRowSet.getRowCount() > 0) {
				while (dbRowSet.next()) {
					if( !dbRowSet.getString(1).trim().equals("")){
						sb.append(dbRowSet.getString(1)+";");
					}
				}

			}
			data.put("send_eml2", sb.toString());
			data.put("contents1", command.searchEMAILTemplateContent(account));

			eventResponse.setETCData(data);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	
	
	
	
	
	/**
	 * EsdSce0103 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCOPSmryManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonPopUpManageEvent event = (CommonPopUpManageEvent) e;
		CommonPopUpManageBC command = new CommonPopUpManageBCImpl();

		try {
			List<COPSummaryVO> list = command.searchCOPSmryManage(event
					.getCopSummaryVO());
			COPSummaryVO vo = null;

			if (list.size() > 0) {
				vo = (COPSummaryVO) list.get(0);
				eventResponse.setETCData(vo.getColumnValues());
			}
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * EsdSce0103 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSCNOManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		CommonPopUpManageEvent event = (CommonPopUpManageEvent) e;
		CommonPopUpManageBC command = new CommonPopUpManageBCImpl();

		try {
			eventResponse = command.searchSCNOManage(event
					.getSCNOManagementVO());
			// eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * EsdSce0107 : [�대깽��<br>
	 * [鍮꾩쫰�덉뒪��긽]��[�됱쐞]�⑸땲��<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSceClmList(Event e) throws EventException {
    	log.debug("\n searchSceClmList start ");
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	CommonPopUpManageEvent event = (CommonPopUpManageEvent) e;
    	CommonPopUpManageBC command = new CommonPopUpManageBCImpl();
        
        try {
            List<SearchSceClmDataVO> list = command.searchSceClmList(event.getSceClmInfo());
            eventResponse.setRsVoList(list);
    	}catch(EventException ex){
    		throw ex;
    	}catch(Exception ex){
    		throw new EventException(ex.getMessage(), ex);
    	}		
    	return eventResponse;
    }
	
	/**
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * Country Inquery<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContiManage(Event e) throws EventException {
		log.debug("\n searchContiManage start ");
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	CommonPopUpManageEvent event = (CommonPopUpManageEvent) e;
    	CommonPopUpManageBC command = new CommonPopUpManageBCImpl();

		try {
			List<SearchContiManageVO> list = command.searchContiManage(event.getContiInfo());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
    		throw ex;
    	}catch(Exception ex){
    		throw new EventException(ex.getMessage(), ex);
    	}		
    	return eventResponse;
	}
	
}