/*=========================================================
*Copyright(c) 2009 CyberLogitec  
*@FileName : LongstayingUnclaimEQMgtSC.java
*@FileTitle : Container Staying Days (Summary)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.07.09 김종준
* 1.0 Creation
* =========================================================
* 2010.09.07 남궁진호 [CHM-201005814-01] 소스품질 결함 조치
*            사용하지않는 VO객체 제거,List<vo >공백제거
* 2012.09.19 신자영 [CHM-201220003-01] L/S U/C CREATION - COR DRAFT 기능 개발
* 
* 2014.04.07 김창영 [HJSBIZ_CR_45] 장비 과부족현황 Mailing 기능개발
* 2014.07.09 김도현 [CHM-201430725] UC Inquiry, UC Activity, UC File Upload 관련 개발추가 
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.basic.CIMCommonBC;
import com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.basic.CIMCommonBCImpl;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.basic.CNTRInventoryReportBC;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.basic.CNTRInventoryReportBCImpl;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtCodeCommonVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.basic.LongstayingUnclaimEQFlaggingBC;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.basic.LongstayingUnclaimEQFlaggingBCImpl;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event.EesCim0021Event;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event.EesCim0022Event;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event.EesCim0024Event;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event.EesCim0025Event;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event.EesCim0041Event;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event.EesCim0042Event;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event.EesCim0044Event;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event.EesCim0060Event;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event.EesCim0061Event;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event.EesCim0062Event;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event.EesCim1951Event;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration.LongstayingUnclaimEQFlaggingDBDAO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.CntrFdayListVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.EQBalanceReportInputListVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.FlaggingListSmryVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.LongStayUclmDetailVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.MailingServiceSettingListVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.OPInventoryForPseudoBookingDetailVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.OPInventoryForPseudoBookingSummayVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.SDaysLisDetailVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.SDaysListSmryVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.basic.UncollectedCargoBC;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.basic.UncollectedCargoBCImpl;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.event.EesCim0063Event;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.event.EesCim0064Event;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.event.EesCim0065Event;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.event.EesCim0066Event;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.event.EesCim0070Event;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.event.EesCim0071Event;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.event.EesCim0072Event;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.CodeVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.SearchUncollectedCargoFileVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.SearchUncollectedGlMonXchRtListVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.SearchUncollectedVolDtlListVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.UncollectedCargoAuthorizerVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.UncollectedCargoVO;
import com.hanjin.apps.alps.ees.lse.lsecommon.leaseterm.basic.LeaseTermBC;
import com.hanjin.apps.alps.ees.lse.lsecommon.leaseterm.basic.LeaseTermBCImpl;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBC;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MstLseTermVO;

/**
 * ALPS-LongstayingUnclaimEQMgt Business Logic ServiceCommand - ALPS-LongstayingUnclaimEQMgt 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author kim jong jun
 * @see LongstayingUnclaimEQFlaggingDBDAO
 * @since J2EE 1.6
 */

public class LongstayingUnclaimEQMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * LongstayingUnclaimEQMgt system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("LongstayingUnclaimEQMgtSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * LongstayingUnclaimEQMgt system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("LongstayingUnclaimEQMgtSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-LongstayingUnclaimEQMgt system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = new GeneralEventResponse();
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EesCim0021Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSDaysListSmry(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCommon02List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSDaysListByMvmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchSDaysListTotalDays(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {	//Location 코드 체크
				eventResponse = checkLocation(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCim1951Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOPInventoryForPseudoBookingList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
			    eventResponse = searchOPInventoryForPseudoBookingDetailList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCim0044Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSDaysListDetail(e);
			}			
		} else if (e.getEventName().equalsIgnoreCase("EesCim0041Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSDaysListTotalDaysByMvmt(e);
			}			
		} else if (e.getEventName().equalsIgnoreCase("EesCim0042Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSDaysListTotalDaysDetail(e);
			}			
		} else if (e.getEventName().equalsIgnoreCase("EesCim0022Event")) {
			log.debug("EesCim0022Event 시작");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFlaggingTargetList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCommon02List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkLocation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCorDraft(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchRcvDelCodeList(e);	
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageFlagging(e);
			}			
		} else if (e.getEventName().equalsIgnoreCase("EesCim0024Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFlaggingStatusList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCommon02List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkLocation(e);
			}			
		} else if (e.getEventName().equalsIgnoreCase("EesCim0025Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCntrFdayList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCommon02List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkLocation(e);
			}	
		} else if (e.getEventName().equalsIgnoreCase("EesCim0060Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = mainSearchEQBalanceReportInputList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = preSearchEQBalanceReport(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSubContiCd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchLccCd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchEccCd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageEQBalanceReportInput(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCim0061Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = mainSearchEQBalanceReportInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = preSearchEQBalanceReport(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSubContiCd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchLccCd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchEccCd(e);
			} 
		} else if (e.getEventName().equalsIgnoreCase("EesCim0062Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = mainSearchMailingServiceSettingList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageMailingServiceSetting(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCim0063Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUncollectedCargoCreation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComboCodeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	
				eventResponse = checkNewUCCaseNo(e);							
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {	// B/L No Validation Check
				eventResponse = checkBLNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {	// Branch/Agent Validation Check
				eventResponse = checkAgent(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {	// RHQ Validation Check
				eventResponse = checkRHQ(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {	// HANDLER Validation Check
				eventResponse = checkHandler(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {	// B/L No Validation Check2
				eventResponse = checkBLNo2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {	// B/L No Validation Check2
				eventResponse = searchUncollectedCargoCreationBlInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {	// B/L No Validation Check2
				eventResponse = checkOfcHandlerMatch(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {	// B/L No Validation Check2
				eventResponse = checkOfAuthority(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {	// B/L No Validation Check2
				eventResponse = checkBLNo3(e);	
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				// Case1_MULTI   :  UC Case NO 가 없는 경우  => Master : input, Detail : input
				eventResponse = manageUncollectedCargoCreation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				// Case2_MULTI01 :  UC Case NO 가 있는 경우(기존 Seq 변경)  => Master : update, Detail : update
				eventResponse = manageUncollectedCargoCreation01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				// Case3_MULTI02 :  UC Case NO 가 있는 경우(Seq 추가 후 변경)  => Master input, Detail input
				eventResponse = manageUncollectedCargoCreation02(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				// Case3_MULTI03 :   Counter Office 의 Branch/Agent 의 경우 3가지 항목만 수정가능 => Master update, Detail update
				eventResponse = manageUncollectedCargoCreation03(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				// Case3_MULTI04 :   Reopen 만 저장하는 경우 Status 코드 값을 OS로 변경 저장
				eventResponse = manageUncollectedCargoCreation04(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				// Case3_MULTI04 :   관리자의 메모를 저장한다.
				eventResponse = manageUncollectedCargoCreation05(e);
			} else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = checkOfcCd(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EesCim0064Event")) {	// UC Inquiry
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {  
				eventResponse = searchUncollectedInquiryList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCim0066Event")) {	// UC Activity
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchUncollectedCargoFileList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01) ){
				eventResponse = manageUncollectedCargoFile(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EesCim0065Event")) {	// UC File Upload
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUploadFileInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = createUploadFileInfoCOM(e);
				eventResponse = createUploadFileInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeUploadFilesCOM(e);
				eventResponse = removeUploadFiles(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCim0070Event")) {	// UC-VOL_DTL
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchUncollectedVolDtlList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCim0071Event")) {	// Help Exchange
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchUncollectedGlMonXchRtList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCurrCdCombo(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EesCim0072Event")) {	// Help Exchange
		    if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
			    eventResponse = searchUncollectedCargoAuthorizer(e);
		    } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
		    	eventResponse = checkAuthorizerInputId(e);
 		    } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
       			eventResponse = manageUncollectedCargoAuthorizer(e);
			}
	}
		return eventResponse;
	}
	
	/**
	 * EES_CIM_0021 : Retrieve<br>
	 * Full/ MTY 컨테이너의 장기체류 현황을 지역별,EQ TP&SZ별로 체류 기간을 구분하여 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSDaysListSmry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0021Event event = (EesCim0021Event)e;
		LongstayingUnclaimEQFlaggingBC command = new LongstayingUnclaimEQFlaggingBCImpl();

		try{
			List<SDaysListSmryVO> list = command.searchSDaysListSmry(event.getFlaggingSDaysOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_CIM_0021 : Retrieve<br>
	 * Full/ MTY 컨테이너의 장기체류 현황을 지역별,MVMT Status 별, EQ TP&SZ별로 체류 기간을 구분하여 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSDaysListByMvmt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0021Event event = (EesCim0021Event)e;
		LongstayingUnclaimEQFlaggingBC command = new LongstayingUnclaimEQFlaggingBCImpl();
		try{
			List<SDaysListSmryVO> list = command.searchSDaysListByMvmt(event.getFlaggingSDaysOptionVO ());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;		
	}	

	/**
	 * EES_CIM_0021 : Retrieve<br>
	 * 조회시점에 체류하고 있는 컨테이너의 과거 MVMT History를 조회하여, 지역별, EQ TP&SZ로  MVMT Status 를 분류하여 체류   일수를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSDaysListTotalDays(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0021Event event = (EesCim0021Event)e;
		LongstayingUnclaimEQFlaggingBC command = new LongstayingUnclaimEQFlaggingBCImpl();
		try{
			List<SDaysListSmryVO> list = command.searchSDaysListTotalDays(event.getFlaggingSDaysOptionVO ());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;		
	}	
	
	/**
	 * EES_CIM_0044 : Retrieve<br>
	 * Full/ MTY 장기체화 장비의 BKG 및 Movement 정보등을 컨테이너 번호별로 일괄적으로 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSDaysListDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0044Event event = (EesCim0044Event)e;
		LongstayingUnclaimEQFlaggingBC command = new LongstayingUnclaimEQFlaggingBCImpl();
		try{
			List<SDaysLisDetailVO> list = command.searchSDaysListDetail(event.getFlaggingSDaysOptionVO ());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;		
	}		
	
	/**
	 * EES_CIM_0041 : Retrieve<br>
	 * 컨테이너 번호별로 Total S/Days의 체류일수를 CNTR MVMT Status별 체류일수를 집계하여 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSDaysListTotalDaysByMvmt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0041Event event = (EesCim0041Event)e;
		LongstayingUnclaimEQFlaggingBC command = new LongstayingUnclaimEQFlaggingBCImpl();
		try{
			List<SDaysLisDetailVO> list = command.searchSDaysListTotalDaysByMvmt(event.getFlaggingSDaysOptionVO ());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;		
	}	
	
	/**
	 * EES_CIM_0042 : Retrieve<br>
	 * “Total S/Days” 현황을 컨테이너별 “최초반입일시/야드” 및 “현 MVMT 및 Yard 정보”등을 포함하여 체류일수를 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSDaysListTotalDaysDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0042Event event = (EesCim0042Event)e;
		LongstayingUnclaimEQFlaggingBC command = new LongstayingUnclaimEQFlaggingBCImpl();
		try{
			List<SDaysLisDetailVO> list = command.searchSDaysListTotalDaysDetail(event.getFlaggingSDaysOptionVO ());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;		
	}	
	
	/**
	 * 각화면 공통 lease_term,TP/SZ 조회<br>
	 * 각화면 공통 lease_term,TP/SZ  정보 조회<br>
	 * 
	 * @param e 이벤트
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommon02List(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		CNTRInventoryReportBC command = new CNTRInventoryReportBCImpl();
		List<InvtCodeCommonVO> invtCodeCommonVO = command.searchCntrTypeSizeList( );
		StringBuilder sb = new StringBuilder();
		if(invtCodeCommonVO.size() > 0) {
			for(int i = 0 ; i < invtCodeCommonVO.size()-1 ; i++){
				sb.append(invtCodeCommonVO.get(i).getCntrTpszCd());
				sb.append("|");
			}
			sb.append(invtCodeCommonVO.get(invtCodeCommonVO.size()-1).getCntrTpszCd());
		} 

		Map<String,String> etcData = new HashMap<String,String>();
		 
		etcData.put("cntr_tpsz_cd",sb.toString());		
		
		//Lease Term Combo Object Item
		LeaseTermBC leaseCommand = new LeaseTermBCImpl();
		List<MstLseTermVO> leaseTermList = leaseCommand.searchLeaseTermComboItemBasic();
		StringBuffer sLeaseTermNm = new StringBuffer();
		StringBuffer sLeaseTermCd = new StringBuffer();

		for ( int i = 0 ; i < leaseTermList.size() ; i++ ) {
			if ( sLeaseTermNm.toString().equals("") ) {
				sLeaseTermNm.append(leaseTermList.get(i).getLstmCd());
				sLeaseTermCd.append(leaseTermList.get(i).getLstmCd());
			} else {
				sLeaseTermNm.append("|").append(leaseTermList.get(i).getLstmCd());
				sLeaseTermCd.append("|").append(leaseTermList.get(i).getLstmCd());
			}
		}

		etcData.put("lease_term_nm", sLeaseTermNm.toString());
		etcData.put("lease_term_cd", sLeaseTermCd.toString());

		eventResponse.setETCData(etcData);
		return eventResponse;
	}	    
	
	/**
	 * EES_CIM_0022 : Retrieve<br>
	 * 장기체화장비(L/Staying) 및 Unclaim 요건 장비에 대한 제반 정보를 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFlaggingTargetList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0022Event event = (EesCim0022Event)e;
		LongstayingUnclaimEQFlaggingBC command = new LongstayingUnclaimEQFlaggingBCImpl();
		try{
			List<LongStayUclmDetailVO> list = command.searchFlaggingTargetList(event.getFlaggingSDaysOptionVO ());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;		
	}
	

	/**
	 * EES_CIM_0022 : COR Draft<br>
	 * 장기체화장비(L/Staying) 및 Unclaim 요건 장비에 대한 제반 정보를 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCorDraft(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0022Event event = (EesCim0022Event)e;
		LongstayingUnclaimEQFlaggingBC command = new LongstayingUnclaimEQFlaggingBCImpl();
		try{
		
			List<LongStayUclmDetailVO> list = command.searchCorDraft(event.getFlaggingSDaysOptionVO());
			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;		
	}
	
	/**
	 * EES_CIM_0022 : RCV/DEL list<br>
	 * RCV/DEL list를 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRcvDelCodeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0022Event event = (EesCim0022Event)e;
		LongstayingUnclaimEQFlaggingBC command = new LongstayingUnclaimEQFlaggingBCImpl();
		try{
		
			List<LongStayUclmDetailVO> list = command.searchRcvDelCodeBasic(event.getCodeFlg());
			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;		
	}	
	
	
	/**
	 * 화면별 Location 이벤트 체크로직<br>
	 * Location check validate<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkLocation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//EesCim1001Event event = (EesCim1001Event)e;
		CIMCommonBC command = new CIMCommonBCImpl();

		String locLevel = (String)e.getAttribute("inquirylevel");
		String locCD = (String)e.getAttribute("location");
		String check = command.checkLocation(locLevel,locCD);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Map<String,String> etcData = new HashMap<String,String>();
		etcData.put("check",check);
		
		eventResponse.setETCData(etcData);
		return eventResponse;
	}
	
	/**
	 * EES_CIM_0022 : 저장<br>
	 * 장기체화장비(L/Staying) 및 Unclaim 장비 Flag 와 해소 방안을 등록한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageFlagging(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		LongstayingUnclaimEQFlaggingBC command = new LongstayingUnclaimEQFlaggingBCImpl();
		ContainerOnOffhireBC cntrCommand = new ContainerOnOffhireBCImpl();
		EesCim0022Event event = (EesCim0022Event)e;
		
		try{
			begin();
			cntrCommand.updateCntrMasterByLongStayCreationBasic(event.getLongStayUclmDetailVOS(),account);
			command.manageFlagging(event.getLongStayUclmDetailVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("CIM00003").getUserMessage());
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
	 * EES_CIM_0024 : Retrieve<br>
	 * L/S & U/C Creation화면에서 Flag된 L/S 및 U/C 장비의 현황을 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFlaggingStatusList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0024Event event = (EesCim0024Event)e;
		LongstayingUnclaimEQFlaggingBC command = new LongstayingUnclaimEQFlaggingBCImpl();
		try{
			List<FlaggingListSmryVO> list = command.searchFlaggingStatusListSmry(event.getFlaggingSDaysOptionVO ());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;		
	}
	/**
	 * EES_CIM_0018 : Retrieve<br>
	 * 조회시점 기준, 지역별로 소재하고 있는 컨테이너 넘버 및 관련 Booking 및 장비관리 정보를 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrFdayList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0025Event event = (EesCim0025Event)e;
		
		event.getInvtOptionVO().setOfcCd(account.getOfc_cd());
		LongstayingUnclaimEQFlaggingBC command = new LongstayingUnclaimEQFlaggingBCImpl();
		try{
			List<CntrFdayListVO> list = command.searchCntrFdayList(event.getInvtOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_CIM_1951 : Retrieve<br>
	 * OP Inventory for Pseudo Booking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOPInventoryForPseudoBookingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim1951Event event = (EesCim1951Event)e;
		LongstayingUnclaimEQFlaggingBC command = new LongstayingUnclaimEQFlaggingBCImpl();

		try{
			List<OPInventoryForPseudoBookingSummayVO> list = command.searchOPInventoryForPseudoBookingList(event.getOPInventoryForPseudoBookingOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_CIM_1951 : Retrieve<br>
	 * OP Inventory for Pseudo Booking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOPInventoryForPseudoBookingDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim1951Event event = (EesCim1951Event)e;
		LongstayingUnclaimEQFlaggingBC command = new LongstayingUnclaimEQFlaggingBCImpl();

		try{
			List<OPInventoryForPseudoBookingDetailVO> list = command.searchOPInventoryForPseudoBookingDetailList(event.getOPInventoryForPseudoBookingOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_CIM_0060 : Retrieve<br>
	 * EQ Balance Report.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse mainSearchEQBalanceReportInputList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0060Event event = (EesCim0060Event) e;
		LongstayingUnclaimEQFlaggingBC command = new LongstayingUnclaimEQFlaggingBCImpl();
		
		try{
			List<EQBalanceReportInputListVO> list = command.mainSearchEQBalanceReportInputList(event.getRhqCd(), event.getPeriodWeek(), event.getScontiCd(), event.getLccCd(), event.getEccCd());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_CIM_0060 : Retrieve<br>
	 * EQ Balance Report.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse mainSearchEQBalanceReportInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0061Event event = (EesCim0061Event) e;
		LongstayingUnclaimEQFlaggingBC command = new LongstayingUnclaimEQFlaggingBCImpl();
		
		try{
			List<EQBalanceReportInputListVO> list = command.mainSearchEQBalanceReportInquiryList(event.getRhqCd(), event.getFmWeek(), event.getToWeek(), event.getScontiCd(), event.getLccCd(), event.getEccCd());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_CIM_0060, EES_CIM_0061, EES_CIM_0062 : Preceding Retrieve<br>
	 * EQ Balance Report.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse preSearchEQBalanceReport(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		LongstayingUnclaimEQFlaggingBC command = new LongstayingUnclaimEQFlaggingBCImpl();
		
		String lclHqOfcCd		= null;
		String glblhqOfcCd		= null;
		String hdQtrByOfcCd		= null;
		String nowWeek			= null;
		String lastWeek			= null;
		String scontiCd			= null;
		String lccCd			= null;
		String eccCd			= null;
		
		try{
			if (e.getEventName().equalsIgnoreCase("EesCim0060Event")) {
				EesCim0060Event event = (EesCim0060Event) e;
				
				hdQtrByOfcCd = command.searchHdQtrByOfcCd(account.getOfc_cd(), event.getPageType());
				scontiCd = command.searchSubContiCd(event.getRhqCd());
				lccCd = command.searchLccCd(event.getScontiCd(), event.getRhqCd());
				eccCd = command.searchEccCd(event.getScontiCd(), event.getEccCd(), event.getRhqCd());
				
			} else if (e.getEventName().equalsIgnoreCase("EesCim0061Event")) {
				EesCim0061Event event = (EesCim0061Event) e;
				
				hdQtrByOfcCd = command.searchHdQtrByOfcCd(account.getOfc_cd(), event.getPageType());
				scontiCd = command.searchSubContiCd(event.getRhqCd());
				lccCd = command.searchLccCd(event.getScontiCd(), event.getRhqCd());
				eccCd = command.searchEccCd(event.getScontiCd(), event.getEccCd(), event.getRhqCd());
				lastWeek = command.searchLastWeek();
			} 
			
			nowWeek = command.searchNowWeek();
			lclHqOfcCd = command.searchLclHqOfcCd();
			glblhqOfcCd = command.searchGlblhqOfcCd();

			eventResponse.setETCData("lcl_hq_ofc_cd", lclHqOfcCd);
			eventResponse.setETCData("glbl_hq_ofc_cd", glblhqOfcCd);
			eventResponse.setETCData("ar_hd_qtr_ofc_cd", hdQtrByOfcCd);
			eventResponse.setETCData("now_week", nowWeek);
			eventResponse.setETCData("last_week", lastWeek);
			eventResponse.setETCData("sconti_cd", scontiCd);
			eventResponse.setETCData("lcc_cd", lccCd);
			eventResponse.setETCData("ecc_cd", eccCd);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_CIM_0060, EES_CIM_0061, EES_CIM_0062 : Sub-Conti Code Retrieve<br>
	 * For Setting Sub-Conti Code<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSubContiCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		LongstayingUnclaimEQFlaggingBC command = new LongstayingUnclaimEQFlaggingBCImpl();
		
		String subContiCd		= null;
		
		try{
			if (e.getEventName().equalsIgnoreCase("EesCim0060Event")) {
				EesCim0060Event event = (EesCim0060Event) e;
				subContiCd = command.searchSubContiCd(event.getRhqCd());
			} else if (e.getEventName().equalsIgnoreCase("EesCim0061Event")) {
				EesCim0061Event event = (EesCim0061Event) e;
				subContiCd = command.searchSubContiCd(event.getRhqCd());
			}

			eventResponse.setETCData("sub_conti_cd", subContiCd);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_CIM_0060, EES_CIM_0061, EES_CIM_0062 : LCC Code Retrieve<br>
	 * For Setting LCC Code<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLccCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		LongstayingUnclaimEQFlaggingBC command = new LongstayingUnclaimEQFlaggingBCImpl();
		
		String lccCd		= null;
		
		try{
			if (e.getEventName().equalsIgnoreCase("EesCim0060Event")) {
				EesCim0060Event event = (EesCim0060Event) e;
				lccCd = command.searchLccCd(event.getScontiCd(), event.getRhqCd());
			} else if (e.getEventName().equalsIgnoreCase("EesCim0061Event")) {
				EesCim0061Event event = (EesCim0061Event) e;
				lccCd = command.searchLccCd(event.getScontiCd(), event.getRhqCd());
			}

			eventResponse.setETCData("lcc_cd", lccCd);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_CIM_0060, EES_CIM_0061, EES_CIM_0062 : ECC Code Retrieve<br>
	 * For Setting ECC Code<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEccCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		LongstayingUnclaimEQFlaggingBC command = new LongstayingUnclaimEQFlaggingBCImpl();
		
		String eccCd		= null;
		
		try{
			if (e.getEventName().equalsIgnoreCase("EesCim0060Event")) {
				EesCim0060Event event = (EesCim0060Event) e;
				eccCd = command.searchEccCd(event.getScontiCd(), event.getLccCd(), event.getRhqCd());
			} else if (e.getEventName().equalsIgnoreCase("EesCim0061Event")) {
				EesCim0061Event event = (EesCim0061Event) e;
				eccCd = command.searchEccCd(event.getScontiCd(), event.getLccCd(), event.getRhqCd());
			}

			eventResponse.setETCData("ecc_cd", eccCd);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_CIM_0060 : Save<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageEQBalanceReportInput(Event e) throws EventException {
		
		EesCim0060Event event = (EesCim0060Event) e;
		LongstayingUnclaimEQFlaggingBC command = new LongstayingUnclaimEQFlaggingBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			
			begin();
			command.manageEQBalanceReportInput(event.getCimEqSplsDfctStsVOS(), account);
			commit();
			eventResponse.setUserMessage(new ErrorHandler("CIM00003").getUserMessage());
			
		} catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * EES_CIM_0062 : Retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse mainSearchMailingServiceSettingList(Event e) throws EventException {

		LongstayingUnclaimEQFlaggingBC command = new LongstayingUnclaimEQFlaggingBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		int cntByUsrId = 0;
		
		try{
			cntByUsrId = command.cntOfCimEqSplsDfctEmlByUsrId(account.getUsr_id());
			
			List<MailingServiceSettingListVO> list = command.mainSearchMailingServiceSettingList(account.getUsr_id(), cntByUsrId);
			
			if(cntByUsrId > 0) eventResponse.setETCData("select_type", "UNION");
			else eventResponse.setETCData("select_type", "MDM");
			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * EES_CIM_0062 : Save<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMailingServiceSetting(Event e) throws EventException {
		EesCim0062Event event = (EesCim0062Event) e;
		LongstayingUnclaimEQFlaggingBC command = new LongstayingUnclaimEQFlaggingBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			begin();
			
			if(event.getMailingServiceSettingListVOS() != null) {
				
				command.manageMailingServiceSetting(event.getMailingServiceSettingListVOS(), account);
			} else {
				
				command.manageMailingServiceSetting(null, account);
			}
			
			commit();
			eventResponse.setUserMessage(new ErrorHandler("CIM00003").getUserMessage());
			
		} catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}

	/**
	 * EES_CIM_0063 : Retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUncollectedCargoCreation(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0063Event event = (EesCim0063Event)e;
		UncollectedCargoBC command = new UncollectedCargoBCImpl();
		try{
			String strAgnt = "TRUE";
			List<UncollectedCargoVO> list = command.searchUncollectedCargoCreation(event.getUncollectedCargoVO());
			if (list == null || list.size() < 1) {
				strAgnt = "FALSE";
			}
			eventResponse.setRsVoList(list);
			Map<String,String> etcData = new HashMap<String,String>();
			etcData.put("RTNVAL",strAgnt);
			eventResponse.setETCData(etcData);
			
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;		
	}
	
	
	
	/**
	 * UC Creation B/L info 조회 [EES_CIM_0063]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUncollectedCargoCreationBlInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0063Event event = (EesCim0063Event)e;
		UncollectedCargoBC command = new UncollectedCargoBCImpl();
		try{
			
			UncollectedCargoVO uncollectedCargoVO = command.searchUncollectedCargoCreationBlInfo(event.getIntgCdId());
			
			Map<String,String> etcData = new HashMap<String,String>();
			etcData.put("vvd",uncollectedCargoVO.getVvd());
			etcData.put("vsl_nm",uncollectedCargoVO.getVslNm());
			etcData.put("por",uncollectedCargoVO.getPor());
			etcData.put("por_dt",uncollectedCargoVO.getPorDt());
			etcData.put("pol",uncollectedCargoVO.getPol());
			etcData.put("pol_etd",uncollectedCargoVO.getPolEtd());
			etcData.put("pod",uncollectedCargoVO.getPod());
			etcData.put("pod_eta",uncollectedCargoVO.getPodEta());
			etcData.put("del_cd",uncollectedCargoVO.getDelCd());
			etcData.put("del_dt",uncollectedCargoVO.getDelDt());
			etcData.put("shpr",uncollectedCargoVO.getShpr());
			etcData.put("cnee",uncollectedCargoVO.getCnee());
			etcData.put("noti",uncollectedCargoVO.getNoti());
			etcData.put("frwd",uncollectedCargoVO.getFrwd());
			etcData.put("cmdt",uncollectedCargoVO.getCmdt());
			etcData.put("prepaid",uncollectedCargoVO.getPrepaid());
			etcData.put("collect",uncollectedCargoVO.getCollect());
			etcData.put("uc_do_iss_dt",uncollectedCargoVO.getUcDoIssDt());
			
			eventResponse.setETCData(etcData);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;		
	}

	/**
	 * EES_CIM_0063 : Retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComboCodeList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0063Event event = (EesCim0063Event)e;
		UncollectedCargoBC command = new UncollectedCargoBCImpl();
		try{
			List<CodeVO> list = command.searchComboCodeList(event.getIntgCdId());
			
			StringBuffer comboList = new StringBuffer("");
			 
			for(int i=0; i<list.size(); i++){
				CodeVO commonCode = (CodeVO)list.get(i);
							
				String code = commonCode.getCode();
				String name	= commonCode.getCodeDesc();
				
				name = name.replaceAll("\"", "");						
				comboList.append(code + '|' + name);
				if(i < list.size()-1) comboList.append("@");
			}
			
			eventResponse.setRsVoList(list);	
			eventResponse.setETCData("comboList", comboList.toString());	
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;		
	}
	
//	/**
//	 * EES_CIM_0062 : Save<br>
//	 * 
//	 * @param Event e
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	private EventResponse manageUncollectedCargoCreation(Event e) throws EventException {
//		EesCim0063Event event = (EesCim0063Event) e;
//		UncollectedCargoBC command = new UncollectedCargoBCImpl();
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		
//		try{
//			begin();
//			
//			
//			// 신규 UC CASE NO 생성, VO에 Setting  
//				
//			command.manageUncollectedCargoCreation(event.getUncollectedCargoVO(), account);
//			command.manageUncollectedCargoCreation(null, account);
//			commit();
//			eventResponse.setUserMessage(new ErrorHandler("CIM00003").getUserMessage());
//			
//		} catch(EventException ex){
//			rollback();
//			throw ex;
//		} catch(Exception ex){
//			throw new EventException(ex.getMessage(), ex);
//		}
//		
//		return eventResponse;
//	}
	
	/**
	 * New UC Case No 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkNewUCCaseNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		UncollectedCargoBC command = new UncollectedCargoBCImpl();

		String ucCDHd = (String)e.getAttribute("hndlBrncCd");
		String ucDate = (String)e.getAttribute("ucDate");
		
//		java.util.Calendar cal = java.util.Calendar.getInstance();
//		int year = cal.get(cal.YEAR);
		
		int year = Integer.valueOf(ucDate.substring(0,4));
		
		ucCDHd = "UC" + ucCDHd.substring(0, 3) + year;
		String UCCaseNo = command.checkNewUCCaseNo(ucCDHd);
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Map<String,String> etcData = new HashMap<String,String>();
		etcData.put("UCCaseNo",UCCaseNo);
		
		eventResponse.setETCData(etcData);
		return eventResponse;
	}
	
	/**
	 * BL 중복 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkBLNo3(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim0063Event event = (EesCim0063Event)e;
		UncollectedCargoBC command = new UncollectedCargoBCImpl();

		String flag = command.checkBLNo3(event.getUncollectedCargoVO());
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Map<String,String> etcData = new HashMap<String,String>();
		etcData.put("Flag",flag);
		
		eventResponse.setETCData(etcData);
		return eventResponse;
	}

	/**
	 * Valide B/L No 유무 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkBLNo(Event e) throws EventException {
		
		EesCim0063Event event = (EesCim0063Event)e;
		UncollectedCargoBC command = new UncollectedCargoBCImpl();
		
		String strBLNo = command.checkBLNo(event.getIntgCdId());
		if (strBLNo == null ||"".equals(strBLNo)) {
			strBLNo = "FALSE";
		}
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Map<String,String> etcData = new HashMap<String,String>();
		etcData.put("RTNVAL",strBLNo);
		eventResponse.setETCData(etcData);
		
		return eventResponse;
	}	
	
	/**
	 *  CIM_UC_CGO_DTL 에 해당 B/L NO 존재 여부 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkBLNo2(Event e) throws EventException {
		
		EesCim0063Event event = (EesCim0063Event)e;
		UncollectedCargoBC command = new UncollectedCargoBCImpl();
		
		String strUCCsNo = command.checkBLNo2(event.getIntgCdId());
		if (strUCCsNo == null ||"".equals(strUCCsNo)) {
			strUCCsNo = "FALSE";
		}
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Map<String,String> etcData = new HashMap<String,String>();
		etcData.put("RTNVAL",strUCCsNo);
		eventResponse.setETCData(etcData);
		
		return eventResponse;
	}	

	/**
	 * Valide Agent 유무 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkAgent(Event e) throws EventException {
		
		EesCim0063Event event = (EesCim0063Event)e;
		UncollectedCargoBC command = new UncollectedCargoBCImpl();
		
		String strAgnt = command.checkAgent(event.getIntgCdId());
		if (strAgnt == null ||"".equals(strAgnt)) {
			strAgnt = "FALSE";
		}
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Map<String,String> etcData = new HashMap<String,String>();
		etcData.put("RTNVAL",strAgnt);
		eventResponse.setETCData(etcData);
		
		return eventResponse;
	}	

	/**
	 * Valide RHQ 유무 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkRHQ(Event e) throws EventException {
		
		EesCim0063Event event = (EesCim0063Event)e;
		UncollectedCargoBC command = new UncollectedCargoBCImpl();
		
		String strRhq = command.checkRHQ(event.getIntgCdId());
		if (strRhq == null ||"".equals(strRhq)) {
			strRhq = "FALSE";
		}
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Map<String,String> etcData = new HashMap<String,String>();
		etcData.put("RTNVAL",strRhq);
		eventResponse.setETCData(etcData);
		
		return eventResponse;
	}	

	/**
	 * Valide Handler 유무 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkHandler(Event e) throws EventException {
		
		EesCim0063Event event = (EesCim0063Event)e;
		UncollectedCargoBC command = new UncollectedCargoBCImpl();
		
		String strHndlr = command.checkHandler(event.getIntgCdId());
		if (strHndlr == null ||"".equals(strHndlr)) {
			strHndlr = "FALSE";
		}
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Map<String,String> etcData = new HashMap<String,String>();
		etcData.put("RTNVAL",strHndlr);
		eventResponse.setETCData(etcData);
		
		return eventResponse;
	}	
	
	/**
	 * EES_CIM_0063 : Save<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageUncollectedCargoCreation(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0063Event event = (EesCim0063Event)e;
		UncollectedCargoBC command = new UncollectedCargoBCImpl();
		try{			
			begin();
			command.manageUncollectedCargoCreation(event.getUncollectedCargoVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("CIM00003").getUserMessage());
			commit();
			eventResponse.setETCData("RTNVAL", "N");

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
	 * EES_CIM_0063 : Save01<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageUncollectedCargoCreation01(Event e) throws EventException {
		
		// Case1_MULTI01 :  UC Case NO 가 있는 경우(기존 Seq 변경)  => Master : update, Detail : update
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0063Event event = (EesCim0063Event)e;
		UncollectedCargoBC command = new UncollectedCargoBCImpl();
		try{			
			begin();
			command.manageUncollectedCargoCreation01(event.getUncollectedCargoVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("CIM00003").getUserMessage());
			commit();
			eventResponse.setETCData("RTNVAL", "N");
			
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
	 * EES_CIM_0063 : Save02<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageUncollectedCargoCreation02(Event e) throws EventException {
		
		// Case1_MULTI02 :  UC Case NO 가 있는 경우(Seq 추가 후 변경)  => Master update, Detail input
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0063Event event = (EesCim0063Event)e;
		UncollectedCargoBC command = new UncollectedCargoBCImpl();
		try{			
			begin();
			command.manageUncollectedCargoCreation02(event.getUncollectedCargoVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("CIM00003").getUserMessage());
			commit();
			eventResponse.setETCData("RTNVAL", "N");
			
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
	 * EES_CIM_0063 : Save03<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageUncollectedCargoCreation03(Event e) throws EventException {
		
		// Counter Office 의 Branch/Agent 의 경우 변경할 수 있는 내용이 제한 되어 있음. => Master update, Detail update
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0063Event event = (EesCim0063Event)e;
		UncollectedCargoBC command = new UncollectedCargoBCImpl();
		try{			
			begin();
			command.manageUncollectedCargoCreation03(event.getUncollectedCargoVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("CIM00003").getUserMessage());
			commit();
			eventResponse.setETCData("RTNVAL", "N");
			
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
	 * EES_CIM_0063 : Save04<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageUncollectedCargoCreation04(Event e) throws EventException {
		
		// Case3_MULTI04 :   Reopen 만 저장하는 경우 Status 코드 값을 OS로 변경 저장
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0063Event event = (EesCim0063Event)e;
		UncollectedCargoBC command = new UncollectedCargoBCImpl();
		try{			
			begin();
			command.manageUncollectedCargoCreation04(event.getUncollectedCargoVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("CIM00003").getUserMessage());
			commit();
			eventResponse.setETCData("RTNVAL", "N");
			
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
	 * EES_CIM_0063 : Save05<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageUncollectedCargoCreation05(Event e) throws EventException {
		
		// Case3_MULTI04 :   Reopen 만 저장하는 경우 Status 코드 값을 OS로 변경 저장
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UncollectedCargoBC command = new UncollectedCargoBCImpl();
		String managerMemo = (String)e.getAttribute("managerMemo");
		String isAuthority = (String)e.getAttribute("isAuthority");		
		String ucCsNo = (String)e.getAttribute("ucCsNo");		
		String blNo = (String)e.getAttribute("blNo");
		try{			
			begin();
			command.manageUncollectedCargoCreation05(managerMemo,isAuthority,ucCsNo,blNo, account.getUsr_id());
			eventResponse.setUserMessage(new ErrorHandler("CIM00003").getUserMessage());
			commit();
			eventResponse.setETCData("RTNVAL", "Y");
			
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
	 * Valide Handler 유무 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkOfcCd(Event e) throws EventException {
		
		EesCim0063Event event = (EesCim0063Event)e;
		UncollectedCargoBC command = new UncollectedCargoBCImpl();
		
		String strOfcCd = command.checkOfcCd(event.getIntgCdId());
		if (strOfcCd == null ||"".equals(strOfcCd)) {
			strOfcCd = "FALSE";
		}
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Map<String,String> etcData = new HashMap<String,String>();
		etcData.put("RTNVAL",strOfcCd);
		eventResponse.setETCData(etcData);
		
		return eventResponse;
	}
	
	/**
	 * Valide Office & Handler  유무 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */

	private EventResponse checkOfcHandlerMatch(Event e) throws EventException {
		
		EesCim0063Event event = (EesCim0063Event)e;
		UncollectedCargoBC command = new UncollectedCargoBCImpl();
		
		String strOfcCd = command.checkOfcHandlerMatch(event.getUncollectedCargoVO(), event.getIntgCdId());
		if (strOfcCd == null ||"".equals(strOfcCd)) {
			strOfcCd = "FALSE";
		}
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Map<String,String> etcData = new HashMap<String,String>();
		etcData.put("RTNVAL",strOfcCd);
		eventResponse.setETCData(etcData);
		
		return eventResponse;
	
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * UC Inquiry 리스트 조회 [EES_CIM_0064]<br>
	 * 
	 * @param e Event  
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUncollectedInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim0064Event event = (EesCim0064Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			UncollectedCargoBC command = new UncollectedCargoBCImpl();
			eventResponse = command.searchUncollectedInquiryList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * UC Activity 리스트 조회 [EES_CIM_0066]<br>
	 * 
	 * @param e Event  
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUncollectedCargoFileList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0066Event event = (EesCim0066Event)e;
		UncollectedCargoBC command = new UncollectedCargoBCImpl();
		
		try{
			List<SearchUncollectedCargoFileVO> list = command.searchUncollectedCargoFileList(event.getSearchUncollectedCargoFileVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * UC Activity 저장/수정/삭제 처리 [EES_CIM_0066]<br>
	 *
	 * @param e Event  
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageUncollectedCargoFile(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0066Event event = (EesCim0066Event)e;
		UncollectedCargoBC command = new UncollectedCargoBCImpl();
		try{
			begin();
			command.manageUncollectedCargoFile(event.getSearchUncollectedCargoFileVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
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
	 * 조회 이벤트 처리<br>
	 * UC-VOL_DTL 리스트 조회 [EES_CIM_0070]<br>
	 * 
	 * @param e Event  
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUncollectedVolDtlList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0070Event event = (EesCim0070Event)e;
		UncollectedCargoBC command = new UncollectedCargoBCImpl();
		
		try{
			List<SearchUncollectedVolDtlListVO> list = command.searchUncollectedVolDtlList(event.getSearchUncollectedVolDtlListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Help Exchange 리스트 조회 - 년월/통화코드별 환율조회 [EES_CIM_0071]<br>
	 * 
	 * @param e Event  
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUncollectedGlMonXchRtList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0071Event event = (EesCim0071Event)e;
		UncollectedCargoBC command = new UncollectedCargoBCImpl();
		
		try{
			List<SearchUncollectedGlMonXchRtListVO> list = command.searchUncollectedGlMonXchRtList(event.getSearchUncollectedGlMonXchRtListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Help Exchange - 통화코드Combo리스트 [EES_CIM_0071]<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCurrCdCombo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim0071Event 	event 			= (EesCim0071Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse 		eventResponse 	= null;
		
		try {
			UncollectedCargoBC command = new UncollectedCargoBCImpl();
			eventResponse = command.searchCurrCdCombo(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * UC File Attach 업로드된 파일정보(목록) 조회 이벤트 처리 [EES_CIM_0065]<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUploadFileInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim0065Event event = (EesCim0065Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			UncollectedCargoBC command = new UncollectedCargoBCImpl();
			eventResponse = command.searchUploadFileInfo(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * UC File Attach FileUpload정보 저장(생성) 이벤트 처리 [EES_CIM_0067]<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse createUploadFileInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			begin();
			UncollectedCargoBC command = new UncollectedCargoBCImpl();
			eventResponse = command.createUploadFileInfo(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse; 
	}

	
	/**
	 * UC File Attach FileUpload정보-공통테이블 저장(생성) 이벤트 처리 [EES_CIM_0067]<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse createUploadFileInfoCOM(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			begin();
			UncollectedCargoBC command = new UncollectedCargoBCImpl();
			eventResponse = command.createUploadFileInfoCOM(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse; 
	}

	/**
	 * UC File Attach FileUpload정보 삭제 이벤트 처리 [EES_CIM_0067]<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse removeUploadFiles(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			begin();
			UncollectedCargoBC command = new UncollectedCargoBCImpl();
			eventResponse = command.removeUploadFiles(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse; 
	}	

	/**
	 * UC File Attach FileUpload정보-공통 삭제 이벤트 처리 [EES_CIM_0067]<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse removeUploadFilesCOM(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			begin();
			UncollectedCargoBC command = new UncollectedCargoBCImpl();
			eventResponse = command.removeUploadFilesCOM(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse; 
	}	
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * UC Authorizer 리스트 조회 [EES_CIM_0072]<br>
	 * 
	 * @param e Event  
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUncollectedCargoAuthorizer(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0072Event event = (EesCim0072Event)e;
		UncollectedCargoBC command = new UncollectedCargoBCImpl();
		
		try{
			List<UncollectedCargoAuthorizerVO> list = command.searchUncollectedCargoAuthorizer(event.getUncollectedCargoAuthorizerVO()); 
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * 조회 이벤트 처리<br>
	 * UC Authorizer 리스트 조회 [EES_CIM_0072]<br>
	 * 
	 * @param e Event  
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkAuthorizerInputId(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0072Event event = (EesCim0072Event)e;
		UncollectedCargoBC command = new UncollectedCargoBCImpl();
		
		try{
			List<UncollectedCargoAuthorizerVO> list = command.checkAuthorizerInputId(event.getUncollectedCargoAuthorizerVO()); 
			eventResponse.setETCData("cnt", ((UncollectedCargoAuthorizerVO)list.get(0)).getCnt());
			eventResponse.setETCData("usr_nm", ((UncollectedCargoAuthorizerVO)list.get(0)).getUsrNm());
			eventResponse.setETCData("isfalg", ((UncollectedCargoAuthorizerVO)list.get(0)).getIsfalg());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * EES_CIM_0072 : UC Authorizer Save<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageUncollectedCargoAuthorizer(Event e) throws EventException {
		
		// Case3_MULTI04 :   Reopen 만 저장하는 경우 Status 코드 값을 OS로 변경 저장
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0072Event event = (EesCim0072Event)e;
		UncollectedCargoBC command = new UncollectedCargoBCImpl();
		try{			
			begin();
			command.manageUncollectedCargoAuthorizer(event.getUncollectedCargoAuthorizerVOs(),account.getUsr_id());
			eventResponse.setUserMessage(new ErrorHandler("CIM00003").getUserMessage());
			commit();
			eventResponse.setETCData("RTNVAL", "N");
			
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
	 * 권한 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */

	private EventResponse checkOfAuthority(Event e) throws EventException {
		
		EesCim0063Event event = (EesCim0063Event)e;
		UncollectedCargoBC command = new UncollectedCargoBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		String getAuthority = command.checkOfAuthority(event.getUncollectedCargoVO(),account.getUsr_id());
//		Map<String,String> etcData = new HashMap<String,String>();
		eventResponse.setETCData("getAuthority",getAuthority);
		
		return eventResponse;
	
	}	
		
}