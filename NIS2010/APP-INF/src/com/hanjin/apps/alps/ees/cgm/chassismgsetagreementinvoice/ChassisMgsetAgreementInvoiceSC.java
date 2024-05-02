/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetAgreementInvoiceSC.java
*@FileTitle : Agreement Matching
*Open Issues :
*@LastModifyDate : 2014.07.31
*@LastModifier : Chang Young Kim
*@LastVersion : 1.31
* 2009.04.29 김창식
* 1.0 Creation
*Change history : 
* 2014.02.11 Performance by SCC(POOL) 신규화면 추가(EES_CGM_1155), 신용찬 수석
* 2014.05.30 Chang Young Kim_Added In accordance with the "CHM-201430040"
* 2014.07.31 Modified by Chang Young Kim
* 2014.11.19 COPS Co-Op Pool Payable Charge Creation 신규화면 추가(EES_CGM_1223), Modified by Chang Young Kim
* 2015.03.30 [CHM-201534562] 미주샷시 임차료(사용료) 추정 비용 로직 검토 의뢰 (EES_CGM_1107)
* 2015.07.30 [CHM-201536860] 샤시 월별 추정 실적 입력 로직 변경 (EES_CGM_1225) 
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.basic.CgmCodeMgtBC;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.basic.CgmCodeMgtBCImpl;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.ComboINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.ComboMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.MdmOrganizationINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.MdmOrganizationMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.basic.ChassisMgsetAgreementBC;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.basic.ChassisMgsetAgreementBCImpl;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm1020Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm1021Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm1022Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm1026Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm1117Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm1118Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm1202Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm2021Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm2022Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm2023Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm2026Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm2028Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm2103Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSAgreementGroupVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSAgreementINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSAgreementListMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSAgreementMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSCpsAgreementGroupVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSCpsAgreementINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSCpsAgreementMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermChangeResultMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermStatusGroupVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermStatusMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSAgreementGroupVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSAgreementListMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSAgreementMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSTermChangeResultMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSTermStatusGroupVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSTermStatusMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.basic.ChassisMgsetInvoiceBC;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.basic.ChassisMgsetInvoiceBCImpl;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1028Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1029Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1030Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1031Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1034Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1035Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1107Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1123Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1124Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1125Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1126Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1155Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1156Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1203Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1204Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1205Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1207Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1208Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1211Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1220Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1223Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1225Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm2032Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm2035Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm2036Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm2085Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm2086Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm2098Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm2206Event;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration.ChassisMgsetInvoiceDBDAO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSChargeCreationMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCoPoolChargeMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSConfirmPayableAmountINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSConfirmPayableAmountMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSConfirmPayableGRPVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCpsAuditResultUpdateINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCpsAuditResultUpdateMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCpsConfirmPayableGRPVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCpsInvoiceAuditResultCmmtCrMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCpsPayableInvoiceCreationINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCpsPayableInvoiceCreationMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSEstimateExpenseMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceImportAuditMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceInquiryMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSLessorAgmtMatchingMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSNuPoolChargeMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSPayableInvoiceCreationINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSPayableInvoiceCreationMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSPoolSCCReportINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSPoolSCCReportMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSSCNOReportMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSScExceptionINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSChargeCreationMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSConfirmPayableAmountINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSConfirmPayableAmountMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSEstimateExpenseMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSInvoiceImportAuditMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSInvoiceInquiryMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSLessorAgmtMatchingMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSPayableInvoiceCreationINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSPayableInvoiceCreationMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.PoolEstmExpenseMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.basic.ChassisMgsetOnOffhireBC;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.basic.ChassisMgsetOnOffhireBCImpl;
import com.hanjin.bizcommon.csr.csrcommon.csrexternalfinder.basic.CSRExternalFinderBC;
import com.hanjin.bizcommon.csr.csrcommon.csrexternalfinder.basic.CSRExternalFinderBCImpl;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ApPayInvDtlVO;
import com.hanjin.syscommon.common.table.ApPayInvVO;


/**
 * NIS2010-ChassisMgsetAgreementInvoice Business Logic ServiceCommand - NIS2010-ChassisMgsetAgreementInvoice 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author KIM CHANG SIK
 * @see ChassisMgsetInvoiceDBDAO
 * @since J2EE 1.4
 */

public class ChassisMgsetAgreementInvoiceSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ChassisMgsetAgreementInvoice system 업무 시나리오 선행작업<br>
	 * ees_cgm_1028업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * ChassisMgsetAgreementInvoice system 업무 시나리오 마감작업<br>
	 * ees_cgm_1028 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("ChassisMgsetAgreementInvoiceSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-ChassisMgsetAgreementInvoice system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		try
		{
			// RDTO(Data Transfer Object including Parameters)
			EventResponse eventResponse = null;

			// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
			if (e.getEventName().equalsIgnoreCase("EesCgm1020Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSAgreementAllService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.MULTI)){
					eventResponse = modifyCHSAgreementService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)){
					eventResponse = removeCHSAgreementService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1020DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1021Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSAgreementListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1021DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1022Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSAgreementDtlPopupService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1026Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSTermChangeEqListService(e);
				} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchCHSEqMainService(e);
				} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageCHSTermChangeService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
					eventResponse = backEndCHSTermChangeListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
					eventResponse = searchComBackEndJobStatusService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1028Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSLessorAgmtMatchingService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageCHSLessorAgmtMatchingService (e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = checkCHSAgmtService (e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1029Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSChargeCreationListService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchCHSChargeCreationResultService (e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = createCHSChargeService (e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
					eventResponse = removeCHSChargeService (e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1030Event")) {
				if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
					eventResponse = verifyCHSInvoiceDraftService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
					eventResponse = auditCHSInvoiceDraftService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
					eventResponse = verifyCHSInvoiceDraftInsertService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
					eventResponse = verifyCHSInvoiceDraftSearchService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1031Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSInvoiceAuditResultService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
					eventResponse = manageCHSInvoiceAuditResultService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
					eventResponse = confirmCHSPayableAmountService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
					eventResponse = cancelCHSPayableAmountService(e);
				}

			} else if (e.getEventName().equalsIgnoreCase("EesCgm1034Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSInvoiceListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchCHSInvoiceDetailService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
					eventResponse = createCHSInvoiceService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
					eventResponse = cancelCHSInvoiceService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1034DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1035Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSInvoiceInqListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchCHSInvoiceInqDtlService (e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2036Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMGSInvoiceInqListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchMGSInvoiceInqDtlService (e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1117Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSAgreementSelectionListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1117DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1118Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSTermChangeResultSmryService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1118DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1123Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSCoPoolChargeDtlService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageCHSCoPoolChargeService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchCHSCoPoolChargeListService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					eventResponse = searchCHSCoPoolChargeInitService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
					eventResponse = removeCHSCoPoolChargeService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1123DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1124Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSNuPoolChargeDtlService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageCHSNuPoolChargeService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchCHSNuPoolChargeListService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					eventResponse = searchCHSNuPoolChargeInitService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
					eventResponse = removeCHSNuPoolChargeService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1124DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2021Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMGSAgreementAllService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.MULTI)){
					eventResponse = modifyMGSAgreementService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)){
					eventResponse = removeMGSAgreementService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm2021DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2022Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMGSAgreementSelectionListService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm2022DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2023Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMGSAgreementListService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm2023DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2026Event")) {
				if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMGSTermChangeEqListService(e);
				}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchMGSEqMainService(e);
				}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageMGSTermChangeService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2028Event")) {
				if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMGSTermChangeResultSmryService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm2028DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2032Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMGSChargeCreationListService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchMGSChargeCreationResultService (e);
				}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = createMGSChargeService (e);
				}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
					eventResponse = removeMGSChargeService (e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2035Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMGSInvoiceListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchMGSInvoiceDetailService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
					eventResponse = createMGSInvoiceService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
					eventResponse = cancelMGSInvoiceService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm2035DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2085Event")) {
				if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
					eventResponse = verifyMGSInvoiceDraftService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
					eventResponse = auditMGSInvoiceDraftService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
					eventResponse = verifyMGSInvoiceDraftInsertService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
					eventResponse = verifyMGSInvoiceDraftSearchService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2086Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMGSLessorAgmtMatchingService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageMGSLessorAgmtMatchingService (e);
				}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = checkMGSAgmtService (e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2098Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMGSInvoiceAuditResultService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
					eventResponse = manageMGSInvoiceAuditResultService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
					eventResponse = confirmMGSPayableAmountService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
					eventResponse = cancelMGSPayableAmountService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2103Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMGSAgreementDtlPopupService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1125Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchPoolEstimateAmtService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = modifyPoolEstimateAmtService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1126Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchPoolEstimateReportService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1107Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				// search
					eventResponse = searchCHSEstimateExpenseService(e);
				} else if ( e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	// calculate
					eventResponse = searchCHSEstimateExpenseCalcService(e);
				} else if ( e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	// summary
					eventResponse = searchCHSEstimateExpenseSummaryService(e);
				} else if ( e.getFormCommand().isCommand(FormCommand.MULTI)) {		// delete/insert
					eventResponse = manageCHSEstimateExpenseCalcService(e);
				} else if ( e.getFormCommand().isCommand(FormCommand.COMMAND01)) {	// BackendJob Check
					eventResponse = searchComBackEndJobStatusService(e);		
				} else if ( e.getFormCommand().isCommand(FormCommand.COMMAND02)) {	// BackendJob Load
					eventResponse = loadFileBackEndJobResultService(e);		
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2206Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {			// search
					eventResponse = searchMGSEstimateExpenseService(e);
				} else if ( e.getFormCommand().isCommand(FormCommand.SEARCH01)) // calculate
				{
					eventResponse = searchMGSEstimateExpenseCalcService(e);
				} else if ( e.getFormCommand().isCommand(FormCommand.SEARCH02)) // summary
				{
					eventResponse = searchMGSEstimateExpenseSummaryService(e);
				} else if ( e.getFormCommand().isCommand(FormCommand.MULTI)) 	// delete/insert
				{
					eventResponse = manageMGSEstimateExpenseCalcService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1202Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {			// search
					eventResponse = searchCHSCpsAgreementAllService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)){
					eventResponse = checkCHSCpsAgreementYardService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI)){
					eventResponse = modifyCHSCpsAgreementService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)){
					eventResponse = removeCHSCpsAgreementService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1202DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1203Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSCpsChargeCreationListService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchCHSCpsChargeCreationResultService (e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
					eventResponse = removeCHSCpsChargeService (e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1203DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1204Event")) {
				if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
					eventResponse = verifyCHSInvoiceDraftService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
					eventResponse = auditCHSCpsInvoiceService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
					eventResponse = searchComBackEndJobStatusService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = checkCHSInvoiceNoDup(e);
				} 
				else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
					eventResponse = saveCHSCpsInvoiceService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1205Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSCpsInvoiceAuditResultService(e);
				} 
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
					eventResponse = searchCHSCpsInvoiceAuditResultCmmtCrService(e);
				} 
				else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
					eventResponse = manageCHSCpsInvoiceAuditResultService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
					eventResponse = confirmCHSCpsPayableAmountService(e);
				} 
				else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
					eventResponse = manageCHSCpsInvoiceAuditResultCmmtCrService(e);
				} 
				else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
					eventResponse = cancelCHSCpsPayableAmountService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1207Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSCpsInvoiceListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchCHSCpsInvoiceDetailService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
					eventResponse = createCHSCpsInvoiceService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
					eventResponse = cancelCHSCpsInvoiceService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1207DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1208Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSInvoiceInqListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchCHSInvoiceInqDtlService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1208DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1155Event")) {

				if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1155DefaultService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSPoolReportService(e);					
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {	//Period Default
					eventResponse = searchDefaultMonthWeek(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {	//HEAD TITLE
					eventResponse = searchMonthList(e);
				} 
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1156Event")) {

				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSSCNOReportService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {	//Period Default
					eventResponse = searchDefaultMonthWeek(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1220Event")) {

				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSSCExceptionService(e);
				} 
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	//Search SCC 
					eventResponse = searchVerifySccService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	//Search SC NO.
					eventResponse = searchVerifyScNoService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1211Event")) {

				if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {		// Check
					eventResponse = insertAfterCheckAuditResultUpdate(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {	// Update
					eventResponse = updateAuditResultUpdate(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1223Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSCoPoolChargeDtlService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageCHSCoPoolChargeService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchCHSCoPoolChargeListService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					eventResponse = searchCHSCoPoolChargeInitService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
					eventResponse = removeCHSCoPoolChargeService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1123DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1225Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchZPPoolEstimateAmtFromMASService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchZPPoolEstimateAmtService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = modifyZPPoolEstimateAmtService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {	// BackendJob Check
					eventResponse = searchComBackEndJobStatusService(e);		
				} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {	// BackendJob Load
					eventResponse = loadFileBackEndJobResultService(e);		
				}
			} 

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1028] : [Retrieve]<br>
	 * Lessor 와 match 되는 agreement 정보를 조회한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSLessorAgmtMatchingService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1028Event event = (EesCgm1028Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<CHSLessorAgmtMatchingMGTVO> list = command.searchCHSLessorAgmtMatchingBasic(event.getChsLessorAgmtMatchingINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1104] : [Save]<br>
	 * Lessor 와 match 되는 agreement 정보를 저장한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCHSLessorAgmtMatchingService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1028Event event = (EesCgm1028Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		try{
			begin();
			command.manageCHSLessorAgmtMatchingBasic (event.getChsLessorAgmtMatchingINVOS(),account);
//			eventResponse.setUserMessage(new ErrorHandler("CGM00002").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1028] : [Check]<br>
	 * Agreement No 입력 후 Focus Out 시 기존에 등록된 Agreement No. 인지 체크한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCHSAgmtService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1028Event event = (EesCgm1028Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();

		int agmtCnt = 0;
		String vndrSeq = null;
		String vndrLglEngNm = null;

		try {
			CHSLessorAgmtMatchingMGTVO lessorAgmtMatchingMGTVO = command.checkCHSAgmtBasic(event.getChsLessorAgmtMatchingINVO());

			if(lessorAgmtMatchingMGTVO == null){
				agmtCnt = 0;
				vndrSeq = "";
				vndrLglEngNm = "";
			} else {
				agmtCnt = 1;
				vndrSeq = lessorAgmtMatchingMGTVO.getVndrSeq();
				vndrLglEngNm = lessorAgmtMatchingMGTVO.getVndrLglEngNm();
			}

			eventResponse.setETCData("AgmtCnt", String.valueOf(agmtCnt));
			eventResponse.setETCData("vndrSeq", String.valueOf(vndrSeq));
			eventResponse.setETCData("vndrLglEngNm", String.valueOf(vndrLglEngNm));

		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * [EES_CGM_2086] : [Retrieve]<br>
	 * Lessor 와 match 되는 agreement 정보를 조회한다.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSLessorAgmtMatchingService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2086Event event = (EesCgm2086Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<MGSLessorAgmtMatchingMGTVO> list = command.searchMGSLessorAgmtMatchingBasic(event.getMgsLessorAgmtMatchingINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2086] : [Save]<br>
	 * Lessor 와 match 되는 agreement 정보를 저장한다.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMGSLessorAgmtMatchingService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2086Event event = (EesCgm2086Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		try{
			begin();
			command.manageMGSLessorAgmtMatchingBasic (event.getMgsLessorAgmtMatchingINVOS(),account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2086] : [Check]<br>
	 * Agreement No 입력 후 Focus Out 시 기존에 등록된 Agreement No. 인지 체크한다.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkMGSAgmtService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2086Event event = (EesCgm2086Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();

		int agmtCnt = 0;
		String vndrSeq = null;
		String vndrLglEngNm = null;

		try {
			MGSLessorAgmtMatchingMGTVO lessorAgmtMatchingMGTVO = command.checkMGSAgmtBasic(event.getMgsLessorAgmtMatchingINVO());

			if(lessorAgmtMatchingMGTVO == null){
				agmtCnt = 0;
				vndrSeq = "";
				vndrLglEngNm = "";
			} else {
				agmtCnt = 1;
				vndrSeq = lessorAgmtMatchingMGTVO.getVndrSeq();
				vndrLglEngNm = lessorAgmtMatchingMGTVO.getVndrLglEngNm();
			}

			eventResponse.setETCData("AgmtCnt", String.valueOf(agmtCnt));
			eventResponse.setETCData("vndrSeq", String.valueOf(vndrSeq));
			eventResponse.setETCData("vndrLglEngNm", String.valueOf(vndrLglEngNm));

		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * [EES_CGM_1123] : [Retrieve]<br>
	 * 저장된 Co-op Pool Charge 목록을 조회한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSCoPoolChargeListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			StringBuffer comboList = new StringBuffer("");
			
			if ("EesCgm1123Event".equalsIgnoreCase(e.getEventName())) {
				EesCgm1123Event event = (EesCgm1123Event)e;
				
				List<CHSCoPoolChargeMGTVO> list = command.searchCHSCoPoolChargeListBasic(event.getChsCoPoolChargeINVO());
				
				for(int i=0; i<list.size(); i++){
					CHSCoPoolChargeMGTVO chsCoPoolChargeMGTVO = (CHSCoPoolChargeMGTVO)list.get(i);

					comboList.append(chsCoPoolChargeMGTVO.getInvNo() + "|" + chsCoPoolChargeMGTVO.getChssMgstInvStsCd());

					if(i < list.size()-1) comboList.append("@");
				}
			}else if("EesCgm1223Event".equalsIgnoreCase(e.getEventName())){
				EesCgm1223Event event = (EesCgm1223Event)e;
				
				List<CHSCoPoolChargeMGTVO> list = command.searchCHSCoPoolChargeListBasic(event.getChsCoPoolChargeINVO());
				
				for(int i=0; i<list.size(); i++){
					CHSCoPoolChargeMGTVO chsCoPoolChargeMGTVO = (CHSCoPoolChargeMGTVO)list.get(i);

					comboList.append(chsCoPoolChargeMGTVO.getInvNo() + "|" + chsCoPoolChargeMGTVO.getChssMgstInvStsCd());

					if(i < list.size()-1) comboList.append("@");
				}
			}
			
			eventResponse.setETCData("comboList", comboList.toString());

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1123] : [Retrieve]<br>
	 * Co-op Pool Charge 초기 항목을 조회한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSCoPoolChargeInitService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			if ("EesCgm1123Event".equalsIgnoreCase(e.getEventName())) {
				EesCgm1123Event event = (EesCgm1123Event)e;
				
				List<CHSCoPoolChargeMGTVO> list = command.searchCHSCoPoolChargeInitBasic(event.getChsCoPoolChargeINVO());
				eventResponse.setRsVoList(list);
			}else if("EesCgm1223Event".equalsIgnoreCase(e.getEventName())){
				EesCgm1223Event event = (EesCgm1223Event)e;
				
				List<CHSCoPoolChargeMGTVO> list = command.searchCHSCoPoolChargeInitBasic(event.getChsCoPoolChargeINVO());
				eventResponse.setRsVoList(list);
			}

			return eventResponse;
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1123] : [Retrieve]<br>
	 * 저장된 Co-op Pool Charge 상세 내역을 조회한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSCoPoolChargeDtlService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<CHSCoPoolChargeMGTVO> list = null;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			if ("EesCgm1123Event".equalsIgnoreCase(e.getEventName())) {
				EesCgm1123Event event = (EesCgm1123Event)e;
				
				list = command.searchCHSCoPoolChargeDtlBasic(event.getChsCoPoolChargeINVO());
			}else if("EesCgm1223Event".equalsIgnoreCase(e.getEventName())){
				EesCgm1223Event event = (EesCgm1223Event)e;
				
				list = command.searchCHSCoPoolChargeDtlBasic(event.getChsCoPoolChargeINVO());
			}
			
			// 결과 리스트를 목록에 담는다.
			if(list != null){
				eventResponse.setRsVoList(list);
			}
			
			// Form 안의 객체에 값을 맵핑하기 위하여 값을 etcData 로 넘긴다.
			CHSCoPoolChargeMGTVO chsCoPoolChargeMGTVO = new CHSCoPoolChargeMGTVO();
			if(list != null){
				if(list.size() > 0){
					chsCoPoolChargeMGTVO = (CHSCoPoolChargeMGTVO)list.get(0);
				}
			}

			eventResponse.setETCData(chsCoPoolChargeMGTVO.getColumnValues());

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}

	}


	/**
	 * [EES_CGM_1123][EES_CGM_1223] : [Save]<br>
	 * 입력된 Co-op Pool Charge 를 관리한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCHSCoPoolChargeService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		
		try{
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			
			if ("EesCgm1123Event".equalsIgnoreCase(e.getEventName())) {
				EesCgm1123Event event = (EesCgm1123Event)e;
				
				begin();

				// 1. CGM_PAY_INV 의 Invoice No 가 'LS' 또는 'NP'에 존재하는지  체크하여 Exception 처리
				// 2. CP 안에서 다른 Cost Month 에 Invoice No 가 존재하는지 체크하여 Exception 처리
				command.checkCHSInvoiceNoBasic(event.getChsCoPoolChargeINVO().getInvNo(),
							event.getChsCoPoolChargeINVO().getChssMgstInvKndCd(), event.getChsCoPoolChargeINVO().getCostYrmon());

				// 만약  Invoice No 가 'LS' 또는 'NP'에 존재하지 않으면 저장 프로세스 실행.
				CHSCoPoolChargeMGTVO data = command.searchCHSCoPoolChargeMainBasic(event.getChsCoPoolChargeINVO());

				if(data == null){
					// 데이터가 존재하지 않는 자료를 신규로 입력처리
					command.createCHSCoPoolChargeBasic(event.getChsCoPoolChargeINVOS(), event.getChsCoPoolChargeINVO(), account);
				} else {
					// 데이터가 존재하면 수정처리
					command.modifyCHSCoPoolChargeBasic(event.getChsCoPoolChargeINVOS(), event.getChsCoPoolChargeINVO(), account);
				}
				
			}else if("EesCgm1223Event".equalsIgnoreCase(e.getEventName())){
				EesCgm1223Event event = (EesCgm1223Event)e;
				
				begin();

				// 1. CGM_PAY_INV 의 Invoice No 가 'LS' 또는 'NP'에 존재하는지  체크하여 Exception 처리
				// 2. CP 안에서 다른 Cost Month 에 Invoice No 가 존재하는지 체크하여 Exception 처리
				command.checkCHSInvoiceNoBasic(event.getChsCoPoolChargeINVO().getInvNo(),
							event.getChsCoPoolChargeINVO().getChssMgstInvKndCd(), event.getChsCoPoolChargeINVO().getCostYrmon());

				// 만약  Invoice No 가 'LS' 또는 'NP'에 존재하지 않으면 저장 프로세스 실행.
				CHSCoPoolChargeMGTVO data = command.searchCHSCoPoolChargeMainBasic(event.getChsCoPoolChargeINVO());

				if(data == null){
					// 데이터가 존재하지 않는 자료를 신규로 입력처리
					command.createCHSCoPoolChargeBasic(event.getChsCoPoolChargeINVOS(), event.getChsCoPoolChargeINVO(), account);
				} else {
					// 데이터가 존재하면 수정처리
					command.modifyCHSCoPoolChargeBasic(event.getChsCoPoolChargeINVOS(), event.getChsCoPoolChargeINVO(), account);
				}
			}
		
			commit();

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1123] : [Delete]<br>
	 * 기저장된 Co-op Pool Charge 정보를 삭제한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeCHSCoPoolChargeService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			
			if ("EesCgm1123Event".equalsIgnoreCase(e.getEventName())) {
				EesCgm1123Event event = (EesCgm1123Event)e;
				
				begin();
				command.removeCHSCoPoolChargeBasic(event.getChsCoPoolChargeINVO(), account);
				
			}else if("EesCgm1223Event".equalsIgnoreCase(e.getEventName())){
				EesCgm1223Event event = (EesCgm1223Event)e;
				
				begin();
				command.removeCHSCoPoolChargeBasic(event.getChsCoPoolChargeINVO(), account);
			}
			
			commit();

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1021] : [Retrieve]<br>
	 * 현재까지 저장되어 있는 Chassis의 장비 임대 계약 Agreement list 를 조회한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSAgreementListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1021Event event = (EesCgm1021Event)e;
			ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
			List<CHSAgreementListMGTVO> list = command.searchCHSAgreementListBasic(event.getChsAgreementListINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2023] : [Retrieve]<br>
	 * 현재까지 저장되어 있는 M.G.Set의 장비 임대 계약 Agreement list 를 조회한다.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSAgreementListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2023Event event = (EesCgm2023Event)e;
			ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
			List<MGSAgreementListMGTVO> list = command.searchMGSAgreementListBasic(event.getMgsAgreementListINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1117] : [Retrieve]<br>
	 * 기존에 저장된 Chassis 장비 임차 계약의 기본정보를 조회한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSAgreementSelectionListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1117Event event = (EesCgm1117Event)e;
			ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
			List<CHSAgreementListMGTVO> list = command.searchCHSAgreementSelectionListBasic(event.getChsAgreementListINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}

	}

	/**
	 * [EES_CGM_2022] : [Retrieve]<br>
	 * 기존에 저장된 M.G.Set 장비 임차 계약의 기본정보를 조회한다.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSAgreementSelectionListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2022Event event = (EesCgm2022Event)e;
			ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
			List<MGSAgreementListMGTVO> list = command.searchMGSAgreementSelectionListBasic(event.getMgsAgreementListINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1020] : [Retrieve]<br>
	 * agreement 기본정보 및 rate, remark 등의 모든 정보를 조회한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSAgreementAllService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1020Event event = (EesCgm1020Event)e;
			ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			// Response
			CHSAgreementGroupVO list = command.searchCHSAgreementAllBasic(event.getChsAgreementINVO());

			eventResponse.setETCData((Map<String,String>)list.getEtcData());
			eventResponse.setRsVoList((List<CHSAgreementMGTVO>)list.getChsagreementmgtvo());
			eventResponse.setRsVoList((List<CHSAgreementMGTVO>)list.getChsagreementmgtvo2());
			eventResponse.setRsVoList((List<CHSAgreementMGTVO>)list.getChsagreementmgtvo3());
			eventResponse.setRsVoList((List<CHSAgreementMGTVO>)list.getChsagreementmgtvo4());

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1022] : [Retrieve]<br>
	 * agreement 기본정보 및 rate, remark 등의 모든 정보를 Popup형태로 조회한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSAgreementDtlPopupService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1022Event event = (EesCgm1022Event)e;
			ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			// Response
			CHSAgreementGroupVO list = command.searchCHSAgreementAllBasic(event.getChsAgreementINVO());

			eventResponse.setETCData((Map<String,String>)list.getEtcData());
			eventResponse.setRsVoList((List<CHSAgreementMGTVO>)list.getChsagreementmgtvo());
			eventResponse.setRsVoList((List<CHSAgreementMGTVO>)list.getChsagreementmgtvo2());
			eventResponse.setRsVoList((List<CHSAgreementMGTVO>)list.getChsagreementmgtvo3());
			eventResponse.setRsVoList((List<CHSAgreementMGTVO>)list.getChsagreementmgtvo4());

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1020] : [Save] <br>
	 * 화면에서 입력된 내용대로 최초 Agreement 생성.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyCHSAgreementService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1020Event event = (EesCgm1020Event)e;
		ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
		try{
			List<CHSAgreementINVO[]> voList = new ArrayList<CHSAgreementINVO[]>();
			voList.add(event.getChsAgreementINVOS1());
			voList.add(event.getChsAgreementINVOS2());
			voList.add(event.getChsAgreementINVOS3());
			voList.add(event.getChsAgreementINVOS4());
			voList.add(event.getChsAgreementINVOS5());

			begin();
			CHSAgreementMGTVO chsAgreementMGTVO = command.modifyCHSAgreementBasic (voList, event.getChsAgreementINVO() ,account);

			// ETC DATA 설정
			eventResponse.setETCData((Map<String,String>)chsAgreementMGTVO.getColumnValues());

			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1020] : [Delete] <br>
	 * 선택된 Agreement 를 삭제 처리 한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeCHSAgreementService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1020Event event = (EesCgm1020Event)e;
		ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
		try{
			begin();
			command.removeCHSAgreementBasic (event.getChsAgreementINVO() ,account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2021] : [Retrieve]<br>
	 * agreement 기본정보 및 rate, remark 등의 모든 정보를 조회한다.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSAgreementAllService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2021Event event = (EesCgm2021Event)e;
			ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			// Response
			MGSAgreementGroupVO list = command.searchMGSAgreementAllBasic(event.getMgsAgreementINVO());

			eventResponse.setETCData((Map<String,String>)list.getEtcData());
			eventResponse.setRsVoList((List<MGSAgreementMGTVO>)list.getMgsagreementmgtvo());

	//		for(int i=0; i < agmtInfo.size(); i++){
	//
	//			if(i==0){
	//				// Agreement No 최신버전에 해당하는 정보취득 - ETC DATA 설정
	//				eventResponse.setETCData((Map<String,String>)agmtInfo.get(i));
	//			} else {
	//				// Agreement No 별 부가정보 및 버전 List 정보 - Vo List
	//				eventResponse.setRsVoList((List<MGSAgreementMGTVO>)agmtInfo.get(i));
	//			}
	//		}

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2103] : [Retrieve]<br>
	 * agreement 기본정보 및 rate, remark 등의 모든 정보를 Popup형태로 조회한다.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSAgreementDtlPopupService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2103Event event = (EesCgm2103Event)e;
			ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			MGSAgreementGroupVO list = command.searchMGSAgreementAllBasic(event.getMgsAgreementINVO());

			eventResponse.setETCData((Map<String,String>)list.getEtcData());
			eventResponse.setRsVoList((List<MGSAgreementMGTVO>)list.getMgsagreementmgtvo());

	//		for(int i=0; i < agmtInfo.size(); i++){
	//
	//			if(i==0){
	//				// Agreement No 최신버전에 해당하는 정보취득 - ETC DATA 설정
	//				eventResponse.setETCData((Map<String,String>)agmtInfo.get(i));
	//			} else {
	//				// Agreement No 별 부가정보 및 버전 List 정보 - Vo List
	//				eventResponse.setRsVoList((List<MGSAgreementMGTVO>)agmtInfo.get(i));
	//			}
	//		}

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2021] : [Save] <br>
	 * 화면에서 입력된 내용대로 최초 Agreement 생성.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyMGSAgreementService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2021Event event = (EesCgm2021Event)e;
		ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
		try{
			begin();
			MGSAgreementMGTVO mgsAgreementMGTVO = command.modifyMGSAgreementBasic (event.getMgsAgreementINVO() ,account);
			// ETC DATA 설정
			eventResponse.setETCData((Map<String,String>)mgsAgreementMGTVO.getColumnValues());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2021] : [Delete] <br>
	 * 선택된 Agreement 를 삭제 처리 한다.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeMGSAgreementService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2021Event event = (EesCgm2021Event)e;
		ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
		try{
			begin();
			command.removeMGSAgreementBasic (event.getMgsAgreementINVO() ,account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1026] : [Retrieve]<br>
	 * 선택된 Agreement 에 해당하는 Term change 대상이 될  Equipment list 를 조회한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSTermChangeEqListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1026Event event = (EesCgm1026Event)e;
			ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
			List<CHSTermStatusMGTVO> list = command.searchCHSTermChangeEqListBasic(event.getChsTermStatusINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1026] : [Retrieve]<br>
	 * Chassis 장비의 마스터 정보를 조회한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSEqMainService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1026Event event = (EesCgm1026Event)e;
			ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			// Response
			CHSTermStatusGroupVO list = command.searchCHSEqMainBasic(event.getChsTermStatusINVO());

			eventResponse.setRsVoList((List<CHSTermStatusMGTVO>)list.getChstermstatusmgtvos());
			eventResponse.setETCData((Map<String,String>)list.getChstermstatusmgtvo().getColumnValues());

	//		for(int i=0; i<responseData.size(); i++){
	//			if(i == 0)
	//				// VO Data 설정 ==> 데이터가 존재하는지 알기 위해
	//				eventResponse.setRsVoList((List<CHSTermStatusMGTVO>)responseData.get(i));
	//			else
	//				// ETC DATA 설정
	//				eventResponse.setETCData((Map<String,String>)((CHSTermStatusMGTVO)responseData.get(i)).getColumnValues());
	//		}
	//
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1026] : [Save]<br>
	 * 선택된 Agreement 에 대해 Term Change  수행.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCHSTermChangeService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1026Event event = (EesCgm1026Event)e;
		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
		try
		{
			begin();
			command.manageCHSTermChangeBasic (event.getChsTermStatusINVOS(), event.getChsTermStatusINVO() ,account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2026] : [Retrieve]<br>
	 * 선택된 Agreement 에 해당하는 Term change 대상이 될  Equipment list 를 조회한다.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSTermChangeEqListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2026Event event = (EesCgm2026Event)e;
			ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
			List<MGSTermStatusMGTVO> list = command.searchMGSTermChangeEqListBasic(event.getMgsTermStatusINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2026] : [Retrieve]<br>
	 * M.G.Set 장비의 마스터 정보를 조회한다.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSEqMainService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2026Event event = (EesCgm2026Event)e;
			ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			// Response
			MGSTermStatusGroupVO list = command.searchMGSEqMainBasic(event.getMgsTermStatusINVO());

			eventResponse.setRsVoList((List<MGSTermStatusMGTVO>)list.getMgstermstatusmgtvos());
			eventResponse.setETCData((Map<String,String>)list.getMgstermstatusmgtvo().getColumnValues());

	//		for(int i=0; i<responseData.size(); i++){
	//			if(i == 0)
	//				// VO Data 설정 ==> 데이터가 존재하는지 알기 위해
	//				eventResponse.setRsVoList((List<MGSTermStatusMGTVO>)responseData.get(i));
	//			else
	//				// ETC DATA 설정
	//				eventResponse.setETCData((Map<String,String>)((MGSTermStatusMGTVO)responseData.get(i)).getColumnValues());
	//		}
	//
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2026] : [Save]<br>
	 * 선택된 Agreement 에 대해 Term Change  수행.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMGSTermChangeService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2026Event event = (EesCgm2026Event)e;
		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
		try{
			begin();
			command.manageMGSTermChangeBasic (event.getMgsTermStatusINVOS(), event.getMgsTermStatusINVO() ,account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1118] : [Retrieve]<br>
	 * 조회조건에 해당하는 Office, Lessor, Old Agreement, New Agreement 별로 <br>
	 * Chassis Type/Size별 Term Change 수량 및 합을 Display 한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSTermChangeResultSmryService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1118Event event = (EesCgm1118Event)e;
			ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
			List<CHSTermChangeResultMGTVO> list = command.searchCHSTermChangeResultSmryBasic(event.getChsTermChangeResultINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2028] : [Retrieve]<br>
	 * 조회조건에 해당하는 Office, Lessor, Old Agreement, New Agreement 별로 <br>
	 * M.G.Set Type/Size별 Term Change 수량 및 합을 Display 한다.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSTermChangeResultSmryService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2028Event event = (EesCgm2028Event)e;
			ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
			List<MGSTermChangeResultMGTVO> list = command.searchMGSTermChangeResultSmryBasic(event.getMgsTermChangeResultINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1029] : [Retrieve]<br>
	 * 해당월의 Charge 생성 리스트를 조회한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSChargeCreationListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1029Event event = (EesCgm1029Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<CHSChargeCreationMGTVO> list = command.searchCHSChargeCreationListBasic(event.getChsChargeCreationINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1029] : [Retrieve]<br>
	 * Charge Creation 한 결과값을 조회한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSChargeCreationResultService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1029Event event = (EesCgm1029Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<CHSChargeCreationMGTVO> list = command.searchCHSChargeCreationResultBasic(event.getChsChargeCreationINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1029] : [Charge Creation]<br>
	 * 선택된 Agreement 에 대해, 해당 월의 Charge 를 생성한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createCHSChargeService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1029Event event = (EesCgm1029Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		try{
			begin();

			command.createCHSChargeBasic(event.getChsChargeCreationINVOS(), event.getChsChargeCreationINVO(), account);
			List<CHSChargeCreationMGTVO> chargeList = command.searchCHSChargeCreationListBasic(event.getChsChargeCreationINVO());
			List<CHSChargeCreationMGTVO> resultList = command.searchCHSChargeCreationResultBasic(event.getChsChargeCreationINVO());

			eventResponse.setRsVoList(chargeList);
			eventResponse.setRsVoList(resultList);

			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1029] : [Delete]<br>
	 * 선택된 Charge 를 삭제한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeCHSChargeService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1029Event event = (EesCgm1029Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		try{
			begin();
			command.removeCHSChargeBasic(event.getChsChargeCreationINVOS(), event.getChsChargeCreationINVO(), account);
			List<CHSChargeCreationMGTVO> list = command.searchCHSChargeCreationListBasic(event.getChsChargeCreationINVO());
			eventResponse.setRsVoList(list);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2032] : [Retrieve]<br>
	 * 해당월의 Charge 생성 리스트를 조회한다.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSChargeCreationListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2032Event event = (EesCgm2032Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<MGSChargeCreationMGTVO> list = command.searchMGSChargeCreationListBasic(event.getMgsChargeCreationINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2032] : [Retrieve]<br>
	 * Charge Creation 한 결과값을 조회한다.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSChargeCreationResultService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2032Event event = (EesCgm2032Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<MGSChargeCreationMGTVO> list = command.searchMGSChargeCreationResultBasic(event.getMgsChargeCreationINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2032] : [Charge Creation]<br>
	 * 선택된 Agreement 에 대해, 해당 월의 Charge 를 생성한다.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createMGSChargeService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2032Event event = (EesCgm2032Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		try{
			begin();

			command.createMGSChargeBasic(event.getMgsChargeCreationINVOS(), event.getMgsChargeCreationINVO(), account);
			List<MGSChargeCreationMGTVO> chargeList = command.searchMGSChargeCreationListBasic(event.getMgsChargeCreationINVO());
			List<MGSChargeCreationMGTVO> resultList = command.searchMGSChargeCreationResultBasic(event.getMgsChargeCreationINVO());

			eventResponse.setRsVoList(chargeList);
			eventResponse.setRsVoList(resultList);

			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2032] : [Delete]<br>
	 * 선택된 Charge 를 삭제한다.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeMGSChargeService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2032Event event = (EesCgm2032Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		try{
			begin();
			command.removeMGSChargeBasic(event.getMgsChargeCreationINVOS(), event.getMgsChargeCreationINVO(), account);
			List<MGSChargeCreationMGTVO> list = command.searchMGSChargeCreationListBasic(event.getMgsChargeCreationINVO());
			eventResponse.setRsVoList(list);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1125] : [Retrieve] <br>
	 *  저장된 Pool Estimate Amount 를 조회한다. Retrieve <br>주1)
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPoolEstimateAmtService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1125Event event = (EesCgm1125Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<PoolEstmExpenseMGTVO> list = command.searchPoolEstimateAmtBasic(event.getPoolEstmExpenseINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1125] : [Save] <br>
	 *  저장된 Pool Estimate Amount 를 조회한다. Save <br>주1)
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyPoolEstimateAmtService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1125Event event = (EesCgm1125Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		try{
			begin();

			command.modifyPoolEstimateAmtBasic(event.getPoolEstmExpenseMGTVOs(),account);
//			eventResponse.setUserMessage(new ErrorHandler("CGM00002").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1126] : [Retrieve] <br>
	 * 입력된 년도, Pool TYPE 에 해당하는 Pool List 별, 월별 Estimate amount 를 조회하였다. Retrieve <br>주1)
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPoolEstimateReportService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1126Event event = (EesCgm1126Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<PoolEstmExpenseMGTVO> list = command.searchPoolEstimateReportBasic(event.getPoolEstmExpenseINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1030] : [Verify]<br>
	 * 화면에 LOAD 된 Invoice draft 데이터를 EQ 단위로 Verify 수행.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyCHSInvoiceDraftService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCgm1030Event event = (EesCgm1030Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			List<CHSInvoiceImportAuditMGTVO> list = command.verifyCHSInvoiceDraftBasic(event.getChsInvoiceImportAuditINVOS(), event.getChsInvoiceImportAuditINVO(),account);
			eventResponse.setRsVoList(list);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1030] : [Verify]<br>
	 * 화면에 LOAD 된 Invoice draft 데이터를 EQ 단위로 Verify Insert 수행.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyCHSInvoiceDraftInsertService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCgm1030Event event = (EesCgm1030Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			command.verifyCHSInvoiceDraftInsertBasic(event.getChsInvoiceImportAuditINVOS(), event.getChsInvoiceImportAuditINVO(),account);
			commit();
			eventResponse.setETCData("ins_result", "SUCCESS");
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1030] : [Verify]<br>
	 * 화면에 LOAD 된 Invoice draft 데이터를 EQ 단위로 Verify Search수행.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyCHSInvoiceDraftSearchService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCgm1030Event event = (EesCgm1030Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<CHSInvoiceImportAuditMGTVO> list = command.verifyCHSInvoiceDraftSearchBasic(event.getChsInvoiceImportAuditINVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2085] : [Verify]<br>
	 * 화면에 LOAD 된 Invoice draft 데이터를 EQ 단위로 Verify Insert 수행.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyMGSInvoiceDraftInsertService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCgm2085Event event = (EesCgm2085Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			command.verifyMGSInvoiceDraftInsertBasic(event.getMgsInvoiceImportAuditINVOS(), event.getMgsInvoiceImportAuditINVO(),account);
			commit();
			eventResponse.setETCData("ins_result", "SUCCESS");
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2085] : [Verify]<br>
	 * 화면에 LOAD 된 Invoice draft 데이터를 EQ 단위로 Verify Search수행.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyMGSInvoiceDraftSearchService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCgm2085Event event = (EesCgm2085Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<MGSInvoiceImportAuditMGTVO> list = command.verifyMGSInvoiceDraftSearchBasic(event.getMgsInvoiceImportAuditINVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1030] : [Save]<br>
	 * Invoice import 화면에서 로드된 invoice draft 를 Audit 하고 저장한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse auditCHSInvoiceDraftService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1030Event event = (EesCgm1030Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		try{
			begin();
			command.auditCHSInvoiceDraftBasic(event.getChsInvoiceImportAuditINVOS(), event.getChsInvoiceImportAuditINVO(), account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2085] : [Verify]<br>
	 * 화면에 LOAD 된 Invoice draft 데이터를 EQ 단위로 Verify 수행.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyMGSInvoiceDraftService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCgm2085Event event = (EesCgm2085Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			List<MGSInvoiceImportAuditMGTVO> list = command.verifyMGSInvoiceDraftBasic(event.getMgsInvoiceImportAuditINVOS(), event.getMgsInvoiceImportAuditINVO(),account);
			eventResponse.setRsVoList(list);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}


		return eventResponse;
	}

	/**
	 * [EES_CGM_2085] : [Save]<br>
	 * Invoice import 화면에서 로드된 invoice draft 를 Audit 하고 저장한다.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse auditMGSInvoiceDraftService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2085Event event = (EesCgm2085Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		try{
			begin();
			command.auditMGSInvoiceDraftBasic(event.getMgsInvoiceImportAuditINVOS(), event.getMgsInvoiceImportAuditINVO(), account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1031] : [Retrieve]<br>
	 * Lease payable amount confirm 화면에서 화면 open 시 선택된 Agreement Audit result 를 조회한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSInvoiceAuditResultService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1031Event event = (EesCgm1031Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CHSConfirmPayableGRPVO resultVO = command.searchCHSInvoiceAuditResultBasic(event.getChsConfirmPayableAmountINVO());
			List<List<CHSConfirmPayableAmountMGTVO>> list = resultVO.getcHSConfirmPayableAmountMGTVOs();

			for(int i=0; i<list.size(); i++){
				eventResponse.setRsVoList((List<CHSConfirmPayableAmountMGTVO>)list.get(i));
			}
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1031] : [Save]<br>
	 * Eq 별 Invoice Audit result 상태를 저장한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCHSInvoiceAuditResultService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1031Event event = (EesCgm1031Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		try{
			begin();

			List<CHSConfirmPayableAmountINVO[]> voList = new ArrayList<CHSConfirmPayableAmountINVO[]>();

			voList.add(event.getChsConfirmPayableAmountINVOS1());
			voList.add(event.getChsConfirmPayableAmountINVOS2());
			voList.add(event.getChsConfirmPayableAmountINVOS3());

			List<CHSConfirmPayableAmountMGTVO> list = command.manageCHSInvoiceAuditResultBasic(voList,event.getChsConfirmPayableAmountINVO(), account);

			// Invoice Only의 경우 list 를 조회한다.
			if(event.getChsConfirmPayableAmountINVOS3() != null){
				eventResponse.setRsVoList(list);
			}

			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1031] : [Payable Amount Confirm]<br>
	 * 화면의 Payable Amount 대로 비용 확정(confirm) 처리한다.(Chassis) <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmCHSPayableAmountService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1031Event event = (EesCgm1031Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		try{
			begin();
			command.confirmCHSPayableAmountBasic(event.getChsConfirmPayableAmountINVOS(), event.getChsConfirmPayableAmountINVO(), account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1031] : [Payable Amount Confirm]<br>
	 * 화면의 Payable Amount 대로 비용 확정 취소(cancel) 처리한다.(Chassis) <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelCHSPayableAmountService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1031Event event = (EesCgm1031Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		try{
			begin();
			command.cancelCHSPayableAmountBasic(event.getChsConfirmPayableAmountINVO(), account);

			CHSConfirmPayableGRPVO resultVO = command.searchCHSInvoiceAuditResultBasic(event.getChsConfirmPayableAmountINVO());
			List<List<CHSConfirmPayableAmountMGTVO>> list = resultVO.getcHSConfirmPayableAmountMGTVOs();

			for(int i=0; i<list.size(); i++){
				eventResponse.setRsVoList((List<CHSConfirmPayableAmountMGTVO>)list.get(i));
			}
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2098] : [Retrieve]<br>
	 * Lease payable amount confirm 화면에서 화면 open 시 선택된 Agreement Audit result 를 조회한다.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSInvoiceAuditResultService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2098Event event = (EesCgm2098Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CHSConfirmPayableGRPVO resultVO = command.searchMGSInvoiceAuditResultBasic(event.getMgsConfirmPayableAmountINVO());
			List<List<MGSConfirmPayableAmountMGTVO>> list = resultVO.getmGSConfirmPayableAmountMGTVOs();

			for(int i=0; i<list.size(); i++){
				eventResponse.setRsVoList((List<MGSConfirmPayableAmountMGTVO>)list.get(i));
			}
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2098] : [Save]<br>
	 * Eq 별 Invoice Audit result 상태를 저장한다.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMGSInvoiceAuditResultService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2098Event event = (EesCgm2098Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		try{
			begin();

			List<MGSConfirmPayableAmountINVO[]> voList = new ArrayList<MGSConfirmPayableAmountINVO[]>();

			voList.add(event.getMgsConfirmPayableAmountINVOS1());
			voList.add(event.getMgsConfirmPayableAmountINVOS2());
			voList.add(event.getMgsConfirmPayableAmountINVOS3());

			List<MGSConfirmPayableAmountMGTVO> list = command.manageMGSInvoiceAuditResultBasic(voList,event.getMgsConfirmPayableAmountINVO(), account);

			// Invoice Only의 경우 list 를 조회한다.
			if(event.getMgsConfirmPayableAmountINVOS3() != null){
				eventResponse.setRsVoList(list);
			}

			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2098] : [Payable Amount Confirm]<br>
	 * 화면의 Payable Amount 대로 비용 확정(confirm) 처리한다.(M.G.Set) <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmMGSPayableAmountService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2098Event event = (EesCgm2098Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		try{
			begin();
			command.confirmMGSPayableAmountBasic(event.getMgsConfirmPayableAmountINVOS(), event.getMgsConfirmPayableAmountINVO(), account);
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2098] : [Payable Amount Confirm]<br>
	 * 화면의 Payable Amount 대로 비용 확정 취소(cancel) 처리한다.(M.G.Set) <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelMGSPayableAmountService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2098Event event = (EesCgm2098Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		try{
			begin();
			command.cancelMGSPayableAmountBasic(event.getMgsConfirmPayableAmountINVO(), account);
			CHSConfirmPayableGRPVO resultVO = command.searchMGSInvoiceAuditResultBasic(event.getMgsConfirmPayableAmountINVO());

			List<List<MGSConfirmPayableAmountMGTVO>> list = resultVO.getmGSConfirmPayableAmountMGTVOs();

			for(int i=0; i<list.size(); i++){
				eventResponse.setRsVoList((List<MGSConfirmPayableAmountMGTVO>)list.get(i));
			}
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1124] : [Retrieve]<br>
	 * 저장된 Neutral Pool Charge 목록을 조회한다<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSNuPoolChargeListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1124Event event = (EesCgm1124Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<CHSNuPoolChargeMGTVO> list = command.searchCHSNuPoolChargeListBasic(event.getChsNuPoolChargeINVO());

			StringBuffer comboList = new StringBuffer("");
			for(int i=0; i<list.size(); i++){
				CHSNuPoolChargeMGTVO chsNuPoolChargeMGTVO = (CHSNuPoolChargeMGTVO)list.get(i);

				comboList.append(chsNuPoolChargeMGTVO.getInvNo() + "|" + chsNuPoolChargeMGTVO.getChssMgstInvStsCd());

				if(i < list.size()-1) comboList.append("@");
			}

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("comboList", comboList.toString());

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1124] : [Retrieve]<br>
	 * Neutral Pool Charge 초기 항목을 조회한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSNuPoolChargeInitService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1124Event event = (EesCgm1124Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<CHSNuPoolChargeMGTVO> list = command.searchCHSNuPoolChargeInitBasic(event.getChsNuPoolChargeINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1124] : [Retrieve]<br>
	 * 저장된 Neutral Pool Charge 상세 내역을 조회한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSNuPoolChargeDtlService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1124Event event = (EesCgm1124Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();

			List<CHSNuPoolChargeMGTVO> list = command.searchCHSNuPoolChargeDtlBasic(event.getChsNuPoolChargeINVO());

			CHSNuPoolChargeMGTVO chsNuPoolChargeMGTVO = new CHSNuPoolChargeMGTVO();
			if(list.size() > 0){

				chsNuPoolChargeMGTVO = (CHSNuPoolChargeMGTVO)list.get(0);
			}

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// 결과 리스트를 목록에 담는다.
			eventResponse.setRsVoList(list);

			// Form 안의 객체에 값을 맵핑하기 위하여 값을 etcData 로 넘긴다.
			eventResponse.setETCData(chsNuPoolChargeMGTVO.getColumnValues());

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}


	/**
	 * [EES_CGM_1124] : [Save]<br>
	 * 입력된 Neutral Pool Charge 를 관리한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCHSNuPoolChargeService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EesCgm1124Event event = (EesCgm1124Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();

		try{
			begin();

			// 1. CGM_PAY_INV 의 Invoice No 가 'LS' 또는 'CP'에 존재하는지  체크하여 Exception 처리
			// 2. NP 안에서 다른 Cost Month 에 Invoice No 가 존재하는지 체크하여 Exception 처리
			command.checkCHSInvoiceNoBasic(event.getChsNuPoolChargeINVO().getInvNo(),
						event.getChsNuPoolChargeINVO().getChssMgstInvKndCd(), event.getChsNuPoolChargeINVO().getCostYrmon());

			// 만약  Invoice No 가 'LS' 또는 'NP'에 존재하지 않으면 저장 프로세스 실행.
			CHSNuPoolChargeMGTVO data = command.searchCHSNuPoolChargeMainBasic(event.getChsNuPoolChargeINVO());

			if(data == null){
				// 데이터가 존재하지 않는 자료를 신규로 입력처리
				command.createCHSNuPoolChargeBasic(event.getChsNuPoolChargeINVOS(), event.getChsNuPoolChargeINVO(), account);
			} else {
				// 데이터가 존재하면 수정처리
				command.modifyCHSNuPoolChargeBasic(event.getChsNuPoolChargeINVOS(), event.getChsNuPoolChargeINVO(), account);
			}

			commit();

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1124] : [Delete]<br>
	 * 기저장된 Neutral Pool Charge 정보를 삭제한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeCHSNuPoolChargeService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EesCgm1124Event event = (EesCgm1124Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();

		try{
			begin();
			command.removeCHSNuPoolChargeBasic(event.getChsNuPoolChargeINVO(), account);
			commit();

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1034] : [Retrieve]<br>
	 * Invoice List 를 조회한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSInvoiceListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1034Event event = (EesCgm1034Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<CHSPayableInvoiceCreationMGTVO> list = command.searchCHSInvoiceListBasic(event.getChsPayableInvoiceCreationINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1034] : [Grid(dclick)]<br>
	 * 선택된 Invoice 에 속한 Detail 건들을 조회한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSInvoiceDetailService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1034Event event = (EesCgm1034Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<CHSPayableInvoiceCreationMGTVO> list = command.searchCHSInvoiceDetailBasic(event.getChsPayableInvoiceCreationINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1034] : [Invoice Confirm]<br>
	 * Invoice Creation 화면에서 입력된 제반 사항(Issue date, effective date, receive date, revenue VVD 등) <br>
	 * 내용으로 Invoice 를 생성한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createCHSInvoiceService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EesCgm1034Event event = (EesCgm1034Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		CSRExternalFinderBC command2 = new CSRExternalFinderBCImpl();

		try{
			begin();

			// CSR 처리
			CHSPayableInvoiceCreationINVO[] chsPayableInvoiceCreationINVOS = event.getChsPayableInvoiceCreationINVOS();

			for(int i=0; i<chsPayableInvoiceCreationINVOS.length; i++){

				CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO = event.getChsPayableInvoiceCreationINVO();

				// 파라메터 값 설정
				if(!chsPayableInvoiceCreationINVOS[i].getInvTaxCltTpCd().equals("")){
					chsPayableInvoiceCreationINVO.setInvTaxCltTpCd(chsPayableInvoiceCreationINVOS[i].getInvTaxCltTpCd());
				} else {
					chsPayableInvoiceCreationINVO.setInvTaxCltTpCd("0");
				}

				if(!chsPayableInvoiceCreationINVOS[i].getInvTaxRt().equals("")){
					chsPayableInvoiceCreationINVO.setInvTaxRt(chsPayableInvoiceCreationINVOS[i].getInvTaxRt());
				} else {
					chsPayableInvoiceCreationINVO.setInvTaxRt("0");
				}

				if(!chsPayableInvoiceCreationINVOS[i].getChgSmryAmt().equals("")){
					chsPayableInvoiceCreationINVO.setChgSmryAmt(chsPayableInvoiceCreationINVOS[i].getChgSmryAmt());
				} else {
					chsPayableInvoiceCreationINVO.setChgSmryAmt("0");
				}

				chsPayableInvoiceCreationINVO.setPayInvSeq(chsPayableInvoiceCreationINVOS[i].getPayInvSeq());
				chsPayableInvoiceCreationINVO.setChssMgstInvKndCd(chsPayableInvoiceCreationINVOS[i].getChssMgstInvKndCd());

				// AP_INV_MAIN 설정
				ApPayInvVO apPayInvVO = command.searchCHSInvoiceCreateMainBasic(chsPayableInvoiceCreationINVO, account);

				// AP_INV_DTL 설정
				ApPayInvDtlVO[] apPayInvDtlVOs = command.searchCHSInvoiceCreateDetailBasic(chsPayableInvoiceCreationINVO, account);

				// CSR 메소드 실행
				String  invRgstNo = command2.createApPayInvInfo(apPayInvVO, apPayInvDtlVOs, account);

				// CSR 에 받은 INV_RGST_NO 값을 설정
				chsPayableInvoiceCreationINVOS[i].setInvRgstNo(invRgstNo);

			}

			// 내부모듈
			command.createCHSInvoiceBasic(chsPayableInvoiceCreationINVOS, event.getChsPayableInvoiceCreationINVO(), account);
			List<CHSPayableInvoiceCreationMGTVO> list = command.searchCHSInvoiceListBasic(event.getChsPayableInvoiceCreationINVO());


			eventResponse.setRsVoList(list);
			commit();

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1034] : [Cancel]<br>
	 * Confirm 된 Invoice 를 Charge Creation 상태로 Cancel 처리한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelCHSInvoiceService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EesCgm1034Event event = (EesCgm1034Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		CSRExternalFinderBC command2 = new CSRExternalFinderBCImpl();

		try{
			begin();

			// CSR 처리
			CHSPayableInvoiceCreationINVO[] chsPayableInvoiceCreationINVOS = event.getChsPayableInvoiceCreationINVOS();

			for(int i=0; i<chsPayableInvoiceCreationINVOS.length; i++){

				ApPayInvVO apPayInvVO = new ApPayInvVO();
				ApPayInvDtlVO[] apPayInvDtlVOs = new ApPayInvDtlVO[0];

				apPayInvVO.setUpdUsrId(account.getUsr_id());
				apPayInvVO.setInvOfcCd(account.getOfc_cd());
				apPayInvVO.setDeltFlg("Y");
				apPayInvVO.setInvRgstNo(chsPayableInvoiceCreationINVOS[i].getInvRgstNo());

				// CSR 메소드 실행
				command2.createApPayInvInfo(apPayInvVO, apPayInvDtlVOs, account);

			}

			// 내부모듈
			command.cancelCHSInvoiceBasic(event.getChsPayableInvoiceCreationINVOS(), event.getChsPayableInvoiceCreationINVO(), account);
			List<CHSPayableInvoiceCreationMGTVO> list = command.searchCHSInvoiceListBasic(event.getChsPayableInvoiceCreationINVO());
			eventResponse.setRsVoList(list);
			commit();

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2035] : [Retrieve]<br>
	 * Invoice List 를 조회한다.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSInvoiceListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2035Event event = (EesCgm2035Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<MGSPayableInvoiceCreationMGTVO> list = command.searchMGSInvoiceListBasic(event.getMgsPayableInvoiceCreationINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2035] : [Retrieve]<br>
	 * 선택된 Invoice 에 속한 Detail 건들을 조회한다.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSInvoiceDetailService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2035Event event = (EesCgm2035Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<MGSPayableInvoiceCreationMGTVO> list = command.searchMGSInvoiceDetailBasic(event.getMgsPayableInvoiceCreationINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2035] : [Invoice Confirm]<br>
	 * Invoice Creation 화면에서 입력된 제반 사항(Issue date, effective date, receive date, revenue VVD 등) <br>
	 * 내용으로 Invoice 를 생성한다.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createMGSInvoiceService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EesCgm2035Event event = (EesCgm2035Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		CSRExternalFinderBC command2 = new CSRExternalFinderBCImpl();

		try{
			begin();

			// CSR 처리
			MGSPayableInvoiceCreationINVO[] mgsPayableInvoiceCreationINVOS = event.getMgsPayableInvoiceCreationINVOS();

			for(int i=0; i<mgsPayableInvoiceCreationINVOS.length; i++){

				MGSPayableInvoiceCreationINVO mgsPayableInvoiceCreationINVO = event.getMgsPayableInvoiceCreationINVO();

				// 파라메터 값 설정
				if(!mgsPayableInvoiceCreationINVOS[i].getInvTaxCltTpCd().equals("")){
					mgsPayableInvoiceCreationINVO.setInvTaxCltTpCd(mgsPayableInvoiceCreationINVOS[i].getInvTaxCltTpCd());
				} else {
					mgsPayableInvoiceCreationINVO.setInvTaxCltTpCd("0");
				}

				if(!mgsPayableInvoiceCreationINVOS[i].getInvTaxRt().equals("")){
					mgsPayableInvoiceCreationINVO.setInvTaxRt(mgsPayableInvoiceCreationINVOS[i].getInvTaxRt());
				} else {
					mgsPayableInvoiceCreationINVO.setInvTaxRt("0");
				}

				if(!mgsPayableInvoiceCreationINVOS[i].getChgSmryAmt().equals("")){
					mgsPayableInvoiceCreationINVO.setChgSmryAmt(mgsPayableInvoiceCreationINVOS[i].getChgSmryAmt());
				} else {
					mgsPayableInvoiceCreationINVO.setChgSmryAmt("0");
				}

				mgsPayableInvoiceCreationINVO.setPayInvSeq(mgsPayableInvoiceCreationINVOS[i].getPayInvSeq());
				mgsPayableInvoiceCreationINVO.setChssMgstInvKndCd(mgsPayableInvoiceCreationINVOS[i].getChssMgstInvKndCd());

				// AP_INV_MAIN 설정
				ApPayInvVO apPayInvVO = command.searchMGSInvoiceCreateMainBasic(mgsPayableInvoiceCreationINVO, account);

				// AP_INV_DTL 설정
				ApPayInvDtlVO[] apPayInvDtlVOs = command.searchMGSInvoiceCreateDetailBasic(mgsPayableInvoiceCreationINVO, account);

				// CSR 메소드 실행
				String  invRgstNo = command2.createApPayInvInfo(apPayInvVO, apPayInvDtlVOs, account);

				// CSR 에 받은 INV_RGST_NO 값을 설정
				mgsPayableInvoiceCreationINVOS[i].setInvRgstNo(invRgstNo);

			}

			// 내부모듈
			command.createMGSInvoiceBasic(event.getMgsPayableInvoiceCreationINVOS(), event.getMgsPayableInvoiceCreationINVO(), account);
			List<MGSPayableInvoiceCreationMGTVO> list = command.searchMGSInvoiceListBasic(event.getMgsPayableInvoiceCreationINVO());

			eventResponse.setRsVoList(list);
			commit();

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2035] : [Cancel]<br>
	 * Confirm 된 Invoice 를 Charge Creation 상태로 Cancel 처리한다.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelMGSInvoiceService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EesCgm2035Event event = (EesCgm2035Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		CSRExternalFinderBC command2 = new CSRExternalFinderBCImpl();

		try{
			begin();

			// CSR 처리
			MGSPayableInvoiceCreationINVO[] mgsPayableInvoiceCreationINVOS = event.getMgsPayableInvoiceCreationINVOS();

			for(int i=0; i<mgsPayableInvoiceCreationINVOS.length; i++){

				ApPayInvVO apPayInvVO = new ApPayInvVO();
				ApPayInvDtlVO[] apPayInvDtlVOs = new ApPayInvDtlVO[0];

				apPayInvVO.setUpdUsrId(account.getUsr_id());
				apPayInvVO.setInvOfcCd(account.getOfc_cd());
				apPayInvVO.setDeltFlg("Y");
				apPayInvVO.setInvRgstNo(mgsPayableInvoiceCreationINVOS[i].getInvRgstNo());

				// CSR 메소드 실행
				command2.createApPayInvInfo(apPayInvVO, apPayInvDtlVOs, account);

			}

			command.cancelMGSInvoiceBasic(event.getMgsPayableInvoiceCreationINVOS(), event.getMgsPayableInvoiceCreationINVO(), account);
			List<MGSPayableInvoiceCreationMGTVO> list = command.searchMGSInvoiceListBasic(event.getMgsPayableInvoiceCreationINVO());
			eventResponse.setRsVoList(list);
			commit();

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1107] : [Retrieve]<br>
	 * 월별 Chassis 추정결산 조회. <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSEstimateExpenseService (Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1107Event event = (EesCgm1107Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<CHSEstimateExpenseMGTVO> list = command.searchCHSEstimateExpenseBasic(event.getCHSEstimateExpenseINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1107] : [Retrieve]<br>
	 * 월별 Chassis 추정결산 산정. <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSEstimateExpenseCalcService (Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1107Event event = (EesCgm1107Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			// BackEndJob 수행
			String status = command.searchCHSEstimateExpenseCalcBasicBackEndJobStart(event.getCHSEstimateExpenseINVO(), account);
			
			eventResponse.setETCData("BackEndJobKey", status);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1107] : [Retrieve]<br>
	 * 월별 Chassis 추정결산 Summary조회. <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSEstimateExpenseSummaryService (Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1107Event event = (EesCgm1107Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<CHSEstimateExpenseMGTVO> list = command.searchCHSEstimateExpenseSummaryBasic(event.getCHSEstimateExpenseINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1107] : [manage]<br>
	 * 월별 Chassis 추정결산 처리. <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCHSEstimateExpenseCalcService (Event e) throws EventException {
		log.debug("☆★☆1107--------------------------->>");
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EesCgm1107Event event = (EesCgm1107Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();

		try{
			begin();
			command.manageCHSEstimateExpenseCalcBasic(event.getCHSEstimateExpenseINVO(),event.getCHSEstimateExpenseINVOs(), account);
			commit();

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2206] : [Retrieve]<br>
	 * 월별 M.G. Set 추정결산 조회. <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSEstimateExpenseService (Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2206Event event = (EesCgm2206Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<MGSEstimateExpenseMGTVO> list = command.searchMGSEstimateExpenseBasic(event.getMGSEstimateExpenseINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2206] : [Retrieve]<br>
	 * 월별 M.G. Set 추정결산 산정. <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSEstimateExpenseCalcService (Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2206Event event = (EesCgm2206Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<MGSEstimateExpenseMGTVO> list = command.searchMGSEstimateExpenseCalcBasic(event.getMGSEstimateExpenseINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2206] : [Retrieve]<br>
	 * 월별 M.G. Set 추정결산 Summary 조회. <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSEstimateExpenseSummaryService (Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2206Event event = (EesCgm2206Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<MGSEstimateExpenseMGTVO> list = command.searchMGSEstimateExpenseSummaryBasic(event.getMGSEstimateExpenseINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2206] : [manage]<br>
	 * 월별 M.G. Set 추정결산 처리. <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMGSEstimateExpenseCalcService (Event e) throws EventException {
		log.debug("☆★☆2206--------------------------->>");
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EesCgm2206Event event = (EesCgm2206Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();

		try{
			begin();
			command.manageMGSEstimateExpenseCalcBasic(event.getMGSEstimateExpenseINVO(),event.getMGSEstimateExpenseINVOs(), account);
			commit();

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1208]
	 * [EES_CGM_1035] : [Retrieve]<br>
	 * Chassis의 INVOICE를 Summary 하여 보여준다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSInvoiceInqListService (Event e) throws EventException {
		try
		{
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<CHSInvoiceInquiryMGTVO> list = null;
			// PDTO(Data Transfer Object including Parameters)
			if ("EesCgm1035Event".equalsIgnoreCase(e.getEventName())) {
				// PDTO(Data Transfer Object including Parameters)
				EesCgm1035Event event = (EesCgm1035Event)e;
				list = command.searchCHSInvoiceInqListBasic (event.getCHSInvoiceInquiryINVO());
			}else if("EesCgm1208Event".equalsIgnoreCase(e.getEventName())){
				// PDTO(Data Transfer Object including Parameters)
				EesCgm1208Event event = (EesCgm1208Event)e;
				list = command.searchCHSInvoiceInqListBasic (event.getCHSInvoiceInquiryINVO());
			}
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			if(list != null){
				eventResponse.setRsVoList(list);
			}
			
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1208]
	 * [EES_CGM_1035] : [Grid(dclick)]<br>
	 * Chassis의 INVOICE Detail 데이터를 보여준다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSInvoiceInqDtlService (Event e) throws EventException {
		try
		{
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<CHSInvoiceInquiryMGTVO> list = null;
			if ("EesCgm1035Event".equalsIgnoreCase(e.getEventName())) {
				// PDTO(Data Transfer Object including Parameters)
				EesCgm1035Event event = (EesCgm1035Event)e;
				list = command.searchCHSInvoiceInqDtlBasic (event.getCHSInvoiceInquiryINVO());
			}else if("EesCgm1208Event".equalsIgnoreCase(e.getEventName())){
				// PDTO(Data Transfer Object including Parameters)
				EesCgm1208Event event = (EesCgm1208Event)e;
				list = command.searchCHSInvoiceInqDtlBasic (event.getCHSInvoiceInquiryINVO());
			}
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			if(list != null){
				eventResponse.setRsVoList(list);
			}
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2036] : [Retrieve]<br>
	 * M.G.Set의 INVOICE를 Summary 하여 보여준다.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSInvoiceInqListService (Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2036Event event = (EesCgm2036Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<MGSInvoiceInquiryMGTVO> list = command.searchMGSInvoiceInqListBasic (event.getMGSInvoiceInquiryINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2036] : [Grid(dclick)]<br>
	 * M.G.Set의 INVOICE Detail 데이터를 보여준다.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSInvoiceInqDtlService (Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2036Event event = (EesCgm2036Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<MGSInvoiceInquiryMGTVO> list = command.searchMGSInvoiceInqDtlBasic (event.getMGSInvoiceInquiryINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1021] : [Default] <br>
	 * Default Searvice.. Retrieve <br>주1)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1021DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// agmt_lstm_cd
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD01948");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2023] : [Default] <br>
	 * Default Searvice.. Retrieve <br>주1)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm2023DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// agmt_lstm_cd
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD01948");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	/**
	 * [EES_CGM_1117] : [Default] <br>
	 * Default Searvice.. Retrieve <br>주1)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1117DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// agmt_lstm_cd
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD01948");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	/**
	 * [EES_CGM_2022] : [Default] <br>
	 * Default Searvice.. Retrieve <br>주1)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm2022DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// agmt_lstm_cd
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD01948");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1020] : [Default] <br>
	 * Default Searvice.. Retrieve <br>주1)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1020DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			MdmOrganizationINVO mdmOrganizationINVO = new MdmOrganizationINVO();

			mdmOrganizationINVO.setOfcCd(account.getOfc_cd());
			MdmOrganizationMGTVO mdmOrganizationMGTVO  = command.searchOrganizationBasic(mdmOrganizationINVO);
			// ETC DATA 설정
			log.debug("mdmOrganizationMGTVO.getArCurrCd()============"+mdmOrganizationMGTVO.getArCurrCd());


			eventResponse.setETCData("ar_curr_cd",mdmOrganizationMGTVO.getArCurrCd());

			// agmt_lstm_cd
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD01948");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			cParam1 = new ComboINVO();
			List<ComboMGTVO> list2 = command.searchPoolListBasic(cParam1);
			eventResponse.setRsVoList(list2);

			cParam1 = new ComboINVO();
			List<ComboMGTVO> list3 = command.searchStateCodeListBasic(cParam1);
			eventResponse.setRsVoList(list3);



			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2021] : [Default] <br>
	 * Default Searvice.. Retrieve <br>주1)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm2021DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// agmt_lstm_cd
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD01948");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1118] : [Default] <br>
	 * Default Searvice.. Retrieve <br>주1)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1118DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// agmt_lstm_cd
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD01948");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);


			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2028] : [Default] <br>
	 * Default Searvice.. Retrieve <br>주1)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm2028DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// agmt_lstm_cd
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD01948");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1123],[EES_CGM_1223] : [Default] <br>
	 * Default Searvice.. Retrieve <br>주1)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1123DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// agmt_lstm_cd
			ComboINVO cParam1 = new ComboINVO();
			
			if ("EesCgm1123Event".equalsIgnoreCase(e.getEventName())) {
				cParam1.setAgmtLstmCd("CP");
				cParam1.setChssPoolCd("");
				
				List<ComboMGTVO> list1 = command.searchAgreementByPoolBasic(cParam1);

				eventResponse.setRsVoList(list1);

				cParam1 = new ComboINVO();
				List<ComboMGTVO> list2 = command.searchPoolListBasic(cParam1);
				eventResponse.setRsVoList(list2);
			}else if("EesCgm1223Event".equalsIgnoreCase(e.getEventName())){
				cParam1.setAgmtLstmCd("ZP");
				cParam1.setChssPoolCd("");
				
				List<ComboMGTVO> list1 = command.searchAgreementByPoolBasic(cParam1);

				eventResponse.setRsVoList(list1);

				cParam1 = new ComboINVO();
				List<ComboMGTVO> list2 = command.searchCPSCHSSPoolListBasic(cParam1);
				eventResponse.setRsVoList(list2);
			}		
			
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1124] : [Default] <br>
	 * Default Searvice.. Retrieve <br>주1)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1124DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// agmt_lstm_cd
			ComboINVO cParam1 = new ComboINVO();

			cParam1.setAgmtLstmCd("NP");
			cParam1.setChssPoolCd("");
			List<ComboMGTVO> list1 = command.searchAgreementByPoolBasic(cParam1);
			eventResponse.setRsVoList(list1);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	// chungpa 20091230 Default Service Start
	/**
	 * [EES_CGM_1034] : [Default] <br>
	 * Default Searvice.. Retrieve <br>주1)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1034DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// Option
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD02355");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2035] : [Default] <br>
	 * Default Searvice.. Retrieve <br>주1)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm2035DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// Option
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD02355");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1026] : [Save] - BackEndJob<br>
	 * 선택된 Agreement 에 대해 Term Change를 BackEndJob으로 수행.(Chassis)<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse backEndCHSTermChangeListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesCgm1026Event event = (EesCgm1026Event)e;
			ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
			String status = command.backEndCHSTermChangeListBasic(event.getChsTermStatusINVOS(), event.getChsTermStatusINVO() ,account);
			eventResponse.setETCData("BackEndJobKey", status);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1026] [EES_CGM_1204] [EES_CGM_1107] : BackEndJob<br>
	 * BackEndJob의 실행결과에 대한 상태값을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchComBackEndJobStatusService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
			String key = (String)e.getAttribute("KEY");

			String status = command.searchComBackEndJobStatusBasic(key);
			eventResponse.setETCData("jb_sts_flg", status);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [EES_CGM_1107][EES_CGM_1225] : BackEndJob<br>
	 * BackEndJob의 실행결과로 생성된 파일을 로드합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse loadFileBackEndJobResultService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String key = null;
		
		if ("EesCgm1107Event".equalsIgnoreCase(e.getEventName())) {
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1107Event event = (EesCgm1107Event)e;
			key = event.getCHSEstimateExpenseINVO().getBackendjobKey();
		} else if("EesCgm1225Event".equalsIgnoreCase(e.getEventName())){
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1225Event event = (EesCgm1225Event)e;
			key = event.getPoolEstmExpenseINVO().getBackendjobKey();
		}
		
		List list = null;
//		log.debug("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= key : " + key);
		try {
			if(e.getEventName().equalsIgnoreCase("EesCgm1107Event")) {
				list = (List<CHSEstimateExpenseMGTVO>)BackEndJobResult.loadFromFile(key);
			} else if(e.getEventName().equalsIgnoreCase("EesCgm1225Event")) {
				list = (List<PoolEstmExpenseMGTVO>)BackEndJobResult.loadFromFile(key);
			}
			eventResponse.setRsVoList(list);
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * [EES_CGM_1202] : [Retrieve]<br>
	 * CPS Agreement 기본정보 및 Rate, Condition 등의 모든 정보를 조회한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSCpsAgreementAllService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1202Event event = (EesCgm1202Event)e;
			ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			// Response
			CHSCpsAgreementGroupVO list = command.searchCHSCpsAgreementAllBasic(event.getChsCpsAgreementINVO());

			eventResponse.setETCData((Map<String,String>)list.getEtcData());
			eventResponse.setRsVoList((List<CHSCpsAgreementMGTVO>)list.getChsCpsAgreementMGTVO());
			eventResponse.setRsVoList((List<CHSCpsAgreementMGTVO>)list.getChsCpsAgreementMGTVO2());
			eventResponse.setRsVoList((List<CHSCpsAgreementMGTVO>)list.getChsCpsAgreementMGTVO3());

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 *  Tab2에서 입력된 Yard Code로부터 Yard Name과 Tab1의 SCC를 체크한다. <br>주1)
	 * 
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCHSCpsAgreementYardService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1202Event event = (EesCgm1202Event)e;
			ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
			CHSCpsAgreementMGTVO CHSCpsAgreementMGTVO = command.checkCHSCpsAgreementYardBasic(event.getChsCpsAgreementINVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData((Map<String,String>)CHSCpsAgreementMGTVO.getColumnValues());
			
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 * [EES_CGM_1202] : [Save] <br>
	 * 화면에서 입력된 내용대로 최초 NP(ZP) Agreement 생성.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyCHSCpsAgreementService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1202Event event = (EesCgm1202Event)e;
		ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
		try{
			List<CHSCpsAgreementINVO[]> voList = new ArrayList<CHSCpsAgreementINVO[]>();
			voList.add(event.getChsCpsAgreementINVOS1());
			voList.add(event.getChsCpsAgreementINVOS2());

			begin();
			CHSCpsAgreementMGTVO chsCpsAgreementMGTVO = command.modifyCHSCpsAgreementBasic (voList, event.getChsCpsAgreementINVO() ,account);

			// ETC DATA 설정
			eventResponse.setETCData((Map<String,String>)chsCpsAgreementMGTVO.getColumnValues());

			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1202] : [Delete] <br>
	 * 선택된 NP(ZP) Agreement 를 삭제 처리 한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeCHSCpsAgreementService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1202Event event = (EesCgm1202Event)e;
		ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
		try{
			begin();
			command.removeCHSCpsAgreementBasic (event.getChsCpsAgreementINVO() ,account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [EES_CGM_1202] : [Default] <br>
	 * Default Searvice.. Retrieve <br>주1)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1202DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			ComboINVO cParam1 = new ComboINVO();

			cParam1 = new ComboINVO();
			List<ComboMGTVO> list = command.searchCPSCHSSPoolListBasic(cParam1);
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	// chungpa 20091229 Default Service End
	
	/**
	 * [EES_CGM_1203] : [Retrieve]<br>
	 * 해당월의 Charge 생성 리스트를 조회한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSCpsChargeCreationListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1203Event event = (EesCgm1203Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<CHSChargeCreationMGTVO> list = command.searchCHSCpsChargeCreationListBasic(event.getChsChargeCreationINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 * [EES_CGM_1203] : [Default] <br>
	 * Default Searvice.. Retrieve <br>주1)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1203DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// agmt_lstm_cd
			ComboINVO cParam1 = new ComboINVO();

			cParam1.setAgmtLstmCd("CP");
			cParam1.setChssPoolCd("");
			List<ComboMGTVO> list1 = command.searchAgreementByPoolBasic(cParam1);

			eventResponse.setRsVoList(list1);

			cParam1 = new ComboINVO();
			List<ComboMGTVO> list2 = command.searchCPSCHSSPoolListBasic(cParam1);
			eventResponse.setRsVoList(list2);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 * [EES_CGM_1203] : [Retrieve]<br>
	 * Charge Creation 한 결과값을 조회한다.(Cps Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSCpsChargeCreationResultService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1203Event event = (EesCgm1203Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<CHSChargeCreationMGTVO> list = command.searchCHSCpsChargeCreationResultBasic(event.getChsChargeCreationINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 * [EES_CGM_1203] : [Delete]<br>
	 * 선택된 Charge 를 삭제한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeCHSCpsChargeService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1203Event event = (EesCgm1203Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		try{
			begin();
			command.removeCHSCpsChargeBasic(event.getChsChargeCreationINVOS(), event.getChsChargeCreationINVO(), account);
			List<CHSChargeCreationMGTVO> list = command.searchCHSCpsChargeCreationListBasic(event.getChsChargeCreationINVO());
			eventResponse.setRsVoList(list);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}
		
	/**
	 * [EES_CGM_1204] : [Audit]<br>
	 * Invoice import 화면에서 로드된 invoice draft 를 Audit 하고 저장한다.(Chassis)<br>
	 *			
	 * @param Event e	
	 * @return EventResponse response		
	 * @exception EventException			
	 */		
	public EventResponse auditCHSCpsInvoiceService(Event e) throws EventException {
		
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EesCgm1204Event event = (EesCgm1204Event)e;						
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();		
			
			// AUDIT 수행
			String status = command.auditCHSCpsInvoiceDraftBackEndJobStart(event.getChsInvoiceImportAuditINVOS(), event.getChsInvoiceImportAuditINVO(), account);				
			eventResponse.setETCData("BackEndJobKey", status);
		
			return eventResponse; 	
	
	}
	
	/**
	 * [EES_CGM_1204] : [Save]<br>
	 * Invoice import 화면에서 Usage/Rebill를 제외한 Invoice Type을 Save한다. : Only CGM_LSE_CHG_HDR (Chassis)<br>
	 *			
	 * @param Event e	
	 * @return EventResponse response		
	 * @exception EventException			
	 */		
	public EventResponse saveCHSCpsInvoiceService(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1204Event event = (EesCgm1204Event)e;						
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();		
		
		try{
			begin();
			// Save 수행
			command.saveCHSCpsInvoiceDraft(event.getChsInvoiceImportAuditINVO(), account);
			
			commit();
			eventResponse.setETCData("ins_result", "SUCCESS");
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;

}
	
	/**
	 * [EES_CGM_1204] : [Save]<br>
	 * CGM_PAY_INV 테이블에 동일 INV_NO 존재하는지 여부 체크(Chassis)<br>
	 *			
	 * @param Event e	
	 * @return EventResponse response		
	 * @exception EventException			
	 */		
	public EventResponse checkCHSInvoiceNoDup(Event e) throws EventException {
		try
		{		
			
			String invFlag = "F"; // F : 중복존재, T : 중복 없음
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EesCgm1204Event event = (EesCgm1204Event)e;						
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();	
		
			/*
			 * CGM_PAY_INV 테이블에 동일 INV_NO 존재하는지 여부 체크 (2014-07-01 추가, 신용찬)
			 */
			long invCnt = command.checkCHSInvoiceNoDupBasic(event.getChsInvoiceImportAuditINVO());	

			if(invCnt > 0 ) invFlag = "F";
			else            invFlag = "T";

			eventResponse.setETCData("invFlag", invFlag);
			
			return eventResponse; 	
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}		
	}	
	
	/**
	 * [EES_CGM_1205] : [Retrieve]<br>
	 * CPS payable amount confirm 화면에서 화면 open 시 선택된 Agreement Audit result 를 조회한다.(Chassis)<br>
	 * Invoice Type :	Usage/Rebill	[UNR]
	 * 					Repo(Migration)	[MIG]
	 * 					Min Commitment	[CMT]
	 * 					MH Credit		[MCD]
	 * 					Revenue Sharing	[RSH]
	 * 					Cost Sharing	[CSH]
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSCpsInvoiceAuditResultService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1205Event event = (EesCgm1205Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CHSCpsConfirmPayableGRPVO resultVO = command.searchCHSCpsInvoiceAuditResultBasic(event.getChsCpsPayableInvoiceCreationINVO());
			List<List<CHSCpsPayableInvoiceCreationMGTVO>> list1 = resultVO.getCHSCpsPayableInvoiceCreationMGTVOs();
			

			for(int i=0; i<list1.size(); i++){
				eventResponse.setRsVoList((List<CHSCpsPayableInvoiceCreationMGTVO>)list1.get(i));
			}
			
			if(event.getChsCpsPayableInvoiceCreationINVO().getParentChssCopInvTpCd().equals("CMT") || 
				event.getChsCpsPayableInvoiceCreationINVO().getParentChssCopInvTpCd().equals("MCD")) {
				List<CHSCpsInvoiceAuditResultCmmtCrMGTVO> list2 = resultVO.getcHSCpsInvoiceAuditResultCmmtCrMGTVO();
				eventResponse.setRsVoList(list2);
			}
			
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 * [EES_CGM_1205] : [Retrieve]<br>
	 * CPS payable amount confirm 화면에서 화면 open 시 선택된 Agreement Audit result 를 조회한다.(Chassis)<br>
	 * Invoice Type : Min Commitment[CMT], MH Credit[MCD]
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSCpsInvoiceAuditResultCmmtCrService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1205Event event = (EesCgm1205Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			List<CHSCpsInvoiceAuditResultCmmtCrMGTVO> list 
				= command.searchCHSCpsInvoiceAuditResultCmmtCrBasic( event.getAgmtOfcCtyCd()
																	,event.getAgmtSeq()
																	,event.getAgmtVerNo()
																	,event.getCostYrmon()
																	,event.getCostYrmonSeq() );
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 * [EES_CGM_1205] : [Save]<br>
	 * Eq 별 Invoice Audit result 상태를 저장한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCHSCpsInvoiceAuditResultService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1205Event event = (EesCgm1205Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		try{
			begin();

			List<CHSCpsPayableInvoiceCreationINVO[]> voList = new ArrayList<CHSCpsPayableInvoiceCreationINVO[]>();

			voList.add(event.getChsCpsPayableInvoiceCreationINVO1());
			voList.add(event.getChsCpsPayableInvoiceCreationINVO2());
			voList.add(event.getChsCpsPayableInvoiceCreationINVO3());

			List<CHSCpsPayableInvoiceCreationMGTVO> list = command.manageCHSCpsInvoiceAuditResultBasic(voList,event.getChsCpsPayableInvoiceCreationINVO(), account);

			// Invoice Only의 경우 list 를 조회한다.
			if(event.getChsCpsPayableInvoiceCreationINVO1() != null){
				eventResponse.setRsVoList(list);
			}
			
			// Min Commitment/MH Credit Tab의 내용을 저장한다.
			if(event.getChsCpsPayableInvoiceCreationINVO().getParentChssCopInvTpCd().equals("CMT") || 
					event.getChsCpsPayableInvoiceCreationINVO().getParentChssCopInvTpCd().equals("MCD")) {
				command.manageCHSCpsInvoiceAuditResultCmmtCrBasic(event.getCHSCpsInvoiceAuditResultCmmtCrMGTVOs(), account);
			}

			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [EES_CGM_1205] : [Payable Amount Confirm]<br>
	 * 화면의 Payable Amount 대로 비용 확정(confirm) 처리한다.(Chassis) <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmCHSCpsPayableAmountService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1205Event event = (EesCgm1205Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		try{
			begin();
			command.confirmCHSCpsPayableAmountBasic(event.getChsCpsPayableInvoiceCreationINVOS(), event.getChsConfirmPayableAmountINVO(), account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [EES_CGM_1205] : [Save]<br>
	 * Min Commitment/MH Credit Tab의 내용을 저장한다.(Chassis) <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCHSCpsInvoiceAuditResultCmmtCrService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1205Event event = (EesCgm1205Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		try{
			begin();
			command.manageCHSCpsInvoiceAuditResultCmmtCrBasic(event.getCHSCpsInvoiceAuditResultCmmtCrMGTVOs(), account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [EES_CGM_1205] : [Payable Amount Confirm]<br>
	 * 화면의 Payable Amount 대로 비용 확정 취소(cancel) 처리한다.(Chassis) <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelCHSCpsPayableAmountService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1205Event event = (EesCgm1205Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		try{
			begin();
			// 취소(cancel) 처리
			command.cancelCHSCpsPayableAmountBasic(event.getChsCpsPayableInvoiceCreationINVO(), account);
			
			// 재조회
			CHSCpsConfirmPayableGRPVO resultVO = command.searchCHSCpsInvoiceAuditResultBasic(event.getChsCpsPayableInvoiceCreationINVO());
			List<List<CHSCpsPayableInvoiceCreationMGTVO>> list1 = resultVO.getCHSCpsPayableInvoiceCreationMGTVOs();

			for(int i=0; i<list1.size(); i++){
				eventResponse.setRsVoList((List<CHSCpsPayableInvoiceCreationMGTVO>)list1.get(i));
			}
			
			if(event.getChsCpsPayableInvoiceCreationINVO().getParentChssCopInvTpCd().equals("CMT") || 
					event.getChsCpsPayableInvoiceCreationINVO().getParentChssCopInvTpCd().equals("MCD")) {
					List<CHSCpsInvoiceAuditResultCmmtCrMGTVO> list2 = resultVO.getcHSCpsInvoiceAuditResultCmmtCrMGTVO();
					eventResponse.setRsVoList(list2);
			}
			
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [EES_CGM_1207] : [Default] <br>
	 * Default Searvice.. Retrieve <br>주1)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1207DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// Option
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD02355");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 * [EES_CGM_1207] : [Retrieve]<br>
	 * Invoice List 를 조회한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSCpsInvoiceListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1207Event event = (EesCgm1207Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<CHSPayableInvoiceCreationMGTVO> list = command.searchCHSCpsInvoiceListBasic(event.getChsPayableInvoiceCreationINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1207] : [Grid(dclick)]<br>
	 * 선택된 Invoice 에 속한 Detail 건들을 조회한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSCpsInvoiceDetailService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1207Event event = (EesCgm1207Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<CHSPayableInvoiceCreationMGTVO> list = command.searchCHSCpsInvoiceDetailBasic(event.getChsPayableInvoiceCreationINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 * [EES_CGM_1207] : [Invoice Confirm]<br>
	 * Invoice Creation 화면에서 입력된 제반 사항(Issue date, effective date, receive date, revenue VVD 등) <br>
	 * 내용으로 Invoice 를 생성한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createCHSCpsInvoiceService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EesCgm1207Event event = (EesCgm1207Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		CSRExternalFinderBC command2 = new CSRExternalFinderBCImpl();

		try{
			begin();

			// CSR 처리
			CHSPayableInvoiceCreationINVO[] chsPayableInvoiceCreationINVOS = event.getChsPayableInvoiceCreationINVOS();

			for(int i=0; i<chsPayableInvoiceCreationINVOS.length; i++){

				CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO = event.getChsPayableInvoiceCreationINVO();

				// 파라메터 값 설정
				if(!chsPayableInvoiceCreationINVOS[i].getInvTaxCltTpCd().equals("")){
					chsPayableInvoiceCreationINVO.setInvTaxCltTpCd(chsPayableInvoiceCreationINVOS[i].getInvTaxCltTpCd());
				} else {
					chsPayableInvoiceCreationINVO.setInvTaxCltTpCd("0");
				}

				if(!chsPayableInvoiceCreationINVOS[i].getInvTaxRt().equals("")){
					chsPayableInvoiceCreationINVO.setInvTaxRt(chsPayableInvoiceCreationINVOS[i].getInvTaxRt());
				} else {
					chsPayableInvoiceCreationINVO.setInvTaxRt("0");
				}

				if(!chsPayableInvoiceCreationINVOS[i].getChgSmryAmt().equals("")){
					chsPayableInvoiceCreationINVO.setChgSmryAmt(chsPayableInvoiceCreationINVOS[i].getChgSmryAmt());
				} else {
					chsPayableInvoiceCreationINVO.setChgSmryAmt("0");
				}

				chsPayableInvoiceCreationINVO.setPayInvSeq(chsPayableInvoiceCreationINVOS[i].getPayInvSeq());
				chsPayableInvoiceCreationINVO.setChssMgstInvKndCd(chsPayableInvoiceCreationINVOS[i].getChssMgstInvKndCd());

				// AP_INV_MAIN 설정
				ApPayInvVO apPayInvVO = command.searchCHSInvoiceCreateMainBasic(chsPayableInvoiceCreationINVO, account);

				// AP_INV_DTL 설정
				ApPayInvDtlVO[] apPayInvDtlVOs = command.searchCHSInvoiceCreateDetailBasic(chsPayableInvoiceCreationINVO, account);

				// CSR 메소드 실행
				String  invRgstNo = command2.createApPayInvInfo(apPayInvVO, apPayInvDtlVOs, account);

				// CSR 에 받은 INV_RGST_NO 값을 설정
				chsPayableInvoiceCreationINVOS[i].setInvRgstNo(invRgstNo);

			}

			// 내부모듈
			command.createCHSCpsInvoiceBasic(chsPayableInvoiceCreationINVOS, event.getChsPayableInvoiceCreationINVO(), account);
			List<CHSPayableInvoiceCreationMGTVO> list = command.searchCHSCpsInvoiceListBasic(event.getChsPayableInvoiceCreationINVO());


			eventResponse.setRsVoList(list);
			commit();

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [EES_CGM_1207] : [Cancel]<br>
	 * Confirm 된 Invoice 를 Charge Creation 상태로 Cancel 처리한다.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelCHSCpsInvoiceService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EesCgm1207Event event = (EesCgm1207Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		CSRExternalFinderBC command2 = new CSRExternalFinderBCImpl();

		try{
			begin();

			// CSR 처리
			CHSPayableInvoiceCreationINVO[] chsPayableInvoiceCreationINVOS = event.getChsPayableInvoiceCreationINVOS();

			for(int i=0; i<chsPayableInvoiceCreationINVOS.length; i++){

				ApPayInvVO apPayInvVO = new ApPayInvVO();
				ApPayInvDtlVO[] apPayInvDtlVOs = new ApPayInvDtlVO[0];

				apPayInvVO.setUpdUsrId(account.getUsr_id());
				apPayInvVO.setInvOfcCd(account.getOfc_cd());
				apPayInvVO.setDeltFlg("Y");
				apPayInvVO.setInvRgstNo(chsPayableInvoiceCreationINVOS[i].getInvRgstNo());

				// CSR 메소드 실행
				command2.createApPayInvInfo(apPayInvVO, apPayInvDtlVOs, account);

			}

			// 내부모듈
			command.cancelCHSCpsInvoiceBasic(event.getChsPayableInvoiceCreationINVOS(), event.getChsPayableInvoiceCreationINVO(), account);
			List<CHSPayableInvoiceCreationMGTVO> list = command.searchCHSCpsInvoiceListBasic(event.getChsPayableInvoiceCreationINVO());
			eventResponse.setRsVoList(list);
			commit();

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [EES_CGM_1208] : [Default] <br>
	 * Default Searvice.. Retrieve <br>주1)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1208DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			ComboINVO cParam1 = new ComboINVO();

			cParam1 = new ComboINVO();
			List<ComboMGTVO> list = command.searchCPSCHSSPoolListBasic(cParam1);
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 * [EES_CGM_1155] : [Default] <br>
	 * Default Searvice.. Retrieve <br>주1)
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1155DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CgmCodeMgtBC command          = new CgmCodeMgtBCImpl();	
			// agmt_lstm_cd
			ComboINVO cParam1 = new ComboINVO();

			cParam1.setAgmtLstmCd("CP");
			cParam1.setChssPoolCd("");

			// pool name/code list	
			List<ComboMGTVO> list1 = command.searchCPSCHSSPoolListBasic(cParam1);
			eventResponse.setRsVoList(list1);
			

			return eventResponse;
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}	
	
	/**
	 * 화면공통Period 조회 이벤트 처리<br>
	 * 현재일을 기준으로 주차와,년월을 구해 주어진 기간의 주차와,년월을 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDefaultMonthWeek(Event e) throws EventException {

		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		// 기본월 시작/종료 조회
		CHSPoolSCCReportINVO chsPoolSCCReportINVO = command.searchDefaultMonthWeek();
		if(chsPoolSCCReportINVO.getFromBseDt() != null ) {
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData.put("fm_prd",chsPoolSCCReportINVO.getFromBseDt());
			etcData.put("to_prd",chsPoolSCCReportINVO.getToBseDt()  );
			eventResponse.setETCData(etcData);
		}		
		return eventResponse;		
	}	

	/**
	 * EES_CGM_1155 : 달 헤더 Retrieve <br>
	 * 주어진 기간의 주차와,년월 목록을 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthList(Event e) throws EventException {
		// 2014-05-28 Justin Han recovered R4J defects.
		EesCgm1155Event event = (EesCgm1155Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		
		List<CHSPoolSCCReportMGTVO> chsListVOS = command.searchMonthList(event.getChsPoolSCCReportINVO() );

//		String totBaseDt = "";
		StringBuffer totBaseDt = new StringBuffer();
		if(chsListVOS.size() > 0) {
			for ( int i=0; i<chsListVOS.size(); i++) {
				if ( i == chsListVOS.size()-1) {
					totBaseDt.append( chsListVOS.get(i).getBseDt().substring(0, 4)+"-"+chsListVOS.get(i).getBseDt().substring(4, 6) );  // 신용찬 수정, 2014-07-09
//					totBaseDt.append(chsListVOS.get(i).getBseDt().substring(0, 4)).append("-").append(chsListVOS.get(i).getBseDt().substring(4, 6));
//					totBaseDt = totBaseDt+chsListVOS.get(i).getBseDt().substring(0, 4)+"-"+chsListVOS.get(i).getBseDt().substring(4, 6);
				} else {
					totBaseDt.append( chsListVOS.get(i).getBseDt().substring(0, 4)+"-"+chsListVOS.get(i).getBseDt().substring(4, 6)+"|" ); // 신용찬 수정, 2014-07-09
//					totBaseDt.append(totBaseDt+chsListVOS.get(i).getBseDt().substring(0, 4)).append("-").append(chsListVOS.get(i).getBseDt().substring(4, 6)).append("|");
//					totBaseDt = totBaseDt+chsListVOS.get(i).getBseDt().substring(0, 4)+"-"+chsListVOS.get(i).getBseDt().substring(4, 6)+"|";
				}
			}
		}
		Map<String,String> etcData = new HashMap<String,String>();
		
//		etcData.put("bse_dt", totBaseDt);
		etcData.put("bse_dt", totBaseDt.toString());
		
		eventResponse.setETCData(etcData);
		return eventResponse;
	}
	
	/**
	 * EES_CGM_1155 : Retrieve <br>
	 * Chassis Amount Pool단위 조회  <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSPoolReportService(Event e) throws EventException {
		EesCgm1155Event event = (EesCgm1155Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		List<CHSPoolSCCReportMGTVO> list = command.searchCHSPoolReportBasic(event.getChsPoolSCCReportINVO());		
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	}	
	
	/**
	 * EES_CGM_1156 : Retrieve <br>
	 * Chassis Amount SC/NO단위 조회  <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSSCNOReportService(Event e) throws EventException {
		EesCgm1156Event event = (EesCgm1156Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		List<CHSSCNOReportMGTVO> list = command.searchCHSSCNOReportBasic(event.getChsSCNOReportINVO());		
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	}
	
	/**
	 * EES_CGM_1220 : Retrieve <br>
	 * Chassis Exception Qinquiry list 조회  <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSSCExceptionService(Event e) throws EventException {
		EesCgm1220Event event = (EesCgm1220Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		List<CHSScExceptionINVO> vos = command.searchCHSSCExceptionService(event.getCHSScExceptionINVO());	                
        
		Map colValues = vos.get(0).getColumnValues();                                                                           
		String[] cols = (String[])colValues.keySet().toArray(new String[colValues.size()]);                                     		
		
		StringBuilder sb = new StringBuilder();                                                                                 
                                                                                                                                        
		if (cols.length > 0) {                   
			for (int j = 1 ; j < 66 ; j++){
				String name = "scc"+ j;
				
				for(int i = 0 ; i < cols.length ; i++){                                                                      
					if(cols[i].startsWith("scc") && (!"".equals(colValues.get(cols[i])) && colValues.get(cols[i]) != null)){											
						if(cols[i].equals(name)){
							sb.append(colValues.get(cols[i])); 
							sb.append("|"); 
						}
					}
				}                                                                                                       
			}                                                                                                               
		}                                                                                                                       
			                                                                                                                
		Map<String, String> etcData = new HashMap<String, String>();                                                            
		etcData.put("header", sb.toString());                                                                                   
		vos.remove(0);
		                                                                                                                         
		eventResponse.setETCData(etcData);		                                                                        
		                                                                                                                        
		eventResponse.setRsVoList(vos);                                                                                         
		                                                                                                                        
		return eventResponse;  
	}
	
	/**
	 * EES_CGM_1220 : searchVerifySccService <br>
	 *  SCC를 체크합니다. <br>
	 * 
     * @param  Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchVerifySccService(Event e) throws EventException {
    	try {
			// PDTO(Data Transfer Object including Parameters)
    		EesCgm1220Event event = (EesCgm1220Event)e;
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
    		
			CHSScExceptionINVO cHSScExceptionINVO = event.getCHSScExceptionINVO();  

			String locCd = "";

			List<CHSScExceptionINVO> vos = command.searchVerifySccService(cHSScExceptionINVO);
			
			StringBuffer sb = new StringBuffer();
			
			for(int i = 0; i < vos.size(); i++){
				sb.append(vos.get(i).getLocCd()+", ");
			}
			
			locCd = sb.toString();
	
			eventResponse.setETCData("LOC_CD", locCd);
			
			return eventResponse;

		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	}
    
    /**
	 * EES_CGM_1220 : searchVerifyScNoService <br>
	 *  SC No.를 체크합니다. <br>
	 * 
     * @param  Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchVerifyScNoService(Event e) throws EventException {
    	try {
			// PDTO(Data Transfer Object including Parameters)
    		EesCgm1220Event event = (EesCgm1220Event)e;
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
    		
			CHSScExceptionINVO cHSScExceptionINVO = event.getCHSScExceptionINVO();  

			String scNo = "";

			List<CHSScExceptionINVO> vos = command.searchVerifyScNoService(cHSScExceptionINVO);
			
			StringBuffer sb = new StringBuffer();
			
			for(int i = 0; i < vos.size(); i++){
				sb.append(vos.get(i).getScNo()+", ");
			}
			
			scNo = sb.toString();
	
			eventResponse.setETCData("SC_NO", scNo);
			
			return eventResponse;

		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	}
	
	/**
	 * [EES_CGM_1211] : [Check]<br>
	 * Load된 데이터를 CGM_LSE_INV_TMP에 insert 한 후 <br>
	 * 비교로직 Query로 이상유무를 체크하여 화면으로 비교결과 전달<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse insertAfterCheckAuditResultUpdate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1211Event event = (EesCgm1211Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		
		try{
			begin();
			
			List<CHSCpsAuditResultUpdateMGTVO> voList = new ArrayList<CHSCpsAuditResultUpdateMGTVO>();
			
			int maxSeq = 0;	// select nvl(max(CHG_CRE_SEQ),0) + 1 from CGM_LSE_INV_TMP
			int insCnt = 0;
			
			String costYrmon = null;
			String costYrmonSeq = null;
			String agmtOfcCtyCd = null;
			String agmtSeq = null;
			String agmtVerNo = null;
			
			maxSeq = command.getMaxSeqAuditResultUpdate();
//			log.debug("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 1");
			insCnt = command.insertAuditResultUpdate(event.getChsCpsAuditResultUpdateINVOS(), maxSeq, account);
//			log.debug("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 2 : " + insCnt);
			if(insCnt > 0) {
				
				costYrmon		= event.getChsCpsAuditResultUpdateINVOS()[0].getCostYrmon();
				costYrmonSeq	= event.getChsCpsAuditResultUpdateINVOS()[0].getCostYrmonSeq();
				agmtOfcCtyCd	= event.getChsCpsAuditResultUpdateINVOS()[0].getAgmtOfcCtyCd();
				agmtSeq			= event.getChsCpsAuditResultUpdateINVOS()[0].getAgmtSeq();
				agmtVerNo		= event.getChsCpsAuditResultUpdateINVOS()[0].getAgmtVerNo();
				
				voList = command.checkAuditResultUpdate(maxSeq, costYrmon, costYrmonSeq, agmtOfcCtyCd, agmtSeq, agmtVerNo);
			}
			
			
			eventResponse.setRsVoList(voList);
			eventResponse.setETCData("INSERT_CNT", Integer.toString(insCnt));
			
			commit();
			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [EES_CGM_1211] : [Update]<br>
	 * Check된 데이터를 DB에 update<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse updateAuditResultUpdate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1211Event event = (EesCgm1211Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		
		try{
			begin();
			
			int updCnt = 0;
			
			updCnt = command.updateAuditResultUpdate(event.getChsCpsAuditResultUpdateINVOS(), account);
			
			eventResponse.setETCData("UPDATE_CNT", Integer.toString(updCnt));
			
			commit();
			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [EES_CGM_1225] : [Retrieve] <br>
	 *  MAS(MAS_DMDT_COST_RPT_BKG_DTL)에서 Pool Estimate Amount 를 조회한다. Calculation (BackendJob) <br>주1)
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchZPPoolEstimateAmtFromMASService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1225Event event = (EesCgm1225Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			// BackEndJob 수행
			String status = command.searchZPPoolEstimateAmtFromMASBasicBackEndJobStart(event.getPoolEstmExpenseINVO(), account);
//			List<PoolEstmExpenseMGTVO> list = command.searchZPPoolEstimateAmtFromMASBasic(event.getPoolEstmExpenseINVO());
			
			eventResponse.setETCData("BackEndJobKey", status);
//			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 * [EES_CGM_1225] : [Retrieve] <br>
	 * 저장된 Pool Estimate Amount 를 조회한다. Retrieve <br>주1)
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchZPPoolEstimateAmtService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1225Event event = (EesCgm1225Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<PoolEstmExpenseMGTVO> list = command.searchZPPoolEstimateAmtBasic(event.getPoolEstmExpenseINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 * [EES_CGM_1225] : [Save] <br>
	 *  조회된 Pool Estimate Amount 를 저장한다. Save <br>주1)
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyZPPoolEstimateAmtService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1225Event event = (EesCgm1225Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		try{
			begin();
//			log.debug("event.getPoolEstmExpenseMGTVOs().length============="+event.getPoolEstmExpenseMGTVOs().length);
			command.modifyZPPoolEstimateAmtBasic(event.getPoolEstmExpenseMGTVOs(), account);
//			eventResponse.setUserMessage(new ErrorHandler("CGM00002").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}
}