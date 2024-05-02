/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : GEMCommonSC.java
 *@FileTitle : Expense Office Maintenance
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.17
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.04.17 최정미 , 진윤오
 * 1.0 Creation
 * ----------------------------------------------------
 * History
 * 2011.04.18 [CHM-201108838-01] 이준범
 * Title : OFC code Change 설정 시 Assigned Expense Data 변경 요청
 * DESC  : manageChangeOffice() 추가
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemcommon;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.cps.gem.common.GemUtil;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemclosingschedulemgt.basic.GEMClosingScheduleMgtBC;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemclosingschedulemgt.basic.GEMClosingScheduleMgtBCImpl;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemclosingschedulemgt.event.CpsGem0006Event;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemclosingschedulemgt.vo.MonClzVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemcommon.basic.GEMCommonBC;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemcommon.basic.GEMCommonBCImpl;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemcommon.event.CpsGem1001Event;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemcommon.event.GemCommonEvent;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemcommon.vo.SlipPerfCondVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.basic.GEMMasterCodeMgtBC;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.basic.GEMMasterCodeMgtBCImpl;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.event.CpsGem0007Event;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.event.CpsGem000801Event;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.event.CpsGem000802Event;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.event.CpsGem000803Event;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.event.CpsGem0009Event;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.event.CpsGem0010Event;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.event.CpsGem0011Event;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.event.CpsGem0012Event;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.event.CpsGem0013Event;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.event.CpsGem0030Event;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.event.CpsGem0109Event;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.event.CpsGem0110Event;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.event.CpsGem0111Event;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.event.CpsGem9999Event;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.integration.GEMMasterCodeMgtDBDAO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.ExpenseInfoMgtVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.ExpenseInquiryVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.ExpenseNameVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.GemAcctExptVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.GemAcctMtxVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.GemCngOfcVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.GemExpenseVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.GemOfcHisVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.GemOfficeVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.GemXchRtVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.MdmAccountVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.OfficeExptVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.OfficeInfoVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.OfficeMgtVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.SubsidiaryAccountMatrixInfoVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.XchRtInqVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.basic.GEMPlanningPerformanceBC;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.basic.GEMPlanningPerformanceBCImpl;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.GemSlpIfVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-GEMCommon Business Logic ServiceCommand - NIS2010-GEMCommon 대한 비지니스
 * 트랜잭션을 처리한다. 일반관리비 기준정보 관리
 * 
 * @author choijungmi
 * @see GEMMasterCodeMgtDBDAO
 * @since J2EE 1.4
 */

public class GEMCommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * GEMCommon system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
		}
	}

	/**
	 * GEMPlanningPerformanceSC system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("GEMCommonSC 종료");
	}

	// ************************************************************************************************

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-GEMCommon system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {

		// 이벤트 정보
		EventResponse eventResponse = null;
		// 이벤트 명 취득
		String eventName = e.getEventName();
		// Command 명 취득
		FormCommand cmd = e.getFormCommand();

		// ===========================================================================
		// Common
		// ===========================================================================
		if (e.getEventName().equalsIgnoreCase("GemCommonEvent")) {
			// ---------------------------------------------------------------------------
			// [GEMCommon] Common
			// ---------------------------------------------------------------------------

			// [confirm]
			// [BUOffice]
			if (cmd.isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBUOffice(e);
				// [Level3]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchMajorListByOffice(e);
				// [Level4]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchMinorListByOffice(e);
				// [Level3]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchSubsMajorListByOffice(e);
				// [Level4]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST04)) {
				eventResponse = searchSubsMinorListByOffice(e);

			} else if (cmd.isCommand(FormCommand.SEARCHLIST05)) {
				eventResponse = searchExpenseCdByRole(e);
			}

		}
		// ===========================================================================
		// J.Y.O
		// ===========================================================================
		// ---------------------------------------------------------------------------
		// [CPS_GEM_1001] Admin Page
		// ---------------------------------------------------------------------------
		else if ("CpsGem1001Event".equalsIgnoreCase(eventName)) {

			// [전표 실적,예산 데이타 정규화]
			if (cmd.isCommand(FormCommand.MULTI01)) {
				return modifySlipPerf(e);
				// [전표 누적금액 수정]
			} else if (cmd.isCommand(FormCommand.MULTI02)) {
				return modifyRsltSmryByYrmon(e);
			}

			// ---------------------------------------------------------------------------
			// [CPS_GEM-0009] Foreign Exchange Rate Maintenance
			// ---------------------------------------------------------------------------
		} else if ("CpsGem0009Event".equalsIgnoreCase(eventName)) {

			// [Save]
			if (cmd.isCommand(FormCommand.MULTI)) {
				return manageInitialExchangeRateInfo(e);
				// [Retrieve , Open]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST)) {
				return searchExchangeRateInfo(e);
				// [Grid Row]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				return searchMonthlyExchangeRate(e);
				// [Excel upload]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST02)) {
				return searchCurrencyByOffice(e);
				// [curr_cd check]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST03)) {
				return checkCurrency(e);
			}

			// ---------------------------------------------------------------------------
			// [CPS_GEM-0111] Monthly Accounting Rate Interface
			// ---------------------------------------------------------------------------
		} else if ("CpsGem0111Event".equalsIgnoreCase(eventName)) {
			// [confirm]
			if (cmd.isCommand(FormCommand.ADD)) {
				return manageExchangeRateInterface(e);
			}

			// ---------------------------------------------------------------------------
			// [CPS_GEM-0007] Expense Code Maintenance
			// ---------------------------------------------------------------------------
		} else if ("CpsGem0007Event".equalsIgnoreCase(eventName)) {
			// [Save]
			if (cmd.isCommand(FormCommand.MULTI)) {
				return manageExpenseInfo(e);
				// [Retrieve]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST)) {
				return searchExpenseInfo(e);
				// [Open]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				return open0007(e);
				// [Group Level@CLICK]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST02)) {
				return searchExpenseParentList(e);
				// [Main_Code Matching] Parent@CHANGE
			} else if (cmd.isCommand(FormCommand.SEARCHLIST03)) {
				return searchExpenseName(e);
				// [Grid_Account Information] Account Code@FOCUS_OUT
			} else if (cmd.isCommand(FormCommand.SEARCHLIST04)) {
				return searchAccountName(e);
				// [Grid_Account Information] Deleted Data@CLICK
			} else if (cmd.isCommand(FormCommand.SEARCHLIST05)) {
				return searchAccountInfo(e);
				// [Grid_Divided by Office] Deleted Data@CLICK
			} else if (cmd.isCommand(FormCommand.SEARCHLIST06)) {
				return searchDividedOfficeInfo(e);
				// [Grid_Divided by Office] office@focus out
			} else if (cmd.isCommand(FormCommand.SEARCHLIST07)) {
				return searchOfcCheck(e);
				// [Grid_Divided by Office] account code@focus out
			} else if (cmd.isCommand(FormCommand.SEARCHLIST08)) {
				return searchGenExpnCheck(e);
			}
		}

		// ===========================================================================
		// C.J.M
		// ===========================================================================

		else if (e.getEventName().equalsIgnoreCase("CpsGem0006Event")) {
			// ---------------------------------------------------------------------------
			// [CPS_GEM_0006] Closing Confirmation & Interface Status
			// ---------------------------------------------------------------------------

			// [Save]
			if (cmd.isCommand(FormCommand.MULTI)) {
				eventResponse = manageClosingInfo(e);
				// [Retrive]
			} else if (cmd.isCommand(FormCommand.SEARCH)) {
				eventResponse = searchClosingInfo(e);
				// [G/L I/F Click]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = createSlipClosing(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("CpsGem0010Event")) {
			// ---------------------------------------------------------------------------
			// [CPS_GEM_0010] Expense Code Inquiry
			// ---------------------------------------------------------------------------

			// [confirm]
			// [OPEN]
			if (cmd.isCommand(FormCommand.SEARCH)) {
				eventResponse = searchExpenseInqOpen(e);
				// [Retrieve]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchExpenseInq(e);
				// [Expense]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchExpenseList(e);
				// [Account]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchAccountList(e);
				// [Group Expense]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchGroupExpenseList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("CpsGem0011Event")) {
			// ---------------------------------------------------------------------------
			// [CPS_GEM_0011] Expense Office Inquiry
			// ---------------------------------------------------------------------------

			// [confirm]
			// [OPEN LEVEL2]
			if (cmd.isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBUOffice(e);
				// [Retrieve]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchOfficeInfo(e);
				// [Level3]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchMajorListByOffice(e);
				// [Level4]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchMinorListByOffice(e);
				// [SUMUP OFFICE]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchSumUpListByOffice(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("CpsGem0012Event")) {
			// ---------------------------------------------------------------------------
			// [CPS_GEM_0012] Foreign Exchange Rate Inquiry
			// ---------------------------------------------------------------------------

			// [confirm]
			// [OPEN LEVEL2]
			if (cmd.isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCurrencyList(e);
				// [Retrieve]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchExchangeRateInq(e);
				// [Level3]
			}
		} else if (e.getEventName().equalsIgnoreCase("CpsGem0013Event")) {
			// ---------------------------------------------------------------------------
			// [CPS_GEM_0013] Expense Matrix per Office
			// ---------------------------------------------------------------------------

			// [OPEN LEVEL2]
			if (cmd.isCommand(FormCommand.SEARCH)) {
				eventResponse = searchExpenseMatrixperOffice(e);
				// [Retrieve]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchOfficeExpenseMatrix(e);
				// [Level3]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchMajorListByOffice(e);
				// [Level4]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchMinorListByOffice(e);
				// [Grid Row Click]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchOfficeExpenseMatrixListByExpense(e);
				// [Group Expense]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST04)) {
				eventResponse = searchGroupExpenseList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("CpsGem000801Event")) {
			// ---------------------------------------------------------------------------
			// [CPS_GEM_0008_01] Expense Office Maintenance - Office Code
			// ---------------------------------------------------------------------------

			// [SAVE]
			if (cmd.isCommand(FormCommand.MULTI)) {
				eventResponse = manageOfficeInfo(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("CpsGem0109Event")) {
			// ---------------------------------------------------------------------------
			// [CPS_GEM_0109] Office code history
			// ---------------------------------------------------------------------------

			// [OPEN]
			if (cmd.isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOfficeHistoryInfo(e);
				// [OFC_CODE를 통한 CTR_CODE SEARCH]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchOfficeHistoryInfoByCtrCode(e);
				// [SAVE]
			} else if (cmd.isCommand(FormCommand.MULTI)) {
				eventResponse = manageOfficeHistoryInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("CpsGem000802Event")) {
			// ---------------------------------------------------------------------------
			// [CPS_GEM_0008_02] Expense Office Maintenance - Expense Matrix per
			// Office
			// ---------------------------------------------------------------------------

			// [ROWADD Click시 Expense Code Check]
			if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = checkExpense(e);
				// [SAVE]
			} else if (cmd.isCommand(FormCommand.MULTI)) {
				eventResponse = manageOfficeExpenseMatrix(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("CpsGem0110Event")) {
			// ---------------------------------------------------------------------------
			// [CPS_GEM_0110] Expense Matrix Copy
			// ---------------------------------------------------------------------------

			// [confirm]
			if (cmd.isCommand(FormCommand.MULTI)) {
				eventResponse = createExpenseCopy(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("CpsGem000803Event")) {
			// ---------------------------------------------------------------------------
			// [CPS_GEM_0008_03] Expense Office Maintenance –Office Matrix per
			// Office
			// ---------------------------------------------------------------------------

			// [Open시]
			if (cmd.isCommand(FormCommand.SEARCH)) {
				eventResponse = searchExptListByOffice(e);
				// [Retrive or Delt_flg='Y']
			} else if (cmd.isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchOfficeMatrixListByOffice(e);
				// [Expense Group]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchGroupExpenseList(e);
				// [Expense Code]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchExptListByExpense(e);
				// [Expense Code DupCheck]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchExptListByDupCheck(e);
				// [RowAdd Click시 From~To Office Code 조회]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST04)) {
				eventResponse = searchOfficeMatrixListByRowAdd(e);
				// [SAVE]
			} else if (cmd.isCommand(FormCommand.MULTI)) {
				eventResponse = manageOfficeMatrixListByOffice(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("CpsGem9999Event")) {
			// ---------------------------------------------------------------------------
			// [CPS_GEM_9999] Log in Office Change Management
			// ---------------------------------------------------------------------------

			// [Retrive]
			if (cmd.isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchLogInOfficeChange(e);
				// [Log in Office]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchLogInOfficeChangeByLogOfcCd(e);
				// [Cng Office]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchLogInOfficeChangeByCngOfcCd(e);
				// [Log and Cng DupCheck]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchLogInOfficeChangeByDupOfcCd(e);
				// [SAVE]
			} else if (cmd.isCommand(FormCommand.MULTI)) {
				eventResponse = manageLogInOfficeChange(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("CpsGem0030Event")) {
			// ---------------------------------------------------------------------------
			// [CPS_GEM_0030] Expense Code Maintenance for subsidiary
			// ---------------------------------------------------------------------------
			// [Retrive]
			if (cmd.isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchSubsidiaryAccountMatrixInfo(e);
			}else if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchSubsidiaryAccountCheck(e);
			}else if (cmd.isCommand(FormCommand.MULTI)) {
				eventResponse = manageSubsidiaryAccountMatrixInfo(e);
			}
		}
		return eventResponse;
	}

	// ===========================================================================
	// J.Y.O
	// ===========================================================================

	// ---------------------------------------------------------------------------
	// [CPS_GEM_1001] Admin Page
	// ---------------------------------------------------------------------------

	/**
	 * 전표 실적,예산 데이타 정규화
	 * 
	 * @author JIN YOON OH
	 * @category CPS_GEM_1001
	 * @category modifySlipPerf
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse modifySlipPerf(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();
			CpsGem1001Event event = (CpsGem1001Event) e;
			GEMCommonBC command = new GEMCommonBCImpl();

			SlipPerfCondVO slipPerfCondVO = event.getSlipPerfCondVO();

			int cnt = command.modifySlipPerf(slipPerfCondVO);

			// update 건수
			eventResponse.setETCData("cnt", cnt + "");

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
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}

		return eventResponse;
	}

	/**
	 * 전표 실적,예산 데이타 정규화
	 * 
	 * @author JIN YOON OH
	 * @category CPS_GEM_1001
	 * @category modifyRsltSmryByYrmon
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyRsltSmryByYrmon(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();
			CpsGem1001Event event = (CpsGem1001Event) e;
			GEMCommonBC command = new GEMCommonBCImpl();

			SlipPerfCondVO slipPerfCondVO = event.getSlipPerfCondVO();

			int cnt = command.modifyRsltSmryByYrmon(slipPerfCondVO);

			// update 건수
			eventResponse.setETCData("cnt", cnt + "");

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
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}

		return eventResponse;
	}

	// ---------------------------------------------------------------------------
	// [CPS_GEM-0009] Foreign Exchange Rate Maintenance
	// ---------------------------------------------------------------------------

	/**
	 * 비용계획 및 실적집계시 사용할 환율정보를 조회한다<br>
	 * 비용계획시 사용할 계획환율 정의하고, 실적(전표)집계를 위한 경리환율 정보를 조회한다<br>
	 * 
	 * @author JIN YOON OH
	 * @category CPS_GEM-0009
	 * @category searchExchangeRateInfo
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExchangeRateInfo(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			// 리스트 취득
			List<GemXchRtVO> list = new ArrayList<GemXchRtVO>();

			CpsGem0009Event event = (CpsGem0009Event) e;
			GemXchRtVO vo = event.getGemXchRtVO();

			// 계획년이 존재하지 않을경우 현재년을 입력
			String year = vo.getAcctXchRtYrmon();
			if (year == null || year.trim().length() == 0) {
				year = DateTime.getYear() + "";
			}

			list = command.searchExchangeRateInfo(year, vo.getDeltFlg());

			eventResponse.setRsVoList(list);

			// 반환 객체 설정
			if (list != null && !list.isEmpty()) {
				GemXchRtVO gemXchRtVO = list.get(0);
				String currCd = gemXchRtVO.getCurrCd();
				// USD:KRW설정
				eventResponse.setETCData("usd_krw_xch_rt", gemXchRtVO
						.getUsdKrwXchRt());
				// 월별 환율 조회
				List<GemXchRtVO> list1 = new ArrayList<GemXchRtVO>();
				list1 = command.searchMonthlyExchangeRate(year, currCd);
				eventResponse.setRsVoList(list1);
			}
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * 일반관리비 비용계획시 사용할 계획환율 정의하고 등록 , 수정 , 삭제 한다<br>
	 * 
	 * @author JIN YOON OH
	 * @category CPS_GEM-0009
	 * @category manageInitialExchangeRateInfo
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse manageInitialExchangeRateInfo(Event e)
			throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();

			// ----------------------------------------------
			// 계획 환율 저장 처리
			// ----------------------------------------------
			CpsGem0009Event event = (CpsGem0009Event) e;
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();
			command.manageInitialExchangeRateInfo(event.getGemXchRtVOs(),
					account.getUsr_id());
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
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}

		return eventResponse;
	}

	/**
	 * Currency Code의 월별 환율을 조회<br>
	 * 
	 * @author JIN YOON OH
	 * @category CPS_GEM-0009
	 * @category searchMonthlyExchangeRate
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMonthlyExchangeRate(Event e)
			throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {

			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			// 리스트 취득
			List<GemXchRtVO> list = new ArrayList<GemXchRtVO>();

			CpsGem0009Event event = (CpsGem0009Event) e;

			GemXchRtVO vo = event.getGemXchRtVO();

			list = command.searchMonthlyExchangeRate(vo.getAcctXchRtYrmon(), vo
					.getCurrCd());

			// 반환 객체 설정
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * 1.Excel 로 작성된 계획환율 Upload <br>
	 * 2.Upload 된 Currency Code와 조직별 Currency Code를 비교하여, 누락된 조직별 Currency Code를
	 * 표시한다<br>
	 * 
	 * @author JIN YOON OH
	 * @category CPS_GEM-0009
	 * @category searchCurrencyByOffice
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCurrencyByOffice(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			CpsGem0009Event event = (CpsGem0009Event) e;

			// where in절 만들기
			String inCurrCd = event.getInCurrCd();

			List<String> inCurrCdList = new ArrayList<String>();

			String[] inCurrCds = inCurrCd.split("\\|");

			if (inCurrCd.length() > 0) {

				for (int i = 0; i < inCurrCds.length; i++) {
					inCurrCdList.add(inCurrCds[i]);
				}

				String currCdList = command
						.searchCurrencyByOffice(inCurrCdList);
				// 반환 객체 설정
				eventResponse.setETCData("currCdList", currCdList);

			} else {
				// 반환 객체 설정
				eventResponse.setETCData("currCdList", "");
			}
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * 1.입력된 Currency Code 가 유효한지 체크한다 <br>
	 * 
	 * @author JIN YOON OH
	 * @category CPS_GEM-0009
	 * @category checkCurrency
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse checkCurrency(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {

			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			CpsGem0009Event event = (CpsGem0009Event) e;

			GemXchRtVO vo = event.getGemXchRtVO();
			String errCode = command.checkCurrency(vo.getAcctXchRtYrmon(), vo
					.getCurrCd());

			if ("2".equals(errCode)) {
				// 에러/성공 메세지설정
				eventResponse.setUserMessage(new ErrorHandler("GEM01008")
						.getUserMessage());
			} else if ("3".equals(errCode)) {
				eventResponse.setUserMessage(new ErrorHandler("GEM01009")
						.getUserMessage());
			}

			eventResponse.setETCData("errCode", errCode);
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	// ---------------------------------------------------------------------------
	// [CPS_GEM_0111] Monthly Accounting Rate Interface
	// ---------------------------------------------------------------------------
	/**
	 * 일반관리비 비용실적 집계시 USD , KRW , LCL 로 환산하기 위한 경리환율을 I/F 받아 생성한다 <br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM_0111
	 * @category createExchangeRateInterface
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse manageExchangeRateInterface(Event e)
			throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();

			// ----------------------------------------------
			// 계획 환율 저장 처리
			// ----------------------------------------------
			CpsGem0111Event event = (CpsGem0111Event) e;
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();
			int cnt = command.manageExchangeRateInterface(event.getMonth(),
					account.getUsr_id());
			if (cnt == 0) {
				// GEM00013(There is no related data!)
				eventResponse.setUserMessage(new ErrorHandler("GEM00013")
						.getUserMessage());

			} else {
				// 에러/성공 메세지설정
				eventResponse.setUserMessage(new ErrorHandler("GEM00008")
						.getUserMessage());

			}
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}

		return eventResponse;
	}

	// ---------------------------------------------------------------------------
	// [CPS_GEM-0007] Expense Code Maintenance
	// ---------------------------------------------------------------------------
	/**
	 * 일반관리비 비용주관팀으로 정의된 TIC콤보박스와 parent콤보박스 세팅<br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category open0007
	 * @param Event e
	 * @return response EventResponse
	 * @throws EventException
	 */	
	private EventResponse open0007(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// ----------------------------------------
			// TIC 콤보박스 설정
			// ----------------------------------------
			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();
			String[] arr = command.searchExpenseTICList();
			// 반환 객체 설정
			eventResponse.setETCData("ticList", GemUtil.addSpChar(arr));

			// ----------------------------------------
			// parent 콤보박스 설정
			// ----------------------------------------
			List<GemExpenseVO> parentList = command
					.searchExpenseParentList("3");
			// 반환 객체 설정
			eventResponse.setRsVoList(parentList);

		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}

		return eventResponse;

	}

	/**
	 * 일반관리비 비용주관팀으로 정의된 조직코드(Office Code) 정보<br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category searchExpenseTICList
	 * @param Event e
	 * @return response EventResponse
	 * @throws EventException
	 */
	public EventResponse searchExpenseTICList(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();
			String[] arr = command.searchExpenseTICList();
			// 반환 객체 설정
			eventResponse.setETCData("ticList", GemUtil.addSpChar(arr));

		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}

		return eventResponse;
	}

	/**
	 * [CPS_GEM-0007] Expense Code Maintenance 1.일반관리비 비용코드 기준 정보 2.회계코드 기준 정보 및
	 * 일반관리비 비용코드와 매핑 정보 3.비용실적에 대한 재분배를 위한 예외사항 정보
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM_0007
	 * @category searchExpenseInfo
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchExpenseInfo(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			CpsGem0007Event event = (CpsGem0007Event) e;
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			// 컨테이너 vo
			ExpenseInfoMgtVO expenseInfoMgtVO = event.getExpenseInfoMgtVO();

			// 사용자 설정
			GemExpenseVO gemExpenseVO = expenseInfoMgtVO.getGemExpenseVO();
			gemExpenseVO.setCreUsrId(account.getUsr_id());
			gemExpenseVO.setUpdUsrId(account.getUsr_id());

			String genExpnCd = gemExpenseVO.getGenExpnCd();

			ExpenseInfoMgtVO vo = command.searchExpenseInfo(genExpnCd,
					gemExpenseVO.getDeltFlg());
			eventResponse.setRsVo(vo.getGemExpenseVO());

			// 2.회계코드 기준 정보 및 일반관리비 비용코드와 매핑 정보
			List<GemAcctMtxVO> gemAcctMtxVOs = command.searchAccountInfo(
					genExpnCd, gemExpenseVO.getAcctMtxDeltFlg());
			eventResponse.setRsVoList(gemAcctMtxVOs);

			// 3.비용실적에 대한 재분배를 위한 예외사항 정보
			List<GemAcctExptVO> gemAcctExptVOs = command
					.searchDividedOfficeInfo(genExpnCd, gemExpenseVO
							.getAcctExptDeltFlg());
			eventResponse.setRsVoList(gemAcctExptVOs);

			// 부모 expense코드 리스트 취득
			if (vo.getGemExpenseVO() != null) {
				String genExpnGrpLvl = vo.getGemExpenseVO().getGenExpnGrpLvl();
				if (genExpnGrpLvl != null && !genExpnGrpLvl.equals("")) {
					int lvl = Integer.parseInt(genExpnGrpLvl);
					if (lvl != 1) {
						lvl--;
						List<GemExpenseVO> parentList = command
								.searchExpenseParentList(lvl + "");
						// 반환 객체 설정
						eventResponse.setRsVoList(parentList);
					}
				}
			}

		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * 일반관리비 비용계획 및 실적집계시 사용할 코드 수정<br>
	 * 일반관리비 비용계획시 사용할 비용코드(Expense Code) 정의하고, 실적(전표)집계를 위한 회계코드(Account Code)를
	 * 매핑, 실적(전표)재분배를 위한 코드정의를 한다<br>
	 * GEM00007 에러코드
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	public EventResponse manageExpenseInfo(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();

			// ----------------------------------------------
			// 계획 환율 저장 처리
			// ----------------------------------------------
			CpsGem0007Event event = (CpsGem0007Event) e;
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();
			ExpenseInfoMgtVO vo = event.getExpenseInfoMgtVO();
			GemExpenseVO gemExpenseVO = vo.getGemExpenseVO();
			gemExpenseVO.setUpdUsrId(account.getUsr_id());
			gemExpenseVO.setCreUsrId(account.getUsr_id());

			command.manageExpenseInfo(event.getExpenseInfoMgtVO());

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
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}

		return eventResponse;

	}

	/**
	 * 회계코드 기준 정보 및 일반관리비 비용코드와 매핑 정보 <br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category searchAccountInfo
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	public EventResponse searchAccountInfo(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			CpsGem0007Event event = (CpsGem0007Event) e;
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			ExpenseInfoMgtVO expenseInfoMgtVO = event.getExpenseInfoMgtVO();

			GemExpenseVO gemExpenseVO = expenseInfoMgtVO.getGemExpenseVO();

			List<GemAcctMtxVO> list = command.searchAccountInfo(gemExpenseVO
					.getGenExpnCd(), gemExpenseVO.getAcctMtxDeltFlg());

			eventResponse.setRsVoList(list);

		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}

		return eventResponse;

	}

	/**
	 * 회계코드(Account Code)가 사용되는 코드인지를 체크하고, 영문약어명과 한글약어명 조회
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category searchAccountName
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	public EventResponse searchAccountName(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {

			CpsGem0007Event event = (CpsGem0007Event) e;
			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			String acctCd = event.getAcctCd();

			String[] codes = command.searchAcctCheck(acctCd);
			// 반환 객체 설정
			eventResponse.setETCData("code", codes[0]);
			eventResponse.setETCData("gen_expn_cd", codes[1]);

			if (codes[0].equals("0")) {
				MdmAccountVO mdmAccountVO = command.searchAccountName(acctCd);
				// 반환 객체 설정
				eventResponse.setRsVo(mdmAccountVO);
			}

		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}

		return eventResponse;

	}

	/**
	 * 일반관리비 비용코드의 Group Level[1st, 2nd, 3rd, Final]에 해당하는 Parent Code 리스트 조회<br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category searchExpenseParentList
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	public EventResponse searchExpenseParentList(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {

			CpsGem0007Event event = (CpsGem0007Event) e;
			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			ExpenseInfoMgtVO expenseInfoMgtVO = event.getExpenseInfoMgtVO();

			GemExpenseVO gemExpenseVO = expenseInfoMgtVO.getGemExpenseVO();

			String genExpnGrpLvl = gemExpenseVO.getGenExpnGrpLvl();

			int lvl = Integer.parseInt(genExpnGrpLvl);

			if (lvl != 1) {
				lvl--;
				List<GemExpenseVO> parentList = command
						.searchExpenseParentList(lvl + "");
				// 반환 객체 설정
				eventResponse.setRsVoList(parentList);
			}

		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}

		return eventResponse;

	}

	/**
	 * 일반관리비 비용코드(Expense Code) 의 한글약어명, 영문약어명, 비용주관팀을 조회한다<br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category searchExpenseName
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	public EventResponse searchExpenseName(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {

			CpsGem0007Event event = (CpsGem0007Event) e;
			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			ExpenseInfoMgtVO expenseInfoMgtVO = event.getExpenseInfoMgtVO();

			GemExpenseVO gemExpenseVO = expenseInfoMgtVO.getGemExpenseVO();

			String genExpnCd = gemExpenseVO.getPrntGenExpnCd();

			ExpenseNameVO expenseNameVO = command.searchExpenseName(genExpnCd);

			// 반환 객체 설정
			eventResponse.setRsVo(expenseNameVO);

		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}

		return eventResponse;

	}

	/**
	 * 비용실적에 대한 재분배를 위한 예외사항 정보<br>
	 * ( 특정조직(SELTDA) 에서 회계코드(Account Code)의 실적을 발생시킬때, 매핑된 일반관리비 비용코드(Expense
	 * Code)로 집계하지않고,<br>
	 * 정의된 비용코드(Expense Code)로 집계 ) <br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDividedOfficeInfo(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			CpsGem0007Event event = (CpsGem0007Event) e;
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			ExpenseInfoMgtVO expenseInfoMgtVO = event.getExpenseInfoMgtVO();

			GemExpenseVO gemExpenseVO = expenseInfoMgtVO.getGemExpenseVO();

			List<GemAcctExptVO> list = command.searchDividedOfficeInfo(
					gemExpenseVO.getGenExpnCd(), gemExpenseVO
							.getAcctExptDeltFlg());

			eventResponse.setRsVoList(list);

		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}

		return eventResponse;

	}

	/**
	 * 계정코드 존재 여부 체크 계정코드 미존재(신규) == 0 삭제 계정코드 존재 == > 1 사용중 계정코드 존재 == > 2
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category searchAcctCheck
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	public EventResponse searchAcctCheck(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {

			CpsGem0007Event event = (CpsGem0007Event) e;
			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			// 회계코드
			String acctCd = event.getAcctCd();
			String[] codes = command.searchAcctCheck(acctCd);
			// 반환 객체 설정
			eventResponse.setETCData("code", codes[0]);
			eventResponse.setETCData("gen_expn_cd", codes[1]);

		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}

		return eventResponse;

	}

	/**
	 * 오피스코드 존재 여부 체크 오피스코드 미존재(신규) == 0 삭제 오피스코드 존재 == > 1 사용중 오피스코드 존재 == > 2
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category searchOfcCheck
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	public EventResponse searchOfcCheck(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {

			CpsGem0007Event event = (CpsGem0007Event) e;
			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			// 오피스 코드
			String ofcCd = event.getOfcCd();
			String code = command.searchOfcCheck(ofcCd);
			// 반환 객체 설정
			eventResponse.setETCData("code", code);
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;

	}

	/**
	 * 분리되어야 할 Budget Code 존재 여부 체크 회계코드가 미존재 == 0 분리비용코드테이블(gem_acct_expt)에 이미
	 * 존재 == 1 계정코드에테이블(gem_acct_mtx)에 비용코드 미존재 == 2 정상 == 3 gem_acct_mtx에서 비용코드
	 * 반환
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category searchGenExpnCheck
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	public EventResponse searchGenExpnCheck(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {

			CpsGem0007Event event = (CpsGem0007Event) e;
			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			// 오피스 코드
			String ofcCd = event.getOfcCd();
			// 회계코드
			String acctCd = event.getAcctCd();

			ExpenseInfoMgtVO expenseInfoMgtVO = event.getExpenseInfoMgtVO();

			GemExpenseVO gemExpenseVO = expenseInfoMgtVO.getGemExpenseVO();

			// 비용코드
			String genExpnCd = gemExpenseVO.getGenExpnCd();

			MdmAccountVO mdmAccountVO = command.searchAccountName(acctCd);

			String[] codes = { "", "" };

			if (mdmAccountVO == null) {
				codes[0] = "0";
			}

			String code = command.searchGenExpnCheck(ofcCd, genExpnCd, acctCd);

			// 존재하는 경우 에러 , 그외의 경우 mtx에서 비용코드 취득
			if (!code.equals("0")) {
				codes[0] = "1";
			} else {
				String acctCodes[] = command.searchAcctCheck(acctCd);
				// 존재하는경우 비용코드 설정 , 미존재시 에러
				if (acctCodes[0].equals("2")) {
					codes[0] = "3";
					codes[1] = acctCodes[1];
				} else {
					codes[0] = "2";
				}
			}

			// 반환 객체 설정
			eventResponse.setETCData("code", codes[0]);
			eventResponse.setETCData("gen_expn_cd", codes[1]);

		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}

		return eventResponse;

	}

	// ===========================================================================
	// C.J.M
	// ===========================================================================

	// ---------------------------------------------------------------------------
	// [CPS_GEM_0006] Closing Confirmation & Interface Status
	// ---------------------------------------------------------------------------

	/**
	 * CPS_GEM_0006 조회 이벤트 처리<br>
	 * GEMClosingScheduleMgt의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0006
	 * @category searchClosingInfo
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchClosingInfo(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMClosingScheduleMgtBC command = new GEMClosingScheduleMgtBCImpl();

			// 리스트 취득
			List<MonClzVO> list = new ArrayList<MonClzVO>();

			CpsGem0006Event event = (CpsGem0006Event) e;

			list = command.searchClosingInfo(event.getGemMonClzVO()
					.getClzYrmon());

			// 반환 객체 설정
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * CPS_GEM_0006 화면의 G/L I/F 클릭시 이벤트 처리<br>
	 * GEMClosingScheduleMgt의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0006
	 * @category createSlipClosing
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse createSlipClosing(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		log.info("##### GEMCommonSC createSlipClosing START #####");

		// BC 객체 생성
		GEMPlanningPerformanceBC command = new GEMPlanningPerformanceBCImpl();

		CpsGem0006Event event = (CpsGem0006Event) e;

		// returnStr (0:실패, 1:성공, 2:작업내용없음)
		String returnStr = "0";
		String glEffDt = event.getMonClzVO().getGlifClzYrmon();
		log.info("##### glEffDt : " + glEffDt);

		List<GemSlpIfVO> list = command.searchSlpIf("", "", glEffDt);
		log.info("##### list : " + list.size());
		if (list.size() == 0) {
			returnStr = "2";
		} else {
			int k = 0;
			for (int i = 0; i < list.size(); i++) {
				GemSlpIfVO gemSlpIfVO = (GemSlpIfVO) list.get(i);
				log.info("##### gemSlpIfVO : " + gemSlpIfVO);

				try {
					begin();

					// GEM_SLP_IF 테이블에 Insert 성공이면
					command.createSlipClosing(gemSlpIfVO);
					command.modifySlipErrInfo(gemSlpIfVO);
					commit();
					k++;
				} catch (EventException ex) {
					log.error("SC EventException e : " + ex.toString(), ex);
					rollback();
					throw ex;
				} catch (Exception ex) {
					log.error("SC Exception e : " + ex.toString(), ex);
					rollback();
					throw new EventException(new ErrorHandler("GEM99999").getMessage(),
							ex);
				}
			}
			if (k > 0)
				returnStr = "1";
		}

		// 반환 객체 설정
		eventResponse.setETCData("code", returnStr);

		log.info("##### GEMCommonSC createSlipClosing END #####");

		return eventResponse;
	}

	/**
	 * CPS_GEM_0006 멀티 이벤트 처리<br>
	 * GEMClosingScheduleMgt의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0006
	 * @category manageClosingInfo
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse manageClosingInfo(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		CpsGem0006Event event = (CpsGem0006Event) e;

		// BC 객체 생성
		GEMClosingScheduleMgtBC command = new GEMClosingScheduleMgtBCImpl();

		try {
			begin();

			// 현지법인실적 입력일정 정보 조회
			command
					.manageClosingInfo(event.getMonClzVOs(), account
							.getUsr_id());

			// 에러메세지설정
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
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	// ---------------------------------------------------------------------------
	// [CPS_GEM_0010] Expense Code Inquiry
	// ---------------------------------------------------------------------------

	/**
	 * CPS_GEM_0010 오픈 이벤트 처리<br>
	 * GEMMasterCodeMgt의 오픈 조회 이벤트 처리<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0010
	 * @category searchExpenseInqOpen
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchExpenseInqOpen(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			// 반환값 취득
			List<GemExpenseVO> searchExpenseList = command.searchExpenseList();
			List<GemExpenseVO> searchGroupListByExpense = command
					.searchGroupListByExpense();
			String[] searchTicList = command.searchExpenseTICList();

			// 반환 객체 설정
			eventResponse.setRsVoList(searchExpenseList);
			eventResponse.setRsVoList(searchGroupListByExpense);
			eventResponse.setETCData("ticList", GemUtil
					.addSpChar(searchTicList));
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * CPS_GEM_0010 조회 이벤트 처리<br>
	 * GEMMasterCodeMgt의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0010
	 * @category searchExpenseInq
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchExpenseInq(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			// 리스트 취득
			List<ExpenseInquiryVO> list = new ArrayList<ExpenseInquiryVO>();

			CpsGem0010Event event = (CpsGem0010Event) e;

			list = command.searchExpenseInq(event.getExpenseInqVO());

			// 반환 객체 설정
			if (list.size() <= 0) {
				// GEM00013(There is no related data!)
				eventResponse.setUserMessage(new ErrorHandler("GEM00013")
						.getUserMessage());
			}
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * CPS_GEM_0010의 Expense 이벤트 처리<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0010
	 * @category searchExpenseList
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchExpenseList(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			// 반환값 취득
			List<GemExpenseVO> searchExpenseList = command.searchExpenseList();

			// 반환 객체 설정
			eventResponse.setRsVoList(searchExpenseList);
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * CPS_GEM_0010의 Account 이벤트 처리<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0010
	 * @category searchAccountList
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAccountList(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			// 반환값 취득
			List<GemAcctMtxVO> searchAccountList = command.searchAccountList();

			// 반환 객체 설정
			eventResponse.setRsVoList(searchAccountList);
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * CPS_GEM_0010의 Group Expense 이벤트 처리<br>
	 * CPS_GEM_0013의 Group Expense 이벤트 처리<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0010, CPS_GEM_0013
	 * @category searchGroupExpenseList
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchGroupExpenseList(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			// 반환값 취득
			List<GemExpenseVO> searchGroupListByExpense = command
					.searchGroupListByExpense();

			// 반환 객체 설정
			eventResponse.setRsVoList(searchGroupListByExpense);
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	// ---------------------------------------------------------------------------
	// [CPS_GEM_0011] Expense Office Inquiry
	// ---------------------------------------------------------------------------

	/**
	 * CPS_GEM_0011의 Open시 이벤트 처리
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0011
	 * @category searchBUOffice
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchBUOffice(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMCommonBC command = new GEMCommonBCImpl();

			// 반환값 취득
			// 일반관리비 BU 조직코드 조회
			String[] searchExpenseBUList = command.searchBUOffice();

			// 반환 객체 설정
			eventResponse.setETCData("searchBUOfficeList", GemUtil
					.addSpChar(searchExpenseBUList));
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * CPS_GEM_0011의 일반관리비 Major 조직코드 조회
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0011
	 * @category searchMajorListByOffice
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMajorListByOffice(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMCommonBC command = new GEMCommonBCImpl();

			GemCommonEvent event = (GemCommonEvent) e;

			// 반환값 취득
			String rgnOfcFlg = event.getOfficeMgtVO().getSchHohqGbn();
			String ofcCd = event.getOfficeMgtVO().getSchLvl1();

			String[] searchMajorList = command.searchMajorListByOffice(
					rgnOfcFlg, ofcCd);

			// 반환 객체 설정
			eventResponse.setETCData("searchMajorList", GemUtil
					.addSpChar(searchMajorList));
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * [투자법인] BU조직에 속한 HO본사,HQ지역그룹,BU주관부서 코드 리스트 조회
	 * 
	 * @author Park Chang June
	 * @category GEM_COMMONGS
	 * @category searchSubsMajorListByOffice
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSubsMajorListByOffice(Event e)
			throws EventException { // 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMCommonBC command = new GEMCommonBCImpl();

			GemCommonEvent event = (GemCommonEvent) e;

			// 반환값 취득
			String rgnOfcFlg = event.getOfficeMgtVO().getSchHohqGbn();
			String ofcCd = event.getOfficeMgtVO().getSchLvl1();

			String[] searchMajorList = command.searchSubsMajorListByOffice(
					rgnOfcFlg, ofcCd);

			// 반환 객체 설정
			eventResponse.setETCData("searchMajorList", GemUtil
					.addSpChar(searchMajorList));
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * CPS_GEM_0011의 일반관리비 Minor 조직코드 조회
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0011
	 * @category searchMinorListByOffice
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMinorListByOffice(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMCommonBC command = new GEMCommonBCImpl();

			GemCommonEvent event = (GemCommonEvent) e;

			// 반환값 취득
			String rgnOfcFlg = event.getOfficeMgtVO().getSchHohqGbn();
			String ofcCd = event.getOfficeMgtVO().getSchLvl2();

			String[] searchMinorList = command.searchMinorListByOffice(
					rgnOfcFlg, ofcCd);

			// 반환 객체 설정
			eventResponse.setETCData("searchMinorList", GemUtil
					.addSpChar(searchMinorList));
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * [투자법인] HO본사,HQ지역그룹,BU주관부서의 속한 조직코드 리스트 조회
	 * 
	 * @author Park Chang June
	 * @category GEM_COMMONGS
	 * @category searchSubsMinorListByOffice
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSubsMinorListByOffice(Event e)
			throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// BC 객체 생성
			GEMCommonBC command = new GEMCommonBCImpl();

			GemCommonEvent event = (GemCommonEvent) e;

			// 반환값 취득
			String rgnOfcFlg = event.getOfficeMgtVO().getSchHohqGbn();
			String ofcCd = event.getOfficeMgtVO().getSchLvl2();

			String[] searchMinorList = command.searchSubsMinorListByOffice(
					rgnOfcFlg, ofcCd);

			// 반환 객체 설정
			eventResponse.setETCData("searchMinorList", GemUtil
					.addSpChar(searchMinorList));
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}
	
	/**
	 * 조직별 사용가능한 비용코드 리스트 조회
	 * 
	 * @author lee jun bum
	 * @category GEM_COMMONGS
	 * @category searchExpenseCdByRole
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchExpenseCdByRole(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// BC 객체 생성
			GEMCommonBC command = new GEMCommonBCImpl();

			GemCommonEvent event = (GemCommonEvent) e;

			// 반환값 취득			
			String ofcCd = event.getOfficeMgtVO().getSchLvl2();

			String[] searchExpenseCdByRoleList = command.searchExpenseCdByRole(ofcCd);

			// 반환 객체 설정
			eventResponse.setETCData("searchExpenseCdByRoleList", GemUtil
					.addSpChar(searchExpenseCdByRoleList));
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * CPS_GEM_0011의 SUMUP OFFICE코드 조회
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0011
	 * @category searchSumUpListByOffice
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSumUpListByOffice(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			// 반환값 취득
			String[] searchSumUpList = command.searchSumUpListByOffice();
			// 반환 객체 설정
			eventResponse.setETCData("searchSumUpList", GemUtil
					.addSpChar(searchSumUpList));
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * CPS_GEM_0011 조회 이벤트 처리<br>
	 * GEMMasterCodeMgt의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0011
	 * @category searchOfficeInfo
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOfficeInfo(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			// 리스트 취득
			List<GemOfficeVO> list = new ArrayList<GemOfficeVO>();

			CpsGem0011Event event = (CpsGem0011Event) e;

			list = command.searchOfficeInfo(event.getOfficeMgtVO());

			// 반환 객체 설정
			if (list.size() <= 0) {
				// GEM00013(There is no related data!)
				eventResponse.setUserMessage(new ErrorHandler("GEM00013")
						.getUserMessage());
			}
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	// ---------------------------------------------------------------------------
	// [CPS_GEM_0012] Foreign Exchange Rate Inquiry
	// ---------------------------------------------------------------------------

	/**
	 * CPS_GEM_0012의 Open시 이벤트 처리
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0012
	 * @category searchCurrencyList
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCurrencyList(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			CpsGem0012Event event = (CpsGem0012Event) e;

			// 반환값 취득
			// 일반관리비 BU 조직코드 조회
			String strYear = event.getGemXchRtVO().getAcctXchRtYrmon();

			String[] searchCurrencyList = command.searchCurrencyList(strYear);
			String searchUsdRate = command.searchUsdRate(strYear);

			// 반환 객체 설정
			eventResponse.setETCData("searchCurrencyList", GemUtil
					.addSpChar(searchCurrencyList));
			eventResponse.setETCData("searchUsdRate", searchUsdRate);
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * CPS_GEM_0012 조회 이벤트 처리<br>
	 * GEMMasterCodeMgt의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0012
	 * @category searchExchangeRateInq
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchExchangeRateInq(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			// 리스트 취득
			List<XchRtInqVO> list = new ArrayList<XchRtInqVO>();

			CpsGem0012Event event = (CpsGem0012Event) e;

			String acctXchRtYrmon = event.getGemXchRtVO().getAcctXchRtYrmon();
			String currCds = event.getGemXchRtVO().getCurrCd();

			list = command.searchExchangeRateInq(acctXchRtYrmon, currCds);
			String searchUsdRate = command.searchUsdRate(acctXchRtYrmon);

			// 반환 객체 설정
			if (list.size() <= 0) {
				// GEM00013(There is no related data!)
				eventResponse.setUserMessage(new ErrorHandler("GEM00013")
						.getUserMessage());
			}

			eventResponse.setETCData("searchUsdRate", searchUsdRate);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	// ---------------------------------------------------------------------------
	// [CPS_GEM_0013] Expense Matrix per Office
	// ---------------------------------------------------------------------------

	/**
	 * CPS_GEM_0013의 Open시 이벤트 처리
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0013
	 * @category searchExpenseMatrixperOffice
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchExpenseMatrixperOffice(Event e)
			throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// BC 객체 생성
			GEMCommonBC comCommand = new GEMCommonBCImpl();
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			// 반환값 취득
			// 일반관리비 BU 조직코드 조회
			String[] searchExpenseBUList = comCommand.searchBUOffice();
			List<GemExpenseVO> searchGroupListByExpense = command
					.searchGroupListByExpense();
			// 반환 객체 설정
			eventResponse.setETCData("searchBUOfficeList", GemUtil
					.addSpChar(searchExpenseBUList));
			eventResponse.setRsVoList(searchGroupListByExpense);
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * CPS_GEM_0013 Office조회 이벤트 처리<br>
	 * GEMMasterCodeMgt의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0013
	 * @category searchOfficeExpenseMatrix
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOfficeExpenseMatrix(Event e)
			throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			// 리스트 취득
			List<OfficeInfoVO> list = new ArrayList<OfficeInfoVO>();
			List<OfficeInfoVO> expenseList = new ArrayList<OfficeInfoVO>();

			CpsGem0013Event event = (CpsGem0013Event) e;

			list = command.searchOfficeExpenseMatrix(event.getOfficeMgtVO());

			// 반환 객체 설정
			if (list.size() <= 0) {
				// GEM00013(There is no related data!)
				eventResponse.setUserMessage(new ErrorHandler("GEM00013")
						.getUserMessage());
			} else {
				// Expense 조회
				if (list != null && !list.isEmpty()) {
					OfficeInfoVO dto = list.get(0);
					event.getOfficeMgtVO().setHdnOfcCd(dto.getOfcCd());

					expenseList = command
							.searchOfficeExpenseMatrixListByExpense(event
									.getOfficeMgtVO());
				}
			}

			// 반환 객체 설정
			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(expenseList);
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * CPS_GEM_0013 Expense조회 이벤트 처리<br>
	 * GEMMasterCodeMgt의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0013
	 * @category searchOfficeExpenseMatrixLIstByExpense
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOfficeExpenseMatrixListByExpense(Event e)
			throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			// 리스트 취득
			List<OfficeInfoVO> expenseList = new ArrayList<OfficeInfoVO>();

			CpsGem0013Event event = (CpsGem0013Event) e;

			expenseList = command.searchOfficeExpenseMatrixListByExpense(event
					.getOfficeMgtVO());

			// 반환 객체 설정
			eventResponse.setRsVoList(expenseList);
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	// ---------------------------------------------------------------------------
	// [CPS_GEM_0008_01] Expense Office Maintenance - Office Code
	// ---------------------------------------------------------------------------

	/**
	 * CPS_GEM_0008_01 멀티 이벤트 처리<br>
	 * GEMMasterCodeMgt의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0008_01
	 * @category manageOfficeInfo
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse manageOfficeInfo(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		CpsGem000801Event event = (CpsGem000801Event) e;

		// BC 객체 생성
		GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

		try {
			begin();

			// event관련 사용자정보 insert
			GemOfficeVO[] gemOfficeVOs = event.getGemOfficeVOs();
			for (int i = 0; i < gemOfficeVOs.length; i++) {
				// 사용자 설정
				gemOfficeVOs[i].setCreUsrId(account.getUsr_id());
				gemOfficeVOs[i].setUpdUsrId(account.getUsr_id());
			}

			command.manageOfficeInfo(gemOfficeVOs);

			// 에러메세지설정
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
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	// ---------------------------------------------------------------------------
	// [CPS_GEM_0109] Office code history
	// ---------------------------------------------------------------------------

	/**
	 * CPS_GEM_0109 Office code history 이벤트 처리<br>
	 * GEMMasterCodeMgt의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0109
	 * @category searchOfficeHistoryInfo
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOfficeHistoryInfo(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			// 리스트 취득
			List<GemOfcHisVO> list = new ArrayList<GemOfcHisVO>();

			CpsGem0109Event event = (CpsGem0109Event) e;

			list = command.searchOfficeHistoryInfo(event.getGemOfcHisVO()
					.getOfcCd());

			// 반환 객체 설정
			if (list.size() <= 0) {
				// GEM00013(There is no related data!)
				eventResponse.setUserMessage(new ErrorHandler("GEM00013")
						.getUserMessage());
			}

			// 반환 객체 설정
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * CPS_GEM_0109 Office code history의 Ofc_Code에 해당하는 Ctr_Code 조회 이벤트 처리<br>
	 * GEMMasterCodeMgt의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0109
	 * @category searchOfficeHistoryInfoByCtrCode
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOfficeHistoryInfoByCtrCode(Event e)
			throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			CpsGem0109Event event = (CpsGem0109Event) e;

			String ctrCode = command.searchOfficeHistoryInfoByCtrCode(event
					.getGemOfcHisVO().getOfcCd());

			// 반환 객체 설정
			eventResponse.setETCData("ctrCode", ctrCode);
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * CPS_GEM_0109 멀티 이벤트 처리<br>
	 * GEMMasterCodeMgt의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0109
	 * @category manageOfficeHistoryInfo
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse manageOfficeHistoryInfo(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		CpsGem0109Event event = (CpsGem0109Event) e;

		// BC 객체 생성
		GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();
		
		// BC 객체 생성
		GEMPlanningPerformanceBC command1 = new GEMPlanningPerformanceBCImpl();

		try {
			begin();

			String ofcCd = "";
			String bfrOfcCd = "";
			String expDt = "";
			String usrId = "";
			
			// Office code별 History 관리
			GemOfcHisVO[] gemOfcHisVOs = event.getGemOfcHisVOs();
			for (int i = 0; i < gemOfcHisVOs.length; i++) {
				// 사용자 설정
				gemOfcHisVOs[i].setCreUsrId(account.getUsr_id());
				gemOfcHisVOs[i].setUpdUsrId(account.getUsr_id());
				
				ofcCd    = gemOfcHisVOs[i].getOfcCd();
				bfrOfcCd = gemOfcHisVOs[i].getBfrOfcCd();
				expDt    = gemOfcHisVOs[i].getExpDt();
				usrId    = gemOfcHisVOs[i].getUpdUsrId();

			}
			command.manageOfficeHistoryInfo(gemOfcHisVOs);
			// 확정된 예산을 From Office 에서 To Office 변경하는 메소드
			command1.manageChangeOffice(ofcCd, bfrOfcCd, expDt, usrId);
			
			// 에러메세지설정
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
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	// ---------------------------------------------------------------------------
	// [CPS_GEM_0008_02] Expense Office Maintenance - Expense Matrix per Office
	// ---------------------------------------------------------------------------

	/**
	 * Expense Code 사용여부를 체크 Expense Code 사용 가능 == 0 Expense Code 사용 불가능(유효하지 않은
	 * 코드) == 1 Expense Code 사용 불가능(중복 입력된 코드) == 2 Expense Code 사용 불가능(관리비관련
	 * 비용) == 3 Expense Code 사용 불가능(영업관련 비용) == 4
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0008_02
	 * @category checkExpense
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	public EventResponse checkExpense(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			CpsGem000802Event event = (CpsGem000802Event) e;
			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			// get
			String ofcCd = event.getOfficeMgtVO().getHdnOfcCd();
			String slsOfcFlg = event.getOfficeMgtVO().getHdnSlsOfcFlg();
			String genExpnCd = event.getOfficeMgtVO().getSchOfficeCode();
			String langDiv = event.getOfficeMgtVO().getSchLang();

			// set
			OfficeMgtVO officeMgtVO = new OfficeMgtVO();
			// officeMgtVO.setHdnOfcCd(ofcCd);
			officeMgtVO.setSchOfficeGbn("N");
			officeMgtVO.setSchOfficeCode(genExpnCd);
			officeMgtVO.setSchLang(langDiv);

			// 리스트 취득
			List<OfficeInfoVO> expenseList = new ArrayList<OfficeInfoVO>();

			String resultStr1 = "", resultStr2 = "", resultStr3 = "";
			String code = "", code1 = "", code2 = "", code3 = "";

			// 1. 입력된 Expense Code가 Level = '4'인지를 확인
			resultStr1 = command.searchExpenseCheck("lvlCheck", ofcCd,
					genExpnCd);
			// 2. 입력된 Expense Code가 중복인지를 확인
			resultStr2 = command.searchExpenseCheck("dupCheck", ofcCd,
					genExpnCd);
			// 3. 입력된 Expense Code의 사용가능여부를 판단
			resultStr3 = command.searchExpenseCheck("etc", ofcCd, genExpnCd);

			if ("TRUE".equals(resultStr1))
				code1 = "0";
			else if ("FALSE".equals(resultStr1))
				code1 = "1";

			if ("TRUE".equals(resultStr2))
				code2 = "0";
			else if ("FALSE".equals(resultStr2))
				code2 = "2";

			if ("Y".equals(slsOfcFlg)) {
				if ("TRUE".equals(resultStr3))
					code3 = "0";
				else if ("FALSE".equals(resultStr3))
					code3 = "3";
			} else if ("N".equals(slsOfcFlg)) {
				if ("TRUE".equals(resultStr3))
					code3 = "0";
				else if ("FALSE".equals(resultStr3))
					code3 = "4";
			}

			if (!"0".equals(code1))
				code = code1;
			else if ("0".equals(code1) && !"0".equals(code2))
				code = code2;
			else if ("0".equals(code1) && "0".equals(code2)
					&& !"0".equals(code3))
				code = code3;
			else
				code = "0";

			if ("0".equals(code)) {
				expenseList = command
						.searchOfficeExpenseMatrixListByExpense(officeMgtVO);
			}

			// 반환 객체 설정
			eventResponse.setETCData("code", code);
			eventResponse.setRsVoList(expenseList);
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * CPS_GEM_0008_02 멀티 이벤트 처리<br>
	 * GEMMasterCodeMgt의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0008_02
	 * @category manageOfficeExpenseMatrix
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse manageOfficeExpenseMatrix(Event e)
			throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		CpsGem000802Event event = (CpsGem000802Event) e;

		// BC 객체 생성
		GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

		try {
			begin();

			// event관련 사용자정보 insert
			OfficeInfoVO[] officeInfoVOs = event.getOfficeInfoVOs();
			for (int i = 0; i < officeInfoVOs.length; i++) {
				// 사용자 설정
				officeInfoVOs[i].setCreUsrId(account.getUsr_id());
				officeInfoVOs[i].setUpdUsrId(account.getUsr_id());
			}

			command.manageOfficeExpenseMatrix(officeInfoVOs);

			// 에러메세지설정
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
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	// ---------------------------------------------------------------------------
	// [CPS_GEM_0110] Expense Matrix Copy
	// ---------------------------------------------------------------------------

	/**
	 * CPS_GEM_0110 멀티 이벤트 처리<br>
	 * GEMMasterCodeMgt의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0110
	 * @category createExpenseCopy
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse createExpenseCopy(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		CpsGem0110Event event = (CpsGem0110Event) e;

		// BC 객체 생성
		GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

		try {
			begin();

			// Expense Matrix Copy & Initial process
			String mtxDiv = event.getMatrixDiv();
			String fmOfc = event.getFromOfcCd();
			String toOfc = event.getToOfcCd();
			String userId = account.getUsr_id();

			int insCnt = command
					.createExpenseCopy(mtxDiv, fmOfc, toOfc, userId);
			log.info("insCnt : " + insCnt);

			// 반환 객체 설정
			eventResponse.setETCData("insCnt", "" + insCnt);

			// 에러메세지설정
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
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	// ---------------------------------------------------------------------------
	// [CPS_GEM_0008_03] Expense Office Maintenance - Office Matrix per Office
	// ---------------------------------------------------------------------------

	/**
	 * CPS_GEM_0008_03의 Open시 이벤트 처리
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0008_03
	 * @category searchExptListByOffice
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchExptListByOffice(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			// 반환값 취득
			List<GemExpenseVO> searchGroupListByExpense = new ArrayList<GemExpenseVO>();
			List<GemExpenseVO> searchExpenseList = new ArrayList<GemExpenseVO>();

			String rgnOfcFlg = "";
			String deltFlg = "";

			// From Office
			String[] searchFromList = command.searchFromOffice(rgnOfcFlg,
					deltFlg);
			// To Office
			String[] searchToList = command.searchToOffice(rgnOfcFlg, deltFlg);
			// Expense Code
			searchExpenseList = command.searchExpenseList();
			// Expense Group
			searchGroupListByExpense = command.searchGroupListByExpense();

			// 반환 객체 설정
			eventResponse.setETCData("searchFromList", GemUtil
					.addSpChar(searchFromList));
			eventResponse.setETCData("searchToList", GemUtil
					.addSpChar(searchToList));
			eventResponse.setRsVoList(searchExpenseList);
			eventResponse.setRsVoList(searchGroupListByExpense);
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * CPS_GEM_0008_03의 Retrive or Delt_flg = 'Y'를 체크시 이벤트 처리
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0008_03
	 * @category searchOfficeMatrixListByOffice
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOfficeMatrixListByOffice(Event e)
			throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			CpsGem000803Event event = (CpsGem000803Event) e;

			// 반환값 취득
			List<OfficeExptVO> list = new ArrayList<OfficeExptVO>();
			list = command.searchOfficeMatrixListByOffice(event
					.getOfficeMgtVO());

			// 반환 객체 설정
			if (list.size() <= 0) {
				// GEM00013(There is no related data!)
				eventResponse.setUserMessage(new ErrorHandler("GEM00013")
						.getUserMessage());
			}
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * CPS_GEM_0008_03의 From ~ To Office Code 선택시 해당범위안의 Expense Code를 조회
	 * CPS_GEM_0008_03의 Expense Code 이벤트 처리<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0008_03
	 * @category searchExptListByExpense
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchExptListByExpense(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			CpsGem000803Event event = (CpsGem000803Event) e;
			String sndOfcCd = event.getOfficeMgtVO().getHdnOfcCd();
			String rcvOfcCd = event.getOfficeMgtVO().getSchOfficeCode();

			// 반환값 취득
			List<ExpenseNameVO> searchExptListByExpense = command
					.searchExptListByExpense(sndOfcCd, rcvOfcCd);
			// 반환 객체 설정
			eventResponse.setRsVoList(searchExptListByExpense);
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * CPS_GEM_0008_03의 Expense Code 선택시 중복체크 CPS_GEM_0008_03의 Expense Code 이벤트
	 * 처리<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0008_03
	 * @category searchExptListByDupCheck
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchExptListByDupCheck(Event e)
			throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			CpsGem000803Event event = (CpsGem000803Event) e;
			String sndOfcCd = event.getOfficeMgtVO().getHdnOfcCd();
			String rcvOfcCd = event.getOfficeMgtVO().getSchOfficeCode();
			String genExpnCd = event.getOfficeMgtVO().getSchGenExpnCd();

			// 반환값 취득
			String errCode = command.searchExptListByDupCheck(sndOfcCd,
					rcvOfcCd, genExpnCd);

			// 반환 객체 설정
			eventResponse.setETCData("code", errCode);
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * CPS_GEM_0008_03의 RowAdd 버튼을 클릭시 From~To Office Code 조회 CPS_GEM_0008_03의
	 * RowAdd 버튼 이벤트 처리<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0008_03
	 * @category searchOfficeMatrixListByRowAdd
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOfficeMatrixListByRowAdd(Event e)
			throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			String rgnOfcFlg = "N";
			String deltFlg = "N";

			// From Office
			String[] searchFromList = command.searchFromOffice(rgnOfcFlg,
					deltFlg);
			// To Office
			String[] searchToList = command.searchToOffice(rgnOfcFlg, deltFlg);

			// 반환 객체 설정
			eventResponse.setETCData("searchFromList", GemUtil
					.addSpChar(searchFromList));
			eventResponse.setETCData("searchToList", GemUtil
					.addSpChar(searchToList));
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * CPS_GEM_0008_03의 멀티 이벤트 처리<br>
	 * GEMMasterCodeMgt의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0008_03
	 * @category manageOfficeMatrixListByOffice
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse manageOfficeMatrixListByOffice(Event e)
			throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		CpsGem000803Event event = (CpsGem000803Event) e;

		// BC 객체 생성
		GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

		try {
			begin();

			// event관련 사용자정보 insert
			OfficeExptVO[] officeExptVOs = event.getOfficeExptVOs();
			for (int i = 0; i < officeExptVOs.length; i++) {
				// 사용자 설정
				officeExptVOs[i].setCreUsrId(account.getUsr_id());
				officeExptVOs[i].setUpdUsrId(account.getUsr_id());
			}

			command.manageOfficeMatrixListByOffice(officeExptVOs);

			// 에러메세지설정
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
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	// ---------------------------------------------------------------------------
	// [CPS_GEM_9999] Log in Office Change Management
	// ---------------------------------------------------------------------------

	/**
	 * CPS_GEM_9999의 Retrive 이벤트 처리
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_9999
	 * @category searchLogInOffice
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchLogInOfficeChange(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			CpsGem9999Event event = (CpsGem9999Event) e;

			// 반환값 취득
			List<GemCngOfcVO> list = new ArrayList<GemCngOfcVO>();
			list = command.searchLogInOfficeChange(event.getOfficeMgtVO());

			// 반환 객체 설정
			if (list.size() <= 0) {
				// GEM00013(There is no related data!)
				eventResponse.setUserMessage(new ErrorHandler("GEM00013")
						.getUserMessage());
			}
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * CPS_GEM_9999의 Log Office Code 중복체크 CPS_GEM_9999의 Log Office Code 이벤트 처리<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_9999
	 * @category searchLogInOfficeChangeByLogOfcCd
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchLogInOfficeChangeByLogOfcCd(Event e)
			throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			log.info("#####LOG");
			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			CpsGem9999Event event = (CpsGem9999Event) e;
			String strOfcCd = event.getOfficeMgtVO().getHdnOfcCd();

			// 반환값 취득
			String errCode = command.searchLogInOfficeChangeByDupCheck("LOG",
					strOfcCd);

			// 반환 객체 설정
			eventResponse.setETCData("code", errCode);
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * CPS_GEM_9999의 Cng Office Code 중복체크 CPS_GEM_9999의 Cng Office Code 이벤트 처리<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_9999
	 * @category searchLogInOfficeChangeByCngOfcCd
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchLogInOfficeChangeByCngOfcCd(Event e)
			throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {

			log.info("#####CNG");
			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			CpsGem9999Event event = (CpsGem9999Event) e;
			String strOfcCd = event.getOfficeMgtVO().getHdnOfcCd();

			// 반환값 취득
			String errCode = command.searchLogInOfficeChangeByDupCheck("CNG",
					strOfcCd);

			// 반환 객체 설정
			eventResponse.setETCData("code", errCode);
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * CPS_GEM_9999의 Log~Cng Office Code 중복체크 CPS_GEM_9999의 Log~Cng Office Code
	 * 이벤트 처리<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_9999
	 * @category searchLogInOfficeChangeByDupOfcCd
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchLogInOfficeChangeByDupOfcCd(Event e)
			throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			log.info("#####DUP");
			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			CpsGem9999Event event = (CpsGem9999Event) e;
			String strOfcCd = event.getOfficeMgtVO().getHdnOfcCd();
			String cngOfcCd = event.getOfficeMgtVO().getSchOfficeCode();

			// 반환값 취득
			String errCode = command.searchLogInOfficeChangeByOfcCdDupCheck(
					strOfcCd, cngOfcCd);

			// 반환 객체 설정
			eventResponse.setETCData("code", errCode);
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;

	}

	/**
	 * CPS_GEM_9999의 멀티 이벤트 처리<br>
	 * GEMMasterCodeMgt의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_9999
	 * @category manageLogInOfficeChange
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse manageLogInOfficeChange(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		CpsGem9999Event event = (CpsGem9999Event) e;

		// BC 객체 생성
		GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

		try {
			begin();

			// event관련 사용자정보 insert
			GemCngOfcVO[] gemCngOfcVOs = event.getGemCngOfcVOs();
			for (int i = 0; i < gemCngOfcVOs.length; i++) {
				// 사용자 설정
				gemCngOfcVOs[i].setCreUsrId(account.getUsr_id());
				gemCngOfcVOs[i].setUpdUsrId(account.getUsr_id());
			}

			command.manageLogInOfficeChange(gemCngOfcVOs);

			// 에러메세지설정
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
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}
	
	/**
	 * CPS_GEM_0030 조회 이벤트 처리<br>
	 * Expense Code Maintenance for subsidiary의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0030
	 * @category searchSubsidiaryAccountMatrixInfo
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSubsidiaryAccountMatrixInfo(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			// 리스트 취득
			List<SubsidiaryAccountMatrixInfoVO> list = new ArrayList<SubsidiaryAccountMatrixInfoVO>();

			CpsGem0030Event event = (CpsGem0030Event) e;
			
			list = command.searchSubsidiaryAccountMatrixInfo(event.getOfficeMgtVO());

			// 반환 객체 설정
			if (list.size() <= 0) {
				// GEM00013(There is no related data!)
				eventResponse.setUserMessage(new ErrorHandler("GEM00013")
						.getUserMessage());
			}
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}
	
	/**
	 * 현지법인에서 사용하는 Account code의 중복 여부를 확인 한다
	 * 
	 * @author leejunbum
	 * @category CPS_GEM_0030
	 * @category searchSubsidiaryAccountCheck
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	public EventResponse searchSubsidiaryAccountCheck(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			CpsGem0030Event event = (CpsGem0030Event) e;
			// BC 객체 생성
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();

			// get
			String ofcCd     = event.getSubsidiaryAccountMatrixInfoVO().getOfcCd();
			String subsAcctCd = event.getSubsidiaryAccountMatrixInfoVO().getSubsAcctCd();
			
			String resultStr = "";
			String code      = "";

			// 입력된 Expense Code가 중복인지를 확인
			resultStr = command.searchSubsidiaryAccountCheck(ofcCd, subsAcctCd);

			if ("TRUE".equals(resultStr)){
				code = "0";
			}else if ("FALSE".equals(resultStr)){
				code = "1";
			}			

			// 반환 객체 설정
			eventResponse.setETCData("code", code);
		} catch (EventException ex) {

			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {

			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}
		return eventResponse;
	}
	
	/**
	 * 현지법인이 사용하는 Account Code 를 등록 , 수정 , 삭제 한다<br>
	 * 
	 * @author Lee Jun Bum
	 * @category CPS_GEM_0030
	 * @category manageSubsidiaryAccountMatrixInfo
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse manageSubsidiaryAccountMatrixInfo(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();

			// ----------------------------------------------
			// 계획 환율 저장 처리
			// ----------------------------------------------
			CpsGem0030Event event = (CpsGem0030Event) e;
			GEMMasterCodeMgtBC command = new GEMMasterCodeMgtBCImpl();
			command.manageSubsidiaryAccountMatrixInfo(event.getSubsidiaryAccountMatrixInfoVOs(), account.getUsr_id());
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
			throw new EventException(new ErrorHandler("GEM99999").getMessage(),
					ex);
		}

		return eventResponse;
	}
}