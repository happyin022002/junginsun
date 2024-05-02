/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : COPHistoryBC.java
*@FileTitle : COP History Search
*Open Issues :
*Change history :
*@LastModifyDate : 2008-03-03
*@LastModifier : minestar
*@LastVersion : 1.0
* 2008-03-03 minestar
* 1.0 최초 생성
* 2011.07.06 손은주 [CHM-201111830]Split 13-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 - 의미없는 주석 및 미사용 소스 제거
* 2011.11.29 전준영 [CLT-111121289][R4J 공지] 45주차 Java application 소스 품질 결함 조치  - Null Dereferencing
* 2011.12.01 전준영 [CLT-111121289]Split R4J 소스품질 결함 조치 - Null Dereferencing
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copreport;

import java.util.List;

import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.BkgCopManageVO;
import com.hanjin.apps.alps.esd.sce.copreport.cophsitory.basic.COPHistoryBC;
import com.hanjin.apps.alps.esd.sce.copreport.cophsitory.basic.COPHistoryBCImpl;
import com.hanjin.apps.alps.esd.sce.copreport.cophsitory.event.EsdSce0071Event;
import com.hanjin.apps.alps.esd.sce.copreport.cophsitory.vo.SearchCOPHistoryVO;
import com.hanjin.apps.alps.esd.sce.copreport.manualcntrmapping.basic.ManualCntrMappBC;
import com.hanjin.apps.alps.esd.sce.copreport.manualcntrmapping.basic.ManualCntrMappBCImpl;
import com.hanjin.apps.alps.esd.sce.copreport.manualcntrmapping.event.EsdSce0115Event;
import com.hanjin.apps.alps.esd.sce.copreport.manualcntrmapping.vo.SearchCntrMapgListVO;
import com.hanjin.apps.alps.esd.sce.copreport.optimumroutepass.basic.OptimumRoutePassBC;
import com.hanjin.apps.alps.esd.sce.copreport.optimumroutepass.basic.OptimumRoutePassBCImpl;
import com.hanjin.apps.alps.esd.sce.copreport.optimumroutepass.event.EsdSce0170Event;
import com.hanjin.apps.alps.esd.sce.copreport.optimumroutepass.event.EsdSce0171Event;
import com.hanjin.apps.alps.esd.sce.copreport.optimumroutepass.vo.OptmRoutPassDtlVO;
import com.hanjin.apps.alps.esd.sce.copreport.optimumroutepass.vo.OptmRoutPassSmryVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SceCopHdrVO;


/**
 * ENIS-SCE Business Logic ServiceCommand<br>
 * - ENIS-SCE에 대한 비지니스 트랜잭션을 처리한다.<br>
 *
 * @author Jungwoo HAN
 * @see EsdSce001EventResponse,COPReport
 * @since J2EE 1.4
 */
public class COPReportSC extends ServiceCommandSupport {

	// Login User Information
    private SignOnUserAccount account = null;

	/**
     * SCE 업무 시나리오 선행작업<br>
     * COPReport업무 시나리오 호출시 관련 내부객체 생성<br>
     */
    public void doStart() {
        try {
            // 일단 comment --> 로그인 체크 부분
            account = getSignOnUserAccount();
        } catch (Exception e) {
            log.error("COPReportSC 선행 작업 시 오류 " + e.toString(), e);
        }
    }

    /**
     * SCE 업무 시나리오 마감작업<br>
     * COPReport업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        // command.doEnd();
        log.debug("COPReportSC 종료");
    }

    /**
     * 각 이벤트에 해당하는 업무 시나리오 수행<br>
     * ENIS-SCE 업무에서 발생하는 모든 이벤트의 분기처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
	public EventResponse perform(Event e) throws EventException {

		EventResponse eventResponse = null;

        // SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
        // COP Inquiry Customer Name Search
        if (e.getEventName().equalsIgnoreCase("EsdSce0071Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
                eventResponse = searchCOPHistory(e);
            }
        } else if ( e.getEventName().equalsIgnoreCase("EsdSce0078Event")) {

        	if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) { //Sub-Office
        		log.debug("\n COPReportSC EventName : "+e.getEventName());
    			//eventResponse = searchSubOfficeList(e);
    		}
//        	if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) { //Exception Type
//    			//eventResponse = searchExptTPList(e);
//    		}
//        	if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) { //Exception Type
//    			//eventResponse = searchExptDTLTPList(e);
//    		}
        } else if (e.getEventName().equalsIgnoreCase("EsdSce0115Event")) {
			//log.debug("\n EsdSce0115Event");
			// Retrieve 클릭시-상단리스트
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				log.debug("\n SEARCH01************");
				eventResponse = searchCntrMapgList(e);
				// Save 클릭시-저장
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				log.debug("\n 0115 command MULTI01" );
				eventResponse = multiCntrMapg(e);
			// Save 클릭시-하단 리스트
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				log.debug("\n SEARCHLIST************" );
				eventResponse = searchCopMapgList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdSce0120Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				log.debug("\n SEARCH01************");
				eventResponse = searchCntrMapgList(e);
				// Save 클릭시-저장
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				log.debug("\n 0115 command MULTI01" );
				eventResponse = multiCntrMapg(e);
			// Save 클릭시-하단 리스트
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdSce0170Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOptmRoutPassSmry(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdSce0171Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOptmRoutPassDtl(e);
			}
		}

        log.debug("\n SC END!!!");

    	return eventResponse;
	}


	/**
	 * COP History 조회 결과를 리턴한다.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCOPHistory(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsdSce0071Event event         = (EsdSce0071Event)e ;
    	List<SearchCOPHistoryVO> list = null;
 	
        try {
        	COPHistoryBC command = new COPHistoryBCImpl();
            list = command.searchCOPHistory(event.getConditionVO());
			eventResponse.setRsVoList(list);            
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        } 
        return eventResponse;
	}

    /**
     * Manual Container Mapping(하단리스트 조회) &&&
     *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */
	private EventResponse searchCopMapgList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		EsdSce0115Event event         = (EsdSce0115Event)e;

		try {
			ManualCntrMappBC command = new ManualCntrMappBCImpl();
			List<SceCopHdrVO> list =  command.searchCopMapgList(event.getManualReplanInfoVOs());
			//log.info("\n searchCopMapgList SC~~~~~");
			eventResponse.setRsVoList(list); 			
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
    /**
     * Manual Container Mapping(상단리스트 조회) &&&
     *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */
	private EventResponse searchCntrMapgList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		EsdSce0115Event event   = (EsdSce0115Event) e;

		try {
			ManualCntrMappBC command = new ManualCntrMappBCImpl();
			List<SearchCntrMapgListVO>  list = command.searchCntrMapgList(event.getManualReplanInfoVO());
			eventResponse.setRsVoList(list); 
			return (eventResponse);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

    /**
     * Manual Container Mapping(Save-저장)
     *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */
	public EventResponse multiCntrMapg(Event e) throws EventException {
//		EventResponse eventResponse = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		EsdSce0115Event event   = (EsdSce0115Event) e;

		try {
			ManualCntrMappBC command = new ManualCntrMappBCImpl();
			BkgCopManageVO[] vos = event.getBkgCopManageVOs();

			List<SceCopHdrVO> list =  command.searchCopMapgList(event.getManualReplanInfoVOs());			
			eventResponse.setRsVoList(list); 			
			
			begin();			
			command.multiCntrMapg(vos);
			commit();

			return (eventResponse);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Optimum Route Pass - Summary<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOptmRoutPassSmry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0170Event event = (EsdSce0170Event)e;
		OptimumRoutePassBC command = new OptimumRoutePassBCImpl();

		try{
			List<OptmRoutPassSmryVO> list = command.searchOptmRoutPassSmry(event.getOptmRoutPassCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Optimum Route Pass - Detail<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOptmRoutPassDtl(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0171Event event = (EsdSce0171Event)e;
		OptimumRoutePassBC command = new OptimumRoutePassBCImpl();

		try{
			List<OptmRoutPassDtlVO> list = command.searchOptmRoutPassDtl(event.getOptmRoutPassCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

}
