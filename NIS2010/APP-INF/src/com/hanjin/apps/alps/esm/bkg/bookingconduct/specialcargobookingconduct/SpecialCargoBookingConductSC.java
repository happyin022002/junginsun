/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoBookingConductSC.java
*@FileTitle : Criteria of Out of Gauge Calculation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.06.09 이병규
* 1.0 Creation
* --------------------------------------------------------
* HISTORY
* 2010.10.12 김영철 [CHM-201006332-01] PSA AUTO EDI 수정 요청 (Special Cargo 정보 자동 전송 및 WARNING 메세지 추가)
* 2011.05.03 이재위 [CHM-201108912] [Booking] AWK 화물의 weight Check 로직 생성 요청
* 2011.07.14 김진승 [CHM-201111820] Split 03-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치
* 2011.10.21 변종건 [CHM-201113466-01] DG Cargo Application 기능 보완 요청
* 2013.08.29 김보배 [CHM-201326393] Split 01-[PRD] Inland DG constraint 관련 PC replan 대상조건 추가
* 2013.12.05 김보배 [CHM-201327753] "At Risk" RF Booking Validation 추가 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBC;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryLineVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryTableVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SpclVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgReceiptSendVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.Vender301ParamVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.basic.SpecialCargoReceiptBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.basic.SpecialCargoReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg0055Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg0106Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg0200Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg0204Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg0206Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg0498Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg0735Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg0754Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg1045Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration.SpecialCargoReceiptDBDAO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.AwkAproInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.AwkBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.AwkCgoApplVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BbAproInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BbBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BbCgoApplVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BbCntrListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgAwkCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgAwkDimVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgBbCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgDgCgoInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgRfCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.CntrComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.CntrInfoListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.CntrTypzQtyVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgAproInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgCgoApplVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgCgoListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgPackageVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgPreCheckingStatusVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.ImdgPckDescVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.RfAproInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.RfBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.RfCgoApplVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.ScgImdgUnNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SegrGrpVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SpclCgoAproApplVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SpclReqInVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.basic.SpecialCargoRiderBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.basic.SpecialCargoRiderBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.event.EsmBkg0207Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.event.EsmBkg0369Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.event.EsmBkg0742Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.AttachFileInVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.AttachFileOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.BlRiderInVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.BlRiderOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.SpclCntrListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.SpclRiderInVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.SpclRiderOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.SpclRiderVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.ContainerVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.basic.PSAManifestBC;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.basic.PSAManifestBCImpl;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBC;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.basic.OwnDangerousCargoApprovalBC;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.basic.OwnDangerousCargoApprovalBCImpl;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionInputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionOutputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.basic.PartnerLinesDangerousCargoApprovalBC;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.basic.PartnerLinesDangerousCargoApprovalBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;
import com.hanjin.syscommon.common.table.BkgImgStoVO;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
import com.hanjin.syscommon.common.table.MasBkgComIfVO;
import com.hanjin.syscommon.common.table.ScgAproRqstVO;
import com.hanjin.syscommon.common.table.ScgVvdAproRqstVO;
import com.hanjin.syscommon.common.util.ComFileUtil;



/**
 * ALPS-SpecialCargoBookingConduct Business Logic ServiceCommand - ALPS-SpecialCargoBookingConduct 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author Lee Byung Kyu
 * @see SpecialCargoReceiptDBDAO
 * @since J2EE 1.6
 */

public class SpecialCargoBookingConductSC extends ServiceCommandSupport { 
	// Login User Information
	private SignOnUserAccount account = null; 

	/**
	 * SpecialCargoBookingConduct system 업무 시나리오 선행작업<br>
	 * ESM_BKG_0057업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("SpecialCargoBookingConductSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * SpecialCargoBookingConduct system 업무 시나리오 마감작업<br>
	 * ESM_BKG_0057 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("SpecialCargoBookingConductSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-SpecialCargoBookingConduct system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;		
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmBkg0055Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				
				eventResponse = searchAwkCargo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {				
				eventResponse = searchAwkDim(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {				
				eventResponse = manageAwkCargo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {				
				eventResponse = manageSpclCgoApro(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {				
				eventResponse = searchDimension(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {				
				eventResponse = searchGrsMaxWgt(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0200Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				
				eventResponse = searchDgCargo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {				
				eventResponse = manageDgCargo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {				
				eventResponse = manageSpclCgoApro(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)) {
				eventResponse = validateSpecialCargo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {				
				eventResponse = searchSegrGrp(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {				
				eventResponse = searchSpclProviNo(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0498Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				
				eventResponse = searchRfCargo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {				
				eventResponse = manageRfCargo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {				
				eventResponse = manageSpclCgoApro(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)) {				
				eventResponse = searchCmdtCd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND06)) {				
				eventResponse = searchCLLVVD(e);	
			}						
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0106Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				
				eventResponse = searchBbCargo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {				
				eventResponse = manageBbCargo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {				
				eventResponse = manageSpclCgoApro(e);
			}			
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0204Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				
				eventResponse = searchDgUnNumber(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {				
				eventResponse = searchDgUnNumber(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg1045Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				
				eventResponse = searchDgPackage(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0754Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				
				eventResponse = searchDgSequence(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {				
				eventResponse = searchDgSequence(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0369Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBlRiderList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBlRider(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0207Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSpclRiderList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSpclRider(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0742Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAttachFileList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0206Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				
				eventResponse = searchImdgPckDesc(e);
			}		
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0735Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {				
				eventResponse = searchDgCargoFromOldBkg(e);
			}
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0742 조회 이벤트 처리<br>
	 * B/L Rider & DG Rider 파일 업로드 현황  리스트 조회 이벤트 처리<br>
	 * @author LEE JIN SEO
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAttachFileList(Event e) throws EventException {
		log.debug("[START:: SpecialCargoBookingConductSC == searchAttachFileList SEARCH ]==========");
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialCargoRiderBC command = new SpecialCargoRiderBCImpl();

		//1.로직 처리전 Event 객체에서 값을 입력하거나 선택된 값으로 설정해준다.
		EsmBkg0742Event event = (EsmBkg0742Event)e;
		AttachFileInVO attachFileInVO = event.getAttachFileInVO();

		try{
			//2.로직 처리 실행
			List<AttachFileOutVO> list = command.searchAttachFileList(attachFileInVO);

			//3.로직 처리후 결과처리
			eventResponse.setRsVoList(list);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		log.debug("[END::]==========");
		return eventResponse;
	}

	/**
	 * ESM_BKG_0369 조회 이벤트 처리<br>
	 * b/l의 rider image 정보 list를 조회 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * @author LEE JIN SEO
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBlRiderList(Event e) throws EventException {
		log.debug("[START:: SpecialCargoBookingConductSC == searchBlRiderList SEARCH ]==========");
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialCargoRiderBC command = new SpecialCargoRiderBCImpl();

		//1.로직 처리전 Event 객체에서 값을 입력하거나 선택된 값으로 설정해준다.
		EsmBkg0369Event event = (EsmBkg0369Event)e;
		BlRiderInVO blRiderInVO = event.getBlRiderInVO();
		blRiderInVO.setAccount(account);

		try{
			//2.로직 처리 실행
			List<BlRiderOutVO> list = command.searchBlRiderList(event.getBlRiderInVO());

			//3.로직 처리후 결과처리
			eventResponse.setRsVoList(list);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		log.debug("[END::]==========");
		return eventResponse;
	}

	/**
	 * ESM_BKG_0369 저장 이벤트 처리<br>
	 * b/l의 rider image 정보를 생성 처리<br>
	 * @author LEE JIN SEO
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBlRider(Event e) throws EventException {
		log.debug("[START:: SpecialCargoBookingConductSC == manageBlRider SEARCH ]==========");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialCargoRiderBC command = new SpecialCargoRiderBCImpl();
		//1.로직 처리전 Event 객체에서 값을 입력하거나 선택된 값으로 설정해준다.
		EsmBkg0369Event event = (EsmBkg0369Event)e;
		BlRiderInVO blRiderInVO = event.getBlRiderInVO();
		blRiderInVO.setAccount(account);

		try{
			//2.로직 처리 실행
			begin();
			command.manageBlRider(blRiderInVO);
			commit();

			//3.로직 처리후 결과처리
			eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());  //BKG00102 : 저장성공

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		log.debug("[END::]==========");
		return eventResponse;
	}


	/**
	 * ESM_BKG_0207 조회 이벤트 처리<br>
	 * b/l의 SpclRider image 정보 list를 조회 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * @author LEE JIN SEO
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpclRiderList(Event e) throws EventException {
		log.debug("[START:: SpecialCargoBookingConductSC == searchSpclRiderList SEARCH ]==========");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialCargoRiderBC command = new SpecialCargoRiderBCImpl();

		//1.로직 처리전 Event 객체에서 값을 입력하거나 선택된 값으로 설정해준다.
		EsmBkg0207Event event = (EsmBkg0207Event)e;
		SpclRiderInVO spclRiderInVO = event.getSpclRiderInVO();
		spclRiderInVO.setAccount(account);

		try{
			//2.로직 처리 실행
			SpclRiderOutVO spclRiderOutVO = command.searchSpclRiderList(event.getSpclRiderInVO());

			List<SpclRiderVO> spclRiderList = spclRiderOutVO.getO_spclRiderVO();
			
			/* 메일 보내기 오류로 인한 파일존재하지는지 체크 여부 */
			if(spclRiderList.size() > 0){
				Iterator<SpclRiderVO> SpclRiderVOs = spclRiderList.iterator();
	        	while(SpclRiderVOs.hasNext()){
	        		ComFileUtil fileUtil = new ComFileUtil();
	        		SpclRiderVO riderVo = (SpclRiderVO)SpclRiderVOs.next();
	        		if(riderVo.getFileSavId() != null && !riderVo.getFileSavId().equals("")){
						if(!fileUtil.fileDeleteCheck(riderVo.getFileSavId())){
							BkgImgStoVO delVo = new BkgImgStoVO();
							delVo.setBkgNo(riderVo.getBkgNo());
							delVo.setFileSavId(riderVo.getFileSavId());
							delVo.setImgSeq(riderVo.getImgSeq());
							command.removeSpclRider(delVo);
							SpclRiderVOs.remove();
						}
					}
	        	}
			}
			
			List<SpclCntrListVO> spclCntrList = spclRiderOutVO.getO_spclCntrListVO();

			//화면단에서 컨트롤하기 어려워 컨터이너 데이터 가공처리
			StringBuffer cBoxBuf = new StringBuffer("");

			cBoxBuf.append("<table width='100%' class='grid2' border='0' id= t_table>");
			if(spclCntrList.size() > 0){
				Iterator<SpclCntrListVO> list = spclCntrList.iterator();
	        	while(list.hasNext()){
	        		SpclCntrListVO spclCntrListVO = (SpclCntrListVO)list.next();
	        		cBoxBuf.append("<tr class='tr2_head'><td width='10%' align='center'>");
	        		cBoxBuf.append("<input type='checkbox' name='t_check'  value='"+spclCntrListVO.getCargoValue()+"'></td>");
	        		cBoxBuf.append("<td width='90%' align='center'>"+spclCntrListVO.getCargoName()+"</td>");
	        		cBoxBuf.append("<input type='hidden' name='t_name' value='"+spclCntrListVO.getCargoName()+"'></tr>");
	        	}
			}else{
				cBoxBuf.append("<tr class='tr2_head'><td width='10%' align='center'>");
				cBoxBuf.append("no data... </td></tr>");
			}
			cBoxBuf.append("</table>");

        	String checkBoxString = cBoxBuf.toString();

			//3.로직 처리후 결과처리
        	eventResponse.setETCData("checkBoxString", checkBoxString);
			eventResponse.setRsVoList(spclRiderList);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		log.debug("[END::]==========");
		return eventResponse;
	}

	/**
	 * ESM_BKG_0207 저장 이벤트 처리<br>
	 * b/l의 SpclRider image  정보를 생성 처리<br>
	 * @author LEE JIN SEO
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSpclRider(Event e) throws EventException {
		log.debug("[START:: SpecialCargoBookingConductSC == manageSpclRider SEARCH ]==========");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialCargoRiderBC command = new SpecialCargoRiderBCImpl();

		//1.로직 처리전 Event 객체에서 값을 입력하거나 선택된 값으로 설정해준다.
		EsmBkg0207Event event = (EsmBkg0207Event)e;
		SpclRiderInVO spclRiderInVO = event.getSpclRiderInVO();
		spclRiderInVO.setAccount(account);

		try{
			//2.로직 처리 실행
			begin();
			command.manageSpclRider(spclRiderInVO);
			commit();

			//3.로직 처리후 결과처리
			eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());  //BKG00102 : 저장성공

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		log.debug("[END::]==========");
		return eventResponse;
	}

	/**
	 * ESM_BKG_0055 조회 이벤트 처리<br>
	 * special cargo list를 조회 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAwkCargo(Event e) throws EventException {
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0055Event event = (EsmBkg0055Event) e;        
        BookingUtil utilCmd = new BookingUtil();        
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();        
        String bkgNo      = event.getBkgNo();
        String blNo       = event.getBlNo();
                
        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
		bkgBlNoIN.setBkgNo(event.getBkgNo());
		bkgBlNoIN.setBlNo(event.getBlNo());
        bkgBlNoIN.setCaUsrId(account.getUsr_id());
               
        try{         	
        	if(bkgNo==null || bkgNo.length()==0){
                if(blNo!=null && blNo.length()>0){
                    bkgNo = utilCmd.searchBkgNoByBlNo(blNo);
                }
            }  
        	
        	BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
        	
        	log.debug("bkgBlNoVO.value======"+bkgBlNoVO);
        	
        	//AwkCgoApplVO applVo = command.searchAwkCargo(bkgNo, blNo, bkgBlNoVO.getCaFlg());
        	AwkCgoApplVO applVo =  new AwkCgoApplVO();
        	
        	if(bkgBlNoVO != null){
        		applVo = command.searchAwkCargo(bkgNo, blNo, bkgBlNoVO.getCaFlg());
        	}else{
        		applVo = command.searchAwkCargo(bkgNo, blNo, "");
        	}
        	 
        	// Awkawrd Criteria 조회
			BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
			bkgHrdCdgCtntListCondVO.setHrdCdgId("AWK_CRITERIA");
			List<BkgHrdCdgCtntVO> hrdCdgList = utilCmd.searchHardCoding(bkgHrdCdgCtntListCondVO);
			
        	List<AwkBkgInfoVO> awkBkgInfo = applVo.getAwkBkgInfo();
        	AwkAproInfoVO awkAproInfo = applVo.getAwkAproInfo();
            List<BkgAwkCgoVO> bkgAwkCgo = applVo.getBkgAwkCgoVO();
            List<CntrTypzQtyVO> typzQtys = applVo.getCntrTypzQty();
            List<CntrComboVO> cntrCombo = applVo.getCntrCombo();
            List<BkgAwkDimVO> bkgAwkDim = applVo.getBkgAwkDim();                            
            eventResponse.setETCData(awkAproInfo.getColumnValues());                            
            eventResponse.setRsVoList(bkgAwkCgo);
            eventResponse.setRsVoList(typzQtys);
            eventResponse.setRsVoList(awkBkgInfo);
            eventResponse.setRsVoList(cntrCombo);
            eventResponse.setRsVoList(bkgAwkDim);
            eventResponse.setRsVoList(hrdCdgList);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }	
	
	/**
	 * ESM_BKG_0055 Dimension List 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAwkDim(Event e) throws EventException {
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0055Event event = (EsmBkg0055Event) e;        
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl(); 
        BookingUtil utilCmd = new BookingUtil();    
        String bkgNo      = event.getBkgNo();
        
        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
        bkgBlNoIN.setBkgNo(event.getBkgNo());
        bkgBlNoIN.setCaUsrId(account.getUsr_id());
		               
        try{
        	BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
        	
        	AwkCgoApplVO applVo = command.searchAwkDim(bkgNo, bkgBlNoVO.getCaFlg());        	
            List<BkgAwkDimVO> bkgAwkDim = applVo.getBkgAwkDim();              	
            eventResponse.setRsVoList(bkgAwkDim);           
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
	 * ESM_BKG_0756 Dimension List 조회 팝업 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDimension(Event e) throws EventException {
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0055Event event = (EsmBkg0055Event) e;        
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl(); 
        BookingUtil utilCmd = new BookingUtil();  
        String bkgNo      = event.getBkgNo();
        String akwCgoSeq      = event.getAwkCgoSeq();
        
        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
        bkgBlNoIN.setBkgNo(event.getBkgNo());
        bkgBlNoIN.setCaUsrId(account.getUsr_id());
               
        try{
        	BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
        	
        	AwkCgoApplVO applVo = command.searchDimension(bkgNo, akwCgoSeq, bkgBlNoVO.getCaFlg());        	
            List<BkgAwkDimVO> bkgAwkDim = applVo.getBkgAwkDim();              	
            eventResponse.setRsVoList(bkgAwkDim);           
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
	 * ESM_BKG_0055 Gross Max Weight 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGrsMaxWgt(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0055Event event = (EsmBkg0055Event) e;        
		SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl(); 
		String bkgNo = "";
		String cntrNo = "";
		String grsWgt = "";
		String cntrTpszCd = "";
		String wgtUtCd = "";

		try{
    		bkgNo = event.getBkgAwkCgoVO().getBkgNo();
    		cntrNo = event.getBkgAwkCgoVO().getCntrNo();
    		grsWgt = event.getBkgAwkCgoVO().getGrsWgt();
    		cntrTpszCd = event.getBkgAwkCgoVO().getCntrTpszCd();
    		wgtUtCd = event.getBkgAwkCgoVO().getWgtUtCd();

    		eventResponse = (GeneralEventResponse)command.searchGrsMaxWgt(bkgNo,cntrNo,grsWgt,cntrTpszCd, wgtUtCd);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0055 Special Cargo List 저장 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAwkCargo(Event e) throws EventException {

        EsmBkg0055Event event = (EsmBkg0055Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();        
        BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
        BookingUtil utilCmd = new BookingUtil();
        AwkCgoApplVO awkCgoApplVO = new AwkCgoApplVO(); 
        BLDocumentationCMBC bldocCmd = new BLDocumentationCMBCImpl();
        BookingARCreationBC arCmd = new BookingARCreationBCImpl();
        GeneralBookingReceiptBC generalCmd= new GeneralBookingReceiptBCImpl();
        ARBkgInterfaceCreationVO bkgIfVO = new ARBkgInterfaceCreationVO();        
        HistoryTableVO historyTableVO = null;
        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();        
        SpclVO spclVO = new SpclVO();                
        
        awkCgoApplVO.setBkgAwkCgoVOs(event.getBkgAwkCgoVOs());
        awkCgoApplVO.setBkgAwkDimVOs(event.getBkgAwkDimVOs());
        awkCgoApplVO.setAccount(account);       
        String uiId = "ESM_BKG_0055";        
        String bkgNo = event.getBkgNo();        
        String spclTp = "AWK";            
        String cntrNo = "";        
        awkCgoApplVO.setBkgNo(bkgNo);        
        bkgBlNoIN.setBkgNo(bkgNo);
        bkgBlNoIN.setCaUsrId(account.getUsr_id());

        GeneralBookingSearchBC genSearchCmd = new GeneralBookingSearchBCImpl();  
        
        try{        	
        	//String caFlg = utilCmd.searchBkgCaStatus(bkgBlNoIN);
        	BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
        	
			if (bkgBlNoVO.getCaFlg() == null || bkgBlNoVO.getBkgNo() == null) {
				throw new RuntimeException(new ErrorHandler("BKG01049", new String[] { event.getBkgNo() }).getMessage());
			}			
			historyTableVO = histCmd.searchOldBkgForHistory(uiId, bkgBlNoVO);
			
			//if ("Y".equals(caFlg)) {
				//correctCmd.modifyCngScreenFlag(uiId, bkgBlNoIN);  //사용않함으로 변경됨.
			//}        	
        	begin();         	
        	//utilCmd.searchBkgBlNoVO (bkgBlNoVO);        	
        	command.manageAwkCargo(awkCgoApplVO, bkgBlNoVO.getCaFlg());         	
        	bldocCmd.modifyCntrFlgBySpcl2(bkgNo, spclTp, cntrNo, bkgBlNoVO.getCaFlg()); 
        	bldocCmd.modifyCntrFlgBySpcl(bkgNo, spclTp, cntrNo, bkgBlNoVO.getCaFlg()); 
        	if(awkCgoApplVO.getBkgAwkCgoVOs() != null){
	        	for (int i = 0; i < awkCgoApplVO.getBkgAwkCgoVOs().length; i++) {         		
	        		spclVO.setBkgNo(awkCgoApplVO.getBkgAwkCgoVOs()[i].getBkgNo());
	        		spclVO.setSpclTp(spclTp);
	        		spclVO.setCntrVolQty(awkCgoApplVO.getBkgAwkCgoVOs()[i].getCntrVolQty());
	        		spclVO.setCntrTpszCd(awkCgoApplVO.getBkgAwkCgoVOs()[i].getCntrTpszCd());         		
	        		generalCmd.modifyBkgBySpcl(spclVO, bkgBlNoVO.getCaFlg());   
	        	}        
        	}
        	
        	//String caFlg = utilCmd.searchBkgCaStatus(bkgBlNoVO);         	
        	String newStsCd = "W";        	
        	bkgBlNoVO.setCaFlg(bkgBlNoVO.getCaFlg());        	
        	boolean bkgStsChgFlg = false;

       		bkgStsChgFlg = generalCmd.changeBkgStatus(newStsCd, bkgBlNoVO, bkgStsChgFlg, account);   

        	if(bkgStsChgFlg == true && "N".equals(bkgBlNoVO.getCaFlg())){
        		bkgIfVO.setBkgNo(bkgBlNoVO.getBkgNo());
    	        bkgIfVO.setManDivInd("B");
    	        bkgIfVO.setUserId(account.getUsr_id());
            	arCmd.interfaceBKGARInvoiceToINV(bkgIfVO); 
            	
        		CostAssignBC masBc = new CostAssignBCImpl();
//    			CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
//    			coaBkgComIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
//    			coaBkgComIfVo.setCostSrcSysCd("BKG");
//    			coaBkgComIfVo.setIfRmk("Booking Status Change");
//    			coaBkgComIfVo.setCreUsrId(account.getUsr_id());
//    			coaBkgComIfVo.setUpdUsrId(account.getUsr_id());
        		
        		MasBkgComIfVO masBkgComIfVo = new MasBkgComIfVO();
    			masBkgComIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
    			masBkgComIfVo.setCostSrcSysCd("BKG");
    			masBkgComIfVo.setIfRmk("Booking Status Change");
    			masBkgComIfVo.setCreUsrId(account.getUsr_id());
    			masBkgComIfVo.setUpdUsrId(account.getUsr_id());
    			
//    			coaBc.modifyCoaCommonInterface(coaBkgComIfVo);
    			masBc.modifyMasCommonInterface(masBkgComIfVo);
        	}
        	
        	histCmd.manageBookingHistory(uiId, historyTableVO, account);        	

    		// Cntr No가 수정이 되면 Vender 301이 전송되도록 하기 위하여 Flg를 만들었음. ( 경종윤 수석님 요청 - 2010.08.26 )
//            String bracCd = "U";
//            String ediKind = "BT";
        	if ( "Y".equals(event.getAwkChkFlg()) ) {
				
        		// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
        		Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
				vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
				vender301ParamVO.setOldVvdVOs(null);
				vender301ParamVO.setOldQtyVOs(null);
				vender301ParamVO.setOldMtyPkupYdCd(null);
				vender301ParamVO.setBracCd("U");
				vender301ParamVO.setEdiKind("BT");
				vender301ParamVO.setAutoManualFlg("Y");
				vender301ParamVO.setRcvId("");
				
	        	List<BkgNtcHisVO> bkgNtcHisVOs = genSearchCmd.createTmlBkgReceiptEdi(vender301ParamVO, account);   
	        	histCmd.createBkgNtcHis(bkgNtcHisVOs, uiId);
        	}
	        	
            commit();         
            if ( "Y".equals(event.getAwkChkFlg()) ) {
	        	// DG 저장시에 PSA 전송되도록 수정함. [CHM-201006332-01]
	        	eventResponse.setETCData("psaValCode", this.managePSABKGAuto(bkgBlNoVO.getBkgNo(), "N"));
        	}
            eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());            
        }catch(EventException ex){
            rollback();
            eventResponse.setUserMessage(ex.getMessage());
            throw ex;
        }catch(Exception ex){
            rollback();
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
	 * ESM_BKG_0200 조회 이벤트 처리<br>
	 * special cargo list를 조회 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDgCargo(Event e) throws EventException {
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0200Event event = (EsmBkg0200Event) e;        
        BookingUtil utilCmd = new BookingUtil();        
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();        
        String bkgNo      = event.getBkgNo();
        String blNo       = event.getBlNo();
        String oldBkgNo   = event.getOldBkgNo();
        boolean searchCntrFlag = false;
        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
        bkgBlNoIN.setBkgNo(bkgNo);
        bkgBlNoIN.setCaUsrId(account.getUsr_id());
        
        try{       	
        	if(bkgNo==null || bkgNo.length()==0){
                if(blNo!=null && blNo.length()>0){
                    bkgNo = utilCmd.searchBkgNoByBlNo(blNo);
                }
            }  
        	
        	BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
        	
        	DgCgoApplVO applVo = new DgCgoApplVO();
        	
        	
        	// 이전 bkgNo와 현재 bkgNo가 틀린경우 Container 정보 조회하도록 Flag 변경.
	      	if(bkgNo != null && !bkgNo.equals(oldBkgNo)){
	      		searchCntrFlag = true;
	      	}
        	
        	if(bkgBlNoVO != null){
        		applVo = command.searchDgCargo(bkgNo, blNo, bkgBlNoVO.getCaFlg(), searchCntrFlag);              
        	}else{
        		applVo = command.searchDgCargo(bkgNo, blNo, "", searchCntrFlag);       
        	}
        	
        	List<DgBkgInfoVO> dgBkgInfo = applVo.getDgBkgInfo();
        	DgAproInfoVO dgAproInfo = applVo.getDgAproInfo();
            List<BkgDgCgoInfoVO> bkgDgCgo = applVo.getBkgDgCgoInfo();
            List<DgCgoListVO> dgCgoList = applVo.getDgCgoList();
            List<CntrTypzQtyVO> typzQtys = applVo.getCntrTypzQty();
            List<CntrComboVO> cntrCombo = applVo.getCntrCombo();
            List<CntrInfoListVO> cntrInfoList = applVo.getCntrInfoList();                            
        	eventResponse.setETCData(dgAproInfo.getColumnValues());                            
            eventResponse.setRsVoList(bkgDgCgo);
            eventResponse.setRsVoList(dgCgoList);
            eventResponse.setRsVoList(typzQtys);
            eventResponse.setRsVoList(dgBkgInfo);
            eventResponse.setRsVoList(cntrCombo);
            eventResponse.setRsVoList(cntrInfoList);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
	
	
	/**
	 * ESM_BKG_0200 Special Cargo List 저장 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDgCargo(Event e) throws EventException {
		EsmBkg0200Event event = (EsmBkg0200Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();         
        BookingHistoryMgtBC 	histCmd 	= new BookingHistoryMgtBCImpl();
        BookingUtil 			utilCmd 	= new BookingUtil(); 
        BLDocumentationCMBC 	bldocCmd 	= new BLDocumentationCMBCImpl();
        GeneralBookingSearchBC  genSearchCmd= new GeneralBookingSearchBCImpl();  
        GeneralBookingReceiptBC generalCmd	= new GeneralBookingReceiptBCImpl(); 
              
        PartnerLinesDangerousCargoApprovalBC dgCgoApplBC 	= new PartnerLinesDangerousCargoApprovalBCImpl();
       
        DgCgoApplVO dgCgoApplVO = new DgCgoApplVO();  
        SpclVO spclVO = new SpclVO();        
        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();                         
        
        dgCgoApplVO.setDgCgoListVOs(event.getDgCgoListVOs());                     
        HistoryTableVO historyTableVO = null;    	
        dgCgoApplVO.setAccount(account);
        String bkgNo = event.getBkgNo();                
        String uiId = "ESM_BKG_0200";        
        String spclTp = "DG";        
        String cntrNo = "";        
        dgCgoApplVO.setBkgNo(bkgNo);        
        bkgBlNoIN.setBkgNo(bkgNo);	
        bkgBlNoIN.setCaUsrId(account.getUsr_id());

        String bracCd = "U";
        String ediKind = "BT";
               
        try{
        	//String caFlg = utilCmd.searchBkgCaStatus(bkgBlNoIN); 
        	BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
        	
			if (bkgBlNoVO.getCaFlg() == null || bkgBlNoVO.getBkgNo() == null) {
				throw new RuntimeException(new ErrorHandler("BKG01049", new String[] { event.getBkgNo() }).getMessage());
			}			
			historyTableVO = histCmd.searchOldBkgForHistory(uiId, bkgBlNoVO);			
			//if ("Y".equals(caFlg)) {
				//correctCmd.modifyCngScreenFlag(uiId, bkgBlNoIN);  //사용않함으로 변경됨.
			//}       	
        	begin();        	
        	command.manageDgCargo(dgCgoApplVO, bkgBlNoVO.getCaFlg()); 
        	ProductCatalogCreateBC prdBc = new ProductCatalogCreateBCImpl();
            prdBc.searchPrdImDgConstraint(bkgBlNoVO.getPctlNo(), bkgBlNoVO.getBkgNo());
            commit();             
            bldocCmd.modifyCntrFlgBySpcl2(bkgNo, spclTp, cntrNo, bkgBlNoVO.getCaFlg()); 
        	bldocCmd.modifyCntrFlgBySpcl(bkgNo, spclTp, cntrNo, bkgBlNoVO.getCaFlg());      	
        	
        	for (int i = 0; i < dgCgoApplVO.getDgCgoListVOs().length; i++) {        		
        		spclVO.setBkgNo(dgCgoApplVO.getDgCgoListVOs()[i].getBkgNo());
        		spclVO.setSpclTp(spclTp);
        		spclVO.setCntrVolQty(dgCgoApplVO.getDgCgoListVOs()[i].getCntrVolQty());
        		spclVO.setCntrTpszCd(dgCgoApplVO.getDgCgoListVOs()[i].getCntrTpszCd());        		
        		generalCmd.modifyBkgBySpcl(spclVO, bkgBlNoVO.getCaFlg());   
        	}            
        	
        	//String caFlg = utilCmd.searchBkgCaStatus(bkgBlNoVO);         	
        	String newStsCd = "W";        	
        	bkgBlNoVO.setCaFlg(bkgBlNoVO.getCaFlg());        	
        	boolean bkgStsChgFlg = false;        	

        	bkgStsChgFlg = generalCmd.changeBkgStatus(newStsCd, bkgBlNoVO, bkgStsChgFlg, account);   

        	// dg pre checking status 조회
        	PreRestrictionInputVO preRestrictionInputVO = new PreRestrictionInputVO();
        	preRestrictionInputVO.setInnerPreRestrictionInputVO(event.getPreRestrictionInputVO());
        	preRestrictionInputVO.setInnerPreRestrictionInputVOS(event.getPreRestrictionInputVOS());
        	preRestrictionInputVO.setInnerScgPrnrAproRqstCgoVOS(event.getScgPrnrAproRqstCgoVOS());
        	
        	PreRestrictionOutputVO vo = dgCgoApplBC.searchPreCheckingSummaryList(preRestrictionInputVO);

        	String crrPreChkCd = "1";
        	String oprPreChkCd = "1";
        	String segrPreChkCd = "1";
        	String pckPreChkCd = "1";
        	for(int i = 0; i < vo.getScgPrnrAproRqstCgoVOs().size(); i++){
                if(!crrPreChkCd.equals("R")){
                    if(crrPreChkCd.equals("1")){
                               crrPreChkCd = vo.getScgPrnrAproRqstCgoVOs().get(i).getCrrFlg();
                    } else {
                    	if(crrPreChkCd.equals("O") && vo.getScgPrnrAproRqstCgoVOs().get(i).getCrrFlg().equals("X")){
                    		crrPreChkCd = "X";
                       	}else{
                       		crrPreChkCd = vo.getScgPrnrAproRqstCgoVOs().get(i).getCrrFlg();
                       	}
                    }
                }
                if(!oprPreChkCd.equals("R")){                             
                    if(oprPreChkCd.equals("1")){
                    	oprPreChkCd = vo.getScgPrnrAproRqstCgoVOs().get(i).getPortFlg();
                    } else {
                    	if(oprPreChkCd.equals("O") && vo.getScgPrnrAproRqstCgoVOs().get(i).getPortFlg().equals("X")){
                    		oprPreChkCd = "X";
                    	}else{
                    		oprPreChkCd = vo.getScgPrnrAproRqstCgoVOs().get(i).getPortFlg();
                    	}
                    }
                }
 
        		if(segrPreChkCd.equals("1")){
        			segrPreChkCd = vo.getScgPrnrAproRqstCgoVOs().get(i).getSegFlg();
        		} else {
        			if(segrPreChkCd.equals("O")
        					&& vo.getScgPrnrAproRqstCgoVOs().get(i).getSegFlg().equals("X")){
        				segrPreChkCd = "X";
        			}
        		}     
        		if(vo.getScgPrnrAproRqstCgoVOs().get(i).getPiFlg().equals("N/A")){
        			vo.getScgPrnrAproRqstCgoVOs().get(i).setPiFlg("O");
        		}
        		if(pckPreChkCd.equals("1")){
        			pckPreChkCd = vo.getScgPrnrAproRqstCgoVOs().get(i).getPiFlg();
        		} else {
        			if(pckPreChkCd.equals("O")
        					&& vo.getScgPrnrAproRqstCgoVOs().get(i).getPiFlg().equals("X")){
        				pckPreChkCd = "X";
        			}
        			if(pckPreChkCd.equals("O")
        					&& vo.getScgPrnrAproRqstCgoVOs().get(i).getPiFlg().equals("M")){
        				pckPreChkCd = "M";
        			}
        		}  
        	}
        	DgPreCheckingStatusVO dgPreCheckingStatusVO = new DgPreCheckingStatusVO();
        	dgPreCheckingStatusVO.setCrrPreChkCd(crrPreChkCd);
        	dgPreCheckingStatusVO.setOprPreChkCd(oprPreChkCd);
        	dgPreCheckingStatusVO.setSegrPreChkCd(segrPreChkCd);
        	dgPreCheckingStatusVO.setPckPreChkCd(pckPreChkCd);
        	generalCmd.modifyDGPreChkSts(bkgBlNoVO, dgPreCheckingStatusVO, account);
        	
        	if(bkgStsChgFlg == true && "N".equals(bkgBlNoVO.getCaFlg())){
                BookingARCreationBC arCmd = new BookingARCreationBCImpl();  
                ARBkgInterfaceCreationVO bkgIfVO = new ARBkgInterfaceCreationVO();
        		bkgIfVO.setBkgNo(bkgBlNoVO.getBkgNo());
    	        bkgIfVO.setManDivInd("B");
    	        bkgIfVO.setUserId(account.getUsr_id());
            	arCmd.interfaceBKGARInvoiceToINV(bkgIfVO); 
            	
//        		CostAssignBC coaBc = new CostAssignBCImpl();
//    			CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
//    			coaBkgComIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
//    			coaBkgComIfVo.setCostSrcSysCd("BKG");
//    			coaBkgComIfVo.setIfRmk("Booking Status Change");
//    			coaBkgComIfVo.setCreUsrId(account.getUsr_id());
//    			coaBkgComIfVo.setUpdUsrId(account.getUsr_id());
//    			
//    			coaBc.modifyCoaCommonInterface(coaBkgComIfVo);
            	
            	CostAssignBC masBc = new CostAssignBCImpl();
    			MasBkgComIfVO masBkgComIfVo = new MasBkgComIfVO();
    			masBkgComIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
    			masBkgComIfVo.setCostSrcSysCd("BKG");
    			masBkgComIfVo.setIfRmk("Booking Status Change");
    			masBkgComIfVo.setCreUsrId(account.getUsr_id());
    			masBkgComIfVo.setUpdUsrId(account.getUsr_id());
    			
    			masBc.modifyMasCommonInterface(masBkgComIfVo);
        	}   	
	        	
	        histCmd.manageBookingHistory(uiId, historyTableVO, account);
	        
    		// Cntr No가 수정이 되면 Vender 301이 전송되도록 하기 위하여 Flg를 만들었음. ( 경종윤 수석님 요청 - 2010.08.26 )
        	if ( "Y".equals(event.getDgChkFlg()) ) {        		
        		// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
        		Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
				vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
				vender301ParamVO.setOldVvdVOs(null);
				vender301ParamVO.setOldQtyVOs(null);
				vender301ParamVO.setOldMtyPkupYdCd(null);
				vender301ParamVO.setBracCd(bracCd);
				vender301ParamVO.setEdiKind(ediKind);
				vender301ParamVO.setAutoManualFlg("Y");
				vender301ParamVO.setRcvId("");
				
	        	List<BkgNtcHisVO> bkgNtcHisVOs = genSearchCmd.createTmlBkgReceiptEdi(vender301ParamVO, account);        	
	        	histCmd.createBkgNtcHis(bkgNtcHisVOs, uiId);
	        	// DG 저장시에 PSA 전송되도록 수정함. [CHM-201006332-01]
	        	eventResponse.setETCData("psaValCode", this.managePSABKGAuto(bkgBlNoVO.getBkgNo(), "N"));
        	}
            eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());            
        }catch(EventException ex){
            rollback();
            eventResponse.setUserMessage(ex.getMessage());  
            throw ex;
        }catch(Exception ex){
            rollback();
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
	 * ESM_BKG_0735 Copy From Old Booking 조회 이벤트 처리 <br>
	 * Copy From Old Booking 조회 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDgCargoFromOldBkg(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0735Event event = (EsmBkg0735Event) e;        
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();        
        String bkgNo   = event.getBkgNo(); // original booking
        
        try{       	
        	DgCgoApplVO applVo = new DgCgoApplVO();
        	
        	applVo = command.searchDgCargoFromOldBkg(bkgNo, "", "N", false);     

            List<DgCgoListVO> dgCgoList = applVo.getDgCgoList();
            
            eventResponse.setRsVoList(dgCgoList);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
	 * ESM_BKG_0498 조회 이벤트 처리<br>
	 * special cargo list를 조회 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRfCargo(Event e) throws EventException {
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0498Event event = (EsmBkg0498Event) e;        
        BookingUtil utilCmd = new BookingUtil();        
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();        
        String bkgNo      = event.getBkgNo();
        String blNo       = event.getBlNo();
        
        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();  
        bkgBlNoIN.setBkgNo(bkgNo);	
        bkgBlNoIN.setCaUsrId(account.getUsr_id());
               
        try{       	
        	if(bkgNo==null || bkgNo.length()==0){
                if(blNo!=null && blNo.length()>0){
                    bkgNo = utilCmd.searchBkgNoByBlNo(blNo);
                }
            }  
        	
        	BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
        	
        	RfCgoApplVO applVo = new RfCgoApplVO();
        	
        	if(bkgBlNoVO != null){        	
        		applVo = command.searchRfCargo(bkgNo, blNo, bkgBlNoVO.getCaFlg());  
        	}else{
        		applVo = command.searchRfCargo(bkgNo, blNo, "");  
        	}
        	
        	List<RfBkgInfoVO> rfBkgInfo = applVo.getRfBkgInfoVO();
        	RfAproInfoVO rfAproInfo = applVo.getRfAproInfoVO();
            List<BkgRfCgoVO> bkgRfCgo = applVo.getBkgRfCgoVO();
            List<CntrTypzQtyVO> typzQtys = applVo.getCntrTypzQty();
            List<CntrComboVO> cntrCombo = applVo.getCntrCombo();                             
            eventResponse.setETCData(rfAproInfo.getColumnValues());      
            
            if(rfBkgInfo != null && rfBkgInfo.size() >0){
            	eventResponse.setETCData("kr_flag", rfBkgInfo.get(0).getKrFlag());
              	eventResponse.setETCData("cmdt_flag", rfBkgInfo.get(0).getCmdtFlag());
              	eventResponse.setETCData("desc_flag", rfBkgInfo.get(0).getDescFlag());
              	eventResponse.setETCData("co_flag", rfBkgInfo.get(0).getCoFlag());
              	
            }else{
            	eventResponse.setETCData("kr_flag", "");
              	eventResponse.setETCData("cmdt_flag", "");
              	eventResponse.setETCData("desc_flag", "");
              	eventResponse.setETCData("co_flag","");
            }
            
            
            eventResponse.setRsVoList(bkgRfCgo);
            eventResponse.setRsVoList(typzQtys);
            eventResponse.setRsVoList(rfBkgInfo);
            eventResponse.setRsVoList(cntrCombo);            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
	 * ESM_BKG_0498 Special Cargo List 저장 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRfCargo(Event e) throws EventException {

		EsmBkg0498Event event = (EsmBkg0498Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();       
        BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
        BookingUtil utilCmd = new BookingUtil();       
        BLDocumentationCMBC bldocCmd = new BLDocumentationCMBCImpl();
        GeneralBookingReceiptBC generalCmd= new GeneralBookingReceiptBCImpl();       
        RfCgoApplVO rfCgoApplVO = new RfCgoApplVO();         
        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();        
        SpclVO spclVO = new SpclVO();       
        BookingARCreationBC arCmd = new BookingARCreationBCImpl();                              
        ARBkgInterfaceCreationVO bkgIfVO = new ARBkgInterfaceCreationVO();
        HistoryTableVO historyTableVO = null;    	
        rfCgoApplVO.setBkgRfCgoVOs(event.getBkgRfCgoVOs());        
        rfCgoApplVO.setAccount(account);         
        String uiId = "ESM_BKG_0498";        
        String bkgNo = event.getBkgNo();         
        String spclTp = "RF";
        String cntrNo = "";        
        rfCgoApplVO.setBkgNo(bkgNo);        
        bkgBlNoIN.setBkgNo(bkgNo);
        bkgBlNoIN.setCaUsrId(account.getUsr_id());
        ContainerVO[] containerVOs = null;
        
        GeneralBookingSearchBC genSearchCmd = new GeneralBookingSearchBCImpl();  
        String bracCd = "U";
        String ediKind = "BT";
        
        try{
        	//String caFlg = utilCmd.searchBkgCaStatus(bkgBlNoIN);
        	BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
			if (bkgBlNoVO.getCaFlg() == null || bkgBlNoVO.getBkgNo() == null) {
				throw new RuntimeException(new ErrorHandler("BKG01049", new String[] { event.getBkgNo() }).getMessage());
			}			
			historyTableVO = histCmd.searchOldBkgForHistory(uiId, bkgBlNoVO);			
			//if ("Y".equals(caFlg)) {
				//correctCmd.modifyCngScreenFlag(uiId, bkgBlNoIN);  //사용않함으로 변경됨.
			//}     
			
			event.getBkgRfCgoVOs();
			
        	begin();   

        	containerVOs = new ContainerVO[rfCgoApplVO.getBkgRfCgoVOs().length];
        	ContainerVO cntrVO = null;
        	
        	for (int i = 0; i < rfCgoApplVO.getBkgRfCgoVOs().length; i++) {        		
        		cntrVO = new ContainerVO();
        		cntrVO.setBkgNo(rfCgoApplVO.getBkgRfCgoVOs()[i].getBkgNo());
        		cntrVO.setCntrNo(rfCgoApplVO.getBkgRfCgoVOs()[i].getCntrNo());
        		containerVOs[i] = cntrVO;
        	}            
        	// At Risk 에 해당하는 CNTR 인 경우 alert
        	String rskFlg = bldocCmd.validateCntrRsk(containerVOs, bkgBlNoVO.getCaFlg(), "Y");
        	eventResponse.setETCData("rskFlg", rskFlg);
        	
        	command.manageRfCargo(rfCgoApplVO, bkgBlNoVO.getCaFlg());       	
        	bldocCmd.modifyCntrFlgBySpcl2(bkgNo, spclTp, cntrNo, bkgBlNoVO.getCaFlg()); 
        	bldocCmd.modifyCntrFlgBySpcl(bkgNo, spclTp, cntrNo, bkgBlNoVO.getCaFlg());         	
        	
        	for (int i = 0; i < rfCgoApplVO.getBkgRfCgoVOs().length; i++) {        		
        		spclVO.setBkgNo(rfCgoApplVO.getBkgRfCgoVOs()[i].getBkgNo());
        		spclVO.setSpclTp(spclTp);
        		spclVO.setCntrVolQty(rfCgoApplVO.getBkgRfCgoVOs()[i].getCntrVolQty());
        		spclVO.setCntrTpszCd(rfCgoApplVO.getBkgRfCgoVOs()[i].getCntrTpszCd());       		
        		generalCmd.modifyBkgBySpcl(spclVO, bkgBlNoVO.getCaFlg());   
        	}            
        	
        	//String caFlg = utilCmd.searchBkgCaStatus(bkgBlNoVO);         	
        	String newStsCd = "W";        	
        	bkgBlNoVO.setCaFlg(bkgBlNoVO.getCaFlg());        	
        	boolean bkgStsChgFlg = false;        	
        	bkgStsChgFlg = generalCmd.changeBkgStatus(newStsCd, bkgBlNoVO, bkgStsChgFlg, account);   
        	
        	if(bkgStsChgFlg == true && "N".equals(bkgBlNoVO.getCaFlg())){
        		bkgIfVO.setBkgNo(bkgBlNoVO.getBkgNo());
    	        bkgIfVO.setManDivInd("B");
    	        bkgIfVO.setUserId(account.getUsr_id());
            	arCmd.interfaceBKGARInvoiceToINV(bkgIfVO); 

//        		CostAssignBC coaBc = new CostAssignBCImpl();
//    			CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
//    			coaBkgComIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
//    			coaBkgComIfVo.setCostSrcSysCd("BKG");
//    			coaBkgComIfVo.setIfRmk("Booking Status Change");
//    			coaBkgComIfVo.setCreUsrId(account.getUsr_id());
//    			coaBkgComIfVo.setUpdUsrId(account.getUsr_id());
//    			
//    			coaBc.modifyCoaCommonInterface(coaBkgComIfVo);
            	
            	CostAssignBC masBc = new CostAssignBCImpl();
    			MasBkgComIfVO masBkgComIfVo = new MasBkgComIfVO();
    			masBkgComIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
    			masBkgComIfVo.setCostSrcSysCd("BKG");
    			masBkgComIfVo.setIfRmk("Booking Status Change");
    			masBkgComIfVo.setCreUsrId(account.getUsr_id());
    			masBkgComIfVo.setUpdUsrId(account.getUsr_id());
    			
    			masBc.modifyMasCommonInterface(masBkgComIfVo);
        	}
        	histCmd.manageBookingHistory(uiId, historyTableVO, account);       	

    		// Cntr No가 수정이 되면 Vender 301이 전송되도록 하기 위하여 Flg를 만들었음. ( 경종윤 수석님 요청 - 2010.08.26 )
        	if ( "Y".equals(event.getRfChkFlg()) ) {
        		
        		// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
        		Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
				vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
				vender301ParamVO.setOldVvdVOs(null);
				vender301ParamVO.setOldQtyVOs(null);
				vender301ParamVO.setOldMtyPkupYdCd(null);
				vender301ParamVO.setBracCd(bracCd);
				vender301ParamVO.setEdiKind(ediKind);
				vender301ParamVO.setAutoManualFlg("Y");
				vender301ParamVO.setRcvId("");
				
	        	List<BkgNtcHisVO> bkgNtcHisVOs = genSearchCmd.createTmlBkgReceiptEdi(vender301ParamVO, account);        	
	        	histCmd.createBkgNtcHis(bkgNtcHisVOs, uiId);
        	}
	        	
            commit();    
            if ( "Y".equals(event.getRfChkFlg()) ) {
	        	// DG 저장시에 PSA 전송되도록 수정함. [CHM-201006332-01]
	        	eventResponse.setETCData("psaValCode", this.managePSABKGAuto(bkgBlNoVO.getBkgNo(), "N"));
        	}          
            eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());            
        }catch(EventException ex){
            rollback();
            eventResponse.setUserMessage(ex.getMessage()); 
            throw ex;
        }catch(Exception ex){
            rollback();
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
	 * ESM_BKG_0106 조회 이벤트 처리<br>
	 * special cargo list를 조회 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBbCargo(Event e) throws EventException {
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0106Event event = (EsmBkg0106Event) e;        
        BookingUtil utilCmd = new BookingUtil();        
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();        
        String bkgNo      = event.getBkgNo();
        String blNo       = event.getBlNo();
        
        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
        bkgBlNoIN.setBkgNo(bkgNo);
        bkgBlNoIN.setCaUsrId(account.getUsr_id());
               
        try{        	
        	if(bkgNo==null || bkgNo.length()==0){
                if(blNo!=null && blNo.length()>0){
                    bkgNo = utilCmd.searchBkgNoByBlNo(blNo);
                }
            }
        	
        	BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
        	
        	BbCgoApplVO applVo = new BbCgoApplVO();
        	
        	if(bkgBlNoVO != null){
        		applVo = command.searchBbCargo(bkgNo, blNo, bkgBlNoVO.getCaFlg());    
        	}else{
        		applVo = command.searchBbCargo(bkgNo, blNo, "");  
        	}
        	
        	List<BbBkgInfoVO> bbBkgInfo = applVo.getBbBkgInfoVO();
        	BbAproInfoVO bbAproInfo = applVo.getBbAproInfoVO();
            List<BkgBbCgoVO> bkgBbCgo = applVo.getBkgBbCgoVO();
            List<BbCntrListVO> bbCntrList = applVo.getBbCntrListVO();
            List<CntrTypzQtyVO> typzQtys = applVo.getCntrTypzQty();
            List<CntrComboVO> cntrCombo = applVo.getCntrCombo();                           
            eventResponse.setETCData(bbAproInfo.getColumnValues());                            
            eventResponse.setRsVoList(bkgBbCgo);
            eventResponse.setRsVoList(typzQtys);
            eventResponse.setRsVoList(bbBkgInfo);
            eventResponse.setRsVoList(bbCntrList);
            eventResponse.setRsVoList(cntrCombo);          
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }	
	
	/**
	 * ESM_BKG_0106 Special Cargo List 저장 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBbCargo(Event e) throws EventException {

		EsmBkg0106Event event = (EsmBkg0106Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();         
        BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
        BookingUtil utilCmd = new BookingUtil(); 
        GeneralBookingReceiptBC generalCmd = new GeneralBookingReceiptBCImpl(); 
        BLDocumentationCMBC bldocCmd = new BLDocumentationCMBCImpl();
        BbCgoApplVO bbCgoApplVO = new BbCgoApplVO();         
        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();                
        BookingARCreationBC arCmd = new BookingARCreationBCImpl();                              
        ARBkgInterfaceCreationVO bkgIfVO = new ARBkgInterfaceCreationVO();
        HistoryTableVO historyTableVO = null;    	
        bbCgoApplVO.setBkgBbCgoVOs(event.getBkgBbCgoVOs());
        bbCgoApplVO.setBbCntrListVOs(event.getBbCntrListVOs());
        bbCgoApplVO.setAccount(account);       
        String uiId = "ESM_BKG_0106";        
        String bkgNo = event.getBkgNo();  
        String ovrVoidSltQty = event.getOvrVoidSltQty();
        String spclTp = "BB";        
        bbCgoApplVO.setBkgNo(bkgNo); 
        //bbCgoApplVO.setOvrVoidSltQty(ovrVoidSltQty); 
        bkgBlNoIN.setBkgNo(bkgNo);
        bkgBlNoIN.setCaUsrId(account.getUsr_id());        
        
        GeneralBookingSearchBC genSearchCmd = new GeneralBookingSearchBCImpl();     
        String bracCd = "U";
        String ediKind = "BT";
        
        try{        	
        	//String caFlg = utilCmd.searchBkgCaStatus(bkgBlNoIN);
        	BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
			if (bkgBlNoVO.getCaFlg() == null || bkgBlNoVO.getBkgNo() == null) {
				throw new RuntimeException(new ErrorHandler("BKG01049", new String[] { event.getBkgNo() }).getMessage());
			}			
			historyTableVO = histCmd.searchOldBkgForHistory(uiId, bkgBlNoVO);			
			//if ("Y".equals(caFlg)) {
				//correctCmd.modifyCngScreenFlag(uiId, bkgBlNoIN);  //사용않함으로 변경됨.
			//}        	
        	begin();        	 
        	command.manageBbCargo(bbCgoApplVO, bkgBlNoVO.getCaFlg()); 
        	
        	//bldocCmd.modifyCntrFlgBySpcl(bkgNo, spclTp); 
        	//bldocCmd.modifyCntrFlgBySpcl2(bkgNo, spclTp, cntrNo); 
        	//bldocCmd.modifyCntrFlgBySpcl(bkgNo, spclTp);       	
        	
        	if(bbCgoApplVO.getBbCntrListVOs() != null){   
        		bldocCmd.modifyCntrFlgBySpcl3(bkgNo, bkgBlNoVO.getCaFlg());
	        	for (int i =0; i < bbCgoApplVO.getBbCntrListVOs().length; i++){	        		
	        		if(bbCgoApplVO.getBbCntrListVOs()[i].getIbflag().equals("I") || bbCgoApplVO.getBbCntrListVOs()[i].getIbflag().equals("U")){
	        			
	        			bldocCmd.modifyCntrFlgBySpcl(bkgNo, spclTp, bbCgoApplVO.getBbCntrListVOs()[i].getCntrNo(), bkgBlNoVO.getCaFlg()); 
	        		}
	        		if(bbCgoApplVO.getBbCntrListVOs()[i].getIbflag().equals("D")){
	        			bldocCmd.modifyCntrFlgBySpcl2(bkgNo, spclTp, bbCgoApplVO.getBbCntrListVOs()[i].getCntrNo(), bkgBlNoVO.getCaFlg()); 
	        		}
	        	}        	
        	}        	
        	
        	generalCmd.modifyBbVoidQty(bkgNo, ovrVoidSltQty, bkgBlNoVO.getCaFlg());
        	
        	/*
        	for (int i = 0; i < bbCgoApplVO.getBkgBbCgoVOs().length; i++) {
        		
        		spclVO.setBkgNo(bbCgoApplVO.getBkgBbCgoVOs()[i].getBkgNo());
        		spclVO.setSpclTp(spclTp);
        		spclVO.setCntrVolQty(bbCgoApplVO.getBkgBbCgoVOs()[i].getCntrVolQty());
        		spclVO.setCntrTpszCd(bbCgoApplVO.getBkgBbCgoVOs()[i].getCntrTpszCd());         		
        		
        		generalCmd.modifyBkgBySpcl(spclVO);   
        	} 
        	*/           
        	
        	//String caFlg = utilCmd.searchBkgCaStatus(bkgBlNoVO);         	
        	String newStsCd = "W";        	
        	bkgBlNoVO.setCaFlg(bkgBlNoVO.getCaFlg());        	
        	boolean bkgStsChgFlg = false;        	
        	
        	bkgStsChgFlg = generalCmd.changeBkgStatus(newStsCd, bkgBlNoVO, bkgStsChgFlg, account);   

        	if(bkgStsChgFlg == true && "N".equals(bkgBlNoVO.getCaFlg())){
        		bkgIfVO.setBkgNo(bkgBlNoVO.getBkgNo());
    	        bkgIfVO.setManDivInd("B");
    	        bkgIfVO.setUserId(account.getUsr_id());
            	arCmd.interfaceBKGARInvoiceToINV(bkgIfVO); 
            	
//        		CostAssignBC coaBc = new CostAssignBCImpl();
//    			CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
//    			coaBkgComIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
//    			coaBkgComIfVo.setCostSrcSysCd("BKG");
//    			coaBkgComIfVo.setIfRmk("Booking Status Change");
//    			coaBkgComIfVo.setCreUsrId(account.getUsr_id());
//    			coaBkgComIfVo.setUpdUsrId(account.getUsr_id());
//    			
//    			coaBc.modifyCoaCommonInterface(coaBkgComIfVo);
            	
            	CostAssignBC masBc = new CostAssignBCImpl();
    			MasBkgComIfVO masBkgComIfVo = new MasBkgComIfVO();
    			masBkgComIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
    			masBkgComIfVo.setCostSrcSysCd("BKG");
    			masBkgComIfVo.setIfRmk("Booking Status Change");
    			masBkgComIfVo.setCreUsrId(account.getUsr_id());
    			masBkgComIfVo.setUpdUsrId(account.getUsr_id());
    			
    			masBc.modifyMasCommonInterface(masBkgComIfVo);
        	}	        	
        	
        	histCmd.manageBookingHistory(uiId, historyTableVO, account);

    		// Cntr No가 수정이 되면 Vender 301이 전송되도록 하기 위하여 Flg를 만들었음. ( 경종윤 수석님 요청 - 2010.08.26 )
        	if ( "Y".equals(event.getBbChkFlg()) ) {
        		
        		// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
        		Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
				vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
				vender301ParamVO.setOldVvdVOs(null);
				vender301ParamVO.setOldQtyVOs(null);
				vender301ParamVO.setOldMtyPkupYdCd(null);
				vender301ParamVO.setBracCd(bracCd);
				vender301ParamVO.setEdiKind(ediKind);
				vender301ParamVO.setAutoManualFlg("Y");
				vender301ParamVO.setRcvId("");
				
	        	List<BkgNtcHisVO> bkgNtcHisVOs = genSearchCmd.createTmlBkgReceiptEdi(vender301ParamVO, account);        	
	        	histCmd.createBkgNtcHis(bkgNtcHisVOs, uiId);
        	}
            commit();      
        	if ( "Y".equals(event.getBbChkFlg()) ) {
	        	// DG 저장시에 PSA 전송되도록 수정함. [CHM-201006332-01]
	        	eventResponse.setETCData("psaValCode", this.managePSABKGAuto(bkgBlNoVO.getBkgNo(), "N"));
        	}        
            eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());            
        }catch(EventException ex){
            rollback();
            eventResponse.setUserMessage(ex.getMessage());  
            throw ex;
        }catch(Exception ex){
            rollback();
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
	 * Special Cargo List (ESM_BKG_0055, ESM_BKG_0200, ESM_BKG_0498, ESM_BKG_0106) 연동 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	
	private EventResponse manageSpclCgoApro(Event e) throws EventException {		
		  
        String uiId = "";
        String spclCgoTp = "";
        String rowCnt = "";   
        String scgFlg = "";
        String button = "N";
        SpclCgoAproApplVO spclCgoAproApplVO = new SpclCgoAproApplVO();
        GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
              
        if ("EsmBkg0055Event".equalsIgnoreCase(e.getEventName())) {        	
            uiId = "ESM_BKG_0055";
            spclCgoTp = "A";
            scgFlg = "AK";
            EsmBkg0055Event event = (EsmBkg0055Event)e;
            button = event.getButton();
            spclCgoAproApplVO.setSpclReqInVOs(event.getSpclReqInVOs());
            spclCgoAproApplVO.setBkgNo(event.getBkgNo());  
            spclCgoAproApplVO.setSpclCgoTp(spclCgoTp);           
        } else if ("EsmBkg0200Event".equalsIgnoreCase(e.getEventName())) {        	
            uiId = "ESM_BKG_0200";
            spclCgoTp = "D";
            scgFlg = "DG";
            EsmBkg0200Event event = (EsmBkg0200Event)e;
            button = event.getButton();
            log.debug("event.getSpclReqInVOs()==============>"+event.getSpclReqInVOs());
            spclCgoAproApplVO.setSpclReqInVOs(event.getSpclReqInVOs());
            spclCgoAproApplVO.setBkgNo(event.getBkgNo());  
            spclCgoAproApplVO.setSpclCgoTp(spclCgoTp);             
        } else if ("EsmBkg0498Event".equalsIgnoreCase(e.getEventName())) {        	
            uiId = "ESM_BKG_0498";
            spclCgoTp = "R";
            scgFlg = "RF";
            EsmBkg0498Event event = (EsmBkg0498Event)e;
            button = event.getButton();
            spclCgoAproApplVO.setSpclReqInVOs(event.getSpclReqInVOs());
            spclCgoAproApplVO.setBkgNo(event.getBkgNo());  
            spclCgoAproApplVO.setSpclCgoTp(spclCgoTp);            
        } else if ("EsmBkg0106Event".equalsIgnoreCase(e.getEventName())) {        	
            uiId = "ESM_BKG_0106";
            spclCgoTp = "B";
            scgFlg = "BB";
            EsmBkg0106Event event = (EsmBkg0106Event)e;
            button = event.getButton();
            spclCgoAproApplVO.setSpclReqInVOs(event.getSpclReqInVOs());
            spclCgoAproApplVO.setBkgNo(event.getBkgNo());  
            spclCgoAproApplVO.setSpclCgoTp(spclCgoTp); 
            rowCnt = event.getRowCnt();            
        }         		
        GeneralEventResponse eventResponse = new GeneralEventResponse();        
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();
        OwnDangerousCargoApprovalBC ownCmd = new OwnDangerousCargoApprovalBCImpl();       
        GeneralBookingSearchBC genSearchCmd = new GeneralBookingSearchBCImpl();
        
        // BKG Status Change
        GeneralBookingReceiptBC generalCmd= new GeneralBookingReceiptBCImpl();  
        ARBkgInterfaceCreationVO bkgIfVO = new ARBkgInterfaceCreationVO();    
        BookingARCreationBC arCmd = new BookingARCreationBCImpl();
//        CostAssignBC coaCmd = new CostAssignBCImpl();
        CostAssignBC masCmd = new CostAssignBCImpl();
        
        //OwnApprovalRequestVO ownApprovalRequestVO = new OwnApprovalRequestVO();        
        BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();
        ScgAproRqstVO[] scgAproRqstVOs = new ScgAproRqstVO[1];
        ScgVvdAproRqstVO[] scgVvdAproRqstVOs = null; 
        BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();        
        HistoryLineVO historyLineVO = new HistoryLineVO();               
        bkgBlNoVO.setBkgNo(spclCgoAproApplVO.getBkgNo());
        historyLineVO.setBkgNo(spclCgoAproApplVO.getBkgNo());
        historyLineVO.setUiId(uiId);   
        spclCgoAproApplVO.setAccount(account);
        String strSpclCgo = "";
        String bracCd = "U";
        String ediKind = "BT";
        int cancelCnt = 0;     
               
        try{       	
        	begin();        	
        	strSpclCgo = command.manageSpclCgoApro(spclCgoAproApplVO);
        	
        	if (strSpclCgo.equals("1")) {
        		throw new EventException(new ErrorHandler("BKG00003", new String[] {}).getMessage());
        	}
        	
        	for (SpclReqInVO vo : spclCgoAproApplVO.getSpclReqInVOs()) {
        		
        		if("C".equals(vo.getAproCd())) {
        			cancelCnt++;        			
        			//ownCmd.cancelSpecialCargoRequest(scgFlg, bkgNo, cgoSeq, spclCgoAproCd, account);
        			if(spclCgoTp.equals("A")){
        			ownCmd.cancelSpecialCargoRequest(scgFlg, vo.getBkgNo(), new String[]{vo.getAwkCgoSeq()}, new String[]{"C"}, account); 
        			}
        			if(spclCgoTp.equals("D")){
        				ownCmd.cancelSpecialCargoRequest(scgFlg, vo.getBkgNo(), new String[]{vo.getDcgoSeq()}, new String[]{"C"}, account);	
        			}
        			if(spclCgoTp.equals("R")){
        				ownCmd.cancelSpecialCargoRequest(scgFlg, vo.getBkgNo(), new String[]{vo.getRcSeq()}, new String[]{"C"}, account);	
        			}
        			if(spclCgoTp.equals("B")){
        				ownCmd.cancelSpecialCargoRequest(scgFlg, vo.getBkgNo(), new String[]{vo.getBbCgoSeq()}, new String[]{"C"}, account);	
        			}
        		}
        	}
        	String  cntr_qty = Integer.toString(spclCgoAproApplVO.getSpclReqInVOs().length-cancelCnt);        	
        	if ( null != spclCgoAproApplVO.getSpclReqInVOs() && 0 < spclCgoAproApplVO.getSpclReqInVOs().length ) {        		
        		scgAproRqstVOs[0] = new ScgAproRqstVO();
        		scgAproRqstVOs[0].setIbflag("I");        		
        		scgAproRqstVOs[0].setBkgNo(spclCgoAproApplVO.getBkgNo());        		
        		scgAproRqstVOs[0].setPorCd(spclCgoAproApplVO.getSpclReqInVOs()[0].getPorCd());
        		scgAproRqstVOs[0].setDelCd(spclCgoAproApplVO.getSpclReqInVOs()[0].getDelCd());
        		scgAproRqstVOs[0].setLstRqstDatFlg("N");
        		scgAproRqstVOs[0].setBkgRcvTermCd(spclCgoAproApplVO.getSpclReqInVOs()[0].getRcvTermCd());
        		scgAproRqstVOs[0].setBkgDeTermCd(spclCgoAproApplVO.getSpclReqInVOs()[0].getDeTermCd());
        		scgAproRqstVOs[0].setRqstUsrId(account.getUsr_id());
        		scgAproRqstVOs[0].setRqstOfcCd(account.getOfc_cd());
        		scgAproRqstVOs[0].setRqstDt(account.getUpd_dt());
        		scgAproRqstVOs[0].setSpclBkgRqstFlg("N");        		
        		if("A".equalsIgnoreCase(spclCgoAproApplVO.getSpclCgoTp())){        			
        			scgAproRqstVOs[0].setSpclCgoCateCd("AK");
        			scgAproRqstVOs[0].setAwkCgoQty(cntr_qty);
        		}        		
        		if("D".equalsIgnoreCase(spclCgoAproApplVO.getSpclCgoTp())){        			
        			scgAproRqstVOs[0].setSpclCgoCateCd("DG");
        			scgAproRqstVOs[0].setDcgoQty(cntr_qty);
        		}
        		if("R".equalsIgnoreCase(spclCgoAproApplVO.getSpclCgoTp())){	
        			scgAproRqstVOs[0].setSpclCgoCateCd("RF");
        			scgAproRqstVOs[0].setRcQty(cntr_qty);
				}
				if("B".equalsIgnoreCase(spclCgoAproApplVO.getSpclCgoTp())){					
					scgAproRqstVOs[0].setSpclCgoCateCd("BB");
					scgAproRqstVOs[0].setBbCgoQty(rowCnt);
				}
        	}
        	scgVvdAproRqstVOs = command.searchBkgVvd(spclCgoAproApplVO.getBkgNo());
        	log.debug("\n 재실행 여부 결정 " + button);
        	if ("N".equals(button)){
        		ownCmd.requestSpecialCargoApproval(scgAproRqstVOs, scgVvdAproRqstVOs, account);  
        	}
        	        	
        	// BKG Status Change
        	String newStsCd = "W";
        	boolean bkgStsChgFlg = false;
       		bkgStsChgFlg = generalCmd.changeBkgStatus(newStsCd, bkgBlNoVO, bkgStsChgFlg, account);          		
       		
       		//DOC_USR_ID 가 HOMEPAGE일 경우 REQUEST 유저 ID로 UPDATE
       		receiptBC.modifyDocUserId(bkgBlNoVO.getBkgNo(), bkgBlNoVO.getCaFlg(), account.getUsr_id());
       		
       		
       		GeneralBookingSearchBC bkgCommand = new GeneralBookingSearchBCImpl();
            BookingHistoryMgtBC  hisCommand = new BookingHistoryMgtBCImpl();

       		
       		String rcvrEml = null; 
            rcvrEml = bkgCommand.searchEBkgUploadNoticeEml(bkgBlNoVO.getBkgNo());
                           
            if(rcvrEml!=null && rcvrEml.length()>0){
                           
                    BkgBlNoVO[] bkgBlNoVOs = {bkgBlNoVO};
                    String[]    eml        = {rcvrEml};     
                    String[]    cct        = {""};
                    String[]    docCct     = {""};
                    String[]    rmk        = {""};
                    String mrdNm = "ESM_BKG_5005G";
                                  
                    BkgReceiptSendVO bkgReceiptSendVO = new BkgReceiptSendVO();
                    bkgReceiptSendVO.setBkgBlNoVos(bkgBlNoVOs);
                    bkgReceiptSendVO.setEmlAddrs(eml);
                    bkgReceiptSendVO.setRemarks(rmk);
                    bkgReceiptSendVO.setMrdNm(mrdNm);
                    bkgReceiptSendVO.setCcts(cct);
                    bkgReceiptSendVO.setDocCcts(docCct);
                    List<BkgNtcHisVO> bkgNtcHisVOs = bkgCommand.sendBkgReceiptByEmail(bkgReceiptSendVO, "", account);
                    hisCommand.createBkgNtcHis(bkgNtcHisVOs, "SYSTEM");  
            } 

       		
       		
       		
       		
       		
       		

        	// INV Interface
       		if(bkgStsChgFlg == true && !"Y".equals(bkgBlNoVO.getCaFlg())){
        		bkgIfVO.setBkgNo(bkgBlNoVO.getBkgNo());
    	        bkgIfVO.setManDivInd("B");
    	        bkgIfVO.setUserId(account.getUsr_id());
            	arCmd.interfaceBKGARInvoiceToINV(bkgIfVO); 
            	
				/* COA */
//                CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
//                coaBkgComIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
//                coaBkgComIfVo.setCostSrcSysCd("BKG");
//                coaBkgComIfVo.setIfRmk("Booking Status Change");
//                coaBkgComIfVo.setCreUsrId(account.getUsr_id());
//                coaBkgComIfVo.setUpdUsrId(account.getUsr_id());
//                coaCmd.modifyCoaCommonInterface(coaBkgComIfVo);
            	MasBkgComIfVO masBkgComIfVo = new MasBkgComIfVO();
                masBkgComIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
                masBkgComIfVo.setCostSrcSysCd("BKG");
                masBkgComIfVo.setIfRmk("Booking Status Change");
                masBkgComIfVo.setCreUsrId(account.getUsr_id());
                masBkgComIfVo.setUpdUsrId(account.getUsr_id());
                masCmd.modifyMasCommonInterface(masBkgComIfVo);
        	}
        	
	        //bkgIfVO.setBkgNo(spclCgoAproApplVO.getBkgNo());
	        //bkgIfVO.setManDivInd("B");
	        //bkgIfVO.setUserId(account.getUsr_id());
        	//arCmd.interfaceBKGARInvoiceToINV(bkgIfVO); 
        	
        	//if (bkgStsChgFlg == true){
        	//historyCmd.createBkgHistoryLine(historyLineVO, account);     
        	
    		// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
    		Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
			vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
			vender301ParamVO.setOldVvdVOs(null);
			vender301ParamVO.setOldQtyVOs(null);
			vender301ParamVO.setOldMtyPkupYdCd(null);
			vender301ParamVO.setBracCd(bracCd);
			vender301ParamVO.setEdiKind(ediKind);
			vender301ParamVO.setAutoManualFlg("Y");
			vender301ParamVO.setRcvId("");
			
        	List<BkgNtcHisVO> bkgNtcHisVOs = genSearchCmd.createTmlBkgReceiptEdi(vender301ParamVO, account);        	
        	bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, uiId);
        	
        	commit();
        	// DG 저장시에 PSA 전송되도록 수정함. [CHM-201006332-01]
        	String psaValCode = this.managePSABKGAuto(bkgBlNoVO.getBkgNo(), "N");
        	eventResponse.setETCData("psaValCode", psaValCode );
        	//}        	
        	//interfaceCrm....        	    	
        	 
            
            eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage()); 
           
        }catch(EventException ex){
            rollback();           
            throw ex;	                     
        }catch(Exception ex){
            rollback();
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
	 * ESM_BKG_1045 Special Cargo List 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDgPackage(Event e) throws EventException {
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1045Event event = (EsmBkg1045Event) e;                  
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();        
        String code      = event.getCode();
        String desc       = event.getDesc();
        String pckTpCd       = event.getPckTpCd();        
                
        try{        	
        	DgCgoApplVO applVo = command.searchDgPackage(code, desc, pckTpCd);                    	
        	List<DgPackageVO> dgPackageVO = applVo.getDgPackage();        	              	                   
            eventResponse.setRsVoList(dgPackageVO);          
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
	 * ESM_BKG_0204 Special Cargo List 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDgUnNumber(Event e) throws EventException {
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0204Event event = (EsmBkg0204Event) e;                 
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();        
        String bkgNo      = event.getBkgNo();
        String unNo      = event.getUnNo();
        String imdgClass       = event.getImdgClass();
        String prpShpNm       = event.getPrpShpNm();
               
        try{        	
        	DgCgoApplVO applVo = command.searchDgUnNumber(bkgNo, unNo, imdgClass, prpShpNm);                    	
        	List<ScgImdgUnNoVO> scgImdgUnNoVO = applVo.getScgImdgUnNo();
        	eventResponse.setRsVoList(scgImdgUnNoVO);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }	
	
	private EventResponse searchDgSequence(Event e) throws EventException {
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0754Event event = (EsmBkg0754Event) e;              
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();
        BookingUtil utilCmd = new BookingUtil();   
        String bkgNo      = event.getBkgNo();
        String cntrNo      = event.getCntrNo();
        String cntrTpszCd      = event.getCntrTpszCd();
        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();  
        bkgBlNoIN.setBkgNo(bkgNo);        	
        bkgBlNoIN.setCaUsrId(account.getUsr_id());
        
        try{ 
        	BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
        	DgCgoApplVO applVo = command.searchDgSequence(bkgNo, cntrNo, cntrTpszCd, bkgBlNoVO.getCaFlg());                     	
        	List<BkgDgCgoInfoVO> bkgDgCgoInfo = applVo.getBkgDgCgoInfo();       	
            eventResponse.setRsVoList(bkgDgCgoInfo);          
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
	 * SpecialCargo CmdtCd로 정보 조회.	 *
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCmdtCd(Event e) throws EventException {
		try{
			EsmBkg0498Event event = (EsmBkg0498Event)e;			
			BookingUtil utilCmd = new BookingUtil();

			GeneralEventResponse eventResponse = new GeneralEventResponse();

			String cmdt_nm = utilCmd.searchMdmCmdtDesc(event.getCmdtCd());		
				
			eventResponse.setETCData("cmdt_nm", cmdt_nm);				
			eventResponse.setUserMessage(new ErrorHandler("BKG00010").getUserMessage());
			
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}		
	}

	/**
	 * Booking 번호로 CLL VVD 정보 조회.	 *
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCLLVVD(Event e) throws EventException {

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0498Event event = (EsmBkg0498Event)e;	              
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();
     
        String bkgNo = event.getBkgNo();      
                
        try{        	
        	String cllVvd = command.searchCLLVVD(bkgNo);
            eventResponse.setETCData("cll_vvd", cllVvd);	
   
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
 
	}
	
	/**
	 * (ESM_BKG_0206) imdgPckCd, imdgPckTpCd로 정보 조회.	 *
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchImdgPckDesc(Event e) throws EventException {
		try{
			EsmBkg0206Event event = (EsmBkg0206Event)e;
			SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();

			GeneralEventResponse eventResponse = new GeneralEventResponse();

			ImdgPckDescVO imdgPckDescVO = command.searchImdgPckDesc(event.getImdgPckCd(), event.getImdgPckTpCd());

			if(imdgPckDescVO != null){
				eventResponse.setETCData(imdgPckDescVO.getColumnValues());
			}else{
				
				eventResponse.setETCData("imdg_pck_desc","");				
				eventResponse.setUserMessage(new ErrorHandler("BKG00010").getUserMessage());
			}
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}		
	}

	/**
	 * Auto PSA EDI 전송
	 * cop에 전달할 Rail Receiving Date를 결정한다(mnl_set_dt 우선)
	 *  
	 * @author		YoungCheal Kim
	 * @param 		String bkgNo
	 * @param 		String qtyModifyFlag
	 * @return		String
	 */
	private String managePSABKGAuto(String bkgNo, String qtyModifyFlag) {
		String returnVal = "";
		try{
			begin();
			// psa I/f 대상 자동 전송부분 추가함. ( 전성진수석 요청 - 2010.08.20 - Ticket ID : CHM-201005191-01 )
			//BookingHistoryMgtBC의 createBkgHistoryLine 호출	
			BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
			List<BkgNtcHisVO> bkgNtcHisVOs = null;
			
			PSAManifestBC psaBC = new PSAManifestBCImpl();
			PsaBkgVO[] psaBkgVOs = new PsaBkgVO[1];
			psaBkgVOs[0] = new PsaBkgVO();
			psaBkgVOs[0].setBkgNo(bkgNo);
			psaBkgVOs[0].setSndUsrId(account.getUsr_id());
			psaBkgVOs[0].setQtyModifyFlag(qtyModifyFlag);
			
			psaBC.managePSABKG(psaBkgVOs);

			bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();	
			BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
			bkgNtcHisVO.setBkgNo(bkgNo);
			bkgNtcHisVO.setNtcViaCd("E");
			bkgNtcHisVO.setNtcKndCd("PS");
			bkgNtcHisVO.setEdiId("PSACBI");
			bkgNtcHisVO.setEsvcGrpCd("");
			bkgNtcHisVO.setBkgNtcSndRsltCd("A");
			bkgNtcHisVO.setSndUsrId(account.getUsr_id());
			bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
			bkgNtcHisVO.setCreUsrId(account.getUsr_id());
			bkgNtcHisVO.setUpdUsrId(account.getUsr_id());									
			bkgNtcHisVOs.add(bkgNtcHisVO);
			
			//2015.11.18 [CHM-201538758] PSA 로 Booking EDI (CBINFO)가 전송될 시, SGSINAO, SGSINAC 에서의 MT Release 를 위해 동일 Booking 정보를 SGSINAO, SGSINAC 로 추가 전송 함.
			String bkgMtyPkupYdCd = psaBC.searchBkgMtyPkupYdCdForPsa(bkgNo);
			if (bkgMtyPkupYdCd != null && bkgMtyPkupYdCd.length()>0){
				BkgNtcHisVO bkgNtcHisVO2 = new BkgNtcHisVO();
				bkgNtcHisVO2.setBkgNo(bkgNo);
				bkgNtcHisVO2.setNtcViaCd("E");
				bkgNtcHisVO2.setNtcKndCd("PS");
				bkgNtcHisVO2.setEdiId(bkgMtyPkupYdCd);
				bkgNtcHisVO2.setEsvcGrpCd("");
				bkgNtcHisVO2.setBkgNtcSndRsltCd("A");
				bkgNtcHisVO2.setSndUsrId(account.getUsr_id());
				bkgNtcHisVO2.setSndOfcCd(account.getOfc_cd());
				bkgNtcHisVO2.setCreUsrId(account.getUsr_id());
				bkgNtcHisVO2.setUpdUsrId(account.getUsr_id());									
				bkgNtcHisVOs.add(bkgNtcHisVO2);
			}
			
			if(bkgNtcHisVOs!=null){
				if(bkgNtcHisVOs.size()>0){
					bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0079");
				}
			}
			commit();
			returnVal = "Y"; 
		} catch(EventException ex){
			rollback();
			log.error(ex.getMessage());  //2013.07.05
			returnVal = ex.getMessage();
		} catch(Exception ex){
			rollback();
			log.error(ex.getMessage()); // 2011.07.14
			returnVal = ex.getMessage();
			//			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return  returnVal;
	}
	
	/**
	 * ESM_BKG_0200 MultiCombo 조회 이벤트 처리<br>
	 * Segregation Group list를 조회. MultiCombo 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSegrGrp(Event e) throws EventException {
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        List<SegrGrpVO> segrGrpOutVO = new ArrayList<SegrGrpVO>();
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();        
        
        try{       	
        	segrGrpOutVO = command.searchSegrGrp();       
            eventResponse.setRsVoList(segrGrpOutVO);

        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
	 * ESM_BKG_0200 IMDG UN NUMBER의 SPECIAL PROVISION No 조회 이벤트 처리<br>
	 * Validation Check를 위한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSpclProviNo(Event e) throws EventException {
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0200Event event = (EsmBkg0200Event) e;
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();
        String unNo = "";
        String unNoSeq = "";
        String spclProviNo = "";
        
        try{
        	unNo = event.getImdgUnNo();
        	unNoSeq = event.getImdgUnNoSeq();

        	spclProviNo = command.searchSpclProviNo(unNo, unNoSeq);       
            eventResponse.setETCData("spcl_provi_no", spclProviNo);

        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
        
        return eventResponse;
    }
	
	/**
	 * Special Cargo Validation 체크 (ESM_BKG_0055, ESM_BKG_0200, ESM_BKG_0498, ESM_BKG_0106)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	
	private EventResponse validateSpecialCargo(Event e) throws EventException {
		
        String uiId = "";
        String spclCgoTp = "";
        String rowCnt = "";   
        String scgFlg = "";
        String button = "N";
        SpclCgoAproApplVO spclCgoAproApplVO = new SpclCgoAproApplVO();
              
        if ("EsmBkg0055Event".equalsIgnoreCase(e.getEventName())) {        	
            uiId = "ESM_BKG_0055";
            spclCgoTp = "A";
            scgFlg = "AK";
            EsmBkg0055Event event = (EsmBkg0055Event)e;
            button = event.getButton();
            spclCgoAproApplVO.setSpclReqInVOs(event.getSpclReqInVOs());
            spclCgoAproApplVO.setBkgNo(event.getBkgNo());  
            spclCgoAproApplVO.setSpclCgoTp(spclCgoTp);           
        } else if ("EsmBkg0200Event".equalsIgnoreCase(e.getEventName())) {        	
            uiId = "ESM_BKG_0200";
            spclCgoTp = "D";
            scgFlg = "DG";
            EsmBkg0200Event event = (EsmBkg0200Event)e;
            button = event.getButton();
            log.debug("event.getSpclReqInVOs()==============>"+event.getSpclReqInVOs());
            spclCgoAproApplVO.setSpclReqInVOs(event.getSpclReqInVOs());
            spclCgoAproApplVO.setBkgNo(event.getBkgNo());  
            spclCgoAproApplVO.setSpclCgoTp(spclCgoTp);             
        } else if ("EsmBkg0498Event".equalsIgnoreCase(e.getEventName())) {        	
            uiId = "ESM_BKG_0498";
            spclCgoTp = "R";
            scgFlg = "RF";
            EsmBkg0498Event event = (EsmBkg0498Event)e;
            button = event.getButton();
            spclCgoAproApplVO.setSpclReqInVOs(event.getSpclReqInVOs());
            spclCgoAproApplVO.setBkgNo(event.getBkgNo());  
            spclCgoAproApplVO.setSpclCgoTp(spclCgoTp);            
        } else if ("EsmBkg0106Event".equalsIgnoreCase(e.getEventName())) {        	
            uiId = "ESM_BKG_0106";
            spclCgoTp = "B";
            scgFlg = "BB";
            EsmBkg0106Event event = (EsmBkg0106Event)e;
            button = event.getButton();
            spclCgoAproApplVO.setSpclReqInVOs(event.getSpclReqInVOs());
            spclCgoAproApplVO.setBkgNo(event.getBkgNo());  
            spclCgoAproApplVO.setSpclCgoTp(spclCgoTp); 
            rowCnt = event.getRowCnt();            
        }         		
        GeneralEventResponse eventResponse = new GeneralEventResponse();        
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();
  
               
        try{       	
        	String warnMsg = command.validateSpCgo(spclCgoAproApplVO.getSpclCgoTp(), spclCgoAproApplVO.getBkgNo());
        	
       		if(warnMsg != null && !"".equals(warnMsg)){
        		eventResponse.setETCData("warn_msg", warnMsg );
        		return eventResponse; 
        	}
        }catch(EventException ex){
            rollback();           
            throw ex;	                     
        }catch(Exception ex){
            rollback();
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }       		
        	
}
