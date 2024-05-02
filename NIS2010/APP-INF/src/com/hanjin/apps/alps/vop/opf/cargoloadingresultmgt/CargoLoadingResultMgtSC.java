/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoLoadingResultMgtSC.java
*@FileTitle : TDR Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.07.06 장석현
* 1.0 Creation
* ---------------------------------------------------------------
* History
* 2011.06.29 이준범 [CHM-201111792-01]
* 제 목 : Cargo Handling Performance + RDR CREATION 화면 보완
* 내 용 : 1)Cargo Handling Performance - region Check 로직삭제
*       2) RDR CREATION - Region 선택 칼럼 삭제 요하며, Port 칼럼은 해당 VVD의 Turning port및 Normal Port check하여
*                      해당 Port의 Region의 last Port만 Select Box로 표시될수 있도록 처리 
* 2011.08.24 김민아 [CHM-201113050-01] [VOP-OPF] RDR Inquiry 로직 변경 : RDR이 생성된 region만 보일수 있도록 로직 변경
* 2013.11.25 임옥영 [CHM-201327237] [VOP-OPF] RDR Summary 메뉴 추가 
* 2014.03.14 최덕우 [CHM-201428874] Fleeet Status 신규화면 개발
* 2015.04.21 이병훈 [CHM-201535480] VNOR Report Creation 화면 기능 개선(Remark Submit)
* 2015.05.22 이병훈 [CHM-201535464] VNOR Report Summary Inquiry 개발
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.basic.TCharterIOInvoiceBC;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.basic.TCharterIOInvoiceBCImpl;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.FmsVnorItmVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.FmsVnorVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.basic.RegionDepartureReportBC;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.basic.RegionDepartureReportBCImpl;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.event.VopOpf0045Event;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.event.VopOpf004601Event;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.event.VopOpf004602Event;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.event.VopOpf004603Event;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.event.VopOpf004604Event;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.event.VopOpf004605Event;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.event.VopOpf004606Event;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.event.VopOpf0046Event;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.event.VopOpf0047Event;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRAddSlotVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRAkVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRBbVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRCrtListOptionVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRDgVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRHcVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRListOptionVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRLoadVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRNextPortVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDROverUsedVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRRemarkVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRRfInterPortVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRRfMainTradeVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRSlotReleaseVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRSlotSwapVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRSlotUtilVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRSummaryVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRVslAllocVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRVslMvmtVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RdrCreatInfoVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRSearchRegionLastPortVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.basic.TerminalDepartureReportBC;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.basic.TerminalDepartureReportBCImpl;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0036Event;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0037Event;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0057Event;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0061Event;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0063Event;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0064Event;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0065Event;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0069Event;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0071Event;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0072Event;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0073Event;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0074Event;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0095Event;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf2069Event;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf9036Event;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration.TerminalDepartureReportDBDAO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.CgoHndPerformInputVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.CgoRhndPerformInputVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.DischVolSGTdrVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.FleetStatusVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.MdmRhqComboVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.MissingTDRVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.OpfTdrAtchFileVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.OpfTmlProdRptRsnCdVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.OpfVnorAtchFileVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.OpfVnorSummaryVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.PortLogDetailVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.PortLogHeadVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.RHContainerVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrAllocationBSAVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrDistLoadVolVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrHeaderSkdVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrListOptionVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrSlotHC45VO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrUtilizeSlotPortVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportCondVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TmnlPerformInputVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TmnlPerformVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.VskVslPortSkdSheetVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.basic.OpfUtilBC;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.basic.OpfUtilBCImpl;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.ComComboVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.OpfComboVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ComIntgCdDtlVO;
import com.hanjin.syscommon.common.table.MdmYardVO;
import com.hanjin.syscommon.common.table.OpfRstwgRsnCdVO;
import com.hanjin.syscommon.common.table.OpfVnorEmlStupVO;
import com.hanjin.syscommon.common.table.OpfVnorItmVO;
import com.hanjin.syscommon.common.table.OpfVnorVO;
import com.hanjin.syscommon.common.table.TdrCntrDetailVO;

/**
 * NIS2010-CargoLoadingResultMgt Business Logic ServiceCommand - NIS2010-CargoLoadingResultMgt 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Jang Suk Hyun
 * @see TerminalDepartureReportDBDAO
 * @since J2EE 1.6
 */

public class CargoLoadingResultMgtSC extends ServiceCommandSupport {
	// Login User Information 
	private SignOnUserAccount account = null;

	/**
	 * CargoLoadingResultMgt system 업무 시나리오 선행작업<br>
	 * VOP_OPF_0036업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("CargoLoadingResultMgtSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * CargoLoadingResultMgt system 업무 시나리오 마감작업<br>
	 * VOP_OPF_0036 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("CargoLoadingResultMgtSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-CargoLoadingResultMgt system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {//SEARCHLIST04
				eventResponse = searchTdrHeaderList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) {//SEARCHLIST05
				eventResponse = searchTdrHeaderList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST06)) {//SEARCHLIST06
				eventResponse = searchBkgVolumeDischTotal(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST07)) {//SEARCHLIST07
				eventResponse = searchBkgVolumeDischSG(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST08)) {//SEARCHLIST08
				eventResponse = searchBkgVolumeDischBreak(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST09)) {//SEARCHLIST09
				eventResponse = searchTdrSlotBSAImportList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)) {//SEARCHLIST10
				eventResponse = searchTdrSlotHC45ImportList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)) {//SEARCHLIST11
				eventResponse = searchTdrSlotPortImpList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST12)) {//SEARCHLIST12
				eventResponse = searchTdrSlotDepImportList(e);
			}		
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST13)) {//SEARCHLIST13
				eventResponse = searchTdrRHReasonCdList(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST14)) {//SEARCHLIST14
				eventResponse = searchBkgVolumeLoadTotal(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST15)) {//SEARCHLIST15
				eventResponse = searchBkgVolumeLoadSG(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST16)) {//SEARCHLIST16
				eventResponse = searchBkgVolumeLoadBreak(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTdrSKDList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchTdrPortLogList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchTdrDischargeTotalList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {//Load - Special Cargo - IN
				eventResponse = searchTdrDischargeSGList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchTdrDischargeBreakList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {//LOad - Ocean 상태값만..변경..같이 사용.
				eventResponse = searchTdrLoadOceanPortList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchTdrCodList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchTdrRHList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = searchTdrMisHandleList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchTdrSlotBSAList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchTdrSlotHC45List(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {		//HC/45' 미정인 상태라서. 12번으로...
				eventResponse = searchTdrSlotDepList(e);
			}
 			else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = searchTdrTmpStwgList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {		//HC/45' 미정인 상태라서. 12번으로...
				eventResponse = searchTdrSlotPortList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {//Load - Special Cargo - EX
				eventResponse = searchTdrLoadSGList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {// Rehandling Account Code Check
				eventResponse = checkReHndlAcctCd(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {//LOad - Inter 상태값만..변경..같이 사용.
				eventResponse = searchTdrLoadInterPortList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageTdr(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageTdrCrane(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = manageTdrDisch(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = manageTdrLoad(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = manageTdrCod(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI06)) {
				eventResponse = manageTdrRH(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI07)) {
				eventResponse = manageTdrMishandle(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI08)) {
				eventResponse = manageTdrSlot(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI09)) {
				eventResponse = manageTdrTmpStwg(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI10)) {
				eventResponse = manageTdrRemark(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)){
				eventResponse = searchTdrDischList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)){
				eventResponse = searchTdrLoadList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)){
				eventResponse = searchTdrSlotList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST17)){////SEARCHLIST17
				eventResponse = searchBkgDisch(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf0037Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchExcludeTpr(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageExcludeTpr(e);
			}
		}		
		else if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchComboData(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRDRVSLMvmtList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {
				eventResponse = searchRDRAddSlotHeaderList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRDRAddSlotList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchRDRSlotUtilList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchRDRAKList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchRDRBBList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchRDRHCList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchRDRRFList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchRDRDGList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = searchRDRVSLAllocList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchRDRSlotReleaseList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchRDRSlotSwapList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = searchRDRLoadList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) {
				eventResponse = searchRDRLoadHeaderList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = searchRDROverList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = searchRDRRemarkList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = searchRDRRegionList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf0057Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCgoHndPerformList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {//COMMAND01->SEARCH01
				eventResponse= searchMdmYardCombo(e);
			}			
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf0061Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCgoRhndPerformList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf0063Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTmnlPerformList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {//Open
            	eventResponse = openVopOpf0063(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf0064Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVslConditionList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf0069Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTmnlProdList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {//COMMAND01->SEARCH01
				eventResponse= searchMdmRhqCombo(e);
			}			
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf2069Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTdrDetailList(e);
			}
        }
		/************************1. RDR Creation ******************************/
        else if (e.getEventName().equalsIgnoreCase("VopOpf0046Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { // Header 정보가져오기 
                eventResponse = searchRdrHeader(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { // VVD 별 Last Port 정보 
                eventResponse = searchRegionLastPort(e);
            }else if (e.getFormCommand().isCommand(FormCommand.REMOVELIST)) {//Retrieve Remark
                eventResponse  = removeRdrData(e);
            }
        }
        /**************************1)VSL Mvmt************************************/
        else if (e.getEventName().equalsIgnoreCase("VopOpf004601Event")) {
            
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {//MOVE LIST Retrieve
                eventResponse = searchRDRCrtVSLMvmtList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {//Import Vessel Movement Retrieve
                eventResponse = searchRDRImpVSLMvmtList(e);
            }else  if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {//Save
                eventResponse = manageRDRVSLMvmt(e);
            }else  if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {//REMOVE
                eventResponse = removeRDRVSLMvmt(e);
            }
        }   
		/**************************2)Slot/WGT Util************************************/
        else if (e.getEventName().equalsIgnoreCase("VopOpf004602Event")) {
            
             if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {//SLOT LIST Retrieve
                eventResponse = searchRdrSltWgtUtil(e);
            }else  if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {//Save
                eventResponse = manageRdrSltWgtUtil(e);
            }else  if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {//REMOVE
                eventResponse = removeRdrSltWgtUtil(e);
            }
        } 
        /**************************3)HC45 ************************************/
        else if (e.getEventName().equalsIgnoreCase("VopOpf004603Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {//HC45 LIST Retrieve
                  eventResponse = searchRdrHC45(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {//Import Sub Allocation
                  eventResponse = searchRDRImpHC45(e);
            }else  if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {//Save
                  eventResponse = manageRdrHC45(e);
            }else  if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {//REMOVE
                  eventResponse = removeRdrHC45(e);
            }
        } 
        /**************************4)RF ************************************/
        else if (e.getEventName().equalsIgnoreCase("VopOpf004604Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {//RF LIST Retrieve
                  eventResponse = searchRdrRF(e);
            }else  if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {//Save
                  eventResponse = manageRdrRf(e);
            }else  if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {//REMOVE
                  eventResponse = removeRdrRfAll(e);
            }
        }
        /**************************5)VSL Alloc ************************************/
        else if (e.getEventName().equalsIgnoreCase("VopOpf004605Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {//VSL Alloc LIST Retrieve
                  eventResponse = searchRdrVSLAlloc(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {//MOVE LIST Retrieve
                  eventResponse = searchImpRdrVSLAlloc(e);
            }else  if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {//Save
                  eventResponse = manageRdrVSLAlloc(e);
            }else  if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {//REMOVE
                  eventResponse = removeRdrVSLAllocAll(e);
            }
        }
        /**************************6)Remark ************************************/
        else if (e.getEventName().equalsIgnoreCase("VopOpf004606Event")) {
            
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {//Retrieve Remark
                   eventResponse  = searchRdrHeaderRemark(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {//SAVE
                   eventResponse  = modifyRdrHeaderForRemark(e);
            }else  if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {//REMOVE
                   eventResponse  = removeRdrHeaderForRemark(e);
            }
        }else  if (e.getEventName().equalsIgnoreCase("VopOpf0095Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//Retrieve
            	eventResponse = searchMissingTDRList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {//Port Code Key-in
            	eventResponse = searchChkPort(e);
            }else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {//Open
            	eventResponse = openVopOpf0095(e);
            } 
        }
        /**************** TDR Creation R/H File Attach Pop-Up *******************/
        else if (e.getEventName().equalsIgnoreCase("VopOpf9036Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // SEARCH
				eventResponse = searchOpfTdrAtchFileVO(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // SAVE ( Insert, Update, Delete ) 
				eventResponse = manageOpfTdrAtchFileVO(e);
			}
		}
		
        else if (e.getEventName().equalsIgnoreCase("VopOpf0047Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRDRSummaryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRDRSMRYRegionList(e);
			}
        }
		else if (e.getEventName().equalsIgnoreCase("VopOpf0065Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFleetStatusList(e);
            }
		}
		/**************** Vessel Not Operationally Ready Report *******************/
        else if (e.getEventName().equalsIgnoreCase("VopOpf0071Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
        		eventResponse = searchComComboList(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
        		eventResponse = searchComComboList(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
        		eventResponse = searchComComboList(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {
        		eventResponse = searchComComboList(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) {
        		eventResponse = searchComComboList(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST06)) {
        		eventResponse = searchOffHireTimeList(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST07)) {
        		eventResponse = searchSkdPortList(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST08)) {
        		eventResponse = searchPortOfcCdList(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkVessel(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkVoyNo(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkFromPort(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = checkToPort(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = checkOfficeCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVnor(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = saveVnor(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = submitVnor(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = deleteVnor(e);
			}
        }
		/**************** VNOR File Upload Pop-Up *******************/
        else if (e.getEventName().equalsIgnoreCase("VopOpf0072Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchItemAttachFile(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageOpfVnorAtchFile(e);
			}
        }
		/**************** Vessel Not Operationally Ready Report Summary Inquiry *******************/
        else if (e.getEventName().equalsIgnoreCase("VopOpf0073Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchVnorSummary(e);
        	}
        }
		/**************** VNOR Mail Setup Pop-Up *******************/
        else if (e.getEventName().equalsIgnoreCase("VopOpf0074Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVnorEmlStup(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageVnorEmlStup(e);
			}
        }
		 
		return eventResponse;
	}
	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * TDR Actual Schedule의 Date및 Codition을 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrSKDList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();

		try{
			List<VskVslPortSkdSheetVO> list = command.searchTdrSKDList(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Vessel Schedule"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Vessel Schedule"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * TDR Header 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrHeaderList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrHeaderSkdVO> list = command.searchTdrHeaderList(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05) && list.size() < 1){
				//throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Header"}).getMessage(), ex);
				eventResponse.setUserMessage(new ErrorHandler("OPF00001").getUserMessage());
			}
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Header"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Header"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * 1. TDR Header (Port Log) list를  조회 합니다. <br>
	 * 2. TDR Crane list를  조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrPortLogList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<PortLogHeadVO> list1 = command.searchTdrPortLogHeadList(event.getTerminalDepartureReportCondVO());
			List<PortLogDetailVO> list2 = command.searchTdrPortLogDetailList(event.getTerminalDepartureReportCondVO());
			//eventResponse.setRsVoList(list1);
			
			if(list1 != null && list1.size() > 0){
				PortLogHeadVO temp = list1.get(0);
				
				eventResponse.setETCData("used_crane", temp.getUsedCrane());
				eventResponse.setETCData("avg_gang", temp.getAvgCrane());
				eventResponse.setETCData("gross_work", temp.getGrossWork());
				eventResponse.setETCData("net_work", temp.getNetWork());
				eventResponse.setETCData("lost_time", temp.getLostTime());
				eventResponse.setETCData("gross_gang", temp.getGrossGang());
				eventResponse.setETCData("net_gang", temp.getNetGang());
				eventResponse.setETCData("hatch_handl", temp.getHatchHandl());
				eventResponse.setETCData("gear_handl", temp.getGearHandl());
				eventResponse.setETCData("move_handl", temp.getMoveHandl());
				eventResponse.setETCData("tmnl_gross", temp.getTmnlGross());
 
				eventResponse.setETCData("tmnl_net", temp.getTmnlNet());
				eventResponse.setETCData("per_gang_gross", temp.getPerGangGross());
				eventResponse.setETCData("per_gan_net", temp.getPerGanNet());
				eventResponse.setETCData("commence", temp.getCommence());
				eventResponse.setETCData("complete", temp.getComplete());
			}
			
			eventResponse.setRsVoList(list2);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Port Log"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Port Log"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}

	/**
	 * VOP_OPF_0036 : Import BKG data for ref. <br>
	 * BKG의 Total Vol. list를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgVolumeDischTotal(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrDistLoadVolVO> list = command.searchBkgVolumeDischTotal(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Import BKG"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Import BKG"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}	

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * TDR Total Vol. list를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrDischargeTotalList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrDistLoadVolVO> list = command.searchTdrDischargeTotalList(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Total Vol."}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Total Vol."}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}	

	/**
	 * VOP_OPF_0036 : Import BKG data for ref.<br>
	 * BKG의 SCG Vol. List를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgVolumeDischSG(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<DischVolSGTdrVO> list = command.searchBkgVolumeDischSG(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR SCG Import"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR SCG Import"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}	

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * TDR I-Stowge SCG Vol. list를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrDischargeSGList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<DischVolSGTdrVO> list = command.searchTdrDischargeSGList(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Disch. SCG"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Disch. SCG"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * TDR Alps SCG Vol. list를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrLoadSGList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<DischVolSGTdrVO> list = command.searchTdrLoadSGList(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Load SCG"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Load SCG"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}

	/**
	 * VOP_OPF_0036 : Import BKG data for ref.<br>
	 * BKG의 Break Bulk Vol. List를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgVolumeDischBreak(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrCntrDetailVO> list = command.searchBkgVolumeDischBreak(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Break Bulk Import"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Break Bulk Import"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * TDR Break Bulk list를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrDischargeBreakList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrCntrDetailVO> list = command.searchTdrDischargeBreakList(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Break Bulk"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Break Bulk"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * TDR Load Total list를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrLoadOceanPortList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrDistLoadVolVO> list = command.searchTdrLoadOceanPortList(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Load Total"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Load Total"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0036 : Import BKG data for ref. <br>
	 * BKG의 Load Total Vol. list를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgVolumeLoadTotal(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrDistLoadVolVO> list = command.searchBkgVolumeLoadTotal(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Load Total Import"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Load Total Import"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0036 : Import BKG data for ref. <br>
	 * BKG Load SCG Import List를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgVolumeLoadSG(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<DischVolSGTdrVO> list = command.searchBkgVolumeLoadSG(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Load SCG Import"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Load SCG Import"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0036 : Import BKG data for ref. <br>
	 * BKG Load Break Bulk Import List를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgVolumeLoadBreak(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrCntrDetailVO> list = command.searchBkgVolumeLoadBreak(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Load Break Bulk Import"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Load Break Bulk Import"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}	
	/**
	 * VOP_OPF_0036 : Retrieve<br>
	 * TDR COD List를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrCodList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrCntrDetailVO> list = command.searchTdrCodList(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR COD"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR COD"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}	

	/**
	 * VOP_OPF_0036 : Retrieve<br>
	 * TDR Re Handle List를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrRHList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<RHContainerVO> list = command.searchTdrRHList(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Re Handle"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Re Handle"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}	

	/**
	 * VOP_OPF_0036 : Retrieve<br>
	 * TDR Mis Handle List를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrMisHandleList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrCntrDetailVO> list = command.searchTdrMisHandleList(event.getTerminalDepartureReportConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Mis Handle"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Mis Handle"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}		
	
	/**
	 * VOP_OPF_0036 : Retrieve<br>
	 * TDR Slot Bsa List를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrSlotBSAList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrAllocationBSAVO> list = command.searchTdrSlotBSAList(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Slot Bsa"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Slot Bsa"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0036 : Import BSA & Slot Swap<br>
	 * BSA Slot Bsa List Import를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrSlotBSAImportList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrAllocationBSAVO> list = command.searchTdrSlotBSAImportList(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Slot Bsa Import"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Slot Bsa Import"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}		
		
	/**
	 * VOP_OPF_0036 : Retrieve<br>
	 * TDR Slot HC45 List를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrSlotHC45List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrSlotHC45VO> list = command.searchTdrSlotHC45List(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Slot HC45"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Slot HC45"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0036 : Import Sub Allocation<br>
	 * BSA Slot HC45 List Import를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrSlotHC45ImportList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrSlotHC45VO> list = command.searchTdrSlotHC45ImportList(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Slot HC45 Import"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Slot HC45 Import"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0036 : Retrieve<br>
	 * TDR Slot Depature List를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrSlotDepList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrUtilizeSlotPortVO> list = command.searchTdrSlotDepList(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Slot Depature"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Slot Depature"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}			

	/**
	 * VOP_OPF_0036 : Retrieve<br>
	 * TDR Slot Port List를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrSlotPortList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrUtilizeSlotPortVO> list = command.searchTdrSlotPortList(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Slot Port"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Slot Port"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}			

	/**
	 * VOP_OPF_0036 : Import Load Vol. <br>
	 * TDR Slot Port Import List를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrSlotPortImpList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrUtilizeSlotPortVO> list = command.searchTdrSlotPortImpList(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Slot Port Import"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Slot Port Import"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}			
	

	/**
	 * VOP_OPF_0036 : Import BSA & Slot Swap <br>
	 * TDR Slot Departure Import List를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrSlotDepImportList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrUtilizeSlotPortVO> list = command.searchTdrSlotDepImportList(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Slot Port Import"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Slot Port Import"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}			
	
	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * TDR Temp Stwg List를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrTmpStwgList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrCntrDetailVO> list = command.searchTdrTmpStwgList(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Temp Stwg"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Temp Stwg"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}			
	
	/**
	 * VOP_OPF_0037 : Retrieve <br>
	 * Exclude Tpr List를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExcludeTpr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0037Event event = (VopOpf0037Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<OpfTmlProdRptRsnCdVO> list = command.searchExcludeTpr(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0037Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Exclude Tpr"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Exclude Tpr"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}		
	
	/**
	 * VOP_OPF_0037 : Retrieve <br>
	 * TDR Discharge Multi List를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrDischList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			TerminalDepartureReportCondVO condVo = event.getTerminalDepartureReportCondVO();
			
			condVo.setStatus1("LM");
			condVo.setStatus2("");
			condVo.setScStatus1("DS");
			condVo.setScStatus2("DG");
			condVo.setScStatus3("");
			
			List<TdrDistLoadVolVO> list1 = command.searchTdrDischargeTotalList(condVo);
			List<DischVolSGTdrVO> list2 = command.searchTdrDischargeSGList(condVo);
			List<TdrCntrDetailVO> list3 = command.searchTdrDischargeBreakList(condVo);

			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
			eventResponse.setRsVoList(list3);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0037Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Discharge"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Discharge"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}		
	
	/**
	 * VOP_OPF_0037 : Retrieve <br>
	 * TDR Load Multi List를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrLoadList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			TerminalDepartureReportCondVO condVo = event.getTerminalDepartureReportCondVO();
			
			//Ocean
			condVo.setStatus1("LM");
			condVo.setStatus2("OT");
			List<TdrDistLoadVolVO> list1 = command.searchTdrLoadOceanPortList(condVo);

			//Inter Port
			condVo.setStatus1("LI");
			condVo.setStatus2("LT");
			List<TdrDistLoadVolVO> list2 = command.searchTdrLoadInterPortList(condVo);
			
			//Special Cargo 
			condVo.setScStatus1("LS");
			condVo.setScStatus2("ST");
			
			List<DischVolSGTdrVO> list3 = null;
			if(condVo.getSysCreate().substring(0, 2).toUpperCase().equals("IN"))
				list3 = command.searchTdrDischargeSGList(condVo);
			else
				list3 = command.searchTdrLoadSGList(condVo);

			condVo.setScStatus1("LS");
			condVo.setScStatus2("");
			//Break Bulk 
			List<TdrCntrDetailVO> list4 = command.searchTdrDischargeBreakList(condVo);

			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
			if ( list3 != null ) {
				eventResponse.setRsVoList(list3);
			}
			eventResponse.setRsVoList(list4);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Load"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Load"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	/**
	 * VOP_OPF_0037 : Retrieve <br>
	 * TDR Load Multi List를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrSlotList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			TerminalDepartureReportCondVO condVo = event.getTerminalDepartureReportCondVO();
			
			//BSA
			List<TdrAllocationBSAVO> list1 = command.searchTdrSlotBSAList(condVo);

			//HC/45'
			List<TdrSlotHC45VO> list2 = command.searchTdrSlotHC45List(condVo);

			//Slot(Port)
			condVo.setSlStatus1("OM");
			condVo.setSlStatus2("OI");
			/*condVo.setSlStatus1("SM");
			condVo.setSlStatus2("SI");*/
			List<TdrUtilizeSlotPortVO> list3 = command.searchTdrSlotDepList(condVo);
			
			//Slot(Dep)
			condVo.setSlStatus1("SM");
			condVo.setSlStatus2("SI");
			/*condVo.setSlStatus1("OM");
			condVo.setSlStatus2("OI");*/
			List<TdrUtilizeSlotPortVO> list4 = command.searchTdrSlotPortList(condVo);


			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
			eventResponse.setRsVoList(list3);
			eventResponse.setRsVoList(list4);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Slot"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Slot"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	/**
	 * VOP_OPF_0037 : Import BKG data for ref. <br>
	 * TDR BKG Disch. Multi Import List를 조회 합니다.<br>
	 * (*) 참조사항 : 미사용. 초기에 모든 Import되는 Discharge의 해당하는 
	 * Total/SCG/Break Bulk를 모두 들고 오려하여서.
	 * 다음에 사용할지 몰라서 소스만 남겨둠.  
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgDisch(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			TerminalDepartureReportCondVO condVo = event.getTerminalDepartureReportCondVO();
			
			condVo.setStatus1("");
			List<TdrDistLoadVolVO> list1 = command.searchBkgVolumeDischTotal(condVo);
			eventResponse.setRsVoList(list1);
			
			condVo.setScStatus1("DS");
			condVo.setScStatus2("DG");
			condVo.setScStatus3("");
			List<DischVolSGTdrVO> list2 = command.searchBkgVolumeDischSG(condVo);
			eventResponse.setRsVoList(list2);
			
			List<TdrCntrDetailVO> list3 = command.searchBkgVolumeDischBreak(condVo);
			eventResponse.setRsVoList(list3);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR BKG Disch."}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR BKG Disch."}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	/**
	 * VOP_OPF_0038 : Retrieve <br>
	 * ReHandle Code. Multi Import List를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrRHReasonCdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			
			List<OpfRstwgRsnCdVO> list1 = command.searchTdrRHReasonCdList(event.getOpfRstwgRsnCdVO());
			eventResponse.setRsVoList(list1);
			
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0040Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Re Handle Code"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Re Handle Code"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * Terminal Departure Report Header의 수정내용을 저장 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTdr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			begin();
			command.manageTdr(event.getTdrHeaderVOS(), account);
			String sBTN_DELETE = (String)event.getAttribute("BTN_DELETE");
			
			/**If Use Btn Delete */
			if(sBTN_DELETE.equals("Y")){
			    /**Delete 메세지 */
	            eventResponse.setUserMessage(new ErrorHandler("OPF00008", new String[]{"Data"}).getUserMessage());      			    
			}else{//기존 프로그램이 Save와 Delete 같이 사용함.
	             /**Save 메세지 */
			    eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			}
	
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report Header"}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * VOP_OPF_0036 : Save <br>
	 * TERMINAL DEPARTURE REPORT CRANE의 수정내용을 저장 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTdrCrane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			begin();
			command.manageTdrCrane(event.getTdrHeaderVOS(), event.getPortLogDetailVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report Crane"}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * TERMINAL DEPARTURE REPORT Discharge의 수정내용을 저장 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTdrDisch(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			begin();

			command.manageTdrDischTotal(event.getTdrHeaderVOS(), event.getTdrDistLoadVolVOS(), account);
//            command.modifyTdrHeaderMvs( event.getTdrHeaderVOS(), event.getTerminalDepartureReportCondVO(), account);
			command.manageTdrDischSG   (event.getTdrHeaderVOS(), event.getDischVolSGTdrVOS() , account);
			command.manageTdrDischBreak(event.getTdrHeaderVOS(), event.getTdrCntrDetailVOS() , account);
            command.modifyTdrHeaderMvs( event.getTdrHeaderVOS(), event.getTerminalDepartureReportCondVO(), account);
            command.modifyTdrSAvgGang(event.getTdrHeaderVOS(), account);

			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report Discharge"}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * TERMINAL DEPARTURE REPORT Load의 수정내용을 저장 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTdrLoad(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			begin();

 
			command.manageTdrLoad(event.getTdrHeaderVOS(), event.getTdrDistLoadVolVOS(), account);
//            command.modifyTdrHeaderMvs( event.getTdrHeaderVOS(), event.getTerminalDepartureReportCondVO(), account);
			command.manageTdrLoadSG(event.getTdrHeaderVOS(), event.getDischVolSGTdrVOS(), account);
			command.manageTdrDischBreak(event.getTdrHeaderVOS(), event.getTdrCntrDetailVOS(), account);
            command.modifyTdrHeaderMvs( event.getTdrHeaderVOS(), event.getTerminalDepartureReportCondVO(), account);
            command.modifyTdrSAvgGang(event.getTdrHeaderVOS(), account);

			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report Load"}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * TERMINAL DEPARTURE REPORT Cod의 수정내용을 저장 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTdrCod(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			begin();

			command.manageTdrCod(event.getTdrHeaderVOS(), event.getTdrCntrDetailVOS(), account);

			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report COD"}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * TERMINAL DEPARTURE REPORT REHandle의 수정내용을 저장 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTdrRH(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			begin();

			command.manageTdrRH(event.getTdrHeaderVOS(), event.getTdrCntrDetailVOS(), account);
            command.modifyTdrHeaderMvs( event.getTdrHeaderVOS(), event.getTerminalDepartureReportCondVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report REHandle"}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * TERMINAL DEPARTURE REPORT MisHandle의 수정내용을 저장 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTdrMishandle(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			begin();

			command.manageTdrMishandle(event.getTdrHeaderVOS(), event.getTdrCntrDetailVOS(), account);
            command.modifyTdrHeaderMvs( event.getTdrHeaderVOS(), event.getTerminalDepartureReportCondVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report MisHandle"}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * TERMINAL DEPARTURE REPORT Slot의 수정내용을 저장 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTdrSlot(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			begin();

			command.manageTdrSlotBSA(event.getTdrHeaderVOS(), event.getTdrAllocationVOS(), account);
			command.manageTdrSlotHC45(event.getTdrHeaderVOS(), event.getTdrSlotHC45VO(), account);
			command.manageTdrSlotPort(event.getTdrHeaderVOS(), event.getTdrUtilizeSlotPortVO(), account);
			
			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report Slot"}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * TERMINAL DEPARTURE REPORT TmpStwg의 수정내용을 저장 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTdrTmpStwg(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			begin();

			command.manageTdrTmpStwg(event.getTdrHeaderVOS(), event.getTdrCntrDetailVOS(), account);

			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report TmpStwg"}).getMessage(), ex);
		}
		return eventResponse;
	}

	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * TERMINAL DEPARTURE REPORT Remark의 수정내용을 저장 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTdrRemark(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			begin();

			command.manageTdr(event.getTdrHeaderVOS(), account);

			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report Remark"}).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * VOP_OPF_0037 : Save <br>
	 * OPF TERMINAL DEPARTURE REPORT DETAIL의 수정내용을 저장 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageExcludeTpr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0037Event event = (VopOpf0037Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			command.manageExcludeTpr(event.getOpfTmlProdRptRsnCdVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Opf Terminal Departure Report Detail"}).getMessage(), ex);
		}
		return eventResponse;
	}		
	// VOP_OPF_0045 Start ============================================================//
	/**
	 * VOP_OPF_0045 : Retrieve <br>
	 * 1. RDR Region Combo의 List를 조회 합니다. <br>
	 * 2. RDR Operator Combo의 List를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComboData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0045Event event = (VopOpf0045Event)e;
		
		try{
			// 1. Region Combo List.
			RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
			
//			List<ComIntgCdDtlVO> regionList = command.searchComCodeList("CD02169");
//			StringBuffer data = new StringBuffer();
//			if(regionList != null && regionList.size() > 0){
//				for (int i = 0; i < regionList.size(); i++) {
//					
//					data.append(regionList.get(i).getIntgCdValCtnt()+","+regionList.get(i).getIntgCdValDesc());
//					if (i < regionList.size()-1)
//						data.append("|");
//				}
//			}
//			eventResponse.setETCData("regionList", data.toString());
			

			List<RDRListOptionVO> operatorList = command.searchCarrierList(event.getRDRListOptionVO());
			StringBuffer data02 = new StringBuffer();
			for (int i = 0; i < operatorList.size(); i++) {
				RDRListOptionVO oprVO = operatorList.get(i);
				data02.append(oprVO.getOprCd()+","+oprVO.getOprCd());
				if (i < operatorList.size()-1)
					data02.append("|");
			}
			eventResponse.setETCData("operatorList", data02.toString());
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO Approved Details"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO APVL for Own BKG"}).getMessage(), ex);				
			}
		}		
		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0045 : Retrieve <br>
	 * RDR Move List를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDRVSLMvmtList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0045Event event = (VopOpf0045Event)e;
		RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<RDRNextPortVO> list2 = command.searchRDRNextPortList(event.getRDRListOptionVO());
			
			if(list2 != null && list2.size() > 0){
				RDRNextPortVO tmpVo = list2.get(0);
				
				eventResponse.setETCData("NEXT_PORT" , tmpVo.getNextPort() ==null?"":tmpVo.getNextPort());
				eventResponse.setETCData("ETA"       , tmpVo.getEta()      ==null?"":tmpVo.getEta());
				eventResponse.setETCData("NEXT_CANAL", tmpVo.getNextCanal()==null?"":tmpVo.getNextCanal());
				eventResponse.setETCData("ETA_CANAL" , tmpVo.getEtaCanal() ==null?"":tmpVo.getEtaCanal());
				
				log.error("NEXT_CANAL "+ tmpVo.getNextCanal());
				log.error("ETA_CANAL "+ tmpVo.getEtaCanal());
				
            }else{
            	log.error("NEXT_CANAL Else ");				
                eventResponse.setETCData("NEXT_PORT" ,  "");
                eventResponse.setETCData("ETA"       ,  "");
                eventResponse.setETCData("NEXT_CANAL",  "");
                eventResponse.setETCData("ETA_CANAL" ,  ""); 
            }
			
			List<RDRVslMvmtVO> list = command.searchRDRVSLMvmtList(event.getRDRListOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Move"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Move"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0045 : Retrieve <br>
	 * RDR Add Slot Operator List를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDRAddSlotHeaderList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0045Event event = (VopOpf0045Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			// 1. Region Combo List.
			RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
			
			List<RDRListOptionVO> operatorList = command.searchRDRAddSlotHeaderList(event.getRDRListOptionVO());
			StringBuffer data = new StringBuffer();
			if(operatorList != null && operatorList.size() > 0){
				for (int i = 0; i < operatorList.size(); i++) {
					
					data.append(operatorList.get(i).getOprCd());
					if (i < operatorList.size()-1)
						data.append("|");
				}
			}
			eventResponse.setETCData("operatorList", data.toString());
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Add Slot Operator"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Add Slot Operator"}).getMessage(), ex);				
			}
		}		
		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0045 : Retrieve <br>
	 * RDR Add Slot List를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDRAddSlotList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0045Event event = (VopOpf0045Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RegionDepartureReportBC command = new RegionDepartureReportBCImpl();

		try{
			List<RDRAddSlotVO> list = command.searchRDRAddSlotList(event.getRDRListOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Add Slot"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Add Slot"}).getMessage(), ex);				
			}
		}		

        return eventResponse;
	}
	
	/**
	 * VOP_OPF_0045 : Retrieve <br>
	 * RDR Slot Utilize List를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDRSlotUtilList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0045Event event = (VopOpf0045Event)e;
		RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<RDRSlotUtilVO> list = command.searchRDRSlotUtilList(event.getRDRListOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Slot Utilize"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Slot Utilize"}).getMessage(), ex);				
			}
		}		

		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0045 : Retrieve <br>
	 * RDR Akward List를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDRAKList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0045Event event = (VopOpf0045Event)e;
		RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<RDRAkVO> list = command.searchRDRAKList(event.getRDRListOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Akward"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Akward"}).getMessage(), ex);				
			}
		}		

		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0045 : Retrieve <br>
	 * RDR Break Bulk List를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDRBBList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0045Event event = (VopOpf0045Event)e;
		RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<RDRBbVO> list = command.searchRDRBBList(event.getRDRListOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Break Bulk"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Break Bulk"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0045 : Retrieve <br>
	 * RDR Re Handle List를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDRHCList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0045Event event = (VopOpf0045Event)e;
		RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<RDRHcVO> list = command.searchRDRHCList(event.getRDRListOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Re Handle"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Re Handle"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0045 : Retrieve <br>
	 * RDR Refer List를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDRRFList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0045Event event = (VopOpf0045Event)e;
		RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<RDRRfMainTradeVO> list1 = command.searchRDRRfMainTradeList(event.getRDRListOptionVO());
			List<RDRRfInterPortVO> list2 = command.searchRDRRfInterPortList(event.getRDRListOptionVO());

			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Refer"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Refer"}).getMessage(), ex);				
			}
		}		

        return eventResponse;
	}
	
	/**
	 * VOP_OPF_0045 : Retrieve <br>
	 * RDR Danger Cntr List를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDRDGList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0045Event event = (VopOpf0045Event)e;
		RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<RDRDgVO> list = command.searchRDRDGList(event.getRDRListOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Refer"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Refer"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0045 : Retrieve <br>
	 * RDR Vessel Allocation List를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDRVSLAllocList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0045Event event = (VopOpf0045Event)e;
		RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<RDRVslAllocVO> list = command.searchRDRVSLAllocList(event.getRDRListOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Allocation"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Allocation"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0045 : Retrieve <br>
	 * RDR Slot Realease List를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDRSlotReleaseList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0045Event event = (VopOpf0045Event)e;
		RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<RDRSlotReleaseVO> list = command.searchRDRSlotReleaseList(event.getRDRListOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Slot Realease"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Slot Realease"}).getMessage(), ex);				
			}
		}		

        return eventResponse;
	}
	
	/**
	 * VOP_OPF_0045 : Retrieve <br>
	 * RDR Slot Swap List를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDRSlotSwapList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0045Event event = (VopOpf0045Event)e;
		RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<RDRSlotSwapVO> list = command.searchRDRSlotSwapList(event.getRDRListOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Slot Swap"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Slot Swap"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0045 : Retrieve <br>
	 * RDR Load Header List를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDRLoadHeaderList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0045Event event = (VopOpf0045Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		// 1. Region Combo List.
		RegionDepartureReportBC command = new RegionDepartureReportBCImpl();

		try{
			List<RDRListOptionVO> operatorList = command.searchRDRLoadHeaderList(event.getRDRListOptionVO());
			StringBuffer data = new StringBuffer();
			if(operatorList != null && operatorList.size() > 0){
				for (int i = 0; i < operatorList.size(); i++) {
					
					data.append(operatorList.get(i).getOprCd());
					if (i < operatorList.size()-1)
						data.append("|");
				}
			}
			eventResponse.setETCData("operatorList", data.toString());
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Slot Load Header"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Slot Load Header"}).getMessage(), ex);				
			}
		}		
		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0045 : Retrieve <br>
	 * RDR Load List를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDRLoadList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0045Event event = (VopOpf0045Event)e;
		RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<RDRLoadVO> list = command.searchRDRLoadList(event.getRDRListOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Slot Load"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Slot Load"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0045 : Retrieve <br>
	 * RDR IPC Over Used List를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDROverList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0045Event event = (VopOpf0045Event)e;
		RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<RDROverUsedVO> list = command.searchRDROverList(event.getRDRListOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Slot IPC Over Used"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Slot IPC Over Used"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0045 : Retrieve <br>
	 * RDR Info를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDRRemarkList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0045Event event = (VopOpf0045Event)e;
		RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<RDRRemarkVO> list = command.searchRDRRemarkList(event.getRDRListOptionVO());
			RDRRemarkVO data = new RDRRemarkVO();
			if(list.size()>0){
			     data = list.get(0);
		         eventResponse.setETCData( data.getColumnValues() );
			}
			eventResponse.setRsVoList(list);
 
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Slot Remark"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Slot Remark"}).getMessage(), ex);				
			}
		}		
		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0045 : Retrieve <br>
	 * 1. VVD 에 해당하는 RDR Region Combo의 List를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDRRegionList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0045Event event = (VopOpf0045Event)e;
		
		try{
			// 1. Region Combo List.
			RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
			
			List<ComIntgCdDtlVO> regionList = command.searchRDRRegionList(event.getRDRListOptionVO());
			StringBuffer data = new StringBuffer();
			if(regionList != null && regionList.size() > 0){
				for (int i = 0; i < regionList.size(); i++) {
					
					data.append(regionList.get(i).getIntgCdValCtnt()+","+regionList.get(i).getIntgCdValDesc());
					if (i < regionList.size()-1)
						data.append("|");
				}
			}
			eventResponse.setETCData("regionList", data.toString());
			
			
			
//			RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
//			
//			List<ComIntgCdDtlVO> regionList = command.searchComCodeList("CD02169");
//			StringBuffer data = new StringBuffer();
//			if(regionList != null && regionList.size() > 0){
//				for (int i = 0; i < regionList.size(); i++) {
//					
//					data.append(regionList.get(i).getIntgCdValCtnt()+","+regionList.get(i).getIntgCdValDesc());
//					if (i < regionList.size()-1)
//						data.append("|");
//				}
//			}
//			eventResponse.setETCData("regionList", data.toString());
//			List<RDRListOptionVO> operatorList = command.searchCarrierList(event.getRDRListOptionVO());
//			StringBuffer data02 = new StringBuffer();
//			for (int i = 0; i < operatorList.size(); i++) {
//				RDRListOptionVO oprVO = operatorList.get(i);
//				data02.append(oprVO.getOprCd()+","+oprVO.getOprCd());
//				if (i < operatorList.size()-1)
//					data02.append("|");
//			}
//			eventResponse.setETCData("operatorList", data02.toString());
			
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO Approved Details"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO APVL for Own BKG"}).getMessage(), ex);				
			}
		}		
		
		return eventResponse;
	}
	// VOP_OPF_0045 End ==============================================================//
	
	// VOP_OPF_0057 Start ============================================================//
	/**
	 * VOP_OPF_0057 : Retrieve <br>
	 * Cargo Handling Performance를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCgoHndPerformList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0057Event event = (VopOpf0057Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();

		try{
			List<CgoHndPerformInputVO> list = command.searchCgoHndPerformList(event.getTerminalDepartureReportConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0057Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Cargo Handling Performance"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Cargo Handling Performance"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	} 	

	/**
	 * VOP_OPF_0057 : Retrieve <br>
	 * Yard Combo를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmYardCombo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0057Event event = (VopOpf0057Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
 
		try{
			List<MdmYardVO> list = command.searchMdmYardCombo(event.getTerminalDepartureReportConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0057Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Yard Combo"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Yard Combo"}).getMessage(), ex);				
			}
		}		
		return eventResponse;		
	}
	// VOP_OPF_0057 End ==============================================================//	
	
	// VOP_OPF_0061 Start ============================================================//
	/**
	 * VOP_OPF_0061 : Retrieve <br>
	 * Cargo Handling Performance를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCgoRhndPerformList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0061Event event = (VopOpf0061Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();

		try{
			List<CgoRhndPerformInputVO> list = command.searchCgoRhndPerformList(event.getTerminalDepartureReportConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0061Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Cargo Handling Performance"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Cargo Handling Performance"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}	
	// VOP_OPF_0061 End ==============================================================//
	
	// VOP_OPF_0063 Start ============================================================//
	/**
	 * VOP_OPF_0063 : Retrieve <br>
	 * Terminal Performance - Port / Lane를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTmnlPerformList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0063Event event = (VopOpf0063Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();

		try{
			List<TmnlPerformInputVO> list = command.searchTmnlPerformLaneList(event.getTerminalDepartureReportConditionVO());
			eventResponse.setRsVoList(list);
//			List<TmnlPerformInputVO> list2 = command.searchTmnlPerformPortList(event.getTerminalDepartureReportConditionVO());
//			eventResponse.setRsVoList(list2);			
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0063Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Terminal Performance"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Terminal Performance"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}	
	// VOP_OPF_0063 End ==============================================================//
	
	// VOP_OPF_0064 Start ============================================================//
	/**
	 * VOP_OPF_0064 : Retrieve <br>
	 * Cargo Handling Performance를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVslConditionList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0064Event event = (VopOpf0064Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();

		try{
			List<TdrListOptionVO> list = command.searchVslConditionList(event.getTerminalDepartureReportConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0064Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Cargo Handling Performance"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Cargo Handling Performance"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}	
	// VOP_OPF_0064 End ==============================================================//

	// VOP_OPF_0069 Start ============================================================//
	/**
	 * VOP_OPF_0069 : Retrieve <br>
	 * Cargo Handling Performance를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTmnlProdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0069Event event = (VopOpf0069Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();

		try{
			List<TmnlPerformVO> list = command.searchTmnlProdList(event.getTerminalDepartureReportConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0064Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Cargo Handling Performance"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Cargo Handling Performance"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0069 : Retrieve <br>
	 * RHQ Code를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmRhqCombo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0069Event event = (VopOpf0069Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();

		try{
			List<MdmRhqComboVO> list = command.searchMdmRhqCombo(event.getTerminalDepartureReportConditionVO());
			
			StringBuffer strVal = new StringBuffer();
			StringBuffer strName = new StringBuffer();

			for(int i=0;i<list.size();i++){
				if(i == 0 )
				{
					strVal.append(((MdmRhqComboVO)list.get(i)).getVal());
					strName.append(((MdmRhqComboVO)list.get(i)).getName());
				}
				else
				{
					strVal.append("|" + ((MdmRhqComboVO)list.get(i)).getVal());
					strName.append("|" + ((MdmRhqComboVO)list.get(i)).getName());
				}
			}
	 
			Map<String,String> etcData = new HashMap<String,String>();
			etcData.put("cmbVal", strVal.toString() );
			etcData.put("cmbName", strName.toString() );
			eventResponse.setETCData(etcData);
			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0069Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RHQ Code"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RHQ Code"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
		
	} 	
	
	// VOP_OPF_0069 End ==============================================================//
	
	// VOP_OPF_2069 Start ============================================================//
	/**
	 * VOP_OPF_0069 : Retrieve <br>
	 * Cargo Handling Performance를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf2069Event event = (VopOpf2069Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();

		try{
			List<TerminalDepartureReportVO> list = command.searchTdrDetailList(event.getTerminalDepartureReportConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0069Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Cargo Handling Performance"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Cargo Handling Performance"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}	
	// VOP_OPF_0069 End ==============================================================//	
    /**
     * VOP_OPF_0046_01 : Retrieve <br>
     * RDR Creation Move List를 조회 합니다. <br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchRDRCrtVSLMvmtList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        VopOpf004601Event event = (VopOpf004601Event)e;
        RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try{
  
 
            List<RdrCreatInfoVO> listEta = command.searchRdrHeader( event.getRDRCrtListOptionVO() );
            if(listEta.size() == 0){//헤더 없을경우.
                listEta = command.searchRDRCreNextPortList ( event.getRDRCrtListOptionVO()  );
            }
 
            if(listEta != null && listEta.size() > 0){
                RdrCreatInfoVO tmpVo = listEta.get(0);
                
                eventResponse.setETCData("NEXT_PORT" , tmpVo.getNextPort());
                eventResponse.setETCData("ETA"       , tmpVo.getEta());
                eventResponse.setETCData("NEXT_CANAL", tmpVo.getNextCanal());
                eventResponse.setETCData("ETA_CANAL" , tmpVo.getEtaCanal());
            }else{
                eventResponse.setETCData("NEXT_PORT" ,  "");
                eventResponse.setETCData("ETA"       ,  "");
                eventResponse.setETCData("NEXT_CANAL",  "");
                eventResponse.setETCData("ETA_CANAL" ,  ""); 
            }
            
            List<RDRVslMvmtVO> list = command.searchRDRCrtVSLMvmtList(event.getRDRCrtListOptionVO() );
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Move"}).getMessage(), ex);
        }       
        return eventResponse;
    }
    
    /**
     * VOP_OPF_0046_01 : Import Vessel Movement <br>
     * Vessel Movement정보를 Import하기 위해 조회한다.<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchRDRImpVSLMvmtList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        VopOpf004601Event event = (VopOpf004601Event)e;
        RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try{
            List<RdrCreatInfoVO> list = command.searchRDRImpVSLMvmtList(event.getRDRCrtListOptionVO() );
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Import Move List"}).getMessage(), ex);
        }       
        return eventResponse;
    }
    
    /**
     * VOP_OPF_0046_01 : Save <br>
     * RDR Vessel Movement의 수정내용을 저장 합니다. <br>
     * 
     * @param     Event e
     * @return    EventResponse response
     * @exception EventException
     */
    private EventResponse manageRDRVSLMvmt(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        VopOpf004601Event event = (VopOpf004601Event)e;
        RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
        try{
            begin();
 
            command.manageRDRVSLMvmt(event.getRDRCrtListOptionVO(), event.getRdrCreatInfoVOs(), account);
            eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
            
            commit();
        }catch(EventException ex){
            rollback();
            throw ex;
 
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR Movement Save"}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * VOP_OPF_0046 : Retrieve <br>
     * Port정보와 RdrHeader 정보를 조회한다.<br>
     *
     * @throws EventException 
     * @return EventResponse response
     * @author jang kang cheol
     */
    private EventResponse searchRdrHeader(Event e) throws EventException{
        VopOpf0046Event event = (VopOpf0046Event)e;
        RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try{ 
            List<RdrCreatInfoVO> list  = command.searchRdrHeader(event.getRDRCrtListOptionVO() );
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Header Info"}).getMessage(), ex);    
        }       
        return eventResponse; 
    }
    
 
     /**
      * VOP_OPF_0046_01 : Delete <br>
      * RDR Header정보과 MoveMent 정보를 삭제한다. <br>
      * 
      * @throws EventException 
      * @return EventResponse response
      * @author jang kang cheol
      */
      private EventResponse removeRDRVSLMvmt(Event e) throws EventException{  
          VopOpf004601Event event = (VopOpf004601Event)e;
          RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
          GeneralEventResponse eventResponse = new GeneralEventResponse();
          
          try{
              begin();
   
              command.removeRDRVSLMvmt(  event.getRDRCrtListOptionVO()  );
              eventResponse.setUserMessage(new ErrorHandler("OPF00008", new String[]{"Data"}).getUserMessage());
              
              commit();
          }catch(EventException ex){
              rollback();
              throw ex;
          } catch (Exception ex) {
              log.error("err " + ex.toString(), ex);
              rollback();
              throw new EventException(new ErrorHandler("COM12197", new String[]{"RDR Movement"}).getMessage(), ex);
          }
          return eventResponse;
      }
      /**
       * VOP_OPF_0046_02 : Retrieve <br>
       * RDR Slot/WGT Util 정보를  조회한다. <br>
       * 
       * @throws EventException e 
       * @return EventResponse response
       * @author jang kang cheol
       */
       private EventResponse searchRdrSltWgtUtil(Event e) throws EventException{  
           VopOpf004602Event event = (VopOpf004602Event)e;
           RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
           GeneralEventResponse eventResponse = new GeneralEventResponse();
           
           try{
               List<RdrCreatInfoVO> list = command.searchRdrSltWgtUtil(event.getRDRCrtListOptionVO() );
               eventResponse.setRsVoList(list);
           }catch(EventException ex){
               throw ex;
           } catch (Exception ex) {
               log.error("err " + ex.toString(), ex);
               throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Slot/WGT Util"}).getMessage(), ex);     
           }       
           return eventResponse;
      }
       /**
        * VOP_OPF_0046_02 : Save <br>
        * RDR Slot/WGT Util 정보를  저장 한다. <br>
        * 
        * @throws EventException e 
        * @return EventResponse response
        * @author jang kang cheol
        */
      private EventResponse manageRdrSltWgtUtil(Event e) throws EventException{  
          VopOpf004602Event event = (VopOpf004602Event)e;
          RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
          GeneralEventResponse eventResponse = new GeneralEventResponse();
          
          try{
              begin();
              command.manageRdrSltWgtUtil(event.getRDRCrtListOptionVO(), event.getRdrCreatInfoVOs(), account);
              eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
              this.commit();
          }catch(EventException ex){
              this.rollback();
              throw ex;
          } catch (Exception ex) {
              log.error("err " + ex.toString(), ex);
              this.rollback();
              throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR Slot/WGT Util"}).getMessage(), ex);
          }
          return eventResponse;
      }
      /**
       * VOP_OPF_0046_02 : Delete <br>
       * RDR Utilize 정보를  삭제 한다. <br>
       * 
       * @throws EventException e 
       * @return EventResponse response
       * @author jang kang cheol
       */
     private EventResponse removeRdrSltWgtUtil(Event e) throws EventException{  
         VopOpf004602Event event = (VopOpf004602Event)e;
         RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
         GeneralEventResponse eventResponse = new GeneralEventResponse();
         
         try{
             begin();
             RDRCrtListOptionVO rDRCrtListOptionVO = event.getRDRCrtListOptionVO();
             rDRCrtListOptionVO.setUpdateUser(  this.account.getUsr_id() );
             command.removeRdrSltWgtUtilAll( rDRCrtListOptionVO );
             eventResponse.setUserMessage(new ErrorHandler("OPF00008", new String[]{"Data"}).getUserMessage());
             this.commit();
         }catch(EventException ex){
             this.rollback();
             throw ex;
         } catch (Exception ex) {
             log.error("err " + ex.toString(), ex);
             this.rollback();
             throw new EventException(new ErrorHandler("COM12197", new String[]{"RDR Slot/WGT Util"}).getMessage(), ex);
         }
         return eventResponse;
     }
     /**
      * VOP_OPF_0046_03 : Retrieve <br>
      * RDR HC45 정보를  조회한다. <br>
      * 
      * @throws EventException e 
      * @return EventResponse response
      * @author jang kang cheol
      */
      private EventResponse searchRdrHC45(Event e) throws EventException{  
          VopOpf004603Event event = (VopOpf004603Event)e;
          RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
          GeneralEventResponse eventResponse = new GeneralEventResponse();
          
          try{
              List<RdrCreatInfoVO> list = command.searchRdrHC45(event.getRDRCrtListOptionVO() );
              eventResponse.setRsVoList(list);
          }catch(EventException ex){
              throw ex;
          } catch (Exception ex) {
              log.error("err " + ex.toString(), ex);
              throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR HC45"}).getMessage(), ex);     
          }       
          return eventResponse;
     }
      /**
       * VOP_OPF_0046_03 : Import Retrieve <br>
       * RDR HC45의 Sub Alloction 정보를  조회한다. <br>
       * 
       * @throws EventException e 
       * @return EventResponse response
       * @author jang kang cheol
       */
       private EventResponse searchRDRImpHC45(Event e) throws EventException{  
           VopOpf004603Event event = (VopOpf004603Event)e;
           RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
           GeneralEventResponse eventResponse = new GeneralEventResponse();
           
           try{
               List<RdrCreatInfoVO> list = command.searchRDRImpHC45(event.getRDRCrtListOptionVO() );
               eventResponse.setRsVoList(list);
           }catch(EventException ex){
               throw ex;
           } catch (Exception ex) {
               log.error("err " + ex.toString(), ex);
               throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR HC45"}).getMessage(), ex);     
           }       
           return eventResponse;
      }
      
      /**
       * VOP_OPF_0046_03 : Save <br>
       * RDR HC45 정보를  저장 한다. <br>
       * 
       * @throws EventException e 
       * @return EventResponse response
       * @author jang kang cheol
       */
     private EventResponse manageRdrHC45(Event e) throws EventException{  
         VopOpf004603Event event = (VopOpf004603Event)e;
         RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
         GeneralEventResponse eventResponse = new GeneralEventResponse();
         
         try{
             begin();
             command.manageRdrHC45(event.getRDRCrtListOptionVO(), event.getRdrCreatInfoVOs(), account);
             eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
             this.commit();
         }catch(EventException ex){
             this.rollback();
             throw ex;
         } catch (Exception ex) {
             log.error("err " + ex.toString(), ex);
             this.rollback();
             throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR HC45"}).getMessage(), ex);
         }
         return eventResponse;
     }
     /**
      * VOP_OPF_0046_03 : Delete <br>
      * RDR HC45 정보를  삭제 한다. <br>
      * 
      * @throws EventException e 
      * @return EventResponse response
      * @author jang kang cheol
      */
    private EventResponse removeRdrHC45(Event e) throws EventException{  
        VopOpf004603Event event = (VopOpf004603Event)e;
        RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try{
            begin();
            RDRCrtListOptionVO rDRCrtListOptionVO = event.getRDRCrtListOptionVO();
            rDRCrtListOptionVO.setUpdateUser(  this.account.getUsr_id() );
            command.removeRdrHC45( rDRCrtListOptionVO  );
            eventResponse.setUserMessage(new ErrorHandler("OPF00008", new String[]{"Data"}).getUserMessage());
            this.commit();
        }catch(EventException ex){
            this.rollback();
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            this.rollback();
            throw new EventException(new ErrorHandler("COM12197", new String[]{"RDR HC45"}).getMessage(), ex);
        }
        return eventResponse;
    }
       
    /**
     * VOP_OPF_0046_04 : Retrieve <br>
     * RDR RF 정보를  조회한다. <br>
     * 
     * @throws EventException e 
     * @return EventResponse response
     * @author jang kang cheol
     */
     private EventResponse searchRdrRF(Event e) throws EventException{  
         VopOpf004604Event event = (VopOpf004604Event)e;
         RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
         GeneralEventResponse eventResponse = new GeneralEventResponse();
         
         try{
             List<RdrCreatInfoVO> listMainTrade = command.searchRdrRfListMainTrade(event.getRDRCrtListOptionVO() );
             List<RdrCreatInfoVO> listInterPort = command.searchRdrRfListInterPort(event.getRDRCrtListOptionVO() );
             eventResponse.setRsVoList(listMainTrade);
             eventResponse.setRsVoList(listInterPort);
         }catch(EventException ex){
             throw ex;
         } catch (Exception ex) {
             log.error("err " + ex.toString(), ex);
             throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR RF"}).getMessage(), ex);     
         }       
         return eventResponse;
    }      
     
     /**
      * VOP_OPF_0046_04 : Save <br>
      * RDR RF 정보를  저장 한다. <br>
      * 
      * @throws EventException e 
      * @return EventResponse response
      * @author jang kang cheol
      */
    private EventResponse manageRdrRf(Event e) throws EventException{  
        VopOpf004604Event event = (VopOpf004604Event)e;
        RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try{
            begin();
            command.manageRdrRf(event.getRDRCrtListOptionVO(), event.getRdrCreatInfoMainTradeVOs(), event.getRdrCreatInfoInterPortVOs(), account);
            eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
            this.commit();
        }catch(EventException ex){
            this.rollback();
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            this.rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR RF"}).getMessage(), ex);
        }
        return eventResponse;
    }
    /**
     * VOP_OPF_0046_04 : Delete <br>
     * RF 정보를  삭제 한다. <br>
     * 
     * @throws EventException e 
     * @return EventResponse response
     * @author jang kang cheol
     */
   private EventResponse removeRdrRfAll(Event e) throws EventException{  
       VopOpf004604Event event = (VopOpf004604Event)e;
       RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
       GeneralEventResponse eventResponse = new GeneralEventResponse();
       
       try{
           begin();
           command.removeRdrRfAll(event.getRDRCrtListOptionVO() );
           eventResponse.setUserMessage(new ErrorHandler("OPF00008", new String[]{"Data"}).getUserMessage());
           this.commit();
       }catch(EventException ex){
           this.rollback();
           throw ex;
       } catch (Exception ex) {
           log.error("err " + ex.toString(), ex);
           this.rollback();
           throw new EventException(new ErrorHandler("COM12197", new String[]{"RDR RF"}).getMessage(), ex);
       }
       return eventResponse;
   }
 
   /**
    * VOP_OPF_0046_05 : Retrieve <br>
    * RDR VSL Alloc 정보를  조회한다. <br>
    * 
    * @throws EventException e 
    * @return EventResponse response
    * @author jang kang cheol
    */
    private EventResponse searchRdrVSLAlloc(Event e) throws EventException{  
        VopOpf004605Event event = (VopOpf004605Event)e;
        RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try{
            List<RdrCreatInfoVO> list = command.searchRdrVSLAlloc(event.getRDRCrtListOptionVO() );
            eventResponse.setRsVoList(list);
 
        }catch(EventException ex){
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR VSL Allocation"}).getMessage(), ex);     
        }       
        return eventResponse;
   }
    /**
     * VOP_OPF_0046_05 : Retrieve <br>
     * Import RDR VSL Alloc 정보를  조회한다. <br>
     * 
     * @throws EventException e 
     * @return EventResponse response
     * @author jang kang cheol
     */
    private EventResponse searchImpRdrVSLAlloc(Event e) throws EventException{  
        VopOpf004605Event event = (VopOpf004605Event)e;
        RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try{
            List<RdrCreatInfoVO> list = command.searchImpRdrVSLAlloc(event.getRDRCrtListOptionVO() );
            eventResponse.setRsVoList(list);
 
        }catch(EventException ex){
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Import RDR VSL Allocation"}).getMessage(), ex);     
        }       
        return eventResponse;
   }   
    /**
     * VOP_OPF_0046_04 : Save <br>
     * RDR RF 정보를  저장 한다. <br>
     * 
     * @throws EventException e 
     * @return EventResponse response
     * @author jang kang cheol
     */
   private EventResponse manageRdrVSLAlloc(Event e) throws EventException{  
       VopOpf004605Event event = (VopOpf004605Event)e;
       RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
       GeneralEventResponse eventResponse = new GeneralEventResponse();
       
       try{
           begin();
           command.manageRdrVSLAlloc(event.getRDRCrtListOptionVO(),  event.getRdrCreatInfoVOs() , account);
           eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
           this.commit();
       }catch(EventException ex){
           this.rollback();
           throw ex;
       } catch (Exception ex) {
           log.error("err " + ex.toString(), ex);
           this.rollback();
           throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR VSL Allocation"}).getMessage(), ex);
       }
       return eventResponse;
   }
       /**
        * VOP_OPF_0046_05 : Delete <br>
        * RDR VSL Allocation 정보를  삭제 한다. <br>
        * 
        * @throws EventException e 
        * @return EventResponse response
        * @author jang kang cheol
        */
      private EventResponse removeRdrVSLAllocAll(Event e) throws EventException{  
          VopOpf004605Event event = (VopOpf004605Event)e;
          RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
          GeneralEventResponse eventResponse = new GeneralEventResponse();
          
          try{
              begin();
              command.removeRdrVSLAllocAll(event.getRDRCrtListOptionVO() );
              eventResponse.setUserMessage(new ErrorHandler("OPF00008", new String[]{"Data"}).getUserMessage());
              this.commit();
          }catch(EventException ex){
              this.rollback();
              throw ex;
          } catch (Exception ex) {
              log.error("err " + ex.toString(), ex);
              this.rollback();
              throw new EventException(new ErrorHandler("COM12197", new String[]{"RDR VSL Allocation"}).getMessage(), ex);
          }
          return eventResponse;
      }
      /**
       * VOP_OPF_0046_06 : Save <br>
       * RDR Header의 Remark 정보를  저장 한다. <br>
       * 
       * @throws EventException e 
       * @return EventResponse response
       * @author jang kang cheol
       */
      private EventResponse modifyRdrHeaderForRemark(Event e) throws EventException{  
         VopOpf004606Event event = (VopOpf004606Event)e;
         RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
         GeneralEventResponse eventResponse = new GeneralEventResponse();
         RDRCrtListOptionVO rDRCrtListOptionVO = null;
         try{
             begin();
             rDRCrtListOptionVO = event.getRDRCrtListOptionVO();
             rDRCrtListOptionVO.setUpdateUser(  this.account.getUsr_id()  );
             command.modifyRdrHeaderForRemark(event.getRDRCrtListOptionVO() );
             eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
             this.commit();
         }catch(EventException ex){
             this.rollback();
             throw ex;
         } catch (Exception ex) {
             log.error("err " + ex.toString(), ex);
             this.rollback();
             throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR Remark"}).getMessage(), ex);
         }
         return eventResponse;
      }
      /**
       * VOP_OPF_0046_05 : Retrieve <br>
       * Import RDR VSL Alloc 정보를  조회한다. <br>
       * 
       * @throws EventException e 
       * @return EventResponse response
       * @author jang kang cheol
       */
      private EventResponse searchRdrHeaderRemark(Event e) throws EventException{  
          VopOpf004606Event event = (VopOpf004606Event)e;
          RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
          GeneralEventResponse eventResponse = new GeneralEventResponse();
          
          try{
              List<RdrCreatInfoVO> list = command.searchRdrHeaderRemark(event.getRDRCrtListOptionVO() );
              RdrCreatInfoVO rdrCreatInfoVO = new RdrCreatInfoVO();
              if(list.size()>0){
                  rdrCreatInfoVO = list.get(0);
              }
              eventResponse.setRsVoList( list  );
              eventResponse.setETCData( rdrCreatInfoVO.getColumnValues()  );
    
          }catch(EventException ex){
              throw ex;
          } catch (Exception ex) {
              log.error("err " + ex.toString(), ex);
              throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Remark"}).getMessage(), ex);     
          }       
          return eventResponse;
     }  
      /**
       * VOP_OPF_0046_06 : Delete <br>
       * RDR Header의 Remark 정보를  삭제 한다. <br>
       * 
       * @throws EventException e 
       * @return EventResponse response
       * @author jang kang cheol
       */
      private EventResponse removeRdrHeaderForRemark(Event e) throws EventException{  
         VopOpf004606Event event = (VopOpf004606Event)e;
         RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
         GeneralEventResponse eventResponse = new GeneralEventResponse();
         RDRCrtListOptionVO rDRCrtListOptionVO = null;
         try{
             begin();
             rDRCrtListOptionVO = event.getRDRCrtListOptionVO();
             rDRCrtListOptionVO.setUpdateUser(  this.account.getUsr_id()  );
             
             rDRCrtListOptionVO.setRemark( "" );
             command.modifyRdrHeaderForRemark( rDRCrtListOptionVO );
             eventResponse.setUserMessage(new ErrorHandler("OPF00008", new String[]{"Data"}).getUserMessage());
             this.commit();
         }catch(EventException ex){
             this.rollback();
             throw ex;
         } catch (Exception ex) {
             log.error("err " + ex.toString(), ex);
             this.rollback();
             throw new EventException(new ErrorHandler("COM12197", new String[]{"RDR Remark"}).getMessage(), ex);
         }
         return eventResponse;
      }
      /**
       * VOP_OPF_0046  : Delete <br>
       * RDR Header의 모든 정보를  삭제 한다. <br>
       * 
       * @throws EventException e 
       * @return EventResponse response
       * @author jang kang cheol
       */
      private EventResponse removeRdrData(Event e) throws EventException{  
         VopOpf0046Event event = (VopOpf0046Event)e;
         RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
         GeneralEventResponse eventResponse = new GeneralEventResponse();
         RDRCrtListOptionVO rDRCrtListOptionVO = null;
         try{
             begin();
             rDRCrtListOptionVO = event.getRDRCrtListOptionVO();
             command.removeRdrData( rDRCrtListOptionVO );
             eventResponse.setUserMessage(new ErrorHandler("OPF00008", new String[]{"Data"}).getUserMessage());
             this.commit();
         }catch(EventException ex){
             this.rollback();
             throw ex;
         } catch (Exception ex) {
             log.error("err " + ex.toString(), ex);
             this.rollback();
             throw new EventException(new ErrorHandler("COM12197", new String[]{"RDR Data Remove"}).getMessage(), ex);
         }
         return eventResponse;
      }
      
	/**
	 * VOP_OPF_0095 : Retrieve <br>
	 * Missing TDR List 조회 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMissingTDRList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0095Event event = (VopOpf0095Event) e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try {
			List<MissingTDRVO> list = command.searchMissingTDRList(event.getMissingTDRCondVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Missing TDR List" }).getMessage(), ex);
		}
		return eventResponse;
	}
  
	/**
	 * VOP_OPF_0095 : open <br>
	 * 화면 오픈시 필요한 코드정보를 조회 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse openVopOpf0095(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//VopOpf0095Event event = (VopOpf0095Event) e;
		RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
		OpfUtilBC command1 = new OpfUtilBCImpl();
		try {
			
			String rhqOfcCd = command1.searchRhqOfcCd(account.getOfc_cd());
			eventResponse.setETCData("RHQ_OFC_CD", rhqOfcCd);
			
			List<ComIntgCdDtlVO> list = command.searchComCodeList("CD02773");
			StringBuffer data = new StringBuffer();
			if(list != null){
				data.append(" ,All");
				for (int i = 0; i < list.size(); i++) {
					data.append("|");
					data.append(list.get(i).getIntgCdValCtnt()+","+list.get(i).getIntgCdValDpDesc());
//					
//					if (i < list.size() -1){
//						data.append("|");
//					}
				}
			}
			eventResponse.setETCData("tdrList", data.toString());
			
			list = command.searchComCodeList("CD02774");
			data = new StringBuffer();
			if(list != null){
				data.append(" ,All");
				for (int i = 0; i < list.size(); i++) {
					data.append("|");
					data.append(list.get(i).getIntgCdValCtnt()+","+list.get(i).getIntgCdValDpDesc());
				}
			}
			eventResponse.setETCData("svcList", data.toString());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Missing TDR List" }).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * VOP_OPF_0095 화면 : Port Code OnBlur
	 * Port Code Key-in 시 validation check
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchChkPort(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0095Event event = (VopOpf0095Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
 
		try{
			List<MissingTDRVO> list = command.searchPortCodeNRhqOfcCdList(event.getMissingTDRCondVO());
			
			String portCd   = "";
			String rhqOfcCd = "";
			if (!list.isEmpty()){
				portCd   = list.get(0).getPortCd  ();
				rhqOfcCd = list.get(0).getRhqOfcCd();
			}
			eventResponse.setETCData("PORT_CD"   , portCd);
			eventResponse.setETCData("RHQ_OFC_CD", rhqOfcCd);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Yard Combo"}).getMessage(), ex);
		}		
		return eventResponse;		
	}

	/**
	 * VOP_OPF_0063 : open <br>
	 * 화면 오픈시 필요한 코드정보를 조회 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse openVopOpf0063(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		OpfUtilBC command1 = new OpfUtilBCImpl();
		try {
			String rhqOfcCd = command1.searchRhqOfcCd(account.getOfc_cd());
			eventResponse.setETCData("RHQ_OFC_CD", rhqOfcCd);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Terminal Performance Open" }).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Rehandling Account ( Carrier ) Code 의 유효성을 [조회] 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkReHndlAcctCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<OpfComboVO> list = command.checkReHndlAcctCd(event.getTdrCntrDetailVOS()[0]);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Check Carrier"}).getMessage(), ex);
		}		
		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * TDR Load Inter Port list를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrLoadInterPortList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrDistLoadVolVO> list = command.searchTdrLoadInterPortList(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Load Inter Port"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Load Inter Port"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0046 : Port <br>
	 * RDR Creation 화면 VVD 별 Last Port를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRegionLastPort(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0046Event event = (VopOpf0046Event)e;
		RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
		try{
			List<RDRSearchRegionLastPortVO> list = command.searchRegionLastPort(event.getRDRCrtListOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Load Inter Port"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Load Inter Port"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_9036 : SEARCH <br>
	 * TDR R/H 의 File Attached 건을 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOpfTdrAtchFileVO(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf9036Event event = (VopOpf9036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();

		try{
			List<OpfTdrAtchFileVO> list = command.searchOpfTdrAtchFileVO(event.getOpfTdrAtchFileVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	/**
	 * VOP_OPF_9036 : MULTI <br>
	 * TDR R/H 의 File Attached 건을 생성, 수정 및 삭제합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageOpfTdrAtchFileVO(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf9036Event event = (VopOpf9036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			begin();
			command.manageOpfTdrAtchFileVO(event.getOpfTdrAtchFileVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * VOP_OPF_0047 : Retrieve <br>
	 * 1. VVD 에 해당하는 Region Combo의 List를 조회 합니다. <br>
	 * VOP_OPF_0045의 BC Method 재사용
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDRSMRYRegionList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0047Event event = (VopOpf0047Event)e;
		
		try{
			// 1. Region Combo List.
			RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
			
			List<ComIntgCdDtlVO> regionList = command.searchRDRRegionList(event.getRDRListOptionVO());
			StringBuffer data = new StringBuffer();
			if(regionList != null && regionList.size() > 0){
				for (int i = 0; i < regionList.size(); i++) {
					
					data.append(regionList.get(i).getIntgCdValCtnt()+","+regionList.get(i).getIntgCdValDesc());
					if (i < regionList.size()-1)
						data.append("|");
				}
			}
			eventResponse.setETCData("regionList", data.toString());		
		} catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0047Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Region Code"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Region Code"}).getMessage(), ex);				
			}
		}		
		
		return eventResponse;
	}
	/**
	 * VOP_OPF_0047 : Retrieve <br>
	 * RDRSummary List를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDRSummaryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0047Event event = (VopOpf0047Event)e;
		RegionDepartureReportBC command = new RegionDepartureReportBCImpl();

		try{
			List<RDRSummaryVO> list = command.searchRDRSummaryList(event.getRDRSummaryVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0065 : Retrieve <br>
	 * Fleet Status을 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFleetStatusList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0065Event event = (VopOpf0065Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();

		try{
			List<FleetStatusVO> list = command.searchFleetStatusList(event.getFleetStatusVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0065Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Fleet Status"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Fleet Status"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0071 : SEARCHLIST01 & SEARCHLIST02 & SEARCHLIST03<br>
	 * 콤보리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComComboList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0071Event event = (VopOpf0071Event) e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		
		try {
			List<ComComboVO> list = command.searchComComboList(event.getComComboVO());
			eventResponse.setRsVoList(list);
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Code List" }).getMessage(), eex);
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0071 : SEARCHLIST04<br>
	 * 해당 Vessel의 Off-Hire Time List를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffHireTimeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0071Event event = (VopOpf0071Event) e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		
		try {
			OpfVnorVO opfVnorVO = event.getOpfVnorVO();
			List<ComComboVO> list = command.searchOffHireTimeList(opfVnorVO.getVslCd());
			eventResponse.setRsVoList(list);
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Off-Hire Time List" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0071 : SEARCHLIST07<br>
	 * 해당 Vessel / Voy No 의 SKD Port List를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSkdPortList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0071Event event = (VopOpf0071Event) e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		
		try {
			OpfVnorVO opfVnorVO = event.getOpfVnorVO();
			List<ComComboVO> list = command.searchSkdPortList(opfVnorVO);
			eventResponse.setRsVoList(list);
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "SKD Port List" }).getMessage(), eex);
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	private EventResponse searchPortOfcCdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0071Event event = (VopOpf0071Event) e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		
		try {
			OpfVnorVO opfVnorVO = event.getOpfVnorVO();
			List<ComComboVO> list = command.searchPortOfcCdList(opfVnorVO);
			eventResponse.setRsVoList(list);
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "SKD Port List" }).getMessage(), eex);
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0071 : SEARCH01<br>
	 * 유효한 Vessel Code 인지 체크한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkVessel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		VopOpf0071Event event = (VopOpf0071Event)e;
		try {
			OpfVnorVO opfVnorVO = event.getOpfVnorVO();
			String isVslOk = command.checkVessel(opfVnorVO.getVslCd());
			eventResponse.setETCData("is_vsl_ok", isVslOk);
		} catch(EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0071 : SEARCH02<br>
	 * 유효한 Voyage No 인지 체크한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkVoyNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		VopOpf0071Event event = (VopOpf0071Event)e;
		try {
			OpfVnorVO opfVnorVO = event.getOpfVnorVO();
			
			// Voyage No Check만을 위해 From Port & To Port 정보는 삭제
			opfVnorVO.setVnorFmPortCd("");
			opfVnorVO.setVnorToPortCd("");
			
			String isVslOk = command.checkVskSkd(opfVnorVO);
			eventResponse.setETCData("is_vsl_ok", isVslOk);
		} catch(EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0071 : SEARCH03<br>
	 * 유효한 Port (From) 인지 체크한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkFromPort(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		VopOpf0071Event event = (VopOpf0071Event)e;
		try {
			OpfVnorVO opfVnorVO = event.getOpfVnorVO();
			
			// From Port Check만을 위해 To Port 정보는 삭제
			opfVnorVO.setVnorToPortCd("");
			
			String isVslOk = command.checkVskSkd(opfVnorVO);
			eventResponse.setETCData("is_vsl_ok", isVslOk);
		} catch(EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0071 : SEARCH04<br>
	 * 유효한 Port (From) 인지 체크한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkToPort(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		VopOpf0071Event event = (VopOpf0071Event)e;
		try {
			OpfVnorVO opfVnorVO = event.getOpfVnorVO();
			
			// From Port Check만을 위해 From Port 정보는 삭제
			opfVnorVO.setVnorFmPortCd("");
			
			String isVslOk = command.checkVskSkd(opfVnorVO);
			eventResponse.setETCData("is_vsl_ok", isVslOk);
		} catch(EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0071 : SEARCH05<br>
	 * 유효한 Office Code 인지 체크한다.<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse checkOfficeCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		VopOpf0071Event event = (VopOpf0071Event)e;
		try {
			String isOk = command.checkOfficeCode(event.getOfcCd());
			eventResponse.setETCData("IS_OK", isOk);
		} catch(EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0071 : SEARCH<br>
	 * Vessel Not Operationally Ready Report 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVnor(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		VopOpf0071Event event = (VopOpf0071Event)e;
		List<OpfVnorItmVO> mainItmList = new ArrayList<OpfVnorItmVO>();
		List<OpfVnorItmVO> subItmList = new ArrayList<OpfVnorItmVO>();
		try {
			OpfVnorVO opfVnorVO = command.searchVnor(event.getOpfVnorVO());
			List<OpfVnorItmVO> itmList = command.searchVnorItm(event.getOpfVnorVO());
			
			// 헤더 정보 셋팅
			if (opfVnorVO != null) {
				eventResponse.setETCData("vsl_cd", opfVnorVO.getVslCd());
				eventResponse.setETCData("vnor_seq", opfVnorVO.getVnorSeq());
				eventResponse.setETCData("vnor_offh_fm_dt", opfVnorVO.getVnorOffhFmDt());
				eventResponse.setETCData("vnor_offh_to_dt", opfVnorVO.getVnorOffhToDt());
				eventResponse.setETCData("cr_chk_flg", opfVnorVO.getCrChkFlg());
				eventResponse.setETCData("skd_voy_no", opfVnorVO.getSkdVoyNo() + opfVnorVO.getSkdDirCd());
				eventResponse.setETCData("vnor_vsl_sts_cd", opfVnorVO.getVnorVslStsCd());
				eventResponse.setETCData("vnor_fm_port_cd", opfVnorVO.getVnorFmPortCd());
				eventResponse.setETCData("vnor_to_port_cd", opfVnorVO.getVnorToPortCd());
				eventResponse.setETCData("vnor_stup_sts_cd", opfVnorVO.getVnorStupStsCd());
				eventResponse.setETCData("vnor_offh_knd_cd", opfVnorVO.getVnorOffhKndCd());
				eventResponse.setETCData("vnor_offh_tp_cd", opfVnorVO.getVnorOffhTpCd());
				eventResponse.setETCData("vnor_rmk", opfVnorVO.getVnorRmk());
				eventResponse.setETCData("eml_snd_no", opfVnorVO.getEmlSndNo());
			}
			
			// Main Item List 셋팅
			if (itmList.size() > 0) {
				mainItmList.addAll(itmList.subList(0, 1));
			}
			
			// Sub Item List 셋팅
			if (itmList.size() > 1) {
				subItmList.addAll(itmList.subList(1, itmList.size()));
			}
			
			eventResponse.setRsVoList(mainItmList);
			eventResponse.setRsVoList(subItmList);
			
		} catch(EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0071 : COMMAND01 <br>
	 * Vessel Not Operationally Ready Report 수정한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse saveVnor(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0071Event event = (VopOpf0071Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		String isVslOk = "Y";
		try{
			OpfVnorVO OpfVnorVO = event.getOpfVnorVO();
			OpfVnorItmVO[] opfVnorItmVOs = event.getOpfVnorItmVOs();
			if ("".equals(OpfVnorVO.getVnorStupStsCd())) {
				isVslOk = command.checkDupOffHireTime(OpfVnorVO);
			}
			
			if ("Y".equals(isVslOk)) {
				begin();
				command.saveVnor(OpfVnorVO, opfVnorItmVOs, account);
				commit();
			}
			eventResponse.setETCData("VNOR_SEQ", OpfVnorVO.getVnorSeq());
			eventResponse.setETCData("IS_OK", isVslOk);
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0071 : COMMAND02 <br>
	 * Vessel Not Operationally Ready Report Submit한다.<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse submitVnor(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0071Event event = (VopOpf0071Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		TCharterIOInvoiceBC command2 = new TCharterIOInvoiceBCImpl();
		
		try{
			OpfVnorVO opfVnorVO = event.getOpfVnorVO();
			FmsVnorVO fmsVnorVO = event.getFmsVnorVO();
			OpfVnorItmVO[] opfVnorItmVOs = event.getOpfVnorItmVOs();
			FmsVnorItmVO[] fmsVnorItmVOs = event.getFmsVnorItmVOs();
			String vnorStupStsCd = opfVnorVO.getVnorStupStsCd();
			
			// E-mail Send
			if (opfVnorItmVOs != null) {
				String emlSndNo = command.sendVnorEmail(opfVnorVO, opfVnorItmVOs, account);
				opfVnorVO.setEmlSndNo(emlSndNo);
			}
			
			begin();
			
			// OPF Data Update & Insert
			command.submitVnor(opfVnorVO, opfVnorItmVOs, account);
			
			// 사선/용선 체크
			String vslOwnIndCd = command.getVslOwnIndCd(opfVnorVO.getVslCd());
			
			// 용선일 경우에만 FMS로 Interface 한다.
			if ("C".equals(vslOwnIndCd)) {
				// FMS Data Inserface
				String vslCd = opfVnorVO.getVslCd();
				String fmsVnorOffhFmDt = opfVnorVO.getVnorOffhFmDt().replace(".", "").replace(":", "");
				String fmsVnorOffhToDt = opfVnorVO.getVnorOffhToDt().replace(".", "").replace(":", "");
				String crChkFlg = opfVnorVO.getCrChkFlg();
				
				int fmsVnorSeq = command2.searchVnorSeq(vslCd, fmsVnorOffhFmDt, fmsVnorOffhToDt, crChkFlg);
				int fmsVnorItmSeq = command2.searchVnorItmSeq(vslCd, fmsVnorOffhFmDt, fmsVnorOffhToDt, crChkFlg);
				String fmsVnorSeqStr = String.valueOf(fmsVnorSeq);
				
				if ("SA".equals(vnorStupStsCd)) {
					fmsVnorVO.setVnorSeq(fmsVnorSeqStr);
					fmsVnorVO.setVnorOffhFmDt(fmsVnorOffhFmDt);
					fmsVnorVO.setVnorOffhToDt(fmsVnorOffhToDt);
					fmsVnorVO.setSkdVoyNo(opfVnorVO.getSkdVoyNo().substring(0, 4));
					fmsVnorVO.setSkdDirCd(opfVnorVO.getSkdVoyNo().substring(4, 5));
					fmsVnorVO.setCreUsrId(account.getUsr_id());
					fmsVnorVO.setUpdUsrId(account.getUsr_id());
					command2.addFmsVnor(fmsVnorVO);
				}
				
				if (fmsVnorItmVOs != null) {
					for (int i = 0; i < fmsVnorItmVOs.length; i++) {
						int atchFileKnt = Integer.parseInt(opfVnorItmVOs[i].getAtchFileKnt());
						fmsVnorItmVOs[i].setVslCd(opfVnorVO.getVslCd());
						fmsVnorItmVOs[i].setVnorSeq(fmsVnorSeqStr);
						fmsVnorItmVOs[i].setVnorItmSeq(String.valueOf(i+fmsVnorItmSeq));
						fmsVnorItmVOs[i].setAtchFileOpLnkId(opfVnorItmVOs[i].getAtchFileLnkId());
						fmsVnorItmVOs[i].setAtchFileOpKnt(opfVnorItmVOs[i].getAtchFileKnt());
						fmsVnorItmVOs[i].setVnorItmFletAddCd("O");
						fmsVnorItmVOs[i].setInvSeq(opfVnorItmVOs[i].getVnorSeq());
						fmsVnorItmVOs[i].setInvDtlSeq(opfVnorItmVOs[i].getVnorItmSeq());
						if (atchFileKnt == 0) {
							fmsVnorItmVOs[i].setVnorItmProcCd("N");
						} else {
							fmsVnorItmVOs[i].setVnorItmProcCd("C");
						}
						fmsVnorItmVOs[i].setCreUsrId(account.getUsr_id());
						fmsVnorItmVOs[i].setUpdUsrId(account.getUsr_id());
						command2.addFmsVnorItm(fmsVnorItmVOs[i]);
					}
				}
			}
			
			commit();
			
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0071 : COMMAND03 <br>
	 * Vessel Not Operationally Ready Report 삭제한다.<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse deleteVnor(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0071Event event = (VopOpf0071Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			begin();
			command.deleteVnor(event.getOpfVnorVO());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0072 : SEARCH<br>
	 * Item Attach File을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchItemAttachFile(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0072Event event = (VopOpf0072Event) e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		
		try {
			List<OpfVnorAtchFileVO> list = command.searchItemAttachFile(event.getOpfAtchFileVO());
			eventResponse.setRsVoList(list);
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Item Attach File List" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0072 : MULTI <br>
	 * VNOR 의 File Attached 건을 생성, 수정 및 삭제합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageOpfVnorAtchFile(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0072Event event = (VopOpf0072Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			begin();
			command.manageOpfVnorAtchFile(event.getOpfAtchFileVOs(), account);
			command.updateVnorItemAttachFile(event.getVslCd(), event.getVnorSeq(), event.getVnorItmSeq(), event.getAtchFileLnkId());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0074 : SEARCH<br>
	 * VNOR Email Setup을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVnorEmlStup(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		
		try {
			List<OpfVnorEmlStupVO> list = command.searchVnorEmlStup();
			eventResponse.setRsVoList(list);
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "VNOR Email Setup List" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0074 : MULTI <br>
	 * VNOR Email Setup 생성 및 삭제합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageVnorEmlStup(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0074Event event = (VopOpf0074Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			begin();
			command.manageVnorEmlStup(event.getOpfVnorEmlStupVOs(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0073 : SEARCH <br>
	 * VNOR Summary Inquiry 조회합니다.<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchVnorSummary(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0073Event event = (VopOpf0073Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<OpfVnorSummaryVO> list = command.searchVnorSummary(event.getOpfVnorSummaryVO());
			eventResponse.setRsVoList(list);
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "VNOR Summary" }).getMessage(), eex);
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
}
