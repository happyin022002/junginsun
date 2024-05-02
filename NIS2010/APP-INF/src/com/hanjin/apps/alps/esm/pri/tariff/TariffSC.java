/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : TariffSC.java
 *@FileTitle : Tariff Rule Creation &amp; Amendment
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.10.06
 *@LastModifier : 최성민
 *@LastVersion : 1.0
 * 2010.10.06 최성민
 * 1.0 Creation
=========================================================
 * History
 * 2011.04.19 이행지 [CHM-201110201-01] Tariff Rule 관련 Status 변경 관리자 기능 추가 요청
 *                                  - SuperUser일 경우 Publish Cacel권한 부여
 * 2011.05.16 이행지 [CHM-201110773-01] [PRI] Tariff Rule - Publish Cancel 기능 보완
 * 2013.04.17 전윤주 [CHM-201324375] Inland Tariff 기능 병합  (Amend Type 추가)
 * 2013.04.29 김보배 [CHM-201324375] Publish 기능 이전 요청
 * 2013.06.10 서미진 [선처리 CSR] Load Excel data 의 증가로 backendjob으로 upload 로직 변경
 * 2013.07.31 전윤주 [CHM-201326002] DG Service flag가 'Y' 인 경우에만 버튼 색을 파란색으로 표시 
 *                                 DG Service flag 조회를 위한 메서드 추가(ESM_PRI_7003_01), IHC DG, SPCL CGO Service flag 조회를 위한 메서드 추가(ESM_PRI_7025)
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.hanjin.apps.alps.esm.pri.common.diff.DiffList;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.basic.PRICommonBC;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.basic.PRICommonBCImpl;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.tariff.country.basic.CountryBC;
import com.hanjin.apps.alps.esm.pri.tariff.country.basic.CountryBCImpl;
import com.hanjin.apps.alps.esm.pri.tariff.country.event.EsmPri7027Event;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.basic.FeederChargeGuideLineBC;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.basic.FeederChargeGuideLineBCImpl;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.event.EsmPri700301Event;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.event.EsmPri700302Event;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.event.EsmPri7011Event;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.event.EsmPri7012Event;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.event.EsmPri7013Event;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.event.EsmPri7026Event;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.event.EsmPri7028Event;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.FDRDetailVO;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.FDRMainVO;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.basic.FICCostInterfaceBC;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.basic.FICCostInterfaceBCImpl;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.event.EsmPri7006Event;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.event.EsmPri7007Event;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.event.EsmPri702101Event;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.event.EsmPri702102Event;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.event.EsmPri7022Event;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.vo.TariffCodeMappingVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.basic.IHCGuideLineBC;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.basic.IHCGuideLineBCImpl;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event.EsmPri700101Event;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event.EsmPri700102Event;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event.EsmPri7001Event;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event.EsmPri7002Event;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event.EsmPri700401Event;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event.EsmPri700402Event;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event.EsmPri7014Event;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event.EsmPri7024Event;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event.EsmPri702501Event;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event.EsmPri702502Event;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event.EsmPri7025Event;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event.EsmPri703101Event;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event.EsmPri703102Event;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event.EsmPri7031Event;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event.EsmPri703201Event;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event.EsmPri703202Event;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event.EsmPri7032Event;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event.EsmPri7033Event;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event.EsmPri7034Event;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event.EsmPri7035Event;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.IHCDetailVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.IHCGuidelineMainVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.SearchIHCAmendmentHistoryMainVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.SearchUsInlandServiceModeTotalVO;
import com.hanjin.apps.alps.esm.pri.tariff.inlandrates.basic.InlandRatesBC;
import com.hanjin.apps.alps.esm.pri.tariff.inlandrates.basic.InlandRatesBCImpl;
import com.hanjin.apps.alps.esm.pri.tariff.inlandrates.event.EsmPri3514Event;
import com.hanjin.apps.alps.esm.pri.tariff.inlandrates.event.EsmPri3515Event;
import com.hanjin.apps.alps.esm.pri.tariff.inlandrates.event.EsmPri3516Event;
import com.hanjin.apps.alps.esm.pri.tariff.inlandrates.event.EsmPri3517Event;
import com.hanjin.apps.alps.esm.pri.tariff.inlandrates.event.EsmPri3521Event;
import com.hanjin.apps.alps.esm.pri.tariff.inlandrates.event.EsmPri3522Event;
import com.hanjin.apps.alps.esm.pri.tariff.inlandrates.vo.PriTrfInlndParamVO;
import com.hanjin.apps.alps.esm.pri.tariff.inlandrates.vo.RsltPriTrfInlndRtVO;
import com.hanjin.apps.alps.esm.pri.tariff.inlandrates.vo.RsltPriTrfInlndVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffcode.basic.TariffCodeBC;
import com.hanjin.apps.alps.esm.pri.tariff.tariffcode.basic.TariffCodeBCImpl;
import com.hanjin.apps.alps.esm.pri.tariff.tariffcode.event.EsmPri3502Event;
import com.hanjin.apps.alps.esm.pri.tariff.tariffcode.event.EsmPri3503Event;
import com.hanjin.apps.alps.esm.pri.tariff.tariffcode.vo.RsltSvcScpCdVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffcode.vo.SearchTariffCodeALLVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffcode.vo.SearchTariffCodeUsedVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffcode.vo.SearchTariffScopeDupVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.basic.TariffGeneralInformationBC;
import com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.basic.TariffGeneralInformationBCImpl;
import com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.event.EsmPri3501Event;
import com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.event.EsmPri3504Event;
import com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.event.EsmPri3505Event;
import com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.event.EsmPri3511Event;
import com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.event.EsmPri3518Event;
import com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.vo.PriTrfBzcHistoryAmendVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.vo.PriTrfBzcHistoryVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.vo.RsltPriTrfBzcListVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.vo.RsltPriTrfBzcVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffrule.basic.TariffRuleBC;
import com.hanjin.apps.alps.esm.pri.tariff.tariffrule.basic.TariffRuleBCImpl;
import com.hanjin.apps.alps.esm.pri.tariff.tariffrule.event.EsmPri3507Event;
import com.hanjin.apps.alps.esm.pri.tariff.tariffrule.event.EsmPri3509Event;
import com.hanjin.apps.alps.esm.pri.tariff.tariffrule.event.EsmPri3510Event;
import com.hanjin.apps.alps.esm.pri.tariff.tariffrule.event.EsmPri3512Event;
import com.hanjin.apps.alps.esm.pri.tariff.tariffrule.event.EsmPri3519Event;
import com.hanjin.apps.alps.esm.pri.tariff.tariffrule.event.EsmPri3523Event;
import com.hanjin.apps.alps.esm.pri.tariff.tariffrule.event.EsmPri3599Event;
import com.hanjin.apps.alps.esm.pri.tariff.tariffrule.integration.TariffRuleDBDAO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffrule.vo.RsltPriTrfRuleVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriTariffVO;
import com.hanjin.syscommon.common.table.PriTrfBzcVO;
import com.hanjin.syscommon.common.table.PriTrfInlndVO;

/**
 * ALPS-Tariff Business Logic ServiceCommand - ALPS-Tariff 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author CHOI SUNGMIN
 * @see TariffRuleDBDAO
 * @since J2EE 1.6
 */

public class TariffSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * Tariff system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("TariffSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * Tariff system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("TariffSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-Tariff system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmPri3507Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTariffRuleList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkTariffRuleNumber(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageTariffRule(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) { // Amend Cancel
				eventResponse = cancelAmendTariffRule(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY03)) { // Request
				eventResponse = requestTariffRule(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY04)) { // Approve
				eventResponse = approveTariffRule(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY06)) { // Cancel
				eventResponse = cancelStatusTariffRule(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { // Cancel Publish
				eventResponse = cancelPublishTariffRuleBySuperUser(e);
			} else {
				eventResponse = initTariffRuleComboData(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri3519Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) { // Amend
				eventResponse = amendTariffRule(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri3510Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MODIFY05)) { // Publish
				eventResponse = publishTariffRule(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri3512Event")) { // Rule Inquiry
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTariffRuleInquiryList(e);
			} else {
				eventResponse = initTariffRuleInquiryComboData(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri3509Event")) { // Rule History
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTariffRuleHistoryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchTariffRuleAmendHistoryList(e);
			} else {
				eventResponse = initTariffRuleHistoryComboData(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri3514Event")) { // Inland Rates List
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchInlandRatesName(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // Inland Rates Detail
				eventResponse = searchInlandRates(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { // Inland Rates Detail DownLoad
				eventResponse = searchInlandRatesExcel(e);
			}
			/*
			 * else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) { //Excel Upload check eventResponse = searchInlandRatesCheck(e); }
			 */
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) { // Inland Rates Max seq
				eventResponse = searchInlandRatesMaxSeq(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) { // Delete
				eventResponse = removeInlandRates(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE02)) { // Cancel
				eventResponse = cancelInlandRates(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // Save
				eventResponse = manageInlandRates(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { // Attach
				eventResponse = manageInlandRatesFile(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) { // Request
				eventResponse = requestInlandRates(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY03)) { // Approve
				eventResponse = approveInlandRates(e);
			}
			/*
			 * else if (e.getFormCommand().isCommand(FormCommand.MODIFY04)) { //EsmPri3517Event eventResponse = approveInlandRates(e); }
			 */
			else {
				eventResponse = initInlandRatesComboData(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri3521Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) { // Amend
				eventResponse = amendInlandRates(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri3522Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // Excel Check
				eventResponse = searchInlandRatesCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // Save
				eventResponse = manageInlandRatesExcel(e);
			} else {
				eventResponse = initInlandRatesComboData(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri3517Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MODIFY04)) { // Publish
				eventResponse = publishInlandRates(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri3502Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // FOCUS_OUT
				eventResponse = searchTariffCodeName(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // Retrieve
				eventResponse = searchTariffCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // Save
				eventResponse = manageTariffCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) { // Delete
				eventResponse = removeTariffCode(e);
			} else {
				eventResponse = initTariffCodeCreationComboData(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri3501Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTariffGeneralInformation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // SAVE
				eventResponse = manageTariffGeneralInformation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) { // DELETE
				eventResponse = removeTariffGeneralInformation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY03)) { // REQUEST
				eventResponse = requestTariffGeneralInformation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY04)) { // APPROVE
				eventResponse = approveTariffGeneralInformation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY06)) { // CANCEL
				eventResponse = cancelTariffGeneralInformation(e);
			} else {
				eventResponse = initTariffGeneralInformationComboData(e); // 화면 최초 호출 시 실행
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri3518Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) { // AMEND
				eventResponse = amendTariffGeneralInformation(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri3503Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // Retrieve
				eventResponse = searchTariffCodeList(e);
			} else {
				eventResponse = initTariffCodeComboData(e); // FOCUS_OUT
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri3505Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MODIFY05)) { // PUBLISH
				eventResponse = publishTariffGeneralInformation(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri3511Event")) { // Tariff General Information Inquiry
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { // RETRIEVE
				eventResponse = searchTariffGeneralInformationInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // DOUBLE CLICK
				eventResponse = searchTariffGeneralInformationInquiry(e);
			} else { // 화면 최초 호출 시 실행
				eventResponse = initTariffGeneralInformationInquiryComboData(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri3515Event")) { // Inland Rates Inquiry
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { // RETRIEVE
				eventResponse = searchInlandRatesInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // SHEET CLICK
				eventResponse = searchInlandRatesInquiry(e);
			} else { // 화면 최초 호출 시 실행
				eventResponse = initInlandRatesInquiryComboData(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri3504Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // RETRIEVE
				eventResponse = searchTariffGeneralHistoryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // SHEET 1 DOUBLE CLICK
				eventResponse = searchTariffGeneralAmendHistoryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { // SHEET 2 DOUBLE CLICK
				eventResponse = searchTariffGeneralHistory(e);
			} else {
				eventResponse = initTariffGeneralHistoryComboData(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri3516Event")) { // Inland Rates History
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { // RETRIEVE
				eventResponse = searchInlandRatesHistoryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { // SHEET1 CLICK
				eventResponse = searchInlandRatesAmendHistoryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // SHEET2 CLICK
				eventResponse = searchInlandRatesHistory(e);
			} else { // 화면 최초 호출 시 실행
				eventResponse = initInlandRatesHistoryComboData(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri3599Event")) {
			// Diff Popup
			eventResponse = searchTariffRuleDiff(e);
		} else if (e.getEventName().equalsIgnoreCase("EsmPri3523Event")) { // Tariff Rule Publish Revise
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { // RETRIEVE
				eventResponse = searchTariffRulePublishCancelList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // OK
				eventResponse = cancelPublishTariffRule(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri7021Event")) {
		} else if (e.getEventName().equalsIgnoreCase("EsmPri702101Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchAddOnCostTraiff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managerAddOnCostTraiff(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri702102Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchIHCCostTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managerIHCCostTariff(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri7022Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTariffCodeMapping(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageTariffCodeMapping(e);
			}else {
				eventResponse = initTariffCodeMappingComboData(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri700301Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // RETRIEVE sheet
				eventResponse = searchTariffInquiryListDR(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {// Add-on DG Flag search
				eventResponse = searchTariffInquiryAddOnDgFlag(e);
			}			
		} else if (e.getEventName().equalsIgnoreCase("EsmPri700302Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTariffInquiryListRF(e);
			}	
		} else if (e.getEventName().equalsIgnoreCase("EsmPri700401Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchIhcTariffInquiryListDR(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri700402Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchIhcTariffInquiryListRF(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri7024Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchIHCTariffList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri7027Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCountryList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri7001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // RETRIEVE Form
				eventResponse = searchIHCGuidelineMain(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // SAVE
				eventResponse = manageIHCGuideline(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { // CANCEL
				eventResponse = cancelIHCGuideline(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) { // CONFIRM
				eventResponse = confirmIHCGuideline(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) { // CONFIRM - CHECK
				eventResponse = checkPreIHCGuideline(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) { // AMEND - CHECK
				eventResponse = checkMaxCostTrfNo(e);
			} else {
				eventResponse = initIHCGuidelineComboData(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri700101Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // RETRIEVE sheet
				eventResponse = searchIHCGuidelineDetailDry(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // SAVE
				eventResponse = manageIHCGuidelineDetailDry(e);
			} else {
				eventResponse = initIHCGuidelineComboData(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri700102Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // RETRIEVE Form
				eventResponse = searchIHCGuidelineMain(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // RETRIEVE sheet
				eventResponse = searchIHCGuidelineDetailReefer(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // SAVE
				eventResponse = manageIHCGuidelineDetailReefer(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // SAVE CHECK
				eventResponse = checkAddRFIHCGuidelineDetail(e);
			} else {
				eventResponse = initIHCGuidelineComboData(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri7002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // AMEND
				eventResponse = amendIHCGuideline(e);
			} else {
				eventResponse = initIHCGuidelineComboData(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri7011Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // RETRIEVE Form
				eventResponse = searchFDRMain(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // RETRIEVE sheet
				eventResponse = searchFDRDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // SAVE
				eventResponse = manageFDR(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { // CANCEL
				eventResponse = cancelFDR(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) { // CONFIRM
				eventResponse = confirmFDR(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) { // CONFIRM - CHECK
				eventResponse = checkPreFDR(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) { // AMEND - CHECK
				eventResponse = checkMaxCostTrfNoFDR(e);
			} else {
				eventResponse = initIHCGuidelineComboData(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri7012Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // AMEND
				eventResponse = amendFDR(e);
			} else {
				eventResponse = initIHCGuidelineComboData(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri7013Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				// upload
				eventResponse = uploadAddonCreation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				// 엑셀 업로드 데이터에 대한 Validation 체크
				eventResponse = uploadAddonCreationCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				// Feeder 상태 체크
				eventResponse = searchFeederStatus(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkLocCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				// service scope에 따른 Feeder RHQ_CD 조회
				eventResponse = comboFdrRhqCdList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri7025Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // RETRIEVE Main
				eventResponse = searchIHCAmendmentHistoryMain(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {				
				eventResponse = searchIHCDgOverWeightFlag(e); // DG, Weight 버튼 색 변경을 위해 flag 조회
			}else {
				eventResponse = initIHCGuidelineComboData(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri7026Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {			// RETRIEVE Main
				eventResponse = searchFDRAmendmentHistoryMain(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // RETRIEVE Detail
				eventResponse = searchFDRAmendmentHistoryDetail(e);
			} else {
				eventResponse = initIHCGuidelineComboData(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri7028Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchFDRDGSurcharge(e);
			} else {
				eventResponse = initIHCGuidelineComboData(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri7006Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkCopyServiceScope(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkCopyServiceScopeInitial(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = checkCopyServiceScopeEffdt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageIHCCopy(e);
			}				
		} else if (e.getEventName().equalsIgnoreCase("EsmPri7007Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkFDRCopyServiceScopeInitial(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkFDRCopyServiceScopeEffdt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageFDRCopy(e);
			}				
		} else if (e.getEventName().equalsIgnoreCase("EsmPri702501Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchIHCAmendmentHistoryDetailDR(e);
			} else {
				eventResponse = initIHCGuidelineComboData(e);
			}				
		} else if (e.getEventName().equalsIgnoreCase("EsmPri702502Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchIHCAmendmentHistoryDetailRF(e);
			} else {
				eventResponse = initIHCGuidelineComboData(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri7031Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 	 // RETRIEVE Form
				eventResponse = searchUsIHCGuidelineMain(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // CONFIRM VAL 1
				eventResponse = checkUsIHCTariffTotal(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { // CONFIRM VAL 2
				eventResponse = checkUsIHCTariffTuning(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // SAVE
				eventResponse = manageUsIHCGuideline(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { // CANCEL
				eventResponse = cancelUsIHCGuideline(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) { // CONFIRM
				eventResponse = confirmUsIHCGuideline(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) { // CONFIRM - CHECK
				eventResponse = checkUsPreIHCGuideline(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) { // AMEND - CHECK
				eventResponse = checkUsMaxCostTrfNo(e);
			} else {
				eventResponse = initIHCGuidelineComboData(e);
			}	
		} else if (e.getEventName().equalsIgnoreCase("EsmPri703101Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // RETRIEVE sheet
				eventResponse = searchUsIHCGuidelineDetailDry(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // Retrieve Inland SVC Mode
				eventResponse = searchUsInlandServiceModeTotalDry(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // SAVE
				eventResponse = manageUsIHCGuidelineDetailDry(e);
			} else {
				eventResponse = initIHCGuidelineComboData(e);
			}	
		} else if (e.getEventName().equalsIgnoreCase("EsmPri703102Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // RETRIEVE sheet
				eventResponse = searchUsIHCGuidelineDetailReefer(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // SAVE
				eventResponse = manageUsIHCGuidelineDetailReefer(e);
			} else {
				eventResponse = initIHCGuidelineComboData(e);
			}	
		} else if (e.getEventName().equalsIgnoreCase("EsmPri7033Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // RETRIEVE sheet
				eventResponse = searchUsRailIHCGuidelineDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { // Check		
				eventResponse = checkUsRailIHCGuidelineDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // SAVE
				eventResponse = manageUsRailIHCGuidelineDetail(e);
			} else {
				eventResponse = initIHCGuidelineComboData(e);
			}	
		} else if (e.getEventName().equalsIgnoreCase("EsmPri7032Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchUsIHCAmendmentHistoryMainCombo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchUsIHCAmendmentHistoryMainMaxSeq(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchUsIHCAmendmentHistoryMain(e);
			} else {
				eventResponse = initIHCGuidelineComboData(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri703201Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchUsIHCAmendmentHistoryDetailDR(e);
			} else {
				eventResponse = initIHCGuidelineComboData(e);
			}				
		} else if (e.getEventName().equalsIgnoreCase("EsmPri703202Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchUsIHCAmendmentHistoryDetailRF(e);
			} else {
				eventResponse = initIHCGuidelineComboData(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmPri7034Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchUsTariffInquiryList(e);
			} else {
				eventResponse = initIHCGuidelineComboData(e);
			}	
		} else if (e.getEventName().equalsIgnoreCase("EsmPri7035Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageUsRoute(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // Check		
				eventResponse = checkUsRoute(e);
			} 
		} else if (e.getEventName().equalsIgnoreCase("EsmPri7014Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				// upload
				eventResponse = uploadIHCCreation(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				// 엑셀 업로드 데이터에 대한 Validation 체크
				eventResponse = uploadIHCCreationCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				// Feeder 상태 체크
				eventResponse = searchIHCStatus(e);
			} else {
				eventResponse = initIHCGuidelineComboData(e);
			}
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3507 : [OPEN]<br>
	 * [콤보데이터]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse initTariffRuleComboData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// EsmPri3507Event event = (EsmPri3507Event)e;
		PRICommonBC command = new PRICommonBCImpl();
		TariffRuleBC command2 = new TariffRuleBCImpl();
		RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

		try {
			// Amend Type
			vo.setCd("CD02760");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("TRF_RULE_AMDT_TP_CD", list);

			// Status
			vo.setCd("CD02395");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("TRF_RULE_STS_CD", list);

			// Charge Code
			list = command.searchChargeCdList(vo);
			eventResponse.setCustomData("TRF_RULE_CHG_CD", list);

			// Approval Office
			list = command.searchApprovalOfficeList(vo);
			eventResponse.setCustomData("APRO_OFC_CD", list);

			// TARIFF CODE
			list = command2.searchTariffCodeList(vo);
			eventResponse.setCustomData("TARIFF_CD", list);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3507 : [Retrieve]<br>
	 * [Tariff Rule Creation & Amendment 정보]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffRuleList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3507Event event = (EsmPri3507Event) e;
		TariffRuleBC command = new TariffRuleBCImpl();

		try {
			event.getPriTrfRuleVO().setRqstOfcCd(account.getOfc_cd());
			event.getPriTrfRuleVO().setAproOfcCd(account.getRhq_ofc_cd());

			List<RsltPriTrfRuleVO> list = command.searchTariffRuleList(event.getPriTrfRuleVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3507 : [Retrieve]<br>
	 * [Tariff Rule Creation & Amendment 정보의 중복]을 [체크]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkTariffRuleNumber(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3507Event event = (EsmPri3507Event) e;
		TariffRuleBC command = new TariffRuleBCImpl();

		try {
			String dupLen = command.checkTariffRuleNumber(event.getPriTrfRuleVO());
			eventResponse.setETCData("DUP_LEN", dupLen);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3507 : [Save]<br>
	 * [Tariff Rule Creation & Amendment 정보]을 [저장]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTariffRule(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3507Event event = (EsmPri3507Event) e;
		TariffRuleBC command = new TariffRuleBCImpl();
		try {
			begin();
			// command.manageTariffRule(event.getPriTrfRuleVOS(),account);
			command.manageTariffRule(event.getPriTrfRuleListVO(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
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
	 * ESM_PRI_3507: Cancel Publish<br>
	 * 숨은 기능인 Superuser만 실행 시킬수 있는 Cancel Publish
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelPublishTariffRuleBySuperUser(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3507Event event = (EsmPri3507Event) e;
		TariffRuleBC command = new TariffRuleBCImpl();

		try {
			begin();
			command.cancelPublishTariffRuleBySuperUser(event.getPriTrfRuleVO(), account);

			eventResponse.setUserMessage((String) new ErrorHandler("PRI01047", new String[] {}).getUserMessage());
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
	 * ESM_PRI_3519 : [Amend]<br>
	 * [Tariff Rule Creation & Amendment 정보]을 [AMEND]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse amendTariffRule(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3519Event event = (EsmPri3519Event) e;
		TariffRuleBC command = new TariffRuleBCImpl();
		try {
			begin();
			command.amendTariffRule(event.getPriTrfRuleVO(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
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
	 * ESM_PRI_3507 : [Amend Cancel]<br>
	 * [Tariff Rule Creation & Amendment 정보]을 [AMEND CANCEL]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelAmendTariffRule(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3507Event event = (EsmPri3507Event) e;
		TariffRuleBC command = new TariffRuleBCImpl();
		try {
			begin();
			command.cancelAmendTariffRule(event.getPriTrfRuleVO(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
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
	 * ESM_PRI_3507 : [Request]<br>
	 * [Tariff Rule Creation & Amendment 정보]을 [REQUEST]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse requestTariffRule(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3507Event event = (EsmPri3507Event) e;
		TariffRuleBC command = new TariffRuleBCImpl();
		try {
			begin();
			command.requestTariffRule(event.getPriTrfRuleVO(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00341", new String[] { "Request" }).getUserMessage());
			commit();
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
	 * ESM_PRI_3507 : [Approve]<br>
	 * [Tariff Rule Creation & Amendment 정보]을 [APPROVE]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse approveTariffRule(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3507Event event = (EsmPri3507Event) e;
		TariffRuleBC command = new TariffRuleBCImpl();
		try {
			begin();
			command.approveTariffRule(event.getPriTrfRuleVO(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00341", new String[] { "Approve" }).getUserMessage());
			commit();
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
	 * ESM_PRI_3510 : [Publish]<br>
	 * [Tariff Rule Creation & Amendment 정보]을 [PUBLISH]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse publishTariffRule(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3510Event event = (EsmPri3510Event) e;
		TariffRuleBC command = new TariffRuleBCImpl();
		try {
			begin();
			command.publishTariffRule(event.getPriTrfRuleVO(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00341", new String[] { "Publish" }).getUserMessage());
			commit();
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
	 * ESM_PRI_3507 : [Cancel]<br>
	 * [Tariff Rule Creation & Amendment 상태정보]을 [수정]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelStatusTariffRule(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3507Event event = (EsmPri3507Event) e;
		TariffRuleBC command = new TariffRuleBCImpl();
		try {
			begin();
			command.cancelStatusTariffRule(event.getPriTrfRuleVO(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00341", new String[] { "Cancel" }).getUserMessage());
			commit();
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
	 * ESM_PRI_3512 : [OPEN]<br>
	 * [콤보데이터]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse initTariffRuleInquiryComboData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// EsmPri3507Event event = (EsmPri3507Event)e;
		PRICommonBC command = new PRICommonBCImpl();
		TariffRuleBC command2 = new TariffRuleBCImpl();

		RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

		try {
			// Amend Type
			vo.setCd("CD02760");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("TRF_RULE_AMDT_TP_CD", list);

			// Status
			vo.setCd("CD02395");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("TRF_RULE_STS_CD", list);

			// Charge Code
			list = command.searchChargeCdList(vo);
			eventResponse.setCustomData("TRF_RULE_CHG_CD", list);

			// Approval Office
			list = command.searchApprovalOfficeList(vo);
			eventResponse.setCustomData("APRO_OFC_CD", list);

			// TARIFF CODE
			list = command2.searchTariffCodeList(vo);
			eventResponse.setCustomData("TARIFF_CD", list);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3512 : [Retrieve]<br>
	 * [Tariff Rule 정보]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffRuleInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3512Event event = (EsmPri3512Event) e;
		TariffRuleBC command = new TariffRuleBCImpl();

		try {
			List<RsltPriTrfRuleVO> list = command.searchTariffRuleInquiryList(event.getPriTrfRuleVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3509 : [OPEN]<br>
	 * [콤보데이터]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse initTariffRuleHistoryComboData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PRICommonBC command = new PRICommonBCImpl();
		TariffRuleBC command2 = new TariffRuleBCImpl();

		RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

		try {
			// Status
			vo.setCd("CD02395");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("TRF_RULE_STS_CD", list);

			// Approval Office
			list = command.searchApprovalOfficeList(vo);
			eventResponse.setCustomData("APRO_OFC_CD", list);

			// TARIFF CODE
			list = command2.searchTariffCodeList(vo);
			eventResponse.setCustomData("TARIFF_CD", list);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3514 : [OPEN]<br>
	 * [콤보데이터]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse initInlandRatesComboData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// EsmPri3514Event event = (EsmPri3514Event)e;
		PRICommonBC command = new PRICommonBCImpl();
		InlandRatesBC command2 = new InlandRatesBCImpl();

		RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

		try {

			if ("EsmPri3514Event".equals(e.getEventName())) {
				// Approval Office
				list = command.searchApprovalOfficeList(vo);
				eventResponse.setCustomData("APRO_OFC_CD", list);

				// TARIFF CODE
				list = command2.searchTariffCodeList(vo);
				eventResponse.setCustomData("TARIFF_CD", list);

				// Amend Type
				vo.setCd("CD02760");
				list = command.searchComCodeDescList(vo);
				eventResponse.setCustomData("TRF_INLND_AMDT_TP_CD", list);

				// Status
				vo.setCd("CD02395");
				list = command.searchComCodeDescList(vo);
				eventResponse.setCustomData("TRF_RULE_STS_CD", list);

				// Source
				vo.setCd("CD01734");
				list = command.searchComCodeDescList(vo);
				eventResponse.setCustomData("SRC_INFO_CD", list);
			}

			// Currency
			list = command.searchAllCurrencyCodeList(vo);
			eventResponse.setCustomData("CURR_CD", list);

			// Term
			vo.setCd("CD01725");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("INLND_RT_TERM_CD", list);

			// Trans. Mode
			vo.setCd("CD02772");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("PRC_INLND_RT_TRSP_MOD_CD", list);

			// Weght Unit
			vo.setCd("CD02764");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("INLND_RT_LMT_WGT_UT_CD", list);

			// Type
			vo.setCd("CD01701");
			list = command.searchComCodeDescList(vo);
			// list = command.searchComCodeList(vo);
			eventResponse.setCustomData("PRC_CGO_TP_CD", list);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3514 : [Save]<br>
	 * [Inland Rate Max Seq]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandRatesMaxSeq(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3514Event event = (EsmPri3514Event) e;
		InlandRatesBC command = new InlandRatesBCImpl();

		try {
			String maxSeq = command.searchInlandRatesMaxSeq(event.getPriTrfInlndVO());
			eventResponse.setETCData("MAX_SEQ", maxSeq);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3514 : [Retrieve]<br>
	 * [Inland Rate Name]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandRatesName(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3514Event event = (EsmPri3514Event) e;
		InlandRatesBC command = new InlandRatesBCImpl();

		try {
			List<PriTrfInlndVO> list = command.searchInlandRatesName(event.getPriTrfInlndVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3514 : [Retrieve]<br>
	 * [Inland Rate 상세정보]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandRates(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3514Event event = (EsmPri3514Event) e;
		InlandRatesBC command = new InlandRatesBCImpl();
		PriTrfInlndParamVO priTrfInlndParamVO = new PriTrfInlndParamVO();
		try {
			String searchFlg = event.getPriTrfInlndParamVO().getEtc1();

			// List<RsltPriTrfInlndVO> list1 = command.searchInlandRates(event.getPriTrfInlndParamVO());
			// eventResponse.setRsVoList(list1);

			event.getPriTrfInlndParamVO().setRqstOfcCd(account.getOfc_cd());
			event.getPriTrfInlndParamVO().setAproOfcCd(account.getRhq_ofc_cd());

			if (searchFlg.equals("ONLY_MAIN")) {
				List<RsltPriTrfInlndVO> list1 = command.searchInlandRates(event.getPriTrfInlndParamVO());
				eventResponse.setRsVoList(list1);
			} else if (searchFlg.equals("ONLY_DETAIL")) {
				List<RsltPriTrfInlndVO> list1 = command.searchInlandRates(event.getPriTrfInlndParamVO());
				// eventResponse.setRsVoList(list1);

				// Exception 처리 : Cancel 진행으로 현재 Amend Seq 가 존재하지 않을경우
				if (list1.isEmpty()) {
					throw new EventException(new ErrorHandler("PRI06014", new String[] {}).getMessage());
				}

				ObjectCloner.build(list1.get(0), priTrfInlndParamVO);
				priTrfInlndParamVO.setEtc2(event.getPriTrfInlndParamVO().getEtc2());
				List<RsltPriTrfInlndRtVO> list2 = command.searchInlandRatesLocation(priTrfInlndParamVO);
				eventResponse.setRsVoList(list2);

				String maxSeq = command.searchInlandRatesLocationMaxSeq(priTrfInlndParamVO);
				eventResponse.setETCData("LOC_MAX_SEQ", maxSeq);

				// 최근 업데이트 날짜
				String maxUpdate = command.searchInlandRatesMaxUpdate(priTrfInlndParamVO);
				eventResponse.setETCData("MAX_UPD_DT", maxUpdate);
			} else if (searchFlg.equals("CHECK_VIEW")) {
				List<RsltPriTrfInlndRtVO> list2 = command.searchInlandRatesLocation(event.getPriTrfInlndParamVO());
				eventResponse.setRsVoList(list2);

				String maxSeq = command.searchInlandRatesLocationMaxSeq(event.getPriTrfInlndParamVO());
				eventResponse.setETCData("LOC_MAX_SEQ", maxSeq);

				// 최근 업데이트 날짜
				String maxUpdate = command.searchInlandRatesMaxUpdate(priTrfInlndParamVO);
				eventResponse.setETCData("MAX_UPD_DT", maxUpdate);
			} else {
				List<RsltPriTrfInlndVO> list1 = command.searchInlandRates(event.getPriTrfInlndParamVO());
				eventResponse.setRsVoList(list1);

				// Exception 처리 : Cancel 진행으로 현재 Amend Seq 가 존재하지 않을경우
				if (list1.isEmpty()) {
					throw new EventException(new ErrorHandler("PRI06014", new String[] {}).getMessage());
				}

				ObjectCloner.build(list1.get(0), priTrfInlndParamVO);
				priTrfInlndParamVO.setEtc2(event.getPriTrfInlndParamVO().getEtc2());
				List<RsltPriTrfInlndRtVO> list2 = command.searchInlandRatesLocation(priTrfInlndParamVO);
				eventResponse.setRsVoList(list2);

				String maxSeq = command.searchInlandRatesLocationMaxSeq(priTrfInlndParamVO);
				eventResponse.setETCData("LOC_MAX_SEQ", maxSeq);

				// 최근 업데이트 날짜
				String maxUpdate = command.searchInlandRatesMaxUpdate(priTrfInlndParamVO);
				eventResponse.setETCData("MAX_UPD_DT", maxUpdate);
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3514 : [Down Excel]<br>
	 * [Inland Rate 상세정보]을 [다운로드]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandRatesExcel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3514Event event = (EsmPri3514Event) e;
		InlandRatesBC command = new InlandRatesBCImpl();

		try {
			List<RsltPriTrfInlndRtVO> list = command.searchInlandRatesExcel(event.getPriTrfInlndRtVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3522 : [check]<br>
	 * [Inland Rate 상세정보]을 [체크]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandRatesCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3522Event event = (EsmPri3522Event) e;
		InlandRatesBC command = new InlandRatesBCImpl();

		try {
			List<RsltCdListVO> list = command.searchInlandRatesCheck(event.getPriTrfInlndRtVOS());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3514 : [Delete]<br>
	 * [Inland Rate 정보]을 [삭제]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeInlandRates(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3514Event event = (EsmPri3514Event) e;
		InlandRatesBC command = new InlandRatesBCImpl();
		try {
			begin();

			String sValue = command.searchInlandRatesExistCheck(event.getPriTrfInlndVO());
			// Exception 처리 : Cancel 진행으로 현재 Amend Seq 가 존재하지 않을경우
			if (sValue == null) {
				throw new EventException(new ErrorHandler("PRI01135", new String[] { "Inland Rates" }).getMessage());
			}

			command.removeInlandRates(event.getPriTrfInlndVO());
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00102", new String[] {}).getUserMessage());
			commit();
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
	 * ESM_PRI_3514 : [Cancel]<br>
	 * [Inland Rate 정보]을 [취소]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelInlandRates(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3514Event event = (EsmPri3514Event) e;
		InlandRatesBC command = new InlandRatesBCImpl();
		try {
			begin();

			String sValue = command.searchInlandRatesExistCheck(event.getPriTrfInlndVO());
			// Exception 처리 : Cancel 진행으로 현재 Amend Seq 가 존재하지 않을경우
			if (sValue == null) {
				throw new EventException(new ErrorHandler("PRI01135", new String[] { "Inland Rates" }).getMessage());
			}

			command.cancelInlandRates(event.getPriTrfInlndVO(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00341", new String[] { "Cancel" }).getUserMessage());
			commit();
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
	 * ESM_PRI_3514 : [Save]<br>
	 * [Inland Rate 상세정보]을 [저장]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageInlandRates(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3514Event event = (EsmPri3514Event) e;
		InlandRatesBC command = new InlandRatesBCImpl();
		PriTrfInlndVO tVo = new PriTrfInlndVO();
		try {
			begin();

			ObjectCloner.build(event.getPriTrfInlndListVO().getPriTrfInlndParamVO(), tVo);
			String sFlag = event.getPriTrfInlndListVO().getPriTrfInlndVOs()[0].getIbflag();
			String sValue = command.searchInlandRatesExistCheck(tVo);

			// Exception 처리 : Cancel 진행으로 현재 Amend Seq 가 존재하지 않을경우
			if ("I".equals(sFlag) && sValue != null) {
				throw new EventException(new ErrorHandler("PRI01135", new String[] { "Inland Rates" }).getMessage());
			} else if (!"I".equals(sFlag) && sValue == null) {
				throw new EventException(new ErrorHandler("PRI01135", new String[] { "Inland Rates" }).getMessage());
			}

			command.manageInlandRates(event.getPriTrfInlndListVO(), account);

			// 최근 업데이트 날짜
			String maxUpdate = command.searchInlandRatesMaxUpdate(event.getPriTrfInlndListVO().getPriTrfInlndParamVO());
			eventResponse.setETCData("MAX_UPD_DT", maxUpdate);

			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
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
	 * ESM_PRI_3522 : [Save]<br>
	 * [Inland Rate 상세정보]을 [저장]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageInlandRatesExcel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3522Event event = (EsmPri3522Event) e;
		InlandRatesBC command = new InlandRatesBCImpl();
		try {
			begin();
			command.manageInlandRates(event.getPriTrfInlndListVO(), account);

			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
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
	 * ESM_PRI_3517 : [Publish]<br>
	 * [Inland Rate 정보]을 [PUBLISH]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse publishInlandRates(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3517Event event = (EsmPri3517Event) e;
		InlandRatesBC command = new InlandRatesBCImpl();
		try {
			begin();
			command.publishInlandRates(event.getPriTrfInlndVO(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00341", new String[] { "Publish" }).getUserMessage());
			commit();
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
	 * ESM_PRI_3521 : [Amend]<br>
	 * [Inland Rate 정보]을 [AMEND]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse amendInlandRates(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3521Event event = (EsmPri3521Event) e;
		InlandRatesBC command = new InlandRatesBCImpl();
		try {
			begin();
			command.amendInlandRates(event.getPriTrfInlndVO(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
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
	 * ESM_PRI_3507 : [Request]<br>
	 * [Inland Rate 정보]을 [REQUEST]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse requestInlandRates(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3514Event event = (EsmPri3514Event) e;
		InlandRatesBC command = new InlandRatesBCImpl();
		try {
			begin();

			String sValue = command.searchInlandRatesExistCheck(event.getPriTrfInlndVO());
			// Exception 처리 : Cancel 진행으로 현재 Amend Seq 가 존재하지 않을경우
			if (sValue == null) {
				throw new EventException(new ErrorHandler("PRI01135", new String[] { "Inland Rates" }).getMessage());
			}

			command.requestInlandRates(event.getPriTrfInlndVO(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00341", new String[] { "Request" }).getUserMessage());
			commit();
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
	 * ESM_PRI_3507 : [Approve]<br>
	 * [Inland Rate 정보]을 [승인]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse approveInlandRates(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3514Event event = (EsmPri3514Event) e;
		InlandRatesBC command = new InlandRatesBCImpl();
		try {
			begin();

			String sValue = command.searchInlandRatesExistCheck(event.getPriTrfInlndVO());
			// Exception 처리 : Cancel 진행으로 현재 Amend Seq 가 존재하지 않을경우
			if (sValue == null) {
				throw new EventException(new ErrorHandler("PRI01135", new String[] { "Inland Rates" }).getMessage());
			}

			command.approveInlandRates(event.getPriTrfInlndVO(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00341", new String[] { "Approve" }).getUserMessage());
			commit();
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
	 * ESM_PRI_3514 : [Save]<br>
	 * [Inland Rate 파일]을 [업로드]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageInlandRatesFile(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3514Event event = (EsmPri3514Event) e;
		InlandRatesBC command = new InlandRatesBCImpl();
		try {
			begin();
			List<String> keys = event.getKeys();
			command.manageInlandRatesFile(event.getPriTrfInlndVO(), keys, account);

			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
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
	 * ESM_PRI_3509 : [Retrieve]<br>
	 * [Tariff Rule Amend History 정보]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffRuleAmendHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3509Event event = (EsmPri3509Event) e;
		TariffRuleBC command = new TariffRuleBCImpl();

		try {
			List<RsltPriTrfRuleVO> list = command.searchTariffRuleAmendHistoryList(event.getPriTrfRuleHistoryVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3514 : [Retrieve]<br>
	 * [Tariff Rule History 정보]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffRuleHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3509Event event = (EsmPri3509Event) e;
		TariffRuleBC command = new TariffRuleBCImpl();

		try {
			List<RsltPriTrfRuleVO> list = command.searchTariffRuleHistoryList(event.getPriTrfRuleHistoryVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3502 : [Retrieve] <br>
	 * [Tariff Scope]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3502Event event = (EsmPri3502Event) e;
		TariffCodeBC command = new TariffCodeBCImpl();

		try {
			List<RsltSvcScpCdVO> list = command.searchTariffCode(event.getRsltSvcScpCdVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3502 : Tariff Code Focus out <br>
	 * [Tariff Name]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffCodeName(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3502Event event = (EsmPri3502Event) e;
		PRICommonBC command = new PRICommonBCImpl();
		TariffCodeBC command2 = new TariffCodeBCImpl();
		try {			
			List<PriTariffVO> list = command.searchTariffCodeName(event.getPriTariffVO());
			List<PriTariffVO> list2 = command2.searchInlandRates(event.getPriTariffVO()); 

			if (list.size() > 0) {
				eventResponse.setETCData("trf_nm", list.get(0).getTrfNm());
				eventResponse.setETCData("cre_flg", "N");
				eventResponse.setETCData("trf_inlnd_flg", list2.get(0).getTrfInlndFlg());
				eventResponse.setETCData("web_dp_flg", list2.get(0).getWebDpFlg());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3502 : [OPEN] [Combo Data]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse initTariffCodeCreationComboData(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PRICommonBC command = new PRICommonBCImpl();

		RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

		try {
			list = command.searchServiceScopeCodeList(vo);
			eventResponse.setCustomData("scopeList", list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3502 : [SAVE] <br>
	 * Tariff Name을 생성하고, Tariff Scope 추가 및 삭제<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTariffCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3502Event event = (EsmPri3502Event) e;
		TariffCodeBC command = new TariffCodeBCImpl();
		try {

			List<SearchTariffScopeDupVO> checkList = command.searchTariffScopeDuplicate(event.getRsltSvcScpCdVOs());

			if (checkList.size() != 0) {
				StringBuffer dup = new StringBuffer();
				for (int i = 0; i < checkList.size(); i++) {
					if (i != 0) {
						dup.append(",");
					}
					dup.append(checkList.get(i).getSvcScpCd());
				}
				throw new EventException(new ErrorHandler("PRI06010", new String[] { dup.toString() }).getMessage());

			}

			begin();
			command.manageTariffCode(event.getInPriTariffVO(), event.getRsltSvcScpCdVOs(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3502 : DELETE <br>
	 * Tariff 삭제
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */

	private EventResponse removeTariffCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3502Event event = (EsmPri3502Event) e;
		TariffCodeBC command = new TariffCodeBCImpl();

		try {
			SearchTariffCodeUsedVO usedVO = command.searchTariffCodeUsed(event.getPriTariffVO());

			if (!usedVO.getUsedFlg().equals("0")) {
				throw new EventException(new ErrorHandler("PRI06004", new String[] {}).getMessage());
			}
			begin();
			command.removeTariffCode(event.getPriTariffVO());
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00102", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3501 : Open<br>
	 * Combo Data를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse initTariffGeneralInformationComboData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PRICommonBC command = new PRICommonBCImpl();

		RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

		try {

			// TARIFF CODE
			list = command.searchTariffCodeList(vo);
			eventResponse.setCustomData("TARIFF_CD", list);

			// Approval Office
			list = command.searchApprovalOfficeList(vo);
			eventResponse.setCustomData("APRO_OFC_CD", list);

			// Tariff Type
			vo.setCd("CD02761");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("TRF_BZC_TP_CD", list);

			// Weight Ton Unit
			vo.setCd("CD02764");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("TRF_BZC_WGT_UT_CD", list);

			// Volume Ton Unit
			vo.setCd("CD02762");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("TRF_BZC_VOL_UT_CD", list);

			// CURRENCY
			list = command.searchAllCurrencyCodeList(vo);
			eventResponse.setCustomData("CURR_CD", list);

			// SOURCE
			vo.setCd("CD02064");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("SRC_INFO_CD", list);

			// //STATUS
			// vo.setCd("CD02395");
			// list = command.searchComCodeDescList(vo);
			// eventResponse.setCustomData("TRF_BZC_STS_CD", list);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3501 : Retrieve<br>
	 * Tariff Code의 General Information을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffGeneralInformation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3501Event event = (EsmPri3501Event) e;
		TariffGeneralInformationBC command = new TariffGeneralInformationBCImpl();

		try {
			RsltPriTrfBzcListVO vo = command.searchTariffGeneralInformation(event.getPriTrfBzcVO(), account);
			eventResponse.setRsVoList(vo.getRsltPriTrfBzcVOs());
			eventResponse.setRsVoList(vo.getRsltPriTrfBzcRoutPntVOs());
			eventResponse.setRsVoList(vo.getRsltPriTrfBzcRoutPntVOs2());

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3501 : [Save]<br>
	 * Tariff Code의 General Information을 저장한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTariffGeneralInformation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3501Event event = (EsmPri3501Event) e;
		TariffGeneralInformationBC command = new TariffGeneralInformationBCImpl();
		try {
			PriTrfBzcVO priTrfBzcVO = event.getTrfBzcMnVO().getPriTrfBzcVO();
			int cnt1 = command.searchTariffCodeExistCheck(priTrfBzcVO);
			int cnt2 = command.searchTariffBasicExistCheck(priTrfBzcVO);

			if (priTrfBzcVO != null) {
				// Exception 처리 : 1.Tariff Code에 대한 무결성 제약 조건
				if (cnt1 == 0)
					throw new EventException(new ErrorHandler("PRI06003", new String[] {}).getMessage());

				// Exception 처리 : 2.Tariff Basic Info에 대한 무결성 제약조건
				if (("I".equals(priTrfBzcVO.getIbflag()) && cnt2 > 0))
					throw new EventException(new ErrorHandler("PRI01135", new String[] { "Tariff General Information" }).getMessage());
				// Exception 처리 : 3.삭제된 Basic 데이터에 Basic 또는 Basic Rout Point update 하는 경우
				if (!"I".equals(priTrfBzcVO.getIbflag()) && cnt2 == 0)
					throw new EventException(new ErrorHandler("PRI01135", new String[] { "Tariff General Information" }).getMessage());
			}

			begin();
			command.manageTariffGeneralInformation(event.getTrfBzcMnVO(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
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
	 * ESM_PRI_3501 : [Delete]<br>
	 * Tariff Code의 General Information을 삭제한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeTariffGeneralInformation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3501Event event = (EsmPri3501Event) e;
		TariffGeneralInformationBC command = new TariffGeneralInformationBCImpl();
		try {
			PriTrfBzcVO priTrfBzcVO = event.getPriTrfBzcVO();
			int cnt = command.searchTariffBasicExistCheck(priTrfBzcVO);

			// Exception 처리 : 3.삭제된 Basic 데이터에 Basic delete 하는 경우
			if (cnt == 0)
				throw new EventException(new ErrorHandler("PRI01135", new String[] { "Tariff General Information" }).getMessage());

			begin();
			command.removeTariffGeneralInformation(event.getPriTrfBzcVO());
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00102", new String[] {}).getUserMessage());
			commit();
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
	 * ESM_PRI_3501 : [Request]<br>
	 * Tariff Code의 General Information을 Request한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse requestTariffGeneralInformation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3501Event event = (EsmPri3501Event) e;
		TariffGeneralInformationBC command = new TariffGeneralInformationBCImpl();
		try {
			PriTrfBzcVO priTrfBzcVO = event.getTrfBzcMnVO().getPriTrfBzcVO();
			int cnt = command.searchTariffBasicExistCheck(priTrfBzcVO);

			// Exception 처리 : 4.삭제된 Basic 데이터를 request 하는 경우
			if (cnt == 0)
				throw new EventException(new ErrorHandler("PRI01135", new String[] { "Tariff General Information" }).getMessage());

			begin();
			command.requestTariffGeneralInformation(event.getTrfBzcMnVO(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00341", new String[] { "Request" }).getUserMessage());
			commit();
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
	 * ESM_PRI_3501 : [Approve]<br>
	 * Tariff Code의 General Information을 Approve한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse approveTariffGeneralInformation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3501Event event = (EsmPri3501Event) e;
		TariffGeneralInformationBC command = new TariffGeneralInformationBCImpl();
		try {
			begin();
			command.approveTariffGeneralInformation(event.getTrfBzcMnVO(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00341", new String[] { "Approve" }).getUserMessage());
			commit();
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
	 * ESM_PRI_3501 : [Cancel]<br>
	 * Tariff Code의 General Information을 Cancel한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelTariffGeneralInformation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3501Event event = (EsmPri3501Event) e;
		TariffGeneralInformationBC command = new TariffGeneralInformationBCImpl();
		try {
			PriTrfBzcVO priTrfBzcVO = event.getTrfBzcMnVO().getPriTrfBzcVO();
			int cnt = command.searchTariffBasicExistCheck(priTrfBzcVO);

			// Exception 처리 : 5.삭제된 Basic 데이터를 cancel 하는 경우
			if (cnt == 0)
				throw new EventException(new ErrorHandler("PRI01135", new String[] { "Tariff General Information" }).getMessage());

			begin();
			command.cancelTariffGeneralInformation(event.getTrfBzcMnVO(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00341", new String[] { "Cancel" }).getUserMessage());
			commit();
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
	 * ESM_PRI_3518 : [이벤트]<br>
	 * Tariff Code의 General Information을 Amend한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse amendTariffGeneralInformation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3518Event event = (EsmPri3518Event) e;
		TariffGeneralInformationBC command = new TariffGeneralInformationBCImpl();
		try {
			begin();
			command.amendTariffGeneralInformation(event.getTrfBzcMnVO(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
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
	 * ESM_PRI_3503 : [Retrieve] <br>
	 * [Tariff Code]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3503Event event = (EsmPri3503Event) e;
		TariffCodeBC command = new TariffCodeBCImpl();

		try {
			List<SearchTariffCodeALLVO> list = command.searchTariffCodeList(event.getSearchTariffCodeALLVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3503 : [OPEN]<br>
	 * [콤보데이터]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse initTariffCodeComboData(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TariffRuleBC command = new TariffRuleBCImpl();

		RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

		try {
			list = command.searchTariffCodeList(vo);
			eventResponse.setCustomData("TARIFF_CD", list);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3505 : [Publish]<br>
	 * Tariff Code의 General Information을 Publish한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse publishTariffGeneralInformation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3505Event event = (EsmPri3505Event) e;
		TariffGeneralInformationBC command = new TariffGeneralInformationBCImpl();
		try {
			begin();
			command.publishTariffGeneralInformation(event.getTrfBzcMnVO(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00341", new String[] { "Publish" }).getUserMessage());
			commit();
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
	 * ESM_PRI_3511 : Open<br>
	 * Combo Data를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse initTariffGeneralInformationInquiryComboData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PRICommonBC command = new PRICommonBCImpl();

		RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

		try {

			// TARIFF CODE
			list = command.searchTariffCodeList(vo);
			eventResponse.setCustomData("TARIFF_CD", list);
			// STATUS
			vo.setCd("CD02395");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("TRF_BZC_STS_CD", list);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3511 : Retrieve<br>
	 * Tariff General Information List를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffGeneralInformationInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3511Event event = (EsmPri3511Event) e;
		TariffGeneralInformationBC command = new TariffGeneralInformationBCImpl();

		try {
			List<RsltPriTrfBzcVO> vo = command.searchTariffGeneralInformationInquiryList(event.getPriTrfBzcVO());
			eventResponse.setRsVoList(vo);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3511 : Sheet Double Click<br>
	 * Tariff General Information Detail을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffGeneralInformationInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3511Event event = (EsmPri3511Event) e;
		TariffGeneralInformationBC command = new TariffGeneralInformationBCImpl();

		try {
			RsltPriTrfBzcListVO vo = command.searchTariffGeneralInformationInquiry(event.getPriTrfBzcVO());
			eventResponse.setRsVoList(vo.getRsltPriTrfBzcVOs());
			eventResponse.setRsVoList(vo.getRsltPriTrfBzcRoutPntVOs());
			eventResponse.setRsVoList(vo.getRsltPriTrfBzcRoutPntVOs2());

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3515 : Open<br>
	 * Combo Data를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse initInlandRatesInquiryComboData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PRICommonBC command = new PRICommonBCImpl();
		InlandRatesBC command2 = new InlandRatesBCImpl();

		RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

		try {

			// TARIFF CODE
			list = command2.searchTariffCodeList(vo);
			eventResponse.setCustomData("TARIFF_CD", list);
			// STATUS
			vo.setCd("CD02395");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("TRF_INLND_STS_CD", list);
			// Amend Type
			vo.setCd("CD02760");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("TRF_INLND_AMDT_TP_CD", list);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3515 : Retrieve<br>
	 * Inland Rate List를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandRatesInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3515Event event = (EsmPri3515Event) e;
		InlandRatesBC command = new InlandRatesBCImpl();

		try {
			List<RsltPriTrfInlndVO> vo = command.searchInlandRatesInquiryList(event.getPriTrfInlndVO());
			eventResponse.setRsVoList(vo);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3515 : Sheet Click<br>
	 * Inland Rate Detail을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandRatesInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3515Event event = (EsmPri3515Event) e;
		InlandRatesBC command = new InlandRatesBCImpl();

		try {
			List<RsltPriTrfInlndRtVO> vo = command.searchInlandRatesInquiry(event.getPriTrfInlndRtVO());
			eventResponse.setRsVoList(vo);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3504 : [OPEN]<br>
	 * [콤보데이터]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse initTariffGeneralHistoryComboData(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TariffRuleBC command = new TariffRuleBCImpl();

		RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

		try {
			list = command.searchTariffCodeList(vo);
			eventResponse.setCustomData("TARIFF_CD", list);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3504 : [Retrieve] <br>
	 * [Tariff General Information History]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffGeneralHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3504Event event = (EsmPri3504Event) e;
		TariffGeneralInformationBC command = new TariffGeneralInformationBCImpl();

		try {
			List<PriTrfBzcHistoryVO> list = command.searchTariffGeneralHistoryList(event.getPriTrfBzcHistoryVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3504 : sheet1 double click <br>
	 * [Tariff General Information Amend History]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 * @exception EventException
	 */
	private EventResponse searchTariffGeneralAmendHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3504Event event = (EsmPri3504Event) e;
		TariffGeneralInformationBC command = new TariffGeneralInformationBCImpl();

		try {
			List<PriTrfBzcHistoryAmendVO> list = command.searchTariffGeneralAmendHistoryList(event.getPriTrfBzcHistoryAmendVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3504 : sheet2 double click <br>
	 * [Tariff General Information Amend History Detail]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffGeneralHistory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3504Event event = (EsmPri3504Event) e;
		TariffGeneralInformationBC command = new TariffGeneralInformationBCImpl();

		try {
			RsltPriTrfBzcListVO vo = command.searchTariffGeneralHistory(event.getPriTrfBzcVO());
			eventResponse.setRsVoList(vo.getRsltPriTrfBzcRoutPntVOs());
			eventResponse.setRsVoList(vo.getRsltPriTrfBzcRoutPntVOs2());

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3516 : Open<br>
	 * Combo Data를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse initInlandRatesHistoryComboData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PRICommonBC command = new PRICommonBCImpl();
		InlandRatesBC command2 = new InlandRatesBCImpl();

		RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

		try {

			// TARIFF CODE
			list = command2.searchTariffCodeList(vo);
			eventResponse.setCustomData("TARIFF_CD", list);
			// STATUS
			vo.setCd("CD02395");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("TRF_INLND_STS_CD", list);
			// Amend Type
			vo.setCd("CD02760");
			list = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("TRF_INLND_AMDT_TP_CD", list);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3516 : Retrieve<br>
	 * Inland Rates Name 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandRatesHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3516Event event = (EsmPri3516Event) e;
		InlandRatesBC command = new InlandRatesBCImpl();

		try {
			List<RsltPriTrfInlndVO> vo = command.searchInlandRatesHistoryList(event.getPriTrfInlndHistoryVO());
			eventResponse.setRsVoList(vo);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3516 : Sheet1 Click<br>
	 * Inland Rates Amend 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandRatesAmendHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3516Event event = (EsmPri3516Event) e;
		InlandRatesBC command = new InlandRatesBCImpl();

		try {
			List<RsltPriTrfInlndVO> vo = command.searchInlandRatesAmendHistoryList(event.getPriTrfInlndHistoryVO());
			eventResponse.setRsVoList(vo);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3516 : Sheet2 Click<br>
	 * Inland Rates Location 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandRatesHistory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3516Event event = (EsmPri3516Event) e;
		InlandRatesBC command = new InlandRatesBCImpl();

		try {
			List<RsltPriTrfInlndRtVO> vo = command.searchInlandRatesHistory(event.getPriTrfInlndHistoryVO());
			eventResponse.setRsVoList(vo);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3599 : Retrieve <br>
	 * Tariff Rule Diff
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 * @exception EventException
	 */
	private EventResponse searchTariffRuleDiff(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3599Event event = (EsmPri3599Event) e;
		TariffRuleBC command = new TariffRuleBCImpl();

		try {
			DiffList list = command.searchTariffRuleDiff(event.getInPriTrfRuleDiffVO());
			eventResponse.setCustomData("DIFF_LIST", list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3523 : [Retrieve]<br>
	 * [Tariff Rule Publish Cancel하기 위한 정보]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffRulePublishCancelList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3523Event event = (EsmPri3523Event) e;
		TariffRuleBC command = new TariffRuleBCImpl();

		try {
			List<RsltPriTrfRuleVO> list = command.searchTariffRulePublishCancelList(event.getPriTrfRuleVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_3523: Publish Cancel<br>
	 * [Tariff Rule]을 [Publish Cancel]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelPublishTariffRule(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3523Event event = (EsmPri3523Event) e;
		TariffRuleBC command = new TariffRuleBCImpl();

		try {
			begin();
			command.cancelPublishTariffRule(event.getPriTrfRuleVOs(), account);

			eventResponse.setUserMessage((String) new ErrorHandler("PRI01047", new String[] {}).getUserMessage());
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

	// 2012.05.07

	/**
	 * ESM_PRI_7021_01 :: Cost Table interface - Add-on Tariff TAB
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAddOnCostTraiff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri702101Event event = (EsmPri702101Event) e;
		FICCostInterfaceBC command = new FICCostInterfaceBCImpl();
		try {
			eventResponse.setRsVoList(command.searchAddOnCostTariff(event.getSvcScpCd(),event.getRhq_cd(),event.getOrg_dest_tp_cd()));
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7021_01 :: Cost I/F (Add-On)
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse managerAddOnCostTraiff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri702101Event event = (EsmPri702101Event) e;
		FICCostInterfaceBC command = new FICCostInterfaceBCImpl();
		try {
			begin();
			command.managerAddOnCostTraiff(event.getAddOnCostTraiffListVOs(), account);
			commit();
			return eventResponse;
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7021_02 :: Cost Table interface - IHC Tariff TAB
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchIHCCostTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri702102Event event = (EsmPri702102Event) e;
		FICCostInterfaceBC command = new FICCostInterfaceBCImpl();
		try {
			eventResponse.setRsVoList(command.searchIHCCostTariff(event.getSvcScpCd(), event.getCntCd(), event.getRhq_cd(), event.getOrg_dest_tp_cd()));
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7021_02 :: Cost I/F(IHC)
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse managerIHCCostTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri702102Event event = (EsmPri702102Event) e;
		FICCostInterfaceBC command = new FICCostInterfaceBCImpl();
		try {
			begin();
			command.managerIHCCostTariff(event.getIhcCostTariffInterfaceListVOs(), account);
			commit();
			return eventResponse;
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7003_01 : Feeder/IHC Tariff Inquiry - Dry Tab
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTariffInquiryListDR(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri700301Event event = (EsmPri700301Event) e;
		FeederChargeGuideLineBC command = new FeederChargeGuideLineBCImpl();
		try {
			eventResponse.setRsVoList(command.searchTariffInquiryList(event.getSearchTariffInquiryVO()));
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 *  ESM_PRI_7003_01, ESM_PRI_7003_02 : Feeder/IHC Tariff Inquiry - 버튼 색 표시를 위한 조회
	 * Add-on 의 DG service flag를 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTariffInquiryAddOnDgFlag(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri700301Event event = (EsmPri700301Event) e;
		FeederChargeGuideLineBC command = new FeederChargeGuideLineBCImpl();
		try {
			eventResponse.setRsVoList(command.searchTariffInquiryAddOnDgFlag(event.getTariffInquiryListVO()));
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_7003_02 : Feeder/IHC Tariff Inquiry - Reefer Tab
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTariffInquiryListRF(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri700302Event event = (EsmPri700302Event) e;
		FeederChargeGuideLineBC command = new FeederChargeGuideLineBCImpl();
		try {
			eventResponse.setRsVoList(command.searchTariffInquiryList(event.getSearchTariffInquiryVO()));
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7004_01 : IHC inquiry in local currency (TRO) - DR
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchIhcTariffInquiryListDR(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri700401Event event = (EsmPri700401Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			eventResponse.setRsVoList(command.searchIhcTariffInquiryList(event.getSearchIhcTariffInquiryVO()));
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_7004_02 : IHC inquiry in local currency (TRO) - RF
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchIhcTariffInquiryListRF(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri700402Event event = (EsmPri700402Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			eventResponse.setRsVoList(command.searchIhcTariffInquiryList(event.getSearchIhcTariffInquiryVO()));
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7024 :: IHC Tariff Creation & Amendment - Special Popup
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchIHCTariffList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7024Event event = (EsmPri7024Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			eventResponse.setRsVoList(command.searchSpecialCargoPopupList(event.getiHCGuidelineMainVO()));
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7027 :: IHC Country Inquiry
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCountryList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7027Event event = (EsmPri7027Event) e;
		CountryBC command = new CountryBCImpl();
		try {
			eventResponse.setRsVoList(command.searchCountryList(event.getCountryListVO()));
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7001 : Load Page <br>
	 * Retrieve basic Code List <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse initIHCGuidelineComboData(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PRICommonBC command = new PRICommonBCImpl();

		List<RsltCdListVO> customData = null;
		RsltCdListVO vo = new RsltCdListVO();

		try {
			// service scope code
			vo.setCd("CD03048");
			customData = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("SVC_SCP_CD", customData);

			// Trans. Mode
			vo.setCd("CD01720");
			customData = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("PRC_TRSP_MOD_CD", customData);

			// Term
			vo.setCd("CD01725");
			customData = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("RCV_DE_TERM_CD", customData);

			// SRC_INFO_CD
			vo.setCd("CD02198");
			customData = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("SRC_INFO_CD", customData);
			
			// Inland SVC Mode
			vo.setCd("CD03121");
			customData = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("USA_COST_TRF_SVC_MOD_CD", customData);
			
			// Amend Type
			vo.setCd("CD02760");
			customData = command.searchComCodeDescList(vo);
			eventResponse.setCustomData("IHC_TRF_AMDT_TP_CD", customData);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_7001 : Retrieve form <br>
	 * Retrieve form data <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIHCGuidelineMain(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7001Event event = (EsmPri7001Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			List<IHCGuidelineMainVO> list = command.searchIHCGuidelineMain(event.getiHCGuidelineMainVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_7001_01 : Retrieve sheet <br>
	 * Retrieve sheet data <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIHCGuidelineDetailDry(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri700101Event event = (EsmPri700101Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			eventResponse.setRsVoList(command.searchIHCGuidelineDetail(event.getiHCGuidelineDetailVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_7001_02 : Retrieve sheet <br>
	 * Retrieve sheet data <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIHCGuidelineDetailReefer(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri700102Event event = (EsmPri700102Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			eventResponse.setRsVoList(command.searchIHCGuidelineDetail(event.getiHCGuidelineDetailVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_7001 : SAVE <br>
	 * Save data <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageIHCGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7001Event event = (EsmPri7001Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			begin();
			command.manageIHCGuidelineMain(event.getiHCGuidelineMainVO(), account);
			// eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
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
	 * ESM_PRI_7001_01 : SAVE <br>
	 * Save data <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageIHCGuidelineDetailDry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri700101Event event = (EsmPri700101Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			begin();
			command.manageIHCGuidelineDetail(event.getiHCGuidelineMainVO(), event.getiHCGuidelineDetailVOs(), account);
			// eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
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
	 * ESM_PRI_7001_02 : SAVE <br>
	 * Save data <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageIHCGuidelineDetailReefer(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri700102Event event = (EsmPri700102Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			begin();
			command.manageIHCGuidelineDetail(event.getiHCGuidelineMainVO(), event.getiHCGuidelineDetailVOs(), account);
			// eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
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
	 * ESM_PRI_7001 : Cancel <br>
	 * Cancel <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelIHCGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7001Event event = (EsmPri7001Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			begin();
			command.cancelIHCGuidelineMain(event.getiHCGuidelineMainVO(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
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
	 * ESM_PRI_7001 : Confirm <br>
	 * Confirm <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmIHCGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7001Event event = (EsmPri7001Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			begin();
			command.confirmIHCGuidelineMain(event.getiHCGuidelineMainVO(), event.getPriTrfIhcProgVO(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
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
	 * ESM_PRI_7002 : Amend <br>
	 * Amend <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse amendIHCGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7002Event event = (EsmPri7002Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			begin();
			command.amendIHCGuideline(event.getiHCGuidelineMainVO(), event.getPriTrfIhcProgVO(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
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
	 * ESM_PRI_7001 : Confirm <br>
	 * Retrieve pre version eff_dt <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkPreIHCGuideline(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7001Event event = (EsmPri7001Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			List<IHCGuidelineMainVO> list = command.checkPreIHCGuideline(event.getiHCGuidelineMainVO());

			if (list.size() > 0) {
				eventResponse.setETCData("eff_dt", list.get(0).getEffDt());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_7001 : Confirm <br>
	 * Retrieve pre version eff_dt <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkMaxCostTrfNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7001Event event = (EsmPri7001Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			 List<IHCGuidelineMainVO> list = command.checkMaxCostTrfNo(event.getiHCGuidelineMainVO());
			
			 if (list.size() > 0) {
			 eventResponse.setETCData("cost_trf_no", list.get(0).getCostTrfNo());
			 }
//			eventResponse.setRsVoList(command.checkMaxCostTrfNo(event.getiHCGuidelineMainVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_7011 : Retrieve form <br>
	 * Retrieve form data <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFDRMain(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7011Event event = (EsmPri7011Event) e;
		FeederChargeGuideLineBC command = new FeederChargeGuideLineBCImpl();
		try {
			List<FDRMainVO> list = command.searchFDRMain(event.getfDRMainVO());
			eventResponse.setRsVoList(list);

			if (list.size() > 0) {
				eventResponse.setETCData("fdr_trf_no", list.get(0).getFdrTrfNo());
				eventResponse.setETCData("amdt_seq", list.get(0).getAmdtSeq());
				eventResponse.setETCData("cre_dt", list.get(0).getCreDt());
				eventResponse.setETCData("eff_dt", list.get(0).getEffDt());
				eventResponse.setETCData("exp_dt", list.get(0).getExpDt());
				eventResponse.setETCData("cfm_dt", list.get(0).getCfmDt());
				eventResponse.setETCData("cfm_usr", list.get(0).getCfmUsr());
				eventResponse.setETCData("cre_usr", list.get(0).getCreUsr());
				eventResponse.setETCData("fic_prop_sts_cd", list.get(0).getFicPropStsCd());
				eventResponse.setETCData("fic_prop_sts_nm", list.get(0).getFicPropStsNm());
				eventResponse.setETCData("prc_io_bnd_cd", list.get(0).getPrcIoBndCd());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_7011 : Retrieve sheet <br>
	 * Retrieve sheet data <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFDRDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7011Event event = (EsmPri7011Event) e;
		FeederChargeGuideLineBC command = new FeederChargeGuideLineBCImpl();
		try {
			eventResponse.setRsVoList(command.searchFDRDetail(event.getfDRMainVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_7011 : SAVE <br>
	 * Save data <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageFDR(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7011Event event = (EsmPri7011Event) e;
		FeederChargeGuideLineBC command = new FeederChargeGuideLineBCImpl();
		try {
			begin();
			command.manageFDR(event.getfDRMainVO(), event.getfDRDetailVOs(), account);
			// eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
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
	 * ESM_PRI_7011 : Cancel <br>
	 * Cancel <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelFDR(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7011Event event = (EsmPri7011Event) e;
		FeederChargeGuideLineBC command = new FeederChargeGuideLineBCImpl();
		try {
			begin();
			command.cancelFDR(event.getfDRMainVO(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
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
	 * ESM_PRI_7011 : Confirm <br>
	 * Confirm <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmFDR(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7011Event event = (EsmPri7011Event) e;
		FeederChargeGuideLineBC command = new FeederChargeGuideLineBCImpl();
		try {
			begin();
			command.confirmFDR(event.getfDRMainVO(), event.getfDRProgVO(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
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
	 * ESM_PRI_7012 : Amend <br>
	 * Amend <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse amendFDR(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7012Event event = (EsmPri7012Event) e;
		FeederChargeGuideLineBC command = new FeederChargeGuideLineBCImpl();
		try {
			begin();
			command.amendFDR(event.getfDRMainVO(), event.getfDRProgVO(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
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
	 * ESM_PRI_7011 : Confirm <br>
	 * Retrieve pre version eff_dt <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkPreFDR(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7011Event event = (EsmPri7011Event) e;
		FeederChargeGuideLineBC command = new FeederChargeGuideLineBCImpl();
		try {
			List<FDRMainVO> list = command.checkPreFDR(event.getfDRMainVO());

			if (list.size() > 0) {
				eventResponse.setETCData("eff_dt", list.get(0).getEffDt());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_7011 : Amend <br>
	 * Retrieve MAX COST_TRF_NO <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkMaxCostTrfNoFDR(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7011Event event = (EsmPri7011Event) e;
		FeederChargeGuideLineBC command = new FeederChargeGuideLineBCImpl();
		try {
			eventResponse.setRsVoList(command.checkMaxCostTrfNoFDR(event.getfDRMainVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_7013 : EUR Add-on Guideline Creation / Amend – Load Excel <br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse uploadAddonCreation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7013Event event = (EsmPri7013Event) e;
		FeederChargeGuideLineBC command = new FeederChargeGuideLineBCImpl();
		try {
			begin();
			FDRDetailVO fdrDetailVO = event.getFdrDetailVO();
			fdrDetailVO.setCreUsrId(account.getUsr_id());
			fdrDetailVO.setUpdUsrId(account.getUsr_id());

			command.uploadAddonCreation(fdrDetailVO, event.getPriTrfFdrRtVOs());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_7013 : EUR Add-on Guideline Creation / Amend – Load Excel <br>
	 * Point/Base Port 코드의 유효성 체크
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse uploadAddonCreationCheck(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7013Event event = (EsmPri7013Event) e;
		FeederChargeGuideLineBC command = new FeederChargeGuideLineBCImpl();
		try {
			List<String> rsltList = command.uploadAddonCreationCheck(event.getPriTrfFdrRtVOs());
			eventResponse.setETCData("CHECK_CODE", rsltList.toString().replaceAll(Pattern.quote("["), "").replaceAll(Pattern.quote("]"), ""));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_7013 : EUR Add-on Guideline Creation / Amend – Load Excel <br>
	 * Feeder 상태를 확인하기 위해
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchFeederStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7013Event event = (EsmPri7013Event) e;
		FeederChargeGuideLineBC command = new FeederChargeGuideLineBCImpl();
		try {
			String rsltVal = command.searchFeederStatus(event.getFdrDetailVO());
			eventResponse.setETCData("CHK_STATUS", rsltVal);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_7013 : EUR Add-on Guideline Creation / Amend – Load Excel <br>
	 * 서비스 코드에 따른 RHQ_CD 조회
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse comboFdrRhqCdList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7013Event event = (EsmPri7013Event) e;
		FeederChargeGuideLineBC command = new FeederChargeGuideLineBCImpl();
		try {
			eventResponse.setRsVoList(command.comboFdrRhqCdList(event.getFdrDetailVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_7013 : EUR Add-on Guideline Creation / Amend – Load Excel <br>
	 * location 코드 존재 여부 체크
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkLocCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7013Event event = (EsmPri7013Event) e;
		FeederChargeGuideLineBC command = new FeederChargeGuideLineBCImpl();
		try {
			eventResponse.setETCData("CHK_STATUS", String.valueOf(command.checkLocCode(event.getLocCd())));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_7025 : IHC Tariff Amendment History Main <br>
	 * Retrieve IHC Tariff Amendment History Main <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIHCAmendmentHistoryMain(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7025Event event = (EsmPri7025Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			eventResponse.setRsVoList(command.searchIHCAmendmentHistoryMain(event.getSearchIHCAmendmentHistoryMainVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_7025 : IHC Tariff Amendment History Main <br>
	 * DG, Overweight 팝업 버튼 색 변경을 위한 조회 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIHCDgOverWeightFlag(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7025Event event = (EsmPri7025Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			eventResponse.setRsVoList(command.searchIHCDgOverWeightFlag(event.getIHCTariffInquiryListVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	

	/**
	 * ESM_PRI_7025_01 : IHC Tariff Amendment History Detail <br>
	 * Retrieve IHC Tariff Amendment History detail - DRY <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIHCAmendmentHistoryDetailDR(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri702501Event event = (EsmPri702501Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			eventResponse.setRsVoList(command.searchIHCAmendmentHistoryDetail(event.getSearchIHCAmendmentHistoryDetailVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_7025_02 : IHC Tariff Amendment History Detail <br>
	 * Retrieve IHC Tariff Amendment History detail - RF <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIHCAmendmentHistoryDetailRF(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri702502Event event = (EsmPri702502Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			eventResponse.setRsVoList(command.searchIHCAmendmentHistoryDetail(event.getSearchIHCAmendmentHistoryDetailVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_7026 : FDR Tariff Amendment History Main <br>
	 * Retrieve FDR Tariff Amendment History Main <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFDRAmendmentHistoryMain(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7026Event event = (EsmPri7026Event) e;
		FeederChargeGuideLineBC command = new FeederChargeGuideLineBCImpl();
		try {
			eventResponse.setRsVoList(command.searchFDRAmendmentHistoryMain(event.getSearchFDRAmendmentHistoryMainVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_7026 : Add-on Tariff Amendment History Detail <br>
	 * Retrieve Add-on Tariff Amendment History detail <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFDRAmendmentHistoryDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7026Event event = (EsmPri7026Event) e;
		FeederChargeGuideLineBC command = new FeederChargeGuideLineBCImpl();
		try {
			eventResponse.setRsVoList(command.searchFDRAmendmentHistoryDetail(event.getSearchFDRAmendmentHistoryDetailVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_7028 : Add-On Tariff Amendment DG Cargo Inquiry <br>
	 * Retrieve Add-On Tariff Amendment DG Cargo Inquiry <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFDRDGSurcharge(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7028Event event = (EsmPri7028Event) e;
		FeederChargeGuideLineBC command = new FeederChargeGuideLineBCImpl();
		try {
			eventResponse.setRsVoList(command.searchFDRDGSurcharge(event.getfDRDGSurchargeVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_7006 : Check Copy Service Scope - SAVE validation 1 <br>
	 * check that to be copied country in selected scope or not <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCopyServiceScope(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7006Event event = (EsmPri7006Event) e;
		FICCostInterfaceBC command = new FICCostInterfaceBCImpl();
		try {
			eventResponse.setRsVoList(command.checkCopyServiceScope(event.getCheckCopyServiceScopeVOs()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_7006 : Check Copy Service Scope - SAVE validation 2 <br>
	 * check exist IHC tariff's status <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCopyServiceScopeInitial(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7006Event event = (EsmPri7006Event) e;
		FICCostInterfaceBC command = new FICCostInterfaceBCImpl();
		try {
			eventResponse.setRsVoList(command.checkCopyServiceScopeInitial(event.getCheckCopyServiceScopeVOs()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_7006 : Check Copy Service Scope - SAVE validation 3 <br>
	 * check exist IHC tariff's effective date <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCopyServiceScopeEffdt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7006Event event = (EsmPri7006Event) e;
		FICCostInterfaceBC command = new FICCostInterfaceBCImpl();
		try {
			eventResponse.setRsVoList(command.checkCopyServiceScopeEffdt(event.getCheckCopyServiceScopeVOs()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_7006 : Copy IHC
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageIHCCopy(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7006Event event = (EsmPri7006Event) e;
		FICCostInterfaceBC command = new FICCostInterfaceBCImpl();
		IHCGuideLineBC command2 = new IHCGuideLineBCImpl();
		try {
			begin();
			command2.confirmIHCExpDt(event.getiHCGuidelineMainVOs(), account);
			command.manageIHCCopy(event.getCopyTariffIhcVOs(), account);
			commit();
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
	 * ESM_PRI_7007 : Check Copy Service Scope - SAVE validation 1 <br>
	 * check exist FDR tariff's status <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkFDRCopyServiceScopeInitial(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7007Event event = (EsmPri7007Event) e;
		FICCostInterfaceBC command = new FICCostInterfaceBCImpl();
		try {
			eventResponse.setRsVoList(command.checkFDRCopyServiceScopeInitial(event.getCheckFDRCopyServiceScopeVOs()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_7007 : Check Copy Service Scope - SAVE validation 2 <br>
	 * check exist FDR tariff's effective date <br>
	 * 
	 * @param CheckFDRCopyServiceScopeVO[] checkFDRCopyServiceScopeVOs
	 * @return List<CheckFDRCopyServiceScopeVO>
	 * @throws EventException
	 */
	private EventResponse checkFDRCopyServiceScopeEffdt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7007Event event = (EsmPri7007Event) e;
		FICCostInterfaceBC command = new FICCostInterfaceBCImpl();
		try {
			eventResponse.setRsVoList(command.checkFDRCopyServiceScopeEffdt(event.getCheckFDRCopyServiceScopeVOs()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_7007 : Copy FDR
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageFDRCopy(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7007Event event = (EsmPri7007Event) e;
		FICCostInterfaceBC command = new FICCostInterfaceBCImpl();
		FeederChargeGuideLineBC command2 = new FeederChargeGuideLineBCImpl();
		try {
			begin();
			command2.confirmFDRExpDt(event.getfDRMainVOs(), account);
			command.manageFDRCopy(event.getCopyTariffFdrVOs(), account);
			commit();
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
	 * ESM_PRI_7031 : Retrieve form <br>
	 * Retrieve form data for US <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUsIHCGuidelineMain(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7031Event event = (EsmPri7031Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			List<IHCGuidelineMainVO> list = command.searchIHCGuidelineMain(event.getiHCGuidelineMainVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_7031 : SAVE <br>
	 * Save data for US<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageUsIHCGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7031Event event = (EsmPri7031Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			begin();
			command.manageIHCGuidelineMain(event.getiHCGuidelineMainVO(), account);
			commit();
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
	 * ESM_PRI_7031 : Cancel <br>
	 * Cancel for US<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelUsIHCGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7031Event event = (EsmPri7031Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			begin();
			command.cancelIHCGuidelineMain(event.getiHCGuidelineMainVO(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
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
	 * ESM_PRI_7031_01 : Retrieve sheet <br>
	 * Retrieve sheet data for US<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUsIHCGuidelineDetailDry(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri703101Event event = (EsmPri703101Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			eventResponse.setRsVoList(command.searchIHCGuidelineDetail(event.getiHCGuidelineDetailVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_7031_02 : Retrieve sheet <br>
	 * Retrieve sheet data <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUsIHCGuidelineDetailReefer(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri703102Event event = (EsmPri703102Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			eventResponse.setRsVoList(command.searchIHCGuidelineDetail(event.getiHCGuidelineDetailVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_7031_01 : SAVE <br>
	 * Save data for US - DR <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageUsIHCGuidelineDetailDry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri703101Event event = (EsmPri703101Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			begin();
			command.manageUsIHCGuidelineDetail(event.getiHCGuidelineMainVO(), event.getiHCGuidelineDetailVOs(), account);
			commit();
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
	 * ESM_PRI_7031_02 : SAVE <br>
	 * Save data for US - RF<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageUsIHCGuidelineDetailReefer(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri703102Event event = (EsmPri703102Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			begin();
			command.manageUsIHCGuidelineDetail(event.getiHCGuidelineMainVO(), event.getiHCGuidelineDetailVOs(), account);
			commit();
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
	 * ESM_PRI_7031 : Confirm <br>
	 * Retrieve pre version eff_dt <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkUsMaxCostTrfNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7031Event event = (EsmPri7031Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			 List<IHCGuidelineMainVO> list = command.checkMaxCostTrfNo(event.getiHCGuidelineMainVO());
			
			 if (list.size() > 0) {
			 eventResponse.setETCData("cost_trf_no", list.get(0).getCostTrfNo());
			 }
//			eventResponse.setRsVoList(command.checkMaxCostTrfNo(event.getiHCGuidelineMainVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_7031 : Confirm <br>
	 * Retrieve pre version eff_dt <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkUsPreIHCGuideline(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7031Event event = (EsmPri7031Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			List<IHCGuidelineMainVO> list = command.checkPreIHCGuideline(event.getiHCGuidelineMainVO());

			if (list.size() > 0) {
				eventResponse.setETCData("eff_dt", list.get(0).getEffDt());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_7031 : Confirm <br>
	 * Confirm for US<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmUsIHCGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7031Event event = (EsmPri7031Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			begin();
			command.confirmIHCGuidelineMain(event.getiHCGuidelineMainVO(), event.getPriTrfIhcProgVO(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
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
	 * ESM_PRI_7031_01 : Retrieve sheet <br>
	 * Retrieve Inland SVC Mode data for US<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUsInlandServiceModeTotalDry(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri703101Event event = (EsmPri703101Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			eventResponse.setRsVoList(command.searchUsInlandServiceModeTotal(event.getSearchUsInlandServiceModeTotalVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_7033 : Route Retrieve  <br>
	 * Route Retrieve <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUsRailIHCGuidelineDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7033Event event = (EsmPri7033Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			eventResponse.setRsVoList(command.searchUsRailIHCGuidelineDetail(event.getiHCGuidelineDetailVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_7033 : Apply to Tariff <br>
	 * Update Rate data<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageUsRailIHCGuidelineDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7033Event event = (EsmPri7033Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			begin();
			command.manageUsRailIHCGuidelineDetail(event.getiHCGuidelineDetailVOs(), account);
			commit();
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
	 * ESM_PRI_7033 : Check  <br>
	 * Check Point - Base port pair <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkUsRailIHCGuidelineDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7033Event event = (EsmPri7033Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			eventResponse.setRsVoList(command.checkUsRailIHCGuidelineDetail(event.getiHCGuidelineDetailVOs()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_7032 : US IHC Tariff No. Combo <br>
	 * Retrieve US IHC Tariff No. Combo <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUsIHCAmendmentHistoryMainCombo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7032Event event = (EsmPri7032Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();

		try {
			eventResponse.setRsVoList(command.searchIHCAmendmentHistoryMainCombo(event.getSearchIHCAmendmentHistoryMainVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_7032 : Retrieve Max seq. <br>
	 * Retrieve US IHC Tariff Amendment History Max seq. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUsIHCAmendmentHistoryMainMaxSeq(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7032Event event = (EsmPri7032Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			List<SearchIHCAmendmentHistoryMainVO> list = command.searchIHCAmendmentHistoryMainMaxSeq(event.getSearchIHCAmendmentHistoryMainVO());

			if (list.size() > 0) {
				eventResponse.setETCData("ihc_trf_no", list.get(0).getIhcTrfNo());
				eventResponse.setETCData("amdt_seq", list.get(0).getAmdtSeq());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_7032 : US IHC Tariff Amendment History Main <br>
	 * Retrieve IHC Tariff Amendment History Main <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUsIHCAmendmentHistoryMain(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7032Event event = (EsmPri7032Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			eventResponse.setRsVoList(command.searchIHCAmendmentHistoryMain(event.getSearchIHCAmendmentHistoryMainVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_7032_01 : US IHC Tariff Amendment History Detail <br>
	 * Retrieve US IHC Tariff Amendment History detail - DRY <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUsIHCAmendmentHistoryDetailDR(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri703201Event event = (EsmPri703201Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			eventResponse.setRsVoList(command.searchIHCAmendmentHistoryDetail(event.getSearchIHCAmendmentHistoryDetailVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_7032_02 : US IHC Tariff Amendment History Detail <br>
	 * Retrieve US IHC Tariff Amendment History detail - RF <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUsIHCAmendmentHistoryDetailRF(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri703202Event event = (EsmPri703202Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			eventResponse.setRsVoList(command.searchIHCAmendmentHistoryDetail(event.getSearchIHCAmendmentHistoryDetailVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_7034 : Retrieve <br>
	 * Retrieve Inland add-on inquiry in local currency (TRO) <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUsTariffInquiryList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7034Event event = (EsmPri7034Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			eventResponse.setRsVoList(command.searchUsTariffInquiryList(event.getSearchUsTariffInquiryListVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_7031 : Confirm <br>
	 * validation check 1 - total value is 0 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkUsIHCTariffTotal(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7031Event event = (EsmPri7031Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			List<SearchUsInlandServiceModeTotalVO> list = command.checkUsIHCTariffTotal(event.getiHCGuidelineMainVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_7031 : Confirm <br>
	 * validation check 2 - rate tariff tuning or not <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkUsIHCTariffTuning(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7031Event event = (EsmPri7031Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			List<SearchUsInlandServiceModeTotalVO> list = command.checkUsIHCTariffTuning(event.getiHCGuidelineMainVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_7001_02 : Save  <br>
	 * Check Add RF IHC GuidelineDetail <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkAddRFIHCGuidelineDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri700102Event event = (EsmPri700102Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			eventResponse.setRsVoList(command.checkAddRFIHCGuidelineDetail(event.getiHCGuidelineDetailVOs()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_7035 : Delete from Tariff <br>
	 * Delete US Route<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageUsRoute(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7035Event event = (EsmPri7035Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			begin();
			command.manageUsRoute(event.getiHCGuidelineDetailVOs(), account);
			commit();
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
	 * ESM_PRI_7035 : Check  <br>
	 * Check Point - Base port pair <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkUsRoute(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7035Event event = (EsmPri7035Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			eventResponse.setRsVoList(command.checkUsRailIHCGuidelineDetail(event.getiHCGuidelineDetailVOs()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_7014 : MULTI  <br>
	 * IHC Guideline Creation / Amend ad Excel <br>
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse uploadIHCCreation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7014Event event = (EsmPri7014Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			begin();
			IHCDetailVO ihcDetailVO = event.getIHCDetailVO();
			ihcDetailVO.setCreUsrId(account.getUsr_id());
			ihcDetailVO.setUpdUsrId(account.getUsr_id());

			eventResponse.setETCData("BackEndJobKey", command.uploadIHCCreation(ihcDetailVO, event.getPriTrfIHCRtVOs()));
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * ESM_PRI_7014 : SEARCH01  <br>
	 * IHC Guideline Creation / Amend ad Excel <br>
	 * IHC의 Status를 확인한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchIHCStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7014Event event = (EsmPri7014Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			String rsltVal = command.searchIHCStatus(event.getIHCDetailVO());
			eventResponse.setETCData("CHK_STATUS", rsltVal);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * ESM_PRI_7014 : SEARCH  <br>
	 * IHC Guideline Creation / Amend ad Excel <br>
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse uploadIHCCreationCheck(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7014Event event = (EsmPri7014Event) e;
		IHCGuideLineBC command = new IHCGuideLineBCImpl();
		try {
			List<String> rsltList = command.uploadIHCCreationCheck(event.getPriTrfIHCRtVOs());
			eventResponse.setETCData("CHECK_CODE", rsltList.toString().replaceAll(Pattern.quote("["), "").replaceAll(Pattern.quote("]"), ""));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_7022 : [OPEN]<br>
	 * [콤보데이터]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse initTariffCodeMappingComboData(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PRICommonBC command = new PRICommonBCImpl();
		InlandRatesBC command2 = new InlandRatesBCImpl();

		RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

		try {
			// TARIFF CODE
			list = command2.searchTariffCodeList(vo);
			eventResponse.setCustomData("TRF_CD", list);
//			eventResponse.setRsVoList(list);
			
			// COUNTRY CODE, COUNTRY NAME
			list = command.searchAocTariffCountryList(vo);
			eventResponse.setCustomData("CNT_CD", list);
//			eventResponse.setRsVoList(list);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * ESM_PRI_7022 : 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffCodeMapping(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7022Event event = (EsmPri7022Event) e;
		FICCostInterfaceBC command = new FICCostInterfaceBCImpl();
		try {
			List<TariffCodeMappingVO> list = command.searchTariffCodeMapping();
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * ESM_PRI_7022 : 저장<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTariffCodeMapping(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri7022Event event = (EsmPri7022Event) e;
		FICCostInterfaceBC command = new FICCostInterfaceBCImpl();
		
		TariffCodeMappingVO[] tariffCodeMappingVOs = event.getTariffCodeMappingVOs();

        try {
            begin();
            command.manageTariffCodeMapping(tariffCodeMappingVOs, account);
            commit();
            eventResponse.setUserMessage("");
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
	
}