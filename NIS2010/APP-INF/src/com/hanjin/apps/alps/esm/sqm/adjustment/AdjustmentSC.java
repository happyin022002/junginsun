/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : AdjustmentSC.java
*@FileTitle      : AdjustmentSC
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.31
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.31 SQM USER
* 1.0 Creation
* 2013.10.21 PEJ   [CHM-201327263] Figure Inquiry  조회 팝업 추가 searchPotnFigureInquriyList 추가(ESM_SQM_0043/ESM_SQM_0044)
* 2013.12.10 PEJ   [CHM-201328059] QTA Edit_Office Add 팝업 추가(ESM_SQM_0045)
* 2013.12.17 PEJ   [CHM-201328060] 2014년 연간 판매목표 수립 지원(Trade 필수항목으로 변경)
* 2014.01.16 PEJ   [CHM-201328244] IAS Sector Sales 판매시스템 개발
* 2014.07.30 이혜민 [CHM-201431302] QTA Inquiry_Quarterly Current QTA Report for IAS Sector 에서 Raw Data Export 산출 로직 변경 CSR
* 2014.09.25 이혜민 [CHM-201431935] Portion Adjustment 화면의 From, TO VVD 입력 시 Portion Connected <> 'I' 인 VVD alert.
* 2015.01.16 이혜민 [CHM-201533644] Raw data Export 보완
* 2015.02.12 김용습 [CHM-201534142] Alloc = QTA 화면 내 Trade Direction 기능 추가
* 2015.02.23 이혜민 [CHM-201534159] Alloc = QTA 화면 내 Alloc Delete 기능 추가
* 2015.05.15 이혜민 [CHM-201535608] Adjustment 화면 3개 Creation전 RHQ별 Portion 존재하고, Office portion이 없는 List 조회.
* 2015.07.09 김용습 [CHM-201536817] [CSR 전환건] Final QTA Adjustment > Post QTA Adjustment > QTA Edit for IAS Sector 화면 내 Week 조회 로직 수정			
* 2015.07.17 김용습 [CHM-201537066] [CSR 전환건] QTA Inquiry_Yearly Current QTA Report for IAS Sector 조회 로직 변경			
* 2015.07.22 김용습 [CHM-201537172] [CSR 전환건] QTA Adjustment by VVD 화면 내 신규 기능 추가
* 2015.08.06 김용습 [CHM-201537260] [CSR 전환 건] SQM내 Report에 과거 CM 체계 기준 판매목표 데이터 조회 기능 생성 (15년 2Q 이전 데이터 Freeze) 
* 2015.10.01 김용습 [CHM-201537934] [CSR 전환건] Allocation = QTA의 "SPC Alloc Apply" 로직 수정
* 2015.10.06 김용습 [CHM-201538196] Portion Adjustment by RHQ, Head Office 화면 내 해당 분기 값만 입력 가능토록 Validation 설정
* 2015.12.09 김용습 [CHM-201539254] VVD Adjustment, VVD Adjustment for IAS Sector에서 Currently Updated에서 BSA 매뉴얼로 수정가능하도록 로직 수정.
* 2016.01.15 CHM-201639770 VVD Adjustment의 Update Option 추가 CSR
* 2016.02.05 최성민 [CHM-201639787] SQM Planning 도중 & Planning 완료 후 노선, P/F Group, Sector 추가 로직 Process 변경
* 2016.03.23 CHM-201640708 Office별 포션 자동 입력 로직 수정
* 2016.06.24 [CHM-201642264] Contract View IAS Office Portion 입력 화면 개발건 로직 개요
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.adjustment;

import java.util.List;

import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.basic.QtaAdjustmentBC;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.basic.QtaAdjustmentBCImpl;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.event.EsmSqm0031Event;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.event.EsmSqm0032Event;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.event.EsmSqm0033Event;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.event.EsmSqm0034Event;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.event.EsmSqm0035Event;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.event.EsmSqm0043Event;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.event.EsmSqm0045Event;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.event.EsmSqm0219Event;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.event.EsmSqm0220Event;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.event.EsmSqm0221Event;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.event.EsmSqm0222Event;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.event.EsmSqm0224Event;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.SearchAllocQtaListVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.SearchLaneOfficeListVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.SearchPotnAdjustmentListVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.SearchPotnFigureInquiryListVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.SearchQtaAdjustmentForSectorListVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.SearchQtaAdjustmentListVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.SearchQtaEditListVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtainquiry.basic.QtaInquiryBC;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtainquiry.basic.QtaInquiryBCImpl;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtainquiry.event.EsmSqm0036Event;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtainquiry.event.EsmSqm0037Event;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtainquiry.event.EsmSqm0225Event;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtainquiry.event.EsmSqm0226Event;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtainquiry.vo.SearchCurrentQtaIasSectorVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtainquiry.vo.SearchQuarterlyCurrnetQtaListVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtainquiry.vo.SearchYearlyCurrnetQtaListVO;
import com.hanjin.apps.alps.esm.sqm.common.basic.CommonBC;
import com.hanjin.apps.alps.esm.sqm.common.basic.CommonBCImpl;
import com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.basic.OfficeMappingBC;
import com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.basic.OfficeMappingBCImpl;
import com.hanjin.apps.alps.esm.sqm.planning.planning.basic.PlanningBC;
import com.hanjin.apps.alps.esm.sqm.planning.planning.basic.PlanningBCImpl;
import com.hanjin.apps.alps.esm.sqm.planning.planning.vo.SearchQtaLoadRevForSectorListVO;
import com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.integration.AdjustmentDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-adjustment Business Logic ServiceCommand - ALPS-DataManage 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author SQM USER
 * @see AdjustmentDBDAO
 * @since J2EE 1.6
 */
public class AdjustmentSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;
	
	/**
	 * Adjustment system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("AdjustmentSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}
	
	/**
	 * Adjustment system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("AdjustmentSC 종료");
	}
	
	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-Adjustment system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmSqm0031Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaAdjustmentList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageQtaAdjustment(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = saveSupply(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0031(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOfcZeroPortion(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = comparisonWithHo(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = comparisonWithRhq(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = findVvdFromOtherQuarter(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSqm0032Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPotnAdjustmentByHOList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0032(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePotnAdjustmentByHO(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createPotnAdjustmentByHO(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = searchRhqGroupRowAdd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchApplyWeek(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchVvdCngTpCd(e); 			
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0033Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPotnAdjustmentByRHQList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0033(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePotnAdjustmentByRHQ(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createPotnAdjustmentByRHQ(e);
			}  else if(e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = searchOfcGroupRowAdd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchApplyWeek(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0034Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaEditList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0034(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComBoByQtr(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchWeekComBoByQtr(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageQtaEdit(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createCmcbAdjust(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0035Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAllocQtaList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComBoByQtr0035(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0035(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageAllocQta(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageQtaEditForAlloc(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = deleteQtaEditForAlloc(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = activateData(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0036Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchYearlyCurrnetQta(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchYearlyCurrnetQtaPreviousVersion(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = excelDownYearlyCurrnetQta(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = excelDownYearlyCurrnetQtaPreviousVersion(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0036(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0037Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQuarterlyCurrnetQta(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchQuarterlyCurrnetQtaPreviousVersion(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = excelDownQuarterlyCurrnetQta(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = excelDownQuarterlyCurrnetQtaPreviousVersion(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0037(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0043Event")) { //ESM_SQM_0043, ESM_SQM_0044
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPotnFigureInquriyList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0045Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLaneOfficeList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = createQtaOfficeAdd(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0045(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0219Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0219(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchQtaAdjustmentForSectorList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createQtaAdjustmentForSector(e);				
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = saveSupplyForSector(e);				
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0220Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0220(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaEditIasSectorList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComBoByQtr0220(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchWeekComBoByQtr0220(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageQtaEditIasSector(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createCmcbAdjustIasSector(e);
			} 
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0221Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0221(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaEditPolPodPairAddIasSector(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createQtaEditPolPodPairAddIasSector(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0222Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0222(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaEditOfficeAddIasSector(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createQtaEditOfficeAddIasSector(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchQtaLoadRevForAddSectorList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createQtaLoadRevForAddSector(e);
			}
			
			
			
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0224Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0224(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComBoByQtr0224(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRbccoPfmcQtaSetIasSector(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageRbccoPfmcQtaSetIasSector(e);
			}  
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0225Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0225(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCurrQtaReptYrIasSector(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCurrQtaReptYrIasSectorCurrentlyUpdated(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCurrQtaReptYrIasSectorPreviousVersion(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = excelDownCurrQtaReptYrIasSector(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = excelDownCurrQtaReptYrIasSectorCurrentlyUpdated(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = excelDownCurrQtaReptYrIasSectorPreviousVersion(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse = excelDownCurrQtaReptYrIasSectorCurrentlyUpdatedPreviousVersion(e);
			} 
			
		}else if (e.getEventName().equalsIgnoreCase("EsmSqm0226Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0226(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCurrQtaReptQtrIasSector(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCurrQtaReptQtrIasSectorPreviousVersion(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = excelDownCurrQtaReptQtrIasSector(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = excelDownCurrQtaReptQtrIasSectorPreviousVersion(e);
			} 
			
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0031 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0031(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Quarter */
					{"quarter", "", ""},
					/* 3. Current Quarter. */
					{"currentQta", "", ""},
					/* 4. Bound. */
					{"comCodeBound", "", "All"},
					/* 5. YN. */
					{"comCodeYn", "", "All"},
					/* 6. trade Direction. */
					{"comCodeTrdDir", "", "All"}
			};
			
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0032 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0032(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Quarter */
					{"quarter", "", ""},
					/* 3. Current Quarter. */
					{"currentQta", "", ""},
					/* 4. Office View */
					{"officeView", "", ""},
					/* 5. Bound */
					{"comCodeBound", "", "All"},
					/* 6. In/Out Bound. */
					{"comCodeOutNonOutBound", "", "All"},
					/* 7. trade Direction. */
					{"comCodeTrdDir", "", "All"}
			};
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0033 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0033(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Quarter */
					{"quarter", "", ""},
					/* 3. Current Quarter. */
					{"currentQta", "", ""},
					/* 4. Office View */
					{"officeView", "", ""},
					/* 5. Bound */
					{"comCodeBound", "", "All"},
					/* 6. In/Out Bound. */
					{"comCodeOutNonOutBound", "", "All"},
					/* 7. trade Direction. */
					{"comCodeTrdDir", "", "All"}
			};
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0034 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0034(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Quarter */
					{"quarter", "", ""},
					/* 3. Current Quarter. */
					{"currentQta", "", ""},
					/* 4. Office View */
					{"officeView", "", ""},
					/* 5. Trade */
					{"trade", "", ""},
					/* 6. Rhq */
					{"rhq", "", "All"},
					/* 7. Bound */
					{"comCodeBound", "", "All"}, 
					/* 8. Change Type code */
					{"comCodecngTp", "", "All"}, 
					/* 9. trade Direction. */
					{"comCodeTrdDir", "", "All"}
			};
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0035 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0035(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Trade */
					{"mdmTrade", "", "All"},
					/* 3. Rhq */
					{"rhq", "", "All"},
					/* 4. Bound */
					{"comCodeBound", "", "All"}, 
					/* 5. Current Quarter. */
					{"currentQta", "", ""},
					/* 6. trade Direction. */
					{"comCodeTrdDir", "", "All"}
			};
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0036 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0036(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Current Quarter. */
					{"currentQta", "", ""},
					/* 3. Office level */
					{"comCodeOfcLvl", "", ""},
					/* 4. RHQ. */
					{"rhq", "", "All"},
					/* 5. Office View */
					{"officeView", "", ""},
					/* 6. Trade */
					{"mdmTrade", "", "All"},
					/* 7. Bound. */
					{"comCodeBound", "", "All"},
					/* 8. trade Direction. */
					{"comCodeTrdDir", "", "All"}
			};
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0037 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0037(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Quarter */
					{"quarter", "", ""},
					/* 3. Current Quarter. */
					{"currentQta", "", ""},
					/* 4. Office level */
					{"comCodeOfcLvl", "", ""},
					/* 5. RHQ. */
					{"rhq", "", "All"},
					/* 6. Office View */
					{"officeView", "", ""},
					/* 7. Trade */
					{"mdmTrade", "", "All"},
					/* 8. Bound. */
					{"comCodeBound", "", "All"},
					/* 9. trade Direction. */
					{"comCodeTrdDir", "", "All"}
			};
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0031 : Retrieve 이벤트 처리<br>
	 * [QTA Adjustment by VVD]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaAdjustmentList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0031Event event = (EsmSqm0031Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			List<SearchQtaAdjustmentListVO> list = command.searchQtaAdjustmentList(event.getConditionVO(), account);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0031 : SEARCH03 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse findVvdFromOtherQuarter(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0031Event event = (EsmSqm0031Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			List<SearchQtaAdjustmentListVO> list = command.findVvdFromOtherQuarter(event.getConditionVO(), account);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0031 : COMMAND02 이벤트 처리<br>
	 * [QTA Adjustment by VVD]와 [Portion adjustment by Head Office]와의 결과 비교
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse comparisonWithHo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0031Event event = (EsmSqm0031Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			List<SearchQtaAdjustmentListVO> list = command.comparisonWithHo(event.getConditionVO(), account);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0031 : COMMAND03 이벤트 처리<br>
	 * [QTA Adjustment by VVD]와 [Portion adjustment by RHQ]와의 결과 비교
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse comparisonWithRhq(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0031Event event = (EsmSqm0031Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			List<SearchQtaAdjustmentListVO> list = command.comparisonWithRhq(event.getConditionVO(), account);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0031 : MULTI 이벤트 처리<br>
	 * [QTA Adjustment by VVD]을 [CUD 처리] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageQtaAdjustment(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0031Event event = (EsmSqm0031Event)e; 
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			begin();
			command.manageQtaAdjustment(event.getManageQtaAdjustmentVOS(), event.getConditionVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0031 : MULTI01 이벤트 처리<br>
	 * [QTA Adjustment by VVD]을 [CUD 처리] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse saveSupply(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0031Event event = (EsmSqm0031Event)e; 
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			begin();
			command.saveSupply(event.getManageQtaAdjustmentVOS(), event.getConditionVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0031,0032,0033 : Creation 이벤트 처리<br>
	 * Adjustment화면에서 Creation 전 RHQ에는 Portion을 부여했으나 해당 RHQ 산하의 Office에게 Portion을 부여하지 않은 RHQ List를 조회합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfcZeroPortion(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0031Event event = (EsmSqm0031Event)e; 
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		String list = "";
		StringBuffer listTtl = new StringBuffer();

		try{
			List<String> OfcZeroPortion = command.searchOfcZeroPortion(event.getConditionVO());
			if(OfcZeroPortion.size()>0){
				for(int i=0; i<OfcZeroPortion.size(); i++){
					listTtl.append(",\n");
					listTtl.append(OfcZeroPortion.get(i));
					list = listTtl.toString();
				}
			}
			eventResponse.setETCData("OfcZeroPortion", list);
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
	 * ESM_SQM_0032 : Retrieve 이벤트 처리<br>
	 * [Portion Adjustment by Head Office]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchPotnAdjustmentByHOList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0032Event event = (EsmSqm0032Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			List<SearchPotnAdjustmentListVO> list = command.searchPotnAdjustmentList(event.getConditionVO(),account);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0032 : Retrieve 이벤트 처리<br>
	 * [Portion Adjustment by Head Office]을 [저장] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse managePotnAdjustmentByHO(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0032Event event = (EsmSqm0032Event)e; 
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			begin();
			command.managePotnAdjustment(event.getConditionVO(), event.getSearchPotnAdjustmentListVOS(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0032 : MULTI02 이벤트 처리<br>
	 * [Portion Adjustment by Head Office]를 [생성] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRhqGroupRowAdd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0032Event event = (EsmSqm0032Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			List<SearchPotnAdjustmentListVO> list = command.searchRhqGroupRowAdd(event.getConditionVO(),account);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0032, ESM_SQM_0033 : SEARCH01 이벤트 처리<br>
	 * [Portion Adjustment by Head Office, RHQ]에서 vvd의 주차를 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchApplyWeek(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0032Event event = (EsmSqm0032Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {			
			String[] aplyWk = command.searchApplyWeek(event.getConditionVO(),event.getVvd());			
			eventResponse.setETCData("aply_wk", aplyWk[0]);
			eventResponse.setETCData("cost_yrmon", aplyWk[1]);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0032 : SEARCH02 이벤트 처리<br>
	 * [Portion Adjustment by Head Office]에서 vvd 입력 시 해당 VVD가 Alloc 적용됐거나 QTA Edit에서 매뉴얼로 수정되었는지 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchVvdCngTpCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0032Event event = (EsmSqm0032Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		String list = "";
		StringBuffer listTtl = new StringBuffer();
		
		try {			
			List<String> vvdList = command.searchVvdCngTpCd(event.getConditionVO());			
			if(vvdList.size()>0){
				for(int i=0; i<vvdList.size(); i++){
					listTtl.append("&");
					listTtl.append(vvdList.get(i));
					list = listTtl.toString();
				}
			}
			eventResponse.setETCData("vvdList", list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0032 : MULTI01 이벤트 처리<br>
	 * [Portion Adjustment by Head Office]에서 확정데이터를 [재생성] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createPotnAdjustmentByHO(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0032Event event = (EsmSqm0032Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			begin();
			command.createPotnAdjustmentByHO(event.getConditionVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0033 : Retrieve 이벤트 처리<br>
	 * [Portion Adjustment by RHQ]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchPotnAdjustmentByRHQList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0033Event event = (EsmSqm0033Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			List<SearchPotnAdjustmentListVO> list = command.searchPotnAdjustmentList(event.getConditionVO(),account);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0033 : Retrieve 이벤트 처리<br>
	 * [Portion Adjustment by RHQ]을 [저장] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse managePotnAdjustmentByRHQ(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0033Event event = (EsmSqm0033Event)e; 
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			begin();
			command.managePotnAdjustment(event.getConditionVO(), event.getSearchPotnAdjustmentListVOS(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0033 : MULTI02 이벤트 처리<br>
	 * [Portion Adjustment by RHQ]를 [생성] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchOfcGroupRowAdd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0033Event event = (EsmSqm0033Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			List<SearchPotnAdjustmentListVO> list = command.searchRhqGroupRowAdd(event.getConditionVO(),account);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0033 : MULTI01 이벤트 처리<br>
	 * [Portion Adjustment by RHQ]에서 확정데이터를 [재생성] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createPotnAdjustmentByRHQ(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0033Event event = (EsmSqm0033Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			begin();
			command.createPotnAdjustmentByRHQ(event.getConditionVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0034 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoByQtr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0034Event event = (EsmSqm0034Event)e;
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Month */
					{"month", "", "All"},
//					/* 2. Week */
//					{"week", "", "All"}

			};
			eventResponse = codeUtil.getMakeCodeSelectListForPlanning(event.getConditionVO(),account, array);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0035 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoByQtr0035(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0035Event event = (EsmSqm0035Event)e;
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Month */
					{"month", "", "All"},
					/* 2. Week */
					{"week", "", "All"}

			};
			eventResponse = codeUtil.getMakeCodeSelectListForPlanning(event.getConditionVO(),account, array);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0034 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWeekComBoByQtr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0034Event event = (EsmSqm0034Event)e;
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Week */
					{"revisedWeekForOverall", "", "All"}

			};
			eventResponse = codeUtil.getMakeCodeSelectListForPlanning(event.getConditionVO(),account, array);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0034 : Retrieve 이벤트 처리<br>
	 * [Qta Edit]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaEditList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0034Event event = (EsmSqm0034Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			List<SearchQtaEditListVO> list = command.searchQtaEditList(event.getConditionVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0034 : MULTI 이벤트 처리<br>
	 * [Qta Edit]을을 [저장] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageQtaEdit(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0034Event event = (EsmSqm0034Event)e; 
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			begin();
			command.manageQtaEdit(event.getSqmCfmQtaVOS(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0034 : MULTI01 이벤트 처리<br>
	 * [CMCB adjust]을을 [저장] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */	
	private EventResponse createCmcbAdjust(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0034Event event = (EsmSqm0034Event)e; 
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			begin();
			command.createCmcbAdjust(event.getConditionVO(),account.getUsr_id());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0035 : Retrieve 이벤트 처리<br>
	 * [Allocation = QTA Setting]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAllocQtaList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0035Event event = (EsmSqm0035Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			List<SearchAllocQtaListVO> list = command.searchAllocQtaList(event.getConditionVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0035 : MULTI 이벤트 처리<br>
	 * [Allocation = QTA Setting]을을 [저장] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageAllocQta(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0035Event event = (EsmSqm0035Event)e; 
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();

		try {
			begin();
			command.manageAllocQta(event.getSqmAlocQtaVOS(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0036 : Retrieve 이벤트 처리<br>
	 * [QTA Inquiry_Yearly Overall (Currently Updated)]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchYearlyCurrnetQta(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0036Event event = (EsmSqm0036Event)e;
		QtaInquiryBC command = new QtaInquiryBCImpl();
		
		try {
			List<SearchYearlyCurrnetQtaListVO> list = command.searchYearlyCurrnetQtaList(event.getConditionVO(), "N");
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0036 : Retrieve 이벤트 처리<br>
	 * [QTA Inquiry_Yearly Overall (Currently Updated)]을 [조회] 합니다. (Previous Version)
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchYearlyCurrnetQtaPreviousVersion(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0036Event event = (EsmSqm0036Event)e;
		QtaInquiryBC command = new QtaInquiryBCImpl();
		
		try {
			List<SearchYearlyCurrnetQtaListVO> list = command.searchYearlyCurrnetQtaListPreviousVersion(event.getConditionVO(), "N");
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0036 : Raw Data Export 이벤트 처리<br>
	 * Sheet 에 보여주지 않고 필수 조회조건에 해당하는 전체 Data Excel Down 합니다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse excelDownYearlyCurrnetQta(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0036Event event = (EsmSqm0036Event)e;
		QtaInquiryBC command = new QtaInquiryBCImpl();

		try {
			eventResponse.setRs(command.excelDownYearlyCurrentQta(event.getConditionVO(), "Y"));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0036 : Raw Data Export 이벤트 처리<br>
	 * Sheet 에 보여주지 않고 필수 조회조건에 해당하는 전체 Data Excel Down 합니다. (PreviousVersion)
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse excelDownYearlyCurrnetQtaPreviousVersion(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0036Event event = (EsmSqm0036Event)e;
		QtaInquiryBC command = new QtaInquiryBCImpl();

		try {
			eventResponse.setRs(command.excelDownYearlyCurrentQtaPreviousVersion(event.getConditionVO(), "Y"));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0037 : Retrieve 이벤트 처리<br>
	 * [QTA Inquiry_Quarterly Overall (Currently Updated)]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQuarterlyCurrnetQta(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0037Event event = (EsmSqm0037Event)e;
		QtaInquiryBC command = new QtaInquiryBCImpl();
		
		try {
			List<SearchQuarterlyCurrnetQtaListVO> list = command.searchQuarterlyCurrnetQtaList(event.getConditionVO(), "N");
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0037 : Retrieve 이벤트 처리<br>
	 * [QTA Inquiry_Quarterly Overall (Currently Updated)]을 [조회] 합니다. (PreviousVersion)
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQuarterlyCurrnetQtaPreviousVersion(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0037Event event = (EsmSqm0037Event)e;
		QtaInquiryBC command = new QtaInquiryBCImpl();
		
		try {
			List<SearchQuarterlyCurrnetQtaListVO> list = command.searchQuarterlyCurrnetQtaListPreviousVersion(event.getConditionVO(), "N");
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0037 : Raw Data Export 이벤트 처리<br>
	 * Sheet 에 보여주지 않고 필수 조회조건에 해당하는 전체 Data Excel Down 합니다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse excelDownQuarterlyCurrnetQta(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0037Event event = (EsmSqm0037Event)e;
		QtaInquiryBC command = new QtaInquiryBCImpl();

		try {
			eventResponse.setRs(command.excelDownQuarterlyCurrentQta(event.getConditionVO(), "Y"));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0037 : Raw Data Export 이벤트 처리<br>
	 * Sheet 에 보여주지 않고 필수 조회조건에 해당하는 전체 Data Excel Down 합니다. (Previous Version)
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse excelDownQuarterlyCurrnetQtaPreviousVersion(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0037Event event = (EsmSqm0037Event)e;
		QtaInquiryBC command = new QtaInquiryBCImpl();

		try {
			eventResponse.setRs(command.excelDownQuarterlyCurrentQtaPreviousVersion(event.getConditionVO(), "Y"));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0035 : MULTI01 이벤트 처리<br>
	 * [Allocation = QTA Setting]을을 [confirm] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageQtaEditForAlloc(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0035Event event = (EsmSqm0035Event)e; 
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			begin();
			command.manageQtaEditForAlloc(event.getSqmAlocQtaVOS(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SQM_0035 : MULTI02 이벤트 처리<br>
	 * [Allocation = QTA Setting]을을 [delete] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse deleteQtaEditForAlloc(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0035Event event = (EsmSqm0035Event)e; 
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			begin();
			command.deleteQtaEditForAlloc(event.getSqmAlocQtaVOS(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0035 : MULTI03 이벤트 처리<br>
	 * [Allocation = QTA Setting]을 [Activate] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse activateData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0035Event event = (EsmSqm0035Event)e; 
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			begin();
			command.activateData(event.getSqmAlocQtaVOS(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0043/ESM_SQM_0044 : Retrieve 이벤트 처리<br>
	 * [Figure Inquiry]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchPotnFigureInquriyList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0043Event event = (EsmSqm0043Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			List<SearchPotnFigureInquiryListVO> list = command.searchPotnFigureInquiryList(event.getConditionVO(), account);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0045 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0045(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. sub Trade. */
					{"subTrade", "IAS", ""},
					/* 2. IAS Region */
					{"iasRegion", "", "All"},
					/* 3. RHQ. */
					{"rhqForPlan", "", ""},
					/* 4. Bound. */
					{"comCodeBound", "", ""}
			};
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0045 : Retrieve 이벤트 처리<br>
	 * [IAS Lane Office List]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchLaneOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0045Event event = (EsmSqm0045Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			List<SearchLaneOfficeListVO> list = command.searchLaneOfficeList(event.getConditionVO(), account);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_SQM_0045 : Creation 이벤트 처리<br>
	 * [IAS QTA Office Add]을 [생성]  및 [Lane-Office Relation Setting] 상태를 변경 한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */	
	private EventResponse createQtaOfficeAdd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0045Event event = (EsmSqm0045Event)e; 
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		OfficeMappingBC commandOfc = new OfficeMappingBCImpl();
		
		try {
			begin();
			// 확정 데이터에 Office를 추가한다.
			command.createQtaOfficeAdd(event.getSearchLaneOfficeListVOS(), event.getConditionVO(), account);
			// Lane-Office Relation Setting 의 Active 상태를 변경한다.
			commandOfc.modifyLaneOfficeRelation(event.getSqmQtaLaneOfcVOS(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_SQM_0219 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0219(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Quarter */
					{"quarter", "", ""},
					/* 3. Current Quarter. */
					{"currentQta", "", ""},
					/* 4. sub Trade. */
					{"subTradeSector", "", "All"},
					/* 5. IAS Region */
					{"iasRegion", "", "All"},
					/* 6. Bound. */
					{"comCodeBound", "", "All"},
					/* 7. trade Direction. */
					{"comCodeTrdDir", "", "All"}
			};
			
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}	

	/**
	 * ESM_SQM_0219 : Retrieve 이벤트 처리<br>
	 * [QTA Adjustment by VVD For Sector]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaAdjustmentForSectorList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0219Event event = (EsmSqm0219Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			List<SearchQtaAdjustmentForSectorListVO> list = command.searchQtaAdjustmentForSectorList(event.getConditionVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}	
	

	/**
	 * ESM_SQM_0219 : Creation<br>
	 * [QTA Adjustment by VVD For Secter]을 [복사][변경][삭제] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */	
	private EventResponse createQtaAdjustmentForSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0219Event event = (EsmSqm0219Event)e; 
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			begin();
			// Adjustment by VVD For Sector Creation
			command.createQtaAdjustmentForSector(event.getManageQtaAdjustmentVOS(), event.getConditionVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_SQM_0219 : Save Supply<br>
	 * [QTA Adjustment by VVD For Secter]을 [저장] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */	
	private EventResponse saveSupplyForSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0219Event event = (EsmSqm0219Event)e; 
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			begin();
			command.saveSupplyForSector(event.getManageQtaAdjustmentVOS(), event.getConditionVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0220 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0220(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Quarter */
					{"quarter", "", ""},
					/* 3. Current Quarter. */
					{"currentQta", "", ""},
					/* 4. Office View */
					{"officeView", "", ""},
					/* 5. RHQ. */
					{"rhq", "", "All"},
					/* 6. sub Trade. */
					{"subTradeSector", "", ""},
					/* 7. IAS Region */
					{"iasRegion", "", "All"},
					/* 8. Bound. */
					{"comCodeBound", "", ""},
					/* 9. trade Direction. */
					{"comCodeTrdDir", "", ""}		
			};
			
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}	
	
	/**
	 * ESM_SQM_0220: 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoByQtr0220(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0220Event event = (EsmSqm0220Event)e;
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Month */
					{"month", "", "All"},
					/* 2. Week */
//					{"week", "", "All"}

			};
			eventResponse = codeUtil.getMakeCodeSelectListForPlanning(event.getConditionVO(),account, array);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0220: 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWeekComBoByQtr0220(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0220Event event = (EsmSqm0220Event)e;
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Week */
					{"revisedWeekForSector", "", "All"}

			};
			eventResponse = codeUtil.getMakeCodeSelectListForPlanning(event.getConditionVO(),account, array);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0220 : Retrieve 이벤트 처리<br>
	 * [Qta Edit for IAS Sector]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaEditIasSectorList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0220Event event = (EsmSqm0220Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			List<SearchQtaEditListVO> list = command.searchQtaEditIasSectorList(event.getConditionVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0220 : MULTI 이벤트 처리<br>
	 * [Qta Edit for IAS Sector]을 [저장] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageQtaEditIasSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0220Event event = (EsmSqm0220Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			begin();
			command.manageQtaEditIasSector(event.getSqmSctrCfmQtaVOS(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0220 : MULTI01 이벤트 처리<br>
	 * [CMCB adjust for IAS Sector]을 [저장] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */	
	private EventResponse createCmcbAdjustIasSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0220Event event = (EsmSqm0220Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			begin();
			command.createCmcbAdjustIasSector(event.getConditionVO(),account.getUsr_id());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0221 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0221(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. sub Trade. */
					{"subTradeSector", "", ""},
					/* 2. IAS Region */
					{"iasRegion", "", "All"},
					/* 3. Bound. */
					{"comCodeBound", "", ""}
			};
			
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}	
	
	/**
	 * ESM_SQM_0221 : Retrieve 이벤트 처리<br>
	 * [Qta Edit POL-POD Pair Add for IAS Sector]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaEditPolPodPairAddIasSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0221Event event = (EsmSqm0221Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			List<SearchQtaEditListVO> list = command.searchQtaEditPolPodPairAddIasSector(event.getConditionVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0221 : CREATION<br>
	 * [Qta Edit POL-POD Pair Add for IAS Sector]을 [생성] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createQtaEditPolPodPairAddIasSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0221Event event = (EsmSqm0221Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			begin();
			command.createQtaEditPolPodPairAddIasSector(event.getManageQtaEditIasSectorVOS(), event.getConditionVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0222 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0222(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. sub Trade. */
					{"subTradeSector", "", ""},
					/* 2. IAS Region */
					{"iasRegion", "", "All"},
					/* 3. Bound. */
					{"comCodeBound", "", ""},
					/* 4. RHQ. */
					{"rhq", "", "All"},
			};
			
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}	
	
	/**
	 * ESM_SQM_0222 : Retrieve 이벤트 처리<br>
	 * [Qta Edit Office Add for IAS Sector]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaEditOfficeAddIasSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0222Event event = (EsmSqm0222Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			List<SearchQtaEditListVO> list = command.searchQtaEditOfficeAddIasSector(event.getConditionVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_SQM_0222 : Retrieve 이벤트 처리<br>
	 * [Qta Edit Office Add for IAS Sector]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaLoadRevForAddSectorList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0222Event event = (EsmSqm0222Event)e;
		PlanningBC command = new PlanningBCImpl();
		
		try {
			List<SearchQtaLoadRevForSectorListVO> list = command.searchQtaLoadRevForAddSectorList(event.getConditionVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	
	
	/**
	 * ESM_SQM_0222 : CREATION<br>
	 * [Qta Edit Office Add for IAS Sector]을 [생성] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createQtaEditOfficeAddIasSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0222Event event = (EsmSqm0222Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			begin();
			command.createQtaEditOfficeAddIasSector(event.getManageQtaEditIasSectorVOS(), event.getConditionVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	

	
	/**
	 * ESM_SQM_0222 : CREATION<br>
	 * [Qta Edit Office Add for IAS Sector]을 [생성] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createQtaLoadRevForAddSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0222Event event = (EsmSqm0222Event)e;
		PlanningBC command = new PlanningBCImpl();
		
		try {
			begin();
			command.createQtaLoadRevForAddSector(event.getSqmSctrLodRevVOs(), event.getConditionVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0224 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0224(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Quarter */
					{"quarter", "", ""},
					/* 3. Next Quarter. */
					{"nextQta", "", ""}		
			};
			
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}	
	
	/**
	 * ESM_SQM_0224: 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoByQtr0224(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0224Event event = (EsmSqm0224Event)e;
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Week */
					{"week", "", "All"}

			};
			eventResponse = codeUtil.getMakeCodeSelectListForPlanning(event.getConditionVO(),account, array);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0224 : Retrieve 이벤트 처리<br>
	 * [RBCCO PFMC = QTA Setting for IAS Sector]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRbccoPfmcQtaSetIasSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0224Event event = (EsmSqm0224Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			List<SearchQtaEditListVO> list = command.searchRbccoPfmcQtaSetIasSector(event.getConditionVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0224 : Apply 이벤트 처리<br>
	 * [RBCCO PFMC = QTA Setting for IAS Sector]을 [Apply] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageRbccoPfmcQtaSetIasSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0224Event event = (EsmSqm0224Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			begin();
			command.manageRbccoPfmcQtaSetIasSector(event.getSearchQtaEditListVOS(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0225 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0225(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					
					/* 1. Year */
					{"year", "", ""},
					/* 2. Current Quarter. */
					{"currentQta", "", ""},
					/* 3. Office View */
					{"officeView", "", ""},
					/* 4. Office level */
					{"comCodeOfcLvl", "", ""},					
					/* 5. RHQ. */
					{"rhq", "", "All"},
					/* 6. sub Trade. */
					{"subTradeSector", "", "All"},
					/* 7. IAS Region */
					{"iasRegion", "", "All"},
					/* 8. Bound. */
					{"comCodeBound", "", "All"},
					/* 9. trade Direction. */
					{"comCodeTrdDir", "", "All"}		
			};
			
			
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}	
	
	/**
	 * ESM_SQM_0225 : [Retrieve]<br>
	 * [QTA Inquiry_Yearly Current QTA Report for IAS Sector]을 [조회] 합니다. (Initially Fixed)<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCurrQtaReptYrIasSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0225Event event = (EsmSqm0225Event)e;
		QtaInquiryBC command = new QtaInquiryBCImpl();
		
		try {
			List<SearchCurrentQtaIasSectorVO> list = command.searchCurrQtaReptYrIasSector(event.getConditionVO(), "N");
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0225 : [Retrieve]<br>
	 * [QTA Inquiry_Yearly Current QTA Report for IAS Sector]을 [조회] 합니다. (PreviousVersion)<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCurrQtaReptYrIasSectorPreviousVersion(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0225Event event = (EsmSqm0225Event)e;
		QtaInquiryBC command = new QtaInquiryBCImpl();
		
		try {
			List<SearchCurrentQtaIasSectorVO> list = command.searchCurrQtaReptYrIasSectorPreviousVersion(event.getConditionVO(), "N");
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0225 : [Retrieve]<br>
	 * [QTA Inquiry_Yearly Current QTA Report for IAS Sector]을 [조회] 합니다.(Currently Updated)<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCurrQtaReptYrIasSectorCurrentlyUpdated(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0225Event event = (EsmSqm0225Event)e;
		QtaInquiryBC command = new QtaInquiryBCImpl();
		
		try {
			List<SearchCurrentQtaIasSectorVO> list = command.searchCurrQtaReptYrIasSectorCurrentlyUpdated(event.getConditionVO(), "N");
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0225 : Raw Data Export 이벤트 처리<br>
	 * Sheet 에 보여주지 않고 필수 조회조건에 해당하는 전체 Data Excel Down 합니다. (Initially Fixed)
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse excelDownCurrQtaReptYrIasSector(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0225Event event = (EsmSqm0225Event)e;
		QtaInquiryBC command = new QtaInquiryBCImpl();

		try {
			eventResponse.setRs(command.excelDownCurrQtaReptYrIasSector(event.getConditionVO(), "Y"));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0225 : Raw Data Export 이벤트 처리<br>
	 * Sheet 에 보여주지 않고 필수 조회조건에 해당하는 전체 Data Excel Down 합니다. (Currently Updated)
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse excelDownCurrQtaReptYrIasSectorCurrentlyUpdated(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0225Event event = (EsmSqm0225Event)e;
		QtaInquiryBC command = new QtaInquiryBCImpl();

		try {
			eventResponse.setRs(command.excelDownCurrQtaReptYrIasSectorCurrentlyUpdated(event.getConditionVO(), "Y"));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0225 : Raw Data Export 이벤트 처리<br>
	 * Sheet 에 보여주지 않고 필수 조회조건에 해당하는 전체 Data Excel Down 합니다. (Initially Fixed) (PreviousVersion)
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse excelDownCurrQtaReptYrIasSectorPreviousVersion(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0225Event event = (EsmSqm0225Event)e;
		QtaInquiryBC command = new QtaInquiryBCImpl();

		try {
			eventResponse.setRs(command.excelDownCurrQtaReptYrIasSectorPreviousVersion(event.getConditionVO(), "Y"));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0225 : Raw Data Export 이벤트 처리<br>
	 * Sheet 에 보여주지 않고 필수 조회조건에 해당하는 전체 Data Excel Down 합니다. (Currently Updated) (PreviousVersion)
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse excelDownCurrQtaReptYrIasSectorCurrentlyUpdatedPreviousVersion(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0225Event event = (EsmSqm0225Event)e;
		QtaInquiryBC command = new QtaInquiryBCImpl();

		try {
			eventResponse.setRs(command.excelDownCurrQtaReptYrIasSectorCurrentlyUpdatedPreviousVersion(event.getConditionVO(), "Y"));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0226 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0226(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Quarter */
					{"quarter", "", ""},
					/* 3. Current Quarter. */
					{"currentQta", "", ""},
					/* 4. Office View */
					{"officeView", "", ""},
					/* 5. Office level */
					{"comCodeOfcLvl", "", ""},					
					/* 6. RHQ. */
					{"rhq", "", "All"},
					/* 7. sub Trade. */
					{"subTradeSector", "", "All"},
					/* 8. IAS Region */
					{"iasRegion", "", "All"},
					/* 9. Bound. */
					{"comCodeBound", "", "All"},
					/* 10. trade Direction. */
					{"comCodeTrdDir", "", "All"}		
			};
			
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0226 : [Retrieve]<br>
	 * [QTA Inquiry_Quarterly Current QTA Report for IAS Sector]을 [조회] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCurrQtaReptQtrIasSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0226Event event = (EsmSqm0226Event)e;
		QtaInquiryBC command = new QtaInquiryBCImpl();
		
		try {
			List<SearchCurrentQtaIasSectorVO> list = command.searchCurrQtaReptQtrIasSector(event.getConditionVO(), "N");
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0226 : [Retrieve]<br>
	 * [QTA Inquiry_Quarterly Current QTA Report for IAS Sector]을 [조회] 합니다. (Previous Version)
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCurrQtaReptQtrIasSectorPreviousVersion(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0226Event event = (EsmSqm0226Event)e;
		QtaInquiryBC command = new QtaInquiryBCImpl();
		
		try {
			List<SearchCurrentQtaIasSectorVO> list = command.searchCurrQtaReptQtrIasSectorPreviousVersion(event.getConditionVO(), "N");
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0226 : Raw Data Export 이벤트 처리<br>
	 * Sheet 에 보여주지 않고 필수 조회조건에 해당하는 전체 Data Excel Down 합니다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse excelDownCurrQtaReptQtrIasSector(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0226Event event = (EsmSqm0226Event)e;
		QtaInquiryBC command = new QtaInquiryBCImpl();

		try {
			eventResponse.setRs(command.excelDownCurrQtaReptQtrIasSector(event.getConditionVO(), "Y"));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SQM_0226 : Raw Data Export 이벤트 처리<br>
	 * Sheet 에 보여주지 않고 필수 조회조건에 해당하는 전체 Data Excel Down 합니다. (PreviousVersion)
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse excelDownCurrQtaReptQtrIasSectorPreviousVersion(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSqm0226Event event = (EsmSqm0226Event)e;
		QtaInquiryBC command = new QtaInquiryBCImpl();

		try {
			eventResponse.setRs(command.excelDownCurrQtaReptQtrIasSectorPreviousVersion(event.getConditionVO(), "Y"));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
}