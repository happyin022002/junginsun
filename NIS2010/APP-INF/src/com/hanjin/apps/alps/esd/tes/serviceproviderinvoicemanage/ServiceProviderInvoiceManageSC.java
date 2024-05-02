/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ServiceProviderInvoiceManageSC.java
*@FileTitle : Off-dock CY Invoice 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-14
*@LastModifier : byungheeyoo
*@LastVersion : 1.0
* 2006-09-14 byungheeyoo
* 1.0 최초 생성
* 2009-03-11 : 성능 log 관련 기능 추가
* 2009-03-12 : 성능 log 관련 TRY 구분 추가
* 2009-04-27 : 날짜 주석 추가 및 수정  
* 2009-08-27 [PJM-200900072] : EDI manual cntr 목록 조회 
* 2010-11-11 박재흥 [CHM-201006940-01] INV AUTO CALC CHECK
* 2010-12-03 박재흥 [] INV AUTO CALC CHECK시 SELTOB는 무조건 통과
* 2011-09-27 윤태승 [] 34주차 Java application 소스 품질 결함 조치
* 2011-10-13: [CHM-201113119] [TES] HIT의 TES invoice eBilling 2단계(invoice PDF 수신) 개발 진행 요청 - TEST용
* 2011-10-25 윤태승 [] 34주차 Java application 소스 품질 결함 조치 추가 수정
* 2012-03-22 오요한 [CHM-201216589][TES] HPC KHH 터미널과 Invoice eBilling 수신 구축 수정
* 2012-06-20 유병희 [CHM-201217209][TES] Terminal Invoice eBilling 추진 --- ECT Terminal & Euromax Terminal
* 2014-06-19 유병희 [CHM-201429211][TES] TES: Double call시 Target yard에서 Get cntr 기능 추가 
=========================================================*/

package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage;

import java.util.List;

import com.hanjin.apps.alps.esd.tes.common.tescommon.basic.TESCommonBC;
import com.hanjin.apps.alps.esd.tes.common.tescommon.basic.TESCommonBCImpl;
import com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.basic.TESInvoiceCommonBC;
import com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.basic.TESInvoiceCommonBCImpl;
import com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.event.TESInvoiceCommonEvent;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.basic.TESeBillingCommonBCImpl;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.event.TESeBillingEvent;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.basic.CARIssueTransferSlipManageBC;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.basic.CARIssueTransferSlipManageBCImpl;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0023Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0024Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0025Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0078Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0080Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0100Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0101Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.vo.CARIssueTransferSlipManageCommonVO;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.invoiceprocessingauditmanage.basic.InvoiceProcessingAuditManageBC;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.invoiceprocessingauditmanage.basic.InvoiceProcessingAuditManageBCImpl;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.invoiceprocessingauditmanage.event.EsdTes0015Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.basic.MarineTerminalInvoiceManageBC;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.basic.MarineTerminalInvoiceManageBCImpl;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes0001Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes0012Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes0013Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes0014Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes0017Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes9001Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes9010Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes9232Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes9300Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes9500Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.vo.SearchCostCodeDetailListVO;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.basic.MarineTerminalStorageInvoiceManageBC;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.basic.MarineTerminalStorageInvoiceManageBCImpl;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event.EsdTes0009Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event.EsdTes0019Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event.EsdTes9142Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event.EsdTes9152Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event.EsdTes9234Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event.EsdTes9254Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.basic.OffdockCYInvoiceManageBC;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.basic.OffdockCYInvoiceManageBCImpl;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes0004Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes0018Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9030Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9034Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9050Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9074Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9075Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9140Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9150Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9233Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9240Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9253Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.basic.OndockRailChargeInvoiceManageBC;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.basic.OndockRailChargeInvoiceManageBCImpl;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event.EsdTes0064Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event.EsdTes0068Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event.EsdTes9060Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event.EsdTes9130Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event.EsdTes9231Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event.EsdTes9251Event;
import com.hanjin.bizcommon.approval.util.ApprovalUtil;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrInfoVO;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.table.ComBakEndJbVO;
import com.hanjin.syscommon.common.table.ApInvHdrVO;
import com.hanjin.syscommon.common.table.TesEdiSoHdrVO;
import com.hanjin.syscommon.common.table.TesJbExePerfLogVO;
import com.hanjin.syscommon.common.table.TesN3rdPtyIfVO;
import com.hanjin.syscommon.common.table.TesTmlSoCntrListVO;

/**
 * ENIS-ESD Business Logic ServiceCommand<br>
 * - ENIS-ESD에 대한 비지니스 트랜잭션을 처리한다.<br>
 *
 * @author byungheeyoo
 * @see ESD_TES_004EventResponse,OffdockCYInvoiceManageDBDAO 참조
 * @since J2EE 1.4 
 */
public class ServiceProviderInvoiceManageSC extends ServiceCommandSupport {
	// Login User Information
	@SuppressWarnings("unused")
	private SignOnUserAccount account = null;

	/**
	 * ESD 업무 시나리오 선행작업<br>
	 * OffdockCYInvoiceManage업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() { 
		try {
			// 일단 comment --> 로그인 체크 부분
			account=getSignOnUserAccount();
		} catch (Exception e) {
			log.error("ServiceProviderInvoiceManageSC 선행 작업 시 오류 " + e.toString(), e);
		}
	} 

	/**
	 * ESD 업무 시나리오 마감작업<br>
	 * OffdockCYInvoiceManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("ServiceProviderInvoiceManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ENIS-ESD 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event event object
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {

		EventResponse eventResponse = null;
		log.debug("\n\n SC ... event name : " + e.getEventName());

		/** Yoo. 시작 ***/
		if (e.getEventName().equalsIgnoreCase("EsdTes0004Event")) {
			log.debug("\n##################"+e.getEventName()+" - SC.e.getFormCommand() : "+e.getFormCommand().getCommand() + "##################\n");

			if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = createOffdockCYInvoiceBasicInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOffdockCYInvoiceBasicInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {		//Header 정보
				eventResponse = searchOffdockCYCostCalcSts(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {		//chk dgit
				eventResponse = checkDigitOffdock2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {		//Container List(CO, DC) Search
				eventResponse = searchOffdockCYContainerList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {	//Cost Calc. 자동계산하기 
				eventResponse = calOffdockCYInvoiceCost(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {	//DTL 전체 조회
				eventResponse = searchOffdockCYInvoiceDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {	//get all sheets
				eventResponse = searchOffdockCYInvoiceAllSheets(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				new TESInvoiceCommonBCImpl().checkInvoiceStatus(((EsdTes0004Event)e).getTesTmlSoHdrVO(),TESInvoiceCommonBC.INV_STS_RC);
				eventResponse = modifyOffdockCYInvoice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {		//reject
				new TESInvoiceCommonBCImpl().checkInvoiceStatus(((EsdTes0004Event)e).getTesTmlSoHdrVO(),TESInvoiceCommonBC.INV_STS_RC);
				eventResponse = modifyOffdockCYInvoiceReject(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {		// 동시에 COIN, DSCP, CALC.TMNL, CALC.ByDay sheet의 data를 삭제
				eventResponse = removeOffdockCYInvoice01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE02)) {		//CALC.ByPool sheet의 data를 삭제
				eventResponse = removeOffdockCYInvoice02(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE03)) {		//Calc.TMNL과 Calc.ByDay sheet의 자동 계산 시 기존 data 삭제
				eventResponse = removeOffdockCYInvoiceAutoCalcData(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE04)) {
				eventResponse = removeOffdockCYInvoiceAutoCalcDataAllCalcTab(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE05)) {		//Calc.ByPool sheet의 자동 계산 data를 삭제
				eventResponse = removeOffdockCYInvoiceAutoCalcData2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE06)) {		//Calc.TMNL, Calc.ByDay, Calc.ByPool sheet의 자동 계산 data를 삭제
				eventResponse = removeOffdockCYInvoiceAllCalcData(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {			//Container List CUD
				new TESInvoiceCommonBCImpl().checkInvoiceStatus(((EsdTes0004Event)e).getTesTmlSoHdrVO(),TESInvoiceCommonBC.INV_STS_RC);
				eventResponse = createOffdockCYInvoiceContainerList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				new TESInvoiceCommonBCImpl().checkInvoiceStatus(((EsdTes0004Event)e).getTesTmlSoHdrVO(),TESInvoiceCommonBC.INV_STS_RC);
				eventResponse = createOffdockCYInvoiceDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {			//connfirm
				new TESInvoiceCommonBCImpl().checkInvoiceStatus(((EsdTes0004Event)e).getTesTmlSoHdrVO(),TESInvoiceCommonBC.INV_STS_RC);
				eventResponse = modifyOffdockCYInvoiceConfirm(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				new TESInvoiceCommonBCImpl().checkInvoiceStatus(((EsdTes0004Event)e).getTesTmlSoHdrVO(),TESInvoiceCommonBC.INV_STS_CF);
				eventResponse = cancelOffdockCYInvoiceConfirm(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {			//reject상태를 정상('NL')으로 설정한다.
				eventResponse = cancelOffdockCYInvoiceReject(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes0009Event")) {
			log.debug("\n "+e.getEventName()+" -  SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.ADD)) {				//main hidden add
				eventResponse = createStorageInvoiceBasicInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {		//main hidden search
				eventResponse = searchStorageInvoiceBasicInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				new TESInvoiceCommonBCImpl().checkInvoiceStatus(((EsdTes0009Event)e).getTesTmlSoHdrVO(),TESInvoiceCommonBC.INV_STS_RC);
				eventResponse = modifyStorageInvoice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeStorageInvoice01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE02)) {
				eventResponse = removeStorageInvoice02(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE03)) {
				eventResponse = removeStorageInvoiceAutoCalcData(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE04)) {
				eventResponse = removeStorageInvoiceAutoCalcDataAllCalcTab(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE05)) {
				eventResponse = removeStorageInvoiceAutoCalcData2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE06)) {
				eventResponse = removeStorageInvoiceAllCalcData(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				new TESInvoiceCommonBCImpl().checkInvoiceStatus(((EsdTes0009Event)e).getTesTmlSoHdrVO(),TESInvoiceCommonBC.INV_STS_RC);
				eventResponse = modifyStorageInvoiceReject(e);					//Reject
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchStorageContainerList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = calStorageInvoiceCost(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchStorageInvoiceDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchStorageInvoiceAllSheets(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {		//chk dgit
				eventResponse = checkDigitStorage2(e);				
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {		//container list cud
				new TESInvoiceCommonBCImpl().checkInvoiceStatus(((EsdTes0009Event)e).getTesTmlSoHdrVO(),TESInvoiceCommonBC.INV_STS_RC);
				eventResponse = createStorageInvoiceContainerList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				new TESInvoiceCommonBCImpl().checkInvoiceStatus(((EsdTes0009Event)e).getTesTmlSoHdrVO(),TESInvoiceCommonBC.INV_STS_RC);
				eventResponse = createStorageInvoiceDetail(e);					//Cost Calc.(SR by FD)
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				new TESInvoiceCommonBCImpl().checkInvoiceStatus(((EsdTes0009Event)e).getTesTmlSoHdrVO(),TESInvoiceCommonBC.INV_STS_RC);
				eventResponse = modifyStorageInvoiceConfirm(e);					//Confirm
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	
				new TESInvoiceCommonBCImpl().checkInvoiceStatus(((EsdTes0009Event)e).getTesTmlSoHdrVO(),TESInvoiceCommonBC.INV_STS_CF);
				eventResponse = cancelStorageInvoiceConfirm(e);					//Cancel Confirm
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY03)) {
				eventResponse = cancelStorageInvoiceReject(e);					//Cancel Reject
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes9030Event")) {
			log.debug("\n "+e.getEventName()+" -  SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");
		    if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
		    	eventResponse = multiReviseCalculatedVolume(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiReviseCalculatedVolumeM(e);		    	
		    } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchOffdockRevisedVolume(e);
		    } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchOffdockRevisedVolume(e);
		    } else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOffdockCYReviseMode(e);
//		    } else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
//				eventResponse = searchOffdockCYRvisCntrListCdN(e);
		    } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchOffdockCYRvisCntrListCdMT(e);
		    } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchOffdockCYRvisCntrListCdDG(e);
		    } else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchOffdockCYRvisCntrListCdRF(e);
		    } else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchOffdockCYRvisCntrListCdAK(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes9034Event")) {
			log.debug("\n "+e.getEventName()+" -  SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");
		    if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
		    	eventResponse = multiReviseCalculatedVolumeForTMRFMO(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiReviseCalculatedVolumeMForTMRFMO(e);		    	
		    } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchOffdockRevisedVolumeForTMRFMO(e);
		    } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchOffdockRevisedVolumeForTMRFMO(e);
		    } else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOffdockCYReviseModeForTMRFMO(e);
		    } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchOffdockCYRvisCntrListCdMTForTMRFMO(e);
		    } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchOffdockCYRvisCntrListCdDGForTMRFMO(e);
		    } else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchOffdockCYRvisCntrListCdRFForTMRFMO(e);
		    } else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchOffdockCYRvisCntrListCdAKForTMRFMO(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes9050Event")) {
			log.debug("\n "+e.getEventName()+" -  SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");
		    if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchOffdockCYTotalAmount(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes9060Event")) {
			log.debug("\n "+e.getEventName()+" -  SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");
		    if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchStorageTotalAmount(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes9074Event")) {
			log.debug("\n "+e.getEventName()+" -  SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");
		    if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchOffdockRevisedVolume2(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes9075Event")) {
			log.debug("\n "+e.getEventName()+" -  SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");
		    if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchOffdockRevisedVolumeSeparate2(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes9140Event")) {
			log.debug("\n "+e.getEventName()+" -  SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");
		    if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = verifyOffdockCYInvoiceVolume(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkDigitOffdock(e);
			// eBilling - B
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchEDIOffdockCYInvoiceContainerList(e);
			// eBilling - E
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchBakEndJbVO(e);
			// eBilling - E
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes9142Event")) {
			log.debug("\n xxx EsdTes9142Event "+e.getEventName()+" -  SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");
		    if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = verifyStorageInvoiceVolume(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)){		//Check Disit
				eventResponse = checkDigitStorage(e);
			// eBilling - B
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchEDIStorageInvoiceContainerList(e);
			// eBilling - E
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes9150Event")) {
			log.debug("\n "+e.getEventName()+" -  SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");
		    if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = verifyOffdockCYInvoiceCostByPool(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes9152Event")) {
			log.debug("\n "+e.getEventName()+" -  SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");
		    if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = verifyStorageInvoiceCostByPool(e);
			// eBilling - B	
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				searchEDIStorageInvoiceContainerListFreePool(e);
			// eBilling - E	
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes9233Event")) {
			log.debug("\n >>>>>>>>>>>>>>>>>>>>>> "+e.getEventName()+" -  SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<<<<<<<<<<<<<<<\n");
		    if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchOffdock3rdIFlist(e);
//			SP에서 3rd Party Billing은 더이상 제공하지 않는다. 2009.10.05
//		    } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
//				eventResponse = searchOffdock3rdIFlistByPool(e);
		    } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
		    	eventResponse = searchOffdock3rdIFlistByDay(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiOffdock3rdIFlist(e);		    	
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes9234Event")) {
			log.debug("\n "+e.getEventName()+" -  SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");
//		    if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
//				eventResponse = searchStorage3rdIFlist(e);
//		    } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
//				eventResponse = searchStorage3rdIFlistByPool(e);
//		    } else 		    
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
		    	eventResponse = searchStorage3rdIFlistByDay(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiStorage3rdIFlist(e);		    	
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes9240Event")) {
			log.debug("\n "+e.getEventName()+" -  SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");
		    if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
		    	eventResponse = multiReviseCalculatedVolumeSeparate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiReviseCalculatedVolumeSeparateM(e);		    	
		    } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {		//Auto
				eventResponse = searchOffdockRevisedVolumeSeparate(e);
		    } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {	//Manual
				eventResponse = searchOffdockRevisedVolumeSeparate(e);
		    } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {	//Revised Vol Doble billing check
					eventResponse = searchOffdockRevisedVolumeDoubleBillChk(e);
		    } else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {			//Manual - Get RVIS_CNTR_LIST_CD
				eventResponse = searchOffdockCYReviseModeSeparate(e);

//			2009.12.17 함수 DBDAO.searchOffdockCYRvisCntrListCdN 를 호출하는데 NULL 을 리턴하도록 구현되어있다.
//			필요없기에 주석처리함.
//		    } else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {		//RVIS_CNTR_LIST_CD - N
//				eventResponse = searchOffdockCYRvisCntrListCdNSeparate(e);
		    } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {		//RVIS_CNTR_LIST_CD - MT
				eventResponse = searchOffdockCYRvisCntrListCdMTSeparate(e);
		    } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {		//RVIS_CNTR_LIST_CD - DG
				eventResponse = searchOffdockCYRvisCntrListCdDGSeparate(e);
		    } else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {		//RVIS_CNTR_LIST_CD - RF
				eventResponse = searchOffdockCYRvisCntrListCdRFSeparate(e);
		    } else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {		//RVIS_CNTR_LIST_CD - AK
				eventResponse = searchOffdockCYRvisCntrListCdAKSeparate(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes9253Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchOffdock3rdIFlistOnly(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes9254Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchStorage3rdIFlistOnly(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes0025Event")) {
			log.debug("\n "+e.getEventName()+" -  SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCSRSOlist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiRejectedCSRCancellation(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes0100Event")) {
			log.debug("\n "+e.getEventName()+" -  SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCSRAPiflist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiConfirmCSR(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				//new TESInvoiceCommonBCImpl().checkInvoiceStatus(((EsdTes100Event)e).getAP_INV_HDR().getCsr_no() ,TESInvoiceCommonBC.INV_STS_AR);				
				eventResponse = cancelCSR(e);
			}
//			else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)){ 현재 BIZCOMMON SC에서 backend job에러시 rollback 으로 사용했으나 사용하지 않음 
//				eventResponse = modifyStsCdSOHDRBack(e);
//			} 
			
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes0101Event")) {
			log.debug("\n "+e.getEventName()+" -  SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCSRSOlist2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchCSRSOhdr(e);
			}
		}
		/** Yoo. 끝  ***/



		/** Moon. 시작 ***/
		if (e.getEventName().equalsIgnoreCase("EsdTes0018Event")) {
			log.debug("\n "+e.getEventName()+" -  SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");
		    if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOffdockCYInvoiceBasicInfoInquiry(e);
/*			
 * [0018]조회에서는 사용안하는 함수
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				//eventResponse = searchOffdockCYContainerListInquiry(e);
				log.debug("SEARCHLIST "+e.getFormCommand().getCommand());
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				log.debug("SEARCHLIST01 "+e.getFormCommand().getCommand());
				//eventResponse = calOffdockCYInvoiceCostInquiry(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				log.debug("SEARCHLIST02 "+e.getFormCommand().getCommand());
				//eventResponse = searchOffdockCYInvoiceDetailInquiry(e);
*/			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				log.debug("SEARCHLIST03 "+e.getFormCommand().getCommand());
				eventResponse = searchOffdockCYInvoiceAllSheetsInquiry(e);
			} 
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes0023Event")) {
		    if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCSRSummary(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchCSRSummary1(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSoIfCd(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes0024Event")) {
			log.debug("EsdTes0024Event FormCommand====================="+e.getFormCommand().getCommand());
		    if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCSRSummaryDetail(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				new TESInvoiceCommonBCImpl().searchMinusInvAmtSvxxJoExist(((EsdTes0024Event)e).getTesTmlSoHdrVOs()); 
				eventResponse = searchPreVeiw(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = tmpSearchCSRSummary(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = tmpSearchPreVeiw(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				new TESInvoiceCommonBCImpl().searchMinusInvAmtSvxxJoExist(((EsdTes0024Event)e).getTesTmlSoHdrVOs()); 
				eventResponse = approvalRequest(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchCSRSummaryDetail1(e);
			} 
		}
		
		if (e.getEventName().equalsIgnoreCase("EsdTes0078Event")) {
		    if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchTAXInfo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchApEviNo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchTAXCode(e);
			}
		}
		
//		if (e.getEventName().equalsIgnoreCase("EsdTes0079Event")) {//타지 않아 주석처리함
//		    if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
//				eventResponse = searchCSRSummaryDetail(e);
//			}
//		}
		
		if (e.getEventName().equalsIgnoreCase("EsdTes0080Event")) {
		    if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCSRSummaryDetail2(e);
			}
		}
		/** Moon. 끝 ***/



		/** JINJOO. 시작 ***/
		if (e.getEventName().equalsIgnoreCase("EsdTes0019Event")) {
			log.debug("\n "+e.getEventName()+" -  SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");
		    if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
		    	eventResponse = searchStorageInvoiceBasicInfo2(e);
		    } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchStorageContainerList2(e);
			//}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { 잠깐막음
				//eventResponse = searchStorageInvoiceDetail2(e);잠깐막음
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes0013Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTerminalInvoiceSummary(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MODIFY)){
				eventResponse = modifyTerminalInvoiceConfirm(e);
			} else if(e.getFormCommand().isCommand(FormCommand.REMOVE)){
				eventResponse = removeTerminalInvoice(e);
			// ViewAdpter의 isSave 값에 대한 처리방법으로 인해 COMMAND01에서 REMOVE01로 변경. (2010-05-12) 				
			} else if(e.getFormCommand().isCommand(FormCommand.REMOVE01)){
				eventResponse = removeTerminalEDIInvoice(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){
				eventResponse = convertEDIInvoice2TMLInvoice(e);
//			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND03)){
//				eventResponse = validateEDIInvoice(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes0014Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTerminalExpenseSummary(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTerminalExpenseVolumeSummary(e);
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("EsdTes9300Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOfficeHierarchy(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSubOffice(e);
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsdTes9500Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTOR(e);
			}
		}		
		//GST Invoice Summary (India)
		if (e.getEventName().equalsIgnoreCase("EsdTes0012Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTerminalGSTInvoiceSummary(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MODIFY)){
				eventResponse = modifyTerminalInvoiceConfirm(e);
			} else if(e.getFormCommand().isCommand(FormCommand.REMOVE)){
				eventResponse = removeTerminalInvoice(e);
			// ViewAdpter의 isSave 값에 대한 처리방법으로 인해 COMMAND01에서 REMOVE01로 변경. (2010-05-12) 				
			} else if(e.getFormCommand().isCommand(FormCommand.REMOVE01)){
				eventResponse = removeTerminalEDIInvoice(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){
				eventResponse = convertEDIInvoice2TMLInvoice(e);
//			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND03)){
//				eventResponse = validateEDIInvoice(e);
			}
		}
		/**
		 * On-Dock Rail Charge Container List 조회
		 * @author kimjinjoo
		 */
		if (e.getEventName().equalsIgnoreCase("EsdTes0068Event")) {
			if(log.isDebugEnabled())log.debug("\n\n"+e.getEventName()+" -  SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOndockRailChargeBasicInfo2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse =  searchOndockRailChargeContainerList2(e);
			}
		}

		/**
		 * Marine Terminal Container List 조회
		 * @author kimjijoo
		 */

		if(e.getEventName().equalsIgnoreCase("EsdTes0017Event")) {
			log.debug("start EsdTes0017Event");
			if(log.isDebugEnabled()) log.debug("\n\n"+e.getEventName()+" -  SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTerminalInvoiceBasicInfo2(e);
				//eventResponse = addMarineTerminalInvoiceManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTerminalContainerList2(e);
			}
			//화면 미사용 2009-08-26 park
			/*else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchAccumulatedVolume2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchTerminalInvoiceCalculationList2(e);
			}*/
		}
		/** JINJOO. 끝 ***/




		/*******************************************************************************************
		 * 								parkyeonjin 개발부분(event 분기부분) 시작
		 ******************************************************************************************/

		/**
		 *  Terminal Invoice Part Start
		 *  author : 박연진
		 */
		if (e.getEventName().equalsIgnoreCase("EsdTes0001Event")) {
			log.debug("\n\n ### SC.EsdTes0001Event ####################### \n\n");
			if(log.isDebugEnabled())log.debug("\n "+e.getEventName()+" -  SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = this.searchTerminalInvoiceBasicInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = this.searchMarineTerminalInvoice(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = this.searchMarineTerminalCNTRList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = this.calculateTerminalInvoiceCost(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchManualRvisDivision(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {		//chk dgit
				eventResponse = checkDigit2(e);				
			} else if (e.getFormCommand().isCommand(FormCommand.ADD)){
				eventResponse = this.createTerminalInvoiceBasicInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = this.modifyTerminalInvoice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = this.confirmMarineTerminalInvoice(e);//confirm
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = this.modifyTerminalInvoice(e);//reject
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY03)) {
				eventResponse = this.rejectLiftTerminalInvoice(e);//reject Lift
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = this.removeTerminalInvoiceContainerList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE02)) {
				eventResponse = this.removeTerminalInvoiceCosts(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE03)) {
				eventResponse = this.removeTerminalInvoiceContainerList2(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = this.multiTerminalInvoiceContainerList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = this.multiTerminalInvoiceDetail(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = this.searchTerminalInvoiceATBDt(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = this.searchAccumulatedVolume(e);
//			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
//				eventResponse = this.searchOtherCarrierAccountCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY04)) {
				eventResponse = this.modifyN3rdPartyAmount(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI14)) {
				eventResponse = this.reVerifyTerminalInvoiceContainerList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = this.searchTerminalInvoiceVVDDual(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY05)) {  //--  MR Invoice 입력시 FIO 조건 CNTR verification 결과 보완  by J PARK  2011-0725
				eventResponse = this.modifyContainerFromCoToDC(e);
			}
		}

		
		if(e.getEventName().equalsIgnoreCase("EsdTes1003Event")) {
			if(log.isDebugEnabled()) log.debug("\n\n"+e.getEventName()+" -  SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTerminalInvoiceAutoBoundList(e);
				//eventResponse = addMarineTerminalInvoiceManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiTerminalInvoiceAutoBoundList(e);
			} 
		}

//		File Import
		if (e.getEventName().equalsIgnoreCase("EsdTes9010Event")) {
			if(log.isDebugEnabled())log.debug("\n "+e.getEventName()+" -  SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = checkTerminalInvoiceContainerList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkDigit(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchEDIInvoiceContainerList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchHJSListOnlyList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchContainerListByWorkOrder(e);
			}else {
				eventResponse = getVrfyTmls(e);
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsdTes9032Event")) {
			if(log.isDebugEnabled())log.debug("\n "+e.getEventName()+" -  SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");

			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAutoRevisedVolume(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchManualRevisedVolume(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchEDIInvoiceManualContainerList(e);		
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = updateContainerListRvisFlg(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = updateContainerListRvisFlgManual(e);
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("EsdTes9033Event")) {
			if(log.isDebugEnabled())log.debug("\n "+e.getEventName()+" -  SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");

			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAutoRevisedVolume(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchManualRevisedVolume(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchEDIInvoiceManualContainerList(e);		
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = updateContainerListRvisFlg(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = updateContainerListRvisFlgManual(e);
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsdTes9072Event")) {
			if(log.isDebugEnabled())log.debug("\n "+e.getEventName()+" -  SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");

			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMarineTerminalAutoRevisedVolume(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchMarineTerminalManualRevisedVolume(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes9190Event")) {
			if(log.isDebugEnabled())log.debug("\n "+e.getEventName()+" -  SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRehandlingVolume(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	
				eventResponse = searchEDIInvoiceRHManualContainerList(e);				
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = multiRehandlingVolume(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes9191Event")) {
			if(log.isDebugEnabled())log.debug("\n "+e.getEventName()+" -  SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMarineTerminalRehandlingVolume(e);
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsdTes9220Event")) {
			if(log.isDebugEnabled())log.debug("\n "+e.getEventName()+" -  SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAccumulatedVolumeList(e);
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsdTes9232Event")) {
			if(log.isDebugEnabled())log.debug("\n "+e.getEventName()+" -  SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");

			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAutoTrdPartyVolume(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchManualTrdPartyVolume(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = multiTerminalInvoiceN3rdParyIF2(e);
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsdTes9252Event")) {
			if(log.isDebugEnabled())log.debug("\n "+e.getEventName()+" -  SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");

			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMarineTerminalTrdPartyVolume(e);
			}
		}

		/*
		 *  Terminal Invoice Part End
		 *  author : 박연진
		 */
		/*
		 *  On-Dock Rail Charge Invoice Part Start
		 *  author : 박연진
		 */
		if (e.getEventName().equalsIgnoreCase("EsdTes0064Event")) {
			if(log.isDebugEnabled())log.debug("\n "+e.getEventName()+" - 0064 SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = this.createOndockRailChargeBasicInfo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = this.modifyOndockRailChargeBasicInfo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = this.searchOndockRailChargeBasicInfo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.multiOndockRailChargeContainerList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = this.multiOndockRailChargeInvoiceDetail(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = this.searchOndockRailChargeContainerList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = this.searchOndockRailChargeCostCalculationList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = this.searchOnDockChargeInvoiceCostCalcComboCodeList(e);
//			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {//지워야됨
//				eventResponse = this.searchOndockRailChargeInvoiceRvisList(e);
//			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
//				eventResponse = this.searchOndockRailChargeInvoiceN3ptyList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = this.removeOndockRailChargeInvoiceCost(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {		//chk dgit
				eventResponse = checkDigitOnDock(e);				
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsdTes9031Event")) {
			log.debug("\n "+e.getEventName()+" -  SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");
		    if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTerminalInvoiceRevisedVolume(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOnDockAutoRevisedVolume(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchTerminalInvoiceRevisedVolume9031(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = updateOnDockContainerListRvisFlg(e);
			}
		}


		if (e.getEventName().equalsIgnoreCase("EsdTes9130Event")) {
			if(log.isDebugEnabled())log.debug("\n "+e.getEventName()+" -  SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = verifyOndockRailChargeContainerList(e);
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsdTes9231Event")) {
			if(log.isDebugEnabled())log.debug("\n "+e.getEventName()+" -  SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTerminalInvoiceN3ptyAutoCntrList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTerminalInvoiceN3ptyManualCntrList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiTerminalInvoiceN3rdParyIF(e);				
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes9251Event")) {
			if(log.isDebugEnabled())log.debug("\n "+e.getEventName()+" -  SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");

			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOnDockTrdPartyVolume(e);
			}
		}

		//MG Set
		if (e.getEventName().equalsIgnoreCase("EsdTes1004Event")) {
			log.debug("\n##################"+e.getEventName()+" - SC.e.getFormCommand() : "+e.getFormCommand().getCommand() + "##################\n");

			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMGSetFuelingChargeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiMGSetFuelingCharge(e);				
			}
		}		
		
		/*******************************************************************************************
		 * 								parkyeonjin 개발부분(event 분기부분) 끝
		 ******************************************************************************************/
		
		if (e.getEventName().equalsIgnoreCase("EsdTes9001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCostCodeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCostCodeDetailList(e);				
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPortSkdDetailList(e);				
			}
		}		
		
		
		
		/**
		 * Invoice Processing Audit Inquiry
		 * 4347.06.19
		 */
		if ( e.getEventName().equalsIgnoreCase("EsdTes0015Event") ) {
			log.debug("\n##################"+ e.getEventName() +" - SC.e.getFormCommand() : "+ e.getFormCommand().getCommand() + "##################\n");
			/**
			 * INVOICE Layer
			 * 1 : Marine Terminal Invoice
			 * 2 : On-dock Rail Charge Invoice
			 * 3 : Off-dock CY Invoice
			 * 4 : Marine Terminal Strorage Invoice
			 */	 

			// Marine Terminal Invoice
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAuditTerminalInvoiceContainerList(e);
			// On-dock Rail Charge Invoice
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchAuditOndockRailChargeContainerList(e);
			// Off-dock CY Invoice
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchAuditOffdockCYContainerList(e);
			// Marine Terminal Strorage Invoice
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchAuditStorageContainerList(e);
			}
		}
		
		

		return eventResponse;
	}	
	

	/**
	 * 9001 팝업화면 searchCostCodeDetailList
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostCodeDetailList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MarineTerminalInvoiceManageBCImpl command = null;
		try{
			// creating Impl each event  
			EsdTes9001Event event =(EsdTes9001Event) e;
			command = new MarineTerminalInvoiceManageBCImpl();
			List<SearchCostCodeDetailListVO> list = command.searchCostCodeDetailList(event.getInfoVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 9001 팝업화면 searchCostCodeList
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostCodeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MarineTerminalInvoiceManageBCImpl command = null;
		try{
			// creating Impl each event  
			EsdTes9001Event event =(EsdTes9001Event) e;
			command = new MarineTerminalInvoiceManageBCImpl();
			String cost_cd_inv_tp_cd = event.getCost_cd_inv_tp_cd();
			List<SearchCostCodeDetailListVO> list = command.searchCostCodeList(event.getInfoVO(), event.getCmnVO(), cost_cd_inv_tp_cd, event.getSignOnUserAccount());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Cost Calc. 자동계산
	 * @param e Event event object
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse calOffdockCYInvoiceCost(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event)e;

		GeneralEventResponse eventResponse = null;

		try {
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = (GeneralEventResponse)command.calOffdockCYInvoiceCost(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Cost Calc. 자동계산
	 * @param e Event event object
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse calStorageInvoiceCost(Event e) throws EventException {

		EsdTes0009Event event = (EsdTes0009Event)e;

		EventResponse eventResponse = null;

		try {
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			eventResponse = command.calStorageInvoiceCost(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * check digit 처리
	 * @param e Event EsdTes0004Event
	 * @return eventResponse  
	 * @exception EventException
	 */
	public EventResponse checkDigitOffdock2(Event e) throws EventException {
		log.debug("\n\n SC.checkDigitOffdock2 ----------------------------- \n");

		EsdTes0004Event event = (EsdTes0004Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();

		try {
			log.debug("\n checkDigit  ------------------------  \n");
			
			begin();
			command.updateCNTRNumber2(event.getTesTmlSoHdrVO());
			commit();
			
//			eventResponse = command.searchOffdockCYInvoiceBasicInfo(event);
			
		} catch (EventException de) {
			log.debug("\n EventException rollback ------------------------  \n");
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse;
	}
	
	/**
	 * check digit 처리
	 * @param e Event EsdTes914Event
	 * @return eventResponse  ESD_TES_914EventResponse
	 * @exception EventException
	 */
	public EventResponse checkDigitOffdock(Event e) throws EventException {
		log.debug("\n\n SC.checkDigitOffdock ----------------------------- \n");

		EsdTes9140Event event = (EsdTes9140Event)e;
		EventResponse eventResponse = null;
		OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();

		try {
			log.debug("\n 무조건 임시 TABLE 지우기1 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP(event);

			log.debug("\n 임시 TABLE에 넣고 ------------------------  \n");
			command.createTES_FILE_IMP_TMP(event);

			log.debug("\n checkDigit  ------------------------  \n");
			
			begin();
			command.updateCNTRNumber(event);
			commit();
			
			eventResponse = command.searchTES_FILE_IMP_TMP(event);
			
		} catch (EventException de) {
			log.debug("\n EventException rollback ------------------------  \n");
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} finally {
			log.debug("\n 무조건 임시 TABLE 지우기2 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP(event);
		}
		return eventResponse;
	}	
/*//	public EventResponse checkDigitOffdock(Event e) throws EventException {
//
//		log.debug("\n\n SC.checkDigitOffdock ----------------------------- \n");
//
//		EsdTes9140Event event = (EsdTes9140Event)e;
//		EventResponse eventResponse = null;
//		OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
//
//		try {
//			log.debug("\n 무조건 임시 TABLE 지우기1 ------------------------  \n");
//			command.removeTES_FILE_IMP_TMP(event);
//
//			log.debug("\n 임시 TABLE에 넣고 ------------------------  \n");
//			command.createTES_FILE_IMP_TMP(event);
//
//			log.debug("\n checkDigit  ------------------------  \n");
//			eventResponse = command.searchCNTRNumber(event);
//
//			ESD_TES_914EventResponse er = (ESD_TES_914EventResponse)eventResponse;
//			event.setRowSet(er.getRs());
//			log.debug("\n CNTR_LIST에 넣고 ------------------------  \n");
//
//			begin();
//			command.updateCNTRNumber(event);
//			commit();
//			eventResponse = command.searchTES_FILE_IMP_TMP(event);
//		} catch (EventException de) {
//			log.debug("\n EventException rollback ------------------------  \n");
//			rollback();
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		} finally {
//			log.debug("\n 무조건 임시 TABLE 지우기2 ------------------------  \n");
//			command.removeTES_FILE_IMP_TMP(event);
//		}
//		return eventResponse;
//	}
*/
	
	/**
	 * check digit 처리
	 * @param e Event EsdTes9142Event
	 * @return eventResponse  ESD_TES_9142EventResponse
	 * @exception EventException
	 */
	public EventResponse checkDigitStorage(Event e) throws EventException {

		log.debug("\n\n SC.checkDigitStorage ----------------------------- \n");

		EsdTes9142Event event = (EsdTes9142Event)e;
		EventResponse eventResponse = null;
		MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();

		try {
			log.debug("\n 무조건 임시 TABLE 지우기1 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP(event);

			log.debug("\n 임시 TABLE에 넣고 ------------------------  \n");
			command.createTES_FILE_IMP_TMP(event);

			log.debug("\n checkDigit  ------------------------  \n");
			
			begin();
			command.updateCNTRNumber(event);
			commit();
			
			eventResponse = command.searchTES_FILE_IMP_TMP(event);
		} catch (EventException de) {
			log.debug("\n EventException rollback ------------------------  \n");
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} finally {
			log.debug("\n 무조건 임시 TABLE 지우기2 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP(event);
		}
		return eventResponse;
	}
	
	/**
	 * check digit 처리
	 * @param e Event EsdTes0004Event
	 * @return eventResponse  
	 * @exception EventException
	 */
	public EventResponse checkDigitStorage2(Event e) throws EventException {
		log.debug("\n\n SC.checkDigitStorage2 ----------------------------- \n");

		EsdTes0009Event event = (EsdTes0009Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();

		try {
			log.debug("\n checkDigit  ------------------------  \n");
			
			begin();
			command.updateCNTRNumber2(event.getTesTmlSoHdrVO());
			commit();
			
//			eventResponse = command.searchOffdockCYInvoiceBasicInfo(event);
			
		} catch (EventException de) {
			log.debug("\n EventException rollback ------------------------  \n");
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} 
		
		return eventResponse;
	}	

	
	/**
	 * EDI로 받은 CNTR목록 조회 - eBilling
	 * @param e Event event object
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchEDIOffdockCYInvoiceContainerList(Event e) throws EventException {

//		log.debug("\n\n SC.searchEDIOffdockCYInvoiceContainerList ----------------------------- \n");
		log.debug(e.toString());
//		ESD_TES_914Event event = (ESD_TES_914Event)e;
//		EventResponse eventResponse = null;
//		OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();

//		try {
//			eventResponse = command.searchEDIOffdockCYInvoiceContainerList(event);
//		} catch (EventException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//		return eventResponse;
		return null;
	}
	
	/**
	 * EDI로 받은 CNTR목록 조회 - eBilling
	 * @param e Event event object
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchEDIStorageInvoiceContainerList(Event e) throws EventException {
		log.debug(e.toString());
		log.debug("\n\n SC.searchEDIStorageInvoiceContainerList ----------------------------- \n");

		EsdTes9142Event event = (EsdTes9142Event)e;
		EventResponse eventResponse = null;
		MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();

		try {
			eventResponse = command.searchEDIStorageInvoiceContainerList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	
	/**
	 * EDI로 받은 FreePool CNTR목록 조회 - eBilling
	 * @param e Event event object
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchEDIStorageInvoiceContainerListFreePool(Event e) throws EventException {
		log.debug(e.toString());
		log.debug("\n\n SC.searchEDIStorageInvoiceContainerListFreePool ----------------------------- \n");

		EsdTes9152Event event = (EsdTes9152Event)e;
		EventResponse eventResponse = null;
		MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();

		try {
			eventResponse = command.searchEDIStorageInvoiceContainerListFreePool(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Off-dock verify 하기
	 * @param e Event event object
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyOffdockCYInvoiceVolume(Event e) throws EventException {

		log.debug("\n SC.verifyOffdockCYInvoiceVolume ------------------------  \n");
		
		EsdTes9140Event event = (EsdTes9140Event)e;
		EventResponse eventResponse = new GeneralEventResponse();
		OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
//		int insCnt = 0;
		String key = "";
		
		/**
		 * 2009-03-11 (2009-04-27 : 날짜 주석 추가 및 수정)
		 * # DB에 성능LOG에 SC에서의 시작 시각을 남기는 부분은 크게 3부분으로 나뉜다. 각가가 transaction을 분리하여 혹 문제가 발생하여도 기존 작업에 영향이 없도록 한다.
		 * 1) 시작 시각 찍기 - key가 되는 curr_seq를 생성하여 마침까지 넘겨야 한다. 한 SC의 작업에서는 하나의 sequence가 바람직하다.
		 * 2) 오류 시각 찍기 - 반드시 1)번에서 넘어온 현재의 key값이 있을 경우만 실행한다.
		 * 3) 마침 시각 찍기 - 반드시 1)번에서 넘어온 현재의 key값이 있을 경우만 실행한다.
		 * 
		 * 
		 * 1) DB에 성능LOG에 SC에서의 시작 시각을 남기는 부분 - 시작부분이 완료되면 반드시 현재의 SEQUENCE를 마칠때까지 넘겨야 한다.
		 * <주> param_map으로 담는 인자값들은 작업에 따라 다르니 그때마다 각각 설정해야한다.
		 */		

		String curr_seq = null;
//		try {//2009-03-12
//			String pageURL = event.getPageURL();
//			TesJbExePerfLogVO tesJbExePerfLogVO = new TesJbExePerfLogVO();
//			tesJbExePerfLogVO.setInvOfcCd( e.getSignOnUserAccount().getOfc_cd() );
//			tesJbExePerfLogVO.setExeUsrId( e.getSignOnUserAccount().getUsr_id() );
//			tesJbExePerfLogVO.setJbTpCd( TESCommonBC.PERF_JOB_TYPE_ON_LINE_INVOICE );
//			tesJbExePerfLogVO.setPgmUrl( (pageURL!=null&&!pageURL.equals("")?pageURL.trim():JSPUtil.getNull(event.getEventName())) );			
//			tesJbExePerfLogVO.setFuncDivCd( String.valueOf(event.getFormCommand().getCommand()) );
//			tesJbExePerfLogVO.setExeRowKnt( event.getTesFileImpTmpVOs()!=null?Integer.toString( (event.getTesFileImpTmpVOs()).length ):"" );
//			tesJbExePerfLogVO.setTmlSoOfcCtyCd( event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd() );
//			tesJbExePerfLogVO.setTmlSoSeq( event.getTesTmlSoHdrVO().getTmlSoSeq() );
//			tesJbExePerfLogVO.setJbParaCtnt( event.getPerfParams() );
//			curr_seq = beginJobExecutionPerformance( tesJbExePerfLogVO );
//		} catch (Exception ex){
//			//본 업무에 영향을 안주기 위해 Exception을 던지지 않는다.
//			log.error(ex.getMessage());
//			if (false){
//				throw new EventException(ex.getMessage());
//			}
//		}
		
		curr_seq = searchCurrSeq(e);
		
		try {
//			//무조건 임시 TABLE 지우기 1
//			log.debug("\n 무조건 임시 TABLE 지우기 1 ------------------------  \n");
//			command.removeTES_FILE_IMP_TMP(event);
//
//			//임시 TABLE에 넣고
//			log.debug("\n 임시 TABLE에 넣고 ------------------------  \n");
//			command.createTES_FILE_IMP_TMP(event);
//
//			//계산하기
//			log.debug("\n 계산하기 ------------------------  \n");
//			eventResponse = command.verifyOffdockCYInvoiceVolume(event); //계산하기
//			event.setRowSet(eventResponse.getRs());
//			
//			//CNTR_LIST에 넣고
//			log.debug("\n CNTR_LIST에 넣고 ------------------------  \n");
//			begin();
//			insCnt = command.insertOffdockCYInvoiceContainerList(event);
//			commit();
//			
//			eventResponse.setETCData("insCnt", String.valueOf(insCnt));
//			eventResponse.setETCData( "successFlag", "SUCCESS" );
			
			key = command.startBackEndJob(event);
			
            BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(key);

            DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();
            List<ComBakEndJbVO> dbRowSetlist = (List)RowSetUtil.rowSetToVOs(rowSet, ComBakEndJbVO.class);
           
            ComBakEndJbVO jobVo = new ComBakEndJbVO();
            
            if (dbRowSetlist.size() == 0) {
                // Background job framework가 정상적으로 동작하지 않을 경우 발생하는 오류를 회피하기 위함           
                jobVo.setJbStsFlg("0");
            } else {
                jobVo = (ComBakEndJbVO)dbRowSetlist.get(0);
            }

            eventResponse.setETCData("jb_sts_flg", jobVo.getJbStsFlg());			
    		eventResponse.setETCData("key", key);
			
			
		} catch (EventException de) {
			log.debug("\n EventException rollback ------------------------  \n");
			rollback();
			log.error("err " + de.toString(), de);
			/**
			 * 2) DB에 성능LOG에 SC에서의 오류 발생 시각을 남기는 부분
			 */			
			errorJobExecutionPerformance(curr_seq);			
//			errorJobExecutionPerformance(currSeq, de.toString());	// Error Remark					
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		} finally {
			//무조건 임시 TABLE 지우기 2
			log.debug("\n 무조건 임시 TABLE 지우기 2 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP(event);
		}
		
		/**
		 * 3) DB에 성능LOG에 SC에서의 마침 시각을 남기는 부분
		 */ 
		endJobExecutionPerformance(curr_seq);

		
		return eventResponse;
	}
	
	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
//	private EventResponse SearchBakEndJbVO(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		BackEndJobStatusSearchSampleBC command = new BackEndJobStatusSearchSampleBCImpl();
//		
//		String status = command.ComBakEndJbVO((String)e.getAttribute("KEY"));
//		eventResponse.setETCData("jb_sts_flg", status);
//		return eventResponse;
//	}	

	private EventResponse searchBakEndJbVO(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes9140Event event = (EsdTes9140Event) e;
		try {
            String backEndJobKey = event.getAttribute("resultStr")==null?"":event.getAttribute("resultStr").toString();
			// Backend job이 완료되었는지 검사한다.
            BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(backEndJobKey);

            DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();
            List<ComBakEndJbVO> dbRowSetlist = (List)RowSetUtil.rowSetToVOs(rowSet, ComBakEndJbVO.class);
           
            ComBakEndJbVO jobVo = new ComBakEndJbVO();
            
            if (dbRowSetlist.size() == 0) {
                // Background job framework가 정상적으로 동작하지 않을 경우 발생하는 오류를 회피하기 위함           
                jobVo.setJbStsFlg("0");
            } else {
                jobVo = (ComBakEndJbVO)dbRowSetlist.get(0);
            }

            eventResponse.setETCData("jb_sts_flg", jobVo.getJbStsFlg());

			
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * Off-dock ByPool verify 하기
	 * @param e Event event object
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyOffdockCYInvoiceCostByPool(Event e) throws EventException {

		log.debug("\n SC.verifyOffdockCYInvoiceCostByPool ------------------------  \n");

		EsdTes9150Event event = (EsdTes9150Event)e;
		EventResponse eventResponse = new GeneralEventResponse();
		OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
		int insCnt = 0;

		try {
			//무조건 임시 TABLE 지우기 1
			log.debug("\n 무조건 임시 TABLE 지우기 1 ------------------------  \n");
			command.removeTES_FILE_IMP_TMPByPool(event);

			//임시 TABLE에 넣고
			log.debug("\n 임시 TABLE에 넣고 ------------------------  \n");
			command.createTES_FILE_IMP_TMPByPool(event);

			//계산하기
//			log.debug("\n 계산하기 ------------------------  \n");
//			eventResponse = command.verifyOffdockCYInvoiceCostByPool(event);
//			ESD_TES_915EventResponse er = (ESD_TES_915EventResponse)eventResponse;
//			er = (ESD_TES_915EventResponse)eventResponse;
//			event.setRowSet(er.getRs());
//
			//계산하기
			log.debug("\n 계산하기 ------------------------  \n");
			eventResponse = command.verifyOffdockCYInvoiceCostByPool(event); //계산하기
			event.setRowSet(eventResponse.getRs());
			
			//CNTR_LIST에 넣고
			log.debug("\n CNTR_LIST에 넣고 ------------------------  \n");
			begin();
			insCnt = command.insertOffdockCYInvoiceDetail(event);
			commit();
			
			log.debug("at SC insCnt : "+insCnt);
			
			eventResponse.setETCData("insCnt", String.valueOf(insCnt));
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			
//			er.setInsCnt(insCnt);
//			eventResponse = er;
		} catch (EventException de) {
			log.debug("\n EventException rollback ------------------------  \n");
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} finally {
			//무조건 임시 TABLE 지우기 2
			log.debug("\n 무조건 임시 TABLE 지우기 2 ------------------------  \n");
			command.removeTES_FILE_IMP_TMPByPool(event);
		}
		return eventResponse;
	}

	/**
	 * Storage verify 하기
	 * @param e Event event object
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyStorageInvoiceVolume(Event e) throws EventException {

		log.debug("\n SC.verifyStorageInvoiceVolume ------------------------  \n");

		EsdTes9142Event event = (EsdTes9142Event)e;
		EventResponse eventResponse = new GeneralEventResponse();
		MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
		int insCnt = 0;

		/**
		 * 2009-03-11
		 * # DB에 성능LOG에 SC에서의 시작 시각을 남기는 부분은 크게 3부분으로 나뉜다. 각가가 transaction을 분리하여 혹 문제가 발생하여도 기존 작업에 영향이 없도록 한다.
		 * 1) 시작 시각 찍기 - key가 되는 curr_seq를 생성하여 마침까지 넘겨야 한다. 한 SC의 작업에서는 하나의 sequence가 바람직하다.
		 * 2) 오류 시각 찍기 - 반드시 1)번에서 넘어온 현재의 key값이 있을 경우만 실행한다.
		 * 3) 마침 시각 찍기 - 반드시 1)번에서 넘어온 현재의 key값이 있을 경우만 실행한다.
		 * 
		 * 
		 * 1) DB에 성능LOG에 SC에서의 시작 시각을 남기는 부분 - 시작부분이 완료되면 반드시 현재의 SEQUENCE를 마칠때까지 넘겨야 한다.
		 * <주> param_map으로 담는 인자값들은 작업에 따라 다르니 그때마다 각각 설정해야한다.
		 */		
		String curr_seq = null;
//		try {//2009-03-12
//			String pageURL = event.getPageURL();
//			TesJbExePerfLogVO tesJbExePerfLogVO = new TesJbExePerfLogVO();
//			tesJbExePerfLogVO.setInvOfcCd( e.getSignOnUserAccount().getOfc_cd() );
//			tesJbExePerfLogVO.setExeUsrId( e.getSignOnUserAccount().getUsr_id() );
//			tesJbExePerfLogVO.setJbTpCd( TESCommonBC.PERF_JOB_TYPE_ON_LINE_INVOICE );
//			tesJbExePerfLogVO.setPgmUrl( (pageURL!=null&&!pageURL.equals("")?pageURL.trim():JSPUtil.getNull(event.getEventName())) );			
//			tesJbExePerfLogVO.setFuncDivCd( String.valueOf(event.getFormCommand().getCommand()) );
//			tesJbExePerfLogVO.setExeRowKnt( event.getTesFileImpTmpVOs()!=null?Integer.toString( (event.getTesFileImpTmpVOs()).length ):"" );
//			tesJbExePerfLogVO.setTmlSoOfcCtyCd( event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd() );
//			tesJbExePerfLogVO.setTmlSoSeq( event.getTesTmlSoHdrVO().getTmlSoSeq() );
//			tesJbExePerfLogVO.setJbParaCtnt( event.getPerfParams() );
//			curr_seq = beginJobExecutionPerformance( tesJbExePerfLogVO );
//		} catch (Exception ex){
//			//본 업무에 영향을 안주기 위해 Exception을 던지지 않는다.
//			log.error(ex.getMessage());
//			
//			if (false){
//				throw new EventException(ex.getMessage());
//			}
//		}
		curr_seq = searchCurrSeq(e);
	
		try {
			//무조건 임시 TABLE 지우기 1
			log.debug("\n 무조건 임시 TABLE 지우기 1 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP(event);

			//임시 TABLE에 넣고
			log.debug("\n 임시 TABLE에 넣고 ------------------------  \n");
			command.createTES_FILE_IMP_TMP(event); //임시에 넣고

			//계산하기
			log.debug("\n 계산하기 ------------------------  \n");
			eventResponse = command.verifyStorageInvoiceVolumne(event); //계산하기
			event.setRowSet(eventResponse.getRs());
			
			//CNTR_LIST에 넣고
			log.debug("\n CNTR_LIST에 넣고 ------------------------  \n");
			begin();
			insCnt = command.insertStorageInvoiceContainerList(event);
			commit();
			
			log.debug("insCnt ------------------------ "+insCnt);
			
			eventResponse.setETCData("insCnt", String.valueOf(insCnt));
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			/**
			 * 2) DB에 성능LOG에 SC에서의 오류 발생 시각을 남기는 부분
			 */			
			errorJobExecutionPerformance(curr_seq);					
//			errorJobExecutionPerformance(currSeq, de.toString());	// Error Remark					
			throw new EventException(de.getMessage());
		} finally {
			//무조건 임시 TABLE 지우기 2
			log.debug("\n 무조건 임시 TABLE 지우기 2 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP(event);
		}

		/**
		 * 3) DB에 성능LOG에 SC에서의 마침 시각을 남기는 부분
		 */ 
		endJobExecutionPerformance(curr_seq);
		
		return eventResponse;
	}

	/**
	 * Storage ByPool verify 하기
	 * @param e Event event object
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyStorageInvoiceCostByPool(Event e) throws EventException {

		log.debug("\n SC.verifyOffdockCYInvoiceCostByPool ------------------------  \n");

		EsdTes9152Event event = (EsdTes9152Event)e;
		EventResponse eventResponse = null;
		MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
		int insCnt = 0;

		try {
			//무조건 임시 TABLE 지우기1
			log.debug("\n 무조건 임시 TABLE 지우기1 ------------------------  \n");
			command.removeTES_FILE_IMP_TMPByPool(event);

			//임시 TABLE에 넣고
			log.debug("\n 임시 TABLE에 넣고 ------------------------  \n");
			command.createTES_FILE_IMP_TMPByPool(event);

//			//계산하기
//			log.debug("\n 계산하기 ------------------------  \n");
//			eventResponse = command.verifyStorageInvoiceCostByPool(event);
//			ESD_TES_9152EventResponse er = (ESD_TES_9152EventResponse)eventResponse;
//			er = (ESD_TES_9152EventResponse)eventResponse;
//			event.setRowSet(er.getRs());

			//계산하기
			log.debug("\n 계산하기 ------------------------  \n");
			eventResponse = command.verifyStorageInvoiceCostByPool(event); //계산하기
			event.setRowSet(eventResponse.getRs());
			
			//CNTR_LIST에 넣고
			log.debug("\n CNTR_LIST에 넣고 ------------------------  \n");
			begin();
			insCnt = command.insertStorageInvoiceDetail(event);
			commit();
			
			eventResponse.setETCData("insCnt", String.valueOf(insCnt));
			eventResponse.setETCData( "successFlag", "SUCCESS" );
						
//			//CNTR_LIST에 넣고
//			log.debug("\n CNTR_LIST에 넣고 ------------------------  \n");
//			begin();
//			insCnt = command.insertStorageInvoiceDetail(event);
//			commit();
//			er.setInsCnt(insCnt);
//			eventResponse = er;
		} catch (EventException de) {
			log.debug("\n EventException rollback ------------------------  \n");
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} finally {
			//무조건 임시 TABLE 지우기 2
			log.debug("\n 무조건 임시 TABLE 지우기 2 ------------------------  \n");
			command.removeTES_FILE_IMP_TMPByPool(event);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYInvoiceDetail(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event)e;

		GeneralEventResponse eventResponse = null;

		try {
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = (GeneralEventResponse)command.searchOffdockCYInvoiceDetail(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYInvoiceAllSheets(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event)e;

		GeneralEventResponse eventResponse = null;

		try {
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = (GeneralEventResponse)command.searchOffdockCYInvoiceAllSheets(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStorageInvoiceDetail(Event e) throws EventException {

		EsdTes0009Event event = (EsdTes0009Event)e;

		EventResponse eventResponse = null;

		try {
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			eventResponse = command.searchStorageInvoiceDetail(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStorageInvoiceAllSheets(Event e) throws EventException {

		EsdTes0009Event event = (EsdTes0009Event)e;

		EventResponse eventResponse = null;

		try {
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			eventResponse = command.searchStorageInvoiceAllSheets(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockRevisedVolume(Event e) throws EventException {

		EsdTes9030Event event = (EsdTes9030Event)e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdockRevisedVolume() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchRevisedVolume(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockRevisedVolumeForTMRFMO(Event e) throws EventException {

		EsdTes9034Event event = (EsdTes9034Event)e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdockRevisedVolumeForTMRFMO() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchRevisedVolumeForTMRFMO(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockRevisedVolumeSeparate(Event e) throws EventException {

		EsdTes9240Event event = (EsdTes9240Event)e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdockRevisedVolumeSeparate() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchRevisedVolumeSeparate(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
		
	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockRevisedVolumeDoubleBillChk(Event e) throws EventException {

		EsdTes9240Event event = (EsdTes9240Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		EventResponse eventResponse = null;  

		try {
			log.debug("\n\n SC - searchOffdockRevisedVolumeDoubleBillChk() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			String[] cntr = command.searchOffdockRevisedVolumeDoubleBillChk(event);
			eventResponse.setETCData("cntr_cnt", cntr[0]);  
			eventResponse.setETCData("cntr_no", cntr[1]);  
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockRevisedVolume2(Event e) throws EventException {

		EsdTes9074Event event = (EsdTes9074Event)e;

		GeneralEventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdockRevisedVolume2() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = (GeneralEventResponse)command.searchRevisedVolume2(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockRevisedVolumeSeparate2(Event e) throws EventException {

		EsdTes9075Event event = (EsdTes9075Event)e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdockRevisedVolumeSeparate2() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchRevisedVolumeSeparate2(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYReviseMode(Event e) throws EventException {

		EsdTes9030Event event = (EsdTes9030Event)e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdockCYReviseMode() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdockCYReviseMode(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYReviseModeForTMRFMO(Event e) throws EventException {

		EsdTes9034Event event = (EsdTes9034Event)e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdockCYReviseModeForTMRFMO() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdockCYReviseModeForTMRFMO(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYReviseModeSeparate(Event e) throws EventException {

		EsdTes9240Event event = (EsdTes9240Event)e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdockCYReviseModeSeparate() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdockCYReviseModeSeparate(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

//	private EventResponse searchOffdockCYRvisCntrListCdNSeparate(Event e) throws EventException {
//
//		EsdTes9240Event event = (EsdTes9240Event)e;
//
//		EventResponse eventResponse = null;
//
//		try {
//			log.debug("\n\n SC - searchOffdockCYRvisCntrListCdN() \n\n");
//			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
//			eventResponse = command.searchOffdockCYRvisCntrListCdNSeparate(event);
//		} catch (EventException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//		return eventResponse;
//	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYRvisCntrListCdMT(Event e) throws EventException {

		EsdTes9030Event event = (EsdTes9030Event)e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdockCYRvisCntrListCdMT() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdockCYRvisCntrListCdMT(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYRvisCntrListCdMTForTMRFMO(Event e) throws EventException {

		EsdTes9034Event event = (EsdTes9034Event)e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdockCYRvisCntrListCdMTForTMRFMO() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdockCYRvisCntrListCdMTForTMRFMO(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYRvisCntrListCdMTSeparate(Event e) throws EventException {

		EsdTes9240Event event = (EsdTes9240Event)e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdockCYRvisCntrListCdMTSeparate() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdockCYRvisCntrListCdMTSeparate(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYRvisCntrListCdDG(Event e) throws EventException {

		EsdTes9030Event event = (EsdTes9030Event)e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdockCYRvisCntrListCdDG() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdockCYRvisCntrListCdDG(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYRvisCntrListCdDGForTMRFMO(Event e) throws EventException {

		EsdTes9034Event event = (EsdTes9034Event)e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdockCYRvisCntrListCdDGForTMRFMO() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdockCYRvisCntrListCdDGForTMRFMO(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYRvisCntrListCdDGSeparate(Event e) throws EventException {

		EsdTes9240Event event = (EsdTes9240Event)e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdockCYRvisCntrListCdDGSeparate() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdockCYRvisCntrListCdDGSeparate(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYRvisCntrListCdRF(Event e) throws EventException {

		EsdTes9030Event event = (EsdTes9030Event)e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdockCYRvisCntrListCdRF() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdockCYRvisCntrListCdRF(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYRvisCntrListCdRFForTMRFMO(Event e) throws EventException {

		EsdTes9034Event event = (EsdTes9034Event)e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdockCYRvisCntrListCdRFForTMRFMO() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdockCYRvisCntrListCdRFForTMRFMO(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYRvisCntrListCdRFSeparate(Event e) throws EventException {

		EsdTes9240Event event = (EsdTes9240Event)e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdockCYRvisCntrListCdRFSeparate() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdockCYRvisCntrListCdRFSeparate(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYRvisCntrListCdAK(Event e) throws EventException {

		EsdTes9030Event event = (EsdTes9030Event)e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdockCYRvisCntrListCdAK() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdockCYRvisCntrListCdAK(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYRvisCntrListCdAKForTMRFMO(Event e) throws EventException {

		EsdTes9034Event event = (EsdTes9034Event)e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdockCYRvisCntrListCdAKForTMRFMO() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdockCYRvisCntrListCdAKForTMRFMO(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYRvisCntrListCdAKSeparate(Event e) throws EventException {

		EsdTes9240Event event = (EsdTes9240Event)e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdockCYRvisCntrListCdAKSeparate() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdockCYRvisCntrListCdAKSeparate(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * TPB 조회용 POPUP창에서 사용...
	 * @param e Event event object
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdock3rdIFlistOnly(Event e) throws EventException {

		EsdTes9253Event event = (EsdTes9253Event)e;

		GeneralEventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdock3rdIFlistOnly() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = (GeneralEventResponse)command.searchOffdock3rdIFlistOnly(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdock3rdIFlist(Event e) throws EventException {

		EsdTes9233Event event = (EsdTes9233Event)e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdock3rdIFlist() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdock3rdIFlist(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdock3rdIFlistByDay(Event e) throws EventException {

		EsdTes9233Event event = (EsdTes9233Event)e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdock3rdIFlistByDay() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdock3rdIFlistByDay(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiOffdock3rdIFlist(Event e) throws EventException {
		log.debug("at dbdao.multiOffdock3rdIFlist()" );

		EsdTes9233Event		event		= (EsdTes9233Event) e;
		/**
		 * Terminal Invoice Confirm 처리할때. TPB IF SVXXJO건 분석용 로그추가.(2010-04-27)
		 * # DB에 성능LOG에 SC에서의 시작 시각을 남기는 부분은 크게 3부분으로 나뉜다. 각가가 transaction을 분리하여 혹 문제가 발생하여도 기존 작업에 영향이 없도록 한다.
		 * 1) 시작 시각 찍기 - key가 되는 curr_seq를 생성하여 마침까지 넘겨야 한다. 한 SC의 작업에서는 하나의 sequence가 바람직하다.
		 * 2) 오류 시각 찍기 - 반드시 1)번에서 넘어온 현재의 key값이 있을 경우만 실행한다.
		 * 3) 마침 시각 찍기 - 반드시 1)번에서 넘어온 현재의 key값이 있을 경우만 실행한다.
		 * 
		 * 
		 * 1) DB에 성능LOG에 SC에서의 시작 시각을 남기는 부분 - 시작부분이 완료되면 반드시 현재의 SEQUENCE를 마칠때까지 넘겨야 한다.
		 * <주> param_map으로 담는 인자값들은 작업에 따라 다르니 그때마다 각각 설정해야한다.
		 */		
		
//		TesN3rdPtyIfVO[]	tesN3rdPtyIfVOs 	= null;
		String				currSeq				= null;
		
//		// TPB IF 누락건 분석위한 로그추가.(2010-05-03)
//		try {
//			tesN3rdPtyIfVOs		= event.getTesN3rdPtyIfVOs();
//			
//			TesJbExePerfLogVO	tesJbExePerfLogVO	= new TesJbExePerfLogVO();
//			StringBuilder		sbuPerfRmk			= new StringBuilder();
//			int					insFlgCnt			= 0;	// INSERT
//			int					updFlgCnt			= 0;	// UPDATE
//			
//			for( int i = 0; tesN3rdPtyIfVOs != null && i < tesN3rdPtyIfVOs.length; i++ ) {
//				if ( "I".equals(tesN3rdPtyIfVOs[i].getIbflag() ) ) {
//					insFlgCnt++;
//				}
//				if ( "U".equals(tesN3rdPtyIfVOs[i].getIbflag() ) ) {
//					updFlgCnt++;
//				}
//			}
//
//			if ( insFlgCnt > 0 ) {
//				sbuPerfRmk.append("C");
//			}
//			if ( updFlgCnt > 0 ) {
//				sbuPerfRmk.append("U");
//			}
//			
//			// TPB DELETE.
//			String	delIfSeq	= JSPUtil.getNull(event.getOffdockCYInvoiceManageVO().getDelIfSeq());
//			if ( delIfSeq.length() > 0 ) {
//				delIfSeq	= delIfSeq.substring( 0, delIfSeq.length() - 1 ); 		//.replaceAll("\\|", ",");
//				String	[]	arrIfSeq	= delIfSeq.split("\\|");
//				
//				sbuPerfRmk.append("D(" + arrIfSeq.length + ")"); // 삭제 건수.
//			}
//
//			tesJbExePerfLogVO.setInvOfcCd		( e.getSignOnUserAccount().getOfc_cd() );
//			tesJbExePerfLogVO.setExeUsrId		( e.getSignOnUserAccount().getUsr_id() );
//			tesJbExePerfLogVO.setJbTpCd			( TESCommonBC.PERF_JOB_TYPE_TPB );
//			tesJbExePerfLogVO.setPgmUrl			( (event.getPageURL() != null && !"".equals(event.getPageURL()) ? event.getPageURL().trim():JSPUtil.getNull( event.getEventName() ) ) );			
//			tesJbExePerfLogVO.setFuncDivCd		( String.valueOf(event.getFormCommand().getCommand()) );
//			tesJbExePerfLogVO.setExeRowKnt		( tesN3rdPtyIfVOs != null ? Integer.toString( tesN3rdPtyIfVOs.length ) : "" );
//			tesJbExePerfLogVO.setTmlSoOfcCtyCd	( event.getTesN3rdPtyIfVO().getTmlSoOfcCtyCd() );
//			tesJbExePerfLogVO.setTmlSoSeq		( event.getTesN3rdPtyIfVO().getTmlSoSeq() );
//			tesJbExePerfLogVO.setJbParaCtnt		( event.getPerfParams() );
//			tesJbExePerfLogVO.setPerfRmk		( sbuPerfRmk.toString() );
//			
//			currSeq = beginJobExecutionPerformance( tesJbExePerfLogVO );
//		} catch (Exception ex){
//			//본 업무에 영향을 안주기 위해 Exception을 던지지 않는다.
//			log.error(ex.getMessage());
//			if (false){
//				throw new EventException(ex.getMessage());
//			}
//		}
		
		currSeq = searchCurrSeq(e);

		String calc_cost_grp_cd = JSPUtil.getNull( event.getOffdockCYInvoiceManageVO().getCalcCostGrpCd());
		
		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.multiOffdock3rdIFlist(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			/**
			 * 2) DB에 성능LOG에 SC에서의 오류 발생 시각을 남기는 부분
			 */			
			errorJobExecutionPerformance(currSeq);
//			errorJobExecutionPerformance(currSeq, de.toString());	// Error Remark					
			throw new EventException(de.getMessage());
		} finally {
			/**
			 * 3) DB에 성능LOG에 SC에서의 마침 시각을 남기는 부분
			 */ 
			endJobExecutionPerformance(currSeq);
		}

		if ("SD".equals(calc_cost_grp_cd)) {
			return searchOffdock3rdIFlistByDay(e);
		} else {
			return searchOffdock3rdIFlist(e);
		}
	}
	
	//SP에서 3rd Party Billing은 더이상 제공하지 않는다. 2009.10.05
//	private EventResponse searchOffdock3rdIFlistByPool(Event e) throws EventException {
//
//		EsdTes9233Event event = (EsdTes9233Event)e;
//
//		EventResponse eventResponse = null;
//
//		try {
//			log.debug("\n\n SC - searchOffdock3rdIFlistByPool() \n\n");
//			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
//			eventResponse = command.searchOffdock3rdIFlistByPool(event);
//		} catch (EventException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//		return eventResponse;
//	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStorage3rdIFlistOnly(Event e) throws EventException {
		log.debug("SC.searchStorage3rdIFlistOnly ###############################");
		EsdTes9254Event event = (EsdTes9254Event)e;

		GeneralEventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchStorage3rdIFlistOnly() \n\n");
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			eventResponse = (GeneralEventResponse)command.searchStorage3rdIFlistOnly(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

//	private EventResponse searchStorage3rdIFlist(Event e) throws EventException {
//		log.debug("SC.searchStorage3rdIFlist ###############################");
//		EsdTes9234Event event = (EsdTes9234Event)e;
//
//		EventResponse eventResponse = null;
//
//		try {
//			log.debug("\n\n SC - searchStorage3rdIFlist() \n\n");
//			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
//			eventResponse = command.searchStorage3rdIFlist(event);
//		} catch (EventException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//		return eventResponse;
//	}

//	private EventResponse searchStorage3rdIFlistByPool(Event e) throws EventException {
//		log.debug("SC.searchStorage3rdIFlistByPool ###############################");
//		EsdTes9234Event event = (EsdTes9234Event)e;
//
//		EventResponse eventResponse = null;
//
//		try {
//			log.debug("\n\n SC - searchStorage3rdIFlistByPool() \n\n");
//			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
//			eventResponse = command.searchStorage3rdIFlistByPool(event);
//		} catch (EventException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//		return eventResponse;
//	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStorage3rdIFlistByDay(Event e) throws EventException {
		log.debug("SC.searchStorage3rdIFlistByDay ###############################");
		EsdTes9234Event event = (EsdTes9234Event)e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchStorage3rdIFlistByDay() \n\n");
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			eventResponse = command.searchStorage3rdIFlistByDay(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiStorage3rdIFlist(Event e) throws EventException {

		/**
		 * Terminal Invoice Confirm 처리할때. TPB IF SVXXJO건 분석용 로그추가.(2010-04-27)
		 * # DB에 성능LOG에 SC에서의 시작 시각을 남기는 부분은 크게 3부분으로 나뉜다. 각가가 transaction을 분리하여 혹 문제가 발생하여도 기존 작업에 영향이 없도록 한다.
		 * 1) 시작 시각 찍기 - key가 되는 curr_seq를 생성하여 마침까지 넘겨야 한다. 한 SC의 작업에서는 하나의 sequence가 바람직하다.
		 * 2) 오류 시각 찍기 - 반드시 1)번에서 넘어온 현재의 key값이 있을 경우만 실행한다.
		 * 3) 마침 시각 찍기 - 반드시 1)번에서 넘어온 현재의 key값이 있을 경우만 실행한다.
		 * 
		 * 
		 * 1) DB에 성능LOG에 SC에서의 시작 시각을 남기는 부분 - 시작부분이 완료되면 반드시 현재의 SEQUENCE를 마칠때까지 넘겨야 한다.
		 * <주> param_map으로 담는 인자값들은 작업에 따라 다르니 그때마다 각각 설정해야한다.
		 */		
//		EsdTes9234Event		event		= (EsdTes9234Event)e;
		
//		TesN3rdPtyIfVO[]	tesN3rdPtyIfVOs 	= null;
		String				currSeq				= null;
		
//		// TPB IF 누락건 분석위한 로그추가.(2010-05-03)
//		try {
//			tesN3rdPtyIfVOs		= event.getTesN3rdPtyIfVOs();
//			
//			TesJbExePerfLogVO	tesJbExePerfLogVO	= new TesJbExePerfLogVO();
//			StringBuilder		sbuPerfRmk			= new StringBuilder();
//			int					insFlgCnt			= 0;	// INSERT
//			int					updFlgCnt			= 0;	// UPDATE
//			
//			for( int i = 0; tesN3rdPtyIfVOs != null && i < tesN3rdPtyIfVOs.length; i++ ) {
//				if ( "I".equals(tesN3rdPtyIfVOs[i].getIbflag() ) ) {
//					insFlgCnt++;
//				}
//				if ( "U".equals(tesN3rdPtyIfVOs[i].getIbflag() ) ) {
//					updFlgCnt++;
//				}
//			}
//
//			if ( insFlgCnt > 0 ) {
//				sbuPerfRmk.append("C");
//			}
//			if ( updFlgCnt > 0 ) {
//				sbuPerfRmk.append("U");
//			}
//			
//			// TPB DELETE.
//			String	delIfSeq	= JSPUtil.getNull(event.getMarineTerminalStorageInvoiceManageVO().getDelIfSeq());
//			if ( delIfSeq.length() > 0 ) {
//				delIfSeq	= delIfSeq.substring( 0, delIfSeq.length() - 1 ); 		//.replaceAll("\\|", ",");
//				String	[]	arrIfSeq	= delIfSeq.split("\\|");
//				
//				sbuPerfRmk.append("D(" + arrIfSeq.length + ")"); // 삭제 건수.
//			}
//
//			tesJbExePerfLogVO.setInvOfcCd		( e.getSignOnUserAccount().getOfc_cd() );
//			tesJbExePerfLogVO.setExeUsrId		( e.getSignOnUserAccount().getUsr_id() );
//			tesJbExePerfLogVO.setJbTpCd			( TESCommonBC.PERF_JOB_TYPE_TPB );
//			tesJbExePerfLogVO.setPgmUrl			( (event.getPageURL() != null && !"".equals(event.getPageURL()) ? event.getPageURL().trim():JSPUtil.getNull( event.getEventName() ) ) );			
//			tesJbExePerfLogVO.setFuncDivCd		( String.valueOf(event.getFormCommand().getCommand()) );
//			tesJbExePerfLogVO.setExeRowKnt		( tesN3rdPtyIfVOs != null ? Integer.toString( tesN3rdPtyIfVOs.length ) : "" );
//			tesJbExePerfLogVO.setTmlSoOfcCtyCd	( event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd() );
//			tesJbExePerfLogVO.setTmlSoSeq		( event.getTesTmlSoHdrVO().getTmlSoSeq() );
//			tesJbExePerfLogVO.setJbParaCtnt		( event.getPerfParams() );
//			tesJbExePerfLogVO.setPerfRmk		( sbuPerfRmk.toString() );
//			
//			currSeq = beginJobExecutionPerformance( tesJbExePerfLogVO );
//		} catch (Exception ex){
//			//본 업무에 영향을 안주기 위해 Exception을 던지지 않는다.
//			log.error(ex.getMessage());
//			if (false){
//				throw new EventException(ex.getMessage());
//			}
//		}
		
		currSeq = searchCurrSeq(e);

		try {
			begin();
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			command.multiStorage3rdIFlist(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			/**
			 * 2) DB에 성능LOG에 SC에서의 오류 발생 시각을 남기는 부분
			 */			
			errorJobExecutionPerformance(currSeq);
//			errorJobExecutionPerformance(currSeq, de.toString());	// Error Remark					
			throw new EventException(de.getMessage());
		} finally {
			/**
			 * 3) DB에 성능LOG에 SC에서의 마침 시각을 남기는 부분
			 */ 
			endJobExecutionPerformance(currSeq);
		}
		return searchStorage3rdIFlistByDay(e);
	}
	
	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYTotalAmount(Event e) throws EventException {

		EsdTes9050Event event = (EsdTes9050Event)e;

		GeneralEventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdockCYTotalAmount() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = (GeneralEventResponse)command.searchOffdockCYTotalAmount(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStorageTotalAmount(Event e) throws EventException {
		EsdTes9060Event event 			= (EsdTes9060Event)e;
		EventResponse 	eventResponse 	= null;

		try {
			log.debug("\n\n SC - searchStorageTotalAmount() \n\n");
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			eventResponse = command.searchOnDockTotalAmount(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYContainerList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EsdTes0004Event event = (EsdTes0004Event)e;
		EventResponse eventResponse = null;

		try {
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdockCYContainerList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}


	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStorageContainerList(Event e) throws EventException {

		EsdTes0009Event event = (EsdTes0009Event)e;

		EventResponse eventResponse = null;

		try {
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			eventResponse = command.searchStorageContainerList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYInvoiceBasicInfo(Event e) throws EventException {
		log.debug("at SC.searchOffdockCYInvoiceBasicInfo");
		EsdTes0004Event event = (EsdTes0004Event)e;

		EventResponse eventResponse = null;

		try {
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdockCYInvoiceBasicInfo(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYInvoiceRejectInfo(Event e) throws EventException {

		log.debug("\n\n\n  SC.searchOffdockCYInvoiceRejectInfo  \n");

		EsdTes0004Event event = (EsdTes0004Event)e;

		EventResponse eventResponse = null;

		try {
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdockCYInvoiceRejectInfo(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}


	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStorageInvoiceBasicInfo(Event e) throws EventException {

		EsdTes0009Event event = (EsdTes0009Event)e;
		EventResponse eventResponse = null;

		try {
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			eventResponse = command.searchStorageInvoiceBasicInfo(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
		
	}


	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStorageInvoiceRejectInfo(Event e) throws EventException {

		EsdTes0009Event event = (EsdTes0009Event)e;

		EventResponse eventResponse = null;

		try {
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			eventResponse = command.searchStorageInvoiceRejectInfo(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}


	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYCostCalcSts(Event e) throws EventException {
		log.debug("\n searchOffdockCYCostCalcSts \n");

		EsdTes0004Event event = (EsdTes0004Event)e;

		EventResponse eventResponse = null;

		try {
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdockCYCostCalcSts(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyOffdockCYInvoiceConfirm(Event e) throws EventException {
		log.debug("\n SC.modifyOffdockCYInvoiceConfirm  \n");

		EsdTes0004Event event = (EsdTes0004Event)e;


		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			TESInvoiceCommonBC		    commandCom 		= new TESInvoiceCommonBCImpl();
			
			log.debug("(EsdTes0004Event)e).getTesTmlSoHdrVO().getTmlInvStsCd()============>"+((EsdTes0004Event)e).getTesTmlSoHdrVO().getTmlInvStsCd());
			//2010.11.03 장병용 부장님 요청  inv에서 cost code 별 auto 유무 체크로직 추가
			String ofc_cd = event.getSignOnUserAccount().getOfc_cd();
			if(!ofc_cd.equals("SELTBB")){	//2015-08-03 그룹사 조직 코드 변경 (SELTOB -> SELTBB)
				commandCom.checkInvCalcCostCD(event.getTesTmlSoHdrVO());
			}
			
			command.modifyOffdockCYInvoiceConfirm(event);
			command.updateOffdockCYAccountCode(event);
			
			//[CHM-201534788]GW Agmt Link 기준 변경 (Save->Confirm)	2015-03-24
			//[CHM-201640117]유효 AGMT 판단 Date와 Invoice Confirm시 가져오는 GW AGMT date 일치 
			String fromDate = event.getTesTmlSoHdrVO().getToPrdDt();
			String toDate = event.getTesTmlSoHdrVO().getToPrdDt();
			commandCom.updateInvoiceDetailAgmt(event.getTesTmlSoHdrVO(), fromDate, toDate);
			
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockCYInvoiceBasicInfo(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelOffdockCYInvoiceConfirm(Event e) throws EventException {
		log.debug("\n SC.cancelOffdockCYInvoiceConfirm  \n");

		EsdTes0004Event event = (EsdTes0004Event)e;

		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.cancelOffdockCYInvoiceConfirm(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockCYInvoiceBasicInfo(e);
	}

	/**
	 * reject상태를 정상('NL')으로 설정한다.
	 * @param e Event event object
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelOffdockCYInvoiceReject(Event e) throws EventException {
		log.debug("\n SC.cancelOffdockCYInvoiceReject  \n");

		EsdTes0004Event event = (EsdTes0004Event)e;

		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.cancelOffdockCYInvoiceReject(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockCYInvoiceRejectInfo(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyStorageInvoiceConfirm(Event e) throws EventException {
		log.debug("\n SC.modifyStorageInvoiceConfirm  \n");

		EsdTes0009Event event = (EsdTes0009Event)e;

		try {
			begin();
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			TESInvoiceCommonBC		    commandCom 		= new TESInvoiceCommonBCImpl();
			
			log.debug("(EsdTes0009Event)e).getTesTmlSoHdrVO().getTmlInvStsCd()============>"+((EsdTes0009Event)e).getTesTmlSoHdrVO().getTmlInvStsCd());
			//2010.11.03 장병용 부장님 요청  inv에서 cost code 별 auto 유무 체크로직 추가			String ofc_cd = ((EsdTes0004Event)e).getSignOnUserAccount().getOfc_cd();
			String ofc_cd = ((EsdTes0009Event)e).getSignOnUserAccount().getOfc_cd();
			if(!ofc_cd.equals("SELTBB")){	//2015-08-03 그룹사 조직 코드 변경 (SELTOB -> SELTBB)
				commandCom.checkInvCalcCostCD(((EsdTes0009Event)e).getTesTmlSoHdrVO());
			}
			
			command.modifyStorageInvoiceConfirm(event);
			command.updateStorageAccountCode(event);
			
			//[CHM-201534788]GW Agmt Link 기준 변경 (Save->Confirm)	2015-03-24
			//[CHM-201640117]유효 AGMT 판단 Date와 Invoice Confirm시 가져오는 GW AGMT date 일치 
			String fromDate = event.getTesTmlSoHdrVO().getToPrdDt();
			String toDate = event.getTesTmlSoHdrVO().getToPrdDt();
			commandCom.updateInvoiceDetailAgmt(event.getTesTmlSoHdrVO(), fromDate, toDate);
			
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchStorageInvoiceBasicInfo(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelStorageInvoiceConfirm(Event e) throws EventException {
		log.debug("\n SC.cancelStorageInvoiceConfirm  \n");

		EsdTes0009Event event = (EsdTes0009Event)e;

		try {
			begin();
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			command.cancelStorageInvoiceConfirm(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchStorageInvoiceBasicInfo(e);
	}

	/**
	 * Off Dock CY Invoice Creation & Correction - insert TES_TML_SO_HDR
	 * @param e Event event object
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createOffdockCYInvoiceBasicInfo(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event)e;
		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.createOffdockCYInvoiceBasicInfo(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockCYInvoiceBasicInfo(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createStorageInvoiceBasicInfo(Event e) throws EventException {

		EsdTes0009Event event = (EsdTes0009Event)e;

		try {
			begin();
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			command.createStorageInvoiceBasicInfo(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchStorageInvoiceBasicInfo(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyOffdockCYInvoice(Event e) throws EventException {
		
		log.debug("\n\n\n  SC.modifyOffdockCYInvoice  \n");
		
		EsdTes0004Event event = (EsdTes0004Event)e;

		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.modifyOffdockCYInvoice(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockCYInvoiceBasicInfo(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyOffdockCYInvoiceReject(Event e) throws EventException {

		log.debug("\n\n\n  SC.modifyOffdockCYInvoiceReject  \n");

		EsdTes0004Event event = (EsdTes0004Event)e;

		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.modifyOffdockCYInvoiceReject(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockCYInvoiceRejectInfo(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyStorageInvoiceReject(Event e) throws EventException {

		log.debug("\n\n\n  SC.modifyStorageInvoiceReject  \n");

		EsdTes0009Event event = (EsdTes0009Event)e;

		try {
			begin();
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			command.modifyStorageInvoiceReject(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchStorageInvoiceRejectInfo(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelStorageInvoiceReject(Event e) throws EventException {

		log.debug("\n\n\n  SC.cancelStorageInvoiceReject  \n");

		EsdTes0009Event event = (EsdTes0009Event)e;

		try {
			begin();
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			command.cancelStorageInvoiceReject(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchStorageInvoiceRejectInfo(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyStorageInvoice(Event e) throws EventException {

		EsdTes0009Event event = (EsdTes0009Event)e;

		try {
			begin();
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			command.modifyStorageInvoice(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchStorageInvoiceBasicInfo(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeOffdockCYInvoice01(Event e) throws EventException {

		
		EsdTes0004Event event = (EsdTes0004Event)e;

		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.removeOffdockCYInvoiceContainerList(event);
			command.removeOffdockCYInvoiceRvis(event);
			command.removeOffdockCYInvoiceN3rd01(event);
			command.removeOffdockCYInvoiceDetailTMNL(event);
			command.removeOffdockCYInvoiceDetailByDay(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockCYInvoiceBasicInfo(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeOffdockCYInvoice02(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event)e;

		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.removeOffdockCYInvoiceN3rd02(event);
			command.removeOffdockCYInvoiceDetailByPool(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockCYInvoiceBasicInfo(e);
	}

	/**
	 * Calc.TMNL과 Calc.ByDay sheet의 자동 계산 시 기존 data 삭제
	 * @param e Event event object
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeOffdockCYInvoiceAutoCalcData(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event)e;

		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.removeOffdockCYAutoCalcTMNL(event);
			command.removeOffdockCYAutoCalcByDay(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockCYInvoiceDetail(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeOffdockCYInvoiceAutoCalcData2(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event)e;

		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.removeOffdockCYAutoCalcByPool(event);
			commit();
			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockCYInvoiceDetail(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeOffdockCYInvoiceAllCalcData(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event)e;

		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			
			command.removeOffdockCYInvoiceRvis(event);
			command.removeOffdockCYInvoiceN3rd01(event);
			
			command.removeOffdockCYInvoiceDetailTMNL(event);
			command.removeOffdockCYInvoiceDetailByDay(event);
			command.removeOffdockCYInvoiceDetailByPool(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockCYInvoiceDetail(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeOffdockCYInvoiceAutoCalcDataAllCalcTab(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event)e;

		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.removeOffdockCYAutoCalcTMNL(event);
			command.removeOffdockCYAutoCalcByDay(event);
			command.removeOffdockCYAutoCalcByPool(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockCYInvoiceDetail(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeStorageInvoice01(Event e) throws EventException {

		EsdTes0009Event event = (EsdTes0009Event)e;

		try {
			begin();
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			command.removeStorageInvoiceContainerList(event);
			command.removeStorageInvoiceN3rd01(event);
			command.removeStorageInvoiceDetailByDay(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchStorageInvoiceBasicInfo(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeStorageInvoice02(Event e) throws EventException {

		EsdTes0009Event event = (EsdTes0009Event)e;

		try {
			begin();
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			command.removeStorageInvoiceN3rd02(event);
			command.removeStorageInvoiceDetailByPool(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchStorageInvoiceBasicInfo(e);
	}

	/**
	 * @param e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeStorageInvoiceAutoCalcData(Event e) throws EventException {

		EsdTes0009Event event = (EsdTes0009Event)e;

		try {
			begin();
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			command.removeStorageAutoCalcByDay(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchStorageInvoiceDetail(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeStorageInvoiceAutoCalcData2(Event e) throws EventException {

		EsdTes0009Event event = (EsdTes0009Event)e;

		try {
			begin();
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			command.removeStorageAutoCalcByPool(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchStorageInvoiceDetail(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeStorageInvoiceAllCalcData(Event e) throws EventException {

		EsdTes0009Event event = (EsdTes0009Event)e;

		try {
			begin();
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			command.removeStorageInvoiceN3rd01(event);
			command.removeStorageInvoiceDetailByDay(event);
			command.removeStorageInvoiceDetailByPool(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchStorageInvoiceDetail(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeStorageInvoiceAutoCalcDataAllCalcTab(Event e) throws EventException {

		EsdTes0009Event event = (EsdTes0009Event)e;

		try {
			begin();
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			command.removeStorageAutoCalcByDay(event);
			command.removeStorageAutoCalcByPool(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchStorageInvoiceDetail(e);
	}

	/**
	 * OffdockCYInvoiceContainerList Multi 이벤트 처리<br>
	 * OffdockCYInvoiceContainerList event에 대한 OffdockCYInvoiceContainerList Multi 이벤트 처리<br>
	 * @param e Event event object
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createOffdockCYInvoiceContainerList(Event e) throws EventException {

		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.createOffdockCYInvoiceContainerList(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockCYContainerList(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createStorageInvoiceContainerList(Event e) throws EventException {

		EsdTes0009Event event = (EsdTes0009Event)e;

		try {
			begin();
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			command.createStorageInvoiceContainerList(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchStorageContainerList(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiReviseCalculatedVolume(Event e) throws EventException {

		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.multiReviseCalculatedVolume(e);
			command.recalculateReviseCalculatedVolumeCount(e);
			command.recalculateOffdocCYInvoiceCostAmount(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockRevisedVolume(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiReviseCalculatedVolumeForTMRFMO(Event e) throws EventException {

		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.multiReviseCalculatedVolumeForTMRFMO(e);
			command.recalculateReviseCalculatedVolumeCountForTMRFMO(e);
			command.recalculateOffdocCYInvoiceCostAmountForTMRFMO(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockRevisedVolumeForTMRFMO(e);
	}
	
	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiReviseCalculatedVolumeM(Event e) throws EventException {

		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.multiReviseCalculatedVolumeM(e);
			command.recalculateReviseCalculatedVolumeCountM(e);

			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockRevisedVolume(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiReviseCalculatedVolumeMForTMRFMO(Event e) throws EventException {

		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.multiReviseCalculatedVolumeMForTMRFMO(e);
			command.recalculateReviseCalculatedVolumeCountMForTMRFMO(e);

			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockRevisedVolumeForTMRFMO(e);
	}
	
	/**
	 * Revised Vol. Separate - Auto
	 * @param e Event event object
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiReviseCalculatedVolumeSeparate(Event e) throws EventException {

		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.multiReviseCalculatedVolumeSeparate(e);
			command.recalculateReviseCalculatedVolumeCountSeparate(e);
			command.recalculateOffdocCYInvoiceCostAmountSeparate(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockRevisedVolumeSeparate(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiReviseCalculatedVolumeSeparateM(Event e) throws EventException {

		// ESD_TES_924Event event = (ESD_TES_924Event)e;

		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.multiReviseCalculatedVolumeSeparateM(e);
			command.recalculateReviseCalculatedVolumeCountSeparateM(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockRevisedVolumeSeparate(e);
	}
	
	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createOffdockCYInvoiceDetail(Event e) throws EventException {
		try {
			log.debug("in createOffdockCYInvoiceDetail");
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.createOffdockCYInvoiceDetail(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return searchOffdockCYInvoiceDetail(e);
	}
    
	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createStorageInvoiceDetail(Event e) throws EventException {

		EsdTes0009Event event = (EsdTes0009Event)e;

		try {
			begin();
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			command.createStorageInvoiceDetail(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchStorageInvoiceDetail(e);
	}
	
	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCSRSOlist(Event e) throws EventException {
		log.debug("start searchCSRSOlist ===================");
		
		EsdTes0025Event event 			= (EsdTes0025Event)e;
		EventResponse 	eventResponse 	= null;

		try {
			log.debug("\n\n SC - searchCSRSOlist() ================================ \n\n");
			CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
			eventResponse = command.searchCSRSOlist(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCSRSOhdr(Event e) throws EventException {
		log.debug("\n\n start SC - searchCSRSOhdr() ========================= \n\n");
		EsdTes0101Event event = (EsdTes0101Event)e;
		EventResponse eventResponse = null;

		try {
			CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
			eventResponse = command.searchCSRSOhdr(event);
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCSRSOlist2(Event e) throws EventException {
		log.debug("\n\n SC - searchCSRSOlist2()  ================================== \n\n");
		
		EsdTes0101Event event = (EsdTes0101Event)e;
		EventResponse eventResponse = null;

		try {
			CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
			eventResponse = command.searchCSRSOlist2(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiRejectedCSRCancellation(Event e) throws EventException {
		log.debug("\n\n SC - multiRejectedCSRCancellation() ==================== \n\n");
		EsdTes0025Event event = (EsdTes0025Event)e;

		try {
			begin();
			CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
			command.multiRejectedCSRCancellation(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return searchCSRSOlist(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiConfirmCSR(Event e) throws EventException {
		log.debug("\n\n SC - multiConfirmCSR() =================== \n\n");
		EsdTes0100Event event = (EsdTes0100Event)e;
		CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();

		try {
			begin();
			command.multiConfirmCSR(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return searchCSRAPiflist(e);
	}
	
	/**
	 * Approval Requested상태인 CSR만 cancel처리 한다. 
	 * - 이 경우 반드시 공통 결재 정보는 공통module에서 제공하는 BC method로 삭제하고 AP정보를 cancel처리한다.	 * 
	 * @param e Event event object
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelCSR(Event e) throws EventException {
		log.debug("\n\n SC - cancelCSR() \n");
		EsdTes0100Event event = (EsdTes0100Event)e;
		CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
		
		ApInvHdrVO vo = event.getApInvHdrVO();
		ComCsrInfoVO comCsrInfoVO =new ComCsrInfoVO();		
		ApprovalUtil aproUtil = new ApprovalUtil();

		try {
			begin();
			new com.hanjin.bizcommon.approval.basic.ApprovalBCImpl().cancelApproval(JSPUtil.getNull(vo.getCsrNo()));
			command.cancelCSR(event);
			
			//CSR Cancel 처리시 USR_APRO_STEP_FLG = ''으로 업데이트
			comCsrInfoVO.setCsrNo(JSPUtil.getNull(vo.getCsrNo()));
			comCsrInfoVO.setCsrAproTpCd(vo.getCsrTpCd());
			aproUtil.updateAproGwDt(comCsrInfoVO);
			
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return searchCSRAPiflist(e);
	}

	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCSRAPiflist(Event e) throws EventException {

		log.debug("\n\n SC - searchCSRAPiflist() \n\n");

		EsdTes0100Event event = (EsdTes0100Event)e;

		EventResponse eventResponse = null;

		try {
			CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
			eventResponse = command.searchCSRAPiflist(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/******** YOO 끝 *****************************/


	/******** Moon 시작 *****************************/
	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYInvoiceBasicInfoInquiry(Event e) throws EventException {
		
		log.debug(">>>>>>>>>>> searchOffdockCYInvoiceBasicInfoInquiry");
		
		EsdTes0018Event event = (EsdTes0018Event)e;

		GeneralEventResponse eventResponse = null;

		try {
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = (GeneralEventResponse)command.searchOffdockCYInvoiceBasicInfoInquiry(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

//	[0018]조회에서는 사용안하는 함수
//	private EventResponse searchOffdockCYContainerListInquiry(Event e) throws EventException {
//		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
//		EsdTes0018Event event = (EsdTes0018Event)e;
//		GeneralEventResponse eventResponse = null;
//
//		try {
//			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
//			eventResponse = (GeneralEventResponse)command.searchOffdockCYContainerListInquiry(event);
//		} catch (EventException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//		return eventResponse;
//	}

//	[0018]조회에서는 사용안하는 함수
//	private EventResponse calOffdockCYInvoiceCostInquiry(Event e) throws EventException {
//
//		EsdTes0018Event event = (EsdTes0018Event)e;
//
//		EventResponse eventResponse = null;
//
//		try {
//			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
//			eventResponse = command.calOffdockCYInvoiceCostInquiry(event);
//		} catch (EventException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//		return eventResponse;
//	}

//	[0018]조회에서는 사용안하는 함수
//	private EventResponse searchOffdockCYInvoiceDetailInquiry(Event e) throws EventException {
//
//		EsdTes0018Event event = (EsdTes0018Event)e;
//
//		GeneralEventResponse eventResponse = null;
//
//		try {
//			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
//			eventResponse = (GeneralEventResponse)command.searchOffdockCYInvoiceDetailInquiry(event);
//		} catch (EventException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//		return eventResponse;
//	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYInvoiceAllSheetsInquiry(Event e) throws EventException {

		log.debug("\n SC.searchOffdockCYInvoiceAllSheetsInquiry 111 -------------- \n");

		EsdTes0018Event event = (EsdTes0018Event)e;

		GeneralEventResponse eventResponse = null;

		try {
			log.debug("\n SC.searchOffdockCYInvoiceAllSheetsInquiry 222 debug -------------- \n");
			log.error("\n SC.searchOffdockCYInvoiceAllSheetsInquiry 222 error -------------- \n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			
			eventResponse = (GeneralEventResponse)command.searchOffdockCYInvoiceAllSheetsInquiry(event);
			
			log.debug("\n SC.searchOffdockCYInvoiceAllSheetsInquiry 333 -------------- \n");
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse;
	}
    /******** Moon 끝 *****************************/



	/******** JINJOO 시작 *****************************/
//	private EventResponse searchStorageInvoiceDetail2(Event e) throws EventException {
//
//		ESD_TES_019Event event = (ESD_TES_019Event)e;
//
//		EventResponse eventResponse = null;
//
//		try {
//			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
//			eventResponse = command.searchStorageInvoiceDetail2(event);
//		} catch (EventException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//		return eventResponse;
//	}


 /**
  * Storage Container 목록
  * @param e Event event object
  * @return EventResponse
  * @exception EventException
  */
	private EventResponse searchStorageContainerList2(Event e) throws EventException {

		EsdTes0019Event event = (EsdTes0019Event)e;

		GeneralEventResponse eventResponse = null;

		try {
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			eventResponse = (GeneralEventResponse)command.searchStorageContainerList2(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * header 정보 조회 (main sheet)
	 * @param e Event event object
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStorageInvoiceBasicInfo2(Event e) throws EventException {

		EsdTes0019Event event = (EsdTes0019Event)e;
		if(log.isDebugEnabled()) log.debug("\n\n***********ServiceProviderInvoiceManageSC : searchStorageInvoiceBasicInfo2 ************\n");
		GeneralEventResponse eventResponse = null;

		try {
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			eventResponse = (GeneralEventResponse)command.searchStorageInvoiceBasicInfo2(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}




	/*
	 * On-Dock Rail Charge ContanerList Inquiry Start
	 * @author : kimjinjoo
	 */
	/**
	 * 사용자가 입력한 Inv No, Vndr Seq에 해당하는 TerminalInvoice 조회 이벤트 처리<br>
	 * On-dockRa Rail Charge Container List 조회 화면에 대한 이벤트 처리<br>
	 *
	 * @param e Event EsdTes0068Event
	 * @return eventResponse  ESD_TES_0068EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOndockRailChargeBasicInfo2(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		EsdTes0068Event event = (EsdTes0068Event)e;

		try {
			begin();
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			eventResponse = command.searchOndockRailChargeBasicInfo2(event);
			if(log.isDebugEnabled())log.debug("==========ServiceProviderInvoiceManageSC    searchOndockRailChargeBasicInfo2() commit Before");
			commit();
			if(log.isDebugEnabled())log.debug("==========ServiceProviderInvoiceManageSC    searchOndockRailChargeBasicInfo2() commit After");

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * OnDockRailChargeInvoiceManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOndockRailChargeContainerList2(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0068Event event = (EsdTes0068Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		if(log.isDebugEnabled())log.debug("==========ServiceProviderInvoiceManageSC    searchOndockRailChargeContainerList2() ============");
		try {
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			eventResponse = command.searchOndockRailChargeContainerList2(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}




	/**
	 * Terminal Invoice 조회화면 - Summary
	 * @author kimjinjoo
	 */

	/**
	 * 조회 이벤트 처리<br>
	 * marineterminalinvoicemanage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTerminalInvoiceSummary(Event e) throws EventException {
		log.debug("*******ServiceProviderInvoiceManageSC : searchTerminalInvoiceSummary********\n");
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0013Event event = (EsdTes0013Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		/**
		 * 2009-03-11 (2009-04-27 : 날짜 주석 추가 및 수정)
		 * # DB에 성능LOG에 SC에서의 시작 시각을 남기는 부분은 크게 3부분으로 나뉜다. 각가가 transaction을 분리하여 혹 문제가 발생하여도 기존 작업에 영향이 없도록 한다.
		 * 1) 시작 시각 찍기 - key가 되는 curr_seq를 생성하여 마침까지 넘겨야 한다. 한 SC의 작업에서는 하나의 sequence가 바람직하다.
		 * 2) 오류 시각 찍기 - 반드시 1)번에서 넘어온 현재의 key값이 있을 경우만 실행한다.
		 * 3) 마침 시각 찍기 - 반드시 1)번에서 넘어온 현재의 key값이 있을 경우만 실행한다.
		 * 
		 * 
		 * 1) DB에 성능LOG에 SC에서의 시작 시각을 남기는 부분 - 시작부분이 완료되면 반드시 현재의 SEQUENCE를 마칠때까지 넘겨야 한다.
		 * <주> param_map으로 담는 인자값들은 작업에 따라 다르니 그때마다 각각 설정해야한다.
		 */		
		String curr_seq = null;
//		try {//2009-03-12
//
///*			
//			HashMap param_map = new HashMap();
//			param_map.put("ofc_cd",e.getSignOnUserAccount().getOfc_cd());
//			param_map.put("usr_id",e.getSignOnUserAccount().getUsr_id());
//			param_map.put("jb_tp_cd",TESCommonBC.PERF_JOB_TYPE_ON_LINE);
//			param_map.put("pgm_url",(pageURL!=null&&!pageURL.equals("")?pageURL.trim():JSPUtil.getNull(event.getEventName())));
//			param_map.put("f_cmd",event.getEventParams().get("f_cmd"));
//			param_map.put("param_val",TESUtil.getParamNotNullValueChkPerfParamSize(((EsdTes0013Event)e).getEventParams()));
//			log.debug("\n\n  ##### SC..beginJobExecutionPerformance  \n\n");
//			curr_seq = beginJobExecutionPerformance(param_map);
//*/
////			TESCommonEvent tESCommonEvent = new TESCommonEvent();
////			
////			tESCommonEvent.getTesCommonVO().setOfcCd(e.getSignOnUserAccount().getOfc_cd());
////			tESCommonEvent.getTesCommonVO().setUsrId(e.getSignOnUserAccount().getUsr_id());
////			tESCommonEvent.getTesCommonVO().setJbTpCd(TESCommonBC.PERF_JOB_TYPE_ON_LINE);
////			tESCommonEvent.getTesCommonVO().setPgmUrl((pageURL!=null&&!pageURL.equals("")?pageURL.trim():JSPUtil.getNull(event.getEventName())));
////			tESCommonEvent.getTesCommonVO().setFCmd(event.getFormCommand().toString());
////			tESCommonEvent.getTesCommonVO().setParamVal(TESUtil.getParamNotNullValueChkPerfParamSize(((EsdTes0013Event)e).getEventParams()));
////			curr_seq = beginJobExecutionPerformance(tESCommonEvent.getTesJbExePerfLogVO());
//			
//			String pageURL = event.getPageURL();
//			TesJbExePerfLogVO tesJbExePerfLogVO = new TesJbExePerfLogVO();
//			tesJbExePerfLogVO.setInvOfcCd( e.getSignOnUserAccount().getOfc_cd() );
//			tesJbExePerfLogVO.setExeUsrId( e.getSignOnUserAccount().getUsr_id() );
//			tesJbExePerfLogVO.setJbTpCd( TESCommonBC.PERF_JOB_TYPE_ON_LINE );
//			tesJbExePerfLogVO.setPgmUrl( (pageURL!=null&&!pageURL.equals("")?pageURL.trim():JSPUtil.getNull(event.getEventName())) );			
//			tesJbExePerfLogVO.setFuncDivCd( String.valueOf(event.getFormCommand().getCommand()) );
//			tesJbExePerfLogVO.setJbParaCtnt( event.getPerfParams() );
//			curr_seq = beginJobExecutionPerformance( tesJbExePerfLogVO );
//			
//		} catch (Exception ex){
//			//본 업무에 영향을 안주기 위해 Exception을 던지지 않는다.
//			log.error(ex.getMessage());
//			
//			if (false){
//				throw new EventException(ex.getMessage());
//			}
//		}
		
		curr_seq = searchCurrSeq(e);
		
		try {
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchTerminalInvoiceSummary(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			/**
			 * 2) DB에 성능LOG에 SC에서의 오류 발생 시각을 남기는 부분
			 */			
			errorJobExecutionPerformance(curr_seq);
//			errorJobExecutionPerformance(currSeq, de.toString());	// Error Remark					
			throw new EventException(de.getMessage());
		}

		/**
		 * 3) DB에 성능LOG에 SC에서의 마침 시각을 남기는 부분
		 */ 
		endJobExecutionPerformance(curr_seq);
		
		return eventResponse;
	}

//	private EventResponse searchTerminalInvoiceSummary(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
//		EsdTes0013Event event = (EsdTes0013Event)e;
//
//		try{
//			List<searchTerminalInvoiceSummaryVO> list = command.searchTerminalInvoiceSummary(event.getsearchTerminalInvoiceSummaryVO());
//			eventResponse.setRsVoList(list);
//		}catch(EventException ex){
//			throw ex;
//		}catch(Exception ex){
//			throw new EventException(ex.getMessage(), ex);
//		}		
//		return eventResponse;
//	}
	
	/**
	 * Terminal Invoice 조회화면 - Summary
	 * @author kimjinjoo
	 */

	/**
	 * 조회 이벤트 처리<br>
	 * marineterminalinvoicemanage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTerminalExpenseSummary(Event e) throws EventException {
		log.debug("*******ServiceProviderInvoiceManageSC : searchTerminalExpenseSummary $$$********\n");
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0014Event event = (EsdTes0014Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		/**
		 * 2009-03-11 (2009-04-27 : 날짜 주석 추가 및 수정)
		 * # DB에 성능LOG에 SC에서의 시작 시각을 남기는 부분은 크게 3부분으로 나뉜다. 각가가 transaction을 분리하여 혹 문제가 발생하여도 기존 작업에 영향이 없도록 한다.
		 * 1) 시작 시각 찍기 - key가 되는 curr_seq를 생성하여 마침까지 넘겨야 한다. 한 SC의 작업에서는 하나의 sequence가 바람직하다.
		 * 2) 오류 시각 찍기 - 반드시 1)번에서 넘어온 현재의 key값이 있을 경우만 실행한다.
		 * 3) 마침 시각 찍기 - 반드시 1)번에서 넘어온 현재의 key값이 있을 경우만 실행한다.
		 * 
		 * 
		 * 1) DB에 성능LOG에 SC에서의 시작 시각을 남기는 부분 - 시작부분이 완료되면 반드시 현재의 SEQUENCE를 마칠때까지 넘겨야 한다.
		 * <주> param_map으로 담는 인자값들은 작업에 따라 다르니 그때마다 각각 설정해야한다.
		 */		
		String curr_seq = null;
		try {//2009-03-12

//			HashMap param_map = new HashMap();
//			param_map.put("ofc_cd",e.getSignOnUserAccount().getOfc_cd());
//			param_map.put("usr_id",e.getSignOnUserAccount().getUsr_id());
//			param_map.put("jb_tp_cd",TESCommonBC.PERF_JOB_TYPE_ON_LINE);
//			param_map.put("pgm_url",(pageURL!=null&&!pageURL.equals("")?pageURL.trim():JSPUtil.getNull(event.getEventName())));
//			param_map.put("f_cmd",event.getParam_map().get("f_cmd"));
//			param_map.put("param_val",TESUtil.getParamNotNullValueChkPerfParamSize(((EsdTes0014Event)e).getParam_map()));
//			log.debug("\n\n  ##### SC..beginJobExecutionPerformance  \n\n");
//			curr_seq = beginJobExecutionPerformance(param_map);
//		
//			TESCommonEvent tESCommonEvent = new TESCommonEvent();
//			
//			//TesCommonVO tesCommonVO = new TesCommonVO();
//			tESCommonEvent.getTesCommonVO().setOfcCd(e.getSignOnUserAccount().getOfc_cd());
//			tESCommonEvent.getTesCommonVO().setUsrId(e.getSignOnUserAccount().getUsr_id());
//			tESCommonEvent.getTesCommonVO().setJbTpCd(TESCommonBC.PERF_JOB_TYPE_ON_LINE);
//			tESCommonEvent.getTesCommonVO().setPgmUrl((pageURL!=null&&!pageURL.equals("")?pageURL.trim():JSPUtil.getNull(event.getEventName())));
//			tESCommonEvent.getTesCommonVO().setFCmd(event.getFormCommand().toString());
//			tESCommonEvent.getTesCommonVO().setParamVal(TESUtil.getParamNotNullValueChkPerfParamSize(((EsdTes0013Event)e).getEventParams()));
//			curr_seq = beginJobExecutionPerformance(tESCommonEvent.getTesJbExePerfLogVO());
			
			String pageURL = event.getPageURL();
			TesJbExePerfLogVO tesJbExePerfLogVO = new TesJbExePerfLogVO();
			tesJbExePerfLogVO.setInvOfcCd( e.getSignOnUserAccount().getOfc_cd() );
			tesJbExePerfLogVO.setExeUsrId( e.getSignOnUserAccount().getUsr_id() );
			tesJbExePerfLogVO.setJbTpCd( TESCommonBC.PERF_JOB_TYPE_ON_LINE );
			tesJbExePerfLogVO.setPgmUrl( (pageURL!=null&&!pageURL.equals("")?pageURL.trim():JSPUtil.getNull(event.getEventName())) );			
			tesJbExePerfLogVO.setFuncDivCd( String.valueOf(event.getFormCommand().getCommand()) );
			tesJbExePerfLogVO.setJbParaCtnt( event.getPerfParams() );
			curr_seq = beginJobExecutionPerformance( tesJbExePerfLogVO );
			
			
		} catch (Exception ex){
			//본 업무에 영향을 안주기 위해 Exception을 던지지 않는다.
			log.error(ex.getMessage());
			throw new EventException(ex.getMessage());
		}

		try {
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchTerminalExpenseSummary(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			/**
			 * 2) DB에 성능LOG에 SC에서의 오류 발생 시각을 남기는 부분
			 */			
			errorJobExecutionPerformance(curr_seq);					
//			errorJobExecutionPerformance(currSeq, de.toString());	// Error Remark					
			throw new EventException(de.getMessage());
		}
		
		/**
		 * 3) DB에 성능LOG에 SC에서의 마침 시각을 남기는 부분
		 */ 
		endJobExecutionPerformance(curr_seq);
		
		return eventResponse;
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * marineterminalinvoicemanage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTOR(Event e) throws EventException {

		log.debug("*******ServiceProviderInvoiceManageSC : searchTOR********\n");
		// PDTO(Data Transfer Object including Parameters)
		EsdTes9500Event event = (EsdTes9500Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchTOR(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * marineterminalinvoicemanage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeHierarchy(Event e) throws EventException {

		log.debug("*******ServiceProviderInvoiceManageSC : searchOfficeHierarchy********\n");
		// PDTO(Data Transfer Object including Parameters)
		EsdTes9300Event event = (EsdTes9300Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchOfficeHierarchy(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	 /**
	 * 조회 이벤트 처리<br>
	 * marineterminalinvoicemanage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSubOffice(Event e) throws EventException {

		log.debug("*******ServiceProviderInvoiceManageSC : searchSubOffice********\n");
		// PDTO(Data Transfer Object including Parameters)
		EsdTes9300Event event = (EsdTes9300Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchSubOffice(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	
	 /**
	 * 변경 이벤트 처리<br>  J PARK
	 * MR Invoice 입력시 FIO 조건 CNTR verification 결과 보완  by J PARK  2011-0725
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyContainerFromCoToDC(Event e) throws EventException {

		log.debug("*******ServiceProviderInvoiceManageSC : modifyContainerFromCoToDC********\n");
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0001Event event = (EsdTes0001Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    modifyContainerFromCoToDC() ============");

			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.modifyContainerFromCoToDC(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}
	 /**
	 * 조회 이벤트 처리<br>
	 * marineterminalinvoicemanage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTerminalExpenseVolumeSummary(Event e) throws EventException {

		log.debug("*******ServiceProviderInvoiceManageSC : searchTerminalExpenseVolumeSummary********\n");
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0014Event event = (EsdTes0014Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		/**
		 * 2009-03-11 (2009-04-27 : 날짜 주석 추가 및 수정)
		 * # DB에 성능LOG에 SC에서의 시작 시각을 남기는 부분은 크게 3부분으로 나뉜다. 각가가 transaction을 분리하여 혹 문제가 발생하여도 기존 작업에 영향이 없도록 한다.
		 * 1) 시작 시각 찍기 - key가 되는 curr_seq를 생성하여 마침까지 넘겨야 한다. 한 SC의 작업에서는 하나의 sequence가 바람직하다.
		 * 2) 오류 시각 찍기 - 반드시 1)번에서 넘어온 현재의 key값이 있을 경우만 실행한다.
		 * 3) 마침 시각 찍기 - 반드시 1)번에서 넘어온 현재의 key값이 있을 경우만 실행한다.
		 * 
		 * 
		 * 1) DB에 성능LOG에 SC에서의 시작 시각을 남기는 부분 - 시작부분이 완료되면 반드시 현재의 SEQUENCE를 마칠때까지 넘겨야 한다.
		 * <주> param_map으로 담는 인자값들은 작업에 따라 다르니 그때마다 각각 설정해야한다.
		 */		
		String curr_seq = null;
//		try {//2009-03-12
//
////				HashMap param_map = new HashMap();
////				param_map.put("ofc_cd",e.getSignOnUserAccount().getOfc_cd());
////				param_map.put("usr_id",e.getSignOnUserAccount().getUsr_id());
////				param_map.put("jb_tp_cd",TESCommonBC.PERF_JOB_TYPE_ON_LINE);
////				param_map.put("pgm_url",(pageURL!=null&&!pageURL.equals("")?pageURL.trim():JSPUtil.getNull(event.getEventName())));
////				param_map.put("f_cmd",event.getParam_map().get("f_cmd"));
////				param_map.put("param_val",TESUtil.getParamNotNullValueChkPerfParamSize(((EsdTes0014Event)e).getParam_map()));			
////				log.debug("\n\n  ##### SC..beginJobExecutionPerformance  \n\n");
////				curr_seq = beginJobExecutionPerformance(param_map);
//			
////				TESCommonEvent tESCommonEvent = new TESCommonEvent();
////				
////				//TesCommonVO tesCommonVO = new TesCommonVO();
////				tESCommonEvent.getTesCommonVO().setOfcCd(e.getSignOnUserAccount().getOfc_cd());
////				tESCommonEvent.getTesCommonVO().setUsrId(e.getSignOnUserAccount().getUsr_id());
////				tESCommonEvent.getTesCommonVO().setJbTpCd(TESCommonBC.PERF_JOB_TYPE_ON_LINE);
////				tESCommonEvent.getTesCommonVO().setPgmUrl((pageURL!=null&&!pageURL.equals("")?pageURL.trim():JSPUtil.getNull(event.getEventName())));
////				tESCommonEvent.getTesCommonVO().setFCmd(event.getFormCommand().toString());
////				tESCommonEvent.getTesCommonVO().setParamVal(TESUtil.getParamNotNullValueChkPerfParamSize(((EsdTes0013Event)e).getEventParams()));
////				curr_seq = beginJobExecutionPerformance(tESCommonEvent.getTesJbExePerfLogVO());
//			
//			String pageURL = event.getPageURL();
//			TesJbExePerfLogVO tesJbExePerfLogVO = new TesJbExePerfLogVO();
//			tesJbExePerfLogVO.setInvOfcCd( e.getSignOnUserAccount().getOfc_cd() );
//			tesJbExePerfLogVO.setExeUsrId( e.getSignOnUserAccount().getUsr_id() );
//			tesJbExePerfLogVO.setJbTpCd( TESCommonBC.PERF_JOB_TYPE_ON_LINE );
//			tesJbExePerfLogVO.setPgmUrl( (pageURL!=null&&!pageURL.equals("")?pageURL.trim():JSPUtil.getNull(event.getEventName())) );			
//			tesJbExePerfLogVO.setFuncDivCd( String.valueOf(event.getFormCommand().getCommand()) );
//			tesJbExePerfLogVO.setJbParaCtnt( event.getPerfParams() );
//			curr_seq = beginJobExecutionPerformance( tesJbExePerfLogVO );				
//			
//		} catch (Exception ex){
//			//본 업무에 영향을 안주기 위해 Exception을 던지지 않는다.
//			log.error(ex.getMessage());
//			
//			if (false){
//				throw new EventException(ex.getMessage());
//			}
//		}
		
		curr_seq = searchCurrSeq(e);
	
		try {
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchTerminalExpenseVolumeSummary(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			/**
			 * 2) DB에 성능LOG에 SC에서의 오류 발생 시각을 남기는 부분
			 */			
			errorJobExecutionPerformance(curr_seq);
//			errorJobExecutionPerformance(currSeq, de.toString());	// Error Remark					
			throw new EventException(de.getMessage());
		}

		/**
		 * 3) DB에 성능LOG에 SC에서의 마침 시각을 남기는 부분
		 */ 
		endJobExecutionPerformance(curr_seq);
		
		return eventResponse;
	}



	/**
	 * 수정 이벤트 처리<br>
	 * marineterminalinvoicemanage의 event에 대한 특정 리스트 수정 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyTerminalInvoiceConfirm(Event e)throws EventException{
		log.debug("*******ServiceProviderInvoiceManageSC : modifyTerminalInvoiceConfirm********\n");
//		 PDTO(Data Transfer Object including Parameters)
		EsdTes0013Event event = (EsdTes0013Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.modifyTerminalInvoiceConfirm(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}





	/**
	 * 수정 이벤트 처리<br>
	 * marineterminalinvoicemanage의 event에 대한 특정 리스트 수정 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */

	private EventResponse removeTerminalInvoice(Event e)throws EventException{
		log.debug("*******ServiceProviderInvoiceManageSC : RemoveTerminalInvoice********\n");
//		 PDTO(Data Transfer Object including Parameters)
		EsdTes0013Event	event			= (EsdTes0013Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse	eventResponse	= null;

		try {
			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.removeTerminalInvoice(event);
log.info("\n\n [SC][removeTerminalInvoice][] >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + eventResponse.toString() );			
			
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}



	/**
	 * EDI Invoice 삭제 처리<br>
	 *
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */

	private EventResponse removeTerminalEDIInvoice(Event e)throws EventException{
		log.debug("*******ServiceProviderInvoiceManageSC : removeTerminalEDIInvoice********\n");
		
		EsdTes0013Event event			= (EsdTes0013Event)e;
		EventResponse	eventResponse	= null;

		try {
			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.removeTerminalEDIInvoice(event);
log.info("\n\n [SC][removeTerminalEDIInvoice][] >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + eventResponse.toString() );			
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
//		return null;
	}

	/**
	 * EDI Invoice Validation TEST<br>
	 *
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	private EventResponse convertEDIInvoice2TMLInvoice(Event e)throws EventException {
		log.debug(e.toString());
		log.debug("*******ServiceProviderInvoiceManageSC : convertEDIInvoice2TMLInvoice xx********\n");

		EsdTes0013Event event = (EsdTes0013Event)e;
		EventResponse eventResponse = null; //new GeneralEventResponse();
		TesEdiSoHdrVO tesEdiSoHdrVO = null;
		String chkVndrYN = null;
		TESeBillingEvent te  = null;

		try {
			tesEdiSoHdrVO = event.getTesEdiSoHdrVO();
			if (tesEdiSoHdrVO!=null){
				tesEdiSoHdrVO.setCreUsrId(event.getSignOnUserAccount().getUsr_id());
				tesEdiSoHdrVO.setLoclCreDt(event.getSignOnUserAccount().getOfc_cd());
				if (tesEdiSoHdrVO.getSndrId()!=null && !tesEdiSoHdrVO.getSndrId().trim().equals("")){
					log.error("\n new conv "+JSPUtil.getNull(tesEdiSoHdrVO.getVndrSeq())+"|"+JSPUtil.getNull(tesEdiSoHdrVO.getInvNo())+"<<<< \n");
					te = new TESeBillingEvent();
					te.setTesEdiSoHdrVO(tesEdiSoHdrVO);
					if (te!=null){
						chkVndrYN = new TESeBillingCommonBCImpl().checkValidEdiVndrSeq(te);
					} else {
						log.error("\n Invalid TESCommonEvent Exception!!! \n ");
						throw new EventException("Invalid TESCommonEvent Exception!!!");
					}
					log.debug("\n chkVndrYN:"+JSPUtil.getNull(chkVndrYN)+"<<<< \n");
					if (chkVndrYN!=null){
						if (chkVndrYN.trim().equals("Y")){
							// 신형(2012-07 기준)							
							begin();
							eventResponse = new TESeBillingCommonBCImpl().convertEDIInvoice2TMLInvoice(event);
							commit();
						} else {
							log.error("\n Unavailable VNDR found Exception!!! \n");
							throw new EventException("\n Unavailable VNDR found Exception!!! \n");
						}
					} else {
						log.error("\n Invalid VNDR Check Flag Exception!!! \n ");
						throw new EventException("Invalid VNDR Check flag Exception!!!");
					}
				} else {
					// 구형
					log.error("\n old conv "+JSPUtil.getNull(tesEdiSoHdrVO.getVndrSeq())+"|"+JSPUtil.getNull(tesEdiSoHdrVO.getInvNo())+"<<<< \n");
					begin();
					eventResponse = new TESInvoiceCommonBCImpl().convertEDIInvoice2TMLInvoice(event);
					commit();
				}
			} else {
				log.error("\n Invalid EDI Invoice Info Exception!!! \n ");
				throw new EventException("Invalid EDI Invoice Info Exception!!!");
			}
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());		
		}
		return eventResponse;
	}


	/**
	 * MarineTerminal ContainerList 조회화면
	 * UI-ESD-TES-0017 관련 함수 시작
	 * @author kimjinjoo
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTerminalInvoiceBasicInfo2(Event e) throws EventException{
		if(log.isDebugEnabled()) log.debug("\n\nServiceProvider Invoice ManageSC :::::::: searchTerminalInvoiceBasicInfo2\n");

		EsdTes0017Event event = (EsdTes0017Event)e;
		EventResponse eventResponse = null;

		try{
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchTerminalInvoiceBasicInfo2(event);
		}catch(EventException de){
			log.error("err" + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTerminalContainerList2(Event e) throws EventException{
		if(log.isDebugEnabled()) log.debug("\n\nServiceProvider Invoice ManageSC :::::::: searchTerminalContainerList2\n");
		EsdTes0017Event event = (EsdTes0017Event)e;
		//사용자의 요청결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try{
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchTerminalContainerList2(event);
		}catch(EventException de){
			log.error("err" + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTerminalInvoiceBasicInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0001Event event = (EsdTes0001Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    searchTerminalInvoiceBasicInfo() ============");
		try {
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchTerminalInvoiceBasicInfo(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage의 event에 대한 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMarineTerminalInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0001Event event = (EsdTes0001Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    searchMarineTerminalInvoice() ============");
		try {
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchMarineTerminalInvoice(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	 /**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage의 event에 대한 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMarineTerminalCNTRList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0001Event event = (EsdTes0001Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    searchMarineTerminalInvoice() ============");
		try {
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchMarineTerminalCNTRList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage의 event에 대한 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMarineTerminalInvoiceCNTRList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0001Event event = (EsdTes0001Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    searchMarineTerminalInvoiceCNTRList() ============");
		try {
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchMarineTerminalInvoiceCNTRList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}


	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage의 event에 대한 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMarineTerminalInvoiceCosts(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0001Event event = (EsdTes0001Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    searchMarineTerminalInvoiceCosts() ============");
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchMarineTerminalInvoiceCosts(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}


	/**
	 * TerminalInvoiceCalculationList 조회 이벤트 처리<br>
	 * ESD_TES_0001 에 대한  TerminalInvoiceCalculationList 조회 이벤트 처리<br>
	 *
	 * @param e EsdTes0001Event
	 * @return EventResponse ESD_TES_001EventResponse
	 * @exception EventException
	 */
	public EventResponse calculateTerminalInvoiceCost(Event e) throws EventException {
		EventResponse 	eventResponse 	= null;
		EsdTes0001Event event 			= (EsdTes0001Event)e;

		try {
			if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    calculateTerminalInvoiceCost()");

			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.calculateTerminalInvoiceCost(event);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}




	/**
	 * ATB DATE 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 ATB DATE 조회 이벤트 처리<br>
	 *
	 * @param e EsdTes001Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceATBDt(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    searchTerminalInvoiceATBDt() ============");

			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchTerminalInvoiceATBDt(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * Revised Container Division 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 Revised Container Division조회 이벤트 처리<br>
	 *
	 * @param e EsdTes001Event
	 * @return eventResponse  ESD_TES_001EventResponse
	 * @exception EventException
	 */
	public EventResponse searchManualRvisDivision(Event e) throws EventException {
		EventResponse 	eventResponse 	= null;
//		EsdTes0001Event event			=(EsdTes0001Event)e;
		
		try {
			if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    searchManualRvisDivision()");
			
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchManualRvisDivision(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}


	/**
	 * Accumulate Vol 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 Accumulate Vol 조회 이벤트 처리<br>
	 *
	 * @param e EsdTes001Event
	 * @return eventResponse  ESD_TES_001EventResponse
	 * @exception EventException
	 */

	public EventResponse searchAccumulatedVolume(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    searchAccumulatedVolume()");
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchAccumulatedVolume(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * 추가 이벤트 처리<br>
	 * MarineTerminalInvoiceManage의 event에 대한 추가 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	private EventResponse createTerminalInvoiceBasicInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0001Event event = (EsdTes0001Event)e;

		try {
			if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    createTerminalInvoiceBasicInfo() ============");
			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			command.createTerminalInvoiceBasicInfo(event);
			//VVD Creation 들어갈 자리..
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchTerminalInvoiceBasicInfo(e);
	}


	/**
	 * 수정 이벤트 처리<br>
	 * MarineTerminalInvoiceManage의 event에 대한 수정 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyTerminalInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0001Event event = (EsdTes0001Event)e;

		try {
			if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    modifyTerminalInvoice() ============");

			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			command.modifyTerminalInvoice(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return this.searchTerminalInvoiceBasicInfo(e);
	}


	/**
	 * 수정 이벤트 처리<br>
	 * MarineTerminalInvoiceManage의 event에 대한 수정 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyN3rdPartyAmount(Event e) throws EventException {
		EventResponse eventResponse = null;
		EsdTes0001Event event = (EsdTes0001Event)e;

		try {
			if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    modifyN3rdPartyAmount() ============");

			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.modifyN3rdPartyAmount(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * 수정 이벤트 처리<br>
	 * MarineTerminalInvoiceManage의 event에 대한 수정 이벤트 처리<br>
	 * VVD 누락되는 현상 방지 위해 2007.09.27 추가.
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmMarineTerminalInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0001Event event = (EsdTes0001Event)e;
				
		try {
			if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    confirmMarineTerminalInvoice() ============");
		
			MarineTerminalInvoiceManageBC 	command 	= new MarineTerminalInvoiceManageBCImpl();
			TESInvoiceCommonBC		    commandCom 		= new TESInvoiceCommonBCImpl();

			begin();
//			command.searchMgsetCount(e); //고객요청으로 잠시만 주석처리함
			
			//2010.11.03 장병용 부장님 요청  inv에서 cost code 별 auto 유무 체크로직 추가
			String ofc_cd = event.getSignOnUserAccount().getOfc_cd();
			if(!ofc_cd.equals("SELTBB")){	//2015-08-03 그룹사 조직 코드 변경 (SELTOB -> SELTBB)
				commandCom.checkInvCalcCostCD(event.getTesTmlSoHdrVO());	
			}
			
			command.multiTerminalInvoiceVVD(e);
			command.checkMissingVVD(e);
			command.multiTerminalInvoiceDetail(e);
			command.modifyTerminalInvoice(e);
			
			//[CHM-201534788]GW Agmt Link 기준 변경 (Save->Confirm)	2015-03-24
			//[CHM-201640117]유효 AGMT 판단 Date와 Invoice Confirm시 가져오는 GW AGMT date 일치 
			String fromDate = event.getTesCommonVo().getAtbDt();
			String toDate = event.getTesCommonVo().getAtbDt();
			commandCom.updateInvoiceDetailAgmt(event.getTesTmlSoHdrVO(), fromDate, toDate);
			
			commit();
			
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage(), ex);
		}
		
		return this.searchTerminalInvoiceBasicInfo(e);
	}


	/**
	 * 수정 이벤트 처리<br>
	 * MarineTerminalInvoiceManage의 event에 대한 수정 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	private EventResponse rejectLiftTerminalInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0001Event event = (EsdTes0001Event)e;

		try {
			if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    rejectLiftTerminalInvoice() ============");
			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			command.rejectLiftTerminalInvoice(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return this.searchTerminalInvoiceBasicInfo(e);
	}


	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage의 event에 대한 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	public EventResponse multiTerminalInvoiceContainerList(Event e) throws EventException {
		try {
			if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    multiTerminalInvoiceContainerList()");

			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			command.multiTerminalInvoiceVVD(e);
			command.checkMissingVVD(e);
			command.multiTerminalInvoiceContainerList(e);

			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchMarineTerminalInvoiceCNTRList(e);
	}


	/**
	 * 멀티 이벤트 처리<br>
	 * MarineTerminalInvoiceManage의 event에 대한 멀티 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	public EventResponse multiTerminalInvoiceDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체

		try {
			if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    multiTerminalInvoiceDetail()");
			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			command.multiTerminalInvoiceVVD(e);
			command.checkMissingVVD(e);
			command.multiTerminalInvoiceDetail(e);
			commit();

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchMarineTerminalInvoiceCosts(e);
	}


	/**
	 * 삭제 이벤트 처리<br>
	 * MarineTerminalInvoiceManage의 event에 대한 삭제 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	public EventResponse removeTerminalInvoiceContainerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		try {
			if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    removeTerminalInvoiceContainerList()");
			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.removeTerminalInvoiceContainerList(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * 삭제 이벤트 처리<br>
	 * MarineTerminalInvoiceManage의 event에 대한 삭제 이벤트 처리<br>
	 * removeTerminalInvoiceContainerList와의 차이점 : VVD List는 삭제하지 않는다.
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	public EventResponse removeTerminalInvoiceContainerList2(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		try {
			if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    removeTerminalInvoiceContainerList2()");
			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.removeTerminalInvoiceContainerList2(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}


	/**
	 * 삭제 이벤트 처리<br>
	 * MarineTerminalInvoiceManage의 event에 대한 삭제 이벤트 처리<br>
	 * TES_TML_SO_DTL, TES_TML_SO_RVIS_LIST, TES_N3RD_PTY_IF, TES_TML_SO_BB_DTL 삭제
	 *
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	public EventResponse removeTerminalInvoiceCosts(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체

		try {
			if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    removeTerminalInvoiceCosts()");
			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			command.removeTerminalInvoiceCosts(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchMarineTerminalInvoiceCosts(e);
	}



	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage의 event에 대한 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	public EventResponse updateContainerListRvisFlg(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    updateContainerListRvisFlg()");
			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.updateContainerListRvisFlg(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}
	
	/**
	 * Terminal invoice의 manual rvis.vol 수정 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse updateContainerListRvisFlgManual(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			log.debug("\n ServiceProviderInvoiceManageSC - updateContainerListRvisFlgManual()");
			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.updateContainerListRvisFlgManual(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * MarineTerminalInvoiceManage의 event에 대한 멀티 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	public EventResponse reVerifyTerminalInvoiceContainerList(Event e) throws EventException {
		EsdTes0001Event event = (EsdTes0001Event)e;
		EventResponse eventResponse = null;
		MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();

		if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    reVerifyTerminalInvoiceContainerList()");

		try {
			// 무조건 임시 TABLE 지우기1
			log.debug("\n 무조건 임시 TABLE 지우기1 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP2(event);
			// 임시 TABLE에 넣고
			log.debug("\n 임시 TABLE에 넣고 ------------------------  \n");
			command.createTES_FILE_IMP_TMPforReverify(event);
			// CNTR List 삭제하고
			log.debug("\n CNTR List 삭제하고 ------------------------  \n");
			command.removeTerminalInvoiceContainerList2(event);
			// Verify
			log.debug("\n Verify : Imported File ------------------------  \n");
			eventResponse = command.reVerifyTerminalInvoiceContainerList(event);

			event.setRowSet(eventResponse.getRs());

			// CNTR_LIST에 넣고
			log.debug("\n CNTR_LIST에 넣고 ------------------------  \n");
			begin();
			command.createTerminalInvoiceContainerList2(event);
			commit();
			
			// CHM-201642965 CNTR List Upload시 Time-Out로직 분리 - 2016-08-16
			DBRowSet dbRowSet = eventResponse.getRs();
			if ( dbRowSet != null ) {
				if ( dbRowSet.first() ) {
					event.getTesTmlSoCntrListVO().setVslCd(dbRowSet.getString("vsl_cd"));
					event.getTesTmlSoCntrListVO().setDscrIndCd(dbRowSet.getString("dscr_ind_cd"));
					event.getTesTmlSoCntrListVO().setCntrStyCd(dbRowSet.getString("cntr_sty_cd"));
			
			 		// CNTC 항차이고 Verify 결과가 NH인 경우 BKG No. 를 조회후 UPDATE.
					List<TesTmlSoCntrListVO> updVoList = command.searchCntcBkgNoContainerList(event.getTesTmlSoCntrListVO());
					if ( updVoList != null && updVoList.size() > 0 ) {
						begin();
						command.updateCntcBkgNoContainerList(updVoList);
						commit();
					}
				}
			}

		} catch(EventException de) {
			log.debug("\n EventException rollback ------------------------  \n");
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage(), ex);
		} finally {
//			무조건 임시 TABLE 지우기
			log.debug("\n 무조건 임시 TABLE 지우기2 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP2(event);
		}
		return searchMarineTerminalCNTRList(e);
	}





	/******************************************* EsdTes901Event : File Import 시작 *******************************************/
	/**
	 * FinalBayFlanSource HJSListOnly Search이벤트 처리<br>
	 * CotainerList PopUp화면에 대한 FinalBayFlanSource HJSListOnly Search이벤트 처리<br>
	 *
	 * @param e EsdTes9010Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	public EventResponse searchHJSListOnlyList(Event e) throws EventException {
		EsdTes9010Event event = (EsdTes9010Event)e;
		EventResponse eventResponse = null;
		MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();

		if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    searchHJSListOnlyList()");

		try {
			//무조건 임시 TABLE 지우기1
			log.debug("\n 무조건 임시 TABLE 지우기1 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP(event);
			//임시 TABLE에 넣고
			log.debug("\n 임시 TABLE에 넣고 ------------------------  \n");
			command.createTES_FILE_IMP_TMP(event);
			//Verify
			log.debug("\n Verify : HJS LIST ONLY ------------------------  \n");
			eventResponse = command.searchHJSListOnlyList(event);
			event.setRowSet(eventResponse.getRs());

			//CNTR_LIST에 넣고
			log.debug("\n CNTR_LIST에 넣고 ------------------------  \n");
			begin();
			command.createTerminalInvoiceVVD(event);
			/**
			 * 	ENIS에서 addBatch를 하지 않고 excuteBatch를 실행해서 실제론 돌지 않았음.(JJ만듬)		
			 */
//			command.deleteTerminalInvoiceContainerList(event); //Verify시 CNTR목록을 넣기 전에 한번만 주운다.
			command.createTerminalInvoiceContainerList(event);
			commit();
			
		} catch(EventException de) {
			log.debug("\n EventException rollback ------------------------  \n");
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} finally {
			//무조건 임시 TABLE 지우기
			log.debug("\n 무조건 임시 TABLE 지우기2 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP(event);
		}
		return eventResponse;
	}


	/**
	 * FinalBayFlanSource HJSListOnly Search이벤트 처리<br>
	 * CotainerList PopUp화면에 대한 FinalBayFlanSource HJSListOnly Search이벤트 처리<br>
	 *
	 * @param e EsdTes901Event
	 * @return eventResponse  ESD_TES_901EventResponse
	 * @exception EventException
	 */
	public EventResponse checkDigit(Event e) throws EventException {
		EsdTes9010Event event = (EsdTes9010Event)e;
		EventResponse eventResponse = null;
		MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();

		if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    checkDigit()");

		try {
//			무조건 임시 TABLE 지우기1
			log.debug("\n 무조건 임시 TABLE 지우기1 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP(event);
//			임시 TABLE에 넣고
			log.debug("\n 임시 TABLE에 넣고 ------------------------  \n");
			command.createTES_FILE_IMP_TMP(event);
//			checkDigit
			log.debug("\n checkDigit  ------------------------  \n");
			eventResponse = command.searchCNTRNumber(event);
			event.setRowSet(eventResponse.getRs());

//			CNTR_LIST에 업뎃
			log.debug("\n CNTR_LIST에 넣고 ------------------------  \n");
			begin();
			command.updateCNTRNumber(event);
			commit();
			eventResponse = command.searchTES_FILE_IMP_TMP(event);

		}catch(EventException de) {
			log.debug("\n EventException rollback ------------------------  \n");
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}finally {
//			무조건 임시 TABLE 지우기
			log.debug("\n 무조건 임시 TABLE 지우기2 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP(event);
		}
		return eventResponse;
	}


	/**
	 * FinalBayFlanSource HJSListOnly Search이벤트 처리<br>
	 * CotainerList PopUp화면에 대한 FinalBayFlanSource HJSListOnly Search이벤트 처리<br>
	 *
	 * @param e EsdTes901Event
	 * @return eventResponse  ESD_TES_901EventResponse
	 * @exception EventException
	 */
	public EventResponse checkDigit2(Event e) throws EventException {
		log.debug("\n\n SC.checkDigit2 ----------------------------- \n");

		EsdTes0001Event event = (EsdTes0001Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();

		try {
			log.debug("\n checkDigit2  ------------------------  \n");
			
			begin();
			command.updateCNTRNumber2(event.getTesTmlSoHdrVO());
			commit();
			
//			eventResponse = command.searchOffdockCYInvoiceBasicInfo(event);
			
		} catch (EventException de) {
			log.debug("\n EventException rollback ------------------------  \n");
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} 
		
		return eventResponse;
	}

	/**
	 * FinalBayFlanSource HJSListOnly Search이벤트 처리<br>
	 * CotainerList PopUp화면에 대한 FinalBayFlanSource HJSListOnly Search이벤트 처리<br>
	 *
	 * @param e EsdTes901Event
	 * @return eventResponse  ESD_TES_901EventResponse
	 * @exception EventException
	 */
	public EventResponse checkDigitOnDock(Event e) throws EventException {
		log.debug("\n\n SC.checkDigitOnDock ----------------------------- \n");

		EsdTes0064Event event = (EsdTes0064Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();

		try {
			log.debug("\n checkDigitOnDock  ------------------------  \n");
			
			begin();
			command.updateCNTRNumber2(event.getTesTmlSoHdrVO());
			commit();
			
//			eventResponse = command.searchOffdockCYInvoiceBasicInfo(event);
			
		} catch (EventException de) {
			log.debug("\n EventException rollback ------------------------  \n");
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} 
		
		return eventResponse;
	}

	
	/**
	 * 멀티 이벤트 처리<br>
	 * MarineTerminalInvoiceManage의 event에 대한 멀티 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	public EventResponse checkTerminalInvoiceContainerList(Event e) throws EventException {
		// ESD_TES_901EventResponse eventResponse = null;
		EsdTes9010Event event = (EsdTes9010Event)e;
		EventResponse eventResponse = null;
		MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();

		if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    checkTerminalInvoiceContainerList()");

		/**
		 * 2009-03-11 (2009-04-27 : 날짜 주석 추가 및 수정)
		 * # DB에 성능LOG에 SC에서의 시작 시각을 남기는 부분은 크게 3부분으로 나뉜다. 각가가 transaction을 분리하여 혹 문제가 발생하여도 기존 작업에 영향이 없도록 한다.
		 * 1) 시작 시각 찍기 - key가 되는 curr_seq를 생성하여 마침까지 넘겨야 한다. 한 SC의 작업에서는 하나의 sequence가 바람직하다.
		 * 2) 오류 시각 찍기 - 반드시 1)번에서 넘어온 현재의 key값이 있을 경우만 실행한다.
		 * 3) 마침 시각 찍기 - 반드시 1)번에서 넘어온 현재의 key값이 있을 경우만 실행한다.
		 * 
		 * 
		 * 1) DB에 성능LOG에 SC에서의 시작 시각을 남기는 부분 - 시작부분이 완료되면 반드시 현재의 SEQUENCE를 마칠때까지 넘겨야 한다.
		 * <주> param_map으로 담는 인자값들은 작업에 따라 다르니 그때마다 각각 설정해야한다.
		 */		
		String curr_seq = null;
//		try {//2009-03-12
//		
////			HashMap param_map = new HashMap();
////			param_map.put("ofc_cd",e.getSignOnUserAccount().getOfc_cd());
////			param_map.put("usr_id",e.getSignOnUserAccount().getUsr_id());
////			param_map.put("jb_tp_cd",TESCommonBC.PERF_JOB_TYPE_ON_LINE_INVOICE);
////			param_map.put("pgm_url",(pageURL!=null&&!pageURL.equals("")?pageURL.trim():JSPUtil.getNull(event.getEventName())));
////			param_map.put("f_cmd",event.getParams().get("f_cmd"));
////			param_map.put("row_cnt",((EsdTes901Event)e).getTES_TML_SO_CNTR_LISTS()!=null?Integer.toString(((EsdTes901Event)e).getTES_TML_SO_CNTR_LISTS().size()):"");
////			param_map.put("tml_so_ofc_cty_cd",event.getParams().get("tml_so_ofc_cty_cd"));
////			param_map.put("tml_so_seq",event.getParams().get("tml_so_seq"));
////			param_map.put("param_val",TESUtil.getParamNotNullValueChkPerfParamSize(((EsdTes901Event)e).getParams()));
////			log.debug("\n\n  ##### SC..beginJobExecutionPerformance  \n\n");
////			curr_seq = beginJobExecutionPerformance(param_map);	
//
//			String pageURL = event.getPageURL();
//			TesJbExePerfLogVO tesJbExePerfLogVO = new TesJbExePerfLogVO();
//			tesJbExePerfLogVO.setInvOfcCd( e.getSignOnUserAccount().getOfc_cd() );
//			tesJbExePerfLogVO.setExeUsrId( e.getSignOnUserAccount().getUsr_id() );
//			tesJbExePerfLogVO.setJbTpCd( TESCommonBC.PERF_JOB_TYPE_ON_LINE_INVOICE );
//			tesJbExePerfLogVO.setPgmUrl( (pageURL!=null&&!pageURL.equals("")?pageURL.trim():JSPUtil.getNull(event.getEventName())) );			
//			tesJbExePerfLogVO.setFuncDivCd( String.valueOf(event.getFormCommand().getCommand()) );
//			tesJbExePerfLogVO.setExeRowKnt( event.getTesFileImpTmpVOs()!=null?Integer.toString( (event.getTesFileImpTmpVOs()).length ):"" );
//			tesJbExePerfLogVO.setTmlSoOfcCtyCd( event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd() );
//			tesJbExePerfLogVO.setTmlSoSeq( event.getTesTmlSoHdrVO().getTmlSoSeq() );
//			tesJbExePerfLogVO.setJbParaCtnt( event.getPerfParams() );
//			curr_seq = beginJobExecutionPerformance( tesJbExePerfLogVO );	
//			
//			
//		} catch (Exception ex){
//			//본 업무에 영향을 안주기 위해 Exception을 던지지 않는다.
//			log.error(ex.getMessage());
//
//			if (false){
//				throw new EventException(ex.getMessage());
//			}
//		}
		
		curr_seq = searchCurrSeq(e);
		
		try {
			// 무조건 임시 TABLE 지우기1
			log.debug("\n sc 무조건 임시 TABLE 지우기1 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP(event);
			// 임시 TABLE에 넣고
			log.debug("\n sc 임시 TABLE에 넣고 ------------------------  \n");
			command.createTES_FILE_IMP_TMP(event);
			// Verify
			log.debug("\n sc Verify : Imported File ------------------------  \n");
			eventResponse = command.checkTerminalInvoiceContainerList(event);
//			ESD_TES_901EventResponse er = (ESD_TES_901EventResponse)eventResponse;
//			er = (ESD_TES_901EventResponse)eventResponse;
			event.setRowSet(eventResponse.getRs());

			// CNTR_LIST에 넣고
			log.debug("\n sc CNTR_LIST에 넣고 ------------------------  \n");
			begin();
			command.createTerminalInvoiceVVD(event);
			/**
			 * 	ENIS에서 addBatch를 하지 않고 excuteBatch를 실행해서 실제론 돌지 않았음.(JJ만듬)		
			 */
//			command.deleteTerminalInvoiceContainerList(event); //Verify시 CNTR목록을 넣기 전에 한번만 주운다.
			command.createTerminalInvoiceContainerList(event);
			commit();
			
			
			//eventResponse = er;
	 		if(event.getTesCommonVO().getHjsListYn().equals("Y")){
				// Verify
				log.debug("\n sc Verify : SML LIST ONLY ------------------------  \n");
				eventResponse = command.searchHJSListOnlyList(event);
//				er = (ESD_TES_901EventResponse)eventResponse;
				event.setRowSet(eventResponse.getRs());

				// CNTR_LIST에 넣고
				log.debug("\n sc CNTR_LIST에 넣고 ------------------------  \n");
				begin();
				command.createTerminalInvoiceContainerList(event);
				commit();
			}
	 		
	 		// CHM-201642965 CNTR List Upload시 Time-Out로직 분리 - 2016-08-16
			DBRowSet dbRowSet = eventResponse.getRs();
			if ( dbRowSet != null ) {
				if ( dbRowSet.first() ) {
					event.getTesTmlSoCntrListVO().setVslCd(dbRowSet.getString("vsl_cd"));
					event.getTesTmlSoCntrListVO().setDscrIndCd(dbRowSet.getString("dscr_ind_cd"));

					// CNTC 항차이고 Verify 결과가 NH인 경우 BKG No. 를 조회후 UPDATE.
					List<TesTmlSoCntrListVO> updVoList = command.searchCntcBkgNoContainerList(event.getTesTmlSoCntrListVO());
					if ( updVoList != null && updVoList.size() > 0 ) {
						begin();
						command.updateCntcBkgNoContainerList(updVoList);
						commit();
					}
				}
			}
			
		} catch (EventException de) {
			log.debug("\n EventException rollback ------------------------  \n");
			rollback();
			log.error("err " + de.toString(), de);
			/**
			 * 2) DB에 성능LOG에 SC에서의 오류 발생 시각을 남기는 부분
			 */			
			errorJobExecutionPerformance(curr_seq);			
//			errorJobExecutionPerformance(currSeq, de.toString());	// Error Remark					
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage(), ex);
		} finally {
//			무조건 임시 TABLE 지우기
			log.debug("\n 무조건 임시 TABLE 지우기2 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP(event);
		}
		
		/**
		 * 3) DB에 성능LOG에 SC에서의 마침 시각을 남기는 부분
		 */ 
		endJobExecutionPerformance(curr_seq);
		
		return eventResponse;
	}


	/**
	 * EDI로 접수받은 Container List를 조회한다.<br>
	 *
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	public EventResponse searchEDIInvoiceContainerList(Event e) throws EventException {
		log.debug("\n==========ServiceProviderInvoiceManageSC    searchEDIInvoiceContainerList()");

		EventResponse eventResponse = null;
		MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();

		try {
			eventResponse = command.searchEDIInvoiceContainerList(e);
		}catch(EventException de){
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}


	/**
	 * WorkOrder를 입력하여 해당 Container List를 조회한다.<br>
	 *
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	public EventResponse searchContainerListByWorkOrder(Event e) throws EventException {
//		ESD_TES_901EventResponse eventResponse = null;
		
		log.debug("\n========== ServiceProviderInvoiceManageSC    searchContainerListByWorkOrder()");
		EventResponse eventResponse = null;
		EsdTes9010Event event = (EsdTes9010Event)e;
		MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();

		if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    searchContainerListByWorkOrder()");

		try {
			eventResponse = command.searchContainerListByWorkOrder(event);
		}catch(EventException de){
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;

	}
	
	/**
	 * verify 대상용 terminal 가져오기
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse getVrfyTmls(Event e) throws EventException {
		log.debug("\n SC - MarineTerminalInvoiceManageBCImpl.getVrfyTmls() ============");

		EsdTes9010Event event = (EsdTes9010Event)e;
		EventResponse eventResponse = null;
		MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
		
		try {
			eventResponse = command.getVrfyTmls(event);
		} catch(EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch(Exception ee) {
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		}
		return eventResponse;		
	}

	/******************************************* EsdTes903_2Event : Revised Volume Popup 시작 *******************************************/

	/**
	 * Revised Vol List 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 Revised Vol List조회 이벤트 처리<br>
	 *
	 * @param e EsdTes9032Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	public EventResponse searchManualRevisedVolume(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    searchManualRevisedVolume()");
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchManualRevisedVolume(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 2009-08-27 [PJM-200900072] : EDI manual cntr 목록 조회
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchEDIInvoiceManualContainerList(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			log.debug("\n==========ServiceProviderInvoiceManageSC    searchEDIInvoiceManualContainerList()");
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchEDIInvoiceManualContainerList(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Revised Vol List 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 Revised Vol List조회 이벤트 처리<br>
	 *
	 * @param e EsdTes907_2Event
	 * @return eventResponse  ESD_TES_907_2EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMarineTerminalManualRevisedVolume(Event e) throws EventException {
		
		EventResponse eventResponse = null;

		try {
			if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    searchMarineTerminalManualRevisedVolume()");
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchMarineTerminalManualRevisedVolume(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;

	}



	/**
	 * Revised Vol List 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 Revised Vol List조회 이벤트 처리<br>
	 *
	 * @param e EsdTes9032Event
	 * @return eventResponse  EventResponse
	 * @exception EventExceptionfor
	 */
	public EventResponse searchAutoRevisedVolume(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    searchAutoRevisedVolume()");
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchAutoRevisedVolume(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * Revised Vol List 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 Revised Vol List조회 이벤트 처리<br>
	 *
	 * @param e EsdTes907_2Event
	 * @return eventResponse  ESD_TES_907_2EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMarineTerminalAutoRevisedVolume(Event e) throws EventException {
		log.debug("============start sc searchMarineTerminalAutoRevisedVolume =============== ");
		
		EventResponse eventResponse = null;

		try {
			if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    searchMarineTerminalAutoRevisedVolume()");
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchMarineTerminalAutoRevisedVolume(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}



	/******************************************* ESD_TES_9232Event : 3rd Party Popup 시작 *******************************************/


	/**
	 * 3rd Party 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 Revised Vol List조회 이벤트 처리<br>
	 *
	 * @param e EsdTes9232Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAutoTrdPartyVolume(Event e) throws EventException {
		
		EventResponse evnetResponse = null;

		try {
			if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    searchAutoTrdPartyVolume()");
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			evnetResponse = command.searchAutoTrdPartyVolume(e);
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return evnetResponse;
	}

	/**
	 * 3rd Party 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 Revised Vol List조회 이벤트 처리<br>
	 *
	 * @param e EsdTes9232Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	public EventResponse searchManualTrdPartyVolume(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC searchManualTrdPartyVolume()");
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchManualTrdPartyVolume(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}
	
	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiTerminalInvoiceN3rdParyIF2(Event e) throws EventException {
		EventResponse eventResponse = null;

		/**
		 * Terminal Invoice Confirm 처리할때. TPB IF SVXXJO건 분석용 로그추가.(2010-04-27)
		 * # DB에 성능LOG에 SC에서의 시작 시각을 남기는 부분은 크게 3부분으로 나뉜다. 각가가 transaction을 분리하여 혹 문제가 발생하여도 기존 작업에 영향이 없도록 한다.
		 * 1) 시작 시각 찍기 - key가 되는 curr_seq를 생성하여 마침까지 넘겨야 한다. 한 SC의 작업에서는 하나의 sequence가 바람직하다.
		 * 2) 오류 시각 찍기 - 반드시 1)번에서 넘어온 현재의 key값이 있을 경우만 실행한다.
		 * 3) 마침 시각 찍기 - 반드시 1)번에서 넘어온 현재의 key값이 있을 경우만 실행한다.
		 * 
		 * 
		 * 1) DB에 성능LOG에 SC에서의 시작 시각을 남기는 부분 - 시작부분이 완료되면 반드시 현재의 SEQUENCE를 마칠때까지 넘겨야 한다.
		 * <주> param_map으로 담는 인자값들은 작업에 따라 다르니 그때마다 각각 설정해야한다.
		 */		

//		EsdTes9232Event	event		= (EsdTes9232Event)e;
		
//		TesN3rdPtyIfVO[]	tesN3rdPtyIfVOs 	= null;
		String				currSeq				= null;
		
		// TPB IF SVXXJO 누락건 분석위한 로그추가.(2010-04-27)
//		try {
//			tesN3rdPtyIfVOs		= event.getTesN3rdPtyIfVOs();
//			
//			TesJbExePerfLogVO	tesJbExePerfLogVO	= new TesJbExePerfLogVO();
//			StringBuilder		sbuPerfRmk			= new StringBuilder();
//			int					joCnt				= 0;	// SVXXJO 건 
//			int					insFlgCnt			= 0;	// INSERT
//			int					updFlgCnt			= 0;	// UPDATE
//			
//			// SVXXJO 건인지 확인하기 위함.
//			for( int i = 0; tesN3rdPtyIfVOs != null && i < tesN3rdPtyIfVOs.length; i++ ) {
//				if ( "SVXXJO".equals(tesN3rdPtyIfVOs[i].getLgsCostCd() ) ) {
//					joCnt++;
//				}
//				if ( "I".equals(tesN3rdPtyIfVOs[i].getIbflag() ) ) {
//					insFlgCnt++;
//				}
//				if ( "U".equals(tesN3rdPtyIfVOs[i].getIbflag() ) ) {
//					updFlgCnt++;
//				}
//			}
//
//			if ( joCnt > 0 ) {
//				sbuPerfRmk.append("JO ");
//				if ( sbuPerfRmk.length() > 0 ) {
//					if ( insFlgCnt > 0 ) {
//						sbuPerfRmk.append("C");
//					}
//					if ( updFlgCnt > 0 ) {
//						sbuPerfRmk.append("U");
//					}
//				}
//			}
//			
//			// TPB DELETE.
//			String	delIfSeq	= JSPUtil.getNull(event.getMarineTerminalInvoiceCommonVO().getDelIfSeq());
//			if ( delIfSeq.length() > 0 ) {
//				delIfSeq	= delIfSeq.substring( 0, delIfSeq.length() - 1 ); 		//.replaceAll("\\|", ",");
//				String	[]	arrIfSeq	= delIfSeq.split("\\|");
//				
//				sbuPerfRmk.append("D(" + arrIfSeq.length + ")"); // 삭제 건수.
//			}
//
//			tesJbExePerfLogVO.setInvOfcCd		( e.getSignOnUserAccount().getOfc_cd() );
//			tesJbExePerfLogVO.setExeUsrId		( e.getSignOnUserAccount().getUsr_id() );
//			tesJbExePerfLogVO.setJbTpCd			( TESCommonBC.PERF_JOB_TYPE_TPB );
//			tesJbExePerfLogVO.setPgmUrl			( (event.getPageURL() != null && !"".equals(event.getPageURL()) ? event.getPageURL().trim():JSPUtil.getNull( event.getEventName() ) ) );			
//			tesJbExePerfLogVO.setFuncDivCd		( String.valueOf(event.getFormCommand().getCommand()) );
//			tesJbExePerfLogVO.setExeRowKnt		( tesN3rdPtyIfVOs != null ? Integer.toString( tesN3rdPtyIfVOs.length ) : "" );
//			tesJbExePerfLogVO.setTmlSoOfcCtyCd	( event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd() );
//			tesJbExePerfLogVO.setTmlSoSeq		( event.getTesTmlSoHdrVO().getTmlSoSeq() );
//			tesJbExePerfLogVO.setJbParaCtnt		( event.getPerfParams() );
//			tesJbExePerfLogVO.setPerfRmk		( sbuPerfRmk.toString() );
//			
//			currSeq = beginJobExecutionPerformance( tesJbExePerfLogVO );
//		} catch (Exception ex){
//			//본 업무에 영향을 안주기 위해 Exception을 던지지 않는다.
//			log.error(ex.getMessage());
//			if (false){
//				throw new EventException(ex.getMessage());
//			}
//		}
		
		currSeq = searchCurrSeq(e);

		try {
			log.debug("\n ServiceProviderInvoiceManageSC    multiTerminalInvoiceN3rdParyIF2()");
			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.multiTerminalInvoiceN3rdParyIF(e);
//			if ( 1 != 2 ) {
//				throw new EventException("Error Remark TPB IF TEST");
//			}
			commit();
		} catch (EventException de) {
			rollback();
			log.error("\n\n[][][catch] >>>>>>>>>>>>>>> err " + de.toString(), de);
			/**
			 * 2) DB에 성능LOG에 SC에서의 오류 발생 시각을 남기는 부분
			 */	
			
			errorJobExecutionPerformance(currSeq);
//			errorJobExecutionPerformance(currSeq, de.toString());	// Error Remark					

			throw new EventException(de.getMessage());
		} finally {
			/**
			 * 3) DB에 성능LOG에 SC에서의 마침 시각을 남기는 부분
			 */ 
			endJobExecutionPerformance(currSeq);
		}

		return eventResponse;
	}
	
	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiTerminalInvoiceN3rdParyIF(Event e) throws EventException {
		/**
		 * Terminal Invoice Confirm 처리할때. TPB IF SVXXJO건 분석용 로그추가.(2010-04-27)
		 * # DB에 성능LOG에 SC에서의 시작 시각을 남기는 부분은 크게 3부분으로 나뉜다. 각가가 transaction을 분리하여 혹 문제가 발생하여도 기존 작업에 영향이 없도록 한다.
		 * 1) 시작 시각 찍기 - key가 되는 curr_seq를 생성하여 마침까지 넘겨야 한다. 한 SC의 작업에서는 하나의 sequence가 바람직하다.
		 * 2) 오류 시각 찍기 - 반드시 1)번에서 넘어온 현재의 key값이 있을 경우만 실행한다.
		 * 3) 마침 시각 찍기 - 반드시 1)번에서 넘어온 현재의 key값이 있을 경우만 실행한다.
		 * 
		 * 
		 * 1) DB에 성능LOG에 SC에서의 시작 시각을 남기는 부분 - 시작부분이 완료되면 반드시 현재의 SEQUENCE를 마칠때까지 넘겨야 한다.
		 * <주> param_map으로 담는 인자값들은 작업에 따라 다르니 그때마다 각각 설정해야한다.
		 */		
//		EsdTes9231Event		event		= (EsdTes9231Event)e;
		
//		TesN3rdPtyIfVO[]	tesN3rdPtyIfVOs 	= null;
		String				currSeq				= null;
		
		// TPB IF 누락건 분석위한 로그추가.(2010-05-03)
//		try {
//			tesN3rdPtyIfVOs		= event.getTesN3rdPtyIfVOs();
//			
//			TesJbExePerfLogVO	tesJbExePerfLogVO	= new TesJbExePerfLogVO();
//			StringBuilder		sbuPerfRmk			= new StringBuilder();
//			int					insFlgCnt			= 0;	// INSERT
//			int					updFlgCnt			= 0;	// UPDATE
//			
//			// 건인지 확인하기 위함.
//			for( int i = 0; tesN3rdPtyIfVOs != null && i < tesN3rdPtyIfVOs.length; i++ ) {
//				if ( "I".equals(tesN3rdPtyIfVOs[i].getIbflag() ) ) {
//					insFlgCnt++;
//				}
//				if ( "U".equals(tesN3rdPtyIfVOs[i].getIbflag() ) ) {
//					updFlgCnt++;
//				}
//			}
//
//			if ( insFlgCnt > 0 ) {
//				sbuPerfRmk.append("C");
//			}
//			if ( updFlgCnt > 0 ) {
//				sbuPerfRmk.append("U");
//			}
//			
//			// TPB DELETE.
//			String	delIfSeq	= JSPUtil.getNull(event.getOndockRailChargeInvoiceCommonVO().getDelIfSeq());
//			if ( delIfSeq.length() > 0 ) {
//				delIfSeq	= delIfSeq.substring( 0, delIfSeq.length() - 1 ); 		//.replaceAll("\\|", ",");
//				String	[]	arrIfSeq	= delIfSeq.split("\\|");
//				
//				sbuPerfRmk.append("D(" + arrIfSeq.length + ")"); // 삭제 건수.
//			}
//
//			tesJbExePerfLogVO.setInvOfcCd		( e.getSignOnUserAccount().getOfc_cd() );
//			tesJbExePerfLogVO.setExeUsrId		( e.getSignOnUserAccount().getUsr_id() );
//			tesJbExePerfLogVO.setJbTpCd			( TESCommonBC.PERF_JOB_TYPE_TPB );
//			tesJbExePerfLogVO.setPgmUrl			( (event.getPageURL() != null && !"".equals(event.getPageURL()) ? event.getPageURL().trim():JSPUtil.getNull( event.getEventName() ) ) );			
//			tesJbExePerfLogVO.setFuncDivCd		( String.valueOf(event.getFormCommand().getCommand()) );
//			tesJbExePerfLogVO.setExeRowKnt		( tesN3rdPtyIfVOs != null ? Integer.toString( tesN3rdPtyIfVOs.length ) : "" );
//			tesJbExePerfLogVO.setTmlSoOfcCtyCd	( event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd() );
//			tesJbExePerfLogVO.setTmlSoSeq		( event.getTesTmlSoHdrVO().getTmlSoSeq() );
//			tesJbExePerfLogVO.setJbParaCtnt		( event.getPerfParams() );
//			tesJbExePerfLogVO.setPerfRmk		( sbuPerfRmk.toString() );
//			
//			currSeq = beginJobExecutionPerformance( tesJbExePerfLogVO );
//		} catch (Exception ex){
//			//본 업무에 영향을 안주기 위해 Exception을 던지지 않는다.
//			log.error(ex.getMessage());
//			if (false){
//				throw new EventException(ex.getMessage());
//			}
//		}
		
		currSeq = searchCurrSeq(e);

		try {
			begin();
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			command.multiTerminalInvoiceN3rdParyIF(e);
			commit();
			
			//eventResponse = command.searchStorage3rdIFlistByDay(event);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			/**
			 * 2) DB에 성능LOG에 SC에서의 오류 발생 시각을 남기는 부분
			 */			
			errorJobExecutionPerformance(currSeq);
//			errorJobExecutionPerformance(currSeq, de.toString());	// Error Remark					
			throw new EventException(de.getMessage());
		} finally {
			/**
			 * 3) DB에 성능LOG에 SC에서의 마침 시각을 남기는 부분
			 */ 
			endJobExecutionPerformance(currSeq);
		}

		return searchTerminalInvoiceN3ptyAutoCntrList(e);
	}
	
	/**
	 * 3rd Party 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 Revised Vol List조회 이벤트 처리<br>
	 *
	 * @param e EsdTes9252Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMarineTerminalTrdPartyVolume(Event e) throws EventException {
		log.debug("start searchMarineTerminalTrdPartyVolume =======================>");
		
//		EsdTes9252Event event = (EsdTes9252Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    searchMarineTerminalTrdPartyVolume()");
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchMarineTerminalTrdPartyVolume(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}
	/******** JINJOO 끝 *****************************/





	/** parkyeonjin 시작  *********************/
	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage 화면에 대한 조회 이벤트 처리<br>
	 *
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */



	/**
	 * Accumulate Vol List 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 Accumulate Vol List조회 이벤트 처리<br>
	 *
	 * @param e EsdTes922Event
	 * @return eventResponse  ESD_TES_922EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAccumulatedVolumeList(Event e) throws EventException {
		EventResponse eventResponse = null;

		try { 
			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchAccumulatedVolumeList(e);
			if(log.isDebugEnabled())log.debug("==========ServiceProviderInvoiceManageSC    searchAccumulatedVolumeList() commit Before");
			commit();
			if(log.isDebugEnabled())log.debug("==========ServiceProviderInvoiceManageSC    searchAccumulatedVolumeList() commit After");

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * RehandlingVolume List 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 RehandlingVolume List조회 이벤트 처리<br>
	 *
	 * @param e EsdTes919Event
	 * @return eventResponse  ESD_TES_919EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRehandlingVolume(Event e) throws EventException {
		EventResponse eventResponse = null;
		log.debug("==========ServiceProviderInvoiceManageSC    searchRehandlingVolume()");
		
		try {
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchRehandlingVolume(e);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * 2009-08-27 [PJM-200900072] : EDI Manual CNTR 목록 조회
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchEDIInvoiceRHManualContainerList(Event e) throws EventException {
		EventResponse eventResponse = null;
		log.debug("==========ServiceProviderInvoiceManageSC    searchEDIInvoiceRHManualContainerList()");
		
		try {
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchEDIInvoiceRHManualContainerList(e);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}
	
	
	/**
	 * RehandlingVolume List 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 RehandlingVolume List조회 이벤트 처리<br>
	 *
	 * @param e EsdTes9191Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMarineTerminalRehandlingVolume(Event e) throws EventException {
		
		EventResponse eventResponse = null;
		
		if(log.isDebugEnabled())log.debug("========== ServiceProviderInvoiceManageSC    searchMarineTerminalRehandlingVolume() commit Before");
		try {
			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = (EventResponse)command.searchMarineTerminalRehandlingVolume(e);
			commit();

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	
	/**
	 * RehandlingVolume List 저장 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 RehandlingVolume List조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiRehandlingVolume(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			log.debug("\n ServiceProviderInvoiceManageSC    multiRehandlingVolume()");
			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.multiRehandlingVolume(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}


	/*
	 *  Terminal Invoice Part End 이후 이부분까지 복사해서 붙일것.
	 *  author : 박연진
	 */
	/*
	 *  On-Dock Rail Charge Invoice Part Start 이후 이부분부터 복사해서 붙일것.
	 *  author : 박연진
	 */
	/**
	 * 조회 이벤트 처리<br>
	 * OnDockRailChargeInvoiceManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOndockRailChargeBasicInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0064Event event = (EsdTes0064Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		if(log.isDebugEnabled())log.debug("==========ServiceProviderInvoiceManageSC    searchOndockRailChargeBasicInfo() ============");
		try {
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			eventResponse = command.searchOndockRailChargeBasicInfo(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
	 * 추가 이벤트 처리<br>
	 * OnDockRailChargeInvoiceManage의 event에 대한 추가 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	private EventResponse createOndockRailChargeBasicInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0064Event event = (EsdTes0064Event)e;
		if(log.isDebugEnabled())log.debug("==========ServiceProviderInvoiceManageSC    createOndockRailChargeBasicInfo() ============");

		try {
			begin();
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			command.createOndockRailChargeBasicInfo(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return this.searchOndockRailChargeBasicInfo(e);
	}

	/**
	 * 수정 이벤트 처리<br>
	 * OnDockRailChargeInvoiceManage의 event에 대한 수정 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyOndockRailChargeBasicInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0064Event event = (EsdTes0064Event)e;
		if(log.isDebugEnabled())log.debug("==========ServiceProviderInvoiceManageSC    modifyOndockRailChargeBasicInfo() ============");

		try {
			begin();
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			TESInvoiceCommonBC		    commandCom 		= new TESInvoiceCommonBCImpl();
			
			//2010.11.03 장병용 부장님 요청  inv에서 cost code 별 auto 유무 체크로직 추가
			String ofc_cd = ((EsdTes0064Event)e).getSignOnUserAccount().getOfc_cd();
			if(((EsdTes0064Event)e).getTesTmlSoHdrVO().getTmlInvStsCd().equals("C") && !ofc_cd.equals("SELTBB")){	//2015-08-03 그룹사 조직 코드 변경 (SELTOB -> SELTBB)
				commandCom.checkInvCalcCostCD(((EsdTes0064Event)e).getTesTmlSoHdrVO());
			}
			
			command.modifyOndockRailChargeBasicInfo(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return this.searchOndockRailChargeBasicInfo(e);
	}
	/**
	 * OndockRailChargeContainerList verify 이벤트 처리<br>
	 * OndockRailChargeContainerList event에 대한 OndockRailChargeContainerList verify 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	public EventResponse verifyOndockRailChargeContainerList(Event e) throws EventException {
		if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    verifyOndockRailChargeContainerList()");

		EsdTes9130Event event = (EsdTes9130Event)e;
		EventResponse 	eventResponse = null;
		OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();

		/**
		 * 2010-04-30
		 * # DB에 성능LOG에 SC에서의 시작 시각을 남기는 부분은 크게 3부분으로 나뉜다. 각가가 transaction을 분리하여 혹 문제가 발생하여도 기존 작업에 영향이 없도록 한다.
		 * 1) 시작 시각 찍기 - key가 되는 curr_seq를 생성하여 마침까지 넘겨야 한다. 한 SC의 작업에서는 하나의 sequence가 바람직하다.
		 * 2) 오류 시각 찍기 - 반드시 1)번에서 넘어온 현재의 key값이 있을 경우만 실행한다.
		 * 3) 마침 시각 찍기 - 반드시 1)번에서 넘어온 현재의 key값이 있을 경우만 실행한다.
		 * 
		 * 
		 * 1) DB에 성능LOG에 SC에서의 시작 시각을 남기는 부분 - 시작부분이 완료되면 반드시 현재의 SEQUENCE를 마칠때까지 넘겨야 한다.
		 * <주> param_map으로 담는 인자값들은 작업에 따라 다르니 그때마다 각각 설정해야한다.
		 */		
		String		currSeq		= null;
		
//		try {
//			TesJbExePerfLogVO tesJbExePerfLogVO = new TesJbExePerfLogVO();
//			
//			tesJbExePerfLogVO.setInvOfcCd		( e.getSignOnUserAccount().getOfc_cd() );
//			tesJbExePerfLogVO.setExeUsrId		( e.getSignOnUserAccount().getUsr_id() );
//			tesJbExePerfLogVO.setJbTpCd			( TESCommonBC.PERF_JOB_TYPE_ON_LINE_INVOICE );
//			tesJbExePerfLogVO.setPgmUrl			( (event.getPageURL() != null && !"".equals(event.getPageURL()) ? event.getPageURL().trim():JSPUtil.getNull( event.getEventName() ) ) );			
//			tesJbExePerfLogVO.setFuncDivCd		( String.valueOf(event.getFormCommand().getCommand()) );
//			tesJbExePerfLogVO.setExeRowKnt		( event.getTesFileImpTmpVOs()!=null?Integer.toString( (event.getTesFileImpTmpVOs()).length ):"" );
//			tesJbExePerfLogVO.setTmlSoOfcCtyCd	( event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd() );
//			tesJbExePerfLogVO.setTmlSoSeq		( event.getTesTmlSoHdrVO().getTmlSoSeq() );
//			tesJbExePerfLogVO.setJbParaCtnt		( event.getPerfParams() );
//			
//			currSeq = beginJobExecutionPerformance( tesJbExePerfLogVO );
//		} catch (Exception ex){
//			//본 업무에 영향을 안주기 위해 Exception을 던지지 않는다.
//			log.error(ex.getMessage());
//			
//			if (false){
//				throw new EventException(ex.getMessage());
//			}
//		}
		
		currSeq = searchCurrSeq(e);
	
		try {
//			무조건 임시 TABLE 지우기1
			log.debug("\n 무조건 임시 TABLE 지우기1 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP(event);
//			임시 TABLE에 넣고
			log.debug("\n 임시 TABLE에 넣고 ------------------------  \n");
			command.createTES_FILE_IMP_TMP(event);
//			계산하기
			log.debug("\n 계산하기 ------------------------  \n");
			eventResponse = command.verifyOndockRailChargeContainerList(event);
			
			event.setRowSet(eventResponse.getRs());

//			CNTR_LIST에 넣고
			log.debug("\n CNTR_LIST에 넣고 ------------------------  \n");
			begin();
			command.createOndockRailChargeContainerList(event);
			commit();
			
			//TRS에서 찾은 BKG No.의 Status가 Cancelled인 경우에는 BKG 테이블에서 최신 BKG No. 찾아서 업데이트 하도록 로직 추가 2018-03-06
			log.debug("\n 1. Cancelled BKG 찾기 ------------------------  \n");
			List<TesTmlSoCntrListVO> updVoList = command.searchBkgNoContainerList(event.getTesTmlSoHdrVO());
			if ( updVoList != null && updVoList.size() > 0 ) {
				begin();
				command.updateBkgNoContainerList(updVoList);
				commit();
			}
			
		}catch(EventException de) {
			log.debug("\n EventException rollback ------------------------  \n");
			rollback();
			log.error("err " + de.toString(), de);
			/**
			 * 2) DB에 성능LOG에 SC에서의 오류 발생 시각을 남기는 부분
			 */			
			errorJobExecutionPerformance(currSeq);					
//			errorJobExecutionPerformance(currSeq, de.toString());	// Error Remark					
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage(), ex);
		} finally {
//			무조건 임시 TABLE 지우기
			log.debug("\n 무조건 임시 TABLE 지우기2 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP(event);
			/**
			 * 3) DB에 성능LOG에 SC에서의 마침 시각을 남기는 부분
			 */ 
			endJobExecutionPerformance(currSeq);
		}
		return eventResponse;
	}


	/**
	 * OndockRailChargeContainerList Multi 이벤트 처리<br>
	 * OndockRailChargeContainerList event에 대한 OndockRailChargeContainerList Multi 이벤트 처리<br>
	 *
	 * @param e EsdTes0064Event
	 * @return EventResponse ESD_TES_0064EventResponse
	 * @exception EventException
	 */
	public EventResponse multiOndockRailChargeContainerList(Event e) throws EventException {
		log.debug("start multiOndockRailChargeContainerList");
		
		EventResponse eventResponse = null;

		try {
			begin();
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			eventResponse = command.multiOndockRailChargeContainerList(e);
			if(log.isDebugEnabled())log.debug("==========ServiceProviderInvoiceManageSC    multiOndockRailChargeContainerList() commit Before");
			commit();
			if(log.isDebugEnabled())log.debug("==========ServiceProviderInvoiceManageSC    multiOndockRailChargeContainerList() commit After");

		} catch (EventException de) {
			//rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * OnDockRailChargeInvoiceManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOndockRailChargeContainerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0064Event event = (EsdTes0064Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		if(log.isDebugEnabled())log.debug("==========ServiceProviderInvoiceManageSC    searchOndockRailChargeContainerList() ============");
		try {
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			eventResponse = command.searchOndockRailChargeContainerList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
	 * 조회 이벤트 처리<br>
	 * OnDockRailChargeInvoiceManage의 event에 대한 특정 searchOndockRailChargeCostCalculationList 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOndockRailChargeCostCalculationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0064Event event = (EsdTes0064Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		if(log.isDebugEnabled())log.debug("==========ServiceProviderInvoiceManageSC    searchOndockRailChargeCostCalculationList() ============");
		try {
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			eventResponse = command.searchOndockRailChargeCostCalculationList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
	 * 조회 이벤트 처리<br>
	 * OnDockRailChargeInvoiceManage의 대한 조회 이벤트 처리<br>
	 *
	 * @param e EsdTes064Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOnDockChargeInvoiceCostCalcComboCodeList(Event e) throws EventException {
//		ESD_TES_064EventResponse eventResponse = null;
		EventResponse eventResponse = null;

		try {
			begin();
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			eventResponse = (EventResponse)command.searchOnDockChargeInvoiceCostCalcComboCodeList(e);
			if(log.isDebugEnabled())log.debug("==========ServiceProviderInvoiceManageSC    searchOnDockChargeInvoiceCostCalcComboCodeList() commit Before");
			commit();
			if(log.isDebugEnabled())log.debug("==========ServiceProviderInvoiceManageSC    searchOnDockChargeInvoiceCostCalcComboCodeList() commit After");

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}
	/**
	 * 멀티 이벤트 처리<br>
	 * MarineTerminalInvoiceManage의 event에 대한 멀티 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	public EventResponse multiOndockRailChargeInvoiceDetail(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			begin();
			
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			TESInvoiceCommonBC commandCom = new TESInvoiceCommonBCImpl();
			
			if(log.isDebugEnabled())log.debug("==========ServiceProviderInvoiceManageSC    multiOnDockChargeInvoiceDetail() commit Before");
			
			eventResponse = command.multiOndockRailChargeInvoiceDetail(e);			
			
			//[CHM-201534788]GW Agmt Link 기준 변경 (Save->Confirm)	2015-03-24
			//[CHM-201640117]유효 AGMT 판단 Date와 Invoice Confirm시 가져오는 GW AGMT date 일치 
			String fromDate = ((EsdTes0064Event)e).getOndockRailChargeInvoiceCommonVO().getMinWrkDt();
			String toDate = ((EsdTes0064Event)e).getOndockRailChargeInvoiceCommonVO().getMaxWrkDt();
			commandCom.updateInvoiceDetailAgmt(((EsdTes0064Event)e).getTesTmlSoHdrVO(), fromDate, toDate);
			
			commit();
			if(log.isDebugEnabled())log.debug("==========ServiceProviderInvoiceManageSC    multiOnDockChargeInvoiceDetail() commit After");

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * MarineTerminalInvoiceManage의 event에 대한 멀티 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	public EventResponse removeOndockRailChargeInvoiceCost(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			begin();
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			eventResponse = command.removeOndockRailChargeInvoiceCost(e);
			if(log.isDebugEnabled())log.debug("==========ServiceProviderInvoiceManageSC    multiOnDockChargeInvoiceDetail() commit Before");
			commit();
			if(log.isDebugEnabled())log.debug("==========ServiceProviderInvoiceManageSC    multiOnDockChargeInvoiceDetail() commit After");

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}
//	/**
//	 * TML_SO_RVIS_LIST 조회 이벤트 처리<br>
//	 * MarineTerminalInvoiceManage화면에 대한 TML_SO_RVIS_LIST 조회 이벤트 처리<br>
//	 *
//	 * @param e EsdTes064Event
//	 * @return eventResponse  ESD_TES_064EventResponse
//	 * @exception EventException
//	 */
//	public EventResponse searchOndockRailChargeInvoiceRvisList(Event e) throws EventException {
//		ESD_TES_064EventResponse eventResponse = null;
//
//		try {
//			begin();
//			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
//			eventResponse = (ESD_TES_064EventResponse)command.searchOndockRailChargeInvoiceRvisList(e);
//			if(log.isDebugEnabled())log.debug("==========ServiceProviderInvoiceManageSC    searchOndockRailChargeInvoiceRvisList() commit Before");
//			commit();
//			if(log.isDebugEnabled())log.debug("==========ServiceProviderInvoiceManageSC    searchOndockRailChargeInvoiceRvisList() commit After");
//
//		} catch (EventException de) {
//			rollback();
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//
//		return eventResponse;
//	}
	
//	/**
//	 * TerminalInvoiceN3rdPartyIF LIST 조회 이벤트 처리<br>
//	 * MarineTerminalInvoiceManage화면에 대한 TerminalInvoiceN3rdPartyIF LIST 조회 이벤트 처리<br>
//	 *
//	 * @param e EsdTes064Event
//	 * @return eventResponse  ESD_TES_064EventResponse
//	 * @exception EventException
//	 */
//	public EventResponse searchOndockRailChargeInvoiceN3ptyList(Event e) throws EventException {
//		ESD_TES_064EventResponse eventResponse = null;
//
//		try {
//			begin();
//			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
//			eventResponse = (ESD_TES_064EventResponse)command.searchOndockRailChargeInvoiceN3ptyList(e);
//			if(log.isDebugEnabled())log.debug("==========ServiceProviderInvoiceManageSC    searchOndockRailChargeInvoiceN3ptyList() commit Before");
//			commit();
//			if(log.isDebugEnabled())log.debug("==========ServiceProviderInvoiceManageSC    searchOndockRailChargeInvoiceN3ptyList() commit After");
//
//		} catch (EventException de) {
//			rollback();
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//
//		return eventResponse;
//	}

	/**
	 * TerminalInvoiceN3ptyAutoCntrList 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 TerminalInvoiceN3ptyAutoCntrList 조회 이벤트 처리<br>
	 *
	 * @param e EsdTes9231Event
	 * @return eventResponse  ESD_TES_9231EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceN3ptyAutoCntrList(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			begin();
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			eventResponse = command.searchTerminalInvoiceN3ptyAutoCntrList(e);
			
			if(log.isDebugEnabled())log.debug("==========ServiceProviderInvoiceManageSC    searchTerminalInvoiceN3ptyAutoCntrList() commit Before");
			commit();
			if(log.isDebugEnabled())log.debug("==========ServiceProviderInvoiceManageSC    searchTerminalInvoiceN3ptyAutoCntrList() commit After");

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}
	/**
	 * TerminalInvoiceN3ptyManualCntrList 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 TerminalInvoiceN3ptyManualCntrList 조회 이벤트 처리<br>
	 *
	 * @param e EsdTes9231Event
	 * @return eventResponse  ESD_TES_9231EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceN3ptyManualCntrList(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			begin();
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			eventResponse = command.searchTerminalInvoiceN3ptyManualCntrList(e);
			
			if(log.isDebugEnabled())log.debug("==========ServiceProviderInvoiceManageSC    searchTerminalInvoiceN3ptyManualCntrList() commit Before");
			commit();
			if(log.isDebugEnabled())log.debug("==========ServiceProviderInvoiceManageSC    searchTerminalInvoiceN3ptyManualCntrList() commit After");

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}


	/**
	 * 3rd Party 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 Revised Vol List조회 이벤트 처리<br>
	 *
	 * @param e EsdTes9251Event
	 * @return eventResponse  ESD_TES_9251EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOnDockTrdPartyVolume(Event e) throws EventException {
		EventResponse eventResponse = null;
		EsdTes9251Event event = (EsdTes9251Event)e;
		
		try {
			if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    searchOnDockTrdPartyVolume()");
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			eventResponse = command.searchOnDockTrdPartyVolume(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}


	/**
	 * Revised Vol List 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 Revised Vol List조회 이벤트 처리<br>
	 *
	 * @param e EsdTes9031Event
	 * @return  EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOnDockAutoRevisedVolume(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    searchOnDockAutoRevisedVolume()");
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			eventResponse = command.searchAutoRevisedVolume(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}



	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage의 event에 대한 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	public EventResponse updateOnDockContainerListRvisFlg(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    updateOnDockContainerListRvisFlg()");
			begin();
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			eventResponse = command.updateOnDockContainerListRvisFlg(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * Revised Vol List 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 Revised Vol List조회 이벤트 처리<br>
	 *
	 * @param e EsdTes9031Event
	 * @return eventResponse  ESD_TES_903_1EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceRevisedVolume(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			begin();
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			eventResponse = command.searchTerminalInvoiceRevisedVolume(e);
			if(log.isDebugEnabled())log.debug("==========ServiceProviderInvoiceManageSC    searchTerminalInvoiceRevisedVolume() commit Before");
			commit();
			if(log.isDebugEnabled())log.debug("==========ServiceProviderInvoiceManageSC    searchTerminalInvoiceRevisedVolume() commit After");

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}
	/**
	 * Revised Vol List 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 Revised Vol List조회 이벤트 처리<br>
	 *
	 * @param e EsdTes903_1Event
	 * @return eventResponse  ESD_TES_903_1EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceRevisedVolume9031(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			begin();
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			eventResponse = command.searchTerminalInvoiceRevisedVolume9031(e);
			if(log.isDebugEnabled())log.debug("========== ServiceProviderInvoiceManageSC    searchTerminalInvoiceRevisedVolume903_1() commit Before");
			commit();
			if(log.isDebugEnabled())log.debug("========== ServiceProviderInvoiceManageSC    searchTerminalInvoiceRevisedVolume903_1() commit After");

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/** parkyeonjin 끝  *********************/


	/** 문종배 시작  *********************/
	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCSRSummary(Event e) throws EventException {

		EsdTes0023Event event = (EsdTes0023Event)e;
		EventResponse eventResponse = null;

		try {
			CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
			eventResponse = command.searchCSRSummary(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCSRSummary1(Event e) throws EventException {
		EsdTes0023Event event 			= (EsdTes0023Event)e;
		EventResponse 	eventResponse 	= null;

		try {
			CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
			eventResponse = command.searchCSRSummary1(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSoIfCd(Event e) throws EventException {
		EsdTes0023Event event = (EsdTes0023Event)e;
		EventResponse eventResponse = null;

		try {
			CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
			eventResponse = command.searchSoIfCd(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCSRSummaryDetail1(Event e) throws EventException {

		EsdTes0024Event event = (EsdTes0024Event)e;
		EventResponse 	eventResponse = null;

		try {
			begin();
			CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
			eventResponse = command.searchCSRSummaryDetail1(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * searchCSRSummaryDetail
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCSRSummaryDetail(Event e) throws EventException {
		log.debug("start searchCSRSummaryDetail ==========================");
		
		EsdTes0024Event event 			= (EsdTes0024Event)e;
		EventResponse 	eventResponse 	= null;

		try {
			begin();
			CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
			eventResponse = command.searchCSRSummaryDetail(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * searchCSRSummaryDetail
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCSRSummaryDetail2(Event e) throws EventException {
		log.debug("start searchCSRSummaryDetail2 ==========================");
		
		EsdTes0080Event event 			= (EsdTes0080Event)e;
		EventResponse 	eventResponse 	= null;

		try {
			begin();
			CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
			eventResponse = command.searchCSRSummaryDetail2(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse tmpSearchCSRSummary(Event e) throws EventException {

		EsdTes0024Event event = (EsdTes0024Event)e;
		EventResponse eventResponse = null;

		try {
			begin();
			CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
			eventResponse = command.tmpSearchCSRSummary(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
    
	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse tmpSearchPreVeiw(Event e) throws EventException {
		log.debug("start tmpSearchPreVeiw ======================== FormCommand:"+FormCommand.SEARCH03);
		
		EsdTes0024Event event 			= (EsdTes0024Event)e;
		EventResponse 	eventResponse 	= null;

		try {
			begin();
			CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
			eventResponse = command.tmpSearchPreVeiw(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse approvalRequest(Event e) throws EventException {
		log.debug("\n\n SC.approvalRequest Start ----------------------  \n\n");
		
		EsdTes0024Event event = (EsdTes0024Event)e;
		EventResponse eventResponse = null;
		CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
		DBRowSet[] autoRevVVDList = null;
		DBRowSet[] manualRevVVDList = null;
		DBRowSet[] dtrbRowSet = null;
		
		DBRowSet[] cancelledBkgList = null;

//		HashMap param_map = (HashMap)event.getParam_map();
//		String cnt_cd = param_map!=null?(String)param_map.get("cnt_cd"):"";

		try {
			//Cancelled BKG 이면 BKG를 새로 찾아서 변경한다. 2018-03-09
			cancelledBkgList = command.getCancelledBkgNoList(event);
			event.setBkgRowSetArr01(cancelledBkgList);
			
			begin();
			command.modifyCancelledBkgNo(event);
			commit();
			
			autoRevVVDList = command.getAutoRevVVDList(event);
			event.setAutoRowSetArr01(autoRevVVDList);
			manualRevVVDList = command.getManualRevVVDList(event);
			event.setManualRowSetArr01(manualRevVVDList);

			begin();
			command.modifyAutoRevVVD(event);
			command.modifyManualRevVVD(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw de;
		}catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage(), ex);
		}

		try {
			if (event.getCARIssueTransferSlipManageCommonVO().getCntCd().equals("KR")){
				dtrbRowSet =command.searchApInvDTRBIn(event);
				event.setDtrbRowSetArr(dtrbRowSet); 
			} else {
				dtrbRowSet =command.searchApInvDTRBOut(event);
				event.setDtrbRowSetArr(dtrbRowSet);
			}

			begin();
			eventResponse = command.approvalRequest(event);
			commit();
			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw de;
		}catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage(), ex);
		}
		
		log.debug("\n\n SC.approvalRequest End ----------------------  \n\n");
		return eventResponse;
	}
	
	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPreVeiw(Event e) throws EventException {
		log.debug("\n\n SC.searchPreVeiw ============================= \n\n");
		
		EsdTes0024Event event = (EsdTes0024Event)e;
		CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
		EventResponse 	eventResponse 		= null;
		DBRowSet[] 		autoRevVVDList 		= null;
		DBRowSet[] 		manualRevVVDList 	= null;
		DBRowSet[] 		dtrbRowSet 			= null;

//		HashMap param_map = (HashMap)event.getParam_map();
//		String cnt_cd = param_map!=null?(String)param_map.get("cnt_cd"):"";

		try {
			autoRevVVDList 		= command.getAutoRevVVDList(event);
			event.setAutoRowSetArr01(autoRevVVDList);
			
			manualRevVVDList = command.getManualRevVVDList(event);
			event.setManualRowSetArr01(manualRevVVDList);

			begin();
			command.modifyAutoRevVVD(event);
			command.modifyManualRevVVD(event);
			commit();
			
		}catch (EventException de) {
			rollback();
			log.error("searchPreVeiw err " + de.toString(), de);
			throw de;
		}catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage(), ex);
		}

		try {
			if (event.getCARIssueTransferSlipManageCommonVO().getCntCd().equals("KR")){
				dtrbRowSet =command.searchApInvDTRBIn(event);
				event.setDtrbRowSetArr(dtrbRowSet);

			} else {
				dtrbRowSet =command.searchApInvDTRBOut(event);
				event.setDtrbRowSetArr(dtrbRowSet);
			}

			begin();
			eventResponse = command.searchPreVeiw(event);
			commit();
		}catch (EventException de) {
			rollback();
			log.error("searchPreVeiw err " + de.toString(), de);
			throw de;
		}catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTAXInfo(Event e) throws EventException {
		log.debug("start searchTAXInfo ================");
		
		EsdTes0078Event event = (EsdTes0078Event)e;
		EventResponse 	eventResponse = null;

		try {
			CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
			eventResponse = command.searchTAXInfo(event, account);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchApEviNo(Event e) throws EventException {
		log.debug("start searchApEviNo ================");
		
		EsdTes0078Event event = (EsdTes0078Event)e;
		EventResponse 	eventResponse = null;

		try {
			begin();
			CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
			eventResponse = command.searchApEviNo(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTAXCode(Event e) throws EventException {
		log.debug("start searchTAXCode ========================");
		
		EsdTes0078Event event = (EsdTes0078Event)e;
		EventResponse 	eventResponse = null;

		try {
			CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
			eventResponse = command.searchTAXCode(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/** 문종배 끝  *********************/

	/**
	 * VVD Dual 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 VVD Dual 조회 이벤트 처리<br>
	 *
	 * @param e EsdTes001Event
	 * @return eventResponse  ESD_TES_001EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceVVDDual(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    searchTerminalInvoiceVVDDual() ============");

			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = (EventResponse)command.searchTerminalInvoiceVVDDual(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}
	
	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTerminalInvoiceAutoBoundList(Event e) throws EventException{
		if(log.isDebugEnabled()) log.debug("\n\nServiceProvider Invoice ManageSC :::::::: searchTerminalInvoiceAutoBoundList\n");
		EventResponse eventResponse = null;

		try{
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchTerminalInvoiceAutoBoundList(e);
		}catch(EventException de){
			log.error("err" + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiTerminalInvoiceAutoBoundList(Event e) throws EventException {

		try {
			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			command.checkDualVVD(e);
			command.multiTerminalInvoiceAutoBoundList(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return searchTerminalInvoiceAutoBoundList(e);
	}

	/**
	 * DB에 성능LOG에 SC단위에서 작업 시작 시각 찍기 (2009-03-11)
	 * @param param_map
	 * @return String
	 * @exception EventException
	 */
	private String beginJobExecutionPerformance(TesJbExePerfLogVO tesJbExePerfLogVO) {
		log.debug("\n\n  ##### beginJobExecutionPerformance  \n\n");
		/**
		 * # DB에 성능LOG에 SC에서의 시작 시각을 남기는 부분은 크게 3부분으로 나뉜다. 각가가 transaction을 분리하여 혹 문제가 발생하여도 기존 작업에 영향이 없도록 한다.
		 * 1) 시작 시각 찍기 - key가 되는 sequence를 생성하여 마침까지 넘겨야 한다. 한 SC의 작업에서는 하나의 sequence가 바람직하다.
		 * 2) 오류 시각 찍기 - 반드시 1)번에서 넘어온 현재의 key값이 있을 경우만 실행한다.
		 * 3) 마침 시각 찍기 - 반드시 1)번에서 넘어온 현재의 key값이 있을 경우만 실행한다.
		 */
		String curr_seq = null;
		try {
			/**
			 * 1) DB에 성능LOG에 SC에서의 시작 시각을 남기는 부분 - 시작부분이 완료되면 반드시 현재의 SEQUENCE를 마칠때까지 넘겨야 한다.
			 * <주> param_map으로 담는 인자값들은 작업에 따라 다르니 그때마다 각각 설정해야한다.
			 */
			begin();
			//TESCommonEvent com_event = null;
//			String param_name = null;
//			java.util.Enumeration enums = request.getParameterNames();
//			while (enums.hasMoreElements()){
//				param_name = (String)enums.nextElement();
//				param_map.put(param_name,request.getParameter(param_name));
//				log.debug("[param_name:" + param_name + "] - value:" + request.getParameter(param_name));
//			}
//			com_event = new TESCommonEvent(param_map);
//			curr_seq = new TESCommonBCImpl().beginJobExecutionPerformance(com_event);
			

			//com_event = new TESCommonEvent();
			//com_event.setTesCommonVO(tesCommonVO);		
			curr_seq = new TESCommonBCImpl().beginJobExecutionPerformance(tesJbExePerfLogVO);  			
			
			commit();
		} catch (Exception de) {
			/** 기존 작업에 영향을 주지 않기 위해 Exception을 던지지 않는다. **/ 
			rollback();
			log.error("\n  beginJobExecutionPerformance - ERROR!  \n");
			log.error("err " + de.toString(), de);
		}
		return curr_seq;
	}
	
	
	
	/**
	 * DB에 성능LOG에 SC단위에서 작업 오류 시각 찍기 (2009-03-11)
	 * @param curr_seq
	 */
	private void errorJobExecutionPerformance(String currSeq) {
		try {
			if (currSeq!=null && !currSeq.trim().equals("")){
				begin();
				new TESCommonBCImpl().errorJobExecutionPerformance(currSeq);
				commit();
			} else {
				log.error("\n\n  errorJobExecutionPerformance - NO PERF_SEQUENCE FOUND ERROR! \n\n");
			}			
		} catch (Exception de) {
			/** 기존 작업에 영향을 주지 않기 위해 Exception을 던지지 않는다. **/ 
			rollback();
			log.error("\n  errorJobExecutionPerformance - ERROR!  \n");
			log.error("err " + de.toString(), de);
		}
	}

	/**
	 * DB에 성능LOG에 SC단위에서 작업 오류 시각 찍기 (2009-03-11)
	 * @param currSeq
	 * @param errRmk
	 */
//	private void errorJobExecutionPerformance(String currSeq, String errRmk) {
//		try {
//			if (currSeq!=null && !currSeq.trim().equals("")){
//				begin();
////				new TESCommonBCImpl().errorJobExecutionPerformance(currSeq, errRmk);
//				commit();
//			} else {
//				log.error("\n\n  errorJobExecutionPerformance - NO PERF_SEQUENCE FOUND ERROR! \n\n");
//			}			
//		} catch (Exception de) {
//			/** 기존 작업에 영향을 주지 않기 위해 Exception을 던지지 않는다. **/ 
//			rollback();
//			log.error("\n  errorJobExecutionPerformance - ERROR!  \n");
//			log.error("err " + de.toString(), de);
//		}
//	}

	/**
	 * DB에 성능LOG에 SC단위에서 작업 마침 시각 찍기 (2009-03-11)
	 * @param currSeq
	 */
	private void endJobExecutionPerformance(String currSeq) {
		try {
log.info("\n\n [SC][endJobExecutionPerformance][] >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> currSeq = " + currSeq );			
			if (currSeq!=null && !currSeq.trim().equals("")){
				begin();
				new TESCommonBCImpl().endJobExecutionPerformance(currSeq);
				commit();
			} else {
				log.error("\n\n  endJobExecutionPerformance - NO PERF_SEQUENCE FOUND ERROR! \n\n");
			}			
		} catch (Exception de) {
			/** 기존 작업에 영향을 주지 않기 위해 Exception을 던지지 않는다. **/ 
			rollback();
			log.error("\n  endJobExecutionPerformance - ERROR!  \n");
			log.error("err " + de.toString(), de);
		}
	}

	/**
	 * Search MGSet List
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMGSetFuelingChargeList(Event e) throws EventException {
		EventResponse eventResponse = null;
//		EsdTes1004Event event = (EsdTes1004Event)e;
		
		try {
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchMGSetFuelingChargeList(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}
	
	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiMGSetFuelingCharge(Event e) throws EventException {

		try {
			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			command.multiMGSetFuelingCharge(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchMGSetFuelingChargeList(e);
	}
	
//	/**
//	 * 
//	 * @param e
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	private EventResponse modifyStsCdSOHDRBack(Event e) throws EventException {
//		EventResponse eventResponse = null;
//		
//		try {
//			CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
//			eventResponse = command.modifyStsCdSOHDRBack(e);
//			
//		} catch (EventException de) {
//			rollback();
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//
//		return eventResponse;
//	}
	
	
	/**
	 * 
	 * @param e
	 * @return
	 */
	private String searchCurrSeq(Event e){
		
		String curr_seq = null;
		TesJbExePerfLogVO tesJbExePerfLogVO = new TesJbExePerfLogVO();
		
		if (e instanceof EsdTes9140Event) {
			EsdTes9140Event event = (EsdTes9140Event)e;
			try {
				String pageURL = event.getPageURL();
				tesJbExePerfLogVO.setInvOfcCd( e.getSignOnUserAccount().getOfc_cd() );
				tesJbExePerfLogVO.setExeUsrId( e.getSignOnUserAccount().getUsr_id() );
				tesJbExePerfLogVO.setJbTpCd( TESCommonBC.PERF_JOB_TYPE_ON_LINE_INVOICE );
				tesJbExePerfLogVO.setPgmUrl( (pageURL!=null&&!pageURL.equals("")?pageURL.trim():JSPUtil.getNull(event.getEventName())) );			
				tesJbExePerfLogVO.setFuncDivCd( String.valueOf(event.getFormCommand().getCommand()) );
				tesJbExePerfLogVO.setExeRowKnt( event.getTesFileImpTmpVOs()!=null?Integer.toString( (event.getTesFileImpTmpVOs()).length ):"" );
				tesJbExePerfLogVO.setTmlSoOfcCtyCd( event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd() );
				tesJbExePerfLogVO.setTmlSoSeq( event.getTesTmlSoHdrVO().getTmlSoSeq() );
				tesJbExePerfLogVO.setJbParaCtnt( event.getPerfParams() );
			} catch (Exception ex) {
				log.error(ex.getMessage());
			}
		} else if(e instanceof EsdTes9142Event){
			EsdTes9142Event event = (EsdTes9142Event)e;
			try {
				String pageURL = event.getPageURL();
				tesJbExePerfLogVO.setInvOfcCd( e.getSignOnUserAccount().getOfc_cd() );
				tesJbExePerfLogVO.setExeUsrId( e.getSignOnUserAccount().getUsr_id() );
				tesJbExePerfLogVO.setJbTpCd( TESCommonBC.PERF_JOB_TYPE_ON_LINE_INVOICE );
				tesJbExePerfLogVO.setPgmUrl( (pageURL!=null&&!pageURL.equals("")?pageURL.trim():JSPUtil.getNull(event.getEventName())) );			
				tesJbExePerfLogVO.setFuncDivCd( String.valueOf(event.getFormCommand().getCommand()) );
				tesJbExePerfLogVO.setExeRowKnt( event.getTesFileImpTmpVOs()!=null?Integer.toString( (event.getTesFileImpTmpVOs()).length ):"" );
				tesJbExePerfLogVO.setTmlSoOfcCtyCd( event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd() );
				tesJbExePerfLogVO.setTmlSoSeq( event.getTesTmlSoHdrVO().getTmlSoSeq() );
				tesJbExePerfLogVO.setJbParaCtnt( event.getPerfParams() );
			} catch (Exception ex) {
				log.error(ex.getMessage());
			}
		} else if(e instanceof EsdTes9233Event){
			EsdTes9233Event	event = (EsdTes9233Event) e;
			TesN3rdPtyIfVO[]	tesN3rdPtyIfVOs 	= null;
			try {
				tesN3rdPtyIfVOs		= event.getTesN3rdPtyIfVOs();
				StringBuilder		sbuPerfRmk			= new StringBuilder();
				int					insFlgCnt			= 0;	// INSERT
				int					updFlgCnt			= 0;	// UPDATE

				for( int i = 0; tesN3rdPtyIfVOs != null && i < tesN3rdPtyIfVOs.length; i++ ) {
					if ( "I".equals(tesN3rdPtyIfVOs[i].getIbflag() ) ) {
						insFlgCnt++;
					}
					if ( "U".equals(tesN3rdPtyIfVOs[i].getIbflag() ) ) {
						updFlgCnt++;
					}
				}

				if ( insFlgCnt > 0 ) {
					sbuPerfRmk.append("C");
				}
				if ( updFlgCnt > 0 ) {
					sbuPerfRmk.append("U");
				}
				
				// TPB DELETE.
				String	delIfSeq	= JSPUtil.getNull(event.getOffdockCYInvoiceManageVO().getDelIfSeq());
				if ( delIfSeq.length() > 0 ) {
					delIfSeq	= delIfSeq.substring( 0, delIfSeq.length() - 1 ); 		//.replaceAll("\\|", ",");
					String	[]	arrIfSeq	= delIfSeq.split("\\|");
					sbuPerfRmk.append("D(" + arrIfSeq.length + ")"); // 삭제 건수.
				}

				tesJbExePerfLogVO.setInvOfcCd		( e.getSignOnUserAccount().getOfc_cd() );
				tesJbExePerfLogVO.setExeUsrId		( e.getSignOnUserAccount().getUsr_id() );
				tesJbExePerfLogVO.setJbTpCd			( TESCommonBC.PERF_JOB_TYPE_TPB );
				tesJbExePerfLogVO.setPgmUrl			( (event.getPageURL() != null && !"".equals(event.getPageURL()) ? event.getPageURL().trim():JSPUtil.getNull( event.getEventName() ) ) );			
				tesJbExePerfLogVO.setFuncDivCd		( String.valueOf(event.getFormCommand().getCommand()) );
				tesJbExePerfLogVO.setExeRowKnt		( tesN3rdPtyIfVOs != null ? Integer.toString( tesN3rdPtyIfVOs.length ) : "" );
				tesJbExePerfLogVO.setTmlSoOfcCtyCd	( event.getTesN3rdPtyIfVO().getTmlSoOfcCtyCd() );
				tesJbExePerfLogVO.setTmlSoSeq		( event.getTesN3rdPtyIfVO().getTmlSoSeq() );
				tesJbExePerfLogVO.setJbParaCtnt		( event.getPerfParams() );
				tesJbExePerfLogVO.setPerfRmk		( sbuPerfRmk.toString() );
				
			} catch (Exception ex){
				log.error(ex.getMessage());
			}
		} else if(e instanceof EsdTes9234Event){
			EsdTes9234Event event = (EsdTes9234Event)e;
			TesN3rdPtyIfVO[]	tesN3rdPtyIfVOs 	= null;
			try {
				tesN3rdPtyIfVOs		= event.getTesN3rdPtyIfVOs();
				StringBuilder		sbuPerfRmk			= new StringBuilder();
				int					insFlgCnt			= 0;	// INSERT
				int					updFlgCnt			= 0;	// UPDATE
				
				for( int i = 0; tesN3rdPtyIfVOs != null && i < tesN3rdPtyIfVOs.length; i++ ) {
					if ( "I".equals(tesN3rdPtyIfVOs[i].getIbflag() ) ) {
						insFlgCnt++;
					}
					if ( "U".equals(tesN3rdPtyIfVOs[i].getIbflag() ) ) {
						updFlgCnt++;
					}
				}

				if ( insFlgCnt > 0 ) {
					sbuPerfRmk.append("C");
				}
				if ( updFlgCnt > 0 ) {
					sbuPerfRmk.append("U");
				}
				
				// TPB DELETE.
				String	delIfSeq	= JSPUtil.getNull(event.getMarineTerminalStorageInvoiceManageVO().getDelIfSeq());
				if ( delIfSeq.length() > 0 ) {
					delIfSeq	= delIfSeq.substring( 0, delIfSeq.length() - 1 ); 		//.replaceAll("\\|", ",");
					String	[]	arrIfSeq	= delIfSeq.split("\\|");
					sbuPerfRmk.append("D(" + arrIfSeq.length + ")"); // 삭제 건수.
				}

				tesJbExePerfLogVO.setInvOfcCd		( e.getSignOnUserAccount().getOfc_cd() );
				tesJbExePerfLogVO.setExeUsrId		( e.getSignOnUserAccount().getUsr_id() );
				tesJbExePerfLogVO.setJbTpCd			( TESCommonBC.PERF_JOB_TYPE_TPB );
				tesJbExePerfLogVO.setPgmUrl			( (event.getPageURL() != null && !"".equals(event.getPageURL()) ? event.getPageURL().trim():JSPUtil.getNull( event.getEventName() ) ) );			
				tesJbExePerfLogVO.setFuncDivCd		( String.valueOf(event.getFormCommand().getCommand()) );
				tesJbExePerfLogVO.setExeRowKnt		( tesN3rdPtyIfVOs != null ? Integer.toString( tesN3rdPtyIfVOs.length ) : "" );
				tesJbExePerfLogVO.setTmlSoOfcCtyCd	( event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd() );
				tesJbExePerfLogVO.setTmlSoSeq		( event.getTesTmlSoHdrVO().getTmlSoSeq() );
				tesJbExePerfLogVO.setJbParaCtnt		( event.getPerfParams() );
				tesJbExePerfLogVO.setPerfRmk		( sbuPerfRmk.toString() );
				
			} catch (Exception ex){
				log.error(ex.getMessage());
			}
		} else if(e instanceof EsdTes0013Event){
			EsdTes0013Event event = (EsdTes0013Event)e;
			try {
				String pageURL = event.getPageURL();
				tesJbExePerfLogVO.setInvOfcCd( e.getSignOnUserAccount().getOfc_cd() );
				tesJbExePerfLogVO.setExeUsrId( e.getSignOnUserAccount().getUsr_id() );
				tesJbExePerfLogVO.setJbTpCd( TESCommonBC.PERF_JOB_TYPE_ON_LINE );
				tesJbExePerfLogVO.setPgmUrl( (pageURL!=null&&!pageURL.equals("")?pageURL.trim():JSPUtil.getNull(event.getEventName())) );			
				tesJbExePerfLogVO.setFuncDivCd( String.valueOf(event.getFormCommand().getCommand()) );
				tesJbExePerfLogVO.setJbParaCtnt( event.getPerfParams() );
			} catch (Exception ex){
				log.error(ex.getMessage());
			}
		} else if(e instanceof EsdTes0014Event){
			EsdTes0014Event event = (EsdTes0014Event)e;
			try {//2009-03-12
				String pageURL = event.getPageURL();
				tesJbExePerfLogVO.setInvOfcCd( e.getSignOnUserAccount().getOfc_cd() );
				tesJbExePerfLogVO.setExeUsrId( e.getSignOnUserAccount().getUsr_id() );
				tesJbExePerfLogVO.setJbTpCd( TESCommonBC.PERF_JOB_TYPE_ON_LINE );
				tesJbExePerfLogVO.setPgmUrl( (pageURL!=null&&!pageURL.equals("")?pageURL.trim():JSPUtil.getNull(event.getEventName())) );			
				tesJbExePerfLogVO.setFuncDivCd( String.valueOf(event.getFormCommand().getCommand()) );
				tesJbExePerfLogVO.setJbParaCtnt( event.getPerfParams() );
			} catch (Exception ex){
				log.error(ex.getMessage());
			}
		} else if(e instanceof EsdTes9010Event){
			EsdTes9010Event event = (EsdTes9010Event)e;
			try {
				String pageURL = event.getPageURL();
				tesJbExePerfLogVO.setInvOfcCd( e.getSignOnUserAccount().getOfc_cd() );
				tesJbExePerfLogVO.setExeUsrId( e.getSignOnUserAccount().getUsr_id() );
				tesJbExePerfLogVO.setJbTpCd( TESCommonBC.PERF_JOB_TYPE_ON_LINE_INVOICE );
				tesJbExePerfLogVO.setPgmUrl( (pageURL!=null&&!pageURL.equals("")?pageURL.trim():JSPUtil.getNull(event.getEventName())) );			
				tesJbExePerfLogVO.setFuncDivCd( String.valueOf(event.getFormCommand().getCommand()) );
				tesJbExePerfLogVO.setExeRowKnt( event.getTesFileImpTmpVOs()!=null?Integer.toString( (event.getTesFileImpTmpVOs()).length ):"" );
				tesJbExePerfLogVO.setTmlSoOfcCtyCd( event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd() );
				tesJbExePerfLogVO.setTmlSoSeq( event.getTesTmlSoHdrVO().getTmlSoSeq() );
				tesJbExePerfLogVO.setJbParaCtnt( event.getPerfParams() );
			} catch (Exception ex){
				log.error(ex.getMessage());
			}
		} else if(e instanceof EsdTes9232Event){
			EsdTes9232Event	event		= (EsdTes9232Event)e;
			TesN3rdPtyIfVO[]	tesN3rdPtyIfVOs 	= null;
			
			// TPB IF SVXXJO 누락건 분석위한 로그추가.(2010-04-27)
			try {
				tesN3rdPtyIfVOs		= event.getTesN3rdPtyIfVOs();
				StringBuilder		sbuPerfRmk			= new StringBuilder();
				int					joCnt				= 0;	// SVXXJO 건 
				int					insFlgCnt			= 0;	// INSERT
				int					updFlgCnt			= 0;	// UPDATE
				
				// SVXXJO 건인지 확인하기 위함.
				for( int i = 0; tesN3rdPtyIfVOs != null && i < tesN3rdPtyIfVOs.length; i++ ) {
					if ( "SVXXJO".equals(tesN3rdPtyIfVOs[i].getLgsCostCd() ) ) {
						joCnt++;
					}
					if ( "I".equals(tesN3rdPtyIfVOs[i].getIbflag() ) ) {
						insFlgCnt++;
					}
					if ( "U".equals(tesN3rdPtyIfVOs[i].getIbflag() ) ) {
						updFlgCnt++;
					}
				}

				if ( joCnt > 0 ) {
					sbuPerfRmk.append("JO ");
					if ( sbuPerfRmk.length() > 0 ) {
						if ( insFlgCnt > 0 ) {
							sbuPerfRmk.append("C");
						}
						if ( updFlgCnt > 0 ) {
							sbuPerfRmk.append("U");
						}
					}
				}
				
				// TPB DELETE.
				String	delIfSeq	= JSPUtil.getNull(event.getMarineTerminalInvoiceCommonVO().getDelIfSeq());
				if ( delIfSeq.length() > 0 ) {
					delIfSeq	= delIfSeq.substring( 0, delIfSeq.length() - 1 ); 		//.replaceAll("\\|", ",");
					String	[]	arrIfSeq	= delIfSeq.split("\\|");
					sbuPerfRmk.append("D(" + arrIfSeq.length + ")"); // 삭제 건수.
				}

				tesJbExePerfLogVO.setInvOfcCd		( e.getSignOnUserAccount().getOfc_cd() );
				tesJbExePerfLogVO.setExeUsrId		( e.getSignOnUserAccount().getUsr_id() );
				tesJbExePerfLogVO.setJbTpCd			( TESCommonBC.PERF_JOB_TYPE_TPB );
				tesJbExePerfLogVO.setPgmUrl			( (event.getPageURL() != null && !"".equals(event.getPageURL()) ? event.getPageURL().trim():JSPUtil.getNull( event.getEventName() ) ) );			
				tesJbExePerfLogVO.setFuncDivCd		( String.valueOf(event.getFormCommand().getCommand()) );
				tesJbExePerfLogVO.setExeRowKnt		( tesN3rdPtyIfVOs != null ? Integer.toString( tesN3rdPtyIfVOs.length ) : "" );
				tesJbExePerfLogVO.setTmlSoOfcCtyCd	( event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd() );
				tesJbExePerfLogVO.setTmlSoSeq		( event.getTesTmlSoHdrVO().getTmlSoSeq() );
				tesJbExePerfLogVO.setJbParaCtnt		( event.getPerfParams() );
				tesJbExePerfLogVO.setPerfRmk		( sbuPerfRmk.toString() );
				
			} catch (Exception ex){
				log.error(ex.getMessage());
			}
		} else if(e instanceof EsdTes9231Event){
			EsdTes9231Event event = (EsdTes9231Event)e;
			TesN3rdPtyIfVO[]	tesN3rdPtyIfVOs 	= null;
			
			// TPB IF 누락건 분석위한 로그추가.(2010-05-03)
			try {
				tesN3rdPtyIfVOs		= event.getTesN3rdPtyIfVOs();
				StringBuilder		sbuPerfRmk			= new StringBuilder();
				int					insFlgCnt			= 0;	// INSERT
				int					updFlgCnt			= 0;	// UPDATE
				
				// 건인지 확인하기 위함.
				for( int i = 0; tesN3rdPtyIfVOs != null && i < tesN3rdPtyIfVOs.length; i++ ) {
					if ( "I".equals(tesN3rdPtyIfVOs[i].getIbflag() ) ) {
						insFlgCnt++;
					}
					if ( "U".equals(tesN3rdPtyIfVOs[i].getIbflag() ) ) {
						updFlgCnt++;
					}
				}

				if ( insFlgCnt > 0 ) {
					sbuPerfRmk.append("C");
				}
				if ( updFlgCnt > 0 ) {
					sbuPerfRmk.append("U");
				}
				
				// TPB DELETE.
				String	delIfSeq	= JSPUtil.getNull(event.getOndockRailChargeInvoiceCommonVO().getDelIfSeq());
				if ( delIfSeq.length() > 0 ) {
					delIfSeq	= delIfSeq.substring( 0, delIfSeq.length() - 1 ); 		//.replaceAll("\\|", ",");
					String	[]	arrIfSeq	= delIfSeq.split("\\|");
					sbuPerfRmk.append("D(" + arrIfSeq.length + ")"); // 삭제 건수.
				}

				tesJbExePerfLogVO.setInvOfcCd		( e.getSignOnUserAccount().getOfc_cd() );
				tesJbExePerfLogVO.setExeUsrId		( e.getSignOnUserAccount().getUsr_id() );
				tesJbExePerfLogVO.setJbTpCd			( TESCommonBC.PERF_JOB_TYPE_TPB );
				tesJbExePerfLogVO.setPgmUrl			( (event.getPageURL() != null && !"".equals(event.getPageURL()) ? event.getPageURL().trim():JSPUtil.getNull( event.getEventName() ) ) );			
				tesJbExePerfLogVO.setFuncDivCd		( String.valueOf(event.getFormCommand().getCommand()) );
				tesJbExePerfLogVO.setExeRowKnt		( tesN3rdPtyIfVOs != null ? Integer.toString( tesN3rdPtyIfVOs.length ) : "" );
				tesJbExePerfLogVO.setTmlSoOfcCtyCd	( event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd() );
				tesJbExePerfLogVO.setTmlSoSeq		( event.getTesTmlSoHdrVO().getTmlSoSeq() );
				tesJbExePerfLogVO.setJbParaCtnt		( event.getPerfParams() );
				tesJbExePerfLogVO.setPerfRmk		( sbuPerfRmk.toString() );
				
			} catch (Exception ex){
				log.error(ex.getMessage());
			}
		} else if(e instanceof EsdTes9130Event){
			EsdTes9130Event event = (EsdTes9130Event)e;
			try {
				tesJbExePerfLogVO.setInvOfcCd		( e.getSignOnUserAccount().getOfc_cd() );
				tesJbExePerfLogVO.setExeUsrId		( e.getSignOnUserAccount().getUsr_id() );
				tesJbExePerfLogVO.setJbTpCd			( TESCommonBC.PERF_JOB_TYPE_ON_LINE_INVOICE );
				tesJbExePerfLogVO.setPgmUrl			( (event.getPageURL() != null && !"".equals(event.getPageURL()) ? event.getPageURL().trim():JSPUtil.getNull( event.getEventName() ) ) );			
				tesJbExePerfLogVO.setFuncDivCd		( String.valueOf(event.getFormCommand().getCommand()) );
				tesJbExePerfLogVO.setExeRowKnt		( event.getTesFileImpTmpVOs()!=null?Integer.toString( (event.getTesFileImpTmpVOs()).length ):"" );
				tesJbExePerfLogVO.setTmlSoOfcCtyCd	( event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd() );
				tesJbExePerfLogVO.setTmlSoSeq		( event.getTesTmlSoHdrVO().getTmlSoSeq() );
				tesJbExePerfLogVO.setJbParaCtnt		( event.getPerfParams() );
			} catch (Exception ex){
				log.error(ex.getMessage());
			}
		}else if(e instanceof EsdTes0012Event){
			EsdTes0012Event event = (EsdTes0012Event)e;
			try {
				String pageURL = event.getPageURL();
				tesJbExePerfLogVO.setInvOfcCd( e.getSignOnUserAccount().getOfc_cd() );
				tesJbExePerfLogVO.setExeUsrId( e.getSignOnUserAccount().getUsr_id() );
				tesJbExePerfLogVO.setJbTpCd( TESCommonBC.PERF_JOB_TYPE_ON_LINE );
				tesJbExePerfLogVO.setPgmUrl( (pageURL!=null&&!pageURL.equals("")?pageURL.trim():JSPUtil.getNull(event.getEventName())) );			
				tesJbExePerfLogVO.setFuncDivCd( String.valueOf(event.getFormCommand().getCommand()) );
				tesJbExePerfLogVO.setJbParaCtnt( event.getPerfParams() );
			} catch (Exception ex){
				log.error(ex.getMessage());
			}
		}
		
		curr_seq = beginJobExecutionPerformance( tesJbExePerfLogVO );

		return curr_seq;
	}
	
	
	/**
	 * searchAuditTerminalInvoiceContainerList
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAuditTerminalInvoiceContainerList(Event e) throws EventException {
		log.debug("START searchAuditTerminalInvoiceContainerList ==========================");
		
		EsdTes0015Event	event = (EsdTes0015Event)e;
		EventResponse		eventResponse 	= null;

		try {
			InvoiceProcessingAuditManageBC command = new InvoiceProcessingAuditManageBCImpl();
			eventResponse = command.searchAuditTerminalInvoiceContainerList(event);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * searchAuditTerminalInvoiceContainerList
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAuditOndockRailChargeContainerList(Event e) throws EventException {
		log.debug("START searchAuditOndockRailChargeContainerList ==========================");
		
		EsdTes0015Event	event = (EsdTes0015Event)e;
		EventResponse		eventResponse 	= null;
		
		try {
			InvoiceProcessingAuditManageBC command = new InvoiceProcessingAuditManageBCImpl();
			eventResponse = command.searchAuditOndockRailChargeContainerList(event);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * searchAuditTerminalInvoiceContainerList
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAuditOffdockCYContainerList(Event e) throws EventException {
		log.debug("START searchAuditOffdockCYContainerList ==========================");
		
		EsdTes0015Event	event = (EsdTes0015Event)e;
		EventResponse		eventResponse 	= null;
		
		try {
			InvoiceProcessingAuditManageBC command = new InvoiceProcessingAuditManageBCImpl();
			eventResponse = command.searchAuditOffdockCYContainerList(event);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * searchAuditTerminalInvoiceContainerList
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAuditStorageContainerList(Event e) throws EventException {
		log.debug("START searchAuditStorageContainerList ==========================");
		
		EsdTes0015Event	event = (EsdTes0015Event)e;
		EventResponse		eventResponse 	= null;
		
		try {
			InvoiceProcessingAuditManageBC command = new InvoiceProcessingAuditManageBCImpl();
			eventResponse = command.searchAuditStorageContainerList(event);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * 9035 팝업화면 searchPortSkdDetailList<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortSkdDetailList(Event e) throws EventException {
		log.debug("START searchPortSkdDetailList ==========================");

		EsdTes9001Event	event			= (EsdTes9001Event)e;
		EventResponse	eventResponse	= null;
		
		try{
			// creating Impl each event  
			MarineTerminalInvoiceManageBCImpl command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchPortSkdDetailList(event);
		}catch(EventException de){
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	
	/**
	 * Terminal Invoice 조회화면 - GST Invoice Summary (India)
	 * @author LimJinYoung
	 */

	/**
	 * 조회 이벤트 처리<br>
	 * marineterminalinvoicemanage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * @param e Event
	 * @return eventResponse  EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTerminalGSTInvoiceSummary(Event e) throws EventException {
		log.debug("*******ServiceProviderInvoiceManageSC : searchTerminalGSTInvoiceSummary********\n");
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0012Event event = (EsdTes0012Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		String curr_seq = null;
		curr_seq = searchCurrSeq(e);
		
		try {
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchTerminalGSTInvoiceSummary(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			/**
			 * 2) DB에 성능LOG에 SC에서의 오류 발생 시각을 남기는 부분
			 */			
			errorJobExecutionPerformance(curr_seq);
//			errorJobExecutionPerformance(currSeq, de.toString());	// Error Remark					
			throw new EventException(de.getMessage());
		}

		/**
		 * 3) DB에 성능LOG에 SC에서의 마침 시각을 남기는 부분
		 */ 
		endJobExecutionPerformance(curr_seq);
		
		return eventResponse;
	}
	
}