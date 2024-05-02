/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerLeaseAgreementRegistrationSC.java
*@FileTitle : Lease Agreement Creation & Update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.05.22 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration;

import java.util.List;

import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.basic.AgreementRegistrationBC;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.basic.AgreementRegistrationBCImpl;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.event.EesLse0001Event;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.event.EesLse0002Event;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.event.EesLse0004Event;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.event.EesLse0091Event;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.event.EesLse0095Event;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.event.EesLse0096Event;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.event.EesLse0102Event;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.integration.AgreementRegistrationDBDAO;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementListVO;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementRegistrationVO;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementVO;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.InInterrstServiceVO;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.InterrstServiceVO;
import com.hanjin.apps.alps.ees.lse.lsecommon.cntrtpsz.basic.ContainerTypeSizeBC;
import com.hanjin.apps.alps.ees.lse.lsecommon.cntrtpsz.basic.ContainerTypeSizeBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MdmCntrTpSzVO;


/**
 * NIS2010-ContainerLeaseAgreementRegistration Business Logic ServiceCommand - NIS2010-ContainerLeaseAgreementRegistration 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Nho Jung Yong
 * @see AgreementRegistrationDBDAO
 * @since J2EE 1.6
 */

public class ContainerLeaseAgreementRegistrationSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ContainerLeaseAgreementRegistration system 업무 시나리오 선행작업<br>
	 * EES_LSE_0001업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	@Override
	public void doStart() {
		log.debug("ContainerLeaseAgreementRegistrationSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * ContainerLeaseAgreementRegistration system 업무 시나리오 마감작업<br>
	 * EES_LSE_0001 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	@Override
	public void doEnd() {
		log.debug("ContainerLeaseAgreementRegistrationSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-ContainerLeaseAgreementRegistration system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param   Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		// 1. [UI:EES_LSE_0091] Agreement No. Selection Pop-up
		if ( e.getEventName().equalsIgnoreCase("EesLse0091Event") ) {
			if ( e.getFormCommand().isCommand(FormCommand.SEARCH) ) {
				//조회
				eventResponse = searchAgreementListBrieflyService(e);
			}
		} else if ( e.getEventName().equalsIgnoreCase("EesLse0001Event") ) {
			if ( e.getFormCommand().isCommand(FormCommand.SEARCH) ) {
				//조회(Master, Gerenal)
				eventResponse = searchAgreementService(e);
			} else if ( e.getFormCommand().isCommand(FormCommand.SEARCH01) ) {
				//조회(Penalty)
				eventResponse = searchAgreementDPPService(e);
			} else if ( e.getFormCommand().isCommand(FormCommand.ADD) ) {
				//입력
				eventResponse = createAgreementService(e);
			} else if ( e.getFormCommand().isCommand(FormCommand.MODIFY) ) {
				//수정
				eventResponse = modifyAgreementService(e);
			} else if ( e.getFormCommand().isCommand(FormCommand.COMMAND01) ) {
				//Vesrion Up
				eventResponse = createAgreementNewVersionService(e);
			} else if ( e.getFormCommand().isCommand(FormCommand.DEFAULT) ) {
				//화면오픈
				eventResponse = initPage(e);
			}
		} else if ( e.getEventName().equalsIgnoreCase("EesLse0002Event") ) {
			if ( e.getFormCommand().isCommand(FormCommand.SEARCH) ) {
				//조회
				eventResponse = searchAgreementVersionListService(e);
			}
		} else if ( e.getEventName().equalsIgnoreCase("EesLse0096Event") ) {
			if ( e.getFormCommand().isCommand(FormCommand.DEFAULT) ) {
				//조회
				eventResponse = searchAgreementLastVersionService(e);
			}
		} else if ( e.getEventName().equalsIgnoreCase("EesLse0004Event") ) {
			if ( e.getFormCommand().isCommand(FormCommand.SEARCH) ) {
				//조회
				eventResponse = searchAgreementListService(e);
			} else if ( e.getFormCommand().isCommand(FormCommand.SEARCH01) ) {
				//조회
				eventResponse = searchAgreementListPerDiemService(e);
			} else if ( e.getFormCommand().isCommand(FormCommand.DEFAULT) ) {
				//화면오픈
				eventResponse = initPage(e);
			}
		} else if ( e.getEventName().equalsIgnoreCase("EesLse0095Event") ) {
			if ( e.getFormCommand().isCommand(FormCommand.SEARCH) ) {
				//조회(Master, Gerenal)
				eventResponse = searchAgreementService(e);
			} else if ( e.getFormCommand().isCommand(FormCommand.DEFAULT) ) {
				//화면오픈
				eventResponse = initPage(e);
			}
		} else if ( e.getEventName().equalsIgnoreCase("EesLse0102Event") ) {
			if ( e.getFormCommand().isCommand(FormCommand.SEARCH) ) {
				//조회 (calculation)
				eventResponse = calculationInterrstService(e);	
			} 
		}
		
		return eventResponse;
	}

	/**
	 * 각 페이지 초기 Loading 시 처리 <br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse initPage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if ( e.getEventName().equalsIgnoreCase("EesLse0001Event")
			  || e.getEventName().equalsIgnoreCase("EesLse0004Event")
			  || e.getEventName().equalsIgnoreCase("EesLse0095Event") ) {
				ContainerTypeSizeBC command = new ContainerTypeSizeBCImpl();
				List<MdmCntrTpSzVO> cntrTpSzlist = command.searchCntrTpSzListBasic();
				
				StringBuffer sCntrTpSzCd = new StringBuffer();
	
				for ( int i = 0 ; i < cntrTpSzlist.size() ; i++ ) {
					if ( sCntrTpSzCd.toString().equals("") ) {
						sCntrTpSzCd.append(cntrTpSzlist.get(i).getCntrTpszCd());
					} else {
						sCntrTpSzCd.append("|").append(cntrTpSzlist.get(i).getCntrTpszCd());
					}
				}
	
				eventResponse.setCustomData("cntr_tpsz_cd", sCntrTpSzCd.toString());
			}
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
	 * EES_LSE_0091 : Retrieve <br>
	 * Lease Agreement List 조회<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgreementListBrieflyService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0091Event event = (EesLse0091Event)e;
			AgreementRegistrationBC command = new AgreementRegistrationBCImpl();
			List<AgreementVO> list = command.searchAgreementListBrieflyBasic(event.getAgreementVO());
			eventResponse.setRsVoList(list);
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
	 * EES_LSE_0001 : Retrieve <br>
	 * EES_LSE_0095 : Retrieve <br>
	 * Lease Agreement Master Data 및 General Data 조회 <br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgreementService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			AgreementRegistrationBC command = new AgreementRegistrationBCImpl();
	
			AgreementRegistrationVO searchVO  = null;
			AgreementRegistrationVO returnVO1 = null; // Master Data
			AgreementRegistrationVO returnVO2 = null; // General Data
			AgreementRegistrationVO returnVO3 = null; // Per-Diem Data
			AgreementRegistrationVO returnVO4 = null; // Lift Charge Data
			AgreementRegistrationVO returnVO5 = null; // DOL/DOC Data
			AgreementRegistrationVO returnVO6 = null; // Drop Office Description Data
			AgreementRegistrationVO returnVO7 = null; // Penalty Data
			AgreementRegistrationVO returnVO8 = null; // DPP Data
			AgreementRegistrationVO returnVO9 = null; // Pic Data
			
	
			if ( e.getEventName().equalsIgnoreCase("EesLse0001Event") ) {
				EesLse0001Event event = (EesLse0001Event)e;
				searchVO = event.getAgreementRegistrationVO();
			} else if ( e.getEventName().equalsIgnoreCase("EesLse0095Event") ) {
				EesLse0095Event event = (EesLse0095Event)e;
				searchVO = event.getAgreementRegistrationVO();
			}
	
			returnVO1 = command.searchAgreementBasic(searchVO);
			returnVO2 = command.searchAgreementGeneralBasic(searchVO);
			returnVO3 = command.searchAgreementPerDiemBasic(searchVO);
			returnVO4 = command.searchAgreementLiftChargeBasic(searchVO);
			returnVO5 = command.searchAgreementDolDocBasic(searchVO);
			returnVO6 = command.searchAgreementDropOfficeDescBasic(searchVO);
			returnVO7 = command.searchAgreementPenaltyBasic(searchVO);
			returnVO8 = command.searchAgreementDppBasic(searchVO);
			returnVO9 = command.searchAgreementPicBasic(searchVO);
	
			// Lease Agreement Master Data
			eventResponse.setETCData(((returnVO1.getAgreementVOs().get(0))).getColumnValues());
	
			// Lease Agreement General Data
			eventResponse.setRsVoList(returnVO2.getAgreementGeneralListVOs());
	
			// Lease Agreement Per-diem Data
			eventResponse.setRsVoList(returnVO3.getAgreementRatesVOs());
	
			// Lease Agreement Lifting Charges Data
			eventResponse.setRsVoList(returnVO4.getAgreementRatesVOs());
	
			// Lease Agreement DOL/DOC Data
			eventResponse.setRsVoList(returnVO5.getAgreementRatesVOs());
	
			// Lease Agreement Drop Office Description Data
			eventResponse.setRsVoList(returnVO6.getAgreementDropOfficeDescVOs());
	
			// Lease Agreement Penalty Data
			eventResponse.setRsVoList(returnVO7.getAgreementRatesVOs());
	
			// Lease Agreement DPP Data
			eventResponse.setRsVoList(returnVO8.getAgreementDppRateVOs());

			// Lease Agreement AGMT Attach Data
			eventResponse.setRsVoList(returnVO9.getAgreementFileUploadVOs());
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
	 * EES_LSE_0001 : DPP Coverage Click <br>
	 * Lease Agreement DPP Data 조회 <br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgreementDPPService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			AgreementRegistrationBC command = new AgreementRegistrationBCImpl();
	
			AgreementRegistrationVO searchVO = null;
			AgreementRegistrationVO returnVO = null;
	
			if ( e.getEventName().equalsIgnoreCase("EesLse0001Event") ) {
				EesLse0001Event event = (EesLse0001Event)e;
				searchVO = event.getAgreementRegistrationVO();
			} else if ( e.getEventName().equalsIgnoreCase("EesLse0095Event") ) {
				EesLse0095Event event = (EesLse0095Event)e;
				searchVO = event.getAgreementRegistrationVO();
			}
	
			returnVO  = command.searchAgreementDppBasic(searchVO);
	
			// Lease Agreement DPP Data
			eventResponse.setRsVoList(returnVO.getAgreementDppRateVOs());
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
	 * EES_LSE_0001 : Save <br>
	 * Lease Agreement Master 및 Tab Data 신규 저장 <br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createAgreementService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0001Event event = (EesLse0001Event)e;
		AgreementRegistrationBC command = new AgreementRegistrationBCImpl();
		String strNewAgmtSeq = "";
		try{
			begin();
			strNewAgmtSeq = command.createAgreementBasic(event.getAgreementRegistrationVO(),account);
			eventResponse.setETCData("agmt_seq", strNewAgmtSeq);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0001 : Save <br>
	 * Lease Agreement Master 및 Tab Data 수정 저장<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyAgreementService(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0001Event event = (EesLse0001Event)e;
		AgreementRegistrationBC command = new AgreementRegistrationBCImpl();
		try{
			begin();
			command.modifyAgreementBasic(event.getAgreementRegistrationVO(),account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0001 : Version Up <br>
	 * Lease Agreement Version Up 처리 <br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createAgreementNewVersionService(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0001Event event = (EesLse0001Event)e;
		AgreementRegistrationBC command = new AgreementRegistrationBCImpl();
		String strNewAgmtVerSeq = "";
		try{
			begin();
			strNewAgmtVerSeq = command.createAgreementNewVersionBasic(event.getAgreementRegistrationVO(),account);
			eventResponse.setETCData("agmt_ver_seq", strNewAgmtVerSeq);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0002 : Retrieve <br>
	 * Lease Agreement Version List 조회 <br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgreementVersionListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0002Event event = (EesLse0002Event)e;
			AgreementRegistrationBC command = new AgreementRegistrationBCImpl();
			List<AgreementVO> list = command.searchAgreementVersionListBasic(event.getAgreementVO());
	
			eventResponse.setRsVoList(list);
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
	 * EES_LSE_0096 : 화면 초기 Loadiong <br>
	 * Lease Agreement Last Version 정보 조회 <br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgreementLastVersionService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0096Event event = (EesLse0096Event)e;
			AgreementRegistrationBC command = new AgreementRegistrationBCImpl();
	
			AgreementRegistrationVO returnVO = command.searchAgreementBasic(event.getAgreementRegistrationVO());
			AgreementVO agmtVO = returnVO.getAgreementVOs().get(0);
	
			// Lease Agreement Master Data
			eventResponse.setCustomData("agmt_cty_cd", agmtVO.getAgmtCtyCd());
			eventResponse.setCustomData("agmt_seq", agmtVO.getAgmtSeq());
			eventResponse.setCustomData("agmt_ver_seq", agmtVO.getAgmtVerSeq());
			eventResponse.setCustomData("eff_dt", agmtVO.getEffDt());
			eventResponse.setCustomData("exp_dt", agmtVO.getExpDt());
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
	 * EES_LSE_0004 : Retrieve <br>
	 * Lease Agreement Term & Condition Lists 조회 <br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgreementListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0004Event event = (EesLse0004Event)e;
			AgreementRegistrationBC command = new AgreementRegistrationBCImpl();
			List<AgreementListVO> list = command.searchAgreementListBasic(event.getExpFromDt(), event.getExpToDt(), event.getVndrSeq(), event.getLstmCd(), event.getOrgCntrTpszCd(), event.getOfcCd());
			eventResponse.setRsVoList(list);
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
	 * EES_LSE_0004 : IBSheet 내 Agreement No. Double Click <br>
	 * Lease Agreement Term & Condition Lists 조회 <br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgreementListPerDiemService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0004Event event = (EesLse0004Event)e;
			AgreementRegistrationBC command = new AgreementRegistrationBCImpl();
			StringBuffer sbGeneralCntrTpszCds = new StringBuffer();
			AgreementRegistrationVO returnVO = command.searchAgreementPerDiemBasic(event.getAgreementRegistrationVO());
			AgreementRegistrationVO returnVO2 = command.searchAgreementGeneralBasic(event.getAgreementRegistrationVO());
	
			if ( returnVO2.getAgreementGeneralListVOs().size() > 0 ) {
				for ( int i = 0 ; i < returnVO2.getAgreementGeneralListVOs().size() ; i++ ) {
					if ( sbGeneralCntrTpszCds.toString().equals("") ) {
						sbGeneralCntrTpszCds.append(returnVO2.getAgreementGeneralListVOs().get(i).getCntrTpszCd());
					} else {
						sbGeneralCntrTpszCds.append("|").append(returnVO2.getAgreementGeneralListVOs().get(i).getCntrTpszCd());
					}
				}
			}
	
			if ( !sbGeneralCntrTpszCds.toString().equals("") ) {
				// General 로 등록된 Container Type/Size Code의 문자열을 ETC Data 로 Setting : IBSheet 컬럼 Show/Hidden 에 사용함.
				eventResponse.setETCData("general_cntr_tysz_cd", sbGeneralCntrTpszCds.toString());
				// Lease Agreement Per-diem Data
				eventResponse.setRsVoList(returnVO.getAgreementRatesVOs());
			} else {
				//eventResponse.setUserMessage(new ErrorHandler("LSE01048").getMessage());
				throw new EventException(new ErrorHandler("LSE01048").getMessage());
			}
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
	 * EES_LSE_0102 : caculation Click <br>
	 * Interest calculation 조회 <br>
	 * 	
	 * @param  Event e
	 * @return EventResponse	
	 * @exception EventException	
	 */
	private EventResponse calculationInterrstService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			AgreementRegistrationBC command = new AgreementRegistrationBCImpl();
			InInterrstServiceVO inInterrstServiceVO = null; 
			List<InterrstServiceVO> interrstServiceVOS = null;
			
			EesLse0102Event event = (EesLse0102Event)e;	
			inInterrstServiceVO = event.getInInterrstServiceVO();	
			
			interrstServiceVOS  = command.calculationInterrstBasic(inInterrstServiceVO);
			
			//Interest calculation Data
			eventResponse.setRsVoList(interrstServiceVOS);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		
		return eventResponse;
	}
}