/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChangeOfDestinationMgtSC.java
*@FileTitle : COD Approve Main Screen
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.07.20 김종옥
* 1.0 Creation
*=========================================================
* History
* 2010.07.26 LHJ [Ticket-ID:CHM-201004935] COD application 조회 기능 추가 요청 및 에러 수정건
* 2012.04.05 김민아 [CHM-201217130-01] COD application 승인 화면내 Rehnadling Q"ty를 계산한 Bayplan 정보 칼럼 추가
* 2015.03.06 이병훈 [CHM-201534196] COD charges DVC 비용 관련 로직 수정
*=========================================================*/
package com.hanjin.apps.alps.vop.opf.changeofdestinationmgt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;

import com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.basic.TerminalAgreementManageBC;
import com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.basic.TerminalAgreementManageBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.basic.CODCorrectionBC;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.basic.CODCorrectionBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.CodRehandlingInfoVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.basic.ChangeOfDestinationMgtBC;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.basic.ChangeOfDestinationMgtBCImpl;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.event.VopOpf0033Event;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.event.VopOpf0206Event;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.event.VopOpf0207Event;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration.ChangeOfDestinationMgtDBDAO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.ApprovalInformationVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.BkgCodCostListVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.CODRequestInformationVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.CODRequestListVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.OpfCodDvsFeeBoxBlVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.OpfCodDvsFeeViewVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.OpfCodOldNewPodVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCodCostVO;
import com.hanjin.syscommon.common.table.ComIntgCdDtlVO;
import com.hanjin.syscommon.common.table.MdmCurrencyVO;
import com.hanjin.syscommon.common.table.OpfCodDvsFeeVO;
import com.hanjin.syscommon.common.table.OpfCodRjctCdVO;
import com.hanjin.syscommon.common.table.ScgRgnShpOprCdVO;
import com.hanjin.syscommon.common.util.MessageUtil;

/**
 * ALPS-ChangeOfDestinationMgt Business Logic ServiceCommand - ALPS-ChangeOfDestinationMgt 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Kim Jong Ock
 * @see ChangeOfDestinationMgtDBDAO
 * @since J2EE 1.6
 */

public class ChangeOfDestinationMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ChangeOfDestinationMgt system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("ChangeOfDestinationMgtSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * ChangeOfDestinationMgt system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("ChangeOfDestinationMgtSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-ChangeOfDestinationMgt system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("VopOpf0033Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCODRequestList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {// COMMAND01 -> SEARCH01
				eventResponse= searchRsoCombo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {// COMMAND02 -> SEARCH02
				eventResponse= searchCodCombo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {// Auth Result Combo 2010.07.23 추가 by LHJ
				eventResponse= searchAuthCombo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {// COD Reason Combo 2010.07.23 추가 by LHJ
				eventResponse= searchCodRsnCombo(e);
			} else {
				eventResponse= searchOfcRso(e);  // 화면 Loading시 User Ofice로 RSO Code 찾아오기.2010.07.26 추가 by LHJ
			}
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf0206Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCODDetail(e);
			}
			/*else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse= searchBayPlanCheck(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { 
				eventResponse= searchRehandlingList(e);
			}*/
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse= searchRehandlingCost(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse= searchCurrCdCombo(e);
			}
			/*else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse= searchRehandlingQTY(e);
			}*/
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse= searchRatUtCdCheck(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse= searchRehandlingCalculationList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse= searchRehandlingContainerList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse= searchCODEmailsendList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {// COMMAND01 -> SEARCH01
				eventResponse= searchRsoCombo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {// COMMAND02 -> SEARCH02
				eventResponse= searchCODRejectCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = approveCod(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = modifyCodRgn(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf0207Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDiversionList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCodDivFee(e);
			}
		}
		
		return eventResponse;
	}
	/**
	 * VOP_OPF_0033 : COD Approval<br>
	 * COD Approval을 조회 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCODRequestList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0033Event event = (VopOpf0033Event)e;
		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();

		try{
			List<CODRequestListVO> list = command.searchCODRequestList(event.getChangeOfDestinationMgtConditionVO());
			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0206 : COD Approval Detail at RSO Office<br>
	 * RSO, LANE 별 EMAIL 을 조회 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCODEmailsendList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0206Event event = (VopOpf0206Event)e;
		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();

		try{
			List<CODRequestInformationVO> list = command.searchCODEmailsendList(event.getChangeOfDestinationMgtConditionVO());
				if(list != null && list.size() > 0){
					eventResponse.setETCData("picEml", list.get(0).getPicEml());
				}
			
			if( !event.getChangeOfDestinationMgtConditionVO().getVvd().equals(""))
			{	
			List<CODRequestInformationVO> list1 = command.searchCODCarrierCd(event.getChangeOfDestinationMgtConditionVO());
				if(list1 != null && list1.size() > 0){
					eventResponse.setETCData("carrierCd", list1.get(0).getCarrierCd());
				}
			}			

			List<CODRequestInformationVO> list2 = command.searchCODNewOldPODCd(event.getChangeOfDestinationMgtConditionVO());
			if(list2 != null && list2.size() > 0){ 			
				Map<String,String> etcData = new HashMap<String,String>();
				etcData.put("oldPodCd", ((CODRequestInformationVO)list2.get(0)).getOldPodCd() );
				etcData.put("oldPodFullNm", ((CODRequestInformationVO)list2.get(0)).getOldPodFullNm() );
				etcData.put("newPodCd", ((CODRequestInformationVO)list2.get(0)).getNewPodCd() );
				etcData.put("newPodFullNm", ((CODRequestInformationVO)list2.get(0)).getNewPodFullNm() );	
				
				eventResponse.setETCData(etcData);
			}

			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * VOP_OPF_0033 : COD Approval<br>
	 * RSO 콤보생성을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRsoCombo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0033Event event = (VopOpf0033Event)e;
		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();

		try{
			List<ScgRgnShpOprCdVO> list = command.searchRsoCombo(event.getChangeOfDestinationMgtConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0033 : COD Approval<br>
	 * COD Condition 콤보생성을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCodCombo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0033Event event = (VopOpf0033Event)e;
		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();

		try{
			List<ComIntgCdDtlVO> list = command.searchCodCombo(event.getChangeOfDestinationMgtConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0033 : COD Approval<br>
	 * Auth Result 콤보생성을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAuthCombo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		VopOpf0033Event event = (VopOpf0033Event)e;
		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();

		try{
			List<ComIntgCdDtlVO> list = command.searchAuthCombo();
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * VOP_OPF_0033 : COD Approval<br>
	 * COD Reason 콤보생성을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCodRsnCombo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		VopOpf0033Event event = (VopOpf0033Event)e;
		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();

		try{
			List<ComIntgCdDtlVO> list = command.searchCodRsnCombo();
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0033 : Office Rso<br>
	 * 로그인사용자의 소속오피스에 해당되는 RSO 찾기 <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfcRso(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// VopOpf0033Event event = (VopOpf0033Event)e;
		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();

		try{
			String rso = command.searchOfcRso(account);
			eventResponse.setETCData("rso", rso);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0206 : COD Approval Detail at RSO Office<br>
	 * COD Request Information 을 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCODDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0206Event event = (VopOpf0206Event)e;
		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();

		try{
			//COD Request Information 조회
			List<CODRequestInformationVO> list = command.searchCODDetail(event.getChangeOfDestinationMgtConditionVO());
			eventResponse.setRsVoList(list);
			
			//Approval RSO 조회
			List<ApprovalInformationVO> list2 = command.searchRsoDetail(event.getChangeOfDestinationMgtConditionVO());
			eventResponse.setRsVoList(list2);
			
			List<BkgCodCostVO> list4 = command.searchRehandlingList(event.getChangeOfDestinationMgtConditionVO());
			eventResponse.setRsVoList(list4);
			/**
			//COD Condition 가 Received 일때만 계산 함.
			if(event.getChangeOfDestinationMgtConditionVO().getCod().equals("R")){
				//Bay Plan Check...
				List<ChangeOfDestinationMgtConditionVO> list3 = command.searchBayPlanCheck(event.getChangeOfDestinationMgtConditionVO());
				if( ((ChangeOfDestinationMgtConditionVO)list3.get(0)).getCnt().equals("0")){
					Map<String,String> etcData = new HashMap<String,String>();
					etcData.put("BayPlanCnt", ((ChangeOfDestinationMgtConditionVO)list3.get(0)).getCnt() );
					eventResponse.setETCData(etcData);
					//[2009-09-17] 수정
					//eventResponse.setUserMessage(new ErrorHandler("OPF00024").getUserMessage());
				}else{
					// Freight & Charges for COD 조회
					List<BkgCodCostVO> list4 = command.searchRehandlingList(event.getChangeOfDestinationMgtConditionVO());
					eventResponse.setRsVoList(list4);
					
		        	//[2009-09-17] 수정
			        //if(list4.size() < 1){
					//	eventResponse.setUserMessage(new ErrorHandler("OPF00025").getUserMessage());        	
			        //}
				}
			}else{
				List<BkgCodCostVO> list4 = command.searchRehandlingList(event.getChangeOfDestinationMgtConditionVO());
				eventResponse.setRsVoList(list4);
			}
			**/
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0206 : COD Approval Detail at RSO Office<br>
	 * Approval Information 을 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	/*private EventResponse searchBayPlanCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0206Event event = (VopOpf0206Event)e;
		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();

		try{
			List<ChangeOfDestinationMgtConditionVO> list = command.searchBayPlanCheck(event.getChangeOfDestinationMgtConditionVO());
			Map<String,String> etcData = new HashMap<String,String>();
			etcData.put("BayPlanCnt", ((ChangeOfDestinationMgtConditionVO)list.get(0)).getCnt() );
			eventResponse.setETCData(etcData);
			
			eventResponse.setUserMessage(new ErrorHandler("OPF00003").getUserMessage());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
		}		
		return eventResponse;
	}*/
	
	
	/**
	 * VOP_OPF_0206 : COD Approval Detail at RSO Office<br>
	 * COD Request Information 을 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	/*private EventResponse searchRehandlingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0206Event event = (VopOpf0206Event)e;
		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();

		try{
			List<ChangeOfDestinationMgtConditionVO> list2 = command.searchBayPlanCheck(event.getChangeOfDestinationMgtConditionVO());
		
			if( ((ChangeOfDestinationMgtConditionVO)list2.get(0)).getCnt().equals("0")){
				Map<String,String> etcData = new HashMap<String,String>();
				etcData.put("BayPlanCnt", ((ChangeOfDestinationMgtConditionVO)list2.get(0)).getCnt() );
				eventResponse.setETCData(etcData);
				//[2009-09-17] 수정
				//eventResponse.setUserMessage(new ErrorHandler("OPF00024").getUserMessage());
			}else{
				List<BkgCodCostVO> list = command.searchRehandlingList(event.getChangeOfDestinationMgtConditionVO());
				eventResponse.setRsVoList(list);
				
		        //if(list.size() < 1){
		        	////[2009-09-17] 수정
					//eventResponse.setUserMessage(new ErrorHandler("OPF00025").getUserMessage());        	
		        //}
			}
			//List<BkgCodCostVO> list = command.searchRehandlingList(event.getChangeOfDestinationMgtConditionVO());
			//eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
		}		
		return eventResponse;
	}*/	
	
	/**
	 * VOP_OPF_0206 : Freight & Charges for COD<br>
	 * CHR, CUR, Rate을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRehandlingCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0206Event event = (VopOpf0206Event)e;
		TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
		CODCorrectionBC command1 = new CODCorrectionBCImpl();
		//ChangeOfDestinationMgtBC command2 = new ChangeOfDestinationMgtBCImpl();

		try{
			//BKG에 request 건의 rehandling vvd를 조회한다.
			//String strVvd = command1.searchRehandlingVvd(event.getBkgCodCostListVO().getBkgNo(), event.getBkgCodCostListVO().getCodRqstSeq());
			//event.getBkgCodCostListVO().setVvd(strVvd);
			
			CodRehandlingInfoVO codRehandlingInfoVO = command1.searchRehandlingInfo(event.getBkgCodCostListVO().getBkgNo(), event.getBkgCodCostListVO().getCodRqstSeq());
			event.getBkgCodCostListVO().setVvd(codRehandlingInfoVO.getCodOldNewRhndPortVvdVO().getVvd());
			event.getBkgCodCostListVO().setCodRhndPortCd(codRehandlingInfoVO.getCodOldNewRhndPortVvdVO().getCodRhndPortYdCd());
			
			/*codRehandlingInfoVO.getCodOldNewRhndPortVvdVO();
			List<CodCntrVO> codCntrs = codRehandlingInfoVO.getCodCntrVOs();
		
			for(int i=0; i<codCntrs.size(); i++){
				log.debug("==============ock=="+codRehandlingInfoVO.getCodOldNewRhndPortVvdVO().getCodRhndPortYdCd());
				log.debug("==============ock=="+codCntrs.get(i).getCntrNo());
			}*/			
			
			List<BkgCodCostVO> list = command.searchRehandlingCost(event.getBkgCodCostListVO());
			
			if(list.size() < 1){
				eventResponse.setUserMessage(new ErrorHandler("OPF00004").getUserMessage());
			}else{
				/** 2009-12-23 시작 인정환 수석님 일단 스킵.
				String strCurrCd = ((SearchRehandlingCostVO)list.get(0)).getCurrCd();
				String strRate = ((SearchRehandlingCostVO)list.get(0)).getRate();

				List<BkgCodCostVO> list2 = command2.searchRehandlingRate(event.getChangeOfDestinationMgtConditionVO(), strCurrCd, strRate);
				
				Map<String,String> etcData = new HashMap<String,String>();
				etcData.put("etcChgCd", ((BkgCodCostVO)list2.get(0)).getChgCd() );
				etcData.put("etcCurrCd", ((BkgCodCostVO)list2.get(0)).getCurrCd() );
				etcData.put("etcChgUtAmt", ((BkgCodCostVO)list2.get(0)).getChgUtAmt() );
				2009-12-23 끝 **/

				Map<String,String> etcData = new HashMap<String,String>();
				etcData.put("etcCurrCd", ((BkgCodCostVO)list.get(0)).getCurrCd() );
				etcData.put("etcChgUtAmt", ((BkgCodCostVO)list.get(0)).getChgUtAmt() );
				
				eventResponse.setETCData(etcData);
			}	
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Freight & Charges for COD"}).getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * VOP_OPF_0206 : Freight & Charges for COD<br>
	 * Row Add 시 CHR, CUR, Rate을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	/*private EventResponse searchRehandlingQTY(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0206Event event = (VopOpf0206Event)e;
		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();
		TerminalAgreementManageBC command2 = new TerminalAgreementManageBCImpl();
		boolean bbBlan = false;
		try{
			List<BkgCodCostVO> list = command.searchRehandlingQTY(event.getChangeOfDestinationMgtConditionVO());
			//eventResponse.setRsVoList(list);
			if(list.size() < 1){
				eventResponse.setUserMessage(new ErrorHandler("OPF00004").getUserMessage());
			}else{
				//getCgoCateCd() 'BB' Type이 존재하면 'Re-Handling 물량 중 Awkward Container가 존재하여 COD가 불가합니다.' MSG Display
				for(int i=0; i<list.size(); i++){
					if("BB".equals(((BkgCodCostVO)list.get(i)).getCgoCateCd())){
						bbBlan = true;
					}else{
						bbBlan = false;
					}
				}
				
				if(bbBlan){
					eventResponse.setUserMessage(new ErrorHandler("OPF00005").getUserMessage());
				}else{
					Map<String,String> etcData = new HashMap<String,String>();
	
					event.getChangeOfDestinationMgtConditionVO().setTpsz(((BkgCodCostVO)list.get(0)).getRatUtCd());
					etcData.put("etcCgoCateCd", ((BkgCodCostVO)list.get(0)).getCgoCateCd() );
					
					//List<SearchRehandlingCostVO> list2 = command2.searchRehandlingCost(event.getChangeOfDestinationMgtConditionVO());
					
					//if(list2.size() < 1){
					//	eventResponse.setUserMessage(new ErrorHandler("OPF00004").getUserMessage());
					//}else{
					//	String strCurrCd = ((SearchRehandlingCostVO)list2.get(0)).getCurrCd();
					//	String strRate = ((SearchRehandlingCostVO)list2.get(0)).getRate();
						
						//
						//List<BkgCodCostVO> list3 = command.searchRehandlingRate(event.getChangeOfDestinationMgtConditionVO(), strCurrCd, strRate);
						
						//etcData.put("etcChgCd", ((BkgCodCostVO)list3.get(0)).getChgCd() );
						//etcData.put("etcCurrCd", ((BkgCodCostVO)list3.get(0)).getCurrCd() );
						//etcData.put("etcChgUtAmt", ((BkgCodCostVO)list3.get(0)).getChgUtAmt() );
						//

						//etcData.put("etcChgCd", "RLO" );
						//etcData.put("etcCurrCd", strCurrCd );
						//etcData.put("etcChgUtAmt", strRate );

						//etcData.put("etcRatUtCd", ((BkgCodCostVO)list.get(0)).getRatUtCd());
						//etcData.put("etcRatAsQty", ((BkgCodCostVO)list.get(0)).getRatAsQty());

						//etcData.put("etcChgAmt",  Integer.toString(Integer.parseInt(strRate) * Integer.parseInt(((BkgCodCostVO)list.get(0)).getRatAsQty())));
					//}

					eventResponse.setETCData(etcData);
				}
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Freight & Charges for COD"}).getMessage(), ex);
		}		
		return eventResponse;
	}*/
		
	/**
	 * VOP_OPF_0206 : Freight & Charges for COD<br>
	 * CNTR Type/SIZE시 유효성 체크를 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRatUtCdCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0206Event event = (VopOpf0206Event)e;
		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();
		
		try{
			List<BkgCodCostVO> list = command.searchRatUtCdCheck(event.getChangeOfDestinationMgtConditionVO());
			if(list.size() < 1){
				eventResponse.setUserMessage(new ErrorHandler("OPF00002", new String[]{"CNTR Type/SIZE"}).getUserMessage());
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Freight & Charges for COD"}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * VOP_OPF_0206 : COD Approval Detail at RSO Office<br>
	 * Reject Reason 콤보생성을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCODRejectCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0206Event event = (VopOpf0206Event)e;
		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();

		try{
			List<OpfCodRjctCdVO> list = command.searchCODRejectCodeList(event.getChangeOfDestinationMgtConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * VOP_OPF_0206 : COD Approval Detail at RSO Office<br>
	 * Freight & Charges for COD에 CUR 콤보생성을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCurrCdCombo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0206Event event = (VopOpf0206Event)e;
		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();

		try{
			List<MdmCurrencyVO> list = command.searchCurrCdCombo(event.getChangeOfDestinationMgtConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0206 : Retrieve<br>
	 * Calculation 시 Freight & Charges for COD을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchRehandlingCalculationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0206Event event = (VopOpf0206Event)e;
		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();
		CODCorrectionBC command1 = new CODCorrectionBCImpl();
		//TerminalAgreementManageBC command2 = new TerminalAgreementManageBCImpl();
		boolean bbBlan = false;
		
		List<BkgCodCostVO> listVO = new ArrayList<BkgCodCostVO>();
		
		try{
			List<OpfCodOldNewPodVO> oldNewPodList = command.searchOldNewPodCntr(event.getChangeOfDestinationMgtConditionVO());
			
			if (oldNewPodList.size() == 0) {
				eventResponse.setUserMessage("This BKG No is not COD target.");
				eventResponse.setETCData("applied_bayplan_vvd", "");
				eventResponse.setETCData("applied_bayplan_port", "");
			} else if (oldNewPodList.get(0).getOldPodClptSeq() == null || oldNewPodList.get(0).getNewPodClptSeq() == null || "".equals(oldNewPodList.get(0).getOldPodClptSeq()) || "".equals(oldNewPodList.get(0).getNewPodClptSeq())) {
				eventResponse.setUserMessage("This BKG No is not COD target.");
				eventResponse.setETCData("applied_bayplan_vvd", "");
				eventResponse.setETCData("applied_bayplan_port", "");
			} else {
				int oldPodClptSeq = Integer.parseInt(oldNewPodList.get(0).getOldPodClptSeq());
				int newPodClptSeq = Integer.parseInt(oldNewPodList.get(0).getNewPodClptSeq());
				
				// New POD가 Old POD 보다 이후인 경우 - Bayplan 적용 안 함
				if (oldPodClptSeq < newPodClptSeq) {
				//	List<OpfCodDvsFeeBoxBlVO> opfCodDvsFeeBoxBlVOs = null;
					BkgCodCostVO vo = new BkgCodCostVO();
					
				//	event.getChangeOfDestinationMgtConditionVO().setCurrCd("");
					//opfCodDvsFeeBoxBlVOs = command.searchCodDiversionFeeList(event.getChangeOfDestinationMgtConditionVO());
					
					// DVC 셋팅
					vo.setCodRqstSeq(event.getChangeOfDestinationMgtConditionVO().getCodRqstSeq());
					vo.setChgCd("DVC");
					vo.setCostCdRqstSeq("1");
					vo.setCurrCd("");
					//vo.setChgUtAmt(opfCodDvsFeeBoxBlVOs.get(0).getDvsFeeAmtBoxBl());
					vo.setChgUtAmt("");
					vo.setBkgNo(event.getChangeOfDestinationMgtConditionVO().getBkgNo());
					vo.setCgoCateCd("DR");
					listVO.add(vo);
					
					// RLO 셋팅
					// TES Rehandling Cost 조회하기 위한 파라메터 셋팅
					List<BkgCodCostListVO> list = new ArrayList<BkgCodCostListVO>();
					BkgCodCostListVO bkgCodCostListVO = null;
					for (int i = 1; i < oldNewPodList.size(); i++) {
						bkgCodCostListVO = new BkgCodCostListVO();
						bkgCodCostListVO.setBkgNo(event.getChangeOfDestinationMgtConditionVO().getBkgNo());
						bkgCodCostListVO.setChgCd("RLO");
						bkgCodCostListVO.setRatUtCd(oldNewPodList.get(i).getCntrTpszCd());
						bkgCodCostListVO.setRatAsQty(oldNewPodList.get(i).getCntrQty());
						bkgCodCostListVO.setCgoCateCd("DR");
						bkgCodCostListVO.setCodRqstSeq(event.getChangeOfDestinationMgtConditionVO().getCodRqstSeq());
						bkgCodCostListVO.setCntrCgoTpCd("F");
						bkgCodCostListVO.setVvd(event.getChangeOfDestinationMgtConditionVO().getVvd());
						bkgCodCostListVO.setCodRhndPortCd(event.getChangeOfDestinationMgtConditionVO().getCodRhndPortCd());
						list.add(bkgCodCostListVO);
					}
					// RLO Cost 정보를 가져오기 위해 TES Rehandling Cost 조회
					List list2 = command.searchRehandlingCost(list);
					for (int i = 0; i < list2.size(); i++) {
						List<BkgCodCostVO> voList = (List<BkgCodCostVO>) list2.get(i);
						listVO.addAll(voList);
					}
					
					eventResponse.setRsVoList(listVO);
					eventResponse.setETCData("applied_bayplan_vvd", "");
					eventResponse.setETCData("applied_bayplan_port", "");
					
				// New POD가 Old POD 보다 이전인 경우 - Bayplan 적용
				} else {
					CodRehandlingInfoVO codRehandlingInfoVO = command1.searchRehandlingInfo(event.getChangeOfDestinationMgtConditionVO().getBkgNo(), event.getChangeOfDestinationMgtConditionVO().getCodRqstSeq());
					//List<OpfCodDvsFeeBoxBlVO> opfCodDvsFeeBoxBlVOs = null;
					
					List<BkgCodCostListVO> list = command.searchRehandlingQTY(event.getChangeOfDestinationMgtConditionVO(), codRehandlingInfoVO);
					if(list.size() < 1){
						/* R/H 발생하지 않으면 (BayPlan에 QTY가 존재하지 않는 경우) */
						BkgCodCostVO vo = new BkgCodCostVO();
						
						event.getChangeOfDestinationMgtConditionVO().setCurrCd("");
					//	opfCodDvsFeeBoxBlVOs = command.searchCodDiversionFeeList(event.getChangeOfDestinationMgtConditionVO());                                                                                                                                                                                                                                                         
						
						vo.setCodRqstSeq(event.getChangeOfDestinationMgtConditionVO().getCodRqstSeq());
						vo.setChgCd("DVC");
						vo.setCostCdRqstSeq("1");
						vo.setCurrCd("");
					//	vo.setChgUtAmt(opfCodDvsFeeBoxBlVOs.get(0).getDvsFeeAmtBoxBl());
						vo.setChgUtAmt("");
						vo.setBkgNo(event.getChangeOfDestinationMgtConditionVO().getBkgNo());
						vo.setCgoCateCd("DR");
						
						listVO.add(vo);
						eventResponse.setRsVoList(listVO);
						eventResponse.setETCData("applied_bayplan_vvd", "");
						eventResponse.setETCData("applied_bayplan_port", "");
						
					}else{
						//getCgoCateCd() 'BB' Type이 존재하면 'Re-Handling 물량 중 Awkward Container가 존재하여 COD가 불가합니다.' MSG Display
						for(int i=0; i<list.size(); i++){
							if("BB".equals(((BkgCodCostListVO)list.get(i)).getCgoCateCd())){
								bbBlan = true;
							}else{
								bbBlan = false;
							}
						}
						
						if(bbBlan){
							eventResponse.setUserMessage(new ErrorHandler("OPF00005").getUserMessage());
						}else{
							List list2 = command.searchRehandlingCost(list);
							//log.debug("searchRehandlingCost-2");
							List<BkgCodCostVO> dvcList = new ArrayList<BkgCodCostVO>();
							List<BkgCodCostVO> rhCostList = (List<BkgCodCostVO>) list2.get(0);	
							if(rhCostList.size() < 1){
								event.getChangeOfDestinationMgtConditionVO().setCurrCd("");
							//	opfCodDvsFeeBoxBlVOs = command.searchCodDiversionFeeList(event.getChangeOfDestinationMgtConditionVO());
								
								/* R/H 발생하지 않으면 (BayPlan에 QTY는 존재하지만 TES에 COST가 존재하지 않는 경우) */
								BkgCodCostVO vo = new BkgCodCostVO();
								vo.setCodRqstSeq(event.getChangeOfDestinationMgtConditionVO().getCodRqstSeq());
								vo.setChgCd("DVC");
								vo.setCostCdRqstSeq("1");
								vo.setCurrCd("");
							//	vo.setChgUtAmt(opfCodDvsFeeBoxBlVOs.get(0).getDvsFeeAmtBoxBl());
								vo.setChgUtAmt("");
								vo.setRatAsQty("1");
								vo.setRatUtCd(list.get(0).getRatUtCd());
								vo.setCntrCgoTpCd(list.get(0).getCntrCgoTpCd());
								vo.setBkgNo(event.getChangeOfDestinationMgtConditionVO().getBkgNo());
								vo.setCgoCateCd(list.get(0).getCgoCateCd());
								dvcList.add(vo);
								
								vo = new BkgCodCostVO();
								event.getChangeOfDestinationMgtConditionVO().setCurrCd(list.get(0).getCurrCd());
								//opfCodDvsFeeBoxBlVOs = command.searchCodDiversionFeeList(event.getChangeOfDestinationMgtConditionVO());
								vo.setCodRqstSeq(event.getChangeOfDestinationMgtConditionVO().getCodRqstSeq());
								vo.setChgCd("RLO");
								vo.setCostCdRqstSeq("2");
								vo.setCurrCd(list.get(0).getCurrCd());							
								vo.setRatAsQty(list.get(0).getRatAsQty());
								vo.setRatUtCd(list.get(0).getRatUtCd());
								vo.setCntrCgoTpCd(list.get(0).getCntrCgoTpCd());
								vo.setBkgNo(event.getChangeOfDestinationMgtConditionVO().getBkgNo());
								vo.setCgoCateCd(list.get(0).getCgoCateCd());
								dvcList.add(vo);
								
								listVO.addAll(dvcList);
								
							//	opfCodDvsFeeBoxBlVOs.get(0).getDvsFeeAmtBoxBl();
								eventResponse.setUserMessage(new ErrorHandler("OPF00004").getUserMessage());
							}else{
							
								for(int i=0; i<list2.size(); i++){
									List<BkgCodCostVO> voList = (List<BkgCodCostVO>) list2.get(i);							
									event.getChangeOfDestinationMgtConditionVO().setCurrCd(voList.get(0).getCurrCd());
								//	opfCodDvsFeeBoxBlVOs = command.searchCodDiversionFeeList(event.getChangeOfDestinationMgtConditionVO());							
									
									//for(OpfCodDvsFeeBoxBlVO d : opfCodDvsFeeBoxBlVOs){
										BkgCodCostVO vo = new BkgCodCostVO();
										vo.setCodRqstSeq(event.getChangeOfDestinationMgtConditionVO().getCodRqstSeq());
										vo.setChgCd("DVC");
										vo.setCurrCd("");
										vo.setCostCdRqstSeq("1");								
										//vo.setChgUtAmt(d.getDvsFeeAmtBoxBl());
										vo.setChgUtAmt("");
										vo.setRatAsQty("1");
										vo.setRatUtCd(list.get(0).getRatUtCd());
										vo.setCntrCgoTpCd(list.get(0).getCntrCgoTpCd());
										vo.setBkgNo(event.getChangeOfDestinationMgtConditionVO().getBkgNo());
										vo.setCgoCateCd(list.get(0).getCgoCateCd());
										dvcList.add(vo);
										listVO.addAll(dvcList);
								  //break;
									//}
									break;
								}
								for(int i=0; i<list2.size(); i++){	
									List<BkgCodCostVO> voList = (List<BkgCodCostVO>) list2.get(i);							
									for(BkgCodCostVO vo : voList){								
										event.getChangeOfDestinationMgtConditionVO().setCurrCd(vo.getCurrCd());
										//opfCodDvsFeeBoxBlVOs = command.searchCodDiversionFeeList(event.getChangeOfDestinationMgtConditionVO());
										
									//	String rhCharge = vo.getChgUtAmt();
									//	String dvsFeeAmt = null;
									//	if("USD".equals(vo.getCurrCd())){
									//		dvsFeeAmt = "";
									//	} else {
									//		dvsFeeAmt = "";
									//	}
										
									//	Double chgUtAmt =  0D;
										
										//if("M".equals(opfCodDvsFeeBoxBlVOs.get(0).getContiCd())){
											//vo.setChgUtAmt(String.valueOf(NumberUtils.toDouble(rhCharge)));
											vo.setChgUtAmt("");
									//	} else {
										//	if(NumberUtils.toDouble(rhCharge) > NumberUtils.toDouble(dvsFeeAmt)){
											//	chgUtAmt = NumberUtils.toDouble(rhCharge);										
											//} else {
										//		chgUtAmt = NumberUtils.toDouble(opfCodDvsFeeBoxBlVOs.get(0).getDvsFeeAmt());
												vo.setCurrCd("");
										//	}									
										//	vo.setChgUtAmt(String.valueOf(chgUtAmt));
									//		vo.setChgUtAmt("");
									//	}								
										vo.setRatAsQty(vo.getRatAsQty());
										vo.setRatUtCd(vo.getRatUtCd());
										vo.setCntrCgoTpCd(vo.getCntrCgoTpCd());
										listVO.addAll(voList);
									}
								}
							}
							
						}
						eventResponse.setRsVoList(listVO);
						eventResponse.setETCData("applied_bayplan_vvd", list.get(0).getVvd());
						eventResponse.setETCData("applied_bayplan_port", list.get(0).getPort());
					}
				}
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Freight & Charges for COD"}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * VOP_OPF_0206 : Retrieve<br>
	 * CNTR Q'ty 팝업 클릭시 Container NO.을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRehandlingContainerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0206Event event = (VopOpf0206Event)e;
		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();
		CODCorrectionBC command1 = new CODCorrectionBCImpl();
		
		StringBuffer sbuf = new StringBuffer();
		
		try{
			//BKG에 request 건의 rehandling vvd를 조회한다.
			CodRehandlingInfoVO codRehandlingInfoVO = command1.searchRehandlingInfo(event.getChangeOfDestinationMgtConditionVO().getBkgNo(), event.getChangeOfDestinationMgtConditionVO().getCodRqstSeq());

			Map<String,String> etcData = new HashMap<String,String>();

			List<BkgCodCostListVO> list = command.searchRehandlingContainerList(event.getChangeOfDestinationMgtConditionVO(), codRehandlingInfoVO);
			if(list.size()>0){
				sbuf.append("CNTR NO.      CNTR CON.   PORT    POSITION"+"\n");
				sbuf.append("-----------------------------------------------------------------"+"\n");
			}
			for(int i=0; i<list.size(); i++){
				sbuf.append(list.get(i).getCntr()+"      ");
				sbuf.append(list.get(i).getCgoCateCd()+"         ");
				sbuf.append(list.get(i).getPort()+"     ");
				sbuf.append(list.get(i).getPosition()+"\n");
			}
			
			etcData.put("etcContainerList", sbuf.toString());
			eventResponse.setETCData(etcData);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Freight & Charges for COD"}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * VOP_OPF_0207 : COD Tariff Registration<br>
	 * Region COD MIN. Tariff 을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDiversionList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0207Event event = (VopOpf0207Event)e;
		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();

		try{
			List<OpfCodDvsFeeVO> list = command.searchDiversionList(event.getChangeOfDestinationMgtConditionVO());
			List<OpfCodDvsFeeViewVO> list2 = command.searchDiversionViewList(event.getChangeOfDestinationMgtConditionVO());
			
			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(list2);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Tariff Registration"}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * VOP_OPF_0207 : COD Tariff Registration<br>
	 * SHA Tide Information Creation 을 저장 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCodDivFee(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0207Event event = (VopOpf0207Event)e;
 		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();
		try{ 
			begin();
			command.manageCodDivFee(event.getOpfCodDvsFeeVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();			
        } catch (EventException ex) {
        	log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
        	log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"COD Tariff Registration"}).getMessage(), ex);
        }

		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0206 : COD Approval Detail at RSO Office<br>
	 * OK 버튼 클릭시 BKG --> 승인/거절 처리 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse approveCod(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0206Event event = (VopOpf0206Event)e;
		CODCorrectionBC command = new CODCorrectionBCImpl();
		
		String sndNm = "";
		String sndrId = "";
		String rcvNm = "";
		String rcvrId = "";
		String content = "";
		
		try{
			begin();
			//Auth Result 가 Y, N 일때만
			if( event.getCodAuthVO().getAuthflag().equals("Y") ||  event.getCodAuthVO().getAuthflag().equals("N") ){
				sndNm = event.getCODNoticeVO().getSndrUsrNm();
				sndrId = event.getCODNoticeVO().getSndrUsrId();
				rcvNm = event.getCODNoticeVO().getRcvrUsrNm();
				rcvrId = event.getCODNoticeVO().getRcvrUsrId();
				content = event.getCODNoticeVO().getMsgCtnt();
				
				MessageUtil msess = new MessageUtil();
				msess.messageInsert(sndNm, sndrId, rcvNm, rcvrId, content);
			}
	
			command.approveCod(event.getCodAuthVO(), event.getBkgCodCostVOS(), "", account);
			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
        	log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
        	log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
        }
		return eventResponse;
	}	
	
	/**
	 * VOP_OPF_0206 : COD Approval Detail at RSO Office<br>
	 * Update 버튼 클릭시 BKG --> RSO UPDATE 처리 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyCodRgn(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0206Event event = (VopOpf0206Event)e;
		CODCorrectionBC command = new CODCorrectionBCImpl();
		try{
			begin();
			command.modifyCodRgn(event.getBkgCodVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
        	log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
        	log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
        }
		return eventResponse;
	}	
		
}