/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpotBiddingManageRSC.java
*@FileTitle : SpotBidding Web-Service
*Open Issues :
*Change history :
*@LastModifyDate : 2015-06-22
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2015-06-22 SHIN DONG IL
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange;

import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.basic.SpotBiddingManageBC;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.basic.SpotBiddingManageBCImpl;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingListResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingListSendEvent;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingLowestAmtEvent;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingLowestAmtResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingReceiveBiddingAmtEvent;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSendReeferCargoInfoEvent;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSendReeferCargoInfoResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSendAwkwardCargoInfoEvent;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSendAwkwardCargoInfoResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSendDangerCargoInfoEvent;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSendDangerCargoInfoResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSpUsrInfoEvent;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;

/**
* ESD-TRS Business Logic ServiceCommand<br>
* - ESD-TRS 에 대한 비지니스 트랜잭션을 처리한다.<br>
* 
* @author SHIN DONG IL
* @see EventResponse,SpotBiddingManageDBDAO 참조
* @since J2EE 1.6
*/
public class SpotBiddingManageRSC extends ServiceCommandSupport {
	
	private static final long serialVersionUID = 1L;
	
    /**
    * ESD-TRS 업무 시나리오 선행작업<br>
    * SpotBiddingManage 업무 시나리오 호출시 관련 내부객체 생성<br>
    */
   public void doStart() {
       try {
           // 일단 comment --> 로그인 체크 부분
          log.error("SpotBiddingManageRSC 시작 ");
       } catch (Exception e) {
           log.error("SpotBiddingManageRSC 선행 작업 시 오류 " + e.toString(), e);
       }
   }

   /**
    * ESD-TRS 업무 시나리오 마감작업<br>
    * SpotBiddingManage 업무 시나리오 종료시 관련 내부객체 해제<br>
    */
   public void doEnd() {
       // command.doEnd();
       log.debug("SpotBiddingManageRSC 종료");
   }

   /**
    * 각 이벤트에 해당하는 업무 시나리오 수행<br>
    * ESD-TRS 업무에서 발생하는 모든 이벤트의 분기처리<br>
    * 
    * @param e Event
    * @return response EventResponse
    * @exception EventException
    */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;
		
		 if (e.getEventName().equalsIgnoreCase("SpotBiddingListSendEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = sendSpotBiddingList(e);
			}else{
				eventResponse = null;
			}
		 }else if (e.getEventName().equalsIgnoreCase("SpotBiddingLowestAmtEvent")){
			 if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				 eventResponse = sendSpotBiddingLowestAmt(e);
			}else{
				eventResponse = null;
			}
		 }else if (e.getEventName().equalsIgnoreCase("SpotBiddingReceiveBiddingAmtEvent")){
			 if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				spotBiddingReceiveBiddingAmt(e);
			}else{
				eventResponse = null;
			}
		 }else if (e.getEventName().equalsIgnoreCase("SpotBiddingSpUsrInfoEvent")){
			 if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				 modifySpotBiddingSpUsrInfo(e);
			}else{
				eventResponse = null;
			}
		 }else if (e.getEventName().equalsIgnoreCase("SpotBiddingSendReeferCargoInfoEvent")){
			 if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				 eventResponse =  searchSpotBiddingSendReeferCargoInfo(e);
			}else{
				eventResponse = null;
			}
		 }else if (e.getEventName().equalsIgnoreCase("SpotBiddingSendAwkwardCargoInfoEvent")){
			 if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse =  searchSpotBiddingSendAwkwardCargoInfo(e);
			}else{
				eventResponse = null;
			}
		 }else if (e.getEventName().equalsIgnoreCase("SpotBiddingSendDangerCargoInfoEvent")){
			 if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse =  searchSpotBiddingSendDangerCargoInfo(e);
			}else{
				eventResponse = null;
			}		 
		 }else{
			 eventResponse = null;
		 }
		return eventResponse;
	}
	/**
	 * 조회 이벤트 처리<br>
	 * SPP의 조회조건을 I/F받아 조회결과를 SPP로 I/F해준다.<br>
	 * 
	 * @param e Event
	 * @return eventResponse
	 * @exception EventException
	 */
	private EventResponse sendSpotBiddingList(Event e) throws EventException {
		SpotBiddingListResponse eventResponse = null;
		SpotBiddingListSendEvent event = (SpotBiddingListSendEvent) e;
		try {
		SpotBiddingManageBC command = new SpotBiddingManageBCImpl();
       	eventResponse = new SpotBiddingListResponse(command.sendSpotBiddingList(event));
       	
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		 return eventResponse;
	 }
	/**
	 * Bidding의 최저가 Bidding Amount를 SPP로 I/F받는다.
	 * 
	 * @param e Event
	 * @return eventResponse
	 * @throws EventException
	 */
	private EventResponse sendSpotBiddingLowestAmt(Event e) throws EventException {
		SpotBiddingLowestAmtResponse eventResponse = null;
		SpotBiddingLowestAmtEvent event = (SpotBiddingLowestAmtEvent) e;
		try {
		SpotBiddingManageBC command = new SpotBiddingManageBCImpl();
       	eventResponse = new SpotBiddingLowestAmtResponse(command.sendSpotBiddingLowestAmt(event));
       	
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		 return eventResponse;
	 }
	
	/**
	 * SPP에서 Bidding Amount를 I/F받는다.
	 * 
	 * @param e Event
	 * @throws EventException
	 */
	private void spotBiddingReceiveBiddingAmt(Event e) throws EventException {
//		EventResponse eventResponse = null;
		SpotBiddingReceiveBiddingAmtEvent event = (SpotBiddingReceiveBiddingAmtEvent) e;
		
		try {
		SpotBiddingManageBC command = new SpotBiddingManageBCImpl();
		begin();
		command.spotBiddingReceiveBiddingAmt(event);
       	commit();

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
//		return eventResponse;
	 }
	
	/**
	 * SPP에서 User정보를 I/F받아 Vendor의 SPP Flag를 Update한다.
	 * 
	 * @param e
	 * @throws EventException
	 */
	private void modifySpotBiddingSpUsrInfo(Event e) throws EventException {
//		EventResponse eventResponse = null;
		SpotBiddingSpUsrInfoEvent event = (SpotBiddingSpUsrInfoEvent) e;
		
		try {
		SpotBiddingManageBC command = new SpotBiddingManageBCImpl();
		
		begin();
        command.modifySpotBiddingSpUsrInfo(event);
       	commit();

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
//		return eventResponse;
	 }
	
	/**
	 * 조회 이벤트 처리<br>
	 * SPP의 조회조건을 I/F받아 Reefer Cargo 조회결과를 SPP로 I/F해준다.<br>
	 * 
	 * @param e Event
	 * @return eventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpotBiddingSendReeferCargoInfo(Event e) throws EventException {
		SpotBiddingSendReeferCargoInfoResponse eventResponse = null;
		SpotBiddingSendReeferCargoInfoEvent event = (SpotBiddingSendReeferCargoInfoEvent) e;
		try {
		SpotBiddingManageBC command = new SpotBiddingManageBCImpl();
       	eventResponse = new SpotBiddingSendReeferCargoInfoResponse(command.searchSpotBiddingSendReeferCargoInfo(event));
       	
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		 return eventResponse;
	 }
	
	/**
	 * 조회 이벤트 처리<br>
	 * SPP의 조회조건을 I/F받아 Awkward Cargo 조회결과를 SPP로 I/F해준다.<br>
	 * 
	 * @param e Event
	 * @return eventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpotBiddingSendAwkwardCargoInfo(Event e) throws EventException {
		SpotBiddingSendAwkwardCargoInfoResponse eventResponse = null;
		SpotBiddingSendAwkwardCargoInfoEvent event = (SpotBiddingSendAwkwardCargoInfoEvent) e;
		try {
		SpotBiddingManageBC command = new SpotBiddingManageBCImpl();
       	eventResponse = new SpotBiddingSendAwkwardCargoInfoResponse(command.searchSpotBiddingSendAwkwardCargoInfo(event));
       	
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		 return eventResponse;
	 }
	
	/**
	 * 조회 이벤트 처리<br>
	 * SPP의 조회조건을 I/F받아 Danger Cargo 조회결과를 SPP로 I/F해준다.<br>
	 * 
	 * @param e Event
	 * @return eventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpotBiddingSendDangerCargoInfo(Event e) throws EventException {
		SpotBiddingSendDangerCargoInfoResponse eventResponse = null;
		SpotBiddingSendDangerCargoInfoEvent event = (SpotBiddingSendDangerCargoInfoEvent) e;
		try {
		SpotBiddingManageBC command = new SpotBiddingManageBCImpl();
       	eventResponse = new SpotBiddingSendDangerCargoInfoResponse(command.searchSpotBiddingSendDangerCargoInfo(event));
       	
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		 return eventResponse;
	 }
}