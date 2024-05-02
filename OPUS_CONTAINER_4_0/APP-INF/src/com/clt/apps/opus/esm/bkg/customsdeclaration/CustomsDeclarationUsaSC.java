/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CustomsDeclarationSC.java
 *@FileTitle : ESM_BKG-0017
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.06.01
 *@LastModifier : 민정호
 *@LastVersion : 1.1
 * 2009.04.21 김승민
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgReferenceNoGenerationVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.MdmCustVO;
import com.clt.apps.opus.esm.bkg.common.CountryCode;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.basic.UsaCustomsReportBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.basic.UsaCustomsReportBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg0041Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg0359Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg0428Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg0429Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg0507Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg0508Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg0518Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg0574Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg0819Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg1037Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg1122Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.BaplieMonitorCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.ContainerDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.RailHistoryDetailListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.TransmissionChkListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.UsaAmsReportIsf5ListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.UsaAmsReportListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.UsaVesselArrivalCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.UsaVesselArrivalDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.AmsRailListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.AmsReportListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.CheckListDetailListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.RcvHistDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.ReceiveLogDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.ScacReportDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistFileDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.basic.UsaCustomsTransmissionBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.basic.UsaCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.event.EsmBkg0233Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.event.EsmBkg0514Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.event.EsmBkg0543Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.event.EsmBkg1023Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.event.EsmBkg1098Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.event.OpusbkgEdiErrUsReceiveEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.event.Ubiz2comOpusbkgAmsAckEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.BaplieAlarmSetupVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.StiDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaEDADetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaManifestListCondForEdiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaRcvMsgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaTmlBlByVvdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestListCondForEdiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestListForEdiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.basic.UsaInbondTransmissionBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.basic.UsaInbondTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.event.EsmBkg0408Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.event.EsmBkg0533Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.event.EsmBkg0540Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.ClearanceTypeDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.InBondNumberDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.InBondNumberVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaInbondContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaInbondManifestDetailListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaInbondManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaInbondManifestListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaMibTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.vo.InbondListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.vo.InbondManifestDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.basic.CndManifestListDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.basic.CndManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.HusBlInpChkVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.basic.UsaManifestListDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.basic.UsaManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0034Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0036Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0037Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0210Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0393Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0613Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0926Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0947Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg1008Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg1144Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg1179Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.OrgPartyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsCustomsStatusNoticeVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBkgCmVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBlCustVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBlDetailContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBlKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBlRemarkVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaCntrListRsltVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaContainerManifestDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaDownloadSummaryVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaHblCheckDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestListContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestListDownloadCntrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestSearchCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestSearchDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaVesselVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UserAuthListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UserAuthListModiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UserInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.AuthSetupListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ContainerListRsltVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.DispoCdDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.DispoCdListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.HouseBlDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.SetupListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBC;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBCImpl;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CstmsClrVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.HoldNoticeBC;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.HoldNoticeBCImpl;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CstmsHldVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.basic.CLLCDLManifestBC;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.basic.CLLCDLManifestBCImpl;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllCdlTransmitVO;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCstmsAdvIbdVO;
import com.clt.syscommon.common.table.BkgNtcHisVO;
import com.clt.syscommon.common.table.ComUserVO;
import com.clt.syscommon.common.table.MdmCountryVO;
import com.clt.syscommon.common.table.MdmLocationVO;
import com.clt.syscommon.common.table.MdmPortVO;

/**
 * OPUS-CustomsDeclarationUsaSC Business Logic ServiceCommand -
 * OPUS-CustomsDeclarationUsaSC handling business transaction.
 *
 * @author 2012505
 * @see
 * @since J2EE 1.4
 */
public class CustomsDeclarationUsaSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CustomsDeclarationUsaSC system <br>
	 * ESM_BKG-0017<br>
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
	 * CustomsDeclarationUsaSC system <br>
	 * ESM_BKG-0017 <br>
	 */
	public void doEnd() {
		log.debug("CustomsDeclarationUsaSC 종료");
	}

	/**
	 *
	 * OPUS-CustomsDeclarationUsaSC system <br>
	 *
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		log.info("[SC.perform] Start ---------------------------");
		log.info("[SC.perform] e.getEventName() : " + e.getEventName());
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		/**
		 * SC가 USA 여러 이벤트를 처리하는 경우 사용해야 할 부분 manifestlistdownload Event DeFine
		 */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0034Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUserAuthority(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = inquiryBlData(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = reactivateBl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = removeBl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchDispositionCdList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = correctBl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				// DUMMY BL NO
				eventResponse = manageBkgReferenceNumberGeneration(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01) || e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = searchMdmCust(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY11)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY12)) {
				eventResponse = transmitManifestIsf(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchUiSetUpInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0036Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH) || e.getFormCommand().isCommand(FormCommand.SEARCH01)
					|| e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchContainerManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = modifyContainerManifest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0037Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH) || e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchContainerList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageContainerList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0210Event")) {
			// log.info("=== EsmBkg0210Event Start ===");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				// log.info("=== EsmBkg0210Event SEARCH ===");
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = manageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = deleteManifest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0393Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = checkHouseBlDataList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0613Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchUserAuthYn(e); // 초기 오픈시 유저 권한 체크.
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeBl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitManifest(e); // MI/HI/TI 전송.
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = transmitOfm(e); // Ofm Generation.
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchVessel(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0926Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSetupList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSetupList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifySetupList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = modifySetupList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0947Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				BookingUtil command2 = new BookingUtil();
				// ALL 옵션을 위한 기본 콤보 객체 선언.
				// BkgComboVO combovo = new BkgComboVO();
				// combovo.setDesc(" ");
				// combovo.setName(" ");
				List<BkgComboVO> list = command2.searchCombo("CD02571");
				// list.add(0, combovo);

				GeneralEventResponse response = new GeneralEventResponse();
				// Message Type Code 콤보 조회
				response.setRsVoList(list);
				eventResponse = response;
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDispositionCdList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDispositionCdList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1008Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAuthSetupList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchUiSetUpInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageAuthSetupList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1144Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOrgPartyList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMdmCust(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchLocation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				GeneralEventResponse response = new GeneralEventResponse();
				response.setRsVoList(searchCodeCombo("CD03013"));
				eventResponse = response;

			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageOrgPartyInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1179Event")) {

			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUsCustomsStatusNoticeInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageUsCustomsStatusNoticeInfo(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0408Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH) || e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = assignInBondNumber(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01) || e.getFormCommand().isCommand(FormCommand.MULTI02)
					|| e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchUserAuthInfoForHub(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0533Event") || e.getEventName().equalsIgnoreCase("EsmBkg0408Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH) || e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = assignInBondNumber(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01) || e.getFormCommand().isCommand(FormCommand.MULTI02)
					|| e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchUserAuthInfoForHub(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0540Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMdmCust(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCommodity(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchLocation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchScNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManifest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0233Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchUserAuthYn(e); // 초기 오픈시 유저 권한 체크.
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeBl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitManifest(e); // MI/HI/TI 전송.
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = transmitOfm(e); // Ofm Generation.
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchVessel(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0514Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchUserAuthYn(e); // 초기 오픈시 유저 권한 체크.
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeBl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitManifest(e); // MI/HI/TI 전송.
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = transmitOfm(e); // Ofm Generation.
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchVessel(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0543Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchUserAuthYn(e); // 초기 오픈시 유저 권한 체크.
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeBl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitManifest(e); // MI/HI/TI 전송.
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = transmitOfm(e); // Ofm Generation.
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchVessel(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1023Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchStowageManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitStowageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1098Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBaplieAlarmSetup(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBaplieAlarmSetup(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = new GeneralEventResponse();
				BookingUtil command = new BookingUtil();
				String retVal = command.searchMdmLocPortName(((EsmBkg1098Event) e).getStrLocCd());
				eventResponse.setETCData("port_cd", (retVal == null || retVal.equals("")) ? "INVALID" : retVal);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = new GeneralEventResponse();
				BookingUtil command = new BookingUtil();
				String retVal = command.searchMdmVslSvcLane(((EsmBkg1098Event) e).getStrSlanCd());
				eventResponse.setETCData("slan_cd", retVal);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = new GeneralEventResponse();
				BookingUtil command = new BookingUtil();
				ComUserVO comUserVO = command.searchComUserInfo(((EsmBkg1098Event) e).getStrUsrId());
				if (comUserVO != null) {
					eventResponse.setETCData("rcvr_eml", comUserVO.getUsrEml());
					eventResponse.setETCData("usr_nm", comUserVO.getUsrNm());
					eventResponse.setETCData("ofc_cd", comUserVO.getOfcCd());
				} else {
					eventResponse.setETCData("rcvr_eml", "");
					eventResponse.setETCData("usr_nm", "");
					eventResponse.setETCData("ofc_cd", "");
				}
			}
		} else if (e.getEventName().equalsIgnoreCase("Ubiz2comOpusbkgAmsAckEvent")) {
			eventResponse = loadCstmsRcvMsg(e);
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0041Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAmsReportList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchDispositionCdList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchComCode1125(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0359Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTransmissionCheckList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchVesselArrival(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0428Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAmsReportList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				GeneralEventResponse response = new GeneralEventResponse();
				// Message Type Code 콤보 조회
				response.setRsVoList(searchCodeCombo("CD02292"));
				// 미국 현재 날짜 조회
				response.setETCData("date", searchLocalSysdate(e));
				eventResponse = response;
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0429Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAmsReportList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				GeneralEventResponse response = new GeneralEventResponse();
				// Message Type Code 콤보 조회
				response.setRsVoList(searchCodeCombo("CD02292"));
				// 미국 현재 날짜 조회
				response.setETCData("date", searchLocalSysdate(e));
				eventResponse = response;
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0507Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH) || e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchTransmitHistList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchTransmitHistList2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchUserAuthYn(e); // 초기 오픈시 유저 권한 체크.
			} else {
				GeneralEventResponse response = new GeneralEventResponse();
				// Message Type Code 콤보 조회
				response.setRsVoList(searchCodeCombo("CD02235"));
				// 미국 현재 날짜 조회
				response.setETCData("date", searchLocalSysdate(e));
				eventResponse = response;
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0508Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH) || e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchTransmitHistList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchTransmitHistList2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchUserAuthYn(e); // 초기 오픈시 유저 권한 체크.
			} else {
				GeneralEventResponse response = new GeneralEventResponse();
				// Message Type Code 콤보 조회
				response.setRsVoList(searchCodeCombo("CD02235"));
				// 미국 현재 날짜 조회
				response.setETCData("date", searchLocalSysdate(e));
				eventResponse = response;
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0518Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBlListByCntr(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0574Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchScacReportByVvdPod(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCodeConversion(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0819Event") || e.getEventName().equalsIgnoreCase("EsmBkg0041Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAmsReportList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchDispositionCdList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchComCode1125(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1037Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAmsRailHistoryList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1122Event")) { // 2011.06.20
																			// 김봉균
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBaplieMonitor(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchUsLastForeignPort(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("OpusbkgEdiErrUsReceiveEvent")) {
			eventResponse = loadEdiErr(e);
		}

		log.info("[SC.perform] End ---------------------------");
		return eventResponse;
	}

	/**
	 *
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse loadEdiErr(Event e) throws EventException {
		log.info("SC [loadEdiErr] Start---------------------");
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaCustomsTransmissionBC command = null;

		try {
			begin();

			// Canada 수신
			OpusbkgEdiErrUsReceiveEvent event = (OpusbkgEdiErrUsReceiveEvent) e;
			command = new UsaCustomsTransmissionBCImpl();
			String strFlatFile = event.getFlatFile();
			command.loadEdiErr(strFlatFile);
			commit();

		} catch (EventException ex) {
			log.error("EventException : " + ex.getMessage());
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("Exception : " + ex.getMessage());
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0034 : SEARCH <br>
	 * searchUserAuthority 조회<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUserAuthority(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaManifestListDownloadBC command = null;
		String usrId = account.getUsr_id();
		command = new UsaManifestListDownloadBCImpl();
		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0034Event")) {
				UserAuthListModiVO userAuthVO = (UserAuthListModiVO) command.searchUserAuthority(usrId, account.getOfc_cd());
				if (userAuthVO != null) {
					eventResponse.setETCData(userAuthVO.getColumnValues());
				}
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0613 : INIT <br>
	 * ESM_BKG_0507 : INIT <br>
	 * searchUserAuthYn 조회<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse inquiryBlData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		UsaManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// 이벤트별 Impl 생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0034Event")) {
				EsmBkg0034Event event = (EsmBkg0034Event) e;
				command = new UsaManifestListDownloadBCImpl();

				List<BlDetailVO> list = command.inquiryBlData(event.getBlCondVO());
				UsaBlDetailContainerVO vo = (UsaBlDetailContainerVO) list.get(0);

				eventResponse.setETCData("div_ind", vo.getDivInd());

				if (vo.getUsaAiBlInfoVO() != null) {
					eventResponse.setRsVo(vo.getUsaAiBlInfoVO());
					eventResponse.setETCData(vo.getUsaAiBlInfoVO().getColumnValues());
				}
				if (vo.getUsaBlCustVOs() != null) {
					eventResponse.setRsVoList(vo.getUsaBlCustVOs());
				}
				if (vo.getUsaBlCustomerSecondVOs() != null) {
					eventResponse.setRsVoList(vo.getUsaBlCustomerSecondVOs());
				}
				if (vo.getUsaBlCustomsResultVOs() != null) {
					eventResponse.setRsVoList(vo.getUsaBlCustomsResultVOs());
				}
				if (vo.getUsaBlRemarkVOs() != null && vo.getUsaBlRemarkVOs().size() > 0) {
					UsaBlRemarkVO remarkVO = vo.getUsaBlRemarkVOs().get(0);
					if (!"".equals(remarkVO.getDiffRmk())) {
						eventResponse.setETCData("diff_rmk", remarkVO.getDiffRmk());
					}
					if (!"".equals(remarkVO.getCntrNo()) || !"".equals(remarkVO.getRailCrrRefNo()) || !"".equals(remarkVO.getIbdTrspNo())) {
						eventResponse.setRsVoList(vo.getUsaBlRemarkVOs());
					}
				}
				if (vo.getUsaBlHistoryVOs() != null) {
					eventResponse.setRsVoList(vo.getUsaBlHistoryVOs());
				}
				if (vo.getUsaBlHblListVOs() != null) {
					eventResponse.setRsVoList(vo.getUsaBlHblListVOs());
				}
				if (vo.getUsaBlMultiBlListVOs() != null) {
					eventResponse.setRsVoList(vo.getUsaBlMultiBlListVOs());
				}
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0018 : MULTI <br>
	 * ESM_BKG_0016 : MULTI <br>
	 * Panama를 통과하는 화물에 대한 Manifest를 ACP(Authority of Canal of Panama)에 신고하기 위해
	 * 사전 VVD INFORMATION을 입력한다.<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse reactivateBl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0034Event")) {
				EsmBkg0034Event event = (EsmBkg0034Event) e;
				command = new UsaManifestListDownloadBCImpl();
				UsaBlKeyVO blKeyVO = new UsaBlKeyVO();
				blKeyVO.setBlKey(CountryCode.US + event.getBlNo());
				command.reactivateBl((BlKeyVO) blKeyVO, account);
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0152 : INIT <br>
	 * ESM_BKG_1033 : INIT <br>
	 * com_intg_cd_dtl Table 조회<br>
	 *
	 * @param String
	 *            comCode
	 * @return List<BkgComboVO>
	 * @exception EventException
	 */
	private EventResponse removeBl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0613Event")) {
				EsmBkg0613Event event = (EsmBkg0613Event) e;
				command = new UsaManifestListDownloadBCImpl();
				UsaManifestSearchDetailVO[] listVO = event.getUsaManifestSearchDetailVOS();

				int listSize = listVO.length;
				String deleteBl = "";
				for (int i = 0; i < listSize; i++) {
					if ("D".equals(listVO[i].getIbflag())) {
						deleteBl = listVO[i].getBlNo();
						break;
					}
				}

				UsaBlKeyVO blKeyVO = new UsaBlKeyVO();
				blKeyVO.setBlKey("US" + deleteBl);
				blKeyVO.setHisTpId("MIS");
				blKeyVO.setUsrId(account.getUsr_id());
				BlKeyVO b = (BlKeyVO) blKeyVO;
				command.removeBl(b, account);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00593").getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0034Event")) {
				EsmBkg0034Event event = (EsmBkg0034Event) e;
				command = new UsaManifestListDownloadBCImpl();
				UsaBlKeyVO blKeyVO = new UsaBlKeyVO();
				blKeyVO.setBlKey(CountryCode.US + event.getBlNo());
				command.removeBl((BlKeyVO) blKeyVO, account);
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0457 : MULTI01 <br>
	 * ESM_BKG_0034 : SEARCH02 <br>
	 * 세관 신고시 필요한 Manifest B/L 정보를 Active 상태로 업데이트 한다.<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDispositionCdList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0947Event")) {
				EsmBkg0947Event event = (EsmBkg0947Event) e;
				DispoCdListCondVO dispoCdListCondVO = event.getDispoCdListCondVO();
				command = new UsaManifestListDownloadBCImpl();
				List<DispoCdDetailVO> dispoCdDetailVOs = command.searchDispositionCdList(dispoCdListCondVO);
				// 결과 처리
				if (dispoCdDetailVOs == null) {
					// 결과값이 없을 경우 오류 리턴
					eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
				} else {
					eventResponse.setRsVoList(dispoCdDetailVOs);
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0034Event")) {
				EsmBkg0034Event event = (EsmBkg0034Event) e;
				DispoCdListCondVO dispoCdListCondVO = event.getDispoCdListCondVO();
				command = new UsaManifestListDownloadBCImpl();
				List<DispoCdDetailVO> list = command.searchDispositionCdList(dispoCdListCondVO);
				eventResponse.setRsVoList(list);
			}
			// dwkim, 0041, Ams Report page, Customs Result Code list search.
			else if (e.getEventName().equals("EsmBkg0041Event")) {
				UsaCustomsReportBC command3 = new UsaCustomsReportBCImpl();
				// 0. BC에 Disposition 코드조회 작업 요청 및 결과값 셋업.
				eventResponse.setRsVoList(command3.searchDispositionCdList());
				// Rcv Term cd, De Term Cd 등을 조회하기 위한 유틸 BC 선언.
				BookingUtil command2 = new BookingUtil();
				// ALL 옵션을 위한 기본 콤보 객체 선언.
				BkgComboVO combovo = new BkgComboVO();
				combovo.setDesc("");
				combovo.setName("");
				// 1. R- OUTBOUND RECEIVED
				List<BkgComboVO> list = command2.searchCombo("CD00764");
				list.add(0, combovo);
				eventResponse.setRsVoList(list);
				// 2. D- INBOUND DELIVERY
				list = command2.searchCombo("CD00765");
				list.add(0, combovo);
				eventResponse.setRsVoList(list);
				// 3. FILER
				list = command2.searchCombo("CD02268");
				list.add(0, combovo);
				eventResponse.setRsVoList(list);
				// 4. customs_result_code_grp
				list = command2.searchCombo("CD02571");
				list.add(0, combovo);
				eventResponse.setRsVoList(list);
				// 5.EQ Control OFC
				List<MdmLocationVO> list2 = command3.searchEQCtrlOfcCdList();
				eventResponse.setRsVoList(list2);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0947 : MULTI <br>
	 * Hold Notice를 송부를 위하여 Customs에서 받는 특정 Code를 등록 및 조회<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse correctBl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			EsmBkg0034Event event = (EsmBkg0034Event) e;
			command = new UsaManifestListDownloadBCImpl();
			UsaBlDetailContainerVO containerVO = new UsaBlDetailContainerVO();
			containerVO.setBlNo(event.getBlNo());
			containerVO.setBlCstms(event.getBlCstms());
			containerVO.setOldAiBlInfoVO(event.getOldAiBlInfoVOs()[0]);
			containerVO.setNewAiBlInfoVO(event.getUsaAiBlInfoVOs()[0]);
			containerVO.setOldBlCustVOs(event.getOldBlCustVOs());
			containerVO.setNewBlCustVOs(event.getUsaBlCustVOs());
			containerVO.setOldBlCustomerSecondVOs(event.getOldBlCustomerSecondVOs());
			containerVO.setNewBlCustomerSecondVOs(event.getUsaBlCustomerSecondVOs());
			command.correctBl(containerVO, account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0061 : REMOVE <br>
	 * ESM_BKG_0034 : SEARCH03 <br>
	 * ESM_BKG_0613 : REMOVE01 <br>
	 * ROCS(ROTTERDAM) 세관 Manifest 신고용 B/L 정보를 삭제한다.<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBkgReferenceNumberGeneration(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0034Event")) {
				BookingUtil util = new BookingUtil();
				BkgReferenceNoGenerationVO bkgReferenceNoGenerationVO = util.manageBkgReferenceNumberGeneration("USD", account.getOfc_cd(),
						account.getUsr_id());
				eventResponse.setETCData("dummy_bl_no", bkgReferenceNoGenerationVO.getUsdNo());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0428 <br>
	 * 미국 현재 날짜 가져오기<br>
	 *
	 * @return String
	 * @exception EventException
	 */
	private EventResponse searchMdmCust(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		MdmCustVO mdmCustVO = null;
		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0034Event")) {
				EsmBkg0034Event event = (EsmBkg0034Event) e;
				UsaBlCustVO usaBlCustVO = event.getUsaBlCustVO();
				mdmCustVO = command.searchMdmCust(usaBlCustVO.getCustCntCd(), usaBlCustVO.getCustSeq(), "N");
				if (mdmCustVO != null) {
					eventResponse.setETCData("cust_nm", mdmCustVO.getName());
					eventResponse.setETCData("cust_addr", mdmCustVO.getAddress());
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0540Event")) {
				EsmBkg0540Event event = (EsmBkg0540Event) e;
				mdmCustVO = command.searchMdmCust(event.getStrCustCntCd(), event.getStrCustSeq(), "Y");
				if (mdmCustVO != null) {
					eventResponse.setETCData("result", mdmCustVO.getName());
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1144Event")) {
				EsmBkg1144Event event = (EsmBkg1144Event) e;
				mdmCustVO = command.searchMdmCust(event.getStrCustCntCd(), event.getStrCustSeq(), "Y");
				if (mdmCustVO != null) {
					eventResponse.setETCData("result", mdmCustVO.getName());
				}
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0029 : SEARCH02<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse transmitManifest(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaCustomsTransmissionBC command = null;
		// EDIMgtBC ediCommand = new EDIMgtBCImpl();
		String flatFile = "";
		Map<String, String> etcData = new HashMap<String, String>();
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0613Event")) {
				// USA MI FLATFILE 생성 및 전송
				EsmBkg0613Event event = (EsmBkg0613Event) e;
				command = new UsaCustomsTransmissionBCImpl();
				UsaManifestSearchDetailVO[] vos = event.getUsaManifestSearchDetailVOS();
				if (vos.length > 0) {
					vos[0].setUsrId(account.getUsr_id());
					vos[0].setOfcCd(account.getOfc_cd());
				}
				// BackEnd
				String key = command.startBackEndJob(account, vos, "ESM_BKG_0613");
				eventResponse.setETCData("KEY", key);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0543Event")) {
				// USA Departure HI FLATFILE 생성 및 전송
				EsmBkg0543Event event = (EsmBkg0543Event) e;
				command = new UsaCustomsTransmissionBCImpl();
				UsaManifestListCondForEdiVO vo = event.getUsaManifestListCondForEdiVO();
				vo.setUsrId(account.getUsr_id());
				vo.setOfcCd(account.getOfc_cd());
				UsaManifestListCondForEdiVO[] list = { vo };
				flatFile = command.transmitManifest(list);
				eventResponse.setETCData("flatFile", flatFile);
				eventResponse.setETCData(etcData);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0514Event")) {
				// USA Arrival HI FLATFILE 생성 및 전송
				EsmBkg0514Event event = (EsmBkg0514Event) e;
				command = new UsaCustomsTransmissionBCImpl();
				UsaManifestListCondForEdiVO vo = event.getUsaManifestListCondForEdiVO();
				vo.setUsrId(account.getUsr_id());
				vo.setOfcCd(account.getOfc_cd());
				UsaManifestListCondForEdiVO[] list = { vo };
				flatFile = command.transmitManifest(list);
				eventResponse.setETCData("flatFile", flatFile);
				eventResponse.setETCData(etcData);
				// 0533 Transmit처리. USA HI FLAT FILE 생성 및 전송
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0533Event")) {
				// Event 객체 선언.
				EsmBkg0533Event event = (EsmBkg0533Event) e;
				UsaInbondTransmissionBC command2 = new UsaInbondTransmissionBCImpl();
				// Event 객체로 부터 Transmit 대상 아이템을 가져옴.
				UsaMibTransmitVO[] vos = event.getUsaMibTransmitVOS();
				// 작업을 수행한 User 정보를 가져옴.
				vos[0].setUsrId(account.getUsr_id());
				vos[0].setOfcCd(account.getOfc_cd());
				// BackEnd Job Calling.
				if (vos != null) {
					// BackEnd
					String key = command2.startBackEndJob(account.getUsr_id(), vos, "ESM_BKG_0533");
					eventResponse.setETCData("KEY", key);
				}
				// 0408 Transmit처리. USA AI FLAT FILE 생성 및 전송
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0408Event")) {
				// Event 객체 선언.
				EsmBkg0408Event event = (EsmBkg0408Event) e;
				command = new UsaCustomsTransmissionBCImpl();
				// 하단 그리드의 vo.
				UsaManifestSearchDetailVO vo = null;
				// 상단 그리드로 부터 조회한 BL리스트.
				List<UsaInbondManifestDetailListVO> lvos = new ArrayList<UsaInbondManifestDetailListVO>();
				// Event 객체로 부터 Transmit 대상 아이템을 가져옴.
				// 하단 그리드 리스트.
				UsaInbondManifestDetailListVO[] detailVOs = event.getUsaInbondManifestDetailListVOS();
				// 상단 그리드 리스트.
				UsaInbondManifestListVO[] summaryVOs = event.getUsaInbondManifestListVOS();
				// BC호출을 위해 매개VO를 형변환하기 위한 사이즈 셋업.
				int len = 0;
				if (detailVOs != null) {
					len += detailVOs.length;
				}
				// 상단그리드로 부터 전송 요청이 들어온 경우, 해당 BL 리스트를 조회하여 lvos 객체에 값을 셋업한다.
				if (summaryVOs != null) {
					UsaInbondManifestListCondVO condvo = new UsaInbondManifestListCondVO();
					condvo.setPageNo("ESM_BKG_0408");
					List<UsaContainerVO> usaContainerVOs = null;
					UsaContainerVO usaContainerVO = null;
					// 상단그리드로 부터 하단그리드를 조회하는 BC 호출하 기 위한 BC초기화.
					UsaInbondTransmissionBC command2 = new UsaInbondTransmissionBCImpl();
					for (int i = 0; i < summaryVOs.length; i++) {
						// setTrspAuthDt 로 해당 BC에서 Partial check 등 을 생략한 체 순수한
						// bl list 만 조회하게 됨.
						summaryVOs[i].setTrspAuthDt("to query bl list for AI transmit");
						condvo.setUsaInbondManifestListVO(summaryVOs[i]);
						// BC에 작업 요청
						// 요약조회, Inbond B/L, Local B/L 조회 수행.
						usaContainerVOs = (List<UsaContainerVO>) (Object) (command2.searchInbondManifestList((InbondListCondVO) condvo));
						// 결과값이 있을 경우 lvos 셋업.
						if (usaContainerVOs.size() > 0) {
							usaContainerVO = usaContainerVOs.get(0);
							// getInbondBlDetailListVOs() 값이 존재하는 경우 : 0408화면의
							// Inbond Bl list.
							if (usaContainerVO.getInbondBlDetailListVOs() != null) {
								len += usaContainerVO.getInbondBlDetailListVOs().size();
								lvos.addAll(usaContainerVO.getInbondBlDetailListVOs());
							}
						}
					}
				}
				// Transmit 을 실행할 BC에 전달될 vo 변수.
				UsaManifestSearchDetailVO[] vos = new UsaManifestSearchDetailVO[len];
				int i = 0;
				if (detailVOs != null) {
					for (i = 0; i < detailVOs.length; i++) {
						vo = new UsaManifestSearchDetailVO();
						vo.setBlNo(detailVOs[i].getBlNo());
						vo.setTransmitCd("AI");
						vo.setVvd(detailVOs[i].getVvd());
						vo.setUsrId(account.getUsr_id());
						vo.setOfcCd(account.getOfc_cd());
						vo.setPod(detailVOs[i].getPodCd());
						vo.setPol(detailVOs[i].getPolCd());
						vos[i] = vo;
					}
				}
				// 상단 그리드에 의해 조회된 BL 리스트를 vos 에 담는다.
				if (lvos != null) {
					for (int j = 0; j < lvos.size(); j++) {
						// 62, 63 인 경우, L.USA코드가 없으면 오류를 발생한다.
						if (lvos.get(j).getUsaLstLocCd().equals("")
								&& (lvos.get(j).getIbdTrspTpCd().equals("62") || lvos.get(j).getIbdTrspTpCd().equals("63"))) {
							throw new EventException(new ErrorHandler("BKG00229").getMessage()); // Missing
																									// Last
							// USA
						}
						vo = new UsaManifestSearchDetailVO();
						vo.setBlNo(lvos.get(j).getBlNo());
						vo.setTransmitCd("AI");
						vo.setVvd(lvos.get(j).getVvd());
						vo.setUsrId(account.getUsr_id());
						vo.setOfcCd(account.getOfc_cd());
						vo.setPod(lvos.get(j).getPodCd());
						vo.setPol(lvos.get(j).getPolCd());
						vos[i] = vo;
						i++;
					}
				}
				if (vos != null) {
					// BackEnd
					String key = command.startBackEndJob(account, vos, "ESM_BKG_0408");
					eventResponse.setETCData("KEY", key);
				}
				// USA Arrival HI FLAT FILE 생성 및 전송- 0233용으로 0514와는 약간 다르다.
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0233Event")) {
				EsmBkg0233Event event = (EsmBkg0233Event) e;
				command = new UsaCustomsTransmissionBCImpl();
				// 이벤트로 부터 매개VO 배열을 가져온다.
				UsaEDADetailVO[] usaEDADetailVOs = event.getUsaEDADetailVOs();
				// BC호출을 위해 매개VO를 형변환 한다.
				UsaManifestListCondForEdiVO tmpVo = new UsaManifestListCondForEdiVO();
				UsaManifestListCondForEdiVO[] list = null;
				if (usaEDADetailVOs != null) {
					// 실제 매개변수로 전달할 VO를 선언한다.
					list = new UsaManifestListCondForEdiVO[usaEDADetailVOs.length];
					for (int i = 0; i < usaEDADetailVOs.length; i++) {
						// 실제 매개변수로 전달할 VO에 값을 전달하고, 이를 배열에 담는다.
						tmpVo = new UsaManifestListCondForEdiVO();
						tmpVo.setPolCd("");
						tmpVo.setVvd(usaEDADetailVOs[i].getVvd());
						tmpVo.setPodCd(usaEDADetailVOs[i].getPod());
						tmpVo.setBlCount(usaEDADetailVOs[i].getBlCount());
						tmpVo.setEta(usaEDADetailVOs[i].getEta());
						tmpVo.setEtaTime(usaEDADetailVOs[i].getEdaOnMi());
						tmpVo.setUsrId(account.getUsr_id());
						tmpVo.setOfcCd(account.getOfc_cd());
						tmpVo.setPageNo("ESM_BKG_0233");
						list[i] = tmpVo;
					}
					// BC 호출. flatFile을 리턴받는다.
					flatFile = command.transmitManifest(list);
					// 결과값을 EtcData로 리턴함.
					eventResponse.setETCData("flatFile", flatFile);
					eventResponse.setETCData(etcData);
				} else {
					eventResponse.setUserMessage(new ErrorHandler("BKG00099").getUserMessage());
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0034Event")) {
				// USA EDI FLAT FILE 생성 및 재전송
				EsmBkg0034Event event = (EsmBkg0034Event) e;
				command = new UsaCustomsTransmissionBCImpl();
				UsaManifestSearchDetailVO[] vos = event.getUsaManifestSearchDetailVOS();
				if (vos.length > 0) {
					vos[0].setUsrId(account.getUsr_id());
					vos[0].setOfcCd(account.getOfc_cd());
				}
				flatFile = command.transmitManifest(vos);
				eventResponse.setETCData("flatFile", flatFile);
				eventResponse.setETCData(etcData);
				// 성공메시지 세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00218").getUserMessage());
				commit();
				begin();
				this.transmitCdlEdi(vos[0].getBlNo());
			}

			commit();
		} catch (EventException ex) {
			log.error("EventException : " + ex.toString(), ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("Exception : " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * ESM_BKG_0730 : MULTI01 <br>
	 * ESM_BKG_0991 : MULTI <br>
	 * 세관에 적하목록 신고를 EDI를 통해 전송한다.<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitManifestIsf(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaCustomsTransmissionBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			EsmBkg0034Event event = (EsmBkg0034Event) e;
			command = new UsaCustomsTransmissionBCImpl();
			command.transmitManifestIsf(event.getUsaManifestSearchDetailVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 한국세관 Inbound Empty BL MSN 추가
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchUiSetUpInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg1008Event")) {
				EsmBkg1008Event event = (EsmBkg1008Event) e;
				command = new UsaManifestListDownloadBCImpl();
				UserAuthListCondVO cond = (UserAuthListCondVO) event.getAuthSetupListCondVO();
				String userId = cond.getChUsrId();
				List<UserInfoVO> list2 = command.searchUserAuthority(userId);
				int listSize = list2.size();
				if (listSize > 0) {
					UserInfoVO vo = (UserInfoVO) list2.get(0);
					eventResponse.setETCData("search_usr_nm", vo.getUsrNm());
					eventResponse.setETCData("search_ofc_cd", vo.getOfcCd());
					eventResponse.setETCData("search_auth_count", vo.getAuthCount());
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0034Event")) {
				// WGT 단위콤보
				eventResponse.setRsVoList(searchComCodeCombo("CD00775"));
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1008 : MULTI<BR>
	 * User Auth List 정보수정<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainerManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaManifestListDownloadBC command = null;
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0036Event")) {
				EsmBkg0036Event event = (EsmBkg0036Event) e;
				command = new UsaManifestListDownloadBCImpl();
				UsaContainerManifestDetailVO detailVO = (UsaContainerManifestDetailVO) command.searchContainerManifest(event
						.getContainerManifestCondVO());

				eventResponse.setRsVoList(detailVO.getUsaContainerListVOs());
				eventResponse.setRsVoList(detailVO.getUsaCntrManifestListVOs());
				eventResponse.setRsVoList(detailVO.getUsaCntrManifestInfoVOs());
				if (detailVO.getUsaCntrManifestInfoVOs().size() > 0) {
					eventResponse.setETCData(detailVO.getUsaCntrManifestInfoVOs().get(0).getColumnValues());
				}
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0304 : SEARCH <br>
	 * ESM_BKG_0470 : SEARCH <br>
	 * ESM_BKG_0493 : SEARCH <br>
	 * ESM_BKG_0494 : SEARCH <br>
	 * ESM_BKG_0015 : SEARCH <br>
	 * ESM_BKG_0359 : INIT <br>
	 * ESM_BKG_1104 : SEARCH <br>
	 * ESM_BKG_1171 : SEARCH <br>
	 * 세관에 신고할 대상 VesselArrival 정보 데이터를 조회한다.<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyContainerManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0036Event")) { // 미국
				EsmBkg0036Event event = (EsmBkg0036Event) e;
				command = new UsaManifestListDownloadBCImpl();
				command.modifyContainerManifest(event.getContainerManifestListVOs(), account);
				// 성공메시지세팅
				// eventResponse.setUserMessage(new
				// ErrorHandler("BKG00166").getUserMessage());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0351 : MULTI <br>
	 * 데이터 확인을 위한 BL List에서 B/L Seq를 수정한다.<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	/*
	 * private EventResponse manageHSCode(Event e) throws EventException { //
	 * v2.0 확인 후 삭제요 UsaManifestListDownloadBC command = null;
	 * GeneralEventResponse eventResponse = new GeneralEventResponse(); try {
	 * begin(); if (e.getEventName().equalsIgnoreCase("EsmBkg0745Event")) {
	 * EsmBkg0745Event event = (EsmBkg0745Event) e; command = new
	 * BrcsManifestDownloadBCImpl();
	 * command.manageHSCode(event.getBrHsCdDetailVOs(), account);
	 * eventResponse.setUserMessage((String) new ErrorHandler( "BKG00166", new
	 * String[] {}).getUserMessage()); } commit(); } catch (EventException ex) {
	 * rollback(); throw ex; } catch (Exception ex) { rollback(); throw new
	 * EventException(new ErrorHandler("BKG06087").getMessage(), ex); } return
	 * eventResponse; }
	 */

	/**
	 * ESM_BKG_1098 : SEARCH <br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		UsaManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			command = new UsaManifestListDownloadBCImpl();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0037Event")) {
				EsmBkg0037Event event = (EsmBkg0037Event) e;
				List<ContainerListRsltVO> list = command.searchContainerList(event.getContainerListCondVO());
				if (event.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse.setRsVoList(list);
				} else if (event.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					if (list != null && list.size() > 0) {
						UsaCntrListRsltVO vo = (UsaCntrListRsltVO) list.get(0);
						eventResponse.setETCData("cntr_no", vo.getCntrNo());
						eventResponse.setETCData("cntr_tpsz_cd", vo.getCntrTpszCd());
					}
				}
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0037 : MULTI<BR>
	 * Container 정보를 저장한다.<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageContainerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			EsmBkg0037Event event = (EsmBkg0037Event) e;
			command = new UsaManifestListDownloadBCImpl();
			command.manageContainerList(event.getContainerListRsltVOs(), account);
			// 성공메시지세팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0305 : SEARCH<BR>
	 * 세관에 등록된 보세장치장 코드를 조회하는 화면<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchManifestList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		UsaManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		log.info("=== EsmBkg0210Event searchManifestList ===");
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0210Event")) {
				log.info("=== EsmBkg0210Event Start ===");
				EsmBkg0210Event event = (EsmBkg0210Event) e;
				// Canada와 US 동일한 화면 사용
				if (event.getCustoms().endsWith("CA")) {
					log.info("=== EsmBkg0210Event CA Start ===");
					CndManifestListDownloadBC commandCnd = new CndManifestListDownloadBCImpl();
					eventResponse.setRsVoList(commandCnd.searchManifestList(event.getManifestListCondVO(),account));
					log.info("=== EsmBkg0210Event CA End ===");
				} else {
					command = new UsaManifestListDownloadBCImpl();
					List<ManifestListDetailVO> list = command.searchManifestList(event.getManifestListCondVO(),account);
					UsaManifestListContainerVO containerVO = (UsaManifestListContainerVO) list.get(0);
					if (containerVO.getUsaManifestListDownloadVO() != null) {
						List<UsaDownloadSummaryVO> usaManifestListDownloadVOs = containerVO.getUsaManifestListDownloadVO();

						if (usaManifestListDownloadVOs.size() > 0) {
							eventResponse.setRsVoList(usaManifestListDownloadVOs);
						} else {
							// 결과값이 없을 경우 메세지 리턴
							eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
						}
					}
					if (containerVO.getUsaManifestListDownloadDetailVO() != null) {
						List<UsaManifestListDetailVO> usaManifestListDownloadDetailVOs = containerVO.getUsaManifestListDownloadDetailVO();
						eventResponse.setRsVoList(usaManifestListDownloadDetailVOs);
					}
					if (containerVO.getUsaManifestListDownloadCntrVO() != null) {
						List<UsaManifestListDownloadCntrVO> usaManifestListDownloadCntrVOs = containerVO.getUsaManifestListDownloadCntrVO();
						eventResponse.setRsVoList(usaManifestListDownloadCntrVOs);
					}
					if (containerVO.getUsaBkgCmVO() != null) {
						List<UsaBkgCmVO> usaBkgCmVOs = containerVO.getUsaBkgCmVO();
						eventResponse.setRsVoList(usaBkgCmVOs);
					}
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0613Event")) {
				EsmBkg0613Event event = (EsmBkg0613Event) e;
				command = new UsaManifestListDownloadBCImpl();
				List<ManifestListDetailVO> list = command.searchMiManifestList(event.getManifestListCondVO());
				UsaManifestListContainerVO containerVO = (UsaManifestListContainerVO) list.get(0);
				String searchMtd = ((UsaManifestSearchCondVO) event.getManifestListCondVO()).getSearchMtd();
				// 요약조회일 경우,
				if ("Summary".equals(searchMtd) && containerVO.getUsaManifestSummaryVO() != null) {
					eventResponse.setRsVoList(containerVO.getUsaManifestSummaryVO());
				}
				// 상세조회일 경우,
				if (!"Summary".equals(searchMtd) && containerVO.getUsaManifestSearchDetailVO() != null) {
					eventResponse.setRsVoList(containerVO.getUsaManifestSearchDetailVO());
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0543Event")) {
				EsmBkg0543Event event = (EsmBkg0543Event) e;
				UsaCustomsTransmissionBC command2 = new UsaCustomsTransmissionBCImpl();
				ManifestListForEdiVO containerVo = command2.searchManifestListForEdi((ManifestListCondForEdiVO) event
						.getUsaManifestListCondForEdiVO());
				UsaManifestListCondForEdiVO retVO = containerVo.getUsaManifestListCondForEdiVO();
				List<UsaManifestListCondForEdiVO> list = new ArrayList<UsaManifestListCondForEdiVO>();
				list.add(retVO);
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0514Event")) {
				EsmBkg0514Event event = (EsmBkg0514Event) e;
				UsaCustomsTransmissionBC command2 = new UsaCustomsTransmissionBCImpl();
				ManifestListForEdiVO containerVo = command2.searchManifestListForEdi((ManifestListCondForEdiVO) event
						.getUsaManifestListCondForEdiVO());
				UsaManifestListCondForEdiVO retVO = containerVo.getUsaManifestListCondForEdiVO();
				List<UsaManifestListCondForEdiVO> list = new ArrayList<UsaManifestListCondForEdiVO>();
				list.add(retVO);
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0233Event")) {
				EsmBkg0233Event event = (EsmBkg0233Event) e;
				UsaCustomsTransmissionBC command2 = new UsaCustomsTransmissionBCImpl();
				ManifestListForEdiVO containerVo = command2.searchManifestListForEdi((ManifestListCondForEdiVO) event
						.getUsaManifestListCondForEdiVO());
				List<UsaEDADetailVO> list = containerVo.getUsaEDADetailVOs();
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0533Event")) {
				EsmBkg0533Event event = (EsmBkg0533Event) e;
				List<UsaContainerVO> usaContainerVOs = null;
				UsaContainerVO usaContainerVO = null;
				UsaInbondTransmissionBC command2 = new UsaInbondTransmissionBCImpl();
				// BC에 작업 요청
				// Container별/BL별 조회를 수행.
				usaContainerVOs = (List<UsaContainerVO>) (Object) (command2.searchInbondManifestList((InbondListCondVO) event.getUsaInbondManifestListCondVO()));
				// 결과값이 있을 경우 eventResponse 셋업.
				if (usaContainerVOs.size() > 0) {
					usaContainerVO = usaContainerVOs.get(0);
					List<UsaInbondManifestListVO> usaInbondManifestDetailVOs = usaContainerVO.getUsaInbondManifestListVOs();
					// 리턴값을 셋팅.
					eventResponse.setRsVoList(usaInbondManifestDetailVOs);
				} else {
					// 결과값이 없을 경우 오류 리턴
					eventResponse.setUserMessage(new ErrorHandler("BKG00123").getUserMessage());
				}
				// eventResponse.setETCData(etcData);
				// 0408 화면 조회.
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0408Event")) {
				EsmBkg0408Event event = (EsmBkg0408Event) e;
				List<UsaContainerVO> usaContainerVOs = null;
				UsaContainerVO usaContainerVO = null;
				UsaInbondTransmissionBC command2 = new UsaInbondTransmissionBCImpl();
				// BC에 작업 요청
				// 요약조회, Inbond B/L, Local B/L 조회 수행.
				usaContainerVOs = (List<UsaContainerVO>) (Object) (command2.searchInbondManifestList((InbondListCondVO) event.getUsaInbondManifestListCondVO()));
				// 결과값이 있을 경우 eventResponse 셋업.
				if (usaContainerVOs.size() > 0) {
					usaContainerVO = usaContainerVOs.get(0);
					// 리턴값을 셋팅.
					// getUsaInbondManifestListVOs() 값이 존재하는 경우 : 0533 혹은 0408
					// 상단 시트
					// 조회 결과.
					if (usaContainerVO.getUsaInbondManifestListVOs() != null) {
						eventResponse.setRsVoList(usaContainerVO.getUsaInbondManifestListVOs());
					}
					// getInbondBlDetailListVOs() 값이 존재하는 경우 : 0408화면의 Inbond Bl
					// list.
					if (usaContainerVO.getInbondBlDetailListVOs() != null) {
						eventResponse.setRsVoList(usaContainerVO.getInbondBlDetailListVOs());
					}
					// getLocalBlDetailListVOs() 값이 존재하는 경우: 0408화면의 Local Bl
					// list.
					if (usaContainerVO.getLocalBlDetailListVOs() != null) {
						eventResponse.setRsVoList(usaContainerVO.getLocalBlDetailListVOs());
					}
				} else {
					// 결과값이 없을 경우 오류 리턴
					eventResponse.setUserMessage(new ErrorHandler("BKG00123").getUserMessage());
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0540Event")) {
				EsmBkg0540Event event = (EsmBkg0540Event) e;
				UsaInbondTransmissionBC command2 = new UsaInbondTransmissionBCImpl();
				// BC에 작업 요청
				List<InbondManifestDetailVO> inbondManifestDetailVOs = command2.searchInbondClearanceList(event.getInbondManifestListCondVO());
				// 결과 처리
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					if (inbondManifestDetailVOs == null) {
						// 결과값이 없을 경우 메세지 리턴
						eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
					} else {
						eventResponse.setRsVoList(inbondManifestDetailVOs);
					}
				} else {
					if (inbondManifestDetailVOs == null) {
						eventResponse.setETCData("result", "nodata");
					} else {
						ClearanceTypeDetailVO detailVO = (ClearanceTypeDetailVO) inbondManifestDetailVOs.get(0);
						eventResponse.setETCData("result", detailVO.getCreOfcCd());
					}
				}
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0462 : SEARCH <br>
	 * 일본 세관에 신고할 대상 Manifest 정보(Download 데이터) 를 조회한다.<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0210Event")) {
				EsmBkg0210Event event = (EsmBkg0210Event) e;
				String key = "";
				if (event.getManifestListDetailVOs()[0].getPgmNo() == null || "".equals(event.getManifestListDetailVOs()[0].getPgmNo()) ) {
					event.getManifestListDetailVOs()[0].setPgmNo("ESM_BKG_0210");
				}
				if (event.getCustoms().endsWith("CA")) {
					CndManifestListDownloadBC commandCnd = new CndManifestListDownloadBCImpl();
					key = commandCnd.manageManifest(event.getManifestListDetailVOs(), account);
				} else {
					command = new UsaManifestListDownloadBCImpl();
					key = command.manageManifest(event.getManifestListDetailVOs(), account);
				}
				eventResponse.setETCData("KEY", key);

			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0533Event")) {
				EsmBkg0533Event event = (EsmBkg0533Event) e;
				// BCImpl 객체 생성.
				command = new UsaManifestListDownloadBCImpl();
				// BC 호출.
				command.modifyInbondData(event.getUsaInbondManifestDetailVOS(), account);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());

			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0408Event")) {
				EsmBkg0408Event event = (EsmBkg0408Event) e;
				// BCImpl 객체 생성.
				command = new UsaManifestListDownloadBCImpl();
				// Event에서 파라미터 VO 추출.
				UsaInbondManifestListVO[] listVos = event.getUsaInbondManifestListVOS();
				UsaInbondManifestDetailListVO[] detailVOs = event.getUsaInbondManifestDetailListVOS();
				// InbondVO를 상속받은 UsaInbondContainerVO에 셋업후 파라미터로 BC 실행.
				UsaInbondContainerVO[] inbondVO = new UsaInbondContainerVO[1];
				inbondVO[0] = new UsaInbondContainerVO();
				inbondVO[0].setUsaInbondManifestListVOs(listVos);
				inbondVO[0].setUsaInbondManifestDetailListVOs(detailVOs);
				// PageNo 셋업.
				inbondVO[0].setPageNo("ESM_BKG_0408");
				/*
				 * 2009/10/23 책임테이블 문제로 inbondTransmissionBC에서 manifestDownBC로
				 * 이관.
				 */
				// BC 호출.
				command.modifyInbondData(inbondVO, account);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00166").getMessage());

			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0540Event")) {
				EsmBkg0540Event event = (EsmBkg0540Event) e;
				UsaInbondTransmissionBC command2 = new UsaInbondTransmissionBCImpl();
				command2.modifyManifestList(event.getInbondManifestDetailVOs(), account);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			}
			commit();

		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0061 : MULTI <br>
	 * ROCS(ROTTERDAM) 세관에 신고할 대상 Manifest List를 전송하기 전에 데이터를 확인했다는 의미로 Confirm
	 * Indicator를 업데이트 한다.<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse backEndJobResult(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String sKey = "";
		if (e.getEventName().equalsIgnoreCase("EsmBkg0210Event")) {
			EsmBkg0210Event event = (EsmBkg0210Event) e;
			sKey = event.getKey();
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1023Event")) {
			EsmBkg1023Event event = (EsmBkg1023Event) e;
			sKey = event.getKey();
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0613Event")) {
			EsmBkg0613Event event = (EsmBkg0613Event) e;
			sKey = event.getKey();
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0408Event")) {
			EsmBkg0408Event event = (EsmBkg0408Event) e;
			sKey = event.getKey();
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0533Event")) {
			EsmBkg0533Event event = (EsmBkg0533Event) e;
			sKey = event.getKey();
		}
		String strResult = "";
		try {
			BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(sKey);
			DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();

			while (rowSet.next()) {
				if ("2".equals(rowSet.getString("JB_STS_FLG"))) {
					// BackEndJob 처리중
					strResult = "PROCESSING";
				} else if ("3".equals(rowSet.getString("JB_STS_FLG"))) {
					// 성공메시지세팅
					// Data Saved Successfully!!
					eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());

					strResult = "SUCCESS";
				} else if ("4".equals(rowSet.getString("JB_STS_FLG"))) {
					// 에러메시지세팅
					if (!"".equals(rowSet.getString("JB_USR_ERR_MSG"))) {
						eventResponse.setUserMessage(rowSet.getString("JB_USR_ERR_MSG"));

						throw new EventException(rowSet.getString("JB_USR_ERR_MSG"));

					} else {
						eventResponse.setUserMessage(new ErrorHandler("BKG00167").getUserMessage());
					}

					strResult = "FAIL";
				}
			}
			eventResponse.setETCData("jb_sts_flg", strResult);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0210 : MULTI<BR>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteManifest(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0210Event")) {
				// ENS EDI FLAT FILE 생성 및 전송
				EsmBkg0210Event event = (EsmBkg0210Event) e;
				if (event.getCustoms().endsWith("CA")) {
					CndManifestListDownloadBC commandCnd = new CndManifestListDownloadBCImpl();
					commandCnd.deleteManifest(event.getManifestListDetailVOs());
					commandCnd.deleteManifestBl(event.getManifestListDetailVOs());
					eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
				}else{
					command = new UsaManifestListDownloadBCImpl();
					command.deleteManifest(event.getManifestListDetailVOs());
					command.deleteManifestBl(event.getManifestListDetailVOs());
					eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
				}
				eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			}
			commit();
		} catch (EventException ex) {
			log.error("EventException : " + ex.toString(), ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("Exception : " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0340 : SEARCH <br>
	 * ESM_BKG_0340 : SEARCH03 <br>
	 * ESM_BKG_0341 : SEARCH <br>
	 * ESM_BKG_0341 : SEARCH03 <br>
	 *
	 * 하선신고서(Discharging Cargo Declaration) 정보를 조회<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkHouseBlDataList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			EsmBkg0393Event event = (EsmBkg0393Event) e;
			if (event.getCustoms().startsWith(CountryCode.US)) {
				command = new UsaManifestListDownloadBCImpl();
				List<HouseBlDetailVO> list = command.checkHouseBlDataList(event.getHouseBlCondVO());
				if (list.size() > 1) {
					UsaHblCheckDetailVO detailVO = (UsaHblCheckDetailVO) list.get(0);
					list.remove(0);
					eventResponse.setETCData(detailVO.getColumnValues());
				}
				eventResponse.setRsVoList(list);
			} else if (event.getCustoms().startsWith(CountryCode.CA)) {
				CndManifestListDownloadBC commandCnd = new CndManifestListDownloadBCImpl();
				List<HouseBlDetailVO> list = commandCnd.checkHouseBlDataList(event.getHouseBlCondVO());
				if (list.size() > 1) {
					HusBlInpChkVO detailVO = (HusBlInpChkVO) list.get(0);
					list.remove(0);
					eventResponse.setETCData(detailVO.getColumnValues());
				}
				eventResponse.setRsVoList(list);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0031 : COMMAND02 <br>
	 * ESM_BKG_0505 : COMMAND02 <br>
	 * ESM_BKG_0217 : SEARCH01 <br>
	 *
	 * 컨테이너 TYPE 조회<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUserAuthYn(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaManifestListDownloadBC command = null;
		String usrId = account.getUsr_id();
		command = new UsaManifestListDownloadBCImpl();
		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0613Event")) {
				String retVal = command.searchUserAuthYn(usrId, "ESM_BKG_0613");
				String retVal2 = command.searchUserAuthMiMultiYn(usrId);
				eventResponse.setETCData("user_auth_str", retVal);
				eventResponse.setETCData("user_auth_mi_multi_str", retVal2);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0507Event")) {
				String retVal = command.searchUserAuthYn(usrId, "ESM_BKG_0507");
				eventResponse.setETCData("user_auth_str", retVal);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0034 : MULTI <br>
	 * bl 수정<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitOfm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaCustomsTransmissionBC command = null;
		// EDIMgtBC ediCommand = new EDIMgtBCImpl();
		String flatFile = "";
		Map<String, String> etcData = new HashMap<String, String>();
		try {
			begin();
			// 이벤트별 Impl생성 USA EDI FLAT FILE 생성 및 전송
			EsmBkg0613Event event = (EsmBkg0613Event) e;
			command = new UsaCustomsTransmissionBCImpl();
			UsaManifestSearchDetailVO[] vos = event.getUsaManifestSearchDetailVOS();
			if (vos.length > 0) {
				vos[0].setUsrId(account.getUsr_id());
				vos[0].setOfcCd(account.getOfc_cd());
			}
			flatFile = command.transmitOfm(vos);
			eventResponse.setETCData("flatFile", flatFile);
			eventResponse.setETCData(etcData);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0334 : SEARCH<BR>
	 * Discharging CY Code List 조회<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVessel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		UsaManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0613Event")) {
				EsmBkg0613Event event = (EsmBkg0613Event) e;
				command = new UsaManifestListDownloadBCImpl();
				List<VesselVO> list = command.searchVessel(event.getVesselCondVO());
				if (list.size() > 0) {
					UsaVesselVO vo = (UsaVesselVO) list.get(0);
					eventResponse.setETCData("ACT_VVD", vo.getVvd());
				} else {
					eventResponse.setETCData("ACT_VVD", "");
				}
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0249 : SEARCH<BR>
	 * ESM_BKG_0551 : SEARCH<BR>
	 * 세관 신고용 VVD 목록 조회<br>
	 *
	 * @param cstmsVvdInfoCondVO
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSetupList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		UsaManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// 이벤트별 Impl 생성
		try {
			EsmBkg0926Event event = (EsmBkg0926Event) e;
			command = new UsaManifestListDownloadBCImpl();
			if (event.getSetupListCondVO() != null) {
				List<SetupListDetailVO> list = command.searchSetupList(event.getSetupListCondVO());
				eventResponse.setRsVoList(list);
			} else {
				if ("country".equals(event.getComboName())) {
					// Country Code List
					List<MdmCountryVO> countryCode = command.searchCountryCodeList();
					eventResponse.setRsVoList(countryCode);
				} else {
					// Port Code List
					MdmPortVO portVo = new MdmPortVO();
					portVo.setPortCd("ALL");
					portVo.setPortNm("ALL");
					List<MdmPortVO> portCode = command.searchPortCodeList(event.getCntCd());
					portCode.add(0, portVo);
					eventResponse.setRsVoList(portCode);
				}
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0926 : MULTI,MODIFY <br>
	 * 저장 이벤트 처리<br>
	 * UsaManifestListDownload의 event에 대한 저장 이벤트 처리<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifySetupList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		UsaManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// 이벤트별 Impl 생성
			EsmBkg0926Event event = (EsmBkg0926Event) e;
			command = new UsaManifestListDownloadBCImpl();
			begin();
			if (event.getSetupListModVO() != null) {
				command.modifySetupList(event.getSetupListModVO(), account);
				eventResponse.setETCData("mode", "U");
			} else if (event.getSetupKeyVO() != null) {
				command.modifySetupStatus(event.getSetupKeyVO(), account);
				eventResponse.setETCData("mode", "D");
			}
			// 성공메시지세팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0029 : SEARCH<BR>
	 * ESM_BKG_0034 : SEARCH01 <br>
	 * ESM_BKG_0045 : SEARCH <br>
	 * 세관 관리 항목 setup 정보 조회<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDispositionCdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			EsmBkg0947Event event = (EsmBkg0947Event) e;
			command = new UsaManifestListDownloadBCImpl();
			command.manageDispositionCdList(event.getDispoCdDetailVOs(), account);
			// 성공메시지세팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0518 : SEARCH <br>
	 * Hold Notice를 송부를 위하여 Customs에서 받는 특정 Code를 등록 및 조회<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAuthSetupList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			EsmBkg1008Event event = (EsmBkg1008Event) e;
			command = new UsaManifestListDownloadBCImpl();
			List<AuthSetupListVO> list = command.searchAuthSetupList(event.getAuthSetupListCondVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1008 : SEARCH01<BR>
	 * ESM_BKG_0013 : INIT<BR>
	 * ESM_BKG_0029 : INIT<BR>
	 * ESM_BKG_0034 : COMMAND01<BR>
	 * User name, office 조회<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAuthSetupList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			EsmBkg1008Event event = (EsmBkg1008Event) e;
			command = new UsaManifestListDownloadBCImpl();
			UserAuthListModiVO[] vos = (UserAuthListModiVO[]) event.getAuthSetupListVOS();
			for (int i = 0; i < vos.length; i++) {
				vos[i].setUpdUsrId(account.getUsr_id());
			}
			command.manageAuthSetupList(event.getAuthSetupListVOS());
			// 성공메시지세팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1095 : MULTI<BR>
	 * User Auth List 정보수정<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOrgPartyList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		UsaManifestListDownloadBC command = null;
		try {
			command = new UsaManifestListDownloadBCImpl();
			EsmBkg1144Event event = (EsmBkg1144Event) e;
			if (event.getOrgPartyVO() != null) {
				List<OrgPartyVO> list = command.searchOrgPartyList(event.getOrgPartyVO());
				eventResponse.setRsVoList(list);
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1144 : save <br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0540Event")) {
				EsmBkg0540Event event = (EsmBkg0540Event) e;
				BookingUtil bkgUtil = new BookingUtil();
				String locNm = bkgUtil.searchMdmLocName(event.getStrLocCd());
				if (!"".equals(locNm)) {
					eventResponse.setETCData("result", locNm);
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1144Event")) {
				EsmBkg1144Event event = (EsmBkg1144Event) e;
				BookingUtil bkgUtil = new BookingUtil();
				String locNm = bkgUtil.searchMdmLocName(event.getStrLocCd());

				if (!"".equals(locNm)) {
					eventResponse.setETCData("result", locNm);
				}
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1046 : SEARCH, SEARCH01 <br>
	 * ESM_BKG_1070 : SEARCH <br>
	 * Customer, Container 등의 BL 정보를 조회<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageOrgPartyInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		UsaManifestListDownloadBC command = null;
		try {
			command = new UsaManifestListDownloadBCImpl();
			EsmBkg1144Event event = (EsmBkg1144Event) e;

			command.manageOrgPartyInfo(event.getOrgPartyVOs());
			// 성공메시지세팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1142 : MULTI01<BR>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUsCustomsStatusNoticeInfo(Event e) throws EventException {

		UsaManifestListDownloadBCImpl command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg1179Event")) {
				command = new UsaManifestListDownloadBCImpl();

				EsmBkg1179Event event = (EsmBkg1179Event) e;

				// 단건조회
				UsCustomsStatusNoticeVO usCustomsVO = command.searchUsCustomsStatusNoticeInfo(event.getUsCustomsStatusNoticeVO().getHndlOfcCd());

				// ETC-DATA:ETC KEY 선언
				if (usCustomsVO != null) {
					if (usCustomsVO.getHndlOfcCd() != null) {
						// eventResponse.setETCData(usCustomsVO.getColumnValues());
						eventResponse.setRsVo(usCustomsVO);
					}
				}
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1179 : SAVE <br>
	 * UserSetupMgt의 event에 대한 멀티 이벤트 처리<br>
	 * booking담당자별 각각의 화면에서 미리 정의된 Data를 Display해 주는 Data를 User별 입력해놓는다.<br>
	 *
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse assignInBondNumber(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaManifestListDownloadBC command = null;
		try {
			// PMIB NO의 MAX순차를 찾은후 1씩 증가시키므로 Transaction 관리가 필요함.
			begin();

			EsmBkg0408Event event = (EsmBkg0408Event) e;
			// BCImpl 객체 생성.
			command = new UsaManifestListDownloadBCImpl();
			// 이벤트로 부터 sheet1 SaveXml Data 추출.
			UsaInbondManifestListVO[] vos = event.getUsaInbondManifestListVOS();
			UsaInbondManifestDetailListVO[] vos2 = event.getUsaInbondManifestDetailListVOS();
			int i = 0;
			int len = 0;
			if (vos != null)
				len += vos.length;
			if (vos2 != null)
				len += vos2.length;
			// BCImpl의 매개변수에 맞도록 형 변환.
			InBondNumberVO[] inVos = new InBondNumberVO[len];
			if (vos != null) {
				for (i = 0; i < vos.length; i++) {
					inVos[i] = new InBondNumberVO();
					inVos[i].setVvd(vos[i].getVvd());
					inVos[i].setPod(vos[i].getPodCd());
					inVos[i].setHub(vos[i].getHubLocCd());
					inVos[i].setDel(vos[i].getDelCd());
					inVos[i].setCstms(vos[i].getCstmsLocCd());
					inVos[i].setBlNo("");
					inVos[i].setUserId(account.getUsr_id());
					inVos[i].setOfcCd(account.getOfc_cd());
				}
			}
			if (vos2 != null) {
				for (int j = 0; j < vos2.length; j++) {
					inVos[i] = new InBondNumberVO();
					inVos[i].setVvd(vos2[j].getVvd());
					inVos[i].setPod(vos2[j].getPodCd());
					inVos[i].setHub(vos2[j].getHubLocCd());
					inVos[i].setDel(vos2[j].getDelCd());
					inVos[i].setCstms(vos2[j].getCstmsLocCd());
					inVos[i].setBlNo(vos2[j].getBlNo());
					inVos[i].setUserId(account.getUsr_id());
					inVos[i].setOfcCd(account.getOfc_cd());
					i++;
				}
			}
			// BC 호출.
			List<InBondNumberDetailVO> rtnVos = command.assignInBondNumber(inVos);
			// 결과 처리
			if (rtnVos == null) {
				// 결과값이 없을 경우 오류 리턴
				eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
			} else {
				eventResponse.setRsVoList(rtnVos);
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0505 : COMMAND01 <br>
	 * 초기 BKG_NO 생성<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUserAuthInfoForHub(Event e) throws EventException {
		GeneralEventResponse eventResponse = null;
		UsaInbondTransmissionBC command = null;
		String[] hubModifyYn = new String[2];
		try {
			eventResponse = new GeneralEventResponse();
			command = new UsaInbondTransmissionBCImpl();

			hubModifyYn = command.searchUserAuthInfoForHub(account.getUsr_id());

			eventResponse.setETCData("hubModifyYn", hubModifyYn[0]);
			eventResponse.setETCData("cstmsModifyYn", hubModifyYn[1]);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_BKG_0990 : SEARCH <br>
	 * ESM_BKG_0034 : INIT <br>
	 * download 후 B/L을 추가 할 수 있다.<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommodity(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil bkgUtil = new BookingUtil();
		try {
			// 이벤트별 Impl생성
			EsmBkg0540Event event = (EsmBkg0540Event) e;
			String cmdtNm = bkgUtil.searchMdmCmdtDesc(event.getStrCmdtCd());
			if (!"".equals(cmdtNm)) eventResponse.setETCData("result", cmdtNm);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1037 : SEARCH <br>
	 * US AMS: Rail AMS History 조회.<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStowageManifestList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaCustomsTransmissionBC command = null;
		try {
			// 이벤트별 Impl생성
			EsmBkg1023Event event = (EsmBkg1023Event) e;
			command = new UsaCustomsTransmissionBCImpl();
			// BC 호출.
			List<ManifestTransmitVO> list = command.searchStowageManifestList(event.getUsaStowageManifestCondVO());
			// 결과 셋업.
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1023 : MULTI <BR>
	 * Vessel Stowage Plan Transmit 실행.<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitStowageManifest(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaCustomsTransmissionBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			EsmBkg1023Event event = (EsmBkg1023Event) e;
			// BackEnd
			command = new UsaCustomsTransmissionBCImpl();
			StiDetailVO[] detailVOs = event.getUsaStowageManifestDetailVOs();
			if (detailVOs != null) {
				for (int i = 0; i < detailVOs.length; i++) {
					detailVOs[i].setTmp1(account.getUsr_id());
					detailVOs[i].setTmp2(account.getOfc_cd());
				}
				String key = command.startBackEndJob(account, detailVOs, "ESM_BKG_1023");
				eventResponse.setETCData("KEY", key);
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0031 : SEARCH<br>
	 * ESM_BKG_0217 : SEARCH <br>
	 * BL INFO 조회<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBaplieAlarmSetup(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaCustomsTransmissionBC command = null;
		try {
			EsmBkg1098Event event = (EsmBkg1098Event) e;
			command = new UsaCustomsTransmissionBCImpl();
			List<BaplieAlarmSetupVO> list = command.searchBaplieAlarmSetup(event.getBaplieAlarmSetupVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1098 : SAVE <br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBaplieAlarmSetup(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaCustomsTransmissionBC command = new UsaCustomsTransmissionBCImpl();
		String user_id = account.getUsr_id();
		try {
			EsmBkg1098Event event = (EsmBkg1098Event) e;
			begin();
			command.manageBaplieAlarmSetup(event.getBaplieAlarmSetupVOs(), user_id);
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1106 : SEARCH01<BR>
	 * VVD FocusOut 시, 해당하는 vvd 의 EU 1st Port 를 조회.<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse loadCstmsRcvMsg(Event e) throws EventException {
		log.info("SC [loadCstmsRcvMsg] Start---------------------");
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaCustomsTransmissionBC command = null;
		UsaRcvMsgVO rcvVO = null;


		try {
			if (e.getEventName().equalsIgnoreCase("Ubiz2comOpusbkgAmsAckEvent")) {
				// 미세관 응답메세지 수신.
				Ubiz2comOpusbkgAmsAckEvent event = (Ubiz2comOpusbkgAmsAckEvent) e;
				command = new UsaCustomsTransmissionBCImpl();

				String rcvMsg = event.getFlatFile();
				rcvMsg = rcvMsg.replaceAll("\r\n", "\n");
				// 80Byte로 만들어 준다. (alps로직을 고치지 않기 위해)
				StringTokenizer token = new StringTokenizer(rcvMsg, "\n");
				String newRcvMsg = "";
				String header = "";
				while (token.hasMoreTokens())
				{
					String msgline = token.nextToken();
					if (msgline.indexOf("$$$") == -1)
					{
						if ("".equals(newRcvMsg))
							newRcvMsg = getDigitBlank(msgline, 80, " ", "R");
						else
							newRcvMsg = newRcvMsg + "\n" + getDigitBlank(msgline, 80, " ", "R");
					}
					else
					{
						header = msgline;
					}
				}
				rcvMsg = newRcvMsg;

				ArrayList<String> msgList = new ArrayList<String>();
				for (int i = 0; i < rcvMsg.length(); i++)
				{
					newRcvMsg = rcvMsg.substring(i);
					int acrIdx = newRcvMsg.substring(3).indexOf("ACR");

					if (acrIdx != -1)
					{
						msgList.add(newRcvMsg.substring(0, acrIdx + 2));
						i = i + acrIdx + 2;
					}
					else
					{
						acrIdx = newRcvMsg.indexOf("ACR");
						if (acrIdx != -1)
						{
							msgList.add(newRcvMsg);
							break;
						}
					}
				}

				for (int i=0; i<msgList.size(); i++)
				{
					begin();
					rcvMsg = header + "\n" + msgList.get(i);

					UsaRcvMsgVO usaRcvMsgVO = new UsaRcvMsgVO();
					usaRcvMsgVO.setRcvMsg(rcvMsg);
					try {
						rcvVO = (UsaRcvMsgVO) command.loadCstmsRcvMsg(usaRcvMsgVO);
					}catch (Exception ce) {
						log.error("US Customs Error\n" + ce.getStackTrace());
					}

					if (rcvVO != null) {
						try {
							// CFlag가 Y -> N으로 변경시
							List<BkgCstmsAdvIbdVO> bkgCstmsAdvIbdVOs = rcvVO.getBkgCstmsAdvIbdVOs();
							if (bkgCstmsAdvIbdVOs != null) {
								UsaManifestListDownloadBC manifestBC = new UsaManifestListDownloadBCImpl();
								manifestBC.modifyIbdCstmsClrCngFlg(bkgCstmsAdvIbdVOs);
							}
						} catch (Exception ce) {
							log.error("CFlag  Y -> N으로 변경\n" + ce.getStackTrace());
						}

						// Cargo Release 호출
						List<CstmsClrVO> cstmsClrs = rcvVO.getCstmsClrVOs();
						if (cstmsClrs != null) {
							log.info("Cargo Release Start");
							CargoReleaseOrderBC command3 = new CargoReleaseOrderBCImpl();
							for (int k = 0; k < cstmsClrs.size(); k++) {
								// try catch 중첩허용 타모듈 호출
								try {
									command3.setupFocByCstms(cstmsClrs.get(k));
								} catch (Exception ce) {
									log.error("Cargo Release Error\n" + ce.getStackTrace());
								}
							}
						}
						// Hold Notice('PH', 'CF') 호출
						List<CstmsHldVO> cstmsHlds = rcvVO.getCstmsHldVOs();
						if (cstmsHlds != null) {
							HoldNoticeBC command3 = new HoldNoticeBCImpl();
							BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();
							for (int k = 0; k < cstmsHlds.size(); k++) {
								// try catch 중첩허용 타모듈 호출
								try {
									// 1. Hold Notice
									List<BkgNtcHisVO> bkgNtcHisVOs = command3.createCstmsHld(cstmsHlds.get(k));
									// 2. Register Notice History
									bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, "UBIZ2COM_OPUSBKG_T_AMS_ACK");
								} catch (Exception ce) {
									log.error("Hold Notice('PH', 'CF') Error\n" + ce.getStackTrace());
								}
							}
						}
						// Warning 이벤트 Send
						List<CstmsHldVO> cstmsHldSends = rcvVO.getCstmsHldSendVOs();
						if (cstmsHldSends != null) {
							HoldNoticeBC command3 = new HoldNoticeBCImpl();
							for (int k = 0; k < cstmsHldSends.size(); k++) {
								// try catch 중첩허용 타모듈 호출
								try {
									// 1. Warning 이벤트 Send
									String gubun = SubSystemConfigFactory.get("BKG.MFT.SERVICE.MODE");
									if (gubun == null)
										gubun = "N";
									// TEST 일때는 GW, Alert 전송하지 않음. (ACE M1 테스트용)
									if (!gubun.equals("TEST")) {
										command3.sendAmsNtcToObStaff(cstmsHldSends.get(k));
										command3.sendAmsNtcToBkgStaff(cstmsHldSends.get(k));
									}
								} catch (Exception ce) {
									log.error("Warning 이벤트 Send Error\n" + ce.getStackTrace());
								}
							}
						}
					} // end Inbound
					commit();
				} // end for (message)

			} // 미세관 수신 이벤트
		} catch (Exception ex) {
			log.error("Exception : " + ex.getMessage());
		}

		return eventResponse;
	}

	/**
	 * ESM_BKG_0989 : SEARCH <br>
	 * KOREA에서 입/출항 선박 신고 적하목록 전송 문서의 상세 내역 조회<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAmsReportList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaCustomsReportBC command = null;
		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0819Event")) {
				EsmBkg0819Event event = (EsmBkg0819Event) e;
				command = new UsaCustomsReportBCImpl();
				List<AmsReportListDetailVO> list = command.searchAmsReportList(event.getMiTransmitHistoryCondVO());
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0041Event")) {
				EsmBkg0041Event event = (EsmBkg0041Event) e;
				command = new UsaCustomsReportBCImpl();
				UsaAmsReportListCondVO vo = event.getCondVO();
				vo.setTmp2(account.getCnt_cd());
				List<AmsReportListDetailVO> list = command.searchAmsReportList(vo);
				if ("ISF5".equals(vo.getGeneralOrRail())) {
					int manifest = 0;
					int accepted = 0;
					int rejected = 0;
					int none = 0;
					int target = 0;
					int unmanifest = 0;
					for (int i = 0; i < list.size(); i++) {
						UsaAmsReportIsf5ListVO isf5 = (UsaAmsReportIsf5ListVO) list.get(i);
						// 대상BL(모든BL)
						target++;
						if ("".equals(isf5.getIsfActCd())) {
							unmanifest++;
						} else {
							manifest++;
							if ("".equals(isf5.getIsfRsltCd())) {
								none++;
							} else if ("01".equals(isf5.getIsfRsltCd())) {
								rejected++;
							} else if ("02,03".indexOf(isf5.getIsfRsltCd()) >= 0) {
								accepted++;
							}
						}
					}
					eventResponse.setETCData("manifest", manifest + "");
					eventResponse.setETCData("accepted", accepted + "");
					eventResponse.setETCData("rejected", rejected + "");
					eventResponse.setETCData("none", none + "");
					eventResponse.setETCData("target", target + "");
					eventResponse.setETCData("unmanifest", unmanifest + "");
				}
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0428Event")) {
				EsmBkg0428Event event = (EsmBkg0428Event) e;
				command = new UsaCustomsReportBCImpl();
				List<RcvHistDetailVO> list = command.searchReceiveHist(event.getRcvHistCondVO());
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0429Event")) {
				EsmBkg0429Event event = (EsmBkg0429Event) e;
				command = new UsaCustomsReportBCImpl();
				List<ReceiveLogDetailVO> list = command.searchReceiveLog(event.getReceiveLogCondVO());
				eventResponse.setRsVoList(list);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0450 : SEARCH01 <br>
	 * ESM_BKG_0507 : SEARCH <br>
	 * ESM_BKG_0508 : SEARCH <br>
	 * Rotterdam세관에 보낸 edi History 현황정보를 가져온다<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode1125(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// RHQ List
		List<BkgComboVO> list = searchComCodeCombo("CD00961");
		BkgComboVO vo = new BkgComboVO();

		// default
		vo.setVal("");
		vo.setDesc("");
		vo.setName("");
		list.add(0, vo);

		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * ESM_BKG_0152 : INIT <br>
	 * ESM_BKG_1033 : INIT <br>
	 * com_intg_cd_dtl Table 조회<br>
	 *
	 * @param String
	 *            comCode
	 * @return List<BkgComboVO>
	 * @exception EventException
	 */
	private List<BkgComboVO> searchComCodeCombo(String comCode) throws EventException {
		BookingUtil bkgUtil = new BookingUtil();
		List<BkgComboVO> list = bkgUtil.searchCombo(comCode);
		try {
			for (int j = 0; j < list.size(); j++) {
				// 콤보 Text에 value + Name으로 보여주는 경우 사용
				list.get(j).setDesc(list.get(j).getVal() + " " + list.get(j).getName());
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return list;
	}

	/**
	 * ESM_BKG_1126 : SEARCH<BR>
	 * Europe Advanced Manifest - EXS REPORT 조회.<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTransmissionCheckList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaCustomsReportBC command = null;
		try {
			// 이벤트별 Impl생성
			EsmBkg0359Event event = (EsmBkg0359Event) e;
			command = new UsaCustomsReportBCImpl();
			// BC 호출.
			List<CheckListDetailListVO> list = command.searchTransmissionCheckList(event.getCondVo());
			// 조회결과가 있는 경우 결과값 추출.
			if (list != null) {
				CheckListDetailListVO vo = list.get(0);
				// 처음 탭(Manifest Status) 관련 결과값 리스트 셋업.
				if (vo.getManifestStatusResultList() != null) {
					eventResponse.setRsVoList(vo.getManifestStatusResultList());
				}
				// 두번째 탭(BL to be Delete) 관련 결과값 리스트 셋업.
				if (vo.getManifestStatusResultList() != null) {
					eventResponse.setRsVoList(vo.getBlToBeDeletedResultList());
				}
			} else {
				// 결과값이 없을 경우 오류 리턴
				eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0393 : SEARCH <br>
	 * 세관신고전 House B/L의 Data의 정확성 유무를 조회<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVesselArrival(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// UsaManifestListDownloadBC command = null;
		UsaCustomsReportBC command = null;
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0359Event")) {
				EsmBkg0359Event event = (EsmBkg0359Event) e;
				command = new UsaCustomsReportBCImpl();
				// 이벤트에서 vo 추출.
				TransmissionChkListCondVO cond = event.getCondVo();
				UsaVesselArrivalCondVO condvo = new UsaVesselArrivalCondVO();
				condvo.setVvd(cond.getVvd());
				condvo.setPort(cond.getPol());
				// BC 호출.
				List<UsaVesselArrivalDetailVO> volist = command.searchVesselArrival(condvo);
				// 조회결과가 있는 경우 결과값 추출.
				if (volist != null) {
					eventResponse.setETCData("eta", volist.get(0).getEta());
				}
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0234 : MULTI01 <br>
	 * DBF 파일생성해서 로컬로 파일 경로를 반환한다.<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTransmitHistList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaCustomsReportBC command = null;
		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0507Event")) {
				EsmBkg0507Event event = (EsmBkg0507Event) e;
				command = new UsaCustomsReportBCImpl();
				List<TransmitHistListDetailVO> list = command.searchTransmitHistList(event.getTransmitHistListCondVO());
				if (list.size() == 0) {
					eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
				}
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0508Event")) {
				EsmBkg0508Event event = (EsmBkg0508Event) e;
				command = new UsaCustomsReportBCImpl();
				List<TransmitHistFileDetailVO> list = command.searchTransmitHistFile(event.getTransmitHistFileCondVO());
				if (list.size() == 0) {
					eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
				} else {
					eventResponse.setRsVoList(list);
					eventResponse.setCustomData("filePath", list.get(0).getFilePath());
				}
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0142 : SEARCH<BR>
	 * ACI Report<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTransmitHistList2(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaCustomsReportBC command = null;
		Map<String, String> mapVO = new HashMap<String, String>();

		StringBuffer temp1 = new StringBuffer();

		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0508Event")) {
				EsmBkg0508Event event = (EsmBkg0508Event) e;
				command = new UsaCustomsReportBCImpl();
				List<TransmitHistFileDetailVO> list = command.searchTransmitHistFile(event.getTransmitHistFileCondVO());
				if (list.size() == 0) {
					eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
				} else {
					for (int i = 0; i < list.size(); i++) {
						TransmitHistFileDetailVO transmitHistFileDetailVO = (TransmitHistFileDetailVO) list.get(i);
						mapVO = transmitHistFileDetailVO.getColumnValues();
						temp1.append(mapVO.get("log_ctnt") + "\r\n");
					}
					eventResponse.setETCData("log_ctnt_etc", temp1.toString());
				}
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1107 : MULTI02 <br>
	 * 메뉴얼 MRN 삭제 <br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBlListByCntr(Event e) throws EventException {
		UsaCustomsReportBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0518Event event = (EsmBkg0518Event) e;
		try {
			command = new UsaCustomsReportBCImpl();
			// BC에 작업 요청
			List<ContainerDetailVO> containerDetailVOs = command.searchBlListByCntr(event.getCntrNo(), event.getVvd(), event.getBlType());

			// 결과 처리
			if (containerDetailVOs == null) {
				// 결과값이 없을 경우 오류 리턴
				eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
			} else {
				eventResponse.setRsVoList(containerDetailVOs);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0408 : SEARCH02 <br>
	 * PMIB NO를 구한후 BL에 할당.<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScacReportByVvdPod(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaCustomsReportBC command = null;
		try {
			// 이벤트별 Impl생성
			EsmBkg0574Event event = (EsmBkg0574Event) e;
			command = new UsaCustomsReportBCImpl();
			List<ScacReportDetailVO> list = command.searchScacReportByVvdPod(event.getScacReportCondVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0574 : SEARCH01<BR>
	 * ESM_BKG_0041 : SEARCH01<BR>
	 * Ams Pod 조회<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCodeConversion(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaCustomsReportBC command = null;
		try {
			// 이벤트별 Impl생성
			EsmBkg0574Event event = (EsmBkg0574Event) e;
			command = new UsaCustomsReportBCImpl();
			String amsCode = command.searchCodeConversion(event.getScacReportCondVO().getPod());
			eventResponse.setETCData("ams_pod", amsCode);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0551 : SEARCH01<BR>
	 * 세관 신고용 VVD 목록 조회<br>
	 *
	 * @param cstmsVvdInfoCondVO
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAmsRailHistoryList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaCustomsReportBC command = null;
		try {
			// 이벤트별 Impl생성
			EsmBkg1037Event event = (EsmBkg1037Event) e;
			command = new UsaCustomsReportBCImpl();
			List<AmsRailListVO> result = command.searchAmsRailHistoryList(event.getCondVO());
			if (result != null && result.size() > 0) {
				AmsRailListVO vo = result.get(0);
				eventResponse.setRsVoList(vo.getDetailList());
				if (vo.getBlList() != null) {
					eventResponse.setRsVoList(vo.getBlList());
				}
				if (vo.getHeader() != null) {
					RailHistoryDetailListVO head = vo.getHeader();
					eventResponse.setETCData("f", head.getF());
					eventResponse.setETCData("o", head.getO());
					eventResponse.setETCData("c", head.getC());
					eventResponse.setETCData("c_desc", head.getCDesc());
					eventResponse.setETCData("vvd", head.getVvd());
					eventResponse.setETCData("vsl_nm", head.getVslNm());
					eventResponse.setETCData("pol", head.getPol());
					eventResponse.setETCData("pod", head.getPod());
					eventResponse.setETCData("eta", head.getEta());
					eventResponse.setETCData("del", head.getDel());
					eventResponse.setETCData("hub", head.getHub());
					eventResponse.setETCData("r", head.getR());
					eventResponse.setETCData("d", head.getD());
					eventResponse.setETCData("qty", head.getQty());
					eventResponse.setETCData("qty_tp", head.getQtyTp());
					eventResponse.setETCData("wgt", head.getWgt());
					eventResponse.setETCData("wgt_up", head.getWgtUt());
				}
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0152 : SEARCH <br>
	 * 중국 DEL 지역별 운송 Mode를 조회한다.<br>
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBaplieMonitor(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaCustomsReportBCImpl command = null;
		try {
			EsmBkg1122Event event = (EsmBkg1122Event) e;
			command = new UsaCustomsReportBCImpl();

			List<BaplieMonitorCondVO> list = command.searchBaplieMonitor(event.getBaplieMonitorCondVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1122 : VVD 입력박스 Focus out 이벤트 대응<br>
	 * JSP화면 VVD입력 후에 입력 VVD에 해당하는 Last Foreign Port 를 조회한다.
	 *
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchUsLastForeignPort(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaCustomsReportBCImpl command = null;
		String crrCd = null;
		String lPol = null;
		try {
			EsmBkg1122Event event = (EsmBkg1122Event) e;
			command = new UsaCustomsReportBCImpl();
			String vvd = event.getBaplieMonitorCondVO().getVvd();
			List<BaplieMonitorCondVO> list = command.searchUsLastForeignPort(vvd);
			if (list != null && list.size() > 0) {
				BaplieMonitorCondVO vo = list.get(0);
				crrCd = vo.getCrrCd();
				lPol = vo.getLPol();
				eventResponse.setETCData("CRRCD", crrCd);
				eventResponse.setETCData("LPOL", lPol);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1179 : SAVE <br>
	 * UserSetupMgt의 event에 대한 멀티 이벤트 처리<br>
	 * booking담당자별 각각의 화면에서 미리 정의된 Data를 Display해 주는 Data를 User별 입력해놓는다.<br>
	 *
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageUsCustomsStatusNoticeInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EsmBkg1179Event event = (EsmBkg1179Event) e;

		UsaManifestListDownloadBC command = new UsaManifestListDownloadBCImpl();

		event.getUsCustomsStatusNoticeVO().setCreUsrId(account.getUsr_id());
		event.getUsCustomsStatusNoticeVO().setUpdUsrId(account.getUsr_id());

		try {

			begin();
			command.manageUsCustomsStatusNoticeInfo(event.getUsCustomsStatusNoticeVO());
			commit();

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0428 : INIT <br>
	 * ESM_BKG_0429 : INIT <br>
	 * ESM_BKG_0217 <br>
	 * 코드별 콤보 데이터 조회<br>
	 *
	 * @param String
	 *            comCode
	 * @return List<BkgComboVO>
	 * @exception EventException
	 */
	private List<BkgComboVO> searchCodeCombo(String comCode) throws EventException {
		try {
			BookingUtil bkgUtil = new BookingUtil();
			List<BkgComboVO> list = bkgUtil.searchCombo(comCode);
			return list;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_0428 <br>
	 * 미국 현재 날짜 가져오기<br>
	 *
	 * @return String
	 * @exception EventException
	 */
	private String searchLocalSysdate(Event e) throws EventException {
		UsaCustomsReportBC command = new UsaCustomsReportBCImpl();
		String date = null;
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0428Event") || e.getEventName().equalsIgnoreCase("EsmBkg0507Event")) {
				date = command.searchLocalSysdate();
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return date;
	}

	/**
	 * CDL 자동전송
	 *
	 * @param blNo
	 */
	private void transmitCdlEdi(String blNo) throws Exception {
		try {
			UsaCustomsTransmissionBC command = new UsaCustomsTransmissionBCImpl();
			BlInfoCondVO blInfoCondVO = new BlInfoCondVO();
			blInfoCondVO.setBlNo(blNo);
			List<BlInfoVO> blInfos = command.searchTmlBlByVvd(blInfoCondVO);
			if (blInfos.size() > 0) {
				CllCdlTransmitVO[] cllCdlTransmitVOs = new CllCdlTransmitVO[blInfos.size()];
				for (int i = 0; i < blInfos.size(); i++) {
					UsaTmlBlByVvdVO usaTmlBlByVvdVO = (UsaTmlBlByVvdVO) blInfos.get(i);
					cllCdlTransmitVOs[i] = new CllCdlTransmitVO();
					cllCdlTransmitVOs[i].setBkgNo(usaTmlBlByVvdVO.getBkgNo());
					cllCdlTransmitVOs[i].setBlNo(usaTmlBlByVvdVO.getBlNo());
					cllCdlTransmitVOs[i].setCntrNo(usaTmlBlByVvdVO.getCntrNo());
					cllCdlTransmitVOs[i].setBkgCgoTpCd(usaTmlBlByVvdVO.getBkgCgoTpCd());
					cllCdlTransmitVOs[i].setInListType("D");
					cllCdlTransmitVOs[i].setInVvdCd(usaTmlBlByVvdVO.getVslCd() + usaTmlBlByVvdVO.getSkdVoyNo() + usaTmlBlByVvdVO.getSkdDirCd());
					cllCdlTransmitVOs[i].setInPolCd(usaTmlBlByVvdVO.getCstmsPolCd());
					cllCdlTransmitVOs[i].setInPodCd(usaTmlBlByVvdVO.getCstmsPodCd());
					cllCdlTransmitVOs[i].setInSndId(usaTmlBlByVvdVO.getSndId());
					cllCdlTransmitVOs[i].setInRcvId(usaTmlBlByVvdVO.getRcvId());
					cllCdlTransmitVOs[i].setInYdCd(usaTmlBlByVvdVO.getYdCd());
					cllCdlTransmitVOs[i].setInAreaId("USA");
					cllCdlTransmitVOs[i].setInDestSvrCd("USA");
					cllCdlTransmitVOs[i].setInWhereGubun("DL");
					if ("D".equals(usaTmlBlByVvdVO.getMfStsCd())) {
						cllCdlTransmitVOs[i].setInEdiMsgFunc("CANCEL");
					} else {
						cllCdlTransmitVOs[i].setInEdiMsgFunc("REPLACE");
					}
				}
				CLLCDLManifestBC cLLCDLManifestBC = new CLLCDLManifestBCImpl();
				cLLCDLManifestBC.transmitCllCdl(cllCdlTransmitVOs, account);
			}
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler("BKG40110", new String[] { "Terminal" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG40110", new String[] { "Terminal" }).getMessage(), ex);
		}
	}

	/**
	 *
	 * @param value
	 * @param digitCnt
	 * @param digit
	 * @param leftRight
	 * @return
	 */
	private String getDigitBlank(String value, int digitCnt, String digit, String leftRight)
	{
		StringBuffer sbBlank = new StringBuffer();
		if (value.length() >= digitCnt)
			return value;

		if ("R".equals(leftRight)) {
			sbBlank.append(value);
		}

		for (int i = 0; i < digitCnt - value.length(); i++) {
			if ("".equals(digit) && "R".equals(leftRight))
				digit = " ";
			if ("".equals(digit) && "L".equals(leftRight))
				digit = "0";
			sbBlank.append(digit);
		}

		if ("L".equals(leftRight)) {
			sbBlank.append(value);
		}
		return sbBlank.toString().substring(0, digitCnt);
	}

	/**
	 * [ESM_BKG_0540] Sheet1_OnChange<br>
	 *  - SC No. Validation
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaInbondTransmissionBC command = new UsaInbondTransmissionBCImpl();
		EsmBkg0540Event event = (EsmBkg0540Event)e;

		try {
			eventResponse.setETCData("sc_no", command.searchScNo(event.getStrScNo()));
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

}// end class
