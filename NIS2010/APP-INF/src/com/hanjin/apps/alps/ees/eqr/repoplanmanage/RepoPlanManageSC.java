/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepoPlanManageSC.java
*@FileTitle : Execution Plan
*Open Issues :
*Change history :
*-----------------------------------------------------------------------------
*	No.    Ver.	Modifier			Modifier Date		Explanation
*-----------------------------------------------------------------------------
*				yongchan shin		2008-08-04			CSR NO : N200807310009 - Senator S/O Send, S/O Cancle 방식변경 EAT --> WTC
*				shin yongchan		2008-01-29			CSR NO : R200801154869
*				shin yongchan		2009-01-12			CSR NO : N200901080009 - EQR09 신규 생성 - Execution Plan 메뉴만 접근가능
*	                       														- 전지역에 대해 bkg / s/o cre 기능 가짐, SENCO office user들은 위한 권한
*				Haeng-Ji Lee		2009-01-07			CSR NO : N200901060030 - Oranization Chart에서 (RCC, LCC, ECC, SCC) 에 대한 갯수를 초기화면에 DISPLAY
*  				yongchan shin		2009-05-06			CSR NO : N200905060050 - &repoPlnWeek="+repoPlnWeek+" 항목 추가 (SPLIT BOOKING 대상 조회 WEEK 시작주차 기준 변경) - 계은영 요청
*				Chang-Ho Chae		2009-06-11			CSR No : N200906040080 - EQR 실행계획 하면 조회기능 변경 요청(Fm ETD, To ETA조건 추가)
*														CSR NO : R200903270008 - 소스 품질 개선(메소드 파라미터 삭제로 인한 메소드 호출방식 변경)
*				Lee Byoung Hun	2010.05.11			CSR No : CHM-201003779 - EES_EQR_0143(EQR All-Weeks' Plan Access Grant) 이벤트 처리 추가
*-----------------------------------------------------------------------------
*@LastModifyDate : 2009.08.17
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.08.13 이행지
* 1.0 Creation
* =========================================================
* 2010.10.28 이병훈 [CHM-201006752-01] RD Report E-mailFax 전송 관련 PGM 고도화
* 2010.12.03 양봉준 [CHM-201007345-01] EES_EQR_0144 화면 신규 개발
* 2011.06.13 나상보 [CHM-201111518-01] [EQR]  MTY Rail Trans. 화면의 CNTR List 조회 기능 추가
* 2011.09.02 김영철 [CHM-201113259-01] [EQR]  VD Add시 다다음주차 가지고 오는 로직 추가
* 2012.06.05 신용찬 [CHM-201218172]     T.VVD & D.VVD의 VL ADD 기간을 +0,+1,+2,+3,+4 WEEK 까지 확장	
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.basic.CommonBCImpl;
import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.vo.CommonVO;
import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrforecastprecisionmanage.basic.CntrForecastPrecisionManageBC;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrforecastprecisionmanage.basic.CntrForecastPrecisionManageBCImpl;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrforecastprecisionmanage.event.EesEqr0037Event;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrforecastprecisionmanage.event.EesEqr0141Event;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrforecastprecisionmanage.event.EesEqr0142Event;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrforecastprecisionmanage.vo.EesEqr0037ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrforecastprecisionmanage.vo.MtyRailConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrforecastprecisionmanage.vo.MtyRailDetailVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionfeedbackexamine.basic.CntrRepoExecutionFeedbackExamineBC;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionfeedbackexamine.basic.CntrRepoExecutionFeedbackExamineBCImpl;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionfeedbackexamine.event.EesEqr0063Event;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionfeedbackexamine.vo.EesEqr0063ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.basic.CntrRepoExecutionPlanEstablishBC;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.basic.CntrRepoExecutionPlanEstablishBCImpl;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event.EesEqr0059Event;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event.EesEqr0080Event;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event.EesEqr0081Event;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event.EesEqr0083Event;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event.EesEqr0092Event;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event.EesEqr0094Event;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event.EesEqr0108Event;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event.EesEqr0112Event;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event.EesEqr0113Event;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event.EesEqr0130Event;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event.EesEqr0131Event;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event.EesEqr0132Event;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event.EesEqr0143Event;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event.EtsEqr0001Event;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration.CntrRepoExecutionPlanEstablishDBDAO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0059ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0059MultiVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0080MultiVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0083MultiVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0094ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0131ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0143ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.ModifyFromTrsOffHireReturnVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.MtyBkgVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchBeforeCntrInfoVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchCheckCntrInfoVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchCntrRepoExecutionPlanEstablishVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchEqrAllWeeksPlanAccessGrantVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchEqrOrganizationVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanBkgNoVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanCntrInfoExcelVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanCntrInfoVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanCntrListVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanSplitCntrVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchSendHistoryVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplancompare.basic.CntrRepoPlanCompareBCImpl;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplancompare.event.EesEqr0070Event;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplancompare.event.EesEqr0135Event;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplancompare.vo.EesEqr0070ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplancompare.vo.EesEqr0135ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.basic.CntrRepoPlanKpiAnalysisBC;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.basic.CntrRepoPlanKpiAnalysisBCImpl;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.event.EesEqr0071Event;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.event.EesEqr0072Event;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.event.EesEqr0074Event;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.event.EesEqr0136Event;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.vo.EesEqr0071ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.vo.EesEqr0136ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.vo.GetForecastedSeaInventoryVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.vo.SearchCntrPlanKPISummaryVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.basic.CntrRepoPlanManageBC;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.basic.CntrRepoPlanManageBCImpl;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.event.EesEqr0045Event;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.event.EesEqr0048Event;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.event.EesEqr0051Event;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.event.EesEqr0052Event;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.event.EesEqr0053Event;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.event.EesEqr0054Event;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.event.EesEqr0129Event;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0045ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0048ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0051ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0052ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0053ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0054ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0129ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.GetRepoPlanListVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.SearchCntrOnHireApprovalVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.SearchCntrRepoInOutPlanLaneVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.SearchCntrRepoInOutPlanVVDVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.SearchTSGuidelineVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrreporesult.basic.CntrRepoResultManageBC;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrreporesult.basic.CntrRepoResultManageBCImpl;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrreporesult.event.EesEqr0144Event;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrreporesult.vo.EmptyRepoResultOptionVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingCreateVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.NewBkgSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.basic.GeneralBookingSplitCombineBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.basic.GeneralBookingSplitCombineBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.basic.PerformanceReportBC;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.basic.PerformanceReportBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationBLBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationBLBCImpl;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-RepoPlanManage Business Logic ServiceCommand - ALPS-RepoPlanManage 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Haeng-ji,Lee
 * @see CntrRepoExecutionPlanEstablishDBDAO
 * @since J2EE 1.6
 */

public class RepoPlanManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * RepoPlanManage system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("RepoPlanManageSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * RepoPlanManage system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("RepoPlanManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-RepoPlanManage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EesEqr0059Event")) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {      // 메뉴에서 메뉴 클릭한 경우
				eventResponse = configUserAuthLocation(e);						//user 화면권한, 지역정보 확인
				eventResponse = searchMaxRepoPlanId(e);							//distribute 완료된 최대 repo plan id 검색	
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {  // 051에서 링크로 넘어오는 경우
				eventResponse = configUserAuthLocation(e);						//user 화면권한, 지역정보 확인
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchTrunkVesselAndFeederCntrRepoPlan(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	// VD Add시 BKG No. 가져오기. 
				eventResponse = searchTrunkVesselAndFeederCntrRepoPlanBKGNO(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	// VD Add시 BKG No. 선택했을 때 해당 정보들 가져오기.
				eventResponse = searchTrunkVesselAndFeederCntrRepoPlanBKGNOInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {		// VL Add
				eventResponse = modifyTrunkVesselAndFeederCntrRepoPlan(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {		// Repo BKG Cre Button.
				eventResponse = createRepoBKG(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {		// VD Add -> Split BKG Cre Button.
				eventResponse = createRepoBKGSplit(e);
			}
		}
		// VSL Residual Capa [ EES_EQR_0113 ]
		if (e.getEventName().equalsIgnoreCase("EesEqr0113Event")) {	
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {  // Retrieve 버튼 클릭시
				eventResponse = searchCntrRepoExecutionPlanEstablish(e);				
			}
		}
		
		// 컨테이너 이송 계획 목록 조회
		if (e.getEventName().equalsIgnoreCase("EesEqr0045Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {			// Retrieve 버튼 클릭시
				eventResponse = searchRepoPlanDtInfo(e);
			}			
			if(e.getFormCommand().isCommand(FormCommand.ADD)) {			    // Copy 버튼 클릭시 
				eventResponse = createNewRepoPlanID(e);
			}				
			if(e.getFormCommand().isCommand(FormCommand.REMOVE)) {			// Delete 버튼 클릭시 
				eventResponse = removeRepoPlanID(e);
			}			
		}
		
		//TS Guideline
		if (e.getEventName().equalsIgnoreCase("EesEqr0129Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchTSGuideline(e);
			}			
		}
		
		//F.Cast Land Inv
		if (e.getEventName().equalsIgnoreCase("EesEqr0051Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchForecastedLandInventory(e);
			}
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyForecastedLandInventory(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchDtrbForecastedLandInventory(e);
			}
			if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = dtrbForecastedLandInventory(e);
			}			
		}		
		
		//Repo InOut
		if (e.getEventName().equalsIgnoreCase("EesEqr0052Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCntrRepoInOutPlanDtInfo(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchCntrRepoInOutPlanLaneInfo(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchCntrRepoInOutPlanVvdInfo(e);
			}
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyCntrRepoInOutPlanDtInfo(e);
			}
		}	
		
		//On-Hire
		if (e.getEventName().equalsIgnoreCase("EesEqr0053Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCntrOnHireRepoPlanDtInfo(e);
			}
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyCntrOnHireRepoPlanDtInfo(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchOnHireApproval(e);
			}
		}
		
		//Off-Hire
		if (e.getEventName().equalsIgnoreCase("EesEqr0054Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCntrOffHireRepoPlanDtInfo(e);
			}
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyCntrOffHireRepoPlanDtInfo(e);
			}
		}
		
		//RLA List
		if (e.getEventName().equalsIgnoreCase("EesEqr0048Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchRLARepoPlanDtList(e);
			}
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyRLARepoPlanDtList(e);
			}
		}
		
		// KPI Summary Of Container Repo Plan
		if (e.getEventName().equalsIgnoreCase("EesEqr0071Event")) {

			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCntrRepoPlanKPISummary(e);
			}
		}
		
		// Forecasted M/B
		if (e.getEventName().equalsIgnoreCase("EesEqr0136Event")) {	
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {  // Retrieve 버튼 클릭시
				eventResponse = searchForecastedSeaInventory(e);					                 
			}
		}
		
		// Execution Perform AND Feedback
		if (e.getEventName().equalsIgnoreCase("EesEqr0063Event")) {	
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {  // Retrieve 버튼 클릭시
				eventResponse = searchCntrRepoExecutionFeedback(e);					                 
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {  // sheet1에 duble click입력 시
				eventResponse = searchCntrRepoExecutionFeedbcakExamine(e);	
			}
		}
		
		// Forecast PFMC & Match Ratio
		if (e.getEventName().equalsIgnoreCase("EesEqr0037Event")) {

			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCntrForecastPerformance(e);
			}
		}
		
		// Inventory Container List [ EES_EQR_0094 ]
		if (e.getEventName().equalsIgnoreCase("EesEqr0094Event")) {	
	
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {  // Retrieve 버튼 클릭시
				eventResponse = searchCntrRepoExecutionPlanCntrList(e);					                 
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {  // sheet에 CNTR_NO입력 시
				eventResponse = searchCntrRepoExecutionPlanCntrInfo(e);	
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {  // sheet에 CNTR_NO입력 시 Load Excel
				eventResponse = searchCntrRepoExecutionPlanCntrInfoExcel(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {  // CNTR_NO 중복검사 (현재 호출되지 않는 메소드임, 20100510 - 신용찬 수석) 
				//log.debug("SC START");
				eventResponse = searchCheckCntrInfo(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) {  // sheet에 CNTR_NO입력 시 (이미 저장해 놓았던 CNTR)
				eventResponse = searchBeforeCntrInfo(e);
			}
		}	
		//컨테이너 이송 실행 계획 조회/수정 Truck/Rail/Barge [ EES_EQR_0080 ]
		if (e.getEventName().equalsIgnoreCase("EesEqr0080Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchTruckAndRailAndBargeCntrRepoPlan(e);
				
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyTruckAndRailAndBargeCntrRepoPlan(e);
			
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = soSendTruckAndRailAndBargeCntrRepoPlan(e);
				
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = soCancelTruckAndRailAndBargeCntrRepoPlan(e);
			
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = createRepoBKG(e);	
			
			}
		}		
		//On-Hire & Off-Hire [ EES_EQR_0081 ]
		if (e.getEventName().equalsIgnoreCase("EesEqr0081Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchOnHireAndOffHireCntrRepoPlan(e);			
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyOnHireAndOffHireCntrRepoPlan(e);
				
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = soSendOnHireAndOffHireCntrRepoPlan(e);
				
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = soCancelOnHireAndOffHireCntrRepoPlan(e);
			}	
			
		}
		// COMBINE [ EES_EQR_0108 ]
		if (e.getEventName().equalsIgnoreCase("EesEqr0108Event")) {
			if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = modifyCombineExecution(e);
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("EesEqr0130Event")) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {			// 화면 오픈시 BOOKING 정보 조회
				eventResponse = searchCntrRepoExecutionPlanBkgNoInfo(e);					                 
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {	// Retrieve 버튼 클릭시
				eventResponse = searchCntrRepoExecutionPlanSplitCntrList(e);					                 
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { // excel load시 조회
				eventResponse = searchCntrRepoExecutionPlanSplitCntrList(e);					                 
			}	
		}
		
		// EQR Organization Chart [ EES_EQR_0139 ]
		if (e.getEventName().equalsIgnoreCase("EesEqr0139Event")) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchEqrOrganizationChartCount();
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchEqrOrganizationChart();
			}
		}
		
		// Send FAX or e-mail from 0059 [ EES_EQR_0131 ]
		if (e.getEventName().equalsIgnoreCase("EesEqr0131Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {    // e-mail
				String send_mode = ((EesEqr0131Event)e).getEesEqr0131ConditionVO().getSendMode();
				if ( send_mode.equals("E")){	
					eventResponse = sendEmail(e);
				}
				else if( send_mode.equals("F")){	
					eventResponse = sendFax(e);
				}
				else if( send_mode.equals("A")){
					eventResponse = sendEmail(e);
					eventResponse = sendFax(e);
				}
			}	
			
		}
		// Seach Send History email / fax [ EES_EQR_0132 ]
		if (e.getEventName().equalsIgnoreCase("EesEqr0132Event")) {	
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { // 화면 오픈 시 e-mail /  fax 보낸 이력 조회
				eventResponse = searchSenderHistory(e);					                 
			}			
		}
		
		// SHUTTLE [ EES_EQR_0083 ]
		if (e.getEventName().equalsIgnoreCase("EesEqr0083Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchShuttleCntrRepoPlan(e);
				
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyShuttleCntrRepoPlan(e);
				
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = soSendShuttleCntrRepoPlan(e);
				
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = soCancelShuttleCntrRepoPlan(e);
			}
			
		}
		// Load Factor Performance Inquiry  조회 
		if (e.getEventName().equalsIgnoreCase("EesEqr0074Event")) {	
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {  // Retrieve 버튼 클릭시
				eventResponse = searchKpiAnalysisLoadFactorInfo(e);					                 
			}
			
		}
		// [ EES_EQR_0112 : Forecasted LandInventory ]
		if (e.getEventName().equalsIgnoreCase("EesEqr0112Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchLocalForecastedLandInv(e);
			}
		}
	
		// Load Factor Performance Inquiry  조회 
		if (e.getEventName().equalsIgnoreCase("EesEqr0074Event")) {	
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {  // Retrieve 버튼 클릭시
				eventResponse = searchKpiAnalysisLoadFactorInfo(e);					                 
			}
			
		}
		// Forecasted M/B [ EES_EQR_0072 ]
		if (e.getEventName().equalsIgnoreCase("EesEqr0072Event")) {	
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {  // Retrieve 버튼 클릭시
				eventResponse = searchForecastedMatchBackInfo(e);				
			}
		}
		// [ EES_EQR_0092 : Total ]
		if (e.getEventName().equalsIgnoreCase("EesEqr0092Event")) {	
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {  // Retrieve 버튼 클릭시
				eventResponse = searchTotalCntrRepoPlan(e);					                 
			}
		}
		// [ EES_EQR_0141 : MTY Rail Arrival Inquiry ]
		if (e.getEventName().equalsIgnoreCase("EesEqr0141Event")) {	
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {  
				  eventResponse = searchMtyRailArrivalUSTime(e);					                 
			}else if  (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {  // Retrieve 버튼 클릭시
			      eventResponse = searchMtyRailArrival(e);					                 
			}else if  (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {  // Retrieve 버튼 클릭시
			      eventResponse = searchMtyRailDetail(e);					                 
			}
		
		}
		// [ EES_EQR_0142 : MTY Rail Arrival Inquiry ]
		if (e.getEventName().equalsIgnoreCase("EesEqr0142Event")) {	
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {  // Retrieve 버튼 클릭시
				eventResponse = searchMtyRailResult(e);					                 
			}
		}
		
		// From/To 이송계획 및 비용상세 비교 조회 (EES_EQR_0135) 
	    if (e.getEventName().equalsIgnoreCase("EesEqr0135Event")) {				
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchRepoPlanAndCostFromToDetail(e);
			}
		}
		
	    // 이송계획 및 비용상세 비교 조회 (EES_EQR_0070) 
        if (e.getEventName().equalsIgnoreCase("EesEqr0070Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchRepoPlanAndCostDetail(e);
			}
		}	

		// ETS <-> EQR OffHire Return
		if(e.getEventName().equalsIgnoreCase("EtsEqr0001Event")){
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyOffHireReturnFromETS(e);
			}	
		}

		// EQR All-Weeks' Plan Access Grant
		if (e.getEventName().equalsIgnoreCase("EesEqr0143Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {			// Retrieve 버튼 클릭시
				eventResponse = searchEqrAllWeeksPlanAccessGrant();
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {			// Save 버튼 클릭시
				eventResponse = modifyEqrAllWeeksPlanAccessGrant(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {			// User ID 입력시 (OnChange)
				eventResponse = searchEqrAllWeeksPlanAccessGrantUserInfo(e);
			}
		}
		
	    // Empty Repo Result (EES_EQR_0144) 
        if (e.getEventName().equalsIgnoreCase("EesEqr0144Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchEmptyRepoResult(e);
			}
		}

		return eventResponse;
	}
	
	/**
	 * [EES_EQR_0059 : User 화면권한, 지역정보 확인 ]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse configUserAuthLocation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0059Event event = (EesEqr0059Event)e;
		EesEqr0059ConditionVO conditionVO = new EesEqr0059ConditionVO();
		conditionVO = event.getEesEqr0059ConditionVO();
		CommonBCImpl commonImpl = new CommonBCImpl();
		
		String office_code = event.getSignOnUserAccount().getOfc_cd();
		String user_id     = event.getSignOnUserAccount().getUsr_id();
		
		String[] eqr_auth 		= new String[9];
		
		String user_level       	= null; // USER LEVEL 1, 2, 3, 4, 5
        String user_search_div  	= null; // ALL(모든지역), RCC, LCC
        String user_modify_div  	= null; // ALL(모든지역), RCC, LCC
        String user_search_location = null; // "", RCC, LCC
        String user_modify_location = null; // "", RCC, LCC
        
        String user_access          = null; // 전주차 접근가능한 유저인지 확인 (TRUE - 전주차 접근가능, FALSE - 전주차 접근불가)

		try{			
			eqr_auth[0] = Boolean.toString(event.getSignOnUserAccount().isUserAuth("EQR01"));
	        eqr_auth[1] = Boolean.toString(event.getSignOnUserAccount().isUserAuth("EQR02"));
	        eqr_auth[2] = Boolean.toString(event.getSignOnUserAccount().isUserAuth("EQR03"));
	        eqr_auth[3] = Boolean.toString(event.getSignOnUserAccount().isUserAuth("EQR04"));
	        eqr_auth[4] = Boolean.toString(event.getSignOnUserAccount().isUserAuth("EQR05"));
	        eqr_auth[5] = Boolean.toString(event.getSignOnUserAccount().isUserAuth("EQR06"));
	        eqr_auth[6] = Boolean.toString(event.getSignOnUserAccount().isUserAuth("EQR07"));
	        eqr_auth[7] = Boolean.toString(event.getSignOnUserAccount().isUserAuth("EQR08"));
	        
	        /*
	        CSR NO : N200901080009
	        added by shin yongchan - 20090112
	        EQR09 신규 생성 - Execution Plan 메뉴만 접근가능
	                       - 전지역에 대해 bkg / s/o cre 기능 가짐
	                       - SENCO office user들은 위한 권한 
	        */                
	        eqr_auth[8] = Boolean.toString(event.getSignOnUserAccount().isUserAuth("EQR09"));
	        
	        /*
	          CSR NO : N200901080009
	          modified by shin yongchan - 20090112
	          EQR09 신규 생성 - Execution Plan 메뉴만 접근가능
	                         - 전지역에 대해 bkg / s/o cre 기능 가짐
	                         - SENCO office user들은 위한 권한 	         * 
	         * eqr_auth[0]==true || eqr_auth[6]==true || eqr_auth[8]==true	----> LEVEL 1  조회, 수정  [모든지역 조회, 모든지역 수정  ]
	         * eqr_auth[7]==true                         					----> LEVEL 2  조회, 수정  [해당 RCC 조회, 해당 RCC 수정 ]
	         * eqr_auth[4]==true                         					----> LEVEL 3  조회        [해당 RCC 조회 ]
	         * eqr_auth[3]==true                         					----> LEVEL 4  조회        [모든지역 조회  ]                                                                                                   
	         * eqr_auth[1]==true || eqr_auth[2]==true || eqr_auth[5]==true  ----> LEVEL 5  조회, 수정  [해당 RCC 조회, 해당 LCC 수정 ]                                                                                                   
	         */	              
	        if(eqr_auth[0].equals("true") || eqr_auth[6].equals("true") || eqr_auth[8].equals("true") ) {
	        	user_level        		= "1";   
	        	user_search_div 		= "ALL"; // ALL
	        	user_search_location    = "";	 // 모든지역 조회    
	        	user_modify_div 		= "ALL"; // ALL
	        	user_modify_location    = "ALL";	 // 모든지역 수정

	        }else if(eqr_auth[7].equals("true")) {
	        	user_level        		= "2";   
	        	user_search_div 		= "RCC"; // RCC
	        	user_search_location    = commonImpl.getUserLocInfo(office_code, "R").getResultString();	// user별 office code의 RCC 
	        	user_modify_div 		= "RCC"; // RCC
	        	user_modify_location    = commonImpl.getUserLocInfo(office_code, "R").getResultString();	// user별 office code의 RCC 
	        	
	        }else if(eqr_auth[4].equals("true")) {
	        	user_level        		= "3";   
	        	user_search_div 		= "RCC"; // ALL
	        	user_search_location    = commonImpl.getUserLocInfo(office_code, "R").getResultString();	// user별 office code의 RCC 
	        	user_modify_div 		= ""; // 수정못함
	        	user_modify_location    = ""; // 수정못함
	        }else if(eqr_auth[3].equals("true")) {
	        	user_level        		= "4";   
	        	user_search_div 		= "ALL"; // ALL
	        	user_search_location    = "";    // 모든지역
	        	user_modify_div 		= "";    // 수정못함
	        	user_modify_location    = "";    // 수정못함
	        }else {      // 나머지 모든 user,  eqr_auth[1]==true || eqr_auth[2]==true || eqr_auth[5]==true
	        	user_level        		= "5";   
	        	user_search_div 		= "RCC"; // RCC
	        	user_search_location    = commonImpl.getUserLocInfo(office_code, "R").getResultString();	// user별 office code의 RCC    
	        	user_modify_div 		= "LCC"; // LCC
	        	user_modify_location    = commonImpl.getUserLocInfo(office_code, "L").getResultString();	// user별 office code의 LCC   
			}
	        
	        user_access = commonImpl.checkFullAccessUser(user_id).getResultString();	// 특정 user가 059,080,081,083 에서 전주차 접근권한을 가진유저인지 확인
	        	        
	        conditionVO.setUserLevel(user_level);
	        conditionVO.setUserModifyDiv(user_modify_div);
	        conditionVO.setUserModifyLocation(user_modify_location);
	        conditionVO.setUserSearchDiv(user_search_div);
	        conditionVO.setUserSearchLocation(user_search_location);
	        conditionVO.setUserFullAccess(user_access);  // 전주차접근 가능한 유저인지 확인
	        
	        event.setEesEqr0059ConditionVO(conditionVO);
	        
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
	 * EES_EQR_0059 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMaxRepoPlanId(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0059Event event = (EesEqr0059Event)e;
		CommonBCImpl commonImpl = new CommonBCImpl();
		EesEqr0059ConditionVO conditionVO = event.getEesEqr0059ConditionVO();
		
		try{
			String[] result = commonImpl.searchMaxRepoPlanId().getResultStrArray();
			
			conditionVO.setYyyyww(result[0]);
			conditionVO.setSeq(result[1]);
			
			event.setEesEqr0059ConditionVO(conditionVO);
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
	 * EES_EQR_0059 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTrunkVesselAndFeederCntrRepoPlan(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0059Event event = (EesEqr0059Event)e;
		CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
		CommonBCImpl commonImpl = new CommonBCImpl();
		EesEqr0059ConditionVO conditionVO = new EesEqr0059ConditionVO();
		conditionVO = event.getEesEqr0059ConditionVO();
		List<AbstractValueObject> rsVoList = new ArrayList<AbstractValueObject>();
		
		String userEcc	= "";
		String fromEcc	= "";
		String toEcc	= "";
		
		// execute 작업이 가능한 2개주 --> 5개주로 확장(2012.06.05, 신용찬)
		String repoPlnWeek = "";  //repo plan week +0주차
		repoPlnWeek = conditionVO.getRepoPlnId().toString();
		repoPlnWeek = (!repoPlnWeek.equals("")) ? repoPlnWeek.substring(4,10) : "";
		
		String repoPlnNextWeek = ""; // +1주차
//		String repoPlnAfterNextWeek = ""; // +2주차

		String repoPlnWeek_One   = "";  // +1주차
		String repoPlnWeek_Two   = "";  // +2주차
		String repoPlnWeek_Three = "";  // +3주차
		String repoPlnWeek_Four  = "";  // +4주차
		
		try{
			// USER 별 059화면에 대한 조회영역 조회 (매우 중요) 
	        userEcc = getUserEccWhere(conditionVO.getUserLevel(), conditionVO.getUserSearchLocation());
	        
	        if(conditionVO.getFmtoat().equals("1")) {  // FM TO
				fromEcc = commonImpl.convertECCInfoString(conditionVO.getFromstatus(), conditionVO.getFromlocation()).getResultString();
				toEcc   = commonImpl.convertECCInfoString(conditionVO.getTostatus(),   conditionVO.getTolocation()).getResultString();
	        //CSR No:N200906040080 의거 Fm ETD, To ETA 조건 추가 
			} else if (conditionVO.getFmtoat().equals("3")){  //Fm ETD 
				fromEcc = commonImpl.convertECCInfoString(conditionVO.getFromstatus(), conditionVO.getFromlocation()).getResultString();
				toEcc   = commonImpl.convertECCInfoString(conditionVO.getTostatus(),   conditionVO.getTolocation()).getResultString();		
	        } else if (conditionVO.getFmtoat().equals("4")){  //To ETA
				fromEcc = commonImpl.convertECCInfoString(conditionVO.getFromstatus(), conditionVO.getFromlocation()).getResultString();
				toEcc   = commonImpl.convertECCInfoString(conditionVO.getTostatus(),   conditionVO.getTolocation()).getResultString();
	        } else {                               // AT
				fromEcc = commonImpl.convertECCInfoString(conditionVO.getAtstatus(), conditionVO.getAtlocation()).getResultString();
			}
	        
	        conditionVO.setUserEcc(userEcc);
	        conditionVO.setFromEcc(fromEcc);
	        conditionVO.setToEcc(toEcc);
	        
			CommonRsVO commonRsVO = command.searchTrunkVesselAndFeederCntrRepoPlan(conditionVO);
			CommonRsVO resultVO = new CommonRsVO();
			resultVO.setConditionVO(conditionVO);
			resultVO.setDbRowset( commonRsVO.getDbRowset() );
			
			rsVoList.add(resultVO);
			eventResponse.setRsVoList(rsVoList);
			
			repoPlnNextWeek      = commonImpl.getNextPrevWeek(repoPlnWeek, 1, "NEXT").getResultString();  // repoPlnWeek의 1주 미래주 정보 
//			repoPlnAfterNextWeek = commonImpl.getNextPrevWeek(repoPlnWeek, 2, "NEXT").getResultString();  // repoPlnWeek의 2주 미래주 정보 

			repoPlnWeek_One   = commonImpl.getNextPrevWeek(repoPlnWeek, 1, "NEXT").getResultString();  // repoPlnWeek의 1주 미래주 정보 
			repoPlnWeek_Two   = commonImpl.getNextPrevWeek(repoPlnWeek, 2, "NEXT").getResultString();  // repoPlnWeek의 2주 미래주 정보 
			repoPlnWeek_Three = commonImpl.getNextPrevWeek(repoPlnWeek, 3, "NEXT").getResultString();  // repoPlnWeek의 3주 미래주 정보 
			repoPlnWeek_Four  = commonImpl.getNextPrevWeek(repoPlnWeek, 4, "NEXT").getResultString();  // repoPlnWeek의 4주 미래주 정보 
			
			// 작업이 가능한 repo plan week,  그다음 주차 
			conditionVO.setRepoPlnWeek(repoPlnWeek);
			conditionVO.setRepoPlnNextWeek(repoPlnNextWeek);
			
			//2012.06.05 신용찬 [CHM-201218172]     T.VVD & D.VVD의 VL ADD 기간을 +0,+1,+2,+3,+4 WEEK 까지 확장				
			eventResponse.setETCData("t1_plnWeek", repoPlnWeek);
//			eventResponse.setETCData("t1_plnNextWeek",repoPlnNextWeek);
//			eventResponse.setETCData("t1_plnAfterNextWeek",repoPlnAfterNextWeek);
			eventResponse.setETCData("t1_plnWeek_One",  repoPlnWeek_One);
			eventResponse.setETCData("t1_plnWeek_Two",  repoPlnWeek_Two);
			eventResponse.setETCData("t1_plnWeek_Three",repoPlnWeek_Three);
			eventResponse.setETCData("t1_plnWeek_Four", repoPlnWeek_Four);
			
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
	 * EES_EQR_0059 : [VD Add시 Bkg No. 조회]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTrunkVesselAndFeederCntrRepoPlanBKGNO(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0059Event event = (EesEqr0059Event)e;
		CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
		EesEqr0059ConditionVO conditionVO = new EesEqr0059ConditionVO();
		conditionVO = event.getEesEqr0059ConditionVO();
		
		List<AbstractValueObject> rsVoList = new ArrayList<AbstractValueObject>();
		CommonRsVO commonRsVO = new CommonRsVO();
		
		String currentWeek	= "";
		String prevWeek		= "";
		
		try{
			CommonBCImpl commonImpl = new CommonBCImpl();
			
			/*
			* 1. CSR NO : N200905060050
			*    수정자  : 신용찬 - 2009.05.06	
			*    내용    : &repoPlnWeek="+repoPlnWeek+" 항목 추가 (SPLIT BOOKING 대상 조회 WEEK 시작주차 기준 변경) - 계은영 요청 
			*/
			currentWeek		= conditionVO.getRepoPlnWeek();
			
			// modified by shin yongchan 20071105 - confirmed by whang youngsin
			//prevWeek = commonImpl.getNextPrevWeek(currentWeek, 9, "PREV");  // 현재주 포함한 과거 10번째 주차
			//prevWeek = commonImpl.getNextPrevWeek(currentWeek, 14, "PREV");  // 현재주 포함한 과거 15번째 주차
			// modified by shin yongchan - 20080129
			// CSR NO : R200801154869
			prevWeek = commonImpl.getNextPrevWeek(currentWeek, 19, "PREV").getResultString();  // 현재주 포함한 과거 20번째 주차
			
			conditionVO.setCurrentWeek(currentWeek);
			conditionVO.setPrevWeek(prevWeek);
			
			event.setEesEqr0059ConditionVO(conditionVO);
			
			commonRsVO	= command.searchTrunkVesselAndFeederCntrRepoPlanBKGNO(event.getEesEqr0059ConditionVO());
			CommonRsVO resultVO = new CommonRsVO();
			resultVO.setConditionVO(conditionVO);
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
	 * EES_EQR_0059 : [VD Add시 Bkg No. 조회]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTrunkVesselAndFeederCntrRepoPlanBKGNOInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0059Event event = (EesEqr0059Event)e;
		CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
		EesEqr0059ConditionVO conditionVO = new EesEqr0059ConditionVO();
		conditionVO = event.getEesEqr0059ConditionVO();
		
		List<AbstractValueObject> rsVoList = new ArrayList<AbstractValueObject>();
		CommonRsVO commonRsVO = new CommonRsVO();
		
		try{
			commonRsVO	= command.searchTrunkVesselAndFeederCntrRepoPlanBKGNOInfo(event.getEesEqr0059ConditionVO());
			CommonRsVO resultVO = new CommonRsVO();
			resultVO.setConditionVO(conditionVO);
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
	 * [ EES_EQR_0059 & EES_EQR_0080 : MTY BKG Create ]<br>
	 * BKG/DOC에 운송에 대한 기본정보를 넘긴후 BKG NO 를 받아서 EQR에 저장
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createRepoBKG(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();

		BookingUtil bookingUtil = new BookingUtil();
		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		CommonVO commonVO = new CommonVO();
		MtyBookingCreateVO mtyBookingCreateVO = new MtyBookingCreateVO();
		BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
		EesEqr0059ConditionVO eesEqr0059ConditionVO = null;
		
		String[] table_name = new String[1];
		String gubun	= new String();
		
		if ( e.getEventName().equals("EesEqr0059Event") ) 		gubun = "V";	// Vessel
		else if ( e.getEventName().equals("EesEqr0080Event") )	gubun = "W";	// Water
		
		commonVO.setGubun(gubun);
		
		try {
			begin();
			
			if ( gubun.equals("V") ){
				EesEqr0059Event event = (EesEqr0059Event)e;
				commonVO.setResultVo(event.getEesEqr0059MultiVOs());				
				command.modifyTrunkVesselAndFeederCntrRepoPlan((EesEqr0059MultiVO[]) commonVO.getResultVo(), account);
				table_name[0]	= "EQR_VSL_LODG_DCHG_EXE_PLN";
			} else if ( gubun.equals("W") ){
				EesEqr0080Event event = (EesEqr0080Event)e;
				commonVO.setResultVo(event.getEesEqr0080MultiVOS());
				eesEqr0059ConditionVO = event.getEesEqr0059ConditionVO();
				command.modifyTruckAndRailAndBargeCntrRepoPlan(eesEqr0059ConditionVO, (EesEqr0080MultiVO[]) commonVO.getResultVo(), account);
				table_name[0]	= "EQR_INLND_TRSP_EXE_PLN";
			}
			
			// BKG NO 생성 로직 시작
			// 1. BKG No. 생성
			mtyBookingCreateVO = command.createRepoBKG(commonVO, account);    // BKG/DOC 생성하기위해 필요한 기본정보를 조회한후 BKG VO 에 셋팅해 주는 작업
			BkgBlNoVO newBkgNoVO = bookingUtil.manageBkgNumberGeneration("BKG", account.getOfc_cd(), account.getUsr_id());

			String mtyBkgNo = newBkgNoVO.getBkgNo();

			if(mtyBkgNo == null || mtyBkgNo.equals("")) {
				throw new DAOException(new ErrorHandler("EQR10028", "bkg_no is empty").getMessage());
			} else {
				mtyBkgNo	= mtyBkgNo+"00";
			}
			
			bkgBlNoVO.setBkgNo(mtyBkgNo);
			bkgBlNoVO.setBlNo(mtyBkgNo);
			
			mtyBookingCreateVO.setBkgBlNoVO(bkgBlNoVO);
			
			// 2. Mty Booking Data 생성 
			receiptBC.createMtyRepoBooking(mtyBookingCreateVO, account);
	
			// 3. Mty Booking의 Cntr, B/L Data 생성
			BLDocumentationBLBC blDocBC = new BLDocumentationBLBCImpl();
			blDocBC.createMtyRepoBlCntr(mtyBookingCreateVO, account);

			// 4. Booking 쪽 Report에서 속도향상을 위해서 미리 Qty 정보를 가공
			PerformanceReportBC performReportBc = new PerformanceReportBCImpl();
			performReportBc.manageQtyCntrCoposite(mtyBkgNo, "CQ");
			
			log.debug("/n >>>>>>>>>>>>>>>>>>> Origin Bkg NO : " +mtyBkgNo);
			
			// Booking Split
			MtyBkgVO mtyBkgVO = new MtyBkgVO();	
			mtyBkgVO.setMtyBkgNo(mtyBkgNo);
			mtyBkgVO.setUsrId(account.getUsr_id());
			mtyBkgVO.setGubun(gubun);
			mtyBkgVO.setTableName(table_name);
			


			
			command.modifyMtyBkgNo(mtyBkgVO, commonVO);  // BKGDOC 에서 받은 BKG NO를 EQR에 UPDATE
			
	        commit();
		} catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		if ( gubun.equals("V") ){
			return this.searchTrunkVesselAndFeederCntrRepoPlan(e);
		} else if ( gubun.equals("W") ){
			// 저장후 조회로직 호출	
			return this.searchTruckAndRailAndBargeCntrRepoPlan(e);
		}
		return eventResponse;
	}
	/**
	 * [ EES_EQR_0059 : MTY BKG Split Create ]<br>
	 * BKG/DOC에 운송에 대한 BKG NO 정보를 넘긴후 BKG SPLIT NO 를 받아서 EQR에 저장
	 * 059 에서만 SPLIT 하므로 059/080 구분은 없음.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createRepoBKGSplit(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
		EesEqr0059Event event = (EesEqr0059Event)e;
		
		GeneralBookingSplitCombineBC generalBookingSplitCombineBC = new GeneralBookingSplitCombineBCImpl();
		GeneralBookingReceiptBC	generalBookingReceiptBC = new GeneralBookingReceiptBCImpl();
		BLDocumentationBLBC	bLDocumentationBLBC = new BLDocumentationBLBCImpl();
		
		try {
			begin();
			// Split은 한 Row만 가능하므로 MultiVO에서 첫번째 것만 가져와서 사용하도록 함. (중요)
			EesEqr0059MultiVO eesEqr0059MultiVO = ( (EesEqr0059MultiVO[]) event.getEesEqr0059MultiVOs() )[0];
			
			MtyBookingSplitVO mtyBookingSplitVO = new MtyBookingSplitVO();
			BkgBlNoVO orgBkgBlNoVO = new BkgBlNoVO();
			BkgBlNoVO splitBkgBlNoVO = new BkgBlNoVO();
			NewBkgSplitVO newBkgBlNoVO = new NewBkgSplitVO();
			
			
			// 화면에서 넘겨받은 Original Bkg No. Setting..
			orgBkgBlNoVO.setBkgNo(eesEqr0059MultiVO.getMtyBkgNo());
			orgBkgBlNoVO.setBkgNo(eesEqr0059MultiVO.getMtyBkgNo());
			
			
			// ----- BKG/DOC 메소드 호출 시작 ------
			// Original Bkg No.를 BKG/DOC으로 넘겨 Split No. 가져오기..
			splitBkgBlNoVO = generalBookingSplitCombineBC.searchMtySplitBkgNo(orgBkgBlNoVO, account);
			newBkgBlNoVO.setNewBkgNo(splitBkgBlNoVO.getBkgNo());
			newBkgBlNoVO.setNewBlNo(splitBkgBlNoVO.getBkgNo());
			
			eesEqr0059MultiVO.setOldBkgGrpNo(eesEqr0059MultiVO.getMtyBkgNo());
			eesEqr0059MultiVO.setMtyBkgNo(splitBkgBlNoVO.getBkgNo());
	
			mtyBookingSplitVO = command.createRepoBKGSplit(eesEqr0059MultiVO, account);  // BKG/DOC에 넘겨줄 정보를 조회후 VO 셋팅
			mtyBookingSplitVO.setBkgBlNoVO(orgBkgBlNoVO);
			mtyBookingSplitVO.setNewBkgSplitVO(newBkgBlNoVO);

			// Mty Booking을 Split
			generalBookingReceiptBC.splitMtyRepoBooking(mtyBookingSplitVO, account);
				
			// Mty Booking의 Cntr, B/L을 Split
			bLDocumentationBLBC.splitMtyRepoBlCntr(mtyBookingSplitVO, account);
				
			// 추가된 Cntr에 대해서 Qty 계산, Update시 Cntr을 전부 Detach하면 cancel 처리
			generalBookingReceiptBC.completeMtyRepoBkgSplit(mtyBookingSplitVO, account);
			// ----- BKG/DOC 메소드 호출 종료	---		
			
			// 4. Booking 쪽 Report에서 속도향상을 위해서 미리 Qty 정보를 가공
			PerformanceReportBC performReportBc = new PerformanceReportBCImpl();
			
			performReportBc.manageQtyCntrCoposite(splitBkgBlNoVO.getBkgNo(), "CQ");
			performReportBc.manageQtyCntrCoposite(orgBkgBlNoVO.getBkgNo(), "CQ");
			
			
			log.debug("/n >>>>>>>>>>>>>>>>>>> Split  Bkg NO : " +splitBkgBlNoVO.getBkgNo());
			log.debug("/n >>>>>>>>>>>>>>>>>>> Origin Bkg NO : " +orgBkgBlNoVO.getBkgNo());
			
			// EQR VOLUME 변경을 EQR에서 직접 호출(중요)
			// 다른 경우(BKG CREATE, VOLUME CHANGE는 BKG/DOC 에서 직접 호출)
			// Orginal MTY BKG Volume 변경하기.
			MtyBkgVO mtyBkgVO = new MtyBkgVO();
			mtyBkgVO.setMtyBkgNo(orgBkgBlNoVO.getBkgNo());
			mtyBkgVO.setSplitFlg("N");
			mtyBkgVO.setUsrId(account.getUsr_id());
			mtyBkgVO.setEesEqr0059MultiVO(eesEqr0059MultiVO);
			
			// OGR BKG VOLUME, FIXED PLAN VOLUME 볼륨 변경 
			command.modifyMtyBkgVolChange(mtyBkgVO);  

			eventResponse.setUserMessage(new ErrorHandler("SUCCESS").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	

		// 저장후 조회로직 호출	
		return this.searchTrunkVesselAndFeederCntrRepoPlan(e);
	}
	
	/**
	 * [ EES_EQR_0059 : Save ]<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse modifyTrunkVesselAndFeederCntrRepoPlan(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
		EesEqr0059Event event = (EesEqr0059Event)e;
		
		try{
			begin();
			command.modifyTrunkVesselAndFeederCntrRepoPlan(event.getEesEqr0059MultiVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("SUCCESS").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return this.searchTrunkVesselAndFeederCntrRepoPlan(event);
	}
	
	/**
	 * USER 별 조회영역 조회
	 * 
	 * @param user_level
	 * @param user_search_location
	 * @return String
	 * @exception EventException
	 */
	public String getUserEccWhere(String user_level, String user_search_location) throws EventException {
        String userEccWhere = "";
        
		try {			
			CommonBCImpl commonImpl = new CommonBCImpl();
	        /*
	         * eqr_auth[0]==true || eqr_auth[6]==true    ----> 조회, 수정  [모든지역 조회]
	         * eqr_auth[7]==true                         ----> 조회, 수정  [해당 RCC 조회]
	         * eqr_auth[4]==true                         ----> 조회        [해당 RCC 조회]
	         * eqr_auth[3]==true                         ----> 조회        [모든지역 조회]                                                                                                   
	         */	              
	        if(user_level.equals("1")) {
				userEccWhere = "";	  // 모든지역 조회       	

	        }else if(user_level.equals("2")) {
				userEccWhere = commonImpl.convertECCInfoString("R", user_search_location).getResultString();	  // 해당 RCC 조회
				
				// LOCATION CODE를 찾지 못하면 어떤 지역정보도 검색할수 없어야 합니다.
				if(userEccWhere==null || userEccWhere.equals("")) userEccWhere = "NOT EXIST LOCATION";			
	        	
	        }else if(user_level.equals("3")) {
				userEccWhere = commonImpl.convertECCInfoString("R", user_search_location).getResultString();  // 해당 RCC 조회
				
				// LOCATION CODE를 찾지 못하면 어떤 지역정보도 검색할수 없어야 합니다.
				if(userEccWhere==null || userEccWhere.equals("")) userEccWhere = "NOT EXIST LOCATION";			
	        	
	        }else if(user_level.equals("4")) {
				userEccWhere = "";	        	
	        	
	        }else {      //user_level.equals("5")
				userEccWhere = commonImpl.convertECCInfoString("R", user_search_location).getResultString();	  // 해당 RCC 조회
				// LOCATION CODE를 찾지 못하면 어떤 지역정보도 검색할수 없어야 합니다.
				if(userEccWhere==null || userEccWhere.equals("")) userEccWhere = "NOT EXIST LOCATION";			
				
	        }
	        
	        return userEccWhere;

		} catch (Exception ex) {
	        log.error("err "+ex.toString(),ex);
	        throw new EventException(ex.getMessage());
	    }
	}
	
	/**
	 * EesEqr0113Event 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrRepoExecutionPlanEstablish(Event e) throws EventException {		
		EesEqr0113Event event = (EesEqr0113Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();           // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		
		try {
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			List<SearchCntrRepoExecutionPlanEstablishVO> list = command.searchCntrRepoExecutionPlanEstablish(event.getEesEqr0113ConditionVO());
			eventResponse.setRsVoList(list);
			return (eventResponse); 
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 컨테이너 이송 계획 목록 조회 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse searchRepoPlanDtInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0045Event event = (EesEqr0045Event)e;
		CntrRepoPlanManageBC command = new CntrRepoPlanManageBCImpl();

		try{
			List<GetRepoPlanListVO> list = command.searchRepoPlanList(event.getEesEqr0045ConditionVO());
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
	 * 컨테이너 이송 계획 목록 조회 Copy 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse createNewRepoPlanID(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0045Event event = (EesEqr0045Event)e;
		CntrRepoPlanManageBC command = new CntrRepoPlanManageBCImpl();
		EesEqr0045ConditionVO conditionVO = event.getEesEqr0045ConditionVO();

		try{
			begin();
			command.createNewRepoPlanID(conditionVO, account.getUsr_id());
			eventResponse.setUserMessage(new ErrorHandler("SUCCESS").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
		return this.searchRepoPlanDtInfo(e);
	}
	
	/**
	 * 컨테이너 이송 계획 목록 조회 Delete 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse removeRepoPlanID(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0045Event event = (EesEqr0045Event)e;
		CntrRepoPlanManageBC command = new CntrRepoPlanManageBCImpl();
		EesEqr0045ConditionVO conditionVO = event.getEesEqr0045ConditionVO();

		try{
			conditionVO.setCreUsrId(account.getUsr_id());
			
			begin();
			command.removeRepoPlanID(conditionVO);
			eventResponse.setUserMessage(new ErrorHandler("SUCCESS").getUserMessage());
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
	 * TS Guideline PopUp 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse searchTSGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0129Event event = (EesEqr0129Event)e;
		CntrRepoPlanManageBC command = new CntrRepoPlanManageBCImpl();
		EesEqr0129ConditionVO conditionVO  = event.getEesEqr0129ConditionVO();

		try{
			List<SearchTSGuidelineVO> resultVOList = command.searchTSGuideline(conditionVO);

			eventResponse.setRsVoList(resultVOList);
			
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
	 * 컨테이너 이송계획 관리 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse searchForecastedLandInventory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0051Event event = (EesEqr0051Event)e;
		CntrRepoPlanManageBC command = new CntrRepoPlanManageBCImpl();
		EesEqr0051ConditionVO conditionVO  = event.getEesEqr0051ConditionVO();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();

		try{
			CommonRsVO rsVO = command.searchForecastedLandInventory(conditionVO);
			
			if (rsVO.getDbRowset().getRowCount() != 0) {
				rsVO.setConditionVO(conditionVO);
				returnVOList.add(rsVO);
			}

			eventResponse.setRsVoList(returnVOList);
			
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
	 * 컨테이너 이송계획 관리 저장 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse modifyForecastedLandInventory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0051Event event = (EesEqr0051Event)e;
		CntrRepoPlanManageBC command = new CntrRepoPlanManageBCImpl();
		EesEqr0051ConditionVO conditionVO  = event.getEesEqr0051ConditionVO();
		CommonBCImpl commonImpl = new CommonBCImpl();
		
		try{
			begin();
			commonImpl.modifyRepoRmk(conditionVO.getRepoPlnId(), conditionVO.getRepoRmk(), account.getUsr_id());
			
			command.modifyForecastedLandInventory(event.getEqrAddPlnVOS(), account);
			
			eventResponse.setUserMessage(new ErrorHandler("SUCCESS").getUserMessage());
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
	 * 컨테이너 이송계획 관리 Distribution 가능여부 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse searchDtrbForecastedLandInventory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0051Event event = (EesEqr0051Event)e;
		CntrRepoPlanManageBC command = new CntrRepoPlanManageBCImpl();
		
		String dtrbPlnId = "";

		try{
			CommonRsVO rsVO = command.searchDtrbForecastedLandInventory(event.getEesEqr0051ConditionVO());
			
			DBRowSet rowSet = rsVO.getDbRowset();
			if (rowSet != null) {
				while (rowSet.next()) {
					dtrbPlnId = JSPUtil.getNull(rowSet.getString("REPO_PLN_ID"));
				}
			}

			eventResponse.setETCData("dtrbPlnId", dtrbPlnId);
			eventResponse.setETCData("dtrbSearchYN", "Y");
			
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
	 * 컨테이너 이송계획 관리 Distribution 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse dtrbForecastedLandInventory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0051Event event = (EesEqr0051Event)e;
		CntrRepoPlanManageBC command = new CntrRepoPlanManageBCImpl();
		
		try{
			begin();
			command.dtrbForecastedLandInventory(event.getEesEqr0051ConditionVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("SUCCESS").getUserMessage());
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
	 * 최적화된 REPO InOut 계획 수량 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse searchCntrRepoInOutPlanDtInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0052Event event = (EesEqr0052Event)e;
		CntrRepoPlanManageBC command = new CntrRepoPlanManageBCImpl();
		EesEqr0052ConditionVO conditionVO = event.getEesEqr0052ConditionVO();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();

		try{
			CommonRsVO rsVO = command.searchCntrRepoInOutPlanDtInfo(conditionVO);
			
			conditionVO.setSearchFlag("1"); // ViewAdapter에서 구분하기 위한 Flag 변수를 셋팅
			
			if (rsVO.getDbRowset().getRowCount() != 0) {
				returnVOList.add(conditionVO);
				returnVOList.add(rsVO);
			}

			eventResponse.setRsVoList(returnVOList);
			
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
	 * 최적화된 REPO InOut 계획 수량 VVD 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse searchCntrRepoInOutPlanLaneInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0052Event event = (EesEqr0052Event)e;
		CntrRepoPlanManageBC command = new CntrRepoPlanManageBCImpl();
		EesEqr0052ConditionVO conditionVO = event.getEesEqr0052ConditionVO();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();

		try{
			List<SearchCntrRepoInOutPlanLaneVO> rsVO = command.searchCntrRepoInOutPlanLaneInfo(conditionVO);
			
			conditionVO.setSearchFlag("2"); // ViewAdapter에서 구분하기 위한 Flag 변수를 셋팅
			
			returnVOList.add(conditionVO);
			returnVOList.addAll(rsVO);

			eventResponse.setRsVoList(returnVOList);
			eventResponse.setETCData("rowSearchCol", conditionVO.getCol());
			
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
	 * 최적화된 REPO InOut 계획 수량 LOC 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse searchCntrRepoInOutPlanVvdInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0052Event event = (EesEqr0052Event)e;
		CntrRepoPlanManageBC command = new CntrRepoPlanManageBCImpl();
		EesEqr0052ConditionVO conditionVO = event.getEesEqr0052ConditionVO();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();

		try{
			List<SearchCntrRepoInOutPlanVVDVO> rsVO = command.searchCntrRepoInOutPlanVvdInfo(conditionVO);
			
			if ("vvd".equals(conditionVO.getCol())) {
				conditionVO.setSearchFlag("3"); // ViewAdapter에서 구분하기 위한 Flag 변수를 셋팅
			} else {
				conditionVO.setSearchFlag("4"); // ViewAdapter에서 구분하기 위한 Flag 변수를 셋팅
			}
			
			returnVOList.add(conditionVO);
			returnVOList.addAll(rsVO);

			eventResponse.setRsVoList(returnVOList);
			eventResponse.setETCData("rowSearchCol", conditionVO.getCol());
			
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
	 * 최적화된 REPO InOut 계획 수량 수정 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse modifyCntrRepoInOutPlanDtInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0052Event event = (EesEqr0052Event)e;
		CntrRepoPlanManageBC command = new CntrRepoPlanManageBCImpl();
		EesEqr0052ConditionVO conditionVO  = event.getEesEqr0052ConditionVO();
		CommonBCImpl commonImpl = new CommonBCImpl();
		
		try{
			begin();
			commonImpl.modifyRepoRmk(conditionVO.getRepoPlnId(), conditionVO.getRepoRmk(), account.getUsr_id());
			
			command.modifyCntrRepoInOutPlanDtInfo(event.getEesEqr0052MultiVOS(), account.getUsr_id());
			
			eventResponse.setUserMessage(new ErrorHandler("SUCCESS").getUserMessage());
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
	 * 컨테이너 수급 예측실적 및 정확도(On-Hire) Sheet1 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse searchCntrOnHireRepoPlanDtInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0053Event event = (EesEqr0053Event)e;
		CntrRepoPlanManageBC command = new CntrRepoPlanManageBCImpl();
		EesEqr0053ConditionVO conditionVO = event.getEesEqr0053ConditionVO();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();

		try{
			CommonRsVO rsVO = command.searchCntrOnHireRepoPlanDtInfo(conditionVO);
			
			if (rsVO.getDbRowset().getRowCount() != 0) {
				conditionVO.setSheetFlg("1");
				returnVOList.add(conditionVO);
				returnVOList.add(rsVO);
			}

			eventResponse.setRsVoList(returnVOList);
			
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
	 * 컨테이너 수급 예측실적 및 정확도(On-Hire) Sheet2 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse searchOnHireApproval(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0053Event event = (EesEqr0053Event)e;
		CntrRepoPlanManageBC command = new CntrRepoPlanManageBCImpl();
		EesEqr0053ConditionVO conditionVO = event.getEesEqr0053ConditionVO();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();

		try{
			List<SearchCntrOnHireApprovalVO> voList = command.searchOnHireApproval(conditionVO);
			
			if (voList.size() > 0) {
				conditionVO.setSheetFlg("2");
				returnVOList.add(conditionVO);
				returnVOList.addAll(voList);
			}

			eventResponse.setRsVoList(returnVOList);
			
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
	 * 컨테이너 수급 예측실적 및 정확도(On-Hire) 수정 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse modifyCntrOnHireRepoPlanDtInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0053Event event = (EesEqr0053Event)e;
		CntrRepoPlanManageBC command = new CntrRepoPlanManageBCImpl();
		EesEqr0053ConditionVO conditionVO  = event.getEesEqr0053ConditionVO();
		CommonBCImpl commonImpl = new CommonBCImpl();
		
		try{
			begin();
			commonImpl.modifyRepoRmk(conditionVO.getRepoPlnId(), conditionVO.getRepoRmk(), account.getUsr_id());
			
			command.modifyCntrOnHireRepoPlanDtInfo(event.getEesEqr0053MultiVOS(), account.getUsr_id());
			
			eventResponse.setUserMessage(new ErrorHandler("SUCCESS").getUserMessage());
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
	 * 컨테이너 수급 예측실적 및 정확도(Off-Hire) 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse searchCntrOffHireRepoPlanDtInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0054Event event = (EesEqr0054Event)e;
		CntrRepoPlanManageBC command = new CntrRepoPlanManageBCImpl();
		EesEqr0054ConditionVO conditionVO = event.getEesEqr0054ConditionVO();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();

		try{
			CommonRsVO rsVO = command.searchCntrOffHireRepoPlanDtInfo(conditionVO);
			
			if (rsVO.getDbRowset().getRowCount() != 0) {
				returnVOList.add(conditionVO);
				returnVOList.add(rsVO);
			}

			eventResponse.setRsVoList(returnVOList);
			
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
	 * 컨테이너 수급 예측실적 및 정확도(Off-Hire) 수정 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse modifyCntrOffHireRepoPlanDtInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0054Event event = (EesEqr0054Event)e;
		CntrRepoPlanManageBC command = new CntrRepoPlanManageBCImpl();
		
		try{
			begin();
			command.modifyCntrOffHireRepoPlanDtInfo(event.getEesEqr0053MultiVOS(), account.getUsr_id());
			eventResponse.setUserMessage(new ErrorHandler("SUCCESS").getUserMessage());
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
	 * 컨테이너 수급 예측실적 및 정확도 조회(RLA List) 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse searchRLARepoPlanDtList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0048Event event = (EesEqr0048Event)e;
		CntrRepoPlanManageBC command = new CntrRepoPlanManageBCImpl();
		EesEqr0048ConditionVO conditionVO = event.getEesEqr0048ConditionVO();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();

		try{
			CommonRsVO rsVO = command.searchRLARepoPlanDtList(conditionVO);
			
			if (rsVO.getDbRowset().getRowCount() != 0) {
				returnVOList.add(conditionVO);
				returnVOList.add(rsVO);
			}

			eventResponse.setRsVoList(returnVOList);
			
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
	 * 컨테이너 수급 예측실적 및 정확도 조회(RLA List) 수정 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse modifyRLARepoPlanDtList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0048Event event = (EesEqr0048Event)e;
		CntrRepoPlanManageBC command = new CntrRepoPlanManageBCImpl();
		
		try{
			begin();
			command.modifyRLARepoPlanDtList(event.getEesEqr0048MultiVOS(), event.getEesEqr0048ConditionVO(), account.getUsr_id());
			eventResponse.setUserMessage(new ErrorHandler("SUCCESS").getUserMessage());
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
	 * 컨테이너 이송 계획 KPI 요약 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse searchCntrRepoPlanKPISummary(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0071Event event = (EesEqr0071Event)e;
		CntrRepoPlanKpiAnalysisBC command = new CntrRepoPlanKpiAnalysisBCImpl();
		EesEqr0071ConditionVO conditionVO = event.getEesEqr0071ConditionVO();

		try{
			List<SearchCntrPlanKPISummaryVO> returnVOList = command.searchCntrRepoPlanKPISummary(conditionVO);

			eventResponse.setRsVoList(returnVOList);
			
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
	 * Forecasted M/B 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse searchForecastedSeaInventory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0136Event event = (EesEqr0136Event)e;
		CntrRepoPlanKpiAnalysisBC command = new CntrRepoPlanKpiAnalysisBCImpl();
		EesEqr0136ConditionVO conditionVO = event.getEesEqr0136ConditionVO();

		try{
			List<GetForecastedSeaInventoryVO> returnVOList = command.searchForecastedSeaInventory(conditionVO);

			eventResponse.setRsVoList(returnVOList);
			
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
	 * 컨테이너 이송실행 실적 및 Feedback 조회 이벤트 처리 (Sheet1)<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse searchCntrRepoExecutionFeedback(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0063Event event = (EesEqr0063Event)e;
		CntrRepoExecutionFeedbackExamineBC command = new CntrRepoExecutionFeedbackExamineBCImpl();
		EesEqr0063ConditionVO conditionVO = event.getEesEqr0063ConditionVO();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();

		try{
			CommonRsVO rsVO = command.searchCntrRepoExecutionFeedback(conditionVO);
			
			if (rsVO.getDbRowset().getRowCount() != 0) {
				rsVO.setResultString("Sheet1");
				returnVOList.add(rsVO);
			}
			
			eventResponse.setRsVoList(returnVOList);
			
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
	 * 컨테이너 이송실행 실적 및 Feedback 조회 이벤트 처리 (Sheet2)<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse searchCntrRepoExecutionFeedbcakExamine(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0063Event event = (EesEqr0063Event)e;
		CntrRepoExecutionFeedbackExamineBC command = new CntrRepoExecutionFeedbackExamineBCImpl();
		EesEqr0063ConditionVO conditionVO = event.getEesEqr0063ConditionVO();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();

		try{
			CommonRsVO rsVO = command.searchCntrRepoExecutionFeedbcakExamine(conditionVO);
			
			if (rsVO.getDbRowset().getRowCount() != 0) {
				rsVO.setResultString("Sheet2");
				returnVOList.add(rsVO);
			}
			
			eventResponse.setRsVoList(returnVOList);
			
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
	 * 컨테이너 수급 예측실적 및 정확도 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse searchCntrForecastPerformance(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0037Event event = (EesEqr0037Event)e;
		CntrForecastPrecisionManageBC command = new CntrForecastPrecisionManageBCImpl();
		EesEqr0037ConditionVO conditionVO = event.getEesEqr0037ConditionVO();

		try{
			CommonRsVO rsVO = command.searchCntrForecastPerformance(conditionVO);
			
			eventResponse.setRsVo(rsVO.getDbRowset());
			
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
	 * EES_EQR_094Event 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrRepoExecutionPlanCntrList(Event e) throws EventException {		
		EesEqr0094Event event = (EesEqr0094Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();           // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		CommonBCImpl commonImpl = new CommonBCImpl();
		EesEqr0094ConditionVO conditionVO = event.getEesEqr0094ConditionVO();
		try {
			String location_code = commonImpl.getUserLocInfo(event.getSignOnUserAccount().getOfc_cd(), "L").getResultString();	
			conditionVO.setUserLcc(location_code);
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			List<SearchExecutionPlanCntrListVO> list = command.searchCntrRepoExecutionPlanCntrList(conditionVO);
			eventResponse.setRsVoList(list);
			return (eventResponse); 
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * EES_EQR_094Event 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrRepoExecutionPlanCntrInfo(Event e) throws EventException {		
		EesEqr0094Event event = (EesEqr0094Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();           // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		CommonBCImpl commonImpl = new CommonBCImpl();
		EesEqr0094ConditionVO conditionVO = event.getEesEqr0094ConditionVO();
		try {
			String location_code = commonImpl.getUserLocInfo(event.getSignOnUserAccount().getOfc_cd(), "L").getResultString();	
			conditionVO.setUserLcc(location_code);
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			List<SearchExecutionPlanCntrInfoVO> list = command.searchCntrRepoExecutionPlanCntrInfo(conditionVO);
			List<CommonRsVO> retList = new ArrayList<CommonRsVO>();
			CommonRsVO commonRsVO = new CommonRsVO();
			commonRsVO.setResultVOList(list);
			commonRsVO.setConditionVO(conditionVO);
			retList.add(commonRsVO);
			eventResponse.setRsVoList(retList);
			return (eventResponse); 
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	
	/**
	 * EES_EQR_094Event 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrRepoExecutionPlanCntrInfoExcel(Event e) throws EventException {		
		EesEqr0094Event event = (EesEqr0094Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();           // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		CommonBCImpl commonImpl = new CommonBCImpl();
		EesEqr0094ConditionVO conditionVO = event.getEesEqr0094ConditionVO();
		try {
			String location_code = commonImpl.getUserLocInfo(event.getSignOnUserAccount().getOfc_cd(), "L").getResultString();	
			conditionVO.setUserLcc(location_code);
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			List<SearchExecutionPlanCntrInfoExcelVO> list = command.searchCntrRepoExecutionPlanCntrInfoExcel(conditionVO);
			eventResponse.setRsVoList(list);
			return (eventResponse); 
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * EES_EQR_094Event 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCheckCntrInfo(Event e) throws EventException {		
		EesEqr0094Event event = (EesEqr0094Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();           // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		
		try {
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			List<SearchCheckCntrInfoVO> list = command.searchCheckCntrInfo(event.getEesEqr0094ConditionVO());
			eventResponse.setRsVoList(list);
			return (eventResponse); 
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	
	/**
	 * EES_EQR_094Event 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBeforeCntrInfo(Event e) throws EventException {		
		EesEqr0094Event event = (EesEqr0094Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();           // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		CommonBCImpl commonImpl = new CommonBCImpl();
		EesEqr0094ConditionVO conditionVO = event.getEesEqr0094ConditionVO();
		try {
			String location_code = commonImpl.getUserLocInfo(account.getOfc_cd(), "L").getResultString();	
			conditionVO.setUserLcc(location_code);
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			List<SearchBeforeCntrInfoVO> list = command.searchBeforeCntrInfo(conditionVO);
			eventResponse.setRsVoList(list);
			return (eventResponse); 
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * EES_EQR_080Event 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTruckAndRailAndBargeCntrRepoPlan(Event e) throws EventException {		
		EesEqr0080Event event = (EesEqr0080Event)e;        // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();                  // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		CommonRsVO rsVO = null;
		String fromEccWhere = "";
		String toEccWhere = "";
		String userEccWhere     = ""; // user별 office code의 지역정보(LCC)에 할당된 ECC 정보
		EesEqr0059ConditionVO conditionVO = event.getEesEqr0059ConditionVO();
		
		// execute 작업이 가능한 2개주
		String repoPlnWeek = conditionVO.getRepoPlnId();
		repoPlnWeek = repoPlnWeek.substring(4,10);
		String repoPlnWeek_One = "";
		
		try {
			
			CommonBCImpl commonImpl = new CommonBCImpl();

	        // USER 별 059화면에 대한 조회영역 조회 (매우 중요) 
	        userEccWhere = getUserEccWhere(conditionVO.getUserLevel(), conditionVO.getUserSearchLocation());
	        conditionVO.setUserEcc(userEccWhere);
	        if(conditionVO.getFmtoat().equals("1")) {  // FM TO
				fromEccWhere = commonImpl.convertECCInfoString(conditionVO.getFromstatus(), conditionVO.getFromlocation()).getResultString();
				toEccWhere   = commonImpl.convertECCInfoString(conditionVO.getTostatus(),   conditionVO.getTolocation()).getResultString();
				
				//CSR No:N200906040080 의거 Fm ETD, To ETA 조건 추가 
			}else if (conditionVO.getFmtoat().equals("3")){ //Fm ETD
				fromEccWhere = commonImpl.convertECCInfoString(conditionVO.getFromstatus(), conditionVO.getFromlocation()).getResultString();
				toEccWhere   = commonImpl.convertECCInfoString(conditionVO.getTostatus(),   conditionVO.getTolocation()).getResultString();
			}else if (conditionVO.getFmtoat().equals("4")){ //To ETA
				fromEccWhere = commonImpl.convertECCInfoString(conditionVO.getFromstatus(), conditionVO.getFromlocation()).getResultString();
				toEccWhere   = commonImpl.convertECCInfoString(conditionVO.getTostatus(),   conditionVO.getTolocation()).getResultString();
				// CSR No: N200906040080 추가 끝 
				
			}else {                               // AT
				fromEccWhere = commonImpl.convertECCInfoString(conditionVO.getAtstatus(), conditionVO.getAtlocation()).getResultString();
			}
	        conditionVO.setFromEcc(fromEccWhere);
	        conditionVO.setToEcc(toEccWhere);
	        
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			rsVO = command.searchTruckAndRailAndBargeCntrRepoPlan(event.getEesEqr0059ConditionVO());
			repoPlnWeek_One = commonImpl.getNextPrevWeek(repoPlnWeek, 1, "NEXT").getResultString();  // repoPlnWeek의 1주 미래주 정보 
			
			//eventResponse.setRs(commonRsVO.getDbRowset());
			List<CommonRsVO> retList = new ArrayList<CommonRsVO>();
			CommonRsVO commonRsVO = new CommonRsVO();
			commonRsVO.setDbRowset(rsVO.getDbRowset());
			commonRsVO.setConditionVO(conditionVO);
			retList.add(commonRsVO);
			eventResponse.setRsVoList(retList);
			eventResponse.setETCData("t2_plnWeek",repoPlnWeek);
			eventResponse.setETCData("t2_plnWeek_One",repoPlnWeek_One);
			
			return (eventResponse); 
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * EES_EQR_080Event 수정 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyTruckAndRailAndBargeCntrRepoPlan(Event e) throws EventException {

		EesEqr0080Event event = (EesEqr0080Event) e;  // PDTO(Data Transfer Object including Parameters)
		String tpszInitial = "";
		EesEqr0059ConditionVO conditionVO = event.getEesEqr0059ConditionVO();
		try {
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			CommonBCImpl commonImpl = new CommonBCImpl();
			tpszInitial = commonImpl.getTpszInitial().getResultString();
			conditionVO.setTpszInitial(tpszInitial);
			begin();
			command.modifyTruckAndRailAndBargeCntrRepoPlan(conditionVO,event.getEesEqr0080MultiVOS(),account);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		// 저장후 조회로직 호출	
		return this.searchTruckAndRailAndBargeCntrRepoPlan(event);
	}

	/**
	 * EES_EQR_080Event 수정 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse soSendTruckAndRailAndBargeCntrRepoPlan(Event e) throws EventException {

		EesEqr0080Event event = (EesEqr0080Event) e;  // PDTO(Data Transfer Object including Parameters)
		String tpszInitial = "";
		EesEqr0059ConditionVO conditionVO = event.getEesEqr0059ConditionVO();
		try {
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			conditionVO.setTpszInitial(tpszInitial);
			begin();
			/*
			 * CSR No : N200807310009
			 * modified by shin yongchan - 20080731
			 * Senator S/O Send 방식변경 EAT --> WTC
			 */
			command.modifyTruckAndRailAndBargeCntrRepoPlan(conditionVO,event.getEesEqr0080MultiVOS(),account);
			
			command.soSendTruckAndRailAndBargeCntrRepoPlan(conditionVO,event.getEesEqr0080MultiVOS(),account);  // EAI SEND
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		// 저장후 조회로직 호출
		//return eventResponse;
		return this.searchTruckAndRailAndBargeCntrRepoPlan(event);
	}	

	/**
	 * EES_EQR_080Event 수정 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse soCancelTruckAndRailAndBargeCntrRepoPlan(Event e) throws EventException {

		EesEqr0080Event event = (EesEqr0080Event) e;  // PDTO(Data Transfer Object including Parameters)
		EesEqr0059ConditionVO conditionVO = event.getEesEqr0059ConditionVO();
		try {
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			
			begin();
			command.modifyTruckAndRailAndBargeCntrRepoPlan(conditionVO,event.getEesEqr0080MultiVOS(),account);
			/*
			 * CSR No : N200807310009
			 * modified by shin yongchan - 20080731
			 * Senator S/O Send, S/O Cancel 방식변경 EAT --> WTC
			 */		
			// -- START --		
			command.soCancelTruckAndRailAndBargeCntrRepoPlan(conditionVO,event.getEesEqr0080MultiVOS(),account);  // EAI
			// -- END --
			
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		// 저장후 조회로직 호출	
		return this.searchTruckAndRailAndBargeCntrRepoPlan(event);
	}		
	/**
	 * EES_EQR_108Event 수정 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyCombineExecution(Event e) throws EventException {

		EesEqr0108Event event = (EesEqr0108Event) e;  // PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 			// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			
			begin();
			command.modifyCombineExecution(event.getConditionVO() , event.getEesEqr0108MultiVOS() , account);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}
	
	/**
	 * EES_EQR_0130 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrRepoExecutionPlanBkgNoInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0130Event event = (EesEqr0130Event)e;
		CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
		
		SearchExecutionPlanBkgNoVO searchExecutionPlanBkgNoVO = new SearchExecutionPlanBkgNoVO();
		String bkg_no = event.getConditionVO().getBkgNo();

		try{
			List<SearchExecutionPlanBkgNoVO> list = command.searchCntrRepoExecutionPlanBkgNoInfo(bkg_no);
			if ( list != null && !list.isEmpty()){
				searchExecutionPlanBkgNoVO = list.get(0);
			}
			event.setSearchExecutionPlanBkgNoVO(searchExecutionPlanBkgNoVO);
			eventResponse.setRsVo(searchExecutionPlanBkgNoVO);
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
	 * EES_EQR_0130 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrRepoExecutionPlanSplitCntrList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0130Event event = (EesEqr0130Event)e;
		CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();

		try{
			List<SearchExecutionPlanSplitCntrVO> list = command.searchCntrRepoExecutionPlanSplitCntrList(event.getConditionVO());
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
	 * [ EES_EQR_0139 : EQR Organization Chart - Default ]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEqrOrganizationChartCount() throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();

		try{
			SearchEqrOrganizationVO rsVo = command.searchEqrOrganizationChartCount();
			eventResponse.setRsVo(rsVo);			
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * [ EES_EQR_0139 : EQR Organization Chart - List ]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEqrOrganizationChart() throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();

		try{
			List<SearchEqrOrganizationVO> list = command.searchEqrOrganizationChart();
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
	 * EES_EQR_081Event 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOnHireAndOffHireCntrRepoPlan(Event e) throws EventException {		
		EesEqr0081Event event = (EesEqr0081Event)e;        					// PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();    // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		String fromEccWhere = "";
		//String toEccWhere = "";
		String userEccWhere     = ""; // user별 office code의 지역정보(LCC)에 할당된 ECC 정보
		EesEqr0059ConditionVO conditionVO = event.getEesEqr0059ConditionVO();
		CommonRsVO rsVO = null;
		// execute 작업이 가능한 2개주
		String repoPlnWeek = conditionVO.getRepoPlnId();
		String repoPlnWeek_One = "";
		try {
			repoPlnWeek = repoPlnWeek.substring(4,10);
			
			CommonBCImpl commonImpl = new CommonBCImpl();
			// USER 별 059화면에 대한 조회영역 조회 (매우 중요) 
	        userEccWhere = getUserEccWhere(conditionVO.getUserLevel(), conditionVO.getUserSearchLocation());
	        if(conditionVO.getFmtoat().equals("1")) {  // FM TO TOECC 사용 안합니다.
				fromEccWhere = commonImpl.convertECCInfoString(conditionVO.getFromstatus(), conditionVO.getFromlocation()).getResultString();
				//toEccWhere   = commonImpl.convertECCInfoString(event.getToStatus(),   event.getToLocation());
				
			//CSR No:N200906040080 의거 Fm ETD, To ETA 조건 추가 
			}else if (conditionVO.getFmtoat().equals("3")){  //Fm ETD 
				fromEccWhere = commonImpl.convertECCInfoString(conditionVO.getFromstatus(), conditionVO.getFromlocation()).getResultString();
				
			}else if (conditionVO.getFmtoat().equals("4")){  //To ETA
				fromEccWhere = commonImpl.convertECCInfoString(conditionVO.getFromstatus(), conditionVO.getFromlocation()).getResultString();
			// CSR No: N200906040080 끝
				
			}else {                               // AT 사용 안합니다.
				//fromEccWhere = commonImpl.convertECCInfoString(event.getAtStatus(), event.getAtLocation());
			}
	        conditionVO.setFromEcc(fromEccWhere);
	        conditionVO.setUserEcc(userEccWhere);
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			rsVO = command.searchOnHireAndOffHireCntrRepoPlan(conditionVO);
			
			List<CommonRsVO> retList = new ArrayList<CommonRsVO>();
			CommonRsVO commonRsVO = new CommonRsVO();
			commonRsVO.setDbRowset(rsVO.getDbRowset());
			commonRsVO.setConditionVO(conditionVO);
			retList.add(commonRsVO);
			eventResponse.setRsVoList(retList);
			
			repoPlnWeek_One = commonImpl.getNextPrevWeek(repoPlnWeek, 1, "NEXT").getResultString();  // repoPlnWeek의 1주 미래주 정보
			eventResponse.setETCData("t3_plnWeek",    repoPlnWeek);
			eventResponse.setETCData("t3_plnWeek_One",repoPlnWeek_One);					
			
			return (eventResponse); 
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	} 
	
	/**
	 * EES_EQR_081Event 수정 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyOnHireAndOffHireCntrRepoPlan(Event e) throws EventException {

		EesEqr0081Event event = (EesEqr0081Event) e;  // PDTO(Data Transfer Object including Parameters)
		String tpszInitial = "";
		EesEqr0059ConditionVO conditionVO = event.getEesEqr0059ConditionVO();
		try {
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			// ADD PLAN에 사용될 TPSZ INITIAL
			CommonBCImpl commonImpl = new CommonBCImpl();
			tpszInitial = commonImpl.getTpszInitial().getResultString();
			conditionVO.setTpszInitial(tpszInitial);
			begin();
			command.modifyOnHireAndOffHireCntrRepoPlan(conditionVO,event.getEesEqr0081MultiVOS(),account);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		// 저장후 조회로직 호출	
		return this.searchOnHireAndOffHireCntrRepoPlan(event);
	}			

	/**
	 * EES_EQR_081Event 수정 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse soSendOnHireAndOffHireCntrRepoPlan(Event e) throws EventException {

		EesEqr0081Event event = (EesEqr0081Event) e;  // PDTO(Data Transfer Object including Parameters)
		EesEqr0059ConditionVO conditionVO = event.getEesEqr0059ConditionVO();
		try {
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			
			begin();
			/*
			 * CSR No : N200807310009
			 * modified by shin yongchan - 20080804
			 * Senator S/O Send 방식변경 EAT --> WTC
			 */			
			conditionVO.setTpszInitial("");
			command.modifyOnHireAndOffHireCntrRepoPlan(conditionVO,event.getEesEqr0081MultiVOS(),account);
			command.soSendOnHireAndOffHireCntrRepoPlan(conditionVO,event.getEesEqr0081MultiVOS(),account); 
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		// 저장후 조회로직 호출
		return this.searchOnHireAndOffHireCntrRepoPlan(event);
	}				

	/**
	 * EES_EQR_081Event 수정 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse soCancelOnHireAndOffHireCntrRepoPlan(Event e) throws EventException {

		EesEqr0081Event event = (EesEqr0081Event) e;  // PDTO(Data Transfer Object including Parameters)
		EesEqr0059ConditionVO conditionVO = event.getEesEqr0059ConditionVO();
		try {
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			
			begin();
			/*
			 * CSR No : N200807310009
			 * modified by shin yongchan - 20080731
			 * Senator S/O Send, S/O Cancel 방식변경 EAT --> WTC
			 */		
			conditionVO.setTpszInitial("");
			command.modifyOnHireAndOffHireCntrRepoPlan(conditionVO,event.getEesEqr0081MultiVOS(),account);
			command.soCancelOnHireAndOffHireCntrRepoPlan(conditionVO,event.getEesEqr0081MultiVOS(),account);  // EQR_REPO_EXE_SO_IF
			// -- END --
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		// 저장후 조회로직 호출	
		return this.searchOnHireAndOffHireCntrRepoPlan(event);
	}				

	/**
	 * EES_EQR_081Event 수정 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyOffHireReturnFromETS(Event e) throws EventException {

		EtsEqr0001Event event = (EtsEqr0001Event) e;  // PDTO(Data Transfer Object including Parameters)
		ModifyFromTrsOffHireReturnVO offHireReturnModify = event.getModifyFromTrsOffHireReturnVO();
		ModifyFromTrsOffHireReturnVO retVal = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			
			begin();
			retVal = command.modifyFromTrsOffHireReturn(offHireReturnModify, account);
			eventResponse.setRsVo(retVal);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}				
	
	
	/**
	 * EES_EQR_131Event eMail  Send처리.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse sendEmail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0131Event event = (EesEqr0131Event) e;
		EesEqr0131ConditionVO conditionVO = event.getEesEqr0131ConditionVO();
		try {
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			
			begin();
			command.sendEmail(conditionVO, account);
			eventResponse.setCustomData("sendMode", "email");
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * EES_EQR_131Event  Fax Send처리.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse sendFax(Event e) throws EventException {	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0131Event event = (EesEqr0131Event) e;
		EesEqr0131ConditionVO conditionVO = event.getEesEqr0131ConditionVO();
		try {
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			
			begin();
			command.sendFax(conditionVO, account);
			eventResponse.setCustomData("sendMode", "fax");
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * EES_EQR_132Event 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSenderHistory(Event e) throws EventException {		
		EesEqr0132Event event = (EesEqr0132Event) e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();           // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		List<SearchSendHistoryVO> list = null;
		try {
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			list = command.searchSenderHistory(event.getTarget() , event.getJobCd() , account.getUsr_id());
			eventResponse.setRsVoList(list);
			return (eventResponse); 
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	

	/**
	 * EES_EQR_083Event 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchShuttleCntrRepoPlan(Event e) throws EventException {		
		EesEqr0083Event event = (EesEqr0083Event)e;        // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();                 // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		CommonRsVO rsVO = null;
		String fromEccWhere = "";
		String toEccWhere = "";
		String userEccWhere     = ""; // user별 office code의 지역정보(LCC)에 할당된 ECC 정보
		EesEqr0059ConditionVO conditionVO = event.getEesEqr0059ConditionVO();
			
		try {			
			CommonBCImpl commonImpl = new CommonBCImpl();
			// USER 별 059화면에 대한 조회영역 조회 (매우 중요) 
	        userEccWhere = getUserEccWhere(conditionVO.getUserLevel(), conditionVO.getUserSearchLocation());
			
			if(conditionVO.getFmtoat().equals("1")) {  // FM TO
				fromEccWhere = commonImpl.convertECCInfoString(conditionVO.getFromstatus(), conditionVO.getFromlocation()).getResultString();
				toEccWhere   = commonImpl.convertECCInfoString(conditionVO.getTostatus(),   conditionVO.getTolocation()).getResultString();
				
//				 CSR No : N200906040080로 Fm ETD 조건 추가 
			}else if (conditionVO.getFmtoat().equals("3")){
				fromEccWhere = commonImpl.convertECCInfoString(conditionVO.getFromstatus(), conditionVO.getFromlocation()).getResultString();
				toEccWhere   = commonImpl.convertECCInfoString(conditionVO.getTostatus(),   conditionVO.getTolocation()).getResultString();
            // CSR No : N200906040080로 To ETA 조건 추가 	
			}else if (conditionVO.getFmtoat().equals("4")){
				fromEccWhere = commonImpl.convertECCInfoString(conditionVO.getFromstatus(), conditionVO.getFromlocation()).getResultString();
				toEccWhere   = commonImpl.convertECCInfoString(conditionVO.getTostatus(),   conditionVO.getTolocation()).getResultString();
		    // 	CSR No : N200906040080 추가 끝 	
				
			}else {                               // AT
				fromEccWhere = commonImpl.convertECCInfoString(conditionVO.getAtstatus(), conditionVO.getAtlocation()).getResultString();
			}
						
			conditionVO.setFromEcc(fromEccWhere);
			conditionVO.setToEcc(toEccWhere);
			conditionVO.setUserEcc(userEccWhere);
			
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			rsVO = command.searchShuttleCntrRepoPlan(conditionVO);
			
			List<CommonRsVO> retList = new ArrayList<CommonRsVO>();
			CommonRsVO commonRsVO = new CommonRsVO();
			commonRsVO.setDbRowset(rsVO.getDbRowset());
			commonRsVO.setConditionVO(conditionVO);
			retList.add(commonRsVO);
			eventResponse.setRsVoList(retList);
			
			return (eventResponse); 
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	} 

	/**
	 * EES_EQR_083Event 수정 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyShuttleCntrRepoPlan(Event e) throws EventException {

		EesEqr0083Event event = (EesEqr0083Event)e;        // PDTO(Data Transfer Object including Parameters)		
		EesEqr0059ConditionVO conditionVO = event.getEesEqr0059ConditionVO();
		EesEqr0083MultiVO[] vos = event.getEesEqr0083MultiVOS();
		try {
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			
			begin();
			command.modifyShuttleCntrRepoPlan(conditionVO , vos , account);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		// 저장후 조회로직 호출	
		return this.searchShuttleCntrRepoPlan(event);
	}	

	/**
	 * EES_EQR_083Event 수정 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse soSendShuttleCntrRepoPlan(Event e) throws EventException {

		EesEqr0083Event event = (EesEqr0083Event) e;  // PDTO(Data Transfer Object including Parameters)
		EesEqr0059ConditionVO conditionVO = event.getEesEqr0059ConditionVO();
		EesEqr0083MultiVO[] vos = event.getEesEqr0083MultiVOS();
		try {
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			
			begin();
			
			/*
			 * CSR No : N200807310009
			 * modified by shin yongchan - 20080804
			 * Senator S/O Send 방식변경 EAT --> WTC
			 */						
			//eventResponse = command.modifyShuttleCntrRepoPlan(event);  // EQR_ECC_INTER_EXE_PLN
			//eventResponse = command.soSendShuttleCntrRepoPlan(event);  // EQR_REPO_EXE_SO_IF 입력
			
			command.modifyShuttleCntrRepoPlan(conditionVO , vos , account);
			command.soSendShuttleCntrRepoPlan(conditionVO , vos , account);  // EAI 변경함
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		// 저장후 조회로직 호출
		//return eventResponse;
		return this.searchShuttleCntrRepoPlan(event);
	}			

	/**
	 * EES_EQR_083Event 수정 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse soCancelShuttleCntrRepoPlan(Event e) throws EventException {

		EesEqr0083Event event = (EesEqr0083Event) e;  // PDTO(Data Transfer Object including Parameters)
		EesEqr0059ConditionVO conditionVO = event.getEesEqr0059ConditionVO();
		EesEqr0083MultiVO[] vos = event.getEesEqr0083MultiVOS();
		try {
			CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
			
			begin();
			/*
			 * CSR No : N200807310009
			 * modified by shin yongchan - 20080731
			 * Senator S/O Send, S/O Cancel 방식변경 EAT --> WTC
			 */		
			
			command.modifyShuttleCntrRepoPlan(conditionVO , vos , account);
			command.soCancelShuttleCntrRepoPlan(conditionVO , vos , account);  // EAI 변경함
			// -- END --
			
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		// 저장후 조회로직 호출	
		return this.searchShuttleCntrRepoPlan(event);
	}
	
    /**
	 * EesEqr0074Event 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchKpiAnalysisLoadFactorInfo(Event e) throws EventException {		
		EesEqr0074Event event = (EesEqr0074Event)e; // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();           // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();
		try {
			CntrRepoPlanKpiAnalysisBC command = new CntrRepoPlanKpiAnalysisBCImpl();
			CommonRsVO rsVO = command.searchKpiAnalysisLoadFactorInfo(event.getEesEqr0074ConditionVO());
			returnVOList.add(rsVO);
			eventResponse.setRsVoList(returnVOList);
			return (eventResponse); 
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	/**
	 * [ EES_EQR_0112 : ]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocalForecastedLandInv(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0112Event event = (EesEqr0112Event)e;
		CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();

		try{
			CommonRsVO commonRsVO = command.searchLocalForecastedLandInv(event.getEesEqr0112ConditionVO());
			eventResponse.setRsVo(commonRsVO.getDbRowset());
			
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
	 * EES_EQR_072Event Forecasted M/B 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchForecastedMatchBackInfo(Event e) throws EventException {		
		EesEqr0072Event event = (EesEqr0072Event)e;        // PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();                 // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
	
		try {
			
			CntrRepoPlanKpiAnalysisBC command = new CntrRepoPlanKpiAnalysisBCImpl();
			CommonRsVO commonRsVO = command.searchForecastedMatchBackInfo(event.getEesEqr0072ConditionVO());
			eventResponse.setRsVo(commonRsVO.getDbRowset());
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return (eventResponse); 
	}	
	/**
	 * EES_EQR_0092 : [이벤트]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTotalCntrRepoPlan(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0092Event event = (EesEqr0092Event)e;
		CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
		CommonBCImpl commonImpl = new CommonBCImpl();
		List<AbstractValueObject> rsVoList = new ArrayList<AbstractValueObject>();
		
		String userEcc	= "";
		String fromEcc	= "";
		String toEcc	= "";
		
		try{
			EesEqr0059ConditionVO conditionVO = event.getEesEqr0059ConditionVO();			

			// USER 별 059화면에 대한 조회영역 조회 (매우 중요) 
	        userEcc = getUserEccWhere(conditionVO.getUserLevel(), conditionVO.getUserSearchLocation());
	        
	        if(conditionVO.getFmtoat().equals("1")) {  // FM TO
				fromEcc = commonImpl.convertECCInfoString(conditionVO.getFromstatus(), conditionVO.getFromlocation()).getResultString();
				toEcc   = commonImpl.convertECCInfoString(conditionVO.getTostatus(),   conditionVO.getTolocation()).getResultString();
	        //CSR No:N200906040080 의거 Fm ETD, To ETA 조건 추가 
			} else if (conditionVO.getFmtoat().equals("3")){  //Fm ETD 
				fromEcc = commonImpl.convertECCInfoString(conditionVO.getFromstatus(), conditionVO.getFromlocation()).getResultString();
				toEcc   = commonImpl.convertECCInfoString(conditionVO.getTostatus(),   conditionVO.getTolocation()).getResultString();		
	        } else if (conditionVO.getFmtoat().equals("4")){  //To ETA
				fromEcc = commonImpl.convertECCInfoString(conditionVO.getFromstatus(), conditionVO.getFromlocation()).getResultString();
				toEcc   = commonImpl.convertECCInfoString(conditionVO.getTostatus(),   conditionVO.getTolocation()).getResultString();
	        } else {                               // AT
				fromEcc = commonImpl.convertECCInfoString(conditionVO.getAtstatus(), conditionVO.getAtlocation()).getResultString();
			}
	        
	        conditionVO.setUserEcc(userEcc);
	        conditionVO.setFromEcc(fromEcc);
	        conditionVO.setToEcc(toEcc);
			
			CommonRsVO commonRsVO = command.searchTotalCntrRepoPlan(conditionVO);
			CommonRsVO resultVO = new CommonRsVO();
			resultVO.setConditionVO(conditionVO);
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
	 * [ EES_EQR_0141 : MTY Rail Arrival Inquiry ]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyRailArrival(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0141Event event = (EesEqr0141Event)e;
		CntrForecastPrecisionManageBC command = new CntrForecastPrecisionManageBCImpl();
		
		try{
			MtyRailConditionVO conditionVO = event.getMtyRailConditionVO();
			
			CommonRsVO commonRsVO = command.searchMtyRailArrival(conditionVO);
			eventResponse.setRs(commonRsVO.getDbRowset());		
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
	 * [ EES_EQR_0141 : MTY Rail Arrival Detail ]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyRailDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0141Event event = (EesEqr0141Event)e;
		CntrForecastPrecisionManageBC command = new CntrForecastPrecisionManageBCImpl();
		
		try{
			MtyRailConditionVO conditionVO = event.getMtyRailConditionVO();
			
			List<MtyRailDetailVO> list = command.searchMtyRailArrivalDetail(conditionVO);
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
	 * [ EES_EQR_0141 : MTY Rail Arrival Inquiry ]<br>
	 * 미주지역의 시간을 가져오기 위한 메소드 호출
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyRailArrivalUSTime(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0141Event event = (EesEqr0141Event)e;
		CntrForecastPrecisionManageBC command = new CntrForecastPrecisionManageBCImpl();
		String usTime ="";
		MtyRailConditionVO conditionVO = new MtyRailConditionVO();
		try{
						
			usTime = command.searchMtyRailArrivalUSTime().getResultString();
			conditionVO.setFmDt(usTime);
			event.setMtyRailConditionVO(conditionVO);
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
	 * [ EES_EQR_0142 : MTY Rail Arrival Inquiry ]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyRailResult(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0142Event event = (EesEqr0142Event)e;
		CntrForecastPrecisionManageBC command = new CntrForecastPrecisionManageBCImpl();

		try{ 
			
			CommonRsVO commonRsVO = command.searchMtyRailResult(event.getMtyRailConditionVO());
			List<MtyRailDetailVO> list = command.searchMtyRailResultDetail(event.getMtyRailConditionVO());
			eventResponse.setRs(commonRsVO.getDbRowset());
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
     * EES_EQR_135Event 조회 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
	private EventResponse searchRepoPlanAndCostFromToDetail(Event e) throws EventException {

		EesEqr0135Event event = (EesEqr0135Event) e; 	// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 			// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EesEqr0135ConditionVO conditionVO = event.getEesEqr0135ConditionVO();
		String nextWeek = null;
		String basicWeek= null;
		
		String fromEccWhere 	= "";
		String toEccWhere 		= "";
		try {
			CommonBCImpl commonImpl = new CommonBCImpl();
			
			basicWeek = conditionVO.getYyyyww();
			nextWeek = commonImpl.getNextPrevWeek(basicWeek, 2, "NEXT").getResultString();
			
			conditionVO.setNextWeek(nextWeek);

			if(conditionVO.getFmToAt().equals("1")) {  // FM TO
				fromEccWhere = commonImpl.convertECCInfoString(conditionVO.getFmType(), conditionVO.getFmEccCd()).getResultString();
				toEccWhere   = commonImpl.convertECCInfoString(conditionVO.getToType(), conditionVO.getToEccCd()).getResultString();
			}else {                               // AT
				fromEccWhere = commonImpl.convertECCInfoString(conditionVO.getAtType(), conditionVO.getAtEccCd()).getResultString();
			}
			
			conditionVO.setFromEcc(fromEccWhere);
			conditionVO.setToEcc(toEccWhere);
			
			CntrRepoPlanCompareBCImpl command = new CntrRepoPlanCompareBCImpl();
			CommonRsVO commonRsVO = command.searchRepoPlanAndCostFromToDetail(conditionVO);
			eventResponse.setRs(commonRsVO.getDbRowset());
			
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
     * EES_EQR_0070Event 조회 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
	private EventResponse searchRepoPlanAndCostDetail(Event e) throws EventException {

		EesEqr0070Event event = (EesEqr0070Event) e; 	// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 			// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EesEqr0070ConditionVO conditionVO = event.getEesEqr0070ConditionVO();
		try {
			
			
			CntrRepoPlanCompareBCImpl command = new CntrRepoPlanCompareBCImpl();
			CommonRsVO commonRsVO = command.searchRepoPlanAndCostDetail(conditionVO);
			eventResponse.setRs(commonRsVO.getDbRowset());
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * EQR All-Weeks' Plan Access Grant 조회 이벤트 처리<br>
	 * 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEqrAllWeeksPlanAccessGrant() throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();

		try{
			List<SearchEqrAllWeeksPlanAccessGrantVO> list = command.searchEqrAllWeeksPlanAccessGrant();
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
	 * EQR All-Weeks' Plan Access Grant 수정 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyEqrAllWeeksPlanAccessGrant(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0143Event event = (EesEqr0143Event)e;
		CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
		
		try{
			begin();
			command.modifyEqrAllWeeksPlanAccessGrant(event.getEesEqr0143MultiVOS(), account);
			commit();
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * EQR All-Weeks' Plan Access Grant User Info 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEqrAllWeeksPlanAccessGrantUserInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0143Event event = (EesEqr0143Event)e;
		CommonBCImpl commonImpl = new CommonBCImpl();
		EesEqr0143ConditionVO conditionVO = event.getEesEqr0143ConditionVO();

		try{
			CommonVO commonVO = commonImpl.getUserInfo(conditionVO.getUsrId());
			
			DBRowSet rowSet = commonVO.getDbRowset();
			
			if (rowSet != null) {
				while (rowSet.next()) {
					conditionVO.setUsrNm(rowSet.getString("USR_NM"));
					conditionVO.setOfcCd(rowSet.getString("OFC_CD"));
				}
			}

			eventResponse.setRsVo(conditionVO);
			
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
     * EES_EQR_0144Event 조회 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
	private EventResponse searchEmptyRepoResult(Event e) throws EventException {

		EesEqr0144Event event = (EesEqr0144Event) e; 	// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 			// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EmptyRepoResultOptionVO emptyRepoResultOptionVO = event.getEmptyRepoResultOptionVO();
		try {
			
			
			CntrRepoResultManageBC  command = new CntrRepoResultManageBCImpl();
			CommonRsVO commonRsVO = command.searchEmptyRepoResult(emptyRepoResultOptionVO);
			eventResponse.setRs(commonRsVO.getDbRowset());
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	

}