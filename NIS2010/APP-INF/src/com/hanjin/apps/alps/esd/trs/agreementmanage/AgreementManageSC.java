/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AgreementManageSC.java
*@FileTitle : 요율 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2011-05-11
*@LastModifier : 민정호
*@LastVersion : 1.1 
* 1.0 최초 생성
* 
* 1.1 2011.05.11 민정호 [CHM-201110223] USER 에 의한 AGMT HISTORY 관리를 위한 기능 추가요청
* 2012.10.04 김현화[CHM-201220202-01]US Rail incentive function 추가 요청
* 2014.05.28 최종혁 [CHM-201430241] AGMT Confirm 기능 추가
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage;

import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.basic.AgreementApprovalBC;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.basic.AgreementApprovalBCImpl;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.basic.AgreementCorrectionBC;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.basic.AgreementCorrectionBCImpl;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.basic.AgreementHisBC;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.basic.AgreementHisBCImpl;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.basic.AgreementImportBC;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.basic.AgreementImportBCImpl;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.basic.AgreementRailScgBC;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.basic.AgreementRailScgBCImpl;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0220Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0221Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0223Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0224Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0226Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0227Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0229Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0230Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0231Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0235Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0237Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0240Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.vo.SearchAgmtHdrVO;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.vo.SearchApprovalMgmtVO;
import com.hanjin.apps.alps.esd.trs.agreementmanage.contractattach.basic.ContractAttachBC;
import com.hanjin.apps.alps.esd.trs.agreementmanage.contractattach.basic.ContractAttachBCImpl;
import com.hanjin.apps.alps.esd.trs.agreementmanage.contractattach.event.EsdTrs0243Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.fuelscgmanage.basic.FuelScgManageBC;
import com.hanjin.apps.alps.esd.trs.agreementmanage.fuelscgmanage.basic.FuelScgManageBCImpl;
import com.hanjin.apps.alps.esd.trs.agreementmanage.fuelscgmanage.event.EsdTrs0280Event;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ESD-TRS Business Logic ServiceCommand<br>
 * - ESD-TRS에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author agreement
 * @see AgreementFileImportDBDAO 참조
 * @since J2EE 1.6
 */
public class AgreementManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * TRS 업무 시나리오 선행작업<br>
	 * AgreementFileImport업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account=getSignOnUserAccount();
		} catch (Exception e) {
			log.error("AgreementManageSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * AgreementFileImport업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("AgreementSC 종료");
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
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdTrs0220Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //(ESD_TRS_0220) Agreement Header정보 조회
				eventResponse = searchAgmtHdr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { //(ESD_TRS_0220) Agreement Child S/P정보 조회
				eventResponse = searchAgmtChdVndr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { //(ESD_TRS_0220) Agreement 중복 체크
				eventResponse = searchAgmtDupChk(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {  //(ESD_TRS_0220) Agreement Header정보 저장
				eventResponse = multiAgmtHdr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {  //(ESD_TRS_0220) Contract Office 존재여부 체크
				eventResponse = searchContractOffice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {  //(ESD_TRS_0220) Agreement S/P명 조회
				eventResponse = searchVenderName(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {  //(ESD_TRS_0220) Agreement Child S/P정보 저장
				eventResponse = multiAgmtHdrVndr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {  //(ESD_TRS_0220) Agreement Remark Update
				eventResponse = multiAgmtHdrRmk(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0221Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //(ESD_TRS_0221) Agreement Verify
				eventResponse = verifyAgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { //(ESD_TRS_0221) Agreement rate 정보 저장(입력/수정/삭제)
				eventResponse = multiCorrRateAgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { //(ESD_TRS_0222) Agreement Surcharge Verify
				eventResponse = verifyAgmtSurcharge(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { //(ESD_TRS_0222) Agreement Surcharge rate 정보 저장(입력/수정/삭제)
				eventResponse = multiCorrScgAgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) { //(ESD_TRS_0224) Sub Office 조회
				eventResponse = searchSubOfcCd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) { //(ESD_TRS_0225) Agreement Rate 삭제
				eventResponse = deleteCorrRateAgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) { //(ESD_TRS_0228) Agreement Surcharge Rate 삭제
				eventResponse = deleteCorrScgAgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) { // (ESD_TRS_0224) Rate Correction 권한체크
				eventResponse = searchAuthChk(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EsdTrs0223Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //(ESD_TRS_0223) US RAIL Agreement Fuel Surcharge 조회
				eventResponse = searchRailFuelScgAgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { //(ESD_TRS_0223) US RAIL Agreement Fuel Surcharge 저장
				eventResponse = multiRailFuelScgAgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { //(ESD_TRS_0223) US RAIL Agreement Fixed Surcharge 조회
				eventResponse = searchRailFixScgAgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { //(ESD_TRS_0223) US RAIL Agreement Fixed Surcharge 저장
				eventResponse = multiRailFixScgAgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) { //(ESD_TRS_0223) US RAIL Agreement Fuel, Fixed Surcharge 삭제
				eventResponse = deleteRailFuelScgAgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE02)) { //(ESD_TRS_0223) US RAIL Agreement Fuel, Fixed Surcharge 삭제
				eventResponse = deleteRailFixScgAgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { //(ESD_TRS_0223) US RAIL Agreement Fuel Surcharge Verify
				eventResponse = searchRailFuelFixScgAgmtVerify(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) { //(ESD_TRS_0223) US RAIL Agreement Fuel Surcharge Verify
				eventResponse = searchRailFuelFixScgAgmtVerify(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) { //(ESD_TRS_0223) US RAIL Agreement Incentive 조회
				eventResponse = searchRailIsgScgAgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) { //(ESD_TRS_0223) US RAIL Agreement Incentive 저장
				eventResponse = multiRailIsgScgAgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE03)) { //(ESD_TRS_0223) US RAIL Agreement Incentive 저장
				eventResponse = deleteRailIsgScgAgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) { //(ESD_TRS_0223) US RAIL Agreement Incentive Verify
				eventResponse = searchRailFuelFixScgAgmtVerify(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EsdTrs0224Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //(ESD_TRS_0224) Agreement Rate 조회
				eventResponse = searchCorrSumAgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE02)) { //(ESD_TRS_0224) Agreement Rate Type의 모든 Rate삭제
				eventResponse = deleteCorrSumAgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) { //(ESD_TRS_0224) Agreement Rate Confirm
				eventResponse = confirmAgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { //(ESD_TRS_0224) Agreement Rate Confirm Button 권한 확인
				eventResponse = confirmAgmtBtn(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EsdTrs0226Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { //(ESD_TRS_0226) Agreement Rate 조회
				eventResponse = searchCorrRateAgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { //(ESD_TRS_0228) Agreement Surcharge Rate 조회
				eventResponse = searchCorrRateAgmtExcelDown(e);
			} 
		} else if(e.getEventName().equalsIgnoreCase("EsdTrs0227Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //(ESD_TRS_0227) Agreement Rate History조회용 Rate별 장비리스트 조회
				eventResponse = searchRateHisAgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = saveTrsAgmtEqRtHis(e);	// 민정호 추가			
			}
		} else if(e.getEventName().equalsIgnoreCase("EsdTrs0229Event")) { //ESD_TRS_0229은 0228와 메소드를 공유한다.
			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { //(ESD_TRS_0228) Agreement Surcharge Rate 조회
				eventResponse = searchCorrScgAgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { //(ESD_TRS_0228) Agreement Surcharge Rate 조회
				eventResponse = searchCorrScgAgmtExcelDown(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EsdTrs0230Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //(ESD_TRS_0230) Agreement Surcharge Rate History조회용 Rate별 장비리스트 조회
				eventResponse = searchScgHisAgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = saveScgHisAgmt(e);	// 민정호 추가					
			}
		} else if(e.getEventName().equalsIgnoreCase("EsdTrs0231Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //(ESD_TRS_0231) Agreement Rate 조회
				eventResponse = searchDtlAgmt(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				eventResponse = searchDtlAgmtEffDt(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)){
				eventResponse = searchTpSz(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EsdTrs0233Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //(ESD_TRS_0233) Agreement No 조회
				eventResponse = searchAgmtNo(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EsdTrs0234Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // US RAIL Agreement Surcharge History 조회
				eventResponse = searchRailScgAgmtHis(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { //US RAIL Agreement Surcharge History Popup 조회
				eventResponse = searchRailScgAgmtHisPop(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = saveTrsAgmtRailScgRtHis(e);	// 민정호 추가	
			}
		} else if(e.getEventName().equalsIgnoreCase("EsdTrs0235Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //(ESD_TRS_0235) Agreement Inquiry Surcharge 조회
				eventResponse = searchScgDtlAgmt(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EsdTrs0240Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //(ESD_TRS_0240) HJS-HJL Handling Fee Management 조회
				eventResponse = searchHjlHndlFee(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchHjlHndlFeeHis(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = saveHjlHndlFee(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EsdTrs0237Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //(ESD_TRS_0237) Agreement Confirm Authority 
				eventResponse = searchApprovalList(e);
			} else	if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { //(ESD_TRS_0237) User id 체크
					eventResponse = searchUsrId(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = saveApprovalList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = delApprovalList(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EsdTrs0243Event")) {			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchContract(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiContractRgst(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = deleteContract(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EsdTrs0280Event")) {			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchFuelSurchargeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { //(ESD_TRS_0222) Agreement Surcharge Verify
				eventResponse = verifyFuelScgAgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchFuelSurchargeList(e);	
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { //(ESD_TRS_0280) Agreement rate 정보 저장(입력/수정/삭제)
				eventResponse = multiCorrFuelScgRateAgmt(e);	
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) { //(ESD_TRS_0280) Agreement Rate 삭제
				eventResponse = deleteCorrFuelScgRateAgmt(e);		
			}	
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Agreement Creation & Add 화면의 Agreement Header정보 조회<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgmtHdr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0220Event event = (EsdTrs0220Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			AgreementImportBC command = new AgreementImportBCImpl();
			eventResponse = command.searchAgmtHdr(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Agreement Creation & Add 화면의 Agreement S/P정보 조회<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgmtChdVndr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0220Event event = (EsdTrs0220Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			AgreementImportBC command = new AgreementImportBCImpl();
			eventResponse = command.searchAgmtChdVndr(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Agreement Creation & Add 화면의 Agreement S/P명 조회<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVenderName(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			AgreementImportBC command = new AgreementImportBCImpl();
			eventResponse = command.searchVenderName(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	

	/**
	 * 조회 이벤트 처리<br>
	 * Contract Office 존재여부 조회<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContractOffice(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			AgreementImportBC command = new AgreementImportBCImpl();
			eventResponse = command.searchContractOffice(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Agreement Creation & Add 화면의 Agreement 중복여부 체크<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgmtDupChk(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0220Event event = (EsdTrs0220Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		SearchAgmtHdrVO[] searchAgmtHdrVOs = event.getSearchAgmtHdrVOs();
		try {
			AgreementImportBC command = new AgreementImportBCImpl();
			for ( int i=0; i<searchAgmtHdrVOs.length; i++ ) {
				eventResponse = command.searchAgmtDupChk(searchAgmtHdrVOs[i]);
			}
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 저장 이벤트 처리<br>
	 * Agreement Creation & Add 화면의 Agreement Header정보 저장<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiAgmtHdr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0220Event event = (EsdTrs0220Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		SearchAgmtHdrVO[] searchAgmtHdrVOs = event.getSearchAgmtHdrVOs();
		try {
			AgreementImportBC command = new AgreementImportBCImpl();
			eventResponse = command.multiAgmtHdr(searchAgmtHdrVOs[0]);
//			for ( int i=0; i<searchAgmtHdrVOs.length; i++ ) {
//				eventResponse = command.multiAgmtHdr(searchAgmtHdrVOs[i]);
//			}
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 수정 이벤트 처리<br>
	 * Agreement Agreement Header정보 수정<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiAgmtHdrRmk(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0220Event event = (EsdTrs0220Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			AgreementImportBC command = new AgreementImportBCImpl();
			eventResponse = command.multiAgmtHdrRmk(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 저장 이벤트 처리<br>
	 * Agreement Creation & Add 화면의 Agreement S/P 정보 저장<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiAgmtHdrVndr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0220Event event = (EsdTrs0220Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			AgreementImportBC command = new AgreementImportBCImpl();
			eventResponse = command.multiAgmtHdrVndr(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Verify 이벤트 처리<br>
	 * Agreement Creation / Correction 화면의 Pair Type Agreement Verify<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyAgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0221Event event = (EsdTrs0221Event)e;
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = new GeneralEventResponse();
		String trsp_agmt_rt_tp_cd = event.getFm_trsp_agmt_rt_tp_cd();
		try {
			AgreementImportBC command 	= new AgreementImportBCImpl();
			//create Sequence 
			String newAgmtTmpSeq = command.createAgmtVerifyNewTmpSeq();
			event.setTrspAgmtTmpSeq(newAgmtTmpSeq);
			
			begin();
			command.insertAgmtVerifyData(event);
			commit();

			if (trsp_agmt_rt_tp_cd.equals("P")) {
				eventResponse = command.verifyAgmtPair(event);
			}else if (trsp_agmt_rt_tp_cd.equals("D")) {
				eventResponse = command.verifyAgmtDistance(event);
			}
			
			begin();
			command.deleteAgmtVerifyData(event);
			commit();
		}catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ee){
			log.error("err " + e.toString(), ee);
			throw new EventException(ee.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Agreement Surcharge 화면의 Agreement Surcharge Rate Verify<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyAgmtSurcharge(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0221Event event = (EsdTrs0221Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			AgreementImportBC command = new AgreementImportBCImpl();
			//create Sequence 
			String newAgmtTmpSeq = command.createAgmtVerifyNewTmpSeq();
			event.setTrspAgmtTmpSeq(newAgmtTmpSeq);
			
			begin();
			command.insertAgmtVerifyData(event);
			commit();
			
			eventResponse = command.verifyAgmtSurcharge(event);
			
			begin();
//			command.deleteAgmtVerifyData(event);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	

	/**
	 * 조회 이벤트 처리<br>
	 * US RAIL Surcharge 화면의 US RAIL Agreement Fuel Surcharge 조회<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRailFuelScgAgmt(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			AgreementRailScgBC command = new AgreementRailScgBCImpl();
			eventResponse = command.searchRailFuelScgAgmt(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 저장 이벤트 처리<br>
	 * US RAIL Surcharge 화면의 US RAIL Agreement Fuel Surcharge 저장<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiRailFuelScgAgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0223Event event = (EsdTrs0223Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			begin();
			AgreementRailScgBC command = new AgreementRailScgBCImpl();
			command.multiRailFuelScgAgmt(event);
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
	 * US RAIL Surcharge 화면의 US RAIL Agreement Fixed Surcharge 조회<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRailFixScgAgmt(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			AgreementRailScgBC command = new AgreementRailScgBCImpl();
			eventResponse = command.searchRailFixScgAgmt(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 저장 이벤트 처리<br>
	 * US RAIL Surcharge 화면의 US RAIL Agreement Fixed Surcharge 저장<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiRailFixScgAgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0223Event event = (EsdTrs0223Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			begin();
			AgreementRailScgBC command = new AgreementRailScgBCImpl();
			command.multiRailFixScgAgmt(event);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 삭제 이벤트 처리<br>
	 * US RAIL Surcharge 화면의 US RAIL Agreement Fuel Surcharge 삭제<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteRailFuelScgAgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0223Event event = (EsdTrs0223Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			begin();
			AgreementRailScgBC command = new AgreementRailScgBCImpl();
			command.deleteRailFuelScgAgmt(event);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 삭제 이벤트 처리<br>
	 * US RAIL Surcharge 화면의 US RAIL Agreement Fixed Surcharge 삭제<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteRailFixScgAgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0223Event event = (EsdTrs0223Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			begin();
			AgreementRailScgBC command = new AgreementRailScgBCImpl();
			command.deleteRailFixScgAgmt(event);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 저장 이벤트 처리<br>
	 * US RAIL Surcharge 화면의 US RAIL Agreement Fuel Surcharge Verify<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRailFuelFixScgAgmtVerify(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0223Event event = (EsdTrs0223Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = new GeneralEventResponse();
		
		try {
			AgreementRailScgBC command = new AgreementRailScgBCImpl();
			//create Sequence 
			String newRailScgSeq = command.searchRailFuelFixScgAgmtVerifySeq();
			event.setAgmtRailTmpSeq(newRailScgSeq);
			
			begin();
			command.insertRailFuelFixScgAgmtVerifyData(event);
			commit();
			
			if( event.getScgKnd().equals("FSG") || event.getScgKnd().equals("ISG") ){
				eventResponse = command.verifyAgmtFuel(event);					
			}else if( event.getScgKnd().equals("TTL") ){
				eventResponse = command.verifyAgmtFix(event);				
			}
			
			begin();
			command.deleteRailFuelFixScgAgmtVerifyData(event);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Agreement Summary 화면의 Agreement Rate 조회<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCorrSumAgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0224Event event = (EsdTrs0224Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			AgreementCorrectionBC command = new AgreementCorrectionBCImpl();
			eventResponse = command.searchCorrSumAgmt(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 삭제 이벤트 처리<br>
	 * Agreement Summary 화면의 Agreement Rate 삭제<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteCorrSumAgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0224Event event = (EsdTrs0224Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			AgreementCorrectionBC command = new AgreementCorrectionBCImpl();
			eventResponse = command.deleteCorrSumAgmt(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Agreement Summary 화면의 Sub Office 조회<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSubOfcCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0221Event event = (EsdTrs0221Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			AgreementImportBC command = new AgreementImportBCImpl();
			eventResponse = command.searchSubOfcCd(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Agreement Rate Correction 화면의 Agreement Rate 조회<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCorrRateAgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0226Event event = (EsdTrs0226Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			AgreementCorrectionBC command = new AgreementCorrectionBCImpl();
			eventResponse = command.searchCorrRateAgmt(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 엑셀 다운로드 이벤트 처리<br>
	 * searchCorrRateAgmtExcelDown의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCorrRateAgmtExcelDown(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0226Event event = (EsdTrs0226Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {			
			AgreementCorrectionBC command = new AgreementCorrectionBCImpl();
			String fm_eq_knd_cd = event.getFm_eq_knd_cd();

			eventResponse.setCustomData("rowset", command.getRowSet2(event));
			eventResponse.setCustomData("title", command.getTitle2(fm_eq_knd_cd));
			eventResponse.setCustomData("columns", command.getColumns2(fm_eq_knd_cd));
			eventResponse.setCustomData("fileName", "TRS_0213_EXCEL.xls");
			eventResponse.setCustomData("isZip", true);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}		
	/**
	 * 삭제 이벤트 처리<br>
	 * Agreement Rate Correction 화면의 Agreement Rate 삭제<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteCorrRateAgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0221Event event = (EsdTrs0221Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			AgreementImportBC command 	= new AgreementImportBCImpl();
			//create Sequence 
			String newAgmtTmpSeq = command.createAgmtVerifyNewTmpSeq();
			event.setTrspAgmtTmpSeq(newAgmtTmpSeq);
			
			begin();
			command.insertAgmtVerifyData(event);
			commit();
			
			eventResponse = command.deleteCorrRateAgmt(event);
			
			begin();
			command.deleteAgmtVerifyData(event);
			commit();

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 삭제 이벤트 처리<br>
	 * Agreement Rate Correction 화면의 Agreement Rate 수정<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiCorrRateAgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0221Event event = (EsdTrs0221Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			AgreementImportBC command 	= new AgreementImportBCImpl();
			//create Sequence 
			String newAgmtTmpSeq = command.createAgmtVerifyNewTmpSeq();
			event.setTrspAgmtTmpSeq(newAgmtTmpSeq);
			
			begin();
			command.insertAgmtVerifyData(event);
			commit();
			
			begin();
			eventResponse = command.multiCorrRateAgmt(event);
			commit();
			
			begin();
			command.deleteAgmtVerifyData(event);
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
	 * Agreement Rate History 화면의 Rate History 조회<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateHisAgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0227Event event = (EsdTrs0227Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			AgreementHisBC command = new AgreementHisBCImpl();
			eventResponse = command.searchRateHisAgmt(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
		
	/**
	 * 멀티 이벤트 처리<br>
	 * Agreement Rate History 화면의 Rate History 저장<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse saveTrsAgmtEqRtHis(Event e) throws EventException {
		try {
			begin();
			AgreementHisBC command = new AgreementHisBCImpl();
			command.saveTrsAgmtEqRtHis(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}		
		return this.searchRateHisAgmt(e);
	}	
	
	
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Agreement Surcharge Correction화면의 Surcharge Rate 조회<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCorrScgAgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0229Event event = (EsdTrs0229Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			AgreementCorrectionBC command = new AgreementCorrectionBCImpl();
			eventResponse = command.searchCorrScgAgmt(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 엑셀 다운로드 이벤트 처리<br>
	 * searchCorrScgAgmtExcelDown의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCorrScgAgmtExcelDown(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0229Event event = (EsdTrs0229Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {			
			AgreementCorrectionBC command = new AgreementCorrectionBCImpl();
			String fm_eq_knd_cd = event.getFm_eq_knd_cd();

			eventResponse.setCustomData("rowset", command.getRowSet1(event));
			eventResponse.setCustomData("title", command.getTitle1(fm_eq_knd_cd));
			eventResponse.setCustomData("columns", command.getColumns1(fm_eq_knd_cd));
			eventResponse.setCustomData("fileName", "TRS_0212_EXCEL.xls");
			eventResponse.setCustomData("isZip", true);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
	 * 삭제 이벤트 처리<br>
	 * Agreement Surcharge Correction화면의 Surcharge Rate 삭제<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteCorrScgAgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0221Event event = (EsdTrs0221Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			AgreementImportBC command 	= new AgreementImportBCImpl();
			//create Sequence 
			String newAgmtTmpSeq = command.createAgmtVerifyNewTmpSeq();
			event.setTrspAgmtTmpSeq(newAgmtTmpSeq);
			
			begin();
			command.insertAgmtVerifyData(event);
			commit();
			
			eventResponse = command.deleteCorrScgAgmt(event);
			
			begin();
			command.deleteAgmtVerifyData(event);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
	 * Agreement  Correction 화면의 권한체크<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAuthChk(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0221Event event = (EsdTrs0221Event)e;
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = new GeneralEventResponse();
		try {
			AgreementImportBC command 	= new AgreementImportBCImpl();
			eventResponse = command.searchAuthChk(event, account);
		}catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ee){
			log.error("err " + e.toString(), ee);
			throw new EventException(ee.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 삭제 이벤트 처리<br>
	 * Agreement Surcharge Correction화면의 Surcharge Rate 수정<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiCorrScgAgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0221Event event = (EsdTrs0221Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			AgreementImportBC command 	= new AgreementImportBCImpl();
			//create Sequence 
			String newAgmtTmpSeq = command.createAgmtVerifyNewTmpSeq();
			event.setTrspAgmtTmpSeq(newAgmtTmpSeq);
			
			begin();
			command.insertAgmtVerifyData(event);
			commit();
			
			begin();
			eventResponse = command.multiCorrScgAgmt(event);
			commit();
			
			begin();
			command.deleteAgmtVerifyData(event);
			commit();

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Save 이벤트 처리<br>
	 * HJS-HJL Handling Fee Management save<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse saveHjlHndlFee(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0240Event event = (EsdTrs0240Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			AgreementImportBC command 	= new AgreementImportBCImpl();
			
			begin();
			eventResponse = command.saveHjlHndlFee(event);
			commit();

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	
    /**
	 * 조회 이벤트 처리<br>
	 * Agreement Surcharge Rate History 화면의 Rate History 조회<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScgHisAgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0230Event event = (EsdTrs0230Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			AgreementHisBC command = new AgreementHisBCImpl();
			eventResponse = command.searchScgHisAgmt(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * Agreement Surcharge Rate History 화면의 Rate History 저장<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse saveScgHisAgmt(Event e) throws EventException {
		try {
			begin();
			AgreementHisBC command = new AgreementHisBCImpl();
			command.saveScgHisAgmt(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}		
		return this.searchScgHisAgmt(e);
	}	
	

	/**
	 * 조회 이벤트 처리<br>
	 * Agreement Rate 화면의 Rate 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDtlAgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0231Event event = (EsdTrs0231Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			AgreementHisBC command = new AgreementHisBCImpl();
			eventResponse = command.searchDtlAgmt(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Agreement Rate 화면의 Rate 조회(Effective date 형식으로)<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDtlAgmtEffDt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0231Event event = (EsdTrs0231Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			AgreementHisBC command = new AgreementHisBCImpl();
			eventResponse = command.searchDtlAgmtEffDt(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Agreement Rate 화면의 Rate 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScgDtlAgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0235Event event = (EsdTrs0235Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			AgreementHisBC command = new AgreementHisBCImpl();
			eventResponse = command.searchScgDtlAgmt(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Agreement No 조회<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgmtNo(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			AgreementRailScgBC command = new AgreementRailScgBCImpl();
			eventResponse = command.searchAgmtNo(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * US RAIL Surcharge 화면의 US RAIL Agreement Surcharge History 조회<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRailScgAgmtHis(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			AgreementRailScgBC command = new AgreementRailScgBCImpl();
			eventResponse = command.searchRailScgAgmtHis(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * US RAIL Surcharge 화면의 US RAIL Agreement Surcharge History Popup 조회<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRailScgAgmtHisPop(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			AgreementRailScgBC command = new AgreementRailScgBCImpl();
			eventResponse = command.searchRailScgAgmtHisPop(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Type Size 조회 <br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTpSz(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		EsdTrs0231Event 	event 			= (EsdTrs0231Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse 		eventResponse 	= null;
		
		try {
			AgreementHisBC command = new AgreementHisBCImpl();
			eventResponse = command.searchTpSz(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * HJS-HJL Handling Fee Management정보 조회<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHjlHndlFee(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0240Event event = (EsdTrs0240Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			AgreementImportBC command = new AgreementImportBCImpl();
			eventResponse = command.searchHjlHndlFee(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * HJS-HJL Handling Fee Management정보 History 포함 조회<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHjlHndlFeeHis(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0240Event event = (EsdTrs0240Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			AgreementImportBC command = new AgreementImportBCImpl();
			eventResponse = command.searchHjlHndlFeeHis(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * US RAIL Surcharge 화면의 US RAIL Agreement Surcharge History 삭제여부 저장<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse saveTrsAgmtRailScgRtHis(Event e) throws EventException {
		try {
			begin();
			AgreementRailScgBC command = new AgreementRailScgBCImpl();
			command.saveTrsAgmtRailScgRtHis(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}		
		return this.searchRailScgAgmtHis(e);
	}
	/**
	 * 조회 이벤트 처리<br>
	 * US RAIL Surcharge 화면의 US RAIL Agreement Incentive 조회<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRailIsgScgAgmt(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			AgreementRailScgBC command = new AgreementRailScgBCImpl();
			eventResponse = command.searchRailIsgScgAgmt(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 저장 이벤트 처리<br>
	 * US RAIL Surcharge 화면의 US RAIL Agreement Incentive 저장<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiRailIsgScgAgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0223Event event = (EsdTrs0223Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			begin();

			AgreementRailScgBC command = new AgreementRailScgBCImpl();
			command.multiRailIsgScgAgmt(event);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 삭제 이벤트 처리<br>
	 * US RAIL Surcharge 화면의 US RAIL Agreement Incentive 삭제<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteRailIsgScgAgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0223Event event = (EsdTrs0223Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			begin();
			AgreementRailScgBC command = new AgreementRailScgBCImpl();
			command.deleteRailIsgScgAgmt(event);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Agreement 결재자 리스트 조회<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchApprovalList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0237Event event = (EsdTrs0237Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			AgreementApprovalBC command = new AgreementApprovalBCImpl();
			eventResponse = command.searchApprovalList(event, account);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 저장 이벤트 처리<br>
	 * Agreement 결재자 저장<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse saveApprovalList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0237Event event = (EsdTrs0237Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			begin();
			AgreementApprovalBC command = new AgreementApprovalBCImpl();
			command.saveApprovalList(event, account);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 저장 이벤트 처리<br>
	 * Agreement 결재자 삭제<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse delApprovalList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0237Event event = (EsdTrs0237Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			AgreementApprovalBC command = new AgreementApprovalBCImpl();
			command.delApprovalList(event, account);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Confirm 이벤트 처리<br>
	 * Agreement Summary 화면의 Agreement Confirm<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmAgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0224Event event = (EsdTrs0224Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			begin();
			AgreementCorrectionBC command = new AgreementCorrectionBCImpl();
			eventResponse = command.confirmAgmt(event, account);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Confirm 이벤트 처리<br>
	 * Agreement Summary 화면의 Agreement Confirm Button 활성화<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmAgmtBtn(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0224Event event = (EsdTrs0224Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		TrsAgmtRtTpVO vo=null;
		try {
			AgreementCorrectionBC command = new AgreementCorrectionBCImpl();
			String btnConfirm =  command.confirmAgmtBtn(event, account);
			eventResponse.setETCData("btnConfirm", btnConfirm);
//			eventResponse.setRsVo(vo);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
    /**
	 * 조회 이벤트 처리<br>
	 *  Sheet에 USER ID로 USER NAME을 가져오는 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUsrId(Event e) throws EventException{
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0237Event event = (EsdTrs0237Event)e;
		
		SearchApprovalMgmtVO vo = new SearchApprovalMgmtVO();
		try {
			AgreementApprovalBC command = new AgreementApprovalBCImpl();
			vo = command.searchUsrId(event);

			String cfmUsrNm = vo.getCreUsrNm();  
			String cfmOfcCd  = vo.getCfmOfcCd();
			
			eventResponse.setETCData("cfmUsrNm", cfmUsrNm);			
			eventResponse.setETCData("cfmOfcCd", cfmOfcCd);
			eventResponse.setRsVo(vo);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Agreement Contract Attach 조회<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContract(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0243Event event = (EsdTrs0243Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			ContractAttachBC command = new ContractAttachBCImpl();
			eventResponse = command.searchContract(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	

	/**
	 * 저장 이벤트 처리<br>
	 * Agreement Contract Attach 저장<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiContractRgst(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0243Event event = (EsdTrs0243Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			begin();
			ContractAttachBC command = new ContractAttachBCImpl();
			command.multiContractRgst(event, account);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 삭제 이벤트 처리<br>
	 * Agreement Contract Attach 삭제<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteContract(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0243Event event = (EsdTrs0243Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			ContractAttachBC command = new ContractAttachBCImpl();
			command.deleteContract(event, account);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Fuel Surcharge (FUA) Correction 조회<br>
	 * @param e
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFuelSurchargeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0280Event event = (EsdTrs0280Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			FuelScgManageBC command = new FuelScgManageBCImpl();
			eventResponse = command.searchFuelSurchargeList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	
	
	/**
	 * 조회 이벤트 처리<br>
	 *  Fuel Surcharge (FUA) Correction 화면의 Agreement FUA Surcharge Rate Verify<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyFuelScgAgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0280Event event = (EsdTrs0280Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			FuelScgManageBC command = new FuelScgManageBCImpl();
			//create Sequence 
			String newAgmtTmpSeq = command.createAgmtVerifyNewTmpSeq();
			event.setTrspAgmtTmpSeq(newAgmtTmpSeq);
			
			begin();
			command.insertFeulScgAgmtVerifyData(event,account);
			commit();
			
			eventResponse = command.verifyFuelScgAgmt(event);
			
			begin();
			command.deleteFuelScgAgmtVerifyData(event);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 삭제 이벤트 처리<br>
	 * Fuel Surcharge (FUA) Correction 화면의  FUA SCG Agreement Rate 수정<br>
	 * @param e 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiCorrFuelScgRateAgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0280Event event = (EsdTrs0280Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			FuelScgManageBC command = new FuelScgManageBCImpl();
			//create Sequence 
			String newAgmtTmpSeq = command.createAgmtVerifyNewTmpSeq();
			event.setTrspAgmtTmpSeq(newAgmtTmpSeq);
			
			begin();
			command.insertFeulScgAgmtVerifyData(event,account);
			commit();
			
			begin();
			eventResponse = command.multiCorrFuelScgRateAgmt(event,account);
			commit();
			
			begin();
			command.deleteFuelScgAgmtVerifyData(event);
			commit();

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
	 * 삭제 이벤트 처리<br>
	 * Fuel Surcharge (FUA) Correction 화면의 FUA SCG Agreement Rate 삭제<br>
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteCorrFuelScgRateAgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0280Event event = (EsdTrs0280Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			FuelScgManageBC command = new FuelScgManageBCImpl();
			//create Sequence 
			String newAgmtTmpSeq = command.createAgmtVerifyNewTmpSeq();
			event.setTrspAgmtTmpSeq(newAgmtTmpSeq);
			
			begin();
			command.insertFeulScgAgmtVerifyData(event,account);
			commit();
			
			eventResponse = command.deleteCorrFuelScgRateAgmt(event,account);
			
			begin();
			command.deleteFuelScgAgmtVerifyData(event);
			commit();

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	

}
