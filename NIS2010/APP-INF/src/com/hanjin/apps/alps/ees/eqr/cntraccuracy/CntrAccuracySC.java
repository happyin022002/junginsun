/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName 		: CntrAccuracySC.java
*@FileTitle 	: Accuracy
*Open Issues 	:
*Change history :
*-----------------------------------------------------------------------------
*	No.    Ver.	Modifier			Modifier Date		Explanation
*-----------------------------------------------------------------------------
*				SHIN DONG IL		2013.07.11			Creation
*-----------------------------------------------------------------------------
*@LastModifyDate 	: 2013.07.11
*@LastModifier 		: SHIN DONG IL
*@LastVersion 		: 1.0
* 2013.07.11 SHIN DONG IL
* 1.0 Creation 
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntraccuracy;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.eqr.cntraccuracy.cntraccuracytrend.basic.CntrAccuracyTrendBC;
import com.hanjin.apps.alps.ees.eqr.cntraccuracy.cntraccuracytrend.basic.CntrAccuracyTrendBCImpl;
import com.hanjin.apps.alps.ees.eqr.cntraccuracy.cntraccuracytrend.event.EesEqr1025Event;
import com.hanjin.apps.alps.ees.eqr.cntraccuracy.cntraccuracytrend.event.EesEqr1026Event;
import com.hanjin.apps.alps.ees.eqr.cntraccuracy.cntraccuracytrend.event.EesEqr1066Event;
import com.hanjin.apps.alps.ees.eqr.cntraccuracy.cntraccuracytrend.integration.CntrAccuracyTrendDBDAO;
import com.hanjin.apps.alps.ees.eqr.cntraccuracy.cntraccuracytrend.vo.EesEqr1025ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntraccuracy.cntraccuracytrend.vo.EesEqr1026ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntraccuracy.cntraccuracytrend.vo.EesEqr1066ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.vo.CommonRsVO;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS Accuracy Business Logic ServiceCommand - ALPS-Accuracy 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author SHIN DONG IL
 * @see CntrAccuracyTrendDBDAO
 * @since J2EE 1.6
 */
public class CntrAccuracySC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * Repo Plan system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("CntrAccuracySC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * Repo Plan system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("CntrAccuracySC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-Accuracy Trend system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		if (e.getEventName().equalsIgnoreCase("EesEqr1025Event")) {// Loading Trend By Lane [ EES_EQR_1025 ]
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchLoadingTrendByLaneDefault(e);//
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchLoadingTrendByLaneList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCheckLocCd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCheckVvdCd(e);	
			}
		}else if (e.getEventName().equalsIgnoreCase("EesEqr1026Event")) {// Discharge Trend [ EES_EQR_1026 ]
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchDischargeResultDefault(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchDischargeResultList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EesEqr1066Event")) {// Loading Trend By Port [ EES_EQR_1066 ]
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchLoadingTrendByPortDefault(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchLoadingTrendByPortList(e);
			}			
		}
		return eventResponse;
	}
	
	/**
	 * [ EES_EQR_1025 : Loading Trend By Lane List]<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLoadingTrendByLaneDefault(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr1025Event event = (EesEqr1025Event)e; 
		CntrAccuracyTrendBC command = new CntrAccuracyTrendBCImpl();
		
		EesEqr1025ConditionVO condVO = new EesEqr1025ConditionVO();
		
		condVO = event.getEesEqr1025ConditionVO();

		condVO.setOfcCd(account.getOfc_cd());

		try{
			String[] result = command.searchLoadingTrendByLaneDefault(condVO).getResultStrArray();
			condVO.setEtaFmDt(result[0]);
			condVO.setEtaToDt(result[1]);
			condVO.setFmWk(result[2]);
			condVO.setToWk(result[3]);
			condVO.setRccCd(result[4]);
			condVO.setOfcTpCd(result[5]);
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
	 * [ EES_EQR_1025 : Loading Trend By Lane List]<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLoadingTrendByLaneList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr1025Event event = (EesEqr1025Event)e; 
		CntrAccuracyTrendBC command = new CntrAccuracyTrendBCImpl();
		
		EesEqr1025ConditionVO condVO = new EesEqr1025ConditionVO();
		condVO = event.getEesEqr1025ConditionVO();
		
		List<AbstractValueObject> rsVoList = new ArrayList<AbstractValueObject>();

		try{
			CommonRsVO commonRsVO = command.searchLoadingTrendByLaneList(condVO);

			CommonRsVO resultVO = new CommonRsVO();
			
			resultVO.setConditionVO(condVO);
			resultVO.setDbRowset( commonRsVO.getDbRowset() );
			
			rsVoList.add(resultVO);
			
			eventResponse.setRsVoList(rsVoList);
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
	 * 입력 받은 Loaction Code가 LCC/ECC/SCC에 해당하는지 체크<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCheckLocCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr1025Event event = (EesEqr1025Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrAccuracyTrendBC command = new CntrAccuracyTrendBCImpl();
		EesEqr1025ConditionVO condVO = event.getEesEqr1025ConditionVO();
		String check = "";
		
		check = command.searchCheckLocCd(condVO);
		
		eventResponse.setETCData("check", check);
		return eventResponse;		
	}
	
	/**
	 * 입력 받은 VVD CD 유효성 체크<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCheckVvdCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr1025Event event = (EesEqr1025Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrAccuracyTrendBC command = new CntrAccuracyTrendBCImpl();
		EesEqr1025ConditionVO condVO = event.getEesEqr1025ConditionVO();
		String check = "";
		
		check = command.searchCheckVvdCd(condVO);
		
		eventResponse.setETCData("check", check);
		return eventResponse;		
	}
	
	/**
	 * [ EES_EQR_1066 : Loading Trend By Port List]<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLoadingTrendByPortDefault(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr1066Event event = (EesEqr1066Event)e; 
		CntrAccuracyTrendBC command = new CntrAccuracyTrendBCImpl();
		
		EesEqr1066ConditionVO condVO = new EesEqr1066ConditionVO();
		
		condVO = event.getEesEqr1066ConditionVO();

		condVO.setOfcCd(account.getOfc_cd());

		try{
			String[] result = command.searchLoadingTrendByPortDefault(condVO).getResultStrArray();
			condVO.setEtaFmDt(result[0]);
			condVO.setEtaToDt(result[1]);
			condVO.setFmWk(result[2]);
			condVO.setToWk(result[3]);
			condVO.setRccCd(result[4]);
			condVO.setOfcTpCd(result[5]);
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
	 * [ EES_EQR_1066 : Loading Trend By Port List]<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLoadingTrendByPortList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr1066Event event = (EesEqr1066Event)e; 
		CntrAccuracyTrendBC command = new CntrAccuracyTrendBCImpl();
		
		EesEqr1066ConditionVO condVO = new EesEqr1066ConditionVO();
		condVO = event.getEesEqr1066ConditionVO();
		
		List<AbstractValueObject> rsVoList = new ArrayList<AbstractValueObject>();

		try{
			CommonRsVO commonRsVO = command.searchLoadingTrendByPortList(condVO);

			CommonRsVO resultVO = new CommonRsVO();
			
			resultVO.setConditionVO(condVO);
			resultVO.setDbRowset( commonRsVO.getDbRowset() );
			
			rsVoList.add(resultVO);
			
			eventResponse.setRsVoList(rsVoList);
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
	 * [ EES_EQR_1026 : Discharge Result List]<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDischargeResultDefault(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr1026Event event = (EesEqr1026Event)e; 
		CntrAccuracyTrendBC command = new CntrAccuracyTrendBCImpl();
		
		EesEqr1026ConditionVO condVO = new EesEqr1026ConditionVO();
		
		condVO = event.getEesEqr1026ConditionVO();

		condVO.setOfcCd(account.getOfc_cd());

		try{
			String[] result = command.searchDischargeResultDefault(condVO).getResultStrArray();
			condVO.setFmWk(result[0]);
			condVO.setToWk(result[1]);
			condVO.setRccCd(result[2]);
			condVO.setOfcTpCd(result[3]);
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
	 * [ EES_EQR_1026 : Discharge Result List]<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDischargeResultList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr1026Event event = (EesEqr1026Event)e; 
		CntrAccuracyTrendBC command = new CntrAccuracyTrendBCImpl();
		
		EesEqr1026ConditionVO condVO = new EesEqr1026ConditionVO();
		condVO = event.getEesEqr1026ConditionVO();
		
		List<AbstractValueObject> rsVoList = new ArrayList<AbstractValueObject>();

		try{
			CommonRsVO commonRsVO = command.searchDischargeResultList(condVO);

			CommonRsVO resultVO = new CommonRsVO();
			
			resultVO.setConditionVO(condVO);
			resultVO.setDbRowset( commonRsVO.getDbRowset() );
			
			rsVoList.add(resultVO);
			
			eventResponse.setRsVoList(rsVoList);
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