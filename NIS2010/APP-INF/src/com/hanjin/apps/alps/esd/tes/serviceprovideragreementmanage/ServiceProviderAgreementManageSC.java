/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ServiceProviderAgreementManageSC.java
*@FileTitle : Terminal Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-08
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2006-09-08 jongbaemoon
* 1.0 최초 생성
* 
*@LastModifyDate : 2009.08.10
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.08.10 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage;

import com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.basic.TerminalAgreementManageBC;
import com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.basic.TerminalAgreementManageBCImpl;
import com.hanjin.apps.alps.esd.tes.common.tescommon.basic.TESCommonBC;
import com.hanjin.apps.alps.esd.tes.common.tescommon.basic.TESCommonBCImpl;
import com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes0034Event;
import com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes0039Event;
import com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes0040Event;
import com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes9070Event;
import com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes9160Event;
import com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes9170Event;
import com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes9180Event;
import com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration.TerminalAgreementManageDBDAO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ComUpldFileVO;

/**
 * ALPS-ServiceProviderAgreementManage Business Logic ServiceCommand - ALPS-ServiceProviderAgreementManage 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author yOng hO lEE
 * @see TerminalAgreementManageDBDAO
 * @since J2EE 1.6
 */
public class ServiceProviderAgreementManageSC extends ServiceCommandSupport {
	// Login User Information
	@SuppressWarnings("unused")
	private SignOnUserAccount account = null;
 
	/**
	 * ESD 업무 시나리오 선행작업<br>
	 * TerminalAgreementManage업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account=getSignOnUserAccount();
		} catch (Exception e) {
			log.error("ServiceProviderAgreementManageSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * ESD 업무 시나리오 마감작업<br>
	 * TerminalAgreementManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("ServiceProviderAgreementManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-ESD 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분

		/**
		 * Agreement Creation && Correction
		 */
		if (e.getEventName().equalsIgnoreCase("EsdTes0034Event")) {
			// Terminal Info 등록
			if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = createTerminalAgreementBasicInfo(e);
			// Agreement Header Info 조회
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTerminalAgreementInfo(e);
			// Throughput Cost Code Save 시 조회
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchThorougputCostCode(e);
			// Terminal Rate List 조회
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchTerminalAgreementDetail(e);
			// Storage Rate List 조회
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchStorageAgreementDetail(e);
			// lane code 변경시 조회
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchTerminalAgreement(e);
			// 
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchCostCodeVerifyList(e);
			// Yard, Vendor 조회
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchAgreementYardVendor(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = verifySheetTerminalAgreement(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				// 로직만 수정  2009-10-07
				eventResponse = modifyTerminalAgreementInfo(e);
			// 비용지급 전표 결재 기능 - 3차 GW
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = modifyTerminalAgreementContractInfo(e);
				// Throughput Cost Code Save 시 조회후 저장
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createTerminalAgreementNo(e);
			// Register Agreement Confirm Save. ( Terminal Rate, Storage Rate )
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = registerAgreementConfirm(e);
			// Terminal Storage Rate List Confirm Save
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = mutilAgreement(e);
			// Agreement Register Before
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = regBeforeCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				// 로직만 수정  2009-10-07
				eventResponse = modifyTerminalAgreementDelete(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeAgreement(e);		
			} else {
				eventResponse = loadTerminalAgreement(e); // 화면 최초 호출 시 실행
			}
//			사용되는곳 안보임 2009-10-12
//			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
//				eventResponse = multiTerminalAgreement(e);
//			사용되는곳 안보임 2009-10-12
//			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
//				eventResponse = searchTerminalAgreementInfoCheck(e);
//			사용되는곳 안보임 2009-10-12
//			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)) {
//				eventResponse = createStorageAgreement(e);			
		}

		/**
		 * Terminal Agreement Summary Inquiry
		 */
		if (e.getEventName().equalsIgnoreCase("EsdTes0039Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTerminalAgreeementSummaryList(e);
			}
		}

		/**
		 * Terminal Agreement Detail 조회. by kimjinjoo
		 */
		if (e.getEventName().equalsIgnoreCase("EsdTes0040Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				if(log.isDebugEnabled()) log.debug("\n "+e.getEventName()+" - SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");
				eventResponse = searchTerminalAgreementManage(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				if(log.isDebugEnabled()) log.debug("\n "+e.getEventName()+" - SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");
				eventResponse = searchTerminalAgreementTerminalRateDetail(e);
			}
		}


		/**
		 * Cost Code Remark
		 */
		if (e.getEventName().equalsIgnoreCase("EsdTes9070Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAgreementPopUpList(e);
			}
		}

		/**
		 * Terminal Rate List Excel Load
		 */
		if (e.getEventName().equalsIgnoreCase("EsdTes9160Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = verifyExcelTerminalAgreement(e);
			}
		}
		
		/**
		 * Storage Rate List Excel Load
		 */
		if (e.getEventName().equalsIgnoreCase("EsdTes9170Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = verifyExcelStorageAgreement(e);
			}
		}

		/**
		 * Throughput Cost Code
		 */
		if (e.getEventName().equalsIgnoreCase("EsdTes9180Event")) {
			if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = createThoroughputCC(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchThoroughputCC(e);
			} else {
				eventResponse = searchThoroughputCC(e);
			}
		}

		/**
		 * Volume Accumulate Method
		 */
		if (e.getEventName().equalsIgnoreCase("EsdTes9200Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVolumeAccumulateMethodManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiVolumeAccumulateMethodManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeVolumeAccumulate(e);
			}else {
				eventResponse = searchVolumeAccumulateMethodManage(e);
			}
		}

		return eventResponse;
	}


	/**
	 * 조회 이벤트 처리<br>
	 * TerminalAgreementManage 화면에 대한 조회 이벤트 처리<br>
	 *
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgreementYardVendor(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EsdTes0034Event event = (EsdTes0034Event)e;

		EventResponse	eventResponse	= null;

		try {
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			eventResponse = command.searchAgreementYardVendor(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * TerminalAgreementManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTerminalAgreementDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0034Event	event			= (EsdTes0034Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse	eventResponse	= null;

		try {
			TerminalAgreementManageBC	command	= new TerminalAgreementManageBCImpl();
			eventResponse	= command.searchTerminalAgreementDetail(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * TerminalAgreementManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTerminalAgreement(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0034Event		event	= (EsdTes0034Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse		eventResponse = null;

		try {
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			eventResponse = command.searchTerminalAgreement(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * TerminalAgreementManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStorageAgreementDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0034Event event = (EsdTes0034Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			eventResponse = command.searchStorageAgreementDetail(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * 마스터 입력부분 입력정보로 데이터 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTerminalAgreementInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0034Event		event	= (EsdTes0034Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse		eventResponse	= null;

		try {
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			eventResponse = command.searchTerminalAgreementInfo(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * 마스터 입력 부분 Creation시 yard, vender, eff date 등 중복 데이터 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
//	private EventResponse searchTerminalAgreementInfoCheck(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		EsdTes0034Event event = (EsdTes0034Event)e;
//		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
//		EventResponse eventResponse = null;
//
//		try {
//			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
////			eventResponse = command.searchTerminalAgreementInfoCheck(event);
//		} catch (EventException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//		return eventResponse;
//	}

	/**
	 * 조회 이벤트 처리<br>
	 * Cost Code Verify 로직을 위한 Cost Code Verify 정보 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostCodeVerifyList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0034Event	event			= (EsdTes0034Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse	eventResponse	= null;

		try {
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			eventResponse = command.searchCostCodeVerifyList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Thorougput CostCode event에 대한 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchThorougputCostCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0034Event event = (EsdTes0034Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			eventResponse = command.searchThorougputCostCode(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Verify Terminal Agreement event에 대한 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse verifySheetTerminalAgreement(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EsdTes0034Event		event			= (EsdTes0034Event)e;
		EventResponse		eventResponse	= null;

		try {
			TerminalAgreementManageBC	command	= new TerminalAgreementManageBCImpl();
			eventResponse	= command.verifySheetTerminalAgreement(event);
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse;
	}


	// 사용되는곳 없음 ( 2009-10-01 )
//	private EventResponse verifySheetStorageAgreement(Event e) throws EventException {
//		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
//		EsdTes0034Event event = (EsdTes0034Event)e;
//		EventResponse eventResponse = null;
//
//		try {
//			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
//			eventResponse = command.verifySheetStorageAgreement(event);
//		} catch (EventException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//		return eventResponse;
//	}

	private EventResponse verifyExcelTerminalAgreement(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EsdTes9160Event event = (EsdTes9160Event)e;
		EventResponse eventResponse = null;

		try {
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			eventResponse = command.verifyExcelTerminalAgreement(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}


	private EventResponse verifyExcelStorageAgreement(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EsdTes9170Event event = (EsdTes9170Event)e;
		EventResponse eventResponse = null;

		try {
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			eventResponse = command.verifyExcelStorageAgreement(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	private EventResponse regBeforeCheck(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EsdTes0034Event event = (EsdTes0034Event)e;
		EventResponse eventResponse = null;

		try {
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			eventResponse = command.regBeforeCheck(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 추가 이벤트 처리<br>
	 * TerminalAgreementManage Cofirm의 event에 대한 추가 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse registerAgreementConfirm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0034Event event = (EsdTes0034Event)e;

		try {
			begin();
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			command.registerAgreementConfirm(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return this.searchTerminalAgreement(e);
	}

	/**
	 * 추가 이벤트 처리<br>
	 * TerminalAgreementManage의 event에 대한 추가 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createTerminalAgreementBasicInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0034Event event = (EsdTes0034Event)e;
		EventResponse eventResponse = null;

		try {
			begin();
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			command.createTerminalAgreementBasicInfo(event);
			commit();
			eventResponse = command.searchTerminalAgreementInfo(event);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * 추가 이벤트 처리<br>
	 * TerminalAgreementManage의 event에 대한 추가 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createTerminalAgreementNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0034Event event = (EsdTes0034Event)e;

		try {
			begin();
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			command.createTerminalAgreementNo(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return this.searchTerminalAgreementInfo(e);
	}


	/**
	 * 수정 이벤트 처리<br>
	 * TerminalAgreementManage의 event에 대한 수정 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyTerminalAgreementInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0034Event event = (EsdTes0034Event)e;

		try {
			begin();
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			command.modifyTerminalAgreementInfo(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return this.searchTerminalAgreement(e);
	}

	/**
	 * 수정 이벤트 처리<br>
	 * TerminalAgreementManage의 event에 대한 수정 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyTerminalAgreementContractInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0034Event event = (EsdTes0034Event)e;
		
		try {
			begin();
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			command.modifyTerminalAgreementContractInfo(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return this.searchTerminalAgreement(e);
	}
	
	/**
	 * 삭제 이벤트 처리<br>
	 * TerminalAgreementManage의 event에 대한 삭제 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyTerminalAgreementDelete(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0034Event event = (EsdTes0034Event)e;

		try {
			begin();
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			command.modifyTerminalAgreementDelete(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return this.searchTerminalAgreement(e);
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * TerminalAgreementManage의 event에 대한 멀티 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse mutilAgreement(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//EsdTes0034Event event = (EsdTes0034Event)e;
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse	eventResponse = null;

		try {
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			String	invoiceUseFlg	= command.searchInvoiceHDR(e);
			begin();
			// New FrameWork 적용후 eventResponse 를 Return 해 준다. ( 2009-10-13 )
			eventResponse = command.mutilAgreement(e,invoiceUseFlg);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse;
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * TerminalAgreementManage의 event에 대한 멀티 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse removeAgreement(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//EsdTes0034Event event = (EsdTes0034Event)e;
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse	eventResponse = null;

		try {
			begin();
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			// New FrameWork 적용후 eventResponse 를 Return 해 준다. ( 2009-10-13 )
			eventResponse = command.removeAgreement(e);
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
	 * TerminalAgreement Summary 화면에 대한 조회 이벤트 처리<br>
	 *
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTerminalAgreeementSummaryList(Event e) throws EventException {
		EsdTes0039Event			event			= (EsdTes0039Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse	eventResponse	= null;

		try {
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			eventResponse = (GeneralEventResponse)command.searchTerminalAgreeementSummaryList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * TerminalAgreementManage 화면에 대한 조회 이벤트 처리<br>
	 *
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgreementPopUpList(Event e) throws EventException {
		EsdTes9070Event event = (EsdTes9070Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			eventResponse = command.searchAgreementPopUpList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Throughput Cost Code 화면에 대한 조회 이벤트 처리<br>
	 *
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchThoroughputCC(Event e) throws EventException {
		EsdTes9180Event event = (EsdTes9180Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			eventResponse = command.searchThoroughputCC(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 추가 이벤트 처리<br>
	 * TerminalAgreementManage의 event에 대한 추가 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createThoroughputCC(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes9180Event event = (EsdTes9180Event)e;

		try {

			begin();
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			command.deleteThoroughputCC(event);
			command.createThoroughputCC(event);
			commit();

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return this.searchThoroughputCC(e);
	}


//	===== Vol. Accumulate Method ========================================================
	/**
	 * 조회 이벤트 처리<br>
	 * searchVolumeAccumulateMethodManage event에 대한 멀티 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchVolumeAccumulateMethodManage(Event e) throws EventException {

		//EsdTes9200Event event = (EsdTes9200Event)e;
		EventResponse eventResponse = null;

		try {
			begin();
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			eventResponse = command.searchVolumeAccumulatedMethod(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * multiVolumeAccumulateMethodManage event에 대한 멀티 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiVolumeAccumulateMethodManage(Event e) throws EventException {

		try {
			begin();

			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();

			command.multiVolumeAccumulatedMethod(e);
			command.removeListVolumeAccumulatedCostCode(e);
			command.multiVolumeAccumulatedCostCode(e);
			command.multiVolumeAccumulatedYard(e);

			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return this.searchVolumeAccumulateMethodManage(e);
	}


	/**
	 * 삭제 이벤트 처리<br>
	 * multiVolumeAccumulateMethodManage event에 대한 멀티 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse removeVolumeAccumulate(Event e) throws EventException {
		if(log.isDebugEnabled())log.debug("\n[ServiceProviderAgreementManageSC][removeVolumeAccumulate]");
//		EsdTes9200Event event = (EsdTes9200Event)e;
		//EventResponse eventResponse = null;

		try {
			begin();

			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			command.removeVolumeAccumulate(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return this.searchVolumeAccumulateMethodManage(e);
	}


	/**
	 * Terminal Agreement Detail 조회시작 . by kimjinjoo
	 */

	/**
	 * 조회 이벤트 처리<br>
	 * terminalagreementmanage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 * @author kimjinjoo
	 */
	private EventResponse searchTerminalAgreementManage(Event e) throws EventException {
		log.debug("\n\n=================== ServiceProviderAgreementManageSC :::: searchTerminalAgreementManage============\n");
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0040Event event = (EsdTes0040Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			eventResponse = command.searchTerminalAgreementManage(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * TerminalAgreementManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 * @author kimjinjoo
	 */
	private EventResponse searchTerminalAgreementTerminalRateDetail(Event e) throws EventException {
		log.debug("\n\n=================== ServiceProviderAgreementManageSC :::: searchTerminalAgreementTerminalRateInquiryDetail============\n");
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0040Event event = (EsdTes0040Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			eventResponse = command.searchTerminalAgreementTerminalRateDetail(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		//return this.searchTerminalRateList(e);
		return eventResponse;
	}

	/**
	 * ESD_TES_0034 : Load Page <br>
	 * 화면 로딩시 Excel template을 loading. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse loadTerminalAgreement(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TESCommonBC command1 = new TESCommonBCImpl();
		
		try{
			// Excel Template File Key
			ComUpldFileVO comUpldFileVO = new ComUpldFileVO();
//			comUpldFileVO.setFileUpldNm("TES_Agreement_Templet.xls");
			comUpldFileVO.setFileUpldNm("agreement_new_version_storage_1.xls");
			String fileKey = command1.searchExcelTemplateFileKey(comUpldFileVO);
			eventResponse.setCustomData("templateKey", fileKey);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
}