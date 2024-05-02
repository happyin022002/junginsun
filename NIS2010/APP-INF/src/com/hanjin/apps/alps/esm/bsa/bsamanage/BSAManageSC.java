/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : BSAManageSC.java
 *@FileTitle : BSA Manage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-02
 *@LastModifier : KimJongBeom
 *@LastVersion : 1.0
 * 2006-10-02 KimJongBeom
 * 1.0 최초 생성 
 =========================================================
 * History :
 * 2008.05.07 PEJ Error Message 변경 
 * 2008.10.01 전성진 CSR No.N200809059194 : Over Used Slot Price Table 생성 
 * 2008.10.24 전성진 CSR No.N200810100017 [030] : Slot Price 및 TEU & Slot Price 화면 추가
 * 2009.05.21 김종열 CSR No.N200904020151 : BSA Legacy 변경 관련 수정 
 * 2009.07.01 김종열 CSR No.N200905220063 : H/C Rate 개발 관련 수정                 
 * 2009.08.14 Kim Ki-Dae ENIS --> ALPS 변환     1.0 Creation   
 * 2010.05.18 NKJH : 아키텍처 개발표준 변경에 따른 FormCommand 변경 : COMMAND -> MUILT,MODIFY등 상황에 맞게 
 * 2010.10.04 이행지 [CHM-201005758-01] BSA  Architecture 위배사항 수정 (CommonSC)
 * 2011.07.15 이행지 [CHM-201112101-01] ESM_PRI_0028 화면 검색조건 Currency Code 추가
 * 2011.08.19 최성민 [CHM-201112943-01] Add Carrier Time-Out 에러 수정
 * 2014.12.11 김용습 [CHM-201433095] Overlapped Contract Inquiry 화면 추가
 * 2016.01.29 김성욱 [CHM-201539410] BSA System 개선의 건 / 동일 날짜에 서로 다른 항차 BSA 입력 가능 실현
 =========================================================*/

package com.hanjin.apps.alps.esm.bsa.bsamanage;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.basic.BSAManageBC;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.basic.BSAManageBCImpl;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.event.EsmBsa0021Event;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.event.EsmBsa0023Event;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.event.EsmBsa0035Event;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.event.EsmBsa0123Event;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.event.EsmBsa0024Event;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.event.EsmBsa0026Event;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.event.EsmBsa0028Event;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.event.EsmBsa0120Event;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.event.EsmBsa0162Event;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.event.EsmBsa0172Event;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.integration.BSAManageDBDAO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.BsaTableSaveVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.CreateBSAVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchOverlappedContractInquiryListVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchChgSlotSwapListVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchSpcJoPortDownDetailListVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchSpcJoPortDownMasterListVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchSpcScPortDownDetailListVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchSpcScPortDownMasterListVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.basic.SPCManageBC;
import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.basic.SPCManageBCImpl;
import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.event.EsmBsa0030Event;
import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.event.EsmBsa0032Event;
import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.event.EsmBsa0104Event;
import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.event.EsmBsa0143Event;
import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.vo.SearchSpcConditionVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.vo.SearchSpcSlotInfoByVvdOnVesselListVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.vo.SearchSpcSlotSwapByVvdListVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.vo.SearchStepUpDownVvdDetailListVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.vo.SearchStepUpDownVvdMasterListVO;
import com.hanjin.apps.alps.esm.bsa.common.basic.CommonBC;
import com.hanjin.apps.alps.esm.bsa.common.basic.CommonBCImpl;
import com.hanjin.apps.alps.esm.bsa.common.vo.CommonBsaRsVO;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BsaCrrInfoVO;
import com.hanjin.syscommon.common.table.BsaVvdSwapInfoVO;


/**
 * ALPS-BSAManage Business Logic ServiceCommand - ALPS-BSAManage 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Kim Ki Dae
 * @see BSAManageDBDAO
 * @since J2EE 1.6
 */
public class BSAManageSC extends ServiceCommandSupport {

	SignOnUserAccount account = null;

	String strUserId = "";

	/**
	 * BSAManage 업무 시나리오 선행작업<br>
	 * BSAManage업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
			strUserId = account.getUsr_id();
		} catch (Exception e) {
			log.error("BSAManageSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * BSAManage 업무 시나리오 마감작업<br>
	 * BSAManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("BSAManageSC 종료 ...........................");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * enis-BSAManage 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		
		log.debug("################# BSAManageSC.perform() ############################[START]");
		
		EventResponse eventResponse = null;

		log.debug("\n [CALL] Service Command ------------------------------------------- "
						+ "\n EventName : "
						+ e.getEventName()
						+ "\n Command   : " + e.getFormCommand().getCommand());

		if (e.getEventName().equalsIgnoreCase("EsmBsa0021Event")) {
			log.debug("EsmBsa0021Event이 실행");
			log.debug("e.getFormCommand().getCommand() = " + e.getFormCommand().getCommand());
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { // JO							
				eventResponse = searchBSATableJOList(e);                 // 조회
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { // SC			
				eventResponse = searchBSATableSCList(e); // 조회	
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // JO		
				eventResponse = multiBSATableJO(e); // 저장
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { // SC			
				eventResponse = multiBSATableSC(e); // 저장		
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) { // JO
				eventResponse = removeBSATableJO(e); // 삭제				
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE02)) { // SC
				eventResponse = removeBSATableSC(e);  // 삭제					
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)
					    || e.getFormCommand().isCommand(FormCommand.MULTI04)) { // JO / SC
				eventResponse = createBSA(e); // 생성								
			}
			else { // 초기Load시
				eventResponse = searchInitComBo(e);
				eventResponse.setCustomData(searchBSATableHeaderList(e).getCustomData());
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBsa0123Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {		
				eventResponse = searchBSATableVvdList(e);                 
			}  
			// ESM_BSA_0123 에서 Combo제외 요건에 따라 주석 처리
//			else { // 초기Load시
//				eventResponse = searchInitComBo(e);
//				eventResponse.setCustomData(searchBSATableHeaderList(e).getCustomData());
//			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBsa0023Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCarrierRegisterList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = modifyCarrierRegister(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { 	// BackEndJob 상태값 조회
                eventResponse = searchBackEndJobStatus(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { 	// BackEndJob 결과 조회
                eventResponse = searchBackEndJobGetResult(e);
            } else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiCarrierInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBsa0024Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { // Joint
				eventResponse = searchSPCJOBSA(e);// Operation
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { // swap				
				eventResponse = searchChgSlotSwapList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) { // Space
				eventResponse = searchSPCSCBSA(e);// Chartering						
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiSPCJOBSA(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = multiChgSlotSwap(e);				
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = multiSPCSCBSA(e);
			} else {
				eventResponse = searchInitComBo(e);
				eventResponse.setCustomData(searchCarrierItem(e).getCustomData());
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBsa0026Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {        // JO
				eventResponse = searchSpcJoPortDownMasterList(e); // Master 조회
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { // JO 
				eventResponse = searchSpcJoPortDownDetailList(e); // Detail 조회
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) { // SC		
				eventResponse = searchSpcScPortDownMasterList(e); // Master 조회
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) { // SC	
				eventResponse = searchSpcScPortDownDetailList(e); // Detail 조회
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {      // JO
				eventResponse = multiSPCDownPortJOMaster(e);      // Master 저장
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { 	 // JO
				eventResponse = multiSPCDownPortJODetail(e);  	  // Detail 저장
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) { 	 // SC
				eventResponse = multiSPCDownPortSCMaster(e);	  // Master 저장
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) { 	 // SC
				eventResponse = multiSPCDownPortSCDetail(e);	  // Detail 저장
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) { 	 // JO						
				eventResponse = resetSPCDownPortJO(e);		      // RESET
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) { 	 // SC			
				eventResponse = resetSpcScPortDown(e); 			  // RESET
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {    // JO
				eventResponse = createSpcJoPortDown(e); 		  // 생성
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI06)) {    // SC						
				eventResponse = createSpcScPortDown(e);  		  // 생성
			} else {
				eventResponse = searchInitComBo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBsa0028Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { // 조회
				eventResponse = searchSlotCostList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)
					|| e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { // 조회
				eventResponse = searchRFCostList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)
					|| e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) { // 조회
				eventResponse = searchOverCostList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // 저장
				eventResponse = multiSlotCost(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)
					|| e.getFormCommand().isCommand(FormCommand.MULTI02)) { // 저장
				eventResponse = multiRFCost(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)
					|| e.getFormCommand().isCommand(FormCommand.MULTI04)) { // 저장
				eventResponse = multiOverCost(e);
			} else { // 초기Load시
				eventResponse = searchInitComBo(e);
				eventResponse.setCustomData(searchBsaCrrRgstList(e).getCustomData());
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBsa0172Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { // 조회
				eventResponse = searchBSARateList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { // 조회
				eventResponse = searchBSARateList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) { // 조회
				eventResponse = searchBSARateList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // 저장
				eventResponse = multiBSARate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { // 저장
				eventResponse = multiBSARate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) { // 저장
				eventResponse = multiBSARate(e);
			} else { // 초기Load시
				eventResponse = searchInitComBo(e);
				eventResponse.setCustomData(searchBsaCrrRgstList1(e).getCustomData());
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBsa0162Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { // 조회
				eventResponse = searchOverUsedSlotCostList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // 저장
				eventResponse = multiOverUsedSlotCost(e);
			} else { // 초기Load시
				eventResponse = searchInitComBo(e);
				eventResponse.setCustomData(searchBsaCrrRgstList2(e).getCustomData());
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBsa0030Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { // 조회
				eventResponse = searchSupplySwapVvdList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { // 조회
				eventResponse = searchSlotPrcSwapVvdList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { // 조회
				eventResponse = searchTEUPrcSwapVvdList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) { // 조회
				eventResponse = searchRevCostSwapVvdList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // 생성
				eventResponse = createSupplySwapVvd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) { // RESET
				eventResponse = resetSupplySwapVvd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) { // SAVE
				eventResponse = saveSupplySwapVvd(e); //resetSupplySwapVvd(e);
			} else {
				eventResponse = searchInitComBo(e);
				eventResponse.setCustomData(searchOpJobCarrierList(e).getCustomData());
				eventResponse.setETCData(searchPrevWkPrd(e).getETCData());
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBsa0032Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { // Master 조회
				eventResponse = searchStepUpDownVvdMasterList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // Master 저장
				eventResponse = modifyStepUpDownVvdMaster(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { // Detail  조회
				eventResponse = searchStepUpDownVvdDetailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { // Detail 저장
				eventResponse = multiStepUpDownVvd(e);
			} else {
				eventResponse = searchInitComBo(e);
				eventResponse.setETCData(searchPrevWkPrd(e).getETCData());
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBsa0120Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCarrierInfoList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiCarrierInfo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = multiCarrierInfo(e);
			}
				
		} else if (e.getEventName().equalsIgnoreCase("EsmBsa0104Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { // sheet1 조회
				eventResponse = this.searchSpcSlotInfoByVvdList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // sheet1 저장
				eventResponse = this.multiSpcSlotInfoByVvd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { // sheet2 조회
				eventResponse = this.searchSpcSlotSwapByVvdList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { // sheet2 저장
				eventResponse = this.multiSpcSlotSwapByVvd(e);
			} else {
				eventResponse = searchInitComBo(e);
				eventResponse.setCustomData(searchCarrierItem(e).getCustomData());
				eventResponse.setETCData(searchPrevWkPrd(e).getETCData());
			}			
		} else if (e.getEventName().equalsIgnoreCase("EsmBsa0143Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { // sheet1 조회
				eventResponse = searchSpcSlotInfoByVvdOnVesselList(e);
			} else {
				eventResponse = searchInitComBo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBsa0035Event")) {
			log.debug("EsmBsa0035Event이 실행");
			log.debug("e.getFormCommand().getCommand() = " + e.getFormCommand().getCommand());
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { // JO		
				eventResponse = searchOverlappedContractInquiryJOList(e);                 // 조회
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { // SC			
				eventResponse = searchOverlappedContractInquirySCList(e); // 조회	
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) { // SP			
				eventResponse = searchOverlappedContractInquirySPList(e); // 조회	
			} else { // 초기Load시
				eventResponse = searchInitComBo(e);
				eventResponse.setCustomData(searchBSATableHeaderList(e).getCustomData());
			}
		}
		
		log.debug("################# BSAManageSC.perform() ############################[END]");

		return eventResponse;
	}

	/**
	 * ESM_BSA_0021: 헤더조회 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 헤더조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBSATableHeaderList(Event e) throws EventException {
		log.debug("################# BSAManageSC.searchBSATableHeaderList() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BSAManageBC command = new BSAManageBCImpl();
		try{			
			CommonBsaRsVO rtnVo = command.searchBSATableHeaderList();
			
			eventResponse.setCustomData("rtnVo", rtnVo);
			
			log.debug("################# BSAManageSC.searchBSATableHeaderList() ############################[END]");
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
		
	}		

	/**
	 * ESM_BSA_0021: 조회 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBSATableJOList(Event e) throws EventException {
		log.debug("################# BSAManageSC.searchBSATableJOList() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0021Event event = (EsmBsa0021Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		try{			
			CommonBsaRsVO rtnVo = command.searchBSATableJOList(event.getSearchBsaConditionVO());
			List<CommonBsaRsVO> list = new ArrayList<CommonBsaRsVO>();
			list.add(rtnVo);

			eventResponse.setRsVoList(list);			
			eventResponse.setCustomData("rtnVo", rtnVo);
			log.debug("################# BSAManageSC.searchBSATableJOList() ############################[END]");
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
	}	

	/**
	 * ESM_BSA_0021: 조회 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBSATableSCList(Event e) throws EventException {
		log.debug("################# BSAManageSC.searchBSATableSCList() ############################[START]");
		EsmBsa0021Event event = (EsmBsa0021Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{			
			BSAManageBC command = new BSAManageBCImpl();
			CommonBsaRsVO rtnVo = command.searchBSATableSCList(event.getSearchBsaConditionVO());
			List<CommonBsaRsVO> list = new ArrayList<CommonBsaRsVO>();
			list.add(rtnVo);

			eventResponse.setRsVoList(list);			
			eventResponse.setCustomData("rtnVo", rtnVo);			
			log.debug("################# BSAManageSC.searchBSATableSCList() ############################[END]");
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
	}		

	/**
	 * ESM_BSA_0021: 멀티 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiBSATableJO(Event e) throws EventException {
		log.debug("################# BSAManageSC.multiBSATableJO() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0021Event event = (EsmBsa0021Event)e; 
		BSAManageBC command = new BSAManageBCImpl();
		try {
			begin();
			command.multiBSATableJO(event.getBsaTableSaveVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
			
			log.debug("################# BSAManageSC.multiBSATableJO() ############################[END]");
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_BSA_0021: 멀티 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiBSATableSC(Event e) throws EventException {
		log.debug("################# BSAManageSC.multiBSATableSC() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0021Event event = (EsmBsa0021Event)e; 
		BSAManageBC command = new BSAManageBCImpl();
		try {
			begin();
			command.multiBSATableSC(event.getBsaTableSaveVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
			
			log.debug("################# BSAManageSC.multiBSATableSC() ############################[END]");
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_BSA_0021: 삭제 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 삭제 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeBSATableJO(Event e) throws EventException {
		log.debug("################# BSAManageSC.removeBSATableJO() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0021Event event = (EsmBsa0021Event)e; 
		BSAManageBC command = new BSAManageBCImpl();
		try {
			begin();
			command.removeBSATableJO(event.getBsaTableSaveVOs());
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
			
			log.debug("################# BSAManageSC.removeBSATableJO() ############################[END]");
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_BSA_0021: 삭제 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 삭제 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeBSATableSC(Event e) throws EventException {
		log.debug("################# BSAManageSC.removeBSATableSC() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0021Event event = (EsmBsa0021Event)e; 
		BSAManageBC command = new BSAManageBCImpl();
		try {
			begin();
			command.removeBSATableSC(event.getBsaTableSaveVOs());
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
			
			log.debug("################# BSAManageSC.removeBSATableSC() ############################[END]");
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_BSA_0021: 생성 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 생성 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createBSA(Event e) throws EventException {
		log.debug("################# BSAManageSC.createBSA() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0021Event event = (EsmBsa0021Event)e; 
		BSAManageBC command = new BSAManageBCImpl();
		try {
			begin();
			CreateBSAVO createRtnVo = command.createBSA(event.getSearchBsaConditionVO(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			
			eventResponse.setETCData("err_cd", createRtnVo.getPErrorCode());
			eventResponse.setETCData("err_msg", createRtnVo.getPErrorMsg());
			eventResponse.setCustomData("rtnVo", createRtnVo);
			commit();
			
			log.debug("################# BSAManageSC.createBSA() ############################[END]");
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	

	/**
	 * ESM_BSA_0023: 조회 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCarrierRegisterList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0023Event event = (EsmBsa0023Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		try{
			CommonBsaRsVO rtnVo = command.searchCarrierRegisterList(event.getBsaOpCd());
			List<CommonBsaRsVO> list = new ArrayList<CommonBsaRsVO>();
			list.add(rtnVo);
			
			eventResponse.setRsVoList(list);
			eventResponse.setCustomData("rtnVo", rtnVo);
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	}	

	
    /* ************************************************
       BACK END JOB 관련 - Start
       ************************************************/
	/**
	 * ESM_BSA_0023: 수정 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 수정 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse response 
	 * @exception EventException
	 */
	private EventResponse modifyCarrierRegister(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0023Event event = (EsmBsa0023Event)e; 
		BSAManageBC command = new BSAManageBCImpl();
		try {
			begin();
			eventResponse.setETCData("BackEndJobKey", command.modifyCarrierRegister(event.getBsaAddCarrierSaveVOs(), account));
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
     * BackEndJob : interval <br>
     * BackEndJob의 상태값을 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchBackEndJobStatus(Event e) throws EventException {
        String key = (String)e.getAttribute("KEY");
        String status = null;
        BSAManageBC command = new BSAManageBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            status = command.searchBackEndJobStatus(key);
            eventResponse.setETCData("jb_sts_flg", status);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * BackEndJob : search <br>
     * BackEndJob 결과 리스트를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchBackEndJobGetResult(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse(); 	
        String key = (String)e.getAttribute("KEY");
        try {            
        	String resultMsg = (String)BackEndJobResult.loadFromFile(key);           
        	eventResponse.setETCData("message", resultMsg);
            
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    /* ************************************************
       BACK END JOB 관련 - End
       ************************************************/

	/**
	 * ESM_BSA_0026: 조회 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpcJoPortDownMasterList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0026Event event = (EsmBsa0026Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		try{
			List<SearchSpcJoPortDownMasterListVO> list = command.searchSpcJoPortDownMasterList(event.getSearchBsaConditionVO());
			eventResponse.setRsVoList(list);
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
	}	

	/**
	 * ESM_BSA_0026: 조회 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpcJoPortDownDetailList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0026Event event = (EsmBsa0026Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		try{
			List<SearchSpcJoPortDownDetailListVO> list = command.searchSpcJoPortDownDetailList(event.getSearchBsaConditionVO());
			eventResponse.setRsVoList(list);
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
	}
	

	/**
	 * ESM_BSA_0026: RESET 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 RESET 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse resetSPCDownPortJO(Event e) throws EventException {
	log.debug("################# SPCManageBC.resetSPCDownPortJO() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0026Event event = (EsmBsa0026Event)e; 
		BSAManageBC command = new BSAManageBCImpl();
		try {
			begin();
			command.resetSpcJoPortDown(event.getSearchBsaConditionVO(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			eventResponse.setETCData("err_cd","00000");
			eventResponse.setETCData("err_msg","OK!");
			commit();
			log.debug("################# SPCManageBC.resetSPCDownPortJO() ############################[END]");
			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_BSA_0026: 생성 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 생성 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createSpcJoPortDown(Event e) throws EventException {
		log.debug("################# BSAManageSC.createSpcJoPortDown() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0026Event event = (EsmBsa0026Event)e; 
		BSAManageBC command = new BSAManageBCImpl();
		try {
			begin();
			command.createSpcJoPortDown(event.getSearchBsaConditionVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			eventResponse.setETCData("err_cd","00000");
			eventResponse.setETCData("err_msg","OK!");
			commit();
			
			log.debug("################# BSAManageSC.createSpcJoPortDown() ############################[END]");
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	

	/**
	 * ESM_BSA_0026: 멀티 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiSPCDownPortJOMaster(Event e) throws EventException {
		log.debug("################# BSAManageSC.multiSPCDownPortJOMaster() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0026Event event = (EsmBsa0026Event)e; 
		BSAManageBC command = new BSAManageBCImpl();
		try {
			begin();
			command.multiSPCDownPortJOMaster(event.getBsaJntOpCrrCapaVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
			
			log.debug("################# BSAManageSC.multiSPCDownPortJOMaster() ############################[END]");
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}	

	/**
	 * ESM_BSA_0026: 멀티 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiSPCDownPortJODetail(Event e) throws EventException {
		log.debug("################# BSAManageSC.multiSPCDownPortJODetail() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0026Event event = (EsmBsa0026Event)e; 
		BSAManageBC command = new BSAManageBCImpl();
		try {
			begin();
			command.multiSPCDownPortJODetail(event.getBsaJntOpPortDwnVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
			
			log.debug("################# BSAManageSC.multiSPCDownPortJODetail() ############################[END]");
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}	

	/**
	 * ESM_BSA_0026: 조회 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */

	private EventResponse searchSpcScPortDownMasterList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0026Event event = (EsmBsa0026Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		try{
			List<SearchSpcScPortDownMasterListVO> list = command.searchSpcScPortDownMasterList(event.getSearchBsaConditionVO());
			eventResponse.setRsVoList(list);
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
	}	

	/**
	 * ESM_BSA_0026: 조회 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpcScPortDownDetailList(Event e) throws EventException {
		log.debug("################# BSAManageSC.searchSpcScPortDownDetailList() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0026Event event = (EsmBsa0026Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		try{
			List<SearchSpcScPortDownDetailListVO> list = command.searchSpcScPortDownDetailList(event.getSearchBsaConditionVO());
			eventResponse.setRsVoList(list);
			log.debug("################# BSAManageSC.searchSpcScPortDownDetailList() ############################[END]");
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
	}	

	/**
	 * ESM_BSA_0026: RESET 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 RESET 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse resetSpcScPortDown(Event e) throws EventException {
		log.debug("################# BSAManageSC.resetSpcScPortDown() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0026Event event = (EsmBsa0026Event)e; 
		BSAManageBC command = new BSAManageBCImpl();
		try {
			begin();
			command.resetSpcScPortDown(event.getSearchBsaConditionVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			eventResponse.setETCData("err_cd","00000");
			eventResponse.setETCData("err_msg","OK!");
			commit();
			
			log.debug("################# BSAManageSC.resetSpcScPortDown() ############################[END]");
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}	

	/**
	 * ESM_BSA_0026: 생성 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 생성 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createSpcScPortDown(Event e) throws EventException {
		log.debug("################# BSAManageSC.createSpcScPortDown() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0026Event event = (EsmBsa0026Event)e; 
		BSAManageBC command = new BSAManageBCImpl();
		try {
			begin();
			command.createSpcScPortDown(event.getSearchBsaConditionVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			eventResponse.setETCData("err_cd","00000");
			eventResponse.setETCData("err_msg","OK!");
			commit();
			
			log.debug("################# BSAManageSC.createSpcScPortDown() ############################[END]");
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}	

	/**
	 * ESM_BSA_0026: 멀티 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiSPCDownPortSCMaster(Event e) throws EventException {
		log.debug("################# BSAManageSC.multiSPCDownPortSCMaster() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0026Event event = (EsmBsa0026Event)e; 
		BSAManageBC command = new BSAManageBCImpl();
		try {
			begin();
			command.multiSPCDownPortSCMaster(event.getBsaSltChtrCrrCapaVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
			
			log.debug("################# BSAManageSC.multiSPCDownPortSCMaster() ############################[END]");
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}	

	/**
	 * ESM_BSA_0026: 멀티 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiSPCDownPortSCDetail(Event e) throws EventException {
		log.debug("################# BSAManageSC.multiSPCDownPortSCDetail() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0026Event event = (EsmBsa0026Event)e; 
		BSAManageBC command = new BSAManageBCImpl();
		try {
			begin();
			command.multiSPCDownPortSCDetail(event.getBsaSltChtrPortDwnVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
			
			log.debug("################# BSAManageSC.multiSPCDownPortSCDetail() ############################[END]");
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}	

	/**
	 * 조회 이벤트 처리[ESM_BSA_0030]<br>
	 * BSAManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOpJobCarrierList(Event e) throws EventException {
		log.debug("################# BSAManageSC.searchOpJobCarrierList() ############################[START]");
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0030Event event = (EsmBsa0030Event)e;
		SPCManageBC command = new SPCManageBCImpl();
		try {
			CommonBsaRsVO vo = command.searchOpJobCarrierList(event.getSearchSpcConditionVO());
			eventResponse.setCustomData("rtnVo", vo);
//			eventResponse.setRsVoList(vo.getResultVOList());
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_BSA_0030: 조회 이벤트 처리 - TEU<br>
	 * SPCManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSupplySwapVvdList(Event e)	throws EventException {
		log.debug("################# SPCManageBC.searchSupplySwapVvdList() ############################[START]");
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0030Event event = (EsmBsa0030Event)e; 
		SPCManageBC command = new SPCManageBCImpl();
		
		try {
			CommonBsaRsVO rsVO = command.searchSupplySwapVvdList(event.getSearchSpcConditionVO());
			List<CommonBsaRsVO> list = new ArrayList<CommonBsaRsVO>();
			list.add(rsVO);

			eventResponse.setRsVoList(list);	
			
			log.debug("################# SPCManageBC.searchSupplySwapVvdList() ############################[END]");
			return eventResponse; 
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * ESM_BSA_0030: 조회 이벤트 처리 - Slot Price<br>
	 * SPCManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSlotPrcSwapVvdList(Event e)	throws EventException {
		log.debug("################# SPCManageBC.searchSlotPrcSwapVvdList() ############################[START]");
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0030Event event = (EsmBsa0030Event)e; 
		SPCManageBC command = new SPCManageBCImpl();
		
		try {
			CommonBsaRsVO rsVO = command.searchSlotPrcSwapVvdList(event.getSearchSpcConditionVO());
			List<CommonBsaRsVO> list = new ArrayList<CommonBsaRsVO>();
			list.add(rsVO);

			eventResponse.setRsVoList(list);			

			log.debug("################# SPCManageBC.searchSlotPrcSwapVvdList() ############################[END]");
			return eventResponse; 
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * ESM_BSA_0030: 조회 이벤트 처리 - TEU & Slot Price<br>
	 * SPCManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTEUPrcSwapVvdList(Event e) throws EventException {
		log.debug("################# SPCManageBC.searchTEUPrcSwapVvdList() ############################[START]");
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0030Event event = (EsmBsa0030Event)e; 
		SPCManageBC command = new SPCManageBCImpl();
		
		try {
			CommonBsaRsVO rsVO = command.searchTEUPrcSwapVvdList(event.getSearchSpcConditionVO());
			List<CommonBsaRsVO> list = new ArrayList<CommonBsaRsVO>();
			list.add(rsVO);

			eventResponse.setRsVoList(list);			

			log.debug("################# SPCManageBC.searchTEUPrcSwapVvdList() ############################[END]");
			return eventResponse; 
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * ESM_BSA_0030: 조회 이벤트 처리( Revenue & Cost Of Slot-swap By VVD List)<br>
	 * SPCManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRevCostSwapVvdList(Event e)	throws EventException {
		log.debug("################# SPCManageBC.searchRevCostSwapVvdList() ############################[START]");
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0030Event event = (EsmBsa0030Event)e; 
		SPCManageBC command = new SPCManageBCImpl();
		
		try {
			CommonBsaRsVO rsVO = command.searchRevCostSwapVvdList(event.getSearchSpcConditionVO());
			List<CommonBsaRsVO> list = new ArrayList<CommonBsaRsVO>();
			list.add(rsVO);

			eventResponse.setRsVoList(list);			

			log.debug("################# SPCManageBC.searchRevCostSwapVvdList() ############################[END]");
			return eventResponse; 
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * ESM_BSA_0030: 생성 이벤트 처리<br>
	 * SPCManage의 event에 대한 특정 리스트 생성 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createSupplySwapVvd(Event e) throws EventException {
		log.debug("################# SPCManageBC.createSupplySwapVvd() ############################[START]");
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0030Event event = (EsmBsa0030Event)e; 
		SPCManageBC command = new SPCManageBCImpl();
		
		try {
			CommonBsaRsVO rsVO = command.createSupplySwapVvd(event.getSearchSpcConditionVO(),account);

			eventResponse.setETCData("err_cd",rsVO.getErrorCode());
			eventResponse.setETCData("err_msg",rsVO.getErrorMsg());
			log.debug("################# SPCManageBC.createSupplySwapVvd() ############################[END]");
			return eventResponse; 
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * ESM_BSA_0030: RESET 이벤트 처리<br>
	 * SPCManage의 event에 대한 특정 리스트 RESET 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse resetSupplySwapVvd(Event e) throws EventException {
		log.debug("################# SPCManageBC.resetSupplySwapVvd() ############################[START]");
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0030Event event = (EsmBsa0030Event)e; 
		SPCManageBC command = new SPCManageBCImpl();
		
		try {
			CommonBsaRsVO rsVO = command.resetSupplySwapVvd(event.getSearchSpcConditionVO(),account);

			eventResponse.setETCData("err_cd",rsVO.getErrorCode());
			eventResponse.setETCData("err_msg",rsVO.getErrorMsg());
			
			log.debug("################# SPCManageBC.resetSupplySwapVvd() ############################[END]");
			return eventResponse; 
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * User 가 VVD별로 계약 붙인것 저장함. (ems_bsa_0030 / multi04)
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse saveSupplySwapVvd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0030Event event = (EsmBsa0030Event)e; 
		SPCManageBC command = new SPCManageBCImpl();
		
		log.debug("################# SPCManageSC.saveSupplySwapVvd() ############################[START]");
		try {
			CommonBsaRsVO rsVO = command.saveSupplySwapVvd(event.getMultiSupplySwapVvdVOs(),account);
			eventResponse.setETCData("err_cd",rsVO.getErrorCode());
			eventResponse.setETCData("err_msg",rsVO.getErrorMsg());
			
			log.debug("################# SPCManageSC.saveSupplySwapVvd() ############################[END]");
			return eventResponse;
		}catch(EventException ex){
			log.debug("################# EventException ############################");
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			log.debug("################# Exception ############################");
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}	
	}

	/**
	 * ESM_BSA_0035: 조회 이벤트 처리 (Joint Operating)<br>
	 * BSAManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOverlappedContractInquiryJOList(Event e) throws EventException {
		log.debug("################# BSAManageSC.searchOverlappedContractInquiryJOList() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0035Event event = (EsmBsa0035Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		try{			
			List<SearchOverlappedContractInquiryListVO> list = command.searchOverlappedContractInquiryJOList(event.getSearchBsaConditionVO());

			eventResponse.setRsVoList(list);			
			log.debug("################# BSAManageSC.searchOverlappedContractInquiryJOList() ############################[END]");
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
	}	

	/**
	 * ESM_BSA_0035: 조회 이벤트 처리 (Space Chartering)<br>
	 * BSAManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOverlappedContractInquirySCList(Event e) throws EventException {
		log.debug("################# BSAManageSC.searchOverlappedContractInquirySCList() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0035Event event = (EsmBsa0035Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		try{			
			List<SearchOverlappedContractInquiryListVO> list = command.searchOverlappedContractInquirySCList(event.getSearchBsaConditionVO());

			eventResponse.setRsVoList(list);			
			log.debug("################# BSAManageSC.searchOverlappedContractInquirySCList() ############################[END]");
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
	}		
	
	/**
	 * ESM_BSA_0035: 조회 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOverlappedContractInquirySPList(Event e) throws EventException {
		log.debug("################# BSAManageSP.searchOverlappedContractInquirySPList() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0035Event event = (EsmBsa0035Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		try{			
			List<SearchOverlappedContractInquiryListVO> list = command.searchOverlappedContractInquirySPList(event.getSearchBsaConditionVO());

			eventResponse.setRsVoList(list);			
			log.debug("################# BSAManageSP.searchOverlappedContractInquirySPList() ############################[END]");
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
	}	
	
	/**
	 * 조회 이벤트 처리[ESM_BSA_0104]<br>
	 * BSAManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpcSlotInfoByVvdList(Event e) throws EventException {
		log.debug("################# SPCManageBC.searchSpcSlotInfoByVvdList() ############################[START]");
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0104Event event = (EsmBsa0104Event)e; 
		SPCManageBC command = new SPCManageBCImpl();
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		try {
			rsVo = command.searchSpcSlotInfoByVvdList(event.getSearchSpcConditionVO());
			
			List<CommonBsaRsVO> list = new ArrayList<CommonBsaRsVO>();
			list.add(rsVo);

			eventResponse.setRsVoList(list);				
			
			log.debug("################# SPCManageBC.searchSpcSlotInfoByVvdList() ############################[END]");
			return eventResponse; 
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	

	/**
	 * 멀티 이벤트 처리[ESM_BSA_0104]<br>
	 * EQBalance의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiSpcSlotInfoByVvd(Event e) throws EventException {
		log.debug("################# SPCManageBC.multiSpcSlotInfoByVvd() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0104Event event = (EsmBsa0104Event)e; 
		SPCManageBC command = new SPCManageBCImpl();
		
		try {
			begin();
			command.multiSpcSlotInfoByVvd(event.getBsaSpcSlotInfoByVvdSaveVOs(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
			log.debug("################# SPCManageBC.multiSpcSlotInfoByVvd() ############################[END]");
			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리[ESM_BSA_0104팝업 화면 ESM_BSA_0121]<br>
	 * BSAManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpcSlotSwapByVvdList(Event e)throws EventException {
		log.debug("################# SPCManageBC.searchSpcSlotSwapByVvdList() ############################[START]");
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0104Event event = (EsmBsa0104Event)e; 
		SPCManageBC command = new SPCManageBCImpl();
		try {
			List<SearchSpcSlotSwapByVvdListVO>list = command.searchSpcSlotSwapByVvdList(event.getSearchSpcConditionVO());
			
			eventResponse.setRsVoList(list);				
			
			log.debug("################# SPCManageBC.searchSpcSlotSwapByVvdList() ############################[END]");
			return eventResponse; 
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * 멀티 이벤트 처리[ESM_BSA_0104팝업 화면 ESM_BSA_0121]<br>
	 * EQBalance의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiSpcSlotSwapByVvd(Event e) throws EventException {
		log.debug("################# SPCManageBC.multiSpcSlotSwapByVvd() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0104Event event = (EsmBsa0104Event)e; 
		SPCManageBC command = new SPCManageBCImpl();
		
		
		try {
			begin();
			BsaVvdSwapInfoVO[] vos = event.getBsaVvdSwapInfoVOs();
			SearchSpcConditionVO vo = event.getSearchSpcConditionVO();
			command.multiSpcSlotSwapByVvd(vo,vos,account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
			log.debug("################# SPCManageBC.multiSpcSlotSwapByVvd() ############################[END]");
			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리[ESM_BSA_0104팝업 화면 ESM_BSA_0143]<br>
	 * BSAManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpcSlotInfoByVvdOnVesselList(Event e)throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		log.debug("################# SPCManageBC.searchSpcSlotInfoByVvdOnVesselList() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0143Event event = (EsmBsa0143Event)e; 
		SPCManageBC command = new SPCManageBCImpl();
		try {
			List<SearchSpcSlotInfoByVvdOnVesselListVO>list = command.searchSpcSlotInfoByVvdOnVesselList(event.getSearchSpcConditionVO());
			
			eventResponse.setRsVoList(list);				
			
			log.debug("################# SPCManageBC.searchSpcSlotInfoByVvdOnVesselList() ############################[END]");
			return eventResponse; 
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
 }

	/**
	 * ESM_BSA_0032: 조회 이벤트 처리<br>
	 * SPCManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStepUpDownVvdMasterList(Event e)throws EventException {
		log.debug("################# BSAManageSC.searchStepUpDownVvdMasterList() ############################[START]");
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SPCManageBC command = new SPCManageBCImpl();
		EsmBsa0032Event event = (EsmBsa0032Event)e;
		try{
			List< SearchStepUpDownVvdMasterListVO > list = command.searchStepUpDownVvdMasterList(event.getSearchSpcConditionVO());
			eventResponse.setRsVoList(list);	
			log.debug("################# BSAManageSC.searchStepUpDownVvdMasterList() ############################[END]");
			return eventResponse; 
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
	}

	/**
	 * ESM_BSA_0032: 조회 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStepUpDownVvdDetailList(Event e) throws EventException {
		log.debug("################# BSAManageSC.searchStepUpDownVvdDetailList() ############################[START]");
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SPCManageBC command = new SPCManageBCImpl();
		EsmBsa0032Event event = (EsmBsa0032Event)e;
		try{
			List< SearchStepUpDownVvdDetailListVO > list = command.searchStepUpDownVvdDetailList(event.getSearchSpcConditionVO());
			eventResponse.setRsVoList(list);	
			log.debug("################# BSAManageSC.searchStepUpDownVvdDetailList() ############################[END]");
			return eventResponse; 
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
	}


	/**
	 * ESM_BSA_0032: 멀티 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyStepUpDownVvdMaster(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0032Event event = (EsmBsa0032Event)e;
		SPCManageBC command = new SPCManageBCImpl();
		try{
			begin();
			command.modifyStepUpDownVvdMaster(event.getBsaVvdMstVOs(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}


	/**
	 * ESM_BSA_0032: 멀티 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiStepUpDownVvd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0032Event event = (EsmBsa0032Event)e;
		SPCManageBC command = new SPCManageBCImpl();
		try{
			begin();
			command.multiStepUpDownVvd(event.getBsaVvdPortDwnVOs(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}


	/*
	 * ESM_BSA_024,5:
	 * ---------------------------------------------------------------------
	 */

	/**
	 * 1. 기능 : Carrier Item을 조회한다.
	 * <p>
	 * 2. 처리개요 :
	 * <p> - BSAManage SPC Control J/O
	 * <p>
	 * 3. 주의사항 :
	 * <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : parkeunju/2006.10.24<br>
	 * ===================================<br>
	 * 5. 수정사항
	 * <p>
	 * 5.1 요구사항 ID :
	 * <p> - 수정자/수정일 :
	 * <p> - 수정사유/내역 :
	 * <p>
	 * ===================================<br>
	 * <p/>
	 * 
	 * @param e
	 *            Event
	 * @return response ESM_BSA_024EventResponse
	 * @exception EventException
	 */

	private EventResponse searchCarrierItem(Event e) throws EventException {
		BSAManageBC command = new BSAManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBsaRsVO retVo = new CommonBsaRsVO();
	   	CommonBC comCommand = new CommonBCImpl();
		
		String jo_crrItem = "";
		String sc_crrItem = "";
		String crrItem = "";
		String cobOpJob = "";
		try{
			if(e.getEventName().equalsIgnoreCase("EsmBsa0024Event")){
				
				jo_crrItem = command.searchCarrierItem("J");
				sc_crrItem = command.searchCarrierItem("S");
				cobOpJob = comCommand.searchBSAOpt();
				
				retVo.setStrTemp(jo_crrItem);
				retVo.setStrTemp2(sc_crrItem);
				retVo.setStrTemp3(cobOpJob);
				
				eventResponse.setCustomData("retVo", retVo);
				
			}else if(e.getEventName().equalsIgnoreCase("EsmBsa0104Event")){
				crrItem = command.searchCarrierItem(""); // master sheet 조회
				cobOpJob = comCommand.searchBSAOpt();
				
				retVo.setStrTemp(crrItem);
				retVo.setStrTemp3(cobOpJob);
				
				eventResponse.setCustomData("retVo", retVo);
			}
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}	

	/**
	 * 1. 기능 : Retrieve 클릭시 조회 이벤트 처리
	 * <p>
	 * 2. 처리개요 :
	 * <p> - BSAManage SPC Control J/O 리스트 조회 이벤트 처리
	 * <p>
	 * 3. 주의사항 :
	 * <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : parkeunju/2006.10.24<br>
	 * ===================================<br>
	 * 5. 수정사항
	 * <p>
	 * 5.1 요구사항 ID :
	 * <p> - 수정자/수정일 :
	 * <p> - 수정사유/내역 :
	 * <p>
	 * ===================================<br>
	 * <p/>
	 * 
	 * @param e
	 *            Event
	 * @return response ESM_BSA_0024EventResponse
	 * @exception EventException
	 */

	private EventResponse searchSPCJOBSA(Event e) throws EventException {
		log.debug("################# BSAManageSC.searchSPCJOBSA() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0024Event event = (EsmBsa0024Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		try{			
			CommonBsaRsVO rtnVo = command.searchSPCJOBSA(event.getSearchBsaConditionVO());
            eventResponse.setRsVo(rtnVo.getDbRowset());			
			log.debug("################# BSAManageSC.searchSPCJOBSA() ############################[END]");
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	}
	
	/**
	 * 1. 기능 : Save버튼 클릭시 저장 이벤트 처리
	 * <p>
	 * 2. 처리개요 :
	 * <p> - BSAManage SPC Control J/O 리스트 저장 이벤트 처리
	 * <p>
	 * 3. 주의사항 :
	 * <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : parkeunju/2006.10.24<br>
	 * ===================================<br>
	 * 5. 수정사항
	 * <p>
	 * 5.1 요구사항 ID :
	 * <p> - 수정자/수정일 :
	 * <p> - 수정사유/내역 :
	 * <p>
	 * ===================================<br>
	 * <p/>
	 * 
	 * @param e
	 *            Event
	 * @return response ESM_BSA_024EventResponse
	 * @exception EventException
	 */
	private EventResponse multiSPCJOBSA(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0024Event event = (EsmBsa0024Event)e; 
		BSAManageBC command = new BSAManageBCImpl();
		
		try {
			begin();
			command.multiSPCJOBSA(event.getBsaSlotInfoForSpcCntrSaveVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
			return (eventResponse); 
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	

	/**
	 * 1. 기능 : Retrieve 클릭시 조회 이벤트 처리
	 * <p>
	 * 2. 처리개요 :
	 * <p> - BSAManage SPC Control J/O POPUP 리스트 조회 이벤트 처리
	 * <p>
	 * 3. 주의사항 :
	 * <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : parkeunju/2006.10.31<br>
	 * ===================================<br>
	 * 5. 수정사항
	 * <p>
	 * 5.1 요구사항 ID :
	 * <p> - 수정자/수정일 :
	 * <p> - 수정사유/내역 :
	 * <p>
	 * ===================================<br>
	 * <p/>
	 * 
	 * @param e Event
	 * @return response ESM_BSA_0024EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChgSlotSwapList(Event e) throws EventException {
		log.debug("################# SPCManageBC.searchChgSlotSwapList() ############################[START]");
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0024Event event = (EsmBsa0024Event)e; 
		BSAManageBC command = new BSAManageBCImpl();
		
		try {
			List<SearchChgSlotSwapListVO> list = command.searchChgSlotSwapList(event.getSearchBsaConditionVO());

			eventResponse.setRsVoList(list);			

			log.debug("################# SPCManageBC.searchChgSlotSwapList() ############################[END]");
			return eventResponse; 
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 1. 기능 : Retrieve 클릭시 조회 이벤트 처리
	 * <p>
	 * 2. 처리개요 :
	 * <p> - BSAManage SPC Control J/O POPUP 리스트 저장 이벤트 처리
	 * <p>
	 * 3. 주의사항 :
	 * <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : parkeunju/2006.10.31<br>
	 * ===================================<br>
	 * 5. 수정사항
	 * <p>
	 * 5.1 요구사항 ID :
	 * <p> - 수정자/수정일 :
	 * <p> - 수정사유/내역 :
	 * <p>
	 * ===================================<br>
	 * <p/>
	 * 
	 * @param e
	 *            Event
	 * @return response ESM_BSA_0024EventResponse
	 * @exception EventException
	 */

	private EventResponse multiChgSlotSwap(Event e) throws EventException {
		log.debug("################# SPCManageBC.multiChgSlotSwap() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0024Event event = (EsmBsa0024Event)e; 
		BSAManageBC command = new BSAManageBCImpl();
		
		try {
			begin();
			 command.multiChgSlotSwap(event.getBsaSpcCtrlSwapVOs(),event.getSearchBsaConditionVO(),account);
			 eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			 commit();
			 log.debug("################# SPCManageBC.multiChgSlotSwap () ############################[END]");
			}catch(EventException ex){
				rollback();
				throw ex;
			}catch(Exception ex){ 
				throw new EventException(ex.getMessage(), ex);
			}
			return eventResponse;
	}	

	/**
	 * 1. 기능 : Retrieve 클릭시 조회 이벤트 처리
	 * <p>
	 * 2. 처리개요 :
	 * <p> - BSAManage SPC Control J/O 리스트 조회 이벤트 처리
	 * <p>
	 * 3. 주의사항 :
	 * <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : parkeunju/2006.10.24<br>
	 * ===================================<br>
	 * 5. 수정사항
	 * <p>
	 * 5.1 요구사항 ID :
	 * <p> - 수정자/수정일 :
	 * <p> - 수정사유/내역 :
	 * <p>
	 * ===================================<br>
	 * <p/>
	 * 
	 * @param e
	 *            Event
	 * @return response ESM_BSA_025EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSPCSCBSA(Event e) throws EventException {
		log.debug("################# BSAManageSC.searchSPCSCBSA() ############################[START]");
		EsmBsa0024Event event = (EsmBsa0024Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{			
			BSAManageBC command = new BSAManageBCImpl();
			CommonBsaRsVO rtnVo = command.searchSPCSCBSA(event.getSearchBsaConditionVO());
            eventResponse.setRsVo(rtnVo.getDbRowset());			
			log.debug("################# BSAManageSC.searchSPCSCBSA() ############################[END]");
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	}	

	/**
	 * 1. 기능 : Save버튼 클릭시 저장 이벤트 처리
	 * <p>
	 * 2. 처리개요 :
	 * <p> - BSAManage SPC Control J/O 리스트 저장 이벤트 처리
	 * <p>
	 * 3. 주의사항 :
	 * <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : parkeunju/2006.10.24<br>
	 * ===================================<br>
	 * 5. 수정사항
	 * <p>
	 * 5.1 요구사항 ID :
	 * <p> - 수정자/수정일 :
	 * <p> - 수정사유/내역 :
	 * <p>
	 * ===================================<br>
	 * <p/>
	 * 
	 * @param e
	 *            Event
	 * @return response ESM_BSA_025EventResponse
	 * @exception EventException
	 */
	private EventResponse multiSPCSCBSA(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0024Event event = (EsmBsa0024Event)e; 
		BSAManageBC command = new BSAManageBCImpl();
		try {
			begin();
			command.multiSPCSCBSA(event.getBsaSlotInfoForSpcCntrSaveVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
			return (eventResponse); 
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}		

	
	/**
	 * ESM_BSA_120: 조회 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCarrierInfoList(Event e) throws EventException {
		log.debug("################# BSAManageSC.searchCarrierInfoList() ############################[START]");
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BSAManageBC command = new BSAManageBCImpl();
 
		try{
			List< BsaCrrInfoVO > list = command.searchCarrierInfoList();
			eventResponse.setRsVoList(list);	
			log.debug("################# BSAManageSC.searchCarrierInfoList() ############################[END]");
			return eventResponse; 
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
	}
	
	
	/**
	 * ESM_BSA_120: 멀티 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiCarrierInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BSAManageBC command = new BSAManageBCImpl();
		try{
			begin();
			if(e.getEventName().equalsIgnoreCase("EsmBsa0023Event")){
				EsmBsa0023Event event = (EsmBsa0023Event)e;
				command.multiCarrierInfo(event.getSearchBsaConditionVO(),account);	
			}else if(e.getEventName().equalsIgnoreCase("EsmBsa0120Event")){
				EsmBsa0120Event event = (EsmBsa0120Event)e;
				command.multiCarrierInfo(event.getSearchBsaConditionVO(),account);	
			}
			
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
	 * ESM_BSA_0172: 헤더구성 조회 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBsaCrrRgstList1(Event e) throws EventException {
		log.debug("################# BSAManageSC.searchBsaCrrRgstList1() ############################[START]");
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BSAManageBC command = new BSAManageBCImpl();
 
		try{
			String headset = command.searchBsaCrrRgstList1();
			eventResponse.setCustomData("headSet",headset);
			log.debug("################# BSAManageSC.searchBsaCrrRgstList1() ############################[END]");
			return eventResponse; 
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
	}

	/**
	 * ESM_BSA_028: 헤더구성 조회 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBsaCrrRgstList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BSAManageBC command = new BSAManageBCImpl();
 
		try{
			CommonBsaRsVO vo = command.searchBsaCrrRgstList();
			eventResponse.setCustomData("rtnVo", vo);
			eventResponse.setETCData("headSet", vo.getStrTemp());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse; 		
	}
	
	/**
	 * ESM_BSA_0028: 조회 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSlotCostList(Event e) throws EventException {
		log.debug("################# BSAManageSC.searchSlotCostList() ############################[START]");
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0028Event event = (EsmBsa0028Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		try {
			CommonBsaRsVO rsVO = command.searchSlotCostList(event.getSearchBsaConditionVO());
			List<CommonBsaRsVO> list = new ArrayList<CommonBsaRsVO>();
			list.add(rsVO);

			eventResponse.setRsVoList(list);			
			eventResponse.setCustomData("rtnVo", rsVO);

			log.debug("################# BSAManageSC.searchSlotCostList() ############################[END]");
			return eventResponse; 
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
	}

	/**
	 * ESM_BSA_028: 조회 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRFCostList(Event e) throws EventException {
		log.debug("################# BSAManageSC.searchRFCostList() ############################[START]");
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0028Event event = (EsmBsa0028Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		try {
			CommonBsaRsVO rsVO = command.searchRFCostList(event.getSearchBsaConditionVO());
			List<CommonBsaRsVO> list = new ArrayList<CommonBsaRsVO>();
			list.add(rsVO);

			eventResponse.setRsVoList(list);			
			eventResponse.setCustomData("rtnVo", rsVO);

			log.debug("################# BSAManageSC.searchRFCostList() ############################[END]");
			return eventResponse; 
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	}

	/**
	 * ESM_BSA_028: 조회 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOverCostList(Event e) throws EventException {
		log.debug("################# BSAManageSC.searchRFCostList() ############################[START]");
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0028Event event = (EsmBsa0028Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		try {
			CommonBsaRsVO rsVO = command.searchOverCostList(event.getSearchBsaConditionVO());
			List<CommonBsaRsVO> list = new ArrayList<CommonBsaRsVO>();
			list.add(rsVO);

			eventResponse.setRsVoList(list);			
			eventResponse.setCustomData("rtnVo", rsVO);

			log.debug("################# BSAManageSC.searchRFCostList() ############################[END]");
			return eventResponse; 
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	}

	/**
	 * ESM_BSA_0172: 조회 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBSARateList(Event e) throws EventException {
		log.debug("################# BSAManageSC.searchBSARateList() ############################[START]");
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0172Event event = (EsmBsa0172Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		try {
			CommonBsaRsVO rsVO = command.searchBSARateList(event.getSearchBsaConditionVO());
			List<CommonBsaRsVO> list = new ArrayList<CommonBsaRsVO>();
			list.add(rsVO);

			eventResponse.setRsVoList(list);			
			eventResponse.setCustomData("rtnVo", rsVO);

			log.debug("################# BSAManageSC.searchBSARateList() ############################[END]");
			return eventResponse; 
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	}

	/**
	 * ESM_BSA_0172: 멀티 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiBSARate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0172Event event = (EsmBsa0172Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		try{
			begin();
			command.multiBSARate(event.getBsaHighCubicRateSaveVOs(), account);
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
	 * ESM_BSA_028: 멀티 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiSlotCost(Event e) throws EventException {
	// PDTO(Data Transfer Object including Parameters)
	GeneralEventResponse eventResponse = new GeneralEventResponse();
	EsmBsa0028Event event = (EsmBsa0028Event)e;
	BSAManageBC command = new BSAManageBCImpl();
	try{
		begin();
		command.multiSlotCost(event.getBsaManageSltPrcSaveVOs(), account);
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
	 * ESM_BSA_0028: 멀티 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiRFCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0028Event event = (EsmBsa0028Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		try{
			begin();
			command.multiRFCost(event.getBsaManageSltPrcSaveVOs(), account);
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
	 * ESM_BSA_028: 멀티 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiOverCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0028Event event = (EsmBsa0028Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		try{
			begin();
			command.multiOverCost(event.getBsaManageSltPrcSaveVOs(), account);
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
	 * ESM_BSA_0162: 헤더구성 조회 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBsaCrrRgstList2(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BSAManageBC command = new BSAManageBCImpl();
 
		try{
			CommonBsaRsVO vo = command.searchBsaCrrRgstList2();
			//eventResponse.setRsVoList(vo.getResultVOList());
			
			eventResponse.setCustomData("rtnVo", vo);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse; 		
	}

	/**
	 * ESM_BSA_0162: 조회 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOverUsedSlotCostList(Event e) throws EventException {
		log.debug("################# BSAManageSC.searchOverUsedSlotCostList() ############################[START]");
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0162Event event = (EsmBsa0162Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		try {
			CommonBsaRsVO rsVO = command.searchOverUsedSlotCostList(event.getSearchBsaConditionVO());
			List<CommonBsaRsVO> list = new ArrayList<CommonBsaRsVO>();
			list.add(rsVO);

			eventResponse.setRsVoList(list);			
			eventResponse.setCustomData("rtnVo", rsVO);

			log.debug("################# BSAManageSC.searchOverUsedSlotCostList() ############################[END]");
			return eventResponse; 
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
	}

	/**
	 * ESM_BSA_0162: 멀티 이벤트 처리<br>
	 * BSAManage의 event에 대한 특정 리스트 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiOverUsedSlotCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0162Event event = (EsmBsa0162Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		try{
			begin();
			command.multiOverUsedSlotCost(event.getBsaOverUsedSlotCostSaveVOS(), account);
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
	 * 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInitComBo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC comCommand = new CommonBCImpl();
		try {
			if(e.getEventName().equals("EsmBsa0021Event")){
				String array[][] = { {"trade","",""},  
									 {"rLane","",""},
		       						 {"CD00593","",""}
		       						};
				eventResponse = comCommand.getMakeCodeSelectList(eventResponse,array);
			}
			if(e.getEventName().equals("EsmBsa0035Event")){
				String array[][] = { {"trade","",""},  
									 {"rLane","",""},
		       						 {"CD00593","",""}
		       						};
				eventResponse = comCommand.getMakeCodeSelectList(eventResponse,array);
			}
			if(e.getEventName().equals("EsmBsa0123Event")){
				String array[][] = { {"trade","",""},  
									 {"rLane","",""},
		       						 {"CD00593","",""}
		       						};
				eventResponse = comCommand.getMakeCodeSelectList(eventResponse,array);
			}
			else if(e.getEventName().equals("EsmBsa0024Event")){
				String array[][] = { {"trade","",""},  
			             			{"rLane","",""},
			             			{"CD00593","",""}
		       						};
				eventResponse = comCommand.getMakeCodeSelectList(eventResponse,array);
			}
			else if(e.getEventName().equals("EsmBsa0026Event")){
				String array[][] = { {"trade","",""},  
			             			{"rLane","",""},
			             			{"CD00593","",""},
			             			{"carrier","",""}
		       						};
				eventResponse = comCommand.getMakeCodeSelectList(eventResponse,array);
			}
			else if(e.getEventName().equals("EsmBsa0028Event")){
				String array[][] = { {"trade","",""},  
			             			{"rLane","",""},
			             			{"CD00593","",""}, 
			             			{"rLane4","",""},
			             			{"currency","",""}
		       						};
		       eventResponse = comCommand.getMakeCodeSelectList(eventResponse,array);
			}
			else if(e.getEventName().equals("EsmBsa0030Event")){
				String array[][] = { {"trade","",""},  
			             			{"rLane","",""},
			             			{"CD00593","",""}, 
			             			{"CD00206","",""}
		       						};
				eventResponse = comCommand.getMakeCodeSelectList(eventResponse,array);
	       	}
			else if(e.getEventName().equals("EsmBsa0032Event")){
				String array[][] = { {"trade","",""},  
			             			{"rLane","",""},
			             			{"CD00593","",""}, 
			             			{"CD00206","",""},
			             			{"carrier","",""}
		       						};
				eventResponse = comCommand.getMakeCodeSelectList(eventResponse,array);
	       	}
			else if(e.getEventName().equals("EsmBsa0104Event")){
    			String array[][] = { {"trade","",""},  
			             			{"rLane","",""},
			             			{"CD00593","",""}, 
			             			{"CD00206","",""}
		       						};
    			eventResponse = comCommand.getMakeCodeSelectList(eventResponse,array);
	       	}
			else if(e.getEventName().equals("EsmBsa0143Event")){
    			String array[][] = { {"trade","",""},  
			             			{"rLane","",""},
			             			{"CD00593","",""}, 
			             			{"CD00206","",""}
		       						};
    			eventResponse = comCommand.getMakeCodeSelectList(eventResponse,array);
	       	}
			else if(e.getEventName().equals("EsmBsa0162Event")){
    		   String array[][] = { {"trade","",""},  
			             			{"rLane","",""},
			             			{"CD00593","",""}, 
			             			{"rLane4","",""}
		       						};
		       eventResponse = comCommand.getMakeCodeSelectList(eventResponse,array);
	       	}
			else if(e.getEventName().equals("EsmBsa0172Event")){
    			String array[][] = { {"trade","",""},  
			             			{"rLane","",""},
			             			{"CD00593","",""}, 
			             			{"rLane4","",""}
		       						};
    			eventResponse = comCommand.getMakeCodeSelectList(eventResponse,array);
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
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	public EventResponse searchPrevWkPrd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC comCommand = new CommonBCImpl();
	   	String prevWk = "";
	   	
		try {
			prevWk =comCommand.searchPrevWkPrd();
			eventResponse.setETCData("prevWk", prevWk);
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
   }
	
	/**
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	public EventResponse searchBSATableVvdList(Event e) throws EventException {

	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0123Event event = (EsmBsa0123Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		
		try {
			List<BsaTableSaveVO> list = command.searchBSATableVvdList(event.getSearchBsaConditionVO());
			eventResponse.setRsVoList(list);
			return eventResponse; 
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
   }
}