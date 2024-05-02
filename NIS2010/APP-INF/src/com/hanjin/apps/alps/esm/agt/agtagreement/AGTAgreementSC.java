/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AGTAgreementSC.java
 *@FileTitle : Commission Unit Cost Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.04.22
 *@LastModifier : 박성진
 *@LastVersion : 1.1
 * 2009.08.13 추경원
 * 1.0 Creation
 * 2009-09-04 : Ho-Jin Lee searchFACRateInfoList 추가
 * 2011.04.22 박성진 [CHM-201109104-01][EAS-AGT] Brokerage Agreement Rate Creation for S.America 개발
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtagreement;

import java.util.List;

import com.hanjin.apps.alps.esm.agt.agtagreement.agtcustomeragreementinfo.basic.AGTCustomerAgreementInfoBC;
import com.hanjin.apps.alps.esm.agt.agtagreement.agtcustomeragreementinfo.basic.AGTCustomerAgreementInfoBCImpl;
import com.hanjin.apps.alps.esm.agt.agtagreement.agtcustomeragreementinfo.event.EsmAgt0007Event;
import com.hanjin.apps.alps.esm.agt.agtagreement.agtcustomeragreementinfo.event.EsmAgt0008Event;
import com.hanjin.apps.alps.esm.agt.agtagreement.agtcustomeragreementinfo.event.EsmAgt0035Event;
import com.hanjin.apps.alps.esm.agt.agtagreement.agtcustomeragreementinfo.event.EsmAgt0057Event;
import com.hanjin.apps.alps.esm.agt.agtagreement.agtofficeagreementinfo.basic.AGTOfficeAgreementInfoBC;
import com.hanjin.apps.alps.esm.agt.agtagreement.agtofficeagreementinfo.basic.AGTOfficeAgreementInfoBCImpl;
import com.hanjin.apps.alps.esm.agt.agtagreement.agtofficeagreementinfo.event.EsmAgt0001Event;
import com.hanjin.apps.alps.esm.agt.agtagreement.agtofficeagreementinfo.event.EsmAgt0003Event;
import com.hanjin.apps.alps.esm.agt.agtagreement.agtofficeagreementinfo.event.EsmAgt0004Event;
import com.hanjin.apps.alps.esm.agt.agtagreement.agtofficeagreementinfo.event.EsmAgt0005Event;
import com.hanjin.apps.alps.esm.agt.agtagreement.agtofficeagreementinfo.event.EsmAgt0006Event;
import com.hanjin.apps.alps.esm.agt.agtagreement.agtofficeagreementinfo.event.EsmAgt0037Event;
import com.hanjin.apps.alps.esm.agt.agtagreement.agtofficeagreementinfo.event.EsmAgt0101Event;
import com.hanjin.apps.alps.esm.agt.agtagreement.agtofficeagreementinfo.vo.AgtChargeDeductionVO;
import com.hanjin.apps.alps.esm.agt.agtagreement.agtofficeagreementinfo.vo.AgtCntrTypeSizeVO;
import com.hanjin.apps.alps.esm.agt.agtagreement.agtofficeagreementinfo.vo.AgtGeogOfcVO;
import com.hanjin.apps.alps.esm.agt.agtagreement.agtothcomm.basic.AGTOthCommBC;
import com.hanjin.apps.alps.esm.agt.agtagreement.agtothcomm.basic.AGTOthCommBCImpl;
import com.hanjin.apps.alps.esm.agt.agtagreement.agtothcomm.event.EsmAgt0009Event;
import com.hanjin.apps.alps.esm.agt.agtagreement.agtothcomm.integration.AGTOthCommDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.AgtAgnAgmtMstVO;
import com.hanjin.syscommon.common.table.AgtAgnAgmtRtVO;
import com.hanjin.syscommon.common.table.AgtAgnAgmtVO;
import com.hanjin.syscommon.common.table.AgtAgnCtrtRefVO;
import com.hanjin.syscommon.common.table.AgtAgnOtrRefVO;
import com.hanjin.syscommon.common.table.AgtBrogAgmtRtVO;
import com.hanjin.syscommon.common.table.AgtFacAgmtGrpLocListVO;
import com.hanjin.syscommon.common.table.AgtFacAgmtRtVO;
import com.hanjin.syscommon.common.table.AgtOtrUtCostVO;
import com.hanjin.syscommon.common.table.AgtScsAgmtRtVO;

/**
 * ALPS-AGTAgreement Business Logic ServiceCommand - ALPS-AGTAgreement 대한 비지니스
 * 트랜잭션을 처리한다.
 * 
 * @author Kyung-won Chu
 * @see AGTOthCommDBDAO
 * @since J2EE 1.6
 */

public class AGTAgreementSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * AGTAgreement system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("AGTAgreementSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * AGTAgreement system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("AGTAgreementSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-AGTAgreement system 업무에서 발생하는 모든 이벤트의 분기처리<br>
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

		if (e.getEventName().equalsIgnoreCase("EsmAgt0009Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchUpdateDate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOtherUnitCostInfoList(e);
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

		if (e.getEventName().equalsIgnoreCase("EsmAgt0057Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchScsRateInfoList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiScsRateInfo(e);
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
	 * 조회 이벤트 처리<br>
	 * EsmAgt0001 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 * @Auther Ho-Jin Lee 2009-08-18 Creation
	 */
	private EventResponse searchAgentInfoForAgreementbyCountry(Event e)
			throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
	 * 삭제 이벤트 처리<br>
	 * EsmAgt0001 화면의 event에 대한 삭제 이벤트 처리<br>
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
	 * 추가 이벤트 처리<br>
	 * EsmAgt0001 화면의 event에 대한 추가 이벤트 처리<br>
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
	 * Copy 이벤트 처리<br>
	 * EsmAgt0001 화면의 event에 대한 추가 이벤트 처리<br>
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
	 * 조회 이벤트 처리<br>
	 * EsmAgt0044 화면에 대한 해당 Office 가 맞는지 조회 이벤트 처리<br>
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
	 * ESM_AGT_0003 화면에 대한 Office 조회<br>
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
	 * ESM_AGT_0003 화면에 대한 조회<br>
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
	 * ESM_AGT_0003 화면에 대한 Detail 조회 이벤트<br>
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
	 * ESM_AGT_0003 화면 CUD 이벤트<br>
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
	 * ESM_AGT_0003 화면 AGreement Copy 이벤트<br>
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
	 * ESM_AGT_0003 화면 AGreement Rt RowCopy Save이벤트<br>
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
	 * EsmAgr0009 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUpdateDate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0009Event event = (EsmAgt0009Event) e;
		AGTOthCommBC command = new AGTOthCommBCImpl();

		try {
			List<AgtOtrUtCostVO> list = command.searchUpdateDate(event
					.getAgtOtrUtCostVO());
			// eventResponse.setRsVoList(list);
			if (list != null && !list.isEmpty()) {
				AgtOtrUtCostVO agtOtrUtCostVO = list.get(0);
				String creDt = agtOtrUtCostVO.getCreDt();
				log.info("\n   creDt==" + creDt);
				eventResponse.setETCData("creDt", creDt);
			}
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
	 * EsmAgr0009 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOtherUnitCostInfoList(Event e)
			throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0009Event event = (EsmAgt0009Event) e;
		AGTOthCommBC command = new AGTOthCommBCImpl();

		try {
			List<AgtOtrUtCostVO> list = command
					.searchOtherUnitCostInfoList(event.getAgtOtrUtCostVO());
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
	 * 조회 이벤트 처리<br>
	 * EsmAgt0004 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOtherInfoList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
	 * multi 이벤트 처리<br>
	 * EsmAgt0004 화면의 event에 Multi 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOtherInfoSearchList(Event e)
			throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
	 * 조회 이벤트 처리<br>
	 * EsmAgt0005 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDeductionInfoList(Event e)
			throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
	 * 조회 이벤트 처리<br>
	 * EsmAgt0005 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDeductionInfoChkDetailChkList(Event e)
			throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
	 * 조회 이벤트 처리<br>
	 * ESM_AGT_006 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchGeogOfcInfoContiList(Event e)
	throws EventException {
// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
	 * 조회 이벤트 처리<br>
	 * ESM_AGT_006 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchGeogOfcInfoSubContiList(Event e)
	throws EventException {
// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
	 * 조회 이벤트 처리<br>
	 * ESM_AGT_006 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchGeogOfcInfoSubCntryList(Event e)
	throws EventException {
// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
	 * 조회 이벤트 처리<br>
	 * ESM_AGT_006 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchGeogOfcInfoLocList(Event e)
	throws EventException {
// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
	 * 조회 이벤트 처리<br>
	 * ESM_AGT_006 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchGeogOfcInfoOfcList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
	 * 조회 이벤트 처리<br>
	 * ESM_AGT_007 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUSABrokerageRateInfoList(Event e)
			throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
	 * 멀티 이벤트 처리<br>
	 * ESM_AGT_007 화면의 event에 대한 멀티 이벤트 처리<br>
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
	 * 조회 이벤트 처리<br>
	 * ESM_AGT_0057 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScsRateInfoList(Event e)
			throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0057Event event = (EsmAgt0057Event)e;
		AGTCustomerAgreementInfoBC command = new AGTCustomerAgreementInfoBCImpl();

		try {
			List<AgtScsAgmtRtVO> list = command.searchScsRateInfoList(event.getAgtScsAgmtRtVO());
			log.info("message message message message message message message message message ");
			eventResponse.setRsVoList(list);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * ESM_AGT_0057 화면의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiScsRateInfo(Event e)
			throws EventException {
		EsmAgt0057Event event = (EsmAgt0057Event)e;
		AGTCustomerAgreementInfoBC command = new AGTCustomerAgreementInfoBCImpl();

		try {

			begin();
			command.multiScsRateInfo(event.getAgtScsAgmtRtVOS(), account);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return this.searchScsRateInfoList(e);
	}


	
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_AGT_0008 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFACRateInfoList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
	 * 멀티 이벤트 처리<br>
	 * ESM_AGT_008 화면의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiFACRateInfo(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
	 * Request 이벤트 처리<br>
	 * ESM_AGT_008 화면의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyFACRateRequest(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
	 * Approval 이벤트 처리<br>
	 * ESM_AGT_008 화면의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyFACRateApproval(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
	 * Reject 이벤트 처리<br>
	 * ESM_AGT_008 화면의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyFACRateReject(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
	 * 조회 이벤트 처리<br>
	 * ESM_AGT_008 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFACCustomerInfo(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
	 * 조회 이벤트 처리<br>
	 * ESM_AGT_035 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFACGrpLocList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
	 * 조회 이벤트 처리<br>
	 * ESM_AGT_0037 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @param int gbn
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOtherInfoListInput(Event e, int gbn) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
	 * 조회 이벤트 처리<br>
	 * ESM_AGT_0037 화면에 대한 조회 이벤트 처리<br>
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
	 * 조회 이벤트 처리<br>
	 * EsmAgt0101 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRepCntrList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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