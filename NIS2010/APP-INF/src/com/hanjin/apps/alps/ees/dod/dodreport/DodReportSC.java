/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DodReportSC.java
*@FileTitle : Invoice Creation & Correction
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.05
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2015.11.05 박정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodreport;

import java.util.ArrayList;
import java.util.List;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionaudit.basic.CollectionAuditBC;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionaudit.basic.CollectionAuditBCImpl;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionaudit.event.EesDod0008Event;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionaudit.integration.CollectionAuditDBDAO;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionaudit.vo.CollectionAuditListVO;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.basic.CollectionSummaryBC;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.basic.CollectionSummaryBCImpl;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.event.DodComEvent;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.event.EesDod0009Event;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.event.EesDod0010Event;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.event.EesDod0016Event;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.event.EesDod0017Event;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.vo.CollectionSummaryByCustomerDetailVO;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.vo.CollectionSummaryByCustomerVO;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.vo.SumbyOfcDetailVO;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.vo.SumbyOfcVO;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-DodReport Business Logic ServiceCommand - ALPS-DodReport 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Jeong-Min, Park
 * @see CollectionAuditDBDAO
 * @since J2EE 1.6
 */

public class DodReportSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * DodDropOff system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("DodReportSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * DodReport system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("DodReportSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-DodDropOff system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EesDod0008Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCollectionAuditList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchComBackEndJobStatusService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = loadFileBackEndJobResultService(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EesDod0016Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCollectionSummaryByCustomerList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EesDod0017Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCollectionSummaryByCustomerDetailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchComBackEndJobStatusService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = loadFileBackEndJobResultService(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EesDod0009Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchSumbyOfc(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EesDod0010Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSumbyOfcDetail(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("DodComEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchRHQOfcList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchOfcList(e);
			} 
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = searchSubOfcList(e);
			}
		}
		
		return eventResponse;
	}
	
	/**
	 * EES_DOD_0008 : [SEARCH]<br>
	 * [DOD Collection Audit 대상]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCollectionAuditList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EesDod0008Event event = (EesDod0008Event) e;
			
			CollectionAuditBC command = new CollectionAuditBCImpl();
			
			String status = command.searchCollectionAuditList(event.getCollectionAuditINVO(), account);
			eventResponse.setETCData("BackEndJobKey", status);
			
			return eventResponse;
		} catch(EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} 
	}
	
	
	/**
	 * EES_DOD_0008 : BackEndJob<br>
	 * BackEndJob의 실행결과에 대한 상태값을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchComBackEndJobStatusService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			CollectionAuditBC command = new CollectionAuditBCImpl();
			CollectionSummaryBC command2 = new CollectionSummaryBCImpl();
			String key = (String)e.getAttribute("KEY");
			String status = null;
			if(e.getEventName().equalsIgnoreCase("EesDod0008Event")){
				status = command.searchComBackEndJobStatusBasic(key);
			}else if(e.getEventName().equalsIgnoreCase("EesDod0017Event")){
				status = command2.searchComBackEndJobStatusBasic(key);
			}

			eventResponse.setETCData("jb_sts_flg", status);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DOD_0008 : BackEndJob<br>
	 * BackEndJob의 실행결과로 생성된 파일을 로드합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse loadFileBackEndJobResultService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String key = (String)e.getAttribute("KEY");
		List list = new ArrayList();

		try {
			if(e.getEventName().equalsIgnoreCase("EesDod0008Event")){
				list = (List<CollectionAuditListVO>)BackEndJobResult.loadFromFile(key);
			}else if(e.getEventName().equalsIgnoreCase("EesDod0017Event")){
				list = (List<CollectionSummaryByCustomerDetailVO>)BackEndJobResult.loadFromFile(key);
			}
			eventResponse.setRsVoList(list);
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	/**
	 * EES_DOD_0016 : [SEARCH]<br>
	 * [DOD Collection Summary by Customer 대상]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCollectionSummaryByCustomerList(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDod0016Event event = (EesDod0016Event)e;
		CollectionSummaryBC command = new CollectionSummaryBCImpl();
		try{
			List<CollectionSummaryByCustomerVO> list = command.searchCollectionSummaryByCustomer(event.getCollectionSummaryByCustomerVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * EES_DOD_0017 : [SEARCH]<br>
	 * [DOD Collection Summary Detail by Customer 대상]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCollectionSummaryByCustomerDetailList(Event e) throws EventException{
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EesDod0017Event event = (EesDod0017Event) e;
			CollectionSummaryBC command = new CollectionSummaryBCImpl();
			
			String status = command.searchCollectionSummaryByCustomerDetailList(event.getCollectionSummaryByCustomerDetailVO(), account);
			eventResponse.setETCData("BackEndJobKey", status);
			
			return eventResponse;
		} catch(EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} 
	}
	
	
	/**
	 * EES_DOD_0009 : [SEARCH]<br>
	 * [DOD Collection Summary RHQ Office List]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRHQOfcList(Event e) throws EventException {
		log.info("searchRHQOfcList : start");
		CollectionSummaryBC command = new CollectionSummaryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<String> list = command.searchRHQOfcList();
			if (list != null && list.size() > 0) {			
				StringBuffer ofcCds = new StringBuffer();
				
				for (int i = 0 ; i < list.size() ; i++) {
					String ofcCd = (String)list.get(i);
					ofcCds.append(ofcCd).append("|");
				}
				
				ofcCds.deleteCharAt(ofcCds.length()-1);
				eventResponse.setETCData("office", ofcCds.toString());
			}
			log.info("searchRHQOfcList : end");
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * EES_DOD_0009 : [SEARCH]<br>
	 * [DOD Collection Summary Office List]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfcList(Event e) throws EventException {
		CollectionSummaryBC command = new CollectionSummaryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<String> list = command.searchOfcList();
			log.error(list);
			if (list != null && list.size() > 0) {			
				StringBuffer ofcCds = new StringBuffer();
				
				for (int i = 0 ; i < list.size() ; i++) {
					String ofcCd = (String)list.get(i);
					ofcCds.append(ofcCd).append("|");
				}
				
				ofcCds.deleteCharAt(ofcCds.length()-1);
				eventResponse.setETCData("OFC_CD", ofcCds.toString());
			}
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	/**
	 * EES_DOD_0009 : INCL_SUB_OFC 체크박스<br>
	 * DOD Sub Office 정보를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSubOfcList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DodComEvent event = (DodComEvent)e;
		CollectionSummaryBC command = new CollectionSummaryBCImpl();
		try {
			List<String> list = command.searchSubOfcList(event.getOfficeSubVO());
			if (list != null && list.size() > 0) {			
				StringBuffer ofc_cds = new StringBuffer();
				
				for (int i = 0 ; i < list.size() ; i++) {
					String ofcCd = (String)list.get(i);
					ofc_cds.append(ofcCd).append(",");
				}
				
				ofc_cds.deleteCharAt(ofc_cds.length()-1);
				eventResponse.setETCData("OFC_CD", ofc_cds.toString());
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * EES_DOD_0009 : [SEARCH]<br>
	 * [DOD Collection Summary]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSumbyOfc(Event e) throws EventException {
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EesDod0009Event event = (EesDod0009Event) e;
			
			CollectionSummaryBC command = new CollectionSummaryBCImpl();
			
			List<SumbyOfcVO> list = command.searchSumbyOfc(event.getSumbyOfcVO());
			
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch(EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} 
	}
	
	/**
	 * EES_DOD_0010 : [SEARCH]<br>
	 * [DOD Collection Summary Detail]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException 
	 */
	private EventResponse searchSumbyOfcDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDod0010Event event = (EesDod0010Event)e;
		CollectionSummaryBC command = new CollectionSummaryBCImpl();
		try{
			List<SumbyOfcDetailVO> list = command.searchSumbyOfcDetail(event.getSumbyOfcDetailVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}

}