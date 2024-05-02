/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpacecontrolinquirySC.java
*@FileTitle : spacecontrolinquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.10 한상훈
* 1.0 Creation
* 2010.08.25 최윤성 [CHM-201005492-01] RDR 실적 Summary 기능 개발 - 2010년 시스템 개발 계획
* 2010.08.26 김민아 [CHM-201005553-01] RDR 실적 중 POL/POD 세부 Data Download 기능 개발 - 메소드 추가
* 2010.10.19 최윤성 [CHM-201006585-01] 2010년 연간개발계획 - full+empty L/F summary 화면 개발.
* 2011.11.22 김종준 [CHM-201007116] Weekly L/F by POL/POD 화면 - 기능추가 개발
* 2011.05.19 최성민 [CHM-201110711-01] Inquiry by Trade 화면 보완
* 2011.06.01 김종준 [CHM-201110708-01] F"cast 입력 요청 메세지 송부 기능
* 2011.07.26 김종준 [SRM-201118467] Daily F"cast Status 화면 alloc display 보완 searchUserRoleYn 메소드 추가
* 2011.10.12 김종준 [CHM-201113896-01] Login Office가 ISTSC인 경우에는 Origin Office가 아닌 Login Office가 Loading Office와 일치할 경우 Alloc 이 조회될 수 있도록 수정 요청
* 2011.11.10 김종준 [CHM-201114445-01] f"cast history 화면 RGN Office 창 활성화
* 2012.12.04 최윤성 [CHM-201221640-01] FCST&PFMC by ACCT 신규 탭 추가
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2013.10.30 최윤성 [CHM-201327083-01] IPC Sector 판매 활성화 Tool 개발 - Space Utilization 화면 신규 개발 
* 2016.05.12 이혜민 [CHM-201640880] T/S History 개발 요청
* 2016.07.14 이혜민 [CHM-201642304]  T/S Plan & Guide 기능 Logic 수정 
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.spc.common.SPCUtil;
import com.hanjin.apps.alps.esm.spc.common.common.basic.CommonBC;
import com.hanjin.apps.alps.esm.spc.common.common.basic.CommonBCImpl;
import com.hanjin.apps.alps.esm.spc.common.common.vo.CommonCodeVO;
import com.hanjin.apps.alps.esm.spc.common.common.vo.SearchOfficeCondVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.basic.SpacecontrolinquiryBC;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.basic.SpacecontrolinquiryBCImpl;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0021Event;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0022Event;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0024Event;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0026Event;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0028Event;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0029Event;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0056Event;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0057Event;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0058Event;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0080Event;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0081Event;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0082Event;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0083Event;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0084Event;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0085Event;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0086Event;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0087Event;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0088Event;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration.SpacecontrolinquiryDBDAO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ComplexMainVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ExcelDownSpaceUtilizationLaneListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ExcelDownSpaceUtilizationPortListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiry021SusrLaneViewListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceUtilizationListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchTsPlanGuideListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchWeeklyLfByPolPodListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SpaceControlInquiryVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SpcBsaMgmtVO;


/**
 * ALPS-Spacecontrolinquiry Business Logic ServiceCommand - ALPS-Spacecontrolinquiry 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Han Sang Hoon
 * @see SpacecontrolinquiryDBDAO
 * @since J2EE 1.6
 */

public class SpacecontrolinquirySC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * Spacecontrolinquiry system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("SpacecontrolinquirySC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * Spacecontrolinquiry system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("SpacecontrolinquirySC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-Spacecontrolinquiry system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmSpc0021Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {           // F'cast Comparison
				eventResponse = searchSpaceControlInquiry021FcastPortViewList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) {    // Adjusted allocation status
				eventResponse = searchSpaceControlInquiry021AllocPortViewList2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {    // Allocation Status(HO)
				eventResponse = searchSpaceControlInquiry021AllocPortViewList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST08)) {    // USR_ROLE_CD 가져오기
				eventResponse = searchUserRoleYn(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {           // 2012.01.19 SHKIM
				eventResponse = searchSpaceControlInquiry021SusrLaneUpdate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST09)) {    // 2012.01.19 SHKIM
				eventResponse = searchSpaceControlInquiry021SusrLaneViewList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)) {	    // PFMC Ration vs QTA & BSA 
				eventResponse = searchSpaceControlInquiry021PfmcRatio(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)) {     // Allocation Status(RHQ)
				eventResponse = searchSpaceControlInquiry021AllocPortViewList3(e);
			// add 2012.08.08.
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST12)) {     // BKG Status(RHQ)
				eventResponse = searchSpaceControlInquiry021AllocPortViewList4(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST13)) {     // Alloc&PFMC status by S.REP
				eventResponse = searchSpaceControlInquiry021AllocPortViewList5(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST14)) {     // FCST&BKG PFMC by S.Office
				eventResponse = searchSpaceControlInquiry021AllocPortViewList6(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST15)) {	    //	FCST&PFMC by ACCT
				eventResponse = searchSpaceControlInquiry021FcstPfmcAcctViewList(e);
			}else
				eventResponse = searchSpaceAllocationOfficeCond(e);
		}
		else if(e.getEventName().equalsIgnoreCase("EsmSpc0022Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchSpaceControlInquiryTradeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchSpaceControlInquirySalesOrgList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchSpaceControlInquiryPolPodList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {
				eventResponse = searchSpaceControlInquiryCustomerList(e);//by Shipper
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) {
				eventResponse = searchSpaceControlInquiryContractor(e);
			}
			else {
				//기존 searchSpaceAllocationOfficeCond()를 포함하고 있음.
				eventResponse = searchSpaceControlComboList(e);
			}
		}
		else if(e.getEventName().equalsIgnoreCase("EsmSpc0024Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchSpaceControlInquiryNoShowSummaryList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchSpaceControlInquiryNoShowTradeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchSpaceControlInquiryNoShowOfficeLaneList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {
				eventResponse = searchSpaceControlInquiryNoShowLaneOfficeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) {
				eventResponse = searchSpaceControlInquiryNoShowSubOfficeList(e);
			}
			else
				eventResponse = searchSpaceAllocationOfficeCond(e);
		}
		else if(e.getEventName().equalsIgnoreCase("EsmSpc0028Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchSpaceControlInquiryOfficeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchSpaceControlInquiryOfficeSalesOrgList(e);
			}
			else
				eventResponse = searchSpaceAllocationOfficeCond(e);
		}
		else if(e.getEventName().equalsIgnoreCase("EsmSpc0056Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchSpaceControlTsVolumnList(e);
			}
		}
		else if(e.getEventName().equalsIgnoreCase("EsmSpc0026Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchSpaceControlInquiryList(e);
			}else{
				eventResponse = searchSpaceAllocationOfficeCond(e);
			}	
			
		}
		else if(e.getEventName().equalsIgnoreCase("EsmSpc0080Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchSpaceControlRDRSummaryList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchSpaceControlRDRSummaryDown(e);
			}else{
				eventResponse = searchSpaceAllocationOfficeCond(e);
			}	
			
		}
		else if(e.getEventName().equalsIgnoreCase("EsmSpc0081Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchSpaceControlInquiryRDRDetailList(e);
			}
		}
		else if(e.getEventName().equalsIgnoreCase("EsmSpc0082Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchSpaceControlLFSummaryList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchSpaceControlLFSummaryDown(e);
			}else{
				eventResponse = searchSpaceAllocationOfficeCond(e);
			}	
			
		}
		else if(e.getEventName().equalsIgnoreCase("EsmSpc0083Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchWeeklyLfByPolPodList(e);
			} else if  (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchMonthWeekList(e);
			}
		}
		else if(e.getEventName().equalsIgnoreCase("EsmSpc0084Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSpaceContorlInquiryBSA(e);
			} else if  (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiSpaceContorlInquiryBSA(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmSpc0029Event")) {
		    if  (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createSendMail(e);
			}
			else
				eventResponse = searchSpaceAllocationOfficeCond(e);
		}
		else if (e.getEventName().equalsIgnoreCase("EsmSpc0085Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchSpcTeamQtaRtoList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchSpcTeamQtaRtoList(e);
			}else if  (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiSpcTeamQtaRtos(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmSpc0086Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSpcTgtVvdList(e);
			}else if  (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiSpcTgtVvdList(e);
			}else if  (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = checkVvd(e);
			}
		}
		else if(e.getEventName().equalsIgnoreCase("EsmSpc0057Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchSpaceUtilizationList(e);
			}  else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = excelDownSpaceUtilizationPort(e);
			}  else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = excelDownSpaceUtilizationLane(e);
			}
		}
		
		else if (e.getEventName().equalsIgnoreCase("EsmSpc0058Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchSpaceControlInquiry058VVDList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchSpaceControlInquiry058QtyList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchSpaceControlInquiry058VVDInfo(e);
			}
		}
		
		else if (e.getEventName().equalsIgnoreCase("EsmSpc0087Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchTsPlanGuideMainList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchTsPlanGuideDetailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchTsPlanGuideValidData(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {
				eventResponse = searchSpaceControlTSComboList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) {
				eventResponse = searchTsPlanGuideVvdRlane(e);
			}  else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST06)) {
				eventResponse = searchTsPlanGuideDupVvd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageTsPlanGuideMainList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageTsPlanGuideDetailList(e);
			}
		}
		
		else if (e.getEventName().equalsIgnoreCase("EsmSpc0088Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTsPlanGuideAtchList(e); 
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageTsPlanGuideAtch(e);
			}
		}
		
		
		return eventResponse;
	}

	/**
	 * ESM_SPC_0086 : [VVD Change] 
	 *  입력된 항차를 확인한다.
	 *  
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse checkVvd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0086Event event = (EsmSpc0086Event)e;
		CommonBC command = new CommonBCImpl();
		try{
			boolean chkVvd = command.checkVvd(event.getVvd());
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData.put("isExist",chkVvd?"Y":"N");
			eventResponse.setETCData(etcData);				
		}catch(EventException ex){
			
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SPC_0085 : [Retrieve] 
	 *  한국지점 팀별 QTA RATIO를 조회한다.
	 *  
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchSpcTeamQtaRtoList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0085Event event = (EsmSpc0085Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			log.error("searchSpcTeamQtaRtoList............");
			List<ComplexMainVO> rsVoList = command.searchSpcTeamQtaRtoList(event.getConditionVO());
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand(event.getConditionVO().getType().equals("Q")?"SEARCHLIST01":"SEARCHLIST02");
			}
			
			log.error("risVoList : " + rsVoList.size());
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
	 * ESM_SPC_0085 : [Save] 
	 *  한국지점 팀별 QTA RATIO를 저장한다.
	 *  
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse multiSpcTeamQtaRtos(Event e) throws EventException {
		EsmSpc0085Event event = (EsmSpc0085Event)e;
    	SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();     	
        GeneralEventResponse eventResponse = new GeneralEventResponse();
 
        try {
            begin();
            command.multiSpcTeamQtaRtos( event.getSpcTeamQtaRtoVOs() , this.account);             
            eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
            commit();
           
        } catch (EventException ex) {
        	rollback();
            log.error("error "+ex.toString(), ex);            
            throw ex;
        } catch (Exception ex) {
            rollback();
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }

        return eventResponse;
	}

	/**
	 * ESM_SPC_0086 : [Save] 
	 *  Report에서 조회할 VVD List를 저장한다.
	 *  
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse multiSpcTgtVvdList(Event e) throws EventException {
		EsmSpc0086Event event = (EsmSpc0086Event)e;
    	SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();     	
        GeneralEventResponse eventResponse = new GeneralEventResponse();
 
        try {
            begin();
            command.multiSpcTgtVvdList( event.getSpcTgtVvdVOs() , this.account);             
            eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
            commit();
           
        } catch (EventException ex) {
        	rollback();
            log.error("error "+ex.toString(), ex);            
            throw ex;
        } catch (Exception ex) {
            rollback();
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }

        return eventResponse;
	}

	/**
	 * ESM_SPC_0086 : [Retrieve] <br>
	 * 	Report에서 조회할 VVD List를 조회한다.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchSpcTgtVvdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0086Event event = (EsmSpc0086Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{			
			List<ComplexMainVO> rsVoList = command.searchSpcTgtVvdList(event.getSearchSpaceControlInquiryConditionVO());
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCH");
			}
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
	 * ESM_SPC_0021 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchSpaceControlInquiry021PfmcRatio(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0021Event event = (EsmSpc0021Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		String ui_name = e.getEventName().substring(0, 10);
		try{			
			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiry021PfmcRatio(event.getSearchSpaceControlInquiryConditionVO(), account, ui_name);
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST10");
			}
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
	 * ESM_SPC_0021 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlInquiry021FcastPortViewList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0021Event event = (EsmSpc0021Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiry021FcastPortViewList(event.getSearchSpaceControlInquiryConditionVO());
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST01");
			}
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
	 * ESM_SPC_0021 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlInquiry021AllocPortViewList2(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0021Event event = (EsmSpc0021Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		String ui_name = e.getEventName().substring(0, 10);
		try{			
			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiry021AllocPortViewList2(event.getSearchSpaceControlInquiryConditionVO(), account, ui_name);
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST05");
			}
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
	 * ESM_SPC_0021 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * SHKIM 20120613
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlInquiry021AllocPortViewList3(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0021Event event = (EsmSpc0021Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		String ui_name = e.getEventName().substring(0, 10);
		try{			
			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiry021AllocPortViewList3(event.getSearchSpaceControlInquiryConditionVO(), account, ui_name);
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST11");
			}
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
	 * ESM_SPC_0021 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlInquiry021AllocPortViewList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0021Event event = (EsmSpc0021Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			String ui_name = e.getEventName().substring(0, 10);
			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiry021AllocPortViewList(event.getSearchSpaceControlInquiryConditionVO(), account, ui_name);
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST03");
			}
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
	 * ESM_SPC_0021 : [이벤트]<br>
	 * [SPC_USR_LANE_INFO 저장된]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlInquiry021SusrLaneViewList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0021Event event = (EsmSpc0021Event)e;
		
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			String ui_name = e.getEventName().substring(0, 10);
			List<SearchSpaceControlInquiry021SusrLaneViewListVO> rsVoList = command.searchSpaceControlInquiry021SusrLaneViewList(event.getSearchSpaceControlInquiry021SusrLaneViewListVO(), account, ui_name);
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST09");
			}
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
	 * ESM_SPC_0021 : [이벤트]<br>
	 * [SPC_USR_LANE_INFO]을 [삭제후 저장]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlInquiry021SusrLaneUpdate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0021Event event = (EsmSpc0021Event)e;
		
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			begin();
			String ui_name = e.getEventName().substring(0, 10);
			command.searchSpaceControlInquiry021SusrLaneUpdate(event.getSearchSpaceControlInquiry021SusrLaneViewListVO(), account, ui_name);
			//eventResponse.setUserMessage((String) new ErrorHandler("COM12191",new String[]{"IAS SUB"}).getUserMessage());
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
			//command.addCarriersList(event.getBzcAgmtCrrVOs(),account);
		    /* 
			if ("".equals(rtnVal)){
				eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
				commit();
			}else{
				rollback();
			}     
			*/
			commit();
			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
		return eventResponse;
	}
	/**
	 * ESM_SPC_0022 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlInquiryTradeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0022Event event = (EsmSpc0022Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiryTradeList(event.getSearchSpaceControlInquiryConditionVO());
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST01");
			}
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
	 * ESM_SPC_0022 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlInquirySalesOrgList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0022Event event = (EsmSpc0022Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquirySalesOrgList(event.getSearchSpaceControlInquiryConditionVO());
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST02");
			}
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
	 * ESM_SPC_0022 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlInquiryPolPodList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0022Event event = (EsmSpc0022Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiryPolPodList(event.getSearchSpaceControlInquiryConditionVO());
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST03");
			}
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
	 * ESM_SPC_0022 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlInquiryCustomerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0022Event event = (EsmSpc0022Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiryCustomerList(event.getSearchSpaceControlInquiryConditionVO(), account);
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST04");
			}
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
	 * ESM_SPC_0022 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlInquiryContractor(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0022Event event = (EsmSpc0022Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiryContractor(event.getSearchSpaceControlInquiryConditionVO());
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST05");
			}
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
	 * ESM_SPC_0024 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlInquiryNoShowSummaryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0024Event event = (EsmSpc0024Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiryNoShowSummaryList(event.getSearchSpaceControlInquiryConditionVO());
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST01");
			}
			
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
	 * ESM_SPC_0024 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlInquiryNoShowTradeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0024Event event = (EsmSpc0024Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiryNoShowTradeList(event.getSearchSpaceControlInquiryConditionVO());
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST02");
			}
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
	 * ESM_SPC_0024 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlInquiryNoShowOfficeLaneList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0024Event event = (EsmSpc0024Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiryNoShowOfficeLaneList(event.getSearchSpaceControlInquiryConditionVO());
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST03");
			}
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
	 * ESM_SPC_0024 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlInquiryNoShowLaneOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0024Event event = (EsmSpc0024Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiryNoShowLaneOfficeList(event.getSearchSpaceControlInquiryConditionVO());
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST04");
			}
			eventResponse.setRsVoList(rsVoList);
			
		}catch(EventException ex){
			
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	/**
	 * ESM_SPC_0024 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlInquiryNoShowSubOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0024Event event = (EsmSpc0024Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiryNoShowSubOfficeList(event.getSearchSpaceControlInquiryConditionVO());
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST05");
			}
			eventResponse.setRsVoList(rsVoList);
			
		}catch(EventException ex){
			
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0028 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlInquiryOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0028Event event = (EsmSpc0028Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiryOfficeList(event.getSearchSpaceControlInquiryConditionVO());
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST01");
			}
			eventResponse.setRsVoList(rsVoList);
			
		}catch(EventException ex){
			
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0028 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlInquiryOfficeSalesOrgList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0028Event event = (EsmSpc0028Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiryOfficeSalesOrgList(event.getSearchSpaceControlInquiryConditionVO());
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST02");
			}
			eventResponse.setRsVoList(rsVoList);
			
		}catch(EventException ex){
			
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0056 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlTsVolumnList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0056Event event = (EsmSpc0056Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			List<ComplexMainVO> rsVoList = command.searchSpaceControlTsVolumnList(event.getSearchSpaceControlInquiryConditionVO());
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST");
			}
			eventResponse.setRsVoList(rsVoList);
			
		}catch(EventException ex){
			
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
		
	/**
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceAllocationOfficeCond(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC command = new CommonBCImpl();
		
		try{
			List<SearchOfficeCondVO> list = command.searchOfficeCond(e, account);
			if(list.size() > 0){
				SearchOfficeCondVO searchOfficeCondVO = list.get(0);
				eventResponse.setETCData(searchOfficeCondVO.getColumnValues());
			}
		}catch(EventException ex){
			
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUserRoleYn(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC command = new CommonBCImpl();
		try{
			String ui_name = e.getEventName().substring(0, 10);
			List<SearchOfficeCondVO> list = command.searchUserRoleYn(e, account, ui_name);
			if(list.size() > 0){
				SearchOfficeCondVO searchOfficeCondVO = list.get(0);

				Map<String,String> etcData = new HashMap<String,String>();
				
				etcData.put("usrRoleYn",searchOfficeCondVO.getUsrRoleYn());
				eventResponse.setETCData(etcData);				
			}
		}catch(EventException ex){
			
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
		
	
	/**
	 * ESM_SPC_0026 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0026Event event = (EsmSpc0026Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{

			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiryList(event.getConditionVO());
	
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST02");
			}
			eventResponse.setRsVoList(rsVoList);
			eventResponse.setETCData("sataus", "OK");
		
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0080 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * 2010.08.25 CHOI.Y.S - Ticket ID : CHM-201005492 - RDR 실적 Summary 기능 개발 - 메소드 추가
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlRDRSummaryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0080Event event = (EsmSpc0080Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		
		try{

			List<ComplexMainVO> rsVoList = command.searchSpaceControlRDRSummaryList(event.getConditionVO());
			eventResponse.setRsVoList(rsVoList);
			eventResponse.setETCData("sataus", "OK");
		
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0080 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * 2010.08.25 CHOI.Y.S - Ticket ID : CHM-201005492 - RDR 실적 Summary 기능 개발 - 메소드 추가
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlRDRSummaryDown(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0080Event event = (EsmSpc0080Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		
		try{

			List<ComplexMainVO> rsVoList = command.searchSpaceControlRDRSummaryDown(event.getConditionVO());
			eventResponse.setRsVoList(rsVoList);
			eventResponse.setETCData("sataus", "OK");
		
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/*=====================================================================================
	 * 2010.08.26 김민아 [CHM-201005553-01] RDR 실적 중 POL/POD 세부 Data Download 조회 메소드 추가
	 *=====================================================================================*/
	/**
	 * ESM_SPC_0081 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlInquiryRDRDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0081Event event = (EsmSpc0081Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{

			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiryRDRDetailList(event.getConditionVO());
	
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST");
			}
			eventResponse.setRsVoList(rsVoList);
			eventResponse.setETCData("sataus", "OK");
		
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0082 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * 2010.10.19 최윤성 [CHM-201006585-01] 2010년 연간개발계획 - full+empty L/F summary 화면 개발.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlLFSummaryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0082Event event = (EsmSpc0082Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		
		try{

			List<ComplexMainVO> rsVoList = command.searchSpaceControlLFSummaryList(event.getConditionVO());
			eventResponse.setRsVoList(rsVoList);
			eventResponse.setETCData("sataus", "OK");
		
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0082 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * 2010.10.19 최윤성 [CHM-201006585-01] 2010년 연간개발계획 - full+empty L/F summary 화면 개발.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlLFSummaryDown(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0082Event event = (EsmSpc0082Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		
		try{

			List<ComplexMainVO> rsVoList = command.searchSpaceControlLFSummaryDown(event.getConditionVO());
			eventResponse.setRsVoList(rsVoList);
			eventResponse.setETCData("sataus", "OK");
		
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
		
	/**
	 * ESM_SPC_0083 : Weekly L/F by POL/POD 리스트를 조회<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWeeklyLfByPolPodList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0083Event event = (EsmSpc0083Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{

			List<ComplexMainVO> rsVoList = command.searchWeeklyLfByPolPodList(event.getConditionVO());
	
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST");
			}
			eventResponse.setRsVoList(rsVoList);
			eventResponse.setETCData("sataus", "OK");
		
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0083 : 달,주헤더 Retrieve <br>
	 * 주어진 기간의 주차목록을 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthWeekList(Event e) throws EventException {
		EsmSpc0083Event event = (EsmSpc0083Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();

		List<SearchWeeklyLfByPolPodListVO> searchWeeklyLfByPolPodListVOS = command.searchMonthWeekList(event.getConditionVO() );
		String totBaseDt = "";
		if(searchWeeklyLfByPolPodListVOS.size() > 0) {
			for ( int i=0; i<searchWeeklyLfByPolPodListVOS.size(); i++) {	//헤더 주차를 만든다.
				if ( i == searchWeeklyLfByPolPodListVOS.size()-1) {
					totBaseDt = totBaseDt+searchWeeklyLfByPolPodListVOS.get(i).getCostYrwk().substring(0, 4)+searchWeeklyLfByPolPodListVOS.get(i).getCostYrwk().substring(4, 6);
				} else {
					totBaseDt = totBaseDt+searchWeeklyLfByPolPodListVOS.get(i).getCostYrwk().substring(0, 4)+searchWeeklyLfByPolPodListVOS.get(i).getCostYrwk().substring(4, 6)+"|";
				}
			}
		}
		Map<String,String> etcData = new HashMap<String,String>();
		etcData.put("bse_dt",totBaseDt);
		
		eventResponse.setETCData(etcData);
		return eventResponse;
		
	}
	
	/**
	 * ESM_SPC_0084 : BSA INPUT DATA 리스트를 조회<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceContorlInquiryBSA(Event e) throws EventException {	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0084Event event = (EsmSpc0084Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			List<SpcBsaMgmtVO> rsVoList = command.searchSpaceContorlInquiryBSA(event.getSpcBsaMgmtVO());
			eventResponse.setRsVoList(rsVoList);		
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
    /**
     * ESM_SPC_0084 : Save
     * D : [EsmSpc0084Event]<br>
     * BSA INPUT DATA를 저장합니다.<br>
     * 
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author JongKyu Weon
     */
    private EventResponse multiSpaceContorlInquiryBSA(Event e) throws EventException {
    	EsmSpc0084Event event = (EsmSpc0084Event)e;
    	SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();     	
        GeneralEventResponse eventResponse = new GeneralEventResponse();
 
        try {
            begin();
            command.multiSpaceContorlInquiryBSA( event.getSpcBsaMgmtVOS() , this.account);             
            eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage());
            commit();
           
        } catch (EventException ex) {
        	rollback();
            log.error("error "+ex.toString(), ex);            
            throw ex;
        } catch (Exception ex) {
            rollback();
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }

        return eventResponse;
    }
    
	/**
	 * ESM_SPC_XXXX : Open<br>
	 * Combo Data를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlComboList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC command = new CommonBCImpl();
        CommonCodeVO vo = new CommonCodeVO();
        List<CommonCodeVO> list = new ArrayList<CommonCodeVO>();

		try{
			List<SearchOfficeCondVO> plist = command.searchOfficeCond(e, account);
			if(plist.size() > 0){
				SearchOfficeCondVO searchOfficeCondVO = plist.get(0);
				eventResponse.setETCData(searchOfficeCondVO.getColumnValues());
			}

			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int week = c.get(Calendar.WEEK_OF_YEAR) - 1;
			
			/* 
			 * 2010.12.28  이행지 [CHM-201008010-01][SPC]주차 Tag Library 수정
			 * 마지막 주차에 1월의 날짜가 겹쳐 자바 Calendar에서 1주차로 인식되는 경우가 있어 예외처리.
			 */
			if ( c.getActualMaximum(Calendar.MONTH) == c.get(Calendar.MONTH)
				&& c.get(Calendar.WEEK_OF_YEAR) == 1){
				c.add(Calendar.WEEK_OF_YEAR, -1);
				week = c.get(Calendar.WEEK_OF_YEAR) ;
			}
			
			eventResponse.setETCData("T_YEAR", year+"");
			eventResponse.setETCData("T_WEEK", (week < 10 ? "0" : "") + week);
			
			// YEAR
			list = command.searchComboBoxYearList();
			eventResponse.setCustomData("YEAR", list);

			// WEEK
            list = command.searchComboBoxWeekList();
            eventResponse.setCustomData("WEEK", list);
            
			// RHQ
			vo.setMethod("RHQ");
			list = command.searchCommonComboList(vo);
			eventResponse.setCustomData("RHQ", list);
			 
			// Trade
			vo.setMethod("Trade");
			vo.setIsRepTrade("");
			list = command.searchCommonComboList(vo);
			eventResponse.setCustomData("TRADE", list);

			// SubTrade
			vo.setMethod("SubTrade");
			vo.setIsRepTrade("");
			vo.setIsAll("");
			list = command.searchCommonComboList(vo);
			eventResponse.setCustomData("SUBTRADE", list);
			
			// RLane
			vo.setMethod("RLane");
			vo.setIpc("true"); 
			list = command.searchCommonComboList(vo);
			eventResponse.setCustomData("RLANE", list);

			// Bound
			vo.setSn("Y");
			list = command.searchComboBoxBoundList(vo);
			eventResponse.setCustomData("BOUND", list);

			// OCN/IPC
			vo.setMethod("CommonCode");
			vo.setCode("CD00206");
			list = command.searchCommonComboList(vo);
			eventResponse.setCustomData("OCNIPC", list);
			
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("COM12203",new String[]{}).getMessage(), ex);
	    }
		return eventResponse;
	}
	
	   /**
     * ESM_SPC_0029: Send Message
     * F'cast 입력 요청 메세지 송부 기능 이벤트 처리<br>
     * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse createSendMail(Event e) throws EventException {
    	EsmSpc0029Event event = (EsmSpc0029Event)e;
    	SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {                  
            eventResponse.setETCData("BackEndJobKey", command.createSendMail(event.getSearchSpaceControlInquiryConditionVO(), account));            
        }catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
	    }	    
        return eventResponse;
    } 
	
    /**
	 * ESM_SPC_0021 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * SHKIM 20120613
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlInquiry021AllocPortViewList4(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0021Event event = (EsmSpc0021Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		String ui_name = e.getEventName().substring(0, 10);
		try{	
			
		
			
			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiry021AllocPortViewList4(event.getSearchSpaceControlInquiryConditionVO(), account, ui_name);
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST12");
			}
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
	 * ESM_SPC_0021 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlInquiry021AllocPortViewList5(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0021Event event = (EsmSpc0021Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		String ui_name = e.getEventName().substring(0, 10);
		try{	
			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiry021AllocPortViewList5(event.getSearchSpaceControlInquiryConditionVO(), account, ui_name);
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST13");
			}
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
	 * ESM_SPC_0021 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlInquiry021AllocPortViewList6(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0021Event event = (EsmSpc0021Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		String ui_name = e.getEventName().substring(0, 10);
		try{	
			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiry021AllocPortViewList6(event.getSearchSpaceControlInquiryConditionVO(), account, ui_name);
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST14");
			}
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
	 * ESM_SPC_0021 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlInquiry021FcstPfmcAcctViewList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0021Event event = (EsmSpc0021Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		
		try{	
			List<ComplexMainVO> rsVoList = command.searchSpaceControlInquiry021FcstPfmcAcctViewList(event.getSearchSpaceControlInquiryConditionVO(), account);
			if(rsVoList.size() > 0){
				rsVoList.get(0).setEventCommand("SEARCHLIST15");
			}
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
	 * ESM_SPC_0057 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceUtilizationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0057Event event = (EsmSpc0057Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		
		try{
			List<SearchSpaceUtilizationListVO> rsVoList = command.searchSpaceUtilizationList(event.getSearchSpaceControlInquiryConditionVO());
			eventResponse.setRsVoList(rsVoList);
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * [ESM_SPC_0057] : Raw Data Export 이벤트 처리<br>
	 * Sheet 에 보여주지 않고 필수 조회조건에 해당하는 전체 Data Excel Down 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse excelDownSpaceUtilizationPort(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0057Event event = (EsmSpc0057Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		
		try {
			List<ExcelDownSpaceUtilizationPortListVO> list = command.excelDownSpaceUtilizationPort(event.getSearchSpaceControlInquiryConditionVO(), account);
			
			String headTitle    = "VVD￠OCN-IPC-T/S￠Area￠Load Office￠POL￠POD￠QTA-Load￠QTA-CMB￠CMB-TEU￠CMB-WGT￠Forecast-Total TEU￠Forecast-WT(M/T)￠Allocation-Total TEU￠Allocation-WT(M/T)￠Booking-Total TEU￠Booking-WT(M/T)";
			String column_names = "vvd￠ioc_cd￠area_cd￠ofc_cd￠pol_cd￠pod_cd￠qta_load￠qta_cmb￠cmb_teu￠cmb_wgt￠forecast_total_teu￠forecast_wgt￠allocation_total_teu￠allocation_wgt￠booking_total_teu￠booking_wgt"; 
			
			String title[]   = headTitle.split("￠");
			String columns[] = column_names.split("￠");
			
			eventResponse.setCustomData("vos", list);
			eventResponse.setCustomData("title", title);
			eventResponse.setCustomData("columns", columns);
			eventResponse.setCustomData("fileName", "SpaceUtilization_Port.xls");
			eventResponse.setCustomData("isZip", false);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	
	/**
	 * [ESM_SPC_0057] : Raw Data Export 이벤트 처리<br>
	 * Sheet 에 보여주지 않고 필수 조회조건에 해당하는 전체 Data Excel Down 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse excelDownSpaceUtilizationLane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0057Event event = (EsmSpc0057Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		
	try {
		
			List<ExcelDownSpaceUtilizationLaneListVO> list = command.excelDownSpaceUtilizationLane(event.getSearchSpaceControlInquiryConditionVO(), account);
			
			String headTitle    = "BASE_VVD￠PORT_CD￠PORT_SEQ￠OCN-IPC-T/S￠POD_CD￠POD_SEQ￠LOD_TTL￠AVG_CMPB￠DIS_TTL￠ON_TTL￠LOAD_CAPA￠BSA￠UTIL_RATIO";
			String column_names = "base_vvd￠port_cd￠port_seq￠ioc_cd￠pod_cd￠pod_seq￠lod_ttl￠avg_cmpb￠dis_ttl￠on_ttl￠load_capa￠bsa￠util_ratio"; 
			
			String title[]   = headTitle.split("￠");
			String columns[] = column_names.split("￠");
			
			eventResponse.setCustomData("vos", list);
			eventResponse.setCustomData("title", title);
			eventResponse.setCustomData("columns", columns);
			eventResponse.setCustomData("fileName", "SpaceUtilization_Lane.xls");
			eventResponse.setCustomData("isZip", false);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	
	/**
	 * ESM_SPC_0058 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlInquiry058VVDList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0058Event event = (EsmSpc0058Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			List<SpaceControlInquiryVO> list = command.searchSpaceControlInquiry058VVDList(event.getConditionVO());
			list.get(0).setEventCommend("SEARCHLIST01");
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
	 * ESM_SPC_0058 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlInquiry058VVDInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0058Event event = (EsmSpc0058Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			event.getConditionVO().setOfcCd(account.getOfc_cd());
			List<SpaceControlInquiryVO> list = command.searchSpaceControlInquiry058VVDInfo(event.getConditionVO());
			list.get(0).setEventCommend("SEARCHLIST03");
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
	 * ESM_SPC_0045 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlInquiry058QtyList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0058Event event = (EsmSpc0058Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		try{
			List<SpaceControlInquiryVO> list = command.searchSpaceControlInquiry058QtyList(event.getConditionVO());
			list.get(0).setEventCommend("SEARCHLIST02");
			log.debug(list.get(0));
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
	 * ESM_SPC_0087 : [Retrieve]<br>
	 * [T/S Plan & guide main list]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTsPlanGuideMainList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0087Event event = (EsmSpc0087Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		
		try{
			List<SearchTsPlanGuideListVO> list = command.searchTsPlanGuideMainList(event.getConditionVO());
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
	 * ESM_SPC_0087 : [Save] 전<br>
	 * [T/S Plan & guide Main]을 [저장] 전에 VSK 와 겹치는 목록이 있는지 확인한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */  	
	private EventResponse searchTsPlanGuideDupVvd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0087Event event = (EsmSpc0087Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		SearchTsPlanGuideListVO[] searchTsPlanGuideListVOs = event.getSearchTsPlanGuideListVOS();

		try{
			String[] dupData = command.searchTsPlanGuideDupVvd(searchTsPlanGuideListVOs); 
			if(dupData != null){
				eventResponse.setETCData("vvd_cd",  		dupData[0]);
				eventResponse.setETCData("irr_port_cd", 	dupData[1]);
				eventResponse.setETCData("irr_yd_cd",  		dupData[2]);
				eventResponse.setETCData("crr_cd",  		dupData[3]);
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0087 : [Save]<br>
	 * [T/S Plan & guide Main]을 [저장]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */  	
	private EventResponse manageTsPlanGuideMainList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0087Event event = (EsmSpc0087Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		SearchTsPlanGuideListVO[] searchTsPlanGuideListVOs = event.getSearchTsPlanGuideListVOS();

		try{
			begin();
			command.manageTsPlanGuideMainList(searchTsPlanGuideListVOs,account); 
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
	 * ESM_SPC_0087 : [Sheet1 Dbl Click]<br>
	 * [T/S Plan & guide detail list]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTsPlanGuideDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0087Event event = (EsmSpc0087Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		
		try{
			List<SearchTsPlanGuideListVO> list = command.searchTsPlanGuideDetailList(event.getSearchTsPlanGuideListVO());
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
	 * ESM_SPC_0087 : [Sheet1,2 onChange]<br>
	 * [T/S Plan & guide vvd에 맞는 Sub trade, lane, BD, Week, Operator, Yard, ETD, Lane]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTsPlanGuideValidData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0087Event event = (EsmSpc0087Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		
		try{
			String searchTp = event.getSearchTsPlanGuideListVO().getSearchTp();
			String[] validData = command.searchTsPlanGuideValidData(event.getSearchTsPlanGuideListVO());
			if(searchTp.equals("1")){
				eventResponse.setETCData("rep_trd_cd",  	validData[0]);
				eventResponse.setETCData("rep_sub_trd_cd", 	validData[1]);
				eventResponse.setETCData("dir_cd",  		validData[2]);
				eventResponse.setETCData("cost_wk",  		validData[3]);
				eventResponse.setETCData("crr_cd",  		validData[4]);
			}else if(searchTp.equals("2")){
				eventResponse.setETCData("yd_cd",   validData[0]);
				eventResponse.setETCData("slan_cd", validData[1]);
				eventResponse.setETCData("etd_dt",  validData[2]);
			}
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
	 * ESM_SPC_0087 : [Save]<br>
	 * [T/S Plan & guide Detail]을 [저장]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */  	
	private EventResponse manageTsPlanGuideDetailList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0087Event event = (EsmSpc0087Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		SearchTsPlanGuideListVO[] searchTsPlanGuideListVOs = event.getSearchTsPlanGuideListVOS();

		try{
			begin();
			command.manageTsPlanGuideDetailList(searchTsPlanGuideListVOs,account); 
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
	 * ESM_SPC_0088 : [Load Page]<br>
	 * [T/S Plan & guide Attach list]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */    
	private EventResponse searchTsPlanGuideAtchList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0088Event event = (EsmSpc0088Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();

		try{
			List<SearchTsPlanGuideListVO> list = command.searchTsPlanGuideAtchList(event.getSearchTsPlanGuideListVO());
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
	 * ESM_SPC_0088 : [upload]<br>
	 * [T/S Plan & guide Attach]을 [저장]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */  	
	private EventResponse manageTsPlanGuideAtch(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0088Event event = (EsmSpc0088Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		SearchTsPlanGuideListVO[] searchTsPlanGuideListVOs = event.getSearchTsPlanGuideListVOS();

		try{
			begin();
			command.manageTsPlanGuideAtch(searchTsPlanGuideListVOs,account); 
			commit();

			eventResponse.setUserMessage(new ErrorHandler("COM12191",new String[]{"Data"}).getUserMessage());  //Data saved successfully.

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
	 * ESM_SPC_0087 : [Sheet1 Loading, onChange]<br>
	 * [T/S Plan & guide 에서 Skip 또는 Phase Out Type에 맞는 Reason code]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceControlTSComboList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0087Event event = (EsmSpc0087Event)e;
		
		String skdCngStsCd = event.getSearchTsPlanGuideListVO().getSkdCngStsCd();
		if("S".equals(skdCngStsCd)){
			eventResponse.setETCData("code", SPCUtil.comnCodeList("CD01830", "onlycode"));
			eventResponse.setETCData("code_desc", SPCUtil.comnCodeList("CD01830", "onlyname"));
		}else if("O".equals(skdCngStsCd)||"I".equals(skdCngStsCd)){
			eventResponse.setETCData("code", SPCUtil.comnCodeList("CD01819", "onlycode"));
			eventResponse.setETCData("code_desc", SPCUtil.comnCodeList("CD01819", "onlyname"));
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0087 : [Sheet1 onChange]<br>
	 * [T/S Plan & guide vvd에 맞는 Rlane 목록]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTsPlanGuideVvdRlane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0087Event event = (EsmSpc0087Event)e;
		SpacecontrolinquiryBC command = new SpacecontrolinquiryBCImpl();
		
		try{
			List<SearchTsPlanGuideListVO> list = command.searchTsPlanGuideVvdRlane(event.getSearchTsPlanGuideListVO());
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
