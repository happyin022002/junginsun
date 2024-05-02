/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepoPlanManageSC.java
*@FileTitle : Execution Plan
*Open Issues :
*Change history :
*-----------------------------------------------------------------------------
*	No.    Ver.	Modifier			Modifier Date		Explanation
*-----------------------------------------------------------------------------
*				yongchan shin		2008-08-04			CSR NO : N200807310009 - Senator S/O Send, S/O Cancle 방식변경 EAT --> WTC
*				shin yongchan		2008-01-29			CSR NO : R200801154869
*				shin yongchan		2009-01-12			CSR NO : N200901080009 - EQR09 신규 생성 - Execution Plan 메뉴만 접근가능
*	                       														- 전지역에 대해 bkg / s/o cre 기능 가짐, SENCO office user들은 위한 권한
*				Haeng-Ji Lee		2009-01-07			CSR NO : N200901060030 - Oranization Chart에서 (RCC, LCC, ECC, SCC) 에 대한 갯수를 초기화면에 DISPLAY
*  				yongchan shin		2009-05-06			CSR NO : N200905060050 - &repoPlnWeek="+repoPlnWeek+" 항목 추가 (SPLIT BOOKING 대상 조회 WEEK 시작주차 기준 변경) -  
*				Chang-Ho Chae		2009-06-11			CSR No : N200906040080 - EQR 실행계획 하면 조회기능 변경 (Fm ETD, To ETA조건 추가)
*														CSR NO : R200903270008 - 소스 품질 개선(메소드 파라미터 삭제로 인한 메소드 호출방식 변경)
*				Lee Byoung Hun	2010.05.11			CSR No : CHM-201003779 - EES_EQR_0143(EQR All-Weeks' Plan?Access Grant) 이벤트 처리 추가
*-----------------------------------------------------------------------------
*@LastModifyDate : 2009.08.17
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.08.13 이행지
* 1.0 Creation
* =========================================================
* 2010.10.28 이병훈 [CHM-201006752-01] RD Report E-mailFax 전송 관련 PGM 고도화
* 2010.12.03 양봉준 [CHM-201007345-01] EES_EQR_0144 화면 신규 개발
* 2011.06.13 나상보 [CHM-201111518-01] [EQR]  MTY Rail Trans. 화면의 CNTR List 조회 기능 추가
* 2011.09.02 김영철 [CHM-201113259-01] [EQR]  VD Add시 다다음주차 가지고 오는 로직 추가
* 2012.06.05  [CHM-201218172]     T.VVD & D.VVD의 VL ADD 기간을 +0,+1,+2,+3,+4 WEEK 까지 확장	
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrusarail;

import java.util.List;

import com.clt.apps.opus.ees.eqr.cntrusarail.cntrforecastprecisionmanage.basic.CntrForecastPrecisionManageBC;
import com.clt.apps.opus.ees.eqr.cntrusarail.cntrforecastprecisionmanage.basic.CntrForecastPrecisionManageBCImpl;
import com.clt.apps.opus.ees.eqr.cntrusarail.cntrforecastprecisionmanage.event.EesEqr1058Event;
import com.clt.apps.opus.ees.eqr.cntrusarail.cntrforecastprecisionmanage.event.EesEqr1059Event;
import com.clt.apps.opus.ees.eqr.cntrusarail.cntrforecastprecisionmanage.vo.MtyRailConditionVO;
import com.clt.apps.opus.ees.eqr.cntrusarail.cntrforecastprecisionmanage.vo.MtyRailDetailVO;
import com.clt.apps.opus.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-RepoPlanManage Business Logic ServiceCommand - OPUS-RepoPlanManage 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Haeng-ji,Lee
 * @see CntrRepoExecutionPlanEstablishDBDAO
 * @since J2EE 1.6
 */

public class CntrUsaRailSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * RepoPlanManage system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("RepoPlanManageSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * RepoPlanManage system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("RepoPlanManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * OPUS-RepoPlanManage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
	
		// [ EES_EQR_0141 : MTY Rail Arrival Inquiry ]
		if (e.getEventName().equalsIgnoreCase("EesEqr1058Event")) {	
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {  
				  eventResponse = searchMtyRailArrivalUSTime(e);					                 
			}else if  (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {  // Retrieve 버튼 클릭시
			      eventResponse = searchMtyRailArrival(e);					                 
			}else if  (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {  // Retrieve 버튼 클릭시
			      eventResponse = searchMtyRailDetail(e);					                 
			}
		
		}
		// [ EES_EQR_0142 : MTY Rail Arrival Inquiry ]
		if (e.getEventName().equalsIgnoreCase("EesEqr1059Event")) {	
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {  // Retrieve 버튼 클릭시
				eventResponse = searchMtyRailResult(e);					                 
			}
		}

		return eventResponse;
	}

	/**
	 * [ EES_EQR_0141 : MTY Rail Arrival Inquiry ]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyRailArrival(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr1058Event event = (EesEqr1058Event)e;
		CntrForecastPrecisionManageBC command = new CntrForecastPrecisionManageBCImpl();
		
		try{
			MtyRailConditionVO conditionVO = event.getMtyRailConditionVO();
			
			CommonRsVO commonRsVO = command.searchMtyRailArrival(conditionVO);
			eventResponse.setRs(commonRsVO.getDbRowset());		
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
	 * [ EES_EQR_0141 : MTY Rail Arrival Detail ]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyRailDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr1058Event event = (EesEqr1058Event)e;
		CntrForecastPrecisionManageBC command = new CntrForecastPrecisionManageBCImpl();
		
		try{
			MtyRailConditionVO conditionVO = event.getMtyRailConditionVO();
			
			List<MtyRailDetailVO> list = command.searchMtyRailArrivalDetail(conditionVO);
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
	 * [ EES_EQR_0141 : MTY Rail Arrival Inquiry ]<br>
	 * 미주지역의 시간을 가져오기 위한 메소드 호출
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyRailArrivalUSTime(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr1058Event event = (EesEqr1058Event)e;
		CntrForecastPrecisionManageBC command = new CntrForecastPrecisionManageBCImpl();
		String usTime ="";
		MtyRailConditionVO conditionVO = new MtyRailConditionVO();
		try{
						
			usTime = command.searchMtyRailArrivalUSTime().getResultString();
			conditionVO.setFmDt(usTime);
			event.setMtyRailConditionVO(conditionVO);
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
	 * [ EES_EQR_0142 : MTY Rail Arrival Inquiry ]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyRailResult(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr1059Event event = (EesEqr1059Event)e;
		CntrForecastPrecisionManageBC command = new CntrForecastPrecisionManageBCImpl();

		try{ 
			
			CommonRsVO commonRsVO = command.searchMtyRailResult(event.getMtyRailConditionVO());
			List<MtyRailDetailVO> list = command.searchMtyRailResultDetail(event.getMtyRailConditionVO());
			eventResponse.setRs(commonRsVO.getDbRowset());
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