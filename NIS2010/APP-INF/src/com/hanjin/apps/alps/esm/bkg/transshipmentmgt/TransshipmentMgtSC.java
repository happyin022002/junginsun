/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TransshipmentMgtSC.java
*@FileTitle : VVD Discharging Yard
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.05.18 최영희
* 1.0 Creation
* ------------------------------------------------------
* HISTORY
* 2011.01.13 이일민 [CHM-201006824] VVD 변경시 Loew's 에 customer 301 전송
* 2011.07.05 이일민 [CHM-201111757-01] [Special Cargo:Request로직] Group VVD assign, Next VVD Assign통한 자동 재승인요청
* 2011.07.13 이일민 [CHM-201111757-01] [Special Cargo:Request로직] Group VVD assign, Next VVD Assign통한 자동 재승인요청 - null오류수정
* 2011.07.14 김진승 [CHM-201111820] Split 03-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치
* 2012.01.09 금병주 [CHM-201115389-01] bkg 화면에 Port skip일 경우 표기 요청
* 2012.01.27 김경섭 [CHM-201115348] [BKG] T/S 화물 Transit Time 조회/분석 report 신규개발 
* 2012.06.27 전성진 [] PRD 호출 파라미터 표시 제거
* 2012.12.20 조정민 [CHM-201221841] Booking Confirmation F/File 발송 조건 추가
* 2013.02.13 류대영 [CHM-201322260] T/S 화물에 대한 CLL 마감 이후 CLOSING 기능 의뢰 (2)
* 2013.02.14 류대영 [CHM-201322845] [NEXT VVD Assign] VVD assign시 POD Yard 정보 로직 변경
* 2014.04.07 조인영 [CHM-201429635] NMC ( Non-Manipulation Certificate) Form 개발 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.transshipmentmgt;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.basic.CIMCommonBC;
import com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.basic.CIMCommonBCImpl;
import com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.vo.TypeSizeSequenceVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBC;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBCImpl;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBC;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBCImpl;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.UpdBkgForBkgCodVO;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.UpdBkgForVVDChgVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryLineVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryTableVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.CustTpIdVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.PrdMainInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.PrdParameterVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BdrSpclVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingCreationVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.OldBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.OldNewVvdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VvdAssignVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.basic.SpecialCargoReceiptBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.basic.SpecialCargoReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SpclCgoAproApplVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.basic.CODCorrectionBC;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.basic.CODCorrectionBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.CodEtcVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingMasterMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingMasterMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.basic.TransshipmentMgtBC;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.basic.TransshipmentMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0387Event;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0495Event;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0496Event;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0499Event;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0580Event;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0581Event;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0898Event;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0903Event;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0924Event;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0925Event;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0950Event;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg1157Event;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg1174Event;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.integration.TransshipmentMgtDBDAO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgListForPortAssignVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgRouteForPortAssignVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgTsCoffTmVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.FormerVvdVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.NextVvdVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.RlyVslGrpAssignVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSListBy1st2ndVVDListVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSRemainSumVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSRemianListVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSSummaryVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSTimeRptVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VslDischargingVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VslOopVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VvdAssignTargetBkgVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VvdAssignTargetListVO;
//import com.hanjin.apps.alps.esm.coa.stdunitcost.costassign.basic.CostAssignBC;
//import com.hanjin.apps.alps.esm.coa.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBC;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.basic.OwnDangerousCargoApprovalBC;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.basic.OwnDangerousCargoApprovalBCImpl;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionInputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionOutputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionPortVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionVesselOperatorVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.basic.PartnerLinesDangerousCargoApprovalBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
import com.hanjin.syscommon.common.table.BkgTsRmkVO;
import com.hanjin.syscommon.common.table.BkgVvdVO;
//import com.hanjin.syscommon.common.table.CoaBkgComIfVO;
import com.hanjin.syscommon.common.table.MasBkgComIfVO;
import com.hanjin.syscommon.common.table.ScgAproRqstVO;
import com.hanjin.syscommon.common.table.ScgVvdAproRqstVO;

/**
 * NIS2010-TransshipmentMgt Business Logic ServiceCommand - NIS2010-TransshipmentMgt 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Choi Yeoung Hee
 * @see TransshipmentMgtDBDAO
 * @since J2EE 1.4
 */
public class TransshipmentMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * TransshipmentMgt system 업무 시나리오 선행작업<br>
	 * ESM_BKG-0580업무 시나리오 호출시 관련 내부객체 생성<br>
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
	 * TransshipmentMgt system 업무 시나리오 마감작업<br>
	 * ESM_BKG-0580 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("TransshipmentMgtSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-TransshipmentMgt system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return  EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmBkg0580Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVslDischarging(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageVslDischarging(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0581Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVslOopMatch(e); 
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageVslOopMatch(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageOopCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0496Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTSRemainList(e);
			} 
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0924Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTSRemainSumByLoc(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0495Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTSListBy1st2ndVVDList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchTSVvdFor1st2nd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = sendTsListByFax(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = sendTsListByEmail(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse = sendTsListByFax(e);
				eventResponse = sendTsListByEmail(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND05)) {
				eventResponse=searchLoginLoc(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0925Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTSSummary(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0950Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRlyVslGrpAssign(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse=modifyOceanRoute(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse=searchLoginLoc(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0903Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTSRemark(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse=manageTSRemark(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0387Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFormerVvdForAssign(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse=searchTargetForAssign(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse=searchNextVvdForAssign(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND03) ||e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse=modifyOceanRoute(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND05)) {
				eventResponse=searchLoginLoc(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0499Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTSTimeRptSmry(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTSTimeRptDtl(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchPortTurnTimeVVDList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchTPSZSequenceList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0898Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBkgRouteForPortAssign(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse=searchBkgListForPortAssign(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse=searchBkgVvdForVvdPortAssign(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse=modifyOceanRoute(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse=sendBkgVslReviseNotice(e);
			}  
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg1157Event")) {
		    if(e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
                eventResponse = searchClzStatus(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTsBkgCoffTm(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = closeTsBkgForBayPlan(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = reopenTsBkgForBayPlan(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkTsCloseByBayPlan(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg1174Event")) {
		    if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchNmc(e);
			}
		}  		
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0581:btn_retrieve<br>
	 * t/s port에서 vsl oop match 정보를 조회한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVslOopMatch(Event e) throws EventException {
		try{
			EsmBkg0581Event event = (EsmBkg0581Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();
			VslOopVO vslOopVO = command.searchVslOopMatch(event.getVslOopInputVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(vslOopVO.getVslOopInqVO());
			eventResponse.setRsVoList(vslOopVO.getBkgVslOpCrrCdVO());
			if (vslOopVO.getVslOopInqVO().isEmpty() && vslOopVO.getBkgVslOpCrrCdVO().isEmpty())
			eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_0581:btn_save<br>
	 * vsl oop match 정보를 저장한다.<br>
	 *  
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageVslOopMatch(Event e) throws EventException {		
		try{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmBkg0581Event event = (EsmBkg0581Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();
			begin();
			command.manageVslOopMatch(event.getBkgVslOopVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			rollback();
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}		
	}	
	
	/**
	 * ESM_BKG_0581:btn_save2<br>
	 * oop code를 저장한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageOopCode(Event e) throws EventException {
		try{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmBkg0581Event event = (EsmBkg0581Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();
			begin();
			command.manageOopCode(event.getBkgVslOpCrrCdVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			rollback();
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}		
	}
	
	/**
	 * ESM_BKG_0580:btn_retrieve<br>
	 * Port 별로 입항하는 VVD의 port와 터미널 코드 및 CRN No, UVI No를 조회한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVslDischarging(Event e) throws EventException {
		try{
			EsmBkg0580Event event = (EsmBkg0580Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();
			VslDischargingVO vslDischargingVO = command.searchVslDischarging(event.getbkgVslDchgYdInputVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(vslDischargingVO.getVslDchgYdListVO());
			eventResponse.setRsVoList(vslDischargingVO.getMdmYardVO());
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_0580:btn_save<br>
	 * Port 별로 입항하는 VVD의 port와 터미널 코드 및 CRN No, UVI No를 저장한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageVslDischarging(Event e) throws EventException {
		try{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmBkg0580Event event = (EsmBkg0580Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();
			begin();
			command.manageVslDischarging(event.getbkgVslDchgYdVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			rollback();
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}		
	}
	
	/**
	 * ESM_BKG_0496:btn_retrieve<br>
	 * t/s port에서 next vessel이 재지정 되지 않고 port에 머물러 있는 booking들을 조회한다.<br>
     * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTSRemainList(Event e) throws EventException {
		try{
			EsmBkg0496Event event = (EsmBkg0496Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();
			List<TSRemianListVO> list = command.searchTSRemainList(event.getTSRemainListInputVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list); 
			if (list.isEmpty())
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_0924:loadPage<br>
	 * 전달받은 location에 전달받은 날짜를 기준으로 cnmv_sts_cd가 'TS', 'TN'인 container들을<br>
     * type/size, cargo type별로 합계를 내서 조회한다.<br>
     * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTSRemainSumByLoc(Event e) throws EventException {
		try{
			EsmBkg0924Event event = (EsmBkg0924Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();  
			List<TSRemainSumVO> list = command.searchTSRemainSumByLoc(event.getTSRemainListInputVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list); 
			if (list.isEmpty())
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_0495:btn_Retrieve<br>
	 * t/s port를 기준으로 booking들의 입항 vessel과 출항 vessel을 조회한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTSListBy1st2ndVVDList(Event e) throws EventException {
		try{
			EsmBkg0495Event event = (EsmBkg0495Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			/* ESM_BKG_0495 .js 에서 Script 처리 하여도 Missing 되어 한번더 체크 함 */
			if(event.getTSListBy1st2ndVVDListInputVO().getVvd().isEmpty() && (event.getTSListBy1st2ndVVDListInputVO().getDurFrom().isEmpty() && event.getTSListBy1st2ndVVDListInputVO().getDurTo().isEmpty())){
				eventResponse.setUserMessage(new ErrorHandler("BKG00715",new String[]{"VVD or Duration"}).getUserMessage());
				return eventResponse;
			}			
			List<TSListBy1st2ndVVDListVO> list = command.searchTSListBy1st2ndVVDList(event.getTSListBy1st2ndVVDListInputVO());
			eventResponse.setRsVoList(list); 
			if (list.isEmpty())
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_0495:bkg0495_blur<br> 
	 * 화면에서 vvd를 drop down으로 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTSVvdFor1st2nd(Event e) throws EventException {
		try{
			EsmBkg0495Event event = (EsmBkg0495Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();  
			List<BkgComboVO> list = command.searchTSVvdFor1st2nd(event.getTsVvdFor1st2ndInputVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list); 
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
     * ESM_BKG_0495:btn_Fax<br>
     * 화면에 대한 팩스 보내기 이벤트 처리<br>
     * 
     * @param Event e
	 * @return EventResponse
     * @exception EventException
     */
	private EventResponse sendTsListByFax(Event e)throws EventException{
		try{
			EsmBkg0495Event event = (EsmBkg0495Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();  
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			begin();
			command.sendTsListByFax(event.getSendTsListVO(),account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00496").getUserMessage());
	        commit();
	        return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			rollback();
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}		 		
	}
	
	/**
     * ESM_BKG_0495:btn_EMail<br>
     * 화면에 대한 이메일 보내기 이벤트 처리<br>
	 * 
     * @param Event e
	 * @return EventResponse
     * @exception EventException
     */
	private EventResponse sendTsListByEmail(Event e)throws EventException{		
		try{
			EsmBkg0495Event event = (EsmBkg0495Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl(); 
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			begin();
			command.sendTsListByEmail(event.getSendTsListVO(),event.getStrVvd(),account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00497").getUserMessage());
			commit();
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			rollback();
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}		
	}
	
	/**
	 * ESM_BKG_0925:loadPage<br> 
	 * T/S port에 입항한 1st VVD를 기준으로 연결되는 선명 별로 물량을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTSSummary(Event e) throws EventException {
		try{
			EsmBkg0925Event event = (EsmBkg0925Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();  
			List<TSSummaryVO> list = command.searchTSSummary(event.getTSListBy1st2ndVVDListInputVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list); 			 
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_0950:btn_retrieve<br>
	 * Relay Vessel Group Assign by Relay Port 화면에서 assing을 위해 list를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRlyVslGrpAssign(Event e) throws EventException{
		try{
			EsmBkg0950Event event = (EsmBkg0950Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();  
			List<RlyVslGrpAssignVO> list = command.searchRlyVslGrpAssign(event.getRlyVslGrpAssignInputVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list); 
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_0903:loadPage<br>
	 * Next VVD Assign T/S Remark 화면에서 T/S remark를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTSRemark(Event e)throws EventException{
		try{
			EsmBkg0903Event event = (EsmBkg0903Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();  
			BkgTsRmkVO  bkgTsRmkVO = command.searchTSRemark(event.getBkgTsRmkVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	//		eventResponse.setETCData("bkg_no",(bkgTsRmkVO!=null)? JSPUtil.getNull(bkgTsRmkVO.getBkgNo()):""); 
			eventResponse.setETCData("ts_rmk",(bkgTsRmkVO!=null)? JSPUtil.getNull(bkgTsRmkVO.getTsRmk()):""); 
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_0903:btn_save<br>
	 *  t/s port에서 next vessel을 재지정시 입력한 remark를 저장한다.<br>
	 *  
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTSRemark(Event e)throws EventException{
		try{
			EsmBkg0903Event event = (EsmBkg0903Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();  
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			begin();
			command.manageTSRemark(event.getBkgTsRmkVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			rollback();
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}		
	}
	
	/**
	 * ESM_BKG_0387:btn_retrieve<br>
	 * VVD Assign을 위해 입항 vvd와 출항 vvd, 대상 Bkg들을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFormerVvdForAssign(Event e)throws EventException{
		try{
			EsmBkg0387Event event = (EsmBkg0387Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();  
			List<FormerVvdVO> list = command.searchFormerVvdForAssign(event.getNextVvdAssignInputVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list); 
			if (list.isEmpty()) {
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
			} 
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_0387:sheet1_OnChange<br>
	 * vvd assign에서 next vvd를 지정할 대상을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTargetForAssign(Event e)throws EventException{
		try{
			EsmBkg0387Event event = (EsmBkg0387Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();  
			VvdAssignTargetListVO list = command.searchTargetForAssign(event.getNextVvdAssignInputVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("vs_nm", JSPUtil.getNull(list.getFormerVvdSkdVO().getVslNm()));
			eventResponse.setETCData("eta", JSPUtil.getNull(list.getFormerVvdSkdVO().getEta()));
			eventResponse.setETCData("etd", JSPUtil.getNull(list.getFormerVvdSkdVO().getEtd()));
			eventResponse.setRsVoList(list.getVvdAssignTargetVvdVO());
			eventResponse.setRsVoList(list.getVvdAssignTargetBkgVO());
			if (list.getVvdAssignTargetBkgVO().isEmpty()
				||list.getVvdAssignTargetVvdVO().isEmpty()) {
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
			}			 
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_0387:t1sheet1_OnChange<br>
	 * vvd assign에서 next vvd가 될 수 있는 vvd를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNextVvdForAssign(Event e)throws EventException{
		try{
			EsmBkg0387Event event = (EsmBkg0387Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();  
			List<NextVvdVO> list = command.searchNextVvdForAssign(event.getNextVvdAssignInputVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			if (list.isEmpty()) {
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
			}  
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
	 * VVD를 Check해야하는지 여부<br>
	 *
	 * @author	KimByungKyu
	 * @param 	String vvd
	 * @return  	boolean
	 * @exception Exception
	 */
	private boolean isCheckVvdCd(String vvd){
		boolean isOk = false;
		try{
			if(vvd != null && vvd.length() > 0){
				if(!vvd.startsWith("SMXX") && !vvd.startsWith("SMYY") && !vvd.startsWith("SMZZ")){
					isOk = true;
				}
			}			
		}catch(Exception e){
			log.error(e.getMessage()); // 2011.07.14
			isOk = false;
		}
		return isOk;
	}
	
	/**
	 * ESM_BKG_0950:callback_0950<br>
	 * Booking의 Ocean Route만 수정한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyOceanRoute(Event e) throws EventException{
		GeneralEventResponse eventResponse = null;
		BkgBlNoVO bkgBlNoVO = null;
		eventResponse = new GeneralEventResponse();
		try {
			GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
			GeneralBookingSearchBC  searchBC  = new GeneralBookingSearchBCImpl();
			BookingHistoryMgtBC     historyBC = new BookingHistoryMgtBCImpl();
			BookingUtil             util      = new BookingUtil();
			
//			OwnDangerousCargoApprovalBC ownDangerousCargoApprovalBC = new OwnDangerousCargoApprovalBCImpl();
			ProductCatalogCreateBC  prdBC = new ProductCatalogCreateBCImpl();
			BkgCopManageBC          copBC = new BkgCopManageBCImpl();
			CostAssignBC            masBc = new CostAssignBCImpl();
			BookingARCreationBC     invBc = new BookingARCreationBCImpl();			
			
			PrdMainInfoVO prdMainInfoVO   = new PrdMainInfoVO();			
			PrdParameterVO prdParameterVO = new PrdParameterVO();
			String strUid = "";
			String newVvd = "";
			String oldFirstVvd = "";
			String newFirstVvd = "";
			VvdAssignVO vvdAssignVO = new VvdAssignVO(); 
			OldNewVvdVO oldNewVvdVO = new OldNewVvdVO();

			prdMainInfoVO.setFCmd("3");
			prdMainInfoVO.setPcMode("R");
			boolean isPreVvd = false;  
			
			if (e.getEventName().equalsIgnoreCase("EsmBkg0950Event")){
				EsmBkg0950Event event = (EsmBkg0950Event)e;
				bkgBlNoVO=event.getBkgBlNoVO();
				
				strUid="ESM_BKG_0950"; 
				vvdAssignVO.setBkgBlNoVO(bkgBlNoVO);
		    	oldNewVvdVO.setOldvvd(event.getOrgVVD());
		    	oldNewVvdVO.setNewvvd(event.getNewVVD());
				vvdAssignVO.setOldNewVvdVO(oldNewVvdVO);
				vvdAssignVO.setClosedVvds(event.getClosedVvds());
								
				if("P".equals(event.getAssignFlag())){
					isPreVvd = true;
				}
				newVvd = event.getNewVVD();
				
				prdMainInfoVO.setBkgNo(bkgBlNoVO.getBkgNo());				
				prdParameterVO.setBkgBlNoVO(bkgBlNoVO);
				prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
				
				//group vvd 화면에서 trans mode를 AL로 보냄
				prdParameterVO.getPrdMainInfoVO().setOrgTrnsMode("X");
				prdParameterVO.getPrdMainInfoVO().setDestTrnsMode("X");
				prdParameterVO=util.searchPrdParmForFullRoute (prdParameterVO);
				
				if("F".equals(event.getAssignFlag())){
					if (prdParameterVO.getPrdMainInfoVO().getPod1().equals(event.getRelay())){
						prdParameterVO.getPrdMainInfoVO().setVvd1(event.getNewVVD());
						prdParameterVO.getPrdMainInfoVO().setLane1(util.searchSvcLaneByVvd(event.getNewVVD()));
					}else if (prdParameterVO.getPrdMainInfoVO().getPod2().equals(event.getRelay())){
						prdParameterVO.getPrdMainInfoVO().setVvd2(event.getNewVVD());
						prdParameterVO.getPrdMainInfoVO().setLane2(util.searchSvcLaneByVvd(event.getNewVVD()));
					}else if (prdParameterVO.getPrdMainInfoVO().getPod3().equals(event.getRelay())){
						prdParameterVO.getPrdMainInfoVO().setVvd3(event.getNewVVD());
						prdParameterVO.getPrdMainInfoVO().setLane3(util.searchSvcLaneByVvd(event.getNewVVD()));
					}else if (prdParameterVO.getPrdMainInfoVO().getPod4().equals(event.getRelay())){
						prdParameterVO.getPrdMainInfoVO().setVvd4(event.getNewVVD());
						prdParameterVO.getPrdMainInfoVO().setLane4(util.searchSvcLaneByVvd(event.getNewVVD()));
					}
				}else{
					if (prdParameterVO.getPrdMainInfoVO().getPol1().equals(event.getRelay())){
						prdParameterVO.getPrdMainInfoVO().setVvd1(event.getNewVVD());
						prdParameterVO.getPrdMainInfoVO().setLane1(util.searchSvcLaneByVvd(event.getNewVVD()));
					}else if (prdParameterVO.getPrdMainInfoVO().getPol2().equals(event.getRelay())){
						prdParameterVO.getPrdMainInfoVO().setVvd2(event.getNewVVD());
						prdParameterVO.getPrdMainInfoVO().setLane2(util.searchSvcLaneByVvd(event.getNewVVD()));
					}else if (prdParameterVO.getPrdMainInfoVO().getPol3().equals(event.getRelay())){
						prdParameterVO.getPrdMainInfoVO().setVvd3(event.getNewVVD());
						prdParameterVO.getPrdMainInfoVO().setLane3(util.searchSvcLaneByVvd(event.getNewVVD()));
					}else if (prdParameterVO.getPrdMainInfoVO().getPol4().equals(event.getRelay())){
						prdParameterVO.getPrdMainInfoVO().setVvd4(event.getNewVVD());
						prdParameterVO.getPrdMainInfoVO().setLane4(util.searchSvcLaneByVvd(event.getNewVVD()));
					}
				}				

//				//20151223 [CHM-201539233] Yard Level Data 를 PRD 로 전달 함 (더블콜링 때문)
//				//20100803 vvd assign시 기존 bkg의 yard level data를 prd로 전달하지 않음  
//				//20130214 vvd가 없는 경우에는 yard level data를 전달함
//				if(prdParameterVO.getPrdMainInfoVO().getVvd1() != null
//						&& prdParameterVO.getPrdMainInfoVO().getVvd1().length() == 9){
//					prdParameterVO.getPrdMainInfoVO().setPol1N("");
//					prdParameterVO.getPrdMainInfoVO().setPol1C("");
//					prdParameterVO.getPrdMainInfoVO().setPod1N("");
//					prdParameterVO.getPrdMainInfoVO().setPod1C("");
//				}
//				if(prdParameterVO.getPrdMainInfoVO().getVvd2() != null
//						&& prdParameterVO.getPrdMainInfoVO().getVvd2().length() == 9){
//					prdParameterVO.getPrdMainInfoVO().setPol2N("");
//					prdParameterVO.getPrdMainInfoVO().setPol2C("");	
//					prdParameterVO.getPrdMainInfoVO().setPod2N("");
//					prdParameterVO.getPrdMainInfoVO().setPod2C("");
//				}
//				if(prdParameterVO.getPrdMainInfoVO().getVvd3() != null
//						&& prdParameterVO.getPrdMainInfoVO().getVvd3().length() == 9){
//					prdParameterVO.getPrdMainInfoVO().setPol3N("");
//					prdParameterVO.getPrdMainInfoVO().setPol3C("");
//					prdParameterVO.getPrdMainInfoVO().setPod3N("");
//					prdParameterVO.getPrdMainInfoVO().setPod3C("");
//				}
//				if(prdParameterVO.getPrdMainInfoVO().getVvd4() != null
//						&& prdParameterVO.getPrdMainInfoVO().getVvd4().length() == 9){
//					prdParameterVO.getPrdMainInfoVO().setPol4N("");
//					prdParameterVO.getPrdMainInfoVO().setPol4C("");
//					prdParameterVO.getPrdMainInfoVO().setPod4N("");
//					prdParameterVO.getPrdMainInfoVO().setPod4C("");
//				}
			}else if (e.getEventName().equalsIgnoreCase("EsmBkg0387Event")){
				EsmBkg0387Event event = (EsmBkg0387Event)e;
		    	bkgBlNoVO=event.getBkgBlNoVO(); 
				
		    	strUid="ESM_BKG_0387";
		    	vvdAssignVO.setBkgBlNoVO(bkgBlNoVO);
		    	oldNewVvdVO.setOldvvd(event.getFormerVvd());
		    	oldNewVvdVO.setNewvvd(event.getNextVvd());
		    	oldNewVvdVO.setOopCd(event.getOopCd());	
		    	oldNewVvdVO.setNextTmnl(event.getNextTmnl());
		    	oldNewVvdVO.setNextSeq(event.getNextSeq());
		    	oldNewVvdVO.setOldNextVvd(event.getOldNextVvd());
		    	oldNewVvdVO.setRelayTmnl(event.getRelayTmnl());
		    	oldNewVvdVO.setRelaySeq(event.getRelaySeq());
				vvdAssignVO.setClosedVvds(event.getClosedVvds());
		    	
		    	newVvd = event.getNextVvd();
				vvdAssignVO.setOldNewVvdVO(oldNewVvdVO);	
				
				prdMainInfoVO.setBkgNo(bkgBlNoVO.getBkgNo());
				prdParameterVO.setBkgBlNoVO(bkgBlNoVO);
				prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
				
				//group vvd 화면에서 trans mode를 AL로 보냄
				prdParameterVO.getPrdMainInfoVO().setOrgTrnsMode("X");
				prdParameterVO.getPrdMainInfoVO().setDestTrnsMode("X");
				prdParameterVO=util.searchPrdParmForFullRoute (prdParameterVO);
				
//				//20151223 [CHM-201539233] Yard Level Data 를 PRD 로 전달 함 (더블콜링 때문)				
//				//20100803 vvd assign시 기존 bkg의 yard level data를 prd로 전달하지 않음 
//				//20130214 vvd가 없는 경우에는 yard level data를 전달함
//				if(prdParameterVO.getPrdMainInfoVO().getVvd1() != null
//						&& prdParameterVO.getPrdMainInfoVO().getVvd1().length() == 9){
//					prdParameterVO.getPrdMainInfoVO().setPol1N("");
//					prdParameterVO.getPrdMainInfoVO().setPol1C("");
//					prdParameterVO.getPrdMainInfoVO().setPod1N("");
//					prdParameterVO.getPrdMainInfoVO().setPod1C("");
//				}
//				if(prdParameterVO.getPrdMainInfoVO().getVvd2() != null
//						&& prdParameterVO.getPrdMainInfoVO().getVvd2().length() == 9){
//					prdParameterVO.getPrdMainInfoVO().setPol2N("");
//					prdParameterVO.getPrdMainInfoVO().setPol2C("");	
//					prdParameterVO.getPrdMainInfoVO().setPod2N("");
//					prdParameterVO.getPrdMainInfoVO().setPod2C("");
//				}
//				if(prdParameterVO.getPrdMainInfoVO().getVvd3() != null
//						&& prdParameterVO.getPrdMainInfoVO().getVvd3().length() == 9){
//					prdParameterVO.getPrdMainInfoVO().setPol3N("");
//					prdParameterVO.getPrdMainInfoVO().setPol3C("");
//					prdParameterVO.getPrdMainInfoVO().setPod3N("");
//					prdParameterVO.getPrdMainInfoVO().setPod3C("");
//				}
//				if(prdParameterVO.getPrdMainInfoVO().getVvd4() != null
//						&& prdParameterVO.getPrdMainInfoVO().getVvd4().length() == 9){
//					prdParameterVO.getPrdMainInfoVO().setPol4N("");
//					prdParameterVO.getPrdMainInfoVO().setPol4C("");
//					prdParameterVO.getPrdMainInfoVO().setPod4N("");
//					prdParameterVO.getPrdMainInfoVO().setPod4C("");
//				}
				
				if (prdParameterVO.getPrdMainInfoVO().getVvd2() != null &&
					prdParameterVO.getPrdMainInfoVO().getVvd1().equals(oldNewVvdVO.getOldvvd()) &&
					prdParameterVO.getPrdMainInfoVO().getVvd2().equals(oldNewVvdVO.getOldNextVvd()) ){
					if(isCheckVvdCd(oldNewVvdVO.getNewvvd())){//SMXX0001E가 아닐 경우
						prdParameterVO.getPrdMainInfoVO().setVvd2(oldNewVvdVO.getNewvvd());
						prdParameterVO.getPrdMainInfoVO().setPol2N(oldNewVvdVO.getRelayTmnl());
						prdParameterVO.getPrdMainInfoVO().setPol2C(oldNewVvdVO.getRelaySeq());
						prdParameterVO.getPrdMainInfoVO().setLane2(util.searchSvcLaneByVvd(oldNewVvdVO.getNewvvd()));
						prdParameterVO.getPrdMainInfoVO().setPod2N(oldNewVvdVO.getNextTmnl());
						prdParameterVO.getPrdMainInfoVO().setPod2C(oldNewVvdVO.getNextSeq());
					} else {
						prdParameterVO.getPrdMainInfoVO().setVvd2("SMXX0001E");
						prdParameterVO.getPrdMainInfoVO().setLane2("SYS");
					}				
				} else if (prdParameterVO.getPrdMainInfoVO().getVvd3() != null &&
						   prdParameterVO.getPrdMainInfoVO().getVvd2().equals(oldNewVvdVO.getOldvvd()) &&
						   prdParameterVO.getPrdMainInfoVO().getVvd3().equals(oldNewVvdVO.getOldNextVvd()) ){
					if(isCheckVvdCd(oldNewVvdVO.getNewvvd())){//SMXX0001E가 아닐 경우
						prdParameterVO.getPrdMainInfoVO().setVvd3(oldNewVvdVO.getNewvvd());
						prdParameterVO.getPrdMainInfoVO().setPol3N(oldNewVvdVO.getRelayTmnl());
						prdParameterVO.getPrdMainInfoVO().setPol3C(oldNewVvdVO.getRelaySeq());
						prdParameterVO.getPrdMainInfoVO().setLane3(util.searchSvcLaneByVvd(oldNewVvdVO.getNewvvd()));
						prdParameterVO.getPrdMainInfoVO().setPod3N(oldNewVvdVO.getNextTmnl());
						prdParameterVO.getPrdMainInfoVO().setPod3C(oldNewVvdVO.getNextSeq());
					} else {
						prdParameterVO.getPrdMainInfoVO().setVvd3("SMXX0001E");
						prdParameterVO.getPrdMainInfoVO().setLane3("SYS");
					}
				} else if (prdParameterVO.getPrdMainInfoVO().getVvd4() != null &&
						   prdParameterVO.getPrdMainInfoVO().getVvd3().equals(oldNewVvdVO.getOldvvd()) &&
						   prdParameterVO.getPrdMainInfoVO().getVvd4().equals(oldNewVvdVO.getOldNextVvd()) ){
					if(isCheckVvdCd(oldNewVvdVO.getNewvvd())){//SMXX0001E가 아닐 경우
						prdParameterVO.getPrdMainInfoVO().setVvd4(oldNewVvdVO.getNewvvd());
						prdParameterVO.getPrdMainInfoVO().setPol4N(oldNewVvdVO.getRelayTmnl());
						prdParameterVO.getPrdMainInfoVO().setPol4C(oldNewVvdVO.getRelaySeq());
						prdParameterVO.getPrdMainInfoVO().setLane4(util.searchSvcLaneByVvd(oldNewVvdVO.getNewvvd()));
						prdParameterVO.getPrdMainInfoVO().setPod4N(oldNewVvdVO.getNextTmnl());
						prdParameterVO.getPrdMainInfoVO().setPod4C(oldNewVvdVO.getNextSeq());
					} else {
						prdParameterVO.getPrdMainInfoVO().setVvd4("SMXX0001E");
						prdParameterVO.getPrdMainInfoVO().setLane4("SYS");
					}
				} else if (prdParameterVO.getPrdMainInfoVO().getVvd1() != null &&
						   prdParameterVO.getPrdMainInfoVO().getVvd1().equals(oldNewVvdVO.getOldNextVvd())){
					if(isCheckVvdCd(oldNewVvdVO.getNewvvd())){//SMXX0001E가 아닐 경우
						prdParameterVO.getPrdMainInfoVO().setVvd1(oldNewVvdVO.getNewvvd());
						prdParameterVO.getPrdMainInfoVO().setPol1N(oldNewVvdVO.getRelayTmnl());
						prdParameterVO.getPrdMainInfoVO().setPol1C(oldNewVvdVO.getRelaySeq());
						prdParameterVO.getPrdMainInfoVO().setLane1(util.searchSvcLaneByVvd(oldNewVvdVO.getNewvvd()));
						prdParameterVO.getPrdMainInfoVO().setPod1N(oldNewVvdVO.getNextTmnl());
						prdParameterVO.getPrdMainInfoVO().setPod1C(oldNewVvdVO.getNextSeq());
					} else {
						prdParameterVO.getPrdMainInfoVO().setVvd1("SMXX0001E");
						prdParameterVO.getPrdMainInfoVO().setLane1("SYS");
					}
				}
			}else if (e.getEventName().equalsIgnoreCase("EsmBkg0898Event")){
				EsmBkg0898Event event = (EsmBkg0898Event)e;
				bkgBlNoVO=event.getBkgBlNoVO();
				
				strUid="ESM_BKG_0898";
				vvdAssignVO.setBkgBlNoVO(bkgBlNoVO);
				prdMainInfoVO.setBkgNo(bkgBlNoVO.getBkgNo());		
				vvdAssignVO.setClosedVvds(event.getClosedVvds());		
				vvdAssignVO.setVvdPortAssinVOs(event.getVvdPortAssinVOs());				
				//2012.01.09 port_skp_flg 값 추가 kbj
				vvdAssignVO.setPortSkpFlg(event.getPortSkpFlg());
				
				if (event.getVvdPortAssinVOs().length>0){
					prdMainInfoVO.setPod1(event.getVvdPortAssinVOs()[0].getPodCd());
					prdMainInfoVO.setPod1N((event.getVvdPortAssinVOs()[0].getPodYdCd().length()==7)?event.getVvdPortAssinVOs()[0].getPodYdCd():"");
					prdMainInfoVO.setPod1C(event.getVvdPortAssinVOs()[0].getPodClptIndSeq());
					prdMainInfoVO.setPol1(event.getVvdPortAssinVOs()[0].getPolCd());
					prdMainInfoVO.setPol1N((event.getVvdPortAssinVOs()[0].getPolYdCd().length()==7)?event.getVvdPortAssinVOs()[0].getPolYdCd():"");
					prdMainInfoVO.setPol1C(event.getVvdPortAssinVOs()[0].getPolClptIndSeq());
					prdMainInfoVO.setVvd1(event.getVvdPortAssinVOs()[0].getBkgVvdCd());
				}else{
					prdMainInfoVO = util.resetNthRoute(prdMainInfoVO, 1);
				}
				
				if (event.getVvdPortAssinVOs().length>1){
					prdMainInfoVO.setPod2(event.getVvdPortAssinVOs()[1].getPodCd());
					prdMainInfoVO.setPod2N((event.getVvdPortAssinVOs()[1].getPodYdCd().length()==7)?event.getVvdPortAssinVOs()[1].getPodYdCd():"");
					prdMainInfoVO.setPod2C(event.getVvdPortAssinVOs()[1].getPodClptIndSeq());
					prdMainInfoVO.setPol2(event.getVvdPortAssinVOs()[1].getPolCd());
					prdMainInfoVO.setPol2N((event.getVvdPortAssinVOs()[1].getPolYdCd().length()==7)?event.getVvdPortAssinVOs()[1].getPolYdCd():"");
					prdMainInfoVO.setPol2C(event.getVvdPortAssinVOs()[1].getPolClptIndSeq());
					prdMainInfoVO.setVvd2(event.getVvdPortAssinVOs()[1].getBkgVvdCd());
				}else{
					prdMainInfoVO = util.resetNthRoute(prdMainInfoVO, 2);
				}
				
				if (event.getVvdPortAssinVOs().length>2){
					prdMainInfoVO.setPod3(event.getVvdPortAssinVOs()[2].getPodCd());
					prdMainInfoVO.setPod3N((event.getVvdPortAssinVOs()[2].getPodYdCd().length()==7)?event.getVvdPortAssinVOs()[2].getPodYdCd():"");
					prdMainInfoVO.setPod3C(event.getVvdPortAssinVOs()[2].getPodClptIndSeq());
					prdMainInfoVO.setPol3(event.getVvdPortAssinVOs()[2].getPolCd());
					prdMainInfoVO.setPol3N((event.getVvdPortAssinVOs()[2].getPolYdCd().length()==7)?event.getVvdPortAssinVOs()[2].getPolYdCd():"");
					prdMainInfoVO.setPol3C(event.getVvdPortAssinVOs()[2].getPolClptIndSeq());
					prdMainInfoVO.setVvd3(event.getVvdPortAssinVOs()[2].getBkgVvdCd());
				}else{
					prdMainInfoVO = util.resetNthRoute(prdMainInfoVO, 3); 
				}
				
				if (event.getVvdPortAssinVOs().length>3){
					prdMainInfoVO.setPod4(event.getVvdPortAssinVOs()[3].getPodCd());
					prdMainInfoVO.setPod4N((event.getVvdPortAssinVOs()[3].getPodYdCd().length()==7)?event.getVvdPortAssinVOs()[3].getPodYdCd():"");
					prdMainInfoVO.setPod4C(event.getVvdPortAssinVOs()[3].getPodClptIndSeq());
					prdMainInfoVO.setPol4(event.getVvdPortAssinVOs()[3].getPolCd());
					prdMainInfoVO.setPol4N((event.getVvdPortAssinVOs()[3].getPolYdCd().length()==7)?event.getVvdPortAssinVOs()[3].getPolYdCd():"");
					prdMainInfoVO.setPol4C(event.getVvdPortAssinVOs()[3].getPolClptIndSeq());
					prdMainInfoVO.setVvd4(event.getVvdPortAssinVOs()[3].getBkgVvdCd());
				}else{
					prdMainInfoVO = util.resetNthRoute(prdMainInfoVO, 4); 
				}
				
				prdParameterVO.setBkgBlNoVO(bkgBlNoVO);
				prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
				//group vvd 화면에서 trans mode를 AL로 보냄
//				prdParameterVO.getPrdMainInfoVO().setOrgTrnsMode("X");
//				prdParameterVO.getPrdMainInfoVO().setDestTrnsMode("X");
				//group vvd 화면에서 trans mode를 가져올수 있도록 수정 되어 있음 2010.04.14
				prdParameterVO=util.searchPrdParmForFullRoute (prdParameterVO);
				
				// 기존 route보다 t/s 수가 줄어들면 줄어든 만큼 지워준다
				if(event.getVvdPortAssinVOs().length<2){
					prdParameterVO.setPrdMainInfoVO(util.resetNthRoute(prdParameterVO.getPrdMainInfoVO(), 2));
				}
				if(event.getVvdPortAssinVOs().length<3){
					prdParameterVO.setPrdMainInfoVO(util.resetNthRoute(prdParameterVO.getPrdMainInfoVO(), 3));
				}
				if(event.getVvdPortAssinVOs().length<4){
					prdParameterVO.setPrdMainInfoVO(util.resetNthRoute(prdParameterVO.getPrdMainInfoVO(), 4));
				}
				
				// trunk vvd가 바뀔 수 있으므로 null로 교체 
				prdMainInfoVO = prdParameterVO.getPrdMainInfoVO();
				prdMainInfoVO.setTVvd("");
				prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);	
			}

			//D.Term이 Y인 경우 DEL Node null 로 P/C 호출
			if("Y".equals(prdParameterVO.getPrdMainInfoVO().getDelT())){
				if(prdParameterVO.getPrdMainInfoVO().getPodN().equals(prdParameterVO.getPrdMainInfoVO().getDelN())) {
					prdParameterVO.getPrdMainInfoVO().setDelN("");	
				}
			}			
//			util.prdParameterLog(prdParameterVO.getPrdMainInfoVO());

			String pctlNoMapSeqStr = null;
			//pseudo vvd일 결우 별도 처리
			if(oldNewVvdVO.getNewvvd()!=null
				&&(oldNewVvdVO.getNewvvd().substring(0, 4).equals("SMXX")
					||oldNewVvdVO.getNewvvd().substring(0, 4).equals("SMYY")
					||oldNewVvdVO.getNewvvd().substring(0, 4).equals("SMZZ"))){
				pctlNoMapSeqStr = prdBC.updateBkgAssignVvd(prdParameterVO, account);
			} else {
				receiptBC.validateOceanRoute(prdParameterVO.getPrdMainInfoVO());				
				pctlNoMapSeqStr = prdBC.createPrdCtlgRout(prdParameterVO, account);		
			}
			if(!(pctlNoMapSeqStr != null && pctlNoMapSeqStr.length() > 0 && !"FAIL".equals(pctlNoMapSeqStr))){
				throw new EventException(new ErrorHandler("PRD00040",new String[]{bkgBlNoVO.getBkgNo()}).getMessage());				
			}
			String [] pctlNoMapSeq = util.splitByToken(pctlNoMapSeqStr, "|");			
			if(pctlNoMapSeq[0]!=null && bkgBlNoVO!=null){
				bkgBlNoVO.setPctlNo(pctlNoMapSeq[0]);
			}
			if(pctlNoMapSeq[1]!=null && bkgBlNoVO!=null){
				bkgBlNoVO.setMapSeq(pctlNoMapSeq[1]);
			}
			if(strUid.equals("ESM_BKG_0898")){
				OldBkgInfoVO oldBkgInfoVO = receiptBC.searchOldBkgInfo(bkgBlNoVO);
				oldFirstVvd = oldBkgInfoVO.getFirstVvd();
				if(oldBkgInfoVO.getCodFlg().equals("Y")){
					CODCorrectionBC codBC = new CODCorrectionBCImpl();
					codBC.manageAutoCod(bkgBlNoVO, account, "TS");

					HistoryLineVO historyLineVO = new HistoryLineVO();
					historyLineVO.setUiId(strUid);			
					historyLineVO.setHisCateNm("COD");
					if(bkgBlNoVO!=null && bkgBlNoVO.getBkgNo()!=null){
						historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
					}
					historyLineVO.setCaFlg("N");
					historyLineVO.setCrntCtnt("COD Request Created");				
					historyBC.createBkgHistoryLine(historyLineVO, account);
					
					//POD,DEL 국가 변경시 COP 호출
					CodEtcVO codEtcVO = codBC.searchCopForBkgCodParam(bkgBlNoVO);
					if(codEtcVO!=null){
						UpdBkgForBkgCodVO updBkgForBkgCodVO = new UpdBkgForBkgCodVO();
						updBkgForBkgCodVO.setBkgNo(bkgBlNoVO.getBkgNo());
						updBkgForBkgCodVO.setOldPodYdCd(codEtcVO.getOldPodNodCd());
						updBkgForBkgCodVO.setOldDelYdCd(codEtcVO.getOldDelNodCd());
						updBkgForBkgCodVO.setNewPodYdCd(codEtcVO.getNewPodNodCd());
						updBkgForBkgCodVO.setNewDelYdCd(codEtcVO.getNewDelNodCd());
						copBC.updateBkgForBkgCod(updBkgForBkgCodVO);
					}
				}
			}
			if(bkgBlNoVO!=null){
				bkgBlNoVO.setCaFlg("N");
			}
			vvdAssignVO.setBkgBlNoVO(bkgBlNoVO); 
			//변경 전 값 조회
			HistoryTableVO historyTableVO = historyBC.searchOldBkgForHistory(strUid,bkgBlNoVO);
			
			//vvd 변경
			BdrSpclVO bdrSpclVO=receiptBC.modifyOceanRoute(vvdAssignVO,account);
			
			//변경 후 값과 비교하여 history 생성			
			historyBC.manageBookingHistory(strUid, historyTableVO, account);
			
			if(strUid.equals("ESM_BKG_0898")){
				OldBkgInfoVO newBkgInfoVO = receiptBC.searchOldBkgInfo(bkgBlNoVO);
				newFirstVvd = newBkgInfoVO.getFirstVvd();
				
				/*log.debug("zzzzzzzzzzzzzzzzzz"+oldFirstVvd);
				log.debug("zzzzzzzzzzzzzzzzzz"+newFirstVvd);*/
				
				if(!"Y".equals(bkgBlNoVO.getCaFlg()) && !newFirstVvd.equals(oldFirstVvd)){
					// 15. Roll Over 정보 수정
					bkgBlNoVO.setUiId(strUid);
					receiptBC.modifyBkgRollOvr(bkgBlNoVO, account);
				}
			}
			
			//pre vvd assign이 아닐때, special cargo가 있을 때, new vvd가 off-line type이 아닐 때 실행 
			if (false == isPreVvd && bdrSpclVO.getSpclcgoflag().equals("Y") && !"O".equals(util.searchVslSvcTpCd(newVvd))){				
				ScgAproRqstVO[] scgAproRqstVOs = searchBC.searchBkgForSpclRqst(bkgBlNoVO, "VVD ASSIGN", account);
		        
				// spcl cgo가 있을 때만 처리
		        if(scgAproRqstVOs.length>0){
					OwnDangerousCargoApprovalBC spclAproBC    = new OwnDangerousCargoApprovalBCImpl();
					SpecialCargoReceiptBC 	    spclReceiptBC = new SpecialCargoReceiptBCImpl();	
					PartnerLinesDangerousCargoApprovalBCImpl spclRqstBC = new PartnerLinesDangerousCargoApprovalBCImpl();				
					try {
						List<String> paramVvds = new ArrayList<String>();
						if ("".equals(newVvd)) {
							List<String> newVvds = new ArrayList<String>();
							List<BkgVvdVO> oldVvdVOs = historyTableVO.getBkgVvdVOs();
							List<String> oldVvds = new ArrayList<String>();
							for (BkgVvdVO vo : oldVvdVOs) {
								oldVvds.add(vo.getVslCd()+vo.getSkdVoyNo()+vo.getSkdDirCd());
							}
							newVvds.add(prdMainInfoVO.getVvd1());
							newVvds.add(prdMainInfoVO.getVvd2());
							newVvds.add(prdMainInfoVO.getVvd3());
							newVvds.add(prdMainInfoVO.getVvd4());
							for (String temp : newVvds) {
								if (!oldVvds.contains(temp)) {
									paramVvds.add(temp);
								}
							}
						} else {
							paramVvds.add(newVvd);
						}

						ScgVvdAproRqstVO[] scgVvdVOs = spclReceiptBC.searchBkgVvdTs(bkgBlNoVO.getBkgNo(),paramVvds);
				        
						boolean isDg = false;
						for(int i=0;i<scgAproRqstVOs.length;i++){
							if ("DG".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //DG
								isDg = true;
								break;
							}
						}
						//target lane일 경우
						if(scgVvdVOs.length>0){
							//danger가 있을 경우  
							if(isDg){
								PreRestrictionInputVO preRestrictionInputVO = null;
								PreRestrictionOutputVO chkRslt = null;
								boolean segRslt = false;
								boolean vslRslt = false;
								boolean prtRslt = false;
								List<PreRestrictionVesselOperatorVO> vslRsltDtl = null;
								List<PreRestrictionPortVO>           prtRsltDtl = null;
								String spclRqstDesc = null;
								for (ScgVvdAproRqstVO vo : scgVvdVOs) {
									/********************************************************************************************************************************************
									 * cf.) 
									 * PreRestrictionInputVO preRestrictionInputVO = new PreRestrictionInputVO();
									 * preRestrictionInputVO.setBkgNo("ATLX1210006");
									 * preRestrictionInputVO.setVslCd("HNBR");
									 * preRestrictionInputVO.setSkdVoyNo("0039");
									 * preRestrictionInputVO.setSkdDirCd("E");
									 * PreRestrictionOutputVO chkRslt = checkPreRestriction(preRestrictionInputVO, false, true, true);
									 * boolean segRslt = chkRslt.getSegChkRslt();														//Result of Segregation Validation
									 * boolean vslRslt = chkRslt.getVslChkRslt();														//Result of Vessel Operator’s Prohibition
									 * boolean prtRslt = chkRslt.getPrtChkRslt();														//Result of Port Prohibition En-route
									 * List<PreRestrictionSegregationVO>    segRsltDtl = chkRslt.getPreRestrictionSegregationVOs();		//Detail of Segregation Validation
									 * List<PreRestrictionVesselOperatorVO> vslRsltDtl = chkRslt.getPreRestrictionVesselOperatorVOs();	//Detail of Vessel Operator’s Prohibition
									 * List<PreRestrictionPortVO>           prtRsltDtl = chkRslt.getPreRestrictionPortVOs();			//Detail of Port Prohibition En-route
									 ********************************************************************************************************************************************/
									preRestrictionInputVO = new PreRestrictionInputVO();
									preRestrictionInputVO.setBkgNo(bkgBlNoVO.getBkgNo());
									preRestrictionInputVO.setVslCd(vo.getVslCd());//newVvd.substring(0, 4));
									preRestrictionInputVO.setSkdVoyNo(vo.getSkdVoyNo());//newVvd.substring(4, 8));
									preRestrictionInputVO.setSkdDirCd(vo.getSkdDirCd());//newVvd.substring(8, 9));
									preRestrictionInputVO.setInnerPreRestrictionInputVO(preRestrictionInputVO);
									chkRslt = spclRqstBC.checkPreRestriction(preRestrictionInputVO, false, true, true, true);
									
									segRslt = chkRslt.getSegChkRslt();														//Result of Segregation Validation
									vslRslt = chkRslt.getVslChkRslt();														//Result of Vessel Operator’s Prohibition
									prtRslt = chkRslt.getPrtChkRslt();														//Result of Port Prohibition En-route
				//					List<PreRestrictionSegregationVO>    segRsltDtl = chkRslt.getPreRestrictionSegregationVOs();	//Detail of Segregation Validation
									vslRsltDtl = chkRslt.getPreRestrictionVesselOperatorVOs();	//Detail of Vessel Operator’s Prohibition
									prtRsltDtl = chkRslt.getPreRestrictionPortVOs();			//Detail of Port Prohibition En-route
									
				//					pre check에서 걸렸을 때 spcl request 상태로 변경한다.
									if(segRslt || vslRslt || prtRslt){
										spclRqstDesc = "After implementation pre-checking routines at T/S port, found some conflicts or prohibitions.\n" +
															  "Please check the conflicts or prohibitions.";
										if(null != vslRsltDtl && vslRsltDtl.size()>0){
											for(int vslIdx=0; vslIdx<vslRsltDtl.size(); vslIdx++){
												spclReceiptBC.modifyDgSpclRqstByVvdChange(bkgBlNoVO, spclRqstDesc, vslRsltDtl.get(vslIdx).getSpclCgoSeq(), account);
											}
										}
										
										if(null != prtRsltDtl && prtRsltDtl.size()>0){
											for(int prtIdx=0; prtIdx<prtRsltDtl.size(); prtIdx++){
												spclReceiptBC.modifyDgSpclRqstByVvdChange(bkgBlNoVO, spclRqstDesc, prtRsltDtl.get(prtIdx).getSpclCgoSeq(), account);
											}
										}
									}
								}
							}
							
							SpclCgoAproApplVO spclCgoAproVO = new SpclCgoAproApplVO();
							spclCgoAproVO.setBkgNo(bkgBlNoVO.getBkgNo());
							spclCgoAproVO.setAccount(account);
							spclCgoAproVO.setCreUsrId(account.getUsr_id());
							spclCgoAproVO.setUpdUsrId(account.getUsr_id());
							spclCgoAproVO.setSpclReqInVOs(searchBC.searchSpclReqInVO(bkgBlNoVO));
							
							for(int i=0;i<scgAproRqstVOs.length;i++){
								if ("DG".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //DG
									spclCgoAproVO.setSpclCgoTp("D");
									spclReceiptBC.manageSpclCgoApro(spclCgoAproVO);	
								}else if ("RF".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //RF
									spclCgoAproVO.setSpclCgoTp("R");
									spclReceiptBC.manageSpclCgoApro(spclCgoAproVO);
								}else if ("AK".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //AK
									spclCgoAproVO.setSpclCgoTp("A");
									spclReceiptBC.manageSpclCgoApro(spclCgoAproVO);
								}else if ("BB".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //BB
									spclCgoAproVO.setSpclCgoTp("B");
									spclReceiptBC.manageSpclCgoApro(spclCgoAproVO);
								}	
							}		
	
							//SCG 모듈 호출		        
					        for(int i=0;i<scgAproRqstVOs.length;i++){
					        	ScgAproRqstVO[] scgAproRqstVO = new ScgAproRqstVO[1];
					        	scgAproRqstVO[0] = scgAproRqstVOs[i];
								if ("DG".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //DG
							        spclAproBC.requestSpecialCargoApproval(scgAproRqstVO, scgVvdVOs, account);
								}else if ("RF".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //RF
							        spclAproBC.requestSpecialCargoApproval(scgAproRqstVO, scgVvdVOs, account);
								}else if ("AK".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //AK
							        spclAproBC.requestSpecialCargoApproval(scgAproRqstVO, scgVvdVOs, account);
								}else if ("BB".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //BB
							        spclAproBC.requestSpecialCargoApproval(scgAproRqstVO, scgVvdVOs, account);
								}	
					        }
				        }
					} catch (Exception ex){
						log.error("err " + ex.toString(), ex);
					}				        
		        }
			}

			//IBkgCopManageBC::updateBkg ( bkgNo )
			copBC.updateBkg((bkgBlNoVO.getBkgNo()!=null)?bkgBlNoVO.getBkgNo():"", (bkgBlNoVO.getMapSeq()!=null)?bkgBlNoVO.getMapSeq():"");
			//ICostAssignBC::modifyCoaCommonInterface ( coaBkgComIfVo )
			MasBkgComIfVO masBkgComIfVo = new MasBkgComIfVO();
			if(bkgBlNoVO.getBkgNo()!=null){
				masBkgComIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
			}
			masBkgComIfVo.setCostSrcSysCd("BKG");
			masBkgComIfVo.setIfRmk("VVD ASSIGN");
			masBkgComIfVo.setCreUsrId(account.getUsr_id());
			masBkgComIfVo.setUpdUsrId(account.getUsr_id());
			masBc.modifyMasCommonInterface(masBkgComIfVo);
						
			//IBookingARCreationBC::interfaceBKGARInvoiceToINV ( bkgIfVo )
			ARBkgInterfaceCreationVO bkgIfVo = new ARBkgInterfaceCreationVO();
			if(bkgBlNoVO.getBkgNo()!=null){
				bkgIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
			}
			bkgIfVo.setBkgCorrNo("");
			bkgIfVo.setUserId(account.getUsr_id());
			bkgIfVo.setManDivInd("B");				
			invBc.interfaceBKGARInvoiceToINV(bkgIfVo);	

			//////////////////////////////////////////////////////////////////////////
			// customer301 전송 시작 - 2011.01.10
			// * cnee가 (CA:004510, US:001260)인 경우 전송
			// * 전송내용 : GroupID : COM01760, RCV ID : 6135830007
			BkgBlNoVO bkgBlNoIN = null;
			BookingCreationVO bkgCreVO = null;
			CustTpIdVO custTpIdVo = null;
			List<BkgNtcHisVO> bkgNtcHisVOs = null;
			bkgBlNoIN = new BkgBlNoVO();
			if(bkgBlNoVO.getBkgNo()!=null){
				bkgBlNoIN.setBkgNo(bkgBlNoVO.getBkgNo());
			}
			bkgBlNoIN.setCaUsrId(account.getUsr_id());
			bkgBlNoIN = util.searchBkgBlNoVO(bkgBlNoIN);
			if (null!=bkgBlNoIN) {
				bkgCreVO = receiptBC.searchBooking(bkgBlNoIN);
				if (null!=bkgCreVO) {
					custTpIdVo = new CustTpIdVO();
					custTpIdVo = util.searchCustTpIdInfo(bkgBlNoVO.getBkgNo());
					if( null != custTpIdVo ){
						bkgNtcHisVOs = searchBC.createCustBkgReceiptEdi(bkgBlNoIN, custTpIdVo, "N", account);
						if (null!=bkgNtcHisVOs) {
							for (int i=0; i<bkgNtcHisVOs.size(); i++) {
								bkgNtcHisVOs.get(i).setSndId("SYSTEM");
								bkgNtcHisVOs.get(i).setSndUsrId("SYSTEM");
								bkgNtcHisVOs.get(i).setSndOfcCd("SYSTEM");
								bkgNtcHisVOs.get(i).setCreUsrId(account.getUsr_id());
								bkgNtcHisVOs.get(i).setUpdUsrId(account.getUsr_id());
							}
							historyBC.createBkgNtcHis(bkgNtcHisVOs, "");
						}
					}
					// customer301 전송 끝 - 2011.01.10
					//////////////////////////////////////////////////////////////////////////					
					
					
					// VVD 변경되면 SCE(COP)호출
					try{
						// VVD 변경 되었는지 판별
						Boolean changeVvdFlag = false;
						List<BkgVvdVO> oldBkgVvdVOs = historyTableVO.getBkgVvdVOs();
						List<VslSkdVO> newVslSkdVOs = bkgCreVO.getVslSkd();
						if (null!=newVslSkdVOs) {
							if (oldBkgVvdVOs.size() != newVslSkdVOs.size()) {
								changeVvdFlag = true;
							} else {
								for (int i=0; i<oldBkgVvdVOs.size(); i++) {
									String oldVvd2 = oldBkgVvdVOs.get(i).getVslCd().concat(oldBkgVvdVOs.get(i).getSkdVoyNo()).concat(oldBkgVvdVOs.get(i).getSkdDirCd());
									String newVvd2 = newVslSkdVOs.get(i).getBkgVvdCd();
									if (!(oldVvd2).equals(newVvd2)) {
										changeVvdFlag = true;
										break;
									}
								}
							}
						} else {
							changeVvdFlag = true;
						}
						if(changeVvdFlag){
							UpdBkgForVVDChgVO updBkgForVVDChgVO = new UpdBkgForVVDChgVO();
							// 추가된 vvd의 pol (추가된 vvd가 여러건일때는 추가 vvd중 첫번째 vvd의 pol, 추가건이 없을 경우는 bkg의 pol)
							String eventYdCd = "";
							if(newVslSkdVOs!=null){
								for(int i=0; i<newVslSkdVOs.size(); i++ ){
									boolean existVvd = false;
									for(int j=0; j<oldBkgVvdVOs.size(); j++){
										String oldVvd2 = oldBkgVvdVOs.get(j).getVslCd().concat(oldBkgVvdVOs.get(j).getSkdVoyNo()).concat(oldBkgVvdVOs.get(j).getSkdDirCd());
										String newVvd2 = newVslSkdVOs.get(i).getBkgVvdCd();
										if(newVvd2.equalsIgnoreCase(oldVvd2)){
											existVvd = true;
										}
									}
									if(!existVvd && eventYdCd.equals("")){
										eventYdCd = newVslSkdVOs.get(i).getPolYdCd();
									}
								}
							}
							if(eventYdCd.equals("")){
								eventYdCd = bkgCreVO.getBkgBookingInfoVO().getBkgPolYdCd();
							}
							updBkgForVVDChgVO.setBkgNo(bkgCreVO.getBkgBookingInfoVO().getBkgNo());
							updBkgForVVDChgVO.setEventYdCd(eventYdCd);
							updBkgForVVDChgVO.setCreUsrId(account.getUsr_id());
							copBC.updateBkgForVVDChange(updBkgForVVDChgVO);
						}
					}catch(EventException ex){
						log.error("BKG SCE updateBkgForVVDChange calling errer", ex);
					}
					// VVD 변경되면 SCE(COP)호출 끝
				}
			}
			
			eventResponse.setETCData("SuccessYn", "Y");
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
		} catch(EventException se) {
//			log.error("err " + se.toString(), se);
			/* 임종한 과장님 요청 TransMode 가 없을 경우  유저 가 알아 볼수 있도록 메시지 변경 해서 보여줌 */
			if(0<=se.getMessage().indexOf("Could not find Outbound TransMode")){
				throw new EventException(new ErrorHandler("BKG08155",new String[]{bkgBlNoVO.getBkgNo()}).getMessage(),se);
			} else {
				throw se;
			}
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0898:btn_retrieve<br>
	 * 조건에 맞는 Booking을 route 별로 group으로 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgRouteForPortAssign(Event e)throws EventException{
		try{
			EsmBkg0898Event event = (EsmBkg0898Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();  
			List<BkgRouteForPortAssignVO> list = command.searchBkgRouteForPortAssign(event.getVvd(),event.getPortCd(),event.getPol(),event.getPod(),event.getBkgOfcCd(),event.getYardCd());
			GeneralEventResponse eventResponse = new GeneralEventResponse();			 
			eventResponse.setRsVoList(list);
			if (list.isEmpty()) {
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
			}  
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_0898:sheet1_OnChange<br>
	 * route 별로 group으로 조회한 것을 기준으로 상세 Booking들을 조회한다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgListForPortAssign(Event e)throws EventException{
		try{
			EsmBkg0898Event event = (EsmBkg0898Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();  
			List<BkgListForPortAssignVO> list = command.searchBkgListForPortAssign(event.getBkgListForPortAssignInputVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();			 
			eventResponse.setRsVoList(list);
			if (list.isEmpty()) {
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
			}  
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_0898:btn_vvdportchange<br>
	 * bkg vvd port를 조회한다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgVvdForVvdPortAssign(Event e)throws EventException{
		try{
			EsmBkg0898Event event = (EsmBkg0898Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();  
			List<BkgVvdVO> list = command.searchBkgVvdForVvdPortAssign(event.getBkgBlNoVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();			 
			eventResponse.setRsVoList(list);
			if (list.isEmpty()) {
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
			}  
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
    
	/**
	 * ESM_BKG_0387:loadPage<br>
	 * Relay port를 조회한다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLoginLoc(Event e)throws EventException{
		try{			 
			BookingUtil  util  = new BookingUtil();  
			String strLocCd = util.searchLocCdByOfcCd(account.getOfc_cd());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0387Event")) { 
				EsmBkg0387Event event=(EsmBkg0387Event)e;
				if (event.getRelay().isEmpty()){
					eventResponse.setETCData("relayPort", strLocCd); 
				}else{
					eventResponse.setETCData("relayPort", event.getRelay()); 
					eventResponse.setETCData("etbFrom",event.getEtbFrom());
					eventResponse.setETCData("erbTo",event.getEtbTo());
					eventResponse.setETCData("nextVvd",event.getNextVvd());
				}
			}else{
				eventResponse.setETCData("relayPort", strLocCd); 
			}		
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_0499
	 * 화면별 TPSZSequence : OPEN<br>
	 * 컨테이너 타입 코드에 해당하는 Name 정보 조회<br>
	 * 
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTPSZSequenceList(Event e) throws EventException {
		CIMCommonBC command = new CIMCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<TypeSizeSequenceVO> typesizesequencevo = command.searchTPSZSequenceList();
			StringBuilder sb = new StringBuilder();
			if (typesizesequencevo.size() > 0) {
				for (int i = 0; i < typesizesequencevo.size() - 1; i++) {
					sb.append(typesizesequencevo.get(i).getCntrTpszCd());
					sb.append(",");
				}
				sb.append(typesizesequencevo.get(typesizesequencevo.size() - 1).getCntrTpszCd());
			}
			Map<String, String> etcData = new HashMap<String, String>();
			etcData.put("cntrTypeSize", sb.toString());
			eventResponse.setETCData(etcData);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0449
	 * 조회 옵션에 맞는 VVD 정보 조회<br>
	 * 
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortTurnTimeVVDList(Event e) throws EventException {
		TransshipmentMgtBCImpl command = new TransshipmentMgtBCImpl();		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TSTimeRptVO tSTimeRptVO;
		try {
			tSTimeRptVO =((EsmBkg0499Event)e).getTSTimeRptVO(); 
			List<TSTimeRptVO> list = command.searchPortTurnTimeVVDList(tSTimeRptVO);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0449
	 * Transit Time report in T/S port Summary를 조회한다. - UI-ESM_BKG_0499<br>
	 * 
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTSTimeRptSmry(Event e) throws EventException {
		TransshipmentMgtBCImpl command = new TransshipmentMgtBCImpl();		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TSTimeRptVO tSTimeRptVO;
		try {
			tSTimeRptVO =((EsmBkg0499Event)e).getTSTimeRptVO(); 
			List<TSTimeRptVO> list = command.searchTSTimeRptSmry(tSTimeRptVO);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0449
	 * Transit Time report in T/S port Detail을 조회한다. - UI-ESM_BKG_0499<br>
	 * 
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTSTimeRptDtl(Event e) throws EventException {
		TransshipmentMgtBCImpl command = new TransshipmentMgtBCImpl();		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TSTimeRptVO tSTimeRptVO;
		try {
			tSTimeRptVO =((EsmBkg0499Event)e).getTSTimeRptVO(); 
			List<TSTimeRptVO> list = command.searchTSTimeRptDtl(tSTimeRptVO);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_1157:btn_Retrieve<br>
	 * Booking Closing for Bayplan 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTsBkgCoffTm(Event e)throws EventException{
		try{
			EsmBkg1157Event event =(EsmBkg1157Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();
			List<BkgTsCoffTmVO> list = command.searchTsBkgCoffTm(event.getTsBkgListForBayPlanInputVO(),event.getSubChk());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			if (list.isEmpty())
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_1157:btn_Booking_Close<br>
	 * Booking Close for Bayplan 정보를 저장한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse closeTsBkgForBayPlan(Event e)throws EventException{		
		try{
			EsmBkg1157Event event = (EsmBkg1157Event)e;
			BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			begin();
			command.closeTsBkgForBayPlan(event.getBkgTsCoffTmVOs(), account);
			commit();
			eventResponse.setUserMessage(new ErrorHandler("").getUserMessage());
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			rollback();
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}				
	}
	
	/**
	 * ESM_BKG_1157:btn_Re_Open<br>
	 * Booking ReOpen for Bayplan 정보를 저장한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse reopenTsBkgForBayPlan(Event e)throws EventException{
		try{
			EsmBkg1157Event event = (EsmBkg1157Event)e;
			BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			begin();
			command.reopenTsBkgForBayPlan(event.getBkgTsCoffTmVOs(), account);
			commit();
			eventResponse.setUserMessage(new ErrorHandler("").getUserMessage());
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			rollback();
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}		
	}
	
	/**
	 * ESM_BKG_1157:loadPage<br>
	 * Closing 현황 표시 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchClzStatus(Event e)throws EventException{
		try{
			BookingUtil comboUtil = new BookingUtil();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			 List<BkgComboVO> bkg_clz_sts_list  = comboUtil.searchCombo("CD02111");
	         eventResponse.setCustomData("bkg_clz_sts_list", bkg_clz_sts_list);
	         return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}		
	}
	
	/**
	 * ESM_BKG_1157:checkTsCloseByBayPlan<br>
	 * Transshipment Close에 해당되는지 확인<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkTsCloseByBayPlan(Event e)throws EventException{
		try{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			Map<String, String> etcData = new HashMap<String, String>();

			EsmBkg1157Event event = (EsmBkg1157Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();
			String closedVvds = "";			
			String newVvd = event.getNewVvd();
			
			// ESM_BKG_0387, ESM_BKG_0950
			if(newVvd != null && newVvd.length() > 0){
				VvdAssignTargetBkgVO[] vvdAssignTargetBkgVOs = event.getVvdAssignTargetBkgVOs();
							
				closedVvds = command.checkTsCloseByBayPlan(vvdAssignTargetBkgVOs, newVvd);
			}
			// ESM_BKG_0898
			else {
				BkgVvdVO[] bkgVvdVOs = event.getBkgVvdVOs();
				BkgBlNoVO[] bkgBlNoVOs = event.getBkgBlNoVOs();
				closedVvds = command.checkTsCloseByBayPlanForVvdPortAssign(bkgVvdVOs, bkgBlNoVOs);				
			}			
			etcData.put("closedVvds", closedVvds);
			eventResponse.setETCData(etcData);
	        return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}		
	}

	/**
	 * ESM_BKG_0898:sendBkgVslReviseNotice<br>
	 * Booking Vessel Revised Notice 전송<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendBkgVslReviseNotice(Event e)throws EventException{
		try{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmBkg0898Event event = (EsmBkg0898Event)e;
			
			GeneralBookingSearchBC searchBC = new GeneralBookingSearchBCImpl();
			BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();
			
			String vslCngRsn = event.getVslCngRsn();
			BkgBlNoVO[] arrBkgBlNoVOs = event.getBkgBlNoVOs();
			List<BkgBlNoVO> bkgBlNoVOs = new ArrayList<BkgBlNoVO>();
			for(int i = 0; i < arrBkgBlNoVOs.length; i++){
				bkgBlNoVOs.add(arrBkgBlNoVOs[i]);
			}
			begin();
			List<BkgNtcHisVO> bkgNtcHisVOs = searchBC.sendBkgVslReviseNotice(bkgBlNoVOs, vslCngRsn, account);
			if (null!=bkgNtcHisVOs) {
				for (int i=0; i<bkgNtcHisVOs.size(); i++) {
					bkgNtcHisVOs.get(i).setCreUsrId(account.getUsr_id());
					bkgNtcHisVOs.get(i).setUpdUsrId(account.getUsr_id());
				}
				historyBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0898");
			}
			commit();
			return eventResponse;
		} catch(EventException se) {
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}		
	}
	
	/**
	 * NMC (Non-Manipulation Certificate) Form 조회
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNmc(Event e) throws EventException {

		EsmBkg1174Event 	event 		= (EsmBkg1174Event)e;
		String				bkgNo		= event.getBkg_no();
		String				blNo			= event.getBl_no();
		String				cntrNo		= event.getCntr_no();
		
		EventResponse eventResponse = null;
		 
		try {
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();
			eventResponse = command.searchNmc(bkgNo, blNo, cntrNo);	
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
}