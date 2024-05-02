/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RFAQuotationSC.java
 *@FileTitle : RFA Quotation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.29
 *@LastModifier : 송민석
 *@LastVersion : 1.0
 * 2009.07.29 송민석
 * 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.basic.PRICommonBC;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.basic.PRICommonBCImpl;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.PrsBatchVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.basic.CalculateBC;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.basic.CalculateBCImpl;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.vo.RsltPriPrsRoutCsMaxRoutCsNoVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.basic.RFADurationProposalBC;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.basic.RFADurationProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagroupcommodityproposal.basic.RFAGroupCommodityProposalBC;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagroupcommodityproposal.basic.RFAGroupCommodityProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagrouplocationproposal.basic.RFAGroupLocationProposalBC;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagrouplocationproposal.basic.RFAGroupLocationProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposaldemdet.basic.RFAProposalDEMDETBC;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposaldemdet.basic.RFAProposalDEMDETBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.basic.RFAProposalMainBC;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.basic.RFAProposalMainBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.basic.RFARateProposalBC;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.basic.RFARateProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfagroupcommodityquotation.basic.RFAGroupCommodityQuotationBC;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfagroupcommodityquotation.basic.RFAGroupCommodityQuotationBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfagroupcommodityquotation.event.EsmPri601402Event;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfagroupcommodityquotation.event.EsmPri601502Event;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfagroupcommodityquotation.vo.RsltPriRqGrpCmdtDtlVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfagroupcommodityquotation.vo.RsltPriRqGrpCmdtVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfagrouplocationquotation.basic.RFAGroupLocationQuotationBC;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfagrouplocationquotation.basic.RFAGroupLocationQuotationBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfagrouplocationquotation.event.EsmPri601401Event;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfagrouplocationquotation.event.EsmPri601501Event;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfagrouplocationquotation.vo.RsltPriRqGrpLocDtlVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfagrouplocationquotation.vo.RsltPriRqGrpLocVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.basic.RFAQuotationMainBC;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.basic.RFAQuotationMainBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.event.EsmPri6014Event;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.event.EsmPri6015Event;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.event.EsmPri6044Event;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.event.EsmPri6046Event;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.event.EsmPri6058Event;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltPriRqMnChkNeedCalcVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltPriRqMnVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltSearchDetailCntVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltSearchGlineExistVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.basic.RFARateQuotationBC;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.basic.RFARateQuotationBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event.EsmPri601403Event;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event.EsmPri601404Event;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event.EsmPri601405Event;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event.EsmPri601503Event;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event.EsmPri601504Event;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event.EsmPri601505Event;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event.EsmPri6045Event;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event.EsmPri6056Event;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event.EsmPri6057Event;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event.EsmPri6061Event;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event.EsmPri6063Event;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event.EsmPri6066Event;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event.EsmPri6069Event;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event.EsmPri6072Event;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event.EsmPri6076Event;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event.EsmPri6077Event;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event.EsmPri6079Event;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event.EsmPri6082Event;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event.EsmPri6089Event;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event.EsmPri6094Event;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event.EsmPri6095Event;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event.EsmPri6096Event;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event.EsmPri6097Event;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event.EsmPri6098Event;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event.EsmPri6099Event;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration.RFARateQuotationDBDAO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.FicRouteGroupVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.InPriCommodityRouteVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RFARateQuotationVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltCmpbViewAllListVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltFicCheckCYPortLocationVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriCommodityRouteVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriCostDetailByTransModeListVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriCostSimulationCheckRouteVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriPrsCostDetailVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriPrsCostListVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriRateCmViewAllVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriRqRtCmdtRoutVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriRqRtCmdtVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriRqRtDuplicateCheckVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriRqRtListHorizontalExcelForAddOnTariffVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriRqRtListVerticalExcelForAddOnTariffVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriSurchargeAdjustCommodityDetailVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriSurchargeAdjustCommodityVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriSurchargeAdjustListVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriSurchargeAdjustLocationGroupDetailVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriSurchargeAdjustLocationGroupVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriSurchargeLastAccessDateVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriSurchargeViewAllVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPrsSurchargeDetailListVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltRtListHorizontalExcelForIHCVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltRtListHorizontalExcelVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltRtListVerticalExcelForIHCVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltRtListVerticalExcelVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.basic.SCRateProposalBC;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.basic.SCRateProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.InPriPrsRoutCsVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltRouteCaseCostVersionVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ComUpldFileVO;
import com.hanjin.syscommon.common.table.PriPrsBatVO;
import com.hanjin.syscommon.common.table.PriRqHdrVO;
import com.hanjin.syscommon.common.table.PriRqMnVO;
import com.hanjin.syscommon.common.table.PriRqRtUsdRoutCsVO;

/**
 * ALPS-RFAQuotation Business Logic ServiceCommand - ALPS-RFAQuotation 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author SONG MIN SEOK
 * @see RFARateQuotationDBDAO
 * @since J2EE 1.6
 */

public class RFAQuotationSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * RFAQuotation system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("RFAQuotationSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * RFAQuotation system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("RFAQuotationSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-RFAQuotation system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		// ============================ESM_PRI_6063_Start====================================
		if (e.getEventName().equalsIgnoreCase("EsmPri6063Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCostDetailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCostDetailInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyPrsCost(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = modifyPrsSimulationCost(e);
			}
			// =============================ESM_PRI_6063_end===================================
		}

		// ============================ESM_PRI_6069_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri6069Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRateSurchargeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageRateSurcharge(e);
			}
			// =============================ESM_PRI_6069_end===================================
		}
		// ============================ESM_PRI_6072_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri6072Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSurchargeAdjustList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSurchargeAdjust(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageSurchargeAdjustCalc(e);
			}
			// =============================ESM_PRI_6072_end===================================
		}

		// ============================esm_pri_6079_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri6079Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRateCommodityAllList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRateGroupCommodityDetailList(e);
			}
			// =============================esm_pri_6079_end===================================
		}
		// ============================esm_pri_6082_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri6082Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRateLocationAllList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRateGroupLocationDetailList(e);
			}
			// =============================esm_pri_6082_end===================================
		}
		// ============================esm_pri_6066_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri6066Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCostDetailByTransModeList(e);
			}
			// =============================esm_pri_6066_end===================================
		}

		// ============================ESM_PRI_6077_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri6077Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRateCmViewAllList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyPrsPfmc(e);
			}
			// =============================ESM_PRI_6077_end===================================
		}
		// ============================ESM_PRI_6061_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri6061Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCommodityRouteList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyRateRfaQuotation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchCommodityRouteAreaList(e);
			} else {
				eventResponse = searchInitCommodityRoute(e);
			}
			// =============================ESM_PRI_6061_end===================================
		}

		// ESM_PRI_6014 RFA Quotation Creation start
		// ////////////////////////////////////////////////////////////////////////////////
		else if (e.getEventName().equalsIgnoreCase("EsmPri6014Event")) {

			// search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRfaQuotationMainList(e);
			}
			// gline count 체크
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchGlineExist(e);
			}
			// calculate 했는지 체크
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = checkCalculate(e);
			}
			// cmdt seq 별 rate가 있는지 체크
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = checkExistRate(e);
			}
			// calculate 필요 여부 체크
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchRfaQuotationMainChkNeedCalcList(e);
			}
			// 텝별 건수 조회
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchDetailCnt(e);
			}
			// save
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageRfaQuotationMain(e);
			}
			// DELETE
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = removeRfaQuotationMain(e);
			}
			// cancel
			else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = cancelStatusRfaQuotationMain(e);
			}
			// add version
			else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = createVersionRfaQuotationMain(e);
			}
			// 권한
			else {
				eventResponse = searchAuthorizationOffice(e);
			}
		}
		// ESM_PRI_6014 RFA Quotation Creation end
		// ////////////////////////////////////////////////////////////////////////////////

		// ESM_PRI_6014_01 RFA Quotation Location Group Creation start
		// ////////////////////////////////////////////////////////////////////////////////
		else if (e.getEventName().equalsIgnoreCase("EsmPri601401Event")) {

			// search master
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRfaQuotationGroupLocationList(e);
			}
			// search detail
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupLocationDetailList(e);
			}
			// search rate 사용여부
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkGroupLocationInUse(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageRfaGroupLocationQuotation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = glineCopyRfaGroupLocationQuotation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI07)) {
				eventResponse = checkOriDestGroupLocationInUse(e);
			}
		}
		// ESM_PRI_6014_01 RFA Quotation Location Group Creation end
		// ////////////////////////////////////////////////////////////////////////////////

		// ESM_PRI_6014_02 RFA Quotation Commodity Group Creation start
		// ////////////////////////////////////////////////////////////////////////////////
		else if (e.getEventName().equalsIgnoreCase("EsmPri601402Event")) {

			// search master
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRfaGroupCommodityQuotationList(e);
			}
			// search detail
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupCommodityDetailList(e);
			}
			// search cmdt 사용여부
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkGroupCommodityInUse(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageRfaGroupCommodityQuotation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = glineCopyRfaGroupCommodityQuotation(e);
			}
		}
		// ESM_PRI_6014_02 RFA Quotation Commodity Group Creation end
		// ////////////////////////////////////////////////////////////////////////////////

		// ESM_PRI_6014_03 RFA Quotation Rate Creation start
		// ////////////////////////////////////////////////////////////////////////////////
		else if (e.getEventName().equalsIgnoreCase("EsmPri601403Event")) {

			// search commodity
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRfaRateQuotationList(e);
			}
			// search cmdt rout
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRateCommodityRouteList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchRateList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchRateListVerticalExcel(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchRateListHorizontalExcel(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageCommodityRouteRateRfaRateQuotation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageRouteRateRfaRateQuotation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = glineCopyRfaRateQuotation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = executeCalculate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = monitorCalculate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = searchRateCommoditySequence(e);
			}
		}
		// ESM_PRI_6014_03 RFA Quotation Rate Creation end
		// ////////////////////////////////////////////////////////////////////////////////

		// ESM_PRI_6058 RFA Quotation Rate Creation - G/L Copy Option start
		// ////////////////////////////////////////////////////////////////////////////////
		else if (e.getEventName().equalsIgnoreCase("EsmPri6058Event")) {

			// Gline Copy
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = glineCopyRfaQuotaion(e);
			}

		}
		// ESM_PRI_6008 S/C Quotation Rate Creation - G/L Copy Option end
		// ////////////////////////////////////////////////////////////////////////////////

		// ESM_PRI_6044 RFA Quotation Copy to Quotation start
		// ////////////////////////////////////////////////////////////////////////////////
		else if (e.getEventName().equalsIgnoreCase("EsmPri6044Event")) {

			// Quotation Copy
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = copyToQuotationRfaQuotaionReport(e);
			}

		}
		// ESM_PRI_6034 S/C Quotation Copy to Quotation end
		// ////////////////////////////////////////////////////////////////////////////////

		// ESM_PRI_6045 RFA Quotation Creation - Rate [Check Duplicate] start
		// ////////////////////////////////////////////////////////////////////////////////
		else if (e.getEventName().equalsIgnoreCase("EsmPri6045Event")) {
			// Quotation Copy
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRateDuplicateList(e);
			}

		}
		// ESM_PRI_6045 RFA Quotation Creation - Rate [Check Duplicate] end
		// ////////////////////////////////////////////////////////////////////////////////

		// ESM_PRI_6015 RFA Quotation Inquiry start
		// ////////////////////////////////////////////////////////////////////////////////
		else if (e.getEventName().equalsIgnoreCase("EsmPri6015Event")) {

			// search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRfaQuotationMainReportList(e);
			}

		}
		// ESM_PRI_6015 RFA Quotation Inquiry end
		// ////////////////////////////////////////////////////////////////////////////////

		// ESM_PRI_6015_01 RFA Quotation Location Group Inquiry start
		// ////////////////////////////////////////////////////////////////////////////////
		else if (e.getEventName().equalsIgnoreCase("EsmPri601501Event")) {

			// search master
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRfaQuotationGroupLocationReportList(e);
			}
			// search detail
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupLocationDetailReportList(e);
			}

		}
		// ESM_PRI_6015_01 RFA Quotation Location Group Inquiry end
		// ////////////////////////////////////////////////////////////////////////////////

		// ESM_PRI_6015_02 RFA Quotation Commodity Group Inquiry start
		// ////////////////////////////////////////////////////////////////////////////////
		else if (e.getEventName().equalsIgnoreCase("EsmPri601502Event")) {

			// search master
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRfaGroupCommodityQuotationReportList(e);
			}
			// search detail
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupCommodityDetailReportList(e);
			}

		}
		// ESM_PRI_6015_02 RFA Quotation Commodity Group Inquiry end
		// ////////////////////////////////////////////////////////////////////////////////

		// ESM_PRI_6015_03 RFA Quotation Rate Inquiry start
		// ////////////////////////////////////////////////////////////////////////////////
		else if (e.getEventName().equalsIgnoreCase("EsmPri601503Event")) {

			// search commodity
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRfaRateQuotationReportList(e);
			}
			// search cmdt rout
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRateCommodityRouteReportList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchRateReportList(e);
			}

		}
		// ESM_PRI_6015_03 RFA Quotation Rate Inquiry end
		// ////////////////////////////////////////////////////////////////////////////////

		// ESM_PRI_6076 RFA Quotation-Rate CMPB View All start
		// ////////////////////////////////////////////////////////////////////////////////
		else if (e.getEventName().equalsIgnoreCase("EsmPri6076Event")) {

			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRateCmpbViewAllList(e);
			}

		}

		// ESM_PRI_6056 RQ Rate Creation - Excel Import(Horizontal) start
		// ////////////////////////////////////////////////////////////////////////////////
		else if (e.getEventName().equalsIgnoreCase("EsmPri6056Event")) {
			// search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkRateExcelHorizontal(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = uploadRateExcelHorizontal(e);
			} else {
				eventResponse = initRateExcelHorizontal(e);
			}
		}
		// ESM_PRI_6056 RQ Rate Creation - Excel Import(Horizontal) end
		// ////////////////////////////////////////////////////////////////////////////////

		// ESM_PRI_6057 RQ Rate Creation - Excel Import(Vertical) start
		// ////////////////////////////////////////////////////////////////////////////////
		else if (e.getEventName().equalsIgnoreCase("EsmPri6057Event")) {
			// search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkRateExcelVertical(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = uploadRateExcelVertical(e);
			} else {
				eventResponse = initRateExcelVertical(e);
			}
		}
		// ESM_PRI_6057 RQ Rate Creation - Excel Import(Vertical) end
		// ////////////////////////////////////////////////////////////////////////////////

		// ESM_PRI_6046 RFA Quotation Copy To Proposal start
		// ////////////////////////////////////////////////////////////////////////////////
		else if (e.getEventName().equalsIgnoreCase("EsmPri6046Event")) {
			// Copy To Proposal
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = copyToPropRfaQuotation(e);
			}

		}
		// ESM_PRI_6046 RFA Quotation Copy To Proposal end
		// ////////////////////////////////////////////////////////////////////////////////
		// =============================ESM_PRI_6089_start===================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri6089Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSurchargeViewAllList(e);
			}
		}
		// =============================ESM_PRI_6086_end ===================================

		// ESM_PRI_6014_04 RFA Quotation Rate Creation start (For AEW/AEE)
		// ////////////////////////////////////////////////////////////////////////////////
		else if (e.getEventName().equalsIgnoreCase("EsmPri601404Event")) {
			// search commodity
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRfaRateQuotationListForIHC(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchRateListForIHC(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchRateListVerticalExcelForIHC(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchRateListHorizontalExcelForIHC(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageCommodityRouteRateRfaRateQuotationForIHC(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageRouteRateRfaRateQuotationForIHC(e);
			}
		}
		// ESM_PRI_6014_04 RFA Quotation Rate Creation end
		// ////////////////////////////////////////////////////////////////////////////////

		// ESM_PRI_6094 RFA Quotation Rate - Origin & Destination(For AEW/AEE) start
		// ////////////////////////////////////////////////////////////////////////////////
		else if (e.getEventName().equalsIgnoreCase("EsmPri6094Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchFICRouteGroup(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkCYPortLocation(e);
			}
		}
		// ESM_PRI_6094 RFA Quotation Rate - Origin & Destination (For AEW/AEE) end
		// ////////////////////////////////////////////////////////////////////////////////

		// ESM_PRI_6095 RQ Rate Creation - Excel Import(Vertical) start
		// ////////////////////////////////////////////////////////////////////////////////
		else if (e.getEventName().equalsIgnoreCase("EsmPri6095Event")) {
			// search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkRateExcelVerticalForIHC(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchFicGuidelineRateForIHC(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = uploadRateExcelVerticalForIHC(e);
			} else {
				eventResponse = initRateExcelVerticalForIHC(e);
			}
		}
		// ESM_PRI_6095 RQ Rate Creation - Excel Import(Vertical) end
		// ////////////////////////////////////////////////////////////////////////////////

		// ESM_PRI_6096 RQ Rate Creation - Excel Import(Horizontal) start
		// ////////////////////////////////////////////////////////////////////////////////
		else if (e.getEventName().equalsIgnoreCase("EsmPri6096Event")) {
			// search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkRateExcelHorizontalForIHC(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = uploadRateExcelHorizontalForIHC(e);
			} else {
				eventResponse = initRateExcelHorizontalForIHC(e);
			}
		}
		// ESM_PRI_6096 RQ Rate Creation - Excel Import(Horizontal) end
		// ////////////////////////////////////////////////////////////////////////////////

		// ESM_PRI_6015_04 RFA Quotation Rate Inquiry start
		// ////////////////////////////////////////////////////////////////////////////////
		else if (e.getEventName().equalsIgnoreCase("EsmPri601504Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRfaRateQuotationIhcReportList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRateCommodityRouteIhcReportList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchRateIhcReportList(e);
			}
		}
		// ESM_PRI_6015_04 RFA Quotation Rate Inquiry end
		// ////////////////////////////////////////////////////////////////////////////////

		// ESM_PRI_6014_05 RFA Quotation Rate Creation start (For Add-On Tariff)
		else if (e.getEventName().equalsIgnoreCase("EsmPri601405Event")) {
			// search commodity
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRfaRateQuotationListForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRateCommodityRouteListForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchRateListForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = executeCalculateForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = monitorCalculateForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchRateListVerticalExcelForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchRateListHorizontalExcelForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = searchRateCommoditySequenceForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageCommodityRouteRateRfaRateQuotationForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageRouteRateRfaRateQuotationForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = glineCopyRfaRateQuotationForAddOnTariff(e);
			}
		}
		// ESM_PRI_6014_05 RFA Quotation Rate Creation end
		else if (e.getEventName().equalsIgnoreCase("EsmPri6097Event")) {
			// ESM_PRI_6097 RFA Quotation Rate - Origin & Destination(For AEW/AEE) start
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchFICRouteGroupForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkCYPortLocationForAddOnTariff(e);
			}
			// ESM_PRI_6097 RFA Quotation Rate - Origin & Destination (For AEW/AEE) end
		} else if (e.getEventName().equalsIgnoreCase("EsmPri6098Event")) {
			// ESM_PRI_6098 RQ Rate Creation - Excel Import For Add-On Tariff(Vertical) start
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkRateExcelVerticalForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchFicGuidelineRateForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = uploadRateExcelVerticalForAddOnTariff(e);
			} else {
				eventResponse = initRateExcelVerticalForAddOnTariff(e);
			}
			// ESM_PRI_6098 RQ Rate Creation - Excel Import For Add-On Tariff(Vertical) end
		} else if (e.getEventName().equalsIgnoreCase("EsmPri6099Event")) {
			// ESM_PRI_6099 RQ Rate Creation - Excel Import For Add-On Tariff(Horizontal) start
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkRateExcelHorizontalForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = uploadRateExcelHorizontalForAddOnTariff(e);
			} else {
				eventResponse = initRateExcelHorizontalForAddOnTariff(e);
			}
			// ESM_PRI_6099 RQ Rate Creation - Excel Import For Add-On Tariff(Horizontal) end
		} else if (e.getEventName().equalsIgnoreCase("EsmPri601505Event")) {
			// ESM_PRI_6015_05 RQ Inquiry - start
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRfaRateQuotationReportListForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRateCommodityRouteReportListForAddOnTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchRateReportListForAddOnTariff(e);
			}
			// ESM_PRI_6015_05 RQ Inquiry - END
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_6063 : Retrieve <br>
	 * PRS- Cost Detail List 확인 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostDetailList(Event e) throws EventException {
		log.debug("===================================>>>>>>>>>>>>>>>>>searchCostDetailList");
		// PDTO(Data Transfer Object including Parameters)
		EsmPri6063Event event = (EsmPri6063Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RFARateQuotationBC command1 = new RFARateQuotationBCImpl();
		try {
			List<RsltPriPrsCostListVO> list = command1.searchCostDetailList(event.getRsltPriPrsCostListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6063 : Retrieve <br>
	 * PRS- Cost Detail List 확인 상세 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostDetailInquiryList(Event e) throws EventException {
		log.debug("===================================>>>>>>>>>>>>>>>>>searchCostDetailInquiryList");
		// PDTO(Data Transfer Object including Parameters)
		EsmPri6063Event event = (EsmPri6063Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RFARateQuotationBC command1 = new RFARateQuotationBCImpl();
		try {
			List<RsltPriPrsCostDetailVO> list = command1.searchCostDetailInquiryList(event.getRsltPriPrsCostDetailVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6069 : Retrieve , onLoad , onSaveEnd <BR>
	 * PRS- Applicable Route, Surcharge Detail을 조회 처리합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateSurchargeList(Event e) throws EventException {
		EsmPri6069Event event = (EsmPri6069Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RFARateQuotationBC command1 = new RFARateQuotationBCImpl();
		try {
			RsltPrsSurchargeDetailListVO rsltPrsSurchargeDetailListVO = command1.searchRateSurchargeList(event.getInpPrsSurchargeDetailApplicableRouteVO());
			eventResponse.setRsVoList(rsltPrsSurchargeDetailListVO.getRsltPrsSurchargeDetailApplicableRouteVOS());
			eventResponse.setRsVoList(rsltPrsSurchargeDetailListVO.getRsltPrsSurchargeDetailVOS());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_6069 : Save <BR>
	 * PRS- Surcharge Detail 내용을 추가,삭제,갱신처리 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRateSurcharge(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6069Event event = (EsmPri6069Event) e;

		try {
			begin();
			RFARateQuotationBC command = new RFARateQuotationBCImpl();
			command.manageRateSurcharge(event.getPriRqRtScgVOS(), account);

			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6072 : Retrieve , onLoad, onSaveEnd <BR>
	 * PRS- Surcharge Adjust을 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSurchargeAdjustList(Event e) throws EventException {
		EsmPri6072Event event = (EsmPri6072Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RFARateQuotationBC command1 = new RFARateQuotationBCImpl();
		try {
			List<RsltPriSurchargeAdjustListVO> list = command1.searchSurchargeAdjustList(event.getRsltPriSurchargeAdjustListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_6072 : Save <BR>
	 * PRS- Surcharge Adjust 내용을 추가,삭제,갱신처리 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSurchargeAdjust(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6072Event event = (EsmPri6072Event) e;

		try {
			begin();
			RFARateQuotationBC command = new RFARateQuotationBCImpl();
			command.manageSurchargeAdjust(event.getPriRqScgAdjVOS(), account);

			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6072 : OK <BR>
	 * PRS- Surcharge Adjust 내용을 바탕으로 Calculate Logic을 수행합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSurchargeAdjustCalc(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6072Event event = (EsmPri6072Event) e;

		try {
			begin();
			RFARateQuotationBC command = new RFARateQuotationBCImpl();
			command.manageSurchargeAdjustCalc(event.getPriRqScgAdjVOS()[0], account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6079 : onLoad <BR>
	 * Commodity Group을 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCommodityAllList(Event e) throws EventException {
		EsmPri6079Event event = (EsmPri6079Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RFARateQuotationBC command1 = new RFARateQuotationBCImpl();
		try {
			List<RsltPriSurchargeAdjustCommodityVO> list = command1.searchRateCommodityAllList(event.getRsltPriSurchargeAdjustCommodityVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6079 : onLoad, sheet1_onClick <BR>
	 * Surcharge Adjust-Commodity group에 대한 상세 내용을 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateGroupCommodityDetailList(Event e) throws EventException {
		EsmPri6079Event event = (EsmPri6079Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RFARateQuotationBC command1 = new RFARateQuotationBCImpl();
		try {
			List<RsltPriSurchargeAdjustCommodityDetailVO> list = command1.searchRateGroupCommodityDetailList(event.getRsltPriSurchargeAdjustCommodityDetailVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6082 : onLoad <BR>
	 * Surcharge Adjust-Location Group을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateLocationAllList(Event e) throws EventException {
		EsmPri6082Event event = (EsmPri6082Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RFARateQuotationBC command1 = new RFARateQuotationBCImpl();
		try {
			List<RsltPriSurchargeAdjustLocationGroupVO> list = command1.searchRateLocationAllList(event.getRsltPriSurchargeAdjustLocationGroupVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6082 : onLoad, sheet1_onClick <BR>
	 * SSurcharge Adjust-Location Group에 상세 정보를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateGroupLocationDetailList(Event e) throws EventException {
		log.debug("===================================>>>>>>>>>>>>>>>>>searchGroupCommodityDetailList");
		// PDTO(Data Transfer Object including Parameters)
		EsmPri6082Event event = (EsmPri6082Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RFARateQuotationBC command1 = new RFARateQuotationBCImpl();
		try {
			List<RsltPriSurchargeAdjustLocationGroupDetailVO> list = command1.searchRateGroupLocationDetailList(event.getRsltPriSurchargeAdjustLocationGroupDetailVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6066 : onLoad , Retrieve <BR>
	 * Trans.Mode에 따른 Cost 상세정보를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostDetailByTransModeList(Event e) throws EventException {
		EsmPri6066Event event = (EsmPri6066Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RFARateQuotationBC command1 = new RFARateQuotationBCImpl();
		try {
			List<RsltPriCostDetailByTransModeListVO> list = command1.searchCostDetailByTransModeList(event.getRsltPriCostDetailByTransModeListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6077 : Retrieve , onLoad, radioButton_onChange(rate_type,pfmc_unit) <BR>
	 * CM/OP View 내용을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCmViewAllList(Event e) throws EventException {
		log.debug("===================================>>>>>>>>>>>>>>>>>searchRateCmViewAllList");
		// PDTO(Data Transfer Object including Parameters)
		EsmPri6077Event event = (EsmPri6077Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RFARateQuotationBC command1 = new RFARateQuotationBCImpl();
		try {
			List<RsltPriRateCmViewAllVO> list = command1.searchRateCmViewAllList(event.getRsltPriRateCmViewAllVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6077 : Save <BR>
	 * CM/OP View 의 Load 값을 갱신처리 합니다.
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyPrsPfmc(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6077Event event = (EsmPri6077Event) e;
		try {
			begin();
			RFARateQuotationBC command = new RFARateQuotationBCImpl();
			RFAQuotationMainBC command2 = new RFAQuotationMainBCImpl();
			command.modifyPrsPfmc(event.getPriRqRtCmdtRoutSetVO(), account);
			command2.modifyPrsPriRqMnCm(event.getPriRqRtCmdtRoutSetVO(), account);

			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	// ESM_PRI_6014 RFA Quotation Creation start
	// ////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_6014 : Retrieve <br>
	 * Quotation Main 정보를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRfaQuotationMainList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6014Event event = (EsmPri6014Event) e;
		RFAQuotationMainBC command = new RFAQuotationMainBCImpl();

		try {
			List<RsltPriRqMnVO> list = command.searchRfaQuotationMainList(event.getQutationMainVO().getRsltPriRqMnVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014 : Retrieve <br>
	 * Quotation Main 정보에 대해 calculate 를 수행 했는지를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRfaQuotationMainChkNeedCalcList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6014Event event = (EsmPri6014Event) e;
		RFAQuotationMainBC command = new RFAQuotationMainBCImpl();

		try {
			List<RsltPriRqMnChkNeedCalcVO> list = command.searchRfaQuotationMainChkNeedCalcList(event.getQutationMainVO().getRsltPriRqMnVO());
			eventResponse.setRsVoList(list);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014 : Retrieve <br>
	 * GLINE 존재여부 체크.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGlineExist(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6014Event event = (EsmPri6014Event) e;
		RFAQuotationMainBC command = new RFAQuotationMainBCImpl();

		try {
			List<RsltSearchGlineExistVO> list = command.searchGlineExist(event.getQutationMainVO().getRsltPriRqMnVO());
			eventResponse.setRsVoList(list);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014 : Copy To Proposal <br>
	 * Copy to Proposal 전 calculate 했는지 체크한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCalculate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6014Event event = (EsmPri6014Event) e;
		RFAQuotationMainBC command = new RFAQuotationMainBCImpl();
		String cnt_cal = "0";
		try {
			cnt_cal = command.checkCalculate(event.getQutationMainVO().getRsltPriRqMnVO());
			eventResponse.setETCData("cnt_cal", cnt_cal);
			log.debug("*********************************************************");
			log.debug("cnt_cal : " + eventResponse.getETCData("cnt_cal"));
			log.debug("*********************************************************");

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014 : Add Version, Copy To Proposal <br>
	 * cmdt seq 별 rate data가 있는지 체크한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkExistRate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6014Event event = (EsmPri6014Event) e;
		RFAQuotationMainBC command = new RFAQuotationMainBCImpl();
		String cnt_non_rate = "0";
		try {
			cnt_non_rate = command.checkExistRate(event.getQutationMainVO().getRsltPriRqMnVO());
			eventResponse.setETCData("cnt_non_rate", cnt_non_rate);
			log.debug("*********************************************************");
			log.debug("cnt_non_rate : " + eventResponse.getETCData("cnt_non_rate"));
			log.debug("*********************************************************");

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014 : Retrieve <br>
	 * 텝별 건수 조회.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDetailCnt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6014Event event = (EsmPri6014Event) e;
		RFAQuotationMainBC command = new RFAQuotationMainBCImpl();

		try {

			String qttn_no_read = JSPUtil.getNullNoTrim(event.getQutationMainVO().getRsltPriRqMnVO().getQttnNoRead());
			String qttn_ver_no_read = JSPUtil.getNullNoTrim(event.getQutationMainVO().getRsltPriRqMnVO().getQttnVerNoRead());

			if (!"".equals(qttn_no_read) && !"".equals(qttn_ver_no_read)) {
				event.getQutationMainVO().getRsltPriRqMnVO().setQttnNo(qttn_no_read);
				event.getQutationMainVO().getRsltPriRqMnVO().setQttnVerNo(qttn_ver_no_read);
			}

			List<RsltSearchDetailCntVO> list = command.searchDetailCnt(event.getQutationMainVO().getRsltPriRqMnVO());
			eventResponse.setRsVoList(list);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014 : Save <br>
	 * PRI_RQ_HDR, PRI_RQ_MN 테이블 정보를 저장한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRfaQuotationMain(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6014Event event = (EsmPri6014Event) e;
		RFAQuotationMainBC command = new RFAQuotationMainBCImpl();

		try {
			begin();
			RsltPriRqMnVO rsltPriRqMnVO = command.manageRfaQuotationMain(event.getQutationMainVO(), account);

			eventResponse.setRsVo(rsltPriRqMnVO);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014 : Delete <br>
	 * QTTN NO 에 해당하는 모든 정보를 삭제한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeRfaQuotationMain(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6014Event event = (EsmPri6014Event) e;
		RFAQuotationMainBC command1 = new RFAQuotationMainBCImpl();
		RFAGroupLocationQuotationBC command2 = new RFAGroupLocationQuotationBCImpl();
		RFAGroupCommodityQuotationBC command3 = new RFAGroupCommodityQuotationBCImpl();
		RFARateQuotationBC command4 = new RFARateQuotationBCImpl();

		try {
			begin();
			command4.removeRfaRateQuotation(event.getQutationMainVO().getPriRqHdrVO());
			command3.removeManageRfaGroupCommodityQuotation(event.getQutationMainVO().getPriRqHdrVO());
			command2.removeRfaGroupLocationQuotation(event.getQutationMainVO().getPriRqHdrVO());
			command1.removeRfaQuotationMain(event.getQutationMainVO().getPriRqHdrVO());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014 : Cancel <br>
	 * Quotation 상태코드 cancel로 저장한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelStatusRfaQuotationMain(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6014Event event = (EsmPri6014Event) e;
		RFAQuotationMainBC command = new RFAQuotationMainBCImpl();

		try {
			begin();
			event.getQutationMainVO().getPriRqHdrVO().setQttnStsCd("C");
			command.cancelStatusRfaQuotationMain(event.getQutationMainVO().getPriRqHdrVO(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014 : Add Version <br>
	 * Quotation ver no를 신규로 채번한 후 선택한 Quotation를 등록한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createVersionRfaQuotationMain(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6014Event event = (EsmPri6014Event) e;

		RFAQuotationMainBC command1 = new RFAQuotationMainBCImpl();
		RFAGroupLocationQuotationBC command2 = new RFAGroupLocationQuotationBCImpl();
		RFAGroupCommodityQuotationBC command3 = new RFAGroupCommodityQuotationBCImpl();
		RFARateQuotationBC command4 = new RFARateQuotationBCImpl();

		try {
			begin();

			// status 를 세팅
			event.getQutationMainVO().getRsltCopyToQuotationVO().setQttnStsCd("N");

			// copy tpye 를 세팅
			event.getQutationMainVO().getRsltCopyToQuotationVO().setCopyType("AV");
			command1.copyToQuotationRfaQuotaionMainReport(event.getQutationMainVO().getRsltCopyToQuotationVO(), account);
			command2.copyToQuotationRfaGroupLocationQuotaionReport(event.getQutationMainVO().getRsltCopyToQuotationVO(), account);
			command3.copyToQuotationRfaGroupCommodityQuotaionReport(event.getQutationMainVO().getRsltCopyToQuotationVO(), account);
			command4.copyToQuotationRfaRateQuotaionReport(event.getQutationMainVO().getRsltCopyToQuotationVO(), account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	// ESM_PRI_6014 RFA Quotation Creation end
	// ////////////////////////////////////////////////////////////////////////////////

	// ESM_PRI_6014_01 RFA Quotation Location Group Creation start
	// ////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_6014_01 : Retrieve <br>
	 * Group Location 정보를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRfaQuotationGroupLocationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601401Event event = (EsmPri601401Event) e;
		RFAGroupLocationQuotationBC command = new RFAGroupLocationQuotationBCImpl();

		try {
			List<RsltPriRqGrpLocVO> list = command.searchRfaGroupLocationQuotationList(event.getGroupLocationQuotationVO().getPriRqGrpLocVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014_01 : Retrieve <br>
	 * Group Location Detail 정보를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupLocationDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601401Event event = (EsmPri601401Event) e;
		RFAGroupLocationQuotationBC command = new RFAGroupLocationQuotationBCImpl();

		try {
			List<RsltPriRqGrpLocDtlVO> list = command.searchGroupLocationDetailList(event.getGroupLocationQuotationVO().getPriRqGrpLocVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014_01 : Delete<br>
	 * Group Loc 삭제시, Rate에서 사용하고 있는 코드인지 확인한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse checkGroupLocationInUse(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601401Event event = (EsmPri601401Event) e;
		RFAGroupLocationQuotationBC command = new RFAGroupLocationQuotationBCImpl();

		try {
			List<RsltCdListVO> vos = command.checkGroupLocationInUse(event.getGroupLocationQuotationVO());
			eventResponse.setRsVoList(vos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014_01 : Save <br>
	 * Group Location 정보를 저장한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRfaGroupLocationQuotation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601401Event event = (EsmPri601401Event) e;
		RFAGroupLocationQuotationBC command = new RFAGroupLocationQuotationBCImpl();

		try {
			begin();
			command.manageRfaGroupLocationQuotation(event.getGroupLocationQuotationVO(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014_01 : G/L Copy <br>
	 * PRI_SQ_GRP_LOC, PRI_SQ_GRP_LOC_DTL 에 가이드라인 정보를 카피 입력한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse glineCopyRfaGroupLocationQuotation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601401Event event = (EsmPri601401Event) e;
		RFAGroupLocationQuotationBC command = new RFAGroupLocationQuotationBCImpl();

		try {
			begin();
			command.glineCopyRfaGroupLocationQuotation(event.getGroupLocationQuotationVO().getRsltPriRqMnVO(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	// ESM_PRI_6014_01 RFA Quotation Location Group Creation end
	// ////////////////////////////////////////////////////////////////////////////////

	// ESM_PRI_6014_02 RFA Quotation Commodity Group Creation start
	// ////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_6014_02 : Retrieve <br>
	 * Group Commodity 정보를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRfaGroupCommodityQuotationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601402Event event = (EsmPri601402Event) e;
		RFAGroupCommodityQuotationBC command = new RFAGroupCommodityQuotationBCImpl();

		try {
			List<RsltPriRqGrpCmdtVO> list = command.searchRfaGroupCommodityQuotationList(event.getGroupCommodityQuotationVO().getPriRqGrpCmdtVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014_02 : Retrieve <br>
	 * Group Commodity Detail 정보를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodityDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601402Event event = (EsmPri601402Event) e;
		RFAGroupCommodityQuotationBC command = new RFAGroupCommodityQuotationBCImpl();

		try {
			List<RsltPriRqGrpCmdtDtlVO> list = command.searchGroupCommodityDetailList(event.getGroupCommodityQuotationVO().getPriRqGrpCmdtVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014_02 : Delete<br>
	 * Group cmdt 삭제시, Rate에서 사용하고 있는 코드인지 확인한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse checkGroupCommodityInUse(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601402Event event = (EsmPri601402Event) e;
		RFAGroupCommodityQuotationBC command = new RFAGroupCommodityQuotationBCImpl();

		try {
			List<RsltCdListVO> vos = command.checkGroupCommodityInUse(event.getGroupCommodityQuotationVO());
			eventResponse.setRsVoList(vos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014_02 : Save <br>
	 * Group Commodity 정보를 저장한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRfaGroupCommodityQuotation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601402Event event = (EsmPri601402Event) e;
		RFAGroupCommodityQuotationBC command = new RFAGroupCommodityQuotationBCImpl();

		try {
			begin();
			command.manageRfaGroupCommodityQuotation(event.getGroupCommodityQuotationVO(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014_02 : G/L Copy <br>
	 * PRI_SQ_GRP_CMDT, PRI_SQ_GRP_CMDT_DTL 에 가이드라인 정보를 카피 입력한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse glineCopyRfaGroupCommodityQuotation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601402Event event = (EsmPri601402Event) e;
		RFAGroupCommodityQuotationBC command = new RFAGroupCommodityQuotationBCImpl();

		try {
			begin();
			command.glineCopyRfaGroupCommodityQuotation(event.getGroupCommodityQuotationVO().getRsltPriRqMnVO(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	// ESM_PRI_6014_02 RFA Quotation Commodity Group Creation end
	// ////////////////////////////////////////////////////////////////////////////////

	// ESM_PRI_6014_03 S/C Quotation Rate Creation start
	// ////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_6014_03 : Retrieve <br>
	 * PRI_RQ_RT_CMDT_HDR, PRI_RQ_RT_CMDT 을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRfaRateQuotationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601403Event event = (EsmPri601403Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();

		try {
			List<RsltPriRqRtCmdtVO> list = command.searchRfaRateQuotationList(event.getRateQuotationVO().getPriRqRtCmdtHdrVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014_03 : Retrieve <br>
	 * PRI_RQ_RT_CMDT_ROUT 을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCommodityRouteList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601403Event event = (EsmPri601403Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();

		try {
			List<RsltPriRqRtCmdtRoutVO> list = command.searchRateCommodityRouteList(event.getRateQuotationVO().getPriRqRtCmdtHdrVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014_03 : Retrieve <br>
	 * PRI_RQ_RT_ROUT_PNT,PRI_RQ_RT_ROUT_VIA,PRI_RQ_RT 을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601403Event event = (EsmPri601403Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();

		// 컨테이너 vo
		RFARateQuotationVO rateQuotationVO = new RFARateQuotationVO();

		try {
			rateQuotationVO = command.searchRateList(event.getRateQuotationVO());

			eventResponse.setRsVoList(rateQuotationVO.getRsltPriRqRtCmdtVOList());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriRqRtVOList());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriRqRtRoutOrgPntVOs());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriRqRtRoutOrgViaVOList());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriRqRtRoutDestViaVOList());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriRqRtRoutDestPntVOs());

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014_03 : Down Excel <br>
	 * RATE 관련 정보를 조회한다.(EXCEL DOWN VerticalExcel)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateListVerticalExcel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601403Event event = (EsmPri601403Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();

		try {
			List<RsltRtListVerticalExcelVO> list = command.searchRateListVerticalExcel(event.getRateQuotationVO().getPriRqRtCmdtHdrVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014_03 : Down Excel <br>
	 * RATE 관련 정보를 조회한다.(EXCEL DOWN Horizontal)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateListHorizontalExcel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601403Event event = (EsmPri601403Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();

		try {
			List<RsltRtListHorizontalExcelVO> list = command.searchRateListHorizontalExcel(event.getRateQuotationVO().getPriRqRtCmdtHdrVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014_03 : Save <br>
	 * PRI_RQ_RT_CMDT_HDR, PRI_RQ_RT_CMDT 입력 수정 삭제한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCommodityRouteRateRfaRateQuotation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601403Event event = (EsmPri601403Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();

		try {
			begin();
			command.manageCommodityRouteRateRfaRateQuotation(event.getRateQuotationVO(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014_03 : Save <br>
	 * PRI_RQ_RT_CMDT_ROUT, PRI_RQ_RT_ROUT_PNT, PRI_RQ_RT_ROUT_VIA, PRI_RQ_RT 입력 수정 삭제한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRouteRateRfaRateQuotation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601403Event event = (EsmPri601403Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();

		try {
			begin();
			command.manageRouteRateRfaRateQuotation(event.getRateQuotationVO(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014_03 : G/L Copy <br>
	 * Rate 관련 테이블 에 가이드라인 정보를 카피 입력한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse glineCopyRfaRateQuotation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601403Event event = (EsmPri601403Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();

		try {
			begin();
			command.glineCopyRfaRateQuotation(event.getRateQuotationVO().getRsltPriRqMnVO(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	// ESM_PRI_6014_03 RFA Quotation Commodity Rate end
	// ////////////////////////////////////////////////////////////////////////////////

	// ESM_PRI_6058 RFA Quotation Rate Creation - G/L Copy Option start
	// ////////////////////////////////////////////////////////////////////////////////

	/**
	 * ESM_PRI_6058 : OK <br>
	 * RFA Quotation Rate 관련 테이블에 가이드라인 정보를 카피 등록한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse glineCopyRfaQuotaion(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6058Event event = (EsmPri6058Event) e;
		RFAQuotationMainBC command1 = new RFAQuotationMainBCImpl();
		RFAGroupLocationQuotationBC command2 = new RFAGroupLocationQuotationBCImpl();
		RFAGroupCommodityQuotationBC command3 = new RFAGroupCommodityQuotationBCImpl();
		RFARateQuotationBC command4 = new RFARateQuotationBCImpl();
		String gline_seq = "";
		// 체크된 항목
		RsltSearchGlineExistVO vo = event.getQutationMainVO().getRsltSearchGlineExistVO();
		// tpw
		log.debug("========================================TPW");
		log.debug(vo.toString());
		try {

			gline_seq = command1.searchCopyGlineSeq(event.getQutationMainVO().getRsltPriRqMnVO()); // Copy 대상의 gline_seq

			log.debug("****************************** gline_seq : " + gline_seq);
			vo.setGlineSeq(gline_seq);

			if (JSPUtil.getNull(gline_seq).equals("")) {
				eventResponse.setUserMessage(new ErrorHandler("PRI00201").getUserMessage());
				return eventResponse;
			}

			begin();

			if (JSPUtil.getNullNoTrim(vo.getLocChk()).equals("2")) {
				log.debug("****************************** Copy Group Location");
				// PRI_SP_SCP_GRP_LOC/PRI_SP_SCP_GRP_LOC_DTL
				command2.glineCopyRfaGroupLocationQuotation(event.getQutationMainVO().getRsltPriRqMnVO(), account);
			}

			if (JSPUtil.getNullNoTrim(vo.getSvcScpCd()).equals("TPW")) {
				if (JSPUtil.getNullNoTrim(vo.getCmdtTpwChk()).equals("2") && !JSPUtil.getNullNoTrim(vo.getCmdtTpwMst()).equals("")) {
					log.debug("****************************** Copy Group Commodity TPW");
					command3.copyScopeGuidelineGrpCmdtTpw(vo, account);
				}
			} else {
				if (JSPUtil.getNullNoTrim(vo.getCmdtChk()).equals("2")) {
					log.debug("****************************** Copy Group Commodity");
					command3.glineCopyRfaGroupCommodityQuotation(event.getQutationMainVO().getRsltPriRqMnVO(), account);
				}
			}

			if (JSPUtil.getNullNoTrim(vo.getRateChk()).equals("2")) {
				log.debug("****************************** Copy Rate");
				command4.glineCopyRfaRateQuotation(event.getQutationMainVO().getRsltPriRqMnVO(), account);
			}

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	// ESM_PRI_6008 S/C Quotation Rate Creation - G/L Copy Option start end
	// ////////////////////////////////////////////////////////////////////////////////

	// ESM_PRI_6044 RFA Quotation Copy to Quotation start
	// ////////////////////////////////////////////////////////////////////////////////

	/**
	 * ESM_PRI_6044 : OK <br>
	 * RFA Quotation 정보를 신규 채번하여 등록한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse copyToQuotationRfaQuotaionReport(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6044Event event = (EsmPri6044Event) e;

		RFAQuotationMainBC command1 = new RFAQuotationMainBCImpl();
		RFAGroupLocationQuotationBC command2 = new RFAGroupLocationQuotationBCImpl();
		RFAGroupCommodityQuotationBC command3 = new RFAGroupCommodityQuotationBCImpl();
		RFARateQuotationBC command4 = new RFARateQuotationBCImpl();

		String max_qttn_no = "";
		String qttn_ver_no = "Q1";

		try {
			begin();
			// max_qttn_no search
			PriRqHdrVO vo = new PriRqHdrVO();
			vo.setQttnOfcCd(account.getOfc_cd());
			max_qttn_no = command1.searchRfaQuotationHeaderMaxQttnNo(vo);

			// max_qttn_no 를 세팅
			event.getRsltCopyToQuotationVO().setQttnNo(max_qttn_no);
			// max_qttn_ ver _no 를 세팅
			event.getRsltCopyToQuotationVO().setQttnVerNo(qttn_ver_no);
			// status 를 세팅
			event.getRsltCopyToQuotationVO().setQttnStsCd("N");

			// copy tpye 를 세팅
			event.getRsltCopyToQuotationVO().setCopyType("");

			log.debug("****************************** Copy Main");
			command1.copyToQuotationRfaQuotaionMainReport(event.getRsltCopyToQuotationVO(), account);

			if (JSPUtil.getNullNoTrim(event.getRsltCopyToQuotationVO().getFrmGrpLocCnt()).equals("Y")) {
				log.debug("****************************** Copy Group Location");
				command2.copyToQuotationRfaGroupLocationQuotaionReport(event.getRsltCopyToQuotationVO(), account);
			}

			if (JSPUtil.getNullNoTrim(event.getRsltCopyToQuotationVO().getFrmGrpCmdtCnt()).equals("Y")) {
				log.debug("****************************** Copy Group Commodity");
				command3.copyToQuotationRfaGroupCommodityQuotaionReport(event.getRsltCopyToQuotationVO(), account);
			}

			if (JSPUtil.getNullNoTrim(event.getRsltCopyToQuotationVO().getFrmRateGCnt()).equals("Y")) {
				log.debug("****************************** Copy General Rate");
				command4.copyToQuotationRfaRateQuotaionReport(event.getRsltCopyToQuotationVO(), account);
			}

			// 저장시 키값을 etc 에 리턴
			eventResponse.setETCData("quotation_no", max_qttn_no);
			log.debug("*********************************************************");
			log.debug("quotation_no : " + eventResponse.getETCData("quotation_no"));
			log.debug("*********************************************************");

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	// ESM_PRI_6044 RFA Quotation Copy to Quotation end
	// ////////////////////////////////////////////////////////////////////////////////

	// ESM_PRI_6045 RFA Quotation Creation - Rate [Check Duplicate] start
	// ////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_6045 : Retrieve <br>
	 * Duplicate List를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateDuplicateList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6045Event event = (EsmPri6045Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();
		try {
			List<RsltPriRqRtDuplicateCheckVO> list = command.searchRateDuplicateList(event.getFicRtTpCd(), event.getPriRqMnVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	// ESM_PRI_6045 RFA Quotation Creation - Rate [Check Duplicate] start end
	// ////////////////////////////////////////////////////////////////////////////////

	/**
	 * ESM_PRI_6063 : Save <BR>
	 * RFA RATE관련 Cost, CMPB,OPB 값을 갱신하고 그 갱신여부를 Mark해둔다.
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyPrsCost(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6063Event event = (EsmPri6063Event) e;
		try {
			begin();
			RFARateQuotationBC command = new RFARateQuotationBCImpl();
			command.modifyPrsCost(event.getRsltPriPrsCostListVOS(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI01072", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6023 : OK <BR>
	 * Pre CM/OP Simulation Cost관련 Cost, CMPB,OPB 값을 갱신.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyPrsSimulationCost(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6063Event event = (EsmPri6063Event) e;
		try {
			begin();
			RFARateQuotationBC command = new RFARateQuotationBCImpl();
			SCRateProposalBC commandForCopy = new SCRateProposalBCImpl();
			CalculateBC commandForCalculation = new CalculateBCImpl();
			// command.modifyPrsSimulationCost(event.getRsltPriPrsCostListVOS(),account);

			List<RsltPriPrsCostListVO> listRsltPriPrsCostListVO = new ArrayList<RsltPriPrsCostListVO>();
			String newRoutCsNo = null;
			String newRoutCsSrcDt = null;
			RsltPriPrsCostListVO[] rsltPriPrsCostListVOs = event.getRsltPriPrsCostListVOS();
			InPriPrsRoutCsVO inPriPrsRoutCsVO = event.getInPriPrsRoutCsVO();
			rsltPriPrsCostListVOs[0].setIbflag("U");
			rsltPriPrsCostListVOs[0].setUsdRoutCsSelFlg("N");
			rsltPriPrsCostListVOs[0].setUpdUsrId(account.getUsr_id());
			listRsltPriPrsCostListVO.add(rsltPriPrsCostListVOs[0]);
			// POL(TERM),POD(TERM)의 조합이 정확한지 검사 한다.
			List<RsltPriCostSimulationCheckRouteVO> checkList = command.searchCostSimulationCheckRoutList(event.getInCostSimulationCheckRouteVO());
			if (checkList.size() == 0) {
				// route와 term을 잘 못 입력 하였다.
				throw new EventException(new ErrorHandler("PRI03021").getMessage());
			}

			// 0. PRI_PRS_BAT에서 pgm_no = 'ESM_PRI_T001'인 ROW의
			// PARA_INFO_CTNT(ROUT_CS_SRC_DT) , PRS_BAT_ID(ROUT_CS_CLSS_NO)를 SELECT한다.
			RsltRouteCaseCostVersionVO rsltRouteCaseCostVersionVO = commandForCopy.searchRouteCaseCostVersion(); // <--

			// 1. 새로운 Rout_cs_no를 select한다.
			// RsltNewRoutCaseNoVO rsltNewRoutCaseNoVO = commandForCopy.searchNewRouteCaseNo(rsltRouteCaseCostVersionVO);
			// newRoutCsNo = rsltNewRoutCaseNoVO.getRoutCsNo();
			// newRoutCsSrcDt = rsltNewRoutCaseNoVO.getRoutCsSrcDt();
			RsltPriPrsRoutCsMaxRoutCsNoVO maxRoutCsVO = commandForCalculation.searchPriPrsRoutCsMaxRoutCsNoCalculate(null);
			newRoutCsNo = maxRoutCsVO.getRoutCsNo();
			newRoutCsSrcDt = rsltRouteCaseCostVersionVO.getParaInfoCtnt();
			log.debug("=====rsltNewRoutCaseNoVO==>" + newRoutCsNo);
			log.debug("=====rsltNewRoutCaseNoVO==>" + newRoutCsSrcDt);
			inPriPrsRoutCsVO.setUpdUsrId(account.getUsr_id());

			// 2. PRI_PRS_ROUT_CS(BATCH)에 한건을 INSERT한다.(화면에서 입력받은값을 사용.)
			inPriPrsRoutCsVO.setRoutCsNo(newRoutCsNo);
			inPriPrsRoutCsVO.setRoutCsClssNo(rsltRouteCaseCostVersionVO.getPrsBatId()); // <-- rout_cs_clss_no
			commandForCalculation.managePriPrsRouteCase(inPriPrsRoutCsVO, account);

			// 2. Route Case를 New Rout_cs_no를 이용해서 입력한다. (online)
			PriRqRtUsdRoutCsVO routCsVO = event.getPriRqRtUsdRoutCsVO();
			routCsVO.setRoutCsNo(newRoutCsNo);
			routCsVO.setRoutCsSrcDt(newRoutCsSrcDt);
			command.managePriRateUsedRouteCase(routCsVO, account); //

			// 3. Route를 변경한다. usd_rout_cs_sel_flg ( Y --> N )
			command.modifyPrsRateCommodityRoute(listRsltPriPrsCostListVO); //
			log.debug("===== ******************************* modifyRateCommodityRoute 종료  ==>");

			// 4. PRI_PRS_USD_ROUT_CS_INFO,PRI_PRS_USD_ROUT_ACT_COST,PRI_PRS_USD_ROUT_ESTM_COST Table에 COA 데이터 카피 Insert (online)
			log.debug("===== ******************************* copyBatchCostInfoToOnlineCostInfo 실행  ==>");
			inPriPrsRoutCsVO.setUpdUsrId(account.getUsr_id());
			inPriPrsRoutCsVO.setRoutCsNo(newRoutCsNo);
			inPriPrsRoutCsVO.setRoutCsSrcDt(newRoutCsSrcDt);
			commandForCalculation.copyCoaCostInfoToOnlineCostInfo(inPriPrsRoutCsVO, account);
			log.debug("===== ******************************* copyBatchCostInfoToOnlineCostInfo 종료  ==>");

			// 5. PRI_PRS_USD_ROUT_CS_INFO,PRI_PRS_USD_ROUT_ACT_COST,PRI_PRS_USD_ROUT_ESTM_COST Table에 Data를 Batch DB에 데이터 카피 Insert (online -> batch)
			log.debug("===== ******************************* copyBatchCostInfoToOnlineCostInfoBatch 실행  ==>");
			commandForCalculation.copyOnlineCostInfoToBatchCostInfo(inPriPrsRoutCsVO, account);
			log.debug("===== ******************************* copyBatchCostInfoToOnlineCostInfoBatch 종료  ==>");

			// 5. Calculate Batch Logic과 동일한 로직을 돌린다.
			command.modifyCalculateLogicData(listRsltPriPrsCostListVO); // XA Driver를 사용하면 문제가 생길수 있음 (Merge, with 문장)
			log.debug("===== *******************************  후 ==>");

			eventResponse.setUserMessage(new ErrorHandler("PRI01072").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6061 : onLoad <BR>
	 * Quotaion의 Commodity route 를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommodityRouteList(Event e) throws EventException {
		EsmPri6061Event event = (EsmPri6061Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RFARateQuotationBC command1 = new RFARateQuotationBCImpl();
		try {
			List<RsltPriCommodityRouteVO> list = command1.searchCommodityRouteList(event.getFicRtTpCd(), event.getInPriCommodityRouteVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6061 : OnLoad <BR>
	 * Quotaion의 route의 모든 Area 리스트 조회 <BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommodityRouteAreaList(Event e) throws EventException {
		EsmPri6061Event event = (EsmPri6061Event) e;

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RFARateQuotationBC command1 = new RFARateQuotationBCImpl();
		try {
			List<RsltCdListVO> list = command1.searchCommodityRouteAreaList(event.getInPriCommodityRouteVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6061 : OnLoad <BR>
	 * 초기 Combo에 setting할 초기값를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInitCommodityRoute(Event e) throws EventException {
		EsmPri6061Event event = (EsmPri6061Event) e;
		RFARateQuotationBC command1 = new RFARateQuotationBCImpl();
		PRICommonBC command = new PRICommonBCImpl();
		InPriCommodityRouteVO inVO = null;

		RsltCdListVO rsltcdlistvo = new RsltCdListVO();
		RsltCdListVO rsltVO = new RsltCdListVO();
		List<RsltCdListVO> customData = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		InPriCommodityRouteVO params = event.getInPriCommodityRouteVO();

		try {
			// Customer Type
			rsltcdlistvo.setEtc1(params.getCustCntCd());
			rsltcdlistvo.setEtc2(params.getCustSeq());
			customData = command.searchCustomerName(rsltcdlistvo);
			eventResponse.setCustomData("CustomerName", customData);

			// currency
			rsltcdlistvo = new RsltCdListVO();
			customData = command.searchCurrencyCodeList(rsltcdlistvo);
			eventResponse.setCustomData("Currency", customData);

			// per
			rsltcdlistvo = new RsltCdListVO();
			customData = command.searchPerCodeList(rsltcdlistvo);
			eventResponse.setCustomData("Per", customData);

			// cargo
			rsltcdlistvo = new RsltCdListVO();
			rsltcdlistvo.setCd("CD01701");
			customData = command.searchComCodeDescList(rsltcdlistvo);
			eventResponse.setCustomData("Cargo", customData);

			// CD01706 GRI APPLICATION DIVISION CODE
			rsltcdlistvo = new RsltCdListVO();
			rsltcdlistvo.setCd("CD01706");
			customData = command.searchComCodeList(rsltcdlistvo);
			eventResponse.setCustomData("Application", customData);

			// Creation Date
			inVO = event.getInPriCommodityRouteVO();
			rsltVO = command1.searchSCQuotationCreationDate(inVO);
			eventResponse.setCustomData("CreationDate", rsltVO);

			// Origin
			inVO = event.getInPriCommodityRouteVO();
			inVO.setOrgDestTpCd("O");
			inVO.setOpTpCd("A"); // Ori or Dest Pnt
			customData = command1.searchCommodityRouteAreaList(inVO);
			eventResponse.setCustomData("OriLoc", customData);
			// Dest
			inVO.setOrgDestTpCd("D");
			inVO.setOpTpCd("A");// Ori or Dest Pnt
			customData = command1.searchCommodityRouteAreaList(inVO);
			eventResponse.setCustomData("DestLoc", customData);
			// Ori Via
			inVO.setOrgDestTpCd("O");
			inVO.setOpTpCd("B");// Ori or Dest Via
			customData = command1.searchCommodityRouteAreaList(inVO);
			eventResponse.setCustomData("OriVia", customData);
			// Dest. Via
			inVO.setOrgDestTpCd("D");
			inVO.setOpTpCd("B");// Ori or Dest Via
			customData = command1.searchCommodityRouteAreaList(inVO);
			eventResponse.setCustomData("DestVia", customData);

			// Origin Term
			inVO = event.getInPriCommodityRouteVO();
			inVO.setOrgDestTpCd("O");
			inVO.setOpTpCd("C"); // Ori or Dest Term
			customData = command1.searchCommodityRouteAreaList(inVO);
			eventResponse.setCustomData("ReceiveTerm", customData);

			// Dest Term
			inVO = event.getInPriCommodityRouteVO();
			inVO.setOrgDestTpCd("D");
			inVO.setOpTpCd("C"); // Ori or Dest Term
			customData = command1.searchCommodityRouteAreaList(inVO);
			eventResponse.setCustomData("DestTerm", customData);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * ESM_PRI_6061 : OK <BR>
	 * Quotaion Rate 의 Rate Amount값을 갱신처리 합니다.
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyRateRfaQuotation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6061Event event = (EsmPri6061Event) e;
		try {
			begin();
			RFARateQuotationBC command = new RFARateQuotationBCImpl();
			command.modifyRateRfaQuotation(event.getFicRtTpCd(), event.getInPriQuotationRateAdjustSetVO(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	// ESM_PRI_6015 RFA Quotation Inquiry start
	// ////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_6015 : Retrieve <br>
	 * RFA Quotation Main Inquiry(ESM_PRI_6015).<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRfaQuotationMainReportList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6015Event event = (EsmPri6015Event) e;
		RFAQuotationMainBC command = new RFAQuotationMainBCImpl();

		try {
			List<RsltPriRqMnVO> list = command.searchRfaQuotationMainReportList(event.getQutationMainVO().getRsltPriRqMnVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	// ESM_PRI_6015 RFA Quotation Inquiry end
	// ////////////////////////////////////////////////////////////////////////////////

	// ESM_PRI_6015_01 RFA Quotation Location Group Inquiry start
	// ////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_6015_01 : Retrieve <br>
	 * Group Location 정보를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRfaQuotationGroupLocationReportList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601501Event event = (EsmPri601501Event) e;
		RFAGroupLocationQuotationBC command = new RFAGroupLocationQuotationBCImpl();

		try {
			List<RsltPriRqGrpLocVO> list = command.searchRfaGroupLocationQuotationList(event.getGroupLocationQuotationVO().getPriRqGrpLocVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6015_01 : Retrieve <br>
	 * Group Location Detail 정보를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupLocationDetailReportList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601501Event event = (EsmPri601501Event) e;
		RFAGroupLocationQuotationBC command = new RFAGroupLocationQuotationBCImpl();

		try {
			List<RsltPriRqGrpLocDtlVO> list = command.searchGroupLocationDetailList(event.getGroupLocationQuotationVO().getPriRqGrpLocVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	// ESM_PRI_6015_01 RFA Quotation Location Group Inquiry end
	// ////////////////////////////////////////////////////////////////////////////////

	// ESM_PRI_6015_02 RFA Quotation Commodity Group Inquiry start
	// ////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_6015_02 : Retrieve <br>
	 * Group Commodity 정보를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRfaGroupCommodityQuotationReportList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601502Event event = (EsmPri601502Event) e;
		RFAGroupCommodityQuotationBC command = new RFAGroupCommodityQuotationBCImpl();

		try {
			List<RsltPriRqGrpCmdtVO> list = command.searchRfaGroupCommodityQuotationList(event.getGroupCommodityQuotationVO().getPriRqGrpCmdtVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6015_02 : Retrieve <br>
	 * Group Commodity Detail 정보를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodityDetailReportList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601502Event event = (EsmPri601502Event) e;
		RFAGroupCommodityQuotationBC command = new RFAGroupCommodityQuotationBCImpl();

		try {
			List<RsltPriRqGrpCmdtDtlVO> list = command.searchGroupCommodityDetailList(event.getGroupCommodityQuotationVO().getPriRqGrpCmdtVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	// ESM_PRI_6015_02 RFA Quotation Commodity Group Inquiry end
	// ////////////////////////////////////////////////////////////////////////////////

	// ESM_PRI_6015_03 RFA Quotation Rate Inquiry start
	// ////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_6015_03 : Retrieve <br>
	 * PRI_RQ_RT_CMDT_HDR, PRI_RQ_RT_CMDT 을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRfaRateQuotationReportList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601503Event event = (EsmPri601503Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();

		try {
			List<RsltPriRqRtCmdtVO> list = command.searchRfaRateQuotationList(event.getRateQuotationVO().getPriRqRtCmdtHdrVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6015_03 : Retrieve <br>
	 * PRI_RQ_RT_CMDT_ROUT 을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCommodityRouteReportList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601503Event event = (EsmPri601503Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();

		try {
			List<RsltPriRqRtCmdtRoutVO> list = command.searchRateCommodityRouteList(event.getRateQuotationVO().getPriRqRtCmdtHdrVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6015_03 : Retrieve <br>
	 * PRI_RQ_RT_ROUT_PNT,PRI_RQ_RT_ROUT_VIA,PRI_RQ_RT 을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateReportList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601503Event event = (EsmPri601503Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();

		// 컨테이너 vo
		RFARateQuotationVO rateQuotationVO = new RFARateQuotationVO();

		try {
			rateQuotationVO = command.searchRateList(event.getRateQuotationVO());

			eventResponse.setRsVoList(rateQuotationVO.getRsltPriRqRtCmdtVOList());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriRqRtVOList());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriRqRtRoutOrgPntVOs());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriRqRtRoutOrgViaVOList());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriRqRtRoutDestViaVOList());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriRqRtRoutDestPntVOs());

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	// ESM_PRI_6015_03 RFA Quotation Rate Inquiry end
	// ////////////////////////////////////////////////////////////////////////////////

	/**
	 * ESM_PRI_6014 : OnLoad <br>
	 * 로그인 사용자의 SELECT 권한 정보와 REQUEST OFFICE를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAuthorizationOffice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PRICommonBC command = new PRICommonBCImpl();
		EsmPri6014Event event = (EsmPri6014Event) e;
		RsltCdListVO authData = null;
		try {
			// 권한을 조회한다.
			event.getQutationMainVO().getRsltPriAuthorizationVO().setPrcCtrtTpCd("R");
			event.getQutationMainVO().getRsltPriAuthorizationVO().setCreUsrId(account.getUsr_id());

			authData = command.searchAuthorizationOffice(event.getQutationMainVO().getRsltPriAuthorizationVO(), account);
			eventResponse.setCustomData("AuthData", authData);

			// auth type 리턴
			eventResponse.setETCData("auth_type", authData.getCd());
			log.debug("*********************************************************");
			log.debug("auth_type : " + authData.getCd());
			log.debug("*********************************************************");

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	// ESM_PRI_6076 RFA Quotation-Rate CMPB View All start
	// ////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_6076 : Retrieve <br>
	 * SC Rate CMPB VIEW ALL (ESM_PRI_6076) 리스트를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCmpbViewAllList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6076Event event = (EsmPri6076Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();

		try {
			List<RsltCmpbViewAllListVO> list = command.searchRateCmpbViewAllList(event.getPriRqMnVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	// ESM_PRI_6035 S/C Quotation-Rate View All end
	// ////////////////////////////////////////////////////////////////////////////////

	// ESM_PRI_6056 RQ Rate Creation - Excel Import(Horizontal) start
	// ////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_6056 : Check <br>
	 * RFA Rate LOAD EXCEL(ESM_PRI_6056) 정보 정합성을 체크한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkRateExcelHorizontal(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6056Event event = (EsmPri6056Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();
		try {
			List<RsltCdListVO> vos = command.checkRateExcelHorizontal(event.getPriRqRtCmdtHdrVO(), event.getRsltRtListHorizontalExcelVOS());

			eventResponse.setRsVoList(vos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6056 : Save <br>
	 * RQ Rate LOAD EXCEL(ESM_PRI_6056) 정보를 저장한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse uploadRateExcelHorizontal(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6056Event event = (EsmPri6056Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();

		try {
			begin();
			command.uploadRateExcelHorizontal(event.getPriRqRtCmdtHdrVO(), event.getRsltRtListHorizontalExcelVOS(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6056 : Open<br>
	 * 엑셀 템플릿 다운 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse initRateExcelHorizontal(Event e) throws EventException {
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			ComUpldFileVO comUpldFileVO = new ComUpldFileVO();
			comUpldFileVO.setFileUpldNm("RQ_Rate_Templet_H.xls");
			String fileKey = command.searchExcelTemplateFileKey(comUpldFileVO);
			eventResponse.setCustomData("TEMPLATE_KEY", fileKey);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	// ESM_PRI_6056 RFA Rate Creation - Excel Import(Horizontal) end
	// ////////////////////////////////////////////////////////////////////////////////

	// ESM_PRI_6057 RFA Rate Creation - Excel Import(Vertical) start
	// ////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_6057 : Check <br>
	 * RFA Rate LOAD EXCEL(ESM_PRI_6057) 정보 정합성을 체크한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkRateExcelVertical(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6057Event event = (EsmPri6057Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();

		try {
			List<RsltCdListVO> vos = command.checkRateExcelVertical(event.getPriRqRtCmdtHdrVO(), event.getRsltRtListVerticalExcelVOS());

			eventResponse.setRsVoList(vos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6057 : Save <br>
	 * RFA Rate LOAD EXCEL(ESM_PRI_6057) 정보를 저장한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse uploadRateExcelVertical(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6057Event event = (EsmPri6057Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();

		try {
			begin();
			command.uploadRateExcelVertical(event.getPriRqRtCmdtHdrVO(), event.getRsltRtListVerticalExcelVOS(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6057 : Open<br>
	 * 엑셀 템플릿 다운 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse initRateExcelVertical(Event e) throws EventException {
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			ComUpldFileVO comUpldFileVO = new ComUpldFileVO();
			comUpldFileVO.setFileUpldNm("RQ_Rate_Templet_V.xls");
			String fileKey = command.searchExcelTemplateFileKey(comUpldFileVO);
			eventResponse.setCustomData("TEMPLATE_KEY", fileKey);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	// ESM_PRI_6057 RQ Rate Creation - Excel Import(Vertical) end
	// ////////////////////////////////////////////////////////////////////////////////

	// ESM_PRI_6046 RFA Quotation Copy to Proposal start
	// ////////////////////////////////////////////////////////////////////////////////

	/**
	 * ESM_PRI_6046 : OK <br>
	 * RFA Quotation 정보를 RFA PROPOSAL 관련 테이블에 카피 입력한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse copyToPropRfaQuotation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6046Event event = (EsmPri6046Event) e;

		RFAQuotationMainBC command = new RFAQuotationMainBCImpl();

		RFAProposalMainBC command1 = new RFAProposalMainBCImpl();
		RFADurationProposalBC command2 = new RFADurationProposalBCImpl();
		RFAGroupLocationProposalBC command3 = new RFAGroupLocationProposalBCImpl();
		RFAGroupCommodityProposalBC command4 = new RFAGroupCommodityProposalBCImpl();
		RFARateProposalBC command5 = new RFARateProposalBCImpl();
		RFAProposalDEMDETBC command6 = new RFAProposalDEMDETBCImpl();

		try {
			begin();
			String newPropNo = command1.searchMaxPropNo(account); // 생성된 prop_no
			if (JSPUtil.getNull(newPropNo).equals("")) {
				eventResponse.setUserMessage(new ErrorHandler("PRI00201").getUserMessage());
				commit();
				return eventResponse;
			}

			// prop no setting
			event.getRsltCopyToProposalVO().setNewPropNo(newPropNo);
			// ofc_cd setting
			event.getRsltCopyToProposalVO().setOfcCd(account.getOfc_cd());

			log.debug("****************************** Copy Base");
			command1.copyToProposalBase(event.getRsltCopyToProposalVO(), account);

			log.debug("****************************** Copy Duration");
			command2.copyToProposalScopeDuration(event.getRsltCopyToProposalVO(), account);

			log.debug("****************************** Copy DMDT");
			command6.copyToProposalRqDmdt(event.getRsltCopyToProposalVO(), account);

			if (JSPUtil.getNullNoTrim(event.getRsltCopyToProposalVO().getFrmGrpLocCnt()).equals("Y")) {
				log.debug("****************************** Copy Group Location");
				command3.copyToProposalLocation(event.getRsltCopyToProposalVO(), account);
			}

			if (JSPUtil.getNullNoTrim(event.getRsltCopyToProposalVO().getFrmGrpCmdtCnt()).equals("Y")) {
				log.debug("****************************** Copy Group Commodity");
				command4.copyToProposalCommodity(event.getRsltCopyToProposalVO(), account);
			}

			if (JSPUtil.getNullNoTrim(event.getRsltCopyToProposalVO().getFrmRateGCnt()).equals("Y")) {
				log.debug("****************************** Copy Rate");
				command5.copyToProposalRate(event.getRsltCopyToProposalVO(), account);
			}

			// 상태코드 Proposed로 세팅
			PriRqHdrVO hVo = new PriRqHdrVO();
			hVo.setQttnNo(event.getRsltCopyToProposalVO().getQttnNo());
			hVo.setQttnStsCd("P");
			command.cancelStatusRfaQuotationMain(hVo, account);

			// copy to proposal 시 생성된 proposal no 업데이트
			PriRqMnVO priRqMnVO = new PriRqMnVO();

			priRqMnVO.setPropNo(newPropNo);

			priRqMnVO.setQttnNo(event.getRsltCopyToProposalVO().getQttnNo());
			priRqMnVO.setQttnVerNo(event.getRsltCopyToProposalVO().getQttnVerNo());

			priRqMnVO.setUpdUsrId(account.getUsr_id());

			command.modifyRFAQuotationMainPropNo(priRqMnVO, account);

			// 저장시 키값을 etc 에 리턴
			eventResponse.setETCData("prop_no", newPropNo);
			log.debug("*********************************************************");
			log.debug("prop_no : " + eventResponse.getETCData("prop_no"));
			log.debug("*********************************************************");

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Calculate Batch를 비동기 적으로 실행킨다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse executeCalculate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601403Event event = (EsmPri601403Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();
		PRICommonBC comCommand = new PRICommonBCImpl();
		String prsBatId = "";
		try {
			// property 읽어 오기
			String rCnt = SubSystemConfigFactory.get("PRI.RFA.QTTN.ROTATION.CNT");
			int iRCnt = 5;
			if (rCnt != null) {
				iRCnt = Integer.valueOf(rCnt);
			}

			PriPrsBatVO priPrsBatVO = command.searchMonitorCalculateParam(event.getRateQuotationVO().getPriRqRtCmdtRoutVO());
			PrsBatchVO prsBatchVO = comCommand.searchPrsBatch(priPrsBatVO);

			// pri_Prs_Bat table에 데이터가 있을경우
			if (prsBatchVO != null) {
				String status = command.monitorCalculate(prsBatchVO);

				if ("0".equals(status) // Nothing 아직 상태모름
						|| "1".equals(status) // running
						|| "8".equals(status) // INACTIVE 실행대기
						|| "12".equals(status)// QUE_WAIT 로드밸런싱 대기
				) {
					// 이미 실행중이라면 에러 처리한다.
					throw new EventException(new ErrorHandler("PRI03019", new String[] { account.getUsr_id() }).getMessage());
				}
			}

			// //////////////////////////////////////////////////////////////////////////////////////
			// batch 프로그램 명을 rotation 하기 위한 작업 시작
			PriPrsBatVO updatePriPrsBatVO = new PriPrsBatVO();
			updatePriPrsBatVO.setPgmNo("ESM_PRI_T003");
			updatePriPrsBatVO.setPrsBatId(String.valueOf(iRCnt));
			begin();
			comCommand.modifyPrsBatchMaxRotation(updatePriPrsBatVO);
			commit();
			PrsBatchVO rotationPrsBatchVo = comCommand.searchPrsBatchMaxRotation(updatePriPrsBatVO);
			String rotationPrsBatId = rotationPrsBatchVo.getPrsBatId();
			log.debug("rotationPrsBatId====>" + rotationPrsBatId);
			// batch 프로그램 명을 rotation 하기 위한 작업 종료
			// ///////////////////////////////////////////////////////////////////////////////////////

			priPrsBatVO = command.executeCalculate(event.getRateQuotationVO().getPriRqRtCmdtRoutVO(), rotationPrsBatId, account);

			if (priPrsBatVO != null) {
				begin();
				comCommand.addPrsBatch(priPrsBatVO, account);
				prsBatId = priPrsBatVO.getPrsBatId();
				commit();
			}

			eventResponse.setETCData("JOB_ID", prsBatId);

		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Calculate Batch의 실행 상태를 조회 한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse monitorCalculate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601403Event event = (EsmPri601403Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();
		PRICommonBC comCommand = new PRICommonBCImpl();
		String batchId = "";

		try {
			PriPrsBatVO priPrsBatVO = command.searchMonitorCalculateParam(event.getRateQuotationVO().getPriRqRtCmdtRoutVO());
			PrsBatchVO prsBatchVO = comCommand.searchPrsBatch(priPrsBatVO);
			String status = command.monitorCalculate(prsBatchVO);

			if (prsBatchVO != null) {
				batchId = prsBatchVO.getPrsBatId();
				
				// SUCCESS일경우 PRI_PRS_BAT의 PRS_BAT_ERR_VAL의 결과를 이용한다.
				if ("4".equals(status)) {
					// null도 success로 간주한다.
					if (prsBatchVO.getPrsBatErrVal() != null && prsBatchVO.getPrsBatErrVal().length() != 0 && !"0".equals(prsBatchVO.getPrsBatErrVal())) {// SUCCESS가 아니면
						// FAIL처리
						status = "90";
					}
					
				}
			}
			eventResponse.setETCData("JOB_ID", batchId);
			eventResponse.setETCData("BATCH_STATUS", status);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	// ESM_PRI_6046 RFA Quotation Copy to Proposal end
	// ////////////////////////////////////////////////////////////////////////////////

	/**
	 * ESM_PRI_6014_01 : SAVE<br>
	 * LOCATION GROUP의 ORI/DEST를 체크합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkOriDestGroupLocationInUse(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601401Event event = (EsmPri601401Event) e;
		RFAGroupLocationProposalBC command = new RFAGroupLocationProposalBCImpl();
		try {
			;
			// ORI/DST Validation 체크
			String[] checkVal = command.checkGroupLocationCode(event.getRsltGrpLocDtlListVOs());

			if (checkVal[0] != null) {
				eventResponse.setETCData("ORI_DST_CHECK", checkVal[0]);
			} else {
				eventResponse.setETCData("ORI_DST_CHECK", "");
			}
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6089 : Search <br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSurchargeViewAllList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6089Event event = (EsmPri6089Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();

		try {
			List<RsltPriSurchargeViewAllVO> list = command.searchSurchargeViewAllList(event.getPriRqRtCmdtHdrVO());
			List<RsltPriSurchargeLastAccessDateVO> accessList = command.searchSurchargeLastAccessDateList(event.getPriRqRtCmdtHdrVO());
			eventResponse.setRsVoList(list);

			String accessDate = "";
			if (accessList.size() > 0) {
				accessDate = accessList.get(0).getCreYmd();
			}
			eventResponse.setETCData("access_date", accessDate);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014_04 : Retrieve <br>
	 * PRI_RQ_RT_CMDT_HDR, PRI_RQ_RT_CMDT 을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRfaRateQuotationListForIHC(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601404Event event = (EsmPri601404Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();

		try {
			List<RsltPriRqRtCmdtVO> list = command.searchRfaRateQuotationListForIHC(event.getRateQuotationVO().getPriRqRtCmdtHdrVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014_03 : Rate Commodify Sequence <br>
	 * Rate Commodify Sequence<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRateCommoditySequence(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601403Event event = (EsmPri601403Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();
		try {
			eventResponse.setETCData("cmdtHdrSeq", String.valueOf(command.searchRateCommoditySequence(event.getRateQuotationVO().getPriRqRtCmdtHdrVO())));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014_04 : Save <br>
	 * PRI_RQ_RT_CMDT_HDR, PRI_RQ_RT_CMDT 입력 수정 삭제한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCommodityRouteRateRfaRateQuotationForIHC(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601404Event event = (EsmPri601404Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();
		try {
			begin();
			command.manageCommodityRouteRateRfaRateQuotationForIHC(event.getRateQuotationVO(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014_04 : Save <br>
	 * PRI_RQ_RT_CMDT_ROUT, PRI_RQ_RT_ROUT_PNT, PRI_RQ_RT_ROUT_VIA, PRI_RQ_RT 입력 수정 삭제한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRouteRateRfaRateQuotationForIHC(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601404Event event = (EsmPri601404Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();

		try {
			begin();
			command.manageRouteRateRfaRateQuotationForIHC(event.getRateQuotationVO(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014_03 : Retrieve <br>
	 * PRI_RQ_RT_ROUT_PNT,PRI_RQ_RT_ROUT_VIA,PRI_RQ_RT 을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateListForIHC(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601404Event event = (EsmPri601404Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();
		RFARateQuotationVO rateQuotationVO = new RFARateQuotationVO();

		try {
			rateQuotationVO = command.searchRateListForIHC(event.getRateQuotationVO());

			eventResponse.setRsVoList(rateQuotationVO.getRsltPriRqRtCmdtVOList());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriRqRtVOList());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriRqRtRoutOrgPntVOs());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriRqRtRoutOrgViaVOList());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriRqRtRoutDestViaVOList());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriRqRtRoutDestPntVOs());

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6094 : sheet_OnChange<br>
	 * FIC Route Group을 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFICRouteGroup(Event e) throws EventException {
		EsmPri6094Event event = (EsmPri6094Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<FicRouteGroupVO> list = command.searchFicRouteGroup(event.getFicRouteGroupVO(), false);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6094 : sheet location change<br>
	 * FIC Route Group을 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCYPortLocation(Event e) throws EventException {
		EsmPri6094Event event = (EsmPri6094Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<RsltFicCheckCYPortLocationVO> list = command.checkCYPortLocationCode(event.getFicCheckCYPortLocationVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014_03 : Down Excel <br>
	 * RATE 관련 정보를 조회한다.(EXCEL DOWN VerticalExcel)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateListVerticalExcelForIHC(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601404Event event = (EsmPri601404Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();

		try {
			List<RsltRtListVerticalExcelForIHCVO> list = command.searchRateListVerticalExcelForIHC(event.getRateQuotationVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014_03 : Down Excel <br>
	 * RATE 관련 정보를 조회한다.(EXCEL DOWN Horizontal)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateListHorizontalExcelForIHC(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601404Event event = (EsmPri601404Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();
		try {
			List<RsltRtListHorizontalExcelForIHCVO> list = command.searchRateListHorizontalExcelForIHC(event.getRateQuotationVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6095 : Check <br>
	 * RFA Rate LOAD EXCEL(ESM_PRI_6095) 정보 정합성을 체크한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkRateExcelVerticalForIHC(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6095Event event = (EsmPri6095Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();
		try {
			List<RsltCdListVO> vos = command.checkRateExcelVerticalForIHC(event.getRateQuotationVO());
			eventResponse.setRsVoList(vos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6095 : Save <br>
	 * RFA Rate LOAD EXCEL(ESM_PRI_6095) 정보를 저장한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse uploadRateExcelVerticalForIHC(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6095Event event = (EsmPri6095Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();

		try {
			begin();
			command.uploadRateExcelVerticalForIHC(event.getRateQuotationVO(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6095 : Open<br>
	 * 엑셀 템플릿 다운 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse initRateExcelVerticalForIHC(Event e) throws EventException {
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			ComUpldFileVO comUpldFileVO = new ComUpldFileVO();
			comUpldFileVO.setFileUpldNm("RQ_Rate_Templet_V.xls");
			String fileKey = command.searchExcelTemplateFileKey(comUpldFileVO);
			eventResponse.setCustomData("TEMPLATE_KEY", fileKey);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6095 : Check<br>
	 * Load된 엑셀 데이터의 FIC Rate값을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFicGuidelineRateForIHC(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6095Event event = (EsmPri6095Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();
		try {
			eventResponse.setRsVoList(command.searchFicGuidelineRateForLoadExcel(event.getRateQuotationVO(), false));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6096 : Check <br>
	 * RFA Rate LOAD EXCEL(ESM_PRI_6096) 정보 정합성을 체크한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkRateExcelHorizontalForIHC(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6096Event event = (EsmPri6096Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();
		try {
			List<RsltCdListVO> vos = command.checkRateExcelHorizontalForIHC(event.getRateQuotationVO());
			eventResponse.setRsVoList(vos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6096 : Save <br>
	 * RQ Rate LOAD EXCEL(ESM_PRI_6096) 정보를 저장한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse uploadRateExcelHorizontalForIHC(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6096Event event = (EsmPri6096Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();
		try {
			begin();
			command.uploadRateExcelHorizontalForIHC(event.getRateQuotationVO(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6096 : Open<br>
	 * 엑셀 템플릿 다운 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse initRateExcelHorizontalForIHC(Event e) throws EventException {
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			ComUpldFileVO comUpldFileVO = new ComUpldFileVO();
			comUpldFileVO.setFileUpldNm("RQ_Rate_Templet_H.xls");
			String fileKey = command.searchExcelTemplateFileKey(comUpldFileVO);
			eventResponse.setCustomData("TEMPLATE_KEY", fileKey);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	// ESM_PRI_6015_04 RFA Quotation Rate Inquiry start
	// ////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_6015_04 : Retrieve <br>
	 * PRI_RQ_RT_CMDT_HDR, PRI_RQ_RT_CMDT 을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRfaRateQuotationIhcReportList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601504Event event = (EsmPri601504Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();

		try {
			List<RsltPriRqRtCmdtVO> list = command.searchRfaRateQuotationListForIHC(event.getRateQuotationVO().getPriRqRtCmdtHdrVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6015_04 : Retrieve <br>
	 * PRI_RQ_RT_CMDT_ROUT 을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCommodityRouteIhcReportList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601504Event event = (EsmPri601504Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();

		try {
			List<RsltPriRqRtCmdtRoutVO> list = command.searchRateCommodityRouteList(event.getRateQuotationVO().getPriRqRtCmdtHdrVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6015_04 : Retrieve <br>
	 * PRI_RQ_RT_ROUT_PNT,PRI_RQ_RT_ROUT_VIA,PRI_RQ_RT 을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateIhcReportList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601504Event event = (EsmPri601504Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();
		// 컨테이너 vo
		RFARateQuotationVO rateQuotationVO = new RFARateQuotationVO();
		try {
			rateQuotationVO = command.searchRateListForIHC(event.getRateQuotationVO());

			eventResponse.setRsVoList(rateQuotationVO.getRsltPriRqRtCmdtVOList());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriRqRtVOList());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriRqRtRoutOrgPntVOs());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriRqRtRoutOrgViaVOList());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriRqRtRoutDestViaVOList());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriRqRtRoutDestPntVOs());

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014_05 : Retrieve <br>
	 * PRI_RQ_RT_CMDT_HDR, PRI_RQ_RT_CMDT 을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRfaRateQuotationListForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601405Event event = (EsmPri601405Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();

		try {
			List<RsltPriRqRtCmdtVO> list = command.searchRfaRateQuotationListForIHC(event.getRateQuotationVO().getPriRqRtCmdtHdrVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014_05 : Retrieve <br>
	 * PRI_RQ_RT_ROUT_PNT,PRI_RQ_RT_ROUT_VIA,PRI_RQ_RT 을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateListForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601405Event event = (EsmPri601405Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();
		RFARateQuotationVO rateQuotationVO = new RFARateQuotationVO();

		try {
			rateQuotationVO = command.searchRateListForIHC(event.getRateQuotationVO());

			eventResponse.setRsVoList(rateQuotationVO.getRsltPriRqRtCmdtVOList());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriRqRtVOList());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriRqRtRoutOrgPntVOs());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriRqRtRoutOrgViaVOList());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriRqRtRoutDestViaVOList());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriRqRtRoutDestPntVOs());

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014_05 : Down Excel <br>
	 * RATE 관련 정보를 조회한다.(EXCEL DOWN VerticalExcel)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateListVerticalExcelForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601405Event event = (EsmPri601405Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();

		try {
			List<RsltPriRqRtListVerticalExcelForAddOnTariffVO> list = command.searchRateListVerticalExcelForAddOnTariff(event.getRateQuotationVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014_05 : Down Excel <br>
	 * RATE 관련 정보를 조회한다.(EXCEL DOWN Horizontal)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateListHorizontalExcelForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601405Event event = (EsmPri601405Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();
		try {
			List<RsltPriRqRtListHorizontalExcelForAddOnTariffVO> list = command.searchRateListHorizontalExcelForAddOnTariff(event.getRateQuotationVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014_05 : Save <br>
	 * PRI_RQ_RT_CMDT_HDR, PRI_RQ_RT_CMDT 입력 수정 삭제한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCommodityRouteRateRfaRateQuotationForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601405Event event = (EsmPri601405Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();
		try {
			begin();
			command.manageCommodityRouteRateRfaRateQuotationForIHC(event.getRateQuotationVO(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014_05 : Save <br>
	 * PRI_RQ_RT_CMDT_ROUT, PRI_RQ_RT_ROUT_PNT, PRI_RQ_RT_ROUT_VIA, PRI_RQ_RT 입력 수정 삭제한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRouteRateRfaRateQuotationForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601405Event event = (EsmPri601405Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();

		try {
			begin();
			command.manageRouteRateRfaRateQuotationForIHC(event.getRateQuotationVO(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6094 : sheet_OnChange<br>
	 * FIC Route Group을 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFICRouteGroupForAddOnTariff(Event e) throws EventException {
		EsmPri6097Event event = (EsmPri6097Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<FicRouteGroupVO> list = command.searchFicRouteGroup(event.getFicRouteGroupVO(), true);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6094 : sheet location change<br>
	 * FIC Route Group을 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCYPortLocationForAddOnTariff(Event e) throws EventException {
		EsmPri6097Event event = (EsmPri6097Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<RsltFicCheckCYPortLocationVO> list = command.checkCYPortLocationCode(event.getFicCheckCYPortLocationVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014_05 : Retrieve <br>
	 * PRI_RQ_RT_CMDT_ROUT 을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCommodityRouteListForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601405Event event = (EsmPri601405Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();

		try {
			List<RsltPriRqRtCmdtRoutVO> list = command.searchRateCommodityRouteList(event.getRateQuotationVO().getPriRqRtCmdtHdrVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Calculate Batch를 비동기 적으로 실행킨다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse executeCalculateForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601405Event event = (EsmPri601405Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();
		PRICommonBC comCommand = new PRICommonBCImpl();
		String prsBatId = "";
		try {
			String rCnt = SubSystemConfigFactory.get("PRI.RFA.QTTN.ROTATION.CNT");
			int iRCnt = 5;
			if (rCnt != null) {
				iRCnt = Integer.valueOf(rCnt);
			}

			PriPrsBatVO priPrsBatVO = command.searchMonitorCalculateParam(event.getRateQuotationVO().getPriRqRtCmdtRoutVO());
			PrsBatchVO prsBatchVO = comCommand.searchPrsBatch(priPrsBatVO);

			if (prsBatchVO != null) {
				String status = command.monitorCalculate(prsBatchVO);

				if ("0".equals(status) // Nothing 아직 상태모름
						|| "1".equals(status) // running
						|| "8".equals(status) // INACTIVE 실행대기
						|| "12".equals(status)// QUE_WAIT 로드밸런싱 대기
				) {
					throw new EventException(new ErrorHandler("PRI03019", new String[] { account.getUsr_id() }).getMessage());
				}
			}

			// //////////////////////////////////////////////////////////////////////////////////////
			// batch 프로그램 명을 rotation 하기 위한 작업 시작
			PriPrsBatVO updatePriPrsBatVO = new PriPrsBatVO();
			updatePriPrsBatVO.setPgmNo("ESM_PRI_T003");
			updatePriPrsBatVO.setPrsBatId(String.valueOf(iRCnt));
			begin();
			comCommand.modifyPrsBatchMaxRotation(updatePriPrsBatVO);
			commit();
			PrsBatchVO rotationPrsBatchVo = comCommand.searchPrsBatchMaxRotation(updatePriPrsBatVO);
			String rotationPrsBatId = rotationPrsBatchVo.getPrsBatId();
			log.debug("rotationPrsBatId====>" + rotationPrsBatId);
			// batch 프로그램 명을 rotation 하기 위한 작업 종료
			// ///////////////////////////////////////////////////////////////////////////////////////

			priPrsBatVO = command.executeCalculate(event.getRateQuotationVO().getPriRqRtCmdtRoutVO(), rotationPrsBatId, account);

			if (priPrsBatVO != null) {
				begin();
				comCommand.addPrsBatch(priPrsBatVO, account);
				prsBatId = priPrsBatVO.getPrsBatId();
				commit();
			}
			eventResponse.setETCData("JOB_ID", prsBatId);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Calculate Batch의 실행 상태를 조회 한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse monitorCalculateForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601405Event event = (EsmPri601405Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();
		PRICommonBC comCommand = new PRICommonBCImpl();
		String batchId = "";

		try {
			PriPrsBatVO priPrsBatVO = command.searchMonitorCalculateParam(event.getRateQuotationVO().getPriRqRtCmdtRoutVO());
			PrsBatchVO prsBatchVO = comCommand.searchPrsBatch(priPrsBatVO);
			String status = command.monitorCalculate(prsBatchVO);

			if (prsBatchVO != null) {
				batchId = prsBatchVO.getPrsBatId();
				
				// SUCCESS일경우 PRI_PRS_BAT의 PRS_BAT_ERR_VAL의 결과를 이용한다.
				if ("4".equals(status)) {
					if (prsBatchVO.getPrsBatErrVal() != null && prsBatchVO.getPrsBatErrVal().length() != 0 && !"0".equals(prsBatchVO.getPrsBatErrVal())) {// SUCCESS가 아니면
						status = "90";
					}
				}
			}
			eventResponse.setETCData("JOB_ID", batchId);
			eventResponse.setETCData("BATCH_STATUS", status);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014_05 : Rate Commodify Sequence <br>
	 * Rate Commodify Sequence<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRateCommoditySequenceForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601405Event event = (EsmPri601405Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();
		try {
			eventResponse.setETCData("cmdtHdrSeq", String.valueOf(command.searchRateCommoditySequence(event.getRateQuotationVO().getPriRqRtCmdtHdrVO())));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6014_05 : G/L Copy <br>
	 * Rate 관련 테이블 에 가이드라인 정보를 카피 입력한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse glineCopyRfaRateQuotationForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601405Event event = (EsmPri601405Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();
		try {
			begin();
			command.glineCopyRfaRateQuotation(event.getRateQuotationVO().getRsltPriRqMnVO(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6098 : Check <br>
	 * RFA Rate LOAD EXCEL(ESM_PRI_6095) 정보 정합성을 체크한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkRateExcelVerticalForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6098Event event = (EsmPri6098Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();
		try {
			List<RsltCdListVO> vos = command.checkRateExcelVerticalForIHC(event.getRateQuotationVO());
			eventResponse.setRsVoList(vos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6098 : Check<br>
	 * Load된 엑셀 데이터의 FIC Rate값을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFicGuidelineRateForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6098Event event = (EsmPri6098Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();
		try {
			eventResponse.setRsVoList(command.searchFicGuidelineRateForLoadExcel(event.getRateQuotationVO(), true));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6098 : Save <br>
	 * RFA Rate LOAD EXCEL(ESM_PRI_6095) 정보를 저장한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse uploadRateExcelVerticalForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6098Event event = (EsmPri6098Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();
		try {
			begin();
			command.uploadRateExcelVerticalForAddOnTariff(event.getRateQuotationVO(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6098 : Open<br>
	 * 엑셀 템플릿 다운 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse initRateExcelVerticalForAddOnTariff(Event e) throws EventException {
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			ComUpldFileVO comUpldFileVO = new ComUpldFileVO();
			comUpldFileVO.setFileUpldNm("RQ_Rate_Templet_V.xls");
			String fileKey = command.searchExcelTemplateFileKey(comUpldFileVO);
			eventResponse.setCustomData("TEMPLATE_KEY", fileKey);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6099 : Check <br>
	 * RFA Rate LOAD EXCEL(ESM_PRI_6096) 정보 정합성을 체크한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkRateExcelHorizontalForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6099Event event = (EsmPri6099Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();
		try {
			List<RsltCdListVO> vos = command.checkRateExcelHorizontalForIHC(event.getRateQuotationVO());
			eventResponse.setRsVoList(vos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6099 : Save <br>
	 * RQ Rate LOAD EXCEL(ESM_PRI_6096) 정보를 저장한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse uploadRateExcelHorizontalForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6099Event event = (EsmPri6099Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();
		try {
			begin();
			command.uploadRateExcelHorizontalForAddOnTariff(event.getRateQuotationVO(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6099 : Open<br>
	 * 엑셀 템플릿 다운 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse initRateExcelHorizontalForAddOnTariff(Event e) throws EventException {
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			ComUpldFileVO comUpldFileVO = new ComUpldFileVO();
			comUpldFileVO.setFileUpldNm("RQ_Rate_Templet_H.xls");
			String fileKey = command.searchExcelTemplateFileKey(comUpldFileVO);
			eventResponse.setCustomData("TEMPLATE_KEY", fileKey);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6015_05 : Retrieve <br>
	 * PRI_RQ_RT_CMDT_HDR, PRI_RQ_RT_CMDT 을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRfaRateQuotationReportListForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601505Event event = (EsmPri601505Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();
		try {
			List<RsltPriRqRtCmdtVO> list = command.searchRfaRateQuotationListForIHC(event.getRateQuotationVO().getPriRqRtCmdtHdrVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6015_05 : Retrieve <br>
	 * PRI_RQ_RT_CMDT_ROUT 을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCommodityRouteReportListForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601505Event event = (EsmPri601505Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();
		try {
			List<RsltPriRqRtCmdtRoutVO> list = command.searchRateCommodityRouteList(event.getRateQuotationVO().getPriRqRtCmdtHdrVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_6015_05 : Retrieve <br>
	 * PRI_RQ_RT_ROUT_PNT,PRI_RQ_RT_ROUT_VIA,PRI_RQ_RT 을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateReportListForAddOnTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601505Event event = (EsmPri601505Event) e;
		RFARateQuotationBC command = new RFARateQuotationBCImpl();
		// 컨테이너 vo
		try {
			RFARateQuotationVO rateQuotationVO = command.searchRateListForIHC(event.getRateQuotationVO());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriRqRtCmdtVOList());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriRqRtVOList());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriRqRtRoutOrgPntVOs());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriRqRtRoutOrgViaVOList());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriRqRtRoutDestViaVOList());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriRqRtRoutDestPntVOs());

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
}