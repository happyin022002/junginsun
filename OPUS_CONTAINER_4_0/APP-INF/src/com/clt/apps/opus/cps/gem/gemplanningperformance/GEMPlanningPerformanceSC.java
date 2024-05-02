/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : GEMPlanningPerformanceSC.java
 *@FileTitle : Expense Performance Maintenance
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.17
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.04.17 최정미 , 진윤오
 * 1.0 Creation
 * ----------------------------------------------------------------------------------------------
 * 2010.09.17 이준범 [CHM-201006046-01] toLclAmt , toUsdAmt 는 모두  fmLclAmt(fmUsdAmt) 기준으로 생성한다.
 * 2010.11.19 이준범 [CHM-201007198-01] Initial Plan - Closing date 설정 이후 INI RQ/AD/AP block 적용
 * 1) open000103()
 *   - searchInitialDate() ofcCd 파라미터 추가
 *   - 화면에서 Closing DT 의 유효성을 식별할수 있는 initClzFlg 를 추가하여 Input필드 및 Save 버튼  block 적용
 * 2011.01.04 이준범[선조치] Processing Status 화면 보완
 * 1) open000103()
 *   - Initial 조회시 다음차년도 계획일정이 존재하지않으면, 당해년도로 데이터 조회되도록 보완     
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.cps.gem.common.GemUtil;
import com.clt.apps.opus.cps.gem.gemcommon.gemcommon.basic.GEMCommonBC;
import com.clt.apps.opus.cps.gem.gemcommon.gemcommon.basic.GEMCommonBCImpl;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.basic.GEMMasterCodeMgtBC;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.basic.GEMMasterCodeMgtBCImpl;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.integration.GEMMasterCodeMgtDBDAO;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.GemExpenseVO;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.GemXchRtVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.basic.GEMPlanningPerformanceBC;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.basic.GEMPlanningPerformanceBCImpl;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event.CpsGem000101Event;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event.CpsGem000102Event;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event.CpsGem000103Event;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event.CpsGem0002Event;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event.CpsGem0003Event;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event.CpsGem0004Event;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event.CpsGem001401Event;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event.CpsGem001402Event;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event.CpsGem0015Event;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event.CpsGem0016Event;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event.CpsGem0018Event;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event.CpsGem0019Event;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event.CpsGem0023Event;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event.CpsGem0101Event;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event.CpsGem0104Event;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event.CpsGem0105Event;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event.CpsGem0106Event;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event.CpsGem0108Event;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event.CpsGemFns0030001Event;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event.CpsGemFns0090001Event;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event.CpsGemFns0510001Event;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event.CpsGemFns0610001Event;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.ActRsltSubsPerfVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.AssignedExpnVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.AuthExpnInfoVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.ClosingDateVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.ComparisonPlanningVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.DetailRequestExpenseRqstNoVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.DetailRequestExpenseVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.DetailYearlyExpenseVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.GemApprovalStepVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.GemItemVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.GemRequestVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.GemSlpIfVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.GemSlpPerfVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.ItemVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.OfficeHierarchyVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.OfficeLevelVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.PerformanceInfoVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.PlanningPerformanceVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.PlanningStatusCondVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.PlanningStatusVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.PlanningVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.RatioReasonVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.Report0023R1VO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.Report0025R1VO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.ReportAfterClosingVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.RqsNoVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.RqstInfoVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.RqstPlanInfoVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.SearchOfficeCurrencyVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.SearchProcessingStatusVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.SearchRqstNoReferenceVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.SearchYearlyExpenseVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.SlipPerformanceVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.SubsPerfVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.TransferVO;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.DateTime;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.table.ComBakEndJbVO;

/**
 * NIS2010-GEMPlanningPerformanceSC Business Logic ServiceCommand - NIS2010-GEMPlanningPerformanceSC 대한 비지니스
 * 트랜잭션을 처리한다. 일반관리비 기준정보 관리
 * 
 * @author choijungmi
 * @see GEMMasterCodeMgtDBDAO
 * @since J2EE 1.4
 */

public class GEMPlanningPerformanceSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;
	
	// 레포트 파일 구분자
	private final String SP = "|&&|";
	private final String EOR = "//EOR//";
	/**
	 * GEMCommon system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
		}
	}

	/**
	 * GEMPlanningPerformanceSC system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("GEMPlanningPerformanceSC 종료");
	}

	// ************************************************************************************************

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-GEMPlanningPerformanceSC system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {

		// 이벤트 정보
		EventResponse eventResponse =  new GeneralEventResponse();
		// 이벤트 명 취득
		String eventName = e.getEventName();
		// Command 명 취득
		FormCommand cmd = e.getFormCommand();
		
		
		
		// ===========================================================================
		// J.Y.O
		// ===========================================================================
		// ---------------------------------------------------------------------------
		// [CPS_GEM_0101] Authorized Expense Code
		// ---------------------------------------------------------------------------
		if ("CpsGem0101Event".equalsIgnoreCase(eventName)) {
							
			// [Open]
			if (cmd.isCommand(FormCommand.INIT)) {
				eventResponse = open0101(e);
			// [Retrieve]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchAuthorizedExpenseInfo(e);			
			} 

		} 
		
		// ---------------------------------------------------------------------------
		// [CPS_GEM_0104] Assigned Expense
		// ---------------------------------------------------------------------------    
		else if ("CpsGem0104Event".equalsIgnoreCase(eventName)) {
			
			// [Open]
			if (cmd.isCommand(FormCommand.INIT)) {
				eventResponse = searchAssignedExpenseInfo(e);			
			} 

		} 
		
		// ---------------------------------------------------------------------------
		// [CPS_GEM_0105] Request No. Reference
		// ---------------------------------------------------------------------------    
		else if ("CpsGem0105Event".equalsIgnoreCase(eventName)) {
			
			// [Open]
			if (cmd.isCommand(FormCommand.INIT)) {
				eventResponse = searchRqstNoReference(e);			
			} 

		} 		
		
		
		// ---------------------------------------------------------------------------
		// [CPS_GEM_0001_01] Expense Request – Initial & Additional
		// ---------------------------------------------------------------------------
		else if ("CpsGem0001Event".equalsIgnoreCase(eventName)) {
			//초기 tab 로딩시 jsp에서 권한 취득
			eventResponse = getAuthFlg(e);
		}
		else if ("CpsGem000101Event".equalsIgnoreCase(eventName)) {
							
			// [Open]
			if (cmd.isCommand(FormCommand.INIT)) {
				eventResponse = open000101(e);
			// [Retrieve]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchExpensePlanning(e);			
			// [maxItemNo]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchMaxItem(e);			
			// [checkExpnInfo]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = checkExpnInfo(e);			
			// 저장 
			} else if (cmd.isCommand(FormCommand.MULTI)) {
				eventResponse = manageExpensePlanning(e);
			// 삭제
			} else if (cmd.isCommand(FormCommand.REMOVE)) {
				eventResponse = removeExpensePlanning(e);			
			} else if (cmd.isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReqUpdDt(e);
			} else if (cmd.isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchItmUpdDt(e);
			}
			
		} 
		
		// ---------------------------------------------------------------------------
		// [CPS_GEM_0001_02] Expense Request – Transfer
		// ---------------------------------------------------------------------------    
		else if ("CpsGem000102Event".equalsIgnoreCase(eventName)) {			
			// [Open]
			if (cmd.isCommand(FormCommand.INIT)) {
				eventResponse = open000102(e);			
			} else if (cmd.isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCurrInfo(e);
			} else if (cmd.isCommand(FormCommand.MULTI)) {
				eventResponse = manageExpensePlanning02(e);
			// [Retrieve]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchExpensePlanning02(e);
			} else if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchToOfficeL2List(e);
			} else if (cmd.isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchToOfficeL3List(e);
			} 

		} 
		
		// ---------------------------------------------------------------------------
		// [CPS_GEM_0001_03] Expense Request – Adjustments
		// ---------------------------------------------------------------------------    
		else if ("CpsGem000103Event".equalsIgnoreCase(eventName)) {
			
			// [Open]
			if (cmd.isCommand(FormCommand.INIT)) {
				eventResponse = open000103(e);			
			// [Grid Retrieve]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchExpensePlanningStatus(e);
			// [Grid select]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchExpensePlanning03(e);
			} else if (cmd.isCommand(FormCommand.MULTI)) {
				eventResponse = manageExpensePlanning03(e);
			} else if (cmd.isCommand(FormCommand.MULTI01)) {
				eventResponse = manageExpensePlanning03(e);
			}  

		} 		
		
		// ---------------------------------------------------------------------------
		// [CPS_GEM_0003] Approval of Requested expense
		// --------------------------------------------------------------------------- 
		else if ("CpsGem0003Event".equalsIgnoreCase(eventName)) {
			
			// [Open]
			if (cmd.isCommand(FormCommand.INIT)) {
				eventResponse = open000103(e);			
			// [Grid Retrieve]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchExpensePlanningStatus(e);
			// [Grid select]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchExpensePlanning03(e);
			} else if (cmd.isCommand(FormCommand.MULTI)) {
				eventResponse = manageExpensePlanning05(e);
			} else if (cmd.isCommand(FormCommand.MULTI01)) {
				eventResponse = manageExpensePlanning05(e);
			}  else if (cmd.isCommand(FormCommand.MULTI02)) {
				eventResponse = manageExpensePlanning04(e);
			}  

		} 			
		
		// ---------------------------------------------------------------------------
		// [CPS_GEM_0002] Processing Status
		// --------------------------------------------------------------------------- 
		else if ("CpsGem0002Event".equalsIgnoreCase(eventName)) {
			
			// [Open]
			if (cmd.isCommand(FormCommand.INIT)) {
				eventResponse = open000103(e);			
			// [Grid Retrieve]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchExpensePlanningStatus02(e);
			// [Grid select]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchExpenseStatus(e);
			} 
		} 			
		// ---------------------------------------------------------------------------
		// [CPS_GEM_0023] Request / Initial _ Print
		// --------------------------------------------------------------------------- 
		else if ("CpsGem0023Event".equalsIgnoreCase(eventName)) {
			
			// [request initial]
			if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = report0023S1(e);
		    // [request transfer]	
			} else if (cmd.isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = report0024S1(e);
		    // [adjustment initial]	
			} else if (cmd.isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = report0025S1(e);
			// [adjustment transfer]	
			} else if (cmd.isCommand(FormCommand.SEARCHLIST04)) {
				eventResponse = report0027S1(e);				
			} 
		} 						
		
		// ===========================================================================
		// C.J.M
		// ===========================================================================
		
		// ---------------------------------------------------------------------------
		// [FNS009-0001] Receive WebLogic JMS Queue Proxy
		// ---------------------------------------------------------------------------
	    else if ("CpsGemFns0090001Event".equalsIgnoreCase(eventName)) {
				// [FNS009_0001]
			if (cmd.isCommand(FormCommand.SEARCH01)) {
				receiveFns0090001Slip(e);
			}
		}
		
		// ---------------------------------------------------------------------------
		// [FNS003-0001] Receive WebLogic JMS Queue Proxy
		// ---------------------------------------------------------------------------
	    else if ("CpsGemFns0030001Event".equalsIgnoreCase(eventName)) {
				// [FNS003_0001]
			if (cmd.isCommand(FormCommand.SEARCH01)) {
				receiveFns0030001Slip(e);
			}
		}
		
		// ---------------------------------------------------------------------------
		// [FNS051-0001] Receive WebLogic Web Service Proxy
		// ---------------------------------------------------------------------------
	    else if ("CpsGemFns0510001Event".equalsIgnoreCase(eventName)) {
				// [FNS051_0001]
			if (cmd.isCommand(FormCommand.SEARCH01)) {
				return receiveFns0510001Slip(e);
			}
		}
		
		// ---------------------------------------------------------------------------
		// [FNS061-0001] Receive WebLogic JMS Queue Proxy
		// ---------------------------------------------------------------------------
	    else if ("CpsGemFns0610001Event".equalsIgnoreCase(eventName)) {
				// [FNS061_0001]
			if (cmd.isCommand(FormCommand.SEARCH01)) {
				receiveFns0610001Slip(e);
			}
		}
		
		// ---------------------------------------------------------------------------
		// [CPS_GEM_0019] Detail_Yearly Expense
		// ---------------------------------------------------------------------------    
		else if ("CpsGem0019Event".equalsIgnoreCase(eventName)) {
				// [Open]
			if (cmd.isCommand(FormCommand.SEARCH)) {
				return open0019(e);			
				// [ExcelDown01 BackEndJob]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				return searchDetailByYearlyExpenseByBackEndJobKey(e);
				// [ExcelDown01 BackEndJob Status]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST02)) {
				return searchDetailByBackEndJobStatus(e);
				// [ExcelDown01 BackEndJob LoadFile]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST03)) {
				return searchDetailByYearlyExpenseByBackEndJobFile(e);
				// [ExcelDown02 BackEndJob]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST04)) {
				return searchDetailByRequestExpenseByBackEndJobKey(e);
				// [ExcelDown02 BackEndJob Status]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST05)) {
				return searchDetailByRequestExpenseByBackEndJobFile(e);
				// [ExcelDown03 BackEndJob]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST06)) {
				return searchDetailByRequestExpenseRqstNoByBackEndJobKey(e);
				// [ExcelDown03 BackEndJob Status]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST07)) {
				return searchDetailByRequestExpenseRqstNoByBackEndJobFile(e);
				// Office 권한 체
			} else if (cmd.isCommand(FormCommand.SEARCHLIST08)) {
				return searchOfficeAuth(e);
			}
			
		}
		
		// ===========================================================================
		// P.C.J
		// ===========================================================================
		
		// ---------------------------------------------------------------------------
		// [CPS_GEM_0004] 
		// ---------------------------------------------------------------------------		
		else if (e.getEventName().equalsIgnoreCase("CpsGem0004Event")) {

			if (cmd.isCommand(FormCommand.MULTI)) {
				eventResponse = manageSubsidiaryActualResults(e);
				// [Retrieve]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchSubsidiaryActualResults(e);
				// [Grid Row]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchOfficeExpenseMatrixLIstByExpense(e);
			} else if (cmd.isCommand(FormCommand.SEARCH)) {
				eventResponse = open0004(e);
				// [delete]
			} 
		} 
		
		// ---------------------------------------------------------------------------
		// [CPS_GEM_0016] 
		// ---------------------------------------------------------------------------		
		else if (e.getEventName().equalsIgnoreCase("CpsGem0016Event")) {
			
				// [Retrieve]
			if (cmd.isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchSlipInq(e);
				// [Grid Row]

			} else if (cmd.isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSlipInqOpen(e);
				// [delete]
			} 
		}
		
		// ---------------------------------------------------------------------------
		// [CPS_GEM_0015] 
		// ---------------------------------------------------------------------------		
		else if (e.getEventName().equalsIgnoreCase("CpsGem0015Event")) {

				// [Save]
			if (cmd.isCommand(FormCommand.MULTI)) {
				eventResponse = modifyExceedReason(e);
				// [Retrieve]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchPlanningPerformance(e);
				// [Grid Row]

			} else if (cmd.isCommand(FormCommand.SEARCH)) {
				eventResponse = searchExpnPerfOpen(e);
				// [delete]
			} 
		}
		
		// ---------------------------------------------------------------------------
		// [CPS_GEM_0014_01] 
		// ---------------------------------------------------------------------------		
		else if (e.getEventName().equalsIgnoreCase("CpsGem001401Event")) {
							
				// [Retrieve]
			if (cmd.isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchComparisonPlanning(e);
				// [Grid Row]

			} else if (cmd.isCommand(FormCommand.SEARCH)) {
				eventResponse = searchComparisonOpen(e);
				// [delete]
			} 
		}
		
		// ---------------------------------------------------------------------------
		// [CPS_GEM_0106] 
		// ---------------------------------------------------------------------------		
		else if (e.getEventName().equalsIgnoreCase("CpsGem0106Event")) {

			if (cmd.isCommand(FormCommand.SEARCH)) {
				eventResponse = searchApprovalOpinionInfo(e);
				
			} 
		}
		
		// ---------------------------------------------------------------------------
		// [CPS_GEM_0014_02] 
		// ---------------------------------------------------------------------------		
		else if (e.getEventName().equalsIgnoreCase("CpsGem001402Event")) {

			if (cmd.isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRqstInfo(e);
				
			} 
		}
		
		// ---------------------------------------------------------------------------
		// [CPS_GEM_0108] 
		// ---------------------------------------------------------------------------		
		else if (e.getEventName().equalsIgnoreCase("CpsGem0108Event")) {

			if (cmd.isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPerformanceInquiry(e);
				
			} 
		}
		
		// ---------------------------------------------------------------------------
		// [CPS_GEM_0107] 
		// ---------------------------------------------------------------------------		
		else if (e.getEventName().equalsIgnoreCase("CpsGem0107Event")) {

			if (cmd.isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPerformanceInquiry(e);
				
			} 
		}
		
		// ---------------------------------------------------------------------------
		// [CPS_GEM_0018] 
		// ---------------------------------------------------------------------------		
		else if (e.getEventName().equalsIgnoreCase("CpsGem0018Event")) {
				
				// [Retrieve]
			if (cmd.isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchReportAfterClosingAll(e);
				// [Grid Row]
			
			} else if (cmd.isCommand(FormCommand.SEARCHLIST04)) {
				eventResponse = searchReportAfterClosingExpense(e);
				
			} else if (cmd.isCommand(FormCommand.SEARCHLIST05)) {
				eventResponse = searchReportAfterClosingOffice(e);
				
			} else if (cmd.isCommand(FormCommand.SEARCHLIST06)) {
				eventResponse = searchReportAfterClosingSubsidiary(e);
				
			} else if (cmd.isCommand(FormCommand.SEARCHLIST07)) {
				eventResponse = searchReportAfterClosingMonthly(e);
				
			} else if (cmd.isCommand(FormCommand.SEARCHLIST08)) {
				eventResponse = searchReportAfterClosingSinwaExpense(e);
				
			} else if (cmd.isCommand(FormCommand.SEARCHLIST09)) {
				eventResponse = searchReportAfterClosingMonthlyComment(e);
				
			} else if (cmd.isCommand(FormCommand.SEARCHLIST10)) {
				return searchReportAfterClosingAllBackEndJobKey(e);
				
			} else if (cmd.isCommand(FormCommand.SEARCHLIST11)) {
				return searchReportAfterClosingAllBackEndJobStatus(e);
				
			} else if (cmd.isCommand(FormCommand.SEARCHLIST12)) {
				return searchReportAfterClosingAllBackEndJobFile(e);
				
			} else if (cmd.isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReportOpen(e);
				
			} 
		}
		

		
		return eventResponse;
	}

	// ===========================================================================
	// J.Y.O
	// ===========================================================================

	// ---------------------------------------------------------------------------
	// [CPS_GEM_0101] Authorized Expense Code
	// ---------------------------------------------------------------------------

    /**
     * 화면 open시 tic 콤보리스트 및 expense code 1 group  콤보리스트를 취득한다.<br>
     * 
     * @author J.Y.O
     * @category CPS_GEM_0101
     * @category open0101
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse open0101(Event e) throws EventException {

		// 반환 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();
			GEMMasterCodeMgtBC command1 = new GEMMasterCodeMgtBCImpl();

			// expense group 취득
			List<GemExpenseVO> rsVoList = command.searchExpenseGroupByLvl("1");
			eventResponse.setRsVoList(rsVoList);

			// TIC 취득
			String[] ticCd = command1.searchExpenseTICList();
			eventResponse.setETCData("ticCd", GemUtil.addSpChar(ticCd));
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	
    /**
     * 비용계획을 수립하기 위해서 조직별 승인받은 비용코드를 조회한다<br>
     * 
     * @author J.Y.O
     * @category CPS_GEM_0101
     * @category searchAuthorizedExpenseInfo
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAuthorizedExpenseInfo(Event e)
			throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 이벤트 생성
			CpsGem0101Event event = (CpsGem0101Event) e;
			AuthExpnInfoVO vo = event.getAuthExpnInfoVO();

			// 리스트 취득
			List<AuthExpnInfoVO> list = command.searchAuthorizedExpenseInfo(vo
					.getOfcCd(), vo.getGenExpnCd(), vo.getGenExpnGroupCd(), vo
					.getTicCd());

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(), ex);
		}
		return eventResponse;
	}

	
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0104] Assigned Expense
	// ---------------------------------------------------------------------------    
	
    /**
     * 추가배정, 비용이관을 수행하기 위해 최초확정된 비용계획 정보를 조회 한다<br>
     * 
     * @author J.Y.O
     * @category CPS_GEM_0104
     * @category searchAssignedExpenseInfo
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAssignedExpenseInfo(Event e)
			throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 이벤트 생성
			CpsGem0104Event event = (CpsGem0104Event) e;
			String ofcCd = event.getOfcCd();
			String plnYrmon = event.getPlnYrmon();
			String genExpnCd = event.getGenExpnCd();

			// 리스트 취득
			List<AssignedExpnVO> list = command.searchAssignedExpenseInfo(
					plnYrmon, ofcCd, genExpnCd);

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(), ex);
		}
		return eventResponse;
	}

	// ---------------------------------------------------------------------------
	// [CPS_GEM_0105] Request No. Reference
	// ---------------------------------------------------------------------------    
	
    /**
     * 집행단위에서 수립한 비용계획에 대한 Rquest Number 를 조회한다
     * 
     * @author J.Y.O
     * @category CPS_GEM_0105
     * @category searchRqstNoReference
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRqstNoReference(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();
			GEMMasterCodeMgtBC command1 = new GEMMasterCodeMgtBCImpl();
			// 이벤트 생성
			CpsGem0105Event event = (CpsGem0105Event) e;

			String plnYrmon = event.getPlnYrmon();
			String rqstOfcCd = command.searchUserOfficeCd(account.getOfc_cd());
			String updUserId = account.getUsr_id();
			String genExpnRqstTpCd = event.getGenExpnRqstTpCd();
			String authFlg = event.getAuthFlg();
			String prgId = event.getPrgId();

			// yyyy || '%' 해당년도만
			if (plnYrmon != null && plnYrmon.length() > 4) {
				plnYrmon = plnYrmon.substring(0, 4);
			}

			SearchRqstNoReferenceVO paramVo = new SearchRqstNoReferenceVO();
			paramVo.setAuthFlg(authFlg);
			paramVo.setPlnYrmon(plnYrmon);
			paramVo.setRqstOfcCd(rqstOfcCd);
			paramVo.setUpdUserId(updUserId);
			paramVo.setGenExpnRqstTpCd(genExpnRqstTpCd);
			paramVo.setPrgId(prgId);
			// 리스트 취득
			List<RqsNoVO> list = command.searchRqstNoReference(paramVo);

			// 계획환율 취득
			List<GemXchRtVO> xchRtList = command1.searchExchangeRateInfo(
					plnYrmon, "N");

			if (xchRtList != null) {
				Map<String, BigDecimal> map = new HashMap<String, BigDecimal>();
				for (int i = 0; i < xchRtList.size(); i++) {
					GemXchRtVO vo = xchRtList.get(i);
					map.put(vo.getCurrCd(),
							new BigDecimal(vo.getUsdLoclXchRt()));
				}

				// ---------------------------------------------
				// 금액 USD로 변환
				// ---------------------------------------------
				if (list != null) {
					for (int i = 0; i < list.size(); i++) {
						RqsNoVO vo = list.get(i);
						String frAmt = vo.getFrAmt();
						if (frAmt != null && !frAmt.equals("")) {

							BigDecimal frBigAmt = new BigDecimal(frAmt);
							String frUnit = vo.getFrUtVal();
							if (frUnit != null && !frUnit.equals("")) {
								frBigAmt = frBigAmt.multiply(new BigDecimal(
										frUnit));
							}

							String frCurrCd = vo.getFrCurrCd();
							if (map.containsKey(frCurrCd)) {
								frBigAmt = frBigAmt.divide(map.get(frCurrCd),
										4, BigDecimal.ROUND_DOWN);
								vo.setFrAmt(frBigAmt.toPlainString());
							} else {
								vo.setFrAmt("0");
							}
						}

						String toAmt = vo.getToAmt();
						if (toAmt != null && !toAmt.equals("")) {
							BigDecimal toBigAmt = new BigDecimal(toAmt);
							String toUnit = vo.getToUtVal();
							if (toUnit != null && !toUnit.equals("")) {
								toBigAmt = toBigAmt.multiply(new BigDecimal(
										toUnit));
							}

							String toCurrCd = vo.getToCurrCd();
							if (map.containsKey(toCurrCd)) {
								toBigAmt = toBigAmt.divide(map.get(toCurrCd),
										4, BigDecimal.ROUND_DOWN);
								vo.setToAmt(toBigAmt.toPlainString());
							} else {
								vo.setToAmt("0");
							}
						}

					}
				}

			}

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(), ex);
		}
		return eventResponse;
	}
	
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0001_01] Expense Request – Initial & Additional
	// ---------------------------------------------------------------------------
    /**
	 * Request 테이블의 update date 취득  
     * @author J.Y.O
     * @category CPS_GEM-0001-01
     * @category searchReqUpdDt    
	 * @param e Event
	 * @return response EventResponse
     * @throws EventException
     */
     private GeneralEventResponse searchReqUpdDt(Event e) throws EventException {
		// 반환 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 이벤트 생성
			CpsGem000101Event event = (CpsGem000101Event) e;

			String genExpnRqstNo = event.getGenExpnRqstNo();

			// request update date
			String reqDt = command.searchReqUpdDt(genExpnRqstNo);

			if (reqDt == null) {
				reqDt = "";
			}

			eventResponse.setETCData("reqDt", reqDt);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(), ex);
		}
		return eventResponse;
	}
	
   
     /**
 	 * Request 테이블의 update date 취득  
      * @author J.Y.O
      * @category CPS_GEM-0001-01
      * @category searchItmUpdDt    
 	 * @param e Event
 	 * @return response EventResponse
      * @throws EventException
      */
      public GeneralEventResponse searchItmUpdDt(Event e) throws EventException {

		// 반환 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 이벤트 생성
			CpsGem000101Event event = (CpsGem000101Event) e;

			String genExpnRqstNo = event.getGenExpnRqstNo();

			String genExpnRqstSeq = event.getGenExpnRqstSeq();

			// item update date
			String itmDt = command
					.searchItmUpdDt(genExpnRqstNo, genExpnRqstSeq);

			if (itmDt == null) {
				itmDt = "";
			}

			eventResponse.setETCData("itmDt", itmDt);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(), ex);
		}
		return eventResponse;
	}     
     
    /**
     * 화면 open시 jsp에서 tab의 auth_flg 설정 <br>
     * 
     * @author J.Y.O
     * @category CPS_GEM_0001_01
     * @category open000101 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse getAuthFlg(Event e) throws EventException {

		// 반환 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {

			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();
			// 로그인 오피스 정보
			String ofcCd = command.searchUserOfficeCd(account.getOfc_cd());

			// 회계년도
			String acctXchRtYrmon = DateTime.getYear() + "";

			// 오피스 Role , 오피스 환율 정보 취득
			OfficeLevelVO officeLevelVo = command.searchOfficeRqstInfo(ofcCd,
					acctXchRtYrmon);

			String authFlg = officeLevelVo.getAuthFlg();
			eventResponse.setCustomData("auth_flg", authFlg);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(), ex);
		}
		return eventResponse;
	}	
    /**
     * 화면 open시 오피스 정보 , 환율정보 , 마감일 취득 .<br>
     * 
     * @author J.Y.O
     * @category CPS_GEM_0001-01
     * @category open000101
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse open000101(Event e) throws EventException {
		// 반환 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 로그인 오피스 정보
			String ofcCd = command.searchUserOfficeCd(account.getOfc_cd());
			eventResponse.setETCData("usr_ofc_cd", ofcCd);

			// 회계년도
			String acctXchRtYrmon = DateTime.getYear() + "";

			// 오피스 Role , 오피스 환율 정보 취득
			OfficeLevelVO officeLevelVo = command.searchOfficeRqstInfo(ofcCd,
					acctXchRtYrmon);
			eventResponse.setRsVo(officeLevelVo);

			// 로그인 사용자 오피스 정보
			OfficeHierarchyVO officeHierarchyVO = command
					.searchOfficeHierarchy(ofcCd);
			eventResponse.setRsVo(officeHierarchyVO);

			// 마감 정보
			ClosingDateVO closingDateVO = command.searchClosingDate(
					acctXchRtYrmon, ofcCd);
			eventResponse.setRsVo(closingDateVO);

			// 차년도 예산 수립일 정보(inital)
			String initialDate = (DateTime.getYear() + 1) + "00";
			ClosingDateVO initDateVO = command.searchInitialDate(initialDate, ofcCd);
			if (initDateVO == null) {
				initDateVO = new ClosingDateVO();
				initDateVO.setClzYrmon(initialDate);
				String clzDt = (DateTime.getYear() + 1) + "0000";
				initDateVO.setClzDt(clzDt);
			}

			eventResponse.setRsVo(initDateVO);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(), ex);
		}

		return eventResponse;
	}
	

	
    /**
     * 비용코드정보 및 maxItem No 정보 취득  .<br>
     * 
     * @author J.Y.O
     * @category CPS_GEM_0001_01
     * @category checkExpnInfo
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkExpnInfo(Event e) throws EventException {

		// 반환 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {

			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 이벤트 생성
			CpsGem000101Event event = (CpsGem000101Event) e;

			// 오피스 정보
			String ofcCd = event.getOfcCd();
			// 비용코드
			String genExpnCd = event.getGenExpnCd();
			// 예산 년도
			String plnYrmon = event.getPlnYrmon();
			// 비용주관팀
			String ticCd = event.getTicCd();
			// 비용그룹
			String genExpnGroupCd = event.getGenExpnGroupCd();

			// 비용정보 취득
			GemExpenseVO expenseVO = command.searchRqstExpense(ofcCd,
					genExpnCd, ticCd, genExpnGroupCd);

			eventResponse.setRsVo(expenseVO);

			if (expenseVO != null) {
				// MaxItem번호 취득
				String maxItemNo = command.searchMaxItem(plnYrmon, ofcCd,
						genExpnCd);
				eventResponse.setETCData("itemNo", maxItemNo);
			} else {
				eventResponse.setETCData("itemNo", "001");
			}

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(), ex);
		}
		return eventResponse;
	}	

	
    /**
     * maxItem No 정보 취득  .<br>
     * 
     * @author J.Y.O
     * @category CPS_GEM_0001_01
     * @category searchExpnInfoAndMaxItem
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMaxItem(Event e) throws EventException {

		// 반환 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {

			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();
			// 이벤트 생성
			CpsGem000101Event event = (CpsGem000101Event) e;

			// 오피스 정보
			String ofcCd = event.getOfcCd();
			// 비용코드
			String genExpnCd = event.getGenExpnCd();
			// 예산 년도
			String plnYrmon = event.getPlnYrmon();

			// MaxItem번호 취득
			String maxItemNo = command
					.searchMaxItem(plnYrmon, ofcCd, genExpnCd);
			eventResponse.setETCData("itemNo", maxItemNo);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(), ex);
		}
		return eventResponse;
	}	
	
    /**
     * 유형별(계획비용, 추가배정, 예산이관) 요청한 계획비용 정보를 수정한다  .<br>
     * initial , addtional
     * @author J.Y.O
     * @category CPS_GEM_0001_01
     * @category manageExpensePlanning
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageExpensePlanning(Event e) throws EventException {
		// 반환 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			
			begin();
			
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 이벤트 생성
			CpsGem000101Event event = (CpsGem000101Event) e;

			PlanningVO vo = event.getPlanningVO();

			GemRequestVO requestVO = vo.getGemRequestVO();
			String userId = account.getUsr_id();

			requestVO.setUpdUsrId(userId);
			requestVO.setCreUsrId(userId);
			String usrOfcCd = command.searchUserOfficeCd(account.getOfc_cd());
			requestVO.setRqstOfcCd(usrOfcCd);
			
			vo.setUsrId(userId);
			vo.setUsrOfcCd(usrOfcCd);
			
			command.manageExpensePlanning(vo);
			
			//Request No 설정 
			
			eventResponse.setETCData("gen_expn_rqst_no", requestVO.getGenExpnRqstNo());
			
			
			// 성공 메세지설정
			eventResponse.setUserMessage(new ErrorHandler("GEM00008")
					.getUserMessage());
			commit();

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(), ex);
		}
		
		return eventResponse;
	}		
	
	
	

    /**
     * [CPS_GEM_0001_01] Expense Request – Initial & Additional     *  
     * 집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획을 조회
     * GEM_ITEM
     * @author J.Y.O
     * @category CPS_GEM_0001_01
     * @category searchExpensePlanning
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExpensePlanning(Event e) throws EventException {
		// 반환 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 이벤트 생성
			CpsGem000101Event event = (CpsGem000101Event) e;

			String genExpnRqstNo = event.getGenExpnRqstNo();

			GemRequestVO vo = command.searchExpenseRequest(genExpnRqstNo);
			eventResponse.setRsVo(vo);

			String usrOfcCd = command.searchUserOfficeCd(account.getOfc_cd());

			List<ItemVO> list = command.searchExpensePlanning(genExpnRqstNo,
					usrOfcCd, account.getUsr_id());

			// 년도 취득
			String pln_yr = event.getPlnYrmon();

			for (int i = 0; i < list.size(); i++) {
				ItemVO itemVo = list.get(i);
				// 1. 오피스 Role , 오피스 환율 정보 취득
				OfficeLevelVO officeLevelVo = command.searchOfficeRqstInfo(
						itemVo.getOfcCd(), pln_yr);

				itemVo.setUsdLoclXchRt(officeLevelVo.getUsdLoclXchRt());
				itemVo.setLoclCurrCd(officeLevelVo.getLoclCurrCd());
				itemVo.setRqstUtVal(officeLevelVo.getRqstUtVal());
				itemVo.setTtl(itemVo.getRqstLoclAmt());

				// USD금액
				BigDecimal usdLoclXchRt = new BigDecimal(itemVo
						.getUsdLoclXchRt());
				BigDecimal utVal = new BigDecimal(itemVo.getRqstUtVal());
				BigDecimal rqAmt = new BigDecimal(itemVo.getRqstLoclAmt());
				if (rqAmt.intValue() != 0) {
					BigDecimal rqstUsdAmt = GemUtil.getLclToUsdAmt(rqAmt,
							utVal, usdLoclXchRt);
					itemVo.setRqstUsdAmt(rqstUsdAmt.toPlainString());
				}

				// 2. 오피스 정보
				OfficeHierarchyVO officeHierarchyVO = command
						.searchOfficeHierarchy(itemVo.getOfcCd());
				itemVo.setSlsOfcDivCd(officeHierarchyVO.getRgnOfcFlg());
				itemVo.setOfcLvl1(officeHierarchyVO.getLevel2());
				itemVo.setOfcLvl2(officeHierarchyVO.getLevel3());

			}

			eventResponse.setRsVoList(list);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(), ex);
		}
		return eventResponse;
	}		

	
    /**
     * 집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획 삭제
     * 
     * @author J.Y.O
     * @category CPS_GEM_0001_01
     * @category removeExpensePlanning
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeExpensePlanning(Event e) throws EventException {
		// 반환 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			
			begin();
			
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 이벤트 생성
			CpsGem000101Event event = (CpsGem000101Event) e;
			
			//Request No
			String genExpnRqstNo = event.getGenExpnRqstNo();
			
			//삭제
			command.removeExpensePlanning(genExpnRqstNo);
			
			// 성공 메세지설정
			eventResponse.setUserMessage(new ErrorHandler("GEM00008")
					.getUserMessage());
			commit();

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(), ex);
		}
		
		
		return eventResponse;
	}			
	
	
	
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0001_02] Expense Request – Initial & Additional
	// ---------------------------------------------------------------------------
    /**
     * 화면 open시 오피스 정보 마감일 취득 .<br>
     * 
     * @author J.Y.O
     * @category CPS_GEM_0001_01
     * @category open000101
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse open000102(Event e) throws EventException {
		// 반환 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 로그인 오피스 정보
			String ofcCd = command.searchUserOfficeCd(account.getOfc_cd());
			eventResponse.setETCData("usr_ofc_cd", ofcCd);
			// 회계년도
			String acctXchRtYrmon = DateTime.getYear() + "";

			// 1. 오피스 Role , 오피스 환율 정보 취득
			OfficeLevelVO officeLevelVo = command.searchOfficeRqstInfo(ofcCd,
					acctXchRtYrmon);
			eventResponse.setRsVo(officeLevelVo);

			// 2. 로그인 사용자 오피스 정보
			OfficeHierarchyVO officeHierarchyVO = command
					.searchOfficeHierarchy(ofcCd);
			eventResponse.setRsVo(officeHierarchyVO);

			// 3. 마감 정보
			ClosingDateVO closingDateVO = command.searchClosingDate(
					acctXchRtYrmon, ofcCd);
			eventResponse.setRsVo(closingDateVO);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(), ex);
		}
		return eventResponse;
	}	
	
    /**
     * 통화정보 취득
     * GEM_ITEM
     * @author J.Y.O
     * @category CPS_GEM_0001_02
     * @category searchCurrInfo
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCurrInfo(Event e) throws EventException {

		// 반환 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 이벤트 생성
			CpsGem000102Event event = (CpsGem000102Event) e;

			// 요청 오피스 코드
			String ofcCd = event.getOfcCd();

			// 회계년도
			String acctXchRtYrmon = event.getPlnYrmon();

			// 1. 오피스 Role , 오피스 환율 정보 취득
			OfficeLevelVO officeLevelVo = command.searchOfficeRqstInfo(ofcCd,
					acctXchRtYrmon);
			eventResponse.setRsVo(officeLevelVo);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(), ex);
		}
		return eventResponse;
	}		
	
	
    /**
     * Transfer
     * 유형별(계획비용, 추가배정, 예산이관) 요청한 계획비용 정보를 수정한다  .<br>
     * 
     * @author J.Y.O
     * @category CPS_GEM_0001_02
     * @category manageExpensePlanning02
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageExpensePlanning02(Event e) throws EventException {
		// 반환 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			
			begin();
			
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 이벤트 생성
			CpsGem000102Event event = (CpsGem000102Event) e;

			PlanningVO vo = event.getPlanningVO();

			GemRequestVO requestVO = vo.getGemRequestVO();
			
			//Transfer경우 현재 년월 설정 
			String plnYrmon = DateTime.getFormatString("yyyyMM");
			requestVO.setPlnYrmon(plnYrmon);
			
			String userId = account.getUsr_id();
			requestVO.setUpdUsrId(userId);
			requestVO.setCreUsrId(userId);
			
			String usrOfcCd = command.searchUserOfficeCd(account.getOfc_cd());
			requestVO.setRqstOfcCd(usrOfcCd);
			vo.setUsrId(userId);
			vo.setUsrOfcCd(usrOfcCd);
			

			command.manageExpensePlanning(vo);
			
			//Request No 설정 
			
			eventResponse.setETCData("gen_expn_rqst_no", requestVO.getGenExpnRqstNo());
			
			
			// 성공 메세지설정
			eventResponse.setUserMessage(new ErrorHandler("GEM00008")
					.getUserMessage());
			commit();

		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(), ex);
		}

		
		return eventResponse;
	}			
	
    /**
     * 유형별(계획비용, 추가배정, 예산이관) 요청한 계획비용 정보를 수정한다  .<br>
     * adjustment
     * @author J.Y.O
     * @category CPS_GEM_0001_03
     * @category manageExpensePlanning03
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageExpensePlanning03(Event e) throws EventException {
		// 반환 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			
			begin();
			
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 이벤트 생성
			CpsGem000103Event event = (CpsGem000103Event) e;

			PlanningVO vo = event.getPlanningVO();

			GemRequestVO requestVO = vo.getGemRequestVO();
			String userId = account.getUsr_id();
			requestVO.setUpdUsrId(userId);
			requestVO.setCreUsrId(userId);
			String usrOfcCd = command.searchUserOfficeCd(account.getOfc_cd());
			requestVO.setRqstOfcCd(usrOfcCd);
			vo.setUsrId(userId);
			vo.setUsrOfcCd(usrOfcCd);
			
			// -----------------------------------------
			// 키항목			
			// -----------------------------------------			
			// gen_expn_rqst_no	
			// ofc_cd	
			// gen_expn_cd	
			// gen_expn_itm_no	
			// gen_expn_trns_div_cd	
			// gen_expn_rqst_seq	
			// gen_expn_apro_step_cd
			command.manageExpensePlanning03(vo);
			
			
			// 성공 메세지설정
			eventResponse.setUserMessage(new ErrorHandler("GEM00008")
					.getUserMessage());
			commit();

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(), ex);
		}
		
		return eventResponse;
	}		
	
    /**
     * 리스트에서 다건 승인처리 .<br>
     * approval
     * @author J.Y.O
     * @category CPS_GEM_0003
     * @category manageExpensePlanning04
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageExpensePlanning04(Event e) throws EventException {
		
		// 반환 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			
			begin();
			
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 이벤트 생성
			CpsGem0003Event event = (CpsGem0003Event) e;

			PlanningVO[] vo = event.getPlanningVOs();
			
			String userId = account.getUsr_id();
			
			for (int i = 0; i < vo.length; i++) {				
				PlanningVO planningVO = vo[i];
				
				GemRequestVO requestVO = planningVO.getGemRequestVO();
				requestVO.setUpdUsrId(userId);
				requestVO.setCreUsrId(userId);
				String usrOfcCd = command.searchUserOfficeCd(account.getOfc_cd());
				requestVO.setRqstOfcCd(usrOfcCd);		
				planningVO.setUsrId(userId);
				planningVO.setUsrOfcCd(usrOfcCd);
			
				// apros
				GemApprovalStepVO[] gemApprovalStepVOs = 
					planningVO.getGemApprovalStepVOs();
				
				for (int j = 0; j < gemApprovalStepVOs.length; j++) {
					GemApprovalStepVO gemApprovalStepVO = 
						gemApprovalStepVOs[j];					
					// 승인여부
					String genExpnApstsCd  = gemApprovalStepVO.getGenExpnApstsCd();
					// STEP
					String genExpnAproStepCd  = gemApprovalStepVO.getGenExpnAproStepCd();
                    
					gemApprovalStepVO.setGenExpnAproStepCd("");
					// 기존정보 에서 RQ,AD 데이타 검색 (수정대상)
					gemApprovalStepVO.setGenExpnApstsCd("RQ");
					List<GemApprovalStepVO> gemApprovalStepVOList =  
						command.searchExpenseAproStep(gemApprovalStepVO);
					
					//RQ가 존재 하지 않는 경우 AD로 검색
					if (gemApprovalStepVOList == null || 
							gemApprovalStepVOList.isEmpty()) {
						gemApprovalStepVO.setGenExpnApstsCd("AD");
						gemApprovalStepVOList =  
							command.searchExpenseAproStep(gemApprovalStepVO);
					} 
					
					GemApprovalStepVO stepVO = gemApprovalStepVOList.get(0);
					// 입력한 승인여부 설정
					stepVO.setGenExpnApstsCd(genExpnApstsCd);
					gemApprovalStepVO.setGenExpnAproStepCd(genExpnAproStepCd);
					
					gemApprovalStepVOs[j] = stepVO;
					
					
					
				}	
							
			}

			command.manageExpensePlanning04(vo);			
			// 성공 메세지설정
			eventResponse.setUserMessage(new ErrorHandler("GEM00008")
					.getUserMessage());

			commit();

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(), ex);
		}
		
		return eventResponse;
	}			
	
    /**
     * 리스트에서 한건 승인처리 .<br>
     * approval
     * @author J.Y.O
     * @category CPS_GEM_0003
     * @category manageExpensePlanning04
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageExpensePlanning05(Event e) throws EventException {
		
		// 반환 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			
			begin();
			
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 이벤트 생성
			CpsGem0003Event event = (CpsGem0003Event) e;
			String userId = account.getUsr_id();
			
			PlanningVO planningVO = event.getPlanningVO();				
			GemRequestVO requestVO = planningVO.getGemRequestVO();
			requestVO.setUpdUsrId(userId);
			requestVO.setCreUsrId(userId);
			
			String usrOfcCd = command.searchUserOfficeCd(account.getOfc_cd());
			requestVO.setRqstOfcCd(usrOfcCd);		
			planningVO.setUsrId(userId);
			planningVO.setUsrOfcCd(usrOfcCd);	
		
		    PlanningVO[] vo = new PlanningVO[]{planningVO};
			command.manageExpensePlanning04(vo);
			
			// 성공 메세지설정
			eventResponse.setUserMessage(new ErrorHandler("GEM00008")
					.getUserMessage());

			commit();

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(), ex);
		}
		
		return eventResponse;
	}		
	
    /**
     * 집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획을 조회
     * Transfer
     * @author J.Y.O
     * @category CPS_GEM_0001_02
     * @category searchExpensePlanning2
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExpensePlanning02(Event e)
			throws EventException {
		// 반환 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 이벤트 생성
			CpsGem000102Event event = (CpsGem000102Event) e;

			String genExpnRqstNo = event.getGenExpnRqstNo();

			String plnYrmon = event.getPlnYrmon();

			String plnYear = "";

			if (plnYrmon != null && plnYrmon.length() == 6) {
				plnYear = plnYrmon.substring(0, 4);
			}

			List<TransferVO> list = new ArrayList<TransferVO>();

			String usrOfcCd = command.searchUserOfficeCd(account.getOfc_cd());
			List<GemItemVO> gemItemList = command.searchTransferItem(
					genExpnRqstNo, usrOfcCd, account.getUsr_id());

			GemApprovalStepVO gemApprovalStepVO = new GemApprovalStepVO();
			gemApprovalStepVO.setGenExpnRqstNo(genExpnRqstNo);
			gemApprovalStepVO.setGenExpnAproStepCd("RQ");

			List<GemApprovalStepVO> gemApproStepList = command
					.searchExpenseAproStep(gemApprovalStepVO);

			for (int i = 0; i < gemItemList.size(); i++) {

				GemItemVO item = gemItemList.get(i);
				GemApprovalStepVO aproStep = gemApproStepList.get(i);

				// FM ===================================
				TransferVO vo = new TransferVO();
				vo.setFmOfcCd(item.getOfcCd());
				vo.setFmGenExpnCd(item.getGenExpnCd());
				vo.setFmGenExpnItmNo(item.getGenExpnItmNo());
				vo.setFmGenExpnTrnsDivCd(item.getGenExpnTrnsDivCd());
				vo.setFmGenExpnRqstSeq(item.getGenExpnRqstSeq());
				vo.setFmGenExpnItmDesc(item.getGenExpnItmDesc());
				vo.setFmGenExpnCalcBssDesc(item.getGenExpnCalcBssDesc());
				vo.setFmRqstOpinRmk(item.getRqstOpinRmk());

				vo.setFmJanAmt(item.getJanAmt());
				vo.setFmFebAmt(item.getFebAmt());
				vo.setFmMarAmt(item.getMarAmt());
				vo.setFmAprAmt(item.getAprAmt());
				vo.setFmMayAmt(item.getMayAmt());
				vo.setFmJunAmt(item.getJunAmt());
				vo.setFmJulAmt(item.getJulAmt());
				vo.setFmAugAmt(item.getAugAmt());
				vo.setFmSepAmt(item.getSepAmt());
				vo.setFmOctAmt(item.getOctAmt());
				vo.setFmNovAmt(item.getNovAmt());
				vo.setFmDecAmt(item.getDecAmt());
				// 2009-10-09 추가
				vo.setReqUpdDt(item.getReqUpdDt());
				vo.setItmUpdDt(item.getItmUpdDt());

				vo.setFmRqstJanAmt(aproStep.getJanAmt());
				vo.setFmRqstFebAmt(aproStep.getFebAmt());
				vo.setFmRqstMarAmt(aproStep.getMarAmt());
				vo.setFmRqstAprAmt(aproStep.getAprAmt());
				vo.setFmRqstMayAmt(aproStep.getMayAmt());
				vo.setFmRqstJunAmt(aproStep.getJunAmt());
				vo.setFmRqstJulAmt(aproStep.getJulAmt());
				vo.setFmRqstAugAmt(aproStep.getAugAmt());
				vo.setFmRqstSepAmt(aproStep.getSepAmt());
				vo.setFmRqstOctAmt(aproStep.getOctAmt());
				vo.setFmRqstNovAmt(aproStep.getNovAmt());
				vo.setFmRqstDecAmt(aproStep.getDecAmt());
				vo.setFmRqstLoclAmt(aproStep.getSumAmt());
				vo.setFmTtl(aproStep.getSumAmt());

				// usd , currcd 정보

				// 1. 오피스 Role , 오피스 환율 정보 취득
				OfficeLevelVO officeLevelVo = command.searchOfficeRqstInfo(item
						.getOfcCd(), plnYear);

				vo.setFmLoclCurrCd(officeLevelVo.getLoclCurrCd());
				vo.setFmUsdLoclXchRt(officeLevelVo.getUsdLoclXchRt());
				vo.setFmRqstUtVal(officeLevelVo.getRqstUtVal());

				// usd amt
				BigDecimal fmUsdLoclXchRt = new BigDecimal(vo
						.getFmUsdLoclXchRt());
				BigDecimal fmUtVal = new BigDecimal(vo.getFmRqstUtVal());

				// USD 금액 Rqst Amt
				BigDecimal fmUsdAmt = new BigDecimal(vo.getFmRqstLoclAmt());
				if (fmUsdAmt.intValue() != 0) {
					fmUsdAmt = GemUtil.getLclToUsdAmt(fmUsdAmt.abs(), fmUtVal,
							fmUsdLoclXchRt);
				}

				vo.setFmRqstUsdAmt(fmUsdAmt.toPlainString());

				// 비용정보 취득
				GemExpenseVO expenseVO = command.searchRqstExpense(vo
						.getFmOfcCd(), vo.getFmGenExpnCd(), "", "");
				vo.setFmEngAbbrNm(expenseVO.getEngAbbrNm());
				vo.setFmKrnAbbrNm(expenseVO.getKrnAbbrNm());
				vo.setFmTicCd(expenseVO.getTicCd());

				// 2. 오피스 정보
				OfficeHierarchyVO officeHierarchyVO = command
						.searchOfficeHierarchy(vo.getFmOfcCd());
				vo.setFmSlsOfcDivCd(officeHierarchyVO.getRgnOfcFlg());
				vo.setFmOfcLvl1(officeHierarchyVO.getLevel2());
				vo.setFmOfcLvl2(officeHierarchyVO.getLevel3());

				// TO ===================================
				// 다음행 증가
				i++;
				item = gemItemList.get(i);
				aproStep = gemApproStepList.get(i);

				vo.setToOfcCd(item.getOfcCd());
				vo.setToGenExpnCd(item.getGenExpnCd());
				vo.setToGenExpnItmNo(item.getGenExpnItmNo());
				vo.setToGenExpnTrnsDivCd(item.getGenExpnTrnsDivCd());
				vo.setToGenExpnRqstSeq(item.getGenExpnRqstSeq());
				vo.setToGenExpnItmDesc(item.getGenExpnItmDesc());
				vo.setToGenExpnCalcBssDesc(item.getGenExpnCalcBssDesc());
				vo.setToRqstOpinRmk(item.getRqstOpinRmk());

				vo.setToJanAmt(item.getJanAmt());
				vo.setToFebAmt(item.getFebAmt());
				vo.setToMarAmt(item.getMarAmt());
				vo.setToAprAmt(item.getAprAmt());
				vo.setToMayAmt(item.getMayAmt());
				vo.setToJunAmt(item.getJunAmt());
				vo.setToJulAmt(item.getJulAmt());
				vo.setToAugAmt(item.getAugAmt());
				vo.setToSepAmt(item.getSepAmt());
				vo.setToOctAmt(item.getOctAmt());
				vo.setToNovAmt(item.getNovAmt());
				vo.setToDecAmt(item.getDecAmt());
				// 2009-10-09 추가
				vo.setReqUpdDt(item.getReqUpdDt());
				vo.setItmUpdDt(item.getItmUpdDt());

				vo.setToRqstJanAmt(aproStep.getJanAmt());
				vo.setToRqstFebAmt(aproStep.getFebAmt());
				vo.setToRqstMarAmt(aproStep.getMarAmt());
				vo.setToRqstAprAmt(aproStep.getAprAmt());
				vo.setToRqstMayAmt(aproStep.getMayAmt());
				vo.setToRqstJunAmt(aproStep.getJunAmt());
				vo.setToRqstJulAmt(aproStep.getJulAmt());
				vo.setToRqstAugAmt(aproStep.getAugAmt());
				vo.setToRqstSepAmt(aproStep.getSepAmt());
				vo.setToRqstOctAmt(aproStep.getOctAmt());
				vo.setToRqstNovAmt(aproStep.getNovAmt());
				vo.setToRqstDecAmt(aproStep.getDecAmt());
				vo.setToRqstLoclAmt(aproStep.getSumAmt());
				vo.setToTtl(aproStep.getSumAmt());

				officeLevelVo = command.searchOfficeRqstInfo(item.getOfcCd(),
						plnYear);
				// 1. 오피스 Role , 오피스 환율 정보 취득
				vo.setToLoclCurrCd(officeLevelVo.getLoclCurrCd());
				vo.setToUsdLoclXchRt(officeLevelVo.getUsdLoclXchRt());
				vo.setToRqstUtVal(officeLevelVo.getRqstUtVal());

				/* 2010.09.14 이준범 
				 * toLclAmt , toUsdAmt 는 모두  fmLclAmt 기준으로 생성한다.
				 * 
				// usd amt
				BigDecimal toUsdLoclXchRt = new BigDecimal(vo
						.getToUsdLoclXchRt());
				BigDecimal toUtVal = new BigDecimal(vo.getToRqstUtVal());

				// USD 금액 Rqst Amt
				BigDecimal toUsdAmt = new BigDecimal(vo.getToRqstLoclAmt());
				if (toUsdAmt.intValue() != 0) {
					toUsdAmt = GemUtil.getLclToUsdAmt(toUsdAmt.abs(), toUtVal,
							toUsdLoclXchRt);
				}

				//vo.setToRqstUsdAmt(toUsdAmt.toPlainString());
				 * 
				 */
				vo.setToRqstUsdAmt(fmUsdAmt.toPlainString());
				
				// 비용정보 취득
				expenseVO = command.searchRqstExpense(vo.getToOfcCd(), vo
						.getToGenExpnCd(), "", "");
				vo.setToEngAbbrNm(expenseVO.getEngAbbrNm());
				vo.setToKrnAbbrNm(expenseVO.getKrnAbbrNm());
				vo.setToTicCd(expenseVO.getTicCd());

				// 2. 로그인 사용자 오피스 정보
				officeHierarchyVO = command.searchOfficeHierarchy(vo
						.getToOfcCd());
				vo.setToSlsOfcDivCd(officeHierarchyVO.getRgnOfcFlg());
				vo.setToOfcLvl1(officeHierarchyVO.getLevel2());
				vo.setToOfcLvl2(officeHierarchyVO.getLevel3());

				// 검색여부
				vo.setRetrieveYn("Y");

				list.add(vo);
			}

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999")
					.getMessage(), ex);
		}
		return eventResponse;
	}	
	

	
    /**
     * TO 오피스 레벨3(L3) 조직 정보 취득 
     * Transfer
     * @author J.Y.O
     * @category CPS_GEM_0001_02
     * @category SearchToOfficeL3List
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchToOfficeL3List(Event e) throws EventException {
		// 반환 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 이벤트 생성
			CpsGem000102Event event = (CpsGem000102Event) e;
			String toSlsOfcDivCd = event.getToSlsOfcDivCd();
			String toOfcLvl2 = event.getToOfcLvl2();
			String fmOfcLvl3 = event.getFmOfcLvl3();

			String[] list = command.searchToOfficeL3List(toSlsOfcDivCd,
					toOfcLvl2, fmOfcLvl3);

			eventResponse.setETCData("to_ofc_lvl3", GemUtil.addSpChar(list));
		} catch (EventException ex) {			
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {			
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999")
					.getMessage(), ex);
		}
		return eventResponse;
	}	
	
	
    /**
     * TO 오피스 레벨2(L2) 조직 정보 취득 
     * Transfer
     * @author J.Y.O
     * @category CPS_GEM_0001_02
     * @category SearchToOfficeL2List
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchToOfficeL2List(Event e) throws EventException {
		// 반환 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 이벤트 생성
			CpsGem000102Event event = (CpsGem000102Event) e;
			String toSlsOfcDivCd = event.getToSlsOfcDivCd();
			String toOfcLvl1 = event.getToOfcLvl1();
			String fmOfcLvl2 = event.getFmOfcLvl2();
			String fmOfcLvl3 = event.getFmOfcLvl3();

			String[] list = command.searchToOfficeL2List(toSlsOfcDivCd,
					toOfcLvl1, fmOfcLvl2, fmOfcLvl3);

			eventResponse.setETCData("to_ofc_lvl2", GemUtil.addSpChar(list));
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999")
					.getMessage(), ex);
		}
		return eventResponse;
	}	
	
	
	
	
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0001_03] Expense Request – Adjustment
	// ---------------------------------------------------------------------------
    /**
     * 화면 open시 오피스 정보 마감일 취득 .<br>
     * 
     * @author J.Y.O
     * @category CPS_GEM_0001_03
     * @category open000103
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse open000103(Event e) throws EventException {
		// 반환 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();
			GEMMasterCodeMgtBC command1 = new GEMMasterCodeMgtBCImpl();

			// 로그인 오피스 정보
			String ofcCd = command.searchUserOfficeCd(account.getOfc_cd());
			eventResponse.setETCData("usr_ofc_cd", ofcCd);
			// 회계년도
			String acctXchRtYrmon = DateTime.getYear() + "";
			// Init closing flag
			String initClzFlg = "N";
			
			// 1. 오피스 Role , 오피스 환율 정보 취득
			OfficeLevelVO officeLevelVo = command.searchOfficeRqstInfo(ofcCd,
					acctXchRtYrmon);
			eventResponse.setRsVo(officeLevelVo);

			// 2. 로그인 사용자 오피스 정보
			OfficeHierarchyVO officeHierarchyVO = command
					.searchOfficeHierarchy(ofcCd);
			eventResponse.setRsVo(officeHierarchyVO);

			// 3. 마감 정보
			ClosingDateVO closingDateVO = command.searchClosingDate(
					acctXchRtYrmon, ofcCd);
			eventResponse.setRsVo(closingDateVO);

			// 4.expense group 취득
			List<GemExpenseVO> rsVoList = command.searchExpenseGroupByLvl("1");
			eventResponse.setRsVoList(rsVoList);

			// 5. 차년도 예산 수립일 정보(inital)
			String initialDate = (DateTime.getYear() + 1) + "00";
			ClosingDateVO initDateVO = command.searchInitialDate(initialDate, ofcCd);
			// [201-01-06 CYO 수정] 다음년도예산 initial이없으면 현재년으로 설정
			if (initDateVO == null) {
				initDateVO = new ClosingDateVO();
				initDateVO.setClzYrmon((DateTime.getYear()) + "00");
				String clzDt = (DateTime.getYear() + "") + "0000";
				initDateVO.setClzDt(clzDt);
				initClzFlg = "Y";
			}
			eventResponse.setETCData("init_clz_flg", initClzFlg);
			eventResponse.setRsVo(initDateVO);

			// 6.TIC 취득
			String[] ticCd = command1.searchExpenseTICList();
			eventResponse.setETCData("ticCd", GemUtil.addSpChar(ticCd));

			// 7.사용자 Role취득
			String[] usrRole = command.searchUserRole(account.getUsr_id());
			eventResponse.setETCData("usrRole", GemUtil.addSpChar(usrRole));
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999")
					.getMessage(), ex);
		}
		return eventResponse;
	}	
		
    /**
     * Adjustment 조회
     * 계획비용 요청에 대한 현황을 조회한다 .<br>
     * 
     * @author J.Y.O
     * @category CPS_GEM_0001_03
     * @category searchExpensePlanningStatus
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExpensePlanningStatus(Event e)
			throws EventException {

		// 반환 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 이벤트 생성
			CpsGem000103Event event = (CpsGem000103Event) e;

			PlanningStatusCondVO planningStatusCondVO = event
					.getPlanningStatusCondVO();

			// 계획년도 입력
			String plnYrmon = planningStatusCondVO.getPlnYrmon();
			if (plnYrmon.length() > 4) {
				plnYrmon = plnYrmon.substring(0, 4);
				planningStatusCondVO.setPlnYrmon(plnYrmon);
			}

			// 사용자 오피스
			String usrOfcCd = command.searchUserOfficeCd(account.getOfc_cd());
			planningStatusCondVO.setUserOfcCd(usrOfcCd);

			// 승인 로그인 오피스
			planningStatusCondVO.setGenExpnAproAuthOfcCd(usrOfcCd);

			// 오피스
			String ofcExpnDiv = planningStatusCondVO.getOfcExpnDiv();
			String ofcExpnCd = planningStatusCondVO.getOfcExpnCd();

			if ("O".equals(ofcExpnDiv)) {
				planningStatusCondVO.setFmGenExpnCd("");
				planningStatusCondVO.setFmOfcCd(ofcExpnCd);
			} else {
				planningStatusCondVO.setFmGenExpnCd(ofcExpnCd);
				planningStatusCondVO.setFmOfcCd("");
			}

			// Request 구분 EA,EI,ET
			String genExpnRqstTpCd = planningStatusCondVO.getGenExpnRqstTpCd();

			if ("EA".equals(genExpnRqstTpCd)) {
				genExpnRqstTpCd = "'EA','ET'";
			} else if ("EI".equals(genExpnRqstTpCd)) {
				genExpnRqstTpCd = "'EI'";
			} else {
				genExpnRqstTpCd = "''";
			}

			planningStatusCondVO.setGenExpnRqstTpCd(genExpnRqstTpCd);

			List<PlanningStatusVO> list = command
					.searchExpensePlanningStatus(planningStatusCondVO);

			// USD 금액 , KRW , LCL금액 계산
			if (list == null) {
				eventResponse.setRsVoList(list);
				return eventResponse;
			}

			String currCd = planningStatusCondVO.getCurrCd();

			if ("USD".equals(currCd) || "KRW".equals(currCd)) {

				for (int i = 0; i < list.size(); i++) {

					PlanningStatusVO vo = list.get(i);

					BigDecimal fmLoclKrwXchRt = new BigDecimal(vo
							.getFmLoclKrwXchRt());
					BigDecimal fmUsdLoclXchRt = new BigDecimal(vo
							.getFmUsdLoclXchRt());
					BigDecimal fmUtVal = new BigDecimal(vo.getFmUtVal());

					// Rqst Amt
					BigDecimal fmRqAmt = new BigDecimal(vo.getFmRqAmt());
					if (fmRqAmt.intValue() != 0) {
						if ("USD".equals(currCd)) {
							fmRqAmt = GemUtil.getLclToUsdAmt(fmRqAmt, fmUtVal,
									fmUsdLoclXchRt);
						} else if ("KRW".equals(currCd)) {
							fmRqAmt = GemUtil.getLclToKrwAmt(fmRqAmt, fmUtVal,
									fmLoclKrwXchRt, fmUsdLoclXchRt);
						}
						vo.setFmRqAmt(fmRqAmt.toPlainString());
					}

					// AD Amt
					BigDecimal fmAdAmt = new BigDecimal(vo.getFmAdAmt());
					if (fmAdAmt.intValue() != 0) {
						if ("USD".equals(currCd)) {
							fmAdAmt = GemUtil.getLclToUsdAmt(fmAdAmt, fmUtVal,
									fmUsdLoclXchRt);
						} else if ("KRW".equals(currCd)) {
							fmAdAmt = GemUtil.getLclToKrwAmt(fmAdAmt, fmUtVal,
									fmLoclKrwXchRt, fmUsdLoclXchRt);
						}
						vo.setFmAdAmt(fmAdAmt.toPlainString());
					}

					if ("ET".equals(vo.getGenExpnRqstTpCd())) {

						BigDecimal toLoclKrwXchRt = new BigDecimal(vo
								.getToLoclKrwXchRt());
						BigDecimal toUsdLoclXchRt = new BigDecimal(vo
								.getToUsdLoclXchRt());
						BigDecimal toUtVal = new BigDecimal(vo.getToUtVal());
						// RQ
						BigDecimal toRqAmt = new BigDecimal(vo.getToRqAmt());
						if (toRqAmt.intValue() != 0) {
							if ("USD".equals(currCd)) {
								toRqAmt = GemUtil.getLclToUsdAmt(toRqAmt,
										toUtVal, toUsdLoclXchRt);
							} else if ("KRW".equals(currCd)) {
								toRqAmt = GemUtil
										.getLclToKrwAmt(toRqAmt, toUtVal,
												toLoclKrwXchRt, toUsdLoclXchRt);
							}
							vo.setToRqAmt(toRqAmt.toPlainString());
						}

						BigDecimal toAdAmt = new BigDecimal(vo.getToAdAmt());
						if (toAdAmt.intValue() != 0) {
							if ("USD".equals(currCd)) {
								toAdAmt = GemUtil.getLclToUsdAmt(toAdAmt,
										toUtVal, toUsdLoclXchRt);
							} else if ("KRW".equals(currCd)) {
								toAdAmt = GemUtil
										.getLclToKrwAmt(toAdAmt, toUtVal,
												toLoclKrwXchRt, toUsdLoclXchRt);
							}
							vo.setToAdAmt(toAdAmt.toPlainString());
						}

					}

					if (vo.getFmGenExpnCd() != null
							&& !vo.getFmGenExpnCd().equals("")) {
						// CUR변경 표시
						vo.setFmLoclCurrCd(currCd);
						if ("USD".equals(currCd)) {
							vo.setFmUtVal("1");
						} else if ("KRW".equals(currCd)) {
							vo.setFmUtVal("1000");
						}
					}

					if (vo.getToGenExpnCd() != null
							&& !vo.getToGenExpnCd().equals("")) {
						// CUR변경 표시
						vo.setToLoclCurrCd(currCd);
						if ("USD".equals(currCd)) {
							vo.setToUtVal("1");
						} else if ("KRW".equals(currCd)) {
							vo.setToUtVal("1000");
						}
					}
				}

			}

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999")
					.getMessage(), ex);
		}
		return eventResponse;
	}		
	
	
	
    /**
     * 집행단위, 지역그룹|BU CTRL , 비용주관팀 , 사무국 에서 등록한 비용계획을 조회 
     * Adjustment , Approval 상세화면
     * @author J.Y.O
     * @category CPS_GEM_0001_03
     * @category searchExpensePlanning3
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExpensePlanning03(Event e)
			throws EventException {
		// 반환 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 이벤트 생성
			CpsGem000103Event event = (CpsGem000103Event) e;

			PlanningStatusVO statusVO = event.getPlanningStatusVO();

			// EI , EA , ET
			String genExpnRqstTpCd = statusVO.getGenExpnRqstTpCd();

			// 1. request
			String genExpnRqstNo = event.getGenExpnRqstNo();
			GemRequestVO gemRequestVO = command
					.searchExpenseRequest(genExpnRqstNo);
			// 예산 년도
			String plnYrmon = gemRequestVO.getPlnYrmon();

			eventResponse.setRsVo(gemRequestVO);

			// 2. fm_item
			{
				GemItemVO gemItemVO = new GemItemVO();
				gemItemVO.setGenExpnRqstNo(statusVO.getGenExpnRqstNo());
				gemItemVO.setOfcCd(statusVO.getFmOfcCd());
				gemItemVO.setGenExpnCd(statusVO.getFmGenExpnCd());
				gemItemVO.setGenExpnItmNo(statusVO.getFmGenExpnItmNo());
				gemItemVO.setGenExpnTrnsDivCd("F");
				gemItemVO.setGenExpnRqstSeq(statusVO.getGenExpnRqstSeq());

				List<GemItemVO> gemItemList = command
						.searchExpenseItem(gemItemVO);
				eventResponse.setRsVoList(gemItemList);
			}

			// 2. to_item
			if ("ET".equals(genExpnRqstTpCd)) {
				GemItemVO gemItemVO = new GemItemVO();
				gemItemVO.setGenExpnRqstNo(statusVO.getGenExpnRqstNo());
				gemItemVO.setOfcCd(statusVO.getToOfcCd());
				gemItemVO.setGenExpnCd(statusVO.getToGenExpnCd());
				gemItemVO.setGenExpnItmNo(statusVO.getToGenExpnItmNo());
				gemItemVO.setGenExpnTrnsDivCd("T");
				gemItemVO.setGenExpnRqstSeq(statusVO.getGenExpnRqstSeq());
				List<GemItemVO> gemItemList = command
						.searchExpenseItem(gemItemVO);
				eventResponse.setRsVoList(gemItemList);
			}

			// 3. fm_aproStep
			{
				GemApprovalStepVO gemApprovalStepVO = new GemApprovalStepVO();
				gemApprovalStepVO.setGenExpnRqstNo(statusVO.getGenExpnRqstNo());
				gemApprovalStepVO.setOfcCd(statusVO.getFmOfcCd());
				gemApprovalStepVO.setGenExpnCd(statusVO.getFmGenExpnCd());
				gemApprovalStepVO.setGenExpnItmNo(statusVO.getFmGenExpnItmNo());
				gemApprovalStepVO.setGenExpnTrnsDivCd("F");
				gemApprovalStepVO.setGenExpnRqstSeq(statusVO
						.getGenExpnRqstSeq());
				List<GemApprovalStepVO> gemApprovalStepVOList = command
						.searchExpenseAproStep(gemApprovalStepVO);
				eventResponse.setRsVoList(gemApprovalStepVOList);
			}

			// 4. to_aproStep
			if ("ET".equals(genExpnRqstTpCd)) {
				GemApprovalStepVO gemApprovalStepVO = new GemApprovalStepVO();
				gemApprovalStepVO.setGenExpnRqstNo(statusVO.getGenExpnRqstNo());
				gemApprovalStepVO.setOfcCd(statusVO.getToOfcCd());
				gemApprovalStepVO.setGenExpnCd(statusVO.getToGenExpnCd());
				gemApprovalStepVO.setGenExpnItmNo(statusVO.getToGenExpnItmNo());
				gemApprovalStepVO.setGenExpnTrnsDivCd("T");
				gemApprovalStepVO.setGenExpnRqstSeq(statusVO
						.getGenExpnRqstSeq());
				List<GemApprovalStepVO> gemApprovalStepVOList = command
						.searchExpenseAproStep(gemApprovalStepVO);
				eventResponse.setRsVoList(gemApprovalStepVOList);
			}

			// 5.fm_ofc level
			SearchOfficeCurrencyVO fmOfficeCurrencyVO = command
					.searchOfficeCurrency(statusVO.getFmOfcCd(), plnYrmon);
			eventResponse.setRsVo(fmOfficeCurrencyVO);

			// 6.to_ofc level
			if ("ET".equals(genExpnRqstTpCd)) {
				SearchOfficeCurrencyVO toOfficeCurrencyVO = command
						.searchOfficeCurrency(statusVO.getToOfcCd(), plnYrmon);
				eventResponse.setRsVo(toOfficeCurrencyVO);
			}

			// 7.fm_expense info
			{
				GemExpenseVO gemExpenseVO = command.searchRqstExpense(statusVO
						.getFmOfcCd(), statusVO.getFmGenExpnCd(), "", "");
				eventResponse.setRsVo(gemExpenseVO);
			}

			// 8.to_expense info
			if ("ET".equals(genExpnRqstTpCd)) {
				GemExpenseVO gemExpenseVO = command.searchRqstExpense(statusVO
						.getToOfcCd(), statusVO.getToGenExpnCd(), "", "");
				eventResponse.setRsVo(gemExpenseVO);
			}

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999")
					.getMessage(), ex);
		}
		return eventResponse;
	}		
	
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0003] Approval of Requested expense
	// ---------------------------------------------------------------------------
	

	// ---------------------------------------------------------------------------
	// [CPS_GEM_0002] Processing Status
	// ---------------------------------------------------------------------------
    /**
     * Processing Status 계획비용 요청에 대한 현황을 조회한다 .<br>
     * 
     * @author J.Y.O
     * @category CPS_GEM_0002
     * @category searchExpensePlanningStatus02
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExpensePlanningStatus02(Event e)
			throws EventException {
		// 반환 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 이벤트 생성
			CpsGem0002Event event = (CpsGem0002Event) e;

			PlanningStatusCondVO planningStatusCondVO = event
					.getPlanningStatusCondVO();

			// 계획년도 입력
			String plnYrmon = planningStatusCondVO.getPlnYrmon();
			if (plnYrmon.length() > 4) {
				plnYrmon = plnYrmon.substring(0, 4);
				planningStatusCondVO.setPlnYrmon(plnYrmon);
			}
			// 사용자 오피스
			String usrOfcCd = command.searchUserOfficeCd(account.getOfc_cd());
			planningStatusCondVO.setUserOfcCd(usrOfcCd);

			// 오피스
			String ofcExpnDiv = planningStatusCondVO.getOfcExpnDiv();
			String ofcExpnCd = planningStatusCondVO.getOfcExpnCd();

			if ("O".equals(ofcExpnDiv)) {
				planningStatusCondVO.setFmGenExpnCd("");
				planningStatusCondVO.setFmOfcCd(ofcExpnCd);
			} else {
				planningStatusCondVO.setFmGenExpnCd(ofcExpnCd);
				planningStatusCondVO.setFmOfcCd("");
			}

			String genExpnRqstTpCd = planningStatusCondVO.getGenExpnRqstTpCd();

			if ("EA".equals(genExpnRqstTpCd)) {
				genExpnRqstTpCd = "'EA','ET'";
			} else if ("EI".equals(genExpnRqstTpCd)) {
				genExpnRqstTpCd = "'EI'";
			} else {
				genExpnRqstTpCd = "''";
			}

			planningStatusCondVO.setGenExpnRqstTpCd(genExpnRqstTpCd);

			List<SearchProcessingStatusVO> list = command
					.searchProcessingStatus(planningStatusCondVO);

			// USD 금액 , KRW , LCL금액 계산
			if (list == null) {
				eventResponse.setRsVoList(list);
				return eventResponse;
			}

			String currCd = planningStatusCondVO.getCurrCd();

			if ("USD".equals(currCd) || "KRW".equals(currCd)) {

				for (int i = 0; i < list.size(); i++) {

					SearchProcessingStatusVO vo = list.get(i);

					BigDecimal fmLoclKrwXchRt = new BigDecimal(vo
							.getFmLoclKrwXchRt());
					BigDecimal fmUsdLoclXchRt = new BigDecimal(vo
							.getFmUsdLoclXchRt());
					BigDecimal fmUtVal = new BigDecimal(vo.getFmUtVal());

					// Rqst Amt
					BigDecimal fmRqAmt = new BigDecimal(vo.getFmRqAmt());
					if (fmRqAmt.intValue() != 0) {
						if ("USD".equals(currCd)) {
							fmRqAmt = GemUtil.getLclToUsdAmt(fmRqAmt, fmUtVal,
									fmUsdLoclXchRt);
						} else if ("KRW".equals(currCd)) {
							fmRqAmt = GemUtil.getLclToKrwAmt(fmRqAmt, fmUtVal,
									fmLoclKrwXchRt, fmUsdLoclXchRt);
						}
						vo.setFmRqAmt(fmRqAmt.toPlainString());
					}

					// AD Amt
					BigDecimal fmAdAmt = new BigDecimal(vo.getFmAdAmt());
					if (fmAdAmt.intValue() != 0) {
						if ("USD".equals(currCd)) {
							fmAdAmt = GemUtil.getLclToUsdAmt(fmAdAmt, fmUtVal,
									fmUsdLoclXchRt);
						} else if ("KRW".equals(currCd)) {
							fmAdAmt = GemUtil.getLclToKrwAmt(fmAdAmt, fmUtVal,
									fmLoclKrwXchRt, fmUsdLoclXchRt);
						}
						vo.setFmAdAmt(fmAdAmt.toPlainString());
					}

					// CUR변경 표시
					vo.setFmLoclCurrCd(currCd);

					if ("ET".equals(vo.getGenExpnRqstTpCd())) {

						BigDecimal toLoclKrwXchRt = new BigDecimal(vo
								.getToLoclKrwXchRt());
						BigDecimal toUsdLoclXchRt = new BigDecimal(vo
								.getToUsdLoclXchRt());
						BigDecimal toUtVal = new BigDecimal(vo.getToUtVal());
						// RQ
						BigDecimal toRqAmt = new BigDecimal(vo.getToRqAmt());
						if (toRqAmt.intValue() != 0) {
							if ("USD".equals(currCd)) {
								toRqAmt = GemUtil.getLclToUsdAmt(toRqAmt,
										toUtVal, toUsdLoclXchRt);
							} else if ("KRW".equals(currCd)) {
								toRqAmt = GemUtil
										.getLclToKrwAmt(toRqAmt, toUtVal,
												toLoclKrwXchRt, toUsdLoclXchRt);
							}
							vo.setToRqAmt(toRqAmt.toPlainString());
						}

						BigDecimal toAdAmt = new BigDecimal(vo.getToAdAmt());
						if (toAdAmt.intValue() != 0) {
							if ("USD".equals(currCd)) {
								toAdAmt = GemUtil.getLclToUsdAmt(toAdAmt,
										toUtVal, toUsdLoclXchRt);
							} else if ("KRW".equals(currCd)) {
								toAdAmt = GemUtil
										.getLclToKrwAmt(toAdAmt, toUtVal,
												toLoclKrwXchRt, toUsdLoclXchRt);
							}
							vo.setToAdAmt(toAdAmt.toPlainString());
						}
						// CUR변경 표시
						vo.setToLoclCurrCd(currCd);
					}

					if (vo.getFmGenExpnCd() != null
							&& !vo.getFmGenExpnCd().equals("")) {
						// CUR변경 표시
						vo.setFmLoclCurrCd(currCd);
						if ("USD".equals(currCd)) {
							vo.setFmUtVal("1");
						} else if ("KRW".equals(currCd)) {
							vo.setFmUtVal("1000");
						}
					}

					if (vo.getToGenExpnCd() != null
							&& !vo.getToGenExpnCd().equals("")) {
						// CUR변경 표시
						vo.setToLoclCurrCd(currCd);
						if ("USD".equals(currCd)) {
							vo.setToUtVal("1");
						} else if ("KRW".equals(currCd)) {
							vo.setToUtVal("1000");
						}
					}

				}

			}

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999")
					.getMessage(), ex);
		}
		return eventResponse;
	}			
	
    /**
     * 각Step별 RQ , AP , AD 정보 취득 .<br>
     * 
     * @author J.Y.O
     * @category CPS_GEM_0002
     * @category searchExpenseStatus
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExpenseStatus(Event e) throws EventException {

		// 반환 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 이벤트 생성
			CpsGem0002Event event = (CpsGem0002Event) e;

			GemApprovalStepVO paramVO = new GemApprovalStepVO();
			SearchProcessingStatusVO vo = event.getSearchProcessingStatusVO();
			paramVO.setGenExpnRqstNo(vo.getGenExpnRqstNo());

			if (vo.getFmOfcCd() == null || vo.getFmOfcCd().equals("")) {
				paramVO.setGenExpnTrnsDivCd("T");
				paramVO.setOfcCd(vo.getToOfcCd());
				paramVO.setGenExpnCd(vo.getToGenExpnCd());
				paramVO.setGenExpnItmNo(vo.getToGenExpnItmNo());
			} else {
				paramVO.setGenExpnTrnsDivCd("F");
				paramVO.setOfcCd(vo.getFmOfcCd());
				paramVO.setGenExpnCd(vo.getFmGenExpnCd());
				paramVO.setGenExpnItmNo(vo.getFmGenExpnItmNo());
			}

			paramVO.setGenExpnRqstSeq(vo.getGenExpnRqstSeq());

			paramVO.setGenExpnAproStepCd("RQ");
			List<GemApprovalStepVO> rqStepVO = command
					.searchExpenseAproStep(paramVO);
			if (rqStepVO != null && !rqStepVO.isEmpty()) {
				String status = rqStepVO.get(0).getGenExpnApstsCd();
				eventResponse.setETCData("RQ", status);
			} else {
				eventResponse.setETCData("RQ", "");
			}

			paramVO.setGenExpnAproStepCd("HQ");
			List<GemApprovalStepVO> hqStepVO = command
					.searchExpenseAproStep(paramVO);
			if (hqStepVO != null && !hqStepVO.isEmpty()) {
				String status = hqStepVO.get(0).getGenExpnApstsCd();
				eventResponse.setETCData("HQ", status);
			} else {
				eventResponse.setETCData("HQ", "");
			}

			paramVO.setGenExpnAproStepCd("TC");
			List<GemApprovalStepVO> tcStepVO = command
					.searchExpenseAproStep(paramVO);
			if (tcStepVO != null && !tcStepVO.isEmpty()) {
				String status = tcStepVO.get(0).getGenExpnApstsCd();
				eventResponse.setETCData("TC", status);
			} else {
				eventResponse.setETCData("TC", "");
			}

			paramVO.setGenExpnAproStepCd("CO");
			List<GemApprovalStepVO> coStepVO = command
					.searchExpenseAproStep(paramVO);
			if (coStepVO != null && !coStepVO.isEmpty()) {
				String status = coStepVO.get(0).getGenExpnApstsCd();
				eventResponse.setETCData("CO", status);
			} else {
				eventResponse.setETCData("CO", "");
			}

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999")
					.getMessage(), ex);
		}
		return eventResponse;
	}				
	
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0023] Request / Initial _ Print
	// ---------------------------------------------------------------------------
    /**
     * Expense Request 중 Initial 인쇄 화면.<br>
     * 
     * @author J.Y.O
     * @category CPS_GEM_0023
     * @category report0023S1
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse report0023S1(Event e) throws EventException {

		// 반환 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 이벤트 생성
			CpsGem0023Event event = (CpsGem0023Event) e;

			// ===================================================================
			// Text file 형태
			// ===================================================================
			// EINYCNA200309260001 -- 주쿼리(subpage 사용에서는 반듯이 필요 동일한값이라도 상관없음)
			// expense gorup1st|&&|expnese code|&&|item no.|&&|1000|&&| --
			// subpage1
			// expense gorup1st|&&|expnese code|&&|item no.|&&|2000|&&|
			// expense gorup1st|&&|expnese code|&&|item no.|&&|3000|&&|
			// expense gorup1st|&&|expnese code|&&|item no.|&&|4000|&&|
			// //EOR//
			// -- subpage2 데이타가 없음
			// //EOR//
			// -- subpage3 데이타가 없음
			// //EOR//
			// -- subpage4 데이타가 없음
			// //EOR//
			// -- subpage5 데이타가 없음
			// //EOR//
			//
			// EINYCNA200309260001 -- 주쿼리(subpage 사용에서는 반듯이 필요 동일한값이라도 상관없음)
			// -- subpage1 데이타가 없음
			// //EOR//
			// RQST NO|&&|RQST_OFC|&&|30000|&&| -- subpage2
			// //EOR//
			// Expense gorupcd1|&&|Expense
			// gorupcd2|&&|123456|&&|코드명|&&|001|&&|아이템명|&&|tic|&&|calculation
			// basis|&&|request option|&&| -- subpage3
			// //EOR//
			// 1000|&&|2000|&&|0.988|&&|KOR|&&|1000|&&| -- subpage4
			// //EOR//
			// 01|&&|2000|&&|300|&&|400|&&|1000|&&|1000|&&| -- subpage5
			// 02|&&|2010|&&|300|&&|400|&&|1000|&&|1000|&&|
			// 03|&&|2030|&&|300|&&|400|&&|1000|&&|1000|&&|
			// 04|&&|2050|&&|300|&&|400|&&|1000|&&|1000|&&|
			// 05|&&|2070|&&|300|&&|400|&&|1000|&&|1000|&&|
			// 06|&&|2090|&&|300|&&|400|&&|1000|&&|1000|&&|
			// 07|&&|2110|&&|300|&&|400|&&|1000|&&|1000|&&|
			// 08|&&|2130|&&|300|&&|400|&&|1000|&&|1000|&&|
			// 09|&&|2150|&&|300|&&|400|&&|1000|&&|1000|&&|
			// 10|&&|2170|&&|300|&&|400|&&|1000|&&|1000|&&|
			// 11|&&|2190|&&|300|&&|400|&&|1000|&&|1000|&&|
			// 12|&&|2210|&&|300|&&|400|&&|1000|&&|1000|&&|
			// //EOR//
			// ===================================================================
			// subpage 1 통계정보
			// subpage 2 RqstNo , issued Office
			// subpage 3 Description
			// subpage 4 Calculation
			// subpage 5 Calculation List
			String plnYr = event.getPlnYrmon();

			if (plnYr != null && plnYr.length() > 4) {
				plnYr = plnYr.substring(0, 4);
			}

			List<Report0023R1VO> list = command.report0023R1(event
					.getGenExpnRqstNo(), event.getGenExpnRqstSeq(), event
					.getLangDiv(), plnYr);

			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);

			// 통계정보 페이지
			for (int i = 0; i < list.size(); i++) {
				Report0023R1VO vo = list.get(i);
				BigDecimal usdLoclXchRt = new BigDecimal(vo.getUsdLoclXchRt());
				BigDecimal utVal = new BigDecimal(vo.getRqstUtVal());
				// USD 금액 Rqst Amt
				BigDecimal rqAmt = new BigDecimal(vo.getSumAmt());
				if (rqAmt.intValue() != 0) {
					rqAmt = GemUtil.getLclToUsdAmt(rqAmt, utVal, usdLoclXchRt);
				}

				if (i == 0) {
					pw.println(vo.getGenExpnRqstNo()); // 주쿼리
				}
				pw.print(vo.getGemExpnGrpCd1() + SP); // subpage1
				pw.print(vo.getExpnGrpAbbrNm1() + SP);
				pw.print(vo.getGenExpnCd() + SP);
				pw.print(vo.getGenExpnItmNo() + SP);
				pw.println(rqAmt.toPlainString() + SP);
			}
			pw.println(EOR); // subpage1
			pw.println(EOR); // subpage2
			pw.println(EOR); // subpage3
			pw.println(EOR); // subpage4
			pw.println(EOR); // subpage5

			// 서브 정보 페이지
			for (int i = 0; i < list.size(); i++) {
				Report0023R1VO vo = list.get(i);
				BigDecimal usdLoclXchRt = new BigDecimal(vo.getUsdLoclXchRt());
				BigDecimal utVal = new BigDecimal(vo.getRqstUtVal());
				// USD 금액 Rqst Amt
				BigDecimal usdAmt = new BigDecimal(vo.getSumAmt());
				if (usdAmt.intValue() != 0) {
					usdAmt = GemUtil
							.getLclToUsdAmt(usdAmt, utVal, usdLoclXchRt);
				}
				vo.setUsdAmt(usdAmt.toPlainString());

				pw.println(vo.getGenExpnRqstNo()); // 주쿼리
				pw.println(EOR);// subpage1

				pw.print(vo.getGenExpnRqstNo() + SP);
				pw.print(vo.getOfcCd() + SP);
				pw.println(vo.getSumAmt() + SP);
				pw.println(EOR);// subpage2

				pw.print(vo.getExpnGrpAbbrNm1() + SP);
				pw.print(vo.getExpnGrpAbbrNm2() + SP);
				pw.print(vo.getGenExpnCd() + SP);
				pw.print(vo.getExpnAbbrNm() + SP);
				pw.print(vo.getGenExpnItmNo() + SP);
				pw.print(vo.getGenExpnItmDesc() + SP);
				pw.print(vo.getTicCd() + SP);
				String cal = vo.getGenExpnCalcBssDesc();
				if (cal != null) {
					cal = cal.replaceAll("\r\n", "crlf");
				} else {
					cal = "";
				}

				pw.print(cal + SP);

				String opin = vo.getRqstOpinRmk();
				if (opin != null) {
					opin = opin.replaceAll("\r\n", "crlf");
				} else {
					opin = "";
				}
				pw.print(opin + SP);

				// assigned
				List<String> asList = new ArrayList<String>();
				asList.add(0, vo.getAsgJanAmt());
				asList.add(1, vo.getAsgFebAmt());
				asList.add(2, vo.getAsgMarAmt());
				asList.add(3, vo.getAsgAprAmt());
				asList.add(4, vo.getAsgMayAmt());
				asList.add(5, vo.getAsgJunAmt());
				asList.add(6, vo.getAsgJulAmt());
				asList.add(7, vo.getAsgAugAmt());
				asList.add(8, vo.getAsgSepAmt());
				asList.add(9, vo.getAsgOctAmt());
				asList.add(10, vo.getAsgNovAmt());
				asList.add(11, vo.getAsgDecAmt());
				int asTotal = 0;
				for (int j = 0; j < asList.size(); j++) {
					asTotal += Integer.parseInt(asList.get(j));
				}

				if (asTotal > 0) {
					pw.println("1" + SP);
				} else {
					pw.println("0" + SP);
				}

				pw.println(EOR);// subpage3

				// LCL_AMT,NUMERIC,64
				// USD_AMT,NUMERIC,64
				// USD_LOCL_XCH_RT,FLOAT,64
				// LOCL_CURR_CD,CHAR,64
				// RQST_UT_VAL,NUMERIC,64
				pw.print(vo.getSumAmt() + SP);
				pw.print(vo.getUsdAmt() + SP);
				pw.print(vo.getUsdLoclXchRt() + SP);
				pw.print(vo.getLoclCurrCd() + SP);
				pw.println(vo.getRqstUtVal() + SP);
				pw.println(EOR);// subpage4
				// =========================================
				// subpage5 ===============================
				// =========================================
				GemApprovalStepVO paramVO = new GemApprovalStepVO();

				paramVO.setGenExpnRqstNo(vo.getGenExpnRqstNo());
				paramVO.setOfcCd(vo.getOfcCd());
				paramVO.setGenExpnCd(vo.getGenExpnCd());
				paramVO.setGenExpnItmNo(vo.getGenExpnItmNo());
				paramVO.setGenExpnTrnsDivCd(vo.getGenExpnTrnsDivCd());
				paramVO.setGenExpnRqstSeq(vo.getGenExpnRqstSeq());
				paramVO.setGenExpnAproStepCd("RQ");
				List<GemApprovalStepVO> rqStepVO = command
						.searchExpenseAproStep(paramVO);
				List<String> rqList = getMonthMap(rqStepVO);

				paramVO.setGenExpnAproStepCd("HQ");
				List<GemApprovalStepVO> hqStepVO = command
						.searchExpenseAproStep(paramVO);
				List<String> hqList = getMonthMap(hqStepVO);

				paramVO.setGenExpnAproStepCd("TC");
				List<GemApprovalStepVO> tcStepVO = command
						.searchExpenseAproStep(paramVO);
				List<String> tcList = getMonthMap(tcStepVO);

				paramVO.setGenExpnAproStepCd("CO");
				List<GemApprovalStepVO> coStepVO = command
						.searchExpenseAproStep(paramVO);
				List<String> coList = getMonthMap(coStepVO);

				for (int j = 0; j < 12; j++) {
					pw.print(GemUtil.getEngMonthName((j + 1) + "") + SP);
					pw.print(asList.get(j) + SP);
					pw.print(rqList.get(j) + SP);
					pw.print(hqList.get(j) + SP);
					pw.print(tcList.get(j) + SP);
					pw.println(coList.get(j) + SP);
				}
				pw.println(EOR);// subpage5
			}

			eventResponse.setCustomData("RD", sw.toString());
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999")
					.getMessage(), ex);
		}
		return eventResponse;
	}			
	
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0024] Request / Transfer _ Print
	// ---------------------------------------------------------------------------
    /**
     * Expense Request 중 Transfer 인쇄 화면.<br>
     * 
     * @author J.Y.O
     * @category CPS_GEM_0024
     * @category report0024S1
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse report0024S1(Event e) throws EventException {

		// 반환 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 이벤트 생성
			CpsGem0023Event event = (CpsGem0023Event) e;

			String plnYr = event.getPlnYrmon();

			if (plnYr != null && plnYr.length() > 4) {
				plnYr = plnYr.substring(0, 4);
			}

			List<Report0025R1VO> list = command.report0025R1(event
					.getGenExpnRqstNo(), "", event.getLangDiv());

			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);

			// 통계정보 페이지 첫페이지
			for (int i = 0; i < list.size(); i++) {
				Report0025R1VO vo = list.get(i);

				if (i == 0) {
					pw.println(vo.getGenExpnRqstNo()); // 주쿼리
				}

				// FM ------------------
				BigDecimal fmUsdLoclXchRt = new BigDecimal(vo
						.getFmUsdLoclXchRt());
				BigDecimal fmUtVal = new BigDecimal(vo.getFmUtVal());

				// USD 금액 Rqst Amt
				BigDecimal fmUsdAmt = new BigDecimal(vo.getFmRqAmt());
				if (fmUsdAmt.intValue() != 0) {
					fmUsdAmt = GemUtil.getLclToUsdAmt(fmUsdAmt.abs(), fmUtVal,
							fmUsdLoclXchRt);
				}

				vo.setFmUsdAmt(fmUsdAmt.toPlainString());

				// TO ------------------
				BigDecimal toUsdLoclXchRt = new BigDecimal(vo
						.getToUsdLoclXchRt());
				BigDecimal toUtVal = new BigDecimal(vo.getToUtVal());

				// USD 금액 Rqst Amt
				BigDecimal toUsdAmt = new BigDecimal(vo.getToRqAmt());
				if (toUsdAmt.intValue() != 0) {
					toUsdAmt = GemUtil.getLclToUsdAmt(toUsdAmt.abs(), toUtVal,
							toUsdLoclXchRt);
				}

				vo.setToUsdAmt(toUsdAmt.toPlainString());

				// FM_EXPN_GRP_ABBR_NM,CHAR,64
				// TO_EXPN_GRP_ABBR_NM,CHAR,64
				// FM_GEN_EXPN_CD,CHAR,64
				// TO_GEN_EXPN_CD,CHAR,64
				// FM_GEN_EXPN_ITM_NO,CHAR,64
				// TO_GEN_EXPN_ITM_NO,CHAR,64
				// FM_SUM_AMT,NUMERIC,64
				// TO_SUM_AMT,NUMERIC,64
				pw.print(vo.getGemExpnGrpCd1() + SP); // subpage1
				pw.print(vo.getFmExpnGrpAbbrNm1() + SP);
				pw.print(vo.getToExpnGrpAbbrNm1() + SP);
				pw.print(vo.getFmGenExpnCd() + SP);
				pw.print(vo.getToGenExpnCd() + SP);
				pw.print(vo.getFmGenExpnItemNo() + SP);
				pw.print(vo.getToGenExpnItemNo() + SP);

				pw.print(vo.getFmUsdAmt() + SP);
				pw.println(vo.getToUsdAmt() + SP);
			}

			pw.println(EOR); // subpage1
			pw.println(EOR); // subpage2
			pw.println(EOR); // subpage3
			pw.println(EOR); // subpage4
			pw.println(EOR); // subpage5
			pw.println(EOR); // subpage6

			// 서브 정보 페이지
			for (int i = 0; i < list.size(); i++) {
				Report0025R1VO vo = list.get(i);

				pw.println(vo.getGenExpnRqstNo()); // 주쿼리
				pw.println(EOR);// subpage1

				// GEN_EXPN_RQST_NO,CHAR,64
				// FM_RQST_OFC_CD,CHAR,64
				// TO_RQST_OFC_CD,CHAR,64
				// TTL,NUMERIC,64

				pw.print(vo.getGenExpnRqstNo() + SP);
				pw.print(vo.getFmOfcCd() + SP);
				pw.print(vo.getToOfcCd() + SP);
				pw.println(vo.getFmRqAmt() + SP);
				pw.println(EOR);// subpage2

				// FM_EXPN_GROUP_CD1,CHAR,64
				// TO_EXPN_GROUP_CD1,CHAR,64
				// FM_EXPN_GROUP_CD2,CHAR,64
				// TO_EXPN_GROUP_CD2,CHAR,64
				// FM_GEN_EXPN_CD,CHAR,64
				// TO_GEN_EXPN_CD,CHAR,64
				// FM_EXPN_ABBR_NM,CHAR,500
				// TO_EXPN_ABBR_NM,CHAR,500
				// FM_GEN_EXPN_ITM_NO,CHAR,64
				// TO_GEN_EXPN_ITM_NO,CHAR,64
				// FM_GEN_EXPN_ITM_DESC,CHAR,500
				// TO_GEN_EXPN_ITM_DESC,CHAR,500
				// FM_TIC_CD,CHAR,64
				// TO_TIC_CD,CHAR,64
				// TO_GEN_EXPN_CALC_BSS_DESC,CHAR,4000
				// TO_RQST_OPIN_RMK,CHAR,4000
				// FM_ASSIGNED,CHAR,64
				// TO_ASSIGNED,CHAR,64
				//			
				pw.print(vo.getFmExpnGrpAbbrNm1() + SP);
				pw.print(vo.getToExpnGrpAbbrNm1() + SP);
				pw.print(vo.getFmExpnGrpAbbrNm2() + SP);
				pw.print(vo.getToExpnGrpAbbrNm2() + SP);
				pw.print(vo.getFmGenExpnCd() + SP);
				pw.print(vo.getToGenExpnCd() + SP);
				pw.print(vo.getFmExpnAbbrNm() + SP);
				pw.print(vo.getToExpnAbbrNm() + SP);
				pw.print(vo.getFmGenExpnItemNo() + SP);
				pw.print(vo.getToGenExpnItemNo() + SP);
				pw.print(vo.getFmGenExpnItmDesc() + SP);
				pw.print(vo.getToGenExpnItmDesc() + SP);
				pw.print(vo.getFmTicCd() + SP);
				pw.print(vo.getToTicCd() + SP);
				String cal = vo.getToGenExpnCalcBssDesc();
				if (cal != null) {
					cal = cal.replaceAll("\r\n", "crlf");
				} else {
					cal = "";
				}

				pw.print(cal + SP);

				String opin = vo.getToRqstOpinRmk();
				if (opin != null) {
					opin = opin.replaceAll("\r\n", "crlf");
				} else {
					opin = "";
				}
				pw.print(opin + SP);

				// assigned
				List<String> fmAsList = new ArrayList<String>();
				fmAsList.add(0, vo.getFmAsgJanAmt());
				fmAsList.add(1, vo.getFmAsgFebAmt());
				fmAsList.add(2, vo.getFmAsgMarAmt());
				fmAsList.add(3, vo.getFmAsgAprAmt());
				fmAsList.add(4, vo.getFmAsgMayAmt());
				fmAsList.add(5, vo.getFmAsgJunAmt());
				fmAsList.add(6, vo.getFmAsgJulAmt());
				fmAsList.add(7, vo.getFmAsgAugAmt());
				fmAsList.add(8, vo.getFmAsgSepAmt());
				fmAsList.add(9, vo.getFmAsgOctAmt());
				fmAsList.add(10, vo.getFmAsgNovAmt());
				fmAsList.add(11, vo.getFmAsgDecAmt());
				int asTotal = 0;
				for (int j = 0; j < fmAsList.size(); j++) {
					asTotal += Integer.parseInt(fmAsList.get(j));
				}

				if (asTotal > 0) {
					pw.print("1" + SP);
				} else {
					pw.print("0" + SP);
				}

				List<String> toAsList = new ArrayList<String>();
				toAsList.add(0, vo.getToAsgJanAmt());
				toAsList.add(1, vo.getToAsgFebAmt());
				toAsList.add(2, vo.getToAsgMarAmt());
				toAsList.add(3, vo.getToAsgAprAmt());
				toAsList.add(4, vo.getToAsgMayAmt());
				toAsList.add(5, vo.getToAsgJunAmt());
				toAsList.add(6, vo.getToAsgJulAmt());
				toAsList.add(7, vo.getToAsgAugAmt());
				toAsList.add(8, vo.getToAsgSepAmt());
				toAsList.add(9, vo.getToAsgOctAmt());
				toAsList.add(10, vo.getToAsgNovAmt());
				toAsList.add(11, vo.getToAsgDecAmt());
				asTotal = 0;
				for (int j = 0; j < toAsList.size(); j++) {
					asTotal += Integer.parseInt(toAsList.get(j));
				}

				if (asTotal > 0) {
					pw.println("1" + SP);
				} else {
					pw.println("0" + SP);
				}

				pw.println(EOR);// subpage3

				// FM_LCL_AMT,NUMERIC,64
				// TO_LCL_AMT,NUMERIC,64
				// USD_AMT,NUMERIC,64
				// USD_LOCL_XCH_RT,FLOAT,64
				// FM_LOCL_CURR_CD,CHAR,64
				// TO_LOCL_CURR_CD,CHAR,64
				// FM_RQST_UT_VAL,NUMERIC,64
				// TO_RQST_UT_VAL,NUMERIC,64

				pw.print(vo.getFmRqAmt() + SP);
				pw.print(vo.getToRqAmt() + SP);
				pw.print(vo.getToUsdAmt() + SP);
				pw.print(vo.getToUsdLoclXchRt() + SP);
				pw.print(vo.getFmLoclCurrCd() + SP);
				pw.print(vo.getToLoclCurrCd() + SP);
				pw.print(vo.getFmUtVal() + SP);
				pw.println(vo.getToUtVal() + SP);
				pw.println(EOR);// subpage4

				// =========================================
				// subpage5 ===============================
				// =========================================
				{

					GemApprovalStepVO paramVO = new GemApprovalStepVO();

					paramVO.setGenExpnRqstNo(vo.getGenExpnRqstNo());
					paramVO.setOfcCd(vo.getFmOfcCd());
					paramVO.setGenExpnCd(vo.getFmGenExpnCd());
					paramVO.setGenExpnItmNo(vo.getFmGenExpnItemNo());
					paramVO.setGenExpnTrnsDivCd("F");
					paramVO.setGenExpnRqstSeq(vo.getGenExpnRqstSeq());
					paramVO.setGenExpnAproStepCd("RQ");
					List<GemApprovalStepVO> rqStepVO = command
							.searchExpenseAproStep(paramVO);
					List<String> rqList = getMonthMap(rqStepVO);

					paramVO.setGenExpnAproStepCd("HQ");
					List<GemApprovalStepVO> hqStepVO = command
							.searchExpenseAproStep(paramVO);
					List<String> hqList = getMonthMap(hqStepVO);

					paramVO.setGenExpnAproStepCd("TC");
					List<GemApprovalStepVO> tcStepVO = command
							.searchExpenseAproStep(paramVO);
					List<String> tcList = getMonthMap(tcStepVO);

					paramVO.setGenExpnAproStepCd("CO");
					List<GemApprovalStepVO> coStepVO = command
							.searchExpenseAproStep(paramVO);
					List<String> coList = getMonthMap(coStepVO);
					// Month,CHAR,64
					// Assigned,NUMERIC,64
					// Request,NUMERIC,64
					// Rhq,NUMERIC,64
					// Tic,NUMERIC,64
					// Com,NUMERIC,64
					// LOCL_CURR_CD,CHAR,64
					// RQST_UT_VAL,NUMERIC,64
					for (int j = 0; j < 12; j++) {
						pw.print(GemUtil.getEngMonthName((j + 1) + "") + SP);
						pw.print(fmAsList.get(j) + SP);
						pw.print(rqList.get(j) + SP);
						pw.print(hqList.get(j) + SP);
						pw.print(tcList.get(j) + SP);
						pw.print(coList.get(j) + SP);
						pw.print(vo.getFmLoclCurrCd() + SP);
						pw.println(vo.getFmUtVal() + SP);
					}

					pw.println(EOR);// subpage5
				}
				// =========================================
				// subpage6 ===============================
				// =========================================
				{
					GemApprovalStepVO paramVO = new GemApprovalStepVO();

					paramVO.setGenExpnRqstNo(vo.getGenExpnRqstNo());
					paramVO.setOfcCd(vo.getToOfcCd());
					paramVO.setGenExpnCd(vo.getToGenExpnCd());
					paramVO.setGenExpnItmNo(vo.getToGenExpnItemNo());
					paramVO.setGenExpnTrnsDivCd("T");
					paramVO.setGenExpnRqstSeq(vo.getGenExpnRqstSeq());
					paramVO.setGenExpnAproStepCd("RQ");
					List<GemApprovalStepVO> rqStepVO = command
							.searchExpenseAproStep(paramVO);
					List<String> rqList = getMonthMap(rqStepVO);

					paramVO.setGenExpnAproStepCd("HQ");
					List<GemApprovalStepVO> hqStepVO = command
							.searchExpenseAproStep(paramVO);
					List<String> hqList = getMonthMap(hqStepVO);

					paramVO.setGenExpnAproStepCd("TC");
					List<GemApprovalStepVO> tcStepVO = command
							.searchExpenseAproStep(paramVO);
					List<String> tcList = getMonthMap(tcStepVO);

					paramVO.setGenExpnAproStepCd("CO");
					List<GemApprovalStepVO> coStepVO = command
							.searchExpenseAproStep(paramVO);
					List<String> coList = getMonthMap(coStepVO);
					// Month,CHAR,64
					// Assigned,NUMERIC,64
					// Request,NUMERIC,64
					// Rhq,NUMERIC,64
					// Tic,NUMERIC,64
					// Com,NUMERIC,64
					// LOCL_CURR_CD,CHAR,64
					// RQST_UT_VAL,NUMERIC,64
					for (int j = 0; j < 12; j++) {
						pw.print(GemUtil.getEngMonthName((j + 1) + "") + SP);
						pw.print(toAsList.get(j) + SP);
						pw.print(rqList.get(j) + SP);
						pw.print(hqList.get(j) + SP);
						pw.print(tcList.get(j) + SP);
						pw.print(coList.get(j) + SP);
						pw.print(vo.getToLoclCurrCd() + SP);
						pw.println(vo.getToUtVal() + SP);
					}
					pw.println(EOR);// subpage6
				}

			}

			eventResponse.setCustomData("RD", sw.toString());
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999")
					.getMessage(), ex);
		}
		return eventResponse;
	}		
	
	
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0025] Adjustment / Initial _ Print
	// ---------------------------------------------------------------------------
    /**
     * Adjustment / Initial _ Print<br>
     * 
     * @author J.Y.O
     * @category CPS_GEM_0025
     * @category report0025S1
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse report0025S1(Event e) throws EventException {
		// 반환 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 이벤트 생성
			CpsGem0023Event event = (CpsGem0023Event) e;

			String plnYr = event.getPlnYrmon();

			if (plnYr != null && plnYr.length() > 4) {
				plnYr = plnYr.substring(0, 4);
			}

			List<Report0025R1VO> list = command.report0025R1(event
					.getGenExpnRqstNo(), event.getGenExpnRqstSeq(), event
					.getLangDiv());

			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);

			// 서브 정보 페이지
			for (int i = 0; i < list.size(); i++) {
				Report0025R1VO vo = list.get(i);
				pw.println(vo.getGenExpnRqstNo()); // 주쿼리

				pw.print(vo.getGenExpnRqstNo() + SP);
				pw.print(vo.getFmOfcCd() + SP);
				pw.println(vo.getFmRqAmt() + SP);
				pw.println(EOR);// subpage1

				pw.print(vo.getFmExpnGrpAbbrNm1() + SP);
				pw.print(vo.getFmExpnGrpAbbrNm2() + SP);
				pw.print(vo.getFmGenExpnCd() + SP);
				pw.print(vo.getFmExpnAbbrNm() + SP);
				pw.print(vo.getFmGenExpnItemNo() + SP);
				pw.print(vo.getFmGenExpnItmDesc() + SP);
				pw.print(vo.getFmTicCd() + SP);
				String cal = vo.getFmGenExpnCalcBssDesc();
				if (cal != null) {
					cal = cal.replaceAll("\r\n", "crlf");
				} else {
					cal = "";
				}

				pw.print(cal + SP);

				String opin = vo.getFmRqstOpinRmk();
				if (opin != null) {
					opin = opin.replaceAll("\r\n", "crlf");
				} else {
					opin = "";
				}
				pw.print(opin + SP);

				// assigned
				List<String> fmAsList = new ArrayList<String>();
				fmAsList.add(0, vo.getFmAsgJanAmt());
				fmAsList.add(1, vo.getFmAsgFebAmt());
				fmAsList.add(2, vo.getFmAsgMarAmt());
				fmAsList.add(3, vo.getFmAsgAprAmt());
				fmAsList.add(4, vo.getFmAsgMayAmt());
				fmAsList.add(5, vo.getFmAsgJunAmt());
				fmAsList.add(6, vo.getFmAsgJulAmt());
				fmAsList.add(7, vo.getFmAsgAugAmt());
				fmAsList.add(8, vo.getFmAsgSepAmt());
				fmAsList.add(9, vo.getFmAsgOctAmt());
				fmAsList.add(10, vo.getFmAsgNovAmt());
				fmAsList.add(11, vo.getFmAsgDecAmt());
				int asTotal = 0;
				for (int j = 0; j < fmAsList.size(); j++) {
					asTotal += Integer.parseInt(fmAsList.get(j));
				}

				if (asTotal > 0) {
					pw.println("1" + SP);
				} else {
					pw.println("0" + SP);
				}

				pw.println(EOR);// subpage2

				// LCL_AMT,NUMERIC,64
				// USD_AMT,NUMERIC,64
				// USD_LOCL_XCH_RT,FLOAT,64
				// LOCL_CURR_CD,CHAR,64
				// RQST_UT_VAL,NUMERIC,64
				// LCL_AMT,NUMERIC,64
				// USD_AMT,NUMERIC,64
				// USD_LOCL_XCH_RT,FLOAT,64
				// LOCL_CURR_CD,CHAR,64
				// RQST_UT_VAL,NUMERIC,64

				BigDecimal fmUsdLoclXchRt = new BigDecimal(vo
						.getFmUsdLoclXchRt());
				BigDecimal fmUtVal = new BigDecimal(vo.getFmUtVal());

				// USD 금액 Rqst Amt
				BigDecimal fmUsdAmt = new BigDecimal(vo.getFmRqAmt());
				if (fmUsdAmt.intValue() != 0) {
					fmUsdAmt = GemUtil.getLclToUsdAmt(fmUsdAmt.abs(), fmUtVal,
							fmUsdLoclXchRt);
				}

				vo.setFmUsdAmt(fmUsdAmt.toPlainString());

				pw.print(vo.getFmRqAmt() + SP);
				pw.print(vo.getFmUsdAmt() + SP);
				pw.print(vo.getFmUsdLoclXchRt() + SP);
				pw.print(vo.getFmLoclCurrCd() + SP);
				pw.print(vo.getFmUtVal() + SP);
				// --------------------------------------------------

				// USD 금액 Rqst Amt
				BigDecimal fmAdUsdAmt = new BigDecimal(vo.getFmAdAmt());
				if (fmAdUsdAmt.intValue() != 0) {
					fmAdUsdAmt = GemUtil.getLclToUsdAmt(fmAdUsdAmt.abs(),
							fmUtVal, fmUsdLoclXchRt);
				}

				vo.setFmAdUsdAmt(fmAdUsdAmt.toPlainString());

				pw.print(vo.getFmAdAmt() + SP);
				pw.print(vo.getFmAdUsdAmt() + SP);
				pw.print(vo.getFmUsdLoclXchRt() + SP);
				pw.print(vo.getFmLoclCurrCd() + SP);
				pw.println(vo.getFmUtVal() + SP);
				pw.println(EOR);// subpage3
				// =========================================
				// subpage5 ===============================
				// =========================================
				GemApprovalStepVO paramVO = new GemApprovalStepVO();

				paramVO.setGenExpnRqstNo(vo.getGenExpnRqstNo());
				paramVO.setOfcCd(vo.getFmOfcCd());
				paramVO.setGenExpnCd(vo.getFmGenExpnCd());
				paramVO.setGenExpnItmNo(vo.getFmGenExpnItemNo());
				paramVO.setGenExpnTrnsDivCd("F");
				paramVO.setGenExpnRqstSeq(vo.getGenExpnRqstSeq());
				paramVO.setGenExpnAproStepCd("RQ");
				List<GemApprovalStepVO> rqStepVO = command
						.searchExpenseAproStep(paramVO);
				List<String> rqList = getMonthMap(rqStepVO);

				paramVO.setGenExpnAproStepCd("HQ");
				List<GemApprovalStepVO> hqStepVO = command
						.searchExpenseAproStep(paramVO);
				List<String> hqList = getMonthMap(hqStepVO);

				paramVO.setGenExpnAproStepCd("TC");
				List<GemApprovalStepVO> tcStepVO = command
						.searchExpenseAproStep(paramVO);
				List<String> tcList = getMonthMap(tcStepVO);

				paramVO.setGenExpnAproStepCd("CO");
				List<GemApprovalStepVO> coStepVO = command
						.searchExpenseAproStep(paramVO);
				List<String> coList = getMonthMap(coStepVO);

				for (int j = 0; j < 12; j++) {
					pw.print(GemUtil.getEngMonthName((j + 1) + "") + SP);
					pw.print(fmAsList.get(j) + SP);
					pw.print(rqList.get(j) + SP);
					pw.print(hqList.get(j) + SP);
					pw.print(tcList.get(j) + SP);
					pw.println(coList.get(j) + SP);
				}
				pw.println(EOR);// subpage4
			}

			eventResponse.setCustomData("RD", sw.toString());
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999")
					.getMessage(), ex);
		}
		return eventResponse;
	}			
	
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0027] Adjustment / Transfer _ Print
	// ---------------------------------------------------------------------------
    /**
     * Adjustment / Transfer _ Print<br>
     * 
     * @author J.Y.O
     * @category CPS_GEM_0027
     * @category report0027S1
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse report0027S1(Event e) throws EventException {
		// 반환 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 이벤트 생성
			CpsGem0023Event event = (CpsGem0023Event) e;

			String plnYr = event.getPlnYrmon();

			if (plnYr != null && plnYr.length() > 4) {
				plnYr = plnYr.substring(0, 4);
			}

			List<Report0025R1VO> list = command.report0025R1(event
					.getGenExpnRqstNo(), event.getGenExpnRqstSeq(), event
					.getLangDiv());

			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);

			// 서브 정보 페이지
			for (int i = 0; i < list.size(); i++) {
				Report0025R1VO vo = list.get(i);

				pw.println(vo.getGenExpnRqstNo()); // 주쿼리

				// GEN_EXPN_RQST_NO,CHAR,64
				// FM_RQST_OFC_CD,CHAR,64
				// TO_RQST_OFC_CD,CHAR,64
				// TTL,NUMERIC,64

				pw.print(vo.getGenExpnRqstNo() + SP);
				pw.print(vo.getFmOfcCd() + SP);
				pw.print(vo.getToOfcCd() + SP);
				pw.println(vo.getFmRqAmt() + SP);
				pw.println(EOR);// subpage1

				// FM_EXPN_GROUP_CD1,CHAR,64
				// TO_EXPN_GROUP_CD1,CHAR,64
				// FM_EXPN_GROUP_CD2,CHAR,64
				// TO_EXPN_GROUP_CD2,CHAR,64
				// FM_GEN_EXPN_CD,CHAR,64
				// TO_GEN_EXPN_CD,CHAR,64
				// FM_EXPN_ABBR_NM,CHAR,500
				// TO_EXPN_ABBR_NM,CHAR,500
				// FM_GEN_EXPN_ITM_NO,CHAR,64
				// TO_GEN_EXPN_ITM_NO,CHAR,64
				// FM_GEN_EXPN_ITM_DESC,CHAR,500
				// TO_GEN_EXPN_ITM_DESC,CHAR,500
				// FM_TIC_CD,CHAR,64
				// TO_TIC_CD,CHAR,64
				// TO_GEN_EXPN_CALC_BSS_DESC,CHAR,4000
				// TO_RQST_OPIN_RMK,CHAR,4000
				// FM_ASSIGNED,CHAR,64
				// TO_ASSIGNED,CHAR,64
				//			
				pw.print(vo.getFmExpnGrpAbbrNm1() + SP);
				pw.print(vo.getToExpnGrpAbbrNm1() + SP);
				pw.print(vo.getFmExpnGrpAbbrNm2() + SP);
				pw.print(vo.getToExpnGrpAbbrNm2() + SP);
				pw.print(vo.getFmGenExpnCd() + SP);
				pw.print(vo.getToGenExpnCd() + SP);
				pw.print(vo.getFmExpnAbbrNm() + SP);
				pw.print(vo.getToExpnAbbrNm() + SP);
				pw.print(vo.getFmGenExpnItemNo() + SP);
				pw.print(vo.getToGenExpnItemNo() + SP);
				pw.print(vo.getFmGenExpnItmDesc() + SP);
				pw.print(vo.getToGenExpnItmDesc() + SP);
				pw.print(vo.getFmTicCd() + SP);
				pw.print(vo.getToTicCd() + SP);
				String cal = vo.getToGenExpnCalcBssDesc();
				if (cal != null) {
					cal = cal.replaceAll("\r\n", "crlf");
				} else {
					cal = "";
				}

				pw.print(cal + SP);

				String opin = vo.getToRqstOpinRmk();
				if (opin != null) {
					opin = opin.replaceAll("\r\n", "crlf");
				} else {
					opin = "";
				}
				pw.print(opin + SP);

				// FM assigned ==========================
				List<String> fmAsList = new ArrayList<String>();
				fmAsList.add(0, vo.getFmAsgJanAmt());
				fmAsList.add(1, vo.getFmAsgFebAmt());
				fmAsList.add(2, vo.getFmAsgMarAmt());
				fmAsList.add(3, vo.getFmAsgAprAmt());
				fmAsList.add(4, vo.getFmAsgMayAmt());
				fmAsList.add(5, vo.getFmAsgJunAmt());
				fmAsList.add(6, vo.getFmAsgJulAmt());
				fmAsList.add(7, vo.getFmAsgAugAmt());
				fmAsList.add(8, vo.getFmAsgSepAmt());
				fmAsList.add(9, vo.getFmAsgOctAmt());
				fmAsList.add(10, vo.getFmAsgNovAmt());
				fmAsList.add(11, vo.getFmAsgDecAmt());

				// TO assigned ==========================
				List<String> toAsList = new ArrayList<String>();
				toAsList.add(0, vo.getToAsgJanAmt());
				toAsList.add(1, vo.getToAsgFebAmt());
				toAsList.add(2, vo.getToAsgMarAmt());
				toAsList.add(3, vo.getToAsgAprAmt());
				toAsList.add(4, vo.getToAsgMayAmt());
				toAsList.add(5, vo.getToAsgJunAmt());
				toAsList.add(6, vo.getToAsgJulAmt());
				toAsList.add(7, vo.getToAsgAugAmt());
				toAsList.add(8, vo.getToAsgSepAmt());
				toAsList.add(9, vo.getToAsgOctAmt());
				toAsList.add(10, vo.getToAsgNovAmt());
				toAsList.add(11, vo.getToAsgDecAmt());
				int fmAssign = 0;
				for (int j = 0; j < fmAsList.size(); j++) {
					fmAssign = Integer.parseInt(fmAsList.get(j));
					if (fmAssign > 0) {
						break;
					}
				}

				if (fmAssign > 0) {
					pw.print("1" + SP);
				} else {
					pw.print("0" + SP);
				}

				int toAssign = 0;
				for (int j = 0; j < toAsList.size(); j++) {
					toAssign = Integer.parseInt(toAsList.get(j));
					if (toAssign > 0) {
						break;
					}
				}

				if (toAssign > 0) {
					pw.println("1" + SP);
				} else {
					pw.println("0" + SP);
				}
				pw.println(EOR);// subpage2

				// FM_LCL_AMT,NUMERIC,64
				// TO_LCL_AMT,NUMERIC,64
				// USD_AMT,NUMERIC,64
				// USD_LOCL_XCH_RT,FLOAT,64
				// FM_LOCL_CURR_CD,CHAR,64
				// TO_LOCL_CURR_CD,CHAR,64
				// FM_RQST_UT_VAL,NUMERIC,64
				// TO_RQST_UT_VAL,NUMERIC,64
				// FM_AD_AMT,NUMERIC,64
				// TO_AD_AMT,NUMERIC,64
				// FM_AD_USD_AMT,NUMERIC,64
				BigDecimal fmUsdLoclXchRt = new BigDecimal(vo
						.getFmUsdLoclXchRt());
				BigDecimal fmUtVal = new BigDecimal(vo.getFmUtVal());

				// USD 금액 Rqst Amt
				BigDecimal fmUsdAmt = new BigDecimal(vo.getFmRqAmt());
				if (fmUsdAmt.intValue() != 0) {
					fmUsdAmt = GemUtil.getLclToUsdAmt(fmUsdAmt.abs(), fmUtVal,
							fmUsdLoclXchRt);
				}
				vo.setFmUsdAmt(fmUsdAmt.toPlainString());

				pw.print(vo.getFmRqAmt() + SP);
				pw.print(vo.getToRqAmt() + SP);
				pw.print(vo.getFmUsdAmt() + SP);
				pw.print(vo.getFmUsdLoclXchRt() + SP);
				pw.print(vo.getFmLoclCurrCd() + SP);
				pw.print(vo.getToLoclCurrCd() + SP);
				pw.print(vo.getFmUtVal() + SP);
				pw.print(vo.getToUtVal() + SP);
				// -------------------------------

				// USD 금액 Rqst Amt
				BigDecimal fmAdUsdAmt = new BigDecimal(vo.getFmAdAmt());
				if (fmAdUsdAmt.intValue() != 0) {
					fmAdUsdAmt = GemUtil.getLclToUsdAmt(fmAdUsdAmt.abs(),
							fmUtVal, fmUsdLoclXchRt);
				}

				vo.setFmAdUsdAmt(fmAdUsdAmt.toPlainString());

				pw.print(vo.getFmAdAmt() + SP);
				pw.print(vo.getToAdAmt() + SP);
				pw.println(vo.getFmAdUsdAmt() + SP);
				pw.println(EOR);// subpage3

				// =========================================
				// subpage5 ===============================
				// =========================================
				{

					GemApprovalStepVO paramVO = new GemApprovalStepVO();

					paramVO.setGenExpnRqstNo(vo.getGenExpnRqstNo());
					paramVO.setOfcCd(vo.getFmOfcCd());
					paramVO.setGenExpnCd(vo.getFmGenExpnCd());
					paramVO.setGenExpnItmNo(vo.getFmGenExpnItemNo());
					paramVO.setGenExpnTrnsDivCd("F");
					paramVO.setGenExpnRqstSeq(vo.getGenExpnRqstSeq());
					paramVO.setGenExpnAproStepCd("RQ");
					List<GemApprovalStepVO> rqStepVO = command
							.searchExpenseAproStep(paramVO);
					List<String> rqList = getMonthMap(rqStepVO);

					paramVO.setGenExpnAproStepCd("HQ");
					List<GemApprovalStepVO> hqStepVO = command
							.searchExpenseAproStep(paramVO);
					List<String> hqList = getMonthMap(hqStepVO);

					paramVO.setGenExpnAproStepCd("TC");
					List<GemApprovalStepVO> tcStepVO = command
							.searchExpenseAproStep(paramVO);
					List<String> tcList = getMonthMap(tcStepVO);

					paramVO.setGenExpnAproStepCd("CO");
					List<GemApprovalStepVO> coStepVO = command
							.searchExpenseAproStep(paramVO);
					List<String> coList = getMonthMap(coStepVO);
					// Month,CHAR,64
					// Assigned,NUMERIC,64
					// Request,NUMERIC,64
					// Rhq,NUMERIC,64
					// Tic,NUMERIC,64
					// Com,NUMERIC,64
					// LOCL_CURR_CD,CHAR,64
					// RQST_UT_VAL,NUMERIC,64
					for (int j = 0; j < 12; j++) {
						pw.print(GemUtil.getEngMonthName((j + 1) + "") + SP);
						pw.print(fmAsList.get(j) + SP);
						pw.print(rqList.get(j) + SP);
						pw.print(hqList.get(j) + SP);
						pw.print(tcList.get(j) + SP);
						pw.print(coList.get(j) + SP);
						pw.print(vo.getFmLoclCurrCd() + SP);
						pw.println(vo.getFmUtVal() + SP);
					}

					pw.println(EOR);// subpage4
				}
				// =========================================
				// subpage5 ===============================
				// =========================================
				{
					GemApprovalStepVO paramVO = new GemApprovalStepVO();

					paramVO.setGenExpnRqstNo(vo.getGenExpnRqstNo());
					paramVO.setOfcCd(vo.getToOfcCd());
					paramVO.setGenExpnCd(vo.getToGenExpnCd());
					paramVO.setGenExpnItmNo(vo.getToGenExpnItemNo());
					paramVO.setGenExpnTrnsDivCd("T");
					paramVO.setGenExpnRqstSeq(vo.getGenExpnRqstSeq());
					paramVO.setGenExpnAproStepCd("RQ");
					List<GemApprovalStepVO> rqStepVO = command
							.searchExpenseAproStep(paramVO);
					List<String> rqList = getMonthMap(rqStepVO);

					paramVO.setGenExpnAproStepCd("HQ");
					List<GemApprovalStepVO> hqStepVO = command
							.searchExpenseAproStep(paramVO);
					List<String> hqList = getMonthMap(hqStepVO);

					paramVO.setGenExpnAproStepCd("TC");
					List<GemApprovalStepVO> tcStepVO = command
							.searchExpenseAproStep(paramVO);
					List<String> tcList = getMonthMap(tcStepVO);

					paramVO.setGenExpnAproStepCd("CO");
					List<GemApprovalStepVO> coStepVO = command
							.searchExpenseAproStep(paramVO);
					List<String> coList = getMonthMap(coStepVO);
					// Month,CHAR,64
					// Assigned,NUMERIC,64
					// Request,NUMERIC,64
					// Rhq,NUMERIC,64
					// Tic,NUMERIC,64
					// Com,NUMERIC,64
					// LOCL_CURR_CD,CHAR,64
					// RQST_UT_VAL,NUMERIC,64
					for (int j = 0; j < 12; j++) {
						pw.print(GemUtil.getEngMonthName((j + 1) + "") + SP);
						pw.print(toAsList.get(j) + SP);
						pw.print(rqList.get(j) + SP);
						pw.print(hqList.get(j) + SP);
						pw.print(tcList.get(j) + SP);
						pw.print(coList.get(j) + SP);
						pw.print(vo.getToLoclCurrCd() + SP);
						pw.println(vo.getToUtVal() + SP);
					}

					pw.println(EOR);// subpage5
				}

			}

			eventResponse.setCustomData("RD", sw.toString());
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999")
					.getMessage(), ex);
		}
		return eventResponse;
	}			
	
	
	/**
	 * 월별 map 생성
	 * @param stepVO
	 * @return
	 */
	private List<String> getMonthMap(List<GemApprovalStepVO> stepVO) {
		List<String> list = new ArrayList<String>();
		if (stepVO != null && !stepVO.isEmpty()) {
			GemApprovalStepVO vo = stepVO.get(0);
			list.add(0  , vo.getJanAmt());
			list.add(1  , vo.getFebAmt());
			list.add(2  , vo.getMarAmt());
			list.add(3  , vo.getAprAmt());
			list.add(4  , vo.getMayAmt());
			list.add(5  , vo.getJunAmt());
			list.add(6  , vo.getJulAmt());
			list.add(7  , vo.getAugAmt());
			list.add(8  , vo.getSepAmt());
			list.add(9  , vo.getOctAmt());
			list.add(10 , vo.getNovAmt());
			list.add(11 , vo.getDecAmt());


		} else {
			list.add(0  , "0");
			list.add(1  , "0");
			list.add(2  , "0");
			list.add(3  , "0");
			list.add(4  , "0");
			list.add(5  , "0");
			list.add(6  , "0");
			list.add(7  , "0");
			list.add(8  , "0");
			list.add(9  , "0");
			list.add(10 , "0");
			list.add(11 , "0");
		}
		return list;
	}
	
	// ===========================================================================
	// C.J.M
	// ===========================================================================
	
	// ---------------------------------------------------------------------------
	// [FNS009-0001] Receive WebLogic JMS Queue Proxy
	// ---------------------------------------------------------------------------
    
	/**
     * FNS009-0001 연동
     * 
     * @author choijungmi
     * @category FNS009-0001
     * @category receiveFns0090001Slip
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	public void receiveFns0090001Slip(Event e) throws EventException {
		log.info("##### GEMPlanningPerformanceSC receiveFns0090001Slip START #####");
		GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();
		
		GemSlpIfVO[] models = ((CpsGemFns0090001Event) e).getGemSlpIfVOs();
		log.info("##### models : "+models);
		
		int insCnt = 0;		
		// 0. List Add
		for (int i = 0; i < models.length; i++) {
			String slpTjNo = models[i].getSlpTjNo();
			String slpSeqNo = models[i].getSlpSeqNo();

			if(!command.searchSlpIfCheck(slpTjNo, slpSeqNo)) {
				// GEM_SLP_IF Table에 Insert
				insCnt += command.createSlip(models[i]);
			}
		}
		log.info("##### insCnt : "+insCnt);
				
		// insCnt > 0 면 GEM_SLP_PERF Table에 Insert를 수행 오류가 나면 RollBack함.
		if(insCnt > 0) {
			for (int i = 0; i < models.length; i++) {				
				String slpTjNo = models[i].getSlpTjNo();
				String slpSeqNo = models[i].getSlpSeqNo();
				
				log.error("##### slpTjNo : "+slpTjNo);
				
				// 0. SLP_TJ_NO, SLP_SEQ_NO가 존재하면
				if(command.searchSlpIfCheck(slpTjNo, slpSeqNo)) {
					// 3. ERP로부터 일반관리비 비용집계 대상 전표 정보 조회
					List<GemSlpIfVO> list = command.searchSlpIf(slpTjNo, slpSeqNo, "");
					
					if(list.size() > 0) {						
						for(int j=0; j<list.size(); j++) {
							GemSlpIfVO gemSlpIfVO = (GemSlpIfVO)list.get(j);
							
							try {
								begin();
								// GEM_SLP_IF 테이블에 Insert 성공이면
								command.createSlipClosing(gemSlpIfVO);
								
								commit();
							} catch(EventException ex){
								log.error("SC EventException : " + ex.toString(), ex);
								
								rollback();				
								throw ex;
							} catch(Exception ex) {
								log.error("SC Exception e : " + ex.toString(), ex);
								
								rollback();
								throw new EventException(new ErrorHandler("GEM99999").getMessage(),
										ex);
							}
						}
					}
				}
			}
		}
		log.info("##### GEMPlanningPerformanceSC receiveFns0090001Slip END #####");
	}
	
	// ---------------------------------------------------------------------------
	// [FNS003-0001] Receive WebLogic JMS Queue Proxy
	// ---------------------------------------------------------------------------
    
	/**
     * FNS003-0001 연동
     * 
     * @author choijungmi
     * @category FNS003-0001
     * @category receiveFns0030001Slip
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	public void receiveFns0030001Slip(Event e) throws EventException {
		GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();
		
		GemSlpIfVO[] models = ((CpsGemFns0030001Event) e).getGemSlpIfVOs();
		log.info("##### models : "+models.length);
		
		int insCnt = 0;		
		// 0. List Add
		for (int i = 0; i < models.length; i++) {
			String slpTjNo = models[i].getSlpTjNo();
			String slpSeqNo = models[i].getSlpSeqNo();

			if(!command.searchSlpIfCheck(slpTjNo, slpSeqNo)) {
				// GEM_SLP_IF Table에 Insert
				insCnt += command.createSlip(models[i]);
			}
		}
		log.info("##### insCnt : "+insCnt);

		// insCnt > 0 면 GEM_SLP_PERF Table에 Insert를 수행 오류가 나면 RollBack함.
		if(insCnt > 0) {
			for (int i = 0; i < models.length; i++) {				
				String slpTjNo = models[i].getSlpTjNo();
				String slpSeqNo = models[i].getSlpSeqNo();
				String slpIfFlg = models[i].getSlpIfFlg();
				
				if("N".equals(slpIfFlg)) {
					// 0. SLP_TJ_NO, SLP_SEQ_NO가 존재하면
					if(command.searchSlpIfCheck(slpTjNo, slpSeqNo)) {
						// 3. ERP로부터 일반관리비 비용집계 대상 전표 정보 조회
						List<GemSlpIfVO> list = command.searchSlpIf(slpTjNo, slpSeqNo, "");
						
						if(list.size() > 0) {						
							for(int j=0; j<list.size(); j++) {
								GemSlpIfVO gemSlpIfVO = (GemSlpIfVO)list.get(j);
								//log.info("::::: >>> gemSlpIfVO : "+gemSlpIfVO);
								
								try {
									begin();
									// GEM_SLP_IF 테이블에 Insert 성공이면
									command.createSlipClosing(gemSlpIfVO);
									commit();
								} catch(EventException ex){
									log.error("EventException e : " + ex.toString(), ex);
									rollback();
									throw ex;
								} catch(Exception ex) {
									log.error("Exception e : " + ex.toString(), ex);
									rollback();	
									throw new EventException(new ErrorHandler("GEM99999").getMessage(),
											ex);
								}
							}
						}
					}
				}
			}
		}
	}
	
	// ---------------------------------------------------------------------------
	// [FNS061-0001] Receive WebLogic JMS Queue Proxy
	// ---------------------------------------------------------------------------
    
	/**
     * FNS051-0001 연동
     * 
     * @author choijungmi
     * @category FNS051-0001
     * @category receiveFns0510001Slip
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse receiveFns0510001Slip(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<GemSlpPerfVO> list = new ArrayList<GemSlpPerfVO>();
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			String strCsrNo = ((CpsGemFns0510001Event) e).getCsrNo();

			if (strCsrNo != null) {
				list = command.searchPerformanceRatio(strCsrNo);
			}

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999")
					.getMessage(), ex);
		}
		return eventResponse;
	}
	
	// ---------------------------------------------------------------------------
	// [FNS061-0001] Receive WebLogic JMS Queue Proxy
	// ---------------------------------------------------------------------------
    
	/**
     * FNS061-0001 연동
     * 
     * @author choijungmi
     * @category FNS061-0001
     * @category receiveFns0610001Slip
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	public void receiveFns0610001Slip(Event e) throws EventException {
		try {
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			begin();
			
			GemSlpPerfVO[] models = ((CpsGemFns0610001Event) e).getGemSlpPerfVOs();
			log.info("##### models : "+models.length);
			
			if(models != null) {
				for (int i = 0; i < models.length; i++) {
					String slpTjNo = models[i].getSlpTjNo();
					String prprUsrId = models[i].getPrprUsrId();
					String aproUsrId = models[i].getAproUsrId();
					String updUsrId = models[i].getUpdUsrId();
					
					// XML Length 만큼 For Loop 하여 Modify
					command.modifyApproUsrId(slpTjNo, prprUsrId, aproUsrId, updUsrId);		
				}
			}
			commit();			
		} catch(EventException ex){
			log.error("EventException e : " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("GEM99999",new String[]{}).getMessage());
		} catch(Exception ex) {
			log.error("Exception e : " + ex.toString(), ex);
			rollback();			
			throw new EventException(new ErrorHandler("GEM99999",new String[]{}).getMessage());
		}
	}
	
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0019] Detail_Yearly Expense
	// ---------------------------------------------------------------------------
	
    /**
     * CPS_GEM_0019화면의 open시 검색관련 조회.<br>
     * 
     * @author choijungmi
     * @category CPS_GEM_0019
     * @category open0019
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse open0019(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMCommonBC comCommand = new GEMCommonBCImpl();
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			// 반환값 취득
			// 일반관리비 BU 조직코드 조회
			String[] searchExpenseBUList = comCommand.searchBUOffice();
			String[] searchTicList = command.searchExpenseTICList();

			List<GemExpenseVO> searchExpenseList = command.searchExpenseList();
			List<GemExpenseVO> searchGroupListByExpense = command
					.searchGroupListByExpense();

			// 반환 객체 설정
			eventResponse.setETCData("searchBUOfficeList", GemUtil
					.addSpChar(searchExpenseBUList));
			eventResponse.setETCData("ticList", GemUtil
					.addSpChar(searchTicList));
			eventResponse.setRsVoList(searchExpenseList);
			eventResponse.setRsVoList(searchGroupListByExpense);
			/*
			 * // BU관련 권한 조회 Start========================= // 로그인 오피스 정보 String
			 * ofcCd = usrOfcCd; // 회계년도 String acctXchRtYrmon =
			 * DateTime.getYear() + "";
			 * 
			 * // 오피스 Role , 오피스 환율 정보 취득 OfficeLevelVO officeLevelVo =
			 * commandPf.searchOfficeRqstInfo(ofcCd, acctXchRtYrmon);
			 * eventResponse.setRsVo(officeLevelVo);
			 * 
			 * // 로그인 사용자 오피스 정보 OfficeHierarchyVO officeHierarchyVO =
			 * commandPf.searchOfficeHierarchy(ofcCd);
			 * eventResponse.setRsVo(officeHierarchyVO); // BU관련 권한 조회
			 * End===========================
			 */

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999")
					.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
     * CPS_GEM_0019화면의 open시 검색관련 조회.<br>
     * 
     * @author choijungmi
     * @category CPS_GEM_0019
     * @category searchOfficeAuth
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeAuth(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			CpsGem0019Event event = (CpsGem0019Event) e;

			// BU관련 권한 조회 Start=========================
			// 로그인 오피스 정보
			String ofcCd = "";
			String acctXchRtYrmon = ""; // 회계년도

			log.info("##### event.popup : " + event.popup);
			log.info("##### event.getPopYear() : " + event.getPopYear());
			log.info("##### event.getPopOfcCd() : " + event.getPopOfcCd());

			if ("Y".equals(event.popup)) {
				ofcCd = event.getPopOfcCd();
				acctXchRtYrmon = event.getPopYear() + "";
			} else {
				ofcCd = command.searchUserOfficeCd(account.getOfc_cd());
				acctXchRtYrmon = DateTime.getYear() + "";
			}

			// 오피스 Role , 오피스 환율 정보 취득
			OfficeLevelVO officeLevelVo = command.searchOfficeRqstInfo(ofcCd,
					acctXchRtYrmon);
			eventResponse.setRsVo(officeLevelVo);

			// 로그인 사용자 오피스 정보
			OfficeHierarchyVO officeHierarchyVO = command
					.searchOfficeHierarchy(ofcCd);
			eventResponse.setRsVo(officeHierarchyVO);
			// BU관련 권한 조회 End===========================
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999")
					.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
     * CPS_GEM_0019(01)화면의 DownExcel클릭시 Yearly Expense BackEndJob 처리.<br>
     * 
     * @author choijungmi
     * @category CPS_GEM_0019
     * @category searchDetailByYearlyExpenseByBackEndJobKey
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDetailByYearlyExpenseByBackEndJobKey(Event e)
			throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			CpsGem0019Event event = (CpsGem0019Event) e;

			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 로그인 조직코드
			String usrOfcCd = command.searchUserOfficeCd(account.getOfc_cd());
			event.getSearchYearlyExpenseVO().setAuthOfcCd(usrOfcCd);
			String backEndJobKey = command
					.searchDetailByYearlyExpenseByBackEndJobKey(event
							.getSearchYearlyExpenseVO(), account.getUsr_id());
			log.info(":::::>>> backEndJobKey : " + backEndJobKey);
			eventResponse.setETCData("BackEndJobKey", backEndJobKey);

			/*
			 * // BC 객체 생성 GEMDetailYearlyExpenseBackEndBCImpl command = new
			 * GEMDetailYearlyExpenseBackEndBCImpl();
			 * 
			 * //log.info("##### event.getSearchYearlyExpenseVO() : "+event.
			 * getSearchYearlyExpenseVO()); command.setAuthOfcCd(usrOfcCd);
			 * command
			 * .setSearchYearlyExpenseVO(event.getSearchYearlyExpenseVO());
			 * 
			 * BackEndJobManager backEndJobManager = new BackEndJobManager();
			 * String backEndJobKey = backEndJobManager.execute(command,
			 * account.getUsr_id(), "Yearly Expense");
			 * log.info(":::::>>> backEndJobKey : "+backEndJobKey);
			 * eventResponse.setETCData("BackEndJobKey", backEndJobKey);
			 */
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999")
					.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
     * CPS_GEM_0019화면의 DownExcel클릭시 Yearly Expense의 BackEndJjob의 Key 조회.<br>
     * 
     * @author choijungmi
     * @category CPS_GEM_0019_01
     * @category searchDetailByBackEndJobStatus
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public EventResponse searchDetailByBackEndJobStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		CpsGem0019Event event = (CpsGem0019Event)e;
    	try {    		
	    	
    		SearchYearlyExpenseVO searchYearlyExpenseVO = event.getSearchYearlyExpenseVO();
	    	if(searchYearlyExpenseVO != null) {
	    		String backEndJobKey = searchYearlyExpenseVO.getBackendjobKey();
	    		
    			// Backend job이 완료되었는지 검사한다.
		    	BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(backEndJobKey);

		    	DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();
		    	List<ComBakEndJbVO> dbRowSetlist = (List)RowSetUtil.rowSetToVOs(rowSet, ComBakEndJbVO.class);
		    	log.info(":::::>>> dbRowSetlist : "+dbRowSetlist);
		    	
		    	ComBakEndJbVO jobVo = null;
		    	if (dbRowSetlist.size() == 0) {
		    		// Background job framework가 정상적으로 동작하지 않을 경우 발생하는 오류를 회피하기 위함
		    		jobVo = new ComBakEndJbVO();
		    		jobVo.setJbStsFlg("0");
		    	} else {
		    		jobVo = (ComBakEndJbVO)dbRowSetlist.get(0);	
		    	}
		    	eventResponse.setETCData("jb_sts_flg", jobVo.getJbStsFlg());
	    	}
    	} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999",new String[]{}).getMessage());
		}
    	return eventResponse;
    }
	
	/**
     * CPS_GEM_0019(01)화면의 DownExcel클릭시 BackEndJob에서 실행된 결과 파일을 LoadFile함수를통해 결과를 가져옴<br>
     * 
     * @author choijungmi
     * @category CPS_GEM_0019_01
     * @category searchDetailByYearlyExpenseByBackEndJobFile
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDetailByYearlyExpenseByBackEndJobFile(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			CpsGem0019Event event = (CpsGem0019Event) e;

			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			SearchYearlyExpenseVO searchYearlyExpenseVO = event
					.getSearchYearlyExpenseVO();
			List<DetailYearlyExpenseVO> list = new ArrayList<DetailYearlyExpenseVO>();

			// EAIDAO 호출
			list = command
					.getBackEndJobResutYearlyExpense(searchYearlyExpenseVO
							.getBackendjobKey());
			log.info("::::::>>> list : " + list);
			eventResponse.setRsVoList(list);

			// 반환 객체 설정
			// if(list.size() <= 0) {
			// GEM00013(There is no related data!)
			// eventResponse.setUserMessage(new
			// ErrorHandler("GEM00013").getUserMessage());
			// }
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());			
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999",
					new String[] {}).getMessage());
		}
		return eventResponse;
	}
	
	/**
     * CPS_GEM_0019(02)화면의 DownExcel클릭시 Request Expense Of Initial BackEndJob 처리.<br>
     * 
     * @author choijungmi
     * @category CPS_GEM_0019_02
     * @category searchDetailRequestExpenseByBackEndJob
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDetailByRequestExpenseByBackEndJobKey(Event e)
			throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			CpsGem0019Event event = (CpsGem0019Event) e;

			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();
			String usrOfcCd = command.searchUserOfficeCd(account.getOfc_cd());

			log.info("##### usrOfcCd : " + usrOfcCd);
			// 로그인 조직코드
			event.getSearchYearlyExpenseVO().setAuthOfcCd(usrOfcCd);
			String backEndJobKey = command
					.searchDetailByRequestExpenseByBackEndJobKey(event
							.getSearchYearlyExpenseVO(), account.getUsr_id());
			log.info(":::::>>> backEndJobKey : " + backEndJobKey);
			eventResponse.setETCData("BackEndJobKey", backEndJobKey);

			/*
			 * // BC 객체 생성 GEMDetailRequestExpenseBackEndBCImpl command = new
			 * GEMDetailRequestExpenseBackEndBCImpl();
			 * 
			 * //log.info("##### event.getSearchYearlyExpenseVO() : "+event.
			 * getSearchYearlyExpenseVO()); command.setAuthOfcCd(usrOfcCd);
			 * command
			 * .setSearchYearlyExpenseVO(event.getSearchYearlyExpenseVO());
			 * 
			 * BackEndJobManager backEndJobManager = new BackEndJobManager();
			 * String backEndJobKey = backEndJobManager.execute(command,
			 * account.getUsr_id(), "Request Expense");
			 * log.info(":::::>>> backEndJobKey : "+backEndJobKey);
			 * eventResponse.setETCData("BackEndJobKey", backEndJobKey);
			 */
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999",
					new String[] {}).getMessage());
		}
		return eventResponse;
	}
		
	/**
     * CPS_GEM_0019(02)화면의 DownExcel클릭시 백엔드에서 실행된 결과 파일을 LoadFile함수를통해 결과를 가져옴<br>
     * 
     * @author choijungmi
     * @category CPS_GEM_0019_02
     * @category searchDetailByRequestExpenseByBackEndJobFile
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDetailByRequestExpenseByBackEndJobFile(Event e)
			throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			CpsGem0019Event event = (CpsGem0019Event) e;

			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			SearchYearlyExpenseVO searchYearlyExpenseVO = event
					.getSearchYearlyExpenseVO();
			List<DetailRequestExpenseVO> list = new ArrayList<DetailRequestExpenseVO>();

			// EAIDAO 호출
			list = command
					.getBackEndJobResutRequestExpense(searchYearlyExpenseVO
							.getBackendjobKey());
			log.info("::::::>>> list : " + list);
			eventResponse.setRsVoList(list);

			// 반환 객체 설정
			// if(list.size() <= 0) {
			// GEM00013(There is no related data!)
			// eventResponse.setUserMessage(new
			// ErrorHandler("GEM00013").getUserMessage());
			// }
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999",
					new String[] {}).getMessage());
		}
		return eventResponse;
	}
	
	/**
     * CPS_GEM_0019(03)화면의 DownExcel클릭시 Request Expense Of Initial의 Detail RQST NO BackEndJob 처리.<br>
     * 
     * @author choijungmi
     * @category CPS_GEM_0019_03
     * @category searchDetailRequestExpenseRqstNoByBackEndJob
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDetailByRequestExpenseRqstNoByBackEndJobKey(
			Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			CpsGem0019Event event = (CpsGem0019Event) e;

			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			String usrOfcCd = command.searchUserOfficeCd(account.getOfc_cd());

			log.info("##### usrOfcCd : " + usrOfcCd);
			// 로그인 조직코드
			event.getSearchYearlyExpenseVO().setAuthOfcCd(usrOfcCd);
			String backEndJobKey = command
					.searchDetailByRequestExpenseRqstNoByBackEndJobKey(event
							.getSearchYearlyExpenseVO(), account.getUsr_id());
			log.info(":::::>>> backEndJobKey : " + backEndJobKey);
			eventResponse.setETCData("BackEndJobKey", backEndJobKey);

			/*
			 * // BC 객체 생성 GEMDetailRequestExpenseRqstNoBackEndBCImpl command =
			 * new GEMDetailRequestExpenseRqstNoBackEndBCImpl();
			 * 
			 * 
			 * command.setSearchYearlyExpenseVO(event.getSearchYearlyExpenseVO())
			 * ;
			 * 
			 * BackEndJobManager backEndJobManager = new BackEndJobManager();
			 * String backEndJobKey = backEndJobManager.execute(command,
			 * account.getUsr_id(), "Request Expense Detail");
			 * log.info(":::::>>> backEndJobKey : "+backEndJobKey);
			 * eventResponse.setETCData("BackEndJobKey", backEndJobKey);
			 */
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999",
					new String[] {}).getMessage());
		}
		return eventResponse;
	}
		
	/**
     * CPS_GEM_0019(03)화면의 DownExcel클릭시 백엔드에서 실행된 결과 파일을 LoadFile함수를통해 결과를 가져옴<br>
     * 
     * @author choijungmi
     * @category CPS_GEM_0019_03
     * @category searchDetailByRequestRqstNoExpenseByBackEndJobFile
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDetailByRequestExpenseRqstNoByBackEndJobFile(
			Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			CpsGem0019Event event = (CpsGem0019Event) e;

			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			SearchYearlyExpenseVO searchYearlyExpenseVO = event
					.getSearchYearlyExpenseVO();
			List<DetailRequestExpenseRqstNoVO> list = new ArrayList<DetailRequestExpenseRqstNoVO>();

			// EAIDAO 호출
			list = command
					.getBackEndJobResutRequestExpenseRqstNo(searchYearlyExpenseVO
							.getBackendjobKey());
			log.info("::::::>>> list : " + list);
			eventResponse.setRsVoList(list);

			// 반환 객체 설정
			// if(list.size() <= 0) {
			// GEM00013(There is no related data!)
			// eventResponse.setUserMessage(new
			// ErrorHandler("GEM00013").getUserMessage());
			// }
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999",
					new String[] {}).getMessage());
		}
		return eventResponse;
	}
	
	// ===========================================================================
	// P.C.J
	// ===========================================================================
	/**
     * 현지법인의 실적을 월별로 조회한다<br>
     * 
     * @author P.C.J
     * @category CPS_GEM_0004
     * @category searchSubsidiaryActualResults 
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSubsidiaryActualResults(Event e)
			throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 리스트 취득
			List<SubsPerfVO> list = new ArrayList<SubsPerfVO>();

			// 이벤트 생성
			CpsGem0004Event event = (CpsGem0004Event) e;

			list = command.searchSubsidiaryActualResults(event
					.getActRsltSubsPerfVO());

			eventResponse.setRsVoList(list);

			if (list.size() == 0) {
				// 에러메세지설정
				eventResponse.setUserMessage(new ErrorHandler("GEM00013")
						.getUserMessage());
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999",
					new String[] {}).getMessage());
		}
		return eventResponse;
	}
	
    /**
     * 화면 open시 오피스 정보 , 환율정보 , 마감일 취득 .<br>
     * 
     * @author P.C.J
     * @category CPS_GEM_0004
     * @category open0004
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse open0004(Event e) throws EventException {

		// 반환 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {

			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 로그인 오피스 정보
			String ofcCd = command.searchUserOfficeCd(account.getOfc_cd());
			eventResponse.setETCData("usr_ofc_cd", ofcCd);
			// 회계년도
			String acctXchRtYrmon = DateTime.getYear() + "";

			// 오피스 Role , 오피스 환율 정보 취득
			OfficeLevelVO officeLevelVo = command.searchOfficeRqstInfo(ofcCd,
					acctXchRtYrmon);
			eventResponse.setRsVo(officeLevelVo);

			// 로그인 사용자 오피스 정보
			OfficeHierarchyVO officeHierarchyVO = command
					.searchOfficeHierarchy(ofcCd);
			eventResponse.setRsVo(officeHierarchyVO);

			// 실적을 입력할 년월
			String perfClosingDate = command.searchPerfClosingDate(ofcCd);
			eventResponse.setETCData("closingDate", perfClosingDate);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999",
					new String[] {}).getMessage());
		}
		return eventResponse;
	}
	
    /**
     * 화면 open시 오피스 정보 취득 .<br>
     * 
     * @author P.C.J
     * @category CPS_GEM_0016
     * @category searchSlipInqOpen
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSlipInqOpen(Event e) throws EventException {

		// 반환 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {

			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();
			// 로그인 오피스 정보
			String ofcCd = command.searchUserOfficeCd(account.getOfc_cd());

			// 회계년도
			String acctXchRtYrmon = DateTime.getYear() + "";

			// 오피스 Role , 오피스 환율 정보 취득
			OfficeLevelVO officeLevelVo = command.searchOfficeRqstInfo(ofcCd,
					acctXchRtYrmon);
			eventResponse.setRsVo(officeLevelVo);

			// 로그인 사용자 오피스 정보
			OfficeHierarchyVO officeHierarchyVO = command
					.searchOfficeHierarchy(ofcCd);
			eventResponse.setRsVo(officeHierarchyVO);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999",
					new String[] {}).getMessage());
		}
		return eventResponse;
	}
	
	/**
     * 일반관리비 비용계획을 요청할수 있는 집행단위 조직이 사용할수 있는 비용코드(Expense Code)를 조회한다<br>
     * 
     * @author P.C.J
     * @category CPS_GEM_0004
     * @category searchOfficeExpenseMatrixLIstByExpense 
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeExpenseMatrixLIstByExpense(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 리스트 취득
			List<SubsPerfVO> list = new ArrayList<SubsPerfVO>();

			// 이벤트 생성
			CpsGem0004Event event = (CpsGem0004Event) e;

			ActRsltSubsPerfVO actRsltSubsPerfVO = event.getActRsltSubsPerfVO();
			String usrOfcCd = command.searchUserOfficeCd(account.getOfc_cd());
			actRsltSubsPerfVO.setLoginOfcCd(usrOfcCd);

			list = command
					.searchOfficeExpenseMatrixLIstByExpense(actRsltSubsPerfVO);

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999",
					new String[] {}).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * CPS_GEM_0004 멀티 이벤트 처리<br>
	 * 현지법인 실적을 월별 생성한다<br>
	 * 
	 * @author P.C.J
     * @category CPS_GEM_0004
     * @category manageSubsidiaryActualResults
     * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse manageSubsidiaryActualResults(Event e) throws EventException 
	{		
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		// 이벤트 생성
		CpsGem0004Event event = (CpsGem0004Event)e;
		
		// BC 객체 생성
		GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();
		
		try{
			
			begin();
			
			// event관련 사용자정보 insert
			SubsPerfVO[] subsPerfVOs =  event.getSubsPerfVOs();
			for(int i=0; i<subsPerfVOs.length; i++) {
				//사용자 설정
				subsPerfVOs[i].setCreUsrId(account.getUsr_id().equals("")?account.getUsr_id():account.getUsr_id());
				subsPerfVOs[i].setUpdUsrId(account.getUsr_id().equals("")?account.getUsr_id():account.getUsr_id());
			}
			
			command.manageSubsidiaryActualResults(subsPerfVOs);
			
			// 에러메세지설정
			eventResponse.setUserMessage(new ErrorHandler("GEM00008").getUserMessage());			
			commit();
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getUserMessage());
		} catch(Exception ex) {
			log.error("Exception e : " + ex.toString(), ex);
			rollback();			
			throw new EventException(new ErrorHandler("GEM99999",new String[]{}).getMessage());
		}
		return eventResponse;
	}
	
	/**
     * ERP 에서 I/F 받은 전표 정보 조회<br>
     * 
     * @author P.C.J
     * @category CPS_GEM_0016
     * @category searchSlipInq 
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSlipInq(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {

			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 리스트 취득
			List<SlipPerformanceVO> list = new ArrayList<SlipPerformanceVO>();

			// 이벤트 생성
			CpsGem0016Event event = (CpsGem0016Event) e;

			list = command.searchSlipInq(event.getRqstInfoVO());

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999",
					new String[] {}).getMessage());
		}
		return eventResponse;
	}
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0004] 
	// ---------------------------------------------------------------------------
	
	/**
     * 화면 open시 오피스 정보 취득 .<br>
     * 
     * @author P.C.J
     * @category CPS_GEM_0015
     * @category searchExpnPerfOpen
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExpnPerfOpen(Event e) throws EventException {

		// 반환 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {

			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();
			// 로그인 오피스 정보
			String ofcCd = command.searchUserOfficeCd(account.getOfc_cd());

			// 회계년도
			String acctXchRtYrmon = DateTime.getYear() + "";

			// 오피스 Role , 오피스 환율 정보 취득
			OfficeLevelVO officeLevelVo = command.searchOfficeRqstInfo(ofcCd,
					acctXchRtYrmon);
			eventResponse.setRsVo(officeLevelVo);

			// 로그인 사용자 오피스 정보
			OfficeHierarchyVO officeHierarchyVO = command
					.searchOfficeHierarchy(ofcCd);
			eventResponse.setRsVo(officeHierarchyVO);

			// Closing Date
			String perfClosingDate = command.searchPlanningPerfClosingDate();
			eventResponse.setETCData("closingDate", perfClosingDate);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999",
					new String[] {}).getMessage());
		}
		return eventResponse;
	}
	
	/**
     * 확정된 비용계획과 비용실적 정보 조회<br>
     * 
     * @author P.C.J
     * @category CPS_GEM_0015
     * @category searchPlanningPerformance 
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPlanningPerformance(Event e)
			throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {

			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 리스트 취득
			List<PlanningPerformanceVO> list = new ArrayList<PlanningPerformanceVO>();
			// 이벤트 생성
			CpsGem0015Event event = (CpsGem0015Event) e;

			list = command.searchPlanningPerformance(event.getRqstInfoVO());

			// ratio % 기호 삽입
			for (int i = 0; i < list.size(); i++) {

				PlanningPerformanceVO vo = list.get(i);

				vo.setChaPer("%");
				vo.setChaPer1("%");

			}

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999",
					new String[] {}).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * CPS_GEM_0015 멀티 이벤트 처리<br>
	 * 조회대상 Month의 년간 누계 집행율에 대한 과다/과소 사유 저장<br>
	 * 
	 * @author P.C.J
     * @category CPS_GEM_0015
     * @category modifyExceedReason
     * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyExceedReason(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		// 이벤트 생성
		CpsGem0015Event event = (CpsGem0015Event) e;

		// BC 객체 생성
		GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

		try {

			begin();

			// event관련 사용자정보 insert
			RatioReasonVO[] ratioReasonVOs = event.getRatioReasonVOs();
			for (int i = 0; i < ratioReasonVOs.length; i++) {
				// 사용자 설정
				ratioReasonVOs[i]
						.setCreUsrId(account.getUsr_id().equals("") ? account
								.getUsr_id() : account.getUsr_id());
				ratioReasonVOs[i]
						.setUpdUsrId(account.getUsr_id().equals("") ? account
								.getUsr_id() : account.getUsr_id());
			}

			command.modifyExceedReason(ratioReasonVOs);

			// 에러메세지설정
			eventResponse.setUserMessage(new ErrorHandler("GEM00008")
					.getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999")
					.getUserMessage());
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999",
					new String[] {}).getMessage());
		}
		return eventResponse;
	}
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0015] 
	// ---------------------------------------------------------------------------
	
	/**
     * 화면 open시 오피스 정보 취득 .<br>
     * 
     * @author P.C.J
     * @category CPS_GEM_0014_01
     * @category searchComparisonOpen
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComparisonOpen(Event e) throws EventException {

		// 반환 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {

			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();
			// 로그인 오피스 정보
			String ofcCd = command.searchUserOfficeCd(account.getOfc_cd());

			// 회계년도
			String acctXchRtYrmon = DateTime.getYear() + "";

			// 오피스 Role , 오피스 환율 정보 취득
			OfficeLevelVO officeLevelVo = command.searchOfficeRqstInfo(ofcCd,
					acctXchRtYrmon);
			eventResponse.setRsVo(officeLevelVo);

			// 로그인 사용자 오피스 정보
			OfficeHierarchyVO officeHierarchyVO = command
					.searchOfficeHierarchy(ofcCd);
			eventResponse.setRsVo(officeHierarchyVO);
		} catch (EventException ex) {			
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999")
					.getUserMessage());
		} catch (Exception ex) {			
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999",
					new String[] {}).getMessage());
		}
		return eventResponse;
	}
	
	/**
     * 수립된 비용계획에 대한 요청 정보를 승인단계별로 비교 조회한다<br>
     * 
     * @author P.C.J
     * @category CPS_GEM_0014_01
     * @category searchComparisonPlanning 
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComparisonPlanning(Event e)
			throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 리스트 취득
			List<ComparisonPlanningVO> list = new ArrayList<ComparisonPlanningVO>();

			// 이벤트 생성
			CpsGem001401Event event = (CpsGem001401Event) e;

			list = command.searchComparisonPlanning(event.getRqstInfoVO());

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999")
					.getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999",
					new String[] {}).getMessage());
		}
		return eventResponse;
	}
	
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0014_01] 
	// ---------------------------------------------------------------------------
	
	/**
     * 요청된 비용계획에 대하여 승인 정보를 조회한다<br>
     * 
     * @author P.C.J
     * @category CPS_GEM_0106
     * @category searchApprovalOpinionInfo 
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchApprovalOpinionInfo(Event e)
			throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 리스트 취득
			List<GemApprovalStepVO> list = new ArrayList<GemApprovalStepVO>();

			// 이벤트 생성
			CpsGem0106Event event = (CpsGem0106Event) e;

			// 비용계획 요청 번호
			String genExpnRqstNo = event.getGenExpnRqstNo();

			// 비용코드
			String genExpnCd = event.getGenExpnCd();

			// 비용코드의 아이템번호
			String genExpnItemNo = event.getGenExpnItmNo();

			list = command.searchApprovalOpinionInfo(genExpnRqstNo, genExpnCd,
					genExpnItemNo);

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999")
					.getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999",
					new String[] {}).getMessage());
		}
		return eventResponse;
	}
	
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0106] 
	// ---------------------------------------------------------------------------
	
	/**
     * 유형별(계획비용,추가배정,예산이관) Request 요청된 정보를 상세조회한다<br>
     * 
     * @author P.C.J
     * @category CPS_GEM_0014_02
     * @category searchRqstInfo
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRqstInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 리스트 취득
			List<RqstPlanInfoVO> list = new ArrayList<RqstPlanInfoVO>();
			// 이벤트 생성
			CpsGem001402Event event = (CpsGem001402Event) e;

			// 조회년월
			// String plnYrmon = event.getPlnYrmon();

			// 조직코드
			// String ofcCd = event.getOfcCd();

			// 비용코드
			// String genExpnCd = event.getGenExpnCd();

			// String genExpnRqstTpCd = event.getGenExpnRqstTpCd();

			list = command.searchRqstInfo(event.getRqstInfoVO());

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999")
					.getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999",
					new String[] {}).getMessage());
		}
		return eventResponse;
	}
	
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0014_02] 
	// ---------------------------------------------------------------------------
	
	/**
     * 비용계획을 요청중인 조직의 현재까지의 실적 정보를 조회한다<br>
     * 
     * @author P.C.J
     * @category CPS_GEM_0108
     * @category searchPerformanceInquiry
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPerformanceInquiry(Event e)
			throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 리스트 취득
			List<PerformanceInfoVO> list = new ArrayList<PerformanceInfoVO>();

			// 이벤트 생성
			CpsGem0108Event event = (CpsGem0108Event) e;

			list = command.searchPerformanceInquiry(event.getPerfInqVO());

			NumberFormat nf = NumberFormat.getInstance();

			nf.setMaximumFractionDigits(2); // 최대 소수점 2자리까지만 보이게

			nf.setMinimumFractionDigits(2); // 최소 소수점 2자리까지만 보이게

			// ratio를 구하고 % 문자를 삽입한다
			for (int i = 0; i < list.size(); i++) {

				PerformanceInfoVO vo = list.get(i);

				Double ytdPerf = 0.0;
				Double yearAssExp = 1.0;
				Double ytdAssExp = 1.0;

				if (vo.getYtdPerf() != null && vo.getYtdPerf() != "") {
					ytdPerf = new Double(vo.getYtdPerf());
				}

				if (vo.getYearAssExp() != null && vo.getYearAssExp() != "") {
					yearAssExp = new Double(vo.getYearAssExp());
				}

				if (vo.getYtdAssExp() != null && vo.getYtdAssExp() != "") {
					ytdAssExp = new Double(vo.getYtdAssExp());
				}

				if (yearAssExp == 0.0) {
					yearAssExp = 1.0;
				}

				if (ytdAssExp == 0.0) {
					ytdAssExp = 1.0;
				}

				Double rate1 = (ytdPerf / yearAssExp) * 100;
				Double rate2 = (ytdPerf / ytdAssExp) * 100;

				vo.setYtdRate(nf.format(rate2) + "%");
				vo.setYearRate(nf.format(rate1) + "%");

			}

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999")
					.getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999",
					new String[] {}).getMessage());
		}
		return eventResponse;
	}
	
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0108] 
	// ---------------------------------------------------------------------------
	
	/**
     * 조직별 예산과 실적을 조회하는 화면 초기화<br>
     * 
     * @author P.C.J
     * @category CPS_GEM_0018
     * @category searchReportOpen
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReportOpen(Event e) throws EventException {

		// 반환 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {

			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 로그인 오피스 정보
			String ofcCd = command.searchUserOfficeCd(account.getOfc_cd());
			eventResponse.setETCData("usr_ofc_cd", ofcCd);
			// 회계년도
			String acctXchRtYrmon = DateTime.getYear() + "";

			// 오피스 Role , 오피스 환율 정보 취득
			OfficeLevelVO officeLevelVo = command.searchOfficeRqstInfo(ofcCd,
					acctXchRtYrmon);
			eventResponse.setRsVo(officeLevelVo);

			// 로그인 사용자 오피스 정보
			OfficeHierarchyVO officeHierarchyVO = command
					.searchOfficeHierarchy(ofcCd);
			eventResponse.setRsVo(officeHierarchyVO);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999")
					.getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999",
					new String[] {}).getMessage());
		}
		return eventResponse;
	}
	
	/**
     * 조직별 예산과 실적을 조회한다<br>
     * 
     * @author P.C.J
     * @category CPS_GEM_0018_01
     * @category searchReportAfterClosingAll 
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReportAfterClosingAll(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 리스트 취득
			List<ReportAfterClosingVO> list = new ArrayList<ReportAfterClosingVO>();

			// 이벤트 생성
			CpsGem0018Event event = (CpsGem0018Event) e;

			// 2009.10.26 일 수정 login_office 추가
			RqstInfoVO rqstInfoVO = event.getRqstInfoVO();
			rqstInfoVO.setLoginOffice(account.getOfc_cd());

			list = command.searchReportAfterClosingAll(rqstInfoVO);

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999")
					.getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999",
					new String[] {}).getMessage());
		}
		return eventResponse;
	}
	
	/**
     * 조회 기간에 대한 비목별 집행실적 분석 Report<br>
     * 
     * @author P.C.J
     * @category CPS_GEM_0018_02
     * @category searchReportAfterClosingExpense 
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReportAfterClosingExpense(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {

			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 리스트 취득
			List<ReportAfterClosingVO> list = new ArrayList<ReportAfterClosingVO>();

			// 이벤트 생성
			CpsGem0018Event event = (CpsGem0018Event) e;
			// 2009.10.26 일 수정 login_office 추가
			RqstInfoVO rqstInfoVO = event.getRqstInfoVO();
			rqstInfoVO.setLoginOffice(account.getOfc_cd());
			list = command.searchReportAfterClosingExpense(rqstInfoVO);

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999")
					.getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999",
					new String[] {}).getMessage());
		}
		return eventResponse;
	}
	
	/**
     * 조회 기간에 대하여 Closing 반영된 집행단위별 집행실적 분석 Report<br>
     * 
     * @author P.C.J
     * @category CPS_GEM_0018_03
     * @category searchReportAfterClosingOffice
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReportAfterClosingOffice(Event e)
			throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 리스트 취득
			List<ReportAfterClosingVO> list = new ArrayList<ReportAfterClosingVO>();

			// 이벤트 생성
			CpsGem0018Event event = (CpsGem0018Event) e;
			// 2009.10.26 일 수정 login_office 추가
			RqstInfoVO rqstInfoVO = event.getRqstInfoVO();
			rqstInfoVO.setLoginOffice(account.getOfc_cd());
			list = command.searchReportAfterClosingOffice(rqstInfoVO);

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999")
					.getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999",
					new String[] {}).getMessage());
		}
		return eventResponse;
	}
	
	/**
     * 조회 기간에 대하여 Closing 반영된 투자법인 집행단위별 집행실적 분석 Report<br>
     * 
     * @author P.C.J
     * @category CPS_GEM_0018_04
     * @category searchReportAfterClosingSubsidiary
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReportAfterClosingSubsidiary(Event e)
			throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 리스트 취득
			List<ReportAfterClosingVO> list = new ArrayList<ReportAfterClosingVO>();

			// 이벤트 생성
			CpsGem0018Event event = (CpsGem0018Event) e;
			// 2009.10.26 일 수정 login_office 추가
			RqstInfoVO rqstInfoVO = event.getRqstInfoVO();
			rqstInfoVO.setLoginOffice(account.getOfc_cd());
			list = command.searchReportAfterClosingSubsidiary(rqstInfoVO);

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999")
					.getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999",
					new String[] {}).getMessage());
		}
		return eventResponse;
	}
	
	/**
     * 조회 대상/기간에 대하여 월별 배정 비용 리포트-해외배정비용현황 송부 참조용 Report<br>
     * 
     * @author P.C.J
     * @category CPS_GEM_0018_05
     * @category searchReportAfterClosingMonthly
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReportAfterClosingMonthly(Event e)
			throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 리스트 취득
			List<ReportAfterClosingVO> list = new ArrayList<ReportAfterClosingVO>();

			// 이벤트 생성
			CpsGem0018Event event = (CpsGem0018Event) e;
			// 2009.10.26 일 수정 login_office 추가
			RqstInfoVO rqstInfoVO = event.getRqstInfoVO();
			rqstInfoVO.setLoginOffice(account.getOfc_cd());
			list = command.searchReportAfterClosingMonthly(rqstInfoVO);

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999")
					.getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999",
					new String[] {}).getMessage());
		}
		return eventResponse;
	}
	
	/**
     * 조회 대상/기간에 대하여 월별 배정 비용 리포트-해외배정비용현황 송부 참조용 Report 커맨트<br>
     * 
     * @author P.C.J
     * @category CPS_GEM_0018_05
     * @category searchReportAfterClosingMonthlyComment
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReportAfterClosingMonthlyComment(Event e)
			throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 리스트 취득
			List<ReportAfterClosingVO> list = new ArrayList<ReportAfterClosingVO>();
			// 이벤트 생성
			CpsGem0018Event event = (CpsGem0018Event) e;
			// 2009.10.26 일 수정 login_office 추가
			RqstInfoVO rqstInfoVO = event.getRqstInfoVO();
			rqstInfoVO.setLoginOffice(account.getOfc_cd());
			list = command.searchReportAfterClosingMonthlyComment(rqstInfoVO);

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999")
					.getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999",
					new String[] {}).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 대상/기간에 대하여 월별 배정 비용 리포트-해외배정비용현황 송부 참조용 Report<br>
	 * 
	 * @author P.C.J
	 * @category CPS_GEM_0018_05
	 * @category searchReportAfterClosingSinwaExpense
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReportAfterClosingSinwaExpense(Event e)
			throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			// 리스트 취득
			List<ReportAfterClosingVO> list = new ArrayList<ReportAfterClosingVO>();

			// 이벤트 생성
			CpsGem0018Event event = (CpsGem0018Event) e;
			// 2009.10.26 일 수정 login_office 추가
			RqstInfoVO rqstInfoVO = event.getRqstInfoVO();
			rqstInfoVO.setLoginOffice(account.getOfc_cd());
			list = command.searchReportAfterClosingSinwaExpense(rqstInfoVO);

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999")
					.getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999",
					new String[] {}).getMessage());
		}
		return eventResponse;
	}
	
	/**
     * CPS_GEM_0018_01화면의 DownExcel클릭시 Report After Closing BackEndJob 처리.<br>
     * 
     * @author P.C.J
     * @category CPS_GEM_0018_01
     * @category searchReportAfterClosingAllBackEndJobKey
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReportAfterClosingAllBackEndJobKey(Event e)
			throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			CpsGem0018Event event = (CpsGem0018Event) e;

			// 2009.10.26 일 수정 login_office 추가
			RqstInfoVO rqstInfoVO = event.getRqstInfoVO();
			rqstInfoVO.setLoginOffice(account.getOfc_cd());

			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			String backEndJobKey = command
					.searchReportAfterClosingAllBackEndJobKey(rqstInfoVO,
							account.getUsr_id());
			log.info(":::::>>> backEndJobKey : " + backEndJobKey);
			eventResponse.setETCData("BackEndJobKey", backEndJobKey);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999")
					.getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999",
					new String[] {}).getMessage());
		}
		return eventResponse;
	}
	
	/**
     * CPS_GEM_0018화면의 DownExcel클릭시 Report After Closing의 BackEndJob의 Key 조회.<br>
     * 
     * @author P.C.J
     * @category CPS_GEM_0018_01
     * @category searchReportAfterClosingAllBackEndJobStatus
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchReportAfterClosingAllBackEndJobStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		CpsGem0018Event event = (CpsGem0018Event)e;
    	try {    		
	    	
    		RqstInfoVO rqstInfoVO = event.getRqstInfoVO();
	    	if(rqstInfoVO != null) {
	    		String backEndJobKey = rqstInfoVO.getBackendjobKey();
	    		
    			// Backend job이 완료되었는지 검사한다.
		    	BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(backEndJobKey);

		    	DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();
		    	List<ComBakEndJbVO> dbRowSetlist = (List)RowSetUtil.rowSetToVOs(rowSet, ComBakEndJbVO.class);
		    	log.info(":::::>>> dbRowSetlist : "+dbRowSetlist);
		    	
		    	ComBakEndJbVO jobVo = null;
		    	if (dbRowSetlist.size() == 0) {
		    		// Background job framework가 정상적으로 동작하지 않을 경우 발생하는 오류를 회피하기 위함
		    		jobVo = new ComBakEndJbVO();
		    		jobVo.setJbStsFlg("0");
		    	} else {
		    		jobVo = (ComBakEndJbVO)dbRowSetlist.get(0);	
		    	}
		    	eventResponse.setETCData("jb_sts_flg", jobVo.getJbStsFlg());
	    	}
    	} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999",new String[]{}).getMessage());
		}
    	return eventResponse;
    }
	
	/**
     * CPS_GEM_0018화면의 DownExcel클릭시 백엔드에서 실행된 결과 파일을 LoadFile함수를통해 결과를 가져옴<br>
     * 
     * @author P.C.J
     * @category CPS_GEM_0018_01
     * @category searchReportAfterClosingAllBackEndJobFile
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReportAfterClosingAllBackEndJobFile(Event e)
			throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			CpsGem0018Event event = (CpsGem0018Event) e;

			// BC 객체 생성
			GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

			RqstInfoVO rqstInfoVO = event.getRqstInfoVO();
			List<ReportAfterClosingVO> list = new ArrayList<ReportAfterClosingVO>();

			// EAIDAO 호출
			list = command.getBackEndJobResutReportAfterClosingAll(rqstInfoVO
					.getBackendjobKey());
			log.info("::::::>>> list : " + list);
			eventResponse.setRsVoList(list);

			// 반환 객체 설정
			// if(list.size() <= 0) {
			// GEM00013(There is no related data!)
			// eventResponse.setUserMessage(new
			// ErrorHandler("GEM00013").getUserMessage());
			// }
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999")
					.getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999",
					new String[] {}).getMessage());
		}
		return eventResponse;
	}
	
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0018] 
	// ---------------------------------------------------------------------------

}