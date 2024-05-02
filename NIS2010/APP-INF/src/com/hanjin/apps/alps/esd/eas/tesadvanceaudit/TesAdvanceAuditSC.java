/*=========================================================
*Copyright(c) 2006 CyberLogitec 
*@FileName : TesAdvanceAuditSC.java
*@FileTitle : Equipment Auto Audit 
*Open Issues :
*Change history :
*@LastModifyDate : 2015-04-13
*@LastModifier : Jong-Ock Kim
*@LastVersion : 1.0
* 2015-04-13 Jong-Ock Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.tesadvanceaudit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.eas.eascommon.basic.EASCommonBC;
import com.hanjin.apps.alps.esd.eas.eascommon.basic.EASCommonBCImpl;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.basic.TesAdvanceAuditBC;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.basic.TesAdvanceAuditBCImpl;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.event.EsdEas0370Event;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.event.EsdEas0371Event;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.event.EsdEas0372Event;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.event.EsdEas0373Event;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.event.EsdEas0374Event;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.event.EsdEas0375Event;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.event.EsdEas0376Event;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.event.EsdEas0377Event;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.event.EsdEas0378Event;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.event.EsdEas0379Event;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.event.EsdEas0380Event;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.LgsCostSubjCdVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesAudCfgVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesAuditMRHistoryVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesAuditOndockRailHistoryVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesInvoiceAuditVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesInvoiceConfirmVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesMRStorageFreeDayHistoryVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesMRStorageFreePoolHistoryVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesMarineStorageDetailCostByDayVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesMarineStorageDetailCostByPoolVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesMarineTerminalDetailVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesOffdockCYDetailCostByDayVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesOffdockCYDetailCostByPoolVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesOffdockCYDetailTMNLVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesOffdockCYFreeDayHistoryVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesOffdockCYFreePoolHistoryVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesOffdockCYGateOutDateVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesOffdockCYTerminalHistoryVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesOndockRailChargeInvoiceVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MdmVendorVO;
import com.hanjin.syscommon.common.table.MdmYardVO;

/**
 * TransportmanageSC PDTO(Data Transfer Object including Parameters)<br>
 * 
 * @author Jong-Ock Kim
 * @see ServiceCommandSupport 참조
 * @since J2EE 1.4
 */
public class TesAdvanceAuditSC extends ServiceCommandSupport {
	
	// Login User Information
	private SignOnUserAccount account = null;
	
	/**
	 * EAS 업무 시나리오 선행작업<br>
	 * Tesadvanceaudit업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch(Exception e) {
			log.error("TesAdvanceAudit 선행 작업 시 오류 " + e.toString(), e);
		}
	}
	
	/**
	 * EAS 업무 시나리오 마감작업<br>
	 * Tesadvanceaudit업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("TesAdvanceAudit 종료");
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Transportmanage event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		
		EventResponse eventResponse = null;
		
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if(e.getEventName().equalsIgnoreCase("EsdEas0370Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchTesAudCfgList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = modifyTesAudCfg(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchLgsCostSubjCd(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EsdEas0371Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchTesInvoiceConfirmList(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EsdEas0372Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchTesInvoiceAuditList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = modifyTesInvoiceAudit(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = createTesInvoiceAuditBatch(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EsdEas0378Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchTesAuditMRHistoryList(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EsdEas0379Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchTesOndockRailChargeInvoiceAuditDetailList(e);
			}else{
				eventResponse = searchTesOndockRailChargeInvoiceAuditInit(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EsdEas0373Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchTesOffdockCYInvoiceAuditDetailLList(e);
			}else{
				eventResponse = searchTesOffdockCYInvoiceGateOutDate0373(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EsdEas0375Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchTesMarineStorageInvoiceAuditDetailLList(e);
			}else{
				eventResponse = searchTesOffdockCYInvoiceGateOutDate0375(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EsdEas0377Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchTesMarineTerminalInvoiceAuditDetailList(e);
			}else{
				eventResponse = searchTesMarineTerminalInvoiceAuditDetailList0377(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EsdEas0380Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchTesAuditOndockRailHistoryList(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EsdEas0374Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchTesAuditOffdockCYHistoryList(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EsdEas0376Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchTesAuditMRStorageHistoryList(e);
			}
		}
		
		return eventResponse;
	}

	/**
	 * ESD_EAS_0370 - Retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTesAudCfgList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0370Event event = (EsdEas0370Event)e;
		TesAdvanceAuditBC command = new TesAdvanceAuditBCImpl();
		try{
			List<TesAudCfgVO> list = command.searchTesAudCfgList(event.getTesAuditConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
     * ESD_EAS_0370 - Save<br>
     * @param Event e
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse modifyTesAudCfg(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0370Event event = (EsdEas0370Event)e;
		TesAdvanceAuditBC command = new TesAdvanceAuditBCImpl();		
		try {
			begin();
			command.modifyTesAudCfg(event.getTesAudCfgVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("COM12191", new String[]{"Data"}).getUserMessage());
			commit();
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * ESD_EAS_0370 - Cost Group
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLgsCostSubjCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TesAdvanceAuditBC command = new TesAdvanceAuditBCImpl();
		try{
			List<LgsCostSubjCdVO> list = command.searchLgsCostSubjCd();
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESD_EAS_0371 - Retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTesInvoiceConfirmList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0371Event event = (EsdEas0371Event)e;
		TesAdvanceAuditBC command = new TesAdvanceAuditBCImpl();
		try{
			List<TesInvoiceConfirmVO> list = command.searchTesInvoiceConfirmList(event.getTesAuditConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESD_EAS_0378 - Retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTesAuditMRHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0378Event event = (EsdEas0378Event)e;
		TesAdvanceAuditBC command = new TesAdvanceAuditBCImpl();
		try{
			List<TesAuditMRHistoryVO> list = command.searchTesAuditMRHistoryList(event.getTesAuditConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESD_EAS_0379 - Retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTesOndockRailChargeInvoiceAuditDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0379Event event = (EsdEas0379Event)e;
		TesAdvanceAuditBC command = new TesAdvanceAuditBCImpl();
		try{
			List<TesOndockRailChargeInvoiceVO> list = command.searchTesOndockRailChargeInvoiceAuditDetailList(event.getTesAuditConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESD_EAS_0379 - Init<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTesOndockRailChargeInvoiceAuditInit(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0379Event event = (EsdEas0379Event)e;
		EASCommonBC command = new EASCommonBCImpl();
		
		MdmYardVO mdmYardVO = new MdmYardVO();
		MdmVendorVO mdmVendorVO = new MdmVendorVO();
		Map<String,String> etcData = new HashMap<String,String>();
		
		try{
			mdmYardVO.setYdCd(event.getTesAuditConditionVO().getSYdCd());
			List<MdmYardVO> YardList = command.getYardNameList(mdmYardVO);
			etcData.put("YdNm", ((MdmYardVO)YardList.get(0)).getYdNm());
			eventResponse.setETCData(etcData);
			
			mdmVendorVO.setVndrSeq(event.getTesAuditConditionVO().getSVndrSeq());
			List<MdmVendorVO> VendorList = command.getVendorNameList(mdmVendorVO);
			etcData.put("VndrNm", ((MdmVendorVO)VendorList.get(0)).getVndrLglEngNm());
			eventResponse.setETCData(etcData);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESD_EAS_0373 - Init<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTesOffdockCYInvoiceGateOutDate0373(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0373Event event = (EsdEas0373Event)e;
		EASCommonBC command = new EASCommonBCImpl();
		TesAdvanceAuditBC commandAudit = new TesAdvanceAuditBCImpl();
		
		MdmYardVO mdmYardVO = new MdmYardVO();
		MdmVendorVO mdmVendorVO = new MdmVendorVO();
		Map<String,String> etcData = new HashMap<String,String>();
		try{
			mdmYardVO.setYdCd(event.getTesAuditConditionVO().getSYdCd());
			List<MdmYardVO> YardList = command.getYardNameList(mdmYardVO);
			etcData.put("YdNm", ((MdmYardVO)YardList.get(0)).getYdNm());
			eventResponse.setETCData(etcData);
			
			mdmVendorVO.setVndrSeq(event.getTesAuditConditionVO().getSVndrSeq());
			List<MdmVendorVO> VendorList = command.getVendorNameList(mdmVendorVO);
			etcData.put("VndrNm", ((MdmVendorVO)VendorList.get(0)).getVndrLglEngNm());
			eventResponse.setETCData(etcData);
			
			List<TesOffdockCYGateOutDateVO> list = commandAudit.searchTesOffdockCYInvoiceGateOutDate(event.getTesAuditConditionVO());
			etcData.put("fmGoDt", ((TesOffdockCYGateOutDateVO)list.get(0)).getFmGoDt());
			etcData.put("toGoDt", ((TesOffdockCYGateOutDateVO)list.get(0)).getToGoDt());
			eventResponse.setETCData(etcData);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESD_EAS_0373 - Retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTesOffdockCYInvoiceAuditDetailLList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0373Event event = (EsdEas0373Event)e;
		TesAdvanceAuditBC command = new TesAdvanceAuditBCImpl();
		try{
			List<TesOffdockCYDetailTMNLVO> listTMNL = command.searchTesOffdockCYInvoiceAuditDetailTMNLList(event.getTesAuditConditionVO());
			eventResponse.setRsVoList(listTMNL);
			
			List<TesOffdockCYDetailCostByDayVO> listDay = command.searchTesOffdockCYInvoiceAuditDetailCostByDayList(event.getTesAuditConditionVO());
			eventResponse.setRsVoList(listDay);
			
			List<TesOffdockCYDetailCostByPoolVO> listPool = command.searchTesOffdockCYInvoiceAuditDetailCostByPoolList(event.getTesAuditConditionVO());
			eventResponse.setRsVoList(listPool);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESD_EAS_0375 - Init<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTesOffdockCYInvoiceGateOutDate0375(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0375Event event = (EsdEas0375Event)e;
		EASCommonBC command = new EASCommonBCImpl();
		TesAdvanceAuditBC commandAudit = new TesAdvanceAuditBCImpl();
		
		MdmYardVO mdmYardVO = new MdmYardVO();
		MdmVendorVO mdmVendorVO = new MdmVendorVO();
		Map<String,String> etcData = new HashMap<String,String>();
		try{
			mdmYardVO.setYdCd(event.getTesAuditConditionVO().getSYdCd());
			List<MdmYardVO> YardList = command.getYardNameList(mdmYardVO);
			etcData.put("YdNm", ((MdmYardVO)YardList.get(0)).getYdNm());
			eventResponse.setETCData(etcData);
			
			mdmVendorVO.setVndrSeq(event.getTesAuditConditionVO().getSVndrSeq());
			List<MdmVendorVO> VendorList = command.getVendorNameList(mdmVendorVO);
			etcData.put("VndrNm", ((MdmVendorVO)VendorList.get(0)).getVndrLglEngNm());
			eventResponse.setETCData(etcData);
			
			List<TesOffdockCYGateOutDateVO> list = commandAudit.searchTesOffdockCYInvoiceGateOutDate(event.getTesAuditConditionVO());
			etcData.put("fmGoDt", ((TesOffdockCYGateOutDateVO)list.get(0)).getFmGoDt());
			etcData.put("toGoDt", ((TesOffdockCYGateOutDateVO)list.get(0)).getToGoDt());
			eventResponse.setETCData(etcData);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESD_EAS_0375 - Retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTesMarineStorageInvoiceAuditDetailLList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0375Event event = (EsdEas0375Event)e;
		TesAdvanceAuditBC command = new TesAdvanceAuditBCImpl();
		try{
			List<TesMarineStorageDetailCostByDayVO> listDay = command.searchTesMarineStorageInvoiceAuditDetailCostByDayList(event.getTesAuditConditionVO());
			eventResponse.setRsVoList(listDay);
			
			List<TesMarineStorageDetailCostByPoolVO> listPool = command.searchTesMarineStorageInvoiceAuditDetailCostByPoolList(event.getTesAuditConditionVO());
			eventResponse.setRsVoList(listPool);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESD_EAS_0380 - Retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTesAuditOndockRailHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0380Event event = (EsdEas0380Event)e;
		TesAdvanceAuditBC command = new TesAdvanceAuditBCImpl();
		try{
			List<TesAuditOndockRailHistoryVO> list = command.searchTesAuditOndockRailHistoryList(event.getTesAuditConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}

	/**
	 * ESD_EAS_0377 - Init<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTesMarineTerminalInvoiceAuditDetailList0377(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0377Event event = (EsdEas0377Event)e;
		EASCommonBC command = new EASCommonBCImpl();
		
		MdmYardVO mdmYardVO = new MdmYardVO();
		MdmVendorVO mdmVendorVO = new MdmVendorVO();
		Map<String,String> etcData = new HashMap<String,String>();
		try{
			mdmYardVO.setYdCd(event.getTesAuditConditionVO().getSYdCd());
			List<MdmYardVO> YardList = command.getYardNameList(mdmYardVO);
			etcData.put("YdNm", ((MdmYardVO)YardList.get(0)).getYdNm());
			eventResponse.setETCData(etcData);
			
			mdmVendorVO.setVndrSeq(event.getTesAuditConditionVO().getSVndrSeq());
			List<MdmVendorVO> VendorList = command.getVendorNameList(mdmVendorVO);
			etcData.put("VndrNm", ((MdmVendorVO)VendorList.get(0)).getVndrLglEngNm());
			eventResponse.setETCData(etcData);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESD_EAS_0377 - Retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTesMarineTerminalInvoiceAuditDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0377Event event = (EsdEas0377Event)e;
		TesAdvanceAuditBC command = new TesAdvanceAuditBCImpl();
		try{
			List<TesMarineTerminalDetailVO> list = command.searchTesMarineTerminalInvoiceAuditDetailList(event.getTesAuditConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESD_EAS_0372 - Retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTesInvoiceAuditList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0372Event event = (EsdEas0372Event)e;
		TesAdvanceAuditBC command = new TesAdvanceAuditBCImpl();
		try{
			List<TesInvoiceAuditVO> list = command.searchTesInvoiceAuditList(event.getTesAuditConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
     * ESD_EAS_0372 - Confirm<br>
     * @param Event e
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse modifyTesInvoiceAudit(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0372Event event = (EsdEas0372Event)e;
		TesAdvanceAuditBC command = new TesAdvanceAuditBCImpl();		
		try {
			begin();
			command.modifyTesInvoiceAudit(event.getTesInvoiceAuditVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("COM12191", new String[]{"Data"}).getUserMessage());
			commit();
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * ESD_EAS_0372 - Batch(5분 매뉴얼) 등록<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createTesInvoiceAuditBatch(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0372Event event = (EsdEas0372Event)e;
		TesAdvanceAuditBC command = new TesAdvanceAuditBCImpl();		
		try {
			begin();
			command.createTesInvoiceAuditBatch(event.getTesInvoiceAuditVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("COM12191", new String[]{"Data"}).getUserMessage());
			commit();
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * ESD_EAS_0374 - Retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTesAuditOffdockCYHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0374Event event = (EsdEas0374Event)e;
		TesAdvanceAuditBC command = new TesAdvanceAuditBCImpl();
		try{
			List<TesOffdockCYTerminalHistoryVO> listTMNL = command.searchTesAuditOffdockCYTerminalHistoryList(event.getTesAuditConditionVO());
			eventResponse.setRsVoList(listTMNL);
			
			List<TesOffdockCYFreeDayHistoryVO> listDay = command.searchTesAuditOffdockCYFreeDayHistoryList(event.getTesAuditConditionVO());
			eventResponse.setRsVoList(listDay);
			
			List<TesOffdockCYFreePoolHistoryVO> listPool = command.searchTesAuditOffdockCYFreePoolHistoryList(event.getTesAuditConditionVO());
			eventResponse.setRsVoList(listPool);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESD_EAS_0376 - Retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTesAuditMRStorageHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0376Event event = (EsdEas0376Event)e;
		TesAdvanceAuditBC command = new TesAdvanceAuditBCImpl();
		try{
			List<TesMRStorageFreeDayHistoryVO> listDay = command.searchTesAuditMRStorageFreeDayHistoryList(event.getTesAuditConditionVO());
			eventResponse.setRsVoList(listDay);
			
			List<TesMRStorageFreePoolHistoryVO> listPool = command.searchTesAuditMRStorageFreePoolHistoryList(event.getTesAuditConditionVO());
			eventResponse.setRsVoList(listPool);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
}