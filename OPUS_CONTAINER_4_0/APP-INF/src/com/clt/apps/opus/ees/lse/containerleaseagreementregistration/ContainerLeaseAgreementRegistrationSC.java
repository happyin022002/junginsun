/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerLeaseAgreementRegistrationSC.java
*@FileTitle : Lease Agreement Creation & Update
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleaseagreementregistration;

import java.util.List;

import com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.basic.AgreementRegistrationBC;
import com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.basic.AgreementRegistrationBCImpl;
import com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.event.EesLse0001Event;
import com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.event.EesLse0002Event;
import com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.event.EesLse0004Event;
import com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.event.EesLse0091Event;
import com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.event.EesLse0095Event;
import com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.event.EesLse0096Event;
import com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.integration.AgreementRegistrationDBDAO;
import com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementListVO;
import com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementRegistrationVO;
import com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementVO;
import com.clt.apps.opus.ees.lse.lsecommon.cntrtpsz.basic.ContainerTypeSizeBC;
import com.clt.apps.opus.ees.lse.lsecommon.cntrtpsz.basic.ContainerTypeSizeBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmCntrTpSzVO;


/**
 * ContainerLeaseAgreementRegistration Business Logic ServiceCommand - Handling Business Transaction of ContainerLeaseAgreementRegistration 
 * 
 * @author 
 * @see AgreementRegistrationDBDAO
 * @since J2EE 1.6
 */

public class ContainerLeaseAgreementRegistrationSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ContainerLeaseAgreementRegistration system preceding process for biz scenario<br>
	 * EES_LSE_0001 related objects creation<br>
	 */
	@Override
	public void doStart() {
		log.debug("ContainerLeaseAgreementRegistrationSC 시작");
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * ContainerLeaseAgreementRegistration system biz scenario closing<br>
	 * EES_LSE_0001 clearing related objects<br>
	 */
	@Override
	public void doEnd() {
		log.debug("ContainerLeaseAgreementRegistrationSC 종료");
	}

	/**
	 * Performing Biz Scenario corresponding to each Event<br>
	 * Branch Processing for all Events of ContainerLeaseAgreementRegistration system <br>
	 * 
	 * @param   Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// using in case SC handles several events
		// 1. [UI:EES_LSE_0091] Agreement No. Selection Pop-up
		if ( e.getEventName().equalsIgnoreCase("EesLse0091Event") ) {
			if ( e.getFormCommand().isCommand(FormCommand.SEARCH) ) {
				//Searching
				eventResponse = searchAgreementListBrieflyService(e);
			}
		} else if ( e.getEventName().equalsIgnoreCase("EesLse0001Event") ) {
			if ( e.getFormCommand().isCommand(FormCommand.SEARCH) ) {
				//Searching(Master, Gerenal)
				eventResponse = searchAgreementService(e);
			} else if ( e.getFormCommand().isCommand(FormCommand.SEARCH01) ) {
				//Searching(Penalty)
				eventResponse = searchAgreementDPPService(e);
			} else if ( e.getFormCommand().isCommand(FormCommand.ADD) ) {
				//Inserting
				eventResponse = createAgreementService(e);
			} else if ( e.getFormCommand().isCommand(FormCommand.MODIFY) ) {
				//Modifying
				eventResponse = modifyAgreementService(e);
			} else if ( e.getFormCommand().isCommand(FormCommand.COMMAND01) ) {
				//Vesrion Up
				eventResponse = createAgreementNewVersionService(e);
			} else if ( e.getFormCommand().isCommand(FormCommand.DEFAULT) ) {
				//Screen Open
				eventResponse = initPage(e);
			}
		} else if ( e.getEventName().equalsIgnoreCase("EesLse0002Event") ) {
			if ( e.getFormCommand().isCommand(FormCommand.SEARCH) ) {
				//Search
				eventResponse = searchAgreementVersionListService(e);
			}
		} else if ( e.getEventName().equalsIgnoreCase("EesLse0096Event") ) {
			if ( e.getFormCommand().isCommand(FormCommand.DEFAULT) ) {
				//Search
				eventResponse = searchAgreementLastVersionService(e);
			}
		} else if ( e.getEventName().equalsIgnoreCase("EesLse0004Event") ) {
			if ( e.getFormCommand().isCommand(FormCommand.SEARCH) ) {
				//Search
				eventResponse = searchAgreementListService(e);
			} else if ( e.getFormCommand().isCommand(FormCommand.SEARCH01) ) {
				//Search
				eventResponse = searchAgreementListPerDiemService(e);
			} else if ( e.getFormCommand().isCommand(FormCommand.DEFAULT) ) {
				//Screen Open
				eventResponse = initPage(e);
			}
		} else if ( e.getEventName().equalsIgnoreCase("EesLse0095Event") ) {
			if ( e.getFormCommand().isCommand(FormCommand.SEARCH) ) {
				//Search(Master, Gerenal)
				eventResponse = searchAgreementService(e);
			} else if ( e.getFormCommand().isCommand(FormCommand.DEFAULT) ) {
				//Screen Open
				eventResponse = initPage(e);
			}
		}
		
		return eventResponse;
	}

	/**
	 * Handling each page is initially loading <br>
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
	 * Retrieving Lease Agreement List <br>
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
	 * Retrieving Lease Agreement Master Data 및 General Data <br>
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
			
	
			if ( e.getEventName().equalsIgnoreCase("EesLse0001Event") ) {
				EesLse0001Event event = (EesLse0001Event)e;
				searchVO = event.getAgreementRegistrationVO();
			} else if ( e.getEventName().equalsIgnoreCase("EesLse0095Event") ) {
				EesLse0095Event event = (EesLse0095Event)e;
				searchVO = event.getAgreementRegistrationVO();
			}
	
			if(searchVO != null) {
				returnVO1 = command.searchAgreementBasic(searchVO);
				returnVO2 = command.searchAgreementGeneralBasic(searchVO);
				returnVO3 = command.searchAgreementPerDiemBasic(searchVO);
				returnVO4 = command.searchAgreementLiftChargeBasic(searchVO);
				returnVO5 = command.searchAgreementDolDocBasic(searchVO);
				returnVO6 = command.searchAgreementDropOfficeDescBasic(searchVO);
				returnVO7 = command.searchAgreementPenaltyBasic(searchVO);
				returnVO8 = command.searchAgreementDppBasic(searchVO);
			}	
	
			// Lease Agreement Master Data
			if(returnVO1 != null) {
				eventResponse.setETCData(((returnVO1.getAgreementVOs().get(0))).getColumnValues());
			}
	
			// Lease Agreement General Data
			if(returnVO2 != null) {
				eventResponse.setRsVoList(returnVO2.getAgreementGeneralListVOs());
			}
	
			// Lease Agreement Per-diem Data
			if(returnVO3 != null) {
				eventResponse.setRsVoList(returnVO3.getAgreementRatesVOs());
			}
			
			// Lease Agreement Lifting Charges Data
			if(returnVO4 != null) {
				eventResponse.setRsVoList(returnVO4.getAgreementRatesVOs());
			}
	
			// Lease Agreement DOL/DOC Data
			if(returnVO5 != null) {
				eventResponse.setRsVoList(returnVO5.getAgreementRatesVOs());
			}
	
			// Lease Agreement Drop Office Description Data
			if(returnVO6 != null) {
				eventResponse.setRsVoList(returnVO6.getAgreementDropOfficeDescVOs());
			}
	
			// Lease Agreement Penalty Data
			if(returnVO7 != null) {
				eventResponse.setRsVoList(returnVO7.getAgreementRatesVOs());
			}
	
			// Lease Agreement DPP Data
			if(returnVO8 != null) {
				eventResponse.setRsVoList(returnVO8.getAgreementDppRateVOs());
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
	 * EES_LSE_0001 : DPP Coverage Click <br>
	 * Retrieving Lease Agreement DPP Data <br>
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
			
			if(searchVO != null) {
				returnVO  = command.searchAgreementDppBasic(searchVO);
			}
	
			// Lease Agreement DPP Data
			if(returnVO != null) {
				eventResponse.setRsVoList(returnVO.getAgreementDppRateVOs());
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
	 * EES_LSE_0001 : Save <br>
	 * New Saving Lease Agreement Master and Tab Data <br>
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
	 * Modifying and Saving Lease Agreement Master and Tab Data <br>
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
	 * Handling Lease Agreement Version Up <br>
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
	 * Retrieving Lease Agreement Version List <br>
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
	 * EES_LSE_0096 : Screen initial Loadiong <br>
	 * Retrieving Lease Agreement Last Version information<br>
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
	 * Retrieving Lease Agreement Term & Condition Lists <br>
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
			List<AgreementListVO> list = command.searchAgreementListBasic(event.getExpFromDt(), event.getExpToDt(), event.getVndrSeq(), event.getLstmCd(), event.getOrgCntrTpszCd(), event.getOfcCd(), event.getAllLstmCd(), event.getLsePayTpCd());
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
	 * EES_LSE_0004 : Agreement No. Double Click in IBSheet<br>
	 * Retrieving Lease Agreement Term & Condition Lists <br>
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
				// Using String of Container Type/Size registered in General as ETC Data to Setting : IBSheet Column Show/Hidden
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
}