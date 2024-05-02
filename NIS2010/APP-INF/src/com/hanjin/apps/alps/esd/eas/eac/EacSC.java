/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EacSC.java
*@FileTitle : Expense Audit case Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.29
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2014.10.29 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac;

import java.util.List;

import com.hanjin.apps.alps.esd.eas.eac.eacmgt.basic.EacMgtBC;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.basic.EacMgtBCImpl;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.basic.EacRegRptBC;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.basic.EacRegRptBCImpl;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.event.EsdEas0201Event;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.event.EsdEas0202Event;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.event.EsdEas0203Event;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.event.EsdEas0204Event;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.event.EsdEas0205Event;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.event.EsdEas0206Event;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.event.EsdEas0208Event;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.event.EsdEas0209Event;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.event.EsdEas0210Event;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.event.EsdEas0211Event;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.event.EsdEas0214Event;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.event.EsdEas0217Event;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.event.EsdEas0218Event;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.event.EsdEas0219Event;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.event.EsdEas0220Event;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.event.EsdEas0221Event;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.event.EsdEas0222Event;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.event.EsdEas0223Event;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.event.EsdEas0226Event;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration.EacMgtDBDAO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.AutoAuditFileVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACCdVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACCfmVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACEditVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACInqEacVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACInqVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACNtcHisVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACNtcVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACOfcCfgVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACPsonCfgVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACRgstVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACSpCtrtVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACTpbDtlVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EacFileInVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EacFileOutVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EacSearchVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.SearchOfcPerfVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.SearchOfcStatisticsVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.SearchRhqStatisticsVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.SearchSpPerfVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-Eac Business Logic ServiceCommand - ALPS-Eac 에 대한 비지니스 로직에 대한 인터페이스.
 * 
 * @author HI
 * @see EacMgtDBDAO
 * @since J2EE 1.6
 */

public class EacSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

    /**
     * Eac 업무 시나리오 선행작업<br>
     * Eac system 업무 시나리오 호출시 관련 내부객체 생성<br>
     */	
	public void doStart() {
		log.debug("EacSC 시작");
		try {

			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

    /**
     * Eac 업무 시나리오 마감작업<br>
     * Eac system  업무 시나리오 종료시 관련 내부객체 해제<br>
     */
	public void doEnd() {
		log.debug("EacSC 종료");
	}

	
	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-Eac system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		if (e.getEventName().equalsIgnoreCase("EsdEas0201Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchCombos(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchOfcLvl(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchRhqList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = searchOfcList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse = searchOfcLvlPls(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)) {
				eventResponse = verifyTpbOfc(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND06)) {
				eventResponse = verify3rdVale(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCommonCombo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchBilTpCd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCurrency(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchUsdXch(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchVendor(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = validLoc(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = chkResponsibleOffice(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchCntcPnt(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = verifyEacReg(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchEacReg(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = searchEacRjctNtc(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = verifyBkgNO(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = verifyTpbIf(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				eventResponse = searchPsonCfg(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				eventResponse = validYard(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiEacReg(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = multiEacTpbIf(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = modifyEacSts(e);
			}
			
		}else if (e.getEventName().equalsIgnoreCase("EsdEas0202Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchVndrList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchVndrCntc(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiVndrCntc(e);
			} 
			
		}else if (e.getEventName().equalsIgnoreCase("EsdEas0203Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEacOfc(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiEacOfc(e);
			} 
				
				
		}else if (e.getEventName().equalsIgnoreCase("EsdEas0204Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEacPsn(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiEacPsn(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = deleteEacPsn(e);
			}  
				
		}else if (e.getEventName().equalsIgnoreCase("EsdEas0205Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEacEditList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				eventResponse = searchEacAuditorList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdEas0206Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEacCfmList(e);
			} 
				
		}else if (e.getEventName().equalsIgnoreCase("EsdEas0208Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEacCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdEas0214Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEacPsnList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = deleteEacPsnList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiEacPsnList(e);
			}	
		}else if (e.getEventName().equalsIgnoreCase("EsdEas0209Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOfcStatistics(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdEas0217Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEacReadList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdEas0218Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRhqStatistics(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdEas0210Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOfcPerf(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdEas0211Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = saveEacNotice(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEacNotice(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdEas0219Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSpPerf(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdEas0220Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTpbIfDetail(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdEas0221Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRjctNtcSendHis(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdEas0222Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRjctNtcHis(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdEas0223Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEacFile(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageEacFile(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdEas0226Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAutoAudFile(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCurrency2(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchMonthExchange(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageAutoAudFile(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeAutoAudFileAll(e);
			}

		}
		return eventResponse;
	}


	/**
	 * 화면로딩시 조회 해야하는 콤보 값들을 한번에 조회 한다.<br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchCombos(Event e) throws EventException {
	    try{
	    	GeneralEventResponse eventResponse = new GeneralEventResponse();
	    	EsdEas0201Event event = (EsdEas0201Event)e;
	    	EacMgtBC command = new EacMgtBCImpl();
	    	EacSearchVO esvo = event.getEacSearchVO();
	    	
	    	// Expense Type
	    	esvo.setCodeKey("CD03352");	    	 
	    	eventResponse.setRsVoList(command.searchCommonCombo(esvo));
	    	
	    	// EAC Type
	    	esvo.setCodeKey("CD00587");	    	 
	    	eventResponse.setRsVoList(command.searchCommonCombo(esvo));
	    	
	    	// Action Type
	    	esvo.setCodeKey("CD03338");	    	 
	    	eventResponse.setRsVoList(command.searchCommonCombo(esvo));
	    	
	    	// Completion
	    	esvo.setCodeKey("CD03342");	    	 
	    	eventResponse.setRsVoList(command.searchCommonCombo(esvo));
	    	
	    	// 3RD Party
	    	esvo.setCodeKey("CD00583");	    	 
	    	eventResponse.setRsVoList(command.searchCommonCombo(esvo));
	    	
	    	// Currency
	    	eventResponse.setRsVoList(command.searchCurrency(esvo));
	    	
	    	// TPB Grid - EQ Kind
	    	esvo.setCodeKey("CD01132");	    	 
	    	eventResponse.setRsVoList(command.searchCommonCombo(esvo));
	    	
	    	// TPB Exp.Type 
	    	esvo.setCodeKey("CD00904");	    	 
	    	eventResponse.setRsVoList(command.searchCommonCombo(esvo));
	    	
	    	// EAC Status
	    	eventResponse.setRsVoList(command.SearchEacStatus(esvo));
	    	
    		return eventResponse;
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"searchCommonCombo"}).getMessage(), ex);
        }
	}	
	
	/**
	 * 공통 테이블에 담긴 값을 조회한다.<br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchCommonCombo(Event e) throws EventException {
		try{
			EsdEas0201Event event = (EsdEas0201Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EacSearchVO> list = command.searchCommonCombo(event.getEacSearchVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchCommonCombo"}).getMessage(), ex);
		}
	}	
	
	/**
	 * EsdEas0201  <br>
	 * EAC Type 명을 조회한다 <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchBilTpCd(Event e) throws EventException {
		try{
			EsdEas0201Event event = (EsdEas0201Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EacSearchVO> list = command.searchBilTpCd(event.getEacSearchVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchBilTpCd"}).getMessage(), ex);
		}
	}	
	
	/**
	 * EsdEas0201  <br>
	 * 로그한 유저의 ofc 레벨을 조회한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOfcLvl(Event e) throws EventException {
		try{
			EsdEas0201Event event = (EsdEas0201Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EacSearchVO> list = command.searchOfcLvl(event.getEacSearchVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchOfcLvl"}).getMessage(), ex);
		}
	}	
	/**
	 * EsdEas0201  <br>
	 * 로그한 유저의 ofc 레벨과 초기필요값을 조회한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOfcLvlPls(Event e) throws EventException {
		try{
			EsdEas0201Event event = (EsdEas0201Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EacSearchVO> list = command.searchOfcLvlPls(event.getEacSearchVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchOfcLvlPls"}).getMessage(), ex);
		}
	}	
	/**
	 * EsdEas0201  <br>
	 * S/P Code 의 명칭을 조회한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchVendor(Event e) throws EventException {
		try{
			EsdEas0201Event event = (EsdEas0201Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EacSearchVO> list = command.searchVendor(event.getEacSearchVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchVendor"}).getMessage(), ex);
		}
	}	
	
	/**
	 * EsdEas0201  <br>
	 * Responsible Office 에 값이 존재하는지 체크 한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse chkResponsibleOffice(Event e) throws EventException {
		try{
			EsdEas0201Event event = (EsdEas0201Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EacSearchVO> list = command.chkResponsibleOffice(event.getEacSearchVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"chkResponsibleOffice"}).getMessage(), ex);
		}
	}	
	
	/**
	 * EsdEas0201  <br>
	 * Location 에 값이 존재하는지 체크 한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse validLoc(Event e) throws EventException {
		try{
			EsdEas0201Event event = (EsdEas0201Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EacSearchVO> list = command.validLoc(event.getEacSearchVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"validLoc"}).getMessage(), ex);
		}
	}	
	
	/**
	 * EsdEas0201  <br>
	 * Yard Code 에 값이 존재하는지 체크 한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse validYard(Event e) throws EventException {
		try{
			EsdEas0201Event event = (EsdEas0201Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EacSearchVO> list = command.validYard(event.getEacSearchVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"validLoc"}).getMessage(), ex);
		}
	}	
	
	/**
	 * EsdEas0201  <br>
	 * Currency 콤보데이터를 조회한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchCurrency(Event e) throws EventException {
		try{
			EsdEas0201Event event = (EsdEas0201Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EacSearchVO> list = command.searchCurrency(event.getEacSearchVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchCurrency"}).getMessage(), ex);
		}
	}	
	
	/**
	 * EsdEas0201  <br>
	 * Exchange Rate 조회한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchUsdXch(Event e) throws EventException {
		try{
			EsdEas0201Event event = (EsdEas0201Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EacSearchVO> list = command.searchUsdXch(event.getEacSearchVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchUsdXch"}).getMessage(), ex);
		}
	}	
	
	/**
	 * EsdEas0201  <br>
	 * EAC Registration 를 저장한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse multiEacReg(Event e) throws EventException {
		EsdEas0201Event event = (EsdEas0201Event)e;
		EacMgtBC command = new EacMgtBCImpl();
		try{
			begin();
			String eacNo =  command.multiEacReg(event.getEacTpbDtlVOs(),event.getEacRegistrationVO(),account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setUserMessage(new ErrorHandler("COM12191", new String[]{"Data"}).getUserMessage()); // ($s) was saved successfully.
			eventResponse.setETCData("eac_no",eacNo);
			commit();
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"multiEacReg"}).getMessage(), ex);
		}
	}	
	
	/**
	 * EsdEas0201  <br>
	 * TPB 테이블에 자료를 등록한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse multiEacTpbIf(Event e) throws EventException {
		EsdEas0201Event event = (EsdEas0201Event)e;
		EacMgtBC command = new EacMgtBCImpl();
		try{
			begin();
			command.multiEacTpbIf(event.getEacSearchVO(),account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setUserMessage(new ErrorHandler("COM12191", new String[]{"Data"}).getUserMessage()); // ($s) was saved successfully.
			commit();
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"multiEacTpbIf"}).getMessage(), ex);
		}
	}	
	
	/**
	 * EsdEas0201  <br>
	 * RHQ OFFCE 콤보값을 조회한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchRhqList(Event e) throws EventException {
		try{
			EsdEas0201Event event = (EsdEas0201Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EacSearchVO> list = command.searchRhqList(event.getEacSearchVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchRhqList"}).getMessage(), ex);
		}
	}	
	
	/**
	 * EsdEas0201  <br>
	 * OFFCE 콤보값을 조회한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOfcList(Event e) throws EventException {
		try{
			EsdEas0201Event event = (EsdEas0201Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EacSearchVO> list = command.searchOfcList(event.getEacSearchVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchOfcList"}).getMessage(), ex);
		}
	}	
	
	
	/**
	 * EsdEas0201  <br>
	 * EAC Registration 을 조회한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchEacReg(Event e) throws EventException {
		try{
			EsdEas0201Event event = (EsdEas0201Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EACRgstVO> list = command.searchEacReg(event.getEacRegistrationVO());
			List<EACTpbDtlVO> list2 = command.searchTrpDtlGrid(event.getEacRegistrationVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(list2);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchEacReg"}).getMessage(), ex);
		}
	}	
	
	
	/**
	 * EsdEas0201  <br>
	 * Rejection Notice Tab 을 조회한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchEacRjctNtc(Event e) throws EventException {
		try{
			EsdEas0201Event event = (EsdEas0201Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EACRgstVO> list = command.searchEacRjctNtc(event.getEacSearchVO(),account.getUsr_id());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchEacRjctNtc"}).getMessage(), ex);
		}
	}	

	/**
	 * EsdEas0201  <br>
	 * Contact Point 콤보값을 조회한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchCntcPnt(Event e) throws EventException {
		try{
			EsdEas0201Event event = (EsdEas0201Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EacSearchVO> list = command.searchCntcPnt(event.getEacSearchVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchCntcPnt"}).getMessage(), ex);
		}
	}	
	
	/**
	 * EsdEas0201  <br>
	 * Expense Audit case Registration 저장전 중복된 데이터 인지 확인한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse verifyEacReg(Event e) throws EventException {
		try{
			EsdEas0201Event event = (EsdEas0201Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EacSearchVO> list = command.verifyEacReg(event.getEacSearchVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"verifyEacReg"}).getMessage(), ex);
		}
	}	
	
	/**
	 * EsdEas0201  <br>
	 * Booking No 가 존재하는지 확인한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse verifyBkgNO(Event e) throws EventException {
		try{
			EsdEas0201Event event = (EsdEas0201Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EacSearchVO> list = command.verifyBkgNO(event.getEacSearchVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"verifyBkgNO"}).getMessage(), ex);
		}
	}	
	
	/**
	 * EsdEas0201  <br>
	 * I/F 전에 중복 여부를 체크한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse verifyTpbIf(Event e) throws EventException {
		try{
			EsdEas0201Event event = (EsdEas0201Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EacSearchVO> list = command.verifyTpbIf(event.getEacSearchVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"verifyTpbIf"}).getMessage(), ex);
		}
	}	
	
	/**
	 * EsdEas0201  <br>
	 * Responsible Office 가 TPB 에 등록된 office 인지 확인한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse verifyTpbOfc(Event e) throws EventException {
		try{
			EsdEas0201Event event = (EsdEas0201Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EacSearchVO> list = command.verifyTpbOfc(event.getEacSearchVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"verifyTpbOfc"}).getMessage(), ex);
		}
	}	
	
	/**
	 * EsdEas0201  <br>
	 * Personnel Config, Office Config 가 등록되어 있는지 확인하고 발송자 메일 정보를 조회한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchPsonCfg(Event e) throws EventException {
		try{
			EsdEas0201Event event = (EsdEas0201Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EacSearchVO> list = command.searchPsonCfg(event.getEacSearchVO(),account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"verifyTpbOfc"}).getMessage(), ex);
		}
	}	
	
	/**
	 * EsdEas0201  <br>
	 * 입력한 3rdParty Value 값이 유효한지 체크한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse verify3rdVale(Event e) throws EventException {
		try{
			EsdEas0201Event event = (EsdEas0201Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EacSearchVO> list = command.verify3rdVale(event.getEacSearchVO());
			
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"verify3rdVale"}).getMessage(), ex);
		}
	}	
	
	/**
	 * EsdEas0202  <br>
	 * S/P Contact point 의  MDM S/P Information 을 조회한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchVndrList(Event e) throws EventException {
		try{
			EsdEas0202Event event = (EsdEas0202Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EACSpCtrtVO> list = command.searchVndrList(event.getEacSearchVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchVndrList"}).getMessage(), ex);
		}
	}	
	
	/**
	 * EsdEas0202  <br>
	 *  S/P Code 가 선택되면  등록된 Contact point 을 조회한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchVndrCntc(Event e) throws EventException {
		try{
			EsdEas0202Event event = (EsdEas0202Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EACSpCtrtVO> list = command.searchVndrCntc(event.getEacSearchVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchVndrCntc"}).getMessage(), ex);
		}
	}	
	
	/**
	 * EsdEas0202  <br>
	 * SP Contact point 를 저장한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse multiVndrCntc(Event e) throws EventException {
		EsdEas0202Event event = (EsdEas0202Event)e;
		EacMgtBC command = new EacMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			command.multiVndrCntc(event.getEacSpContactPointVOs(),account.getUsr_id());
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			commit();
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"multiVndrCntc"}).getMessage(), ex);
		}
	}	
	
	/**
	 * EsdEas0203  <br>
	 * Office Config 를 저장한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse multiEacOfc(Event e) throws EventException {
		EsdEas0203Event event = (EsdEas0203Event)e;
		EacMgtBC command = new EacMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			command.multiEacOfc(event.getEacOfficeConfigVO() ,account.getUsr_id());
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			commit();
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"multiEacOfc"}).getMessage(), ex);
		}
	}	

	
	/**
	 * EsdEas0203  <br>
	 * Office Config 를 조회한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchEacOfc(Event e) throws EventException {
		try{
			EsdEas0203Event event = (EsdEas0203Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EACOfcCfgVO> list = command.searchEacOfc(event.getEacOfficeConfigVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchEacOfc"}).getMessage(), ex);
		}
	}	
	
	/**
	 * EsdEas0204  <br>
	 * Personnel Config 를 저장한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse multiEacPsn(Event e) throws EventException {
		EsdEas0204Event event = (EsdEas0204Event)e;
		EacMgtBC command = new EacMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			command.multiEacPsn(event.getEacPersonnelConfigVO() ,account.getUsr_id());
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			commit();
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"multiEacPsn"}).getMessage(), ex);
		}
	}	
	
	
	/**
	 * EsdEas0204  <br>
	 * Personnel Config 를 삭제한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse deleteEacPsn(Event e) throws EventException {
		EsdEas0204Event event = (EsdEas0204Event)e;
		EacMgtBC command = new EacMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			command.deleteEacPsn(event.getEacPersonnelConfigVO() ,account.getUsr_id());
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			commit();
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"deleteEacPsn"}).getMessage(), ex);
		}
	}	
	
	
	/**
	 * EsdEas0204  <br>
	 * Personnel Config 를 조회한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchEacPsn(Event e) throws EventException {
		try{
			EsdEas0204Event event = (EsdEas0204Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EACPsonCfgVO> list = command.searchEacPsn(event.getEacPersonnelConfigVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchEacPsn"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0214  <br>
	 * Personnel Config Inquiry 를 삭제한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse deleteEacPsnList(Event e) throws EventException {
		EsdEas0214Event event = (EsdEas0214Event)e;
		EacMgtBC command = new EacMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			command.deleteEacPsnList(event.getEacPersonnelConfigVOs() ,account.getUsr_id());
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			commit();
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"deleteEacPsnList"}).getMessage(), ex);
		}
	}	
	
	
	/**
	 * EsdEas0214  <br>
	 * Personnel Config Inquiry 를 조회한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchEacPsnList(Event e) throws EventException {
		try{
			EsdEas0214Event event = (EsdEas0214Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EACPsonCfgVO> list = command.searchEacPsnList(event.getEacPersonnelConfigVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchEacPsnList"}).getMessage(), ex);
		}
	}
	
	
	
	/**
	 * EsdEas0205  <br>
	 * Personnel Config Inquiry 를 조회한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchEacAuditorList(Event e) throws EventException {
		try{
			EsdEas0205Event event = (EsdEas0205Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EACEditVO> list = command.searchEacAuditorList(event.getEacSearchVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchEacPsnList"}).getMessage(), ex);
		}
	}
	
	

	/**
	 * EsdEas0201  <br>
	 * 등록된 EAC 자료의 상태를 변경한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse modifyEacSts(Event e) throws EventException {
		try{
			EsdEas0201Event event = (EsdEas0201Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			command.modifyEacSts(event.getEacSearchVOs(),account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"modifyEacSts"}).getMessage(), ex);
		}
	}
	
	
	
	
	
	/**
	 * EsdEas0205  <br>
	 * EAC 등록 자료를 리스트로 조회한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchEacEditList(Event e) throws EventException {
		try{
			EsdEas0205Event event = (EsdEas0205Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EACEditVO> list = command.searchEacEditList(event.getEacSearchVO());  
			
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchEacEditList"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0206  <br>
	 * EAC 등록 자료를 리스트로 조회한다(Confirm)  <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchEacCfmList(Event e) throws EventException {
		try{
			EsdEas0206Event event = (EsdEas0206Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EACCfmVO> list = command.searchEacCfmList(event.getEacSearchVO());  
			
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchEacCfmList"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0208  <br>
	 * EAC 등록 자료를 리스트로 조회한다(Inquiry)  <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchEacCode(Event e) throws EventException {
		try{
			EsdEas0208Event event = (EsdEas0208Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EACCdVO> list = command.searchEacCode(event.getEacSearchVO());  
			
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchEacCfmList"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0209  <br>
	 * 오피스/월별 비용심사 실적 조회. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOfcStatistics(Event e) throws EventException {
		try{
			EsdEas0209Event event = (EsdEas0209Event)e;
			EacRegRptBC command = new EacRegRptBCImpl();
			List<SearchOfcStatisticsVO> list = command.searchOfcStatistics(event.getSearchRegRptVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchOfcStatistics"}).getMessage(), ex);
		}
	}
	
	
	
	/**
	 * EsdEas0206  <br>
	 * EAC 등록 자료를 리스트로 조회한다.   <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchEacReadList(Event e) throws EventException {
		try{
			EsdEas0217Event event = (EsdEas0217Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EACInqVO> list = command.searchEacReadList(event.getEacSearchVO());  
			
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchEacReadList"}).getMessage(), ex);
		}
	}
	
	
	/**
	 * EsdEas0218  <br>
	 * RHQ/월별 비용심사 실적 조회. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchRhqStatistics(Event e) throws EventException {
		try{
			EsdEas0218Event event = (EsdEas0218Event)e;
			EacRegRptBC command = new EacRegRptBCImpl();
			List<SearchRhqStatisticsVO> list = command.searchRhqStatistics(event.getSearchRegRptVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchRhqStatistics"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0210  <br>
	 * Audit office 또는 Responsible Office별 실적 조회 <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOfcPerf(Event e) throws EventException {
		try{
			EsdEas0210Event event = (EsdEas0210Event)e;
			EacRegRptBC command = new EacRegRptBCImpl();
			List<SearchOfcPerfVO> list = command.searchOfcPerf(event.getSearchRegRptVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchOfcPerf"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0211  <br>
	 * S/P별 실적 조회 <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchEacNotice(Event e) throws EventException {
		try{
			EsdEas0211Event event = (EsdEas0211Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EACNtcVO> list = command.searchEacNotice(event.getEacNtcVO(),account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchSpPerf"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0219  <br>
	 * S/P별 실적 조회 <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchSpPerf(Event e) throws EventException {
		try{
			EsdEas0219Event event = (EsdEas0219Event)e;
			EacRegRptBC command = new EacRegRptBCImpl();
			List<SearchSpPerfVO> list = command.searchSpPerf(event.getSearchRegRptVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchSpPerf"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0220  <br>
	 * TPB Inquiry by EAC 내역 조회 <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchTpbIfDetail(Event e) throws EventException {
		try{
			EsdEas0220Event event = (EsdEas0220Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EACInqEacVO> list = command.searchTpbIfDetail(event.getEacInqEacVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchSpPerf"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0211  <br>
	 * EAC Rejection Notice 메일 발송 <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse saveEacNotice(Event e) throws EventException {
		EsdEas0211Event event = (EsdEas0211Event)e;
		EacMgtBC command = new EacMgtBCImpl();
		try{
			begin();
			command.saveEacNotice(event.getEacNtcVO(),account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setUserMessage(new ErrorHandler("COM12191", new String[]{"Data"}).getUserMessage()); // ($s) was saved successfully.
			commit();
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"multiEacReg"}).getMessage(), ex);
		}
	}	
	
	/**
	 * EsdEas0223  <br>
	 * EAC 첨부 파일 내역 조회 <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchEacFile(Event e) throws EventException {
		try{
			EsdEas0223Event event = (EsdEas0223Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EacFileOutVO> list = command.searchEacFile(event.getEacFileInVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchSpPerf"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0223  <br>
	 * EAC 첨부 파일 저장 <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse manageEacFile(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EacMgtBC command = new EacMgtBCImpl();
		//1.로직 처리전 Event 객체에서 값을 입력하거나 선택된 값으로 설정해준다.
		EsdEas0223Event event = (EsdEas0223Event)e;
		EacFileInVO eacFileInVO = event.getEacFileInVO();
		eacFileInVO.setAccount(account);
		try{
			//2.로직 처리 실행
			begin();
			command.manageEacFile(eacFileInVO);
			commit();

			//3.로직 처리후 결과처리
			eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());  //BKG00102 : 저장성공

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		log.debug("[END::]==========");
		return eventResponse;
	}

	
	/**
	 * EsdEas0222  <br>
	 * EAC Rejection Notice History 시퀀스 조회 <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchRjctNtcHis(Event e) throws EventException {
		try{
			EsdEas0222Event event = (EsdEas0222Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EacSearchVO> list = command.searchRjctNtcHis(event.getEacSearchVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchSpPerf"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0221  <br>
	 * Rejection Notice Send History 내역 조회 <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchRjctNtcSendHis(Event e) throws EventException {
		try{
			EsdEas0221Event event = (EsdEas0221Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EACNtcHisVO> list = command.searchRjctNtcSendHis(event.getEacNtcHisVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchSpPerf"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0214  <br>
	 * Personnel Config의 KPI Office를 Update한다.<br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse multiEacPsnList(Event e) throws EventException {
		EsdEas0214Event event = (EsdEas0214Event)e;
		EacMgtBC command = new EacMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			command.multiEacPsnList(event.getEacPersonnelConfigVOs() ,account.getUsr_id());
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			commit();
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"deleteEacPsnList"}).getMessage(), ex);
		}
	}	
	
	/**
	 * EsdEas0226  <br>
	 * Auto Audit 첨부파일 저장/삭제<br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse manageAutoAudFile(Event e) throws EventException {
		EsdEas0226Event event = (EsdEas0226Event)e;
		EacMgtBC command = new EacMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			String atchFileLnkId = command.manageAutoAuditFile(event.getAutoAuditFileVOs() ,account);
			eventResponse.setETCData("atch_file_lnk_id",atchFileLnkId);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			commit();
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"deleteEacPsnList"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0226  <br>
	 * Auto Audit 첨부 파일 내역 조회 <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchAutoAudFile(Event e) throws EventException {
		try{
			EsdEas0226Event event = (EsdEas0226Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<AutoAuditFileVO> list = command.searchAutoAudFile(event.getAutoAuditFileVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchAutoAudFile"}).getMessage(), ex);
		}
	}	
	
	/**
	 * EsdEas0226  <br>
	 * Auto Audit 첨부파일 전체삭제<br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse removeAutoAudFileAll(Event e) throws EventException {
		EsdEas0226Event event = (EsdEas0226Event)e;
		EacMgtBC command = new EacMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			command.removeAutoAudFileAll(event.getAutoAuditFileVO());
			commit();
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"deleteEacPsnList"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0226  <br>
	 * Currency 콤보데이터를 조회한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchCurrency2(Event e) throws EventException {
		try{
			EsdEas0226Event event = (EsdEas0226Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EacSearchVO> list = command.searchCurrency2(event.getEacSearchVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchCurrency"}).getMessage(), ex);
		}
	}	
	
	/**
	 * EsdEas0226  <br>
	 * Currency 환율 조회한다. <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchMonthExchange(Event e) throws EventException {
		try{
			EsdEas0226Event event = (EsdEas0226Event)e;
			EacMgtBC command = new EacMgtBCImpl();
			List<EacSearchVO> list = command.searchMonthExchange(event.getEacSearchVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchCurrency"}).getMessage(), ex);
		}
	}
}
