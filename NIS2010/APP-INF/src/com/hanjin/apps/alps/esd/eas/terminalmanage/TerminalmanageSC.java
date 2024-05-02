/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TerminalmanageSC.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2008-01-07
*@LastModifier : yujin
*@LastVersion : 1.0
* 2007-11-29 yujin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.terminalmanage;

import java.util.List;

import com.hanjin.apps.alps.esd.eas.terminalmanage.basic.RehandExpmanageBC;
import com.hanjin.apps.alps.esd.eas.terminalmanage.basic.RehandExpmanageBCImpl;
import com.hanjin.apps.alps.esd.eas.terminalmanage.event.EsdEas0001Event;
import com.hanjin.apps.alps.esd.eas.terminalmanage.event.EsdEas0901Event;
import com.hanjin.apps.alps.esd.eas.terminalmanage.event.EsdEas0910Event;
import com.hanjin.apps.alps.esd.eas.terminalmanage.event.EsdEas0911Event;
import com.hanjin.apps.alps.esd.eas.terminalmanage.event.EsdEas0912Event;
import com.hanjin.apps.alps.esd.eas.terminalmanage.vo.EasLocationVO;
import com.hanjin.apps.alps.esd.eas.terminalmanage.vo.EasMdmCountryVO;
import com.hanjin.apps.alps.esd.eas.terminalmanage.vo.EasOpfTdrAtchFileVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * TerminalmanageSC ???? PDTO(Data Transfer Object including Parameters)<br>
 * @author yujin
 * @see ServiceCommandSupport 참조
 * @since J2EE 1.4
 */
public class TerminalmanageSC extends ServiceCommandSupport {

	
    // Login User Information
    private SignOnUserAccount account = null;

    /**
     * EAS 업무 시나리오 선행작업<br>
     * TransportmanageSC업무 시나리오 호출시 관련 내부객체 생성<br>
     */
    public void doStart() {
        try {
            // 일단 comment --> 로그인 체크 부분
            account=getSignOnUserAccount();
        } catch (Exception e) {
        	log.info(account.getUsr_id());
            log.error("TransportmanageSC 선행 작업 시 오류 " + e.toString(), e);
        }
    }

    /**
     * EAS 업무 시나리오 마감작업<br>
     * TransportmanageSC업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        // command.doEnd();
        log.debug("TransportmanageSC 종료");
    }

	/**
	 * perform<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */    
	public EventResponse perform(Event e) throws EventException {

        EventResponse eventResponse = null;
       
        // SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분

        if (e.getEventName().equalsIgnoreCase("EsdEas0001Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 
                eventResponse = searchRehandTPBCheckList(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("ESD_EAS_0901Event")) {
	        if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	            eventResponse = searchRehandExpnAudRmk(e);
	        } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
	            eventResponse = multiRehandExpnAudRmk(e);
	        }
        } else if (e.getEventName().equalsIgnoreCase("EsdEas0910Event")) {
	        if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
	            eventResponse = searchPortList(e);
	        } else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
	            eventResponse = searchCountryList(e);
	        }
        } else if (e.getEventName().equalsIgnoreCase("EsdEas0911Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOfficeHierarchy(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSubOffice(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdEas0912Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // SEARCH
				eventResponse = searchOpfTdrAtchFileVO(e);
			}
		}
		return eventResponse;
	}

	/**
	 * searchRehandTPBCheckList 모든 목록을 가져온다.<br>
	 * 
	 * @return e
	 * @throws EventException
	 */    
	private EventResponse searchRehandTPBCheckList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdEas0001Event event = (EsdEas0001Event)e;
		
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			RehandExpmanageBC command = new RehandExpmanageBCImpl();
			eventResponse = command.searchRehandTPBCheckList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Expense Audit Remark 조회
	 * @param e 
	 * @return
	 * @throws EventException
	 */
    private EventResponse searchRehandExpnAudRmk(Event e) throws EventException {
    	EsdEas0901Event	event	= (EsdEas0901Event)e;
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
        
        try {
        	RehandExpmanageBC command = new RehandExpmanageBCImpl();
            eventResponse = command.searchRehandExpnAudRmk(event);
            
        } catch (EventException de) {
        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
	
    /**
	 * Expense Audit Remark 추가/수정 4341.11.24
	 * @param e 
	 * @return
	 * @throws EventException
	 */
    private EventResponse multiRehandExpnAudRmk(Event e) throws EventException {
    	EsdEas0901Event	event	= (EsdEas0901Event)e;
    	
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
        try {
        	begin();
            
        	RehandExpmanageBC	command	= new RehandExpmanageBCImpl();
            eventResponse	= command.multiRehandExpnAudRmk(event);
            commit();
        } catch (EventException de) {
        	rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    	
    /**
	 * Port 리스트를 조회합니다.<br>
	 * 
     * @param e
     * @return
     * @throws EventException
     */
    private EventResponse searchPortList(Event e) throws EventException {
    	try{
    		
        	EsdEas0910Event	event	= (EsdEas0910Event)e;
        	EasLocationVO locationVO = event.getLocationVO();
        	
    		List<EasLocationVO> list = searchPortList(locationVO);
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		eventResponse.setRsVoList(list);
    		/*
    		 * 1건 조회시, 해당 Port명을 etc데이터(Key : port_name)로 등록
    		 */
    		if (list != null && list.size() == 1) {
    			EasLocationVO vo = list.get(0);
    			eventResponse.setETCData("port_name", vo.getLocNm());
    			eventResponse.setETCData("zd", vo.getZd());
    		}
    		return eventResponse;	
    	} catch (EventException de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(de.getMessage());
    	}

    }
	
	/**
	 * Port 리스트를 조회합니다.<br>
	 * 
	 * @param locationVO
	 * @return
	 * @throws EventException
	 */
	private List<EasLocationVO> searchPortList(EasLocationVO locationVO) throws EventException {
		try {
			RehandExpmanageBC	command	= new RehandExpmanageBCImpl();
			List<EasLocationVO> list = command.searchPortList(locationVO);
			return list;
    	} catch (EventException de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(de.getMessage());
    	}
	}
	
	
	/**
	 * 국가 리스트를 조회합니다.<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchCountryList(Event e) throws EventException {
		try {
			
        	EsdEas0910Event	event	= (EsdEas0910Event)e;        	
			EasMdmCountryVO vo = event.getMdmCountryVO();
			RehandExpmanageBC	command	= new RehandExpmanageBCImpl();
			List<EasMdmCountryVO> list = command.searchCountryList(vo.getCntCd());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			if(list!=null && list.size()==1){
				eventResponse.setETCData("cnt_nm", list.get(0).getCntNm());
			}
			return eventResponse;
    	} catch (EventException de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(de.getMessage());
    	}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchOfficeHierarchy(Event e) throws EventException {

		// PDTO(Data Transfer Object including Parameters)
		EsdEas0911Event event = (EsdEas0911Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			RehandExpmanageBC	command	= new RehandExpmanageBCImpl();
			eventResponse = command.searchOfficeHierarchy(event.getOfcCd());
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	
	 /**
	 * 조회 이벤트 처리<br>
	 *
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchSubOffice(Event e) throws EventException {

		// PDTO(Data Transfer Object including Parameters)
		EsdEas0911Event event = (EsdEas0911Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		RehandExpmanageBC	command	= new RehandExpmanageBCImpl();

		try {
			eventResponse = command.searchSubOffice(event.getOfcCd());
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
		
	/**
	 * ESD_EAS_0912 : SEARCH <br>
	 * TDR R/H 의 File Attached 건을 조회합니다.<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchOpfTdrAtchFileVO(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0912Event event = (EsdEas0912Event)e;
		RehandExpmanageBC	command	= new RehandExpmanageBCImpl();

		try{
			List<EasOpfTdrAtchFileVO> list = command.searchOpfTdrAtchFileVO(event.getOpfTdrAtchFileVO());
			eventResponse.setRsVoList(list);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
}
	
	
