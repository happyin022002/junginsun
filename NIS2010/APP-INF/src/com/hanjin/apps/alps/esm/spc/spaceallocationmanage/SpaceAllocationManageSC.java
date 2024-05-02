/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpaceAllocationManageSC.java
*@FileTitle : Allocation Change by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2009.07.29 최윤성
* 1.0 Creation
History ------------------------------------------
2010.08.27 이행지 [CHM-201005552-01] Allocation Control by Main Office 화면 Remark 기능 보완
                                    - Remark 가능한 Office인지 체크하기
2011.05.03 이석준 [CHM-201110568-01] Bottleneck Check 화면 조건 보완(VVD Input 조회시 VVD 정보 조회)
                                   - SearchSpaceAllocationManage045VVDInfo method 추가                                   
2011.08.08 이행지 [CHM-201112741-01] Control by HO/RHQ 화면 보완 1차 - 주차별 CMB 항목 조회되도록 수정
2011.08.16 이행지 [CHM-201112741-01] Control by HO/RHQ 화면 보완 2차 - WAFIE Allocation 팝업 추가
2011.08.25 김종준 [CHM-201113071-01] control by HO/RHQ 화면과 COA 링크 팝업 추가
2011.09.15 이행지 [CHM-201113449-01] COA 링크 화면 보완 - 메소드명 변경
2012.03.19 김성훈 [CHM-201216752-01] COA Report 화면과 동일하게 구성 - 해당 항차, Load Office, POL/POD 조건에 맞는 실적정보 조회
2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
2013.05.03 [CHM-201324211-01] 42,44,47 save 후 로직 etcdata 추가, SLS_OFC_CD 관련 로직 수정
2013.06.26 진마리아 [CHM-201325016-01] 성수기 Alloc copy 기능 개발
2014.07.04 Arie [CHM-201431038] SPC기능보완요청 - COA pop 및 가이드 존재시 Alloc셀 활성화
2014.12.08 신자영 [CHM-201433097] Control Option - A/C 및 CDMT추가 건 상세
2015.01.02 Arie [CHM-201433401]Control Option Registration - Upload기능 추가 요청
2015.01.30 신자영 [CHM-201533908] Control Option 보완 - SC/RFA컬럼 제거 
2015.03.19 김성욱 [CHM-201533908] Control Option 보완 - Sheet3, 4 추가, sheet2, 3, 4에 delete check box 추가
2015.03.25 박은주 [CHM-201534916] Allocation by HO/RHQ 의 Edit기능에 Yield Group추가 요청 ->Sync 옵션추가
2015.06.11 김성욱 [CHM-201535211] SPC BKG 연동
2015.06.24 이혜민 [CHM-201535810] [SPC] Fixed Rate 계약 정보의 SPC 적용 개발 요청
2015.08.11 com.hanjin.apps.alps.esm.mas.common.basic.CommonBC->MAS로 변경 
=========================================================
*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.spc.common.common.basic.CommonBC;
import com.hanjin.apps.alps.esm.spc.common.common.basic.CommonBCImpl;

import com.hanjin.apps.alps.esm.spc.common.common.vo.SearchOfficeCondVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.basic.SpaceAllocationManageBC;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.basic.SpaceAllocationManageBCImpl;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0031Event;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0032Event;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0033Event;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0041Event;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0042Event;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0044Event;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0045Event;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0046Event;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0047Event;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0048Event;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0049Event;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0053Event;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0054Event;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0065Event;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0066Event;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0070Event;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0071Event;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0073Event;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SalesRPTCommonVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchActualCustomerVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSPCAllocBKGListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0033LaneRgstVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0042MListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0053ManageListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchVesselSKDListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SpaceAllocationManageSummaryVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SpaceAllocationManageVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.basic.QtaAdjustmentBC;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.basic.QtaAdjustmentBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SpcAlocPolPodVO;


/**
 * ALPS-SpaceAllocationManage Business Logic ServiceCommand - ALPS-SpaceAllocationManage 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author CHOI Yun Sung
 * @see SpaceAllocationManageBC
 * @since J2EE 1.6
 */

public class SpaceAllocationManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**2
	 * SpaceAllocationManage system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("SpaceAllocationManageSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * SpaceAllocationManage system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("SpaceAllocationManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-SpaceAllocationManage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmSpc0042Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchSpaceAllocationMasterList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchSpaceAllocationDetailList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) { // control option 저장 후 해당 Row에 필요한 컬럼 정보만 업데이트 한다.
				eventResponse = searchSpaceAllocationControlFlagList(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { //AcctCtrl = "N"
				eventResponse = multiSpaceAllocation(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // Control Option Save시
				eventResponse = multiControlOption(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { //AcctCtrl = "Y"
				eventResponse = multiSpaceAllocationSmp(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchWeek();
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = multiSpaceAllocationSaq(e);
			}
			else {
				eventResponse = searchSpaceAllocationOfficeCond(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSpc0044Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchSpaceAllocation0044MasterList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchSpaceAllocation0044DetailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiSpaceAllocation0044Manage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiSpaceAllocation0044ManageSMP(e);
			} else {
				eventResponse = searchSpaceAllocationOfficeCond(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSpc0041Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchSpaceAllocationModelList(e);
			}	
		}
		else if (e.getEventName().equalsIgnoreCase("EsmSpc0045Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchSpaceAllocationManage045VVDList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchSpaceAllocationManage045QtyList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchSpaceAllocationManage045VVDInfo(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSpc0047Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchSpaceAllocation0047MasterList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchSpaceAllocation0047DetailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiSpaceAllocation0047Manage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = multiSpaceAllocation0047ManageSmp(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchWeek();
			} else {
				eventResponse = searchSpaceAllocationOfficeCond(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmSpc0053Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchSpaceAllocationManageList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSpc0054Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchSpaceAllocationModelRun0054List(e);
			}
		
		} else if (e.getEventName().equalsIgnoreCase("EsmSpc0065Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiSpaceAllocationManageTemp(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSpc0066Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchSpaceAllocationManageTempList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiSpaceAllocationManageTemp(e);
			}
		}  else if (e.getEventName().equalsIgnoreCase("EsmSpc0070Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchNoShowAdjustmentList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiNoShowAdjustment(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchNoShowDownloadDateList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = multiForcastDownloadDate(e);
			} else {
				eventResponse = searchSpaceAllocationOfficeCond(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSpc0071Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchVesselSKDList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSpc0048Event")) {  // WAF Allocation
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchWAFAlloc(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiWAFAlloc(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSpc0049Event")) {  // Inquiry by Customized Condition
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchInqByCondition0049List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // Select Customized RPT Form
				eventResponse = searchInqByCondition0049List2(e);
			} else {
				eventResponse = searchRptFormList();
			}
		// ADD 2012.08.28.
		}else if (e.getEventName().equalsIgnoreCase("EsmSpc0046Event")) {
		
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchSpaceAllocation0046List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01) ) {
				eventResponse = multiSpaceAllocation0046ManageByHO(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI) ) {
			    eventResponse = multiSpaceAllocation0046ManageByRHQ(e);
			}
			
		} else if (e.getEventName().equalsIgnoreCase("EsmSpc0031Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchStatusByVvd(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSpc0032Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchStatusByLofc(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSpc0033Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSpaceAllocation0033LaneRgstList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSpaceAllocation0033LanePortRgstList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchSpaceAllocation0033VVDLaneRgstList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchSpaceAllocation0033VVDLanePortRgstList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchSpaceAllocation0033BSACapaList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchSpaceAllocation0033BSACapaByPort(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiSpaceAllocation0033LaneRgstList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = multiSpaceAllocation0033LanePortRgstList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = multiSpaceAllocation0033VVDLaneRgstList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = multiSpaceAllocation0033VVDLanePortRgstList(e);
			} 
		}
		else if (e.getEventName().equalsIgnoreCase("EsmSpc0073Event")) {
			log.debug("\n EsmSpc0073Event");
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			log.debug("\n SEARCH");
				eventResponse = searchActualCustomer(e);
			}	
		}

		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0042 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceAllocationDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0042Event event = (EsmSpc0042Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();

		try{
			log.debug("\n 20131127 test" + event.getConditionVO().getType());
			List<SpaceAllocationManageVO> list = command.searchSpaceAllocationDetailList(event.getConditionVO(), account);
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
	 * ESM_SPC_0042 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceAllocationMasterList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0042Event event = (EsmSpc0042Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();

		try{
			List<SearchSpaceAllocation0042MListVO> list = command.searchSpaceAllocationMasterList(event.getConditionVO());
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
	 * ESM_SPC_0042 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiSpaceAllocation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0042Event event = (EsmSpc0042Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		
		try{
			begin();
			List<SearchSPCAllocBKGListVO> list = command.multiSpaceAllocation(event.getSpcAlocPolPodVOS(), account, event.getConditionVO());
			if( list != null && list.size() > 0 ) {
				StringBuffer rslt_data = new StringBuffer();
				for( int x=0 ; x<list.size() ; x++){
					SearchSPCAllocBKGListVO vo = list.get(x);
					if( vo.getRowNum() == null || vo.getRowNum().equals("") )
						continue;
					rslt_data.append("|").append( vo.getRowNum() )
						.append(",").append( vo.getBkgTtlQty() )
						.append(",").append( vo.getBkgTtlWgt() )
						.append(",").append( vo.getBkgSbQty() )
						.append(",").append( vo.getBkgSbWgt() );
				}
				eventResponse.setETCData( "result", rslt_data.toString() );
			} else {
				StringBuffer rslt_data = new StringBuffer();
				rslt_data.append("|").append( "0" )
				.append(",").append( "0" )
				.append(",").append( "0" )
				.append(",").append( "0" )
				.append(",").append( "0" );
				eventResponse.setETCData( "result", rslt_data.toString() );
			}
			eventResponse.setETCData("status", "OK");
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
	 * ESM_SPC_0042 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiSpaceAllocationSmp(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0042Event event = (EsmSpc0042Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		
		try{
			begin();
			List<SearchSPCAllocBKGListVO> list = command.multiSpaceAllocationSmp(event.getSpcAlocCustPolPodVOS(), account, event.getConditionVO());
			if( list != null && list.size() > 0 ) {
				StringBuffer rslt_data = new StringBuffer();
				for( int x=0 ; x<list.size() ; x++){
					SearchSPCAllocBKGListVO vo = list.get(x);
					if( vo.getRowNum() == null || vo.getRowNum().equals("") )
						continue;
					rslt_data.append("|").append( vo.getRowNum() )
						.append(",").append( vo.getBkgTtlQty() )
						.append(",").append( vo.getBkgTtlWgt() )
						.append(",").append( vo.getBkgSbQty() )
						.append(",").append( vo.getBkgSbWgt() );
				}
				eventResponse.setETCData( "result", rslt_data.toString() );
			} else {
				StringBuffer rslt_data = new StringBuffer();
				rslt_data.append("|").append( "0" )
				.append(",").append( "0" )
				.append(",").append( "0" )
				.append(",").append( "0" )
				.append(",").append( "0" );
				eventResponse.setETCData( "result", rslt_data.toString() );
			}
			eventResponse.setETCData("status", "OK");
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
	 * ESM_SPC_0042 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiControlOption(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0042Event event = (EsmSpc0042Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		
		try{
			begin();
			command.multiControlOption(event.getSpcAlocCtrlOptVOS(),account);
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
	 * ESM_SPC_0042 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
	private EventResponse multiSpaceAllocationSaq(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0042Event event = (EsmSpc0042Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try{
			begin();
			
			
			String UserId  = event.getSignOnUserAccount().getUsr_id();
			String RlaneCd = event.getConditionVO().getRlaneCd();
			String TrdCd   = event.getConditionVO().getTrdCd();
			String Vvd     = event.getConditionVO().getVslCd() +
			                 event.getConditionVO().getSkdVoyNo() +
			                 event.getConditionVO().getSkdDirCd();
			
				
			command.manageSpcAlocIf(TrdCd, RlaneCd, Vvd, UserId);
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
	 * ESM_SPC_0044 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceAllocation0044DetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0044Event event = (EsmSpc0044Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		try{
			List<SpaceAllocationManageVO> list = command.searchSpaceAllocation0044DetailList(event.getConditionVO());
			list.get(0).setEventCommend("SEARCHLIST02");
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
	 * ESM_SPC_0044 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceAllocation0044MasterList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0044Event event = (EsmSpc0044Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		try{
			List<SpaceAllocationManageVO> list = command.searchSpaceAllocation0044MasterList(event.getConditionVO());
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
	 * ESM_SPC_0044 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiSpaceAllocation0044Manage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0044Event event = (EsmSpc0044Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		
		try{
			begin();
			
			List<SearchSPCAllocBKGListVO> list = command.multiSpaceAllocation0044Manage(event.getSpcAlocPolPodVOS(),account);
			if( list != null && list.size() > 0 ) {
				StringBuffer rslt_data = new StringBuffer();
				for( int x=0 ; x<list.size() ; x++){
					SearchSPCAllocBKGListVO vo = list.get(x);
					if( vo.getRowNum() == null || vo.getRowNum().equals("") )
						continue;
					rslt_data.append("|").append( vo.getRowNum() )
						.append(",").append( vo.getBkgTtlQty() )
						.append(",").append( vo.getBkgTtlWgt() )
						.append(",").append( vo.getBkgSbQty() )
						.append(",").append( vo.getBkgSbWgt() );
				}
				eventResponse.setETCData( "result", rslt_data.toString() );
			} else {
				StringBuffer rslt_data = new StringBuffer();
				rslt_data.append("|").append( "0" )
				.append(",").append( "0" )
				.append(",").append( "0" )
				.append(",").append( "0" )
				.append(",").append( "0" );
				eventResponse.setETCData( "result", rslt_data.toString() );
			}
			eventResponse.setETCData("status", "OK");
			eventResponse.setUserMessage(new ErrorHandler("SPC00010").getUserMessage());
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
	 * ESM_SPC_0044 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiSpaceAllocation0044ManageSMP(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0044Event event = (EsmSpc0044Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		
		try{
			begin();
			
			List<SearchSPCAllocBKGListVO> list = command.multiSpaceAllocation0044ManageSMP(event.getSpcAlocCustPolPodVOs(),account,event.getConditionVO());
			if( list != null && list.size() > 0 ) {
				StringBuffer rslt_data = new StringBuffer();
				for( int x=0 ; x<list.size() ; x++){
					SearchSPCAllocBKGListVO vo = list.get(x);
					if( vo.getRowNum() == null || vo.getRowNum().equals("") )
						continue;
					rslt_data.append("|").append( vo.getRowNum() )
						.append(",").append( vo.getBkgTtlQty() )
						.append(",").append( vo.getBkgTtlWgt() )
						.append(",").append( vo.getBkgSbQty() )
						.append(",").append( vo.getBkgSbWgt() );
				}
				eventResponse.setETCData( "result", rslt_data.toString() );
			} else {
				StringBuffer rslt_data = new StringBuffer();
				rslt_data.append("|").append( "0" )
				.append(",").append( "0" )
				.append(",").append( "0" )
				.append(",").append( "0" )
				.append(",").append( "0" );
				eventResponse.setETCData( "result", rslt_data.toString() );
			}
			eventResponse.setETCData("status", "OK");
			eventResponse.setUserMessage(new ErrorHandler("SPC00010").getUserMessage());
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
	 * ESM_SPC_0047 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceAllocation0047DetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0047Event event = (EsmSpc0047Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		try{
			List<SpaceAllocationManageVO> list = command.searchSpaceAllocation0047DetailList(event.getConditionVO());
			list.get(0).setEventCommend("SEARCHLIST02");
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
	 * ESM_SPC_0047 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceAllocation0047MasterList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0047Event event = (EsmSpc0047Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		try{
			List<SpaceAllocationManageVO> list = command.searchSpaceAllocation0047MasterList(event.getConditionVO());
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
	 * ESM_SPC_0047 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiSpaceAllocation0047Manage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0047Event event = (EsmSpc0047Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		
		try{
			begin();
			List<SearchSPCAllocBKGListVO> list = command.multiSpaceAllocation0047Manage(event.getSpcAlocPolPodVOS(),account, event.getConditionVO());
			if( list != null && list.size() > 0 ) {
				StringBuffer rslt_data = new StringBuffer();
				for( int x=0 ; x<list.size() ; x++){
					SearchSPCAllocBKGListVO vo = list.get(x);
					if( vo.getRowNum() == null || vo.getRowNum().equals("") ){
						log.debug("row num is null or empty");
						continue;
					}
					rslt_data.append("|").append( vo.getRowNum() )
						.append(",").append( vo.getBkgTtlQty() )
						.append(",").append( vo.getBkgTtlWgt() )
//						.append(",").append( vo.getBkg20ftQty() )
//						.append(",").append( vo.getBkgD2ftQty() )
//						.append(",").append( vo.getBkg40ftQty() )
//						.append(",").append( vo.getBkgD4ftQty() )
//						.append(",").append( vo.getBkg40ftHcQty())
//						.append(",").append( vo.getBkg45ftHcQty() )
//						.append(",").append( vo.getBkg53ftQty() )
//						.append(",").append( vo.getBkgRfQty() )
//						.append(",").append( vo.getBkgRdQty() )
						.append(",").append( vo.getBkgSbQty() )
						.append(",").append( vo.getBkgSbWgt() );
				}
				log.debug("rslt_data.toString()=" + rslt_data.toString() );
				eventResponse.setETCData( "result", rslt_data.toString() );
			}
			eventResponse.setETCData("status", "OK");
			eventResponse.setUserMessage(new ErrorHandler("SPC00010").getUserMessage());
			//eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
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
	 * ESM_SPC_0047 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiSpaceAllocation0047ManageSmp(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0047Event event = (EsmSpc0047Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		
		try{
			begin();
			List<SearchSPCAllocBKGListVO> list = command.multiSpaceAllocation0047ManageSmp(event.getSpcAlocCustPolPodVOS(),account,event.getConditionVO());
			if( list != null && list.size() > 0 ) {
				StringBuffer rslt_data = new StringBuffer();
				for( int x=0 ; x<list.size() ; x++){
					SearchSPCAllocBKGListVO vo = list.get(x);
					if( vo.getRowNum() == null || vo.getRowNum().equals("") )
						continue;
					rslt_data.append("|").append( vo.getRowNum() )
						.append(",").append( vo.getBkgTtlQty() )
						.append(",").append( vo.getBkgTtlWgt() )
//						.append(",").append( vo.getBkg20ftQty() )
//						.append(",").append( vo.getBkgD2ftQty() )
//						.append(",").append( vo.getBkg40ftQty() )
//						.append(",").append( vo.getBkgD4ftQty() )
//						.append(",").append( vo.getBkg40ftHcQty())
//						.append(",").append( vo.getBkg45ftHcQty() )
//						.append(",").append( vo.getBkg53ftQty() )
//						.append(",").append( vo.getBkgRfQty() )
//						.append(",").append( vo.getBkgRdQty() )
						.append(",").append( vo.getBkgSbQty() )
						.append(",").append( vo.getBkgSbWgt() );
				}
				eventResponse.setETCData( "result", rslt_data.toString() );
			}
			eventResponse.setETCData("status", "OK");
			eventResponse.setUserMessage(new ErrorHandler("SPC00010").getUserMessage());
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
	 * ESM_SPC_0045 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceAllocationManage045VVDList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0045Event event = (EsmSpc0045Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		try{
			List<SpaceAllocationManageVO> list = command.searchSpaceAllocationManage045VVDList(event.getConditionVO());
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
	 * ESM_SPC_0045 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceAllocationManage045VVDInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0045Event event = (EsmSpc0045Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		try{
			event.getConditionVO().setOfcCd(account.getOfc_cd());
			List<SpaceAllocationManageVO> list = command.searchSpaceAllocationManage045VVDInfo(event.getConditionVO());
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
	private EventResponse searchSpaceAllocationManage045QtyList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0045Event event = (EsmSpc0045Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		try{
			List<SpaceAllocationManageVO> list = command.searchSpaceAllocationManage045QtyList(event.getConditionVO());
			list.get(0).setEventCommend("SEARCHLIST02");
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
	 * ESM_SPC_0053 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceAllocationManageList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0053Event event = (EsmSpc0053Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		try{
			List<SearchSpaceAllocation0053ManageListVO> searchSpaceAllocation0053ManageListVOs = command.searchSpaceAllocationManageList(event.getConditionVO());
			List<SpaceAllocationManageVO> mainList = new ArrayList<SpaceAllocationManageVO>();
			SpaceAllocationManageVO spaceAllocationManageVO = new SpaceAllocationManageVO();
			spaceAllocationManageVO.setSearchSpaceAllocation0053ManageListVOs(searchSpaceAllocation0053ManageListVOs);
			mainList.add(spaceAllocationManageVO);
			eventResponse.setRsVoList(mainList);
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
	 * ESM_SPC_0054 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceAllocationModelRun0054List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0054Event event = (EsmSpc0054Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		try{
			event.getConditionVO().setOfcCd(account.getOfc_cd());
			List<SpaceAllocationManageVO> list = command.searchSpaceAllocationModelRun0054List(event.getConditionVO());
			
			if(list.size() > 0){
				list.get(0).setEventCommend("SEARCHLIST01");
			}
			eventResponse.setRsVoList(list);
			eventResponse.setETCData("sataus", "OK");
		
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
	 * ESM_SPC_0041 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceAllocationModelList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0041Event event = (EsmSpc0041Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		try{
//			event.getConditionVO().setOfcCd(account.getOfc_cd());
			List<SpaceAllocationManageVO> list = command.searchSpaceAllocationModelList(event.getConditionVO());
			
			if(list.size() > 0){
				list.get(0).setEventCommend("SEARCHLIST01");
			}
			eventResponse.setRsVoList(list);
			eventResponse.setETCData("sataus", "OK");
		
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
	 * ESM_SPC_0065 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiSpaceAllocationManageTemp(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		
		try{
			begin();
			
			if (e.getEventName().equalsIgnoreCase("EsmSpc0065Event")) {
				EsmSpc0065Event event = (EsmSpc0065Event)e;
				command.multiSpaceAllocationManageTemp(event.getSpcAlocPolPodVOS(), account, event);
				eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmSpc0066Event")) {
				EsmSpc0066Event event = (EsmSpc0066Event)e;
				command.multiSpaceAllocationManageTemp(event.getSpcAlocPolPodVOS(), account, event);
				eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			}
			
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
	 * ESM_SPC_0066 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceAllocationManageTempList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0066Event event = (EsmSpc0066Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		
		try{
			List<SpaceAllocationManageVO> list = command.searchSpaceAllocationManageTempList(event.getConditionVO());
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
	 * ESM_SPC_0070 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNoShowAdjustmentList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0070Event event = (EsmSpc0070Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();

		try{
			List<SpaceAllocationManageVO> list = command.searchNoShowAdjustmentList(event.getConditionVO());
			list.get(0).setConditionVO(event.getConditionVO());
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
	 * ESM_SPC_0070 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNoShowDownloadDateList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0070Event event = (EsmSpc0070Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();

		try{
			List<SpaceAllocationManageVO> list = command.searchNoShowDownloadDateList(event.getConditionVO());
			list.get(0).setConditionVO(event.getConditionVO());
			list.get(0).setEventCommend("SEARCHLIST02");
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
	 * ESM_SPC_0070 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiNoShowAdjustment(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0070Event event = (EsmSpc0070Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		
		try{
			begin();
			command.multiNoShowAdjustment(event.getSpcNshwRsltVOS(),account);
			eventResponse.setETCData("status", "OK");
			eventResponse.setUserMessage(new ErrorHandler("SPC00010").getUserMessage());
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
	 * ESM_SPC_0070 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiForcastDownloadDate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0070Event event = (EsmSpc0070Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		
		try{
			begin();
			command.multiForcastDownloadDate(event.getSpcFcastDwnLodSkdVOS(),account);
			eventResponse.setETCData("status", "OK");
			eventResponse.setUserMessage(new ErrorHandler("SPC00010").getUserMessage());
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
	 * ESM_SPC_0071 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVesselSKDList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0071Event event = (EsmSpc0071Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		
		try{
			List<SearchVesselSKDListVO> list = command.searchVesselSKDList(event.getConditionVO());
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
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceAllocationOfficeCond(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC comCommand = new CommonBCImpl();
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		
		String ofcCd = account.getOfc_cd();
		
		try{
			List<SearchOfficeCondVO> list = comCommand.searchOfficeCond(e, account);
			if(list.size() > 0){
				SearchOfficeCondVO searchOfficeCondVO = list.get(0);
				eventResponse.setETCData(searchOfficeCondVO.getColumnValues());
			}
			/* 2010.08.27 이행지 [CHM-201005552-01] Allocation Control by Main Office 화면 Remark 기능 보완
               Remark 가능한 Office인지 체크하여 Flag값 받아오기.
            */
			String rmkFlg = command.searchRemarkFlagOffice(ofcCd);
			eventResponse.setETCData("rmkFlg",rmkFlg);
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
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWeek() throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		try{
			eventResponse.setETCData("headerWeek",command.searchWeek());
		
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
	 * ESM_SPC_0048 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWAFAlloc(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0048Event event = (EsmSpc0048Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();

		try{
			List<SpcAlocPolPodVO> list = command.searchWAFAlloc(event.getConditionVO());
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
	 * EsmSpc0048Event : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiWAFAlloc(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0048Event event = (EsmSpc0048Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		
		try{
			begin();
			command.multiWAFAlloc(event.getSpcAlocPolPodVOs(),account);
			eventResponse.setETCData("status", "OK");
			eventResponse.setUserMessage(new ErrorHandler("SPC00010").getUserMessage());
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
	 * ESM_SPC_0049 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInqByCondition0049List(Event e) throws EventException {
		EsmSpc0049Event event = (EsmSpc0049Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        String userId = event.getSignOnUserAccount().getUsr_id();
        try{
        	SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();

            event.getSalesRPTCommonVO().setEventName("EsmSpc0049Event");
        	
        	String fRevPolCd = event.getSearchConditionVO().getFRevPolCd();
        	if ( fRevPolCd != null && fRevPolCd.length() > 7 ) {
        		fRevPolCd = fRevPolCd.substring(0,7);
        	}
        	String fRevPodCd = event.getSearchConditionVO().getFRevPodCd();
        	if ( fRevPodCd != null && fRevPodCd.length() > 7 ) {
        		fRevPodCd = fRevPodCd.substring(0,7);
        	}
        	
        	event.getSearchConditionVO().setFRevPolCd(fRevPolCd);
        	event.getSearchConditionVO().setFRevPodCd(fRevPodCd);
            
            SalesRPTCommonVO rtnVo = command.searchInqByCondition0049List(event.getSearchConditionVO(), event.getSalesRPTCommonVO(), userId);            
            eventResponse.setETCData("header", rtnVo.getHeader());
            eventResponse.setETCData("headerNM", rtnVo.getHeaderNM());
            eventResponse.setRsVo(rtnVo.getRowSet());
            return eventResponse;
        }catch(EventException ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage());
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }		
		
	}

	/**
	 * ESM_SPC_0049 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRptFormList() throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		
    	com.hanjin.apps.alps.esm.mas.common.basic.CommonBC masCommonBC = 
				new com.hanjin.apps.alps.esm.mas.common.basic.CommonBCImpl();
    
		String slctItmFomCd = "";
		String slctItmFomNm = "";
		try{
			String slctItmFom = command.searchRptFormList(account);
			if ( slctItmFom.split("@@").length != 0) {
				slctItmFomCd = slctItmFom.split("@@")[0];
				slctItmFomNm = slctItmFom.split("@@")[1];
			}
			
		    String array[][] = {{"tpSz","","All"}};
		    eventResponse = masCommonBC.getMakeCodeSelectList(eventResponse,array);	
		    
			eventResponse.setETCData("slctItmFomCd",slctItmFomCd);
			eventResponse.setETCData("slctItmFomNm",slctItmFomNm);
		
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
	 * 조회 이벤트 처리<br>
	 * group code 목록을 조회 이벤트 처리<br> 
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchInqByCondition0049List2(Event e) throws EventException {
	   EsmSpc0049Event event = (EsmSpc0049Event)e;
       GeneralEventResponse eventResponse = new GeneralEventResponse();
       String userId = event.getSignOnUserAccount().getUsr_id();
       try{
    	   SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
           event.getSalesRPTCommonVO().setEventName("EsmSpc0049Event");
           SalesRPTCommonVO retVo = command.searchInqByCondition0049List2(event.getSearchConditionVO(), event.getSalesRPTCommonVO(), userId);

           eventResponse.setETCData("header", (String)retVo.getHeader());
           eventResponse.setETCData("headerNM", (String)retVo.getHeaderNM());

           return eventResponse;
           
       }catch(EventException ex){
           log.error("err " + ex.toString(), ex);
           throw new EventException(ex.getMessage());
       }catch(Exception ex){
           throw new EventException(ex.getMessage(), ex);
       }
   } 
    
    
    
    
    
    /**
	 * ESM_SPC_0046 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceAllocation0046List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0046Event event = (EsmSpc0046Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		try{
			
			List<SearchSpaceAllocation0042MListVO> list = command.searchSpaceAllocation0046List(event.getConditionVO());
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
	 * ESM_SPC_0046 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiSpaceAllocation0046ManageByRHQ(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0046Event event =(EsmSpc0046Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		
		try{
			begin();
			command.multiSpaceAllocation0046ManageByRHQ(event.getSpcAlocPolPodVOS(), event.getGrpAcct(), account);
			eventResponse.setETCData("status", "OK");
			eventResponse.setUserMessage(new ErrorHandler("SPC00010").getUserMessage());
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
	 * ESM_SPC_0046 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiSpaceAllocation0046ManageByHO(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0046Event event =(EsmSpc0046Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		
		try{
			begin();
			command.multiSpaceAllocation0046ManageByHO(event.getSpcAlocPolPodVOS(), event.getGrpAcct(), account);
			eventResponse.setETCData("status", "OK");
			eventResponse.setUserMessage(new ErrorHandler("SPC00010").getUserMessage());
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
	 * ESM_SPC_0031 : 조회<br>
	 * TRD, SUB TRD, VVD, 주차에 해당하는 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStatusByVvd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0031Event event = (EsmSpc0031Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		try{
			
			List<SpaceAllocationManageSummaryVO> list = command.searchStatusByVvd(event.getConditionVO());
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
	 * ESM_SPC_0032 : 조회<br>
	 * TRD, SUB TRD, OFC, 주차에 해당하는 항차들의 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStatusByLofc(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0032Event event = (EsmSpc0032Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		try{
			
			List<SpaceAllocationManageSummaryVO> list = command.searchStatusByLofc(event.getConditionVO());
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
	 * ESM_SPC_0033 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceAllocation0033LaneRgstList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0033Event event = (EsmSpc0033Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();

		try{
			List<SearchSpaceAllocation0033LaneRgstVO> list = command.searchSpaceAllocation0033LaneRgstList(event.getSearchSpaceAllocation0033LaneRgstVO());
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
	 * ESM_SPC_0033 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceAllocation0033LanePortRgstList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0033Event event = (EsmSpc0033Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();

		try{
			List<SearchSpaceAllocation0033LaneRgstVO> list = command.searchSpaceAllocation0033LanePortRgstList(event.getSearchSpaceAllocation0033LaneRgstVO());
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
	 * ESM_SPC_0033 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceAllocation0033VVDLaneRgstList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0033Event event = (EsmSpc0033Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();

		try{
			List<SearchSpaceAllocation0033LaneRgstVO> list = command.searchSpaceAllocation0033VVDLaneRgstList(event.getSearchSpaceAllocation0033LaneRgstVO());
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
	 * ESM_SPC_0033 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceAllocation0033VVDLanePortRgstList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0033Event event = (EsmSpc0033Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();

		try{
			List<SearchSpaceAllocation0033LaneRgstVO> list = command.searchSpaceAllocation0033VVDLanePortRgstList(event.getSearchSpaceAllocation0033LaneRgstVO());
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
	 * ESM_SPC_0033 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceAllocation0033BSACapaList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0033Event event = (EsmSpc0033Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();

		try{
			List<SearchSpaceAllocation0033LaneRgstVO> list = command.searchSpaceAllocation0033BSACapaList(event.getSearchSpaceAllocation0033LaneRgstVO());
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
	 * ESM_SPC_0033 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceAllocation0033BSACapaByPort(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0033Event event = (EsmSpc0033Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();

		try{
			List<SearchSpaceAllocation0033LaneRgstVO> list = command.searchSpaceAllocation0033BSACapaByPort(event.getSearchSpaceAllocation0033LaneRgstVO());
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
	 * ESM_SPC_0033 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiSpaceAllocation0033LaneRgstList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0033Event event = (EsmSpc0033Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		
		try{
			begin();
			command.multiSpaceAllocation0033LaneRgstList(event.getSearchSpaceAllocation0033LaneRgstVOS(),account);
			eventResponse.setETCData("status", "OK");
			eventResponse.setUserMessage(new ErrorHandler("SPC00010").getUserMessage());
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
	 * ESM_SPC_0033 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiSpaceAllocation0033LanePortRgstList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0033Event event = (EsmSpc0033Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		
		try{
			begin();
			command.multiSpaceAllocation0033LanePortRgstList(event.getSearchSpaceAllocation0033LaneRgstVOS(),account);
			eventResponse.setETCData("status", "OK");
			eventResponse.setUserMessage(new ErrorHandler("SPC00010").getUserMessage());
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
	 * ESM_SPC_0033 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiSpaceAllocation0033VVDLaneRgstList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0033Event event = (EsmSpc0033Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		
		try{
			begin();
			command.multiSpaceAllocation0033VVDLaneRgstList(event.getSearchSpaceAllocation0033LaneRgstVOS(),account);
			eventResponse.setETCData("status", "OK");
			eventResponse.setUserMessage(new ErrorHandler("SPC00010").getUserMessage());
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
	 * ESM_SPC_0033 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiSpaceAllocation0033VVDLanePortRgstList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0033Event event = (EsmSpc0033Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		
		try{
			begin();
			command.multiSpaceAllocation0033VVDLanePortRgstList(event.getSearchSpaceAllocation0033LaneRgstVOS(),account);
			eventResponse.setETCData("status", "OK");
			eventResponse.setUserMessage(new ErrorHandler("SPC00010").getUserMessage());
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
	 * ESM_SPC_0073 : Retrieve <BR>
	 * 0073 화면 Customer/Commodity Code를 조회<br>
	 * 
	 * @param e EsmSpc0073Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActualCustomer(Event e) throws EventException {

		// PDTO(Data Transfer Object including Parameters)
		EsmSpc0073Event event = (EsmSpc0073Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try 
		{
			List<SearchActualCustomerVO> list = command.searchActualCustomer(event.getInfoVO());
	
			eventResponse.setRsVoList(list);
			if(list.size() > 0){
				eventResponse.setETCData("from_dt", list.get(0).getFromDt());
				eventResponse.setETCData("to_dt", list.get(0).getToDt());
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		
		return eventResponse;
	}
	
		/**
	 * ESM_SPC_0042 : [이벤트]<br>
	 * control option 저장 후 해당 Row에 필요한 컬럼 정보 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceAllocationControlFlagList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0042Event event = (EsmSpc0042Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();

		try{
			List<SpaceAllocationManageVO> list = command.searchSpaceAllocationControlFlagList(event.getConditionVO(), account);
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