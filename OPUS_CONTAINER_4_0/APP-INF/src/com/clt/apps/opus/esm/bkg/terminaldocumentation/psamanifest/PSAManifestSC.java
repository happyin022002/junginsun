/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : PSAManifestSC.java
 *@FileTitle : PSAManifestSC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.01
 *@LastModifier :
 *@LastVersion : 1.0
 * 2014.12.01
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.basic.PSAManifestBC;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.basic.PSAManifestBCImpl;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.event.EsmBkg0389Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.event.EsmBkg0420Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.event.EsmBkg0575Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.event.EsmBkg0576Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.event.EsmBkg0582Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.event.EsmBkg0979Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.event.EsmBkg1012Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.event.EsmBkg1013Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.event.EsmBkg1028Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.event.EsmBkg1519Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.ImpStsSpclCgoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaImpStsVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaImportVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaJurongIfVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaPortVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaTsVVDListVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaUnmatchBkgCntrVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaUnmatchListVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaUnmatchPsaCntrVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaVvdVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-PSAManifestSC Business Logic ServiceCommand -f
 * OPUS-PSAManifestSC 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author
 * @see
 * @since J2EE 1.6
 */
public class PSAManifestSC extends ServiceCommandSupport {
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
		log.debug("PSAManifestSC 종료");
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
		if (e.getEventName().equalsIgnoreCase("EsmBkg0389Event")) {
			// OPUS vs Portnet Reconciliation
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

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0420Event")) {
			// PSA Import Status I/F
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				// Sheet Combo initialization
				eventResponse = searchStowageCode4SheetCombo();
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPSAImpSts(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {    // Get status of Back End Job(공통으로 호출)
				eventResponse = getBackEndJobStatus(e.getAttribute("backEndJob_Key").toString());
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {     // Start Back End Job(SAVE)
				eventResponse = startBackEndJobManagePSAImpSts(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {     // Result return(SAVE)
				eventResponse = resultBackEndJobManagePSAImpSts(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {   // Start Back End Job(TRANSMIT)
				eventResponse = startBackEndJobTransmitPSAImpSts(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {   // Result return(TRANSMIT)
				eventResponse = resultBackEndJobTransmitPSAImpSts(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0575Event")) {
			// PSA Vessel Regist 조회
			if (e.getFormCommand().isCommand(FormCommand.SEARCH) || e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchPSAVslRegist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				// SAVE 처리
				eventResponse = managePSAVVDInfo(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0576Event")) {
			// PSA Container Booking I/F History
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPSACNTRBKGHist(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0582Event")) {
			// PSA Port Register
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPSAPortList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePSAPortList(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0979Event")) {
			// PSA Container Booking I/F History Log Pop Up
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPSAStatusLog(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1012Event")) {
			// PSA Special Cargo Info
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				// Multi Combo initialization
				eventResponse = searchStowageCode4MultiCombo();
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				// 조회
				eventResponse = searchPSAImpoStsSpclCgo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				// 추가,수정,삭제
				eventResponse = managePSAImpStsSpclCgo(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1028Event") || e.getEventName().equalsIgnoreCase("EsmBkg1013Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				// PSA Vessel Regist Import Schedule 조회
				eventResponse = searchPSAVVD(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1519Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPSAIbManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {    // (TRANSMIT) Start Back End Job
				eventResponse = startBackEndJobTransmitByVvd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {    // (TRANSMIT) Get status of Back End Job
				eventResponse = getBackEndJobStatus(e.getAttribute("backEndJob_Key").toString());
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {    // (TRANSMIT) Result return
				eventResponse = resultBackEndJobTransmitByVvd(e);
			}
		}
		return eventResponse;
	}

	/**
	 * Back End Job 공통<br>
	 *  - Back End Job Status 조회
	 *(동일 BCImpl에 Back End Job이 여러개일때 공통으로 사용)
	 *
	 * @param String backEndJobKey
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getBackEndJobStatus(String backEndJobKey) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSAManifestBC command = new PSAManifestBCImpl();

		try {
			String jbStsFlg = command.getBackEndJobStatus(backEndJobKey);
			eventResponse.setETCData("jb_sts_flg", jbStsFlg);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0389 :
	 * Opus vs Portnet Reconciliation 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUnmatchList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSAManifestBC command = new PSAManifestBCImpl();
		PsaImportVO[] psaImportVOs = null;
		List<PsaImportVO> unmatchList = new ArrayList<PsaImportVO>();
		PsaUnmatchBkgCntrVO[] psaUnmatchBkgCntrVOs = null;
		List<PsaUnmatchBkgCntrVO> opusList = new ArrayList<PsaUnmatchBkgCntrVO>();
		PsaUnmatchPsaCntrVO[] psaUnmatchPsaCntrVOs = null;
		List<PsaUnmatchPsaCntrVO> psaList = new ArrayList<PsaUnmatchPsaCntrVO>();
		EsmBkg0389Event event = (EsmBkg0389Event) e;

		try {
			PsaUnmatchListVO psaUnmatchListVO = command.searchUnmatchList(event.getPsaUnmatchListVO());
			if (psaUnmatchListVO != null) {
				psaImportVOs = psaUnmatchListVO.getPsaImportVOs();
				psaUnmatchBkgCntrVOs = psaUnmatchListVO.getPsaUnmatchBkgCntrVOs();
				psaUnmatchPsaCntrVOs = psaUnmatchListVO.getPsaUnmatchPsaCntrVOs();

				if (psaImportVOs!=null) unmatchList = Arrays.asList(psaImportVOs);
				if (psaUnmatchBkgCntrVOs!=null) opusList = Arrays.asList(psaUnmatchBkgCntrVOs);
				if (psaUnmatchPsaCntrVOs!=null) psaList = Arrays.asList(psaUnmatchPsaCntrVOs);

				eventResponse.setRsVoList(unmatchList);
				eventResponse.setRsVoList(opusList);
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
	 * UDEVNYK_APPSBKG_CLL_ACK 연동<br>
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
				for (int i=0; i < vvds.length; i++) {
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
	 * Opus vs Portnet Reconciliation 조회<br>
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
			command.manageUnmatchList(condVO);
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
	 * ESM_BKG_0420 : open <br>
	 * Stowage Combo initialization - Sheet Combo<br>
	 *
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStowageCode4SheetCombo() throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<BkgComboVO> bkgComboVOList = new BookingUtil().searchCombo("CD02146");
			StringBuilder comboCode = new StringBuilder();
			StringBuilder comboText = new StringBuilder();
			for (BkgComboVO bkgComboVO : bkgComboVOList) {
				comboCode.append("|").append(bkgComboVO.getVal());
				comboText.append("|").append(bkgComboVO.getVal()).append("\t").append(bkgComboVO.getName());
			}
			eventResponse.setETCData("combo_code", comboCode.toString());
			eventResponse.setETCData("combo_text", comboText.toString());
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0420 : Retrive
	 * Import Status I/F 목록 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPSAImpSts(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSAManifestBC command = new PSAManifestBCImpl();
		EsmBkg0420Event event = (EsmBkg0420Event) e;
		String psaVslNm = "";
		String psaVoyDirCd = "";

		try {
			PsaImpStsVO psaImpStsVO = command.searchPSAImpSts(event.getPsaImpStsVO());
			if (psaImpStsVO != null) {
				if (psaImpStsVO.getPsaVvdVO() != null) {
					if (psaImpStsVO.getPsaVvdVO().getPsaVslNm() != null)
						psaVslNm = psaImpStsVO.getPsaVvdVO().getPsaVslNm();
					if (psaImpStsVO.getPsaVvdVO().getPsaVoyDirCd() != null)
						psaVoyDirCd = psaImpStsVO.getPsaVvdVO().getPsaVoyDirCd();
				}
				eventResponse.setETCData("vsl_nm", psaVslNm);
				eventResponse.setETCData("vsl_voyage", psaVoyDirCd);
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
	 * ESM_BKG_0420 : Save - Back End Job 시작<br>
	 * PSA Import Status I/F 추가/수정/삭제 처리
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse startBackEndJobManagePSAImpSts(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSAManifestBC command = new PSAManifestBCImpl();
		EsmBkg0420Event event = (EsmBkg0420Event) e;

		try {
			PsaImpStsVO[] psaImpStsVOs = event.getPsaImpStsVOs();
			String vslCd = event.getVslCd();
			String skdVoyNo = event.getSkdVoyNo();
			String skdDirCd = event.getSkdDirCd();

			for (PsaImpStsVO psaImpStsVO : psaImpStsVOs) {
				psaImpStsVO.setUserId(account.getUsr_id());
				psaImpStsVO.setVslCd(vslCd);
				psaImpStsVO.setSkdVoyNo(skdVoyNo);
				psaImpStsVO.setSkdDirCd(skdDirCd);
			}

			begin();
			String backEndJobKey = command.startBackEndJobManagePSAImpSts(psaImpStsVOs, account, "ESM_BKG_0420-Save");
			eventResponse.setETCData("backEndJob_Key", backEndJobKey);
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
	 * ESM_BKG_0420 : Save - Back End Job 결과<br>
	 * PSA Import Status I/F 추가/수정/삭제 처리
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse resultBackEndJobManagePSAImpSts(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSAManifestBC command = new PSAManifestBCImpl();
		EsmBkg0420Event event = (EsmBkg0420Event) e;

		try {
			begin();
			command.resultBackEndJobManagePSAImpSts(event.getAttribute("backEndJob_Key").toString());
			commit();
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0420 : Transmit - Back End Job 시작<br>
	 * PSA Import Status I/F 의 Transmit
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse startBackEndJobTransmitPSAImpSts(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSAManifestBC command = new PSAManifestBCImpl();
		EsmBkg0420Event event = (EsmBkg0420Event) e;

		try {
			begin();
			String backEndJobKey = command.startBackEndJobTransmitPSAImpSts(event.getPsaImpStsVO(), account, "ESM_BKG_0420-Transmit");
			eventResponse.setETCData("backEndJob_Key", backEndJobKey);
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
	 * ESM_BKG_0420 : Transmit - Back End Job 결과<br>
	 * PSA Import Status I/F 의 Transmit
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse resultBackEndJobTransmitPSAImpSts(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSAManifestBC command = new PSAManifestBCImpl();
		EsmBkg0420Event event = (EsmBkg0420Event) e;

		try {
			begin();
			command.resultBackEndJobTransmitPSAImpSts(event.getAttribute("backEndJob_Key").toString());
			commit();
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0575 :
	 * Feeder Name, Lloyd No를 조회<Br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPSAVslRegist(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSAManifestBC command = new PSAManifestBCImpl();
		EsmBkg0575Event event = (EsmBkg0575Event) e;

		try {
			if (event.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse.setRsVoList(command.searchPSAVslRegist(event.getPsaVvdVO()));

			} else if (event.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				String psaVslNm = command.searchPSAVslName(event.getPsaVvdVO());
				if (psaVslNm != null) eventResponse.setETCData("psa_vsl_nm", psaVslNm);
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
		PSAManifestBC command = new PSAManifestBCImpl();
		EsmBkg0575Event event = (EsmBkg0575Event) e;

		try {
			begin();
			PsaVvdVO[] psaVvdVOs = event.getPsaVvdVOs();
			for (int i=0; i<psaVvdVOs.length; i++) psaVvdVOs[i].setUserId(account.getUsr_id());
			command.managePSAVVDInfo(psaVvdVOs);
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
	 * ESM_BKG_1028 :
	 * ESM_BKG_1013 :
	 * PSA Vessel Import Schedule 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPSACNTRBKGHist(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSAManifestBC command = new PSAManifestBCImpl();
		EsmBkg0576Event event = (EsmBkg0576Event) e;

		try {
			PsaBkgVO[] psaBkgVOs = command.searchPSACNTRBKGHist(event.getPsaBkgVO());
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
	private EventResponse searchPSAPortList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSAManifestBC command = new PSAManifestBCImpl();
		EsmBkg0582Event event = (EsmBkg0582Event) e;

		try {
			PsaPortVO[] psaPortVOs = command.searchPSAPortList(event.getPortCd());
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
	private EventResponse managePSAPortList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSAManifestBC command = new PSAManifestBCImpl();
		EsmBkg0582Event event = (EsmBkg0582Event) e;

		try {
			begin();
			command.managePSAPortList(event.getPsaPortVOs(), account.getUsr_id());
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
	 * CLL, CDL 테이블에 저장되어 있는 데이터와 비교할 OPUS 데이터를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPSAStatusLog(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSAManifestBC command = new PSAManifestBCImpl();
		EsmBkg0979Event event = (EsmBkg0979Event) e;

		try {
			String statusLog = command.searchPSAStatusLog(event.getBkgNo(), event.getBkgSeq());
			eventResponse.setETCData("status_log", statusLog);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1012 : open <br>
	 * Stowage Combo initialization - MUlti Combo<br>
	 *
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStowageCode4MultiCombo() throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			eventResponse.setRsVoList(new BookingUtil().searchCombo("CD02146"));
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1012 :
	 * PSA Port List 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPSAImpoStsSpclCgo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSAManifestBC command = new PSAManifestBCImpl();

		try {
			EsmBkg1012Event event = (EsmBkg1012Event) e;
			ImpStsSpclCgoVO impStsSpclCgoVO = command.searchPSAImpoStsSpclCgo(event.getImpStsSpclCgoVO());
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
	private EventResponse managePSAImpStsSpclCgo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSAManifestBC command = new PSAManifestBCImpl();
		EsmBkg1012Event event = (EsmBkg1012Event) e;

		try {
			begin();
			ImpStsSpclCgoVO impStsSpclCgoVO = event.getImpStsSpclCgoVO();
			impStsSpclCgoVO.setUserId(account.getUsr_id());
			command.managePSAImpStsSpclCgo(impStsSpclCgoVO);
			if (impStsSpclCgoVO.getTypeCd().equals("D")) {
				eventResponse.setUserMessage(new ErrorHandler("BKG00593").getUserMessage());
			} else {
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
	 * ESM_BKG_0420 :
	 * PSA Import Status EDI 전송 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPSAVVD(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSAManifestBC command = new PSAManifestBCImpl();

		try {
			if ("EsmBkg1028Event".equalsIgnoreCase(e.getEventName())) {
				EsmBkg1028Event event = (EsmBkg1028Event) e;
				eventResponse.setRsVoList(command.searchPSAVVD(event.getPortCd(), event.getEtbDt1(), event.getEtbDt2()));

			} else if ("EsmBkg1013Event".equalsIgnoreCase(e.getEventName())) {
				EsmBkg1013Event event = (EsmBkg1013Event) e;
				eventResponse.setRsVoList(command.searchPSAVVD(event.getPortCd(), event.getEtbDt1(), event.getEtbDt2()));
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1519 : Retrive<br>
	 * PSA Inbound Manifest 목록 조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPSAIbManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSAManifestBC command = new PSAManifestBCImpl();
		EsmBkg1519Event event = (EsmBkg1519Event) e;
		String psaVslNm = "";
		String psaVoyDirCd = "";

		try {
			PsaVvdVO psaVvdVO = command.searchPSAVslNameDir(event.getVvd());
			if (psaVvdVO != null) {
				if (psaVvdVO.getPsaVslNm() != null) psaVslNm = psaVvdVO.getPsaVslNm();
				if (psaVvdVO.getPsaVoyDirCd() != null) psaVoyDirCd = psaVvdVO.getPsaVoyDirCd();
			}
			eventResponse.setETCData("vsl_nm", psaVslNm);
			eventResponse.setETCData("vsl_voyage", psaVoyDirCd);

			eventResponse.setRsVoList(command.searchPSAIbManifest(event.getVvd()));

		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1519 : Transmit - Back End Job 시작<br>
	 * PSA Inbound Manifest EDI 전송
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse startBackEndJobTransmitByVvd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSAManifestBC command = new PSAManifestBCImpl();
		EsmBkg1519Event event = (EsmBkg1519Event) e;

		try {
			begin();
			String backEndJobKey = command.startBackEndJobTransmitByVvd(event.getVvd(), event.getPsaIbManifestVOs(), account, "ESM_BKG_1519-Transmit");
			eventResponse.setETCData("backEndJob_Key", backEndJobKey);
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
	 * ESM_BKG_1519 : Transmit - Back End Job 결과<br>
	 * PSA Inbound Manifest EDI 전송
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse resultBackEndJobTransmitByVvd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PSAManifestBC command = new PSAManifestBCImpl();
		EsmBkg1519Event event = (EsmBkg1519Event) e;

		try {
			begin();
			command.resultBackEndJobTransmitByVvd(event.getAttribute("backEndJob_Key").toString());
			commit();
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}


}

