/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgreementManageSC.java
*@FileTitle : MNR Tariff No Inquiry_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.18
*@LastModifier : Chang Young Kim
*@LastVersion : 1.0
* 2009.06.02 김완규
* 1.0 Creation
* 2014-12-18 Chang Young Kim [CHM-201433304] CSR 승인 강화에 따른 ALPS MNR-AGMT에 GW Document Contract Link 관련 추가 요청 사항
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.agreementmanage;

import java.util.List;

import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.basic.RateMgtBC;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.basic.RateMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.event.EesMnr0015Event;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.event.EesMnr0016Event;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.event.EesMnr0017Event;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.event.EesMnr0018Event;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.event.EesMnr0218Event;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.event.EesMnrS218Event;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.AgmtAtchDataVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.AgreementGRPVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.AgreementInfoListGRPVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.basic.TariffMgtBC;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.basic.TariffMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.event.EesMnr0011Event;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.event.EesMnr0014Event;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.event.EesMnr0136Event;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.event.EesMnr0154Event;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.event.EesMnr0171Event;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.event.EesMnr0188Event;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.event.EesMnr0190Event;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.event.EesMnr0232Event;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.event.EesMnrS011Event;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.event.EesMnrS171Event;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.integration.TariffMgtDBDAO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffEffDtGRPVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffGRPVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffQuarterGRPVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffQuarterVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffRegionVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.RepairTariffMgtGRPVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.TariffApprovalGRPVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.TariffPopupGRPVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.TariffPopupINVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.VerifyTariffFileListGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.basic.PartnerMgtBC;
import com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.basic.PartnerMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.basic.GeneralCodeCheckMgtBC;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.basic.GeneralCodeCheckMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.vo.GeneralCodeCheckMgtGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.basic.RepairMgtBC;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.basic.RepairMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.CustomMnrRprRqstHdrVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-AgreementManage Business Logic ServiceCommand - alps-AgreementManage 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author WanGyu Kim
 * @see TariffMgtDBDAO
 * @since J2EE 1.6
 */

public class AgreementManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * AgreementManage system 업무 시나리오 선행작업<br>
	 * ees_mnr_0188업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("AgreementManageSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * AgreementManage system 업무 시나리오 마감작업<br>
	 * ees_mnr_0188 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("AgreementManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * alps-AgreementManage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EesMnr0188Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRepairTariffPopUpListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0015Event")) {
			//조회
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAgreementService(e);
			}
			//삭제
			else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeAgreementService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageAgreementService(e);
			}
			//메뉴구조를 가져온다.
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAgreementMenuService(e);
			}
			//콤보용 데이타 조회
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchAgreementComboListService(e);
			}
			//Tarrif 콤보용 데이타 조회
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchRepairTariffComboListService(e);
			}
			//어그리먼트를 사용하는 견적서 리스트를 조회
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchUsedEstimateByAGMTService(e);
			}
			//버젼업 하기전 미승인 견적서가 존재하는지 체크
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchNotApprovalESTByAGMTService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0016Event")) {
			//조회
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAgreementInfoListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0017Event")) {
			//조회
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAgreementAttachInfoListService(e);
			}
			// 저장
			else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageAgreementAttachInfoService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0018Event")) {
			//조회
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAgreementInfoListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0014Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRepairTariffService(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageRepairTariffService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0154EventOLD")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalTariffListService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDisposalTariffService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDisposalTariffEffDtListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0154Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalTariffRegionListService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDisposalTariffRegionListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = backEndDisposalTariffRegionListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchComBackEndJobStatusService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0232EventOLD")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalTariffInqueryListService(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDisposalTariffInqueryEffDtListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0232Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalTariffQuarterListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0190Event")) {
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = verifyRepairTariffService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0218Event")) {
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = searchAgreementService(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesMnr0011Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDefaultRepairTariffDetailService(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesMnr0136Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRepairTariffApprovalListService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyRepairTariffStatusService(e);
			}

		}
		else if (e.getEventName().equalsIgnoreCase("EesMnr0171Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRepairTariffApprovalListService(e);
			}
		}
		//**************** SPP FUNCTION *******************************//
		else if (e.getEventName().equalsIgnoreCase("EesMnrS011Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDefaultRepairTariffDetailService(e);
			}
		}
	    else if (e.getEventName().equalsIgnoreCase("EesMnrS018Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAgreementInfoListService(e);
			}
	    }
	    else if (e.getEventName().equalsIgnoreCase("EesMnrS218Event")) {
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = searchAgreementService(e);
			}
	    }
		else if (e.getEventName().equalsIgnoreCase("EesMnrS171Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRepairTariffApprovalListService(e);
			}
		}

		return eventResponse;
	}

	/**
	 * EES_MNR_0015 : IBSEARCH_ASYNC04 <br>
	 * [EES_MNR_0015] 견적서에서 해당 Agreement를 사용하는 견적서 리스트를 조회합니다.. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUsedEstimateByAGMTService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RepairMgtBC command = new RepairMgtBCImpl();
		AgreementGRPVO agreementGRPVO = new AgreementGRPVO();
		EesMnr0015Event event = (EesMnr0015Event)e;
		agreementGRPVO = event.getAgreementGRPVO();

		try{
			agreementGRPVO = command.searchUsedEstimateByAGMTBasic(agreementGRPVO);

			List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOs = agreementGRPVO.getCustomMnrRprRqstHdrVOS();

			StringBuilder retResultList = new StringBuilder("");
			for (int i = 0; i < customMnrRprRqstHdrVOs.size(); i++) {
				retResultList.append("EQ No. : ").append(customMnrRprRqstHdrVOs.get(i).getRqstEqNo()).append("\t").append("Estimate No. : ").append(customMnrRprRqstHdrVOs.get(i).getRqstRefNo()).append("\n");
			}

			eventResponse.setETCData("EST_LIST",retResultList.toString());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0015 : IBSEARCH_ASYNC05 <br>
	 * [EES_MNR_0015] 버젼업 하기전 미승인된 견적서 리스트를 조회합니다.. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNotApprovalESTByAGMTService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RepairMgtBC command = new RepairMgtBCImpl();
		AgreementGRPVO agreementGRPVO = new AgreementGRPVO();
		EesMnr0015Event event = (EesMnr0015Event)e;
		agreementGRPVO = event.getAgreementGRPVO();

		try{
			agreementGRPVO = command.searchNotApprovalESTByAGMTBasic(agreementGRPVO);

			List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOs = agreementGRPVO.getCustomMnrRprRqstHdrVOS();

			StringBuilder retResultList = new StringBuilder("");
			for (int i = 0; i < customMnrRprRqstHdrVOs.size(); i++) {
				retResultList.append("EQ No. : ").append(customMnrRprRqstHdrVOs.get(i).getRqstEqNo()).append("\t").append("Estimate No. : ").append(customMnrRprRqstHdrVOs.get(i).getRqstRefNo()).append("\n");
			}

			eventResponse.setETCData("EST_LIST",retResultList.toString());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0188 : Retrieve <br>
	 * [EES_MNR_0188]M&R Tariff No Inquiry_Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRepairTariffPopUpListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TariffMgtBC command = new TariffMgtBCImpl();

		TariffPopupGRPVO tariffPopupGRPVO = new TariffPopupGRPVO();

		EesMnr0188Event event = (EesMnr0188Event)e;
		TariffPopupINVO tariffPopupINVO = event.getTariffPopupINVO();
		tariffPopupGRPVO.setTariffPopupINVO(tariffPopupINVO);

		try{
			tariffPopupGRPVO = command.searchRepairTariffPopUpListBasic(tariffPopupGRPVO,account);
			eventResponse.setRsVoList(tariffPopupGRPVO.getCustomMnrRprTrfHdrVOs());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0015 : Retrieve <br>
	 * [EES_MNR_0188]M&R Tariff No Combo의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRepairTariffComboListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TariffMgtBC command = new TariffMgtBCImpl();
		TariffPopupGRPVO tariffPopupGRPVO = new TariffPopupGRPVO();
		EesMnr0015Event event = (EesMnr0015Event)e;
		tariffPopupGRPVO = event.getTariffPopupGRPVO();

		try{
			tariffPopupGRPVO = command.searchRepairTariffComboListBasic(tariffPopupGRPVO);
			eventResponse.setRsVoList(tariffPopupGRPVO.getCustomMnrRprTrfHdrVOs());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0218 : Retrieve <br>
	 * [EES_MNR_0218]M&R Agreement의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgreementService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = null;
		//EesMnr0015Event event = (EesMnr0015Event)e;
		RateMgtBC command = new RateMgtBCImpl();

		try{
			if (e.getEventName().equalsIgnoreCase("EesMnr0015Event")) {
				EesMnr0015Event event = (EesMnr0015Event)e;
				AgreementGRPVO agreementGRPVO = command.searchAgreementBasic(event.getAgreementGRPVO());
				eventResponse = agreementGRPVO.getGeneralEventResponse();
			} else if (e.getEventName().equalsIgnoreCase("EesMnr0218Event")) {
				EesMnr0218Event event = (EesMnr0218Event)e;
				AgreementGRPVO agreementGRPVO = command.searchAgreementBasic(event.getAgreementGRPVO());
				eventResponse = agreementGRPVO.getGeneralEventResponse();
			} else if (e.getEventName().equalsIgnoreCase("EesMnrS218Event")) {
				EesMnrS218Event event = (EesMnrS218Event)e;
				AgreementGRPVO agreementGRPVO = command.searchAgreementBasic(event.getAgreementGRPVO());
				eventResponse = agreementGRPVO.getGeneralEventResponse();
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0015 : doActionIBSheet <br>
	 * [EES_MNR_0015]M&R Agreement의 정보를 삭제 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeAgreementService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0015Event event = (EesMnr0015Event)e;
		RateMgtBC command = new RateMgtBCImpl();
		event.getAgreementGRPVO().setAccount(account);

		try{
			begin();
			command.removeAgreementBasic(event.getAgreementGRPVO());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0015 : Save <br>
	 * [EES_MNR_0015]M&R Agreement의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAgreementService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0015Event event = (EesMnr0015Event)e;
		RateMgtBC command = new RateMgtBCImpl();
		PartnerMgtBC command1 = new PartnerMgtBCImpl();

		event.getAgreementGRPVO().setAccount(account);
		event.getRepairPartnerGRPVO().setAccount(account);

		try{
			begin();
			AgreementGRPVO agreementGRPVO = command.manageAgreementBasic(event.getAgreementGRPVO());
			command1.manageRepairPartnerBasic(event.getRepairPartnerGRPVO(),account);
			commit();
			agreementGRPVO = command.searchAgreementBasic(agreementGRPVO);
			eventResponse = agreementGRPVO.getGeneralEventResponse();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception eex){
			rollback();
			throw new EventException(eex.getMessage(), eex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0218 : doActionIBSheet <br>
	 * [EES_MNR_0218]M&R Agreement의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgreementMenuService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0015Event event = (EesMnr0015Event)e;
		RateMgtBC command = new RateMgtBCImpl();

		try{
			AgreementGRPVO agreementGRPVO = command.searchAgreementMenuBasic(event.getAgreementGRPVO());
			eventResponse.setRsVoList(agreementGRPVO.getCustomAgreementMenuDataVOS());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0018 : Retrieve <br>
	 * [EES_MNR_0018]M&R Agreement List의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgreementInfoListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RateMgtBC command = new RateMgtBCImpl();

		try{
			AgreementInfoListGRPVO agreementInfoListGRPVO = new AgreementInfoListGRPVO();

			if (e.getEventName().equalsIgnoreCase("EesMnr0016Event")) {
				EesMnr0016Event event = (EesMnr0016Event)e;
				agreementInfoListGRPVO = command.searchAgreementInfoListBasic(event.getAgreementInfoListGRPVO());
			}else if (e.getEventName().equalsIgnoreCase("EesMnr0018Event")) {
				EesMnr0018Event event = (EesMnr0018Event)e;
				agreementInfoListGRPVO = command.searchAgreementInfoListBasic(event.getAgreementInfoListGRPVO());
			}

			eventResponse.setRsVoList(agreementInfoListGRPVO.getCustomAgreementInfoListDataVOs());

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0215 : Retrieve <br>
	 * [EES_MNR_0215]Tariff Detail Information_Pop_Up의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRepairTariffService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0014Event event = (EesMnr0014Event)e;
		TariffMgtBC command = new TariffMgtBCImpl();

		RepairTariffMgtGRPVO repairTariffMgtGRPVO = new RepairTariffMgtGRPVO();
		repairTariffMgtGRPVO.setRepairTariffMgtINVO((event.getRepairTariffMgtINVO()));

		try{
			repairTariffMgtGRPVO = command.searchRepairTariffBasic(repairTariffMgtGRPVO,account);
			//단건조회(Header)
			eventResponse.setRsVoList(repairTariffMgtGRPVO.getCustomMnrRprTrfHdrVOs());
			//다중조회(Detail)
			for (int i = 0; i < repairTariffMgtGRPVO.getListCustomMnrRprTrfDtlVOs().size(); i++) {
				eventResponse.setRsVoList(repairTariffMgtGRPVO.getListCustomMnrRprTrfDtlVOs().get(i));
			}

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0014 : Save <br>
	 * [EES_MNR_0014]M&R Standard Tariff Creation & Inquiry의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRepairTariffService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0014Event event = (EesMnr0014Event)e;
		TariffMgtBC command = new TariffMgtBCImpl();

		try{
			begin();

			RepairTariffMgtGRPVO repairTariffMgtGRPVO = new RepairTariffMgtGRPVO();
			repairTariffMgtGRPVO.setCustomMnrRprTrfHdrVO(event.getCustomMnrRprTrfHdrVO());
			repairTariffMgtGRPVO.setArrayCustomMnrRprTrfDtlVOs(event.getArrayCustomMnrRprTrfDtlVOs());
			repairTariffMgtGRPVO = command.manageRepairTariffBasic(repairTariffMgtGRPVO,account);

			//Tariff No return
			eventResponse.setRsVo(repairTariffMgtGRPVO.getCustomMnrRprTrfHdrVO());

			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0154 : Retrieve <br>
	 * [EES_MNR_0154]Disposal Tariff by Region의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @deprecated 2010.09.15 현재 [CSR] CHM-201005770-01 Disposal Tariff by Region 기능변경 요청건에 의해 설계문서 현행화시 삭제요망.
	 * @see com.hanjin.apps.alps.ees.mnr.agreementmanage.AgreementManageSC#searchDisposalTariffRegionListService(Event e)
	 */
	private EventResponse searchDisposalTariffListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DisposalTariffGRPVO disposalTariffGRPVO = new DisposalTariffGRPVO();
		if(e.getEventName().equalsIgnoreCase("EesMnr0154Event")){
			EesMnr0154Event event = (EesMnr0154Event)e;
			disposalTariffGRPVO.setDisposalTariffINVO((event.getDisposalTariffINVO()));
		} else if(e.getEventName().equalsIgnoreCase("EesMnr0232Event")) {
			EesMnr0232Event event = (EesMnr0232Event)e;
			disposalTariffGRPVO.setDisposalTariffINVO((event.getDisposalTariffINVO()));
		}
		TariffMgtBC command = new TariffMgtBCImpl();
		try{
			disposalTariffGRPVO = command.searchDisposalTariffBasic(disposalTariffGRPVO,account);
			//단건조회(Header)
			eventResponse.setRsVoList(disposalTariffGRPVO.getCustomMnrDispTrfHdrVOs());
			//다중조회(Detail)
			eventResponse.setRsVoList(disposalTariffGRPVO.getCustomMnrDispTrfDtlVOs());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0232 : Retrieve <br>
	 * [EES_MNR_0232]Disposal Tariff by Region의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @deprecated 2010.09.30 현재 [CSR] CHM-201005733-01 Disposal Tariff Inquiry 기능변경 요청건에 의해 설계문서 현행화시 삭제요망.
	 * @see com.hanjin.apps.alps.ees.mnr.agreementmanage.AgreementManageSC#searchDisposalTariffQuarterListService(Event e)
	 */
	private EventResponse searchDisposalTariffInqueryListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DisposalTariffGRPVO disposalTariffGRPVO = new DisposalTariffGRPVO();
		EesMnr0232Event event = (EesMnr0232Event)e;
		disposalTariffGRPVO.setDisposalTariffINVO((event.getDisposalTariffINVO()));
		TariffMgtBC command = new TariffMgtBCImpl();
		try{
			disposalTariffGRPVO = command.searchDisposalTariffInqueryListBasic(disposalTariffGRPVO,account);

			if(disposalTariffGRPVO.getCustomMnrDispTrfInQueryVOs().size() > 0){
				eventResponse.setETCData("title",disposalTariffGRPVO.getCustomMnrDispTrfInQueryVOs().get(0).getTitle());
				disposalTariffGRPVO.getCustomMnrDispTrfInQueryVOs().remove(0);
			}
			eventResponse.setRsVoList(disposalTariffGRPVO.getCustomMnrDispTrfInQueryVOs());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0154 : Retrieve <br>
	 * [EES_MNR_0154]Disposal Tariff by Region의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @deprecated 2010.09.15 현재 [CSR] CHM-201005770-01 Disposal Tariff by Region 기능변경 요청건에 의해 설계문서 현행화시 삭제요망.
	 */
	private EventResponse searchDisposalTariffEffDtListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DisposalTariffEffDtGRPVO disposalTariffEffDtGRPVO = new DisposalTariffEffDtGRPVO();

		EesMnr0154Event event = (EesMnr0154Event)e;
		disposalTariffEffDtGRPVO.setDisposalTariffEffDtINVO((event.getDisposalTariffEffDtINVO()));

		TariffMgtBC command = new TariffMgtBCImpl();
		try{
			disposalTariffEffDtGRPVO = command.searchDisposalTariffEffDtListBasic(disposalTariffEffDtGRPVO,account);
			//단건조회(Header)
			eventResponse.setRsVoList(disposalTariffEffDtGRPVO.getDisposalTariffEffDtListVOs());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0232 : Effective FM History Retrieve <br>
	 * [EES_MNR_0232]Disposal Tariff Header 조회 <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @deprecated 2010.09.30 현재 [CSR] CHM-201005733-01 Disposal Tariff Inquiry 기능변경 요청건에 의해 설계문서 현행화시 삭제요망.
	 */
	private EventResponse searchDisposalTariffInqueryEffDtListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DisposalTariffEffDtGRPVO disposalTariffEffDtGRPVO = new DisposalTariffEffDtGRPVO();

		EesMnr0232Event event = (EesMnr0232Event)e;
		disposalTariffEffDtGRPVO.setDisposalTariffEffDtINVO((event.getDisposalTariffEffDtINVO()));

		TariffMgtBC command = new TariffMgtBCImpl();
		try{
			disposalTariffEffDtGRPVO = command.searchDisposalTariffInqueryEffDtListBasic(disposalTariffEffDtGRPVO,account);
			//단건조회(Header)
			eventResponse.setRsVoList(disposalTariffEffDtGRPVO.getDisposalTariffEffDtListVOs());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0154 : Save <br>
	 * [EES_MNR_0154]Disposal Tariff by Region의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @deprecated 2010.09.15 현재 [CSR] CHM-201005770-01 Disposal Tariff by Region 기능변경 요청건에 의해 설계문서 현행화시 삭제요망.
	 * @see com.hanjin.apps.alps.ees.mnr.agreementmanage.AgreementManageSC#manageDisposalTariffRegionListService(Event e)
	 */
	private EventResponse manageDisposalTariffService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0154Event event = (EesMnr0154Event)e;
		TariffMgtBC command = new TariffMgtBCImpl();

		try{
			begin();

			DisposalTariffGRPVO disposalTariffGRPVO = new DisposalTariffGRPVO();
			disposalTariffGRPVO.setDisposalTariffINVO(event.getDisposalTariffINVO());
			disposalTariffGRPVO.setCustomMnrDispTrfHdrVO(event.getCustomMnrDispTrfHdrVO());
			disposalTariffGRPVO.setArrayCustomMnrDispTrfDtlVOs(event.getArrayCustomMnrDispTrfDtlVOs());
			disposalTariffGRPVO = command.manageDisposalTariffBasic(disposalTariffGRPVO,account);
			//Tariff No return
			//eventResponse.setRsVo(disposalTariffGRPVO.getCustomMnrDispTrfHdrVO());
			eventResponse.setRsVoList(disposalTariffGRPVO.getCustomMnrDispTrfHdrVOs());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0190 : Verify <br>
	 * [EES_MNR_0190]Local Tariff File Import_Pop Up의 정보를 작업 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyRepairTariffService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0190Event event = (EesMnr0190Event)e;

		GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO = new GeneralCodeCheckMgtGRPVO();
		generalCodeCheckMgtGRPVO.setCustomMnrDatVrfyVOS(event.getCustomMnrDatVrfyVOs());
		GeneralCodeCheckMgtBC command  = new GeneralCodeCheckMgtBCImpl();

		VerifyTariffFileListGRPVO verifyTariffFileListGRPVO = new VerifyTariffFileListGRPVO();
		verifyTariffFileListGRPVO.setVerifyTariffFileListINVO(event.getVerifyTariffFileListINVO());

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			begin();

			//공통함수를 이용 임시테이블에 입력하고, 시퀀스를 얻어온다.
			String seqValue = command.createMnrTempBasic(generalCodeCheckMgtGRPVO,account);

			//Validation Check를 위한 업데이트문을 실행하고, 조회하여 수정된 값들을 얻어온다.
			verifyTariffFileListGRPVO.getVerifyTariffFileListINVO().setTmpSeq(seqValue);  				//set tmp_seq
			String programId = verifyTariffFileListGRPVO.getVerifyTariffFileListINVO().getProgramId();
			//ees_mnr_0011 : Local Tariff
			if(programId.equals("ees_mnr_0011")) {
				verifyTariffFileListGRPVO = command.verifyLocalTariffFileListBasic(verifyTariffFileListGRPVO);	//update and search
			//ees_mnr_0014 : Standard Tariff
			} else {
				verifyTariffFileListGRPVO = command.verifyTariffFileListBasic(verifyTariffFileListGRPVO);	//update and search
			}

			commit();

			//set return to event
			eventResponse.setRsVoList(verifyTariffFileListGRPVO.getCustomMnrDatVrfyVOS());

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0226 : New <br>
	 * [EES_MNR_0226]W/O Creation의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgreementComboListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0015Event event = (EesMnr0015Event)e;
		RateMgtBC command = new RateMgtBCImpl();

		try{
			AgreementGRPVO agreementGRPVO = command.searchAgreementComboListBasic(event.getAgreementGRPVO());
			eventResponse.setRsVoList(agreementGRPVO.getCustomMnrAgmtHdrVOS());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0011 : searchDefault <br>
	 * [EES_MNR_0011]M&R Local Tariff Creation & Verify의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDefaultRepairTariffDetailService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RepairTariffMgtGRPVO repairTariffMgtGRPVO = new RepairTariffMgtGRPVO();

		if(e.getEventName().equalsIgnoreCase("EesMnr0011Event")){
			EesMnr0011Event event = (EesMnr0011Event)e;
			repairTariffMgtGRPVO.setRepairTariffMgtINVO((event.getRepairTariffMgtINVO()));
		} else if(e.getEventName().equalsIgnoreCase("EesMnrS011Event")) {
			EesMnrS011Event event = (EesMnrS011Event)e;
			repairTariffMgtGRPVO.setRepairTariffMgtINVO((event.getRepairTariffMgtINVO()));
		}

		TariffMgtBC command = new TariffMgtBCImpl();

		try{
			repairTariffMgtGRPVO = command.searchDefaultRepairTariffDetailBasic(repairTariffMgtGRPVO,account);
			//다중조회(Detail)
			for (int i = 0; i < repairTariffMgtGRPVO.getListCustomMnrRprTrfDtlVOs().size(); i++) {
				eventResponse.setRsVoList(repairTariffMgtGRPVO.getListCustomMnrRprTrfDtlVOs().get(i));
			}

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0171 : Retrieve <br>
	 * [EES_MNR_0171]M&R Tariff Inquiry의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRepairTariffApprovalListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		TariffApprovalGRPVO tariffApprovalGRPVO = new TariffApprovalGRPVO();
		if(e.getEventName().equalsIgnoreCase("EesMnr0136Event")){
			EesMnr0136Event event = (EesMnr0136Event)e;
			tariffApprovalGRPVO.setTariffApprovalINVO(event.getTariffApprovalINVO());
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0171Event")) {
			EesMnr0171Event event = (EesMnr0171Event)e;
			tariffApprovalGRPVO.setTariffApprovalINVO(event.getTariffApprovalINVO());
		} else if (e.getEventName().equalsIgnoreCase("EesMnrS171Event")) {
			EesMnrS171Event event = (EesMnrS171Event)e;
			tariffApprovalGRPVO.setTariffApprovalINVO(event.getTariffApprovalINVO());
		}
		TariffMgtBC command = new TariffMgtBCImpl();

		try{
			tariffApprovalGRPVO = command.searchRepairTariffApprovalListBasic(tariffApprovalGRPVO,account);
			eventResponse.setRsVoList(tariffApprovalGRPVO.getListCustomTariffApprovalVO());

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0136 : Delete <br>
	 * [EES_MNR_0136]M&R Regional Tariff Approval의 정보를 수정 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyRepairTariffStatusService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0136Event event = (EesMnr0136Event)e;
		TariffMgtBC command = new TariffMgtBCImpl();

		try{
			begin();

			TariffApprovalGRPVO tariffApprovalGRPVO = new TariffApprovalGRPVO();
			tariffApprovalGRPVO.setArrayCustomTariffApprovalVOs((event.getArrayCustomTariffApprovalVOs()));
			command.modifyRepairTariffStatusBasic(tariffApprovalGRPVO,account);

			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0154 : Retrieve <br>
	 * [EES_MNR_0154] 분기별 매각기준 가격정보 현황을 조회합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDisposalTariffRegionListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			EesMnr0154Event event = (EesMnr0154Event)e;
			TariffMgtBC command = new TariffMgtBCImpl();
			List<DisposalTariffRegionVO> list = command.searchDisposalTariffRegionListBasic(event.getDisposalTariffRegionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0154 : Save <br>
	 * [EES_MNR_0154] 분기별 매각기준 가격정보 일괄 저장(추가/수정/삭제) 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDisposalTariffRegionListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0154Event event = (EesMnr0154Event)e;
		TariffMgtBC command = new TariffMgtBCImpl();

		try{
			begin();
			command.manageDisposalTariffRegionListBasic(event.getDisposalTariffRegionVOs(), account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0154 : Save - BackEndJob<br>
	 * [EES_MNR_0154] 분기별 매각기준 가격정보 일괄 저장(추가/수정/삭제) 합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse backEndDisposalTariffRegionListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesMnr0154Event event = (EesMnr0154Event)e;
			TariffMgtBC command = new TariffMgtBCImpl();
			String status = command.backEndDisposalTariffRegionListBasic(event.getDisposalTariffRegionVOs(), account);
			eventResponse.setETCData("BackEndJobKey", status);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0154 : BackEndJob<br>
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
			TariffMgtBC command = new TariffMgtBCImpl();
			String key = (String)e.getAttribute("KEY");

			String status = command.searchComBackEndJobStatusBasic(key);
			eventResponse.setETCData("jb_sts_flg", status);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0232 : Retrieve <br>
	 * [EES_MNR_0232]분기별 지역별 매각기준 가격정보 현황을 조회합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDisposalTariffQuarterListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			EesMnr0232Event event = (EesMnr0232Event)e;
			TariffMgtBC command = new TariffMgtBCImpl();
			DisposalTariffQuarterGRPVO resultVO = command.searchDisposalTariffQuarterListBasic(event.getDisposalTariffQuarterVO());
			List<List<DisposalTariffQuarterVO>> lists = resultVO.getDisposalTariffQuarterVOs();

			eventResponse.setRsVoList(lists.get(0));
			eventResponse.setRsVoList(lists.get(1));
			eventResponse.setRsVoList(lists.get(2));
			eventResponse.setRsVoList(lists.get(3));
			eventResponse.setRsVoList(lists.get(4));
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_MNR_0017 : Retrieve <br>
	 * [EES_MNR_0018] M&R Agreement Attach List의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgreementAttachInfoListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0017Event event = (EesMnr0017Event)e;
		RateMgtBC command = new RateMgtBCImpl();

		try{
			List<AgmtAtchDataVO> list = command.searchAgreementAttachInfoListBasic(event.getAgmtAtchDataVO());

			eventResponse.setRsVoList(list);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_MNR_0017 : Save <br>
	 * [EES_MNR_0018] M&R Agreement Attach List의 정보를 저장 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAgreementAttachInfoService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0017Event event = (EesMnr0017Event)e;
		RateMgtBC command = new RateMgtBCImpl();
		int insCnt = 0;

		try{
			begin();
			
			insCnt = command.manageAgreementAttachInfoBasic(event.getAgmtAtchDataVOS(), event.getAgmtAtchDataVO(), account);
			
			commit();
			
			eventResponse.setETCData("ins_cnt", Integer.toString(insCnt));
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
}