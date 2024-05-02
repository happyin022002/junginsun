/**
 * Copyright(c) 2009 CyberLogitec 
 * @FileName : EquipmentMovementMgtSC.java
 * @FileTitle : EquipmentMovementMgtSC
 * Open Issues :
 * Change history : 2009.08.27 (우경민) - EES_CTM_0418 관련업무 추가
 *                  2009.08.28 (김상수) - EES_CTM_0417 관련업무 추가
 *                  2009.09.09 (김상수) - EES_CTM_0456 관련업무 추가
 * @LastModifyDate : 2009.04.24
 * @LastModifier : 김상수
 * @LastVersion : 1.0
 * 2009.04.24 우경민 1.0 Creation.
 * --------------------------------------------------------
 * History
 * 2010.09.09 김상수 [CHM-201005675-01] Split 01-M&R SYSTEM에서 Damage Flag 자동 제거
 *                    (manageCreateProcess 메서드 수정)
 * 2010.11.15 원종규 [CHM-201007070-01] [SCE] CTM 에서 ACTUAL DATE 정보 전달시 항목 추가 요청
 *                    CTM 에서 ACTUAL DATE 를 SCE 로 전송하기 위해 다음 항목들을 추가
 *                    CopDetailReceiveBC / createCOPMVMT(SceActRcvIfVO actVo)
 * 2010.12.28 김상수 [CHM-201007850-01] [CTM] 업무 고도화 관련 소스 보완
 *                    Log 확인용 표준 출력 로그 제거
 *                    관련 대상 : 16개 file
 *                    변경 사항 : System.out.println => log.info 또는 제거
 * 2011.03.14 나상보 [CHM-201109374-01] Booking Cargo Type이 'R' (Revenue Empty) 인 경우도 SCE에 Data를 넘겨준다.
 * 2011.03.22 나상보 [CHM-201109320-01] Brisbane booking missing boxes : Booking Status Report를 위한 method 호출                    
 * 2011.03.25 나상보 [CHM-201109662-01] COD I/F시 직반납 FLAG 넘겨줌       
 * 2011.07.21 나상보 [CHM-201111948] [CTM] TS화물 VL/VD 추가 Insert 예외처리
 * 2011.10.28 신자영 [CHM-201114074-01] [CTM] VL/VD시 Origin Yard code 입력오류 확인 기능 추가
 * 2012.05.11 문동선 [CHM-201217638-01] [CTM] "VD 삭제 불가 Validation추가"에 따르는 메세지 로직 추가
 * 2013.09.24 강  환 [CHM-201325811] Each Container Inquiry 기능 보완 (CO-CP생성시 auto  생성된 MT 를 SCEM에 추가 IF)
 * 2013.12.09 문동선 [CHM-201327200-01] [CTM] Multi Container Inquiry 신규 화면 추가
 * 2014.01.13 최덕우 [CHM-201327924-01] [CTM]  VL/VD Correction by VVD 수정가능 항목 추가
 * 2015.12.28 김상현 [CHM-201539302] CP이후 Domestic Bkg이 없는 경우, 이후 Domestic Mvvement 추가
 * 2016.02.17 김상현 [CHM-201640053] 동일 CYC#의 mvmt는 최신 Bkg으로 Update
 * 2016.03.03 홍성필 [CHM-201639990] EES_CTM_0436 추가
 * 2016.07.11 김상현 [CHM-201642556] 동일한 MVMT에서 VGM이 나중에 EDI 수신되어 오류처리되는 경우, VGM 소급 update logic 추가
 *  - Database transaction 처리 때문에 'manageCreateProcess' method 결과에 따라서 처리하도록 logic 구성
 */
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.basic.ChassisMovementHistoryBC;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.basic.ChassisMovementHistoryBCImpl;
import com.hanjin.apps.alps.ees.ctm.ctmcommon.containermovementvalidation.basic.ContainerMovementValidationBC;
import com.hanjin.apps.alps.ees.ctm.ctmcommon.containermovementvalidation.basic.ContainerMovementValidationBCImpl;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.basic.ContainerMovementFinderBC;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.basic.ContainerMovementFinderBCImpl;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.basic.LongTxContainerMovementFinderBC;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.basic.LongTxContainerMovementFinderBCImpl;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0405Event;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0408Event;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0409Event;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0411Event;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0412Event;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0413Event;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0415Event;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0417Event;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0418Event;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0419Event;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0420Event;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0436Event;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0437Event;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0443Event;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0460Event;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0465Event;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0468Event;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.ConCBookingVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.CtmCCLMVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.CtmMvmtIrrVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.CtmVvdHistoryVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.MovementEDIReportVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchCorrectionHistoryVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchDeletedMVMTListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEDIErrorVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEDIResultVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEdiMsgVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEmptyBookingListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementHistoryMonitorListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByBkgInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByCntrInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByCntrTpszCdVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByContainerVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByMultiContainerVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListBySplitBkgNoForMultiComboVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByVvdForMultiComboVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchVermasListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.UpdateRatioDetailVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.searchMovementHistoryVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.basic.ContainerMovementMasterDataMgtBC;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.basic.ContainerMovementMasterDataMgtBCImpl;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.event.EesCtm0400Event;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.event.EesCtm0421Event;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.event.EesCtm0461Event;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.vo.RCtmMvmtStsVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.vo.UsAmsLocationListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.basic.ContainerMovementMgtBC;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.basic.ContainerMovementMgtBCImpl;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.basic.ContainerMovementMgtForGateNewBC;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.basic.ContainerMovementMgtForGateNewBCImpl;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0000Event;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0404Event;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0406Event;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0407Event;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0414Event;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0430Event;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0433Event;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0440Event;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0442Event;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0456Event;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0458Event;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0462Event;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0463Event;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0999Event;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event.UbizhjsAlpsCtmEqmvmtEvent;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event.UbizhjsAlpsCtmVermasEvent;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration.ContainerMovementMgtDBDAO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.BkgCNTRListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.BookingQTYVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CorrectionVLVDListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CrossItemVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CtmCntrMovInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CtmVrfdGrsMassEdiMsgVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.EventDateUpdateHistoryParmVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.FlatFileForGateNewVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTBookingInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTHistoryListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchBkgCntrListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchCLMInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIByContainerVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIByResultRemarkVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIMovementListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchPreVLVDListVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBC;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBCImpl;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.vo.SceActRcvIfVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryLineVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.basic.PerformanceReportBC;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.basic.PerformanceReportBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.CtmMvmtXchRsnVO;


/**
 * ALPS-EquipmentMovementMgt Business Logic ServiceCommand
 *  - ALPS-EquipmentMovementMgt 대한 비지니스 트랜잭션을 처리
 *
 * @author KyungMin Woo
 * @see ContainerMovementMgtDBDAO
 * @since J2EE 1.4
 */
public class EquipmentMovementMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * EquipmentMovementMgt system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("EquipmentMovementMgtSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * EquipmentMovementMgt system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("EquipmentMovementMgtSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-EquipmentMovementMgt system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EesCtm0400Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMVMTStatusList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0430Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMVMTHistoryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyMVMTHistory(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPolPodLccCd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchModifiedDataCount(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0421Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReasonList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0412Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchIrregularContainerList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0415Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDeletedMVMTList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0405Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEmptyBookingList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0408Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMovementListByContainer(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0409Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMovementListByBooking(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0440Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCorrectionVLVDListByVVD(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchVLVDYardCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCorrectionVLVDByVVD(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0404Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEDIMovementList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageEDIMovement(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0442Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEDIByContainer(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0406Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVLVDList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageInternationalMVMT(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBkgCntrList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = getEtaEtdTime(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkPREVLVD(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = checkVLVDPreChk(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = checkVVDYardCd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = resMovement(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0458Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBookingQTY(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0433Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCNTRList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0000Event") || e.getEventName().equalsIgnoreCase("UbizhjsAlpsCtmEqmvmtEvent") || e.getEventName().equalsIgnoreCase("UbizhjsAlpsCtmVermasEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = gateNew(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = receiveVermasEdi(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0407Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDomesticMVMT(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0411Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVvdHistory(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0443Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCLMList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0413Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMVMTBKGUnmatchList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0419Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchResultEDIList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0418Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {               // It gets a status of backendjob. 2
				eventResponse = comBackEndJob(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {     // It starts a job of backend. 1
				eventResponse = doBackEndJobEDIOnTimeDetailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {    // It returns a result. 3
				eventResponse = searchEDIOnTimeDetailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchEDIOnTimeDetailExcel(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getRccList();
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = getLccList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0417Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {               // It gets a status of backendjob. 2
				eventResponse = comBackEndJob(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {     // It starts a job of backend. 1
				eventResponse = doBackEndJobEDIErrList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {    // It returns a result. 3
				eventResponse = searchEDIErrorList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchEDIErrorDetailExcel(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0420Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {               // It gets a status of backendjob. 2
				eventResponse = comBackEndJob(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {     // It starts a job of backend. 1
				eventResponse = doBackEndJobEDIRstList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {    // It returns a result. 3
				eventResponse = searchEDIResultList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchEDIResultDetailExcel(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0456Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPreVLVDList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePreVLVD(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0414Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchBookingInfoForEDI(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageMVMTHistoryAndEDI(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0460Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {               // It gets a status of backendjob. 2
				eventResponse = comBackEndJob(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {     // It starts a job of backend. 1
				eventResponse = doBackEndJobVLVDStatus(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {    // It returns a result. 3
				eventResponse = searchEDIOnTimeDetailList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0461Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAmsLocation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageUsAmsLocationList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0999Event")) {
			eventResponse = manageSppMovement(e);
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0462Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {               // It gets a status of backendjob. 2
				eventResponse = comBackEndJob(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {     // It starts a job of backend. 1
				eventResponse = doBackEndJobAutoCreStatus(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {    // It returns a result. 3
				eventResponse = searchEDIOnTimeDetailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageAutoCreSts(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0463Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEventDateUpdateHistory(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0465Event")) { // [CHM-201327200-01] Multi Container Inquiry 신규 화면 생성 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMovementListByMultiContainer(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchMovementErrorListByMultiContainer(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0436Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = containerMovementHistoryMonitorList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getRhqOfficeList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = getOfficeByRhqLevelList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = movementCorrctionMonitorList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = movementCorrctionMonitorLccList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = movementCorrctionMonitorRccList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0437Event")) { // [CHM-201639990] Correction History Inquiry 신규 화면 생성 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCorrectionHistory(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0468Event")) { // Terminal e-VGM Received Monitoring
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchVermasList(e);
			}
		}

		return eventResponse;
	}

	/**
	 * EES_CTM_0400 : btn_retrive<br>
	 * Movement Status List 조회<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMVMTStatusList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0400Event event = (EesCtm0400Event)e;
		ContainerMovementMasterDataMgtBC command = new ContainerMovementMasterDataMgtBCImpl();
		try {
			List<RCtmMvmtStsVO> list = command.searchMVMTStatusList(event.getRCtmMvmtStsVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0430 : btn_retrive<br>
	 * ContainerMovementMasterDataMgt의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMVMTHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0430Event event = (EesCtm0430Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		ContainerMovementValidationBC commonCommand = new ContainerMovementValidationBCImpl();
		try {
			List<MVMTBookingInfoVO> list1 = command.searchBookingInfoList(event.getCtmMovementVO(), commonCommand.searchUserCntCode(account.getOfc_cd()));
			List<MVMTHistoryListVO> list2 = command.searchMVMTHistoryList(event.getMVMTHistoryListVO());
			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
			String lastRetrieveDate = command.searchSystemDate();
			eventResponse.setETCData("last_retrieve_date", lastRetrieveDate);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * EES_CTM_0430 : btn_save<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyMVMTHistory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0430Event event = (EesCtm0430Event)e;
		try {
			begin();
			String rtnStr = modifyMVMTProcess(event.getCusCtmMovementVOS(), event.getCtmMovementVOS());
			if (rtnStr == null) {
				rollback();
			} else {
				if (!"".equals(rtnStr)) {
					eventResponse.setETCData("rtnStr", rtnStr);
					rollback();
				} else {
					commit();
				}
			}
		} catch (EventException ex) {
			log.error("\n\n[SC - modifyMVMTHistory] EventException :\n\n" + ex.getMessage(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("\n\n[SC - modifyMVMTHistory] Exception :\n\n" + ex.getMessage(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * SC : modifyMVMTHistory / manageMVMTHistoryAndEDI에서 호출<br>
	 * Movement History List의 변경 내역을 저장한다<br>
	 *
	 * @param CusCtmMovementVO[] ctmMovementVOs
	 * @param MVMTBookingInfoVO[] mvmtBookingInfoVOs
	 * @return String
	 * @exception EventException
	 */
	private String modifyMVMTProcess(CusCtmMovementVO[] cusCtmMovementVOs, MVMTBookingInfoVO[] mvmtBookingInfoVOs) throws EventException {
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		CrossItemVO item = null;
		String rtnStr = null;
		int priorKnt = 999;// OP, VL 삭제시 동일 bkgno 의 이전 mvmt 수, Booking 데이터 초기화 방지를 위해 0 보다 큰 임의의 수 입력

		//2011.03.08 BKG  [CHM-201109320] Brisbane booking missing boxes
		PerformanceReportBC formanceCmd = new PerformanceReportBCImpl();
		try {
			item = command.modifyMVMTHistory(cusCtmMovementVOs, mvmtBookingInfoVOs, account);

			log.info("조회 결과 DEL FLG :::: " + item.getFinalCfm() + ":::" + item.getUpdateMaster());
			if ("1".equals(item.getFinalCfm())) {
				// 모든 행위 중지하고 상위 메서드에서 RollBack... BKG에서 Final Confirm되어있는 자료임.
				rtnStr = "Booking container is already confirmed. If you want to delete these status, please adjust booking container first.";

			}else if("2".equals(item.getFinalCfm())){
				// 모든 행위 중지하고 상위 메서드에서 RollBack... OP/OC 없이 Cntr가 O/B에 attach되어 있음.
				rtnStr = "Booking container is already attached into O/B Bkg("+item.getBkgNo()+"). If you want to delete these status, please adjust booking container first.";
			} else {
				List<CusCtmMovementVO> lst = item.getCusCtmMovementVOs();
				List<CusCtmMovementVO> list = new ArrayList<CusCtmMovementVO>();
				for (int i = lst.size() -1; i >= 0; i--) {
					if ("USA".equals(lst.get(i).getCntrSvrId()) || "SWA".equals(lst.get(i).getCntrSvrId())) {
						list.add(lst.get(i));
					}
				}
				//log.debug("\n\n item.getFinalCfm() " +item.getFinalCfm() + "\n\n");

				// 최초 생성된 OC가 변경되었을 경우 Booking을 호출하도록 한다
				if (item.getBkgVO() != null) {
					BLDocumentationCMBC bkgCommand0 = new BLDocumentationCMBCImpl();
					bkgCommand0.modifyCntrHistoryUpdate(item.getBkgVO() , "2");
				}

				if (item.getUpdateMaster()) {
					item.getCusCtmMovementVO().setCtmUiYn("Y");    // ctm_ui_yn (0430/0414화면에서의 실행인지 구분값 - MST모듈에서 사용)
					ContainerOnOffhireBC mstCommand = new ContainerOnOffhireBCImpl();
					mstCommand.updateCntrMasterByMvmtBasic(item);

					// OP이고 BKG_CONTAINER에 컨테이너가 존재하지 않을때 BCImpl에서 "X"로 리턴
					// "X"가 아닐때만 BKG모듈을 호출
					if (!"X".equals(item.getFinalCfm())) {
						log.debug("X가 아닐때만 BKG모듈을 호출 시작");
						//[CHM-201642970] OP, VL이 삭제로 booking 정보를 초기화 시 해당 BKG_NO가 정상적으로 입력된 이전 movement가 존재하는지 조회
						if("O".equals(item.getFinalCfm()) || "V".equals(item.getFinalCfm())){
							priorKnt = command.searchSamBkgPriorMvmtKnt(item.getBkgNo(), item.getCntrNo());
							log.debug("\nOP, VL이 삭제로 booking 정보를 초기화 시 해당 BKG_NO가 정상적으로 입력된 이전 movement가 존재하는지 조회  : priorKnt : " + priorKnt);
						}

						BLDocumentationCMBC bkgCommand0 = new BLDocumentationCMBCImpl();
						if ("O".equals(item.getFinalCfm()) && priorKnt < 1) { // OP삭제
							log.debug("OP Booking 데이터 초기화 시작");
							BlRatingBC bkgCommand1 = new BlRatingBCImpl();
							GeneralBookingReceiptBC bkgCommand2 = new GeneralBookingReceiptBCImpl();
							BookingHistoryMgtBC bkgCommand3 = new BookingHistoryMgtBCImpl();

							HistoryLineVO historyLineVO = new HistoryLineVO();
							String[] bkgNoList = command.getBookingListByCycle(item.getCntrNo(), item.getCycNo(), item.getCnmvYr());
							for (int idx = 0; idx < bkgNoList.length; idx++) {
								bkgCommand0.removeCntrSealNo(bkgNoList[idx], item.getCntrNo(), null, item.getCaFlg());
								bkgCommand1.removeCntrRateByCntr(bkgNoList[idx], item.getCntrNo(), "");
								bkgCommand2.removeReferenceDetailByCntr(bkgNoList[idx], item.getCntrNo(), item.getCaFlg());
								bkgCommand2.removeReferenceByCntr(bkgNoList[idx], item.getCntrNo(), item.getCaFlg());
								bkgCommand0.removeCntrMfDesc(bkgNoList[idx], item.getCntrNo(), item.getCaFlg());
								bkgCommand0.removeContainer(bkgNoList[idx], item.getCntrNo(), item.getCaFlg());

								historyLineVO.setBkgNo(bkgNoList[idx]);
								historyLineVO.setHisCateNm("Container");
								historyLineVO.setCaFlg("N");
								historyLineVO.setUiId("SYSTEM");
								historyLineVO.setCrntCtnt("Detach Container:" + item.getCntrNo());
								historyLineVO.setBkgDocProcTpCd(null);
								bkgCommand3.createBkgHistoryLine(historyLineVO, account);

								item.setBkgNo(bkgNoList[idx]);
								// BKG에서 COP호출 할때 Attch할 것인지 확인하기 위한 코드. C일 경우 호출. D(History에서 호출)일때 삭제
								item.setAttchCd("D");
							    // BKG 요청으로 N으로 강제 세팅함. 2009-11-12
								item.setCntrPrtFlg("N");
								// BKG 요청으로 bkg_container 저장후 return값이 ture면 ctm_mvmt_irr에도 저장 (기본으로 return되는 값은 false). 2009-06-25
								boolean modifyCntrOpResult = bkgCommand0.modifyCntrOp(item);
								if (modifyCntrOpResult) {
									command.updateEtcModule(item, modifyCntrOpResult);
								}
								//2011.03.08 BKG  [CHM-201109320] Brisbane booking missing boxes
								/* bkg_no별 container NO, Type 생성.*/
								formanceCmd.manageQtyCntrCoposite(bkgNoList[idx], "CN");
							}

						} else if ("V".equals(item.getFinalCfm()) && priorKnt < 1) { // VL 삭제
							item.setMstBkgCntrOpUpdate(true);
							log.info("원 부킹 번호 :::: " + item.getCusCtmMovementVO().getBkgNo());
							log.info("소스 부킹 번호 :::: " + item.getBkgNo());
							item.getCusCtmMovementVO().setBkgNo(item.getBkgNo());
							item.getCusCtmMovementVO().setCnmvCycNo(item.getCycNo());
							bkgCommand0.modifyCntrHistoryUpdate (item.getCusCtmMovementVO(), "0");

						} else {
							item.setMstBkgCntrOpUpdate(true);
							bkgCommand0.modifyCntrHistoryUpdate (item.getCusCtmMovementVO(), "1");

							/* else : 2014.08.05 Add Script TN/EN-> MT를 OP-OC로 수정시 BKG No.에 CNTR Attach */
							String stsCd = item.getCusCtmMovementVO().getMvmtStsCd();
						    //BLDocumentationCMBC bkgCommand0 = new BLDocumentationCMBCImpl();
						    BookingHistoryMgtBC bkgCommand1 = new BookingHistoryMgtBCImpl();
						    HistoryLineVO historyLineVO = null;
						    boolean modifyCntrOpResult = false;
						    log.debug("\n\n Status CD ==> " + stsCd + "\n\n");
						    if ((stsCd.equals("OP") || stsCd.equals("OC")) && item.getUpdateMaster() ) {
						       if (item.getFindBkgCntr()) {
						         // BKG에서 COP호출 할때 Attch할 것인지 확인하기 위한 코드. C일 경우 호출. D(History에서 호출)일때 삭제
						         item.setAttchCd("C");
						       } else {
						         item.setAttchCd("U");
						         // 신규 생성일때 BKG History 관리 호출
						         historyLineVO = new HistoryLineVO();
						         //historyLineVO.setBkgNo(cusCtmMovementVOs[0].getBkgNo());
						         historyLineVO.setBkgNo(item.getCusCtmMovementVO().getBkgNo());
						         historyLineVO.setHisCateNm("Container");
						         historyLineVO.setCaFlg("N");
						         historyLineVO.setUiId("SYSTEM");
						         historyLineVO.setCrntCtnt("Attach Container:" + cusCtmMovementVOs[0].getCntrNo());
						         historyLineVO.setBkgDocProcTpCd(null);
						         bkgCommand1.createBkgHistoryLine(historyLineVO, account);
						       }
						      
						        //item.getCusCtmMovementVO().setBkgNo(cusCtmMovementVOs[0].getBkgNo());
						        log.debug("\n\n Bkg_no ==> " + item.getCusCtmMovementVO().getBkgNo() + "\n\n");
						        item.getCusCtmMovementVO().setBkgNo(item.getCusCtmMovementVO().getBkgNo());
						        // BKG 요청으로 bkg_container 저장후 return값이 ture면 ctm_mvmt_irr에도 저장 (기본으로 return되는 값은 false). 2009.06.25
						        modifyCntrOpResult = bkgCommand0.modifyCntrOp(item);
						        //2011.03.08 BKG  [CHM-201109320] Brisbane booking missing boxes
						        /* bkg_no별 container NO, Type 생성.*/
						        //formanceCmd.manageQtyCntrCoposite(cusCtmMovementVOs[0].getBkgNo(), "CN");
						        formanceCmd.manageQtyCntrCoposite(item.getCusCtmMovementVO().getBkgNo(), "CN");
						    }
						          // BKG 요청으로 bkg_container 저장후 return값이 ture면 ctm_mvmt_irr에도 저장 (기본으로 return되는 값은 false). 2009-06-25
						     String rtn = command.updateEtcModule(item, modifyCntrOpResult);
						     if (rtn.equals("N")) {
						    	 //rtnStr[0] = "N";
						    	 rtnStr = "Insert irr fail!";
						     }
						     // End : 2014.08.05							
						}

					}
				}

				if (list.size() > 0) {
					ChassisMovementHistoryBC cgmCommand = new ChassisMovementHistoryBCImpl();
					cgmCommand.manageCHSMovementByCtmBasic(list);
				}
				
				//2012.10.25 나상보 - Movement Event Date 변경시에 SEC로 Data가 넘어가도록 해당 Operation 호출을 추가
//				TRLU8836674
//				TES_PUSBO
				if(item.getSceActRcvIfVOs().size() > 0){
					com.hanjin.apps.alps.esd.sce.copdetailreceive.basic.CopDetailReceiveBC sceCommand = 
						new com.hanjin.apps.alps.esd.sce.copdetailreceive.basic.CopDetailReceiveBCImpl();
					
					for(int i = 0; i < item.getSceActRcvIfVOs().size(); i++){
							sceCommand.createCOPMVMT(item.getSceActRcvIfVOs().get(i));
					}
				}
				
				rtnStr = "";
			}

		} catch (EventException ex) {
			log.error("\n\n[SC - modifyMVMTProcess] EventException :\n\n" + ex.getMessage(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("\n\n[SC - modifyMVMTProcess] Exception :\n\n" + ex.getMessage(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return rtnStr;
	}

	/**
	 * EES_CTM_0421 : onload<br>
	 * Restuffing Reason 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReasonList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0421Event event = (EesCtm0421Event)e;
		ContainerMovementMasterDataMgtBC command = new ContainerMovementMasterDataMgtBCImpl();
		try {
			List<CtmMvmtXchRsnVO> list = command.searchReasonList(event.getCtmMvmtXchRsnVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0412 : btn_retrive<br>
	 * BKG container update Irr 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIrregularContainerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0412Event event = (EesCtm0412Event)e;
		ContainerMovementFinderBC command = new ContainerMovementFinderBCImpl();
		try {
			List<CtmMvmtIrrVO> list = command.searchIrregularContainerList(event.getCtmMvmtIrrVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0415 : btn_retrive<br>
	 * Deleted CNTR MVMT History 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDeletedMVMTList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0415Event event = (EesCtm0415Event)e;
		ContainerMovementFinderBC command = new ContainerMovementFinderBCImpl();
		try {
			List<SearchDeletedMVMTListVO> list = command.searchDeletedMVMTList(event.getSearchDeletedMVMTListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0405 : btn_retrive<br>
	 * Empty VL List without BKG 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEmptyBookingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0405Event event = (EesCtm0405Event)e;
		ContainerMovementFinderBC command = new ContainerMovementFinderBCImpl();
		try {
			List<SearchEmptyBookingListVO> list = command.searchEmptyBookingList(event.getSearchEmptyBookingListVO());
			eventResponse.setRsVoList(list);
			// 2016.07.25 김상현 [CHM-201642322] Insert/Delete 처리시, 화면에 보이는 데이터가 최신 데이터인지 체크하는 로직 추가
			//  - 최종 조회 시간 저장
			String lastRetrieveDate = (new ContainerMovementMgtBCImpl()).searchSystemDate();
			eventResponse.setETCData("last_retrieve_date", lastRetrieveDate);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0408 : btn_retrive<br>
	 * Each Container 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMovementListByContainer(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0408Event event = (EesCtm0408Event)e;
		ContainerMovementFinderBC command = new ContainerMovementFinderBCImpl();

		try {
			List<SearchMovementListByContainerVO> list1 = command.searchMovementListByContainer(event.getSearchMovementListByContainerVO());
			eventResponse.setRsVoList(list1);

			// edi_date변수선언
			String ediDate = "";
			// list1의 rowdata가 1건 이상이라면
			if (list1.size() > 0) {
				// ediDate변수에 list1의 마지막 ROW의 CnmvEvntDt필드의 값을 담음
				ediDate = list1.get(list1.size()-1).getCnmvEvntDt();
			}
			// list2에 사용될 vo에 EdiDate필드에 값을 담음
			event.getSearchEdiMsgVO().setEdiDate(ediDate);
			// list2 조회
			List<SearchEdiMsgVO> list2 = command.searchEdiMsg(event.getSearchEdiMsgVO());
			eventResponse.setRsVoList(list2);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0409 : btn_retrive<br>
	 * Each Booking List 조회<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMovementListByBooking(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0409Event event = (EesCtm0409Event)e;
		ContainerMovementFinderBC command = new ContainerMovementFinderBCImpl();

		// 화면으로부터 넘어온 BKG_NO / BL_NO 추출
		String bkgNo = event.getSearchMovementListByBkgInfoVO().getBkgNo();
		String blNo = event.getSearchMovementListByBkgInfoVO().getBlNo();
		StringBuffer comboCode = new StringBuffer();
		StringBuffer comboText = new StringBuffer();

		try {
			if (bkgNo == null || "".equals(bkgNo)) {    // BKG_NO가 없다면
				if (blNo != null && !"".equals(blNo)) {      // BL_NO가 있으면 BL_NO로 BKG_NO를 조회
					bkgNo = command.searchMovementListByGetBkgNo(blNo);
				}
			}

			// 화면으로 넘어온 BKG_NO나 조회된 BKG_NO가 있다면
			if (bkgNo != null && !"".equals(bkgNo)) {
				// 조회조건으로 list1 조회(HTML INPUT용 데이터 )
				List<SearchMovementListByBkgInfoVO> list1 = command.searchMovementListByBkgInfo(bkgNo);
				// list1을 ETC-DATA로 setting
				for (int i=0 ; i<list1.size(); i++) {
					eventResponse.setETCData(list1.get(i).getColumnValues());
				}

				// 조회조건으로 list2 조회(MultiCombo용 데이터) - "S": PRE_VVD
				List<SearchMovementListByVvdForMultiComboVO> list2 = command.searchMovementListByVvdForMultiCombo("S", bkgNo);
				// list2를 ETC-DATA로 setting
				for (int i=0 ; i<list2.size(); i++) {
					comboCode.append(list2.get(i).getPolCd() + "^#^");
					comboText.append(list2.get(i).getVvdCd() + "^#^");
				}
				eventResponse.setETCData("preVvd_comboCode", comboCode.toString());
				eventResponse.setETCData("preVvd_comboText", comboText.toString());

				comboCode = new StringBuffer();
				comboText = new StringBuffer();
				// 조회조건으로 list3 조회(MultiCombo용 데이터) - "U": POST_VVD
				List<SearchMovementListByVvdForMultiComboVO> list3 = command.searchMovementListByVvdForMultiCombo("U", bkgNo);
				// list3을 ETC-DATA로 setting
				for (int i=0 ; i<list3.size(); i++) {
					comboCode.append(list3.get(i).getPolCd() + "^#^");
					comboText.append(list3.get(i).getVvdCd() + "^#^");
				}
				eventResponse.setETCData("postVvd_comboCode", comboCode.toString());
				eventResponse.setETCData("postVvd_comboText", comboText.toString());

				comboCode = new StringBuffer();
				comboText = new StringBuffer();
				// 조회조건으로 list4 조회(MultiCombo용 데이터)
				List<SearchMovementListBySplitBkgNoForMultiComboVO> list4 = command.searchMovementListBySplitBkgNoForMultiCombo(bkgNo);
				// list4을 ETC-DATA로 setting
				for (int i=0 ; i<list4.size(); i++) {
					comboCode.append(list4.get(i).getBkgNoSplit() + "^#^");
					comboText.append(list4.get(i).getBkgNo() + "|" + list4.get(i).getBkgNoSplit() + "|" + list4.get(i).getBlNo() + "^#^");
				}
				eventResponse.setETCData("splitInfo_comboCode", comboCode.toString());
				eventResponse.setETCData("splitInfo_comboText", comboText.toString());

				comboCode = new StringBuffer();
				comboText = new StringBuffer();
				// 조회조건으로 list5 조회(MultiCombo용 데이터)
				List<SearchMovementListByCntrTpszCdVO> list5 = command.searchMovementListByCntrTpszCd(bkgNo);
				// list5을 ETC-DATA로 setting
				for (int i=0 ; i<list5.size(); i++) {
					comboCode.append(list5.get(i).getCntrTpszCd() + "^#^");
					comboText.append(list5.get(i).getCntrTpszCd() + "  :  " + list5.get(i).getOpCntrQty() + "^#^");
				}
				eventResponse.setETCData("cntrTpsz_comboCode", comboCode.toString());
				eventResponse.setETCData("cntrTpsz_comboText", comboText.toString());
				comboCode = null;
				comboText = null;

				// 조회조건으로 list6 조회(SHEET용 데이터 )
				List<SearchMovementListByCntrInfoVO> list6 = command.searchMovementListByCntrInfo(bkgNo);
				eventResponse.setRsVoList(list6);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0440, EES_CTM_0405 : btn_save<br>
	 * VL/VD correction by VVD SAVE<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCorrectionVLVDByVVD(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0440Event event = (EesCtm0440Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();

		//2011.03.08 BKG  [CHM-201109320] Brisbane booking missing boxes
		PerformanceReportBC formanceCmd = new PerformanceReportBCImpl();
		
		try {
			CusCtmMovementVO[] cusVO = event.getCusCtmMovementVOS();
			MVMTBookingInfoVO[] ctmVO = event.getMVMTBookingInfoVOS();
			List<CusCtmMovementVO> list = new ArrayList<CusCtmMovementVO>();
			int priorKnt = 999; // OP, VL 삭제시 동일 bkgno 의 이전 mvmt 수, Booking 데이터 초기화 방지를 위해 0 보다 큰 임의의 수 입력

			for (int idx = 0; idx < cusVO.length; idx++) {

				begin();

				CrossItemVO item = null;
				CusCtmMovementVO[]  param1 = new CusCtmMovementVO[1];
				MVMTBookingInfoVO[] param2 = new MVMTBookingInfoVO[1];
				param1[0] = cusVO[idx];
				ctmVO[idx].setPCntrno(ctmVO[idx].getCntrNo());
				param2[0] = ctmVO[idx];
				item = command.modifyMVMTHistory(param1, param2, account);
				priorKnt = 999; // roop 내에서 초기화

				log.info("조회 결과 DEL FLG :::: " + item.getFinalCfm() + ":::" + item.getUpdateMaster());
				if (item.getFinalCfm().equals("1")) {
					// 모든 행위 중지하고 RollBack... Final Confirm되어있는 자료임.
					rollback();
					eventResponse.setETCData("rtnStr", "Booking container is already confirmed. If you want to delete these status, please adjust booking container first.");
					return eventResponse;
				}
				log.info("대상 서버 :" + param1[0].getCntrSvrId());
				if ("USA".equals(param1[0].getCntrSvrId()) || "SWA".equals(param1[0].getCntrSvrId())) {
					param1[0].setUpdUsrId(account.getUsr_id());
					list.add(param1[0]);
				}

				if (item.getUpdateMaster()) {
					item.getCusCtmMovementVO().setCtmUiYn("Y");    // ctm_ui_yn (0430/0414화면에서의 실행인지 구분값 - MST모듈에서 사용)
					ContainerOnOffhireBC mstCommand = new ContainerOnOffhireBCImpl();
					mstCommand.updateCntrMasterByMvmtBasic(item);

					// OP이고 BKG_CONTAINER에 컨테이너가 존재하지 않을때 BCImpl에서 "X"로 리턴
					// "X"가 아닐때만 BKG모듈을 호출
					if (!"X".equals(item.getFinalCfm())) {
						log.debug("X가 아닐때만 BKG모듈을 호출 시작");
						if (ctmVO[idx].getLstFlg() != null && !"X".equals(ctmVO[idx].getLstFlg())) {
							//[CHM-201642970] OP, VL이 삭제로 booking 정보를 초기화 시 해당 BKG_NO가 정상적으로 입력된 이전 movement가 존재하는지 조회
							if("O".equals(item.getFinalCfm()) || "V".equals(item.getFinalCfm())){
								priorKnt = command.searchSamBkgPriorMvmtKnt(item.getBkgNo(), item.getCntrNo());
							}

							BLDocumentationCMBC bkgCommand0 = new BLDocumentationCMBCImpl();
							if ("O".equals(item.getFinalCfm()) && priorKnt < 1) { // OP삭제
								log.debug("OP Booking 데이터 초기화 시작");
								BlRatingBC bkgCommand1 = new BlRatingBCImpl();
								GeneralBookingReceiptBC bkgCommand2 = new GeneralBookingReceiptBCImpl();
								BookingHistoryMgtBC bkgCommand3 = new BookingHistoryMgtBCImpl();

								bkgCommand0.removeCntrSealNo(item.getBkgNo(), item.getCntrNo(), null, item.getCaFlg());
								bkgCommand1.removeCntrRateByCntr(item.getBkgNo(), item.getCntrNo(), "");
								bkgCommand2.removeReferenceDetailByCntr(item.getBkgNo(), item.getCntrNo(), item.getCaFlg());
								bkgCommand2.removeReferenceByCntr(item.getBkgNo(), item.getCntrNo(), item.getCaFlg());
								bkgCommand0.removeCntrMfDesc(item.getBkgNo(), item.getCntrNo(), item.getCaFlg());
								bkgCommand0.removeContainer(item.getBkgNo(), item.getCntrNo(), item.getCaFlg());

								HistoryLineVO historyLineVO = new HistoryLineVO();
								historyLineVO.setBkgNo(item.getBkgNo());
								historyLineVO.setHisCateNm("Container");
								historyLineVO.setCaFlg("N");
								historyLineVO.setUiId("SYSTEM");
								historyLineVO.setCrntCtnt("Detach Container:" + item.getCntrNo());
								historyLineVO.setBkgDocProcTpCd(null);
								bkgCommand3.createBkgHistoryLine(historyLineVO, account);

								// BKG에서 COP호출 할때 Attch할 것인지 확인하기 위한 코드. C일 경우 호출. D(History에서 호출)일때 삭제
								item.setAttchCd("D");
								// BKG 요청으로 N으로 강제 세팅함. 2009-11-12
								item.setCntrPrtFlg("N");
								// BKG 요청으로 bkg_container 저장후 return값이 ture면 ctm_mvmt_irr에도 저장 (기본으로 return되는 값은 false). 2009-06-25
								boolean modifyCntrOpResult = bkgCommand0.modifyCntrOp(item);
								if (modifyCntrOpResult) {
									command.updateEtcModule(item, modifyCntrOpResult);
								}

								//2011.03.08 BKG  [CHM-201109320] Brisbane booking missing boxes
								/* bkg_no별 container NO, Type 생성.*/
								formanceCmd.manageQtyCntrCoposite(item.getBkgNo(), "CN");
							} else if ("V".equals(item.getFinalCfm()) && priorKnt < 1) { // VL 삭제
								item.setMstBkgCntrOpUpdate(true);
								log.info("원 부킹 번호 :::: " + item.getCusCtmMovementVO().getBkgNo());
								log.info("소스 부킹 번호 :::: " + item.getBkgNo());
								item.getCusCtmMovementVO().setBkgNo(item.getBkgNo());
								item.getCusCtmMovementVO().setCnmvCycNo(item.getCycNo());
								bkgCommand0.modifyCntrHistoryUpdate (item.getCusCtmMovementVO(), "0");

							} else {
								item.setMstBkgCntrOpUpdate(true);
								bkgCommand0.modifyCntrHistoryUpdate (item.getCusCtmMovementVO(), "1");
							}
						}
					}
				}
				
				//2012.10.25 나상보 - Movement Event Date 변경시에 SEC로 Data가 넘어가도록 해당 Operation 호출을 추가
//				TRLU8836674
//				TES_PUSBO
				if(item.getSceActRcvIfVOs().size() > 0){
					com.hanjin.apps.alps.esd.sce.copdetailreceive.basic.CopDetailReceiveBC sceCommand = 
						new com.hanjin.apps.alps.esd.sce.copdetailreceive.basic.CopDetailReceiveBCImpl();
					
					for(int i = 0; i < item.getSceActRcvIfVOs().size() - 1; i++){
						sceCommand.createCOPMVMT(item.getSceActRcvIfVOs().get(i)); 
					}
				}
				
				commit();
			}

			log.info("삭제 대상 리스트 :" + list.size());
			if (list.size() > 0) {
				ChassisMovementHistoryBC cgmCommand = new ChassisMovementHistoryBCImpl();
				cgmCommand.manageCHSMovementByCtmBasic(list);
			}

		} catch (EventException ex) {
			log.error("\n\n[SC - manageCorrectionVLVDByVVD] EventException :\n\n" + ex.getMessage(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("\n\n[SC - manageCorrectionVLVDByVVD] Exception :\n\n" + ex.getMessage(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	

	/**
	 * EES_CTM_0404 : btn_retrive<br>
	 * Update of EDI Message 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEDIMovementList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0404Event event = (EesCtm0404Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();

		try {
			// 정해진 ROW씩 로딩하기 위한 변수 define
			int iPage = event.getSearchEDIMovementListVO().getIPage().equals("") ? 1 : Integer.parseInt(event.getSearchEDIMovementListVO().getIPage());
			int pageRows = Integer.parseInt(event.getSearchEDIMovementListVO().getPagerows());
			int startRowNo = pageRows * (iPage - 1) + 1;
			int endRowNo = pageRows * iPage;

			// searchEDIMovementListVO에 변수 setting
			event.getSearchEDIMovementListVO().setStartRowNo(String.valueOf(startRowNo));
			event.getSearchEDIMovementListVO().setEndRowNo(String.valueOf(endRowNo));
			// searchEDIMovementListVO를 이용하여 List 조회
			List<SearchEDIMovementListVO> list = command.searchEDIMovementList(event.getSearchEDIMovementListVO());

			// XML DATA setting
			eventResponse.setRsVoList(list);

			// list.size()가 0보다 크고 첫조회(Append조회가 아닌) 라면..
			if (iPage < 2) {
				if (list.size() > 0) {
					// 조회조건의 전체카운트 setting
					int rtvTotal = Integer.parseInt(command.searchEDIMovementCount(event.getSearchEDIMovementListVO()));
					eventResponse.setETCData("rtv_total", String.valueOf(rtvTotal));
					// 조회조건의 EDI전체 카운트
					  // 기존 MvmtEdiRsltCd를 추출하여 변수에 임시setting
					String mvmtEdiRsltCd = event.getSearchEDIMovementListVO().getMvmtEdiRsltCd();
					  // SearchEDIMovementListVO의 MvmtEdiRsltCd에 "ALL"을 setting(mvmt_edi_rslt_cd = Y,N)
					event.getSearchEDIMovementListVO().setMvmtEdiRsltCd("ALL");
					  // ediMvmtKnt변수에 조회된 count결과를 setting
					String gndTotal = command.searchEDIMovementCount(event.getSearchEDIMovementListVO());
					  // SearchEDIMovementListVO의 MvmtEdiRsltCd에 임시변수를 다시 setting (VO재사용대비)
					event.getSearchEDIMovementListVO().setMvmtEdiRsltCd(mvmtEdiRsltCd);

					// XML ETC-DATA setting
					  // 조회조건의 EDI전체 카운트 표기구분용
					eventResponse.setETCData("mvmt_edi_rslt_cd", event.getSearchEDIMovementListVO().getMvmtEdiRsltCd());
					  // 조회조건의 EDI전체 카운트
					eventResponse.setETCData("gnd_total", gndTotal);
				} else {
					eventResponse.setETCData("rtv_total", "0");
					eventResponse.setETCData("gnd_total", "0");
				}
			}

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0404 : btn_save<br>
	 * Update of EDI Message 멀티 Save 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageEDIMovement(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0404Event event = (EesCtm0404Event)e;
		ContainerMovementMgtForGateNewBC gatenewCommand = new ContainerMovementMgtForGateNewBCImpl();

		SearchEDIMovementListVO[] searchEDIMovementListVOs = event.getSearchEDIMovementListVOS();
		SearchEDIMovementListVO searchEDIMovementListVO = null;
		FlatFileForGateNewVO flatFileForGateNewVO = null;
		List<SearchEDIMovementListVO> searchEDIMovementList = new ArrayList<SearchEDIMovementListVO>();
		int totalCount = 0;
		int okCount = 0;
		int errorCount = 0;
		int ignoredCount = 0;

		if (searchEDIMovementListVOs != null) {

			for (int k=0; k<searchEDIMovementListVOs.length; k++) {
				searchEDIMovementListVO = null;
				flatFileForGateNewVO = null;
				searchEDIMovementListVOs[k].setEdiUiYn("Y");                   // edi_ui_yn (0404/0414화면에서의 실행인지 구분값)
				searchEDIMovementListVOs[k].setUserId(account.getUsr_id());    // user_id
				searchEDIMovementListVOs[k].setUserNm(account.getUsr_nm());    // user_nm

				if ("R".equals(searchEDIMovementListVOs[k].getIbflag()) || "".equals(searchEDIMovementListVOs[k].getIbflag())) {
					log.info("\n\n===============================================================" +
							  "\n [0404UI] GateNew() - Begin!" +
							  "\n===============================================================\n");
					if ("VL".equals(searchEDIMovementListVOs[k].getEdiMvmtStsCd()) || "VD".equals(searchEDIMovementListVOs[k].getEdiMvmtStsCd()) ) {
						searchEDIMovementListVOs[k].setEdiMvmtStsCd("ZZ");
					}

					try {
						// AssignEdiUiVO2FlatFileVO for GateNew ////////////////////////////
						flatFileForGateNewVO = gatenewCommand.assignEdiUiVO2FlatFileVO(searchEDIMovementListVOs[k]);
						log.info("\n\n===============================================================" +
								  "\n begin_flatFile : ColumnValues" +
								  "\n======================================" +
								  "\n" + flatFileForGateNewVO.getColumnValues().toString().replaceAll(", ", "\n") +
								  "\n======================================" +
								  "\n bkg_number[]=" + java.util.Arrays.toString(flatFileForGateNewVO.getBkgNumber()) +
								  "\n===============================================================\n");
						// BCImpl.GateNew 시작  ////////////////////////////////////////////
						begin();    // gateNew BEGIN
						flatFileForGateNewVO = gatenewCommand.gateNew(flatFileForGateNewVO);
						commit();
						log.info("\n\n===============================================================" +
								  "\n finish_flatFile : ColumnValues" +
								  "\n======================================" +
								  "\n" + flatFileForGateNewVO.getColumnValues().toString().replaceAll(", ", "\n") +
								  "\n======================================" +
								  "\n bkg_number[]=" + java.util.Arrays.toString(flatFileForGateNewVO.getBkgNumber()) +
								  "\n===============================================================\n");
					} catch (EventException ex) {
						rollback();
						log.error("\n\n[SC - (0404UI) GateNew] EventException :\n\n" + ex.getMessage(), ex);
						throw ex;
					} catch (Exception ex) {
						rollback();
						log.error("\n\n[SC - (0404UI) GateNew] Exception :\n\n" + ex.getMessage(), ex);
						throw new EventException(ex.getMessage(), ex);
					}

					// return된 flatFileForGateNewVO가 null이 아니라면 /////////////////
					if (flatFileForGateNewVO != null) {
						// manageGateNewProcess ////////////////////////////////////////
						flatFileForGateNewVO = manageGateNewProcess(flatFileForGateNewVO);
						// AssignFlatFileVO2EdiUiVO for GateNew ////////////////////////
						searchEDIMovementListVO = gatenewCommand.assignFlatFileVO2EdiUiVO(flatFileForGateNewVO, searchEDIMovementListVOs[k]);
					}
					log.info("\n\n===============================================================" +
							  "\n [0404UI] GateNew() - Finish!" +
							  "\n===============================================================\n");

				} else if ("U".equals(searchEDIMovementListVOs[k].getIbflag())) {
					log.info("\n\n===============================================================" +
							  "\n [0404UI] manageEDIProcess() - Begin!" +
							  "\n===============================================================\n");
				    // EDIProcess //////////////////////////////////////////////////////
					searchEDIMovementListVO = manageEDIProcess(searchEDIMovementListVOs[k]);
					log.info("\n\n===============================================================" +
							  "\n [0404UI] manageEDIProcess() - Finish!" +
							  "\n===============================================================\n");
				}

				// return된 searchEDIMovementListVO가 null이 아니라면 /////////////////
				if (searchEDIMovementListVO != null) {
					try {
						int rtyKnt = Integer.parseInt(searchEDIMovementListVOs[k].getRtyKnt()) + 1;
						searchEDIMovementListVO.setRtyKnt(String.valueOf(rtyKnt));    // rty_knt
						begin();    // resultUpdb BEGIN
						log.debug("\n\n===============================================================" +
								  "\n gatenewCommand.resultUpdb()" +
								  "\n===============================================================\n");
						searchEDIMovementListVO = gatenewCommand.resultUpdb(searchEDIMovementListVO);
						commit();
					} catch (EventException ex) {
						rollback();
						log.error("\n\n resultUpdb : EventException\n" + ex.toString(), ex);
						throw ex;
					} catch (Exception ex) {
						rollback();
						log.error("\n\n resultUpdb : Exception\n" + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					}

					// Count : mvmtEdiRsltCd가 Y가 아닌 경우에만 resultList에 add
					if ("N".equals(searchEDIMovementListVO.getMvmtEdiRsltCd())) {
						searchEDIMovementList.add(searchEDIMovementListVO);
						errorCount = errorCount + 1;
					} else if ("X".equals(searchEDIMovementListVO.getMvmtEdiRsltCd()) || "I".equals(searchEDIMovementListVO.getMvmtEdiRsltCd())) {
						ignoredCount = ignoredCount + 1;
					} else {
						okCount = okCount + 1;
					}
					totalCount = totalCount + 1;
				}
			}
		}

		// 결과값 setting
		eventResponse.setETCData("total_count", String.valueOf(totalCount));
		eventResponse.setETCData("ok_count",  String.valueOf(okCount));
		eventResponse.setETCData("error_count",  String.valueOf(errorCount));
		eventResponse.setETCData("ignored_count",  String.valueOf(ignoredCount));
		eventResponse.setRsVoList(searchEDIMovementList);
		return eventResponse;
	}

	/**
	 * EquipmentMovementMgtSC : manageEDIMovement에서 호출<br>
	 * Update of EDI Process 처리<br>
	 *
	 * @param SearchEDIMovementListVO searchEDIMovementListVO
	 * @return SearchEDIMovementListVO
	 * @exception EventException
	 */
	private SearchEDIMovementListVO manageEDIProcess(SearchEDIMovementListVO searchEDIMovementListVO) throws EventException {
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		ContainerMovementValidationBC commonCommand = new ContainerMovementValidationBCImpl();
		ContainerMovementMgtForGateNewBC gatenewCommand = new ContainerMovementMgtForGateNewBCImpl();

		CusCtmMovementVO[] cusCtmMovementVOs = null;
		String[] returnValues = new String[2];
		String[] bkgNoArray = null;
		
		log.debug("\n==================== ACIAC_DIV_CD를 Check ====================");
		String[] checkAciacDivCdYN = new String[3];
		try {
			checkAciacDivCdYN = gatenewCommand.checkAciacDivCd(searchEDIMovementListVO.getCntrNo(), searchEDIMovementListVO.getBkgNo());
			// checkAciacDivCdYN[0] : ResultMessage
			// checkAciacDivCdYN[1] : ResultIndicator
			// checkAciacDivCdYN[2] : checkAciacDivCdYN(Y/N)
			// checkAciacDivCdYN[3] : cntrTpszCd
		} catch (EventException ex) {
			log.error("\n\nerr " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("\n\nerr " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		if ("N".equals(checkAciacDivCdYN[2])) {
			searchEDIMovementListVO.setMvmtEdiRmk(checkAciacDivCdYN[0]);
			searchEDIMovementListVO.setMvmtEdiRsltCd(checkAciacDivCdYN[1]);

		} else {
			if ("USSLCR2".equals(searchEDIMovementListVO.getEvntYdCd()) || "USTYSR3".equals(searchEDIMovementListVO.getEvntYdCd()) || "USJANKC".equals(searchEDIMovementListVO.getEvntYdCd())) {
				log.debug("\n==================== Ignored Yard(USSLCR2, USTYSR3, USJANKC) ====================");
				searchEDIMovementListVO.setMvmtEdiRmk("Ignored Yard(USSLCR2, USTYSR3, USJANKC)");
				searchEDIMovementListVO.setMvmtEdiRsltCd("X");

			} else if ("ER".equals(searchEDIMovementListVO.getEdiMvmtStsCd())) {
				log.debug("\n==================== EdiMvmtSts가 ER일때는 CTM_COMMON Skip ====================");
				searchEDIMovementListVO.setMvmtEdiRmk("STS CHECK ERROR");
				searchEDIMovementListVO.setMvmtEdiRsltCd("N");

			} else {
				log.debug("\n==================== CTM_COMMON 시작 ====================");
				// EdiMvmtSts가 OP, OC일때만 SUB_BKG를 호출
				if ("OP".equals(searchEDIMovementListVO.getEdiMvmtStsCd()) || "OC".equals(searchEDIMovementListVO.getEdiMvmtStsCd())) {
					try {
						bkgNoArray = command.getBkgNoByEDICntrInfo(searchEDIMovementListVO);
					} catch (EventException ex) {
						log.error("\n\nerr " + ex.toString(), ex);
						throw ex;
					} catch (Exception ex) {
						log.error("\n\nerr " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					}
				}

				if (bkgNoArray != null && bkgNoArray.length > 0) {
					/* getEdiVOs[i] + sub bkg_no배열갯수만큼 생성 */
					cusCtmMovementVOs = new CusCtmMovementVO[1 + bkgNoArray.length];
				} else {
					cusCtmMovementVOs = new CusCtmMovementVO[1];
				}

				for (int i = 0; i < cusCtmMovementVOs.length; i++) {
					cusCtmMovementVOs[i] = new CusCtmMovementVO();

					cusCtmMovementVOs[i].setBkgKnt(cusCtmMovementVOs.length + "");
					if (i == 0) {
						cusCtmMovementVOs[i].setBkgNo(searchEDIMovementListVO.getBkgNo());
					} else {
						cusCtmMovementVOs[i].setBkgNo(bkgNoArray[i - 1]);
					}
				    cusCtmMovementVOs[i].setBlNo(searchEDIMovementListVO.getBlNo());
				    cusCtmMovementVOs[i].setCallSgnNo(searchEDIMovementListVO.getCallSgnNo());
				    cusCtmMovementVOs[i].setChssNo(searchEDIMovementListVO.getChssNo());
					cusCtmMovementVOs[i].setCnmvEvntDt(searchEDIMovementListVO.getEvntDt());
					cusCtmMovementVOs[i].setCnmvYr(DateTime.getFormatDate(new java.util.Date(), "yyyy"));
					cusCtmMovementVOs[i].setCntrNo(searchEDIMovementListVO.getCntrNo());
				    cusCtmMovementVOs[i].setCntrSealNo(searchEDIMovementListVO.getCntrSealNo());
					cusCtmMovementVOs[i].setCreUsrId(account.getUsr_id());
					cusCtmMovementVOs[i].setCrntSkdDirCd(searchEDIMovementListVO.getCrntSkdDirCd());
					cusCtmMovementVOs[i].setCrntSkdVoyNo(searchEDIMovementListVO.getCrntSkdVoyNo());
					cusCtmMovementVOs[i].setCrntVslCd(searchEDIMovementListVO.getCrntVslCd());
				    cusCtmMovementVOs[i].setDestYdCd(searchEDIMovementListVO.getDestYdCd());

				    String fullEmptyFlag = (searchEDIMovementListVO.getCntrFullStsCd() == null ? "" : String.valueOf(searchEDIMovementListVO.getCntrFullStsCd()));
					if ("F".equals(fullEmptyFlag) || "L".equals(fullEmptyFlag) || "AH".equals(fullEmptyFlag)) {
						cusCtmMovementVOs[i].setFcntrFlg("F");
					} else if ("M".equals(fullEmptyFlag) || "E".equals(fullEmptyFlag) || "AB".equals(fullEmptyFlag) || "AJ".equals(fullEmptyFlag)) {
						cusCtmMovementVOs[i].setFcntrFlg("M");
				    } else {
						cusCtmMovementVOs[i].setFcntrFlg("F");
					}

					// 2016.07.01 김상현 [CHM-201642185] EDI 수신된 OP status에 F/M 값이 F이면 M으로 변경
					//  - 사용자 입력 status에 따라 F/M 값 변경 logic 추가
					if (("OP".equals(searchEDIMovementListVO.getEdiMvmtStsCd()) || "MT".equals(searchEDIMovementListVO.getEdiMvmtStsCd()))
							&& "F".equals(cusCtmMovementVOs[i].getFcntrFlg())) {
						cusCtmMovementVOs[i].setFcntrFlg("M");
					} else if (("OC".equals(searchEDIMovementListVO.getEdiMvmtStsCd()) || "ID".equals(searchEDIMovementListVO.getEdiMvmtStsCd()))
							&& "M".equals(cusCtmMovementVOs[i].getFcntrFlg())) {
						cusCtmMovementVOs[i].setFcntrFlg("F");
					}

				    cusCtmMovementVOs[i].setMgstNo(searchEDIMovementListVO.getMgstNo());
					cusCtmMovementVOs[i].setMvmtEdiMsgAreaCd(searchEDIMovementListVO.getMvmtEdiMsgAreaCd());
					cusCtmMovementVOs[i].setMvmtEdiMsgSeq(searchEDIMovementListVO.getMvmtEdiMsgSeq());
					cusCtmMovementVOs[i].setMvmtEdiMsgTpId(searchEDIMovementListVO.getMvmtEdiMsgTpId());
					cusCtmMovementVOs[i].setMvmtEdiMsgYrmondy(searchEDIMovementListVO.getMvmtEdiMsgYrmondy());
					cusCtmMovementVOs[i].setMvmtEdiTpCd(searchEDIMovementListVO.getMvmtEdiTpCd());
					cusCtmMovementVOs[i].setMvmtStsCd(searchEDIMovementListVO.getEdiMvmtStsCd());
				    cusCtmMovementVOs[i].setMvmtTrspModCd(searchEDIMovementListVO.getMvmtTrspModCd());
					cusCtmMovementVOs[i].setOfcCd(account.getOfc_cd());
					cusCtmMovementVOs[i].setOrgYdCd(searchEDIMovementListVO.getEvntYdCd());
					cusCtmMovementVOs[i].setPkupNo(searchEDIMovementListVO.getPkupNo());
					if ("VD".equals(searchEDIMovementListVO.getEdiMvmtStsCd())) {
					    cusCtmMovementVOs[i].setPodCd(subStr(searchEDIMovementListVO.getEvntYdCd(), 0, 5));
					} else if ("VL".equals(searchEDIMovementListVO.getEdiMvmtStsCd())) {
					    cusCtmMovementVOs[i].setPolCd(subStr(searchEDIMovementListVO.getEvntYdCd(), 0, 5));
					}
					cusCtmMovementVOs[i].setUpdUsrId(account.getUsr_id());
					cusCtmMovementVOs[i].setUsrNm(account.getUsr_nm());
				    cusCtmMovementVOs[i].setVndrSeq(searchEDIMovementListVO.getVndrSeq());
					cusCtmMovementVOs[i].setWblNo(searchEDIMovementListVO.getWblNo());
					cusCtmMovementVOs[i].setCnmvRmk(searchEDIMovementListVO.getCnmvRmk());
					cusCtmMovementVOs[i].setVgmMzdTpCd(searchEDIMovementListVO.getVgmMzdTpCd());
					cusCtmMovementVOs[i].setVgmRefNo(searchEDIMovementListVO.getVgmRefNo());
					cusCtmMovementVOs[i].setVgmSigCtnt(searchEDIMovementListVO.getVgmSigCtnt());
					cusCtmMovementVOs[i].setVgmVrfyDt(searchEDIMovementListVO.getVgmVrfyDt());
					cusCtmMovementVOs[i].setVgmVrfyOrdCtnt(searchEDIMovementListVO.getVgmVrfyOrdCtnt());
					cusCtmMovementVOs[i].setVgmWgtPtyCtnt(searchEDIMovementListVO.getVgmWgtPtyCtnt());
					cusCtmMovementVOs[i].setVgmWgtQty(searchEDIMovementListVO.getVgmWgtQty());
					cusCtmMovementVOs[i].setVgmWgtUtCd(searchEDIMovementListVO.getVgmWgtUtCd());
				}
				
				// MvmtStsCd가 "C"로 시작하면 Domestic-COMMON을 호출
				if ("C".equals(subStr(searchEDIMovementListVO.getEdiMvmtStsCd(), 0, 1))) {

					/* Domestic MVMT Common 호출 (S) ++++++++++++++++++++++++++++++++++++++++++++++++++*/
					log.debug("\n\n===============================================================" +
							  "\n manageDomesticMVMT(vos[0], account) ++++++ Domestic MVMT Common 호출" +
							  "\n===============================================================\n");
					
					try {
						begin();    // Domestic-COMMON BEGIN
						CrossItemVO item = command.manageDomesticMVMT(cusCtmMovementVOs[0], commonCommand.searchUserCntCode(account.getOfc_cd()));
						returnValues = item.getRtnStr();
						if ("N".equals(returnValues[0])) {
							rollback();    // Domestic-COMMON ROLLBACK
						} else {
							if (item.getUpdateMaster() == true) {
								ContainerOnOffhireBC mstCommand = new ContainerOnOffhireBCImpl();
								mstCommand.updateCntrMasterByMvmtBasic(item);
							}
							commit();    //  Domestic-COMMON COMMIT
							
							// 2013.09.24 강   환 [CHM-201325811] Each Container Inquiry 기능 보완 (CO-CP생성시 auto  생성된 MT 를 SCEM에 추가 IF)
							if(item.getSceActRcvIfVOs().size() > 0){
								com.hanjin.apps.alps.esd.sce.copdetailreceive.basic.CopDetailReceiveBC sceCommand = 
									new com.hanjin.apps.alps.esd.sce.copdetailreceive.basic.CopDetailReceiveBCImpl();
								
								for(int i = 0; i < item.getSceActRcvIfVOs().size(); i++){
										sceCommand.createCOPMVMT(item.getSceActRcvIfVOs().get(i));
								}
							}
							// 2013.09.24 강   환 [CHM-201325811] Each Container Inquiry 기능 보완 (CO-CP생성시 auto  생성된 MT 를 SCEM에 추가 IF)

						}
					} catch (EventException ex) {
						/******************************************************
						 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음   *
						 ******************************************************/
						rollback();    // Domestic-COMMON ROLLBACK
						returnValues[0] = "N";
						returnValues[1] = ex.getMessage().replace("APP", "").replaceAll("<", "").replaceAll("\\|", "").replaceAll(">", "");
						log.error("\n\nerr " + ex.toString(), ex);
					} catch (Exception ex) {
						rollback();    // Domestic-COMMON ROLLBACK
						log.error("\n\nerr " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					}
					log.debug("\n\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Domestic-COMMON_STS : " + returnValues[0] +
							  "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Domestic-COMMON_MSG : " + returnValues[1] + "\n");
					/* Domestic MVMT COmmon 호출 (E) ++++++++++++++++++++++++++++++++++++++++++++++++++*/


				// 아니면 CTM-COMMON을 호출
				} else {

					/* MVMT Common 호출 (S) ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
					log.debug("\n\n===============================================================" +
							  "\n manageCreateProcess(setCustVOs, length) ++++++ MVMT Common 호출" +
							  "\n===============================================================\n");
					try {
						begin();    // COMMON BEGIN
						returnValues = manageCreateProcess(cusCtmMovementVOs, cusCtmMovementVOs.length, false, false);
						if ("N".equals(returnValues[0])) {
							rollback();    // COMMON ROLLBACK
						} else {
							commit();    //  COMMON COMMIT
						}
					} catch (EventException ex) {
						/******************************************************
						 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음   *
						 ******************************************************/
						rollback();    // COMMON ROLLBACK
						returnValues[0] = "N";
						returnValues[1] = ex.getMessage();
						log.error("\n\nerr " + ex.toString(), ex);
					} catch (Exception ex) {
						rollback();    // COMMON ROLLBACK
						log.error("\n\nerr " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					}
					log.debug("\n\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% COMMON_STS : " + returnValues[0] +
							  "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% COMMON_MSG : " + returnValues[1] + "\n");
					/* MVMT Common2 호출 (E) +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
				}

				if (returnValues[0] == null || returnValues[0].trim().equals("") || returnValues[0].trim().equals("null")) {
					returnValues[0] = "";
				} else {
					returnValues[0] = returnValues[0].trim();
				}
				if (returnValues[1] == null || returnValues[1].trim().equals("") || returnValues[1].trim().equals("null")) {
					returnValues[1] = "";
				} else {
					returnValues[1] = returnValues[1].trim();
				}

				// result값을 searchEDIMovementListVO에 setting
				searchEDIMovementListVO.setMvmtEdiRsltCd(returnValues[0]);
				searchEDIMovementListVO.setMvmtEdiRmk(returnValues[1]);
			}
		}
		return searchEDIMovementListVO;
	}

	/**
	 * EES_CTM_0442 : btn_retrive<br>
	 * Detail Information 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEDIByContainer(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0442Event event = (EesCtm0442Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		try {
			List<SearchEDIByContainerVO> list1 = command.searchEDIByContainer(event.getSearchEDIByContainerVO());
			// list0을 ETC-DATA로 setting
			for (int i = 0; i < list1.size(); i++) {
				eventResponse.setETCData(list1.get(i).getColumnValues());
			}

			List<SearchEDIByResultRemarkVO> list2 = command.searchEDIByResultRemark(event.getSearchEDIByResultRemarkVO());
			// list1을 DATA로 setting
			eventResponse.setRsVoList(list2);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0406 : btn_retrive<br>
	 * International의 VL/VD 조회에 대한 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVLVDList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0406Event event = (EesCtm0406Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		try {
			List<SearchCLMInfoVO> list = command.searchVLVDList(event.getSearchCLMInfoVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0406 : Grid (Container onChange Event)<br>
	 * Container번호 조회 후 해당 컨테이너에 예약되어있는 부킹 리스트를 조회한다<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgCntrList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0406Event event = (EesCtm0406Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		try {
			List<SearchBkgCntrListVO> list = command.searchBkgCntrList(event.getSearchBkgCntrListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0406 : btn_save<br>
	 * Container Movement Status 다건의 List 등록<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageInternationalMVMT(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0406Event event = (EesCtm0406Event)e;
		String oldCntrNo = null;
		StringBuffer rtnString = new StringBuffer();

		CtmCntrMovInfoVO[] vos = event.getCtmCntrMovInfoVOS();

		CusCtmMovementVO[] opVos = new CusCtmMovementVO[vos.length+1];
		List<CusCtmMovementVO> errVos = new ArrayList<CusCtmMovementVO>();
		CusCtmMovementVO opVo  = null;
		CtmCntrMovInfoVO vo = null;
		int idx = 0;
		boolean autoExec = true;
		for (int i = 0; i < vos.length; i++) {
			vo = vos[i];
			opVo = new CusCtmMovementVO();
			opVo.setBkgNo(vo.getBkgNo());
			opVo.setBkgCgoTpCd(vo.getBkgCgoTpCd());
			opVo.setBkgRcvTermCd(vo.getRcvTermCd());
			opVo.setChssNo(vo.getChssNo());
			opVo.setCnmvEvntDt(vo.getCnmvEvntDt());
			opVo.setCntrNo(vo.getCntrNo() + vo.getCheckDigit());
			opVo.setCntrSealNo(vo.getCntrSealNo());
			opVo.setCntrSvrId(vo.getCntrSvrId());
			opVo.setCntrTpszCd(vo.getCntrTpszCd());
			if (vo.getCreUsrId() != null && !vo.getCreUsrId().equals(""))
				opVo.setCreUsrId(account.getUsr_id());
			else
				opVo.setCreUsrId(vo.getCreUsrId());
			opVo.setDestYdCd(vo.getDestYdCd());
			opVo.setFcntrFlg(vo.getFcntrFlg());
			opVo.setMvmtStsCd(vo.getMvmtStsCd());
			opVo.setOrgYdCd(vo.getOrgYdCd());
			opVo.setVndrSeq(vo.getVndrSeq());
			opVo.setCntrSealNo(vo.getCntrSealNo());
			opVo.setMgstNo(vo.getMgstNo());
			opVo.setCnmvRmk(vo.getCnmvRmk());
			opVo.setMvmtTrspModCd(vo.getMvmtTrspModCd());
			opVo.setSpclCgoFlg(vo.getSpclCgoFlg());
			opVo.setTrnkSkdDirCd(vo.getTrnkSkdDirCd());
			opVo.setTrnkSkdVoyNo(vo.getTrnkSkdVoyNo());
			opVo.setTrnkVslCd(vo.getTrnkVslCd());
			opVo.setCrntSkdDirCd(vo.getCrntSkdDirCd());
			opVo.setCrntSkdVoyNo(vo.getCrntSkdVoyNo());
			opVo.setCrntVslCd(vo.getCrntVslCd());
			opVo.setPolCd(vo.getPolCd());
			opVo.setPodCd(vo.getPodCd());
			String cntrNo = vo.getCntrNo() + vo.getCheckDigit();

			if (oldCntrNo != null && oldCntrNo.equals(cntrNo)) {
				if (autoExec) {
					opVo.setBkgNoSplit("Y");
				} else {
					opVo.setBkgNoSplit("N");
				}
				opVos[i] = opVo;
			}
			if (oldCntrNo != null && !oldCntrNo.equals(cntrNo)) {
				// 이전 컨테이너 번호가 존재하고 현재 컨테이너 번호와 동일 하지 않을 경우
				// 자동 생성 로직을 타도록
				begin();
				String[] rtnStrs = null;
				try {
					rtnStrs = manageCreateProcess(opVos, idx, false, true);
					if (rtnStrs[0] != null && (rtnStrs[0].equals("N") || rtnStrs[0].equals("I")) ) {
						//opVo.setErrMsg(rtnStrs[1]);
						rollback();
						for (int x = 0; x < idx; x++) {
							opVos[x].setErrMsg(rtnStrs[1]);
							errVos.add(opVos[x]);
							rtnString.append(rtnStrs[1]).append("^^");
							log.debug(rtnStrs[1] + "^^");
						}
					} else {
						commit();
						for (int x = 0; x < idx; x++) {
							rtnString.append(rtnStrs[1]).append("^^");
							log.debug(rtnStrs[1] + "^^");
						}
					}
					opVos = null;
					idx = 0;
					opVos = new CusCtmMovementVO[vos.length+1];
					opVos[idx++] = opVo;
				} catch (Exception ex) {
					/***************************************************************
					 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음 *
					 ***************************************************************/
					rollback();
					for (int x = 0; x < (idx); x++) {
						opVos[x].setErrMsg(rtnStrs[1]);
						errVos.add(opVos[x]);
						rtnString.append(rtnStrs[1]).append("^^");
						log.debug(rtnStrs[1] + "^^");
					}
					log.error(ex.getMessage(),ex);
				}
			} else {
				// 그렇지 않은 경우 자동 생성은 생략하고 배열에 자료를 담아둔다.
				opVos[idx] = opVo;
				idx++;
			}
			oldCntrNo = cntrNo;
		}
		// LOOP 종료 후 처리되지 못한 (마지막 컨테이너)를 실행 하도록 해준다.

		begin();
		String[] rtnStrs = null;
		try {
			log.info("SPP EVENT START ");
			log.info(opVos.length);
			rtnStrs = manageCreateProcess(opVos, idx, false, true);
			if (rtnStrs[0] != null && (rtnStrs[0].equals("N") || rtnStrs[0].equals("I"))) {
				rollback();
				for (int x = 0; x < (idx); x++) {
					opVos[x].setErrMsg(rtnStrs[1]);
					errVos.add(opVos[x]);
					rtnString.append(rtnStrs[1]).append("^^");
					log.debug(rtnStrs[1] + "^^");
				}
			} else {
				commit();
				//rollback();
				for (int x = 0; x < (idx); x++) {
					rtnString.append(rtnStrs[1]).append("^^");
					log.debug(rtnStrs[1] + "^^");
				}
			}
		} catch (Exception ex) {
			/***************************************************************
			 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음 *
			 ***************************************************************/
			rollback();
			for (int x = 0; x < (idx); x++) {
				rtnString.append(rtnStrs[1]).append("^^");
				log.debug(rtnStrs[1] + "^^");
				opVos[x].setErrMsg(rtnStrs[1]);
				errVos.add(opVos[x]);
			}
			log.error(ex.getMessage(),ex);
		}

		eventResponse.setRsVoList(errVos);
		//eventResponse.setETCData("rtnStr", rtnString.toString());
		return eventResponse;
	}

	/**
	 * EES_CTM_0406 : manageMovement, EDI수신, SPP수신(WebService) 등
	 * Container Movement Status 다건의 List 등록
	 * 
	 * @param cusCtmMovementVOS
	 * @param endCount
	 * @param nBkgNoFlg
	 * @param callType
	 *  - true  : manageInternationalMVMT에서 호출
	 *	- false : 그 외에서 호출
	 * @return String[]
	 * @throws EventException
	 * 
     * 2010.09.09 김상수 [CHM-201005675-01] Split 01-M&R SYSTEM에서 Damage Flag 자동 제거
     *  - MNR쪽 VO에 필요데이터를 setting후 MNR쪽 오퍼레이션 호출
     *  - (movement Status가 OP일때 MST_CONTAINER의 dmg_flg가 Y이면  dmg_flg를 Unflagging)
     * 2010.11.15 원종규 [CHM-201007070-01] [SCE] CTM 에서 ACTUAL DATE 정보 전달시 항목 추가 요청
     *  - CTM 에서 ACTUAL DATE 를 SCE 로 전송하기 위해 다음 항목들을 추가
     *  - CopDetailReceiveBC / createCOPMVMT(SceActRcvIfVO actVo)
	 */
	public String[] manageCreateProcess(CusCtmMovementVO[] cusCtmMovementVOS, int endCount, boolean nBkgNoFlg, boolean callType) throws EventException {
		String[] rtnStr = new String[4];
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		// 2011.03.08 BKG  [CHM-201109320] Brisbane booking missing boxes
		PerformanceReportBC formanceCmd = new PerformanceReportBCImpl();

		CrossItemVO item = new CrossItemVO();
		String user_Id, user_Nm, ofc_Cd;
		try {
			for (int i=0; i<endCount; i++) {
				if (cusCtmMovementVOS[i] != null) {
				    // Argument로 넘어온 endCount를 BkgKnt로 setting
					cusCtmMovementVOS[i].setBkgKnt(String.valueOf(endCount));
				    // 현재년도 추출
					cusCtmMovementVOS[i].setCnmvYr(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
					// VL 또는 VD가 아닐때는 vvd코드를 clear
					if (!cusCtmMovementVOS[i].getMvmtStsCd().equals("VL") && !cusCtmMovementVOS[i].getMvmtStsCd().equals("VD")) {
						cusCtmMovementVOS[i].setCrntVslCd("");
						cusCtmMovementVOS[i].setCrntSkdVoyNo("");
						cusCtmMovementVOS[i].setCrntSkdDirCd("");
					}
				}
			}

			// ofc_Cd, user_Nm, user_Id 추출
			if (cusCtmMovementVOS[0].getOfcCd()!=null && !cusCtmMovementVOS[0].getOfcCd().equals("")) {
				ofc_Cd = cusCtmMovementVOS[0].getOfcCd();
			} else if (account != null) {
				ofc_Cd = account.getOfc_cd();
			} else {
				ofc_Cd = "";
			}

			if (cusCtmMovementVOS[0].getUsrNm() != null && !cusCtmMovementVOS[0].getUsrNm().equals("")) {
				user_Nm = cusCtmMovementVOS[0].getUsrNm();
			}  else if (account != null) {
				user_Nm = account.getUsr_nm();
			} else {
				user_Nm = "";
			}

			if (cusCtmMovementVOS[0].getCreUsrId() != null && !cusCtmMovementVOS[0].getCreUsrId().equals("")) {
				user_Id = cusCtmMovementVOS[0].getCreUsrId();
			} else if (account != null) {
				user_Id = account.getUsr_id();
			} else {
				user_Id = "ETCUSER";
			}

			// 컨테이너 이동 정보 등록 (Container Movement Status Insert)
			item = command.manageStsOperation(cusCtmMovementVOS, user_Id, user_Nm, ofc_Cd, endCount, nBkgNoFlg);
		} catch (Exception ex) {
			// 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음
			rtnStr[0] = "N";
			rtnStr[1] = ex.getMessage().replace("APP", "").replaceAll("<", "").replaceAll("\\|", "").replaceAll(">", "");
			log.error(ex.getMessage(), ex);
			return rtnStr;
		}

		rtnStr = item.getRtnStr();
		CusCtmMovementVO cusVo = null;
		if (rtnStr[0] == null || (rtnStr[0].equals("") || rtnStr[0].equalsIgnoreCase("null")  || rtnStr[0].equals("Y"))) {
			try {
				if (rtnStr[0] != null && rtnStr[0].equals("Y")) {
					int vosLength = 0;
					if (callType) {
						// callType이 true면 manageInternationalMVMT에서 호출하는것이므로
						// loop에서 마지막 VO를 제외
						vosLength = cusCtmMovementVOS.length - 1;
					} else {
						// callType이 false면 전체 vo수만큼 loop
						vosLength = cusCtmMovementVOS.length;
					}

					for (int dx=0; dx<vosLength; dx++) {
						cusCtmMovementVOS[dx].setMvmtCreTpCd("R");
						if (rtnStr[0] != null && (rtnStr[1].equals("A") || rtnStr[1].equals("B"))) {
							cusCtmMovementVOS[dx].setNewFlg(rtnStr[1]);    // B: 신조 MT생성 / C: 신조 MT삭제 / X: XX생성 / Y: VL,IC의 XX삭제
						}
					}
				}
			} catch (Exception ex) {
				// 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음
				log.error(ex.getMessage(), ex);
			}

			if (item.getCusCtmMovementVO() != null) {
				cusVo = (CusCtmMovementVO)item.getCusCtmMovementVO().clone();
			} else {
				return item.getRtnStr();
			}

			if (rtnStr[0] != null && rtnStr[0].equals("Y") && rtnStr[1].equals("B")) {
				item.setUpdateMaster(true);
				cusCtmMovementVOS[0].setUpdUsrId(user_Id);
				item.setCusCtmMovementVO(cusCtmMovementVOS[0]);
				rtnStr[1] = "";
			}

			if (rtnStr[0] == null || rtnStr[0].equals("Y") || rtnStr[0].equals("")) {
				try {
					if (rtnStr[0] != null && (rtnStr[0].equals("N") || rtnStr[0].equals("I"))) return rtnStr;
					// MST 호출
					if (item.getUpdateMaster() == true) {
						item.getCusCtmMovementVO().setCntrId(item.getCusCtmMovementVO().getCrntVslCd() + item.getCusCtmMovementVO().getCrntSkdVoyNo() + item.getCusCtmMovementVO().getCrntSkdDirCd());
						ContainerOnOffhireBC mstCommand = new ContainerOnOffhireBCImpl();
						mstCommand.updateCntrMasterByMvmtBasic(item);
					}
				} catch (Exception e) {
					// 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음
					rtnStr[0] = "N";
					rtnStr[1] = e.getMessage().replace("APP", "").replaceAll("<", "").replaceAll("\\|", "").replaceAll(">", "");
					log.error(e.getMessage(), e);
					return rtnStr;
				}

				boolean modifyCntrOpResult = false;
				try {
					// BKG 호출 - 실패하더라도 현재까지는 Commit
					if (item.getMstBkgCntrOpUpdate()) {
						String stsCd = item.getCusCtmMovementVO().getMvmtStsCd();
						BLDocumentationCMBC bkgCommand0 = new BLDocumentationCMBCImpl();
						BookingHistoryMgtBC bkgCommand1 = new BookingHistoryMgtBCImpl();
						HistoryLineVO historyLineVO = null;
						if ((stsCd.equals("OP") || stsCd.equals("OC")) && endCount > 1) {
							for (int imv=0; imv<endCount; imv++) {
								if (item.getFindBkgCntr()) { // BKG에서 COP호출 할때 Attch할 것인지 확인하기 위한 코드. C일 경우 호출. D(History에서 호출)일때 삭제
									item.setAttchCd("C");
								} else {
									item.setAttchCd("U");

									// 신규 생성일때 BKG History 관리 호출
									historyLineVO = new HistoryLineVO();
									historyLineVO.setBkgNo(cusCtmMovementVOS[imv].getBkgNo());
									historyLineVO.setHisCateNm("Container");
									historyLineVO.setCaFlg("N");
									historyLineVO.setUiId("SYSTEM");
									historyLineVO.setCrntCtnt("Attach Container:" + cusCtmMovementVOS[0].getCntrNo());
									historyLineVO.setBkgDocProcTpCd(null);
									bkgCommand1.createBkgHistoryLine(historyLineVO, account);
								}

								item.getCusCtmMovementVO().setBkgNo(cusCtmMovementVOS[imv].getBkgNo());
								// BKG 요청으로 bkg_container 저장후 return값이 true면 ctm_mvmt_irr에도 저장 (기본으로 return되는 값은 false). 2009.06.25
								modifyCntrOpResult = bkgCommand0.modifyCntrOp(item);

								// 2011.03.08 BKG  [CHM-201109320] Brisbane booking missing boxes
								// bkg_no별 container NO, Type 생성.
								formanceCmd.manageQtyCntrCoposite(cusCtmMovementVOS[imv].getBkgNo(), "CN");
							}
						} else {
							if (item.getFindBkgCntr()) {
								// BKG에서 COP호출 할때 Attch할 것인지 확인하기 위한 코드. C일 경우 호출. D(History에서 호출)일때 삭제
								item.setAttchCd("C");
							} else {
								item.setAttchCd("U");

								// 신규 생성일때 BKG History 관리 호출
								historyLineVO = new HistoryLineVO();
								historyLineVO.setBkgNo(item.getBkgNo());
								historyLineVO.setHisCateNm("Container");
								historyLineVO.setCaFlg("N");
								historyLineVO.setUiId("SYSTEM");
								historyLineVO.setCrntCtnt("Attach Container:" + cusCtmMovementVOS[0].getCntrNo());
								historyLineVO.setBkgDocProcTpCd(null);
								bkgCommand1.createBkgHistoryLine(historyLineVO, account);
							}
							// BKG 요청으로 bkg_container 저장후 return값이 ture면 ctm_mvmt_irr에도 저장 (기본으로 return되는 값은 false). 2009-06-25
							modifyCntrOpResult = bkgCommand0.modifyCntrOp(item);

							// 2011.03.08 BKG  [CHM-201109320] Brisbane booking missing boxes
							// bkg_no별 container NO, Type 생성.
							formanceCmd.manageQtyCntrCoposite(item.getBkgNo(), "CN");
						}
					}
				} catch (Exception e) {
					// 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음
					rtnStr[0] = "N";
					rtnStr[1] = e.getMessage().replace("APP", "").replaceAll("<", "").replaceAll("\\|", "").replaceAll(">", "");
					log.error(e.getMessage(), e);
					return rtnStr;
				}

				try {
					// STOCK 호출 - 실패하더라도 현재까지는 Commit
					String preSts = (item.getPrevSts() == null ? "": item.getPrevSts());
					if ("EUR".equals(cusVo.getCntrSvrId())) {
						String stsCd = (cusVo.getMvmtStsCd() == null ? "": cusVo.getMvmtStsCd());
						log.info("\n\n PREV ::: " + preSts + stsCd + "\n\n");
						if ("VL".equals(stsCd) || "XX".equals(stsCd) || "OP".equals(stsCd) || "MT".equals(stsCd) || ( ("EN".equals(stsCd)
								|| "TN".equals(stsCd)) && "MT".equals(preSts))) {
							com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.basic.EmptyReleaseRedeliveryOrderMgtBC emptyCommand
								= new com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.basic.EmptyReleaseRedeliveryOrderMgtBCImpl();
							emptyCommand.updateCimCntrStk(item);
						}
					}

					// COP 호출 - 실패하더라도 현재까지는 Commit
					String fCntr = item.getCusCtmMovementVO().getFcntrFlg();
					// 2011.03.08 나상보 Booking Cargo Type이 'R' (Revenue Empty) 인 경우도 SCE에 Data를 넘겨준다.					
					if ((("F".equals(fCntr) || "Y".equals(fCntr)) || "F".equals(cusVo.getBkgCgoTpCd()) || "R".equals(cusVo.getBkgCgoTpCd()))
							&& cusVo.getBkgNo() != null && !"".equals(cusVo.getBkgNo())) {
						com.hanjin.apps.alps.esd.sce.copdetailreceive.vo.SceActRcvIfVO sceVO
							= new com.hanjin.apps.alps.esd.sce.copdetailreceive.vo.SceActRcvIfVO();
						com.hanjin.apps.alps.esd.sce.copdetailreceive.basic.CopDetailReceiveBC sceCommand
							= new com.hanjin.apps.alps.esd.sce.copdetailreceive.basic.CopDetailReceiveBCImpl();

						sceVO.setCntrNo(cusVo.getCntrNo());
						sceVO.setBkgNo(cusVo.getBkgNo());
						sceVO.setNodCd(cusVo.getOrgYdCd());
						sceVO.setActStsMapgCd(cusVo.getMvmtStsCd());
						sceVO.setActDt(cusVo.getCnmvEvntDt());
						sceVO.setEdiMsgTpCd(cusVo.getMvmtEdiMsgTpId());
						sceVO.setCreTpCd(cusVo.getMvmtCreTpCd());
						sceVO.setCreUsrId(cusVo.getCreUsrId());
						sceVO.setVndrSeq(cusVo.getVndrSeq());
						sceVO.setVslCd(cusVo.getCrntVslCd());
						sceVO.setSkdVoyNo(cusVo.getCrntSkdVoyNo());
						sceVO.setSkdDirCd(cusVo.getCrntSkdDirCd());
						sceVO.setBndVskdSeqCd(cusVo.getIbflag());

						sceVO.setCnmvYr(cusVo.getCnmvYr());
						sceVO.setCnmvIdNo(cusVo.getCnmvIdNo());
						sceVO.setCnmvSeq(cusVo.getCnmvSeq());
						sceVO.setCnmvSplitNo(cusVo.getCnmvSplitNo());
						sceVO.setCnmvCycNo(cusVo.getCnmvCycNo());
						// 2011.03.25 나상보 Immedate Exit Flag 추가
						sceVO.setImdtExtFlg(cusVo.getImdtExtFlg());

						sceCommand.createCOPMVMT(sceVO);
					}

					// BKG 요청으로 bkg_container 저장후 return값이 ture면 ctm_mvmt_irr에도 저장 (기본으로 return되는 값은 false). 2009-06-25
					String rtn = command.updateEtcModule(item, modifyCntrOpResult);
					if (rtn.equals("N")) {
						rtnStr[0] = "N";
						rtnStr[1] = "Insert irr fail!";
					}

					// MNR 호출 - item.getMnrCallYN()가 Y일때만 호출. 2010.09.03
					// (ContainerMovementMgtBCImpl >> manageStsOperation에서 Status가 OP이고 MST_CONTAINER에서 불러온 Damage Flag가 Y일때 MNR을 호출하게하기 위한 flag를 setting함)
					if ("Y".equals(item.getMnrCallYN())) {
						com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.basic.EQFlagMgtBC mnrCommand
							= new com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.basic.EQFlagMgtBCImpl();
						com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqStsVO customMnrEqStsVO
							= new com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqStsVO();

						/*
						 *  필수 입력 받을 값
						 *  customMnrEqStsVO.setEqNo(*** );
						 *	customMnrEqStsVO.setEqKndCd(***);
						 *	customMnrEqStsVO.setEqTpszCd(***);
						 *	customMnrEqStsVO.setMnrDmgFlgYdCd(***);
						 *  customMnrEqStsVO.setMnrDmgFlg(***);
						 *  매칭테이블 MNR_EQ_STS
						 */
						customMnrEqStsVO.setMnrDmgFlg("0"); // flaging : '1', unflaging '0'
						customMnrEqStsVO.setEqKndCd("U");   // Container=> U, Chassis=> Z, GenSet=> G
						customMnrEqStsVO.setEqNo(item.getCusCtmMovementVO().getCntrNo());           // Container No
						customMnrEqStsVO.setEqTpszCd(item.getCusCtmMovementVO().getCntrTpszCd());   // Type/Size
						customMnrEqStsVO.setMnrDmgFlgYdCd(item.getCusCtmMovementVO().getOrgYdCd()); // OP가 발생된 yard Code

						/*
						 * 2015.09.04 Sang-Hyun Kim [자체처리] Batch EES_CTM_B001(CTMMvmtVLVDRsv)에서 movement 처리할 경우, Session 값이 없어서
						 *                                   MNR method에서 오류 발생 되는 문제 수정
						 */
						if (account == null || account.getUsr_id().equals("")) {
							account = new SignOnUserAccount("CTM_BATCH", "CTM_BATCH", "", "","", "", "", "", "CTM_BATCH", "", "CTM_BATCH", "", "", "", "", "", "", "", "", "", "", "");
						}
						mnrCommand.manageIFFlagForOtherBasic(customMnrEqStsVO, account);
					}

					// 2016.02.17 김상현 [CHM-201640053] 동일 CYC#의 mvmt는 최신 Bkg으로 Update
					//  - Booking No.가 검증되었을 경우, 해당하는 Cycle의 Last booking no.에 모두 적용하도록 추가
					if (cusVo.getBkgNo() != null && !"".equals(cusVo.getBkgNo()) && cusVo.getBkgCgoTpCd() != null && !"".equals(cusVo.getBkgCgoTpCd())) {
						String lastBkgNo = cusVo.getBkgNo();
						String lastBlNo = "";
						if (cusVo.getBlNo() != null && !"".equals(cusVo.getBlNo())) {
							lastBlNo = cusVo.getBlNo();
						} else {
							lastBlNo = cusVo.getBkgNo();
						}
						command.modifyLastBkgNo(lastBkgNo, lastBlNo, cusVo);
					}
				} catch (Exception ex) {
					// 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음
					log.error("err " + ex.toString(), ex);
				}

				// sendEDItoKor Start.
				// CusCtmMovementVO의 OrgYardCd 앞2자리가 KR이고 EdiSend lstrm cd 값이 있다면 EDI를 전송
				if ("KR".equals(subStr(cusVo.getOrgYdCd(), 0, 2)) && (item.getEdiSendLstrmCd() != null && !"".equals(item.getEdiSendLstrmCd()))) {
					try {
						// sendEDItoKor 호출 - 실패하더라도 현재까지는 Commit
						String ediSts = cusVo.getMvmtStsCd();
						// EdiSend StsCd가 VD이고 manageStsOperation 결과 StsCd가 IC나 TS일 경우만 EdiSend StsCd로 Setting
						if ("VD".equals(item.getEdiSendStsCd()) && ("IC".equals(cusVo.getMvmtStsCd()) || "TS".equals(cusVo.getMvmtStsCd()))) {
							ediSts = item.getEdiSendStsCd();
						}
						cusVo.setCrntVslCd(item.getEdiSendVslCd());
						cusVo.setCrntSkdVoyNo(item.getEdiSendSkdVoyNo());
						cusVo.setCrntSkdDirCd(item.getEdiSendSkdDirCd());

						command.sendEdiToKor(cusVo, ediSts, item.getEdiSendLstrmCd());
					} catch (Exception ex) {
						// 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음
						log.error("\n\n [SC - manageCreateProcess] sendEDItoKor - Exception :\n" + ex.getMessage(), ex);
					}
				}
				// sendEDItoKor End.
			}
		}
		return rtnStr;
	}

	/**
	 * EES_CTM_0406 : TextBox (VVD CODE) On Change<br>
	 * Yard와 VVD Code를 입력 받고 ETA/ ETD Time을 조회<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse getEtaEtdTime(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0406Event event = (EesCtm0406Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		try {
			String rtnStr = command.getEtaEtdTime(event.getSearchCLMInfoVO());
			eventResponse.setETCData("rtnStr", rtnStr);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0406 : btn_precheck<br>
	 * VL Pre Check에대한 유효성 검사<br>
	 * VL저장 전 Pre Check버튼에 대한 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkPREVLVD(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0406Event event = (EesCtm0406Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		try {
			CtmCntrMovInfoVO[] vos = event.getCtmCntrMovInfoVOS();
			String[][] rtnStr = command.checkPREVLVD(vos, account);
			StringBuffer rtnValue = new StringBuffer();
			for (int i = 0; i < rtnStr.length; i++)
				rtnValue.append(rtnStr[i][0]).append("||");

			eventResponse.setETCData("rtnStr", rtnValue.toString());
			eventResponse.setETCData("errCount", rtnStr[0][1]);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0458 : onLoad<br>
	 * 부킹번호에 딸려있는 부킹 컨테이너의 타입 사이즈별 갯수 리턴<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBookingQTY(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0458Event event = (EesCtm0458Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		try {
			List<BookingQTYVO> list = command.searchBookingQTY(event.getBookingQTY());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0433 : onLoad<br>
	 * 부킹번호에 딸려있는 부킹 컨테이너의 타입 사이즈별 갯수 리턴<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCNTRList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0433Event event = (EesCtm0433Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		try {
			List<BkgCNTRListVO> list = command.searchCNTRList(event.getBookingQTY());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0406 : btn_save<br>
	 * CTM_MVMT_RSV 테이블에 예약 정보를 등록한다<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse resMovement(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0406Event event = (EesCtm0406Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		try {
			begin();
			CtmCntrMovInfoVO[] vos = event.getCtmCntrMovInfoVOS();
			command.resMovement(vos,account);
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0406 : Container Movement Change<br>
	 * 컨테이너 변경시 (VL/VD) 자동 조회<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkVLVDPreChk(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0406Event event = (EesCtm0406Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		try {
			CtmCntrMovInfoVO vos = event.getCtmCntrMovInfoVO();
			String rtnStr = command.checkVLVDPreChk(vos);
			eventResponse.setETCData("rtnStr", rtnStr);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_CTM_0406 : Container Movement Change<br>
	 * VVD, YARD 변경시 해당 yard와 VVD간의 적합성 여부 자동조회<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkVVDYardCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0406Event event = (EesCtm0406Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();

		try {
			CtmCntrMovInfoVO vos = event.getCtmCntrMovInfoVO();
			int rtnStr = command.checkVVDYardCd(vos);
			
			String rtnVaule = ""; 
			if (rtnStr == 0){
				rtnVaule = "Correction";
			} else{
				rtnVaule = "Continue";
			}
			
			eventResponse.setETCData("rtnStr", rtnVaule);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * MQ Inbound : MQProxy<br> / EES_CTM_0000(GATENEW테스트 페이지) : btn_save
	 * GATENEW 멀티 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse gateNew(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UbizhjsAlpsCtmEqmvmtEvent eaiMqEvent = null;
		EesCtm0000Event uiTestEvent = null;

		ContainerMovementMgtForGateNewBC gatenewCommand = new ContainerMovementMgtForGateNewBCImpl();
		FlatFileForGateNewVO[] flatFileVOs = null;
		if (e.getEventName().equals("UbizhjsAlpsCtmEqmvmtEvent")) {
			eaiMqEvent = (UbizhjsAlpsCtmEqmvmtEvent)e;
			flatFileVOs = gatenewCommand.assignFlatFileVO(eaiMqEvent.getFlatFile());;
		} else {
			uiTestEvent = (EesCtm0000Event)e;
			if (uiTestEvent.getInputRadio().equals("SHEET")) {
				flatFileVOs = uiTestEvent.getFlatFileVOS();
			} else {
				flatFileVOs = gatenewCommand.assignFlatFileVO(uiTestEvent.getFlatFileText());;
			}
		}

		List<SearchEDIMovementListVO> searchEDIMovementListVOlist = new ArrayList<SearchEDIMovementListVO>();
		FlatFileForGateNewVO flatFileForGateNewVO = null;
		SearchEDIMovementListVO searchEDIMovementListVO = null;
		if ( flatFileVOs != null ) {
			for ( int jj=0; jj<flatFileVOs.length; jj++ ) {
				log.info("\n\n===============================================================" +
						  "\n [BATCH] GateNew() - Begin!" +
						  "\n===============================================================\n");
				flatFileForGateNewVO = null;
				searchEDIMovementListVO = null;

				try {
					log.info("\n\n===============================================================" +
							  "\n begin_flatFile : ColumnValues" +
							  "\n======================================" +
							  "\n" + flatFileVOs[jj].getColumnValues().toString().replaceAll(", ", "\n") +
							  "\n======================================" +
							  "\n bkg_number[]=" + java.util.Arrays.toString(flatFileVOs[jj].getBkgNumber()) +
							  "\n===============================================================\n");
					begin();    // gateNew BEGIN
					flatFileForGateNewVO = gatenewCommand.gateNew(flatFileVOs[jj]);
					commit();
					log.info("\n\n===============================================================" +
							  "\n finish_flatFile : ColumnValues" +
							  "\n======================================" +
							  "\n" + flatFileForGateNewVO.getColumnValues().toString().replaceAll(", ", "\n") +
							  "\n======================================" +
							  "\n bkg_number[]=" + java.util.Arrays.toString(flatFileForGateNewVO.getBkgNumber()) +
							  "\n===============================================================\n");
				} catch (EventException ex) {
					/******************************************************
					 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음   *
					 ******************************************************/
					rollback();
					log.error("\n\n [BATCH] GateNew() : EventException\n" + ex.toString(), ex);
				} catch (Exception ex) {
					/******************************************************
					 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음   *
					 ******************************************************/
					rollback();
					log.error("\n\n [BATCH] GateNew() : Exception\n" + ex.toString(), ex);
				}

				if ( flatFileForGateNewVO != null ) {
					try {
						flatFileForGateNewVO = manageGateNewProcess(flatFileForGateNewVO);
					} catch (EventException ex) {
						/******************************************************
						 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음   *
						 ******************************************************/
						rollback();
						log.error("\n\n manageGateNewProcess : EventException\n" + ex.toString(), ex);
					} catch (Exception ex) {
						/******************************************************
						 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음   *
						 ******************************************************/
						rollback();
						log.error("\n\n manageGateNewProcess : Exception\n" + ex.toString(), ex);
					} finally {

						/* 미주 "322" 메시지이고  gate status가 AR(Rail Arrival At Destination Intermodal Ramp)인 경우 skip  */
						if ( "322".equals(flatFileForGateNewVO.getMsgId()) && "AR".equals(flatFileForGateNewVO.getGateIo() ) ) {
							/* EES_CTM_0000(GATENEW테스트 페이지)일때만 throw */
							if ( e.getEventName().equals("EesCtm0000Event") ) {
								throw new EventException(new ErrorHandler("[MsgId : 322 & GateIo : AR] Case. GateNew Skip!").getMessage());
							} else {
								log.info("\n\n=============================================================== [MsgId : 322 & GateIo : AR] Case = > Skip\n");
							}
						} else {
							// BkgNumber[0](배열)를 BkgNumber0 에 setting
							flatFileForGateNewVO.setBkgNumber0(flatFileForGateNewVO.getBkgNumber()[0] == null ? "" : flatFileForGateNewVO.getBkgNumber()[0] + "");
							// AssignFlatFileVO2EdiUiVO for GateNew ////////////////////////////
							searchEDIMovementListVO = gatenewCommand.assignFlatFileVO2EdiUiVO(flatFileForGateNewVO, new SearchEDIMovementListVO());
							// rty_knt
							searchEDIMovementListVO.setRtyKnt("0");
							try {
								begin();    // resultUpdb BEGIN
								log.info("\n\n===============================================================" +
										  "\n resultUpdb()" +
										  "\n===============================================================\n");
								searchEDIMovementListVOlist.add(gatenewCommand.resultUpdb(searchEDIMovementListVO));
								commit();
							} catch (EventException ex) {
								/******************************************************
								 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음   *
								 ******************************************************/
								rollback();
								log.error("\n\n resultUpdb : EventException\n" + ex.toString(), ex);
							} catch (Exception ex) {
								/******************************************************
								 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음   *
								 ******************************************************/
								rollback();
								log.error("\n\n resultUpdb : Exception\n" + ex.toString(), ex);
							}
						}
					}
				}
				log.info("\n\n===============================================================" +
						  "\n [BATCH] GateNew() - Finish!" +
						  "\n===============================================================\n");
			}
		}
		eventResponse.setRsVoList(searchEDIMovementListVOlist);
		return eventResponse;
	}

	/**
	 * SC : gateNew / manageEDIMovement 에서 호출<br>
	 * GATENEW Process 처리<br>
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @return FlatFileForGateNewVO
	 * @exception EventException
	 */
	private FlatFileForGateNewVO manageGateNewProcess(FlatFileForGateNewVO flatFileForGateNewVO) throws EventException {
		ContainerMovementMgtForGateNewBC gatenewCommand = new ContainerMovementMgtForGateNewBCImpl();
		String[] returnValues = new String[2];

		/* @checkNassignData 결과가 Y일 경우 */
		if ( "Y".equals(flatFileForGateNewVO.getCheckNassignData()) ) {

			/* Chassis Case가 Y일 경우 @createChassisMovement 호출 */
			if ( "Y".equals(flatFileForGateNewVO.getChssCase()) ) {
				/* gatenew를 통해 접수된 322 Data에 대하여 관련 수신 Data가 Chassis일 경우 연관 serveice를 호출 ( As Is : chs_dbup.pc) */
				log.info("\n\n===============================================================" +
						 "\n Chassis - manageCHSMovementBareByGatenewBasic 호출" +
						 "\n===============================================================\n");
				try {
					ChassisMovementHistoryBC cgmCommand = new ChassisMovementHistoryBCImpl();
					begin();    // Chassis BEGIN
					returnValues = cgmCommand.manageCHSMovementBareByGatenewBasic( flatFileForGateNewVO );
					commit();    //  Chassis COMMIT
				} catch (EventException ex) {
					/******************************************************
					 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음   *
					 ******************************************************/
					rollback();    // Chassis ROLLBACK
					flatFileForGateNewVO.setResultIndicator("N");
					flatFileForGateNewVO.setResultMessage("SYSTEM ERROR (Chassis ERROR)");
					log.error("\n\nerr " + ex.toString(), ex);
				} catch (Exception ex) {
					rollback();    // Chassis ROLLBACK
					flatFileForGateNewVO.setResultIndicator("N");
					flatFileForGateNewVO.setResultMessage("SYSTEM ERROR (Chassis ERROR)");
					log.error("\n\nerr " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}
				log.info("\n\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% CHASSIS_STS 1 : " + returnValues[1] +
						 "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% CHASSIS_MSG 1 : " + returnValues[0] + "\n");

				// 정상처리일때 return값 : returnValues[0] = "", returnValues[1] = "Y"
				if ( returnValues[0].equals("") && returnValues[1].equals("Y") ) {    /* Error가 아닐때 */
					flatFileForGateNewVO.setResultMessage("OK.PROCESSED");
					flatFileForGateNewVO.setResultIndicator("Y");

				} else {    /* Error 발생시 */
					flatFileForGateNewVO.setResultMessage(returnValues[0].trim());
					flatFileForGateNewVO.setResultIndicator("N");

				}

			} else {    /* Chassis Case가 Y가 아닐경우 */

				/* Mvmt Status가 "ER", "ZZ", ""이 아닐경우 CTM-COMMON 호출 */
				if ( !"ER".equals(flatFileForGateNewVO.getMvmtStatus()) && !"ZZ".equals(flatFileForGateNewVO.getMvmtStatus()) ) {

					/* @generateMovement (S) +++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
					CusCtmMovementVO[] setCustVOs = null;
					/* _______________________________________________________________________________________________________________________ */
					/* ____________________________________________________________________________________________________________OP, OC Case */
					String domesticCheck = subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 4);
					/*
					 * 2015.12.24 추가 by Sang-Hyun Kim
					 * "TMAT", "TIND", "TESI", "THYI" Domestic booking으로 판별하도록 추가.
					 *  - HJL이 아닌 타 업체 booking no.
					 */
					if (("OP".equals(flatFileForGateNewVO.getMvmtStatus()) || "OC".equals(flatFileForGateNewVO.getMvmtStatus()))
							&& (!"DLAX".equals(domesticCheck) && !"DCHI".equals(domesticCheck) && !"DHOU".equals(domesticCheck)
									&& !"DMEM".equals(domesticCheck) && !"DNYC".equals(domesticCheck) && !"DSEA".equals(domesticCheck)
									&& !"TCHI".equals(domesticCheck) && !"DHJI".equals(domesticCheck) && !"THJI".equals(domesticCheck)
									&& !"TMAT".equals(domesticCheck) && !"TIND".equals(domesticCheck) && !"TESI".equals(domesticCheck)
									&& !"THYI".equals(domesticCheck))) {

						/* MVMT Common1 호출 (S) +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
						log.info("\n\n===============================================================" +
								 "\n manageCreateProcess(setCustVOs, length) ++++++ MVMT Common 호출1" +
								 "\n===============================================================\n");
						try {
							setCustVOs = gatenewCommand.assignCommonVO( flatFileForGateNewVO, (flatFileForGateNewVO.getBkgNumber() == null ? 0 : flatFileForGateNewVO.getBkgNumber().length));
							begin();    // COMMON BEGIN
							returnValues = manageCreateProcess(setCustVOs, setCustVOs.length, false, false);
							if ( "N".equals(returnValues[0]) ) {
								rollback();    // COMMON ROLLBACK

								// 2016.07.07 김상현 [CHM-201642556] 동일한 MVMT에서 VGM이 나중에 EDI 수신되어 오류처리되는 경우, VGM 소급 update logic 추가
								//  - 동일한 Movement에 대해서 VGM 데이터가 없을 경우, VGM 데이터 업데이트 처리
								if (returnValues[2] != null && "VGM".equals(returnValues[2])) {
									ContainerMovementMgtBC containerMovementMgtBC = new ContainerMovementMgtBCImpl();
									containerMovementMgtBC.updateVgmData(setCustVOs);
								}
							} else {
								commit();    //  COMMON COMMIT
							}
						} catch (EventException ex) {
							/******************************************************
							 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음   *
							 ******************************************************/
							rollback();    // COMMON ROLLBACK
							returnValues[0] = "N";
							returnValues[1] = ex.getMessage();
							log.error("\n\nerr " + ex.toString(), ex);
						} catch (Exception ex) {
							rollback();    // COMMON ROLLBACK
							flatFileForGateNewVO.setResultIndicator("N");
							flatFileForGateNewVO.setResultMessage("SYSTEM ERROR (MVMT Common ERROR)");
							log.error("\n\nerr " + ex.toString(), ex);
							throw new EventException(ex.getMessage(), ex);
						}
						log.info("\n\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% COMMON_STS 1 : " + returnValues[0] +
								 "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% COMMON_MSG 1 : " + returnValues[1] + "\n");
						/* MVMT Common1 호출 (E) +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
					} else if ("USA".equals(flatFileForGateNewVO.getMuidArea())
							&& ("DLAX".equals(domesticCheck) || "DCHI".equals(domesticCheck) || "DHOU".equals(domesticCheck)
									|| "DMEM".equals(domesticCheck) || "DNYC".equals(domesticCheck) || "DSEA".equals(domesticCheck)
									|| "TCHI".equals(domesticCheck) || "DHJI".equals(domesticCheck) || "THJI".equals(domesticCheck)
									|| "TMAT".equals(domesticCheck) || "TIND".equals(domesticCheck) || "TESI".equals(domesticCheck)
									|| "THYI".equals(domesticCheck))) {
						// Domestic MVMT Common 호출 (S)
						log.info("\n\n===============================================================" +
								 "\n manageDomesticMVMT(vos[0], account) ++++++ Domestic MVMT Common 호출" +
								 "\n===============================================================\n");
						
						try {
							setCustVOs = gatenewCommand.assignCommonVO( flatFileForGateNewVO, 1 );
							ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
							begin();    // Domestic-COMMON BEGIN
							CrossItemVO item = command.manageDomesticMVMT(setCustVOs[0], subStr(flatFileForGateNewVO.getEventYard(), 0, 2));
							returnValues = item.getRtnStr();
							if ( "N".equals(returnValues[0]) ) {
								rollback();    // Domestic-COMMON ROLLBACK
							} else {
								
								if (item.getUpdateMaster() == true) {
									ContainerOnOffhireBC mstCommand = new ContainerOnOffhireBCImpl();
									mstCommand.updateCntrMasterByMvmtBasic(item);
								}
								commit();    //  Domestic-COMMON COMMIT
							}
							
							// 2013.09.24 강   환 [CHM-201325811] Each Container Inquiry 기능 보완 (CO-CP생성시 auto  생성된 MT 를 SCEM에 추가 IF)
							if(item.getSceActRcvIfVOs().size() > 0){
								com.hanjin.apps.alps.esd.sce.copdetailreceive.basic.CopDetailReceiveBC sceCommand = 
									new com.hanjin.apps.alps.esd.sce.copdetailreceive.basic.CopDetailReceiveBCImpl();
								
								for(int i = 0; i < item.getSceActRcvIfVOs().size(); i++){
										sceCommand.createCOPMVMT(item.getSceActRcvIfVOs().get(i));
								}
							}
							// 2013.09.24 강   환 [CHM-201325811] Each Container Inquiry 기능 보완 (CO-CP생성시 auto  생성된 MT 를 SCEM에 추가 IF)

						} catch (EventException ex) {
							/******************************************************
							 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음   *
							 ******************************************************/
							rollback();    // Domestic-COMMON ROLLBACK
							returnValues[0] = "N";
							returnValues[1] = ex.getMessage().replace("APP", "").replaceAll("<", "").replaceAll("\\|", "").replaceAll(">", "");
							log.error("\n\nerr " + ex.toString(), ex);
						} catch (Exception ex) {
							rollback();    // Domestic-COMMON ROLLBACK
							log.error("\n\nerr " + ex.toString(), ex);
							throw new EventException(ex.getMessage(), ex);
						}
						log.info("\n\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Domestic-COMMON_STS : " + returnValues[0] +
								 "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Domestic-COMMON_MSG : " + returnValues[1] + "\n");
						/* Domestic MVMT COmmon 호출 (E) ++++++++++++++++++++++++++++++++++++++++++++++++++*/


					}
					/* _______________________________________________________________________________________________________________________ */
					/* __________________________________________________________________________________ International MVMT ( Except OP, OC ) */
					else {
						boolean nBkgNoFlg = false;
						if ("VL".equals(flatFileForGateNewVO.getMvmtStatus()) && "Y".equals(flatFileForGateNewVO.getNBkgNoFlg())) {
							nBkgNoFlg = true;
						}

						// MVMT Common2 호출 (S)
						log.info("\nmanageCreateProcess(setCustVOs, length) ++++++ MVMT Common 호출2\n");
						try {
							setCustVOs = gatenewCommand.assignCommonVO( flatFileForGateNewVO, 1 );
							begin();    // COMMON BEGIN
							returnValues = manageCreateProcess(setCustVOs, setCustVOs.length, nBkgNoFlg, false);
							if ( "N".equals(returnValues[0]) ) {
								rollback();    // COMMON ROLLBACK

								// 2016.07.07 김상현 [CHM-201642556] 동일한 MVMT에서 VGM이 나중에 EDI 수신되어 오류처리되는 경우, VGM 소급 update logic 추가
								//  - 동일한 Movement에 대해서 VGM 데이터가 없을 경우, VGM 데이터 업데이트 처리
								if (returnValues[2] != null && "VGM".equals(returnValues[2])) {
									ContainerMovementMgtBC containerMovementMgtBC = new ContainerMovementMgtBCImpl();
									containerMovementMgtBC.updateVgmData(setCustVOs);
								}
							} else {
								commit();    //  COMMON COMMIT
							}
						} catch (EventException ex) {
							/******************************************************
							 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음   *
							 ******************************************************/
							rollback();    // COMMON ROLLBACK
							returnValues[0] = "N";
							returnValues[1] = ex.getMessage();
							log.error("\n\nerr " + ex.toString(), ex);
						} catch (Exception ex) {
							rollback();    // COMMON ROLLBACK
							flatFileForGateNewVO.setResultIndicator("N");
							flatFileForGateNewVO.setResultMessage("SYSTEM ERROR (MVMT Common ERROR)");
							log.error("\n\nerr " + ex.toString(), ex);
							throw new EventException(ex.getMessage(), ex);
						}
						log.info("\n\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% COMMON_STS 2 : " + returnValues[0] +
								 "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% COMMON_MSG 2 : " + returnValues[1] + "\n");
						/* MVMT Common2 호출 (E) +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/

					}
					/* @generateMovement (E) +++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
				}

				if (returnValues[0] == null || returnValues[0].trim().equals("") || returnValues[0].trim().equals("null")) {
					returnValues[0] = "";
				} else {
					returnValues[0] = returnValues[0].trim();
				}
				if (returnValues[1] == null || returnValues[1].trim().equals("") || returnValues[1].trim().equals("null")) {
					returnValues[1] = "";
				} else {
					returnValues[1] = returnValues[1].trim();
				}

				// result값을 returnVo에 setting
				flatFileForGateNewVO.setResultIndicator(returnValues[0]);
				flatFileForGateNewVO.setResultMessage(returnValues[1]);
			}
		}
		return flatFileForGateNewVO;
	}

	/**
	 * EES_CTM_0407 : btn_save<br>
	 * Domestic Container Movement Grid내용을 저장한다<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDomesticMVMT(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0407Event event = (EesCtm0407Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		ContainerMovementValidationBC commonCommand = new ContainerMovementValidationBCImpl();
		StringBuffer srtRes = new StringBuffer();
		CusCtmMovementVO[] vos = event.getCtmMovementVOS();
		for (int i = 0; i < vos.length; i++) {
			try {
				begin();
				vos[i].setCreUsrId(account.getUsr_id());
				vos[i].setUpdUsrId(account.getUsr_id());
				vos[i].setUsrNm(account.getUsr_nm());
				vos[i].setOfcCd(account.getOfc_cd());

				CrossItemVO item = command.manageDomesticMVMT(vos[i], commonCommand.searchUserCntCode(account.getOfc_cd()));
				String[] strs = item.getRtnStr();
				if (strs != null && !strs[0].equals("null") && strs[0].equals("N")) {
					srtRes.append(strs[1]).append("^^");
					rollback();
				} else {
					srtRes.append("").append("^^");
					if (item.getUpdateMaster() == true) {
						ContainerOnOffhireBC mstCommand = new ContainerOnOffhireBCImpl();
						mstCommand.updateCntrMasterByMvmtBasic(item);
					}
					commit();
					// 2013.09.24 강   환 [CHM-201325811] Each Container Inquiry 기능 보완 (CO-CP생성시 auto  생성된 MT 를 SCEM에 추가 IF)
					if(item.getSceActRcvIfVOs().size() > 0){
						com.hanjin.apps.alps.esd.sce.copdetailreceive.basic.CopDetailReceiveBC sceCommand = 
							new com.hanjin.apps.alps.esd.sce.copdetailreceive.basic.CopDetailReceiveBCImpl();
						
						for(int j = 0; j < item.getSceActRcvIfVOs().size(); j++){
								sceCommand.createCOPMVMT(item.getSceActRcvIfVOs().get(j));
						}
					}
					// 2013.09.24 강   환 [CHM-201325811] Each Container Inquiry 기능 보완 (CO-CP생성시 auto  생성된 MT 를 SCEM에 추가 IF)
				}
			} catch (EventException ex) {
				/***************************************************************
				 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음 *
				 ***************************************************************/
				log.error(ex.getMessage(),ex);
				rollback();
				srtRes.append(ex.getMessage().replace("APP", "").replaceAll("<", "").replaceAll("\\|", "").replaceAll(">", "")).append("^^");
			} catch (Exception ex) {
				/***************************************************************
				 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음 *
				 ***************************************************************/
				log.error(ex.getMessage(),ex);
				rollback();
				srtRes.append(ex.getMessage().replace("APP", "").replaceAll("<", "").replaceAll("\\|", "").replaceAll(">", "")).append("^^");
			}
		}
		eventResponse.setETCData("rtnStr", srtRes.toString());
		return eventResponse;
	}

	/**
	 * EES_CTM_0411 : btn_retrive<br>
	 * Detail Form의 VVD History List 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVvdHistory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0411Event event = (EesCtm0411Event)e;
		ContainerMovementFinderBC command = new ContainerMovementFinderBCImpl();
		try {
			List<CtmVvdHistoryVO> list = command.searchVvdHistory(event.getConINTCommonVO());
			eventResponse.setRsVoList(list);
			List<searchMovementHistoryVO> list1 = command.searchMvmtHistory(event.getConINTCommonVO());
			eventResponse.setRsVoList(list1);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0443 : btn_retrive<br>
	 * Cargo Location message 리스트 조회 <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCLMList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0443Event event = (EesCtm0443Event)e;
		ContainerMovementFinderBC command = new ContainerMovementFinderBCImpl();
		try {
			List<CtmCCLMVO> list = command.searchCLMInfo(event.getCtmCCLMVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0413 : btn_retrive<br>
	 * BKG/MVMT VL/VD Unmatch List 조회. <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMVMTBKGUnmatchList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0413Event event = (EesCtm0413Event)e;
		ContainerMovementFinderBC command = new ContainerMovementFinderBCImpl();
		try {
			List<ConCBookingVO> list1 = command.searchMVMTBKGUnmatchList(event.getConCBookingVO(), "1");
			eventResponse.setRsVoList(list1);
			List<ConCBookingVO> list2 = command.searchMVMTBKGUnmatchList(event.getConCBookingVO(), "2");
			eventResponse.setRsVoList(list2);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0418 : onLoad<br>
	 * RCC Combo에 세팅되는 데이터 로딩<br>
	 *
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse getRccList() throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		LongTxContainerMovementFinderBC command = new LongTxContainerMovementFinderBCImpl();
		try {
			String rtn = command.getRccList(account.getOfc_cd());
			eventResponse.setETCData("rtn", rtn);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0418 : Combo Change<br>
	 * RCC Combo에 세팅되는 데이터 로딩<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse getLccList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0418Event event = (EesCtm0418Event)e;
		LongTxContainerMovementFinderBC command = new LongTxContainerMovementFinderBCImpl();
		try {
			String rtn = command.getLccList(event.getMovementEDIReportVO().getRccCd());
			eventResponse.setETCData("rtn", rtn);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * BackEndJob공통 - BackEndJob status를 return<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse comBackEndJob(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		LongTxContainerMovementFinderBC command = new LongTxContainerMovementFinderBCImpl();
		try {
			String status = command.comBackEndJob((String) e.getAttribute("KEY"));
			eventResponse.setETCData("jb_sts_flg", status);
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0418 : btn_retrive<br>
	 * BackEndJob start<br>
	 * doBackEndJob method
	 * @author Jeong-Hoon, KIM
	 * @param e
	 * @return
	 */
	private EventResponse doBackEndJobEDIOnTimeDetailList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0418Event event = (EesCtm0418Event)e;
		LongTxContainerMovementFinderBC command = new LongTxContainerMovementFinderBCImpl();
		try {
			begin();
			eventResponse.setETCData("BackEndJobKey", command.doBackEndJob(account, event.getMovementEDIReportVO()));
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0418, EES_CTM_0460, EES_CTM_0462 : BackEndJob<br>
	 * MVMT Timely Update Ratio Long Tx 결과 조회<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEDIOnTimeDetailList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		LongTxContainerMovementFinderBC command = new LongTxContainerMovementFinderBCImpl();
		try {
			List<MovementEDIReportVO> list = command.searchEDIOnTimeDetailList((String) e.getAttribute("KEY"));
			eventResponse.setRsVoList(list);
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0418 : btn_excel<br>
	 * 엑셀 다운용 EDI result 상세 데이터를 조회<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEDIOnTimeDetailExcel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0418Event event = (EesCtm0418Event)e;
		LongTxContainerMovementFinderBC command = new LongTxContainerMovementFinderBCImpl();
		try {
			List<UpdateRatioDetailVO> list = command.getUpdateRatioDetail(event.getUpdateRatioDetailVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0417 : btn_retrive<br>
	 * 0417의 BackEndJob을 시작<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse doBackEndJobEDIErrList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0417Event event = (EesCtm0417Event)e;
		LongTxContainerMovementFinderBC command = new LongTxContainerMovementFinderBCImpl();
		try {
			begin();
			eventResponse.setETCData("BackEndJobKey", command.doBackEndJobEDIErrList(account, event.getSearchEDIErrorVO()));
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0417 : BackEndJob<br>
	 * EDI Error Detail List Long Tx 결과 조회<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEDIErrorList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		LongTxContainerMovementFinderBC command = new LongTxContainerMovementFinderBCImpl();
		try {
			List<SearchEDIErrorVO> list = command.searchEDIErrorList((String) e.getAttribute("KEY"));
			eventResponse.setRsVoList(list);
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0417 : btn_excel<br>
	 * 엑셀 다운용 EDI Error 상세 데이터를 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEDIErrorDetailExcel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0417Event event = (EesCtm0417Event)e;
		LongTxContainerMovementFinderBCImpl command = new LongTxContainerMovementFinderBCImpl();
		try {
			List<SearchEDIErrorVO> list = command.searchEDIErrorDetailExcel(event.getSearchEDIErrorVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0420 : btn_retrive<br>
	 * EDI Result Monitoring Data 및 상세 데이터를 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse doBackEndJobEDIRstList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0420Event event = (EesCtm0420Event)e;
		LongTxContainerMovementFinderBC command = new LongTxContainerMovementFinderBCImpl();
		try {
			begin();
			eventResponse.setETCData("BackEndJobKey", command.doBackEndJobEDIRst(account, event.getSearchEDIResultVO()));
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0420 : BackEndJob<br>
	 * EDI Result Detail List Long Tx 결과 조회<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEDIResultList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		LongTxContainerMovementFinderBC command = new LongTxContainerMovementFinderBCImpl();
		try {
			List<SearchEDIResultVO> list = command.searchEDIResultList((String) e.getAttribute("KEY"));
			eventResponse.setRsVoList(list);
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0420 : btn_excel<br>
	 * 엑셀 다운용 EDI result 상세 데이터를 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEDIResultDetailExcel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0420Event event = (EesCtm0420Event)e;
		LongTxContainerMovementFinderBCImpl command = new LongTxContainerMovementFinderBCImpl();
		try {
			List<SearchEDIResultVO> list = command.searchEDIResultDetailExcel(event.getSearchEDIResultVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0419 : btn_retrive<br>
	 * VL/VD EDI Test Result의 리스트 조회<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchResultEDIList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0419Event event = (EesCtm0419Event)e;
		ContainerMovementFinderBC command = new ContainerMovementFinderBCImpl();
		try {
			List<ConCBookingVO> list1 = command.searchResultEDIList(event.getConCBookingVO(), "1");
			eventResponse.setRsVoList(list1);
			List<ConCBookingVO> list2 = command.searchResultEDIList(event.getConCBookingVO(), "2");
			eventResponse.setRsVoList(list2);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0456 : btn_retrive<br>
	 * PreVLVD List를 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPreVLVDList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0456Event event = (EesCtm0456Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		try {
			List<SearchPreVLVDListVO> list = command.searchPreVLVDList(event.getSearchPreVLVDListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0456 : btn_save<br>
	 * PreVLVD List를 수정/삭제<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse managePreVLVD(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0456Event event = (EesCtm0456Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		try {
			begin();
			command.managePreVLVD(event.getSearchPreVLVDListVOS(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * SPP : WebService<br>
	 * SPP에서 넘어온 단건 데이터를 Movement Status에 등록한다<br>
	 *
	 * @param Event e
	 * @return String[]
	 * @exception EventException
	 */
	public EventResponse manageSppMovement(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		String[] rtnStrs = new String[3];
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0999Event event = (EesCtm0999Event)e;
		CusCtmMovementVO[] cusCtmMovementVO = event.getCusCtmMovementVOS();
		CusCtmMovementVO[] opVo = new CusCtmMovementVO[2];
		StringBuffer rtnString = new StringBuffer();

		for (int x = 0; x < cusCtmMovementVO.length; x++) {
			log.info("\n SPP : cusCtmMovementVO[" + x + "] : ColumnValues\n" + cusCtmMovementVO[x].getColumnValues().toString().replaceAll(", ", "\n") + "\n");
			try {
				// 2016.06.02 김상현 [CHM-201641731] VGM 항목 추가
				//  - SPP 입력시 VGM 관련 data가 없을 경우 오류 방지
				cusCtmMovementVO[x].setVgmMzdTpCd(cusCtmMovementVO[x].getVgmMzdTpCd() == null ? "" : cusCtmMovementVO[x].getVgmMzdTpCd().trim());
				cusCtmMovementVO[x].setVgmWgtUtCd(cusCtmMovementVO[x].getVgmWgtUtCd() == null ? "" : cusCtmMovementVO[x].getVgmWgtUtCd().trim());
				cusCtmMovementVO[x].setVgmWgtQty(cusCtmMovementVO[x].getVgmWgtQty() == null ? "" : cusCtmMovementVO[x].getVgmWgtQty().trim());
				cusCtmMovementVO[x].setVgmVrfyDt(cusCtmMovementVO[x].getVgmVrfyDt() == null ? "" : cusCtmMovementVO[x].getVgmVrfyDt().trim());
				cusCtmMovementVO[x].setVgmSigCtnt(cusCtmMovementVO[x].getVgmSigCtnt() == null ? "" : cusCtmMovementVO[x].getVgmSigCtnt().trim());
				cusCtmMovementVO[x].setVgmRefNo(cusCtmMovementVO[x].getVgmRefNo() == null ? "" : cusCtmMovementVO[x].getVgmSigCtnt().trim());
				cusCtmMovementVO[x].setVgmWgtPtyCtnt(cusCtmMovementVO[x].getVgmWgtPtyCtnt() == null ? "" : cusCtmMovementVO[x].getVgmWgtPtyCtnt().trim());
				cusCtmMovementVO[x].setVgmVrfyOrdCtnt(cusCtmMovementVO[x].getVgmVrfyOrdCtnt() == null ? "" : cusCtmMovementVO[x].getVgmVrfyOrdCtnt().trim());

				begin();
				int idx = 1;
				opVo[0] = cusCtmMovementVO[x];

				rtnStrs = manageCreateProcess(opVo, idx, false, false);
				if (rtnStrs[0] != null && rtnStrs[0].equals("N")) {
					rollback();
					for (int y = 0; y < (idx); y++) {
						rtnString.append(rtnStrs[1]).append("^^");
						log.debug(rtnStrs[1] + "^^");
					}

					// 2016.07.11 김상현 [CHM-201642556] 동일한 MVMT에서 VGM이 나중에 EDI 수신되어 오류처리되는 경우, VGM 소급 update logic 추가
					//  - 동일한 Movement에 대해서 VGM 데이터가 없을 경우, VGM 데이터 업데이트 처리
					if (rtnStrs[2] != null && "VGM".equals(rtnStrs[2])) {
						ContainerMovementMgtBC containerMovementMgtBC = new ContainerMovementMgtBCImpl();
						containerMovementMgtBC.updateVgmData(opVo);
					}
				} else {
					commit();
					for (int y = 0; y < (idx); y++) {
						rtnString.append(rtnStrs[1]).append("^^");
						log.debug(rtnStrs[1] + "^^");
					}
				}

			} catch (EventException ex) {
				rollback();
				log.error("err " + ex.toString(), ex);
				throw ex;
			} catch (Exception ex) {
				rollback();
				log.error("err " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}
		}
		log.info("Process End :" + rtnString.toString());
		eventResponse.setETCData("rtnStr", rtnString.toString());
		return eventResponse;

	}

	/**
	 * EES_CTM_0414 : btn2_retrive<br>
	 * UI의 sheet2에 필요한 MVMTHistory List를 조회<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBookingInfoForEDI(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0414Event event = (EesCtm0414Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		ContainerMovementValidationBC commonCommand = new ContainerMovementValidationBCImpl();
		try {
			List<MVMTBookingInfoVO> list = command.searchBookingInfoList(event.getCtmMovementVO(), commonCommand.searchUserCntCode(account.getOfc_cd()));
			eventResponse.setRsVoList(list);
			// 2016.07.25 김상현 [CHM-201642322] Insert/Delete 처리시, 화면에 보이는 데이터가 최신 데이터인지 체크하는 로직 추가
			//  - 최종 조회 시간 저장
			String lastRetrieveDate = command.searchSystemDate();
			eventResponse.setETCData("last_retrieve_date", lastRetrieveDate);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0414 : btn2_save<br>
	 * sheet2저장후 sheet1도 저장<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMVMTHistoryAndEDI(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0414Event event = (EesCtm0414Event)e;
		try {
			begin();
			//===== modifyMVMTProcess (S) ========================================================================
			String rtnStr = modifyMVMTProcess(event.getCusCtmMovementVOS(), event.getCtmMovementVOS());
			//===== modifyMVMTProcess (E)========================================================================
			if (rtnStr == null) {
				rollback();
			} else {
				if (!"".equals(rtnStr)) {
					eventResponse.setETCData("rtnStr", rtnStr);
					rollback();
				} else {
					//===== manageEDIMovement (S)========================================================================
					ContainerMovementMgtForGateNewBC gatenewCommand = new ContainerMovementMgtForGateNewBCImpl();
					SearchEDIMovementListVO searchEDIMovementListVO = event.getSearchEDIMovementListVOS()[0];
					searchEDIMovementListVO.setEdiUiYn("Y");     // edi_ui_yn
					searchEDIMovementListVO.setUserId(account.getUsr_id());    // user_id
					int rtyKnt = Integer.parseInt(searchEDIMovementListVO.getRtyKnt()) + 1;
					searchEDIMovementListVO.setRtyKnt(String.valueOf(rtyKnt));    // rty_knt
					searchEDIMovementListVO.setMvmtEdiRsltCd("Y");
					searchEDIMovementListVO.setMvmtEdiRmk("OK.PROCESSED");
					gatenewCommand.resultUpdb(searchEDIMovementListVO);
					//===== manageEDIMovement (E)========================================================================
					commit();
				}
			}
		} catch (EventException ex) {
			rollback();
			log.error("\n\n[SC - manageMVMTHistoryAndEDI] EventException :\n\n" + ex.getMessage(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("\n\n[SC - manageMVMTHistoryAndEDI] Exception :\n\n" + ex.getMessage(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0460 : btn_retrive<br>
	 * BackEndJob start<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse doBackEndJobVLVDStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0460Event event = (EesCtm0460Event)e;
		LongTxContainerMovementFinderBC command = new LongTxContainerMovementFinderBCImpl();
		try {
			begin();
			eventResponse.setETCData("BackEndJobKey", command.doBackEndJobVLVDStatus(account, event.getVLVDUpdateStatusVO()));
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0461 : form load<br>
	 * US AMS LOCATION LIST 조회<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAmsLocation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0461Event event = (EesCtm0461Event)e;
		ContainerMovementMasterDataMgtBC command = new ContainerMovementMasterDataMgtBCImpl();
		try {
			List<UsAmsLocationListVO> list = command.searchAmsLocation(event.getUsLmsLocationListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0461 : btn_save<br>
	 * US AMS Location List를 수정/삭제<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageUsAmsLocationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0461Event event = (EesCtm0461Event)e;
		ContainerMovementMasterDataMgtBC command = new ContainerMovementMasterDataMgtBCImpl();
		try {
			begin();
			command.manageAmsLocation(event.getUsLmsLocationListVOS(),account);
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0462 : btn_retrive<br>
	 * BackEndJob start<br>
	 * @author Jeong-Hoon, KIM
	 * @param e
	 * @return
	 */
	private EventResponse doBackEndJobAutoCreStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0462Event event = (EesCtm0462Event)e;
		LongTxContainerMovementFinderBC command = new LongTxContainerMovementFinderBCImpl();
		try {
			begin();
			eventResponse.setETCData("BackEndJobKey", command.doBackEndJobAutoCreStatus(account, event.getAutoCreStsListVO()));
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0462 : btn_save<br>
	 * Event Date가 변경된 Movement 내역을 저장.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAutoCreSts(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0462Event event = (EesCtm0462Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		List<SceActRcvIfVO> sceActRcvIfVOs = new ArrayList<SceActRcvIfVO>();
		try {
			begin();
			sceActRcvIfVOs = command.manageAutoCreSts(event.getAutoCreStsListVOS(),account);
			//2012.12.17 나상보 - Movement Event Date 변경시에 SEC로 Data가 넘어가도록 해당 Operation 호출을 추가
//			TRLU8836674
//			TES_PUSBO
			if(sceActRcvIfVOs.size() > 0){
				com.hanjin.apps.alps.esd.sce.copdetailreceive.basic.CopDetailReceiveBC sceCommand = 
					new com.hanjin.apps.alps.esd.sce.copdetailreceive.basic.CopDetailReceiveBCImpl();
				
				for(int i = 0; i < sceActRcvIfVOs.size(); i++){
						sceCommand.createCOPMVMT(sceActRcvIfVOs.get(i));
				}
			}
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}

	/**
	 * 지정한 subString수보다 전체글자수가 작으면 전체글자수만큼 subString 반환<BR>
	 *
	 * @param String str
	 * @param int beginIndex
	 * @param int endIndex
	 * @return String
	 */
	private String subStr(String str, int beginIndex, int endIndex) {
		str = ((str == null || "".equals(str.trim())) ? "" : str.trim());
		int firstIndex = str.length() < beginIndex ? str.length() : beginIndex;
		int lastIndex = str.length() < endIndex ? str.length() : endIndex;
		return str.substring(firstIndex, lastIndex);
	}
	
	/**
	 * EES_CTM_0430 : mvmt_sts_cd onChange<br>
	 * VL/VD일 때 POL / POD LCC 조회<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPolPodLccCd(Event e) throws EventException { 
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0430Event event = (EesCtm0430Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		try {
			String[] rtn = new String[4];
			rtn = command.searchPolPodLccCd(event.getBkgNo(), event.getCntrId());
			eventResponse.setETCData("POL_LCC_CD", rtn[0]);
			eventResponse.setETCData("POD_LCC_CD", rtn[1]);
			eventResponse.setETCData("POL_CD", rtn[2]);
			eventResponse.setETCData("POD_CD", rtn[3]);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_CTM_0463 : Retrieve<br>
	 * Modified event date history Inquiry 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEventDateUpdateHistory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0463Event event = (EesCtm0463Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		try {
			List<EventDateUpdateHistoryParmVO> list = command.searchEventDateUpdateHistory(event.getEventDateUpdateHistoryParmVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * EDIErrorMsgRetry.java에서 호출되는 메소드<br>
	 * 
	 * @param SearchEDIMovementListVO[] searchEDIMovementListVOs
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse manageEDIMovementBatch(SearchEDIMovementListVO[] searchEDIMovementListVOs) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ContainerMovementMgtForGateNewBC gatenewCommand = new ContainerMovementMgtForGateNewBCImpl();

		SearchEDIMovementListVO searchEDIMovementListVO = null;
		FlatFileForGateNewVO flatFileForGateNewVO = null;
		List<SearchEDIMovementListVO> searchEDIMovementList = new ArrayList<SearchEDIMovementListVO>();
		int totalCount = 0;
		int okCount = 0;
		int errorCount = 0;
		int ignoredCount = 0;

		if (searchEDIMovementListVOs != null) {

			for (int k=0; k<searchEDIMovementListVOs.length; k++) {
				searchEDIMovementListVO = null;
				flatFileForGateNewVO = null;
				searchEDIMovementListVOs[k].setEdiUiYn("Y");                   // edi_ui_yn (0404/0414화면에서의 실행인지 구분값)
				searchEDIMovementListVOs[k].setBatchFlg("Y");  					// batch_flg (배치 재처리 인지 여부)
				searchEDIMovementListVOs[k].setUserId("BATCH");    // user_id
				searchEDIMovementListVOs[k].setUserNm("BATCH");    // user_nm

				if ("VL".equals(searchEDIMovementListVOs[k].getEdiMvmtStsCd()) || "VD".equals(searchEDIMovementListVOs[k].getEdiMvmtStsCd()) ) {
					searchEDIMovementListVOs[k].setEdiMvmtStsCd("ZZ");
				}

				try {
					// AssignEdiUiVO2FlatFileVO for GateNew ////////////////////////////
					flatFileForGateNewVO = gatenewCommand.assignEdiUiVO2FlatFileVO(searchEDIMovementListVOs[k]);
					// BCImpl.GateNew 시작  ////////////////////////////////////////////
//					begin();    // gateNew BEGIN
					flatFileForGateNewVO = gatenewCommand.gateNew(flatFileForGateNewVO);
//					commit();
				} catch (EventException ex) {
//					rollback();
					throw ex;
				} catch (Exception ex) {
//					rollback();
					throw new EventException(ex.getMessage(), ex);
				}

				// return된 flatFileForGateNewVO가 null이 아니라면 /////////////////
				if (flatFileForGateNewVO != null) { 
					// manageGateNewProcess ////////////////////////////////////////
					flatFileForGateNewVO = this.manageGateNewProcessByBatch(flatFileForGateNewVO);
					// AssignFlatFileVO2EdiUiVO for GateNew ////////////////////////
					searchEDIMovementListVO = gatenewCommand.assignFlatFileVO2EdiUiVO(flatFileForGateNewVO, searchEDIMovementListVOs[k]);
				}

				// return된 searchEDIMovementListVO가 null이 아니라면 /////////////////
				if (searchEDIMovementListVO != null) {
					try {
						int rtyKnt = Integer.parseInt(searchEDIMovementListVOs[k].getRtyKnt()) + 1;
						searchEDIMovementListVO.setRtyKnt(String.valueOf(rtyKnt));    // rty_knt
//						begin();    // resultUpdb BEGIN
						searchEDIMovementListVO = gatenewCommand.resultUpdb(searchEDIMovementListVO);
//						commit();
					} catch (EventException ex) {
//						rollback();
						throw ex;
					} catch (Exception ex) {
//						rollback();
						throw new EventException(ex.getMessage(), ex);
					}

					// Count : mvmtEdiRsltCd가 Y가 아닌 경우에만 resultList에 add
					if ("N".equals(searchEDIMovementListVO.getMvmtEdiRsltCd())) {
						searchEDIMovementList.add(searchEDIMovementListVO);
						errorCount = errorCount + 1;
					} else if ("X".equals(searchEDIMovementListVO.getMvmtEdiRsltCd()) || "I".equals(searchEDIMovementListVO.getMvmtEdiRsltCd())) {
						ignoredCount = ignoredCount + 1;
					} else {
						okCount = okCount + 1;
					}
					totalCount = totalCount + 1;
				}	//end of if
			}	//end of for
		}	//end of if

		// 결과값 setting
		eventResponse.setETCData("total_count", String.valueOf(totalCount));
		eventResponse.setETCData("ok_count",  String.valueOf(okCount));
		eventResponse.setETCData("error_count",  String.valueOf(errorCount));
		eventResponse.setETCData("ignored_count",  String.valueOf(ignoredCount));
		eventResponse.setRsVoList(searchEDIMovementList);
		return eventResponse;
	}
	
	/**
	 * manageEDIMovementBatch 에서 호출<br>
	 * GATENEW Process 처리<br> 
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @return FlatFileForGateNewVO
	 * @exception EventException
	 */
	private FlatFileForGateNewVO manageGateNewProcessByBatch(FlatFileForGateNewVO flatFileForGateNewVO) throws EventException {
		ContainerMovementMgtForGateNewBC gatenewCommand = new ContainerMovementMgtForGateNewBCImpl();
		String[] returnValues = new String[2];

		/* @checkNassignData 결과가 Y일 경우 */
		if ( "Y".equals(flatFileForGateNewVO.getCheckNassignData()) ) {

			/* Chassis Case가 Y일 경우 @createChassisMovement 호출 */
			if ( "Y".equals(flatFileForGateNewVO.getChssCase()) ) {
				/* gatenew를 통해 접수된 322 Data에 대하여 관련 수신 Data가 Chassis일 경우 연관 serveice를 호출 ( As Is : chs_dbup.pc) */
				log.info("\n\n===============================================================" +
						 "\n Chassis - manageCHSMovementBareByGatenewBasic 호출" +
						 "\n===============================================================\n");
				try {
					ChassisMovementHistoryBC cgmCommand = new ChassisMovementHistoryBCImpl();
//					begin();    // Chassis BEGIN
					returnValues = cgmCommand.manageCHSMovementBareByGatenewBasic( flatFileForGateNewVO );
//					commit();    //  Chassis COMMIT
				} catch (EventException ex) {
					/******************************************************
					 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음   *
					 ******************************************************/
//					rollback();    // Chassis ROLLBACK
					flatFileForGateNewVO.setResultIndicator("N");
					flatFileForGateNewVO.setResultMessage("SYSTEM ERROR (Chassis ERROR)");
					log.error("\n\nerr " + ex.toString(), ex);
				} catch (Exception ex) {
//					rollback();    // Chassis ROLLBACK
					flatFileForGateNewVO.setResultIndicator("N");
					flatFileForGateNewVO.setResultMessage("SYSTEM ERROR (Chassis ERROR)");
					log.error("\n\nerr " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}
				log.info("\n\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% CHASSIS_STS 1 : " + returnValues[1] +
						 "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% CHASSIS_MSG 1 : " + returnValues[0] + "\n");

				// 정상처리일때 return값 : returnValues[0] = "", returnValues[1] = "Y"
				if ( returnValues[0].equals("") && returnValues[1].equals("Y") ) {    /* Error가 아닐때 */
					flatFileForGateNewVO.setResultMessage("OK.PROCESSED");
					flatFileForGateNewVO.setResultIndicator("Y");

				} else {    /* Error 발생시 */
					flatFileForGateNewVO.setResultMessage(returnValues[0].trim());
					flatFileForGateNewVO.setResultIndicator("N");

				}

			} else {    /* Chassis Case가 Y가 아닐경우 */

				/* Mvmt Status가 "ER", "ZZ", ""이 아닐경우 CTM-COMMON 호출 */
				if ( !"ER".equals(flatFileForGateNewVO.getMvmtStatus()) && !"ZZ".equals(flatFileForGateNewVO.getMvmtStatus()) ) {

					/* @generateMovement (S) +++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
					CusCtmMovementVO[] setCustVOs = null;
					// OP, OC Case
					/*
					 * 2015.12.24 추가 by Sang-Hyun Kim
					 * "TMAT", "TIND", "TESI", "THYI" Domestic booking으로 판별하도록 추가.
					 *  - HJL이 아닌 타 업체 booking no.
					 */
					String domesticCheck = subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 4);
					if (("OP".equals(flatFileForGateNewVO.getMvmtStatus()) || "OC".equals(flatFileForGateNewVO.getMvmtStatus()))
							&& (!"DLAX".equals(domesticCheck) && !"DCHI".equals(domesticCheck) && !"DHOU".equals(domesticCheck)
									&& !"DMEM".equals(domesticCheck) && !"DNYC".equals(domesticCheck) && !"DSEA".equals(domesticCheck)
									&& !"TCHI".equals(domesticCheck) && !"DHJI".equals(domesticCheck) && !"THJI".equals(domesticCheck)
									&& !"TMAT".equals(domesticCheck) && !"TIND".equals(domesticCheck) && !"TESI".equals(domesticCheck)
									&& !"THYI".equals(domesticCheck))) {
						// MVMT Common1 호출 (S)
						log.info("\n\n===============================================================" +
								 "\n manageCreateProcess(setCustVOs, length) ++++++ MVMT Common 호출1" +
								 "\n===============================================================\n");
						try {
							setCustVOs = gatenewCommand.assignCommonVO( flatFileForGateNewVO, (flatFileForGateNewVO.getBkgNumber() == null ? 0 : flatFileForGateNewVO.getBkgNumber().length));
//							begin();    // COMMON BEGIN
							returnValues = manageCreateProcess(setCustVOs, setCustVOs.length, false, false);

							// 2016.07.11 김상현 [CHM-201642556] 동일한 MVMT에서 VGM이 나중에 EDI 수신되어 오류처리되는 경우, VGM 소급 update logic 추가
							//  - 동일한 Movement에 대해서 VGM 데이터가 없을 경우, VGM 데이터 업데이트 처리
							if (returnValues[2] != null && "VGM".equals(returnValues[2])) {
								ContainerMovementMgtBC containerMovementMgtBC = new ContainerMovementMgtBCImpl();
								containerMovementMgtBC.updateVgmData(setCustVOs);
							}

//							if ( "N".equals(returnValues[0]) ) {
//								rollback();    // COMMON ROLLBACK
//							} else {
//								commit();    //  COMMON COMMIT
//							}
						} catch (EventException ex) {
							/******************************************************
							 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음   *
							 ******************************************************/
//							rollback();    // COMMON ROLLBACK
							returnValues[0] = "N";
							returnValues[1] = ex.getMessage();
							log.error("\n\nerr " + ex.toString(), ex);
						} catch (Exception ex) {
//							rollback();    // COMMON ROLLBACK
							flatFileForGateNewVO.setResultIndicator("N");
							flatFileForGateNewVO.setResultMessage("SYSTEM ERROR (MVMT Common ERROR)");
							log.error("\n\nerr " + ex.toString(), ex);
							throw new EventException(ex.getMessage(), ex);
						}
						log.info("\n\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% COMMON_STS 1 : " + returnValues[0] +
								 "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% COMMON_MSG 1 : " + returnValues[1] + "\n");
						/* MVMT Common1 호출 (E) +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/


					} else if ("USA".equals(flatFileForGateNewVO.getMuidArea())
							&& ("DLAX".equals(domesticCheck) || "DCHI".equals(domesticCheck) || "DHOU".equals(domesticCheck)
									|| "DMEM".equals(domesticCheck) || "DNYC".equals(domesticCheck) || "DSEA".equals(domesticCheck)
									|| "TCHI".equals(domesticCheck) || "DHJI".equals(domesticCheck) || "THJI".equals(domesticCheck)
									|| "TMAT".equals(domesticCheck) || "TIND".equals(domesticCheck) || "TESI".equals(domesticCheck)
									|| "THYI".equals(domesticCheck))) { // Domestic Case
						// Domestic MVMT Common 호출 (S)
						log.info("\n\n===============================================================" +
								 "\n manageDomesticMVMT(vos[0], account) ++++++ Domestic MVMT Common 호출" +
								 "\n===============================================================\n");
						
						try {
							setCustVOs = gatenewCommand.assignCommonVO( flatFileForGateNewVO, 1 );
							ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
//							begin();    // Domestic-COMMON BEGIN
							CrossItemVO item = command.manageDomesticMVMT(setCustVOs[0], subStr(flatFileForGateNewVO.getEventYard(), 0, 2));
							returnValues = item.getRtnStr();
//							if ( "N".equals(returnValues[0]) ) {
//								rollback();    // Domestic-COMMON ROLLBACK
//							} else {
								
								if (item.getUpdateMaster() == true) {
									ContainerOnOffhireBC mstCommand = new ContainerOnOffhireBCImpl();
									mstCommand.updateCntrMasterByMvmtBasic(item);
								}
//								commit();    //  Domestic-COMMON COMMIT
//							}
							
							// 2013.09.24 강   환 [CHM-201325811] Each Container Inquiry 기능 보완 (CO-CP생성시 auto  생성된 MT 를 SCEM에 추가 IF)
							if(item.getSceActRcvIfVOs().size() > 0){
								com.hanjin.apps.alps.esd.sce.copdetailreceive.basic.CopDetailReceiveBC sceCommand = 
									new com.hanjin.apps.alps.esd.sce.copdetailreceive.basic.CopDetailReceiveBCImpl();
								
								for(int i = 0; i < item.getSceActRcvIfVOs().size(); i++){
										sceCommand.createCOPMVMT(item.getSceActRcvIfVOs().get(i));
								}
							}
							// 2013.09.24 강   환 [CHM-201325811] Each Container Inquiry 기능 보완 (CO-CP생성시 auto  생성된 MT 를 SCEM에 추가 IF)

						} catch (EventException ex) {
							/******************************************************
							 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음   *
							 ******************************************************/
//							rollback();    // Domestic-COMMON ROLLBACK
							returnValues[0] = "N";
							returnValues[1] = ex.getMessage().replace("APP", "").replaceAll("<", "").replaceAll("\\|", "").replaceAll(">", "");
							log.error("\n\nerr " + ex.toString(), ex);
						} catch (Exception ex) {
//							rollback();    // Domestic-COMMON ROLLBACK
							log.error("\n\nerr " + ex.toString(), ex);
							throw new EventException(ex.getMessage(), ex);
						}
						log.info("\n\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Domestic-COMMON_STS : " + returnValues[0] +
								 "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Domestic-COMMON_MSG : " + returnValues[1] + "\n");
						/* Domestic MVMT COmmon 호출 (E) ++++++++++++++++++++++++++++++++++++++++++++++++++*/


					}
					/* _______________________________________________________________________________________________________________________ */
					/* __________________________________________________________________________________ International MVMT ( Except OP, OC ) */
					else {

						boolean nBkgNoFlg = false;
						if ( "VL".equals(flatFileForGateNewVO.getMvmtStatus()) && "Y".equals(flatFileForGateNewVO.getNBkgNoFlg()) ) {
							nBkgNoFlg = true;
						}

						/* MVMT Common2 호출 (S) +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
						log.info("\n\n===============================================================" +
								 "\n manageCreateProcess(setCustVOs, length) ++++++ MVMT Common 호출2" +
								 "\n===============================================================\n");
						try {
							setCustVOs = gatenewCommand.assignCommonVO( flatFileForGateNewVO, 1 );
//							begin();    // COMMON BEGIN
							returnValues = manageCreateProcess(setCustVOs, setCustVOs.length, nBkgNoFlg, false);
//							if ( "N".equals(returnValues[0]) ) {
//								rollback();    // COMMON ROLLBACK
//							} else {
//								commit();    //  COMMON COMMIT
//							}
						} catch (EventException ex) {
							/******************************************************
							 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음   *
							 ******************************************************/
//							rollback();    // COMMON ROLLBACK
							returnValues[0] = "N";
							returnValues[1] = ex.getMessage();
							log.error("\n\nerr " + ex.toString(), ex);
						} catch (Exception ex) {
//							rollback();    // COMMON ROLLBACK
							flatFileForGateNewVO.setResultIndicator("N");
							flatFileForGateNewVO.setResultMessage("SYSTEM ERROR (MVMT Common ERROR)");
							log.error("\n\nerr " + ex.toString(), ex);
							throw new EventException(ex.getMessage(), ex);
						}
						log.info("\n\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% COMMON_STS 2 : " + returnValues[0] +
								 "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% COMMON_MSG 2 : " + returnValues[1] + "\n");
						/* MVMT Common2 호출 (E) +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/

					}
					/* @generateMovement (E) +++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
				}

				if (returnValues[0] == null || returnValues[0].trim().equals("") || returnValues[0].trim().equals("null")) {
					returnValues[0] = "";
				} else {
					returnValues[0] = returnValues[0].trim();
				}
				if (returnValues[1] == null || returnValues[1].trim().equals("") || returnValues[1].trim().equals("null")) {
					returnValues[1] = "";
				} else {
					returnValues[1] = returnValues[1].trim();
				}

				// result값을 returnVo에 setting
				flatFileForGateNewVO.setResultIndicator(returnValues[0]);
				flatFileForGateNewVO.setResultMessage(returnValues[1]);
			}
		}
		return flatFileForGateNewVO;
	}

	/**
	 * EES_CTM_0465 : btn_retrive<br>
	 * Multi Container Inquiry 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMovementListByMultiContainer(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0465Event event = (EesCtm0465Event)e;
		ContainerMovementFinderBC command = new ContainerMovementFinderBCImpl();

		try {
			List<SearchMovementListByMultiContainerVO> list1 = command.searchMovementListByMultiContainer(event.getSearchMovementListByMultiContainerVO());
			eventResponse.setRsVoList(list1);
			
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Multi Container Inquiry Error 리스트 조회 이벤트 처리
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchMovementErrorListByMultiContainer(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0465Event event = (EesCtm0465Event)e;
		ContainerMovementFinderBC command = new ContainerMovementFinderBCImpl();

		try {
			List<SearchEDIMovementListVO> list = command.searchMovementErrorListByMultiContainer(event.getSearchMovementListByMultiContainerVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0440 : btn_retrive<br>
	 * VL/VD correction by VVD 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCorrectionVLVDListByVVD(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0440Event event = (EesCtm0440Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		try {
			List<CorrectionVLVDListVO> list = command.searchCorrectionVLVDListByVVD(event.getCorrectionVLVDList());
			eventResponse.setRsVoList(list);
			// 2016.07.25 김상현 [CHM-201642322] Insert/Delete 처리시, 화면에 보이는 데이터가 최신 데이터인지 체크하는 로직 추가
			//  - 최종 조회 시간 저장
			String lastRetrieveDate = command.searchSystemDate();
			eventResponse.setETCData("last_retrieve_date", lastRetrieveDate);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**	 * 
	 * EES_CTM_0440 : btn_retrive<br>
	 * VL/VD correction by Yard CD 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVLVDYardCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0440Event event = (EesCtm0440Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		try {
			List<CorrectionVLVDListVO> list = command.searchVLVDYardCode(event.getCorrectionVLVDList());
			if(list.size() > 0){
//				String yd_cd_list = "";
				StringBuffer yd_cd_list = new StringBuffer();
				for (int i=0; i<list.size(); i++){
//					yd_cd_list += list.get(i).getYdCd() + ",";
					yd_cd_list.append(list.get(i).getYdCd());
					yd_cd_list.append(",");
				}
				eventResponse.setETCData("yd_cd", yd_cd_list.toString());
			}
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**	 * 
	 * EES_CTM_0436 : btn_retrive<br>
	 * ContinerMovementHistiory 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse containerMovementHistoryMonitorList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0436Event event = (EesCtm0436Event)e;
		ContainerMovementFinderBC command = new ContainerMovementFinderBCImpl();
		try{
			List<SearchMovementHistoryMonitorListVO> list = command.containerMovementHistoryMonitorList(event.getSearchMovementHistoryMonitorListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**	 * 
	 * EES_CTM_0436 : btn_retrive<br>
	 * movement correction Histiory summary yard 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse movementCorrctionMonitorList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0436Event event = (EesCtm0436Event)e;
		ContainerMovementFinderBC command = new ContainerMovementFinderBCImpl();
		try{
			List<SearchMovementHistoryMonitorListVO> list = command.movementCorrctionMonitorList(event.getSearchMovementHistoryMonitorListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**	 * 
	 * EES_CTM_0436 : btn_retrive<br>
	 * movement correction Histiory summary Lcc 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse movementCorrctionMonitorLccList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0436Event event = (EesCtm0436Event)e;
		ContainerMovementFinderBC command = new ContainerMovementFinderBCImpl();
		try{
			List<SearchMovementHistoryMonitorListVO> list = command.movementCorrctionMonitorLccList(event.getSearchMovementHistoryMonitorListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**	 * 
	 * EES_CTM_0436 : btn_retrive<br>
	 * movement correction Histiory summary Rcc 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse movementCorrctionMonitorRccList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0436Event event = (EesCtm0436Event)e;
		ContainerMovementFinderBC command = new ContainerMovementFinderBCImpl();
		try{
			List<SearchMovementHistoryMonitorListVO> list = command.movementCorrctionMonitorRccList(event.getSearchMovementHistoryMonitorListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**	 * 
	 * EES_CTM_0436 : selectbox의 rhq를 조회한다.<br>
	 * ContinerMovementHistiory 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse getRhqOfficeList(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0436Event event = (EesCtm0436Event)e;
		ContainerMovementFinderBC command = new ContainerMovementFinderBCImpl();
		try{
			List<SearchMovementHistoryMonitorListVO> list = command.getRhqOfficeList(event.getSearchMovementHistoryMonitorListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} 
		
		return eventResponse;
	}
	/**	 * 
	 * EES_CTM_0436 : selectbox의 office를 조회한다.<br>
	 * ContinerMovementHistiory 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse getOfficeByRhqLevelList(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0436Event event = (EesCtm0436Event)e;
		ContainerMovementFinderBC command = new ContainerMovementFinderBCImpl();
		try{
			List<SearchMovementHistoryMonitorListVO> list = command.getOfficeByRhqLevelList(event.getSearchMovementHistoryMonitorListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} 
		
		return eventResponse;
	}
	
	/**
	 * EES_CTM_0437 : btn_retrive<br>
	 * Correction History Inquiry 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCorrectionHistory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0437Event event = (EesCtm0437Event)e;
		ContainerMovementFinderBC command = new ContainerMovementFinderBCImpl();

		try {
			List<SearchCorrectionHistoryVO> list1 = command.searchCorrectionHistory(event.getSearchCorrectionHistoryVO());
			eventResponse.setRsVoList(list1);
			
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * VERMAS EDI 데이터 저장
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse receiveVermasEdi(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ContainerMovementMgtForGateNewBC containerMovementMgtForGateNewBC = new ContainerMovementMgtForGateNewBCImpl();

		try {
			CtmVrfdGrsMassEdiMsgVO ctmVrfdGrsMassEdiMsgVOs[] = null;

			if (e.getEventName().equals("UbizhjsAlpsCtmVermasEvent")) {
				UbizhjsAlpsCtmVermasEvent event = (UbizhjsAlpsCtmVermasEvent)e;
				ctmVrfdGrsMassEdiMsgVOs = containerMovementMgtForGateNewBC.assignVermasFlatFileVO(event.getFlatFile());
			} else {
				EesCtm0000Event event = (EesCtm0000Event)e;
				ctmVrfdGrsMassEdiMsgVOs = containerMovementMgtForGateNewBC.assignVermasFlatFileVO(event.getFlatFileText());
			}
			begin();
			containerMovementMgtForGateNewBC.addCtmVrfdGrsMassEdiMsg(ctmVrfdGrsMassEdiMsgVOs);
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * Inbound vermas EDI 데이터 조회.
	 * @param event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchVermasList(Event event) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ContainerMovementFinderBC containerMovementFinderBC = new ContainerMovementFinderBCImpl();
		EesCtm0468Event eesCtm0468Event = (EesCtm0468Event)event;

		try {
			List<SearchVermasListVO> list = containerMovementFinderBC.searchVermasList(eesCtm0468Event.getSearchVermasListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * 마지막 retrieve 이후에 수정된 데이터가 있는데 확인
	 * @param event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchModifiedDataCount(Event event) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ContainerMovementMgtBC containerMovementMgtBC = new ContainerMovementMgtBCImpl();
		EesCtm0430Event eesCtm0430Event = (EesCtm0430Event)event;

		try {
			int rowCount = containerMovementMgtBC.searchModifiedDataCount(eesCtm0430Event.getCtmMovementVO().getCntrNo(), eesCtm0430Event.getCtmMovementVO().getUpdDt());
			eventResponse.setETCData("row_count", (new Integer(rowCount)).toString());
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
}
