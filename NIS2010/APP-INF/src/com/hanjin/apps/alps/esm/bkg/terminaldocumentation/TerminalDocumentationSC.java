/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : TerminalDocumentationSC.java
 *@FileTitle : TerminalDocumentationSC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.11
 *@LastModifier : 경종윤
 *@LastVersion : 1.0
 * 2009.04.21 경종윤
 * 1.0 Creation
 * -------------------------------------------------------
 * History
 * 2011.11.10 민정호 [CHM-201114288] Container Loadign Cross-Check (KOR) 기능 추가 요청
 * 2012.08.17 김보배 [CHM-201219430] [BKG] COPRAR (Pre-S/O) EDI 보완건
 * 2012.09.21 김보배 [CHM-201220211] [BKG] Load Summary by POD 상 Special Stowage Type 추가
 * 2012.10.30 채창호 [CHM-201220810][BKG][CLL/CDL] W/O Flag추가, Transmission MSG변경
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.basic.CLLCDLManifestBC;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.basic.CLLCDLManifestBCImpl;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0155Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0159Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0164Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0617Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0641Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0723Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0904Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0915Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0916Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0930Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0931Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0932Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0933Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0951Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg1056Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg1136Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg1153Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkgUdevhjsAlpsBkgCllAckEvent;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestCllCdlForODCYVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestEdiTerminalInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestKorCllRemarkInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestLoadSumByPodDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestSpclCgoSumByPodDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestSpclStowRqstByPodDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestVslSkdInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CdlDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllCdlCheckListDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllCdlCheckUsaVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllDgCgoDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllRfAkCgoDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.ExCntrTransmitVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCdlDetailContainerVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCdlDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCrossChkCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllLoadSumDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllSpclCgoContainerVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllSpclCgoSumDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllSpclStowRqstDetail2VO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllSpclStowRqstDetail3VO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllSpclStowRqstDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllSppDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllSumDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.PreAdviceManifestListVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.PreAdviceVvdInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.basic.PSAManifestBC;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.basic.PSAManifestBCImpl;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.event.EsmBkg0389Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.event.EsmBkg0420Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.event.EsmBkg0575Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.event.EsmBkg0576Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.event.EsmBkg0582Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.event.EsmBkg0979Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.event.EsmBkg1012Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.event.EsmBkg1013Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.event.EsmBkg1028Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.ImpStsSpclCgoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaImpStsVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaImportVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaJurongIfVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaPortVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaTsVVDListVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaUnmatchBkgCntrVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaUnmatchListVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaUnmatchPsaCntrVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaVvdVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.basic.PSASpecialManifestBC;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.basic.PSASpecialManifestBCImpl;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.event.AlpsbkgTPsacusAckEven;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.event.EsmBkg0573Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.event.EsmBkg0577Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.event.EsmBkg0578Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADgListCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADgListDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSASendHistoryDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSASpecialContainerVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.basic.SpecialManifestBC;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.basic.SpecialManifestBCImpl;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.event.AlpsbkgTEurbaplieEvent;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.event.AlpsbkgTEurcusAckEven;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.event.EsmBkg0965Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.event.EsmBkg0967Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.event.EsmBkg0969Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.event.EsmBkg0970Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.event.EsmBkg0977Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.event.EsmBkg1091Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.event.EsmBkg1097Event;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.BayPlanListDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.BayPlanListVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.DgCntrInfoListVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.DgInqModiVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.DgListCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.DgListDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.FeederInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.FeederNameVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.FwdrListVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.SendHistoryDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.SpecialContainerVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.SpecialListDetailVO;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MdmCntrTpSzVO;
/**
 * NIS2010-TerminalDocumentation Business Logic ServiceCommand -f
 * NIS2010-TerminalDocumentation 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Kyoung Jong Yung
 * @see SpecialManifest
 * @since J2EE 1.4
 */

public class TerminalDocumentationSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CustomsDeclaration system 업무 시나리오 선행작업<br>
	 * ESM_BKG-0017업무 시나리오 호출시 관련 내부객체 생성<br>
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
	 * CustomsDeclaration system 업무 시나리오 마감작업<br>
	 * ESM_BKG-0017 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("TerminalDocumentationSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-CustomsDeclaration system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmBkg0969Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchForwarderList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageForwarderList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0963Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBayPlanList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1091Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBayPlanDetailList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0951Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchKorCllSummary(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0965Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchIstowageInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchDgManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchVesselName(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchYardName(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchDgLocalSaveYn(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchDgListCopyYn(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchDgFeederNameList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDgManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { 
				// 위험물 EDI 전송
				eventResponse = sendDgManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) { 
				// 입력시 validation(bl_no / pol_cd / pod_cd)
				eventResponse = searchDgValidationByVvdKey(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) { 
				// 입력시 validation(cntr_no)
				eventResponse = searchDgValidationByCntrKey(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) { 
				// B/L No.로  BKG의 위험물 테이블에서 데이타를 조회해온다.
				eventResponse = searchDgInfoAtBkgDgByBlNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) { 
				// 위험물 대상을 조회해한(세관 쪽에 등록이 안된 booking쪽 데이타만 조회한다.
				eventResponse = searchAppendDgInfoAtBkgDg(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0930Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchKorCll(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageKorCll(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitKorCll(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				GeneralEventResponse response = new GeneralEventResponse();
				response.setRsVoList(searchComCodeCombo("CD02146"));
				eventResponse = response;
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0977Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSpecialList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSpecialList(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0931Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchKorCll(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0967Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCntrInfoListByBl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCgoSeqListByCntr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchDgCargoInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchForwarderName(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchUnnoName(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchDgFeederNameList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = manageDgManifestList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0932Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchKorCllSummary(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageKorCllRemark(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchKorCllSpecialCgo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchKorCll(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0970Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSendHistory(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0933Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchKorCllSpecialCgo(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0575Event")) {
			// PSA Vessel Regist 조회
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)
					|| e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchPSAVslRegist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				// SAVE 처리
				eventResponse = managePSAVVDInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1028Event")
				|| e.getEventName().equalsIgnoreCase("EsmBkg1013Event")) {
			// PSA Vessel Regist Import Schedule 조회
			eventResponse = searchPSAVVD(e);
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0159Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchMdmCntrTpSz(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchKorCllCdl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCllForDownload(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCllCdlForODCY(e);
			}
			
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0576Event")) {
			// PSA Container Booking I/F History
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPSACNTRBKGHist(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0979Event")) {
			// PSA Container Booking I/F History Log Pop Up
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPSAStatusLog(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0582Event")) {
			// PSA Port Register
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPSAPortList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePSAPortList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0420Event")) {
			// PSA Import Status I/F
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				// 조회
				eventResponse = searchPSAImpSts(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				// 수정
				eventResponse = managePSAImpSts(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				// Transmit
				eventResponse = transmitPSAImpStsInfo(e);
		   	}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)){ 
			    eventResponse = backEndJobResult(e);
			   }
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1012Event")) {
			// PSA Special Cargo Info
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				// 조회
				eventResponse = searchPSAImpoStsSpclCgo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				// 추가,수정,삭제
				eventResponse = managePSAImpStsSpclCgo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0161Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				GeneralEventResponse response = new GeneralEventResponse();
				response.setRsVoList(searchComCodeCombo("CD02298"));
				response.setRsVoList(searchComCodeCombo3("CD02196"));
				response.setRsVoList(searchComCodeCombo3("CD02347"));
				response.setRsVoList(searchComCodeCombo("CD02377"));
				eventResponse = response;
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0155Event")) {
			// PSA Special Cargo Info
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				// 조회
				eventResponse = searchCll(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				// 추가,수정,삭제
				eventResponse = manageCll(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("AlpsbkgTEurbaplieEvent")
				|| e.getEventName().equalsIgnoreCase("AlpsbkgTEurcusAckEven")) {
				eventResponse = loadCstmsRcvMsg(e);
		} else if (e.getEventName().equalsIgnoreCase("AlpsbkgTPsacusAckEven")) {
			   eventResponse = loadCstmsRcvMsg(e);
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1056Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchKorCllSppList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageKorCllSppList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0915Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCllDgCgo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCllDgCgo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0916Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCllRfAkCgo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyCllRfAkCgo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0723Event")) {

			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEdiTerminal(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitCllCdl(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03))
			{
				eventResponse = backEndJobResult(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0641Event")) {

			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCdl(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0904Event")) {

			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCntrExportInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitCntrExportEdi(e);
			} else {
				GeneralEventResponse response = new GeneralEventResponse();
				// Code Operation
				response.setRsVoList(searchComCodeCombo("CD01616"));
				// Haulage Mode
				response.setRsVoList(searchComCodeCombo("CD02217"));
				eventResponse = response;
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0164Event")) {

			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCllCdlCheckForUS(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0617Event")) {

			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCllCdlCheckList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0389Event")) {
			// ALPS vs Portnet Reconciliation
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				// 조회
				eventResponse = searchUnmatchList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				// VVD 목록 조회
				eventResponse = searchPSATsVVDList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				// Jurong I/F 처리
				eventResponse = parseJurongIF(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				// Save 처리
				eventResponse = manageUnmatchList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase(
				"EsmBkgUdevhjsAlpsBkgCllAckEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = receiveUdevhjsAlpsBkgCllAck(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1097Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFeederInfoList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageFeederInfoList(e);
			}
		}  else if (e.getEventName().equalsIgnoreCase("EsmBkg0577Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPsaDgManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { 
				// 위험물 EDI 전송
				eventResponse = psaSendDgManifestList(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0573Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPsaSendHistory(e);
			}

		} else if(e.getEventName().equalsIgnoreCase("EsmBkg1136Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchKorCllCrossCheck(e);
			}			
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0578Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPsaReceiveHistory(e);
			}

		} else if(e.getEventName().equalsIgnoreCase("EsmBkg1153Event")){
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchPreAdviceVvdInfo(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
 				eventResponse = searchPreAdviceManifestList(e);
			}
		}
		return eventResponse;
	}

	/**
	 * com_intg_cd_dtl Table 조회<br>
	 * 
	 * @param String comCode
	 * @return List<BkgComboVO>
	 * @exception EventException
	 */
	private List<BkgComboVO> searchComCodeCombo(String comCode)
			throws EventException {
		
		BookingUtil bkgUtil = null;
		List<BkgComboVO> list = null;
		
		try {

			bkgUtil = new BookingUtil();
			list = bkgUtil.searchCombo(comCode);
			
			for (int j = 0; j < list.size(); j++) {
				// 콤보 Text에 value + Name으로 보여주는 경우 사용
				list.get(j).setDesc(
						list.get(j).getVal() + " " + list.get(j).getName());
			}
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),ex);
		}
		
		return list;
	}
	
	/**
	 * com_intg_cd_dtl Table 조회<br>
	 * 
	 * @param String comCode
	 * @return List<BkgComboVO>
	 * @exception EventException
	 */
	private List<BkgComboVO> searchComCodeCombo3(String comCode)
			throws EventException {
		
		BookingUtil bkgUtil = null;
		List<BkgComboVO> list = null;
		
		try {

			bkgUtil = new BookingUtil();
			list = bkgUtil.searchCombo(comCode);
			
	
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),ex);
		}
		
		return list;
	}	
	
	/**
	 * com_intg_cd_dtl Table 조회<br>
	 * 
	 * @param String comCode
	 * @return List<BkgComboVO>
	 * @exception EventException
	 */
	private List<BkgComboVO> searchComCodeCombo2(String comCode)
			throws EventException {
		
		BookingUtil bkgUtil = null;
		List<BkgComboVO> list = null;
		
		try {

			bkgUtil = new BookingUtil();
			list = bkgUtil.searchCombo(comCode);
			
			for (int j = 0; j < list.size(); j++) {
				// 콤보 Text에 value + Name으로 보여주는 경우 사용
				list.get(j).setDesc(
						list.get(j).getVal() + " " + list.get(j).getDesc());
			}
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),ex);
		}
		
		return list;
	}	

	/**
	 * ESM_BKG_0969 : SEARCH
	 * 포워더 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchForwarderList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		List<FwdrListVO> list = null;
		try {
			if ("EsmBkg0969Event".equalsIgnoreCase(e.getEventName())) {

				command = new SpecialManifestBCImpl();

				EsmBkg0969Event event = (EsmBkg0969Event) e;

				list = command.searchForwarderList(event.getFwdrListCondVO());

				eventResponse.setRsVoList(list);

			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;

	}

	/**
	 * ESM_BKG_0969 : MULTI
	 * 포워더 코드 및 desc정보를 입력한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageForwarderList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;

		try {
			this.begin();
			if ("EsmBkg0969Event".equalsIgnoreCase(e.getEventName())) {

				command = new SpecialManifestBCImpl();

				EsmBkg0969Event event = (EsmBkg0969Event) e;

				command.manageForwarderList(event.getFwdrListVO(), account);

			}
			this.commit();
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
	 * ESM_BKG_0963 : SEARCH
	 * Stowage code 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBayPlanList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		List<BayPlanListVO> list = null;
		try {
			if ("EsmBkg0963Event".equalsIgnoreCase(e.getEventName())) {

				command = new SpecialManifestBCImpl();

				list = command.searchBayPlanList();

				eventResponse.setRsVoList(list);

			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;

	}

	/**
	 * ESM_BKG_1091 : SEARCH
	 * Stowage code 상세 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBayPlanDetailList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		List<BayPlanListDetailVO> list = null;
		try {
			if ("EsmBkg1091Event".equalsIgnoreCase(e.getEventName())) {
				EsmBkg1091Event event = (EsmBkg1091Event) e;
				command = new SpecialManifestBCImpl();

				list = command.searchBayPlanDetailListByBaiId(event.getBayPlanCondVO());

				eventResponse.setRsVoList(list);

			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;

	}
	
	/**
	 * ESM_BKG_0951 : SEARCH
	 * ESM_BKG_0932 : SEARCH
	 * POL 터미널에 전송할 Container Loading List(Korea)의 Summay 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchKorCllSummary(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CLLCDLManifestBC command = new CLLCDLManifestBCImpl();
		List<KorCllSumDetailVO> list = null;
		try {
			if ("EsmBkg0951Event".equalsIgnoreCase(e.getEventName())) {
				EsmBkg0951Event event = (EsmBkg0951Event) e;
				Map<String, String> etcData = new HashMap<String, String>();

				list = command.searchKorCllSummary(event.getKorCllCondVO());
				if (list.size() > 0) {
					KorCllSumDetailVO korCllSumDetailVO = list.get(0);
					if (korCllSumDetailVO.getCLLCDLManifestVslSkdInfoVOs()
							.size() > 0) {
						CLLCDLManifestVslSkdInfoVO cLLCDLManifestVslSkdInfoVO = korCllSumDetailVO
								.getCLLCDLManifestVslSkdInfoVOs().get(0);

						List<CLLCDLManifestLoadSumByPodDetailVO> cLLCDLManifestLoadSumByPodDetailVOs = korCllSumDetailVO
								.getCLLCDLManifestLoadSumByPodDetailVOs();
						eventResponse
								.setRsVoList(cLLCDLManifestLoadSumByPodDetailVOs);

						List<CLLCDLManifestSpclCgoSumByPodDetailVO> cLLCDLManifestSpclCgoSumByPodDetailVOs = korCllSumDetailVO
								.getCLLCDLManifestSpclCgoSumByPodDetailVOs();
						eventResponse
								.setRsVoList(cLLCDLManifestSpclCgoSumByPodDetailVOs);

//						List<CLLCDLManifestSpclStowRqstByPodDetailVO> cLLCDLManifestSpclStowRqstByPodDetailVOs = korCllSumDetailVO
//								.getCLLCDLManifestSpclStowRqstByPodDetailVOs();
//						eventResponse
//								.setRsVoList(cLLCDLManifestSpclStowRqstByPodDetailVOs);
						List<KorCllSpclStowRqstDetailVO> korCllSpclStowRqstDetailVOs = korCllSumDetailVO
								.getKorCllSpclStowRqstDetailVOs();
						eventResponse.setRsVoList(korCllSpclStowRqstDetailVOs);
						List<KorCllSpclStowRqstDetail2VO> korCllSpclStowRqstDetail2VOs = korCllSumDetailVO
								.getKorCllSpclStowRqstDetail2VOs();
						eventResponse.setRsVoList(korCllSpclStowRqstDetail2VOs);
						List<KorCllSpclStowRqstDetail3VO> korCllSpclStowRqstDetail3VOs = korCllSumDetailVO
								.getKorCllSpclStowRqstDetail3VOs();
						eventResponse.setRsVoList(korCllSpclStowRqstDetail3VOs);


						eventResponse.setETCData("vvd_cd",	cLLCDLManifestVslSkdInfoVO.getVvdCd());
						eventResponse.setETCData("un_loc_cd",cLLCDLManifestVslSkdInfoVO.getUnLocCd());
						eventResponse.setETCData("vps_etd_dt",	cLLCDLManifestVslSkdInfoVO.getVpsEtdDt());
					} else {
						eventResponse.setETCData("vvd_cd", "");
						eventResponse.setETCData("un_loc_cd", "");
						eventResponse.setETCData("vps_etd_dt", "");
						eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
					}
				} else {
					eventResponse.setETCData("vvd_cd", "");
					eventResponse.setETCData("un_loc_cd", "");
					eventResponse.setETCData("vps_etd_dt", "");
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
				}

				eventResponse.setETCData(etcData);
			} else if ("EsmBkg0932Event".equalsIgnoreCase(e.getEventName())) {
				EsmBkg0932Event event = (EsmBkg0932Event) e;
				Map<String, String> etcData = new HashMap<String, String>();

				list = command.searchKorCllSummary(event.getKorCllCondVO());

				if (list.size() > 0) {
					KorCllSumDetailVO korCllSumDetailVO = list.get(0);
					if (korCllSumDetailVO.getCLLCDLManifestVslSkdInfoVOs()
							.size() > 0) {
						CLLCDLManifestVslSkdInfoVO cLLCDLManifestVslSkdInfoVO = korCllSumDetailVO
								.getCLLCDLManifestVslSkdInfoVOs().get(0);

						List<KorCllLoadSumDetailVO> korCllLoadSumDetailVOs = korCllSumDetailVO
								.getKorCllLoadSumDetailVOs();
						eventResponse.setRsVoList(korCllLoadSumDetailVOs);

						List<KorCllSpclCgoSumDetailVO> korCllSpclCgoSumDetailVOs = korCllSumDetailVO
								.getKorCllSpclCgoSumDetailVOs();
						eventResponse.setRsVoList(korCllSpclCgoSumDetailVOs);

						List<KorCllSpclStowRqstDetailVO> korCllSpclStowRqstDetailVOs = korCllSumDetailVO
								.getKorCllSpclStowRqstDetailVOs();
						eventResponse.setRsVoList(korCllSpclStowRqstDetailVOs);
						List<KorCllSpclStowRqstDetail2VO> korCllSpclStowRqstDetail2VOs = korCllSumDetailVO
								.getKorCllSpclStowRqstDetail2VOs();
						eventResponse.setRsVoList(korCllSpclStowRqstDetail2VOs);
						List<KorCllSpclStowRqstDetail3VO> korCllSpclStowRqstDetail3VOs = korCllSumDetailVO
								.getKorCllSpclStowRqstDetail3VOs();
						eventResponse.setRsVoList(korCllSpclStowRqstDetail3VOs);

						List<CLLCDLManifestKorCllRemarkInfoVO> cLLCDLManifestKorCllRemarkInfoVOs = korCllSumDetailVO
								.getCLLCDLManifestKorCllRemarkInfoVOs();

						eventResponse.setETCData("vvd_cd_nm",
								cLLCDLManifestVslSkdInfoVO.getVvdCd3());
						eventResponse.setETCData("pol_cd_print", event
								.getKorCllCondVO().getInPolCd()+event
								.getKorCllCondVO().getInPolYdCd());
						eventResponse.setETCData("vps_etd",
								cLLCDLManifestVslSkdInfoVO.getVpsEtdDt());
						if (cLLCDLManifestKorCllRemarkInfoVOs != null) {
							eventResponse.setETCData("setText1",
									cLLCDLManifestKorCllRemarkInfoVOs.get(0)
											.getToDiffRmk());
							eventResponse.setETCData("setText2",
									cLLCDLManifestKorCllRemarkInfoVOs.get(0)
											.getFmDiffRmk());
							eventResponse.setETCData("remark",
									cLLCDLManifestKorCllRemarkInfoVOs.get(0)
											.getRemarkDiffRmk());
						}
					} else {
						eventResponse.setETCData("vvd_cd_nm", "");
						eventResponse.setETCData("pol_cd_print", "");
						eventResponse.setETCData("vps_etd", "");
						eventResponse.setETCData("setText1", "");
						eventResponse.setETCData("setText2", "");
						eventResponse.setETCData("remark", "");
						eventResponse.setUserMessage(new ErrorHandler(
								"BKG00889").getUserMessage());
					}
				} else {
					eventResponse.setETCData("vvd_cd_nm", "");
					eventResponse.setETCData("pol_cd_print", "");
					eventResponse.setETCData("vps_etd", "");
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
				}

				eventResponse.setETCData(etcData);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * ESM_BKG_0930 : 
	 * ESM_BKG_0931 : 
	 * ESM_BKG_0932 : PDF Print 버튼 클릭 시 Container Loading List(Korea) 정보 조회
	 * POL 터미널에 전송할 Container Loading List(Korea) 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchKorCll(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CLLCDLManifestBC command = new CLLCDLManifestBCImpl();
		List<KorCllDetailVO> list = null;
		Map<String, String> etcData = new HashMap<String, String>();
		try {
			if ("EsmBkg0930Event".equalsIgnoreCase(e.getEventName())) {
				EsmBkg0930Event event = (EsmBkg0930Event) e;

				list = command.searchKorCll(event.getKorCllCondVO());

				if (list.size() > 0) {
					eventResponse.setRsVoList(list);
					eventResponse.setETCData("in_ktml_cd", list.get(0).getTVslCd());
					eventResponse.setETCData("in_max_edi_snd_dt", list.get(0).getMaxEdiSndDt());
				} else {
					eventResponse.setETCData("in_ktml_cd", "");
					eventResponse.setETCData("in_max_edi_snd_dt", "");
					eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
				}
				eventResponse.setETCData(etcData);
			} else if ("EsmBkg0931Event".equalsIgnoreCase(e.getEventName())) {
				EsmBkg0931Event event = (EsmBkg0931Event) e;

				list = command.searchKorCll(event.getKorCllCondVO());

				if (list.size() > 0) {
					eventResponse.setRsVoList(list);

					eventResponse.setETCData("vvd_cd_nm", list.get(0).getVvdCdNm());
					eventResponse.setETCData("pol_cd_print", list.get(0).getPolCdPrint());
					eventResponse.setETCData("vps_etd", list.get(0).getVpsEtd());
				} else {
					eventResponse.setETCData("vvd_cd_nm", "");
					eventResponse.setETCData("pol_cd_print", "");
					eventResponse.setETCData("vps_etd", "");
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
				}
				eventResponse.setETCData(etcData);
			} else if ("EsmBkg0932Event".equalsIgnoreCase(e.getEventName())) {
				EsmBkg0932Event event = (EsmBkg0932Event) e;

				list = command.searchKorCll(event.getKorCllCondVO());

				if (list.size() > 0) {
					eventResponse.setRsVoList(list);

					eventResponse.setETCData("preview_vvd_cd", list.get(0).getVvdCdNm());
					eventResponse.setETCData("preview_pol_cd", list.get(0).getPolCdPrint());
					eventResponse.setETCData("preview_vps_etd", list.get(0).getVpsEtd());
				} else {
					eventResponse.setETCData("preview_vvd_cd", "");
					eventResponse.setETCData("preview_pol_cd", "");
					eventResponse.setETCData("preview_vps_etd", "");
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
				}
				eventResponse.setETCData(etcData);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;

	}

	/**
	 * ESM_BKG_0965 :
	 * VVD와 Port를 가지고 Bay Plan에서 Cell position을 자동으로 가져 왔는 지 여부를 조회 한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIstowageInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		String retVal = "";
		try {
			if ("EsmBkg0965Event".equalsIgnoreCase(e.getEventName())) {

				command = new SpecialManifestBCImpl();

				EsmBkg0965Event event = (EsmBkg0965Event) e;

				retVal = command.searchIstowageInfo(event.getDgListCondVO());
				
				eventResponse.setETCData("crntCellPsnNoYn", retVal);

			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;

	}

	/**
	 * ESM_BKG_0965 :
	 * 위험물 신고 대상 컨테이너를 조회 해 온다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDgManifestList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		List<DgListDetailVO> list = null;
		SpecialContainerVO containerVO = null;

		DgListDetailVO vslInfo = null;
		List<DgListDetailVO> detailList = null;
		
		try {
			if ("EsmBkg0965Event".equalsIgnoreCase(e.getEventName())) {

				command = new SpecialManifestBCImpl();

				EsmBkg0965Event event = (EsmBkg0965Event) e;

				DgListCondVO dgListCondVO = event.getDgListCondVO();
				dgListCondVO.setOfcCd(account.getOfc_cd());

				list = command.searchDgManifestList(dgListCondVO);

				if (list != null && list.size() > 0) {
					containerVO = (SpecialContainerVO) list.get(0);

					vslInfo = containerVO.getVslInfo();
					detailList = containerVO.getDetailList();

					// 로컬 저장유무(세관 테이블에 저장 유무)
					eventResponse.setETCData("dgListLocalYn", containerVO.getDgListLocalYn());
					// edi전송 status
					eventResponse.setETCData("ediSentStatus", containerVO.getEdiSentStatus());

					if (vslInfo != null) {

						vslInfo.setAutoSndTpCd(containerVO.getAutoSentFlag());
						vslInfo.setAckRcvStsCd(containerVO.getEdiSentStatus());

					}

					// 상당 배정보
					eventResponse.setRsVo(vslInfo);
					// 하단 그리드 정보
					eventResponse.setRsVoList(detailList);

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
	 * ESM_BKG_0965 :
	 * Vessel Code로 Name을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVesselName(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		try {
			if ("EsmBkg0965Event".equalsIgnoreCase(e.getEventName())) {
				command = new SpecialManifestBCImpl();
				EsmBkg0965Event event = (EsmBkg0965Event) e;
				String vesselName = command.searchVesselName(event
						.getDgListCondVO());
				eventResponse.setETCData("vesselName", vesselName);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0965 :
	 * Berth Code로 YardName을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchYardName(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		try {
			if ("EsmBkg0965Event".equalsIgnoreCase(e.getEventName())) {
				command = new SpecialManifestBCImpl();
				EsmBkg0965Event event = (EsmBkg0965Event) e;
				String yardName = command.searchYardName(event
						.getDgListCondVO());
				eventResponse.setETCData("yardName", yardName);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0967 :
	 * Forward Code로 Forward Name을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchForwarderName(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		try {
			if ("EsmBkg0967Event".equalsIgnoreCase(e.getEventName())) {
				command = new SpecialManifestBCImpl();
				EsmBkg0967Event event = (EsmBkg0967Event) e;
				String anrFwrdName = command.searchForwarderName(event
						.getDgListCondVO());
				eventResponse.setETCData("anrFwrdName", anrFwrdName);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0967 :
	 * UN NO로 NAME을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUnnoName(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		try {
			if ("EsmBkg0967Event".equalsIgnoreCase(e.getEventName())) {
				command = new SpecialManifestBCImpl();
				EsmBkg0967Event event = (EsmBkg0967Event) e;
				String imdgUnNoDesc = command.searchUnnoName(event
						.getDgListCondVO());
				eventResponse.setETCData("imdgUnNoDesc", imdgUnNoDesc);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0967 :
	 * ANTWERP지역의 위험물(수출 선적/수입 하역/통과 분) 신고 시에 <br>
	 * 특정 Dangerous Cargo의 UN No에 따른 추가 Indicator를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpecialList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		List<SpecialListDetailVO> list = null;
		try {
			if ("EsmBkg0977Event".equalsIgnoreCase(e.getEventName())) {

				command = new SpecialManifestBCImpl();

				EsmBkg0977Event event = (EsmBkg0977Event) e;

				list = command.searchSpecialList(event.getSpecialListCondVO());

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
	 * ESM_BKG_0967 :
	 * Special 코드 및 desc정보를 입력한다<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSpecialList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;

		try {
			this.begin();
			if ("EsmBkg0977Event".equalsIgnoreCase(e.getEventName())) {

				command = new SpecialManifestBCImpl();

				EsmBkg0977Event event = (EsmBkg0977Event) e;

				command.manageSpecialList(event.getSpecialListVO(), account);

			}
			this.commit();
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
	 * ESM_BKG_0965 :
	 * ESM_BKG_0967 :
	 * 세관테이블로 위험물 정보를 저장한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException

	 */
	private EventResponse manageDgManifestList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = new SpecialManifestBCImpl();
		;

		try {
			this.begin();
			if ("EsmBkg0965Event".equalsIgnoreCase(e.getEventName())) {

				EsmBkg0965Event event = (EsmBkg0965Event) e;

				command.manageDgManifestList(event.getDgListModiVOs(), account);

			} else if ("EsmBkg0967Event".equalsIgnoreCase(e.getEventName())) {

				EsmBkg0967Event event = (EsmBkg0967Event) e;

				command.modifyDgInquiry(event.getDgInqModiVO(), account);

			}
			this.commit();
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
	 * ESM_BKG_0930 :
	 * POL 터미널에 전송할 Container Loading List (Korea) 정보를 수정한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageKorCll(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CLLCDLManifestBC command = null;

		try {
			this.begin();
			if ("EsmBkg0930Event".equalsIgnoreCase(e.getEventName())) {

				command = new CLLCDLManifestBCImpl();

				EsmBkg0930Event event = (EsmBkg0930Event) e;

				command.manageKorCll(event.getKorCllModifyVOS(), account);
				
				eventResponse.setUserMessage(new ErrorHandler("BKG00166")
				.getUserMessage());

			}
			this.commit();
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
	 * ESM_BKG_0930 :
	 * Container Loading List(Korea) 정보를 POL 터미널에 전송한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitKorCll(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CLLCDLManifestBC command = null;

		String flatFile = "";
		Map<String, String> etcData = new HashMap<String, String>();

		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0930Event")) {
				EsmBkg0930Event event = (EsmBkg0930Event) e;
				command = new CLLCDLManifestBCImpl();
				flatFile = command.transmitKorCll(event.getKorCllCondVO(), account);
				eventResponse.setETCData("flatFile", flatFile);
				eventResponse.setETCData(etcData);
				eventResponse.setUserMessage(new ErrorHandler("BKG00218")
				.getUserMessage());

			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(),
					ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_BKG_0967 :
	 * Danger cargo 정보를 컨테이너 단위로 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDgCargoInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		try {
			if ("EsmBkg0967Event".equalsIgnoreCase(e.getEventName())) {
				command = new SpecialManifestBCImpl();
				EsmBkg0967Event event = (EsmBkg0967Event) e;
				List<DgInqModiVO> dgInqModiVOs = command.searchDgCargoInfo(event
						.getDgCargoCondVO());
				//eventResponse.setRsVo(dgInqModiVOs);
				eventResponse.setRsVoList(dgInqModiVOs);

			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0967 :
	 * 해당 Bl에 속한 컨테이너리스트를 조회한다.(콤보 셋팅을 위해)<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrInfoListByBl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		try {
			if ("EsmBkg0967Event".equalsIgnoreCase(e.getEventName())) {
				command = new SpecialManifestBCImpl();
				EsmBkg0967Event event = (EsmBkg0967Event) e;
				List<DgCntrInfoListVO> list = command
						.searchCntrInfoListByBl(event.getDgCargoCondVO());
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
	 * ESM_BKG_0967 :
	 * 해당 컨테이너에에 속한 Cgo Seq 리스트를 조회한다.(셋팅을 위해)<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCgoSeqListByCntr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		try {
			if ("EsmBkg0967Event".equalsIgnoreCase(e.getEventName())) {
				command = new SpecialManifestBCImpl();
				EsmBkg0967Event event = (EsmBkg0967Event) e;
				List<DgCntrInfoListVO> list = command
						.searchCgoSeqListByCntr(event.getDgCargoCondVO());
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
	 * ESM_BKG_0970 :
	 * 송신 내역을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSendHistory(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		try {
			if ("EsmBkg0970Event".equalsIgnoreCase(e.getEventName())) {
				command = new SpecialManifestBCImpl();
				EsmBkg0970Event event = (EsmBkg0970Event) e;
				List<SendHistoryDetailVO> list = command
						.searchSendHistory(event.getSendHistoryCondVO());
				eventResponse.setRsVoList(list);
			}
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0932 : PDF Print 버튼 클릭 시 LOCAL과 T/S에 대한 KorCllSpecialCgo 조회
	 * ESM_BKG_0933 :
	 * POL 터미널에 전송할 Container Loading List(Korea) 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchKorCllSpecialCgo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CLLCDLManifestBC command = new CLLCDLManifestBCImpl();
		KorCllSpclCgoContainerVO korCllSpclCgoContainerVO = new KorCllSpclCgoContainerVO();
		Map<String, String> etcData = new HashMap<String, String>();
		try {
			if ("EsmBkg0933Event".equalsIgnoreCase(e.getEventName())) {
				EsmBkg0933Event event = (EsmBkg0933Event) e;
 
				korCllSpclCgoContainerVO = command.searchKorCllSpecialCgo(event
						.getKorCllCondVO());

				if ( korCllSpclCgoContainerVO.getCLLCDLManifestVslSkdInfoVOs().size() != 0 )
				{
					eventResponse.setRsVoList(korCllSpclCgoContainerVO
							.getKorCllSpclCgoDetailVOs());
					eventResponse.setRsVoList(korCllSpclCgoContainerVO
							.getCLLCDLManifestSpclCgoTotalByPodDetailVOs());
					eventResponse.setRsVoList(korCllSpclCgoContainerVO
							.getSpclCgoEtcDetailVOs());
	
					eventResponse.setETCData("vvd_cd", korCllSpclCgoContainerVO
							.getCLLCDLManifestVslSkdInfoVOs().get(0).getVvdCd2());
					eventResponse.setETCData("un_loc_cd", korCllSpclCgoContainerVO
							.getCLLCDLManifestVslSkdInfoVOs().get(0).getUnLocCd()+event
							.getKorCllCondVO().getInPolYdCd());
					eventResponse.setETCData("vps_etd_dt", korCllSpclCgoContainerVO
							.getCLLCDLManifestVslSkdInfoVOs().get(0).getVpsEtdDt());
				} else {
					eventResponse.setETCData("vvd_cd", "");
					eventResponse.setETCData("un_loc_cd", "");
					eventResponse.setETCData("vps_etd_dt", korCllSpclCgoContainerVO
							.getCLLCDLManifestVslSkdInfoVOs().get(0).getVpsEtdDt());
					
					eventResponse.setUserMessage(new ErrorHandler(
					"BKG00889").getUserMessage());
				}

				eventResponse.setETCData(etcData);
			} else if ("EsmBkg0932Event".equalsIgnoreCase(e.getEventName())) {
				EsmBkg0932Event event = (EsmBkg0932Event) e;
 
				korCllSpclCgoContainerVO = command.searchKorCllSpecialCgo(event
						.getKorCllCondVO());

				if ( korCllSpclCgoContainerVO.getCLLCDLManifestVslSkdInfoVOs().size() != 0 )
				{
					eventResponse.setRsVoList(korCllSpclCgoContainerVO
							.getKorCllSpclCgoDetailVOs());
					eventResponse.setRsVoList(korCllSpclCgoContainerVO
							.getCLLCDLManifestSpclCgoTotalByPodDetailVOs());
					eventResponse.setRsVoList(korCllSpclCgoContainerVO
							.getSpclCgoEtcDetailVOs());
	
					eventResponse.setETCData("vvd_cd", korCllSpclCgoContainerVO
							.getCLLCDLManifestVslSkdInfoVOs().get(0).getVvdCd2());
					eventResponse.setETCData("un_loc_cd", korCllSpclCgoContainerVO
							.getCLLCDLManifestVslSkdInfoVOs().get(0).getUnLocCd()+event
							.getKorCllCondVO().getInPolYdCd());
					eventResponse.setETCData("vps_etd_dt", korCllSpclCgoContainerVO
							.getCLLCDLManifestVslSkdInfoVOs().get(0).getVpsEtdDt());
				} else {
					eventResponse.setETCData("vvd_cd", "");
					eventResponse.setETCData("un_loc_cd", "");
					eventResponse.setETCData("vps_etd_dt", korCllSpclCgoContainerVO
							.getCLLCDLManifestVslSkdInfoVOs().get(0).getVpsEtdDt());
					
					eventResponse.setUserMessage(new ErrorHandler(
					"BKG00889").getUserMessage());
				}

				eventResponse.setETCData(etcData);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * ESM_BKG_0965 :
	 * 위험물 Flat File 생성 및 EDI 전송<br>
	 * ManifestListDownload의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendDgManifestList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		List<String> flatFileList = null;
		try {
			begin();
			if ("EsmBkg0965Event".equalsIgnoreCase(e.getEventName())) {
				command = new SpecialManifestBCImpl();
				EsmBkg0965Event event = (EsmBkg0965Event) e;
				flatFileList = command.sendDgManifestList(event.getDgEdiVOs(),
						account);

				if (flatFileList != null) {
					eventResponse.setETCData("originalFlatFile", flatFileList
							.get(0));
					eventResponse.setETCData("updateFlatFile", flatFileList
							.get(1));
					eventResponse.setETCData("cancelFlatFile", flatFileList
							.get(2));
				} else {
					eventResponse.setETCData("originalFlatFile", "");
					eventResponse.setETCData("updateFlatFile", "");
					eventResponse.setETCData("cancelFlatFile", "");
				}

				// 성공 메시지 셋팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00218").getUserMessage());
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
	 * ESM_BKG_0575 :
	 * PSA Manifest Vessel Regist 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPSAVslRegist(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSAManifestBC command = null;
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0575Event")) {

				command = new PSAManifestBCImpl();
				EsmBkg0575Event event = (EsmBkg0575Event) e;

				if (event.getFormCommand().isCommand(FormCommand.SEARCH)) {
					// BC에 작업 요청
					PsaVvdVO[] psaVvdVOs = command.searchPSAVslRegist(event.getPsaVvdVO());

					// event 에 담기
					if (psaVvdVOs!=null) eventResponse.setRsVoList((List<PsaVvdVO>) Arrays.asList(psaVvdVOs));
					
				} else if (event.getFormCommand().isCommand(FormCommand.COMMAND01)) {
					// BC에 작업 요청
					String psaVslNm = command.searchPSAVslName(event.getPsaVvdVO());

					// event 에 담기
					if (psaVslNm != null) eventResponse.setETCData("psa_vsl_nm", psaVslNm);
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
	 * ESM_BKG_0575 :
	 * PSA Manifest Vessel Regist 정보 수정<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse managePSAVVDInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSAManifestBC command = null;

		try {
			begin();

			if (e.getEventName().equalsIgnoreCase("EsmBkg0575Event")) {

				command = new PSAManifestBCImpl();
				EsmBkg0575Event event = (EsmBkg0575Event) e;

				PsaVvdVO[] psaVvdVOs = event.getPsaVvdVOs();
				for (int i = 0; i < psaVvdVOs.length; i++)
					psaVvdVOs[i].setUserId(account.getUsr_id());

				// BC에 작업 요청
				command.managePSAVVDInfo(psaVvdVOs);

				// 성공 메시지 셋팅
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
	 * ESM_BKG_1028 :
	 * ESM_BKG_1013 :
	 * PSA Vessel Import Schedule 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPSAVVD(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSAManifestBC command = null;
		PsaVvdVO[] psaVvdVOs = null;

		command = new PSAManifestBCImpl();
		try {
			if ("EsmBkg1028Event".equalsIgnoreCase(e.getEventName())) {
				EsmBkg1028Event event = (EsmBkg1028Event) e;
				psaVvdVOs = command.searchPSAVVD(event.getPortCd(), event.getEtbDt1(), event.getEtbDt2());

				if (psaVvdVOs!=null) eventResponse.setRsVoList((List<PsaVvdVO>) Arrays.asList(psaVvdVOs));
			} else if ("EsmBkg1013Event".equalsIgnoreCase(e.getEventName())) {
				EsmBkg1013Event event = (EsmBkg1013Event) e;
				psaVvdVOs = command.searchPSAVVD(event.getPortCd(), event.getEtbDt1(), event.getEtbDt2());

				if (psaVvdVOs!=null) eventResponse.setRsVoList((List<PsaVvdVO>) Arrays.asList(psaVvdVOs));
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_BKG_0159 :
	 * Terminal EDI Transmit 대상 Contanier Loading/Discharging List를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchKorCllCdl(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CLLCDLManifestBC command = new CLLCDLManifestBCImpl();
		Map<String, String> etcData = new HashMap<String, String>();
		try {
			if ("EsmBkg0159Event".equalsIgnoreCase(e.getEventName())) {
				EsmBkg0159Event event = (EsmBkg0159Event) e;

				String key = command.startBackEndJob(account, event.getKorCllCdlCondVO(), "ESM_BKG_0159_SEARCH");
				eventResponse.setETCData("KEY", key);
				eventResponse.setETCData(etcData);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;

	}
	
	/**
	 * ESM_BKG_0159 :
	 * Terminal EDI Transmit 대상 Contanier Loading/Discharging List를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCllCdlForODCY(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CLLCDLManifestBC command = new CLLCDLManifestBCImpl();
		try {
			if ("EsmBkg0159Event".equalsIgnoreCase(e.getEventName())) {
				EsmBkg0159Event event = (EsmBkg0159Event) e;

				List<CLLCDLManifestCllCdlForODCYVO> cLLCDLManifestCllCdlForODCYVOs = command.searchCllCdlForODCY(event.getKorCllCdlCondVO());
				eventResponse.setRsVoList(cLLCDLManifestCllCdlForODCYVOs);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;

	}	

	/**
	 * ESM_BKG_0576 :
	 * PSA Container Booking I/F History 내역 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPSACNTRBKGHist(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSAManifestBC command = null;

		command = new PSAManifestBCImpl();
		try {
			EsmBkg0576Event event = (EsmBkg0576Event) e;
			// BC 에 조회 요청
			PsaBkgVO[] psaBkgVOs = command.searchPSACNTRBKGHist(event.getPsaBkgVO());
			// Event 에 결과 담기
			if (psaBkgVOs!=null) eventResponse.setRsVoList((List<PsaBkgVO>) Arrays.asList(psaBkgVOs));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0979 :
	 * PSA Container Booking I/F History Log 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPSAStatusLog(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSAManifestBC command = null;

		command = new PSAManifestBCImpl();
		try {
			EsmBkg0979Event event = (EsmBkg0979Event) e;
			// BC 에 조회 요청
			String statusLog = command.searchPSAStatusLog(event.getBkgNo(), event.getBkgSeq());
			// Event 에 결과 담기
			eventResponse.setETCData("status_log", statusLog);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0582 :
	 * PSA Port List 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPSAPortList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSAManifestBC command = null;

		command = new PSAManifestBCImpl();
		try {
			EsmBkg0582Event event = (EsmBkg0582Event) e;
			// BC 에 조회 요청
			PsaPortVO[] psaPortVOs = command.searchPSAPortList(event.getPortCd());
			// Event 에 결과 담기
			if (psaPortVOs!=null) eventResponse.setRsVoList((List<PsaPortVO>) Arrays.asList(psaPortVOs));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Terminal EDI Transmit 대상 Contanier Loading/Discharging List를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmCntrTpSz(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CLLCDLManifestBC command = new CLLCDLManifestBCImpl();
		List<MdmCntrTpSzVO> list = null;
		try {
			list = command.searchMdmCntrTpSz();

			eventResponse.setRsVoList(searchComCodeCombo2("CD00767"));
			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(searchComCodeCombo("CD02192"));
			eventResponse.setRsVoList(searchComCodeCombo("CD02191"));
			eventResponse.setRsVoList(searchComCodeCombo("CD02149"));

			eventResponse.setUserMessage(new ErrorHandler("BKG00889")
					.getUserMessage());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * ESM_BKG_0420 :
	 * PSA Import Status I/F 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPSAImpSts(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSAManifestBC command = null;
		try {
			command = new PSAManifestBCImpl();
			EsmBkg0420Event event = (EsmBkg0420Event) e;

			// BC 에 조회 요청
			PsaImpStsVO psaImpStsVO = command.searchPSAImpSts(event
					.getPsaImpStsVO());
			// Event 에 결과 담기
			if (psaImpStsVO != null) {
				if (psaImpStsVO.getPsaVvdVO() != null)
					eventResponse.setETCData("vsl_nm", psaImpStsVO
							.getPsaVvdVO().getPsaVslNm());
				if (psaImpStsVO.getPsaVvdVO() != null)
					eventResponse.setETCData("vsl_voyage", psaImpStsVO
							.getPsaVvdVO().getPsaVoyDirCd());
				eventResponse.setRsVoList(psaImpStsVO.getListPsaImpStsVO());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0420 :
	 * PSA Import Status I/F 추가/수정/삭제 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse managePSAImpSts(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSAManifestBC command = null;

		try {
			begin();

			command = new PSAManifestBCImpl();
			EsmBkg0420Event event = (EsmBkg0420Event) e;

			// GRID 입력값 변환
			PsaImpStsVO[] psaImpStsVOs = event.getPsaImpStsVOs();
			String vslCd = event.getVslCd();
			String skdVoyNo = event.getSkdVoyNo();
			String skdDirCd = event.getSkdDirCd();

			// ID 및 VVD 처리
			for (int i = 0; i < psaImpStsVOs.length; i++) {
				psaImpStsVOs[i].setUserId(account.getUsr_id());
				psaImpStsVOs[i].setVslCd(vslCd);
				psaImpStsVOs[i].setSkdVoyNo(skdVoyNo);
				psaImpStsVOs[i].setSkdDirCd(skdDirCd);
			}

//			// BC에 작업 요청
//			command.managePSAImpSts(psaImpStsVOs);
//
//			// 성공 메시지 셋팅
//			eventResponse.setUserMessage(new ErrorHandler("BKG00166")
//					.getUserMessage());
			
			 if(e.getEventName().equalsIgnoreCase("EsmBkg0420Event"))
			 {
					command = new PSAManifestBCImpl();
					
					String key = command.startBackEndJob(account, psaImpStsVOs, "ESM_BKG_0420");
					eventResponse.setETCData("KEY", key);
					
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
	
//	/**
//	 * ESM_BKG_0420 :
//	 * PSA Import Status I/F 추가/수정/삭제 처리<br>
//	 * 
//	 * @param Event e
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	private EventResponse managePSAImpSts(Event e) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		PSAManifestBC command = null;
//		
//		try {
//			begin();
//			
//			command = new PSAManifestBCImpl();
//			EsmBkg0420Event event = (EsmBkg0420Event) e;
//			
//			// GRID 입력값 변환
//			PsaImpStsVO[] psaImpStsVOs = event.getPsaImpStsVOs();
//			String vslCd = event.getVslCd();
//			String skdVoyNo = event.getSkdVoyNo();
//			String skdDirCd = event.getSkdDirCd();
//			
//			// ID 및 VVD 처리
//			for (int i = 0; i < psaImpStsVOs.length; i++) {
//				psaImpStsVOs[i].setUserId(account.getUsr_id());
//				psaImpStsVOs[i].setVslCd(vslCd);
//				psaImpStsVOs[i].setSkdVoyNo(skdVoyNo);
//				psaImpStsVOs[i].setSkdDirCd(skdDirCd);
//			}
//			
//			// BC에 작업 요청
//			command.managePSAImpSts(psaImpStsVOs);
//			
//			// 성공 메시지 셋팅
//			eventResponse.setUserMessage(new ErrorHandler("BKG00166")
//			.getUserMessage());
//			
//			commit();
//			
//		} catch (EventException ex) {
//			rollback();
//			throw ex;
//		} catch (Exception ex) {
//			rollback();
//			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
//		}
//		
//		return eventResponse;
//	}

	/**
	 * ESM_BKG_1012 :
	 * PSA Import Status I/F 의 Special Cargo Info 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPSAImpoStsSpclCgo(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSAManifestBC command = null;
		try {
			command = new PSAManifestBCImpl();
			EsmBkg1012Event event = (EsmBkg1012Event) e;

			// BC 에 조회 요청
			ImpStsSpclCgoVO impStsSpclCgoVO = command
					.searchPSAImpoStsSpclCgo(event.getImpStsSpclCgoVO());

			// Event 에 결과 담기
			eventResponse.setETCData(impStsSpclCgoVO.getColumnValues());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),	ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0159 :
	 * VVD가 출항전에 Container Loading List를 각 Port의 Terminal에 전송하기 위해, 전송 전 자체<br>
	 * Table에 대상 데이터를 저장한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCllForDownload(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CLLCDLManifestBC command = null;
		Map<String, String> etcData = new HashMap<String, String>();
		try {
			this.begin();
			if ("EsmBkg0159Event".equalsIgnoreCase(e.getEventName())) {

				command = new CLLCDLManifestBCImpl();

				EsmBkg0159Event event = (EsmBkg0159Event) e;

				String key = command.startBackEndJob(account, event.getTerminalCllVOS(), "ESM_BKG_0159");
				eventResponse.setETCData("KEY", key);
				eventResponse.setETCData(etcData);

			}
			this.commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;

	}

	/**
	 * ESM_BKG_1012 :
	 * PSA Import Status I/F 의 Special Cargo Info 추가/수정/삭제 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse managePSAImpStsSpclCgo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSAManifestBC command = null;

		try {
			begin();

			command = new PSAManifestBCImpl();
			EsmBkg1012Event event = (EsmBkg1012Event) e;

			// 입력값 변환
			ImpStsSpclCgoVO impStsSpclCgoVO = event.getImpStsSpclCgoVO();
			// ID 처리
			impStsSpclCgoVO.setUserId(account.getUsr_id());

			// BC에 작업 요청
			command.managePSAImpStsSpclCgo(impStsSpclCgoVO);

			// 성공 메시지 셋팅 (작업구분에 따라 분리)
			if (impStsSpclCgoVO.getTypeCd().equals("D")) {
				eventResponse.setUserMessage(new ErrorHandler("BKG00593")
						.getUserMessage());
			} else {
				eventResponse.setUserMessage(new ErrorHandler("BKG00166")
						.getUserMessage());
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
	 * ESM_BKG_0420 :
	 * PSA Import Status EDI 전송 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitPSAImpStsInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSAManifestBC command = null;

		try {
			begin();

			command = new PSAManifestBCImpl();
			EsmBkg0420Event event = (EsmBkg0420Event) e;

			PsaImpStsVO psaImpStsVO = event.getPsaImpStsVO();
			// ID 처리
			psaImpStsVO.setUserId(account.getUsr_id());

			// BC에 작업 요청
			command.transmitPSAImpStsInfo(psaImpStsVO);

			// 성공메시지 셋팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00204")
					.getUserMessage());

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
	 * ESM_BKG_0932 :
	 * POL 터미널에 전송할 Container Loading List (Korea) Remark 정보를 수정한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageKorCllRemark(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CLLCDLManifestBC command = null;

		try {
			begin();

			if (e.getEventName().equalsIgnoreCase("EsmBkg0932Event")) {
				command = new CLLCDLManifestBCImpl();
				EsmBkg0932Event event = (EsmBkg0932Event) e;

				command.manageKorCllRemark(event.getKorCllRemarkVO(), account);

				// 성공 메시지 셋팅
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
	 * ESM_BKG_0155 :
	 * POL 터미널에 전송할 Container Loading List 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCll(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CLLCDLManifestBC command = new CLLCDLManifestBCImpl();
		List<CllDetailVO> cllDetailVOs = null;
		Map<String, String> etcData = new HashMap<String, String>();
		try {
			if ("EsmBkg0155Event".equalsIgnoreCase(e.getEventName())) {
				EsmBkg0155Event event = (EsmBkg0155Event) e;

				cllDetailVOs = command.searchCll(event.getCllCondVO());

				if (cllDetailVOs.size() > 0) {
					eventResponse.setETCData("eta_dt", cllDetailVOs.get(0)
							.getEtaDt());
					eventResponse.setETCData("etd_dt", cllDetailVOs.get(0)
							.getEtdDt());
				} else {
					eventResponse.setETCData("eta_dt", "");
					eventResponse.setETCData("etd_dt", "");
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
					.getUserMessage());
				}
				eventResponse.setRsVoList(cllDetailVOs);

				eventResponse.setETCData(etcData);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * ESM_BKG_0155 :
	 * POL 터미널에 전송할 Container Loading List 정보를 수정한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCll(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CLLCDLManifestBC command = null;

		try {
			this.begin();
			if ("EsmBkg0155Event".equalsIgnoreCase(e.getEventName())) {

				command = new CLLCDLManifestBCImpl();

				EsmBkg0155Event event = (EsmBkg0155Event) e;

				command.manageCll(event.getCllDetailVOs(), account);

				eventResponse.setUserMessage(new ErrorHandler("BKG00166")
				.getUserMessage());
			}
			this.commit();
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
	 * EDI 수신 메시징 에 대한 로깅 처리.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse loadCstmsRcvMsg(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		PSASpecialManifestBC command2 = null;

		try {
			begin();
			// 이벤트별 Impl생성

			if (e.getEventName().equalsIgnoreCase("AlpsbkgTEurbaplieEvent")) {
				AlpsbkgTEurbaplieEvent event = (AlpsbkgTEurbaplieEvent) e;
				command = new SpecialManifestBCImpl();
				command.loadCstmsRcvMsg(event.getFlatFile(),
						"AlpsbkgTEurbaplieEvent");

			} else if (e.getEventName().equalsIgnoreCase(
					"AlpsbkgTEurcusAckEven")) {
				AlpsbkgTEurcusAckEven event = (AlpsbkgTEurcusAckEven) e;
				command = new SpecialManifestBCImpl();
				command.loadCstmsRcvMsg(event.getFlatFile(),
						"AlpsbkgTEurcusAckEven");
			} else if (e.getEventName().equalsIgnoreCase(
		     		"AlpsbkgTPsacusAckEven")) {
			    AlpsbkgTPsacusAckEven event = (AlpsbkgTPsacusAckEven) e;
			    command2 = new PSASpecialManifestBCImpl();
			    command2.loadCstmsRcvMsg(event.getFlatFile(),
			      	"AlpsbkgTPsacusAckEven");   
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
	 * ESM_BKG_1056 : 
	 * Container Loading List_Summary_SPP List 한국의 Container Loading 대상 목록의<br>
	 * Summary 화면에서의 SPP Code를 Select<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchKorCllSppList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CLLCDLManifestBC command = null;
		try {
			EsmBkg1056Event event = (EsmBkg1056Event) e;
			command = new CLLCDLManifestBCImpl();
			List<KorCllSppDetailVO> korCllSppDetailVOs = command
					.searchKorCllSppList(event.getEntryTp());
			eventResponse.setRsVoList(korCllSppDetailVOs);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1056 : 
	 * Container Loading List_Summary_SPP List 한국의 Container Loading 대상 목록의<br>
	 * Summary 화면에서의 SPP Code를 Insert, Update, Delete<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageKorCllSppList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CLLCDLManifestBC command = null;
		EsmBkg1056Event event = (EsmBkg1056Event) e;
		try {
			begin();
			command = new CLLCDLManifestBCImpl();
			command.manageKorCllSppList(event.getKorCllSppVOs(), account);
			eventResponse.setETCData("status", "ok");

			// 성공 메시지 셋팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00166")
					.getUserMessage());

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
	 * ESM_BKG_0915 : 
	 * 터미널에 전송할 Container Loading List - Danger Cargo 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCllDgCgo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CLLCDLManifestBC command = new CLLCDLManifestBCImpl();
		List<CllDgCgoDetailVO> cllDgCgoDetailVOs = null;
		try {
			if ("EsmBkg0915Event".equalsIgnoreCase(e.getEventName())) {
				EsmBkg0915Event event = (EsmBkg0915Event) e;

				cllDgCgoDetailVOs = command.searchCllDgCgo(event
						.getCllSpclCondVO());

				eventResponse.setRsVoList(cllDgCgoDetailVOs);
				
				if ( cllDgCgoDetailVOs.size() == 0 )
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
					.getUserMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * ESM_BKG_0915 : 
	 * 터미널에 전송할 Container Loading List - Danger Cargo 정보를 수정한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCllDgCgo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CLLCDLManifestBC command = null;
		EsmBkg0915Event event = (EsmBkg0915Event) e;
		try {
			begin();
			command = new CLLCDLManifestBCImpl();
			command.manageCllDgCgo(event.getBkgCstmsTmlCllDgCgoVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166")
			.getUserMessage());
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
	 * ESM_BKG_0916 : 
	 * 터미널에 전송할 Container Loading List - Reefer, Awkward Cargo 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCllRfAkCgo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CLLCDLManifestBC command = new CLLCDLManifestBCImpl();
		List<CllRfAkCgoDetailVO> cllRfAkCgoDetailVOs = null;
		try {
			if ("EsmBkg0916Event".equalsIgnoreCase(e.getEventName())) {
				EsmBkg0916Event event = (EsmBkg0916Event) e;

				cllRfAkCgoDetailVOs = command.searchCllRfAkCgo(event
						.getCllSpclCondVO());

				eventResponse.setRsVoList(cllRfAkCgoDetailVOs);
				
				if ( cllRfAkCgoDetailVOs.size() == 0 )
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
					.getUserMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * ESM_BKG_0916 : 
	 * 터미널에 전송할 Container Loading List - Reefer, Awkward Cargo 정보를 수정한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyCllRfAkCgo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CLLCDLManifestBC command = null;
		EsmBkg0916Event event = (EsmBkg0916Event) e;
		try {
			begin();
			command = new CLLCDLManifestBCImpl();
			command.modifyCllRfAkCgo(event.getCllRfAkCgoDetailVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166")
			.getUserMessage());
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
	 * ESM_BKG_0723 : 
	 * 터미널에 전송할 Container Loading List - Reefer, Awkward Cargo 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEdiTerminal(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CLLCDLManifestBC command = new CLLCDLManifestBCImpl();
		List<CLLCDLManifestEdiTerminalInfoVO> list = null;
		try {
			if ("EsmBkg0723Event".equalsIgnoreCase(e.getEventName())) {
				// @SuppressWarnings("unused")
				EsmBkg0723Event event = (EsmBkg0723Event) e;

				list = command.searchEdiTerminal(event.getInPortCd(), event.getInListType());

				eventResponse.setRsVoList(list);
				
				if ( list.size() == 0 )
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
					.getUserMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * ESM_BKG_0723 : 
	 * Container Loading List(Korea) 정보를 POL 터미널에 전송한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse 
	 * @exception EventException
	 */
	private EventResponse transmitCllCdl(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CLLCDLManifestBC command = null;

		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0723Event")) {
				EsmBkg0723Event event = (EsmBkg0723Event) e;
				command = new CLLCDLManifestBCImpl();
				String key = command.startBackEndJob(account, event.getCllCdlTransmitVOs(), "ESM_BKG_0723");
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
	 * ESM_BKG_0965 : 
	 * 입력시 validation(bl_no, pol_cd, pod_cd)<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDgValidationByVvdKey(Event e)
			throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		String retVal = "";
		try {
			if ("EsmBkg0965Event".equalsIgnoreCase(e.getEventName())) {
				command = new SpecialManifestBCImpl();
				EsmBkg0965Event event = (EsmBkg0965Event) e;
				retVal = command.searchDgValidationByVvdKey(event
						.getDgValidationCondVO());
				eventResponse.setETCData("retVal", retVal);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * ESM_BKG_0965 : 
	 * 구주위험물 - 입력시 validation(cntr_no)<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDgValidationByCntrKey(Event e)
			throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		String retVal = "";
		try {
			if ("EsmBkg0965Event".equalsIgnoreCase(e.getEventName())) {
				command = new SpecialManifestBCImpl();
				EsmBkg0965Event event = (EsmBkg0965Event) e;
				retVal = command.searchDgValidationByCntrKey(event
						.getDgValidationCondVO());
				eventResponse.setETCData("retVal", retVal);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * ESM_BKG_0965 : 
	 * 구주위험물 - vvd, port로 로컬 위험물테이블에 저장된 상태인지 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDgLocalSaveYn(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		String retVal = "";
		try {
			if ("EsmBkg0965Event".equalsIgnoreCase(e.getEventName())) {
				command = new SpecialManifestBCImpl();
				EsmBkg0965Event event = (EsmBkg0965Event) e;
				retVal = command.searchDgLocalSaveYn(event.getDgListCondVO());
				eventResponse.setETCData("retVal", retVal);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;

	}
	
	/**
	 * ESM_BKG_0965 : 
	 * 구주위험물 - 위험물 조회조건 Declaration Type, VVD, PORT을 기준으로 먼저 세관쪽 DG테이블에 등록되어 있는지를 판단한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDgListCopyYn(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		String dgListCopyYn = "";
		try {
			if ("EsmBkg0965Event".equalsIgnoreCase(e.getEventName())) {
				command = new SpecialManifestBCImpl();
				EsmBkg0965Event event = (EsmBkg0965Event) e;
				dgListCopyYn = command.searchDgListCopyYn(event.getDgListCondVO());
				eventResponse.setETCData("dgListCopyYn", dgListCopyYn);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;

	}
	/**
	 * ESM_BKG_0965 : 
	 * 구주위험물 - B/L No.로 BKG의 위험물 테이블에서 데이타를 조회해온다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDgInfoAtBkgDgByBlNo(Event e)
			throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		List<DgListDetailVO> list = null;
		try {
			if ("EsmBkg0965Event".equalsIgnoreCase(e.getEventName())) {
				command = new SpecialManifestBCImpl();
				EsmBkg0965Event event = (EsmBkg0965Event) e;
				list = command.searchDgInfoAtBkgDgByBlNo(event
						.getDgListCondVO());

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
	 * ESM_BKG_0641 : 
	 * Container Discharging List 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCdl(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CLLCDLManifestBC command = null;
		List<CdlDetailVO> list = null;
		try {
			if ("EsmBkg0641Event".equalsIgnoreCase(e.getEventName())) {
				command = new CLLCDLManifestBCImpl();
				EsmBkg0641Event event = (EsmBkg0641Event) e;
				list = command.searchCdl(event.getCdlCondVO());
				eventResponse.setRsVoList(list);
				
				if ( list.size() == 0 )
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
					.getUserMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * ESM_BKG_0904 : 
	 * Terminal 에 EDI 전송할 Export Container List 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrExportInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CLLCDLManifestBC command = null;
		try {
			if ("EsmBkg0904Event".equalsIgnoreCase(e.getEventName())) {
				command = new CLLCDLManifestBCImpl();
				EsmBkg0904Event event = (EsmBkg0904Event) e;
				List<ExCntrTransmitVO> exCntrTransmitVOs = command
						.searchCntrExportInfo(event.getBkgNo(), event.getPolCd());
				eventResponse.setETCData(exCntrTransmitVOs.get(0).getColumnValues());
				eventResponse.setRsVoList(exCntrTransmitVOs);

			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0904 : 
	 * Export Container List 정보를 Terminal 에 EDI 전송하기 위한 Flatfile을 생성한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitCntrExportEdi(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CLLCDLManifestBC command = null;
		Map<String, String> etcData = new HashMap<String, String>();

		try {
			begin();
			if ("EsmBkg0904Event".equalsIgnoreCase(e.getEventName())) {
				command = new CLLCDLManifestBCImpl();
				EsmBkg0904Event event = (EsmBkg0904Event) e;
				// BC에 작업 요청
				String flatFile = command.transmitCntrExportEdi(event
						.getExCntrTransmitCondVO(), event.getRcvId(), account);
				eventResponse.setETCData("flatFile", flatFile);
				eventResponse.setETCData(etcData);
				// 성공메시지 셋팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00204")
						.getUserMessage());

			}
			commit();

		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(),	ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_BKG_0164 : 
	 * 미주 터미널에 보낼 엑셀 형식의 데이터와 비교할 NIS 데이터를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCllCdlCheckForUS(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CLLCDLManifestBC command = new CLLCDLManifestBCImpl();
		try {
			if ("EsmBkg0164Event".equalsIgnoreCase(e.getEventName())) {
				EsmBkg0164Event event = (EsmBkg0164Event) e;

				List<CllCdlCheckUsaVO> cllCdlCheckUsaVOs = command
						.searchCllCdlCheckForUS(event.getCllCdlCheckUsaCondVO());
				eventResponse.setRsVoList(cllCdlCheckUsaVOs);
				// eventResponse.setETCData(etcData);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * ESM_BKG_0582 : 
	 * PSA Port Data를 추가, 삭제, 변경<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse managePSAPortList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSAManifestBC command = null;
		EsmBkg0582Event event = (EsmBkg0582Event) e;
		try {
			begin();
			command = new PSAManifestBCImpl();
			command.managePSAPortList(event.getPsaPortVOs(), account
					.getUsr_id());
			commit();
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
	 * ESM_BKG_0617 : 
	 * CLL, CDL 테이블에 저장되어 있는 데이터와 비교할 NIS 데이터를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCllCdlCheckList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CLLCDLManifestBC command = new CLLCDLManifestBCImpl();
		try {
			if ("EsmBkg0617Event".equalsIgnoreCase(e.getEventName())) {
				EsmBkg0617Event event = (EsmBkg0617Event) e;

				List<CllCdlCheckListDetailVO> cllCdlCheckListDetailVOs = command
						.searchCllCdlCheckList(event.getCllCdlCheckCondVO());
				if (cllCdlCheckListDetailVOs.size() == 0)
					eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
				eventResponse.setRsVoList(cllCdlCheckListDetailVOs);
				eventResponse.setRsVoList(cllCdlCheckListDetailVOs);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * ESM_BKG_0389 : 
	 * PSA TS VVD 목록 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPSATsVVDList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSAManifestBC command = new PSAManifestBCImpl();
		try {
			EsmBkg0389Event event = (EsmBkg0389Event) e;
			String[] vvds = command.searchPSATsVVDList(event.getRlyPort(), event.getEtdDt(), event.getTransTp());

			if (vvds != null) {
				PsaTsVVDListVO psaTsVVDListVO = null;
				List<PsaTsVVDListVO> psaTsVVDListVOs = new ArrayList<PsaTsVVDListVO>();
				for (int i = 0; i < vvds.length; i++) {
					psaTsVVDListVO = new PsaTsVVDListVO();
					psaTsVVDListVO.setVvd(vvds[i]);
					psaTsVVDListVOs.add(psaTsVVDListVO);
				}
				eventResponse.setRsVoList(psaTsVVDListVOs);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0389 : 
	 * Alps vs Portnet Reconciliation 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUnmatchList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSAManifestBC command = new PSAManifestBCImpl();
		// UNMATCH
		PsaImportVO[] psaImportVOs = null;
		List<PsaImportVO> unmatchList = new ArrayList<PsaImportVO>();
		// ALPS
		PsaUnmatchBkgCntrVO[] psaUnmatchBkgCntrVOs = null;
		List<PsaUnmatchBkgCntrVO> alpsList = new ArrayList<PsaUnmatchBkgCntrVO>();
		// PSA
		PsaUnmatchPsaCntrVO[] psaUnmatchPsaCntrVOs = null;
		List<PsaUnmatchPsaCntrVO> psaList = new ArrayList<PsaUnmatchPsaCntrVO>();

		EsmBkg0389Event event = (EsmBkg0389Event) e;

		PsaUnmatchListVO psaUnmatchListVO = null;
		try {
			psaUnmatchListVO = command.searchUnmatchList(event
					.getPsaUnmatchListVO());

			if (psaUnmatchListVO != null) {

				psaImportVOs = psaUnmatchListVO.getPsaImportVOs();
				psaUnmatchBkgCntrVOs = psaUnmatchListVO.getPsaUnmatchBkgCntrVOs();
				psaUnmatchPsaCntrVOs = psaUnmatchListVO.getPsaUnmatchPsaCntrVOs();

				if (psaImportVOs!=null) unmatchList = Arrays.asList(psaImportVOs);
				if (psaUnmatchBkgCntrVOs!=null) alpsList = Arrays.asList(psaUnmatchBkgCntrVOs);
				if (psaUnmatchPsaCntrVOs!=null) psaList = Arrays.asList(psaUnmatchPsaCntrVOs);

				// 결과 담기
				eventResponse.setRsVoList(unmatchList);
				eventResponse.setRsVoList(alpsList);
				eventResponse.setRsVoList(psaList);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}



	/**
	 * 수신 : 
	 * UDEVHJS_APPSBKG_CLL_ACK 연동<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse receiveUdevhjsAlpsBkgCllAck(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CLLCDLManifestBC command = null;
		try {
			if (e.getEventName().equalsIgnoreCase(
					"EsmBkgUdevhjsAlpsBkgCllAckEvent")) {
				begin();
				EsmBkgUdevhjsAlpsBkgCllAckEvent event = (EsmBkgUdevhjsAlpsBkgCllAckEvent) e;
				command = new CLLCDLManifestBCImpl();
				command.receiveUdevhjsAlpsBkgCllAck(event.getFlatFile(),
						account);
				commit();
			}
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
	 * ESM_BKG_0389 : 
	 * Jurong I/F Parsing 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse parseJurongIF(Event e) throws EventException {

		EsmBkg0389Event event = (EsmBkg0389Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSAManifestBC command = new PSAManifestBCImpl();
		PsaJurongIfVO[] psaJurongIfVOs = null;

		try {

			psaJurongIfVOs = command.parseJurongIF(event.getFileKey());

			if (psaJurongIfVOs != null) {
				eventResponse.setRsVoList(Arrays.asList(psaJurongIfVOs));
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0389 : 
	 * Import 된 UnmatchList 저장<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageUnmatchList(Event e) throws EventException {
		EsmBkg0389Event event = (EsmBkg0389Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSAManifestBC command = new PSAManifestBCImpl();

		try {

			begin();

			PsaImportVO condVO = event.getPsaImportVO();
			condVO.setUserId(account.getUsr_id());

			// BC에 작업 요청
			command.manageUnmatchList(condVO);

			// 성공메시지 셋팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00166")
					.getUserMessage());

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
	 * BackEndJob : 
	 * BackEndJob 실행 후 결과코드 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("static-access")
	private EventResponse backEndJobResult(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String sKey = "";
		String command = "";
		
		KorCllCdlDetailContainerVO korCllCdlDetailContainerVO = new KorCllCdlDetailContainerVO();
		if ( e.getEventName().equalsIgnoreCase("EsmBkg0159Event") )
		{
			EsmBkg0159Event event = (EsmBkg0159Event) e;
			sKey = event.getKey();			
			command = event.getCommand();
		} else if ( e.getEventName().equalsIgnoreCase("EsmBkg0723Event") )
		{
				EsmBkg0723Event event = (EsmBkg0723Event) e;
				sKey = event.getKey();		
		} else if ( e.getEventName().equalsIgnoreCase("EsmBkg0420Event") )
		{
			EsmBkg0420Event event = (EsmBkg0420Event) e;
			sKey = event.getKey();		
		}
		String strResult = "";
		String resultMsg = "";
		try
		{
			BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(sKey);
			BackEndJobResult backEndJobResult = new BackEndJobResult();
			DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();
			while(rowSet.next()) 
			{
				if ("2".equals(rowSet.getString("JB_STS_FLG")))
				{
					// BackEndJob 처리중
					strResult = "PROCESSING";
				}
				else if ("3".equals(rowSet.getString("JB_STS_FLG")))
				{
					// 성공메시지세팅
					if (e.getEventName().equalsIgnoreCase("EsmBkg0159Event") )
					{
						if ( command.equals("2") ) 
						{
						
							korCllCdlDetailContainerVO = (KorCllCdlDetailContainerVO)backEndJobResult.loadFromFile(sKey);
							String cntrNo = "";
							int indexI = 0;
							List<KorCllCdlDetailVO> list = korCllCdlDetailContainerVO.getKorCllCdlDetailVOs();
							List<CLLCDLManifestVslSkdInfoVO> cLLCDLManifestVslSkdInfoVOs = korCllCdlDetailContainerVO.getCLLCDLManifestVslSkdInfoVOs();
							for (int j = 0; j < list.size(); j++) {
								KorCllCdlDetailVO korCllCdlDetailVO = list.get(j);
								if ( korCllCdlDetailVO.getCntrTpszCd() != null )
								{
									if (!cntrNo.equals(korCllCdlDetailVO.getCntrNo())) {
										indexI++;
										korCllCdlDetailVO.setSeq(indexI + "");
										cntrNo = korCllCdlDetailVO.getCntrNo();
									} else {
										korCllCdlDetailVO.setSeq(indexI + "");
									}
									list.set(j, korCllCdlDetailVO);
								}
								
							}
							if ( list.size() == 0 )
							{
								eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
							} else {
								eventResponse.setRsVoList(list);
								eventResponse.setRsVoList(korCllCdlDetailContainerVO.getLclKorCllCdlDetailVOs());
								if ( cLLCDLManifestVslSkdInfoVOs.size() > 0 )
								{
									eventResponse.setETCData("vessel_name", cLLCDLManifestVslSkdInfoVOs.get(0).getVvdCd2());
								}
							}
						} else {
							eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
						}
					} else if (e.getEventName().equalsIgnoreCase("EsmBkg0723Event")) {
						korCllCdlDetailContainerVO = (KorCllCdlDetailContainerVO)backEndJobResult.loadFromFile(sKey);
						resultMsg = korCllCdlDetailContainerVO.getReturnMessage();
						eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());
					}else if (e.getEventName().equalsIgnoreCase("EsmBkg0420Event")) {
						eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
					}
					strResult = "SUCCESS";
				}
				else if ("4".equals(rowSet.getString("JB_STS_FLG")))
				{
					// 에러메시지세팅
					if (e.getEventName().equalsIgnoreCase("EsmBkg0159Event"))
					{
						if ( command.equals("2") ) 
						{
							eventResponse.setUserMessage(new ErrorHandler("BKG06086").getUserMessage());
						} else {
							if (!"".equals(rowSet.getString("JB_ERR_MSG"))) {
								StringTokenizer st = new StringTokenizer(rowSet.getString("JB_ERR_MSG"), "<||>");
								st.nextToken();
								st.nextToken();
								st.nextToken();
								String strErrMsg = st.nextToken();
								eventResponse.setUserMessage(strErrMsg);
							} else {
								eventResponse.setUserMessage(new ErrorHandler("BKG00167").getUserMessage());
							}
						}
					} else if (e.getEventName().equalsIgnoreCase("EsmBkg0723Event"))
					{
						if (!"".equals(rowSet.getString("JB_ERR_MSG"))) {
							StringTokenizer st = new StringTokenizer(rowSet.getString("JB_ERR_MSG"), "<||>");
							st.nextToken();
							st.nextToken();
							st.nextToken();
							String strErrMsg = st.nextToken();
							eventResponse.setUserMessage(strErrMsg);
						} else {
							eventResponse.setUserMessage(new ErrorHandler("BKG00205").getUserMessage());
						}
						
					}else if (e.getEventName().equalsIgnoreCase("EsmBkg0420Event"))
					{
						if (!"".equals(rowSet.getString("JB_ERR_MSG"))) {
							StringTokenizer st = new StringTokenizer(rowSet.getString("JB_ERR_MSG"), "<||>");
							st.nextToken();
							st.nextToken();
							st.nextToken();
							String strErrMsg = st.nextToken();
							eventResponse.setUserMessage(strErrMsg);
						} else {
							eventResponse.setUserMessage(new ErrorHandler("BKG06087").getUserMessage());
						}
					}
					strResult = "FAIL";
				}
			}
			eventResponse.setETCData("jb_sts_flg", strResult);
			eventResponse.setETCData("resultMsg", resultMsg);
		} catch (Exception ex)
		{
			rollback();
			if ( command.equals("2") ) 
			{
				throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
			} else {
				throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
			}
		}
		return eventResponse;
	}	

	/**
	 * ESM_BKG_0965 :
	 * ESM_BKG_0967 :
	 * Feeder Name, Lloyd No를 조회한다.<Br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDgFeederNameList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		List<FeederNameVO> list = null;
		try {
			if ("EsmBkg0967Event".equalsIgnoreCase(e.getEventName())) {
				command = new SpecialManifestBCImpl();
				list = command.searchDgFeederNameList();
				eventResponse.setRsVoList(list);
			} else if ("EsmBkg0965Event".equalsIgnoreCase(e.getEventName())) {
				
				StringBuffer feederName = null;
				StringBuffer feederLloydNo = null;
				StringBuffer displayTextOffeederNameLloyNo = null;
				
				command = new SpecialManifestBCImpl();
				list = command.searchDgFeederNameList();
				
				if(list != null) {
					int listMaxSize = list.size(); 
					if(listMaxSize > 0) {
						feederName = new StringBuffer();
						feederLloydNo = new StringBuffer();
						displayTextOffeederNameLloyNo = new StringBuffer();
						feederName.append(" ");
						feederLloydNo.append(" ");
						displayTextOffeederNameLloyNo.append(" ").append("\t").append(" ");
						for(int i=0; i < listMaxSize; i++) {
							feederName.append("|").append(list.get(i).getFeederName());
							feederLloydNo.append("|").append(list.get(i).getFeederLloydNo());
							displayTextOffeederNameLloyNo.append("|")
														 .append(list.get(i).getFeederName())
														 .append("\t")
														 .append(list.get(i).getFeederLloydNo());
						} // end for(i)
						// Feeder Name, Lloyd No Combo List
						eventResponse.setETCData("feederName", feederName.toString());
						// Feeder Name, Lloyd No Combo List
						eventResponse.setETCData("feederLloydNo", feederLloydNo.toString());
						// Feeder Name, Lloyd No Combo List
						eventResponse.setETCData("displayTextOffeederNameLloyNo", displayTextOffeederNameLloyNo.toString());
					}
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
	 * ESM_BKG_0965 : 
	 * ESM_BKG_0966 :
     * 위험물 대상을 조회해한(세관 쪽에 등록이 안된 booking쪽 데이타만 조회한다.<Br>
     * booking쪽 데이타를 추가 하가위해<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAppendDgInfoAtBkgDg(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		List<DgListDetailVO> list = null;
		try {
			if ("EsmBkg0965Event".equalsIgnoreCase(e.getEventName())) {
				command = new SpecialManifestBCImpl();
				EsmBkg0965Event event = (EsmBkg0965Event) e;
				list = command.searchAppendDgInfoAtBkgDg(event.getDgListCondVO());

				if(list.size() > 0) {
					eventResponse.setRsVoList(list);
				} else {
//					eventResponse.setUserMessage("No data is available to add");
					eventResponse.setUserMessage(new ErrorHandler("BKG95017", new String[] {"append from BKG data"}).getUserMessage());
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
	 * ESM_BKG_1097 : SEARCH
	 * 포워더 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFeederInfoList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		List<FeederInfoVO> list = null;
		try {
			if ("EsmBkg1097Event".equalsIgnoreCase(e.getEventName())) {

				command = new SpecialManifestBCImpl();

				EsmBkg1097Event event = (EsmBkg1097Event) e;

				list = command.searchFeederInfoList(event.getFeederInfoVO());

				eventResponse.setRsVoList(list);

			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;

	}
	
	/**
	 * ESM_BKG_1097 : MULTI
	 * feeder정보를 추가,수정,삭제 한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageFeederInfoList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;

		try {
			this.begin();
			if ("EsmBkg1097Event".equalsIgnoreCase(e.getEventName())) {

				command = new SpecialManifestBCImpl();

				EsmBkg1097Event event = (EsmBkg1097Event) e;

				command.manageFeederInfoList(event.getFeederInfoVOs(), account);

			}
			this.commit();
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
	 * ESM_BKG_0573 :
	 * 송신 내역을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPsaSendHistory(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSASpecialManifestBC command = null;
		try {
			if ("EsmBkg0573Event".equalsIgnoreCase(e.getEventName())) {
				command = new PSASpecialManifestBCImpl();
				EsmBkg0573Event event = (EsmBkg0573Event) e;
				List<PSASendHistoryDetailVO> list = command
						.searchPsaSendHistory(event.getPsaSendHistoryCondVO());
				eventResponse.setRsVoList(list);
			}
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}
	/**
	 * ESM_BKG_0577 :
	 * 위험물 신고 대상 컨테이너를 조회 해 온다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPsaDgManifestList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSASpecialManifestBC command = null;
		List<PSADgListDetailVO> list = null;
		PSASpecialContainerVO containerVO = null;

		PSADgListDetailVO vslInfo = null;
		List<PSADgListDetailVO> detailList = null;
		
		try {
			if ("EsmBkg0577Event".equalsIgnoreCase(e.getEventName())) {

				command = new PSASpecialManifestBCImpl();

				EsmBkg0577Event event = (EsmBkg0577Event) e;

				PSADgListCondVO psaDgListCondVO = event.getPsaDgListCondVO();
				psaDgListCondVO.setOfcCd(account.getOfc_cd());

				list = command.searchPsaDgManifestList(psaDgListCondVO);

				if (list != null && list.size() > 0) {
					containerVO = (PSASpecialContainerVO) list.get(0);

					vslInfo = containerVO.getPsaVslInfo();
					detailList = containerVO.getPsaDetailList();

					// 로컬 저장유무(세관 테이블에 저장 유무)
//					eventResponse.setETCData("dgListLocalYn", containerVO.getDgListLocalYn());
					// edi전송 status
//					eventResponse.setETCData("ediSentStatus", containerVO.getEdiSentStatus());

//					if (vslInfo != null) {
//
//						vslInfo.setAutoSndTpCd(containerVO.getAutoSentFlag());
//						vslInfo.setAckRcvStsCd(containerVO.getEdiSentStatus());
//
//					}

					// 상당 배정보
					eventResponse.setRsVo(vslInfo);
					// 하단 그리드 정보
					eventResponse.setRsVoList(detailList);

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
	 * ESM_BKG_0577 :
	 * 위험물 Flat File 생성 및 EDI 전송<br>
	 * ManifestListDownload의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse psaSendDgManifestList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSASpecialManifestBC command = null;
		List<String> flatFileList = null;
		try {
			begin();
			if ("EsmBkg0577Event".equalsIgnoreCase(e.getEventName())) {
				command = new PSASpecialManifestBCImpl();
				EsmBkg0577Event event = (EsmBkg0577Event) e;
				flatFileList = command.sendPsaDgManifestList(event.getPsaDgEdiVOs(),
						account);

				if (flatFileList != null) {
					eventResponse.setETCData("originalFlatFile", flatFileList
							.get(0));
					eventResponse.setETCData("updateFlatFile", flatFileList
							.get(1));
					eventResponse.setETCData("cancelFlatFile", flatFileList
							.get(2));
				} else {
					eventResponse.setETCData("originalFlatFile", "");
					eventResponse.setETCData("updateFlatFile", "");
					eventResponse.setETCData("cancelFlatFile", "");
				}

				// 성공 메시지 셋팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00218").getUserMessage());
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
	 * ESM_BKG_1136 :
	 * EDI 로 전송된 CLL 상의 Booking 데이터와 B/L Data Input Cross-Check 상의 Booking 데이터를 대조하여 Un-match된 항목을 보여준다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchKorCllCrossCheck(Event e) throws EventException {		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CLLCDLManifestBC command = null;
		try {
			if ("EsmBkg1136Event".equalsIgnoreCase(e.getEventName())) {				
				command = new CLLCDLManifestBCImpl();
				EsmBkg1136Event event = (EsmBkg1136Event) e;
				List<KorCllCrossChkCondVO> list = command.searchKorCllCrossCheck(event.getKorCllCrossChkCondVO());				
				eventResponse.setRsVoList(list);							
			}
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),ex);
		}
		return eventResponse;
	}		
	/**
	 * ESM_BKG_0578 :
	 * 수신 내역을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPsaReceiveHistory(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSASpecialManifestBC command = null;
		try {
			if ("EsmBkg0578Event".equalsIgnoreCase(e.getEventName())) {
				command = new PSASpecialManifestBCImpl();
				EsmBkg0578Event event = (EsmBkg0578Event) e;
				List<PSASendHistoryDetailVO> list = command
						.searchPsaReceiveHistory(event.getPsaSendHistoryCondVO());
				eventResponse.setRsVoList(list);
			}
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_1153 : SEARCH <br>
	 *  VVD 정보 조회<br>
	 * 
	 * @param Event event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchPreAdviceVvdInfo(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CLLCDLManifestBC command = null;
		try{
						
				EsmBkg1153Event event =(EsmBkg1153Event) e;
				command = new CLLCDLManifestBCImpl();
				List<PreAdviceVvdInfoVO> list = command.searchPreAdviceVvdInfo(event.getPreAdviceVO());
				eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1153 : SEARCH01 <br>
	 *  VVD 정보 조회<br>
	 * 
	 * @param Event event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchPreAdviceManifestList(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CLLCDLManifestBC command = null;
		try{
						
				EsmBkg1153Event event =(EsmBkg1153Event) e;
				command = new CLLCDLManifestBCImpl();
				List<PreAdviceManifestListVO> list = command.searchPreAdviceManifestList(event.getPreAdviceVO());
				eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}
}