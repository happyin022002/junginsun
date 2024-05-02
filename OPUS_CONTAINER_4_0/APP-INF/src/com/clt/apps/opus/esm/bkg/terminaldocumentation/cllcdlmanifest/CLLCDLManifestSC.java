/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CLLCDLManifestSC.java
 *@FileTitle : CLLCDLManifestSC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.11
 *@LastModifier :
 *@LastVersion : 1.0
 * 2009.04.21
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.basic.CLLCDLManifestBC;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.basic.CLLCDLManifestBCImpl;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0155Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0159Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0161Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0164Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0617Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0641Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0723Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0904Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0915Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0916Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0930Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0931Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0932Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0933Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0951Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg1056Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg1136Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg1153Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkgUdevNykOpusBkgCllAckEvent;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestCllCdlForODCYVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestEdiTerminalInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestKorCllRemarkInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestLoadSumByPodDetailVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestSpclCgoSumByPodDetailVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestVslSkdInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CdlDetailVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllCdlCheckListDetailVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllCdlCheckUsaVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllDetailVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllDgCgoDetailVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllRfAkCgoDetailVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.ExCntrTransmitVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCdlDetailContainerVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCdlDetailVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCrossChkCondVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllDetailVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllLoadSumDetailVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllSpclCgoContainerVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllSpclCgoSumDetailVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllSppDetailVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllSumDetailVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.PreAdviceManifestListVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.PreAdviceVvdInfoVO;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.backend.support.BackEndJobResult;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmCntrTpSzVO;
/**
 * OPUS-TerminalDocumentation Business Logic ServiceCommand -f
 * OPUS-TerminalDocumentation 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author Kyoung Jong Yung
 * @see SpecialManifest
 * @since J2EE 1.4
 */

public class CLLCDLManifestSC extends ServiceCommandSupport {
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
		log.debug("CLLCDLManifestSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * OPUS-CustomsDeclaration system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		 if (e.getEventName().equalsIgnoreCase("EsmBkg0155Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCll(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCll(e);
			}
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
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchPrdBlckStwgListAsString(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0161Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchSortCombo(e);
//				GeneralEventResponse response = new GeneralEventResponse();
//				response.setRsVoList(searchComCodeCombo("CD02298"));
//				response.setRsVoList(searchComCodeCombo3("CD02196"));
//				response.setRsVoList(searchComCodeCombo3("CD02347"));
//				response.setRsVoList(searchComCodeCombo("CD02377"));
//				eventResponse = response;
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0164Event")) {

			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCllCdlCheckForUS(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0617Event")) {

			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCllCdlCheckList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0641Event")) {

			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCdl(e);
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

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0931Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchKorCll(e);
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
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0933Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchKorCllSpecialCgo(e);
			}

//		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0951Event")) {
//			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
//				eventResponse = searchKorCllSummary(e);
//			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1056Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchKorCllSppList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageKorCllSppList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1136Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchKorCllCrossCheck(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1153Event")){
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchPreAdviceVvdInfo(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = searchPreAdviceManifestList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkgUdevNykOpusBkgCllAckEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = receiveUdevNykOpusBkgCllAck(e);
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
	private List<BkgComboVO> searchComCodeCombo(String comCode) throws EventException {

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
	private List<BkgComboVO> searchComCodeCombo3(String comCode) throws EventException {

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
	private List<BkgComboVO> searchComCodeCombo2(String comCode) throws EventException {

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
	private EventResponse searchCllCdlCheckForUS(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CLLCDLManifestBC command = new CLLCDLManifestBCImpl();
		List<CllCdlCheckUsaVO> orgList = new ArrayList<CllCdlCheckUsaVO>();
		try {
			if ("EsmBkg0164Event".equalsIgnoreCase(e.getEventName())) {
				EsmBkg0164Event event = (EsmBkg0164Event) e;

				List<CllCdlCheckUsaVO> cllCdlCheckUsaVOs = command
						.searchCllCdlCheckForUS(event.getCllCdlCheckUsaCondVO());

				for(CllCdlCheckUsaVO vo:cllCdlCheckUsaVOs){
					if("A".equals(vo.getKind())){
						orgList.add(vo);
					}
				}
				eventResponse.setRsVoList(cllCdlCheckUsaVOs);
				eventResponse.setRsVoList(orgList);
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
	 * 미주 터미널에 보낼 엑셀 형식의 데이터와 비교할 OPUS 데이터를 조회한다.<br>
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
				flatFile = command.transmitKorCll(event.getKorCllCondVO(),event.getKorCllModifyVOS(), account);
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
	private EventResponse searchKorCllSummary(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CLLCDLManifestBC command = new CLLCDLManifestBCImpl();
		List<KorCllSumDetailVO> list = null;
		try {
			if ("EsmBkg0932Event".equalsIgnoreCase(e.getEventName())) {
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

//						List<KorCllSpclStowRqstDetailVO> korCllSpclStowRqstDetailVOs = korCllSumDetailVO
//								.getKorCllSpclStowRqstDetailVOs();
//						eventResponse.setRsVoList(korCllSpclStowRqstDetailVOs);
//						List<KorCllSpclStowRqstDetail2VO> korCllSpclStowRqstDetail2VOs = korCllSumDetailVO
//								.getKorCllSpclStowRqstDetail2VOs();
//						eventResponse.setRsVoList(korCllSpclStowRqstDetail2VOs);
//						List<KorCllSpclStowRqstDetail3VO> korCllSpclStowRqstDetail3VOs = korCllSumDetailVO
//								.getKorCllSpclStowRqstDetail3VOs();
//						eventResponse.setRsVoList(korCllSpclStowRqstDetail3VOs);

						List<CLLCDLManifestKorCllRemarkInfoVO> cLLCDLManifestKorCllRemarkInfoVOs = korCllSumDetailVO
								.getCLLCDLManifestKorCllRemarkInfoVOs();

						eventResponse.setETCData("vvd_cd_nm",
								cLLCDLManifestVslSkdInfoVO.getVvdCd3());
						eventResponse.setETCData("cssm_vvd",
								cLLCDLManifestVslSkdInfoVO.getCssmVvd());
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
						eventResponse.setETCData("cssm_vvd", "");
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
					eventResponse.setETCData("cssm_vvd", "");
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
	private EventResponse searchPreAdviceVvdInfo(Event e) throws EventException {
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
	private EventResponse receiveUdevNykOpusBkgCllAck(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CLLCDLManifestBC command = null;
		try {
			if (e.getEventName().equalsIgnoreCase(
					"EsmBkgUdevNykOpusBkgCllAckEvent")) {
				begin();
				EsmBkgUdevNykOpusBkgCllAckEvent event = (EsmBkgUdevNykOpusBkgCllAckEvent) e;
				command = new CLLCDLManifestBCImpl();
				command.receiveUdevNykOpusBkgCllAck(event.getFlatFile(),
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
	 * ESM_BKG_1153 : SEARCH01 <br>
	 *  VVD 정보 조회<br>
	 *
	 * @param Event event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPreAdviceManifestList(Event e) throws EventException {
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

	/**
	 * ESM_BKG_0161 :
	 * Retrieving Sort Code<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSortCombo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg0161Event event =(EsmBkg0161Event) e;
			String code = event.getCode();
			if(code==null||"".equals(code)){
				return eventResponse;
			}
			if("CD02298".equals(code) || "CD02377".equals(code)){
				eventResponse.setRsVoList(searchComCodeCombo(code));
			}else{
				eventResponse.setRsVoList(searchComCodeCombo3(code));
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
	 * PRD에 등록되어 있는 Blck Stwg를 조회한다.<Br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPrdBlckStwgListAsString(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CLLCDLManifestBC command = new CLLCDLManifestBCImpl();
		try {
			String blckStwg = command.searchPrdBlckStwgListAsString();
			eventResponse.setETCData("blck_stwg", blckStwg);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;

	}
}