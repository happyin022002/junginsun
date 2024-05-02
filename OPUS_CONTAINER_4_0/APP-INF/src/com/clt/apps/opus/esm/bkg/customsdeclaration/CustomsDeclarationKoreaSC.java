/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : CustomsDeclarationKoreaSC.java
 *@FileTitle : CustomsDeclarationKoreaSC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.10.18
 *@LastModifier :
 *@LastVersion : 1.0
 * 2013.10.18
 * 1.0 Creation
=======================================================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.basic.KorCustomsReportBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.basic.KorCustomsReportBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.event.EsmBkg0215Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.event.EsmBkg0334Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.event.EsmBkg0335Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.event.EsmBkg0340Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.event.EsmBkg0341Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.event.EsmBkg0345Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.event.EsmBkg0346Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.event.EsmBkg0358Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.event.EsmBkg0502Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.event.EsmBkg0917Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.event.EsmBkg0989Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorDischCYVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorDischLocCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorDischLocVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorDischPrintListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorEntryTpCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorEntryTpVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorImpPrintListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorMrnVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorRcvHistVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorReportHistContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorTransHistVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorTransmitHistDtlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorWareHouseVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.ReportHistCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.basic.KorCustomsTransmissionBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.basic.KorCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.event.EsmBkg0030Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.event.EsmBkg0031Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.event.EsmBkg0212Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.event.EsmBkg0344Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.event.EsmBkg0371Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.event.EsmBkg0503Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.event.EsmBkgUdevComOpusBkgEntryEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.event.EsmBkgUdevComOpusBkgKrcusEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.event.UbizComOpusBkgKrcusAckEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAmdBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAmdFormVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAmdManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAmendManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCancelManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCntrNoKorVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorDischManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorEmpAmdManiTransVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestCancelTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestDGMTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestDGNTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestMFTTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorRcvAckMsgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorTransCancellCustVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorTransCrossChkDtlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.DgmManifestVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.basic.KorManifestListDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.basic.KorManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.event.EmsBkgWeb0010001Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.event.EsmBkg0329Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.event.EsmBkg0333Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.event.EsmBkg0337Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.event.EsmBkg0338Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.event.EsmBkg0505Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.BkgCstmsKrMfSeqNoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.BkgCstmsKrVvdSmryVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.BkgWebServiceVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorBkgCntrQtyInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorBkgDgCgoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorBkgHistVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorBlInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorBlInfoKorVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorBlInqInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorBondLocalInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorBondTsInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorCmdtVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorCntrCorrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorCntrInqInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorCntrTpSzVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorCodeVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorCorrInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorCorrListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorDgCgoManifestCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorDgCgoManifestVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorDiscCYBondInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorDlContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorElnoInqInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorEmpAmdManiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorExpCorrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorIbDgCgoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorMSNCreateContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorManiCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorManiSumCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorManifestAmdManiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorManifestCrsChkInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorManifestEditListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorManifestEditListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorManifestEditModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorManifestInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorManifestSmryCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorMrnInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorMrnNoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorMsnBondInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorMsnCreateVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorObDgCgoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorPckInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorRcvMsgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorTmpBlBkgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorVslInfoNManifestCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorVslInfoNManifestVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.ObMsnInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CodeVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManiDGMTransVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationBLBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationBLBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgBlDocVO;
import com.clt.syscommon.common.table.BkgBlIssVO;
import com.clt.syscommon.common.table.BkgCstmsKrDlHisVO;
import com.clt.syscommon.common.table.BkgHisDtlVO;
import com.clt.syscommon.common.table.BkgHisMstVO;
import com.clt.syscommon.common.table.BkgRateVO;


/**
 * OPUS-CustomsDeclarationKorea Business Logic ServiceCommand<br>
 * - OPUS-CustomsDeclarationKorea에 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author KIM, Sang-Soo
 * @see
 * @since J2EE 1.6
 */
public class CustomsDeclarationKoreaSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CustomsDeclarationKorea system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("CustomsDeclarationKoreaSC 시작");

		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * CustomsDeclarationKorea system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("CustomsDeclarationKoreaSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * OPUS-CustomsDeclarationKorea system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EmsBkgWeb0010001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = modifyWeb0010001ControlMgmt(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0030Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH) || e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchManifestList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0031Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBlInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = transAmendManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchContainer(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0212Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				// 조회
				eventResponse = searchDgCgoManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				// 수정
				eventResponse = manageDgCgoManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				// Transmit DGM
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				// Transmit DGL
				eventResponse = transmitManifest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0215Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDownLoadHist(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0329Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComCode0329(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH) || e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = startBackEndJobDownloadCstmsBlList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = manageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = manageMsnNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = manageCrossCheck(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0333Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDiscCYBondInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDiscCYBondInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = interfaceWhfToArInv(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0334Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDiscCYCodeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDiscCYCodeList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0335Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmEntryTpList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCstmEntryTpList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0337Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = transmitManifest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0338Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH) || e.getFormCommand().isCommand(FormCommand.SEARCH01) || e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchMsnBondedInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyMsnBondedInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0340Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH) || e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchDischCYList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0341Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH) || e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchDischCYList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0344Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				// 조회
				eventResponse = manageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				// 수정
				eventResponse = modifyManifestSummaryInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				// 삭제
				eventResponse = manageManifestSummaryInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				// Trans Amdendment to PA
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				// Trans Discharge 하선신고
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				// Trans Manifest
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI06)) {
				// Trans Empty Amend
				eventResponse = manageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI07)) {
				// Cancel Per B/L
				eventResponse = transAmendManifest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0345Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchWareHouseInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0346Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchTransCancellInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitCancellKR(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0358Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMRNNoList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0371Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMrnInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI) || e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = manageMrnCreateInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0502Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTransmitHist(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0503Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTransCrossChk(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0505Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH) || e.getFormCommand().isCommand(FormCommand.COMMAND09)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchTempBlNoNBkgNoAssign(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchContainer(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0917Event")) {
			// 세관 수신내역 조회
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReceiveHist(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0989Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTransmitHistDtl(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkgUdevComOpusBkgEntryEvent") || e.getEventName().equalsIgnoreCase("EsmBkgUdevComOpusBkgKrcusEvent")) {
			eventResponse = loadCstmsRcvMsg(e);
		} else if (e.getEventName().equalsIgnoreCase("UbizComOpusBkgKrcusAckEvent")) {
			eventResponse = loadCstmsRcvMsg(e);
		}
		return eventResponse;
	}

	/**
	 * WEB_001_0001 : MULTI01<br>
	 * WebService EAI(WEB_001_0001)<br>
	 *
	 * @author Su-Young, Lee
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyWeb0010001ControlMgmt(Event e) throws EventException {
		GeneralEventResponse eventResponse = null;
		EmsBkgWeb0010001Event event = null;
		KorManifestListDownloadBC command = null;

		try {
			eventResponse = new GeneralEventResponse();
			event = (EmsBkgWeb0010001Event) e;
			command = new KorManifestListDownloadBCImpl();
			begin();
			BkgWebServiceVO webVO = event.getBkgWebServiceVO();
			command.modifyWeb0010001Control(webVO);
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
	 * ESM_BKG_0329 : SEARCH<BR>
	 * Receive History<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManifestList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		KorManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0329Event")) {
				EsmBkg0329Event event = (EsmBkg0329Event) e;
				command = new KorManifestListDownloadBCImpl();

				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					Map<String, String> etcData = new HashMap<String, String>();
					KorMrnNoVO korMrnNoVO = event.getMrnNoVO();
					KorContainerVO korContainerVO = (KorContainerVO) command.searchManifestInfo(korMrnNoVO);
					if (korContainerVO != null) {
						eventResponse.setRsVoList(korContainerVO.getKorManifestInfoVOs());
						eventResponse.setRsVoList(korContainerVO.getKorBkgCntrQtyInfoVOs());
						eventResponse.setETCData("mrn_nbr", korMrnNoVO.getMrnNo());
						eventResponse.setETCData("mrn_chk_no", korMrnNoVO.getMrnChkNo());
						eventResponse.setETCData("in_bound", korMrnNoVO.getInBound());
						eventResponse.setETCData("in_pol", korMrnNoVO.getInPol());
						eventResponse.setETCData("in_pol_yd", korMrnNoVO.getInPol());
						eventResponse.setETCData("in_vvd", korMrnNoVO.getInVvd());
						eventResponse.setETCData("in_pod", korMrnNoVO.getInPod());
						eventResponse.setETCData("in_hn", korMrnNoVO.getInHn());
						eventResponse.setETCData("sel_type", korMrnNoVO.getSelType());
						eventResponse.setETCData("bl_dl", korMrnNoVO.getBlDl());
						eventResponse.setETCData("all_err", korMrnNoVO.getAllErr());
						eventResponse.setETCData("in_blno", korMrnNoVO.getBlNo());
						eventResponse.setETCData("bl_type", korMrnNoVO.getBlType());
						eventResponse.setETCData("el_type", korMrnNoVO.getElType());
						eventResponse.setETCData("correction", korMrnNoVO.getCorrection());
						eventResponse.setETCData("cntr_local", korMrnNoVO.getCntrLocal());
						eventResponse.setETCData("cntr_ts", korMrnNoVO.getCntrTs());
						eventResponse.setETCData("cntr_empty", korMrnNoVO.getCntrEmpty());
						eventResponse.setETCData("cntr_total", korMrnNoVO.getCntrTotal());
						eventResponse.setETCData("bl_local", korMrnNoVO.getBlLocal());
						eventResponse.setETCData("bl_ts", korMrnNoVO.getBlTs());
						eventResponse.setETCData("bl_empty", korMrnNoVO.getBlEmpty());
						eventResponse.setETCData("bl_total", korMrnNoVO.getBlTotal());
						eventResponse.setETCData("eta_etd", korMrnNoVO.getEtaEtd());
						eventResponse.setETCData("etb_dt", korMrnNoVO.getEtbDt());
					} else {
						eventResponse.setETCData("mrn_nbr", " ");
						eventResponse.setETCData("mrn_chk_no", " ");
						// eventResponse.setUserMessage(new ErrorHandler("BKG00689").getUserMessage());
					}
					eventResponse.setETCData(etcData);

				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
					List<KorManifestCrsChkInfoVO> container = null;
					KorMrnNoVO fromClient = null;
					container = command.searchManifestCrsChkInfoKorList(event.getMrnNoVO());
					eventResponse.setRsVoList(container);
					fromClient = command.searchManifestCrsChkInfoSumKorList(event.getMrnNoVO());

					if (fromClient != null) {
						eventResponse.setETCData("mrn_nbr", fromClient.getMrnNo());
						eventResponse.setETCData("mrn_chk_no", fromClient.getMrnChkNo());
						eventResponse.setETCData("eta_etd", fromClient.getEtaEtd());
						eventResponse.setETCData("etb_dt", fromClient.getEtbDt());
					}
				}

			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0337Event")) {
				// EVENT 0337 처리
				EsmBkg0337Event event = (EsmBkg0337Event) e;
				KorMsnCreateVO korMsnCreateVO = event.getKorMrnInfoVO();
				korMsnCreateVO.setUserid(account.getUsr_id());
				command = new KorManifestListDownloadBCImpl();
				List<ManifestListDetailVO> manifestListDetailVOs = null;
				KorMSNCreateContainerVO container = null;
				Map<String, String> etcData = new HashMap<String, String>();
				// BC에 작업 요청
				manifestListDetailVOs = command.searchManifestList(korMsnCreateVO);
				// 결과 처리
				if (manifestListDetailVOs == null) {
					// 결과값이 없을 경우 오류 리턴
					eventResponse.setUserMessage(new ErrorHandler("BKG00689").getUserMessage());
				} else {
					// 정상 처리 결과 저장
					container = (KorMSNCreateContainerVO) manifestListDetailVOs.get(0);
					// MRN 정보 ETC에 저장
					KorMrnInfoVO korMrnInfoVO = container.getKorMrnInfoVO();
					if (korMrnInfoVO == null) {
						// 결과값이 없을 경우 오류 리턴
						eventResponse.setUserMessage(new ErrorHandler("BKG00689").getUserMessage());
					} else {
						etcData.put("mrn_no", korMrnInfoVO.getMrnNo()
								+ korMrnInfoVO.getMrnChkNo());
						etcData.put("vvd", korMrnInfoVO.getVvd());
						etcData.put("port", korMrnInfoVO.getPortCd());
						etcData.put("snd_dt", korMrnInfoVO.getSndDt());
						etcData.put("rslt_dt", korMrnInfoVO.getRsltDt());
						etcData.put("rslt", korMrnInfoVO.getRslt());
						etcData.put("err_msg", korMrnInfoVO.getErrMsg());
						// LOCAL SHEET 용 데이터 존재하면 넘겨주기
						if (container.getLocalMsnInfoVOs() != null)
							eventResponse.setRsVoList(container.getLocalMsnInfoVOs());
						// TS SHEET 용 데이터 존재하면 넘겨주기
						if (container.getTsMsnInfoVOs() != null)
							eventResponse.setRsVoList(container.getTsMsnInfoVOs());
						// LOCAL B/L TYPE COUNT
						etcData.put("local_bl_tp_simple", container.getLocalBlTpCnt().getBlTpSimple());
						etcData.put("local_bl_tp_console", container.getLocalBlTpCnt().getBlTpConsole());
						etcData.put("local_bl_tp_empty", container.getLocalBlTpCnt().getBlTpEmpty());
						// TS B/L TYPE COUNT
						etcData.put("ts_bl_tp_simple", container.getTsBlTpCnt().getBlTpSimple());
						etcData.put("ts_bl_tp_console", container.getTsBlTpCnt().getBlTpConsole());
						etcData.put("ts_bl_tp_empty", container.getTsBlTpCnt().getBlTpEmpty());
						// EDI_SND_DI
						etcData.put("edi_snd_ind", korMrnInfoVO.getSendInd());
					}
				}
				eventResponse.setETCData(etcData);

			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0505Event")) {
				// EVENT 0505 처리
				EsmBkg0505Event event = (EsmBkg0505Event) e;
				// BC 생성
				command = new KorManifestListDownloadBCImpl();
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					// 데이터 조회 처리
					KorBlInqInfoVO korBlInqInfoVO = event.getKorBlInqInfoVO();
					korBlInqInfoVO.setUserId(account.getUsr_id());
					// 조회용 파라메터 객체
					KorManifestEditListCondVO manifestEditListCondVO = new KorManifestEditListCondVO();
					// 결과 값
					KorManifestEditListVO korManifestEditListVO = null;
					// 파라메터 매핑
					manifestEditListCondVO.setTransTp(korBlInqInfoVO.getTransTp());
					manifestEditListCondVO.setBlNo(korBlInqInfoVO.getBlNo());
					manifestEditListCondVO.setCstmsDeclTpCd(korBlInqInfoVO.getCstmsDeclTpCd());
					manifestEditListCondVO.setPortCd(korBlInqInfoVO.getPortCd());
					manifestEditListCondVO.setUserId(korBlInqInfoVO.getUserId());
					Map<String, String> etcData = new HashMap<String, String>();
					// BC에 처리 의뢰
					korManifestEditListVO = (KorManifestEditListVO) command.searchManifestEditList(manifestEditListCondVO);
					// 결과 처리
					if (korManifestEditListVO == null) {
						// 결과값이 없을 경우 오류 리턴
						eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
					} else {
						// 정상 처리 결과 저장
						// Container 리스트
						if (korManifestEditListVO.getKorCntrInqInfoVOs() != null)
							eventResponse.setRsVoList((List<KorCntrInqInfoVO>) Arrays.asList(korManifestEditListVO.getKorCntrInqInfoVOs()));
						// Export Licence 리스트
						if (korManifestEditListVO.getKorElnoInqInfoVOs() != null)
							eventResponse.setRsVoList((List<KorElnoInqInfoVO>) Arrays.asList(korManifestEditListVO.getKorElnoInqInfoVOs()));
						// BL / CUSTOMER INFO 정보는 ETC DATA에 담음
						if (korManifestEditListVO.getKorCustInqInfoVO() != null)
							etcData.putAll(korManifestEditListVO.getKorCustInqInfoVO().getColumnValues());
						if (korManifestEditListVO.getKorBlInqInfoVO() != null)
							etcData.putAll(korManifestEditListVO.getKorBlInqInfoVO().getColumnValues());
						if (manifestEditListCondVO != null)
							etcData.putAll(manifestEditListCondVO.getColumnValues());
						// Cargo Spec
						etcData.put("cargo_spec", korManifestEditListVO.getCargoSpec());
					}
					eventResponse.setETCData(etcData);

				} else if (e.getFormCommand().isCommand(FormCommand.COMMAND09)) {
					// 코드 조회 처리
					// BC에 작업 요청
					CodeVO[] codeVOs = command.searchCodeInfo(null);
					KorCodeVO codeVO = null;
					// 결과 처리
					if (codeVOs == null) {
						// 결과값이 없을 경우 오류 리턴
						eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
					} else {
						codeVO = (KorCodeVO) codeVOs[0];
						eventResponse.setRsVoList((List<KorPckInfoVO>) Arrays.asList(codeVO.getKorPckInfoVOs()));
						eventResponse.setRsVoList((List<KorCmdtVO>) Arrays.asList(codeVO.getKorCmdtVOs()));
						eventResponse.setRsVoList((List<KorCntrTpSzVO>) Arrays.asList(codeVO.getKorCntrTpSzVOs()));
					}
				}

			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0030Event")) {
				// EVENT 0030 처리
				EsmBkg0030Event event = (EsmBkg0030Event) e;
				// BC 생성
				KorCustomsTransmissionBC command2 = new KorCustomsTransmissionBCImpl();
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					// 조회용 파라메터 객체
					KorManifestListCondVO condVO = event.getKorManifestListCondVO();
					// BC에 처리 의뢰
					KorManifestListVO manifestListVO = (KorManifestListVO) command2.searchManifestListForTransmit(condVO);
					// 결과 처리
					eventResponse.setRsVoList((List<KorAmdBlInfoVO>) Arrays.asList(manifestListVO.getKorAmdBlInfoVOs()));
					eventResponse.setRsVoList((List<KorCntrNoKorVO>) Arrays.asList(manifestListVO.getKorCntrNoKorVOs()));
					eventResponse.setETCData("mrn_no", manifestListVO.getMrnNo());
					eventResponse.setETCData("mrn_chk_no", manifestListVO.getMrnChkNo());
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
					// 조회용 파라메터 객체
					KorAmdFormVO[] condVOs = event.getKorAmdFormVOs();
					Map<String, String> etcData = new HashMap<String, String>();
					// 조회결과
					KorAmdFormVO[] amdFormVOs = null;
					// BC에 처리 의뢰
					amdFormVOs = (KorAmdFormVO[]) command2.searchAmdFormPrev(condVOs);
					// 결과 처리
					eventResponse.setRsVoList((List<KorAmdFormVO>) Arrays.asList(amdFormVOs));
					if (amdFormVOs != null && amdFormVOs.length > 0) {
						eventResponse.setETCData("mrn_no", amdFormVOs[0].getMrnNo());
						eventResponse.setETCData("bl_tp_cd", amdFormVOs[0].getBlTpCd());
						eventResponse.setETCData("ship_nm", amdFormVOs[0].getShipNm());
						eventResponse.setETCData("eta_dt", amdFormVOs[0].getEtaDt());
						eventResponse.setETCData("port_cd", amdFormVOs[0].getPortCd());
					}
					eventResponse.setETCData(etcData);
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
	 * ESM_BKG_0031 : SEARCH <br>
	 * 일본 세관에 신고할 대상 Manifest 정보(Download 데이터) 를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBlInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		KorManifestListDownloadBC command = null;

		try {
			String eventName = e.getEventName();
			// 이벤트별 Impl생성
			if (eventName.equalsIgnoreCase("EsmBkg0031Event")) {
				EsmBkg0031Event event = (EsmBkg0031Event) e;
				KorBlInfoCondVO blInfoCondVO = event.getKorBlInfoCondVO();
				command = new KorManifestListDownloadBCImpl();
				KorBlInfoVO korBlInfoVO = (KorBlInfoVO) command.searchBlInfo(blInfoCondVO);
				if (korBlInfoVO.getKorAmendInfoVO() != null)
					eventResponse.setETCData(korBlInfoVO.getKorAmendInfoVO().getColumnValues());
				if (korBlInfoVO.getKorCorrTransVO() != null)
					eventResponse.setETCData(korBlInfoVO.getKorCorrTransVO().getColumnValues());
				if (korBlInfoVO.getKorCustCorrVO() != null)
					eventResponse.setETCData(korBlInfoVO.getKorCustCorrVO().getColumnValues());
				eventResponse.setETCData("cgo_spec", korBlInfoVO.getCgoSpec());
				eventResponse.setRsVoList((List<KorCntrCorrVO>) Arrays.asList(korBlInfoVO.getKorCntrCorrVOs()));
				eventResponse.setRsVoList((List<KorExpCorrVO>) Arrays.asList(korBlInfoVO.getKorExpCorrVOs()));
				eventResponse.setRsVoList((List<KorCorrListVO>) Arrays.asList(korBlInfoVO.getKorCorrListVOs()));
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0212 : SEARCH<br>
	 * DG Cargo Manifest List 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		KorManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0329Event")) {
				EsmBkg0329Event event = (EsmBkg0329Event) e;
				command = new KorManifestListDownloadBCImpl();
				KorDlContainerVO cont = new KorDlContainerVO();
				KorMrnNoVO fromClient = event.getMrnNoVO();
				KorManifestInfoVO[] list = event.getManifestInfoVOs();
				KorBkgCntrQtyInfoVO[] cntrList = event.getCntrVOs();
				cont.setKorMrnNoVO(fromClient);
				cont.setKorManifestInfoVOs(list);
				cont.setKorBkgCntrQtyInfoVOs(cntrList);
				cont.setUser_id(account.getUsr_id());
				cont.setOffice(account.getOfc_cd());
				int delCount = command.manageManifest(cont);
				eventResponse.setETCData("delcount", Integer.toString(delCount));

			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0505Event")) {
				EsmBkg0505Event event = (EsmBkg0505Event) e;
				command = new KorManifestListDownloadBCImpl();
				// 파라메터 객체
				KorManifestEditModificationVO condVO = new KorManifestEditModificationVO();
				// 파라메터 매핑
				condVO.setUserId(account.getUsr_id());
				condVO.setKorBlInqInfoVO(event.getKorBlInqInfoVO());
				condVO.setKorCntrInqInfoVOs(event.getKorCntrInqInfoVOs());
				condVO.setKorCustInqInfoVO(event.getKorCustInqInfoVO());
				condVO.setKorElnoInqInfoVOs(event.getKorElnoInqInfoVOs());
				// BC에 작업 요청
				command.manageManifest(condVO);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());

			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0031Event")) {
				EsmBkg0031Event event = (EsmBkg0031Event) e;
				command = new KorManifestListDownloadBCImpl();
				// 화면에서 넘어온 값 VO 로 얻어옴
				KorManifestAmdManiVO condVO = event.getKorManifestAmdManiVO();
				// 값 매핑
				condVO.setUserId(account.getUsr_id());
				// BC에 작업 요청
				command.manageAmdManifest(condVO);
				// 성공 메시지 셋팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());

			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0344Event")) {

				EsmBkg0344Event event = (EsmBkg0344Event) e;
				command = new KorManifestListDownloadBCImpl();

				if (event.getFormCommand().isCommand(FormCommand.MULTI06)) {
					// 한국세관 0344 Transmit Empty Amend 처리
					KorEmpAmdManiVO[] korEmpAmdManiVOs = event.getKorEmpAmdManiVOs();
					KorAmendManifestTransmitVO korAmendManifestTransmitVO = event.getKorAmendManifestTransmitVO();

					if (korEmpAmdManiVOs != null) {
						// USR_ID 와 RECEIVER 설정
						for (int i = 0; i < korEmpAmdManiVOs.length; i++) {
							korEmpAmdManiVOs[i].setUsrId(account.getUsr_id());
							korEmpAmdManiVOs[i].setOfcCd(account.getOfc_cd());
							korEmpAmdManiVOs[i].setReceiver(korAmendManifestTransmitVO.getReceiver());
						}
						korEmpAmdManiVOs = (KorEmpAmdManiVO[]) command.manageEmpAmdManifest(korEmpAmdManiVOs);

						// Transmit
						this.transmitEmpAmdManifest(korEmpAmdManiVOs);

						// 전송일시 UPDATE
						command.transmitEmpAmdManifest(korEmpAmdManiVOs);

						// 성공메시지세팅
						eventResponse.setUserMessage(new ErrorHandler("BKG00218").getUserMessage());
					} else {
						// 조회결과 없을 경우
						eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
					}

				} else {
					// 한국세관 0344 Transmit 조회
					KorVslInfoNManifestCondVO condVO = event.getKorVslInfoNManifestCondVO();
					condVO.setUserId(account.getUsr_id());
					KorVslInfoNManifestVO korVslInfoNManifestVO = (KorVslInfoNManifestVO) command.manageVslInfoNManifestList(condVO);
					BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO = korVslInfoNManifestVO.getBkgCstmsKrVvdSmryVO();
					if (bkgCstmsKrVvdSmryVO != null) {
						eventResponse.setETCData(bkgCstmsKrVvdSmryVO.getColumnValues());
					} else {
						// 조회결과 없을 경우
						eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
					}
				}
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
	 * 한국세관 InBound Empty Amend 전송
	 *
	 * @param KorEmpAmdManiVO[] korEmpAmdManiVOs
	 * @throws EventException
	 */
	private void transmitEmpAmdManifest(KorEmpAmdManiVO[] korEmpAmdManiVOs) throws EventException {

		try {
			KorCustomsTransmissionBC command = new KorCustomsTransmissionBCImpl();

			// 파라메터 복사
			KorEmpAmdManiTransVO[] korEmpAmdManiTransVOs = new KorEmpAmdManiTransVO[korEmpAmdManiVOs.length];

			for (int i = 0; i < korEmpAmdManiVOs.length; i++) {
				korEmpAmdManiTransVOs[i] = new KorEmpAmdManiTransVO();
				ObjectCloner.build(korEmpAmdManiVOs[i], korEmpAmdManiTransVOs[i]);
			}

			// 전송
			command.transmitEmpAmdManifest(korEmpAmdManiTransVOs);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_0061 : MULTI <br>
	 * ROCS(ROTTERDAM) 세관에 신고할 대상 Manifest List를 전송하기 전에 데이터를 확인했다는 의미로 Confirm
	 * Indicator를 업데이트 한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transAmendManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		KorCustomsTransmissionBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0031Event")) {
				EsmBkg0031Event event = (EsmBkg0031Event) e;
				command = new KorCustomsTransmissionBCImpl();
				KorManifestListDownloadBC command2 = new KorManifestListDownloadBCImpl();
				KorAmdManifestTransmitVO condVO = event.getKorAmdManifestTransmitVO();
				KorBlInfoKorVO korBlInfoKorVO = new KorBlInfoKorVO();
				// KorAmdBlInfoVO korAmdBlInfoVO = new KorAmdBlInfoVO();
				// 파라메터 설정
				condVO.setUserId(account.getUsr_id());
				condVO.setOfcCd(account.getOfc_cd());
				String portCd = null;

				// BC에 작업 요청
				String transSndChk = command.transAmdManifest(condVO);
				if (transSndChk != null) {

					// PORT_CD
					if (condVO.getKorBlAmdVO().getIoBndCd().equals("O")) {
						portCd = condVO.getKorBlAmdVO().getPolCd();
					} else {
						portCd = condVO.getKorBlAmdVO().getPodCd();
					}

					korBlInfoKorVO.setUserId(condVO.getUserId());
					korBlInfoKorVO.setBkgNo(condVO.getKorBlAmdVO().getBkgNo());
					korBlInfoKorVO.setCstmsDeclTpCd(condVO.getKorBlAmdVO().getCstmsDeclTpCd());
					korBlInfoKorVO.setPortCd(portCd);
					korBlInfoKorVO.setTrnsSeq(transSndChk);
					korBlInfoKorVO.setSmtAmdNo(condVO.getKorBlAmdVO().getSmtAmdNo());
					korBlInfoKorVO.setCstmsBlNo(condVO.getKorBlAmdVO().getBlNo());
					korBlInfoKorVO.setDmstPortCd(condVO.getDmstPortCd());
					korBlInfoKorVO.setCTrnsSeq(condVO.getCTrnsSeq());
					// 전송일시 UPDATE 처리
					command2.transAmdManifest(korBlInfoKorVO);

				} else {
					korBlInfoKorVO.setUserId(condVO.getUserId());
					korBlInfoKorVO.setBkgNo(condVO.getKorBlAmdVO().getBkgNo());
					korBlInfoKorVO.setCstmsDeclTpCd(condVO.getKorBlAmdVO().getCstmsDeclTpCd());
					korBlInfoKorVO.setPortCd(portCd);
					korBlInfoKorVO.setTrnsSeq(condVO.getKorBlAmdVO().getTrnsSeq());
					korBlInfoKorVO.setSmtAmdNo(condVO.getKorBlAmdVO().getSmtAmdNo());
					korBlInfoKorVO.setCstmsBlNo(condVO.getKorBlAmdVO().getBlNo());
					korBlInfoKorVO.setDmstPortCd(condVO.getDmstPortCd());
					korBlInfoKorVO.setCTrnsSeq(condVO.getCTrnsSeq());
				}
				command2.modifySndFlg(korBlInfoKorVO);
				// 성공 메시지 셋팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());

			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0344Event")) {
				// Cancel Per B/L 처리
				EsmBkg0344Event event = (EsmBkg0344Event) e;
				KorCancelManifestTransmitVO condVO = event.getKorCancelManifestTransmitVO();
				command = new KorCustomsTransmissionBCImpl();
				KorManifestListDownloadBC command2 = new KorManifestListDownloadBCImpl();
				KorBlInfoKorVO korBlInfoKorVO = new KorBlInfoKorVO();
				// 파라메터 설정
				condVO.setUserId(account.getUsr_id());
				condVO.setOfcCd(account.getOfc_cd());
				String portCd = null;

				// BC에 작업 요청
				String transSndChk = command.transCancelManifest(condVO);

				if (transSndChk != null) {
					// PORT_CD
					if (condVO.getIoBndCd().equals("O")) {
						portCd = condVO.getPolCd();
					} else {
						portCd = condVO.getPodCd();
					}
					korBlInfoKorVO.setUserId(condVO.getUserId());
					korBlInfoKorVO.setBkgNo(condVO.getBkgNo());
					korBlInfoKorVO.setCstmsDeclTpCd(condVO.getInType());
					korBlInfoKorVO.setPortCd(portCd);
					korBlInfoKorVO.setTrnsSeq(transSndChk);
					korBlInfoKorVO.setCstmsBlNo(condVO.getBlNo());
					// 전송일시 UPDATE 처리
					command2.transAmdManifest(korBlInfoKorVO);
				}
				// 성공 메시지 셋팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());
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
	 * ESM_BKG_0574 : SEARCH<BR>
	 * Scac Report 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainer(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		KorManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0505Event")) {
				EsmBkg0505Event event = (EsmBkg0505Event) e;
				command = new KorManifestListDownloadBCImpl();
				String tpszCd = command.searchContainerType(event.getKorContainerCondVO());
				eventResponse.setETCData("tpsz_cd", tpszCd);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0031Event")) {
				EsmBkg0031Event event = (EsmBkg0031Event) e;
				command = new KorManifestListDownloadBCImpl();
				String tpszCd = command.searchContainerType(event.getKorContainerCondVO());
				eventResponse.setETCData("tpsz_cd", tpszCd);
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1023 : SEARCH <br>
	 * Vessel Stowage Plan Transmit 화면을 조회.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDgCgoManifestList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		KorManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			EsmBkg0212Event event = (EsmBkg0212Event) e;
			command = new KorManifestListDownloadBCImpl();
			// Parameter
			KorDgCgoManifestVO condVO = event.getKorDgCgoManifestVO();
			condVO.setUserId(account.getUsr_id());
			// BC 에 작업 요청
			KorDgCgoManifestVO returnVO = (KorDgCgoManifestVO) command.searchDgCgoManifestList(condVO);
			// 처리 결과 넘김
			if (returnVO.getKorBkgDgCgoVOs() != null)
				eventResponse.setRsVoList((List<KorBkgDgCgoVO>) Arrays.asList(returnVO.getKorBkgDgCgoVOs()));
			if (returnVO.getKorIbDgCgoVOs() != null)
				eventResponse.setRsVoList((List<KorIbDgCgoVO>) Arrays.asList(returnVO.getKorIbDgCgoVOs()));
			if (returnVO.getKorObDgCgoVOs() != null)
				eventResponse.setRsVoList((List<KorObDgCgoVO>) Arrays.asList(returnVO.getKorObDgCgoVOs()));
			if (returnVO.getKorBkgDgVvdVO() != null)
				eventResponse.setETCData(returnVO.getKorBkgDgVvdVO().getColumnValues());
			if (returnVO.getKorDgVvdVO() != null)
				eventResponse.setETCData(returnVO.getKorDgVvdVO().getColumnValues());

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0212 : MULTI <br>
	 * DG Cargo Manifest 정보 수정<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDgCgoManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		KorManifestListDownloadBC command = null;
		try {
			begin();
			EsmBkg0212Event event = (EsmBkg0212Event) e;
			command = new KorManifestListDownloadBCImpl();
			// Parameter
			KorDgCgoManifestCondVO condVO = event.getKorDgCgoManifestCondVO();
			condVO.setUserId(account.getUsr_id());
			// BC 에 작업 요청
			command.manageDgCgoManifest(condVO);
			// 성공 메시지 셋팅
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
	 * ESM_BKG_0217 : MULTI <br>
	 * DG Cargo Manifest 정보 수정<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		KorCustomsTransmissionBC transCommand = new KorCustomsTransmissionBCImpl();;
		KorManifestListDownloadBC maniCommand = new KorManifestListDownloadBCImpl();;

		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0344Event")) {
				EsmBkg0344Event event = (EsmBkg0344Event) e;

				if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
					// Trans Discharge 하선신고
					KorDischManifestTransmitVO condVO = event.getKorDischManifestTransmitVO();
					condVO.setUserId(account.getUsr_id());
					condVO.setOfcCd(account.getOfc_cd());
					transCommand.transmitDischManifest(condVO);
					// 신고후 전송시간 UPDATE
					// E Type인 경우는 전송이력을 남기지 않는다.
					if (!condVO.getNoneBlInType().equals("E")) {
						maniCommand.transmitDischManifest(condVO);
					}

				} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
					// Trans Manifest, Trans per B/L
					KorManifestTransmitVO condVO = event.getKorManifestTransmitVO();
					condVO.setUserId(account.getUsr_id());
					condVO.setOfcCd(account.getOfc_cd());
					transCommand.transmitManifest(condVO);
					// 전송후 UPDATE 처리
					// E Type인 경우는 전송이력을 남기지 않는다.
					if (!condVO.getNoneBlInType().equals("E")) {
						maniCommand.transmitManifest(condVO);
					}
					eventResponse.setUserMessage(new ErrorHandler("BKG00218").getMessage());

				} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
					// Trans Amendment To PA, Trans Cancellation To PA
					KorAmendManifestTransmitVO condVO = event.getKorAmendManifestTransmitVO();
					condVO.setUserId(account.getUsr_id());
					condVO.setOfcCd(account.getOfc_cd());
					String subNo = transCommand.transAmendManifest(condVO);

					// Inbound 이고 ETA가 변경된 경우 전송 UPDATE
					if (condVO.getIoBndCd().equals("I") && condVO.getInChgEta().equals("AI")) {

						KorCorrInfoVO korCorrInfoVO = new KorCorrInfoVO();
						korCorrInfoVO.setSubNo(subNo);
						korCorrInfoVO.setBlNo(condVO.getBlNo());
						korCorrInfoVO.setCBlNo(condVO.getBlNo());
						korCorrInfoVO.setKrCstmsCorrId("AI");
						korCorrInfoVO.setCorrRsn("01");
						korCorrInfoVO.setUserId(condVO.getUserId());
						korCorrInfoVO.setTrnsSeq("1");
						korCorrInfoVO.setPortCd(condVO.getPodCd());
						korCorrInfoVO.setKrVslCallSgnCd(condVO.getVslCallSgnCd());
						korCorrInfoVO.setCallYr(condVO.getEtaDt().substring(0, 4));
						korCorrInfoVO.setCallKnt(condVO.getCallKnt());
						korCorrInfoVO.setVslNm(condVO.getVslNm());
						korCorrInfoVO.setVslRgstCntCd(condVO.getVslCntCd());
						korCorrInfoVO.setIoTmlLocCd(condVO.getIoTmlLocCd());
						korCorrInfoVO.setDchgMzdCd(condVO.getDchgMzdCd());
						korCorrInfoVO.setVvd(condVO.getVvd());

						maniCommand.addSndDtCorrInfo(korCorrInfoVO);
					}
				}
				// 성공메시지 셋팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());

			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0212Event")) {
				// 한국세관 DG Cargo Manifest Transmission
				EsmBkg0212Event event = (EsmBkg0212Event) e;
				if (event.getTransmitMode().equals("DGN")) {
					// Transmit DGN
					KorManifestDGNTransmitVO condVO = event.getKorManifestDGNTransmitVO();
					condVO.setUserId(account.getUsr_id());
					condVO.setOfcCd(account.getOfc_cd());
					// BC에 작업 요청
					transCommand.transmitDGNManifest(condVO);
				} else {
					// Transmit DGL
					KorManifestDGMTransmitVO condVO = event.getKorManifestDGMTransmitVO();
					condVO.setUserId(account.getUsr_id());
					condVO.setOfcCd(account.getOfc_cd());
					// BC에 작업 요청
					DgmManifestVO dgmManifestVO = transCommand.transmitDGMManifest(condVO);

					// 전송후 UPDATE
					ManiDGMTransVO maniDGMTransVO = new ManiDGMTransVO();
					ObjectCloner.build(dgmManifestVO, maniDGMTransVO);
					maniCommand = new KorManifestListDownloadBCImpl();
					maniCommand.transmitDGMManifest(maniDGMTransVO);
				}
				// 성공 메시지 셋팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());

			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0337Event")) {
				// 한국세관 MSN CREATE -> EDI SEND
				EsmBkg0337Event event = (EsmBkg0337Event) e;
				KorMsnCreateVO korMsnCreateVO = event.getKorMrnInfoVO();
				KorManifestMFTTransmitVO condVO = new KorManifestMFTTransmitVO();
				condVO.setUserId(account.getUsr_id());
				condVO.setMrnNo(korMsnCreateVO.getInMrnNo());
				condVO.setMrnChkNo(korMsnCreateVO.getInMrnChkNo());
				condVO.setVslCd(korMsnCreateVO.getInVslCd());
				condVO.setSkdVoyNo(korMsnCreateVO.getInSkdVoyageNo());
				condVO.setSkdDirCd(korMsnCreateVO.getInSkdDirCd());
				condVO.setPortCd(korMsnCreateVO.getInPort());
				// BC에 작업 요청
				transCommand.transmitKorMFTManifest(condVO);

				// 전송 후 UPDATE 처리
				KorManiCondVO korManiCondVO = new KorManiCondVO();
				ObjectCloner.build(condVO, korManiCondVO);
				KorManifestListDownloadBC command2 = new KorManifestListDownloadBCImpl();
				command2.transmitKorMFTManifest(korManiCondVO);

				// 성공 메시지 셋팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00693").getUserMessage());
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
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDownLoadHist(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		KorCustomsReportBC command = null;
		try {
			EsmBkg0215Event event = (EsmBkg0215Event) e;
			command = new KorCustomsReportBCImpl();
			List<BkgCstmsKrDlHisVO> list = command.searchDownLoadHist(event.getCstmsVvdInfoVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1008 : SEARCH<BR>
	 * User Auth List 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode0329(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			BookingUtil comboUtil = new BookingUtil();

			// Upload Status - bkg_upld_sts_cd
			List<BkgComboVO> sc = comboUtil.searchCombo("CD02254");

			List<BkgComboVO> list_sc = new ArrayList<BkgComboVO>();

			BkgComboVO comboVo = new BkgComboVO();
			comboVo.setVal("A");
			comboVo.setName("All");
			comboVo.setDesc("All");
			list_sc.add(comboVo);
			for (int i = 0; i < sc.size(); i++) {
				list_sc.add(sc.get(i));
			}

			eventResponse.setRsVoList(list_sc);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0329 : Retrieve<br>
	 * Manifest Data Daonload - Back End Job Strart
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse startBackEndJobDownloadCstmsBlList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		KorManifestListDownloadBC command = new KorManifestListDownloadBCImpl();
		EsmBkg0329Event event = (EsmBkg0329Event) e;
		try {
			KorDlContainerVO korDlContainerVO = new KorDlContainerVO();
			korDlContainerVO.setKorMrnNoVO(event.getMrnNoVO());
			korDlContainerVO.setKorManifestInfoVOs(event.getManifestInfoVOs());
			korDlContainerVO.setKorBkgCntrQtyInfoVOs(event.getCntrVOs());

			// BACKEND JOB 으로 처리
			begin();
			String backEndJobKey = command.startBackEndJobDownloadCstmsBlList(account, korDlContainerVO);
			commit();
			eventResponse.setETCData("KEY", backEndJobKey);
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0329 : SEARCH<BR>
	 * backEndJobResult 결과 조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse backEndJobResult(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0329Event event = (EsmBkg0329Event) e;
		String strResult = "";
		try {
			String sKey = event.getKey();
			BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(sKey);
			DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();

			while (rowSet.next()) {
				if ("2".equals(rowSet.getString("JB_STS_FLG"))) {
					// BackEndJob 처리중
					strResult = "PROCESSING";
				} else if ("3".equals(rowSet.getString("JB_STS_FLG"))) {
					// 성공메시지세팅
					if (e.getEventName().equalsIgnoreCase("EsmBkg0329Event")) {
						// DOWN LOAD Success
						eventResponse.setUserMessage(new ErrorHandler("BKG01088").getUserMessage());
					}
					strResult = "SUCCESS";
				} else if ("4".equals(rowSet.getString("JB_STS_FLG"))) {
					// 에러메시지세팅
					if (!"".equals(rowSet.getString("JB_USR_ERR_MSG"))) {
						eventResponse.setUserMessage(rowSet.getString("JB_USR_ERR_MSG"));
					} else {
						eventResponse.setUserMessage(new ErrorHandler("BKG00167").getUserMessage());
					}
					strResult = "FAIL";
				}
			}
			eventResponse.setETCData("jb_sts_flg", strResult);

		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
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
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMsnNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		KorManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			EsmBkg0329Event event = (EsmBkg0329Event) e;
			command = new KorManifestListDownloadBCImpl();
			command.manageMsnNo(event.getKorMsnNoCondVOs());
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
	 * 한국세관 InBound Empty Amend 전송
	 *
	 * @param KorEmpAmdManiVO
	 *            [] korEmpAmdManiVOs
	 * @throws EventException
	 */
	private EventResponse manageCrossCheck(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		KorManifestListDownloadBC command = null;
		try {
			begin();
			command = new KorManifestListDownloadBCImpl();
			EsmBkg0329Event event = (EsmBkg0329Event) e;
			command.manageCrossCheck(event.getKorManifestCrsChkInfoVOs(), account);
			commit();
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1152 : SEARCH<BR>
	 * Europe Advanced Manifest - EXS MONITORING 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDiscCYBondInfo(Event e) throws EventException {
		KorManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg0333Event event = (EsmBkg0333Event) e;
			KorDiscCYBondInfoVO korDiscCYBondInfoVO = event.getKorDiscCYBondInfoVO();
			command = new KorManifestListDownloadBCImpl();
			// BC에 작업 요청
			korDiscCYBondInfoVO = (KorDiscCYBondInfoVO) command.searchDiscCYBondInfo(korDiscCYBondInfoVO);
			// 결과 처리
			if (korDiscCYBondInfoVO == null) {
				// 결과값이 없을 경우 오류 리턴
				eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
			} else {
				// 결과를 넘김(ETC DATA 배열로)
				korDiscCYBondInfoVO.setSearchType(event.getKorDiscCYBondInfoVO().getSearchType());
				korDiscCYBondInfoVO.setIoBndCd(event.getKorDiscCYBondInfoVO().getIoBndCd());
				eventResponse.setETCData(korDiscCYBondInfoVO.getColumnValues());
				// 객체로 넘기기 추가
				eventResponse.setRsVo(korDiscCYBondInfoVO);
				if (korDiscCYBondInfoVO.getKorGrpMsnVO() != null) eventResponse.setETCData(korDiscCYBondInfoVO.getKorGrpMsnVO().getColumnValues());
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0333 : MODIFY<BR>
	 * Manifest Transmission Save
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDiscCYBondInfo(Event e) throws EventException {
		KorManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		KorDiscCYBondInfoVO discCYBondInfoVO = null;

		try {
			begin();
			EsmBkg0333Event event = (EsmBkg0333Event) e;
			KorDiscCYBondInfoVO korDiscCYBondInfoVO = event.getKorDiscCYBondInfoVO();
			korDiscCYBondInfoVO.setUsrId(account.getUsr_id());
			command = new KorManifestListDownloadBCImpl();
			// BC에 작업 요청
			discCYBondInfoVO = (KorDiscCYBondInfoVO) command.manageDiscCYBondInfo(korDiscCYBondInfoVO);
			// History 저장 처리
			if (discCYBondInfoVO.getBkgHistVO() != null) {
				// Master 정보 처리
				KorBkgHistVO masterVO = discCYBondInfoVO.getBkgHistVO();
				BkgHisMstVO bkgHistMstVO = new BkgHisMstVO();
				// Parameter 복사
				bkgHistMstVO.setBkgNo(masterVO.getBkgNo());
				bkgHistMstVO.setHisSeq(masterVO.getHistSeq());
				bkgHistMstVO.setCreUsrId(account.getUsr_id());
				bkgHistMstVO.setUpdUsrId(account.getUsr_id());
				bkgHistMstVO.setBkgHisIssUiId("DO");
				// Detail 정보 처리
				KorBkgHistVO detailVO = discCYBondInfoVO.getBkgHistDtlVO();
				BkgHisDtlVO bkgHistDtlVO = new BkgHisDtlVO();
				// Parameter 복사
				ObjectCloner.build(bkgHistMstVO, bkgHistDtlVO);
				bkgHistDtlVO.setHisSeq(detailVO.getHistSeq());
				bkgHistDtlVO.setHisDtlSeq(detailVO.getHistDtlSeq());
				bkgHistDtlVO.setPreCtnt(detailVO.getOldMsnDiscloc());
				bkgHistDtlVO.setCrntCtnt(detailVO.getNewMsnDiscloc());
				// BC에 작업 요청
				BookingHistoryMgtBC command2 = new BookingHistoryMgtBCImpl();
				command2.createBkgHisMst(bkgHistMstVO, bkgHistDtlVO);
			}
			// BLISS, BLDOC 처리
			// MSN_BLTS 가 I 혹은 E 인 경우
			if (korDiscCYBondInfoVO.getMrnBlTsCd().equals("I") || korDiscCYBondInfoVO.getMrnBlTsCd().equals("E")) {
				// BLISS 처리
				BLIssuanceBC command3 = new BLIssuanceBCImpl();
				BkgBlIssVO bkgBlIssVO = new BkgBlIssVO();
				// Parameter 복사
				bkgBlIssVO.setBkgNo(korDiscCYBondInfoVO.getBkgNo());
				bkgBlIssVO.setCstmsEntrCd(korDiscCYBondInfoVO.getCstmsClrTpCd());
				bkgBlIssVO.setCstmsClrLocCd(korDiscCYBondInfoVO.getLocCd());
				bkgBlIssVO.setCstmsClrWhNm(korDiscCYBondInfoVO.getCstmsClrWhCd());
				// BC 에 작업 요청
				command3.modifyIbDtlBlIss(bkgBlIssVO);
				// BLDOC 처리
				BLDocumentationBLBC command4 = new BLDocumentationBLBCImpl();
				BkgBlDocVO bkgBlDocVO = new BkgBlDocVO();
				// Parameter 복사
				bkgBlDocVO.setBkgNo(korDiscCYBondInfoVO.getBkgNo());
				bkgBlDocVO.setIbMfCfmFlg(korDiscCYBondInfoVO.getMfCfmFlg());
				// BC에 작업 요청
				command4.modifyBlDoc(bkgBlDocVO);
			}
			// Wharfage 저장 처리
			BlRatingBC command5 = new BlRatingBCImpl();
			BkgRateVO bkgRateVO = new BkgRateVO();
			// Paramter 셋팅
			bkgRateVO.setBkgNo(korDiscCYBondInfoVO.getBkgNo());
			bkgRateVO.setUpdUsrId(account.getUsr_id());
			bkgRateVO.setCreUsrId(account.getUsr_id());
			bkgRateVO.setBkgRtWhfExptCd(korDiscCYBondInfoVO.getBkgRtWhfExptCd());
			bkgRateVO.setWhfShprRgstNo(korDiscCYBondInfoVO.getWhfShprRgstNo());
			// BC에 작업 요청
			command5.manageWhfExptInfo(bkgRateVO);
			// 성공메시지 셋팅
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
	 * ESM_BKG_0333 : COMMAND01 <br>
	 * BackEndJob 실행 후 결과코드 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse interfaceWhfToArInv(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingARCreationBC command = new BookingARCreationBCImpl();

		try {
			begin();
			EsmBkg0333Event event = (EsmBkg0333Event) e;
			KorDiscCYBondInfoVO korDiscCYBondInfoVO = event.getKorDiscCYBondInfoVO();
			ARBkgInterfaceCreationVO bkgIfVO = new ARBkgInterfaceCreationVO();
			// Parameter 셋팅
			bkgIfVO.setBkgNo(korDiscCYBondInfoVO.getBkgNo());
			bkgIfVO.setUserId(account.getUsr_id());
			bkgIfVO.setManDivInd("B");
			bkgIfVO.setBkgCorrNo(null);
			// BC에 작업 요청
			command.interfaceBKGARInvoiceToINV(bkgIfVO);
			commit();
			// 성공메시지 처리
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());

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
	 * ESM_BKG_03341 : REMOVE<BR>
	 * bkg_hrd_cdg 테이블을 수정한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDiscCYCodeList(Event e) throws EventException {
		KorCustomsReportBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg0334Event event = (EsmBkg0334Event) e;
			command = new KorCustomsReportBCImpl();
			// 파라메터 객체
			KorDischLocCondVO korDischLocCondVO = event.getKorDischLocCondVO();
			// BC에 작업 요청
			KorDischLocVO[] korDischLocVOs = (KorDischLocVO[]) command.searchDischCYCodeList(korDischLocCondVO);
			// 결과 처리
			if (korDischLocVOs == null) {
				// 결과값이 없을 경우 오류 리턴
				eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
			} else {
				eventResponse.setRsVoList((List<KorDischLocVO>) Arrays.asList(korDischLocVOs));
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0334 : MULTI <br>
	 * Discharging CY Code List 추가/수정/삭제<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDiscCYCodeList(Event e) throws EventException {
		KorCustomsReportBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg0334Event event = (EsmBkg0334Event) e;
			KorDischLocCondVO[] korDischLocCondVOs = event.getKorDischLocCondVOs();
			for (int i = 0; i < korDischLocCondVOs.length; i++)
				korDischLocCondVOs[i].setUsrId(account.getUsr_id());
			command = new KorCustomsReportBCImpl();
			// BC에 작업 요청
			command.manageDiscCYCodeList(korDischLocCondVOs);
			// 성공메시지 셋팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
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
	 * ESM_BKG_0335 : SEARCH <br>
	 * 한국/인도 세관에 적하 목록 전송할 때 B/L의 통관 Type Code를 Inquiry<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmEntryTpList(Event e) throws EventException {
		KorCustomsReportBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg0335Event event = (EsmBkg0335Event) e;
			command = new KorCustomsReportBCImpl();
			// BC에 작업 요청
			KorEntryTpVO[] korEntryTpVOs = (KorEntryTpVO[]) command.searchCstmEntryTpList(event.getKorEntryTpCondVO());
			// 결과 처리
			if (korEntryTpVOs == null) {
				// 결과값이 없을 경우 오류 리턴
				eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
			} else {
				eventResponse.setRsVoList((List<KorEntryTpVO>) Arrays.asList(korEntryTpVOs));
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0335 : MULTI <br>
	 * 한국/인도 세관에 적하 목록 전송할 때 B/L의 통관 Type Code 추가/수정/삭제<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCstmEntryTpList(Event e) throws EventException {
		KorCustomsReportBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg0335Event event = (EsmBkg0335Event) e;
			KorEntryTpCondVO[] korEntryTpCondVOs = event.getKorEntryTpCondVOs();
			for (int i = 0; i < korEntryTpCondVOs.length; i++)
				korEntryTpCondVOs[i].setUsrId(account.getUsr_id());
			command = new KorCustomsReportBCImpl();
			// BC에 작업 요청
			command.manageCstmEntryTpList(korEntryTpCondVOs);
			// 성공메시지 셋팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
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
	 * ESM_BKG_0338 : MULTI <br>
	 * 한국세관 Discharging CY Bond Info UPDATE<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMsnBondedInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		KorManifestListDownloadBC command = null;
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0338Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					EsmBkg0338Event event = (EsmBkg0338Event) e;
					command = new KorManifestListDownloadBCImpl();
					KorMsnBondInfoVO[] korMsnBondInfoVOs = (KorMsnBondInfoVO[]) command.searchMsnBondedInfo(event.getKorMsnBondInfoVO());
					if (korMsnBondInfoVOs != null && korMsnBondInfoVOs.length > 0) {
						KorMsnBondInfoVO korMsnBondInfoVO = korMsnBondInfoVOs[0];
						// MSN 첫번째 값 셋팅
						eventResponse.setETCData("msn1", korMsnBondInfoVO.getMsnNo());
						// 조회 결과 리스트 셋팅
						if (event.getKorMsnBondInfoVO().getType().equalsIgnoreCase("LOCAL")) {
							eventResponse.setRsVoList((List<KorBondLocalInfoVO>) Arrays.asList(korMsnBondInfoVO.getBondLocalInfoVOs()));
						} else {
							eventResponse.setRsVoList((List<KorBondTsInfoVO>) Arrays.asList(korMsnBondInfoVO.getBondTsInfoVOs()));
						}
					} else {
						// 결과값이 없을 경우 오류 리턴
						eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
					}
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					// Disch CY validation Check
					EsmBkg0338Event event = (EsmBkg0338Event) e;
					command = new KorManifestListDownloadBCImpl();
					String rv = command.searchDischCyValChk(event.getDischCy());

					eventResponse.setETCData("disc_valid", rv);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					// MSN Assign Check
					EsmBkg0338Event event = (EsmBkg0338Event) e;
					command = new KorManifestListDownloadBCImpl();
					String checkVal = command.searchMsnValChk(event.getBkgCstmsKrMfSeqNoVO());

					if (checkVal == null) checkVal = "X";
					else checkVal = "";
					eventResponse.setETCData("msn_valid", checkVal);
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
	 * ESM_BKG_0338 : MULTI <br>
	 * MSN Bonded Info UPDATE<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyMsnBondedInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		KorManifestListDownloadBC command = null;
		try {
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0338Event")) {
				EsmBkg0338Event event = (EsmBkg0338Event) e;
				command = new KorManifestListDownloadBCImpl();
				KorBondTsInfoVO[] korBondInfoVOs = event.getKorBondInfoVOs();
				// 파라메터 객체 생성
				KorMsnBondInfoVO korMsnBondInfoVO = new KorMsnBondInfoVO();
				korMsnBondInfoVO.setBondTsInfoVOs(korBondInfoVOs);
				BkgCstmsKrMfSeqNoVO[] bkgCstmsKrMfSeqNoVOs = command.modifyMsnBondedInfo(korMsnBondInfoVO);

				// BL_ISS 및 BL_DOC 처리
				if (bkgCstmsKrMfSeqNoVOs != null) {

					BkgBlIssVO bkgBlIssVO = new BkgBlIssVO();
					BLIssuanceBC command2 = new BLIssuanceBCImpl();
					BkgBlDocVO bkgBlDocVO = new BkgBlDocVO();
					BLDocumentationBLBC command3 = new BLDocumentationBLBCImpl();

					// Loop
					for (int i = 0; i < bkgCstmsKrMfSeqNoVOs.length; i++) {
						// Parameter 셋팅
						bkgBlIssVO.setCstmsEntrCd(bkgCstmsKrMfSeqNoVOs[i].getCstmsClrTpCd());
						bkgBlIssVO.setCstmsClrLocCd(bkgCstmsKrMfSeqNoVOs[i].getCstmsClrLocCd());
						bkgBlIssVO.setCstmsClrWhNm(bkgCstmsKrMfSeqNoVOs[i].getCstmsClrWhCd());
						bkgBlIssVO.setBkgNo(bkgCstmsKrMfSeqNoVOs[i].getBkgNo());
						bkgBlIssVO.setUpdUsrId(account.getUsr_id());
						// BC에 작업 요청
						command2.modifyIbDtlBlIss(bkgBlIssVO);

						// Parameter 셋팅
						bkgBlDocVO.setIbMfCfmFlg(bkgCstmsKrMfSeqNoVOs[i].getMsnCfmFlg());
						bkgBlDocVO.setBkgNo(bkgCstmsKrMfSeqNoVOs[i].getBkgNo());
						bkgBlDocVO.setUpdUsrId(account.getUsr_id());
						// BC에 작업 요청
						command3.modifyBlDoc(bkgBlDocVO);
					}
				}
				// 성공메시지 셋팅
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
	 * ESM_BKG_0340 : SEARCH, SEARCH03<br>
	 * ESM_BKG_0341 : SEARCH, SEARCH03<br>
	 * 선박별 인증서 만료일(Certificate Expire Date) 업로드<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDischCYList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		KorCustomsReportBC command = null;
		try {
			// EVENT 에 따른 분리
			if (e.getEventName().equals("EsmBkg0340Event")) {
				// 340 처리
				EsmBkg0340Event event = (EsmBkg0340Event) e;
				command = new KorCustomsReportBCImpl();
				// 작업구분에 따른 처리
				if (event.getFormCommand().isCommand((FormCommand.SEARCH))) {
					// BC에 작업 요청
					KorDischCYVO[] korDischCYVOs = (KorDischCYVO[]) command.searchDischCYList(event.getKorDischCYCondVO());
					// 결과 처리
					if (korDischCYVOs == null) {
						// 결과값이 없을 경우 오류 리턴
						eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
					} else {
						eventResponse.setRsVoList((List<KorDischCYVO>) Arrays.asList(korDischCYVOs));
						// 폼 값 처리
						eventResponse.setETCData("mrn_no", korDischCYVOs[0].getMrnNo());
						eventResponse.setETCData("mrn_chk_no", korDischCYVOs[0].getMrnChkNo());
						eventResponse.setETCData("vvd", korDischCYVOs[0].getVvd());
						eventResponse.setETCData("port_cd", korDischCYVOs[0].getPortCd());
					}
				} else if (event.getFormCommand().isCommand(
						(FormCommand.SEARCH03))) {
					// BC에 작업 요청
					KorDischPrintListVO[] korDischPrintListVOs = (KorDischPrintListVO[]) command.searchDischPrintList(event.getKorDischPrintCondVOs());
					// 결과 처리
					if (korDischPrintListVOs == null) {
						// 결과값이 없을 경우 오류 리턴
						eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
					} else {
						eventResponse.setRsVoList((List<KorDischPrintListVO>) Arrays.asList(korDischPrintListVOs));
					}
				}
			} else if (e.getEventName().equals("EsmBkg0341Event")) {
				// 341 처리
				EsmBkg0341Event event = (EsmBkg0341Event) e;
				// 작업구분에 따른 처리
				if (event.getFormCommand().isCommand((FormCommand.SEARCH))) {

					// OUT BOUND 의 경우는 MSN 정보를 만들어 준다.
					if (event.getKorDischCYCondVO().getIoBndCd().equals("O")) {
						// DownLoad BC 생성
						KorManifestListDownloadBC command2 = new KorManifestListDownloadBCImpl();

						// Parameter 용 객체
						ObMsnInfoCondVO obMsnInfoCondVO = new ObMsnInfoCondVO();
						ObjectCloner.build(event.getKorDischCYCondVO(), obMsnInfoCondVO);
						obMsnInfoCondVO.setUserId(account.getUsr_id());
						begin();
						// BC 에 작업 요청
						command2.manageObMsnInfo(obMsnInfoCondVO);
						commit();

					}

					command = new KorCustomsReportBCImpl();
					// BC에 작업 요청
					KorDischCYVO[] korDischCYVOs = (KorDischCYVO[]) command.searchDischCYList(event.getKorDischCYCondVO());

					// 결과 처리
					if (korDischCYVOs == null) {
						// 결과값이 없을 경우
						eventResponse.setETCData("vvd", event.getKorDischCYCondVO().getVslCd()
								+ event.getKorDischCYCondVO().getSkdVoyNo()
								+ event.getKorDischCYCondVO().getSkdDirCd());
						eventResponse.setETCData("port_cd", event.getKorDischCYCondVO().getPortCd());
					} else {
						eventResponse.setRsVoList((List<KorDischCYVO>) Arrays.asList(korDischCYVOs));
						// 폼 값 처리
						eventResponse.setETCData("mrn_no", korDischCYVOs[0].getMrnNo());
						eventResponse.setETCData("mrn_chk_no", korDischCYVOs[0].getMrnChkNo());
						eventResponse.setETCData("vvd", korDischCYVOs[0].getVvd());
						eventResponse.setETCData("port_cd", korDischCYVOs[0].getPortCd());
					}
				} else if (event.getFormCommand().isCommand(
						(FormCommand.SEARCH03))) {
					command = new KorCustomsReportBCImpl();
					// BC에 작업 요청
					KorImpPrintListVO[] korImpPrintListVOs = (KorImpPrintListVO[]) command.searchImpCgoManiPrtList(event.getKorImpPrintCondVOs());
					// 결과 처리
					if (korImpPrintListVOs == null) {
						// 결과값이 없을 경우 오류 리턴
						eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
					} else {
						eventResponse.setRsVoList((List<KorImpPrintListVO>) Arrays.asList(korImpPrintListVOs));
					}
				}
			}

		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0344 : MODIFY<br>
	 * ANCS EDI 수신 메시징 에 대한 로깅 처리.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyManifestSummaryInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			EsmBkg0344Event event = (EsmBkg0344Event) e;
			KorManifestListDownloadBC command = new KorManifestListDownloadBCImpl();
			KorManifestSmryCondVO korManifestSmryCondVO = event.getKorManifestSmryCondVO();
			// USERID
			korManifestSmryCondVO.setUserId(account.getUsr_id());
			// BC에 작업 요청
			command.modifyManifestSummaryInfo(korManifestSmryCondVO);
			commit();
			// 성공메시지세팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
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
	 * ESM_BKG_0344 : REMOVE<BR>
	 * Manifest Transmission 관련해서 Delete<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageManifestSummaryInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		KorManifestListDownloadBC command = new KorManifestListDownloadBCImpl();
		EsmBkg0344Event event = (EsmBkg0344Event) e;
		try {
			begin();
			// 파라메터
			KorManiSumCondVO condVO = event.getKorManiSumCondVO();
			// ID, OFC_CD 넣기
			condVO.setUserId(account.getUsr_id());
			condVO.setOfcCd(account.getOfc_cd());
			// BC 에 작업 요청
			command.manageManifestSummaryInfo(condVO);
			commit();
			// 성공메시지 셋팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00593").getUserMessage());
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
	 * ESM_BKG_0345 : SEARCH<BR>
	 * WareHouse Info 목록조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWareHouseInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		KorCustomsReportBC command = null;
		EsmBkg0345Event event = (EsmBkg0345Event) e;
		try {
			command = new KorCustomsReportBCImpl();
			// BC에 작업 요청
			KorWareHouseVO[] korWareHouseVOs = (KorWareHouseVO[]) command.searchWareHouseInfo(event.getKorWareHouseCondVO());
			// 결과 처리
			if (korWareHouseVOs == null) {
				// 결과값이 없을 경우 오류 리턴
				eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
			} else {
				eventResponse.setRsVoList((List<KorWareHouseVO>) Arrays.asList(korWareHouseVOs));
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0345 : INIT <br>
	 * 화면 로딩시 최초데이터 로딩<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTransCancellInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0346Event event = (EsmBkg0346Event) e;
		try {
			eventResponse.setRsVo(event.getKorTransCancellCustVO());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 *
	 * ESM_BKG_0346 : MULTI01<br>
	 * Korea 세관에 신고 된 적하목록을 삭제하는 Manifest를 전송하기 위해 FlatFile을 생성한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitCancellKR(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		KorCustomsTransmissionBC command = null;

		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0346Event")) {
				// 한국 EDI FLAT FILE 생성 및 전송
				EsmBkg0346Event event = (EsmBkg0346Event) e;
				command = new KorCustomsTransmissionBCImpl();

				KorManifestCancelTransmitVO transmitVO = (KorManifestCancelTransmitVO) event.getManifestTransmitVO();

				KorTransCancellCustVO custVO = transmitVO.getKorTransCancellCustVO();
				custVO.setOfcCd(account.getOfc_cd());
				custVO.setUserId(account.getUsr_id());

				command.transmitCancellKR(transmitVO);
				// 성공메시지 셋팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());
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
	 * ESM_BKG_0358 : SEARCH<br>
	 * EU 세관 전송을 위한 VVD 와 POD 별 B/L 내역 조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchMRNNoList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		KorCustomsReportBC command = null;
		EsmBkg0358Event event = (EsmBkg0358Event) e;
		try {
			command = new KorCustomsReportBCImpl();
			// BC에 작업 요청
			KorMrnVO[] korMrnVOs = (KorMrnVO[]) command.searchMRNNoList(event.getKorMrnCondVO());
			// 결과 처리
			if (korMrnVOs == null) {
				// 결과값이 없을 경우 오류 리턴
				eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
			} else {
				eventResponse.setRsVoList((List<KorMrnVO>) Arrays.asList(korMrnVOs));
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0371 : SEARCH <br>
	 * MRN 정보 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMrnInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		KorCustomsTransmissionBC command = new KorCustomsTransmissionBCImpl();
		EsmBkg0371Event event = (EsmBkg0371Event) e;
		try {
			eventResponse.setRsVoList(command.searchMrnCreateInfo(event.getKorMrnCreateInfoCondVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0371 : MULTI, REMOVE<br>
	 * Hold Notice를 송부를 위하여 Customs에서 받는 특정 Code를 등록 및 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMrnCreateInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		KorManifestListDownloadBC manifestCommand = new KorManifestListDownloadBCImpl();
		EsmBkg0371Event event = (EsmBkg0371Event) e;
		try {
			begin();
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				// Validation
				new KorCustomsTransmissionBCImpl().validateMrnCreateInfo(event.getKorMrnCreateInfoVOs());
				// INSERT
				manifestCommand.manageMrnCreateInfo(event.getKorMrnCreateInfoVOs(), account, (String)event.getAttribute("ff_div"));  //◁◁◁◁◁◁◁◁◁◁///////////////////////////

			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				// DELETE
				manifestCommand.removeMrnMsnCreateInfo(event.getKorMrnCreateInfoVOs());
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
	 * ESM_BKG_0502 : SEARCH, SEARCH01, SEARCH02 <br>
	 * MSN Bonded Info 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTransmitHist(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0502Event")) {
				EsmBkg0502Event event = (EsmBkg0502Event) e;
				KorCustomsReportBC command2 = new KorCustomsReportBCImpl();
				KorReportHistContainerVO histContainer = (KorReportHistContainerVO) command2.searchTransmitHist((ReportHistCondVO) event.getKorTransHistVO());
				List<KorTransHistVO> list = histContainer.getKorTransHistVOs();
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
	 * ESM_BKG_0503 : IBSEARCH <br>
	 * Export Vessel List를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTransCrossChk(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		KorCustomsTransmissionBC command = null;
		try {
			EsmBkg0503Event event = (EsmBkg0503Event) e;

			command = new KorCustomsTransmissionBCImpl();
			List<KorTransCrossChkDtlVO> list = command.searchTransCrossChk(event.getKorTransCrossChkCondVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0484 : ENS Download <br>
	 * ENS Download (Excel)
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTempBlNoNBkgNoAssign(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		KorManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			// 처리용 객체
			KorTmpBlBkgVO tmpBlBkgVO = new KorTmpBlBkgVO();
			command = new KorManifestListDownloadBCImpl();
			tmpBlBkgVO.setUserId(account.getUsr_id());
			tmpBlBkgVO.setOfcCd(account.getOfc_cd());
			tmpBlBkgVO = (KorTmpBlBkgVO) command.searchTempBlNoNBkgNoAssign(tmpBlBkgVO);
			eventResponse.setETCData("bkg_no", tmpBlBkgVO.getBkgNo());
			eventResponse.setETCData("bl_no", tmpBlBkgVO.getBlNo());
			commit();
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0257 : SEARCH05 <br>
	 * GB지역 UVI정보를 찾아온다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReceiveHist(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		KorCustomsReportBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0917Event")) {
				// 한국세관 세관 수신 내역 조회
				EsmBkg0917Event event = (EsmBkg0917Event) e;
				command = new KorCustomsReportBCImpl();
				// BC에 작업 요청
				KorRcvHistVO[] korRcvHistVOs = (KorRcvHistVO[]) command.searchReceiveAckHist(event.getKorRcvHistCondVO());
				// 결과 값이 있을 경우 넘김
				if (korRcvHistVOs != null && korRcvHistVOs.length > 0) {
					List<KorRcvHistVO> list = Arrays.asList(korRcvHistVOs);
					eventResponse.setRsVoList(list);
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
	 * EsmBkgUdevComOpusBkgEntryEvent<br>
	 * EsmBkgUdevComOpusBkgEntryEvent<br>
	 * UbizComOpusBkgKrcusAckEvent<br>
	 * 한국세관 Manifest 신고 등록시 Warehouse(Bonded Area) Detail을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse loadCstmsRcvMsg(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		KorCustomsTransmissionBC command = null;
		KorManifestListDownloadBC command2 = null;
		try {
			// if (!e.getEventName().equalsIgnoreCase("Ubiz2comOpusBkgAmsAckEvent")) {
			begin();
			// }
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkgUdevComOpusBkgEntryEvent")) { // Kor - 배정정보 수신
				EsmBkgUdevComOpusBkgEntryEvent event = (EsmBkgUdevComOpusBkgEntryEvent) e;
				command2 = new KorManifestListDownloadBCImpl();
				KorRcvMsgVO korRcvMsgVO = new KorRcvMsgVO();
				korRcvMsgVO.setFlatFile(event.getFlatFile());
				command2.loadCstmsRcvMsg(korRcvMsgVO);

			} else if (e.getEventName().equalsIgnoreCase("EsmBkgUdevComOpusBkgKrcusEvent")) { // Kor - 한국세관 ACK 수신
				EsmBkgUdevComOpusBkgKrcusEvent event = (EsmBkgUdevComOpusBkgKrcusEvent) e;
				command = new KorCustomsTransmissionBCImpl();
				KorRcvAckMsgVO korRcvAckMsgVO = new KorRcvAckMsgVO();
				korRcvAckMsgVO.setFlatFile(event.getFlatFile());
				command.loadCstmsRcvMsg(korRcvAckMsgVO);

			} else if (e.getEventName().equalsIgnoreCase("UbizComOpusBkgKrcusAckEvent")) { // Kor - 한국세관 PORTAL 수신
				UbizComOpusBkgKrcusAckEvent event = (UbizComOpusBkgKrcusAckEvent) e;
				command = new KorCustomsTransmissionBCImpl();
				KorRcvAckMsgVO korRcvAckMsgVO = new KorRcvAckMsgVO();
				korRcvAckMsgVO.setFlatFile(event.getFlatFile());
				command.loadCstmsRcvMsg(korRcvAckMsgVO);
			}
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
	 * ESM_BKG_0989 : SEARCH <br>
	 * KOREA에서 입/출항 선박 신고 적하목록 전송 문서의 상세 내역 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTransmitHistDtl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		KorCustomsReportBC command = null;
		EsmBkg0989Event event = (EsmBkg0989Event) e;
		try {
			command = new KorCustomsReportBCImpl();
			// BC에 작업 요청
			KorTransmitHistDtlVO[] korTransmitHistDtlVOs = (KorTransmitHistDtlVO[]) command.searchTransmitHistDtl(event.getKorTransmitHistDtlCondVO());
			// 결과 처리
			if (korTransmitHistDtlVOs == null) {
				// 결과값이 없을 경우 오류 리턴
				eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
			} else {
				eventResponse.setRsVoList((List<KorTransmitHistDtlVO>) Arrays.asList(korTransmitHistDtlVOs));
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

}

