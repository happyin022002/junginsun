/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AGTAgreementSC.java
 *@FileTitle : Commission Unit Cost Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.agt.agtagreement;

import java.util.List;

import com.clt.apps.opus.esm.agt.agtagreement.agtcustomeragreementinfo.basic.AGTCustomerAgreementInfoBC;
import com.clt.apps.opus.esm.agt.agtagreement.agtcustomeragreementinfo.basic.AGTCustomerAgreementInfoBCImpl;
import com.clt.apps.opus.esm.agt.agtagreement.agtcustomeragreementinfo.event.EsmAgt0007Event;
import com.clt.apps.opus.esm.agt.agtagreement.agtcustomeragreementinfo.event.EsmAgt0008Event;
import com.clt.apps.opus.esm.agt.agtagreement.agtcustomeragreementinfo.event.EsmAgt0035Event;
import com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.basic.AGTOfficeAgreementInfoBC;
import com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.basic.AGTOfficeAgreementInfoBCImpl;
import com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.event.EsmAgt0001Event;
import com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.event.EsmAgt0003Event;
import com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.event.EsmAgt0004Event;
import com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.event.EsmAgt0005Event;
import com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.event.EsmAgt0006Event;
import com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.event.EsmAgt0037Event;
import com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.event.EsmAgt0101Event;
import com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.vo.AgtChargeDeductionVO;
import com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.vo.AgtCntrTypeSizeVO;
import com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.vo.AgtGeogOfcVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.AgtAgnAgmtMstVO;
import com.clt.syscommon.common.table.AgtAgnAgmtRtVO;
import com.clt.syscommon.common.table.AgtAgnAgmtVO;
import com.clt.syscommon.common.table.AgtAgnCtrtRefVO;
import com.clt.syscommon.common.table.AgtAgnOtrRefVO;
import com.clt.syscommon.common.table.AgtBrogAgmtRtVO;
import com.clt.syscommon.common.table.AgtFacAgmtGrpLocListVO;
import com.clt.syscommon.common.table.AgtFacAgmtRtVO;

/**
 * OPUS-AGTAgreement Business Logic ServiceCommand - OPUS-AGTAgreement handling business transaction 
 *  
 * @author
 * @see AGTOthCommDBDAO
 * @since J2EE 1.6 
 */ 

public class AGTAgreementSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * AGTAgreement system preceding process for biz scenario<br>
	 * related objects creation<br>
	 */
	public void doStart() {
		log.debug("AGTAgreementSC 시작");
		try {
			// checking Login user ID
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * AGTAgreement system biz scenario closing<br>
	 * biz scenario closing<br>
	 */
	public void doEnd() {
		log.debug("AGTAgreementSC 종료");
	}

	/**
	 * 
	 * @param e
	 *            Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("EsmAgt0001Event")) {
			switch (e.getFormCommand().getCommand()) {
			case FormCommand.SEARCH:
				eventResponse = searchAgentInfoForAgreementbyCountry(e);
				break;
			case FormCommand.REMOVE:
				eventResponse = removeAgentInfoForAgreement(e);
				break;
			case FormCommand.ADD:
				eventResponse = createAgentInfoForAgreement(e);
				break;
			case FormCommand.MULTI:
				eventResponse = createOldAgreementNoVendortoNew(e);
				break;
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsmAgt0003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAgentRateInfoList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchAgentRateInfoList2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchAgentRateDetailInfoList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = multiAgentRateInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = multicopyAgentRateInfo(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = multiAgentRateDetailInfo(e);
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsmAgt0004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOtherInfoList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchOtherInfoSearchList(e);
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsmAgt0005Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDeductionInfoList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchDeductionInfoChkDetailChkList(e);
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsmAgt0006Event")) {
			switch (e.getFormCommand().getCommand()) {
			case FormCommand.SEARCH01:
				eventResponse = searchGeogOfcInfoContiList(e);
				break;
			case FormCommand.SEARCH02:
				eventResponse = searchGeogOfcInfoSubContiList(e);
				break;
			case FormCommand.SEARCH03:
				eventResponse = searchGeogOfcInfoSubCntryList(e);
				break;
			case FormCommand.SEARCH04:
				eventResponse = searchGeogOfcInfoLocList(e);
				break;
			case FormCommand.SEARCH05:
				eventResponse = searchGeogOfcInfoOfcList(e);
				break;
			}

		}

		if (e.getEventName().equalsIgnoreCase("EsmAgt0007Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUSABrokerageRateInfoList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiUSABrokerageRateInfo(e);
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsmAgt0008Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFACRateInfoList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				log.info("\n >>>>>>>>>>>>>>>> if(insertVoList.size() > 0){===MULTI1");
				eventResponse = multiFACRateInfo(e);
				log.info("\n >>>>>>>>>>>>>>>> if(insertVoList.size() > 0){===MULTI2");
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = modifyFACRateRequest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = modifyFACRateApproval(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = modifyFACRateReject(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchFACCustomerInfo(e);
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsmAgt0035Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFACGrpLocList(e);
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsmAgt0037Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOtherInfoListInput(e, 1);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchOtherInfoListInput(e, 2);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchOtherInfoListInput2(e, 3);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchOtherInfoListInput2(e, 4);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchOtherInfoListInput(e, 5);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchOtherInfoListInput(e, 6);
			}
		}
		
				
		if (e.getEventName().equalsIgnoreCase("EsmAgt0101Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRepCntrList(e);
			} 
		}

		
		return eventResponse;
	}

	/**
	 * retrieve event process<br>
	 * EsmAgt0001 retrieve event process<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 * @Auther Ho-Jin Lee 2009-08-18 Creation
	 */
	private EventResponse searchAgentInfoForAgreementbyCountry(Event e)
			throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0001Event event = (EsmAgt0001Event) e;
		AGTOfficeAgreementInfoBC command = new AGTOfficeAgreementInfoBCImpl();

		try {
			List<AgtAgnAgmtVO> list = command
					.searchAgentInfoForAgreementbyCountry(event
							.getAgtAgnAgmtVO());
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
	 * delete event process<br>
	 * EsmAgt0001 delete event process<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse removeAgentInfoForAgreement(Event e)
			throws EventException {
		EsmAgt0001Event event = (EsmAgt0001Event) e;
		AGTOfficeAgreementInfoBC command = new AGTOfficeAgreementInfoBCImpl();
		try {
			begin();
			command.removeAgentInfoForAgreement(event.getAgtAgnAgmtVOS(),
					account);
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}
		return searchAgentInfoForAgreementbyCountry(e);
	}

	/**
	 * create event process<br>
	 * EsmAgt0001 create event process<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse createAgentInfoForAgreement(Event e)
			throws EventException {
		EsmAgt0001Event event = (EsmAgt0001Event) e;
		try {

			AGTOfficeAgreementInfoBC command = new AGTOfficeAgreementInfoBCImpl();
			begin();
			command.createAgentInfoForAgreement(event.getAgtAgnAgmtVOS(),
					account);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return searchAgentInfoForAgreementbyCountry(e);
	}

	/**
	 * Copy event process<br>
	 * EsmAgt0001 Copy event process<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse createOldAgreementNoVendortoNew(Event e)
			throws EventException {
		EsmAgt0001Event event = (EsmAgt0001Event) e;
		try {

			AGTOfficeAgreementInfoBC command = new AGTOfficeAgreementInfoBCImpl();
			begin();
			command.createOldAgreementNoVendortoNew(event.getAgtAgnAgmtVOS(),
					event.getAgtAgnAgmtVO(), account);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return searchAgentInfoForAgreementbyCountry(e);
	}

	/**
	 * retrieve event process<br>
	 * EsmAgt0044 retrieve event process of checking about agreement office<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	/*
	private EventResponse checkAgreementOffice(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0001Event event = (EsmAgt0001Event) e;
		AGTOfficeAgreementInfoBC command = new AGTOfficeAgreementInfoBCImpl();

		try {
			List<AgtAgnAgmtVO> list = command.checkAgreementOffice(event.getAgtAgnAgmtVO(), account);
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
	 * retrieve event process
	 * ESM_AGT_0003 retrieve event process about searching Office 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgentRateInfoList(Event e)
			throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0003Event event = (EsmAgt0003Event) e;
		AGTOfficeAgreementInfoBC command = new AGTOfficeAgreementInfoBCImpl();

		try {
			List<AgtAgnAgmtMstVO> list = command.searchAgentRateInfoList(event
					.getAgtAgnAgmtMstVO());
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
	 * ESM_AGT_0003 retrieve event process 2<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchAgentRateInfoList2(Event e)
			throws EventException {
		// TODO Auto-generated method stub
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0003Event event = (EsmAgt0003Event) e;
		AGTOfficeAgreementInfoBC command = new AGTOfficeAgreementInfoBCImpl();

		try {
			List<AgtAgnAgmtVO> list = command.searchAgentRateInfoList2(event
					.getAgtAgnAgmtVO());
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
	 * ESM_AGT_0003 retrieve event process about detail information<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgentRateDetailInfoList(Event e)
			throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0003Event event = (EsmAgt0003Event) e;
		AGTOfficeAgreementInfoBC command = new AGTOfficeAgreementInfoBCImpl();
		try {
			List<AgtAgnAgmtRtVO> list = command
					.searchAgentRateDetailInfoList(event.getAgtAgnAgmtRtVO());
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
	 * ESM_AGT_0003 CUD event process<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse multiAgentRateInfo(Event e) throws EventException {
		// TODO Auto-generated method stub
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0003Event event = (EsmAgt0003Event) e;
		AGTOfficeAgreementInfoBC command = new AGTOfficeAgreementInfoBCImpl();

		try {
			begin();
			command.multiAgentRateInfo(event.getAgtAgnAgmtVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_AGT_0003 AGreement Copy event process<br>
	 * 
	 * @param e
	 * @return eventResponse
	 * @throws EventException
	 */
	private EventResponse multicopyAgentRateInfo(Event e) throws EventException {
		// TODO Auto-generated method stub
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0003Event event = (EsmAgt0003Event) e;
		AGTOfficeAgreementInfoBC command = new AGTOfficeAgreementInfoBCImpl();
		try {
			begin();
			command.multicopyAgentRateInfo(event.getAgtAgnAgmtVOS(), event.getAgtAgnAgmtVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * ESM_AGT_0003 AGreement Rt RowCopy Save event process<br>
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse multiAgentRateDetailInfo(Event e) throws EventException{
	    // TODO Auto-generated method stub
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0003Event event = (EsmAgt0003Event) e;
		AGTOfficeAgreementInfoBC command = new AGTOfficeAgreementInfoBCImpl();
		try{
			begin();
			command.multiAgentRateDetailInfo(event.getAgtAgnAgmtRtVOS(), event.getAgtAgnAgmtRtVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("").getUserMessage());
			commit();
		}catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	    return eventResponse;
    }


	/**
	 * retrieve event process<br>
	 * EsmAgt0004 retrieve event process<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOtherInfoList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0004Event event = (EsmAgt0004Event)e;
		AGTOfficeAgreementInfoBC command = new AGTOfficeAgreementInfoBCImpl();

		try{
			List[] responseData = command.searchOtherInfoList(event.getAgtCntrTypeSizeVO());
			eventResponse.setRsVoList(responseData[0]);
			eventResponse.setRsVoList(responseData[1]);
			eventResponse.setRsVoList(responseData[2]);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;

	}

	/**
	 * multi event process<br>
	 * EsmAgt0004 multi event process<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOtherInfoSearchList(Event e)
			throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0004Event event = (EsmAgt0004Event)e;
		AGTOfficeAgreementInfoBC command = new AGTOfficeAgreementInfoBCImpl();

		try{
			List<AgtCntrTypeSizeVO> list = command.searchOtherInfoSearchList(event.getAgtCntrTypeSizeVO());
			eventResponse.setRsVoList(null);
			eventResponse.setRsVoList(null);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;

	}

	/**
	 * retrieve event process<br>
	 * EsmAgt0005 retrieve event process<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDeductionInfoList(Event e)
			throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0005Event event = (EsmAgt0005Event)e;
		AGTOfficeAgreementInfoBC command = new AGTOfficeAgreementInfoBCImpl();


		try {
			List[] responseData = command.searchDeductionInfoList(event.getAgtChargeDeductionVO());
			eventResponse.setRsVoList(responseData[0]);
			eventResponse.setRsVoList(responseData[1]);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}


	/**
	 * retrieve event process<br>
	 * EsmAgt0005 retrieve event process<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDeductionInfoChkDetailChkList(Event e)
			throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0005Event event = (EsmAgt0005Event)e;
		AGTOfficeAgreementInfoBC command = new AGTOfficeAgreementInfoBCImpl();


		try {
			List<AgtChargeDeductionVO> list = command.searchDeductionInfoChkDetailChkList(event.getAgtChargeDeductionVO());
			eventResponse.setRsVoList(null);
			eventResponse.setRsVoList(list);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event process<br>
	 * ESM_AGT_006 retrieve event process<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchGeogOfcInfoContiList(Event e)
	throws EventException {

GeneralEventResponse eventResponse = new GeneralEventResponse();
EsmAgt0006Event event = (EsmAgt0006Event)e;
AGTOfficeAgreementInfoBC command = new AGTOfficeAgreementInfoBCImpl();


try {
	List<AgtGeogOfcVO> list = command.searchGeogOfcInfoContiList(event.getAgtGeogOfcVO());
	eventResponse.setRsVoList(list);
} catch (EventException de) {
	log.error("err " + de.toString(), de);
	throw new EventException(de.getMessage());
}
return eventResponse;
}

	/**
	 * retrieve event process<br>
	 * ESM_AGT_006 retrieve event processv<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchGeogOfcInfoSubContiList(Event e)
	throws EventException {

GeneralEventResponse eventResponse = new GeneralEventResponse();
EsmAgt0006Event event = (EsmAgt0006Event)e;
AGTOfficeAgreementInfoBC command = new AGTOfficeAgreementInfoBCImpl();


try {
	List<AgtGeogOfcVO> list = command.searchGeogOfcInfoSubContiList(event.getAgtGeogOfcVO());
	eventResponse.setRsVoList(list);
} catch (EventException de) {
	log.error("err " + de.toString(), de);
	throw new EventException(de.getMessage());
}
return eventResponse;
}

	/**
	 * retrieve event process<br>
	 * ESM_AGT_006 retrieve event process<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchGeogOfcInfoSubCntryList(Event e)
	throws EventException {

GeneralEventResponse eventResponse = new GeneralEventResponse();
EsmAgt0006Event event = (EsmAgt0006Event)e;
AGTOfficeAgreementInfoBC command = new AGTOfficeAgreementInfoBCImpl();


try {
	List<AgtGeogOfcVO> list = command.searchGeogOfcInfoCntryList(event.getAgtGeogOfcVO());
	eventResponse.setRsVoList(list);
} catch (EventException de) {
	log.error("err " + de.toString(), de);
	throw new EventException(de.getMessage());
}
return eventResponse;
}

	/**
	 * retrieve event process<br>
	 * ESM_AGT_006 retrieve event process<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchGeogOfcInfoLocList(Event e)
	throws EventException {

GeneralEventResponse eventResponse = new GeneralEventResponse();
EsmAgt0006Event event = (EsmAgt0006Event)e;
AGTOfficeAgreementInfoBC command = new AGTOfficeAgreementInfoBCImpl();


try {
	List<AgtGeogOfcVO> list = command.searchGeogOfcInfoLocList(event.getAgtGeogOfcVO());
	eventResponse.setRsVoList(list);
} catch (EventException de) {
	log.error("err " + de.toString(), de);
	throw new EventException(de.getMessage());
}
return eventResponse;
}

	/**
	 * retrieve event process<br>
	 * ESM_AGT_006 retrieve event process<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchGeogOfcInfoOfcList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0006Event event = (EsmAgt0006Event)e;
		AGTOfficeAgreementInfoBC command = new AGTOfficeAgreementInfoBCImpl();


		try {
			List<AgtGeogOfcVO> list = command.searchGeogOfcInfoOfcList(event.getAgtGeogOfcVO());
			eventResponse.setRsVoList(list);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
		}

	/**
	 * retrieve event process<br>
	 * ESM_AGT_007 retrieve event process<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUSABrokerageRateInfoList(Event e)
			throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0007Event event = (EsmAgt0007Event)e;
		AGTCustomerAgreementInfoBC command = new AGTCustomerAgreementInfoBCImpl();

		try {
			List<AgtBrogAgmtRtVO> list = command.searchUSABrokerageRateInfoList(event.getAgtBrogAgmtRtVO());
			eventResponse.setRsVoList(list);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * multi event process<br>
	 * ESM_AGT_007 multi event process<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiUSABrokerageRateInfo(Event e)
			throws EventException {
		EsmAgt0007Event event = (EsmAgt0007Event)e;
		AGTCustomerAgreementInfoBC command = new AGTCustomerAgreementInfoBCImpl();

		try {

			begin();
			command.multiUSABrokerageRateInfo(event.getAgtBrogAgmtRtVOS(), account);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return this.searchUSABrokerageRateInfoList(e);
	}

	/**
	 * retrieve event process<br>
	 * ESM_AGT_0008 retrieve event process<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFACRateInfoList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0008Event event = (EsmAgt0008Event)e;
		AGTCustomerAgreementInfoBC command = new AGTCustomerAgreementInfoBCImpl();
		try {
			List<AgtFacAgmtRtVO> list = command.searchFACRateInfoList(event.getAgtFacAgmtRtVO());
			eventResponse.setRsVoList(list);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * multi event process<br>
	 * ESM_AGT_008 multi event process<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiFACRateInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0008Event event = (EsmAgt0008Event)e;
		AGTCustomerAgreementInfoBC command = new AGTCustomerAgreementInfoBCImpl();

		try {
			log.info("\n >>>>>>>>>>>>>>multiFACRateInfo1");
			begin();
			command.multiFACRateInfo(event.getAagtFacAgmtRtVOS(), account);
			log.info("\n >>>>>>>>>>>>>>multiFACRateInfo2");
			commit();
			log.info("\n >>>>>>>>>>>>>>multiFACRateInfo3");
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Request event process<br>
	 * ESM_AGT_008 Request event process<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyFACRateRequest(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0008Event event = (EsmAgt0008Event)e;
		AGTCustomerAgreementInfoBC command = new AGTCustomerAgreementInfoBCImpl();
		try {
			begin();
			command.modifyFACRateRequest(event.getAagtFacAgmtRtVOS(), account);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Approval event process<br>
	 * ESM_AGT_008 Approval event process<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyFACRateApproval(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0008Event event = (EsmAgt0008Event)e;
		AGTCustomerAgreementInfoBC command = new AGTCustomerAgreementInfoBCImpl();
		try {

			begin();
			command.modifyFACRateApproval(event.getAagtFacAgmtRtVOS(), account);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Reject event process<br>
	 * ESM_AGT_008 Reject event process<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyFACRateReject(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0008Event event = (EsmAgt0008Event)e;
		AGTCustomerAgreementInfoBC command = new AGTCustomerAgreementInfoBCImpl();

		try {
			begin();
			command.modifyFACRateReject(event.getAagtFacAgmtRtVOS(), account);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event process<br>
	 * ESM_AGT_008 retrieve event process<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFACCustomerInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0008Event event = (EsmAgt0008Event)e;
		AGTCustomerAgreementInfoBC command = new AGTCustomerAgreementInfoBCImpl();
		try {
	
//			eventResponse = command.searchFACCustomerInfo(e);
			
			List<AgtFacAgmtRtVO> list = command.searchFACCustomerInfo(event.getAgtFacAgmtRtVO());
			log.info("\n list="+list);
			eventResponse.setRsVoList(list);
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event process<br>
	 * ESM_AGT_035 retrieve event process<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFACGrpLocList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0035Event event = (EsmAgt0035Event)e;
		AGTCustomerAgreementInfoBC command = new AGTCustomerAgreementInfoBCImpl();

		try {

			List<AgtFacAgmtGrpLocListVO> list =	command.searchFACGrpLocList(event.getAgtFacAgmtGrpLocVO());
			eventResponse.setRsVoList(list);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event process<br>
	 * ESM_AGT_0037 retrieve event process<br>
	 * 
	 * @param Event e
	 * @param int gbn
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOtherInfoListInput(Event e, int gbn) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0037Event event = (EsmAgt0037Event)e;
		AGTOfficeAgreementInfoBC command = new AGTOfficeAgreementInfoBCImpl();
		try {
			List<AgtAgnOtrRefVO> list = command.searchOtherInfoListInput(event.getAgtAgnOtrRefVO(), gbn);
			eventResponse.setRsVoList(list);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
	 * retrieve event process<br>
	 * ESM_AGT_0037 retrieve event process<br>
	 * 
	 * @param Event e
	 * @param int gbn
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOtherInfoListInput2(Event e, int gbn) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0037Event event = (EsmAgt0037Event)e;
		AGTOfficeAgreementInfoBC command = new AGTOfficeAgreementInfoBCImpl();
		try{
			List<AgtAgnCtrtRefVO> list = command.searchOtherInfoListInput2(event.getAgtAgnCtrtRefVO(), gbn);
			eventResponse.setRsVoList(list);
		}catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	    return null;
    }
    
    	
	/**
	 * retrieve event process<br>
	 * EsmAgt0101 retrieve event process<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRepCntrList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0101Event event = (EsmAgt0101Event)e;
		AGTOfficeAgreementInfoBC command = new AGTOfficeAgreementInfoBCImpl();

		try{
			List<AgtCntrTypeSizeVO> list = command.searchRepCntrList(event.getAgtCntrTypeSizeVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;

	}

    
}