/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCQuotationSC.java
*@FileTitle : S/C Quotation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.07.29 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.basic.PRICommonBC;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.basic.PRICommonBCImpl;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.PrsBatchVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.basic.CalculateBC;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.basic.CalculateBCImpl;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.vo.RsltPriPrsRoutCsMaxRoutCsNoVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.basic.SCContractPartyProposalBC;
import com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.basic.SCContractPartyProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.basic.SCDurationProposalBC;
import com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.basic.SCDurationProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.scgroupcommodityproposal.basic.SCGroupCommodityProposalBC;
import com.hanjin.apps.alps.esm.pri.scproposal.scgroupcommodityproposal.basic.SCGroupCommodityProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.scgrouplocationproposal.basic.SCGroupLocationProposalBC;
import com.hanjin.apps.alps.esm.pri.scproposal.scgrouplocationproposal.basic.SCGroupLocationProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.basic.SCMQCProposalBC;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.basic.SCMQCProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.basic.SCProposalMainBC;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.basic.SCProposalMainBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.CstRequestCheckVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.basic.SCRateProposalBC;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.basic.SCRateProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.InPriPrsRoutCsVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltRouteCaseCostVersionVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scgroupcommodityquotation.basic.SCGroupCommodityQuotationBC;
import com.hanjin.apps.alps.esm.pri.scquotation.scgroupcommodityquotation.basic.SCGroupCommodityQuotationBCImpl;
import com.hanjin.apps.alps.esm.pri.scquotation.scgroupcommodityquotation.event.EsmPri600502Event;
import com.hanjin.apps.alps.esm.pri.scquotation.scgroupcommodityquotation.event.EsmPri601302Event;
import com.hanjin.apps.alps.esm.pri.scquotation.scgroupcommodityquotation.vo.RsltPriSqGrpCmdtDtlVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scgroupcommodityquotation.vo.RsltPriSqGrpCmdtVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scgrouplocationquotation.basic.SCGroupLocationQuotationBC;
import com.hanjin.apps.alps.esm.pri.scquotation.scgrouplocationquotation.basic.SCGroupLocationQuotationBCImpl;
import com.hanjin.apps.alps.esm.pri.scquotation.scgrouplocationquotation.event.EsmPri600501Event;
import com.hanjin.apps.alps.esm.pri.scquotation.scgrouplocationquotation.event.EsmPri601301Event;
import com.hanjin.apps.alps.esm.pri.scquotation.scgrouplocationquotation.vo.RsltPriSqGrpLocDtlVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scgrouplocationquotation.vo.RsltPriSqGrpLocVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.basic.SCQuotationMainBC;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.basic.SCQuotationMainBCImpl;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.event.EsmPri6005Event;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.event.EsmPri6008Event;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.event.EsmPri6013Event;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.event.EsmPri6033Event;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.event.EsmPri6034Event;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltPriSqMnChkNeedCalcVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltPriSqMnVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltSearchDetailCntVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltSearchGlineExistVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.basic.SCRateQuotationBC;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.basic.SCRateQuotationBCImpl;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.event.EsmPri600503Event;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.event.EsmPri6006Event;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.event.EsmPri6007Event;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.event.EsmPri6012Event;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.event.EsmPri601303Event;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.event.EsmPri6035Event;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.event.EsmPri6062Event;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.event.EsmPri6065Event;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.event.EsmPri6068Event;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.event.EsmPri6071Event;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.event.EsmPri6074Event;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.event.EsmPri6075Event;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.event.EsmPri6078Event;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.event.EsmPri6081Event;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.event.EsmPri6088Event;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.integration.SCRateQuotationDBDAO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.InPriCommodityRouteVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RateQuotationVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltCmpbViewAllListVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriCommodityRouteVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriCostDetailByTransModeListVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriCostSimulationCheckRouteVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriPrsCostDetailVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriPrsCostListVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriRateCmViewAllVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSqRtAllViewVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSqRtCmdtRoutVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSqRtCmdtVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSurchargeAdjustCommodityDetailVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSurchargeAdjustCommodityVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSurchargeAdjustListVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSurchargeAdjustLocationGroupDetailVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSurchargeAdjustLocationGroupVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSurchargeLastAccessDateVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSurchargeViewAllVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPrsSurchargeDetailListVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltRtListHorizontalExcelVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltRtListVerticalExcelVO;
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
import com.hanjin.syscommon.common.table.PriSqHdrVO;
import com.hanjin.syscommon.common.table.PriSqMnVO;
import com.hanjin.syscommon.common.table.PriSqRtUsdRoutCsVO;


/**
 * ALPS-SCQuotation Business Logic ServiceCommand - ALPS-SCQuotation 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author SONG MIN SEOK
 * @see SCRateQuotationDBDAO
 * @since J2EE 1.6
 */

public class SCQuotationSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * SCQuotation system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		
		try {
			// 일단 comment --> 로그인 체크 부분
			log.debug("SCQuotationSC 시작");
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * SCQuotation system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("SCQuotationSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-SCQuotation system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		

		log.debug(e.getEventName());
		
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		// ============================ESM_PRI_6062_Start====================================
		if (e.getEventName().equalsIgnoreCase("EsmPri6062Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCostDetailList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					eventResponse = searchCostDetailInquiryList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = modifyPrsCost(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = modifyPrsSimulationCost(e);
            }
			// =============================ESM_PRI_6062_end===================================            
        }		
	  

		// ============================ESM_PRI_6068_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri6068Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRateSurchargeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageRateSurcharge(e);
			}
			// =============================ESM_PRI_6068_end===================================
		}			
		// ============================ESM_PRI_6071_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri6071Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSurchargeAdjustList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSurchargeAdjust(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = manageSurchargeAdjustCalc(e);        				
			}
			// =============================ESM_PRI_6071_end===================================            
        }		

		// ============================esm_pri_6078_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri6078Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRateCommodityAllList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRateGroupCommodityDetailList(e);
			}
			// =============================esm_pri_6078_end===================================            
        }		
		// ============================esm_pri_6081_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri6081Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRateLocationAllList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRateGroupLocationDetailList(e);
			}
			// =============================esm_pri_6081_end===================================            
        }	
        // ============================ESM_PRI_6075_Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri6075Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchRateCmViewAllList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = modifyPrsPfmc(e);
            }
            // =============================ESM_PRI_6075_end===================================          
        }
        // ============================esm_pri_6065_Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri6065Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchCostDetailByTransModeList(e);
            }
            // =============================esm_pri_6065_end===================================            
        }   
		// ============================ESM_PRI_6012_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri6012Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCommodityRouteList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyRateScQuotation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchCommodityRouteAreaList(e);
			}else{
				eventResponse = searchInitCommodityRoute(e);
			}
			// =============================ESM_PRI_6012_end===================================
		}		
		
		
		//ESM_PRI_6005 S/C Quotation Creation start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri6005Event")) {
			
			//search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchScQuotationMainList(e);
			}
			//체크 Quotation no
//			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
//				eventResponse = checkQuotationNumber(e);
//			}
			//gline count 체크
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchGlineExist(e);
			}
 
			//cmdt seq 별 rate가 있는지 체크
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = checkExistRate(e);
			}
			//calculate를 돌렸는지 판단한다.
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchScQuotationMainChkNeedCalcList(e);
			}
			//텝별 건수 조회
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchDetailCnt(e);
			}
			//save
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageScQuotationMain(e);
			}
			//delete
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = removeScQuotationMain(e);
			}
			//cancel
			else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = cancelStatusScQuotationMain(e);
			}
			//add version
			else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = createVersionScQuotationMain(e);
			} 
			//권한
			else{
				eventResponse = searchAuthorizationOffice(e);
			}
		}
		//ESM_PRI_6005 S/C Quotation Creation end
		//////////////////////////////////////////////////////////////////////////////////
		
		
		//ESM_PRI_6005_01 S/C Quotation Location Group Creation start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri600501Event")) {
			
			//search master
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchScGroupLocationQuotationList(e);
			}
			//search detail
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupLocationDetailList(e);
			}
			//search rate 사용여부
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkGroupLocationInUse(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageScGroupLocationQuotation(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = glineCopyScGroupLocationQuotation(e);
			}
		}
		//ESM_PRI_6005_01 S/C Quotation Location Group Creation end
		//////////////////////////////////////////////////////////////////////////////////

		//ESM_PRI_6005_02 S/C Quotation Commodity Group Creation start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri600502Event")) {
			
			//search master
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchScGroupCommodityQuotationList(e);
			}
			//search detail
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupCommodityDetailList(e);
			}
			//search cmdt 사용여부 
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkGroupCommodityInUse(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageScGroupCommodityQuotation(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = glineCopyScGroupCommodityQuotation(e);
			}
		}
		//ESM_PRI_6005_02 S/C Quotation Commodity Group Creation end
		//////////////////////////////////////////////////////////////////////////////////
		
		//ESM_PRI_6005_03 S/C Quotation Rate Creation start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri600503Event")) {
			
			//search commodity
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSCRateQuotationList(e);
			}
			//search cmdt rout
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRateCommodityRouteList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchRateList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchRateListVerticalExcel(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchRateListHorizontalExcel(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageCommoditySCRateQuotation(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageRouteRateSCRateQuotation(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = glineCopyScRateQuotation(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = executeCalculate(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = monitorCalculate(e);
			}
		}
		//ESM_PRI_6005_03 S/C Quotation Rate Creation end
		//////////////////////////////////////////////////////////////////////////////////
		
		//ESM_PRI_6008 S/C Quotation Rate Creation - G/L Copy Option start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri6008Event")) {
			
			//Gline Copy
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = glineCopyScQuotaion(e);
			}
			
		}
		//ESM_PRI_6008 S/C Quotation Rate Creation - G/L Copy Option end
		//////////////////////////////////////////////////////////////////////////////////
		
		//ESM_PRI_6033 S/C Quotation Copy to Proposal start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri6033Event")) {
			
			//Proposal Copy
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = copyToPropScQuotation (e);
			}
			
		}
		//ESM_PRI_6033 S/C Quotation Copy to Proposal end
		//////////////////////////////////////////////////////////////////////////////////
		
		//ESM_PRI_6034 S/C Quotation Copy to Quotation start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri6034Event")) {
			
			//Gline Copy
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = copyToQuotationScQuotaionReport(e);
			}
			
		}
		//ESM_PRI_6034 S/C Quotation Copy to Quotation end
		//////////////////////////////////////////////////////////////////////////////////
		
		//ESM_PRI_6035 S/C Quotation-Rate View All start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri6035Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchViewAllSCRateQuotationList(e);
			}
			
		}
		//ESM_PRI_6035 S/C Quotation-Rate View All end
		//////////////////////////////////////////////////////////////////////////////////
		
		//ESM_PRI_6013 S/C Quotation Inquiry start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri6013Event")) {
			//search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchScQuotationReportList(e);
			}
		}
		//ESM_PRI_6005 S/C Quotation Creation end
		//////////////////////////////////////////////////////////////////////////////////
		
		
		//ESM_PRI_6013_01 S/C Quotation Location Group Inquiry start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri601301Event")) {
			
			//search master
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchScGroupLocationQuotationReportList(e);
			}
			//search detail
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupLocationDetailReportList(e);
			}
			
		}
		//ESM_PRI_6013_01 S/C Quotation Location Group Inquiry end
		//////////////////////////////////////////////////////////////////////////////////

		//ESM_PRI_6013_02 S/C Quotation Commodity Group Inquiry start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri601302Event")) {
			
			//search master
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchScGroupCommodityQuotationReportList(e);
			}
			//search detail
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupCommodityDetailReportList(e);
			}
			
		}
		//ESM_PRI_6013_02 S/C Quotation Commodity Group Inquiry end
		//////////////////////////////////////////////////////////////////////////////////
		
		
		//ESM_PRI_6013_03 S/C Quotation Rate Inquiry start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri601303Event")) {
			
			//search commodity
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSCRateQuotationReportList(e);
			}
			//search cmdt rout
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRateCommodityRouteReportList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchRateReportList(e);
			}
			
		}
		//ESM_PRI_6013_03 S/C Quotation Rate Inquiry end
		//////////////////////////////////////////////////////////////////////////////////
		
		
		//ESM_PRI_6074 S/C Quotation-Rate CMPB View All start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri6074Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRateCmpbViewAllList(e);
			}
			
		}
		
		//ESM_PRI_6006 SQ Rate Creation - Excel Import(Horizontal) start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri6006Event")) {
			//search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkRateExcelHorizontal(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = uploadRateExcelHorizontal(e);
			} else {
				eventResponse = initRateExcelHorizontal(e);
			}
		}
		//ESM_PRI_6006 SQ Rate Creation - Excel Import(Horizontal) end
		//////////////////////////////////////////////////////////////////////////////////
		
		//ESM_PRI_6007 SQ Rate Creation - Excel Import(Vertical) start
		//////////////////////////////////////////////////////////////////////////////////
		if (e.getEventName().equalsIgnoreCase("EsmPri6007Event")) {
			//search
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkRateExcelVertical(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = uploadRateExcelVertical(e);
			} else {
				eventResponse = initRateExcelVertical(e);
			}
		}
		//ESM_PRI_6007 SQ Rate Creation - Excel Import(Vertical) end
		//////////////////////////////////////////////////////////////////////////////////
		
        // =============================ESM_PRI_6086_start===================================
        if (e.getEventName().equalsIgnoreCase("EsmPri6088Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchSurchargeViewAllList(e);
            }
        }
        // =============================ESM_PRI_6086_end  ===================================
		
		
		
		return eventResponse;
	}
 
	
	/**
	 * ESM_PRI_6062 : Retrieve <br>
	 * PRS- Cost Detail List 확인 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostDetailList(Event e) throws EventException {
		log.debug("===================================>>>>>>>>>>>>>>>>>searchCostDetailList");
		// PDTO(Data Transfer Object including Parameters)
		EsmPri6062Event event = (EsmPri6062Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		SCRateQuotationBC command1 = new SCRateQuotationBCImpl();
		try{
			List<RsltPriPrsCostListVO> list = command1.searchCostDetailList(event.getRsltPriPrsCostListVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_6062 : Retrieve <br>
	 * PRS- Cost Detail List 상세 내용 확인 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostDetailInquiryList(Event e) throws EventException {
		log.debug("===================================>>>>>>>>>>>>>>>>>searchCostDetailInquiryList");
		// PDTO(Data Transfer Object including Parameters)
		EsmPri6062Event event = (EsmPri6062Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		SCRateQuotationBC command1 = new SCRateQuotationBCImpl();
		try{
			List<RsltPriPrsCostDetailVO> list = command1.searchCostDetailInquiryList(event.getRsltPriPrsCostDetailVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
 
   

	/**
	 * ESM_PRI_6068 : Retrieve , onLoad , onSaveEnd <BR>
	 * PRS- Applicable Route, Surcharge Detail을 조회 처리합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateSurchargeList(Event e) throws EventException {
		EsmPri6068Event event = (EsmPri6068Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		SCRateQuotationBC command1 = new SCRateQuotationBCImpl();
		
		try{
			RsltPrsSurchargeDetailListVO rsltPrsSurchargeDetailListVO = command1.searchRateSurchargeList(event.getInpPrsSurchargeDetailApplicableRouteVO());
			eventResponse.setRsVoList(rsltPrsSurchargeDetailListVO.getRsltPrsSurchargeDetailApplicableRouteVOS());
			eventResponse.setRsVoList(rsltPrsSurchargeDetailListVO.getRsltPrsSurchargeDetailVOS());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_6068 : Save <BR>
	 * PRS- Surcharge Detail 내용을 추가,삭제,갱신처리 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRateSurcharge(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6068Event event = (EsmPri6068Event) e;
		
		try {
			begin();
			SCRateQuotationBC command = new SCRateQuotationBCImpl();
			command.manageRateSurcharge(event.getPriSqRtScgVOS(), account);
//			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
 
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
	 * ESM_PRI_6071 : Retrieve , onLoad, onSaveEnd <BR>
	 * PRS- Surcharge Adjust을 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSurchargeAdjustList(Event e) throws EventException {
		EsmPri6071Event event = (EsmPri6071Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		SCRateQuotationBC command1 = new SCRateQuotationBCImpl();
		try{
			List<RsltPriSurchargeAdjustListVO> list = command1.searchSurchargeAdjustList(event.getRsltPriSurchargeAdjustListVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_6071 : Save <BR>
	 * PRS- Surcharge Adjust 내용을 추가,삭제,갱신처리 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSurchargeAdjust(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6071Event event = (EsmPri6071Event) e;
		
		try {
			begin();
			SCRateQuotationBC command = new SCRateQuotationBCImpl();
			command.manageSurchargeAdjust(event.getPriSqScgAdjVOS(), account);
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
     * ESM_PRI_6071 : OK <BR>
     * PRS- Surcharge Adjust 내용을 바탕으로  Calculate Logic을 수행합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageSurchargeAdjustCalc(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri6071Event event = (EsmPri6071Event) e;

        try {
            begin();
            SCRateQuotationBC command = new SCRateQuotationBCImpl();
            command.manageSurchargeAdjustCalc(event.getPriSqScgAdjVOS()[0], account);
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage()); 
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

	/**
	 * ESM_PRI_6078 :  onLoad <BR>
	 * Commodity Group을 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCommodityAllList(Event e) throws EventException {
		EsmPri6078Event event = (EsmPri6078Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		SCRateQuotationBC command1 = new SCRateQuotationBCImpl();
		try{
			List<RsltPriSurchargeAdjustCommodityVO> list = command1.searchRateCommodityAllList(event.getRsltPriSurchargeAdjustCommodityVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}	
	
	/**
	 * ESM_PRI_6078 :  onLoad, sheet1_onClick <BR>
	 * Surcharge Adjust-Commodity group에 대한 상세 내용을 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateGroupCommodityDetailList(Event e) throws EventException {
		EsmPri6078Event event = (EsmPri6078Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		SCRateQuotationBC command1 = new SCRateQuotationBCImpl();
		try{
			List<RsltPriSurchargeAdjustCommodityDetailVO> list = command1.searchRateGroupCommodityDetailList(event.getRsltPriSurchargeAdjustCommodityDetailVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}		

	
	/**
	 * ESM_PRI_6081 :  onLoad <BR>
	 * Surcharge Adjust-Location Group을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateLocationAllList(Event e) throws EventException {
		EsmPri6081Event event = (EsmPri6081Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		SCRateQuotationBC command1 = new SCRateQuotationBCImpl();
		try{
			List<RsltPriSurchargeAdjustLocationGroupVO> list = command1.searchRateLocationAllList(event.getRsltPriSurchargeAdjustLocationGroupVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}	
	
	/**
	 * ESM_PRI_6081 :  onLoad, sheet1_onClick <BR>
	 * SSurcharge Adjust-Location Group에 상세 정보를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateGroupLocationDetailList(Event e) throws EventException {
		log.debug("===================================>>>>>>>>>>>>>>>>>searchGroupCommodityDetailList");
		// PDTO(Data Transfer Object including Parameters)
		EsmPri6081Event event = (EsmPri6081Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		SCRateQuotationBC command1 = new SCRateQuotationBCImpl();
		try{
			List<RsltPriSurchargeAdjustLocationGroupDetailVO> list = command1.searchRateGroupLocationDetailList(event.getRsltPriSurchargeAdjustLocationGroupDetailVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}				
	


    /**
     * ESM_PRI_6075 : Retrieve , onLoad, radioButton_onChange(rate_type,pfmc_unit) <BR>
     * CM/OP View 내용을 조회 합니다.<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchRateCmViewAllList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri6075Event event = (EsmPri6075Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        SCRateQuotationBC command1 = new SCRateQuotationBCImpl();
        try{
	        List<RsltPriRateCmViewAllVO> list = command1.searchRateCmViewAllList(event.getRsltPriRateCmViewAllVO());
	        eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * ESM_PRI_6075 : Save <BR>
     * CM/OP View 의 Load 값을  갱신처리 합니다.
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse modifyPrsPfmc(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri6075Event event = (EsmPri6075Event) e;
        try {
            begin();
            SCRateQuotationBC command = new SCRateQuotationBCImpl();
            SCQuotationMainBC command2 = new SCQuotationMainBCImpl();
            command.modifyPrsPfmc(event.getPriSqRtCmdtRoutSetVO(), account);
            command2.modifyPrsPriSqMnCm(event.getPriSqRtCmdtRoutSetVO(), account);
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
     * ESM_PRI_6012 : OK <BR>
     * Quotaion Rate 의 Surcharge Amount값을  갱신처리 합니다.
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse modifyRateScQuotation(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri6012Event event = (EsmPri6012Event) e;
        try {
            begin();
            SCRateQuotationBC command = new SCRateQuotationBCImpl();
            command.modifyRateScQuotation(event.getInPriQuotationRateAdjustSetVO(), account);
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
     * ESM_PRI_6012 :  onLoad  <BR>
     * Quotaion의 route 를 조회 합니다.<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchCommodityRouteList(Event e) throws EventException {
        EsmPri6012Event event = (EsmPri6012Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        SCRateQuotationBC command1 = new SCRateQuotationBCImpl();
        try{
	        List<RsltPriCommodityRouteVO> list = command1.searchCommodityRouteList(event.getInPriCommodityRouteVO());
	        eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }  
    
    	
	/**
     * ESM_PRI_6012 :  OnLoad  <BR>
     * Quotaion의 route의 모든 Area 리스트 조회 <BR>
     * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommodityRouteAreaList(Event e) throws EventException {
        EsmPri6012Event event = (EsmPri6012Event) e;
      
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        SCRateQuotationBC command1 = new SCRateQuotationBCImpl();
        try{
	        List<RsltCdListVO> list = command1.searchCommodityRouteAreaList(event.getInPriCommodityRouteVO());
	        eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	/**
     * ESM_PRI_6012 :  OnLoad  <BR>
     * 초기 Combo에 setting할 초기값를 조회 합니다.<br>
     * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInitCommodityRoute(Event e) throws EventException {
        EsmPri6012Event event = (EsmPri6012Event) e;
        SCRateQuotationBC command1 = new SCRateQuotationBCImpl();
		PRICommonBC command = new PRICommonBCImpl();
        InPriCommodityRouteVO inVO = null;
       

 

		RsltCdListVO rsltcdlistvo = new RsltCdListVO();
		RsltCdListVO rsltVO = new RsltCdListVO();
		List<RsltCdListVO> customData = null; 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		InPriCommodityRouteVO params = event.getInPriCommodityRouteVO();

		try{
			// Customer Type
			rsltcdlistvo.setEtc1(params.getCustCntCd());
			rsltcdlistvo.setEtc2(params.getCustSeq());
			customData = command.searchCustomerName(rsltcdlistvo);
			eventResponse.setCustomData("CustomerName", customData);	
			
			//currency 
			rsltcdlistvo = new RsltCdListVO();
			customData = command.searchCurrencyCodeList(rsltcdlistvo);
			eventResponse.setCustomData("Currency", customData);	
	
			//per 
			rsltcdlistvo = new RsltCdListVO();
			customData = command.searchPerCodeList(rsltcdlistvo);
			eventResponse.setCustomData("Per", customData);	
			
			//cargo 
			rsltcdlistvo = new RsltCdListVO();
			rsltcdlistvo.setCd("CD02202");
			customData = command.searchComCodeDescList(rsltcdlistvo);
			eventResponse.setCustomData("Cargo", customData);	
			
	//		// CD02070 SC RECEIVING TERM CODE     	
	//		rsltcdlistvo = new RsltCdListVO();
	//		rsltcdlistvo.setCd("CD02070");
	//		customData = command.searchComCodeList(rsltcdlistvo);
	//		eventResponse.setCustomData("ReceiveTerm", customData);	
	//		// CD02071 SC TRANS TERM CODE     	
	//		rsltcdlistvo = new RsltCdListVO();
	//		rsltcdlistvo.setCd("CD02071");
	//		customData = command.searchComCodeList(rsltcdlistvo);
	//		eventResponse.setCustomData("DestTerm", customData);			
	//		
			
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
			
			
			// Origin  Term
			inVO = event.getInPriCommodityRouteVO();
			inVO.setOrgDestTpCd("O");
			inVO.setOpTpCd("C"); // Ori or Dest Term
			customData = command1.searchCommodityRouteAreaList(inVO);
			eventResponse.setCustomData("ReceiveTerm", customData);	
			
			// Dest  Term
			inVO = event.getInPriCommodityRouteVO();
			inVO.setOrgDestTpCd("D");
			inVO.setOpTpCd("C"); // Ori or Dest Term
			customData = command1.searchCommodityRouteAreaList(inVO);
			eventResponse.setCustomData("DestTerm", customData);	
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		
		return eventResponse;
		
	}
    /**
     * ESM_PRI_6065 :  onLoad , Retrieve <BR>
     * Cost Detail by Trans.Mode 를 조회 합니다.<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchCostDetailByTransModeList(Event e) throws EventException {
        EsmPri6065Event event = (EsmPri6065Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        SCRateQuotationBC command1 = new SCRateQuotationBCImpl();
        try{
	        List<RsltPriCostDetailByTransModeListVO> list = command1.searchCostDetailByTransModeList(event.getRsltPriCostDetailByTransModeListVO());
	        eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }    
    
    
    //ESM_PRI_6005 S/C Quotation Creation start
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_6005 : Retrieve <br>
	 * Quotation Main 정보를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScQuotationMainList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6005Event event = (EsmPri6005Event)e;
		SCQuotationMainBC command = new SCQuotationMainBCImpl();
		
		try{
			List<RsltPriSqMnVO> list = 
				command.searchScQuotationMainList(event.getQutationMainVO().getRsltPriSqMnVO());
			eventResponse.setRsVoList(list);
			
			
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_6005 : Retrieve <br>
	 * Quotation Main 정보에 대해 calculate 를 수행 했는지를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScQuotationMainChkNeedCalcList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6005Event event = (EsmPri6005Event)e;
		SCQuotationMainBC command = new SCQuotationMainBCImpl();
		
		try{
			List<CstRequestCheckVO> list = new ArrayList<CstRequestCheckVO>();
			List<RsltPriSqMnChkNeedCalcVO> listCalc = 
				command.searchScQuotationMainChkNeedCalcList(event.getQutationMainVO().getRsltPriSqMnVO());
			

        	//Calculate를 하지 않은 내용이 존재 하므로 Exception처리 한다.
        	if( listCalc != null && listCalc.size() > 0 ){
        		String preSvcScpCd = "";
        		String svcScpCd = "";
        		StringBuffer strMsg = new StringBuffer();
        		for(int i = 0 ; i < listCalc.size(); i++ ){
        			svcScpCd = listCalc.get(i).getSvcScpCd();
        			if( preSvcScpCd.equals(svcScpCd)){
        				strMsg.append(" & ").append("Special Rate");
        			}else if( "G".equals(listCalc.get(i).getGenSpclRtTpCd()) ){
        				strMsg.append("\n  ").append(svcScpCd).append(" ").append( "General Rate" );
        			}else{
        				strMsg.append("\n  ").append(svcScpCd).append(" ").append( "Special Rate" );
        			}
        			preSvcScpCd = svcScpCd;
        		}
        		//throw new EventException(new ErrorHandler("PRI03019",new String[]{strMsg.toString()}).getMessage());
        		CstRequestCheckVO vo = new CstRequestCheckVO();
        		vo.setTerms("CALC_CHK" );
        		vo.setCnt("1");
        		vo.setNote( strMsg.toString());
        		list.add(vo);
        	}
			eventResponse.setRsVoList(list);
			
			
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
		
	
	
	/**
	 * ESM_PRI_6005 : Retrieve <br>
	 * GLINE 존재여부를 체크한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGlineExist(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6005Event event = (EsmPri6005Event)e;
		SCQuotationMainBC command = new SCQuotationMainBCImpl();
		
		try{
			List<RsltSearchGlineExistVO> list = 
				command.searchGlineExist(event.getQutationMainVO().getRsltPriSqMnVO());
			eventResponse.setRsVoList(list);
			
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	
	/**
	 * ESM_PRI_6005 : Add Version, Copy To Proposal <br>
	 * cmdt seq 별 rate data가 있는지 체크한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkExistRate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6005Event event = (EsmPri6005Event)e;
		SCQuotationMainBC command = new SCQuotationMainBCImpl();
		String cnt_non_rate = "0";
		try{
			cnt_non_rate = command.checkExistRate(event.getQutationMainVO().getRsltPriSqMnVO());
			eventResponse.setETCData("cnt_non_rate", cnt_non_rate);
			log.debug("*********************************************************");
			log.debug("cnt_non_rate : " + eventResponse.getETCData("cnt_non_rate"));
			log.debug("*********************************************************");
			
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
 
	
	/**
	 * ESM_PRI_6005 : Retrieve <br>
	 * 텝별 건수를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDetailCnt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6005Event event = (EsmPri6005Event)e;
		SCQuotationMainBC command = new SCQuotationMainBCImpl();
		
		try{
			String qttn_no_read = JSPUtil.getNullNoTrim(event.getQutationMainVO().getRsltPriSqMnVO().getQttnNoRead());
			String qttn_ver_no_read = JSPUtil.getNullNoTrim(event.getQutationMainVO().getRsltPriSqMnVO().getQttnVerNoRead());
			
			if(!"".equals(qttn_no_read) && !"".equals(qttn_ver_no_read)) {
				event.getQutationMainVO().getRsltPriSqMnVO().setQttnNo(qttn_no_read);
				event.getQutationMainVO().getRsltPriSqMnVO().setQttnVerNo(qttn_ver_no_read);
			}
			
			List<RsltSearchDetailCntVO> list = 
				command.searchDetailCnt(event.getQutationMainVO().getRsltPriSqMnVO());
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	
	/**
	 * ESM_PRI_6005 : Save <br>
	 * PRI_SQ_HDR, PRI_SQ_MN 정보를 저장한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageScQuotationMain(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6005Event event = (EsmPri6005Event)e;
		SCQuotationMainBC command = new SCQuotationMainBCImpl();
		
		try{
			begin();
			RsltPriSqMnVO rsltPriSqMnVO = command.manageScQuotationMain(event.getQutationMainVO(),account);
//			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			
//			//저장시 키값을 etc 에 리턴
//			eventResponse.setETCData("quotation_no", rsltPriSqMnVO.getQttnNo());
//			eventResponse.setETCData("quotation_version_no", rsltPriSqMnVO.getQttnVerNo());
//			log.debug("*********************************************************");
//			log.debug("quotation_no : " + eventResponse.getETCData("quotation_no"));
//			log.debug("quotation_version_no : " + eventResponse.getETCData("quotation_version_no"));
//			log.debug("*********************************************************");
			eventResponse.setRsVo(rsltPriSqMnVO);
			
			
//			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
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
	 * ESM_PRI_6005 : Delete <br>
	 * QTTN NO에 속한 모든 정보를 삭제한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeScQuotationMain(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6005Event event = (EsmPri6005Event)e;
		SCQuotationMainBC 			command1 = new SCQuotationMainBCImpl();
		SCGroupLocationQuotationBC  command2 = new SCGroupLocationQuotationBCImpl();
		SCGroupCommodityQuotationBC command3 = new SCGroupCommodityQuotationBCImpl();
		SCRateQuotationBC 			command4 = new SCRateQuotationBCImpl();
		
		try{
			begin();
			command4.removeScRateQuotation(event.getQutationMainVO().getPriSqHdrVO());
			command3.removeManageScGroupCommodityQuotation(event.getQutationMainVO().getPriSqHdrVO());
			command2.removeScGroupLocationQuotation(event.getQutationMainVO().getPriSqHdrVO());
			command1.removeScQuotationMain(event.getQutationMainVO().getPriSqHdrVO());
//			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
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
	 * ESM_PRI_6005 : Cancel <br>
	 * RI_SQ_HDR 테이블에 상태코드를 cancel로 저장한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelStatusScQuotationMain(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6005Event event = (EsmPri6005Event)e;
		SCQuotationMainBC command = new SCQuotationMainBCImpl();
		
		try{
			begin();
			event.getQutationMainVO().getPriSqHdrVO().setQttnStsCd("C");
			command.cancelStatusScQuotationMain(event.getQutationMainVO().getPriSqHdrVO(),account);
//			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
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
	 * ESM_PRI_6005 : Add Version <br>
	 * Quotation version을 신규로 하나 따서 선택한 Quotation을 복사하여 등록한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */ 
	private EventResponse createVersionScQuotationMain(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6005Event event = (EsmPri6005Event)e;
		
		SCQuotationMainBC 			command1 = new SCQuotationMainBCImpl();
		SCGroupLocationQuotationBC  command2 = new SCGroupLocationQuotationBCImpl();
		SCGroupCommodityQuotationBC command3 = new SCGroupCommodityQuotationBCImpl();
		SCRateQuotationBC 			command4 = new SCRateQuotationBCImpl();
		
					
		try{
			begin();
			
			//status 를 세팅
			event.getQutationMainVO().getRsltCopyToQuotationVO().setQttnStsCd("N");
			
			//copy tpye 를 세팅
			event.getQutationMainVO().getRsltCopyToQuotationVO().setCopyType("AV");
//			log.debug("==========================================================");
//			log.debug( event.getQutationMainVO().getRsltCopyToQuotationVO().getCopyType());
//			log.debug("==========================================================");
			command1.copyToQuotationScQuotaionMainReport(event.getQutationMainVO().getRsltCopyToQuotationVO(), account);
			command2.copyToQuotationScGroupLocationQuotaionReport(event.getQutationMainVO().getRsltCopyToQuotationVO(),account);
			command3.copyToQuotationScGroupCommodityQuotaionReport(event.getQutationMainVO().getRsltCopyToQuotationVO(),account);
			command4.copyToQuotationScRateQuotaionReport(event.getQutationMainVO().getRsltCopyToQuotationVO(),account);
	
//			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
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
		
	//ESM_PRI_6005 S/C Quotation Creation end
	//////////////////////////////////////////////////////////////////////////////////
	
	
	//ESM_PRI_6005_01 S/C Quotation Location Group Creation start
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_6005_01 : Retrieve <br>
	 * PRI_SQ_GRP_LOC 테이블을 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScGroupLocationQuotationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri600501Event event = (EsmPri600501Event)e;
		SCGroupLocationQuotationBC command = new SCGroupLocationQuotationBCImpl();
		
		try{
			List<RsltPriSqGrpLocVO> list = 
				command.searchScGroupLocationQuotationList(event.getGroupLocationQuotationVO().getPriSqGrpLocVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }		
		return eventResponse;
	}
	
	
	/**
	 * ESM_PRI_6005_01 : Retrieve <br>
	 * PRI_SQ_GRP_LOC_DTL 테이블을 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupLocationDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri600501Event event = (EsmPri600501Event)e;
		SCGroupLocationQuotationBC command = new SCGroupLocationQuotationBCImpl();
		
		try{
			List<RsltPriSqGrpLocDtlVO> list = 
				command.searchGroupLocationDetailList(event.getGroupLocationQuotationVO().getPriSqGrpLocVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_6005_01 : Delete<br>
	 * Group Loc 삭제시, Rate에서 사용하고 있는 코드인지 확인한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse checkGroupLocationInUse(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri600501Event event = (EsmPri600501Event)e;
		SCGroupLocationQuotationBC command = new SCGroupLocationQuotationBCImpl();
		
		try {
			List<RsltCdListVO> vos = command.checkGroupLocationInUse(event.getGroupLocationQuotationVO());
			eventResponse.setRsVoList(vos);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_6005_01 : Save <br>
	 * S/C Quotation Location Group을 저장한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageScGroupLocationQuotation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri600501Event event = (EsmPri600501Event)e;
		SCGroupLocationQuotationBC command = new SCGroupLocationQuotationBCImpl();
		
		try{
			begin();
			command.manageScGroupLocationQuotation(event.getGroupLocationQuotationVO(),account);
//			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
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
	 * ESM_PRI_6005_01 : G/L Copy <br>
	 * PRI_SQ_GRP_LOC, PRI_SQ_GRP_LOC_DTL 에 가이드라인 정보를 카피 등록한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse glineCopyScGroupLocationQuotation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri600501Event event = (EsmPri600501Event)e;
		SCGroupLocationQuotationBC command = new SCGroupLocationQuotationBCImpl();
		
		try{
			begin();
			command.glineCopyScGroupLocationQuotation(event.getGroupLocationQuotationVO().getRsltPriSqMnVO(),account);
//			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
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
	
	//ESM_PRI_6005_01 S/C Quotation Location Group Creation end
	//////////////////////////////////////////////////////////////////////////////////
	
	
	//ESM_PRI_6005_02 S/C Quotation Commodity Group Creation start
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_6005_02 : Retrieve <br>
	 * S/C Quotation Commodity Group 정보를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScGroupCommodityQuotationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri600502Event event = (EsmPri600502Event)e;
		SCGroupCommodityQuotationBC command = new SCGroupCommodityQuotationBCImpl();
		
		try{
			List<RsltPriSqGrpCmdtVO> list = 
				command.searchScGroupCommodityQuotationList(event.getGroupCommodityQuotationVO().getPriSqGrpCmdtVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	
	/**
	 * ESM_PRI_6005_02 : Retrieve <br>
	 * S/C Quotation Commodity Group Detail 정보를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodityDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri600502Event event = (EsmPri600502Event)e;
		SCGroupCommodityQuotationBC command = new SCGroupCommodityQuotationBCImpl();
		
		try{
			List<RsltPriSqGrpCmdtDtlVO> list = 
				command.searchGroupCommodityDetailList(event.getGroupCommodityQuotationVO().getPriSqGrpCmdtVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_6005_02 : Delete<br>
	 * Group cmdt 삭제시, Rate에서 사용하고 있는 코드인지 확인한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse checkGroupCommodityInUse(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri600502Event event = (EsmPri600502Event)e;
		SCGroupCommodityQuotationBC command = new SCGroupCommodityQuotationBCImpl();
		
		try {
			List<RsltCdListVO> vos = command.checkGroupCommodityInUse(event.getGroupCommodityQuotationVO());
			eventResponse.setRsVoList(vos);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * ESM_PRI_6005_02 : Save <br>
	 * S/C Quotation Commodity Group 정보를 저장한다.(PRI_SQ_GRP_CMDT, PRI_SQ_GRP_CMDT_DTL)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageScGroupCommodityQuotation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri600502Event event = (EsmPri600502Event)e;
		SCGroupCommodityQuotationBC command = new SCGroupCommodityQuotationBCImpl();
		
		try{
			begin();
			command.manageScGroupCommodityQuotation(event.getGroupCommodityQuotationVO(),account);
//			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
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
	 * ESM_PRI_6005_02 : G/L Copy <br>
	 * PRI_SQ_GRP_CMDT, PRI_SQ_GRP_CMDT_DTL 에 가이드라인 정보를 카피 등록한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse glineCopyScGroupCommodityQuotation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri600502Event event = (EsmPri600502Event)e;
		SCGroupCommodityQuotationBC command = new SCGroupCommodityQuotationBCImpl();
		
		try{
			begin();
			command.glineCopyScGroupCommodityQuotation(event.getGroupCommodityQuotationVO().getRsltPriSqMnVO(),account);
//			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
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
	
	//ESM_PRI_6005_02 S/C Quotation Commodity Group Creation end
	//////////////////////////////////////////////////////////////////////////////////
	
	
	//ESM_PRI_6005_03 S/C Quotation Rate Creation start
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_6005_03 : Retrieve <br>
	 * PRI_SQ_RT_CMDT_HDR, PRI_SQ_RT_CMDT 을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSCRateQuotationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri600503Event event = (EsmPri600503Event)e;
		SCRateQuotationBC command = new SCRateQuotationBCImpl();
		
		try{
			List<RsltPriSqRtCmdtVO> list = 
				command.searchSCRateQuotationList(event.getRateQuotationVO().getPriSqRtCmdtHdrVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }		
		return eventResponse;
	}
	
	
	/**
	 * ESM_PRI_6005_03 : Retrieve <br>
	 * PRI_SQ_RT_CMDT_ROUT 을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCommodityRouteList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri600503Event event = (EsmPri600503Event)e;
		SCRateQuotationBC command = new SCRateQuotationBCImpl();
		
		try{
			List<RsltPriSqRtCmdtRoutVO> list = 
				command.searchRateCommodityRouteList(event.getRateQuotationVO().getPriSqRtCmdtHdrVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	
	/**
	 * ESM_PRI_6005_03 : Retrieve <br>
	 * S/C Quotation Rate 정보를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri600503Event event = (EsmPri600503Event)e;
		SCRateQuotationBC command = new SCRateQuotationBCImpl();
		
		//컨테이너 vo
		RateQuotationVO rateQuotationVO = new RateQuotationVO();

		try{
			rateQuotationVO = command.searchRateList(event.getRateQuotationVO().getPriSqRtCmdtRoutVO());
			
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriSqRtCmdtVOList());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriSqRtVOList());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriSqRtRoutOrgPntVOList());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriSqRtRoutOrgViaVOList());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriSqRtRoutDestViaVOList());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriSqRtRoutDestPntVOList());
			
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	
	/**
	 * ESM_PRI_6005_03 : Down Excel <br>
	 * Rate Vertical Excel Download 리스트를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateListVerticalExcel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri600503Event event = (EsmPri600503Event)e;
		SCRateQuotationBC command = new SCRateQuotationBCImpl();

		try{
			List<RsltRtListVerticalExcelVO> list = command.searchRateListVerticalExcel(event.getRateQuotationVO().getPriSqRtCmdtHdrVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	
	/**
	 * ESM_PRI_6005_03 : Down Excel <br>
	 * Rate Horizontal Excel Download 리스트를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateListHorizontalExcel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri600503Event event = (EsmPri600503Event)e;
		SCRateQuotationBC command = new SCRateQuotationBCImpl();

		try{
			List<RsltRtListHorizontalExcelVO> list = command.searchRateListHorizontalExcel(event.getRateQuotationVO().getPriSqRtCmdtHdrVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	
	/**
	 * ESM_PRI_6005_03 : Save <br>
	 * PRI_SQ_RT_CMDT_HDR, PRI_SQ_RT_CMDT 입력 수정 삭제한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCommoditySCRateQuotation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri600503Event event = (EsmPri600503Event)e;
		SCRateQuotationBC command = new SCRateQuotationBCImpl();
		
		try{
			begin();
			command.manageCommoditySCRateQuotation(event.getRateQuotationVO(),account);
//			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
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
	 * ESM_PRI_6005_03 : Save <br>
	 * PRI_SQ_RT_CMDT_ROUT, PRI_SQ_RT_ROUT_PNT, PRI_SQ_RT_ROUT_VIA, PRI_SQ_RT 입력 수정 삭제한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRouteRateSCRateQuotation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri600503Event event = (EsmPri600503Event)e;
		SCRateQuotationBC command = new SCRateQuotationBCImpl();
		
		try{
			begin();
			command.manageRouteRateSCRateQuotation(event.getRateQuotationVO(),account);
//			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
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
	 * ESM_PRI_6005_03 : G/L Copy <br>
	 * Rate 관련 테이블에 가이드라인 정보를 카피 입력한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse glineCopyScRateQuotation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri600503Event event = (EsmPri600503Event)e;
		SCRateQuotationBC command = new SCRateQuotationBCImpl();
		
		try{
			begin();
			command.glineCopyScRateQuotation(event.getRateQuotationVO().getRsltPriSqMnVO(),account);
//			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
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
	
	//ESM_PRI_6005_03 S/C Quotation Rate Creation end
	//////////////////////////////////////////////////////////////////////////////////
	
	
	//ESM_PRI_6008 S/C Quotation Rate Creation - G/L Copy Option start
	//////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * ESM_PRI_6008 : OK <br>
	 * S/C Quotation 전체 테이블에 가이드라인 정보를 카피 입력한다<br>
	 *  
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse glineCopyScQuotaion(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6008Event event = (EsmPri6008Event)e;
		SCQuotationMainBC command1 = new SCQuotationMainBCImpl();
		SCGroupLocationQuotationBC command2 = new SCGroupLocationQuotationBCImpl();
		SCGroupCommodityQuotationBC command3 = new SCGroupCommodityQuotationBCImpl();
		SCRateQuotationBC command4 = new SCRateQuotationBCImpl();
		String gline_seq = "";
		//체크된 항목
		RsltSearchGlineExistVO vo = event.getQutationMainVO().getRsltSearchGlineExistVO();
		//tpw 
//		SqScpGlineCopyVO tpwVO = event.getQutationMainVO().getSqScpGlineCopyVO();
		log.debug("========================================TPW");
		log.debug(vo.toString());
		try{
			
			gline_seq = command1.searchCopyGlineSeq(event.getQutationMainVO().getRsltPriSqMnVO()); // Copy 대상의 gline_seq
			
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
                command2.glineCopyScGroupLocationQuotation(event.getQutationMainVO().getRsltPriSqMnVO(), account);
            }

            if (JSPUtil.getNullNoTrim(vo.getSvcScpCd()).equals("TPW")) {
                if (JSPUtil.getNullNoTrim(vo.getCmdtTpwChk()).equals("2") && !JSPUtil.getNullNoTrim(vo.getCmdtTpwMst()).equals("")) {
                    log.debug("****************************** Copy Group Commodity TPW");
                    command3.copyScopeGuidelineGrpCmdtTpw(vo, account);
                }
            } else {
                if (JSPUtil.getNullNoTrim(vo.getCmdtChk()).equals("2")) {
                    log.debug("****************************** Copy Group Commodity");
                    command3.glineCopyScGroupCommodityQuotation(event.getQutationMainVO().getRsltPriSqMnVO(), account);
                }                
            }
			
            if (JSPUtil.getNullNoTrim(vo.getRateChk()).equals("2")) {
                log.debug("****************************** Copy Rate");
                command4.glineCopyScRateQuotation(event.getQutationMainVO().getRsltPriSqMnVO(), account);
            }
            
			
//            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
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
	
	//ESM_PRI_6008 S/C Quotation Rate Creation - G/L Copy Option start end
	//////////////////////////////////////////////////////////////////////////////////
	
	
	//ESM_PRI_6033 S/C Quotation Copy to Proposal start
	//////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * ESM_PRI_6033 : OK <br>
	 * S/C Quotation 정보를 S/C PROPOSAL 테이블에 카피 입력한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */ 
	private EventResponse copyToPropScQuotation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6033Event event = (EsmPri6033Event)e;
		
		SCQuotationMainBC command1 = new SCQuotationMainBCImpl();
		SCProposalMainBC  command2 = new SCProposalMainBCImpl();
		
		SCContractPartyProposalBC command3 = new SCContractPartyProposalBCImpl();
		SCDurationProposalBC command4 = new SCDurationProposalBCImpl();
		SCMQCProposalBC command5 = new SCMQCProposalBCImpl();
		SCGroupCommodityProposalBC command6 = new SCGroupCommodityProposalBCImpl();
		SCGroupLocationProposalBC command7 = new SCGroupLocationProposalBCImpl();
		SCRateProposalBC command8 = new SCRateProposalBCImpl();
		
					
		try{
			begin();
			String newPropNo = command2.searchMaxPropNo(account); // 생성된 prop_no
			log.debug("****************************** newPropNo : " +newPropNo);
            if (JSPUtil.getNull(newPropNo).equals("")) {
                eventResponse.setUserMessage(new ErrorHandler("PRI00201").getUserMessage());
                commit();
                return eventResponse;
            }
            
            //prop no setting
            event.getRsltCopyToProposalVO().setNewPropNo(newPropNo);
            log.debug("****************************** APPROVAL OFFICE " + event.getRsltCopyToProposalVO().getAppOfcCd());
			
			log.debug("****************************** Copy Base");
			command2.copyToProposalBase(event.getRsltCopyToProposalVO(), account);
			
			log.debug("****************************** Copy CtrtPty");
			command3.copyToProposalCtrtPty(event.getRsltCopyToProposalVO(), account);
			
			log.debug("****************************** Copy Duration");
			command4.copyToProposalDuration(event.getRsltCopyToProposalVO(), account);
			
			log.debug("****************************** Copy MQC");
			command5.copyToProposalMqc(event.getRsltCopyToProposalVO(), account);
			
			
			if (JSPUtil.getNullNoTrim(event.getRsltCopyToProposalVO().getFrmGrpLocCnt()).equals("Y")) {
                log.debug("****************************** Copy Group Location");
                command7.copyToProposalLoc(event.getRsltCopyToProposalVO(), account);
			}
			
			if (JSPUtil.getNullNoTrim(event.getRsltCopyToProposalVO().getFrmGrpCmdtCnt()).equals("Y")) {
                log.debug("****************************** Copy Group Commodity");
                command6.copyToProposalCmdt(event.getRsltCopyToProposalVO(), account);
			}
			
			if (JSPUtil.getNullNoTrim(event.getRsltCopyToProposalVO().getFrmRateGCnt()).equals("Y")
				|| JSPUtil.getNullNoTrim(event.getRsltCopyToProposalVO().getFrmRateSCnt()).equals("Y")) {
				
				if(JSPUtil.getNullNoTrim(event.getRsltCopyToProposalVO().getFrmRateGCnt()).equals("Y")) {
					event.getRsltCopyToProposalVO().setGenSpclRtTpCdFrom("G");
				}
				
				if(JSPUtil.getNullNoTrim(event.getRsltCopyToProposalVO().getFrmRateSCnt()).equals("Y")) {
					event.getRsltCopyToProposalVO().setGenSpclRtTpCdFrom("S");
				}
				
				if(JSPUtil.getNullNoTrim(event.getRsltCopyToProposalVO().getFrmRateGCnt()).equals("Y")
						&& 	JSPUtil.getNullNoTrim(event.getRsltCopyToProposalVO().getFrmRateSCnt()).equals("Y")) {
						
					event.getRsltCopyToProposalVO().setGenSpclRtTpCdFrom("");
				}
				log.debug("****************************** GenSpclRtTpCdFrom : " + event.getRsltCopyToProposalVO().getGenSpclRtTpCdFrom());
				
                log.debug("****************************** Copy General Rate");
                command8.copyToProposalRate(event.getRsltCopyToProposalVO(), account);
			}
			
			//상태코드 Proposed로 세팅
			PriSqHdrVO hVo = new PriSqHdrVO();
			hVo.setQttnNo(event.getRsltCopyToProposalVO().getQttnNo());
			hVo.setQttnStsCd("P");		
			command1.cancelStatusScQuotationMain(hVo,account);
			
			//copy to proposal 시 생성된 proposal no 업데이트  
			PriSqMnVO priSqMnVO = new PriSqMnVO();
			
			priSqMnVO.setPropNo(newPropNo);
			
			priSqMnVO.setQttnNo(event.getRsltCopyToProposalVO().getQttnNo());
			priSqMnVO.setQttnVerNo(event.getRsltCopyToProposalVO().getQttnVerNo());
			
			priSqMnVO.setUpdUsrId(account.getUsr_id());
			
			command1.modifyScQuotationMainPropNo(priSqMnVO,account);
			
//          eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			
			//저장시 키값을 etc 에 리턴
			eventResponse.setETCData("prop_no", newPropNo);
			log.debug("*********************************************************");
			log.debug("prop_no : " + eventResponse.getETCData("prop_no"));
			log.debug("*********************************************************");
			
//			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
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
	
	
	//ESM_PRI_6033 S/C Quotation Copy to Proposal end
	//////////////////////////////////////////////////////////////////////////////////
	
	
	//ESM_PRI_6034 S/C Quotation Copy to Quotation start
	//////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * ESM_PRI_6034 : OK <br>
	 * 선택한 S/C Quotation 정보를 신규로 등록한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */ 
	private EventResponse copyToQuotationScQuotaionReport(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6034Event event = (EsmPri6034Event)e;
		
		SCQuotationMainBC 			command1 = new SCQuotationMainBCImpl();
		SCGroupLocationQuotationBC  command2 = new SCGroupLocationQuotationBCImpl();
		SCGroupCommodityQuotationBC command3 = new SCGroupCommodityQuotationBCImpl();
		SCRateQuotationBC 			command4 = new SCRateQuotationBCImpl();
		
		String max_qttn_no = "";
		String qttn_ver_no = "Q1";
				
		try{
			begin();
			//max_qttn_no search
			PriSqHdrVO vo = new PriSqHdrVO();
			vo.setQttnOfcCd(account.getOfc_cd());
			max_qttn_no = command1.searchScQuotationHeaderMaxQttnNo(vo);
			
			//max_qttn_no 를 세팅
			event.getRsltCopyToQuotationVO().setQttnNo(max_qttn_no);
			//max_qttn_ ver _no 를 세팅
			event.getRsltCopyToQuotationVO().setQttnVerNo(qttn_ver_no);
			//status 를 세팅
			event.getRsltCopyToQuotationVO().setQttnStsCd("N");
			
			//copy tpye 를 세팅
			event.getRsltCopyToQuotationVO().setCopyType("");
			
				
			log.debug("****************************** Copy Main");
			command1.copyToQuotationScQuotaionMainReport(event.getRsltCopyToQuotationVO(), account);
			
			if (JSPUtil.getNullNoTrim(event.getRsltCopyToQuotationVO().getFrmGrpLocCnt()).equals("Y")) {
                log.debug("****************************** Copy Group Location");
                command2.copyToQuotationScGroupLocationQuotaionReport(event.getRsltCopyToQuotationVO(),account);
			}
			
			if (JSPUtil.getNullNoTrim(event.getRsltCopyToQuotationVO().getFrmGrpCmdtCnt()).equals("Y")) {
                log.debug("****************************** Copy Group Commodity");
                command3.copyToQuotationScGroupCommodityQuotaionReport(event.getRsltCopyToQuotationVO(),account);
			}
			
			if (JSPUtil.getNullNoTrim(event.getRsltCopyToQuotationVO().getFrmRateGCnt()).equals("Y")) {
                log.debug("****************************** Copy General Rate");
                event.getRsltCopyToQuotationVO().setGenSpclRtTpCdFrom("G");
                command4.copyToQuotationScRateQuotaionReport(event.getRsltCopyToQuotationVO(),account);
			}
			
			if (JSPUtil.getNullNoTrim(event.getRsltCopyToQuotationVO().getFrmRateSCnt()).equals("Y")) {
                log.debug("****************************** Copy Special Rate");
                event.getRsltCopyToQuotationVO().setGenSpclRtTpCdFrom("S");
                command4.copyToQuotationScRateQuotaionReport(event.getRsltCopyToQuotationVO(),account);
			}
	
//          eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			
			//저장시 키값을 etc 에 리턴
			eventResponse.setETCData("quotation_no", max_qttn_no);
			log.debug("*********************************************************");
			log.debug("quotation_no : " + eventResponse.getETCData("quotation_no"));
			log.debug("*********************************************************");
			
//			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
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
	
	
	//ESM_PRI_6034 S/C Quotation Copy to Quotation end
	//////////////////////////////////////////////////////////////////////////////////
	
	
	
	//ESM_PRI_6035 S/C Quotation-Rate View All start
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_6034 : Retrieve <br>
	 * Rate 관련 상세내역을 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchViewAllSCRateQuotationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6035Event event = (EsmPri6035Event)e;
		SCRateQuotationBC command = new SCRateQuotationBCImpl();
		
		try{
			List<RsltPriSqRtAllViewVO> list = 
				command.searchViewAllSCRateQuotationList(event.getPriSqRtCmdtHdrVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	//ESM_PRI_6035 S/C Quotation-Rate View All end
	//////////////////////////////////////////////////////////////////////////////////
    
	
	

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
        EsmPri600503Event event = (EsmPri600503Event)e;
        SCRateQuotationBC command = new SCRateQuotationBCImpl();
        PRICommonBC comCommand = new PRICommonBCImpl();
        String prsBatId = "";;

        try{
			///////////////////////////////////////////////////////////////// 
			// property 읽어 오기
			String rCnt = SubSystemConfigFactory.get("PRI.SC.QTTN.ROTATION.CNT");
			int iRCnt = 5;
			if( rCnt != null ){
				iRCnt = Integer.valueOf(rCnt); 
			}
			//////////////////////////////////////////////////////////////// 
			
        	PriPrsBatVO priPrsBatVO = command.searchMonitorCalculateParam(event.getRateQuotationVO().getPriSqRtCmdtRoutVO());
        	PrsBatchVO prsBatchVO = comCommand.searchPrsBatch(priPrsBatVO);
            
            
            //pri_Prs_Bat table에 데이터가 있을경우
            if( prsBatchVO != null ){
            	String status  = command.monitorCalculate(prsBatchVO);
            	
            	if( "0".equals(status)  // Nothing 아직 상태모름
            			|| "1".equals(status) // running
            			|| "8".equals(status) // INACTIVE	실행대기
            			|| "12".equals(status)// QUE_WAIT	 로드밸런싱 대기 
            			){
            		//이미 실행중이라면 에러 처리한다.
            		 throw new EventException(new ErrorHandler("PRI03019",new String[]{account.getUsr_id()}).getMessage());
            	}
            }
        	//////////////////////////////////////////////////////////////////////////////////// 
        	//batch 프로그램 명을 rotation 하기 위한 작업 시작
        	PriPrsBatVO updatePriPrsBatVO = new PriPrsBatVO();
        	updatePriPrsBatVO.setPgmNo("ESM_PRI_T005");
        	updatePriPrsBatVO.setPrsBatId( String.valueOf(iRCnt) );
        	begin();
        	comCommand.modifyPrsBatchMaxRotation(updatePriPrsBatVO);
        	commit();
        	PrsBatchVO rotationPrsBatchVo = comCommand.searchPrsBatchMaxRotation (updatePriPrsBatVO);
        	String rotationPrsBatId = rotationPrsBatchVo.getPrsBatId();
        	log.debug("rotationPrsBatId====>"+rotationPrsBatId);
        	//batch 프로그램 명을 rotation 하기 위한 작업 종료
        	
			////////////////////////////////////////////////////////////////////////////////////      
            
        	priPrsBatVO = command.executeCalculate(event.getRateQuotationVO().getPriSqRtCmdtRoutVO(),rotationPrsBatId,account); 
        	
        	
            if( priPrsBatVO != null ){ 
            	begin();
            	comCommand.addPrsBatch(priPrsBatVO,account);
            	prsBatId = priPrsBatVO.getPrsBatId();
            	commit();
            }
            
            eventResponse.setETCData("JOB_ID",prsBatId);

        }catch(EventException ex){
        	rollback();
            throw ex;
        }catch(Exception ex){
        	rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
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
        EsmPri600503Event event = (EsmPri600503Event)e;
        SCRateQuotationBC command = new SCRateQuotationBCImpl();
        PRICommonBC comCommand = new PRICommonBCImpl();
        String batchId = "";

        try{
        	PriPrsBatVO priPrsBatVO = command.searchMonitorCalculateParam(event.getRateQuotationVO().getPriSqRtCmdtRoutVO());
        	PrsBatchVO prsBatchVO = comCommand.searchPrsBatch(priPrsBatVO);
            String status  = command.monitorCalculate(prsBatchVO);
            
            if( prsBatchVO != null ){
            	batchId = prsBatchVO.getPrsBatId();
            }
            //SUCCESS일경우 PRI_PRS_BAT의 PRS_BAT_ERR_VAL의 결과를 이용한다.
            if( "4".equals(status) ){
            	//SUCCESS가 아니면 FAIL처리
            	// null도 success로 간주한다.
            	if( prsBatchVO.getPrsBatErrVal() != null 
            			&& prsBatchVO.getPrsBatErrVal().length() != 0
            			&& !"0".equals( prsBatchVO.getPrsBatErrVal() )){//SUCCESS가 아니면 FAIL처리            	
            		status = "90";
            	}
            	 
            }            
            eventResponse.setETCData("JOB_ID",batchId);
            eventResponse.setETCData("BATCH_STATUS",status);

        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
 
	
    /**
     * ESM_PRI_6062 : Save <BR>
     * S/C RATE관련 Cost, CMPB,OPB 값을 갱신하고 그 갱신여부를 Mark해둔다.
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
	private EventResponse modifyPrsCost(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri6062Event event = (EsmPri6062Event) e;
        try {
            begin();
            SCRateQuotationBC command = new SCRateQuotationBCImpl();
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
        EsmPri6062Event event = (EsmPri6062Event) e;
        try {
            begin();
            SCRateQuotationBC command = new SCRateQuotationBCImpl();
            
            SCRateProposalBC commandForCopy = new SCRateProposalBCImpl();
            CalculateBC commandForCalculation = new CalculateBCImpl();
            //command.modifyPrsSimulationCost(event.getRsltPriPrsCostListVOS(),account);
            
            List<RsltPriPrsCostListVO> listRsltPriPrsCostListVO = new ArrayList<RsltPriPrsCostListVO>();
            String newRoutCsNo = null;
            String newRoutCsSrcDt = null;
            RsltPriPrsCostListVO[] rsltPriPrsCostListVOs =event.getRsltPriPrsCostListVOS();
            InPriPrsRoutCsVO inPriPrsRoutCsVO = event.getInPriPrsRoutCsVO();
            rsltPriPrsCostListVOs[0].setIbflag("U");
            rsltPriPrsCostListVOs[0].setUsdRoutCsSelFlg("N");
            rsltPriPrsCostListVOs[0].setUpdUsrId(account.getUsr_id());
            listRsltPriPrsCostListVO.add(rsltPriPrsCostListVOs[0]);
            
            
            //POL(TERM),POD(TERM)의 조합이 정확한지 검사 한다.
            List<RsltPriCostSimulationCheckRouteVO> checkList =  command.searchCostSimulationCheckRoutList( event.getInCostSimulationCheckRouteVO());
            if( checkList.size() == 0 ){
            	//route와 term을 잘 못 입력 하였다.
            	throw new EventException(new ErrorHandler("PRI03021").getMessage());
            }
            
            
            
            //0. PRI_PRS_BAT에서  pgm_no = 'ESM_PRI_T001'인 ROW의
            //  PARA_INFO_CTNT(ROUT_CS_SRC_DT)  , PRS_BAT_ID(ROUT_CS_CLSS_NO)를 SELECT한다.
            RsltRouteCaseCostVersionVO rsltRouteCaseCostVersionVO = commandForCopy.searchRouteCaseCostVersion( ); // <--
                     
            //1. 새로운 Rout_cs_no를 select한다. 
//            RsltNewRoutCaseNoVO rsltNewRoutCaseNoVO  = commandForCopy.searchNewRouteCaseNo(rsltRouteCaseCostVersionVO);
//            newRoutCsNo = rsltNewRoutCaseNoVO.getRoutCsNo();
//            newRoutCsSrcDt = rsltNewRoutCaseNoVO.getRoutCsSrcDt();
            RsltPriPrsRoutCsMaxRoutCsNoVO maxRoutCsVO = commandForCalculation.searchPriPrsRoutCsMaxRoutCsNoCalculate(null);
            newRoutCsNo = maxRoutCsVO.getRoutCsNo();
            newRoutCsSrcDt = rsltRouteCaseCostVersionVO.getParaInfoCtnt();
            log.debug("=====rsltNewRoutCaseNoVO==>"+newRoutCsNo);
            log.debug("=====rsltNewRoutCaseNoVO==>"+newRoutCsSrcDt);
            inPriPrsRoutCsVO.setUpdUsrId(account.getUsr_id());
            
            //2. PRI_PRS_ROUT_CS(BATCH)에 한건을 INSERT한다.(화면에서 입력받은값을 사용.)
            inPriPrsRoutCsVO.setRoutCsNo(newRoutCsNo);
            inPriPrsRoutCsVO.setRoutCsClssNo(rsltRouteCaseCostVersionVO.getPrsBatId()); // <-- rout_cs_clss_no
            commandForCalculation.managePriPrsRouteCase(inPriPrsRoutCsVO, account);
            
            

            //2. Route Case를 New Rout_cs_no를 이용해서 입력한다. (online)
            PriSqRtUsdRoutCsVO routCsVO = event.getPriSqRtUsdRoutCsVO() ;
            routCsVO.setRoutCsNo(newRoutCsNo);
            routCsVO.setRoutCsSrcDt(newRoutCsSrcDt);
            command.managePriRateUsedRouteCase(routCsVO,account);  

            //3. Route를 변경한다. usd_rout_cs_sel_flg ( Y --> N )
            command.modifyPrsRateCommodityRoute(listRsltPriPrsCostListVO); // 
            log.debug("===== ******************************* modifyRateCommodityRoute 종료  ==>" ); 
            
            
            //4. PRI_PRS_USD_ROUT_CS_INFO,PRI_PRS_USD_ROUT_ACT_COST,PRI_PRS_USD_ROUT_ESTM_COST Table에 COA 데이터 카피 Insert  (online)
            log.debug("===== ******************************* copyBatchCostInfoToOnlineCostInfo 실행  ==>" ); 
            inPriPrsRoutCsVO.setUpdUsrId(account.getUsr_id());
			inPriPrsRoutCsVO.setRoutCsNo(newRoutCsNo); 
			inPriPrsRoutCsVO.setRoutCsSrcDt(newRoutCsSrcDt);
			commandForCalculation.copyCoaCostInfoToOnlineCostInfo(inPriPrsRoutCsVO, account);
            log.debug("===== ******************************* copyBatchCostInfoToOnlineCostInfo 종료  ==>" ); 
            
            //5. PRI_PRS_USD_ROUT_CS_INFO,PRI_PRS_USD_ROUT_ACT_COST,PRI_PRS_USD_ROUT_ESTM_COST Table에 Data를 Batch DB에  데이터 카피 Insert  (online -> batch)
            log.debug("===== ******************************* copyBatchCostInfoToOnlineCostInfoBatch 실행  ==>" ); 
            commandForCalculation.copyOnlineCostInfoToBatchCostInfo(inPriPrsRoutCsVO, account);
            log.debug("===== ******************************* copyBatchCostInfoToOnlineCostInfoBatch 종료  ==>" );
            
            
            
            //5. Calculate Batch Logic과 동일한 로직을 돌린다.
            command.modifyCalculateLogicData(listRsltPriPrsCostListVO);// XA Driver를 사용하면 문제가 생길수 있음 (Merge, with 문장)
            log.debug("===== *******************************  후 ==>");
            
          
            
            
            eventResponse.setUserMessage(new ErrorHandler("PRI01072").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }        
    
    //ESM_PRI_6013 S/C Quotation Inquiry start
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_6013 : Retrieve <br>
	 * SC QUOTATION INQUIRY MAIN 정보를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScQuotationReportList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6013Event event = (EsmPri6013Event)e;
		SCQuotationMainBC command = new SCQuotationMainBCImpl();
		
		try{
			List<RsltPriSqMnVO> list = 
				command.searchScQuotationReportList(event.getQutationMainVO().getRsltPriSqMnVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }		
		return eventResponse;
	}
	
	
	//ESM_PRI_6013 S/C Quotation Inquiry end
	//////////////////////////////////////////////////////////////////////////////////
	
	
	//ESM_PRI_6013_01 S/C Quotation Location Group Inquiry start
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_6013_01 : Retrieve <br>
	 * PRI_SQ_GRP_LOC 테이블을 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScGroupLocationQuotationReportList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601301Event event = (EsmPri601301Event)e;
		SCGroupLocationQuotationBC command = new SCGroupLocationQuotationBCImpl();
		
		try{
			List<RsltPriSqGrpLocVO> list = 
				command.searchScGroupLocationQuotationList(event.getGroupLocationQuotationVO().getPriSqGrpLocVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	
	/**
	 * ESM_PRI_6013_01 : Retrieve <br>
	 * PRI_SQ_GRP_LOC_DTL 테이블을 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupLocationDetailReportList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601301Event event = (EsmPri601301Event)e;
		SCGroupLocationQuotationBC command = new SCGroupLocationQuotationBCImpl();
		
		try{
			List<RsltPriSqGrpLocDtlVO> list = 
				command.searchGroupLocationDetailList(event.getGroupLocationQuotationVO().getPriSqGrpLocVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	//ESM_PRI_6013_01S/C Quotation Location Group Inquiry end
	//////////////////////////////////////////////////////////////////////////////////
	
	
	//ESM_PRI_6013_02 S/C Quotation Commodity Group Inquiry start
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_6013_02 : Retrieve <br>
	 * PRI_SQ_GRP_CMDT 테이블을 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScGroupCommodityQuotationReportList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601302Event event = (EsmPri601302Event)e;
		SCGroupCommodityQuotationBC command = new SCGroupCommodityQuotationBCImpl();
		
		try{
			List<RsltPriSqGrpCmdtVO> list = 
				command.searchScGroupCommodityQuotationList(event.getGroupCommodityQuotationVO().getPriSqGrpCmdtVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	
	/**
	 * ESM_PRI_6013_02 : Retrieve <br>
	 * PRI_SQ_GRP_CMDT_DTL 테이블을 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodityDetailReportList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601302Event event = (EsmPri601302Event)e;
		SCGroupCommodityQuotationBC command = new SCGroupCommodityQuotationBCImpl();
		
		try{
			List<RsltPriSqGrpCmdtDtlVO> list = 
				command.searchGroupCommodityDetailList(event.getGroupCommodityQuotationVO().getPriSqGrpCmdtVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	//ESM_PRI_6005_02 S/C Quotation Commodity Group Inquiry end
	//////////////////////////////////////////////////////////////////////////////////
	
	
	//ESM_PRI_6013_03 S/C Quotation Rate Inquiry start
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_6013_03 : Retrieve <br>
	 * PRI_SQ_RT_CMDT_HDR, PRI_SQ_RT_CMDT 을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSCRateQuotationReportList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601303Event event = (EsmPri601303Event)e;
		SCRateQuotationBC command = new SCRateQuotationBCImpl();
		
		try{
			List<RsltPriSqRtCmdtVO> list = 
				command.searchSCRateQuotationList(event.getRateQuotationVO().getPriSqRtCmdtHdrVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }		
		return eventResponse;
	}
	
	
	/**
	 * ESM_PRI_6013_03 : Retrieve <br>
	 * PRI_SQ_RT_CMDT_HDR, PRI_SQ_RT_CMDT 을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCommodityRouteReportList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601303Event event = (EsmPri601303Event)e;
		SCRateQuotationBC command = new SCRateQuotationBCImpl();
		
		try{
			List<RsltPriSqRtCmdtRoutVO> list = 
				command.searchRateCommodityRouteList(event.getRateQuotationVO().getPriSqRtCmdtHdrVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	
	/**
	 * ESM_PRI_6013_03 : Retrieve <br>
	 * PRI_SQ_RT_ROUT_PNT,PRI_SQ_RT_ROUT_VIA,PRI_SQ_RT 을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateReportList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri601303Event event = (EsmPri601303Event)e;
		SCRateQuotationBC command = new SCRateQuotationBCImpl();
		
		//컨테이너 vo
		RateQuotationVO rateQuotationVO = new RateQuotationVO();

		try{
			rateQuotationVO = command.searchRateList(event.getRateQuotationVO().getPriSqRtCmdtRoutVO());
			
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriSqRtCmdtVOList());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriSqRtVOList());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriSqRtRoutOrgPntVOList());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriSqRtRoutOrgViaVOList());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriSqRtRoutDestViaVOList());
			eventResponse.setRsVoList(rateQuotationVO.getRsltPriSqRtRoutDestPntVOList());
			
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	
	//ESM_PRI_6013_03 S/C Quotation Commodity Rate end
	//////////////////////////////////////////////////////////////////////////////////
	
	
	
	/**
	 * ESM_PRI_6005 : OnLoad <br>
     * 로그인 사용자의 SELECT 권한 정보와 REQUEST OFFICE를 조회합니다.<br>
     * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAuthorizationOffice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6005Event event = (EsmPri6005Event)e;
		PRICommonBC command = new PRICommonBCImpl();
		RsltCdListVO authData = null;
		
		try{
			//권한을 조회한다.
			event.getQutationMainVO().getRsltPriAuthorizationVO().setPrcCtrtTpCd("S");
			event.getQutationMainVO().getRsltPriAuthorizationVO().setCreUsrId(account.getUsr_id());
			
			authData = command.searchAuthorizationOffice(event.getQutationMainVO().getRsltPriAuthorizationVO(), account);
			eventResponse.setCustomData("AuthData", authData);
			
			//auth type 리턴
			eventResponse.setETCData("auth_type", authData.getCd());
			log.debug("*********************************************************");
			log.debug("auth_type : " + authData.getCd());
			log.debug("*********************************************************");
			
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}	
	
	//ESM_PRI_6035 S/C Quotation-Rate CMPB View All start
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_6035 : Retrieve <br>
	 * SC Rate CMPB VIEW ALL (ESM_PRI_6074) 리스트를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCmpbViewAllList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri6074Event event = (EsmPri6074Event)e;
		SCRateQuotationBC command = new SCRateQuotationBCImpl();
		
		try{
			List<RsltCmpbViewAllListVO> list = 
				command.searchRateCmpbViewAllList(event.getPriSqRtCmdtHdrVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	//ESM_PRI_6035 S/C Quotation-Rate View All end
	//////////////////////////////////////////////////////////////////////////////////
	
	
	//ESM_PRI_6006 SQ Rate Creation - Excel Import(Horizontal) start
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_6006 : Check <br>
	 * SQ Rate LOAD EXCEL(ESM_PRI_6006) 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkRateExcelHorizontal(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri6006Event event = (EsmPri6006Event) e;
        SCRateQuotationBC command = new SCRateQuotationBCImpl();
        try{
        	List<RsltCdListVO> vos = 
        		command.checkRateExcelHorizontal(event.getPriSqRtCmdtHdrVO(), event.getRsltRtListHorizontalExcelVOS());
        	
        	eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }	
        return eventResponse;
    }
    
    /**
     * ESM_PRI_6006 : Save <br>
     * SQ Rate LOAD EXCEL(ESM_PRI_6006) 화면에 대한 입력 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
	private EventResponse uploadRateExcelHorizontal(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmPri6006Event event = (EsmPri6006Event) e;
    	SCRateQuotationBC command = new SCRateQuotationBCImpl();
      
        try {
            begin();
            command.uploadRateExcelHorizontal(event.getPriSqRtCmdtHdrVO(), event.getRsltRtListHorizontalExcelVOS(),account);
//            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
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
	 * ESM_PRI_6006 : Open<br>
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
			comUpldFileVO.setFileUpldNm("SQ_Rate_Templet_H.xls");
			String fileKey = command.searchExcelTemplateFileKey(comUpldFileVO);
			eventResponse.setCustomData("TEMPLATE_KEY", fileKey);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
    //ESM_PRI_6006 SQ Rate Creation - Excel Import(Horizontal) end
	//////////////////////////////////////////////////////////////////////////////////
    
    
  //ESM_PRI_6007 SQ Rate Creation - Excel Import(Vertical) start
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_6007 : Check <br>
	 * SQ Rate LOAD EXCEL(ESM_PRI_6007) 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkRateExcelVertical(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri6007Event event = (EsmPri6007Event) e;
        SCRateQuotationBC command = new SCRateQuotationBCImpl();
        try {
	        List<RsltCdListVO> vos = command.checkRateExcelVertical(event.getPriSqRtCmdtHdrVO(), event.getRsltRtListVerticalExcelVOS());
	
	        eventResponse.setRsVoList(vos);
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
        return eventResponse;
    }
    
    /**
     * ESM_PRI_6007 : Save <br>
     * SQ Rate LOAD EXCEL(ESM_PRI_6007) 화면에 대한 입력 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
	private EventResponse uploadRateExcelVertical(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmPri6007Event event = (EsmPri6007Event) e;
    	SCRateQuotationBC command = new SCRateQuotationBCImpl();
      
        try {
            begin();
            command.uploadRateExcelVertical(event.getPriSqRtCmdtHdrVO(), event.getRsltRtListVerticalExcelVOS(),account);
//            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
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
	 * ESM_PRI_6007 : Open<br>
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
			comUpldFileVO.setFileUpldNm("SQ_Rate_Templet_V.xls");
			String fileKey = command.searchExcelTemplateFileKey(comUpldFileVO);
			eventResponse.setCustomData("TEMPLATE_KEY", fileKey);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
    //ESM_PRI_6007 SQ Rate Creation - Excel Import(Vertical) end
	//////////////////////////////////////////////////////////////////////////////////
	
	
	
	
    /**
     * ESM_PRI_6088 : Search <br>
     * SC GOH Inquiry List를 조회합니다. <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchSurchargeViewAllList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri6088Event event = (EsmPri6088Event) e;
        SCRateQuotationBC command = new SCRateQuotationBCImpl();

        try {
            List<RsltPriSurchargeViewAllVO> list = command.searchSurchargeViewAllList(event.getPriSqRtCmdtHdrVO());
            List<RsltPriSurchargeLastAccessDateVO> accessList = command.searchSurchargeLastAccessDateList(event.getPriSqRtCmdtHdrVO());
            eventResponse.setRsVoList(list);
            
            String accessDateG = "";
            String accessDateS = "";
            if( accessList.size() > 0 ){
            	for(int i = 0 ; i < accessList.size(); i++){
            		if(accessList.get(i).getGenSpclRtTpCd().equals("G") ){
            			accessDateG =  accessList.get(i).getCreYmd();
            		}else if(accessList.get(i).getGenSpclRtTpCd().equals("S")){
            			accessDateS = accessList.get(i).getCreYmd();
            		}
            	}
            }
            eventResponse.setETCData("access_date_g", accessDateG);
            eventResponse.setETCData("access_date_s", accessDateS);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    
}